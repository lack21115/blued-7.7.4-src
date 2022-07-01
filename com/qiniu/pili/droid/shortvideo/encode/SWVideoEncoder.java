package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.nio.ByteBuffer;

public class SWVideoEncoder extends f {
  private PLVideoEncodeSetting f;
  
  private long mVideoEncoderId = 0L;
  
  public SWVideoEncoder(PLVideoEncodeSetting paramPLVideoEncodeSetting) {
    this.f = paramPLVideoEncodeSetting;
  }
  
  private MediaFormat a(PLVideoEncodeSetting paramPLVideoEncodeSetting, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", paramPLVideoEncodeSetting.getVideoEncodingWidth(), paramPLVideoEncodeSetting.getVideoEncodingHeight());
    int i = Math.round(paramPLVideoEncodeSetting.getIFrameInterval() * 1.0F / paramPLVideoEncodeSetting.getVideoEncodingFps());
    mediaFormat.setInteger("bitrate", (int)(paramPLVideoEncodeSetting.getEncodingBitrate() * this.a));
    mediaFormat.setInteger("frame-rate", (int)(paramPLVideoEncodeSetting.getVideoEncodingFps() * this.a));
    mediaFormat.setInteger("i-frame-interval", i);
    mediaFormat.setInteger("profile", g.a(paramPLVideoEncodeSetting.getProfileMode()));
    mediaFormat.setInteger("level", 1);
    mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramArrayOfbyte1));
    mediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(paramArrayOfbyte2));
    return mediaFormat;
  }
  
  private boolean n() {
    return nativeSetParam(1, this.f.getVideoEncodingWidth()) & true & nativeSetParam(2, this.f.getVideoEncodingHeight()) & nativeSetParam(3, (int)(this.f.getEncodingBitrate() * this.a)) & nativeSetParam(5, (int)(this.f.getVideoEncodingFps() * this.a)) & nativeSetParam(4, (int)(this.f.getIFrameInterval() * this.a)) & nativeSetParam(7, this.f.getProfileMode().ordinal());
  }
  
  private native boolean nativeClose();
  
  private native boolean nativeEncode(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  private native boolean nativeInit();
  
  private native boolean nativeOpen();
  
  private native boolean nativeRelease();
  
  private native boolean nativeSetParam(int paramInt1, int paramInt2);
  
  private void onSpsPpsEncoded(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    MediaFormat mediaFormat = a(this.f, paramArrayOfbyte1, paramArrayOfbyte2);
    if (this.d != null)
      this.d.a(mediaFormat); 
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("create format: ");
    stringBuilder.append(mediaFormat);
    e.c("SWVideoEncoder", stringBuilder.toString());
  }
  
  private void onVideoFrameEncoded(int paramInt, boolean paramBoolean, long paramLong) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("on frame encoded: ");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(", ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" bytes");
    stringBuilder.append(", ts = ");
    stringBuilder.append(paramLong);
    e.b("SWVideoEncoder", stringBuilder.toString());
    if (this.d == null)
      return; 
    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    bufferInfo.offset = 0;
    bufferInfo.size = paramInt;
    bufferInfo.presentationTimeUs = paramLong;
    if (paramBoolean)
      bufferInfo.flags |= 0x1; 
    this.d.a(this.e, bufferInfo);
    e();
  }
  
  boolean a(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    return nativeEncode(paramByteBuffer, paramArrayOfbyte, paramInt, paramLong / 1000L);
  }
  
  boolean g() {
    return (nativeInit() && n());
  }
  
  boolean h() {
    return nativeRelease();
  }
  
  boolean i() {
    return nativeOpen();
  }
  
  public String j() {
    return "SWVideoEncoder";
  }
  
  boolean k() {
    return nativeClose();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\SWVideoEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */