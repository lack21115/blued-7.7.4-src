package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class j extends a {
  private final long e;
  
  public j(InputStream paramInputStream, long paramLong, File paramFile, c paramc) {
    super(paramInputStream, paramFile, paramc);
    this.e = paramLong;
  }
  
  public int a() {
    return (this.e <= 0L) ? 0 : super.a();
  }
  
  protected int a(FileOutputStream paramFileOutputStream) throws IOException {
    int i;
    int k;
    byte[] arrayOfByte = new byte[8192];
    long l = this.e;
    this.c.a(this.b.length());
    while (true) {
      i = 0;
      k = l cmp 0L;
      if (k > 0) {
        int m = (int)Math.min(l, arrayOfByte.length);
        m = this.a.read(arrayOfByte, 0, m);
        if (m <= 0)
          break; 
        paramFileOutputStream.write(arrayOfByte, 0, m);
        this.c.a(this.b.length());
        l -= m;
        continue;
      } 
      break;
    } 
    if (k != 0) {
      this.d = "NetworkErrInputStreamDoesNotSupportEnoughBytesAsExpected ";
      i = 4194304;
    } 
    return i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */