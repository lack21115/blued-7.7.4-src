package com.google.zxing.maxicode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

public final class MaxiCodeReader implements Reader {
  private static final ResultPoint[] a = new ResultPoint[0];
  
  private final Decoder b = new Decoder();
  
  private static BitMatrix a(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt = paramBitMatrix.b();
    if (arrayOfInt != null) {
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      int m = arrayOfInt[2];
      int n = arrayOfInt[3];
      BitMatrix bitMatrix = new BitMatrix(30, 33);
      for (int i = 0; i < 33; i++) {
        int i2 = (i * n + n / 2) / 33;
        for (int i1 = 0; i1 < 30; i1++) {
          if (paramBitMatrix.a((i1 * m + m / 2 + (i & 0x1) * m / 2) / 30 + j, i2 + k))
            bitMatrix.b(i1, i); 
        } 
      } 
      return bitMatrix;
    } 
    throw NotFoundException.a();
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    if (paramMap != null && paramMap.containsKey(DecodeHintType.b)) {
      BitMatrix bitMatrix = a(paramBinaryBitmap.c());
      DecoderResult decoderResult = this.b.a(bitMatrix, paramMap);
      Result result = new Result(decoderResult.c(), decoderResult.a(), a, BarcodeFormat.j);
      String str = decoderResult.e();
      if (str != null)
        result.a(ResultMetadataType.d, str); 
      return result;
    } 
    throw NotFoundException.a();
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\maxicode\MaxiCodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */