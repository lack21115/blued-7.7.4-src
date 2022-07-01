package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;

public class TextObject extends BaseMediaObject {
  public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() {
      public TextObject createFromParcel(Parcel param1Parcel) {
        return new TextObject(param1Parcel);
      }
      
      public TextObject[] newArray(int param1Int) {
        return new TextObject[param1Int];
      }
    };
  
  public String text;
  
  public TextObject() {}
  
  public TextObject(Parcel paramParcel) {
    this.text = paramParcel.readString();
  }
  
  public boolean checkArgs() {
    String str = this.text;
    if (str == null || str.length() == 0 || this.text.length() > 1024) {
      LogUtil.e("Weibo.TextObject", "checkArgs fail, text is invalid");
      return false;
    } 
    return true;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public int getObjType() {
    return 1;
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString) {
    return this;
  }
  
  protected String toExtraMediaString() {
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.text);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\TextObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */