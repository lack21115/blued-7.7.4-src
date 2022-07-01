package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public class PLComposeItem {
  private static String TAG = "PLComposeItem";
  
  private long mDurationMs = 5000L;
  
  private String mFilePath;
  
  private ItemType mItemType = ItemType.IMAGE;
  
  private long mTransitionTimeMs = 1500L;
  
  public PLComposeItem(String paramString) {
    if (paramString != null && !paramString.isEmpty()) {
      this.mFilePath = paramString;
      return;
    } 
    throw new IllegalArgumentException("Illegal path: filePath is wrong!");
  }
  
  public long getDurationMs() {
    return this.mDurationMs;
  }
  
  public String getFilePath() {
    return this.mFilePath;
  }
  
  public ItemType getItemType() {
    return this.mItemType;
  }
  
  public long getTransitionTimeMs() {
    return this.mTransitionTimeMs;
  }
  
  public PLComposeItem setDurationMs(long paramLong) {
    if (this.mItemType == ItemType.VIDEO) {
      e.t.e(TAG, "The item type is video, needn't to set duration, because the duration is the video's duration.");
      return this;
    } 
    if (paramLong > 0L) {
      this.mDurationMs = paramLong;
      return this;
    } 
    throw new IllegalArgumentException("durationMs must be greater than 0!");
  }
  
  public PLComposeItem setFilePath(String paramString) {
    if (paramString != null && !paramString.isEmpty()) {
      this.mFilePath = paramString;
      return this;
    } 
    throw new IllegalArgumentException("Illegal path: filePath is wrong!");
  }
  
  public void setItemType(ItemType paramItemType) {
    this.mItemType = paramItemType;
    if (this.mItemType == ItemType.VIDEO) {
      PLMediaFile pLMediaFile = new PLMediaFile(this.mFilePath);
      this.mDurationMs = pLMediaFile.getDurationMs();
      pLMediaFile.release();
      e e = e.t;
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("the item type is video, duration is ");
      stringBuilder.append(this.mDurationMs);
      e.c(str, stringBuilder.toString());
    } 
  }
  
  public PLComposeItem setTransitionTimeMs(long paramLong) {
    if (paramLong >= 0L) {
      this.mTransitionTimeMs = paramLong;
      return this;
    } 
    throw new IllegalArgumentException("transitionTimeMs must be greater than or equal to 0!");
  }
  
  public String toString() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("FilePath", this.mFilePath);
      jSONObject.put("DurationMs", this.mDurationMs);
      jSONObject.put("TransitionTimeMs", this.mTransitionTimeMs);
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public enum ItemType {
    GIF, IMAGE, VIDEO;
    
    static {
      $VALUES = new ItemType[] { IMAGE, VIDEO, GIF };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLComposeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */