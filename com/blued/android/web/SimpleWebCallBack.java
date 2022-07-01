package com.blued.android.web;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.views.WebBtmOptions;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleWebCallBack implements BluedWebView.WebCallback {
  public String a = "";
  
  public WebBtmOptions b;
  
  private ShareOptionRecyclerAdapter.ShareOptionsItemClickListener c;
  
  public void a() {}
  
  public void a(BluedWebView paramBluedWebView, int paramInt) {}
  
  public void a(BluedWebView paramBluedWebView, int paramInt, String paramString1, String paramString2) {}
  
  public void a(BluedWebView paramBluedWebView, String paramString) {}
  
  public void a(BluedWebView paramBluedWebView, String paramString, boolean paramBoolean) {}
  
  public void a(ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    this.c = paramShareOptionsItemClickListener;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString1, String paramString2, Fragment paramFragment, BluedWebView paramBluedWebView) {
    boolean bool;
    if (paramBluedWebView.b() == 9) {
      bool = true;
    } else {
      bool = false;
    } 
    AppHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<JudgeWebUrlParseJson>>(this, paramFragment, paramBluedWebView, paramString1, paramString2) {
          public void a(BluedEntityA<JudgeWebUrlParseJson> param1BluedEntityA) {
            if (CommonTools.a(this.a) && param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              int i = ((JudgeWebUrlParseJson)param1BluedEntityA.data.get(0)).verification;
              this.e.b(this.b, i);
              if (i == -1) {
                if (!WebBlackListPreference.c(this.c))
                  WebBlackListPreference.a(this.c); 
                if (!WebBlackListPreference.c(this.d)) {
                  WebBlackListPreference.a(this.d);
                  return;
                } 
              } else {
                WebBlackListPreference.b(this.c);
                WebBlackListPreference.b(this.d);
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.e.b(this.b, 0);
            return true;
          }
        }bool, paramString2, paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, BluedWebView paramBluedWebView) {
    String str1;
    try {
      str1 = (new URL(paramString2)).getHost();
    } catch (Exception exception) {
      str1 = "about:blank";
    } 
    String str2 = AppInfo.d().getString(2131759342);
    if (paramBluedWebView.c() != null) {
      WebView webView2 = paramBluedWebView.c();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("javascript:");
      stringBuilder2.append(str2);
      webView2.loadUrl(stringBuilder2.toString());
      WebView webView1 = paramBluedWebView.c();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("javascript:getShareInfoFunction('");
      stringBuilder1.append(paramString2);
      stringBuilder1.append("','");
      stringBuilder1.append(str1);
      stringBuilder1.append("','");
      stringBuilder1.append(paramString3);
      stringBuilder1.append("','");
      stringBuilder1.append(paramString4);
      stringBuilder1.append("','");
      stringBuilder1.append(paramString1);
      stringBuilder1.append("','");
      stringBuilder1.append(paramInt);
      stringBuilder1.append("','");
      stringBuilder1.append(paramString5);
      stringBuilder1.append("')");
      webView1.loadUrl(stringBuilder1.toString());
    } 
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, Map<String, String> paramMap, BluedWebView paramBluedWebView) {
    String str;
    if (paramMap != null && paramMap.containsKey("src_url")) {
      str = paramMap.get("src_url");
    } else {
      str = "";
    } 
    a(paramString1, paramString2, paramString3, paramString4, paramInt, str, paramBluedWebView);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, BluedWebView paramBluedWebView) {
    try {
      Logger.a("web_json", paramString1);
      if (this.b == null)
        this.b = new WebBtmOptions((Context)paramBluedWebView.a().getActivity(), -$$Lambda$SimpleWebCallBack$dOeMybZGPQq_R3nRQ4bp658noT0.INSTANCE); 
      FragmentActivity fragmentActivity = paramBluedWebView.a().getActivity();
      JSONObject jSONObject = new JSONObject(paramString1);
      if (StringUtils.e(jSONObject.getString("title")))
        jSONObject.put("title", "No Title"); 
      JSONArray jSONArray = jSONObject.getJSONArray("thumb");
      if (jSONArray.length() > 0) {
        paramString4 = jSONArray.getString(0);
      } else {
        paramString4 = null;
      } 
      paramString2 = jSONObject.getString("description");
      String str = jSONObject.getString("title");
      paramString5 = jSONObject.getString("url");
      paramString6 = jSONObject.getString("bd_target_url");
      if (!TextUtils.isEmpty(paramString6))
        paramString5 = paramString6; 
      int i = Integer.valueOf(paramString3).intValue();
      if (!StringUtils.e(paramString8)) {
        str = paramString8;
      } else if (StringUtils.e(str)) {
        if (!StringUtils.e(paramBluedWebView.e())) {
          str = paramBluedWebView.e();
        } else {
          str = fragmentActivity.getResources().getString(2131755445);
        } 
      } 
      if (!StringUtils.e(paramString9)) {
        paramString2 = paramString9;
      } else if (StringUtils.e(paramString2) || paramString2.equalsIgnoreCase(str)) {
        paramString2 = paramBluedWebView.d();
      } 
      if (paramBluedWebView.b() == 11)
        str = fragmentActivity.getResources().getString(2131759227); 
      ShareEntity shareEntity = ShareUtils.a().a(paramString4, (View)paramBluedWebView.c(), paramString5, str, paramString2, paramString2, i);
      shareEntity.p = jSONObject.getString("activity_secret_code");
      shareEntity.q = jSONObject.getString("activity_secret_text");
      shareEntity.r = jSONObject.getString("activity_secret_copy");
      this.a = jSONObject.getString("activity_secret_text");
      this.b.a(shareEntity, this.c);
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  public void a(Map<String, String> paramMap, BluedWebView paramBluedWebView) {}
  
  public boolean a(Context paramContext, String paramString) {
    if (paramString == null)
      return false; 
    Uri uri = BluedURIRouter.a().d(paramString);
    if (uri == null)
      return false; 
    paramString = uri.getQueryParameter("action");
    if (TextUtils.isEmpty(paramString))
      return false; 
    if ("liveplay".equals(paramString)) {
      String str3 = uri.getQueryParameter("lid");
      String str1 = uri.getQueryParameter("uid");
      paramString = str1;
      if (!TextUtils.isEmpty(str1))
        paramString = EncryptTool.a(str1); 
      String str2 = uri.getQueryParameter("from");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = "web"; 
      LiveRoomData liveRoomData = new LiveRoomData(CommonTools.a(str3), 0, str1, paramString, "", "", 0);
      liveRoomData.liveFrom = LiveUtils.a();
      liveRoomData.recommendType = LiveUtils.b();
      liveRoomData.livePosition = LiveUtils.c();
      LiveRoomInfoChannel.a(paramContext, liveRoomData);
      return true;
    } 
    return false;
  }
  
  public boolean a(BluedWebView paramBluedWebView, BluedUrlParser paramBluedUrlParser) {
    return false;
  }
  
  public void b() {}
  
  public void b(BluedWebView paramBluedWebView, int paramInt) {}
  
  public void b(BluedWebView paramBluedWebView, String paramString, boolean paramBoolean) {}
  
  public boolean b(String paramString) {
    return WebBlackListPreference.c(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\web\SimpleWebCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */