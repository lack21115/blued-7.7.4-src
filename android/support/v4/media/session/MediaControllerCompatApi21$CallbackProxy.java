package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class MediaControllerCompatApi21$CallbackProxy extends MediaController.Callback {
  private MediaControllerCompatApi21$Callback mCallback;
  
  public MediaControllerCompatApi21$CallbackProxy(MediaControllerCompatApi21$Callback paramMediaControllerCompatApi21$Callback) {
    this.mCallback = paramMediaControllerCompatApi21$Callback;
  }
  
  public final void onAudioInfoChanged(MediaController.PlaybackInfo paramPlaybackInfo) {
    MediaControllerCompatApi21$Callback mediaControllerCompatApi21$Callback = this.mCallback;
    paramPlaybackInfo.getPlaybackType();
    AudioAttributes audioAttributes = paramPlaybackInfo.getAudioAttributes();
    if ((audioAttributes.getFlags() & 0x1) != 1 && (audioAttributes.getFlags() & 0x4) != 4)
      audioAttributes.getUsage(); 
    paramPlaybackInfo.getVolumeControl();
    paramPlaybackInfo.getMaxVolume();
    paramPlaybackInfo.getCurrentVolume();
    mediaControllerCompatApi21$Callback.onAudioInfoChanged$2e715812();
  }
  
  public final void onExtrasChanged(Bundle paramBundle) {
    this.mCallback.onExtrasChanged$79e5e33f();
  }
  
  public final void onMetadataChanged(MediaMetadata paramMediaMetadata) {
    this.mCallback.onMetadataChanged(paramMediaMetadata);
  }
  
  public final void onPlaybackStateChanged(PlaybackState paramPlaybackState) {
    this.mCallback.onPlaybackStateChanged(paramPlaybackState);
  }
  
  public final void onQueueChanged(List paramList) {
    this.mCallback.onQueueChanged(paramList);
  }
  
  public final void onQueueTitleChanged(CharSequence paramCharSequence) {
    this.mCallback.onQueueTitleChanged$76bab119();
  }
  
  public final void onSessionDestroyed() {
    this.mCallback.onSessionDestroyed();
  }
  
  public final void onSessionEvent(String paramString, Bundle paramBundle) {
    this.mCallback.onSessionEvent$5dc9c75();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompatApi21$CallbackProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */