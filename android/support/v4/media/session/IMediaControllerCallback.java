package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaMetadataCompat;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
  void onCaptioningEnabledChanged(boolean paramBoolean);
  
  void onEvent(String paramString, Bundle paramBundle);
  
  void onExtrasChanged(Bundle paramBundle);
  
  void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat);
  
  void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat);
  
  void onQueueChanged(List paramList);
  
  void onQueueTitleChanged(CharSequence paramCharSequence);
  
  void onRepeatModeChanged(int paramInt);
  
  void onSessionDestroyed();
  
  void onSessionReady();
  
  void onShuffleModeChanged(int paramInt);
  
  void onShuffleModeChangedRemoved(boolean paramBoolean);
  
  void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */