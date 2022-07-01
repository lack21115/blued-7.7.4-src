package org.chromium.android_webview;

import org.chromium.ui.display.DisplayAndroid;

final class AwContents$AwDisplayAndroidObserver implements DisplayAndroid.DisplayAndroidObserver {
  private AwContents$AwDisplayAndroidObserver() {}
  
  public final void onDIPScaleChanged(float paramFloat) {
    AwContents.access$2400(AwContents.this, AwContents.access$1000(AwContents.this), paramFloat);
    AwLayoutSizer awLayoutSizer = AwContents.access$1500(AwContents.this);
    double d = paramFloat;
    awLayoutSizer.mDIPScale = d;
    null = AwContents.access$300(AwContents.this);
    synchronized (null.mAwSettingsLock) {
      null.mDIPScale = d;
      return;
    } 
  }
  
  public final void onRotationChanged(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwDisplayAndroidObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */