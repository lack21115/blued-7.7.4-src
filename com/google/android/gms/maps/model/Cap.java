package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class Cap extends AbstractSafeParcelable {
  public static final Parcelable.Creator<Cap> CREATOR;
  
  private static final String TAG = Cap.class.getSimpleName();
  
  private final BitmapDescriptor bitmapDescriptor;
  
  private final int type;
  
  private final Float zzcn;
  
  static {
    CREATOR = new zzb();
  }
  
  protected Cap(int paramInt) {
    this(paramInt, (BitmapDescriptor)null, (Float)null);
  }
  
  Cap(int paramInt, IBinder paramIBinder, Float paramFloat) {
    this(paramInt, bitmapDescriptor, paramFloat);
  }
  
  private Cap(int paramInt, BitmapDescriptor paramBitmapDescriptor, Float paramFloat) {
    boolean bool1;
    boolean bool2;
    if (paramFloat != null && paramFloat.floatValue() > 0.0F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramInt != 3 || (paramBitmapDescriptor != null && bool1)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", new Object[] { Integer.valueOf(paramInt), paramBitmapDescriptor, paramFloat }));
    this.type = paramInt;
    this.bitmapDescriptor = paramBitmapDescriptor;
    this.zzcn = paramFloat;
  }
  
  protected Cap(BitmapDescriptor paramBitmapDescriptor, float paramFloat) {
    this(3, paramBitmapDescriptor, Float.valueOf(paramFloat));
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Cap))
      return false; 
    paramObject = paramObject;
    return (this.type == ((Cap)paramObject).type && Objects.equal(this.bitmapDescriptor, ((Cap)paramObject).bitmapDescriptor) && Objects.equal(this.zzcn, ((Cap)paramObject).zzcn));
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.type), this.bitmapDescriptor, this.zzcn });
  }
  
  public String toString() {
    int i = this.type;
    StringBuilder stringBuilder = new StringBuilder(23);
    stringBuilder.append("[Cap: type=");
    stringBuilder.append(i);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    IBinder iBinder;
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    BitmapDescriptor bitmapDescriptor = this.bitmapDescriptor;
    if (bitmapDescriptor == null) {
      bitmapDescriptor = null;
    } else {
      iBinder = bitmapDescriptor.zzb().asBinder();
    } 
    SafeParcelWriter.writeIBinder(paramParcel, 3, iBinder, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 4, this.zzcn, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  final Cap zzh() {
    int i = this.type;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder(29);
            stringBuilder.append("Unknown Cap type: ");
            stringBuilder.append(i);
            Log.w(str, stringBuilder.toString());
            return this;
          } 
          return new CustomCap(this.bitmapDescriptor, this.zzcn.floatValue());
        } 
        return new RoundCap();
      } 
      return new SquareCap();
    } 
    return new ButtCap();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\maps\model\Cap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */