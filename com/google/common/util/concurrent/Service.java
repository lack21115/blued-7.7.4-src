package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Create an AbstractIdleService")
public interface Service {
  State e();
  
  public static abstract class Listener {
    public void a() {}
    
    public void a(Service.State param1State) {}
    
    public void a(Service.State param1State, Throwable param1Throwable) {}
    
    public void b() {}
    
    public void b(Service.State param1State) {}
  }
  
  public enum State {
    a {
      boolean a() {
        return false;
      }
    },
    b {
      boolean a() {
        return false;
      }
    },
    c {
      boolean a() {
        return false;
      }
    },
    d {
      boolean a() {
        return false;
      }
    },
    e {
      boolean a() {
        return true;
      }
    },
    f {
      boolean a() {
        return true;
      }
    };
    
    abstract boolean a();
  }
  
  enum null {
    boolean a() {
      return false;
    }
  }
  
  enum null {
    boolean a() {
      return false;
    }
  }
  
  enum null {
    boolean a() {
      return false;
    }
  }
  
  enum null {
    boolean a() {
      return false;
    }
  }
  
  enum null {
    boolean a() {
      return true;
    }
  }
  
  enum null {
    boolean a() {
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */