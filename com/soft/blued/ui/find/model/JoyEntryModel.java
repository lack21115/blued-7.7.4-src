package com.soft.blued.ui.find.model;

import android.os.Parcel;
import android.os.Parcelable;

public class JoyEntryModel implements Parcelable {
  public static final Parcelable.Creator<JoyEntryModel> CREATOR = new Parcelable.Creator<JoyEntryModel>() {
      public JoyEntryModel createFromParcel(Parcel param1Parcel) {
        return new JoyEntryModel(param1Parcel);
      }
      
      public JoyEntryModel[] newArray(int param1Int) {
        return new JoyEntryModel[param1Int];
      }
    };
  
  public String color;
  
  public String icon;
  
  public String name;
  
  public String url;
  
  public JoyEntryModel() {}
  
  protected JoyEntryModel(Parcel paramParcel) {
    this.name = paramParcel.readString();
    this.url = paramParcel.readString();
    this.icon = paramParcel.readString();
    this.color = paramParcel.readString();
  }
  
  public JoyEntryModel(String paramString1, String paramString2, String paramString3) {
    this.name = paramString1;
    this.url = paramString2;
    this.icon = paramString3;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.icon);
    paramParcel.writeString(this.color);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\JoyEntryModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */