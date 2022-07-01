package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class AbstractService implements Service {
  private static final ListenerCallQueue.Event<Service.Listener> a = new ListenerCallQueue.Event<Service.Listener>() {
      public void a(Service.Listener param1Listener) {
        param1Listener.a();
      }
      
      public String toString() {
        return "starting()";
      }
    };
  
  private static final ListenerCallQueue.Event<Service.Listener> b = new ListenerCallQueue.Event<Service.Listener>() {
      public void a(Service.Listener param1Listener) {
        param1Listener.b();
      }
      
      public String toString() {
        return "running()";
      }
    };
  
  private static final ListenerCallQueue.Event<Service.Listener> c = b(Service.State.b);
  
  private static final ListenerCallQueue.Event<Service.Listener> d = b(Service.State.c);
  
  private static final ListenerCallQueue.Event<Service.Listener> e = a(Service.State.a);
  
  private static final ListenerCallQueue.Event<Service.Listener> f = a(Service.State.b);
  
  private static final ListenerCallQueue.Event<Service.Listener> g = a(Service.State.c);
  
  private static final ListenerCallQueue.Event<Service.Listener> h = a(Service.State.d);
  
  private final Monitor i = new Monitor();
  
  private final Monitor.Guard j = new IsStartableGuard(this);
  
  private final Monitor.Guard k = new IsStoppableGuard(this);
  
  private final Monitor.Guard l = new HasReachedRunningGuard(this);
  
  private final Monitor.Guard m = new IsStoppedGuard(this);
  
  private final ListenerCallQueue<Service.Listener> n = new ListenerCallQueue<Service.Listener>();
  
  private volatile StateSnapshot o = new StateSnapshot(Service.State.a);
  
  private static ListenerCallQueue.Event<Service.Listener> a(Service.State paramState) {
    return new ListenerCallQueue.Event<Service.Listener>(paramState) {
        public void a(Service.Listener param1Listener) {
          param1Listener.a(this.a);
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("terminated({from = ");
          stringBuilder.append(this.a);
          stringBuilder.append("})");
          return stringBuilder.toString();
        }
      };
  }
  
  private void a(Service.State paramState, Throwable paramThrowable) {
    this.n.a(new ListenerCallQueue.Event<Service.Listener>(this, paramState, paramThrowable) {
          public void a(Service.Listener param1Listener) {
            param1Listener.a(this.a, this.b);
          }
          
          public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed({from = ");
            stringBuilder.append(this.a);
            stringBuilder.append(", cause = ");
            stringBuilder.append(this.b);
            stringBuilder.append("})");
            return stringBuilder.toString();
          }
        });
  }
  
  private static ListenerCallQueue.Event<Service.Listener> b(Service.State paramState) {
    return new ListenerCallQueue.Event<Service.Listener>(paramState) {
        public void a(Service.Listener param1Listener) {
          param1Listener.b(this.a);
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("stopping({from = ");
          stringBuilder.append(this.a);
          stringBuilder.append("})");
          return stringBuilder.toString();
        }
      };
  }
  
  private void c(Service.State paramState) {
    switch (null.a[paramState.ordinal()]) {
      default:
        return;
      case 5:
      case 6:
        throw new AssertionError();
      case 4:
        this.n.a(h);
        return;
      case 3:
        this.n.a(g);
        return;
      case 2:
        this.n.a(f);
        return;
      case 1:
        break;
    } 
    this.n.a(e);
  }
  
  private void f() {
    if (!this.i.c())
      this.n.a(); 
  }
  
  private void g() {
    this.n.a(b);
  }
  
  protected abstract void a();
  
  protected final void a(Throwable paramThrowable) {
    Preconditions.a(paramThrowable);
    this.i.a();
    try {
      Service.State state = e();
      int i = null.a[state.ordinal()];
      if (i != 1)
        if (i != 2 && i != 3 && i != 4) {
          if (i != 5) {
            this.i.b();
            f();
          } 
        } else {
          this.o = new StateSnapshot(Service.State.f, false, paramThrowable);
          a(state, paramThrowable);
          this.i.b();
          f();
        }  
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed while in state:");
      stringBuilder.append(state);
      throw new IllegalStateException(stringBuilder.toString(), paramThrowable);
    } finally {
      this.i.b();
      f();
    } 
  }
  
  protected final void b() {
    this.i.a();
    try {
      if (this.o.a == Service.State.b) {
        if (this.o.b) {
          this.o = new StateSnapshot(Service.State.d);
          a();
        } else {
          this.o = new StateSnapshot(Service.State.c);
          g();
        } 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot notifyStarted() when the service is ");
      stringBuilder.append(this.o.a);
      IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
      a(illegalStateException);
      throw illegalStateException;
    } finally {
      this.i.b();
      f();
    } 
  }
  
  protected final void c() {
    this.i.a();
    try {
      StringBuilder stringBuilder;
      Service.State state = e();
      switch (null.a[state.ordinal()]) {
        case 2:
        case 3:
        case 4:
          this.o = new StateSnapshot(Service.State.e);
          c(state);
          break;
        case 1:
        case 5:
        case 6:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Cannot notifyStopped() when the service is ");
          stringBuilder.append(state);
          throw new IllegalStateException(stringBuilder.toString());
      } 
      return;
    } finally {
      this.i.b();
      f();
    } 
  }
  
  public final boolean d() {
    return (e() == Service.State.c);
  }
  
  public final Service.State e() {
    return this.o.a();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" [");
    stringBuilder.append(e());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  final class HasReachedRunningGuard extends Monitor.Guard {
    HasReachedRunningGuard(AbstractService this$0) {
      super(AbstractService.a(this$0));
    }
    
    public boolean a() {
      return (this.a.e().compareTo(Service.State.c) >= 0);
    }
  }
  
  final class IsStartableGuard extends Monitor.Guard {
    IsStartableGuard(AbstractService this$0) {
      super(AbstractService.a(this$0));
    }
    
    public boolean a() {
      return (this.a.e() == Service.State.a);
    }
  }
  
  final class IsStoppableGuard extends Monitor.Guard {
    IsStoppableGuard(AbstractService this$0) {
      super(AbstractService.a(this$0));
    }
    
    public boolean a() {
      return (this.a.e().compareTo(Service.State.c) <= 0);
    }
  }
  
  final class IsStoppedGuard extends Monitor.Guard {
    IsStoppedGuard(AbstractService this$0) {
      super(AbstractService.a(this$0));
    }
    
    public boolean a() {
      return this.a.e().a();
    }
  }
  
  static final class StateSnapshot {
    final Service.State a;
    
    final boolean b;
    
    @NullableDecl
    final Throwable c;
    
    StateSnapshot(Service.State param1State) {
      this(param1State, false, null);
    }
    
    StateSnapshot(Service.State param1State, boolean param1Boolean, @NullableDecl Throwable param1Throwable) {
      boolean bool1;
      boolean bool3;
      boolean bool2 = false;
      if (!param1Boolean || param1State == Service.State.b) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      Preconditions.a(bool3, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", param1State);
      if (param1Throwable != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (param1State == Service.State.f)
        bool2 = true; 
      Preconditions.a(bool2 ^ bool1 ^ 0x1, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", param1State, param1Throwable);
      this.a = param1State;
      this.b = param1Boolean;
      this.c = param1Throwable;
    }
    
    Service.State a() {
      return (this.b && this.a == Service.State.b) ? Service.State.d : this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */