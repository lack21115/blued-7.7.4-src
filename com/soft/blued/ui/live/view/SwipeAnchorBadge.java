package com.soft.blued.ui.live.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.http.H5Url;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;
import java.util.List;

public class SwipeAnchorBadge implements SwipeFlingAdapterView.onFlingListener {
  private View a;
  
  private View b;
  
  private Context c;
  
  private MyPopupWindow d;
  
  private LayoutInflater e;
  
  private ArrayList<AnchorMedal> f = new ArrayList<AnchorMedal>();
  
  private LinearLayout g;
  
  private String h;
  
  private IRequestHost i;
  
  private int j = 0;
  
  private SwipeFlingAdapterView k;
  
  private SwipeAnchorBadgeCardAdapter l;
  
  private boolean m = false;
  
  public SwipeAnchorBadge(Context paramContext, String paramString, IRequestHost paramIRequestHost) {
    this.c = paramContext;
    this.h = paramString;
    this.i = paramIRequestHost;
    d();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, IRequestHost paramIRequestHost) {
    (new SwipeAnchorBadge(paramContext, paramString, paramIRequestHost)).b(paramInt);
  }
  
  private void d() {
    this.e = LayoutInflater.from(this.c);
    View view = this.e.inflate(2131492924, null);
    this.a = view.findViewById(2131300559);
    this.g = (LinearLayout)view.findViewById(2131298926);
    this.g.setVisibility(8);
    this.k = (SwipeFlingAdapterView)view.findViewById(2131300148);
    this.k.setFlingListener(this);
    this.l = new SwipeAnchorBadgeCardAdapter(this, this.c, this.k);
    this.k.setAdapter((Adapter)this.l);
    this.k.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if ((param1MotionEvent.getRawY() < (SwipeAnchorBadge.a(this.a)).b || param1MotionEvent.getRawY() > (SwipeAnchorBadge.a(this.a)).e) && (SwipeAnchorBadge.a(this.a)).a != null && (SwipeAnchorBadge.a(this.a)).a.getX() == (SwipeAnchorBadge.a(this.a)).c)
              this.a.c(); 
            return true;
          }
        });
    this.a.setBackgroundColor(Color.parseColor("#CC000000"));
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.b = view.findViewById(2131298758);
    this.b.setBackgroundColor(this.c.getResources().getColor(2131100897));
    this.b.setVisibility(8);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.d = new MyPopupWindow(this, view, -1, -1, true);
    this.d.setBackgroundDrawable(this.c.getResources().getDrawable(17170445));
    this.d.setTouchable(true);
    this.d.setOutsideTouchable(true);
    this.d.setFocusable(true);
    this.d.update();
    b();
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt) {}
  
  public void a(Object paramObject) {
    this.l.b();
  }
  
  public void b() {
    LiveRoomHttpUtils.c(this.h, new BluedUIHttpResponse<BluedEntityA<AnchorMedal>>(this) {
          boolean a = false;
          
          public void a(BluedEntityA<AnchorMedal> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data.size() > 0) {
              List list = param1BluedEntityA.data;
              int i = 0;
              if (list.get(0) != null) {
                SwipeAnchorBadge.b(this.b).clear();
                while (i < param1BluedEntityA.data.size()) {
                  SwipeAnchorBadge.b(this.b).add(param1BluedEntityA.data.get(i));
                  if (param1BluedEntityA.data.get(i) != null) {
                    String str = ((AnchorMedal)param1BluedEntityA.data.get(i)).pic;
                    if (!StringUtils.e(str))
                      ImageFileLoader.a(SwipeAnchorBadge.c(this.b)).a(str).a(); 
                  } 
                  i++;
                } 
                SwipeAnchorBadge.d(this.b).a(SwipeAnchorBadge.b(this.b));
                SwipeAnchorBadge.d(this.b).a(SwipeAnchorBadge.e(this.b));
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            SwipeAnchorBadge.f(this.b).setVisibility(8);
            SwipeAnchorBadge.a(this.b).setVisibility(0);
            if (this.a) {
              this.a = false;
              this.b.c();
            } 
          }
          
          public void onUIStart() {}
        }this.i);
  }
  
  public void b(int paramInt) {
    this.j = paramInt;
    this.k.setVisibility(4);
    this.g.setVisibility(0);
    this.a.clearAnimation();
    this.b.clearAnimation();
    if (this.d.isShowing())
      this.d.a(); 
    this.d.showAtLocation(this.b, 81, 0, 0);
    this.b.setVisibility(0);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, 2130772055));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.b();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.a.startAnimation((Animation)alphaAnimation);
  }
  
  public void b(Object paramObject) {
    this.l.a();
  }
  
  public void c() {
    if (!this.m) {
      this.m = true;
      AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
      alphaAnimation.setDuration(300L);
      alphaAnimation.setFillAfter(true);
      this.a.startAnimation((Animation)alphaAnimation);
      this.b.setVisibility(8);
      this.b.startAnimation(AnimationUtils.loadAnimation(this.c, 2130772056));
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              SwipeAnchorBadge.g(this.a).a();
              SwipeAnchorBadge.a(this.a, false);
            }
          }320L);
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(SwipeAnchorBadge this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
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
  
  public class SwipeAnchorBadgeCardAdapter extends BaseAdapter {
    private List<AnchorMedal> b = new ArrayList<AnchorMedal>();
    
    private List<AnchorMedal> c = new ArrayList<AnchorMedal>();
    
    private int d = 0;
    
    private Context e;
    
    private int f = 0;
    
    private SwipeFlingAdapterView g;
    
    public SwipeAnchorBadgeCardAdapter(SwipeAnchorBadge this$0, Context param1Context, SwipeFlingAdapterView param1SwipeFlingAdapterView) {
      this.e = param1Context;
      this.g = param1SwipeFlingAdapterView;
      this.f = param1SwipeFlingAdapterView.getVisibleCount();
    }
    
    public void a() {
      this.d--;
      a(this.d);
    }
    
    public void a(int param1Int) {
      (SwipeAnchorBadge.a(this.a)).a = null;
      this.d = param1Int;
      param1Int = this.d;
      if (param1Int >= 0) {
        if (param1Int >= this.b.size())
          return; 
        this.c.clear();
        this.c.add(this.b.get(this.d));
        param1Int = this.d;
        while (true) {
          int i = param1Int + 1;
          param1Int = this.d;
          if (i <= this.f / 2 + param1Int) {
            param1Int = i;
            if (i < this.b.size()) {
              this.c.add(this.b.get(i));
              param1Int = i;
            } 
            continue;
          } 
          param1Int--;
          while (true) {
            i = this.d;
            if (param1Int >= i - this.f / 2) {
              if (param1Int >= 0)
                this.c.add(this.b.get(param1Int)); 
              param1Int--;
              continue;
            } 
            SwipeFlingAdapterView swipeFlingAdapterView = this.g;
            if (swipeFlingAdapterView != null) {
              swipeFlingAdapterView.setTag(2131296875, Integer.valueOf(i));
              this.g.setTag(2131300307, Integer.valueOf(this.b.size()));
            } 
            notifyDataSetChanged();
            break;
          } 
          break;
        } 
      } 
    }
    
    public void a(List<AnchorMedal> param1List) {
      this.b.clear();
      if (param1List != null && param1List.size() > 0)
        for (int i = 0; i < param1List.size(); i++) {
          AnchorMedal anchorMedal = param1List.get(i);
          this.b.add(anchorMedal);
        }  
      this.g.setTag(2131296875, Integer.valueOf(this.d));
      this.g.setTag(2131300307, Integer.valueOf(this.b.size()));
      a(this.d);
    }
    
    public AnchorMedal b(int param1Int) {
      List<AnchorMedal> list = this.c;
      return (list == null || list.size() == 0) ? null : this.c.get(param1Int);
    }
    
    public void b() {
      this.d++;
      Logger.b("swipecard", new Object[] { "pointerForward", Integer.valueOf(this.d) });
      a(this.d);
    }
    
    public int getCount() {
      return this.c.size();
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view;
      ViewHolder viewHolder;
      if (param1View == null) {
        ViewHolder viewHolder1 = new ViewHolder();
        View view1 = LayoutInflater.from(this.e).inflate(2131493415, param1ViewGroup, false);
        viewHolder1.a = (ImageView)view1.findViewById(2131297437);
        viewHolder1.b = (TextView)view1.findViewById(2131300549);
        viewHolder1.c = (TextView)view1.findViewById(2131300791);
        viewHolder1.e = (TextView)view1.findViewById(2131301013);
        viewHolder1.d = (TextView)view1.findViewById(2131301481);
        viewHolder1.f = (TextView)view1.findViewById(2131301299);
        viewHolder = viewHolder1;
        view = view1;
      } else {
        viewHolder = (ViewHolder)view.getTag();
      } 
      AnchorMedal anchorMedal = this.c.get(param1Int);
      if (!StringUtils.e(anchorMedal.pic))
        ImageLoader.a(SwipeAnchorBadge.c(this.a), anchorMedal.pic).a(viewHolder.a); 
      viewHolder.b.setText(anchorMedal.name);
      viewHolder.c.setText(anchorMedal.title);
      if (!StringUtils.e(anchorMedal.upgrade_description)) {
        viewHolder.e.setVisibility(0);
        viewHolder.e.setText(anchorMedal.upgrade_description);
      } else {
        viewHolder.e.setVisibility(4);
      } 
      if (anchorMedal.score > 0) {
        TextView textView1 = viewHolder.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(anchorMedal.score);
        stringBuilder.append(this.e.getResources().getString(2131758647));
        textView1.setText(stringBuilder.toString());
      } else {
        viewHolder.f.setText(" ? ");
      } 
      viewHolder.f.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param2View) {
              WebViewShowInfoFragment.show(SwipeAnchorBadge.SwipeAnchorBadgeCardAdapter.a(this.a), H5Url.a(10), 7);
            }
          });
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(anchorMedal.end_time);
      stringBuilder2.append("");
      String str = TimeAndDateUtils.b(TimeAndDateUtils.b(stringBuilder2.toString()));
      if (StringUtils.e(str) || anchorMedal.end_time == 0L) {
        viewHolder.d.setVisibility(4);
        return view;
      } 
      viewHolder.d.setVisibility(0);
      TextView textView = viewHolder.d;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.e.getResources().getString(2131759194));
      stringBuilder1.append(str);
      textView.setText(stringBuilder1.toString());
      return view;
    }
    
    class ViewHolder {
      public ImageView a;
      
      public TextView b;
      
      public TextView c;
      
      public TextView d;
      
      public TextView e;
      
      public TextView f;
      
      private ViewHolder(SwipeAnchorBadge.SwipeAnchorBadgeCardAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(SwipeAnchorBadge this$0) {}
    
    public void onClick(View param1View) {
      WebViewShowInfoFragment.show(SwipeAnchorBadge.SwipeAnchorBadgeCardAdapter.a(this.a), H5Url.a(10), 7);
    }
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public TextView e;
    
    public TextView f;
    
    private ViewHolder(SwipeAnchorBadge this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\SwipeAnchorBadge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */