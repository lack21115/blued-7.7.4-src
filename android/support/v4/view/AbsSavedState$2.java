package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;

final class AbsSavedState$2 implements Parcelable.ClassLoaderCreator {
  private static AbsSavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader) {
    if (paramParcel.readParcelable(paramClassLoader) == null)
      return AbsSavedState.EMPTY_STATE; 
    throw new IllegalStateException("superState must be null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\AbsSavedState$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */