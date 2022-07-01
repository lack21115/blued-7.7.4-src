package com.qiniu.pili.droid.shortvideo.gl.a;

public class d {
  private c a;
  
  public d(Object paramObject, int paramInt) {
    if (com.qiniu.pili.droid.shortvideo.f.d.b()) {
      this.a = new b(paramObject, paramInt);
      return;
    } 
    this.a = new a(paramObject, paramInt);
  }
  
  public static Object b() {
    return com.qiniu.pili.droid.shortvideo.f.d.b() ? b.b() : a.b();
  }
  
  public void a() {
    this.a.a();
  }
  
  public void a(Object paramObject) {
    this.a.a(paramObject);
  }
  
  public void a(Object paramObject, long paramLong) {
    this.a.a(paramObject, paramLong);
  }
  
  public Object b(Object paramObject) {
    return this.a.b(paramObject);
  }
  
  public void c(Object paramObject) {
    this.a.c(paramObject);
  }
  
  public boolean d(Object paramObject) {
    return this.a.d(paramObject);
  }
  
  protected void finalize() throws Throwable {
    try {
      if (this.a != null)
        this.a.finalize(); 
      return;
    } finally {
      super.finalize();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */