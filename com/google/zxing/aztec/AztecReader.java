package com.google.zxing.aztec;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.decoder.Decoder;
import com.google.zxing.aztec.detector.Detector;
import com.google.zxing.common.DecoderResult;
import java.util.Map;

public final class AztecReader implements Reader {
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    Detector detector = new Detector(paramBinaryBitmap.c());
    boolean bool = false;
    DecoderResult decoderResult = null;
    try {
      AztecDetectorResult aztecDetectorResult = detector.a(false);
      ResultPoint[] arrayOfResultPoint = aztecDetectorResult.e();
      try {
        DecoderResult decoderResult1 = (new Decoder()).a(aztecDetectorResult);
        DecoderResult decoderResult2 = null;
        decoderResult = decoderResult1;
        decoderResult1 = decoderResult2;
      } catch (NotFoundException notFoundException) {
        Object object1 = null;
      } catch (FormatException formatException) {}
    } catch (NotFoundException notFoundException) {
      paramBinaryBitmap = null;
    } catch (FormatException formatException1) {
      paramBinaryBitmap = null;
      FormatException formatException2 = formatException1;
      formatException1 = null;
    } 
    Object object = null;
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\aztec\AztecReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */