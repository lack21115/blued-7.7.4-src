package org.chromium.media;

import android.media.AudioTrack;
import java.nio.ByteBuffer;

final class AudioTrackOutputStream$1 implements AudioTrackOutputStream$Callback {
  public final AudioTrack createAudioTrack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return new AudioTrack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final long getAddress(ByteBuffer paramByteBuffer) {
    return AudioTrackOutputStream.access$400(AudioTrackOutputStream.this, AudioTrackOutputStream.access$200(AudioTrackOutputStream.this), paramByteBuffer);
  }
  
  public final int getMinBufferSize(int paramInt1, int paramInt2, int paramInt3) {
    return AudioTrack.getMinBufferSize(paramInt1, paramInt2, paramInt3);
  }
  
  public final void onError() {
    AudioTrackOutputStream.access$500(AudioTrackOutputStream.this, AudioTrackOutputStream.access$200(AudioTrackOutputStream.this));
  }
  
  public final AudioTrackOutputStream$AudioBufferInfo onMoreData(ByteBuffer paramByteBuffer, long paramLong) {
    return AudioTrackOutputStream.access$300(AudioTrackOutputStream.this, AudioTrackOutputStream.access$200(AudioTrackOutputStream.this), paramByteBuffer, paramLong);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioTrackOutputStream$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */