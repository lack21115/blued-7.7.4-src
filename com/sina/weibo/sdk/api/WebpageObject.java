package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class WebpageObject extends BaseMediaObject {
  public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() {
      public WebpageObject createFromParcel(Parcel param1Parcel) {
        return new WebpageObject(param1Parcel);
      }
      
      public WebpageObject[] newArray(int param1Int) {
        return new WebpageObject[param1Int];
      }
    };
  
  public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
  
  public String defaultText;
  
  public WebpageObject() {}
  
  public WebpageObject(Parcel paramParcel) {
    super(paramParcel);
  }
  
  public boolean checkArgs() {
    return !!super.checkArgs();
  }
  
  public int getObjType() {
    return 5;
  }
  
  protected BaseMediaObject toExtraMediaObject(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        this.defaultText = (new JSONObject(paramString)).optString("extra_key_defaulttext");
        return this;
      } catch (JSONException jSONException) {
        return this;
      }  
    return this;
  }
  
  protected String toExtraMediaString() {
    try {
      JSONObject jSONObject = new JSONObject();
      if (!TextUtils.isEmpty(this.defaultText))
        jSONObject.put("extra_key_defaulttext", this.defaultText); 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      return "";
    } 
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    super.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\WebpageObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */