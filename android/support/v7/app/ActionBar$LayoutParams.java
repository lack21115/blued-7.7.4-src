package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class ActionBar$LayoutParams extends ViewGroup.MarginLayoutParams {
  public int gravity = 0;
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
    this.gravity = 8388627;
  }
  
  public ActionBar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
    this.gravity = typedArray.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
    typedArray.recycle();
  }
  
  public ActionBar$LayoutParams(ActionBar$LayoutParams paramActionBar$LayoutParams) {
    super(paramActionBar$LayoutParams);
    this.gravity = paramActionBar$LayoutParams.gravity;
  }
  
  public ActionBar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\app\ActionBar$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */