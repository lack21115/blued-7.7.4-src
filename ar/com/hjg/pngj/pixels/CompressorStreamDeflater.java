package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.PngjOutputException;
import java.util.zip.Deflater;

public class CompressorStreamDeflater extends CompressorStream {
  protected Deflater j;
  
  protected byte[] k;
  
  protected boolean l;
  
  public void a() {
    if (this.e)
      return; 
    if (!this.j.finished()) {
      this.j.finish();
      while (!this.j.finished())
        b(); 
    } 
    this.e = true;
    if (this.a != null)
      this.a.g(); 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (!this.j.finished() && !this.e && !this.d) {
      this.j.setInput(paramArrayOfbyte, paramInt1, paramInt2);
      this.f += paramInt2;
      while (!this.j.needsInput())
        b(); 
      return;
    } 
    throw new PngjOutputException("write beyond end of stream");
  }
  
  protected void b() {
    int j;
    byte[] arrayOfByte;
    if (this.a != null) {
      arrayOfByte = this.a.h();
      i = this.a.c();
      j = this.a.d();
    } else {
      if (this.k == null)
        this.k = new byte[4096]; 
      arrayOfByte = this.k;
      i = 0;
      j = arrayOfByte.length;
    } 
    int i = this.j.deflate(arrayOfByte, i, j);
    if (i > 0) {
      if (this.a != null)
        this.a.a(i); 
      this.g += i;
    } 
  }
  
  public void close() {
    a();
    try {
      if (this.l)
        this.j.end(); 
    } catch (Exception exception) {}
    super.close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\pixels\CompressorStreamDeflater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */