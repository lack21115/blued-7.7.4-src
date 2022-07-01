package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

final class MediaSessionCompat$ResultReceiverWrapper implements Parcelable {
  public static final Parcelable.Creator CREATOR = new MediaSessionCompat$ResultReceiverWrapper$1();
  
  private ResultReceiver mResultReceiver;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  MediaSessionCompat$ResultReceiverWrapper(Parcel paramParcel) {
    this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel);
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    this.mResultReceiver.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\session\MediaSessionCompat$ResultReceiverWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */