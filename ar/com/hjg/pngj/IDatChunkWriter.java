package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkRaw;
import java.io.OutputStream;

public class IDatChunkWriter {
  private final OutputStream a;
  
  private final int b;
  
  private byte[] c;
  
  private int d;
  
  private int e;
  
  private long f;
  
  private int g;
  
  public void a(int paramInt) {
    this.d += paramInt;
    this.e -= paramInt;
    paramInt = this.e;
    if (paramInt >= 0) {
      if (paramInt == 0)
        b(); 
      return;
    } 
    throw new PngjOutputException("Anomalous situation");
  }
  
  protected byte[] a() {
    return ChunkHelper.c;
  }
  
  public final void b() {
    int i = this.d;
    if (i > 0 && i >= f()) {
      ChunkRaw chunkRaw = new ChunkRaw(this.d, a(), false);
      chunkRaw.d = this.c;
      chunkRaw.a(this.a);
      this.f += (chunkRaw.a + 12);
      this.g++;
      this.d = 0;
      this.e = this.b;
      e();
    } 
  }
  
  public int c() {
    return this.d;
  }
  
  public int d() {
    return this.e;
  }
  
  protected void e() {}
  
  protected int f() {
    return 1;
  }
  
  public void g() {
    b();
    this.d = 0;
    this.c = null;
  }
  
  public byte[] h() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\IDatChunkWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */