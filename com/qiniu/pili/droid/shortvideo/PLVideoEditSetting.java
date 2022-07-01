package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.e;

public class PLVideoEditSetting {
  private static final String TAG = "PLVideoEditSetting";
  
  private String mDestFilepath;
  
  private boolean mIsGifPreviewEnabled = true;
  
  private boolean mIsKeepOriginFile = true;
  
  private String mSourceFilepath;
  
  public String getDestFilepath() {
    return this.mDestFilepath;
  }
  
  public String getSourceFilepath() {
    return this.mSourceFilepath;
  }
  
  public boolean isGifPreviewEnabled() {
    return this.mIsGifPreviewEnabled;
  }
  
  public boolean isKeepOriginFile() {
    return this.mIsKeepOriginFile;
  }
  
  public PLVideoEditSetting setDestFilepath(String paramString) {
    this.mDestFilepath = paramString;
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDestFilepath: ");
    stringBuilder.append(paramString);
    e.c("PLVideoEditSetting", stringBuilder.toString());
    return this;
  }
  
  public PLVideoEditSetting setGifPreviewEnabled(boolean paramBoolean) {
    this.mIsGifPreviewEnabled = paramBoolean;
    return this;
  }
  
  public PLVideoEditSetting setKeepOriginFile(boolean paramBoolean) {
    this.mIsKeepOriginFile = paramBoolean;
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setKeepOriginFile: ");
    stringBuilder.append(paramBoolean);
    e.c("PLVideoEditSetting", stringBuilder.toString());
    return this;
  }
  
  public PLVideoEditSetting setSourceFilepath(String paramString) {
    this.mSourceFilepath = paramString;
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSourceFilepath: ");
    stringBuilder.append(paramString);
    e.c("PLVideoEditSetting", stringBuilder.toString());
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLVideoEditSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */