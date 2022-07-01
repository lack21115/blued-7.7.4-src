package com.qiniu.pili.droid.streaming;

import java.nio.ByteBuffer;

public interface PLScreenYUVCapturerListener {
  void onError(int paramInt);
  
  void onFrameAvailable(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3);
  
  void onPrepared();
  
  void onReady();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\PLScreenYUVCapturerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */