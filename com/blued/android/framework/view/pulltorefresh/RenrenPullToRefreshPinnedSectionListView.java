package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.framework.R;

public class RenrenPullToRefreshPinnedSectionListView extends PullToRefreshPinnedSectionListView {
  private Context b;
  
  private View c;
  
  private LinearLayout d;
  
  private ImageView e;
  
  private TextView f;
  
  private ProgressBar g;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private OnPullDownListener j;
  
  public RenrenPullToRefreshPinnedSectionListView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public RenrenPullToRefreshPinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
  }
  
  public RenrenPullToRefreshPinnedSectionListView(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
    a(paramContext);
  }
  
  public RenrenPullToRefreshPinnedSectionListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
    super(paramContext, paramMode, paramAnimationStyle);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    d(paramContext, (AttributeSet)null);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    TypedArray typedArray = this.b.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrFooterBackground)) {
      Drawable drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrFooterBackground);
      if (drawable != null)
        this.d.setBackgroundDrawable(drawable); 
    } 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrFooterSubTextColor)) {
      ColorStateList colorStateList = typedArray.getColorStateList(R.styleable.PullToRefresh_ptrFooterSubTextColor);
      if (colorStateList != null)
        this.f.setTextColor(colorStateList); 
    } 
    typedArray.recycle();
  }
  
  private void b(AttributeSet paramAttributeSet) {
    this.c = LayoutInflater.from(this.b).inflate(R.layout.pulldown_footer, null);
    this.d = (LinearLayout)this.c.findViewById(R.id.pulldown_footer_content);
    this.e = (ImageView)this.c.findViewById(R.id.pulldown_footer_divider);
    this.f = (TextView)this.c.findViewById(R.id.pulldown_footer_text);
    this.f.setText(PullToRefreshHelper.d());
    this.g = (ProgressBar)this.c.findViewById(R.id.pulldown_footer_loading);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (!RenrenPullToRefreshPinnedSectionListView.c(this.a)) {
              RenrenPullToRefreshPinnedSectionListView.a(this.a, true);
              RenrenPullToRefreshPinnedSectionListView.e(this.a).setVisibility(4);
              RenrenPullToRefreshPinnedSectionListView.f(this.a).setVisibility(0);
              if (RenrenPullToRefreshPinnedSectionListView.a(this.a) != null)
                RenrenPullToRefreshPinnedSectionListView.a(this.a).b(); 
            } 
          }
        });
    if (paramAttributeSet != null)
      a(paramAttributeSet); 
    getRefreshableView().addFooterView(this.c);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet) {
    this.b = paramContext;
    setMode(PullToRefreshBase.Mode.b);
    b(paramAttributeSet);
    setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>(this) {
          public void a(PullToRefreshBase<ListView> param1PullToRefreshBase) {
            if (RenrenPullToRefreshPinnedSectionListView.a(this.a) != null)
              RenrenPullToRefreshPinnedSectionListView.a(this.a).a(); 
          }
        });
    setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener(this) {
          public void a() {
            if (RenrenPullToRefreshPinnedSectionListView.b(this.a) && !RenrenPullToRefreshPinnedSectionListView.c(this.a) && RenrenPullToRefreshPinnedSectionListView.d(this.a)) {
              RenrenPullToRefreshPinnedSectionListView.a(this.a, true);
              RenrenPullToRefreshPinnedSectionListView.e(this.a).setVisibility(4);
              RenrenPullToRefreshPinnedSectionListView.f(this.a).setVisibility(0);
              if (RenrenPullToRefreshPinnedSectionListView.a(this.a) != null)
                RenrenPullToRefreshPinnedSectionListView.a(this.a).b(); 
            } 
          }
        });
  }
  
  private boolean r() {
    ListView listView = getRefreshableView();
    int i = listView.getFirstVisiblePosition();
    return (listView.getLastVisiblePosition() - listView.getFooterViewsCount() - i + 1 < listView.getCount() - listView.getFooterViewsCount());
  }
  
  public void o() {
    this.h = true;
    LinearLayout linearLayout = this.d;
    if (linearLayout != null && linearLayout.getVisibility() != 0)
      this.d.setVisibility(0); 
  }
  
  public void p() {
    this.h = false;
    LinearLayout linearLayout = this.d;
    if (linearLayout != null && linearLayout.getVisibility() == 0)
      this.d.setVisibility(8); 
  }
  
  public void q() {
    post(new Runnable(this) {
          public void run() {
            RenrenPullToRefreshPinnedSectionListView.a(this.a, false);
            RenrenPullToRefreshPinnedSectionListView.e(this.a).setVisibility(0);
            RenrenPullToRefreshPinnedSectionListView.f(this.a).setVisibility(4);
          }
        });
  }
  
  public void setOnPullDownListener(OnPullDownListener paramOnPullDownListener) {
    this.j = paramOnPullDownListener;
  }
  
  public void setRefreshEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      setMode(PullToRefreshBase.Mode.b);
      return;
    } 
    setMode(PullToRefreshBase.Mode.a);
  }
  
  public static interface OnPullDownListener {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\RenrenPullToRefreshPinnedSectionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */