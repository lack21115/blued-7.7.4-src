package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkOFFS extends PngChunkSingle {
  private long h;
  
  private long i;
  
  private int j;
  
  public PngChunkOFFS(ImageInfo paramImageInfo) {
    super("oFFs", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == 9) {
      this.h = PngHelperInternal.c(paramChunkRaw.d, 0);
      long l = this.h;
      if (l < 0L)
        this.h = l + 4294967296L; 
      this.i = PngHelperInternal.c(paramChunkRaw.d, 4);
      l = this.i;
      if (l < 0L)
        this.i = l + 4294967296L; 
      this.j = PngHelperInternal.a(paramChunkRaw.d, 8);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk length ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkOFFS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */