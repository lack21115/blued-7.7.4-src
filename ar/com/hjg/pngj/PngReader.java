package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunksList;
import ar.com.hjg.pngj.chunks.PngMetadata;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

public class PngReader {
  public final ImageInfo a;
  
  public final boolean b;
  
  protected final ChunkSeqReaderPng c;
  
  protected final BufferedStreamFeeder d;
  
  protected final PngMetadata e;
  
  protected int f = -1;
  
  private IImageLineSetFactory<? extends IImageLine> g;
  
  public PngReader(File paramFile) {
    this(PngHelperInternal.a(paramFile), true);
  }
  
  public PngReader(InputStream paramInputStream, boolean paramBoolean) {
    this.d = new BufferedStreamFeeder(paramInputStream);
    this.d.a(paramBoolean);
    this.c = f();
    try {
      BufferedStreamFeeder bufferedStreamFeeder = this.d;
      paramBoolean = true;
      bufferedStreamFeeder.b(true);
      if (this.d.b(this.c, 36)) {
        this.a = this.c.k();
        if (this.c.l() == null)
          paramBoolean = false; 
        this.b = paramBoolean;
        b(5024024L);
        a(901001001L);
        c(2024024L);
        this.c.c("fdAT");
        this.c.c("fcTL");
        this.e = new PngMetadata(this.c.f);
        a((IImageLineSetFactory)ImageLineSetDefault.a());
        this.f = -1;
        return;
      } 
      throw new PngjInputException("error reading first 21 bytes");
    } catch (RuntimeException runtimeException) {
      this.d.b();
      this.c.d();
      throw runtimeException;
    } 
  }
  
  public ChunksList a(boolean paramBoolean) {
    if (paramBoolean && this.c.h())
      a(); 
    return this.c.f;
  }
  
  protected void a() {
    while (this.c.e < 4) {
      if (this.d.a(this.c) > 0)
        continue; 
      throw new PngjInputException("premature ending reading first chunks");
    } 
  }
  
  public void a(long paramLong) {
    this.c.a(paramLong);
  }
  
  public void a(IImageLineSetFactory<? extends IImageLine> paramIImageLineSetFactory) {
    this.g = paramIImageLineSetFactory;
  }
  
  public void a(String paramString) {
    this.c.d(paramString);
  }
  
  public ChunksList b() {
    return a(true);
  }
  
  public void b(long paramLong) {
    this.c.c(paramLong);
  }
  
  public void c() {
    try {
      if (this.c.h())
        a(); 
      if (this.c.i() != null && !this.c.i().d())
        this.c.i().h(); 
      while (!this.c.a()) {
        int i = this.d.a(this.c);
        if (i <= 0)
          break; 
      } 
      return;
    } finally {
      d();
    } 
  }
  
  public void c(long paramLong) {
    this.c.b(paramLong);
  }
  
  public void d() {
    try {
      if (this.c != null)
        this.c.d(); 
    } catch (Exception exception) {
      Logger logger = PngHelperInternal.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("error closing chunk sequence:");
      stringBuilder.append(exception.getMessage());
      logger.warning(stringBuilder.toString());
    } 
    BufferedStreamFeeder bufferedStreamFeeder = this.d;
    if (bufferedStreamFeeder != null)
      bufferedStreamFeeder.b(); 
  }
  
  public ChunkSeqReaderPng e() {
    return this.c;
  }
  
  protected ChunkSeqReaderPng f() {
    return new ChunkSeqReaderPng(false);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.toString());
    stringBuilder.append(" interlaced=");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\PngReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */