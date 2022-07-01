package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
  public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() {
      public b a(Parcel param1Parcel) {
        return new b(param1Parcel);
      }
      
      public b[] a(int param1Int) {
        return new b[param1Int];
      }
    };
  
  public String a;
  
  public Bundle b = null;
  
  private int c = 1;
  
  private Bundle d = null;
  
  public b() {}
  
  private b(Parcel paramParcel) {
    a(paramParcel);
  }
  
  public b(String paramString, int paramInt) {
    this.a = paramString;
    this.c = paramInt;
  }
  
  private static ClassLoader a(Class paramClass) {
    return paramClass.getClassLoader();
  }
  
  private void a(Parcel paramParcel) {
    this.c = paramParcel.readInt();
    this.a = paramParcel.readString();
    this.b = paramParcel.readBundle(a(Bundle.class));
    this.d = paramParcel.readBundle(a(Bundle.class));
  }
  
  public Bundle a() {
    return this.d;
  }
  
  public b a(Bundle paramBundle) {
    this.d = paramBundle;
    return this;
  }
  
  public int b() {
    return (this.d == null) ? 0 : 1;
  }
  
  public int c() {
    return this.c;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.a);
    paramParcel.writeBundle(this.b);
    paramParcel.writeBundle(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */