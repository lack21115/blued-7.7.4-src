package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.util.bi;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends TextureView implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener, e, bi.a {
  private String A;
  
  private AtomicBoolean B = new AtomicBoolean(false);
  
  private boolean C = false;
  
  private int D = 0;
  
  private volatile int a;
  
  private volatile int b;
  
  private SurfaceTexture c = null;
  
  private volatile MediaPlayer d = null;
  
  private AudioManager e;
  
  private Surface f = null;
  
  private int g;
  
  private int h;
  
  private AtomicBoolean i = new AtomicBoolean(false);
  
  private AtomicBoolean j = new AtomicBoolean(false);
  
  private AtomicBoolean k = new AtomicBoolean(false);
  
  private AtomicBoolean l = new AtomicBoolean(false);
  
  private AtomicBoolean m = new AtomicBoolean(false);
  
  private AtomicBoolean n = new AtomicBoolean(false);
  
  private volatile int o;
  
  private AtomicBoolean p = new AtomicBoolean(false);
  
  private b q;
  
  private a r;
  
  private d s = d.b;
  
  private c t = c.a;
  
  private long u = 0L;
  
  private int v = 0;
  
  private int w = 0;
  
  private Handler x;
  
  private Handler y;
  
  private HandlerThread z = new HandlerThread(f.class.getSimpleName());
  
  public f(Context paramContext) {
    super(paramContext);
    this.z.start();
    this.x = (Handler)new bi(this, this.z.getLooper());
    this.y = new Handler();
    this.x.sendEmptyMessage(6);
    setSurfaceTextureListener(this);
  }
  
  private void A() {
    b.a().b(this);
    if (this.d != null) {
      this.d.reset();
      this.d.release();
      this.d = null;
      this.s = d.b;
      this.c = null;
    } 
    this.z.quit();
  }
  
  private void B() {
    if (this.d != null) {
      this.d.reset();
      this.d.release();
      this.d = null;
      this.s = d.b;
      this.B.set(true);
      this.i.set(false);
    } 
  }
  
  private void C() {
    float f1;
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append(" reInit");
    GDTLogger.d(stringBuilder.toString());
    o();
    int i = this.D;
    if (i > 0)
      a(i); 
    if (this.m.get()) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    } 
    this.d.setVolume(f1, f1);
    if (this.A != null) {
      try {
        this.d.setDataSource(this.A);
        this.i.set(true);
        u();
        return;
      } catch (Exception exception) {
        str = exception.getMessage();
      } 
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append(hashCode());
      stringBuilder.append(" reInit failed, path is null");
      str = stringBuilder.toString();
    } 
    GDTLogger.e(str);
  }
  
  private void D() {
    if (!this.m.get()) {
      if (this.s != d.d)
        return; 
      AudioManager audioManager = this.e;
      if (audioManager != null)
        audioManager.requestAudioFocus(null, 3, 2); 
    } 
  }
  
  private void E() {
    AudioManager audioManager = this.e;
    if (audioManager != null)
      audioManager.abandonAudioFocus(null); 
  }
  
  private void b(int paramInt) {
    try {
      if (t()) {
        this.d.seekTo(paramInt);
        this.n.set(false);
        this.o = 0;
        return;
      } 
    } catch (Exception exception) {
      GDTLogger.w("MediaPlayer can not seek");
      exception.printStackTrace();
    } 
    this.n.set(true);
    this.o = paramInt;
  }
  
  private void b(String paramString) {
    p();
    try {
      this.d.setDataSource(paramString);
      this.i.set(true);
      this.A = paramString;
      u();
      return;
    } catch (Exception exception) {
      GDTLogger.d(exception.getMessage());
      this.s = d.a;
      u.a(30112, 0, null);
      this.y.post(new Runnable(this, exception) {
            public void run() {
              if (f.b(this.b) != null)
                f.b(this.b).a(5003, this.a); 
            }
          });
      return;
    } 
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2) {
    MediaPlayer mediaPlayer;
    if (this.s == d.b) {
      String str = "stop() was called but video is not initialized.";
    } else if (this.s == d.c) {
      String str = "stop() was called but video is just prepared, not playing.";
    } else if (this.s == d.e) {
      String str = "stop() was called but video already stopped.";
    } else if (this.s == d.g) {
      String str = "stop() was called but video already ended.";
    } else if (this.s == d.a) {
      String str = "stop() was called but video already encountered error.";
    } else if (this.d == null) {
      String str = "stop() was called but MediaPlayer is null.";
    } else {
      this.s = d.e;
      E();
      this.y.post(new Runnable(this) {
            public void run() {
              if (f.b(this.a) != null)
                f.b(this.a).d(); 
            }
          });
      if (paramBoolean1 || this.d.isPlaying()) {
        int i;
        mediaPlayer = this.d;
        if (paramBoolean2) {
          i = 0;
        } else {
          i = e();
        } 
        mediaPlayer.seekTo(i);
        this.d.pause();
        r();
      } 
      if (paramBoolean1)
        this.C = false; 
      return;
    } 
    GDTLogger.d((String)mediaPlayer);
  }
  
  private void o() {
    p();
    this.e = (AudioManager)getContext().getSystemService("audio");
    this.d.setOnPreparedListener(this);
    this.d.setOnCompletionListener(this);
    this.d.setOnErrorListener(this);
    this.d.setOnSeekCompleteListener(this);
    this.d.setOnVideoSizeChangedListener(this);
  }
  
  private void p() {
    this.k.set(false);
    if (this.d == null) {
      this.d = new MediaPlayer();
    } else {
      this.d.reset();
    } 
    this.l.set(false);
    this.n.set(false);
    this.o = 0;
    this.s = d.b;
  }
  
  private void q() {
    b b1 = this.q;
    if (b1 != null)
      b1.a(this); 
  }
  
  private void r() {
    this.y.post(new Runnable(this) {
          public void run() {
            if (f.a(this.a) != null)
              f.a(this.a).d(); 
          }
        });
  }
  
  private void s() {
    this.y.post(new Runnable(this) {
          public void run() {
            if (f.a(this.a) != null)
              f.a(this.a).c(); 
          }
        });
  }
  
  private boolean t() {
    return (this.d != null && this.s != d.a && this.s != d.b);
  }
  
  private void u() {
    try {
      if (this.d != null) {
        this.d.prepareAsync();
        return;
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      String str = illegalArgumentException.getMessage();
      GDTLogger.d(str);
    } catch (SecurityException securityException) {
      String str = securityException.getMessage();
    } catch (IllegalStateException illegalStateException) {
      String str = illegalStateException.getMessage();
    } 
  }
  
  private void v() {
    Handler handler;
    if (!this.i.get()) {
      String str = "play() was called but video data source was not set.";
    } else {
      this.l.set(true);
      if (!this.k.get()) {
        String str = "play() was called but video is not prepared yet, waiting.";
      } else if (!this.j.get()) {
        String str = "play() was called but SurfaceTexture is not available yet, waiting.";
      } else if (this.s == d.d) {
        String str = "play() was called but video is already playing.";
      } else if (this.d == null) {
        String str = "play() was called but MediaPlayer is null.";
      } else {
        Runnable runnable;
        if (this.C || this.s == d.f) {
          GDTLogger.d("play() was called but video is paused, resuming.");
          this.s = d.d;
          this.C = false;
          this.d.start();
          D();
          handler = this.y;
          runnable = new Runnable(this) {
              public void run() {
                if (f.b(this.a) != null)
                  f.b(this.a).f(); 
              }
            };
        } else {
          if (this.s == d.g || this.s == d.e) {
            GDTLogger.d("play() was called but video already ended/stopped, starting over.");
            b(this.A);
            this.l.set(true);
            return;
          } 
          this.s = d.d;
          D();
          this.d.start();
          handler = this.y;
          runnable = new Runnable(this) {
              public void run() {
                if (f.b(this.a) != null) {
                  float f1;
                  f.b(this.a).b();
                  if (f.c(this.a).get()) {
                    f1 = 0.0F;
                  } else {
                    f1 = 1.0F;
                  } 
                  if (f.d(this.a) != null && f.e(this.a) != f.d.a)
                    try {
                      f.d(this.a).setVolume(f1, f1);
                      return;
                    } catch (Exception exception) {
                      exception.printStackTrace();
                    }  
                } 
              }
            };
        } 
        handler.post(runnable);
        return;
      } 
    } 
    GDTLogger.d((String)handler);
  }
  
  private void w() {
    String str;
    if (this.s == d.b) {
      str = "pause() was called but video is not initialized.";
    } else if (this.s == d.c) {
      str = "pause() was called but video is just prepared, not playing.";
    } else if (this.s == d.f) {
      str = "pause() was called but video already paused.";
    } else if (this.s == d.e) {
      str = "pause() was called but video already stopped.";
    } else if (this.s == d.g) {
      str = "pause() was called but video already ended.";
    } else if (this.d == null) {
      str = "pause() was called but MediaPlayer is null.";
    } else {
      this.s = d.f;
      if (this.d.isPlaying()) {
        this.C = true;
        this.d.pause();
      } 
      E();
      this.y.post(new Runnable(this) {
            public void run() {
              if (f.b(this.a) != null)
                f.b(this.a).e(); 
            }
          });
      return;
    } 
    GDTLogger.d(str);
  }
  
  private void x() {
    try {
      if (this.d != null && this.s != d.a && !this.m.get()) {
        GDTLogger.d("Set volume off.");
        this.d.setVolume(0.0F, 0.0F);
        this.m.set(true);
        this.y.post(new Runnable(this) {
              public void run() {
                if (f.a(this.a) != null)
                  f.a(this.a).e(); 
              }
            });
        E();
        return;
      } 
    } catch (Exception exception) {
      GDTLogger.w("MediaPlayer set volume off error");
      exception.printStackTrace();
    } 
  }
  
  private void y() {
    try {
      if (this.d != null && this.s != d.a && this.m.get()) {
        GDTLogger.d("Set volume on.");
        this.d.setVolume(1.0F, 1.0F);
        this.m.set(false);
        this.y.post(new Runnable(this) {
              public void run() {
                if (f.a(this.a) != null)
                  f.a(this.a).e(); 
              }
            });
        D();
        return;
      } 
    } catch (Exception exception) {
      GDTLogger.w("MediaPlayer set volume on error");
      exception.printStackTrace();
    } 
  }
  
  private void z() {
    String str;
    if (this.c == null) {
      str = "SurfaceTexture is not available, can't open video.";
    } else if (this.d == null) {
      str = "MediaPlayer is null, can't open video.";
    } else {
      if (this.f == null)
        this.f = new Surface(this.c); 
      this.d.setSurface(this.f);
      this.j.set(true);
      if (this.i.get() && this.l.get() && this.k.get()) {
        GDTLogger.d("SurfaceTexture is available and play() was called.");
        b();
      } 
      return;
    } 
    GDTLogger.d(str);
  }
  
  public void a() {
    this.x.sendEmptyMessage(2);
  }
  
  public void a(int paramInt) {
    Message message = Message.obtain();
    message.what = 10;
    message.arg1 = paramInt;
    this.x.sendMessage(message);
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void a(Message paramMessage) {
    int i;
    boolean bool1;
    boolean bool2;
    switch (paramMessage.what) {
      default:
        return;
      case 12:
        A();
        return;
      case 11:
        z();
        return;
      case 10:
        b(paramMessage.arg1);
        return;
      case 9:
        y();
        return;
      case 8:
        x();
        return;
      case 7:
        b(String.valueOf(paramMessage.obj));
        return;
      case 6:
        o();
        return;
      case 5:
        C();
        return;
      case 4:
        B();
        return;
      case 3:
        i = paramMessage.arg1;
        bool2 = false;
        if (i == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (paramMessage.arg2 == 1)
          bool2 = true; 
        b(bool1, bool2);
        return;
      case 2:
        w();
        return;
      case 1:
        break;
    } 
    v();
  }
  
  public void a(b paramb) {
    this.q = paramb;
    r();
    q();
  }
  
  public void a(a parama) {
    this.r = parama;
  }
  
  public void a(c paramc) {
    this.t = paramc;
  }
  
  public void a(String paramString) {
    Message message = Message.obtain();
    message.what = 7;
    message.obj = paramString;
    this.x.sendMessage(message);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b() {
    this.x.sendEmptyMessage(1);
  }
  
  public void b(boolean paramBoolean) {
    this.p.set(paramBoolean);
  }
  
  public boolean c() {
    try {
      if (t() && this.d != null) {
        boolean bool = this.d.isPlaying();
        if (bool)
          return true; 
      } 
    } catch (IllegalStateException illegalStateException) {
      illegalStateException.printStackTrace();
    } 
    return false;
  }
  
  public boolean d() {
    return this.m.get();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    n();
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public int e() {
    try {
      if (t() && this.k.get())
        return this.d.getDuration(); 
    } catch (Exception exception) {
      GDTLogger.w("MediaPlayer can not get Duration");
      exception.printStackTrace();
    } 
    return 0;
  }
  
  public int f() {
    try {
      if (t())
        return (this.s == d.g) ? e() : this.d.getCurrentPosition(); 
    } catch (Exception exception) {
      GDTLogger.w("MediaPlayer get current position error");
      exception.printStackTrace();
    } 
    return 0;
  }
  
  public d g() {
    return this.s;
  }
  
  public void h() {
    this.x.sendEmptyMessage(8);
  }
  
  public void i() {
    this.x.sendEmptyMessage(9);
  }
  
  public void j() {
    this.x.sendEmptyMessage(3);
  }
  
  public String k() {
    return this.A;
  }
  
  public void l() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append(" free");
    GDTLogger.d(stringBuilder.toString());
    this.x.sendEmptyMessage(12);
  }
  
  public void m() {
    this.x.sendEmptyMessage(4);
  }
  
  public void n() {
    if (System.currentTimeMillis() - this.u < 100L)
      return; 
    this.u = System.currentTimeMillis();
    if (this.q != null && !this.p.get()) {
      if (this.q.isShown()) {
        r();
        return;
      } 
      s();
    } 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append(" attached");
    GDTLogger.d(stringBuilder.toString());
    b.a().b(this);
    if (this.B.get()) {
      this.x.sendEmptyMessage(5);
      this.B.set(false);
    } 
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    if (this.s != d.g) {
      this.s = d.g;
      GDTLogger.d("Video is ended.");
      E();
      this.y.post(new Runnable(this) {
            public void run() {
              if (f.b(this.a) != null)
                f.b(this.a).c(); 
            }
          });
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(hashCode());
    stringBuilder.append(" detach");
    GDTLogger.d(stringBuilder.toString());
    this.D = f();
    if (this.d != null)
      b.a().a(this); 
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    u.a(30112, paramInt1, null);
    if (this.s != d.a) {
      this.s = d.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Video encountered error, what = ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", extra = ");
      stringBuilder.append(paramInt2);
      GDTLogger.e(stringBuilder.toString());
      E();
      this.y.post(new Runnable(this, paramInt1, paramInt2) {
            public void run() {
              if (f.b(this.c) != null) {
                f.a a = f.b(this.c);
                int i = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append("");
                a.a(i, new Exception(stringBuilder.toString()));
              } 
            }
          });
    } 
    return true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : I
    //   4: iload_1
    //   5: invokestatic getDefaultSize : (II)I
    //   8: istore #8
    //   10: aload_0
    //   11: getfield b : I
    //   14: iload_2
    //   15: invokestatic getDefaultSize : (II)I
    //   18: istore #9
    //   20: aload_0
    //   21: getfield a : I
    //   24: ifle -> 599
    //   27: aload_0
    //   28: getfield b : I
    //   31: ifle -> 599
    //   34: iload_1
    //   35: invokestatic getMode : (I)I
    //   38: istore #10
    //   40: iload_1
    //   41: invokestatic getSize : (I)I
    //   44: istore #7
    //   46: iload_2
    //   47: invokestatic getMode : (I)I
    //   50: istore #6
    //   52: iload_2
    //   53: invokestatic getSize : (I)I
    //   56: istore_1
    //   57: aload_0
    //   58: getfield t : Lcom/qq/e/comm/plugin/aa/b/f$c;
    //   61: getstatic com/qq/e/comm/plugin/aa/b/f$c.b : Lcom/qq/e/comm/plugin/aa/b/f$c;
    //   64: if_acmpne -> 206
    //   67: iload #7
    //   69: ifne -> 76
    //   72: iload_1
    //   73: ifeq -> 206
    //   76: aload_0
    //   77: getfield b : I
    //   80: iload #7
    //   82: imul
    //   83: aload_0
    //   84: getfield a : I
    //   87: iload_1
    //   88: imul
    //   89: if_icmplt -> 146
    //   92: iload #7
    //   94: ifne -> 100
    //   97: goto -> 146
    //   100: aload_0
    //   101: getfield b : I
    //   104: iload #7
    //   106: imul
    //   107: aload_0
    //   108: getfield a : I
    //   111: iload_1
    //   112: imul
    //   113: if_icmpgt -> 126
    //   116: iload #7
    //   118: istore_2
    //   119: iload_1
    //   120: istore #8
    //   122: iload_1
    //   123: ifne -> 161
    //   126: aload_0
    //   127: getfield b : I
    //   130: iload #7
    //   132: imul
    //   133: aload_0
    //   134: getfield a : I
    //   137: idiv
    //   138: istore #8
    //   140: iload #7
    //   142: istore_2
    //   143: goto -> 161
    //   146: aload_0
    //   147: getfield a : I
    //   150: iload_1
    //   151: imul
    //   152: aload_0
    //   153: getfield b : I
    //   156: idiv
    //   157: istore_2
    //   158: iload_1
    //   159: istore #8
    //   161: aload_0
    //   162: invokevirtual getContext : ()Landroid/content/Context;
    //   165: invokestatic b : (Landroid/content/Context;)I
    //   168: istore #6
    //   170: aload_0
    //   171: invokevirtual getContext : ()Landroid/content/Context;
    //   174: invokestatic c : (Landroid/content/Context;)I
    //   177: istore #7
    //   179: iload_2
    //   180: istore_1
    //   181: iload_2
    //   182: iload #7
    //   184: if_icmple -> 190
    //   187: iload #6
    //   189: istore_1
    //   190: iload_1
    //   191: istore_2
    //   192: iload #8
    //   194: istore #6
    //   196: iload #8
    //   198: iload #7
    //   200: if_icmple -> 513
    //   203: goto -> 450
    //   206: aload_0
    //   207: getfield t : Lcom/qq/e/comm/plugin/aa/b/f$c;
    //   210: getstatic com/qq/e/comm/plugin/aa/b/f$c.c : Lcom/qq/e/comm/plugin/aa/b/f$c;
    //   213: if_acmpne -> 307
    //   216: iload #8
    //   218: i2f
    //   219: fconst_1
    //   220: fmul
    //   221: aload_0
    //   222: getfield a : I
    //   225: i2f
    //   226: fdiv
    //   227: fstore_3
    //   228: iload #9
    //   230: i2f
    //   231: fconst_1
    //   232: fmul
    //   233: aload_0
    //   234: getfield b : I
    //   237: i2f
    //   238: fdiv
    //   239: fstore #4
    //   241: fload_3
    //   242: fload #4
    //   244: invokestatic max : (FF)F
    //   247: fstore #5
    //   249: iload #8
    //   251: iconst_2
    //   252: idiv
    //   253: istore_1
    //   254: iload #9
    //   256: iconst_2
    //   257: idiv
    //   258: istore_2
    //   259: new android/graphics/Matrix
    //   262: dup
    //   263: aload_0
    //   264: invokevirtual getMatrix : ()Landroid/graphics/Matrix;
    //   267: invokespecial <init> : (Landroid/graphics/Matrix;)V
    //   270: astore #11
    //   272: aload #11
    //   274: fload #5
    //   276: fload_3
    //   277: fdiv
    //   278: fload #5
    //   280: fload #4
    //   282: fdiv
    //   283: iload_1
    //   284: i2f
    //   285: iload_2
    //   286: i2f
    //   287: invokevirtual setScale : (FFFF)V
    //   290: aload_0
    //   291: aload #11
    //   293: invokevirtual setTransform : (Landroid/graphics/Matrix;)V
    //   296: iload #8
    //   298: istore #6
    //   300: iload #9
    //   302: istore #7
    //   304: goto -> 741
    //   307: iload #10
    //   309: ldc_w 1073741824
    //   312: if_icmpne -> 399
    //   315: iload #6
    //   317: ldc_w 1073741824
    //   320: if_icmpne -> 399
    //   323: aload_0
    //   324: getfield a : I
    //   327: iload_1
    //   328: imul
    //   329: aload_0
    //   330: getfield b : I
    //   333: iload #7
    //   335: imul
    //   336: if_icmpge -> 357
    //   339: aload_0
    //   340: getfield a : I
    //   343: iload_1
    //   344: imul
    //   345: aload_0
    //   346: getfield b : I
    //   349: idiv
    //   350: istore_2
    //   351: iload_1
    //   352: istore #6
    //   354: goto -> 513
    //   357: iload #7
    //   359: istore_2
    //   360: iload_1
    //   361: istore #6
    //   363: aload_0
    //   364: getfield a : I
    //   367: iload_1
    //   368: imul
    //   369: aload_0
    //   370: getfield b : I
    //   373: iload #7
    //   375: imul
    //   376: if_icmple -> 513
    //   379: aload_0
    //   380: getfield b : I
    //   383: iload #7
    //   385: imul
    //   386: aload_0
    //   387: getfield a : I
    //   390: idiv
    //   391: istore #6
    //   393: iload #7
    //   395: istore_2
    //   396: goto -> 513
    //   399: iload #10
    //   401: ldc_w 1073741824
    //   404: if_icmpne -> 456
    //   407: aload_0
    //   408: getfield b : I
    //   411: iload #7
    //   413: imul
    //   414: aload_0
    //   415: getfield a : I
    //   418: idiv
    //   419: istore #8
    //   421: iload #6
    //   423: ldc_w -2147483648
    //   426: if_icmpne -> 441
    //   429: iload #7
    //   431: istore_2
    //   432: iload_1
    //   433: istore #6
    //   435: iload #8
    //   437: iload_1
    //   438: if_icmpgt -> 513
    //   441: iload #8
    //   443: istore_2
    //   444: iload #7
    //   446: istore_1
    //   447: iload_2
    //   448: istore #7
    //   450: iload_1
    //   451: istore #6
    //   453: goto -> 741
    //   456: iload #6
    //   458: ldc_w 1073741824
    //   461: if_icmpne -> 527
    //   464: aload_0
    //   465: getfield a : I
    //   468: iload_1
    //   469: imul
    //   470: aload_0
    //   471: getfield b : I
    //   474: idiv
    //   475: istore #8
    //   477: iload #8
    //   479: istore #6
    //   481: iload_1
    //   482: istore_2
    //   483: iload #10
    //   485: ldc_w -2147483648
    //   488: if_icmpne -> 521
    //   491: iload #7
    //   493: istore_2
    //   494: iload_1
    //   495: istore #6
    //   497: iload #8
    //   499: iload #7
    //   501: if_icmpgt -> 513
    //   504: iload #8
    //   506: istore #6
    //   508: iload_1
    //   509: istore_2
    //   510: goto -> 521
    //   513: iload_2
    //   514: istore_1
    //   515: iload #6
    //   517: istore_2
    //   518: iload_1
    //   519: istore #6
    //   521: iload_2
    //   522: istore #7
    //   524: goto -> 741
    //   527: aload_0
    //   528: getfield a : I
    //   531: istore #8
    //   533: aload_0
    //   534: getfield b : I
    //   537: istore_2
    //   538: iload #6
    //   540: ldc_w -2147483648
    //   543: if_icmpne -> 567
    //   546: iload_2
    //   547: iload_1
    //   548: if_icmple -> 567
    //   551: aload_0
    //   552: getfield a : I
    //   555: iload_1
    //   556: imul
    //   557: aload_0
    //   558: getfield b : I
    //   561: idiv
    //   562: istore #8
    //   564: goto -> 569
    //   567: iload_2
    //   568: istore_1
    //   569: iload #8
    //   571: istore #6
    //   573: iload_1
    //   574: istore_2
    //   575: iload #10
    //   577: ldc_w -2147483648
    //   580: if_icmpne -> 521
    //   583: iload #8
    //   585: istore #6
    //   587: iload_1
    //   588: istore_2
    //   589: iload #8
    //   591: iload #7
    //   593: if_icmple -> 521
    //   596: goto -> 379
    //   599: iload #8
    //   601: istore #6
    //   603: iload #9
    //   605: istore #7
    //   607: invokestatic getSDKVersionCode : ()I
    //   610: bipush #13
    //   612: if_icmplt -> 741
    //   615: iload #8
    //   617: istore #6
    //   619: iload #9
    //   621: istore #7
    //   623: aload_0
    //   624: getfield g : I
    //   627: ifle -> 741
    //   630: iload #8
    //   632: istore #6
    //   634: iload #9
    //   636: istore #7
    //   638: aload_0
    //   639: getfield h : I
    //   642: ifle -> 741
    //   645: iload_1
    //   646: invokestatic getSize : (I)I
    //   649: istore_1
    //   650: iload_2
    //   651: invokestatic getSize : (I)I
    //   654: istore_2
    //   655: aload_0
    //   656: getfield h : I
    //   659: istore #6
    //   661: aload_0
    //   662: getfield g : I
    //   665: istore #7
    //   667: iload #6
    //   669: iload_1
    //   670: imul
    //   671: iload #7
    //   673: iload_2
    //   674: imul
    //   675: if_icmplt -> 725
    //   678: iload_2
    //   679: ifne -> 685
    //   682: goto -> 725
    //   685: iload #6
    //   687: iload_1
    //   688: imul
    //   689: iload #7
    //   691: iload_2
    //   692: imul
    //   693: if_icmpgt -> 706
    //   696: iload_1
    //   697: istore #6
    //   699: iload_2
    //   700: istore #7
    //   702: iload_1
    //   703: ifne -> 741
    //   706: aload_0
    //   707: getfield g : I
    //   710: iload_2
    //   711: imul
    //   712: aload_0
    //   713: getfield h : I
    //   716: idiv
    //   717: istore #6
    //   719: iload_2
    //   720: istore #7
    //   722: goto -> 741
    //   725: aload_0
    //   726: getfield h : I
    //   729: iload_1
    //   730: imul
    //   731: aload_0
    //   732: getfield g : I
    //   735: idiv
    //   736: istore #7
    //   738: iload_1
    //   739: istore #6
    //   741: invokestatic getSDKVersionCode : ()I
    //   744: bipush #13
    //   746: if_icmplt -> 812
    //   749: aload_0
    //   750: getfield q : Lcom/qq/e/comm/plugin/aa/b/b;
    //   753: astore #11
    //   755: aload #11
    //   757: ifnull -> 812
    //   760: aload #11
    //   762: instanceof com/qq/e/comm/plugin/gdtnativead/a/c
    //   765: ifeq -> 812
    //   768: iload #6
    //   770: aload_0
    //   771: getfield v : I
    //   774: if_icmpne -> 786
    //   777: iload #7
    //   779: aload_0
    //   780: getfield w : I
    //   783: if_icmpeq -> 812
    //   786: aload_0
    //   787: iload #6
    //   789: putfield v : I
    //   792: aload_0
    //   793: iload #7
    //   795: putfield w : I
    //   798: aload_0
    //   799: getfield q : Lcom/qq/e/comm/plugin/aa/b/b;
    //   802: checkcast com/qq/e/comm/plugin/gdtnativead/a/c
    //   805: iload #6
    //   807: iload #7
    //   809: invokevirtual a : (II)V
    //   812: aload_0
    //   813: iload #6
    //   815: iload #7
    //   817: invokevirtual setMeasuredDimension : (II)V
    //   820: return
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer) {
    this.s = d.c;
    this.k.set(true);
    GDTLogger.d("Video is prepared.");
    this.a = paramMediaPlayer.getVideoWidth();
    this.b = paramMediaPlayer.getVideoHeight();
    this.y.post(new Runnable(this) {
          public void run() {
            if (f.b(this.a) != null)
              f.b(this.a).a(); 
          }
        });
    if (this.n.get()) {
      GDTLogger.d("Player is prepared and seekTo() was called.");
      a(this.o);
    } 
    if (this.l.get() && this.j.get()) {
      GDTLogger.d("Player is prepared and play() was called.");
      b();
    } 
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSeekComplete: ");
    stringBuilder.append(paramMediaPlayer.getCurrentPosition());
    GDTLogger.d(stringBuilder.toString());
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    GDTLogger.d("onSurfaceTextureAvailable");
    if (this.c == null) {
      this.c = paramSurfaceTexture;
    } else if (Build.VERSION.SDK_INT >= 16) {
      setSurfaceTexture(this.c);
    } else {
      this.c.release();
      this.c = paramSurfaceTexture;
      Surface surface = this.f;
      if (surface != null)
        surface.release(); 
      this.f = new Surface(this.c);
    } 
    this.x.sendEmptyMessage(11);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture) {
    GDTLogger.d("onSurfaceTextureDestroyed");
    AtomicBoolean atomicBoolean = this.l;
    boolean bool = false;
    atomicBoolean.set(false);
    this.j.set(false);
    if (this.c == null)
      bool = true; 
    return bool;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {
    this.c = paramSurfaceTexture;
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2) {
    this.a = paramMediaPlayer.getVideoWidth();
    this.b = paramMediaPlayer.getVideoHeight();
    if (this.a != 0 && this.b != 0)
      this.y.post(new Runnable(this) {
            public void run() {
              this.a.requestLayout();
            }
          }); 
  }
  
  public static interface a {
    void a();
    
    void a(int param1Int, Exception param1Exception);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
    
    void f();
  }
  
  static class b {
    private static volatile b a;
    
    private ArrayBlockingQueue<WeakReference<f>> b = null;
    
    private int c = -1;
    
    private b() {
      this.b = new ArrayBlockingQueue<WeakReference<f>>(16);
    }
    
    public static b a() {
      // Byte code:
      //   0: getstatic com/qq/e/comm/plugin/aa/b/f$b.a : Lcom/qq/e/comm/plugin/aa/b/f$b;
      //   3: ifnonnull -> 37
      //   6: ldc com/qq/e/comm/plugin/aa/b/f$b
      //   8: monitorenter
      //   9: getstatic com/qq/e/comm/plugin/aa/b/f$b.a : Lcom/qq/e/comm/plugin/aa/b/f$b;
      //   12: ifnonnull -> 25
      //   15: new com/qq/e/comm/plugin/aa/b/f$b
      //   18: dup
      //   19: invokespecial <init> : ()V
      //   22: putstatic com/qq/e/comm/plugin/aa/b/f$b.a : Lcom/qq/e/comm/plugin/aa/b/f$b;
      //   25: ldc com/qq/e/comm/plugin/aa/b/f$b
      //   27: monitorexit
      //   28: goto -> 37
      //   31: astore_0
      //   32: ldc com/qq/e/comm/plugin/aa/b/f$b
      //   34: monitorexit
      //   35: aload_0
      //   36: athrow
      //   37: getstatic com/qq/e/comm/plugin/aa/b/f$b.a : Lcom/qq/e/comm/plugin/aa/b/f$b;
      //   40: areturn
      // Exception table:
      //   from	to	target	type
      //   9	25	31	finally
      //   25	28	31	finally
      //   32	35	31	finally
    }
    
    private int b() {
      int i = this.c;
      if (i >= 0)
        return i; 
      SM sM = GDTADManager.getInstance().getSM();
      if (sM != null) {
        String str = sM.getString("maxCachedPlayerCount");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("player cache count str = ");
        stringBuilder.append(str);
        GDTLogger.d(stringBuilder.toString());
        if (!TextUtils.isEmpty(str)) {
          try {
            i = Integer.parseInt(str);
          } catch (Exception exception) {
            GDTLogger.e(exception.getMessage());
            i = 5;
          } 
          int j = i;
          if (i < 0) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("player cache count = ");
            stringBuilder1.append(i);
            stringBuilder1.append(", set to default: ");
            stringBuilder1.append(5);
            GDTLogger.i(stringBuilder1.toString());
            j = 5;
          } 
          this.c = j;
          return j;
        } 
      } 
      i = 5;
    }
    
    public boolean a(f param1f) {
      if (param1f == null) {
        GDTLogger.e("view == null, return");
      } else {
        int i = b();
        if (i == 0) {
          GDTLogger.d("maxCount == 0, return");
          return false;
        } 
        if (this.b.size() == b()) {
          WeakReference<f> weakReference1 = this.b.poll();
          if (weakReference1 != null) {
            f f1 = weakReference1.get();
            if (f1 != null) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(f1.hashCode());
              stringBuilder1.append("'s player will be released, maxCacheCount = ");
              stringBuilder1.append(i);
              GDTLogger.e(stringBuilder1.toString());
              f1.m();
            } else {
              GDTLogger.d("player is released, remove it");
            } 
          } else {
            GDTLogger.e("queue is empty, why?!");
          } 
        } 
        WeakReference<f> weakReference = new WeakReference<f>(param1f);
        boolean bool = this.b.offer(weakReference);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1f.hashCode());
        stringBuilder.append(" add to cache, result = ");
        stringBuilder.append(bool);
        stringBuilder.append(", size = ");
        stringBuilder.append(this.b.size());
        GDTLogger.d(stringBuilder.toString());
        return bool;
      } 
      return false;
    }
    
    public boolean b(f param1f) {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_1
      //   3: ifnonnull -> 8
      //   6: iconst_0
      //   7: ireturn
      //   8: aload_0
      //   9: getfield b : Ljava/util/concurrent/ArrayBlockingQueue;
      //   12: invokevirtual iterator : ()Ljava/util/Iterator;
      //   15: astore #4
      //   17: aload #4
      //   19: invokeinterface hasNext : ()Z
      //   24: ifeq -> 49
      //   27: aload #4
      //   29: invokeinterface next : ()Ljava/lang/Object;
      //   34: checkcast java/lang/ref/WeakReference
      //   37: astore_3
      //   38: aload_1
      //   39: aload_3
      //   40: invokevirtual get : ()Ljava/lang/Object;
      //   43: if_acmpne -> 17
      //   46: goto -> 51
      //   49: aconst_null
      //   50: astore_3
      //   51: aload_3
      //   52: ifnull -> 118
      //   55: aload_0
      //   56: getfield b : Ljava/util/concurrent/ArrayBlockingQueue;
      //   59: aload_3
      //   60: invokevirtual remove : (Ljava/lang/Object;)Z
      //   63: istore_2
      //   64: new java/lang/StringBuilder
      //   67: dup
      //   68: invokespecial <init> : ()V
      //   71: astore_3
      //   72: aload_3
      //   73: aload_1
      //   74: invokevirtual hashCode : ()I
      //   77: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   80: pop
      //   81: aload_3
      //   82: ldc ' removed from cache, result = '
      //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: pop
      //   88: aload_3
      //   89: iload_2
      //   90: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   93: pop
      //   94: aload_3
      //   95: ldc ', size = '
      //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: pop
      //   101: aload_3
      //   102: aload_0
      //   103: getfield b : Ljava/util/concurrent/ArrayBlockingQueue;
      //   106: invokevirtual size : ()I
      //   109: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   112: pop
      //   113: aload_3
      //   114: astore_1
      //   115: goto -> 144
      //   118: new java/lang/StringBuilder
      //   121: dup
      //   122: invokespecial <init> : ()V
      //   125: astore_3
      //   126: aload_3
      //   127: aload_1
      //   128: invokevirtual hashCode : ()I
      //   131: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   134: pop
      //   135: aload_3
      //   136: ldc ' not in cache'
      //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: pop
      //   142: aload_3
      //   143: astore_1
      //   144: aload_1
      //   145: invokevirtual toString : ()Ljava/lang/String;
      //   148: invokestatic d : (Ljava/lang/String;)V
      //   151: iload_2
      //   152: ireturn
    }
  }
  
  public enum c {
    a, b, c;
  }
  
  public enum d {
    a, b, c, d, e, f, g;
    
    public static d[] a() {
      return (d[])h.clone();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */