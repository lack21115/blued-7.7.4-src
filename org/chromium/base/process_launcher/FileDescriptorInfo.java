package org.chromium.base.process_launcher;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
public final class FileDescriptorInfo implements Parcelable {
  public static final Parcelable.Creator CREATOR = new FileDescriptorInfo$1();
  
  public final ParcelFileDescriptor fd;
  
  public final int id;
  
  public final long offset;
  
  public final long size;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public FileDescriptorInfo(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2) {
    this.id = paramInt;
    this.fd = paramParcelFileDescriptor;
    this.offset = paramLong1;
    this.size = paramLong2;
  }
  
  FileDescriptorInfo(Parcel paramParcel) {
    this.id = paramParcel.readInt();
    this.fd = (ParcelFileDescriptor)paramParcel.readParcelable(ParcelFileDescriptor.class.getClassLoader());
    this.offset = paramParcel.readLong();
    this.size = paramParcel.readLong();
  }
  
  public final int describeContents() {
    return 1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.id);
    paramParcel.writeParcelable((Parcelable)this.fd, 1);
    paramParcel.writeLong(this.offset);
    paramParcel.writeLong(this.size);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\FileDescriptorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */