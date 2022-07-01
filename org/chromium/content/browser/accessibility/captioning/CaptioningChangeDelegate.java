package org.chromium.content.browser.accessibility.captioning;

import android.graphics.Color;
import android.graphics.Typeface;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

public final class CaptioningChangeDelegate {
  final Map mListeners = new WeakHashMap<Object, Object>();
  
  private String mTextTrackBackgroundColor;
  
  private String mTextTrackFontFamily;
  
  private String mTextTrackFontStyle;
  
  private String mTextTrackFontVariant;
  
  private String mTextTrackTextColor;
  
  private String mTextTrackTextShadow;
  
  private String mTextTrackTextSize;
  
  private boolean mTextTracksEnabled;
  
  private static String androidColorToCssColor(Integer paramInteger) {
    if (paramInteger == null)
      return ""; 
    String str = (new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US))).format(Color.alpha(paramInteger.intValue()) / 255.0D);
    return String.format("rgba(%s, %s, %s, %s)", new Object[] { Integer.valueOf(Color.red(paramInteger.intValue())), Integer.valueOf(Color.green(paramInteger.intValue())), Integer.valueOf(Color.blue(paramInteger.intValue())), str });
  }
  
  private void notifySettingsChanged() {
    Iterator<SystemCaptioningBridge$SystemCaptioningBridgeListener> iterator = this.mListeners.keySet().iterator();
    while (iterator.hasNext())
      notifyListener(iterator.next()); 
  }
  
  public final boolean hasActiveListener() {
    return !this.mListeners.isEmpty();
  }
  
  public final void notifyListener(SystemCaptioningBridge$SystemCaptioningBridgeListener paramSystemCaptioningBridge$SystemCaptioningBridgeListener) {
    if (this.mTextTracksEnabled) {
      paramSystemCaptioningBridge$SystemCaptioningBridgeListener.onSystemCaptioningChanged(new TextTrackSettings(this.mTextTracksEnabled, this.mTextTrackBackgroundColor, this.mTextTrackFontFamily, this.mTextTrackFontStyle, this.mTextTrackFontVariant, this.mTextTrackTextColor, this.mTextTrackTextShadow, this.mTextTrackTextSize));
      return;
    } 
    paramSystemCaptioningBridge$SystemCaptioningBridgeListener.onSystemCaptioningChanged(new TextTrackSettings());
  }
  
  public final void onEnabledChanged(boolean paramBoolean) {
    this.mTextTracksEnabled = paramBoolean;
    notifySettingsChanged();
  }
  
  public final void onFontScaleChanged(float paramFloat) {
    this.mTextTrackTextSize = (new DecimalFormat("#%", new DecimalFormatSymbols(Locale.US))).format(paramFloat);
    notifySettingsChanged();
  }
  
  public final void onUserStyleChanged(CaptioningStyle paramCaptioningStyle) {
    this.mTextTrackTextColor = androidColorToCssColor(paramCaptioningStyle.mForegroundColor);
    this.mTextTrackBackgroundColor = androidColorToCssColor(paramCaptioningStyle.mBackgroundColor);
    this.mTextTrackTextShadow = String.format((CaptioningChangeDelegate$ClosedCaptionEdgeAttribute.fromSystemEdgeAttribute(paramCaptioningStyle.mEdgeType, androidColorToCssColor(paramCaptioningStyle.mEdgeColor))).mTextShadow, new Object[] { CaptioningChangeDelegate$ClosedCaptionEdgeAttribute.sEdgeColor, CaptioningChangeDelegate$ClosedCaptionEdgeAttribute.sShadowOffset });
    Typeface typeface = paramCaptioningStyle.mTypeface;
    this.mTextTrackFontFamily = (CaptioningChangeDelegate$ClosedCaptionFont.fromSystemFont(typeface)).mFontFamily;
    if (typeface != null && typeface.isItalic()) {
      this.mTextTrackFontStyle = "italic";
    } else {
      this.mTextTrackFontStyle = "";
    } 
    this.mTextTrackFontVariant = "";
    notifySettingsChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\CaptioningChangeDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */