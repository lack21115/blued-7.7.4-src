package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

public class PermissionInfo implements Parcelable, IMessageEntity {
  public static final Parcelable.Creator<PermissionInfo> CREATOR = new Parcelable.Creator<PermissionInfo>() {
      public PermissionInfo createFromParcel(Parcel param1Parcel) {
        return new PermissionInfo(param1Parcel);
      }
      
      public PermissionInfo[] newArray(int param1Int) {
        return new PermissionInfo[param1Int];
      }
    };
  
  @Packed
  private String appID;
  
  @Packed
  private String packageName;
  
  @Packed
  private String permission;
  
  public PermissionInfo() {}
  
  public PermissionInfo(Parcel paramParcel) {
    this.appID = paramParcel.readString();
    this.packageName = paramParcel.readString();
    this.permission = paramParcel.readString();
  }
  
  public PermissionInfo(String paramString1, String paramString2, String paramString3) {
    this.appID = paramString1;
    this.packageName = paramString2;
    this.permission = paramString3;
  }
  
  public int describeContents() {
    return 0;
  }
  
  public String getAppID() {
    return this.appID;
  }
  
  public String getPackageName() {
    return this.packageName;
  }
  
  public String getPermission() {
    return this.permission;
  }
  
  public void setAppID(String paramString) {
    this.appID = paramString;
  }
  
  public void setPackageName(String paramString) {
    this.packageName = paramString;
  }
  
  public void setPermission(String paramString) {
    this.permission = paramString;
  }
  
  public PermissionInfo setPermissionUri(String paramString) {
    this.permission = paramString;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.appID);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.permission);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\PermissionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */