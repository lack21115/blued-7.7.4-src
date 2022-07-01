package a.a.a.a.a.i;

import a.a.a.a.a.b.b;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.e;
import a.a.a.a.a.i.b.c.a;
import android.content.Context;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.nio.ByteBuffer;

public final class a implements SurfaceTextureCallback {
  public static final boolean a = SharedLibraryNameHelper.getInstance().d();
  
  public a b;
  
  public a c;
  
  public Context d;
  
  public CameraStreamingSetting e;
  
  public CameraStreamingSetting.VIDEO_FILTER_TYPE f = CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_NONE;
  
  public boolean g;
  
  public boolean h;
  
  public boolean i = false;
  
  public ByteBuffer j;
  
  public byte[] k;
  
  public int l;
  
  public final Object m = new Object();
  
  public boolean n = false;
  
  public a(Context paramContext, CameraStreamingSetting paramCameraStreamingSetting, boolean paramBoolean, a parama) {
    if (SharedLibraryNameHelper.d(true) && paramCameraStreamingSetting.e()) {
      e.h.c("ProcessingManager", "using the built-in fb");
      this.c = new a();
    } 
    this.d = paramContext.getApplicationContext();
    this.e = paramCameraStreamingSetting;
    this.g = paramBoolean;
    this.h = e.a().c();
    this.b = parama;
    this.f = paramCameraStreamingSetting.getVideoFilterType();
  }
  
  public void a() {
    this.i = true;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean) {
    synchronized (this.m) {
      if (this.c != null) {
        if (this.l == 0)
          this.l = paramInt1 * paramInt2 * 3 / 2; 
        if (this.j == null)
          this.j = ByteBuffer.allocateDirect(this.l); 
        this.j.clear();
        boolean bool = this.c.a(this.j, this.l);
        if (this.b != null && bool) {
          if (this.k == null)
            this.k = new byte[this.l]; 
          this.j.get(this.k, 0, this.l);
          this.b.a(this.k, paramInt1, paramInt2, PLFourCC.FOURCC_NV21, paramLong, paramBoolean);
        } 
      } 
      return;
    } 
  }
  
  public void a(CameraStreamingSetting.FaceBeautySetting paramFaceBeautySetting) {
    if (this.c == null)
      return; 
    if (paramFaceBeautySetting == null) {
      e.h.d("ProcessingManager", "Invalid FB setting");
      return;
    } 
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mFilterType:");
    stringBuilder.append(this.f);
    e.c("ProcessingManager", stringBuilder.toString());
    if (this.f == CameraStreamingSetting.VIDEO_FILTER_TYPE.VIDEO_FILTER_BEAUTY) {
      this.c.a(paramFaceBeautySetting.beautyLevel);
      float f2 = paramFaceBeautySetting.whiten;
      float f1 = f2;
      if (f2 > 1.0F)
        f1 = 1.0F; 
      this.c.b(f1 / 2.0F);
      this.c.c(paramFaceBeautySetting.redden);
      return;
    } 
    this.c.a(0.0F);
  }
  
  public void a(CameraStreamingSetting.VIDEO_FILTER_TYPE paramVIDEO_FILTER_TYPE) {
    if (this.c != null) {
      this.f = paramVIDEO_FILTER_TYPE;
      a(this.e.getFaceBeautySetting());
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void b() {
    this.i = false;
    f();
  }
  
  public void c() {
    a a1 = this.c;
    if (a1 != null) {
      a1.a();
      f();
    } 
  }
  
  public void d() {
    this.b = null;
  }
  
  public void e() {
    a a1 = this.c;
    if (a1 != null)
      a1.b(h.c(this.d) ^ true); 
  }
  
  public final void f() {
    synchronized (this.m) {
      this.l = 0;
      this.k = null;
      this.j = null;
      return;
    } 
  }
  
  public final void g() {
    a a1 = this.c;
    if (a1 != null) {
      a1.a();
      this.c.a(this.d.getApplicationContext(), h.f(this.d), this.g ^ true);
      this.c.b(h.c(this.d) ^ true);
      a(this.e.getFaceBeautySetting());
    } 
  }
  
  public int onDrawFrame(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat) {
    int i = paramInt1;
    if (this.c != null) {
      i = paramInt1;
      if (paramInt2 != 0) {
        i = paramInt1;
        if (paramInt3 != 0) {
          boolean bool;
          long l = System.nanoTime();
          paramInt1 = this.c.a(paramInt1, paramInt2, paramInt3);
          if (this.i && !this.g && this.n) {
            bool = true;
          } else {
            bool = false;
          } 
          i = paramInt1;
          if (this.h) {
            a(paramInt2, paramInt3, l, bool);
            i = paramInt1;
          } 
        } 
      } 
    } 
    return i;
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2) {
    a a1 = this.c;
    if (a1 != null) {
      a1.b(this.d.getApplicationContext(), paramInt1, paramInt2);
      this.c.a(b.a().c());
      boolean bool = b.a().c();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool)
        if ((b.a().b()).orientation != 90) {
          bool1 = bool2;
        } else {
          bool1 = true;
        }  
      this.c.c(bool1);
    } 
  }
  
  public void onSurfaceCreated() {
    g();
  }
  
  public void onSurfaceDestroyed() {
    a a1 = this.c;
    if (a1 != null)
      a1.a(); 
  }
  
  public static interface a {
    void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3, long param1Long, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */