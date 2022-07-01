package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {
  private final Set<Request> a = Collections.newSetFromMap(new WeakHashMap<Request, Boolean>());
  
  private final List<Request> b = new ArrayList<Request>();
  
  private boolean c;
  
  public void a() {
    this.c = true;
    for (Request request : Util.a(this.a)) {
      if (request.d()) {
        request.c();
        this.b.add(request);
      } 
    } 
  }
  
  public void a(Request paramRequest) {
    this.a.add(paramRequest);
    if (!this.c) {
      paramRequest.a();
      return;
    } 
    paramRequest.b();
    if (Log.isLoggable("RequestTracker", 2))
      Log.v("RequestTracker", "Paused, delaying request"); 
    this.b.add(paramRequest);
  }
  
  public void b() {
    this.c = true;
    for (Request request : Util.a(this.a)) {
      if (request.d() || request.e()) {
        request.b();
        this.b.add(request);
      } 
    } 
  }
  
  public boolean b(Request paramRequest) {
    boolean bool2 = true;
    if (paramRequest == null)
      return true; 
    boolean bool = this.a.remove(paramRequest);
    boolean bool1 = bool2;
    if (!this.b.remove(paramRequest))
      if (bool) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }  
    if (bool1)
      paramRequest.b(); 
    return bool1;
  }
  
  public void c() {
    this.c = false;
    for (Request request : Util.a(this.a)) {
      if (!request.e() && !request.d())
        request.a(); 
    } 
    this.b.clear();
  }
  
  public void d() {
    Iterator<Request> iterator = Util.a(this.a).iterator();
    while (iterator.hasNext())
      b(iterator.next()); 
    this.b.clear();
  }
  
  public void e() {
    for (Request request : Util.a(this.a)) {
      if (!request.e() && !request.f()) {
        request.b();
        if (!this.c) {
          request.a();
          continue;
        } 
        this.b.add(request);
      } 
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("{numRequests=");
    stringBuilder.append(this.a.size());
    stringBuilder.append(", isPaused=");
    stringBuilder.append(this.c);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\manager\RequestTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */