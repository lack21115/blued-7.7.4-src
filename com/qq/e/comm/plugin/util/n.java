package com.qq.e.comm.plugin.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.ad.b;
import com.qq.e.comm.plugin.y.d;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
  public static int a() {
    return (SDKStatus.getSDKVersionCode() >= 20) ? 1 : 0;
  }
  
  public static d a(LoadAdParams paramLoadAdParams) {
    return (paramLoadAdParams == null) ? null : (new d()).a("la", paramLoadAdParams.getLoginAppId()).a("lt", paramLoadAdParams.getLoginType()).a("lo", paramLoadAdParams.getLoginOpenid()).a("ei", paramLoadAdParams.getExtraInfo());
  }
  
  public static d a(b paramb) {
    return (paramb == null) ? null : (new d()).a("la", paramb.y()).a("lt", paramb.x()).a("lo", paramb.v()).a("ei", paramb.H());
  }
  
  private static String a(Context paramContext) {
    int i = Process.myPid();
    List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (list != null)
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (runningAppProcessInfo.pid == i)
          return runningAppProcessInfo.processName; 
      }  
    return "@None@";
  }
  
  public static JSONObject a(Context paramContext, Object paramObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("pd", Process.myPid());
      jSONObject.put("pn", a(paramContext));
      jSONObject.put("td", Thread.currentThread().getId());
      jSONObject.put("tn", Thread.currentThread().getName());
      if (paramObject != null) {
        jSONObject.put("oh", paramObject.hashCode());
        return jSONObject;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */