package com.baidu.aip.face.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CameraView extends FrameLayout {
  public static final int ORIENTATION_HORIZONTAL = 1;
  
  public static final int ORIENTATION_INVERT = 2;
  
  public static final int ORIENTATION_PORTRAIT = 0;
  
  private ICameraControl cameraControl;
  
  private CameraViewTakePictureCallback cameraViewTakePictureCallback = new CameraViewTakePictureCallback();
  
  private View displayView;
  
  private ImageView hintView;
  
  public CameraView(Context paramContext) {
    super(paramContext);
    init();
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init() {
    if (Build.VERSION.SDK_INT >= 21) {
      this.cameraControl = new Camera2Control(getContext());
    } else {
      this.cameraControl = new Camera1Control(getContext());
    } 
    this.displayView = this.cameraControl.getDisplayView();
    addView(this.displayView);
    this.hintView = new ImageView(getContext());
    addView((View)this.hintView);
  }
  
  public ICameraControl getCameraControl() {
    return this.cameraControl;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.displayView.layout(paramInt1, 0, paramInt3, paramInt4 - paramInt2);
  }
  
  public void setOrientation(int paramInt) {
    this.cameraControl.setDisplayOrientation(paramInt);
  }
  
  public void start() {
    this.cameraControl.start();
    setKeepScreenOn(true);
  }
  
  public void stop() {
    this.cameraControl.stop();
    setKeepScreenOn(false);
  }
  
  class CameraViewTakePictureCallback implements ICameraControl.OnTakePictureCallback {
    private CameraViewTakePictureCallback() {}
    
    public void onPictureTaken(byte[] param1ArrayOfbyte) {}
  }
  
  static interface OnTakePictureCallback {
    void onPictureTaken(Bitmap param1Bitmap);
  }
  
  public static @interface Orientation {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\camera\CameraView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */