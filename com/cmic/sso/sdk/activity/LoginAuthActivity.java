package com.cmic.sso.sdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cmic.sso.sdk.AuthThemeConfig;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.g;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.n;
import com.cmic.sso.sdk.utils.u;
import com.cmic.sso.sdk.utils.w;
import com.cmic.sso.sdk.utils.z;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginAuthActivity extends Activity implements View.OnClickListener {
  protected static final String a = LoginAuthActivity.class.getSimpleName();
  
  private Handler b;
  
  private Context c;
  
  private RelativeLayout d;
  
  private com.cmic.sso.sdk.widget.a e;
  
  private com.cmic.sso.sdk.widget.a f;
  
  private com.cmic.sso.sdk.widget.a g;
  
  private Bundle h;
  
  private com.cmic.sso.sdk.auth.a i;
  
  private String j = "";
  
  private CheckBox k;
  
  private LinearLayout l;
  
  private RelativeLayout m;
  
  private long n = 0L;
  
  private int o = 0;
  
  private a p = null;
  
  private TokenListener q;
  
  private boolean r = true;
  
  private LinearLayout s;
  
  private String t;
  
  private AuthThemeConfig u;
  
  private int v;
  
  private int w;
  
  private boolean x;
  
  private Dialog y;
  
  private void a(String paramString1, String paramString2, Bundle paramBundle, JSONObject paramJSONObject) {
    try {
      this.b.removeCallbacksAndMessages(null);
      boolean bool = "103000".equals(paramString1);
      if (bool) {
        if (AuthnHelper.getInstance((Context)this) != null && i.c(paramBundle.getString("traceId")) != null) {
          AuthnHelper.getInstance((Context)this).callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, null, true);
          return;
        } 
      } else if ("200020".equals(paramString1)) {
        if (AuthnHelper.getInstance((Context)this) != null) {
          if (i.c(paramBundle.getString("traceId")) != null) {
            AuthnHelper.getInstance((Context)this).callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, null);
            a();
            return;
          } 
          a();
          return;
        } 
      } else {
        AuthnHelper.getInstance((Context)this).callBackResult(paramString1, paramString2, paramBundle, paramJSONObject, null, true);
        return;
      } 
    } catch (Exception exception) {
      f.a(a, "CallbackResult:未知错误");
      exception.printStackTrace();
    } 
  }
  
  private void a(boolean paramBoolean) {
    try {
      com.cmic.sso.sdk.utils.c.a("authPageOut");
      a("200020", "登录页面关闭", this.h, (JSONObject)null);
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
      return;
    } 
  }
  
  private void d() {
    this.h = getIntent().getExtras();
    if (this.h == null)
      this.h = new Bundle(); 
    this.q = i.c(this.h.getString("traceId", ""));
    DisplayMetrics displayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.b = new Handler(getMainLooper());
    this.p = new a(this);
    this.j = this.h.getString("securityphone");
    String str1 = a;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("mSecurityPhone value is ");
    stringBuilder1.append(this.j);
    f.b(str1, stringBuilder1.toString());
    str1 = this.h.getString("operatorType", "");
    String str2 = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("operator value is ");
    stringBuilder2.append(str1);
    f.b(str2, stringBuilder2.toString());
    if (str1.equals("1")) {
      this.t = "中国移动认证服务条款";
      str1 = "http://wap.cmpassport.com/resources/html/contract.html";
    } else if (str1.equals("3")) {
      this.t = "中国电信天翼账号服务条款";
      str1 = "https://e.189.cn/sdk/agreement/detail.do";
    } else {
      this.t = "中国联通认证服务协议";
      str1 = "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true";
    } 
    this.e = new com.cmic.sso.sdk.widget.a(this.c, 16973840, null, str1);
    this.e.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
          public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int == 4 && param1KeyEvent.getAction() == 1 && param1KeyEvent.getRepeatCount() == 0)
              LoginAuthActivity.a(this.a).dismiss(); 
            return true;
          }
        });
    if (!TextUtils.isEmpty(this.u.getClauseUrl())) {
      this.f = new com.cmic.sso.sdk.widget.a(this.c, 16973840, this.u.getClauseName(), this.u.getClauseUrl());
      this.f.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
            public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4 && param1KeyEvent.getAction() == 1 && param1KeyEvent.getRepeatCount() == 0)
                LoginAuthActivity.b(this.a).dismiss(); 
              return true;
            }
          });
    } 
    if (!TextUtils.isEmpty(this.u.getClauseUrl2())) {
      this.g = new com.cmic.sso.sdk.widget.a(this.c, 16973840, this.u.getClauseName2(), this.u.getClauseUrl2());
      this.g.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
            public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4 && param1KeyEvent.getAction() == 1 && param1KeyEvent.getRepeatCount() == 0)
                LoginAuthActivity.c(this.a).dismiss(); 
              return true;
            }
          });
    } 
    g.a().a(new g.a(this) {
          public void a() {
            LoginAuthActivity.d(this.a).removeCallbacksAndMessages(null);
            if (LoginAuthActivity.a(this.a) != null && LoginAuthActivity.a(this.a).isShowing())
              LoginAuthActivity.a(this.a).dismiss(); 
            if (LoginAuthActivity.b(this.a) != null && LoginAuthActivity.b(this.a).isShowing())
              LoginAuthActivity.b(this.a).dismiss(); 
            LoginAuthActivity.a(this.a, true);
          }
        });
  }
  
  private void e() {
    int i;
    int j;
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    if (this.u.getNumFieldOffsetY() > 0 || this.u.getNumFieldOffsetY_B() < 0) {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.m.measure(i, i);
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mPhoneLayout.getMeasuredHeight()=");
      stringBuilder.append(this.m.getMeasuredHeight());
      f.b(str, stringBuilder.toString());
      if (this.u.getNumFieldOffsetY() > 0 && this.v - this.m.getMeasuredHeight() - w.a(this.c, this.u.getNumFieldOffsetY()) > 0) {
        f.b(a, "numberField_top");
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(0, w.a(this.c, this.u.getNumFieldOffsetY()), 0, 0);
      } else {
        layoutParams.addRule(12, -1);
      } 
    } else if (this.u.getNumFieldOffsetY_B() > 0 && this.v - this.m.getMeasuredHeight() - w.a(this.c, this.u.getNumFieldOffsetY_B()) > 0) {
      f.b(a, "numberField_bottom");
      layoutParams.addRule(12, -1);
      layoutParams.setMargins(0, 0, 0, w.a(this.c, this.u.getNumFieldOffsetY_B()));
    } else {
      layoutParams.addRule(10, -1);
    } 
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    if (this.u.getLogBtnMarginLeft() < 0) {
      i = 0;
    } else {
      i = this.u.getLogBtnMarginLeft();
    } 
    if (this.u.getLogBtnMarginRight() < 0) {
      j = 0;
    } else {
      j = this.u.getLogBtnMarginRight();
    } 
    if (this.u.getLogBtnOffsetY() > 0 || this.u.getLogBtnOffsetY_B() < 0) {
      if (this.u.getLogBtnOffsetY() > 0 && this.v - w.a(this.c, (this.u.getLogBtnHeight() + this.u.getLogBtnOffsetY())) > 0) {
        f.b(a, "logBtn_top");
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(w.a(this.c, i), w.a(this.c, this.u.getLogBtnOffsetY()), w.a(this.c, j), 0);
      } else {
        layoutParams.addRule(12, -1);
        layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), 0);
      } 
    } else if (this.u.getLogBtnOffsetY_B() > 0 && this.v - w.a(this.c, (this.u.getLogBtnHeight() + this.u.getLogBtnOffsetY_B())) > 0) {
      f.b(a, "logBtn_bottom");
      layoutParams.addRule(12, -1);
      layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), w.a(this.c, this.u.getLogBtnOffsetY_B()));
    } else {
      layoutParams.addRule(10, -1);
      layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), 0);
    } 
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
    if (this.u.getPrivacyMarginLeft() >= 0) {
      if (this.u.getCheckedImgWidth() > 30) {
        i = this.u.getPrivacyMarginLeft();
      } else {
        i = this.u.getPrivacyMarginLeft() - 30 - this.u.getCheckedImgWidth();
      } 
    } else if (this.u.getCheckedImgWidth() > 30) {
      i = 0;
    } else {
      i = -(30 - this.u.getCheckedImgWidth());
    } 
    if (this.u.getPrivacyMarginRight() < 0) {
      j = 0;
    } else {
      j = this.u.getPrivacyMarginRight();
    } 
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.l.measure(k, k);
    if (this.u.getPrivacyOffsetY() > 0 || this.u.getPrivacyOffsetY_B() < 0) {
      if (this.u.getPrivacyOffsetY() > 0 && this.v - w.a(this.c, (this.l.getMeasuredHeight() + this.u.getPrivacyOffsetY())) > 0) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("privacy_top = ");
        stringBuilder.append(this.l.getMeasuredHeight());
        f.b(str, stringBuilder.toString());
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(w.a(this.c, i), w.a(this.c, this.u.getPrivacyOffsetY()), w.a(this.c, j), 0);
      } else {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("privacy_bottom=");
        stringBuilder.append(i);
        f.b(str, stringBuilder.toString());
        layoutParams.addRule(12, -1);
        layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), 0);
      } 
    } else if (this.u.getPrivacyOffsetY_B() > 0 && this.v - w.a(this.c, (this.l.getMeasuredHeight() + this.u.getPrivacyOffsetY_B())) > 0) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("privacy_bottom=");
      stringBuilder.append(this.l.getMeasuredHeight());
      f.b(str, stringBuilder.toString());
      layoutParams.addRule(12, -1);
      layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), w.a(this.c, this.u.getPrivacyOffsetY_B()));
    } else {
      layoutParams.addRule(10, -1);
      layoutParams.setMargins(w.a(this.c, i), 0, w.a(this.c, j), 0);
      f.b(a, "privacy_top");
    } 
    this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void f() {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(67108864);
      getWindow().addFlags(134217728);
      if (this.u.getStatusBarColor() != 0) {
        getWindow().addFlags(-2147483648);
        getWindow().clearFlags(67108864);
        getWindow().setStatusBarColor(this.u.getStatusBarColor());
        getWindow().setNavigationBarColor(this.u.getStatusBarColor());
      } 
    } 
    if (Build.VERSION.SDK_INT >= 23)
      if (this.u.isLightColor()) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
      } else {
        getWindow().getDecorView().setSystemUiVisibility(0);
      }  
    RelativeLayout relativeLayout = new RelativeLayout((Context)this);
    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    View view = this.u.getContentView();
    if (view != null) {
      ViewParent viewParent = view.getParent();
      if (viewParent != null)
        ((ViewGroup)viewParent).removeView(view); 
      relativeLayout.addView(view);
    } else if (this.u.getLayoutResID() != -1) {
      getLayoutInflater().inflate(this.u.getLayoutResID(), (ViewGroup)relativeLayout);
    } 
    setContentView((View)relativeLayout);
    int i = getRequestedOrientation();
    this.v = w.b(this.c);
    this.w = w.a(this.c);
    if ((i == 1 && this.w > this.v) || (i == 0 && this.w < this.v)) {
      int j = this.w;
      this.w = this.v;
      this.v = j;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("orientation = ");
    stringBuilder.append(i);
    stringBuilder.append("--screenWidth = ");
    stringBuilder.append(this.w);
    stringBuilder.append("--screenHeight = ");
    stringBuilder.append(this.v);
    f.d(str, stringBuilder.toString());
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    if (this.u.getWindowWidth() != 0) {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
      Point point = new Point();
      getWindowManager().getDefaultDisplay().getSize(point);
      layoutParams.width = w.a(this.c, this.u.getWindowWidth());
      layoutParams.height = w.a(this.c, this.u.getWindowHeight());
      this.w = layoutParams.width;
      this.v = layoutParams.height;
      layoutParams.x = this.u.getWindowX();
      if (this.u.getWindowBottom() == 1) {
        getWindow().setGravity(80);
      } else {
        layoutParams.y = this.u.getWindowY();
      } 
      getWindow().setAttributes(layoutParams);
    } 
    relativeLayout.setFitsSystemWindows(true);
    relativeLayout.setClipToPadding(true);
    try {
      g();
      relativeLayout.addView((View)this.m);
      relativeLayout.addView((View)h());
      relativeLayout.addView((View)i());
      e();
      this.d.setOnClickListener(this);
      this.s.setOnClickListener(this);
      this.k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                LoginAuthActivity.e(this.a).setEnabled(true);
                try {
                  LoginAuthActivity.g(this.a).setBackgroundResource(n.a((Context)this.a, LoginAuthActivity.f(this.a).getCheckedImgPath()));
                  return;
                } catch (Exception exception) {
                  LoginAuthActivity.g(this.a).setBackgroundResource(n.a((Context)this.a, "umcsdk_check_image"));
                  return;
                } 
              } 
              LoginAuthActivity.e(this.a).setEnabled(false);
              try {
                LoginAuthActivity.g(this.a).setBackgroundResource(n.a((Context)this.a, LoginAuthActivity.f(this.a).getUncheckedImgPath()));
                return;
              } catch (Exception exception) {
                LoginAuthActivity.g(this.a).setBackgroundResource(n.a((Context)this.a, "umcsdk_uncheck_image"));
                return;
              } 
            }
          });
      k();
      try {
        if (this.u.isPrivacyState()) {
          this.k.setChecked(true);
          this.k.setBackgroundResource(n.a((Context)this, this.u.getCheckedImgPath()));
          this.d.setEnabled(true);
          return;
        } 
        this.k.setChecked(false);
        this.d.setEnabled(false);
        this.k.setBackgroundResource(n.a((Context)this, this.u.getUncheckedImgPath()));
        return;
      } catch (Exception exception) {
        this.k.setChecked(false);
      } 
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
      f.a(a, exception.toString());
      a("200040", "UI资源加载异常", this.h, (JSONObject)null);
      return;
    } 
  }
  
  private void g() {
    this.m = new RelativeLayout((Context)this);
    this.m.setId(13107);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    this.m.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView((Context)this);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    textView.setGravity(15);
    int i = this.u.getNumberOffsetX();
    if (i == 0) {
      layoutParams2.addRule(13);
    } else if (i > 0) {
      int j = this.w;
      int k = textView.getWidth();
      Context context = this.c;
      float f = i;
      if (j - k - w.a(context, f) > 0) {
        layoutParams2.setMargins(w.a(this.c, f), 0, 0, 0);
      } else {
        f.b(a, "RelativeLayout.ALIGN_PARENT_RIGHT");
        layoutParams2.addRule(11);
      } 
    } 
    try {
      textView.setTextSize(2, this.u.getNumberSize());
    } catch (Exception exception) {
      textView.setTextSize(2, 18.0F);
    } 
    textView.setText(this.j);
    textView.setId(30583);
    this.m.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
    try {
      textView.setTextColor(this.u.getNumberColor());
    } catch (Exception exception) {
      textView.setTextColor(-13421773);
    } 
    i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.m.measure(i, i);
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mPhoneLayout.getMeasuredHeight()=");
    stringBuilder.append(this.m.getMeasuredHeight());
    f.b(str, stringBuilder.toString());
  }
  
  private RelativeLayout h() {
    this.d = new RelativeLayout((Context)this);
    this.d.setId(17476);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(w.a(this.c, this.u.getLogBtnWidth()), w.a(this.c, this.u.getLogBtnHeight()));
    this.d.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    TextView textView = new TextView((Context)this);
    textView.setTextSize(2, this.u.getLogBtnTextSize());
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(13);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.d.addView((View)textView);
    textView.setText(this.u.getLogBtnText());
    try {
      textView.setTextColor(this.u.getLogBtnTextColor());
    } catch (Exception exception) {
      textView.setTextColor(-1);
    } 
    try {
      this.d.setBackgroundResource(n.a(this.c, this.u.getLogBtnBackgroundPath()));
    } catch (Exception exception) {
      exception.printStackTrace();
      this.d.setBackgroundResource(n.a(this.c, "umcsdk_login_btn_bg"));
    } 
    return this.d;
  }
  
  private LinearLayout i() {
    this.l = new LinearLayout((Context)this);
    this.l.setOrientation(0);
    this.l.setHorizontalGravity(1);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.l.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    int i = this.u.getCheckedImgWidth();
    int j = this.u.getCheckedImgHeight();
    Context context1 = this.c;
    float f2 = 30.0F;
    if (i > 30) {
      f1 = i;
    } else {
      f1 = 30.0F;
    } 
    int k = w.a(context1, f1);
    context1 = this.c;
    float f1 = f2;
    if (j > 30)
      f1 = j; 
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(k, w.a(context1, f1));
    this.s = new LinearLayout((Context)this);
    this.s.setOrientation(0);
    this.s.setId(34952);
    this.s.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.k = new CheckBox((Context)this);
    this.k.setChecked(false);
    layoutParams1 = new LinearLayout.LayoutParams(w.a(this.c, this.u.getCheckedImgWidth()), w.a(this.c, this.u.getCheckedImgHeight()));
    Context context2 = this.c;
    if (i > 30) {
      f1 = 0.0F;
    } else {
      f1 = (30 - i);
    } 
    layoutParams1.setMargins(w.a(context2, f1), 0, 0, 0);
    this.k.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.s.addView((View)this.k);
    this.l.addView((View)this.s);
    TextView textView = new TextView((Context)this);
    textView.setTextSize(2, this.u.getPrivacyTextSize());
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.setMargins(w.a(this.c, 5.0F), 0, 0, w.a(this.c, 5.0F));
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.l.addView((View)textView);
    textView.setTextColor(this.u.getClauseBaseColor());
    textView.setText((CharSequence)w.a((Context)this, j(), this.t, this.e, this.f, this.g));
    textView.setLineSpacing(8.0F, 1.0F);
    textView.setIncludeFontPadding(false);
    if (this.u.isPrivacyTextGravityCenter())
      textView.setGravity(17); 
    textView.setHighlightColor(getResources().getColor(17170445));
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    this.k.setButtonDrawable((Drawable)new ColorDrawable());
    try {
      this.k.setBackgroundResource(n.a((Context)this, this.u.getUncheckedImgPath()));
    } catch (Exception exception) {
      this.k.setBackgroundResource(n.a((Context)this, "umcsdk_uncheck_image"));
    } 
    return this.l;
  }
  
  private String j() {
    if (this.u.getPrivacy().contains("$$《运营商条款》$$")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("《");
      stringBuilder.append(this.t);
      stringBuilder.append("》");
      this.t = stringBuilder.toString();
      return this.u.getPrivacy().replace("$$《运营商条款》$$", this.t);
    } 
    return this.u.getPrivacy().replace("$$运营商条款$$", this.t);
  }
  
  private void k() {
    this.d.setClickable(true);
    this.k.setClickable(true);
  }
  
  private void l() {
    this.d.setClickable(false);
    this.k.setClickable(false);
  }
  
  private void m() {
    try {
      if (this.o >= 5) {
        Toast.makeText(this.c, "网络不稳定,请返回重试其他登录方式", 1).show();
        this.d.setClickable(true);
        return;
      } 
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      int j = arrayOfStackTraceElement.length;
      for (int i = 0;; i++) {
        if (i < j) {
          StackTraceElement stackTraceElement = arrayOfStackTraceElement[i];
          f.a("stack", stackTraceElement.getClassName());
          String str = stackTraceElement.getClassName();
          if (!TextUtils.isEmpty(str) && str.contains("com.cmic.sso.sdk.activity") && !stringBuilder.toString().contains(str)) {
            stringBuilder.append(str);
            stringBuilder.append(";");
          } 
        } else {
          this.h.putString("caller", stringBuilder.toString());
          this.h.putLong("loginTime", System.currentTimeMillis());
          String str = this.h.getString("traceId", "");
          if (!TextUtils.isEmpty(str) && i.a(str)) {
            str = z.b();
            this.h.putString("traceId", str);
            i.a(str, this.q);
          } 
          b();
          l();
          c c = new c(this, this.h);
          this.b.postDelayed(c, AuthnHelper.getInstance((Context)this).getOverTime());
          u.a(new b(this, c));
          return;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a() {
    this.b.removeCallbacksAndMessages(null);
    com.cmic.sso.sdk.widget.a a1 = this.e;
    if (a1 != null && a1.isShowing())
      this.e.dismiss(); 
    a1 = this.f;
    if (a1 != null && a1.isShowing())
      this.f.dismiss(); 
    c();
    this.y = null;
    finish();
    if (this.u.getAuthPageActOut() != null && this.u.getActivityIn() != null)
      overridePendingTransition(n.b((Context)this, this.u.getAuthPageActOut()), n.b((Context)this, this.u.getActivityIn())); 
  }
  
  public void b() {
    f.a(a, "loginClickStart");
    try {
      this.x = true;
      if (this.u.getLoginClickListener() != null) {
        this.u.getLoginClickListener().onLoginClickStart(this.c, null);
      } else {
        if (this.y != null) {
          this.y.show();
          return;
        } 
        this.y = (Dialog)(new AlertDialog.Builder((Context)this)).create();
        this.y.setCancelable(false);
        this.y.setCanceledOnTouchOutside(false);
        this.y.setOnKeyListener(new DialogInterface.OnKeyListener(this) {
              public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
                return (param1Int == 4);
              }
            });
        RelativeLayout relativeLayout = new RelativeLayout(this.y.getContext());
        relativeLayout.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.y.getContext());
        imageView.setImageResource(n.a(this.c, "dialog_loading"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 80);
        layoutParams.addRule(13, -1);
        relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
        if (this.y.getWindow() != null)
          this.y.getWindow().setDimAmount(0.0F); 
        this.y.show();
        this.y.setContentView((View)relativeLayout);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    f.a(a, "loginClickStart");
  }
  
  public void c() {
    try {
      f.a(a, "loginClickComplete");
      if (this.u.getLoginClickListener() != null && this.x) {
        this.x = false;
        this.u.getLoginClickListener().onLoginClickComplete(this.c, null);
        return;
      } 
      if (this.y != null && this.y.isShowing()) {
        this.y.dismiss();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void onClick(View paramView) {
    try {
      int i = paramView.getId();
      if (i != 17476) {
        if (i != 26214) {
          if (i != 34952)
            return; 
          if (this.k.isChecked()) {
            this.k.setChecked(false);
            return;
          } 
          this.k.setChecked(true);
          return;
        } 
        a(false);
        return;
      } 
      this.o++;
      m();
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    try {
      super.onCreate(paramBundle);
      if (paramBundle != null)
        finish(); 
      this.c = (Context)this;
      this.u = AuthnHelper.getInstance(this.c).getAuthThemeConfig();
      if (this.u != null && this.u.getThemeId() != -1)
        setTheme(this.u.getThemeId()); 
      com.cmic.sso.sdk.utils.c.a("authPageIn");
      this.n = System.currentTimeMillis();
      this.i = com.cmic.sso.sdk.auth.a.a((Context)this);
      d();
      f();
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      f.a(a, exception.toString());
      exception.printStackTrace();
      a("200025", "发生未知错误", this.h, (JSONObject)null);
      return;
    } 
  }
  
  protected void onDestroy() {
    try {
      this.b.removeCallbacksAndMessages(null);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis() - this.n);
      stringBuilder.append("");
      com.cmic.sso.sdk.utils.c.a("timeOnAuthPage", stringBuilder.toString());
      boolean bool = this.k.isChecked();
      if (bool) {
        com.cmic.sso.sdk.utils.c.a("authPrivacyState", "1");
      } else {
        com.cmic.sso.sdk.utils.c.a("authPrivacyState", "0");
      } 
      if (!this.h.getBoolean("isLoginSwitch", false)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis() - this.n);
        stringBuilder.append("");
        com.cmic.sso.sdk.utils.c.a("timeOnAuthPage", stringBuilder.toString());
        com.cmic.sso.sdk.utils.c.a(this.c, this.h);
        com.cmic.sso.sdk.utils.c.a();
      } 
      this.y = null;
      g.a().c();
      this.p.removeCallbacksAndMessages(null);
    } catch (Exception exception) {
      f.a(a, "LoginAuthActivity clear failed");
      com.cmic.sso.sdk.c.a.a.add(exception);
      exception.printStackTrace();
    } 
    super.onDestroy();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && !paramKeyEvent.isCanceled() && paramKeyEvent.getRepeatCount() == 0) {
      if (this.u.getBackPressedListener() != null)
        this.u.getBackPressedListener().onBackPressed(); 
      a(false);
    } 
    return true;
  }
  
  protected void onResume() {
    super.onResume();
    try {
      if (this.h != null)
        this.h.putString("loginMethod", "loginAuth"); 
      AuthnHelper.getInstance((Context)this).loginPageInCallBack("200087", null);
      return;
    } catch (Exception exception) {
      com.cmic.sso.sdk.c.a.a.add(exception);
      a("200025", "发生未知错误", this.h, (JSONObject)null);
      return;
    } 
  }
  
  static class a extends Handler {
    WeakReference<LoginAuthActivity> a;
    
    a(LoginAuthActivity param1LoginAuthActivity) {
      this.a = new WeakReference<LoginAuthActivity>(param1LoginAuthActivity);
    }
    
    private void a(Message param1Message) {
      LoginAuthActivity loginAuthActivity = this.a.get();
      if (loginAuthActivity != null && param1Message.what == 13) {
        loginAuthActivity.c();
        LoginAuthActivity.i(loginAuthActivity);
      } 
    }
    
    public void handleMessage(Message param1Message) {
      try {
        a(param1Message);
        return;
      } catch (Exception exception) {
        com.cmic.sso.sdk.c.a.a.add(exception);
        exception.printStackTrace();
        return;
      } 
    }
  }
  
  static class b extends u.a {
    WeakReference<LoginAuthActivity> a;
    
    WeakReference<LoginAuthActivity.c> b;
    
    protected b(LoginAuthActivity param1LoginAuthActivity, LoginAuthActivity.c param1c) {
      this.a = new WeakReference<LoginAuthActivity>(param1LoginAuthActivity);
      this.b = new WeakReference<LoginAuthActivity.c>(param1c);
    }
    
    private boolean b() {
      LoginAuthActivity.c c = this.b.get();
      return (this.a.get() != null) ? ((c == null) ? false : LoginAuthActivity.c.a(c, false)) : false;
    }
    
    public void a() {
      LoginAuthActivity loginAuthActivity = this.a.get();
      if (!LoginAuthActivity.j(loginAuthActivity)) {
        LoginAuthActivity.l(loginAuthActivity).a(LoginAuthActivity.k(loginAuthActivity), String.valueOf(3), new com.cmic.sso.sdk.auth.b(this, loginAuthActivity) {
              public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
                if (!LoginAuthActivity.b.a(this.b))
                  return; 
                if ("103000".equals(param2String1)) {
                  LoginAuthActivity.l(this.a).a(LoginAuthActivity.k(this.a), new com.cmic.sso.sdk.auth.b(this) {
                        public void a(String param3String1, String param3String2, Bundle param3Bundle, JSONObject param3JSONObject) {
                          if (!LoginAuthActivity.b.a(this.a.b))
                            return; 
                          long l = param3Bundle.getLong("loginTime");
                          if (l != 0L)
                            param3Bundle.putLong("loginTime", System.currentTimeMillis() - l); 
                          String str = param3Bundle.getString("phonescrip");
                          if ("103000".equals(param3String1) && !TextUtils.isEmpty(str)) {
                            com.cmic.sso.sdk.utils.c.a("authClickSuccess");
                            LoginAuthActivity.b(this.a.a, true);
                          } else {
                            LoginAuthActivity.b(this.a.a, false);
                            com.cmic.sso.sdk.utils.c.a("authClickFailed");
                          } 
                          LoginAuthActivity.a(this.a.a, param3String1, param3String2, param3Bundle, param3JSONObject);
                          try {
                            Thread.sleep(1000L);
                          } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                          } 
                          LoginAuthActivity.h(this.a.a).sendEmptyMessage(13);
                        }
                      });
                  return;
                } 
                LoginAuthActivity.b(this.a, false);
                LoginAuthActivity.a(this.a, param2String1, param2String2, param2Bundle, param2JSONObject);
                try {
                  Thread.sleep(1000L);
                } catch (InterruptedException interruptedException) {
                  interruptedException.printStackTrace();
                } 
                LoginAuthActivity.h(this.a).sendEmptyMessage(13);
              }
            });
        return;
      } 
      LoginAuthActivity.l(loginAuthActivity).a(LoginAuthActivity.k(loginAuthActivity), new com.cmic.sso.sdk.auth.b(this, loginAuthActivity) {
            public void a(String param2String1, String param2String2, Bundle param2Bundle, JSONObject param2JSONObject) {
              if (!LoginAuthActivity.b.a(this.b))
                return; 
              long l = param2Bundle.getLong("loginTime");
              String str = param2Bundle.getString("phonescrip");
              if (l != 0L)
                param2Bundle.putLong("loginTime", System.currentTimeMillis() - l); 
              if ("103000".equals(param2String1) && !TextUtils.isEmpty(str)) {
                com.cmic.sso.sdk.utils.c.a("authClickSuccess");
                LoginAuthActivity.b(this.a, true);
              } else {
                LoginAuthActivity.b(this.a, false);
                com.cmic.sso.sdk.utils.c.a("authClickFailed");
              } 
              LoginAuthActivity.a(this.a, param2String1, param2String2, param2Bundle, param2JSONObject);
              try {
                Thread.sleep(1000L);
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              } 
              LoginAuthActivity.h(this.a).sendEmptyMessage(13);
            }
          });
    }
  }
  
  class null implements com.cmic.sso.sdk.auth.b {
    null(LoginAuthActivity this$0, LoginAuthActivity param1LoginAuthActivity) {}
    
    public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
      if (!LoginAuthActivity.b.a(this.b))
        return; 
      if ("103000".equals(param1String1)) {
        LoginAuthActivity.l(this.a).a(LoginAuthActivity.k(this.a), new com.cmic.sso.sdk.auth.b(this) {
              public void a(String param3String1, String param3String2, Bundle param3Bundle, JSONObject param3JSONObject) {
                if (!LoginAuthActivity.b.a(this.a.b))
                  return; 
                long l = param3Bundle.getLong("loginTime");
                if (l != 0L)
                  param3Bundle.putLong("loginTime", System.currentTimeMillis() - l); 
                String str = param3Bundle.getString("phonescrip");
                if ("103000".equals(param3String1) && !TextUtils.isEmpty(str)) {
                  com.cmic.sso.sdk.utils.c.a("authClickSuccess");
                  LoginAuthActivity.b(this.a.a, true);
                } else {
                  LoginAuthActivity.b(this.a.a, false);
                  com.cmic.sso.sdk.utils.c.a("authClickFailed");
                } 
                LoginAuthActivity.a(this.a.a, param3String1, param3String2, param3Bundle, param3JSONObject);
                try {
                  Thread.sleep(1000L);
                } catch (InterruptedException interruptedException) {
                  interruptedException.printStackTrace();
                } 
                LoginAuthActivity.h(this.a.a).sendEmptyMessage(13);
              }
            });
        return;
      } 
      LoginAuthActivity.b(this.a, false);
      LoginAuthActivity.a(this.a, param1String1, param1String2, param1Bundle, param1JSONObject);
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      LoginAuthActivity.h(this.a).sendEmptyMessage(13);
    }
  }
  
  class null implements com.cmic.sso.sdk.auth.b {
    public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
      if (!LoginAuthActivity.b.a(this.a.b))
        return; 
      long l = param1Bundle.getLong("loginTime");
      if (l != 0L)
        param1Bundle.putLong("loginTime", System.currentTimeMillis() - l); 
      String str = param1Bundle.getString("phonescrip");
      if ("103000".equals(param1String1) && !TextUtils.isEmpty(str)) {
        com.cmic.sso.sdk.utils.c.a("authClickSuccess");
        LoginAuthActivity.b(this.a.a, true);
      } else {
        LoginAuthActivity.b(this.a.a, false);
        com.cmic.sso.sdk.utils.c.a("authClickFailed");
      } 
      LoginAuthActivity.a(this.a.a, param1String1, param1String2, param1Bundle, param1JSONObject);
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      LoginAuthActivity.h(this.a.a).sendEmptyMessage(13);
    }
  }
  
  class null implements com.cmic.sso.sdk.auth.b {
    null(LoginAuthActivity this$0, LoginAuthActivity param1LoginAuthActivity) {}
    
    public void a(String param1String1, String param1String2, Bundle param1Bundle, JSONObject param1JSONObject) {
      if (!LoginAuthActivity.b.a(this.b))
        return; 
      long l = param1Bundle.getLong("loginTime");
      String str = param1Bundle.getString("phonescrip");
      if (l != 0L)
        param1Bundle.putLong("loginTime", System.currentTimeMillis() - l); 
      if ("103000".equals(param1String1) && !TextUtils.isEmpty(str)) {
        com.cmic.sso.sdk.utils.c.a("authClickSuccess");
        LoginAuthActivity.b(this.a, true);
      } else {
        LoginAuthActivity.b(this.a, false);
        com.cmic.sso.sdk.utils.c.a("authClickFailed");
      } 
      LoginAuthActivity.a(this.a, param1String1, param1String2, param1Bundle, param1JSONObject);
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      LoginAuthActivity.h(this.a).sendEmptyMessage(13);
    }
  }
  
  class c implements Runnable {
    private Bundle b;
    
    private boolean c;
    
    c(LoginAuthActivity this$0, Bundle param1Bundle) {
      this.b = param1Bundle;
    }
    
    private boolean a(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield c : Z
      //   6: istore_2
      //   7: aload_0
      //   8: iload_1
      //   9: putfield c : Z
      //   12: aload_0
      //   13: monitorexit
      //   14: iload_2
      //   15: iconst_1
      //   16: ixor
      //   17: ireturn
      //   18: astore_3
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_3
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	18	finally
    }
    
    public void run() {
      if (a(true)) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("resultCode", "102507");
          jSONObject.put("resultString", "请求超时");
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        LoginAuthActivity.b(this.a, false);
        com.cmic.sso.sdk.utils.c.a("authClickFailed");
        LoginAuthActivity.h(this.a).sendEmptyMessage(13);
        long l = this.b.getLong("loginTime");
        if (l != 0L)
          this.b.putLong("loginTime", System.currentTimeMillis() - l); 
        LoginAuthActivity.a(this.a, "102507", "请求超时", this.b, jSONObject);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\activity\LoginAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */