package com.blued.android.share.msg;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class MsgImageText extends MsgText {
  public static final Parcelable.Creator<MsgImageText> CREATOR = new Parcelable.Creator<MsgImageText>() {
      public MsgImageText createFromParcel(Parcel param1Parcel) {
        return new MsgImageText(param1Parcel);
      }
      
      public MsgImageText[] newArray(int param1Int) {
        return new MsgImageText[param1Int];
      }
    };
  
  public int hasImage;
  
  public Bitmap image;
  
  public String imageUrl;
  
  public MsgImageText() {}
  
  public MsgImageText(Parcel paramParcel) {
    super(paramParcel);
    this.imageUrl = paramParcel.readString();
    this.hasImage = paramParcel.readInt();
    if (this.hasImage == 1)
      this.image = (Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()); 
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.imageUrl);
    this.hasImage = 0;
    Bitmap bitmap = this.image;
    if (bitmap != null && !bitmap.isRecycled()) {
      paramParcel.writeParcelable((Parcelable)this.image, 1);
      this.hasImage = 1;
    } 
    paramParcel.writeInt(this.hasImage);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\msg\MsgImageText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */