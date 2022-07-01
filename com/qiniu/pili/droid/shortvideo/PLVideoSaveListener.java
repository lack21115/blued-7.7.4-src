package com.qiniu.pili.droid.shortvideo;

public interface PLVideoSaveListener {
  void onProgressUpdate(float paramFloat);
  
  void onSaveVideoCanceled();
  
  void onSaveVideoFailed(int paramInt);
  
  void onSaveVideoSuccess(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoSaveListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */