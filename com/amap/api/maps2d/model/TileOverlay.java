package com.amap.api.maps2d.model;

import com.amap.api.interfaces.ITileOverlay;

public final class TileOverlay {
  private ITileOverlay a;
  
  public TileOverlay(ITileOverlay paramITileOverlay) {
    this.a = paramITileOverlay;
  }
  
  public void clearTileCache() {
    this.a.clearTileCache();
  }
  
  public boolean equals(Object paramObject) {
    paramObject = this.a;
    return paramObject.equalsRemote((ITileOverlay)paramObject);
  }
  
  public String getId() {
    return this.a.getId();
  }
  
  public float getZIndex() {
    return this.a.getZIndex();
  }
  
  public int hashCode() {
    return this.a.hashCodeRemote();
  }
  
  public boolean isVisible() {
    return this.a.isVisible();
  }
  
  public void remove() {
    this.a.remove();
  }
  
  public void setVisible(boolean paramBoolean) {
    this.a.setVisible(paramBoolean);
  }
  
  public void setZIndex(float paramFloat) {
    this.a.setZIndex(paramFloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\TileOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */