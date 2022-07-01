package com.qiniu.pili.droid.shortvideo;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class PLVideoFrame {
  private byte[] mData;
  
  private a mDataFormat;
  
  private int mHeight;
  
  private boolean mIsKeyFrame;
  
  private int mRotation;
  
  private long mTimestampMs;
  
  private int mWidth;
  
  public byte[] getData() {
    return this.mData;
  }
  
  public a getDataFormat() {
    return this.mDataFormat;
  }
  
  public int getHeight() {
    return this.mHeight;
  }
  
  public int getRotation() {
    return this.mRotation;
  }
  
  public long getTimestampMs() {
    return this.mTimestampMs;
  }
  
  public int getWidth() {
    return this.mWidth;
  }
  
  public boolean isKeyFrame() {
    return this.mIsKeyFrame;
  }
  
  public void setData(byte[] paramArrayOfbyte) {
    this.mData = paramArrayOfbyte;
  }
  
  public void setDataFormat(a parama) {
    this.mDataFormat = parama;
  }
  
  public void setHeight(int paramInt) {
    this.mHeight = paramInt;
  }
  
  public void setIsKeyFrame(boolean paramBoolean) {
    this.mIsKeyFrame = paramBoolean;
  }
  
  public void setRotation(int paramInt) {
    this.mRotation = paramInt;
  }
  
  public void setTimestampMs(long paramLong) {
    this.mTimestampMs = paramLong;
  }
  
  public void setWidth(int paramInt) {
    this.mWidth = paramInt;
  }
  
  public Bitmap toBitmap() {
    Bitmap.Config config;
    int i = this.mWidth;
    int j = this.mHeight;
    if (this.mDataFormat == a.a) {
      config = Bitmap.Config.ARGB_8888;
    } else {
      config = Bitmap.Config.RGB_565;
    } 
    Bitmap bitmap = Bitmap.createBitmap(i, j, config);
    bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.mData));
    return bitmap;
  }
  
  public enum a {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */