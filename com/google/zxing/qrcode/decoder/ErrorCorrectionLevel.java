package com.google.zxing.qrcode.decoder;

public enum ErrorCorrectionLevel {
  a(1),
  b(0),
  c(3),
  d(2);
  
  private static final ErrorCorrectionLevel[] e;
  
  private final int f;
  
  static {
    ErrorCorrectionLevel errorCorrectionLevel1 = a;
    ErrorCorrectionLevel errorCorrectionLevel2 = b;
    ErrorCorrectionLevel errorCorrectionLevel3 = c;
    ErrorCorrectionLevel errorCorrectionLevel4 = d;
    g = new ErrorCorrectionLevel[] { errorCorrectionLevel1, errorCorrectionLevel2, errorCorrectionLevel3, errorCorrectionLevel4 };
    e = new ErrorCorrectionLevel[] { errorCorrectionLevel2, errorCorrectionLevel1, errorCorrectionLevel4, errorCorrectionLevel3 };
  }
  
  ErrorCorrectionLevel(int paramInt1) {
    this.f = paramInt1;
  }
  
  public static ErrorCorrectionLevel a(int paramInt) {
    if (paramInt >= 0) {
      ErrorCorrectionLevel[] arrayOfErrorCorrectionLevel = e;
      if (paramInt < arrayOfErrorCorrectionLevel.length)
        return arrayOfErrorCorrectionLevel[paramInt]; 
    } 
    throw new IllegalArgumentException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\ErrorCorrectionLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */