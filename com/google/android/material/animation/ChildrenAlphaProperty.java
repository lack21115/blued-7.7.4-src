package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
  public static final Property<ViewGroup, Float> a = new ChildrenAlphaProperty("childrenAlpha");
  
  private ChildrenAlphaProperty(String paramString) {
    super(Float.class, paramString);
  }
  
  public Float a(ViewGroup paramViewGroup) {
    Float float_ = (Float)paramViewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
    return (float_ != null) ? float_ : Float.valueOf(1.0F);
  }
  
  public void a(ViewGroup paramViewGroup, Float paramFloat) {
    float f = paramFloat.floatValue();
    paramViewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int j = paramViewGroup.getChildCount();
    int i;
    for (i = 0; i < j; i++)
      paramViewGroup.getChildAt(i).setAlpha(f); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\ChildrenAlphaProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */