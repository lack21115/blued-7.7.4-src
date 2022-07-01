package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.soft.blued.ui.feed.fragment.PhotosRefreshObserver;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewsFeedDragGridView extends GridView implements PhotosRefreshObserver.IPhotosRefreshObserver {
  private int A;
  
  private ChildImageInfo B = new ChildImageInfo();
  
  private List<ChildImageInfo> C = new ArrayList<ChildImageInfo>();
  
  private Handler D = new Handler();
  
  private Runnable E = new Runnable(this) {
      public void run() {
        NewsFeedDragGridView.a(this.a, true);
        NewsFeedDragGridView.a(this.a).vibrate(50L);
        NewsFeedDragGridView.b(this.a).setVisibility(4);
        NewsFeedDragGridView newsFeedDragGridView = this.a;
        NewsFeedDragGridView.a(newsFeedDragGridView, NewsFeedDragGridView.c(newsFeedDragGridView), NewsFeedDragGridView.d(this.a), NewsFeedDragGridView.e(this.a));
      }
    };
  
  private Runnable F = new Runnable(this) {
      public void run() {
        boolean bool;
        if (this.a.getFirstVisiblePosition() == 0 || this.a.getLastVisiblePosition() == this.a.getCount() - 1)
          NewsFeedDragGridView.g(this.a).removeCallbacks(NewsFeedDragGridView.f(this.a)); 
        if (NewsFeedDragGridView.h(this.a) > NewsFeedDragGridView.i(this.a)) {
          bool = true;
          NewsFeedDragGridView.g(this.a).postDelayed(NewsFeedDragGridView.f(this.a), 25L);
        } else if (NewsFeedDragGridView.h(this.a) < NewsFeedDragGridView.j(this.a)) {
          bool = true;
          NewsFeedDragGridView.g(this.a).postDelayed(NewsFeedDragGridView.f(this.a), 25L);
        } else {
          bool = false;
          NewsFeedDragGridView.g(this.a).removeCallbacks(NewsFeedDragGridView.f(this.a));
        } 
        this.a.smoothScrollBy(bool, 10);
      }
    };
  
  private long a = 500L;
  
  private boolean b = false;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private boolean g = true;
  
  private int h;
  
  private View i = null;
  
  private ImageView j;
  
  private Vibrator k;
  
  private WindowManager l;
  
  private WindowManager.LayoutParams m;
  
  private Bitmap n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private int u;
  
  private boolean v = true;
  
  private DragGridBaseAdapter w;
  
  private int x;
  
  private int y;
  
  private boolean z;
  
  public NewsFeedDragGridView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NewsFeedDragGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = (Vibrator)paramContext.getSystemService("vibrator");
    this.l = (WindowManager)paramContext.getSystemService("window");
    this.s = a(paramContext);
    if (!this.z)
      this.x = -1; 
    b();
  }
  
  private static int a(Context paramContext) {
    Rect rect = new Rect();
    ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
    int i = rect.top;
    if (i == 0)
      try {
        Class<?> clazz = Class.forName("com.android.internal.R$dimen");
        Object object = clazz.newInstance();
        null = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
        return paramContext.getResources().getDimensionPixelSize(null);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return i;
  }
  
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(new Animator[] { (Animator)objectAnimator2, (Animator)objectAnimator1 });
    return animatorSet;
  }
  
  private void a(int paramInt1, int paramInt2) {
    WindowManager.LayoutParams layoutParams = this.m;
    layoutParams.x = paramInt1 - this.p + this.r;
    layoutParams.y = paramInt2 - this.o + this.q - this.s;
    this.l.updateViewLayout((View)this.j, (ViewGroup.LayoutParams)layoutParams);
    b(paramInt1, paramInt2);
    this.D.post(this.F);
  }
  
  private void a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    this.m = new WindowManager.LayoutParams();
    WindowManager.LayoutParams layoutParams = this.m;
    layoutParams.format = -3;
    layoutParams.gravity = 51;
    layoutParams.x = paramInt1 - this.p + this.r;
    layoutParams.y = paramInt2 - this.o + this.q - this.s;
    layoutParams.alpha = 0.55F;
    layoutParams.width = -2;
    layoutParams.height = -2;
    layoutParams.flags = 24;
    this.j = new ImageView(getContext());
    this.j.setImageBitmap(paramBitmap);
    this.l.addView((View)this.j, (ViewGroup.LayoutParams)this.m);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2) {
    if (paramView == null)
      return false; 
    int i = paramView.getLeft();
    int j = paramView.getTop();
    if (paramInt1 > i) {
      if (paramInt1 >= i + paramView.getWidth())
        return false; 
      if (paramInt2 > j)
        return !(paramInt2 >= j + paramView.getHeight()); 
    } 
    return false;
  }
  
  private void b() {
    this.C.clear();
    this.C.addAll(SelectPhotoManager.a().c());
    if (this.C.size() < 9) {
      ChildImageInfo childImageInfo = this.B;
      childImageInfo.mImagePath = null;
      this.C.add(childImageInfo);
    } 
  }
  
  private void b(int paramInt1, int paramInt2) {
    paramInt1 = pointToPosition(paramInt1, paramInt2);
    if (paramInt1 != this.h && paramInt1 != -1 && this.v && !StringUtils.e(((ChildImageInfo)this.C.get(paramInt1)).mImagePath)) {
      this.w.a(this.h, paramInt1);
      this.w.a(paramInt1);
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this, viewTreeObserver, paramInt1) {
            public boolean onPreDraw() {
              this.a.removeOnPreDrawListener(this);
              if (Build.VERSION.SDK_INT > 11) {
                NewsFeedDragGridView newsFeedDragGridView = this.c;
                NewsFeedDragGridView.a(newsFeedDragGridView, NewsFeedDragGridView.k(newsFeedDragGridView), this.b);
              } 
              NewsFeedDragGridView.a(this.c, this.b);
              return true;
            }
          });
    } 
  }
  
  private void c() {
    ImageView imageView = this.j;
    if (imageView != null) {
      this.l.removeView((View)imageView);
      this.j = null;
    } 
  }
  
  private void c(int paramInt1, int paramInt2) {
    boolean bool;
    if (paramInt2 > paramInt1) {
      bool = true;
    } else {
      bool = false;
    } 
    LinkedList<AnimatorSet> linkedList = new LinkedList();
    int i = paramInt1;
    if (bool) {
      while (paramInt1 < paramInt2) {
        View view = getChildAt(paramInt1 - getFirstVisiblePosition());
        System.out.println(paramInt1);
        if (++paramInt1 % this.x == 0) {
          linkedList.add(a(view, (-view.getWidth() * (this.x - 1)), 0.0F, view.getHeight(), 0.0F));
          continue;
        } 
        linkedList.add(a(view, view.getWidth(), 0.0F, 0.0F, 0.0F));
      } 
    } else {
      while (i > paramInt2) {
        View view = getChildAt(i - getFirstVisiblePosition());
        paramInt1 = this.x;
        if ((i + paramInt1) % paramInt1 == 0) {
          linkedList.add(a(view, (view.getWidth() * (this.x - 1)), 0.0F, -view.getHeight(), 0.0F));
        } else {
          linkedList.add(a(view, -view.getWidth(), 0.0F, 0.0F, 0.0F));
        } 
        i--;
      } 
    } 
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(linkedList);
    animatorSet.setDuration(300L);
    animatorSet.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            NewsFeedDragGridView.b(this.a, true);
          }
          
          public void onAnimationStart(Animator param1Animator) {
            NewsFeedDragGridView.b(this.a, false);
          }
        });
    animatorSet.start();
  }
  
  private void d() {
    View view = getChildAt(this.h - getFirstVisiblePosition());
    if (view != null)
      view.setVisibility(0); 
    this.w.a(-1);
    c();
  }
  
  public void a() {
    b();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            getParent().requestDisallowInterceptTouchEvent(false); 
        } else if (this.g) {
          i = (int)paramMotionEvent.getX();
          int j = (int)paramMotionEvent.getY();
          if (!a(this.i, i, j))
            this.D.removeCallbacks(this.E); 
        } 
      } else if (this.g) {
        this.D.removeCallbacks(this.E);
        this.D.removeCallbacks(this.F);
        onTouchEvent(paramMotionEvent);
      } 
    } else if (this.g) {
      getParent().requestDisallowInterceptTouchEvent(true);
      this.c = (int)paramMotionEvent.getX();
      this.d = (int)paramMotionEvent.getY();
      this.h = pointToPosition(this.c, this.d);
      try {
        if (this.h != -1) {
          boolean bool = StringUtils.e(((ChildImageInfo)this.C.get(this.h)).mImagePath);
          if (bool)
            return super.dispatchTouchEvent(paramMotionEvent); 
          this.D.postDelayed(this.E, this.a);
          this.i = getChildAt(this.h - getFirstVisiblePosition());
          this.o = this.d - this.i.getTop();
          this.p = this.c - this.i.getLeft();
          this.q = (int)(paramMotionEvent.getRawY() - this.d);
          this.r = (int)(paramMotionEvent.getRawX() - this.c);
          this.t = getHeight() / 5;
          this.u = getHeight() * 4 / 5;
          this.i.setDrawingCacheEnabled(true);
          this.n = Bitmap.createBitmap(this.i.getDrawingCache());
          this.i.destroyDrawingCache();
        } else {
          return super.dispatchTouchEvent(paramMotionEvent);
        } 
        return super.dispatchTouchEvent(paramMotionEvent);
      } catch (Exception exception) {
        return super.dispatchTouchEvent(paramMotionEvent);
      } 
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    PhotosRefreshObserver.a().a(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    PhotosRefreshObserver.a().b(this);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.x == -1) {
      byte b;
      if (this.y > 0) {
        int i = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        paramInt2 = i / this.y;
        if (paramInt2 > 0) {
          while (true) {
            b = paramInt2;
            if (paramInt2 != 1) {
              b = paramInt2;
              if (this.y * paramInt2 + (paramInt2 - 1) * this.A > i) {
                paramInt2--;
                continue;
              } 
            } 
            break;
          } 
        } else {
          b = 1;
        } 
      } else {
        b = 2;
      } 
      this.x = b;
    } 
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (this.g && this.b && this.j != null) {
        int i = paramMotionEvent.getAction();
        if (i != 1) {
          if (i != 2)
            return true; 
          this.e = (int)paramMotionEvent.getX();
          this.f = (int)paramMotionEvent.getY();
          a(this.e, this.f);
          return true;
        } 
        d();
        this.b = false;
        return true;
      } 
    } catch (Exception exception) {}
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    super.setAdapter(paramListAdapter);
    if (paramListAdapter instanceof DragGridBaseAdapter) {
      this.w = (DragGridBaseAdapter)paramListAdapter;
      return;
    } 
    throw new IllegalStateException("the adapter must be implements DragGridAdapter");
  }
  
  public void setColumnWidth(int paramInt) {
    super.setColumnWidth(paramInt);
    this.y = paramInt;
  }
  
  public void setDragResponseMS(long paramLong) {
    this.a = paramLong;
  }
  
  public void setDragable(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void setHorizontalSpacing(int paramInt) {
    super.setHorizontalSpacing(paramInt);
    this.A = paramInt;
  }
  
  public void setNumColumns(int paramInt) {
    super.setNumColumns(paramInt);
    this.z = true;
    this.x = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\NewsFeedDragGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */