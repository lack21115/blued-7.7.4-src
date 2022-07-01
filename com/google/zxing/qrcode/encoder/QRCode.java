package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;

public final class QRCode {
  private Mode a;
  
  private ErrorCorrectionLevel b;
  
  private Version c;
  
  private int d = -1;
  
  private ByteMatrix e;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(200);
    stringBuilder.append("<<\n");
    stringBuilder.append(" mode: ");
    stringBuilder.append(this.a);
    stringBuilder.append("\n ecLevel: ");
    stringBuilder.append(this.b);
    stringBuilder.append("\n version: ");
    stringBuilder.append(this.c);
    stringBuilder.append("\n maskPattern: ");
    stringBuilder.append(this.d);
    if (this.e == null) {
      stringBuilder.append("\n matrix: null\n");
    } else {
      stringBuilder.append("\n matrix:\n");
      stringBuilder.append(this.e);
    } 
    stringBuilder.append(">>\n");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\encoder\QRCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */