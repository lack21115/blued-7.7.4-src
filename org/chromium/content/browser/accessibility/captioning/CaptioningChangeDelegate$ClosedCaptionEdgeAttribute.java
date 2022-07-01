package org.chromium.content.browser.accessibility.captioning;

public enum CaptioningChangeDelegate$ClosedCaptionEdgeAttribute {
  DEPRESSED,
  DROP_SHADOW,
  NONE(""),
  OUTLINE("%2$s %2$s 0 %1$s, -%2$s -%2$s 0 %1$s, %2$s -%2$s 0 %1$s, -%2$s %2$s 0 %1$s"),
  RAISED("%2$s %2$s 0 %1$s, -%2$s -%2$s 0 %1$s, %2$s -%2$s 0 %1$s, -%2$s %2$s 0 %1$s");
  
  private static String sDefaultEdgeColor;
  
  static String sEdgeColor;
  
  static String sShadowOffset;
  
  final String mTextShadow;
  
  static {
    DROP_SHADOW = new CaptioningChangeDelegate$ClosedCaptionEdgeAttribute("DROP_SHADOW", 2, "%1$s %2$s %2$s 0.1em");
    RAISED = new CaptioningChangeDelegate$ClosedCaptionEdgeAttribute("RAISED", 3, "-%2$s -%2$s 0 %1$s");
    DEPRESSED = new CaptioningChangeDelegate$ClosedCaptionEdgeAttribute("DEPRESSED", 4, "%2$s %2$s 0 %1$s");
    $VALUES = new CaptioningChangeDelegate$ClosedCaptionEdgeAttribute[] { NONE, OUTLINE, DROP_SHADOW, RAISED, DEPRESSED };
    sDefaultEdgeColor = "silver";
    sShadowOffset = "0.05em";
    throw new VerifyError("bad dex opcode");
  }
  
  CaptioningChangeDelegate$ClosedCaptionEdgeAttribute(String paramString1) {
    this.mTextShadow = paramString1;
  }
  
  public static CaptioningChangeDelegate$ClosedCaptionEdgeAttribute fromSystemEdgeAttribute(Integer paramInteger, String paramString) {
    if (paramInteger == null)
      return NONE; 
    if (paramString == null || paramString.isEmpty()) {
      sEdgeColor = sDefaultEdgeColor;
    } else {
      sEdgeColor = paramString;
    } 
    switch (paramInteger.intValue()) {
      default:
        return NONE;
      case 4:
        return DEPRESSED;
      case 3:
        return RAISED;
      case 2:
        return DROP_SHADOW;
      case 1:
        break;
    } 
    return OUTLINE;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\CaptioningChangeDelegate$ClosedCaptionEdgeAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */