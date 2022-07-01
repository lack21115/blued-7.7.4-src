package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

public class PngChunkFDAT extends PngChunkMultiple {
  int h;
  
  private int i;
  
  private byte[] j;
  
  public PngChunkFDAT(ImageInfo paramImageInfo) {
    super("fdAT", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    this.i = PngHelperInternal.c(paramChunkRaw.d, 0);
    this.h = paramChunkRaw.a - 4;
    this.j = paramChunkRaw.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkFDAT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */