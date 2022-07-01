package a.d.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class d extends ViewGroup {
  public c b;
  
  public a generateDefaultLayoutParams() {
    return new a(-2, -2);
  }
  
  public a generateLayoutParams(AttributeSet paramAttributeSet) {
    return new a(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new ConstraintLayout.a(paramLayoutParams);
  }
  
  public c getConstraintSet() {
    if (this.b == null)
      this.b = new c(); 
    this.b.a(this);
    return this.b;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static class a extends ConstraintLayout.a {
    public float m0 = 1.0F;
    
    public boolean n0;
    
    public float o0;
    
    public float p0;
    
    public float q0;
    
    public float r0;
    
    public float s0;
    
    public float t0;
    
    public float u0;
    
    public float v0;
    
    public float w0;
    
    public float x0;
    
    public float y0;
    
    public a(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
      this.n0 = false;
      this.o0 = 0.0F;
      this.p0 = 0.0F;
      this.q0 = 0.0F;
      this.r0 = 0.0F;
      this.s0 = 1.0F;
      this.t0 = 1.0F;
      this.u0 = 0.0F;
      this.v0 = 0.0F;
      this.w0 = 0.0F;
      this.x0 = 0.0F;
      this.y0 = 0.0F;
    }
    
    public a(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      int i = 0;
      this.n0 = false;
      this.o0 = 0.0F;
      this.p0 = 0.0F;
      this.q0 = 0.0F;
      this.r0 = 0.0F;
      this.s0 = 1.0F;
      this.t0 = 1.0F;
      this.u0 = 0.0F;
      this.v0 = 0.0F;
      this.w0 = 0.0F;
      this.x0 = 0.0F;
      this.y0 = 0.0F;
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, h.ConstraintSet);
      int j = typedArray.getIndexCount();
      while (i < j) {
        int k = typedArray.getIndex(i);
        if (k == h.ConstraintSet_android_alpha) {
          this.m0 = typedArray.getFloat(k, this.m0);
        } else if (k == h.ConstraintSet_android_elevation) {
          this.o0 = typedArray.getFloat(k, this.o0);
          this.n0 = true;
        } else if (k == h.ConstraintSet_android_rotationX) {
          this.q0 = typedArray.getFloat(k, this.q0);
        } else if (k == h.ConstraintSet_android_rotationY) {
          this.r0 = typedArray.getFloat(k, this.r0);
        } else if (k == h.ConstraintSet_android_rotation) {
          this.p0 = typedArray.getFloat(k, this.p0);
        } else if (k == h.ConstraintSet_android_scaleX) {
          this.s0 = typedArray.getFloat(k, this.s0);
        } else if (k == h.ConstraintSet_android_scaleY) {
          this.t0 = typedArray.getFloat(k, this.t0);
        } else if (k == h.ConstraintSet_android_transformPivotX) {
          this.u0 = typedArray.getFloat(k, this.u0);
        } else if (k == h.ConstraintSet_android_transformPivotY) {
          this.v0 = typedArray.getFloat(k, this.v0);
        } else if (k == h.ConstraintSet_android_translationX) {
          this.w0 = typedArray.getFloat(k, this.w0);
        } else if (k == h.ConstraintSet_android_translationY) {
          this.x0 = typedArray.getFloat(k, this.x0);
        } else if (k == h.ConstraintSet_android_translationZ) {
          this.w0 = typedArray.getFloat(k, this.y0);
        } 
        i++;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\d\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */