package com.facebook.stetho.inspector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.facebook.stetho.server.http.PathMatcher;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChromeDiscoveryHandler implements HttpHandler {
  private static final String PAGE_ID = "1";
  
  private static final String PATH_ACTIVATE = "/json/activate/1";
  
  private static final String PATH_PAGE_LIST = "/json";
  
  private static final String PATH_VERSION = "/json/version";
  
  private static final String PROTOCOL_VERSION = "1.1";
  
  private static final String USER_AGENT = "Stetho";
  
  private static final String WEBKIT_REV = "@188492";
  
  private static final String WEBKIT_VERSION = "537.36 (@188492)";
  
  private final Context mContext;
  
  private final String mInspectorPath;
  
  @Nullable
  private LightHttpBody mPageListResponse;
  
  @Nullable
  private LightHttpBody mVersionResponse;
  
  public ChromeDiscoveryHandler(Context paramContext, String paramString) {
    this.mContext = paramContext;
    this.mInspectorPath = paramString;
  }
  
  private CharSequence getAppLabel() {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getApplicationInfo());
  }
  
  private String getAppLabelAndVersion() {
    StringBuilder stringBuilder = new StringBuilder();
    PackageManager packageManager = this.mContext.getPackageManager();
    stringBuilder.append(getAppLabel());
    stringBuilder.append('/');
    try {
      stringBuilder.append((packageManager.getPackageInfo(this.mContext.getPackageName(), 0)).versionName);
      return stringBuilder.toString();
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new RuntimeException(nameNotFoundException);
    } 
  }
  
  private void handleActivate(LightHttpResponse paramLightHttpResponse) {
    setSuccessfulResponse(paramLightHttpResponse, LightHttpBody.create("Target activation ignored\n", "text/plain"));
  }
  
  private void handlePageList(LightHttpResponse paramLightHttpResponse) throws JSONException {
    if (this.mPageListResponse == null) {
      JSONArray jSONArray = new JSONArray();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("type", "app");
      jSONObject.put("title", makeTitle());
      jSONObject.put("id", "1");
      jSONObject.put("description", "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ws://");
      stringBuilder.append(this.mInspectorPath);
      jSONObject.put("webSocketDebuggerUrl", stringBuilder.toString());
      jSONObject.put("devtoolsFrontendUrl", (new Uri.Builder()).scheme("http").authority("chrome-devtools-frontend.appspot.com").appendEncodedPath("serve_rev").appendEncodedPath("@188492").appendEncodedPath("devtools.html").appendQueryParameter("ws", this.mInspectorPath).build().toString());
      jSONArray.put(jSONObject);
      this.mPageListResponse = LightHttpBody.create(jSONArray.toString(), "application/json");
    } 
    setSuccessfulResponse(paramLightHttpResponse, this.mPageListResponse);
  }
  
  private void handleVersion(LightHttpResponse paramLightHttpResponse) throws JSONException {
    if (this.mVersionResponse == null) {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("WebKit-Version", "537.36 (@188492)");
      jSONObject.put("User-Agent", "Stetho");
      jSONObject.put("Protocol-Version", "1.1");
      jSONObject.put("Browser", getAppLabelAndVersion());
      jSONObject.put("Android-Package", this.mContext.getPackageName());
      this.mVersionResponse = LightHttpBody.create(jSONObject.toString(), "application/json");
    } 
    setSuccessfulResponse(paramLightHttpResponse, this.mVersionResponse);
  }
  
  private String makeTitle() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getAppLabel());
    stringBuilder.append(" (powered by Stetho)");
    String str = ProcessUtil.getProcessName();
    int i = str.indexOf(':');
    if (i >= 0)
      stringBuilder.append(str.substring(i)); 
    return stringBuilder.toString();
  }
  
  private static void setSuccessfulResponse(LightHttpResponse paramLightHttpResponse, LightHttpBody paramLightHttpBody) {
    paramLightHttpResponse.code = 200;
    paramLightHttpResponse.reasonPhrase = "OK";
    paramLightHttpResponse.body = paramLightHttpBody;
  }
  
  public boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse) {
    String str = paramLightHttpRequest.uri.getPath();
    try {
      if ("/json/version".equals(str)) {
        handleVersion(paramLightHttpResponse);
      } else if ("/json".equals(str)) {
        handlePageList(paramLightHttpResponse);
      } else if ("/json/activate/1".equals(str)) {
        handleActivate(paramLightHttpResponse);
      } else {
        paramLightHttpResponse.code = 501;
        paramLightHttpResponse.reasonPhrase = "Not implemented";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No support for ");
        stringBuilder.append(str);
        stringBuilder.append("\n");
        paramLightHttpResponse.body = LightHttpBody.create(stringBuilder.toString(), "text/plain");
      } 
    } catch (JSONException jSONException) {
      paramLightHttpResponse.code = 500;
      paramLightHttpResponse.reasonPhrase = "Internal server error";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(jSONException.toString());
      stringBuilder.append("\n");
      paramLightHttpResponse.body = LightHttpBody.create(stringBuilder.toString(), "text/plain");
    } 
    return true;
  }
  
  public void register(HandlerRegistry paramHandlerRegistry) {
    paramHandlerRegistry.register((PathMatcher)new ExactPathMatcher("/json"), this);
    paramHandlerRegistry.register((PathMatcher)new ExactPathMatcher("/json/version"), this);
    paramHandlerRegistry.register((PathMatcher)new ExactPathMatcher("/json/activate/1"), this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\ChromeDiscoveryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */