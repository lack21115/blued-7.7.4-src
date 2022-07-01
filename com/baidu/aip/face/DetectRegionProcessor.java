package com.baidu.aip.face;

import android.graphics.Rect;
import android.graphics.RectF;
import com.baidu.aip.ImageFrame;

public class DetectRegionProcessor implements FaceProcessor {
  private Rect cropRect = new Rect();
  
  private RectF detectedRect;
  
  private RectF originalCoordinate = new RectF();
  
  public boolean process(FaceDetectManager paramFaceDetectManager, ImageFrame paramImageFrame) {
    RectF rectF = this.detectedRect;
    if (rectF != null) {
      this.originalCoordinate.set(rectF);
      ((CameraImageSource)paramFaceDetectManager.getImageSource()).getCameraControl().getPreviewView().mapToOriginalRect(this.originalCoordinate);
      this.cropRect.left = (int)this.originalCoordinate.left;
      this.cropRect.top = (int)this.originalCoordinate.top;
      this.cropRect.right = (int)this.originalCoordinate.right;
      this.cropRect.bottom = (int)this.originalCoordinate.bottom;
      paramImageFrame.setArgb(FaceCropper.crop(paramImageFrame.getArgb(), paramImageFrame.getWidth(), this.cropRect));
      paramImageFrame.setWidth(this.cropRect.width());
      paramImageFrame.setHeight(this.cropRect.height());
    } 
    return false;
  }
  
  public void setDetectedRect(RectF paramRectF) {
    this.detectedRect = paramRectF;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\DetectRegionProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */