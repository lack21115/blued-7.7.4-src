package com.google.common.util.concurrent;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class UncaughtExceptionHandlers {
  static final class Exiter implements Thread.UncaughtExceptionHandler {
    private static final Logger a = Logger.getLogger(Exiter.class.getName());
    
    private final Runtime b;
    
    public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {
      try {
        a.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[] { param1Thread }), param1Throwable);
      } finally {
        param1Thread = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\UncaughtExceptionHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */