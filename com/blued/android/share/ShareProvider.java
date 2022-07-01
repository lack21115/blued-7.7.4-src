package com.blued.android.share;

public class ShareProvider {
  private static ShareProvider mShareProvider;
  
  private CallbackListener mCallbackListener;
  
  public static ShareProvider getInstance() {
    if (mShareProvider == null)
      mShareProvider = new ShareProvider(); 
    return mShareProvider;
  }
  
  public void onCancel(String paramString) {
    CallbackListener callbackListener = this.mCallbackListener;
    if (callbackListener != null)
      callbackListener.onCancel(paramString); 
  }
  
  public void onFailure(String paramString) {
    CallbackListener callbackListener = this.mCallbackListener;
    if (callbackListener != null)
      callbackListener.onFailure(paramString); 
  }
  
  public void onResume(String paramString) {
    CallbackListener callbackListener = this.mCallbackListener;
    if (callbackListener != null)
      callbackListener.onResume(paramString); 
  }
  
  public void onSuccess(String paramString) {
    CallbackListener callbackListener = this.mCallbackListener;
    if (callbackListener != null)
      callbackListener.onSuccess(paramString); 
  }
  
  public void registerCallback(CallbackListener paramCallbackListener) {
    if (this.mCallbackListener != null)
      this.mCallbackListener = null; 
    this.mCallbackListener = paramCallbackListener;
  }
  
  public void unregisterCallback() {
    this.mCallbackListener = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\ShareProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */