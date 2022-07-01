package com.qiniu.pili.droid.shortvideo;

public interface PLAuthenticationResultCallback {
  public static final int Authorized = 1;
  
  public static final int UnAuthorized = 0;
  
  public static final int UnCheck = -1;
  
  void onAuthorizationResult(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLAuthenticationResultCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */