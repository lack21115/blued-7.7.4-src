package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.AdSlot;
import org.json.JSONObject;

public class ae {
  public static AdSlot a(String paramString) {
    try {
      return a(new JSONObject(paramString));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static AdSlot a(JSONObject paramJSONObject) {
    if (paramJSONObject == null)
      return null; 
    AdSlot.Builder builder = new AdSlot.Builder();
    try {
      int i = paramJSONObject.optInt("width", 640);
      int j = paramJSONObject.optInt("height", 320);
      double d1 = paramJSONObject.optDouble("expressWidth", 0.0D);
      double d2 = paramJSONObject.optDouble("expressHeight", 0.0D);
      builder.setAdCount(paramJSONObject.optInt("adCount", 1));
      builder.setCodeId(paramJSONObject.optString("codeId", null));
      builder.setImageAcceptedSize(i, j);
      builder.setMediaExtra(paramJSONObject.optString("extra", null));
      builder.setNativeAdType(paramJSONObject.optInt("adType"));
      builder.setOrientation(paramJSONObject.optInt("orientation"));
      builder.setRewardAmount(paramJSONObject.optInt("rewardAmount"));
      builder.setRewardName(paramJSONObject.optString("rewardName", null));
      builder.setSupportDeepLink(paramJSONObject.optBoolean("supportDeepLink", false));
      builder.setUserID(paramJSONObject.optString("userId", null));
      builder.setIsAutoPlay(paramJSONObject.optBoolean("autoPlay", true));
      builder.setExpressViewAcceptedSize(Double.valueOf(d1).floatValue(), Double.valueOf(d2).floatValue());
    } catch (Exception exception) {}
    return builder.build();
  }
  
  public static String a(AdSlot paramAdSlot) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("adCount", paramAdSlot.getAdCount());
      jSONObject.put("codeId", paramAdSlot.getCodeId());
      jSONObject.put("width", paramAdSlot.getImgAcceptedWidth());
      jSONObject.put("height", paramAdSlot.getImgAcceptedHeight());
      jSONObject.put("extra", paramAdSlot.getMediaExtra());
      jSONObject.put("adType", paramAdSlot.getNativeAdType());
      jSONObject.put("orientation", paramAdSlot.getOrientation());
      jSONObject.put("rewardAmount", paramAdSlot.getRewardAmount());
      jSONObject.put("rewardName", paramAdSlot.getRewardName());
      jSONObject.put("supportDeepLink", paramAdSlot.isSupportDeepLink());
      jSONObject.put("userId", paramAdSlot.getUserID());
      jSONObject.put("expressWidth", paramAdSlot.getExpressViewAcceptedWidth());
      jSONObject.put("expressHeight", paramAdSlot.getExpressViewAcceptedHeight());
      jSONObject.put("autoPlay", paramAdSlot.isAutoPlay());
    } catch (Exception exception) {}
    return jSONObject.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */