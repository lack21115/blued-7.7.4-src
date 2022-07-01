package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.ShowableListMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
  private static Method sClipToWindowEnabledMethod;
  
  private static Method sGetMaxAvailableHeightMethod;
  
  private static Method sSetEpicenterBoundsMethod;
  
  private ListAdapter mAdapter;
  
  private Context mContext;
  
  private boolean mDropDownAlwaysVisible = false;
  
  public View mDropDownAnchorView;
  
  public int mDropDownGravity = 0;
  
  private int mDropDownHeight = -2;
  
  public int mDropDownHorizontalOffset;
  
  public DropDownListView mDropDownList;
  
  private Drawable mDropDownListHighlight;
  
  public int mDropDownVerticalOffset;
  
  public boolean mDropDownVerticalOffsetSet;
  
  private int mDropDownWidth = -2;
  
  private int mDropDownWindowLayoutType = 1002;
  
  public Rect mEpicenterBounds;
  
  private boolean mForceIgnoreOutsideTouch = false;
  
  final Handler mHandler;
  
  private final ListPopupWindow$ListSelectorHider mHideSelector = new ListPopupWindow$ListSelectorHider(this);
  
  public AdapterView.OnItemClickListener mItemClickListener;
  
  private AdapterView.OnItemSelectedListener mItemSelectedListener;
  
  int mListItemExpandMaximum = Integer.MAX_VALUE;
  
  public boolean mModal;
  
  private DataSetObserver mObserver;
  
  public boolean mOverlapAnchor;
  
  public boolean mOverlapAnchorSet;
  
  public PopupWindow mPopup;
  
  private int mPromptPosition = 0;
  
  private View mPromptView;
  
  final ListPopupWindow$ResizePopupRunnable mResizePopupRunnable = new ListPopupWindow$ResizePopupRunnable(this);
  
  private final ListPopupWindow$PopupScrollListener mScrollListener = new ListPopupWindow$PopupScrollListener(this);
  
  private final Rect mTempRect = new Rect();
  
  private final ListPopupWindow$PopupTouchInterceptor mTouchInterceptor = new ListPopupWindow$PopupTouchInterceptor(this);
  
  static {
    try {
      Class<boolean> clazz = boolean.class;
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchMethodException noSuchMethodException) {
      Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      try {
        Class<int> clazz1 = int.class;
        Class<boolean> clazz = boolean.class;
        throw new VerifyError("bad dex opcode");
      } catch (NoSuchMethodException noSuchMethodException1) {
        Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        try {
          throw new VerifyError("bad dex opcode");
        } catch (NoSuchMethodException noSuchMethodException2) {
          Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
          throw new VerifyError("bad dex opcode");
        } 
      } 
    } 
  }
  
  public ListPopupWindow(Context paramContext) {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  private ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this.mContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper());
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.mDropDownHorizontalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    this.mDropDownVerticalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    if (this.mDropDownVerticalOffset != 0)
      this.mDropDownVerticalOffsetSet = true; 
    typedArray.recycle();
    this.mPopup = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.mPopup.setInputMethodMode(1);
  }
  
  private int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean) {
    if (sGetMaxAvailableHeightMethod != null)
      try {
        return ((Integer)sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
      }  
    return this.mPopup.getMaxAvailableHeight(paramView, paramInt);
  }
  
  public final void clearListSelection() {
    DropDownListView dropDownListView = this.mDropDownList;
    if (dropDownListView != null) {
      dropDownListView.mListSelectionHidden = true;
      dropDownListView.requestLayout();
    } 
  }
  
  DropDownListView createDropDownListView(Context paramContext, boolean paramBoolean) {
    return new DropDownListView(paramContext, paramBoolean);
  }
  
  public final void dismiss() {
    this.mPopup.dismiss();
    if (this.mPromptView != null) {
      ViewParent viewParent = this.mPromptView.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(this.mPromptView); 
    } 
    this.mPopup.setContentView(null);
    this.mDropDownList = null;
    this.mHandler.removeCallbacks(this.mResizePopupRunnable);
  }
  
  public final ListView getListView() {
    return this.mDropDownList;
  }
  
  public final boolean isInputMethodNotNeeded() {
    return (this.mPopup.getInputMethodMode() == 2);
  }
  
  public final boolean isShowing() {
    return this.mPopup.isShowing();
  }
  
  public final void setAdapter(ListAdapter paramListAdapter) {
    if (this.mObserver == null) {
      this.mObserver = new ListPopupWindow$PopupDataSetObserver(this);
    } else if (this.mAdapter != null) {
      this.mAdapter.unregisterDataSetObserver(this.mObserver);
    } 
    this.mAdapter = paramListAdapter;
    if (this.mAdapter != null)
      paramListAdapter.registerDataSetObserver(this.mObserver); 
    if (this.mDropDownList != null)
      this.mDropDownList.setAdapter(this.mAdapter); 
  }
  
  public final void setContentWidth(int paramInt) {
    Drawable drawable = this.mPopup.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.mTempRect);
      this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + paramInt;
      return;
    } 
    this.mDropDownWidth = paramInt;
  }
  
  public final void setInputMethodMode(int paramInt) {
    this.mPopup.setInputMethodMode(paramInt);
  }
  
  public final void setModal(boolean paramBoolean) {
    this.mModal = paramBoolean;
    this.mPopup.setFocusable(paramBoolean);
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.mPopup.setOnDismissListener(paramOnDismissListener);
  }
  
  public final void setVerticalOffset(int paramInt) {
    this.mDropDownVerticalOffset = paramInt;
    this.mDropDownVerticalOffsetSet = true;
  }
  
  public final void show() {
    int i;
    int j;
    int k;
    DropDownListView dropDownListView = this.mDropDownList;
    boolean bool1 = true;
    if (dropDownListView == null) {
      LinearLayout.LayoutParams layoutParams1;
      LinearLayout.LayoutParams layoutParams2;
      Context context = this.mContext;
      new ListPopupWindow$2(this);
      this.mDropDownList = createDropDownListView(context, this.mModal ^ true);
      if (this.mDropDownListHighlight != null)
        this.mDropDownList.setSelector(this.mDropDownListHighlight); 
      this.mDropDownList.setAdapter(this.mAdapter);
      this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
      this.mDropDownList.setFocusable(true);
      this.mDropDownList.setFocusableInTouchMode(true);
      this.mDropDownList.setOnItemSelectedListener(new ListPopupWindow$3(this));
      this.mDropDownList.setOnScrollListener(this.mScrollListener);
      if (this.mItemSelectedListener != null)
        this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener); 
      DropDownListView dropDownListView1 = this.mDropDownList;
      View view = this.mPromptView;
      if (view != null) {
        StringBuilder stringBuilder;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        switch (this.mPromptPosition) {
          default:
            stringBuilder = new StringBuilder("Invalid hint position ");
            stringBuilder.append(this.mPromptPosition);
            Log.e("ListPopupWindow", stringBuilder.toString());
            break;
          case 1:
            linearLayout.addView((View)stringBuilder, (ViewGroup.LayoutParams)layoutParams);
            linearLayout.addView(view);
            break;
          case 0:
            linearLayout.addView(view);
            linearLayout.addView((View)stringBuilder, (ViewGroup.LayoutParams)layoutParams);
            break;
        } 
        if (this.mDropDownWidth >= 0) {
          i = this.mDropDownWidth;
          j = Integer.MIN_VALUE;
        } else {
          i = 0;
          j = 0;
        } 
        view.measure(View.MeasureSpec.makeMeasureSpec(i, j), 0);
        layoutParams2 = (LinearLayout.LayoutParams)view.getLayoutParams();
        i = view.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
      } else {
        i = 0;
        layoutParams1 = layoutParams2;
      } 
      this.mPopup.setContentView((View)layoutParams1);
    } else {
      this.mPopup.getContentView();
      View view = this.mPromptView;
      if (view != null) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
        i = view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
      } else {
        i = 0;
      } 
    } 
    Drawable drawable = this.mPopup.getBackground();
    if (drawable != null) {
      drawable.getPadding(this.mTempRect);
      j = this.mTempRect.top + this.mTempRect.bottom;
      k = j;
      if (!this.mDropDownVerticalOffsetSet) {
        this.mDropDownVerticalOffset = -this.mTempRect.top;
        k = j;
      } 
    } else {
      this.mTempRect.setEmpty();
      k = 0;
    } 
    if (this.mPopup.getInputMethodMode() == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    int m = getMaxAvailableHeight(this.mDropDownAnchorView, this.mDropDownVerticalOffset, bool);
    if (this.mDropDownAlwaysVisible || this.mDropDownHeight == -1) {
      i = m + k;
    } else {
      switch (this.mDropDownWidth) {
        default:
          j = View.MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
          break;
        case -1:
          j = View.MeasureSpec.makeMeasureSpec((this.mContext.getResources().getDisplayMetrics()).widthPixels - this.mTempRect.left + this.mTempRect.right, 1073741824);
          break;
        case -2:
          j = View.MeasureSpec.makeMeasureSpec((this.mContext.getResources().getDisplayMetrics()).widthPixels - this.mTempRect.left + this.mTempRect.right, -2147483648);
          break;
      } 
      m = this.mDropDownList.measureHeightOfChildrenCompat$2e71581f(j, m - i, -1);
      j = i;
      if (m > 0)
        j = i + k + this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom(); 
      i = m + j;
    } 
    boolean bool = isInputMethodNotNeeded();
    PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
    if (this.mPopup.isShowing()) {
      if (!ViewCompat.isAttachedToWindow(this.mDropDownAnchorView))
        return; 
      if (this.mDropDownWidth == -1) {
        j = -1;
      } else if (this.mDropDownWidth == -2) {
        j = this.mDropDownAnchorView.getWidth();
      } else {
        j = this.mDropDownWidth;
      } 
      if (this.mDropDownHeight == -1) {
        if (!bool)
          i = -1; 
        if (bool) {
          PopupWindow popupWindow2 = this.mPopup;
          if (this.mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          } 
          popupWindow2.setWidth(k);
          this.mPopup.setHeight(0);
        } else {
          PopupWindow popupWindow2 = this.mPopup;
          if (this.mDropDownWidth == -1) {
            k = -1;
          } else {
            k = 0;
          } 
          popupWindow2.setWidth(k);
          this.mPopup.setHeight(-1);
        } 
      } else if (this.mDropDownHeight != -2) {
        i = this.mDropDownHeight;
      } 
      PopupWindow popupWindow1 = this.mPopup;
      if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
        bool = bool1;
      } else {
        bool = false;
      } 
      popupWindow1.setOutsideTouchable(bool);
      popupWindow1 = this.mPopup;
      View view = this.mDropDownAnchorView;
      k = this.mDropDownHorizontalOffset;
      m = this.mDropDownVerticalOffset;
      if (j < 0)
        j = -1; 
      if (i < 0)
        i = -1; 
      popupWindow1.update(view, k, m, j, i);
      return;
    } 
    if (this.mDropDownWidth == -1) {
      j = -1;
    } else if (this.mDropDownWidth == -2) {
      j = this.mDropDownAnchorView.getWidth();
    } else {
      j = this.mDropDownWidth;
    } 
    if (this.mDropDownHeight == -1) {
      i = -1;
    } else if (this.mDropDownHeight != -2) {
      i = this.mDropDownHeight;
    } 
    this.mPopup.setWidth(j);
    this.mPopup.setHeight(i);
    if (sClipToWindowEnabledMethod != null)
      try {
        sClipToWindowEnabledMethod.invoke(this.mPopup, new Object[] { Boolean.valueOf(true) });
      } catch (Exception exception) {
        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
      }  
    PopupWindow popupWindow = this.mPopup;
    if (!this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible) {
      bool = true;
    } else {
      bool = false;
    } 
    popupWindow.setOutsideTouchable(bool);
    this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
    if (this.mOverlapAnchorSet)
      PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor); 
    if (sSetEpicenterBoundsMethod != null)
      try {
        sSetEpicenterBoundsMethod.invoke(this.mPopup, new Object[] { this.mEpicenterBounds });
      } catch (Exception exception) {
        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", exception);
      }  
    PopupWindowCompat.showAsDropDown(this.mPopup, this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
    this.mDropDownList.setSelection(-1);
    if (!this.mModal || this.mDropDownList.isInTouchMode())
      clearListSelection(); 
    if (!this.mModal)
      this.mHandler.post(this.mHideSelector); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */