package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.ServerSetting;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.ThreadManager;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthAgent extends BaseApi {
  public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
  
  public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
  
  public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
  
  public static String SECURE_LIB_NAME;
  
  public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
  
  public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
  
  private IUiListener a;
  
  private String b;
  
  private WeakReference<Activity> c;
  
  static {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(SECURE_LIB_FILE_NAME);
    stringBuilder2.append(".so");
    SECURE_LIB_NAME = stringBuilder2.toString();
    String str = Build.CPU_ABI;
    if (str != null && !str.equals("")) {
      if (str.equalsIgnoreCase("arm64-v8a")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_64";
        stringBuilder = new StringBuilder();
        stringBuilder.append(SECURE_LIB_FILE_NAME);
        stringBuilder.append(".so");
        SECURE_LIB_NAME = stringBuilder.toString();
        f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        return;
      } 
      if (stringBuilder.equalsIgnoreCase("x86")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_x86";
        stringBuilder = new StringBuilder();
        stringBuilder.append(SECURE_LIB_FILE_NAME);
        stringBuilder.append(".so");
        SECURE_LIB_NAME = stringBuilder.toString();
        f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        return;
      } 
      if (stringBuilder.equalsIgnoreCase("x86_64")) {
        SECURE_LIB_FILE_NAME = "libwbsafeedit_x86_64";
        stringBuilder = new StringBuilder();
        stringBuilder.append(SECURE_LIB_FILE_NAME);
        stringBuilder.append(".so");
        SECURE_LIB_NAME = stringBuilder.toString();
        f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        return;
      } 
      SECURE_LIB_FILE_NAME = "libwbsafeedit";
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(SECURE_LIB_FILE_NAME);
      stringBuilder.append(".so");
      SECURE_LIB_NAME = stringBuilder.toString();
      f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
      return;
    } 
    SECURE_LIB_FILE_NAME = "libwbsafeedit";
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(SECURE_LIB_FILE_NAME);
    stringBuilder1.append(".so");
    SECURE_LIB_NAME = stringBuilder1.toString();
    f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
  }
  
  public AuthAgent(QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private int a(boolean paramBoolean, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
    CookieSyncManager.createInstance(Global.getContext());
    Bundle bundle = composeCGIParams();
    if (paramBoolean)
      bundle.putString("isadd", "1"); 
    bundle.putString("scope", this.b);
    bundle.putString("client_id", this.mToken.getAppId());
    if (isOEM) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("desktop_m_qq-");
      stringBuilder.append(installChannel);
      stringBuilder.append("-");
      stringBuilder.append("android");
      stringBuilder.append("-");
      stringBuilder.append(registerChannel);
      stringBuilder.append("-");
      stringBuilder.append(businessId);
      bundle.putString("pf", stringBuilder.toString());
    } else {
      bundle.putString("pf", "openmobile_android");
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(System.currentTimeMillis() / 1000L);
    stringBuilder2.append("");
    String str2 = stringBuilder2.toString();
    bundle.putString("sign", SystemUtils.getAppSignatureMD5(Global.getContext(), str2));
    bundle.putString("time", str2);
    bundle.putString("display", "mobile");
    bundle.putString("response_type", "token");
    bundle.putString("redirect_uri", "auth://tauth.qq.com/");
    bundle.putString("cancel_display", "1");
    bundle.putString("switch", "1");
    bundle.putString("status_userip", Util.getUserIp());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(ServerSetting.getInstance().getEnvUrl(Global.getContext(), "http://openmobile.qq.com/oauth2.0/m_authorize?"));
    stringBuilder1.append(Util.encodeUrl(bundle));
    String str1 = stringBuilder1.toString();
    paramIUiListener = new TokenListener(this, Global.getContext(), paramIUiListener, true, false);
    f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
    ThreadManager.executeOnSubThread(new Runnable(this, str1, paramIUiListener) {
          public void run() {
            SystemUtils.extractSecureLib(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
            Activity activity = AuthAgent.e(this.c).get();
            if (activity != null)
              activity.runOnUiThread(new Runnable(this, activity) {
                    public void run() {
                      AuthDialog authDialog = new AuthDialog((Context)this.a, "action_login", this.b.a, this.b.b, AuthAgent.f(this.b.c));
                      Activity activity = this.a;
                      if (activity != null && !activity.isFinishing())
                        authDialog.show(); 
                    }
                  }); 
          }
        });
    f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
    return 2;
  }
  
  private boolean a(Activity paramActivity, Fragment paramFragment, boolean paramBoolean) {
    f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
    Intent intent = getTargetActivityIntent("com.tencent.open.agent.AgentActivity");
    if (intent != null) {
      Bundle bundle = composeCGIParams();
      if (paramBoolean)
        bundle.putString("isadd", "1"); 
      bundle.putString("scope", this.b);
      bundle.putString("client_id", this.mToken.getAppId());
      if (isOEM) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("desktop_m_qq-");
        stringBuilder.append(installChannel);
        stringBuilder.append("-");
        stringBuilder.append("android");
        stringBuilder.append("-");
        stringBuilder.append(registerChannel);
        stringBuilder.append("-");
        stringBuilder.append(businessId);
        bundle.putString("pf", stringBuilder.toString());
      } else {
        bundle.putString("pf", "openmobile_android");
      } 
      bundle.putString("need_pay", "1");
      bundle.putString("oauth_app_name", SystemUtils.getAppName(Global.getContext()));
      intent.putExtra("key_action", "action_login");
      intent.putExtra("key_params", bundle);
      if (hasActivityForIntent(intent)) {
        this.a = new FeedConfirmListener(this, this.a);
        UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.a);
        if (paramFragment != null) {
          f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
          startAssitActivity(paramFragment, intent, 11101);
        } else {
          f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
          startAssitActivity(paramActivity, intent, 11101);
        } 
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
        d.a().a(0, "LOGIN_CHECK_SDK", "1000", this.mToken.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        return true;
      } 
    } 
    d.a().a(1, "LOGIN_CHECK_SDK", "1000", this.mToken.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
    f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
    return false;
  }
  
  protected void a(IUiListener paramIUiListener) {
    f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
    String str1 = this.mToken.getAccessToken();
    String str2 = this.mToken.getOpenId();
    String str3 = this.mToken.getAppId();
    if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("tencent&sdk&qazxc***14969%%");
      stringBuilder.append(str1);
      stringBuilder.append(str3);
      stringBuilder.append(str2);
      stringBuilder.append("qzone3.4");
      str1 = Util.encrypt(stringBuilder.toString());
    } else {
      str1 = "";
    } 
    if (TextUtils.isEmpty(str1)) {
      f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
      return;
    } 
    Bundle bundle = composeCGIParams();
    bundle.putString("encrytoken", str1);
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://openmobile.qq.com/user/user_login_statis", bundle, "POST", null);
    f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
  }
  
  protected void b(IUiListener paramIUiListener) {
    Bundle bundle = composeCGIParams();
    bundle.putString("reqType", "checkLogin");
    BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, new CheckLoginListener(this, paramIUiListener));
    HttpUtils.requestAsync(this.mToken, Global.getContext(), "https://openmobile.qq.com/v3/user/get_info", bundle, "GET", (IRequestListener)tempRequestListener);
  }
  
  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener) {
    return doLogin(paramActivity, paramString, paramIUiListener, false, (Fragment)null);
  }
  
  public int doLogin(Activity paramActivity, String paramString, IUiListener paramIUiListener, boolean paramBoolean, Fragment paramFragment) {
    this.b = paramString;
    this.c = new WeakReference<Activity>(paramActivity);
    this.a = paramIUiListener;
    if (a(paramActivity, paramFragment, paramBoolean)) {
      f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "2", "310", "5", "0", "0", "0");
      return 1;
    } 
    d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "2", "310", "5", "1", "0", "0");
    f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
    this.a = new FeedConfirmListener(this, this.a);
    return a(paramBoolean, this.a);
  }
  
  public void releaseResource() {
    this.c = null;
    this.a = null;
  }
  
  class CheckLoginListener implements IUiListener {
    IUiListener a;
    
    public CheckLoginListener(AuthAgent this$0, IUiListener param1IUiListener) {
      this.a = param1IUiListener;
    }
    
    public void onCancel() {
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onCancel(); 
    }
    
    public void onComplete(Object param1Object) {
      if (param1Object == null) {
        f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
        return;
      } 
      param1Object = param1Object;
      try {
        int i = param1Object.getInt("ret");
        if (i == 0) {
          param1Object = "success";
        } else {
          param1Object = param1Object.getString("msg");
        } 
        if (this.a != null) {
          this.a.onComplete((new JSONObject()).put("ret", i).put("msg", param1Object));
          return;
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
      } 
    }
    
    public void onError(UiError param1UiError) {
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onError(param1UiError); 
    }
  }
  
  class FeedConfirmListener implements IUiListener {
    IUiListener a;
    
    private final String c = "sendinstall";
    
    private final String d = "installwording";
    
    private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";
    
    public FeedConfirmListener(AuthAgent this$0, IUiListener param1IUiListener) {
      this.a = param1IUiListener;
    }
    
    private Drawable a(String param1String, Context param1Context) {
      Drawable drawable;
      AssetManager assetManager = param1Context.getApplicationContext().getAssets();
      Context context = null;
      param1Context = context;
      try {
        byte[] arrayOfByte;
        InputStream inputStream = assetManager.open(param1String);
        if (inputStream == null)
          return null; 
        param1Context = context;
        boolean bool = param1String.endsWith(".9.png");
        if (bool) {
          param1Context = context;
          try {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
          } catch (OutOfMemoryError outOfMemoryError) {
            param1Context = context;
            outOfMemoryError.printStackTrace();
            outOfMemoryError = null;
          } 
          if (outOfMemoryError != null) {
            param1Context = context;
            arrayOfByte = outOfMemoryError.getNinePatchChunk();
            param1Context = context;
            NinePatch.isNinePatchChunk(arrayOfByte);
            param1Context = context;
            return (Drawable)new NinePatchDrawable((Bitmap)outOfMemoryError, arrayOfByte, new Rect(), null);
          } 
        } else {
          param1Context = context;
          Drawable drawable1 = Drawable.createFromStream((InputStream)arrayOfByte, (String)outOfMemoryError);
          drawable = drawable1;
          arrayOfByte.close();
          return drawable1;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        return drawable;
      } 
      return null;
    }
    
    private View a(Context param1Context, Drawable param1Drawable, String param1String, View.OnClickListener param1OnClickListener1, View.OnClickListener param1OnClickListener2) {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)param1Context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      float f1 = displayMetrics.density;
      RelativeLayout relativeLayout = new RelativeLayout(param1Context);
      ImageView imageView = new ImageView(param1Context);
      imageView.setImageDrawable(param1Drawable);
      imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      imageView.setId(1);
      int j = (int)(60.0F * f1);
      int i = (int)(f1 * 14.0F);
      int k = (int)(18.0F * f1);
      int m = (int)(6.0F * f1);
      RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(j, j);
      layoutParams2.addRule(9);
      layoutParams2.setMargins(0, k, m, k);
      relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
      TextView textView = new TextView(param1Context);
      textView.setText(param1String);
      textView.setTextSize(14.0F);
      textView.setGravity(3);
      textView.setIncludeFontPadding(false);
      textView.setPadding(0, 0, 0, 0);
      textView.setLines(2);
      textView.setId(5);
      textView.setMinWidth((int)(185.0F * f1));
      RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.addRule(1, 1);
      layoutParams3.addRule(6, 1);
      float f2 = 5.0F * f1;
      layoutParams3.setMargins(0, 0, (int)f2, 0);
      relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams3);
      View view = new View(param1Context);
      view.setBackgroundColor(Color.rgb(214, 214, 214));
      view.setId(3);
      layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
      layoutParams3.addRule(3, 1);
      layoutParams3.addRule(5, 1);
      layoutParams3.addRule(7, 5);
      j = (int)(12.0F * f1);
      layoutParams3.setMargins(0, 0, 0, j);
      relativeLayout.addView(view, (ViewGroup.LayoutParams)layoutParams3);
      LinearLayout linearLayout = new LinearLayout(param1Context);
      layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams3.addRule(5, 1);
      layoutParams3.addRule(7, 5);
      layoutParams3.addRule(3, 3);
      Button button2 = new Button(param1Context);
      button2.setText("跳过");
      button2.setBackgroundDrawable(a("buttonNegt.png", param1Context));
      button2.setTextColor(Color.rgb(36, 97, 131));
      button2.setTextSize(20.0F);
      button2.setOnClickListener(param1OnClickListener2);
      button2.setId(4);
      k = (int)(45.0F * f1);
      LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, k);
      layoutParams4.rightMargin = i;
      m = (int)(4.0F * f1);
      layoutParams4.leftMargin = m;
      layoutParams4.weight = 1.0F;
      linearLayout.addView((View)button2, (ViewGroup.LayoutParams)layoutParams4);
      Button button1 = new Button(param1Context);
      button1.setText("确定");
      button1.setTextSize(20.0F);
      button1.setTextColor(Color.rgb(255, 255, 255));
      button1.setBackgroundDrawable(a("buttonPost.png", param1Context));
      button1.setOnClickListener(param1OnClickListener1);
      LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, k);
      layoutParams1.weight = 1.0F;
      layoutParams1.rightMargin = m;
      linearLayout.addView((View)button1, (ViewGroup.LayoutParams)layoutParams1);
      relativeLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams3);
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int)(279.0F * f1), (int)(f1 * 163.0F));
      relativeLayout.setPadding(i, 0, j, j);
      relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      relativeLayout.setBackgroundColor(Color.rgb(247, 251, 247));
      PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, 251, 247));
      paintDrawable.setCornerRadius(f2);
      relativeLayout.setBackgroundDrawable((Drawable)paintDrawable);
      return (View)relativeLayout;
    }
    
    private void a(String param1String, IUiListener param1IUiListener, Object param1Object) {
      Activity activity = AuthAgent.e(this.b).get();
      if (activity == null)
        return; 
      Dialog dialog = new Dialog((Context)activity);
      dialog.requestWindowFeature(1);
      PackageManager packageManager = activity.getPackageManager();
      Drawable drawable = null;
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        nameNotFoundException.printStackTrace();
        nameNotFoundException = null;
      } 
      if (nameNotFoundException != null)
        drawable = ((PackageInfo)nameNotFoundException).applicationInfo.loadIcon(packageManager); 
      ButtonListener buttonListener1 = new ButtonListener(this, dialog, param1IUiListener, param1Object) {
          public void onClick(View param2View) {
            this.c.a();
            if (this.d != null && this.d.isShowing())
              this.d.dismiss(); 
            IUiListener iUiListener = this.a;
            if (iUiListener != null)
              iUiListener.onComplete(this.b); 
          }
        };
      ButtonListener buttonListener2 = new ButtonListener(this, dialog, param1IUiListener, param1Object) {
          public void onClick(View param2View) {
            if (this.d != null && this.d.isShowing())
              this.d.dismiss(); 
            IUiListener iUiListener = this.a;
            if (iUiListener != null)
              iUiListener.onComplete(this.b); 
          }
        };
      ColorDrawable colorDrawable = new ColorDrawable();
      colorDrawable.setAlpha(0);
      dialog.getWindow().setBackgroundDrawable((Drawable)colorDrawable);
      dialog.setContentView(a((Context)activity, drawable, param1String, buttonListener1, buttonListener2));
      dialog.setOnCancelListener(new DialogInterface.OnCancelListener(this, param1IUiListener, param1Object) {
            public void onCancel(DialogInterface param2DialogInterface) {
              IUiListener iUiListener = this.a;
              if (iUiListener != null)
                iUiListener.onComplete(this.b); 
            }
          });
      if (activity != null && !activity.isFinishing())
        dialog.show(); 
    }
    
    protected void a() {
      Bundle bundle = AuthAgent.g(this.b);
      Activity activity = AuthAgent.e(this.b).get();
      if (activity != null)
        HttpUtils.requestAsync(AuthAgent.h(this.b), (Context)activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", bundle, "POST", null); 
    }
    
    public void onCancel() {
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onCancel(); 
    }
    
    public void onComplete(Object param1Object) {
      if (param1Object != null) {
        JSONObject jSONObject = (JSONObject)param1Object;
        if (jSONObject != null) {
          boolean bool2 = false;
          boolean bool1 = false;
          try {
            if (jSONObject.getInt("sendinstall") == 1)
              bool1 = true; 
            bool2 = bool1;
            str = jSONObject.getString("installwording");
          } catch (JSONException jSONException) {
            f.d("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
            str = "";
            bool1 = bool2;
          } 
          String str = URLDecoder.decode(str);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" WORDING = ");
          stringBuilder.append(str);
          stringBuilder.append("xx");
          f.a("openSDK_LOG.AuthAgent", stringBuilder.toString());
          if (bool1 && !TextUtils.isEmpty(str)) {
            a(str, this.a, param1Object);
            return;
          } 
          IUiListener iUiListener = this.a;
          if (iUiListener != null)
            iUiListener.onComplete(param1Object); 
        } 
      } 
    }
    
    public void onError(UiError param1UiError) {
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onError(param1UiError); 
    }
    
    abstract class ButtonListener implements View.OnClickListener {
      Dialog d;
      
      ButtonListener(AuthAgent.FeedConfirmListener this$0, Dialog param2Dialog) {
        this.d = param2Dialog;
      }
    }
  }
  
  class null extends FeedConfirmListener.ButtonListener {
    null(AuthAgent this$0, Dialog param1Dialog, IUiListener param1IUiListener, Object param1Object) {
      super((AuthAgent.FeedConfirmListener)this$0, param1Dialog);
    }
    
    public void onClick(View param1View) {
      this.c.a();
      if (this.d != null && this.d.isShowing())
        this.d.dismiss(); 
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onComplete(this.b); 
    }
  }
  
  class null extends FeedConfirmListener.ButtonListener {
    null(AuthAgent this$0, Dialog param1Dialog, IUiListener param1IUiListener, Object param1Object) {
      super((AuthAgent.FeedConfirmListener)this$0, param1Dialog);
    }
    
    public void onClick(View param1View) {
      if (this.d != null && this.d.isShowing())
        this.d.dismiss(); 
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onComplete(this.b); 
    }
  }
  
  class null implements DialogInterface.OnCancelListener {
    null(AuthAgent this$0, IUiListener param1IUiListener, Object param1Object) {}
    
    public void onCancel(DialogInterface param1DialogInterface) {
      IUiListener iUiListener = this.a;
      if (iUiListener != null)
        iUiListener.onComplete(this.b); 
    }
  }
  
  abstract class ButtonListener implements View.OnClickListener {
    Dialog d;
    
    ButtonListener(AuthAgent this$0, Dialog param1Dialog) {
      this.d = param1Dialog;
    }
  }
  
  class TokenListener implements IUiListener {
    private final IUiListener b;
    
    private final boolean c;
    
    private final Context d;
    
    public TokenListener(AuthAgent this$0, Context param1Context, IUiListener param1IUiListener, boolean param1Boolean1, boolean param1Boolean2) {
      this.d = param1Context;
      this.b = param1IUiListener;
      this.c = param1Boolean1;
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
    }
    
    public void onCancel() {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
      this.b.onCancel();
      f.b();
    }
    
    public void onComplete(Object param1Object) {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
      param1Object = param1Object;
      try {
        String str1 = param1Object.getString("access_token");
        String str2 = param1Object.getString("expires_in");
        String str3 = param1Object.getString("openid");
        if (str1 != null && AuthAgent.a(this.a) != null && str3 != null) {
          AuthAgent.b(this.a).setAccessToken(str1, str2);
          AuthAgent.c(this.a).setOpenId(str3);
          a.d(this.d, AuthAgent.d(this.a));
        } 
        str1 = param1Object.getString("pf");
        if (str1 != null)
          try {
            this.d.getSharedPreferences("pfStore", 0).edit().putString("pf", str1).commit();
          } catch (Exception exception) {
            exception.printStackTrace();
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", exception);
          }  
        if (this.c)
          CookieSyncManager.getInstance().sync(); 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", (Throwable)jSONException);
      } 
      this.b.onComplete(param1Object);
      this.a.releaseResource();
      f.b();
    }
    
    public void onError(UiError param1UiError) {
      f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
      this.b.onError(param1UiError);
      f.b();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\auth\AuthAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */