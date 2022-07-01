package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;

public class LiveOfficalRecommendPop extends CenterPopupView {
  public Context c;
  
  public final String d = "LiveRecommendPop";
  
  public int e;
  
  private ImageView f;
  
  private ImageView g;
  
  private TextView h;
  
  private TextView i;
  
  public LiveOfficalRecommendPop(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
  }
  
  public static LiveOfficalRecommendPop a(Context paramContext, int paramInt) {
    LiveOfficalRecommendPop liveOfficalRecommendPop = new LiveOfficalRecommendPop(paramContext);
    liveOfficalRecommendPop.e = paramInt;
    (new XPopup.Builder(paramContext)).a((BasePopupView)liveOfficalRecommendPop).h();
    return liveOfficalRecommendPop;
  }
  
  private void c() {
    int i;
    this.f = (ImageView)findViewById(R.id.iv_close);
    this.g = (ImageView)findViewById(R.id.iv_recommend_bg);
    this.h = (TextView)findViewById(R.id.tv_recommed_tip);
    this.i = (TextView)findViewById(R.id.tv_confirm);
    ImageView imageView = this.g;
    if (this.e == 0) {
      i = R.drawable.live_recommend_offical;
    } else {
      i = R.drawable.live_recommend_time_tip;
    } 
    imageView.setImageResource(i);
    TextView textView = this.h;
    if (this.e == 0) {
      i = R.string.live_recommend_receive;
    } else {
      i = R.string.live_recommend_time_tip;
    } 
    textView.setText(i);
    this.i = (TextView)findViewById(R.id.tv_confirm);
    this.i.setOnClickListener(new -$$Lambda$LiveOfficalRecommendPop$MMysCrOfqm_Yp85hWZAG0x2qbl4(this));
    this.f.setOnClickListener(new -$$Lambda$LiveOfficalRecommendPop$AFzjBzC9ukp_HsrA--n1M0PT0Ds(this));
  }
  
  public void b() {
    super.b();
    c();
  }
  
  public int getImplLayoutId() {
    return R.layout.live_pop_recommend;
  }
  
  public int getMaxWidth() {
    return XPopupUtils.a(getContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LiveOfficalRecommendPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */