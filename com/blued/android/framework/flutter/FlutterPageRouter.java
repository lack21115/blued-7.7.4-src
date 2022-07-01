package com.blued.android.framework.flutter;

import android.content.Context;
import android.content.Intent;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import java.util.HashMap;
import java.util.Map;

public class FlutterPageRouter {
  public static final Map<String, String> a = new HashMap<String, String>() {
    
    };
  
  public static boolean a(Context paramContext, String paramString, Map paramMap) {
    return a(paramContext, paramString, paramMap, 0);
  }
  
  public static boolean a(Context paramContext, String paramString, Map paramMap, int paramInt) {
    paramString = paramString.split("\\?")[0];
    if (AppInfo.m()) {
      Gson gson = (new GsonBuilder()).disableHtmlEscaping().create();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(":");
      stringBuilder.append(gson.toJson(paramMap));
      LogUtils.c("openPageByUrl", stringBuilder.toString());
    } 
    try {
      Intent intent;
      if (a.containsKey(paramString)) {
        intent = FlutterBoostActivity.e().a(a.get(paramString)).a(paramMap).a(BoostFlutterActivity.BackgroundMode.a).a(paramContext);
        if (paramContext instanceof android.app.Activity)
          return true; 
        return true;
      } 
      if (intent.equals("url_page"))
        return false; 
      return false;
    } finally {
      paramContext = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterPageRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */