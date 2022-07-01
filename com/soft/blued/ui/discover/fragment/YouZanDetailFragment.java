package com.soft.blued.ui.discover.fragment;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.views.WebBtmOptions;
import com.blued.android.web.SimpleWebCallBack;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.model.YouZanLoginModel;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.YouZanUtils;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.youzan.androidsdk.YouzanToken;
import com.youzan.androidsdk.event.AbsAuthEvent;
import com.youzan.androidsdk.event.AbsChooserEvent;
import com.youzan.androidsdk.event.AbsShareEvent;
import com.youzan.androidsdk.event.Event;
import com.youzan.androidsdk.model.goods.GoodsShareModel;
import com.youzan.androidsdkx5.YouzanBrowser;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class YouZanDetailFragment extends BaseFragment {
  public View d;
  
  public Context e;
  
  public YouzanBrowser f;
  
  public View g;
  
  public String h;
  
  public String i;
  
  public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener j;
  
  private WebBtmOptions k;
  
  private ImageView l;
  
  private ImageView m;
  
  private ImageView n;
  
  private TextView o;
  
  private String p = "https://web.bldimg.com/cblued/static/61511555575852_.pic.1d8nopvtobuess.jpg";
  
  private boolean a(String paramString) {
    return BluedWebView.a((Context)getActivity(), paramString, (BluedWebView.WebCallback)new SimpleWebCallBack());
  }
  
  public static void show(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("KEY_URL", paramString);
    TerminalActivity.d(paramContext, YouZanDetailFragment.class, bundle);
  }
  
  public boolean V_() {
    if (!this.f.pageGoBack()) {
      getActivity().finish();
      return super.V_();
    } 
    return true;
  }
  
  public void a() {
    this.l = (ImageView)this.d.findViewById(2131296863);
    this.l.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.V_();
          }
        });
    this.m = (ImageView)this.d.findViewById(2131296862);
    this.m.setVisibility(0);
    this.m.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.n = (ImageView)this.d.findViewById(2131296867);
    this.n.setVisibility(0);
    this.n.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.f.sharePage();
          }
        });
    this.o = (TextView)this.d.findViewById(2131296857);
    this.g = this.d.findViewById(2131299007);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.f.reload();
          }
        });
    this.f = (YouzanBrowser)this.d.findViewById(2131301771);
    this.f.setWebChromeClient(new WebChromeClient(this) {
          public void onReceivedTitle(WebView param1WebView, String param1String) {
            super.onReceivedTitle(param1WebView, param1String);
            YouZanDetailFragment.a(this.a).setText(param1String);
          }
        });
    this.f.setWebViewClient(new WebViewClient(this) {
          public void onPageFinished(WebView param1WebView, String param1String) {
            super.onPageFinished(param1WebView, param1String);
            this.b.i = param1String;
          }
          
          public void onPageStarted(WebView param1WebView, String param1String, Bitmap param1Bitmap) {
            super.onPageStarted(param1WebView, param1String, param1Bitmap);
            this.b.f.setVisibility(0);
          }
          
          public void onReceivedError(WebView param1WebView, int param1Int, String param1String1, String param1String2) {
            super.onReceivedError(param1WebView, param1Int, param1String1, param1String2);
            this.b.f.setVisibility(8);
          }
          
          public void onReceivedError(WebView param1WebView, WebResourceRequest param1WebResourceRequest, WebResourceError param1WebResourceError) {
            super.onReceivedError(param1WebView, param1WebResourceRequest, param1WebResourceError);
            this.b.f.setVisibility(8);
          }
          
          public boolean shouldOverrideUrlLoading(WebView param1WebView, String param1String) {
            return YouZanDetailFragment.a(this.b, param1String);
          }
        });
  }
  
  public void k() {
    LoginRegisterHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<YouZanLoginModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<YouZanLoginModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData() && param1BluedEntityA.getSingleData() != null) {
              YouZanLoginModel youZanLoginModel = (YouZanLoginModel)param1BluedEntityA.getSingleData();
              YouzanToken youzanToken = new YouzanToken();
              youzanToken.setAccessToken(youZanLoginModel.access_token);
              Logger.a(false);
              youzanToken.setCookieKey(youZanLoginModel.cookie_key);
              youzanToken.setCookieValue(youZanLoginModel.cookie_value);
              Logger.c("ljx youzantoken access_token:", new Object[] { youZanLoginModel.access_token });
              Logger.c("ljx youzantoken cookie_key:", new Object[] { youZanLoginModel.cookie_key });
              Logger.c("ljx youzantoken cookie_value:", new Object[] { youZanLoginModel.cookie_value });
              YouZanUtils.a(this.a.e, youzanToken);
              this.a.f.sync(youzanToken);
            } 
          }
        }(IRequestHost)w_());
  }
  
  public void l() {
    this.f.subscribe((Event)new AbsAuthEvent(this) {
          public void call(Context param1Context, boolean param1Boolean) {
            if (param1Boolean)
              this.a.k(); 
          }
        });
    this.j = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener(this) {
        public void onItemClick(int param1Int) {
          if (param1Int != 2131756132) {
            if (param1Int != 2131758326) {
              if (param1Int != 2131758547)
                return; 
              InstantLog.b("web_page_options_click", 2);
              this.a.f.reload();
              return;
            } 
            InstantLog.b("web_page_options_click", 1);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.a.i));
            if (AppUtils.a(intent)) {
              this.a.startActivity(intent);
              return;
            } 
          } else {
            InstantLog.b("web_page_options_click", 0);
            if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
              ((ClipboardManager)this.a.getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple url", this.a.i));
            } else {
              ((ClipboardManager)this.a.getActivity().getSystemService("clipboard")).setText(this.a.i);
            } 
            AppMethods.d(2131756131);
          } 
        }
      };
    this.k = new WebBtmOptions((Context)getActivity(), new View.OnClickListener(this) {
          public void onClick(View param1View) {
            InstantLog.b("web_page_options_click", 3);
          }
        });
    this.f.subscribe((Event)new AbsShareEvent(this) {
          public void call(Context param1Context, GoodsShareModel param1GoodsShareModel) {
            String str;
            if (param1GoodsShareModel == null) {
              str = "null";
            } else {
              str = param1GoodsShareModel.getTitle();
            } 
            Logger.c("YouZanDetailFragment", new Object[] { "share event", str });
            if (param1GoodsShareModel != null && !StringUtils.e(param1GoodsShareModel.getLink())) {
              String str1;
              String str2;
              String str3 = BluedHttpUrl.d(param1GoodsShareModel.getLink());
              if (StringUtils.e(param1GoodsShareModel.getTitle())) {
                str = this.a.e.getResources().getString(2131759521);
              } else {
                str = param1GoodsShareModel.getTitle();
              } 
              if (StringUtils.e(param1GoodsShareModel.getDesc())) {
                str2 = this.a.e.getResources().getString(2131759520);
              } else {
                str2 = param1GoodsShareModel.getDesc();
              } 
              if (StringUtils.e(param1GoodsShareModel.getImgUrl())) {
                str1 = YouZanDetailFragment.b(this.a);
              } else {
                str1 = str1.getImgUrl();
              } 
              ShareEntity shareEntity = ShareUtils.a().a(str1, (View)this.a.f, str3, str, str2, str2, 0);
              YouZanDetailFragment.c(this.a).a(shareEntity, this.a.j);
              return;
            } 
            AppMethods.a(this.a.e.getResources().getString(2131755724));
          }
        });
    this.f.subscribe((Event)new AbsChooserEvent(this) {
          public void call(Context param1Context, Intent param1Intent, int param1Int) throws ActivityNotFoundException {
            this.a.startActivityForResult(param1Intent, param1Int);
          }
        });
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("Accept-Language", LocaleUtils.b());
    String str = ProviderHolder.a().e().b();
    if (!TextUtils.isEmpty(str))
      arrayMap.put("X-CLIENT-COLOR", str); 
    this.f.needLoading(false);
    this.f.loadUrl(this.h, (Map)arrayMap);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.f.receiveFile(paramInt1, paramIntent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    InitTaskUtil.initYouZanSDK();
    this.e = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493368, paramViewGroup, false);
      if (getArguments() != null) {
        this.h = getArguments().getString("KEY_URL");
        if (!StringUtils.e(this.h))
          try {
            this.h = URLDecoder.decode(this.h, "UTF-8");
          } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
          }  
      } 
      a();
      l();
      BluedWebView.b((Context)getActivity());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\YouZanDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */