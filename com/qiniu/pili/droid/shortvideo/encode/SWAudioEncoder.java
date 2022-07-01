package com.qiniu.pili.droid.shortvideo.encode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.nio.ByteBuffer;

public class SWAudioEncoder extends f {
  private PLAudioEncodeSetting f;
  
  private long mAudioEncoderId = 0L;
  
  public SWAudioEncoder(PLAudioEncodeSetting paramPLAudioEncodeSetting) {
    this.f = paramPLAudioEncodeSetting;
  }
  
  private MediaFormat a(PLAudioEncodeSetting paramPLAudioEncodeSetting, byte[] paramArrayOfbyte) {
    MediaFormat mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramPLAudioEncodeSetting.getSamplerate(), paramPLAudioEncodeSetting.getChannels());
    mediaFormat.setInteger("bitrate", paramPLAudioEncodeSetting.getBitrate());
    mediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(paramArrayOfbyte));
    return mediaFormat;
  }
  
  private boolean n() {
    return nativeSetParam(1, this.f.getSamplerate()) & true & nativeSetParam(2, this.f.getChannels()) & nativeSetParam(3, this.f.getBitrate());
  }
  
  private native boolean nativeClose();
  
  private native boolean nativeEncode(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  private native boolean nativeInit();
  
  private native boolean nativeOpen();
  
  private native boolean nativeRelease();
  
  private native boolean nativeSetParam(int paramInt1, int paramInt2);
  
  private void onAudioFrameEncoded(int paramInt, long paramLong) {
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("on frame encoded: size = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" bytes");
    stringBuilder.append(", ts = ");
    stringBuilder.append(paramLong);
    e.b("SWAudioEncoder", stringBuilder.toString());
    if (this.d == null)
      return; 
    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    bufferInfo.offset = 0;
    bufferInfo.size = paramInt;
    bufferInfo.presentationTimeUs = paramLong;
    this.d.a(this.e, bufferInfo);
    e();
  }
  
  private void onESDSEncoded(byte[] paramArrayOfbyte) {
    MediaFormat mediaFormat = a(this.f, paramArrayOfbyte);
    if (this.d != null)
      this.d.a(mediaFormat); 
    e e = e.h;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("create format: ");
    stringBuilder.append(mediaFormat);
    e.c("SWAudioEncoder", stringBuilder.toString());
  }
  
  boolean a(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    return nativeEncode(paramByteBuffer, paramArrayOfbyte, paramInt, paramLong);
  }
  
  public long b() {
    return 0L;
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
    return "SWAudioEncoder";
  }
  
  boolean k() {
    return nativeClose();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\encode\SWAudioEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */