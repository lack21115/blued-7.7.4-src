package com.amap.api.interfaces;

import android.graphics.Point;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLngBounds;

public abstract class MapCameraMessage {
  public float amount;
  
  public LatLngBounds bounds;
  
  public CameraPosition cameraPosition;
  
  public Point focus = null;
  
  public int height;
  
  public boolean isChangeFinished = false;
  
  public Type nowType = Type.a;
  
  public int paddingBottom;
  
  public int paddingLeft;
  
  public int paddingRight;
  
  public int paddingTop;
  
  public int width;
  
  public float xPixel;
  
  public float yPixel;
  
  public float zoom;
  
  public enum Type {
    a, b, c, d, e, f, g, h, i, j, k, l;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\MapCameraMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */