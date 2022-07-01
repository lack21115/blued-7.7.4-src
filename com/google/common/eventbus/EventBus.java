package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventBus {
  private static final Logger a = Logger.getLogger(EventBus.class.getName());
  
  private final String b;
  
  private final Executor c;
  
  private final SubscriberExceptionHandler d;
  
  private final SubscriberRegistry e = new SubscriberRegistry(this);
  
  private final Dispatcher f;
  
  public EventBus() {
    this("default");
  }
  
  public EventBus(String paramString) {
    this(paramString, MoreExecutors.a(), Dispatcher.a(), LoggingHandler.a);
  }
  
  EventBus(String paramString, Executor paramExecutor, Dispatcher paramDispatcher, SubscriberExceptionHandler paramSubscriberExceptionHandler) {
    this.b = (String)Preconditions.a(paramString);
    this.c = (Executor)Preconditions.a(paramExecutor);
    this.f = (Dispatcher)Preconditions.a(paramDispatcher);
    this.d = (SubscriberExceptionHandler)Preconditions.a(paramSubscriberExceptionHandler);
  }
  
  public final String a() {
    return this.b;
  }
  
  void a(Throwable paramThrowable, SubscriberExceptionContext paramSubscriberExceptionContext) {
    Preconditions.a(paramThrowable);
    Preconditions.a(paramSubscriberExceptionContext);
    try {
      return;
    } finally {
      paramSubscriberExceptionContext = null;
      a.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[] { paramSubscriberExceptionContext, paramThrowable }), (Throwable)paramSubscriberExceptionContext);
    } 
  }
  
  public String toString() {
    return MoreObjects.a(this).a(this.b).toString();
  }
  
  static final class LoggingHandler implements SubscriberExceptionHandler {
    static final LoggingHandler a = new LoggingHandler();
    
    private static Logger a(SubscriberExceptionContext param1SubscriberExceptionContext) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(EventBus.class.getName());
      stringBuilder.append(".");
      stringBuilder.append(param1SubscriberExceptionContext.a().a());
      return Logger.getLogger(stringBuilder.toString());
    }
    
    private static String b(SubscriberExceptionContext param1SubscriberExceptionContext) {
      Method method = param1SubscriberExceptionContext.d();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Exception thrown by subscriber method ");
      stringBuilder.append(method.getName());
      stringBuilder.append('(');
      stringBuilder.append(method.getParameterTypes()[0].getName());
      stringBuilder.append(')');
      stringBuilder.append(" on subscriber ");
      stringBuilder.append(param1SubscriberExceptionContext.c());
      stringBuilder.append(" when dispatching event: ");
      stringBuilder.append(param1SubscriberExceptionContext.b());
      return stringBuilder.toString();
    }
    
    public void a(Throwable param1Throwable, SubscriberExceptionContext param1SubscriberExceptionContext) {
      Logger logger = a(param1SubscriberExceptionContext);
      if (logger.isLoggable(Level.SEVERE))
        logger.log(Level.SEVERE, b(param1SubscriberExceptionContext), param1Throwable); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */