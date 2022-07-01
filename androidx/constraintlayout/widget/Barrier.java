package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.solver.widgets.Helper;

public class Barrier extends ConstraintHelper {
  public static final int BOTTOM = 3;
  
  public static final int END = 6;
  
  public static final int LEFT = 0;
  
  public static final int RIGHT = 1;
  
  public static final int START = 5;
  
  public static final int TOP = 2;
  
  private int f;
  
  private int g;
  
  private androidx.constraintlayout.solver.widgets.Barrier h;
  
  public Barrier(Context paramContext) {
    super(paramContext);
    setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    setVisibility(8);
  }
  
  public Barrier(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setVisibility(8);
  }
  
  protected void a(AttributeSet paramAttributeSet) {
    super.a(paramAttributeSet);
    this.h = new androidx.constraintlayout.solver.widgets.Barrier();
    if (paramAttributeSet != null) {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = typedArray.getIndexCount();
      for (int i = 0; i < j; i++) {
        int k = typedArray.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_barrierDirection) {
          setType(typedArray.getInt(k, 0));
        } else if (k == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
          this.h.setAllowsGoneWidget(typedArray.getBoolean(k, true));
        } 
      } 
    } 
    this.d = (Helper)this.h;
    validateParams();
  }
  
  public boolean allowsGoneWidget() {
    return this.h.allowsGoneWidget();
  }
  
  public int getType() {
    return this.f;
  }
  
  public void setAllowsGoneWidget(boolean paramBoolean) {
    this.h.setAllowsGoneWidget(paramBoolean);
  }
  
  public void setType(int paramInt) {
    this.f = paramInt;
    this.g = paramInt;
    if (Build.VERSION.SDK_INT < 17) {
      paramInt = this.f;
      if (paramInt == 5) {
        this.g = 0;
      } else if (paramInt == 6) {
        this.g = 1;
      } 
    } else {
      if (1 == getResources().getConfiguration().getLayoutDirection()) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if (paramInt != 0) {
        paramInt = this.f;
        if (paramInt == 5) {
          this.g = 1;
        } else if (paramInt == 6) {
          this.g = 0;
        } 
      } else {
        paramInt = this.f;
        if (paramInt == 5) {
          this.g = 0;
        } else if (paramInt == 6) {
          this.g = 1;
        } 
      } 
    } 
    this.h.setBarrierType(this.g);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\Barrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */