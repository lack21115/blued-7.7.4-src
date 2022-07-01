package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

public class PngChunkBKGD extends PngChunkSingle {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  public PngChunkBKGD(ImageInfo paramImageInfo) {
    super("bKGD", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (this.e.f) {
      this.h = PngHelperInternal.b(paramChunkRaw.d, 0);
      return;
    } 
    if (this.e.g) {
      this.l = paramChunkRaw.d[0] & 0xFF;
      return;
    } 
    this.i = PngHelperInternal.b(paramChunkRaw.d, 0);
    this.j = PngHelperInternal.b(paramChunkRaw.d, 2);
    this.k = PngHelperInternal.b(paramChunkRaw.d, 4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkBKGD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */