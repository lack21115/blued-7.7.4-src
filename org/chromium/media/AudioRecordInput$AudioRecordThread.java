package org.chromium.media;

import android.os.Process;
import org.chromium.base.Log;

final class AudioRecordInput$AudioRecordThread extends Thread {
  volatile boolean mKeepAlive = true;
  
  private AudioRecordInput$AudioRecordThread() {}
  
  public final void run() {
    Process.setThreadPriority(-19);
    try {
      AudioRecordInput.access$000(AudioRecordInput.this).startRecording();
      while (this.mKeepAlive) {
        int i = AudioRecordInput.access$000(AudioRecordInput.this).read(AudioRecordInput.access$100(AudioRecordInput.this), AudioRecordInput.access$100(AudioRecordInput.this).capacity());
        if (i > 0) {
          AudioRecordInput.access$300(AudioRecordInput.this, AudioRecordInput.access$200(AudioRecordInput.this), i, 100);
          continue;
        } 
        Log.e("cr.media", "read failed: %d", new Object[] { Integer.valueOf(i) });
        if (i == -3)
          this.mKeepAlive = false; 
      } 
      try {
        AudioRecordInput.access$000(AudioRecordInput.this).stop();
        return;
      } catch (IllegalStateException illegalStateException) {
        Log.e("cr.media", "stop failed", new Object[] { illegalStateException });
        return;
      } 
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr.media", "startRecording failed", new Object[] { illegalStateException });
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioRecordInput$AudioRecordThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */