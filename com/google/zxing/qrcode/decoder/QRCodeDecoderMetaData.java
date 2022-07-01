package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

public final class QRCodeDecoderMetaData {
  private final boolean a;
  
  QRCodeDecoderMetaData(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public void a(ResultPoint[] paramArrayOfResultPoint) {
    if (this.a && paramArrayOfResultPoint != null) {
      if (paramArrayOfResultPoint.length < 3)
        return; 
      ResultPoint resultPoint = paramArrayOfResultPoint[0];
      paramArrayOfResultPoint[0] = paramArrayOfResultPoint[2];
      paramArrayOfResultPoint[2] = resultPoint;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\QRCodeDecoderMetaData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */