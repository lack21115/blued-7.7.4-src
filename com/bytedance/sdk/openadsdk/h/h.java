package com.bytedance.sdk.openadsdk.h;

import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

class h {
  private final RandomAccessFile a;
  
  h(File paramFile, String paramString) throws a {
    try {
      this.a = new RandomAccessFile(paramFile, paramString);
      return;
    } catch (FileNotFoundException fileNotFoundException) {
      throw new a(fileNotFoundException);
    } 
  }
  
  int a(byte[] paramArrayOfbyte) throws a {
    try {
      return this.a.read(paramArrayOfbyte);
    } catch (IOException iOException) {
      throw new a(iOException);
    } 
  }
  
  void a() {
    d.a(this.a);
  }
  
  void a(long paramLong) throws a {
    try {
      this.a.seek(paramLong);
      return;
    } catch (IOException iOException) {
      throw new a(iOException);
    } 
  }
  
  void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws a {
    try {
      this.a.write(paramArrayOfbyte, paramInt1, paramInt2);
      return;
    } catch (IOException iOException) {
      throw new a(iOException);
    } 
  }
  
  static class a extends Exception {
    a(Throwable param1Throwable) {
      super(param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */