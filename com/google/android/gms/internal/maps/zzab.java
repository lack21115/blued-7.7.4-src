package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

public final class zzab extends zza implements zzz {
  zzab(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
  }
  
  public final int getColor() throws RemoteException {
    Parcel parcel = zza(8, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final Cap getEndCap() throws RemoteException {
    Parcel parcel = zza(22, zza());
    Cap cap = zzc.<Cap>zza(parcel, Cap.CREATOR);
    parcel.recycle();
    return cap;
  }
  
  public final String getId() throws RemoteException {
    Parcel parcel = zza(2, zza());
    String str = parcel.readString();
    parcel.recycle();
    return str;
  }
  
  public final int getJointType() throws RemoteException {
    Parcel parcel = zza(24, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final List<PatternItem> getPattern() throws RemoteException {
    Parcel parcel = zza(26, zza());
    ArrayList<PatternItem> arrayList = parcel.createTypedArrayList(PatternItem.CREATOR);
    parcel.recycle();
    return arrayList;
  }
  
  public final List<LatLng> getPoints() throws RemoteException {
    Parcel parcel = zza(4, zza());
    ArrayList<LatLng> arrayList = parcel.createTypedArrayList(LatLng.CREATOR);
    parcel.recycle();
    return arrayList;
  }
  
  public final Cap getStartCap() throws RemoteException {
    Parcel parcel = zza(20, zza());
    Cap cap = zzc.<Cap>zza(parcel, Cap.CREATOR);
    parcel.recycle();
    return cap;
  }
  
  public final float getWidth() throws RemoteException {
    Parcel parcel = zza(6, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final float getZIndex() throws RemoteException {
    Parcel parcel = zza(10, zza());
    float f = parcel.readFloat();
    parcel.recycle();
    return f;
  }
  
  public final boolean isClickable() throws RemoteException {
    Parcel parcel = zza(18, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isGeodesic() throws RemoteException {
    Parcel parcel = zza(14, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final boolean isVisible() throws RemoteException {
    Parcel parcel = zza(12, zza());
    boolean bool = zzc.zza(parcel);
    parcel.recycle();
    return bool;
  }
  
  public final void remove() throws RemoteException {
    zzb(1, zza());
  }
  
  public final void setClickable(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(17, parcel);
  }
  
  public final void setColor(int paramInt) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    zzb(7, parcel);
  }
  
  public final void setEndCap(Cap paramCap) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramCap);
    zzb(21, parcel);
  }
  
  public final void setGeodesic(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(13, parcel);
  }
  
  public final void setJointType(int paramInt) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeInt(paramInt);
    zzb(23, parcel);
  }
  
  public final void setPattern(List<PatternItem> paramList) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeTypedList(paramList);
    zzb(25, parcel);
  }
  
  public final void setPoints(List<LatLng> paramList) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeTypedList(paramList);
    zzb(3, parcel);
  }
  
  public final void setStartCap(Cap paramCap) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (Parcelable)paramCap);
    zzb(19, parcel);
  }
  
  public final void setVisible(boolean paramBoolean) throws RemoteException {
    Parcel parcel = zza();
    zzc.writeBoolean(parcel, paramBoolean);
    zzb(11, parcel);
  }
  
  public final void setWidth(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(5, parcel);
  }
  
  public final void setZIndex(float paramFloat) throws RemoteException {
    Parcel parcel = zza();
    parcel.writeFloat(paramFloat);
    zzb(9, parcel);
  }
  
  public final boolean zzb(zzz paramzzz) throws RemoteException {
    Parcel parcel2 = zza();
    zzc.zza(parcel2, paramzzz);
    Parcel parcel1 = zza(15, parcel2);
    boolean bool = zzc.zza(parcel1);
    parcel1.recycle();
    return bool;
  }
  
  public final void zze(IObjectWrapper paramIObjectWrapper) throws RemoteException {
    Parcel parcel = zza();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzb(27, parcel);
  }
  
  public final int zzj() throws RemoteException {
    Parcel parcel = zza(16, zza());
    int i = parcel.readInt();
    parcel.recycle();
    return i;
  }
  
  public final IObjectWrapper zzk() throws RemoteException {
    Parcel parcel = zza(28, zza());
    IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
    parcel.recycle();
    return iObjectWrapper;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\internal\maps\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */