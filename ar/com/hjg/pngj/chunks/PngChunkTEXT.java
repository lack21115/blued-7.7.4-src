package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public class PngChunkTEXT extends PngChunkTextVar {
  public PngChunkTEXT(ImageInfo paramImageInfo) {
    super("tEXt", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    String str;
    int i;
    for (i = 0; i < paramChunkRaw.d.length && paramChunkRaw.d[i] != 0; i++);
    this.h = ChunkHelper.a(paramChunkRaw.d, 0, i);
    if (++i < paramChunkRaw.d.length) {
      str = ChunkHelper.a(paramChunkRaw.d, i, paramChunkRaw.d.length - i);
    } else {
      str = "";
    } 
    this.i = str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkTEXT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */