package com.tencent.tbs.sdk.extension.partner.precheck;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class a implements Closeable {
  private final RandomAccessFile a;
  
  private final File b;
  
  private final byte[] c = new byte[8];
  
  private boolean d;
  
  public a(File paramFile) {
    this.b = paramFile;
    this.a = new RandomAccessFile(this.b, "r");
  }
  
  public final int a(byte[] paramArrayOfbyte) {
    return this.a.read(paramArrayOfbyte);
  }
  
  public final int a(char[] paramArrayOfchar) {
    byte[] arrayOfByte = new byte[paramArrayOfchar.length];
    int j = this.a.read(arrayOfByte);
    for (int i = 0; i < paramArrayOfchar.length; i++)
      paramArrayOfchar[i] = (char)arrayOfByte[i]; 
    return j;
  }
  
  public final short a() {
    short s1 = this.a.readShort();
    short s = s1;
    if (this.d)
      s = (short)((s1 & 0xFF00) >>> 8 | (s1 & 0xFF) << 8); 
    return s;
  }
  
  public void a(long paramLong) {
    this.a.seek(paramLong);
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public final int b() {
    int j = this.a.readInt();
    int i = j;
    if (this.d)
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8; 
    return i;
  }
  
  public final long c() {
    if (this.d) {
      this.a.readFully(this.c, 0, 8);
      byte[] arrayOfByte = this.c;
      long l1 = arrayOfByte[7];
      long l2 = (arrayOfByte[6] & 0xFF);
      long l3 = (arrayOfByte[5] & 0xFF);
      long l4 = (arrayOfByte[4] & 0xFF);
      long l5 = (arrayOfByte[3] & 0xFF);
      long l6 = (arrayOfByte[2] & 0xFF);
      return (arrayOfByte[1] & 0xFF) << 8L | l1 << 56L | l2 << 48L | l3 << 40L | l4 << 32L | l5 << 24L | l6 << 16L | (arrayOfByte[0] & 0xFF);
    } 
    return this.a.readLong();
  }
  
  public void close() {
    try {
      this.a.close();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\precheck\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */