package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STMobileFaceInfo;

public class STMobileAvatarNative {
  private long nativeAvatarHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public native int avatarExpressionDetect(int paramInt1, int paramInt2, int paramInt3, STMobileFaceInfo paramSTMobileFaceInfo, float[] paramArrayOffloat);
  
  public native int createInstance(String paramString);
  
  public native int createInstanceFromAssetFile(String paramString, AssetManager paramAssetManager);
  
  public native void destroyInstance();
  
  public native long getAvatarDetectConfig();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileAvatarNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */