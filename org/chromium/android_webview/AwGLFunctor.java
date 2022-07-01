package org.chromium.android_webview;

import android.view.View;
import android.view.ViewGroup;
import org.chromium.base.annotations.CalledByNative;

public class AwGLFunctor {
  private final ViewGroup mContainerView;
  
  final Runnable mFunctorReleasedCallback;
  
  private final Object mLifetimeObject;
  
  final long mNativeAwGLFunctor = nativeCreate(this);
  
  final AwContents$NativeDrawGLFunctor mNativeDrawGLFunctor;
  
  private int mRefCount;
  
  public AwGLFunctor(AwContents$NativeDrawGLFunctorFactory paramAwContents$NativeDrawGLFunctorFactory, ViewGroup paramViewGroup) {
    this.mNativeDrawGLFunctor = paramAwContents$NativeDrawGLFunctorFactory.createFunctor(nativeGetAwDrawGLViewContext(this.mNativeAwGLFunctor));
    this.mLifetimeObject = new Object();
    new CleanupReference(this.mLifetimeObject, new AwGLFunctor$DestroyRunnable(this.mNativeAwGLFunctor, this.mNativeDrawGLFunctor.getDestroyRunnable(), (byte)0));
    this.mContainerView = paramViewGroup;
    if (this.mNativeDrawGLFunctor.supportsDrawGLFunctorReleasedCallback()) {
      this.mFunctorReleasedCallback = new AwGLFunctor$$Lambda$0(this);
      return;
    } 
    this.mFunctorReleasedCallback = null;
  }
  
  @CalledByNative
  private void detachFunctorFromView() {
    this.mNativeDrawGLFunctor.detach((View)this.mContainerView);
    this.mContainerView.invalidate();
  }
  
  public static long getAwDrawGLFunction() {
    return nativeGetAwDrawGLFunction();
  }
  
  private static native long nativeCreate(AwGLFunctor paramAwGLFunctor);
  
  private native void nativeDeleteHardwareRenderer(long paramLong);
  
  private static native void nativeDestroy(long paramLong);
  
  private static native long nativeGetAwDrawGLFunction();
  
  private native long nativeGetAwDrawGLViewContext(long paramLong);
  
  private static native int nativeGetNativeInstanceCount();
  
  @CalledByNative
  private boolean requestInvokeGL(boolean paramBoolean) {
    return this.mNativeDrawGLFunctor.requestInvokeGL((View)this.mContainerView, paramBoolean);
  }
  
  final void addReference() {
    this.mRefCount++;
  }
  
  public final void deleteHardwareRenderer() {
    nativeDeleteHardwareRenderer(this.mNativeAwGLFunctor);
  }
  
  final void removeReference() {
    int i = this.mRefCount - 1;
    this.mRefCount = i;
    if (i == 0)
      deleteHardwareRenderer(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwGLFunctor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */