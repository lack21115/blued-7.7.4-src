package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {
  protected OverlayViewGroup a;
  
  ViewOverlayApi14(Context paramContext, ViewGroup paramViewGroup, View paramView) {
    this.a = new OverlayViewGroup(paramContext, paramViewGroup, paramView, this);
  }
  
  static ViewOverlayApi14 a(View paramView) {
    ViewGroup viewGroup = ViewUtils.f(paramView);
    if (viewGroup != null) {
      int j = viewGroup.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = viewGroup.getChildAt(i);
        if (view instanceof OverlayViewGroup)
          return ((OverlayViewGroup)view).e; 
      } 
      return new ViewGroupOverlayApi14(viewGroup.getContext(), viewGroup, paramView);
    } 
    return null;
  }
  
  public void a(Drawable paramDrawable) {
    this.a.a(paramDrawable);
  }
  
  public void b(Drawable paramDrawable) {
    this.a.b(paramDrawable);
  }
  
  static class OverlayViewGroup extends ViewGroup {
    static Method a;
    
    ViewGroup b;
    
    View c;
    
    ArrayList<Drawable> d = null;
    
    ViewOverlayApi14 e;
    
    private boolean f;
    
    static {
      try {
        a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", new Class[] { int.class, int.class, Rect.class });
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        return;
      } 
    }
    
    OverlayViewGroup(Context param1Context, ViewGroup param1ViewGroup, View param1View, ViewOverlayApi14 param1ViewOverlayApi14) {
      super(param1Context);
      this.b = param1ViewGroup;
      this.c = param1View;
      setRight(param1ViewGroup.getWidth());
      setBottom(param1ViewGroup.getHeight());
      param1ViewGroup.addView((View)this);
      this.e = param1ViewOverlayApi14;
    }
    
    private void a() {
      if (!this.f)
        return; 
      throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
    }
    
    private void a(int[] param1ArrayOfint) {
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      param1ArrayOfint[0] = arrayOfInt2[0] - arrayOfInt1[0];
      param1ArrayOfint[1] = arrayOfInt2[1] - arrayOfInt1[1];
    }
    
    private void b() {
      if (getChildCount() == 0) {
        ArrayList<Drawable> arrayList = this.d;
        if (arrayList == null || arrayList.size() == 0) {
          this.f = true;
          this.b.removeView((View)this);
        } 
      } 
    }
    
    public void a(Drawable param1Drawable) {
      a();
      if (this.d == null)
        this.d = new ArrayList<Drawable>(); 
      if (!this.d.contains(param1Drawable)) {
        this.d.add(param1Drawable);
        invalidate(param1Drawable.getBounds());
        param1Drawable.setCallback((Drawable.Callback)this);
      } 
    }
    
    public void b(Drawable param1Drawable) {
      ArrayList<Drawable> arrayList = this.d;
      if (arrayList != null) {
        arrayList.remove(param1Drawable);
        invalidate(param1Drawable.getBounds());
        param1Drawable.setCallback(null);
        b();
      } 
    }
    
    protected void dispatchDraw(Canvas param1Canvas) {
      int i;
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      this.b.getLocationOnScreen(arrayOfInt1);
      this.c.getLocationOnScreen(arrayOfInt2);
      int j = 0;
      param1Canvas.translate((arrayOfInt2[0] - arrayOfInt1[0]), (arrayOfInt2[1] - arrayOfInt1[1]));
      param1Canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
      super.dispatchDraw(param1Canvas);
      ArrayList<Drawable> arrayList = this.d;
      if (arrayList == null) {
        i = 0;
      } else {
        i = arrayList.size();
      } 
      while (j < i) {
        ((Drawable)this.d.get(j)).draw(param1Canvas);
        j++;
      } 
    }
    
    public boolean dispatchTouchEvent(MotionEvent param1MotionEvent) {
      return false;
    }
    
    public ViewParent invalidateChildInParent(int[] param1ArrayOfint, Rect param1Rect) {
      if (this.b != null) {
        param1Rect.offset(param1ArrayOfint[0], param1ArrayOfint[1]);
        if (this.b != null) {
          param1ArrayOfint[0] = 0;
          param1ArrayOfint[1] = 0;
          int[] arrayOfInt = new int[2];
          a(arrayOfInt);
          param1Rect.offset(arrayOfInt[0], arrayOfInt[1]);
          return super.invalidateChildInParent(param1ArrayOfint, param1Rect);
        } 
        invalidate(param1Rect);
      } 
      return null;
    }
    
    public void invalidateDrawable(Drawable param1Drawable) {
      invalidate(param1Drawable.getBounds());
    }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    protected boolean verifyDrawable(Drawable param1Drawable) {
      if (!super.verifyDrawable(param1Drawable)) {
        ArrayList<Drawable> arrayList = this.d;
        if (arrayList == null || !arrayList.contains(param1Drawable))
          return false; 
      } 
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ViewOverlayApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */