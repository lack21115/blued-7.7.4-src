package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public abstract class PngChunkTextVar extends PngChunkMultiple {
  protected String h;
  
  protected String i;
  
  protected PngChunkTextVar(String paramString, ImageInfo paramImageInfo) {
    super(paramString, paramImageInfo);
  }
  
  public String e() {
    return this.h;
  }
  
  public static class PngTxtInfo {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkTextVar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */