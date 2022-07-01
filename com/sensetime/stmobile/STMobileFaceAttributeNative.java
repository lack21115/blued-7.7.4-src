package com.sensetime.stmobile;

import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STFaceAttribute;
import com.sensetime.stmobile.model.STMobile106;
import com.sensetime.stmobile.model.STMobileFaceInfo;

public class STMobileFaceAttributeNative {
  private long nativeHandle;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public native int createInstance(String paramString);
  
  public native int createInstanceFromAssetFile(String paramString, AssetManager paramAssetManager);
  
  public native void destroyInstance();
  
  public native int detect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STMobile106[] paramArrayOfSTMobile106, STFaceAttribute[] paramArrayOfSTFaceAttribute);
  
  public native int detect2(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STMobileFaceInfo[] paramArrayOfSTMobileFaceInfo, STFaceAttribute[] paramArrayOfSTFaceAttribute);
  
  public native int detect_ext(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STMobile106[] paramArrayOfSTMobile106, float[][] paramArrayOffloat);
  
  public native int detect_ext2(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, STMobileFaceInfo[] paramArrayOfSTMobileFaceInfo, float[][] paramArrayOffloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STMobileFaceAttributeNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */