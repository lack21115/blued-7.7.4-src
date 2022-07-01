package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaBrowserCompat$MediaItem implements Parcelable {
  public static final Parcelable.Creator CREATOR = new MediaBrowserCompat$MediaItem$1();
  
  private final MediaDescriptionCompat mDescription;
  
  private final int mFlags;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaBrowserCompat$MediaItem(Parcel paramParcel) {
    this.mFlags = paramParcel.readInt();
    this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("MediaItem{");
    stringBuilder.append("mFlags=");
    stringBuilder.append(this.mFlags);
    stringBuilder.append(", mDescription=");
    stringBuilder.append(this.mDescription);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.mFlags);
    this.mDescription.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$MediaItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */