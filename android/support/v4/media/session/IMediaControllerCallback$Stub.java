package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;

public abstract class IMediaControllerCallback$Stub extends Binder implements IMediaControllerCallback {
  public IMediaControllerCallback$Stub() {
    attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
  }
  
  public static IMediaControllerCallback asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
    return (iInterface != null && iInterface instanceof IMediaControllerCallback) ? (IMediaControllerCallback)iInterface : new IMediaControllerCallback$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    String str;
    if (paramInt1 != 1598968902) {
      boolean bool2 = false;
      boolean bool1 = false;
      Parcel parcel3 = null;
      Parcel parcel4 = null;
      Parcel parcel5 = null;
      Parcel parcel6 = null;
      Parcel parcel1 = null;
      Parcel parcel2 = null;
      switch (paramInt1) {
        default:
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 13:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onSessionReady();
          return true;
        case 12:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onShuffleModeChanged(paramParcel1.readInt());
          return true;
        case 11:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0)
            bool1 = true; 
          onCaptioningEnabledChanged(bool1);
          return true;
        case 10:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            bool1 = true;
          } else {
            bool1 = bool2;
          } 
          onShuffleModeChangedRemoved(bool1);
          return true;
        case 9:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onRepeatModeChanged(paramParcel1.readInt());
          return true;
        case 8:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            ParcelableVolumeInfo parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(paramParcel1);
          } else {
            paramParcel1 = parcel2;
          } 
          onVolumeInfoChanged((ParcelableVolumeInfo)paramParcel1);
          return true;
        case 7:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          } else {
            paramParcel1 = parcel3;
          } 
          onExtrasChanged((Bundle)paramParcel1);
          return true;
        case 6:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            CharSequence charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel1);
          } else {
            paramParcel1 = parcel4;
          } 
          onQueueTitleChanged((CharSequence)paramParcel1);
          return true;
        case 5:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onQueueChanged(paramParcel1.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
          return true;
        case 4:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(paramParcel1);
          } else {
            paramParcel1 = parcel5;
          } 
          onMetadataChanged((MediaMetadataCompat)paramParcel1);
          return true;
        case 3:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          if (paramParcel1.readInt() != 0) {
            PlaybackStateCompat playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(paramParcel1);
          } else {
            paramParcel1 = parcel6;
          } 
          onPlaybackStateChanged((PlaybackStateCompat)paramParcel1);
          return true;
        case 2:
          paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
          onSessionDestroyed();
          return true;
        case 1:
          break;
      } 
      paramParcel1.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
      str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      } else {
        paramParcel1 = parcel1;
      } 
      onEvent(str, (Bundle)paramParcel1);
      return true;
    } 
    str.writeString("android.support.v4.media.session.IMediaControllerCallback");
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */