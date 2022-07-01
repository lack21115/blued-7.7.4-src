package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstraintWidgetContainer extends WidgetContainer {
  protected LinearSystem af = new LinearSystem();
  
  int ag;
  
  int ah;
  
  int ai;
  
  int aj;
  
  int ak = 0;
  
  int al = 0;
  
  ChainHead[] am = new ChainHead[4];
  
  ChainHead[] an = new ChainHead[4];
  
  int ao = 0;
  
  private boolean aq = false;
  
  private Snapshot ar;
  
  private int as = 7;
  
  private boolean at = false;
  
  private boolean au = false;
  
  public boolean mGroupsWrapOptimized = false;
  
  public boolean mHorizontalWrapOptimized = false;
  
  public boolean mSkipSolver = false;
  
  public boolean mVerticalWrapOptimized = false;
  
  public List<ConstraintWidgetGroup> mWidgetGroups = new ArrayList<ConstraintWidgetGroup>();
  
  public int mWrapFixedHeight = 0;
  
  public int mWrapFixedWidth = 0;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void a(ConstraintWidget paramConstraintWidget) {
    int i = this.ak;
    ChainHead[] arrayOfChainHead = this.an;
    if (i + 1 >= arrayOfChainHead.length)
      this.an = Arrays.<ChainHead>copyOf(arrayOfChainHead, arrayOfChainHead.length * 2); 
    this.an[this.ak] = new ChainHead(paramConstraintWidget, 0, isRtl());
    this.ak++;
  }
  
  private void b(ConstraintWidget paramConstraintWidget) {
    int i = this.al;
    ChainHead[] arrayOfChainHead = this.am;
    if (i + 1 >= arrayOfChainHead.length)
      this.am = Arrays.<ChainHead>copyOf(arrayOfChainHead, arrayOfChainHead.length * 2); 
    this.am[this.al] = new ChainHead(paramConstraintWidget, 1, isRtl());
    this.al++;
  }
  
  private void c() {
    this.ak = 0;
    this.al = 0;
  }
  
  void a(ConstraintWidget paramConstraintWidget, int paramInt) {
    if (paramInt == 0) {
      a(paramConstraintWidget);
      return;
    } 
    if (paramInt == 1)
      b(paramConstraintWidget); 
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem) {
    addToSolver(paramLinearSystem);
    int j = this.ap.size();
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.ap.get(i);
      if (constraintWidget instanceof ConstraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = constraintWidget.A[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.A[1];
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED); 
        constraintWidget.addToSolver(paramLinearSystem);
        if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour1); 
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)
          constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2); 
      } else {
        Optimizer.a(this, paramLinearSystem, constraintWidget);
        constraintWidget.addToSolver(paramLinearSystem);
      } 
    } 
    if (this.ak > 0)
      Chain.a(this, paramLinearSystem, 0); 
    if (this.al > 0)
      Chain.a(this, paramLinearSystem, 1); 
    return true;
  }
  
  public void analyze(int paramInt) {
    super.analyze(paramInt);
    int j = this.ap.size();
    for (int i = 0; i < j; i++)
      ((ConstraintWidget)this.ap.get(i)).analyze(paramInt); 
  }
  
  public void fillMetrics(Metrics paramMetrics) {
    this.af.fillMetrics(paramMetrics);
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int j = this.ap.size();
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.ap.get(i);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 0)
          arrayList.add(constraintWidget); 
      } 
    } 
    return (ArrayList)arrayList;
  }
  
  public int getOptimizationLevel() {
    return this.as;
  }
  
  public LinearSystem getSystem() {
    return this.af;
  }
  
  public String getType() {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines() {
    ArrayList<ConstraintWidget> arrayList = new ArrayList();
    int j = this.ap.size();
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.ap.get(i);
      if (constraintWidget instanceof Guideline) {
        constraintWidget = constraintWidget;
        if (constraintWidget.getOrientation() == 1)
          arrayList.add(constraintWidget); 
      } 
    } 
    return (ArrayList)arrayList;
  }
  
  public List<ConstraintWidgetGroup> getWidgetGroups() {
    return this.mWidgetGroups;
  }
  
  public boolean handlesInternalConstraints() {
    return false;
  }
  
  public boolean isHeightMeasuredTooSmall() {
    return this.au;
  }
  
  public boolean isRtl() {
    return this.aq;
  }
  
  public boolean isWidthMeasuredTooSmall() {
    return this.at;
  }
  
  public void layout() {
    boolean bool;
    int m = this.G;
    int n = this.H;
    int i1 = Math.max(0, getWidth());
    int i2 = Math.max(0, getHeight());
    this.at = false;
    this.au = false;
    if (this.B != null) {
      if (this.ar == null)
        this.ar = new Snapshot(this); 
      this.ar.updateFrom(this);
      setX(this.ag);
      setY(this.ah);
      resetAnchors();
      resetSolverVariables(this.af.getCache());
    } else {
      this.G = 0;
      this.H = 0;
    } 
    if (this.as != 0) {
      if (!optimizeFor(8))
        optimizeReset(); 
      if (!optimizeFor(32))
        optimize(); 
      this.af.graphOptimizer = true;
    } else {
      this.af.graphOptimizer = false;
    } 
    ConstraintWidget.DimensionBehaviour dimensionBehaviour1 = this.A[1];
    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.A[0];
    c();
    if (this.mWidgetGroups.size() == 0) {
      this.mWidgetGroups.clear();
      this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.ap));
    } 
    int i = this.mWidgetGroups.size();
    ArrayList<ConstraintWidget> arrayList = this.ap;
    if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      bool = true;
    } else {
      bool = false;
    } 
    int j = 0;
    int k;
    for (k = 0; k < i && !this.mSkipSolver; k++) {
      if (!((ConstraintWidgetGroup)this.mWidgetGroups.get(k)).mSkipSolver) {
        if (optimizeFor(32))
          if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED && getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            this.ap = (ArrayList<ConstraintWidget>)((ConstraintWidgetGroup)this.mWidgetGroups.get(k)).a();
          } else {
            this.ap = (ArrayList<ConstraintWidget>)((ConstraintWidgetGroup)this.mWidgetGroups.get(k)).mConstrainedGroup;
          }  
        c();
        int i5 = this.ap.size();
        int i3;
        for (i3 = 0; i3 < i5; i3++) {
          ConstraintWidget constraintWidget = this.ap.get(i3);
          if (constraintWidget instanceof WidgetContainer)
            ((WidgetContainer)constraintWidget).layout(); 
        } 
        i3 = j;
        int i4 = 0;
        boolean bool1 = true;
        j = i;
        i = i3;
        i3 = i4;
        label152: while (bool1) {
          i4 = i3 + 1;
          i3 = i;
          try {
            this.af.reset();
            i3 = i;
            c();
            i3 = i;
            createObjectVariables(this.af);
            int i7 = 0;
            while (true) {
              if (i7 < i5) {
                i3 = i;
                ConstraintWidget constraintWidget = this.ap.get(i7);
                try {
                  constraintWidget.createObjectVariables(this.af);
                  i7++;
                } catch (Exception exception) {
                  continue label152;
                } 
                continue;
              } 
              i3 = i;
              boolean bool3 = addChildrenToSolver(this.af);
              if (bool3)
                try {
                  this.af.minimize();
                } catch (Exception exception) {
                  bool1 = bool3;
                  i = i3;
                  continue label152;
                }  
              bool1 = bool3;
              i = i3;
              break;
            } 
          } catch (Exception exception) {
            i = i3;
            exception.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("EXCEPTION : ");
            stringBuilder.append(exception);
            printStream.println(stringBuilder.toString());
          } 
          if (bool1) {
            updateChildrenFromSolver(this.af, Optimizer.a);
          } else {
            updateFromSolver(this.af);
            for (i3 = 0; i3 < i5; i3++) {
              ConstraintWidget constraintWidget = this.ap.get(i3);
              if (constraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                Optimizer.a[2] = true;
                break;
              } 
              if (constraintWidget.A[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                Optimizer.a[2] = true;
                break;
              } 
            } 
          } 
          if (bool && i4 < 8 && Optimizer.a[2]) {
            boolean bool3 = false;
            int i8 = 0;
            int i7 = 0;
            i3 = i4;
            for (i4 = bool3; i4 < i5; i4++) {
              ConstraintWidget constraintWidget = this.ap.get(i4);
              i8 = Math.max(i8, constraintWidget.G + constraintWidget.getWidth());
              i7 = Math.max(i7, constraintWidget.H + constraintWidget.getHeight());
            } 
            i8 = Math.max(this.N, i8);
            i4 = Math.max(this.O, i7);
            if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getWidth() < i8) {
              setWidth(i8);
              this.A[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
              bool1 = true;
              i = 1;
            } else {
              bool1 = false;
            } 
            if (dimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < i4) {
              setHeight(i4);
              this.A[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
              bool1 = true;
              i = 1;
            } 
          } else {
            i3 = i4;
            bool1 = false;
          } 
          i4 = Math.max(this.N, getWidth());
          if (i4 > getWidth()) {
            setWidth(i4);
            this.A[0] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            i = 1;
          } 
          i4 = Math.max(this.O, getHeight());
          if (i4 > getHeight()) {
            setHeight(i4);
            this.A[1] = ConstraintWidget.DimensionBehaviour.FIXED;
            bool1 = true;
            i = 1;
          } 
          boolean bool2 = bool1;
          int i6 = i;
          if (i == 0) {
            boolean bool3 = bool1;
            i4 = i;
            if (this.A[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
              bool3 = bool1;
              i4 = i;
              if (i1 > 0) {
                bool3 = bool1;
                i4 = i;
                if (getWidth() > i1) {
                  this.at = true;
                  this.A[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setWidth(i1);
                  bool3 = true;
                  i4 = 1;
                } 
              } 
            } 
            bool2 = bool3;
            i6 = i4;
            if (this.A[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
              bool2 = bool3;
              i6 = i4;
              if (i2 > 0) {
                bool2 = bool3;
                i6 = i4;
                if (getHeight() > i2) {
                  this.au = true;
                  this.A[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                  setHeight(i2);
                  bool1 = true;
                  i = 1;
                  continue;
                } 
              } 
            } 
          } 
          bool1 = bool2;
          i = i6;
        } 
        ((ConstraintWidgetGroup)this.mWidgetGroups.get(k)).b();
        i3 = i;
        i = j;
        j = i3;
      } 
    } 
    this.ap = arrayList;
    if (this.B != null) {
      i = Math.max(this.N, getWidth());
      int i3 = Math.max(this.O, getHeight());
      this.ar.applyTo(this);
      setWidth(i + this.ag + this.ai);
      setHeight(i3 + this.ah + this.aj);
    } else {
      this.G = m;
      this.H = n;
    } 
    if (j != 0) {
      this.A[0] = dimensionBehaviour2;
      this.A[1] = dimensionBehaviour1;
    } 
    resetSolverVariables(this.af.getCache());
    if (this == getRootConstraintContainer())
      updateDrawPosition(); 
  }
  
  public void optimize() {
    if (!optimizeFor(8))
      analyze(this.as); 
    solveGraph();
  }
  
  public boolean optimizeFor(int paramInt) {
    return ((this.as & paramInt) == paramInt);
  }
  
  public void optimizeForDimensions(int paramInt1, int paramInt2) {
    if (this.A[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.a != null)
      this.a.resolve(paramInt1); 
    if (this.A[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.b != null)
      this.b.resolve(paramInt2); 
  }
  
  public void optimizeReset() {
    int j = this.ap.size();
    resetResolutionNodes();
    for (int i = 0; i < j; i++)
      ((ConstraintWidget)this.ap.get(i)).resetResolutionNodes(); 
  }
  
  public void preOptimize() {
    optimizeReset();
    analyze(this.as);
  }
  
  public void reset() {
    this.af.reset();
    this.ag = 0;
    this.ai = 0;
    this.ah = 0;
    this.aj = 0;
    this.mWidgetGroups.clear();
    this.mSkipSolver = false;
    super.reset();
  }
  
  public void resetGraph() {
    ResolutionAnchor resolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    resolutionAnchor1.invalidateAnchors();
    resolutionAnchor2.invalidateAnchors();
    resolutionAnchor1.resolve(null, 0.0F);
    resolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void setOptimizationLevel(int paramInt) {
    this.as = paramInt;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.ag = paramInt1;
    this.ah = paramInt2;
    this.ai = paramInt3;
    this.aj = paramInt4;
  }
  
  public void setRtl(boolean paramBoolean) {
    this.aq = paramBoolean;
  }
  
  public void solveGraph() {
    ResolutionAnchor resolutionAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
    ResolutionAnchor resolutionAnchor2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
    resolutionAnchor1.resolve(null, 0.0F);
    resolutionAnchor2.resolve(null, 0.0F);
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, boolean[] paramArrayOfboolean) {
    paramArrayOfboolean[2] = false;
    updateFromSolver(paramLinearSystem);
    int j = this.ap.size();
    for (int i = 0; i < j; i++) {
      ConstraintWidget constraintWidget = this.ap.get(i);
      constraintWidget.updateFromSolver(paramLinearSystem);
      if (constraintWidget.A[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth())
        paramArrayOfboolean[2] = true; 
      if (constraintWidget.A[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight())
        paramArrayOfboolean[2] = true; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ConstraintWidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */