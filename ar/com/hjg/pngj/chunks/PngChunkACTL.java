package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

public class PngChunkACTL extends PngChunkSingle {
  private int h;
  
  private int i;
  
  public PngChunkACTL(ImageInfo paramImageInfo) {
    super("acTL", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    this.h = PngHelperInternal.c(paramChunkRaw.d, 0);
    this.i = PngHelperInternal.c(paramChunkRaw.d, 4);
  }
  
  public int e() {
    return this.h;
  }
  
  public int f() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkACTL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */