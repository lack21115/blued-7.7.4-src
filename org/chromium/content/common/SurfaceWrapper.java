package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;

public class SurfaceWrapper implements Parcelable {
  public static final Parcelable.Creator CREATOR = new SurfaceWrapper$1();
  
  public final Surface mSurface;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SurfaceWrapper(Surface paramSurface) {
    this.mSurface = paramSurface;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    this.mSurface.writeToParcel(paramParcel, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\common\SurfaceWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */