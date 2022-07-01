package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;

final class MaterialCalendarGridView extends GridView {
  private final Calendar a = UtcDates.c();
  
  public MaterialCalendarGridView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialCalendarGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (MaterialDatePicker.a(getContext())) {
      setNextFocusLeftId(R.id.cancel_button);
      setNextFocusRightId(R.id.confirm_button);
    } 
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            param1AccessibilityNodeInfoCompat.setCollectionInfo(null);
          }
        });
  }
  
  private static int a(View paramView) {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private void a(int paramInt, Rect paramRect) {
    if (paramInt == 33) {
      setSelection(a().b());
      return;
    } 
    if (paramInt == 130) {
      setSelection(a().a());
      return;
    } 
    super.onFocusChanged(true, paramInt, paramRect);
  }
  
  private static boolean a(Long paramLong1, Long paramLong2, Long paramLong3, Long paramLong4) {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramLong1 != null) {
      bool1 = bool2;
      if (paramLong2 != null) {
        bool1 = bool2;
        if (paramLong3 != null) {
          if (paramLong4 == null)
            return true; 
          bool1 = bool2;
          if (paramLong3.longValue() <= paramLong2.longValue()) {
            if (paramLong4.longValue() < paramLong1.longValue())
              return true; 
            bool1 = false;
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public MonthAdapter a() {
    return (MonthAdapter)super.getAdapter();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    a().notifyDataSetChanged();
  }
  
  protected final void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    MonthAdapter monthAdapter = a();
    DateSelector<?> dateSelector = monthAdapter.c;
    CalendarStyle calendarStyle = monthAdapter.d;
    Long long_1 = monthAdapter.a(monthAdapter.a());
    Long long_2 = monthAdapter.a(monthAdapter.b());
    Iterator<Pair<Long, Long>> iterator = dateSelector.d().iterator();
    while (true) {
      MaterialCalendarGridView materialCalendarGridView = this;
      if (iterator.hasNext()) {
        int i;
        int j;
        int k;
        int m;
        Pair pair = iterator.next();
        if (pair.first == null || pair.second == null)
          continue; 
        long l1 = ((Long)pair.first).longValue();
        long l2 = ((Long)pair.second).longValue();
        if (a(long_1, long_2, Long.valueOf(l1), Long.valueOf(l2)))
          return; 
        if (l1 < long_1.longValue()) {
          k = monthAdapter.a();
          if (monthAdapter.e(k)) {
            i = 0;
          } else {
            i = materialCalendarGridView.getChildAt(k - 1).getRight();
          } 
        } else {
          materialCalendarGridView.a.setTimeInMillis(l1);
          k = monthAdapter.c(materialCalendarGridView.a.get(5));
          i = a(materialCalendarGridView.getChildAt(k));
        } 
        if (l2 > long_2.longValue()) {
          m = Math.min(monthAdapter.b(), getChildCount() - 1);
          if (monthAdapter.f(m)) {
            j = getWidth();
          } else {
            j = materialCalendarGridView.getChildAt(m).getRight();
          } 
        } else {
          materialCalendarGridView.a.setTimeInMillis(l2);
          m = monthAdapter.c(materialCalendarGridView.a.get(5));
          j = a(materialCalendarGridView.getChildAt(m));
        } 
        int n = (int)monthAdapter.getItemId(k);
        int i1 = (int)monthAdapter.getItemId(m);
        while (n <= i1) {
          int i2;
          int i3 = getNumColumns() * n;
          int i8 = getNumColumns();
          View view = getChildAt(i3);
          int i4 = view.getTop();
          int i5 = calendarStyle.a.a();
          int i6 = view.getBottom();
          int i7 = calendarStyle.a.b();
          if (i3 > k) {
            i2 = 0;
          } else {
            i2 = i;
          } 
          if (m > i8 + i3 - 1) {
            i3 = getWidth();
          } else {
            i3 = j;
          } 
          paramCanvas.drawRect(i2, (i4 + i5), i3, (i6 - i7), calendarStyle.h);
          n++;
        } 
        continue;
      } 
      break;
    } 
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    if (paramBoolean) {
      a(paramInt, paramRect);
      return;
    } 
    super.onFocusChanged(false, paramInt, paramRect);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (!super.onKeyDown(paramInt, paramKeyEvent))
      return false; 
    if (getSelectedItemPosition() != -1) {
      if (getSelectedItemPosition() >= a().a())
        return true; 
      if (19 == paramInt) {
        setSelection(a().a());
        return true;
      } 
      return false;
    } 
    return true;
  }
  
  public final void setAdapter(ListAdapter paramListAdapter) {
    if (paramListAdapter instanceof MonthAdapter) {
      super.setAdapter(paramListAdapter);
      return;
    } 
    throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[] { MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName() }));
  }
  
  public void setSelection(int paramInt) {
    if (paramInt < a().a()) {
      super.setSelection(a().a());
      return;
    } 
    super.setSelection(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\datepicker\MaterialCalendarGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */