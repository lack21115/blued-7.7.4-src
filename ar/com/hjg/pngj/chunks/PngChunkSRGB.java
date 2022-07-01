package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkSRGB extends PngChunkSingle {
  private int h;
  
  public PngChunkSRGB(ImageInfo paramImageInfo) {
    super("sRGB", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == 1) {
      this.h = PngHelperInternal.a(paramChunkRaw.d, 0);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk length ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkSRGB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */