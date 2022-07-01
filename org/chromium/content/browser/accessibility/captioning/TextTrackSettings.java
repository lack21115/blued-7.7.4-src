package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;

@TargetApi(19)
public final class TextTrackSettings {
  String mTextTrackBackgroundColor;
  
  String mTextTrackFontFamily;
  
  String mTextTrackFontStyle;
  
  String mTextTrackFontVariant;
  
  String mTextTrackTextColor;
  
  String mTextTrackTextShadow;
  
  String mTextTrackTextSize;
  
  boolean mTextTracksEnabled;
  
  public TextTrackSettings() {}
  
  public TextTrackSettings(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.mTextTracksEnabled = paramBoolean;
    this.mTextTrackBackgroundColor = paramString1;
    this.mTextTrackFontFamily = paramString2;
    this.mTextTrackFontStyle = paramString3;
    this.mTextTrackFontVariant = paramString4;
    this.mTextTrackTextColor = paramString5;
    this.mTextTrackTextShadow = paramString6;
    this.mTextTrackTextSize = paramString7;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\TextTrackSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */