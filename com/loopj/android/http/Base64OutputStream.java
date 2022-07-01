package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
  private static byte[] EMPTY = new byte[0];
  
  private int bpos = 0;
  
  private byte[] buffer = null;
  
  private final Base64.Coder coder;
  
  private final int flags;
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt) {
    this(paramOutputStream, paramInt, true);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean) {
    super(paramOutputStream);
    this.flags = paramInt;
    if (paramBoolean) {
      this.coder = new Base64.Encoder(paramInt, null);
      return;
    } 
    this.coder = new Base64.Decoder(paramInt, null);
  }
  
  private byte[] embiggen(byte[] paramArrayOfbyte, int paramInt) {
    return (paramArrayOfbyte == null || paramArrayOfbyte.length < paramInt) ? new byte[paramInt] : paramArrayOfbyte;
  }
  
  private void flushBuffer() throws IOException {
    int i = this.bpos;
    if (i > 0) {
      internalWrite(this.buffer, 0, i, false);
      this.bpos = 0;
    } 
  }
  
  private void internalWrite(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) throws IOException {
    Base64.Coder coder = this.coder;
    coder.output = embiggen(coder.output, this.coder.maxOutputSize(paramInt2));
    if (this.coder.process(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean)) {
      this.out.write(this.coder.output, 0, this.coder.op);
      return;
    } 
    throw new Base64DataException("bad base-64");
  }
  
  public void close() throws IOException {
    IOException iOException2;
    try {
      flushBuffer();
      internalWrite(EMPTY, 0, 0, true);
      iOException1 = null;
    } catch (IOException iOException1) {}
    try {
      if ((this.flags & 0x10) == 0) {
        this.out.close();
        iOException2 = iOException1;
      } else {
        this.out.flush();
        iOException2 = iOException1;
      } 
    } catch (IOException iOException) {
      iOException2 = iOException1;
      if (iOException1 != null)
        iOException2 = iOException; 
    } 
    if (iOException2 == null)
      return; 
    throw iOException2;
  }
  
  public void write(int paramInt) throws IOException {
    if (this.buffer == null)
      this.buffer = new byte[1024]; 
    int i = this.bpos;
    byte[] arrayOfByte = this.buffer;
    if (i >= arrayOfByte.length) {
      internalWrite(arrayOfByte, 0, i, false);
      this.bpos = 0;
    } 
    arrayOfByte = this.buffer;
    i = this.bpos;
    this.bpos = i + 1;
    arrayOfByte[i] = (byte)paramInt;
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 <= 0)
      return; 
    flushBuffer();
    internalWrite(paramArrayOfbyte, paramInt1, paramInt2, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\Base64OutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */