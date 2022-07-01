package com.soft.blued.ui.msg.model;

public class MsgRecentPhotoInfo {
  public int height;
  
  public long id;
  
  public String imgPath;
  
  public int isNormalImg = 0;
  
  public boolean isPin;
  
  public boolean isSelected;
  
  public int width;
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return this.imgPath.equals(((MsgRecentPhotoInfo)paramObject).imgPath);
  }
  
  public int hashCode() {
    return this.imgPath.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MsgRecentPhotoInfo{id=");
    stringBuilder.append(this.id);
    stringBuilder.append(", imgPath='");
    stringBuilder.append(this.imgPath);
    stringBuilder.append('\'');
    stringBuilder.append(", isSelected=");
    stringBuilder.append(this.isSelected);
    stringBuilder.append(", width=");
    stringBuilder.append(this.width);
    stringBuilder.append(", height=");
    stringBuilder.append(this.height);
    stringBuilder.append(", isNormalImg=");
    stringBuilder.append(this.isNormalImg);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static interface NormalImgType {
    public static final int LONGIMG = 1;
    
    public static final int NOMALIMG = 0;
    
    public static final int WIDEIMG = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgRecentPhotoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */