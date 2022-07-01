package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends zzbgl implements ReflectedParcelable {
  public static final Parcelable.Creator CREATOR;
  
  static final List zzisl = Collections.emptyList();
  
  private final List zzism;
  
  static {
    CREATOR = new zzac();
    throw new VerifyError("bad dex opcode");
  }
  
  LocationResult(List paramList) {
    this.zzism = paramList;
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof LocationResult))
      return false; 
    paramObject = paramObject;
    if (((LocationResult)paramObject).zzism.size() != this.zzism.size())
      return false; 
    paramObject = ((LocationResult)paramObject).zzism.iterator();
    Iterator<Location> iterator = this.zzism.iterator();
    while (paramObject.hasNext()) {
      Location location1 = iterator.next();
      Location location2 = paramObject.next();
      if (location1.getTime() != location2.getTime())
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    Iterator<Location> iterator = this.zzism.iterator();
    int i;
    for (i = 17; iterator.hasNext(); i = i * 31 + (int)(l ^ l >>> 32L))
      long l = ((Location)iterator.next()).getTime(); 
    return i;
  }
  
  public final String toString() {
    String str = String.valueOf(this.zzism);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
    stringBuilder.append("LocationResult[locations: ");
    stringBuilder.append(str);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = zzbgo.zzag(paramParcel, 20293);
    zzbgo.zzc(paramParcel, 1, this.zzism, false);
    zzbgo.zzah(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\location\LocationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */