package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader extends UPCEANReader {
  private final UPCEANReader a = new EAN13Reader();
  
  private static Result a(Result paramResult) throws FormatException {
    String str = paramResult.a();
    if (str.charAt(0) == '0') {
      Result result = new Result(str.substring(1), null, paramResult.c(), BarcodeFormat.o);
      if (paramResult.e() != null)
        result.a(paramResult.e()); 
      return result;
    } 
    throw FormatException.a();
  }
  
  protected int a(BitArray paramBitArray, int[] paramArrayOfint, StringBuilder paramStringBuilder) throws NotFoundException {
    return this.a.a(paramBitArray, paramArrayOfint, paramStringBuilder);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    return a(this.a.a(paramInt, paramBitArray, paramMap));
  }
  
  public Result a(int paramInt, BitArray paramBitArray, int[] paramArrayOfint, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException, ChecksumException {
    return a(this.a.a(paramInt, paramBitArray, paramArrayOfint, paramMap));
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, FormatException {
    return a(this.a.a(paramBinaryBitmap, paramMap));
  }
  
  BarcodeFormat b() {
    return BarcodeFormat.o;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\UPCAReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */