package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkRaw;
import java.util.ArrayList;
import java.util.List;

public class ChunkSeqSkipping extends ChunkSeqReader {
  private List<ChunkRaw> a = new ArrayList<ChunkRaw>();
  
  private boolean c = true;
  
  public ChunkSeqSkipping() {
    this(true);
  }
  
  public ChunkSeqSkipping(boolean paramBoolean) {
    super(true);
    this.c = paramBoolean;
  }
  
  protected ChunkReader a(String paramString, int paramInt, long paramLong, boolean paramBoolean) {
    ChunkReader.ChunkReaderMode chunkReaderMode;
    if (paramBoolean) {
      chunkReaderMode = ChunkReader.ChunkReaderMode.c;
    } else {
      chunkReaderMode = ChunkReader.ChunkReaderMode.b;
    } 
    return new ChunkReader(this, paramInt, paramString, paramLong, chunkReaderMode) {
        protected void a(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
          this.c.a(a(), param1Int1, param1ArrayOfbyte, param1Int2, param1Int3);
        }
        
        protected void c() {
          this.c.a(this);
        }
      };
  }
  
  protected void a(ChunkReader paramChunkReader) {
    super.a(paramChunkReader);
    this.a.add(paramChunkReader.a());
  }
  
  protected void a(ChunkRaw paramChunkRaw, int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {}
  
  protected boolean a(String paramString) {
    return false;
  }
  
  protected boolean b(int paramInt, String paramString) {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ChunkSeqSkipping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */