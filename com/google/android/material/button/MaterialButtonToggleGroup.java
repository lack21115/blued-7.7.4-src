package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
  private static final String a = MaterialButtonToggleGroup.class.getSimpleName();
  
  private static final int b = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
  
  private final List<CornerData> c = new ArrayList<CornerData>();
  
  private final CheckedStateTracker d = new CheckedStateTracker();
  
  private final PressedStateTracker e = new PressedStateTracker();
  
  private final LinkedHashSet<OnButtonCheckedListener> f = new LinkedHashSet<OnButtonCheckedListener>();
  
  private final Comparator<MaterialButton> g = new Comparator<MaterialButton>(this) {
      public int a(MaterialButton param1MaterialButton1, MaterialButton param1MaterialButton2) {
        int i = Boolean.valueOf(param1MaterialButton1.isChecked()).compareTo(Boolean.valueOf(param1MaterialButton2.isChecked()));
        if (i != 0)
          return i; 
        i = Boolean.valueOf(param1MaterialButton1.isPressed()).compareTo(Boolean.valueOf(param1MaterialButton2.isPressed()));
        return (i != 0) ? i : Integer.valueOf(this.a.indexOfChild((View)param1MaterialButton1)).compareTo(Integer.valueOf(this.a.indexOfChild((View)param1MaterialButton2)));
      }
    };
  
  private Integer[] h;
  
  private boolean i = false;
  
  private boolean j;
  
  private boolean k;
  
  private int l;
  
  public MaterialButtonToggleGroup(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.materialButtonToggleGroupStyle);
  }
  
  public MaterialButtonToggleGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, b), paramAttributeSet, paramInt);
    TypedArray typedArray = ThemeEnforcement.a(getContext(), paramAttributeSet, R.styleable.MaterialButtonToggleGroup, paramInt, b, new int[0]);
    setSingleSelection(typedArray.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
    this.l = typedArray.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
    this.k = typedArray.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
    setChildrenDrawingOrderEnabled(true);
    typedArray.recycle();
    ViewCompat.setImportantForAccessibility((View)this, 1);
  }
  
  private int a(View paramView) {
    if (!(paramView instanceof MaterialButton))
      return -1; 
    int i = 0;
    for (int j = 0; i < getChildCount(); j = k) {
      if (getChildAt(i) == paramView)
        return j; 
      int k = j;
      if (getChildAt(i) instanceof MaterialButton) {
        k = j;
        if (c(i))
          k = j + 1; 
      } 
      i++;
    } 
    return -1;
  }
  
  private MaterialButton a(int paramInt) {
    return (MaterialButton)getChildAt(paramInt);
  }
  
  private CornerData a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    CornerData cornerData = this.c.get(paramInt1);
    if (paramInt2 == paramInt3)
      return cornerData; 
    if (getOrientation() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return (paramInt1 == paramInt2) ? (bool ? CornerData.a(cornerData, (View)this) : CornerData.c(cornerData)) : ((paramInt1 == paramInt3) ? (bool ? CornerData.b(cornerData, (View)this) : CornerData.d(cornerData)) : null);
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    View view = findViewById(paramInt);
    if (view instanceof MaterialButton) {
      this.i = true;
      ((MaterialButton)view).setChecked(paramBoolean);
      this.i = false;
    } 
  }
  
  private static void a(ShapeAppearanceModel.Builder paramBuilder, CornerData paramCornerData) {
    if (paramCornerData == null) {
      paramBuilder.a(0.0F);
      return;
    } 
    paramBuilder.a(paramCornerData.a).d(paramCornerData.d).b(paramCornerData.b).c(paramCornerData.c);
  }
  
  private LinearLayout.LayoutParams b(View paramView) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    return (layoutParams instanceof LinearLayout.LayoutParams) ? (LinearLayout.LayoutParams)layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
  }
  
  private void b(int paramInt) {
    if (getChildCount() != 0) {
      if (paramInt == -1)
        return; 
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)a(paramInt).getLayoutParams();
      if (getOrientation() == 1) {
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        return;
      } 
      MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)layoutParams, 0);
      MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)layoutParams, 0);
      layoutParams.leftMargin = 0;
      layoutParams.rightMargin = 0;
    } 
  }
  
  private boolean b(int paramInt, boolean paramBoolean) {
    List<Integer> list = getCheckedButtonIds();
    if (this.k && list.isEmpty()) {
      a(paramInt, true);
      this.l = paramInt;
      return false;
    } 
    if (paramBoolean && this.j) {
      list.remove(Integer.valueOf(paramInt));
      Iterator<Integer> iterator = list.iterator();
      while (iterator.hasNext()) {
        paramInt = ((Integer)iterator.next()).intValue();
        a(paramInt, false);
        c(paramInt, false);
      } 
    } 
    return true;
  }
  
  private void c(int paramInt, boolean paramBoolean) {
    Iterator<OnButtonCheckedListener> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((OnButtonCheckedListener)iterator.next()).a(this, paramInt, paramBoolean); 
  }
  
  private boolean c(int paramInt) {
    return (getChildAt(paramInt).getVisibility() != 8);
  }
  
  private void d() {
    int j = getFirstVisibleChildIndex();
    if (j == -1)
      return; 
    for (int i = j + 1; i < getChildCount(); i++) {
      MaterialButton materialButton1 = a(i);
      MaterialButton materialButton2 = a(i - 1);
      int k = Math.min(materialButton1.getStrokeWidth(), materialButton2.getStrokeWidth());
      LinearLayout.LayoutParams layoutParams = b((View)materialButton1);
      if (getOrientation() == 0) {
        MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams)layoutParams, 0);
        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams)layoutParams, -k);
      } else {
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = -k;
      } 
      materialButton1.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    b(j);
  }
  
  private void d(int paramInt) {
    a(paramInt, true);
    b(paramInt, true);
    setCheckedId(paramInt);
  }
  
  private void e() {
    TreeMap<MaterialButton, Object> treeMap = new TreeMap<MaterialButton, Object>(this.g);
    int j = getChildCount();
    for (int i = 0; i < j; i++)
      treeMap.put(a(i), Integer.valueOf(i)); 
    this.h = (Integer[])treeMap.values().toArray((Object[])new Integer[0]);
  }
  
  private int getFirstVisibleChildIndex() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      if (c(i))
        return i; 
    } 
    return -1;
  }
  
  private int getLastVisibleChildIndex() {
    for (int i = getChildCount() - 1; i >= 0; i--) {
      if (c(i))
        return i; 
    } 
    return -1;
  }
  
  private int getVisibleButtonCount() {
    int i = 0;
    int j;
    for (j = 0; i < getChildCount(); j = k) {
      int k = j;
      if (getChildAt(i) instanceof MaterialButton) {
        k = j;
        if (c(i))
          k = j + 1; 
      } 
      i++;
    } 
    return j;
  }
  
  private void setCheckedId(int paramInt) {
    this.l = paramInt;
    c(paramInt, true);
  }
  
  private void setGeneratedIdIfNeeded(MaterialButton paramMaterialButton) {
    if (paramMaterialButton.getId() == -1)
      paramMaterialButton.setId(ViewCompat.generateViewId()); 
  }
  
  private void setupButtonChild(MaterialButton paramMaterialButton) {
    paramMaterialButton.setMaxLines(1);
    paramMaterialButton.setEllipsize(TextUtils.TruncateAt.END);
    paramMaterialButton.setCheckable(true);
    paramMaterialButton.a(this.d);
    paramMaterialButton.setOnPressedChangeListenerInternal(this.e);
    paramMaterialButton.setShouldDrawSurfaceColorStroke(true);
  }
  
  public void a() {
    this.i = true;
    for (int i = 0; i < getChildCount(); i++) {
      MaterialButton materialButton = a(i);
      materialButton.setChecked(false);
      c(materialButton.getId(), false);
    } 
    this.i = false;
    setCheckedId(-1);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    if (!(paramView instanceof MaterialButton)) {
      Log.e(a, "Child views must be of type MaterialButton.");
      return;
    } 
    super.addView(paramView, paramInt, paramLayoutParams);
    MaterialButton materialButton = (MaterialButton)paramView;
    setGeneratedIdIfNeeded(materialButton);
    setupButtonChild(materialButton);
    if (materialButton.isChecked()) {
      b(materialButton.getId(), true);
      setCheckedId(materialButton.getId());
    } 
    ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
    this.c.add(new CornerData(shapeAppearanceModel.f(), shapeAppearanceModel.i(), shapeAppearanceModel.g(), shapeAppearanceModel.h()));
    ViewCompat.setAccessibilityDelegate((View)materialButton, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            param1AccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.a(this.a, param1View), 1, false, ((MaterialButton)param1View).isChecked()));
          }
        });
  }
  
  public boolean b() {
    return this.j;
  }
  
  void c() {
    int j = getChildCount();
    int k = getFirstVisibleChildIndex();
    int m = getLastVisibleChildIndex();
    for (int i = 0; i < j; i++) {
      MaterialButton materialButton = a(i);
      if (materialButton.getVisibility() != 8) {
        ShapeAppearanceModel.Builder builder = materialButton.getShapeAppearanceModel().n();
        a(builder, a(i, k, m));
        materialButton.setShapeAppearanceModel(builder.a());
      } 
    } 
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    e();
    super.dispatchDraw(paramCanvas);
  }
  
  public CharSequence getAccessibilityClassName() {
    return MaterialButtonToggleGroup.class.getName();
  }
  
  public int getCheckedButtonId() {
    return this.j ? this.l : -1;
  }
  
  public List<Integer> getCheckedButtonIds() {
    ArrayList<Integer> arrayList = new ArrayList();
    for (int i = 0; i < getChildCount(); i++) {
      MaterialButton materialButton = a(i);
      if (materialButton.isChecked())
        arrayList.add(Integer.valueOf(materialButton.getId())); 
    } 
    return arrayList;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    Integer[] arrayOfInteger = this.h;
    if (arrayOfInteger == null || paramInt2 >= arrayOfInteger.length) {
      Log.w(a, "Child order wasn't updated");
      return paramInt2;
    } 
    return arrayOfInteger[paramInt2].intValue();
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    int i = this.l;
    if (i != -1)
      d(i); 
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    byte b;
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo);
    int i = getVisibleButtonCount();
    if (b()) {
      b = 1;
    } else {
      b = 2;
    } 
    accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, i, false, b));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    c();
    d();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onViewRemoved(View paramView) {
    super.onViewRemoved(paramView);
    if (paramView instanceof MaterialButton) {
      MaterialButton materialButton = (MaterialButton)paramView;
      materialButton.b(this.d);
      materialButton.setOnPressedChangeListenerInternal((MaterialButton.OnPressedChangeListener)null);
    } 
    int i = indexOfChild(paramView);
    if (i >= 0)
      this.c.remove(i); 
    c();
    d();
  }
  
  public void setSelectionRequired(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void setSingleSelection(int paramInt) {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean) {
    if (this.j != paramBoolean) {
      this.j = paramBoolean;
      a();
    } 
  }
  
  class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
    private CheckedStateTracker(MaterialButtonToggleGroup this$0) {}
    
    public void a(MaterialButton param1MaterialButton, boolean param1Boolean) {
      if (MaterialButtonToggleGroup.a(this.a))
        return; 
      if (MaterialButtonToggleGroup.b(this.a)) {
        byte b;
        MaterialButtonToggleGroup materialButtonToggleGroup = this.a;
        if (param1Boolean) {
          b = param1MaterialButton.getId();
        } else {
          b = -1;
        } 
        MaterialButtonToggleGroup.a(materialButtonToggleGroup, b);
      } 
      if (MaterialButtonToggleGroup.a(this.a, param1MaterialButton.getId(), param1Boolean))
        MaterialButtonToggleGroup.b(this.a, param1MaterialButton.getId(), param1MaterialButton.isChecked()); 
      this.a.invalidate();
    }
  }
  
  static class CornerData {
    private static final CornerSize e = (CornerSize)new AbsoluteCornerSize(0.0F);
    
    CornerSize a;
    
    CornerSize b;
    
    CornerSize c;
    
    CornerSize d;
    
    CornerData(CornerSize param1CornerSize1, CornerSize param1CornerSize2, CornerSize param1CornerSize3, CornerSize param1CornerSize4) {
      this.a = param1CornerSize1;
      this.b = param1CornerSize3;
      this.c = param1CornerSize4;
      this.d = param1CornerSize2;
    }
    
    public static CornerData a(CornerData param1CornerData) {
      CornerSize cornerSize2 = param1CornerData.a;
      CornerSize cornerSize1 = param1CornerData.d;
      CornerSize cornerSize3 = e;
      return new CornerData(cornerSize2, cornerSize1, cornerSize3, cornerSize3);
    }
    
    public static CornerData a(CornerData param1CornerData, View param1View) {
      return ViewUtils.a(param1View) ? b(param1CornerData) : a(param1CornerData);
    }
    
    public static CornerData b(CornerData param1CornerData) {
      CornerSize cornerSize = e;
      return new CornerData(cornerSize, cornerSize, param1CornerData.b, param1CornerData.c);
    }
    
    public static CornerData b(CornerData param1CornerData, View param1View) {
      return ViewUtils.a(param1View) ? a(param1CornerData) : b(param1CornerData);
    }
    
    public static CornerData c(CornerData param1CornerData) {
      CornerSize cornerSize1 = param1CornerData.a;
      CornerSize cornerSize2 = e;
      return new CornerData(cornerSize1, cornerSize2, param1CornerData.b, cornerSize2);
    }
    
    public static CornerData d(CornerData param1CornerData) {
      CornerSize cornerSize = e;
      return new CornerData(cornerSize, param1CornerData.d, cornerSize, param1CornerData.c);
    }
  }
  
  public static interface OnButtonCheckedListener {
    void a(MaterialButtonToggleGroup param1MaterialButtonToggleGroup, int param1Int, boolean param1Boolean);
  }
  
  class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
    private PressedStateTracker(MaterialButtonToggleGroup this$0) {}
    
    public void a(MaterialButton param1MaterialButton, boolean param1Boolean) {
      this.a.invalidate();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\button\MaterialButtonToggleGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */