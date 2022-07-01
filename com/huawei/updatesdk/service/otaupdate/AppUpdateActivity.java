package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.updatesdk.b.c.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.io.Serializable;
import java.util.concurrent.Executors;

public class AppUpdateActivity extends Activity implements b, b {
  private String a = "com.huawei.appmarket";
  
  private AlertDialog b;
  
  private com.huawei.updatesdk.b.g.a c;
  
  private com.huawei.updatesdk.b.g.a d;
  
  private ProgressBar e;
  
  private TextView f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private ApkUpgradeInfo i = null;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private com.huawei.updatesdk.a.b.b.b l;
  
  private int m = -99;
  
  private int n = -99;
  
  private int o = -99;
  
  private Intent p = null;
  
  private n q;
  
  private Intent a(int paramInt1, int paramInt2, int paramInt3) {
    Intent intent = new Intent();
    intent.putExtra("downloadStatus", paramInt3);
    intent.putExtra("installState", paramInt1);
    intent.putExtra("installType", paramInt2);
    return intent;
  }
  
  private void a() {
    try {
      if (this.b != null && this.b.isShowing()) {
        this.b.dismiss();
        this.b = null;
        return;
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      com.huawei.updatesdk.a.a.b.a.a.a.a("AppUpdateActivity", "progressDialog dismiss IllegalArgumentException");
    } 
  }
  
  private void a(View paramView) {
    if (!com.huawei.updatesdk.a.a.c.h.b.g())
      return; 
    try {
      ScrollView scrollView = (ScrollView)paramView.findViewById(g.c((Context)this, "scroll_layout"));
      if (Build.VERSION.SDK_INT >= 22) {
        TypedValue typedValue = new TypedValue();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getTheme().resolveAttribute(16843987, typedValue, true);
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = TypedValue.complexToDimensionPixelSize(typedValue.data, displayMetrics);
        scrollView.setPadding(i, 0, i, 0);
        return;
      } 
    } catch (Exception exception) {
      com.huawei.updatesdk.a.a.b.a.a.a.b("AppUpdateActivity", exception.toString());
    } 
  }
  
  private void a(com.huawei.updatesdk.a.b.c.b paramb) {
    Bundle bundle = paramb.b();
    if (bundle != null) {
      int i = bundle.getInt("download_status_param", -1);
      d.a().a(a(-1, -1, i));
      if (!com.huawei.updatesdk.a.b.b.d.a.a(i)) {
        a();
        if (com.huawei.updatesdk.a.b.b.d.a.b(i)) {
          Toast.makeText((Context)this, getString(g.e((Context)this, "upsdk_third_app_dl_install_failed")), 0).show();
          finish();
        } 
      } 
    } 
  }
  
  private void a(ApkUpgradeInfo paramApkUpgradeInfo, TextView paramTextView) {
    if (paramTextView == null)
      return; 
    if (paramApkUpgradeInfo.getDiffSize_() > 0) {
      long l;
      if (paramApkUpgradeInfo.getPackingType_() == 3 && paramApkUpgradeInfo.getObbSize_() > 0L) {
        l = paramApkUpgradeInfo.getLongSize_() + paramApkUpgradeInfo.getObbSize_();
      } else {
        l = paramApkUpgradeInfo.getLongSize_();
      } 
      String str = i.a((Context)this, l);
      SpannableString spannableString = new SpannableString(str);
      spannableString.setSpan(new StrikethroughSpan(), 0, str.length(), 33);
      spannableString.setSpan(new TextAppearanceSpan("HwChinese-medium", 0, (int)paramTextView.getTextSize(), null, null), 0, spannableString.length(), 33);
      paramTextView.setText((CharSequence)spannableString);
      return;
    } 
    paramTextView.setVisibility(8);
  }
  
  private void a(String paramString) {
    Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
    intent.setPackage(this.a);
    intent.putExtra("APP_PACKAGENAME", paramString);
    intent.putExtra("APP_MUST_UPDATE_BTN", this.k);
    try {
      this.h = false;
      startActivityForResult(intent, 1002);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("goHiappUpgrade error: ");
      stringBuilder.append(activityNotFoundException.toString());
      com.huawei.updatesdk.a.a.b.a.a.a.b("AppUpdateActivity", stringBuilder.toString());
      this.h = true;
      Intent intent1 = new Intent();
      intent1.putExtra("status", 8);
      d.a().b(intent1);
      d(this.i);
      return;
    } 
  }
  
  private void a(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      this.m = 1;
      finish();
      return;
    } 
    Intent intent = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
    intent.setPackage(this.a);
    intent.putExtra("appDetailId", paramString2);
    intent.putExtra("thirdId", paramString1);
    intent.addFlags(268468224);
    try {
      startActivity(intent);
      if (!this.j)
        finish(); 
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      f.a(this);
      f.a(this.a);
      Intent intent1 = new Intent();
      intent1.putExtra("status", 8);
      d.a().b(intent1);
      com.huawei.updatesdk.b.g.a a1 = this.d;
      if (a1 != null)
        a1.a(); 
      return;
    } 
  }
  
  private long b(ApkUpgradeInfo paramApkUpgradeInfo) {
    long l2 = paramApkUpgradeInfo.getLongSize_();
    if (paramApkUpgradeInfo.getPackingType_() == 1 && paramApkUpgradeInfo.getBundleSize_() > 0L)
      return paramApkUpgradeInfo.getBundleSize_(); 
    long l1 = l2;
    if (paramApkUpgradeInfo.getPackingType_() == 3) {
      l1 = l2;
      if (paramApkUpgradeInfo.getObbSize_() > 0L)
        l1 = l2 + paramApkUpgradeInfo.getObbSize_(); 
    } 
    if (paramApkUpgradeInfo.getDiffSize_() > 0) {
      l2 = paramApkUpgradeInfo.getDiffSize_();
      l1 = l2;
      if (paramApkUpgradeInfo.getPackingType_() == 3) {
        l1 = l2;
        if (paramApkUpgradeInfo.getObbSize_() > 0L)
          l1 = l2 + paramApkUpgradeInfo.getObbSize_(); 
      } 
    } 
    return l1;
  }
  
  private void b() {
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    intentFilter.addDataScheme("package");
    this.q = new n(null);
    a.a((Context)this, intentFilter, (BroadcastReceiver)this.q);
  }
  
  private void b(com.huawei.updatesdk.a.b.c.b paramb) {
    if (this.e == null)
      return; 
    long l = paramb.b("download_apk_size", 0);
    int i = i.a(paramb.b("download_apk_already", 0), l);
    this.e.setProgress(i);
    i = (int)(this.e.getProgress() / this.e.getMax() * 100.0F);
    this.f.setText(i.a(i));
  }
  
  private void b(String paramString) {
    View view = LayoutInflater.from((Context)this).inflate(g.d((Context)this, "upsdk_ota_update_view"), null);
    if (TextUtils.isEmpty(this.i.getNewFeatures_())) {
      str = getString(g.e((Context)this, "upsdk_choice_update"));
    } else {
      str = this.i.getNewFeatures_();
    } 
    ((TextView)view.findViewById(g.c((Context)this, "content_textview"))).setText(str);
    String str = this.i.getVersion_();
    ((TextView)view.findViewById(g.c((Context)this, "version_textview"))).setText(str);
    str = i.a((Context)this, b(this.i));
    ((TextView)view.findViewById(g.c((Context)this, "appsize_textview"))).setText(str);
    str = this.i.getName_();
    ((TextView)view.findViewById(g.c((Context)this, "name_textview"))).setText(str);
    TextView textView = (TextView)view.findViewById(g.c((Context)this, "allsize_textview"));
    a(this.i, textView);
    a(view);
    this.d = com.huawei.updatesdk.b.g.a.a((Context)this, paramString, null);
    this.d.a(view);
  }
  
  private void b(String paramString1, String paramString2) {
    AlertDialog.Builder builder;
    AlertDialog alertDialog = this.b;
    if (alertDialog != null && alertDialog.isShowing())
      return; 
    if (com.huawei.updatesdk.a.a.c.h.b.g()) {
      builder = new AlertDialog.Builder((Context)this);
    } else if (((getResources().getConfiguration()).uiMode & 0x30) == 32 && Build.VERSION.SDK_INT >= 29) {
      builder = new AlertDialog.Builder((Context)this, 16974545);
    } else {
      builder = new AlertDialog.Builder((Context)this, 16974546);
    } 
    this.b = builder.create();
    View view = LayoutInflater.from((Context)this).inflate(g.d((Context)this, "upsdk_app_dl_progress_dialog"), null);
    ((TextView)view.findViewById(g.c((Context)this, "third_app_warn_text"))).setText(getString(g.e((Context)this, "upsdk_app_download_installing"), new Object[] { paramString2 }));
    this.e = (ProgressBar)view.findViewById(g.c((Context)this, "third_app_dl_progressbar"));
    this.e.setMax(100);
    this.f = (TextView)view.findViewById(g.c((Context)this, "third_app_dl_progress_text"));
    view.findViewById(g.c((Context)this, "cancel_bg")).setOnClickListener(new e(this, paramString1));
    this.b.setView(view);
    this.b.setCancelable(false);
    this.b.setCanceledOnTouchOutside(false);
    if (!a.a((Context)this))
      this.b.show(); 
    this.f.setText(i.a(0));
  }
  
  private void c() {
    int i = com.huawei.updatesdk.b.f.a.d().a();
    if (i >= 11 && i < 17)
      this.d.a(g.b((Context)this, "upsdk_update_all_button"), g.a((Context)this, "upsdk_white")); 
  }
  
  private void c(int paramInt) {
    if (paramInt == 5 || paramInt == 4) {
      Toast.makeText((Context)this, getString(g.e((Context)this, "upsdk_third_app_dl_install_failed")), 0).show();
      com.huawei.updatesdk.b.f.b.a();
      finish();
    } 
    if (paramInt == 7) {
      com.huawei.updatesdk.b.f.b.a();
      if (this.g) {
        d(this.i);
        return;
      } 
      finish();
    } 
  }
  
  private void c(com.huawei.updatesdk.a.b.c.b paramb) {
    (new Handler(Looper.getMainLooper())).post(new b(this, paramb));
  }
  
  private void c(ApkUpgradeInfo paramApkUpgradeInfo) {
    com.huawei.updatesdk.b.g.a a1 = com.huawei.updatesdk.b.g.a.a((Context)this, null, getString(g.e((Context)this, "upsdk_appstore_install"), new Object[] { paramApkUpgradeInfo.getName_() }));
    a1.a(new f(this, paramApkUpgradeInfo, a1));
    String str = getString(g.e((Context)this, "upsdk_app_download_info_new"));
    a1.a(new g(this));
    a1.a(com.huawei.updatesdk.b.g.a.c.a, str);
    a1.a(new h(this, a1));
  }
  
  private void c(String paramString) {
    this.c = com.huawei.updatesdk.b.g.a.a((Context)this, null, getString(g.e((Context)this, "upsdk_third_app_dl_cancel_download_prompt_ex")));
    this.c.a(new c(this));
    paramString = getString(g.e((Context)this, "upsdk_third_app_dl_sure_cancel_download"));
    this.c.a(new d(this));
    this.c.a(com.huawei.updatesdk.b.g.a.c.a, paramString);
  }
  
  private void d() {
    com.huawei.updatesdk.b.g.a a1 = this.d;
    if (a1 != null) {
      a1.a(new l(null));
      this.d.a(new m(null));
    } 
  }
  
  private void d(ApkUpgradeInfo paramApkUpgradeInfo) {
    if (paramApkUpgradeInfo == null) {
      finish();
      return;
    } 
    String str3 = getString(g.e((Context)this, "upsdk_ota_title"));
    String str2 = getString(g.e((Context)this, "upsdk_ota_notify_updatebtn"));
    String str1 = getString(g.e((Context)this, "upsdk_ota_cancel"));
    b(str3);
    if (1 == paramApkUpgradeInfo.getIsCompulsoryUpdate_()) {
      str1 = getString(g.e((Context)this, "upsdk_ota_force_cancel_new"));
      if (this.k)
        this.d.c(); 
      this.g = true;
    } 
    this.d.a(new i(this));
    d();
    this.d.a(new j(this));
    if (this.g) {
      this.d.a(false);
    } else {
      this.d.a(new a(this));
    } 
    this.d.a(com.huawei.updatesdk.b.g.a.c.a, str2);
    this.d.a(com.huawei.updatesdk.b.g.a.c.b, str1);
    c();
  }
  
  private void e() {
    a.a((Context)this, (BroadcastReceiver)this.q);
    com.huawei.updatesdk.b.c.c.a().b(this);
    com.huawei.updatesdk.a.b.b.b b1 = this.l;
    if (b1 != null)
      b1.b(); 
    f.a((b)null);
  }
  
  private void e(ApkUpgradeInfo paramApkUpgradeInfo) {
    b();
    b(paramApkUpgradeInfo.getPackage_(), paramApkUpgradeInfo.getName_());
    com.huawei.updatesdk.a.b.b.a a1 = new com.huawei.updatesdk.a.b.b.a(paramApkUpgradeInfo.getDownurl_(), paramApkUpgradeInfo.getLongSize_(), paramApkUpgradeInfo.getSha256_());
    a1.a(paramApkUpgradeInfo.getPackage_());
    this.l = new com.huawei.updatesdk.a.b.b.b(a1);
    this.l.executeOnExecutor(Executors.newSingleThreadExecutor(), (Object[])new Void[0]);
  }
  
  private void f() {
    if (!com.huawei.updatesdk.b.f.b.c((Context)this, this.a)) {
      if (com.huawei.updatesdk.a.b.a.a.c() == null)
        com.huawei.updatesdk.a.b.a.a.a((Context)this); 
      f.a(this);
      f.a(this.a);
      this.d.a();
      return;
    } 
    a(this.i.getPackage_(), this.i.getDetailId_());
  }
  
  public void a(int paramInt) {
    Toast.makeText((Context)this, getString(g.e((Context)this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
    d.a().a(paramInt);
    finish();
  }
  
  public void a(int paramInt, com.huawei.updatesdk.a.b.c.b paramb) {
    if (paramb == null)
      return; 
    if (paramInt == 0) {
      a(paramb);
      return;
    } 
    if (1 == paramInt) {
      b(paramb);
      return;
    } 
    if (2 == paramInt)
      c(paramb); 
  }
  
  public void a(ApkUpgradeInfo paramApkUpgradeInfo) {
    if (paramApkUpgradeInfo != null) {
      com.huawei.updatesdk.b.c.c.a().a(this);
      c(paramApkUpgradeInfo);
      return;
    } 
    Toast.makeText((Context)this, getString(g.e((Context)this, "upsdk_getting_message_fail_prompt_toast")), 0).show();
    finish();
  }
  
  public void b(int paramInt) {
    Toast.makeText((Context)this, getString(g.e((Context)this, "upsdk_connect_server_fail_prompt_toast")), 0).show();
    d.a().a(paramInt);
    finish();
  }
  
  public void finish() {
    if (this.g)
      overridePendingTransition(0, 0); 
    this.p = new Intent();
    this.p.putExtra("status", this.m);
    this.p.putExtra("failcause", this.n);
    this.p.putExtra("compulsoryUpdateCancel", this.g);
    this.p.putExtra("buttonstatus", this.o);
    d.a().b(this.p);
    super.finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt1 == 1002) {
      if (paramIntent != null) {
        com.huawei.updatesdk.a.b.c.b b1 = com.huawei.updatesdk.a.b.c.b.a(paramIntent);
        this.m = paramInt2;
        this.n = b1.a("installResultCode", -99);
        this.g = b1.a("compulsoryUpdateCancel", false);
      } 
      if (paramInt2 == 4) {
        paramInt1 = 100;
      } else {
        paramInt1 = 101;
      } 
      this.o = paramInt1;
      if (!this.h)
        finish(); 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    Serializable serializable;
    requestWindowFeature(1);
    com.huawei.updatesdk.a.a.c.h.b.d().a(getWindow());
    super.onCreate(paramBundle);
    Bundle bundle = com.huawei.updatesdk.a.b.c.b.a(getIntent()).b();
    if (bundle == null) {
      super.finish();
      return;
    } 
    paramBundle = null;
    try {
      Serializable serializable1 = bundle.getSerializable("app_update_parm");
      serializable = serializable1;
    } catch (Exception exception) {
      Log.e("AppUpdateActivity", "Type Conversion Error");
    } 
    if (serializable instanceof ApkUpgradeInfo) {
      this.i = (ApkUpgradeInfo)serializable;
      this.k = bundle.getBoolean("app_must_btn", false);
      if (this.i.getIsCompulsoryUpdate_() == 1)
        this.j = true; 
      if (!TextUtils.isEmpty(h.g().c()))
        this.a = h.g().c(); 
      if (this.i.getDevType_() != 1 || com.huawei.updatesdk.b.f.b.a((Context)this, this.a) != com.huawei.updatesdk.b.f.b.b.b) {
        d(this.i);
        return;
      } 
      a(this.i.getPackage_());
      return;
    } 
    this.m = 3;
    finish();
  }
  
  protected void onDestroy() {
    com.huawei.updatesdk.b.g.a a1 = this.c;
    if (a1 != null) {
      a1.a();
      this.c = null;
    } 
    a1 = this.d;
    if (a1 != null) {
      a1.a();
      this.d = null;
    } 
    a();
    e();
    super.onDestroy();
    finishActivity(1002);
  }
  
  class a implements DialogInterface.OnKeyListener {
    a(AppUpdateActivity this$0) {}
    
    public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
      if (param1Int == 4 && param1KeyEvent.getAction() == 0) {
        AppUpdateActivity.b(this.a, 4);
        this.a.finish();
        return true;
      } 
      return false;
    }
  }
  
  class b implements Runnable {
    b(AppUpdateActivity this$0, com.huawei.updatesdk.a.b.c.b param1b) {}
    
    public void run() {
      Bundle bundle = this.a.b();
      if (bundle == null)
        return; 
      int i = bundle.getInt("INSTALL_STATE");
      int j = bundle.getInt("INSTALL_TYPE");
      d.a().a(AppUpdateActivity.a(this.b, i, j, -1));
      AppUpdateActivity.a(this.b, i);
    }
  }
  
  class c implements com.huawei.updatesdk.b.g.b {
    c(AppUpdateActivity this$0) {}
    
    public void a() {
      AppUpdateActivity.d(this.a).setProgress(0);
      AppUpdateActivity.d(this.a).setMax(0);
      AppUpdateActivity.e(this.a).setText("");
      AppUpdateActivity.f(this.a);
      if (AppUpdateActivity.g(this.a) != null)
        AppUpdateActivity.g(this.a).a(); 
      AppUpdateActivity.h(this.a).a();
      if (AppUpdateActivity.i(this.a)) {
        AppUpdateActivity appUpdateActivity = this.a;
        AppUpdateActivity.b(appUpdateActivity, AppUpdateActivity.j(appUpdateActivity));
        return;
      } 
      AppUpdateActivity.b(this.a, 4);
      this.a.finish();
    }
    
    public void b() {
      AppUpdateActivity.h(this.a).a();
    }
  }
  
  class d implements com.huawei.updatesdk.b.g.a.d {
    d(AppUpdateActivity this$0) {}
    
    public void a() {
      this.a.finish();
    }
  }
  
  class e implements View.OnClickListener {
    e(AppUpdateActivity this$0, String param1String) {}
    
    public void onClick(View param1View) {
      AppUpdateActivity.a(this.b, this.a);
    }
  }
  
  class f implements com.huawei.updatesdk.b.g.b {
    f(AppUpdateActivity this$0, ApkUpgradeInfo param1ApkUpgradeInfo, com.huawei.updatesdk.b.g.a param1a) {}
    
    public void a() {
      if (!com.huawei.updatesdk.a.a.c.i.b.d((Context)this.c)) {
        AppUpdateActivity appUpdateActivity = this.c;
        Toast.makeText((Context)appUpdateActivity, g.e((Context)appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
        this.c.finish();
        return;
      } 
      AppUpdateActivity.a(this.c, this.a);
      this.b.a();
    }
    
    public void b() {
      this.b.a();
      if (AppUpdateActivity.i(this.c)) {
        AppUpdateActivity appUpdateActivity = this.c;
        AppUpdateActivity.b(appUpdateActivity, AppUpdateActivity.j(appUpdateActivity));
        return;
      } 
      AppUpdateActivity.b(this.c, 4);
      this.c.finish();
    }
  }
  
  class g implements com.huawei.updatesdk.b.g.a.d {
    g(AppUpdateActivity this$0) {}
    
    public void a() {
      this.a.finish();
    }
  }
  
  class h implements DialogInterface.OnKeyListener {
    h(AppUpdateActivity this$0, com.huawei.updatesdk.b.g.a param1a) {}
    
    public boolean onKey(DialogInterface param1DialogInterface, int param1Int, KeyEvent param1KeyEvent) {
      if (param1Int == 4 && param1KeyEvent.getAction() == 0) {
        if (AppUpdateActivity.i(this.b)) {
          this.a.a();
          AppUpdateActivity appUpdateActivity = this.b;
          AppUpdateActivity.b(appUpdateActivity, AppUpdateActivity.j(appUpdateActivity));
          return true;
        } 
        AppUpdateActivity.b(this.b, 4);
        this.b.finish();
        return true;
      } 
      return false;
    }
  }
  
  class i implements com.huawei.updatesdk.b.g.b {
    i(AppUpdateActivity this$0) {}
    
    public void a() {
      AppUpdateActivity.c(this.a, 101);
      if (!com.huawei.updatesdk.a.a.c.i.b.d((Context)this.a)) {
        AppUpdateActivity appUpdateActivity = this.a;
        Toast.makeText((Context)appUpdateActivity, g.e((Context)appUpdateActivity, "upsdk_no_available_network_prompt_toast"), 0).show();
        AppUpdateActivity.b(this.a, 2);
        this.a.finish();
        return;
      } 
      AppUpdateActivity.a(this.a);
    }
    
    public void b() {
      AppUpdateActivity.b(this.a).a();
      AppUpdateActivity.b(this.a, 4);
      AppUpdateActivity.c(this.a, 100);
      if (!AppUpdateActivity.i(this.a)) {
        c c = new c();
        AppUpdateActivity appUpdateActivity = this.a;
        c.a((Context)appUpdateActivity, AppUpdateActivity.c(appUpdateActivity), new AppUpdateActivity.k(this.a));
        return;
      } 
      this.a.finish();
    }
  }
  
  class j implements com.huawei.updatesdk.b.g.a.d {
    j(AppUpdateActivity this$0) {}
    
    public void a() {
      this.a.finish();
    }
  }
  
  public class k implements c.a {
    public k(AppUpdateActivity this$0) {}
    
    public void a(Boolean param1Boolean) {
      if (param1Boolean.booleanValue())
        try {
          Intent intent = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
          intent.setPackage(AppUpdateActivity.c(this.a));
          this.a.startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("goHiappUpgrade error: ");
          stringBuilder.append(activityNotFoundException.toString());
          com.huawei.updatesdk.a.a.b.a.a.a.b("AppUpdateActivity", stringBuilder.toString());
        }  
      this.a.finish();
    }
  }
  
  static class l implements DialogInterface.OnDismissListener {
    private l() {}
    
    public void onDismiss(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      intent.putExtra("dialogstatus", 10001);
      d.a().b(intent);
    }
  }
  
  static class m implements DialogInterface.OnShowListener {
    private m() {}
    
    public void onShow(DialogInterface param1DialogInterface) {
      Intent intent = new Intent();
      intent.putExtra("dialogstatus", 10002);
      d.a().b(intent);
    }
  }
  
  class n extends com.huawei.updatesdk.a.b.c.a {
    private n(AppUpdateActivity this$0) {}
    
    public void a(Context param1Context, com.huawei.updatesdk.a.b.c.b param1b) {
      if (!param1b.d())
        return; 
      if (AppUpdateActivity.h(this.a) != null)
        AppUpdateActivity.h(this.a).a(); 
      AppUpdateActivity.f(this.a);
      String str1 = param1b.a();
      String str2 = param1b.c().getDataString();
      if (str2 != null) {
        if (str2.length() < 9)
          return; 
        str2 = str2.substring(8);
        if ("android.intent.action.PACKAGE_ADDED".equals(str1) && AppUpdateActivity.c(this.a).equals(str2)) {
          d.a().a(AppUpdateActivity.a(this.a, 6, 0, -1));
          com.huawei.updatesdk.b.f.b.a();
          AppUpdateActivity appUpdateActivity = this.a;
          AppUpdateActivity.a(appUpdateActivity, AppUpdateActivity.j(appUpdateActivity).getPackage_(), AppUpdateActivity.j(this.a).getDetailId_());
          if (AppUpdateActivity.i(this.a)) {
            appUpdateActivity = this.a;
            AppUpdateActivity.b(appUpdateActivity, AppUpdateActivity.j(appUpdateActivity));
          } 
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\AppUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */