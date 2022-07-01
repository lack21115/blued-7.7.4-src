package com.google.common.eventbus;

import com.google.common.collect.Queues;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher {
  static Dispatcher a() {
    return new PerThreadQueuedDispatcher();
  }
  
  static final class ImmediateDispatcher extends Dispatcher {
    private static final ImmediateDispatcher a = new ImmediateDispatcher();
  }
  
  static final class LegacyAsyncDispatcher extends Dispatcher {
    private final ConcurrentLinkedQueue<EventWithSubscriber> a = Queues.b();
    
    static final class EventWithSubscriber {}
  }
  
  static final class EventWithSubscriber {}
  
  static final class PerThreadQueuedDispatcher extends Dispatcher {
    private final ThreadLocal<Queue<Event>> a = new ThreadLocal<Queue<Event>>(this) {
        protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> a() {
          return Queues.a();
        }
      };
    
    private final ThreadLocal<Boolean> b = new ThreadLocal<Boolean>(this) {
        protected Boolean a() {
          return Boolean.valueOf(false);
        }
      };
    
    private PerThreadQueuedDispatcher() {}
    
    static final class Event {}
  }
  
  class null extends ThreadLocal<Queue<PerThreadQueuedDispatcher.Event>> {
    null(Dispatcher this$0) {}
    
    protected Queue<Dispatcher.PerThreadQueuedDispatcher.Event> a() {
      return Queues.a();
    }
  }
  
  class null extends ThreadLocal<Boolean> {
    null(Dispatcher this$0) {}
    
    protected Boolean a() {
      return Boolean.valueOf(false);
    }
  }
  
  static final class Event {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */