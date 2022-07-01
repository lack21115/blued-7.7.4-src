package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class MsgImage extends AbsShareMsg {
  public static final Parcelable.Creator<MsgImage> CREATOR = new Parcelable.Creator<MsgImage>() {
      public MsgImage createFromParcel(Parcel param1Parcel) {
        return new MsgImage(param1Parcel);
      }
      
      public MsgImage[] newArray(int param1Int) {
        return new MsgImage[param1Int];
      }
    };
  
  public Bitmap image;
  
  public String imagePath;
  
  public String imageUrl;
  
  public MsgImage() {}
  
  public MsgImage(Parcel paramParcel) {
    this.pType = paramParcel.readInt();
    this.appName = paramParcel.readString();
    this.imageUrl = paramParcel.readString();
    this.imagePath = paramParcel.readString();
    this.image = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(this.pType);
    paramParcel.writeString(this.appName);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeString(this.imagePath);
    paramParcel.writeParcelable((Parcelable)this.image, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\msg\MsgImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */