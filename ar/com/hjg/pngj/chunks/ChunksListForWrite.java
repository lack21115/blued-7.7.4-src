package ar.com.hjg.pngj.chunks;

import java.util.List;

public class ChunksListForWrite extends ChunksList {
  private final List<PngChunk> d;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ChunkList: written: ");
    stringBuilder.append(a().size());
    stringBuilder.append(" queue: ");
    stringBuilder.append(this.d.size());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\ChunksListForWrite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */