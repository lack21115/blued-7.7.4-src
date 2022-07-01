package android.support.v4.media.session;

import android.os.Build;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

final class MediaControllerCompat$Callback$StubApi21 implements MediaControllerCompatApi21$Callback {
  private final WeakReference mCallback;
  
  MediaControllerCompat$Callback$StubApi21(MediaControllerCompat$Callback paramMediaControllerCompat$Callback) {
    this.mCallback = new WeakReference<MediaControllerCompat$Callback>(paramMediaControllerCompat$Callback);
  }
  
  public final void onAudioInfoChanged$2e715812() {
    if ((MediaControllerCompat$Callback)this.mCallback.get() != null)
      new MediaControllerCompat$PlaybackInfo(); 
  }
  
  public final void onExtrasChanged$79e5e33f() {
    this.mCallback.get();
  }
  
  public final void onMetadataChanged(Object paramObject) {
    if ((MediaControllerCompat$Callback)this.mCallback.get() != null)
      MediaMetadataCompat.fromMediaMetadata(paramObject); 
  }
  
  public final void onPlaybackStateChanged(Object paramObject) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null && !mediaControllerCompat$Callback.mHasExtraCallback)
      PlaybackStateCompat.fromPlaybackState(paramObject); 
  }
  
  public final void onQueueChanged(List paramList) {
    if ((MediaControllerCompat$Callback)this.mCallback.get() != null)
      MediaSessionCompat$QueueItem.fromQueueItemList(paramList); 
  }
  
  public final void onQueueTitleChanged$76bab119() {
    this.mCallback.get();
  }
  
  public final void onSessionDestroyed() {
    this.mCallback.get();
  }
  
  public final void onSessionEvent$5dc9c75() {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null && mediaControllerCompat$Callback.mHasExtraCallback)
      int i = Build.VERSION.SDK_INT; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat$Callback$StubApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */