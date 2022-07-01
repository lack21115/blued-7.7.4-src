package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.app.BundleCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver extends ResultReceiver {
  private WeakReference mMediaControllerImpl;
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle) {
    MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.mMediaControllerImpl.get();
    if (mediaControllerCompat$MediaControllerImplApi21 != null) {
      IBinder iBinder;
      if (paramBundle == null)
        return; 
      if (Build.VERSION.SDK_INT >= 18) {
        iBinder = paramBundle.getBinder("android.support.v4.media.session.EXTRA_BINDER");
      } else {
        iBinder = BundleCompat.BundleCompatBaseImpl.getBinder((Bundle)iBinder, "android.support.v4.media.session.EXTRA_BINDER");
      } 
      mediaControllerCompat$MediaControllerImplApi21.mExtraBinder = IMediaSession$Stub.asInterface(iBinder);
      if (mediaControllerCompat$MediaControllerImplApi21.mExtraBinder != null)
        synchronized (mediaControllerCompat$MediaControllerImplApi21.mPendingCallbacks) {
          Iterator<MediaControllerCompat$Callback> iterator = mediaControllerCompat$MediaControllerImplApi21.mPendingCallbacks.iterator();
          while (true) {
            if (iterator.hasNext()) {
              MediaControllerCompat$Callback mediaControllerCompat$Callback = iterator.next();
              MediaControllerCompat$MediaControllerImplApi21$ExtraCallback mediaControllerCompat$MediaControllerImplApi21$ExtraCallback = new MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(mediaControllerCompat$Callback);
              mediaControllerCompat$MediaControllerImplApi21.mCallbackMap.put(mediaControllerCompat$Callback, mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
              mediaControllerCompat$Callback.mHasExtraCallback = true;
              try {
                mediaControllerCompat$MediaControllerImplApi21.mExtraBinder.registerCallbackListener(mediaControllerCompat$MediaControllerImplApi21$ExtraCallback);
                continue;
              } catch (RemoteException remoteException) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", (Throwable)remoteException);
              } 
            } else {
              break;
            } 
            mediaControllerCompat$MediaControllerImplApi21.mPendingCallbacks.clear();
            return;
          } 
          mediaControllerCompat$MediaControllerImplApi21.mPendingCallbacks.clear();
          return;
        }  
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */