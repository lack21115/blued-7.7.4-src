package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
  public static final Parcelable.Creator<LocationResult> CREATOR;
  
  static final List<Location> zza = Collections.emptyList();
  
  private final List<Location> zzb;
  
  static {
    CREATOR = new zzaw();
  }
  
  LocationResult(List<Location> paramList) {
    this.zzb = paramList;
  }
  
  public static LocationResult create(List<Location> paramList) {
    List<Location> list = paramList;
    if (paramList == null)
      list = zza; 
    return new LocationResult(list);
  }
  
  public static LocationResult extractResult(Intent paramIntent) {
    return !hasResult(paramIntent) ? null : (LocationResult)paramIntent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public static boolean hasResult(Intent paramIntent) {
    return (paramIntent == null) ? false : paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public final boolean equals(Object<Location> paramObject) {
    if (!(paramObject instanceof LocationResult))
      return false; 
    paramObject = paramObject;
    if (((LocationResult)paramObject).zzb.size() != this.zzb.size())
      return false; 
    paramObject = (Object<Location>)((LocationResult)paramObject).zzb.iterator();
    Iterator<Location> iterator = this.zzb.iterator();
    while (paramObject.hasNext()) {
      Location location1 = iterator.next();
      Location location2 = paramObject.next();
      if (location1.getTime() != location2.getTime())
        return false; 
    } 
    return true;
  }
  
  public final Location getLastLocation() {
    int i = this.zzb.size();
    return (i == 0) ? null : this.zzb.get(i - 1);
  }
  
  public final List<Location> getLocations() {
    return this.zzb;
  }
  
  public final int hashCode() {
    Iterator<Location> iterator = this.zzb.iterator();
    int i;
    for (i = 17; iterator.hasNext(); i = i * 31 + (int)(l ^ l >>> 32L))
      long l = ((Location)iterator.next()).getTime(); 
    return i;
  }
  
  public final String toString() {
    String str = String.valueOf(this.zzb);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 27);
    stringBuilder.append("LocationResult[locations: ");
    stringBuilder.append(str);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getLocations(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\LocationResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */