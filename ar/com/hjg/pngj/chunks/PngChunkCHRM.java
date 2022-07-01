package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkCHRM extends PngChunkSingle {
  private double h;
  
  private double i;
  
  private double j;
  
  private double k;
  
  private double l;
  
  private double m;
  
  private double n;
  
  private double o;
  
  public PngChunkCHRM(ImageInfo paramImageInfo) {
    super("cHRM", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == 32) {
      this.h = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 0));
      this.i = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 4));
      this.j = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 8));
      this.k = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 12));
      this.l = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 16));
      this.m = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 20));
      this.n = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 24));
      this.o = PngHelperInternal.a(PngHelperInternal.c(paramChunkRaw.d, 28));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkCHRM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */