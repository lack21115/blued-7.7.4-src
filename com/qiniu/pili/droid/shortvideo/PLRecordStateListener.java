package com.qiniu.pili.droid.shortvideo;

public interface PLRecordStateListener {
  void onDurationTooShort();
  
  void onError(int paramInt);
  
  void onReady();
  
  void onRecordCompleted();
  
  void onRecordStarted();
  
  void onRecordStopped();
  
  void onSectionDecreased(long paramLong1, long paramLong2, int paramInt);
  
  void onSectionIncreased(long paramLong1, long paramLong2, int paramInt);
  
  void onSectionRecording(long paramLong1, long paramLong2, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLRecordStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */