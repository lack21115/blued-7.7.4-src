package com.amap.api.maps2d.model;

public interface TileProvider {
  public static final Tile NO_TILE = new Tile(-1, -1, null);
  
  Tile getTile(int paramInt1, int paramInt2, int paramInt3);
  
  int getTileHeight();
  
  int getTileWidth();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\maps2d\model\TileProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */