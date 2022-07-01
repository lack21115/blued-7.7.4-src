package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
  public static final Parcelable.Creator CREATOR = new ParcelableVolumeInfo$1();
  
  public int audioStream;
  
  public int controlType;
  
  public int currentVolume;
  
  public int maxVolume;
  
  public int volumeType;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ParcelableVolumeInfo(Parcel paramParcel) {
    this.volumeType = paramParcel.readInt();
    this.controlType = paramParcel.readInt();
    this.maxVolume = paramParcel.readInt();
    this.currentVolume = paramParcel.readInt();
    this.audioStream = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.volumeType);
    paramParcel.writeInt(this.controlType);
    paramParcel.writeInt(this.maxVolume);
    paramParcel.writeInt(this.currentVolume);
    paramParcel.writeInt(this.audioStream);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\ParcelableVolumeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */