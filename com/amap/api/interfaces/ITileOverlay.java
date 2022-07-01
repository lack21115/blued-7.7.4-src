package com.amap.api.interfaces;

public interface ITileOverlay {
  void clearTileCache();
  
  boolean equalsRemote(ITileOverlay paramITileOverlay);
  
  String getId();
  
  float getZIndex();
  
  int hashCodeRemote();
  
  boolean isVisible();
  
  void remove();
  
  void setVisible(boolean paramBoolean);
  
  void setZIndex(float paramFloat);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\ITileOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */