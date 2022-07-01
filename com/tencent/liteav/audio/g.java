package com.tencent.liteav.audio;

public interface g {
  void onRecordEncData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  void onRecordError(int paramInt, String paramString);
  
  void onRecordPcmData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  void onRecordRawPcmData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */