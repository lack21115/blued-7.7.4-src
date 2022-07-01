package com.google.devtools.build.android.desugar.runtime;

final class ThrowableExtension$ReuseDesugaringStrategy extends ThrowableExtension$AbstractDesugaringStrategy {
  public final void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2) {}
  
  public final void printStackTrace(Throwable paramThrowable) {
    paramThrowable.printStackTrace();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\devtools\build\android\desugar\runtime\ThrowableExtension$ReuseDesugaringStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */