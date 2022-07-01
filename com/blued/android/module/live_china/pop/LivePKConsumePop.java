package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;

public class LivePKConsumePop extends CenterPopupView {
  public Context c;
  
  public final String d = "LivePKConsumePop";
  
  private CardView e;
  
  private View f;
  
  private View g;
  
  public LivePKConsumePop(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
  }
  
  public static void a(BaseFragment paramBaseFragment) {
    LivePKConsumePop livePKConsumePop = new LivePKConsumePop(paramBaseFragment.getContext());
    (new XPopup.Builder(paramBaseFragment.getContext())).a(new XPopupCallback() {
          public void a(BasePopupView param1BasePopupView) {}
          
          public void a(BasePopupView param1BasePopupView, int param1Int) {}
          
          public void a(BasePopupView param1BasePopupView, int param1Int, float param1Float, boolean param1Boolean) {}
          
          public void b(BasePopupView param1BasePopupView) {}
          
          public void c(BasePopupView param1BasePopupView) {}
          
          public void d(BasePopupView param1BasePopupView) {}
          
          public void e(BasePopupView param1BasePopupView) {}
          
          public boolean f(BasePopupView param1BasePopupView) {
            return false;
          }
        }).a((BasePopupView)livePKConsumePop).h();
  }
  
  private void c() {
    View view = findViewById(R.id.fl_root);
    this.f = findViewById(R.id.iv_close);
    this.g = findViewById(R.id.tv_ok);
    this.e = (CardView)findViewById(R.id.card_view);
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    view.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
          }
        });
    this.g.setOnClickListener(new -$$Lambda$LivePKConsumePop$Q58qg-IMH2VjvUIS73J-iUYAzJg(this));
    this.f.setOnClickListener(new -$$Lambda$LivePKConsumePop$fH9coEDn4YC-NieWPpUBkm3-z3M(this));
  }
  
  public void b() {
    super.b();
    c();
  }
  
  public int getImplLayoutId() {
    return R.layout.live_pop_pk_consume;
  }
  
  public int getMaxWidth() {
    return XPopupUtils.a(getContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LivePKConsumePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */