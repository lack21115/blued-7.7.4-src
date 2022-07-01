package com.ss.android.socialbase.downloader.e;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.m.f;

public class a extends Exception implements Parcelable {
  public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() {
      public a a(Parcel param1Parcel) {
        return new a(param1Parcel);
      }
      
      public a[] a(int param1Int) {
        return new a[param1Int];
      }
    };
  
  private int a;
  
  private String b;
  
  public a() {}
  
  public a(int paramInt, String paramString) {
    super(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("[d-ex]:");
    stringBuilder.append(paramString);
    this.b = stringBuilder.toString();
    this.a = paramInt;
  }
  
  public a(int paramInt, Throwable paramThrowable) {
    this(paramInt, f.i(paramThrowable));
  }
  
  protected a(Parcel paramParcel) {
    a(paramParcel);
  }
  
  public int a() {
    return this.a;
  }
  
  public void a(Parcel paramParcel) {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public String b() {
    return this.b;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BaseException{errorCode=");
    stringBuilder.append(this.a);
    stringBuilder.append(", errorMsg='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */