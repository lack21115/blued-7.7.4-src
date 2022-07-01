package com.ishumei.l111l11111lIl.l111l11111I1l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111l1Il.l111l11111I1l;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class l1111l111111Il {
  private static final String l1111l111111Il = "sm";
  
  private static long l111l11111I1l = 2000L;
  
  private static long l111l11111Il = 5000L;
  
  private static long l111l11111lIl = 0L;
  
  private static long l111l1111l1Il = 15000L;
  
  private static final int l111l1111lI1l = 9;
  
  private static final int l111l1111lIl = 6;
  
  private static long l111l1111llIl = 30000L;
  
  private static final int l11l1111I11l = 0;
  
  private static final int l11l1111I1l = 2;
  
  private static final int l11l1111I1ll = 1;
  
  private static final int l11l1111Il = 2;
  
  private static final int l11l1111Il1l = 3;
  
  private static final int l11l1111Ill = 4;
  
  private static final int l11l1111lIIl = 3;
  
  private static final int l11l11IlIIll = 1000000;
  
  private String l111l11IlIlIl;
  
  private AtomicInteger l11l111l11Il = new AtomicInteger(0);
  
  private Runnable l11l111l1I1l = new Runnable(this) {
      public final void run() {
        try {
          return;
        } finally {
          Exception exception = null;
        } 
      }
    };
  
  private String l11l111l1lll;
  
  private l1111l111111Il() {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
  }
  
  private static int l1111l111111Il(String paramString) {
    try {
      return (new JSONObject(paramString)).getInt("code");
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  public static l1111l111111Il l1111l111111Il() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  private void l1111l111111Il(int paramInt) {
    if (paramInt == 1) {
      this.l11l111l11Il.set(0);
      return;
    } 
    if (paramInt == 2) {
      long l;
      paramInt = this.l11l111l11Il.incrementAndGet();
      this.l11l111l11Il.get();
      if (paramInt > 1000000)
        this.l11l111l11Il.set(10); 
      if (this.l11l111l11Il.get() > 9) {
        l = 30000L;
      } else if (this.l11l111l11Il.get() > 6) {
        l = 15000L;
      } else if (this.l11l111l11Il.get() > 3) {
        l = 5000L;
      } else {
        l = 2000L;
      } 
      l1111l111111Il(l);
      return;
    } 
    if (paramInt == 4)
      l1111l111111Il(1000L); 
  }
  
  private void l1111l111111Il(long paramLong) {
    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l11l111l1I1l, 4, paramLong, true);
  }
  
  private long l111l11111I1l() {
    return (this.l11l111l11Il.get() > 9) ? 30000L : ((this.l11l111l11Il.get() > 6) ? 15000L : ((this.l11l111l11Il.get() > 3) ? 5000L : 2000L));
  }
  
  private static boolean l111l11111lIl(String paramString1, String paramString2) {
    try {
      com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il1 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(paramString2);
      JSONObject jSONObject = new JSONObject((new l111l11111I1l()).l1111l111111Il(l1111l111111Il1).l1111l111111Il(paramString1.getBytes("utf-8"), null, paramString2));
      int i = jSONObject.getInt("code");
      if (i == 1100) {
        l111l1111llIl.l1111l111111Il().l1111l111111Il(jSONObject);
        return true;
      } 
      if (i == 1902)
        return true; 
    } catch (Exception exception) {}
    return false;
  }
  
  public final void l1111l111111Il(String paramString1, String paramString2) {
    com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new Runnable(this, paramString1, paramString2) {
          public final void run() {
            l111l11111lIl l111l11111lIl = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
            if (l111l11111lIl != null) {
              if (!l111l11111lIl.l11l1111lIIl())
                return; 
              if (!TextUtils.isEmpty(this.l1111l111111Il)) {
                if (TextUtils.isEmpty(this.l111l11111lIl))
                  return; 
                String str = this.l1111l111111Il;
                try {
                  JSONObject jSONObject = new JSONObject(str);
                  jSONObject.put("retry", 1);
                  String str1 = jSONObject.toString();
                  str = str1;
                } catch (Exception exception) {}
                Handler handler = com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(4);
                if (handler == null)
                  return; 
                handler.removeCallbacks(l1111l111111Il.l111l11111Il(this.l111l11111I1l));
                l1111l111111Il.l1111l111111Il(this.l111l11111I1l, str);
                l1111l111111Il.l111l11111lIl(this.l111l11111I1l, this.l111l11111lIl);
                this.l111l11111I1l.l111l11111lIl();
              } 
            } 
          }
        }4);
  }
  
  public final void l111l11111lIl() {
    this.l11l111l11Il.set(0);
    l1111l111111Il(0L);
  }
  
  static final class l1111l111111Il {
    private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111lIl\l111l11111I1l\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */