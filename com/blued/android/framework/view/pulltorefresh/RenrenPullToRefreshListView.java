package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.framework.R;

public class RenrenPullToRefreshListView extends PullToRefreshListView {
  private Context b;
  
  private View c;
  
  private LinearLayout d;
  
  private ImageView e;
  
  private TextView f;
  
  private ProgressBar g;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private boolean j = true;
  
  private int k;
  
  private int l;
  
  private long m;
  
  private OnPullDownListener n;
  
  private AbsListView.OnScrollListener o;
  
  private AbsListView.OnScrollListener p = new AbsListView.OnScrollListener(this) {
      public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
        if (RenrenPullToRefreshListView.g(this.a) != null)
          RenrenPullToRefreshListView.g(this.a).onScroll(param1AbsListView, param1Int1, param1Int2, param1Int3); 
        if (RenrenPullToRefreshListView.h(this.a) && RenrenPullToRefreshListView.b(this.a) && !RenrenPullToRefreshListView.c(this.a)) {
          if (RenrenPullToRefreshListView.a(this.a) == null)
            return; 
          ListAdapter listAdapter = (ListAdapter)param1AbsListView.getAdapter();
          if (listAdapter == null)
            return; 
          long l = System.currentTimeMillis();
          if (RenrenPullToRefreshListView.i(this.a) == 0L) {
            RenrenPullToRefreshListView.a(this.a, l);
            return;
          } 
          if (param1Int1 > RenrenPullToRefreshListView.j(this.a)) {
            double d = (l - RenrenPullToRefreshListView.i(this.a));
            RenrenPullToRefreshListView.a(this.a, param1AbsListView.getLastVisiblePosition());
            RenrenPullToRefreshListView.b(this.a, param1Int1);
            RenrenPullToRefreshListView.a(this.a, l);
            if (d <= 30.0D) {
              param1Int2 = RenrenPullToRefreshListView.k(this.a);
              if (listAdapter.getCount() < 15) {
                param1Int1 = (listAdapter.getCount() - param1Int1) / 2;
              } else {
                param1Int1 = listAdapter.getCount() - 14;
              } 
              if (param1Int2 >= param1Int1) {
                RenrenPullToRefreshListView.a(this.a, true);
                RenrenPullToRefreshListView.a(this.a).b();
                return;
              } 
            } else if (d <= 220.0D) {
              param1Int2 = RenrenPullToRefreshListView.k(this.a);
              if (listAdapter.getCount() < 15) {
                param1Int1 = (listAdapter.getCount() - param1Int1) / 2;
              } else {
                param1Int1 = listAdapter.getCount() - 12;
              } 
              if (param1Int2 >= param1Int1) {
                RenrenPullToRefreshListView.a(this.a, true);
                RenrenPullToRefreshListView.a(this.a).b();
                return;
              } 
            } else {
              param1Int2 = RenrenPullToRefreshListView.k(this.a);
              if (listAdapter.getCount() < 15) {
                param1Int1 = (listAdapter.getCount() - param1Int1) * 2 / 3;
              } else {
                param1Int1 = listAdapter.getCount() - 10;
              } 
              if (param1Int2 >= param1Int1) {
                RenrenPullToRefreshListView.a(this.a, true);
                RenrenPullToRefreshListView.a(this.a).b();
              } 
            } 
          } 
        } 
      }
      
      public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
        if (RenrenPullToRefreshListView.g(this.a) != null)
          RenrenPullToRefreshListView.g(this.a).onScrollStateChanged(param1AbsListView, param1Int); 
        if (param1Int == 1)
          RenrenPullToRefreshListView.a(this.a, 0L); 
      }
    };
  
  public RenrenPullToRefreshListView(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public RenrenPullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    d(paramContext, paramAttributeSet);
  }
  
  public RenrenPullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode) {
    super(paramContext, paramMode);
    a(paramContext);
  }
  
  public RenrenPullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle) {
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
            if (!RenrenPullToRefreshListView.c(this.a)) {
              RenrenPullToRefreshListView.a(this.a, true);
              RenrenPullToRefreshListView.e(this.a).setVisibility(4);
              RenrenPullToRefreshListView.f(this.a).setVisibility(0);
              if (RenrenPullToRefreshListView.a(this.a) != null)
                RenrenPullToRefreshListView.a(this.a).b(); 
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
            if (RenrenPullToRefreshListView.a(this.a) != null) {
              RenrenPullToRefreshListView.a(this.a, true);
              RenrenPullToRefreshListView.a(this.a).a();
            } 
          }
        });
    setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener(this) {
          public void a() {
            if (RenrenPullToRefreshListView.b(this.a) && !RenrenPullToRefreshListView.c(this.a) && RenrenPullToRefreshListView.d(this.a)) {
              RenrenPullToRefreshListView.e(this.a).setVisibility(4);
              RenrenPullToRefreshListView.f(this.a).setVisibility(0);
              if (RenrenPullToRefreshListView.a(this.a) != null) {
                RenrenPullToRefreshListView.a(this.a, true);
                RenrenPullToRefreshListView.a(this.a).b();
              } 
            } 
          }
        });
    super.setOnScrollListener(this.p);
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
            RenrenPullToRefreshListView.a(this.a, false);
            ListView listView = this.a.getRefreshableView();
            if (listView != null && listView.getLastVisiblePosition() >= listView.getCount() - 2) {
              RenrenPullToRefreshListView.e(this.a).setVisibility(0);
              RenrenPullToRefreshListView.f(this.a).setVisibility(4);
              return;
            } 
            RenrenPullToRefreshListView.e(this.a).setVisibility(4);
            RenrenPullToRefreshListView.f(this.a).setVisibility(0);
          }
        });
  }
  
  public void setOnPullDownListener(OnPullDownListener paramOnPullDownListener) {
    this.n = paramOnPullDownListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
    this.o = paramOnScrollListener;
  }
  
  public void setPrestrainDataMode(boolean paramBoolean) {
    this.j = paramBoolean;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\RenrenPullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */