package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkFactory;
import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkLoadBehaviour;
import ar.com.hjg.pngj.chunks.ChunksList;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkIHDR;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChunkSeqReaderPng extends ChunkSeqReader {
  protected ImageInfo a;
  
  protected ImageInfo c;
  
  protected Deinterlacer d;
  
  protected int e = -1;
  
  protected ChunksList f = null;
  
  protected final boolean g;
  
  private long h = 0L;
  
  private boolean i = true;
  
  private boolean j = false;
  
  private Set<String> k = new HashSet<String>();
  
  private long l = 0L;
  
  private long m = 0L;
  
  private long n = 0L;
  
  private IChunkFactory o;
  
  private ChunkLoadBehaviour p = ChunkLoadBehaviour.d;
  
  public ChunkSeqReaderPng(boolean paramBoolean) {
    this.g = paramBoolean;
    this.o = (IChunkFactory)new ChunkFactory();
  }
  
  private void f(String paramString) {
    if (paramString.equals("IHDR")) {
      if (this.e < 0) {
        this.e = 0;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected chunk ");
      stringBuilder.append(paramString);
      throw new PngjInputException(stringBuilder.toString());
    } 
    if (paramString.equals("PLTE")) {
      int j = this.e;
      if (j == 0 || j == 1) {
        this.e = 2;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected chunk ");
      stringBuilder.append(paramString);
      throw new PngjInputException(stringBuilder.toString());
    } 
    if (paramString.equals("IDAT")) {
      int j = this.e;
      if (j >= 0 && j <= 4) {
        this.e = 4;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected chunk ");
      stringBuilder.append(paramString);
      throw new PngjInputException(stringBuilder.toString());
    } 
    if (paramString.equals("IEND")) {
      if (this.e >= 4) {
        this.e = 6;
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected chunk ");
      stringBuilder.append(paramString);
      throw new PngjInputException(stringBuilder.toString());
    } 
    int i = this.e;
    if (i <= 1) {
      this.e = 1;
      return;
    } 
    if (i <= 3) {
      this.e = 3;
      return;
    } 
    this.e = 5;
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return super.a(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString, long paramLong) {
    f(paramString);
    super.a(paramInt, paramString, paramLong);
  }
  
  public void a(long paramLong) {
    this.l = paramLong;
  }
  
  public void a(ChunkReader paramChunkReader) {
    super.a(paramChunkReader);
    if ((paramChunkReader.a()).c.equals("IHDR")) {
      PngChunkIHDR pngChunkIHDR = new PngChunkIHDR(null);
      pngChunkIHDR.a(paramChunkReader.a());
      this.a = pngChunkIHDR.l();
      this.c = this.a;
      if (pngChunkIHDR.k())
        this.d = new Deinterlacer(this.c); 
      this.f = new ChunksList(this.a);
    } 
    if (paramChunkReader.a == ChunkReader.ChunkReaderMode.a && e((paramChunkReader.a()).c))
      this.h += (paramChunkReader.a()).a; 
    if (paramChunkReader.a == ChunkReader.ChunkReaderMode.a || this.j) {
      PngChunk pngChunk = this.o.a(paramChunkReader.a(), k());
      this.f.a(pngChunk, this.e);
    } 
    if (a())
      j(); 
  }
  
  public void a(ImageInfo paramImageInfo) {
    if (!paramImageInfo.equals(this.c))
      this.c = paramImageInfo; 
    if (this.d != null)
      this.d = new Deinterlacer(this.c); 
  }
  
  protected boolean a(int paramInt, String paramString) {
    return this.i;
  }
  
  protected boolean a(String paramString) {
    return paramString.equals("IDAT");
  }
  
  protected DeflatedChunksSet b(String paramString) {
    IdatSet idatSet = new IdatSet(paramString, n(), this.d);
    idatSet.a(this.g);
    return idatSet;
  }
  
  public void b(long paramLong) {
    this.m = paramLong;
  }
  
  public boolean b(int paramInt, String paramString) {
    if (super.b(paramInt, paramString))
      return true; 
    if (ChunkHelper.b(paramString))
      return false; 
    if (this.l <= 0L || paramInt + b() <= this.l) {
      if (this.k.contains(paramString))
        return true; 
      long l = this.m;
      if (l > 0L && paramInt > l)
        return true; 
      l = this.n;
      if (l > 0L && paramInt > l - this.h)
        return true; 
      paramInt = null.a[this.p.ordinal()];
      return (paramInt != 1) ? (!(paramInt != 2)) : (!ChunkHelper.d(paramString));
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Maximum total bytes to read exceeeded: ");
    stringBuilder.append(this.l);
    stringBuilder.append(" offset:");
    stringBuilder.append(b());
    stringBuilder.append(" len=");
    stringBuilder.append(paramInt);
    throw new PngjInputException(stringBuilder.toString());
  }
  
  public void c(long paramLong) {
    this.n = paramLong;
  }
  
  public void c(String paramString) {
    this.k.add(paramString);
  }
  
  public void d() {
    if (this.e != 6)
      this.e = 6; 
    super.d();
  }
  
  public void d(String paramString) {
    this.k.remove(paramString);
  }
  
  protected boolean e(String paramString) {
    return ChunkHelper.b(paramString) ^ true;
  }
  
  public int g() {
    return this.e;
  }
  
  public boolean h() {
    return (g() < 4);
  }
  
  public IdatSet i() {
    DeflatedChunksSet deflatedChunksSet = c();
    return (deflatedChunksSet instanceof IdatSet) ? (IdatSet)deflatedChunksSet : null;
  }
  
  protected void j() {}
  
  public ImageInfo k() {
    return this.a;
  }
  
  public Deinterlacer l() {
    return this.d;
  }
  
  public List<PngChunk> m() {
    return this.f.a();
  }
  
  public ImageInfo n() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ChunkSeqReaderPng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */