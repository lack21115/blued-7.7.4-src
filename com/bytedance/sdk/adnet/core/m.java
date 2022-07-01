package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.face.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class m {
  private final AtomicInteger a = new AtomicInteger();
  
  private final Set<Request<?>> b = new HashSet<Request<?>>();
  
  private final PriorityBlockingQueue<Request<?>> c = new PriorityBlockingQueue<Request<?>>();
  
  private final PriorityBlockingQueue<Request<?>> d = new PriorityBlockingQueue<Request<?>>();
  
  private final com.bytedance.sdk.adnet.face.a e;
  
  private final com.bytedance.sdk.adnet.face.b f;
  
  private final c g;
  
  private final i[] h;
  
  private d i;
  
  private final List<b> j = new ArrayList<b>();
  
  private final List<a> k = new ArrayList<a>();
  
  public m(com.bytedance.sdk.adnet.face.a parama, com.bytedance.sdk.adnet.face.b paramb) {
    this(parama, paramb, 4);
  }
  
  public m(com.bytedance.sdk.adnet.face.a parama, com.bytedance.sdk.adnet.face.b paramb, int paramInt) {
    this(parama, paramb, paramInt, new g(new Handler(Looper.getMainLooper())));
  }
  
  public m(com.bytedance.sdk.adnet.face.a parama, com.bytedance.sdk.adnet.face.b paramb, int paramInt, c paramc) {
    this.e = parama;
    this.f = paramb;
    this.h = new i[paramInt];
    this.g = paramc;
  }
  
  public <T> Request<T> a(Request<T> paramRequest) {
    b(paramRequest);
    paramRequest.setStartTime();
    paramRequest.setRequestQueue(this);
    synchronized (this.b) {
      this.b.add(paramRequest);
      paramRequest.setSequence(c());
      paramRequest.addMarker("add-to-queue");
      a(paramRequest, 0);
      if (!paramRequest.shouldCache()) {
        this.d.add(paramRequest);
        return paramRequest;
      } 
      this.c.add(paramRequest);
      return paramRequest;
    } 
  }
  
  public void a() {
    b();
    this.i = new d(this.c, this.d, this.e, this.g);
    this.i.start();
    for (int j = 0; j < this.h.length; j++) {
      i i1 = new i(this.d, this.f, this.e, this.g);
      this.h[j] = i1;
      i1.start();
    } 
  }
  
  void a(Request<?> paramRequest, int paramInt) {
    synchronized (this.k) {
      Iterator<a> iterator = this.k.iterator();
      while (iterator.hasNext())
        ((a)iterator.next()).a(paramRequest, paramInt); 
      return;
    } 
  }
  
  public void b() {
    d d1 = this.i;
    if (d1 != null)
      d1.a(); 
    for (i i1 : this.h) {
      if (i1 != null)
        i1.a(); 
    } 
  }
  
  public <T> void b(Request<T> paramRequest) {
    if (paramRequest != null) {
      if (TextUtils.isEmpty(paramRequest.getUrl()))
        return; 
      String str = paramRequest.getUrl();
      if (com.bytedance.sdk.adnet.a.d() != null) {
        str = com.bytedance.sdk.adnet.a.d().a(str);
        if (!TextUtils.isEmpty(str))
          paramRequest.setUrl(str); 
      } 
    } 
  }
  
  public int c() {
    return this.a.incrementAndGet();
  }
  
  <T> void c(Request<T> paramRequest) {
    synchronized (this.b) {
      this.b.remove(paramRequest);
      synchronized (this.j) {
        Iterator<b> iterator = this.j.iterator();
        while (iterator.hasNext())
          ((b<T>)iterator.next()).a(paramRequest); 
        a(paramRequest, 5);
        return;
      } 
    } 
  }
  
  public static interface a {
    void a(Request<?> param1Request, int param1Int);
  }
  
  @Deprecated
  public static interface b<T> {
    void a(Request<T> param1Request);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */