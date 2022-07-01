package com.baidu.mobads.interfaces;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IXAdInstanceInfo {
  boolean getAPOOpen();
  
  String getAction();
  
  int getActionType();
  
  int getAdContainerHeight();
  
  int getAdContainerSizeType();
  
  int getAdContainerWidth();
  
  boolean getAdHasDisplayed();
  
  String getAdId();
  
  String getAdSource();
  
  int getAntiTag();
  
  String getAppName();
  
  String getAppOpenStrs();
  
  String getAppPackageName();
  
  long getAppSize();
  
  String getBannerHtmlSnippet();
  
  List<String> getCacheExpireTrackers();
  
  List<String> getCacheFailTrackers();
  
  List<String> getCacheSuccTrackers();
  
  List<String> getCcardTrackers();
  
  String getClickThroughUrl();
  
  String getClklogurl();
  
  List<String> getCloseTrackers();
  
  int getCloseType();
  
  String getConfirmBorderPercent();
  
  long getCreateTime();
  
  CreativeType getCreativeType();
  
  List<String> getCstartcardTrackers();
  
  String getDescription();
  
  int getDlTunnel();
  
  String getExp2ForSingleAd();
  
  int getExpiration();
  
  int getFeedAdStyleType();
  
  List<String> getFullScreenTrackers();
  
  String getFwt();
  
  int getHoursInADayToShowAd();
  
  String getHtmlSnippet();
  
  String getIconUrl();
  
  Set<String> getImpressionUrls();
  
  String getIntHtmlSnippet();
  
  String getLocalCreativeURL();
  
  int getMainMaterialHeight();
  
  int getMainMaterialWidth();
  
  String getMainPictureUrl();
  
  String getMaterialType();
  
  String getMute();
  
  JSONArray getNwinurl();
  
  String getOriginClickUrl();
  
  JSONObject getOriginJsonObject();
  
  String getPage();
  
  String getPhoneForLocalBranding();
  
  String getPhoneNumber();
  
  int getPointsForWall();
  
  String getQueryKey();
  
  List<String> getScardTrackers();
  
  List<String> getSkipTrackers();
  
  String getSponsorUrl();
  
  List<String> getStartTrackers();
  
  int getSwitchButton();
  
  List<String> getThirdClickTrackingUrls();
  
  List<String> getThirdImpressionTrackingUrls();
  
  String getTitle();
  
  String getUniqueId();
  
  String getUrl();
  
  int getVideoDuration();
  
  int getVideoHeight();
  
  String getVideoUrl();
  
  int getVideoWidth();
  
  String getVurl();
  
  String getWebUrl();
  
  String getWinurl();
  
  boolean isActionOnlyWifi();
  
  boolean isAutoOpen();
  
  boolean isCanCancel();
  
  boolean isCanDelete();
  
  boolean isClose();
  
  @Deprecated
  boolean isIconVisibleForImageType();
  
  boolean isInapp();
  
  boolean isPopNotif();
  
  boolean isSecondConfirmed();
  
  boolean isTaskDoneForWall();
  
  boolean isTooLarge();
  
  Boolean isValid();
  
  boolean isVideoMuted();
  
  boolean isWifiTargeted();
  
  void setAPOOpen(boolean paramBoolean);
  
  void setAction(String paramString);
  
  void setActionOnlyWifi(boolean paramBoolean);
  
  void setActionType(int paramInt);
  
  void setAdContainerHeight(int paramInt);
  
  void setAdContainerSizeType(int paramInt);
  
  void setAdContainerWidth(int paramInt);
  
  void setAdHasDisplayed(boolean paramBoolean);
  
  void setAdId(String paramString);
  
  void setAdSource(String paramString);
  
  void setAntiTag(int paramInt);
  
  void setAppName(String paramString);
  
  void setAppOpenStrs(String paramString);
  
  void setAppPackageName(String paramString);
  
  void setAppSize(long paramLong);
  
  void setAutoOpen(boolean paramBoolean);
  
  void setBannerHtmlSnippet(String paramString);
  
  void setCacheExpireTrackers(List<String> paramList);
  
  void setCacheFailTrackers(List<String> paramList);
  
  void setCacheSuccTrackers(List<String> paramList);
  
  void setCanCancel(boolean paramBoolean);
  
  void setCanDelete(boolean paramBoolean);
  
  void setCcardTrackers(List<String> paramList);
  
  void setClickThroughUrl(String paramString);
  
  void setClklogurl(String paramString);
  
  void setClose(boolean paramBoolean);
  
  void setCloseTrackers(List<String> paramList);
  
  void setCloseType(int paramInt);
  
  void setConfirmBorderPercent(String paramString);
  
  void setCreateTime(long paramLong);
  
  void setCreativeType(CreativeType paramCreativeType);
  
  void setCstartcardTrackers(List<String> paramList);
  
  void setDescription(String paramString);
  
  void setDlTunnel(int paramInt);
  
  void setExp2ForSingleAd(String paramString);
  
  void setExpiration(int paramInt);
  
  void setFeedAdStyleType(int paramInt);
  
  void setFullScreenTrackers(List<String> paramList);
  
  void setFwt(String paramString);
  
  @Deprecated
  void setHoursInADayToShowAd(int paramInt);
  
  void setHtmlSnippet(String paramString);
  
  void setIconUrl(String paramString);
  
  @Deprecated
  void setIconVisibleForImageType(boolean paramBoolean);
  
  void setImpressionUrls(Set<String> paramSet);
  
  void setInapp(boolean paramBoolean);
  
  void setIntHtmlSnippet(String paramString);
  
  void setLocalCreativeURL(String paramString);
  
  void setMainMaterialHeight(int paramInt);
  
  void setMainMaterialWidth(int paramInt);
  
  void setMainPictureUrl(String paramString);
  
  void setMaterialType(String paramString);
  
  void setMute(String paramString);
  
  void setNwinurl(JSONArray paramJSONArray);
  
  void setOriginClickUrl(String paramString);
  
  void setPage(String paramString);
  
  void setPhoneForLocalBranding(String paramString);
  
  void setPhoneNumber(String paramString);
  
  void setPointsForWall(int paramInt);
  
  void setPopNotif(boolean paramBoolean);
  
  void setQueryKey(String paramString);
  
  void setScardTrackers(List<String> paramList);
  
  void setSecondConfirmed(boolean paramBoolean);
  
  void setSkipTrackers(List<String> paramList);
  
  void setSponsorUrl(String paramString);
  
  void setStartTrackers(List<String> paramList);
  
  void setSwitchButton(int paramInt);
  
  void setTaskDoneForWall(boolean paramBoolean);
  
  void setThirdClickTrackingUrls(Set<String> paramSet);
  
  void setThirdImpressionTrackingUrls(Set<String> paramSet);
  
  void setTitle(String paramString);
  
  void setTooLarge(boolean paramBoolean);
  
  void setUrl(String paramString);
  
  void setVideoDuration(int paramInt);
  
  void setVideoHeight(int paramInt);
  
  void setVideoMuted(boolean paramBoolean);
  
  void setVideoUrl(String paramString);
  
  void setVideoWidth(int paramInt);
  
  void setVurl(String paramString);
  
  void setWebUrl(String paramString);
  
  void setWifiTargeted(boolean paramBoolean);
  
  void setWinurl(String paramString);
  
  public enum CreativeType {
    GIF,
    HTML,
    HYBRID,
    NONE("none"),
    RM("none"),
    STATIC_IMAGE("none"),
    TEXT("text"),
    VIDEO("text");
    
    private final String a;
    
    static {
      GIF = new CreativeType("GIF", 3, "gif");
      RM = new CreativeType("RM", 4, "rich_media");
      HTML = new CreativeType("HTML", 5, "html");
      HYBRID = new CreativeType("HYBRID", 6, "hybrid");
      VIDEO = new CreativeType("VIDEO", 7, "video");
      b = new CreativeType[] { NONE, TEXT, STATIC_IMAGE, GIF, RM, HTML, HYBRID, VIDEO };
    }
    
    CreativeType(String param1String1) {
      this.a = param1String1;
    }
    
    public static CreativeType parse(String param1String) {
      for (CreativeType creativeType : values()) {
        if (creativeType.a.equalsIgnoreCase(param1String))
          return creativeType; 
      } 
      return null;
    }
    
    public String getValue() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\IXAdInstanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */