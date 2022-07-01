package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class NestedScrollView$SavedState extends View.BaseSavedState {
  public static final Parcelable.Creator CREATOR = new NestedScrollView$SavedState$1();
  
  public int scrollPosition;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  NestedScrollView$SavedState(Parcel paramParcel) {
    super(paramParcel);
    this.scrollPosition = paramParcel.readInt();
  }
  
  NestedScrollView$SavedState(Parcelable paramParcelable) {
    super(paramParcelable);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("HorizontalScrollView.SavedState{");
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" scrollPosition=");
    stringBuilder.append(this.scrollPosition);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.scrollPosition);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\NestedScrollView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */