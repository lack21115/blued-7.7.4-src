package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
  protected final void onReceiveResult(int paramInt, Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader()); 
    if (paramInt == 0 && paramBundle != null) {
      if (!paramBundle.containsKey("media_item"))
        return; 
      paramBundle.getParcelable("media_item");
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$ItemReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */