package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public abstract class PngChunkSingle extends PngChunk {
  protected PngChunkSingle(String paramString, ImageInfo paramImageInfo) {
    super(paramString, paramImageInfo);
  }
  
  public final boolean a() {
    return false;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.a == null) {
      if (((PngChunkSingle)paramObject).a != null)
        return false; 
    } else if (!this.a.equals(((PngChunkSingle)paramObject).a)) {
      return false;
    } 
    return true;
  }
  
  public int hashCode() {
    int i;
    if (this.a == null) {
      i = 0;
    } else {
      i = this.a.hashCode();
    } 
    return 31 + i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */