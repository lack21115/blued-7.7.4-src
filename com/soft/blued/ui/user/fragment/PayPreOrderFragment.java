package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.GoodsOptionBasic;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import java.io.Serializable;

public class PayPreOrderFragment extends BaseFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {
  private static final String f = PayPreOrderFragment.class.getSimpleName();
  
  public Context d;
  
  public View e;
  
  private PayUtils g;
  
  private ProgressBar h;
  
  private GoodsOptionBasic i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private int o;
  
  private int p = 1;
  
  public static void a(Context paramContext, GoodsOptionBasic paramGoodsOptionBasic, String paramString1, String paramString2, int paramInt) {
    a(paramContext, paramGoodsOptionBasic, paramString1, "", "", "", paramString2, paramInt, 0, (IRequestHost)null);
  }
  
  public static void a(Context paramContext, GoodsOptionBasic paramGoodsOptionBasic, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    a(paramContext, paramGoodsOptionBasic, paramString1, paramString2, paramString3, paramString4, paramString5, 0, 0, (IRequestHost)null);
  }
  
  public static void a(Context paramContext, GoodsOptionBasic paramGoodsOptionBasic, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder;
    String str1 = paramString1;
    Logger.a("buy_vip", paramGoodsOptionBasic);
    String str2 = "";
    if (paramInt1 != 0) {
      if (paramGoodsOptionBasic != null) {
        PayUtils payUtils = new PayUtils(paramContext, paramString1, paramIRequestHost);
        payUtils.a(paramString2, paramString3, paramString4, paramString5, paramInt2);
        stringBuilder = new StringBuilder();
        stringBuilder.append("directToPlatform:");
        stringBuilder.append(paramInt1);
        Log.v("drb", stringBuilder.toString());
        if (paramInt1 != 1)
          if (paramInt1 != 2) {
            if (paramInt1 != 3) {
              if (paramInt1 != 4)
                return; 
            } else {
              payUtils.a(paramContext, paramGoodsOptionBasic, "", false, BluedPreferences.U(""), paramString5);
              return;
            } 
          } else {
            if (paramGoodsOptionBasic.wx_contract == 1 && paramInt2 == 0) {
              PayAutoChargeActivity.a(paramContext, paramGoodsOptionBasic, paramString2, paramString3, paramString5, paramInt1);
              return;
            } 
            payUtils.a(2, paramGoodsOptionBasic, paramGoodsOptionBasic.vip_grade);
            return;
          }  
        if (paramGoodsOptionBasic.alipay_contract == 1) {
          PayAutoChargeActivity.a(paramContext, paramGoodsOptionBasic, paramString2, paramString3, paramString5, paramInt1);
          return;
        } 
        payUtils.a(paramInt1, paramGoodsOptionBasic, paramGoodsOptionBasic.vip_grade);
        return;
      } 
    } else {
      String str4;
      Bundle bundle = new Bundle();
      bundle.putSerializable("KEY_ITEM_BUY_OPTION", (Serializable)paramGoodsOptionBasic);
      String str3 = str1;
      if (str1 == null)
        str3 = "my"; 
      bundle.putString("KEY_PAY_FROM", str3);
      if (paramString2 == null)
        paramString2 = ""; 
      bundle.putString("KEY_TARGET_UID", paramString2);
      if (paramString3 == null)
        paramString3 = ""; 
      bundle.putString("KEY_ACTIVITY_ID", paramString3);
      if (stringBuilder == null)
        str4 = ""; 
      bundle.putString("KEY_EXCHANGE_ID", str4);
      bundle.putInt("KEY_COUPON_ID", paramInt2);
      if (paramString5 == null)
        paramString5 = str2; 
      bundle.putString("KEY_DETAIL", paramString5);
      TransparentActivity.a(bundle);
      TransparentActivity.b(paramContext, PayPreOrderFragment.class, bundle);
    } 
  }
  
  public boolean V_() {
    getActivity().finish();
    return super.V_();
  }
  
  public void a() {
    this.h = (ProgressBar)this.e.findViewById(2131299453);
    this.h.setVisibility(4);
    this.e.setOnClickListener(new -$$Lambda$PayPreOrderFragment$6HspfWKG67nvX6WG38XMgQVsjrE(this));
    NormalPayTypeChoosePop.a(this.d, new NormalPayTypeChoosePop.iChoosePayResultListener(this) {
          public void a() {}
          
          public void a(int param1Int, boolean param1Boolean) {
            PayPreOrderFragment.a(this.a, param1Int);
            this.a.a(true);
          }
        }this.p, this.i.id, (IRequestHost)w_());
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    a(new Runnable(this, paramBoolean) {
          public void run() {
            LiveEventBusUtil.a(this.a);
            if (this.b.getActivity() != null)
              this.b.getActivity().finish(); 
          }
        }500L);
  }
  
  public void a(boolean paramBoolean) {
    int i = this.p;
    if (i != 1)
      if (i != 2) {
        if (i != 4)
          return; 
      } else {
        if (this.i.wx_contract == 1 && this.o == 0 && paramBoolean) {
          PayAutoChargeActivity.a(this.d, this.i, this.k, this.l, this.n, this.p);
          return;
        } 
        PayUtils payUtils1 = this.g;
        GoodsOptionBasic goodsOptionBasic1 = this.i;
        payUtils1.a(2, goodsOptionBasic1, goodsOptionBasic1.vip_grade);
        return;
      }  
    if (this.i.alipay_contract == 1 && this.o == 0 && paramBoolean) {
      PayAutoChargeActivity.a(this.d, this.i, this.k, this.l, this.n, this.p);
      return;
    } 
    PayUtils payUtils = this.g;
    i = this.p;
    GoodsOptionBasic goodsOptionBasic = this.i;
    payUtils.a(i, goodsOptionBasic, goodsOptionBasic.vip_grade);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    getActivity().overridePendingTransition(2130772039, 2130772039);
    if (this.e == null) {
      this.e = paramLayoutInflater.inflate(2131493037, paramViewGroup, false);
      if (getArguments() != null) {
        this.i = (GoodsOptionBasic)getArguments().getSerializable("KEY_ITEM_BUY_OPTION");
        this.j = getArguments().getString("KEY_PAY_FROM");
        this.k = getArguments().getString("KEY_TARGET_UID");
        this.l = getArguments().getString("KEY_ACTIVITY_ID");
        this.m = getArguments().getString("KEY_EXCHANGE_ID");
        this.n = getArguments().getString("KEY_DETAIL");
        this.o = getArguments().getInt("KEY_COUPON_ID");
        this.p = getArguments().getInt("KEY_PAY_PLAT_FORM");
      } 
      this.g = new PayUtils((Context)getActivity(), this.j, (IRequestHost)w_());
      this.g.a(this.k, this.l, this.m, this.n, this.o);
      a();
      StatusBarHelper.a((Activity)getActivity(), false);
      VIPBuyResultObserver.a().a(this, getLifecycle());
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\PayPreOrderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */