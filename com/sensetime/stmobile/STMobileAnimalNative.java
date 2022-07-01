package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STAnimalFace;

public class STMobileAnimalNative {
  public static final long ST_MOBILE_CAT_DETECT = 1L;
  
  private static final String TAG = STMobileAnimalNative.class.getSimpleName();
  
  private long nativeAnimalHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public static native STAnimalFace[] animalMirror(int paramInt1, STAnimalFace[] paramArrayOfSTAnimalFace, int paramInt2);
  
  public static native STAnimalFace[] animalResize(int paramInt1, STAnimalFace[] paramArrayOfSTAnimalFace, int paramInt2);
  
  public static native STAnimalFace[] animalRotate(int paramInt1, int paramInt2, int paramInt3, STAnimalFace[] paramArrayOfSTAnimalFace, int paramInt4);
  
  public native STAnimalFace[] animalDetect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int createInstance(String paramString, int paramInt);
  
  public native int createInstanceFromAssetFile(String paramString, int paramInt, AssetManager paramAssetManager);
  
  public native void destroyInstance();
  
  public native int reset();
  
  public native int setParam(int paramInt, float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileAnimalNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */