package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class AlertDialogLayout extends LinearLayoutCompat {
  public AlertDialogLayout(Context paramContext) {
    super(paramContext);
  }
  
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int n = getChildCount();
    int i1 = this.mGravity;
    paramInt3 = i1 & 0x70;
    if (paramInt3 != 16) {
      if (paramInt3 != 80) {
        paramInt1 = getPaddingTop();
      } else {
        paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      } 
    } else {
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - paramInt1) / 2;
    } 
    Drawable drawable = this.mDivider;
    paramInt4 = 0;
    if (drawable == null) {
      paramInt3 = 0;
    } else {
      paramInt3 = drawable.getIntrinsicHeight();
    } 
    while (paramInt4 < n) {
      View view = getChildAt(paramInt4);
      paramInt2 = paramInt1;
      if (view != null) {
        paramInt2 = paramInt1;
        if (view.getVisibility() != 8) {
          int i3 = view.getMeasuredWidth();
          int i4 = view.getMeasuredHeight();
          LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view.getLayoutParams();
          int i2 = linearLayoutCompat$LayoutParams.gravity;
          paramInt2 = i2;
          if (i2 < 0)
            paramInt2 = i1 & 0x800007; 
          paramInt2 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection((View)this)) & 0x7;
          if (paramInt2 != 1) {
            if (paramInt2 != 5) {
              paramInt2 = linearLayoutCompat$LayoutParams.leftMargin + i;
            } else {
              paramInt2 = j - k - i3 - linearLayoutCompat$LayoutParams.rightMargin;
            } 
          } else {
            paramInt2 = (j - i - m - i3) / 2 + i + linearLayoutCompat$LayoutParams.leftMargin - linearLayoutCompat$LayoutParams.rightMargin;
          } 
          i2 = paramInt1;
          if (hasDividerBeforeChildAt(paramInt4))
            i2 = paramInt1 + paramInt3; 
          paramInt1 = i2 + linearLayoutCompat$LayoutParams.topMargin;
          view.layout(paramInt2, paramInt1, i3 + paramInt2, paramInt1 + i4);
          paramInt2 = paramInt1 + i4 + linearLayoutCompat$LayoutParams.bottomMargin;
        } 
      } 
      paramInt4++;
      paramInt1 = paramInt2;
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i1;
    byte b;
    int i4 = getChildCount();
    int j = 0;
    View view3 = null;
    View view1 = view3;
    View view2 = view1;
    int i = 0;
    while (i < i4) {
      View view4 = getChildAt(i);
      View view5 = view3;
      View view6 = view1;
      View view7 = view2;
      if (view4.getVisibility() != 8) {
        int i7 = view4.getId();
        if (i7 == R.id.topPanel) {
          view5 = view4;
          view6 = view1;
          view7 = view2;
        } else if (i7 == R.id.buttonPanel) {
          view5 = view3;
          view6 = view4;
          view7 = view2;
        } else {
          if ((i7 != R.id.contentPanel && i7 != R.id.customPanel) || view2 != null) {
            i = j;
            // Byte code: goto -> 774
          } 
          view7 = view4;
          view6 = view1;
          view5 = view3;
        } 
      } 
      i++;
      view3 = view5;
      view1 = view6;
      view2 = view7;
    } 
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt1);
    int k = getPaddingTop() + getPaddingBottom();
    if (view3 != null) {
      view3.measure(paramInt1, 0);
      k += view3.getMeasuredHeight();
      j = View.combineMeasuredStates(0, view3.getMeasuredState());
    } else {
      j = 0;
    } 
    if (view1 != null) {
      view1.measure(paramInt1, 0);
      View view = view1;
      while (true) {
        i = ViewCompat.getMinimumHeight(view);
        if (i > 0)
          break; 
        if (view instanceof ViewGroup) {
          ViewGroup viewGroup = (ViewGroup)view;
          if (viewGroup.getChildCount() == 1) {
            View view4 = viewGroup.getChildAt(0);
            continue;
          } 
        } 
        i = 0;
        break;
      } 
      i1 = view1.getMeasuredHeight() - i;
      k += i;
      j = View.combineMeasuredStates(j, view1.getMeasuredState());
    } else {
      i1 = 0;
      i = 0;
    } 
    if (view2 != null) {
      int i7;
      if (i6 == 0) {
        i7 = 0;
      } else {
        i7 = View.MeasureSpec.makeMeasureSpec(Math.max(0, n - k), i6);
      } 
      view2.measure(paramInt1, i7);
      b = view2.getMeasuredHeight();
      k += b;
      j = View.combineMeasuredStates(j, view2.getMeasuredState());
    } else {
      b = 0;
    } 
    int i2 = n - k;
    n = j;
    int i3 = i2;
    int m = k;
    if (view1 != null) {
      i1 = Math.min(i2, i1);
      n = i2;
      m = i;
      if (i1 > 0) {
        n = i2 - i1;
        m = i + i1;
      } 
      view1.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(m, 1073741824));
      m = k - i + view1.getMeasuredHeight();
      i = View.combineMeasuredStates(j, view1.getMeasuredState());
      i3 = n;
      n = i;
    } 
    j = n;
    i = m;
    if (view2 != null) {
      j = n;
      i = m;
      if (i3 > 0) {
        view2.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(b + i3, i6));
        i = m - b + view2.getMeasuredHeight();
        j = View.combineMeasuredStates(n, view2.getMeasuredState());
      } 
    } 
    k = 0;
    for (m = 0; k < i4; m = n) {
      view1 = getChildAt(k);
      n = m;
      if (view1.getVisibility() != 8)
        n = Math.max(m, view1.getMeasuredWidth()); 
      k++;
    } 
    setMeasuredDimension(View.resolveSizeAndState(m + getPaddingLeft() + getPaddingRight(), paramInt1, j), View.resolveSizeAndState(i, paramInt2, 0));
    if (i5 != 1073741824) {
      j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
      for (i = 0; i < i4; i++) {
        view1 = getChildAt(i);
        if (view1.getVisibility() != 8) {
          LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = (LinearLayoutCompat$LayoutParams)view1.getLayoutParams();
          if (linearLayoutCompat$LayoutParams.width == -1) {
            k = linearLayoutCompat$LayoutParams.height;
            linearLayoutCompat$LayoutParams.height = view1.getMeasuredHeight();
            measureChildWithMargins(view1, j, 0, paramInt2, 0);
            linearLayoutCompat$LayoutParams.height = k;
          } 
        } 
      } 
    } 
    i = 1;
    if (i == 0)
      super.onMeasure(paramInt1, paramInt2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AlertDialogLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */