package com.google.common.cache;

public enum RemovalCause {
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
      return true;
    }
  },
  d {
    boolean a() {
      return true;
    }
  },
  e {
    boolean a() {
      return true;
    }
  };
  
  abstract boolean a();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\RemovalCause.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */