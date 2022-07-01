package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.a;
import com.qiniu.pili.droid.shortvideo.gl.c.e;

public class d {
  private View a;
  
  private SurfaceTexture b;
  
  private Surface c;
  
  private a d;
  
  private e e;
  
  private int f;
  
  private float[] g = new float[16];
  
  private int h;
  
  private void g() {
    int i = this.h;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.h = 0;
    } 
  }
  
  public void a() {
    SurfaceTexture surfaceTexture = this.b;
    if (surfaceTexture != null)
      surfaceTexture.updateTexImage(); 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {
    c();
    this.a = paramView;
    this.d = new a();
    this.d.a(paramView.getWidth(), paramView.getHeight());
    this.d.b();
    this.e = new e();
    this.e.a(paramInt1, paramInt2);
    this.e.a(paramView.getWidth(), paramView.getHeight(), PLDisplayMode.FIT);
    this.h = com.qiniu.pili.droid.shortvideo.f.d.a(null, paramInt1, paramInt2, 6408);
    this.f = com.qiniu.pili.droid.shortvideo.f.d.c();
    this.b = new SurfaceTexture(this.f);
    this.b.setDefaultBufferSize(paramView.getWidth(), paramView.getHeight());
    this.c = new Surface(this.b);
  }
  
  public void a(float[] paramArrayOffloat) {
    this.b.getTransformMatrix(paramArrayOffloat);
  }
  
  public void b() {
    Canvas canvas = f();
    if (canvas != null) {
      canvas.drawColor(0, PorterDuff.Mode.CLEAR);
      this.a.draw(canvas);
      this.c.unlockCanvasAndPost(canvas);
    } 
  }
  
  public void c() {
    Surface surface = this.c;
    if (surface != null)
      surface.release(); 
    SurfaceTexture surfaceTexture = this.b;
    if (surfaceTexture != null)
      surfaceTexture.release(); 
    a a1 = this.d;
    if (a1 != null)
      a1.f(); 
    e e1 = this.e;
    if (e1 != null)
      e1.f(); 
    this.c = null;
    this.b = null;
    this.d = null;
    this.e = null;
    g();
  }
  
  public long d() {
    SurfaceTexture surfaceTexture = this.b;
    return (surfaceTexture == null) ? 0L : surfaceTexture.getTimestamp();
  }
  
  public int e() {
    int i = this.f;
    a(this.g);
    float f = this.a.getAlpha();
    a a1 = this.d;
    if (a1 != null) {
      i = a1.b(this.f, this.g);
      i = this.e.a(i, f, null, this.h, true);
    } 
    return i;
  }
  
  public Canvas f() {
    Surface surface = this.c;
    if (surface != null)
      try {
        return surface.lockCanvas(null);
      } catch (Exception exception) {
        e e1 = e.j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("error while rendering view to gl: ");
        stringBuilder.append(exception);
        e1.e("ViewRenderer", stringBuilder.toString());
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */