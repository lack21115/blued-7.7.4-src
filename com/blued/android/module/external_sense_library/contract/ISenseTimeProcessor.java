package com.blued.android.module.external_sense_library.contract;

import android.graphics.Rect;
import android.os.Handler;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;

public interface ISenseTimeProcessor {
  void adjustViewPort(int paramInt1, int paramInt2);
  
  void changeCustomEvent();
  
  void changeSticker(String paramString1, String paramString2);
  
  void changeSticker(String paramString1, String paramString2, ISetStickerListener paramISetStickerListener);
  
  void disableObjectTracking();
  
  int drawFrame(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  void enableBeautify(boolean paramBoolean);
  
  void enableObject(boolean paramBoolean);
  
  void enableSticker(boolean paramBoolean);
  
  Rect getIndexRect();
  
  byte[] getOutputBuffer();
  
  long getStickerTriggerAction();
  
  void handlePreviewFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3);
  
  void onDestroy();
  
  void onPause();
  
  void onResume();
  
  void onStart();
  
  void onStop();
  
  void onSurfaceCreated();
  
  void onSurfaceDestroyed();
  
  void removeAllStickers();
  
  void resetIndexRect();
  
  void setBeautyParam(BluedBeautifyKey.KEY paramKEY, float paramFloat);
  
  void setCameraFacing(boolean paramBoolean);
  
  void setFilterStrength(float paramFloat);
  
  void setFilterStyle(BluedFilterType.FILER paramFILER);
  
  void setHandler(Handler paramHandler);
  
  void setIndexRect(int paramInt1, int paramInt2, boolean paramBoolean);
  
  void setNeedSaveFrame(boolean paramBoolean);
  
  void setObjectTrackRect();
  
  void switchCamera();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\contract\ISenseTimeProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */