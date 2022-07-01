package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.annotations.CalledByNative;

public class UnguessableToken implements Parcelable {
  public static final Parcelable.Creator CREATOR = new UnguessableToken$1();
  
  private final long mHigh;
  
  private final long mLow;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private UnguessableToken(long paramLong1, long paramLong2) {
    this.mHigh = paramLong1;
    this.mLow = paramLong2;
  }
  
  @CalledByNative
  private static UnguessableToken create(long paramLong1, long paramLong2) {
    return new UnguessableToken(paramLong1, paramLong2);
  }
  
  @CalledByNative
  private UnguessableToken parcelAndUnparcelForTesting() {
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    parcel.setDataPosition(0);
    UnguessableToken unguessableToken = (UnguessableToken)CREATOR.createFromParcel(parcel);
    parcel.recycle();
    return unguessableToken;
  }
  
  public int describeContents() {
    return 0;
  }
  
  @CalledByNative
  public long getHighForSerialization() {
    return this.mHigh;
  }
  
  @CalledByNative
  public long getLowForSerialization() {
    return this.mLow;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeLong(this.mHigh);
    paramParcel.writeLong(this.mLow);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\UnguessableToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */