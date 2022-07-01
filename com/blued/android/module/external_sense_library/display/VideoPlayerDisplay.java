package com.blued.android.module.external_sense_library.display;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.SensorEvent;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.Constants;
import com.blued.android.module.external_sense_library.encoder.MediaVideoEncoder;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STBeautifyNative;
import com.sensetime.stmobile.STMobileFaceAttributeNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileObjectTrackNative;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.STMobileStreamFilterNative;
import com.sensetime.stmobile.model.STFaceAttribute;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STMobile106;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoPlayerDisplay extends BaseDisplay implements GLSurfaceView.Renderer {
  private static final int MESSAGE_ADD_SUB_MODEL = 1001;
  
  private static final int MESSAGE_REMOVE_SUB_MODEL = 1002;
  
  private boolean DEBUG = false;
  
  private String TAG = "VideoPlayerDisplay";
  
  private float[] mBeautifyParams = new float[] { 
      0.36F, 0.74F, 0.02F, 0.13F, 0.11F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  private int[] mBeautifyTextureId;
  
  private long mBodyAction = 0L;
  
  private Context mContext;
  
  private int mCount = 0;
  
  private float mCurrentFilterStrength = 0.65F;
  
  private String mCurrentFilterStyle;
  
  private String mCurrentSticker;
  
  private long mCurrentTime = 0L;
  
  private int mCustomEvent = 0;
  
  private long mDetectConfig = 0L;
  
  private String mFaceAttribute;
  
  private long mFaceAttributeCost = 0L;
  
  private boolean[] mFaceExpressionResult;
  
  private float mFilterStrength = 0.65F;
  
  private String mFilterStyle;
  
  private int[] mFilterTextureOutId;
  
  private float mFps;
  
  private int mFrameCost = 0;
  
  private int mFrameCount = 0;
  
  private STGLRender mGLRender;
  
  private GLSurfaceView mGlSurfaceView;
  
  private long mHandAction = 0L;
  
  private Handler mHandler;
  
  private STHumanAction mHumanActionBeautyOutput = new STHumanAction();
  
  private int mHumanActionCreateConfig = 131568;
  
  private Object mHumanActionHandleLock = new Object();
  
  private int mImageHeight;
  
  private int mImageWidth;
  
  private Rect mIndexRect = new Rect();
  
  private boolean mIsCreateHumanActionHandleSucceeded = false;
  
  private boolean mIsFirstCount = true;
  
  private boolean mIsFirstPlaying = true;
  
  private boolean mIsObjectTracking = false;
  
  private boolean mIsPaused = false;
  
  private MediaPlayer mMediaPlayer;
  
  private boolean mNeedBeautify = false;
  
  private boolean mNeedFilter = false;
  
  private boolean mNeedObject = false;
  
  private boolean mNeedPause = true;
  
  private boolean mNeedResetEglContext = false;
  
  private boolean mNeedSave = false;
  
  private boolean mNeedSetObjectTarget = false;
  
  private boolean mNeedShowRect = true;
  
  private boolean mNeedSticker = false;
  
  private long mObjectCost = 0L;
  
  private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() {
      public void onFrameAvailable(SurfaceTexture param1SurfaceTexture) {
        VideoPlayerDisplay.this.mGlSurfaceView.requestRender();
        if (VideoPlayerDisplay.this.mNeedPause)
          VideoPlayerDisplay.this.mMediaPlayer.pause(); 
      }
    };
  
  private ByteBuffer mRGBABuffer;
  
  private long mRotateCost = 0L;
  
  private STMobileFaceAttributeNative mSTFaceAttributeNative = new STMobileFaceAttributeNative();
  
  private STMobileHumanActionNative mSTHumanActionNative = new STMobileHumanActionNative();
  
  private STMobileObjectTrackNative mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
  
  private STMobileStreamFilterNative mSTMobileStreamFilterNative = new STMobileStreamFilterNative();
  
  private int mScreenIndexRectWidth = 0;
  
  private SensorEvent mSensorEvent;
  
  private boolean mShowOriginal = false;
  
  private STBeautifyNative mStBeautifyNative = new STBeautifyNative();
  
  private final float[] mStMatrix = new float[16];
  
  private STMobileStickerNative mStStickerNative = new STMobileStickerNative();
  
  private long mStartTime;
  
  private Handler mSubModelsManagerHandler;
  
  private HandlerThread mSubModelsManagerThread;
  
  private int mSurfaceHeight;
  
  private int mSurfaceWidth;
  
  private Rect mTargetRect = new Rect();
  
  private FloatBuffer mTextureBuffer;
  
  protected int mTextureId = -1;
  
  private int[] mTextureOutId;
  
  private Timer mTimer = new Timer();
  
  private TimerTask mTimerTask;
  
  private MediaVideoEncoder mVideoEncoder;
  
  private int[] mVideoEncoderTexture;
  
  private String mVideoPath = null;
  
  private SurfaceTexture mVideoTexture;
  
  private MediaMetadataRetriever retr;
  
  private String rotation;
  
  public VideoPlayerDisplay(Context paramContext, GLSurfaceView paramGLSurfaceView, String paramString) {
    this.mGlSurfaceView = paramGLSurfaceView;
    this.mContext = paramContext;
    this.mVideoPath = paramString;
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
    this.mTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureBuffer.put(TextureRotationUtil.b).position(0);
    this.mGLRender = new STGLRender();
    this.DEBUG = AppInfo.m();
    initHumanAction();
    initObjectTrack();
    if (this.DEBUG)
      initFaceAttribute(); 
    this.mSubModelsManagerThread = new HandlerThread("SubModelManagerThread");
    this.mSubModelsManagerThread.start();
    this.mSubModelsManagerHandler = new Handler(this.mSubModelsManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!VideoPlayerDisplay.this.mIsPaused && VideoPlayerDisplay.this.mIsCreateHumanActionHandleSucceeded) {
            int i = param1Message.what;
            if (i != 1001) {
              if (i != 1002)
                return; 
              i = ((Integer)param1Message.obj).intValue();
              if (i != 0) {
                VideoPlayerDisplay.this.removeSubModel(i);
                return;
              } 
            } else {
              String str = (String)param1Message.obj;
              if (str != null)
                VideoPlayerDisplay.this.addSubModel(str); 
            } 
          } 
        }
      };
  }
  
  private void addSubModel(String paramString) {
    synchronized (this.mHumanActionHandleLock) {
      int i = this.mSTHumanActionNative.addSubModelFromAssetFile(paramString, this.mContext.getAssets());
      LogUtils.c(this.TAG, "add sub model result: %d", new Object[] { Integer.valueOf(i) });
      if (i == 0)
        if (paramString.equals("M_SenseME_Body_Fourteen_1.2.0.model")) {
          this.mDetectConfig |= 0x8000000L;
          this.mSTHumanActionNative.setParam(9, 3.0F);
        } else if (paramString.equals("M_SenseME_Face_Extra_5.23.0.model")) {
          this.mDetectConfig |= 0x1000000L;
        } else if (paramString.equals("M_SenseME_Iris_2.0.0.model")) {
          this.mDetectConfig |= 0x6000000L;
        } else if (paramString.equals("M_SenseME_Hand_5.4.0.model")) {
          this.mDetectConfig |= 0x410000FEFF00L;
        }  
      return;
    } 
  }
  
  private void adjustViewPort(int paramInt1, int paramInt2) {
    this.mSurfaceHeight = paramInt2;
    this.mSurfaceWidth = paramInt1;
    GLES20.glViewport(0, 0, this.mSurfaceWidth, this.mSurfaceHeight);
    this.mGLRender.calculateVertexBuffer(this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
  }
  
  private void confirmWidthAndHeight(String paramString) {
    int i = Integer.valueOf(paramString).intValue();
    if (i != 0) {
      if (i != 90) {
        if (i != 180) {
          if (i != 270)
            return; 
          this.mImageWidth = Integer.parseInt(this.retr.extractMetadata(19));
          this.mImageHeight = Integer.parseInt(this.retr.extractMetadata(18));
          this.mGLRender.adjustVideoTextureBuffer(270, true, false);
          return;
        } 
        this.mImageHeight = Integer.parseInt(this.retr.extractMetadata(19));
        this.mImageWidth = Integer.parseInt(this.retr.extractMetadata(18));
        this.mGLRender.adjustVideoTextureBuffer(0, true, false);
        return;
      } 
      this.mImageWidth = Integer.parseInt(this.retr.extractMetadata(19));
      this.mImageHeight = Integer.parseInt(this.retr.extractMetadata(18));
      this.mGLRender.adjustVideoTextureBuffer(90, true, false);
      return;
    } 
    this.mImageHeight = Integer.parseInt(this.retr.extractMetadata(19));
    this.mImageWidth = Integer.parseInt(this.retr.extractMetadata(18));
    this.mGLRender.adjustVideoTextureBuffer(180, true, false);
  }
  
  private void deleteCameraPreviewTexture() {
    int i = this.mTextureId;
    if (i != -1)
      GLES20.glDeleteTextures(1, new int[] { i }, 0); 
    this.mTextureId = -1;
  }
  
  private void deleteInternalTextures() {
    int[] arrayOfInt = this.mBeautifyTextureId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mBeautifyTextureId = null;
    } 
    arrayOfInt = this.mTextureOutId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mTextureOutId = null;
    } 
    arrayOfInt = this.mFilterTextureOutId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mFilterTextureOutId = null;
    } 
    arrayOfInt = this.mVideoEncoderTexture;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mVideoEncoderTexture = null;
    } 
  }
  
  private void faceAttributeDetect(byte[] paramArrayOfbyte, STHumanAction paramSTHumanAction) {
    if (paramSTHumanAction != null && paramArrayOfbyte != null && paramArrayOfbyte.length == this.mImageHeight * this.mImageWidth * 4) {
      STMobile106[] arrayOfSTMobile106 = paramSTHumanAction.getMobileFaces();
      if (arrayOfSTMobile106 != null && arrayOfSTMobile106.length != 0) {
        STFaceAttribute[] arrayOfSTFaceAttribute = new STFaceAttribute[arrayOfSTMobile106.length];
        long l = System.currentTimeMillis();
        int i = this.mSTFaceAttributeNative.detect(paramArrayOfbyte, 6, this.mImageWidth, this.mImageHeight, arrayOfSTMobile106, arrayOfSTFaceAttribute);
        LogUtils.c(this.TAG, "attribute cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        this.mFaceAttributeCost = System.currentTimeMillis() - l;
        if (i == 0) {
          if ((arrayOfSTFaceAttribute[0]).attribute_count > 0) {
            this.mFaceAttribute = STFaceAttribute.getFaceAttributeString(arrayOfSTFaceAttribute[0]);
            return;
          } 
          this.mFaceAttribute = "null";
          return;
        } 
      } else {
        this.mFaceAttribute = null;
        this.mFaceAttributeCost = 0L;
      } 
    } 
  }
  
  private int getCurrentOrientation() {
    int k = Accelerometer.c();
    int j = k - 1;
    int i = j;
    if (j < 0)
      i = k ^ 0x3; 
    return i;
  }
  
  private void initBeauty() {
    int i = this.mStBeautifyNative.createInstance();
    String str = this.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("the result is for initBeautify ");
    stringBuilder.append(i);
    LogUtils.c(str, stringBuilder.toString(), new Object[0]);
    if (i == 0) {
      this.mStBeautifyNative.setParam(1, this.mBeautifyParams[0]);
      this.mStBeautifyNative.setParam(3, this.mBeautifyParams[1]);
      this.mStBeautifyNative.setParam(4, this.mBeautifyParams[2]);
      this.mStBeautifyNative.setParam(5, this.mBeautifyParams[3]);
      this.mStBeautifyNative.setParam(6, this.mBeautifyParams[4]);
      this.mStBeautifyNative.setParam(7, this.mBeautifyParams[5]);
      this.mStBeautifyNative.setParam(8, this.mBeautifyParams[6]);
      this.mStBeautifyNative.setParam(9, this.mBeautifyParams[7]);
      this.mStBeautifyNative.setParam(10, this.mBeautifyParams[8]);
      this.mStBeautifyNative.setParam(11, this.mBeautifyParams[9]);
      this.mStBeautifyNative.setParam(12, this.mBeautifyParams[26]);
      this.mStBeautifyNative.setParam(20, this.mBeautifyParams[10]);
      this.mStBeautifyNative.setParam(21, this.mBeautifyParams[11]);
      this.mStBeautifyNative.setParam(22, this.mBeautifyParams[12]);
      this.mStBeautifyNative.setParam(23, this.mBeautifyParams[13]);
      this.mStBeautifyNative.setParam(24, this.mBeautifyParams[14]);
      this.mStBeautifyNative.setParam(25, this.mBeautifyParams[15]);
      this.mStBeautifyNative.setParam(26, this.mBeautifyParams[16]);
      this.mStBeautifyNative.setParam(27, this.mBeautifyParams[17]);
      this.mStBeautifyNative.setParam(28, this.mBeautifyParams[18]);
      this.mStBeautifyNative.setParam(29, this.mBeautifyParams[19]);
      this.mStBeautifyNative.setParam(30, this.mBeautifyParams[20]);
      this.mStBeautifyNative.setParam(31, this.mBeautifyParams[21]);
      this.mStBeautifyNative.setParam(32, this.mBeautifyParams[22]);
      this.mStBeautifyNative.setParam(33, this.mBeautifyParams[23]);
      this.mStBeautifyNative.setParam(34, this.mBeautifyParams[24]);
      this.mStBeautifyNative.setParam(35, this.mBeautifyParams[25]);
      this.mStBeautifyNative.setParam(2, 0.0F);
    } 
  }
  
  private void initFaceAttribute() {
    int i = this.mSTFaceAttributeNative.createInstanceFromAssetFile("M_SenseME_Attribute_1.0.1.model", this.mContext.getAssets());
    LogUtils.c(this.TAG, "the result for createInstance for faceAttribute is %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void initFilter() {
    this.mSTMobileStreamFilterNative.createInstance();
    this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle);
    this.mCurrentFilterStrength = this.mFilterStrength;
    this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
  }
  
  private void initHumanAction() {
    (new Thread(new Runnable() {
          public void run() {
            synchronized (VideoPlayerDisplay.this.mHumanActionHandleLock) {
              int i = VideoPlayerDisplay.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), VideoPlayerDisplay.this.mHumanActionCreateConfig, VideoPlayerDisplay.this.mContext.getAssets());
              LogUtils.c(VideoPlayerDisplay.this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                i = VideoPlayerDisplay.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", VideoPlayerDisplay.this.mContext.getAssets());
                LogUtils.c(VideoPlayerDisplay.this.TAG, "add hand model result: %d", new Object[] { Integer.valueOf(i) });
                i = VideoPlayerDisplay.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Segment_1.5.0.model", VideoPlayerDisplay.this.mContext.getAssets());
                LogUtils.c(VideoPlayerDisplay.this.TAG, "add figure segment model result: %d", new Object[] { Integer.valueOf(i) });
                VideoPlayerDisplay.access$102(VideoPlayerDisplay.this, true);
                VideoPlayerDisplay.this.mSTHumanActionNative.setParam(2, 0.35F);
                i = VideoPlayerDisplay.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Iris_2.0.0.model", VideoPlayerDisplay.this.mContext.getAssets());
                LogUtils.c(VideoPlayerDisplay.this.TAG, "add eyeball contour model result: %d", new Object[] { Integer.valueOf(i) });
                i = VideoPlayerDisplay.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Avatar_Help_2.0.0.model", VideoPlayerDisplay.this.mContext.getAssets());
                LogUtils.c(VideoPlayerDisplay.this.TAG, "add avatar help model result: %d", new Object[] { Integer.valueOf(i) });
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void initObjectTrack() {
    this.mSTMobileObjectTrackNative.createInstance();
  }
  
  private void initSticker() {
    int i = this.mStStickerNative.createInstance(this.mContext);
    if (this.mNeedSticker)
      this.mStStickerNative.changeSticker(this.mCurrentSticker); 
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction());
    LogUtils.c(this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
    this.mStStickerNative.loadAvatarModelFromAssetFile("M_SenseME_Avatar_Core_2.0.0.model", this.mContext.getAssets());
  }
  
  private void removeSubModel(int paramInt) {
    synchronized (this.mHumanActionHandleLock) {
      int i = this.mSTHumanActionNative.removeSubModelByConfig(paramInt);
      LogUtils.c(this.TAG, "remove sub model result: %d", new Object[] { Integer.valueOf(i) });
      if (paramInt == 4096) {
        this.mDetectConfig &= 0xFFFFFFFFF7FFFFFFL;
      } else if (paramInt == 512) {
        this.mDetectConfig &= 0xFFFFFFFFFEFFFFFFL;
      } else if (paramInt == 2048) {
        this.mDetectConfig &= 0xFFFFFFFFF9FFFFFFL;
      } else if (paramInt == 128) {
        this.mDetectConfig &= 0xFFFFBEFFFF0100FFL;
      } 
      return;
    } 
  }
  
  private void savePicture(int paramInt) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(this.mImageHeight * this.mImageWidth * 4);
    this.mGLRender.saveTextureToFrameBuffer(paramInt, byteBuffer);
    byteBuffer.position(0);
    Message message = Message.obtain(this.mHandler);
    message.what = 150;
    message.obj = byteBuffer;
    Bundle bundle = new Bundle();
    bundle.putInt("imageWidth", this.mImageWidth);
    bundle.putInt("imageHeight", this.mImageHeight);
    message.setData(bundle);
    message.sendToTarget();
  }
  
  private void setHumanActionDetectConfig(boolean paramBoolean, long paramLong) {
    if (!this.mNeedSticker || this.mCurrentSticker == null)
      paramLong = 0L; 
    if (paramBoolean) {
      this.mDetectConfig = paramLong | 0x1L;
      return;
    } 
    this.mDetectConfig = paramLong;
  }
  
  private void setUpVideo() {
    if (this.mTextureId == -1) {
      this.mTextureId = OpenGLUtils.a();
      this.mVideoTexture = new SurfaceTexture(this.mTextureId);
      this.mVideoTexture.setOnFrameAvailableListener(this.mOnFrameAvailableListener);
    } 
    try {
      this.retr = new MediaMetadataRetriever();
      this.retr.setDataSource(this.mVideoPath);
      this.rotation = this.retr.extractMetadata(24);
      confirmWidthAndHeight(this.rotation);
      prepareVideoAndStart();
      return;
    } catch (Exception exception) {
      String str = this.TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setUpVideo: ");
      stringBuilder.append(exception.getMessage());
      Log.e(str, stringBuilder.toString());
      return;
    } 
  }
  
  public void StartPlayVideo() {
    if (this.mMediaPlayer != null) {
      this.mNeedPause = false;
      this.mTimerTask = new TimerTask() {
          public void run() {
            if (VideoPlayerDisplay.this.mMediaPlayer != null) {
              int i = VideoPlayerDisplay.this.mMediaPlayer.getCurrentPosition();
              if (VideoPlayerDisplay.this.mMediaPlayer.getDuration() > 0) {
                Message message = VideoPlayerDisplay.this.mHandler.obtainMessage(171);
                message.arg1 = i;
                VideoPlayerDisplay.this.mHandler.sendMessage(message);
              } 
            } 
          }
        };
      this.mMediaPlayer.start();
      this.mTimer.schedule(this.mTimerTask, 0L, 500L);
    } 
  }
  
  public void StopPlayViedo() {
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null)
      try {
        mediaPlayer.pause();
        this.mMediaPlayer.seekTo(0);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void addSubModelByName(String paramString) {
    Message message = this.mSubModelsManagerHandler.obtainMessage(1001);
    message.obj = paramString;
    this.mSubModelsManagerHandler.sendMessage(message);
  }
  
  public void changeCustomEvent() {
    this.mCustomEvent = 3;
  }
  
  protected void deleteTextures() {
    LogUtils.c(this.TAG, "delete textures", new Object[0]);
    deleteCameraPreviewTexture();
    deleteInternalTextures();
  }
  
  public void disableObjectTracking() {
    this.mIsObjectTracking = false;
  }
  
  public void enableBeautify(boolean paramBoolean) {
    this.mNeedBeautify = paramBoolean;
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction());
    this.mNeedResetEglContext = true;
  }
  
  public void enableFilter(boolean paramBoolean) {
    this.mNeedFilter = paramBoolean;
    this.mNeedResetEglContext = true;
  }
  
  public void enableObject(boolean paramBoolean) {
    this.mNeedObject = paramBoolean;
    if (this.mNeedObject)
      resetIndexRect(); 
  }
  
  public void enableSticker(boolean paramBoolean) {
    this.mNeedSticker = paramBoolean;
    if (!paramBoolean)
      setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction()); 
    this.mNeedResetEglContext = true;
  }
  
  public float[] getBeautyParams() {
    float[] arrayOfFloat = new float[6];
    int i = 0;
    while (true) {
      float[] arrayOfFloat1 = this.mBeautifyParams;
      if (i < arrayOfFloat1.length) {
        arrayOfFloat[i] = arrayOfFloat1[i];
        i++;
        continue;
      } 
      return arrayOfFloat;
    } 
  }
  
  public long getBodyActionInfo() {
    return this.mBodyAction;
  }
  
  public String getFaceAttributeString() {
    return this.mFaceAttribute;
  }
  
  public boolean[] getFaceExpressionInfo() {
    return this.mFaceExpressionResult;
  }
  
  public float getFpsInfo() {
    return Math.round(this.mFps * 10.0F) / 10.0F;
  }
  
  public int getFrameCost() {
    return this.mFrameCost;
  }
  
  public long getHandActionInfo() {
    return this.mHandAction;
  }
  
  public Rect getIndexRect() {
    return this.mIndexRect;
  }
  
  public int getPreviewHeight() {
    return this.mImageHeight;
  }
  
  public int getPreviewWidth() {
    return this.mImageWidth;
  }
  
  public long getStickerTriggerAction() {
    return this.mStStickerNative.getTriggerAction();
  }
  
  public void onDestroy() {
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null) {
      mediaPlayer.stop();
      this.mMediaPlayer = null;
    } 
    synchronized (this.mHumanActionHandleLock) {
      this.mSTHumanActionNative.destroyInstance();
      this.mSTFaceAttributeNative.destroyInstance();
      this.mSTMobileObjectTrackNative.destroyInstance();
      return;
    } 
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    // Byte code:
    //   0: aload_0
    //   1: getfield TAG : Ljava/lang/String;
    //   4: ldc_w 'onDrawFrame'
    //   7: iconst_0
    //   8: anewarray java/lang/Object
    //   11: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   14: pop
    //   15: aload_0
    //   16: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   19: ifnonnull -> 40
    //   22: aload_0
    //   23: aload_0
    //   24: getfield mImageHeight : I
    //   27: aload_0
    //   28: getfield mImageWidth : I
    //   31: imul
    //   32: iconst_4
    //   33: imul
    //   34: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   37: putfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   40: aload_0
    //   41: getfield mBeautifyTextureId : [I
    //   44: ifnonnull -> 72
    //   47: aload_0
    //   48: iconst_1
    //   49: newarray int
    //   51: putfield mBeautifyTextureId : [I
    //   54: aload_0
    //   55: getfield mImageWidth : I
    //   58: aload_0
    //   59: getfield mImageHeight : I
    //   62: aload_0
    //   63: getfield mBeautifyTextureId : [I
    //   66: sipush #3553
    //   69: invokestatic a : (II[II)V
    //   72: aload_0
    //   73: getfield mTextureOutId : [I
    //   76: ifnonnull -> 104
    //   79: aload_0
    //   80: iconst_1
    //   81: newarray int
    //   83: putfield mTextureOutId : [I
    //   86: aload_0
    //   87: getfield mImageWidth : I
    //   90: aload_0
    //   91: getfield mImageHeight : I
    //   94: aload_0
    //   95: getfield mTextureOutId : [I
    //   98: sipush #3553
    //   101: invokestatic a : (II[II)V
    //   104: aload_0
    //   105: getfield mVideoEncoderTexture : [I
    //   108: ifnonnull -> 118
    //   111: aload_0
    //   112: iconst_1
    //   113: newarray int
    //   115: putfield mVideoEncoderTexture : [I
    //   118: aload_0
    //   119: getfield mVideoTexture : Landroid/graphics/SurfaceTexture;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull -> 2102
    //   127: aload_0
    //   128: getfield mIsPaused : Z
    //   131: ifne -> 2102
    //   134: aload_1
    //   135: invokevirtual updateTexImage : ()V
    //   138: aload_0
    //   139: invokestatic currentTimeMillis : ()J
    //   142: putfield mStartTime : J
    //   145: fconst_0
    //   146: fconst_0
    //   147: fconst_0
    //   148: fconst_0
    //   149: invokestatic glClearColor : (FFFF)V
    //   152: sipush #16640
    //   155: invokestatic glClear : (I)V
    //   158: aload_0
    //   159: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   162: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   165: pop
    //   166: invokestatic currentTimeMillis : ()J
    //   169: lstore #8
    //   171: aload_0
    //   172: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   175: aload_0
    //   176: getfield mTextureId : I
    //   179: aload_0
    //   180: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   183: invokevirtual preProcess : (ILjava/nio/ByteBuffer;)I
    //   186: istore #5
    //   188: aload_0
    //   189: getfield TAG : Ljava/lang/String;
    //   192: ldc_w 'preprocess cost time: %d'
    //   195: iconst_1
    //   196: anewarray java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: invokestatic currentTimeMillis : ()J
    //   204: lload #8
    //   206: lsub
    //   207: invokestatic valueOf : (J)Ljava/lang/Long;
    //   210: aastore
    //   211: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   214: pop
    //   215: aload_0
    //   216: getfield mShowOriginal : Z
    //   219: ifne -> 1814
    //   222: aload_0
    //   223: getfield mNeedObject : Z
    //   226: istore #12
    //   228: iload #12
    //   230: ifeq -> 587
    //   233: aload_0
    //   234: getfield mNeedSetObjectTarget : Z
    //   237: ifeq -> 344
    //   240: invokestatic currentTimeMillis : ()J
    //   243: lstore #8
    //   245: new com/sensetime/stmobile/model/STRect
    //   248: dup
    //   249: aload_0
    //   250: getfield mTargetRect : Landroid/graphics/Rect;
    //   253: getfield left : I
    //   256: aload_0
    //   257: getfield mTargetRect : Landroid/graphics/Rect;
    //   260: getfield top : I
    //   263: aload_0
    //   264: getfield mTargetRect : Landroid/graphics/Rect;
    //   267: getfield right : I
    //   270: aload_0
    //   271: getfield mTargetRect : Landroid/graphics/Rect;
    //   274: getfield bottom : I
    //   277: invokespecial <init> : (IIII)V
    //   280: astore_1
    //   281: aload_0
    //   282: getfield mSTMobileObjectTrackNative : Lcom/sensetime/stmobile/STMobileObjectTrackNative;
    //   285: aload_0
    //   286: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   289: invokevirtual array : ()[B
    //   292: bipush #6
    //   294: aload_0
    //   295: getfield mImageWidth : I
    //   298: aload_0
    //   299: getfield mImageHeight : I
    //   302: aload_1
    //   303: invokevirtual setTarget : ([BIIILcom/sensetime/stmobile/model/STRect;)I
    //   306: pop
    //   307: aload_0
    //   308: getfield TAG : Ljava/lang/String;
    //   311: ldc_w 'setTarget cost time: %d'
    //   314: iconst_1
    //   315: anewarray java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: invokestatic currentTimeMillis : ()J
    //   323: lload #8
    //   325: lsub
    //   326: invokestatic valueOf : (J)Ljava/lang/Long;
    //   329: aastore
    //   330: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   333: pop
    //   334: aload_0
    //   335: iconst_0
    //   336: putfield mNeedSetObjectTarget : Z
    //   339: aload_0
    //   340: iconst_1
    //   341: putfield mIsObjectTracking : Z
    //   344: new android/graphics/Rect
    //   347: dup
    //   348: iconst_0
    //   349: iconst_0
    //   350: iconst_0
    //   351: iconst_0
    //   352: invokespecial <init> : (IIII)V
    //   355: astore #13
    //   357: aload_0
    //   358: getfield mIsObjectTracking : Z
    //   361: ifeq -> 516
    //   364: invokestatic currentTimeMillis : ()J
    //   367: lstore #8
    //   369: iconst_1
    //   370: newarray float
    //   372: astore #14
    //   374: aload_0
    //   375: getfield mSTMobileObjectTrackNative : Lcom/sensetime/stmobile/STMobileObjectTrackNative;
    //   378: aload_0
    //   379: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   382: invokevirtual array : ()[B
    //   385: bipush #6
    //   387: aload_0
    //   388: getfield mImageWidth : I
    //   391: aload_0
    //   392: getfield mImageHeight : I
    //   395: aload #14
    //   397: invokevirtual objectTrack : ([BIII[F)Lcom/sensetime/stmobile/model/STRect;
    //   400: astore #15
    //   402: aload_0
    //   403: getfield TAG : Ljava/lang/String;
    //   406: ldc_w 'objectTrack cost time: %d'
    //   409: iconst_1
    //   410: anewarray java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: invokestatic currentTimeMillis : ()J
    //   418: lload #8
    //   420: lsub
    //   421: invokestatic valueOf : (J)Ljava/lang/Long;
    //   424: aastore
    //   425: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   428: pop
    //   429: aload_0
    //   430: invokestatic currentTimeMillis : ()J
    //   433: lload #8
    //   435: lsub
    //   436: putfield mObjectCost : J
    //   439: aload #13
    //   441: astore_1
    //   442: aload #15
    //   444: ifnull -> 481
    //   447: aload #13
    //   449: astore_1
    //   450: aload #14
    //   452: arraylength
    //   453: ifle -> 481
    //   456: aload #15
    //   458: invokevirtual getRect : ()Landroid/graphics/Rect;
    //   461: aload_0
    //   462: getfield mSurfaceWidth : I
    //   465: aload_0
    //   466: getfield mSurfaceHeight : I
    //   469: aload_0
    //   470: getfield mImageWidth : I
    //   473: aload_0
    //   474: getfield mImageHeight : I
    //   477: invokestatic b : (Landroid/graphics/Rect;IIII)Landroid/graphics/Rect;
    //   480: astore_1
    //   481: aload_0
    //   482: getfield mHandler : Landroid/os/Handler;
    //   485: bipush #120
    //   487: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   490: astore #13
    //   492: aload #13
    //   494: aload_1
    //   495: putfield obj : Ljava/lang/Object;
    //   498: aload_0
    //   499: getfield mHandler : Landroid/os/Handler;
    //   502: aload #13
    //   504: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   507: pop
    //   508: aload_0
    //   509: aload_1
    //   510: putfield mIndexRect : Landroid/graphics/Rect;
    //   513: goto -> 631
    //   516: aload_0
    //   517: getfield mNeedShowRect : Z
    //   520: ifeq -> 553
    //   523: aload_0
    //   524: getfield mHandler : Landroid/os/Handler;
    //   527: bipush #121
    //   529: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   532: astore_1
    //   533: aload_1
    //   534: aload_0
    //   535: getfield mIndexRect : Landroid/graphics/Rect;
    //   538: putfield obj : Ljava/lang/Object;
    //   541: aload_0
    //   542: getfield mHandler : Landroid/os/Handler;
    //   545: aload_1
    //   546: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   549: pop
    //   550: goto -> 631
    //   553: aload_0
    //   554: getfield mHandler : Landroid/os/Handler;
    //   557: bipush #120
    //   559: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   562: astore_1
    //   563: aload_1
    //   564: aload #13
    //   566: putfield obj : Ljava/lang/Object;
    //   569: aload_0
    //   570: getfield mHandler : Landroid/os/Handler;
    //   573: aload_1
    //   574: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   577: pop
    //   578: aload_0
    //   579: aload #13
    //   581: putfield mIndexRect : Landroid/graphics/Rect;
    //   584: goto -> 631
    //   587: aload_0
    //   588: lconst_0
    //   589: putfield mObjectCost : J
    //   592: iload #12
    //   594: ifeq -> 611
    //   597: aload_0
    //   598: getfield mNeedBeautify : Z
    //   601: ifne -> 631
    //   604: aload_0
    //   605: getfield mNeedSticker : Z
    //   608: ifne -> 631
    //   611: aload_0
    //   612: getfield mHandler : Landroid/os/Handler;
    //   615: sipush #130
    //   618: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   621: astore_1
    //   622: aload_0
    //   623: getfield mHandler : Landroid/os/Handler;
    //   626: aload_1
    //   627: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   630: pop
    //   631: aload_0
    //   632: getfield mNeedBeautify : Z
    //   635: ifne -> 645
    //   638: aload_0
    //   639: getfield mNeedSticker : Z
    //   642: ifeq -> 1573
    //   645: aload_0
    //   646: getfield mIsCreateHumanActionHandleSucceeded : Z
    //   649: ifeq -> 1573
    //   652: invokestatic currentTimeMillis : ()J
    //   655: lstore #8
    //   657: aload_0
    //   658: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   661: aload_0
    //   662: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   665: invokevirtual array : ()[B
    //   668: bipush #6
    //   670: aload_0
    //   671: getfield mDetectConfig : J
    //   674: aload_0
    //   675: invokespecial getCurrentOrientation : ()I
    //   678: aload_0
    //   679: getfield mImageWidth : I
    //   682: aload_0
    //   683: getfield mImageHeight : I
    //   686: invokevirtual humanActionDetect : ([BIJIII)Lcom/sensetime/stmobile/model/STHumanAction;
    //   689: astore_1
    //   690: aload_0
    //   691: getfield TAG : Ljava/lang/String;
    //   694: ldc_w 'human action cost time: %d'
    //   697: iconst_1
    //   698: anewarray java/lang/Object
    //   701: dup
    //   702: iconst_0
    //   703: invokestatic currentTimeMillis : ()J
    //   706: lload #8
    //   708: lsub
    //   709: invokestatic valueOf : (J)Ljava/lang/Long;
    //   712: aastore
    //   713: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   716: pop
    //   717: aload_0
    //   718: getfield DEBUG : Z
    //   721: istore #12
    //   723: aconst_null
    //   724: astore #14
    //   726: iload #12
    //   728: ifeq -> 823
    //   731: aload_1
    //   732: ifnull -> 818
    //   735: aload_1
    //   736: getfield faceCount : I
    //   739: ifle -> 818
    //   742: invokestatic currentTimeMillis : ()J
    //   745: lstore #8
    //   747: aload_0
    //   748: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   751: astore #13
    //   753: aload_0
    //   754: aload_1
    //   755: aload_0
    //   756: invokespecial getCurrentOrientation : ()I
    //   759: iconst_0
    //   760: invokestatic getExpression : (Lcom/sensetime/stmobile/model/STHumanAction;IZ)[Z
    //   763: putfield mFaceExpressionResult : [Z
    //   766: aload_0
    //   767: getfield TAG : Ljava/lang/String;
    //   770: ldc_w 'face expression cost time: %d'
    //   773: iconst_1
    //   774: anewarray java/lang/Object
    //   777: dup
    //   778: iconst_0
    //   779: invokestatic currentTimeMillis : ()J
    //   782: lload #8
    //   784: lsub
    //   785: invokestatic valueOf : (J)Ljava/lang/Long;
    //   788: aastore
    //   789: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   792: pop
    //   793: aload_0
    //   794: getfield mHandler : Landroid/os/Handler;
    //   797: sipush #140
    //   800: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   803: astore #13
    //   805: aload_0
    //   806: getfield mHandler : Landroid/os/Handler;
    //   809: aload #13
    //   811: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   814: pop
    //   815: goto -> 823
    //   818: aload_0
    //   819: aconst_null
    //   820: putfield mFaceExpressionResult : [Z
    //   823: aload_0
    //   824: getfield DEBUG : Z
    //   827: ifeq -> 1250
    //   830: aload_1
    //   831: ifnull -> 968
    //   834: aload_1
    //   835: invokevirtual getImage : ()Lcom/sensetime/stmobile/model/STImage;
    //   838: ifnull -> 866
    //   841: aload_0
    //   842: getfield TAG : Ljava/lang/String;
    //   845: ldc_w 'human action background result: %d'
    //   848: iconst_1
    //   849: anewarray java/lang/Object
    //   852: dup
    //   853: iconst_0
    //   854: iconst_1
    //   855: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   858: aastore
    //   859: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   862: pop
    //   863: goto -> 888
    //   866: aload_0
    //   867: getfield TAG : Ljava/lang/String;
    //   870: ldc_w 'human action background result: %d'
    //   873: iconst_1
    //   874: anewarray java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: iconst_0
    //   880: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   883: aastore
    //   884: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   887: pop
    //   888: aload_1
    //   889: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   892: ifnull -> 941
    //   895: aload_1
    //   896: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   899: arraylength
    //   900: ifle -> 941
    //   903: aload_0
    //   904: aload_1
    //   905: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   908: iconst_0
    //   909: aaload
    //   910: getfield handAction : J
    //   913: putfield mHandAction : J
    //   916: aload_0
    //   917: getfield mHandler : Landroid/os/Handler;
    //   920: sipush #141
    //   923: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   926: astore #13
    //   928: aload_0
    //   929: getfield mHandler : Landroid/os/Handler;
    //   932: aload #13
    //   934: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   937: pop
    //   938: goto -> 968
    //   941: aload_0
    //   942: lconst_0
    //   943: putfield mHandAction : J
    //   946: aload_0
    //   947: getfield mHandler : Landroid/os/Handler;
    //   950: sipush #142
    //   953: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   956: astore #13
    //   958: aload_0
    //   959: getfield mHandler : Landroid/os/Handler;
    //   962: aload #13
    //   964: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   967: pop
    //   968: aload_0
    //   969: getfield mFrameCount : I
    //   972: istore #4
    //   974: iload #4
    //   976: bipush #20
    //   978: if_icmpgt -> 992
    //   981: aload_0
    //   982: iload #4
    //   984: iconst_1
    //   985: iadd
    //   986: putfield mFrameCount : I
    //   989: goto -> 1009
    //   992: aload_0
    //   993: iconst_0
    //   994: putfield mFrameCount : I
    //   997: aload_0
    //   998: aload_0
    //   999: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   1002: invokevirtual array : ()[B
    //   1005: aload_1
    //   1006: invokespecial faceAttributeDetect : ([BLcom/sensetime/stmobile/model/STHumanAction;)V
    //   1009: aload_1
    //   1010: ifnull -> 1250
    //   1013: aload_1
    //   1014: getfield faceCount : I
    //   1017: ifle -> 1079
    //   1020: iconst_0
    //   1021: istore #4
    //   1023: iload #4
    //   1025: aload_1
    //   1026: getfield faceCount : I
    //   1029: if_icmpge -> 1079
    //   1032: aload_1
    //   1033: iload #4
    //   1035: aload_0
    //   1036: getfield mImageWidth : I
    //   1039: aload_0
    //   1040: getfield mImageHeight : I
    //   1043: invokestatic a : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1046: astore #13
    //   1048: aload #13
    //   1050: ifnull -> 1070
    //   1053: aload #13
    //   1055: arraylength
    //   1056: ifle -> 1070
    //   1059: aload_0
    //   1060: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1063: iload #5
    //   1065: aload #13
    //   1067: invokevirtual onDrawPoints : (I[F)V
    //   1070: iload #4
    //   1072: iconst_1
    //   1073: iadd
    //   1074: istore #4
    //   1076: goto -> 1023
    //   1079: aload_1
    //   1080: getfield bodyCount : I
    //   1083: ifle -> 1238
    //   1086: iconst_0
    //   1087: istore #4
    //   1089: iload #4
    //   1091: aload_1
    //   1092: getfield bodyCount : I
    //   1095: if_icmpge -> 1145
    //   1098: aload_1
    //   1099: iload #4
    //   1101: aload_0
    //   1102: getfield mImageWidth : I
    //   1105: aload_0
    //   1106: getfield mImageHeight : I
    //   1109: invokestatic c : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1112: astore #13
    //   1114: aload #13
    //   1116: ifnull -> 1136
    //   1119: aload #13
    //   1121: arraylength
    //   1122: ifle -> 1136
    //   1125: aload_0
    //   1126: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1129: iload #5
    //   1131: aload #13
    //   1133: invokevirtual onDrawPoints : (I[F)V
    //   1136: iload #4
    //   1138: iconst_1
    //   1139: iadd
    //   1140: istore #4
    //   1142: goto -> 1089
    //   1145: aload_0
    //   1146: aload_1
    //   1147: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1150: iconst_0
    //   1151: aaload
    //   1152: getfield bodyAction : J
    //   1155: putfield mBodyAction : J
    //   1158: aload_0
    //   1159: getfield TAG : Ljava/lang/String;
    //   1162: ldc_w 'human action body count: %d'
    //   1165: iconst_1
    //   1166: anewarray java/lang/Object
    //   1169: dup
    //   1170: iconst_0
    //   1171: aload_1
    //   1172: getfield bodyCount : I
    //   1175: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1178: aastore
    //   1179: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1182: pop
    //   1183: aload_0
    //   1184: getfield TAG : Ljava/lang/String;
    //   1187: ldc_w 'human action body[0] action: %d'
    //   1190: iconst_1
    //   1191: anewarray java/lang/Object
    //   1194: dup
    //   1195: iconst_0
    //   1196: aload_1
    //   1197: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1200: iconst_0
    //   1201: aaload
    //   1202: getfield bodyAction : J
    //   1205: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1208: aastore
    //   1209: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1212: pop
    //   1213: aload_0
    //   1214: getfield mHandler : Landroid/os/Handler;
    //   1217: sipush #143
    //   1220: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1223: astore #13
    //   1225: aload_0
    //   1226: getfield mHandler : Landroid/os/Handler;
    //   1229: aload #13
    //   1231: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1234: pop
    //   1235: goto -> 1243
    //   1238: aload_0
    //   1239: lconst_0
    //   1240: putfield mBodyAction : J
    //   1243: ldc_w 36160
    //   1246: iconst_0
    //   1247: invokestatic glBindFramebuffer : (II)V
    //   1250: aload_0
    //   1251: invokespecial getCurrentOrientation : ()I
    //   1254: istore #7
    //   1256: aload_0
    //   1257: getfield mNeedBeautify : Z
    //   1260: ifeq -> 1367
    //   1263: invokestatic currentTimeMillis : ()J
    //   1266: lstore #8
    //   1268: aload_0
    //   1269: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   1272: iload #5
    //   1274: aload_0
    //   1275: getfield mImageWidth : I
    //   1278: aload_0
    //   1279: getfield mImageHeight : I
    //   1282: iload #7
    //   1284: aload_1
    //   1285: aload_0
    //   1286: getfield mBeautifyTextureId : [I
    //   1289: iconst_0
    //   1290: iaload
    //   1291: aload_0
    //   1292: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1295: invokevirtual processTexture : (IIIILcom/sensetime/stmobile/model/STHumanAction;ILcom/sensetime/stmobile/model/STHumanAction;)I
    //   1298: istore #4
    //   1300: invokestatic currentTimeMillis : ()J
    //   1303: lstore #10
    //   1305: aload_0
    //   1306: getfield TAG : Ljava/lang/String;
    //   1309: ldc_w 'beautify cost time: %d'
    //   1312: iconst_1
    //   1313: anewarray java/lang/Object
    //   1316: dup
    //   1317: iconst_0
    //   1318: lload #10
    //   1320: lload #8
    //   1322: lsub
    //   1323: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1326: aastore
    //   1327: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1330: pop
    //   1331: iload #4
    //   1333: ifne -> 1367
    //   1336: aload_0
    //   1337: getfield mBeautifyTextureId : [I
    //   1340: iconst_0
    //   1341: iaload
    //   1342: istore #6
    //   1344: aload_0
    //   1345: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1348: astore_1
    //   1349: aload_0
    //   1350: getfield TAG : Ljava/lang/String;
    //   1353: ldc_w 'replace enlarge eye and shrink face action'
    //   1356: iconst_0
    //   1357: anewarray java/lang/Object
    //   1360: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1363: pop
    //   1364: goto -> 1371
    //   1367: iload #5
    //   1369: istore #6
    //   1371: iload #6
    //   1373: istore #4
    //   1375: aload_0
    //   1376: getfield mNeedSticker : Z
    //   1379: ifeq -> 1577
    //   1382: aload_0
    //   1383: getfield mCustomEvent : I
    //   1386: istore #4
    //   1388: aload_0
    //   1389: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1392: astore #15
    //   1394: aload #14
    //   1396: astore #13
    //   1398: aload #15
    //   1400: ifnull -> 1452
    //   1403: aload #14
    //   1405: astore #13
    //   1407: aload #15
    //   1409: getfield values : [F
    //   1412: ifnull -> 1452
    //   1415: aload #14
    //   1417: astore #13
    //   1419: aload_0
    //   1420: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1423: getfield values : [F
    //   1426: arraylength
    //   1427: iconst_3
    //   1428: if_icmple -> 1452
    //   1431: new com/sensetime/stmobile/model/STStickerInputParams
    //   1434: dup
    //   1435: aload_0
    //   1436: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1439: getfield values : [F
    //   1442: iconst_0
    //   1443: aload_0
    //   1444: getfield mCustomEvent : I
    //   1447: invokespecial <init> : ([FZI)V
    //   1450: astore #13
    //   1452: invokestatic currentTimeMillis : ()J
    //   1455: lstore #8
    //   1457: aload_0
    //   1458: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1461: iload #6
    //   1463: aload_1
    //   1464: iload #7
    //   1466: iconst_0
    //   1467: aload_0
    //   1468: getfield mImageWidth : I
    //   1471: aload_0
    //   1472: getfield mImageHeight : I
    //   1475: iconst_0
    //   1476: aload #13
    //   1478: aload_0
    //   1479: getfield mTextureOutId : [I
    //   1482: iconst_0
    //   1483: iaload
    //   1484: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;I)I
    //   1487: istore #7
    //   1489: iload #4
    //   1491: aload_0
    //   1492: getfield mCustomEvent : I
    //   1495: if_icmpne -> 1503
    //   1498: aload_0
    //   1499: iconst_0
    //   1500: putfield mCustomEvent : I
    //   1503: aload_0
    //   1504: getfield TAG : Ljava/lang/String;
    //   1507: ldc_w 'processTexture result: %d'
    //   1510: iconst_1
    //   1511: anewarray java/lang/Object
    //   1514: dup
    //   1515: iconst_0
    //   1516: iload #7
    //   1518: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1521: aastore
    //   1522: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1525: pop
    //   1526: aload_0
    //   1527: getfield TAG : Ljava/lang/String;
    //   1530: ldc_w 'sticker cost time: %d'
    //   1533: iconst_1
    //   1534: anewarray java/lang/Object
    //   1537: dup
    //   1538: iconst_0
    //   1539: invokestatic currentTimeMillis : ()J
    //   1542: lload #8
    //   1544: lsub
    //   1545: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1548: aastore
    //   1549: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1552: pop
    //   1553: iload #6
    //   1555: istore #4
    //   1557: iload #7
    //   1559: ifne -> 1577
    //   1562: aload_0
    //   1563: getfield mTextureOutId : [I
    //   1566: iconst_0
    //   1567: iaload
    //   1568: istore #4
    //   1570: goto -> 1577
    //   1573: iload #5
    //   1575: istore #4
    //   1577: aload_0
    //   1578: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1581: astore_1
    //   1582: aload_0
    //   1583: getfield mFilterStyle : Ljava/lang/String;
    //   1586: astore #13
    //   1588: aload_1
    //   1589: aload #13
    //   1591: if_acmpeq -> 1612
    //   1594: aload_0
    //   1595: aload #13
    //   1597: putfield mCurrentFilterStyle : Ljava/lang/String;
    //   1600: aload_0
    //   1601: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1604: aload_0
    //   1605: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1608: invokevirtual setStyle : (Ljava/lang/String;)I
    //   1611: pop
    //   1612: aload_0
    //   1613: getfield mCurrentFilterStrength : F
    //   1616: fstore_2
    //   1617: aload_0
    //   1618: getfield mFilterStrength : F
    //   1621: fstore_3
    //   1622: fload_2
    //   1623: fload_3
    //   1624: fcmpl
    //   1625: ifeq -> 1646
    //   1628: aload_0
    //   1629: fload_3
    //   1630: putfield mCurrentFilterStrength : F
    //   1633: aload_0
    //   1634: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1637: iconst_0
    //   1638: aload_0
    //   1639: getfield mCurrentFilterStrength : F
    //   1642: invokevirtual setParam : (IF)I
    //   1645: pop
    //   1646: aload_0
    //   1647: getfield mFilterTextureOutId : [I
    //   1650: ifnonnull -> 1678
    //   1653: aload_0
    //   1654: iconst_1
    //   1655: newarray int
    //   1657: putfield mFilterTextureOutId : [I
    //   1660: aload_0
    //   1661: getfield mImageWidth : I
    //   1664: aload_0
    //   1665: getfield mImageHeight : I
    //   1668: aload_0
    //   1669: getfield mFilterTextureOutId : [I
    //   1672: sipush #3553
    //   1675: invokestatic a : (II[II)V
    //   1678: iload #4
    //   1680: istore #6
    //   1682: aload_0
    //   1683: getfield mNeedFilter : Z
    //   1686: ifeq -> 1763
    //   1689: invokestatic currentTimeMillis : ()J
    //   1692: lstore #8
    //   1694: aload_0
    //   1695: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1698: iload #4
    //   1700: aload_0
    //   1701: getfield mImageWidth : I
    //   1704: aload_0
    //   1705: getfield mImageHeight : I
    //   1708: aload_0
    //   1709: getfield mFilterTextureOutId : [I
    //   1712: iconst_0
    //   1713: iaload
    //   1714: invokevirtual processTexture : (IIII)I
    //   1717: istore #7
    //   1719: aload_0
    //   1720: getfield TAG : Ljava/lang/String;
    //   1723: ldc_w 'filters cost time: %d'
    //   1726: iconst_1
    //   1727: anewarray java/lang/Object
    //   1730: dup
    //   1731: iconst_0
    //   1732: invokestatic currentTimeMillis : ()J
    //   1735: lload #8
    //   1737: lsub
    //   1738: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1741: aastore
    //   1742: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1745: pop
    //   1746: iload #4
    //   1748: istore #6
    //   1750: iload #7
    //   1752: ifne -> 1763
    //   1755: aload_0
    //   1756: getfield mFilterTextureOutId : [I
    //   1759: iconst_0
    //   1760: iaload
    //   1761: istore #6
    //   1763: aload_0
    //   1764: getfield TAG : Ljava/lang/String;
    //   1767: ldc_w 'frame cost time total: %d'
    //   1770: iconst_1
    //   1771: anewarray java/lang/Object
    //   1774: dup
    //   1775: iconst_0
    //   1776: invokestatic currentTimeMillis : ()J
    //   1779: aload_0
    //   1780: getfield mStartTime : J
    //   1783: lsub
    //   1784: aload_0
    //   1785: getfield mRotateCost : J
    //   1788: ladd
    //   1789: aload_0
    //   1790: getfield mObjectCost : J
    //   1793: ladd
    //   1794: aload_0
    //   1795: getfield mFaceAttributeCost : J
    //   1798: ldc2_w 20
    //   1801: ldiv
    //   1802: ladd
    //   1803: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1806: aastore
    //   1807: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1810: pop
    //   1811: goto -> 1818
    //   1814: iload #5
    //   1816: istore #6
    //   1818: aload_0
    //   1819: getfield mNeedSave : Z
    //   1822: ifeq -> 1836
    //   1825: aload_0
    //   1826: iload #6
    //   1828: invokespecial savePicture : (I)V
    //   1831: aload_0
    //   1832: iconst_0
    //   1833: putfield mNeedSave : Z
    //   1836: aload_0
    //   1837: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1840: ifnull -> 1846
    //   1843: invokestatic glFinish : ()V
    //   1846: aload_0
    //   1847: getfield mVideoEncoderTexture : [I
    //   1850: iconst_0
    //   1851: iload #6
    //   1853: iastore
    //   1854: aload_0
    //   1855: getfield mVideoTexture : Landroid/graphics/SurfaceTexture;
    //   1858: aload_0
    //   1859: getfield mStMatrix : [F
    //   1862: invokevirtual getTransformMatrix : ([F)V
    //   1865: aload_0
    //   1866: monitorenter
    //   1867: aload_0
    //   1868: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1871: ifnull -> 1914
    //   1874: aload_0
    //   1875: getfield mNeedResetEglContext : Z
    //   1878: ifeq -> 1902
    //   1881: aload_0
    //   1882: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1885: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
    //   1888: aload_0
    //   1889: getfield mVideoEncoderTexture : [I
    //   1892: iconst_0
    //   1893: iaload
    //   1894: invokevirtual a : (Landroid/opengl/EGLContext;I)V
    //   1897: aload_0
    //   1898: iconst_0
    //   1899: putfield mNeedResetEglContext : Z
    //   1902: aload_0
    //   1903: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1906: aload_0
    //   1907: getfield mStMatrix : [F
    //   1910: invokevirtual a : ([F)Z
    //   1913: pop
    //   1914: aload_0
    //   1915: monitorexit
    //   1916: aload_0
    //   1917: invokestatic currentTimeMillis : ()J
    //   1920: aload_0
    //   1921: getfield mStartTime : J
    //   1924: lsub
    //   1925: aload_0
    //   1926: getfield mRotateCost : J
    //   1929: ladd
    //   1930: aload_0
    //   1931: getfield mObjectCost : J
    //   1934: ladd
    //   1935: aload_0
    //   1936: getfield mFaceAttributeCost : J
    //   1939: ldc2_w 20
    //   1942: ldiv
    //   1943: ladd
    //   1944: l2i
    //   1945: putfield mFrameCost : I
    //   1948: invokestatic currentTimeMillis : ()J
    //   1951: lstore #8
    //   1953: aload_0
    //   1954: aload_0
    //   1955: getfield mCount : I
    //   1958: iconst_1
    //   1959: iadd
    //   1960: putfield mCount : I
    //   1963: aload_0
    //   1964: getfield mIsFirstCount : Z
    //   1967: ifeq -> 1984
    //   1970: aload_0
    //   1971: lload #8
    //   1973: putfield mCurrentTime : J
    //   1976: aload_0
    //   1977: iconst_0
    //   1978: putfield mIsFirstCount : Z
    //   1981: goto -> 2030
    //   1984: lload #8
    //   1986: aload_0
    //   1987: getfield mCurrentTime : J
    //   1990: lsub
    //   1991: l2i
    //   1992: istore #4
    //   1994: iload #4
    //   1996: sipush #1000
    //   1999: if_icmplt -> 2030
    //   2002: aload_0
    //   2003: lload #8
    //   2005: putfield mCurrentTime : J
    //   2008: aload_0
    //   2009: aload_0
    //   2010: getfield mCount : I
    //   2013: i2f
    //   2014: ldc_w 1000.0
    //   2017: fmul
    //   2018: iload #4
    //   2020: i2f
    //   2021: fdiv
    //   2022: putfield mFps : F
    //   2025: aload_0
    //   2026: iconst_0
    //   2027: putfield mCount : I
    //   2030: aload_0
    //   2031: getfield TAG : Ljava/lang/String;
    //   2034: ldc_w 'render fps: %f'
    //   2037: iconst_1
    //   2038: anewarray java/lang/Object
    //   2041: dup
    //   2042: iconst_0
    //   2043: aload_0
    //   2044: getfield mFps : F
    //   2047: invokestatic valueOf : (F)Ljava/lang/Float;
    //   2050: aastore
    //   2051: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2054: pop
    //   2055: iconst_0
    //   2056: iconst_0
    //   2057: aload_0
    //   2058: getfield mSurfaceWidth : I
    //   2061: aload_0
    //   2062: getfield mSurfaceHeight : I
    //   2065: invokestatic glViewport : (IIII)V
    //   2068: aload_0
    //   2069: getfield mShowOriginal : Z
    //   2072: ifeq -> 2086
    //   2075: aload_0
    //   2076: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2079: iload #5
    //   2081: invokevirtual onDrawFrame : (I)I
    //   2084: pop
    //   2085: return
    //   2086: aload_0
    //   2087: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2090: iload #6
    //   2092: invokevirtual onDrawFrame : (I)I
    //   2095: pop
    //   2096: return
    //   2097: astore_1
    //   2098: aload_0
    //   2099: monitorexit
    //   2100: aload_1
    //   2101: athrow
    //   2102: return
    // Exception table:
    //   from	to	target	type
    //   1867	1902	2097	finally
    //   1902	1914	2097	finally
    //   1914	1916	2097	finally
    //   2098	2100	2097	finally
  }
  
  public void onPause() {
    LogUtils.c(this.TAG, "onPause", new Object[0]);
    this.mIsPaused = true;
    MediaPlayer mediaPlayer = this.mMediaPlayer;
    if (mediaPlayer != null)
      mediaPlayer.pause(); 
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            VideoPlayerDisplay.this.mSTHumanActionNative.reset();
            VideoPlayerDisplay.this.mStBeautifyNative.destroyBeautify();
            VideoPlayerDisplay.this.mStStickerNative.destroyInstance();
            VideoPlayerDisplay.this.mSTMobileStreamFilterNative.destroyInstance();
            VideoPlayerDisplay.access$1802(VideoPlayerDisplay.this, null);
            VideoPlayerDisplay.this.deleteTextures();
            VideoPlayerDisplay.this.mGLRender.destroyFrameBuffers();
          }
        });
    this.mGlSurfaceView.onPause();
  }
  
  public void onResume() {
    LogUtils.c(this.TAG, "onResume", new Object[0]);
    this.mIsPaused = false;
    this.mNeedPause = true;
    this.mGLRender = new STGLRender();
    this.mGlSurfaceView.onResume();
    this.mGlSurfaceView.forceLayout();
    this.mGlSurfaceView.requestRender();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {
    LogUtils.c(this.TAG, "onSurfaceChanged", new Object[0]);
    if (this.mIsPaused == true)
      return; 
    adjustViewPort(paramInt1, paramInt2);
    this.mGLRender.init(this.mImageWidth, this.mImageHeight);
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {
    LogUtils.c(this.TAG, "onSurfaceCreated", new Object[0]);
    if (this.mIsPaused == true)
      return; 
    GLES20.glEnable(3024);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glEnable(2929);
    setUpVideo();
    initBeauty();
    initSticker();
    initFilter();
  }
  
  public void prepareVideoAndStart() {
    this.mMediaPlayer = new MediaPlayer();
    this.mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
          public void onPrepared(MediaPlayer param1MediaPlayer) {
            param1MediaPlayer.start();
            Message message = VideoPlayerDisplay.this.mHandler.obtainMessage(170);
            message.arg1 = VideoPlayerDisplay.this.mMediaPlayer.getDuration();
            VideoPlayerDisplay.this.mHandler.sendMessage(message);
          }
        });
    Surface surface = new Surface(this.mVideoTexture);
    this.mMediaPlayer.setSurface(surface);
    surface.release();
    try {
      this.mMediaPlayer.reset();
      this.mMediaPlayer.setDataSource(this.mVideoPath);
      this.mMediaPlayer.prepareAsync();
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    this.mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          public void onCompletion(MediaPlayer param1MediaPlayer) {
            if (VideoPlayerDisplay.this.mNeedPause)
              return; 
            if (VideoPlayerDisplay.this.mMediaPlayer != null)
              VideoPlayerDisplay.this.mMediaPlayer.seekTo(0); 
            if (VideoPlayerDisplay.this.mTimerTask != null) {
              if (VideoPlayerDisplay.this.mMediaPlayer != null && !VideoPlayerDisplay.this.mMediaPlayer.isPlaying()) {
                int i = VideoPlayerDisplay.this.mMediaPlayer.getCurrentPosition();
                Message message = VideoPlayerDisplay.this.mHandler.obtainMessage(171);
                message.arg1 = i;
                VideoPlayerDisplay.this.mHandler.sendMessage(message);
              } 
              VideoPlayerDisplay.this.mTimerTask.cancel();
            } 
            if (VideoPlayerDisplay.this.mIsFirstPlaying) {
              Message message = VideoPlayerDisplay.this.mHandler.obtainMessage(172);
              VideoPlayerDisplay.this.mHandler.sendMessage(message);
              VideoPlayerDisplay.access$802(VideoPlayerDisplay.this, false);
              VideoPlayerDisplay.this.StartPlayVideo();
              return;
            } 
            VideoPlayerDisplay.this.StartPlayVideo();
          }
        });
  }
  
  public void removeSubModelByConfig(int paramInt) {
    Message message = this.mSubModelsManagerHandler.obtainMessage(1002);
    message.obj = Integer.valueOf(paramInt);
    this.mSubModelsManagerHandler.sendMessage(message);
  }
  
  public void resetIndexRect() {
    if (this.mImageWidth == 0)
      return; 
    int i = this.mSurfaceWidth;
    this.mScreenIndexRectWidth = i / 4;
    Rect rect = this.mIndexRect;
    int j = this.mScreenIndexRectWidth;
    rect.left = (i - j) / 2;
    rect.top = (this.mSurfaceHeight - j) / 2;
    rect.right = rect.left + this.mScreenIndexRectWidth;
    rect = this.mIndexRect;
    rect.bottom = rect.top + this.mScreenIndexRectWidth;
    this.mNeedShowRect = true;
    this.mNeedSetObjectTarget = false;
    this.mIsObjectTracking = false;
  }
  
  public void resetObjectTrack() {
    this.mSTMobileObjectTrackNative.reset();
  }
  
  public void setBeautyParam(int paramInt, float paramFloat) {
    if (this.mBeautifyParams[paramInt] != paramFloat) {
      this.mStBeautifyNative.setParam(Constants.a[paramInt], paramFloat);
      this.mBeautifyParams[paramInt] = paramFloat;
    } 
  }
  
  public void setFilterStrength(float paramFloat) {
    this.mFilterStrength = paramFloat;
  }
  
  public void setFilterStyle(String paramString) {
    this.mFilterStyle = paramString;
  }
  
  public void setHandler(Handler paramHandler) {
    this.mHandler = paramHandler;
  }
  
  public void setIndexRect(int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = this.mScreenIndexRectWidth;
    this.mIndexRect = new Rect(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
    this.mNeedShowRect = paramBoolean;
  }
  
  public void setObjectTrackRect() {
    this.mNeedSetObjectTarget = true;
    this.mIsObjectTracking = false;
    this.mTargetRect = STUtils.a(getIndexRect(), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
  }
  
  public void setSaveImage() {
    this.mNeedSave = true;
  }
  
  public void setSensorEvent(SensorEvent paramSensorEvent) {
    this.mSensorEvent = paramSensorEvent;
  }
  
  public void setShowOriginal(boolean paramBoolean) {
    this.mShowOriginal = paramBoolean;
  }
  
  public void setShowSticker(String paramString) {
    this.mCurrentSticker = paramString;
    this.mStStickerNative.changeSticker(this.mCurrentSticker);
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction());
  }
  
  public void setVideoEncoder(final MediaVideoEncoder encoder) {
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_0
            //   3: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   6: ifnull -> 28
            //   9: aload_0
            //   10: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   13: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
            //   16: aload_0
            //   17: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/VideoPlayerDisplay;
            //   20: invokestatic access$2000 : (Lcom/blued/android/module/external_sense_library/display/VideoPlayerDisplay;)[I
            //   23: iconst_0
            //   24: iaload
            //   25: invokevirtual a : (Landroid/opengl/EGLContext;I)V
            //   28: aload_0
            //   29: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/VideoPlayerDisplay;
            //   32: aload_0
            //   33: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   36: invokestatic access$2102 : (Lcom/blued/android/module/external_sense_library/display/VideoPlayerDisplay;Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;)Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   39: pop
            //   40: aload_0
            //   41: monitorexit
            //   42: return
            //   43: astore_1
            //   44: aload_0
            //   45: monitorexit
            //   46: aload_1
            //   47: athrow
            // Exception table:
            //   from	to	target	type
            //   2	28	43	finally
            //   28	42	43	finally
            //   44	46	43	finally
          }
        });
  }
  
  public void setmIsFirstPlaying(boolean paramBoolean) {
    this.mIsFirstPlaying = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\VideoPlayerDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */