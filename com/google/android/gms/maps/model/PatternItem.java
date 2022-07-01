package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

public class PatternItem extends AbstractSafeParcelable {
  public static final Parcelable.Creator<PatternItem> CREATOR;
  
  private static final String TAG = PatternItem.class.getSimpleName();
  
  private final int type;
  
  private final Float zzdv;
  
  static {
    CREATOR = new zzi();
  }
  
  public PatternItem(int paramInt, Float paramFloat) {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
      if (paramFloat != null && paramFloat.floatValue() >= 0.0F) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }  
    String str = String.valueOf(paramFloat);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 45);
    stringBuilder.append("Invalid PatternItem: type=");
    stringBuilder.append(paramInt);
    stringBuilder.append(" length=");
    stringBuilder.append(str);
    Preconditions.checkArgument(bool1, stringBuilder.toString());
    this.type = paramInt;
    this.zzdv = paramFloat;
  }
  
  static List<PatternItem> zza(List<PatternItem> paramList) {
    if (paramList == null)
      return null; 
    ArrayList<PatternItem> arrayList = new ArrayList(paramList.size());
    for (PatternItem patternItem : paramList) {
      if (patternItem == null) {
        patternItem = null;
      } else {
        int i = patternItem.type;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              String str = TAG;
              StringBuilder stringBuilder = new StringBuilder(37);
              stringBuilder.append("Unknown PatternItem type: ");
              stringBuilder.append(i);
              Log.w(str, stringBuilder.toString());
            } else {
              patternItem = new Gap(patternItem.zzdv.floatValue());
            } 
          } else {
            patternItem = new Dot();
          } 
        } else {
          patternItem = new Dash(patternItem.zzdv.floatValue());
        } 
      } 
      arrayList.add(patternItem);
    } 
    return arrayList;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof PatternItem))
      return false; 
    paramObject = paramObject;
    return (this.type == ((PatternItem)paramObject).type && Objects.equal(this.zzdv, ((PatternItem)paramObject).zzdv));
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.type), this.zzdv });
  }
  
  public String toString() {
    int i = this.type;
    String str = String.valueOf(this.zzdv);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 39);
    stringBuilder.append("[PatternItem: type=");
    stringBuilder.append(i);
    stringBuilder.append(" length=");
    stringBuilder.append(str);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    SafeParcelWriter.writeFloatObject(paramParcel, 3, this.zzdv, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\PatternItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */