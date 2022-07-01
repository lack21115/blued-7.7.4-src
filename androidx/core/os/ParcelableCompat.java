package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class ParcelableCompat {
  @Deprecated
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks) {
    return (Parcelable.Creator<T>)new ParcelableCompatCreatorHoneycombMR2<T>(paramParcelableCompatCreatorCallbacks);
  }
  
  static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> a;
    
    ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> param1ParcelableCompatCreatorCallbacks) {
      this.a = param1ParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel param1Parcel) {
      return this.a.createFromParcel(param1Parcel, null);
    }
    
    public T createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return this.a.createFromParcel(param1Parcel, param1ClassLoader);
    }
    
    public T[] newArray(int param1Int) {
      return this.a.newArray(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\os\ParcelableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */