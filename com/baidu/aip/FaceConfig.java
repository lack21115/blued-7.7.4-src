package com.baidu.aip;

import java.io.Serializable;

public class FaceConfig implements Serializable {
  private static final String TAG = FaceConfig.class.getSimpleName();
  
  public float blurnessValue = 0.7F;
  
  public float brightnessValue = 40.0F;
  
  public int cropFaceValue = 400;
  
  public int faceDecodeNumberOfThreads = 0;
  
  public int headPitchValue = 10;
  
  public int headRollValue = 10;
  
  public int headYawValue = 10;
  
  public boolean isCheckFaceQuality = true;
  
  public boolean isLivenessRandom = false;
  
  public boolean isSound = true;
  
  public boolean isVerifyLive = true;
  
  public int livenessRandomCount = 3;
  
  public int maxCropImageNum = 1;
  
  public int minFaceSize = 200;
  
  public float notFaceValue = 0.6F;
  
  public float occlusionValue = 0.5F;
  
  public float getBlurnessValue() {
    return this.blurnessValue;
  }
  
  public float getBrightnessValue() {
    return this.brightnessValue;
  }
  
  public int getCropFaceValue() {
    return this.cropFaceValue;
  }
  
  public int getFaceDecodeNumberOfThreads() {
    return this.faceDecodeNumberOfThreads;
  }
  
  public int getHeadPitchValue() {
    return this.headPitchValue;
  }
  
  public int getHeadRollValue() {
    return this.headRollValue;
  }
  
  public int getHeadYawValue() {
    return this.headYawValue;
  }
  
  public int getMaxCropImageNum() {
    return this.maxCropImageNum;
  }
  
  public int getMinFaceSize() {
    return this.minFaceSize;
  }
  
  public float getNotFaceValue() {
    return this.notFaceValue;
  }
  
  public float getOcclusionValue() {
    return this.occlusionValue;
  }
  
  public boolean isCheckFaceQuality() {
    return this.isCheckFaceQuality;
  }
  
  public boolean isLivenessRandom() {
    return this.isLivenessRandom;
  }
  
  public boolean isSound() {
    return this.isSound;
  }
  
  public boolean isVerifyLive() {
    return this.isVerifyLive;
  }
  
  public void setBlurnessValue(float paramFloat) {
    this.blurnessValue = paramFloat;
  }
  
  public void setBrightnessValue(float paramFloat) {
    this.brightnessValue = paramFloat;
  }
  
  public void setCheckFaceQuality(boolean paramBoolean) {
    this.isCheckFaceQuality = paramBoolean;
  }
  
  public void setCropFaceValue(int paramInt) {
    this.cropFaceValue = paramInt;
  }
  
  public void setFaceDecodeNumberOfThreads(int paramInt) {
    this.faceDecodeNumberOfThreads = paramInt;
  }
  
  public void setHeadPitchValue(int paramInt) {
    this.headPitchValue = paramInt;
  }
  
  public void setHeadRollValue(int paramInt) {
    this.headRollValue = paramInt;
  }
  
  public void setHeadYawValue(int paramInt) {
    this.headYawValue = paramInt;
  }
  
  public void setLivenessRandom(boolean paramBoolean) {
    this.isLivenessRandom = paramBoolean;
  }
  
  public void setMaxCropImageNum(int paramInt) {
    this.maxCropImageNum = paramInt;
  }
  
  public void setMinFaceSize(int paramInt) {
    this.minFaceSize = paramInt;
  }
  
  public void setNotFaceValue(float paramFloat) {
    this.notFaceValue = paramFloat;
  }
  
  public void setOcclusionValue(float paramFloat) {
    this.occlusionValue = paramFloat;
  }
  
  public void setSound(boolean paramBoolean) {
    this.isSound = paramBoolean;
  }
  
  public void setVerifyLive(boolean paramBoolean) {
    this.isVerifyLive = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\FaceConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */