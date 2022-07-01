package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zze;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;

public final class zzf extends zza implements zze {
  zzf(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.internal.ICreator");
  }
  
  public final IMapViewDelegate zza(IObjectWrapper paramIObjectWrapper, GoogleMapOptions paramGoogleMapOptions) throws RemoteException {
    IMapViewDelegate iMapViewDelegate;
    Parcel parcel2 = zza();
    zzc.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel2, (Parcelable)paramGoogleMapOptions);
    Parcel parcel1 = zza(3, parcel2);
    IBinder iBinder = parcel1.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
      if (iInterface instanceof IMapViewDelegate) {
        iMapViewDelegate = (IMapViewDelegate)iInterface;
      } else {
        iMapViewDelegate = new zzk((IBinder)iMapViewDelegate);
      } 
    } 
    parcel1.recycle();
    return iMapViewDelegate;
  }
  
  public final IStreetViewPanoramaViewDelegate zza(IObjectWrapper paramIObjectWrapper, StreetViewPanoramaOptions paramStreetViewPanoramaOptions) throws RemoteException {
    IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate;
    Parcel parcel2 = zza();
    zzc.zza(parcel2, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel2, (Parcelable)paramStreetViewPanoramaOptions);
    Parcel parcel1 = zza(7, parcel2);
    IBinder iBinder = parcel1.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
      if (iInterface instanceof IStreetViewPanoramaViewDelegate) {
        iStreetViewPanoramaViewDelegate = (IStreetViewPanoramaViewDelegate)iInterface;
      } else {
        iStreetViewPanoramaViewDelegate = new zzbw((IBinder)iStreetViewPanoramaViewDelegate);
      } 
    } 
    parcel1.recycle();
    return iStreetViewPanoramaViewDelegate;
  }
  
  public final void zza(IObjectWrapper paramIObjectWrapper, int paramInt) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeInt(paramInt);
    zzb(6, parcel);
  }
  
  public final IMapFragmentDelegate zzc(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    IMapFragmentDelegate iMapFragmentDelegate;
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel = zza(2, parcel);
    IBinder iBinder = parcel.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
      if (iInterface instanceof IMapFragmentDelegate) {
        iMapFragmentDelegate = (IMapFragmentDelegate)iInterface;
      } else {
        iMapFragmentDelegate = new zzj((IBinder)iMapFragmentDelegate);
      } 
    } 
    parcel.recycle();
    return iMapFragmentDelegate;
  }
  
  public final IStreetViewPanoramaFragmentDelegate zzd(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate;
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel = zza(8, parcel);
    IBinder iBinder = parcel.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate");
      if (iInterface instanceof IStreetViewPanoramaFragmentDelegate) {
        iStreetViewPanoramaFragmentDelegate = (IStreetViewPanoramaFragmentDelegate)iInterface;
      } else {
        iStreetViewPanoramaFragmentDelegate = new zzbv((IBinder)iStreetViewPanoramaFragmentDelegate);
      } 
    } 
    parcel.recycle();
    return iStreetViewPanoramaFragmentDelegate;
  }
  
  public final ICameraUpdateFactoryDelegate zze() throws RemoteException {
    ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate;
    Parcel parcel = zza(4, zza());
    IBinder iBinder = parcel.readStrongBinder();
    if (iBinder == null) {
      iBinder = null;
    } else {
      IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
      if (iInterface instanceof ICameraUpdateFactoryDelegate) {
        iCameraUpdateFactoryDelegate = (ICameraUpdateFactoryDelegate)iInterface;
      } else {
        iCameraUpdateFactoryDelegate = new zzb((IBinder)iCameraUpdateFactoryDelegate);
      } 
    } 
    parcel.recycle();
    return iCameraUpdateFactoryDelegate;
  }
  
  public final zze zzf() throws RemoteException {
    Parcel parcel = zza(5, zza());
    zze zze1 = com.google.android.gms.internal.maps.zzf.zzb(parcel.readStrongBinder());
    parcel.recycle();
    return zze1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */