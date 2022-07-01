package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

public abstract class MediaControllerCompat$Callback implements IBinder.DeathRecipient {
  private MediaControllerCompat$Callback$MessageHandler mHandler;
  
  boolean mHasExtraCallback;
  
  public MediaControllerCompat$Callback() {
    if (Build.VERSION.SDK_INT >= 21) {
      new MediaControllerCompatApi21$CallbackProxy(new MediaControllerCompat$Callback$StubApi21(this));
      return;
    } 
    new MediaControllerCompat$Callback$StubCompat(this);
  }
  
  final void postToHandler(int paramInt, Object paramObject, Bundle paramBundle) {
    if (this.mHandler != null) {
      paramObject = this.mHandler.obtainMessage(paramInt, paramObject);
      paramObject.setData(paramBundle);
      paramObject.sendToTarget();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */