package org.chromium.base;

final class ThrowUncaughtException$1 implements Runnable {
  public final void run() {
    throw new RuntimeException("Intentional exception not caught by JNI");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ThrowUncaughtException$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */