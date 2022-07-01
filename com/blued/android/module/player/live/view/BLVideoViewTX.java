package com.blued.android.module.player.live.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;

public class BLVideoViewTX extends AbsVideoView {
  private static final String a = BLVideoViewTX.class.getSimpleName();
  
  private SurfaceView b;
  
  private Surface c;
  
  private TXLivePlayer d;
  
  private int e = 1;
  
  private String f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private SurfaceHolder.Callback k = new SurfaceHolder.Callback(this) {
      int a;
      
      int b;
      
      public void surfaceChanged(SurfaceHolder param1SurfaceHolder, int param1Int1, int param1Int2, int param1Int3) {
        String str = BLVideoViewTX.e();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surfaceChanged mSurfaceHeight");
        stringBuilder.append(BLVideoViewTX.b(this.c));
        stringBuilder.append("mSurfaceWidth ");
        stringBuilder.append(BLVideoViewTX.a(this.c));
        Log.c(str, stringBuilder.toString());
        if (this.b != param1Int3 || this.a != param1Int2) {
          BLVideoViewTX.c(this.c).setSurfaceSize(BLVideoViewTX.a(this.c), BLVideoViewTX.b(this.c));
          BLVideoViewTX.c(this.c).setSurface(BLVideoViewTX.d(this.c));
        } 
      }
      
      public void surfaceCreated(SurfaceHolder param1SurfaceHolder) {
        BLVideoViewTX.a(this.c, param1SurfaceHolder.getSurface());
        this.a = BLVideoViewTX.a(this.c);
        this.b = BLVideoViewTX.b(this.c);
      }
      
      public void surfaceDestroyed(SurfaceHolder param1SurfaceHolder) {
        if (BLVideoViewTX.d(this.c) != null)
          BLVideoViewTX.d(this.c).release(); 
      }
    };
  
  private ITXLivePlayListener l = new ITXLivePlayListener(this) {
      public void onNetStatus(Bundle param1Bundle) {}
      
      public void onPlayEvent(int param1Int, Bundle param1Bundle) {
        // Byte code:
        //   0: new java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial <init> : ()V
        //   7: astore_3
        //   8: aload_3
        //   9: ldc 'receive event: '
        //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: pop
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   20: pop
        //   21: aload_3
        //   22: ldc ', '
        //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   27: pop
        //   28: aload_3
        //   29: aload_2
        //   30: ldc 'EVT_MSG'
        //   32: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
        //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: pop
        //   39: aload_3
        //   40: invokevirtual toString : ()Ljava/lang/String;
        //   43: astore_3
        //   44: invokestatic e : ()Ljava/lang/String;
        //   47: aload_3
        //   48: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
        //   51: pop
        //   52: iload_1
        //   53: sipush #-2301
        //   56: if_icmpeq -> 224
        //   59: iload_1
        //   60: sipush #2009
        //   63: if_icmpeq -> 121
        //   66: iload_1
        //   67: sipush #2003
        //   70: if_icmpeq -> 109
        //   73: iload_1
        //   74: sipush #2004
        //   77: if_icmpeq -> 109
        //   80: iload_1
        //   81: sipush #2006
        //   84: if_icmpeq -> 224
        //   87: iload_1
        //   88: sipush #2007
        //   91: if_icmpeq -> 97
        //   94: goto -> 233
        //   97: invokestatic e : ()Ljava/lang/String;
        //   100: ldc 'onLoading'
        //   102: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   105: pop
        //   106: goto -> 233
        //   109: invokestatic e : ()Ljava/lang/String;
        //   112: ldc 'PLAY_EVT_RCV_FIRST_I_FRAME'
        //   114: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
        //   117: pop
        //   118: goto -> 233
        //   121: aload_0
        //   122: getfield a : Lcom/blued/android/module/player/live/view/BLVideoViewTX;
        //   125: aload_2
        //   126: ldc 'EVT_PARAM1'
        //   128: invokevirtual getInt : (Ljava/lang/String;)I
        //   131: invokestatic a : (Lcom/blued/android/module/player/live/view/BLVideoViewTX;I)I
        //   134: pop
        //   135: aload_0
        //   136: getfield a : Lcom/blued/android/module/player/live/view/BLVideoViewTX;
        //   139: aload_2
        //   140: ldc 'EVT_PARAM2'
        //   142: invokevirtual getInt : (Ljava/lang/String;)I
        //   145: invokestatic b : (Lcom/blued/android/module/player/live/view/BLVideoViewTX;I)I
        //   148: pop
        //   149: invokestatic e : ()Ljava/lang/String;
        //   152: astore_2
        //   153: new java/lang/StringBuilder
        //   156: dup
        //   157: invokespecial <init> : ()V
        //   160: astore #4
        //   162: aload #4
        //   164: ldc 'PLAY_EVT_CHANGE_RESOLUTION mVideoWidth'
        //   166: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: pop
        //   170: aload #4
        //   172: aload_0
        //   173: getfield a : Lcom/blued/android/module/player/live/view/BLVideoViewTX;
        //   176: invokestatic e : (Lcom/blued/android/module/player/live/view/BLVideoViewTX;)I
        //   179: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   182: pop
        //   183: aload #4
        //   185: ldc 'mVideoHeight '
        //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: pop
        //   191: aload #4
        //   193: aload_0
        //   194: getfield a : Lcom/blued/android/module/player/live/view/BLVideoViewTX;
        //   197: invokestatic f : (Lcom/blued/android/module/player/live/view/BLVideoViewTX;)I
        //   200: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   203: pop
        //   204: aload_2
        //   205: aload #4
        //   207: invokevirtual toString : ()Ljava/lang/String;
        //   210: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   213: pop
        //   214: aload_0
        //   215: getfield a : Lcom/blued/android/module/player/live/view/BLVideoViewTX;
        //   218: invokevirtual d : ()V
        //   221: goto -> 233
        //   224: invokestatic e : ()Ljava/lang/String;
        //   227: ldc 'onCompletion'
        //   229: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   232: pop
        //   233: iload_1
        //   234: ifge -> 245
        //   237: invokestatic e : ()Ljava/lang/String;
        //   240: aload_3
        //   241: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
        //   244: pop
        //   245: return
      }
    };
  
  public BLVideoViewTX(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public BLVideoViewTX(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BLVideoViewTX(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.b = new SurfaceView(paramContext);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    addView((View)this.b);
    this.b.getHolder().addCallback(this.k);
  }
  
  private boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString) || (!paramString.startsWith("http://") && !paramString.startsWith("https://") && !paramString.startsWith("rtmp://") && !paramString.startsWith("/"))) {
      Log.c(a, "url is invalid");
      return false;
    } 
    if (paramString.startsWith("rtmp://")) {
      this.e = 0;
    } else {
      if ((paramString.startsWith("http://") || paramString.startsWith("https://")) && paramString.contains(".flv")) {
        this.e = 1;
        this.f = paramString;
        return true;
      } 
      Log.c(a, "url is invalide");
      return false;
    } 
    this.f = paramString;
    return true;
  }
  
  private void f() {
    if (this.d == null) {
      this.d = new TXLivePlayer(AppInfo.d());
      this.d.enableHardwareDecode(false);
    } 
    this.g = AppInfo.m;
    this.h = AppInfo.l;
    g();
    this.d.setSurface(this.c);
    this.d.setSurfaceSize(this.g, this.h);
    this.d.setPlayListener(this.l);
  }
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/view/SurfaceView;
    //   6: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnonnull -> 33
    //   14: new android/widget/FrameLayout$LayoutParams
    //   17: dup
    //   18: aload_0
    //   19: getfield g : I
    //   22: aload_0
    //   23: getfield h : I
    //   26: invokespecial <init> : (II)V
    //   29: astore_1
    //   30: goto -> 49
    //   33: aload_1
    //   34: aload_0
    //   35: getfield g : I
    //   38: putfield width : I
    //   41: aload_1
    //   42: aload_0
    //   43: getfield h : I
    //   46: putfield height : I
    //   49: aload_0
    //   50: getfield b : Landroid/view/SurfaceView;
    //   53: aload_1
    //   54: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	60	finally
    //   14	30	60	finally
    //   33	49	60	finally
    //   49	57	60	finally
  }
  
  public void a() {
    if (!TextUtils.isEmpty(this.f))
      this.d.startPlay(this.f, this.e); 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.g = paramInt1;
    this.h = paramInt2;
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSurfaceWidthHeight width = ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" -- height = ");
    stringBuilder.append(paramInt2);
    Log.a(str, stringBuilder.toString());
    d();
  }
  
  public void a(View paramView) {
    f();
  }
  
  public void b() {
    TXLivePlayer tXLivePlayer = this.d;
    if (tXLivePlayer != null)
      tXLivePlayer.pause(); 
  }
  
  public void c() {
    TXLivePlayer tXLivePlayer = this.d;
    if (tXLivePlayer != null) {
      tXLivePlayer.setPlayListener(null);
      this.d.stopPlay(true);
    } 
    Surface surface = this.c;
    if (surface != null)
      surface.release(); 
    this.d = null;
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : I
    //   6: ifeq -> 237
    //   9: aload_0
    //   10: getfield j : I
    //   13: ifeq -> 237
    //   16: aload_0
    //   17: getfield g : I
    //   20: ifeq -> 237
    //   23: aload_0
    //   24: getfield h : I
    //   27: ifeq -> 237
    //   30: aload_0
    //   31: getfield i : I
    //   34: i2f
    //   35: aload_0
    //   36: getfield g : I
    //   39: i2f
    //   40: fdiv
    //   41: fstore_2
    //   42: aload_0
    //   43: getfield j : I
    //   46: i2f
    //   47: aload_0
    //   48: getfield h : I
    //   51: i2f
    //   52: fdiv
    //   53: fstore_3
    //   54: fload_2
    //   55: fstore_1
    //   56: getstatic com/blued/android/module/player/live/view/BLVideoView.a : Z
    //   59: ifeq -> 68
    //   62: fload_2
    //   63: fload_3
    //   64: invokestatic max : (FF)F
    //   67: fstore_1
    //   68: getstatic com/blued/android/module/player/live/view/BLVideoViewTX.a : Ljava/lang/String;
    //   71: astore #4
    //   73: new java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial <init> : ()V
    //   80: astore #5
    //   82: aload #5
    //   84: ldc 'before data: mVideoWidth:'
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #5
    //   92: aload_0
    //   93: getfield i : I
    //   96: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #5
    //   102: ldc '   mVideoHeight:'
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #5
    //   110: aload_0
    //   111: getfield j : I
    //   114: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload #5
    //   120: ldc ' mSurfaceWidth:'
    //   122: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload #5
    //   128: aload_0
    //   129: getfield g : I
    //   132: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #5
    //   138: ldc '   mSurfaceHeight:'
    //   140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload #5
    //   146: aload_0
    //   147: getfield h : I
    //   150: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload #4
    //   156: aload #5
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: getstatic com/blued/android/module/player/live/view/BLVideoViewTX.a : Ljava/lang/String;
    //   168: astore #4
    //   170: new java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial <init> : ()V
    //   177: astore #5
    //   179: aload #5
    //   181: ldc '====ratio:'
    //   183: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload #5
    //   189: fload_1
    //   190: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload #4
    //   196: aload #5
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   204: pop
    //   205: aload_0
    //   206: aload_0
    //   207: getfield i : I
    //   210: i2f
    //   211: fload_1
    //   212: fdiv
    //   213: f2d
    //   214: invokestatic ceil : (D)D
    //   217: d2i
    //   218: putfield g : I
    //   221: aload_0
    //   222: aload_0
    //   223: getfield j : I
    //   226: i2f
    //   227: fload_1
    //   228: fdiv
    //   229: f2d
    //   230: invokestatic ceil : (D)D
    //   233: d2i
    //   234: putfield h : I
    //   237: getstatic com/blued/android/module/player/live/view/BLVideoViewTX.a : Ljava/lang/String;
    //   240: astore #4
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: astore #5
    //   251: aload #5
    //   253: ldc 'after data: mVideoWidth:'
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload #5
    //   261: aload_0
    //   262: getfield i : I
    //   265: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #5
    //   271: ldc '   mVideoHeight:'
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload #5
    //   279: aload_0
    //   280: getfield j : I
    //   283: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: ldc ' mSurfaceWidth:'
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload #5
    //   297: aload_0
    //   298: getfield g : I
    //   301: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #5
    //   307: ldc '   mSurfaceHeight:'
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #5
    //   315: aload_0
    //   316: getfield h : I
    //   319: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #4
    //   325: aload #5
    //   327: invokevirtual toString : ()Ljava/lang/String;
    //   330: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   333: pop
    //   334: aload_0
    //   335: invokespecial g : ()V
    //   338: aload_0
    //   339: monitorexit
    //   340: return
    //   341: astore #4
    //   343: aload_0
    //   344: monitorexit
    //   345: aload #4
    //   347: athrow
    // Exception table:
    //   from	to	target	type
    //   2	54	341	finally
    //   56	68	341	finally
    //   68	237	341	finally
    //   237	338	341	finally
  }
  
  public void setVideoPath(String paramString) {
    a(paramString);
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\live\view\BLVideoViewTX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */