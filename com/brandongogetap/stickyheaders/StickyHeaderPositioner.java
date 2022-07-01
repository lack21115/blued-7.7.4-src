package com.brandongogetap.stickyheaders;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class StickyHeaderPositioner {
  private final RecyclerView a;
  
  private final boolean b;
  
  private View c;
  
  private int d = -1;
  
  private List<Integer> e;
  
  private int f;
  
  private boolean g;
  
  private float h = -1.0F;
  
  private int i = -1;
  
  private RecyclerView.ViewHolder j;
  
  private StickyHeaderListener k;
  
  StickyHeaderPositioner(RecyclerView paramRecyclerView) {
    this.a = paramRecyclerView;
    paramRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            int i = StickyHeaderPositioner.a(this.a).getVisibility();
            if (StickyHeaderPositioner.b(this.a) != null)
              StickyHeaderPositioner.b(this.a).setVisibility(i); 
          }
        });
    this.b = i();
  }
  
  private float a(Context paramContext, int paramInt) {
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    return paramInt * f;
  }
  
  private float a(View paramView) {
    if (b(paramView)) {
      if (this.f == 1) {
        float f1 = -(this.c.getHeight() - paramView.getY());
        this.c.setTranslationY(f1);
        return f1;
      } 
      float f = -(this.c.getWidth() - paramView.getX());
      this.c.setTranslationX(f);
      return f;
    } 
    return -1.0F;
  }
  
  private int a(int paramInt, View paramView) {
    if (c(paramView)) {
      int j = this.e.indexOf(Integer.valueOf(paramInt));
      if (j > 0)
        return ((Integer)this.e.get(j - 1)).intValue(); 
    } 
    Iterator<Integer> iterator = this.e.iterator();
    int i = -1;
    while (iterator.hasNext()) {
      Integer integer = iterator.next();
      if (integer.intValue() <= paramInt)
        i = integer.intValue(); 
    } 
    return i;
  }
  
  private void a(Context paramContext) {
    int i = this.i;
    if (i != -1 && this.h == -1.0F)
      this.h = a(paramContext, i); 
  }
  
  private void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
    boolean bool1;
    int i;
    boolean bool2;
    if (this.f == 1) {
      bool1 = this.a.getPaddingLeft();
    } else {
      bool1 = false;
    } 
    if (this.f == 1) {
      i = 0;
    } else {
      i = this.a.getPaddingTop();
    } 
    if (this.f == 1) {
      bool2 = this.a.getPaddingRight();
    } else {
      bool2 = false;
    } 
    paramMarginLayoutParams.setMargins(bool1, i, bool2, 0);
  }
  
  private void b() {
    if (this.f == 1) {
      this.c.setTranslationY(0.0F);
      return;
    } 
    this.c.setTranslationX(0.0F);
  }
  
  private void b(Map<Integer, View> paramMap) {
    View view = this.c;
    if (view == null)
      return; 
    view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, view, paramMap) {
          public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 16) {
              this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
              this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } 
            if (StickyHeaderPositioner.b(this.c) == null)
              return; 
            StickyHeaderPositioner.f(this.c).requestLayout();
            this.c.a(this.b);
          }
        });
  }
  
  private boolean b(View paramView) {
    int i = this.f;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 1) {
      if (paramView.getY() < this.c.getHeight())
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (paramView.getX() < this.c.getWidth())
      bool1 = true; 
    return bool1;
  }
  
  private int c() {
    View view = this.c;
    return (view == null) ? 0 : ((this.f == 1) ? view.getHeight() : view.getWidth());
  }
  
  private void c(int paramInt) {
    View view = this.c;
    if (view == null)
      return; 
    if (this.f == 1) {
      view.setTranslationY(view.getTranslationY() + paramInt);
      return;
    } 
    view.setTranslationX(view.getTranslationX() + paramInt);
  }
  
  private boolean c(View paramView) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
      if (this.f == 1) {
        bool1 = bool2;
        if (paramView.getY() > 0.0F)
          return true; 
      } else {
        bool1 = bool2;
        if (paramView.getX() > 0.0F)
          return true; 
      }  
    return bool1;
  }
  
  private void d(int paramInt) {
    if (this.c != null) {
      j().removeView(this.c);
      f(paramInt);
      this.c = null;
      this.j = null;
    } 
  }
  
  private void d(View paramView) {
    a((ViewGroup.MarginLayoutParams)paramView.getLayoutParams());
  }
  
  private boolean d() {
    View view = this.c;
    boolean bool2 = false;
    boolean bool1 = false;
    if (view == null)
      return false; 
    if (this.f == 1) {
      if (view.getTranslationY() < 0.0F)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (view.getTranslationX() < 0.0F)
      bool1 = true; 
    return bool1;
  }
  
  private void e() {
    View view = this.c;
    if (view == null)
      return; 
    view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, view) {
          int a = StickyHeaderPositioner.d(this.c);
          
          public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT >= 16) {
              this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
              this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } 
            if (StickyHeaderPositioner.b(this.c) == null)
              return; 
            int i = StickyHeaderPositioner.d(this.c);
            if (StickyHeaderPositioner.e(this.c)) {
              int j = this.a;
              if (j != i)
                StickyHeaderPositioner.a(this.c, j - i); 
            } 
          }
        });
  }
  
  private void e(int paramInt) {
    StickyHeaderListener stickyHeaderListener = this.k;
    if (stickyHeaderListener != null)
      stickyHeaderListener.a(this.c, paramInt); 
  }
  
  private boolean e(View paramView) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
      if (this.f == 1) {
        bool1 = bool2;
        if (paramView.getY() > 0.0F)
          return true; 
      } else {
        bool1 = bool2;
        if (paramView.getX() > 0.0F)
          return true; 
      }  
    return bool1;
  }
  
  private void f() {
    if (this.h != -1.0F) {
      View view = this.c;
      if (view != null) {
        if ((this.f == 1 && view.getTranslationY() == 0.0F) || (this.f == 0 && this.c.getTranslationX() == 0.0F)) {
          g();
          return;
        } 
        h();
      } 
    } 
  }
  
  private void f(int paramInt) {
    StickyHeaderListener stickyHeaderListener = this.k;
    if (stickyHeaderListener != null)
      stickyHeaderListener.b(this.c, paramInt); 
  }
  
  private void g() {
    if (Build.VERSION.SDK_INT >= 21) {
      if (this.c.getTag() != null)
        return; 
      this.c.setTag(Boolean.valueOf(true));
      this.c.animate().z(this.h);
    } 
  }
  
  private void h() {
    if (Build.VERSION.SDK_INT >= 21 && this.c.getTag() != null) {
      this.c.setTag(null);
      this.c.animate().z(0.0F);
    } 
  }
  
  private boolean i() {
    return (this.a.getPaddingLeft() > 0 || this.a.getPaddingRight() > 0 || this.a.getPaddingTop() > 0);
  }
  
  private ViewGroup j() {
    return (ViewGroup)this.a.getParent();
  }
  
  private void k() {
    int i = this.d;
    j().post(new Runnable(this, i) {
          public void run() {
            if (StickyHeaderPositioner.g(this.b))
              StickyHeaderPositioner.b(this.b, this.a); 
          }
        });
  }
  
  void a() {
    d(this.d);
  }
  
  void a(int paramInt) {
    if (paramInt != -1) {
      this.i = paramInt;
      return;
    } 
    this.h = -1.0F;
    this.i = -1;
  }
  
  void a(int paramInt, Map<Integer, View> paramMap, ViewRetriever paramViewRetriever, boolean paramBoolean) {
    if (paramBoolean) {
      paramInt = -1;
    } else {
      paramInt = a(paramInt, paramMap.get(Integer.valueOf(paramInt)));
    } 
    View view = paramMap.get(Integer.valueOf(paramInt));
    if (paramInt != this.d) {
      if (paramInt == -1 || (this.b && e(view))) {
        this.g = true;
        k();
        this.d = -1;
      } else {
        this.d = paramInt;
        a(paramViewRetriever.a(paramInt), paramInt);
      } 
    } else if (this.b && e(view)) {
      d(this.d);
      this.d = -1;
    } 
    a(paramMap);
    this.a.post(new Runnable(this) {
          public void run() {
            StickyHeaderPositioner.c(this.a);
          }
        });
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if (this.j == paramViewHolder) {
      f(this.d);
      this.a.getAdapter().onBindViewHolder(this.j, paramInt);
      this.j.itemView.requestLayout();
      e();
      e(paramInt);
      this.g = false;
      return;
    } 
    d(this.d);
    this.j = paramViewHolder;
    this.a.getAdapter().onBindViewHolder(this.j, paramInt);
    this.c = this.j.itemView;
    e(paramInt);
    a(this.c.getContext());
    this.c.setVisibility(4);
    this.c.setId(R.id.header_view);
    j().addView(this.c);
    if (this.b)
      d(this.c); 
    this.g = false;
  }
  
  void a(StickyHeaderListener paramStickyHeaderListener) {
    this.k = paramStickyHeaderListener;
  }
  
  void a(List<Integer> paramList) {
    this.e = paramList;
  }
  
  void a(Map<Integer, View> paramMap) {
    boolean bool;
    View view = this.c;
    if (view == null)
      return; 
    if (view.getHeight() == 0) {
      b(paramMap);
      return;
    } 
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (true) {
      boolean bool2 = iterator.hasNext();
      boolean bool1 = true;
      bool = bool1;
      if (bool2) {
        Map.Entry entry = iterator.next();
        if (((Integer)entry.getKey()).intValue() <= this.d)
          continue; 
        if (a((View)entry.getValue()) == -1.0F) {
          bool = bool1;
          break;
        } 
        bool = false;
      } 
      break;
    } 
    if (bool)
      b(); 
    this.c.setVisibility(0);
  }
  
  void b(int paramInt) {
    this.f = paramInt;
    this.d = -1;
    this.g = true;
    k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\brandongogetap\stickyheaders\StickyHeaderPositioner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */