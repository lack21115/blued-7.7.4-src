package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;

public abstract class PngChunk {
  public final String a;
  
  public final boolean b;
  
  public final boolean c;
  
  public final boolean d;
  
  protected final ImageInfo e;
  
  protected ChunkRaw f;
  
  protected int g = -1;
  
  private boolean h = false;
  
  public PngChunk(String paramString, ImageInfo paramImageInfo) {
    this.a = paramString;
    this.e = paramImageInfo;
    this.b = ChunkHelper.b(paramString);
    this.c = ChunkHelper.c(paramString);
    this.d = ChunkHelper.d(paramString);
  }
  
  final void a(int paramInt) {
    this.g = paramInt;
  }
  
  protected abstract void a(ChunkRaw paramChunkRaw);
  
  protected abstract boolean a();
  
  public ChunkRaw b() {
    return this.f;
  }
  
  void b(ChunkRaw paramChunkRaw) {
    this.f = paramChunkRaw;
  }
  
  public int c() {
    ChunkRaw chunkRaw = this.f;
    return (chunkRaw != null) ? chunkRaw.a : -1;
  }
  
  public long d() {
    ChunkRaw chunkRaw = this.f;
    return (chunkRaw != null) ? chunkRaw.d() : -1L;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("chunk id= ");
    stringBuilder.append(this.a);
    stringBuilder.append(" (len=");
    stringBuilder.append(c());
    stringBuilder.append(" offset=");
    stringBuilder.append(d());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public enum ChunkOrderingConstraint {
    a, b, c, d, e, f, g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */