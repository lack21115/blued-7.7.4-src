package org.chromium.media;

import android.media.AudioTrack;
import java.nio.ByteBuffer;

interface AudioTrackOutputStream$Callback {
  AudioTrack createAudioTrack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  long getAddress(ByteBuffer paramByteBuffer);
  
  int getMinBufferSize(int paramInt1, int paramInt2, int paramInt3);
  
  void onError();
  
  AudioTrackOutputStream$AudioBufferInfo onMoreData(ByteBuffer paramByteBuffer, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioTrackOutputStream$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */