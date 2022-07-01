package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;

public class LiveRankingButtonView extends LinearLayout implements View.OnClickListener {
  public boolean a = false;
  
  public RankingExtra b;
  
  private Context c;
  
  private LayoutInflater d;
  
  private View e;
  
  private View f;
  
  private View g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private MarqueeTextView k;
  
  private MarqueeTextView l;
  
  private boolean m;
  
  private boolean n = false;
  
  private Runnable o = new Runnable(this) {
      public void run() {
        try {
          LiveRankingButtonView.a(this.a).setVisibility(8);
          LiveRankingButtonView.b(this.a).setVisibility(0);
          LiveRankingButtonView.b(this.a).setListener(new MarqueeTextView.callbackListener(this) {
                public void a(int param2Int) {
                  if (param2Int >= 2) {
                    LiveRankingButtonView.b(this.a.a).b();
                    LiveRankingButtonView.a(this.a.a).setVisibility(0);
                    LiveRankingButtonView.b(this.a.a).setVisibility(8);
                    LiveRankingButtonView.c(this.a.a);
                  } 
                }
              });
          LiveRankingButtonView.b(this.a).a();
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  private Runnable p = new Runnable(this) {
      public void run() {
        try {
          LiveRankingButtonView.d(this.a).setVisibility(8);
          LiveRankingButtonView.e(this.a).setVisibility(0);
          LiveRankingButtonView.e(this.a).setListener(new MarqueeTextView.callbackListener(this) {
                public void a(int param2Int) {
                  if (param2Int >= 2) {
                    LiveRankingButtonView.e(this.a.a).b();
                    LiveRankingButtonView.d(this.a.a).setVisibility(0);
                    LiveRankingButtonView.e(this.a.a).setVisibility(8);
                    LiveRankingButtonView.f(this.a.a);
                  } 
                }
              });
          LiveRankingButtonView.e(this.a).a();
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  public LiveRankingButtonView(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
    b();
  }
  
  public LiveRankingButtonView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    b();
  }
  
  private String a(double paramDouble) {
    return (new DecimalFormat("#.##")).format(paramDouble);
  }
  
  private void b() {
    this.d = LayoutInflater.from(this.c);
    View view = this.d.inflate(R.layout.layout_live_ranking_button, (ViewGroup)this, true);
    this.e = view.findViewById(R.id.ll_pk);
    this.f = view.findViewById(R.id.ll_hot);
    this.g = view.findViewById(R.id.ll_rise);
    this.h = (TextView)view.findViewById(R.id.tv_pk);
    this.i = (TextView)view.findViewById(R.id.tv_hot);
    this.k = (MarqueeTextView)view.findViewById(R.id.tv_pk_tips);
    this.l = (MarqueeTextView)view.findViewById(R.id.tv_hot_tips);
    this.j = (TextView)view.findViewById(R.id.tv_rise);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
  }
  
  private void c() {
    if (this.b == null)
      return; 
    this.f.removeCallbacks(this.p);
    this.l.setVisibility(8);
    this.l.b();
    this.e.removeCallbacks(this.o);
    this.k.setVisibility(8);
    this.k.b();
    int i = this.b.battle_rank;
    String str = "未上榜";
    if (i >= 0) {
      String str1;
      this.e.setVisibility(0);
      TextView textView = this.h;
      if (this.b.battle_rank > 0) {
        str1 = String.format(getContext().getString(R.string.live_pk_rank_num), new Object[] { Integer.valueOf(this.b.battle_rank) });
      } else {
        str1 = "未上榜";
      } 
      textView.setText(str1);
      if (this.b.battle_catch > 0) {
        MarqueeTextView marqueeTextView = this.k;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("距上一名还差");
        stringBuilder.append(a(this.b.battle_catch));
        stringBuilder.append("PK值");
        marqueeTextView.setText(stringBuilder.toString());
        e();
      } 
    } else {
      this.e.setVisibility(8);
    } 
    if (this.b.hot >= 0) {
      this.f.setVisibility(0);
      this.i.setVisibility(0);
      TextView textView = this.i;
      if (this.b.hot > 0) {
        str1 = String.format(getContext().getString(R.string.live_pk_rank_num), new Object[] { Integer.valueOf(this.b.hot) });
      } else {
        str1 = "未上榜";
      } 
      textView.setText(str1);
      this.g.setVisibility(0);
      textView = this.j;
      String str1 = str;
      if (this.b.jump > 0)
        str1 = String.format(getContext().getString(R.string.live_pk_rank_num), new Object[] { Integer.valueOf(this.b.jump) }); 
      textView.setText(str1);
      if (this.b.need_score > 0.0D) {
        MarqueeTextView marqueeTextView = this.l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("距上一名还差");
        stringBuilder.append(a(this.b.need_score));
        stringBuilder.append("热度");
        marqueeTextView.setText(stringBuilder.toString());
        d();
        return;
      } 
    } else {
      this.f.setVisibility(8);
      this.g.setVisibility(8);
    } 
  }
  
  private void d() {
    if (this.n)
      return; 
    this.f.removeCallbacks(this.p);
    this.f.postDelayed(this.p, 2000L);
  }
  
  private void e() {
    if (this.n)
      return; 
    this.e.removeCallbacks(this.o);
    this.e.postDelayed(this.o, 2000L);
  }
  
  public void a() {
    try {
      this.f.removeCallbacks(this.p);
      this.l.b();
      this.e.removeCallbacks(this.o);
      this.k.b();
      this.n = true;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.ll_pk) {
      EventTrackLive.a(LiveProtos.Event.LIVE_PK_ICON_CLICK);
      LiveEventBus.get("live_ranking_dialog").post(Integer.valueOf(0));
      return;
    } 
    if (paramView.getId() == R.id.ll_hot) {
      LiveEventBus.get("live_ranking_dialog").post(Integer.valueOf(1));
      return;
    } 
    if (paramView.getId() == R.id.ll_rise)
      LiveEventBus.get("live_ranking_dialog").post(Integer.valueOf(2)); 
  }
  
  public void setIsSimpleModel(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setValue(RankingExtra paramRankingExtra) {
    if (this.l != null && !this.m) {
      if (this.n)
        return; 
      this.b = paramRankingExtra;
      c();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveRankingButtonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */