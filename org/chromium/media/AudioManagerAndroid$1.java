package org.chromium.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class AudioManagerAndroid$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    switch (paramIntent.getIntExtra("state", 0)) {
      default:
        AudioManagerAndroid.access$500("Invalid state");
        break;
      case 1:
        synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[1] = true;
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[2] = false;
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[4] = false;
        } 
        break;
      case 0:
        synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[1] = false;
          if (AudioManagerAndroid.access$300(AudioManagerAndroid.this)) {
            AudioManagerAndroid.access$200(AudioManagerAndroid.this)[4] = true;
            AudioManagerAndroid.access$200(AudioManagerAndroid.this)[2] = false;
          } else if (AudioManagerAndroid.access$400$7074bab7()) {
            AudioManagerAndroid.access$200(AudioManagerAndroid.this)[2] = true;
            AudioManagerAndroid.access$200(AudioManagerAndroid.this)[4] = false;
          } 
        } 
        break;
    } 
    if (AudioManagerAndroid.access$600(AudioManagerAndroid.this))
      AudioManagerAndroid.access$700(AudioManagerAndroid.this); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */