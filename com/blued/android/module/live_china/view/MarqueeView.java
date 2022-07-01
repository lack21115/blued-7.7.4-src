package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarqueeView extends ViewFlipper {
  private int a = 4000;
  
  private boolean b = false;
  
  private int c = 1000;
  
  private int d = 12;
  
  private String e;
  
  private boolean f = false;
  
  private int g = 19;
  
  private boolean h = false;
  
  private int i = 0;
  
  private int j = R.anim.anim_bottom_in;
  
  private int k = R.anim.anim_top_out;
  
  private int l;
  
  private List<? extends CharSequence> m = new ArrayList<CharSequence>();
  
  private OnItemClickListener n;
  
  private LiveMsgManager o;
  
  private ScrollTextView.OnScrollListener p;
  
  private int q;
  
  public MarqueeView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  private TextView a(CharSequence paramCharSequence) {
    TextView textView = new TextView(getContext());
    textView.setGravity(this.g);
    try {
      textView.setTextColor(Color.parseColor(this.e));
    } catch (Exception exception) {
      textView.setTextColor(-1);
    } 
    textView.setTextSize(this.d);
    textView.setSingleLine(true);
    textView.setText(paramCharSequence);
    textView.setTag(Integer.valueOf(this.l));
    textView.setMovementMethod((MovementMethod)LinkMovementClickMethod.a());
    return textView;
  }
  
  private void a(int paramInt1, int paramInt2) {
    post(new Runnable(this, paramInt1, paramInt2) {
          public void run() {
            MarqueeView.a(this.c, this.a, this.b);
          }
        });
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    setFlipInterval(this.a);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2) {
    float f;
    CharSequence charSequence = LiveRoomInfo.a().a(paramString, "#ffd452", new LiveRoomConstants.ClickAtLinkListener(this) {
          public void a(String param1String1, String param1String2) {
            if (MarqueeView.a(this.a) != null) {
              if (TextUtils.isEmpty(param1String2)) {
                MarqueeView.a(this.a).b(param1String1);
                return;
              } 
              MarqueeView.a(this.a).a(param1String2);
              return;
            } 
            if (TextUtils.isEmpty(param1String2)) {
              LiveSetDataObserver.a().d(param1String1);
              return;
            } 
            LiveSetDataObserver.a().e(param1String2);
          }
        });
    int j = charSequence.length();
    Context context = getContext();
    int i = this.q;
    if (i > 580) {
      f = 720.0F;
    } else {
      f = i;
    } 
    i = DensityUtils.b(context, f);
    if (i != 0) {
      int k = i / this.d;
      ArrayList<CharSequence> arrayList = new ArrayList();
      if (j <= k) {
        arrayList.add(charSequence);
      } else {
        byte b;
        int n = j / k;
        if (j % k != 0) {
          b = 1;
        } else {
          b = 0;
        } 
        int m = 0;
        i = 0;
        while (m < n + b) {
          int i2 = m * k + i;
          int i3 = m + 1;
          int i1 = i3 * k + i;
          m = i1;
          if (i1 >= j)
            m = j; 
          if (i2 == 0) {
            i1 = 0;
          } else {
            i1 = i2;
          } 
          CharSequence charSequence1 = charSequence.subSequence(i1, m);
          Matcher matcher = Pattern.compile("[a-z0-9]").matcher(charSequence1);
          for (i1 = 0; matcher.find(); i1++)
            i++; 
          m += i1;
          if (m >= j) {
            arrayList.add(charSequence.subSequence(i2, j));
            break;
          } 
          arrayList.add(charSequence.subSequence(i2, m));
          m = i3;
        } 
      } 
      if (this.m == null)
        this.m = new ArrayList<CharSequence>(); 
      this.m.clear();
      this.m.addAll(arrayList);
      a(paramInt1, paramInt2);
      return;
    } 
    throw new RuntimeException("Please set the width of MarqueeView !");
  }
  
  private void b(int paramInt1, int paramInt2) {
    removeAllViews();
    clearAnimation();
    this.l = 0;
    addView((View)a(this.m.get(this.l)));
    if (this.m.size() > 1) {
      c(paramInt1, paramInt2);
      startFlipping();
    } 
    if (getInAnimation() != null) {
      getInAnimation().setAnimationListener(new Animation.AnimationListener(this) {
            public void onAnimationEnd(Animation param1Animation) {
              MarqueeView.b(this.a);
              if (MarqueeView.c(this.a) >= MarqueeView.d(this.a).size()) {
                AppInfo.n().postDelayed(new Runnable(this) {
                      public void run() {
                        if (MarqueeView.e(this.a.a) != null)
                          MarqueeView.e(this.a.a).a(); 
                      }
                    },  1000L);
                return;
              } 
              MarqueeView marqueeView = this.a;
              TextView textView = MarqueeView.a(marqueeView, MarqueeView.d(marqueeView).get(MarqueeView.c(this.a)));
              if (textView.getParent() == null)
                this.a.addView((View)textView); 
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
      return;
    } 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            if (MarqueeView.e(this.a) != null)
              MarqueeView.e(this.a).a(); 
          }
        },  4000L);
  }
  
  private void c(int paramInt1, int paramInt2) {
    Animation animation = AnimationUtils.loadAnimation(getContext(), paramInt1);
    if (this.b)
      animation.setDuration(this.c); 
    setInAnimation(animation);
    animation = AnimationUtils.loadAnimation(getContext(), paramInt2);
    if (this.b)
      animation.setDuration(this.c); 
    setOutAnimation(animation);
  }
  
  public List<? extends CharSequence> getNotices() {
    return this.m;
  }
  
  public int getPosition() {
    return ((Integer)getCurrentView().getTag()).intValue();
  }
  
  public void setLiveMsgManager(LiveMsgManager paramLiveMsgManager) {
    this.o = paramLiveMsgManager;
  }
  
  public void setNotices(List<? extends CharSequence> paramList) {
    this.m = paramList;
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener) {
    this.n = paramOnItemClickListener;
  }
  
  public void setOnScrollListener(ScrollTextView.OnScrollListener paramOnScrollListener) {
    this.p = paramOnScrollListener;
  }
  
  public void setTextColor(String paramString) {
    this.e = paramString;
  }
  
  public void setWidth(int paramInt) {
    this.q = paramInt;
  }
  
  public static interface OnItemClickListener {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\MarqueeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */