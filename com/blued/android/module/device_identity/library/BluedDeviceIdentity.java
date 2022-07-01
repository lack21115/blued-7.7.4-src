package com.blued.android.module.device_identity.library;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.statistics.BluedStatistics;
import com.datavisor.vangogh.face.DVTokenClient;
import com.google.gson.Gson;
import com.ishumei.smantifraud.SmAntiFraud;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BluedDeviceIdentity {
  private static BluedDeviceIdentity a;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private String d = null;
  
  private Map<String, String> e = new ConcurrentHashMap<String, String>();
  
  private Map<String, Boolean> f = new ConcurrentHashMap<String, Boolean>();
  
  public static BluedDeviceIdentity a() {
    if (a == null)
      a = new BluedDeviceIdentity(); 
    return a;
  }
  
  private void a(Context paramContext) {
    Log.v("BluedDeviceIdentity", "initShumengSDK()");
    try {
      Main.init(paramContext, "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKrxd6xg3i6OL6j34xOS3aGZZqxFKBj7eeDqJ44coQFoNi7KxZ8h6OkZCRMX0S8Btodi/NFlb57gsk/kowjfBAcCAwEAAQ==");
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    Main.getQueryID(paramContext, AppInfo.c, "optionMessage", 1, new Listener(this) {
          public void handler(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get shumengid:");
            stringBuilder.append(param1String);
            Log.v("BluedDeviceIdentity", stringBuilder.toString());
            if (!TextUtils.isEmpty(param1String)) {
              BluedDeviceIdentity.a(this.a, "szlm_id", param1String);
              BluedStatistics.a().k(param1String);
            } 
          }
        });
    Log.v("BluedDeviceIdentity", "wait shumeng sdk callback");
    if (TextUtils.equals("1", AppInfo.e())) {
      Main.getOpenAnmsID(paramContext, new Listener(this) {
            public void handler(String param1String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("get oaid:");
              stringBuilder.append(param1String);
              Log.v("BluedDeviceIdentity", stringBuilder.toString());
              if (!"NA".equalsIgnoreCase(param1String)) {
                BluedDeviceIdentity.a(this.a).put("oaid", param1String);
                BluedDeviceIdentity.a(this.a, param1String);
              } 
            }
          });
      Log.v("BluedDeviceIdentity", "wait shumeng-oaid sdk callback");
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    String str;
    Log.v("BluedDeviceIdentity", "initDataVisorSDK()");
    if (!HappyDnsUtils.c()) {
      str = "datavisor-zjk.irisgw.com";
    } else {
      str = "blued.gw-dv.net";
    } 
    DVTokenClient.a(AppInfo.d()).a(str);
    DVTokenClient.a(AppInfo.d()).a(paramString1, paramString2, null, new DVTokenClient.InitResultListener(this) {
          public void a(String param1String, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get dataVisor token:");
            stringBuilder.append(param1String);
            stringBuilder.append(", result:");
            stringBuilder.append(param1Int);
            Log.v("BluedDeviceIdentity", stringBuilder.toString());
            if (param1Int == 0)
              BluedDeviceIdentity.a(this.a, "dvid", param1String); 
          }
        });
  }
  
  private void b(String paramString) {
    SharedPreferencesUtils.a().edit().putString("SM_OAID", paramString).commit();
  }
  
  private void b(String paramString1, String paramString2) {
    boolean bool;
    String str = this.e.get(paramString1);
    Boolean bool1 = this.f.get(paramString1);
    if (bool1 == null) {
      bool = false;
    } else {
      bool = bool1.booleanValue();
    } 
    if (!bool || !TextUtils.equals(str, paramString2)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      this.e.put(paramString1, paramString2);
      if (!this.c)
        return; 
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("type", paramString1);
      hashMap.put("dev_id", paramString2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("upload deviceId, type:");
      stringBuilder.append(paramString1);
      stringBuilder.append(", id:");
      stringBuilder.append(paramString2);
      Log.v("BluedDeviceIdentity", stringBuilder.toString());
      Map<String, String> map = BluedHttpTools.a();
      Gson gson = AppInfo.f();
      try {
        map.put("_", AesCrypto.b(gson.toJson(hashMap)));
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      if (!TextUtils.isEmpty(this.d)) {
        this.f.put(paramString1, Boolean.valueOf(true));
        HttpManager.b(this.d).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
      } 
    } 
  }
  
  private void i() {
    Log.v("BluedDeviceIdentity", "initShumeiSDK()");
    try {
      SmAntiFraud.SmOption smOption = new SmAntiFraud.SmOption();
      smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
      smOption.setChannel(AppInfo.c);
      smOption.setAppId(AppInfo.e());
      smOption.setPublicKey("MIIDOzCCAiOgAwIBAgIBMDANBgkqhkiG9w0BAQUFADA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wHhcNMTgwMjExMDg0NTIyWhcNMzgwMjA2MDg0NTIyWjA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCkF+2AicVKj7SaHw3dbJt3i6fkL1WfLw1WRqe8r8Cc7qJOshaqNvCzW1qRX6E5H/umtl1Uj99V07uewUFk96xY/+s/GuBnbGoSrcu3OAHDgEGuY5atZo+umIk7LufAif2VUcNGY3nWxGcig20ExO/6nAf/G3Xxo4QL8fBdPG/prOXxSvtJiPls1Qg9zzSgAH+HMCAINMsuJmzDQiTt6Me8k7YHts+jWQF7KF25plITcW1Qmy3Aw8qYjVhbHn8KTAEeuQhmM5RS6KP1Hu71q4DYOWcx44QThSbiAYwG1JQBBwM8XnBfVYMpr6Qi0owibNYoZ/S6xwfRFGB0W1HeG9WfAgMBAAGjUDBOMB0GA1UdDgQWBBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAfBgNVHSMEGDAWgBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4IBAQB5MWz1RGFG537rJCtHp+LqxR9iJSFsHiW3ZoLIAeyD0oJ69RcL2gE/TNWmE9zYUkd9TdNtXqxlNPpj1P1/+x781neWnGou/n/XFS82T5S339X3DIjHc/IqOzwnxEOKH2V0NmK9iKgx6H05Q9MMvUXFsL3QK2hDMAVY28roRiC4S1yfJJaA08DfvXZf6cVx1xfWl+ks57+3knkoWap1rjwh1RdGk5ChPbzD0AnAcWTMWRCbjuJnttlmWZnI1I6mhcQUKUEMoj8sR8m11YJ5woscYPsIle/rJOOosuMghczD1vRcg3eLUaWn1A5rsBa82RyxhiuYocEQVX59Hy6v3npT");
      if (TextUtils.equals("2", AppInfo.e()))
        smOption.setArea("xjp"); 
      smOption.setServerIdCallback(new SmAntiFraud.IServerSmidCallback(this) {
            public void onError(int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("get shumeiBoxId failed:");
              stringBuilder.append(param1Int);
              Log.v("BluedDeviceIdentity", stringBuilder.toString());
            }
            
            public void onSuccess(String param1String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("get shumeiBoxId:");
              stringBuilder.append(param1String);
              Log.v("BluedDeviceIdentity", stringBuilder.toString());
              BluedStatistics.a().j(param1String);
              BluedDeviceIdentity.a(this.a, "boxid", param1String);
            }
          });
      SmAntiFraud.create(AppInfo.d(), smOption);
      Log.v("BluedDeviceIdentity", "wait shumei sdk callback");
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private void j() {
    Log.v("BluedDeviceIdentity", "upload all id");
    b("szlm_id", this.e.get("szlm_id"));
    b("boxid", this.e.get("boxid"));
    b("dvid", this.e.get("dvid"));
    b("oaid", this.e.get("oaid"));
    b("push_token", this.e.get("push_token"));
  }
  
  private String k() {
    return SharedPreferencesUtils.a().getString("SM_OAID", "");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    Log.v("BluedDeviceIdentity", "init");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init, app:");
    stringBuilder.append(AppInfo.e());
    Log.v("BluedDeviceIdentity", stringBuilder.toString());
    if (this.b)
      return; 
    this.b = true;
    this.d = paramString1;
    a(paramString2, paramString3);
    i();
    a(paramContext);
    Log.v("BluedDeviceIdentity", "init end");
  }
  
  public void a(String paramString) {
    b("push_token", paramString);
  }
  
  public void b() {
    if (!this.c) {
      this.c = true;
      j();
    } 
  }
  
  public void c() {
    this.c = false;
    this.f.clear();
  }
  
  public String d() {
    String str2 = this.e.get("szlm_id");
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  @Deprecated
  public String e() {
    return "";
  }
  
  public String f() {
    if (!this.b)
      return ""; 
    String str2 = this.e.get("boxid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = str2;
      try {
        str2 = SmAntiFraud.getDeviceId();
        str1 = str2;
        StringBuilder stringBuilder = new StringBuilder();
        str1 = str2;
        stringBuilder.append("get local shumeiBoxId : ");
        str1 = str2;
        stringBuilder.append(str2);
        str1 = str2;
        Log.v("BluedDeviceIdentity", stringBuilder.toString());
        str1 = str2;
        BluedStatistics.a().j(str2);
        str1 = str2;
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    str2 = str1;
    if (str1 == null)
      str2 = ""; 
    return str2;
  }
  
  public String g() {
    String str2 = this.e.get("dvid");
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return str1;
  }
  
  public String h() {
    String str2 = this.e.get("oaid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str2 = k();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get cached oaid:");
      stringBuilder.append(str2);
      Log.v("BluedDeviceIdentity", stringBuilder.toString());
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        this.e.put("oaid", str2);
        str1 = str2;
      } 
    } 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\device_identity\library\BluedDeviceIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */