package com.baidu.mobads.nativecpu;

import android.view.View;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IBasicCPUData {
  int getActionType();
  
  int getAdHeight();
  
  String getAdLogoUrl();
  
  int getAdWidth();
  
  String getAppPackageName();
  
  String getAuthor();
  
  String getBaiduLogoUrl();
  
  String getBrandName();
  
  String getChannelId();
  
  String getChannelName();
  
  int getCommentCounts();
  
  String getDesc();
  
  JSONArray getDislikeReasons();
  
  int getDownloadStatus();
  
  int getDuration();
  
  JSONObject getExtra();
  
  String getIconUrl();
  
  List<String> getImageUrls();
  
  int getPlayCounts();
  
  int getPresentationType();
  
  List<String> getSmallImageUrls();
  
  int getStyleType();
  
  int getThumbHeight();
  
  String getThumbUrl();
  
  int getThumbWidth();
  
  String getTitle();
  
  String getType();
  
  String getUpdateTime();
  
  String getVUrl();
  
  void handleClick(View paramView);
  
  boolean isDownloadApp();
  
  boolean isTop();
  
  void markDislike(String[] paramArrayOfString);
  
  void onImpression(View paramView);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\IBasicCPUData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */