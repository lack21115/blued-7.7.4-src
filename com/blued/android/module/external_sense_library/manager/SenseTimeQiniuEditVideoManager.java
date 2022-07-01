package com.blued.android.module.external_sense_library.manager;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.AppLogger;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.model.STHumanAction;
import java.nio.ByteBuffer;

public class SenseTimeQiniuEditVideoManager extends SenseTimeBaseManager {
  private static final String DRAW_FRAME_TAG = "Blued_Sense_DrawFrame";
  
  private static final String TAG = "Blued_Sense_SenseTimeManager";
  
  private volatile boolean mCameraChanging = false;
  
  public SenseTimeQiniuEditVideoManager(Context paramContext) {
    this(paramContext, true);
  }
  
  public SenseTimeQiniuEditVideoManager(Context paramContext, boolean paramBoolean) {
    super(paramContext, paramBoolean);
    init();
  }
  
  private STHumanAction checkHumanActionDetect() {
    if (this.mIsCreateHumanActionHandleSucceeded && !this.mCameraChanging && this.mImageData != null) {
      if (this.mImageData.length <= 0)
        return null; 
      synchronized (this.mImageDataLock) {
        if (this.mNv21ImageData == null || this.mNv21ImageData.length != this.mImageHeight * this.mImageWidth * 3 / 2)
          this.mNv21ImageData = new byte[this.mImageHeight * this.mImageWidth * 3 / 2]; 
        if (this.mImageData != null && this.mNv21ImageData.length >= this.mImageData.length)
          System.arraycopy(this.mImageData, 0, this.mNv21ImageData, 0, this.mImageData.length); 
        return (this.mImageHeight * this.mImageWidth * 3 / 2 > this.mNv21ImageData.length) ? null : STHumanAction.humanActionRotateAndMirror(humanActionDetect(this.mNv21ImageData), this.mImageWidth, this.mImageHeight, this.mCameraID, this.mImageRotation);
      } 
    } 
    return null;
  }
  
  public void adjustViewPort(int paramInt1, int paramInt2) {
    AppLogger appLogger = AppLogger.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_SenseTimeManageradjustViewPort() | width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height:");
    stringBuilder.append(paramInt2);
    appLogger.a(stringBuilder.toString(), new Object[0]);
    if (this.mSurfaceWidth != paramInt1 || this.mSurfaceHeight != paramInt2) {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
    } 
  }
  
  protected void checkTextureOutId() {
    if (this.mBeautifyTextureId == null) {
      this.mBeautifyTextureId = new int[1];
      GlUtil.a(this.mTexHeight, this.mTexWidth, this.mBeautifyTextureId, 3553);
    } 
    if (this.mStickerTextureOutId == null) {
      this.mStickerTextureOutId = new int[1];
      GlUtil.a(this.mTexHeight, this.mTexWidth, this.mStickerTextureOutId, 3553);
    } 
  }
  
  public int drawFrame(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    checkTexture(paramInt2, paramInt3);
    this.mInputTextureId = paramInt1;
    if (this.mRGBABuffer == null)
      this.mRGBABuffer = ByteBuffer.allocate(this.mTexWidth * this.mTexHeight * 4); 
    this.mRGBABuffer.rewind();
    GLES20.glReadPixels(0, 0, this.mTexWidth, this.mTexHeight, 6408, 5121, this.mRGBABuffer);
    if (this.mOutputBuffer == null) {
      this.mOutputBuffer = new byte[paramInt2 * paramInt3 * 3 / 2];
    } else {
      int i = this.mOutputBuffer.length;
      paramInt2 = paramInt2 * paramInt3 * 3 / 2;
      if (i != paramInt2)
        this.mOutputBuffer = new byte[paramInt2]; 
    } 
    this.mInputTextureId = onFilterProcessTexture(paramInt1, this.mTexWidth, this.mTexHeight, 3, paramBoolean);
    GLES20.glDisable(2929);
    return this.mInputTextureId;
  }
  
  public void enableBeautify(boolean paramBoolean) {}
  
  public void enableSticker(boolean paramBoolean) {}
  
  protected int getCurrentOrientation() {
    int k = Accelerometer.c();
    int j = k - 1;
    int i = j;
    if (j < 0)
      i = k ^ 0x3; 
    return i;
  }
  
  public void handlePreviewFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    this.mImageWidth = paramInt2;
    this.mImageHeight = paramInt1;
    this.mImageRotation = paramInt3;
    AppLogger appLogger = AppLogger.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_SenseTimeManager@@@ data:");
    stringBuilder.append(paramArrayOfbyte.length);
    stringBuilder.append(" | width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" | height:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" | rotation:");
    stringBuilder.append(paramInt3);
    appLogger.a(stringBuilder.toString(), new Object[0]);
    synchronized (this.mImageDataLock) {
      if (this.mImageData == null || this.mImageData.length != this.mImageHeight * this.mImageWidth * 3 / 2)
        this.mImageData = new byte[this.mImageWidth * this.mImageHeight * 3 / 2]; 
      if (paramArrayOfbyte.length <= this.mImageData.length)
        System.arraycopy(paramArrayOfbyte, 0, this.mImageData, 0, paramArrayOfbyte.length); 
      if (this.mNeedObject) {
        this.mProcessImageHandler.removeMessages(100);
        this.mProcessImageHandler.sendEmptyMessage(100);
      } 
      return;
    } 
  }
  
  protected STHumanAction humanActionDetect(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("humanActionDetect() mImageHeight:");
    stringBuilder.append(this.mImageHeight);
    stringBuilder.append(" | mImageWidth:");
    stringBuilder.append(this.mImageWidth);
    LogUtils.b("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
    stringBuilder = new StringBuilder();
    stringBuilder.append("humanActionDetect() getHumanActionOrientation():");
    stringBuilder.append(getHumanActionOrientation());
    LogUtils.b("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
    return this.mSTHumanActionNative.humanActionDetect(paramArrayOfbyte, 3, this.mDetectConfig, getHumanActionOrientation(), this.mImageHeight, this.mImageWidth);
  }
  
  public void onDestroy() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onDestroy()", new Object[0]);
    this.isActive = false;
    destorySTNative();
    if (this.isUseSensor && this.mStickerMaps != null) {
      this.mStickerMaps.clear();
      this.mStickerMaps = null;
    } 
    if (this.mContext == null || ((Activity)this.mContext).isFinishing())
      StickerDataManager.clearData(); 
  }
  
  public void onPause() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onPause()", new Object[0]);
    synchronized (this.mImageDataLock) {
      if (this.mImageData != null)
        this.mImageData = new byte[0]; 
      this.mIsPaused = true;
      if (this.isUseSensor && this.mSensorManager != null)
        this.mSensorManager.unregisterListener(this); 
      return;
    } 
  }
  
  public void onResume() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onResume()", new Object[0]);
    this.mIsPaused = false;
    if (this.isUseSensor)
      registerSensorListener(); 
  }
  
  public void onStart() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onStart()", new Object[0]);
    this.isActive = true;
    if (this.isUseSensor && this.mAccelerometer != null)
      this.mAccelerometer.a(); 
  }
  
  public void onStop() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onStop()", new Object[0]);
    if (this.isUseSensor && this.mAccelerometer != null)
      this.mAccelerometer.b(); 
  }
  
  public void onSurfaceCreated() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onSurfaceCreated()", new Object[0]);
    initFilter();
  }
  
  public void onSurfaceDestroyed() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onSurfaceDestroyed()", new Object[0]);
    deleteInternalTextures();
    destroyFilterNative();
  }
  
  public void setCameraFacing(boolean paramBoolean) {}
  
  protected void setHumanActionDetectConfig(boolean paramBoolean, long paramLong) {
    if (!this.mNeedSticker || this.mCurrentStickerModel == null || TextUtils.isEmpty(this.mCurrentStickerModel.localPath))
      paramLong = 0L; 
    if (paramBoolean) {
      this.mDetectConfig = paramLong | 0x1L | 0x4L | 0x410000FEFF00L;
      return;
    } 
    this.mDetectConfig = paramLong;
  }
  
  public void switchCamera() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\SenseTimeQiniuEditVideoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */