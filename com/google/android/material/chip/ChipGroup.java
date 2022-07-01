package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.List;

public class ChipGroup extends FlowLayout {
  private static final int a = R.style.Widget_MaterialComponents_ChipGroup;
  
  private int b;
  
  private int c;
  
  private boolean d;
  
  private boolean e;
  
  private OnCheckedChangeListener f;
  
  private final CheckedStateTracker g = new CheckedStateTracker();
  
  private PassThroughHierarchyChangeListener h = new PassThroughHierarchyChangeListener();
  
  private int i = -1;
  
  private boolean j = false;
  
  public ChipGroup(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    TypedArray typedArray = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.ChipGroup, paramInt, a, new int[0]);
    paramInt = typedArray.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(typedArray.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(typedArray.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(typedArray.getBoolean(R.styleable.ChipGroup_singleLine, false));
    setSingleSelection(typedArray.getBoolean(R.styleable.ChipGroup_singleSelection, false));
    setSelectionRequired(typedArray.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
    paramInt = typedArray.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
    if (paramInt != -1)
      this.i = paramInt; 
    typedArray.recycle();
    super.setOnHierarchyChangeListener(this.h);
    ViewCompat.setImportantForAccessibility((View)this, 1);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    this.i = paramInt;
    OnCheckedChangeListener onCheckedChangeListener = this.f;
    if (onCheckedChangeListener != null && this.d && paramBoolean)
      onCheckedChangeListener.a(this, paramInt); 
  }
  
  private void b(int paramInt, boolean paramBoolean) {
    View view = findViewById(paramInt);
    if (view instanceof Chip) {
      this.j = true;
      ((Chip)view).setChecked(paramBoolean);
      this.j = false;
    } 
  }
  
  private int getChipCount() {
    int i = 0;
    int j;
    for (j = 0; i < getChildCount(); j = k) {
      int k = j;
      if (getChildAt(i) instanceof Chip)
        k = j + 1; 
      i++;
    } 
    return j;
  }
  
  private void setCheckedId(int paramInt) {
    a(paramInt, true);
  }
  
  int a(View paramView) {
    if (!(paramView instanceof Chip))
      return -1; 
    int i = 0;
    for (int j = 0; i < getChildCount(); j = k) {
      int k = j;
      if (getChildAt(i) instanceof Chip) {
        if ((Chip)getChildAt(i) == paramView)
          return j; 
        k = j + 1;
      } 
      i++;
    } 
    return -1;
  }
  
  public void a() {
    this.j = true;
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view instanceof Chip)
        ((Chip)view).setChecked(false); 
    } 
    this.j = false;
    setCheckedId(-1);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (paramView instanceof Chip) {
      Chip chip = (Chip)paramView;
      if (chip.isChecked()) {
        int i = this.i;
        if (i != -1 && this.d)
          b(i, false); 
        setCheckedId(chip.getId());
      } 
    } 
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean b() {
    return super.b();
  }
  
  public boolean c() {
    return this.d;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (super.checkLayoutParams(paramLayoutParams) && paramLayoutParams instanceof LayoutParams);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public int getCheckedChipId() {
    return this.d ? this.i : -1;
  }
  
  public List<Integer> getCheckedChipIds() {
    ArrayList<Integer> arrayList = new ArrayList();
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view instanceof Chip && ((Chip)view).isChecked()) {
        arrayList.add(Integer.valueOf(view.getId()));
        if (this.d)
          return arrayList; 
      } 
    } 
    return arrayList;
  }
  
  public int getChipSpacingHorizontal() {
    return this.b;
  }
  
  public int getChipSpacingVertical() {
    return this.c;
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    int i = this.i;
    if (i != -1) {
      b(i, true);
      setCheckedId(this.i);
    } 
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    byte b;
    byte b1;
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    if (b()) {
      b = getChipCount();
    } else {
      b = -1;
    } 
    int i = getRowCount();
    if (c()) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, b, false, b1));
  }
  
  public void setChipSpacing(int paramInt) {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(int paramInt) {
    if (this.b != paramInt) {
      this.b = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    } 
  }
  
  public void setChipSpacingHorizontalResource(int paramInt) {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(int paramInt) {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(int paramInt) {
    if (this.c != paramInt) {
      this.c = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    } 
  }
  
  public void setChipSpacingVerticalResource(int paramInt) {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  @Deprecated
  public void setDividerDrawableHorizontal(Drawable paramDrawable) {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setDividerDrawableVertical(Drawable paramDrawable) {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setFlexWrap(int paramInt) {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener) {
    this.f = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener) {
    PassThroughHierarchyChangeListener.a(this.h, paramOnHierarchyChangeListener);
  }
  
  public void setSelectionRequired(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  @Deprecated
  public void setShowDividerHorizontal(int paramInt) {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  @Deprecated
  public void setShowDividerVertical(int paramInt) {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(int paramInt) {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleLine(boolean paramBoolean) {
    super.setSingleLine(paramBoolean);
  }
  
  public void setSingleSelection(int paramInt) {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean) {
    if (this.d != paramBoolean) {
      this.d = paramBoolean;
      a();
    } 
  }
  
  class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
    private CheckedStateTracker(ChipGroup this$0) {}
    
    public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
      if (ChipGroup.a(this.a))
        return; 
      if (this.a.getCheckedChipIds().isEmpty() && ChipGroup.b(this.a)) {
        ChipGroup.a(this.a, param1CompoundButton.getId(), true);
        ChipGroup.b(this.a, param1CompoundButton.getId(), false);
        return;
      } 
      int i = param1CompoundButton.getId();
      if (param1Boolean) {
        if (ChipGroup.c(this.a) != -1 && ChipGroup.c(this.a) != i && ChipGroup.d(this.a)) {
          ChipGroup chipGroup = this.a;
          ChipGroup.a(chipGroup, ChipGroup.c(chipGroup), false);
        } 
        ChipGroup.a(this.a, i);
        return;
      } 
      if (ChipGroup.c(this.a) == i)
        ChipGroup.a(this.a, -1); 
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
  }
  
  public static interface OnCheckedChangeListener {
    void a(ChipGroup param1ChipGroup, int param1Int);
  }
  
  class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
    private ViewGroup.OnHierarchyChangeListener b;
    
    private PassThroughHierarchyChangeListener(ChipGroup this$0) {}
    
    public void onChildViewAdded(View param1View1, View param1View2) {
      if (param1View1 == this.a && param1View2 instanceof Chip) {
        if (param1View2.getId() == -1) {
          int i;
          if (Build.VERSION.SDK_INT >= 17) {
            i = View.generateViewId();
          } else {
            i = param1View2.hashCode();
          } 
          param1View2.setId(i);
        } 
        ((Chip)param1View2).setOnCheckedChangeListenerInternal(ChipGroup.e(this.a));
      } 
      ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.b;
      if (onHierarchyChangeListener != null)
        onHierarchyChangeListener.onChildViewAdded(param1View1, param1View2); 
    }
    
    public void onChildViewRemoved(View param1View1, View param1View2) {
      if (param1View1 == this.a && param1View2 instanceof Chip)
        ((Chip)param1View2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener)null); 
      ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.b;
      if (onHierarchyChangeListener != null)
        onHierarchyChangeListener.onChildViewRemoved(param1View1, param1View2); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\chip\ChipGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */