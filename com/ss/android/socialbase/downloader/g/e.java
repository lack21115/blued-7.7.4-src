package com.ss.android.socialbase.downloader.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class e implements Parcelable, Comparable {
  public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() {
      public e a(Parcel param1Parcel) {
        return new e(param1Parcel);
      }
      
      public e[] a(int param1Int) {
        return new e[param1Int];
      }
    };
  
  private final String a;
  
  private final String b;
  
  protected e(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public e(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public int compareTo(Object paramObject) {
    if (paramObject instanceof e) {
      String str = this.a;
      paramObject = paramObject;
      if (TextUtils.equals(str, paramObject.a()))
        return 0; 
      str = this.a;
      if (str == null)
        return -1; 
      int i = str.compareTo(paramObject.a());
      return (i > 0) ? 1 : ((i < 0) ? -1 : 0);
    } 
    return 1;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (TextUtils.equals(this.a, ((e)paramObject).a) && TextUtils.equals(this.b, ((e)paramObject).b));
    } 
    return false;
  }
  
  public int hashCode() {
    int i;
    String str = this.a;
    int j = 0;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    } 
    str = this.b;
    if (str != null)
      j = str.hashCode(); 
    return i * 31 + j;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */