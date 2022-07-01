package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Decoder {
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.f);
  
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
  
  public DecoderResult a(BitMatrix paramBitMatrix) throws FormatException, ChecksumException {
    BitMatrixParser bitMatrixParser = new BitMatrixParser(paramBitMatrix);
    Version version = bitMatrixParser.a();
    DataBlock[] arrayOfDataBlock = DataBlock.a(bitMatrixParser.b(), version);
    int k = arrayOfDataBlock.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += arrayOfDataBlock[i].a();
      i++;
    } 
    byte[] arrayOfByte = new byte[j];
    k = arrayOfDataBlock.length;
    for (i = 0; i < k; i++) {
      DataBlock dataBlock = arrayOfDataBlock[i];
      byte[] arrayOfByte1 = dataBlock.b();
      int m = dataBlock.a();
      a(arrayOfByte1, m);
      for (j = 0; j < m; j++)
        arrayOfByte[j * k + i] = arrayOfByte1[j]; 
    } 
    return DecodedBitStreamParser.a(arrayOfByte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\decoder\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */