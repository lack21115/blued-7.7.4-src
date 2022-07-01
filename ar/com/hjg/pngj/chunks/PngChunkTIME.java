package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkTIME extends PngChunkSingle {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  public PngChunkTIME(ImageInfo paramImageInfo) {
    super("tIME", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == 7) {
      this.h = PngHelperInternal.b(paramChunkRaw.d, 0);
      this.i = PngHelperInternal.a(paramChunkRaw.d, 2);
      this.j = PngHelperInternal.a(paramChunkRaw.d, 3);
      this.k = PngHelperInternal.a(paramChunkRaw.d, 4);
      this.l = PngHelperInternal.a(paramChunkRaw.d, 5);
      this.m = PngHelperInternal.a(paramChunkRaw.d, 6);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkTIME.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */