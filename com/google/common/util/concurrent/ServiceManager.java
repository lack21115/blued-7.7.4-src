package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ServiceManager implements ServiceManagerBridge {
  private static final Logger a = Logger.getLogger(ServiceManager.class.getName());
  
  private static final ListenerCallQueue.Event<Listener> b = new ListenerCallQueue.Event<Listener>() {
      public void a(ServiceManager.Listener param1Listener) {
        param1Listener.a();
      }
      
      public String toString() {
        return "healthy()";
      }
    };
  
  private static final ListenerCallQueue.Event<Listener> c = new ListenerCallQueue.Event<Listener>() {
      public void a(ServiceManager.Listener param1Listener) {
        param1Listener.b();
      }
      
      public String toString() {
        return "stopped()";
      }
    };
  
  private final ImmutableList<Service> d;
  
  public String toString() {
    return MoreObjects.a(ServiceManager.class).a("services", Collections2.a((Collection)this.d, Predicates.a(Predicates.a(NoOpService.class)))).toString();
  }
  
  static final class EmptyServiceManagerWarning extends Throwable {}
  
  public static abstract class Listener {
    public void a() {}
    
    public void a(Service param1Service) {}
    
    public void b() {}
  }
  
  static final class NoOpService extends AbstractService {
    protected void a() {
      c();
    }
  }
  
  static final class ServiceListener extends Service.Listener {
    final Service a;
    
    final WeakReference<ServiceManager.ServiceManagerState> b;
    
    public void a() {
      ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
      if (serviceManagerState != null) {
        serviceManagerState.a(this.a, Service.State.a, Service.State.b);
        if (!(this.a instanceof ServiceManager.NoOpService))
          ServiceManager.a().log(Level.FINE, "Starting {0}.", this.a); 
      } 
    }
    
    public void a(Service.State param1State) {
      ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
      if (serviceManagerState != null) {
        if (!(this.a instanceof ServiceManager.NoOpService))
          ServiceManager.a().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.a, param1State }); 
        serviceManagerState.a(this.a, param1State, Service.State.e);
      } 
    }
    
    public void a(Service.State param1State, Throwable param1Throwable) {
      ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
      if (serviceManagerState != null) {
        if ((this.a instanceof ServiceManager.NoOpService ^ true) != 0) {
          Logger logger = ServiceManager.a();
          Level level = Level.SEVERE;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Service ");
          stringBuilder.append(this.a);
          stringBuilder.append(" has failed in the ");
          stringBuilder.append(param1State);
          stringBuilder.append(" state.");
          logger.log(level, stringBuilder.toString(), param1Throwable);
        } 
        serviceManagerState.a(this.a, param1State, Service.State.f);
      } 
    }
    
    public void b() {
      ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
      if (serviceManagerState != null)
        serviceManagerState.a(this.a, Service.State.b, Service.State.c); 
    }
    
    public void b(Service.State param1State) {
      ServiceManager.ServiceManagerState serviceManagerState = this.b.get();
      if (serviceManagerState != null)
        serviceManagerState.a(this.a, param1State, Service.State.d); 
    }
  }
  
  static final class ServiceManagerState {
    final Monitor a;
    
    final SetMultimap<Service.State, Service> b;
    
    final Multiset<Service.State> c;
    
    final Map<Service, Stopwatch> d;
    
    boolean e;
    
    boolean f;
    
    final int g;
    
    final ListenerCallQueue<ServiceManager.Listener> h;
    
    void a() {
      this.h.a(ServiceManager.b());
    }
    
    void a(Service param1Service) {
      this.h.a(new ListenerCallQueue.Event<ServiceManager.Listener>(this, param1Service) {
            public void a(ServiceManager.Listener param2Listener) {
              param2Listener.a(this.a);
            }
            
            public String toString() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("failed({service=");
              stringBuilder.append(this.a);
              stringBuilder.append("})");
              return stringBuilder.toString();
            }
          });
    }
    
    void a(Service param1Service, Service.State param1State1, Service.State param1State2) {
      boolean bool;
      Preconditions.a(param1Service);
      if (param1State1 != param1State2) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      this.a.a();
      try {
        this.f = true;
        bool = this.e;
        if (!bool)
          return; 
        Preconditions.b(this.b.c(param1State1, param1Service), "Service %s not at the expected location in the state map %s", param1Service, param1State1);
        Preconditions.b(this.b.a(param1State2, param1Service), "Service %s in the state map unexpectedly at %s", param1Service, param1State2);
        Stopwatch stopwatch2 = this.d.get(param1Service);
        Stopwatch stopwatch1 = stopwatch2;
        if (stopwatch2 == null) {
          stopwatch1 = Stopwatch.b();
          this.d.put(param1Service, stopwatch1);
        } 
        if (param1State2.compareTo(Service.State.c) >= 0 && stopwatch1.c()) {
          stopwatch1.e();
          if (!(param1Service instanceof ServiceManager.NoOpService))
            ServiceManager.a().log(Level.FINE, "Started {0} in {1}.", new Object[] { param1Service, stopwatch1 }); 
        } 
        if (param1State2 == Service.State.f)
          a(param1Service); 
        if (this.c.a(Service.State.c) == this.g) {
          b();
        } else if (this.c.a(Service.State.e) + this.c.a(Service.State.f) == this.g) {
          a();
        } 
        return;
      } finally {
        this.a.b();
        c();
      } 
    }
    
    void b() {
      this.h.a(ServiceManager.c());
    }
    
    void c() {
      Preconditions.b(this.a.c() ^ true, "It is incorrect to execute listeners with the monitor held.");
      this.h.a();
    }
    
    final class AwaitHealthGuard extends Monitor.Guard {
      public boolean a() {
        return (this.a.c.a(Service.State.c) == this.a.g || this.a.c.contains(Service.State.d) || this.a.c.contains(Service.State.e) || this.a.c.contains(Service.State.f));
      }
    }
    
    final class StoppedGuard extends Monitor.Guard {
      public boolean a() {
        return (this.a.c.a(Service.State.e) + this.a.c.a(Service.State.f) == this.a.g);
      }
    }
  }
  
  class null implements Function<Map.Entry<Service, Long>, Long> {
    public Long a(Map.Entry<Service, Long> param1Entry) {
      return param1Entry.getValue();
    }
  }
  
  class null implements ListenerCallQueue.Event<Listener> {
    null(ServiceManager this$0, Service param1Service) {}
    
    public void a(ServiceManager.Listener param1Listener) {
      param1Listener.a(this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed({service=");
      stringBuilder.append(this.a);
      stringBuilder.append("})");
      return stringBuilder.toString();
    }
  }
  
  final class AwaitHealthGuard extends Monitor.Guard {
    public boolean a() {
      return (this.a.c.a(Service.State.c) == this.a.g || this.a.c.contains(Service.State.d) || this.a.c.contains(Service.State.e) || this.a.c.contains(Service.State.f));
    }
  }
  
  final class StoppedGuard extends Monitor.Guard {
    public boolean a() {
      return (this.a.c.a(Service.State.e) + this.a.c.a(Service.State.f) == this.a.g);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */