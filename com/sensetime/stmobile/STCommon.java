package com.sensetime.stmobile;

public class STCommon {
  public static final int ST_MOBILE_HUMAN_ACTION_MAX_FACE_COUNT = 10;
  
  public static final int ST_MOBILE_TRACKING_ENABLE_DEBOUNCE = 16;
  
  public static final int ST_MOBILE_TRACKING_ENABLE_FACE_ACTION = 32;
  
  public static final int ST_MOBILE_TRACKING_MULTI_THREAD = 0;
  
  public static final int ST_MOBILE_TRACKING_SINGLE_THREAD = 65536;
  
  public static final int ST_PIX_FMT_BGR888 = 5;
  
  public static final int ST_PIX_FMT_BGRA8888 = 4;
  
  public static final int ST_PIX_FMT_GRAY8 = 0;
  
  public static final int ST_PIX_FMT_NV12 = 2;
  
  public static final int ST_PIX_FMT_NV21 = 3;
  
  public static final int ST_PIX_FMT_RGBA8888 = 6;
  
  public static final int ST_PIX_FMT_YUV420P = 1;
  
  static {
    System.loadLibrary("st_mobile");
    System.loadLibrary("stmobile_jni");
  }
  
  public static native int stColorConvert(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int stImageRotate(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void setBrowjumpThreshold(float paramFloat);
  
  public native void setEyeblinkThreshold(float paramFloat);
  
  public native void setHeadpitchThreshold(float paramFloat);
  
  public native void setHeadposeThreshold(float paramFloat);
  
  public native void setHeadyawThreshold(float paramFloat);
  
  public native void setMouthahThreshold(float paramFloat);
  
  public native void setSmoothThreshold(float paramFloat);
  
  enum ResultCode {
    ST_E_ACTIVE_CODE_INVALID,
    ST_E_ACTIVE_FAIL,
    ST_E_AUTH_EXPIRE,
    ST_E_CERTIFICAT_NOT_BE_TRUSTED,
    ST_E_DELNOTFOUND,
    ST_E_FAIL,
    ST_E_FILE_EXPIRE,
    ST_E_FILE_NOT_FOUND,
    ST_E_HANDLE,
    ST_E_INVALIDARG,
    ST_E_INVALID_APPID,
    ST_E_INVALID_AUTH,
    ST_E_INVALID_FILE_FORMAT,
    ST_E_INVALID_PIXEL_FORMAT,
    ST_E_LICENSE_IS_NOT_ACTIVABLE,
    ST_E_NOT_CONNECT_TO_NETWORK,
    ST_E_NO_CAPABILITY,
    ST_E_ONLINE_ACTIVATE_CODE_INVALID,
    ST_E_ONLINE_ACTIVATE_CONNECT_FAIL,
    ST_E_ONLINE_ACTIVATE_FAIL,
    ST_E_ONLINE_ACTIVATE_NO_NEED,
    ST_E_ONLINE_AUTH_CONNECT_FAIL,
    ST_E_ONLINE_AUTH_INVALID,
    ST_E_ONLINE_AUTH_TIMEOUT,
    ST_E_OTHER_LINK_ERRORS_IN_HTTPS,
    ST_E_OUTOFMEMORY,
    ST_E_PLATFORM_NOTSUPPORTED,
    ST_E_SUBMODEL_NOT_EXIST,
    ST_E_UNSUPPORTED_ZIP,
    ST_E_UUID_MISMATCH,
    ST_E_ZIP_EXIST_IN_MEMORY,
    ST_OK(0);
    
    private final int resultCode;
    
    static {
      ST_E_HANDLE = new ResultCode("ST_E_HANDLE", 2, -2);
      ST_E_OUTOFMEMORY = new ResultCode("ST_E_OUTOFMEMORY", 3, -3);
      ST_E_FAIL = new ResultCode("ST_E_FAIL", 4, -4);
      ST_E_DELNOTFOUND = new ResultCode("ST_E_DELNOTFOUND", 5, -5);
      ST_E_INVALID_PIXEL_FORMAT = new ResultCode("ST_E_INVALID_PIXEL_FORMAT", 6, -6);
      ST_E_FILE_NOT_FOUND = new ResultCode("ST_E_FILE_NOT_FOUND", 7, -7);
      ST_E_INVALID_FILE_FORMAT = new ResultCode("ST_E_INVALID_FILE_FORMAT", 8, -8);
      ST_E_FILE_EXPIRE = new ResultCode("ST_E_FILE_EXPIRE", 9, -9);
      ST_E_INVALID_AUTH = new ResultCode("ST_E_INVALID_AUTH", 10, -13);
      ST_E_INVALID_APPID = new ResultCode("ST_E_INVALID_APPID", 11, -14);
      ST_E_AUTH_EXPIRE = new ResultCode("ST_E_AUTH_EXPIRE", 12, -15);
      ST_E_UUID_MISMATCH = new ResultCode("ST_E_UUID_MISMATCH", 13, -16);
      ST_E_ONLINE_AUTH_CONNECT_FAIL = new ResultCode("ST_E_ONLINE_AUTH_CONNECT_FAIL", 14, -17);
      ST_E_ONLINE_AUTH_TIMEOUT = new ResultCode("ST_E_ONLINE_AUTH_TIMEOUT", 15, -18);
      ST_E_ONLINE_AUTH_INVALID = new ResultCode("ST_E_ONLINE_AUTH_INVALID", 16, -19);
      ST_E_LICENSE_IS_NOT_ACTIVABLE = new ResultCode("ST_E_LICENSE_IS_NOT_ACTIVABLE", 17, -20);
      ST_E_ACTIVE_FAIL = new ResultCode("ST_E_ACTIVE_FAIL", 18, -21);
      ST_E_ACTIVE_CODE_INVALID = new ResultCode("ST_E_ACTIVE_CODE_INVALID", 19, -22);
      ST_E_NO_CAPABILITY = new ResultCode("ST_E_NO_CAPABILITY", 20, -23);
      ST_E_PLATFORM_NOTSUPPORTED = new ResultCode("ST_E_PLATFORM_NOTSUPPORTED", 21, -24);
      ST_E_SUBMODEL_NOT_EXIST = new ResultCode("ST_E_SUBMODEL_NOT_EXIST", 22, -26);
      ST_E_ONLINE_ACTIVATE_NO_NEED = new ResultCode("ST_E_ONLINE_ACTIVATE_NO_NEED", 23, -27);
      ST_E_ONLINE_ACTIVATE_FAIL = new ResultCode("ST_E_ONLINE_ACTIVATE_FAIL", 24, -28);
      ST_E_ONLINE_ACTIVATE_CODE_INVALID = new ResultCode("ST_E_ONLINE_ACTIVATE_CODE_INVALID", 25, -29);
      ST_E_ONLINE_ACTIVATE_CONNECT_FAIL = new ResultCode("ST_E_ONLINE_ACTIVATE_CONNECT_FAIL", 26, -30);
      ST_E_UNSUPPORTED_ZIP = new ResultCode("ST_E_UNSUPPORTED_ZIP", 27, -32);
      ST_E_ZIP_EXIST_IN_MEMORY = new ResultCode("ST_E_ZIP_EXIST_IN_MEMORY", 28, -33);
      ST_E_NOT_CONNECT_TO_NETWORK = new ResultCode("ST_E_NOT_CONNECT_TO_NETWORK", 29, -34);
      ST_E_OTHER_LINK_ERRORS_IN_HTTPS = new ResultCode("ST_E_OTHER_LINK_ERRORS_IN_HTTPS", 30, -35);
      ST_E_CERTIFICAT_NOT_BE_TRUSTED = new ResultCode("ST_E_CERTIFICAT_NOT_BE_TRUSTED", 31, -36);
      $VALUES = new ResultCode[] { 
          ST_OK, ST_E_INVALIDARG, ST_E_HANDLE, ST_E_OUTOFMEMORY, ST_E_FAIL, ST_E_DELNOTFOUND, ST_E_INVALID_PIXEL_FORMAT, ST_E_FILE_NOT_FOUND, ST_E_INVALID_FILE_FORMAT, ST_E_FILE_EXPIRE, 
          ST_E_INVALID_AUTH, ST_E_INVALID_APPID, ST_E_AUTH_EXPIRE, ST_E_UUID_MISMATCH, ST_E_ONLINE_AUTH_CONNECT_FAIL, ST_E_ONLINE_AUTH_TIMEOUT, ST_E_ONLINE_AUTH_INVALID, ST_E_LICENSE_IS_NOT_ACTIVABLE, ST_E_ACTIVE_FAIL, ST_E_ACTIVE_CODE_INVALID, 
          ST_E_NO_CAPABILITY, ST_E_PLATFORM_NOTSUPPORTED, ST_E_SUBMODEL_NOT_EXIST, ST_E_ONLINE_ACTIVATE_NO_NEED, ST_E_ONLINE_ACTIVATE_FAIL, ST_E_ONLINE_ACTIVATE_CODE_INVALID, ST_E_ONLINE_ACTIVATE_CONNECT_FAIL, ST_E_UNSUPPORTED_ZIP, ST_E_ZIP_EXIST_IN_MEMORY, ST_E_NOT_CONNECT_TO_NETWORK, 
          ST_E_OTHER_LINK_ERRORS_IN_HTTPS, ST_E_CERTIFICAT_NOT_BE_TRUSTED };
    }
    
    ResultCode(int param1Int1) {
      this.resultCode = param1Int1;
    }
    
    public int getResultCode() {
      return this.resultCode;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */