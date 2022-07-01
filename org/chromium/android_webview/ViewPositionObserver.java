package org.chromium.android_webview;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

public final class ViewPositionObserver {
  final ArrayList mListeners;
  
  final int[] mPosition = new int[2];
  
  private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
  
  private View mView;
  
  public ViewPositionObserver(View paramView) {
    this.mView = paramView;
    this.mListeners = new ArrayList();
    updatePosition();
    this.mPreDrawListener = new ViewPositionObserver$1(this);
  }
  
  public final void addListener(ViewPositionObserver$Listener paramViewPositionObserver$Listener) {
    if (this.mListeners.contains(paramViewPositionObserver$Listener))
      return; 
    if (this.mListeners.isEmpty()) {
      this.mView.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
      updatePosition();
    } 
    this.mListeners.add(paramViewPositionObserver$Listener);
  }
  
  final void updatePosition() {
    int i = this.mPosition[0];
    int j = this.mPosition[1];
    this.mView.getLocationInWindow(this.mPosition);
    if (this.mPosition[0] != i || this.mPosition[1] != j)
      for (i = 0; i < this.mListeners.size(); i++)
        ((ViewPositionObserver$Listener)this.mListeners.get(i)).onPositionChanged(this.mPosition[0], this.mPosition[1]);  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ViewPositionObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */