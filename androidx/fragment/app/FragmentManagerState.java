package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

final class FragmentManagerState implements Parcelable {
  public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
      public FragmentManagerState createFromParcel(Parcel param1Parcel) {
        return new FragmentManagerState(param1Parcel);
      }
      
      public FragmentManagerState[] newArray(int param1Int) {
        return new FragmentManagerState[param1Int];
      }
    };
  
  ArrayList<FragmentState> a;
  
  ArrayList<String> b;
  
  BackStackState[] c;
  
  String d = null;
  
  int e;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel) {
    this.a = paramParcel.createTypedArrayList(FragmentState.CREATOR);
    this.b = paramParcel.createStringArrayList();
    this.c = (BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR);
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeTypedList(this.a);
    paramParcel.writeStringList(this.b);
    paramParcel.writeTypedArray((Parcelable[])this.c, paramInt);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\fragment\app\FragmentManagerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */