package com.google.common.io;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
  private byte a() throws IOException, EOFException {
    int i = this.in.read();
    if (-1 != i)
      return (byte)i; 
    throw new EOFException();
  }
  
  public boolean readBoolean() throws IOException {
    return (readUnsignedByte() != 0);
  }
  
  public byte readByte() throws IOException {
    return (byte)readUnsignedByte();
  }
  
  public char readChar() throws IOException {
    return (char)readUnsignedShort();
  }
  
  public double readDouble() throws IOException {
    return Double.longBitsToDouble(readLong());
  }
  
  public float readFloat() throws IOException {
    return Float.intBitsToFloat(readInt());
  }
  
  public void readFully(byte[] paramArrayOfbyte) throws IOException {
    ByteStreams.a(this, paramArrayOfbyte);
  }
  
  public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    ByteStreams.a(this, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public int readInt() throws IOException {
    byte b1 = a();
    byte b2 = a();
    byte b3 = a();
    return Ints.a(a(), b3, b2, b1);
  }
  
  public String readLine() {
    throw new UnsupportedOperationException("readLine is not supported");
  }
  
  public long readLong() throws IOException {
    byte b1 = a();
    byte b2 = a();
    byte b3 = a();
    byte b4 = a();
    byte b5 = a();
    byte b6 = a();
    byte b7 = a();
    return Longs.a(a(), b7, b6, b5, b4, b3, b2, b1);
  }
  
  public short readShort() throws IOException {
    return (short)readUnsignedShort();
  }
  
  public String readUTF() throws IOException {
    return (new DataInputStream(this.in)).readUTF();
  }
  
  public int readUnsignedByte() throws IOException {
    int i = this.in.read();
    if (i >= 0)
      return i; 
    throw new EOFException();
  }
  
  public int readUnsignedShort() throws IOException {
    byte b = a();
    return Ints.a((byte)0, (byte)0, a(), b);
  }
  
  public int skipBytes(int paramInt) throws IOException {
    return (int)this.in.skip(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\LittleEndianDataInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */