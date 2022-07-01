package com.soft.blued.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.CommonTools;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.constant.ShareCoreConstants;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.mobevent.MobEventUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.pay.model.VIPPayResult;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends BaseFragmentActivity implements IWXAPIEventHandler {
  private String c = "";
  
  private String d = "";
  
  private IWXAPI e;
  
  private ProgressBar f;
  
  public static void a(Context paramContext, String paramString) {
    Intent intent = new Intent(paramContext, WXPayEntryActivity.class);
    intent.putExtra("RESULT", paramString);
    intent.putExtra("from", "alipay");
    paramContext.startActivity(intent);
  }
  
  public void a(String paramString1, String paramString2) {
    PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<VIPPayResult>>(this, (IRequestHost)new ActivityFragmentActive(getLifecycle())) {
          protected void a(BluedEntityA<VIPPayResult> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                  String str = AesCrypto.c(((VIPPayResult)param1BluedEntityA.data.get(0))._);
                  boolean bool = true;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("result==");
                  stringBuilder.append(str);
                  Logger.c("getVIPPayResult", new Object[] { stringBuilder.toString() });
                  VIPPayResult vIPPayResult = (VIPPayResult)AppInfo.f().fromJson(str, VIPPayResult.class);
                  if (vIPPayResult.status == 1) {
                    MobEventUtils.a();
                    if ((vIPPayResult.activity_id == 3 || vIPPayResult.activity_id == 4) && vIPPayResult.user_info != null && vIPPayResult.extra != null) {
                      AppMethods.a(this.a.getResources().getString(2131758348));
                      ChatHelperV4.a().a((Context)this.a, vIPPayResult.user_info, 1, vIPPayResult.extra.info_1, vIPPayResult.extra.info_2, vIPPayResult.extra.product_vip_grade, 0, "");
                    } 
                    BluedConfig.b().d();
                    VIPBuyResultObserver.a().a(vIPPayResult.ops, true);
                    AppInfo.n().postDelayed(new Runnable(this, vIPPayResult) {
                          public void run() {
                            if (this.a.lucky_list != null && this.a.lucky_list.size() > 0) {
                              FuGiftListEvent fuGiftListEvent = new FuGiftListEvent();
                              fuGiftListEvent.a = this.a.lucky_list;
                              LiveEventBus.get("buy_fu", FuGiftListEvent.class).post(fuGiftListEvent);
                            } 
                          }
                        }1000L);
                    if (vIPPayResult.is_dialog == 1) {
                      int i = vIPPayResult.ops;
                      if (i != 2 && i != 3) {
                        if (i != 4) {
                          this.a.finish();
                          AppMethods.a(this.a.getResources().getString(2131755153));
                          return;
                        } 
                        this.a.finish();
                        Observable observable = LiveEventBus.get("call_buy_open");
                        if (vIPPayResult.is_secret_dialog != 1)
                          bool = false; 
                        observable.post(Boolean.valueOf(bool));
                        return;
                      } 
                      PopMenuUtils.a((Context)this.a, new PopMenuFromCenter.DismissListner(this) {
                            public void dissmiss(boolean param2Boolean) {
                              this.a.a.finish();
                            }
                          });
                      return;
                    } 
                    this.a.finish();
                    AppMethods.a(this.a.getResources().getString(2131755153));
                    return;
                  } 
                  this.a.finish();
                  VIPBuyResultObserver.a().a(0, false);
                  AppMethods.a(this.a.getResources().getString(2131755151));
                  return;
                } 
                this.a.finish();
                VIPBuyResultObserver.a().a(0, false);
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              } catch (Exception exception) {
                this.a.finish();
                VIPBuyResultObserver.a().a(0, false);
                AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                return;
              }  
            this.a.finish();
            VIPBuyResultObserver.a().a(0, false);
            AppMethods.a(AppInfo.d().getResources().getString(2131756082));
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onUIFailure====");
            stringBuilder.append(param1String);
            Logger.e("WXPay", new Object[] { stringBuilder.toString() });
            VIPBuyResultObserver.a().a(0, false);
            this.a.finish();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (CommonTools.a((Activity)this.a))
              WXPayEntryActivity.a(this.a).setVisibility(8); 
          }
          
          public void onUIStart() {
            WXPayEntryActivity.a(this.a).setVisibility(0);
            super.onUIStart();
          }
        }(IRequestHost)new ActivityFragmentActive(getLifecycle()), paramString1, paramString2);
  }
  
  public void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setContentView(2131493261);
    this.f = (ProgressBar)findViewById(2131299453);
    Intent intent = getIntent();
    if (intent != null) {
      this.c = intent.getStringExtra("RESULT");
      this.d = intent.getStringExtra("from");
    } 
    if ("alipay".equals(this.d)) {
      if (!TextUtils.isEmpty(this.c)) {
        a(this.d, this.c);
        return;
      } 
      VIPBuyResultObserver.a().a(0, false);
      AppMethods.a(getResources().getString(2131755140));
      return;
    } 
    this.e = WXAPIFactory.createWXAPI((Context)this, ShareCoreConstants.a());
    this.e.handleIntent(getIntent(), this);
  }
  
  public void onDestroy() {
    getWindow().setFlags(2048, 2048);
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.e.handleIntent(paramIntent, this);
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp) {
    if (paramBaseResp.getType() == 5) {
      PayResp payResp = (PayResp)paramBaseResp;
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0) {
          VIPBuyResultObserver.a().a(0, false);
          AppMethods.a(getResources().getString(2131755140));
          finish();
          return;
        } 
        a("weixin", payResp.prepayId);
        return;
      } 
      VIPBuyResultObserver.a().a(0, false);
      AppMethods.a(getResources().getString(2131755139));
      finish();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\wxapi\WXPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */