package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder {
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.e);
  
  private DecoderResult a(BitMatrixParser paramBitMatrixParser, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    Version version = paramBitMatrixParser.b();
    ErrorCorrectionLevel errorCorrectionLevel = paramBitMatrixParser.a().a();
    DataBlock[] arrayOfDataBlock = DataBlock.a(paramBitMatrixParser.c(), version, errorCorrectionLevel);
    int k = arrayOfDataBlock.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += arrayOfDataBlock[i].a();
      i++;
    } 
    byte[] arrayOfByte = new byte[j];
    int m = arrayOfDataBlock.length;
    j = 0;
    i = 0;
    while (j < m) {
      DataBlock dataBlock = arrayOfDataBlock[j];
      byte[] arrayOfByte1 = dataBlock.b();
      int n = dataBlock.a();
      a(arrayOfByte1, n);
      k = 0;
      while (k < n) {
        arrayOfByte[i] = arrayOfByte1[k];
        k++;
        i++;
      } 
      j++;
    } 
    return DecodedBitStreamParser.a(arrayOfByte, version, errorCorrectionLevel, paramMap);
  }
  
  private void a(byte[] paramArrayOfbyte, int paramInt) throws ChecksumException {
    int j = paramArrayOfbyte.length;
    int[] arrayOfInt = new int[j];
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      arrayOfInt[i] = paramArrayOfbyte[i] & 0xFF; 
    try {
      this.a.a(arrayOfInt, paramArrayOfbyte.length - paramInt);
      for (i = bool; i < paramInt; i++)
        paramArrayOfbyte[i] = (byte)arrayOfInt[i]; 
      return;
    } catch (ReedSolomonException reedSolomonException) {
      throw ChecksumException.a();
    } 
  }
  
  public DecoderResult a(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap) throws FormatException, ChecksumException {
    BitMatrixParser bitMatrixParser = new BitMatrixParser(paramBitMatrix);
    formatException = null;
    try {
      return a(bitMatrixParser, paramMap);
    } catch (FormatException formatException) {
      paramBitMatrix = null;
    } catch (ChecksumException checksumException) {}
    try {
      bitMatrixParser.d();
      bitMatrixParser.a(true);
      bitMatrixParser.b();
      bitMatrixParser.a();
      bitMatrixParser.e();
      DecoderResult decoderResult = a(bitMatrixParser, paramMap);
      decoderResult.a(new QRCodeDecoderMetaData(true));
      return decoderResult;
    } catch (FormatException|ChecksumException formatException1) {
      if (formatException != null)
        throw formatException; 
      throw checksumException;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */