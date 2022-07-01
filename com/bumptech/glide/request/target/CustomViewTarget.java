package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
  private static final int b = R.id.glide_custom_view_target_tag;
  
  protected final T a;
  
  private final SizeDeterminer c;
  
  private View.OnAttachStateChangeListener d;
  
  private boolean e;
  
  private boolean f;
  
  public CustomViewTarget(T paramT) {
    this.a = (T)Preconditions.a(paramT);
    this.c = new SizeDeterminer((View)paramT);
  }
  
  private void a(Object paramObject) {
    this.a.setTag(b, paramObject);
  }
  
  private Object g() {
    return this.a.getTag(b);
  }
  
  private void h() {
    View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
    if (onAttachStateChangeListener != null) {
      if (this.f)
        return; 
      this.a.addOnAttachStateChangeListener(onAttachStateChangeListener);
      this.f = true;
    } 
  }
  
  private void i() {
    View.OnAttachStateChangeListener onAttachStateChangeListener = this.d;
    if (onAttachStateChangeListener != null) {
      if (!this.f)
        return; 
      this.a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
      this.f = false;
    } 
  }
  
  public final Request a() {
    Object object = g();
    if (object != null) {
      if (object instanceof Request)
        return (Request)object; 
      throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    } 
    return null;
  }
  
  public final void a(Drawable paramDrawable) {
    h();
    e(paramDrawable);
  }
  
  public final void a(Request paramRequest) {
    a(paramRequest);
  }
  
  public final void a(SizeReadyCallback paramSizeReadyCallback) {
    this.c.a(paramSizeReadyCallback);
  }
  
  public final void b(SizeReadyCallback paramSizeReadyCallback) {
    this.c.b(paramSizeReadyCallback);
  }
  
  public final void c(Drawable paramDrawable) {
    this.c.b();
    d(paramDrawable);
    if (!this.e)
      i(); 
  }
  
  protected abstract void d(Drawable paramDrawable);
  
  final void e() {
    Request request = a();
    if (request != null && request.f())
      request.a(); 
  }
  
  protected void e(Drawable paramDrawable) {}
  
  final void f() {
    Request request = a();
    if (request != null) {
      this.e = true;
      request.b();
      this.e = false;
    } 
  }
  
  public void o_() {}
  
  public void p_() {}
  
  public void q_() {}
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Target for: ");
    stringBuilder.append(this.a);
    return stringBuilder.toString();
  }
  
  static final class SizeDeterminer {
    static Integer a;
    
    boolean b;
    
    private final View c;
    
    private final List<SizeReadyCallback> d = new ArrayList<SizeReadyCallback>();
    
    private SizeDeterminerLayoutListener e;
    
    SizeDeterminer(View param1View) {
      this.c = param1View;
    }
    
    private int a(int param1Int1, int param1Int2, int param1Int3) {
      int i = param1Int2 - param1Int3;
      if (i > 0)
        return i; 
      if (this.b && this.c.isLayoutRequested())
        return 0; 
      param1Int1 -= param1Int3;
      if (param1Int1 > 0)
        return param1Int1; 
      if (!this.c.isLayoutRequested() && param1Int2 == -2) {
        if (Log.isLoggable("CustomViewTarget", 4))
          Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions."); 
        return a(this.c.getContext());
      } 
      return 0;
    }
    
    private static int a(Context param1Context) {
      if (a == null) {
        Display display = ((WindowManager)Preconditions.a(param1Context.getSystemService("window"))).getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        a = Integer.valueOf(Math.max(point.x, point.y));
      } 
      return a.intValue();
    }
    
    private void a(int param1Int1, int param1Int2) {
      Iterator<?> iterator = (new ArrayList(this.d)).iterator();
      while (iterator.hasNext())
        ((SizeReadyCallback)iterator.next()).a(param1Int1, param1Int2); 
    }
    
    private boolean a(int param1Int) {
      return (param1Int > 0 || param1Int == Integer.MIN_VALUE);
    }
    
    private boolean b(int param1Int1, int param1Int2) {
      return (a(param1Int1) && a(param1Int2));
    }
    
    private int c() {
      boolean bool;
      int i = this.c.getPaddingTop();
      int j = this.c.getPaddingBottom();
      ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
      if (layoutParams != null) {
        bool = layoutParams.height;
      } else {
        bool = false;
      } 
      return a(this.c.getHeight(), bool, i + j);
    }
    
    private int d() {
      boolean bool;
      int i = this.c.getPaddingLeft();
      int j = this.c.getPaddingRight();
      ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
      if (layoutParams != null) {
        bool = layoutParams.width;
      } else {
        bool = false;
      } 
      return a(this.c.getWidth(), bool, i + j);
    }
    
    void a() {
      if (this.d.isEmpty())
        return; 
      int i = d();
      int j = c();
      if (!b(i, j))
        return; 
      a(i, j);
      b();
    }
    
    void a(SizeReadyCallback param1SizeReadyCallback) {
      int i = d();
      int j = c();
      if (b(i, j)) {
        param1SizeReadyCallback.a(i, j);
        return;
      } 
      if (!this.d.contains(param1SizeReadyCallback))
        this.d.add(param1SizeReadyCallback); 
      if (this.e == null) {
        ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
        this.e = new SizeDeterminerLayoutListener(this);
        viewTreeObserver.addOnPreDrawListener(this.e);
      } 
    }
    
    void b() {
      ViewTreeObserver viewTreeObserver = this.c.getViewTreeObserver();
      if (viewTreeObserver.isAlive())
        viewTreeObserver.removeOnPreDrawListener(this.e); 
      this.e = null;
      this.d.clear();
    }
    
    void b(SizeReadyCallback param1SizeReadyCallback) {
      this.d.remove(param1SizeReadyCallback);
    }
    
    static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
      private final WeakReference<CustomViewTarget.SizeDeterminer> a;
      
      SizeDeterminerLayoutListener(CustomViewTarget.SizeDeterminer param2SizeDeterminer) {
        this.a = new WeakReference<CustomViewTarget.SizeDeterminer>(param2SizeDeterminer);
      }
      
      public boolean onPreDraw() {
        if (Log.isLoggable("CustomViewTarget", 2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
          stringBuilder.append(this);
          Log.v("CustomViewTarget", stringBuilder.toString());
        } 
        CustomViewTarget.SizeDeterminer sizeDeterminer = this.a.get();
        if (sizeDeterminer != null)
          sizeDeterminer.a(); 
        return true;
      }
    }
  }
  
  static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference<CustomViewTarget.SizeDeterminer> a;
    
    SizeDeterminerLayoutListener(CustomViewTarget.SizeDeterminer param1SizeDeterminer) {
      this.a = new WeakReference<CustomViewTarget.SizeDeterminer>(param1SizeDeterminer);
    }
    
    public boolean onPreDraw() {
      if (Log.isLoggable("CustomViewTarget", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
        stringBuilder.append(this);
        Log.v("CustomViewTarget", stringBuilder.toString());
      } 
      CustomViewTarget.SizeDeterminer sizeDeterminer = this.a.get();
      if (sizeDeterminer != null)
        sizeDeterminer.a(); 
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\CustomViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */