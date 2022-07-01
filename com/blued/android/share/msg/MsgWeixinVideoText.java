package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class MsgWeixinVideoText extends MsgText {
  public static final Parcelable.Creator<MsgWeixinVideoText> CREATOR = new Parcelable.Creator<MsgWeixinVideoText>() {
      public MsgWeixinVideoText createFromParcel(Parcel param1Parcel) {
        return new MsgWeixinVideoText(param1Parcel);
      }
      
      public MsgWeixinVideoText[] newArray(int param1Int) {
        return new MsgWeixinVideoText[param1Int];
      }
    };
  
  public Bitmap image;
  
  public String imageUrl;
  
  public MsgWeixinVideoText() {}
  
  public MsgWeixinVideoText(Parcel paramParcel) {
    super(paramParcel);
    this.imageUrl = paramParcel.readString();
    this.image = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.imageUrl);
    paramParcel.writeParcelable((Parcelable)this.image, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\msg\MsgWeixinVideoText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */