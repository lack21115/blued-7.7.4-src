package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.j.b.a.a;
import java.io.File;
import java.io.IOException;

class e implements h {
  private final a a;
  
  private final File b;
  
  private final long c;
  
  private String d;
  
  private int e;
  
  public e(a parama, File paramFile, long paramLong) {
    this.a = parama;
    this.b = paramFile;
    this.c = paramLong;
  }
  
  public int a(c paramc) {
    String str;
    try {
      k k;
      j j;
      long l = this.c - this.b.length();
      if (l == 0L && this.c > 0L) {
        paramc.a(this.b.length());
        return 0;
      } 
      if (this.c <= 0L) {
        k = new k(this.a.e(), this.b, paramc);
      } else {
        j = new j(this.a.e(), l, this.b, (c)k);
      } 
      this.e |= j.a();
      this.d = j.b();
      return this.e;
    } catch (IllegalStateException illegalStateException) {
      this.e |= 0x800000;
      str = "IllegalStateExceptionWhileDoMainPartitionDownloaderWork";
    } catch (IOException iOException) {
      this.e |= 0x400000;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("UnknownNetworkExceptionWhileDoMainPartitionDownloaderWork");
      stringBuilder.append(iOException.getMessage());
      str = stringBuilder.toString();
    } 
    this.d = str;
    return this.e;
  }
  
  public String a() {
    return this.d;
  }
  
  public int b() {
    return this.e;
  }
  
  public void c() {
    a a1 = this.a;
    if (a1 != null)
      a1.f(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */