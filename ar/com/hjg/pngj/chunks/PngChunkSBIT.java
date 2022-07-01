package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkSBIT extends PngChunkSingle {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  public PngChunkSBIT(ImageInfo paramImageInfo) {
    super("sBIT", paramImageInfo);
  }
  
  private int e() {
    byte b;
    if (this.e.f) {
      b = 1;
    } else {
      b = 3;
    } 
    int i = b;
    if (this.e.e)
      i = b + 1; 
    return i;
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (paramChunkRaw.a == e()) {
      if (this.e.f) {
        this.h = PngHelperInternal.a(paramChunkRaw.d, 0);
        if (this.e.e) {
          this.i = PngHelperInternal.a(paramChunkRaw.d, 1);
          return;
        } 
      } else {
        this.j = PngHelperInternal.a(paramChunkRaw.d, 0);
        this.k = PngHelperInternal.a(paramChunkRaw.d, 1);
        this.l = PngHelperInternal.a(paramChunkRaw.d, 2);
        if (this.e.e)
          this.i = PngHelperInternal.a(paramChunkRaw.d, 3); 
      } 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunk length ");
    stringBuilder.append(paramChunkRaw);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkSBIT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */