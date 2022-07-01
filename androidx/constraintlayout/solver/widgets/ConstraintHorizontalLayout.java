package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
  private ContentAlignment aq = ContentAlignment.MIDDLE;
  
  public ConstraintHorizontalLayout() {}
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    if (this.ap.size() != 0) {
      int i = 0;
      int j = this.ap.size();
      ConstraintWidget constraintWidget = this;
      while (i < j) {
        ConstraintWidget constraintWidget1 = this.ap.get(i);
        if (constraintWidget != this) {
          constraintWidget1.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.RIGHT);
          constraintWidget.connect(ConstraintAnchor.Type.RIGHT, constraintWidget1, ConstraintAnchor.Type.LEFT);
        } else {
          ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
          if (this.aq == ContentAlignment.END)
            strength = ConstraintAnchor.Strength.WEAK; 
          constraintWidget1.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0, strength);
        } 
        constraintWidget1.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
        constraintWidget1.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
        i++;
        constraintWidget = constraintWidget1;
      } 
      if (constraintWidget != this) {
        ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
        if (this.aq == ContentAlignment.BEGIN)
          strength = ConstraintAnchor.Strength.WEAK; 
        constraintWidget.connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT, 0, strength);
      } 
    } 
    super.addToSolver(paramLinearSystem);
  }
  
  public enum ContentAlignment {
    BEGIN, BOTTOM, END, LEFT, MIDDLE, RIGHT, TOP, VERTICAL_MIDDLE;
    
    static {
      BOTTOM = new ContentAlignment("BOTTOM", 5);
      LEFT = new ContentAlignment("LEFT", 6);
      RIGHT = new ContentAlignment("RIGHT", 7);
      a = new ContentAlignment[] { BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, RIGHT };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ConstraintHorizontalLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */