package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

public class SubscriberExceptionContext {
  private final EventBus a;
  
  private final Object b;
  
  private final Object c;
  
  private final Method d;
  
  SubscriberExceptionContext(EventBus paramEventBus, Object paramObject1, Object paramObject2, Method paramMethod) {
    this.a = (EventBus)Preconditions.a(paramEventBus);
    this.b = Preconditions.a(paramObject1);
    this.c = Preconditions.a(paramObject2);
    this.d = (Method)Preconditions.a(paramMethod);
  }
  
  public EventBus a() {
    return this.a;
  }
  
  public Object b() {
    return this.b;
  }
  
  public Object c() {
    return this.c;
  }
  
  public Method d() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\SubscriberExceptionContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */