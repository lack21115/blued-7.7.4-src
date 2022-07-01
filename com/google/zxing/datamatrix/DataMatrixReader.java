package com.google.zxing.datamatrix;

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
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

public final class DataMatrixReader implements Reader {
  private static final ResultPoint[] a = new ResultPoint[0];
  
  private final Decoder b = new Decoder();
  
  private static int a(int[] paramArrayOfint, BitMatrix paramBitMatrix) throws NotFoundException {
    int j = paramBitMatrix.e();
    int i = paramArrayOfint[0];
    int k = paramArrayOfint[1];
    while (i < j && paramBitMatrix.a(i, k))
      i++; 
    if (i != j) {
      i -= paramArrayOfint[0];
      if (i != 0)
        return i; 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt1 = paramBitMatrix.c();
    int[] arrayOfInt2 = paramBitMatrix.d();
    if (arrayOfInt1 != null && arrayOfInt2 != null) {
      int j = a(arrayOfInt1, paramBitMatrix);
      int k = arrayOfInt1[1];
      int i = arrayOfInt2[1];
      int m = arrayOfInt1[0];
      int n = (arrayOfInt2[0] - m + 1) / j;
      int i1 = (i - k + 1) / j;
      if (n > 0 && i1 > 0) {
        int i2 = j / 2;
        BitMatrix bitMatrix = new BitMatrix(n, i1);
        for (i = 0; i < i1; i++) {
          for (int i3 = 0; i3 < n; i3++) {
            if (paramBitMatrix.a(i3 * j + m + i2, i * j + k + i2))
              bitMatrix.b(i3, i); 
          } 
        } 
        return bitMatrix;
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    DecoderResult decoderResult;
    ResultPoint[] arrayOfResultPoint;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.b)) {
      BitMatrix bitMatrix = a(paramBinaryBitmap.c());
      decoderResult = this.b.a(bitMatrix);
      arrayOfResultPoint = a;
    } else {
      DetectorResult detectorResult = (new Detector(decoderResult.c())).a();
      decoderResult = this.b.a(detectorResult.d());
      arrayOfResultPoint = detectorResult.e();
    } 
    Result result = new Result(decoderResult.c(), decoderResult.a(), arrayOfResultPoint, BarcodeFormat.f);
    List list = decoderResult.d();
    if (list != null)
      result.a(ResultMetadataType.c, list); 
    String str = decoderResult.e();
    if (str != null)
      result.a(ResultMetadataType.d, str); 
    return result;
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\DataMatrixReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */