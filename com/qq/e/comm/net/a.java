package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  private static String a() {
    Context context = GDTADManager.getInstance().getAppContext();
    TelephonyManager telephonyManager = null;
    try {
      String str;
      NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
      TelephonyManager telephonyManager1 = telephonyManager;
      if (networkInfo != null) {
        telephonyManager1 = telephonyManager;
        if (networkInfo.getType() == 0) {
          telephonyManager1 = (TelephonyManager)context.getSystemService("phone");
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(telephonyManager1.getNetworkType());
          str = stringBuilder.toString();
        } 
      } 
      return str;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static JSONObject a(PM paramPM) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
    jSONObject.putOpt("pv", Integer.valueOf(paramPM.getPluginVersion()));
    jSONObject.putOpt("sdk_st", Integer.valueOf(1));
    return jSONObject;
  }
  
  public static JSONObject a(SM paramSM) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (paramSM != null) {
      jSONObject.putOpt("suid", paramSM.getSuid());
      jSONObject.putOpt("sid", paramSM.getSid());
    } 
    return jSONObject;
  }
  
  public static JSONObject a(APPStatus paramAPPStatus) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (paramAPPStatus != null) {
      jSONObject.putOpt("an", paramAPPStatus.getAPPName());
      jSONObject.putOpt("appkey", paramAPPStatus.getAPPID());
      jSONObject.putOpt("appv", paramAPPStatus.getAPPVersion());
      jSONObject.putOpt("appn", paramAPPStatus.getAPPRealName());
    } 
    return jSONObject;
  }
  
  public static JSONObject a(DeviceStatus paramDeviceStatus) throws JSONException {
    JSONObject jSONObject = new JSONObject();
    if (paramDeviceStatus != null) {
      jSONObject.putOpt("so", paramDeviceStatus.getScreenOrientation());
      jSONObject.putOpt("dn", paramDeviceStatus.getDataNet());
      String str = a();
      if (!StringUtil.isEmpty(str))
        jSONObject.putOpt("cell_native", str); 
      jSONObject.putOpt("lat", paramDeviceStatus.getLat());
      jSONObject.putOpt("lng", paramDeviceStatus.getLng());
      for (Map.Entry entry : paramDeviceStatus.getLacAndCeilId().entrySet())
        jSONObject.putOpt((String)entry.getKey(), entry.getValue()); 
    } 
    return jSONObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */