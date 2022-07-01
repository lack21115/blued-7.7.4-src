package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

public final class zzj extends zza implements zzh {
  zzj(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
  }
  
  public final LatLng getCenter() throws RemoteException {
    Parcel parcel = zza(4, zza());
    LatLng latLng = zzc.<LatLng>zza(parcel, LatLng.CREATOR);
    parcel.recycle();
    return latLng;
  }
  
  public final int getFillColor() throws RemoteException {
    Parcel parcel = zza(12, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final String getId() throws RemoteException {
    Parcel parcel = zza(2, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final double getRadius() throws RemoteException {
    Parcel parcel = zza(6, zza());
    double d = parcel.readDouble();
    parcel.recycle();
    return d;
  }
  
  public final int getStrokeColor() throws RemoteException {
    Parcel parcel = zza(10, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final List<PatternItem> getStrokePattern() throws RemoteException {
    Parcel parcel = zza(22, zza());
    ArrayList<PatternItem> arrayList = parcel.createTypedArrayList(PatternItem.CREATOR);
    parcel.recycle();
    return arrayList;
  }
  
  public final float getStrokeWidth() throws RemoteException {
    Parcel parcel = zza(8, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final float getZIndex() throws RemoteException {
    Parcel parcel = zza(14, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final boolean isClickable() throws RemoteException {
    Parcel parcel = zza(20, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isVisible() throws RemoteException {
    Parcel parcel = zza(16, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void remove() throws RemoteException {
    zzb(1, zza());
  }
  
  public final void setCenter(LatLng paramLatLng) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramLatLng);
    zzb(3, parcel);
  }
  
  public final void setClickable(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(19, parcel);
  }
  
  public final void setFillColor(int paramInt) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    zzb(11, parcel);
  }
  
  public final void setRadius(double paramDouble) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeDouble(paramDouble);
    zzb(5, parcel);
  }
  
  public final void setStrokeColor(int paramInt) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    zzb(9, parcel);
  }
  
  public final void setStrokePattern(List<PatternItem> paramList) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeTypedList(paramList);
    zzb(21, parcel);
  }
  
  public final void setStrokeWidth(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(7, parcel);
  }
  
  public final void setVisible(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(15, parcel);
  }
  
  public final void setZIndex(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(13, parcel);
  }
  
  public final boolean zzb(zzh paramzzh) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzh);
    Parcel parcel1 = zza(17, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(23, parcel);
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(18, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final IObjectWrapper zzk() throws RemoteException {
    Parcel parcel = zza(24, zza());
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */