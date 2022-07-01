package com.android.webview.chromium;

import android.graphics.Canvas;
import android.view.View;
import org.chromium.android_webview.AwContents;

class DrawGLFunctor implements AwContents.NativeDrawGLFunctor {
  private static final boolean sSupportFunctorReleasedCallback = false;
  
  private final DrawGLFunctor$DestroyRunnable mDestroyRunnable;
  
  private final WebViewDelegateFactory$WebViewDelegate mWebViewDelegate;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public DrawGLFunctor(long paramLong, WebViewDelegateFactory$WebViewDelegate paramWebViewDelegateFactory$WebViewDelegate) {
    this.mDestroyRunnable = new DrawGLFunctor$DestroyRunnable(nativeCreateGLFunctor(paramLong));
    this.mWebViewDelegate = paramWebViewDelegateFactory$WebViewDelegate;
  }
  
  private static native long nativeCreateGLFunctor(long paramLong);
  
  private static native void nativeDestroyGLFunctor(long paramLong);
  
  private static native void nativeSetChromiumAwDrawGLFunction(long paramLong);
  
  public static void setChromiumAwDrawGLFunction(long paramLong) {
    nativeSetChromiumAwDrawGLFunction(paramLong);
  }
  
  public final void detach(View paramView) {
    if (DrawGLFunctor$DestroyRunnable.access$000(this.mDestroyRunnable) != 0L) {
      this.mWebViewDelegate.detachDrawGlFunctor(paramView, DrawGLFunctor$DestroyRunnable.access$000(this.mDestroyRunnable));
      return;
    } 
    throw new RuntimeException("detach on already destroyed DrawGLFunctor");
  }
  
  public final Runnable getDestroyRunnable() {
    return this.mDestroyRunnable;
  }
  
  public final boolean requestDrawGL(Canvas paramCanvas, Runnable paramRunnable) {
    if (DrawGLFunctor$DestroyRunnable.access$000(this.mDestroyRunnable) != 0L) {
      assert false;
      throw new AssertionError();
    } 
    throw new RuntimeException("requestDrawGL on already destroyed DrawGLFunctor");
  }
  
  public final boolean requestInvokeGL(View paramView, boolean paramBoolean) {
    if (DrawGLFunctor$DestroyRunnable.access$000(this.mDestroyRunnable) != 0L) {
      if (!sSupportFunctorReleasedCallback && !this.mWebViewDelegate.canInvokeDrawGlFunctor(paramView))
        return false; 
      this.mWebViewDelegate.invokeDrawGlFunctor(paramView, DrawGLFunctor$DestroyRunnable.access$000(this.mDestroyRunnable), paramBoolean);
      return true;
    } 
    throw new RuntimeException("requestInvokeGL on already destroyed DrawGLFunctor");
  }
  
  public final boolean supportsDrawGLFunctorReleasedCallback() {
    return sSupportFunctorReleasedCallback;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\DrawGLFunctor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */