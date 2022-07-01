package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;

public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
  private static final Interpolator l = (Interpolator)new DecelerateInterpolator();
  
  Runnable a;
  
  LinearLayoutCompat b;
  
  int c;
  
  int d;
  
  protected ViewPropertyAnimator e;
  
  protected final VisibilityAnimListener f = new VisibilityAnimListener(this);
  
  private TabClickListener g;
  
  private Spinner h;
  
  private boolean i;
  
  private int j;
  
  private int k;
  
  public ScrollingTabContainerView(Context paramContext) {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(paramContext);
    setContentHeight(actionBarPolicy.getTabContainerHeight());
    this.d = actionBarPolicy.getStackedTabMaxWidth();
    this.b = d();
    addView((View)this.b, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private boolean a() {
    Spinner spinner = this.h;
    return (spinner != null && spinner.getParent() == this);
  }
  
  private void b() {
    if (a())
      return; 
    if (this.h == null)
      this.h = e(); 
    removeView((View)this.b);
    addView((View)this.h, new ViewGroup.LayoutParams(-2, -1));
    if (this.h.getAdapter() == null)
      this.h.setAdapter((SpinnerAdapter)new TabAdapter(this)); 
    Runnable runnable = this.a;
    if (runnable != null) {
      removeCallbacks(runnable);
      this.a = null;
    } 
    this.h.setSelection(this.k);
  }
  
  private boolean c() {
    if (!a())
      return false; 
    removeView((View)this.h);
    addView((View)this.b, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.h.getSelectedItemPosition());
    return false;
  }
  
  private LinearLayoutCompat d() {
    LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
    linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    linearLayoutCompat.setGravity(17);
    linearLayoutCompat.setLayoutParams((ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
    return linearLayoutCompat;
  }
  
  private Spinner e() {
    AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
    appCompatSpinner.setLayoutParams((ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(-2, -1));
    appCompatSpinner.setOnItemSelectedListener(this);
    return appCompatSpinner;
  }
  
  TabView a(ActionBar.Tab paramTab, boolean paramBoolean) {
    TabView tabView = new TabView(this, getContext(), paramTab, paramBoolean);
    if (paramBoolean) {
      tabView.setBackgroundDrawable(null);
      tabView.setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, this.j));
      return tabView;
    } 
    tabView.setFocusable(true);
    if (this.g == null)
      this.g = new TabClickListener(this); 
    tabView.setOnClickListener(this.g);
    return tabView;
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean) {
    TabView tabView = a(paramTab, false);
    this.b.addView((View)tabView, paramInt, (ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    Spinner spinner = this.h;
    if (spinner != null)
      ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged(); 
    if (paramBoolean)
      tabView.setSelected(true); 
    if (this.i)
      requestLayout(); 
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean) {
    TabView tabView = a(paramTab, false);
    this.b.addView((View)tabView, (ViewGroup.LayoutParams)new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    Spinner spinner = this.h;
    if (spinner != null)
      ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged(); 
    if (paramBoolean)
      tabView.setSelected(true); 
    if (this.i)
      requestLayout(); 
  }
  
  public void animateToTab(int paramInt) {
    View view = this.b.getChildAt(paramInt);
    Runnable runnable = this.a;
    if (runnable != null)
      removeCallbacks(runnable); 
    this.a = new Runnable(this, view) {
        public void run() {
          int i = this.a.getLeft();
          int j = (this.b.getWidth() - this.a.getWidth()) / 2;
          this.b.smoothScrollTo(i - j, 0);
          this.b.a = null;
        }
      };
    post(this.a);
  }
  
  public void animateToVisibility(int paramInt) {
    ViewPropertyAnimator viewPropertyAnimator = this.e;
    if (viewPropertyAnimator != null)
      viewPropertyAnimator.cancel(); 
    if (paramInt == 0) {
      if (getVisibility() != 0)
        setAlpha(0.0F); 
      viewPropertyAnimator = animate().alpha(1.0F);
      viewPropertyAnimator.setDuration(200L);
      viewPropertyAnimator.setInterpolator((TimeInterpolator)l);
      viewPropertyAnimator.setListener((Animator.AnimatorListener)this.f.withFinalVisibility(viewPropertyAnimator, paramInt));
      viewPropertyAnimator.start();
      return;
    } 
    viewPropertyAnimator = animate().alpha(0.0F);
    viewPropertyAnimator.setDuration(200L);
    viewPropertyAnimator.setInterpolator((TimeInterpolator)l);
    viewPropertyAnimator.setListener((Animator.AnimatorListener)this.f.withFinalVisibility(viewPropertyAnimator, paramInt));
    viewPropertyAnimator.start();
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    Runnable runnable = this.a;
    if (runnable != null)
      post(runnable); 
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
    setContentHeight(actionBarPolicy.getTabContainerHeight());
    this.d = actionBarPolicy.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Runnable runnable = this.a;
    if (runnable != null)
      removeCallbacks(runnable); 
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ((TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    boolean bool;
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = 1;
    if (i == 1073741824) {
      bool = true;
    } else {
      bool = false;
    } 
    setFillViewport(bool);
    int j = this.b.getChildCount();
    if (j > 1 && (i == 1073741824 || i == Integer.MIN_VALUE)) {
      if (j > 2) {
        this.c = (int)(View.MeasureSpec.getSize(paramInt1) * 0.4F);
      } else {
        this.c = View.MeasureSpec.getSize(paramInt1) / 2;
      } 
      this.c = Math.min(this.c, this.d);
    } else {
      this.c = -1;
    } 
    i = View.MeasureSpec.makeMeasureSpec(this.j, 1073741824);
    if (bool || !this.i)
      paramInt2 = 0; 
    if (paramInt2 != 0) {
      this.b.measure(0, i);
      if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1)) {
        b();
      } else {
        c();
      } 
    } else {
      c();
    } 
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, i);
    paramInt1 = getMeasuredWidth();
    if (bool && paramInt2 != paramInt1)
      setTabSelected(this.k); 
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void removeAllTabs() {
    this.b.removeAllViews();
    Spinner spinner = this.h;
    if (spinner != null)
      ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged(); 
    if (this.i)
      requestLayout(); 
  }
  
  public void removeTabAt(int paramInt) {
    this.b.removeViewAt(paramInt);
    Spinner spinner = this.h;
    if (spinner != null)
      ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged(); 
    if (this.i)
      requestLayout(); 
  }
  
  public void setAllowCollapse(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void setContentHeight(int paramInt) {
    this.j = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt) {
    this.k = paramInt;
    int j = this.b.getChildCount();
    for (int i = 0; i < j; i++) {
      boolean bool;
      View view = this.b.getChildAt(i);
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
      if (bool)
        animateToTab(paramInt); 
    } 
    Spinner spinner = this.h;
    if (spinner != null && paramInt >= 0)
      spinner.setSelection(paramInt); 
  }
  
  public void updateTab(int paramInt) {
    ((TabView)this.b.getChildAt(paramInt)).update();
    Spinner spinner = this.h;
    if (spinner != null)
      ((TabAdapter)spinner.getAdapter()).notifyDataSetChanged(); 
    if (this.i)
      requestLayout(); 
  }
  
  class TabAdapter extends BaseAdapter {
    TabAdapter(ScrollingTabContainerView this$0) {}
    
    public int getCount() {
      return this.a.b.getChildCount();
    }
    
    public Object getItem(int param1Int) {
      return ((ScrollingTabContainerView.TabView)this.a.b.getChildAt(param1Int)).getTab();
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      if (param1View == null)
        return (View)this.a.a((ActionBar.Tab)getItem(param1Int), true); 
      ((ScrollingTabContainerView.TabView)param1View).bindTab((ActionBar.Tab)getItem(param1Int));
      return param1View;
    }
  }
  
  class TabClickListener implements View.OnClickListener {
    TabClickListener(ScrollingTabContainerView this$0) {}
    
    public void onClick(View param1View) {
      ((ScrollingTabContainerView.TabView)param1View).getTab().select();
      int j = this.a.b.getChildCount();
      for (int i = 0; i < j; i++) {
        boolean bool;
        View view = this.a.b.getChildAt(i);
        if (view == param1View) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      } 
    }
  }
  
  class TabView extends LinearLayout {
    private final int[] b = new int[] { 16842964 };
    
    private ActionBar.Tab c;
    
    private TextView d;
    
    private ImageView e;
    
    private View f;
    
    public TabView(ScrollingTabContainerView this$0, Context param1Context, ActionBar.Tab param1Tab, boolean param1Boolean) {
      super(param1Context, null, R.attr.actionBarTabStyle);
      this.c = param1Tab;
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(param1Context, null, this.b, R.attr.actionBarTabStyle, 0);
      if (tintTypedArray.hasValue(0))
        setBackgroundDrawable(tintTypedArray.getDrawable(0)); 
      tintTypedArray.recycle();
      if (param1Boolean)
        setGravity(8388627); 
      update();
    }
    
    public void bindTab(ActionBar.Tab param1Tab) {
      this.c = param1Tab;
      update();
    }
    
    public ActionBar.Tab getTab() {
      return this.c;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      super.onInitializeAccessibilityNodeInfo(param1AccessibilityNodeInfo);
      param1AccessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
    }
    
    public void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      if (this.a.c > 0 && getMeasuredWidth() > this.a.c)
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a.c, 1073741824), param1Int2); 
    }
    
    public void setSelected(boolean param1Boolean) {
      boolean bool;
      if (isSelected() != param1Boolean) {
        bool = true;
      } else {
        bool = false;
      } 
      super.setSelected(param1Boolean);
      if (bool && param1Boolean)
        sendAccessibilityEvent(4); 
    }
    
    public void update() {
      ActionBar.Tab tab = this.c;
      View view = tab.getCustomView();
      ViewParent viewParent = null;
      if (view != null) {
        viewParent = view.getParent();
        if (viewParent != this) {
          if (viewParent != null)
            ((ViewGroup)viewParent).removeView(view); 
          addView(view);
        } 
        this.f = view;
        TextView textView = this.d;
        if (textView != null)
          textView.setVisibility(8); 
        ImageView imageView = this.e;
        if (imageView != null) {
          imageView.setVisibility(8);
          this.e.setImageDrawable(null);
          return;
        } 
      } else {
        CharSequence charSequence1;
        view = this.f;
        if (view != null) {
          removeView(view);
          this.f = null;
        } 
        Drawable drawable = tab.getIcon();
        CharSequence charSequence2 = tab.getText();
        if (drawable != null) {
          if (this.e == null) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            appCompatImageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            addView((View)appCompatImageView, 0);
            this.e = appCompatImageView;
          } 
          this.e.setImageDrawable(drawable);
          this.e.setVisibility(0);
        } else {
          ImageView imageView1 = this.e;
          if (imageView1 != null) {
            imageView1.setVisibility(8);
            this.e.setImageDrawable(null);
          } 
        } 
        int i = TextUtils.isEmpty(charSequence2) ^ true;
        if (i != 0) {
          if (this.d == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            appCompatTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            addView((View)appCompatTextView);
            this.d = appCompatTextView;
          } 
          this.d.setText(charSequence2);
          this.d.setVisibility(0);
        } else {
          TextView textView = this.d;
          if (textView != null) {
            textView.setVisibility(8);
            this.d.setText(null);
          } 
        } 
        ImageView imageView = this.e;
        if (imageView != null)
          imageView.setContentDescription(tab.getContentDescription()); 
        if (i == 0)
          charSequence1 = tab.getContentDescription(); 
        TooltipCompat.setTooltipText((View)this, charSequence1);
      } 
    }
  }
  
  public class VisibilityAnimListener extends AnimatorListenerAdapter {
    private boolean b = false;
    
    private int c;
    
    protected VisibilityAnimListener(ScrollingTabContainerView this$0) {}
    
    public void onAnimationCancel(Animator param1Animator) {
      this.b = true;
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      if (this.b)
        return; 
      ScrollingTabContainerView scrollingTabContainerView = this.a;
      scrollingTabContainerView.e = null;
      scrollingTabContainerView.setVisibility(this.c);
    }
    
    public void onAnimationStart(Animator param1Animator) {
      this.a.setVisibility(0);
      this.b = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator param1ViewPropertyAnimator, int param1Int) {
      this.c = param1Int;
      this.a.e = param1ViewPropertyAnimator;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ScrollingTabContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */