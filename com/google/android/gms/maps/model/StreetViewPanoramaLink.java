package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class StreetViewPanoramaLink extends AbstractSafeParcelable {
  public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new zzn();
  
  public final float bearing;
  
  public final String panoId;
  
  public StreetViewPanoramaLink(String paramString, float paramFloat) {
    this.panoId = paramString;
    float f = paramFloat;
    if (paramFloat <= 0.0D)
      f = paramFloat % 360.0F + 360.0F; 
    this.bearing = f % 360.0F;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof StreetViewPanoramaLink))
      return false; 
    paramObject = paramObject;
    return (this.panoId.equals(((StreetViewPanoramaLink)paramObject).panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(((StreetViewPanoramaLink)paramObject).bearing));
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.panoId, Float.valueOf(this.bearing) });
  }
  
  public String toString() {
    return Objects.toStringHelper(this).add("panoId", this.panoId).add("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.panoId, false);
    SafeParcelWriter.writeFloat(paramParcel, 3, this.bearing);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\StreetViewPanoramaLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */