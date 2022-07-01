package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkGAMA extends PngChunkSingle {
  private double h;
  
  public PngChunkGAMA(ImageInfo paramImageInfo) {
    super("gAMA", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == 4) {
      this.h = PngHelperInternal.c(paramChunkRaw.d, 0) / 100000.0D;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkGAMA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */