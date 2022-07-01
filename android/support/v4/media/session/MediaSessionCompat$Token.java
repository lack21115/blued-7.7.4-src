package android.support.v4.media.session;

import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class MediaSessionCompat$Token implements Parcelable {
  public static final Parcelable.Creator CREATOR = new MediaSessionCompat$Token$1();
  
  private final Object mInner;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaSessionCompat$Token(Object paramObject) {
    this(paramObject, (byte)0);
  }
  
  private MediaSessionCompat$Token(Object paramObject, byte paramByte) {
    this.mInner = paramObject;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof MediaSessionCompat$Token))
      return false; 
    paramObject = paramObject;
    return (this.mInner == null) ? ((((MediaSessionCompat$Token)paramObject).mInner == null)) : ((((MediaSessionCompat$Token)paramObject).mInner == null) ? false : this.mInner.equals(((MediaSessionCompat$Token)paramObject).mInner));
  }
  
  public final int hashCode() {
    return (this.mInner == null) ? 0 : this.mInner.hashCode();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramParcel.writeParcelable((Parcelable)this.mInner, paramInt);
      return;
    } 
    paramParcel.writeStrongBinder((IBinder)this.mInner);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompat$Token.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */