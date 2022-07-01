package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {
  private final int a;
  
  private final PreloadTargetQueue b;
  
  private final RequestManager c;
  
  private final PreloadModelProvider<T> d;
  
  private final PreloadSizeProvider<T> e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private boolean j;
  
  private void a() {
    for (int i = 0; i < this.b.a.size(); i++)
      this.c.a(this.b.a(0, 0)); 
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (paramInt1 < paramInt2) {
      i = Math.max(this.f, paramInt1);
      j = paramInt2;
    } else {
      j = Math.min(this.g, paramInt1);
      i = paramInt2;
    } 
    int j = Math.min(this.i, j);
    int i = Math.min(this.i, Math.max(0, i));
    if (paramInt1 < paramInt2) {
      for (paramInt1 = i; paramInt1 < j; paramInt1++)
        a(this.d.a(paramInt1), paramInt1, true); 
    } else {
      for (paramInt1 = j - 1; paramInt1 >= i; paramInt1--)
        a(this.d.a(paramInt1), paramInt1, false); 
    } 
    this.g = i;
    this.f = j;
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    int i;
    if (this.j != paramBoolean) {
      this.j = paramBoolean;
      a();
    } 
    if (paramBoolean) {
      i = this.a;
    } else {
      i = -this.a;
    } 
    a(paramInt, i + paramInt);
  }
  
  private void a(T paramT, int paramInt1, int paramInt2) {
    if (paramT == null)
      return; 
    int[] arrayOfInt = this.e.a(paramT, paramInt1, paramInt2);
    if (arrayOfInt == null)
      return; 
    RequestBuilder<?> requestBuilder = this.d.a(paramT);
    if (requestBuilder == null)
      return; 
    requestBuilder.a(this.b.a(arrayOfInt[0], arrayOfInt[1]));
  }
  
  private void a(List<T> paramList, int paramInt, boolean paramBoolean) {
    int i = paramList.size();
    if (paramBoolean) {
      int j;
      for (j = 0; j < i; j++)
        a(paramList.get(j), paramInt, j); 
    } else {
      int j;
      for (j = i - 1; j >= 0; j--)
        a(paramList.get(j), paramInt, j); 
    } 
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    this.i = paramInt3;
    paramInt3 = this.h;
    if (paramInt1 > paramInt3) {
      a(paramInt2 + paramInt1, true);
    } else if (paramInt1 < paramInt3) {
      a(paramInt1, false);
    } 
    this.h = paramInt1;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public static interface PreloadModelProvider<U> {
    RequestBuilder<?> a(U param1U);
    
    List<U> a(int param1Int);
  }
  
  public static interface PreloadSizeProvider<T> {
    int[] a(T param1T, int param1Int1, int param1Int2);
  }
  
  static final class PreloadTarget implements Target<Object> {
    int a;
    
    int b;
    
    private Request c;
    
    public Request a() {
      return this.c;
    }
    
    public void a(Drawable param1Drawable) {}
    
    public void a(Request param1Request) {
      this.c = param1Request;
    }
    
    public void a(SizeReadyCallback param1SizeReadyCallback) {
      param1SizeReadyCallback.a(this.b, this.a);
    }
    
    public void a(Object param1Object, Transition<? super Object> param1Transition) {}
    
    public void b(Drawable param1Drawable) {}
    
    public void b(SizeReadyCallback param1SizeReadyCallback) {}
    
    public void c(Drawable param1Drawable) {}
    
    public void o_() {}
    
    public void p_() {}
    
    public void q_() {}
  }
  
  static final class PreloadTargetQueue {
    final Queue<ListPreloader.PreloadTarget> a;
    
    public ListPreloader.PreloadTarget a(int param1Int1, int param1Int2) {
      ListPreloader.PreloadTarget preloadTarget = this.a.poll();
      this.a.offer(preloadTarget);
      preloadTarget.b = param1Int1;
      preloadTarget.a = param1Int2;
      return preloadTarget;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\ListPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */