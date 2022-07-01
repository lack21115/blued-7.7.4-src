package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.core.b;
import com.qiniu.pili.droid.shortvideo.core.u;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class PLRecordSetting {
  private static final String DISPLAY_MODE = "displayMode";
  
  private static final String MAX_RECORD_DURATION = "maxRecordDuration";
  
  private static final String RECORD_FILE_PATH = "recordFilePath";
  
  public static final String TAG = "PLRecordSetting";
  
  private static final String VIDEO_CACHE_DIR = "videoCacheDir";
  
  private PLDisplayMode mDisplayMode = PLDisplayMode.FULL;
  
  private boolean mIsRecordSpeedVariable = false;
  
  private long mMaxRecordDuration = 10000L;
  
  private String mRecordFilepath;
  
  private File mVideoCacheDir;
  
  public static PLRecordSetting fromJSON(JSONObject paramJSONObject) {
    PLRecordSetting pLRecordSetting = new PLRecordSetting();
    pLRecordSetting.setMaxRecordDuration(paramJSONObject.optInt("maxRecordDuration", 10000));
    pLRecordSetting.setVideoCacheDir(paramJSONObject.optString("videoCacheDir"));
    pLRecordSetting.setVideoFilepath(paramJSONObject.optString("recordFilePath"));
    pLRecordSetting.setDisplayMode(PLDisplayMode.valueOf(paramJSONObject.optString("displayMode", PLDisplayMode.FULL.name())));
    return pLRecordSetting;
  }
  
  public static PLRecordSetting fromSetting(PLRecordSetting paramPLRecordSetting) {
    PLRecordSetting pLRecordSetting = new PLRecordSetting();
    pLRecordSetting.setMaxRecordDuration(paramPLRecordSetting.mMaxRecordDuration);
    pLRecordSetting.setRecordSpeedVariable(paramPLRecordSetting.mIsRecordSpeedVariable);
    pLRecordSetting.setDisplayMode(paramPLRecordSetting.mDisplayMode);
    pLRecordSetting.setVideoCacheDir(paramPLRecordSetting.mVideoCacheDir);
    pLRecordSetting.setVideoFilepath(paramPLRecordSetting.mRecordFilepath);
    return pLRecordSetting;
  }
  
  public boolean IsRecordSpeedVariable() {
    return this.mIsRecordSpeedVariable;
  }
  
  public PLDisplayMode getDisplayMode() {
    return this.mDisplayMode;
  }
  
  public long getMaxRecordDuration() {
    return this.mMaxRecordDuration;
  }
  
  public File getVideoCacheDir() {
    return this.mVideoCacheDir;
  }
  
  public String getVideoFilepath() {
    return this.mRecordFilepath;
  }
  
  public PLRecordSetting setDisplayMode(PLDisplayMode paramPLDisplayMode) {
    this.mDisplayMode = paramPLDisplayMode;
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setDisplayMode: ");
    stringBuilder.append(paramPLDisplayMode);
    e.c("PLRecordSetting", stringBuilder.toString());
    return this;
  }
  
  public PLRecordSetting setMaxRecordDuration(long paramLong) {
    if (!u.a().a(b.a.g))
      return this; 
    this.mMaxRecordDuration = paramLong;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMaxRecordDuration: ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" ms");
    e.c("PLRecordSetting", stringBuilder.toString());
    return this;
  }
  
  public PLRecordSetting setRecordSpeedVariable(boolean paramBoolean) {
    this.mIsRecordSpeedVariable = paramBoolean;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRecordSpeedVariable: ");
    stringBuilder.append(paramBoolean);
    e.c("PLRecordSetting", stringBuilder.toString());
    return this;
  }
  
  public PLRecordSetting setVideoCacheDir(File paramFile) {
    this.mVideoCacheDir = paramFile;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVideoCacheDir: ");
    stringBuilder.append(paramFile);
    e.c("PLRecordSetting", stringBuilder.toString());
    return this;
  }
  
  public PLRecordSetting setVideoCacheDir(String paramString) {
    return setVideoCacheDir(new File(paramString));
  }
  
  public PLRecordSetting setVideoFilepath(String paramString) {
    this.mRecordFilepath = paramString;
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVideoFilepath: ");
    stringBuilder.append(paramString);
    e.c("PLRecordSetting", stringBuilder.toString());
    return this;
  }
  
  public JSONObject toJSON() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("maxRecordDuration", this.mMaxRecordDuration);
      jSONObject.put("videoCacheDir", this.mVideoCacheDir.getAbsolutePath());
      jSONObject.put("recordFilePath", this.mRecordFilepath);
      jSONObject.put("displayMode", this.mDisplayMode.name());
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLRecordSetting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */