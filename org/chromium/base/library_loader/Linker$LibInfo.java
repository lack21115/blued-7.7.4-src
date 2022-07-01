package org.chromium.base.library_loader;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;
import org.chromium.base.Log;
import org.chromium.base.annotations.AccessedByNative;

public class Linker$LibInfo implements Parcelable {
  public static final Parcelable.Creator CREATOR = new Linker$LibInfo$1();
  
  @AccessedByNative
  public long mLoadAddress;
  
  @AccessedByNative
  public long mLoadSize;
  
  @AccessedByNative
  public int mRelroFd = -1;
  
  @AccessedByNative
  public long mRelroSize;
  
  @AccessedByNative
  public long mRelroStart;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  Linker$LibInfo() {}
  
  Linker$LibInfo(Parcel paramParcel) {
    this.mLoadAddress = paramParcel.readLong();
    this.mLoadSize = paramParcel.readLong();
    this.mRelroStart = paramParcel.readLong();
    this.mRelroSize = paramParcel.readLong();
    ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel);
    if (parcelFileDescriptor != null)
      this.mRelroFd = parcelFileDescriptor.detachFd(); 
  }
  
  public int describeContents() {
    return 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    if (this.mRelroFd >= 0) {
      paramParcel.writeLong(this.mLoadAddress);
      paramParcel.writeLong(this.mLoadSize);
      paramParcel.writeLong(this.mRelroStart);
      paramParcel.writeLong(this.mRelroSize);
      try {
        ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromFd(this.mRelroFd);
        parcelFileDescriptor.writeToParcel(paramParcel, 0);
        parcelFileDescriptor.close();
        return;
      } catch (IOException iOException) {
        Log.e("LibraryLoader", "Can't write LibInfo file descriptor to parcel", new Object[] { iOException });
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\library_loader\Linker$LibInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */