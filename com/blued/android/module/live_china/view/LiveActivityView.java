package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveActivityDotAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

public class LiveActivityView extends FrameLayout implements View.OnClickListener {
  public BaseFragment a;
  
  public ActivityFragmentActive b;
  
  public boolean c;
  
  private View d;
  
  private Context e;
  
  private LayoutInflater f;
  
  private View g;
  
  private LiveActiivtyRecycleView h;
  
  private LiveAutoScrollViewPager i;
  
  private RecordingOnliveFragment j;
  
  private PlayingOnliveFragment k;
  
  private long l;
  
  private PicAdapter m;
  
  private LiveActivityDotAdapter n;
  
  public LiveActivityView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LiveActivityView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    a();
  }
  
  private void a() {
    this.f = LayoutInflater.from(this.e);
    this.d = this.f.inflate(R.layout.live_activity_layout, (ViewGroup)this, true);
    this.g = this.d.findViewById(R.id.fl_box);
    this.h = (LiveActiivtyRecycleView)this.d.findViewById(R.id.box_rv);
    this.h.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this, getContext(), 0, false) {
          public void smoothScrollToPosition(RecyclerView param1RecyclerView, RecyclerView.State param1State, int param1Int) {
            LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, param1RecyclerView.getContext()) {
                public float a(DisplayMetrics param2DisplayMetrics) {
                  return 600.0F / param2DisplayMetrics.densityDpi;
                }
              };
            linearSmoothScroller.setTargetPosition(param1Int);
            startSmoothScroll((RecyclerView.SmoothScroller)linearSmoothScroller);
          }
        });
    this.i = (LiveAutoScrollViewPager)this.d.findViewById(R.id.box_view_pager);
    this.m = new PicAdapter(this, getContext(), this.i);
    this.i.setAdapter(this.m);
    this.i.setInterval(3000L);
    this.n = new LiveActivityDotAdapter(getContext(), new ArrayList(), this.h);
    this.h.setAdapter((RecyclerView.Adapter)this.n);
    setVisibility(8);
    this.i.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) {
          public void onPageScrollStateChanged(int param1Int) {}
          
          public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
          
          public void onPageSelected(int param1Int) {
            LiveActivityView.a(this.a).a(param1Int);
            if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).activity != null && param1Int < (LiveRoomManager.a().h()).activity.size() && (LiveRoomManager.a().h()).activity.get(param1Int) != null)
              EventTrackLive.f(LiveProtos.Event.LIVE_ACTIVITY_RESOURCE_SHOW, LiveRoomManager.a().c(), LiveRoomManager.a().e(), ((LiveActivityItemModel)(LiveRoomManager.a().h()).activity.get(param1Int)).url); 
          }
        });
  }
  
  public void a(BaseFragment paramBaseFragment) {
    this.a = paramBaseFragment;
    if (paramBaseFragment instanceof RecordingOnliveFragment) {
      this.c = true;
      this.j = (RecordingOnliveFragment)paramBaseFragment;
      this.b = this.j.w_();
      this.l = this.j.u;
      return;
    } 
    if (paramBaseFragment instanceof PlayingOnliveFragment) {
      this.c = false;
      this.k = (PlayingOnliveFragment)paramBaseFragment;
      this.b = this.k.w_();
      this.l = this.k.u;
    } 
  }
  
  public void onClick(View paramView) {}
  
  public void setData(List<LiveActivityItemModel> paramList) {
    if (paramList != null && paramList.size() > 0) {
      this.m.a(paramList);
      this.i.setAdapter(this.m);
      if (paramList.size() == 1) {
        this.g.setVisibility(8);
      } else {
        this.g.setVisibility(0);
        this.i.f();
        this.i.setCurrentItem(0, false);
      } 
      this.n.a(paramList, 0);
      setVisibility(0);
      LiveSetDataObserver.a().a(true);
      return;
    } 
    setVisibility(8);
    LiveSetDataObserver.a().a(false);
  }
  
  public class PicAdapter extends PagerAdapter implements View.OnClickListener {
    private List<View> b = new ArrayList<View>();
    
    private LayoutInflater c;
    
    private ViewPager d;
    
    private Context e;
    
    public PicAdapter(LiveActivityView this$0, Context param1Context, ViewPager param1ViewPager) {
      this.e = param1Context;
      this.d = param1ViewPager;
      this.c = LayoutInflater.from(param1Context);
    }
    
    public void a(List<LiveActivityItemModel> param1List) {
      if (param1List == null)
        return; 
      this.b.clear();
      for (LiveActivityItemModel liveActivityItemModel : param1List) {
        if (liveActivityItemModel == null)
          return; 
        View view = this.c.inflate(R.layout.live_activity_item, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.iv_grab);
        ImageLoader.a(null, liveActivityItemModel.icon).a(4.0F).a(imageView);
        TextView textView = (TextView)view.findViewById(R.id.rank_text);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)textView.getLayoutParams();
        if (liveActivityItemModel != null && liveActivityItemModel.rank > 0L) {
          if (param1List.size() <= 1) {
            marginLayoutParams.topMargin = DensityUtils.a(this.a.getContext(), 4.0F);
          } else {
            marginLayoutParams.topMargin = DensityUtils.a(this.a.getContext(), 20.0F);
          } 
          textView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          textView.setVisibility(0);
          textView.setOnClickListener(new View.OnClickListener(this, liveActivityItemModel) {
                public void onClick(View param2View) {
                  if (this.b.a.a instanceof PlayingOnliveFragment) {
                    LiveActivityView.a(this.b.a, (PlayingOnliveFragment)this.b.a.a);
                    LiveActivityView.b(this.b.a).f(this.a.id);
                    return;
                  } 
                  if (this.b.a.a instanceof RecordingOnliveFragment) {
                    LiveActivityView.a(this.b.a, (RecordingOnliveFragment)this.b.a.a);
                    LiveActivityView.c(this.b.a).a(this.a.id);
                  } 
                }
              });
          textView.setText(String.format(LiveActivityView.d(this.a).getString(R.string.live_activty), new Object[] { Long.valueOf(liveActivityItemModel.rank) }));
        } else {
          textView.setVisibility(8);
        } 
        imageView.setOnClickListener(new View.OnClickListener(this, liveActivityItemModel) {
              public void onClick(View param2View) {
                if (LiveRoomManager.a().h() != null)
                  EventTrackLive.f(LiveProtos.Event.LIVE_ACTIVITY_RESOURCE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.a.url); 
                if (this.b.a.a instanceof PlayingOnliveFragment) {
                  if (this.a.page == 0) {
                    LiveRoomInfo.a().b(LiveActivityView.d(this.b.a), this.a.url);
                    ((PlayingOnliveFragment)this.b.a.a).a(true);
                    return;
                  } 
                  ((PlayingOnliveFragment)this.b.a.a).e(this.a.url);
                  return;
                } 
                if (this.b.a.a instanceof RecordingOnliveFragment)
                  ((RecordingOnliveFragment)this.b.a.a).g(this.a.url); 
              }
            });
        this.b.add(view);
      } 
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return this.b.size();
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("instantiateItem:");
      stringBuilder.append(param1Int);
      Log.i("==ppp", stringBuilder.toString());
      View view = this.b.get(param1Int);
      view.setTag(Integer.valueOf(param1Int));
      view.setOnClickListener(this);
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
    
    public void onClick(View param1View) {}
  }
  
  class null implements View.OnClickListener {
    null(LiveActivityView this$0, LiveActivityItemModel param1LiveActivityItemModel) {}
    
    public void onClick(View param1View) {
      if (this.b.a.a instanceof PlayingOnliveFragment) {
        LiveActivityView.a(this.b.a, (PlayingOnliveFragment)this.b.a.a);
        LiveActivityView.b(this.b.a).f(this.a.id);
        return;
      } 
      if (this.b.a.a instanceof RecordingOnliveFragment) {
        LiveActivityView.a(this.b.a, (RecordingOnliveFragment)this.b.a.a);
        LiveActivityView.c(this.b.a).a(this.a.id);
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(LiveActivityView this$0, LiveActivityItemModel param1LiveActivityItemModel) {}
    
    public void onClick(View param1View) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.f(LiveProtos.Event.LIVE_ACTIVITY_RESOURCE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.a.url); 
      if (this.b.a.a instanceof PlayingOnliveFragment) {
        if (this.a.page == 0) {
          LiveRoomInfo.a().b(LiveActivityView.d(this.b.a), this.a.url);
          ((PlayingOnliveFragment)this.b.a.a).a(true);
          return;
        } 
        ((PlayingOnliveFragment)this.b.a.a).e(this.a.url);
        return;
      } 
      if (this.b.a.a instanceof RecordingOnliveFragment)
        ((RecordingOnliveFragment)this.b.a.a).g(this.a.url); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveActivityView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */