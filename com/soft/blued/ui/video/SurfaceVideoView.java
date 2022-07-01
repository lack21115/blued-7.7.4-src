package com.soft.blued.ui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.utils.Logger;

public class SurfaceVideoView extends SurfaceView implements SurfaceHolder.Callback {
  MediaState a;
  
  OnStateChangeListener b;
  
  private MediaPlayer c;
  
  private Context d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private MediaPlayer.OnInfoListener i = new MediaPlayer.OnInfoListener(this) {
      public boolean onInfo(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
        Logger.a("dddrb", new Object[] { "onInfo what = ", Integer.valueOf(param1Int1) });
        if (this.a.b != null) {
          this.a.b.b();
          if (param1Int1 == 701) {
            this.a.b.c();
            return false;
          } 
          if (param1Int1 == 702)
            this.a.b.b(); 
        } 
        return false;
      }
    };
  
  private MediaPlayer.OnBufferingUpdateListener j = new MediaPlayer.OnBufferingUpdateListener(this) {
      public void onBufferingUpdate(MediaPlayer param1MediaPlayer, int param1Int) {
        Logger.a("ddrb", new Object[] { "onBufferingUpdate", Integer.valueOf(param1Int) });
        if (this.a.b != null && this.a.a == SurfaceVideoView.MediaState.c)
          this.a.b.a(SurfaceVideoView.a(this.a).getDuration(), SurfaceVideoView.a(this.a).getCurrentPosition()); 
      }
    };
  
  public SurfaceVideoView(Context paramContext) {
    super(paramContext);
    this.d = paramContext;
    a();
    Logger.a("dddrb", new Object[] { "Context context" });
  }
  
  public SurfaceVideoView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    a();
    Logger.a("dddrb", new Object[] { "Context context, AttributeSet attrs" });
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : I
    //   6: ifeq -> 181
    //   9: aload_0
    //   10: getfield f : I
    //   13: ifeq -> 181
    //   16: aload_0
    //   17: getfield g : I
    //   20: ifeq -> 181
    //   23: aload_0
    //   24: getfield h : I
    //   27: ifeq -> 181
    //   30: aload_0
    //   31: getfield e : I
    //   34: i2f
    //   35: aload_0
    //   36: getfield g : I
    //   39: i2f
    //   40: fdiv
    //   41: aload_0
    //   42: getfield f : I
    //   45: i2f
    //   46: aload_0
    //   47: getfield h : I
    //   50: i2f
    //   51: fdiv
    //   52: invokestatic min : (FF)F
    //   55: fstore_1
    //   56: ldc 'SurfaceVideoView'
    //   58: bipush #8
    //   60: anewarray java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: ldc 'resetViewSize before data: mVideoWidth:'
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_0
    //   71: getfield e : I
    //   74: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: ldc '   mVideoHeight:'
    //   82: aastore
    //   83: dup
    //   84: iconst_3
    //   85: aload_0
    //   86: getfield f : I
    //   89: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   92: aastore
    //   93: dup
    //   94: iconst_4
    //   95: ldc '   mSurfaceWidth:'
    //   97: aastore
    //   98: dup
    //   99: iconst_5
    //   100: aload_0
    //   101: getfield g : I
    //   104: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   107: aastore
    //   108: dup
    //   109: bipush #6
    //   111: ldc '   mSurfaceHeight:'
    //   113: aastore
    //   114: dup
    //   115: bipush #7
    //   117: aload_0
    //   118: getfield h : I
    //   121: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 'SurfaceVideoView'
    //   130: iconst_2
    //   131: anewarray java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: ldc '====ratio:'
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: fload_1
    //   142: invokestatic valueOf : (F)Ljava/lang/Float;
    //   145: aastore
    //   146: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield e : I
    //   154: i2f
    //   155: fload_1
    //   156: fdiv
    //   157: f2d
    //   158: invokestatic ceil : (D)D
    //   161: d2i
    //   162: putfield g : I
    //   165: aload_0
    //   166: aload_0
    //   167: getfield f : I
    //   170: i2f
    //   171: fload_1
    //   172: fdiv
    //   173: f2d
    //   174: invokestatic ceil : (D)D
    //   177: d2i
    //   178: putfield h : I
    //   181: ldc 'SurfaceVideoView'
    //   183: bipush #8
    //   185: anewarray java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: ldc 'resetViewSize after data: mVideoWidth:'
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload_0
    //   196: getfield e : I
    //   199: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_2
    //   205: ldc '   mVideoHeight:'
    //   207: aastore
    //   208: dup
    //   209: iconst_3
    //   210: aload_0
    //   211: getfield f : I
    //   214: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   217: aastore
    //   218: dup
    //   219: iconst_4
    //   220: ldc '   mSurfaceWidth:'
    //   222: aastore
    //   223: dup
    //   224: iconst_5
    //   225: aload_0
    //   226: getfield g : I
    //   229: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: bipush #6
    //   236: ldc '   mSurfaceHeight:'
    //   238: aastore
    //   239: dup
    //   240: bipush #7
    //   242: aload_0
    //   243: getfield h : I
    //   246: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   249: aastore
    //   250: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload_0
    //   254: monitorexit
    //   255: return
    //   256: astore_2
    //   257: aload_0
    //   258: monitorexit
    //   259: aload_2
    //   260: athrow
    // Exception table:
    //   from	to	target	type
    //   2	181	256	finally
    //   181	253	256	finally
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : I
    //   6: ifeq -> 310
    //   9: aload_0
    //   10: getfield f : I
    //   13: ifeq -> 310
    //   16: aload_0
    //   17: getfield g : I
    //   20: ifeq -> 310
    //   23: aload_0
    //   24: getfield g : I
    //   27: i2f
    //   28: aload_0
    //   29: getfield e : I
    //   32: i2f
    //   33: fdiv
    //   34: fstore_1
    //   35: ldc 'SurfaceVideoView'
    //   37: bipush #10
    //   39: anewarray java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 'fillWidth before data: mVideoWidth:'
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_0
    //   50: getfield e : I
    //   53: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: ldc '   mVideoHeight:'
    //   61: aastore
    //   62: dup
    //   63: iconst_3
    //   64: aload_0
    //   65: getfield f : I
    //   68: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   71: aastore
    //   72: dup
    //   73: iconst_4
    //   74: ldc ' mSurfaceWidth:'
    //   76: aastore
    //   77: dup
    //   78: iconst_5
    //   79: aload_0
    //   80: getfield g : I
    //   83: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   86: aastore
    //   87: dup
    //   88: bipush #6
    //   90: ldc '   mSurfaceHeight:'
    //   92: aastore
    //   93: dup
    //   94: bipush #7
    //   96: aload_0
    //   97: getfield h : I
    //   100: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   103: aastore
    //   104: dup
    //   105: bipush #8
    //   107: ldc '   ratioW:'
    //   109: aastore
    //   110: dup
    //   111: bipush #9
    //   113: fload_1
    //   114: invokestatic valueOf : (F)Ljava/lang/Float;
    //   117: aastore
    //   118: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_0
    //   122: getfield f : I
    //   125: i2f
    //   126: fload_1
    //   127: fmul
    //   128: fstore_1
    //   129: ldc 'SurfaceVideoView'
    //   131: iconst_2
    //   132: anewarray java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: ldc 'to fill width to get height:'
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: fload_1
    //   143: invokestatic valueOf : (F)Ljava/lang/Float;
    //   146: aastore
    //   147: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_0
    //   151: getfield h : I
    //   154: i2f
    //   155: fload_1
    //   156: fsub
    //   157: fconst_0
    //   158: fcmpl
    //   159: ifle -> 218
    //   162: fload_1
    //   163: aload_0
    //   164: getfield h : I
    //   167: i2f
    //   168: fdiv
    //   169: f2d
    //   170: ldc2_w 0.8
    //   173: dcmpl
    //   174: iflt -> 218
    //   177: aload_0
    //   178: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   181: invokevirtual C : ()I
    //   184: putfield g : I
    //   187: aload_0
    //   188: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   191: invokevirtual D : ()I
    //   194: putfield h : I
    //   197: ldc 'SurfaceVideoView'
    //   199: iconst_1
    //   200: anewarray java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: ldc 'go to fill screen'
    //   207: aastore
    //   208: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: invokespecial c : ()V
    //   215: goto -> 310
    //   218: aload_0
    //   219: fload_1
    //   220: f2i
    //   221: putfield h : I
    //   224: ldc 'SurfaceVideoView'
    //   226: iconst_1
    //   227: anewarray java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: ldc 'only fill width'
    //   234: aastore
    //   235: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: ldc 'SurfaceVideoView'
    //   240: bipush #8
    //   242: anewarray java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: ldc 'fillWidth after data: mVideoWidth:'
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: aload_0
    //   253: getfield e : I
    //   256: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   259: aastore
    //   260: dup
    //   261: iconst_2
    //   262: ldc '   mVideoHeight:'
    //   264: aastore
    //   265: dup
    //   266: iconst_3
    //   267: aload_0
    //   268: getfield f : I
    //   271: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   274: aastore
    //   275: dup
    //   276: iconst_4
    //   277: ldc ' mSurfaceWidth:'
    //   279: aastore
    //   280: dup
    //   281: iconst_5
    //   282: aload_0
    //   283: getfield g : I
    //   286: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: bipush #6
    //   293: ldc '   mSurfaceHeight:'
    //   295: aastore
    //   296: dup
    //   297: bipush #7
    //   299: aload_0
    //   300: getfield h : I
    //   303: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   306: aastore
    //   307: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload_0
    //   311: monitorexit
    //   312: return
    //   313: astore_2
    //   314: aload_0
    //   315: monitorexit
    //   316: aload_2
    //   317: athrow
    // Exception table:
    //   from	to	target	type
    //   2	215	313	finally
    //   218	310	313	finally
  }
  
  public void a() {
    this.g = LiveFloatManager.a().C();
    this.h = LiveFloatManager.a().D();
    getHolder().addCallback(this);
    getHolder().setType(3);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    if (this.a == MediaState.b) {
      b();
      return;
    } 
    try {
      this.c.reset();
      this.c.setLooping(paramBoolean);
      this.c.setDataSource(paramString);
      this.c.prepareAsync();
      this.a = MediaState.b;
      return;
    } catch (Exception exception) {
      Logger.a("ddrb", new Object[] { "e = ", exception, "mediaPlayer = ", this.c });
      exception.printStackTrace();
      OnStateChangeListener onStateChangeListener = this.b;
      if (onStateChangeListener != null)
        onStateChangeListener.e(); 
      return;
    } 
  }
  
  public void b() {
    ThreadManager.a().a(new ThreadExecutor(this, "SurfaceVideoStop") {
          public void execute() {
            try {
              SurfaceVideoView.MediaState mediaState1 = this.a.a;
              SurfaceVideoView.MediaState mediaState2 = SurfaceVideoView.MediaState.a;
              if (mediaState1 == mediaState2)
                return; 
              if (this.a.a == SurfaceVideoView.MediaState.b) {
                SurfaceVideoView.a(this.a).reset();
                this.a.a = SurfaceVideoView.MediaState.a;
                System.out.println("prepare->reset");
                return;
              } 
              if (this.a.a == SurfaceVideoView.MediaState.d) {
                SurfaceVideoView.a(this.a).stop();
                SurfaceVideoView.a(this.a).reset();
                this.a.a = SurfaceVideoView.MediaState.a;
                System.out.println("pause->init");
                return;
              } 
              if (this.a.a == SurfaceVideoView.MediaState.c) {
                SurfaceVideoView.a(this.a).pause();
                SurfaceVideoView.a(this.a).stop();
                SurfaceVideoView.a(this.a).reset();
                this.a.a = SurfaceVideoView.MediaState.a;
                System.out.println("playing->init");
                return;
              } 
            } catch (Exception exception) {
              this.a.a = SurfaceVideoView.MediaState.a;
            } finally {
              if (this.a.b != null)
                this.a.b.d(); 
            } 
          }
        });
  }
  
  public MediaPlayer getMediaPlayer() {
    return this.c;
  }
  
  public MediaState getState() {
    return this.a;
  }
  
  public void setOnStateChangeListener(OnStateChangeListener paramOnStateChangeListener) {
    this.b = paramOnStateChangeListener;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    if (this.c == null) {
      this.c = new MediaPlayer();
      this.c.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              param1MediaPlayer.start();
              this.a.a = SurfaceVideoView.MediaState.c;
              Logger.a("ddrb", new Object[] { "start" });
              if (this.a.b != null)
                this.a.b.b(); 
            }
          });
      this.c.setOnInfoListener(this.i);
      Logger.a("dddrb", new Object[] { "setOnInfoListener" });
      this.c.setOnErrorListener(new MediaPlayer.OnErrorListener(this) {
            public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
              param1MediaPlayer.release();
              this.a.a = SurfaceVideoView.MediaState.a;
              if (this.a.b != null)
                this.a.b.e(); 
              return false;
            }
          });
      this.c.setOnBufferingUpdateListener(this.j);
      this.c.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener(this) {
            public void onVideoSizeChanged(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
              SurfaceVideoView.a(this.a, param1Int1);
              SurfaceVideoView.b(this.a, param1Int2);
              SurfaceVideoView.b(this.a);
              if (SurfaceVideoView.c(this.a) != 0 && SurfaceVideoView.d(this.a) != 0 && SurfaceVideoView.e(this.a) != 0 && SurfaceVideoView.f(this.a) != 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(SurfaceVideoView.e(this.a), SurfaceVideoView.f(this.a));
                layoutParams.gravity = 17;
                this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              } 
            }
          });
    } 
    this.c.setDisplay(paramSurfaceHolder);
    this.a = MediaState.a;
    Logger.a("dddrb", new Object[] { "setDisplay" });
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    OnStateChangeListener onStateChangeListener = this.b;
    if (onStateChangeListener != null)
      onStateChangeListener.a(); 
  }
  
  public enum MediaState {
    a, b, c, d, e;
  }
  
  public static interface OnStateChangeListener {
    void a();
    
    void a(int param1Int1, int param1Int2);
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\SurfaceVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */