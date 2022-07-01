package ar.com.hjg.pngj;

import java.util.Arrays;
import java.util.zip.Inflater;

public class IdatSet extends DeflatedChunksSet {
  protected byte[] f;
  
  protected byte[] g;
  
  protected final ImageInfo h;
  
  protected final Deinterlacer i;
  
  final RowInfo j;
  
  protected int[] k;
  
  public IdatSet(String paramString, ImageInfo paramImageInfo, Deinterlacer paramDeinterlacer) {
    this(paramString, paramImageInfo, paramDeinterlacer, (Inflater)null, (byte[])null);
  }
  
  public IdatSet(String paramString, ImageInfo paramImageInfo, Deinterlacer paramDeinterlacer, Inflater paramInflater, byte[] paramArrayOfbyte) {
    super(paramString, i + 1, paramImageInfo.k + 1, paramInflater, paramArrayOfbyte);
    int i;
    this.k = new int[5];
    this.h = paramImageInfo;
    this.i = paramDeinterlacer;
    this.j = new RowInfo(paramImageInfo, paramDeinterlacer);
  }
  
  private void c(int paramInt) {
    int i = this.h.j;
    int j = 1;
    for (i = 1 - i; j <= paramInt; i++) {
      byte b;
      if (i > 0) {
        b = this.f[i] & 0xFF;
      } else {
        b = 0;
      } 
      this.f[j] = (byte)(this.a[j] + (b + (this.g[j] & 0xFF)) / 2);
      j++;
    } 
  }
  
  private void d(int paramInt) {
    for (int i = 1; i <= paramInt; i++)
      this.f[i] = this.a[i]; 
  }
  
  private void e(int paramInt) {
    int i = this.h.j;
    int j = 1;
    for (i = 1 - i; j <= paramInt; i++) {
      boolean bool;
      int k = 0;
      if (i > 0) {
        bool = this.f[i] & 0xFF;
      } else {
        bool = false;
      } 
      if (i > 0)
        k = this.g[i] & 0xFF; 
      this.f[j] = (byte)(this.a[j] + PngHelperInternal.a(bool, this.g[j] & 0xFF, k));
      j++;
    } 
  }
  
  private void f(int paramInt) {
    int i;
    for (i = 1; i <= this.h.j; i++)
      this.f[i] = this.a[i]; 
    int j = this.h.j + 1;
    for (i = 1; j <= paramInt; i++) {
      this.f[j] = (byte)(this.a[j] + this.f[i]);
      j++;
    } 
  }
  
  private void g(int paramInt) {
    for (int i = 1; i <= paramInt; i++)
      this.f[i] = (byte)(this.a[i] + this.g[i]); 
  }
  
  protected void a() {
    super.a();
    this.j.a(i());
    k();
    RowInfo rowInfo = this.j;
    rowInfo.a(this.f, rowInfo.m + 1);
  }
  
  protected int b() {
    return l();
  }
  
  protected void b(int paramInt) {
    byte[] arrayOfByte = this.f;
    if (arrayOfByte == null || arrayOfByte.length < this.a.length) {
      this.f = new byte[this.a.length];
      this.g = new byte[this.a.length];
    } 
    if (this.j.j == 0)
      Arrays.fill(this.f, (byte)0); 
    arrayOfByte = this.f;
    this.f = this.g;
    this.g = arrayOfByte;
    byte b = this.a[0];
    if (FilterType.b(b)) {
      FilterType filterType = FilterType.a(b);
      int[] arrayOfInt = this.k;
      arrayOfInt[b] = arrayOfInt[b] + 1;
      this.f[0] = this.a[0];
      int i = null.a[filterType.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i == 5) {
                e(paramInt);
                return;
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Filter type ");
              stringBuilder1.append(b);
              stringBuilder1.append(" not implemented");
              throw new PngjInputException(stringBuilder1.toString());
            } 
            c(paramInt);
            return;
          } 
          g(paramInt);
          return;
        } 
        f(paramInt);
        return;
      } 
      d(paramInt);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Filter type ");
    stringBuilder.append(b);
    stringBuilder.append(" invalid");
    throw new PngjInputException(stringBuilder.toString());
  }
  
  protected void c() {
    super.c();
  }
  
  public void g() {
    super.g();
    this.f = null;
    this.g = null;
  }
  
  public void k() {
    b(this.j.m);
  }
  
  public int l() {
    // Byte code:
    //   0: aload_0
    //   1: getfield i : Lar/com/hjg/pngj/Deinterlacer;
    //   4: astore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: aload_2
    //   8: ifnonnull -> 45
    //   11: aload_0
    //   12: invokevirtual i : ()I
    //   15: aload_0
    //   16: getfield h : Lar/com/hjg/pngj/ImageInfo;
    //   19: getfield b : I
    //   22: iconst_1
    //   23: isub
    //   24: if_icmplt -> 30
    //   27: goto -> 63
    //   30: aload_0
    //   31: getfield h : Lar/com/hjg/pngj/ImageInfo;
    //   34: getfield k : I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_1
    //   40: iadd
    //   41: istore_1
    //   42: goto -> 63
    //   45: aload_2
    //   46: invokevirtual a : ()Z
    //   49: ifeq -> 63
    //   52: aload_0
    //   53: getfield i : Lar/com/hjg/pngj/Deinterlacer;
    //   56: invokevirtual h : ()I
    //   59: istore_1
    //   60: goto -> 38
    //   63: aload_0
    //   64: invokevirtual j : ()Z
    //   67: ifne -> 75
    //   70: aload_0
    //   71: iload_1
    //   72: invokevirtual a : (I)V
    //   75: iload_1
    //   76: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\IdatSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */