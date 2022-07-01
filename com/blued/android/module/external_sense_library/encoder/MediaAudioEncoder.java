package com.blued.android.module.external_sense_library.encoder;

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import java.nio.ByteBuffer;

public class MediaAudioEncoder extends MediaEncoder {
  private static final int[] k = new int[] { 1, 0, 5, 7, 6 };
  
  private AudioThread j;
  
  protected void a() {
    this.j = null;
    super.a();
  }
  
  class AudioThread extends Thread {
    public void run() {
      Process.setThreadPriority(-19);
      try {
        int j = AudioRecord.getMinBufferSize(44100, 16, 2);
        int i = 25600;
        if (25600 < j)
          i = (j / 1024 + 1) * 1024 * 2; 
        int[] arrayOfInt = MediaAudioEncoder.b();
        int k = arrayOfInt.length;
        AudioRecord audioRecord = null;
        j = 0;
        while (true) {
          if (j < k) {
            int m = arrayOfInt[j];
            try {
              audioRecord = new AudioRecord(m, 44100, 16, 2, i);
              m = audioRecord.getState();
              if (m != 1)
                audioRecord = null; 
            } catch (Exception exception) {
              exception = null;
            } 
            if (exception == null) {
              j++;
              continue;
            } 
          } 
          if (exception != null)
            try {
              if (this.a.b) {
                null = ByteBuffer.allocateDirect(1024);
                exception.startRecording();
                try {
                  while (this.a.b && !this.a.c && !this.a.d) {
                    null.clear();
                    i = exception.read(null, 1024);
                    if (i > 0) {
                      null.position(i);
                      null.flip();
                      this.a.a(null, i, this.a.f());
                      this.a.c();
                    } 
                  } 
                  this.a.c();
                } finally {
                  exception.stop();
                } 
              } 
              return;
            } finally {
              exception.release();
            }  
          Log.e("MediaAudioEncoder", "failed to initialize AudioRecord");
          return;
        } 
      } catch (Exception exception) {
        Log.e("MediaAudioEncoder", "AudioThread#run", exception);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encoder\MediaAudioEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */