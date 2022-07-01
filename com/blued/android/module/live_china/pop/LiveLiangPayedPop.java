package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LiveLiangPayedPop extends CenterPopupView {
  public Context c;
  
  public final String d = "LiveLiangPayedPop";
  
  private ImageView e;
  
  private TextView f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private String j;
  
  private long k = 0L;
  
  private int t;
  
  public LiveLiangPayedPop(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString, long paramLong, int paramInt) {
    LiveLiangPayedPop liveLiangPayedPop = new LiveLiangPayedPop(paramBaseFragment.getContext());
    liveLiangPayedPop.j = paramString;
    liveLiangPayedPop.k = paramLong;
    liveLiangPayedPop.t = paramInt;
    (new XPopup.Builder(paramBaseFragment.getContext())).a(new XPopupCallback(paramBaseFragment) {
          public void a(BasePopupView param1BasePopupView) {}
          
          public void a(BasePopupView param1BasePopupView, int param1Int) {}
          
          public void a(BasePopupView param1BasePopupView, int param1Int, float param1Float, boolean param1Boolean) {}
          
          public void b(BasePopupView param1BasePopupView) {}
          
          public void c(BasePopupView param1BasePopupView) {}
          
          public void d(BasePopupView param1BasePopupView) {
            LiveEventBus.get("LIVE_WEB_PAGE_REFRESH").post("");
            BaseFragment baseFragment = this.a;
            if (baseFragment != null && baseFragment.getActivity() != null)
              this.a.getActivity().finish(); 
          }
          
          public void e(BasePopupView param1BasePopupView) {}
          
          public boolean f(BasePopupView param1BasePopupView) {
            return false;
          }
        }).a((BasePopupView)liveLiangPayedPop).h();
  }
  
  private void c() {
    Resources resources;
    this.e = (ImageView)findViewById(R.id.iv_close);
    this.i = (TextView)findViewById(R.id.tv_tip);
    this.f = (TextView)findViewById(R.id.tv_id);
    this.g = (TextView)findViewById(R.id.tv_date);
    this.h = (TextView)findViewById(R.id.tv_ok);
    this.h.setOnClickListener(new -$$Lambda$LiveLiangPayedPop$2pY9n2VUqKxdb4pQLykkopo5nzY(this));
    this.e.setOnClickListener(new -$$Lambda$LiveLiangPayedPop$Ui4bkLowbsW_eGrph503V4ENpzo(this));
    TextView textView = this.i;
    if (this.t == 0) {
      resources = getResources();
      i = R.string.live_id_liang_receive;
    } else {
      resources = getResources();
      i = R.string.live_id_re_new;
    } 
    textView.setText(resources.getString(i));
    this.f.setText(this.j);
    long l = this.k;
    int i = (int)(l / 86400L);
    int j = (int)(l % 86400L / 3600L);
    int k = (int)(l % 3600L / 60L);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.c.getString(R.string.live_id_valid_period));
    if (i >= 1)
      stringBuilder.append(String.format(this.c.getString(R.string.live_id_valid_period_day), new Object[] { Integer.valueOf(i) })); 
    if (j >= 1)
      stringBuilder.append(String.format(this.c.getString(R.string.live_id_valid_period_hour), new Object[] { Integer.valueOf(j) })); 
    if (k >= 1)
      stringBuilder.append(String.format(this.c.getString(R.string.live_id_valid_period_minute), new Object[] { Integer.valueOf(k) })); 
    this.g.setText(stringBuilder.toString());
  }
  
  public void b() {
    super.b();
    c();
  }
  
  public int getImplLayoutId() {
    return R.layout.live_pop_receive_liang_id;
  }
  
  public int getMaxWidth() {
    return XPopupUtils.a(getContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LiveLiangPayedPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */