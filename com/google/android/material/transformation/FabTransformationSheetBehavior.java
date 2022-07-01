package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
  private Map<View, Integer> a;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, boolean paramBoolean) {
    ViewParent viewParent = paramView.getParent();
    if (!(viewParent instanceof CoordinatorLayout))
      return; 
    CoordinatorLayout coordinatorLayout = (CoordinatorLayout)viewParent;
    int j = coordinatorLayout.getChildCount();
    if (Build.VERSION.SDK_INT >= 16 && paramBoolean)
      this.a = new HashMap<View, Integer>(j); 
    for (int i = 0; i < j; i++) {
      boolean bool;
      View view = coordinatorLayout.getChildAt(i);
      if (view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams && ((CoordinatorLayout.LayoutParams)view.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior) {
        bool = true;
      } else {
        bool = false;
      } 
      if (view != paramView && !bool)
        if (!paramBoolean) {
          Map<View, Integer> map = this.a;
          if (map != null && map.containsKey(view))
            ViewCompat.setImportantForAccessibility(view, ((Integer)this.a.get(view)).intValue()); 
        } else {
          if (Build.VERSION.SDK_INT >= 16)
            this.a.put(view, Integer.valueOf(view.getImportantForAccessibility())); 
          ViewCompat.setImportantForAccessibility(view, 4);
        }  
    } 
    if (!paramBoolean)
      this.a = null; 
  }
  
  protected FabTransformationBehavior.FabTransformationSpec a(Context paramContext, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    } 
    FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
    fabTransformationSpec.a = MotionSpec.a(paramContext, i);
    fabTransformationSpec.b = new Positioning(17, 0.0F, 0.0F);
    return fabTransformationSpec;
  }
  
  protected boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramView2, paramBoolean1);
    return super.a(paramView1, paramView2, paramBoolean1, paramBoolean2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transformation\FabTransformationSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */