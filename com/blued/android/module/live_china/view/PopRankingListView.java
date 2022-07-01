package com.blued.android.module.live_china.view;

import android.app.Dialog;
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
import com.blued.android.core.AppMethods;
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
import com.blued.android.module.live_china.fragment.LiveRankWebDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRankingListExtra;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class PopRankingListView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private View f;
  
  private CustomViewPager g;
  
  private LiveRankListToolBarView h;
  
  private MyPagerAdapter i;
  
  private PkPagerAdapter j;
  
  private BaseFragment k;
  
  private View l;
  
  private final int m = 3;
  
  private final int n = 2;
  
  private String o;
  
  private RankingAdapter p;
  
  private RankingAdapter q;
  
  private RankingAdapter r;
  
  private RankingAdapter s;
  
  private Map<String, View> t = new HashMap<String, View>();
  
  private Map<String, View> u = new HashMap<String, View>();
  
  private LiveRankWebDialogFragment v;
  
  public PopRankingListView(BaseFragment paramBaseFragment) {
    this.k = paramBaseFragment;
    this.b = paramBaseFragment.getContext();
    d();
  }
  
  private String a(double paramDouble) {
    return (new DecimalFormat("#.##")).format(paramDouble);
  }
  
  private void b(int paramInt) {
    if (paramInt == 1) {
      EventTrackLive.a(LiveProtos.Event.LIVE_HOT_PAGE_SHOW, this.o);
    } else if (paramInt == 2) {
      EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_PAGE_SHOW, this.o);
    } else {
      return;
    } 
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRankingListExtra, LiveRankingListExtra>>(this, (IRequestHost)this.k.w_(), paramInt) {
          public boolean onUIFailure(int param1Int, String param1String) {
            View view = (View)PopRankingListView.e(this.b).get(String.valueOf(this.a));
            if (view != null) {
              TextView textView = (TextView)view.findViewById(R.id.tv_empty_view);
              textView.setVisibility(0);
              textView.setText(R.string.live_network_error);
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            PopRankingListView.n(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            PopRankingListView.n(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity<LiveRankingListExtra, LiveRankingListExtra> param1BluedEntity) {
            View view = (View)PopRankingListView.e(this.b).get(String.valueOf(this.a));
            if (view == null)
              return; 
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout)view.findViewById(R.id.ll_anchor_rank_layout);
            TextView textView2 = (TextView)view.findViewById(R.id.tv_rank_index);
            ImageView imageView1 = (ImageView)view.findViewById(R.id.iv_rank_index);
            ImageView imageView2 = (ImageView)view.findViewById(R.id.avatar);
            TextView textView3 = (TextView)view.findViewById(R.id.tv_name);
            TextView textView1 = (TextView)view.findViewById(R.id.tv_rank);
            RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_list);
            TextView textView4 = (TextView)view.findViewById(R.id.tv_empty_view);
            boolean bool = param1BluedEntity.hasData();
            int i = 0;
            if (!bool) {
              shapeLinearLayout.setVisibility(8);
              textView4.setVisibility(0);
              textView4.setText(R.string.live_ranking_no_data);
              recyclerView.setVisibility(8);
              return;
            } 
            shapeLinearLayout.setVisibility(0);
            textView4.setVisibility(8);
            recyclerView.setVisibility(0);
            textView2.setText(String.valueOf(((LiveRankingListExtra)param1BluedEntity.extra).index));
            if (((LiveRankingListExtra)param1BluedEntity.extra).index == 1) {
              imageView1.setVisibility(0);
              imageView1.setImageResource(R.drawable.live_rank_up_one);
              textView2.setVisibility(8);
            } else if (((LiveRankingListExtra)param1BluedEntity.extra).index == 2) {
              imageView1.setVisibility(0);
              imageView1.setImageResource(R.drawable.live_rank_up_two);
              textView2.setVisibility(8);
            } else if (((LiveRankingListExtra)param1BluedEntity.extra).index == 3) {
              imageView1.setVisibility(0);
              imageView1.setImageResource(R.drawable.live_rank_up_three);
              textView2.setVisibility(8);
            } else {
              imageView1.setVisibility(8);
              int k = this.a;
              if (k == 1) {
                if (((LiveRankingListExtra)param1BluedEntity.extra).index <= 0) {
                  textView2.setVisibility(8);
                } else {
                  textView2.setVisibility(0);
                } 
              } else if (k == 2) {
                if (((LiveRankingListExtra)param1BluedEntity.extra).index <= 0 || ((LiveRankingListExtra)param1BluedEntity.extra).rise <= 0) {
                  textView2.setVisibility(8);
                } else {
                  textView2.setVisibility(0);
                } 
              } 
            } 
            textView3.setText(((LiveRankingListExtra)param1BluedEntity.extra).nickname);
            ImageLoader.a(null, ((LiveRankingListExtra)param1BluedEntity.extra).avatar).a(R.drawable.channel_default_head).c().a(imageView2);
            int j = this.a;
            if (j == 1) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(PopRankingListView.a(this.b, ((LiveRankingListExtra)param1BluedEntity.extra).hot));
              stringBuilder.append("热度值");
              textView1.setText(stringBuilder.toString());
              while (i < param1BluedEntity.data.size()) {
                ((LiveRankingListExtra)param1BluedEntity.data.get(i)).compareHot = ((LiveRankingListExtra)param1BluedEntity.extra).hot - ((LiveRankingListExtra)param1BluedEntity.data.get(i)).hot;
                i++;
              } 
              PopRankingListView.i(this.b).c(param1BluedEntity.data);
              return;
            } 
            if (j == 2) {
              String str;
              if (((LiveRankingListExtra)param1BluedEntity.extra).rise > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("飙升");
                stringBuilder.append(((LiveRankingListExtra)param1BluedEntity.extra).rise);
                stringBuilder.append("名");
                str = stringBuilder.toString();
              } else {
                str = "未上榜";
              } 
              textView1.setText(str);
              PopRankingListView.j(this.b).c(param1BluedEntity.data);
            } 
          }
        }paramInt);
  }
  
  private void c(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      String str;
      if (LiveRoomManager.a().h() != null) {
        str = String.valueOf((LiveRoomManager.a().h()).lid);
      } else {
        str = "";
      } 
      LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRankingListExtra, LiveRankingListExtra>>(this, (IRequestHost)this.k.w_(), paramInt) {
            public boolean onUIFailure(int param1Int, String param1String) {
              View view = (View)PopRankingListView.k(this.b).get(String.valueOf(this.a));
              if (view != null) {
                TextView textView = (TextView)view.findViewById(R.id.tv_empty_view);
                int i = this.a;
                if (i == 0) {
                  if (PopRankingListView.l(this.b).n() == null || PopRankingListView.l(this.b).n().size() <= 0) {
                    textView.setVisibility(0);
                    textView.setText(R.string.live_network_error);
                  } 
                } else if (i == 1 && (PopRankingListView.m(this.b).n() == null || PopRankingListView.m(this.b).n().size() <= 0)) {
                  textView.setVisibility(0);
                  textView.setText(R.string.live_network_error);
                } 
              } 
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              PopRankingListView.n(this.b).setVisibility(8);
            }
            
            public void onUIStart() {
              super.onUIStart();
              PopRankingListView.n(this.b).setVisibility(0);
            }
            
            public void onUIUpdate(BluedEntity<LiveRankingListExtra, LiveRankingListExtra> param1BluedEntity) {
              View view = (View)PopRankingListView.k(this.b).get(String.valueOf(this.a));
              if (view == null)
                return; 
              ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout)view.findViewById(R.id.ll_anchor_rank_layout);
              TextView textView2 = (TextView)view.findViewById(R.id.tv_rank_index);
              ImageView imageView1 = (ImageView)view.findViewById(R.id.iv_rank_index);
              ImageView imageView2 = (ImageView)view.findViewById(R.id.avatar);
              TextView textView3 = (TextView)view.findViewById(R.id.tv_name);
              TextView textView1 = (TextView)view.findViewById(R.id.tv_rank);
              RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_list);
              TextView textView4 = (TextView)view.findViewById(R.id.tv_empty_view);
              boolean bool = param1BluedEntity.hasData();
              int i = 0;
              if (!bool) {
                shapeLinearLayout.setVisibility(8);
                textView4.setVisibility(0);
                textView4.setText(R.string.live_ranking_no_data);
                recyclerView.setVisibility(8);
                return;
              } 
              shapeLinearLayout.setVisibility(0);
              textView4.setVisibility(8);
              recyclerView.setVisibility(0);
              textView2.setText(String.valueOf(((LiveRankingListExtra)param1BluedEntity.extra).index));
              if (((LiveRankingListExtra)param1BluedEntity.extra).index == 1) {
                imageView1.setVisibility(0);
                imageView1.setImageResource(R.drawable.live_rank_up_one);
                textView2.setVisibility(8);
              } else if (((LiveRankingListExtra)param1BluedEntity.extra).index == 2) {
                imageView1.setVisibility(0);
                imageView1.setImageResource(R.drawable.live_rank_up_two);
                textView2.setVisibility(8);
              } else if (((LiveRankingListExtra)param1BluedEntity.extra).index == 3) {
                imageView1.setVisibility(0);
                imageView1.setImageResource(R.drawable.live_rank_up_three);
                textView2.setVisibility(8);
              } else {
                imageView1.setVisibility(8);
                if (((LiveRankingListExtra)param1BluedEntity.extra).index <= 0) {
                  textView2.setVisibility(8);
                } else {
                  textView2.setVisibility(0);
                } 
              } 
              textView3.setText(((LiveRankingListExtra)param1BluedEntity.extra).nickname);
              ImageLoader.a(null, ((LiveRankingListExtra)param1BluedEntity.extra).avatar).a(R.drawable.channel_default_head).c().a(imageView2);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(PopRankingListView.a(this.b, ((LiveRankingListExtra)param1BluedEntity.extra).score));
              stringBuilder.append(PopRankingListView.f(this.b).getString(R.string.live_pk_score));
              textView1.setText(stringBuilder.toString());
              while (i < param1BluedEntity.data.size()) {
                ((LiveRankingListExtra)param1BluedEntity.data.get(i)).comparePk = ((LiveRankingListExtra)param1BluedEntity.data.get(i)).index - ((LiveRankingListExtra)param1BluedEntity.extra).index;
                i++;
              } 
              i = this.a;
              if (i == 0) {
                PopRankingListView.l(this.b).c(param1BluedEntity.data);
                return;
              } 
              if (i == 1)
                PopRankingListView.m(this.b).c(param1BluedEntity.data); 
            }
          }str, paramInt);
    } 
  }
  
  private void d() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_ranking, null);
    this.c = view.findViewById(R.id.tv_bg);
    this.t.clear();
    this.u.clear();
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.c();
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
            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_SOAR_LIST_QA_CLICK);
            if (PopRankingListView.a(this.a) != null && PopRankingListView.a(this.a).isVisible())
              return; 
            PopRankingListView.a(this.a, new LiveRankWebDialogFragment());
            PopRankingListView.a(this.a).show(PopRankingListView.b(this.a).getFragmentManager(), "rankWebDialog");
          }
        });
    this.l = view.findViewById(R.id.ll_loading);
    this.g = (CustomViewPager)view.findViewById(R.id.live_record_level_viewpager);
    this.h = (LiveRankListToolBarView)view.findViewById(R.id.live_record_level_tool_bar);
    this.h.a(this.b.getResources().getStringArray(R.array.live_ranking_list_title));
    this.h.setOnToolBarItemClickListener(new LiveRankListToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            PopRankingListView.c(this.a).setCurrentItem(param1Int);
          }
        });
    this.i = new MyPagerAdapter(this);
    this.g.setAdapter(this.i);
    this.g.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            PopRankingListView.d(this.a).setToolBtnSelect(param1Int);
            if (param1Int == 0) {
              PopRankingListView.a(this.a, 0);
              return;
            } 
            if (param1Int == 1) {
              PopRankingListView.b(this.a, 1);
              return;
            } 
            if (param1Int == 2)
              PopRankingListView.b(this.a, 2); 
          }
        });
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  public void a(int paramInt) {
    if (LiveRoomManager.a().l())
      return; 
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(true));
    this.o = LiveRoomManager.a().e();
    MyPopupWindow myPopupWindow = this.e;
    if (myPopupWindow != null && myPopupWindow.isShowing())
      this.e.a(); 
    d();
    this.c.clearAnimation();
    this.d.clearAnimation();
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    if (paramInt == 0) {
      this.g.setCurrentItem(0);
      c(0);
      return;
    } 
    if (paramInt == 1) {
      this.g.setCurrentItem(1);
      b(paramInt);
      return;
    } 
    if (paramInt == 2) {
      this.g.setCurrentItem(2);
      b(paramInt);
    } 
  }
  
  public boolean a() {
    return (this.d.getVisibility() == 0);
  }
  
  public void b() {
    this.k = null;
  }
  
  public void c() {
    LiveEventBus.get("live_show_dialog").post(Boolean.valueOf(false));
    LiveRankWebDialogFragment liveRankWebDialogFragment = this.v;
    if (liveRankWebDialogFragment != null) {
      Dialog dialog = liveRankWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.v.dismiss(); 
    } 
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopRankingListView.o(this.a).a();
          }
        },  300L);
  }
  
  class MyPagerAdapter extends PagerAdapter {
    MyPagerAdapter(PopRankingListView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return 3;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      if ((View)PopRankingListView.e(this.a).get(String.valueOf(param1Int)) == null)
        if (param1Int == 0) {
          View view1 = LayoutInflater.from(PopRankingListView.f(this.a)).inflate(R.layout.pop_window_ranking_pk, param1ViewGroup, false);
          ShapeFrameLayout shapeFrameLayout1 = (ShapeFrameLayout)view1.findViewById(R.id.fl_day);
          ShapeFrameLayout shapeFrameLayout2 = (ShapeFrameLayout)view1.findViewById(R.id.fl_week);
          TextView textView1 = (TextView)view1.findViewById(R.id.tv_day);
          TextView textView2 = (TextView)view1.findViewById(R.id.tv_week);
          ViewPager viewPager = (ViewPager)view1.findViewById(R.id.live_pk_viewpager);
          PopRankingListView popRankingListView = this.a;
          PopRankingListView.a(popRankingListView, new PopRankingListView.PkPagerAdapter(popRankingListView));
          viewPager.setAdapter(PopRankingListView.g(this.a));
          viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this, textView1, shapeFrameLayout1, shapeFrameLayout2, textView2) {
                public void onPageScrollStateChanged(int param2Int) {}
                
                public void onPageScrolled(int param2Int1, float param2Float, int param2Int2) {}
                
                public void onPageSelected(int param2Int) {
                  if (param2Int == 0) {
                    ShapeModel shapeModel = new ShapeModel();
                    shapeModel.H = DensityUtils.a(PopRankingListView.f(this.e.a), 30.0F);
                    shapeModel.k = ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_b);
                    this.a.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_0a0a0a));
                    this.b.setShapeModel(shapeModel);
                    shapeModel = new ShapeModel();
                    this.c.setShapeModel(shapeModel);
                    this.d.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_767676));
                    PopRankingListView.a(this.e.a, 0);
                    return;
                  } 
                  if (param2Int == 1) {
                    ShapeModel shapeModel = new ShapeModel();
                    this.a.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_767676));
                    this.b.setShapeModel(shapeModel);
                    shapeModel = new ShapeModel();
                    shapeModel.H = DensityUtils.a(PopRankingListView.f(this.e.a), 30.0F);
                    shapeModel.k = ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_b);
                    this.d.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_0a0a0a));
                    this.c.setShapeModel(shapeModel);
                    PopRankingListView.a(this.e.a, 1);
                  } 
                }
              });
          shapeFrameLayout1.setOnClickListener(new View.OnClickListener(this, viewPager) {
                public void onClick(View param2View) {
                  this.a.setCurrentItem(0);
                }
              });
          shapeFrameLayout2.setOnClickListener(new View.OnClickListener(this, viewPager) {
                public void onClick(View param2View) {
                  this.a.setCurrentItem(1);
                }
              });
          PopRankingListView.e(this.a).put(String.valueOf(param1Int), view1);
        } else {
          PopRankingListView popRankingListView;
          View view1 = LayoutInflater.from(PopRankingListView.f(this.a)).inflate(R.layout.pop_window_ranking_list, param1ViewGroup, false);
          RecyclerView recyclerView = (RecyclerView)view1.findViewById(R.id.recycler_list);
          recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(PopRankingListView.f(this.a), 1, false));
          View view2 = view1.findViewById(R.id.tv_hot_tips);
          View view3 = view1.findViewById(R.id.tv_send_gift);
          if (PopRankingListView.b(this.a) instanceof PlayingOnliveFragment) {
            view3.setVisibility(0);
            view3.setOnClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    if (PopRankingListView.c(this.a.a).getCurrentItem() == 1) {
                      EventTrackLive.a(LiveProtos.Event.LIVE_HOT_LIST_GO_GOODS_CLICK, PopRankingListView.h(this.a.a));
                    } else if (PopRankingListView.c(this.a.a).getCurrentItem() == 2) {
                      EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_LIST_GO_GOODS_CLICK, PopRankingListView.h(this.a.a));
                    } 
                    this.a.a.c();
                    LiveRefreshUIObserver.a().i();
                  }
                });
          } else {
            view3.setVisibility(8);
          } 
          if (param1Int == 1) {
            view2.setVisibility(0);
            popRankingListView = this.a;
            PopRankingListView.a(popRankingListView, new PopRankingListView.RankingAdapter(popRankingListView, 1, 0));
            recyclerView.setAdapter((RecyclerView.Adapter)PopRankingListView.i(this.a));
          } else if (param1Int == 2) {
            popRankingListView.setVisibility(8);
            popRankingListView = this.a;
            PopRankingListView.b(popRankingListView, new PopRankingListView.RankingAdapter(popRankingListView, 2, 0));
            recyclerView.setAdapter((RecyclerView.Adapter)PopRankingListView.j(this.a));
          } 
          PopRankingListView.e(this.a).put(String.valueOf(param1Int), view1);
        }  
      View view = (View)PopRankingListView.e(this.a).get(String.valueOf(param1Int));
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null implements ViewPager.OnPageChangeListener {
    null(PopRankingListView this$0, TextView param1TextView1, ShapeFrameLayout param1ShapeFrameLayout1, ShapeFrameLayout param1ShapeFrameLayout2, TextView param1TextView2) {}
    
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {
      if (param1Int == 0) {
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.H = DensityUtils.a(PopRankingListView.f(this.e.a), 30.0F);
        shapeModel.k = ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_b);
        this.a.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_0a0a0a));
        this.b.setShapeModel(shapeModel);
        shapeModel = new ShapeModel();
        this.c.setShapeModel(shapeModel);
        this.d.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_767676));
        PopRankingListView.a(this.e.a, 0);
        return;
      } 
      if (param1Int == 1) {
        ShapeModel shapeModel = new ShapeModel();
        this.a.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_767676));
        this.b.setShapeModel(shapeModel);
        shapeModel = new ShapeModel();
        shapeModel.H = DensityUtils.a(PopRankingListView.f(this.e.a), 30.0F);
        shapeModel.k = ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_b);
        this.d.setTextColor(ContextCompat.getColor(PopRankingListView.f(this.e.a), R.color.syc_dark_0a0a0a));
        this.c.setShapeModel(shapeModel);
        PopRankingListView.a(this.e.a, 1);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRankingListView this$0, ViewPager param1ViewPager) {}
    
    public void onClick(View param1View) {
      this.a.setCurrentItem(0);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRankingListView this$0, ViewPager param1ViewPager) {}
    
    public void onClick(View param1View) {
      this.a.setCurrentItem(1);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRankingListView this$0) {}
    
    public void onClick(View param1View) {
      if (PopRankingListView.c(this.a.a).getCurrentItem() == 1) {
        EventTrackLive.a(LiveProtos.Event.LIVE_HOT_LIST_GO_GOODS_CLICK, PopRankingListView.h(this.a.a));
      } else if (PopRankingListView.c(this.a.a).getCurrentItem() == 2) {
        EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_LIST_GO_GOODS_CLICK, PopRankingListView.h(this.a.a));
      } 
      this.a.a.c();
      LiveRefreshUIObserver.a().i();
    }
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopRankingListView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.c();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface PK_TYPE {}
  
  class PkPagerAdapter extends PagerAdapter {
    PkPagerAdapter(PopRankingListView this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return 2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      View view = (View)PopRankingListView.k(this.a).get(String.valueOf(param1Int));
      while (view == null) {
        PopRankingListView popRankingListView;
        view = LayoutInflater.from(PopRankingListView.f(this.a)).inflate(R.layout.pop_window_ranking_list, param1ViewGroup, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(PopRankingListView.f(this.a), 1, false));
        View view1 = view.findViewById(R.id.tv_hot_tips);
        View view2 = view.findViewById(R.id.tv_send_gift);
        if (PopRankingListView.b(this.a) instanceof PlayingOnliveFragment) {
          view2.setVisibility(0);
          view2.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  this.a.a.c();
                  LiveRefreshUIObserver.a().i();
                }
              });
        } else {
          view2.setVisibility(8);
        } 
        if (param1Int == 0) {
          view1.setVisibility(8);
          popRankingListView = this.a;
          PopRankingListView.c(popRankingListView, new PopRankingListView.RankingAdapter(popRankingListView, 0, 0));
          recyclerView.setAdapter((RecyclerView.Adapter)PopRankingListView.l(this.a));
        } else if (param1Int == 1) {
          popRankingListView.setVisibility(8);
          popRankingListView = this.a;
          PopRankingListView.d(popRankingListView, new PopRankingListView.RankingAdapter(popRankingListView, 0, 1));
          recyclerView.setAdapter((RecyclerView.Adapter)PopRankingListView.m(this.a));
        } 
        PopRankingListView.k(this.a).put(String.valueOf(param1Int), view);
      } 
      view = (View)PopRankingListView.k(this.a).get(String.valueOf(param1Int));
      if (view.getParent() != null)
        ((ViewGroup)view.getParent()).removeView(view); 
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRankingListView this$0) {}
    
    public void onClick(View param1View) {
      this.a.a.c();
      LiveRefreshUIObserver.a().i();
    }
  }
  
  public static interface RANKING_TYPE {}
  
  class RankingAdapter extends BaseQuickAdapter<LiveRankingListExtra, BaseViewHolder> {
    private int b;
    
    private int c;
    
    public RankingAdapter(PopRankingListView this$0, int param1Int1, int param1Int2) {
      super(R.layout.pop_window_ranking_list_item, null);
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRankingListExtra param1LiveRankingListExtra) {
      int i = this.b;
      if (i == 1) {
        EventTrackLive.a(LiveProtos.Event.LIVE_HOT_LIST_SHOW, String.valueOf(param1LiveRankingListExtra.uid));
      } else if (i == 2) {
        EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_LIST_SHOW, String.valueOf(param1LiveRankingListExtra.uid));
      } 
      TextView textView3 = (TextView)param1BaseViewHolder.d(R.id.tv_rank_index);
      ImageView imageView1 = (ImageView)param1BaseViewHolder.d(R.id.iv_rank_index);
      ImageView imageView2 = (ImageView)param1BaseViewHolder.d(R.id.avatar);
      TextView textView4 = (TextView)param1BaseViewHolder.d(R.id.tv_name);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.tv_rank);
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.tv_pk);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1LiveRankingListExtra.index);
      stringBuilder.append("");
      textView3.setText(stringBuilder.toString());
      if (param1LiveRankingListExtra.index == 1) {
        imageView1.setVisibility(0);
        imageView1.setImageResource(R.drawable.live_rank_up_one);
        textView3.setVisibility(8);
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
      i = this.b;
      if (i == 1) {
        if (param1LiveRankingListExtra.compareHot < 0.0D) {
          textView2.setText(String.format(this.k.getResources().getString(R.string.live_ranking_backward_x_hit), new Object[] { PopRankingListView.a(this.a, param1LiveRankingListExtra.compareHot * -1.0D) }));
        } else {
          textView2.setText(String.format(this.k.getResources().getString(R.string.live_ranking_leading_x_hit), new Object[] { PopRankingListView.a(this.a, param1LiveRankingListExtra.compareHot) }));
        } 
        textView1.setVisibility(8);
      } else if (i == 2) {
        textView2.setText(String.format(this.k.getResources().getString(R.string.live_ranking_soaring_x), new Object[] { Integer.valueOf(param1LiveRankingListExtra.rise) }));
        textView1.setVisibility(8);
      } else if (i == 0) {
        if (param1LiveRankingListExtra.comparePk > 0) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.k.getString(R.string.live_pk_score_up));
          stringBuilder2.append(PopRankingListView.a(this.a, param1LiveRankingListExtra.score_greater));
          stringBuilder2.append(this.k.getString(R.string.live_pk_score));
          textView2.setText(stringBuilder2.toString());
        } else if (param1LiveRankingListExtra.comparePk < 0) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.k.getString(R.string.live_pk_score_down));
          stringBuilder2.append(PopRankingListView.a(this.a, param1LiveRankingListExtra.score_greater));
          stringBuilder2.append(this.k.getString(R.string.live_pk_score));
          textView2.setText(stringBuilder2.toString());
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("0");
          stringBuilder2.append(this.k.getString(R.string.live_pk_score));
          textView2.setText(stringBuilder2.toString());
        } 
        textView1.setVisibility(0);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(PopRankingListView.a(this.a, param1LiveRankingListExtra.score));
        stringBuilder1.append(" ");
        stringBuilder1.append(this.k.getString(R.string.live_pk_score));
        textView1.setText(stringBuilder1.toString());
      } 
      param1BaseViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, param1LiveRankingListExtra) {
            public void onClick(View param2View) {
              if (PopRankingListView.RankingAdapter.a(this.b) == 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_HOT_LIST_CLICK, String.valueOf(this.a.uid));
              } else if (PopRankingListView.RankingAdapter.a(this.b) == 2) {
                EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_LIST_CLICK, String.valueOf(this.a.uid));
              } 
              if (PopRankingListView.b(this.b.a) instanceof PlayingOnliveFragment) {
                if (LiveRoomManager.a().h() == null)
                  return; 
                if (this.a.lid <= 0L)
                  return; 
                LiveRoomData liveRoomData = new LiveRoomData(this.a.lid, 0, "live_room_ranking", this.a.uid, this.a.nickname, this.a.avatar, 0);
                LiveRoomManager.a().b(LiveRoomManager.a().h());
                PlayingOnliveFragment.a(PopRankingListView.RankingAdapter.b(this.b), liveRoomData);
                return;
              } 
              if (PopRankingListView.b(this.b.a) instanceof com.blued.android.module.live_china.fragment.RecordingOnliveFragment)
                AppMethods.a("当前正在开播无法切换直播间"); 
            }
          });
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRankingListView this$0, LiveRankingListExtra param1LiveRankingListExtra) {}
    
    public void onClick(View param1View) {
      if (PopRankingListView.RankingAdapter.a(this.b) == 1) {
        EventTrackLive.a(LiveProtos.Event.LIVE_HOT_LIST_CLICK, String.valueOf(this.a.uid));
      } else if (PopRankingListView.RankingAdapter.a(this.b) == 2) {
        EventTrackLive.a(LiveProtos.Event.LIVE_SOAR_LIST_CLICK, String.valueOf(this.a.uid));
      } 
      if (PopRankingListView.b(this.b.a) instanceof PlayingOnliveFragment) {
        if (LiveRoomManager.a().h() == null)
          return; 
        if (this.a.lid <= 0L)
          return; 
        LiveRoomData liveRoomData = new LiveRoomData(this.a.lid, 0, "live_room_ranking", this.a.uid, this.a.nickname, this.a.avatar, 0);
        LiveRoomManager.a().b(LiveRoomManager.a().h());
        PlayingOnliveFragment.a(PopRankingListView.RankingAdapter.b(this.b), liveRoomData);
        return;
      } 
      if (PopRankingListView.b(this.b.a) instanceof com.blued.android.module.live_china.fragment.RecordingOnliveFragment)
        AppMethods.a("当前正在开播无法切换直播间"); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopRankingListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */