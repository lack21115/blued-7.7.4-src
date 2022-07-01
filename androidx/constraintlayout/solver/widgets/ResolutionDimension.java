package androidx.constraintlayout.solver.widgets;

public class ResolutionDimension extends ResolutionNode {
  float a = 0.0F;
  
  public void remove() {
    this.i = 2;
  }
  
  public void reset() {
    super.reset();
    this.a = 0.0F;
  }
  
  public void resolve(int paramInt) {
    if (this.i == 0 || this.a != paramInt) {
      this.a = paramInt;
      if (this.i == 1)
        invalidate(); 
      didResolve();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ResolutionDimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */