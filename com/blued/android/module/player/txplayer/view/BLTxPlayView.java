package com.blued.android.module.player.txplayer.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.player.Config;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.File;

public class BLTxPlayView extends AbBaseVideoView implements ITXVodPlayListener {
  private TXCloudVideoView g;
  
  private TXVodPlayer h;
  
  private TXVodPlayConfig i;
  
  private Context j;
  
  private int k;
  
  private boolean l;
  
  private int m = 0;
  
  private int n = 0;
  
  private PlayerState o = PlayerState.a;
  
  public BLTxPlayView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BLTxPlayView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BLTxPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  private void h() {
    this.j = AppInfo.d();
    if (TextUtils.isEmpty(this.b)) {
      File file = this.j.getExternalCacheDir();
      if (file != null && file.exists()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(file.getAbsolutePath());
        stringBuilder1.append("/TX/PLDroidPlayer");
        this.b = stringBuilder1.toString();
      } else {
        this.b = Config.b;
      } 
    } 
    Utils.b(this.b);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init ");
    stringBuilder.append(this);
    Log.c("BLTxPlayView", stringBuilder.toString());
    i();
  }
  
  private void i() {
    this.g = new TXCloudVideoView(this.j);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    Log.b("BLTxPlayView", "init mPlayerView");
    addView((View)this.g);
  }
  
  private void j() {
    if (this.h == null) {
      this.h = new TXVodPlayer(this.j);
      this.h.setRequestAudioFocus(false);
      this.h.setLoop(true);
      this.h.setVodListener(this);
    } 
    if (this.i == null) {
      this.i = new TXVodPlayConfig();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("initPlayer: cache dir = ");
      stringBuilder.append(this.b);
      Log.c("BLTxPlayView", stringBuilder.toString());
      this.i.setCacheFolderPath(this.b);
      this.i.setMaxCacheItems(30);
    } 
    this.o = PlayerState.a;
    this.h.setConfig(this.i);
    this.h.enableHardwareDecode(this.c.v);
  }
  
  private boolean k() {
    return (this.o == PlayerState.d);
  }
  
  private boolean l() {
    return (this.d != null && !this.d.equals(getSetUrl()));
  }
  
  private void m() {
    if (this.h == null || this.c == null) {
      Log.d("BLTxPlayView", "something is null, startTxPlayer discard");
      return;
    } 
    String str = getSetUrl();
    if (TextUtils.isEmpty(str)) {
      Log.e("BLTxPlayView", "error, play url is empty");
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("startTxPlayer: url = ");
    stringBuilder2.append(str);
    Log.c("BLTxPlayView", stringBuilder2.toString());
    int i = this.h.startPlay(str);
    this.d = str;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startPlay result=");
    stringBuilder1.append(i);
    Log.c("BLTxPlayView", stringBuilder1.toString());
  }
  
  private void n() {
    TXVodPlayer tXVodPlayer = this.h;
    if (tXVodPlayer != null) {
      tXVodPlayer.setVodListener(null);
      this.h.stopPlay(true);
      this.h = null;
      this.o = PlayerState.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("releasePlayer ");
      stringBuilder.append(getPlayUrl());
      Log.c("BLTxPlayView", stringBuilder.toString());
    } 
  }
  
  private void o() {
    TXCloudVideoView tXCloudVideoView = this.g;
    if (tXCloudVideoView != null) {
      removeView((View)tXCloudVideoView);
      this.g.onDestroy();
      this.g = null;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("releaseRenderView: ");
      stringBuilder.append(getPlayUrl());
      Log.c("BLTxPlayView", stringBuilder.toString());
    } 
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc 'preloadVideo: url = '
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual getSetUrl : ()Ljava/lang/String;
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_1
    //   27: ldc ', '
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: aload_0
    //   35: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 'BLTxPlayView'
    //   41: aload_1
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield l : Z
    //   54: aload_0
    //   55: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   58: ifnull -> 96
    //   61: aload_0
    //   62: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   65: invokevirtual isPlaying : ()Z
    //   68: ifeq -> 96
    //   71: aload_0
    //   72: invokespecial l : ()Z
    //   75: ifeq -> 85
    //   78: aload_0
    //   79: invokevirtual f : ()V
    //   82: goto -> 96
    //   85: ldc 'BLTxPlayView'
    //   87: ldc 'already start play, so discard preload.'
    //   89: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield g : Lcom/tencent/rtmp/ui/TXCloudVideoView;
    //   100: ifnonnull -> 107
    //   103: aload_0
    //   104: invokespecial i : ()V
    //   107: aload_0
    //   108: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   111: ifnonnull -> 118
    //   114: aload_0
    //   115: invokespecial j : ()V
    //   118: aload_0
    //   119: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   122: iconst_0
    //   123: invokevirtual setAutoPlay : (Z)V
    //   126: aload_0
    //   127: invokespecial m : ()V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Exception table:
    //   from	to	target	type
    //   2	82	133	finally
    //   85	93	133	finally
    //   96	107	133	finally
    //   107	118	133	finally
    //   118	130	133	finally
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    if (this.h == null) {
      Log.c("BLTxPlayView", "setVolume error, mPlayer is null");
      return;
    } 
    super.a(paramFloat1, paramFloat2);
    if (paramFloat1 == 0.0F || paramFloat2 == 0.0F) {
      this.h.setAudioPlayoutVolume(0);
      return;
    } 
    this.h.setAudioPlayoutVolume(100);
    AudioManagerUtils.a().b();
  }
  
  public void a(long paramLong) {
    TXVodPlayer tXVodPlayer = this.h;
    if (tXVodPlayer != null)
      tXVodPlayer.seek((float)(paramLong / 1000L)); 
  }
  
  public void a(VideoPlayConfig paramVideoPlayConfig) {
    if (paramVideoPlayConfig == null)
      return; 
    super.a(paramVideoPlayConfig);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("loadVideoSource ");
    stringBuilder.append(getSetUrl());
    Log.b("BLTxPlayView", stringBuilder.toString());
  }
  
  public void a(boolean paramBoolean) {
    j();
    Log.b("BLTxPlayView", "initVideoViewOptions ");
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial k : ()Z
    //   6: ifeq -> 16
    //   9: aload_0
    //   10: invokevirtual g : ()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore_1
    //   24: aload_1
    //   25: ldc_w 'startPlay setPlayer() '
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: aload_0
    //   34: invokevirtual getSetUrl : ()Ljava/lang/String;
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: ldc ', '
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: aload_0
    //   50: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: ldc 'BLTxPlayView'
    //   56: aload_1
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   63: pop
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield l : Z
    //   69: aload_0
    //   70: getfield g : Lcom/tencent/rtmp/ui/TXCloudVideoView;
    //   73: ifnonnull -> 89
    //   76: ldc 'BLTxPlayView'
    //   78: ldc_w 'startPlay mVideoView = null'
    //   81: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
    //   84: pop
    //   85: aload_0
    //   86: invokespecial i : ()V
    //   89: aload_0
    //   90: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   93: ifnonnull -> 100
    //   96: aload_0
    //   97: invokespecial j : ()V
    //   100: aload_0
    //   101: getfield c : Lcom/blued/android/module/player/media/model/VideoPlayConfig;
    //   104: getfield j : Z
    //   107: ifeq -> 119
    //   110: aload_0
    //   111: fconst_1
    //   112: fconst_1
    //   113: invokevirtual a : (FF)V
    //   116: goto -> 125
    //   119: aload_0
    //   120: fconst_0
    //   121: fconst_0
    //   122: invokevirtual a : (FF)V
    //   125: aload_0
    //   126: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   129: aload_0
    //   130: getfield g : Lcom/tencent/rtmp/ui/TXCloudVideoView;
    //   133: invokevirtual setPlayerView : (Lcom/tencent/rtmp/ui/TXCloudVideoView;)V
    //   136: aload_0
    //   137: getfield h : Lcom/tencent/rtmp/TXVodPlayer;
    //   140: iconst_1
    //   141: invokevirtual setAutoPlay : (Z)V
    //   144: aload_0
    //   145: invokespecial m : ()V
    //   148: aload_0
    //   149: monitorexit
    //   150: return
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	151	finally
    //   16	89	151	finally
    //   89	100	151	finally
    //   100	116	151	finally
    //   119	125	151	finally
    //   125	148	151	finally
  }
  
  public void c() {
    f();
    n();
    o();
    if (this.e != null)
      this.e = null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("release url = ");
    stringBuilder.append(getPlayUrl());
    Log.b("BLTxPlayView", stringBuilder.toString());
    super.c();
  }
  
  public void d() {
    this.l = true;
    if (e()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pause: ");
      stringBuilder.append(getPlayUrl());
      Log.c("BLTxPlayView", stringBuilder.toString());
      this.o = PlayerState.d;
      this.h.pause();
    } else {
      Log.d("BLTxPlayView", "mPlayer == null, so discard pause");
    } 
    AudioManagerUtils.a().a(false);
  }
  
  public boolean e() {
    TXVodPlayer tXVodPlayer = this.h;
    return (tXVodPlayer != null) ? tXVodPlayer.isPlaying() : false;
  }
  
  public void f() {
    if (this.h != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop: ");
      stringBuilder.append(getPlayUrl());
      Log.c("BLTxPlayView", stringBuilder.toString());
      this.o = PlayerState.e;
      this.h.setPlayerView((TXCloudVideoView)null);
      this.h.stopPlay(true);
    } 
  }
  
  public void g() {
    if (k()) {
      this.o = PlayerState.c;
      this.h.resume();
      return;
    } 
    b();
  }
  
  public long getCurrentPosition() {
    TXVodPlayer tXVodPlayer = this.h;
    return (tXVodPlayer != null) ? ((long)tXVodPlayer.getCurrentPlaybackTime() * 1000L) : super.getCurrentPosition();
  }
  
  public long getDuration() {
    TXVodPlayer tXVodPlayer = this.h;
    return (tXVodPlayer != null) ? ((long)tXVodPlayer.getDuration() * 1000L) : super.getDuration();
  }
  
  public void onNetStatus(TXVodPlayer paramTXVodPlayer, Bundle paramBundle) {}
  
  public void onPlayEvent(TXVodPlayer paramTXVodPlayer, int paramInt, Bundle paramBundle) {
    String str;
    if (paramInt != 2005) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("TXVodPlayer onPlayEvent event: ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", ");
      stringBuilder.append(paramBundle.getString("EVT_MSG"));
      str = stringBuilder.toString();
      Log.b("BLTxPlayView", str);
    } else {
      str = "";
    } 
    if (paramInt != 2003) {
      if (paramInt != 2004) {
        if (paramInt != 2007) {
          if (paramInt != 2009) {
            if (paramInt != 2011) {
              if (paramInt != 2013) {
                if (paramInt == 2014 && this.e != null)
                  this.e.c(); 
              } else {
                this.o = PlayerState.b;
              } 
            } else {
              this.k = paramBundle.getInt("EVT_PARAM1");
            } 
          } else {
            int j;
            this.m = paramBundle.getInt("EVT_PARAM1");
            this.n = paramBundle.getInt("EVT_PARAM2");
            int i = this.k;
            if (i == 90 || i == 270) {
              j = 1;
            } else {
              j = 0;
            } 
            if (j) {
              i = this.n;
            } else {
              i = this.m;
            } 
            if (j) {
              j = this.m;
            } else {
              j = this.n;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("width");
            stringBuilder.append(i);
            stringBuilder.append("height ");
            stringBuilder.append(j);
            Log.b("BLTxPlayView", stringBuilder.toString());
            a(i, j, (View)this);
          } 
        } else if (this.e != null) {
          this.e.a();
        } 
      } else {
        this.o = PlayerState.c;
        if (this.e != null)
          this.e.d(); 
      } 
    } else if (this.l && this.h != null) {
      this.l = false;
      this.o = PlayerState.d;
      this.h.pause();
      Log.c("BLTxPlayView", "paused by user request");
    } 
    if (paramInt < 0) {
      Log.e("BLTxPlayView", str);
      TXVodPlayer tXVodPlayer = this.h;
      if (tXVodPlayer != null)
        tXVodPlayer.stopPlay(false); 
      if (this.e != null)
        this.e.b(); 
    } 
  }
  
  public void setMute(boolean paramBoolean) {
    TXVodPlayer tXVodPlayer = this.h;
    if (tXVodPlayer != null)
      tXVodPlayer.setMute(paramBoolean); 
  }
  
  enum PlayerState {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\txplayer\view\BLTxPlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */