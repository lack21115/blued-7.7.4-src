package org.chromium.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class AudioManagerAndroid$3 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    switch (paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0)) {
      default:
        AudioManagerAndroid.access$500("Invalid state");
        return;
      case 2:
        return;
      case 1:
        AudioManagerAndroid.access$802(AudioManagerAndroid.this, 1);
        return;
      case 0:
        break;
    } 
    if (AudioManagerAndroid.access$800(AudioManagerAndroid.this) != 3 && AudioManagerAndroid.access$600(AudioManagerAndroid.this))
      AudioManagerAndroid.access$700(AudioManagerAndroid.this); 
    AudioManagerAndroid.access$802(AudioManagerAndroid.this, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */