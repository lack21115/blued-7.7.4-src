package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzbg;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest extends AbstractSafeParcelable {
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzal();
  
  public static final int INITIAL_TRIGGER_DWELL = 4;
  
  public static final int INITIAL_TRIGGER_ENTER = 1;
  
  public static final int INITIAL_TRIGGER_EXIT = 2;
  
  private final List<zzbg> zza;
  
  private final int zzb;
  
  private final String zzc;
  
  GeofencingRequest(List<zzbg> paramList, int paramInt, String paramString) {
    this.zza = paramList;
    this.zzb = paramInt;
    this.zzc = paramString;
  }
  
  public List<Geofence> getGeofences() {
    ArrayList<zzbg> arrayList = new ArrayList();
    arrayList.addAll(this.zza);
    return (List)arrayList;
  }
  
  public int getInitialTrigger() {
    return this.zzb;
  }
  
  public String toString() {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("GeofencingRequest[");
    stringBuilder2.append("geofences=");
    stringBuilder2.append(this.zza);
    int i = this.zzb;
    StringBuilder stringBuilder1 = new StringBuilder(30);
    stringBuilder1.append(", initialTrigger=");
    stringBuilder1.append(i);
    stringBuilder1.append(", ");
    stringBuilder2.append(stringBuilder1.toString());
    String str = String.valueOf(this.zzc);
    if (str.length() != 0) {
      str = "tag=".concat(str);
    } else {
      str = new String("tag=");
    } 
    stringBuilder2.append(str);
    stringBuilder2.append("]");
    return stringBuilder2.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zza, false);
    SafeParcelWriter.writeInt(paramParcel, 2, getInitialTrigger());
    SafeParcelWriter.writeString(paramParcel, 3, this.zzc, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static final class Builder {
    private final List<zzbg> zza = new ArrayList<zzbg>();
    
    private int zzb = 5;
    
    private String zzc = "";
    
    public final Builder addGeofence(Geofence param1Geofence) {
      Preconditions.checkNotNull(param1Geofence, "geofence can't be null.");
      Preconditions.checkArgument(param1Geofence instanceof zzbg, "Geofence must be created using Geofence.Builder.");
      this.zza.add((zzbg)param1Geofence);
      return this;
    }
    
    public final Builder addGeofences(List<Geofence> param1List) {
      if (param1List != null) {
        if (param1List.isEmpty())
          return this; 
        for (Geofence geofence : param1List) {
          if (geofence != null)
            addGeofence(geofence); 
        } 
      } 
      return this;
    }
    
    public final GeofencingRequest build() {
      Preconditions.checkArgument(this.zza.isEmpty() ^ true, "No geofence has been added to this request.");
      return new GeofencingRequest(this.zza, this.zzb, this.zzc);
    }
    
    public final Builder setInitialTrigger(int param1Int) {
      this.zzb = param1Int & 0x7;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\location\GeofencingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */