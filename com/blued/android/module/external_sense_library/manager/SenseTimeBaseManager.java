package com.blued.android.module.external_sense_library.manager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.contract.IGetBufferCallback;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.contract.IHandActionListener;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.display.STGLRender;
import com.blued.android.module.external_sense_library.gl.TextureProcessor;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.AppLogger;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.HandlerUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import com.sensetime.stmobile.STBeautifyNative;
import com.sensetime.stmobile.STMobileAnimalNative;
import com.sensetime.stmobile.STMobileAvatarNative;
import com.sensetime.stmobile.STMobileFaceAttributeNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STMobileObjectTrackNative;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.STMobileStreamFilterNative;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STRect;
import com.sensetime.stmobile.model.STStickerInputParams;
import java.nio.ByteBuffer;
import java.util.HashMap;

public abstract class SenseTimeBaseManager implements SensorEventListener, IRequestHost, IGetBufferCallback, ISenseTimeProcessor {
  protected static final String DRAW_FRAME_TAG = "Blued_Sense_DrawFrame";
  
  protected static final int MESSAGE_NEED_ADD_STICKER = 1006;
  
  protected static final int MESSAGE_NEED_CHANGE_STICKER = 1003;
  
  protected static final int MESSAGE_NEED_REMOVEALL_STICKERS = 1005;
  
  protected static final int MESSAGE_NEED_REMOVE_STICKER = 1004;
  
  protected static final int MESSAGE_PROCESS_IMAGE = 100;
  
  protected static final int RESULT_DEFAULT = 1000;
  
  protected static final int RESULT_SUCCESS = 0;
  
  protected static final int ST_E_ZIP_EXIST_IN_MEMORY = -33;
  
  protected static final String TAG = "Blued_Sense_SenseTimeManager";
  
  protected int CHANGESTICKER_RESULT = 1000;
  
  protected IHandActionListener iHandActionListener;
  
  protected STStickerInputParams inputEvent;
  
  protected boolean isActive;
  
  protected boolean isNeedSaveFrame = false;
  
  protected boolean isUseSensor = true;
  
  protected boolean loadStickering = false;
  
  protected Accelerometer mAccelerometer;
  
  protected float[] mBeautifyParams = new float[] { 
      0.02F, 0.36F, 0.74F, 0.0F, 0.11F, 0.13F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
      0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  protected int[] mBeautifyTextureId;
  
  protected volatile boolean mCameraChanging = false;
  
  protected int mCameraID = 1;
  
  protected Handler mChangeStickerManagerHandler;
  
  protected HandlerThread mChangeStickerManagerThread;
  
  protected Context mContext;
  
  protected float mCurrentFilterStrength = 0.65F;
  
  protected String mCurrentFilterStyle;
  
  protected StickerBaseModel mCurrentStickerModel;
  
  protected int mCustomEvent = 0;
  
  protected long mDetectConfig = 0L;
  
  protected float mFilterStrength = 0.65F;
  
  protected String mFilterStyle;
  
  protected int[] mFilterTextureOutId;
  
  protected Handler mHandler;
  
  protected STHumanAction mHumanActionBeautyOutput = new STHumanAction();
  
  protected int mHumanActionCreateConfig = 131568;
  
  protected HandlerThread mHumanActionDetectThread;
  
  protected Object mHumanActionHandleLock = new Object();
  
  protected volatile byte[] mImageData;
  
  protected Object mImageDataLock = new Object();
  
  protected int mImageHeight;
  
  protected int mImageRotation;
  
  protected int mImageWidth;
  
  protected Rect mIndexRect = new Rect();
  
  protected int mInputTextureId;
  
  protected boolean mIsCreateHumanActionHandleSucceeded = false;
  
  protected boolean mIsObjectTracking = false;
  
  protected boolean mIsPaused = false;
  
  protected boolean mNeedBeautify = false;
  
  protected boolean mNeedFaceAttribute = false;
  
  protected boolean mNeedFilter = false;
  
  protected boolean mNeedObject = false;
  
  protected boolean mNeedSetObjectTarget = false;
  
  protected boolean mNeedShowRect = true;
  
  protected boolean mNeedSticker = false;
  
  protected byte[] mNv21ImageData;
  
  protected byte[] mOutputBuffer;
  
  protected int mParamType = 0;
  
  protected Handler mProcessImageHandler;
  
  protected HandlerThread mProcessImageThread;
  
  protected ByteBuffer mRGBABuffer;
  
  protected Sensor mRotation;
  
  protected STMobileFaceAttributeNative mSTFaceAttributeNative;
  
  protected STGLRender mSTGLRender;
  
  protected STMobileHumanActionNative mSTHumanActionNative;
  
  protected STMobileAvatarNative mSTMobileAvatarNative;
  
  protected STMobileObjectTrackNative mSTMobileObjectTrackNative;
  
  protected STMobileStreamFilterNative mSTMobileStreamFilterNative;
  
  protected int mScreenIndexRectWidth = 0;
  
  protected SensorEvent mSensorEvent;
  
  protected SensorManager mSensorManager;
  
  protected HashMap<String, ISetStickerListener> mSetStickerListenerMap = new HashMap<String, ISetStickerListener>();
  
  protected STMobileAnimalNative mStAnimalNative;
  
  protected STBeautifyNative mStBeautifyNative;
  
  protected STMobileStickerNative mStStickerNative;
  
  protected HashMap<String, Integer> mStickerMaps = new HashMap<String, Integer>();
  
  protected int[] mStickerTextureOutId;
  
  protected int mSurfaceHeight;
  
  protected int mSurfaceWidth;
  
  protected Rect mTargetRect = new Rect();
  
  protected int mTexHeight;
  
  protected int mTexWidth;
  
  protected TextureProcessor mTextureProcessor;
  
  protected TextureProcessor mTextureProcessorBack;
  
  protected TextureProcessor mTextureProcessorFront;
  
  protected Handler mUpdateHandActionHandler;
  
  protected int result = 1000;
  
  public SenseTimeBaseManager(Context paramContext) {
    this(paramContext, true);
  }
  
  public SenseTimeBaseManager(Context paramContext, boolean paramBoolean) {
    if (paramContext == null)
      return; 
    if (AppInfo.d() == null)
      return; 
    StickerConfig.a(AppInfo.d());
    this.mContext = paramContext;
    this.isUseSensor = paramBoolean;
    this.isActive = true;
  }
  
  private void enableFilter(boolean paramBoolean) {
    this.mNeedFilter = paramBoolean;
  }
  
  private void initHandlerManager() {
    this.mProcessImageThread = new HandlerThread("ProcessImageThread");
    this.mProcessImageThread.start();
    this.mProcessImageHandler = new Handler(this.mProcessImageThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what == 100 && !SenseTimeBaseManager.this.mIsPaused && !SenseTimeBaseManager.this.mCameraChanging)
            SenseTimeBaseManager.this.objectTrack(); 
        }
      };
    this.mHumanActionDetectThread = new HandlerThread("mHumanActionDetectThread");
    this.mHumanActionDetectThread.start();
    this.mUpdateHandActionHandler = new Handler(this.mHumanActionDetectThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (param1Message.what != 141)
            return; 
          try {
            if (param1Message.obj != null) {
              long l = ((Long)param1Message.obj).longValue();
              if (SenseTimeBaseManager.this.iHandActionListener != null) {
                SenseTimeBaseManager.this.iHandActionListener.onHandAction(l);
                return;
              } 
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
        }
      };
    this.mChangeStickerManagerThread = new HandlerThread("ChangeStickerManagerThread");
    this.mChangeStickerManagerThread.start();
    this.mChangeStickerManagerHandler = new Handler(this.mChangeStickerManagerThread.getLooper()) {
        public void handleMessage(Message param1Message) {
          if (!SenseTimeBaseManager.this.mIsPaused) {
            String str3;
            SenseTimeBaseManager senseTimeBaseManager2;
            String str2;
            SenseTimeBaseManager senseTimeBaseManager1;
            int i;
            String str5;
            StringBuilder stringBuilder1;
            SenseTimeBaseManager senseTimeBaseManager4;
            String str4;
            SenseTimeBaseManager senseTimeBaseManager3;
            StickerBaseModel stickerBaseModel = (StickerBaseModel)param1Message.obj;
            switch (param1Message.what) {
              default:
                return;
              case 1006:
                if (stickerBaseModel == null) {
                  LogUtils.c("Blued_Sense_SenseTimeManager", "add sticker | baseModel == null", new Object[0]);
                  return;
                } 
                str3 = stickerBaseModel.localPath;
                str5 = stickerBaseModel.name;
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("add sticker | addStickerPath: ");
                stringBuilder1.append(str3);
                LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder1.toString(), new Object[0]);
                if (!TextUtils.isEmpty(str3)) {
                  int j = SenseTimeBaseManager.this.mStStickerNative.addSticker(str3);
                  if (j > 0) {
                    senseTimeBaseManager4 = SenseTimeBaseManager.this;
                    senseTimeBaseManager4.mParamType = senseTimeBaseManager4.mStStickerNative.getNeededInputParams();
                    if (SenseTimeBaseManager.this.mStickerMaps != null)
                      SenseTimeBaseManager.this.mStickerMaps.put(str3, Integer.valueOf(j)); 
                    SenseTimeBaseManager senseTimeBaseManager = SenseTimeBaseManager.this;
                    senseTimeBaseManager.setHumanActionDetectConfig(senseTimeBaseManager.mNeedBeautify | SenseTimeBaseManager.this.mNeedFaceAttribute, SenseTimeBaseManager.this.getStickerTriggerAction());
                    return;
                  } 
                  SenseTimeBaseManager.this.mySendMessage(160);
                  return;
                } 
                return;
              case 1005:
                SenseTimeBaseManager.this.mStStickerNative.removeAllStickers();
                if (SenseTimeBaseManager.this.mStickerMaps != null)
                  SenseTimeBaseManager.this.mStickerMaps.clear(); 
                senseTimeBaseManager2 = SenseTimeBaseManager.this;
                senseTimeBaseManager2.setHumanActionDetectConfig(senseTimeBaseManager2.mNeedBeautify | SenseTimeBaseManager.this.mNeedFaceAttribute, SenseTimeBaseManager.this.getStickerTriggerAction());
                return;
              case 1004:
                if (senseTimeBaseManager4 == null) {
                  LogUtils.c("Blued_Sense_SenseTimeManager", "remove sticker | baseModel == null", new Object[0]);
                  return;
                } 
                str2 = ((StickerBaseModel)senseTimeBaseManager4).localPath;
                str4 = ((StickerBaseModel)senseTimeBaseManager4).name;
                i = ((Integer)SenseTimeBaseManager.this.mStickerMaps.get(str2)).intValue();
                LogUtils.c("Blued_Sense_SenseTimeManager", "remove sticker | packageId:%d | removeStickerPath:%s ", new Object[] { Integer.valueOf(i), str2 });
                senseTimeBaseManager3 = SenseTimeBaseManager.this;
                senseTimeBaseManager3.result = senseTimeBaseManager3.mStStickerNative.removeSticker(i);
                if (SenseTimeBaseManager.this.mStickerMaps != null && SenseTimeBaseManager.this.result == 0)
                  SenseTimeBaseManager.this.mStickerMaps.remove(str2); 
                senseTimeBaseManager1 = SenseTimeBaseManager.this;
                senseTimeBaseManager1.setHumanActionDetectConfig(senseTimeBaseManager1.mNeedBeautify | SenseTimeBaseManager.this.mNeedFaceAttribute, SenseTimeBaseManager.this.getStickerTriggerAction());
                return;
              case 1003:
                break;
            } 
            if (senseTimeBaseManager3 == null) {
              LogUtils.c("Blued_Sense_SenseTimeManager", "change sticker | baseModel == null", new Object[0]);
              return;
            } 
            String str6 = ((StickerBaseModel)senseTimeBaseManager3).localPath;
            String str1 = ((StickerBaseModel)senseTimeBaseManager3).name;
            if (SenseTimeBaseManager.this.mCurrentStickerModel != null) {
              str1 = SenseTimeBaseManager.this.mCurrentStickerModel.localPath;
            } else {
              str1 = "";
            } 
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("change sticker | changeSticker: ");
            stringBuilder2.append(str6);
            LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder2.toString(), new Object[0]);
            if (!str1.equals(str6)) {
              LogUtils.c("Blued_Sense_SenseTimeManager", "change sticker | !mCurrentSticker.equals(changeSticker)", new Object[0]);
              SenseTimeBaseManager senseTimeBaseManager6 = SenseTimeBaseManager.this;
              senseTimeBaseManager6.CHANGESTICKER_RESULT = senseTimeBaseManager6.mStStickerNative.changeSticker(str6);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("change sticker | result: ");
              stringBuilder.append(SenseTimeBaseManager.this.CHANGESTICKER_RESULT);
              LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
              SenseTimeBaseManager senseTimeBaseManager5 = SenseTimeBaseManager.this;
              senseTimeBaseManager5.mParamType = senseTimeBaseManager5.mStStickerNative.getNeededInputParams();
              senseTimeBaseManager5 = SenseTimeBaseManager.this;
              senseTimeBaseManager5.setHumanActionDetectConfig(senseTimeBaseManager5.mNeedBeautify | SenseTimeBaseManager.this.mNeedFaceAttribute, SenseTimeBaseManager.this.getStickerTriggerAction());
              if (TextUtils.isEmpty(str6)) {
                SenseTimeBaseManager.this.mCurrentStickerModel = null;
              } else if (SenseTimeBaseManager.this.CHANGESTICKER_RESULT == 0 || SenseTimeBaseManager.this.CHANGESTICKER_RESULT == -33) {
                SenseTimeBaseManager.this.mCurrentStickerModel = (StickerBaseModel)senseTimeBaseManager3;
              } 
            } 
            SenseTimeBaseManager.this.loadStickering = false;
          } 
        }
      };
  }
  
  private void initHumanAction() {
    LogUtils.b("Blued_Sense_SenseTimeManager", "----》initHumanAction", new Object[0]);
    setHumanActionDetectConfig(true, this.mStStickerNative.getTriggerAction());
    (new Thread(new Runnable() {
          public void run() {
            synchronized (SenseTimeBaseManager.this.mHumanActionHandleLock) {
              int i = SenseTimeBaseManager.this.mSTHumanActionNative.createInstanceFromAssetFile(FileUtils.a(), SenseTimeBaseManager.this.mHumanActionCreateConfig, SenseTimeBaseManager.this.mContext.getAssets());
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("the result for createInstance for human_action is ");
              stringBuilder.append(i);
              LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
              if (i == 0) {
                LogUtils.c("Blued_Sense_SenseTimeManager", "add hand model result: %d", new Object[] { Integer.valueOf(this.this$0.mSTHumanActionNative.addSubModelFromAssetFile("M_SenseME_Hand_5.4.0.model", this.this$0.mContext.getAssets())) });
                SenseTimeBaseManager.this.mIsCreateHumanActionHandleSucceeded = true;
                SenseTimeBaseManager.this.mSTHumanActionNative.setParam(2, 0.35F);
              } 
              return;
            } 
          }
        })).start();
  }
  
  private void initNative() {
    this.mStStickerNative = new STMobileStickerNative();
    this.mStBeautifyNative = new STBeautifyNative();
    this.mSTHumanActionNative = new STMobileHumanActionNative();
    this.mStAnimalNative = new STMobileAnimalNative();
    this.mSTMobileStreamFilterNative = new STMobileStreamFilterNative();
    this.mSTFaceAttributeNative = new STMobileFaceAttributeNative();
    this.mSTMobileObjectTrackNative = new STMobileObjectTrackNative();
    this.mSTMobileAvatarNative = new STMobileAvatarNative();
  }
  
  private void initSensorManager() {
    this.mSensorManager = (SensorManager)this.mContext.getSystemService("sensor");
    this.mRotation = this.mSensorManager.getDefaultSensor(11);
  }
  
  private void removeSticker(int paramInt) {
    this.mChangeStickerManagerHandler.removeMessages(1004);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1004);
    message.obj = Integer.valueOf(paramInt);
    this.mChangeStickerManagerHandler.sendMessage(message);
  }
  
  public void changeCustomEvent() {
    this.mCustomEvent = 3;
  }
  
  public void changeSticker(String paramString1, String paramString2) {
    if (this.mSetStickerListenerMap.get(paramString1) != null)
      ((ISetStickerListener)this.mSetStickerListenerMap.get(paramString1)).onSetSticker(); 
    StickerBaseModel stickerBaseModel = new StickerBaseModel();
    stickerBaseModel.name = paramString1;
    stickerBaseModel.localPath = paramString2;
    this.mChangeStickerManagerHandler.removeMessages(1003);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1003);
    message.obj = stickerBaseModel;
    this.mChangeStickerManagerHandler.sendMessage(message);
  }
  
  public void changeSticker(final String name, String paramString2, ISetStickerListener paramISetStickerListener) {
    if (TextUtils.isEmpty(name) || TextUtils.isEmpty(paramString2)) {
      if (paramISetStickerListener != null)
        paramISetStickerListener.onFailed(ErrorCode.PlayStickerCode.a, "name or path is null"); 
      changeSticker(name, paramString2);
      return;
    } 
    this.loadStickering = true;
    if (paramISetStickerListener != null)
      this.mSetStickerListenerMap.put(name, paramISetStickerListener); 
    StickerDataManager.getStickerPath(name, paramString2, new IGetStickerListener() {
          public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
            SenseTimeBaseManager senseTimeBaseManager = SenseTimeBaseManager.this;
            senseTimeBaseManager.loadStickering = false;
            if (senseTimeBaseManager.mSetStickerListenerMap.get(name) != null) {
              ISetStickerListener iSetStickerListener = SenseTimeBaseManager.this.mSetStickerListenerMap.get(name);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("downLoad fail | ");
              stringBuilder.append(param1String);
              iSetStickerListener.onFailed(param1PlayStickerCode, stringBuilder.toString());
            } 
          }
          
          public void onSuccess(String param1String1, String param1String2) {
            SenseTimeBaseManager.this.changeSticker(param1String1, param1String2);
          }
          
          public void onSyncStart() {}
        });
  }
  
  protected void checkTexture(int paramInt1, int paramInt2) {
    AppLogger appLogger = AppLogger.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_SenseTimeManager texWidth:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" | texHeight:");
    stringBuilder.append(paramInt2);
    appLogger.a(stringBuilder.toString(), new Object[0]);
    if (this.mTexWidth != paramInt1 || this.mTexHeight != paramInt2 || this.mCameraChanging) {
      deleteInternalTextures();
      this.mTexWidth = paramInt1;
      this.mTexHeight = paramInt2;
      this.mCameraChanging = false;
    } 
    checkTextureOutId();
  }
  
  protected abstract void checkTextureOutId();
  
  protected void deleteInternalTextures() {
    int[] arrayOfInt = this.mBeautifyTextureId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mBeautifyTextureId = null;
    } 
    arrayOfInt = this.mStickerTextureOutId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mStickerTextureOutId = null;
    } 
    arrayOfInt = this.mFilterTextureOutId;
    if (arrayOfInt != null) {
      GLES20.glDeleteTextures(1, arrayOfInt, 0);
      this.mFilterTextureOutId = null;
    } 
    synchronized (this.mImageDataLock) {
      if (this.mImageData != null)
        this.mImageData = new byte[0]; 
      if (this.mOutputBuffer != null)
        this.mOutputBuffer = new byte[0]; 
      return;
    } 
  }
  
  protected void destorySTNative() {
    synchronized (this.mHumanActionHandleLock) {
      this.mSTHumanActionNative.destroyInstance();
      this.mSTFaceAttributeNative.destroyInstance();
      this.mSTMobileObjectTrackNative.destroyInstance();
      this.mStAnimalNative.destroyInstance();
      this.mSTMobileAvatarNative.destroyInstance();
      return;
    } 
  }
  
  protected void destroyBeautifyNative() {
    this.mStBeautifyNative.destroyBeautify();
  }
  
  protected void destroyFilterNative() {
    this.mSTMobileStreamFilterNative.destroyInstance();
  }
  
  protected void destroyStickerNative() {
    this.mStStickerNative.removeAvatarModel();
    this.mStStickerNative.destroyInstance();
  }
  
  public void disableObjectTracking() {
    this.mIsObjectTracking = false;
  }
  
  public int drawFrame(int paramInt1, int paramInt2, int paramInt3) {
    return drawFrame(paramInt1, paramInt2, paramInt3, false);
  }
  
  public abstract void enableBeautify(boolean paramBoolean);
  
  public void enableObject(boolean paramBoolean) {
    this.mNeedObject = paramBoolean;
    if (this.mNeedObject)
      resetIndexRect(); 
  }
  
  public void enableSticker(boolean paramBoolean) {
    this.mNeedSticker = paramBoolean;
    if (!paramBoolean)
      setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, getStickerTriggerAction()); 
    if (!paramBoolean)
      changeSticker((String)null, (String)null, (ISetStickerListener)null); 
  }
  
  protected int getCameraOrientation(int paramInt) {
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    int j = Camera.getNumberOfCameras();
    for (int i = 0; i < j; i++) {
      Camera.getCameraInfo(i, cameraInfo);
      if (paramInt == cameraInfo.facing)
        return cameraInfo.orientation; 
    } 
    return 0;
  }
  
  protected abstract int getCurrentOrientation();
  
  protected int getHumanActionOrientation() {
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
    if (this.mImageRotation != 270 || (i & 0x1) != 1) {
      null = i;
      if (this.mImageRotation == 90) {
        null = i;
        if ((i & 0x1) == 0)
          return i ^ 0x2; 
      } 
      return null;
    } 
    return i ^ 0x2;
  }
  
  protected byte[] getImgeData() {
    return this.mNv21ImageData;
  }
  
  public Rect getIndexRect() {
    return this.mIndexRect;
  }
  
  public byte[] getOutputBuffer() {
    return this.mOutputBuffer;
  }
  
  public long getStickerTriggerAction() {
    return this.mStStickerNative.getTriggerAction();
  }
  
  protected void init() {
    init(true, 131568);
  }
  
  protected void init(boolean paramBoolean, int paramInt) {
    this.mAccelerometer = new Accelerometer(this.mContext);
    if (this.isUseSensor)
      initSensorManager(); 
    this.mHumanActionCreateConfig = paramInt;
    initNative();
    initHumanAction();
    initObjectTrack();
    initHandlerManager();
    this.mSTGLRender = new STGLRender(paramBoolean);
  }
  
  protected void initBeauty() {
    if (this.mStBeautifyNative.createInstance() == 0) {
      this.mStBeautifyNative.setParam(4, this.mBeautifyParams[0]);
      this.mStBeautifyNative.setParam(1, this.mBeautifyParams[1]);
      this.mStBeautifyNative.setParam(3, this.mBeautifyParams[2]);
      this.mStBeautifyNative.setParam(10, this.mBeautifyParams[3]);
      this.mStBeautifyNative.setParam(6, this.mBeautifyParams[4]);
      this.mStBeautifyNative.setParam(5, this.mBeautifyParams[5]);
      this.mStBeautifyNative.setParam(7, this.mBeautifyParams[6]);
      this.mStBeautifyNative.setParam(11, this.mBeautifyParams[7]);
      this.mStBeautifyNative.setParam(8, this.mBeautifyParams[8]);
      this.mStBeautifyNative.setParam(9, this.mBeautifyParams[9]);
    } 
  }
  
  protected void initFilter() {
    this.mSTMobileStreamFilterNative.createInstance();
    if (!TextUtils.isEmpty(this.mCurrentFilterStyle))
      this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle); 
    this.mCurrentFilterStrength = this.mFilterStrength;
    this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
  }
  
  protected void initObjectTrack() {
    this.mSTMobileObjectTrackNative.createInstance();
  }
  
  protected void initSticker() {
    int i = this.mStStickerNative.createInstance(this.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("the result for createInstance for sticker is : ");
    stringBuilder.append(i);
    LogUtils.b("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
    if (this.mNeedSticker) {
      StickerBaseModel stickerBaseModel = this.mCurrentStickerModel;
      if (stickerBaseModel != null)
        changeSticker(stickerBaseModel.name, this.mCurrentStickerModel.localPath); 
    } 
    boolean bool = this.mNeedSticker;
    this.mStStickerNative.loadAvatarModelFromAssetFile("M_SenseME_Avatar_Core_2.0.0.model", this.mContext.getAssets());
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, getStickerTriggerAction());
    stringBuilder = new StringBuilder();
    stringBuilder.append("the result for createInstance for initSticker is ");
    stringBuilder.append(i);
    LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
  }
  
  public boolean isActive() {
    return this.isActive;
  }
  
  protected boolean isFlipHorizontal() {
    return (this.mCameraID != 1);
  }
  
  protected boolean isFlipVertical() {
    return (getCameraOrientation(this.mCameraID) == 90 || getCameraOrientation(this.mCameraID) == 270);
  }
  
  protected void mySendMessage(int paramInt) {
    mySendMessage(paramInt, (Object)null, -1, -1);
  }
  
  protected void mySendMessage(int paramInt, Object paramObject) {
    mySendMessage(paramInt, paramObject, -1, -1);
  }
  
  protected void mySendMessage(int paramInt1, Object paramObject, int paramInt2, int paramInt3) {
    Handler handler = this.mHandler;
    if (handler != null) {
      Message message = handler.obtainMessage(paramInt1);
      if (paramObject != null)
        message.obj = paramObject; 
      if (paramInt2 != -1)
        message.arg1 = paramInt2; 
      if (paramInt3 != -1)
        message.arg2 = paramInt3; 
      this.mHandler.sendMessage(message);
    } 
  }
  
  protected void objectTrack() {
    if (this.mImageData != null) {
      if (this.mImageData.length == 0)
        return; 
      boolean bool = this.mNeedObject;
      if (bool) {
        if (this.mNeedSetObjectTarget) {
          long l = System.currentTimeMillis();
          this.mTargetRect = STUtils.c(this.mTargetRect, this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation);
          STRect sTRect = new STRect(this.mTargetRect.left, this.mTargetRect.top, this.mTargetRect.right, this.mTargetRect.bottom);
          this.mSTMobileObjectTrackNative.setTarget(this.mImageData, 3, this.mImageHeight, this.mImageWidth, sTRect);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("setTarget cost time: ");
          stringBuilder.append(System.currentTimeMillis() - l);
          stringBuilder.append(" rotation = ");
          stringBuilder.append(this.mImageRotation);
          LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
          this.mNeedSetObjectTarget = false;
          this.mIsObjectTracking = true;
        } 
        Rect rect = new Rect(0, 0, 0, 0);
        if (this.mIsObjectTracking) {
          long l = System.currentTimeMillis();
          float[] arrayOfFloat = new float[1];
          STRect sTRect = this.mSTMobileObjectTrackNative.objectTrack(this.mImageData, 3, this.mImageHeight, this.mImageWidth, arrayOfFloat);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("objectTrack cost time: ");
          stringBuilder.append(System.currentTimeMillis() - l);
          LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
          if (sTRect != null && arrayOfFloat.length > 0) {
            rect = STUtils.b(STUtils.d(new Rect((sTRect.getRect()).left, (sTRect.getRect()).top, (sTRect.getRect()).right, (sTRect.getRect()).bottom), this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
            if (!this.mNeedShowRect) {
              mySendMessage(120, rect);
              this.mIndexRect = rect;
              return;
            } 
          } 
        } else {
          if (this.mNeedShowRect) {
            mySendMessage(121, this.mIndexRect);
            return;
          } 
          mySendMessage(120, rect);
          this.mIndexRect = rect;
          return;
        } 
      } else if (!bool || (!this.mNeedBeautify && !this.mNeedSticker && !this.mNeedFaceAttribute)) {
        mySendMessage(130);
      } 
    } 
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  protected int onBeautifyProcessTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, STHumanAction paramSTHumanAction) {
    this.result = 1000;
    if (this.mNeedBeautify) {
      long l = System.currentTimeMillis();
      if (this.isNeedSaveFrame) {
        this.mOutputBuffer = new byte[(getImgeData()).length];
        this.result = this.mStBeautifyNative.processTextureAndOutputBuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramSTHumanAction, this.mBeautifyTextureId[0], this.mOutputBuffer, paramInt5, this.mHumanActionBeautyOutput);
        saveImageBuffer2Picture(1, this.mOutputBuffer);
      } else {
        this.result = this.mStBeautifyNative.processTexture(paramInt1, paramInt2, paramInt3, paramInt4, paramSTHumanAction, this.mBeautifyTextureId[0], this.mHumanActionBeautyOutput);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("beautify result:");
      stringBuilder.append(this.result);
      stringBuilder.append(" | cost time: ");
      stringBuilder.append(System.currentTimeMillis() - l);
      LogUtils.c("Blued_Sense_DrawFrame", stringBuilder.toString(), new Object[0]);
      if (this.result == 0)
        return this.mBeautifyTextureId[0]; 
    } 
    return paramInt1;
  }
  
  public void onDestroy() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onDestroy()", new Object[0]);
    this.isActive = false;
    destorySTNative();
    Context context = this.mContext;
    if (context == null || ((Activity)context).isFinishing())
      StickerDataManager.clearData(); 
  }
  
  protected void onDestroySenseNative() {
    this.mSTHumanActionNative.reset();
    destroyBeautifyNative();
    destroyStickerNative();
    destroyFilterNative();
  }
  
  protected int onFilterProcessTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    if (!TextUtils.isEmpty(this.mFilterStyle)) {
      if (!this.mFilterStyle.equals(this.mCurrentFilterStyle)) {
        this.mCurrentFilterStyle = this.mFilterStyle;
        this.mSTMobileStreamFilterNative.setStyle(this.mCurrentFilterStyle);
      } 
      float f1 = this.mCurrentFilterStrength;
      float f2 = this.mFilterStrength;
      if (f1 != f2) {
        this.mCurrentFilterStrength = f2;
        this.mSTMobileStreamFilterNative.setParam(0, this.mCurrentFilterStrength);
      } 
    } 
    if (this.mFilterTextureOutId == null) {
      this.mFilterTextureOutId = new int[1];
      GlUtil.a(this.mTexWidth, this.mTexHeight, this.mFilterTextureOutId, 3553);
    } 
    if (this.mNeedFilter) {
      long l = System.currentTimeMillis();
      if (paramBoolean) {
        Integer integer;
        this.result = this.mSTMobileStreamFilterNative.processTextureAndOutputBuffer(paramInt1, paramInt2, paramInt3, this.mFilterTextureOutId[0], this.mOutputBuffer, paramInt4);
        if (this.isNeedSaveFrame)
          saveImageBuffer2Picture(3, this.mOutputBuffer); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("mOutputBuffer:");
        stringBuilder1.append(this.mOutputBuffer);
        if (stringBuilder1.toString() == null) {
          String str = "null";
        } else {
          integer = Integer.valueOf(this.mOutputBuffer.length);
        } 
        LogUtils.a("Blued_Sense_SenseTimeManager", new Object[] { integer });
      } else {
        this.result = this.mSTMobileStreamFilterNative.processTexture(this.mInputTextureId, this.mTexWidth, this.mTexHeight, this.mFilterTextureOutId[0]);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("filter result:");
      stringBuilder.append(this.result);
      stringBuilder.append(" | cost time: ");
      stringBuilder.append(System.currentTimeMillis() - l);
      LogUtils.c("Blued_Sense_DrawFrame", stringBuilder.toString(), new Object[0]);
      if (this.result == 0)
        return this.mFilterTextureOutId[0]; 
    } 
    return paramInt1;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent) {
    if (this.isUseSensor)
      this.mSensorEvent = paramSensorEvent; 
  }
  
  protected int onStickerProcessTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, STHumanAction paramSTHumanAction) {
    // Byte code:
    //   0: aload_0
    //   1: sipush #1000
    //   4: putfield result : I
    //   7: aload_0
    //   8: getfield mNeedSticker : Z
    //   11: ifeq -> 608
    //   14: aload_0
    //   15: getfield loadStickering : Z
    //   18: ifne -> 608
    //   21: invokestatic currentTimeMillis : ()J
    //   24: lstore #12
    //   26: aload_0
    //   27: getfield mCustomEvent : I
    //   30: istore #8
    //   32: new java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: astore #18
    //   41: aload #18
    //   43: ldc_w 'sticker, event : '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload #18
    //   52: aload_0
    //   53: getfield mCustomEvent : I
    //   56: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: ldc 'Blued_Sense_SenseTimeManager'
    //   62: aload #18
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: iconst_0
    //   68: anewarray java/lang/Object
    //   71: invokestatic b : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   74: pop
    //   75: aload_0
    //   76: getfield mParamType : I
    //   79: istore #9
    //   81: iconst_1
    //   82: istore #17
    //   84: iconst_1
    //   85: istore #16
    //   87: iload #9
    //   89: iconst_1
    //   90: iand
    //   91: iconst_1
    //   92: if_icmpne -> 168
    //   95: aload_0
    //   96: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   99: astore #18
    //   101: aload #18
    //   103: ifnull -> 168
    //   106: aload #18
    //   108: getfield values : [F
    //   111: ifnull -> 168
    //   114: aload_0
    //   115: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   118: getfield values : [F
    //   121: arraylength
    //   122: ifle -> 168
    //   125: aload_0
    //   126: getfield mSensorEvent : Landroid/hardware/SensorEvent;
    //   129: getfield values : [F
    //   132: astore #18
    //   134: aload_0
    //   135: getfield mCameraID : I
    //   138: iconst_1
    //   139: if_icmpne -> 145
    //   142: goto -> 148
    //   145: iconst_0
    //   146: istore #16
    //   148: aload_0
    //   149: new com/sensetime/stmobile/model/STStickerInputParams
    //   152: dup
    //   153: aload #18
    //   155: iload #16
    //   157: iload #8
    //   159: invokespecial <init> : ([FZI)V
    //   162: putfield inputEvent : Lcom/sensetime/stmobile/model/STStickerInputParams;
    //   165: goto -> 220
    //   168: aload_0
    //   169: getfield mCameraID : I
    //   172: iconst_1
    //   173: if_icmpne -> 183
    //   176: iload #17
    //   178: istore #16
    //   180: goto -> 186
    //   183: iconst_0
    //   184: istore #16
    //   186: aload_0
    //   187: new com/sensetime/stmobile/model/STStickerInputParams
    //   190: dup
    //   191: iconst_4
    //   192: newarray float
    //   194: dup
    //   195: iconst_0
    //   196: fconst_0
    //   197: fastore
    //   198: dup
    //   199: iconst_1
    //   200: fconst_0
    //   201: fastore
    //   202: dup
    //   203: iconst_2
    //   204: fconst_0
    //   205: fastore
    //   206: dup
    //   207: iconst_3
    //   208: fconst_1
    //   209: fastore
    //   210: iload #16
    //   212: iload #8
    //   214: invokespecial <init> : ([FZI)V
    //   217: putfield inputEvent : Lcom/sensetime/stmobile/model/STStickerInputParams;
    //   220: aload_0
    //   221: getfield isNeedSaveFrame : Z
    //   224: ifeq -> 287
    //   227: aload_0
    //   228: aload_0
    //   229: invokevirtual getImgeData : ()[B
    //   232: arraylength
    //   233: newarray byte
    //   235: putfield mOutputBuffer : [B
    //   238: aload_0
    //   239: aload_0
    //   240: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   243: iload_1
    //   244: aload #7
    //   246: iload #4
    //   248: iload #5
    //   250: iload_2
    //   251: iload_3
    //   252: iconst_0
    //   253: aload_0
    //   254: getfield inputEvent : Lcom/sensetime/stmobile/model/STStickerInputParams;
    //   257: aload_0
    //   258: getfield mStickerTextureOutId : [I
    //   261: iconst_0
    //   262: iaload
    //   263: iload #6
    //   265: aload_0
    //   266: getfield mOutputBuffer : [B
    //   269: invokevirtual processTextureAndOutputBuffer : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;II[B)I
    //   272: putfield result : I
    //   275: aload_0
    //   276: iconst_2
    //   277: aload_0
    //   278: getfield mOutputBuffer : [B
    //   281: invokevirtual saveImageBuffer2Picture : (I[B)V
    //   284: goto -> 318
    //   287: aload_0
    //   288: aload_0
    //   289: getfield mStStickerNative : Lcom/sensetime/stmobile/STMobileStickerNative;
    //   292: iload_1
    //   293: aload #7
    //   295: iload #4
    //   297: iload #5
    //   299: iload_2
    //   300: iload_3
    //   301: iconst_0
    //   302: aload_0
    //   303: getfield inputEvent : Lcom/sensetime/stmobile/model/STStickerInputParams;
    //   306: aload_0
    //   307: getfield mStickerTextureOutId : [I
    //   310: iconst_0
    //   311: iaload
    //   312: invokevirtual processTexture : (ILcom/sensetime/stmobile/model/STHumanAction;IIIIZLcom/sensetime/stmobile/model/STStickerInputParams;I)I
    //   315: putfield result : I
    //   318: aload #7
    //   320: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   323: ifnull -> 480
    //   326: aload #7
    //   328: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   331: arraylength
    //   332: ifle -> 480
    //   335: aload #7
    //   337: getfield hands : [Lcom/sensetime/stmobile/model/STMobileHandInfo;
    //   340: iconst_0
    //   341: aaload
    //   342: getfield handAction : J
    //   345: lstore #14
    //   347: ldc2_w 16384
    //   350: lstore #10
    //   352: lload #14
    //   354: ldc2_w 131072
    //   357: land
    //   358: lconst_0
    //   359: lcmp
    //   360: ifle -> 371
    //   363: ldc2_w 131072
    //   366: lstore #10
    //   368: goto -> 445
    //   371: lload #14
    //   373: ldc2_w 262144
    //   376: land
    //   377: lconst_0
    //   378: lcmp
    //   379: ifle -> 390
    //   382: ldc2_w 262144
    //   385: lstore #10
    //   387: goto -> 445
    //   390: lload #14
    //   392: ldc2_w 8192
    //   395: land
    //   396: lconst_0
    //   397: lcmp
    //   398: ifle -> 409
    //   401: ldc2_w 8192
    //   404: lstore #10
    //   406: goto -> 445
    //   409: lload #14
    //   411: ldc2_w 2048
    //   414: land
    //   415: lconst_0
    //   416: lcmp
    //   417: ifle -> 428
    //   420: ldc2_w 2048
    //   423: lstore #10
    //   425: goto -> 445
    //   428: lload #14
    //   430: ldc2_w 16384
    //   433: land
    //   434: lconst_0
    //   435: lcmp
    //   436: ifle -> 442
    //   439: goto -> 445
    //   442: lconst_0
    //   443: lstore #10
    //   445: aload_0
    //   446: getfield mUpdateHandActionHandler : Landroid/os/Handler;
    //   449: sipush #141
    //   452: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   455: astore #7
    //   457: aload #7
    //   459: lload #10
    //   461: invokestatic valueOf : (J)Ljava/lang/Long;
    //   464: putfield obj : Ljava/lang/Object;
    //   467: aload_0
    //   468: getfield mUpdateHandActionHandler : Landroid/os/Handler;
    //   471: aload #7
    //   473: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   476: pop
    //   477: goto -> 511
    //   480: aload_0
    //   481: getfield mUpdateHandActionHandler : Landroid/os/Handler;
    //   484: sipush #141
    //   487: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   490: astore #7
    //   492: aload #7
    //   494: lconst_0
    //   495: invokestatic valueOf : (J)Ljava/lang/Long;
    //   498: putfield obj : Ljava/lang/Object;
    //   501: aload_0
    //   502: getfield mUpdateHandActionHandler : Landroid/os/Handler;
    //   505: aload #7
    //   507: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   510: pop
    //   511: iload #8
    //   513: aload_0
    //   514: getfield mCustomEvent : I
    //   517: if_icmpne -> 525
    //   520: aload_0
    //   521: iconst_0
    //   522: putfield mCustomEvent : I
    //   525: aload_0
    //   526: getfield result : I
    //   529: ifne -> 542
    //   532: aload_0
    //   533: getfield mStickerTextureOutId : [I
    //   536: iconst_0
    //   537: iaload
    //   538: istore_1
    //   539: goto -> 542
    //   542: new java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial <init> : ()V
    //   549: astore #7
    //   551: aload #7
    //   553: ldc_w 'sticker result:'
    //   556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload #7
    //   562: aload_0
    //   563: getfield result : I
    //   566: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload #7
    //   572: ldc_w ' | cost time: '
    //   575: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload #7
    //   581: invokestatic currentTimeMillis : ()J
    //   584: lload #12
    //   586: lsub
    //   587: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: ldc 'Blued_Sense_DrawFrame'
    //   593: aload #7
    //   595: invokevirtual toString : ()Ljava/lang/String;
    //   598: iconst_0
    //   599: anewarray java/lang/Object
    //   602: invokestatic c : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   605: pop
    //   606: iload_1
    //   607: ireturn
    //   608: iload_1
    //   609: ireturn
  }
  
  public void readBuffer(byte[] paramArrayOfbyte) {
    if (!this.mNeedFilter && paramArrayOfbyte != null) {
      byte[] arrayOfByte = this.mOutputBuffer;
      if (arrayOfByte != null && paramArrayOfbyte.length <= arrayOfByte.length)
        System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramArrayOfbyte.length); 
    } 
  }
  
  protected void registerSensorListener() {
    SensorManager sensorManager = this.mSensorManager;
    if (sensorManager != null)
      sensorManager.registerListener(this, this.mRotation, 1); 
  }
  
  public void removeAllStickers() {
    this.mChangeStickerManagerHandler.removeMessages(1005);
    Message message = this.mChangeStickerManagerHandler.obtainMessage(1005);
    this.mChangeStickerManagerHandler.sendMessage(message);
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
  
  protected void saveImageBuffer2Picture(int paramInt, byte[] paramArrayOfbyte) {
    if (this.mHandler != null) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(paramArrayOfbyte.length);
      byteBuffer.put(paramArrayOfbyte);
      Message message = Message.obtain(this.mHandler);
      message.what = 150;
      message.obj = byteBuffer;
      message.arg1 = paramInt;
      Bundle bundle = new Bundle();
      bundle.putInt("imageWidth", this.mImageWidth);
      bundle.putInt("imageHeight", this.mImageHeight);
      message.setData(bundle);
      message.sendToTarget();
    } 
  }
  
  public void setBeautyParam(BluedBeautifyKey.KEY paramKEY, float paramFloat) {
    if (paramKEY != null && this.mBeautifyParams[paramKEY.getIndex()] != paramFloat) {
      this.mStBeautifyNative.setParam(paramKEY.getBeautyParamsType(), paramFloat);
      this.mBeautifyParams[paramKEY.getIndex()] = paramFloat;
    } 
  }
  
  public void setCameraFacing(boolean paramBoolean) {
    if (paramBoolean) {
      this.mCameraID = 1;
      return;
    } 
    this.mCameraID = 0;
  }
  
  public void setFilterStrength(float paramFloat) {
    this.mFilterStrength = paramFloat;
  }
  
  public void setFilterStyle(BluedFilterType.FILER paramFILER) {
    if (paramFILER != null) {
      this.mFilterStyle = FilterDataManager.getInstance().getModel(paramFILER);
      enableFilter(true);
      return;
    } 
    this.mFilterStyle = "";
    enableFilter(false);
  }
  
  public void setHandActionListener(IHandActionListener paramIHandActionListener) {
    this.iHandActionListener = paramIHandActionListener;
  }
  
  public void setHandler(Handler paramHandler) {
    this.mHandler = paramHandler;
  }
  
  protected abstract void setHumanActionDetectConfig(boolean paramBoolean, long paramLong);
  
  public void setIndexRect(int paramInt1, int paramInt2, boolean paramBoolean) {
    int i = this.mScreenIndexRectWidth;
    this.mIndexRect = new Rect(paramInt1, paramInt2, paramInt1 + i, i + paramInt2);
    this.mNeedShowRect = paramBoolean;
  }
  
  public void setNeedSaveFrame(boolean paramBoolean) {
    this.isNeedSaveFrame = paramBoolean;
    if (this.isNeedSaveFrame)
      this.mHandler = (new HandlerUtils()).a(); 
  }
  
  public void setObjectTrackRect() {
    this.mNeedSetObjectTarget = true;
    this.mIsObjectTracking = false;
    this.mTargetRect = STUtils.a(getIndexRect(), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
  }
  
  public void switchCamera() {
    boolean bool = false;
    LogUtils.c("Blued_Sense_SenseTimeManager", "switchCamera()", new Object[0]);
    this.mCameraChanging = true;
    if (this.mCameraID != 1)
      bool = true; 
    this.mCameraID = bool;
    if (this.mNeedObject) {
      resetIndexRect();
      return;
    } 
    mySendMessage(130);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\SenseTimeBaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */