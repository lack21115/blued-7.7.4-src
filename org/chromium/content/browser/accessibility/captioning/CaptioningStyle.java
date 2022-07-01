package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import android.graphics.Typeface;

@TargetApi(19)
public final class CaptioningStyle {
  Integer mBackgroundColor;
  
  Integer mEdgeColor;
  
  Integer mEdgeType;
  
  Integer mForegroundColor;
  
  Typeface mTypeface;
  
  public CaptioningStyle(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, Typeface paramTypeface) {
    this.mBackgroundColor = paramInteger1;
    this.mEdgeColor = paramInteger2;
    this.mEdgeType = paramInteger3;
    this.mForegroundColor = paramInteger4;
    this.mTypeface = paramTypeface;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\CaptioningStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */