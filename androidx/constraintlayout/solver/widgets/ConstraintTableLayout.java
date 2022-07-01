package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout extends ConstraintWidgetContainer {
  public static final int ALIGN_CENTER = 0;
  
  public static final int ALIGN_LEFT = 1;
  
  public static final int ALIGN_RIGHT = 2;
  
  private boolean aq = true;
  
  private int ar = 0;
  
  private int as = 0;
  
  private int at = 8;
  
  private ArrayList<VerticalSlice> au = new ArrayList<VerticalSlice>();
  
  private ArrayList<HorizontalSlice> av = new ArrayList<HorizontalSlice>();
  
  private ArrayList<Guideline> aw = new ArrayList<Guideline>();
  
  private ArrayList<Guideline> ax = new ArrayList<Guideline>();
  
  private LinearSystem ay = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void c() {
    if (this.ay == null)
      return; 
    int j = this.aw.size();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      Guideline guideline = this.aw.get(i);
      LinearSystem linearSystem = this.ay;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getDebugName());
      stringBuilder.append(".VG");
      stringBuilder.append(i);
      guideline.setDebugSolverName(linearSystem, stringBuilder.toString());
    } 
    j = this.ax.size();
    for (i = bool; i < j; i++) {
      Guideline guideline = this.ax.get(i);
      LinearSystem linearSystem = this.ay;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getDebugName());
      stringBuilder.append(".HG");
      stringBuilder.append(i);
      guideline.setDebugSolverName(linearSystem, stringBuilder.toString());
    } 
  }
  
  private void d() {
    this.au.clear();
    float f2 = 100.0F / this.ar;
    int i = 0;
    ConstraintTableLayout constraintTableLayout = this;
    float f1 = f2;
    while (i < this.ar) {
      VerticalSlice verticalSlice = new VerticalSlice(this);
      verticalSlice.a = constraintTableLayout;
      if (i < this.ar - 1) {
        Guideline guideline = new Guideline();
        guideline.setOrientation(1);
        guideline.setParent(this);
        guideline.setGuidePercent((int)f1);
        f1 += f2;
        verticalSlice.b = guideline;
        this.aw.add(guideline);
      } else {
        verticalSlice.b = this;
      } 
      ConstraintWidget constraintWidget = verticalSlice.b;
      this.au.add(verticalSlice);
      i++;
    } 
    c();
  }
  
  private void e() {
    this.av.clear();
    float f2 = 100.0F / this.as;
    ConstraintTableLayout constraintTableLayout = this;
    float f1 = f2;
    for (int i = 0; i < this.as; i++) {
      HorizontalSlice horizontalSlice = new HorizontalSlice(this);
      horizontalSlice.a = constraintTableLayout;
      if (i < this.as - 1) {
        Guideline guideline = new Guideline();
        guideline.setOrientation(0);
        guideline.setParent(this);
        guideline.setGuidePercent((int)f1);
        f1 += f2;
        horizontalSlice.b = guideline;
        this.ax.add(guideline);
      } else {
        horizontalSlice.b = this;
      } 
      ConstraintWidget constraintWidget = horizontalSlice.b;
      this.av.add(horizontalSlice);
    } 
    c();
  }
  
  private void f() {
    int k = this.ap.size();
    int i = 0;
    int j = 0;
    while (i < k) {
      ConstraintWidget constraintWidget1 = this.ap.get(i);
      j += constraintWidget1.getContainerItemSkip();
      int m = this.ar;
      int n = j / m;
      HorizontalSlice horizontalSlice = this.av.get(n);
      VerticalSlice verticalSlice = this.au.get(j % m);
      ConstraintWidget constraintWidget2 = verticalSlice.a;
      ConstraintWidget constraintWidget3 = verticalSlice.b;
      ConstraintWidget constraintWidget4 = horizontalSlice.a;
      ConstraintWidget constraintWidget5 = horizontalSlice.b;
      constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), this.at);
      if (constraintWidget3 instanceof Guideline) {
        constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.at);
      } else {
        constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.at);
      } 
      m = verticalSlice.c;
      if (m != 1) {
        if (m != 2) {
          if (m == 3)
            constraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT); 
        } else {
          constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
          constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        } 
      } else {
        constraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
        constraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
      } 
      constraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), this.at);
      if (constraintWidget5 instanceof Guideline) {
        constraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), this.at);
      } else {
        constraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), this.at);
      } 
      j++;
      i++;
    } 
  }
  
  public void addToSolver(LinearSystem paramLinearSystem) {
    super.addToSolver(paramLinearSystem);
    int i = this.ap.size();
    if (i == 0)
      return; 
    setTableDimensions();
    if (paramLinearSystem == this.af) {
      int k = this.aw.size();
      boolean bool = false;
      int j = 0;
      while (true) {
        boolean bool1 = true;
        if (j < k) {
          Guideline guideline = this.aw.get(j);
          if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
            bool1 = false; 
          guideline.setPositionRelaxed(bool1);
          guideline.addToSolver(paramLinearSystem);
          j++;
          continue;
        } 
        int m = this.ax.size();
        j = 0;
        while (true) {
          k = bool;
          if (j < m) {
            Guideline guideline = this.ax.get(j);
            if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            guideline.setPositionRelaxed(bool1);
            guideline.addToSolver(paramLinearSystem);
            j++;
            continue;
          } 
          break;
        } 
        while (k < i) {
          ((ConstraintWidget)this.ap.get(k)).addToSolver(paramLinearSystem);
          k++;
        } 
        break;
      } 
    } 
  }
  
  public void computeGuidelinesPercentPositions() {
    int j = this.aw.size();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      ((Guideline)this.aw.get(i)).c(); 
    j = this.ax.size();
    for (i = bool; i < j; i++)
      ((Guideline)this.ax.get(i)).c(); 
  }
  
  public void cycleColumnAlignment(int paramInt) {
    VerticalSlice verticalSlice = this.au.get(paramInt);
    paramInt = verticalSlice.c;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          verticalSlice.c = 1; 
      } else {
        verticalSlice.c = 0;
      } 
    } else {
      verticalSlice.c = 2;
    } 
    f();
  }
  
  public String getColumnAlignmentRepresentation(int paramInt) {
    VerticalSlice verticalSlice = this.au.get(paramInt);
    return (verticalSlice.c == 1) ? "L" : ((verticalSlice.c == 0) ? "C" : ((verticalSlice.c == 3) ? "F" : ((verticalSlice.c == 2) ? "R" : "!")));
  }
  
  public String getColumnsAlignmentRepresentation() {
    int j = this.au.size();
    String str = "";
    int i = 0;
    while (i < j) {
      String str1;
      VerticalSlice verticalSlice = this.au.get(i);
      if (verticalSlice.c == 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("L");
        str1 = stringBuilder.toString();
      } else if (verticalSlice.c == 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("C");
        str1 = stringBuilder.toString();
      } else if (verticalSlice.c == 3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("F");
        str1 = stringBuilder.toString();
      } else {
        str1 = str;
        if (verticalSlice.c == 2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str);
          stringBuilder.append("R");
          str1 = stringBuilder.toString();
        } 
      } 
      i++;
      str = str1;
    } 
    return str;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines() {
    return this.ax;
  }
  
  public int getNumCols() {
    return this.ar;
  }
  
  public int getNumRows() {
    return this.as;
  }
  
  public int getPadding() {
    return this.at;
  }
  
  public String getType() {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines() {
    return this.aw;
  }
  
  public boolean handlesInternalConstraints() {
    return true;
  }
  
  public boolean isVerticalGrowth() {
    return this.aq;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2) {
    if (paramInt1 < this.au.size()) {
      ((VerticalSlice)this.au.get(paramInt1)).c = paramInt2;
      f();
    } 
  }
  
  public void setColumnAlignment(String paramString) {
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c == 'L') {
        setColumnAlignment(i, 1);
      } else if (c == 'C') {
        setColumnAlignment(i, 0);
      } else if (c == 'F') {
        setColumnAlignment(i, 3);
      } else if (c == 'R') {
        setColumnAlignment(i, 2);
      } else {
        setColumnAlignment(i, 0);
      } 
    } 
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString) {
    this.ay = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    c();
  }
  
  public void setNumCols(int paramInt) {
    if (this.aq && this.ar != paramInt) {
      this.ar = paramInt;
      d();
      setTableDimensions();
    } 
  }
  
  public void setNumRows(int paramInt) {
    if (!this.aq && this.ar != paramInt) {
      this.as = paramInt;
      e();
      setTableDimensions();
    } 
  }
  
  public void setPadding(int paramInt) {
    if (paramInt > 1)
      this.at = paramInt; 
  }
  
  public void setTableDimensions() {
    int k = this.ap.size();
    int i = 0;
    int j = 0;
    while (i < k) {
      j += ((ConstraintWidget)this.ap.get(i)).getContainerItemSkip();
      i++;
    } 
    k += j;
    if (this.aq) {
      if (this.ar == 0)
        setNumCols(1); 
      int m = this.ar;
      j = k / m;
      i = j;
      if (m * j < k)
        i = j + 1; 
      if (this.as == i && this.aw.size() == this.ar - 1)
        return; 
      this.as = i;
      e();
    } else {
      if (this.as == 0)
        setNumRows(1); 
      int m = this.as;
      j = k / m;
      i = j;
      if (m * j < k)
        i = j + 1; 
      if (this.ar == i && this.ax.size() == this.as - 1)
        return; 
      this.ar = i;
      d();
    } 
    f();
  }
  
  public void setVerticalGrowth(boolean paramBoolean) {
    this.aq = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem) {
    super.updateFromSolver(paramLinearSystem);
    if (paramLinearSystem == this.af) {
      int j = this.aw.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++)
        ((Guideline)this.aw.get(i)).updateFromSolver(paramLinearSystem); 
      j = this.ax.size();
      for (i = bool; i < j; i++)
        ((Guideline)this.ax.get(i)).updateFromSolver(paramLinearSystem); 
    } 
  }
  
  class HorizontalSlice {
    ConstraintWidget a;
    
    ConstraintWidget b;
    
    HorizontalSlice(ConstraintTableLayout this$0) {}
  }
  
  class VerticalSlice {
    ConstraintWidget a;
    
    ConstraintWidget b;
    
    int c = 1;
    
    VerticalSlice(ConstraintTableLayout this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ConstraintTableLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */