package com.blued.android.web;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.web.CommonUrlHandler;
import com.blued.android.framework.web.DownloaderJSCallback;
import com.blued.android.framework.web.JSExecutor;
import com.blued.android.framework.web.WebDownloaderManager;
import com.blued.android.framework.web.WebUploadFile;
import com.blued.android.framework.web.cache.BluedWebViewCacheClient;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.views.WebBtmOptions;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.manager.EmotionPackWebDownload;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.net.URL;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseWebView implements View.OnCreateContextMenuListener {
  public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener a;
  
  public String b;
  
  public String c;
  
  public String d;
  
  private RectPosition e;
  
  private DisplayMetrics f;
  
  private int g;
  
  private int h;
  
  private Fragment i;
  
  private WebView j;
  
  private ViewGroup k;
  
  private WebCallback l;
  
  private WebUploadFile m;
  
  private JSExecutor n;
  
  private DownloaderJSCallback o;
  
  private String p;
  
  private View q;
  
  private WebChromeClient.CustomViewCallback r;
  
  private String s;
  
  private String t;
  
  private String u;
  
  private boolean v;
  
  private String w;
  
  private int x;
  
  private WebBtmOptions y;
  
  private Map<String, Long> z;
  
  private static boolean a(Context paramContext, Uri paramUri, JSExecutor paramJSExecutor) {
    String str1;
    String str2;
    StringBuilder stringBuilder;
    if (paramUri == null)
      return false; 
    if (paramJSExecutor == null)
      return false; 
    String str3 = paramUri.getQueryParameter("action");
    if (TextUtils.isEmpty(str3))
      return false; 
    if ("remove_emotion".equals(str3)) {
      str1 = paramUri.getQueryParameter("fun");
      if (!TextUtils.isEmpty(str1)) {
        str2 = paramUri.getQueryParameter("code");
        stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(str1);
        stringBuilder.append("('");
        stringBuilder.append(1);
        stringBuilder.append("', '");
        stringBuilder.append(str2);
        stringBuilder.append("')");
        str1 = stringBuilder.toString();
        paramJSExecutor.a(paramJSExecutor.b(), str1);
      } 
      return false;
    } 
    if ("liveplay".equals(stringBuilder)) {
      String str6 = str2.getQueryParameter("lid");
      String str5 = str2.getQueryParameter("uid");
      String str4 = str5;
      if (!TextUtils.isEmpty(str5))
        str4 = EncryptTool.a(str5); 
      str5 = str2.getQueryParameter("from");
      str2 = str5;
      if (TextUtils.isEmpty(str5))
        str2 = "web"; 
      LiveRoomInfoChannel.a((Context)str1, new LiveRoomData(CommonTools.a(str6), 0, str2, str4, "", "", 0));
      return true;
    } 
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, JSExecutor paramJSExecutor) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("preOverrideUrlLoad(), url:");
    stringBuilder.append(paramString);
    Logger.a("webTest", new Object[] { stringBuilder.toString() });
    if (TextUtils.isEmpty(paramString))
      return true; 
    if (CommonUrlHandler.a(paramContext, paramString))
      return true; 
    Uri uri = BluedURIRouter.a().d(paramString);
    if (a(paramContext, uri, paramJSExecutor) || BluedURIRouter.a().a(paramContext, uri)) {
      InstantLog.a("url_to_native", paramString);
      return true;
    } 
    if (!paramString.startsWith("http://") && !paramString.startsWith("https://") && !paramString.startsWith("blued://") && !paramString.startsWith("iblued://") && !paramString.startsWith("www.")) {
      Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      try {
        if (AppMethods.a(intent)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("system handle it: ");
          stringBuilder1.append(paramString);
          Logger.a("webTest", new Object[] { stringBuilder1.toString() });
          paramContext.startActivity(intent);
          return true;
        } 
      } catch (SecurityException securityException) {
        securityException.printStackTrace();
      } 
      return true;
    } 
    return false;
  }
  
  private boolean a(String paramString) {
    boolean bool2 = a((Context)this.i.getActivity(), paramString, this.n);
    boolean bool1 = bool2;
    if (!bool2)
      bool1 = b(paramString); 
    return bool1;
  }
  
  private boolean b(String paramString) {
    BluedUrlParser bluedUrlParser = BluedUrlParser.a(paramString);
    boolean bool1 = false;
    int i = 0;
    if (bluedUrlParser == null)
      return false; 
    if (!CommonTools.a(this.i))
      return false; 
    boolean bool = "changetitle".equals(bluedUrlParser.a());
    WebCallback webCallback2 = null;
    String str1 = null;
    String str2 = null;
    if (bool) {
      paramString = str2;
      if (bluedUrlParser.b() != null)
        paramString = (String)bluedUrlParser.b().get("title"); 
      if (!TextUtils.isEmpty(paramString)) {
        this.u = paramString;
        webCallback2 = this.l;
        if (webCallback2 != null)
          webCallback2.a(this, paramString); 
      } 
      return true;
    } 
    if ("download".equals(bluedUrlParser.a())) {
      String str;
      if (bluedUrlParser.b() != null) {
        str = (String)bluedUrlParser.b().get("opt");
        str1 = (String)bluedUrlParser.b().get("code");
        paramString = (String)bluedUrlParser.b().get("url");
      } else {
        str1 = null;
        paramString = str1;
      } 
      if ("emotionpack".equals(str)) {
        EmotionPackWebDownload.a((Context)this.i.getActivity(), str1, this.n.b(), str);
        return true;
      } 
      if (!TextUtils.isEmpty(paramString))
        WebDownloaderManager.a().a(this.n.b(), paramString, str, str1); 
      return true;
    } 
    if ("jscb".equals(bluedUrlParser.a())) {
      String str;
      if (bluedUrlParser.b() != null) {
        str = (String)bluedUrlParser.b().get("opt");
        paramString = (String)bluedUrlParser.b().get("fun");
      } else {
        paramString = null;
        str = str1;
      } 
      if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(paramString)) {
        if ("register_download".equals(str)) {
          if (this.o == null) {
            this.o = new DownloaderJSCallback(this.n);
            WebDownloaderManager.a().a(this.o);
          } 
          this.o.a(this.n.b(), paramString);
          return true;
        } 
        if ("emotion_list".equals(str)) {
          str = EmotionManager.g();
          JSExecutor jSExecutor = this.n;
          str2 = jSExecutor.b();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("javascript:");
          stringBuilder.append(paramString);
          stringBuilder.append("('");
          stringBuilder.append(str);
          stringBuilder.append("')");
          jSExecutor.a(str2, stringBuilder.toString());
          return true;
        } 
        if ("get_uid".equals(str)) {
          str = UserInfo.a().i().getUid();
          JSExecutor jSExecutor = this.n;
          str2 = jSExecutor.b();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("javascript:");
          stringBuilder.append(paramString);
          stringBuilder.append("('");
          stringBuilder.append(str);
          stringBuilder.append("')");
          jSExecutor.a(str2, stringBuilder.toString());
        } 
      } 
      return true;
    } 
    if ("close".equals(bluedUrlParser.a())) {
      this.i.getActivity().finish();
      return false;
    } 
    if ("webshare".equals(bluedUrlParser.a())) {
      String str3;
      InstantLog.a("url_to_native", paramString);
      String str4 = this.s;
      Map map = bluedUrlParser.b();
      str2 = "";
      if (map != null) {
        paramString = (String)bluedUrlParser.b().get("type");
        if (!StringUtils.e(paramString))
          i = Integer.valueOf(paramString).intValue(); 
        if (map.containsKey("title")) {
          paramString = (String)map.get("title");
        } else {
          paramString = "";
        } 
        if (map.containsKey("content")) {
          str3 = (String)map.get("content");
        } else {
          str3 = "";
        } 
        if (map.containsKey("to")) {
          str1 = (String)map.get("to");
        } else {
          str1 = "";
        } 
        if (map.containsKey("url"))
          str4 = (String)map.get("url"); 
        if (map.containsKey("src_url"))
          str2 = (String)map.get("src_url"); 
      } else {
        str1 = "";
        paramString = str1;
        str3 = paramString;
        str2 = str3;
        i = 0;
      } 
      a(str1, str4, paramString, str3, i, str2);
      return true;
    } 
    WebCallback webCallback1 = this.l;
    bool = bool1;
    if (webCallback1 != null) {
      bool = bool1;
      if (webCallback1.a(this, bluedUrlParser))
        bool = true; 
    } 
    return bool;
  }
  
  public WebView a() {
    return this.j;
  }
  
  public void a(String paramString1, String paramString2) {
    boolean bool;
    if (this.x == 9) {
      bool = true;
    } else {
      bool = false;
    } 
    AppHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<JudgeWebUrlParseJson>>(this, paramString1, paramString2) {
          public void a(BluedEntityA<JudgeWebUrlParseJson> param1BluedEntityA) {
            if (CommonTools.a(BaseWebView.c(this.c)) && param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              int i = ((JudgeWebUrlParseJson)param1BluedEntityA.data.get(0)).verification;
              if (BaseWebView.a(this.c) != null)
                BaseWebView.a(this.c).b(this.c, i); 
              if (i == -1) {
                if (!WebBlackListPreference.c(this.a))
                  WebBlackListPreference.a(this.a); 
                if (!WebBlackListPreference.c(this.b)) {
                  WebBlackListPreference.a(this.b);
                  return;
                } 
              } else {
                WebBlackListPreference.b(this.a);
                WebBlackListPreference.b(this.b);
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (BaseWebView.a(this.c) != null)
              BaseWebView.a(this.c).b(this.c, 0); 
            return true;
          }
        }bool, paramString2, paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5) {
    String str1;
    try {
      str1 = (new URL(paramString2)).getHost();
    } catch (Exception exception) {
      str1 = "about:blank";
    } 
    String str2 = this.i.getActivity().getString(2131759342);
    WebView webView2 = this.j;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("javascript:");
    stringBuilder2.append(str2);
    webView2.loadUrl(stringBuilder2.toString());
    WebView webView1 = this.j;
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
  
  public void b() {
    String str = this.i.getActivity().getString(2131759341);
    WebView webView = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("javascript:");
    stringBuilder.append(str);
    webView.loadUrl(stringBuilder.toString());
    this.j.loadUrl("javascript:getOptionMenuFunction()");
  }
  
  public void c() {
    this.j.loadUrl("javascript:getBannerPosition()");
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {
    MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener(this) {
        public boolean onMenuItemClick(MenuItem param1MenuItem) {
          if (param1MenuItem.getItemId() == 1 && !TextUtils.isEmpty(BaseWebView.q(this.a))) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(RecyclingUtils.a());
            stringBuilder1.append(File.separator);
            stringBuilder1.append("blued");
            String str1 = stringBuilder1.toString();
            File file = new File(str1);
            if (!file.exists())
              file.mkdir(); 
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(Md5.a(BaseWebView.q(this.a).toLowerCase().trim()));
            stringBuilder2.append(".jpg");
            String str2 = stringBuilder2.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str1);
            stringBuilder3.append(File.separator);
            stringBuilder3.append(str2);
            str1 = stringBuilder3.toString();
            FileDownloader.a(BaseWebView.q(this.a), str1, new FileHttpResponseHandler(this, str2, str1) {
                  public void a(File param2File) {
                    PermissionHelper.e(new PermissionCallbacks(this) {
                          public void a(String[] param3ArrayOfString) {}
                          
                          public void aa_() {
                            ThreadManager.a().a(new ThreadExecutor(this, "CopyImageToPicDir") {
                                  public void execute() {
                                    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(file.getAbsolutePath());
                                    stringBuilder.append(File.separator);
                                    stringBuilder.append("blued");
                                    stringBuilder.append(File.separator);
                                    stringBuilder.append(this.a.a.a);
                                    String str = stringBuilder.toString();
                                    FileUtils.a(this.a.a.b, str, this.a.a.a);
                                    AppInfo.n().post(new -$$Lambda$BaseWebView$6$1$1$1$x722J3Sq6N_eRbwTFzOj0rWbdDo(str));
                                  }
                                });
                          }
                        });
                  }
                  
                  public void a(Throwable param2Throwable, int param2Int, File param2File) {
                    super.onFailure(param2Throwable, param2Int, param2File);
                    AppMethods.d(2131757053);
                  }
                }null);
            return true;
          } 
          return false;
        }
      };
    if (paramView instanceof WebView) {
      WebView.HitTestResult hitTestResult = ((WebView)paramView).getHitTestResult();
      if (hitTestResult != null) {
        int i = hitTestResult.getType();
        if (i == 5 || i == 8) {
          this.w = hitTestResult.getExtra();
          paramContextMenu.add(0, 1, 0, 2131759343).setOnMenuItemClickListener(onMenuItemClickListener);
        } 
      } 
    } 
  }
  
  final class InJavaScriptBluedNativeObject {
    @JavascriptInterface
    public void getH5ViewPagerInfo(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      BaseWebView baseWebView = BaseWebView.this;
      BaseWebView.a(baseWebView, new BaseWebView.RectPosition(baseWebView, param1Int1, param1Int2, param1Int3, param1Int4));
    }
    
    @JavascriptInterface
    public void registerResumeJs(String param1String) {
      BaseWebView.d(BaseWebView.this, param1String);
    }
  }
  
  final class InJavaScriptLocalObj {
    @JavascriptInterface
    public void setOptionMenu(String param1String) {
      BaseWebView.k(this.a).post(new Runnable(this, param1String) {
            public void run() {
              BaseWebView.a(this.b.a).a(this.a);
            }
          });
    }
    
    @JavascriptInterface
    public void shareTo(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      if (BaseWebView.c(this.a) == null)
        return; 
      Runnable runnable = new Runnable(this, param1String1, param1String3, param1String4, param1String5) {
          public void run() {
            try {
              String str3;
              FragmentActivity fragmentActivity = BaseWebView.c(this.e.a).getActivity();
              JSONObject jSONObject = new JSONObject(this.a);
              if (StringUtils.e(jSONObject.getString("title")))
                jSONObject.put("title", "No Title"); 
              JSONArray jSONArray = jSONObject.getJSONArray("thumb");
              if (jSONArray.length() > 0) {
                str3 = jSONArray.getString(0);
              } else {
                str3 = null;
              } 
              String str2 = jSONObject.getString("description");
              String str1 = jSONObject.getString("title");
              String str4 = jSONObject.getString("url");
              int i = Integer.valueOf(this.b).intValue();
              if (!StringUtils.e(this.c)) {
                str1 = this.c;
              } else if (StringUtils.e(str1)) {
                if (!StringUtils.e(BaseWebView.r(this.e.a))) {
                  str1 = BaseWebView.r(this.e.a);
                } else {
                  str1 = fragmentActivity.getResources().getString(2131755445);
                } 
              } 
              if (!StringUtils.e(this.d)) {
                str2 = this.d;
              } else if (StringUtils.e(str2) || str2.equalsIgnoreCase(str1)) {
                str2 = BaseWebView.o(this.e.a);
              } 
              if (BaseWebView.s(this.e.a) == 11)
                str1 = fragmentActivity.getResources().getString(2131759227); 
              ShareEntity shareEntity = ShareUtils.a().a(str3, (View)this.e.a.a(), str4, str1, str2, str2, i);
              shareEntity.p = jSONObject.getString("activity_secret_code");
              shareEntity.q = jSONObject.getString("activity_secret_text");
              shareEntity.r = jSONObject.getString("activity_secret_copy");
              this.e.a.b = jSONObject.getString("activity_secret_code");
              this.e.a.c = jSONObject.getString("activity_secret_text");
              this.e.a.d = jSONObject.getString("activity_secret_copy");
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("secretCode:");
              stringBuilder.append(this.e.a.b);
              Log.v("drb", stringBuilder.toString());
              stringBuilder = new StringBuilder();
              stringBuilder.append("secretText:");
              stringBuilder.append(this.e.a.c);
              Log.v("drb", stringBuilder.toString());
              stringBuilder = new StringBuilder();
              stringBuilder.append("secretCopy:");
              stringBuilder.append(this.e.a.d);
              Log.v("drb", stringBuilder.toString());
              BaseWebView.t(this.e.a).a(shareEntity, this.e.a.a);
              return;
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
              return;
            } 
          }
        };
      if (BaseWebView.c(this.a) instanceof BaseFragment)
        ((BaseFragment)BaseWebView.c(this.a)).a(runnable, 500L); 
      if (BaseWebView.c(this.a) instanceof BaseDialogFragment)
        ((BaseDialogFragment)BaseWebView.c(this.a)).a(runnable, 500L); 
    }
  }
  
  class null implements Runnable {
    null(BaseWebView this$0, String param1String1, String param1String2, String param1String3, String param1String4) {}
    
    public void run() {
      try {
        String str3;
        FragmentActivity fragmentActivity = BaseWebView.c(this.e.a).getActivity();
        JSONObject jSONObject = new JSONObject(this.a);
        if (StringUtils.e(jSONObject.getString("title")))
          jSONObject.put("title", "No Title"); 
        JSONArray jSONArray = jSONObject.getJSONArray("thumb");
        if (jSONArray.length() > 0) {
          str3 = jSONArray.getString(0);
        } else {
          str3 = null;
        } 
        String str2 = jSONObject.getString("description");
        String str1 = jSONObject.getString("title");
        String str4 = jSONObject.getString("url");
        int i = Integer.valueOf(this.b).intValue();
        if (!StringUtils.e(this.c)) {
          str1 = this.c;
        } else if (StringUtils.e(str1)) {
          if (!StringUtils.e(BaseWebView.r(this.e.a))) {
            str1 = BaseWebView.r(this.e.a);
          } else {
            str1 = fragmentActivity.getResources().getString(2131755445);
          } 
        } 
        if (!StringUtils.e(this.d)) {
          str2 = this.d;
        } else if (StringUtils.e(str2) || str2.equalsIgnoreCase(str1)) {
          str2 = BaseWebView.o(this.e.a);
        } 
        if (BaseWebView.s(this.e.a) == 11)
          str1 = fragmentActivity.getResources().getString(2131759227); 
        ShareEntity shareEntity = ShareUtils.a().a(str3, (View)this.e.a.a(), str4, str1, str2, str2, i);
        shareEntity.p = jSONObject.getString("activity_secret_code");
        shareEntity.q = jSONObject.getString("activity_secret_text");
        shareEntity.r = jSONObject.getString("activity_secret_copy");
        this.e.a.b = jSONObject.getString("activity_secret_code");
        this.e.a.c = jSONObject.getString("activity_secret_text");
        this.e.a.d = jSONObject.getString("activity_secret_copy");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("secretCode:");
        stringBuilder.append(this.e.a.b);
        Log.v("drb", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("secretText:");
        stringBuilder.append(this.e.a.c);
        Log.v("drb", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("secretCopy:");
        stringBuilder.append(this.e.a.d);
        Log.v("drb", stringBuilder.toString());
        BaseWebView.t(this.e.a).a(shareEntity, this.e.a.a);
        return;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        return;
      } 
    }
  }
  
  class null implements Runnable {
    null(BaseWebView this$0, String param1String) {}
    
    public void run() {
      BaseWebView.a(this.b.a).a(this.a);
    }
  }
  
  class RectPosition {
    private int b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    public RectPosition(BaseWebView this$0, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.b = param1Int2;
      this.c = param1Int1;
      this.d = param1Int3;
      this.e = param1Int4;
    }
  }
  
  public static interface WebCallback {
    void a(BaseWebView param1BaseWebView, int param1Int);
    
    void a(BaseWebView param1BaseWebView, int param1Int, String param1String1, String param1String2);
    
    void a(BaseWebView param1BaseWebView, String param1String);
    
    void a(BaseWebView param1BaseWebView, String param1String, boolean param1Boolean);
    
    void a(String param1String);
    
    boolean a(BaseWebView param1BaseWebView, BluedUrlParser param1BluedUrlParser);
    
    void b(BaseWebView param1BaseWebView, int param1Int);
    
    void b(BaseWebView param1BaseWebView, String param1String, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\web\BaseWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */