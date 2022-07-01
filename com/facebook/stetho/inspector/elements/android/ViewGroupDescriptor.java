package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.android.FragmentCompatUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

final class ViewGroupDescriptor extends AbstractChainedDescriptor<ViewGroup> implements HighlightableDescriptor<ViewGroup> {
  private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap<View, Object>());
  
  private Object getElement(View paramView, Object paramObject) {
    return (paramObject == this) ? paramView : ((WeakReference)paramObject).get();
  }
  
  private Object getElementForView(ViewGroup paramViewGroup, View paramView) {
    Object object2 = this.mViewToElementMap.get(paramView);
    if (object2 != null) {
      object2 = getElement(paramView, object2);
      if (object2 != null && paramView.getParent() == paramViewGroup)
        return object2; 
      this.mViewToElementMap.remove(paramView);
    } 
    Object object1 = FragmentCompatUtil.findFragmentForView(paramView);
    if (object1 != null && !FragmentCompatUtil.isDialogFragment(object1)) {
      this.mViewToElementMap.put(paramView, new WeakReference(object1));
      return object1;
    } 
    this.mViewToElementMap.put(paramView, this);
    return paramView;
  }
  
  private boolean isChildVisible(View paramView) {
    return paramView instanceof DocumentHiddenView ^ true;
  }
  
  @Nullable
  public Object getElementToHighlightAtPosition(ViewGroup paramViewGroup, int paramInt1, int paramInt2, Rect paramRect) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getChildCount : ()I
    //   4: iconst_1
    //   5: isub
    //   6: istore #5
    //   8: iload #5
    //   10: iflt -> 67
    //   13: aload_1
    //   14: iload #5
    //   16: invokevirtual getChildAt : (I)Landroid/view/View;
    //   19: astore #6
    //   21: aload_0
    //   22: aload #6
    //   24: invokespecial isChildVisible : (Landroid/view/View;)Z
    //   27: ifeq -> 58
    //   30: aload #6
    //   32: invokevirtual getVisibility : ()I
    //   35: ifne -> 58
    //   38: aload #6
    //   40: aload #4
    //   42: invokevirtual getHitRect : (Landroid/graphics/Rect;)V
    //   45: aload #4
    //   47: iload_2
    //   48: iload_3
    //   49: invokevirtual contains : (II)Z
    //   52: ifeq -> 58
    //   55: goto -> 70
    //   58: iload #5
    //   60: iconst_1
    //   61: isub
    //   62: istore #5
    //   64: goto -> 8
    //   67: aconst_null
    //   68: astore #6
    //   70: aload #6
    //   72: ifnull -> 78
    //   75: aload #6
    //   77: areturn
    //   78: aload #4
    //   80: iconst_0
    //   81: iconst_0
    //   82: aload_1
    //   83: invokevirtual getWidth : ()I
    //   86: aload_1
    //   87: invokevirtual getHeight : ()I
    //   90: invokevirtual set : (IIII)V
    //   93: aload_1
    //   94: areturn
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(ViewGroup paramViewGroup, Rect paramRect) {
    return (View)paramViewGroup;
  }
  
  protected void onGetChildren(ViewGroup paramViewGroup, Accumulator<Object> paramAccumulator) {
    int j = paramViewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = paramViewGroup.getChildAt(i);
      if (isChildVisible(view))
        paramAccumulator.store(getElementForView(paramViewGroup, view)); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewGroupDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */