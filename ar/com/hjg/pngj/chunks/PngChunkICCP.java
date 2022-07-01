package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

public class PngChunkICCP extends PngChunkSingle {
  private String h;
  
  private byte[] i;
  
  public PngChunkICCP(ImageInfo paramImageInfo) {
    super("iCCP", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    int i = ChunkHelper.c(paramChunkRaw.d);
    this.h = ChunkHelper.a(paramChunkRaw.d, 0, i);
    if ((paramChunkRaw.d[i + 1] & 0xFF) == 0) {
      int j = paramChunkRaw.d.length;
      i += 2;
      j -= i;
      this.i = new byte[j];
      System.arraycopy(paramChunkRaw.d, i, this.i, 0, j);
      return;
    } 
    throw new PngjException("bad compression for ChunkTypeICCP");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkICCP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */