package org.chromium.android_webview;

final class AwContents$AwLayoutSizerDelegate implements AwLayoutSizer$Delegate {
  private AwContents$AwLayoutSizerDelegate() {}
  
  public final boolean isLayoutParamsHeightWrapContent() {
    return (AwContents.access$700(AwContents.this).getLayoutParams() != null && (AwContents.access$700(AwContents.this).getLayoutParams()).height == -2);
  }
  
  public final void requestLayout() {
    AwContents.access$700(AwContents.this).requestLayout();
  }
  
  public final void setForceZeroLayoutHeight(boolean paramBoolean) {
    null = AwContents.this.mSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mForceZeroLayoutHeight != paramBoolean) {
        null.mForceZeroLayoutHeight = paramBoolean;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public final void setMeasuredDimension(int paramInt1, int paramInt2) {
    AwContents.access$800(AwContents.this).setMeasuredDimension(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$AwLayoutSizerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */