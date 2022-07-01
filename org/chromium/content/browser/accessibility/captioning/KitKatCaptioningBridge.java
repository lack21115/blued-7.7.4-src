package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.accessibility.CaptioningManager;
import org.chromium.base.ContextUtils;

@TargetApi(19)
public final class KitKatCaptioningBridge implements SystemCaptioningBridge {
  static KitKatCaptioningBridge sKitKatCaptioningBridge;
  
  final CaptioningChangeDelegate mCaptioningChangeDelegate = new CaptioningChangeDelegate();
  
  private final CaptioningManager.CaptioningChangeListener mCaptioningChangeListener = new KitKatCaptioningBridge$KitKatCaptioningChangeListener(this, (byte)0);
  
  private final CaptioningManager mCaptioningManager = (CaptioningManager)ContextUtils.sApplicationContext.getSystemService("captioning");
  
  static CaptioningStyle getCaptioningStyleFrom(CaptioningManager.CaptionStyle paramCaptionStyle) {
    Integer integer1;
    Integer integer2;
    Integer integer3;
    Integer integer4;
    if (paramCaptionStyle == null)
      return new CaptioningStyle(null, null, null, null, null); 
    if (Build.VERSION.SDK_INT >= 21) {
      Object object1;
      Object object2;
      Object object3;
      boolean bool = paramCaptionStyle.hasBackgroundColor();
      Integer integer = null;
      if (bool) {
        object1 = Integer.valueOf(paramCaptionStyle.backgroundColor);
      } else {
        object1 = null;
      } 
      if (paramCaptionStyle.hasEdgeColor()) {
        object2 = Integer.valueOf(paramCaptionStyle.edgeColor);
      } else {
        object2 = null;
      } 
      if (paramCaptionStyle.hasEdgeType()) {
        object3 = Integer.valueOf(paramCaptionStyle.edgeType);
      } else {
        object3 = null;
      } 
      if (paramCaptionStyle.hasForegroundColor())
        integer = Integer.valueOf(paramCaptionStyle.foregroundColor); 
      integer4 = (Integer)object1;
      integer3 = integer;
      integer2 = (Integer)object2;
      integer1 = (Integer)object3;
      if (paramCaptionStyle.hasWindowColor()) {
        int i = paramCaptionStyle.windowColor;
        integer4 = (Integer)object1;
        integer3 = integer;
        integer2 = (Integer)object2;
        integer1 = (Integer)object3;
      } 
    } else {
      integer4 = Integer.valueOf(paramCaptionStyle.backgroundColor);
      integer2 = Integer.valueOf(paramCaptionStyle.edgeColor);
      integer1 = Integer.valueOf(paramCaptionStyle.edgeType);
      integer3 = Integer.valueOf(paramCaptionStyle.foregroundColor);
    } 
    return new CaptioningStyle(integer4, integer2, integer1, integer3, paramCaptionStyle.getTypeface());
  }
  
  private void syncToDelegate() {
    this.mCaptioningChangeDelegate.onEnabledChanged(this.mCaptioningManager.isEnabled());
    this.mCaptioningChangeDelegate.onFontScaleChanged(this.mCaptioningManager.getFontScale());
    this.mCaptioningManager.getLocale();
    this.mCaptioningChangeDelegate.onUserStyleChanged(getCaptioningStyleFrom(this.mCaptioningManager.getUserStyle()));
  }
  
  public final void addListener(SystemCaptioningBridge$SystemCaptioningBridgeListener paramSystemCaptioningBridge$SystemCaptioningBridgeListener) {
    if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
      this.mCaptioningManager.addCaptioningChangeListener(this.mCaptioningChangeListener);
      syncToDelegate();
    } 
    this.mCaptioningChangeDelegate.mListeners.put(paramSystemCaptioningBridge$SystemCaptioningBridgeListener, null);
    this.mCaptioningChangeDelegate.notifyListener(paramSystemCaptioningBridge$SystemCaptioningBridgeListener);
  }
  
  public final void removeListener(SystemCaptioningBridge$SystemCaptioningBridgeListener paramSystemCaptioningBridge$SystemCaptioningBridgeListener) {
    this.mCaptioningChangeDelegate.mListeners.remove(paramSystemCaptioningBridge$SystemCaptioningBridgeListener);
    if (!this.mCaptioningChangeDelegate.hasActiveListener())
      this.mCaptioningManager.removeCaptioningChangeListener(this.mCaptioningChangeListener); 
  }
  
  public final void syncToListener(SystemCaptioningBridge$SystemCaptioningBridgeListener paramSystemCaptioningBridge$SystemCaptioningBridgeListener) {
    if (!this.mCaptioningChangeDelegate.hasActiveListener())
      syncToDelegate(); 
    this.mCaptioningChangeDelegate.notifyListener(paramSystemCaptioningBridge$SystemCaptioningBridgeListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\KitKatCaptioningBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */