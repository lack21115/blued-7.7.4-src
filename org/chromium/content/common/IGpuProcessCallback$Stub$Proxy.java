package org.chromium.content.common;

import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

final class IGpuProcessCallback$Stub$Proxy implements IGpuProcessCallback {
  private IBinder mRemote;
  
  IGpuProcessCallback$Stub$Proxy(IBinder paramIBinder) {
    this.mRemote = paramIBinder;
  }
  
  public final IBinder asBinder() {
    return this.mRemote;
  }
  
  public final void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface) {
    Parcel parcel = Parcel.obtain();
    try {
      parcel.writeInterfaceToken("org.chromium.content.common.IGpuProcessCallback");
      if (paramUnguessableToken != null) {
        parcel.writeInt(1);
        paramUnguessableToken.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      if (paramSurface != null) {
        parcel.writeInt(1);
        paramSurface.writeToParcel(parcel, 0);
      } else {
        parcel.writeInt(0);
      } 
      this.mRemote.transact(1, parcel, null, 1);
      return;
    } finally {
      parcel.recycle();
    } 
  }
  
  public final SurfaceWrapper getViewSurface(int paramInt) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    try {
      SurfaceWrapper surfaceWrapper;
      parcel1.writeInterfaceToken("org.chromium.content.common.IGpuProcessCallback");
      parcel1.writeInt(paramInt);
      this.mRemote.transact(2, parcel1, parcel2, 0);
      parcel2.readException();
      if (parcel2.readInt() != 0) {
        surfaceWrapper = (SurfaceWrapper)SurfaceWrapper.CREATOR.createFromParcel(parcel2);
      } else {
        surfaceWrapper = null;
      } 
      return surfaceWrapper;
    } finally {
      parcel2.recycle();
      parcel1.recycle();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\common\IGpuProcessCallback$Stub$Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */