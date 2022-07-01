package com.geetest.onepassv2.f;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.geetest.onelogin.j.h;
import com.geetest.onepassv2.listener.OnePassListener;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends AsyncTask<String, Void, String> {
  private com.geetest.onepassv2.a.a a;
  
  private OnePassListener b;
  
  private Long c;
  
  private Network d;
  
  private ConnectivityManager e;
  
  private ConnectivityManager.NetworkCallback f;
  
  public a(com.geetest.onepassv2.a.a parama, OnePassListener paramOnePassListener, Network paramNetwork, ConnectivityManager paramConnectivityManager, ConnectivityManager.NetworkCallback paramNetworkCallback) {
    this.a = parama;
    this.b = paramOnePassListener;
    this.d = paramNetwork;
    this.e = paramConnectivityManager;
    this.f = paramNetworkCallback;
  }
  
  protected String a(String... paramVarArgs) {
    if (isCancelled())
      return null; 
    this.c = Long.valueOf(System.currentTimeMillis());
    h.b("电信运营商开始请求");
    return com.geetest.onepassv2.g.a.a(paramVarArgs[0], null, this.d, this.a.b());
  }
  
  protected void a(String paramString) {
    h.b("电信运营商请求结束");
    if (this.e != null && this.f != null) {
      if (Build.VERSION.SDK_INT >= 21)
        this.e.unregisterNetworkCallback(this.f); 
    } else {
      ConnectivityManager connectivityManager = this.e;
      if (connectivityManager != null)
        com.geetest.onepassv2.e.a.b(connectivityManager, 0, "enableHIPRI"); 
    } 
    com.geetest.onepassv2.a.a a1 = this.a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis() - this.c.longValue());
    stringBuilder2.append("");
    a1.r(stringBuilder2.toString());
    if (isCancelled())
      return; 
    if (TextUtils.isEmpty(paramString)) {
      com.geetest.onepassv2.listener.a.a(this.b, com.geetest.onelogin.b.a.E, "CT operator request error", this.a);
      h.c("电信运营商请求错误");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("电信运营商请求成功，结果为: ");
    stringBuilder1.append(paramString);
    h.b(stringBuilder1.toString());
    try {
      String str = com.geetest.onelogin.e.a.a.c((new JSONObject(paramString)).getString("data"), "e1c3d0de067d4666");
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("电信运营商请求解密成功，结果为: ");
      stringBuilder2.append(str);
      h.b(stringBuilder2.toString());
      str = (new JSONObject(str)).getString("accessCode");
      this.a.q(str);
      com.geetest.onepassv2.listener.a.a(this.b, this.a);
      return;
    } catch (Exception exception) {
      try {
        com.geetest.onepassv2.listener.a.a(this.b, com.geetest.onelogin.b.a.E, new JSONObject(paramString), this.a);
      } catch (JSONException jSONException) {
        com.geetest.onepassv2.listener.a.a(this.b, com.geetest.onelogin.b.a.E, paramString, this.a);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("电信运营商接口返回值异常，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */