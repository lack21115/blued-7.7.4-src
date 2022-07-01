package ar.com.hjg.pngj;

public class ImageInfo {
  public final int a;
  
  public final int b;
  
  public final int c;
  
  public final int d;
  
  public final boolean e;
  
  public final boolean f;
  
  public final boolean g;
  
  public final boolean h;
  
  public final int i;
  
  public final int j;
  
  public final int k;
  
  public final int l;
  
  public final int m;
  
  private long n = -1L;
  
  private long o = -1L;
  
  public ImageInfo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.e = paramBoolean1;
    this.g = paramBoolean3;
    this.f = paramBoolean2;
    if (!this.f || !paramBoolean3) {
      if (paramBoolean2 || paramBoolean3) {
        if (paramBoolean1) {
          i = 2;
        } else {
          i = 1;
        } 
      } else if (paramBoolean1) {
        i = 4;
      } else {
        i = 3;
      } 
      this.d = i;
      this.c = paramInt3;
      if (paramInt3 < 8) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      } 
      this.h = paramBoolean1;
      paramInt3 = this.d;
      this.i = this.c * paramInt3;
      int i = this.i;
      this.j = (i + 7) / 8;
      this.k = (i * paramInt1 + 7) / 8;
      this.l = paramInt3 * this.a;
      if (this.h) {
        paramInt3 = this.k;
      } else {
        paramInt3 = this.l;
      } 
      this.m = paramInt3;
      paramInt3 = this.c;
      if (paramInt3 != 1 && paramInt3 != 2 && paramInt3 != 4) {
        if (paramInt3 != 8)
          if (paramInt3 == 16) {
            if (this.g) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("indexed can't have bitdepth=");
              stringBuilder1.append(this.c);
              throw new PngjException(stringBuilder1.toString());
            } 
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("invalid bitdepth=");
            stringBuilder1.append(this.c);
            throw new PngjException(stringBuilder1.toString());
          }  
      } else if (!this.g && !this.f) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("only indexed or grayscale can have bitdepth=");
        stringBuilder1.append(this.c);
        throw new PngjException(stringBuilder1.toString());
      } 
      if (paramInt1 >= 1 && paramInt1 <= 16777216) {
        if (paramInt2 >= 1 && paramInt2 <= 16777216) {
          if (this.l >= 1)
            return; 
          throw new PngjException("invalid image parameters (overflow?)");
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("invalid rows=");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" ???");
        throw new PngjException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid cols=");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" ???");
      throw new PngjException(stringBuilder.toString());
    } 
    throw new PngjException("palette and greyscale are mutually exclusive");
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (this.e != ((ImageInfo)paramObject).e) ? false : ((this.c != ((ImageInfo)paramObject).c) ? false : ((this.a != ((ImageInfo)paramObject).a) ? false : ((this.f != ((ImageInfo)paramObject).f) ? false : ((this.g != ((ImageInfo)paramObject).g) ? false : (!(this.b != ((ImageInfo)paramObject).b))))));
  }
  
  public int hashCode() {
    char c1;
    char c2;
    boolean bool = this.e;
    char c3 = 'ӏ';
    if (bool) {
      c1 = 'ӏ';
    } else {
      c1 = 'ӕ';
    } 
    int i = this.c;
    int j = this.a;
    if (this.f) {
      c2 = 'ӏ';
    } else {
      c2 = 'ӕ';
    } 
    if (!this.g)
      c3 = 'ӕ'; 
    return (((((c1 + 31) * 31 + i) * 31 + j) * 31 + c2) * 31 + c3) * 31 + this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ImageInfo [cols=");
    stringBuilder.append(this.a);
    stringBuilder.append(", rows=");
    stringBuilder.append(this.b);
    stringBuilder.append(", bitDepth=");
    stringBuilder.append(this.c);
    stringBuilder.append(", channels=");
    stringBuilder.append(this.d);
    stringBuilder.append(", alpha=");
    stringBuilder.append(this.e);
    stringBuilder.append(", greyscale=");
    stringBuilder.append(this.f);
    stringBuilder.append(", indexed=");
    stringBuilder.append(this.g);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */