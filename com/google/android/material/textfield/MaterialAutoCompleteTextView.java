package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
  private final ListPopupWindow a;
  
  private final AccessibilityManager b;
  
  private final Rect c = new Rect();
  
  public MaterialAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public MaterialAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = getContext();
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.MaterialAutoCompleteTextView, paramInt, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
    if (typedArray.hasValue(R.styleable.MaterialAutoCompleteTextView_android_inputType) && typedArray.getInt(R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0)
      setKeyListener(null); 
    this.b = (AccessibilityManager)paramContext.getSystemService("accessibility");
    this.a = new ListPopupWindow(paramContext);
    this.a.setModal(true);
    this.a.setAnchorView((View)this);
    this.a.setInputMethodMode(2);
    this.a.setAdapter(getAdapter());
    this.a.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            // Byte code:
            //   0: iload_3
            //   1: ifge -> 18
            //   4: aload_0
            //   5: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   8: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   11: invokevirtual getSelectedItem : ()Ljava/lang/Object;
            //   14: astore_1
            //   15: goto -> 32
            //   18: aload_0
            //   19: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   22: invokevirtual getAdapter : ()Landroid/widget/ListAdapter;
            //   25: iload_3
            //   26: invokeinterface getItem : (I)Ljava/lang/Object;
            //   31: astore_1
            //   32: aload_0
            //   33: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   36: aload_1
            //   37: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;Ljava/lang/Object;)V
            //   40: aload_0
            //   41: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   44: invokevirtual getOnItemClickListener : ()Landroid/widget/AdapterView$OnItemClickListener;
            //   47: astore_1
            //   48: aload_1
            //   49: ifnull -> 119
            //   52: aload_2
            //   53: ifnull -> 63
            //   56: iload_3
            //   57: istore #6
            //   59: iload_3
            //   60: ifge -> 98
            //   63: aload_0
            //   64: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   67: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   70: invokevirtual getSelectedView : ()Landroid/view/View;
            //   73: astore_2
            //   74: aload_0
            //   75: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   78: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   81: invokevirtual getSelectedItemPosition : ()I
            //   84: istore #6
            //   86: aload_0
            //   87: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   90: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   93: invokevirtual getSelectedItemId : ()J
            //   96: lstore #4
            //   98: aload_1
            //   99: aload_0
            //   100: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   103: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   106: invokevirtual getListView : ()Landroid/widget/ListView;
            //   109: aload_2
            //   110: iload #6
            //   112: lload #4
            //   114: invokeinterface onItemClick : (Landroid/widget/AdapterView;Landroid/view/View;IJ)V
            //   119: aload_0
            //   120: getfield a : Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;
            //   123: invokestatic a : (Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;)Landroidx/appcompat/widget/ListPopupWindow;
            //   126: invokevirtual dismiss : ()V
            //   129: return
          }
        });
    typedArray.recycle();
  }
  
  private int a() {
    ListAdapter listAdapter = getAdapter();
    TextInputLayout textInputLayout = b();
    int i = 0;
    if (listAdapter != null) {
      if (textInputLayout == null)
        return 0; 
      int m = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int n = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      int j = Math.max(0, this.a.getSelectedItemPosition());
      int i1 = Math.min(listAdapter.getCount(), j + 15);
      int k = Math.max(0, i1 - 15);
      View view = null;
      j = 0;
      while (k < i1) {
        int i3 = listAdapter.getItemViewType(k);
        int i2 = i;
        if (i3 != i) {
          view = null;
          i2 = i3;
        } 
        view = listAdapter.getView(k, view, (ViewGroup)textInputLayout);
        if (view.getLayoutParams() == null)
          view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2)); 
        view.measure(m, n);
        j = Math.max(j, view.getMeasuredWidth());
        k++;
        i = i2;
      } 
      Drawable drawable = this.a.getBackground();
      k = j;
      if (drawable != null) {
        drawable.getPadding(this.c);
        k = j + this.c.left + this.c.right;
      } 
      return k + textInputLayout.getEndIconView().getMeasuredWidth();
    } 
    return 0;
  }
  
  private <T extends ListAdapter & android.widget.Filterable> void a(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 17) {
      setText(convertSelectionToString(paramObject), false);
      return;
    } 
    ListAdapter listAdapter = getAdapter();
    setAdapter((ListAdapter)null);
    setText(convertSelectionToString(paramObject));
    setAdapter(listAdapter);
  }
  
  private TextInputLayout b() {
    for (ViewParent viewParent = getParent(); viewParent != null; viewParent = viewParent.getParent()) {
      if (viewParent instanceof TextInputLayout)
        return (TextInputLayout)viewParent; 
    } 
    return null;
  }
  
  public CharSequence getHint() {
    TextInputLayout textInputLayout = b();
    return (textInputLayout != null && textInputLayout.a()) ? textInputLayout.getHint() : super.getHint();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    TextInputLayout textInputLayout = b();
    if (textInputLayout != null && textInputLayout.a() && super.getHint() == null && ManufacturerUtils.a())
      setHint(""); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a()), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight()); 
  }
  
  public <T extends ListAdapter & android.widget.Filterable> void setAdapter(T paramT) {
    super.setAdapter((ListAdapter)paramT);
    this.a.setAdapter(getAdapter());
  }
  
  public void showDropDown() {
    if (getInputType() == 0) {
      AccessibilityManager accessibilityManager = this.b;
      if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
        this.a.show();
        return;
      } 
    } 
    super.showDropDown();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\MaterialAutoCompleteTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */