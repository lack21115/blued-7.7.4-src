package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor {
  public static final int AUTO_CONSTRAINT_CREATOR = 2;
  
  public static final int SCOUT_CREATOR = 1;
  
  public static final int USER_CREATOR = 0;
  
  final ConstraintWidget a;
  
  final Type b;
  
  ConstraintAnchor c;
  
  int d = -1;
  
  SolverVariable e;
  
  private ResolutionAnchor f = new ResolutionAnchor(this);
  
  private Strength g = Strength.NONE;
  
  private ConnectionType h = ConnectionType.RELAXED;
  
  private int i = 0;
  
  public int mMargin = 0;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, Type paramType) {
    this.a = paramConstraintWidget;
    this.b = paramType;
  }
  
  private boolean a(ConstraintWidget paramConstraintWidget, HashSet<ConstraintWidget> paramHashSet) {
    if (paramHashSet.contains(paramConstraintWidget))
      return false; 
    paramHashSet.add(paramConstraintWidget);
    if (paramConstraintWidget == getOwner())
      return true; 
    ArrayList<ConstraintAnchor> arrayList = paramConstraintWidget.getAnchors();
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && a(constraintAnchor.getTarget().getOwner(), paramHashSet))
        return true; 
    } 
    return false;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt) {
    return connect(paramConstraintAnchor, paramInt, -1, Strength.STRONG, 0, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2) {
    return connect(paramConstraintAnchor, paramInt1, -1, Strength.STRONG, paramInt2, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, Strength paramStrength, int paramInt3, boolean paramBoolean) {
    if (paramConstraintAnchor == null) {
      this.c = null;
      this.mMargin = 0;
      this.d = -1;
      this.g = Strength.NONE;
      this.i = 2;
      return true;
    } 
    if (!paramBoolean && !isValidConnection(paramConstraintAnchor))
      return false; 
    this.c = paramConstraintAnchor;
    if (paramInt1 > 0) {
      this.mMargin = paramInt1;
    } else {
      this.mMargin = 0;
    } 
    this.d = paramInt2;
    this.g = paramStrength;
    this.i = paramInt3;
    return true;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, Strength paramStrength, int paramInt2) {
    return connect(paramConstraintAnchor, paramInt1, -1, paramStrength, paramInt2, false);
  }
  
  public int getConnectionCreator() {
    return this.i;
  }
  
  public ConnectionType getConnectionType() {
    return this.h;
  }
  
  public int getMargin() {
    if (this.a.getVisibility() == 8)
      return 0; 
    if (this.d > -1) {
      ConstraintAnchor constraintAnchor = this.c;
      if (constraintAnchor != null && constraintAnchor.a.getVisibility() == 8)
        return this.d; 
    } 
    return this.mMargin;
  }
  
  public final ConstraintAnchor getOpposite() {
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 5:
        return this.a.r;
      case 4:
        return this.a.t;
      case 3:
        return this.a.q;
      case 2:
        return this.a.s;
      case 1:
      case 6:
      case 7:
      case 8:
      case 9:
        break;
    } 
    return null;
  }
  
  public ConstraintWidget getOwner() {
    return this.a;
  }
  
  public int getPriorityLevel() {
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 7:
      case 8:
      case 9:
        return 0;
      case 6:
        return 1;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        break;
    } 
    return 2;
  }
  
  public ResolutionAnchor getResolutionNode() {
    return this.f;
  }
  
  public int getSnapPriorityLevel() {
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 9:
        return 0;
      case 8:
        return 1;
      case 7:
        return 0;
      case 6:
        return 2;
      case 4:
      case 5:
        return 0;
      case 2:
      case 3:
        return 1;
      case 1:
        break;
    } 
    return 3;
  }
  
  public SolverVariable getSolverVariable() {
    return this.e;
  }
  
  public Strength getStrength() {
    return this.g;
  }
  
  public ConstraintAnchor getTarget() {
    return this.c;
  }
  
  public Type getType() {
    return this.b;
  }
  
  public boolean isConnected() {
    return (this.c != null);
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget) {
    if (a(paramConstraintWidget, new HashSet<ConstraintWidget>()))
      return false; 
    ConstraintWidget constraintWidget = getOwner().getParent();
    return (constraintWidget == paramConstraintWidget) ? true : ((paramConstraintWidget.getParent() == constraintWidget));
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget, ConstraintAnchor paramConstraintAnchor) {
    return isConnectionAllowed(paramConstraintWidget);
  }
  
  public boolean isSideAnchor() {
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 2:
      case 3:
      case 4:
      case 5:
        return true;
      case 1:
      case 6:
      case 7:
      case 8:
      case 9:
        break;
    } 
    return false;
  }
  
  public boolean isSimilarDimensionConnection(ConstraintAnchor paramConstraintAnchor) {
    boolean bool1;
    Type type1 = paramConstraintAnchor.getType();
    Type type2 = this.b;
    boolean bool3 = true;
    boolean bool2 = true;
    if (type1 == type2)
      return true; 
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 9:
        return false;
      case 4:
      case 5:
      case 6:
      case 8:
        bool1 = bool2;
        if (type1 != Type.TOP) {
          bool1 = bool2;
          if (type1 != Type.BOTTOM) {
            bool1 = bool2;
            if (type1 != Type.CENTER_Y) {
              if (type1 == Type.BASELINE)
                return true; 
              bool1 = false;
            } 
          } 
        } 
        return bool1;
      case 2:
      case 3:
      case 7:
        bool1 = bool3;
        if (type1 != Type.LEFT) {
          bool1 = bool3;
          if (type1 != Type.RIGHT) {
            if (type1 == Type.CENTER_X)
              return true; 
            bool1 = false;
          } 
        } 
        return bool1;
      case 1:
        break;
    } 
    return (type1 != Type.BASELINE);
  }
  
  public boolean isSnapCompatibleWith(ConstraintAnchor paramConstraintAnchor) {
    int i;
    if (this.b == Type.CENTER)
      return false; 
    if (this.b == paramConstraintAnchor.getType())
      return true; 
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 8:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 4 && i != 5);
      case 7:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 2 && i != 3);
      case 5:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 4 && i != 8);
      case 4:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 5 && i != 8);
      case 3:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 2 && i != 7);
      case 2:
        i = null.a[paramConstraintAnchor.getType().ordinal()];
        return !(i != 3 && i != 7);
      case 1:
      case 6:
      case 9:
        break;
    } 
    return false;
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor) {
    boolean bool2 = false;
    if (paramConstraintAnchor == null)
      return false; 
    Type type1 = paramConstraintAnchor.getType();
    Type type2 = this.b;
    if (type1 == type2)
      return !(type2 == Type.BASELINE && (!paramConstraintAnchor.getOwner().hasBaseline() || !getOwner().hasBaseline())); 
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 6:
      case 7:
      case 8:
      case 9:
        return false;
      case 4:
      case 5:
        if (type1 == Type.TOP || type1 == Type.BOTTOM) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        bool2 = bool1;
        return (paramConstraintAnchor.getOwner() instanceof Guideline) ? ((bool1 || type1 == Type.CENTER_Y)) : bool2;
      case 2:
      case 3:
        if (type1 == Type.LEFT || type1 == Type.RIGHT) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        bool2 = bool1;
        return (paramConstraintAnchor.getOwner() instanceof Guideline) ? ((bool1 || type1 == Type.CENTER_X)) : bool2;
      case 1:
        break;
    } 
    boolean bool1 = bool2;
    if (type1 != Type.BASELINE) {
      bool1 = bool2;
      if (type1 != Type.CENTER_X) {
        bool1 = bool2;
        if (type1 != Type.CENTER_Y)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public boolean isVerticalAnchor() {
    switch (null.a[this.b.ordinal()]) {
      default:
        throw new AssertionError(this.b.name());
      case 4:
      case 5:
      case 6:
      case 8:
      case 9:
        return true;
      case 1:
      case 2:
      case 3:
      case 7:
        break;
    } 
    return false;
  }
  
  public void reset() {
    this.c = null;
    this.mMargin = 0;
    this.d = -1;
    this.g = Strength.STRONG;
    this.i = 0;
    this.h = ConnectionType.RELAXED;
    this.f.reset();
  }
  
  public void resetSolverVariable(Cache paramCache) {
    SolverVariable solverVariable = this.e;
    if (solverVariable == null) {
      this.e = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
      return;
    } 
    solverVariable.reset();
  }
  
  public void setConnectionCreator(int paramInt) {
    this.i = paramInt;
  }
  
  public void setConnectionType(ConnectionType paramConnectionType) {
    this.h = paramConnectionType;
  }
  
  public void setGoneMargin(int paramInt) {
    if (isConnected())
      this.d = paramInt; 
  }
  
  public void setMargin(int paramInt) {
    if (isConnected())
      this.mMargin = paramInt; 
  }
  
  public void setStrength(Strength paramStrength) {
    if (isConnected())
      this.g = paramStrength; 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.getDebugName());
    stringBuilder.append(":");
    stringBuilder.append(this.b.toString());
    return stringBuilder.toString();
  }
  
  public enum ConnectionType {
    RELAXED, STRICT;
  }
  
  public enum Strength {
    NONE, STRONG, WEAK;
  }
  
  public enum Type {
    NONE, RIGHT, TOP, BASELINE, BOTTOM, CENTER, CENTER_X, CENTER_Y, LEFT;
    
    static {
      RIGHT = new Type("RIGHT", 3);
      BOTTOM = new Type("BOTTOM", 4);
      BASELINE = new Type("BASELINE", 5);
      CENTER = new Type("CENTER", 6);
      CENTER_X = new Type("CENTER_X", 7);
      CENTER_Y = new Type("CENTER_Y", 8);
      a = new Type[] { NONE, LEFT, TOP, RIGHT, BOTTOM, BASELINE, CENTER, CENTER_X, CENTER_Y };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ConstraintAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */