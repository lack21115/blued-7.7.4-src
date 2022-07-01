package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

public class Helper extends ConstraintWidget {
  protected ConstraintWidget[] af = new ConstraintWidget[4];
  
  protected int ag = 0;
  
  public void add(ConstraintWidget paramConstraintWidget) {
    int i = this.ag;
    ConstraintWidget[] arrayOfConstraintWidget = this.af;
    if (i + 1 > arrayOfConstraintWidget.length)
      this.af = Arrays.<ConstraintWidget>copyOf(arrayOfConstraintWidget, arrayOfConstraintWidget.length * 2); 
    arrayOfConstraintWidget = this.af;
    i = this.ag;
    arrayOfConstraintWidget[i] = paramConstraintWidget;
    this.ag = i + 1;
  }
  
  public void removeAllIds() {
    this.ag = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */