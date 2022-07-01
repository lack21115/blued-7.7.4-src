package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLImageRotateSetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.c.d;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends e {
  private volatile boolean A = false;
  
  private float B;
  
  private PLImageRotateSetting C;
  
  private final Object z = new Object();
  
  public f() {
    e.d.c("ImageRotateRecorderCore", "init");
  }
  
  private d a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    float f1 = paramBitmap.getWidth() / paramInt1;
    float f2 = paramBitmap.getHeight() / paramInt2;
    d d = new d(paramBitmap);
    d.a(1.0F);
    d.b(0.5F - f1 / 2.0F, 0.5F - f2 / 2.0F);
    d.a(paramInt1, paramInt2);
    d.b();
    return d;
  }
  
  private void u() {
    synchronized (this.z) {
      this.A = true;
      this.z.notify();
      return;
    } 
  }
  
  private void v() {
    synchronized (this.z) {
      while (true) {
        boolean bool = this.A;
        if (!bool) {
          try {
            this.z.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          continue;
        } 
        this.A = false;
        return;
      } 
    } 
  }
  
  private float w() {
    return 360.0F / (float)this.C.getCircleTimeMs() / 1000.0F * this.c.getVideoEncodingFps();
  }
  
  public String a() {
    return "ImageRotateRecorderCore";
  }
  
  public void a(Context paramContext, PLImageRotateSetting paramPLImageRotateSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    e.d.c("ImageRotateRecorderCore", "prepare +");
    l.a(paramContext);
    a(paramContext, paramPLMicrophoneSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
    this.m = paramContext;
    this.c = paramPLVideoEncodeSetting;
    this.C = paramPLImageRotateSetting;
    this.b = (com.qiniu.pili.droid.shortvideo.encode.a)new e(paramPLVideoEncodeSetting);
    this.b.a(this.f);
    e.d.c("ImageRotateRecorderCore", "prepare -");
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.r : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   6: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial a : (Ljava/lang/String;)Z
    //   23: istore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_2
    //   27: ireturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	28	finally
    //   18	24	28	finally
  }
  
  public void b() {
    (new Thread(new a())).start();
  }
  
  public boolean c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/qiniu/pili/droid/shortvideo/f/e.d : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   5: ldc 'ImageRotateRecorderCore'
    //   7: ldc 'endSection'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokespecial c : ()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq -> 34
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield d : Z
    //   26: aload_0
    //   27: getfield b : Lcom/qiniu/pili/droid/shortvideo/encode/a;
    //   30: invokevirtual c : ()Z
    //   33: pop
    //   34: aload_0
    //   35: invokespecial u : ()V
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_1
    //   41: ireturn
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	42	finally
    //   21	34	42	finally
    //   34	38	42	finally
  }
  
  public JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_record_image_rotate", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void onAudioFrameAvailable(byte[] paramArrayOfbyte, long paramLong) {
    super.onAudioFrameAvailable(paramArrayOfbyte, paramLong);
    u();
  }
  
  class a implements Runnable {
    private a(f this$0) {}
    
    public void run() {
      int i = this.a.c.getVideoEncodingWidth();
      int j = this.a.c.getVideoEncodingHeight();
      long l2 = 1000000L / this.a.c.getVideoEncodingFps();
      d d = new d(null, 1);
      com.qiniu.pili.droid.shortvideo.gl.a.f f1 = new com.qiniu.pili.droid.shortvideo.gl.a.f(d, this.a.a, false);
      f1.b();
      Bitmap bitmap2 = d.a(this.a.m, f.a(this.a).getBackgroundImageUri(), i, j);
      Bitmap bitmap1 = d.a(this.a.m, f.a(this.a).getRotateImageUri(), f.a(this.a).getRotateImageWidth(), f.a(this.a).getRotateImageHeight());
      int k = d.a(bitmap2);
      g g = d.a(i, j);
      d d1 = f.a(this.a, bitmap1, i, j);
      d1.c(f.b(this.a));
      long l1 = 0L;
      while (this.a.d()) {
        double d2 = l1;
        if (d2 < this.a.x * 1000000.0D / this.a.t) {
          f f2 = this.a;
          f.a(f2, f.b(f2) + f.c(this.a));
          d1.c(f.c(this.a));
          GLES20.glClear(16384);
          g.b(d1.a(k));
          f1.a(l1);
          f1.c();
          this.a.b.a(l1);
          l1 = (long)(d2 + (1000L * l2) / this.a.t);
          continue;
        } 
        f.d(this.a);
      } 
      g.f();
      d1.f();
      f1.d();
      d.a();
      bitmap1.recycle();
      bitmap2.recycle();
      f.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */