package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Bitmap;
import android.opengl.Matrix;
import com.qiniu.pili.droid.shortvideo.PLFadeTransition;
import com.qiniu.pili.droid.shortvideo.PLPositionTransition;
import com.qiniu.pili.droid.shortvideo.PLTransition;
import java.util.ArrayList;
import java.util.List;

public class m extends d {
  private List<PLTransition> o = new ArrayList<PLTransition>();
  
  private float p;
  
  private float q;
  
  private float r;
  
  private float s;
  
  public m(Bitmap paramBitmap) {
    super(paramBitmap);
  }
  
  public int a(int paramInt, long paramLong) {
    for (PLTransition pLTransition : this.o) {
      PLPositionTransition pLPositionTransition;
      long l1 = pLTransition.b();
      long l2 = pLTransition.a();
      if (l1 * 1000000L <= paramLong && l2 * 1000000L >= paramLong) {
        if (pLTransition instanceof PLFadeTransition) {
          a(((PLFadeTransition)pLTransition).a(paramLong));
          continue;
        } 
        if (pLTransition instanceof PLPositionTransition) {
          float f1 = (-this.b + 1.0F) / 2.0F;
          float f2 = (this.a / this.i / this.j + 1.0F) / 2.0F;
          float f3 = this.i * 2.0F / this.j;
          pLPositionTransition = (PLPositionTransition)pLTransition;
          this.q = (pLPositionTransition.b(paramLong) - f1) * 2.0F;
          this.p = (pLPositionTransition.a(paramLong) - f2) * f3;
        } 
        continue;
      } 
      if (pLPositionTransition instanceof PLPositionTransition) {
        this.s = 0.0F;
        this.r = 0.0F;
        this.q = 0.0F;
        this.p = 0.0F;
      } 
    } 
    return a(paramInt);
  }
  
  public void a(PLTransition paramPLTransition) {
    this.o.add(paramPLTransition);
  }
  
  protected void d() {
    super.d();
    Matrix.translateM(this.m, 0, -this.s, this.r, 0.0F);
    Matrix.translateM(this.m, 0, this.p, -this.q, 0.0F);
    this.r = this.q;
    this.s = this.p;
  }
  
  public void f() {
    super.f();
    this.o.clear();
    this.o = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */