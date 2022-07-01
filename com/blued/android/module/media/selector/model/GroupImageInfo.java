package com.blued.android.module.media.selector.model;

import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;

public class GroupImageInfo implements Serializable {
  private MediaInfo childImageInfo;
  
  private String folderName;
  
  private int imageCounts;
  
  private int mediaType;
  
  private String topImagePath;
  
  public String topImageUri;
  
  public MediaInfo getChildImageInfo() {
    return this.childImageInfo;
  }
  
  public String getFolderName() {
    return this.folderName;
  }
  
  public int getImageCounts() {
    return this.imageCounts;
  }
  
  public int getMediaType() {
    return this.mediaType;
  }
  
  public String getTopImagePath() {
    return this.topImagePath;
  }
  
  public boolean isVideoMediaType() {
    return (getMediaType() == 3);
  }
  
  public void setChildImageInfo(MediaInfo paramMediaInfo) {
    this.childImageInfo = paramMediaInfo;
  }
  
  public void setFolderName(String paramString) {
    this.folderName = paramString;
  }
  
  public void setImageCounts(int paramInt) {
    this.imageCounts = paramInt;
  }
  
  public void setMediaType(int paramInt) {
    this.mediaType = paramInt;
  }
  
  public void setTopImagePath(String paramString) {
    this.topImagePath = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\model\GroupImageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */