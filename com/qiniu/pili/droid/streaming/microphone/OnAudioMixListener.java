package com.qiniu.pili.droid.streaming.microphone;

public interface OnAudioMixListener {
  void onProgress(long paramLong1, long paramLong2);
  
  void onStatusChanged(MixStatus paramMixStatus);
  
  public enum MixStatus {
    Finish;
    
    static {
      MixStatus mixStatus = new MixStatus("Finish", 0);
      Finish = mixStatus;
      $VALUES = new MixStatus[] { mixStatus };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\microphone\OnAudioMixListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */