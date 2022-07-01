package org.chromium.android_webview;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.MotionEvent;

final class FullScreenView$InternalAccessAdapter implements AwContents$InternalAccessDelegate {
  private FullScreenView$InternalAccessAdapter() {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    FullScreenView.this.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean) {
    FullScreenView.access$500(FullScreenView.this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2) {
    FullScreenView.access$700(FullScreenView.this, paramInt1, paramInt2);
  }
  
  public final boolean super_dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return FullScreenView.access$201(FullScreenView.this, paramKeyEvent);
  }
  
  public final int super_getScrollBarStyle() {
    return FullScreenView.access$401(FullScreenView.this);
  }
  
  public final boolean super_onGenericMotionEvent(MotionEvent paramMotionEvent) {
    return FullScreenView.access$301(FullScreenView.this, paramMotionEvent);
  }
  
  public final boolean super_onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    return FullScreenView.access$101(FullScreenView.this, paramInt, paramKeyEvent);
  }
  
  public final void super_scrollTo(int paramInt1, int paramInt2) {
    FullScreenView.access$601(FullScreenView.this, paramInt1, paramInt2);
  }
  
  public final void super_startActivityForResult(Intent paramIntent, int paramInt) {
    throw new RuntimeException("FullScreenView InternalAccessAdapter shouldn't call startActivityForResult. See AwContents#startActivityForResult");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\FullScreenView$InternalAccessAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */