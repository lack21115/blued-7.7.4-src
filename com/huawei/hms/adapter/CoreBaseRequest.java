package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

class CoreBaseRequest implements IMessageEntity {
  @Packed
  private String jsonHeader;
  
  @Packed
  private String jsonObject;
  
  @Packed
  private Parcelable parcelable;
  
  public String getJsonHeader() {
    return this.jsonHeader;
  }
  
  public String getJsonObject() {
    return this.jsonObject;
  }
  
  public Parcelable getParcelable() {
    return this.parcelable;
  }
  
  public void setJsonHeader(String paramString) {
    this.jsonHeader = paramString;
  }
  
  public void setJsonObject(String paramString) {
    this.jsonObject = paramString;
  }
  
  public void setParcelable(Parcelable paramParcelable) {
    this.parcelable = paramParcelable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\CoreBaseRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */