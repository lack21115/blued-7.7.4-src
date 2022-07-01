package com.sensetime.stmobile;

import android.content.Context;
import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAnimalFace;
import com.sensetime.stmobile.model.STCondition;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STStickerInputParams;
import com.sensetime.stmobile.model.STTransParam;
import com.sensetime.stmobile.sticker_module_types.STModuleInfo;

public class STMobileStickerNative {
  public static final int ST_INPUT_PARAM_CAMERA_QUATERNION = 1;
  
  public static final int ST_INPUT_PARAM_NONE = 0;
  
  public static final int ST_MOBILE_BROW_JUMP = 32;
  
  public static final int ST_MOBILE_EYE_BLINK = 2;
  
  public static final int ST_MOBILE_HEAD_PITCH = 16;
  
  public static final int ST_MOBILE_HEAD_YAW = 8;
  
  public static final int ST_MOBILE_MOUTH_AH = 4;
  
  private static final String TAG = STMobileStickerNative.class.getSimpleName();
  
  private static ItemCallback mCallback;
  
  private STSoundPlay mSoundPlay;
  
  private STStickerEvent mStickerEvent;
  
  private long nativeStickerHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  private native int createInstanceNative();
  
  private native void destroyInstanceNative();
  
  public static void item_callback(String paramString, int paramInt) {
    ItemCallback itemCallback = mCallback;
    if (itemCallback != null)
      itemCallback.processTextureCallback(paramString, RenderStatus.fromStatus(paramInt)); 
  }
  
  public static void setCallback(ItemCallback paramItemCallback) {
    mCallback = paramItemCallback;
  }
  
  public native int addModuleTransition(int paramInt1, int paramInt2, STCondition[] paramArrayOfSTCondition, STTransParam[] paramArrayOfSTTransParam, int[] paramArrayOfint);
  
  public native int addSticker(String paramString);
  
  public native int addStickerFromAssetsFile(String paramString, AssetManager paramAssetManager);
  
  public native int changeSticker(String paramString);
  
  public native int changeStickerFromAssetsFile(String paramString, AssetManager paramAssetManager);
  
  public native int clearModuleTransition(int paramInt);
  
  public int createInstance(Context paramContext) {
    if (paramContext != null)
      this.mSoundPlay = new STSoundPlay(paramContext); 
    int i = createInstanceNative();
    if (i == 0) {
      STSoundPlay sTSoundPlay = this.mSoundPlay;
      if (sTSoundPlay != null)
        sTSoundPlay.setStickHandle(this); 
    } 
    if (i == 0) {
      STStickerEvent.createInstance();
      this.mStickerEvent = STStickerEvent.getInstance();
    } 
    return i;
  }
  
  public native int createModule(int paramInt1, int paramInt2, int paramInt3);
  
  public native int createSticker(int paramInt);
  
  public void destroyInstance() {
    destroyInstanceNative();
    STSoundPlay sTSoundPlay = this.mSoundPlay;
    if (sTSoundPlay != null) {
      sTSoundPlay.release();
      this.mSoundPlay = null;
    } 
  }
  
  public native long getAnimalDetectConfig();
  
  public native STModuleInfo[] getModules();
  
  public native int getNeededInputParams();
  
  public native int[] getPackageIds();
  
  public native int getParamInt(int paramInt1, int paramInt2);
  
  public native long getTriggerAction();
  
  public native int loadAvatarModel(String paramString);
  
  public native int loadAvatarModelFromAssetFile(String paramString, AssetManager paramAssetManager);
  
  public native int moveModuleToPackage(int paramInt1, int paramInt2);
  
  public native int processTexture(int paramInt1, STHumanAction paramSTHumanAction, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, STStickerInputParams paramSTStickerInputParams, int paramInt6);
  
  public native int processTextureAndOutputBuffer(int paramInt1, STHumanAction paramSTHumanAction, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, STStickerInputParams paramSTStickerInputParams, int paramInt6, int paramInt7, byte[] paramArrayOfbyte);
  
  public native int processTextureBoth(int paramInt1, STHumanAction paramSTHumanAction, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, STStickerInputParams paramSTStickerInputParams, STAnimalFace[] paramArrayOfSTAnimalFace, int paramInt6, int paramInt7);
  
  public native void removeAllStickers();
  
  public native int removeAvatarModel();
  
  public native int removeModule(int paramInt);
  
  public native int removeSticker(int paramInt);
  
  public native int removeTransition(int paramInt);
  
  public native int setMaxMemory(int paramInt);
  
  public native int setParamBool(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native int setParamFloat(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native int setParamInt(int paramInt1, int paramInt2, int paramInt3);
  
  public native int setParamLong(int paramInt1, int paramInt2, long paramLong);
  
  public native int setParamStr(int paramInt1, int paramInt2, String paramString);
  
  public native int setSoundPlayDone(String paramString);
  
  public native int setWaitingMaterialLoaded(boolean paramBoolean);
  
  public static interface ItemCallback {
    void processTextureCallback(String param1String, STMobileStickerNative.RenderStatus param1RenderStatus);
  }
  
  enum RenderStatus {
    ST_MATERIAL_BEGIN_RENDER(0),
    ST_MATERIAL_NO_RENDERING(0),
    ST_MATERIAL_RENDERING(1);
    
    private final int status;
    
    static {
      $VALUES = new RenderStatus[] { ST_MATERIAL_BEGIN_RENDER, ST_MATERIAL_RENDERING, ST_MATERIAL_NO_RENDERING };
    }
    
    RenderStatus(int param1Int1) {
      this.status = param1Int1;
    }
    
    public static RenderStatus fromStatus(int param1Int) {
      for (RenderStatus renderStatus : values()) {
        if (renderStatus.getStatus() == param1Int)
          return renderStatus; 
      } 
      return null;
    }
    
    public int getStatus() {
      return this.status;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileStickerNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */