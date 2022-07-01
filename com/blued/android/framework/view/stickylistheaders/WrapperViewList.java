package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class WrapperViewList extends ListView {
  private LifeCycleListener a;
  
  private List<View> b;
  
  private int c;
  
  private Rect d = new Rect();
  
  private Field e;
  
  private boolean f = true;
  
  private boolean g = false;
  
  public WrapperViewList(Context paramContext) {
    super(paramContext);
    try {
      Field field = AbsListView.class.getDeclaredField("mSelectorRect");
      field.setAccessible(true);
      this.d = (Rect)field.get(this);
      if (Build.VERSION.SDK_INT >= 14) {
        this.e = AbsListView.class.getDeclaredField("mSelectorPosition");
        this.e.setAccessible(true);
        return;
      } 
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException.printStackTrace();
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
      return;
    } catch (IllegalAccessException illegalAccessException) {
      illegalAccessException.printStackTrace();
      return;
    } 
  }
  
  private void b() {
    if (!this.d.isEmpty()) {
      int i = c();
      if (i >= 0) {
        View view = getChildAt(i - a());
        if (view instanceof WrapperView) {
          WrapperView wrapperView = (WrapperView)view;
          this.d.top = wrapperView.getTop() + wrapperView.e;
        } 
      } 
    } 
  }
  
  private void b(View paramView) {
    if (this.b == null)
      this.b = new ArrayList<View>(); 
    this.b.add(paramView);
  }
  
  private int c() {
    Field field = this.e;
    if (field == null) {
      for (int i = 0; i < getChildCount(); i++) {
        if (getChildAt(i).getBottom() == this.d.bottom)
          return i + a(); 
      } 
    } else {
      try {
        return field.getInt(this);
      } catch (IllegalArgumentException illegalArgumentException) {
        illegalArgumentException.printStackTrace();
      } catch (IllegalAccessException illegalAccessException) {
        illegalAccessException.printStackTrace();
      } 
    } 
    return -1;
  }
  
  int a() {
    int i;
    int k = getFirstVisiblePosition();
    if (Build.VERSION.SDK_INT >= 11)
      return k; 
    int j = 0;
    while (true) {
      i = k;
      if (j < getChildCount()) {
        if (getChildAt(j).getBottom() >= 0) {
          i = k + j;
          break;
        } 
        j++;
        continue;
      } 
      break;
    } 
    j = i;
    if (!this.f) {
      j = i;
      if (getPaddingTop() > 0) {
        j = i;
        if (i > 0) {
          j = i;
          if (getChildAt(0).getTop() > 0)
            j = i - 1; 
        } 
      } 
    } 
    return j;
  }
  
  void a(int paramInt) {
    this.c = paramInt;
  }
  
  void a(LifeCycleListener paramLifeCycleListener) {
    this.a = paramLifeCycleListener;
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  boolean a(View paramView) {
    List<View> list = this.b;
    return (list == null) ? false : list.contains(paramView);
  }
  
  public void addFooterView(View paramView) {
    super.addFooterView(paramView);
    b(paramView);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean) {
    super.addFooterView(paramView, paramObject, paramBoolean);
    b(paramView);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    b();
    if (this.c != 0) {
      paramCanvas.save();
      Rect rect = paramCanvas.getClipBounds();
      rect.top = this.c;
      paramCanvas.clipRect(rect);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
    } else {
      super.dispatchDraw(paramCanvas);
    } 
    this.a.a(paramCanvas);
  }
  
  protected void layoutChildren() {
    if (!this.g)
      super.layoutChildren(); 
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong) {
    View view = paramView;
    if (paramView instanceof WrapperView)
      view = ((WrapperView)paramView).a; 
    return super.performItemClick(view, paramInt, paramLong);
  }
  
  public boolean removeFooterView(View paramView) {
    if (super.removeFooterView(paramView)) {
      this.b.remove(paramView);
      return true;
    } 
    return false;
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    this.f = paramBoolean;
    super.setClipToPadding(paramBoolean);
  }
  
  static interface LifeCycleListener {
    void a(Canvas param1Canvas);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickylistheaders\WrapperViewList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */