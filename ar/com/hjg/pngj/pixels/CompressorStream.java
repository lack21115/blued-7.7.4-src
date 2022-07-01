package ar.com.hjg.pngj.pixels;

import ar.com.hjg.pngj.IDatChunkWriter;
import java.io.OutputStream;

public abstract class CompressorStream extends OutputStream {
  protected IDatChunkWriter a;
  
  public final int b;
  
  public final long c;
  
  boolean d;
  
  protected boolean e;
  
  protected long f;
  
  protected long g;
  
  protected int h;
  
  protected boolean i;
  
  private byte[] j;
  
  public abstract void a();
  
  public abstract void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public void close() {
    a();
    IDatChunkWriter iDatChunkWriter = this.a;
    if (iDatChunkWriter != null)
      iDatChunkWriter.g(); 
    this.d = true;
  }
  
  public void write(int paramInt) {
    write(new byte[] { (byte)paramInt });
  }
  
  public final void write(byte[] paramArrayOfbyte) {
    write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public final void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    this.h++;
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt2 <= this.b) {
      a(paramArrayOfbyte, paramInt1, paramInt2);
      if (this.i) {
        paramInt2 = this.h;
        byte[] arrayOfByte = this.j;
        if (paramInt2 < arrayOfByte.length)
          arrayOfByte[paramInt2] = paramArrayOfbyte[paramInt1]; 
      } 
    } else {
      while (j > 0) {
        a(paramArrayOfbyte, i, this.b);
        paramInt1 = this.b;
        i += paramInt1;
        j -= paramInt1;
      } 
    } 
    if (this.f >= this.c)
      a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\pixels\CompressorStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */