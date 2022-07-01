package org.chromium.media;

final class AudioTrackOutputStream$WorkerThread extends Thread {
  volatile boolean mDone = false;
  
  public final void run() {
    while (!this.mDone) {
      int i = AudioTrackOutputStream.access$000(AudioTrackOutputStream.this);
      if (i >= 0)
        if (i <= 0)
          AudioTrackOutputStream.access$100(AudioTrackOutputStream.this);  
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioTrackOutputStream$WorkerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */