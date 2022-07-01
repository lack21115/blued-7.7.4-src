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

public class LiveMediaPlayerManagerTX extends AbsLiveManager {
  private static String b = "LiveMediaPlayerManagerTX";
  
  private static int c = 10;
  
  private static String d = "rtmp://";
  
  private static String e = "http://";
  
  private static String f = "https://";
  
  private static String g = ".flv";
  
  private int h = 1;
  
  private String i;
  
  private TXLivePlayer j;
  
  private TXLivePlayConfig k;
  
  private TXCloudVideoView l;
  
  private ITXLivePlayListener m = new ITXLivePlayListener(this) {
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
        //   64: if_icmpeq -> 272
        //   67: iload_1
        //   68: sipush #2009
        //   71: if_icmpeq -> 229
        //   74: iload_1
        //   75: sipush #2013
        //   78: if_icmpeq -> 205
        //   81: iload_1
        //   82: sipush #2003
        //   85: if_icmpeq -> 171
        //   88: iload_1
        //   89: sipush #2004
        //   92: if_icmpeq -> 146
        //   95: iload_1
        //   96: sipush #2006
        //   99: if_icmpeq -> 272
        //   102: iload_1
        //   103: sipush #2007
        //   106: if_icmpeq -> 112
        //   109: goto -> 303
        //   112: invokestatic k : ()Ljava/lang/String;
        //   115: ldc 'onMediaBufferStart'
        //   117: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   120: pop
        //   121: aload_0
        //   122: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   125: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   128: ifnull -> 303
        //   131: aload_0
        //   132: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   135: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   138: invokeinterface a : ()V
        //   143: goto -> 303
        //   146: aload_0
        //   147: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   150: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   153: ifnull -> 303
        //   156: aload_0
        //   157: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   160: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   163: invokeinterface b : ()V
        //   168: goto -> 303
        //   171: invokestatic k : ()Ljava/lang/String;
        //   174: ldc 'PLAY_EVT_RCV_FIRST_I_FRAME'
        //   176: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)I
        //   179: pop
        //   180: aload_0
        //   181: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   184: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   187: ifnull -> 303
        //   190: aload_0
        //   191: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   194: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   197: invokeinterface c : ()V
        //   202: goto -> 303
        //   205: aload_0
        //   206: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   209: invokestatic a : (Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;)Lcom/tencent/rtmp/TXLivePlayer;
        //   212: ifnull -> 303
        //   215: aload_0
        //   216: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   219: invokestatic a : (Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;)Lcom/tencent/rtmp/TXLivePlayer;
        //   222: invokevirtual resumeLive : ()I
        //   225: pop
        //   226: goto -> 303
        //   229: aload_0
        //   230: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   233: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   236: ifnull -> 303
        //   239: aload_2
        //   240: ldc 'EVT_PARAM1'
        //   242: invokevirtual getInt : (Ljava/lang/String;)I
        //   245: istore_3
        //   246: aload_2
        //   247: ldc 'EVT_PARAM2'
        //   249: invokevirtual getInt : (Ljava/lang/String;)I
        //   252: istore #4
        //   254: aload_0
        //   255: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   258: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   261: iload_3
        //   262: iload #4
        //   264: invokeinterface a : (II)V
        //   269: goto -> 303
        //   272: invokestatic k : ()Ljava/lang/String;
        //   275: ldc 'onCompletion'
        //   277: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
        //   280: pop
        //   281: aload_0
        //   282: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   285: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   288: ifnull -> 303
        //   291: aload_0
        //   292: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   295: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   298: invokeinterface e : ()V
        //   303: iload_1
        //   304: ifge -> 329
        //   307: aload_0
        //   308: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   311: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   314: ifnull -> 329
        //   317: aload_0
        //   318: getfield a : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManagerTX;
        //   321: getfield a : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
        //   324: invokeinterface d : ()V
        //   329: return
      }
    };
  
  private boolean a(String paramString) {
    if (TextUtils.isEmpty(paramString) || (!paramString.startsWith("http://") && !paramString.startsWith(f) && !paramString.startsWith(d) && !paramString.startsWith("/"))) {
      Log.c(b, "url is invalide");
      return false;
    } 
    if (paramString.startsWith(d)) {
      this.h = 0;
      return true;
    } 
    if ((paramString.startsWith(e) || paramString.startsWith(f)) && paramString.contains(g)) {
      this.h = 1;
      return true;
    } 
    Log.c(b, "url is invalide");
    return false;
  }
  
  public void a(String paramString, BlLiveView paramBlLiveView) throws Exception {
    String str = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("prepare videoPath = ");
    stringBuilder.append(paramString);
    Log.c(str, stringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      Log.c(b, "prepare videoPath empty");
      return;
    } 
    if (paramBlLiveView == null) {
      Log.c(b, "surfaceView is null");
      return;
    } 
    this.i = paramString;
    if (paramBlLiveView.getChildAt(0) != null && paramBlLiveView.getChildAt(0) instanceof TXCloudVideoView)
      this.l = (TXCloudVideoView)paramBlLiveView.getChildAt(0); 
    if (this.l == null) {
      Log.c(b, "TXCloudVideoView is null");
      return;
    } 
    if (this.j == null) {
      this.j = new TXLivePlayer(AppInfo.d());
      this.k = new TXLivePlayConfig();
      this.k.setConnectRetryCount(c);
      this.j.setConfig(this.k);
      this.j.enableHardwareDecode(false);
    } 
    this.j.setPlayerView(this.l);
    if (a(this.i)) {
      this.j.startPlay(this.i, this.h);
      this.j.setPlayListener(this.m);
    } 
  }
  
  public boolean a() {
    TXLivePlayer tXLivePlayer = this.j;
    return (tXLivePlayer != null && tXLivePlayer.isPlaying());
  }
  
  public void b() {
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer == null || this.l == null) {
      Log.d(b, "can not reconnect, mPlayer or mVideoView is null.");
      return;
    } 
    try {
      tXLivePlayer.stopPlay(false);
      this.j.setPlayerView(this.l);
      if (a(this.i)) {
        this.j.startPlay(this.i, this.h);
        this.j.setPlayListener(this.m);
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void c() {
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer != null)
      tXLivePlayer.resume(); 
  }
  
  public void d() {
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer != null)
      tXLivePlayer.pause(); 
  }
  
  public void e() {
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer != null)
      tXLivePlayer.setMute(false); 
  }
  
  public void f() {
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer != null)
      tXLivePlayer.setMute(true); 
  }
  
  public void g() {
    if (this.j != null) {
      Log.b(b, "releaseWithoutStop");
      this.j.setPlayerView(null);
    } 
  }
  
  public void h() {
    Log.b(b, "release");
    TXLivePlayer tXLivePlayer = this.j;
    if (tXLivePlayer != null) {
      tXLivePlayer.setPlayerView(null);
      this.j.setPlayListener(null);
      this.j.stopPlay(true);
    } 
    this.a = null;
    this.j = null;
  }
  
  public void i() {
    if (this.j != null) {
      Log.c(b, "setMediaEmpty");
      this.j.pause();
      this.j.setPlayerView(null);
      this.j.setPlayListener(null);
      this.j.stopPlay(true);
      this.j = null;
    } 
  }
  
  public void j() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\live\manager\LiveMediaPlayerManagerTX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */