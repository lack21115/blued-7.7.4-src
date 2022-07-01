package android.support.v4.media.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

final class IMediaControllerCallback$Stub$Proxy implements IMediaControllerCallback {
  private IBinder mRemote;
  
  IMediaControllerCallback$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void onCaptioningEnabledChanged(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void onEvent(String paramString, Bundle paramBundle) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      parcel.writeString(paramString);
      if (paramBundle != null) {
        parcel.writeInt(1);
        paramBundle.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onExtrasChanged(Bundle paramBundle) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      if (paramBundle != null) {
        parcel.writeInt(1);
        paramBundle.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(7, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onMetadataChanged(MediaMetadataCompat paramMediaMetadataCompat) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      if (paramMediaMetadataCompat != null) {
        parcel.writeInt(1);
        paramMediaMetadataCompat.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(4, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onPlaybackStateChanged(PlaybackStateCompat paramPlaybackStateCompat) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      if (paramPlaybackStateCompat != null) {
        parcel.writeInt(1);
        paramPlaybackStateCompat.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(3, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onQueueChanged(List paramList) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      parcel.writeTypedList(paramList);
      this.mRemote.transact(5, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onQueueTitleChanged(CharSequence paramCharSequence) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      if (paramCharSequence != null) {
        parcel.writeInt(1);
        TextUtils.writeToParcel(paramCharSequence, parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(6, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onRepeatModeChanged(int paramInt) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      parcel.writeInt(paramInt);
      this.mRemote.transact(9, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onSessionDestroyed() {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      this.mRemote.transact(2, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onSessionReady() {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      this.mRemote.transact(13, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onShuffleModeChanged(int paramInt) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      parcel.writeInt(paramInt);
      this.mRemote.transact(12, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final void onShuffleModeChangedRemoved(boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void onVolumeInfoChanged(ParcelableVolumeInfo paramParcelableVolumeInfo) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
      if (paramParcelableVolumeInfo != null) {
        parcel.writeInt(1);
        paramParcelableVolumeInfo.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(8, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\IMediaControllerCallback$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */