package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;

public class XAdLandingPageExtraInfo extends XAdCommandExtraInfo {
  public static final Parcelable.Creator<XAdLandingPageExtraInfo> CREATOR = new c();
  
  public int e75;
  
  public int from;
  
  public boolean isFullScreen;
  
  public String lpMurl;
  
  public String lpShoubaiStyle;
  
  public int orientation;
  
  public int os;
  
  public String prodType;
  
  public String title;
  
  private XAdLandingPageExtraInfo(Parcel paramParcel) {
    super(paramParcel);
    boolean bool = false;
    this.isFullScreen = false;
    this.orientation = 1;
    this.e75 = 1;
    this.from = 0;
    this.os = 1;
    this.url = paramParcel.readString();
    if (paramParcel.readByte() != 0)
      bool = true; 
    this.isFullScreen = bool;
    this.orientation = paramParcel.readInt();
    this.e75 = paramParcel.readInt();
    this.from = paramParcel.readInt();
    this.adid = paramParcel.readString();
    this.qk = paramParcel.readString();
    this.packageNameOfPubliser = paramParcel.readString();
    this.appsid = paramParcel.readString();
    this.appsec = paramParcel.readString();
    this.os = paramParcel.readInt();
    this.prodType = paramParcel.readString();
    this.v = paramParcel.readString();
    this.sn = paramParcel.readString();
    this.title = paramParcel.readString();
    this.lpShoubaiStyle = paramParcel.readString();
    this.lpMurl = paramParcel.readString();
  }
  
  public XAdLandingPageExtraInfo(String paramString, IXAdInstanceInfo paramIXAdInstanceInfo) {
    super(paramString, paramIXAdInstanceInfo);
    this.isFullScreen = false;
    this.orientation = 1;
    this.e75 = 1;
    this.from = 0;
    this.os = 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    String str;
    h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.url);
    paramParcel.writeByte((byte)this.isFullScreen);
    paramParcel.writeInt(this.orientation);
    paramParcel.writeInt(this.e75);
    paramParcel.writeInt(this.from);
    paramParcel.writeString(this.adid);
    paramParcel.writeString(this.qk);
    paramParcel.writeString(this.packageNameOfPubliser);
    paramParcel.writeString(this.appsid);
    paramParcel.writeString(this.appsec);
    paramParcel.writeInt(1);
    paramParcel.writeString(this.mProdType);
    paramParcel.writeString(h.b());
    paramParcel.writeString(iXAdSystemUtils.getEncodedSN(XAdSDKFoundationFacade.getInstance().getApplicationContext()));
    if (TextUtils.isEmpty(this.title)) {
      str = "";
    } else {
      str = this.title;
    } 
    this.title = str;
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.lpShoubaiStyle);
    paramParcel.writeString(this.lpMurl);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\XAdLandingPageExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */