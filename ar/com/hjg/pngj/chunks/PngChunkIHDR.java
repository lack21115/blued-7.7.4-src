package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjInputException;
import java.io.ByteArrayInputStream;

public class PngChunkIHDR extends PngChunkSingle {
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  public PngChunkIHDR(ImageInfo paramImageInfo) {
    super("IHDR", paramImageInfo);
    if (paramImageInfo != null)
      a(paramImageInfo); 
  }
  
  public void a(ImageInfo paramImageInfo) {
    b(this.e.a);
    c(this.e.b);
    d(this.e.c);
    if (this.e.e) {
      j = 4;
    } else {
      j = 0;
    } 
    int i = j;
    if (this.e.g)
      i = j + 1; 
    int j = i;
    if (!this.e.f)
      j = i + 2; 
    e(j);
    f(0);
    g(0);
    h(0);
  }
  
  public void a(ChunkRaw paramChunkRaw) {
    ByteArrayInputStream byteArrayInputStream;
    if (paramChunkRaw.a == 13) {
      byteArrayInputStream = paramChunkRaw.c();
      this.h = PngHelperInternal.b(byteArrayInputStream);
      this.i = PngHelperInternal.b(byteArrayInputStream);
      this.j = PngHelperInternal.a(byteArrayInputStream);
      this.k = PngHelperInternal.a(byteArrayInputStream);
      this.l = PngHelperInternal.a(byteArrayInputStream);
      this.m = PngHelperInternal.a(byteArrayInputStream);
      this.n = PngHelperInternal.a(byteArrayInputStream);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad IDHR len ");
    stringBuilder.append(((ChunkRaw)byteArrayInputStream).a);
    throw new PngjException(stringBuilder.toString());
  }
  
  public void b(int paramInt) {
    this.h = paramInt;
  }
  
  public void c(int paramInt) {
    this.i = paramInt;
  }
  
  public void d(int paramInt) {
    this.j = paramInt;
  }
  
  public ChunkRaw e() {
    ChunkRaw chunkRaw = new ChunkRaw(13, ChunkHelper.a, true);
    PngHelperInternal.a(this.h, chunkRaw.d, 0);
    PngHelperInternal.a(this.i, chunkRaw.d, 4);
    chunkRaw.d[8] = (byte)this.j;
    chunkRaw.d[9] = (byte)this.k;
    chunkRaw.d[10] = (byte)this.l;
    chunkRaw.d[11] = (byte)this.m;
    chunkRaw.d[12] = (byte)this.n;
    return chunkRaw;
  }
  
  public void e(int paramInt) {
    this.k = paramInt;
  }
  
  public int f() {
    return this.h;
  }
  
  public void f(int paramInt) {
    this.l = paramInt;
  }
  
  public int g() {
    return this.i;
  }
  
  public void g(int paramInt) {
    this.m = paramInt;
  }
  
  public int h() {
    return this.j;
  }
  
  public void h(int paramInt) {
    this.n = paramInt;
  }
  
  public int i() {
    return this.k;
  }
  
  public int j() {
    return this.n;
  }
  
  public boolean k() {
    return (j() == 1);
  }
  
  public ImageInfo l() {
    boolean bool1;
    boolean bool2;
    m();
    if ((i() & 0x4) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((i() & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (i() == 0 || i() == 4) {
      boolean bool = true;
      return new ImageInfo(f(), g(), h(), bool1, bool, bool2);
    } 
    boolean bool3 = false;
    return new ImageInfo(f(), g(), h(), bool1, bool3, bool2);
  }
  
  public void m() {
    if (this.h >= 1 && this.i >= 1 && this.l == 0 && this.m == 0) {
      int i = this.j;
      if (i == 1 || i == 2 || i == 4 || i == 8 || i == 16) {
        i = this.n;
        if (i >= 0 && i <= 1) {
          i = this.k;
          if (i != 0) {
            if (i != 6 && i != 2)
              if (i != 3) {
                if (i != 4)
                  throw new PngjInputException("bad IHDR: invalid colormodel"); 
              } else {
                if (this.j != 16)
                  return; 
                throw new PngjInputException("bad IHDR: bitdepth invalid");
              }  
            i = this.j;
            if (i != 8) {
              if (i == 16)
                return; 
              throw new PngjInputException("bad IHDR: bitdepth invalid");
            } 
          } 
          return;
        } 
        throw new PngjInputException("bad IHDR: interlace invalid");
      } 
      throw new PngjInputException("bad IHDR: bitdepth invalid");
    } 
    throw new PngjInputException("bad IHDR: col/row/compmethod/filmethod invalid");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\PngChunkIHDR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */