package com.sensetime.stmobile;

public class STStickerEvent {
  private static String TAG = "STStickerEvent";
  
  private static STStickerEvent mInstance;
  
  private StickerEventListener mStickerEventDefaultListener;
  
  public static STStickerEvent createInstance() {
    if (mInstance == null)
      mInstance = new STStickerEvent(); 
    return mInstance;
  }
  
  public static STStickerEvent getInstance() {
    return mInstance;
  }
  
  private void onAnimationEvent(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
    StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
    if (stickerEventListener != null)
      stickerEventListener.onAnimationEvent(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong); 
  }
  
  private void onKeyFrameEvent(String paramString, int paramInt) {
    StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
    if (stickerEventListener != null)
      stickerEventListener.onKeyFrameEvent(paramString, paramInt); 
  }
  
  private void onPackageEvent(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    StickerEventListener stickerEventListener = this.mStickerEventDefaultListener;
    if (stickerEventListener != null)
      stickerEventListener.onPackageEvent(paramString, paramInt1, paramInt2, paramInt3); 
  }
  
  public void setStickerEventListener(StickerEventListener paramStickerEventListener) {
    if (paramStickerEventListener != null)
      this.mStickerEventDefaultListener = paramStickerEventListener; 
  }
  
  public static interface StickerEventListener {
    void onAnimationEvent(String param1String, int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long);
    
    void onKeyFrameEvent(String param1String, int param1Int);
    
    void onPackageEvent(String param1String, int param1Int1, int param1Int2, int param1Int3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STStickerEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */