package com.blued.android.module.shortvideo.model;

import java.io.Serializable;

public class VideoFrameInfo implements Serializable {
  public int index;
  
  public String path;
  
  public long time;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("VideoFrameInfo{index='");
    stringBuilder.append(this.index);
    stringBuilder.append('\'');
    stringBuilder.append(", path='");
    stringBuilder.append(this.path);
    stringBuilder.append('\'');
    stringBuilder.append(", time='");
    stringBuilder.append(this.time);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\VideoFrameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */