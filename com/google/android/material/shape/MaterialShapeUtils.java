package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils {
  static CornerTreatment a() {
    return new RoundedCornerTreatment();
  }
  
  static CornerTreatment a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? a() : new CutCornerTreatment()) : new RoundedCornerTreatment();
  }
  
  public static void a(View paramView) {
    Drawable drawable = paramView.getBackground();
    if (drawable instanceof MaterialShapeDrawable)
      a(paramView, (MaterialShapeDrawable)drawable); 
  }
  
  public static void a(View paramView, float paramFloat) {
    Drawable drawable = paramView.getBackground();
    if (drawable instanceof MaterialShapeDrawable)
      ((MaterialShapeDrawable)drawable).r(paramFloat); 
  }
  
  public static void a(View paramView, MaterialShapeDrawable paramMaterialShapeDrawable) {
    if (paramMaterialShapeDrawable.P())
      paramMaterialShapeDrawable.q(ViewUtils.d(paramView)); 
  }
  
  static EdgeTreatment b() {
    return new EdgeTreatment();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\MaterialShapeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */