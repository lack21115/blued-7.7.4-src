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

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
  private static boolean b;
  
  private static int c = R.id.glide_custom_view_target_tag;
  
  protected final T a;
  
  private final SizeDeterminer d;
  
  private View.OnAttachStateChangeListener e;
  
  private boolean f;
  
  private boolean g;
  
  public ViewTarget(T paramT) {
    this.a = (T)Preconditions.a(paramT);
    this.d = new SizeDeterminer((View)paramT);
  }
  
  private void a(Object paramObject) {
    b = true;
    this.a.setTag(c, paramObject);
  }
  
  private void i() {
    View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
    if (onAttachStateChangeListener != null) {
      if (this.g)
        return; 
      this.a.addOnAttachStateChangeListener(onAttachStateChangeListener);
      this.g = true;
    } 
  }
  
  private void j() {
    View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
    if (onAttachStateChangeListener != null) {
      if (!this.g)
        return; 
      this.a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
      this.g = false;
    } 
  }
  
  private Object k() {
    return this.a.getTag(c);
  }
  
  public Request a() {
    Object object = k();
    if (object != null) {
      if (object instanceof Request)
        return (Request)object; 
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    } 
    return null;
  }
  
  public void a(Drawable paramDrawable) {
    super.a(paramDrawable);
    i();
  }
  
  public void a(Request paramRequest) {
    a(paramRequest);
  }
  
  public void a(SizeReadyCallback paramSizeReadyCallback) {
    this.d.a(paramSizeReadyCallback);
  }
  
  public void b(SizeReadyCallback paramSizeReadyCallback) {
    this.d.b(paramSizeReadyCallback);
  }
  
  public void c(Drawable paramDrawable) {
    super.c(paramDrawable);
    this.d.b();
    if (!this.f)
      j(); 
  }
  
  void f() {
    Request request = a();
    if (request != null && request.f())
      request.a(); 
  }
  
  void g() {
    Request request = a();
    if (request != null) {
      this.f = true;
      request.b();
      this.f = false;
    } 
  }
  
  public T h() {
    return this.a;
  }
  
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
        if (Log.isLoggable("ViewTarget", 4))
          Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions."); 
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
      private final WeakReference<ViewTarget.SizeDeterminer> a;
      
      SizeDeterminerLayoutListener(ViewTarget.SizeDeterminer param2SizeDeterminer) {
        this.a = new WeakReference<ViewTarget.SizeDeterminer>(param2SizeDeterminer);
      }
      
      public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
          stringBuilder.append(this);
          Log.v("ViewTarget", stringBuilder.toString());
        } 
        ViewTarget.SizeDeterminer sizeDeterminer = this.a.get();
        if (sizeDeterminer != null)
          sizeDeterminer.a(); 
        return true;
      }
    }
  }
  
  static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference<ViewTarget.SizeDeterminer> a;
    
    SizeDeterminerLayoutListener(ViewTarget.SizeDeterminer param1SizeDeterminer) {
      this.a = new WeakReference<ViewTarget.SizeDeterminer>(param1SizeDeterminer);
    }
    
    public boolean onPreDraw() {
      if (Log.isLoggable("ViewTarget", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnGlobalLayoutListener called attachStateListener=");
        stringBuilder.append(this);
        Log.v("ViewTarget", stringBuilder.toString());
      } 
      ViewTarget.SizeDeterminer sizeDeterminer = this.a.get();
      if (sizeDeterminer != null)
        sizeDeterminer.a(); 
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\ViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */