package com.bumptech.glide.request;

public class ThumbnailRequestCoordinator implements Request, RequestCoordinator {
  private final RequestCoordinator a;
  
  private final Object b;
  
  private volatile Request c;
  
  private volatile Request d;
  
  private RequestCoordinator.RequestState e = RequestCoordinator.RequestState.c;
  
  private RequestCoordinator.RequestState f = RequestCoordinator.RequestState.c;
  
  private boolean g;
  
  public ThumbnailRequestCoordinator(Object paramObject, RequestCoordinator paramRequestCoordinator) {
    this.b = paramObject;
    this.a = paramRequestCoordinator;
  }
  
  private boolean i() {
    RequestCoordinator requestCoordinator = this.a;
    return (requestCoordinator == null || requestCoordinator.b(this));
  }
  
  private boolean j() {
    RequestCoordinator requestCoordinator = this.a;
    return (requestCoordinator == null || requestCoordinator.d(this));
  }
  
  private boolean k() {
    RequestCoordinator requestCoordinator = this.a;
    return (requestCoordinator == null || requestCoordinator.c(this));
  }
  
  public void a() {
    synchronized (this.b) {
      this.g = true;
      try {
        if (this.e != RequestCoordinator.RequestState.d && this.f != RequestCoordinator.RequestState.a) {
          this.f = RequestCoordinator.RequestState.a;
          this.d.a();
        } 
        if (this.g && this.e != RequestCoordinator.RequestState.a) {
          this.e = RequestCoordinator.RequestState.a;
          this.c.a();
        } 
        return;
      } finally {
        this.g = false;
      } 
    } 
  }
  
  public void a(Request paramRequest1, Request paramRequest2) {
    this.c = paramRequest1;
    this.d = paramRequest2;
  }
  
  public boolean a(Request paramRequest) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof com/bumptech/glide/request/ThumbnailRequestCoordinator
    //   4: istore #4
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_3
    //   9: istore_2
    //   10: iload #4
    //   12: ifeq -> 96
    //   15: aload_1
    //   16: checkcast com/bumptech/glide/request/ThumbnailRequestCoordinator
    //   19: astore_1
    //   20: aload_0
    //   21: getfield c : Lcom/bumptech/glide/request/Request;
    //   24: ifnonnull -> 39
    //   27: iload_3
    //   28: istore_2
    //   29: aload_1
    //   30: getfield c : Lcom/bumptech/glide/request/Request;
    //   33: ifnonnull -> 96
    //   36: goto -> 57
    //   39: iload_3
    //   40: istore_2
    //   41: aload_0
    //   42: getfield c : Lcom/bumptech/glide/request/Request;
    //   45: aload_1
    //   46: getfield c : Lcom/bumptech/glide/request/Request;
    //   49: invokeinterface a : (Lcom/bumptech/glide/request/Request;)Z
    //   54: ifeq -> 96
    //   57: aload_0
    //   58: getfield d : Lcom/bumptech/glide/request/Request;
    //   61: ifnonnull -> 76
    //   64: iload_3
    //   65: istore_2
    //   66: aload_1
    //   67: getfield d : Lcom/bumptech/glide/request/Request;
    //   70: ifnonnull -> 96
    //   73: goto -> 94
    //   76: iload_3
    //   77: istore_2
    //   78: aload_0
    //   79: getfield d : Lcom/bumptech/glide/request/Request;
    //   82: aload_1
    //   83: getfield d : Lcom/bumptech/glide/request/Request;
    //   86: invokeinterface a : (Lcom/bumptech/glide/request/Request;)Z
    //   91: ifeq -> 96
    //   94: iconst_1
    //   95: istore_2
    //   96: iload_2
    //   97: ireturn
  }
  
  public void b() {
    synchronized (this.b) {
      this.g = false;
      this.e = RequestCoordinator.RequestState.c;
      this.f = RequestCoordinator.RequestState.c;
      this.d.b();
      this.c.b();
      return;
    } 
  }
  
  public boolean b(Request paramRequest) {
    synchronized (this.b) {
      if (i() && (paramRequest.equals(this.c) || this.e != RequestCoordinator.RequestState.d))
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public void c() {
    synchronized (this.b) {
      if (!this.f.a()) {
        this.f = RequestCoordinator.RequestState.b;
        this.d.c();
      } 
      if (!this.e.a()) {
        this.e = RequestCoordinator.RequestState.b;
        this.c.c();
      } 
      return;
    } 
  }
  
  public boolean c(Request paramRequest) {
    synchronized (this.b) {
      if (k() && paramRequest.equals(this.c) && !g())
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public boolean d() {
    synchronized (this.b) {
      if (this.e == RequestCoordinator.RequestState.a)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean d(Request paramRequest) {
    synchronized (this.b) {
      if (j() && paramRequest.equals(this.c) && this.e != RequestCoordinator.RequestState.b)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return bool;
  }
  
  public void e(Request paramRequest) {
    synchronized (this.b) {
      if (paramRequest.equals(this.d)) {
        this.f = RequestCoordinator.RequestState.d;
        return;
      } 
      this.e = RequestCoordinator.RequestState.d;
      if (this.a != null)
        this.a.e(this); 
      if (!this.f.a())
        this.d.b(); 
      return;
    } 
  }
  
  public boolean e() {
    synchronized (this.b) {
      if (this.e == RequestCoordinator.RequestState.d)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public void f(Request paramRequest) {
    synchronized (this.b) {
      if (!paramRequest.equals(this.c)) {
        this.f = RequestCoordinator.RequestState.e;
        return;
      } 
      this.e = RequestCoordinator.RequestState.e;
      if (this.a != null)
        this.a.f(this); 
      return;
    } 
  }
  
  public boolean f() {
    synchronized (this.b) {
      if (this.e == RequestCoordinator.RequestState.c)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public boolean g() {
    synchronized (this.b) {
      if (this.d.g() || this.c.g())
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public RequestCoordinator h() {
    synchronized (this.b) {
      if (this.a != null)
        return this.a.h(); 
    } 
    ThumbnailRequestCoordinator thumbnailRequestCoordinator = this;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return thumbnailRequestCoordinator;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\ThumbnailRequestCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */