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
import com.sensetime.stmobile.model.STRect;
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

public class CameraDisplayDoubleInput extends BaseDisplay implements GLSurfaceView.Renderer {
  private static final int MESSAGE_ADD_SUB_MODEL = 1001;
  
  private static final int MESSAGE_NEED_ADD_STICKER = 1006;
  
  private static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
  
  private static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
  
  private static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
  
  private static final int MESSAGE_PROCESS_IMAGE = 100;
  
  private static final int MESSAGE_REMOVE_SUB_MODEL = 1002;
  
  private boolean DEBUG = false;
  
  private String TAG = "CameraDisplayDoubleInput";
  
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
  
  private byte[] mImageData;
  
  private Object mImageDataLock = new Object();
  
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
  
  private byte[] mNv21ImageData;
  
  private long mObjectCost = 0L;
  
  private int mParamType = 0;
  
  private Camera.PreviewCallback mPreviewCallback = new Camera.PreviewCallback() {
      public void onPreviewFrame(byte[] param1ArrayOfbyte, Camera param1Camera) {
        if (!CameraDisplayDoubleInput.this.mCameraChanging) {
          if (CameraDisplayDoubleInput.this.mCameraProxy.a() == null)
            return; 
          if (CameraDisplayDoubleInput.this.mImageData == null || CameraDisplayDoubleInput.this.mImageData.length != CameraDisplayDoubleInput.this.mImageHeight * CameraDisplayDoubleInput.this.mImageWidth * 3 / 2) {
            CameraDisplayDoubleInput cameraDisplayDoubleInput = CameraDisplayDoubleInput.this;
            CameraDisplayDoubleInput.access$2102(cameraDisplayDoubleInput, new byte[cameraDisplayDoubleInput.mImageWidth * CameraDisplayDoubleInput.this.mImageHeight * 3 / 2]);
          } 
          synchronized (CameraDisplayDoubleInput.this.mImageDataLock) {
            System.arraycopy(param1ArrayOfbyte, 0, CameraDisplayDoubleInput.this.mImageData, 0, param1ArrayOfbyte.length);
            CameraDisplayDoubleInput.this.mProcessImageHandler.removeMessages(100);
            CameraDisplayDoubleInput.this.mProcessImageHandler.sendEmptyMessage(100);
            CameraDisplayDoubleInput.this.mGlSurfaceView.requestRender();
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
  
  public CameraDisplayDoubleInput(Context paramContext, ChangePreviewSizeListener paramChangePreviewSizeListener, GLSurfaceView paramGLSurfaceView) {
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
    int k = Accelerometer.c();
    int j = k - 1;
    int i = j;
    if (j < 0)
      i = k ^ 0x3; 
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
    int i = this.mSTMobileStreamFilterNative.createInstance();
    LogUtils.c(this.TAG, "filters create instance result %d", new Object[] { Integer.valueOf(i) });
    this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle);
    this.mCurrentFilterStrength = this.mFilterStrength;
    this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
  }
  
  private void initHandlerManager() {
    this.mProcessImageThread = new HandlerThread("ProcessImageThread");
    this.mProcessImageThread.start();
    this.mProcessImageHandler = new Handler(this.mProcessImageThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what == 100 && !CameraDisplayDoubleInput.this.mIsPaused && !CameraDisplayDoubleInput.this.mCameraChanging)
            CameraDisplayDoubleInput.this.objectTrack(); 
        }
      };
    this.mSubModelsManagerThread = new HandlerThread("SubModelManagerThread");
    this.mSubModelsManagerThread.start();
    this.mSubModelsManagerHandler = new Handler(this.mSubModelsManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplayDoubleInput.this.mIsPaused && !CameraDisplayDoubleInput.this.mCameraChanging && CameraDisplayDoubleInput.this.mIsCreateHumanActionHandleSucceeded) {
            int i = param1Message.what;
            if (i != 1001) {
              if (i != 1002)
                return; 
              i = ((Integer)param1Message.obj).intValue();
              if (i != 0) {
                CameraDisplayDoubleInput.this.removeSubModel(i);
                return;
              } 
            } else {
              String str = (String)param1Message.obj;
              if (str != null)
                CameraDisplayDoubleInput.this.addSubModel(str); 
            } 
          } 
        }
      };
    this.mChangeStickerManagerThread = new HandlerThread("ChangeStickerManagerThread");
    this.mChangeStickerManagerThread.start();
    this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!CameraDisplayDoubleInput.this.mIsPaused && !CameraDisplayDoubleInput.this.mCameraChanging) {
            CameraDisplayDoubleInput cameraDisplayDoubleInput2;
            String str;
            CameraDisplayDoubleInput cameraDisplayDoubleInput1;
            Message message;
            int i;
            int j;
            boolean bool;
            switch (param1Message.what) {
              default:
                return;
              case 1005:
                CameraDisplayDoubleInput.this.mStStickerNative.removeAllStickers();
                if (CameraDisplayDoubleInput.this.mCurrentStickerMaps != null)
                  CameraDisplayDoubleInput.this.mCurrentStickerMaps.clear(); 
                cameraDisplayDoubleInput2 = CameraDisplayDoubleInput.this;
                bool = cameraDisplayDoubleInput2.mNeedBeautify;
                cameraDisplayDoubleInput2.setHumanActionDetectConfig(CameraDisplayDoubleInput.this.mNeedFaceAttribute | bool, CameraDisplayDoubleInput.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInput.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1004:
                i = ((Integer)((Message)cameraDisplayDoubleInput2).obj).intValue();
                j = CameraDisplayDoubleInput.this.mStStickerNative.removeSticker(i);
                if (CameraDisplayDoubleInput.this.mCurrentStickerMaps != null && j == 0)
                  CameraDisplayDoubleInput.this.mCurrentStickerMaps.remove(Integer.valueOf(i)); 
                cameraDisplayDoubleInput2 = CameraDisplayDoubleInput.this;
                cameraDisplayDoubleInput2.setHumanActionDetectConfig(cameraDisplayDoubleInput2.mNeedBeautify | CameraDisplayDoubleInput.this.mNeedFaceAttribute, CameraDisplayDoubleInput.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInput.this.mSTMobileMakeupNative.getTriggerAction());
                return;
              case 1003:
                str = (String)((Message)cameraDisplayDoubleInput2).obj;
                CameraDisplayDoubleInput.access$602(CameraDisplayDoubleInput.this, str);
                i = CameraDisplayDoubleInput.this.mStStickerNative.changeSticker(CameraDisplayDoubleInput.this.mCurrentSticker);
                LogUtils.c(CameraDisplayDoubleInput.this.TAG, "change sticker result: %d", new Object[] { Integer.valueOf(i) });
                cameraDisplayDoubleInput1 = CameraDisplayDoubleInput.this;
                CameraDisplayDoubleInput.access$902(cameraDisplayDoubleInput1, cameraDisplayDoubleInput1.mStStickerNative.getNeededInputParams());
                cameraDisplayDoubleInput1 = CameraDisplayDoubleInput.this;
                cameraDisplayDoubleInput1.setHumanActionDetectConfig(cameraDisplayDoubleInput1.mNeedBeautify | CameraDisplayDoubleInput.this.mNeedFaceAttribute, CameraDisplayDoubleInput.this.mStStickerNative.getTriggerAction(), CameraDisplayDoubleInput.this.mSTMobileMakeupNative.getTriggerAction());
                message = CameraDisplayDoubleInput.this.mHandler.obtainMessage(110);
                CameraDisplayDoubleInput.this.mHandler.sendMessage(message);
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
            synchronized (CameraDisplayDoubleInput.this.mHumanActionHandleLock) {
              long l = System.currentTimeMillis();
              int i = CameraDisplayDoubleInput.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), CameraDisplayDoubleInput.this.mHumanActionCreateConfig, CameraDisplayDoubleInput.this.mContext.getAssets());
              LogUtils.c(CameraDisplayDoubleInput.this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
              String str = CameraDisplayDoubleInput.this.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("load model name: ");
              stringBuilder.append(FileUtils.a());
              stringBuilder.append(" cost time: ");
              stringBuilder.append(System.currentTimeMillis() - l);
              Log.e(str, stringBuilder.toString());
              if (i == 0) {
                i = CameraDisplayDoubleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", CameraDisplayDoubleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInput.this.TAG, "add hand model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplayDoubleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Segment_1.5.0.model", CameraDisplayDoubleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInput.this.TAG, "add figure segment model result: %d", new Object[] { Integer.valueOf(i) });
                CameraDisplayDoubleInput.access$302(CameraDisplayDoubleInput.this, true);
                CameraDisplayDoubleInput.this.mSTHumanActionNative.setParam(2, 0.35F);
                i = CameraDisplayDoubleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Face_Extra_5.23.0.model", CameraDisplayDoubleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInput.this.TAG, "add face extra model result: %d", new Object[] { Integer.valueOf(i) });
                i = CameraDisplayDoubleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Iris_2.0.0.model", CameraDisplayDoubleInput.this.mContext.getAssets());
                LogUtils.c(CameraDisplayDoubleInput.this.TAG, "add eyeball contour model result: %d", new Object[] { Integer.valueOf(i) });
                if (CameraDisplayDoubleInput.this.mNeedAvatar) {
                  i = CameraDisplayDoubleInput.this.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Avatar_Help_2.0.0.model", CameraDisplayDoubleInput.this.mContext.getAssets());
                  LogUtils.c(CameraDisplayDoubleInput.this.TAG, "add avatar help model result: %d", new Object[] { Integer.valueOf(i) });
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
        String str1 = this.mCurrentStickerMaps.get(integer);
        int j = this.mStStickerNative.addSticker(str1);
        treeMap.put(Integer.valueOf(j), str1);
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
    long l = System.currentTimeMillis();
    this.mStStickerNative.loadAvatarModelFromAssetFile("M_SenseME_Avatar_Core_2.0.0.model", this.mContext.getAssets());
    String str = this.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("load model name: M_SenseME_Avatar_Core_2.0.0.model cost time: ");
    stringBuilder.append(System.currentTimeMillis() - l);
    Log.e(str, stringBuilder.toString());
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction());
    LogUtils.c(this.TAG, "the result for createInstance for human_action is %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void objectTrack() {
    byte[] arrayOfByte = this.mImageData;
    if (arrayOfByte != null) {
      if (arrayOfByte.length == 0)
        return; 
      boolean bool = this.mNeedObject;
      if (bool) {
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
        if (!bool || (!this.mNeedBeautify && !this.mNeedSticker && !this.mNeedFaceAttribute)) {
          Message message = this.mHandler.obtainMessage(130);
          this.mHandler.sendMessage(message);
        } 
      } 
    } 
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
      return;
    } 
    this.mDetectConfig = paramLong1 | paramLong2;
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
      return;
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
      this.mCurrentPreview = paramInt;
      this.mSetPreViewSizeSucceed = false;
      this.mIsChangingPreviewSize = true;
      this.mCameraChanging = true;
      this.mCameraProxy.c();
      this.mGlSurfaceView.queueEvent(new Runnable() {
            public void run() {
              if (CameraDisplayDoubleInput.this.mRGBABuffer != null)
                CameraDisplayDoubleInput.this.mRGBABuffer.clear(); 
              CameraDisplayDoubleInput.access$2902(CameraDisplayDoubleInput.this, null);
              CameraDisplayDoubleInput.this.deleteTextures();
              if (CameraDisplayDoubleInput.this.mCameraProxy.a() != null)
                CameraDisplayDoubleInput.this.setUpCamera(); 
              CameraDisplayDoubleInput.this.mGLRender.init(CameraDisplayDoubleInput.this.mImageWidth, CameraDisplayDoubleInput.this.mImageHeight);
              if (CameraDisplayDoubleInput.this.DEBUG)
                CameraDisplayDoubleInput.this.mGLRender.initDrawPoints(); 
              if (CameraDisplayDoubleInput.this.mNeedObject)
                CameraDisplayDoubleInput.this.resetIndexRect(); 
              CameraDisplayDoubleInput.this.mGLRender.calculateVertexBuffer(CameraDisplayDoubleInput.this.mSurfaceWidth, CameraDisplayDoubleInput.this.mSurfaceHeight, CameraDisplayDoubleInput.this.mImageWidth, CameraDisplayDoubleInput.this.mImageHeight);
              if (CameraDisplayDoubleInput.this.mListener != null)
                CameraDisplayDoubleInput.this.mListener.onChangePreviewSize(CameraDisplayDoubleInput.this.mImageHeight, CameraDisplayDoubleInput.this.mImageWidth); 
              CameraDisplayDoubleInput.access$102(CameraDisplayDoubleInput.this, false);
              CameraDisplayDoubleInput.access$4002(CameraDisplayDoubleInput.this, false);
              LogUtils.b(CameraDisplayDoubleInput.this.TAG, "exit  change Preview size queue event", new Object[0]);
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
      setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, this.mStStickerNative.getTriggerAction(), this.mSTMobileMakeupNative.getTriggerAction()); 
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
    this.mCameraProxy.a(paramBoolean);
  }
  
  public boolean isChangingPreviewSize() {
    return this.mIsChangingPreviewSize;
  }
  
  public void onDestroy() {
    synchronized (this.mHumanActionHandleLock) {
      this.mSTHumanActionNative.destroyInstance();
      this.mSTFaceAttributeNative.destroyInstance();
      this.mSTMobileObjectTrackNative.destroyInstance();
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
    //   175: ifnull -> 2517
    //   178: aload_0
    //   179: getfield mIsPaused : Z
    //   182: ifne -> 2517
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
    //   220: lstore #9
    //   222: aload_0
    //   223: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   226: astore #15
    //   228: aload_0
    //   229: getfield mTextureId : I
    //   232: istore #4
    //   234: aconst_null
    //   235: astore_1
    //   236: aload #15
    //   238: iload #4
    //   240: aconst_null
    //   241: invokevirtual preProcess : (ILjava/nio/ByteBuffer;)I
    //   244: istore #5
    //   246: aload_0
    //   247: getfield TAG : Ljava/lang/String;
    //   250: ldc_w 'preprocess cost time: %d'
    //   253: iconst_1
    //   254: anewarray java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: invokestatic currentTimeMillis : ()J
    //   262: lload #9
    //   264: lsub
    //   265: invokestatic valueOf : (J)Ljava/lang/Long;
    //   268: aastore
    //   269: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   272: pop
    //   273: iload #5
    //   275: istore #4
    //   277: aload_0
    //   278: getfield mShowOriginal : Z
    //   281: ifne -> 2189
    //   284: aload_0
    //   285: getfield mNeedBeautify : Z
    //   288: ifne -> 309
    //   291: aload_0
    //   292: getfield mNeedSticker : Z
    //   295: ifne -> 309
    //   298: iload #5
    //   300: istore #6
    //   302: aload_0
    //   303: getfield mNeedFaceAttribute : Z
    //   306: ifeq -> 1882
    //   309: aload_0
    //   310: getfield mIsCreateHumanActionHandleSucceeded : Z
    //   313: ifeq -> 822
    //   316: aload_0
    //   317: getfield mCameraChanging : Z
    //   320: ifne -> 821
    //   323: aload_0
    //   324: getfield mImageData : [B
    //   327: astore_1
    //   328: aload_1
    //   329: ifnull -> 821
    //   332: aload_1
    //   333: arraylength
    //   334: aload_0
    //   335: getfield mImageHeight : I
    //   338: aload_0
    //   339: getfield mImageWidth : I
    //   342: imul
    //   343: iconst_3
    //   344: imul
    //   345: iconst_2
    //   346: idiv
    //   347: if_icmpeq -> 351
    //   350: return
    //   351: aload_0
    //   352: getfield mImageDataLock : Ljava/lang/Object;
    //   355: astore_1
    //   356: aload_1
    //   357: monitorenter
    //   358: aload_0
    //   359: getfield mNv21ImageData : [B
    //   362: ifnull -> 386
    //   365: aload_0
    //   366: getfield mNv21ImageData : [B
    //   369: arraylength
    //   370: aload_0
    //   371: getfield mImageHeight : I
    //   374: aload_0
    //   375: getfield mImageWidth : I
    //   378: imul
    //   379: iconst_3
    //   380: imul
    //   381: iconst_2
    //   382: idiv
    //   383: if_icmpeq -> 405
    //   386: aload_0
    //   387: aload_0
    //   388: getfield mImageWidth : I
    //   391: aload_0
    //   392: getfield mImageHeight : I
    //   395: imul
    //   396: iconst_3
    //   397: imul
    //   398: iconst_2
    //   399: idiv
    //   400: newarray byte
    //   402: putfield mNv21ImageData : [B
    //   405: aload_0
    //   406: getfield mImageData : [B
    //   409: ifnull -> 443
    //   412: aload_0
    //   413: getfield mNv21ImageData : [B
    //   416: arraylength
    //   417: aload_0
    //   418: getfield mImageData : [B
    //   421: arraylength
    //   422: if_icmplt -> 443
    //   425: aload_0
    //   426: getfield mImageData : [B
    //   429: iconst_0
    //   430: aload_0
    //   431: getfield mNv21ImageData : [B
    //   434: iconst_0
    //   435: aload_0
    //   436: getfield mImageData : [B
    //   439: arraylength
    //   440: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   443: aload_1
    //   444: monitorexit
    //   445: aload_0
    //   446: getfield mImageHeight : I
    //   449: aload_0
    //   450: getfield mImageWidth : I
    //   453: imul
    //   454: iconst_3
    //   455: imul
    //   456: iconst_2
    //   457: idiv
    //   458: aload_0
    //   459: getfield mNv21ImageData : [B
    //   462: arraylength
    //   463: if_icmple -> 467
    //   466: return
    //   467: invokestatic currentTimeMillis : ()J
    //   470: lstore #9
    //   472: aload_0
    //   473: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   476: aload_0
    //   477: getfield mNv21ImageData : [B
    //   480: iconst_3
    //   481: aload_0
    //   482: getfield mDetectConfig : J
    //   485: aload_0
    //   486: invokespecial getHumanActionOrientation : ()I
    //   489: aload_0
    //   490: getfield mImageHeight : I
    //   493: aload_0
    //   494: getfield mImageWidth : I
    //   497: invokevirtual humanActionDetect : ([BIJIII)Lcom/sensetime/stmobile/model/STHumanAction;
    //   500: astore_1
    //   501: aload_0
    //   502: getfield TAG : Ljava/lang/String;
    //   505: ldc_w 'human action cost time: %d'
    //   508: iconst_1
    //   509: anewarray java/lang/Object
    //   512: dup
    //   513: iconst_0
    //   514: invokestatic currentTimeMillis : ()J
    //   517: lload #9
    //   519: lsub
    //   520: invokestatic valueOf : (J)Ljava/lang/Long;
    //   523: aastore
    //   524: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   527: pop
    //   528: aload_0
    //   529: getfield mNeedDistance : Z
    //   532: ifeq -> 628
    //   535: aload_1
    //   536: ifnull -> 623
    //   539: aload_1
    //   540: getfield faceCount : I
    //   543: ifle -> 623
    //   546: invokestatic currentTimeMillis : ()J
    //   549: lstore #9
    //   551: aload_0
    //   552: aload_0
    //   553: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   556: aload_1
    //   557: getfield faces : [Lcom/sensetime/stmobile/model/STMobileFaceInfo;
    //   560: iconst_0
    //   561: aaload
    //   562: aload_0
    //   563: invokespecial getHumanActionOrientation : ()I
    //   566: aload_0
    //   567: getfield mImageHeight : I
    //   570: aload_0
    //   571: getfield mImageWidth : I
    //   574: aload_0
    //   575: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   578: invokevirtual a : ()Landroid/hardware/Camera;
    //   581: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   584: invokevirtual getVerticalViewAngle : ()F
    //   587: invokevirtual getFaceDistance : (Lcom/sensetime/stmobile/model/STMobileFaceInfo;IIIF)F
    //   590: putfield mFaceDistance : F
    //   593: aload_0
    //   594: getfield TAG : Ljava/lang/String;
    //   597: ldc_w 'human action face distance cost time: %d'
    //   600: iconst_1
    //   601: anewarray java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: invokestatic currentTimeMillis : ()J
    //   609: lload #9
    //   611: lsub
    //   612: invokestatic valueOf : (J)Ljava/lang/Long;
    //   615: aastore
    //   616: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   619: pop
    //   620: goto -> 628
    //   623: aload_0
    //   624: fconst_0
    //   625: putfield mFaceDistance : F
    //   628: aload_0
    //   629: getfield DEBUG : Z
    //   632: ifeq -> 787
    //   635: aload_1
    //   636: ifnull -> 744
    //   639: aload_1
    //   640: getfield faceCount : I
    //   643: ifle -> 744
    //   646: invokestatic currentTimeMillis : ()J
    //   649: lstore #9
    //   651: aload_0
    //   652: getfield mSTHumanActionNative : Lcom/sensetime/stmobile/STMobileHumanActionNative;
    //   655: astore #15
    //   657: aload_0
    //   658: invokespecial getHumanActionOrientation : ()I
    //   661: istore #4
    //   663: aload_0
    //   664: getfield mCameraID : I
    //   667: iconst_1
    //   668: if_icmpne -> 677
    //   671: iconst_1
    //   672: istore #13
    //   674: goto -> 680
    //   677: iconst_0
    //   678: istore #13
    //   680: aload_0
    //   681: aload_1
    //   682: iload #4
    //   684: iload #13
    //   686: invokestatic getExpression : (Lcom/sensetime/stmobile/model/STHumanAction;IZ)[Z
    //   689: putfield mFaceExpressionResult : [Z
    //   692: aload_0
    //   693: getfield TAG : Ljava/lang/String;
    //   696: ldc_w 'face expression cost time: %d'
    //   699: iconst_1
    //   700: anewarray java/lang/Object
    //   703: dup
    //   704: iconst_0
    //   705: invokestatic currentTimeMillis : ()J
    //   708: lload #9
    //   710: lsub
    //   711: invokestatic valueOf : (J)Ljava/lang/Long;
    //   714: aastore
    //   715: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   718: pop
    //   719: aload_0
    //   720: getfield mHandler : Landroid/os/Handler;
    //   723: sipush #140
    //   726: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   729: astore #15
    //   731: aload_0
    //   732: getfield mHandler : Landroid/os/Handler;
    //   735: aload #15
    //   737: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   740: pop
    //   741: goto -> 749
    //   744: aload_0
    //   745: aconst_null
    //   746: putfield mFaceExpressionResult : [Z
    //   749: aload_0
    //   750: getfield mFrameCount : I
    //   753: istore #4
    //   755: iload #4
    //   757: bipush #20
    //   759: if_icmpgt -> 773
    //   762: aload_0
    //   763: iload #4
    //   765: iconst_1
    //   766: iadd
    //   767: putfield mFrameCount : I
    //   770: goto -> 787
    //   773: aload_0
    //   774: iconst_0
    //   775: putfield mFrameCount : I
    //   778: aload_0
    //   779: aload_0
    //   780: getfield mNv21ImageData : [B
    //   783: aload_1
    //   784: invokespecial faceAttributeDetect : ([BLcom/sensetime/stmobile/model/STHumanAction;)V
    //   787: aload_1
    //   788: aload_0
    //   789: getfield mImageWidth : I
    //   792: aload_0
    //   793: getfield mImageHeight : I
    //   796: aload_0
    //   797: getfield mCameraID : I
    //   800: aload_0
    //   801: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   804: invokevirtual d : ()I
    //   807: invokestatic humanActionRotateAndMirror : (Lcom/sensetime/stmobile/model/STHumanAction;IIII)Lcom/sensetime/stmobile/model/STHumanAction;
    //   810: astore_1
    //   811: goto -> 822
    //   814: astore #15
    //   816: aload_1
    //   817: monitorexit
    //   818: aload #15
    //   820: athrow
    //   821: return
    //   822: aload_0
    //   823: invokespecial getCurrentOrientation : ()I
    //   826: istore #7
    //   828: iload #5
    //   830: istore #4
    //   832: aload_1
    //   833: astore #15
    //   835: aload_0
    //   836: getfield mNeedBeautify : Z
    //   839: ifeq -> 1034
    //   842: invokestatic currentTimeMillis : ()J
    //   845: lstore #9
    //   847: aload_0
    //   848: getfield mNeedBeautyOutputBuffer : Z
    //   851: ifne -> 889
    //   854: aload_0
    //   855: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   858: iload #5
    //   860: aload_0
    //   861: getfield mImageWidth : I
    //   864: aload_0
    //   865: getfield mImageHeight : I
    //   868: iload #7
    //   870: aload_1
    //   871: aload_0
    //   872: getfield mBeautifyTextureId : [I
    //   875: iconst_0
    //   876: iaload
    //   877: aload_0
    //   878: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   881: invokevirtual processTexture : (IIIILcom/sensetime/stmobile/model/STHumanAction;ILcom/sensetime/stmobile/model/STHumanAction;)I
    //   884: istore #6
    //   886: goto -> 962
    //   889: aload_0
    //   890: getfield mImageWidth : I
    //   893: istore #4
    //   895: aload_0
    //   896: getfield mImageHeight : I
    //   899: istore #6
    //   901: iload #4
    //   903: iload #6
    //   905: imul
    //   906: iconst_4
    //   907: imul
    //   908: newarray byte
    //   910: astore #15
    //   912: aload_0
    //   913: getfield mStBeautifyNative : Lcom/sensetime/stmobile/STBeautifyNative;
    //   916: iload #5
    //   918: iload #4
    //   920: iload #6
    //   922: iload #7
    //   924: aload_1
    //   925: aload_0
    //   926: getfield mBeautifyTextureId : [I
    //   929: iconst_0
    //   930: iaload
    //   931: aload #15
    //   933: bipush #6
    //   935: aload_0
    //   936: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   939: invokevirtual processTextureAndOutputBuffer : (IIIILcom/sensetime/stmobile/model/STHumanAction;I[BILcom/sensetime/stmobile/model/STHumanAction;)I
    //   942: istore #6
    //   944: aload_0
    //   945: getfield mNeedSave : Z
    //   948: ifeq -> 962
    //   951: iload #6
    //   953: ifne -> 962
    //   956: aload_0
    //   957: aload #15
    //   959: invokespecial saveImageBuffer2Picture : ([B)V
    //   962: invokestatic currentTimeMillis : ()J
    //   965: lstore #11
    //   967: aload_0
    //   968: getfield TAG : Ljava/lang/String;
    //   971: ldc_w 'beautify cost time: %d'
    //   974: iconst_1
    //   975: anewarray java/lang/Object
    //   978: dup
    //   979: iconst_0
    //   980: lload #11
    //   982: lload #9
    //   984: lsub
    //   985: invokestatic valueOf : (J)Ljava/lang/Long;
    //   988: aastore
    //   989: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   992: pop
    //   993: iload #5
    //   995: istore #4
    //   997: aload_1
    //   998: astore #15
    //   1000: iload #6
    //   1002: ifne -> 1034
    //   1005: aload_0
    //   1006: getfield mBeautifyTextureId : [I
    //   1009: iconst_0
    //   1010: iaload
    //   1011: istore #4
    //   1013: aload_0
    //   1014: getfield mHumanActionBeautyOutput : Lcom/sensetime/stmobile/model/STHumanAction;
    //   1017: astore #15
    //   1019: aload_0
    //   1020: getfield TAG : Ljava/lang/String;
    //   1023: ldc_w 'replace enlarge eye and shrink face action'
    //   1026: iconst_0
    //   1027: anewarray java/lang/Object
    //   1030: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1033: pop
    //   1034: iload #4
    //   1036: istore #5
    //   1038: aload_0
    //   1039: getfield mNeedMakeup : Z
    //   1042: ifeq -> 1119
    //   1045: invokestatic currentTimeMillis : ()J
    //   1048: lstore #9
    //   1050: iload #4
    //   1052: istore #5
    //   1054: aload_0
    //   1055: getfield mSTMobileMakeupNative : Lcom/sensetime/stmobile/STMobileMakeupNative;
    //   1058: iload #4
    //   1060: aload #15
    //   1062: iload #7
    //   1064: aload_0
    //   1065: getfield mImageWidth : I
    //   1068: aload_0
    //   1069: getfield mImageHeight : I
    //   1072: aload_0
    //   1073: getfield mMakeupTextureId : [I
    //   1076: iconst_0
    //   1077: iaload
    //   1078: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIII)I
    //   1081: ifne -> 1092
    //   1084: aload_0
    //   1085: getfield mMakeupTextureId : [I
    //   1088: iconst_0
    //   1089: iaload
    //   1090: istore #5
    //   1092: aload_0
    //   1093: getfield TAG : Ljava/lang/String;
    //   1096: ldc_w 'makeup cost time: %d'
    //   1099: iconst_1
    //   1100: anewarray java/lang/Object
    //   1103: dup
    //   1104: iconst_0
    //   1105: invokestatic currentTimeMillis : ()J
    //   1108: lload #9
    //   1110: lsub
    //   1111: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1114: aastore
    //   1115: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1118: pop
    //   1119: aload_0
    //   1120: getfield mCameraChanging : Z
    //   1123: ifeq -> 1127
    //   1126: return
    //   1127: iload #5
    //   1129: istore #4
    //   1131: aload_0
    //   1132: getfield mNeedSticker : Z
    //   1135: ifeq -> 1483
    //   1138: aload_0
    //   1139: getfield mCustomEvent : I
    //   1142: istore #8
    //   1144: aload_0
    //   1145: getfield mParamType : I
    //   1148: iconst_1
    //   1149: iand
    //   1150: iconst_1
    //   1151: if_icmpne -> 1222
    //   1154: aload_0
    //   1155: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1158: astore_1
    //   1159: aload_1
    //   1160: ifnull -> 1222
    //   1163: aload_1
    //   1164: getfield values : [F
    //   1167: ifnull -> 1222
    //   1170: aload_0
    //   1171: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1174: getfield values : [F
    //   1177: arraylength
    //   1178: ifle -> 1222
    //   1181: aload_0
    //   1182: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   1185: getfield values : [F
    //   1188: astore_1
    //   1189: aload_0
    //   1190: getfield mCameraID : I
    //   1193: iconst_1
    //   1194: if_icmpne -> 1203
    //   1197: iconst_1
    //   1198: istore #13
    //   1200: goto -> 1206
    //   1203: iconst_0
    //   1204: istore #13
    //   1206: new com/sensetime/stmobile/model/STStickerInputParams
    //   1209: dup
    //   1210: aload_1
    //   1211: iload #13
    //   1213: iload #8
    //   1215: invokespecial <init> : ([FZI)V
    //   1218: astore_1
    //   1219: goto -> 1270
    //   1222: aload_0
    //   1223: getfield mCameraID : I
    //   1226: iconst_1
    //   1227: if_icmpne -> 1236
    //   1230: iconst_1
    //   1231: istore #13
    //   1233: goto -> 1239
    //   1236: iconst_0
    //   1237: istore #13
    //   1239: new com/sensetime/stmobile/model/STStickerInputParams
    //   1242: dup
    //   1243: iconst_4
    //   1244: newarray float
    //   1246: dup
    //   1247: iconst_0
    //   1248: fconst_0
    //   1249: fastore
    //   1250: dup
    //   1251: iconst_1
    //   1252: fconst_0
    //   1253: fastore
    //   1254: dup
    //   1255: iconst_2
    //   1256: fconst_0
    //   1257: fastore
    //   1258: dup
    //   1259: iconst_3
    //   1260: fconst_1
    //   1261: fastore
    //   1262: iload #13
    //   1264: iload #8
    //   1266: invokespecial <init> : ([FZI)V
    //   1269: astore_1
    //   1270: invokestatic currentTimeMillis : ()J
    //   1273: lstore #9
    //   1275: aload_0
    //   1276: getfield mNeedStickerOutputBuffer : Z
    //   1279: ifne -> 1317
    //   1282: aload_0
    //   1283: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1286: iload #5
    //   1288: aload #15
    //   1290: iload #7
    //   1292: iconst_0
    //   1293: aload_0
    //   1294: getfield mImageWidth : I
    //   1297: aload_0
    //   1298: getfield mImageHeight : I
    //   1301: iconst_0
    //   1302: aload_1
    //   1303: aload_0
    //   1304: getfield mTextureOutId : [I
    //   1307: iconst_0
    //   1308: iaload
    //   1309: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;I)I
    //   1312: istore #6
    //   1314: goto -> 1402
    //   1317: aload_0
    //   1318: getfield mImageWidth : I
    //   1321: istore #4
    //   1323: aload_0
    //   1324: getfield mImageHeight : I
    //   1327: istore #6
    //   1329: iload #4
    //   1331: iload #6
    //   1333: imul
    //   1334: iconst_4
    //   1335: imul
    //   1336: newarray byte
    //   1338: astore #16
    //   1340: aload_0
    //   1341: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   1344: iload #5
    //   1346: aload #15
    //   1348: iload #7
    //   1350: iconst_0
    //   1351: iload #4
    //   1353: iload #6
    //   1355: iconst_0
    //   1356: aload_1
    //   1357: aload_0
    //   1358: getfield mTextureOutId : [I
    //   1361: iconst_0
    //   1362: iaload
    //   1363: bipush #6
    //   1365: aload #16
    //   1367: invokevirtual processTextureAndOutputBuffer : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;II[B)I
    //   1370: istore #4
    //   1372: iload #4
    //   1374: istore #6
    //   1376: aload_0
    //   1377: getfield mNeedSave : Z
    //   1380: ifeq -> 1402
    //   1383: iload #4
    //   1385: istore #6
    //   1387: iload #4
    //   1389: ifne -> 1402
    //   1392: aload_0
    //   1393: aload #16
    //   1395: invokespecial saveImageBuffer2Picture : ([B)V
    //   1398: iload #4
    //   1400: istore #6
    //   1402: iload #8
    //   1404: aload_0
    //   1405: getfield mCustomEvent : I
    //   1408: if_icmpne -> 1416
    //   1411: aload_0
    //   1412: iconst_0
    //   1413: putfield mCustomEvent : I
    //   1416: aload_0
    //   1417: getfield TAG : Ljava/lang/String;
    //   1420: ldc_w 'processTexture result: %d'
    //   1423: iconst_1
    //   1424: anewarray java/lang/Object
    //   1427: dup
    //   1428: iconst_0
    //   1429: iload #6
    //   1431: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1434: aastore
    //   1435: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1438: pop
    //   1439: aload_0
    //   1440: getfield TAG : Ljava/lang/String;
    //   1443: ldc_w 'sticker cost time: %d'
    //   1446: iconst_1
    //   1447: anewarray java/lang/Object
    //   1450: dup
    //   1451: iconst_0
    //   1452: invokestatic currentTimeMillis : ()J
    //   1455: lload #9
    //   1457: lsub
    //   1458: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1461: aastore
    //   1462: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1465: pop
    //   1466: iload #5
    //   1468: istore #4
    //   1470: iload #6
    //   1472: ifne -> 1483
    //   1475: aload_0
    //   1476: getfield mTextureOutId : [I
    //   1479: iconst_0
    //   1480: iaload
    //   1481: istore #4
    //   1483: iload #4
    //   1485: istore #6
    //   1487: aload_0
    //   1488: getfield DEBUG : Z
    //   1491: ifeq -> 1882
    //   1494: aload #15
    //   1496: ifnull -> 1633
    //   1499: aload #15
    //   1501: invokevirtual getImage : ()Lcom/sensetime/stmobile/model/STImage;
    //   1504: ifnull -> 1532
    //   1507: aload_0
    //   1508: getfield TAG : Ljava/lang/String;
    //   1511: ldc_w 'human action background result: %d'
    //   1514: iconst_1
    //   1515: anewarray java/lang/Object
    //   1518: dup
    //   1519: iconst_0
    //   1520: iconst_1
    //   1521: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1524: aastore
    //   1525: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1528: pop
    //   1529: goto -> 1554
    //   1532: aload_0
    //   1533: getfield TAG : Ljava/lang/String;
    //   1536: ldc_w 'human action background result: %d'
    //   1539: iconst_1
    //   1540: anewarray java/lang/Object
    //   1543: dup
    //   1544: iconst_0
    //   1545: iconst_0
    //   1546: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1549: aastore
    //   1550: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1553: pop
    //   1554: aload #15
    //   1556: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1559: ifnull -> 1608
    //   1562: aload #15
    //   1564: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1567: arraylength
    //   1568: ifle -> 1608
    //   1571: aload_0
    //   1572: aload #15
    //   1574: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   1577: iconst_0
    //   1578: aaload
    //   1579: getfield handAction : J
    //   1582: putfield mHandAction : J
    //   1585: aload_0
    //   1586: getfield mHandler : Landroid/os/Handler;
    //   1589: sipush #141
    //   1592: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1595: astore_1
    //   1596: aload_0
    //   1597: getfield mHandler : Landroid/os/Handler;
    //   1600: aload_1
    //   1601: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1604: pop
    //   1605: goto -> 1633
    //   1608: aload_0
    //   1609: lconst_0
    //   1610: putfield mHandAction : J
    //   1613: aload_0
    //   1614: getfield mHandler : Landroid/os/Handler;
    //   1617: sipush #142
    //   1620: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1623: astore_1
    //   1624: aload_0
    //   1625: getfield mHandler : Landroid/os/Handler;
    //   1628: aload_1
    //   1629: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1632: pop
    //   1633: iload #4
    //   1635: istore #6
    //   1637: aload #15
    //   1639: ifnull -> 1882
    //   1642: aload #15
    //   1644: getfield faceCount : I
    //   1647: ifle -> 1707
    //   1650: iconst_0
    //   1651: istore #5
    //   1653: iload #5
    //   1655: aload #15
    //   1657: getfield faceCount : I
    //   1660: if_icmpge -> 1707
    //   1663: aload #15
    //   1665: iload #5
    //   1667: aload_0
    //   1668: getfield mImageWidth : I
    //   1671: aload_0
    //   1672: getfield mImageHeight : I
    //   1675: invokestatic a : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1678: astore_1
    //   1679: aload_1
    //   1680: ifnull -> 1698
    //   1683: aload_1
    //   1684: arraylength
    //   1685: ifle -> 1698
    //   1688: aload_0
    //   1689: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1692: iload #4
    //   1694: aload_1
    //   1695: invokevirtual onDrawPoints : (I[F)V
    //   1698: iload #5
    //   1700: iconst_1
    //   1701: iadd
    //   1702: istore #5
    //   1704: goto -> 1653
    //   1707: aload #15
    //   1709: getfield bodyCount : I
    //   1712: ifle -> 1866
    //   1715: iconst_0
    //   1716: istore #5
    //   1718: iload #5
    //   1720: aload #15
    //   1722: getfield bodyCount : I
    //   1725: if_icmpge -> 1772
    //   1728: aload #15
    //   1730: iload #5
    //   1732: aload_0
    //   1733: getfield mImageWidth : I
    //   1736: aload_0
    //   1737: getfield mImageHeight : I
    //   1740: invokestatic c : (Lcom/sensetime/stmobile/model/STHumanAction;III)[F
    //   1743: astore_1
    //   1744: aload_1
    //   1745: ifnull -> 1763
    //   1748: aload_1
    //   1749: arraylength
    //   1750: ifle -> 1763
    //   1753: aload_0
    //   1754: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   1757: iload #4
    //   1759: aload_1
    //   1760: invokevirtual onDrawPoints : (I[F)V
    //   1763: iload #5
    //   1765: iconst_1
    //   1766: iadd
    //   1767: istore #5
    //   1769: goto -> 1718
    //   1772: aload_0
    //   1773: aload #15
    //   1775: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1778: iconst_0
    //   1779: aaload
    //   1780: getfield bodyAction : J
    //   1783: putfield mBodyAction : J
    //   1786: aload_0
    //   1787: getfield TAG : Ljava/lang/String;
    //   1790: ldc_w 'human action body count: %d'
    //   1793: iconst_1
    //   1794: anewarray java/lang/Object
    //   1797: dup
    //   1798: iconst_0
    //   1799: aload #15
    //   1801: getfield bodyCount : I
    //   1804: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1807: aastore
    //   1808: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1811: pop
    //   1812: aload_0
    //   1813: getfield TAG : Ljava/lang/String;
    //   1816: ldc_w 'human action body[0] action: %d'
    //   1819: iconst_1
    //   1820: anewarray java/lang/Object
    //   1823: dup
    //   1824: iconst_0
    //   1825: aload #15
    //   1827: getfield bodys : [Lcom/sensetime/stmobile/model/STMobileBodyInfo;
    //   1830: iconst_0
    //   1831: aaload
    //   1832: getfield bodyAction : J
    //   1835: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1838: aastore
    //   1839: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1842: pop
    //   1843: aload_0
    //   1844: getfield mHandler : Landroid/os/Handler;
    //   1847: sipush #143
    //   1850: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   1853: astore_1
    //   1854: aload_0
    //   1855: getfield mHandler : Landroid/os/Handler;
    //   1858: aload_1
    //   1859: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   1862: pop
    //   1863: goto -> 1871
    //   1866: aload_0
    //   1867: lconst_0
    //   1868: putfield mBodyAction : J
    //   1871: ldc_w 36160
    //   1874: iconst_0
    //   1875: invokestatic glBindFramebuffer : (II)V
    //   1878: iload #4
    //   1880: istore #6
    //   1882: aload_0
    //   1883: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1886: astore_1
    //   1887: aload_0
    //   1888: getfield mFilterStyle : Ljava/lang/String;
    //   1891: astore #15
    //   1893: aload_1
    //   1894: aload #15
    //   1896: if_acmpeq -> 1917
    //   1899: aload_0
    //   1900: aload #15
    //   1902: putfield mCurrentFilterStyle : Ljava/lang/String;
    //   1905: aload_0
    //   1906: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1909: aload_0
    //   1910: getfield mCurrentFilterStyle : Ljava/lang/String;
    //   1913: invokevirtual setStyle : (Ljava/lang/String;)I
    //   1916: pop
    //   1917: aload_0
    //   1918: getfield mCurrentFilterStrength : F
    //   1921: fstore_2
    //   1922: aload_0
    //   1923: getfield mFilterStrength : F
    //   1926: fstore_3
    //   1927: fload_2
    //   1928: fload_3
    //   1929: fcmpl
    //   1930: ifeq -> 1951
    //   1933: aload_0
    //   1934: fload_3
    //   1935: putfield mCurrentFilterStrength : F
    //   1938: aload_0
    //   1939: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   1942: iconst_0
    //   1943: aload_0
    //   1944: getfield mCurrentFilterStrength : F
    //   1947: invokevirtual setParam : (IF)I
    //   1950: pop
    //   1951: aload_0
    //   1952: getfield mFilterTextureOutId : [I
    //   1955: ifnonnull -> 1983
    //   1958: aload_0
    //   1959: iconst_1
    //   1960: newarray int
    //   1962: putfield mFilterTextureOutId : [I
    //   1965: aload_0
    //   1966: getfield mImageWidth : I
    //   1969: aload_0
    //   1970: getfield mImageHeight : I
    //   1973: aload_0
    //   1974: getfield mFilterTextureOutId : [I
    //   1977: sipush #3553
    //   1980: invokestatic a : (II[II)V
    //   1983: iload #6
    //   1985: istore #4
    //   1987: aload_0
    //   1988: getfield mNeedFilter : Z
    //   1991: ifeq -> 2141
    //   1994: invokestatic currentTimeMillis : ()J
    //   1997: lstore #9
    //   1999: aload_0
    //   2000: getfield mNeedFilterOutputBuffer : Z
    //   2003: ifne -> 2034
    //   2006: aload_0
    //   2007: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2010: iload #6
    //   2012: aload_0
    //   2013: getfield mImageWidth : I
    //   2016: aload_0
    //   2017: getfield mImageHeight : I
    //   2020: aload_0
    //   2021: getfield mFilterTextureOutId : [I
    //   2024: iconst_0
    //   2025: iaload
    //   2026: invokevirtual processTexture : (IIII)I
    //   2029: istore #5
    //   2031: goto -> 2097
    //   2034: aload_0
    //   2035: getfield mImageWidth : I
    //   2038: istore #4
    //   2040: aload_0
    //   2041: getfield mImageHeight : I
    //   2044: istore #5
    //   2046: iload #4
    //   2048: iload #5
    //   2050: imul
    //   2051: iconst_4
    //   2052: imul
    //   2053: newarray byte
    //   2055: astore_1
    //   2056: aload_0
    //   2057: getfield mSTMobileStreamFilterNative : Lcom/sensetime/stmobile/STMobileStreamFilterNative;
    //   2060: iload #6
    //   2062: iload #4
    //   2064: iload #5
    //   2066: aload_0
    //   2067: getfield mFilterTextureOutId : [I
    //   2070: iconst_0
    //   2071: iaload
    //   2072: aload_1
    //   2073: bipush #6
    //   2075: invokevirtual processTextureAndOutputBuffer : (IIII[BI)I
    //   2078: istore #5
    //   2080: aload_0
    //   2081: getfield mNeedSave : Z
    //   2084: ifeq -> 2097
    //   2087: iload #5
    //   2089: ifne -> 2097
    //   2092: aload_0
    //   2093: aload_1
    //   2094: invokespecial saveImageBuffer2Picture : ([B)V
    //   2097: aload_0
    //   2098: getfield TAG : Ljava/lang/String;
    //   2101: ldc_w 'filters cost time: %d'
    //   2104: iconst_1
    //   2105: anewarray java/lang/Object
    //   2108: dup
    //   2109: iconst_0
    //   2110: invokestatic currentTimeMillis : ()J
    //   2113: lload #9
    //   2115: lsub
    //   2116: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2119: aastore
    //   2120: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2123: pop
    //   2124: iload #6
    //   2126: istore #4
    //   2128: iload #5
    //   2130: ifne -> 2141
    //   2133: aload_0
    //   2134: getfield mFilterTextureOutId : [I
    //   2137: iconst_0
    //   2138: iaload
    //   2139: istore #4
    //   2141: aload_0
    //   2142: getfield TAG : Ljava/lang/String;
    //   2145: ldc_w 'frame cost time total: %d'
    //   2148: iconst_1
    //   2149: anewarray java/lang/Object
    //   2152: dup
    //   2153: iconst_0
    //   2154: invokestatic currentTimeMillis : ()J
    //   2157: aload_0
    //   2158: getfield mStartTime : J
    //   2161: lsub
    //   2162: aload_0
    //   2163: getfield mRotateCost : J
    //   2166: ladd
    //   2167: aload_0
    //   2168: getfield mObjectCost : J
    //   2171: ladd
    //   2172: aload_0
    //   2173: getfield mFaceAttributeCost : J
    //   2176: ldc2_w 20
    //   2179: ldiv
    //   2180: ladd
    //   2181: invokestatic valueOf : (J)Ljava/lang/Long;
    //   2184: aastore
    //   2185: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2188: pop
    //   2189: aload_0
    //   2190: getfield mNeedSave : Z
    //   2193: ifeq -> 2207
    //   2196: aload_0
    //   2197: iload #4
    //   2199: invokespecial savePicture : (I)V
    //   2202: aload_0
    //   2203: iconst_0
    //   2204: putfield mNeedSave : Z
    //   2207: aload_0
    //   2208: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2211: ifnull -> 2355
    //   2214: invokestatic glFinish : ()V
    //   2217: aload_0
    //   2218: getfield mVideoEncoderTexture : [I
    //   2221: iconst_0
    //   2222: iload #4
    //   2224: iastore
    //   2225: aload_0
    //   2226: getfield mSurfaceTexture : Landroid/graphics/SurfaceTexture;
    //   2229: aload_0
    //   2230: getfield mStMatrix : [F
    //   2233: invokevirtual getTransformMatrix : ([F)V
    //   2236: aload_0
    //   2237: getfield mStMatrix : [F
    //   2240: astore_1
    //   2241: aload_0
    //   2242: getfield mCameraID : I
    //   2245: iconst_1
    //   2246: if_icmpne -> 2255
    //   2249: iconst_1
    //   2250: istore #13
    //   2252: goto -> 2258
    //   2255: iconst_0
    //   2256: istore #13
    //   2258: aload_0
    //   2259: getfield mCameraID : I
    //   2262: ifne -> 2284
    //   2265: aload_0
    //   2266: getfield mCameraProxy : Lcom/blued/android/module/external_sense_library/camera/CameraProxy;
    //   2269: invokevirtual d : ()I
    //   2272: sipush #270
    //   2275: if_icmpne -> 2284
    //   2278: iconst_1
    //   2279: istore #14
    //   2281: goto -> 2287
    //   2284: iconst_0
    //   2285: istore #14
    //   2287: aload_0
    //   2288: aload_1
    //   2289: iload #13
    //   2291: iload #14
    //   2293: invokespecial processStMatrix : ([FZZ)V
    //   2296: aload_0
    //   2297: monitorenter
    //   2298: aload_0
    //   2299: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2302: ifnull -> 2345
    //   2305: aload_0
    //   2306: getfield mNeedResetEglContext : Z
    //   2309: ifeq -> 2333
    //   2312: aload_0
    //   2313: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2316: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
    //   2319: aload_0
    //   2320: getfield mVideoEncoderTexture : [I
    //   2323: iconst_0
    //   2324: iaload
    //   2325: invokevirtual a : (Landroid/opengl/EGLContext;I)V
    //   2328: aload_0
    //   2329: iconst_0
    //   2330: putfield mNeedResetEglContext : Z
    //   2333: aload_0
    //   2334: getfield mVideoEncoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
    //   2337: aload_0
    //   2338: getfield mStMatrix : [F
    //   2341: invokevirtual a : ([F)Z
    //   2344: pop
    //   2345: aload_0
    //   2346: monitorexit
    //   2347: goto -> 2355
    //   2350: astore_1
    //   2351: aload_0
    //   2352: monitorexit
    //   2353: aload_1
    //   2354: athrow
    //   2355: aload_0
    //   2356: invokestatic currentTimeMillis : ()J
    //   2359: aload_0
    //   2360: getfield mStartTime : J
    //   2363: lsub
    //   2364: aload_0
    //   2365: getfield mRotateCost : J
    //   2368: ladd
    //   2369: aload_0
    //   2370: getfield mObjectCost : J
    //   2373: ladd
    //   2374: aload_0
    //   2375: getfield mFaceAttributeCost : J
    //   2378: ldc2_w 20
    //   2381: ldiv
    //   2382: ladd
    //   2383: l2i
    //   2384: putfield mFrameCost : I
    //   2387: invokestatic currentTimeMillis : ()J
    //   2390: lstore #9
    //   2392: aload_0
    //   2393: aload_0
    //   2394: getfield mCount : I
    //   2397: iconst_1
    //   2398: iadd
    //   2399: putfield mCount : I
    //   2402: aload_0
    //   2403: getfield mIsFirstCount : Z
    //   2406: ifeq -> 2423
    //   2409: aload_0
    //   2410: lload #9
    //   2412: putfield mCurrentTime : J
    //   2415: aload_0
    //   2416: iconst_0
    //   2417: putfield mIsFirstCount : Z
    //   2420: goto -> 2469
    //   2423: lload #9
    //   2425: aload_0
    //   2426: getfield mCurrentTime : J
    //   2429: lsub
    //   2430: l2i
    //   2431: istore #5
    //   2433: iload #5
    //   2435: sipush #1000
    //   2438: if_icmplt -> 2469
    //   2441: aload_0
    //   2442: lload #9
    //   2444: putfield mCurrentTime : J
    //   2447: aload_0
    //   2448: aload_0
    //   2449: getfield mCount : I
    //   2452: i2f
    //   2453: ldc_w 1000.0
    //   2456: fmul
    //   2457: iload #5
    //   2459: i2f
    //   2460: fdiv
    //   2461: putfield mFps : F
    //   2464: aload_0
    //   2465: iconst_0
    //   2466: putfield mCount : I
    //   2469: aload_0
    //   2470: getfield TAG : Ljava/lang/String;
    //   2473: ldc_w 'render fps: %f'
    //   2476: iconst_1
    //   2477: anewarray java/lang/Object
    //   2480: dup
    //   2481: iconst_0
    //   2482: aload_0
    //   2483: getfield mFps : F
    //   2486: invokestatic valueOf : (F)Ljava/lang/Float;
    //   2489: aastore
    //   2490: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   2493: pop
    //   2494: iconst_0
    //   2495: iconst_0
    //   2496: aload_0
    //   2497: getfield mSurfaceWidth : I
    //   2500: aload_0
    //   2501: getfield mSurfaceHeight : I
    //   2504: invokestatic glViewport : (IIII)V
    //   2507: aload_0
    //   2508: getfield mGLRender : Lcom/blued/android/module/external_sense_library/display/STGLRender;
    //   2511: iload #4
    //   2513: invokevirtual onDrawFrame : (I)I
    //   2516: pop
    //   2517: return
    // Exception table:
    //   from	to	target	type
    //   358	386	814	finally
    //   386	405	814	finally
    //   405	443	814	finally
    //   443	445	814	finally
    //   816	818	814	finally
    //   2298	2333	2350	finally
    //   2333	2345	2350	finally
    //   2345	2347	2350	finally
    //   2351	2353	2350	finally
  }
  
  public void onPause() {
    LogUtils.c(this.TAG, "onPause", new Object[0]);
    this.mSetPreViewSizeSucceed = false;
    this.mIsPaused = true;
    this.mImageData = null;
    this.mCameraProxy.b();
    LogUtils.b(this.TAG, "Release camera", new Object[0]);
    this.mGlSurfaceView.queueEvent(new Runnable() {
          public void run() {
            CameraDisplayDoubleInput.this.mSTHumanActionNative.reset();
            CameraDisplayDoubleInput.this.mStBeautifyNative.destroyBeautify();
            CameraDisplayDoubleInput.this.mStStickerNative.removeAvatarModel();
            CameraDisplayDoubleInput.this.mStStickerNative.destroyInstance();
            CameraDisplayDoubleInput.this.mSTMobileStreamFilterNative.destroyInstance();
            CameraDisplayDoubleInput.this.mSTMobileMakeupNative.destroyInstance();
            CameraDisplayDoubleInput.access$2902(CameraDisplayDoubleInput.this, null);
            CameraDisplayDoubleInput.access$3002(CameraDisplayDoubleInput.this, null);
            CameraDisplayDoubleInput.this.deleteTextures();
            if (CameraDisplayDoubleInput.this.mSurfaceTexture != null)
              CameraDisplayDoubleInput.this.mSurfaceTexture.release(); 
            CameraDisplayDoubleInput.this.mGLRender.destroyFrameBuffers();
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
    this.mCameraProxy.b(paramInt);
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
            //   6: ifnull -> 38
            //   9: aload_0
            //   10: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;
            //   13: invokestatic access$4100 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;)[I
            //   16: ifnull -> 38
            //   19: aload_0
            //   20: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   23: invokestatic eglGetCurrentContext : ()Landroid/opengl/EGLContext;
            //   26: aload_0
            //   27: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;
            //   30: invokestatic access$4100 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;)[I
            //   33: iconst_0
            //   34: iaload
            //   35: invokevirtual a : (Landroid/opengl/EGLContext;I)V
            //   38: aload_0
            //   39: getfield this$0 : Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;
            //   42: aload_0
            //   43: getfield val$encoder : Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
            //   46: invokestatic access$4202 : (Lcom/blued/android/module/external_sense_library/display/CameraDisplayDoubleInput;Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;)Lcom/blued/android/module/external_sense_library/encoder/MediaVideoEncoder;
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
              CameraDisplayDoubleInput.this.deleteTextures();
              if (CameraDisplayDoubleInput.this.mCameraProxy.a() != null)
                CameraDisplayDoubleInput.this.setUpCamera(); 
              CameraDisplayDoubleInput.access$102(CameraDisplayDoubleInput.this, false);
              CameraDisplayDoubleInput.access$3402(CameraDisplayDoubleInput.this, cameraID);
            }
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\CameraDisplayDoubleInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */