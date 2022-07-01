package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STImage;

public class STMobileMakeupNative {
  private long nativeMakeupHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public native int addMakeupForType(int paramInt, String paramString);
  
  public native int addMakeupForTypeFromAssetsFile(int paramInt, String paramString, AssetManager paramAssetManager);
  
  public native void clearMakeups();
  
  public native int createInstance();
  
  public native int destroyInstance();
  
  public native long getTriggerAction();
  
  public native int prepare(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STHumanAction paramSTHumanAction);
  
  public native int processTexture(int paramInt1, STHumanAction paramSTHumanAction, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native int processTextureAndOutputBuffer(int paramInt1, STHumanAction paramSTHumanAction, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfbyte);
  
  public native int removeMakeup(int paramInt);
  
  public native int setMakeupForType(int paramInt, String paramString);
  
  public native int setMakeupForTypeFromAssetsFile(int paramInt, String paramString, AssetManager paramAssetManager);
  
  public native void setResourceForType(int paramInt1, int paramInt2, STImage paramSTImage);
  
  public native void setSmoothStrengthForType(int paramInt, float paramFloat);
  
  public native void setStrengthForType(int paramInt, float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileMakeupNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */