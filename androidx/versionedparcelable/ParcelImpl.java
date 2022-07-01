package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelImpl implements Parcelable {
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() {
      public ParcelImpl createFromParcel(Parcel param1Parcel) {
        return new ParcelImpl(param1Parcel);
      }
      
      public ParcelImpl[] newArray(int param1Int) {
        return new ParcelImpl[param1Int];
      }
    };
  
  private final VersionedParcelable a;
  
  protected ParcelImpl(Parcel paramParcel) {
    this.a = (new VersionedParcelParcel(paramParcel)).i();
  }
  
  public ParcelImpl(VersionedParcelable paramVersionedParcelable) {
    this.a = paramVersionedParcelable;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public <T extends VersionedParcelable> T getVersionedParcel() {
    return (T)this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    (new VersionedParcelParcel(paramParcel)).a(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\versionedparcelable\ParcelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */