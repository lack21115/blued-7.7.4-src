package a.a.a.a.a.l;

import a.a.a.a.a.a.h.d;
import a.a.a.a.a.a.h.f;
import a.a.a.a.a.a.h.h;
import a.a.a.a.a.e.e;
import android.app.Activity;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.streaming.PLScreenYUVCapturerListener;
import com.qiniu.pili.droid.streaming.ScreenSetting;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class c {
  public MediaProjectionManager a;
  
  public b b;
  
  public ScreenSetting c;
  
  public PLScreenYUVCapturerListener d;
  
  public d e;
  
  public h f;
  
  public Surface g;
  
  public SurfaceTexture h;
  
  public Surface i;
  
  public SurfaceTexture j;
  
  public a.a.a.a.a.b.i.q.a k;
  
  public a.a.a.a.a.b.i.a l;
  
  public final float[] m = new float[16];
  
  public int n;
  
  public boolean o;
  
  public boolean p;
  
  public volatile c q;
  
  public void a() {
    e.g.c("ScreenYUVCapturerCore", "start +");
    if (!j())
      return; 
    if (this.b == null || this.i == null) {
      h();
      return;
    } 
    if (d()) {
      e.g.d("ScreenYUVCapturerCore", "you are screen capturing now, can not start again!");
      return;
    } 
    this.b.a(this.i);
    this.p = true;
    e.g.c("ScreenYUVCapturerCore", "start -");
  }
  
  public void a(Activity paramActivity) {
    e.g.c("ScreenYUVCapturerCore", "requestScreenCapture +");
    if (!j())
      return; 
    if (d()) {
      e.g.d("ScreenYUVCapturerCore", "you are screen capturing now, can not request again!");
      return;
    } 
    MediaProjectionManager mediaProjectionManager = (MediaProjectionManager)paramActivity.getSystemService("media_projection");
    this.a = mediaProjectionManager;
    paramActivity.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 2008);
    e.g.c("ScreenYUVCapturerCore", "requestScreenCapture -");
  }
  
  public void a(ScreenSetting paramScreenSetting, PLScreenYUVCapturerListener paramPLScreenYUVCapturerListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   5: ldc 'ScreenYUVCapturerCore'
    //   7: ldc 'prepare +'
    //   9: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ifnull -> 151
    //   16: aload_2
    //   17: ifnull -> 141
    //   20: getstatic a/a/a/a/a/e/e.d : La/a/a/a/a/e/e;
    //   23: astore_3
    //   24: new java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore #4
    //   33: aload #4
    //   35: ldc 'prepare, screenSetting = '
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #4
    //   43: aload_1
    //   44: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc 'ScreenYUVCapturerCore'
    //   51: aload #4
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield o : Z
    //   63: ifeq -> 79
    //   66: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   69: ldc 'ScreenYUVCapturerCore'
    //   71: ldc 'you have prepared already!'
    //   73: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: aload_0
    //   80: aload_1
    //   81: putfield c : Lcom/qiniu/pili/droid/streaming/ScreenSetting;
    //   84: aload_0
    //   85: aload_2
    //   86: putfield d : Lcom/qiniu/pili/droid/streaming/PLScreenYUVCapturerListener;
    //   89: new android/os/HandlerThread
    //   92: dup
    //   93: ldc 'ScreenYUVCapturerCore'
    //   95: invokespecial <init> : (Ljava/lang/String;)V
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual start : ()V
    //   103: aload_0
    //   104: new a/a/a/a/a/l/c$c
    //   107: dup
    //   108: aload_1
    //   109: invokevirtual getLooper : ()Landroid/os/Looper;
    //   112: aload_0
    //   113: invokespecial <init> : (Landroid/os/Looper;La/a/a/a/a/l/c;)V
    //   116: putfield q : La/a/a/a/a/l/c$c;
    //   119: aload_0
    //   120: getfield q : La/a/a/a/a/l/c$c;
    //   123: iconst_0
    //   124: invokevirtual sendEmptyMessage : (I)Z
    //   127: pop
    //   128: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   131: ldc 'ScreenYUVCapturerCore'
    //   133: ldc 'prepare -'
    //   135: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_0
    //   139: monitorexit
    //   140: return
    //   141: new java/lang/IllegalArgumentException
    //   144: dup
    //   145: ldc 'Error!!! screenYUVCaptureListener cannot be null'
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: athrow
    //   151: new java/lang/IllegalArgumentException
    //   154: dup
    //   155: ldc 'Error!!! screenSetting cannot be null'
    //   157: invokespecial <init> : (Ljava/lang/String;)V
    //   160: athrow
    //   161: astore_1
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	161	finally
    //   20	76	161	finally
    //   79	138	161	finally
    //   141	151	161	finally
    //   151	161	161	finally
  }
  
  public boolean a(int paramInt1, int paramInt2, Intent paramIntent) {
    e.g.c("ScreenYUVCapturerCore", "onActivityResult +");
    if (!j())
      return false; 
    if (paramInt1 != 2008 || paramIntent == null) {
      e.g.e("ScreenYUVCapturerCore", "param error, screen recorder init failed!");
      return false;
    } 
    MediaProjection mediaProjection = this.a.getMediaProjection(paramInt2, paramIntent);
    if (mediaProjection == null) {
      e.g.e("ScreenYUVCapturerCore", "something is wrong, screen recorder init failed!");
      return false;
    } 
    ScreenSetting screenSetting = this.c;
    if (screenSetting == null) {
      e.g.e("ScreenYUVCapturerCore", "please invoke prepare interface first!");
      return false;
    } 
    this.b = new b(screenSetting.getWidth(), this.c.getHeight(), this.c.getDpi(), mediaProjection);
    this.d.onReady();
    e.g.c("ScreenYUVCapturerCore", "onActivityResult -");
    return true;
  }
  
  public void b() {
    e.g.c("ScreenYUVCapturerCore", "stop +");
    b b1 = this.b;
    if (b1 == null) {
      h();
      return;
    } 
    b1.a();
    this.p = false;
    e.g.c("ScreenYUVCapturerCore", "stop -");
  }
  
  public void c() {
    e.g.c("ScreenYUVCapturerCore", "release +");
    if (d())
      b(); 
    this.q.sendEmptyMessage(2);
    this.o = false;
    e.g.c("ScreenYUVCapturerCore", "release -");
  }
  
  public boolean d() {
    return this.p;
  }
  
  public final void e() {
    this.e = new d(null, 1);
    this.h = new SurfaceTexture(1);
    this.g = new Surface(this.h);
    h h1 = new h(this.e, this.g, true);
    this.f = h1;
    h1.d();
    this.n = f.a(36197);
    SurfaceTexture surfaceTexture = new SurfaceTexture(this.n);
    this.j = surfaceTexture;
    surfaceTexture.setDefaultBufferSize(this.c.getWidth(), this.c.getHeight());
    this.i = new Surface(this.j);
    this.j.setOnFrameAvailableListener(new a(this));
    this.k = new a.a.a.a.a.b.i.q.a();
    a.a.a.a.a.b.i.a a1 = new a.a.a.a.a.b.i.a();
    this.l = a1;
    a1.a(0, this.c.getWidth(), this.c.getHeight());
    this.o = true;
    (new Handler(Looper.getMainLooper())).post(new b(this));
  }
  
  public final void f() {
    this.j.updateTexImage();
    this.j.getTransformMatrix(this.m);
    int i = this.l.b(this.n, this.m);
    ByteBuffer byteBuffer = this.k.a(i, this.c.getWidth(), this.c.getHeight());
    this.d.onFrameAvailable(byteBuffer, byteBuffer.capacity(), this.c.getWidth(), this.c.getHeight());
  }
  
  public final void g() {
    this.q.getLooper().quit();
    h h1 = this.f;
    if (h1 != null) {
      h1.g();
      this.f = null;
    } 
    d d1 = this.e;
    if (d1 != null) {
      d1.b();
      this.e = null;
    } 
    SurfaceTexture surfaceTexture2 = this.j;
    if (surfaceTexture2 != null) {
      surfaceTexture2.release();
      this.j = null;
    } 
    Surface surface = this.i;
    if (surface != null) {
      surface.release();
      this.i = null;
    } 
    surface = this.g;
    if (surface != null) {
      surface.release();
      this.g = null;
    } 
    SurfaceTexture surfaceTexture1 = this.h;
    if (surfaceTexture1 != null) {
      surfaceTexture1.release();
      this.h = null;
    } 
  }
  
  public final void h() {
    this.d.onError(2);
    e.g.e("ScreenYUVCapturerCore", "please make sure you have prepared by the callback onPrepared()");
  }
  
  public final void i() {
    this.d.onError(1);
    e.g.e("ScreenYUVCapturerCore", "failed to requestScreenYUVCapture, Android version < LOLLIPOP !");
  }
  
  public final boolean j() {
    if (Build.VERSION.SDK_INT < 21) {
      i();
      return false;
    } 
    if (!this.o) {
      h();
      return false;
    } 
    return true;
  }
  
  public class a implements SurfaceTexture.OnFrameAvailableListener {
    public a(c this$0) {}
    
    public void onFrameAvailable(SurfaceTexture param1SurfaceTexture) {
      if (c.a(this.a))
        c.b(this.a).sendEmptyMessage(1); 
    }
  }
  
  public class b implements Runnable {
    public b(c this$0) {}
    
    public void run() {
      c.c(this.a).onPrepared();
    }
  }
  
  public static class c extends Handler {
    public WeakReference<c> a;
    
    public c(Looper param1Looper, c param1c) {
      super(param1Looper);
      this.a = new WeakReference<c>(param1c);
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder1;
      int i = param1Message.what;
      c c1 = this.a.get();
      e e = e.g;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("GLHandler what:");
      stringBuilder2.append(i);
      stringBuilder2.append(",capturer=");
      stringBuilder2.append(c1);
      e.c("ScreenYUVCapturerCore", stringBuilder2.toString());
      if (c1 == null) {
        e.g.d("ScreenYUVCapturerCore", "GLHandler.handleMessage: recoder is null");
        return;
      } 
      if (i != 0) {
        if (i != 1) {
          if (i == 2) {
            c.f(c1);
            return;
          } 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unhandled msg what=");
          stringBuilder1.append(i);
          throw new RuntimeException(stringBuilder1.toString());
        } 
        c.e((c)stringBuilder1);
        return;
      } 
      c.d((c)stringBuilder1);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\l\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */