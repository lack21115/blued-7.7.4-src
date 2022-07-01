package ar.com.hjg.pngj;

public class Deinterlacer {
  final ImageInfo a;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private boolean o = false;
  
  public Deinterlacer(ImageInfo paramImageInfo) {
    this.a = paramImageInfo;
    this.i = 0;
    this.l = -1;
    this.m = -1;
    this.n = 0;
    this.o = false;
    this.h = 0;
    a(1);
    c(0);
  }
  
  static byte[] b(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("bad interlace pass");
        stringBuilder.append(paramInt);
        throw new PngjExceptionInternal(stringBuilder.toString());
      case 7:
        return new byte[] { 1, 2, 0, 1 };
      case 6:
        return new byte[] { 2, 2, 1, 0 };
      case 5:
        return new byte[] { 2, 4, 0, 2 };
      case 4:
        return new byte[] { 4, 4, 2, 0 };
      case 3:
        return new byte[] { 4, 8, 0, 4 };
      case 2:
        return new byte[] { 8, 8, 4, 0 };
      case 1:
        break;
    } 
    return new byte[] { 8, 8, 0, 0 };
  }
  
  private void c(int paramInt) {
    this.l = paramInt;
    this.m = paramInt * this.b + this.d;
    paramInt = this.m;
    if (paramInt >= 0 && paramInt < this.a.b)
      return; 
    throw new PngjExceptionInternal("bad row - this should not happen");
  }
  
  void a(int paramInt) {
    if (this.i == paramInt)
      return; 
    this.i = paramInt;
    byte[] arrayOfByte = b(paramInt);
    this.c = arrayOfByte[0];
    this.b = arrayOfByte[1];
    this.e = arrayOfByte[2];
    this.d = arrayOfByte[3];
    if (this.a.b > this.d) {
      paramInt = this.a.b;
      int i = this.b;
      paramInt = (paramInt + i - 1 - this.d) / i;
    } else {
      paramInt = 0;
    } 
    this.j = paramInt;
    if (this.a.a > this.e) {
      paramInt = this.a.a;
      int i = this.c;
      paramInt = (paramInt + i - 1 - this.e) / i;
    } else {
      paramInt = 0;
    } 
    this.k = paramInt;
    if (this.k == 0)
      this.j = 0; 
    this.g = this.c * this.a.d;
    this.f = this.e * this.a.d;
  }
  
  boolean a() {
    this.n++;
    int i = this.j;
    if (i != 0) {
      int j = this.l;
      if (j < i - 1) {
        c(j + 1);
        return true;
      } 
    } 
    i = this.i;
    if (i == 7) {
      this.o = true;
      return false;
    } 
    a(i + 1);
    if (this.j == 0) {
      this.n--;
      return a();
    } 
    c(0);
    return true;
  }
  
  int b() {
    return this.l;
  }
  
  int c() {
    return this.m;
  }
  
  int d() {
    return this.i;
  }
  
  int e() {
    return this.j;
  }
  
  int f() {
    return this.k;
  }
  
  public int g() {
    return f();
  }
  
  public int h() {
    return (this.a.i * g() + 7) / 8;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\Deinterlacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */