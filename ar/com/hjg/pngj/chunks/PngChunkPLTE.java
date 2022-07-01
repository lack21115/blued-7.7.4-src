package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;

public class PngChunkPLTE extends PngChunkSingle {
  private int h = 0;
  
  private int[] i;
  
  public PngChunkPLTE(ImageInfo paramImageInfo) {
    super("PLTE", paramImageInfo);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.i[paramInt1] = paramInt2 << 16 | paramInt3 << 8 | paramInt4;
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    b(paramChunkRaw.a / 3);
    int i = 0;
    for (int j = 0; i < this.h; j++) {
      byte[] arrayOfByte = paramChunkRaw.d;
      int k = j + 1;
      byte b = arrayOfByte[j];
      arrayOfByte = paramChunkRaw.d;
      j = k + 1;
      a(i, b & 0xFF, arrayOfByte[k] & 0xFF, paramChunkRaw.d[j] & 0xFF);
      i++;
    } 
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
    paramInt = this.h;
    if (paramInt >= 1 && paramInt <= 256) {
      int[] arrayOfInt = this.i;
      if (arrayOfInt == null || arrayOfInt.length != paramInt)
        this.i = new int[this.h]; 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid pallette - nentries=");
    stringBuilder.append(this.h);
    throw new PngjException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkPLTE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */