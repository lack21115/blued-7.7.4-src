package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public abstract class PngChunkMultiple extends PngChunk {
  protected PngChunkMultiple(String paramString, ImageInfo paramImageInfo) {
    super(paramString, paramImageInfo);
  }
  
  public final boolean a() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkMultiple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */