package org.chromium.android_webview;

import android.graphics.Canvas;
import android.view.View;

public interface AwContents$NativeDrawGLFunctor {
  void detach(View paramView);
  
  Runnable getDestroyRunnable();
  
  boolean requestDrawGL(Canvas paramCanvas, Runnable paramRunnable);
  
  boolean requestInvokeGL(View paramView, boolean paramBoolean);
  
  boolean supportsDrawGLFunctorReleasedCallback();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$NativeDrawGLFunctor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */