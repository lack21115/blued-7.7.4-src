package com.qiniu.android.storage;

public interface Recorder {
  void del(String paramString);
  
  byte[] get(String paramString);
  
  String getFileName();
  
  void set(String paramString, byte[] paramArrayOfbyte);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\Recorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */