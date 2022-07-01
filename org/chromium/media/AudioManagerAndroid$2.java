package org.chromium.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class AudioManagerAndroid$2 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    switch (paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0)) {
      default:
        AudioManagerAndroid.access$500("Invalid state");
        return;
      case 3:
        return;
      case 2:
        synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
          AudioManagerAndroid.access$200(AudioManagerAndroid.this)[3] = true;
          return;
        } 
      case 1:
        return;
      case 0:
        break;
    } 
    synchronized (AudioManagerAndroid.access$100(AudioManagerAndroid.this)) {
      AudioManagerAndroid.access$200(AudioManagerAndroid.this)[3] = false;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */