package com.tencent.liteav.audio.impl.Record;

public interface c {
  void onAudioRecordError(int paramInt, String paramString);
  
  void onAudioRecordPCM(byte[] paramArrayOfbyte, int paramInt, long paramLong);
  
  void onAudioRecordStart();
  
  void onAudioRecordStop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\Record\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */