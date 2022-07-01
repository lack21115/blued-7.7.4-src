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
import com.sensetime.stmobile.STMobileFaceAttributeNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileMakeupNative;
import com.sensetime.stmobile.STMobileObjectTrackNative;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.STMobileStreamFilterNative;
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
import java.util.TreeMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CameraDisplaySingleInput extends BaseDisplay implements GLSurfaceView.Renderer {
  private static final int MESSAGE_ADD_SUB_MODEL = 1001;
  
  private static final int MESSAGE_NEED_ADD_STICKER = 1006;
  
  private static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
  
  private static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
  
  private static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
  
  private static final int MESSAGE_REMOVE_SUB_MODEL = 1002;
  
  private boolean DEBUG = false;
  
  private String TAG = "CameraDisplaySingleInput";
  
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
        if (!CameraDisplaySingleInput.this.mCameraChanging)
          CameraDisplaySingleInput.this.mGlSurfaceView.requestRender(); 
      }
    };
  
  private int mParamType = 0;
  
  private ByteBuffer mRGBABuffer;
  
  private long mRotateCost = 0L;
  
  private STMobileFaceAttributeNative mSTFaceAttributeNative = new STMobileFaceAttributeNative();
  
  private STMobileHumanActionNative mSTHumanActionNative = new STMobileHumanActionNative();
  
  private STMobileMakeupNative mSTMobileMakeupNative = new STMobileMakeupNative();
  
  private STMobileObjectTrackNative mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
  
  private STMobileStreamFilterNative mSTMobileStreamFilterNative = new STMobileStreamFilterNative();
  
  private int mScreenIndexRectWidth = 0;
  
  private SensorEvent mSensorEvent;
  
  private boolean mSetPreViewSizeSucceed = false;
  
  private boolean mShowOriginal = false;
  
  private STBeautifyNative mStBeautifyNative = new STBeautifyNative();
  
  private final float[] mStMatrix = new float[16];
  
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
  
  private int[] mTextureOutId;
  
  private MediaVideoEncoder mVideoEncoder;
  
  private int[] mVideoEncoderTexture;
  
  public CameraDisplaySingleInput(Context paramContext, ChangePreviewSizeListener paramChangePreviewSizeListener, GLSurfaceView paramGLSurfaceView) {
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
  
  private void initHandlerManager() {
    this.mSubModelsManagerThread = new HandlerThread("SubModelManagerThread");
    this.mSubModelsManagerThread.start();
    this.mSubModelsManagerHandler = new Handler(this.mSubModelsManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplaySingleInput.this.mIsPaused && !CameraDisplaySingleInput.this.mCameraChanging && CameraDisplaySingleInput.this.mIsCreateHumanActionHandleSucceeded) {
            int i = param1Message.what;
            if (i != 1001) {
              if (i != 1002)
                return; 
              i = ((Integer)param1Message.obj).intValue();
              if (i != 0) {
                CameraDisplaySingleInput.this.removeSubModel(i);
                return;
              } 
            } else {
              String str = (String)param1Message.obj;
              if (str != null)
                CameraDisplaySingleInput.this.addSubModel(str); 
            } 
          } 
        }
      };
    this.mChangeStickerManagerThread = new HandlerThread("ChangeStickerManagerThread");
    this.mChangeStickerManagerThread.start();
    this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplaySingleInput.this.mIsPaused && !CameraDisplaySingleInput.this.mCameraChanging) {
            CameraDisplaySingleInput cameraDisplaySingleInput2;
            String str;
            CameraDisplaySingleInput cameraDisplaySingleInput1;
            Message message;
            int i;
            switch (param1Message.what) {
              default:
                return;
              case 1005:
                CameraDisplaySingleInput.this.mStStickerNative.removeAllStickers();
                if (CameraDisplaySingleInput.this.mCurrentStickerMaps != null)
                  CameraDisplaySingleInput.this.mCurrentStickerMaps.clear(); 
                cameraDisplaySingleInput2 = CameraDisplaySingleInput.this;
                cameraDisplaySingleInput2.setHumanActionDetectConfig(cameraDisplaySingleInput2.mNeedBeautify, CameraDisplaySingleInput.this.mStStickerNative.getTriggerAction(), CameraDisplaySingleInput.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1003:
                str = (String)((Message)cameraDisplaySingleInput2).obj;
                CameraDisplaySingleInput.access$502(CameraDisplaySingleInput.this, str);
                i = CameraDisplaySingleInput.this.mStStickerNative.changeSticker(CameraDisplaySingleInput.this.mCurrentSticker);
                LogUtils.c(CameraDisplaySingleInput.this.TAG, "change sticker result: %d", new Object[] { Integer.valueOf(i) });
                cameraDisplaySingleInput1 = CameraDisplaySingleInput.this;
                CameraDisplaySingleInput.access$802(cameraDisplaySingleInput1, cameraDisplaySingleInput1.mStStickerNative.getNeededInputParams());
                cameraDisplaySingleInput1 = CameraDisplaySingleInput.this;
                cameraDisplaySingleInput1.setHumanActionDetectConfig(cameraDisplaySingleInput1.mNeedBeautify, CameraDisplaySingleInput.this.mStStickerNative.getTriggerAction(), CameraDisplaySingleInput.this.mSTMobileMakeupNative.getTriggerAction());
                message = CameraDisplaySingleInput.this.mHandler.obtainMessage(110);
                CameraDisplaySingleInput.this.mHandler.sendMessage(message);
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
            synchronized (CameraDisplaySingleInput.this.mHumanActionHandleLock) {
              int i = CameraDisplaySingleInput.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), CameraDisplaySingleInput.this.mHumanActionCreateConfig, CameraDisplaySingleInput.this.mContext.getAssets());
              LogUtils.c(CameraDisplaySingleInput.this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
              if (i == 0) {
                i = CameraDisplaySingleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", CameraDisplaySingleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInput.this.TAG, "add hand model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplaySingleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Segment_1.5.0.model", CameraDisplaySingleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInput.this.TAG, "add figure segment model result: %d", new Object[] { Integer.valueOf(i) });
                CameraDisplaySingleInput.access$202(CameraDisplaySingleInput.this, true);
                CameraDisplaySingleInput.this.mSTHumanActionNative.setParam(2, 0.35F);
                i = CameraDisplaySingleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Face_Extra_5.23.0.model", CameraDisplaySingleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInput.this.TAG, "add face extra model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplaySingleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Iris_2.0.0.model", CameraDisplaySingleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplaySingleInput.this.TAG, "add eyeball contour model result: %d", new Object[] { Integer.valueOf(i) });
                if (CameraDisplaySingleInput.this.mNeedAvatar) {
                  i = CameraDisplaySingleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Avatar_Help_2.0.0.model", CameraDisplaySingleInput.this.mContext.getAssets());
                  LogUtils.c(CameraDisplaySingleInput.this.TAG, "add avatar help model result: %d", new Object[] { Integer.valueOf(i) });
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
      this.mCameraProxy.a(this.mSurfaceTexture, null);
      return;
    } 
  }
  
  public int addSticker(String paramString) {
    this.mCurrentSticker = paramString;
    int i = this.mStStickerNative.addSticker(this.mCurrentSticker);
    if (i > 0) {
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
              if (CameraDisplaySingleInput.this.mRGBABuffer != null)
                CameraDisplaySingleInput.this.mRGBABuffer.clear(); 
              CameraDisplaySingleInput.access$2202(CameraDisplaySingleInput.this, null);
              CameraDisplaySingleInput.this.deleteTextures();
              if (CameraDisplaySingleInput.this.mCameraProxy.a() != null)
                CameraDisplaySingleInput.this.setUpCamera(); 
              CameraDisplaySingleInput.this.mGLRender.init(CameraDisplaySingleInput.this.mImageWidth, CameraDisplaySingleInput.this.mImageHeight);
              if (CameraDisplaySingleInput.this.DEBUG)
                CameraDisplaySingleInput.this.mGLRender.initDrawPoints(); 
              if (CameraDisplaySingleInput.this.mNeedObject)
                CameraDisplaySingleInput.this.resetIndexRect(); 
              CameraDisplaySingleInput.this.mGLRender.calculateVertexBuffer(CameraDisplaySingleInput.this.mSurfaceWidth, CameraDisplaySingleInput.this.mSurfaceHeight, CameraDisplaySingleInput.this.mImageWidth, CameraDisplaySingleInput.this.mImageHeight);
              if (CameraDisplaySingleInput.this.mListener != null)
                CameraDisplaySingleInput.this.mListener.onChangePreviewSize(CameraDisplaySingleInput.this.mImageHeight, CameraDisplaySingleInput.this.mImageWidth); 
              CameraDisplaySingleInput.access$102(CameraDisplaySingleInput.this, false);
              CameraDisplaySingleInput.access$3302(CameraDisplaySingleInput.this, false);
              CameraDisplaySingleInput.this.mGlSurfaceView.requestRender();
              LogUtils.b(CameraDisplaySingleInput.this.TAG, "exit  change Preview size queue event", new Object[0]);
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
    //   20: getfield TAG : Ljava/lang/String;
    //   23: ldc_w 'onDrawFrame'
    //   26: iconst_0
    //   27: anewarray java/lang/Object
    //   30: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   33: pop
    //   34: aload_0
    //   35: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   38: ifnonnull -> 59
    //   41: aload_0
    //   42: aload_0
    //   43: getfield mImageHeight : I
    //   46: aload_0
    //   47: getfield mImageWidth : I
    //   50: imul
    //   51: iconst_4
    //   52: imul
    //   53: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   56: putfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: getfield mBeautifyTextureId : [I
    //   63: ifnonnull -> 91
    //   66: aload_0
    //   67: iconst_1
    //   68: newarray int
    //   70: putfield mBeautifyTextureId : [I
    //   73: aload_0
    //   74: getfield mImageWidth : I
    //   77: aload_0
    //   78: getfield mImageHeight : I
    //   81: aload_0
    //   82: getfield mBeautifyTextureId : [I
    //   85: sipush #3553
    //   88: invokestatic a : (II[II)V
    //   91: aload_0
    //   92: getfield mMakeupTextureId : [I
    //   95: ifnonnull -> 123
    //   98: aload_0
    //   99: iconst_1
    //   100: newarray int
    //   102: putfield mMakeupTextureId : [I
    //   105: aload_0
    //   106: getfield mImageWidth : I
    //   109: aload_0
    //   110: getfield mImageHeight : I
    //   113: aload_0
    //   114: getfield mMakeupTextureId : [I
    //   117: sipush #3553
    //   120: invokestatic a : (II[II)V
    //   123: aload_0
    //   124: getfield mTextureOutId : [I
    //   127: ifnonnull -> 155
    //   130: aload_0
    //   131: iconst_1
    //   132: newarray int
    //   134: putfield mTextureOutId : [I
    //   137: aload_0
    //   138: getfield mImageWidth : I
    //   141: aload_0
    //   142: getfield mImageHeight : I
    //   145: aload_0
    //   146: getfield mTextureOutId : [I
    //   149: sipush #3553
    //   152: invokestatic a : (II[II)V
    //   155: aload_0
    //   156: getfield mVideoEncoderTexture : [I
    //   159: ifnonnull -> 169
    //   162: aload_0
    //   163: iconst_1
    //   164: newarray int
    //   166: putfield mVideoEncoderTexture : [I
    //   169: aload_0
    //   170: getfield mSurfaceTexture : Landroid/graphics/SurfaceTexture;
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull -> 2485
    //   178: aload_0
    //   179: getfield mIsPaused : Z
    //   182: ifne -> 2485
    //   185: aload_1
    //   186: invokevirtual updateTexImage : ()V
    //   189: aload_0
    //   190: invokestatic currentTimeMillis : ()J
    //   193: putfield mStartTime : J
    //   196: fconst_0
    //   197: fconst_0
    //   198: fconst_0
    //   199: fconst_0
    //   200: invokestatic glClearColor : (FFFF)V
    //   203: sipush #16640
    //   206: invokestatic glClear : (I)V
    //   209: aload_0
    //   210: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   213: invokevirtual rewind : ()Ljava/nio/Buffer;
    //   216: pop
    //   217: invokestatic currentTimeMillis : ()J
    //   220: lstore #8
    //   222: aload_0
    //   223: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   226: aload_0
    //   227: getfield mTextureId : I
    //   230: aload_0
    //   231: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   234: invokevirtual preProcess : (ILjava/nio/ByteBuffer;)I
    //   237: istore #5
    //   239: aload_0
    //   240: getfield TAG : Ljava/lang/String;
    //   243: ldc_w 'preprocess cost time: %d'
    //   246: iconst_1
    //   247: anewarray java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: invokestatic currentTimeMillis : ()J
    //   255: lload #8
    //   257: lsub
    //   258: invokestatic valueOf : (J)Ljava/lang/Long;
    //   261: aastore
    //   262: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   265: pop
    //   266: iload #5
    //   268: istore #4
    //   270: aload_0
    //   271: getfield mShowOriginal : Z
    //   274: ifne -> 2157
    //   277: aload_0
    //   278: getfield mNeedObject : Z
    //   281: istore #12
    //   283: iload #12
    //   285: ifeq -> 642
    //   288: aload_0
    //   289: getfield mNeedSetObjectTarget : Z
    //   292: ifeq -> 399
    //   295: invokestatic currentTimeMillis : ()J
    //   298: lstore #8
    //   300: new com/sensetime/stmobile/model/STRect
    //   303: dup
    //   304: aload_0
    //   305: getfield mTargetRect : Landroid/graphics/Rect;
    //   308: getfield left : I
    //   311: aload_0
    //   312: getfield mTargetRect : Landroid/graphics/Rect;
    //   315: getfield top : I
    //   318: aload_0
    //   319: getfield mTargetRect : Landroid/graphics/Rect;
    //   322: getfield right : I
    //   325: aload_0
    //   326: getfield mTargetRect : Landroid/graphics/Rect;
    //   329: getfield bottom : I
    //   332: invokespecial <init> : (IIII)V
    //   335: astore_1
    //   336: aload_0
    //   337: getfield mSTMobileObjectTrackNative : Lcom/sensetime/stmobile/STMobileObjectTrackNative;
    //   340: aload_0
    //   341: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   344: invokevirtual array : ()[B
    //   347: bipush #6
    //   349: aload_0
    //   350: getfield mImageWidth : I
    //   353: aload_0
    //   354: getfield mImageHeight : I
    //   357: aload_1
    //   358: invokevirtual setTarget : ([BIIILcom/sensetime/stmobile/model/STRect;)I
    //   361: pop
    //   362: aload_0
    //   363: getfield TAG : Ljava/lang/String;
    //   366: ldc_w 'setTarget cost time: %d'
    //   369: iconst_1
    //   370: anewarray java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: invokestatic currentTimeMillis : ()J
    //   378: lload #8
    //   380: lsub
    //   381: invokestatic valueOf : (J)Ljava/lang/Long;
    //   384: aastore
    //   385: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   388: pop
    //   389: aload_0
    //   390: iconst_0
    //   391: putfield mNeedSetObjectTarget : Z
    //   394: aload_0
    //   395: iconst_1
    //   396: putfield mIsObjectTracking : Z
    //   399: new android/graphics/Rect
    //   402: dup
    //   403: iconst_0
    //   404: iconst_0
    //   405: iconst_0
    //   406: iconst_0
    //   407: invokespecial <init> : (IIII)V
    //   410: astore #14
    //   412: aload_0
    //   413: getfield mIsObjectTracking : Z
    //   416: ifeq -> 571
    //   419: invokestatic currentTimeMillis : ()J
    //   422: lstore #8
    //   424: iconst_1
    //   425: newarray float
    //   427: astore #15
    //   429: aload_0
    //   430: getfield mSTMobileObjectTrackNative : Lcom/sensetime/stmobile/STMobileObjectTrackNative;
    //   433: aload_0
    //   434: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   437: invokevirtual array : ()[B
    //   440: bipush #6
    //   442: aload_0
    //   443: getfield mImageWidth : I
    //   446: aload_0
    //   447: getfield mImageHeight : I
    //   450: aload #15
    //   452: invokevirtual objectTrack : ([BIII[F)Lcom/sensetime/stmobile/model/STRect;
    //   455: astore #16
    //   457: aload_0
    //   458: getfield TAG : Ljava/lang/String;
    //   461: ldc_w 'objectTrack cost time: %d'
    //   464: iconst_1
    //   465: anewarray java/lang/Object
    //   468: dup
    //   469: iconst_0
    //   470: invokestatic currentTimeMillis : ()J
    //   473: lload #8
    //   475: lsub
    //   476: invokestatic valueOf : (J)Ljava/lang/Long;
    //   479: aastore
    //   480: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   483: pop
    //   484: aload_0
    //   485: invokestatic currentTimeMillis : ()J
    //   488: lload #8
    //   490: lsub
    //   491: putfield mObjectCost : J
    //   494: aload #14
    //   496: astore_1
    //   497: aload #16
    //   499: ifnull -> 536
    //   502: aload #14
    //   504: astore_1
    //   505: aload #15
    //   507: arraylength
    //   508: ifle -> 536
    //   511: aload #16
    //   513: invokevirtual getRect : ()Landroid/graphics/Rect;
    //   516: aload_0
    //   517: getfield mSurfaceWidth : I
    //   520: aload_0
    //   521: getfield mSurfaceHeight : I
    //   524: aload_0
    //   525: getfield mImageWidth : I
    //   528: aload_0
    //   529: getfield mImageHeight : I
    //   532: invokestatic b : (Landroid/graphics/Rect;IIII)Landroid/graphics/Rect;
    //   535: astore_1
    //   536: aload_0
    //   537: getfield mHandler : Landroid/os/Handler;
    //   540: bipush #120
    //   542: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   545: astore #14
    //   547: aload #14
    //   549: aload_1
    //   550: putfield obj : Ljava/lang/Object;
    //   553: aload_0
    //   554: getfield mHandler : Landroid/os/Handler;
    //   557: aload #14
    //   559: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   562: pop
    //   563: aload_0
    //   564: aload_1
    //   565: putfield mIndexRect : Landroid/graphics/Rect;
    //   568: goto -> 686
    //   571: aload_0
    //   572: getfield mNeedShowRect : Z
    //   575: ifeq -> 608
    //   578: aload_0
    //   579: getfield mHandler : Landroid/os/Handler;
    //   582: bipush #121
    //   584: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   587: astore_1
    //   588: aload_1
    //   589: aload_0
    //   590: getfield mIndexRect : Landroid/graphics/Rect;
    //   593: putfield obj : Ljava/lang/Object;
    //   596: aload_0
    //   597: getfield mHandler : Landroid/os/Handler;
    //   600: aload_1
    //   601: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   604: pop
    //   605: goto -> 686
    //   608: aload_0
    //   609: getfield mHandler : Landroid/os/Handler;
    //   612: bipush #120
    //   614: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   617: astore_1
    //   618: aload_1
    //   619: aload #14
    //   621: putfield obj : Ljava/lang/Object;
    //   624: aload_0
    //   625: getfield mHandler : Landroid/os/Handler;
    //   628: aload_1
    //   629: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   632: pop
    //   633: aload_0
    //   634: aload #14
    //   636: putfield mIndexRect : Landroid/graphics/Rect;
    //   639: goto -> 686
    //   642: aload_0
    //   643: lconst_0
    //   644: putfield mObjectCost : J
    //   647: iload #12
    //   649: ifeq -> 666
    //   652: aload_0
    //   653: getfield mNeedBeautify : Z
    //   656: ifne -> 686
    //   659: aload_0
    //   660: getfield mNeedSticker : Z
    //   663: ifne -> 686
    //   666: aload_0
    //   667: getfield mHandler : Landroid/os/Handler;
    //   670: sipush #130
    //   673: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   676: astore_1
    //   677: aload_0
    //   678: getfield mHandler : Landroid/os/Handler;
    //   681: aload_1
    //   682: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   685: pop
    //   686: aload_0
    //   687: getfield mNeedBeautify : Z
    //   690: ifne -> 704
    //   693: iload #5
    //   695: istore #4
    //   697: aload_0
    //   698: getfield mNeedSticker : Z
    //   701: ifeq -> 1919
    //   704: aload_0
    //   705: getfield mIsCreateHumanActionHandleSucceeded : Z
    //   708: ifeq -> 1442
    //   711: invokestatic currentTimeMillis : ()J
    //   714: lstore #8
    //   716: aload_0
    //   717: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   720: aload_0
    //   721: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   724: invokevirtual array : ()[B
    //   727: bipush #6
    //   729: aload_0
    //   730: getfield mDetectConfig : J
    //   733: aload_0
    //   734: invokespecial getCurrentOrientation : ()I
    //   737: aload_0
    //   738: getfield mImageWidth : I
    //   741: aload_0
    //   742: getfield mImageHeight : I
    //   745: invokevirtual humanActionDetect : ([BIJIII)Lcom/sensetime/stmobile/model/STHumanAction;
    //   748: astore #14
    //   750: aload_0
    //   751: getfield TAG : Ljava/lang/String;
    //   754: ldc_w 'human action cost time: %d'
    //   757: iconst_1
    //   758: anewarray java/lang/Object
    //   761: dup
    //   762: iconst_0
    //   763: invokestatic currentTimeMillis : ()J
    //   766: lload #8
    //   768: lsub
    //   769: invokestatic valueOf : (J)Ljava/lang/Long;
    //   772: aastore
    //   773: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   776: pop
    //   777: aload_0
    //   778: getfield mNeedDistance : Z
    //   781: ifeq -> 880
    //   784: aload #14
    //   786: ifnull -> 875
    //   789: aload #14
    //   791: getfield faceCount : I
    //   794: ifle -> 875
    //   797: invokestatic currentTimeMillis : ()J
    //   800: lstore #8
    //   802: aload_0
    //   803: aload_0
    //   804: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   807: aload #14
    //   809: getfield faces : [Lcom/sensetime/stmobile/model/STMobileFaceInfo;
    //   812: iconst_0
    //   813: aaload
    //   814: aload_0
    //   815: invokespecial getCurrentOrientation : ()I
    //   818: aload_0
    //   819: getfield mImageWidth : I
    //   822: aload_0
    //   823: getfield mImageHeight : I
    //   826: aload_0
    //   827: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   830: invokevirtual a : ()Landroid/hardware/Camera;
    //   833: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   836: invokevirtual getVerticalViewAngle : ()F
    //   839: invokevirtual getFaceDistance : (Lcom/sensetime/stmobile/model/STMobileFaceInfo;IIIF)F
    //   842: putfield mFaceDistance : F
    //   845: aload_0
    //   846: getfield TAG : Ljava/lang/String;
    //   849: ldc_w 'human action face distance cost time: %d'
    //   852: iconst_1
    //   853: anewarray java/lang/Object
    //   856: dup
    //   857: iconst_0
    //   858: invokestatic currentTimeMillis : ()J
    //   861: lload #8
    //   863: lsub
    //   864: invokestatic valueOf : (J)Ljava/lang/Long;
    //   867: aastore
    //   868: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   871: pop
    //   872: goto -> 880
    //   875: aload_0
    //   876: fconst_0
    //   877: putfield mFaceDistance : F
    //   880: aload_0
    //   881: getfield DEBUG : Z
    //   884: ifeq -> 1001
    //   887: aload #14
    //   889: ifnull -> 996
    //   892: aload #14
    //   894: getfield faceCount : I
    //   897: ifle -> 996
    //   900: invokestatic currentTimeMillis : ()J
    //   903: lstore #8
    //   905: aload_0
    //   906: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   909: astore_1
    //   910: aload_0
    //   911: invokespecial getCurrentOrientation : ()I
    //   914: istore #4
    //   916: aload_0
    //   917: getfield mCameraID : I
    //   920: iconst_1
    //   921: if_icmpne -> 930
    //   924: iconst_1
    //   925: istore #12
    //   927: goto -> 933
    //   930: iconst_0
    //   931: istore #12
    //   933: aload_0
    //   934: aload #14
    //   936: iload #4
    //   938: iload #12
    //   940: invokestatic getExpression : (Lcom/sensetime/stmobile/model/STHumanAction;IZ)[Z
    //   943: putfield mFaceExpressionResult : [Z
    //   946: aload_0
    //   947: getfield TAG : Ljava/lang/String;
    //   950: ldc_w 'face expression cost time: %d'
    //   953: iconst_1
    //   954: anewarray java/lang/Object
    //   957: dup
    //   958: iconst_0
    //   959: invokestatic currentTimeMillis : ()J
    //   962: lload #8
    //   964: lsub
    //   965: invokestatic valueOf : (J)Ljava/lang/Long;
    //   968: aastore
    //   969: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   972: pop
    //   973: aload_0
    //   974: getfield mHandler : Landroid/os/Handler;
    //   977: sipush #140
    //   980: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   983: astore_1
    //   984: aload_0
    //   985: getfield mHandler : Landroid/os/Handler;
    //   988: aload_1
    //   989: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   992: pop
    //   993: goto -> 1001
    //   996: aload_0
    //   997: aconst_null
    //   998: putfield mFaceExpressionResult : [Z
    //   1001: aload #14
    //   1003: astore_1
    //   1004: aload_0
    //   1005: getfield DEBUG : Z
    //   1008: ifeq -> 1444
    //   1011: aload #14
    //   1013: ifnull -> 1150
    //   1016: aload #14
    //   1018: invokevirtual getImage : ()Lcom/sensetime/stmobile/model/STImage;
    //   1021: ifnull -> 1049
    //   1024: aload_0
    //   1025: getfield TAG : Ljava/lang/String;
    //   1028: ldc_w 'human action background result: %d'
    //   1031: iconst_1
    //   1032: anewarray java/lang/Object
    //   1035: dup
    //   1036: iconst_0
    //   1037: iconst_1
    //   1038: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1041: aastore
    //   1042: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1045: pop
    //   1046: goto -> 1071
    //   1049: aload_0
    //   1050: getfield TAG : Ljava/lang/String;
    //   1053: ldc_w 'human action background result: %d'
    //   1056: iconst_1
    //   1057: anewarray java/lang/Object
    //   1060: dup
    //   1061: iconst_0
    //   1062: iconst_0
    //   1063: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1066: aastore
    //   1067: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1070: pop
    //   1071: aload #14
    //   1073: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1076: ifnull -> 1125
    //   1079: aload #14
    //   1081: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1084: arraylength
    //   1085: ifle -> 1125
    //   1088: aload_0
    //   1089: aload #14
    //   1091: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1094: iconst_0
    //   1095: aaload
    //   1096: getfield handAction : J
    //   1099: putfield mHandAction : J
    //   1102: aload_0
    //   1103: getfield mHandler : Landroid/os/Handler;
    //   1106: sipush #141
    //   1109: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1112: astore_1
    //   1113: aload_0
    //   1114: getfield mHandler : Landroid/os/Handler;
    //   1117: aload_1
    //   1118: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1121: pop
    //   1122: goto -> 1150
    //   1125: aload_0
    //   1126: lconst_0
    //   1127: putfield mHandAction : J
    //   1130: aload_0
    //   1131: getfield mHandler : Landroid/os/Handler;
    //   1134: sipush #142
    //   1137: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1140: astore_1
    //   1141: aload_0
    //   1142: getfield mHandler : Landroid/os/Handler;
    //   1145: aload_1
    //   1146: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1149: pop
    //   1150: aload_0
    //   1151: getfield mFrameCount : I
    //   1154: istore #4
    //   1156: iload #4
    //   1158: bipush #20
    //   1160: if_icmpgt -> 1174
    //   1163: aload_0
    //   1164: iload #4
    //   1166: iconst_1
    //   1167: iadd
    //   1168: putfield mFrameCount : I
    //   1171: goto -> 1192
    //   1174: aload_0
    //   1175: iconst_0
    //   1176: putfield mFrameCount : I
    //   1179: aload_0
    //   1180: aload_0
    //   1181: getfield mRGBABuffer : Ljava/nio/ByteBuffer;
    //   1184: invokevirtual array : ()[B
    //   1187: aload #14
    //   1189: invokespecial faceAttributeDetect : ([BLcom/sensetime/stmobile/model/STHumanAction;)V
    //   1192: aload #14
    //   1194: astore_1
    //   1195: aload #14
    //   1197: ifnull -> 1444
    //   1200: aload #14
    //   1202: getfield faceCount : I
    //   1205: ifle -> 1265
    //   1208: iconst_0
    //   1209: istore #4
    //   1211: iload #4
    //   1213: aload #14
    //   1215: getfield faceCount : I
    //   1218: if_icmpge -> 1265
    //   1221: aload #14
    //   1223: iload #4
    //   1225: aload_0
    //   1226: getfield mImageWidth : I
    //   1229: aload_0
    //   1230: getfield mImageHeight : I
    //   1233: invokestatic a : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1236: astore_1
    //   1237: aload_1
    //   1238: ifnull -> 1256
    //   1241: aload_1
    //   1242: arraylength
    //   1243: ifle -> 1256
    //   1246: aload_0
    //   1247: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1250: iload #5
    //   1252: aload_1
    //   1253: invokevirtual onDrawPoints : (I[F)V
    //   1256: iload #4
    //   1258: iconst_1
    //   1259: iadd
    //   1260: istore #4
    //   1262: goto -> 1211
    //   1265: aload #14
    //   1267: getfield bodyCount : I
    //   1270: ifle -> 1424
    //   1273: iconst_0
    //   1274: istore #4
    //   1276: iload #4
    //   1278: aload #14
    //   1280: getfield bodyCount : I
    //   1283: if_icmpge -> 1330
    //   1286: aload #14
    //   1288: iload #4
    //   1290: aload_0
    //   1291: getfield mImageWidth : I
    //   1294: aload_0
    //   1295: getfield mImageHeight : I
    //   1298: invokestatic c : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1301: astore_1
    //   1302: aload_1
    //   1303: ifnull -> 1321
    //   1306: aload_1
    //   1307: arraylength
    //   1308: ifle -> 1321
    //   1311: aload_0
    //   1312: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1315: iload #5
    //   1317: aload_1
    //   1318: invokevirtual onDrawPoints : (I[F)V
    //   1321: iload #4
    //   1323: iconst_1
    //   1324: iadd
    //   1325: istore #4
    //   1327: goto -> 1276
    //   1330: aload_0
    //   1331: aload #14
    //   1333: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1336: iconst_0
    //   1337: aaload
    //   1338: getfield bodyAction : J
    //   1341: putfield mBodyAction : J
    //   1344: aload_0
    //   1345: getfield TAG : Ljava/lang/String;
    //   1348: ldc_w 'human action body count: %d'
    //   1351: iconst_1
    //   1352: anewarray java/lang/Object
    //   1355: dup
    //   1356: iconst_0
    //   1357: aload #14
    //   1359: getfield bodyCount : I
    //   1362: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1365: aastore
    //   1366: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1369: pop
    //   1370: aload_0
    //   1371: getfield TAG : Ljava/lang/String;
    //   1374: ldc_w 'human action body[0] action: %d'
    //   1377: iconst_1
    //   1378: anewarray java/lang/Object
    //   1381: dup
    //   1382: iconst_0
    //   1383: aload #14
    //   1385: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1388: iconst_0
    //   1389: aaload
    //   1390: getfield bodyAction : J
    //   1393: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1396: aastore
    //   1397: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1400: pop
    //   1401: aload_0
    //   1402: getfield mHandler : Landroid/os/Handler;
    //   1405: sipush #143
    //   1408: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1411: astore_1
    //   1412: aload_0
    //   1413: getfield mHandler : Landroid/os/Handler;
    //   1416: aload_1
    //   1417: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1420: pop
    //   1421: goto -> 1429
    //   1424: aload_0
    //   1425: lconst_0
    //   1426: putfield mBodyAction : J
    //   1429: ldc_w 36160
    //   1432: iconst_0
    //   1433: invokestatic glBindFramebuffer : (II)V
    //   1436: aload #14
    //   1438: astore_1
    //   1439: goto -> 1444
    //   1442: aconst_null
    //   1443: astore_1
    //   1444: aload_0
    //   1445: invokespecial getCurrentOrientation : ()I
    //   1448: istore #6
    //   1450: aload_1
    //   1451: astore #14
    //   1453: iload #5
    //   1455: istore #4
    //   1457: aload_0
    //   1458: getfield mNeedBeautify : Z
    //   1461: ifeq -> 1573
    //   1464: invokestatic currentTimeMillis : ()J
    //   1467: lstore #8
    //   1469: aload_0
    //   1470: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   1473: iload #5
    //   1475: aload_0
    //   1476: getfield mImageWidth : I
    //   1479: aload_0
    //   1480: getfield mImageHeight : I
    //   1483: iload #6
    //   1485: aload_1
    //   1486: aload_0
    //   1487: getfield mBeautifyTextureId : [I
    //   1490: iconst_0
    //   1491: iaload
    //   1492: aload_0
    //   1493: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1496: invokevirtual processTexture : (IIIILcom/sensetime/stmobile/model/STHumanAction;ILcom/sensetime/stmobile/model/STHumanAction;)I
    //   1499: istore #7
    //   1501: invokestatic currentTimeMillis : ()J
    //   1504: lstore #10
    //   1506: aload_0
    //   1507: getfield TAG : Ljava/lang/String;
    //   1510: ldc_w 'beautify cost time: %d'
    //   1513: iconst_1
    //   1514: anewarray java/lang/Object
    //   1517: dup
    //   1518: iconst_0
    //   1519: lload #10
    //   1521: lload #8
    //   1523: lsub
    //   1524: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1527: aastore
    //   1528: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1531: pop
    //   1532: aload_1
    //   1533: astore #14
    //   1535: iload #5
    //   1537: istore #4
    //   1539: iload #7
    //   1541: ifne -> 1573
    //   1544: aload_0
    //   1545: getfield mBeautifyTextureId : [I
    //   1548: iconst_0
    //   1549: iaload
    //   1550: istore #4
    //   1552: aload_0
    //   1553: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1556: astore #14
    //   1558: aload_0
    //   1559: getfield TAG : Ljava/lang/String;
    //   1562: ldc_w 'replace enlarge eye and shrink face action'
    //   1565: iconst_0
    //   1566: anewarray java/lang/Object
    //   1569: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1572: pop
    //   1573: iload #4
    //   1575: istore #5
    //   1577: aload_0
    //   1578: getfield mNeedMakeup : Z
    //   1581: ifeq -> 1658
    //   1584: invokestatic currentTimeMillis : ()J
    //   1587: lstore #8
    //   1589: iload #4
    //   1591: istore #5
    //   1593: aload_0
    //   1594: getfield mSTMobileMakeupNative : Lcom/sensetime/stmobile/STMobileMakeupNative;
    //   1597: iload #4
    //   1599: aload #14
    //   1601: iload #6
    //   1603: aload_0
    //   1604: getfield mImageWidth : I
    //   1607: aload_0
    //   1608: getfield mImageHeight : I
    //   1611: aload_0
    //   1612: getfield mMakeupTextureId : [I
    //   1615: iconst_0
    //   1616: iaload
    //   1617: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIII)I
    //   1620: ifne -> 1631
    //   1623: aload_0
    //   1624: getfield mMakeupTextureId : [I
    //   1627: iconst_0
    //   1628: iaload
    //   1629: istore #5
    //   1631: aload_0
    //   1632: getfield TAG : Ljava/lang/String;
    //   1635: ldc_w 'makeup cost time: %d'
    //   1638: iconst_1
    //   1639: anewarray java/lang/Object
    //   1642: dup
    //   1643: iconst_0
    //   1644: invokestatic currentTimeMillis : ()J
    //   1647: lload #8
    //   1649: lsub
    //   1650: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1653: aastore
    //   1654: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1657: pop
    //   1658: iload #5
    //   1660: istore #4
    //   1662: aload_0
    //   1663: getfield mNeedSticker : Z
    //   1666: ifeq -> 1919
    //   1669: aload_0
    //   1670: getfield mCustomEvent : I
    //   1673: istore #4
    //   1675: aload_0
    //   1676: getfield mParamType : I
    //   1679: iconst_1
    //   1680: iand
    //   1681: iconst_1
    //   1682: if_icmpne -> 1753
    //   1685: aload_0
    //   1686: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1689: astore_1
    //   1690: aload_1
    //   1691: ifnull -> 1753
    //   1694: aload_1
    //   1695: getfield values : [F
    //   1698: ifnull -> 1753
    //   1701: aload_0
    //   1702: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1705: getfield values : [F
    //   1708: arraylength
    //   1709: ifle -> 1753
    //   1712: aload_0
    //   1713: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1716: getfield values : [F
    //   1719: astore_1
    //   1720: aload_0
    //   1721: getfield mCameraID : I
    //   1724: iconst_1
    //   1725: if_icmpne -> 1734
    //   1728: iconst_1
    //   1729: istore #12
    //   1731: goto -> 1737
    //   1734: iconst_0
    //   1735: istore #12
    //   1737: new com/sensetime/stmobile/model/STStickerInputParams
    //   1740: dup
    //   1741: aload_1
    //   1742: iload #12
    //   1744: iload #4
    //   1746: invokespecial <init> : ([FZI)V
    //   1749: astore_1
    //   1750: goto -> 1801
    //   1753: aload_0
    //   1754: getfield mCameraID : I
    //   1757: iconst_1
    //   1758: if_icmpne -> 1767
    //   1761: iconst_1
    //   1762: istore #12
    //   1764: goto -> 1770
    //   1767: iconst_0
    //   1768: istore #12
    //   1770: new com/sensetime/stmobile/model/STStickerInputParams
    //   1773: dup
    //   1774: iconst_4
    //   1775: newarray float
    //   1777: dup
    //   1778: iconst_0
    //   1779: fconst_0
    //   1780: fastore
    //   1781: dup
    //   1782: iconst_1
    //   1783: fconst_0
    //   1784: fastore
    //   1785: dup
    //   1786: iconst_2
    //   1787: fconst_0
    //   1788: fastore
    //   1789: dup
    //   1790: iconst_3
    //   1791: fconst_1
    //   1792: fastore
    //   1793: iload #12
    //   1795: iload #4
    //   1797: invokespecial <init> : ([FZI)V
    //   1800: astore_1
    //   1801: invokestatic currentTimeMillis : ()J
    //   1804: lstore #8
    //   1806: aload_0
    //   1807: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1810: iload #5
    //   1812: aload #14
    //   1814: iload #6
    //   1816: iconst_0
    //   1817: aload_0
    //   1818: getfield mImageWidth : I
    //   1821: aload_0
    //   1822: getfield mImageHeight : I
    //   1825: iconst_0
    //   1826: aload_1
    //   1827: aload_0
    //   1828: getfield mTextureOutId : [I
    //   1831: iconst_0
    //   1832: iaload
    //   1833: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;I)I
    //   1836: istore #6
    //   1838: iload #4
    //   1840: aload_0
    //   1841: getfield mCustomEvent : I
    //   1844: if_icmpne -> 1852
    //   1847: aload_0
    //   1848: iconst_0
    //   1849: putfield mCustomEvent : I
    //   1852: aload_0
    //   1853: getfield TAG : Ljava/lang/String;
    //   1856: ldc_w 'processTexture result: %d'
    //   1859: iconst_1
    //   1860: anewarray java/lang/Object
    //   1863: dup
    //   1864: iconst_0
    //   1865: iload #6
    //   1867: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1870: aastore
    //   1871: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1874: pop
    //   1875: aload_0
    //   1876: getfield TAG : Ljava/lang/String;
    //   1879: ldc_w 'sticker cost time: %d'
    //   1882: iconst_1
    //   1883: anewarray java/lang/Object
    //   1886: dup
    //   1887: iconst_0
    //   1888: invokestatic currentTimeMillis : ()J
    //   1891: lload #8
    //   1893: lsub
    //   1894: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1897: aastore
    //   1898: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1901: pop
    //   1902: iload #5
    //   1904: istore #4
    //   1906: iload #6
    //   1908: ifne -> 1919
    //   1911: aload_0
    //   1912: getfield mTextureOutId : [I
    //   1915: iconst_0
    //   1916: iaload
    //   1917: istore #4
    //   1919: aload_0
    //   1920: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1923: astore_1
    //   1924: aload_0
    //   1925: getfield mFilterStyle : Ljava/lang/String;
    //   1928: astore #14
    //   1930: aload_1
    //   1931: aload #14
    //   1933: if_acmpeq -> 1954
    //   1936: aload_0
    //   1937: aload #14
    //   1939: putfield mCurrentFilterStyle : Ljava/lang/String;
    //   1942: aload_0
    //   1943: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1946: aload_0
    //   1947: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1950: invokevirtual setStyle : (Ljava/lang/String;)I
    //   1953: pop
    //   1954: aload_0
    //   1955: getfield mCurrentFilterStrength : F
    //   1958: fstore_2
    //   1959: aload_0
    //   1960: getfield mFilterStrength : F
    //   1963: fstore_3
    //   1964: fload_2
    //   1965: fload_3
    //   1966: fcmpl
    //   1967: ifeq -> 1988
    //   1970: aload_0
    //   1971: fload_3
    //   1972: putfield mCurrentFilterStrength : F
    //   1975: aload_0
    //   1976: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1979: iconst_0
    //   1980: aload_0
    //   1981: getfield mCurrentFilterStrength : F
    //   1984: invokevirtual setParam : (IF)I
    //   1987: pop
    //   1988: aload_0
    //   1989: getfield mFilterTextureOutId : [I
    //   1992: ifnonnull -> 2020
    //   1995: aload_0
    //   1996: iconst_1
    //   1997: newarray int
    //   1999: putfield mFilterTextureOutId : [I
    //   2002: aload_0
    //   2003: getfield mImageWidth : I
    //   2006: aload_0
    //   2007: getfield mImageHeight : I
    //   2010: aload_0
    //   2011: getfield mFilterTextureOutId : [I
    //   2014: sipush #3553
    //   2017: invokestatic a : (II[II)V
    //   2020: iload #4
    //   2022: istore #5
    //   2024: aload_0
    //   2025: getfield mNeedFilter : Z
    //   2028: ifeq -> 2105
    //   2031: invokestatic currentTimeMillis : ()J
    //   2034: lstore #8
    //   2036: aload_0
    //   2037: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2040: iload #4
    //   2042: aload_0
    //   2043: getfield mImageWidth : I
    //   2046: aload_0
    //   2047: getfield mImageHeight : I
    //   2050: aload_0
    //   2051: getfield mFilterTextureOutId : [I
    //   2054: iconst_0
    //   2055: iaload
    //   2056: invokevirtual processTexture : (IIII)I
    //   2059: istore #6
    //   2061: aload_0
    //   2062: getfield TAG : Ljava/lang/String;
    //   2065: ldc_w 'filters cost time: %d'
    //   2068: iconst_1
    //   2069: anewarray java/lang/Object
    //   2072: dup
    //   2073: iconst_0
    //   2074: invokestatic currentTimeMillis : ()J
    //   2077: lload #8
    //   2079: lsub
    //   2080: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2083: aastore
    //   2084: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2087: pop
    //   2088: iload #4
    //   2090: istore #5
    //   2092: iload #6
    //   2094: ifne -> 2105
    //   2097: aload_0
    //   2098: getfield mFilterTextureOutId : [I
    //   2101: iconst_0
    //   2102: iaload
    //   2103: istore #5
    //   2105: aload_0
    //   2106: getfield TAG : Ljava/lang/String;
    //   2109: ldc_w 'frame cost time total: %d'
    //   2112: iconst_1
    //   2113: anewarray java/lang/Object
    //   2116: dup
    //   2117: iconst_0
    //   2118: invokestatic currentTimeMillis : ()J
    //   2121: aload_0
    //   2122: getfield mStartTime : J
    //   2125: lsub
    //   2126: aload_0
    //   2127: getfield mRotateCost : J
    //   2130: ladd
    //   2131: aload_0
    //   2132: getfield mObjectCost : J
    //   2135: ladd
    //   2136: aload_0
    //   2137: getfield mFaceAttributeCost : J
    //   2140: ldc2_w 20
    //   2143: ldiv
    //   2144: ladd
    //   2145: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2148: aastore
    //   2149: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2152: pop
    //   2153: iload #5
    //   2155: istore #4
    //   2157: aload_0
    //   2158: getfield mNeedSave : Z
    //   2161: ifeq -> 2175
    //   2164: aload_0
    //   2165: iload #4
    //   2167: invokespecial savePicture : (I)V
    //   2170: aload_0
    //   2171: iconst_0
    //   2172: putfield mNeedSave : Z
    //   2175: aload_0
    //   2176: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2179: ifnull -> 2323
    //   2182: invokestatic glFinish : ()V
    //   2185: aload_0
    //   2186: getfield mVideoEncoderTexture : [I
    //   2189: iconst_0
    //   2190: iload #4
    //   2192: iastore
    //   2193: aload_0
    //   2194: getfield mSurfaceTexture : Landroid/graphics/SurfaceTexture;
    //   2197: aload_0
    //   2198: getfield mStMatrix : [F
    //   2201: invokevirtual getTransformMatrix : ([F)V
    //   2204: aload_0
    //   2205: getfield mStMatrix : [F
    //   2208: astore_1
    //   2209: aload_0
    //   2210: getfield mCameraID : I
    //   2213: iconst_1
    //   2214: if_icmpne -> 2223
    //   2217: iconst_1
    //   2218: istore #12
    //   2220: goto -> 2226
    //   2223: iconst_0
    //   2224: istore #12
    //   2226: aload_0
    //   2227: getfield mCameraID : I
    //   2230: ifne -> 2252
    //   2233: aload_0
    //   2234: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   2237: invokevirtual d : ()I
    //   2240: sipush #270
    //   2243: if_icmpne -> 2252
    //   2246: iconst_1
    //   2247: istore #13
    //   2249: goto -> 2255
    //   2252: iconst_0
    //   2253: istore #13
    //   2255: aload_0
    //   2256: aload_1
    //   2257: iload #12
    //   2259: iload #13
    //   2261: invokespecial processStMatrix : ([FZZ)V
    //   2264: aload_0
    //   2265: monitorenter
    //   2266: aload_0
    //   2267: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2270: ifnull -> 2313
    //   2273: aload_0
    //   2274: getfield mNeedResetEglContext : Z
    //   2277: ifeq -> 2301
    //   2280: aload_0
    //   2281: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2284: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
    //   2287: aload_0
    //   2288: getfield mVideoEncoderTexture : [I
    //   2291: iconst_0
    //   2292: iaload
    //   2293: invokevirtual a : (Landroid/opengl/EGLContext;I)V
    //   2296: aload_0
    //   2297: iconst_0
    //   2298: putfield mNeedResetEglContext : Z
    //   2301: aload_0
    //   2302: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2305: aload_0
    //   2306: getfield mStMatrix : [F
    //   2309: invokevirtual a : ([F)Z
    //   2312: pop
    //   2313: aload_0
    //   2314: monitorexit
    //   2315: goto -> 2323
    //   2318: astore_1
    //   2319: aload_0
    //   2320: monitorexit
    //   2321: aload_1
    //   2322: athrow
    //   2323: aload_0
    //   2324: invokestatic currentTimeMillis : ()J
    //   2327: aload_0
    //   2328: getfield mStartTime : J
    //   2331: lsub
    //   2332: aload_0
    //   2333: getfield mRotateCost : J
    //   2336: ladd
    //   2337: aload_0
    //   2338: getfield mObjectCost : J
    //   2341: ladd
    //   2342: aload_0
    //   2343: getfield mFaceAttributeCost : J
    //   2346: ldc2_w 20
    //   2349: ldiv
    //   2350: ladd
    //   2351: l2i
    //   2352: putfield mFrameCost : I
    //   2355: invokestatic currentTimeMillis : ()J
    //   2358: lstore #8
    //   2360: aload_0
    //   2361: aload_0
    //   2362: getfield mCount : I
    //   2365: iconst_1
    //   2366: iadd
    //   2367: putfield mCount : I
    //   2370: aload_0
    //   2371: getfield mIsFirstCount : Z
    //   2374: ifeq -> 2391
    //   2377: aload_0
    //   2378: lload #8
    //   2380: putfield mCurrentTime : J
    //   2383: aload_0
    //   2384: iconst_0
    //   2385: putfield mIsFirstCount : Z
    //   2388: goto -> 2437
    //   2391: lload #8
    //   2393: aload_0
    //   2394: getfield mCurrentTime : J
    //   2397: lsub
    //   2398: l2i
    //   2399: istore #5
    //   2401: iload #5
    //   2403: sipush #1000
    //   2406: if_icmplt -> 2437
    //   2409: aload_0
    //   2410: lload #8
    //   2412: putfield mCurrentTime : J
    //   2415: aload_0
    //   2416: aload_0
    //   2417: getfield mCount : I
    //   2420: i2f
    //   2421: ldc_w 1000.0
    //   2424: fmul
    //   2425: iload #5
    //   2427: i2f
    //   2428: fdiv
    //   2429: putfield mFps : F
    //   2432: aload_0
    //   2433: iconst_0
    //   2434: putfield mCount : I
    //   2437: aload_0
    //   2438: getfield TAG : Ljava/lang/String;
    //   2441: ldc_w 'render fps: %f'
    //   2444: iconst_1
    //   2445: anewarray java/lang/Object
    //   2448: dup
    //   2449: iconst_0
    //   2450: aload_0
    //   2451: getfield mFps : F
    //   2454: invokestatic valueOf : (F)Ljava/lang/Float;
    //   2457: aastore
    //   2458: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2461: pop
    //   2462: iconst_0
    //   2463: iconst_0
    //   2464: aload_0
    //   2465: getfield mSurfaceWidth : I
    //   2468: aload_0
    //   2469: getfield mSurfaceHeight : I
    //   2472: invokestatic glViewport : (IIII)V
    //   2475: aload_0
    //   2476: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2479: iload #4
    //   2481: invokevirtual onDrawFrame : (I)I
    //   2484: pop
    //   2485: return
    // Exception table:
    //   from	to	target	type
    //   2266	2301	2318	finally
    //   2301	2313	2318	finally
    //   2313	2315	2318	finally
    //   2319	2321	2318	finally
  }
  
  public void onPause() {
    LogUtils.c(this.TAG, "onPause", new Object[0]);
    this.mIsPaused = true;
    this.mSetPreViewSizeSucceed = false;
    this.mCameraProxy.b();
    LogUtils.b(this.TAG, "Release camera", new Object[0]);
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            CameraDisplaySingleInput.this.mSTHumanActionNative.reset();
            CameraDisplaySingleInput.this.mStBeautifyNative.destroyBeautify();
            CameraDisplaySingleInput.this.mStStickerNative.removeAvatarModel();
            CameraDisplaySingleInput.this.mStStickerNative.destroyInstance();
            CameraDisplaySingleInput.this.mSTMobileStreamFilterNative.destroyInstance();
            CameraDisplaySingleInput.this.mSTMobileMakeupNative.destroyInstance();
            CameraDisplaySingleInput.access$2202(CameraDisplaySingleInput.this, null);
            CameraDisplaySingleInput.this.deleteTextures();
            if (CameraDisplaySingleInput.this.mSurfaceTexture != null)
              CameraDisplaySingleInput.this.mSurfaceTexture.release(); 
            CameraDisplaySingleInput.this.mGLRender.destroyFrameBuffers();
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
            //   17: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInput;
            //   20: invokestatic access$3400 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInput;)[I
            //   23: iconst_0
            //   24: iaload
            //   25: invokevirtual a : (Landroid/opengl/EGLContext;I)V
            //   28: aload_0
            //   29: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInput;
            //   32: aload_0
            //   33: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   36: invokestatic access$3502 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplaySingleInput;Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;)Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
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
              CameraDisplaySingleInput.this.deleteTextures();
              if (CameraDisplaySingleInput.this.mCameraProxy.a() != null)
                CameraDisplaySingleInput.this.setUpCamera(); 
              CameraDisplaySingleInput.access$102(CameraDisplaySingleInput.this, false);
            }
          });
      this.mGlSurfaceView.requestRender();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\CameraDisplaySingleInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */