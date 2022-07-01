package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;

public class PngChunkFCTL extends PngChunkMultiple {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private byte o;
  
  private byte p;
  
  public PngChunkFCTL(ImageInfo paramImageInfo) {
    super("fcTL", paramImageInfo);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    this.h = PngHelperInternal.c(paramChunkRaw.d, 0);
    this.i = PngHelperInternal.c(paramChunkRaw.d, 4);
    this.j = PngHelperInternal.c(paramChunkRaw.d, 8);
    this.k = PngHelperInternal.c(paramChunkRaw.d, 12);
    this.l = PngHelperInternal.c(paramChunkRaw.d, 16);
    this.m = PngHelperInternal.b(paramChunkRaw.d, 20);
    this.n = PngHelperInternal.b(paramChunkRaw.d, 22);
    this.o = paramChunkRaw.d[24];
    this.p = paramChunkRaw.d[25];
  }
  
  public ImageInfo e() {
    return new ImageInfo(this.i, this.j, this.e.c, this.e.e, this.e.f, this.e.g);
  }
  
  public int f() {
    return this.k;
  }
  
  public int g() {
    return this.l;
  }
  
  public int h() {
    return this.m;
  }
  
  public int i() {
    return this.n;
  }
  
  public byte j() {
    return this.o;
  }
  
  public byte k() {
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkFCTL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */