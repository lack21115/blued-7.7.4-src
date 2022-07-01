package com.blued.android.module.player.live.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class BaseLiveMediaPlayerManager extends AbsLiveManager {
  private static String h = "BaseLiveMediaPlayerManager";
  
  protected TXLivePlayer b;
  
  protected int c = 1;
  
  protected TXLivePlayConfig d;
  
  protected String e;
  
  protected TXCloudVideoView f;
  
  protected ITXLivePlayListener g = new ITXLivePlayListener(this) {
      public void onNetStatus(Bundle param1Bundle) {}
      
      public void onPlayEvent(int param1Int, Bundle param1Bundle) {
        // Byte code:
        //   0: new java/lang/StringBuilder
        //   3: dup
        //   4: invokespecial <init> : ()V
        //   7: astore #5
        //   9: aload #5
        //   11: ldc 'receive event: '
        //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   16: pop
        //   17: aload #5
        //   19: iload_1
        //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   23: pop
        //   24: aload #5
        //   26: ldc ', '
        //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   31: pop
        //   32: aload #5
        //   34: aload_2
        //   35: ldc 'EVT_MSG'
        //   37: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
        //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   43: pop
        //   44: aload #5
        //   46: invokevirtual toString : ()Ljava/lang/String;
        //   49: astore #5
        //   51: invokestatic k : ()Ljava/lang/String;
        //   54: aload #5
        //   56: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
        //   59: pop
        //   60: iload_1
        //   61: sipush #-2301
        //   64: if_icmpeq -> 326
        //   67: iload_1
        //   68: sipush #2009
        //   71: if_icmpeq -> 229
        //   74: iload_1
        //   75: sipush #2013
        //   78: if_icmpeq -> 196
        //   81: iload_1
        //   82: sipush #2003
        //   85: if_icmpeq -> 162
        //   88: iload_1
        //   89: sipush #2004
        //   92: if_icmpeq -> 137
        //   95: iload_1
        //   96: sipush #2006
        //   99: if_icmpeq -> 326
        //   102: iload_1
        //   103: sipush #2007
        //   106: if_icmpeq -> 112
        //   109: goto -> 357
        //   112: aload_0
        //   113: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   116: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   119: ifnull -> 357
        //   122: aload_0
        //   123: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   126: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   129: invokeinterface a : ()V
        //   134: goto -> 357
        //   137: aload_0
        //   138: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   141: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   144: ifnull -> 357
        //   147: aload_0
        //   148: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   151: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   154: invokeinterface b : ()V
        //   159: goto -> 357
        //   162: invokestatic k : ()Ljava/lang/String;
        //   165: ldc 'PLAY_EVT_RCV_FIRST_I_FRAME'
        //   167: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
        //   170: pop
        //   171: aload_0
        //   172: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   175: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   178: ifnull -> 357
        //   181: aload_0
        //   182: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   185: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   188: invokeinterface c : ()V
        //   193: goto -> 357
        //   196: invokestatic k : ()Ljava/lang/String;
        //   199: ldc 'PLAY_EVT_VOD_PLAY_PREPARED resumeLive'
        //   201: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   204: pop
        //   205: aload_0
        //   206: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   209: getfield b : Lcom/tencent/rtmp/TXLivePlayer;
        //   212: ifnull -> 357
        //   215: aload_0
        //   216: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   219: getfield b : Lcom/tencent/rtmp/TXLivePlayer;
        //   222: invokevirtual resumeLive : ()I
        //   225: pop
        //   226: goto -> 357
        //   229: aload_0
        //   230: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   233: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   236: ifnull -> 357
        //   239: aload_2
        //   240: ldc 'EVT_PARAM1'
        //   242: invokevirtual getInt : (Ljava/lang/String;)I
        //   245: istore_3
        //   246: aload_2
        //   247: ldc 'EVT_PARAM2'
        //   249: invokevirtual getInt : (Ljava/lang/String;)I
        //   252: istore #4
        //   254: aload_0
        //   255: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   258: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   261: iload_3
        //   262: iload #4
        //   264: invokeinterface a : (II)V
        //   269: invokestatic k : ()Ljava/lang/String;
        //   272: astore_2
        //   273: new java/lang/StringBuilder
        //   276: dup
        //   277: invokespecial <init> : ()V
        //   280: astore #5
        //   282: aload #5
        //   284: ldc 'PLAY_EVT_CHANGE_RESOLUTION, sizechange, width ='
        //   286: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   289: pop
        //   290: aload #5
        //   292: iload_3
        //   293: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   296: pop
        //   297: aload #5
        //   299: ldc 'height='
        //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   304: pop
        //   305: aload #5
        //   307: iload #4
        //   309: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   312: pop
        //   313: aload_2
        //   314: aload #5
        //   316: invokevirtual toString : ()Ljava/lang/String;
        //   319: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   322: pop
        //   323: goto -> 357
        //   326: invokestatic k : ()Ljava/lang/String;
        //   329: ldc 'onCompletion'
        //   331: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   334: pop
        //   335: aload_0
        //   336: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   339: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   342: ifnull -> 357
        //   345: aload_0
        //   346: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   349: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   352: invokeinterface e : ()V
        //   357: iload_1
        //   358: ifge -> 383
        //   361: aload_0
        //   362: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   365: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   368: ifnull -> 383
        //   371: aload_0
        //   372: getfield a : Lcom/blued/android/module/player/live/manager/BaseLiveMediaPlayerManager;
        //   375: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   378: invokeinterface d : ()V
        //   383: return
      }
    };
  
  public void a(String paramString, BlLiveView paramBlLiveView) throws Exception {
    String str = h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare videoPath = ");
    stringBuilder.append(paramString);
    Log.c(str, stringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      Log.c(h, "prepare videoPath empty");
      return;
    } 
    if (paramBlLiveView == null) {
      Log.c(h, "surfaceView is null");
      return;
    } 
    if (paramBlLiveView.getChildAt(0) != null && paramBlLiveView.getChildAt(0) instanceof TXCloudVideoView)
      this.f = (TXCloudVideoView)paramBlLiveView.getChildAt(0); 
    this.e = paramString;
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null) {
      TXCloudVideoView tXCloudVideoView = this.f;
      if (tXCloudVideoView != null) {
        tXLivePlayer.setPlayerView(tXCloudVideoView);
        String str1 = h;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("prepare mMediaPlayer.setPlayerView(mBLliveView) return");
        stringBuilder1.append(this.f.getWidth());
        stringBuilder1.append(",");
        stringBuilder1.append(this.f.getHeight());
        Log.c(str1, stringBuilder1.toString());
        return;
      } 
    } 
    if (this.b == null) {
      this.b = new TXLivePlayer(AppInfo.d());
      this.d = new TXLivePlayConfig();
      this.d.setAutoAdjustCacheTime(false);
      this.d.setCacheTime(3.0F);
      this.d.setConnectRetryCount(10);
      this.b.setConfig(this.d);
      this.b.enableHardwareDecode(false);
    } 
    this.b.setPlayerView(this.f);
    if (a(this.e)) {
      this.b.startPlay(this.e, this.c);
      this.b.setPlayListener(this.g);
    } 
  }
  
  public boolean a() {
    return (this.b != null);
  }
  
  protected boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString) || (!paramString.startsWith("http://") && !paramString.startsWith("https://") && !paramString.startsWith("rtmp://") && !paramString.startsWith("/"))) {
      Log.c(h, "url is invalid");
      return false;
    } 
    if (paramString.startsWith("rtmp://")) {
      this.c = 0;
      return true;
    } 
    if ((paramString.startsWith("http://") || paramString.startsWith("https://")) && paramString.contains(".flv")) {
      this.c = 1;
      return true;
    } 
    Log.c(h, "url is invalid");
    return false;
  }
  
  public void b() {
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null && this.f != null)
      try {
        tXLivePlayer.stopPlay(false);
        this.b.setPlayerView(this.f);
        if (a(this.e)) {
          this.b.startPlay(this.e, this.c);
          this.b.setPlayListener(this.g);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void c() {
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null)
      tXLivePlayer.resume(); 
  }
  
  public void d() {
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null)
      tXLivePlayer.pause(); 
  }
  
  public void e() {
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null)
      tXLivePlayer.setMute(false); 
  }
  
  public void f() {
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null)
      tXLivePlayer.setMute(true); 
  }
  
  public void g() {
    TXCloudVideoView tXCloudVideoView = this.f;
    if (tXCloudVideoView != null) {
      tXCloudVideoView.onDestroy();
      this.f = null;
    } 
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null)
      tXLivePlayer.setPlayerView(null); 
    Log.c(h, "releaseWithoutStop");
  }
  
  public void h() {
    TXCloudVideoView tXCloudVideoView = this.f;
    if (tXCloudVideoView != null) {
      tXCloudVideoView.onDestroy();
      this.f = null;
    } 
    TXLivePlayer tXLivePlayer = this.b;
    if (tXLivePlayer != null) {
      tXLivePlayer.setPlayerView(null);
      this.b.setPlayListener(null);
      this.b.stopPlay(true);
    } 
    this.a = null;
    this.b = null;
    Log.c(h, "release");
  }
  
  public void i() {
    if (this.b != null) {
      Log.c(h, "setMediaEmpty");
      this.b.pause();
      this.b.setPlayListener(null);
      this.b.stopPlay(true);
      this.b = null;
    } 
    TXCloudVideoView tXCloudVideoView = this.f;
    if (tXCloudVideoView != null) {
      tXCloudVideoView.onDestroy();
      this.f = null;
    } 
    Log.c(h, "setMediaEmpty");
  }
  
  public void j() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\live\manager\BaseLiveMediaPlayerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */