package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRecordLevelExtra;
import com.blued.android.module.live_china.model.LiveRecordLevelModel;
import com.blued.android.module.live_china.model.LiveRecordLevelPrivilegeModel;
import com.blued.android.module.live_china.model.LiveRecordLevelTaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PopRecordLevelView {
  private LayoutInflater a;
  
  private Context b;
  
  private View c;
  
  private View d;
  
  private MyPopupWindow e;
  
  private CustomViewPager f;
  
  private LiveRecordLevelToolBarView g;
  
  private RecordLevelPagerAdapter h;
  
  private RecordingOnliveFragment i;
  
  private View j;
  
  private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        PopRecordLevelView.b(this.a).setToolBtnSelect(param1Int);
      }
    };
  
  private List<String> l = new ArrayList<String>();
  
  private TaskAdapter m;
  
  private PrivilegeAdapter n;
  
  private List<View> o = new ArrayList<View>();
  
  public PopRecordLevelView(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.i = paramRecordingOnliveFragment;
    this.b = paramRecordingOnliveFragment.getContext();
    e();
    d();
  }
  
  private void d() {
    this.a = LayoutInflater.from(this.b);
    View view = this.a.inflate(R.layout.pop_window_record_level_task, null);
    this.c = view.findViewById(R.id.tv_bg);
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
    this.j = view.findViewById(R.id.ll_loading);
    this.f = (CustomViewPager)view.findViewById(R.id.live_record_level_viewpager);
    this.g = (LiveRecordLevelToolBarView)view.findViewById(R.id.live_record_level_tool_bar);
    this.g.a(this.b.getResources().getStringArray(R.array.live_record_level_title));
    this.g.setOnToolBarItemClickListener(new LiveRecordLevelToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            PopRecordLevelView.a(this.a).setCurrentItem(param1Int);
          }
        });
    this.h = new RecordLevelPagerAdapter(this);
    this.f.setAdapter(this.h);
    this.f.addOnPageChangeListener(this.k);
    this.e = new MyPopupWindow(this, view, -1, -1, true);
    this.e.setBackgroundDrawable(this.b.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.update();
  }
  
  private void e() {
    for (String str : this.b.getResources().getStringArray(R.array.live_record_level_title))
      this.l.add(str); 
  }
  
  public void a() {
    RecordingOnliveFragment recordingOnliveFragment = this.i;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.Q(); 
    this.c.clearAnimation();
    this.d.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    this.e.showAtLocation(this.d, 81, 0, 0);
    this.d.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
    this.d.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.b();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void b() {
    BluedUIHttpResponse<BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra>>(this, (IRequestHost)this.i.w_()) {
        public void onUIFinish() {
          super.onUIFinish();
          PopRecordLevelView.c(this.a).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          PopRecordLevelView.c(this.a).setVisibility(0);
        }
        
        public void onUIUpdate(BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra> param1BluedEntity) {
          if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
            LiveRecordLevelModel liveRecordLevelModel = param1BluedEntity.data.get(0);
            if (liveRecordLevelModel != null) {
              if (liveRecordLevelModel.missions != null && PopRecordLevelView.d(this.a) != null)
                PopRecordLevelView.d(this.a).a(liveRecordLevelModel.missions); 
              if (liveRecordLevelModel.features != null && PopRecordLevelView.e(this.a) != null)
                PopRecordLevelView.e(this.a).a(liveRecordLevelModel.features); 
            } 
          } 
          if (param1BluedEntity != null && param1BluedEntity.extra != null && PopRecordLevelView.f(this.a) != null)
            PopRecordLevelView.f(this.a).a(((LiveRecordLevelExtra)param1BluedEntity.extra).mission_more_url, ((LiveRecordLevelExtra)param1BluedEntity.extra).feature_more_url); 
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.i.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.q(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void c() {
    RecordingOnliveFragment recordingOnliveFragment = this.i;
    if (recordingOnliveFragment != null)
      recordingOnliveFragment.R(); 
    this.d.setVisibility(8);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopRecordLevelView.g(this.a).a();
          }
        },  300L);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopRecordLevelView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
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
  
  class PrivilegeAdapter extends BaseQuickAdapter<LiveRecordLevelPrivilegeModel, BaseViewHolder> {
    private ImageView b;
    
    private TextView c;
    
    public PrivilegeAdapter(PopRecordLevelView this$0) {
      super(R.layout.item_live_record_level_privilege, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRecordLevelPrivilegeModel param1LiveRecordLevelPrivilegeModel) {
      if (param1BaseViewHolder != null) {
        String str;
        this.b = (ImageView)param1BaseViewHolder.d(R.id.live_privilege_icon);
        this.c = (TextView)param1BaseViewHolder.d(R.id.live_privilege_name);
        param1BaseViewHolder.a(R.id.live_privilege_name, param1LiveRecordLevelPrivilegeModel.title);
        param1BaseViewHolder.a(R.id.live_privilege_level, param1LiveRecordLevelPrivilegeModel.message);
        if (param1LiveRecordLevelPrivilegeModel.status == 1) {
          str = param1LiveRecordLevelPrivilegeModel.icon;
        } else {
          str = param1LiveRecordLevelPrivilegeModel.icon_disable;
        } 
        ImageLoader.a(null, str).a(this.b);
      } 
    }
  }
  
  class RecordLevelPagerAdapter extends PagerAdapter {
    private String b = "";
    
    private String c = "";
    
    RecordLevelPagerAdapter(PopRecordLevelView this$0) {}
    
    public void a(String param1String1, String param1String2) {
      this.b = param1String1;
      this.c = param1String2;
    }
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return PopRecordLevelView.h(this.a).size();
    }
    
    public int getItemPosition(Object param1Object) {
      return -2;
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      PopRecordLevelView popRecordLevelView;
      while (PopRecordLevelView.i(this.a).size() < PopRecordLevelView.h(this.a).size()) {
        View view = LayoutInflater.from(PopRecordLevelView.j(this.a)).inflate(R.layout.live_beauty_pager, param1ViewGroup, false);
        PopRecordLevelView.i(this.a).add(view);
      } 
      View view1 = PopRecordLevelView.i(this.a).get(param1Int);
      PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView)view1.findViewById(R.id.live_beauty_recycler_view);
      RecyclerView recyclerView = (RecyclerView)pullToRefreshRecyclerView.getRefreshableView();
      pullToRefreshRecyclerView.setRefreshEnabled(false);
      view1.findViewById(R.id.ll_more).setVisibility(0);
      View view2 = view1.findViewById(R.id.live_task_more);
      if (param1Int != 0) {
        if (param1Int == 1) {
          ((LinearLayout.LayoutParams)pullToRefreshRecyclerView.getLayoutParams()).topMargin = DensityUtils.a(PopRecordLevelView.j(this.a), 5.0F);
          recyclerView.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(PopRecordLevelView.j(this.a), 4));
          popRecordLevelView = this.a;
          PopRecordLevelView.a(popRecordLevelView, new PopRecordLevelView.PrivilegeAdapter(popRecordLevelView));
          recyclerView.setAdapter((RecyclerView.Adapter)PopRecordLevelView.e(this.a));
          view2.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  if (!TextUtils.isEmpty(PopRecordLevelView.RecordLevelPagerAdapter.b(this.a))) {
                    this.a.a.c();
                    AppInfo.n().postDelayed(new Runnable(this) {
                          public void run() {
                            PopRecordLevelView.g(this.a.a.a).a();
                            PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.b(this.a.a), 0);
                          }
                        }300L);
                  } 
                }
              });
        } 
      } else {
        ((LinearLayout.LayoutParams)popRecordLevelView.getLayoutParams()).topMargin = DensityUtils.a(PopRecordLevelView.j(this.a), 15.0F);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PopRecordLevelView.j(this.a));
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
        PopRecordLevelView popRecordLevelView1 = this.a;
        PopRecordLevelView.a(popRecordLevelView1, new PopRecordLevelView.TaskAdapter(popRecordLevelView1));
        recyclerView.setAdapter((RecyclerView.Adapter)PopRecordLevelView.d(this.a));
        view2.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param2View) {
                if (!TextUtils.isEmpty(PopRecordLevelView.RecordLevelPagerAdapter.a(this.a))) {
                  this.a.a.c();
                  AppInfo.n().postDelayed(new Runnable(this) {
                        public void run() {
                          PopRecordLevelView.g(this.a.a.a).a();
                          PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.a(this.a.a), 0);
                        }
                      }300L);
                } 
              }
            });
      } 
      if (view1.getParent() != null)
        ((ViewGroup)view1.getParent()).removeView(view1); 
      param1ViewGroup.addView(PopRecordLevelView.i(this.a).get(param1Int));
      return view1;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRecordLevelView this$0) {}
    
    public void onClick(View param1View) {
      if (!TextUtils.isEmpty(PopRecordLevelView.RecordLevelPagerAdapter.a(this.a))) {
        this.a.a.c();
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                PopRecordLevelView.g(this.a.a.a).a();
                PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.a(this.a.a), 0);
              }
            }300L);
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      PopRecordLevelView.g(this.a.a.a).a();
      PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.a(this.a.a), 0);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopRecordLevelView this$0) {}
    
    public void onClick(View param1View) {
      if (!TextUtils.isEmpty(PopRecordLevelView.RecordLevelPagerAdapter.b(this.a))) {
        this.a.a.c();
        AppInfo.n().postDelayed(new Runnable(this) {
              public void run() {
                PopRecordLevelView.g(this.a.a.a).a();
                PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.b(this.a.a), 0);
              }
            }300L);
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      PopRecordLevelView.g(this.a.a.a).a();
      PopRecordLevelView.k(this.a.a.a).b(PopRecordLevelView.RecordLevelPagerAdapter.b(this.a.a), 0);
    }
  }
  
  class TaskAdapter extends BaseQuickAdapter<LiveRecordLevelTaskModel, BaseViewHolder> {
    private ImageView b;
    
    private TextView c;
    
    private TextView d;
    
    private ImageView e;
    
    public TaskAdapter(PopRecordLevelView this$0) {
      super(R.layout.item_live_record_level_task, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, LiveRecordLevelTaskModel param1LiveRecordLevelTaskModel) {
      if (param1BaseViewHolder != null) {
        this.b = (ImageView)param1BaseViewHolder.d(R.id.live_task_icon);
        this.c = (TextView)param1BaseViewHolder.d(R.id.live_task_name);
        this.d = (TextView)param1BaseViewHolder.d(R.id.live_task_details);
        this.e = (ImageView)param1BaseViewHolder.d(R.id.live_task_status_icon);
        param1BaseViewHolder.a(R.id.live_task_name, param1LiveRecordLevelTaskModel.title);
        ImageLoader.a(null, param1LiveRecordLevelTaskModel.icon).a(this.b);
        ImageLoader.a(null, param1LiveRecordLevelTaskModel.status_image).a(this.e);
        String str2 = param1LiveRecordLevelTaskModel.message;
        String str1 = param1LiveRecordLevelTaskModel.highlight;
        StringBuilder stringBuilder1 = new StringBuilder(str2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("message.indexOf(highlight) = ");
        stringBuilder2.append(stringBuilder1.indexOf(str1));
        Log.v("pk", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("message.lastIndexOf(highlight) = ");
        stringBuilder2.append(stringBuilder1.indexOf(str1));
        stringBuilder2.append(str1.length());
        Log.v("pk", stringBuilder2.toString());
        stringBuilder1.insert(stringBuilder1.indexOf(str1), " ");
        stringBuilder1.insert(stringBuilder1.indexOf(str1) + str1.length(), " ");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("sb.toString() = ");
        stringBuilder2.append(stringBuilder1.toString());
        Log.v("pk", stringBuilder2.toString());
        SpannableString spannableString = new SpannableString(stringBuilder1.toString());
        this.d.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan(this) {
              public void onClick(View param2View) {}
              
              public void updateDrawState(TextPaint param2TextPaint) {
                param2TextPaint.setColor(PopRecordLevelView.TaskAdapter.a(this.a).getResources().getColor(R.color.nafio_f));
                param2TextPaint.setUnderlineText(false);
              }
            },  spannableString.toString().indexOf(str1), spannableString.toString().indexOf(str1) + str1.length(), 33);
        this.d.setText((CharSequence)spannableString);
      } 
    }
  }
  
  class null extends ClickableSpan {
    null(PopRecordLevelView this$0) {}
    
    public void onClick(View param1View) {}
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(PopRecordLevelView.TaskAdapter.a(this.a).getResources().getColor(R.color.nafio_f));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopRecordLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */