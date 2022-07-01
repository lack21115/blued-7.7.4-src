package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

public class CmdObject extends BaseMediaObject {
  public static final String CMD_HOME = "home";
  
  public static final Parcelable.Creator<CmdObject> CREATOR = new Parcelable.Creator<CmdObject>() {
      public CmdObject createFromParcel(Parcel param1Parcel) {
        return new CmdObject(param1Parcel);
      }
      
      public CmdObject[] newArray(int param1Int) {
        return new CmdObject[param1Int];
      }
    };
  
  public String cmd;
  
  public CmdObject() {}
  
  public CmdObject(Parcel paramParcel) {
    this.cmd = paramParcel.readString();
  }
  
  public boolean checkArgs() {
    String str = this.cmd;
    return !(str == null || str.length() == 0 || this.cmd.length() > 1024);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getObjType() {
    return 7;
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString) {
    return this;
  }
  
  protected String toExtraMediaString() {
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.cmd);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\CmdObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */