package org.chromium.content.browser.accessibility.captioning;

import android.view.accessibility.CaptioningManager;
import java.util.Locale;

final class KitKatCaptioningBridge$KitKatCaptioningChangeListener extends CaptioningManager.CaptioningChangeListener {
  private KitKatCaptioningBridge$KitKatCaptioningChangeListener() {}
  
  public final void onEnabledChanged(boolean paramBoolean) {
    KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onEnabledChanged(paramBoolean);
  }
  
  public final void onFontScaleChanged(float paramFloat) {
    KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onFontScaleChanged(paramFloat);
  }
  
  public final void onLocaleChanged(Locale paramLocale) {}
  
  public final void onUserStyleChanged(CaptioningManager.CaptionStyle paramCaptionStyle) {
    CaptioningStyle captioningStyle = KitKatCaptioningBridge.getCaptioningStyleFrom(paramCaptionStyle);
    KitKatCaptioningBridge.this.mCaptioningChangeDelegate.onUserStyleChanged(captioningStyle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\KitKatCaptioningBridge$KitKatCaptioningChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */