package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkHelper;
import java.util.Arrays;

public class ChunkSeqReader implements IBytesConsumer {
  private byte[] a = new byte[8];
  
  protected final boolean b;
  
  private int c = 0;
  
  private boolean d = false;
  
  private boolean e = false;
  
  private int f = 0;
  
  private long g = 0L;
  
  private DeflatedChunksSet h;
  
  private ChunkReader i;
  
  private long j;
  
  public ChunkSeqReader() {
    this(true);
  }
  
  public ChunkSeqReader(boolean paramBoolean) {
    this.b = paramBoolean;
    this.d = paramBoolean ^ true;
  }
  
  public int a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.e)
      return -1; 
    if (paramInt2 == 0)
      return 0; 
    if (paramInt2 >= 0) {
      if (this.d) {
        ChunkReader chunkReader = this.i;
        if (chunkReader == null || chunkReader.b()) {
          int j = 8 - this.c;
          if (j <= paramInt2)
            paramInt2 = j; 
          System.arraycopy(paramArrayOfbyte, paramInt1, this.a, this.c, paramInt2);
          this.c += paramInt2;
          j = 0 + paramInt2;
          this.g += paramInt2;
          paramInt1 = j;
          if (this.c == 8) {
            this.f++;
            a(PngHelperInternal.c(this.a, 0), ChunkHelper.a(this.a, 4, 4), this.g - 8L);
            this.c = 0;
            return j;
          } 
          return paramInt1;
        } 
        paramInt1 = this.i.a(paramArrayOfbyte, paramInt1, paramInt2);
        this.g += paramInt1;
        return paramInt1 + 0;
      } 
      int i = 8 - this.c;
      if (i <= paramInt2)
        paramInt2 = i; 
      System.arraycopy(paramArrayOfbyte, paramInt1, this.a, this.c, paramInt2);
      this.c += paramInt2;
      if (this.c == 8) {
        a(this.a);
        this.c = 0;
        this.d = true;
      } 
      paramInt1 = 0 + paramInt2;
      this.g += paramInt2;
      return paramInt1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad len: ");
    stringBuilder.append(paramInt2);
    throw new PngjInputException(stringBuilder.toString());
  }
  
  protected ChunkReader a(String paramString, int paramInt, long paramLong, boolean paramBoolean) {
    ChunkReader.ChunkReaderMode chunkReaderMode;
    if (paramBoolean) {
      chunkReaderMode = ChunkReader.ChunkReaderMode.c;
    } else {
      chunkReaderMode = ChunkReader.ChunkReaderMode.a;
    } 
    return new ChunkReader(this, paramInt, paramString, paramLong, chunkReaderMode) {
        protected void a(int param1Int1, byte[] param1ArrayOfbyte, int param1Int2, int param1Int3) {
          throw new PngjExceptionInternal("should never happen");
        }
        
        protected void c() {
          this.c.a(this);
        }
      };
  }
  
  protected void a(int paramInt, String paramString, long paramLong) {
    boolean bool;
    if (paramString.equals("IDAT"))
      this.j += paramInt; 
    boolean bool1 = a(paramInt, paramString);
    boolean bool2 = b(paramInt, paramString);
    boolean bool3 = a(paramString);
    DeflatedChunksSet deflatedChunksSet = this.h;
    if (deflatedChunksSet != null) {
      bool = deflatedChunksSet.a(paramString);
    } else {
      bool = false;
    } 
    if (bool3 && !bool2) {
      if (!bool) {
        deflatedChunksSet = this.h;
        if (deflatedChunksSet == null || deflatedChunksSet.d()) {
          this.h = b(paramString);
        } else {
          throw new PngjInputException("new IDAT-like chunk when previous was not done");
        } 
      } 
      this.i = new DeflatedChunkReader(this, paramInt, paramString, bool1, paramLong, this.h) {
          protected void c() {
            super.c();
            this.c.a(this);
          }
        };
      return;
    } 
    this.i = a(paramString, paramInt, paramLong, bool2);
    if (!bool1)
      this.i.a(false); 
  }
  
  protected void a(ChunkReader paramChunkReader) {
    if (this.f == 1) {
      String str = e();
      if (str != null && !str.equals((paramChunkReader.a()).c)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bad first chunk: ");
        stringBuilder.append((paramChunkReader.a()).c);
        stringBuilder.append(" expected: ");
        stringBuilder.append(e());
        throw new PngjInputException(stringBuilder.toString());
      } 
    } 
    if ((paramChunkReader.a()).c.equals(f()))
      this.e = true; 
  }
  
  protected void a(byte[] paramArrayOfbyte) {
    if (Arrays.equals(paramArrayOfbyte, PngHelperInternal.a()))
      return; 
    throw new PngjInputException("Bad PNG signature");
  }
  
  public boolean a() {
    return this.e;
  }
  
  protected boolean a(int paramInt, String paramString) {
    return true;
  }
  
  protected boolean a(String paramString) {
    return false;
  }
  
  public long b() {
    return this.g;
  }
  
  protected DeflatedChunksSet b(String paramString) {
    return new DeflatedChunksSet(paramString, 1024, 1024);
  }
  
  protected boolean b(int paramInt, String paramString) {
    return false;
  }
  
  public boolean b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    while (paramInt2 > 0) {
      int i = a(paramArrayOfbyte, paramInt1, paramInt2);
      if (i < 1)
        return false; 
      paramInt2 -= i;
      paramInt1 += i;
    } 
    return true;
  }
  
  public DeflatedChunksSet c() {
    return this.h;
  }
  
  public void d() {
    DeflatedChunksSet deflatedChunksSet = this.h;
    if (deflatedChunksSet != null)
      deflatedChunksSet.g(); 
    this.e = true;
  }
  
  protected String e() {
    return "IHDR";
  }
  
  protected String f() {
    return "IEND";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ChunkSeqReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */