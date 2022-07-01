package com.baidu.mobads.nativecpu.a;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.nativecpu.IBasicCPUData;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements IBasicCPUData {
  public Object a;
  
  public c b;
  
  public b(Context paramContext, Object paramObject) {
    this.a = paramObject;
    this.b = c.a(paramContext, "com.baidu.mobads.container.nativecpu.interfaces.ICPUAdInstance");
  }
  
  public int getActionType() {
    return ((Integer)this.b.b(this.a, "getActionType", new Object[0])).intValue();
  }
  
  public int getAdHeight() {
    return ((Integer)this.b.b(this.a, "getAdHeight", new Object[0])).intValue();
  }
  
  public String getAdLogoUrl() {
    return (String)this.b.b(this.a, "getAdLogoUrl", new Object[0]);
  }
  
  public int getAdWidth() {
    return ((Integer)this.b.b(this.a, "getAdWidth", new Object[0])).intValue();
  }
  
  public String getAppPackageName() {
    return (String)this.b.b(this.a, "getPackageName", new Object[0]);
  }
  
  public String getAuthor() {
    return (String)this.b.b(this.a, "getAuthor", new Object[0]);
  }
  
  public String getBaiduLogoUrl() {
    return (String)this.b.b(this.a, "getBaiduLogoUrl", new Object[0]);
  }
  
  public String getBrandName() {
    Object object = this.b.b(this.a, "getBrandName", new Object[0]);
    return (object instanceof String) ? (String)object : null;
  }
  
  public String getChannelId() {
    return (String)this.b.b(this.a, "getCatId", new Object[0]);
  }
  
  public String getChannelName() {
    return (String)this.b.b(this.a, "getCatName", new Object[0]);
  }
  
  public int getCommentCounts() {
    return ((Integer)this.b.b(this.a, "getCommentCounts", new Object[0])).intValue();
  }
  
  public String getDesc() {
    return (String)this.b.b(this.a, "getContent", new Object[0]);
  }
  
  public JSONArray getDislikeReasons() {
    return (JSONArray)this.b.b(this.a, "getDislikeReasons", new Object[0]);
  }
  
  public int getDownloadStatus() {
    return ((Integer)this.b.b(this.a, "getDownloadStatus", new Object[0])).intValue();
  }
  
  public int getDuration() {
    return ((Integer)this.b.b(this.a, "getDuration", new Object[0])).intValue();
  }
  
  public JSONObject getExtra() {
    return (JSONObject)this.b.b(this.a, "getExtra", new Object[0]);
  }
  
  public String getIconUrl() {
    return (String)this.b.b(this.a, "getAvatar", new Object[0]);
  }
  
  public List<String> getImageUrls() {
    Object object = this.b.b(this.a, "getImageList", new Object[0]);
    return (object instanceof List) ? (List<String>)object : null;
  }
  
  public int getPlayCounts() {
    Object object = this.b.b(this.a, "getPlayCounts", new Object[0]);
    return (object instanceof Integer) ? ((Integer)object).intValue() : 0;
  }
  
  public int getPresentationType() {
    return ((Integer)this.b.b(this.a, "getPresentationType", new Object[0])).intValue();
  }
  
  public List<String> getSmallImageUrls() {
    Object object = this.b.b(this.a, "getSmallImageList", new Object[0]);
    return (object instanceof List) ? (List<String>)object : null;
  }
  
  public int getStyleType() {
    return ((Integer)this.b.b(this.a, "getStyleType", new Object[0])).intValue();
  }
  
  public int getThumbHeight() {
    return ((Integer)this.b.b(this.a, "getThumbHeight", new Object[0])).intValue();
  }
  
  public String getThumbUrl() {
    return (String)this.b.b(this.a, "getThumbUrl", new Object[0]);
  }
  
  public int getThumbWidth() {
    return ((Integer)this.b.b(this.a, "getThumbWidth", new Object[0])).intValue();
  }
  
  public String getTitle() {
    return (String)this.b.b(this.a, "getTitle", new Object[0]);
  }
  
  public String getType() {
    return (String)this.b.b(this.a, "getType", new Object[0]);
  }
  
  public String getUpdateTime() {
    return (String)this.b.b(this.a, "getUpdateTime", new Object[0]);
  }
  
  public String getVUrl() {
    return (String)this.b.b(this.a, "getVUrl", new Object[0]);
  }
  
  public void handleClick(View paramView) {
    this.b.a(this.a, "handleClick", new Object[] { paramView });
  }
  
  public boolean isDownloadApp() {
    return ((Boolean)this.b.b(this.a, "isDownloadApp", new Object[0])).booleanValue();
  }
  
  public boolean isTop() {
    return ((Boolean)this.b.b(this.a, "isTop", new Object[0])).booleanValue();
  }
  
  public void markDislike(String[] paramArrayOfString) {
    this.b.a(this.a, "markDislike", new Object[] { paramArrayOfString });
  }
  
  public void onImpression(View paramView) {
    this.b.a(this.a, "onImpression", new Object[] { paramView });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */