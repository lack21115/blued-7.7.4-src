package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoObject extends BaseMediaObject {
  public static final Parcelable.Creator<VideoObject> CREATOR = new Parcelable.Creator<VideoObject>() {
      public VideoObject createFromParcel(Parcel param1Parcel) {
        return new VideoObject(param1Parcel);
      }
      
      public VideoObject[] newArray(int param1Int) {
        return new VideoObject[param1Int];
      }
    };
  
  public static final String EXTRA_KEY_DEFAULTTEXT = "extra_key_defaulttext";
  
  public String dataHdUrl;
  
  public String dataUrl;
  
  public String defaultText;
  
  public int duration;
  
  public String h5Url;
  
  public VideoObject() {}
  
  public VideoObject(Parcel paramParcel) {
    super(paramParcel);
    this.h5Url = paramParcel.readString();
    this.dataUrl = paramParcel.readString();
    this.dataHdUrl = paramParcel.readString();
    this.duration = paramParcel.readInt();
  }
  
  public boolean checkArgs() {
    if (!super.checkArgs())
      return false; 
    String str = this.dataUrl;
    if (str != null && str.length() > 512) {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataUrl is invalid");
      return false;
    } 
    str = this.dataHdUrl;
    if (str != null && str.length() > 512) {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, dataHdUrl is invalid");
      return false;
    } 
    if (this.duration <= 0) {
      LogUtil.e("Weibo.VideoObject", "checkArgs fail, duration is invalid");
      return false;
    } 
    return true;
  }
  
  public int getObjType() {
    return 4;
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
    paramParcel.writeString(this.h5Url);
    paramParcel.writeString(this.dataUrl);
    paramParcel.writeString(this.dataHdUrl);
    paramParcel.writeInt(this.duration);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\VideoObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */