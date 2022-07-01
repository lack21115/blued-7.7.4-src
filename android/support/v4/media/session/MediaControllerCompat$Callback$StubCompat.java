package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import java.lang.ref.WeakReference;
import java.util.List;

class MediaControllerCompat$Callback$StubCompat extends IMediaControllerCallback$Stub {
  private final WeakReference mCallback;
  
  MediaControllerCompat$Callback$StubCompat(MediaControllerCompat$Callback paramMediaControllerCompat$Callback) {
    this.mCallback = new WeakReference<MediaControllerCompat$Callback>(paramMediaControllerCompat$Callback);
  }
  
  public final void onCaptioningEnabledChanged(boolean paramBoolean) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(11, Boolean.valueOf(paramBoolean), null); 
  }
  
  public final void onEvent(String paramString, Bundle paramBundle) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(1, paramString, paramBundle); 
  }
  
  public void onExtrasChanged(Bundle paramBundle) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(7, paramBundle, null); 
  }
  
  public void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(3, paramMediaMetadataCompat, null); 
  }
  
  public final void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(2, paramPlaybackStateCompat, null); 
  }
  
  public void onQueueChanged(List paramList) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(5, paramList, null); 
  }
  
  public void onQueueTitleChanged(CharSequence paramCharSequence) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(6, paramCharSequence, null); 
  }
  
  public final void onRepeatModeChanged(int paramInt) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(9, Integer.valueOf(paramInt), null); 
  }
  
  public void onSessionDestroyed() {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(8, null, null); 
  }
  
  public final void onSessionReady() {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(13, null, null); 
  }
  
  public final void onShuffleModeChanged(int paramInt) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null)
      mediaControllerCompat$Callback.postToHandler(12, Integer.valueOf(paramInt), null); 
  }
  
  public final void onShuffleModeChangedRemoved(boolean paramBoolean) {}
  
  public void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo) {
    MediaControllerCompat$Callback mediaControllerCompat$Callback = this.mCallback.get();
    if (mediaControllerCompat$Callback != null) {
      if (paramParcelableVolumeInfo != null) {
        int i = paramParcelableVolumeInfo.volumeType;
        i = paramParcelableVolumeInfo.audioStream;
        i = paramParcelableVolumeInfo.controlType;
        i = paramParcelableVolumeInfo.maxVolume;
        i = paramParcelableVolumeInfo.currentVolume;
        MediaControllerCompat$PlaybackInfo mediaControllerCompat$PlaybackInfo = new MediaControllerCompat$PlaybackInfo();
      } else {
        paramParcelableVolumeInfo = null;
      } 
      mediaControllerCompat$Callback.postToHandler(4, paramParcelableVolumeInfo, null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompat$Callback$StubCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */