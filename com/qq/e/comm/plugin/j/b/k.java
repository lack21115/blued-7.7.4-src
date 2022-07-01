package com.qq.e.comm.plugin.j.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class k extends a {
  public k(InputStream paramInputStream, File paramFile, c paramc) {
    super(paramInputStream, paramFile, paramc);
  }
  
  protected int a(FileOutputStream paramFileOutputStream) throws IOException {
    byte[] arrayOfByte = new byte[8192];
    while (true) {
      this.c.a(this.b.length());
      int i = this.a.read(arrayOfByte);
      if (i <= 0)
        return 0; 
      paramFileOutputStream.write(arrayOfByte, 0, i);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */