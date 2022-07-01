package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
  public static final boolean FULL_DEBUG = false;
  
  private static int f = 1000;
  
  public static Metrics sMetrics;
  
  int a = 0;
  
  ArrayRow[] b;
  
  int c;
  
  int d;
  
  final Cache e;
  
  private HashMap<String, SolverVariable> g = null;
  
  public boolean graphOptimizer;
  
  private Row h;
  
  private int i = 32;
  
  private int j;
  
  private boolean[] k;
  
  private int l;
  
  private SolverVariable[] m;
  
  private int n;
  
  private ArrayRow[] o;
  
  private final Row p;
  
  public LinearSystem() {
    int i = this.i;
    this.j = i;
    this.b = null;
    this.graphOptimizer = false;
    this.k = new boolean[i];
    this.c = 1;
    this.d = 0;
    this.l = i;
    this.m = new SolverVariable[f];
    this.n = 0;
    this.o = new ArrayRow[i];
    this.b = new ArrayRow[i];
    b();
    this.e = new Cache();
    this.h = new GoalRow(this.e);
    this.p = new ArrayRow(this.e);
  }
  
  private final int a(Row paramRow, boolean paramBoolean) {
    Metrics metrics = sMetrics;
    if (metrics != null)
      metrics.optimize++; 
    int i;
    for (i = 0; i < this.c; i++)
      this.k[i] = false; 
    boolean bool = false;
    for (i = 0; !bool; i = j) {
      metrics = sMetrics;
      if (metrics != null)
        metrics.iterations++; 
      int j = i + 1;
      if (j >= this.c * 2)
        return j; 
      if (paramRow.getKey() != null)
        this.k[(paramRow.getKey()).id] = true; 
      SolverVariable solverVariable = paramRow.getPivotCandidate(this, this.k);
      if (solverVariable != null) {
        if (this.k[solverVariable.id])
          return j; 
        this.k[solverVariable.id] = true;
      } 
      if (solverVariable != null) {
        i = 0;
        int k = -1;
        for (float f = Float.MAX_VALUE; i < this.d; f = f1) {
          float f1;
          int m;
          ArrayRow arrayRow = this.b[i];
          if (arrayRow.a.c == SolverVariable.Type.UNRESTRICTED) {
            m = k;
            f1 = f;
          } else if (arrayRow.d) {
            m = k;
            f1 = f;
          } else {
            m = k;
            f1 = f;
            if (arrayRow.a(solverVariable)) {
              float f2 = arrayRow.variables.get(solverVariable);
              m = k;
              f1 = f;
              if (f2 < 0.0F) {
                f2 = -arrayRow.b / f2;
                m = k;
                f1 = f;
                if (f2 < f) {
                  m = i;
                  f1 = f2;
                } 
              } 
            } 
          } 
          i++;
          k = m;
        } 
        if (k > -1) {
          ArrayRow arrayRow = this.b[k];
          arrayRow.a.a = -1;
          Metrics metrics1 = sMetrics;
          if (metrics1 != null)
            metrics1.pivots++; 
          arrayRow.c(solverVariable);
          arrayRow.a.a = k;
          arrayRow.a.updateReferencesWithNewDefinition(arrayRow);
          i = j;
          continue;
        } 
      } 
      bool = true;
    } 
    return i;
  }
  
  private SolverVariable a(SolverVariable.Type paramType, String paramString) {
    SolverVariable solverVariable1;
    SolverVariable solverVariable2 = this.e.b.acquire();
    if (solverVariable2 == null) {
      solverVariable2 = new SolverVariable(paramType, paramString);
      solverVariable2.setType(paramType, paramString);
      solverVariable1 = solverVariable2;
    } else {
      solverVariable2.reset();
      solverVariable2.setType((SolverVariable.Type)solverVariable1, paramString);
      solverVariable1 = solverVariable2;
    } 
    int i = this.n;
    int j = f;
    if (i >= j) {
      f = j * 2;
      this.m = Arrays.<SolverVariable>copyOf(this.m, f);
    } 
    SolverVariable[] arrayOfSolverVariable = this.m;
    i = this.n;
    this.n = i + 1;
    arrayOfSolverVariable[i] = solverVariable1;
    return solverVariable1;
  }
  
  private void a() {
    this.i *= 2;
    this.b = Arrays.<ArrayRow>copyOf(this.b, this.i);
    Cache cache = this.e;
    cache.c = Arrays.<SolverVariable>copyOf(cache.c, this.i);
    int i = this.i;
    this.k = new boolean[i];
    this.j = i;
    this.l = i;
    Metrics metrics = sMetrics;
    if (metrics != null) {
      metrics.tableSizeIncrease++;
      metrics = sMetrics;
      metrics.maxTableSize = Math.max(metrics.maxTableSize, this.i);
      metrics = sMetrics;
      metrics.lastTableSize = metrics.maxTableSize;
    } 
  }
  
  private void a(ArrayRow paramArrayRow) {
    paramArrayRow.addError(this, 0);
  }
  
  private void a(ArrayRow paramArrayRow, int paramInt) {
    a(paramArrayRow, paramInt, 0);
  }
  
  private int b(Row paramRow) throws Exception {
    boolean bool;
    int i = 0;
    while (true) {
      if (i < this.d) {
        if ((this.b[i]).a.c != SolverVariable.Type.UNRESTRICTED && (this.b[i]).b < 0.0F) {
          i = 1;
          break;
        } 
        i++;
        continue;
      } 
      i = 0;
      break;
    } 
    if (i != 0) {
      boolean bool1 = false;
      i = 0;
      while (true) {
        bool = i;
        if (!bool1) {
          Metrics metrics = sMetrics;
          if (metrics != null)
            metrics.bfs++; 
          int m = i + 1;
          int k = 0;
          i = -1;
          bool = true;
          float f = Float.MAX_VALUE;
          int j;
          for (j = 0; k < this.d; j = i2) {
            float f1;
            int n;
            int i1;
            int i2;
            ArrayRow arrayRow = this.b[k];
            if (arrayRow.a.c == SolverVariable.Type.UNRESTRICTED) {
              n = i;
              i1 = bool;
              f1 = f;
              i2 = j;
            } else if (arrayRow.d) {
              n = i;
              i1 = bool;
              f1 = f;
              i2 = j;
            } else {
              n = i;
              i1 = bool;
              f1 = f;
              i2 = j;
              if (arrayRow.b < 0.0F) {
                int i3;
                for (i3 = 1;; i3++) {
                  n = i;
                  i1 = bool;
                  f1 = f;
                  i2 = j;
                  if (i3 < this.c) {
                    SolverVariable solverVariable = this.e.c[i3];
                    float f2 = arrayRow.variables.get(solverVariable);
                    if (f2 <= 0.0F)
                      continue; 
                    i1 = j;
                    i2 = 0;
                    j = bool;
                    n = i;
                    i = i2;
                    for (bool = i1;; bool = i1)
                      i++; 
                    i = j;
                    j = bool;
                    bool = i;
                    i = n;
                    continue;
                  } 
                  break;
                } 
              } 
            } 
            k++;
            i = n;
            bool = i1;
            f = f1;
          } 
          if (i != -1) {
            ArrayRow arrayRow = this.b[i];
            arrayRow.a.a = -1;
            Metrics metrics1 = sMetrics;
            if (metrics1 != null)
              metrics1.pivots++; 
            arrayRow.c(this.e.c[bool]);
            arrayRow.a.a = i;
            arrayRow.a.updateReferencesWithNewDefinition(arrayRow);
          } else {
            bool1 = true;
          } 
          if (m > this.c / 2)
            bool1 = true; 
          i = m;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private void b() {
    int i = 0;
    while (true) {
      ArrayRow[] arrayOfArrayRow = this.b;
      if (i < arrayOfArrayRow.length) {
        ArrayRow arrayRow = arrayOfArrayRow[i];
        if (arrayRow != null)
          this.e.a.release(arrayRow); 
        this.b[i] = null;
        i++;
        continue;
      } 
      break;
    } 
  }
  
  private final void b(ArrayRow paramArrayRow) {
    if (this.d > 0) {
      paramArrayRow.variables.a(paramArrayRow, this.b);
      if (paramArrayRow.variables.a == 0)
        paramArrayRow.d = true; 
    } 
  }
  
  private void c() {
    for (int i = 0; i < this.d; i++) {
      ArrayRow arrayRow = this.b[i];
      arrayRow.a.computedValue = arrayRow.b;
    } 
  }
  
  private final void c(ArrayRow paramArrayRow) {
    if (this.b[this.d] != null)
      this.e.a.release(this.b[this.d]); 
    this.b[this.d] = paramArrayRow;
    SolverVariable solverVariable = paramArrayRow.a;
    int i = this.d;
    solverVariable.a = i;
    this.d = i + 1;
    paramArrayRow.a.updateReferencesWithNewDefinition(paramArrayRow);
  }
  
  public static ArrayRow createRowCentering(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.a(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramBoolean)
      arrayRow.addError(paramLinearSystem, 4); 
    return arrayRow;
  }
  
  public static ArrayRow createRowDimensionPercent(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    if (paramBoolean)
      paramLinearSystem.a(arrayRow); 
    return arrayRow.a(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramFloat);
  }
  
  public static ArrayRow createRowEquals(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt);
    if (paramBoolean)
      paramLinearSystem.a(arrayRow, 1); 
    return arrayRow;
  }
  
  public static ArrayRow createRowGreaterThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    SolverVariable solverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt);
    if (paramBoolean)
      paramLinearSystem.a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F)); 
    return arrayRow;
  }
  
  public static ArrayRow createRowLowerThan(LinearSystem paramLinearSystem, SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt, boolean paramBoolean) {
    SolverVariable solverVariable = paramLinearSystem.createSlackVariable();
    ArrayRow arrayRow = paramLinearSystem.createRow();
    arrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt);
    if (paramBoolean)
      paramLinearSystem.a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F)); 
    return arrayRow;
  }
  
  private void d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Display Rows (");
    stringBuilder.append(this.d);
    stringBuilder.append("x");
    stringBuilder.append(this.c);
    stringBuilder.append(")\n");
    String str = stringBuilder.toString();
    System.out.println(str);
  }
  
  public static Metrics getMetrics() {
    return sMetrics;
  }
  
  void a(ArrayRow paramArrayRow, int paramInt1, int paramInt2) {
    paramArrayRow.b(createErrorVariable(paramInt2, null), paramInt1);
  }
  
  void a(Row paramRow) throws Exception {
    Metrics metrics = sMetrics;
    if (metrics != null) {
      metrics.minimizeGoal++;
      metrics = sMetrics;
      metrics.maxVariables = Math.max(metrics.maxVariables, this.c);
      metrics = sMetrics;
      metrics.maxRows = Math.max(metrics.maxRows, this.d);
    } 
    b((ArrayRow)paramRow);
    b(paramRow);
    a(paramRow, false);
    c();
  }
  
  public void addCenterPoint(ConstraintWidget paramConstraintWidget1, ConstraintWidget paramConstraintWidget2, float paramFloat, int paramInt) {
    SolverVariable solverVariable3 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable solverVariable5 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable solverVariable4 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT));
    SolverVariable solverVariable7 = createObjectVariable(paramConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM));
    SolverVariable solverVariable1 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
    SolverVariable solverVariable8 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
    SolverVariable solverVariable6 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
    SolverVariable solverVariable2 = createObjectVariable(paramConstraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
    ArrayRow arrayRow2 = createRow();
    double d1 = paramFloat;
    double d2 = Math.sin(d1);
    double d3 = paramInt;
    arrayRow2.createRowWithAngle(solverVariable5, solverVariable7, solverVariable8, solverVariable2, (float)(d2 * d3));
    addConstraint(arrayRow2);
    ArrayRow arrayRow1 = createRow();
    arrayRow1.createRowWithAngle(solverVariable3, solverVariable4, solverVariable1, solverVariable6, (float)(Math.cos(d1) * d3));
    addConstraint(arrayRow1);
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3) {
    ArrayRow arrayRow = createRow();
    arrayRow.a(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2);
    if (paramInt3 != 6)
      arrayRow.addError(this, paramInt3); 
    addConstraint(arrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow) {
    if (paramArrayRow == null)
      return; 
    Metrics metrics = sMetrics;
    if (metrics != null) {
      metrics.constraints++;
      if (paramArrayRow.d) {
        metrics = sMetrics;
        metrics.simpleconstraints++;
      } 
    } 
    if (this.d + 1 >= this.l || this.c + 1 >= this.j)
      a(); 
    boolean bool1 = false;
    boolean bool2 = false;
    if (!paramArrayRow.d) {
      b(paramArrayRow);
      if (paramArrayRow.isEmpty())
        return; 
      paramArrayRow.d();
      bool1 = bool2;
      if (paramArrayRow.a(this)) {
        SolverVariable solverVariable = createExtraVariable();
        paramArrayRow.a = solverVariable;
        c(paramArrayRow);
        this.p.initFromRow(paramArrayRow);
        a(this.p, true);
        if (solverVariable.a == -1) {
          if (paramArrayRow.a == solverVariable) {
            solverVariable = paramArrayRow.b(solverVariable);
            if (solverVariable != null) {
              Metrics metrics1 = sMetrics;
              if (metrics1 != null)
                metrics1.pivots++; 
              paramArrayRow.c(solverVariable);
            } 
          } 
          if (!paramArrayRow.d)
            paramArrayRow.a.updateReferencesWithNewDefinition(paramArrayRow); 
          this.d--;
        } 
        bool1 = true;
      } 
      if (!paramArrayRow.a())
        return; 
    } 
    if (!bool1)
      c(paramArrayRow); 
  }
  
  public ArrayRow addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    arrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    if (paramInt2 != 6)
      arrayRow.addError(this, paramInt2); 
    addConstraint(arrayRow);
    return arrayRow;
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt) {
    int i = paramSolverVariable.a;
    if (paramSolverVariable.a != -1) {
      ArrayRow arrayRow1 = this.b[i];
      if (arrayRow1.d) {
        arrayRow1.b = paramInt;
        return;
      } 
      if (arrayRow1.variables.a == 0) {
        arrayRow1.d = true;
        arrayRow1.b = paramInt;
        return;
      } 
      arrayRow1 = createRow();
      arrayRow1.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(arrayRow1);
      return;
    } 
    ArrayRow arrayRow = createRow();
    arrayRow.a(paramSolverVariable, paramInt);
    addConstraint(arrayRow);
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt1, int paramInt2) {
    int i = paramSolverVariable.a;
    if (paramSolverVariable.a != -1) {
      ArrayRow arrayRow1 = this.b[i];
      if (arrayRow1.d) {
        arrayRow1.b = paramInt1;
        return;
      } 
      arrayRow1 = createRow();
      arrayRow1.createRowEquals(paramSolverVariable, paramInt1);
      arrayRow1.addError(this, paramInt2);
      addConstraint(arrayRow1);
      return;
    } 
    ArrayRow arrayRow = createRow();
    arrayRow.a(paramSolverVariable, paramInt1);
    arrayRow.addError(this, paramInt2);
    addConstraint(arrayRow);
  }
  
  public void addGreaterBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = 0;
    arrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, solverVariable, 0);
    if (paramBoolean)
      a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F), 1); 
    addConstraint(arrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable, int paramInt) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = 0;
    arrayRow.createRowGreaterThan(paramSolverVariable, paramInt, solverVariable);
    addConstraint(arrayRow);
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = 0;
    arrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt1);
    if (paramInt2 != 6)
      a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F), paramInt2); 
    addConstraint(arrayRow);
  }
  
  public void addLowerBarrier(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, boolean paramBoolean) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = 0;
    arrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, solverVariable, 0);
    if (paramBoolean)
      a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F), 1); 
    addConstraint(arrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2) {
    ArrayRow arrayRow = createRow();
    SolverVariable solverVariable = createSlackVariable();
    solverVariable.strength = 0;
    arrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, solverVariable, paramInt1);
    if (paramInt2 != 6)
      a(arrayRow, (int)(arrayRow.variables.get(solverVariable) * -1.0F), paramInt2); 
    addConstraint(arrayRow);
  }
  
  public void addRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat, int paramInt) {
    ArrayRow arrayRow = createRow();
    arrayRow.createRowDimensionRatio(paramSolverVariable1, paramSolverVariable2, paramSolverVariable3, paramSolverVariable4, paramFloat);
    if (paramInt != 6)
      arrayRow.addError(this, paramInt); 
    addConstraint(arrayRow);
  }
  
  public SolverVariable createErrorVariable(int paramInt, String paramString) {
    Metrics metrics = sMetrics;
    if (metrics != null)
      metrics.errors++; 
    if (this.c + 1 >= this.j)
      a(); 
    SolverVariable solverVariable = a(SolverVariable.Type.ERROR, paramString);
    this.a++;
    this.c++;
    solverVariable.id = this.a;
    solverVariable.strength = paramInt;
    this.e.c[this.a] = solverVariable;
    this.h.addError(solverVariable);
    return solverVariable;
  }
  
  public SolverVariable createExtraVariable() {
    Metrics metrics = sMetrics;
    if (metrics != null)
      metrics.extravariables++; 
    if (this.c + 1 >= this.j)
      a(); 
    SolverVariable solverVariable = a(SolverVariable.Type.SLACK, (String)null);
    this.a++;
    this.c++;
    solverVariable.id = this.a;
    this.e.c[this.a] = solverVariable;
    return solverVariable;
  }
  
  public SolverVariable createObjectVariable(Object paramObject) {
    SolverVariable solverVariable = null;
    if (paramObject == null)
      return null; 
    if (this.c + 1 >= this.j)
      a(); 
    if (paramObject instanceof ConstraintAnchor) {
      ConstraintAnchor constraintAnchor = (ConstraintAnchor)paramObject;
      solverVariable = constraintAnchor.getSolverVariable();
      paramObject = solverVariable;
      if (solverVariable == null) {
        constraintAnchor.resetSolverVariable(this.e);
        paramObject = constraintAnchor.getSolverVariable();
      } 
      if (((SolverVariable)paramObject).id != -1 && ((SolverVariable)paramObject).id <= this.a) {
        Object object = paramObject;
        if (this.e.c[((SolverVariable)paramObject).id] == null) {
          if (((SolverVariable)paramObject).id != -1)
            paramObject.reset(); 
          this.a++;
          this.c++;
          ((SolverVariable)paramObject).id = this.a;
          ((SolverVariable)paramObject).c = SolverVariable.Type.UNRESTRICTED;
          this.e.c[this.a] = (SolverVariable)paramObject;
          return (SolverVariable)paramObject;
        } 
        return (SolverVariable)object;
      } 
    } else {
      return solverVariable;
    } 
    if (((SolverVariable)paramObject).id != -1)
      paramObject.reset(); 
    this.a++;
    this.c++;
    ((SolverVariable)paramObject).id = this.a;
    ((SolverVariable)paramObject).c = SolverVariable.Type.UNRESTRICTED;
    this.e.c[this.a] = (SolverVariable)paramObject;
    return (SolverVariable)paramObject;
  }
  
  public ArrayRow createRow() {
    ArrayRow arrayRow = this.e.a.acquire();
    if (arrayRow == null) {
      arrayRow = new ArrayRow(this.e);
    } else {
      arrayRow.reset();
    } 
    SolverVariable.a();
    return arrayRow;
  }
  
  public SolverVariable createSlackVariable() {
    Metrics metrics = sMetrics;
    if (metrics != null)
      metrics.slackvariables++; 
    if (this.c + 1 >= this.j)
      a(); 
    SolverVariable solverVariable = a(SolverVariable.Type.SLACK, (String)null);
    this.a++;
    this.c++;
    solverVariable.id = this.a;
    this.e.c[this.a] = solverVariable;
    return solverVariable;
  }
  
  public void displayVariablesReadableRows() {
    d();
    String str = "";
    int i = 0;
    while (i < this.d) {
      String str1 = str;
      if ((this.b[i]).a.c == SolverVariable.Type.UNRESTRICTED) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(this.b[i].b());
        str = stringBuilder1.toString();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append("\n");
        str1 = stringBuilder1.toString();
      } 
      i++;
      str = str1;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.h);
    stringBuilder.append("\n");
    str = stringBuilder.toString();
    System.out.println(str);
  }
  
  public void fillMetrics(Metrics paramMetrics) {
    sMetrics = paramMetrics;
  }
  
  public Cache getCache() {
    return this.e;
  }
  
  public int getMemoryUsed() {
    int i = 0;
    int j;
    for (j = 0; i < this.d; j = k) {
      ArrayRow[] arrayOfArrayRow = this.b;
      int k = j;
      if (arrayOfArrayRow[i] != null)
        k = j + arrayOfArrayRow[i].c(); 
      i++;
    } 
    return j;
  }
  
  public int getNumEquations() {
    return this.d;
  }
  
  public int getNumVariables() {
    return this.a;
  }
  
  public int getObjectVariableValue(Object paramObject) {
    paramObject = ((ConstraintAnchor)paramObject).getSolverVariable();
    return (paramObject != null) ? (int)(((SolverVariable)paramObject).computedValue + 0.5F) : 0;
  }
  
  public void minimize() throws Exception {
    Metrics metrics = sMetrics;
    if (metrics != null)
      metrics.minimize++; 
    if (this.graphOptimizer) {
      metrics = sMetrics;
      if (metrics != null)
        metrics.graphOptimizer++; 
      byte b = 0;
      int i = 0;
      while (true) {
        if (i < this.d) {
          if (!(this.b[i]).d) {
            i = b;
            break;
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
      if (i == 0) {
        a(this.h);
        return;
      } 
      metrics = sMetrics;
      if (metrics != null)
        metrics.fullySolved++; 
      c();
      return;
    } 
    a(this.h);
  }
  
  public void reset() {
    int i;
    for (i = 0; i < this.e.c.length; i++) {
      SolverVariable solverVariable = this.e.c[i];
      if (solverVariable != null)
        solverVariable.reset(); 
    } 
    this.e.b.releaseAll(this.m, this.n);
    this.n = 0;
    Arrays.fill((Object[])this.e.c, (Object)null);
    HashMap<String, SolverVariable> hashMap = this.g;
    if (hashMap != null)
      hashMap.clear(); 
    this.a = 0;
    this.h.clear();
    this.c = 1;
    for (i = 0; i < this.d; i++)
      (this.b[i]).c = false; 
    b();
    this.d = 0;
  }
  
  static interface Row {
    void addError(SolverVariable param1SolverVariable);
    
    void clear();
    
    SolverVariable getKey();
    
    SolverVariable getPivotCandidate(LinearSystem param1LinearSystem, boolean[] param1ArrayOfboolean);
    
    void initFromRow(Row param1Row);
    
    boolean isEmpty();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\LinearSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */