package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.soft.blued.customview.CommonTopTitleNoTrans;

public class GiftVoucherHelpPop extends BottomPopupView {
  public static GiftVoucherHelpPop b;
  
  private CommonTopTitleNoTrans c;
  
  public GiftVoucherHelpPop(Context paramContext) {
    super(paramContext);
  }
  
  public void b() {
    super.b();
    this.c = (CommonTopTitleNoTrans)findViewById(2131300300);
    this.c.setLeftImg(2131232438);
    this.c.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
          }
        });
    this.c.setCenterText(getContext().getString(2131759330));
  }
  
  public int getImplLayoutId() {
    return 2131494043;
  }
  
  public void t() {
    super.t();
    b = null;
  }
  
  public void v() {
    super.v();
    b = this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\GiftVoucherHelpPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */