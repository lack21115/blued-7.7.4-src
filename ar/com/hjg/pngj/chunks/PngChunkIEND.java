package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public class PngChunkIEND extends PngChunkSingle {
  public PngChunkIEND(ImageInfo paramImageInfo) {
    super("IEND", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {}
  
  public ChunkRaw e() {
    return new ChunkRaw(0, ChunkHelper.d, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkIEND.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */