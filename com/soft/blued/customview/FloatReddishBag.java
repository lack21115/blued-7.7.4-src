package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardStatusExtra;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.lang.ref.SoftReference;
import java.util.List;

public abstract class FloatReddishBag extends LinearLayout {
  public Context a;
  
  public View b;
  
  private ImageView c;
  
  private TextView d;
  
  private Handler e;
  
  private List<LiveRewardListModel> f;
  
  private int g;
  
  private BaseFragment h;
  
  private String i;
  
  private boolean j = true;
  
  private Long k;
  
  private int l;
  
  private float m;
  
  private RecyclerView.OnScrollListener n = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {}
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        param1Int1 = ((GridLayoutManager)param1RecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (param1RecyclerView.getChildAt(0) != null) {
          if (FloatReddishBag.b(this.a) == null)
            FloatReddishBag.a(this.a, Long.valueOf(System.currentTimeMillis())); 
          param1Int2 = param1RecyclerView.getChildAt(0).getTop();
          long l = System.currentTimeMillis() - FloatReddishBag.b(this.a).longValue();
          if (param1Int1 == 0 && param1Int2 == 0) {
            if (!FloatReddishBag.c(this.a))
              FloatReddishBag.d(this.a); 
          } else if (FloatReddishBag.e(this.a) < param1Int1) {
            if (FloatReddishBag.c(this.a))
              FloatReddishBag.f(this.a); 
          } else if (FloatReddishBag.e(this.a) == param1Int1) {
            float f1 = FloatReddishBag.g(this.a);
            float f2 = param1Int2;
            int i = (int)Math.abs(f1 - f2);
            if (FloatReddishBag.g(this.a) < f2 && l != 0L && (i * 1000) / l > 2000L) {
              if (!FloatReddishBag.c(this.a))
                FloatReddishBag.d(this.a); 
            } else if (FloatReddishBag.g(this.a) > f2 && i > 10 && FloatReddishBag.c(this.a)) {
              FloatReddishBag.f(this.a);
            } 
          } 
          FloatReddishBag.a(this.a, param1Int1);
          FloatReddishBag.a(this.a, param1Int2);
          FloatReddishBag.a(this.a, Long.valueOf(System.currentTimeMillis()));
        } 
      }
    };
  
  public FloatReddishBag(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    e();
  }
  
  public FloatReddishBag(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    e();
  }
  
  public FloatReddishBag(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    e();
  }
  
  private void a(long paramLong) {
    this.e.removeMessages(0);
    this.e.sendEmptyMessageDelayed(0, paramLong);
  }
  
  private void a(View paramView) {
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.a, -50.0F), DensityUtils.a(this.a, 30.0F) });
    valueAnimator.setDuration(200L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          }
        });
    valueAnimator.start();
  }
  
  private void a(IRequestHost paramIRequestHost) {
    a(new BluedUIHttpResponse<BluedEntity<LiveRewardListModel, LiveRewardStatusExtra>>(this, paramIRequestHost) {
          public void onUIUpdate(BluedEntity<LiveRewardListModel, LiveRewardStatusExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.hasData()) {
              if (param1BluedEntity.extra != null) {
                String str = ((LiveRewardStatusExtra)param1BluedEntity.extra).redirect;
                if (!TextUtils.isEmpty(str)) {
                  FloatReddishBag.a(this.a, param1BluedEntity.data, str);
                  return;
                } 
              } 
            } else {
              FloatReddishBag.a(this.a, param1BluedEntity.data, "");
            } 
          }
        }paramIRequestHost);
  }
  
  private void a(List<LiveRewardListModel> paramList, String paramString) {
    if (!this.h.isAdded())
      return; 
    if (paramList != null && paramList.size() > 0) {
      b();
      this.f = paramList;
      this.i = paramString;
      setVisibility(0);
      TextView textView = this.d;
      String str = this.a.getResources().getString(2131757660);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramList.size());
      stringBuilder.append("");
      textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
      a(0L);
      return;
    } 
    setVisibility(8);
  }
  
  private void b(View paramView) {
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.a, 30.0F), DensityUtils.a(this.a, -50.0F) });
    valueAnimator.setDuration(200L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            this.a.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          }
        });
    valueAnimator.start();
  }
  
  private void e() {
    this.b = LayoutInflater.from(this.a).inflate(2131493928, (ViewGroup)this);
    this.c = (ImageView)this.b.findViewById(2131299611);
    this.d = (TextView)this.b.findViewById(2131299612);
    this.e = new MyHandler(this);
    setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
            WebViewShowInfoFragment.show(this.a.a, FloatReddishBag.a(this.a), 7);
          }
        });
  }
  
  private void f() {
    a((View)this);
    this.j = true;
  }
  
  private void g() {
    b((View)this);
    this.j = false;
  }
  
  public abstract void a();
  
  public void a(int paramInt) {
    List<LiveRewardListModel> list = this.f;
    if (list != null && list.size() > paramInt) {
      LiveRewardListModel liveRewardListModel = this.f.get(paramInt);
      if (liveRewardListModel != null) {
        BaseFragment baseFragment = this.h;
        if (baseFragment != null) {
          ActivityFragmentActive activityFragmentActive = baseFragment.w_();
        } else {
          baseFragment = null;
        } 
        ImageLoader.a((IRequestHost)baseFragment, liveRewardListModel.avatar).a(2131234356).c().a(this.c);
      } 
    } 
  }
  
  public abstract void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost);
  
  public abstract void b();
  
  public void c() {
    a((IRequestHost)this.h.w_());
  }
  
  public void d() {
    List<LiveRewardListModel> list = this.f;
    if (list != null) {
      int j = this.g;
      int i = list.size();
      if (++j == i) {
        this.g = 0;
      } else {
        this.g = j;
      } 
      a(this.g);
    } 
  }
  
  public RecyclerView.OnScrollListener getCustomScrollListener() {
    return this.n;
  }
  
  public void setFragment(BaseFragment paramBaseFragment) {
    this.h = paramBaseFragment;
  }
  
  static class MyHandler extends Handler {
    SoftReference<FloatReddishBag> a;
    
    public MyHandler(FloatReddishBag param1FloatReddishBag) {
      this.a = new SoftReference<FloatReddishBag>(param1FloatReddishBag);
    }
    
    public void handleMessage(Message param1Message) {
      super.handleMessage(param1Message);
      if (param1Message.what != 0)
        return; 
      FloatReddishBag floatReddishBag = this.a.get();
      if (floatReddishBag != null) {
        floatReddishBag.d();
        FloatReddishBag.a(floatReddishBag, 3000L);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\FloatReddishBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */