package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.CirclePageIndicator;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class PopAnchorBadge {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  public ViewPager f;
  
  public CirclePageIndicator g;
  
  public View h;
  
  public LinearLayout i;
  
  private MyPopupWindow j;
  
  private ArrayList<AnchorMedal> k = new ArrayList<AnchorMedal>();
  
  private MyPagerAdapter l;
  
  private String m;
  
  private IRequestHost n;
  
  private String o = "0";
  
  private DismissLisnter p;
  
  private String q = "";
  
  public PopAnchorBadge(Context paramContext, String paramString, IRequestHost paramIRequestHost, DismissLisnter paramDismissLisnter) {
    this.d = paramContext;
    this.n = paramIRequestHost;
    this.p = paramDismissLisnter;
    this.q = paramString;
    g();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DismissLisnter paramDismissLisnter, IRequestHost paramIRequestHost) {
    (new PopAnchorBadge(paramContext, paramString2, paramIRequestHost, paramDismissLisnter)).a(paramString3, paramString1);
  }
  
  private void g() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.l = new MyPagerAdapter(this);
    this.b = this.a.findViewById(R.id.tv_bg);
    this.f = (ViewPager)this.a.findViewById(R.id.vp_badge);
    this.g = (CirclePageIndicator)this.a.findViewById(R.id.indicator);
    this.i = (LinearLayout)this.a.findViewById(R.id.ll_loading);
    this.h = this.a.findViewById(R.id.tv_close);
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.e();
          }
        });
    this.f.setAdapter(this.l);
    this.g.setViewPager(this.f);
    this.g.setRadius(DensityUtils.a(this.d, 3.5F));
    this.g.setInterval(DensityUtils.a(this.d, 5.5F));
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.e();
          }
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.j = new MyPopupWindow(this, this.a, -1, -1, true);
    this.j.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.j.setTouchable(true);
    this.j.setOutsideTouchable(true);
    this.j.setFocusable(true);
    this.j.update();
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.anchor_badge_bottom, null);
  }
  
  public void a(String paramString1, String paramString2) {
    this.o = paramString1;
    this.m = paramString2;
    this.i.setVisibility(0);
    this.f.setVisibility(4);
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.j.isShowing())
      this.j.a(); 
    this.j.showAtLocation(this.c, 81, 0, 0);
    this.c.setVisibility(0);
    c();
  }
  
  public View b() {
    return this.e.inflate(R.layout.item_anchor_badge, null);
  }
  
  public void c() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.d();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public void d() {
    LiveRoomHttpUtils.a(this.m, true, new BluedUIHttpResponse<BluedEntityA<AnchorMedal>>(this) {
          boolean a = false;
          
          public void a(BluedEntityA<AnchorMedal> param1BluedEntityA) {
            byte b = 0;
            if (param1BluedEntityA != null && param1BluedEntityA.data.size() > 0 && param1BluedEntityA.data.get(0) != null) {
              PopAnchorBadge.a(this.b).clear();
              for (int j = 0; j < param1BluedEntityA.data.size(); j++) {
                PopAnchorBadge.a(this.b).add(param1BluedEntityA.data.get(j));
                if (param1BluedEntityA.data.get(j) != null) {
                  String str = ((AnchorMedal)param1BluedEntityA.data.get(j)).pic;
                  if (!TextUtils.isEmpty(str))
                    ImageFileLoader.a(PopAnchorBadge.b(this.b)).a(str).a(); 
                } 
              } 
            } 
            if (PopAnchorBadge.c(this.b).getCount() > 1) {
              this.b.g.setVisibility(0);
            } else {
              this.b.g.setVisibility(8);
            } 
            PopAnchorBadge.c(this.b).notifyDataSetChanged();
            this.b.g.a();
            for (int i = b; i < PopAnchorBadge.a(this.b).size(); i++) {
              if (!TextUtils.isEmpty(PopAnchorBadge.d(this.b)) && PopAnchorBadge.d(this.b).equals(((AnchorMedal)PopAnchorBadge.a(this.b).get(i)).bid)) {
                this.b.f.setCurrentItem(i);
                return;
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            this.b.i.setVisibility(8);
            this.b.f.setVisibility(0);
            if (this.a) {
              this.a = false;
              this.b.e();
            } 
          }
          
          public void onUIStart() {}
        }this.n);
  }
  
  public void e() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopAnchorBadge.e(this.a).a();
            if (PopAnchorBadge.f(this.a) != null)
              PopAnchorBadge.f(this.a).a(); 
          }
        },  320L);
    f();
    this.c.setVisibility(8);
  }
  
  public void f() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  public static interface ANCHOR_MEDAL {}
  
  public static interface DismissLisnter {
    void a();
    
    void b();
  }
  
  public class MyPagerAdapter extends PagerAdapter {
    public MyPagerAdapter(PopAnchorBadge this$0) {}
    
    public void destroyItem(ViewGroup param1ViewGroup, int param1Int, Object param1Object) {
      param1ViewGroup.removeView((View)param1Object);
    }
    
    public int getCount() {
      return (PopAnchorBadge.a(this.a) == null) ? 0 : PopAnchorBadge.a(this.a).size();
    }
    
    public Object instantiateItem(ViewGroup param1ViewGroup, int param1Int) {
      AnchorMedal anchorMedal = PopAnchorBadge.a(this.a).get(param1Int);
      View view = this.a.b();
      ImageView imageView = (ImageView)view.findViewById(R.id.img_badge);
      TextView textView2 = (TextView)view.findViewById(R.id.tv_badge_name);
      TextView textView3 = (TextView)view.findViewById(R.id.tv_gained_cond);
      TextView textView1 = (TextView)view.findViewById(R.id.tv_valid_date);
      TextView textView4 = (TextView)view.findViewById(R.id.tv_lvlup_cond);
      TextView textView5 = (TextView)view.findViewById(R.id.tv_score);
      if (anchorMedal.score > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(anchorMedal.score);
        stringBuilder.append(this.a.d.getResources().getString(R.string.score_point));
        textView5.setText(stringBuilder.toString());
      } else {
        textView5.setText("?");
      } 
      if (LiveRoomInfo.a().f().equals(PopAnchorBadge.g(this.a))) {
        textView5.setBackground(null);
      } else {
        textView5.setBackgroundResource(R.drawable.shape_popmedal_point_bg);
        textView5.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param2View) {
                if (!LiveRefreshUIObserver.a().e())
                  return; 
                LiveRoomInfo.a().b(this.a.a.d, LiveRoomInfo.a().y());
                PopAnchorBadge.f(this.a.a).b();
              }
            });
      } 
      if (!TextUtils.isEmpty(anchorMedal.pic))
        ImageLoader.a(PopAnchorBadge.b(this.a), anchorMedal.pic).a(imageView); 
      textView2.setText(anchorMedal.name);
      textView3.setText(anchorMedal.title);
      if (!TextUtils.isEmpty(anchorMedal.upgrade_description)) {
        textView4.setVisibility(0);
        textView4.setText(anchorMedal.upgrade_description);
      } else {
        textView4.setVisibility(4);
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(anchorMedal.end_time);
      stringBuilder2.append("");
      String str = LiveTimeAndDateUtils.a(LiveTimeAndDateUtils.a(stringBuilder2.toString()));
      if (TextUtils.isEmpty(str) || anchorMedal.end_time == 0L) {
        textView1.setVisibility(4);
        param1ViewGroup.addView(view);
        return view;
      } 
      textView1.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.a.d.getResources().getString(R.string.valid_to));
      stringBuilder1.append(str);
      textView1.setText(stringBuilder1.toString());
      param1ViewGroup.addView(view);
      return view;
    }
    
    public boolean isViewFromObject(View param1View, Object param1Object) {
      return (param1View == param1Object);
    }
  }
  
  class null implements View.OnClickListener {
    null(PopAnchorBadge this$0) {}
    
    public void onClick(View param1View) {
      if (!LiveRefreshUIObserver.a().e())
        return; 
      LiveRoomInfo.a().b(this.a.a.d, LiveRoomInfo.a().y());
      PopAnchorBadge.f(this.a.a).b();
    }
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopAnchorBadge this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.e();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopAnchorBadge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */