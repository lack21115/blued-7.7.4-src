package ar.com.hjg.pngj.chunks;

public class PngMetadata {
  private final ChunksList a;
  
  private final boolean b;
  
  public PngMetadata(ChunksList paramChunksList) {
    this.a = paramChunksList;
    if (paramChunksList instanceof ChunksListForWrite) {
      this.b = false;
      return;
    } 
    this.b = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */