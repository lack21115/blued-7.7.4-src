package com.google.zxing.pdf417;

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
import com.google.zxing.common.DecoderResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.pdf417.decoder.PDF417ScanningDecoder;
import com.google.zxing.pdf417.detector.Detector;
import com.google.zxing.pdf417.detector.PDF417DetectorResult;
import java.util.ArrayList;
import java.util.Map;

public final class PDF417Reader implements Reader, MultipleBarcodeReader {
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return (paramResultPoint1 == null || paramResultPoint2 == null) ? 0 : (int)Math.abs(paramResultPoint1.a() - paramResultPoint2.a());
  }
  
  private static int a(ResultPoint[] paramArrayOfResultPoint) {
    return Math.max(Math.max(a(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), a(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.max(a(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), a(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  private static Result[] a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, boolean paramBoolean) throws NotFoundException, FormatException, ChecksumException {
    ArrayList<Result> arrayList = new ArrayList();
    PDF417DetectorResult pDF417DetectorResult = Detector.a(paramBinaryBitmap, paramMap, paramBoolean);
    for (ResultPoint[] arrayOfResultPoint : pDF417DetectorResult.b()) {
      DecoderResult decoderResult = PDF417ScanningDecoder.a(pDF417DetectorResult.a(), arrayOfResultPoint[4], arrayOfResultPoint[5], arrayOfResultPoint[6], arrayOfResultPoint[7], b(arrayOfResultPoint), a(arrayOfResultPoint));
      Result result = new Result(decoderResult.c(), decoderResult.a(), arrayOfResultPoint, BarcodeFormat.k);
      result.a(ResultMetadataType.d, decoderResult.e());
      PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata)decoderResult.f();
      if (pDF417ResultMetadata != null)
        result.a(ResultMetadataType.i, pDF417ResultMetadata); 
      arrayList.add(result);
    } 
    return arrayList.<Result>toArray(new Result[arrayList.size()]);
  }
  
  private static int b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return (paramResultPoint1 == null || paramResultPoint2 == null) ? Integer.MAX_VALUE : (int)Math.abs(paramResultPoint1.a() - paramResultPoint2.a());
  }
  
  private static int b(ResultPoint[] paramArrayOfResultPoint) {
    return Math.min(Math.min(b(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]), b(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) * 17 / 18), Math.min(b(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5]), b(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3]) * 17 / 18));
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    Result[] arrayOfResult = a(paramBinaryBitmap, paramMap, false);
    if (arrayOfResult != null && arrayOfResult.length != 0 && arrayOfResult[0] != null)
      return arrayOfResult[0]; 
    throw NotFoundException.a();
  }
  
  public void a() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\PDF417Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */