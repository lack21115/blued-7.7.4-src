package org.chromium.android_webview;

import android.view.ViewTreeObserver;

final class ViewPositionObserver$1 implements ViewTreeObserver.OnPreDrawListener {
  public final boolean onPreDraw() {
    ViewPositionObserver.this.updatePosition();
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ViewPositionObserver$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */