package com.qiniu.pili.droid.beauty;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.h;
import com.qiniu.pili.droid.shortvideo.f.j;

public final class a implements PLVideoFilterListener {
  public static final boolean a = h.a().b();
  
  private Context b;
  
  private b c;
  
  private PLFaceBeautySetting d;
  
  private int e;
  
  public a(Context paramContext, PLFaceBeautySetting paramPLFaceBeautySetting) {
    if (h.a(true)) {
      e.g.c("FaceBeautyProcessor", "using the built-in fb");
      this.c = new b();
    } 
    this.b = paramContext;
    this.d = paramPLFaceBeautySetting;
  }
  
  private void c() {
    if (!a)
      return; 
    b b1 = this.c;
    if (b1 != null) {
      b1.a();
      this.c.a(this.b.getApplicationContext(), j.d(this.b), 0);
      this.c.a(j.e(this.b) ^ true);
      a(this.d);
    } 
  }
  
  public void a(PLFaceBeautySetting paramPLFaceBeautySetting) {
    if (a) {
      if (this.c == null)
        return; 
      if (paramPLFaceBeautySetting == null) {
        e.g.d("FaceBeautyProcessor", "Invalid FB setting");
        return;
      } 
      float f2 = paramPLFaceBeautySetting.getWhiten();
      float f1 = f2;
      if (f2 > 1.0F)
        f1 = 1.0F; 
      this.c.b(f1 / 2.0F);
      this.c.c(paramPLFaceBeautySetting.getRedden());
      this.c.a(paramPLFaceBeautySetting.getBeautyLevel());
      this.d = paramPLFaceBeautySetting;
    } 
  }
  
  public boolean a() {
    boolean bool = a;
    boolean bool1 = false;
    if (!bool)
      return false; 
    PLFaceBeautySetting pLFaceBeautySetting = this.d;
    bool = bool1;
    if (pLFaceBeautySetting != null) {
      bool = bool1;
      if (pLFaceBeautySetting.isEnabled())
        bool = true; 
    } 
    return bool;
  }
  
  public void b() {
    if (!a)
      return; 
    b b1 = this.c;
    if (b1 != null)
      b1.a(); 
  }
  
  public int onDrawFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong, float[] paramArrayOffloat) {
    if (!a)
      return paramInt1; 
    int i = paramInt1;
    if (this.c != null) {
      i = paramInt1;
      if (paramInt2 != 0) {
        i = paramInt1;
        if (paramInt3 != 0) {
          if (this.e == 0)
            this.e = d.a(null, paramInt2, paramInt3, 6408); 
          this.c.a(paramInt1, paramInt2, paramInt3, this.e);
          i = this.e;
        } 
      } 
    } 
    return i;
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2) {
    if (!a)
      return; 
    b b1 = this.c;
    if (b1 != null)
      b1.b(this.b.getApplicationContext(), paramInt1, paramInt2); 
  }
  
  public void onSurfaceCreated() {
    if (!a)
      return; 
    this.e = 0;
    c();
  }
  
  public void onSurfaceDestroy() {
    if (!a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\beauty\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */