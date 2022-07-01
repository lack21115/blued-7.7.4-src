package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class Constraints extends ViewGroup {
  public static final String TAG = "Constraints";
  
  ConstraintSet a;
  
  public Constraints(Context paramContext) {
    super(paramContext);
    setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
    setVisibility(8);
  }
  
  public Constraints(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
    setVisibility(8);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    Log.v("Constraints", " ################# init");
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-2, -2);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new ConstraintLayout.LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ConstraintSet getConstraintSet() {
    if (this.a == null)
      this.a = new ConstraintSet(); 
    this.a.clone(this);
    return this.a;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public static class LayoutParams extends ConstraintLayout.LayoutParams {
    public float alpha = 1.0F;
    
    public boolean applyElevation;
    
    public float elevation;
    
    public float rotation;
    
    public float rotationX;
    
    public float rotationY;
    
    public float scaleX;
    
    public float scaleY;
    
    public float transformPivotX;
    
    public float transformPivotY;
    
    public float translationX;
    
    public float translationY;
    
    public float translationZ;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      int i = 0;
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.ConstraintSet);
      int j = typedArray.getIndexCount();
      while (i < j) {
        int k = typedArray.getIndex(i);
        if (k == R.styleable.ConstraintSet_android_alpha) {
          this.alpha = typedArray.getFloat(k, this.alpha);
        } else if (k == R.styleable.ConstraintSet_android_elevation) {
          this.elevation = typedArray.getFloat(k, this.elevation);
          this.applyElevation = true;
        } else if (k == R.styleable.ConstraintSet_android_rotationX) {
          this.rotationX = typedArray.getFloat(k, this.rotationX);
        } else if (k == R.styleable.ConstraintSet_android_rotationY) {
          this.rotationY = typedArray.getFloat(k, this.rotationY);
        } else if (k == R.styleable.ConstraintSet_android_rotation) {
          this.rotation = typedArray.getFloat(k, this.rotation);
        } else if (k == R.styleable.ConstraintSet_android_scaleX) {
          this.scaleX = typedArray.getFloat(k, this.scaleX);
        } else if (k == R.styleable.ConstraintSet_android_scaleY) {
          this.scaleY = typedArray.getFloat(k, this.scaleY);
        } else if (k == R.styleable.ConstraintSet_android_transformPivotX) {
          this.transformPivotX = typedArray.getFloat(k, this.transformPivotX);
        } else if (k == R.styleable.ConstraintSet_android_transformPivotY) {
          this.transformPivotY = typedArray.getFloat(k, this.transformPivotY);
        } else if (k == R.styleable.ConstraintSet_android_translationX) {
          this.translationX = typedArray.getFloat(k, this.translationX);
        } else if (k == R.styleable.ConstraintSet_android_translationY) {
          this.translationY = typedArray.getFloat(k, this.translationY);
        } else if (k == R.styleable.ConstraintSet_android_translationZ) {
          this.translationX = typedArray.getFloat(k, this.translationZ);
        } 
        i++;
      } 
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.applyElevation = false;
      this.elevation = 0.0F;
      this.rotation = 0.0F;
      this.rotationX = 0.0F;
      this.rotationY = 0.0F;
      this.scaleX = 1.0F;
      this.scaleY = 1.0F;
      this.transformPivotX = 0.0F;
      this.transformPivotY = 0.0F;
      this.translationX = 0.0F;
      this.translationY = 0.0F;
      this.translationZ = 0.0F;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\widget\Constraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */