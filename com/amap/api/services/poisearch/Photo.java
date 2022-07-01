package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

public final class Photo implements Parcelable {
  public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
    
    };
  
  private String a;
  
  private String b;
  
  public Photo() {}
  
  public Photo(Parcel paramParcel) {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
  }
  
  public Photo(String paramString1, String paramString2) {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public final int describeContents() {
    return 0;
  }
  
  public final String getTitle() {
    return this.a;
  }
  
  public final String getUrl() {
    return this.b;
  }
  
  public final void setTitle(String paramString) {
    this.a = paramString;
  }
  
  public final void setUrl(String paramString) {
    this.b = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\poisearch\Photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */