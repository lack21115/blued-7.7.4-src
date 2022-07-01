package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Rect;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;

public class j extends k {
  private int c;
  
  private int d;
  
  private PLVideoMixSetting e;
  
  private d f;
  
  private d o;
  
  public int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramBoolean) {
      paramInt2 = this.o.a(this.b, paramInt2, true);
      return this.f.a(paramInt2, paramInt1, false);
    } 
    paramInt1 = this.f.a(this.b, paramInt1, true);
    return this.o.a(paramInt1, paramInt2, false);
  }
  
  public void a(PLVideoMixSetting paramPLVideoMixSetting) {
    this.e = paramPLVideoMixSetting;
  }
  
  public boolean a(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
    return super.a(paramInt1, paramInt2);
  }
  
  public boolean b() {
    Rect rect = this.e.getCameraVideoRect();
    this.f = new d(rect.width(), rect.height());
    float f1 = rect.left / this.c;
    float f2 = (this.d - rect.bottom) / this.d;
    this.f.b(f1, f2);
    this.f.a(true);
    this.f.a(1.0F);
    this.f.b(true);
    this.f.a(this.c, this.d);
    this.f.b();
    rect = this.e.getSampleVideoRect();
    this.o = new d(rect.width(), rect.height());
    f1 = rect.left / this.c;
    f2 = (this.d - rect.bottom) / this.d;
    this.o.b(f1, f2);
    this.o.a(true);
    this.o.a(1.0F);
    this.o.b(true);
    this.o.a(this.c, this.d);
    this.o.b();
    return true;
  }
  
  public void f() {
    this.o.f();
    this.f.f();
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */