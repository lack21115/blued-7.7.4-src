package com.ethanhua.skeleton;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import io.supercharge.shimmerlayout.ShimmerLayout;

public class ViewSkeletonScreen implements SkeletonScreen {
  private static final String a = ViewSkeletonScreen.class.getName();
  
  private final ViewReplacer b;
  
  private final View c;
  
  private final int d;
  
  private final int e;
  
  private final boolean f;
  
  private final int g;
  
  private final int h;
  
  private ViewSkeletonScreen(Builder paramBuilder) {
    this.c = Builder.a(paramBuilder);
    this.d = Builder.b(paramBuilder);
    this.f = Builder.c(paramBuilder);
    this.g = Builder.d(paramBuilder);
    this.h = Builder.e(paramBuilder);
    this.e = Builder.f(paramBuilder);
    this.b = new ViewReplacer(Builder.a(paramBuilder));
  }
  
  private ShimmerLayout a(ViewGroup paramViewGroup) {
    ShimmerLayout shimmerLayout = (ShimmerLayout)LayoutInflater.from(this.c.getContext()).inflate(R.layout.layout_shimmer, paramViewGroup, false);
    shimmerLayout.setShimmerColor(this.e);
    shimmerLayout.setShimmerAngle(this.h);
    shimmerLayout.setShimmerAnimationDuration(this.g);
    View view = LayoutInflater.from(this.c.getContext()).inflate(this.d, (ViewGroup)shimmerLayout, false);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams != null)
      shimmerLayout.setLayoutParams(layoutParams); 
    shimmerLayout.addView(view);
    shimmerLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this, shimmerLayout) {
          public void onViewAttachedToWindow(View param1View) {
            this.a.a();
          }
          
          public void onViewDetachedFromWindow(View param1View) {
            this.a.b();
          }
        });
    shimmerLayout.a();
    return shimmerLayout;
  }
  
  private View c() {
    ViewParent viewParent = this.c.getParent();
    if (viewParent == null) {
      Log.e(a, "the source view have not attach to any view");
      return null;
    } 
    ViewGroup viewGroup = (ViewGroup)viewParent;
    return (View)(this.f ? a(viewGroup) : LayoutInflater.from(this.c.getContext()).inflate(this.d, viewGroup, false));
  }
  
  public void a() {
    if (this.b.b() instanceof ShimmerLayout)
      ((ShimmerLayout)this.b.b()).b(); 
    this.b.a();
  }
  
  public void b() {
    View view = c();
    if (view != null)
      this.b.a(view); 
  }
  
  public static class Builder {
    private final View a;
    
    private int b;
    
    private boolean c = true;
    
    private int d;
    
    private int e = 1000;
    
    private int f = 20;
    
    public Builder(View param1View) {
      this.a = param1View;
      this.d = ContextCompat.getColor(this.a.getContext(), R.color.shimmer_color);
    }
    
    public Builder a(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public ViewSkeletonScreen a() {
      ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(this);
      viewSkeletonScreen.b();
      return viewSkeletonScreen;
    }
    
    public Builder b(int param1Int) {
      this.d = ContextCompat.getColor(this.a.getContext(), param1Int);
      return this;
    }
    
    public Builder c(int param1Int) {
      this.e = param1Int;
      return this;
    }
    
    public Builder d(int param1Int) {
      this.f = param1Int;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\ethanhua\skeleton\ViewSkeletonScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */