package org.chromium.content.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

public abstract class IGpuProcessCallback$Stub extends Binder implements IGpuProcessCallback {
  public IGpuProcessCallback$Stub() {
    attachInterface(this, "org.chromium.content.common.IGpuProcessCallback");
  }
  
  public static IGpuProcessCallback asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("org.chromium.content.common.IGpuProcessCallback");
    return (iInterface != null && iInterface instanceof IGpuProcessCallback) ? (IGpuProcessCallback)iInterface : new IGpuProcessCallback$Stub$Proxy(paramIBinder);
  }
  
  public IBinder asBinder() {
    return (IBinder)this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) {
    if (paramInt1 != 1598968902) {
      SurfaceWrapper surfaceWrapper1;
      switch (paramInt1) {
        default:
          return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        case 2:
          paramParcel1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
          surfaceWrapper1 = getViewSurface(paramParcel1.readInt());
          paramParcel2.writeNoException();
          if (surfaceWrapper1 != null) {
            paramParcel2.writeInt(1);
            surfaceWrapper1.writeToParcel(paramParcel2, 1);
            return true;
          } 
          paramParcel2.writeInt(0);
          return true;
        case 1:
          break;
      } 
      surfaceWrapper1.enforceInterface("org.chromium.content.common.IGpuProcessCallback");
      paramInt1 = surfaceWrapper1.readInt();
      SurfaceWrapper surfaceWrapper2 = null;
      if (paramInt1 != 0) {
        UnguessableToken unguessableToken = (UnguessableToken)UnguessableToken.CREATOR.createFromParcel((Parcel)surfaceWrapper1);
      } else {
        paramParcel2 = null;
      } 
      if (surfaceWrapper1.readInt() != 0) {
        Surface surface = (Surface)Surface.CREATOR.createFromParcel((Parcel)surfaceWrapper1);
      } else {
        surfaceWrapper1 = surfaceWrapper2;
      } 
      forwardSurfaceForSurfaceRequest((UnguessableToken)paramParcel2, (Surface)surfaceWrapper1);
      return true;
    } 
    paramParcel2.writeString("org.chromium.content.common.IGpuProcessCallback");
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\common\IGpuProcessCallback$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */