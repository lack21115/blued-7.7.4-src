package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.PngjOutputException;

public class CompressorStreamLz4 extends CompressorStream {
  private final DeflaterEstimatorLz4 j;
  
  private byte[] k;
  
  private final int l;
  
  private int m;
  
  public void a() {
    if (!this.e) {
      b();
      this.e = true;
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramInt2 == 0)
      return; 
    if (!this.e && !this.d) {
      this.f += paramInt2;
      while (paramInt2 > 0) {
        if (this.m == 0 && (paramInt2 >= 16000 || this.f == this.c)) {
          this.g += this.j.a(paramArrayOfbyte, paramInt1, paramInt2);
          paramInt2 = 0;
          continue;
        } 
        if (this.k == null)
          this.k = new byte[this.l]; 
        int i = this.m;
        int j = this.l;
        if (i + paramInt2 <= j) {
          i = paramInt2;
        } else {
          i = j - i;
        } 
        if (i > 0)
          System.arraycopy(paramArrayOfbyte, paramInt1, this.k, this.m, i); 
        this.m += i;
        j = paramInt2 - i;
        i = paramInt1 + i;
        paramInt1 = i;
        paramInt2 = j;
        if (this.m == this.l) {
          b();
          paramInt1 = i;
          paramInt2 = j;
        } 
      } 
      return;
    } 
    throw new PngjOutputException("write beyond end of stream");
  }
  
  void b() {
    if (this.m > 0) {
      this.g += this.j.a(this.k, 0, this.m);
      this.m = 0;
    } 
  }
  
  public void close() {
    a();
    if (!this.d) {
      super.close();
      this.k = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\pixels\CompressorStreamLz4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */