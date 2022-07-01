package com.soft.blued.ui.feed.model;

public class ChildImageInfo {
  public long duration;
  
  public int height;
  
  public String imgUri;
  
  public String mImagePath;
  
  public String mPid;
  
  public boolean mSelect;
  
  public boolean mTakePhoto;
  
  public String mediaType;
  
  public int width;
  
  public ChildImageInfo() {}
  
  public ChildImageInfo(ChildImageInfo paramChildImageInfo) {
    copy(paramChildImageInfo);
  }
  
  public ChildImageInfo(String paramString) {
    this.mImagePath = paramString;
  }
  
  public void copy(ChildImageInfo paramChildImageInfo) {
    this.mImagePath = paramChildImageInfo.mImagePath;
    this.mPid = paramChildImageInfo.mPid;
    this.mSelect = paramChildImageInfo.mSelect;
    this.width = paramChildImageInfo.width;
    this.height = paramChildImageInfo.height;
    this.mTakePhoto = paramChildImageInfo.mTakePhoto;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\ChildImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */