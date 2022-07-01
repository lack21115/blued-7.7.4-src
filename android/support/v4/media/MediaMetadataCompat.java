package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;

public final class MediaMetadataCompat implements Parcelable {
  public static final Parcelable.Creator CREATOR;
  
  private static ArrayMap METADATA_KEYS_TYPE = new ArrayMap();
  
  private Bundle mBundle;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaMetadataCompat(Parcel paramParcel) {
    this.mBundle = paramParcel.readBundle();
  }
  
  public static MediaMetadataCompat fromMediaMetadata(Object paramObject) {
    if (paramObject != null && Build.VERSION.SDK_INT >= 21) {
      Parcel parcel = Parcel.obtain();
      ((MediaMetadata)paramObject).writeToParcel(parcel, 0);
      parcel.setDataPosition(0);
      paramObject = CREATOR.createFromParcel(parcel);
      parcel.recycle();
      return (MediaMetadataCompat)paramObject;
    } 
    return null;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeBundle(this.mBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaMetadataCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */