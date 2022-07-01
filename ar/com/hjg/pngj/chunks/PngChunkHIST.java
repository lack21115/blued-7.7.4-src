package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;

public class PngChunkHIST extends PngChunkSingle {
  private int[] h = new int[0];
  
  public PngChunkHIST(ImageInfo paramImageInfo) {
    super("hIST", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    if (this.e.g) {
      this.h = new int[paramChunkRaw.d.length / 2];
      int i = 0;
      while (true) {
        int[] arrayOfInt = this.h;
        if (i < arrayOfInt.length) {
          arrayOfInt[i] = PngHelperInternal.b(paramChunkRaw.d, i * 2);
          i++;
          continue;
        } 
        break;
      } 
      return;
    } 
    throw new PngjException("only indexed images accept a HIST chunk");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkHIST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */