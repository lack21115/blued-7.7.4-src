package com.facebook.stetho.websocket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class Frame {
  public static final byte OPCODE_BINARY_FRAME = 2;
  
  public static final byte OPCODE_CONNECTION_CLOSE = 8;
  
  public static final byte OPCODE_CONNECTION_PING = 9;
  
  public static final byte OPCODE_CONNECTION_PONG = 10;
  
  public static final byte OPCODE_TEXT_FRAME = 1;
  
  public boolean fin;
  
  public boolean hasMask;
  
  public byte[] maskingKey;
  
  public byte opcode;
  
  public byte[] payloadData;
  
  public long payloadLen;
  
  public boolean rsv1;
  
  public boolean rsv2;
  
  public boolean rsv3;
  
  private void decodeFirstByte(byte paramByte) {
    boolean bool1;
    boolean bool2 = true;
    if ((paramByte & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.fin = bool1;
    if ((paramByte & 0x40) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.rsv1 = bool1;
    if ((paramByte & 0x20) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.rsv2 = bool1;
    if ((paramByte & 0x10) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.rsv3 = bool1;
    this.opcode = (byte)(paramByte & 0xF);
  }
  
  private long decodeLength(byte paramByte, InputStream paramInputStream) throws IOException {
    int i;
    if (paramByte <= 125)
      return paramByte; 
    if (paramByte == 126)
      return ((readByteOrThrow(paramInputStream) & 0xFF) << 8 | readByteOrThrow(paramInputStream) & 0xFF); 
    if (paramByte == Byte.MAX_VALUE) {
      long l = 0L;
      paramByte = 0;
      while (paramByte < 8) {
        l = (l | (readByteOrThrow(paramInputStream) & 0xFF)) << 8L;
        i = paramByte + 1;
      } 
      return l;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected length byte: ");
    stringBuilder.append(i);
    throw new IOException(stringBuilder.toString());
  }
  
  private static byte[] decodeMaskingKey(InputStream paramInputStream) throws IOException {
    byte[] arrayOfByte = new byte[4];
    readBytesOrThrow(paramInputStream, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  private byte encodeFirstByte() {
    if (this.fin) {
      b2 = (byte)128;
    } else {
      b2 = 0;
    } 
    byte b1 = b2;
    if (this.rsv1)
      b1 = (byte)(b2 | 0x40); 
    byte b2 = b1;
    if (this.rsv2)
      b2 = (byte)(b1 | 0x20); 
    b1 = b2;
    if (this.rsv3)
      b1 = (byte)(b2 | 0x10); 
    return (byte)(b1 | this.opcode & 0xF);
  }
  
  private static byte[] encodeLength(long paramLong) {
    return (paramLong <= 125L) ? new byte[] { (byte)(int)paramLong } : ((paramLong <= 65535L) ? new byte[] { 126, (byte)(int)(paramLong >> 8L & 0xFFL), (byte)(int)(paramLong & 0xFFL) } : new byte[] { Byte.MAX_VALUE, (byte)(int)(paramLong >> 56L & 0xFFL), (byte)(int)(paramLong >> 48L & 0xFFL), (byte)(int)(paramLong >> 40L & 0xFFL), (byte)(int)(paramLong >> 32L & 0xFFL), (byte)(int)(paramLong >> 24L & 0xFFL), (byte)(int)(paramLong >> 16L & 0xFFL), (byte)(int)(paramLong >> 8L & 0xFFL), (byte)(int)(paramLong & 0xFFL) });
  }
  
  private static byte readByteOrThrow(InputStream paramInputStream) throws IOException {
    int i = paramInputStream.read();
    if (i != -1)
      return (byte)i; 
    throw new EOFException();
  }
  
  private static void readBytesOrThrow(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    while (paramInt2 > 0) {
      int i = paramInputStream.read(paramArrayOfbyte, paramInt1, paramInt2);
      if (i != -1) {
        paramInt2 -= i;
        paramInt1 += i;
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public void readFrom(BufferedInputStream paramBufferedInputStream) throws IOException {
    boolean bool;
    byte[] arrayOfByte;
    decodeFirstByte(readByteOrThrow(paramBufferedInputStream));
    byte b = readByteOrThrow(paramBufferedInputStream);
    if ((b & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.hasMask = bool;
    this.payloadLen = decodeLength((byte)(b & 0xFFFFFF7F), paramBufferedInputStream);
    if (this.hasMask) {
      arrayOfByte = decodeMaskingKey(paramBufferedInputStream);
    } else {
      arrayOfByte = null;
    } 
    this.maskingKey = arrayOfByte;
    long l = this.payloadLen;
    this.payloadData = new byte[(int)l];
    readBytesOrThrow(paramBufferedInputStream, this.payloadData, 0, (int)l);
    MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int)this.payloadLen);
  }
  
  public void writeTo(BufferedOutputStream paramBufferedOutputStream) throws IOException {
    paramBufferedOutputStream.write(encodeFirstByte());
    byte[] arrayOfByte = encodeLength(this.payloadLen);
    if (this.hasMask)
      arrayOfByte[0] = (byte)(arrayOfByte[0] | 0x80); 
    paramBufferedOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
    if (!this.hasMask) {
      paramBufferedOutputStream.write(this.payloadData, 0, (int)this.payloadLen);
      return;
    } 
    throw new UnsupportedOperationException("Writing masked data not implemented");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\websocket\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */