package com.baidu.idl.license;

import android.content.Context;

public class AndroidLicenser {
  private static String deviceID = "";
  
  private static AndroidLicenser mInstance;
  
  public boolean is_remote_authorize = true;
  
  private LicenseReader reader = new LicenseReader();
  
  public static AndroidLicenser getInstance() {
    // Byte code:
    //   0: ldc com/baidu/idl/license/AndroidLicenser
    //   2: monitorenter
    //   3: getstatic com/baidu/idl/license/AndroidLicenser.mInstance : Lcom/baidu/idl/license/AndroidLicenser;
    //   6: ifnonnull -> 19
    //   9: new com/baidu/idl/license/AndroidLicenser
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/baidu/idl/license/AndroidLicenser.mInstance : Lcom/baidu/idl/license/AndroidLicenser;
    //   19: getstatic com/baidu/idl/license/AndroidLicenser.mInstance : Lcom/baidu/idl/license/AndroidLicenser;
    //   22: astore_0
    //   23: ldc com/baidu/idl/license/AndroidLicenser
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/baidu/idl/license/AndroidLicenser
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static String get_device_id(Context paramContext) {
    if ("".equals(deviceID))
      deviceID = LicenseDevice.getDeviceID(paramContext).toUpperCase(); 
    return deviceID;
  }
  
  private String[] get_local_license(Context paramContext) {
    return this.reader.get_local_license(paramContext);
  }
  
  private String[] get_remote_license(Context paramContext, String paramString) {
    return this.reader.get_remote_license(paramContext, paramString);
  }
  
  private native int init_with_algorithm(Context paramContext, String paramString1, String paramString2, int paramInt);
  
  private int reader_init(String paramString) {
    return this.reader.init(paramString);
  }
  
  private native int remote_authenticate(Context paramContext);
  
  public native int authenticate(Context paramContext);
  
  public native String get_decrypted_license();
  
  public native String get_env_device_id(Context paramContext);
  
  public native String get_env_package_name(Context paramContext);
  
  public native String get_env_signature_md5(Context paramContext);
  
  public native long get_expire_time();
  
  public native String get_license_algorithm();
  
  public native String get_license_api_key();
  
  public native String get_license_device_id();
  
  public native String get_license_info(String paramString);
  
  public native String get_license_package_name();
  
  public native String get_license_signature_md5();
  
  public native int init(Context paramContext, String paramString1, String paramString2);
  
  public int init(Context paramContext, String paramString1, String paramString2, int paramInt) {
    return init_with_algorithm(paramContext, paramString1, paramString2, paramInt);
  }
  
  public int put_local_license(Context paramContext, String[] paramArrayOfString) {
    return this.reader.put_local_license(paramContext, paramArrayOfString);
  }
  
  public enum ErrorCode {
    LICENSE_DECRYPT_ERROR, LICENSE_EXPIRED, LICENSE_INFO_CHECK_ERROR, LICENSE_INFO_FORMAT_ERROR, LICENSE_INIT_ERROR, LICENSE_LOCAL_FILE_ERROR, LICENSE_MISS_REQUIRED_INFO, LICENSE_REMOTE_DATA_ERROR, SUCCESS;
    
    static {
      LICENSE_DECRYPT_ERROR = new ErrorCode("LICENSE_DECRYPT_ERROR", 2);
      LICENSE_INFO_FORMAT_ERROR = new ErrorCode("LICENSE_INFO_FORMAT_ERROR", 3);
      LICENSE_EXPIRED = new ErrorCode("LICENSE_EXPIRED", 4);
      LICENSE_MISS_REQUIRED_INFO = new ErrorCode("LICENSE_MISS_REQUIRED_INFO", 5);
      LICENSE_INFO_CHECK_ERROR = new ErrorCode("LICENSE_INFO_CHECK_ERROR", 6);
      LICENSE_LOCAL_FILE_ERROR = new ErrorCode("LICENSE_LOCAL_FILE_ERROR", 7);
      LICENSE_REMOTE_DATA_ERROR = new ErrorCode("LICENSE_REMOTE_DATA_ERROR", 8);
      $VALUES = new ErrorCode[] { SUCCESS, LICENSE_INIT_ERROR, LICENSE_DECRYPT_ERROR, LICENSE_INFO_FORMAT_ERROR, LICENSE_EXPIRED, LICENSE_MISS_REQUIRED_INFO, LICENSE_INFO_CHECK_ERROR, LICENSE_LOCAL_FILE_ERROR, LICENSE_REMOTE_DATA_ERROR };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\idl\license\AndroidLicenser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */