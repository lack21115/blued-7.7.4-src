package com.huawei.hms.common.api;

public class CommonStatusCodes {
  public static final int API_NOT_CONNECTED = 17;
  
  public static final int CANCELED = 16;
  
  public static final int DEVELOPER_ERROR = 10;
  
  public static final int ERROR = 13;
  
  public static final int INTERNAL_ERROR = 8;
  
  public static final int INTERRUPTED = 14;
  
  public static final int INVALID_ACCOUNT = 5;
  
  public static final int NETWORK_ERROR = 7;
  
  public static final int RESOLUTION_REQUIRED = 6;
  
  @Deprecated
  public static final int SERVICE_DISABLED = 3;
  
  @Deprecated
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  
  public static final int SIGN_IN_REQUIRED = 4;
  
  public static final int SUCCESS = 0;
  
  public static final int SUCCESS_CACHE = -1;
  
  public static final int TIMEOUT = 15;
  
  public static String getStatusCodeString(int paramInt) {
    if (paramInt != -1) {
      if (paramInt != 0) {
        if (paramInt != 10) {
          if (paramInt != 9004) {
            StringBuilder stringBuilder;
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("unknown status code: ");
                    stringBuilder.append(paramInt);
                    return stringBuilder.toString();
                  case 17:
                    return "API_NOT_CONNECTED";
                  case 16:
                    return "CANCELED";
                  case 15:
                    return "TIMEOUT";
                  case 14:
                    return "INTERRUPTED";
                  case 13:
                    break;
                } 
                return "ERROR";
              case 8:
                return "INTERNAL_ERROR";
              case 7:
                return "NETWORK_ERROR";
              case 6:
                return "RESOLUTION_REQUIRED";
              case 5:
                return "INVALID_ACCOUNT";
              case 4:
                return "SIGN_IN_REQUIRED";
              case 3:
                return "SERVICE_DISABLED";
              case 2:
                break;
            } 
            return "SERVICE_VERSION_UPDATE_REQUIRED";
          } 
          return "DEAD_CLIENT";
        } 
        return "DEVELOPER_ERROR";
      } 
      return "SUCCESS";
    } 
    return "SUCCESS_CACHE";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\api\CommonStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */