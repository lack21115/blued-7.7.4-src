package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  
  public static final int INPUT_METHOD_NEEDED = 1;
  
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  
  public static final int MATCH_PARENT = -1;
  
  public static final int POSITION_PROMPT_ABOVE = 0;
  
  public static final int POSITION_PROMPT_BELOW = 1;
  
  public static final int WRAP_CONTENT = -2;
  
  private static Method a;
  
  private static Method b;
  
  private static Method h;
  
  private Drawable A;
  
  private AdapterView.OnItemClickListener B;
  
  private AdapterView.OnItemSelectedListener C;
  
  private final PopupTouchInterceptor D = new PopupTouchInterceptor(this);
  
  private final PopupScrollListener E = new PopupScrollListener(this);
  
  private final ListSelectorHider F = new ListSelectorHider(this);
  
  private Runnable G;
  
  private final Rect H = new Rect();
  
  private Rect I;
  
  private boolean J;
  
  DropDownListView c;
  
  int d = Integer.MAX_VALUE;
  
  final ResizePopupRunnable e = new ResizePopupRunnable(this);
  
  final Handler f;
  
  PopupWindow g;
  
  private Context i;
  
  private ListAdapter j;
  
  private int k = -2;
  
  private int l = -2;
  
  private int m;
  
  private int n;
  
  private int o = 1002;
  
  private boolean p;
  
  private boolean q = true;
  
  private boolean r;
  
  private boolean s;
  
  private int t = 0;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private View w;
  
  private int x = 0;
  
  private DataSetObserver y;
  
  private View z;
  
  static {
    if (Build.VERSION.SDK_INT <= 28) {
      try {
        a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { boolean.class });
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      } 
      try {
        h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
      } 
    } 
    if (Build.VERSION.SDK_INT <= 23)
      try {
        b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, int.class, boolean.class });
        return;
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      }  
  }
  
  public ListPopupWindow(Context paramContext) {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this.i = paramContext;
    this.f = new Handler(paramContext.getMainLooper());
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.m = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.n = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.n != 0)
      this.p = true; 
    typedArray.recycle();
    this.g = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.g.setInputMethodMode(1);
  }
  
  private int a(View paramView, int paramInt, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT <= 23) {
      Method method = b;
      if (method != null)
        try {
          return ((Integer)method.invoke(this.g, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
        } catch (Exception exception) {
          Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
        }  
      return this.g.getMaxAvailableHeight(paramView, paramInt);
    } 
    return this.g.getMaxAvailableHeight(paramView, paramInt, paramBoolean);
  }
  
  private void a() {
    View view = this.w;
    if (view != null) {
      ViewParent viewParent = view.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(this.w); 
    } 
  }
  
  private void a(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT <= 28) {
      Method method = a;
      if (method != null)
        try {
          method.invoke(this.g, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        } catch (Exception exception) {
          Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
          return;
        }  
    } else {
      this.g.setIsClippedToScreen(paramBoolean);
    } 
  }
  
  private static boolean a(int paramInt) {
    return (paramInt == 66 || paramInt == 23);
  }
  
  private int b() {
    byte b1;
    byte b2;
    DropDownListView dropDownListView = this.c;
    boolean bool = true;
    if (dropDownListView == null) {
      LinearLayout.LayoutParams layoutParams1;
      LinearLayout.LayoutParams layoutParams2;
      Context context = this.i;
      this.G = new Runnable(this) {
          public void run() {
            View view = this.a.getAnchorView();
            if (view != null && view.getWindowToken() != null)
              this.a.show(); 
          }
        };
      this.c = a(context, this.J ^ true);
      Drawable drawable1 = this.A;
      if (drawable1 != null)
        this.c.setSelector(drawable1); 
      this.c.setAdapter(this.j);
      this.c.setOnItemClickListener(this.B);
      this.c.setFocusable(true);
      this.c.setFocusableInTouchMode(true);
      this.c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) {
            public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
              if (param1Int != -1) {
                DropDownListView dropDownListView = this.a.c;
                if (dropDownListView != null)
                  dropDownListView.setListSelectionHidden(false); 
              } 
            }
            
            public void onNothingSelected(AdapterView<?> param1AdapterView) {}
          });
      this.c.setOnScrollListener(this.E);
      AdapterView.OnItemSelectedListener onItemSelectedListener = this.C;
      if (onItemSelectedListener != null)
        this.c.setOnItemSelectedListener(onItemSelectedListener); 
      DropDownListView dropDownListView1 = this.c;
      View view = this.w;
      if (view != null) {
        boolean bool1;
        StringBuilder stringBuilder;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        b1 = this.x;
        if (b1 != 0) {
          if (b1 != 1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid hint position ");
            stringBuilder.append(this.x);
            Log.e("ListPopupWindow", stringBuilder.toString());
          } else {
            linearLayout.addView((View)stringBuilder, (ViewGroup.LayoutParams)layoutParams);
            linearLayout.addView(view);
          } 
        } else {
          linearLayout.addView(view);
          linearLayout.addView((View)stringBuilder, (ViewGroup.LayoutParams)layoutParams);
        } 
        b1 = this.l;
        if (b1 >= 0) {
          bool1 = true;
        } else {
          b1 = 0;
          bool1 = false;
        } 
        view.measure(View.MeasureSpec.makeMeasureSpec(b1, bool1), 0);
        layoutParams2 = (LinearLayout.LayoutParams)view.getLayoutParams();
        b1 = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
      } else {
        b1 = 0;
        layoutParams1 = layoutParams2;
      } 
      this.g.setContentView((View)layoutParams1);
    } else {
      ViewGroup viewGroup = (ViewGroup)this.g.getContentView();
      View view = this.w;
      if (view != null) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
        b1 = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      } else {
        b1 = 0;
      } 
    } 
    Drawable drawable = this.g.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.H);
      int k = this.H.top + this.H.bottom;
      b2 = k;
      if (!this.p) {
        this.n = -this.H.top;
        b2 = k;
      } 
    } else {
      this.H.setEmpty();
      b2 = 0;
    } 
    if (this.g.getInputMethodMode() != 2)
      bool = false; 
    int j = a(getAnchorView(), this.n, bool);
    if (this.u || this.k == -1)
      return j + b2; 
    int i = this.l;
    if (i != -2) {
      if (i != -1) {
        i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      } else {
        i = View.MeasureSpec.makeMeasureSpec((this.i.getResources().getDisplayMetrics()).widthPixels - this.H.left + this.H.right, 1073741824);
      } 
    } else {
      i = View.MeasureSpec.makeMeasureSpec((this.i.getResources().getDisplayMetrics()).widthPixels - this.H.left + this.H.right, -2147483648);
    } 
    j = this.c.measureHeightOfChildrenCompat(i, 0, -1, j - b1, -1);
    i = b1;
    if (j > 0)
      i = b1 + b2 + this.c.getPaddingTop() + this.c.getPaddingBottom(); 
    return j + i;
  }
  
  DropDownListView a(Context paramContext, boolean paramBoolean) {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public void clearListSelection() {
    DropDownListView dropDownListView = this.c;
    if (dropDownListView != null) {
      dropDownListView.setListSelectionHidden(true);
      dropDownListView.requestLayout();
    } 
  }
  
  public View.OnTouchListener createDragToOpenListener(View paramView) {
    return new ForwardingListener(this, paramView) {
        public ListPopupWindow getPopup() {
          return this.a;
        }
      };
  }
  
  public void dismiss() {
    this.g.dismiss();
    a();
    this.g.setContentView(null);
    this.c = null;
    this.f.removeCallbacks(this.e);
  }
  
  public View getAnchorView() {
    return this.z;
  }
  
  public int getAnimationStyle() {
    return this.g.getAnimationStyle();
  }
  
  public Drawable getBackground() {
    return this.g.getBackground();
  }
  
  public Rect getEpicenterBounds() {
    Rect rect = this.I;
    return (rect != null) ? new Rect(rect) : null;
  }
  
  public int getHeight() {
    return this.k;
  }
  
  public int getHorizontalOffset() {
    return this.m;
  }
  
  public int getInputMethodMode() {
    return this.g.getInputMethodMode();
  }
  
  public ListView getListView() {
    return this.c;
  }
  
  public int getPromptPosition() {
    return this.x;
  }
  
  public Object getSelectedItem() {
    return !isShowing() ? null : this.c.getSelectedItem();
  }
  
  public long getSelectedItemId() {
    return !isShowing() ? Long.MIN_VALUE : this.c.getSelectedItemId();
  }
  
  public int getSelectedItemPosition() {
    return !isShowing() ? -1 : this.c.getSelectedItemPosition();
  }
  
  public View getSelectedView() {
    return !isShowing() ? null : this.c.getSelectedView();
  }
  
  public int getSoftInputMode() {
    return this.g.getSoftInputMode();
  }
  
  public int getVerticalOffset() {
    return !this.p ? 0 : this.n;
  }
  
  public int getWidth() {
    return this.l;
  }
  
  public boolean isDropDownAlwaysVisible() {
    return this.u;
  }
  
  public boolean isInputMethodNotNeeded() {
    return (this.g.getInputMethodMode() == 2);
  }
  
  public boolean isModal() {
    return this.J;
  }
  
  public boolean isShowing() {
    return this.g.isShowing();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (isShowing() && paramInt != 62 && (this.c.getSelectedItemPosition() >= 0 || !a(paramInt))) {
      int j;
      int k = this.c.getSelectedItemPosition();
      int m = this.g.isAboveAnchor() ^ true;
      ListAdapter listAdapter = this.j;
      int i = Integer.MAX_VALUE;
      if (listAdapter != null) {
        boolean bool = listAdapter.areAllItemsEnabled();
        if (bool) {
          i = 0;
        } else {
          i = this.c.lookForSelectablePosition(0, true);
        } 
        if (bool) {
          j = listAdapter.getCount() - 1;
        } else {
          j = this.c.lookForSelectablePosition(listAdapter.getCount() - 1, false);
        } 
      } else {
        j = Integer.MIN_VALUE;
      } 
      if ((m != 0 && paramInt == 19 && k <= i) || (m == 0 && paramInt == 20 && k >= j)) {
        clearListSelection();
        this.g.setInputMethodMode(1);
        show();
        return true;
      } 
      this.c.setListSelectionHidden(false);
      if (this.c.onKeyDown(paramInt, paramKeyEvent)) {
        this.g.setInputMethodMode(2);
        this.c.requestFocusFromTouch();
        show();
        return !(paramInt != 19 && paramInt != 20 && paramInt != 23 && paramInt != 66);
      } 
      if (m != 0 && paramInt == 20) {
        if (k == j)
          return true; 
      } else if (m == 0 && paramInt == 19 && k == i) {
        return true;
      } 
    } 
    return false;
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && isShowing()) {
      KeyEvent.DispatcherState dispatcherState;
      View view = this.z;
      if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getRepeatCount() == 0) {
        dispatcherState = view.getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.startTracking(paramKeyEvent, this); 
        return true;
      } 
      if (paramKeyEvent.getAction() == 1) {
        dispatcherState = dispatcherState.getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.handleUpEvent(paramKeyEvent); 
        if (paramKeyEvent.isTracking() && !paramKeyEvent.isCanceled()) {
          dismiss();
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    if (isShowing() && this.c.getSelectedItemPosition() >= 0) {
      boolean bool = this.c.onKeyUp(paramInt, paramKeyEvent);
      if (bool && a(paramInt))
        dismiss(); 
      return bool;
    } 
    return false;
  }
  
  public boolean performItemClick(int paramInt) {
    if (isShowing()) {
      if (this.B != null) {
        DropDownListView dropDownListView = this.c;
        View view = dropDownListView.getChildAt(paramInt - dropDownListView.getFirstVisiblePosition());
        ListAdapter listAdapter = dropDownListView.getAdapter();
        this.B.onItemClick((AdapterView)dropDownListView, view, paramInt, listAdapter.getItemId(paramInt));
      } 
      return true;
    } 
    return false;
  }
  
  public void postShow() {
    this.f.post(this.G);
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    DataSetObserver dataSetObserver = this.y;
    if (dataSetObserver == null) {
      this.y = new PopupDataSetObserver(this);
    } else {
      ListAdapter listAdapter = this.j;
      if (listAdapter != null)
        listAdapter.unregisterDataSetObserver(dataSetObserver); 
    } 
    this.j = paramListAdapter;
    if (paramListAdapter != null)
      paramListAdapter.registerDataSetObserver(this.y); 
    DropDownListView dropDownListView = this.c;
    if (dropDownListView != null)
      dropDownListView.setAdapter(this.j); 
  }
  
  public void setAnchorView(View paramView) {
    this.z = paramView;
  }
  
  public void setAnimationStyle(int paramInt) {
    this.g.setAnimationStyle(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    this.g.setBackgroundDrawable(paramDrawable);
  }
  
  public void setContentWidth(int paramInt) {
    Drawable drawable = this.g.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.H);
      this.l = this.H.left + this.H.right + paramInt;
      return;
    } 
    setWidth(paramInt);
  }
  
  public void setDropDownAlwaysVisible(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public void setDropDownGravity(int paramInt) {
    this.t = paramInt;
  }
  
  public void setEpicenterBounds(Rect paramRect) {
    if (paramRect != null) {
      paramRect = new Rect(paramRect);
    } else {
      paramRect = null;
    } 
    this.I = paramRect;
  }
  
  public void setForceIgnoreOutsideTouch(boolean paramBoolean) {
    this.v = paramBoolean;
  }
  
  public void setHeight(int paramInt) {
    if (paramInt >= 0 || -2 == paramInt || -1 == paramInt) {
      this.k = paramInt;
      return;
    } 
    throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
  }
  
  public void setHorizontalOffset(int paramInt) {
    this.m = paramInt;
  }
  
  public void setInputMethodMode(int paramInt) {
    this.g.setInputMethodMode(paramInt);
  }
  
  public void setListSelector(Drawable paramDrawable) {
    this.A = paramDrawable;
  }
  
  public void setModal(boolean paramBoolean) {
    this.J = paramBoolean;
    this.g.setFocusable(paramBoolean);
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.g.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener) {
    this.B = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener) {
    this.C = paramOnItemSelectedListener;
  }
  
  public void setOverlapAnchor(boolean paramBoolean) {
    this.s = true;
    this.r = paramBoolean;
  }
  
  public void setPromptPosition(int paramInt) {
    this.x = paramInt;
  }
  
  public void setPromptView(View paramView) {
    boolean bool = isShowing();
    if (bool)
      a(); 
    this.w = paramView;
    if (bool)
      show(); 
  }
  
  public void setSelection(int paramInt) {
    DropDownListView dropDownListView = this.c;
    if (isShowing() && dropDownListView != null) {
      dropDownListView.setListSelectionHidden(false);
      dropDownListView.setSelection(paramInt);
      if (dropDownListView.getChoiceMode() != 0)
        dropDownListView.setItemChecked(paramInt, true); 
    } 
  }
  
  public void setSoftInputMode(int paramInt) {
    this.g.setSoftInputMode(paramInt);
  }
  
  public void setVerticalOffset(int paramInt) {
    this.n = paramInt;
    this.p = true;
  }
  
  public void setWidth(int paramInt) {
    this.l = paramInt;
  }
  
  public void setWindowLayoutType(int paramInt) {
    this.o = paramInt;
  }
  
  public void show() {
    int i;
    int j = b();
    boolean bool1 = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.g, this.o);
    boolean bool2 = this.g.isShowing();
    boolean bool = true;
    if (bool2) {
      if (!ViewCompat.isAttachedToWindow(getAnchorView()))
        return; 
      int m = this.l;
      if (m == -1) {
        i = -1;
      } else {
        i = m;
        if (m == -2)
          i = getAnchorView().getWidth(); 
      } 
      m = this.k;
      if (m == -1) {
        if (!bool1)
          j = -1; 
        if (bool1) {
          PopupWindow popupWindow2 = this.g;
          if (this.l == -1) {
            m = -1;
          } else {
            m = 0;
          } 
          popupWindow2.setWidth(m);
          this.g.setHeight(0);
        } else {
          PopupWindow popupWindow2 = this.g;
          if (this.l == -1) {
            m = -1;
          } else {
            m = 0;
          } 
          popupWindow2.setWidth(m);
          this.g.setHeight(-1);
        } 
      } else if (m != -2) {
        j = m;
      } 
      PopupWindow popupWindow1 = this.g;
      if (this.v || this.u)
        bool = false; 
      popupWindow1.setOutsideTouchable(bool);
      popupWindow1 = this.g;
      View view = getAnchorView();
      m = this.m;
      int n = this.n;
      if (i < 0)
        i = -1; 
      if (j < 0)
        j = -1; 
      popupWindow1.update(view, m, n, i, j);
      return;
    } 
    int k = this.l;
    if (k == -1) {
      i = -1;
    } else {
      i = k;
      if (k == -2)
        i = getAnchorView().getWidth(); 
    } 
    k = this.k;
    if (k == -1) {
      j = -1;
    } else if (k != -2) {
      j = k;
    } 
    this.g.setWidth(i);
    this.g.setHeight(j);
    a(true);
    PopupWindow popupWindow = this.g;
    if (!this.v && !this.u) {
      bool = true;
    } else {
      bool = false;
    } 
    popupWindow.setOutsideTouchable(bool);
    this.g.setTouchInterceptor(this.D);
    if (this.s)
      PopupWindowCompat.setOverlapAnchor(this.g, this.r); 
    if (Build.VERSION.SDK_INT <= 28) {
      Method method = h;
      if (method != null)
        try {
          method.invoke(this.g, new Object[] { this.I });
        } catch (Exception exception) {
          Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception);
        }  
    } else {
      this.g.setEpicenterBounds(this.I);
    } 
    PopupWindowCompat.showAsDropDown(this.g, getAnchorView(), this.m, this.n, this.t);
    this.c.setSelection(-1);
    if (!this.J || this.c.isInTouchMode())
      clearListSelection(); 
    if (!this.J)
      this.f.post(this.F); 
  }
  
  class ListSelectorHider implements Runnable {
    ListSelectorHider(ListPopupWindow this$0) {}
    
    public void run() {
      this.a.clearListSelection();
    }
  }
  
  class PopupDataSetObserver extends DataSetObserver {
    PopupDataSetObserver(ListPopupWindow this$0) {}
    
    public void onChanged() {
      if (this.a.isShowing())
        this.a.show(); 
    }
    
    public void onInvalidated() {
      this.a.dismiss();
    }
  }
  
  class PopupScrollListener implements AbsListView.OnScrollListener {
    PopupScrollListener(ListPopupWindow this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (param1Int == 1 && !this.a.isInputMethodNotNeeded() && this.a.g.getContentView() != null) {
        this.a.f.removeCallbacks(this.a.e);
        this.a.e.run();
      } 
    }
  }
  
  class PopupTouchInterceptor implements View.OnTouchListener {
    PopupTouchInterceptor(ListPopupWindow this$0) {}
    
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getAction();
      int j = (int)param1MotionEvent.getX();
      int k = (int)param1MotionEvent.getY();
      if (i == 0 && this.a.g != null && this.a.g.isShowing() && j >= 0 && j < this.a.g.getWidth() && k >= 0 && k < this.a.g.getHeight()) {
        this.a.f.postDelayed(this.a.e, 250L);
      } else if (i == 1) {
        this.a.f.removeCallbacks(this.a.e);
      } 
      return false;
    }
  }
  
  class ResizePopupRunnable implements Runnable {
    ResizePopupRunnable(ListPopupWindow this$0) {}
    
    public void run() {
      if (this.a.c != null && ViewCompat.isAttachedToWindow((View)this.a.c) && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.d) {
        this.a.g.setInputMethodMode(2);
        this.a.show();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */