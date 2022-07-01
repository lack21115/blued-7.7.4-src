package ar.com.hjg.pngj;

import java.io.FilterInputStream;
import java.io.IOException;

public class PngReaderFilter extends FilterInputStream {
  private ChunkSeqReaderPng a;
  
  public void close() throws IOException {
    super.close();
    this.a.d();
  }
  
  public int read() throws IOException {
    int i = super.read();
    if (i > 0)
      this.a.b(new byte[] { (byte)i }, 0, 1); 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    int i = super.read(paramArrayOfbyte);
    if (i > 0)
      this.a.b(paramArrayOfbyte, 0, i); 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt2 = super.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt2 > 0)
      this.a.b(paramArrayOfbyte, paramInt1, paramInt2); 
    return paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\PngReaderFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */