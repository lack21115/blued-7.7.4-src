package com.soft.blued.ui.user.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.soft.blued.utils.Logger;

public class UserProfileHoverBtmBtns extends LinearLayout implements View.OnClickListener {
  public Context a;
  
  public View b;
  
  private View c;
  
  private ImageView d;
  
  private TextView e;
  
  private View f;
  
  private ImageView g;
  
  private TextView h;
  
  private boolean i;
  
  private Long j;
  
  private int k;
  
  private float l;
  
  private View.OnClickListener m;
  
  private View.OnClickListener n;
  
  private BaseFragment o;
  
  private View p;
  
  private RecyclerView.OnScrollListener q = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {}
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        param1Int1 = ((GridLayoutManager)param1RecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (param1RecyclerView.getChildAt(0) != null) {
          if (UserProfileHoverBtmBtns.a(this.a) == null)
            UserProfileHoverBtmBtns.a(this.a, Long.valueOf(System.currentTimeMillis())); 
          param1Int2 = param1RecyclerView.getChildAt(0).getTop();
          long l = System.currentTimeMillis() - UserProfileHoverBtmBtns.a(this.a).longValue();
          if (param1Int1 == 0 && param1Int2 == 0) {
            if (!UserProfileHoverBtmBtns.b(this.a))
              this.a.b(); 
          } else if (UserProfileHoverBtmBtns.c(this.a) < param1Int1) {
            if (UserProfileHoverBtmBtns.b(this.a))
              this.a.c(); 
          } else if (UserProfileHoverBtmBtns.c(this.a) == param1Int1) {
            float f1 = UserProfileHoverBtmBtns.d(this.a);
            float f2 = param1Int2;
            int i = (int)Math.abs(f1 - f2);
            if (UserProfileHoverBtmBtns.d(this.a) < f2 && l != 0L && (i * 1000) / l > 2000L) {
              if (!UserProfileHoverBtmBtns.b(this.a))
                this.a.b(); 
            } else if (UserProfileHoverBtmBtns.d(this.a) > f2 && i > 10 && UserProfileHoverBtmBtns.b(this.a)) {
              this.a.c();
            } 
          } 
          UserProfileHoverBtmBtns.a(this.a, param1Int1);
          UserProfileHoverBtmBtns.a(this.a, param1Int2);
          UserProfileHoverBtmBtns.a(this.a, Long.valueOf(System.currentTimeMillis()));
        } 
      }
    };
  
  public UserProfileHoverBtmBtns(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public UserProfileHoverBtmBtns(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void c(View paramView) {
    Logger.c("hover_btns", new Object[] { " startBtmBtnShowAnim()" });
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.a, -80.0F), 0 });
    valueAnimator.setDuration(200L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i);
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.start();
  }
  
  private void d(View paramView) {
    Logger.c("hover_btns", new Object[] { " startBtmBtnHideAnim()" });
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { 0, DensityUtils.a(this.a, -80.0F) });
    valueAnimator.setDuration(200L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i);
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          }
        });
    valueAnimator.start();
  }
  
  public void a() {
    Logger.c("hover_btns", new Object[] { " initView()" });
    this.b = LayoutInflater.from(this.a).inflate(2131494241, (ViewGroup)this, true);
    this.p = this.b.findViewById(2131298699);
    this.c = this.b.findViewById(2131298907);
    this.d = (ImageView)this.b.findViewById(2131297502);
    this.e = (TextView)this.b.findViewById(2131300947);
    this.f = this.b.findViewById(2131299061);
    this.g = (ImageView)this.b.findViewById(2131297549);
    this.h = (TextView)this.b.findViewById(2131301277);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void a(View paramView) {
    Logger.c("hover_btns", new Object[] { " playImageButtonClickAnimator()" });
    AnimatorSet animatorSet = new AnimatorSet();
    ValueAnimator valueAnimator1 = ObjectAnimator.ofFloat(new float[] { 1.0F, 0.7F });
    valueAnimator1.setDuration(100L);
    valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(f);
            this.a.setScaleY(f);
          }
        });
    ValueAnimator valueAnimator2 = ObjectAnimator.ofFloat(new float[] { 0.7F, 1.0F });
    valueAnimator2.setDuration(100L);
    valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(f);
            this.a.setScaleY(f);
          }
        });
    valueAnimator2.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    animatorSet.playSequentially(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.addListener(new Animator.AnimatorListener(this, paramView) {
          public void onAnimationCancel(Animator param1Animator) {}
          
          public void onAnimationEnd(Animator param1Animator) {
            if (UserProfileHoverBtmBtns.e(this.b) != null) {
              if (CommonTools.a((Fragment)UserProfileHoverBtmBtns.e(this.b)))
                this.b.b(this.a); 
            } else {
              this.b.b(this.a);
            } 
            this.a.setOnClickListener(this.b);
          }
          
          public void onAnimationRepeat(Animator param1Animator) {}
          
          public void onAnimationStart(Animator param1Animator) {
            this.a.setOnClickListener(null);
          }
        });
    animatorSet.start();
  }
  
  public void b() {
    c(this.p);
    this.i = true;
  }
  
  public void b(View paramView) {
    int i = paramView.getId();
    if (i != 2131298907) {
      if (i != 2131299061)
        return; 
      View.OnClickListener onClickListener = this.n;
      if (onClickListener != null) {
        onClickListener.onClick(this.f);
        return;
      } 
    } else {
      View.OnClickListener onClickListener = this.m;
      if (onClickListener != null)
        onClickListener.onClick(this.c); 
    } 
  }
  
  public void c() {
    d(this.p);
    this.i = false;
  }
  
  public boolean getIfBtmBtnShowed() {
    return this.i;
  }
  
  public ImageView getImgLeft() {
    return this.d;
  }
  
  public ImageView getImgRight() {
    return this.g;
  }
  
  public RecyclerView.OnScrollListener getScrollListener() {
    return this.q;
  }
  
  public TextView getTvLeft() {
    return this.e;
  }
  
  public TextView getTvRight() {
    return this.h;
  }
  
  public void onClick(View paramView) {
    a(paramView);
  }
  
  public void setFragment(BaseFragment paramBaseFragment) {
    this.o = paramBaseFragment;
  }
  
  public void setLeftBtnClick(View.OnClickListener paramOnClickListener) {
    this.m = paramOnClickListener;
  }
  
  public void setRightBtnClick(View.OnClickListener paramOnClickListener) {
    this.n = paramOnClickListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\UserProfileHoverBtmBtns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */