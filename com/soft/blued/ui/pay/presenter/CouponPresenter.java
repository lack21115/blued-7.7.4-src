package com.soft.blued.ui.pay.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.pay.model.BluedCoupon;
import com.soft.blued.utils.Logger;

public class CouponPresenter extends MvpPresenter {
  public static String j = "KEY_GOOD_ID";
  
  public static String l = "KEY_CHOOSED_COUPON_ID";
  
  public int h = 1;
  
  public int i = 20;
  
  public int k;
  
  public int m;
  
  private BluedUIHttpResponse c(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<BluedCoupon>>(this, "coupon_list", g(), paramIFetchDataListener) {
        protected void a(BluedEntityA<BluedCoupon> param1BluedEntityA) {
          if (param1BluedEntityA != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("choosedCouponID:");
            stringBuilder.append(this.b.m);
            Logger.a("coupon", stringBuilder.toString());
            if (this.b.m > 0 && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              for (int i = 0; i < param1BluedEntityA.data.size(); i++) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("couponid:");
                stringBuilder.append(((BluedCoupon)param1BluedEntityA.data.get(i)).id);
                Logger.a("coupon", stringBuilder.toString());
                if (this.b.m == ((BluedCoupon)param1BluedEntityA.data.get(i)).id && ((BluedCoupon)param1BluedEntityA.data.get(i)).is_available == 1)
                  ((BluedCoupon)param1BluedEntityA.data.get(i)).ifChoosed = true; 
              }  
            this.a.a("fresh", param1BluedEntityA.data);
            if (!param1BluedEntityA.hasMore())
              this.a.b(); 
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          this.a.a(param1Boolean);
          if (!param1Boolean) {
            CouponPresenter couponPresenter = this.b;
            couponPresenter.h--;
          } 
        }
        
        public void onUIStart() {
          super.onUIStart();
          this.a.a();
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.k = paramBundle1.getInt(j);
      this.m = paramBundle1.getInt(l);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get couponid:");
      stringBuilder.append(this.m);
      Logger.a("coupon", stringBuilder.toString());
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    PayHttpUtils.a(c(paramIFetchDataListener), this.h, this.i, this.k, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    PayHttpUtils.a(c(paramIFetchDataListener), this.h, this.i, this.k, g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\presenter\CouponPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */