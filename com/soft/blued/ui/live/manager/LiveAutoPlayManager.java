package com.soft.blued.ui.live.manager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatInitData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.LiveEnterFailedReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import java.util.List;

public class LiveAutoPlayManager implements LiveChatInfoListener, LiveSysNetworkObserver.ILiveSysNetworkObserver {
  private static volatile LiveAutoPlayManager a;
  
  private BlLiveView b;
  
  private LiveAutoPlayer c;
  
  private String d;
  
  private short e = 4;
  
  private long f = -1L;
  
  private LiveRoomData g;
  
  private String h;
  
  private LiveChatInitData i;
  
  private OnMediaPlayerConnectListener j;
  
  private int k = 1;
  
  private Reconnect l = new Reconnect();
  
  private boolean m = false;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private LiveEnterFailedReason q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private Handler v;
  
  private LiveAutoPlayer.LiveAutoPlayerListener w = new LiveAutoPlayer.LiveAutoPlayerListener(this) {
      public void a() {
        Logger.b("LiveAutoPlayManager", new Object[] { "onMediaBufferStart" });
        this.a.g();
        if (LiveAutoPlayManager.a(this.a) != null)
          LiveAutoPlayManager.a(this.a).a(); 
      }
      
      public void a(int param1Int1, int param1Int2) {
        LiveAutoPlayManager.a(this.a, param1Int1);
        LiveAutoPlayManager.b(this.a, param1Int2);
      }
      
      public void b() {
        Logger.b("LiveAutoPlayManager", new Object[] { "onMediaBufferEnd" });
        this.a.i();
        if (LiveAutoPlayManager.a(this.a) != null)
          LiveAutoPlayManager.a(this.a).b(); 
      }
      
      public void c() {
        Logger.b("LiveAutoPlayManager", new Object[] { "onMediaVideoStart" });
        this.a.i();
        if (LiveAutoPlayManager.a(this.a) != null)
          LiveAutoPlayManager.a(this.a).c(); 
      }
      
      public void d() {
        if (!LiveAutoPlayManager.b(this.a))
          this.a.b(); 
      }
      
      public void e() {
        if (!LiveAutoPlayManager.b(this.a))
          this.a.b(); 
      }
    };
  
  private LiveAutoPlayManager() {
    o();
    this.v = new Handler(Looper.getMainLooper());
    this.c = new LiveAutoPlayer();
    this.c.a(this.w);
  }
  
  public static LiveAutoPlayManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/live/manager/LiveAutoPlayManager.a : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/live/manager/LiveAutoPlayManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/live/manager/LiveAutoPlayManager.a : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/live/manager/LiveAutoPlayManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/live/manager/LiveAutoPlayManager.a : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;
    //   25: ldc com/soft/blued/ui/live/manager/LiveAutoPlayManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/live/manager/LiveAutoPlayManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/live/manager/LiveAutoPlayManager.a : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(LiveRoomData paramLiveRoomData, String paramString) {
    if (paramLiveRoomData == null) {
      Logger.b("LiveAutoPlayManager", new Object[] { "initLiveData discard, liveRoomData is null" });
      return;
    } 
    this.g = paramLiveRoomData;
    this.h = paramString;
    String str = this.g.live_url;
    if (!TextUtils.isEmpty(str))
      try {
        this.d = AesCrypto.e(str);
        a(this.d, this.g, this.h);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  private void a(String paramString1, LiveRoomData paramLiveRoomData, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 'initMediaPlayer'
    //   12: aastore
    //   13: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   20: invokevirtual a : ()Z
    //   23: ifeq -> 30
    //   26: aload_0
    //   27: invokespecial m : ()V
    //   30: aload_0
    //   31: aload_1
    //   32: putfield d : Ljava/lang/String;
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield k : I
    //   40: aload_0
    //   41: aload_2
    //   42: getfield lid : J
    //   45: putfield f : J
    //   48: aload_0
    //   49: aload_2
    //   50: putfield g : Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   53: aload_0
    //   54: aload_3
    //   55: putfield h : Ljava/lang/String;
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield o : Z
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield p : Z
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield n : Z
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield q : Lcom/blued/android/chat/data/LiveEnterFailedReason;
    //   78: aload_0
    //   79: getfield v : Landroid/os/Handler;
    //   82: aload_0
    //   83: getfield l : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager$Reconnect;
    //   86: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   89: aload_0
    //   90: invokespecial l : ()V
    //   93: aload_0
    //   94: invokevirtual g : ()V
    //   97: invokestatic a : ()Lcom/blued/android/module/live_china/observer/LiveSysNetworkObserver;
    //   100: aload_0
    //   101: invokevirtual a : (Lcom/blued/android/module/live_china/observer/LiveSysNetworkObserver$ILiveSysNetworkObserver;)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: astore_1
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_1
    //   111: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	107	finally
    //   30	104	107	finally
  }
  
  private void l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_2
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 'prepare mVideoPath = '
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: aload_0
    //   16: getfield d : Ljava/lang/String;
    //   19: aastore
    //   20: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   23: aload_0
    //   24: getfield d : Ljava/lang/String;
    //   27: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   30: ifeq -> 50
    //   33: ldc 'LiveAutoPlayManager'
    //   35: iconst_1
    //   36: anewarray java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: ldc 'prepare mVideoPath empty'
    //   43: aastore
    //   44: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   54: invokevirtual a : ()Z
    //   57: ifeq -> 64
    //   60: aload_0
    //   61: invokespecial n : ()V
    //   64: aload_0
    //   65: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   68: aload_0
    //   69: getfield d : Ljava/lang/String;
    //   72: aload_0
    //   73: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   76: invokevirtual a : (Ljava/lang/String;Lcom/blued/android/module/player/txplayer/view/BlLiveView;)V
    //   79: ldc 'LiveAutoPlayManager'
    //   81: iconst_1
    //   82: anewarray java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: ldc 'prepare prepareAsync'
    //   89: aastore
    //   90: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -> 105
    //   96: astore_1
    //   97: aload_0
    //   98: invokespecial m : ()V
    //   101: aload_1
    //   102: invokevirtual printStackTrace : ()V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   2	47	108	finally
    //   50	64	96	java/lang/Exception
    //   50	64	108	finally
    //   64	93	96	java/lang/Exception
    //   64	93	108	finally
    //   97	105	108	finally
  }
  
  private void m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 'release'
    //   12: aastore
    //   13: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: invokespecial n : ()V
    //   20: invokestatic a : ()Lcom/blued/android/module/live_china/observer/LiveSysNetworkObserver;
    //   23: aload_0
    //   24: invokevirtual b : (Lcom/blued/android/module/live_china/observer/LiveSysNetworkObserver$ILiveSysNetworkObserver;)V
    //   27: aload_0
    //   28: getfield v : Landroid/os/Handler;
    //   31: aload_0
    //   32: getfield l : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager$Reconnect;
    //   35: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   38: aload_0
    //   39: invokevirtual g : ()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield g : Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield i : Lcom/blued/android/chat/data/LiveChatInitData;
    //   52: aload_0
    //   53: ldc2_w -1
    //   56: putfield f : J
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield e : S
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield k : I
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield o : Z
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield p : Z
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield m : Z
    //   84: aload_0
    //   85: iconst_0
    //   86: putfield n : Z
    //   89: aload_0
    //   90: aconst_null
    //   91: putfield q : Lcom/blued/android/chat/data/LiveEnterFailedReason;
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield d : Ljava/lang/String;
    //   99: aload_0
    //   100: iconst_0
    //   101: putfield r : I
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield s : I
    //   109: aload_0
    //   110: ldc ''
    //   112: putfield h : Ljava/lang/String;
    //   115: aload_0
    //   116: monitorexit
    //   117: return
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Exception table:
    //   from	to	target	type
    //   2	115	118	finally
  }
  
  private void n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc 'setMediaEmpty'
    //   12: aastore
    //   13: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield g : Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   21: aload_0
    //   22: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   25: invokevirtual b : ()Z
    //   28: ifeq -> 38
    //   31: aload_0
    //   32: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   35: invokevirtual f : ()V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	41	finally
  }
  
  private void o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic d : ()Landroid/content/Context;
    //   6: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   9: ldc 2131493128
    //   11: aconst_null
    //   12: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   15: ldc 2131296337
    //   17: invokevirtual findViewById : (I)Landroid/view/View;
    //   20: checkcast com/blued/android/module/player/txplayer/view/BlLiveView
    //   23: putfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	29	finally
  }
  
  private void p() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield r : I
    //   6: ifeq -> 110
    //   9: aload_0
    //   10: getfield s : I
    //   13: ifeq -> 110
    //   16: aload_0
    //   17: getfield t : I
    //   20: ifeq -> 110
    //   23: aload_0
    //   24: getfield u : I
    //   27: ifeq -> 110
    //   30: aload_0
    //   31: getfield r : I
    //   34: i2f
    //   35: aload_0
    //   36: getfield t : I
    //   39: i2f
    //   40: fdiv
    //   41: aload_0
    //   42: getfield s : I
    //   45: i2f
    //   46: aload_0
    //   47: getfield u : I
    //   50: i2f
    //   51: fdiv
    //   52: invokestatic min : (FF)F
    //   55: fstore_1
    //   56: ldc 'LiveAutoPlayManager'
    //   58: iconst_2
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc_w '====ratio:'
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: fload_1
    //   71: invokestatic valueOf : (F)Ljava/lang/Float;
    //   74: aastore
    //   75: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_0
    //   79: aload_0
    //   80: getfield r : I
    //   83: i2f
    //   84: fload_1
    //   85: fdiv
    //   86: f2d
    //   87: invokestatic ceil : (D)D
    //   90: d2i
    //   91: putfield t : I
    //   94: aload_0
    //   95: aload_0
    //   96: getfield s : I
    //   99: i2f
    //   100: fload_1
    //   101: fdiv
    //   102: f2d
    //   103: invokestatic ceil : (D)D
    //   106: d2i
    //   107: putfield u : I
    //   110: ldc 'LiveAutoPlayManager'
    //   112: bipush #8
    //   114: anewarray java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: ldc_w 'after data: mVideoWidth:'
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload_0
    //   126: getfield r : I
    //   129: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: ldc_w '   mVideoHeight:'
    //   138: aastore
    //   139: dup
    //   140: iconst_3
    //   141: aload_0
    //   142: getfield s : I
    //   145: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_4
    //   151: ldc_w ' mSurfaceWidth:'
    //   154: aastore
    //   155: dup
    //   156: iconst_5
    //   157: aload_0
    //   158: getfield t : I
    //   161: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   164: aastore
    //   165: dup
    //   166: bipush #6
    //   168: ldc_w '   mSurfaceHeight:'
    //   171: aastore
    //   172: dup
    //   173: bipush #7
    //   175: aload_0
    //   176: getfield u : I
    //   179: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: invokespecial q : ()V
    //   190: aload_0
    //   191: monitorexit
    //   192: return
    //   193: astore_2
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_2
    //   197: athrow
    // Exception table:
    //   from	to	target	type
    //   2	110	193	finally
    //   110	190	193	finally
  }
  
  private void q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic n : ()Landroid/os/Handler;
    //   5: new com/soft/blued/ui/live/manager/-$$Lambda$LiveAutoPlayManager$yBqbCTS43RPbC0Z4lIa5csv_Krg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial <init> : (Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;)V
    //   13: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  private BlLiveView r() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   6: ifnull -> 35
    //   9: aload_0
    //   10: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   13: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   16: astore_1
    //   17: aload_1
    //   18: instanceof android/view/ViewGroup
    //   21: ifeq -> 35
    //   24: aload_1
    //   25: checkcast android/view/ViewGroup
    //   28: aload_0
    //   29: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   32: invokevirtual removeView : (Landroid/view/View;)V
    //   35: ldc 'LiveAutoPlayManager'
    //   37: iconst_1
    //   38: anewarray java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc_w 'getSurfaceView'
    //   46: aastore
    //   47: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	59	finally
    //   35	55	59	finally
  }
  
  public void Q() {
    Logger.b("LiveAutoPlayManager", new Object[] { "wifi disconnect" });
    e();
    r();
  }
  
  public void a(LiveRoomData paramLiveRoomData, String paramString, FrameLayout paramFrameLayout, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore #6
    //   11: aload #6
    //   13: ldc_w 'autoPlay:'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload #6
    //   22: aload_1
    //   23: getfield lid : J
    //   26: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 'LiveAutoPlayManager'
    //   32: iconst_1
    //   33: anewarray java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload #6
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   50: invokevirtual F : ()Z
    //   53: ifeq -> 74
    //   56: ldc 'LiveAutoPlayManager'
    //   58: iconst_1
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc_w 'float window is playing, discard!'
    //   67: aastore
    //   68: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield g : Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   78: ifnull -> 126
    //   81: aload_1
    //   82: getfield live_url : Ljava/lang/String;
    //   85: aload_0
    //   86: getfield g : Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   89: getfield live_url : Ljava/lang/String;
    //   92: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   95: ifeq -> 126
    //   98: aload_0
    //   99: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   102: invokevirtual b : ()Z
    //   105: ifeq -> 126
    //   108: ldc 'LiveAutoPlayManager'
    //   110: iconst_1
    //   111: anewarray java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: ldc_w 'already auto play, discard!'
    //   119: aastore
    //   120: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: monitorexit
    //   125: return
    //   126: aload_0
    //   127: invokespecial r : ()Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   130: astore #6
    //   132: aload #6
    //   134: ifnonnull -> 140
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: new java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #7
    //   149: aload #7
    //   151: ldc_w 'autoPlay prepare:'
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload #7
    //   160: aload_1
    //   161: getfield lid : J
    //   164: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 'LiveAutoPlayManager'
    //   170: iconst_1
    //   171: anewarray java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload #7
    //   178: invokevirtual toString : ()Ljava/lang/String;
    //   181: aastore
    //   182: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: aload_0
    //   186: iload #4
    //   188: putfield t : I
    //   191: aload_0
    //   192: iload #5
    //   194: putfield u : I
    //   197: new android/widget/FrameLayout$LayoutParams
    //   200: dup
    //   201: iconst_1
    //   202: iconst_1
    //   203: invokespecial <init> : (II)V
    //   206: astore #7
    //   208: aload #7
    //   210: bipush #17
    //   212: putfield gravity : I
    //   215: aload_3
    //   216: aload #6
    //   218: aload #7
    //   220: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   223: aload_0
    //   224: aload_1
    //   225: aload_2
    //   226: invokespecial a : (Lcom/blued/android/module/live_china/model/LiveRoomData;Ljava/lang/String;)V
    //   229: aload_0
    //   230: invokevirtual d : ()V
    //   233: aload_0
    //   234: monitorexit
    //   235: return
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    // Exception table:
    //   from	to	target	type
    //   2	71	236	finally
    //   74	123	236	finally
    //   126	132	236	finally
    //   140	233	236	finally
  }
  
  public void b() {
    g();
    OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.j;
    if (onMediaPlayerConnectListener != null)
      onMediaPlayerConnectListener.d(); 
    int i = this.k;
    if (i < 10) {
      this.k = i + 1;
      c();
      return;
    } 
    h();
    onMediaPlayerConnectListener = this.j;
    if (onMediaPlayerConnectListener != null)
      onMediaPlayerConnectListener.e(); 
  }
  
  public void c() {
    this.v.removeCallbacks(this.l);
    this.v.postDelayed(this.l, 3000L);
  }
  
  public void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   6: invokevirtual c : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 'pause'
    //   13: aastore
    //   14: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: getfield c : Lcom/soft/blued/ui/live/manager/LiveAutoPlayer;
    //   21: invokevirtual d : ()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	27	finally
  }
  
  public long f() {
    return this.f;
  }
  
  public void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 'setLiveLoading'
    //   13: aastore
    //   14: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield o : Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield p : Z
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	30	finally
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 'setLiveLoadFail'
    //   13: aastore
    //   14: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield o : Z
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield p : Z
    //   27: aload_0
    //   28: getfield v : Landroid/os/Handler;
    //   31: aload_0
    //   32: getfield l : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager$Reconnect;
    //   35: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	38	41	finally
  }
  
  public void i() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 'setLiveLoadSuccess'
    //   13: aastore
    //   14: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield o : Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield p : Z
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield k : I
    //   32: aload_0
    //   33: getfield v : Landroid/os/Handler;
    //   36: aload_0
    //   37: getfield l : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager$Reconnect;
    //   40: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   43: aload_0
    //   44: getfield v : Landroid/os/Handler;
    //   47: new com/soft/blued/ui/live/manager/-$$Lambda$LiveAutoPlayManager$9vzxgGfC6m0BkwypljvQ1rdxgR4
    //   50: dup
    //   51: aload_0
    //   52: invokespecial <init> : (Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager;)V
    //   55: ldc2_w 300
    //   58: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   61: pop
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   2	62	65	finally
  }
  
  public void j() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'LiveAutoPlayManager'
    //   4: iconst_1
    //   5: anewarray java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 'setLiveLoadOver'
    //   13: aastore
    //   14: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield o : Z
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield p : Z
    //   27: aload_0
    //   28: invokespecial n : ()V
    //   31: aload_0
    //   32: getfield v : Landroid/os/Handler;
    //   35: aload_0
    //   36: getfield l : Lcom/soft/blued/ui/live/manager/LiveAutoPlayManager$Reconnect;
    //   39: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	45	finally
  }
  
  public boolean k() {
    return this.c.b();
  }
  
  public void onClose(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    Logger.b("LiveAutoPlayManager", new Object[] { "onClose" });
    this.q = LiveEnterFailedReason.LIVEROOM_CLOSE;
    this.n = true;
    j();
  }
  
  public void onJoinLive(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3) {}
  
  public void onRecvNewMsg(ChattingModel paramChattingModel) {}
  
  public void onViewerDataChanged(long paramLong, List<ProfileData> paramList) {}
  
  public void onViewerEntrance(EntranceData paramEntranceData, long paramLong) {}
  
  public static interface OnMediaPlayerConnectListener {
    void a();
    
    void b();
    
    void c();
    
    void d();
    
    void e();
  }
  
  class Reconnect implements Runnable {
    private Reconnect(LiveAutoPlayManager this$0) {}
    
    public void run() {
      LiveAutoPlayManager.c(this.a).e();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\manager\LiveAutoPlayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */