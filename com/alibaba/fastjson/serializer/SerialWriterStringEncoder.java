package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class SerialWriterStringEncoder {
  private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = new ThreadLocal<SoftReference<byte[]>>();
  
  private final CharsetEncoder encoder;
  
  public SerialWriterStringEncoder(Charset paramCharset) {
    this(paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
  }
  
  public SerialWriterStringEncoder(CharsetEncoder paramCharsetEncoder) {
    this.encoder = paramCharsetEncoder;
  }
  
  private static byte[] allocateBytes(int paramInt) {
    if (paramInt > 131072)
      return new byte[paramInt]; 
    if (paramInt >>> 10 <= 0) {
      paramInt = 1024;
    } else {
      paramInt = 1 << 32 - Integer.numberOfLeadingZeros(paramInt - 1);
    } 
    byte[] arrayOfByte = new byte[paramInt];
    bytesBufLocal.set((SoftReference)new SoftReference<byte>(arrayOfByte));
    return arrayOfByte;
  }
  
  public static void clearBytes() {
    bytesBufLocal.set(null);
  }
  
  public static byte[] getBytes(int paramInt) {
    SoftReference<byte[]> softReference = bytesBufLocal.get();
    if (softReference == null)
      return allocateBytes(paramInt); 
    byte[] arrayOfByte2 = softReference.get();
    if (arrayOfByte2 == null)
      return allocateBytes(paramInt); 
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length < paramInt)
      arrayOfByte1 = allocateBytes(paramInt); 
    return arrayOfByte1;
  }
  
  private static int scale(int paramInt, float paramFloat) {
    return (int)(paramInt * paramFloat);
  }
  
  public byte[] encode(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt2 == 0)
      return new byte[0]; 
    this.encoder.reset();
    return encode(paramArrayOfchar, paramInt1, paramInt2, getBytes(scale(paramInt2, this.encoder.maxBytesPerChar())));
  }
  
  public byte[] encode(char[] paramArrayOfchar, int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte);
    CharBuffer charBuffer = CharBuffer.wrap(paramArrayOfchar, paramInt1, paramInt2);
    try {
      CoderResult coderResult = this.encoder.encode(charBuffer, byteBuffer, true);
      if (!coderResult.isUnderflow())
        coderResult.throwException(); 
      coderResult = this.encoder.flush(byteBuffer);
      if (!coderResult.isUnderflow())
        coderResult.throwException(); 
      paramInt1 = byteBuffer.position();
      byte[] arrayOfByte = new byte[paramInt1];
      System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramInt1);
      return arrayOfByte;
    } catch (CharacterCodingException characterCodingException) {
      throw new JSONException(characterCodingException.getMessage(), characterCodingException);
    } 
  }
  
  public CharsetEncoder getEncoder() {
    return this.encoder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SerialWriterStringEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */