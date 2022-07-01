package com.soft.blued.ui.msg.model;

public class MsgChattingImageModel {
  private String latitude;
  
  private String location;
  
  private String longitude;
  
  private MsgSourceEntity msgSource;
  
  private int pic_height;
  
  private int pic_width;
  
  public String getLatitude() {
    String str = this.latitude;
    return (str != null) ? str : "";
  }
  
  public String getLocation() {
    String str = this.location;
    return (str != null) ? str : "";
  }
  
  public String getLongitude() {
    String str = this.longitude;
    return (str != null) ? str : "";
  }
  
  public MsgSourceEntity getMsgSource() {
    return this.msgSource;
  }
  
  public int getPicHeight() {
    return this.pic_height;
  }
  
  public int getPicWidth() {
    return this.pic_width;
  }
  
  public void setLatitude(String paramString) {
    this.latitude = paramString;
  }
  
  public void setLocation(String paramString) {
    this.location = paramString;
  }
  
  public void setLongitude(String paramString) {
    this.longitude = paramString;
  }
  
  public void setMsgSource(MsgSourceEntity paramMsgSourceEntity) {
    this.msgSource = paramMsgSourceEntity;
  }
  
  public void setPicHeight(int paramInt) {
    this.pic_height = paramInt;
  }
  
  public void setPicWidth(int paramInt) {
    this.pic_width = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgChattingImageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */