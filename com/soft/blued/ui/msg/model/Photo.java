package com.soft.blued.ui.msg.model;

public class Photo {
  private String picid;
  
  private String url;
  
  private String url_small;
  
  public String getPicid() {
    return this.picid;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public String getUrl_small() {
    return this.url_small;
  }
  
  public void setPicid(String paramString) {
    this.picid = paramString;
  }
  
  public void setUrl(String paramString) {
    this.url = paramString;
  }
  
  public void setUrl_small(String paramString) {
    this.url_small = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Photo [picid=");
    stringBuilder.append(this.picid);
    stringBuilder.append(", url=");
    stringBuilder.append(this.url);
    stringBuilder.append(", url_small=");
    stringBuilder.append(this.url_small);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\Photo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */