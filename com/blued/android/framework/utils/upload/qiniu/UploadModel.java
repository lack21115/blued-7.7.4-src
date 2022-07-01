package com.blued.android.framework.utils.upload.qiniu;

public class UploadModel {
  public String compressPath;
  
  public int type = 0;
  
  public String url;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UploadModel{compressPath='");
    stringBuilder.append(this.compressPath);
    stringBuilder.append('\'');
    stringBuilder.append(", url='");
    stringBuilder.append(this.url);
    stringBuilder.append('\'');
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static interface TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\util\\upload\qiniu\UploadModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */