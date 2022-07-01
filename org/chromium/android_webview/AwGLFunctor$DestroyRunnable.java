package org.chromium.android_webview;

final class AwGLFunctor$DestroyRunnable implements Runnable {
  private final long mNativeAwGLFunctor;
  
  private final Runnable mNativeDrawGLFunctorDestroyRunnable;
  
  private AwGLFunctor$DestroyRunnable(long paramLong, Runnable paramRunnable) {
    this.mNativeAwGLFunctor = paramLong;
    this.mNativeDrawGLFunctorDestroyRunnable = paramRunnable;
  }
  
  public final void run() {
    this.mNativeDrawGLFunctorDestroyRunnable.run();
    AwGLFunctor.access$000(this.mNativeAwGLFunctor);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwGLFunctor$DestroyRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */