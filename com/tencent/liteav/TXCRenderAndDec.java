package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.w;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.renderer.g;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;

public class TXCRenderAndDec extends a implements b, a.a, g, f {
  public static final String TAG = "TXCRenderAndDec";
  
  private j mConfig = null;
  
  private Context mContext = null;
  
  private int mCustomRenderFrameBufferId = -1;
  
  private a mDecListener = null;
  
  private boolean mEnableDecoderChange = false;
  
  private boolean mEnableLimitHWDecCache = false;
  
  private boolean mEnableRestartDecoder = false;
  
  private boolean mFirstRender = false;
  
  private long mFrameDecErrCnt = 0L;
  
  private boolean mIsRendering = false;
  
  private long mLastRenderCalculateTS = 0L;
  
  private long mLastRenderFrameCount = 0L;
  
  private long mLastReqKeyFrameTS = 0L;
  
  private WeakReference<b> mNotifyListener;
  
  private j mRGBA2YUVFilter = null;
  
  private boolean mRealTime = false;
  
  private WeakReference<b> mRenderAndDecDelegate;
  
  private long mRenderFrameCount = 0L;
  
  private int mRenderMode = 0;
  
  private int mRenderRotation = 0;
  
  private int mStreamType = 0;
  
  private TXCVideoDecoder mVideoDecoder = null;
  
  private b mVideoFrameFormat = b.a;
  
  private u mVideoFrameListener;
  
  private f mVideoRender = null;
  
  public TXCRenderAndDec(Context paramContext) {
    this.mContext = paramContext;
    c.a().a(this.mContext);
  }
  
  private void notifyEvent(int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("EVT_USERID", getID());
    bundle.putInt("EVT_ID", paramInt);
    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null)
      bundle.putCharSequence("EVT_MSG", paramString); 
    bundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    g.a(this.mNotifyListener, paramInt, bundle);
  }
  
  private void requestKeyFrame() {
    long l = TXCTimeUtil.getTimeTick();
    if (l > this.mLastReqKeyFrameTS + 3000L) {
      this.mLastReqKeyFrameTS = l;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("requestKeyFrame: ");
      stringBuilder.append(getID());
      TXCLog.e("TXCRenderAndDec", stringBuilder.toString());
      WeakReference<b> weakReference = this.mRenderAndDecDelegate;
      if (weakReference != null) {
        b b1 = weakReference.get();
        if (b1 != null)
          b1.onRequestKeyFrame(getID(), this.mStreamType); 
      } 
    } 
  }
  
  private void startDecode() {
    f f1 = this.mVideoRender;
    if (f1 != null) {
      SurfaceTexture surfaceTexture = f1.a();
    } else {
      f1 = null;
    } 
    startDecode((SurfaceTexture)f1);
  }
  
  private void startDecode(SurfaceTexture paramSurfaceTexture) {
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null) {
      tXCVideoDecoder.stop();
      tXCVideoDecoder.enableHWDec(this.mConfig.h);
      tXCVideoDecoder.config(this.mConfig.y);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("trtc_ start decode ");
      stringBuilder.append(paramSurfaceTexture);
      stringBuilder.append(", hw: ");
      stringBuilder.append(this.mConfig.h);
      stringBuilder.append(", id ");
      stringBuilder.append(getID());
      stringBuilder.append("_");
      stringBuilder.append(this.mStreamType);
      TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
      if (paramSurfaceTexture != null) {
        tXCVideoDecoder.setup(paramSurfaceTexture, null, null, this.mRealTime ^ true);
        tXCVideoDecoder.setUserId(getID());
        tXCVideoDecoder.start();
        return;
      } 
      if (!this.mConfig.h) {
        tXCVideoDecoder.setup((Surface)null, null, null, this.mRealTime ^ true);
        tXCVideoDecoder.setUserId(getID());
        tXCVideoDecoder.start();
      } 
    } 
  }
  
  public void decVideo(TXSNALPacket paramTXSNALPacket) {}
  
  public void enableDecoderChange(boolean paramBoolean) {
    this.mEnableDecoderChange = paramBoolean;
  }
  
  public void enableLimitDecCache(boolean paramBoolean) {
    this.mEnableLimitHWDecCache = paramBoolean;
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null)
      tXCVideoDecoder.enableLimitDecCache(paramBoolean); 
  }
  
  public void enableRestartDecoder(boolean paramBoolean) {
    this.mEnableRestartDecoder = paramBoolean;
  }
  
  public long getAVNetRecvInterval() {
    return getLongValue(6014, 2);
  }
  
  public long getAVPlayInterval() {
    return getLongValue(6013, 2);
  }
  
  public j getConfig() {
    return this.mConfig;
  }
  
  public int getStreamType() {
    return this.mStreamType;
  }
  
  public long getVideoCacheDuration() {
    return getIntValue(6010, 2);
  }
  
  public long getVideoCacheFrameCount() {
    return getIntValue(6011, 2);
  }
  
  public int getVideoDecCacheFrameCount() {
    return getIntValue(6012, 2);
  }
  
  public int getVideoGop() {
    return getIntValue(7120);
  }
  
  public f getVideoRender() {
    return this.mVideoRender;
  }
  
  public boolean isRendering() {
    return this.mIsRendering;
  }
  
  public void muteVideo(boolean paramBoolean) {
    if (!paramBoolean) {
      f f1 = this.mVideoRender;
      if (f1 != null)
        f1.n(); 
    } 
  }
  
  public void onDecodeFailed(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("video decode failed ");
    stringBuilder.append(paramInt);
    TXCLog.e("TXCRenderAndDec", stringBuilder.toString());
    requestKeyFrame();
    paramInt = this.mStreamType;
    long l = this.mFrameDecErrCnt + 1L;
    this.mFrameDecErrCnt = l;
    setStatusValue(17014, paramInt, Long.valueOf(l));
  }
  
  public void onDecodeFrame(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3) {
    // Byte code:
    //   0: iload #8
    //   2: ifeq -> 27
    //   5: iload #8
    //   7: iconst_1
    //   8: if_icmpeq -> 27
    //   11: iload #8
    //   13: iconst_2
    //   14: if_icmpeq -> 27
    //   17: iload #8
    //   19: istore #9
    //   21: iload #8
    //   23: iconst_3
    //   24: if_icmpne -> 38
    //   27: sipush #360
    //   30: iload #8
    //   32: bipush #90
    //   34: imul
    //   35: isub
    //   36: istore #9
    //   38: aload_0
    //   39: getfield mVideoFrameListener : Lcom/tencent/liteav/u;
    //   42: astore #11
    //   44: aload #11
    //   46: ifnull -> 140
    //   49: aload_1
    //   50: ifnull -> 140
    //   53: aload_0
    //   54: getfield mVideoFrameFormat : Lcom/tencent/liteav/basic/b/b;
    //   57: getstatic com/tencent/liteav/basic/b/b.b : Lcom/tencent/liteav/basic/b/b;
    //   60: if_acmpeq -> 73
    //   63: aload_0
    //   64: getfield mVideoFrameFormat : Lcom/tencent/liteav/basic/b/b;
    //   67: getstatic com/tencent/liteav/basic/b/b.e : Lcom/tencent/liteav/basic/b/b;
    //   70: if_acmpne -> 140
    //   73: aload_0
    //   74: getfield mVideoRender : Lcom/tencent/liteav/renderer/f;
    //   77: ifnull -> 89
    //   80: aload_1
    //   81: invokevirtual clone : ()Lcom/tencent/liteav/basic/structs/TXSVideoFrame;
    //   84: astore #10
    //   86: goto -> 92
    //   89: aload_1
    //   90: astore #10
    //   92: aload #10
    //   94: aload_0
    //   95: getfield mRenderRotation : I
    //   98: iload #9
    //   100: iadd
    //   101: sipush #360
    //   104: irem
    //   105: putfield rotation : I
    //   108: aload_0
    //   109: getfield mVideoFrameFormat : Lcom/tencent/liteav/basic/b/b;
    //   112: getstatic com/tencent/liteav/basic/b/b.e : Lcom/tencent/liteav/basic/b/b;
    //   115: if_acmpne -> 123
    //   118: aload #10
    //   120: invokevirtual loadNV21BufferFromI420Buffer : ()V
    //   123: aload #11
    //   125: aload_0
    //   126: invokevirtual getID : ()Ljava/lang/String;
    //   129: aload_0
    //   130: getfield mStreamType : I
    //   133: aload #10
    //   135: invokeinterface onRenderVideoFrame : (Ljava/lang/String;ILcom/tencent/liteav/basic/structs/TXSVideoFrame;)V
    //   140: aload_0
    //   141: getfield mFirstRender : Z
    //   144: ifne -> 243
    //   147: aload_0
    //   148: iconst_1
    //   149: putfield mFirstRender : Z
    //   152: aload_0
    //   153: invokevirtual getID : ()Ljava/lang/String;
    //   156: sipush #5007
    //   159: ldc2_w -1
    //   162: ldc2_w -1
    //   165: ldc_w ''
    //   168: aload_0
    //   169: getfield mStreamType : I
    //   172: invokestatic a : (Ljava/lang/String;IJJLjava/lang/String;I)V
    //   175: aload_0
    //   176: getfield mVideoRender : Lcom/tencent/liteav/renderer/f;
    //   179: ifnonnull -> 197
    //   182: aload_0
    //   183: invokevirtual getID : ()Ljava/lang/String;
    //   186: ldc_w 40022
    //   189: lconst_0
    //   190: aload_0
    //   191: getfield mStreamType : I
    //   194: invokestatic a : (Ljava/lang/String;IJI)V
    //   197: aload_0
    //   198: getfield mVideoDecoder : Lcom/tencent/liteav/videodecoder/TXCVideoDecoder;
    //   201: ifnull -> 225
    //   204: aload_0
    //   205: invokevirtual getID : ()Ljava/lang/String;
    //   208: ldc_w 40029
    //   211: aload_0
    //   212: getfield mVideoDecoder : Lcom/tencent/liteav/videodecoder/TXCVideoDecoder;
    //   215: invokevirtual GetDecodeFirstFrameTS : ()J
    //   218: aload_0
    //   219: getfield mStreamType : I
    //   222: invokestatic a : (Ljava/lang/String;IJI)V
    //   225: aload_0
    //   226: getfield mStreamType : I
    //   229: iconst_2
    //   230: if_icmpne -> 243
    //   233: aload_0
    //   234: invokevirtual getID : ()Ljava/lang/String;
    //   237: sipush #32004
    //   240: invokestatic a : (Ljava/lang/String;I)V
    //   243: aload_0
    //   244: getfield mVideoRender : Lcom/tencent/liteav/renderer/f;
    //   247: astore #10
    //   249: aload #10
    //   251: ifnull -> 265
    //   254: aload #10
    //   256: aload_1
    //   257: iload_2
    //   258: iload_3
    //   259: iload #9
    //   261: invokevirtual a : (Lcom/tencent/liteav/basic/structs/TXSVideoFrame;III)V
    //   264: return
    //   265: aload_0
    //   266: getfield mLastRenderCalculateTS : J
    //   269: lconst_0
    //   270: lcmp
    //   271: ifne -> 292
    //   274: aload_0
    //   275: invokestatic currentTimeMillis : ()J
    //   278: putfield mLastRenderCalculateTS : J
    //   281: aload_0
    //   282: lconst_0
    //   283: putfield mLastRenderFrameCount : J
    //   286: aload_0
    //   287: lconst_0
    //   288: putfield mRenderFrameCount : J
    //   291: return
    //   292: aload_0
    //   293: aload_0
    //   294: getfield mRenderFrameCount : J
    //   297: lconst_1
    //   298: ladd
    //   299: putfield mRenderFrameCount : J
    //   302: return
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle) {
    if (paramInt == 2106) {
      j j1 = this.mConfig;
      j1.h = false;
      TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
      if (tXCVideoDecoder != null)
        tXCVideoDecoder.restart(j1.h); 
    } else if (paramInt == 2020) {
      TXCLog.e("TXCRenderAndDec", "decoding too many frame(>40) without output! request key frame now.");
      requestKeyFrame();
      return;
    } 
    paramBundle.putInt("EVT_STREAM_TYPE", this.mStreamType);
    g.a(this.mNotifyListener, paramInt, paramBundle);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("play decode when surface texture create hw ");
    stringBuilder.append(this.mConfig.h);
    TXCLog.w("TXCRenderAndDec", stringBuilder.toString());
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null)
      tXCVideoDecoder.setup(paramSurfaceTexture, null, null, this.mRealTime ^ true); 
    if (this.mConfig.h)
      startDecode(paramSurfaceTexture); 
  }
  
  public void onSurfaceTextureDestroy(SurfaceTexture paramSurfaceTexture) {
    try {
      TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
      if (this.mConfig.h && this.mVideoDecoder != null)
        this.mVideoDecoder.stop(); 
      if (this.mCustomRenderFrameBufferId != -1) {
        TXCOpenGlUtils.b(this.mCustomRenderFrameBufferId);
        this.mCustomRenderFrameBufferId = -1;
      } 
      if (this.mRGBA2YUVFilter != null) {
        this.mRGBA2YUVFilter.e();
        this.mRGBA2YUVFilter = null;
      } 
      if (this.mDecListener != null) {
        this.mDecListener.a(paramSurfaceTexture);
        return;
      } 
    } catch (Exception exception) {
      TXCLog.e("TXCRenderAndDec", "onSurfaceTextureDestroy failed.", exception);
    } 
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    u u1 = this.mVideoFrameListener;
    if (u1 == null)
      return; 
    TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
    tXSVideoFrame.width = paramInt2;
    tXSVideoFrame.height = paramInt3;
    tXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
    tXSVideoFrame.rotation = (paramInt4 + this.mRenderRotation) % 360;
    if (this.mVideoFrameFormat == b.f) {
      tXSVideoFrame.textureId = paramInt1;
      tXSVideoFrame.eglContext = TXCOpenGlUtils.e();
      if (this.mCustomRenderFrameBufferId == -1)
        this.mCustomRenderFrameBufferId = TXCOpenGlUtils.d(); 
      TXCOpenGlUtils.a(paramInt1, this.mCustomRenderFrameBufferId);
      GLES20.glBindFramebuffer(36160, this.mCustomRenderFrameBufferId);
      this.mVideoFrameListener.onRenderVideoFrame(getID(), this.mStreamType, tXSVideoFrame);
      TXCOpenGlUtils.d(this.mCustomRenderFrameBufferId);
      return;
    } 
    if (this.mVideoFrameFormat == b.c) {
      tXSVideoFrame.textureId = paramInt1;
      f f1 = this.mVideoRender;
      if (f1 instanceof a)
        tXSVideoFrame.eglContext = ((a)f1).b(); 
      u1.onRenderVideoFrame(getID(), this.mStreamType, tXSVideoFrame);
      return;
    } 
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null && !tXCVideoDecoder.isHardwareDecode())
      return; 
    if (this.mRGBA2YUVFilter == null) {
      if (this.mVideoFrameFormat == b.e) {
        this.mRGBA2YUVFilter = (j)new w(3);
      } else {
        this.mRGBA2YUVFilter = (j)new w(1);
      } 
      this.mRGBA2YUVFilter.a(true);
      if (this.mRGBA2YUVFilter.c()) {
        this.mRGBA2YUVFilter.a(paramInt2, paramInt3);
      } else {
        TXCLog.i("TXCRenderAndDec", "throwVideoFrame->release mVideoFrameFilter");
        this.mRGBA2YUVFilter = null;
      } 
    } 
    if (this.mRGBA2YUVFilter != null) {
      GLES20.glViewport(0, 0, paramInt2, paramInt3);
      this.mRGBA2YUVFilter.a(paramInt2, paramInt3);
      this.mRGBA2YUVFilter.a(paramInt1);
      GLES20.glBindFramebuffer(36160, this.mRGBA2YUVFilter.m());
      u1.onRenderVideoFrame(getID(), this.mStreamType, tXSVideoFrame);
      GLES20.glBindFramebuffer(36160, 0);
    } 
  }
  
  public void onVideoSizeChange(int paramInt1, int paramInt2) {
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.c(paramInt1, paramInt2); 
    Bundle bundle = new Bundle();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Resolution changed to");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    bundle.putCharSequence("EVT_MSG", stringBuilder.toString());
    bundle.putInt("EVT_PARAM1", paramInt1);
    bundle.putInt("EVT_PARAM2", paramInt2);
    bundle.putString("EVT_USERID", getID());
    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    bundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    onNotifyEvent(2009, bundle);
    setStatusValue(5003, this.mStreamType, Integer.valueOf(paramInt1 << 16 | paramInt2));
    String str = getID();
    long l1 = paramInt1;
    long l2 = paramInt2;
    TXCEventRecorderProxy.a(str, 4003, l1, l2, "", this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40002, l1, this.mStreamType);
    TXCKeyPointReportProxy.a(getID(), 40003, l2, this.mStreamType);
  }
  
  public void restartDecoder() {
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null && tXCVideoDecoder.isHevc())
      tXCVideoDecoder.restart(true); 
  }
  
  public void setBlockInterval(int paramInt) {
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.f(paramInt); 
  }
  
  public void setConfig(j paramj) {
    this.mConfig = paramj;
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.b(this.mConfig.d); 
  }
  
  public void setDecListener(a parama) {
    this.mDecListener = parama;
  }
  
  public void setID(String paramString) {
    super.setID(paramString);
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.setID(getID()); 
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null)
      tXCVideoDecoder.setUserId(paramString); 
  }
  
  public void setNotifyListener(b paramb) {
    this.mNotifyListener = new WeakReference<b>(paramb);
  }
  
  public void setRenderAndDecDelegate(b paramb) {
    this.mRenderAndDecDelegate = new WeakReference<b>(paramb);
  }
  
  public void setRenderMirrorType(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRenderMirrorType ");
    stringBuilder.append(paramInt);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.d(paramInt); 
  }
  
  public void setRenderMode(int paramInt) {
    this.mRenderMode = paramInt;
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.c(paramInt); 
  }
  
  public void setRenderRotation(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("vrotation setRenderRotation ");
    stringBuilder.append(paramInt);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    this.mRenderRotation = paramInt;
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.e(paramInt); 
  }
  
  public void setStreamType(int paramInt) {
    this.mStreamType = paramInt;
    f f1 = this.mVideoRender;
    if (f1 != null)
      f1.a(this.mStreamType); 
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null)
      tXCVideoDecoder.setStreamType(this.mStreamType); 
  }
  
  public void setVideoFrameListener(u paramu, b paramb) {
    this.mVideoFrameListener = paramu;
    this.mVideoFrameFormat = paramb;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVideoFrameListener->enter listener: ");
    stringBuilder.append(paramu);
    stringBuilder.append(", format: ");
    stringBuilder.append(paramb);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    f f1 = this.mVideoRender;
    if (f1 != null && f1 instanceof a) {
      if (paramu == null) {
        TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> clean listener.");
        ((a)this.mVideoRender).b(null);
        return;
      } 
      TXCLog.i("TXCRenderAndDec", "setCustomRenderListener-> set listener.");
      ((a)this.mVideoRender).b(this);
    } 
  }
  
  public void setVideoRender(f paramf) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set video render ");
    stringBuilder.append(paramf);
    stringBuilder.append(" id ");
    stringBuilder.append(getID());
    stringBuilder.append(", ");
    stringBuilder.append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    this.mVideoRender = paramf;
    paramf = this.mVideoRender;
    if (paramf == null)
      return; 
    paramf.setID(getID());
    this.mVideoRender.a(this.mStreamType);
    this.mVideoRender.a(this);
    this.mVideoRender.c(this.mRenderMode);
    this.mVideoRender.e(this.mRenderRotation);
    if (this.mVideoFrameListener != null) {
      paramf = this.mVideoRender;
      if (paramf instanceof a)
        ((a)paramf).b(this); 
    } 
    j j1 = this.mConfig;
    if (j1 != null)
      this.mVideoRender.b(j1.d); 
  }
  
  public void start(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start render dec ");
    stringBuilder.append(getID());
    stringBuilder.append(", ");
    stringBuilder.append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    this.mRealTime = paramBoolean;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    f f1 = this.mVideoRender;
    if (f1 != null) {
      f1.a(this);
      this.mVideoRender.e();
      this.mVideoRender.setID(getID());
    } 
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    startDecode();
    this.mIsRendering = true;
  }
  
  public void startVideo() {
    stopVideo();
    this.mRealTime = true;
    this.mFrameDecErrCnt = 0L;
    this.mLastReqKeyFrameTS = 0L;
    f f1 = this.mVideoRender;
    if (f1 != null) {
      f1.a(this);
      this.mVideoRender.e();
      this.mVideoRender.setID(getID());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start video dec ");
    stringBuilder.append(getID());
    stringBuilder.append(", ");
    stringBuilder.append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    this.mVideoDecoder = new TXCVideoDecoder();
    this.mVideoDecoder.setUserId(getID());
    this.mVideoDecoder.setStreamType(this.mStreamType);
    this.mVideoDecoder.setListener(this);
    this.mVideoDecoder.setNotifyListener(this);
    this.mVideoDecoder.enableChange(this.mEnableDecoderChange);
    this.mVideoDecoder.enableRestart(this.mEnableRestartDecoder);
    this.mVideoDecoder.enableLimitDecCache(this.mEnableLimitHWDecCache);
    startDecode();
    this.mIsRendering = true;
  }
  
  public void stop() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stop video render dec ");
    stringBuilder.append(getID());
    stringBuilder.append(", ");
    stringBuilder.append(this.mStreamType);
    TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
    this.mIsRendering = false;
    this.mRealTime = false;
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null) {
      tXCVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    } 
    f f1 = this.mVideoRender;
    if (f1 != null) {
      f1.m();
      this.mVideoRender.a(true);
      this.mVideoRender.a(null);
    } 
  }
  
  public void stopVideo() {
    this.mIsRendering = false;
    if (this.mVideoDecoder != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop video dec ");
      stringBuilder.append(getID());
      stringBuilder.append(", ");
      stringBuilder.append(this.mStreamType);
      TXCLog.i("TXCRenderAndDec", stringBuilder.toString());
      this.mVideoDecoder.setListener(null);
      this.mVideoDecoder.setNotifyListener(null);
      this.mVideoDecoder.stop();
    } 
    f f1 = this.mVideoRender;
    if (f1 != null) {
      f1.m();
      this.mVideoRender.a(false);
      this.mVideoRender.a(null);
    } 
  }
  
  public void updateLoadInfo() {
    TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
    if (tXCVideoDecoder != null) {
      long l;
      int i = this.mStreamType;
      if (tXCVideoDecoder.isHardwareDecode() == true) {
        l = 1L;
      } else {
        l = 0L;
      } 
      setStatusValue(5002, i, Long.valueOf(l));
    } 
    f f1 = this.mVideoRender;
    if (f1 != null) {
      f1.o();
      return;
    } 
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.mLastRenderCalculateTS;
    if (l2 >= 1000L) {
      long l = this.mRenderFrameCount;
      double d = (l - this.mLastRenderFrameCount) * 1000.0D / l2;
      this.mLastRenderFrameCount = l;
      this.mLastRenderCalculateTS = l1;
      setStatusValue(6002, this.mStreamType, Double.valueOf(d));
    } 
  }
  
  public static interface a {
    void a(SurfaceTexture param1SurfaceTexture);
  }
  
  public static interface b {
    void onRequestKeyFrame(String param1String, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\TXCRenderAndDec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */