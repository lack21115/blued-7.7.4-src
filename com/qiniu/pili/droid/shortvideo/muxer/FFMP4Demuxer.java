package com.qiniu.pili.droid.shortvideo.muxer;

import com.qiniu.pili.droid.shortvideo.f.e;
import java.math.BigDecimal;
import java.nio.ByteBuffer;

public class FFMP4Demuxer {
  private static String a = "FFMP4Demuxer";
  
  private long b;
  
  private native int nativeCloseFile(long paramLong);
  
  private native long nativeGetAudioCodecParams(long paramLong);
  
  private native int nativeGetAudioESDS(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native int nativeGetAudioStreamIndex(long paramLong);
  
  private native int nativeGetAudioTimebaseDen(long paramLong);
  
  private native int nativeGetAudioTimebaseNum(long paramLong);
  
  private native long nativeGetPacketDTS(long paramLong);
  
  private native byte[] nativeGetPacketData(long paramLong);
  
  private native int nativeGetPacketDataSize(long paramLong);
  
  private native long nativeGetPacketDuration(long paramLong);
  
  private native long nativeGetPacketPTS(long paramLong);
  
  private native int nativeGetPacketStreamIndex(long paramLong);
  
  private native float nativeGetPacketTimestamp(long paramLong1, int paramInt, long paramLong2);
  
  private native long nativeGetVideoCodecParams(long paramLong);
  
  private native int nativeGetVideoFrameRate(long paramLong);
  
  private native int nativeGetVideoRotate(long paramLong);
  
  private native int nativeGetVideoSPSPPS(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native int nativeGetVideoStreamIndex(long paramLong);
  
  private native int nativeGetVideoTimebaseDen(long paramLong);
  
  private native int nativeGetVideoTimebaseNum(long paramLong);
  
  private native int nativeIsPacketKeyFrame(long paramLong);
  
  private native long nativeOpenFile(String paramString);
  
  private native long nativeReadNextPacket(long paramLong);
  
  private native int nativeSeek(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
  
  public int a() {
    return nativeGetVideoStreamIndex(this.b);
  }
  
  public int a(int paramInt1, long paramLong, int paramInt2) {
    return nativeSeek(this.b, paramInt1, paramLong, paramInt2);
  }
  
  public int a(long paramLong) {
    return nativeGetPacketStreamIndex(paramLong);
  }
  
  public int a(ByteBuffer paramByteBuffer, int paramInt) {
    return nativeGetVideoSPSPPS(this.b, paramByteBuffer, paramInt);
  }
  
  public long a(int paramInt, long paramLong) {
    BigDecimal bigDecimal = new BigDecimal(nativeGetPacketTimestamp(this.b, paramInt, paramLong));
    bigDecimal.setScale(6, 5);
    return (long)(bigDecimal.floatValue() * 1000000.0F);
  }
  
  public boolean a(String paramString) {
    this.b = nativeOpenFile(paramString);
    if (this.b == -1L) {
      e.n.e(a, "demuxer create failed!");
      return false;
    } 
    return true;
  }
  
  public int b() {
    return nativeGetAudioStreamIndex(this.b);
  }
  
  public int b(ByteBuffer paramByteBuffer, int paramInt) {
    return nativeGetAudioESDS(this.b, paramByteBuffer, paramInt);
  }
  
  public byte[] b(long paramLong) {
    return nativeGetPacketData(paramLong);
  }
  
  public int c() {
    return nativeGetVideoFrameRate(this.b);
  }
  
  public int c(long paramLong) {
    return nativeGetPacketDataSize(paramLong);
  }
  
  public int d() {
    return nativeGetVideoRotate(this.b);
  }
  
  public int d(long paramLong) {
    return nativeIsPacketKeyFrame(paramLong);
  }
  
  public int e() {
    return nativeGetAudioTimebaseNum(this.b);
  }
  
  public long e(long paramLong) {
    return nativeGetPacketPTS(paramLong);
  }
  
  public int f() {
    return nativeGetAudioTimebaseDen(this.b);
  }
  
  public long f(long paramLong) {
    return nativeGetPacketDTS(paramLong);
  }
  
  public int g() {
    return nativeGetVideoTimebaseNum(this.b);
  }
  
  public long g(long paramLong) {
    return nativeGetPacketDuration(paramLong);
  }
  
  public int h() {
    return nativeGetVideoTimebaseDen(this.b);
  }
  
  public long i() {
    return nativeReadNextPacket(this.b);
  }
  
  public long j() {
    return nativeGetVideoCodecParams(this.b);
  }
  
  public long k() {
    return nativeGetAudioCodecParams(this.b);
  }
  
  public int l() {
    return nativeCloseFile(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\muxer\FFMP4Demuxer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */