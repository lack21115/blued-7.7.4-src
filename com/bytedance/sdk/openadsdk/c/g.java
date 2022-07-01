package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class g<T extends i> extends HandlerThread implements Handler.Callback {
  public static String a = "AdEventThread";
  
  public static String b = "ttad_bk";
  
  public final e<T> c;
  
  public p<T> d;
  
  public final List<T> e;
  
  public long f;
  
  public boolean g;
  
  public int h;
  
  public Handler i;
  
  public final a j;
  
  public final b k;
  
  protected boolean l;
  
  public g(e<T> parame, p<T> paramp, b paramb, a parama) {
    super(b);
    this.k = paramb;
    this.j = parama;
    this.c = parame;
    this.d = paramp;
    this.e = Collections.synchronizedList(new LinkedList<T>());
    this.l = false;
  }
  
  public g(String paramString1, String paramString2, e<T> parame, p<T> paramp, b paramb, a parama) {
    super(paramString1);
    a = paramString2;
    this.k = paramb;
    this.j = parama;
    this.c = parame;
    this.d = paramp;
    this.e = Collections.synchronizedList(new LinkedList<T>());
    this.l = false;
  }
  
  private void a() {
    this.c.a(this.k.d, this.k.e);
    this.g = this.c.b();
    this.h = this.c.c();
    if (this.g) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onHandleInitEvent serverBusy, retryCount = ");
      stringBuilder1.append(this.h);
      a(stringBuilder1.toString());
      h();
      return;
    } 
    b(this.c.a());
    a("onHandleInitEvent,mCloseSaveAndRetry is false, read db event data");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onHandleInitEvent cacheData count = ");
    stringBuilder.append(this.e.size());
    a(stringBuilder.toString());
    e();
  }
  
  private void a(int paramInt, long paramLong) {
    Message message = this.i.obtainMessage();
    message.what = paramInt;
    this.i.sendMessageDelayed(message, paramLong);
  }
  
  private void a(T paramT) {
    c(this.e);
    this.c.a(paramT);
    a("onHandleReceivedAdEvent mCloseSaveAndRetry is false, save event into db");
    if (this.g)
      return; 
    a("onHandleReceivedAdEvent");
    this.e.add(paramT);
    if (n()) {
      a("onHandleReceivedAdEvent upload");
      e();
    } 
  }
  
  private void a(String paramString) {
    t.b(a, paramString);
  }
  
  private static boolean a(h paramh) {
    return (paramh.b == 509);
  }
  
  private void b() {
    if (!this.j.a()) {
      a(4, this.k.c);
      a("onHandleServerBusyRetryEvent, no net");
      return;
    } 
    List<T> list = this.c.a();
    c(list);
    if (r.a(list)) {
      a("onHandleServerBusyRetryEvent, empty list start routine");
      o();
      j();
      return;
    } 
    h h = a(list);
    if (h != null) {
      StringBuilder stringBuilder;
      if (h.a) {
        a("onHandleServerBusyRetryEvent, success");
        g();
        f();
        return;
      } 
      if (a(h)) {
        this.h++;
        this.c.a(this.h);
        this.c.a(list, this.k.d, this.k.e);
        h();
        stringBuilder = new StringBuilder();
        stringBuilder.append("onHandleServerBusyRetryEvent, serverbusy, count = ");
        stringBuilder.append(this.h);
        a(stringBuilder.toString());
        return;
      } 
      if (b(h)) {
        g();
        f();
        return;
      } 
      if (!this.l) {
        i();
        a("onHandleServerBusyRetryEvent, net fail");
        return;
      } 
      this.h++;
      this.c.a(this.h);
      this.c.a((List<T>)stringBuilder, this.k.d, this.k.e);
      l();
    } 
  }
  
  private void b(List<T> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() == 0) {
          a("reloadCacheList adEventList is empty======");
          return;
        } 
        HashSet<String> hashSet = new HashSet();
        Iterator<T> iterator = this.e.iterator();
        while (iterator.hasNext())
          hashSet.add(((i)iterator.next()).b()); 
        for (i i : paramList) {
          if (!hashSet.contains(i.b()))
            this.e.add((T)i); 
        } 
        return;
      } catch (Exception exception) {
        return;
      }  
    a("reloadCacheList adEventList is empty======");
  }
  
  private static boolean b(h paramh) {
    return paramh.d;
  }
  
  private void c() {
    if (this.g)
      return; 
    a("onHandleRoutineRetryEvent");
    e();
  }
  
  private void c(List<T> paramList) {
    if (this.l) {
      if (paramList == null)
        return; 
      if (paramList.size() <= 100) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start and return, checkAndDeleteEvent local size:");
        stringBuilder.append(paramList.size());
        stringBuilder.append("小于:");
        stringBuilder.append(100);
        a(stringBuilder.toString());
        return;
      } 
      int j = (int)(paramList.size() - 75.0F);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("start checkAndDeleteEvent local size,deleteCnt:");
      stringBuilder2.append(paramList.size());
      stringBuilder2.append(",");
      stringBuilder2.append(j);
      a(stringBuilder2.toString());
      ArrayList<i> arrayList = new ArrayList();
      for (int i = 0; i < j; i++)
        arrayList.add((i)paramList.get(i)); 
      paramList.removeAll(arrayList);
      this.c.a((List)arrayList);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("end checkAndDeleteEvent local size:");
      stringBuilder1.append(paramList.size());
      a(stringBuilder1.toString());
    } 
  }
  
  private void d() {
    if (this.g)
      return; 
    a("onHandleRoutineUploadEvent");
    e();
  }
  
  private void e() {
    this.i.removeMessages(3);
    this.i.removeMessages(2);
    if (r.a(this.e)) {
      this.f = System.currentTimeMillis();
      j();
      return;
    } 
    if (!this.j.a()) {
      a("doRoutineUpload no net, wait retry");
      i();
      return;
    } 
    h h = a(this.e);
    if (h != null) {
      if (h.a) {
        a("doRoutineUpload success");
        g();
        f();
        return;
      } 
      if (a(h)) {
        a("doRoutineUpload serverbusy");
        k();
        return;
      } 
      if (b(h)) {
        g();
        f();
        return;
      } 
      if (!this.g) {
        if (!this.l) {
          i();
          a("doRoutineUpload net fail retry");
          return;
        } 
        l();
      } 
    } 
  }
  
  private void f() {
    this.f = System.currentTimeMillis();
    o();
    j();
  }
  
  private void g() {
    a("clearCacheList, delete event from cache and db");
    this.c.a(this.e);
    this.e.clear();
  }
  
  private void h() {
    a(4, m());
  }
  
  private void i() {
    a(3, this.k.c);
  }
  
  private void j() {
    a(2, this.k.b);
  }
  
  private void k() {
    this.g = true;
    this.c.a(true);
    this.e.clear();
    this.i.removeMessages(3);
    this.i.removeMessages(2);
    h();
  }
  
  private void l() {
    this.g = true;
    this.c.a(true);
    this.e.clear();
    this.i.removeMessages(3);
    this.i.removeMessages(2);
    h();
  }
  
  private long m() {
    return (this.h % 3 + 1) * this.k.f;
  }
  
  private boolean n() {
    return (!this.g && (this.e.size() >= this.k.a || System.currentTimeMillis() - this.f >= this.k.b));
  }
  
  private void o() {
    this.g = false;
    this.c.a(false);
    this.h = 0;
    this.c.a(0);
    this.i.removeMessages(4);
  }
  
  public h a(List<T> paramList) {
    if (this.d == null)
      o.f(); 
    p<T> p1 = this.d;
    return (p1 == null) ? null : p1.a(paramList);
  }
  
  public boolean handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i != 5)
              return true; 
            a();
            return true;
          } 
          b();
          return true;
        } 
        c();
        return true;
      } 
      d();
      return true;
    } 
    a((T)paramMessage.obj);
    return true;
  }
  
  protected void onLooperPrepared() {
    this.f = System.currentTimeMillis();
    this.i = new Handler(getLooper(), this);
  }
  
  public static interface a {
    boolean a();
  }
  
  public static class b {
    final int a;
    
    final long b;
    
    final long c;
    
    final int d;
    
    final long e;
    
    final long f;
    
    b(int param1Int1, long param1Long1, long param1Long2, int param1Int2, long param1Long3, long param1Long4) {
      this.a = param1Int1;
      this.b = param1Long1;
      this.c = param1Long2;
      this.d = param1Int2;
      this.e = param1Long3;
      this.f = param1Long4;
    }
    
    public static b a() {
      return new b(1, 120000L, 15000L, 5, 172800000L, 300000L);
    }
    
    public static b b() {
      return new b(3, 120000L, 15000L, 5, 172800000L, 300000L);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\c\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */