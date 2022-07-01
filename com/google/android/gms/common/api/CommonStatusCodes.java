package com.google.android.gms.common.api;

public final class CommonStatusCodes {
  public static String getStatusCodeString(int paramInt) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder(32);
        stringBuilder.append("unknown status code: ");
        stringBuilder.append(paramInt);
        return stringBuilder.toString();
      case 18:
        return "DEAD_CLIENT";
      case 17:
        return "API_NOT_CONNECTED";
      case 16:
        return "CANCELED";
      case 15:
        return "TIMEOUT";
      case 14:
        return "INTERRUPTED";
      case 13:
        return "ERROR";
      case 10:
        return "DEVELOPER_ERROR";
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
        return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 0:
        return "SUCCESS";
      case -1:
        break;
    } 
    return "SUCCESS_CACHE";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\CommonStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */