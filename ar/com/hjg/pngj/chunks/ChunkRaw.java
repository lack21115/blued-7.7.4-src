package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjBadCrcException;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjOutputException;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;

public class ChunkRaw {
  public final int a;
  
  public final byte[] b;
  
  public final String c;
  
  public byte[] d = null;
  
  public byte[] e = new byte[4];
  
  private long f = 0L;
  
  private CRC32 g;
  
  public ChunkRaw(int paramInt, String paramString, boolean paramBoolean) {
    this.a = paramInt;
    this.c = paramString;
    this.b = ChunkHelper.a(paramString);
    paramInt = 0;
    while (paramInt < 4) {
      byte[] arrayOfByte = this.b;
      if (arrayOfByte[paramInt] >= 65 && arrayOfByte[paramInt] <= 122 && (arrayOfByte[paramInt] <= 90 || arrayOfByte[paramInt] >= 97)) {
        paramInt++;
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Bad id chunk: must be ascii letters ");
      stringBuilder.append(paramString);
      throw new PngjException(stringBuilder.toString());
    } 
    if (paramBoolean)
      a(); 
  }
  
  public ChunkRaw(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
    this(paramInt, ChunkHelper.a(paramArrayOfbyte), paramBoolean);
  }
  
  private void e() {
    this.g = new CRC32();
    this.g.update(this.b, 0, 4);
    int i = this.a;
    if (i > 0)
      this.g.update(this.d, 0, i); 
    PngHelperInternal.a((int)this.g.getValue(), this.e, 0);
  }
  
  public void a() {
    byte[] arrayOfByte = this.d;
    if (arrayOfByte == null || arrayOfByte.length < this.a)
      this.d = new byte[this.a]; 
  }
  
  public void a(long paramLong) {
    this.f = paramLong;
  }
  
  public void a(OutputStream paramOutputStream) {
    StringBuilder stringBuilder;
    b(paramOutputStream);
    int i = this.a;
    if (i > 0) {
      byte[] arrayOfByte = this.d;
      if (arrayOfByte != null) {
        PngHelperInternal.a(paramOutputStream, arrayOfByte, 0, i);
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("cannot write chunk, raw chunk data is null [");
        stringBuilder.append(this.c);
        stringBuilder.append("]");
        throw new PngjOutputException(stringBuilder.toString());
      } 
    } 
    e();
    c((OutputStream)stringBuilder);
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.g == null)
      this.g = new CRC32(); 
    this.g.update(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void b() {
    int i = (int)this.g.getValue();
    int j = PngHelperInternal.c(this.e, 0);
    if (i == j)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("chunk: ");
    stringBuilder.append(toString());
    stringBuilder.append(" expected=");
    stringBuilder.append(j);
    stringBuilder.append(" read=");
    stringBuilder.append(i);
    throw new PngjBadCrcException(stringBuilder.toString());
  }
  
  public void b(OutputStream paramOutputStream) {
    if (this.b.length == 4) {
      PngHelperInternal.a(paramOutputStream, this.a);
      PngHelperInternal.a(paramOutputStream, this.b);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bad chunkid [");
    stringBuilder.append(this.c);
    stringBuilder.append("]");
    throw new PngjOutputException(stringBuilder.toString());
  }
  
  ByteArrayInputStream c() {
    return new ByteArrayInputStream(this.d);
  }
  
  public void c(OutputStream paramOutputStream) {
    PngHelperInternal.a(paramOutputStream, this.e, 0, 4);
  }
  
  public long d() {
    return this.f;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    String str = this.c;
    if (str == null) {
      if (((ChunkRaw)paramObject).c != null)
        return false; 
    } else if (!str.equals(((ChunkRaw)paramObject).c)) {
      return false;
    } 
    return !(this.f != ((ChunkRaw)paramObject).f);
  }
  
  public int hashCode() {
    int i;
    String str = this.c;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    long l = this.f;
    return (i + 31) * 31 + (int)(l ^ l >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("chunkid=");
    stringBuilder.append(ChunkHelper.a(this.b));
    stringBuilder.append(" len=");
    stringBuilder.append(this.a);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\ChunkRaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */