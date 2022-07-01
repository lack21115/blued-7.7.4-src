package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.a.a.d;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import com.qiniu.pili.droid.shortvideo.encode.e;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.d;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.b.d;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.texread.d;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends e {
  private final Object A = new Object();
  
  private volatile boolean B = false;
  
  private View z;
  
  public t() {
    e.d.c("ViewRecorderCore", "init");
  }
  
  private void v() {
    synchronized (this.A) {
      this.B = true;
      this.A.notify();
      return;
    } 
  }
  
  private void w() {
    synchronized (this.A) {
      while (true) {
        boolean bool = this.B;
        if (!bool) {
          try {
            this.A.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          continue;
        } 
        this.B = false;
        return;
      } 
    } 
  }
  
  protected String a() {
    return "ViewRecorderCore";
  }
  
  public void a(View paramView, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLRecordSetting paramPLRecordSetting) {
    e.d.c("ViewRecorderCore", "prepare +");
    Context context = paramView.getContext().getApplicationContext();
    l.a(context);
    a(context, paramPLMicrophoneSetting, paramPLAudioEncodeSetting, paramPLRecordSetting);
    this.z = paramView;
    this.c = paramPLVideoEncodeSetting;
    if (this.c.isHWCodecEnabled()) {
      this.b = (com.qiniu.pili.droid.shortvideo.encode.a)new e(paramPLVideoEncodeSetting);
    } else {
      this.b = (com.qiniu.pili.droid.shortvideo.encode.a)new SWVideoEncoder(paramPLVideoEncodeSetting);
    } 
    this.b.a(this.f);
    e.d.c("ViewRecorderCore", "prepare -");
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.x : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
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
  
  protected void b() {
    (new Thread(new a())).start();
  }
  
  public JSONObject h() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("operation_record_view", 1);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public long u() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : Lcom/qiniu/pili/droid/shortvideo/core/i;
    //   6: invokevirtual d : ()J
    //   9: lstore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: lload_1
    //   13: lreturn
    //   14: astore_3
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_3
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  class a implements Runnable {
    private a(t this$0) {}
    
    public void run() {
      SurfaceTexture surfaceTexture1;
      SurfaceTexture surfaceTexture2;
      d d1 = new d();
      d1.a(this.a.c.getVideoEncodingFps());
      int i = this.a.c.getVideoEncodingWidth();
      int j = this.a.c.getVideoEncodingHeight();
      boolean bool = this.a.c.isHWCodecEnabled();
      d d = null;
      if (!bool) {
        surfaceTexture1 = new SurfaceTexture(0);
        Surface surface = new Surface(surfaceTexture1);
        this.a.a = surface;
      } else {
        surfaceTexture1 = null;
        surfaceTexture2 = surfaceTexture1;
      } 
      d d2 = new d(null, 1);
      f f = new f(d2, this.a.a, false);
      f.b();
      d d3 = new d();
      d3.a(t.a(this.a), i, j);
      g g = d.a(i, j);
      while (this.a.d) {
        t.a(this.a).post(new Runnable(this, d3) {
              public void run() {
                this.a.b();
                t.b(this.b.a);
              }
            });
        t.c(this.a);
        d3.a();
        long l = d3.d();
        i = d3.e();
        if (!d1.a()) {
          if (this.a.c.isHWCodecEnabled()) {
            GLES20.glClear(16384);
            g.b(i);
            if (this.a.b.a(l)) {
              f.a(l - this.a.b.b());
              f.c();
            } 
            continue;
          } 
          d d4 = d;
          if (d == null)
            d4 = new d(this.a.c.getVideoEncodingWidth(), this.a.c.getVideoEncodingHeight()); 
          ByteBuffer byteBuffer = d4.a(i);
          this.a.b.a(byteBuffer, byteBuffer.capacity(), l);
          d = d4;
        } 
      } 
      f.d();
      g.f();
      d2.a();
      d3.c();
      if (!this.a.c.isHWCodecEnabled()) {
        surfaceTexture1.release();
        surfaceTexture2.release();
        if (d != null)
          d.a(); 
      } 
      t.a(this.a, false);
    }
  }
  
  class null implements Runnable {
    null(t this$0, d param1d) {}
    
    public void run() {
      this.a.b();
      t.b(this.b.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */