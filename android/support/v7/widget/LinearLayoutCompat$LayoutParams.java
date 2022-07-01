package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class LinearLayoutCompat$LayoutParams extends ViewGroup.MarginLayoutParams {
  public int gravity = -1;
  
  public float weight;
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
    this.weight = 0.0F;
  }
  
  public LinearLayoutCompat$LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
    this.weight = typedArray.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
    this.gravity = typedArray.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
    typedArray.recycle();
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    super(paramLayoutParams);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\LinearLayoutCompat$LayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */