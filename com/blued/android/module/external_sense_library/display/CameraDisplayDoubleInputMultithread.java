package com.blued.android.module.external_sense_library.display;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.Constants;
import com.blued.android.module.external_sense_library.camera.CameraProxy;
import com.blued.android.module.external_sense_library.encoder.MediaVideoEncoder;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import com.blued.android.module.external_sense_library.model.ByteWrapper;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STBeautifyNative;
import com.sensetime.stmobile.STMobileAnimalNative;
import com.sensetime.stmobile.STMobileAvatarNative;
import com.sensetime.stmobile.STMobileFaceAttributeNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileMakeupNative;
import com.sensetime.stmobile.STMobileObjectTrackNative;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.STMobileStreamFilterNative;
import com.sensetime.stmobile.model.STAnimalFace;
import com.sensetime.stmobile.model.STCondition;
import com.sensetime.stmobile.model.STFaceAttribute;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STMobile106;
import com.sensetime.stmobile.model.STRect;
import com.sensetime.stmobile.model.STTransParam;
import com.sensetime.stmobile.model.STTriggerEvent;
import com.sensetime.stmobile.sticker_module_types.STModuleInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraDisplayDoubleInputMultithread implements GLSurfaceView.Renderer {
  private static final int MESSAGE_ADD_SUB_MODEL = 1001;
  
  private static final int MESSAGE_DETECT_HUMANACTION = 101;
  
  private static final int MESSAGE_NEED_ADD_STICKER = 1006;
  
  private static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
  
  private static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
  
  private static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
  
  private static final int MESSAGE_PROCESS_IMAGE = 100;
  
  private static final int MESSAGE_REMOVE_SUB_MODEL = 1002;
  
  private boolean DEBUG = false;
  
  private String TAG = "CameraDisplayDoubleInputMultithread";
  
  private int animalFaceLlength = 0;
  
  private float[] avatarExpression = new float[54];
  
  boolean dectetStarted = false;
  
  private boolean frameBufferReady = false;
  
  private ByteBuffer frameRenderBuffer = null;
  
  STHumanAction humanAction;
  
  private int[] initTextureId = new int[1];
  
  private STAnimalFace[] mAnimalFace;
  
  private float[] mBeautifyParams = new float[] { 
      0.36F, 0.74F, 0.02F, 0.13F, 0.11F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  private int[] mBeautifyTextureId;
  
  private long mBodyAction = 0L;
  
  private boolean mBufferFilled = false;
  
  private boolean mCameraChanging = false;
  
  private int mCameraID = 1;
  
  public CameraProxy mCameraProxy;
  
  private Handler mChangeStickerManagerHandler;
  
  private HandlerThread mChangeStickerManagerThread;
  
  private Context mContext;
  
  private int mCount = 0;
  
  private boolean mCreateObjectTrackSucceeded = false;
  
  private float mCurrentFilterStrength = 0.65F;
  
  private String mCurrentFilterStyle;
  
  private String[] mCurrentMakeup = new String[9];
  
  private int mCurrentPreview = 0;
  
  private String mCurrentSticker;
  
  private TreeMap<Integer, String> mCurrentStickerMaps = new TreeMap<Integer, String>();
  
  private long mCurrentTime = 0L;
  
  private int mCustomEvent = 0;
  
  private byte[][] mDataBuffer = new byte[2][];
  
  private long mDetectConfig = 0L;
  
  private ExecutorService mDetectThreadPool = Executors.newFixedThreadPool(1);
  
  private String mFaceAttribute;
  
  private long mFaceAttributeCost = 0L;
  
  private float mFaceDistance = 0.0F;
  
  private boolean[] mFaceExpressionResult;
  
  private float mFilterStrength = 0.65F;
  
  private String mFilterStyle;
  
  private int[] mFilterTextureOutId;
  
  private boolean mFirstRender = true;
  
  private float mFps;
  
  private int mFrameCost = 0;
  
  private int mFrameCount = 0;
  
  private STGLRender mGLRender;
  
  private GLSurfaceView mGlSurfaceView;
  
  private long mHandAction = 0L;
  
  private Handler mHandler;
  
  private STHumanAction mHumanActionBeautyOutput = new STHumanAction();
  
  private int mHumanActionCreateConfig = 131568;
  
  private HandlerThread mHumanActionDetectThread;
  
  private Object mHumanActionHandleLock = new Object();
  
  private byte[] mImageData;
  
  private Object mImageDataLock = new Object();
  
  private int mImageHeight;
  
  private int mImageWidth;
  
  private Rect mIndexRect = new Rect();
  
  private boolean mInited = false;
  
  private int mInputTextureId;
  
  private boolean mIsChangingPreviewSize = false;
  
  private boolean mIsCreateHumanActionHandleSucceeded = false;
  
  private boolean mIsFirstCount = true;
  
  private boolean mIsObjectTracking = false;
  
  private boolean mIsPaused = false;
  
  LinkedBlockingDeque<ByteWrapper> mLBDQ = new LinkedBlockingDeque<ByteWrapper>();
  
  private ChangePreviewSizeListener mListener;
  
  Object mLock = new Object();
  
  private float mMakeUpStrength = 0.7F;
  
  private int[] mMakeupPackageId = new int[9];
  
  private float[] mMakeupStrength = new float[9];
  
  private int[] mMakeupTextureId;
  
  private boolean mNeedAvatar = true;
  
  private boolean mNeedAvatarExpression = false;
  
  private boolean mNeedBeautify = false;
  
  private boolean mNeedBeautyOutputBuffer = false;
  
  private boolean mNeedDistance = true;
  
  private boolean mNeedFaceAttribute = false;
  
  private boolean mNeedFilter = false;
  
  private boolean mNeedFilterOutputBuffer = false;
  
  private boolean mNeedMakeup = false;
  
  private boolean mNeedObject = false;
  
  private boolean mNeedResetEglContext = false;
  
  private boolean mNeedSave = false;
  
  private boolean mNeedSetObjectTarget = false;
  
  private boolean mNeedShowRect = true;
  
  private boolean mNeedSticker = false;
  
  private boolean mNeedStickerOutputBuffer = false;
  
  private ByteWrapper mNv21ImageData;
  
  private long mObjectCost = 0L;
  
  private int mParamType = 0;
  
  private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() {
      public void onPreviewFrame(byte[] param1ArrayOfbyte, Camera param1Camera) {
        while (CameraDisplayDoubleInputMultithread.this.mLBDQ.size() > 1)
          CameraDisplayDoubleInputMultithread.this.mLBDQ.pollLast(); 
        CameraDisplayDoubleInputMultithread.this.mLBDQ.offer(new ByteWrapper(param1ArrayOfbyte));
        if (!CameraDisplayDoubleInputMultithread.this.mCameraChanging) {
          if (CameraDisplayDoubleInputMultithread.this.mCameraProxy.a() == null)
            return; 
          if (CameraDisplayDoubleInputMultithread.this.mImageData == null || CameraDisplayDoubleInputMultithread.this.mImageData.length != CameraDisplayDoubleInputMultithread.this.mImageHeight * CameraDisplayDoubleInputMultithread.this.mImageWidth * 3 / 2) {
            CameraDisplayDoubleInputMultithread cameraDisplayDoubleInputMultithread = CameraDisplayDoubleInputMultithread.this;
            CameraDisplayDoubleInputMultithread.access$2102(cameraDisplayDoubleInputMultithread, new byte[cameraDisplayDoubleInputMultithread.mImageWidth * CameraDisplayDoubleInputMultithread.this.mImageHeight * 3 / 2]);
          } 
          synchronized (CameraDisplayDoubleInputMultithread.this.mImageDataLock) {
            System.arraycopy(param1ArrayOfbyte, 0, CameraDisplayDoubleInputMultithread.this.mImageData, 0, param1ArrayOfbyte.length);
            CameraDisplayDoubleInputMultithread.this.mProcessImageHandler.removeMessages(100);
            CameraDisplayDoubleInputMultithread.this.mProcessImageHandler.sendEmptyMessage(100);
            if (!CameraDisplayDoubleInputMultithread.this.frameBufferReady) {
              CameraDisplayDoubleInputMultithread.access$2702(CameraDisplayDoubleInputMultithread.this, true);
              CameraDisplayDoubleInputMultithread.this.mLBDQ.clear();
              CameraDisplayDoubleInputMultithread.this.queue.clear();
              null = CameraDisplayDoubleInputMultithread.this;
              null.initFrameRenderBuffer(((CameraDisplayDoubleInputMultithread)null).mImageWidth / 2 * CameraDisplayDoubleInputMultithread.this.mImageHeight / 2);
              CameraDisplayDoubleInputMultithread.this.mLBDQ.offer(new ByteWrapper(param1ArrayOfbyte));
              CameraDisplayDoubleInputMultithread.access$3002(CameraDisplayDoubleInputMultithread.this, true);
            } 
            CameraDisplayDoubleInputMultithread.access$3102(CameraDisplayDoubleInputMultithread.this, true);
            CameraDisplayDoubleInputMultithread.this.mGlSurfaceView.requestRender();
            return;
          } 
        } 
      }
    };
  
  private Handler mProcessImageHandler;
  
  private HandlerThread mProcessImageThread;
  
  private ByteBuffer mRGBABuffer;
  
  private long mRotateCost = 0L;
  
  private STMobileFaceAttributeNative mSTFaceAttributeNative = new STMobileFaceAttributeNative();
  
  private STMobileHumanActionNative mSTHumanActionNative = new STMobileHumanActionNative();
  
  private STMobileAvatarNative mSTMobileAvatarNative = new STMobileAvatarNative();
  
  private STMobileMakeupNative mSTMobileMakeupNative = new STMobileMakeupNative();
  
  private STMobileObjectTrackNative mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
  
  private STMobileStreamFilterNative mSTMobileStreamFilterNative = new STMobileStreamFilterNative();
  
  private STStickerEventCallback mSTStickerEventCallback;
  
  private int mScreenIndexRectWidth = 0;
  
  private SensorEvent mSensorEvent;
  
  private boolean mSetPreViewSizeSucceed = false;
  
  private boolean mShowOriginal = false;
  
  private STMobileAnimalNative mStAnimalNative = new STMobileAnimalNative();
  
  private STBeautifyNative mStBeautifyNative = new STBeautifyNative();
  
  private float[] mStMatrix = new float[16];
  
  private STMobileStickerNative mStStickerNative = new STMobileStickerNative();
  
  private long mStartTime;
  
  private Handler mSubModelsManagerHandler;
  
  private HandlerThread mSubModelsManagerThread;
  
  private ArrayList<String> mSupportedPreviewSizes;
  
  private int mSurfaceHeight;
  
  private SurfaceTexture mSurfaceTexture;
  
  private int mSurfaceWidth;
  
  private Rect mTargetRect = new Rect();
  
  private FloatBuffer mTextureBuffer;
  
  protected int mTextureId = -1;
  
  private boolean mTextureInit = false;
  
  private int[] mTextureOutId;
  
  private int[] mTextureUV;
  
  private int[] mTextureY;
  
  private MediaVideoEncoder mVideoEncoder;
  
  private int[] mVideoEncoderTexture;
  
  private boolean needAnimalDetect = false;
  
  private boolean nv21YUVDataDirty;
  
  private Queue<STHumanAction> queue = new LinkedBlockingQueue<STHumanAction>();
  
  boolean renderFlag = false;
  
  STHumanAction rotatedHumanAction;
  
  int[] textureIdBuffer = new int[2];
  
  public CameraDisplayDoubleInputMultithread(Context paramContext, ChangePreviewSizeListener paramChangePreviewSizeListener, GLSurfaceView paramGLSurfaceView) {
    this.mCameraProxy = new CameraProxy(paramContext);
    this.mGlSurfaceView = paramGLSurfaceView;
    this.mListener = paramChangePreviewSizeListener;
    this.mContext = paramContext;
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
    this.mTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureBuffer.put(TextureRotationUtil.b).position(0);
    this.mGLRender = new STGLRender();
    this.DEBUG = AppInfo.m();
    initHumanAction();
    initCatFace();
    initObjectTrack();
    if (this.mNeedAvatarExpression)
      initAvatar(); 
    if (this.DEBUG)
      initFaceAttribute(); 
    initHandlerManager();
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
        } else if (paramString.equals("M_SenseME_Avatar_Help_2.0.0.model")) {
          this.mDetectConfig |= 0x800000000000L;
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
    arrayOfInt = this.mMakeupTextureId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mMakeupTextureId = null;
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
    arrayOfInt = this.mTextureY;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mTextureY = null;
    } 
    arrayOfInt = this.mTextureUV;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mTextureUV = null;
    } 
  }
  
  private void faceAttributeDetect(byte[] paramArrayOfbyte, STHumanAction paramSTHumanAction) {
    if (paramSTHumanAction != null && paramArrayOfbyte != null && paramArrayOfbyte.length == this.mImageWidth * this.mImageHeight * 3 / 2) {
      STMobile106[] arrayOfSTMobile106 = paramSTHumanAction.getMobileFaces();
      if (arrayOfSTMobile106 != null && arrayOfSTMobile106.length != 0) {
        STFaceAttribute[] arrayOfSTFaceAttribute = new STFaceAttribute[arrayOfSTMobile106.length];
        long l = System.currentTimeMillis();
        int i = this.mSTFaceAttributeNative.detect(paramArrayOfbyte, 3, this.mImageHeight, this.mImageWidth, arrayOfSTMobile106, arrayOfSTFaceAttribute);
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
    int i = Accelerometer.c();
    if (this.mCameraProxy.d() == 90 || this.mCameraProxy.d() == 270) {
      int j = i - 1;
      return (j < 0) ? (i ^ 0x3) : j;
    } 
    return (i + 2) % 4;
  }
  
  private int getForeGroundStickerOrientation() {
    int i = Accelerometer.c();
    if (this.mCameraProxy.d() == 90 || this.mCameraProxy.d() == 270) {
      int j = i - 1;
      return (j < 0) ? (i ^ 0x3) : j;
    } 
    return (i + 2) % 4;
  }
  
  private int getHumanActionDetectDir(int paramInt1, int paramInt2) {
    int i;
    if (paramInt1 != 0) {
      i = paramInt2;
      if (paramInt1 != 90)
        if (paramInt1 != 180) {
          if (paramInt1 != 270)
            return 0; 
          i = paramInt2;
          if ((paramInt2 & 0x1) == 1)
            return paramInt2 ^ 0x2; 
        } else {
          return (paramInt2 + 1) % 4;
        }  
    } else {
      i = (paramInt2 + 3) % 4;
    } 
    return i;
  }
  
  private int getHumanActionOrientation() {
    int i = this.mCameraID;
    null = 0;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = Accelerometer.c();
    if (i == 0 && j == 0) {
      i = 2;
    } else if (i == 0 && j == 2) {
      i = null;
    } else {
      i = j;
    } 
    if (this.mCameraProxy.d() != 270 || (i & 0x1) != 1) {
      null = i;
      if (this.mCameraProxy.d() == 90) {
        null = i;
        if ((i & 0x1) == 0)
          return i ^ 0x2; 
      } 
      return null;
    } 
    return i ^ 0x2;
  }
  
  private void humanActionDetect(byte[] paramArrayOfbyte) {
    this.dectetStarted = true;
    long l = System.currentTimeMillis();
    int i = getHumanActionDetectDir(this.mCameraProxy.d(), Accelerometer.c());
    this.humanAction = this.mSTHumanActionNative.humanActionDetect(paramArrayOfbyte, 3, this.mDetectConfig, i, this.mImageHeight, this.mImageWidth);
    LogUtils.c(this.TAG, "human action cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    if (this.mNeedAvatarExpression && this.humanAction.getFaceInfos() != null) {
      this.mSTMobileAvatarNative.avatarExpressionDetect(i, this.mImageWidth, this.mImageHeight, this.humanAction.getFaceInfos()[0], this.avatarExpression);
      Log.d("avatarExpressionResult:", Arrays.toString(this.avatarExpression));
    } 
    if (this.mNeedDistance) {
      STHumanAction sTHumanAction1 = this.humanAction;
      if (sTHumanAction1 != null && sTHumanAction1.faceCount > 0) {
        l = System.currentTimeMillis();
        this.mFaceDistance = this.mSTHumanActionNative.getFaceDistance(this.humanAction.faces[0], i, this.mImageHeight, this.mImageWidth, this.mCameraProxy.a().getParameters().getVerticalViewAngle());
        LogUtils.c(this.TAG, "human action face distance cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      } else {
        this.mFaceDistance = 0.0F;
      } 
    } 
    STHumanAction sTHumanAction = this.humanAction;
    if (sTHumanAction != null && sTHumanAction.faceCount > 0) {
      String str = this.TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("humanActionDetect faceActionScoreCount: ");
      stringBuilder.append((this.humanAction.faces[0]).faceActionScoreCount);
      Log.e(str, stringBuilder.toString());
      if ((this.humanAction.faces[0]).faceActionScore != null)
        for (i = 0; i < (this.humanAction.faces[0]).faceActionScore.length; i++) {
          str = this.TAG;
          stringBuilder = new StringBuilder();
          stringBuilder.append("humanActionDetect faceAction ret: index: ");
          stringBuilder.append(i);
          stringBuilder.append(",  score: ");
          stringBuilder.append((this.humanAction.faces[0]).faceActionScore[i]);
          Log.e(str, stringBuilder.toString());
        }  
    } 
    synchronized (this.mLock) {
      this.humanAction = STHumanAction.humanActionRotateAndMirror(this.humanAction, this.mImageWidth, this.mImageHeight, this.mCameraID, this.mCameraProxy.d());
      this.queue.add(this.humanAction);
      this.mLock.notify();
      return;
    } 
  }
  
  private void initAvatar() {
    int i = this.mSTMobileAvatarNative.createInstanceFromAssetFile("M_SenseME_Avatar_Core_2.0.0.model", this.mContext.getAssets());
    LogUtils.c(this.TAG, "create avatar handle result: %d", new Object[] { Integer.valueOf(i) });
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
    } 
  }
  
  private void initCatFace() {
    int i = this.mStAnimalNative.createInstanceFromAssetFile("M_SenseME_CatFace_2.0.0.model", 0, this.mContext.getAssets());
    LogUtils.c(this.TAG, "create animal handle result: %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void initFaceAttribute() {
    int i = this.mSTFaceAttributeNative.createInstanceFromAssetFile("M_SenseME_Attribute_1.0.1.model", this.mContext.getAssets());
    LogUtils.c(this.TAG, "the result for createInstance for faceAttribute is %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void initFilter() {
    int i = this.mSTMobileStreamFilterNative.createInstance();
    LogUtils.c(this.TAG, "filters create instance result %d", new Object[] { Integer.valueOf(i) });
    this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle);
    this.mCurrentFilterStrength = this.mFilterStrength;
    this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
  }
  
  private void initFrameRenderBuffer(int paramInt) {
    this.frameRenderBuffer = ByteBuffer.allocateDirect(paramInt * 6);
    this.frameRenderBuffer.position(0);
    this.frameBufferReady = true;
  }
  
  private void initHandlerManager() {
    this.mProcessImageThread = new HandlerThread("ProcessImageThread");
    this.mProcessImageThread.start();
    this.mProcessImageHandler = new Handler(this.mProcessImageThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what == 100 && !CameraDisplayDoubleInputMultithread.this.mIsPaused && !CameraDisplayDoubleInputMultithread.this.mCameraChanging)
            CameraDisplayDoubleInputMultithread.this.objectTrack(); 
        }
      };
    this.mHumanActionDetectThread = new HandlerThread("mHumanActionDetectThread");
    this.mHumanActionDetectThread.start();
    this.mSubModelsManagerThread = new HandlerThread("SubModelManagerThread");
    this.mSubModelsManagerThread.start();
    this.mSubModelsManagerHandler = new Handler(this.mSubModelsManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplayDoubleInputMultithread.this.mIsPaused && !CameraDisplayDoubleInputMultithread.this.mCameraChanging && CameraDisplayDoubleInputMultithread.this.mIsCreateHumanActionHandleSucceeded) {
            int i = param1Message.what;
            if (i != 1001) {
              if (i != 1002)
                return; 
              i = ((Integer)param1Message.obj).intValue();
              if (i != 0) {
                CameraDisplayDoubleInputMultithread.this.removeSubModel(i);
                return;
              } 
            } else {
              String str = (String)param1Message.obj;
              if (str != null)
                CameraDisplayDoubleInputMultithread.this.addSubModel(str); 
            } 
          } 
        }
      };
    this.mChangeStickerManagerThread = new HandlerThread("ChangeStickerManagerThread");
    this.mChangeStickerManagerThread.start();
    this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplayDoubleInputMultithread.this.mIsPaused && !CameraDisplayDoubleInputMultithread.this.mCameraChanging) {
            CameraDisplayDoubleInputMultithread cameraDisplayDoubleInputMultithread2;
            String str;
            CameraDisplayDoubleInputMultithread cameraDisplayDoubleInputMultithread1;
            Message message;
            int i;
            int j;
            boolean bool;
            switch (param1Message.what) {
              default:
                return;
              case 1005:
                CameraDisplayDoubleInputMultithread.this.mStStickerNative.removeAllStickers();
                if (CameraDisplayDoubleInputMultithread.this.mCurrentStickerMaps != null)
                  CameraDisplayDoubleInputMultithread.this.mCurrentStickerMaps.clear(); 
                cameraDisplayDoubleInputMultithread2 = CameraDisplayDoubleInputMultithread.this;
                bool = cameraDisplayDoubleInputMultithread2.mNeedBeautify;
                cameraDisplayDoubleInputMultithread2.setHumanActionDetectConfig(CameraDisplayDoubleInputMultithread.this.mNeedFaceAttribute | bool, CameraDisplayDoubleInputMultithread.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInputMultithread.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1004:
                i = ((Integer)((Message)cameraDisplayDoubleInputMultithread2).obj).intValue();
                j = CameraDisplayDoubleInputMultithread.this.mStStickerNative.removeSticker(i);
                if (CameraDisplayDoubleInputMultithread.this.mCurrentStickerMaps != null && j == 0)
                  CameraDisplayDoubleInputMultithread.this.mCurrentStickerMaps.remove(Integer.valueOf(i)); 
                cameraDisplayDoubleInputMultithread2 = CameraDisplayDoubleInputMultithread.this;
                cameraDisplayDoubleInputMultithread2.setHumanActionDetectConfig(cameraDisplayDoubleInputMultithread2.mNeedBeautify | CameraDisplayDoubleInputMultithread.this.mNeedFaceAttribute, CameraDisplayDoubleInputMultithread.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInputMultithread.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1003:
                str = (String)((Message)cameraDisplayDoubleInputMultithread2).obj;
                CameraDisplayDoubleInputMultithread.access$602(CameraDisplayDoubleInputMultithread.this, str);
                i = CameraDisplayDoubleInputMultithread.this.mStStickerNative.changeSticker(CameraDisplayDoubleInputMultithread.this.mCurrentSticker);
                LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "change sticker result: %d", new Object[] { Integer.valueOf(i) });
                cameraDisplayDoubleInputMultithread1 = CameraDisplayDoubleInputMultithread.this;
                CameraDisplayDoubleInputMultithread.access$902(cameraDisplayDoubleInputMultithread1, cameraDisplayDoubleInputMultithread1.mStStickerNative.getNeededInputParams());
                cameraDisplayDoubleInputMultithread1 = CameraDisplayDoubleInputMultithread.this;
                cameraDisplayDoubleInputMultithread1.setHumanActionDetectConfig(cameraDisplayDoubleInputMultithread1.mNeedBeautify | CameraDisplayDoubleInputMultithread.this.mNeedFaceAttribute, CameraDisplayDoubleInputMultithread.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInputMultithread.this.mSTMobileMakeupNative.getTriggerAction());
                message = CameraDisplayDoubleInputMultithread.this.mHandler.obtainMessage(110);
                CameraDisplayDoubleInputMultithread.this.mHandler.sendMessage(message);
                break;
              case 1006:
                break;
            } 
          } 
        }
      };
  }
  
  private void initHumanAction() {
    (new Thread(new Runnable() {
          public void run() {
            synchronized (CameraDisplayDoubleInputMultithread.this.mHumanActionHandleLock) {
              int i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), CameraDisplayDoubleInputMultithread.this.mHumanActionCreateConfig, CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
              LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "add hand model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Segment_1.5.0.model", CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "add figure segment model result: %d", new Object[] { Integer.valueOf(i) });
                CameraDisplayDoubleInputMultithread.access$302(CameraDisplayDoubleInputMultithread.this, true);
                CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.setParam(2, 0.35F);
                i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Face_Extra_5.23.0.model", CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "add face extra model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Iris_2.0.0.model", CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "add eyeball contour model result: %d", new Object[] { Integer.valueOf(i) });
                if (CameraDisplayDoubleInputMultithread.this.mNeedAvatar) {
                  i = CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Avatar_Help_2.0.0.model", CameraDisplayDoubleInputMultithread.this.mContext.getAssets());
                  LogUtils.c(CameraDisplayDoubleInputMultithread.this.TAG, "add avatar help model result: %d", new Object[] { Integer.valueOf(i) });
                } 
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void initMakeup() {
    int j = this.mSTMobileMakeupNative.createInstance();
    String str = this.TAG;
    int i = 0;
    LogUtils.c(str, "makeup create instance result %d", new Object[] { Integer.valueOf(j) });
    while (i < 9) {
      if (this.mMakeupPackageId[i] > 0) {
        setMakeupForType(i, this.mCurrentMakeup[i]);
        setStrengthForType(i, this.mMakeupStrength[i]);
      } 
      i++;
    } 
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  private void initObjectTrack() {
    if (this.mSTMobileObjectTrackNative.createInstance() == 0)
      this.mCreateObjectTrackSucceeded = true; 
  }
  
  private void initSticker() {
    int i = this.mStStickerNative.createInstance(this.mContext);
    if (i == 0)
      this.mSTStickerEventCallback = new STStickerEventCallback(); 
    if (this.mNeedSticker && this.mCurrentStickerMaps.size() == 0)
      this.mStStickerNative.changeSticker(this.mCurrentSticker); 
    if (this.mNeedSticker && this.mCurrentStickerMaps != null) {
      TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
      for (Integer integer : this.mCurrentStickerMaps.keySet()) {
        String str = this.mCurrentStickerMaps.get(integer);
        int j = this.mStStickerNative.addSticker(str);
        treeMap.put(Integer.valueOf(j), str);
        Message message = this.mHandler.obtainMessage(161);
        message.arg1 = integer.intValue();
        message.arg2 = j;
        this.mHandler.sendMessage(message);
      } 
      this.mCurrentStickerMaps.clear();
      Iterator<Integer> iterator = treeMap.keySet().iterator();
      while (iterator.hasNext()) {
        int j = ((Integer)iterator.next()).intValue();
        this.mCurrentStickerMaps.put(Integer.valueOf(j), (String)treeMap.get(Integer.valueOf(j)));
      } 
    } 
    this.mStStickerNative.loadAvatarModelFromAssetFile("M_SenseME_Avatar_Core_2.0.0.model", this.mContext.getAssets());
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
    LogUtils.c(this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void objectTrack() {
    byte[] arrayOfByte = this.mImageData;
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0)
        return; 
      if (this.mNeedObject && this.mCreateObjectTrackSucceeded) {
        if (this.mNeedSetObjectTarget) {
          long l = System.currentTimeMillis();
          this.mTargetRect = STUtils.c(this.mTargetRect, this.mImageWidth, this.mImageHeight, this.mCameraID, this.mCameraProxy.d());
          STRect sTRect = new STRect(this.mTargetRect.left, this.mTargetRect.top, this.mTargetRect.right, this.mTargetRect.bottom);
          this.mSTMobileObjectTrackNative.setTarget(this.mImageData, 3, this.mImageHeight, this.mImageWidth, sTRect);
          LogUtils.c(this.TAG, "setTarget cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          this.mNeedSetObjectTarget = false;
          this.mIsObjectTracking = true;
        } 
        Rect rect = new Rect(0, 0, 0, 0);
        if (this.mIsObjectTracking) {
          long l = System.currentTimeMillis();
          float[] arrayOfFloat = new float[1];
          STRect sTRect = this.mSTMobileObjectTrackNative.objectTrack(this.mImageData, 3, this.mImageHeight, this.mImageWidth, arrayOfFloat);
          LogUtils.c(this.TAG, "objectTrack cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          this.mObjectCost = System.currentTimeMillis() - l;
          if (sTRect != null && arrayOfFloat.length > 0) {
            Rect rect1 = STUtils.b(STUtils.d(new Rect((sTRect.getRect()).left, (sTRect.getRect()).top, (sTRect.getRect()).right, (sTRect.getRect()).bottom), this.mImageWidth, this.mImageHeight, this.mCameraID, this.mCameraProxy.d()), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
            if (!this.mNeedShowRect) {
              Message message = this.mHandler.obtainMessage(120);
              message.obj = rect1;
              this.mHandler.sendMessage(message);
              this.mIndexRect = rect1;
              return;
            } 
          } 
        } else {
          Message message1;
          if (this.mNeedShowRect) {
            message1 = this.mHandler.obtainMessage(121);
            message1.obj = this.mIndexRect;
            this.mHandler.sendMessage(message1);
            return;
          } 
          Message message2 = this.mHandler.obtainMessage(120);
          message2.obj = message1;
          this.mHandler.sendMessage(message2);
          this.mIndexRect = (Rect)message1;
          return;
        } 
      } else {
        this.mObjectCost = 0L;
        if (!this.mNeedObject || (!this.mNeedBeautify && !this.mNeedSticker && !this.mNeedFaceAttribute)) {
          Message message = this.mHandler.obtainMessage(130);
          this.mHandler.sendMessage(message);
        } 
      } 
    } 
  }
  
  private STAnimalFace[] processAnimalFaceResult(STAnimalFace[] paramArrayOfSTAnimalFace, boolean paramBoolean, int paramInt) {
    if (paramArrayOfSTAnimalFace == null)
      return null; 
    if (paramBoolean && paramInt == 90) {
      paramArrayOfSTAnimalFace = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 1, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length);
      return STMobileAnimalNative.animalMirror(this.mImageWidth, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length);
    } 
    if (paramBoolean && paramInt == 270) {
      paramArrayOfSTAnimalFace = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 3, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length);
      return STMobileAnimalNative.animalMirror(this.mImageWidth, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length);
    } 
    if (!paramBoolean && paramInt == 270)
      return STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 3, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length); 
    STAnimalFace[] arrayOfSTAnimalFace = paramArrayOfSTAnimalFace;
    if (!paramBoolean) {
      arrayOfSTAnimalFace = paramArrayOfSTAnimalFace;
      if (paramInt == 90)
        arrayOfSTAnimalFace = STMobileAnimalNative.animalRotate(this.mImageHeight, this.mImageWidth, 1, paramArrayOfSTAnimalFace, paramArrayOfSTAnimalFace.length); 
    } 
    return arrayOfSTAnimalFace;
  }
  
  private void processStMatrix(float[] paramArrayOffloat) {
    paramArrayOffloat[0] = 1.0F;
    paramArrayOffloat[1] = 0.0F;
    paramArrayOffloat[2] = 0.0F;
    paramArrayOffloat[3] = 0.0F;
    paramArrayOffloat[4] = 0.0F;
    paramArrayOffloat[5] = -1.0F;
    paramArrayOffloat[6] = 0.0F;
    paramArrayOffloat[7] = 0.0F;
    paramArrayOffloat[8] = 0.0F;
    paramArrayOffloat[9] = 0.0F;
    paramArrayOffloat[10] = 1.0F;
    paramArrayOffloat[11] = 0.0F;
    paramArrayOffloat[12] = 0.0F;
    paramArrayOffloat[13] = 1.0F;
    paramArrayOffloat[14] = 0.0F;
    paramArrayOffloat[15] = 1.0F;
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
      } else if (paramInt == 140737488355328L) {
        this.mDetectConfig &= 0xFFFF7FFFFFFFFFFFL;
      } 
      return;
    } 
  }
  
  private void saveImageBuffer2Picture(byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = ByteBuffer.allocate(this.mImageHeight * this.mImageWidth * 4);
    byteBuffer.put(paramArrayOfbyte);
    Message message = Message.obtain(this.mHandler);
    message.what = 150;
    message.obj = byteBuffer;
    Bundle bundle = new Bundle();
    bundle.putInt("imageWidth", this.mImageWidth);
    bundle.putInt("imageHeight", this.mImageHeight);
    message.setData(bundle);
    message.sendToTarget();
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
  
  private void setHumanActionDetectConfig(boolean paramBoolean, long paramLong1, long paramLong2) {
    if (!this.mNeedSticker || this.mCurrentSticker == null)
      paramLong1 = 0L; 
    if (!this.mNeedMakeup)
      paramLong2 = 0L; 
    if (paramBoolean) {
      this.mDetectConfig = paramLong1 | paramLong2 | 0x1L;
    } else {
      this.mDetectConfig = paramLong1 | paramLong2;
    } 
    if ((this.mStStickerNative.getAnimalDetectConfig() & 0x1L) > 0L) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.needAnimalDetect = paramBoolean;
  }
  
  private void setUpCamera() {
    if (this.mTextureId == -1) {
      this.mTextureId = OpenGLUtils.a();
      this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
    } 
    String str = this.mSupportedPreviewSizes.get(this.mCurrentPreview);
    int i = str.indexOf('x');
    this.mImageHeight = Integer.parseInt(str.substring(0, i));
    this.mImageWidth = Integer.parseInt(str.substring(i + 1));
    int[] arrayOfInt = this.initTextureId;
    if (arrayOfInt[0] == 0)
      arrayOfInt[0] = OpenGLUtils.a(this.mImageWidth, this.mImageHeight, arrayOfInt); 
    if (this.mIsPaused)
      return; 
    while (true) {
      if (!this.mSetPreViewSizeSucceed) {
        try {
          this.mCameraProxy.a(this.mImageHeight, this.mImageWidth);
          this.mSetPreViewSizeSucceed = true;
        } catch (Exception exception) {
          this.mSetPreViewSizeSucceed = false;
        } 
        try {
          Thread.sleep(10L);
        } catch (Exception exception) {}
      } 
      boolean bool1 = this.mCameraProxy.e();
      boolean bool2 = this.mCameraProxy.f();
      this.mGLRender.adjustTextureBuffer(this.mCameraProxy.d(), bool2, bool1);
      if (this.mIsPaused)
        return; 
      this.mCameraProxy.a(this.mSurfaceTexture, this.mPreviewCallback);
      this.mFirstRender = true;
      return;
    } 
  }
  
  private void setUpTexture() {
    this.mTextureY = new int[1];
    GLES20.glGenTextures(1, this.mTextureY, 0);
    GLES20.glBindTexture(3553, this.mTextureY[0]);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    this.mTextureUV = new int[1];
    GLES20.glGenTextures(1, this.mTextureUV, 0);
    GLES20.glBindTexture(3553, this.mTextureUV[0]);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10241, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
  }
  
  private void updateFrameWhenDirty(byte[] paramArrayOfbyte) {
    this.frameRenderBuffer.clear();
    this.frameRenderBuffer.position(0);
    this.frameRenderBuffer.put(paramArrayOfbyte);
    this.frameRenderBuffer.position(0);
    this.nv21YUVDataDirty = false;
  }
  
  private void updateNV21YUVTexture() {
    if (!this.mTextureInit) {
      this.frameRenderBuffer.position(0);
      GLES20.glBindTexture(3553, this.mTextureY[0]);
      GLES20.glTexImage2D(3553, 0, 6409, this.mImageHeight, this.mImageWidth, 0, 6409, 5121, this.frameRenderBuffer);
      this.frameRenderBuffer.position(this.mImageWidth / 2 * 4 * this.mImageHeight / 2);
      GLES20.glBindTexture(3553, this.mTextureUV[0]);
      GLES20.glTexImage2D(3553, 0, 6410, this.mImageHeight / 2, this.mImageWidth / 2, 0, 6410, 5121, this.frameRenderBuffer);
      this.mTextureInit = true;
      return;
    } 
    this.frameRenderBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.mTextureY[0]);
    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mImageHeight, this.mImageWidth, 6409, 5121, this.frameRenderBuffer);
    this.frameRenderBuffer.position(this.mImageWidth / 2 * 4 * this.mImageHeight / 2);
    GLES20.glBindTexture(3553, this.mTextureUV[0]);
    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mImageHeight / 2, this.mImageWidth / 2, 6410, 5121, this.frameRenderBuffer);
  }
  
  public int addSticker(String paramString) {
    this.mCurrentSticker = paramString;
    int i = this.mStStickerNative.addSticker(this.mCurrentSticker);
    if (i > 0) {
      this.mParamType = this.mStStickerNative.getNeededInputParams();
      TreeMap<Integer, String> treeMap = this.mCurrentStickerMaps;
      if (treeMap != null)
        treeMap.put(Integer.valueOf(i), this.mCurrentSticker); 
      setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
      Message message1 = this.mHandler.obtainMessage(110);
      this.mHandler.sendMessage(message1);
      return i;
    } 
    Message message = this.mHandler.obtainMessage(160);
    this.mHandler.sendMessage(message);
    return -1;
  }
  
  public void addSubModelByName(String paramString) {
    Message message = this.mSubModelsManagerHandler.obtainMessage(1001);
    message.obj = paramString;
    this.mSubModelsManagerHandler.sendMessage(message);
  }
  
  public void changeCustomEvent() {
    this.mCustomEvent = 3;
  }
  
  public void changeModuleTransition(int paramInt) {
    STModuleInfo[] arrayOfSTModuleInfo = this.mStStickerNative.getModules();
    if (arrayOfSTModuleInfo == null)
      return; 
    int k = arrayOfSTModuleInfo.length;
    int j = 0;
    byte b3 = -1;
    byte b2 = -1;
    byte b1 = -1;
    int i = -1;
    while (j < k) {
      byte b4;
      byte b5;
      byte b6;
      String str = (new String((arrayOfSTModuleInfo[j]).b)).trim();
      if (str.equals("fire")) {
        b5 = (arrayOfSTModuleInfo[j]).a;
        b4 = b3;
        b6 = b1;
      } else if (str.equals("hand")) {
        b6 = (arrayOfSTModuleInfo[j]).a;
        b4 = b3;
        b5 = b2;
      } else if (str.equals("hearta")) {
        b4 = (arrayOfSTModuleInfo[j]).a;
        b5 = b2;
        b6 = b1;
      } else {
        b4 = b3;
        b5 = b2;
        b6 = b1;
        if (str.equals("heartb")) {
          i = (arrayOfSTModuleInfo[j]).a;
          b6 = b1;
          b5 = b2;
          b4 = b3;
        } 
      } 
      j++;
      b3 = b4;
      b2 = b5;
      b1 = b6;
    } 
    if (paramInt == 0 && b2 != -1 && b1 != -1) {
      this.mStStickerNative.clearModuleTransition(b2);
      this.mStStickerNative.clearModuleTransition(b1);
      STTriggerEvent sTTriggerEvent4 = new STTriggerEvent();
      sTTriggerEvent4.setTriggerType(2);
      sTTriggerEvent4.setTrigger(1048576L);
      sTTriggerEvent4.setModuleId(-1);
      sTTriggerEvent4.setAppear(true);
      STCondition sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(2);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent4 });
      STTransParam sTTransParam4 = new STTransParam();
      sTTransParam4.setFadeFrame(0);
      sTTransParam4.setDelayFrame(0);
      sTTransParam4.setLastingFrame(0);
      sTTransParam4.setPlayloop(1);
      this.mStStickerNative.addModuleTransition(b2, 2, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam4 }, new int[] { -1 });
      STTriggerEvent sTTriggerEvent3 = new STTriggerEvent();
      sTTriggerEvent3.setTriggerType(2);
      sTTriggerEvent3.setTrigger(1048576L);
      sTTriggerEvent3.setModuleId(-1);
      sTTriggerEvent3.setAppear(false);
      sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(2);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent3 });
      STTransParam sTTransParam3 = new STTransParam();
      sTTransParam3.setFadeFrame(0);
      sTTransParam3.setDelayFrame(0);
      sTTransParam3.setLastingFrame(0);
      sTTransParam3.setPlayloop(1);
      this.mStStickerNative.addModuleTransition(b2, 5, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam3 }, new int[] { -1 });
      STTriggerEvent sTTriggerEvent2 = new STTriggerEvent();
      sTTriggerEvent2.setTriggerType(2);
      sTTriggerEvent2.setTrigger(1048576L);
      sTTriggerEvent2.setModuleId(-1);
      sTTriggerEvent2.setAppear(true);
      sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(2);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent2 });
      STTransParam sTTransParam2 = new STTransParam();
      sTTransParam2.setFadeFrame(0);
      sTTransParam2.setDelayFrame(0);
      sTTransParam2.setLastingFrame(0);
      sTTransParam2.setPlayloop(1);
      this.mStStickerNative.addModuleTransition(b1, 2, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam2 }, new int[] { -1 });
      STTriggerEvent sTTriggerEvent1 = new STTriggerEvent();
      sTTriggerEvent1.setTriggerType(2);
      sTTriggerEvent1.setTrigger(1048576L);
      sTTriggerEvent1.setModuleId(-1);
      sTTriggerEvent1.setAppear(false);
      sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(2);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent1 });
      STTransParam sTTransParam1 = new STTransParam();
      sTTransParam1.setFadeFrame(0);
      sTTransParam1.setDelayFrame(0);
      sTTransParam1.setLastingFrame(0);
      sTTransParam1.setPlayloop(1);
      this.mStStickerNative.addModuleTransition(b1, 5, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam1 }, new int[] { -1 });
      this.mDetectConfig |= 0x100000L;
      return;
    } 
    if (paramInt == 1 && b3 != -1 && i != -1) {
      this.mStStickerNative.clearModuleTransition(b3);
      this.mStStickerNative.clearModuleTransition(i);
      STTriggerEvent sTTriggerEvent2 = new STTriggerEvent();
      sTTriggerEvent2.setTriggerType(2);
      sTTriggerEvent2.setTrigger(2L);
      sTTriggerEvent2.setModuleId(-1);
      sTTriggerEvent2.setAppear(true);
      STCondition sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(5);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent2 });
      STTransParam sTTransParam2 = new STTransParam();
      sTTransParam2.setFadeFrame(0);
      sTTransParam2.setDelayFrame(10);
      sTTransParam2.setLastingFrame(0);
      sTTransParam2.setPlayloop(3);
      this.mStStickerNative.addModuleTransition(b3, 2, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam2 }, new int[] { -1 });
      STTriggerEvent sTTriggerEvent1 = new STTriggerEvent();
      sTTriggerEvent1.setTriggerType(2);
      sTTriggerEvent1.setTrigger(2L);
      sTTriggerEvent1.setModuleId(-1);
      sTTriggerEvent1.setAppear(true);
      sTCondition = new STCondition();
      sTCondition.setPreStateModuleId(-1);
      sTCondition.setPreState(2);
      sTCondition.setTriggerCount(1);
      sTCondition.setTriggers(new STTriggerEvent[] { sTTriggerEvent1 });
      STTransParam sTTransParam1 = new STTransParam();
      sTTransParam1.setFadeFrame(0);
      sTTransParam1.setDelayFrame(0);
      sTTransParam1.setLastingFrame(0);
      sTTransParam1.setPlayloop(3);
      this.mStStickerNative.addModuleTransition(i, 2, new STCondition[] { sTCondition }, new STTransParam[] { sTTransParam1 }, new int[] { -1 });
      return;
    } 
    if (paramInt == 2 && b3 != -1)
      this.mStStickerNative.setParamBool(b3, 102, false); 
  }
  
  public void changePreviewSize(int paramInt) {
    if (this.mCameraProxy.a() != null && !this.mCameraChanging) {
      if (this.mIsPaused)
        return; 
      this.renderFlag = false;
      int[] arrayOfInt = this.textureIdBuffer;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      byte[][] arrayOfByte = this.mDataBuffer;
      arrayOfByte[0] = null;
      arrayOfByte[1] = null;
      this.mFirstRender = true;
      this.mCurrentPreview = paramInt;
      this.mSetPreViewSizeSucceed = false;
      this.mIsChangingPreviewSize = true;
      this.frameBufferReady = false;
      this.dectetStarted = false;
      this.mCameraChanging = true;
      this.mCameraProxy.c();
      this.mGlSurfaceView.queueEvent(new Runnable() {
            public void run() {
              if (CameraDisplayDoubleInputMultithread.this.mRGBABuffer != null)
                CameraDisplayDoubleInputMultithread.this.mRGBABuffer.clear(); 
              CameraDisplayDoubleInputMultithread.access$3702(CameraDisplayDoubleInputMultithread.this, null);
              CameraDisplayDoubleInputMultithread.this.mLBDQ.clear();
              CameraDisplayDoubleInputMultithread.this.queue.clear();
              CameraDisplayDoubleInputMultithread.this.deleteTextures();
              if (CameraDisplayDoubleInputMultithread.this.mCameraProxy.a() != null)
                CameraDisplayDoubleInputMultithread.this.setUpCamera(); 
              CameraDisplayDoubleInputMultithread.this.mGLRender.init(CameraDisplayDoubleInputMultithread.this.mImageWidth, CameraDisplayDoubleInputMultithread.this.mImageHeight);
              if (CameraDisplayDoubleInputMultithread.this.DEBUG)
                CameraDisplayDoubleInputMultithread.this.mGLRender.initDrawPoints(); 
              if (CameraDisplayDoubleInputMultithread.this.mNeedObject)
                CameraDisplayDoubleInputMultithread.this.resetIndexRect(); 
              CameraDisplayDoubleInputMultithread.this.mGLRender.calculateVertexBuffer(CameraDisplayDoubleInputMultithread.this.mSurfaceWidth, CameraDisplayDoubleInputMultithread.this.mSurfaceHeight, CameraDisplayDoubleInputMultithread.this.mImageWidth, CameraDisplayDoubleInputMultithread.this.mImageHeight);
              if (CameraDisplayDoubleInputMultithread.this.mListener != null)
                CameraDisplayDoubleInputMultithread.this.mListener.onChangePreviewSize(CameraDisplayDoubleInputMultithread.this.mImageHeight, CameraDisplayDoubleInputMultithread.this.mImageWidth); 
              CameraDisplayDoubleInputMultithread.access$102(CameraDisplayDoubleInputMultithread.this, false);
              CameraDisplayDoubleInputMultithread.access$4902(CameraDisplayDoubleInputMultithread.this, false);
              LogUtils.b(CameraDisplayDoubleInputMultithread.this.TAG, "exit  change Preview size queue event", new Object[0]);
              CameraDisplayDoubleInputMultithread.this.setUpTexture();
              CameraDisplayDoubleInputMultithread.access$5102(CameraDisplayDoubleInputMultithread.this, false);
            }
          });
    } 
  }
  
  public void changeSticker(String paramString) {
    this.mChangeStickerManagerHandler.removeMessages(1003);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1003);
    message.obj = paramString;
    this.mChangeStickerManagerHandler.sendMessage(message);
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
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
    this.mNeedResetEglContext = true;
  }
  
  public void enableFaceDistance(boolean paramBoolean) {
    this.mNeedDistance = paramBoolean;
  }
  
  public void enableFilter(boolean paramBoolean) {
    this.mNeedFilter = paramBoolean;
    this.mNeedResetEglContext = true;
  }
  
  public void enableMakeUp(boolean paramBoolean) {
    this.mNeedMakeup = paramBoolean;
    this.mNeedResetEglContext = true;
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void enableObject(boolean paramBoolean) {
    this.mNeedObject = paramBoolean;
    if (this.mNeedObject)
      resetIndexRect(); 
  }
  
  public void enableSticker(boolean paramBoolean) {
    this.mNeedSticker = paramBoolean;
    if (!paramBoolean)
      setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction()); 
    this.mNeedResetEglContext = true;
  }
  
  public long getAnimalDetectConfig() {
    return this.mStStickerNative.getAnimalDetectConfig();
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
  
  public int getCameraID() {
    return this.mCameraID;
  }
  
  public boolean getFaceAttribute() {
    return this.mNeedFaceAttribute;
  }
  
  public String getFaceAttributeString() {
    return this.mFaceAttribute;
  }
  
  public float getFaceDistanceInfo() {
    return this.mFaceDistance;
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
  
  public boolean getSupportPreviewsize(int paramInt) {
    return (paramInt == 0 && this.mSupportedPreviewSizes.contains("640x480")) ? true : ((paramInt == 1 && this.mSupportedPreviewSizes.contains("1280x720")));
  }
  
  public void handleZoom(boolean paramBoolean) {
    CameraProxy cameraProxy = this.mCameraProxy;
    if (cameraProxy != null)
      cameraProxy.a(paramBoolean); 
  }
  
  public boolean isChangingPreviewSize() {
    return this.mIsChangingPreviewSize;
  }
  
  public void onDestroy() {
    synchronized (this.mHumanActionHandleLock) {
      this.mSTHumanActionNative.destroyInstance();
      this.mSTFaceAttributeNative.destroyInstance();
      this.mSTMobileObjectTrackNative.destroyInstance();
      this.mStAnimalNative.destroyInstance();
      if (this.mNeedAvatarExpression)
        this.mSTMobileAvatarNative.destroyInstance(); 
      null = (Object<Integer, String>)this.mCurrentStickerMaps;
      if (null != null) {
        null.clear();
        this.mCurrentStickerMaps = null;
      } 
      return;
    } 
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCameraChanging : Z
    //   4: ifne -> 2843
    //   7: aload_0
    //   8: getfield mBufferFilled : Z
    //   11: ifeq -> 2843
    //   14: aload_0
    //   15: getfield frameBufferReady : Z
    //   18: ifne -> 22
    //   21: return
    //   22: aload_0
    //   23: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   26: invokevirtual a : ()Landroid/hardware/Camera;
    //   29: ifnonnull -> 33
    //   32: return
    //   33: aload_0
    //   34: getfield TAG : Ljava/lang/String;
    //   37: ldc_w 'onDrawFrame'
    //   40: iconst_0
    //   41: anewarray java/lang/Object
    //   44: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   47: pop
    //   48: aload_0
    //   49: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   52: ifnonnull -> 73
    //   55: aload_0
    //   56: aload_0
    //   57: getfield mImageHeight : I
    //   60: aload_0
    //   61: getfield mImageWidth : I
    //   64: imul
    //   65: iconst_4
    //   66: imul
    //   67: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   70: putfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   73: aload_0
    //   74: getfield mBeautifyTextureId : [I
    //   77: ifnonnull -> 105
    //   80: aload_0
    //   81: iconst_1
    //   82: newarray int
    //   84: putfield mBeautifyTextureId : [I
    //   87: aload_0
    //   88: getfield mImageWidth : I
    //   91: aload_0
    //   92: getfield mImageHeight : I
    //   95: aload_0
    //   96: getfield mBeautifyTextureId : [I
    //   99: sipush #3553
    //   102: invokestatic a : (II[II)V
    //   105: aload_0
    //   106: getfield mMakeupTextureId : [I
    //   109: ifnonnull -> 137
    //   112: aload_0
    //   113: iconst_1
    //   114: newarray int
    //   116: putfield mMakeupTextureId : [I
    //   119: aload_0
    //   120: getfield mImageWidth : I
    //   123: aload_0
    //   124: getfield mImageHeight : I
    //   127: aload_0
    //   128: getfield mMakeupTextureId : [I
    //   131: sipush #3553
    //   134: invokestatic a : (II[II)V
    //   137: aload_0
    //   138: getfield mTextureOutId : [I
    //   141: ifnonnull -> 169
    //   144: aload_0
    //   145: iconst_1
    //   146: newarray int
    //   148: putfield mTextureOutId : [I
    //   151: aload_0
    //   152: getfield mImageWidth : I
    //   155: aload_0
    //   156: getfield mImageHeight : I
    //   159: aload_0
    //   160: getfield mTextureOutId : [I
    //   163: sipush #3553
    //   166: invokestatic a : (II[II)V
    //   169: aload_0
    //   170: getfield mVideoEncoderTexture : [I
    //   173: ifnonnull -> 183
    //   176: aload_0
    //   177: iconst_1
    //   178: newarray int
    //   180: putfield mVideoEncoderTexture : [I
    //   183: aload_0
    //   184: invokestatic currentTimeMillis : ()J
    //   187: putfield mStartTime : J
    //   190: aload_0
    //   191: aload_0
    //   192: getfield renderFlag : Z
    //   195: iconst_1
    //   196: ixor
    //   197: putfield renderFlag : Z
    //   200: aload_0
    //   201: getfield renderFlag : Z
    //   204: iconst_1
    //   205: ixor
    //   206: istore #5
    //   208: aload_0
    //   209: getfield mLBDQ : Ljava/util/concurrent/LinkedBlockingDeque;
    //   212: invokevirtual size : ()I
    //   215: ifle -> 2833
    //   218: aload_0
    //   219: getfield mDataBuffer : [[B
    //   222: iload #5
    //   224: aload_0
    //   225: getfield mLBDQ : Ljava/util/concurrent/LinkedBlockingDeque;
    //   228: invokevirtual remove : ()Ljava/lang/Object;
    //   231: checkcast com/blued/android/module/external_sense_library/model/ByteWrapper
    //   234: invokevirtual getData : ()[B
    //   237: aastore
    //   238: aload_0
    //   239: getfield nv21YUVDataDirty : Z
    //   242: ifeq -> 292
    //   245: invokestatic currentTimeMillis : ()J
    //   248: lstore #8
    //   250: aload_0
    //   251: aload_0
    //   252: getfield mDataBuffer : [[B
    //   255: iload #5
    //   257: aaload
    //   258: invokespecial updateFrameWhenDirty : ([B)V
    //   261: aload_0
    //   262: invokespecial updateNV21YUVTexture : ()V
    //   265: aload_0
    //   266: getfield TAG : Ljava/lang/String;
    //   269: ldc_w 'updateTexture cost time: %d'
    //   272: iconst_1
    //   273: anewarray java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: invokestatic currentTimeMillis : ()J
    //   281: lload #8
    //   283: lsub
    //   284: invokestatic valueOf : (J)Ljava/lang/Long;
    //   287: aastore
    //   288: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   291: pop
    //   292: fconst_0
    //   293: fconst_0
    //   294: fconst_0
    //   295: fconst_0
    //   296: invokestatic glClearColor : (FFFF)V
    //   299: sipush #16640
    //   302: invokestatic glClear : (I)V
    //   305: aload_0
    //   306: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   309: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   312: pop
    //   313: invokestatic currentTimeMillis : ()J
    //   316: lstore #8
    //   318: aload_0
    //   319: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   322: aload_0
    //   323: getfield mTextureY : [I
    //   326: iconst_0
    //   327: iaload
    //   328: aload_0
    //   329: getfield mTextureUV : [I
    //   332: iconst_0
    //   333: iaload
    //   334: aload_0
    //   335: getfield renderFlag : Z
    //   338: invokevirtual YUV2RGB : (IIZ)I
    //   341: istore #6
    //   343: aload_0
    //   344: iload #6
    //   346: putfield mInputTextureId : I
    //   349: aload_0
    //   350: getfield TAG : Ljava/lang/String;
    //   353: ldc_w 'preprocess cost time: %d'
    //   356: iconst_1
    //   357: anewarray java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: invokestatic currentTimeMillis : ()J
    //   365: lload #8
    //   367: lsub
    //   368: invokestatic valueOf : (J)Ljava/lang/Long;
    //   371: aastore
    //   372: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   375: pop
    //   376: aload_0
    //   377: getfield needAnimalDetect : Z
    //   380: ifeq -> 456
    //   383: invokestatic currentTimeMillis : ()J
    //   386: lstore #8
    //   388: aload_0
    //   389: aload_0
    //   390: getfield mStAnimalNative : Lcom/sensetime/stmobile/STMobileAnimalNative;
    //   393: aload_0
    //   394: getfield mDataBuffer : [[B
    //   397: iload #5
    //   399: aaload
    //   400: iconst_3
    //   401: aload_0
    //   402: aload_0
    //   403: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   406: invokevirtual d : ()I
    //   409: invokestatic c : ()I
    //   412: invokespecial getHumanActionDetectDir : (II)I
    //   415: aload_0
    //   416: getfield mImageHeight : I
    //   419: aload_0
    //   420: getfield mImageWidth : I
    //   423: invokevirtual animalDetect : ([BIIII)[Lcom/sensetime/stmobile/model/STAnimalFace;
    //   426: putfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   429: aload_0
    //   430: getfield TAG : Ljava/lang/String;
    //   433: ldc_w 'cat face detect cost time: %d'
    //   436: iconst_1
    //   437: anewarray java/lang/Object
    //   440: dup
    //   441: iconst_0
    //   442: invokestatic currentTimeMillis : ()J
    //   445: lload #8
    //   447: lsub
    //   448: invokestatic valueOf : (J)Ljava/lang/Long;
    //   451: aastore
    //   452: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   455: pop
    //   456: aload_0
    //   457: getfield needAnimalDetect : Z
    //   460: ifeq -> 512
    //   463: aload_0
    //   464: getfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   467: astore_1
    //   468: aload_1
    //   469: ifnull -> 512
    //   472: aload_1
    //   473: arraylength
    //   474: ifle -> 512
    //   477: aload_0
    //   478: getfield mCameraID : I
    //   481: iconst_1
    //   482: if_icmpne -> 491
    //   485: iconst_1
    //   486: istore #12
    //   488: goto -> 494
    //   491: iconst_0
    //   492: istore #12
    //   494: aload_0
    //   495: aload_0
    //   496: aload_1
    //   497: iload #12
    //   499: aload_0
    //   500: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   503: invokevirtual d : ()I
    //   506: invokespecial processAnimalFaceResult : ([Lcom/sensetime/stmobile/model/STAnimalFace;ZI)[Lcom/sensetime/stmobile/model/STAnimalFace;
    //   509: putfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   512: aload_0
    //   513: getfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   516: astore_1
    //   517: aload_1
    //   518: ifnonnull -> 527
    //   521: iconst_0
    //   522: istore #4
    //   524: goto -> 531
    //   527: aload_1
    //   528: arraylength
    //   529: istore #4
    //   531: aload_0
    //   532: iload #4
    //   534: putfield animalFaceLlength : I
    //   537: aload_0
    //   538: getfield DEBUG : Z
    //   541: ifeq -> 610
    //   544: aload_0
    //   545: getfield animalFaceLlength : I
    //   548: ifle -> 610
    //   551: iconst_0
    //   552: istore #4
    //   554: iload #4
    //   556: aload_0
    //   557: getfield animalFaceLlength : I
    //   560: if_icmpge -> 610
    //   563: aload_0
    //   564: getfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   567: iload #4
    //   569: aaload
    //   570: aload_0
    //   571: getfield mImageWidth : I
    //   574: aload_0
    //   575: getfield mImageHeight : I
    //   578: invokestatic a : (Lcom/sensetime/stmobile/model/STAnimalFace;II)[F
    //   581: astore_1
    //   582: aload_1
    //   583: ifnull -> 601
    //   586: aload_1
    //   587: arraylength
    //   588: ifle -> 601
    //   591: aload_0
    //   592: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   595: iload #6
    //   597: aload_1
    //   598: invokevirtual onDrawPoints : (I[F)V
    //   601: iload #4
    //   603: iconst_1
    //   604: iadd
    //   605: istore #4
    //   607: goto -> 554
    //   610: aload_0
    //   611: getfield mShowOriginal : Z
    //   614: ifne -> 2543
    //   617: aload_0
    //   618: getfield mNeedBeautify : Z
    //   621: ifne -> 638
    //   624: aload_0
    //   625: getfield mNeedSticker : Z
    //   628: ifne -> 638
    //   631: aload_0
    //   632: getfield mNeedFaceAttribute : Z
    //   635: ifeq -> 2238
    //   638: aload_0
    //   639: getfield mIsCreateHumanActionHandleSucceeded : Z
    //   642: ifeq -> 2238
    //   645: aload_0
    //   646: getfield mCameraChanging : Z
    //   649: ifne -> 2237
    //   652: aload_0
    //   653: getfield mImageData : [B
    //   656: astore_1
    //   657: aload_1
    //   658: ifnull -> 2237
    //   661: aload_1
    //   662: arraylength
    //   663: aload_0
    //   664: getfield mImageHeight : I
    //   667: aload_0
    //   668: getfield mImageWidth : I
    //   671: imul
    //   672: iconst_3
    //   673: imul
    //   674: iconst_2
    //   675: idiv
    //   676: if_icmpeq -> 680
    //   679: return
    //   680: aload_0
    //   681: getfield mDetectThreadPool : Ljava/util/concurrent/ExecutorService;
    //   684: new com/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread$6
    //   687: dup
    //   688: aload_0
    //   689: iload #5
    //   691: invokespecial <init> : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;I)V
    //   694: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   699: pop
    //   700: aload_0
    //   701: aload_0
    //   702: getfield queue : Ljava/util/Queue;
    //   705: invokeinterface peek : ()Ljava/lang/Object;
    //   710: checkcast com/sensetime/stmobile/model/STHumanAction
    //   713: putfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   716: aload_0
    //   717: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   720: ifnull -> 736
    //   723: aload_0
    //   724: getfield queue : Ljava/util/Queue;
    //   727: invokeinterface remove : ()Ljava/lang/Object;
    //   732: pop
    //   733: goto -> 851
    //   736: aload_0
    //   737: getfield dectetStarted : Z
    //   740: ifeq -> 764
    //   743: aload_0
    //   744: getfield mFirstRender : Z
    //   747: ifeq -> 764
    //   750: aload_0
    //   751: getfield textureIdBuffer : [I
    //   754: iconst_0
    //   755: iload #6
    //   757: iastore
    //   758: aload_0
    //   759: iconst_0
    //   760: putfield mFirstRender : Z
    //   763: return
    //   764: aload_0
    //   765: getfield mLock : Ljava/lang/Object;
    //   768: astore_1
    //   769: aload_1
    //   770: monitorenter
    //   771: aload_0
    //   772: aload_0
    //   773: getfield queue : Ljava/util/Queue;
    //   776: invokeinterface peek : ()Ljava/lang/Object;
    //   781: checkcast com/sensetime/stmobile/model/STHumanAction
    //   784: putfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   787: aload_0
    //   788: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   791: astore #13
    //   793: aload #13
    //   795: ifnonnull -> 815
    //   798: aload_0
    //   799: getfield mLock : Ljava/lang/Object;
    //   802: invokevirtual wait : ()V
    //   805: goto -> 815
    //   808: astore #13
    //   810: aload #13
    //   812: invokevirtual printStackTrace : ()V
    //   815: aload_1
    //   816: monitorexit
    //   817: aload_0
    //   818: aload_0
    //   819: getfield queue : Ljava/util/Queue;
    //   822: invokeinterface peek : ()Ljava/lang/Object;
    //   827: checkcast com/sensetime/stmobile/model/STHumanAction
    //   830: putfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   833: aload_0
    //   834: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   837: ifnonnull -> 841
    //   840: return
    //   841: aload_0
    //   842: getfield queue : Ljava/util/Queue;
    //   845: invokeinterface remove : ()Ljava/lang/Object;
    //   850: pop
    //   851: aload_0
    //   852: getfield renderFlag : Z
    //   855: ifne -> 878
    //   858: aload_0
    //   859: getfield textureIdBuffer : [I
    //   862: astore_1
    //   863: aload_1
    //   864: iconst_1
    //   865: iload #6
    //   867: iastore
    //   868: aload_0
    //   869: aload_1
    //   870: iconst_0
    //   871: iaload
    //   872: putfield mInputTextureId : I
    //   875: goto -> 895
    //   878: aload_0
    //   879: getfield textureIdBuffer : [I
    //   882: astore_1
    //   883: aload_1
    //   884: iconst_0
    //   885: iload #6
    //   887: iastore
    //   888: aload_0
    //   889: aload_1
    //   890: iconst_1
    //   891: iaload
    //   892: putfield mInputTextureId : I
    //   895: aload_0
    //   896: getfield DEBUG : Z
    //   899: ifeq -> 1067
    //   902: aload_0
    //   903: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   906: astore_1
    //   907: aload_1
    //   908: ifnull -> 1018
    //   911: aload_1
    //   912: getfield faceCount : I
    //   915: ifle -> 1018
    //   918: invokestatic currentTimeMillis : ()J
    //   921: lstore #8
    //   923: aload_0
    //   924: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   927: astore_1
    //   928: aload_0
    //   929: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   932: astore_1
    //   933: aload_0
    //   934: invokespecial getHumanActionOrientation : ()I
    //   937: istore #4
    //   939: aload_0
    //   940: getfield mCameraID : I
    //   943: iconst_1
    //   944: if_icmpne -> 953
    //   947: iconst_1
    //   948: istore #12
    //   950: goto -> 956
    //   953: iconst_0
    //   954: istore #12
    //   956: aload_0
    //   957: aload_1
    //   958: iload #4
    //   960: iload #12
    //   962: invokestatic getExpression : (Lcom/sensetime/stmobile/model/STHumanAction;IZ)[Z
    //   965: putfield mFaceExpressionResult : [Z
    //   968: aload_0
    //   969: getfield TAG : Ljava/lang/String;
    //   972: ldc_w 'face expression cost time: %d'
    //   975: iconst_1
    //   976: anewarray java/lang/Object
    //   979: dup
    //   980: iconst_0
    //   981: invokestatic currentTimeMillis : ()J
    //   984: lload #8
    //   986: lsub
    //   987: invokestatic valueOf : (J)Ljava/lang/Long;
    //   990: aastore
    //   991: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   994: pop
    //   995: aload_0
    //   996: getfield mHandler : Landroid/os/Handler;
    //   999: sipush #140
    //   1002: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1005: astore_1
    //   1006: aload_0
    //   1007: getfield mHandler : Landroid/os/Handler;
    //   1010: aload_1
    //   1011: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1014: pop
    //   1015: goto -> 1023
    //   1018: aload_0
    //   1019: aconst_null
    //   1020: putfield mFaceExpressionResult : [Z
    //   1023: aload_0
    //   1024: getfield mFrameCount : I
    //   1027: istore #4
    //   1029: iload #4
    //   1031: bipush #20
    //   1033: if_icmpgt -> 1047
    //   1036: aload_0
    //   1037: iload #4
    //   1039: iconst_1
    //   1040: iadd
    //   1041: putfield mFrameCount : I
    //   1044: goto -> 1067
    //   1047: aload_0
    //   1048: iconst_0
    //   1049: putfield mFrameCount : I
    //   1052: aload_0
    //   1053: aload_0
    //   1054: getfield mDataBuffer : [[B
    //   1057: iload #5
    //   1059: aaload
    //   1060: aload_0
    //   1061: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1064: invokespecial faceAttributeDetect : ([BLcom/sensetime/stmobile/model/STHumanAction;)V
    //   1067: aload_0
    //   1068: invokespecial getCurrentOrientation : ()I
    //   1071: istore #5
    //   1073: aload_0
    //   1074: getfield mNeedBeautify : Z
    //   1077: ifeq -> 1276
    //   1080: invokestatic currentTimeMillis : ()J
    //   1083: lstore #8
    //   1085: aload_0
    //   1086: getfield mNeedBeautyOutputBuffer : Z
    //   1089: ifne -> 1132
    //   1092: aload_0
    //   1093: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   1096: aload_0
    //   1097: getfield mInputTextureId : I
    //   1100: aload_0
    //   1101: getfield mImageWidth : I
    //   1104: aload_0
    //   1105: getfield mImageHeight : I
    //   1108: iload #5
    //   1110: aload_0
    //   1111: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1114: aload_0
    //   1115: getfield mBeautifyTextureId : [I
    //   1118: iconst_0
    //   1119: iaload
    //   1120: aload_0
    //   1121: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1124: invokevirtual processTexture : (IIIILcom/sensetime/stmobile/model/STHumanAction;ILcom/sensetime/stmobile/model/STHumanAction;)I
    //   1127: istore #4
    //   1129: goto -> 1207
    //   1132: aload_0
    //   1133: getfield mImageWidth : I
    //   1136: istore #4
    //   1138: aload_0
    //   1139: getfield mImageHeight : I
    //   1142: istore #7
    //   1144: iload #4
    //   1146: iload #7
    //   1148: imul
    //   1149: iconst_4
    //   1150: imul
    //   1151: newarray byte
    //   1153: astore_1
    //   1154: aload_0
    //   1155: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   1158: aload_0
    //   1159: getfield mInputTextureId : I
    //   1162: iload #4
    //   1164: iload #7
    //   1166: iload #5
    //   1168: aload_0
    //   1169: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1172: aload_0
    //   1173: getfield mBeautifyTextureId : [I
    //   1176: iconst_0
    //   1177: iaload
    //   1178: aload_1
    //   1179: bipush #6
    //   1181: aload_0
    //   1182: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1185: invokevirtual processTextureAndOutputBuffer : (IIIILcom/sensetime/stmobile/model/STHumanAction;I[BILcom/sensetime/stmobile/model/STHumanAction;)I
    //   1188: istore #4
    //   1190: aload_0
    //   1191: getfield mNeedSave : Z
    //   1194: ifeq -> 1207
    //   1197: iload #4
    //   1199: ifne -> 1207
    //   1202: aload_0
    //   1203: aload_1
    //   1204: invokespecial saveImageBuffer2Picture : ([B)V
    //   1207: invokestatic currentTimeMillis : ()J
    //   1210: lstore #10
    //   1212: aload_0
    //   1213: getfield TAG : Ljava/lang/String;
    //   1216: ldc_w 'beautify cost time: %d'
    //   1219: iconst_1
    //   1220: anewarray java/lang/Object
    //   1223: dup
    //   1224: iconst_0
    //   1225: lload #10
    //   1227: lload #8
    //   1229: lsub
    //   1230: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1233: aastore
    //   1234: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1237: pop
    //   1238: iload #4
    //   1240: ifne -> 1276
    //   1243: aload_0
    //   1244: aload_0
    //   1245: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1248: putfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1251: aload_0
    //   1252: aload_0
    //   1253: getfield mBeautifyTextureId : [I
    //   1256: iconst_0
    //   1257: iaload
    //   1258: putfield mInputTextureId : I
    //   1261: aload_0
    //   1262: getfield TAG : Ljava/lang/String;
    //   1265: ldc_w 'replace enlarge eye and shrink face action'
    //   1268: iconst_0
    //   1269: anewarray java/lang/Object
    //   1272: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1275: pop
    //   1276: aload_0
    //   1277: getfield mNeedMakeup : Z
    //   1280: ifeq -> 1359
    //   1283: invokestatic currentTimeMillis : ()J
    //   1286: lstore #8
    //   1288: aload_0
    //   1289: getfield mSTMobileMakeupNative : Lcom/sensetime/stmobile/STMobileMakeupNative;
    //   1292: aload_0
    //   1293: getfield mInputTextureId : I
    //   1296: aload_0
    //   1297: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1300: iload #5
    //   1302: aload_0
    //   1303: getfield mImageWidth : I
    //   1306: aload_0
    //   1307: getfield mImageHeight : I
    //   1310: aload_0
    //   1311: getfield mMakeupTextureId : [I
    //   1314: iconst_0
    //   1315: iaload
    //   1316: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIII)I
    //   1319: ifne -> 1332
    //   1322: aload_0
    //   1323: aload_0
    //   1324: getfield mMakeupTextureId : [I
    //   1327: iconst_0
    //   1328: iaload
    //   1329: putfield mInputTextureId : I
    //   1332: aload_0
    //   1333: getfield TAG : Ljava/lang/String;
    //   1336: ldc_w 'makeup cost time: %d'
    //   1339: iconst_1
    //   1340: anewarray java/lang/Object
    //   1343: dup
    //   1344: iconst_0
    //   1345: invokestatic currentTimeMillis : ()J
    //   1348: lload #8
    //   1350: lsub
    //   1351: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1354: aastore
    //   1355: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1358: pop
    //   1359: aload_0
    //   1360: getfield mCameraChanging : Z
    //   1363: ifeq -> 1367
    //   1366: return
    //   1367: aload_0
    //   1368: getfield mNeedSticker : Z
    //   1371: ifeq -> 1735
    //   1374: aload_0
    //   1375: getfield mCustomEvent : I
    //   1378: istore #7
    //   1380: aload_0
    //   1381: getfield mParamType : I
    //   1384: iconst_1
    //   1385: iand
    //   1386: iconst_1
    //   1387: if_icmpne -> 1458
    //   1390: aload_0
    //   1391: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1394: astore_1
    //   1395: aload_1
    //   1396: ifnull -> 1458
    //   1399: aload_1
    //   1400: getfield values : [F
    //   1403: ifnull -> 1458
    //   1406: aload_0
    //   1407: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1410: getfield values : [F
    //   1413: arraylength
    //   1414: ifle -> 1458
    //   1417: aload_0
    //   1418: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1421: getfield values : [F
    //   1424: astore_1
    //   1425: aload_0
    //   1426: getfield mCameraID : I
    //   1429: iconst_1
    //   1430: if_icmpne -> 1439
    //   1433: iconst_1
    //   1434: istore #12
    //   1436: goto -> 1442
    //   1439: iconst_0
    //   1440: istore #12
    //   1442: new com/sensetime/stmobile/model/STStickerInputParams
    //   1445: dup
    //   1446: aload_1
    //   1447: iload #12
    //   1449: iload #7
    //   1451: invokespecial <init> : ([FZI)V
    //   1454: astore_1
    //   1455: goto -> 1506
    //   1458: aload_0
    //   1459: getfield mCameraID : I
    //   1462: iconst_1
    //   1463: if_icmpne -> 1472
    //   1466: iconst_1
    //   1467: istore #12
    //   1469: goto -> 1475
    //   1472: iconst_0
    //   1473: istore #12
    //   1475: new com/sensetime/stmobile/model/STStickerInputParams
    //   1478: dup
    //   1479: iconst_4
    //   1480: newarray float
    //   1482: dup
    //   1483: iconst_0
    //   1484: fconst_0
    //   1485: fastore
    //   1486: dup
    //   1487: iconst_1
    //   1488: fconst_0
    //   1489: fastore
    //   1490: dup
    //   1491: iconst_2
    //   1492: fconst_0
    //   1493: fastore
    //   1494: dup
    //   1495: iconst_3
    //   1496: fconst_1
    //   1497: fastore
    //   1498: iload #12
    //   1500: iload #7
    //   1502: invokespecial <init> : ([FZI)V
    //   1505: astore_1
    //   1506: invokestatic currentTimeMillis : ()J
    //   1509: lstore #8
    //   1511: aload_0
    //   1512: getfield mNeedStickerOutputBuffer : Z
    //   1515: ifne -> 1568
    //   1518: aload_0
    //   1519: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1522: aload_0
    //   1523: getfield mInputTextureId : I
    //   1526: aload_0
    //   1527: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1530: iload #5
    //   1532: aload_0
    //   1533: invokespecial getForeGroundStickerOrientation : ()I
    //   1536: aload_0
    //   1537: getfield mImageWidth : I
    //   1540: aload_0
    //   1541: getfield mImageHeight : I
    //   1544: iconst_0
    //   1545: aload_1
    //   1546: aload_0
    //   1547: getfield mAnimalFace : [Lcom/sensetime/stmobile/model/STAnimalFace;
    //   1550: aload_0
    //   1551: getfield animalFaceLlength : I
    //   1554: aload_0
    //   1555: getfield mTextureOutId : [I
    //   1558: iconst_0
    //   1559: iaload
    //   1560: invokevirtual processTextureBoth : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;[Lcom/sensetime/stmobile/model/STAnimalFace;II)I
    //   1563: istore #4
    //   1565: goto -> 1656
    //   1568: aload_0
    //   1569: getfield mImageWidth : I
    //   1572: aload_0
    //   1573: getfield mImageHeight : I
    //   1576: imul
    //   1577: iconst_4
    //   1578: imul
    //   1579: newarray byte
    //   1581: astore #13
    //   1583: aload_0
    //   1584: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1587: aload_0
    //   1588: getfield mInputTextureId : I
    //   1591: aload_0
    //   1592: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1595: iload #5
    //   1597: aload_0
    //   1598: invokespecial getForeGroundStickerOrientation : ()I
    //   1601: aload_0
    //   1602: getfield mImageWidth : I
    //   1605: aload_0
    //   1606: getfield mImageHeight : I
    //   1609: iconst_0
    //   1610: aload_1
    //   1611: aload_0
    //   1612: getfield mTextureOutId : [I
    //   1615: iconst_0
    //   1616: iaload
    //   1617: bipush #6
    //   1619: aload #13
    //   1621: invokevirtual processTextureAndOutputBuffer : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;II[B)I
    //   1624: istore #5
    //   1626: iload #5
    //   1628: istore #4
    //   1630: aload_0
    //   1631: getfield mNeedSave : Z
    //   1634: ifeq -> 1656
    //   1637: iload #5
    //   1639: istore #4
    //   1641: iload #5
    //   1643: ifne -> 1656
    //   1646: aload_0
    //   1647: aload #13
    //   1649: invokespecial saveImageBuffer2Picture : ([B)V
    //   1652: iload #5
    //   1654: istore #4
    //   1656: iload #7
    //   1658: aload_0
    //   1659: getfield mCustomEvent : I
    //   1662: if_icmpne -> 1670
    //   1665: aload_0
    //   1666: iconst_0
    //   1667: putfield mCustomEvent : I
    //   1670: aload_0
    //   1671: getfield TAG : Ljava/lang/String;
    //   1674: ldc_w 'processTexture result: %d'
    //   1677: iconst_1
    //   1678: anewarray java/lang/Object
    //   1681: dup
    //   1682: iconst_0
    //   1683: iload #4
    //   1685: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1688: aastore
    //   1689: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1692: pop
    //   1693: aload_0
    //   1694: getfield TAG : Ljava/lang/String;
    //   1697: ldc_w 'sticker cost time: %d'
    //   1700: iconst_1
    //   1701: anewarray java/lang/Object
    //   1704: dup
    //   1705: iconst_0
    //   1706: invokestatic currentTimeMillis : ()J
    //   1709: lload #8
    //   1711: lsub
    //   1712: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1715: aastore
    //   1716: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1719: pop
    //   1720: iload #4
    //   1722: ifne -> 1735
    //   1725: aload_0
    //   1726: aload_0
    //   1727: getfield mTextureOutId : [I
    //   1730: iconst_0
    //   1731: iaload
    //   1732: putfield mInputTextureId : I
    //   1735: aload_0
    //   1736: getfield DEBUG : Z
    //   1739: ifeq -> 2238
    //   1742: aload_0
    //   1743: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1746: astore_1
    //   1747: aload_1
    //   1748: ifnull -> 1890
    //   1751: aload_1
    //   1752: invokevirtual getImage : ()Lcom/sensetime/stmobile/model/STImage;
    //   1755: ifnull -> 1783
    //   1758: aload_0
    //   1759: getfield TAG : Ljava/lang/String;
    //   1762: ldc_w 'human action background result: %d'
    //   1765: iconst_1
    //   1766: anewarray java/lang/Object
    //   1769: dup
    //   1770: iconst_0
    //   1771: iconst_1
    //   1772: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1775: aastore
    //   1776: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1779: pop
    //   1780: goto -> 1805
    //   1783: aload_0
    //   1784: getfield TAG : Ljava/lang/String;
    //   1787: ldc_w 'human action background result: %d'
    //   1790: iconst_1
    //   1791: anewarray java/lang/Object
    //   1794: dup
    //   1795: iconst_0
    //   1796: iconst_0
    //   1797: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1800: aastore
    //   1801: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1804: pop
    //   1805: aload_0
    //   1806: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1809: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1812: ifnull -> 1865
    //   1815: aload_0
    //   1816: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1819: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1822: arraylength
    //   1823: ifle -> 1865
    //   1826: aload_0
    //   1827: aload_0
    //   1828: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1831: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1834: iconst_0
    //   1835: aaload
    //   1836: getfield handAction : J
    //   1839: putfield mHandAction : J
    //   1842: aload_0
    //   1843: getfield mHandler : Landroid/os/Handler;
    //   1846: sipush #141
    //   1849: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1852: astore_1
    //   1853: aload_0
    //   1854: getfield mHandler : Landroid/os/Handler;
    //   1857: aload_1
    //   1858: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1861: pop
    //   1862: goto -> 1890
    //   1865: aload_0
    //   1866: lconst_0
    //   1867: putfield mHandAction : J
    //   1870: aload_0
    //   1871: getfield mHandler : Landroid/os/Handler;
    //   1874: sipush #142
    //   1877: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1880: astore_1
    //   1881: aload_0
    //   1882: getfield mHandler : Landroid/os/Handler;
    //   1885: aload_1
    //   1886: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1889: pop
    //   1890: aload_0
    //   1891: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1894: astore_1
    //   1895: aload_1
    //   1896: ifnull -> 2238
    //   1899: aload_1
    //   1900: getfield faceCount : I
    //   1903: ifle -> 1969
    //   1906: iconst_0
    //   1907: istore #4
    //   1909: iload #4
    //   1911: aload_0
    //   1912: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1915: getfield faceCount : I
    //   1918: if_icmpge -> 1969
    //   1921: aload_0
    //   1922: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1925: iload #4
    //   1927: aload_0
    //   1928: getfield mImageWidth : I
    //   1931: aload_0
    //   1932: getfield mImageHeight : I
    //   1935: invokestatic a : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1938: astore_1
    //   1939: aload_1
    //   1940: ifnull -> 1960
    //   1943: aload_1
    //   1944: arraylength
    //   1945: ifle -> 1960
    //   1948: aload_0
    //   1949: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1952: aload_0
    //   1953: getfield mInputTextureId : I
    //   1956: aload_1
    //   1957: invokevirtual onDrawPoints : (I[F)V
    //   1960: iload #4
    //   1962: iconst_1
    //   1963: iadd
    //   1964: istore #4
    //   1966: goto -> 1909
    //   1969: aload_0
    //   1970: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1973: getfield faceCount : I
    //   1976: ifle -> 2042
    //   1979: iconst_0
    //   1980: istore #4
    //   1982: iload #4
    //   1984: aload_0
    //   1985: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1988: getfield faceCount : I
    //   1991: if_icmpge -> 2042
    //   1994: aload_0
    //   1995: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1998: iload #4
    //   2000: aload_0
    //   2001: getfield mImageWidth : I
    //   2004: aload_0
    //   2005: getfield mImageHeight : I
    //   2008: invokestatic b : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   2011: astore_1
    //   2012: aload_1
    //   2013: ifnull -> 2033
    //   2016: aload_1
    //   2017: arraylength
    //   2018: ifle -> 2033
    //   2021: aload_0
    //   2022: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2025: aload_0
    //   2026: getfield mInputTextureId : I
    //   2029: aload_1
    //   2030: invokevirtual onDrawPoints : (I[F)V
    //   2033: iload #4
    //   2035: iconst_1
    //   2036: iadd
    //   2037: istore #4
    //   2039: goto -> 1982
    //   2042: aload_0
    //   2043: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2046: getfield bodyCount : I
    //   2049: ifle -> 2215
    //   2052: iconst_0
    //   2053: istore #4
    //   2055: iload #4
    //   2057: aload_0
    //   2058: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2061: getfield bodyCount : I
    //   2064: if_icmpge -> 2115
    //   2067: aload_0
    //   2068: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2071: iload #4
    //   2073: aload_0
    //   2074: getfield mImageWidth : I
    //   2077: aload_0
    //   2078: getfield mImageHeight : I
    //   2081: invokestatic c : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   2084: astore_1
    //   2085: aload_1
    //   2086: ifnull -> 2106
    //   2089: aload_1
    //   2090: arraylength
    //   2091: ifle -> 2106
    //   2094: aload_0
    //   2095: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2098: aload_0
    //   2099: getfield mInputTextureId : I
    //   2102: aload_1
    //   2103: invokevirtual onDrawPoints : (I[F)V
    //   2106: iload #4
    //   2108: iconst_1
    //   2109: iadd
    //   2110: istore #4
    //   2112: goto -> 2055
    //   2115: aload_0
    //   2116: aload_0
    //   2117: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2120: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   2123: iconst_0
    //   2124: aaload
    //   2125: getfield bodyAction : J
    //   2128: putfield mBodyAction : J
    //   2131: aload_0
    //   2132: getfield TAG : Ljava/lang/String;
    //   2135: ldc_w 'human action body count: %d'
    //   2138: iconst_1
    //   2139: anewarray java/lang/Object
    //   2142: dup
    //   2143: iconst_0
    //   2144: aload_0
    //   2145: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2148: getfield bodyCount : I
    //   2151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   2154: aastore
    //   2155: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2158: pop
    //   2159: aload_0
    //   2160: getfield TAG : Ljava/lang/String;
    //   2163: ldc_w 'human action body[0] action: %d'
    //   2166: iconst_1
    //   2167: anewarray java/lang/Object
    //   2170: dup
    //   2171: iconst_0
    //   2172: aload_0
    //   2173: getfield rotatedHumanAction : Lcom/sensetime/stmobile/model/STHumanAction;
    //   2176: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   2179: iconst_0
    //   2180: aaload
    //   2181: getfield bodyAction : J
    //   2184: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2187: aastore
    //   2188: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2191: pop
    //   2192: aload_0
    //   2193: getfield mHandler : Landroid/os/Handler;
    //   2196: sipush #143
    //   2199: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   2202: astore_1
    //   2203: aload_0
    //   2204: getfield mHandler : Landroid/os/Handler;
    //   2207: aload_1
    //   2208: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   2211: pop
    //   2212: goto -> 2220
    //   2215: aload_0
    //   2216: lconst_0
    //   2217: putfield mBodyAction : J
    //   2220: ldc_w 36160
    //   2223: iconst_0
    //   2224: invokestatic glBindFramebuffer : (II)V
    //   2227: goto -> 2238
    //   2230: astore #13
    //   2232: aload_1
    //   2233: monitorexit
    //   2234: aload #13
    //   2236: athrow
    //   2237: return
    //   2238: aload_0
    //   2239: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   2242: astore_1
    //   2243: aload_0
    //   2244: getfield mFilterStyle : Ljava/lang/String;
    //   2247: astore #13
    //   2249: aload_1
    //   2250: aload #13
    //   2252: if_acmpeq -> 2273
    //   2255: aload_0
    //   2256: aload #13
    //   2258: putfield mCurrentFilterStyle : Ljava/lang/String;
    //   2261: aload_0
    //   2262: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2265: aload_0
    //   2266: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   2269: invokevirtual setStyle : (Ljava/lang/String;)I
    //   2272: pop
    //   2273: aload_0
    //   2274: getfield mCurrentFilterStrength : F
    //   2277: fstore_2
    //   2278: aload_0
    //   2279: getfield mFilterStrength : F
    //   2282: fstore_3
    //   2283: fload_2
    //   2284: fload_3
    //   2285: fcmpl
    //   2286: ifeq -> 2307
    //   2289: aload_0
    //   2290: fload_3
    //   2291: putfield mCurrentFilterStrength : F
    //   2294: aload_0
    //   2295: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2298: iconst_0
    //   2299: aload_0
    //   2300: getfield mCurrentFilterStrength : F
    //   2303: invokevirtual setParam : (IF)I
    //   2306: pop
    //   2307: aload_0
    //   2308: getfield mFilterTextureOutId : [I
    //   2311: ifnonnull -> 2339
    //   2314: aload_0
    //   2315: iconst_1
    //   2316: newarray int
    //   2318: putfield mFilterTextureOutId : [I
    //   2321: aload_0
    //   2322: getfield mImageWidth : I
    //   2325: aload_0
    //   2326: getfield mImageHeight : I
    //   2329: aload_0
    //   2330: getfield mFilterTextureOutId : [I
    //   2333: sipush #3553
    //   2336: invokestatic a : (II[II)V
    //   2339: aload_0
    //   2340: getfield mNeedFilter : Z
    //   2343: ifeq -> 2495
    //   2346: invokestatic currentTimeMillis : ()J
    //   2349: lstore #8
    //   2351: aload_0
    //   2352: getfield mNeedFilterOutputBuffer : Z
    //   2355: ifne -> 2388
    //   2358: aload_0
    //   2359: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2362: aload_0
    //   2363: getfield mInputTextureId : I
    //   2366: aload_0
    //   2367: getfield mImageWidth : I
    //   2370: aload_0
    //   2371: getfield mImageHeight : I
    //   2374: aload_0
    //   2375: getfield mFilterTextureOutId : [I
    //   2378: iconst_0
    //   2379: iaload
    //   2380: invokevirtual processTexture : (IIII)I
    //   2383: istore #4
    //   2385: goto -> 2453
    //   2388: aload_0
    //   2389: getfield mImageWidth : I
    //   2392: istore #4
    //   2394: aload_0
    //   2395: getfield mImageHeight : I
    //   2398: istore #5
    //   2400: iload #4
    //   2402: iload #5
    //   2404: imul
    //   2405: iconst_4
    //   2406: imul
    //   2407: newarray byte
    //   2409: astore_1
    //   2410: aload_0
    //   2411: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2414: aload_0
    //   2415: getfield mInputTextureId : I
    //   2418: iload #4
    //   2420: iload #5
    //   2422: aload_0
    //   2423: getfield mFilterTextureOutId : [I
    //   2426: iconst_0
    //   2427: iaload
    //   2428: aload_1
    //   2429: bipush #6
    //   2431: invokevirtual processTextureAndOutputBuffer : (IIII[BI)I
    //   2434: istore #4
    //   2436: aload_0
    //   2437: getfield mNeedSave : Z
    //   2440: ifeq -> 2453
    //   2443: iload #4
    //   2445: ifne -> 2453
    //   2448: aload_0
    //   2449: aload_1
    //   2450: invokespecial saveImageBuffer2Picture : ([B)V
    //   2453: aload_0
    //   2454: getfield TAG : Ljava/lang/String;
    //   2457: ldc_w 'filters cost time: %d'
    //   2460: iconst_1
    //   2461: anewarray java/lang/Object
    //   2464: dup
    //   2465: iconst_0
    //   2466: invokestatic currentTimeMillis : ()J
    //   2469: lload #8
    //   2471: lsub
    //   2472: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2475: aastore
    //   2476: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2479: pop
    //   2480: iload #4
    //   2482: ifne -> 2495
    //   2485: aload_0
    //   2486: aload_0
    //   2487: getfield mFilterTextureOutId : [I
    //   2490: iconst_0
    //   2491: iaload
    //   2492: putfield mInputTextureId : I
    //   2495: aload_0
    //   2496: getfield TAG : Ljava/lang/String;
    //   2499: ldc_w 'frame cost time total: %d'
    //   2502: iconst_1
    //   2503: anewarray java/lang/Object
    //   2506: dup
    //   2507: iconst_0
    //   2508: invokestatic currentTimeMillis : ()J
    //   2511: aload_0
    //   2512: getfield mStartTime : J
    //   2515: lsub
    //   2516: aload_0
    //   2517: getfield mRotateCost : J
    //   2520: ladd
    //   2521: aload_0
    //   2522: getfield mObjectCost : J
    //   2525: ladd
    //   2526: aload_0
    //   2527: getfield mFaceAttributeCost : J
    //   2530: ldc2_w 20
    //   2533: ldiv
    //   2534: ladd
    //   2535: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2538: aastore
    //   2539: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2542: pop
    //   2543: aload_0
    //   2544: getfield mNeedSave : Z
    //   2547: ifeq -> 2563
    //   2550: aload_0
    //   2551: aload_0
    //   2552: getfield mInputTextureId : I
    //   2555: invokespecial savePicture : (I)V
    //   2558: aload_0
    //   2559: iconst_0
    //   2560: putfield mNeedSave : Z
    //   2563: aload_0
    //   2564: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2567: ifnull -> 2650
    //   2570: invokestatic glFinish : ()V
    //   2573: aload_0
    //   2574: getfield mVideoEncoderTexture : [I
    //   2577: iconst_0
    //   2578: aload_0
    //   2579: getfield mInputTextureId : I
    //   2582: iastore
    //   2583: aload_0
    //   2584: aload_0
    //   2585: getfield mStMatrix : [F
    //   2588: invokespecial processStMatrix : ([F)V
    //   2591: aload_0
    //   2592: monitorenter
    //   2593: aload_0
    //   2594: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2597: ifnull -> 2640
    //   2600: aload_0
    //   2601: getfield mNeedResetEglContext : Z
    //   2604: ifeq -> 2628
    //   2607: aload_0
    //   2608: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2611: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
    //   2614: aload_0
    //   2615: getfield mVideoEncoderTexture : [I
    //   2618: iconst_0
    //   2619: iaload
    //   2620: invokevirtual a : (Landroid/opengl/EGLContext;I)V
    //   2623: aload_0
    //   2624: iconst_0
    //   2625: putfield mNeedResetEglContext : Z
    //   2628: aload_0
    //   2629: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2632: aload_0
    //   2633: getfield mStMatrix : [F
    //   2636: invokevirtual a : ([F)Z
    //   2639: pop
    //   2640: aload_0
    //   2641: monitorexit
    //   2642: goto -> 2650
    //   2645: astore_1
    //   2646: aload_0
    //   2647: monitorexit
    //   2648: aload_1
    //   2649: athrow
    //   2650: aload_0
    //   2651: invokestatic currentTimeMillis : ()J
    //   2654: aload_0
    //   2655: getfield mStartTime : J
    //   2658: lsub
    //   2659: aload_0
    //   2660: getfield mRotateCost : J
    //   2663: ladd
    //   2664: aload_0
    //   2665: getfield mObjectCost : J
    //   2668: ladd
    //   2669: aload_0
    //   2670: getfield mFaceAttributeCost : J
    //   2673: ldc2_w 20
    //   2676: ldiv
    //   2677: ladd
    //   2678: l2i
    //   2679: putfield mFrameCost : I
    //   2682: invokestatic currentTimeMillis : ()J
    //   2685: lstore #8
    //   2687: aload_0
    //   2688: aload_0
    //   2689: getfield mCount : I
    //   2692: iconst_1
    //   2693: iadd
    //   2694: putfield mCount : I
    //   2697: aload_0
    //   2698: getfield mIsFirstCount : Z
    //   2701: ifeq -> 2718
    //   2704: aload_0
    //   2705: lload #8
    //   2707: putfield mCurrentTime : J
    //   2710: aload_0
    //   2711: iconst_0
    //   2712: putfield mIsFirstCount : Z
    //   2715: goto -> 2764
    //   2718: lload #8
    //   2720: aload_0
    //   2721: getfield mCurrentTime : J
    //   2724: lsub
    //   2725: l2i
    //   2726: istore #4
    //   2728: iload #4
    //   2730: sipush #1000
    //   2733: if_icmplt -> 2764
    //   2736: aload_0
    //   2737: lload #8
    //   2739: putfield mCurrentTime : J
    //   2742: aload_0
    //   2743: aload_0
    //   2744: getfield mCount : I
    //   2747: i2f
    //   2748: ldc_w 1000.0
    //   2751: fmul
    //   2752: iload #4
    //   2754: i2f
    //   2755: fdiv
    //   2756: putfield mFps : F
    //   2759: aload_0
    //   2760: iconst_0
    //   2761: putfield mCount : I
    //   2764: aload_0
    //   2765: getfield TAG : Ljava/lang/String;
    //   2768: ldc_w 'render fps: %f'
    //   2771: iconst_1
    //   2772: anewarray java/lang/Object
    //   2775: dup
    //   2776: iconst_0
    //   2777: aload_0
    //   2778: getfield mFps : F
    //   2781: invokestatic valueOf : (F)Ljava/lang/Float;
    //   2784: aastore
    //   2785: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2788: pop
    //   2789: iconst_0
    //   2790: iconst_0
    //   2791: aload_0
    //   2792: getfield mSurfaceWidth : I
    //   2795: aload_0
    //   2796: getfield mSurfaceHeight : I
    //   2799: invokestatic glViewport : (IIII)V
    //   2802: aload_0
    //   2803: getfield mShowOriginal : Z
    //   2806: ifne -> 2822
    //   2809: aload_0
    //   2810: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2813: aload_0
    //   2814: getfield mInputTextureId : I
    //   2817: invokevirtual onDrawFrame : (I)I
    //   2820: pop
    //   2821: return
    //   2822: aload_0
    //   2823: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2826: iload #6
    //   2828: invokevirtual onDrawFrame : (I)I
    //   2831: pop
    //   2832: return
    //   2833: aload_0
    //   2834: aload_0
    //   2835: getfield renderFlag : Z
    //   2838: iconst_1
    //   2839: ixor
    //   2840: putfield renderFlag : Z
    //   2843: return
    // Exception table:
    //   from	to	target	type
    //   771	793	2230	finally
    //   798	805	808	java/lang/InterruptedException
    //   798	805	2230	finally
    //   810	815	2230	finally
    //   815	817	2230	finally
    //   2232	2234	2230	finally
    //   2593	2628	2645	finally
    //   2628	2640	2645	finally
    //   2640	2642	2645	finally
    //   2646	2648	2645	finally
  }
  
  public void onPause() {
    LogUtils.c(this.TAG, "onPause", new Object[0]);
    this.mSetPreViewSizeSucceed = false;
    this.mInited = false;
    this.mIsPaused = true;
    this.mImageData = null;
    this.renderFlag = false;
    int[] arrayOfInt = this.textureIdBuffer;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    byte[][] arrayOfByte = this.mDataBuffer;
    arrayOfByte[0] = null;
    arrayOfByte[1] = null;
    this.mFirstRender = true;
    this.frameBufferReady = false;
    this.mTextureInit = false;
    this.dectetStarted = false;
    this.mCameraProxy.b();
    LogUtils.b(this.TAG, "Release camera", new Object[0]);
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            CameraDisplayDoubleInputMultithread.this.mLBDQ.clear();
            CameraDisplayDoubleInputMultithread.this.queue.clear();
            CameraDisplayDoubleInputMultithread.this.mSTHumanActionNative.reset();
            CameraDisplayDoubleInputMultithread.this.mStBeautifyNative.destroyBeautify();
            CameraDisplayDoubleInputMultithread.this.mStStickerNative.removeAvatarModel();
            CameraDisplayDoubleInputMultithread.this.mStStickerNative.destroyInstance();
            CameraDisplayDoubleInputMultithread.this.mSTMobileStreamFilterNative.destroyInstance();
            CameraDisplayDoubleInputMultithread.this.mSTMobileMakeupNative.destroyInstance();
            CameraDisplayDoubleInputMultithread.access$3702(CameraDisplayDoubleInputMultithread.this, null);
            CameraDisplayDoubleInputMultithread.access$3802(CameraDisplayDoubleInputMultithread.this, null);
            CameraDisplayDoubleInputMultithread.this.deleteTextures();
            if (CameraDisplayDoubleInputMultithread.this.mSurfaceTexture != null)
              CameraDisplayDoubleInputMultithread.this.mSurfaceTexture.release(); 
            CameraDisplayDoubleInputMultithread.this.mGLRender.destroyFrameBuffers();
          }
        });
    this.mGlSurfaceView.onPause();
  }
  
  public void onResume() {
    LogUtils.c(this.TAG, "onResume", new Object[0]);
    if (this.mCameraProxy.a() == null) {
      if (this.mCameraProxy.g() == 1)
        this.mCameraID = 0; 
      this.mCameraProxy.a(this.mCameraID);
      this.mSupportedPreviewSizes = this.mCameraProxy.a(new String[] { "640x480", "1280x720" });
    } 
    this.mIsPaused = false;
    this.mSetPreViewSizeSucceed = false;
    this.mNeedResetEglContext = true;
    this.mTextureInit = false;
    this.mGLRender = new STGLRender();
    this.mGlSurfaceView.onResume();
    this.mGlSurfaceView.forceLayout();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {
    LogUtils.c(this.TAG, "onSurfaceChanged", new Object[0]);
    if (this.mIsPaused == true)
      return; 
    adjustViewPort(paramInt1, paramInt2);
    if (this.mInited)
      return; 
    this.mGLRender.init(this.mImageWidth, this.mImageHeight);
    this.mStartTime = System.currentTimeMillis();
    setUpTexture();
    this.mInited = true;
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {
    LogUtils.c(this.TAG, "onSurfaceCreated", new Object[0]);
    if (this.mIsPaused == true)
      return; 
    GLES20.glEnable(3024);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glEnable(2929);
    while (!this.mCameraProxy.i()) {
      if (this.mCameraProxy.h())
        return; 
      try {
        Thread.sleep(10L, 0);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
    if (this.mCameraProxy.a() != null)
      setUpCamera(); 
    initBeauty();
    initSticker();
    initFilter();
    initMakeup();
  }
  
  public void removeAllStickers() {
    this.mChangeStickerManagerHandler.removeMessages(1005);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1005);
    this.mChangeStickerManagerHandler.sendMessage(message);
  }
  
  public void removeMakeupByType(int paramInt) {
    if (this.mSTMobileMakeupNative.removeMakeup(this.mMakeupPackageId[paramInt]) == 0)
      this.mMakeupPackageId[paramInt] = 0; 
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void removeSticker(int paramInt) {
    this.mChangeStickerManagerHandler.removeMessages(1004);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1004);
    message.obj = Integer.valueOf(paramInt);
    this.mChangeStickerManagerHandler.sendMessage(message);
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
  
  public void setExposureCompensation(int paramInt) {
    CameraProxy cameraProxy = this.mCameraProxy;
    if (cameraProxy != null)
      cameraProxy.b(paramInt); 
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
  
  public void setMakeupForType(int paramInt, String paramString) {
    this.mMakeupPackageId[paramInt] = this.mSTMobileMakeupNative.setMakeupForType(paramInt, paramString);
    if (this.mMakeupPackageId[paramInt] > 0)
      this.mCurrentMakeup[paramInt] = paramString; 
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void setMakeupForTypeFromAssets(int paramInt, String paramString) {
    this.mMakeupPackageId[paramInt] = this.mSTMobileMakeupNative.setMakeupForTypeFromAssetsFile(paramInt, paramString, this.mContext.getAssets());
    if (this.mMakeupPackageId[paramInt] > 0)
      this.mCurrentMakeup[paramInt] = paramString; 
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void setMeteringArea(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = new float[2];
    STUtils.a(paramFloat1, paramFloat2, this.mSurfaceWidth, this.mSurfaceHeight, this.mCameraID, this.mCameraProxy.d(), arrayOfFloat);
    Rect rect = STUtils.a(arrayOfFloat, this.mSurfaceWidth, this.mSurfaceHeight, 100);
    this.mCameraProxy.a(rect);
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
  
  public void setStrengthForType(int paramInt, float paramFloat) {
    if (paramInt == 4) {
      this.mSTMobileMakeupNative.setStrengthForType(paramInt, this.mMakeUpStrength * paramFloat);
      this.mMakeupStrength[paramInt] = paramFloat * this.mMakeUpStrength;
      return;
    } 
    this.mSTMobileMakeupNative.setStrengthForType(paramInt, paramFloat);
    this.mMakeupStrength[paramInt] = paramFloat;
  }
  
  public void setVideoEncoder(final MediaVideoEncoder encoder) {
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: monitorenter
            //   2: aload_0
            //   3: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   6: ifnull -> 38
            //   9: aload_0
            //   10: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;
            //   13: invokestatic access$5200 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;)[I
            //   16: ifnull -> 38
            //   19: aload_0
            //   20: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   23: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
            //   26: aload_0
            //   27: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;
            //   30: invokestatic access$5200 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;)[I
            //   33: iconst_0
            //   34: iaload
            //   35: invokevirtual a : (Landroid/opengl/EGLContext;I)V
            //   38: aload_0
            //   39: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;
            //   42: aload_0
            //   43: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   46: invokestatic access$5302 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInputMultithread;Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;)Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   49: pop
            //   50: aload_0
            //   51: monitorexit
            //   52: return
            //   53: astore_1
            //   54: aload_0
            //   55: monitorexit
            //   56: aload_1
            //   57: athrow
            // Exception table:
            //   from	to	target	type
            //   2	38	53	finally
            //   38	52	53	finally
            //   54	56	53	finally
          }
        });
  }
  
  public void switchCamera() {
    if (Camera.getNumberOfCameras() != 1) {
      if (this.mCameraChanging)
        return; 
      this.renderFlag = false;
      int[] arrayOfInt = this.textureIdBuffer;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      byte[][] arrayOfByte = this.mDataBuffer;
      arrayOfByte[0] = null;
      arrayOfByte[1] = null;
      this.mFirstRender = true;
      final int cameraID = 1 - this.mCameraID;
      this.mCameraChanging = true;
      this.mCameraProxy.a(i);
      if (this.mCameraProxy.h())
        return; 
      this.mSetPreViewSizeSucceed = false;
      if (this.mNeedObject) {
        resetIndexRect();
      } else {
        Message message = this.mHandler.obtainMessage(130);
        this.mHandler.sendMessage(message);
      } 
      this.mGlSurfaceView.queueEvent(new Runnable() {
            public void run() {
              if (CameraDisplayDoubleInputMultithread.this.mRGBABuffer != null)
                CameraDisplayDoubleInputMultithread.this.mRGBABuffer.clear(); 
              CameraDisplayDoubleInputMultithread.access$3702(CameraDisplayDoubleInputMultithread.this, null);
              CameraDisplayDoubleInputMultithread.this.mLBDQ.clear();
              CameraDisplayDoubleInputMultithread.this.queue.clear();
              CameraDisplayDoubleInputMultithread.this.deleteCameraPreviewTexture();
              if (CameraDisplayDoubleInputMultithread.this.mCameraProxy.a() != null)
                CameraDisplayDoubleInputMultithread.this.setUpCamera(); 
              CameraDisplayDoubleInputMultithread.access$102(CameraDisplayDoubleInputMultithread.this, false);
              CameraDisplayDoubleInputMultithread.access$4302(CameraDisplayDoubleInputMultithread.this, cameraID);
            }
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\CameraDisplayDoubleInputMultithread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */