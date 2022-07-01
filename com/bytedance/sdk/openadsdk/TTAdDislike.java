package com.bytedance.sdk.openadsdk;

public interface TTAdDislike {
  void setDislikeInteractionCallback(DislikeInteractionCallback paramDislikeInteractionCallback);
  
  void showDislikeDialog();
  
  public static interface DislikeInteractionCallback {
    void onCancel();
    
    void onSelected(int param1Int, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTAdDislike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */