package com.soft.blued.sdk.ui;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.sdk.SDKBaseAction;
import com.soft.blued.sdk.SDKPayAction;
import com.soft.blued.sdk.model.SDKPayBalanceModel;
import com.soft.blued.sdk.model.SDKPayConsumeModel;
import com.soft.blued.sdk.model.SDKPayOrderModel;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment;
import com.soft.blued.user.UserInfo;

public class SDKPayPresenter implements SDKPayContract.IPresenter {
  Context a;
  
  long b;
  
  int c;
  
  String d;
  
  String e;
  
  String f;
  
  String g;
  
  String h;
  
  String i;
  
  SDKPayContract.IView j;
  
  private String k;
  
  private int l = 0;
  
  public SDKPayPresenter(Context paramContext, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, SDKPayContract.IView paramIView) {
    this.a = paramContext;
    this.b = paramLong;
    this.c = paramInt;
    this.d = paramString1;
    this.e = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.f = paramString5;
    this.i = paramString6;
    this.j = paramIView;
  }
  
  private void b(String paramString) {
    this.j.a();
    PayHttpUtils.a((HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<SDKPayConsumeModel>>(this) {
          private SDKPayConsumeModel b = null;
          
          private int c = 0;
          
          public void a(BluedEntityA<SDKPayConsumeModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.size() <= 0)
                return; 
              this.b = param1BluedEntityA.data.get(0);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.c = param1Int;
            if (param1Int != 403000203 && param1Int != 403000213 && param1Int != 403000210 && param1Int != 403000212 && !TextUtils.isEmpty(param1String))
              AppMethods.a(param1String); 
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.a.j.b();
            if (this.b == null) {
              int i = this.c;
              if (i == 403000203) {
                this.a.j.i();
                return;
              } 
              if (i == 403000213) {
                this.a.j.aF_();
                return;
              } 
              if (i == 403000210 && SDKPayPresenter.b(this.a) == 0) {
                SDKPayPresenter.a(this.a, 1);
                this.a.a((String)null);
                return;
              } 
              if (this.c == 403000212) {
                AppMethods.d(2131758654);
                return;
              } 
            } else {
              SDKBaseAction sDKBaseAction = SDKActionManager.b(this.a.b);
              if (sDKBaseAction != null && sDKBaseAction instanceof SDKPayAction)
                ((SDKPayAction)sDKBaseAction).a(this.a.a, 0, 0, this.b.balance); 
              this.a.j.h();
            } 
          }
        }(IRequestHost)this.j.w_(), this.k, paramString, this.d, this.e, this.g, this.h, this.f, this.i);
  }
  
  public void a(String paramString) {
    if (TextUtils.isEmpty(this.k))
      return; 
    if (this.l == 1 && TextUtils.isEmpty(paramString)) {
      this.j.aE_();
      return;
    } 
    b(paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.j.a(UserInfo.a().c());
    if (paramBoolean)
      PayHttpUtils.a((HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<SDKPayBalanceModel>>(this) {
            public void a(BluedEntityA<SDKPayBalanceModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
                SDKPayBalanceModel sDKPayBalanceModel = param1BluedEntityA.data.get(0);
                if (sDKPayBalanceModel != null) {
                  UserInfo.a().a(sDKPayBalanceModel.balance);
                  this.a.j.a(sDKPayBalanceModel.balance);
                } 
              } 
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              if (!TextUtils.isEmpty(param1String))
                AppMethods.a(param1String); 
              return true;
            }
          },  (IRequestHost)this.j.w_(), this.d, this.e, this.g, this.h, this.f); 
  }
  
  public void b() {
    BeansPrePayFragment.a(this.a, 0);
  }
  
  public void bb_() {
    d();
  }
  
  public void c() {
    TerminalActivity.d(this.a, PayPasswordSettingFragment.class, null);
  }
  
  public void d() {
    this.j.a();
    this.j.aD_();
    PayHttpUtils.a((HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<SDKPayOrderModel>>(this) {
          private int b = 0;
          
          public void a(BluedEntityA<SDKPayOrderModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.size() <= 0)
                return; 
              SDKPayOrderModel sDKPayOrderModel = param1BluedEntityA.data.get(0);
              this.a.j.a(sDKPayOrderModel.beans);
              this.a.j.c(sDKPayOrderModel.goods_name);
              this.a.j.b(sDKPayOrderModel.orders_id);
              this.a.j.a(sDKPayOrderModel.name);
              this.a.j.e();
              SDKPayPresenter.a(this.a, sDKPayOrderModel.orders_id);
              SDKPayPresenter.a(this.a, sDKPayOrderModel.has_payment);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b = param1Int;
            if (!TextUtils.isEmpty(param1String))
              AppMethods.a(param1String); 
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            this.a.j.b();
            if (TextUtils.isEmpty(SDKPayPresenter.a(this.a))) {
              SDKBaseAction sDKBaseAction = SDKActionManager.b(this.a.b);
              if (sDKBaseAction != null && sDKBaseAction instanceof SDKPayAction)
                ((SDKPayAction)sDKBaseAction).a(this.a.a, 1, this.b, 0); 
              this.a.j.h();
            } 
          }
        }(IRequestHost)this.j.w_(), this.c, this.d, this.e, this.g, this.h, this.f);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\sd\\ui\SDKPayPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */