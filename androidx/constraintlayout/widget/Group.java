package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class Group extends ConstraintHelper {
  public Group(Context paramContext) {
    super(paramContext);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public Group(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(AttributeSet paramAttributeSet) {
    super.a(paramAttributeSet);
    this.e = false;
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout) {
    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)getLayoutParams();
    layoutParams.s.setWidth(0);
    layoutParams.s.setHeight(0);
  }
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout) {
    float f;
    int j = getVisibility();
    if (Build.VERSION.SDK_INT >= 21) {
      f = getElevation();
    } else {
      f = 0.0F;
    } 
    for (int i = 0; i < this.b; i++) {
      View view = paramConstraintLayout.getViewById(this.a[i]);
      if (view != null) {
        view.setVisibility(j);
        if (f > 0.0F && Build.VERSION.SDK_INT >= 21)
          view.setElevation(f); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */