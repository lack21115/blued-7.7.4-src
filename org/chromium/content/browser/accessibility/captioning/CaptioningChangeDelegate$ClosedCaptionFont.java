package org.chromium.content.browser.accessibility.captioning;

import android.graphics.Typeface;
import java.util.EnumSet;

public enum CaptioningChangeDelegate$ClosedCaptionFont {
  CASUAL,
  CURSIVE,
  DEFAULT(""),
  MONOSPACE(""),
  SANS_SERIF("sans-serif"),
  SANS_SERIF_CONDENSED("sans-serif-condensed"),
  SANS_SERIF_MONOSPACE("sans-serif-monospace"),
  SANS_SERIF_SMALLCAPS("sans-serif-monospace"),
  SERIF("serif"),
  SERIF_MONOSPACE("serif-monospace");
  
  final String mFontFamily;
  
  static {
    EnumSet.noneOf(CaptioningChangeDelegate$ClosedCaptionFont$Flags.class);
    CASUAL = new CaptioningChangeDelegate$ClosedCaptionFont("CASUAL", 6, "casual");
    EnumSet.noneOf(CaptioningChangeDelegate$ClosedCaptionFont$Flags.class);
    CURSIVE = new CaptioningChangeDelegate$ClosedCaptionFont("CURSIVE", 7, "cursive");
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SANS_SERIF);
    SANS_SERIF_SMALLCAPS = new CaptioningChangeDelegate$ClosedCaptionFont("SANS_SERIF_SMALLCAPS", 8, "sans-serif-smallcaps");
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.MONOSPACE);
    MONOSPACE = new CaptioningChangeDelegate$ClosedCaptionFont("MONOSPACE", 9, "monospace");
    $VALUES = new CaptioningChangeDelegate$ClosedCaptionFont[] { DEFAULT, SANS_SERIF, SANS_SERIF_CONDENSED, SANS_SERIF_MONOSPACE, SERIF, SERIF_MONOSPACE, CASUAL, CURSIVE, SANS_SERIF_SMALLCAPS, MONOSPACE };
    throw new VerifyError("bad dex opcode");
  }
  
  CaptioningChangeDelegate$ClosedCaptionFont(String paramString1) {
    this.mFontFamily = paramString1;
  }
  
  public static CaptioningChangeDelegate$ClosedCaptionFont fromSystemFont(Typeface paramTypeface) {
    if (paramTypeface == null)
      return DEFAULT; 
    for (CaptioningChangeDelegate$ClosedCaptionFont captioningChangeDelegate$ClosedCaptionFont : values()) {
      if (Typeface.create(captioningChangeDelegate$ClosedCaptionFont.mFontFamily, paramTypeface.getStyle()).equals(paramTypeface))
        return captioningChangeDelegate$ClosedCaptionFont; 
    } 
    return DEFAULT;
  }
  
  static {
    EnumSet.noneOf(CaptioningChangeDelegate$ClosedCaptionFont$Flags.class);
  }
  
  static {
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SANS_SERIF);
  }
  
  static {
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SANS_SERIF);
  }
  
  static {
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SANS_SERIF, CaptioningChangeDelegate$ClosedCaptionFont$Flags.MONOSPACE);
  }
  
  static {
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SERIF);
  }
  
  static {
    EnumSet.of(CaptioningChangeDelegate$ClosedCaptionFont$Flags.SERIF, CaptioningChangeDelegate$ClosedCaptionFont$Flags.MONOSPACE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\CaptioningChangeDelegate$ClosedCaptionFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */