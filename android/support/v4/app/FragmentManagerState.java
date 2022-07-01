package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

final class FragmentManagerState implements Parcelable {
  public static final Parcelable.Creator CREATOR = new FragmentManagerState$1();
  
  FragmentState[] mActive;
  
  int[] mAdded;
  
  BackStackState[] mBackStack;
  
  int mNextFragmentIndex;
  
  int mPrimaryNavActiveIndex = -1;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel) {
    this.mActive = (FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR);
    this.mAdded = paramParcel.createIntArray();
    this.mBackStack = (BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR);
    this.mPrimaryNavActiveIndex = paramParcel.readInt();
    this.mNextFragmentIndex = paramParcel.readInt();
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedArray((Parcelable[])this.mActive, paramInt);
    paramParcel.writeIntArray(this.mAdded);
    paramParcel.writeTypedArray((Parcelable[])this.mBackStack, paramInt);
    paramParcel.writeInt(this.mPrimaryNavActiveIndex);
    paramParcel.writeInt(this.mNextFragmentIndex);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentManagerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */