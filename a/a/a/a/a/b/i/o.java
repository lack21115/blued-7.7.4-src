package a.a.a.a.a.b.i;

import a.a.a.a.a.a.h.f;
import android.opengl.GLES20;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class o {
  public int a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public List<f> f = new ArrayList<f>();
  
  public int a() {
    return this.a;
  }
  
  public int a(int paramInt1, int paramInt2) {
    if (this.f.size() <= paramInt1)
      return 0; 
    GLES20.glBindFramebuffer(36160, this.c);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.d, 0);
    b(paramInt1, paramInt2);
    GLES20.glBindFramebuffer(36160, 0);
    return this.d;
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, PreviewAppearance.ScaleType paramScaleType) {
    float f = this.a;
    int i = (int)(f * paramFloat3);
    paramFloat3 = this.b;
    int j = (int)(paramFloat3 * paramFloat4);
    int k = (int)(f * paramFloat1);
    int m = (int)(paramFloat3 * (1.0F - paramFloat2));
    f f1 = new f();
    f1.a(paramInt1, paramInt2, k, m - j, i, j, paramScaleType);
    f1.a(this.e);
    this.f.add(f1);
    return this.f.size() - 1;
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.a = paramInt1;
    this.b = paramInt2;
    f();
    return paramBoolean ? c(paramInt1, paramInt2) : true;
  }
  
  public int b() {
    return this.b;
  }
  
  public void b(int paramInt1, int paramInt2) {
    if (this.f.size() <= paramInt1)
      return; 
    GLES20.glClear(16384);
    ((f)this.f.get(paramInt1)).b(paramInt2);
  }
  
  public int c() {
    return this.f.size();
  }
  
  public final boolean c(int paramInt1, int paramInt2) {
    this.d = f.a(null, paramInt1, paramInt2, 6408);
    return true;
  }
  
  public void d() {
    this.f.clear();
  }
  
  public void e() {
    int i = this.c;
    if (i != 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { i }, 0);
      this.c = 0;
    } 
    i = this.d;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.d = 0;
    } 
    Iterator<f> iterator = this.f.iterator();
    while (iterator.hasNext()) {
      ((f)iterator.next()).g();
      iterator.remove();
    } 
  }
  
  public final void f() {
    this.c = f.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */