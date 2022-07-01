package com.google.zxing.multi.qrcode;

import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.Serializable;
import java.util.Comparator;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
  private static final Result[] a = new Result[0];
  
  private static final ResultPoint[] b = new ResultPoint[0];
  
  static final class SAComparator implements Serializable, Comparator<Result> {
    public int a(Result param1Result1, Result param1Result2) {
      return Integer.compare(((Integer)param1Result1.e().get(ResultMetadataType.j)).intValue(), ((Integer)param1Result2.e().get(ResultMetadataType.j)).intValue());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\multi\qrcode\QRCodeMultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */