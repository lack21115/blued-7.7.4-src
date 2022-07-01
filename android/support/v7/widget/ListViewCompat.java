package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
  Field mIsChildViewEnabled;
  
  protected int mMotionPosition;
  
  int mSelectionBottomPadding = 0;
  
  int mSelectionLeftPadding = 0;
  
  int mSelectionRightPadding = 0;
  
  int mSelectionTopPadding = 0;
  
  private ListViewCompat$GateKeeperDrawable mSelector;
  
  Rect mSelectorRect = new Rect();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    try {
      this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled.setAccessible(true);
      return;
    } catch (NoSuchFieldException noSuchFieldException) {
      ThrowableExtension.printStackTrace(noSuchFieldException);
      return;
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    if (!this.mSelectorRect.isEmpty()) {
      Drawable drawable = getSelector();
      if (drawable != null) {
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(paramCanvas);
      } 
    } 
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    boolean bool = true;
    setSelectorEnabled(true);
    Drawable drawable = getSelector();
    if (drawable != null) {
      if (!touchModeDrawsInPressedStateCompat() || !isPressed())
        bool = false; 
      if (bool)
        drawable.setState(getDrawableState()); 
    } 
  }
  
  public final int measureHeightOfChildrenCompat$2e71581f(int paramInt1, int paramInt2, int paramInt3) {
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Drawable drawable = getDivider();
    ListAdapter listAdapter = getAdapter();
    if (listAdapter == null)
      return i + k; 
    if (j <= 0 || drawable == null)
      j = 0; 
    int i1 = listAdapter.getCount();
    i += k;
    drawable = null;
    int m = 0;
    int n = 0;
    for (k = 0; m < i1; k = i3) {
      int i3 = listAdapter.getItemViewType(m);
      int i2 = n;
      if (i3 != n) {
        drawable = null;
        i2 = i3;
      } 
      View view2 = listAdapter.getView(m, (View)drawable, (ViewGroup)this);
      ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
      ViewGroup.LayoutParams layoutParams1 = layoutParams2;
      if (layoutParams2 == null) {
        layoutParams1 = generateDefaultLayoutParams();
        view2.setLayoutParams(layoutParams1);
      } 
      if (layoutParams1.height > 0) {
        n = View.MeasureSpec.makeMeasureSpec(layoutParams1.height, 1073741824);
      } else {
        n = View.MeasureSpec.makeMeasureSpec(0, 0);
      } 
      view2.measure(paramInt1, n);
      view2.forceLayout();
      n = i;
      if (m > 0)
        n = i + j; 
      i = n + view2.getMeasuredHeight();
      if (i >= paramInt2)
        return (paramInt3 >= 0 && m > paramInt3 && k > 0 && i != paramInt2) ? k : paramInt2; 
      i3 = k;
      if (paramInt3 >= 0) {
        i3 = k;
        if (m >= paramInt3)
          i3 = i; 
      } 
      m++;
      n = i2;
      View view1 = view2;
    } 
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0)
      this.mMotionPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()); 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setSelector(Drawable paramDrawable) {
    ListViewCompat$GateKeeperDrawable listViewCompat$GateKeeperDrawable;
    if (paramDrawable != null) {
      listViewCompat$GateKeeperDrawable = new ListViewCompat$GateKeeperDrawable(paramDrawable);
    } else {
      listViewCompat$GateKeeperDrawable = null;
    } 
    this.mSelector = listViewCompat$GateKeeperDrawable;
    super.setSelector((Drawable)this.mSelector);
    Rect rect = new Rect();
    if (paramDrawable != null)
      paramDrawable.getPadding(rect); 
    this.mSelectionLeftPadding = rect.left;
    this.mSelectionTopPadding = rect.top;
    this.mSelectionRightPadding = rect.right;
    this.mSelectionBottomPadding = rect.bottom;
  }
  
  protected final void setSelectorEnabled(boolean paramBoolean) {
    if (this.mSelector != null)
      this.mSelector.mEnabled = paramBoolean; 
  }
  
  protected boolean touchModeDrawsInPressedStateCompat() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ListViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */