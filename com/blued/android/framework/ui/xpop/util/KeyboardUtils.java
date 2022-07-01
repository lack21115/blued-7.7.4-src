package com.blued.android.framework.ui.xpop.util;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import java.util.HashMap;
import java.util.Iterator;

public final class KeyboardUtils {
  public static int a;
  
  private static ViewTreeObserver.OnGlobalLayoutListener b;
  
  private static HashMap<View, OnSoftInputChangedListener> c = new HashMap<View, OnSoftInputChangedListener>();
  
  private static int d = 0;
  
  private KeyboardUtils() {
    throw new UnsupportedOperationException("u can't instantiate me...");
  }
  
  public static void a(View paramView) {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).showSoftInput(paramView, 2);
  }
  
  public static void a(View paramView, BasePopupView paramBasePopupView) {
    b = null;
    if (paramView == null)
      return; 
    paramView = paramView.findViewById(16908290);
    if (paramView == null)
      return; 
    paramView.getViewTreeObserver().removeGlobalOnLayoutListener(b);
    c.remove(paramBasePopupView);
  }
  
  public static void a(Window paramWindow, BasePopupView paramBasePopupView, OnSoftInputChangedListener paramOnSoftInputChangedListener) {
    if (((paramWindow.getAttributes()).flags & 0x200) != 0)
      paramWindow.clearFlags(512); 
    FrameLayout frameLayout = (FrameLayout)paramWindow.findViewById(16908290);
    a = b(paramWindow);
    c.put(paramBasePopupView, paramOnSoftInputChangedListener);
    ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(paramWindow) {
        public void onGlobalLayout() {
          int i = KeyboardUtils.a(this.a);
          if (KeyboardUtils.a != i) {
            Iterator<KeyboardUtils.OnSoftInputChangedListener> iterator = KeyboardUtils.a().values().iterator();
            while (iterator.hasNext())
              ((KeyboardUtils.OnSoftInputChangedListener)iterator.next()).a(i); 
            KeyboardUtils.a = i;
          } 
        }
      };
    frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
  }
  
  private static int b() {
    Resources resources = Resources.getSystem();
    int i = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    return (i != 0) ? resources.getDimensionPixelSize(i) : 0;
  }
  
  private static int b(Window paramWindow) {
    View view = paramWindow.getDecorView();
    if (view == null)
      return a; 
    Rect rect = new Rect();
    view.getWindowVisibleDisplayFrame(rect);
    int i = Math.abs(view.getBottom() - rect.bottom);
    if (i <= b()) {
      d = i;
      return 0;
    } 
    return i - d;
  }
  
  public static void b(View paramView) {
    ((InputMethodManager)paramView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static interface OnSoftInputChangedListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpo\\util\KeyboardUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */