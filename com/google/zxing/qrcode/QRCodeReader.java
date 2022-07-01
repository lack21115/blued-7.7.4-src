package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader implements Reader {
  private static final ResultPoint[] a = new ResultPoint[0];
  
  private final Decoder b = new Decoder();
  
  private static float a(int[] paramArrayOfint, BitMatrix paramBitMatrix) throws NotFoundException {
    int m = paramBitMatrix.f();
    int n = paramBitMatrix.e();
    int j = paramArrayOfint[0];
    boolean bool = true;
    int i = paramArrayOfint[1];
    int k;
    for (k = 0; j < n && i < m; k = i1) {
      int i3;
      boolean bool1 = bool;
      int i1 = k;
      if (bool != paramBitMatrix.a(j, i)) {
        i1 = k + 1;
        if (i1 != 5) {
          i3 = bool ^ true;
        } else {
          break;
        } 
      } 
      j++;
      i++;
      int i2 = i3;
    } 
    if (j != n && i != m)
      return (j - paramArrayOfint[0]) / 7.0F; 
    throw NotFoundException.a();
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix) throws NotFoundException {
    int[] arrayOfInt1 = paramBitMatrix.c();
    int[] arrayOfInt2 = paramBitMatrix.d();
    if (arrayOfInt1 != null && arrayOfInt2 != null) {
      float f = a(arrayOfInt1, paramBitMatrix);
      int j = arrayOfInt1[1];
      int k = arrayOfInt2[1];
      int m = arrayOfInt1[0];
      int i = arrayOfInt2[0];
      if (m < i && j < k) {
        int i2 = k - j;
        int n = i;
        if (i2 != i - m) {
          n = m + i2;
          if (n >= paramBitMatrix.e())
            throw NotFoundException.a(); 
        } 
        int i1 = Math.round((n - m + 1) / f);
        i2 = Math.round((i2 + 1) / f);
        if (i1 > 0 && i2 > 0) {
          if (i2 == i1) {
            int i3 = (int)(f / 2.0F);
            j += i3;
            i = m + i3;
            m = (int)((i1 - 1) * f) + i - n;
            n = i;
            if (m > 0)
              if (m <= i3) {
                n = i - m;
              } else {
                throw NotFoundException.a();
              }  
            k = (int)((i2 - 1) * f) + j - k;
            i = j;
            if (k > 0)
              if (k <= i3) {
                i = j - k;
              } else {
                throw NotFoundException.a();
              }  
            BitMatrix bitMatrix = new BitMatrix(i1, i2);
            for (j = 0; j < i2; j++) {
              i3 = (int)(j * f);
              for (k = 0; k < i1; k++) {
                if (paramBitMatrix.a((int)(k * f) + n, i3 + i))
                  bitMatrix.b(k, j); 
              } 
            } 
            return bitMatrix;
          } 
          throw NotFoundException.a();
        } 
        throw NotFoundException.a();
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
  
  public final Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    DecoderResult decoderResult;
    ResultPoint[] arrayOfResultPoint;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.b)) {
      BitMatrix bitMatrix = a(paramBinaryBitmap.c());
      decoderResult = this.b.a(bitMatrix, paramMap);
      arrayOfResultPoint = a;
    } else {
      DetectorResult detectorResult = (new Detector(decoderResult.c())).a((Map)arrayOfResultPoint);
      decoderResult = this.b.a(detectorResult.d(), (Map)arrayOfResultPoint);
      arrayOfResultPoint = detectorResult.e();
    } 
    if (decoderResult.f() instanceof QRCodeDecoderMetaData)
      ((QRCodeDecoderMetaData)decoderResult.f()).a(arrayOfResultPoint); 
    Result result = new Result(decoderResult.c(), decoderResult.a(), arrayOfResultPoint, BarcodeFormat.l);
    List list = decoderResult.d();
    if (list != null)
      result.a(ResultMetadataType.c, list); 
    String str = decoderResult.e();
    if (str != null)
      result.a(ResultMetadataType.d, str); 
    if (decoderResult.g()) {
      result.a(ResultMetadataType.j, Integer.valueOf(decoderResult.i()));
      result.a(ResultMetadataType.k, Integer.valueOf(decoderResult.h()));
    } 
    return result;
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\QRCodeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */