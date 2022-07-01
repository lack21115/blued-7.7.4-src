package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public final class zzbv extends zza implements IStreetViewPanoramaFragmentDelegate {
  zzbv(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
  }
  
  public final IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException {
    IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate;
    Parcel parcel = zza(1, zza());
    IBinder iBinder = parcel.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
      if (iInterface instanceof IStreetViewPanoramaDelegate) {
        iStreetViewPanoramaDelegate = (IStreetViewPanoramaDelegate)iInterface;
      } else {
        iStreetViewPanoramaDelegate = new zzbu((IBinder)iStreetViewPanoramaDelegate);
      } 
    } 
    parcel.recycle();
    return iStreetViewPanoramaDelegate;
  }
  
  public final void getStreetViewPanoramaAsync(zzbp paramzzbp) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, paramzzbp);
    zzb(12, parcel);
  }
  
  public final boolean isReady() throws RemoteException {
    Parcel parcel = zza(11, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzb(3, parcel);
  }
  
  public final IObjectWrapper onCreateView(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, Bundle paramBundle) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, (IInterface)paramIObjectWrapper1);
    zzc.zza(parcel2, (IInterface)paramIObjectWrapper2);
    zzc.zza(parcel2, (Parcelable)paramBundle);
    Parcel parcel1 = zza(4, parcel2);
    paramIObjectWrapper2 = IObjectWrapper.Stub.asInterface(parcel1.readStrongBinder());
    parcel1.recycle();
    return paramIObjectWrapper2;
  }
  
  public final void onDestroy() throws RemoteException {
    zzb(8, zza());
  }
  
  public final void onDestroyView() throws RemoteException {
    zzb(7, zza());
  }
  
  public final void onInflate(IObjectWrapper paramIObjectWrapper, StreetViewPanoramaOptions paramStreetViewPanoramaOptions, Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel, (Parcelable)paramStreetViewPanoramaOptions);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzb(2, parcel);
  }
  
  public final void onLowMemory() throws RemoteException {
    zzb(9, zza());
  }
  
  public final void onPause() throws RemoteException {
    zzb(6, zza());
  }
  
  public final void onResume() throws RemoteException {
    zzb(5, zza());
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramBundle);
    parcel = zza(10, parcel);
    if (parcel.readInt() != 0)
      paramBundle.readFromParcel(parcel); 
    parcel.recycle();
  }
  
  public final void onStart() throws RemoteException {
    zzb(13, zza());
  }
  
  public final void onStop() throws RemoteException {
    zzb(14, zza());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzbv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */