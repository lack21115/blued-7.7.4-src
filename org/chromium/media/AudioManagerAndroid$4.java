package org.chromium.media;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;

final class AudioManagerAndroid$4 extends ContentObserver {
  AudioManagerAndroid$4(Handler paramHandler) {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean) {
    super.onChange(paramBoolean);
    AudioManager audioManager = AudioManagerAndroid.access$900(AudioManagerAndroid.this);
    paramBoolean = false;
    int i = audioManager.getStreamVolume(0);
    AudioManagerAndroid audioManagerAndroid = AudioManagerAndroid.this;
    long l = AudioManagerAndroid.access$1000(AudioManagerAndroid.this);
    if (i == 0)
      paramBoolean = true; 
    AudioManagerAndroid.access$1100(audioManagerAndroid, l, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */