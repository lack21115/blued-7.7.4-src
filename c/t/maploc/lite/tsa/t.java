package c.t.maploc.lite.tsa;

public abstract class t extends u {
  private l a = null;
  
  protected j g = null;
  
  public t(j paramj, l paraml) {
    this.g = paramj;
    this.a = paraml;
  }
  
  public final void a(int paramInt1, int paramInt2) {
    l l1 = this.a;
    if (l1 != null)
      l1.a(paramInt1, paramInt2); 
  }
  
  public final void a(p paramp) {
    l l1 = this.a;
    if (l1 != null && paramp != null)
      l1.a(paramp); 
  }
  
  public final j e() {
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */