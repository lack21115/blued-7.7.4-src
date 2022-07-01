package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class Guideline extends ConstraintWidget {
  public static final int HORIZONTAL = 0;
  
  public static final int RELATIVE_BEGIN = 1;
  
  public static final int RELATIVE_END = 2;
  
  public static final int RELATIVE_PERCENT = 0;
  
  public static final int RELATIVE_UNKNWON = -1;
  
  public static final int VERTICAL = 1;
  
  protected float af = -1.0F;
  
  protected int ag = -1;
  
  protected int ah = -1;
  
  private ConstraintAnchor ai = this.r;
  
  private int aj;
  
  private boolean ak;
  
  private int al;
  
  private Rectangle am;
  
  private int an;
  
  public Guideline() {
    int i = 0;
    this.aj = 0;
    this.ak = false;
    this.al = 0;
    this.am = new Rectangle();
    this.an = 8;
    this.z.clear();
    this.z.add(this.ai);
    int j = this.y.length;
    while (i < j) {
      this.y[i] = this.ai;
      i++;
    } 
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    boolean bool;
    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)getParent();
    if (constraintWidgetContainer == null)
      return; 
    ConstraintAnchor constraintAnchor1 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor constraintAnchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
    if (this.B != null && this.B.A[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      bool = true;
    } else {
      bool = false;
    } 
    if (this.aj == 0) {
      constraintAnchor1 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
      constraintAnchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
      if (this.B != null && this.B.A[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        bool = true;
      } else {
        bool = false;
      } 
    } 
    if (this.ag != -1) {
      SolverVariable solverVariable = paramLinearSystem.createObjectVariable(this.ai);
      paramLinearSystem.addEquality(solverVariable, paramLinearSystem.createObjectVariable(constraintAnchor1), this.ag, 6);
      if (bool) {
        paramLinearSystem.addGreaterThan(paramLinearSystem.createObjectVariable(constraintAnchor2), solverVariable, 0, 5);
        return;
      } 
    } else {
      SolverVariable solverVariable;
      if (this.ah != -1) {
        SolverVariable solverVariable1 = paramLinearSystem.createObjectVariable(this.ai);
        solverVariable = paramLinearSystem.createObjectVariable(constraintAnchor2);
        paramLinearSystem.addEquality(solverVariable1, solverVariable, -this.ah, 6);
        if (bool) {
          paramLinearSystem.addGreaterThan(solverVariable1, paramLinearSystem.createObjectVariable(constraintAnchor1), 0, 5);
          paramLinearSystem.addGreaterThan(solverVariable, solverVariable1, 0, 5);
          return;
        } 
      } else if (this.af != -1.0F) {
        paramLinearSystem.addConstraint(LinearSystem.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(this.ai), paramLinearSystem.createObjectVariable(constraintAnchor1), paramLinearSystem.createObjectVariable(solverVariable), this.af, this.ak));
      } 
    } 
  }
  
  public boolean allowedInBarrier() {
    return true;
  }
  
  public void analyze(int paramInt) {
    ConstraintWidget constraintWidget = getParent();
    if (constraintWidget == null)
      return; 
    if (getOrientation() == 1) {
      this.r.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), 0);
      this.t.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), 0);
      if (this.ag != -1) {
        this.q.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), this.ag);
        this.s.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), this.ag);
        return;
      } 
      if (this.ah != -1) {
        this.q.getResolutionNode().dependsOn(1, constraintWidget.s.getResolutionNode(), -this.ah);
        this.s.getResolutionNode().dependsOn(1, constraintWidget.s.getResolutionNode(), -this.ah);
        return;
      } 
      if (this.af != -1.0F && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
        paramInt = (int)(constraintWidget.C * this.af);
        this.q.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), paramInt);
        this.s.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), paramInt);
        return;
      } 
    } else {
      this.q.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), 0);
      this.s.getResolutionNode().dependsOn(1, constraintWidget.q.getResolutionNode(), 0);
      if (this.ag != -1) {
        this.r.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), this.ag);
        this.t.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), this.ag);
        return;
      } 
      if (this.ah != -1) {
        this.r.getResolutionNode().dependsOn(1, constraintWidget.t.getResolutionNode(), -this.ah);
        this.t.getResolutionNode().dependsOn(1, constraintWidget.t.getResolutionNode(), -this.ah);
        return;
      } 
      if (this.af != -1.0F && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
        paramInt = (int)(constraintWidget.D * this.af);
        this.r.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), paramInt);
        this.t.getResolutionNode().dependsOn(1, constraintWidget.r.getResolutionNode(), paramInt);
      } 
    } 
  }
  
  void c() {
    float f = getX() / getParent().getWidth();
    if (this.aj == 0)
      f = getY() / getParent().getHeight(); 
    setGuidePercent(f);
  }
  
  public void cyclePosition() {
    if (this.ag != -1) {
      c();
      return;
    } 
    if (this.af != -1.0F) {
      e();
      return;
    } 
    if (this.ah != -1)
      d(); 
  }
  
  void d() {
    int i = getX();
    if (this.aj == 0)
      i = getY(); 
    setGuideBegin(i);
  }
  
  void e() {
    int i = getParent().getWidth() - getX();
    if (this.aj == 0)
      i = getParent().getHeight() - getY(); 
    setGuideEnd(i);
  }
  
  public ConstraintAnchor getAnchor() {
    return this.ai;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType) {
    switch (null.a[paramType.ordinal()]) {
      default:
        throw new AssertionError(paramType.name());
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        return null;
      case 3:
      case 4:
        if (this.aj == 0)
          return this.ai; 
      case 1:
      case 2:
        break;
    } 
    if (this.aj == 1)
      return this.ai; 
  }
  
  public ArrayList<ConstraintAnchor> getAnchors() {
    return this.z;
  }
  
  public Rectangle getHead() {
    Rectangle rectangle = this.am;
    int i = getDrawX();
    int j = this.an;
    int k = getDrawY();
    int m = this.an;
    rectangle.setBounds(i - j, k - m * 2, m * 2, m * 2);
    if (getOrientation() == 0) {
      rectangle = this.am;
      i = getDrawX();
      j = this.an;
      k = getDrawY();
      m = this.an;
      rectangle.setBounds(i - j * 2, k - m, m * 2, m * 2);
    } 
    return this.am;
  }
  
  public int getOrientation() {
    return this.aj;
  }
  
  public int getRelativeBegin() {
    return this.ag;
  }
  
  public int getRelativeBehaviour() {
    return (this.af != -1.0F) ? 0 : ((this.ag != -1) ? 1 : ((this.ah != -1) ? 2 : -1));
  }
  
  public int getRelativeEnd() {
    return this.ah;
  }
  
  public float getRelativePercent() {
    return this.af;
  }
  
  public String getType() {
    return "Guideline";
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2) {
    if (this.aj == 1) {
      paramInt1 -= this.K;
      if (this.ag != -1) {
        setGuideBegin(paramInt1);
        return;
      } 
      if (this.ah != -1) {
        setGuideEnd(getParent().getWidth() - paramInt1);
        return;
      } 
      if (this.af != -1.0F) {
        setGuidePercent(paramInt1 / getParent().getWidth());
        return;
      } 
    } else {
      paramInt1 = paramInt2 - this.L;
      if (this.ag != -1) {
        setGuideBegin(paramInt1);
        return;
      } 
      if (this.ah != -1) {
        setGuideEnd(getParent().getHeight() - paramInt1);
        return;
      } 
      if (this.af != -1.0F)
        setGuidePercent(paramInt1 / getParent().getHeight()); 
    } 
  }
  
  public void setGuideBegin(int paramInt) {
    if (paramInt > -1) {
      this.af = -1.0F;
      this.ag = paramInt;
      this.ah = -1;
    } 
  }
  
  public void setGuideEnd(int paramInt) {
    if (paramInt > -1) {
      this.af = -1.0F;
      this.ag = -1;
      this.ah = paramInt;
    } 
  }
  
  public void setGuidePercent(float paramFloat) {
    if (paramFloat > -1.0F) {
      this.af = paramFloat;
      this.ag = -1;
      this.ah = -1;
    } 
  }
  
  public void setGuidePercent(int paramInt) {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt) {
    this.al = paramInt;
  }
  
  public void setOrientation(int paramInt) {
    if (this.aj == paramInt)
      return; 
    this.aj = paramInt;
    this.z.clear();
    if (this.aj == 1) {
      this.ai = this.q;
    } else {
      this.ai = this.r;
    } 
    this.z.add(this.ai);
    int i = this.y.length;
    for (paramInt = 0; paramInt < i; paramInt++)
      this.y[paramInt] = this.ai; 
  }
  
  public void setPositionRelaxed(boolean paramBoolean) {
    if (this.ak == paramBoolean)
      return; 
    this.ak = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem) {
    if (getParent() == null)
      return; 
    int i = paramLinearSystem.getObjectVariableValue(this.ai);
    if (this.aj == 1) {
      setX(i);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    } 
    setX(0);
    setY(i);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Guideline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */