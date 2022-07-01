package ar.com.hjg.pngj;

class RowInfo {
  public final ImageInfo a;
  
  public final Deinterlacer b;
  
  public final boolean c;
  
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  int i;
  
  int j;
  
  int k;
  
  int l;
  
  int m;
  
  int n;
  
  byte[] o;
  
  int p;
  
  public RowInfo(ImageInfo paramImageInfo, Deinterlacer paramDeinterlacer) {
    boolean bool;
    this.a = paramImageInfo;
    this.b = paramDeinterlacer;
    if (paramDeinterlacer != null) {
      bool = true;
    } else {
      bool = false;
    } 
    this.c = bool;
  }
  
  void a(int paramInt) {
    this.h = paramInt;
    if (this.c) {
      this.n = this.b.d();
      this.e = this.b.c;
      this.d = this.b.b;
      this.g = this.b.e;
      this.f = this.b.d;
      this.i = this.b.c();
      this.j = this.b.b();
      this.k = this.b.e();
      this.l = this.b.f();
      this.m = (this.a.i * this.l + 7) / 8;
      return;
    } 
    this.n = 1;
    this.d = 1;
    this.e = 1;
    this.f = 0;
    this.g = 0;
    this.j = paramInt;
    this.i = paramInt;
    this.k = this.a.b;
    this.l = this.a.a;
    this.m = this.a.k;
  }
  
  void a(byte[] paramArrayOfbyte, int paramInt) {
    this.o = paramArrayOfbyte;
    this.p = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\RowInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */