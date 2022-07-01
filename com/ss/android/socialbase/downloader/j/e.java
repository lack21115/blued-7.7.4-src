package com.ss.android.socialbase.downloader.j;

import java.io.IOException;
import java.io.InputStream;

public class e implements c {
  private final InputStream a;
  
  private final b b;
  
  public e(InputStream paramInputStream, int paramInt) {
    this.a = paramInputStream;
    this.b = new b(paramInt);
  }
  
  public b a() throws IOException {
    b b1 = this.b;
    b1.b = this.a.read(b1.a);
    return this.b;
  }
  
  public void a(b paramb) {}
  
  public void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\j\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */