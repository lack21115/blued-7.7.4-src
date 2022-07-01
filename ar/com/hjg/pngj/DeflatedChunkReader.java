package ar.com.hjg.pngj;

public class DeflatedChunkReader extends ChunkReader {
  protected final DeflatedChunksSet d;
  
  protected boolean e = false;
  
  protected boolean f = false;
  
  protected byte[] g;
  
  protected int h = -1;
  
  public DeflatedChunkReader(int paramInt, String paramString, boolean paramBoolean, long paramLong, DeflatedChunksSet paramDeflatedChunksSet) {
    super(paramInt, paramString, paramLong, ChunkReader.ChunkReaderMode.b);
    this.d = paramDeflatedChunksSet;
    if (paramString.equals("fdAT")) {
      this.f = true;
      this.g = new byte[4];
    } 
    paramDeflatedChunksSet.a(this);
  }
  
  public void a(int paramInt) {
    this.h = paramInt;
  }
  
  protected void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    int i = paramInt2;
    int j = paramInt3;
    if (this.f) {
      i = paramInt2;
      j = paramInt3;
      if (paramInt1 < 4)
        while (true) {
          i = paramInt2;
          j = paramInt3;
          if (paramInt1 < 4) {
            i = paramInt2;
            j = paramInt3;
            if (paramInt3 > 0) {
              this.g[paramInt1] = paramArrayOfbyte[paramInt2];
              paramInt1++;
              paramInt2++;
              paramInt3--;
              continue;
            } 
          } 
          break;
        }  
    } 
    if (j > 0) {
      this.d.a(paramArrayOfbyte, i, j);
      if (this.e)
        System.arraycopy(paramArrayOfbyte, i, (a()).d, this.b, j); 
    } 
  }
  
  protected void c() {
    if (this.f && (a()).c.equals("fdAT") && this.h >= 0) {
      int i = PngHelperInternal.c(this.g, 0);
      if (i == this.h)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("bad chunk sequence for fDAT chunk ");
      stringBuilder.append(i);
      stringBuilder.append(" expected ");
      stringBuilder.append(this.h);
      throw new PngjInputException(stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\DeflatedChunkReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */