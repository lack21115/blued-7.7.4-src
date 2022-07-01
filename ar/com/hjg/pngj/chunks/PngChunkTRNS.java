package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

public class PngChunkTRNS extends PngChunkSingle {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int[] l = new int[0];
  
  public PngChunkTRNS(ImageInfo paramImageInfo) {
    super("tRNS", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    boolean bool = this.e.f;
    int i = 0;
    if (bool) {
      this.h = PngHelperInternal.b(paramChunkRaw.d, 0);
      return;
    } 
    if (this.e.g) {
      int j = paramChunkRaw.d.length;
      this.l = new int[j];
      while (i < j) {
        this.l[i] = paramChunkRaw.d[i] & 0xFF;
        i++;
      } 
    } else {
      this.i = PngHelperInternal.b(paramChunkRaw.d, 0);
      this.j = PngHelperInternal.b(paramChunkRaw.d, 2);
      this.k = PngHelperInternal.b(paramChunkRaw.d, 4);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkTRNS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */