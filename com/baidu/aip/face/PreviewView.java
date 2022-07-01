package com.baidu.aip.face;

import android.graphics.RectF;
import android.view.TextureView;

public interface PreviewView {
  ScaleType getScaleType();
  
  TextureView getTextureView();
  
  void mapFromOriginalRect(RectF paramRectF);
  
  void mapFromOriginalRectEx(RectF paramRectF);
  
  void mapToOriginalRect(RectF paramRectF);
  
  void setPreviewSize(int paramInt1, int paramInt2);
  
  void setScaleType(ScaleType paramScaleType);
  
  public enum ScaleType {
    CROP_INSIDE, FIT_HEIGHT, FIT_WIDTH;
    
    static {
      CROP_INSIDE = new ScaleType("CROP_INSIDE", 2);
      $VALUES = new ScaleType[] { FIT_WIDTH, FIT_HEIGHT, CROP_INSIDE };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\PreviewView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */