package c.t.maploc.lite.tsa;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

final class f extends Handler {
  private int a = 0;
  
  private long b = 0L;
  
  private boolean c = false;
  
  f(c paramc, Looper paramLooper) {
    super(paramLooper);
  }
  
  private void a(int paramInt) {
    Location location = c.l(this.d).c();
    if (location != n.a && c.g(this.d) == 0L) {
      r r = new r();
      r.c = "network";
      q q = r.a(location).a();
      q.a(location);
      if (!c.j(this.d)) {
        c.a(this.d, 0, q);
        return;
      } 
    } else if (c.d(this.d) != 0 || c.m(this.d) == null || System.currentTimeMillis() - c.m(this.d).getTime() >= 60000L) {
      c.a(this.d, paramInt, q.a);
    } 
  }
  
  private static boolean a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        if (paramString.contains("latitude"))
          return true; 
        JSONArray jSONArray = jSONObject.optJSONArray("cells");
        if (jSONArray != null && jSONArray.length() > 0)
          return true; 
        jSONArray = jSONObject.optJSONArray("wifis");
        if (jSONArray != null && jSONArray.length() > 0)
          return true; 
      } finally {} 
    return false;
  }
  
  public final void handleMessage(Message paramMessage) {
    Pair pair;
    o o1;
    String str1;
    q q;
    r r;
    int i = paramMessage.what;
    boolean bool = false;
    switch (i) {
      default:
        return;
      case 2005:
        c.k(this.d);
        sendEmptyMessage(2002);
        return;
      case 2004:
        a(1);
        c.a(this.d, -1L);
        return;
      case 2003:
        removeMessages(2004);
        pair = (Pair)paramMessage.obj;
        str2 = pair.first.toString();
        o1 = (o)((i)pair.second).b;
        c.a(this.d, o1.b);
        if (o1.a()) {
          str1 = "gps";
        } else {
          str1 = "network";
        } 
        r = new r();
        r.b = str2;
        r.c = str1;
        q = r.a();
        if (q == q.a) {
          a(404);
          return;
        } 
        if (!c.j(this.d) || q.a()) {
          if (!q.a())
            q.a(q); 
          c.a(this.d, 0, q);
        } 
        c.a(this.d, System.currentTimeMillis());
        c.a(this.d, q);
        return;
      case 2001:
        if (!c.c(this.d) && c.d(this.d) != 2) {
          if (c.e(this.d) != null)
            c.e(this.d).c(); 
          long l1 = Math.max(c.f(this.d), 4000L);
          if (System.currentTimeMillis() - c.g(this.d) >= l1)
            break; 
          return;
        } 
        break;
      case 2002:
        break;
    } 
    removeMessages(2002);
    o o2 = c.h(this.d);
    if (o2 == null) {
      a(2);
      return;
    } 
    long l = System.currentTimeMillis();
    if (o2.a() && l - this.b > 60000L) {
      this.c = true;
      this.b = l;
    } else {
      this.c = false;
    } 
    String str2 = o2.a(c.a(this.d), this.c);
    if ((a(str2) ^ true) != 0) {
      this.a++;
      if (this.a >= 2) {
        a(2);
        this.a = 0;
        return;
      } 
    } else {
      this.a = 0;
      h h = c.i(this.d);
      try {
        String str;
        byte[] arrayOfByte = h.a(str2.getBytes("GBK"));
        if (ak.a(arrayOfByte) == null) {
          str = h.a(0);
        } else {
          str = h.a(1);
        } 
        i i1 = new i(arrayOfByte, str, o2);
        i1.c = str2;
        l = SystemClock.elapsedRealtime();
        if (i.a(i1) != null)
          bool = h.b.offer(i1); 
        if (bool)
          return; 
        h.b.clear();
        h.b.offer(i1);
        StringBuilder stringBuilder = new StringBuilder("post");
        stringBuilder.append("Location");
        return;
      } finally {
        q = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */