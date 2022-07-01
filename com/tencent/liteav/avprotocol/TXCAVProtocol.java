package com.tencent.liteav.avprotocol;

import android.util.Log;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.g;
import java.util.ArrayList;

public class TXCAVProtocol {
  public static byte AV_STATE_ENTER_AUDIO = 1;
  
  public static byte AV_STATE_ENTER_VIDEO = 3;
  
  public static byte AV_STATE_EXIT_AUDIO = 2;
  
  public static byte AV_STATE_EXIT_VIDEO = 4;
  
  public static byte AV_STATE_NONE;
  
  private static final String TAG = TXCAVProtocol.class.getSimpleName();
  
  private long mInstance = 0L;
  
  private TXIAVListener mListener = null;
  
  static {
    g.f();
  }
  
  public TXCAVProtocol() {
    this.mInstance = nativeInitAVProtocol();
  }
  
  private native void nativeChangeAVState(long paramLong, TXIAVCompletionCallback paramTXIAVCompletionCallback, byte paramByte);
  
  private native void nativeEnterRoom(long paramLong1, TXIAVCompletionCallback paramTXIAVCompletionCallback, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfbyte, long paramLong6, int paramInt);
  
  private native void nativeExitRoom(long paramLong, TXIAVCompletionCallback paramTXIAVCompletionCallback);
  
  private native DownloadStats nativeGetDownloadStats(long paramLong);
  
  private native long[] nativeGetRoomMemberList(long paramLong);
  
  private native long[] nativeGetRoomVideoList(long paramLong);
  
  private native UploadStats nativeGetUploadStats(long paramLong);
  
  private native long nativeInitAVProtocol();
  
  private native void nativePushAAC(long paramLong1, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  private native void nativePushNAL(long paramLong1, byte[] paramArrayOfbyte, int paramInt, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
  
  private native void nativeRequestViews(long paramLong, TXIAVCompletionCallback paramTXIAVCompletionCallback, long[] paramArrayOflong, int[] paramArrayOfint1, int[] paramArrayOfint2);
  
  private native void nativeUninitAVProtocol(long paramLong);
  
  private void onMemberChange(long paramLong, boolean paramBoolean) {
    this.mListener.onMemberChange(paramLong, paramBoolean);
  }
  
  private void onPullAudio(int paramInt1, long paramLong1, byte[] paramArrayOfbyte, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (this.mListener != null) {
      TXSAVProtoAudioPacket tXSAVProtoAudioPacket = new TXSAVProtoAudioPacket();
      tXSAVProtoAudioPacket.roomID = paramInt1;
      tXSAVProtoAudioPacket.tinyID = paramLong1;
      tXSAVProtoAudioPacket.audioData = paramArrayOfbyte;
      tXSAVProtoAudioPacket.timestamp = paramLong2;
      tXSAVProtoAudioPacket.sampleRate = paramInt2;
      tXSAVProtoAudioPacket.channelsPerSample = paramInt3;
      tXSAVProtoAudioPacket.bitsPerChannel = paramInt4;
      tXSAVProtoAudioPacket.packetType = paramInt5;
      this.mListener.onPullAudio(tXSAVProtoAudioPacket);
    } 
  }
  
  private void onPullVideo(int paramInt1, long paramLong1, byte[] paramArrayOfbyte, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    if (this.mListener != null) {
      TXSAVProtoNALPacket tXSAVProtoNALPacket = new TXSAVProtoNALPacket();
      tXSAVProtoNALPacket.roomID = paramInt1;
      tXSAVProtoNALPacket.tinyID = paramLong1;
      tXSAVProtoNALPacket.nalType = paramInt2;
      tXSAVProtoNALPacket.nalData = paramArrayOfbyte;
      tXSAVProtoNALPacket.pts = paramLong2;
      tXSAVProtoNALPacket.dts = paramLong3;
      tXSAVProtoNALPacket.gopIndex = paramInt3;
      tXSAVProtoNALPacket.gopFrameIndex = paramInt4;
      tXSAVProtoNALPacket.frameIndex = paramInt5;
      tXSAVProtoNALPacket.refFremeIndex = paramInt6;
      this.mListener.onPullNAL(tXSAVProtoNALPacket);
    } 
  }
  
  private void onVideoStateChange(long paramLong, boolean paramBoolean) {
    this.mListener.onVideoStateChange(paramLong, paramBoolean);
  }
  
  private void sendNotifyEvent(int paramInt, String paramString) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("event");
    stringBuilder.append(paramInt);
    Log.i(str, stringBuilder.toString());
    this.mListener.sendNotifyEvent(paramInt, paramString);
  }
  
  public void changeAVState(byte paramByte, TXIAVCompletionCallback paramTXIAVCompletionCallback) {
    long l = this.mInstance;
    if (l == 0L)
      return; 
    nativeChangeAVState(l, paramTXIAVCompletionCallback, paramByte);
  }
  
  public void destory() {
    long l = this.mInstance;
    if (l == 0L)
      return; 
    nativeUninitAVProtocol(l);
    this.mInstance = 0L;
  }
  
  public void enterRoom(TXCAVProtoParam paramTXCAVProtoParam, TXIAVCompletionCallback paramTXIAVCompletionCallback) {
    if (this.mInstance == 0L)
      return; 
    int i = (int)c.a().a("QUICMode", "AVRoom");
    nativeEnterRoom(this.mInstance, paramTXIAVCompletionCallback, paramTXCAVProtoParam.sdkAppid, paramTXCAVProtoParam.sdkVersion, paramTXCAVProtoParam.roomID, paramTXCAVProtoParam.authBits, paramTXCAVProtoParam.authBuffer, paramTXCAVProtoParam.userID, i);
  }
  
  public void exitRoom(final TXIAVCompletionCallback callback) {
    long l = this.mInstance;
    if (l == 0L)
      return; 
    nativeExitRoom(l, new TXIAVCompletionCallback() {
          public void onComplete(int param1Int) {
            callback.onComplete(param1Int);
          }
        });
  }
  
  public DownloadStats getDownloadStats() {
    long l = this.mInstance;
    return (l != 0L) ? nativeGetDownloadStats(l) : null;
  }
  
  public long[] getRoomMemberList() {
    long l = this.mInstance;
    return (l == 0L) ? null : nativeGetRoomMemberList(l);
  }
  
  public long[] getRoomVideoList() {
    long l = this.mInstance;
    return (l == 0L) ? null : nativeGetRoomVideoList(l);
  }
  
  public UploadStats getUploadStats() {
    long l = this.mInstance;
    return (l != 0L) ? nativeGetUploadStats(l) : null;
  }
  
  public native String nativeNAT64Compatable(String paramString, short paramShort);
  
  public void pushAAC(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
    long l = this.mInstance;
    if (l == 0L)
      return; 
    nativePushAAC(l, paramArrayOfbyte, paramInt1, paramInt2, 16, 3, paramLong);
  }
  
  public void pushNAL(TXSNALPacket paramTXSNALPacket) {
    long l = this.mInstance;
    if (l == 0L)
      return; 
    nativePushNAL(l, paramTXSNALPacket.nalData, paramTXSNALPacket.nalType, paramTXSNALPacket.gopIndex, paramTXSNALPacket.gopFrameIndex, paramTXSNALPacket.frameIndex, paramTXSNALPacket.refFremeIndex, paramTXSNALPacket.pts, paramTXSNALPacket.dts);
  }
  
  public void requestViews(ArrayList<TXSAVRoomView> paramArrayList, TXIAVCompletionCallback paramTXIAVCompletionCallback) {
    if (this.mInstance == 0L)
      return; 
    long[] arrayOfLong = new long[paramArrayList.size()];
    int[] arrayOfInt1 = new int[paramArrayList.size()];
    int[] arrayOfInt2 = new int[paramArrayList.size()];
    for (int i = 0; i < paramArrayList.size(); i++) {
      arrayOfLong[i] = ((TXSAVRoomView)paramArrayList.get(i)).tinyID;
      arrayOfInt1[i] = ((TXSAVRoomView)paramArrayList.get(i)).width;
      arrayOfInt2[i] = ((TXSAVRoomView)paramArrayList.get(i)).height;
    } 
    nativeRequestViews(this.mInstance, paramTXIAVCompletionCallback, arrayOfLong, arrayOfInt1, arrayOfInt2);
  }
  
  public void setListener(TXIAVListener paramTXIAVListener) {
    this.mListener = paramTXIAVListener;
  }
  
  public class DownloadStats {
    public long afterParseAudioBytes;
    
    public long afterParseVideoBytes;
    
    public long beforeParseAudioBytes;
    
    public long beforeParseVideoBytes;
    
    public long connTS;
    
    public long dnsTS;
    
    public long firstAudioTS;
    
    public long firstVideoTS;
    
    public String serverIP;
    
    public long startTS;
  }
  
  public class TXCAVProtoParam {
    public int authBits;
    
    public byte[] authBuffer;
    
    public long roomID;
    
    public int sdkAppid;
    
    public int sdkVersion;
    
    public long userID;
  }
  
  public static interface TXIAVCompletionCallback {
    void onComplete(int param1Int);
  }
  
  public static interface TXIAVListener {
    void onMemberChange(long param1Long, boolean param1Boolean);
    
    void onPullAudio(TXCAVProtocol.TXSAVProtoAudioPacket param1TXSAVProtoAudioPacket);
    
    void onPullNAL(TXCAVProtocol.TXSAVProtoNALPacket param1TXSAVProtoNALPacket);
    
    void onVideoStateChange(long param1Long, boolean param1Boolean);
    
    void sendNotifyEvent(int param1Int, String param1String);
  }
  
  public class TXSAVProtoAudioPacket extends a {
    public int roomID;
    
    public long tinyID;
  }
  
  public class TXSAVProtoNALPacket extends TXSNALPacket {
    public int roomID;
    
    public long tinyID;
  }
  
  public class TXSAVRoomView {
    public int height;
    
    public long tinyID;
    
    public int width;
  }
  
  public class UploadStats {
    public long audioCacheLen;
    
    public long audioDropCount;
    
    public long channelType;
    
    public long connTS;
    
    public long dnsTS;
    
    public long inAudioBytes;
    
    public long inVideoBytes;
    
    public long outAudioBytes;
    
    public long outVideoBytes;
    
    public String serverIP;
    
    public long startTS;
    
    public long videoCacheLen;
    
    public long videoDropCount;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\tencent\liteav\avprotocol\TXCAVProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */