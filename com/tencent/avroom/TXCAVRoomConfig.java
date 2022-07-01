package com.tencent.avroom;

import android.graphics.Bitmap;

public class TXCAVRoomConfig {
  public static final int AVROOM_VIDEO_ASPECT_1_1 = 3;
  
  public static final int AVROOM_VIDEO_ASPECT_3_4 = 2;
  
  public static final int AVROOM_VIDEO_ASPECT_9_16 = 1;
  
  private static int LOCAL_RENDER_MODE;
  
  private static int REMOTE_RENDER_MODE;
  
  private int captureFPS = 15;
  
  private boolean enablePureAudioPush = false;
  
  private boolean enableVideoHWAcceleration = true;
  
  private boolean frontCamera = true;
  
  private int homeOrientation = TXCAVRoomConstants.AVROOM_HOME_ORIENTATION_DOWN;
  
  private boolean isHasVideo = false;
  
  private int pauseFlag = 3;
  
  private int pauseFps = 5;
  
  private Bitmap pauseImg = null;
  
  private int videoAspect = 1;
  
  private int videoBitrate = 600;
  
  public TXCAVRoomConfig VideoAspect(int paramInt) {
    this.videoAspect = paramInt;
    return this;
  }
  
  public TXCAVRoomConfig enablePureAudioPush(boolean paramBoolean) {
    this.enablePureAudioPush = paramBoolean;
    return this;
  }
  
  public TXCAVRoomConfig enableVideoHWAcceleration(boolean paramBoolean) {
    this.enableVideoHWAcceleration = paramBoolean;
    return this;
  }
  
  public TXCAVRoomConfig frontCamera(boolean paramBoolean) {
    this.frontCamera = paramBoolean;
    return this;
  }
  
  public int getCaptureVideoFPS() {
    return this.captureFPS;
  }
  
  public int getHomeOrientation() {
    return this.homeOrientation;
  }
  
  public int getLocalRenderMode() {
    return LOCAL_RENDER_MODE;
  }
  
  public int getPauseFlag() {
    return this.pauseFlag;
  }
  
  public int getPauseFps() {
    return this.pauseFps;
  }
  
  public Bitmap getPauseImg() {
    return this.pauseImg;
  }
  
  public int getRemoteRenderMode() {
    return REMOTE_RENDER_MODE;
  }
  
  public int getVideoAspect() {
    return this.videoAspect;
  }
  
  public int getVideoBitrate() {
    return this.videoBitrate;
  }
  
  public TXCAVRoomConfig homeOrientation(int paramInt) {
    this.homeOrientation = paramInt;
    return this;
  }
  
  public boolean isEnablePureAudioPush() {
    return this.enablePureAudioPush;
  }
  
  public boolean isEnableVideoHWAcceleration() {
    return this.enableVideoHWAcceleration;
  }
  
  public boolean isFrontCamera() {
    return this.frontCamera;
  }
  
  public boolean isHasVideo() {
    return this.isHasVideo;
  }
  
  public TXCAVRoomConfig pauseFps(int paramInt) {
    this.pauseFps = paramInt;
    return this;
  }
  
  public TXCAVRoomConfig pauseImg(Bitmap paramBitmap) {
    this.pauseImg = paramBitmap;
    return this;
  }
  
  public TXCAVRoomConfig setCaptureVideoFPS(int paramInt) {
    this.captureFPS = paramInt;
    return this;
  }
  
  public void setHasVideo(boolean paramBoolean) {
    this.isHasVideo = paramBoolean;
  }
  
  public TXCAVRoomConfig setLocalRenderMode(int paramInt) {
    LOCAL_RENDER_MODE = paramInt;
    return this;
  }
  
  public void setPauseFlag(int paramInt) {
    this.pauseFlag = paramInt;
  }
  
  public TXCAVRoomConfig setRemoteRenderMode(int paramInt) {
    REMOTE_RENDER_MODE = paramInt;
    return this;
  }
  
  public TXCAVRoomConfig videoBitrate(int paramInt) {
    this.videoBitrate = paramInt;
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\TXCAVRoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */