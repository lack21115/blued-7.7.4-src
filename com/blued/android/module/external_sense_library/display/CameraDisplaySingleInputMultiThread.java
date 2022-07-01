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
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.Constants;
import com.blued.android.module.external_sense_library.camera.CameraProxy;
import com.blued.android.module.external_sense_library.encoder.MediaVideoEncoder;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
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
import com.sensetime.stmobile.model.STTransParam;
import com.sensetime.stmobile.model.STTriggerEvent;
import com.sensetime.stmobile.sticker_module_types.STModuleInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraDisplaySingleInputMultiThread implements GLSurfaceView.Renderer {
  private static final int MESSAGE_ADD_SUB_MODEL = 1001;
  
  private static final int MESSAGE_NEED_ADD_STICKER = 1006;
  
  private static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
  
  private static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
  
  private static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
  
  private static final int MESSAGE_REMOVE_SUB_MODEL = 1002;
  
  private static final Object sDetectLock = new Object();
  
  private boolean DEBUG = false;
  
  private String TAG = "CameraDisplaySingleInputMultiThread";
  
  private float[] mBeautifyParams = new float[] { 
      0.36F, 0.74F, 0.02F, 0.13F, 0.11F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  private int[] mBeautifyTextureId;
  
  private long mBodyAction = 0L;
  
  private boolean mCameraChanging = false;
  
  private int mCameraID = 1;
  
  public CameraProxy mCameraProxy;
  
  private Handler mChangeStickerManagerHandler;
  
  private HandlerThread mChangeStickerManagerThread;
  
  private Context mContext;
  
  private int mCount = 0;
  
  private float mCurrentFilterStrength = 0.65F;
  
  private String mCurrentFilterStyle;
  
  private String[] mCurrentMakeup = new String[9];
  
  private int mCurrentPreview = 0;
  
  private String mCurrentSticker;
  
  private TreeMap<Integer, String> mCurrentStickerMaps = new TreeMap<Integer, String>();
  
  private long mCurrentTime = 0L;
  
  private int mCustomEvent = 0;
  
  private long mDetectConfig = 0L;
  
  private int mDetectImageHeight;
  
  private int mDetectImageWidth;
  
  private ExecutorService mDetectThreadPool = Executors.newFixedThreadPool(1);
  
  private String mFaceAttribute;
  
  private long mFaceAttributeCost = 0L;
  
  private float mFaceDistance = 0.0F;
  
  private boolean[] mFaceExpressionResult;
  
  private float mFilterStrength = 0.65F;
  
  private String mFilterStyle;
  
  private int[] mFilterTextureOutId;
  
  private float mFps;
  
  private int mFrameCost = 0;
  
  private int mFrameCount = 0;
  
  private int mFrameIndex = 0;
  
  private STGLRender mGLRender;
  
  private GLSurfaceView mGlSurfaceView;
  
  private long mHandAction = 0L;
  
  private Handler mHandler;
  
  private STHumanAction mHumanActionBeautyOutput = new STHumanAction();
  
  private int mHumanActionCreateConfig = 131568;
  
  private Object mHumanActionHandleLock = new Object();
  
  private Queue<STHumanAction> mHumanActionQueue = new LinkedBlockingQueue<STHumanAction>();
  
  private float mHumanActionRatio = 1.0F;
  
  private int mImageHeight;
  
  private int mImageWidth;
  
  private Rect mIndexRect = new Rect();
  
  private boolean mIsChangingPreviewSize = false;
  
  private boolean mIsCreateHumanActionHandleSucceeded = false;
  
  private boolean mIsFirstCount = true;
  
  private boolean mIsObjectTracking = false;
  
  private boolean mIsPaused = false;
  
  private ChangePreviewSizeListener mListener;
  
  private float mMakeUpStrength = 0.7F;
  
  private int[] mMakeupPackageId = new int[9];
  
  private float[] mMakeupStrength = new float[9];
  
  private int[] mMakeupTextureId;
  
  private boolean mNeedAvatar = true;
  
  private boolean mNeedAvatarExpression = false;
  
  private boolean mNeedBeautify = false;
  
  private boolean mNeedDistance = true;
  
  private boolean mNeedFilter = false;
  
  private boolean mNeedMakeup = false;
  
  private boolean mNeedObject = false;
  
  private boolean mNeedResetEglContext = false;
  
  private boolean mNeedSave = false;
  
  private boolean mNeedSetObjectTarget = false;
  
  private boolean mNeedShowRect = true;
  
  private boolean mNeedSticker = false;
  
  private long mObjectCost = 0L;
  
  private SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() {
      public void onFrameAvailable(SurfaceTexture param1SurfaceTexture) {
        if (!CameraDisplaySingleInputMultiThread.this.mCameraChanging)
          CameraDisplaySingleInputMultiThread.this.mGlSurfaceView.requestRender(); 
      }
    };
  
  private int[] mOutputTextureId;
  
  private int mParamType = 0;
  
  private ByteBuffer[] mRGBABuffer;
  
  private long mRotateCost = 0L;
  
  private STMobileFaceAttributeNative mSTFaceAttributeNative = new STMobileFaceAttributeNative();
  
  private STMobileHumanActionNative mSTHumanActionNative = new STMobileHumanActionNative();
  
  private STMobileAvatarNative mSTMobileAvatarNative = new STMobileAvatarNative();
  
  private STMobileMakeupNative mSTMobileMakeupNative = new STMobileMakeupNative();
  
  private STMobileObjectTrackNative mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
  
  private STMobileStreamFilterNative mSTMobileStreamFilterNative = new STMobileStreamFilterNative();
  
  private int mScreenIndexRectWidth = 0;
  
  private SensorEvent mSensorEvent;
  
  private boolean mSetPreViewSizeSucceed = false;
  
  private boolean mShowOriginal = false;
  
  private STMobileAnimalNative mStAnimalNative = new STMobileAnimalNative();
  
  private STBeautifyNative mStBeautifyNative = new STBeautifyNative();
  
  private final float[] mStMatrix = new float[16];
  
  private STMobileStickerNative mStStickerNative = new STMobileStickerNative();
  
  private long mStartTime;
  
  private int[] mStickerTextureId;
  
  private Handler mSubModelsManagerHandler;
  
  private HandlerThread mSubModelsManagerThread;
  
  private ArrayList<String> mSupportedPreviewSizes;
  
  private int mSurfaceHeight;
  
  private SurfaceTexture mSurfaceTexture;
  
  private int mSurfaceWidth;
  
  private Rect mTargetRect = new Rect();
  
  private FloatBuffer mTextureBuffer;
  
  protected int mTextureId = -1;
  
  private MediaVideoEncoder mVideoEncoder;
  
  private int[] mVideoEncoderTexture;
  
  public CameraDisplaySingleInputMultiThread(Context paramContext, ChangePreviewSizeListener paramChangePreviewSizeListener, GLSurfaceView paramGLSurfaceView) {
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
    initObjectTrack();
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
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mBeautifyTextureId = null;
    } 
    arrayOfInt = this.mMakeupTextureId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mMakeupTextureId = null;
    } 
    arrayOfInt = this.mStickerTextureId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mStickerTextureId = null;
    } 
    arrayOfInt = this.mFilterTextureOutId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(2, arrayOfInt, 0);
      this.mFilterTextureOutId = null;
    } 
    arrayOfInt = this.mVideoEncoderTexture;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mVideoEncoderTexture = null;
    } 
  }
  
  private void drawPoints(STHumanAction paramSTHumanAction, int paramInt) {
    if (!GLES20.glIsTexture(paramInt)) {
      LogUtils.d(this.TAG, "draw point with invalid texture", new Object[0]);
      return;
    } 
    if (paramSTHumanAction != null) {
      if (paramSTHumanAction.faceCount > 0)
        for (int i = 0; i < paramSTHumanAction.faceCount; i++) {
          float[] arrayOfFloat = STUtils.a(paramSTHumanAction, i, this.mImageWidth, this.mImageHeight);
          if (arrayOfFloat != null && arrayOfFloat.length > 0)
            this.mGLRender.onDrawPoints(paramInt, arrayOfFloat); 
        }  
      if (paramSTHumanAction.bodyCount > 0) {
        for (int i = 0; i < paramSTHumanAction.bodyCount; i++) {
          float[] arrayOfFloat = STUtils.c(paramSTHumanAction, i, this.mImageWidth, this.mImageHeight);
          if (arrayOfFloat != null && arrayOfFloat.length > 0)
            this.mGLRender.onDrawPoints(paramInt, arrayOfFloat); 
        } 
        this.mBodyAction = (paramSTHumanAction.bodys[0]).bodyAction;
        LogUtils.c(this.TAG, "human action body count: %d", new Object[] { Integer.valueOf(paramSTHumanAction.bodyCount) });
        LogUtils.c(this.TAG, "human action body[0] action: %d", new Object[] { Long.valueOf((paramSTHumanAction.bodys[0]).bodyAction) });
        Message message = this.mHandler.obtainMessage(143);
        this.mHandler.sendMessage(message);
      } else {
        this.mBodyAction = 0L;
      } 
      GLES20.glBindFramebuffer(36160, 0);
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
    this.mSTMobileStreamFilterNative.createInstance();
    this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle);
    this.mCurrentFilterStrength = this.mFilterStrength;
    this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
  }
  
  private void initHandlerManager() {
    this.mSubModelsManagerThread = new HandlerThread("SubModelManagerThread");
    this.mSubModelsManagerThread.start();
    this.mSubModelsManagerHandler = new Handler(this.mSubModelsManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplaySingleInputMultiThread.this.mIsPaused && !CameraDisplaySingleInputMultiThread.this.mCameraChanging && CameraDisplaySingleInputMultiThread.this.mIsCreateHumanActionHandleSucceeded) {
            int i = param1Message.what;
            if (i != 1001) {
              if (i != 1002)
                return; 
              i = ((Integer)param1Message.obj).intValue();
              if (i != 0) {
                CameraDisplaySingleInputMultiThread.this.removeSubModel(i);
                return;
              } 
            } else {
              String str = (String)param1Message.obj;
              if (str != null)
                CameraDisplaySingleInputMultiThread.this.addSubModel(str); 
            } 
          } 
        }
      };
    this.mChangeStickerManagerThread = new HandlerThread("ChangeStickerManagerThread");
    this.mChangeStickerManagerThread.start();
    this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplaySingleInputMultiThread.this.mIsPaused && !CameraDisplaySingleInputMultiThread.this.mCameraChanging) {
            CameraDisplaySingleInputMultiThread cameraDisplaySingleInputMultiThread2;
            String str;
            CameraDisplaySingleInputMultiThread cameraDisplaySingleInputMultiThread1;
            Message message;
            int i;
            switch (param1Message.what) {
              default:
                return;
              case 1005:
                CameraDisplaySingleInputMultiThread.this.mStStickerNative.removeAllStickers();
                if (CameraDisplaySingleInputMultiThread.this.mCurrentStickerMaps != null)
                  CameraDisplaySingleInputMultiThread.this.mCurrentStickerMaps.clear(); 
                cameraDisplaySingleInputMultiThread2 = CameraDisplaySingleInputMultiThread.this;
                cameraDisplaySingleInputMultiThread2.setHumanActionDetectConfig(cameraDisplaySingleInputMultiThread2.mNeedBeautify, CameraDisplaySingleInputMultiThread.this.mStStickerNative.getTriggerAction(), CameraDisplaySingleInputMultiThread.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1003:
                str = (String)((Message)cameraDisplaySingleInputMultiThread2).obj;
                CameraDisplaySingleInputMultiThread.access$502(CameraDisplaySingleInputMultiThread.this, str);
                i = CameraDisplaySingleInputMultiThread.this.mStStickerNative.changeSticker(CameraDisplaySingleInputMultiThread.this.mCurrentSticker);
                cameraDisplaySingleInputMultiThread1 = CameraDisplaySingleInputMultiThread.this;
                CameraDisplaySingleInputMultiThread.access$702(cameraDisplaySingleInputMultiThread1, cameraDisplaySingleInputMultiThread1.mStStickerNative.getNeededInputParams());
                LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "change sticker result: %d", new Object[] { Integer.valueOf(i) });
                cameraDisplaySingleInputMultiThread1 = CameraDisplaySingleInputMultiThread.this;
                cameraDisplaySingleInputMultiThread1.setHumanActionDetectConfig(cameraDisplaySingleInputMultiThread1.mNeedBeautify, CameraDisplaySingleInputMultiThread.this.mStStickerNative.getTriggerAction(), CameraDisplaySingleInputMultiThread.this.mSTMobileMakeupNative.getTriggerAction());
                message = CameraDisplaySingleInputMultiThread.this.mHandler.obtainMessage(110);
                CameraDisplaySingleInputMultiThread.this.mHandler.sendMessage(message);
                break;
              case 1004:
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
            synchronized (CameraDisplaySingleInputMultiThread.this.mHumanActionHandleLock) {
              int i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), CameraDisplaySingleInputMultiThread.this.mHumanActionCreateConfig, CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
              LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "add hand model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Segment_1.5.0.model", CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "add figure segment model result: %d", new Object[] { Integer.valueOf(i) });
                CameraDisplaySingleInputMultiThread.access$202(CameraDisplaySingleInputMultiThread.this, true);
                CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.setParam(2, 0.35F);
                i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Face_Extra_5.23.0.model", CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "add face extra model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Iris_2.0.0.model", CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "add eyeball contour model result: %d", new Object[] { Integer.valueOf(i) });
                if (CameraDisplaySingleInputMultiThread.this.mNeedAvatar) {
                  i = CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Avatar_Help_2.0.0.model", CameraDisplaySingleInputMultiThread.this.mContext.getAssets());
                  LogUtils.c(CameraDisplaySingleInputMultiThread.this.TAG, "add avatar help model result: %d", new Object[] { Integer.valueOf(i) });
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  private void initObjectTrack() {
    this.mSTMobileObjectTrackNative.createInstance();
  }
  
  private void initSticker() {
    int i = this.mStStickerNative.createInstance(this.mContext);
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
    LogUtils.c(this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
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
  
  private void processStMatrix(float[] paramArrayOffloat, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1 && paramArrayOffloat != null && paramArrayOffloat.length == 16) {
      int i;
      for (i = 0; i < 3; i++) {
        int j = i * 4;
        paramArrayOffloat[j] = -paramArrayOffloat[j];
      } 
      if (paramArrayOffloat[12] == 0.0F) {
        paramArrayOffloat[12] = 1.0F;
      } else if (paramArrayOffloat[12] == 1.0F) {
        paramArrayOffloat[12] = 0.0F;
      } 
    } 
    if (paramBoolean2 && paramArrayOffloat != null && paramArrayOffloat.length == 16) {
      paramArrayOffloat[0] = 1.0F;
      paramArrayOffloat[5] = -1.0F;
      paramArrayOffloat[12] = 0.0F;
      paramArrayOffloat[13] = 1.0F;
    } 
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
      return;
    } 
    this.mDetectConfig = paramLong1 | paramLong2;
  }
  
  private void setUpCamera() {
    if (this.mTextureId == -1) {
      this.mTextureId = OpenGLUtils.a();
      this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
      this.mSurfaceTexture.setOnFrameAvailableListener(this.mOnFrameAvailableListener);
    } 
    String str = this.mSupportedPreviewSizes.get(this.mCurrentPreview);
    int i = str.indexOf('x');
    this.mImageHeight = Integer.parseInt(str.substring(0, i));
    this.mImageWidth = Integer.parseInt(str.substring(i + 1));
    i = this.mImageWidth;
    int j = this.mImageHeight;
    if (i >= j) {
      this.mHumanActionRatio = i / 640.0F;
      this.mDetectImageWidth = 640;
      this.mDetectImageHeight = j * this.mDetectImageWidth / i;
    } else {
      this.mHumanActionRatio = j / 640.0F;
      this.mDetectImageHeight = 640;
      this.mDetectImageWidth = i * this.mDetectImageHeight / j;
    } 
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
      this.mFrameIndex = 0;
      this.mCameraProxy.a(this.mSurfaceTexture, null);
      return;
    } 
  }
  
  private void updateFaceExpressionInfo(STHumanAction paramSTHumanAction) {
    if (paramSTHumanAction != null && paramSTHumanAction.faceCount > 0) {
      boolean bool;
      long l = System.currentTimeMillis();
      int i = getCurrentOrientation();
      if (this.mCameraID == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      this.mFaceExpressionResult = STMobileHumanActionNative.getExpression(paramSTHumanAction, i, bool);
      LogUtils.c(this.TAG, "face expression cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      Message message = this.mHandler.obtainMessage(140);
      this.mHandler.sendMessage(message);
      return;
    } 
    this.mFaceExpressionResult = null;
  }
  
  private void updateHandInfo(STHumanAction paramSTHumanAction) {
    if (paramSTHumanAction != null) {
      if (paramSTHumanAction.hands != null && paramSTHumanAction.hands.length > 0) {
        this.mHandAction = (paramSTHumanAction.hands[0]).handAction;
        Message message1 = this.mHandler.obtainMessage(141);
        this.mHandler.sendMessage(message1);
        return;
      } 
      this.mHandAction = 0L;
      Message message = this.mHandler.obtainMessage(142);
      this.mHandler.sendMessage(message);
    } 
  }
  
  public int addSticker(String paramString) {
    this.mCurrentSticker = paramString;
    int i = this.mStStickerNative.addSticker(this.mCurrentSticker);
    if (i > 0) {
      this.mParamType = this.mStStickerNative.getNeededInputParams();
      TreeMap<Integer, String> treeMap = this.mCurrentStickerMaps;
      if (treeMap != null)
        treeMap.put(Integer.valueOf(i), this.mCurrentSticker); 
      setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
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
      this.mCurrentPreview = paramInt;
      this.mSetPreViewSizeSucceed = false;
      this.mIsChangingPreviewSize = true;
      this.mCameraChanging = true;
      this.mCameraProxy.c();
      this.mGlSurfaceView.queueEvent(new Runnable() {
            public void run() {
              if (CameraDisplaySingleInputMultiThread.this.mRGBABuffer != null) {
                CameraDisplaySingleInputMultiThread.this.mRGBABuffer[0].clear();
                CameraDisplaySingleInputMultiThread.this.mRGBABuffer[1].clear();
              } 
              CameraDisplaySingleInputMultiThread.access$1902(CameraDisplaySingleInputMultiThread.this, null);
              CameraDisplaySingleInputMultiThread.this.deleteTextures();
              if (CameraDisplaySingleInputMultiThread.this.mCameraProxy.a() != null)
                CameraDisplaySingleInputMultiThread.this.setUpCamera(); 
              CameraDisplaySingleInputMultiThread.this.mGLRender.init(CameraDisplaySingleInputMultiThread.this.mImageWidth, CameraDisplaySingleInputMultiThread.this.mImageHeight, CameraDisplaySingleInputMultiThread.this.mDetectImageWidth, CameraDisplaySingleInputMultiThread.this.mDetectImageHeight);
              if (CameraDisplaySingleInputMultiThread.this.DEBUG)
                CameraDisplaySingleInputMultiThread.this.mGLRender.initDrawPoints(); 
              if (CameraDisplaySingleInputMultiThread.this.mNeedObject)
                CameraDisplaySingleInputMultiThread.this.resetIndexRect(); 
              CameraDisplaySingleInputMultiThread.this.mGLRender.calculateVertexBuffer(CameraDisplaySingleInputMultiThread.this.mSurfaceWidth, CameraDisplaySingleInputMultiThread.this.mSurfaceHeight, CameraDisplaySingleInputMultiThread.this.mImageWidth, CameraDisplaySingleInputMultiThread.this.mImageHeight);
              if (CameraDisplaySingleInputMultiThread.this.mListener != null)
                CameraDisplaySingleInputMultiThread.this.mListener.onChangePreviewSize(CameraDisplaySingleInputMultiThread.this.mImageHeight, CameraDisplaySingleInputMultiThread.this.mImageWidth); 
              CameraDisplaySingleInputMultiThread.access$102(CameraDisplaySingleInputMultiThread.this, false);
              CameraDisplaySingleInputMultiThread.access$4602(CameraDisplaySingleInputMultiThread.this, false);
              CameraDisplaySingleInputMultiThread.this.mGlSurfaceView.requestRender();
              LogUtils.b(CameraDisplaySingleInputMultiThread.this.TAG, "exit  change Preview size queue event", new Object[0]);
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void enableObject(boolean paramBoolean) {
    this.mNeedObject = paramBoolean;
    if (this.mNeedObject)
      resetIndexRect(); 
  }
  
  public void enableSticker(boolean paramBoolean) {
    this.mNeedSticker = paramBoolean;
    if (!paramBoolean)
      setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction()); 
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
  
  public int getCameraID() {
    return this.mCameraID;
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
      return;
    } 
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCameraChanging : Z
    //   4: ifeq -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   12: invokevirtual a : ()Landroid/hardware/Camera;
    //   15: ifnonnull -> 19
    //   18: return
    //   19: aload_0
    //   20: getfield mFrameIndex : I
    //   23: iconst_2
    //   24: irem
    //   25: istore #5
    //   27: aload_0
    //   28: getfield TAG : Ljava/lang/String;
    //   31: astore_1
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #14
    //   41: aload #14
    //   43: ldc_w 'frame index='
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #14
    //   52: aload_0
    //   53: getfield mFrameIndex : I
    //   56: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #14
    //   62: ldc_w ';doubleBufIndex='
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #14
    //   71: iload #5
    //   73: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_1
    //   78: aload #14
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: iconst_0
    //   84: anewarray java/lang/Object
    //   87: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   90: pop
    //   91: aload_0
    //   92: getfield TAG : Ljava/lang/String;
    //   95: ldc_w 'onDrawFrame'
    //   98: iconst_0
    //   99: anewarray java/lang/Object
    //   102: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   105: pop
    //   106: aload_0
    //   107: getfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   110: ifnonnull -> 161
    //   113: aload_0
    //   114: iconst_2
    //   115: anewarray java/nio/ByteBuffer
    //   118: putfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   121: aload_0
    //   122: getfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   125: iconst_0
    //   126: aload_0
    //   127: getfield mDetectImageHeight : I
    //   130: aload_0
    //   131: getfield mDetectImageWidth : I
    //   134: imul
    //   135: iconst_4
    //   136: imul
    //   137: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   140: aastore
    //   141: aload_0
    //   142: getfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   145: iconst_1
    //   146: aload_0
    //   147: getfield mDetectImageHeight : I
    //   150: aload_0
    //   151: getfield mDetectImageWidth : I
    //   154: imul
    //   155: iconst_4
    //   156: imul
    //   157: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   160: aastore
    //   161: aload_0
    //   162: getfield mBeautifyTextureId : [I
    //   165: ifnonnull -> 193
    //   168: aload_0
    //   169: iconst_2
    //   170: newarray int
    //   172: putfield mBeautifyTextureId : [I
    //   175: aload_0
    //   176: getfield mImageWidth : I
    //   179: aload_0
    //   180: getfield mImageHeight : I
    //   183: aload_0
    //   184: getfield mBeautifyTextureId : [I
    //   187: sipush #3553
    //   190: invokestatic a : (II[II)V
    //   193: aload_0
    //   194: getfield mMakeupTextureId : [I
    //   197: ifnonnull -> 225
    //   200: aload_0
    //   201: iconst_2
    //   202: newarray int
    //   204: putfield mMakeupTextureId : [I
    //   207: aload_0
    //   208: getfield mImageWidth : I
    //   211: aload_0
    //   212: getfield mImageHeight : I
    //   215: aload_0
    //   216: getfield mMakeupTextureId : [I
    //   219: sipush #3553
    //   222: invokestatic a : (II[II)V
    //   225: aload_0
    //   226: getfield mStickerTextureId : [I
    //   229: ifnonnull -> 257
    //   232: aload_0
    //   233: iconst_2
    //   234: newarray int
    //   236: putfield mStickerTextureId : [I
    //   239: aload_0
    //   240: getfield mImageWidth : I
    //   243: aload_0
    //   244: getfield mImageHeight : I
    //   247: aload_0
    //   248: getfield mStickerTextureId : [I
    //   251: sipush #3553
    //   254: invokestatic a : (II[II)V
    //   257: aload_0
    //   258: getfield mOutputTextureId : [I
    //   261: ifnonnull -> 271
    //   264: aload_0
    //   265: iconst_2
    //   266: newarray int
    //   268: putfield mOutputTextureId : [I
    //   271: aload_0
    //   272: getfield mVideoEncoderTexture : [I
    //   275: ifnonnull -> 285
    //   278: aload_0
    //   279: iconst_2
    //   280: newarray int
    //   282: putfield mVideoEncoderTexture : [I
    //   285: aload_0
    //   286: getfield mSurfaceTexture : Landroid/graphics/SurfaceTexture;
    //   289: astore_1
    //   290: aload_1
    //   291: ifnull -> 2015
    //   294: aload_0
    //   295: getfield mIsPaused : Z
    //   298: ifne -> 2015
    //   301: aload_1
    //   302: invokevirtual updateTexImage : ()V
    //   305: aload_0
    //   306: invokestatic currentTimeMillis : ()J
    //   309: putfield mStartTime : J
    //   312: fconst_0
    //   313: fconst_0
    //   314: fconst_0
    //   315: fconst_0
    //   316: invokestatic glClearColor : (FFFF)V
    //   319: sipush #16640
    //   322: invokestatic glClear : (I)V
    //   325: aload_0
    //   326: getfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   329: iload #5
    //   331: aaload
    //   332: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   335: pop
    //   336: invokestatic currentTimeMillis : ()J
    //   339: lstore #8
    //   341: aload_0
    //   342: getfield mOutputTextureId : [I
    //   345: iload #5
    //   347: aload_0
    //   348: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   351: aload_0
    //   352: getfield mTextureId : I
    //   355: aload_0
    //   356: getfield mRGBABuffer : [Ljava/nio/ByteBuffer;
    //   359: iload #5
    //   361: aaload
    //   362: iload #5
    //   364: invokevirtual preProcess : (ILjava/nio/ByteBuffer;I)I
    //   367: iastore
    //   368: aload_0
    //   369: getfield TAG : Ljava/lang/String;
    //   372: ldc_w 'preprocess cost time: %d'
    //   375: iconst_1
    //   376: anewarray java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: invokestatic currentTimeMillis : ()J
    //   384: lload #8
    //   386: lsub
    //   387: invokestatic valueOf : (J)Ljava/lang/Long;
    //   390: aastore
    //   391: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   394: pop
    //   395: iconst_m1
    //   396: istore #4
    //   398: aload_0
    //   399: getfield mShowOriginal : Z
    //   402: ifne -> 1643
    //   405: aload_0
    //   406: getfield mNeedBeautify : Z
    //   409: ifne -> 428
    //   412: aload_0
    //   413: getfield mNeedSticker : Z
    //   416: ifeq -> 422
    //   419: goto -> 428
    //   422: iconst_0
    //   423: istore #5
    //   425: goto -> 1349
    //   428: aload_0
    //   429: getfield mIsCreateHumanActionHandleSucceeded : Z
    //   432: ifeq -> 455
    //   435: aload_0
    //   436: getfield mDetectThreadPool : Ljava/util/concurrent/ExecutorService;
    //   439: new com/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread$4
    //   442: dup
    //   443: aload_0
    //   444: iload #5
    //   446: invokespecial <init> : (Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread;I)V
    //   449: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   454: pop
    //   455: aload_0
    //   456: invokespecial getCurrentOrientation : ()I
    //   459: istore #7
    //   461: aload_0
    //   462: getfield mHumanActionQueue : Ljava/util/Queue;
    //   465: invokeinterface peek : ()Ljava/lang/Object;
    //   470: checkcast com/sensetime/stmobile/model/STHumanAction
    //   473: astore_1
    //   474: aload_1
    //   475: ifnull -> 491
    //   478: aload_0
    //   479: getfield mHumanActionQueue : Ljava/util/Queue;
    //   482: invokeinterface remove : ()Ljava/lang/Object;
    //   487: pop
    //   488: goto -> 625
    //   491: aload_0
    //   492: getfield mFrameIndex : I
    //   495: istore #4
    //   497: iload #4
    //   499: ifne -> 511
    //   502: aload_0
    //   503: iload #4
    //   505: iconst_1
    //   506: iadd
    //   507: putfield mFrameIndex : I
    //   510: return
    //   511: getstatic com/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread.sDetectLock : Ljava/lang/Object;
    //   514: astore_1
    //   515: aload_1
    //   516: monitorenter
    //   517: getstatic com/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread.sDetectLock : Ljava/lang/Object;
    //   520: invokevirtual wait : ()V
    //   523: goto -> 538
    //   526: astore #14
    //   528: goto -> 1638
    //   531: astore #14
    //   533: aload #14
    //   535: invokevirtual printStackTrace : ()V
    //   538: aload_1
    //   539: monitorexit
    //   540: aload_0
    //   541: getfield mHumanActionQueue : Ljava/util/Queue;
    //   544: invokeinterface peek : ()Ljava/lang/Object;
    //   549: checkcast com/sensetime/stmobile/model/STHumanAction
    //   552: astore_1
    //   553: aload_1
    //   554: ifnonnull -> 615
    //   557: aload_0
    //   558: getfield TAG : Ljava/lang/String;
    //   561: astore_1
    //   562: new java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial <init> : ()V
    //   569: astore #14
    //   571: aload #14
    //   573: ldc_w 'no human action result at index='
    //   576: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload #14
    //   582: aload_0
    //   583: getfield mFrameIndex : I
    //   586: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_1
    //   591: aload #14
    //   593: invokevirtual toString : ()Ljava/lang/String;
    //   596: iconst_0
    //   597: anewarray java/lang/Object
    //   600: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   603: pop
    //   604: aload_0
    //   605: aload_0
    //   606: getfield mFrameIndex : I
    //   609: iconst_1
    //   610: iadd
    //   611: putfield mFrameIndex : I
    //   614: return
    //   615: aload_0
    //   616: getfield mHumanActionQueue : Ljava/util/Queue;
    //   619: invokeinterface remove : ()Ljava/lang/Object;
    //   624: pop
    //   625: aload_1
    //   626: getfield bufIndex : I
    //   629: istore #6
    //   631: aload_0
    //   632: getfield DEBUG : Z
    //   635: ifeq -> 650
    //   638: aload_0
    //   639: aload_1
    //   640: aload_0
    //   641: getfield mOutputTextureId : [I
    //   644: iload #6
    //   646: iaload
    //   647: invokespecial drawPoints : (Lcom/sensetime/stmobile/model/STHumanAction;I)V
    //   650: aload_0
    //   651: getfield TAG : Ljava/lang/String;
    //   654: astore #14
    //   656: new java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial <init> : ()V
    //   663: astore #15
    //   665: aload #15
    //   667: ldc_w 'has human action result at index='
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload #15
    //   676: aload_0
    //   677: getfield mFrameIndex : I
    //   680: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload #15
    //   686: ldc_w ';use frame='
    //   689: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload #15
    //   695: iload #6
    //   697: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload #14
    //   703: aload #15
    //   705: invokevirtual toString : ()Ljava/lang/String;
    //   708: iconst_0
    //   709: anewarray java/lang/Object
    //   712: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   715: pop
    //   716: aload_0
    //   717: getfield mNeedBeautify : Z
    //   720: istore #12
    //   722: aconst_null
    //   723: astore #14
    //   725: iload #12
    //   727: ifeq -> 896
    //   730: invokestatic currentTimeMillis : ()J
    //   733: lstore #8
    //   735: new com/sensetime/stmobile/model/STHumanAction
    //   738: dup
    //   739: invokespecial <init> : ()V
    //   742: astore #15
    //   744: aload #15
    //   746: aload_1
    //   747: getfield bufIndex : I
    //   750: putfield bufIndex : I
    //   753: aload_0
    //   754: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   757: aload_0
    //   758: getfield mOutputTextureId : [I
    //   761: iload #6
    //   763: iaload
    //   764: aload_0
    //   765: getfield mImageWidth : I
    //   768: aload_0
    //   769: getfield mImageHeight : I
    //   772: iload #7
    //   774: aload_1
    //   775: aload_0
    //   776: getfield mBeautifyTextureId : [I
    //   779: iload #6
    //   781: iaload
    //   782: aload #15
    //   784: invokevirtual processTexture : (IIIILcom/sensetime/stmobile/model/STHumanAction;ILcom/sensetime/stmobile/model/STHumanAction;)I
    //   787: istore #4
    //   789: invokestatic currentTimeMillis : ()J
    //   792: lstore #10
    //   794: aload_0
    //   795: getfield TAG : Ljava/lang/String;
    //   798: ldc_w 'beautify cost time: %d'
    //   801: iconst_1
    //   802: anewarray java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: lload #10
    //   809: lload #8
    //   811: lsub
    //   812: invokestatic valueOf : (J)Ljava/lang/Long;
    //   815: aastore
    //   816: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   819: pop
    //   820: iload #4
    //   822: ifeq -> 875
    //   825: aload_0
    //   826: getfield TAG : Ljava/lang/String;
    //   829: astore #15
    //   831: new java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial <init> : ()V
    //   838: astore #16
    //   840: aload #16
    //   842: ldc_w 'beautify processTexture error '
    //   845: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload #16
    //   851: iload #4
    //   853: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload #15
    //   859: aload #16
    //   861: invokevirtual toString : ()Ljava/lang/String;
    //   864: iconst_0
    //   865: anewarray java/lang/Object
    //   868: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   871: pop
    //   872: goto -> 899
    //   875: aload_0
    //   876: getfield mOutputTextureId : [I
    //   879: iload #6
    //   881: aload_0
    //   882: getfield mBeautifyTextureId : [I
    //   885: iload #6
    //   887: iaload
    //   888: iastore
    //   889: aload #15
    //   891: astore #14
    //   893: goto -> 899
    //   896: iconst_m1
    //   897: istore #4
    //   899: aload_0
    //   900: getfield mNeedMakeup : Z
    //   903: ifeq -> 1010
    //   906: invokestatic currentTimeMillis : ()J
    //   909: lstore #8
    //   911: aload #14
    //   913: ifnull -> 923
    //   916: aload #14
    //   918: astore #15
    //   920: goto -> 926
    //   923: aload_1
    //   924: astore #15
    //   926: aload_0
    //   927: getfield mSTMobileMakeupNative : Lcom/sensetime/stmobile/STMobileMakeupNative;
    //   930: aload_0
    //   931: getfield mOutputTextureId : [I
    //   934: iload #6
    //   936: iaload
    //   937: aload #15
    //   939: iload #7
    //   941: aload_0
    //   942: getfield mImageWidth : I
    //   945: aload_0
    //   946: getfield mImageHeight : I
    //   949: aload_0
    //   950: getfield mMakeupTextureId : [I
    //   953: iload #6
    //   955: iaload
    //   956: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIII)I
    //   959: istore #4
    //   961: iload #4
    //   963: ifne -> 980
    //   966: aload_0
    //   967: getfield mOutputTextureId : [I
    //   970: iload #6
    //   972: aload_0
    //   973: getfield mMakeupTextureId : [I
    //   976: iload #6
    //   978: iaload
    //   979: iastore
    //   980: aload_0
    //   981: getfield TAG : Ljava/lang/String;
    //   984: ldc_w 'makeup cost time: %d'
    //   987: iconst_1
    //   988: anewarray java/lang/Object
    //   991: dup
    //   992: iconst_0
    //   993: invokestatic currentTimeMillis : ()J
    //   996: lload #8
    //   998: lsub
    //   999: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1002: aastore
    //   1003: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1006: pop
    //   1007: goto -> 1010
    //   1010: iload #6
    //   1012: istore #5
    //   1014: aload_0
    //   1015: getfield mNeedSticker : Z
    //   1018: ifeq -> 1349
    //   1021: aload_0
    //   1022: getfield mCustomEvent : I
    //   1025: istore #5
    //   1027: aload_0
    //   1028: getfield mParamType : I
    //   1031: iconst_1
    //   1032: iand
    //   1033: iconst_1
    //   1034: if_icmpne -> 1111
    //   1037: aload_0
    //   1038: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1041: astore #15
    //   1043: aload #15
    //   1045: ifnull -> 1111
    //   1048: aload #15
    //   1050: getfield values : [F
    //   1053: ifnull -> 1111
    //   1056: aload_0
    //   1057: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1060: getfield values : [F
    //   1063: arraylength
    //   1064: ifle -> 1111
    //   1067: aload_0
    //   1068: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1071: getfield values : [F
    //   1074: astore #15
    //   1076: aload_0
    //   1077: getfield mCameraID : I
    //   1080: iconst_1
    //   1081: if_icmpne -> 1090
    //   1084: iconst_1
    //   1085: istore #12
    //   1087: goto -> 1093
    //   1090: iconst_0
    //   1091: istore #12
    //   1093: new com/sensetime/stmobile/model/STStickerInputParams
    //   1096: dup
    //   1097: aload #15
    //   1099: iload #12
    //   1101: iload #5
    //   1103: invokespecial <init> : ([FZI)V
    //   1106: astore #15
    //   1108: goto -> 1160
    //   1111: aload_0
    //   1112: getfield mCameraID : I
    //   1115: iconst_1
    //   1116: if_icmpne -> 1125
    //   1119: iconst_1
    //   1120: istore #12
    //   1122: goto -> 1128
    //   1125: iconst_0
    //   1126: istore #12
    //   1128: new com/sensetime/stmobile/model/STStickerInputParams
    //   1131: dup
    //   1132: iconst_4
    //   1133: newarray float
    //   1135: dup
    //   1136: iconst_0
    //   1137: fconst_0
    //   1138: fastore
    //   1139: dup
    //   1140: iconst_1
    //   1141: fconst_0
    //   1142: fastore
    //   1143: dup
    //   1144: iconst_2
    //   1145: fconst_0
    //   1146: fastore
    //   1147: dup
    //   1148: iconst_3
    //   1149: fconst_1
    //   1150: fastore
    //   1151: iload #12
    //   1153: iload #5
    //   1155: invokespecial <init> : ([FZI)V
    //   1158: astore #15
    //   1160: invokestatic currentTimeMillis : ()J
    //   1163: lstore #8
    //   1165: aload #14
    //   1167: ifnull -> 1176
    //   1170: aload #14
    //   1172: astore_1
    //   1173: goto -> 1176
    //   1176: aload_0
    //   1177: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1180: aload_0
    //   1181: getfield mOutputTextureId : [I
    //   1184: iload #6
    //   1186: iaload
    //   1187: aload_1
    //   1188: iload #7
    //   1190: iconst_0
    //   1191: aload_0
    //   1192: getfield mImageWidth : I
    //   1195: aload_0
    //   1196: getfield mImageHeight : I
    //   1199: iconst_0
    //   1200: aload #15
    //   1202: aload_0
    //   1203: getfield mStickerTextureId : [I
    //   1206: iload #6
    //   1208: iaload
    //   1209: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;I)I
    //   1212: istore #4
    //   1214: iload #5
    //   1216: aload_0
    //   1217: getfield mCustomEvent : I
    //   1220: if_icmpne -> 1228
    //   1223: aload_0
    //   1224: iconst_0
    //   1225: putfield mCustomEvent : I
    //   1228: aload_0
    //   1229: getfield TAG : Ljava/lang/String;
    //   1232: ldc_w 'processTexture result: %d'
    //   1235: iconst_1
    //   1236: anewarray java/lang/Object
    //   1239: dup
    //   1240: iconst_0
    //   1241: iload #4
    //   1243: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1246: aastore
    //   1247: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1250: pop
    //   1251: aload_0
    //   1252: getfield TAG : Ljava/lang/String;
    //   1255: ldc_w 'sticker cost time: %d'
    //   1258: iconst_1
    //   1259: anewarray java/lang/Object
    //   1262: dup
    //   1263: iconst_0
    //   1264: invokestatic currentTimeMillis : ()J
    //   1267: lload #8
    //   1269: lsub
    //   1270: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1273: aastore
    //   1274: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1277: pop
    //   1278: iload #4
    //   1280: ifeq -> 1331
    //   1283: aload_0
    //   1284: getfield TAG : Ljava/lang/String;
    //   1287: astore_1
    //   1288: new java/lang/StringBuilder
    //   1291: dup
    //   1292: invokespecial <init> : ()V
    //   1295: astore #14
    //   1297: aload #14
    //   1299: ldc_w 'sticker processTexture error '
    //   1302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload #14
    //   1308: iload #4
    //   1310: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload_1
    //   1315: aload #14
    //   1317: invokevirtual toString : ()Ljava/lang/String;
    //   1320: iconst_0
    //   1321: anewarray java/lang/Object
    //   1324: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1327: pop
    //   1328: goto -> 1345
    //   1331: aload_0
    //   1332: getfield mOutputTextureId : [I
    //   1335: iload #6
    //   1337: aload_0
    //   1338: getfield mStickerTextureId : [I
    //   1341: iload #6
    //   1343: iaload
    //   1344: iastore
    //   1345: iload #6
    //   1347: istore #5
    //   1349: aload_0
    //   1350: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload_0
    //   1355: getfield mFilterStyle : Ljava/lang/String;
    //   1358: astore #14
    //   1360: aload_1
    //   1361: aload #14
    //   1363: if_acmpeq -> 1384
    //   1366: aload_0
    //   1367: aload #14
    //   1369: putfield mCurrentFilterStyle : Ljava/lang/String;
    //   1372: aload_0
    //   1373: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1376: aload_0
    //   1377: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1380: invokevirtual setStyle : (Ljava/lang/String;)I
    //   1383: pop
    //   1384: aload_0
    //   1385: getfield mCurrentFilterStrength : F
    //   1388: fstore_2
    //   1389: aload_0
    //   1390: getfield mFilterStrength : F
    //   1393: fstore_3
    //   1394: fload_2
    //   1395: fload_3
    //   1396: fcmpl
    //   1397: ifeq -> 1418
    //   1400: aload_0
    //   1401: fload_3
    //   1402: putfield mCurrentFilterStrength : F
    //   1405: aload_0
    //   1406: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1409: iconst_0
    //   1410: aload_0
    //   1411: getfield mCurrentFilterStrength : F
    //   1414: invokevirtual setParam : (IF)I
    //   1417: pop
    //   1418: aload_0
    //   1419: getfield mFilterTextureOutId : [I
    //   1422: ifnonnull -> 1450
    //   1425: aload_0
    //   1426: iconst_2
    //   1427: newarray int
    //   1429: putfield mFilterTextureOutId : [I
    //   1432: aload_0
    //   1433: getfield mImageWidth : I
    //   1436: aload_0
    //   1437: getfield mImageHeight : I
    //   1440: aload_0
    //   1441: getfield mFilterTextureOutId : [I
    //   1444: sipush #3553
    //   1447: invokestatic a : (II[II)V
    //   1450: aload_0
    //   1451: getfield mNeedFilter : Z
    //   1454: ifeq -> 1587
    //   1457: invokestatic currentTimeMillis : ()J
    //   1460: lstore #8
    //   1462: aload_0
    //   1463: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1466: aload_0
    //   1467: getfield mOutputTextureId : [I
    //   1470: iload #5
    //   1472: iaload
    //   1473: aload_0
    //   1474: getfield mImageWidth : I
    //   1477: aload_0
    //   1478: getfield mImageHeight : I
    //   1481: aload_0
    //   1482: getfield mFilterTextureOutId : [I
    //   1485: iload #5
    //   1487: iaload
    //   1488: invokevirtual processTexture : (IIII)I
    //   1491: istore #6
    //   1493: aload_0
    //   1494: getfield TAG : Ljava/lang/String;
    //   1497: ldc_w 'filters cost time: %d'
    //   1500: iconst_1
    //   1501: anewarray java/lang/Object
    //   1504: dup
    //   1505: iconst_0
    //   1506: invokestatic currentTimeMillis : ()J
    //   1509: lload #8
    //   1511: lsub
    //   1512: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1515: aastore
    //   1516: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1519: pop
    //   1520: iload #6
    //   1522: ifeq -> 1573
    //   1525: aload_0
    //   1526: getfield TAG : Ljava/lang/String;
    //   1529: astore_1
    //   1530: new java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial <init> : ()V
    //   1537: astore #14
    //   1539: aload #14
    //   1541: ldc_w 'filters processTexture error '
    //   1544: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload #14
    //   1550: iload #4
    //   1552: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1555: pop
    //   1556: aload_1
    //   1557: aload #14
    //   1559: invokevirtual toString : ()Ljava/lang/String;
    //   1562: iconst_0
    //   1563: anewarray java/lang/Object
    //   1566: invokestatic d : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1569: pop
    //   1570: goto -> 1587
    //   1573: aload_0
    //   1574: getfield mOutputTextureId : [I
    //   1577: iload #5
    //   1579: aload_0
    //   1580: getfield mFilterTextureOutId : [I
    //   1583: iload #5
    //   1585: iaload
    //   1586: iastore
    //   1587: aload_0
    //   1588: getfield TAG : Ljava/lang/String;
    //   1591: ldc_w 'frame cost time total: %d'
    //   1594: iconst_1
    //   1595: anewarray java/lang/Object
    //   1598: dup
    //   1599: iconst_0
    //   1600: invokestatic currentTimeMillis : ()J
    //   1603: aload_0
    //   1604: getfield mStartTime : J
    //   1607: lsub
    //   1608: aload_0
    //   1609: getfield mRotateCost : J
    //   1612: ladd
    //   1613: aload_0
    //   1614: getfield mObjectCost : J
    //   1617: ladd
    //   1618: aload_0
    //   1619: getfield mFaceAttributeCost : J
    //   1622: ldc2_w 20
    //   1625: ldiv
    //   1626: ladd
    //   1627: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1630: aastore
    //   1631: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1634: pop
    //   1635: goto -> 1646
    //   1638: aload_1
    //   1639: monitorexit
    //   1640: aload #14
    //   1642: athrow
    //   1643: iconst_0
    //   1644: istore #5
    //   1646: aload_0
    //   1647: getfield mNeedSave : Z
    //   1650: ifeq -> 1669
    //   1653: aload_0
    //   1654: aload_0
    //   1655: getfield mOutputTextureId : [I
    //   1658: iload #5
    //   1660: iaload
    //   1661: invokespecial savePicture : (I)V
    //   1664: aload_0
    //   1665: iconst_0
    //   1666: putfield mNeedSave : Z
    //   1669: aload_0
    //   1670: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1673: ifnull -> 1822
    //   1676: invokestatic glFinish : ()V
    //   1679: aload_0
    //   1680: getfield mVideoEncoderTexture : [I
    //   1683: iconst_0
    //   1684: aload_0
    //   1685: getfield mOutputTextureId : [I
    //   1688: iload #5
    //   1690: iaload
    //   1691: iastore
    //   1692: aload_0
    //   1693: getfield mSurfaceTexture : Landroid/graphics/SurfaceTexture;
    //   1696: aload_0
    //   1697: getfield mStMatrix : [F
    //   1700: invokevirtual getTransformMatrix : ([F)V
    //   1703: aload_0
    //   1704: getfield mStMatrix : [F
    //   1707: astore_1
    //   1708: aload_0
    //   1709: getfield mCameraID : I
    //   1712: iconst_1
    //   1713: if_icmpne -> 1722
    //   1716: iconst_1
    //   1717: istore #12
    //   1719: goto -> 1725
    //   1722: iconst_0
    //   1723: istore #12
    //   1725: aload_0
    //   1726: getfield mCameraID : I
    //   1729: ifne -> 1751
    //   1732: aload_0
    //   1733: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   1736: invokevirtual d : ()I
    //   1739: sipush #270
    //   1742: if_icmpne -> 1751
    //   1745: iconst_1
    //   1746: istore #13
    //   1748: goto -> 1754
    //   1751: iconst_0
    //   1752: istore #13
    //   1754: aload_0
    //   1755: aload_1
    //   1756: iload #12
    //   1758: iload #13
    //   1760: invokespecial processStMatrix : ([FZZ)V
    //   1763: aload_0
    //   1764: monitorenter
    //   1765: aload_0
    //   1766: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1769: ifnull -> 1812
    //   1772: aload_0
    //   1773: getfield mNeedResetEglContext : Z
    //   1776: ifeq -> 1800
    //   1779: aload_0
    //   1780: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1783: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
    //   1786: aload_0
    //   1787: getfield mVideoEncoderTexture : [I
    //   1790: iconst_0
    //   1791: iaload
    //   1792: invokevirtual a : (Landroid/opengl/EGLContext;I)V
    //   1795: aload_0
    //   1796: iconst_0
    //   1797: putfield mNeedResetEglContext : Z
    //   1800: aload_0
    //   1801: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   1804: aload_0
    //   1805: getfield mStMatrix : [F
    //   1808: invokevirtual a : ([F)Z
    //   1811: pop
    //   1812: aload_0
    //   1813: monitorexit
    //   1814: goto -> 1822
    //   1817: astore_1
    //   1818: aload_0
    //   1819: monitorexit
    //   1820: aload_1
    //   1821: athrow
    //   1822: aload_0
    //   1823: invokestatic currentTimeMillis : ()J
    //   1826: aload_0
    //   1827: getfield mStartTime : J
    //   1830: lsub
    //   1831: aload_0
    //   1832: getfield mRotateCost : J
    //   1835: ladd
    //   1836: aload_0
    //   1837: getfield mObjectCost : J
    //   1840: ladd
    //   1841: aload_0
    //   1842: getfield mFaceAttributeCost : J
    //   1845: ldc2_w 20
    //   1848: ldiv
    //   1849: ladd
    //   1850: l2i
    //   1851: putfield mFrameCost : I
    //   1854: invokestatic currentTimeMillis : ()J
    //   1857: lstore #8
    //   1859: aload_0
    //   1860: aload_0
    //   1861: getfield mCount : I
    //   1864: iconst_1
    //   1865: iadd
    //   1866: putfield mCount : I
    //   1869: aload_0
    //   1870: getfield mIsFirstCount : Z
    //   1873: ifeq -> 1890
    //   1876: aload_0
    //   1877: lload #8
    //   1879: putfield mCurrentTime : J
    //   1882: aload_0
    //   1883: iconst_0
    //   1884: putfield mIsFirstCount : Z
    //   1887: goto -> 1936
    //   1890: lload #8
    //   1892: aload_0
    //   1893: getfield mCurrentTime : J
    //   1896: lsub
    //   1897: l2i
    //   1898: istore #4
    //   1900: iload #4
    //   1902: sipush #1000
    //   1905: if_icmplt -> 1936
    //   1908: aload_0
    //   1909: lload #8
    //   1911: putfield mCurrentTime : J
    //   1914: aload_0
    //   1915: aload_0
    //   1916: getfield mCount : I
    //   1919: i2f
    //   1920: ldc_w 1000.0
    //   1923: fmul
    //   1924: iload #4
    //   1926: i2f
    //   1927: fdiv
    //   1928: putfield mFps : F
    //   1931: aload_0
    //   1932: iconst_0
    //   1933: putfield mCount : I
    //   1936: aload_0
    //   1937: getfield TAG : Ljava/lang/String;
    //   1940: ldc_w 'render fps: %f'
    //   1943: iconst_1
    //   1944: anewarray java/lang/Object
    //   1947: dup
    //   1948: iconst_0
    //   1949: aload_0
    //   1950: getfield mFps : F
    //   1953: invokestatic valueOf : (F)Ljava/lang/Float;
    //   1956: aastore
    //   1957: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1960: pop
    //   1961: iconst_0
    //   1962: iconst_0
    //   1963: aload_0
    //   1964: getfield mSurfaceWidth : I
    //   1967: aload_0
    //   1968: getfield mSurfaceHeight : I
    //   1971: invokestatic glViewport : (IIII)V
    //   1974: aload_0
    //   1975: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1978: aload_0
    //   1979: getfield mOutputTextureId : [I
    //   1982: iload #5
    //   1984: iaload
    //   1985: invokevirtual onDrawFrame : (I)I
    //   1988: pop
    //   1989: getstatic com/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread.sDetectLock : Ljava/lang/Object;
    //   1992: astore_1
    //   1993: aload_1
    //   1994: monitorenter
    //   1995: aload_0
    //   1996: aload_0
    //   1997: getfield mFrameIndex : I
    //   2000: iconst_1
    //   2001: iadd
    //   2002: putfield mFrameIndex : I
    //   2005: aload_1
    //   2006: monitorexit
    //   2007: return
    //   2008: astore #14
    //   2010: aload_1
    //   2011: monitorexit
    //   2012: aload #14
    //   2014: athrow
    //   2015: return
    // Exception table:
    //   from	to	target	type
    //   517	523	531	java/lang/InterruptedException
    //   517	523	526	finally
    //   533	538	526	finally
    //   538	540	526	finally
    //   1638	1640	526	finally
    //   1765	1800	1817	finally
    //   1800	1812	1817	finally
    //   1812	1814	1817	finally
    //   1818	1820	1817	finally
    //   1995	2007	2008	finally
    //   2010	2012	2008	finally
  }
  
  public void onPause() {
    LogUtils.c(this.TAG, "onPause", new Object[0]);
    this.mIsPaused = true;
    this.mSetPreViewSizeSucceed = false;
    this.mCameraProxy.b();
    LogUtils.b(this.TAG, "Release camera", new Object[0]);
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            CameraDisplaySingleInputMultiThread.this.mSTHumanActionNative.reset();
            CameraDisplaySingleInputMultiThread.this.mStBeautifyNative.destroyBeautify();
            CameraDisplaySingleInputMultiThread.this.mStStickerNative.removeAvatarModel();
            CameraDisplaySingleInputMultiThread.this.mStStickerNative.destroyInstance();
            CameraDisplaySingleInputMultiThread.this.mSTMobileStreamFilterNative.destroyInstance();
            CameraDisplaySingleInputMultiThread.this.mSTMobileMakeupNative.destroyInstance();
            CameraDisplaySingleInputMultiThread.access$1902(CameraDisplaySingleInputMultiThread.this, null);
            CameraDisplaySingleInputMultiThread.this.deleteTextures();
            if (CameraDisplaySingleInputMultiThread.this.mSurfaceTexture != null)
              CameraDisplaySingleInputMultiThread.this.mSurfaceTexture.release(); 
            CameraDisplaySingleInputMultiThread.this.mGLRender.destroyFrameBuffers();
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
    this.mGLRender.init(this.mImageWidth, this.mImageHeight, this.mDetectImageWidth, this.mDetectImageHeight);
    this.mStartTime = System.currentTimeMillis();
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void removeSticker(int paramInt) {
    int i = this.mStStickerNative.removeSticker(paramInt);
    TreeMap<Integer, String> treeMap = this.mCurrentStickerMaps;
    if (treeMap != null && i == 0)
      treeMap.remove(Integer.valueOf(paramInt)); 
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
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
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
  }
  
  public void setMakeupForTypeFromAssets(int paramInt, String paramString) {
    this.mMakeupPackageId[paramInt] = this.mSTMobileMakeupNative.setMakeupForTypeFromAssetsFile(paramInt, paramString, this.mContext.getAssets());
    if (this.mMakeupPackageId[paramInt] > 0)
      this.mCurrentMakeup[paramInt] = paramString; 
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
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
            //   6: ifnull -> 28
            //   9: aload_0
            //   10: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   13: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
            //   16: aload_0
            //   17: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread;
            //   20: invokestatic access$4700 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread;)[I
            //   23: iconst_0
            //   24: iaload
            //   25: invokevirtual a : (Landroid/opengl/EGLContext;I)V
            //   28: aload_0
            //   29: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread;
            //   32: aload_0
            //   33: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   36: invokestatic access$4802 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInputMultiThread;Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;)Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
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
  
  public void switchCamera() {
    if (Camera.getNumberOfCameras() != 1) {
      if (this.mCameraChanging)
        return; 
      if (this.mCameraProxy.h())
        return; 
      this.mCameraID = 1 - this.mCameraID;
      this.mCameraChanging = true;
      this.mCameraProxy.a(this.mCameraID);
      this.mSetPreViewSizeSucceed = false;
      if (this.mNeedObject) {
        resetIndexRect();
      } else {
        Message message = this.mHandler.obtainMessage(130);
        this.mHandler.sendMessage(message);
      } 
      this.mGlSurfaceView.queueEvent(new Runnable() {
            public void run() {
              if (CameraDisplaySingleInputMultiThread.this.mRGBABuffer != null) {
                CameraDisplaySingleInputMultiThread.this.mRGBABuffer[0].clear();
                CameraDisplaySingleInputMultiThread.this.mRGBABuffer[1].clear();
                CameraDisplaySingleInputMultiThread.access$1902(CameraDisplaySingleInputMultiThread.this, null);
              } 
              CameraDisplaySingleInputMultiThread.this.mHumanActionQueue.clear();
              CameraDisplaySingleInputMultiThread.this.deleteTextures();
              if (CameraDisplaySingleInputMultiThread.this.mCameraProxy.a() != null)
                CameraDisplaySingleInputMultiThread.this.setUpCamera(); 
              CameraDisplaySingleInputMultiThread.access$102(CameraDisplaySingleInputMultiThread.this, false);
            }
          });
      this.mGlSurfaceView.requestRender();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\CameraDisplaySingleInputMultiThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */