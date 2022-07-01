package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.alipay.sdk.app.PayTask;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.model.PayRemaining;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.ui.pay.model.VIPPayResult;
import com.soft.blued.ui.user.model.AliPayResult;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.model.VIPAutoChargeOrderForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.Serializable;
import java.util.Map;

public class PayAutoChargeActivity extends BaseFragmentActivity {
  public Context c;
  
  private GoodsOptionBasic d;
  
  private ProgressBar e;
  
  private IWXAPI f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private boolean j = false;
  
  private String k;
  
  private Dialog l;
  
  private int m = -1;
  
  private int n = 0;
  
  private int o;
  
  private boolean p = false;
  
  private boolean q = false;
  
  public static void a(Context paramContext, GoodsOptionBasic paramGoodsOptionBasic, String paramString1, String paramString2, String paramString3, int paramInt) {
    Intent intent = new Intent(paramContext, PayAutoChargeActivity.class);
    intent.putExtra("KEY_ITEM_BUY_OPTION", (Serializable)paramGoodsOptionBasic);
    intent.putExtra("KEY_TARGET_UID", paramString1);
    intent.putExtra("KEY_ACTIVITY_ID", paramString2);
    intent.putExtra("KEY_VIP_DETAIL", paramString3);
    intent.putExtra("KEY_PAY_PLAT_FORM", paramInt);
    paramContext.startActivity(intent);
  }
  
  private void a(VIPAutoChargeOrderForJsonParse paramVIPAutoChargeOrderForJsonParse) {
    OpenWebview.Req req = new OpenWebview.Req();
    req.url = paramVIPAutoChargeOrderForJsonParse.entrust_url;
    this.k = paramVIPAutoChargeOrderForJsonParse.contract_code;
    this.f.sendReq((BaseReq)req);
  }
  
  private void b(VIPAutoChargeOrderForJsonParse paramVIPAutoChargeOrderForJsonParse) {
    this.q = true;
    try {
      (new Thread(new -$$Lambda$PayAutoChargeActivity$RwX_i5RaJDCNb5ZOO4gb5E9drlI(this, paramVIPAutoChargeOrderForJsonParse))).start();
      return;
    } catch (Exception exception) {
      this.q = false;
      VIPBuyResultObserver.a().a(0, false);
      AppMethods.a(AppInfo.d().getResources().getString(2131756082));
      finish();
      return;
    } 
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    Logger.a("auto_charge", "end query");
    DialogUtils.b(this.l);
    VIPBuyResultObserver.a().a(paramInt, paramBoolean);
    finish();
  }
  
  public void b(boolean paramBoolean) {
    UserHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this, (IRequestHost)a()) {
          boolean a = true;
          
          protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
            try {
              String str = AesCrypto.c(((PayRemaining)param1BluedEntityA.data.get(0))._);
              if (AppInfo.m()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("get order back:");
                stringBuilder.append(str);
                Logger.a("auto_charge", stringBuilder.toString());
              } 
              VIPAutoChargeOrderForJsonParse vIPAutoChargeOrderForJsonParse = (VIPAutoChargeOrderForJsonParse)AppInfo.f().fromJson(str, VIPAutoChargeOrderForJsonParse.class);
              int i = PayAutoChargeActivity.b(this.b);
              if (i != 1)
                if (i != 2) {
                  if (i != 4)
                    return; 
                } else {
                  if (this.b.h()) {
                    PayAutoChargeActivity.b(this.b, vIPAutoChargeOrderForJsonParse);
                    return;
                  } 
                  this.b.finish();
                  return;
                }  
              PayAutoChargeActivity.a(this.b, vIPAutoChargeOrderForJsonParse);
              return;
            } catch (Exception exception) {
              AppMethods.a(AppInfo.d().getResources().getString(2131756082));
              Logger.a("auto_charge", "finish at getVIPAutoChargeOrder 200 error");
              this.b.finish();
              return;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 4032020) {
              this.a = false;
              CommonAlertDialog.a(this.b.c, "", param1String, this.b.c.getResources().getString(2131756100), new -$$Lambda$PayAutoChargeActivity$2$GE_5M5TUOkh4WMIJqkdAq5nmdJI(this), this.b.c.getResources().getString(2131755726), new -$$Lambda$PayAutoChargeActivity$2$GptYYC7rMHNtAAz2Oq2NEYAT19E(this), null).setCancelable(false);
              return true;
            } 
            if (param1Int == 4032021) {
              CommonAlertDialog.a(this.b.c, "", param1String, this.b.c.getResources().getString(2131756100), new -$$Lambda$PayAutoChargeActivity$2$aFlqhQBFRnwqxe3e58lJw_Ql5-o(this), null, 0).setOnCancelListener(new -$$Lambda$PayAutoChargeActivity$2$pG4y-EhFmSgwoOeEEJynDsktyqA(this));
              this.a = false;
              return true;
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            onUIFinish();
            PayAutoChargeActivity.e(this.b).setVisibility(4);
            if (!param1Boolean && this.a)
              this.b.finish(); 
          }
          
          public void onUIStart() {
            super.onUIStart();
            PayAutoChargeActivity.e(this.b).setVisibility(0);
          }
        }this.d.c_id, PayHttpUtils.a(this.o), 0.0D, this.d.vip_grade, 0, this.g, this.h, this.i, paramBoolean, (IRequestHost)a());
  }
  
  public boolean h() {
    boolean bool;
    if (this.f.getWXAppSupportAPI() >= 570425345) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      Toast.makeText((Context)this, getResources().getString(2131755146), 0).show();
      Logger.e("PayAutoChargeActivity", new Object[] { "checkWXPayEnviroment=======" });
    } 
    return bool;
  }
  
  public void i() {
    DialogUtils.a(this.l);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("query result start ifQueryStarted:");
    stringBuilder.append(this.p);
    Logger.a("auto_charge", stringBuilder.toString());
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            UserHttpUtils.a((IRequestHost)this.a.a(), PayAutoChargeActivity.a(this.a), PayHttpUtils.a(PayAutoChargeActivity.b(this.a)), new BluedUIHttpResponse<BluedEntityA<VIPPayResult>>(this, (IRequestHost)this.a.a()) {
                  protected void a(BluedEntityA<VIPPayResult> param2BluedEntityA) {
                    try {
                      String str = AesCrypto.c(((VIPPayResult)param2BluedEntityA.data.get(0))._);
                      if (AppInfo.m()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("query result back:");
                        stringBuilder.append(str);
                        Logger.a("auto_charge", stringBuilder.toString());
                      } 
                      VIPPayResult vIPPayResult = (VIPPayResult)AppInfo.f().fromJson(str, VIPPayResult.class);
                      PayAutoChargeActivity.a(this.a.a, vIPPayResult.status);
                      PayAutoChargeActivity.b(this.a.a, vIPPayResult.is_dialog);
                      if (vIPPayResult.status == 3) {
                        MobEventUtils.a();
                        BluedConfig.b().e();
                        DialogUtils.b(PayAutoChargeActivity.c(this.a.a));
                        if (PayAutoChargeActivity.d(this.a.a) == 1) {
                          PopMenuUtils.a(this.a.a.c, new -$$Lambda$PayAutoChargeActivity$1$1$jqF5FP7JowNsGqpRXXzpufcpdWk(this));
                          return;
                        } 
                        AppMethods.d(2131756206);
                        this.a.a.a(2, true);
                        return;
                      } 
                      AppMethods.d(2131756082);
                      this.a.a.a(2, false);
                      return;
                    } catch (Exception exception) {
                      AppMethods.d(2131756082);
                      this.a.a.a(2, false);
                      return;
                    } 
                  }
                  
                  public boolean onUIFailure(int param2Int, String param2String) {
                    this.a.a.a(2, false);
                    return super.onUIFailure(param2Int, param2String);
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                  }
                });
          }
        }1500L);
  }
  
  public void j() {
    Context context = this.c;
    this.l = DialogUtils.a(context, context.getResources().getString(2131755018), false);
    this.e = (ProgressBar)findViewById(2131299453);
    b(false);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.c = (Context)this;
    setContentView(2131493036);
    if (getIntent() != null) {
      this.d = (GoodsOptionBasic)getIntent().getSerializableExtra("KEY_ITEM_BUY_OPTION");
      this.g = getIntent().getStringExtra("KEY_TARGET_UID");
      this.h = getIntent().getStringExtra("KEY_ACTIVITY_ID");
      this.i = getIntent().getStringExtra("KEY_VIP_DETAIL");
      this.o = getIntent().getIntExtra("KEY_PAY_PLAT_FORM", 1);
    } 
    j();
    StatusBarHelper.a((Activity)this, false);
    this.f = WXAPIFactory.createWXAPI(this.c, ShareCoreConstants.a(), false);
    this.f.registerApp(ShareCoreConstants.a());
  }
  
  public void onDestroy() {
    super.onDestroy();
    Logger.a("auto_charge", "activity on destroy");
  }
  
  public void onResume() {
    super.onResume();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResume:");
    stringBuilder.append(this.j);
    stringBuilder.append(";");
    stringBuilder.append(this.k);
    Logger.a("auto_charge", stringBuilder.toString());
    if (this.j) {
      if (!StringUtils.e(this.k)) {
        if (!this.p) {
          i();
          this.p = true;
          return;
        } 
      } else if (!this.q) {
        finish();
        return;
      } 
    } else {
      this.j = true;
    } 
  }
  
  public static interface RESULTCODE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\PayAutoChargeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */