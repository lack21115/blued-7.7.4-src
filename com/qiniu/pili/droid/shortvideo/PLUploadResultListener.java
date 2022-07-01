package com.qiniu.pili.droid.shortvideo;

import org.json.JSONObject;

public interface PLUploadResultListener {
  void onUploadVideoFailed(int paramInt, String paramString);
  
  void onUploadVideoSuccess(JSONObject paramJSONObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLUploadResultListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */