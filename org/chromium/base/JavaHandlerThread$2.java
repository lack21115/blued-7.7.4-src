package org.chromium.base;

final class JavaHandlerThread$2 implements Runnable {
  public final void run() {
    JavaHandlerThread.access$100(JavaHandlerThread.this).quit();
    JavaHandlerThread.access$200(JavaHandlerThread.this, nativeThread);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\JavaHandlerThread$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */