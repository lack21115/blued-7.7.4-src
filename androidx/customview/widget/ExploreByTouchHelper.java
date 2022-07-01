package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityRecord;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
  public static final int HOST_ID = -1;
  
  public static final int INVALID_ID = -2147483648;
  
  private static final Rect c = new Rect(2147483647, 2147483647, -2147483648, -2147483648);
  
  private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> l = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
      public void obtainBounds(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat, Rect param1Rect) {
        param1AccessibilityNodeInfoCompat.getBoundsInParent(param1Rect);
      }
    };
  
  private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> m = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
      public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> param1SparseArrayCompat, int param1Int) {
        return (AccessibilityNodeInfoCompat)param1SparseArrayCompat.valueAt(param1Int);
      }
      
      public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> param1SparseArrayCompat) {
        return param1SparseArrayCompat.size();
      }
    };
  
  int a = Integer.MIN_VALUE;
  
  int b = Integer.MIN_VALUE;
  
  private final Rect d = new Rect();
  
  private final Rect e = new Rect();
  
  private final Rect f = new Rect();
  
  private final int[] g = new int[2];
  
  private final AccessibilityManager h;
  
  private final View i;
  
  private MyNodeProvider j;
  
  public int k = Integer.MIN_VALUE;
  
  public ExploreByTouchHelper(View paramView) {
    if (paramView != null) {
      this.i = paramView;
      this.h = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
      paramView.setFocusable(true);
      if (ViewCompat.getImportantForAccessibility(paramView) == 0)
        ViewCompat.setImportantForAccessibility(paramView, 1); 
      return;
    } 
    throw new IllegalArgumentException("View may not be null");
  }
  
  private static Rect a(View paramView, int paramInt, Rect paramRect) {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130) {
            paramRect.set(0, -1, i, -1);
            return paramRect;
          } 
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } 
        paramRect.set(-1, 0, -1, j);
        return paramRect;
      } 
      paramRect.set(0, j, i, j);
      return paramRect;
    } 
    paramRect.set(i, 0, i, j);
    return paramRect;
  }
  
  private AccessibilityEvent a(int paramInt1, int paramInt2) {
    return (paramInt1 != -1) ? b(paramInt1, paramInt2) : d(paramInt2);
  }
  
  private void a(int paramInt, Rect paramRect) {
    a(paramInt).getBoundsInParent(paramRect);
  }
  
  private boolean a(int paramInt, Bundle paramBundle) {
    return ViewCompat.performAccessibilityAction(this.i, paramInt, paramBundle);
  }
  
  private boolean a(Rect paramRect) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramRect != null) {
      if (paramRect.isEmpty())
        return false; 
      if (this.i.getWindowVisibility() != 0)
        return false; 
      ViewParent viewParent = this.i.getParent();
      while (viewParent instanceof View) {
        View view = (View)viewParent;
        if (view.getAlpha() > 0.0F) {
          if (view.getVisibility() != 0)
            return false; 
          viewParent = view.getParent();
          continue;
        } 
        return false;
      } 
      bool1 = bool2;
      if (viewParent != null)
        bool1 = true; 
    } 
    return bool1;
  }
  
  private static int b(int paramInt) {
    return (paramInt != 19) ? ((paramInt != 21) ? ((paramInt != 22) ? 130 : 66) : 17) : 33;
  }
  
  private AccessibilityEvent b(int paramInt1, int paramInt2) {
    AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = a(paramInt1);
    accessibilityEvent.getText().add(accessibilityNodeInfoCompat.getText());
    accessibilityEvent.setContentDescription(accessibilityNodeInfoCompat.getContentDescription());
    accessibilityEvent.setScrollable(accessibilityNodeInfoCompat.isScrollable());
    accessibilityEvent.setPassword(accessibilityNodeInfoCompat.isPassword());
    accessibilityEvent.setEnabled(accessibilityNodeInfoCompat.isEnabled());
    accessibilityEvent.setChecked(accessibilityNodeInfoCompat.isChecked());
    a(paramInt1, accessibilityEvent);
    if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
      accessibilityEvent.setClassName(accessibilityNodeInfoCompat.getClassName());
      AccessibilityRecordCompat.setSource((AccessibilityRecord)accessibilityEvent, this.i, paramInt1);
      accessibilityEvent.setPackageName(this.i.getContext().getPackageName());
      return accessibilityEvent;
    } 
    throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
  }
  
  private SparseArrayCompat<AccessibilityNodeInfoCompat> b() {
    ArrayList<Integer> arrayList = new ArrayList();
    a(arrayList);
    SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat();
    for (int i = 0; i < arrayList.size(); i++)
      sparseArrayCompat.put(i, e(i)); 
    return sparseArrayCompat;
  }
  
  private boolean b(int paramInt, Rect paramRect) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat1;
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
    SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = b();
    int j = this.b;
    int i = Integer.MIN_VALUE;
    if (j == Integer.MIN_VALUE) {
      accessibilityNodeInfoCompat2 = null;
    } else {
      accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat)sparseArrayCompat.get(j);
    } 
    if (paramInt != 1 && paramInt != 2) {
      if (paramInt == 17 || paramInt == 33 || paramInt == 66 || paramInt == 130) {
        Rect rect = new Rect();
        j = this.b;
        if (j != Integer.MIN_VALUE) {
          a(j, rect);
        } else if (paramRect != null) {
          rect.set(paramRect);
        } else {
          a(this.i, paramInt, rect);
        } 
        accessibilityNodeInfoCompat1 = FocusStrategy.<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>findNextFocusInAbsoluteDirection(sparseArrayCompat, m, l, accessibilityNodeInfoCompat2, rect, paramInt);
      } else {
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      } 
    } else {
      boolean bool;
      if (ViewCompat.getLayoutDirection(this.i) == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      accessibilityNodeInfoCompat1 = FocusStrategy.<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>findNextFocusInRelativeDirection(sparseArrayCompat, m, l, accessibilityNodeInfoCompat2, paramInt, bool, false);
    } 
    if (accessibilityNodeInfoCompat1 == null) {
      paramInt = i;
    } else {
      paramInt = sparseArrayCompat.keyAt(sparseArrayCompat.indexOfValue(accessibilityNodeInfoCompat1));
    } 
    return requestKeyboardFocusForVirtualView(paramInt);
  }
  
  private boolean c() {
    int i = this.b;
    return (i != Integer.MIN_VALUE && b(i, 16, null));
  }
  
  private boolean c(int paramInt1, int paramInt2, Bundle paramBundle) {
    return (paramInt2 != 1) ? ((paramInt2 != 2) ? ((paramInt2 != 64) ? ((paramInt2 != 128) ? b(paramInt1, paramInt2, paramBundle) : g(paramInt1)) : f(paramInt1)) : clearKeyboardFocusForVirtualView(paramInt1)) : requestKeyboardFocusForVirtualView(paramInt1);
  }
  
  private AccessibilityEvent d(int paramInt) {
    AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(paramInt);
    this.i.onInitializeAccessibilityEvent(accessibilityEvent);
    return accessibilityEvent;
  }
  
  private AccessibilityNodeInfoCompat d() {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.i);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.i, accessibilityNodeInfoCompat);
    ArrayList<Integer> arrayList = new ArrayList();
    a(arrayList);
    if (accessibilityNodeInfoCompat.getChildCount() <= 0 || arrayList.size() <= 0) {
      int i = 0;
      int j = arrayList.size();
      while (i < j) {
        accessibilityNodeInfoCompat.addChild(this.i, ((Integer)arrayList.get(i)).intValue());
        i++;
      } 
      return accessibilityNodeInfoCompat;
    } 
    throw new RuntimeException("Views cannot have both real and virtual children");
  }
  
  private AccessibilityNodeInfoCompat e(int paramInt) {
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    accessibilityNodeInfoCompat.setEnabled(true);
    accessibilityNodeInfoCompat.setFocusable(true);
    accessibilityNodeInfoCompat.setClassName("android.view.View");
    accessibilityNodeInfoCompat.setBoundsInParent(c);
    accessibilityNodeInfoCompat.setBoundsInScreen(c);
    accessibilityNodeInfoCompat.setParent(this.i);
    a(paramInt, accessibilityNodeInfoCompat);
    if (accessibilityNodeInfoCompat.getText() != null || accessibilityNodeInfoCompat.getContentDescription() != null) {
      accessibilityNodeInfoCompat.getBoundsInParent(this.e);
      if (!this.e.equals(c)) {
        int i = accessibilityNodeInfoCompat.getActions();
        if ((i & 0x40) == 0) {
          if ((i & 0x80) == 0) {
            boolean bool;
            accessibilityNodeInfoCompat.setPackageName(this.i.getContext().getPackageName());
            accessibilityNodeInfoCompat.setSource(this.i, paramInt);
            if (this.a == paramInt) {
              accessibilityNodeInfoCompat.setAccessibilityFocused(true);
              accessibilityNodeInfoCompat.addAction(128);
            } else {
              accessibilityNodeInfoCompat.setAccessibilityFocused(false);
              accessibilityNodeInfoCompat.addAction(64);
            } 
            if (this.b == paramInt) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool) {
              accessibilityNodeInfoCompat.addAction(2);
            } else if (accessibilityNodeInfoCompat.isFocusable()) {
              accessibilityNodeInfoCompat.addAction(1);
            } 
            accessibilityNodeInfoCompat.setFocused(bool);
            this.i.getLocationOnScreen(this.g);
            accessibilityNodeInfoCompat.getBoundsInScreen(this.d);
            if (this.d.equals(c)) {
              accessibilityNodeInfoCompat.getBoundsInParent(this.d);
              if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain();
                for (paramInt = accessibilityNodeInfoCompat.mParentVirtualDescendantId; paramInt != -1; paramInt = accessibilityNodeInfoCompat1.mParentVirtualDescendantId) {
                  accessibilityNodeInfoCompat1.setParent(this.i, -1);
                  accessibilityNodeInfoCompat1.setBoundsInParent(c);
                  a(paramInt, accessibilityNodeInfoCompat1);
                  accessibilityNodeInfoCompat1.getBoundsInParent(this.e);
                  this.d.offset(this.e.left, this.e.top);
                } 
                accessibilityNodeInfoCompat1.recycle();
              } 
              this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            } 
            if (this.i.getLocalVisibleRect(this.f)) {
              this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
              if (this.d.intersect(this.f)) {
                accessibilityNodeInfoCompat.setBoundsInScreen(this.d);
                if (a(this.d))
                  accessibilityNodeInfoCompat.setVisibleToUser(true); 
              } 
            } 
            return accessibilityNodeInfoCompat;
          } 
          throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } 
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      } 
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    } 
    throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
  }
  
  private boolean f(int paramInt) {
    if (this.h.isEnabled()) {
      if (!this.h.isTouchExplorationEnabled())
        return false; 
      int i = this.a;
      if (i != paramInt) {
        if (i != Integer.MIN_VALUE)
          g(i); 
        this.a = paramInt;
        this.i.invalidate();
        sendEventForVirtualView(paramInt, 32768);
        return true;
      } 
    } 
    return false;
  }
  
  private boolean g(int paramInt) {
    if (this.a == paramInt) {
      this.a = Integer.MIN_VALUE;
      this.i.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    } 
    return false;
  }
  
  protected abstract int a(float paramFloat1, float paramFloat2);
  
  AccessibilityNodeInfoCompat a(int paramInt) {
    return (paramInt == -1) ? d() : e(paramInt);
  }
  
  protected void a(int paramInt, AccessibilityEvent paramAccessibilityEvent) {}
  
  protected abstract void a(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  protected void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void a(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  protected abstract void a(List<Integer> paramList);
  
  boolean a(int paramInt1, int paramInt2, Bundle paramBundle) {
    return (paramInt1 != -1) ? c(paramInt1, paramInt2, paramBundle) : a(paramInt2, paramBundle);
  }
  
  protected abstract boolean b(int paramInt1, int paramInt2, Bundle paramBundle);
  
  public void c(int paramInt) {
    int i = this.k;
    if (i == paramInt)
      return; 
    this.k = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt) {
    if (this.b != paramInt)
      return false; 
    this.b = Integer.MIN_VALUE;
    a(paramInt, false);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean dispatchHoverEvent(MotionEvent paramMotionEvent) {
    boolean bool = this.h.isEnabled();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      if (!this.h.isTouchExplorationEnabled())
        return false; 
      int i = paramMotionEvent.getAction();
      if (i != 7 && i != 9) {
        if (i != 10)
          return false; 
        if (this.k != Integer.MIN_VALUE) {
          c(-2147483648);
          return true;
        } 
        return false;
      } 
      i = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      c(i);
      bool1 = bool2;
      if (i != Integer.MIN_VALUE)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    int j = paramKeyEvent.getAction();
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (j != 1) {
      j = paramKeyEvent.getKeyCode();
      if (j != 61) {
        if (j != 66)
          switch (j) {
            default:
              return false;
            case 19:
            case 20:
            case 21:
            case 22:
              bool1 = bool2;
              if (paramKeyEvent.hasNoModifiers()) {
                j = b(j);
                int k = paramKeyEvent.getRepeatCount();
                for (bool1 = false; i < k + 1 && b(j, (Rect)null); bool1 = true)
                  i++; 
                return bool1;
              } 
              return bool1;
            case 23:
              break;
          }  
        bool1 = bool2;
        if (paramKeyEvent.hasNoModifiers()) {
          bool1 = bool2;
          if (paramKeyEvent.getRepeatCount() == 0) {
            c();
            return true;
          } 
        } 
      } else {
        if (paramKeyEvent.hasNoModifiers())
          return b(2, (Rect)null); 
        bool1 = bool2;
        if (paramKeyEvent.hasModifiers(1))
          bool1 = b(1, (Rect)null); 
      } 
    } 
    return bool1;
  }
  
  public final int getAccessibilityFocusedVirtualViewId() {
    return this.a;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView) {
    if (this.j == null)
      this.j = new MyNodeProvider(this); 
    return this.j;
  }
  
  @Deprecated
  public int getFocusedVirtualView() {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId() {
    return this.b;
  }
  
  public final void invalidateRoot() {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt) {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2) {
    if (paramInt1 != Integer.MIN_VALUE && this.h.isEnabled()) {
      ViewParent viewParent = this.i.getParent();
      if (viewParent != null) {
        AccessibilityEvent accessibilityEvent = a(paramInt1, 2048);
        AccessibilityEventCompat.setContentChangeTypes(accessibilityEvent, paramInt2);
        ViewParentCompat.requestSendAccessibilityEvent(viewParent, this.i, accessibilityEvent);
      } 
    } 
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    int i = this.b;
    if (i != Integer.MIN_VALUE)
      clearKeyboardFocusForVirtualView(i); 
    if (paramBoolean)
      b(paramInt, paramRect); 
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    a(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    a(paramAccessibilityNodeInfoCompat);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt) {
    if (!this.i.isFocused() && !this.i.requestFocus())
      return false; 
    int i = this.b;
    if (i == paramInt)
      return false; 
    if (i != Integer.MIN_VALUE)
      clearKeyboardFocusForVirtualView(i); 
    this.b = paramInt;
    a(paramInt, true);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2) {
    if (paramInt1 != Integer.MIN_VALUE) {
      if (!this.h.isEnabled())
        return false; 
      ViewParent viewParent = this.i.getParent();
      if (viewParent == null)
        return false; 
      AccessibilityEvent accessibilityEvent = a(paramInt1, paramInt2);
      return ViewParentCompat.requestSendAccessibilityEvent(viewParent, this.i, accessibilityEvent);
    } 
    return false;
  }
  
  class MyNodeProvider extends AccessibilityNodeProviderCompat {
    MyNodeProvider(ExploreByTouchHelper this$0) {}
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int param1Int) {
      return AccessibilityNodeInfoCompat.obtain(this.a.a(param1Int));
    }
    
    public AccessibilityNodeInfoCompat findFocus(int param1Int) {
      if (param1Int == 2) {
        param1Int = this.a.a;
      } else {
        param1Int = this.a.b;
      } 
      return (param1Int == Integer.MIN_VALUE) ? null : createAccessibilityNodeInfo(param1Int);
    }
    
    public boolean performAction(int param1Int1, int param1Int2, Bundle param1Bundle) {
      return this.a.a(param1Int1, param1Int2, param1Bundle);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\customview\widget\ExploreByTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */