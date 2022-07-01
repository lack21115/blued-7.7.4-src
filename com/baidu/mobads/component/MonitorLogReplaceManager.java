package com.baidu.mobads.component;

import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import java.util.HashSet;
import java.util.Iterator;

public class MonitorLogReplaceManager {
  private static final String CLICK_AREA = "hot";
  
  private static final String PLAY_MODE = "0";
  
  private static final String REGULAR_MATCH_CLICK_AREA = "%25%25area%25%25";
  
  private static final String REGULAR_MATCH_CUR_TIME = "%25%25cur_time%25%25";
  
  private static final String REGULAR_MATCH_PLAY_MODE = "%25%25play_mode%25%25";
  
  private static final String REGULAR_MATCH_START_TIME = "%25%25start_time%25%25";
  
  private static final String REGULAR_MATCH_TIME_STAMP = "%25%25origin_time%25%25";
  
  private static void httpGetRequest(String paramString, IXAdContainerContext paramIXAdContainerContext) {
    paramIXAdContainerContext.fireAdMetrics(paramString, null);
  }
  
  public static String regularMatch(String paramString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(System.currentTimeMillis());
    paramString = paramString.replaceAll("%25%25origin_time%25%25", stringBuilder.toString()).replaceAll("%25%25play_mode%25%25", "0");
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt1);
    paramString = paramString.replaceAll("%25%25cur_time%25%25", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(paramInt2);
    return paramString.replaceAll("%25%25start_time%25%25", stringBuilder.toString()).replaceAll("%25%25area%25%25", "hot");
  }
  
  public static void sendClickLog(IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainerContext paramIXAdContainerContext) {
    if (paramIXAdInstanceInfo == null)
      return; 
    for (String str : paramIXAdInstanceInfo.getThirdClickTrackingUrls()) {
      paramIXAdInstanceInfo.setThirdClickTrackingUrls(new HashSet());
      httpGetRequest(regularMatch(str, 0, 0), paramIXAdContainerContext);
    } 
  }
  
  public static void sendImpressionLog(IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainerContext paramIXAdContainerContext) {
    if (paramIXAdInstanceInfo == null)
      return; 
    Iterator<String> iterator2 = paramIXAdInstanceInfo.getImpressionUrls().iterator();
    while (iterator2.hasNext())
      httpGetRequest(regularMatch(iterator2.next(), 0, 0), paramIXAdContainerContext); 
    Iterator<String> iterator1 = paramIXAdInstanceInfo.getThirdImpressionTrackingUrls().iterator();
    while (iterator1.hasNext())
      httpGetRequest(regularMatch(iterator1.next(), 0, 0), paramIXAdContainerContext); 
  }
  
  public static void sendVCloseLog(int paramInt1, int paramInt2, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainerContext paramIXAdContainerContext) {
    if (paramIXAdInstanceInfo == null)
      return; 
    Iterator<String> iterator = paramIXAdInstanceInfo.getCloseTrackers().iterator();
    while (iterator.hasNext())
      httpGetRequest(regularMatch(iterator.next(), paramInt1, paramInt2), paramIXAdContainerContext); 
  }
  
  public static void sendVSkipLog(IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainerContext paramIXAdContainerContext) {
    if (paramIXAdInstanceInfo == null)
      return; 
    Iterator<String> iterator = paramIXAdInstanceInfo.getSkipTrackers().iterator();
    while (iterator.hasNext())
      httpGetRequest(regularMatch(iterator.next(), 0, 0), paramIXAdContainerContext); 
  }
  
  public static void sendVStartLog(IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainerContext paramIXAdContainerContext) {
    if (paramIXAdInstanceInfo == null)
      return; 
    Iterator<String> iterator = paramIXAdInstanceInfo.getStartTrackers().iterator();
    while (iterator.hasNext())
      httpGetRequest(regularMatch(iterator.next(), 0, 0), paramIXAdContainerContext); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\component\MonitorLogReplaceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */