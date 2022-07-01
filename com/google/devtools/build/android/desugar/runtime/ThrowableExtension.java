package com.google.devtools.build.android.desugar.runtime;

import java.io.PrintStream;

public final class ThrowableExtension {
  private static ThrowableExtension$AbstractDesugaringStrategy STRATEGY;
  
  static {
    try {
      Integer integer = readApiLevelFromBuildVersion();
      if (integer != null) {
        try {
          throw new VerifyError("bad dex opcode");
        } catch (Throwable throwable) {}
      } else {
        ThrowableExtension$NullDesugaringStrategy throwableExtension$NullDesugaringStrategy;
        if ((Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true) != 0) {
          ThrowableExtension$MimicDesugaringStrategy throwableExtension$MimicDesugaringStrategy = new ThrowableExtension$MimicDesugaringStrategy();
        } else {
          throwableExtension$NullDesugaringStrategy = new ThrowableExtension$NullDesugaringStrategy();
        } 
        STRATEGY = throwableExtension$NullDesugaringStrategy;
        if (integer != null)
          throw new VerifyError("bad dex opcode"); 
        throw new VerifyError("bad dex opcode");
      } 
    } catch (Throwable throwable) {}
    PrintStream printStream = System.err;
    new StringBuilder("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
    throw new VerifyError("bad dex opcode");
  }
  
  public static void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2) {
    STRATEGY.addSuppressed(paramThrowable1, paramThrowable2);
  }
  
  public static void printStackTrace(Throwable paramThrowable) {
    STRATEGY.printStackTrace(paramThrowable);
  }
  
  private static Integer readApiLevelFromBuildVersion() {
    try {
      return (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
    } catch (Exception exception) {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      exception.printStackTrace(System.err);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\devtools\build\android\desugar\runtime\ThrowableExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */