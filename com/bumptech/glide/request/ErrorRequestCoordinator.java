package com.bumptech.glide.request;

public final class ErrorRequestCoordinator implements Request, RequestCoordinator {
  private final Object a;
  
  private final RequestCoordinator b;
  
  private volatile Request c;
  
  private volatile Request d;
  
  private RequestCoordinator.RequestState e = RequestCoordinator.RequestState.c;
  
  private RequestCoordinator.RequestState f = RequestCoordinator.RequestState.c;
  
  public ErrorRequestCoordinator(Object paramObject, RequestCoordinator paramRequestCoordinator) {
    this.a = paramObject;
    this.b = paramRequestCoordinator;
  }
  
  private boolean g(Request paramRequest) {
    return (paramRequest.equals(this.c) || (this.e == RequestCoordinator.RequestState.e && paramRequest.equals(this.d)));
  }
  
  private boolean i() {
    RequestCoordinator requestCoordinator = this.b;
    return (requestCoordinator == null || requestCoordinator.b(this));
  }
  
  private boolean j() {
    RequestCoordinator requestCoordinator = this.b;
    return (requestCoordinator == null || requestCoordinator.d(this));
  }
  
  private boolean k() {
    RequestCoordinator requestCoordinator = this.b;
    return (requestCoordinator == null || requestCoordinator.c(this));
  }
  
  public void a() {
    synchronized (this.a) {
      if (this.e != RequestCoordinator.RequestState.a) {
        this.e = RequestCoordinator.RequestState.a;
        this.c.a();
      } 
      return;
    } 
  }
  
  public void a(Request paramRequest1, Request paramRequest2) {
    this.c = paramRequest1;
    this.d = paramRequest2;
  }
  
  public boolean a(Request paramRequest) {
    boolean bool = paramRequest instanceof ErrorRequestCoordinator;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramRequest = paramRequest;
      bool1 = bool2;
      if (this.c.a(((ErrorRequestCoordinator)paramRequest).c)) {
        bool1 = bool2;
        if (this.d.a(((ErrorRequestCoordinator)paramRequest).d))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public void b() {
    synchronized (this.a) {
      this.e = RequestCoordinator.RequestState.c;
      this.c.b();
      if (this.f != RequestCoordinator.RequestState.c) {
        this.f = RequestCoordinator.RequestState.c;
        this.d.b();
      } 
      return;
    } 
  }
  
  public boolean b(Request paramRequest) {
    synchronized (this.a) {
      if (i() && g(paramRequest))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public void c() {
    synchronized (this.a) {
      if (this.e == RequestCoordinator.RequestState.a) {
        this.e = RequestCoordinator.RequestState.b;
        this.c.c();
      } 
      if (this.f == RequestCoordinator.RequestState.a) {
        this.f = RequestCoordinator.RequestState.b;
        this.d.c();
      } 
      return;
    } 
  }
  
  public boolean c(Request paramRequest) {
    synchronized (this.a) {
      if (k() && g(paramRequest))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public boolean d() {
    synchronized (this.a) {
      if (this.e == RequestCoordinator.RequestState.a || this.f == RequestCoordinator.RequestState.a)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean d(Request paramRequest) {
    synchronized (this.a) {
      if (j() && g(paramRequest))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public void e(Request paramRequest) {
    synchronized (this.a) {
      if (paramRequest.equals(this.c)) {
        this.e = RequestCoordinator.RequestState.d;
      } else if (paramRequest.equals(this.d)) {
        this.f = RequestCoordinator.RequestState.d;
      } 
      if (this.b != null)
        this.b.e(this); 
      return;
    } 
  }
  
  public boolean e() {
    synchronized (this.a) {
      if (this.e == RequestCoordinator.RequestState.d || this.f == RequestCoordinator.RequestState.d)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public void f(Request paramRequest) {
    synchronized (this.a) {
      if (!paramRequest.equals(this.d)) {
        this.e = RequestCoordinator.RequestState.e;
        if (this.f != RequestCoordinator.RequestState.a) {
          this.f = RequestCoordinator.RequestState.a;
          this.d.a();
        } 
        return;
      } 
      this.f = RequestCoordinator.RequestState.e;
      if (this.b != null)
        this.b.f(this); 
      return;
    } 
  }
  
  public boolean f() {
    synchronized (this.a) {
      if (this.e == RequestCoordinator.RequestState.c && this.f == RequestCoordinator.RequestState.c)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean g() {
    synchronized (this.a) {
      if (this.c.g() || this.d.g())
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public RequestCoordinator h() {
    synchronized (this.a) {
      if (this.b != null)
        return this.b.h(); 
    } 
    ErrorRequestCoordinator errorRequestCoordinator = this;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return errorRequestCoordinator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\ErrorRequestCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */