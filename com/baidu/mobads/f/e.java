package com.baidu.mobads.f;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements Parcelable {
  public static final Parcelable.Creator<e> a = new f();
  
  private JSONObject b;
  
  private double c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private int g;
  
  private int h;
  
  private e(Parcel paramParcel) {
    this.e = paramParcel.readString();
    this.h = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.c = paramParcel.readDouble();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
  }
  
  public e(e parame, String paramString, Boolean paramBoolean) {}
  
  public e(String paramString) {
    boolean bool = true;
    try {
      this.b = new JSONObject(paramString);
      this.c = this.b.getDouble("version");
      this.d = this.b.getString("url");
      this.e = this.b.getString("sign");
      this.h = 1;
      this.f = "";
      this.g = 0;
    } catch (JSONException jSONException) {
      this.h = 0;
    } 
    if (c() == null)
      bool = false; 
    this.h = bool;
  }
  
  public Boolean a() {
    int i = this.h;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return Boolean.valueOf(bool);
  }
  
  public double b() {
    return this.c;
  }
  
  public String c() {
    return XAdSDKFoundationFacade.getInstance().getURIUitls().replaceURLWithSupportProtocol(this.d);
  }
  
  public String d() {
    return this.e;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String e() {
    return this.f;
  }
  
  public String toString() {
    return this.b.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.e);
    paramParcel.writeInt(this.h);
    paramParcel.writeString(this.d);
    paramParcel.writeDouble(this.c);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */