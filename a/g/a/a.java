package a.g.a;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a implements Parcelable {
  public static final Parcelable.Creator<a> CREATOR;
  
  public static final a c = new a();
  
  public final Parcelable b;
  
  static {
    CREATOR = (Parcelable.Creator<a>)new b();
    throw new VerifyError("bad dex opcode");
  }
  
  public a(Parcel paramParcel, ClassLoader paramClassLoader) {
    throw new VerifyError("bad dex opcode");
  }
  
  public a(Parcelable paramParcelable) {
    if (paramParcelable != null) {
      if (paramParcelable != c);
      throw new VerifyError("bad dex opcode");
    } 
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static final class a extends a {
    public a() {
      super((a)null);
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public static final class b implements Parcelable.ClassLoaderCreator<a> {
    public b() {
      throw new VerifyError("bad dex opcode");
    }
    
    public a createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object createFromParcel(Parcel param1Parcel) {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      throw new VerifyError("bad dex opcode");
    }
    
    public Object[] newArray(int param1Int) {
      return (Object[])new a[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\g\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */