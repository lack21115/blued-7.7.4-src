package com.bumptech.glide.request;

public interface RequestCoordinator {
  boolean b(Request paramRequest);
  
  boolean c(Request paramRequest);
  
  boolean d(Request paramRequest);
  
  void e(Request paramRequest);
  
  void f(Request paramRequest);
  
  boolean g();
  
  RequestCoordinator h();
  
  public enum RequestState {
    a(false),
    b(false),
    c(false),
    d(true),
    e(true);
    
    private final boolean f;
    
    RequestState(boolean param1Boolean) {
      this.f = param1Boolean;
    }
    
    boolean a() {
      return this.f;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\RequestCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */