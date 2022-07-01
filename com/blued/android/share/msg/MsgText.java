package com.blued.android.share.msg;

import android.os.Parcel;
import android.os.Parcelable;

public class MsgText extends AbsShareMsg {
  public static final Parcelable.Creator<MsgText> CREATOR = new Parcelable.Creator<MsgText>() {
      public MsgText createFromParcel(Parcel param1Parcel) {
        return new MsgText(param1Parcel);
      }
      
      public MsgText[] newArray(int param1Int) {
        return new MsgText[param1Int];
      }
    };
  
  public String summary;
  
  public String targetUrl;
  
  public String title;
  
  public MsgText() {}
  
  public MsgText(Parcel paramParcel) {
    this.title = paramParcel.readString();
    this.summary = paramParcel.readString();
    this.targetUrl = paramParcel.readString();
    this.pType = paramParcel.readInt();
    this.appName = paramParcel.readString();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.summary);
    paramParcel.writeString(this.targetUrl);
    paramParcel.writeInt(this.pType);
    paramParcel.writeString(this.appName);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\msg\MsgText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */