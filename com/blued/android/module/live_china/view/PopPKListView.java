package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRankingListExtra;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.pop.LivePKConsumePop;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class PopPKListView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private View f;
  
  private ShapeFrameLayout g;
  
  private ShapeFrameLayout h;
  
  private TextView i;
  
  private TextView j;
  
  private CustomViewPager k;
  
  private PkPagerAdapter l;
  
  private BaseFragment m;
  
  private View n;
  
  private final int o = 2;
  
  private String p;
  
  private RankingAdapter q;
  
  private RankingAdapter r;
  
  private Map<String, View> s = new HashMap<String, View>();
  
  private int t;
  
  private String u;
  
  private int v;
  
  public PopPKListView(BaseFragment paramBaseFragment) {
    this.m = paramBaseFragment;
    this.b = paramBaseFragment.getContext();
    c();
  }
  
  private String a(double paramDouble) {
    return (new DecimalFormat("#.##")).format(paramDouble);
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifne -> 29
    //   4: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   7: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   10: ifnull -> 42
    //   13: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   16: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   19: getfield lid : J
    //   22: invokestatic valueOf : (J)Ljava/lang/String;
    //   25: astore_2
    //   26: goto -> 45
    //   29: iload_1
    //   30: iconst_1
    //   31: if_icmpne -> 42
    //   34: aload_0
    //   35: getfield u : Ljava/lang/String;
    //   38: astore_2
    //   39: goto -> 45
    //   42: ldc ''
    //   44: astore_2
    //   45: new com/blued/android/module/live_china/view/PopPKListView$7
    //   48: dup
    //   49: aload_0
    //   50: aload_0
    //   51: getfield m : Lcom/blued/android/core/ui/BaseFragment;
    //   54: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
    //   57: iload_1
    //   58: invokespecial <init> : (Lcom/blued/android/module/live_china/view/PopPKListView;Lcom/blued/android/core/net/IRequestHost;I)V
    //   61: aload_2
    //   62: invokestatic b : (Lcom/blued/android/framework/http/BluedUIHttpResponse;Ljava/lang/String;)V
    //   65: return
  }
  
  private void b(int paramInt) {
    View view = this.s.get(String.valueOf(paramInt));
    if (view != null) {
      ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout)view.findViewById(R.id.ll_anchor_rank_layout);
      RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_list);
      View view1 = view.findViewById(R.id.fl_pk_list_empty);
      view = view.findViewById(R.id.live_pay);
      if (this.t == 0) {
        view.setVisibility(0);
      } else {
        view.setVisibility(8);
      } 
      if (paramInt == 0) {
        if (this.q.n() == null || this.q.n().size() <= 0) {
          shapeLinearLayout.setVisibility(8);
          view1.setVisibility(0);
          recyclerView.setVisibility(8);
          return;
        } 
      } else if (paramInt == 1 && (this.r.n() == null || this.r.n().size() <= 0)) {
        shapeLinearLayout.setVisibility(8);
        view1.setVisibility(0);
        recyclerView.setVisibility(8);
      } 
    } 
  }
  
  private void c() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_pk, null);
    this.c = view.findViewById(R.id.bg_view);
    this.s.clear();
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    this.d = view.findViewById(R.id.ll_content);
    this.d.setVisibility(8);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.f = view.findViewById(R.id.iv_help);
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LivePKConsumePop.a(PopPKListView.a(this.a));
          }
        });
    this.g = (ShapeFrameLayout)view.findViewById(R.id.fl_owner);
    this.h = (ShapeFrameLayout)view.findViewById(R.id.fl_other);
    this.i = (TextView)view.findViewById(R.id.tv_owner);
    this.j = (TextView)view.findViewById(R.id.tv_other);
    this.n = view.findViewById(R.id.ll_loading);
    this.k = (CustomViewPager)view.findViewById(R.id.live_pk_viewpager);
    this.l = new PkPagerAdapter(this);
    this.k.setAdapter(this.l);
    this.k.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            if (param1Int == 0) {
              ShapeModel shapeModel = new ShapeModel();
              shapeModel.H = DensityUtils.a(PopPKListView.b(this.a), 30.0F);
              shapeModel.k = ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_b);
              PopPKListView.c(this.a).setTextColor(ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_0a0a0a));
              PopPKListView.d(this.a).setShapeModel(shapeModel);
              shapeModel = new ShapeModel();
              PopPKListView.e(this.a).setShapeModel(shapeModel);
              PopPKListView.f(this.a).setTextColor(ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_767676));
              PopPKListView.a(this.a, 0);
              return;
            } 
            if (param1Int == 1) {
              ShapeModel shapeModel = new ShapeModel();
              PopPKListView.c(this.a).setTextColor(ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_767676));
              PopPKListView.d(this.a).setShapeModel(shapeModel);
              shapeModel = new ShapeModel();
              shapeModel.H = DensityUtils.a(PopPKListView.b(this.a), 30.0F);
              shapeModel.k = ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_b);
              PopPKListView.f(this.a).setTextColor(ContextCompat.getColor(PopPKListView.b(this.a), R.color.syc_dark_0a0a0a));
              PopPKListView.e(this.a).setShapeModel(shapeModel);
              PopPKListView.a(this.a, 1);
            } 
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_RANK_CLICK, LiveProtos.Status.DAILY);
            PopPKListView.g(this.a).setCurrentItem(0);
          }
        });
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_RANK_CLICK, LiveProtos.Status.WEEKLY);
            PopPKListView.g(this.a).setCurrentItem(1);
          }
        });
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  public void a(LivePkBannerModel paramLivePkBannerModel) {
    if (LiveRoomManager.a().l())
      return; 
    if (paramLivePkBannerModel == null)
      return; 
    this.t = paramLivePkBannerModel.from;
    this.u = paramLivePkBannerModel.lid;
    this.v = paramLivePkBannerModel.pk_state;
    this.p = LiveRoomManager.a().e();
    MyPopupWindow myPopupWindow = this.e;
    if (myPopupWindow != null && myPopupWindow.isShowing())
      this.e.a(); 
    c();
    this.c.clearAnimation();
    this.d.clearAnimation();
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    if (paramLivePkBannerModel.type == 0) {
      this.k.setCurrentItem(0);
      a(0);
      return;
    } 
    if (paramLivePkBannerModel.type == 1) {
      this.k.setCurrentItem(1);
      a(1);
    } 
  }
  
  public boolean a() {
    return (this.d.getVisibility() == 0);
  }
  
  public void b() {
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(false));
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopPKListView.m(this.a).a();
          }
        },  300L);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopPKListView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.b();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface PK_TYPE {}
  
  class PkPagerAdapter extends PagerAdapter {
    PkPagerAdapter(PopPKListView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      View view = (View)PopPKListView.h(this.a).get(String.valueOf(param1Int));
      while (view == null) {
        view = LayoutInflater.from(PopPKListView.b(this.a)).inflate(R.layout.pop_window_pk_list, param1ViewGroup, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(PopPKListView.b(this.a), 1, false));
        if (param1Int == 0) {
          PopPKListView popPKListView = this.a;
          PopPKListView.a(popPKListView, new PopPKListView.RankingAdapter(popPKListView, 0));
          recyclerView.setAdapter((RecyclerView.Adapter)PopPKListView.i(this.a));
        } else if (param1Int == 1) {
          PopPKListView popPKListView = this.a;
          PopPKListView.b(popPKListView, new PopPKListView.RankingAdapter(popPKListView, 1));
          recyclerView.setAdapter((RecyclerView.Adapter)PopPKListView.j(this.a));
        } 
        PopPKListView.h(this.a).put(String.valueOf(param1Int), view);
      } 
      view = (View)PopPKListView.h(this.a).get(String.valueOf(param1Int));
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class RankingAdapter extends BaseQuickAdapter<LiveRankingListExtra, BaseViewHolder> {
    private int b;
    
    public RankingAdapter(PopPKListView this$0, int param1Int) {
      super(R.layout.pop_window_ranking_list_item, null);
      this.b = param1Int;
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRankingListExtra param1LiveRankingListExtra) {
      TextView textView3 = (TextView)param1BaseViewHolder.d(R.id.tv_rank_index);
      ImageView imageView1 = (ImageView)param1BaseViewHolder.d(R.id.iv_rank_index);
      ImageView imageView2 = (ImageView)param1BaseViewHolder.d(R.id.avatar);
      TextView textView4 = (TextView)param1BaseViewHolder.d(R.id.tv_name);
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.tv_rank);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.tv_pk);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(param1LiveRankingListExtra.index);
      stringBuilder2.append("");
      textView3.setText(stringBuilder2.toString());
      if (param1LiveRankingListExtra.index == 1) {
        int i = this.b;
        if (i == 0) {
          if (PopPKListView.l(this.a) == 1) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_pk_mvp);
            textView3.setVisibility(8);
          } else if (PopPKListView.l(this.a) == 0) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_up_one);
            textView3.setVisibility(8);
          } else if (PopPKListView.l(this.a) == 2) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_up_one);
            textView3.setVisibility(8);
          } 
        } else if (i == 1) {
          if (PopPKListView.l(this.a) == 1) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_up_one);
            textView3.setVisibility(8);
          } else if (PopPKListView.l(this.a) == 0) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_up_one);
            textView3.setVisibility(8);
          } else if (PopPKListView.l(this.a) == 2) {
            imageView1.setVisibility(0);
            imageView1.setImageResource(R.drawable.live_rank_pk_mvp);
            textView3.setVisibility(8);
          } 
        } 
      } else if (param1LiveRankingListExtra.index == 2) {
        imageView1.setVisibility(0);
        imageView1.setImageResource(R.drawable.live_rank_up_two);
        textView3.setVisibility(8);
      } else if (param1LiveRankingListExtra.index == 3) {
        imageView1.setVisibility(0);
        imageView1.setImageResource(R.drawable.live_rank_up_three);
        textView3.setVisibility(8);
      } else {
        imageView1.setVisibility(8);
        textView3.setVisibility(0);
      } 
      ImageLoader.a(null, param1LiveRankingListExtra.avatar).a(R.drawable.channel_default_head).c().a(imageView2);
      textView4.setText(param1LiveRankingListExtra.nickname);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(PopPKListView.a(this.a, param1LiveRankingListExtra.score));
      stringBuilder1.append(this.k.getString(R.string.live_pk_consumes));
      textView1.setText(stringBuilder1.toString());
      textView2.setVisibility(8);
      param1BaseViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, param1LiveRankingListExtra) {
            public void onClick(View param2View) {
              if (PopPKListView.RankingAdapter.a(this.b) == 0) {
                this.b.a.b();
                LiveSetDataObserver.a().e(this.a.uid);
              } 
            }
          });
    }
  }
  
  class null implements View.OnClickListener {
    null(PopPKListView this$0, LiveRankingListExtra param1LiveRankingListExtra) {}
    
    public void onClick(View param1View) {
      if (PopPKListView.RankingAdapter.a(this.b) == 0) {
        this.b.a.b();
        LiveSetDataObserver.a().e(this.a.uid);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopPKListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */