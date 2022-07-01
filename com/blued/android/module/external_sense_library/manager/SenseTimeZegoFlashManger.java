package com.blued.android.module.external_sense_library.manager;

import android.content.Context;
import android.opengl.GLES20;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.external_sense_library.gl.TextureProcessor;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.STUtils;
import com.blued.android.module.external_sense_library.utils.Accelerometer;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.sensetime.stmobile.STCommon;
import com.sensetime.stmobile.model.STHumanAction;

public class SenseTimeZegoFlashManger extends SenseTimeBaseManager {
  byte[] mNV21Data;
  
  public SenseTimeZegoFlashManger(Context paramContext, boolean paramBoolean) {
    super(paramContext, paramBoolean);
    init(false, 328128);
  }
  
  private STHumanAction checkHumanActionDetectWithRGBA() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("checkHumanActionDetect() isCreateHumanActionHandleSucceeded:");
    stringBuilder.append(this.mIsCreateHumanActionHandleSucceeded);
    LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
    if (this.mIsCreateHumanActionHandleSucceeded) {
      if (this.mCameraChanging || this.mImageData == null || this.mImageData.length < this.mImageHeight * this.mImageWidth * 4) {
        LogUtils.c("Blued_Sense_SenseTimeManager", "checkHumanActionDetect() | mCameraChanging || mImageData == null || mImageData.length != mImageHeight * mImageWidth * 3 / 2", new Object[0]);
        return null;
      } 
      synchronized (this.mImageDataLock) {
        if (this.mNV21Data == null || this.mNV21Data.length != this.mImageHeight * this.mImageWidth * 3 / 2)
          this.mNV21Data = new byte[this.mImageHeight * this.mImageWidth * 3 / 2]; 
        STCommon.stColorConvert(this.mImageData, this.mNV21Data, this.mImageWidth, this.mImageHeight, 42);
        null = new StringBuilder();
        null.append("humanActionDetect() mImageHeight:");
        null.append(this.mImageHeight);
        null.append(" | mImageWidth:");
        null.append(this.mImageWidth);
        LogUtils.b("Blued_Sense_SenseTimeManager", null.toString(), new Object[0]);
        null = new StringBuilder();
        null.append("humanActionDetect() getCurrentOrientation():");
        null.append(getCurrentOrientation());
        LogUtils.b("Blued_Sense_SenseTimeManager", null.toString(), new Object[0]);
        null = new StringBuilder();
        null.append("mDetectConfig: ");
        null.append(this.mDetectConfig);
        LogUtils.b("Blued_Sense_SenseTimeManager", null.toString(), new Object[0]);
        null = new StringBuilder();
        null.append("detect imageData: ");
        null.append(this.mImageData.length);
        LogUtils.b("Blued_Sense_SenseTimeManager", null.toString(), new Object[0]);
        return this.mSTHumanActionNative.humanActionDetect(this.mNV21Data, 3, this.mDetectConfig, getCurrentOrientation(), this.mImageWidth, this.mImageHeight);
      } 
    } 
    return null;
  }
  
  public void adjustViewPort(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_SenseTimeManageradjustViewPort() | width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height:");
    stringBuilder.append(paramInt2);
    LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString());
    if (this.mSurfaceWidth != paramInt1 || this.mSurfaceHeight != paramInt2) {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      if (this.mTextureProcessor == null) {
        this.mTextureProcessor = new TextureProcessor(0);
        this.mTextureProcessor.a();
      } 
      this.mTextureProcessor.a(paramInt1, paramInt2);
    } 
  }
  
  protected void checkTextureOutId() {
    if (this.mBeautifyTextureId == null) {
      this.mBeautifyTextureId = new int[1];
      GlUtil.a(this.mTexWidth, this.mTexHeight, this.mBeautifyTextureId, 3553);
    } 
    if (this.mStickerTextureOutId == null) {
      this.mStickerTextureOutId = new int[1];
      GlUtil.a(this.mTexWidth, this.mTexHeight, this.mStickerTextureOutId, 3553);
    } 
    if (this.mFilterTextureOutId == null) {
      this.mFilterTextureOutId = new int[1];
      GlUtil.a(this.mTexWidth, this.mTexHeight, this.mFilterTextureOutId, 3553);
    } 
  }
  
  public int drawFrame(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    checkTexture(paramInt2, paramInt3);
    this.mInputTextureId = paramInt1;
    if (this.mInputTextureId == 0)
      return paramInt1; 
    if (this.mNeedBeautify || this.mNeedSticker || this.mNeedFaceAttribute) {
      STHumanAction sTHumanAction = checkHumanActionDetectWithRGBA();
      if (sTHumanAction == null) {
        LogUtils.c("Blued_Sense_SenseTimeManager", "checkHumanActionDetect() humanAction == null", new Object[0]);
        return paramInt1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("flashDrawFrame() getCurrentOrientation():");
      stringBuilder.append(getCurrentOrientation());
      LogUtils.b("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
      this.mInputTextureId = onBeautifyProcessTexture(this.mInputTextureId, this.mTexWidth, this.mTexHeight, getCurrentOrientation(), 3, sTHumanAction);
      if (this.result == 0)
        sTHumanAction = this.mHumanActionBeautyOutput; 
      if (this.mCameraChanging)
        return this.mInputTextureId; 
      this.mInputTextureId = onStickerProcessTexture(this.mInputTextureId, this.mTexWidth, this.mTexHeight, getCurrentOrientation(), 2, 3, sTHumanAction);
    } 
    if (this.mOutputBuffer == null) {
      this.mOutputBuffer = new byte[paramInt2 * paramInt3 * 4];
    } else {
      paramInt1 = this.mOutputBuffer.length;
      paramInt2 = paramInt2 * paramInt3 * 4;
      if (paramInt1 != paramInt2)
        this.mOutputBuffer = new byte[paramInt2]; 
    } 
    this.mInputTextureId = onFilterProcessTexture(this.mInputTextureId, this.mTexWidth, this.mTexHeight, 3, paramBoolean);
    GLES20.glDisable(2929);
    return this.mInputTextureId;
  }
  
  public void enableBeautify(boolean paramBoolean) {
    this.mNeedBeautify = paramBoolean;
    setHumanActionDetectConfig(this.mNeedBeautify | this.mNeedFaceAttribute, getStickerTriggerAction());
    setHumanActionDetectConfig(this.mNeedBeautify, this.mStStickerNative.getTriggerAction());
  }
  
  protected int getCurrentOrientation() {
    Accelerometer.c();
    return 2;
  }
  
  protected byte[] getImgeData() {
    return this.mNV21Data;
  }
  
  public void handlePreviewFrame(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
    this.mImageRotation = paramInt3;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_SenseTimeManager@@@ data:");
    stringBuilder.append(paramArrayOfbyte.length);
    stringBuilder.append(" | width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" | height:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" | rotation:");
    stringBuilder.append(paramInt3);
    LogUtils.c("Blued_Sense_SenseTimeManager", stringBuilder.toString(), new Object[0]);
    synchronized (this.mImageDataLock) {
      if (this.mImageData == null || this.mImageData.length != this.mImageHeight * this.mImageWidth * 4)
        this.mImageData = new byte[this.mImageHeight * this.mImageWidth * 4]; 
      if (paramArrayOfbyte.length <= this.mImageData.length)
        System.arraycopy(paramArrayOfbyte, 0, this.mImageData, 0, paramArrayOfbyte.length); 
      if (this.mNeedObject) {
        this.mProcessImageHandler.removeMessages(100);
        this.mProcessImageHandler.sendEmptyMessage(100);
      } 
      return;
    } 
  }
  
  public void onDestroy() {
    this.isActive = false;
    destorySTNative();
  }
  
  public void onPause() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onPause()", new Object[0]);
    synchronized (this.mImageDataLock) {
      this.mImageData = new byte[0];
      this.mIsPaused = true;
      return;
    } 
  }
  
  public void onResume() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onResume()", new Object[0]);
    this.mIsPaused = false;
  }
  
  public void onStart() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onStart()", new Object[0]);
    this.isActive = true;
  }
  
  public void onStop() {
    LogUtils.c("Blued_Sense_SenseTimeManager", "onStop()", new Object[0]);
  }
  
  public void onSurfaceCreated() {
    initBeauty();
    initSticker();
    initFilter();
  }
  
  public void onSurfaceDestroyed() {
    deleteInternalTextures();
    onDestroySenseNative();
  }
  
  protected void setHumanActionDetectConfig(boolean paramBoolean, long paramLong) {
    if (paramBoolean) {
      this.mDetectConfig = paramLong | 0x1L;
      return;
    } 
    this.mDetectConfig = paramLong;
  }
  
  public void setObjectTrackRect() {
    super.setObjectTrackRect();
    this.mTargetRect = STUtils.a(getIndexRect(), this.mSurfaceWidth, this.mSurfaceHeight, this.mImageWidth, this.mImageHeight);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\SenseTimeZegoFlashManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */