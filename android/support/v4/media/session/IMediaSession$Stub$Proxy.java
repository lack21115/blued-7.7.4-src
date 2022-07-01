package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

final class IMediaSession$Stub$Proxy implements IMediaSession {
  private IBinder mRemote;
  
  IMediaSession$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramMediaDescriptionCompat != null) {
        parcel1.writeInt(1);
        paramMediaDescriptionCompat.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(41, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void addQueueItemAt(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramMediaDescriptionCompat != null) {
        parcel1.writeInt(1);
        paramMediaDescriptionCompat.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      parcel1.writeInt(paramInt);
      this.mRemote.transact(42, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void adjustVolume(int paramInt1, int paramInt2, String paramString) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeInt(paramInt1);
      parcel1.writeInt(paramInt2);
      parcel1.writeString(paramString);
      this.mRemote.transact(11, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void fastForward() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(22, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final Bundle getExtras() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      Bundle bundle;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(31, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
      } else {
        bundle = null;
      } 
      return bundle;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final long getFlags() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(9, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readLong();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final PendingIntent getLaunchPendingIntent() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      PendingIntent pendingIntent;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(8, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2);
      } else {
        pendingIntent = null;
      } 
      return pendingIntent;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final MediaMetadataCompat getMetadata() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      MediaMetadataCompat mediaMetadataCompat;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(27, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2);
      } else {
        mediaMetadataCompat = null;
      } 
      return mediaMetadataCompat;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final String getPackageName() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(6, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readString();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final PlaybackStateCompat getPlaybackState() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      PlaybackStateCompat playbackStateCompat;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(28, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2);
      } else {
        playbackStateCompat = null;
      } 
      return playbackStateCompat;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final List getQueue() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(29, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR);
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final CharSequence getQueueTitle() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      CharSequence charSequence;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(30, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
      } else {
        charSequence = null;
      } 
      return charSequence;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final int getRatingType() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(32, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readInt();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final int getRepeatMode() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(37, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readInt();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final int getShuffleMode() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(47, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readInt();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final String getTag() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(7, parcel1, parcel2, 0);
      parcel2.readException();
      return parcel2.readString();
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final ParcelableVolumeInfo getVolumeAttributes() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      ParcelableVolumeInfo parcelableVolumeInfo;
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(10, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2);
      } else {
        parcelableVolumeInfo = null;
      } 
      return parcelableVolumeInfo;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final boolean isCaptioningEnabled() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      IBinder iBinder = this.mRemote;
      boolean bool = false;
      iBinder.transact(45, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i != 0)
        bool = true; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final boolean isShuffleModeEnabledRemoved() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      IBinder iBinder = this.mRemote;
      boolean bool = false;
      iBinder.transact(38, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i != 0)
        bool = true; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final boolean isTransportControlEnabled() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      IBinder iBinder = this.mRemote;
      boolean bool = false;
      iBinder.transact(5, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i != 0)
        bool = true; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void next() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(20, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void pause() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(18, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void play() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(13, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void playFromMediaId(String paramString, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(14, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void playFromSearch(String paramString, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(15, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void playFromUri(Uri paramUri, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramUri != null) {
        parcel1.writeInt(1);
        paramUri.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(16, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void prepare() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(33, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void prepareFromMediaId(String paramString, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(34, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void prepareFromSearch(String paramString, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(35, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void prepareFromUri(Uri paramUri, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramUri != null) {
        parcel1.writeInt(1);
        paramUri.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(36, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void previous() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(21, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void rate(RatingCompat paramRatingCompat) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramRatingCompat != null) {
        parcel1.writeInt(1);
        paramRatingCompat.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(25, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void rateWithExtras(RatingCompat paramRatingCompat, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramRatingCompat != null) {
        parcel1.writeInt(1);
        paramRatingCompat.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(51, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramIMediaControllerCallback != null) {
        IBinder iBinder = paramIMediaControllerCallback.asBinder();
      } else {
        paramIMediaControllerCallback = null;
      } 
      parcel1.writeStrongBinder((IBinder)paramIMediaControllerCallback);
      this.mRemote.transact(3, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramMediaDescriptionCompat != null) {
        parcel1.writeInt(1);
        paramMediaDescriptionCompat.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(43, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void removeQueueItemAt(int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeInt(paramInt);
      this.mRemote.transact(44, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void rewind() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(23, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void seekTo(long paramLong) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeLong(paramLong);
      this.mRemote.transact(24, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat$ResultReceiverWrapper paramMediaSessionCompat$ResultReceiverWrapper) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      if (paramMediaSessionCompat$ResultReceiverWrapper != null) {
        parcel1.writeInt(1);
        paramMediaSessionCompat$ResultReceiverWrapper.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(1, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void sendCustomAction(String paramString, Bundle paramBundle) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeString(paramString);
      if (paramBundle != null) {
        parcel1.writeInt(1);
        paramBundle.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(26, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final boolean sendMediaButton(KeyEvent paramKeyEvent) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      boolean bool = true;
      if (paramKeyEvent != null) {
        parcel1.writeInt(1);
        paramKeyEvent.writeToParcel(parcel1, 0);
      } else {
        parcel1.writeInt(0);
      } 
      this.mRemote.transact(2, parcel1, parcel2, 0);
      parcel2.readException();
      int i = parcel2.readInt();
      if (i == 0)
        bool = false; 
      return bool;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void setCaptioningEnabled(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setRepeatMode(int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeInt(paramInt);
      this.mRemote.transact(39, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void setShuffleMode(int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeInt(paramInt);
      this.mRemote.transact(48, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void setShuffleModeEnabledRemoved(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setVolumeTo(int paramInt1, int paramInt2, String paramString) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeInt(paramInt1);
      parcel1.writeInt(paramInt2);
      parcel1.writeString(paramString);
      this.mRemote.transact(12, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void skipToQueueItem(long paramLong) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      parcel1.writeLong(paramLong);
      this.mRemote.transact(17, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void stop() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      this.mRemote.transact(19, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
  
  public final void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      parcel1.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
      if (paramIMediaControllerCallback != null) {
        IBinder iBinder = paramIMediaControllerCallback.asBinder();
      } else {
        paramIMediaControllerCallback = null;
      } 
      parcel1.writeStrongBinder((IBinder)paramIMediaControllerCallback);
      this.mRemote.transact(4, parcel1, parcel2, 0);
      parcel2.readException();
      return;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\IMediaSession$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */