package com.qiniu.pili.droid.streaming.processing.image;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.ByteBuffer;

public final class ImageProcessor {
  public static final boolean b = SharedLibraryNameHelper.getInstance().d();
  
  public int a;
  
  public void a() {
    releaseYUVProcessor();
    e.h.c("ImageProcessor", "release");
  }
  
  public void a(int paramInt) {
    if (this.a != paramInt) {
      setFilterMode(paramInt);
      this.a = paramInt;
    } 
  }
  
  public native int convertYUV(ByteBuffer paramByteBuffer1, int paramInt, ByteBuffer paramByteBuffer2, boolean paramBoolean);
  
  public void finalize() {
    try {
      super.finalize();
    } finally {
      Exception exception;
    } 
    e.h.c("ImageProcessor", "finalize");
  }
  
  public native void initYUVProcessor(WatermarkSetting paramWatermarkSetting, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, boolean paramBoolean2);
  
  public native void releaseYUVProcessor();
  
  public final native void setFilterMode(int paramInt);
  
  public native void updateWatermarkSetting(WatermarkSetting paramWatermarkSetting);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\processing\image\ImageProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */