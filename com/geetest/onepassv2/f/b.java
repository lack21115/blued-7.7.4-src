package com.geetest.onepassv2.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.e.a.c;
import com.geetest.onelogin.j.h;
import com.geetest.onepassv2.a.a;
import com.geetest.onepassv2.b.c;
import com.geetest.onepassv2.e.a;
import com.geetest.onepassv2.g.a;
import com.geetest.onepassv2.listener.OnePassListener;
import com.geetest.onepassv2.listener.a;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends AsyncTask<String, Void, String> {
  private a a;
  
  private OnePassListener b;
  
  private Context c;
  
  private Long d;
  
  private Network e;
  
  private ConnectivityManager f;
  
  private ConnectivityManager.NetworkCallback g;
  
  public b(a parama, OnePassListener paramOnePassListener, Context paramContext, Network paramNetwork, ConnectivityManager paramConnectivityManager, ConnectivityManager.NetworkCallback paramNetworkCallback) {
    this.a = parama;
    this.b = paramOnePassListener;
    this.c = paramContext;
    this.e = paramNetwork;
    this.f = paramConnectivityManager;
    this.g = paramNetworkCallback;
  }
  
  protected String a(String... paramVarArgs) {
    if (isCancelled())
      return null; 
    this.d = Long.valueOf(System.currentTimeMillis());
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("timeStamp", System.currentTimeMillis());
      jSONObject.put("pIp", c.a(this.c));
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("构造联通请求数据错误: ");
      stringBuilder.append(jSONException.toString());
      h.c(stringBuilder.toString());
    } 
    String str1 = com.geetest.onepassv2.g.b.a(this.c);
    String str2 = com.geetest.onepassv2.g.b.a(this.c, str1, this.a.x());
    h.b("联通运营商开始请求");
    try {
      return a.a(paramVarArgs[0], c.a(jSONObject.toString(), this.a.x()), this.a.w(), this.e, str1, str2, this.a);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("联通运营商构造参数错误: ");
      stringBuilder.append(exception.toString());
      h.b(stringBuilder.toString());
      return null;
    } 
  }
  
  protected void a(String paramString) {
    h.b("联通运营商请求结束");
    if (this.f != null && this.g != null) {
      if (Build.VERSION.SDK_INT >= 21)
        this.f.unregisterNetworkCallback(this.g); 
    } else {
      ConnectivityManager connectivityManager = this.f;
      if (connectivityManager != null)
        a.b(connectivityManager, 0, "enableHIPRI"); 
    } 
    a a1 = this.a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis() - this.d.longValue());
    stringBuilder2.append("");
    a1.r(stringBuilder2.toString());
    if (isCancelled())
      return; 
    if (TextUtils.isEmpty(paramString)) {
      h.c("联通运营商请求错误");
      a.a(this.b, a.G, "CU operator request error", this.a);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("联通运营商请求成功，结果为: ");
    stringBuilder1.append(paramString);
    h.b(stringBuilder1.toString());
    try {
      String str;
      JSONObject jSONObject = new JSONObject(paramString);
      if ("0".equals(jSONObject.getString("code"))) {
        str = URLDecoder.decode(c.b(jSONObject.getString("data"), this.a.x()), "utf-8");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("联通运营商请求解密成功，结果为: ");
        stringBuilder2.append(str);
        h.b(stringBuilder2.toString());
        str = (new JSONObject(str)).getString("accessCode");
        this.a.q(str);
        a.a(this.b, this.a);
        return;
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("联通运营商请求成功，获取 token 失败: ");
      stringBuilder2.append(paramString);
      h.c(stringBuilder2.toString());
      a.a(this.b, a.G, (JSONObject)str, this.a);
      return;
    } catch (Exception exception) {
      try {
        a.a(this.b, a.G, new JSONObject(paramString), this.a);
      } catch (JSONException jSONException) {
        a.a(this.b, a.G, paramString, this.a);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("电信运营商接口返回值异常，错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */