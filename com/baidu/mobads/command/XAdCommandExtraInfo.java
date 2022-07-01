package com.baidu.mobads.command;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.vo.XAdInstanceInfo;

public abstract class XAdCommandExtraInfo implements Parcelable {
  public String adid = "-1";
  
  public String appsec = "";
  
  public String appsid = "";
  
  public Boolean autoOpen;
  
  public Boolean canCancel;
  
  public String canDelete;
  
  public String iconfrom;
  
  protected XAdInstanceInfo mAdInstanceInfo;
  
  public int mIntTesting4LM;
  
  public String mProdType;
  
  public String mStringTesting4LM;
  
  public String packageName = "";
  
  public String packageNameOfPubliser = "";
  
  public Boolean popNotif;
  
  public String qk = "";
  
  public String sn;
  
  public String url;
  
  public String v;
  
  protected XAdCommandExtraInfo(Parcel paramParcel) {
    Boolean bool = Boolean.valueOf(true);
    this.autoOpen = bool;
    this.v = "";
    this.sn = "";
    this.iconfrom = "";
    this.canCancel = bool;
    this.canDelete = "";
    this.popNotif = bool;
    this.mAdInstanceInfo = (XAdInstanceInfo)paramParcel.readParcelable(XAdInstanceInfo.class.getClassLoader());
    this.mProdType = paramParcel.readString();
    this.mIntTesting4LM = paramParcel.readInt();
    this.mStringTesting4LM = paramParcel.readString();
  }
  
  public XAdCommandExtraInfo(String paramString, IXAdInstanceInfo paramIXAdInstanceInfo) {
    Boolean bool = Boolean.valueOf(true);
    this.autoOpen = bool;
    this.v = "";
    this.sn = "";
    this.iconfrom = "";
    this.canCancel = bool;
    this.canDelete = "";
    this.popNotif = bool;
    this.mIntTesting4LM = 999;
    this.mStringTesting4LM = "this is the test string";
    this.mProdType = paramString;
    this.mAdInstanceInfo = (XAdInstanceInfo)paramIXAdInstanceInfo;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public IXAdInstanceInfo getAdInstanceInfo() {
    return (IXAdInstanceInfo)this.mAdInstanceInfo;
  }
  
  public Boolean isValid() {
    return Boolean.valueOf("-1".equalsIgnoreCase(this.adid));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.mAdInstanceInfo, paramInt);
    paramParcel.writeString(this.mProdType);
    paramParcel.writeInt(this.mIntTesting4LM);
    paramParcel.writeString(this.mStringTesting4LM);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\command\XAdCommandExtraInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */