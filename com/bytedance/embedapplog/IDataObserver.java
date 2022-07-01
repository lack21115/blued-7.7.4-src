package com.bytedance.embedapplog;

import org.json.JSONObject;

public interface IDataObserver {
  void onIdLoaded(String paramString1, String paramString2, String paramString3);
  
  void onRemoteAbConfigGet(boolean paramBoolean, JSONObject paramJSONObject);
  
  void onRemoteConfigGet(boolean paramBoolean, JSONObject paramJSONObject);
  
  void onRemoteIdGet(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\IDataObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */