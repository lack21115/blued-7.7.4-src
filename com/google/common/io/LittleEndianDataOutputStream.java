package com.google.common.io;

import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
  public void close() throws IOException {
    this.out.close();
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void writeBoolean(boolean paramBoolean) throws IOException {
    ((DataOutputStream)this.out).writeBoolean(paramBoolean);
  }
  
  public void writeByte(int paramInt) throws IOException {
    ((DataOutputStream)this.out).writeByte(paramInt);
  }
  
  @Deprecated
  public void writeBytes(String paramString) throws IOException {
    ((DataOutputStream)this.out).writeBytes(paramString);
  }
  
  public void writeChar(int paramInt) throws IOException {
    writeShort(paramInt);
  }
  
  public void writeChars(String paramString) throws IOException {
    for (int i = 0; i < paramString.length(); i++)
      writeChar(paramString.charAt(i)); 
  }
  
  public void writeDouble(double paramDouble) throws IOException {
    writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  public void writeFloat(float paramFloat) throws IOException {
    writeInt(Float.floatToIntBits(paramFloat));
  }
  
  public void writeInt(int paramInt) throws IOException {
    this.out.write(paramInt & 0xFF);
    this.out.write(paramInt >> 8 & 0xFF);
    this.out.write(paramInt >> 16 & 0xFF);
    this.out.write(paramInt >> 24 & 0xFF);
  }
  
  public void writeLong(long paramLong) throws IOException {
    byte[] arrayOfByte = Longs.b(Long.reverseBytes(paramLong));
    write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void writeShort(int paramInt) throws IOException {
    this.out.write(paramInt & 0xFF);
    this.out.write(paramInt >> 8 & 0xFF);
  }
  
  public void writeUTF(String paramString) throws IOException {
    ((DataOutputStream)this.out).writeUTF(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\LittleEndianDataOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */