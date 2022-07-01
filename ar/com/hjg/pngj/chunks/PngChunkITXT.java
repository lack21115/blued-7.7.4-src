package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

public class PngChunkITXT extends PngChunkTextVar {
  private boolean j = false;
  
  private String k = "";
  
  private String l = "";
  
  public PngChunkITXT(ImageInfo paramImageInfo) {
    super("iTXt", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    int k;
    int[] arrayOfInt = new int[3];
    int i = 0;
    int j = 0;
    while (true) {
      k = j;
      if (i < paramChunkRaw.d.length) {
        if (paramChunkRaw.d[i] == 0) {
          arrayOfInt[j] = i;
          k = j + 1;
          j = i;
          if (k == 1)
            j = i + 2; 
          i = j;
          j = k;
          if (k == 3)
            break; 
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (k == 3) {
      boolean bool;
      this.h = ChunkHelper.a(paramChunkRaw.d, 0, arrayOfInt[0]);
      i = arrayOfInt[0] + 1;
      if (paramChunkRaw.d[i] == 0) {
        bool = false;
      } else {
        bool = true;
      } 
      this.j = bool;
      if (!this.j || paramChunkRaw.d[++i] == 0) {
        this.k = ChunkHelper.a(paramChunkRaw.d, i, arrayOfInt[1] - i);
        this.l = ChunkHelper.b(paramChunkRaw.d, arrayOfInt[1] + 1, arrayOfInt[2] - arrayOfInt[1] - 1);
        i = arrayOfInt[2] + 1;
        if (this.j) {
          this.i = ChunkHelper.b(ChunkHelper.a(paramChunkRaw.d, i, paramChunkRaw.d.length - i, false));
          return;
        } 
        this.i = ChunkHelper.b(paramChunkRaw.d, i, paramChunkRaw.d.length - i);
        return;
      } 
      throw new PngjException("Bad formed PngChunkITXT chunk - bad compression method ");
    } 
    throw new PngjException("Bad formed PngChunkITXT chunk");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkITXT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */