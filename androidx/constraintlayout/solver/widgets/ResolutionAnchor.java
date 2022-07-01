package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;

public class ResolutionAnchor extends ResolutionNode {
  public static final int BARRIER_CONNECTION = 5;
  
  public static final int CENTER_CONNECTION = 2;
  
  public static final int CHAIN_CONNECTION = 4;
  
  public static final int DIRECT_CONNECTION = 1;
  
  public static final int MATCH_CONNECTION = 3;
  
  public static final int UNCONNECTED = 0;
  
  ConstraintAnchor a;
  
  float b;
  
  ResolutionAnchor c;
  
  float d;
  
  ResolutionAnchor e;
  
  float f;
  
  int g = 0;
  
  private ResolutionAnchor j;
  
  private float k;
  
  private ResolutionDimension l = null;
  
  private int m = 1;
  
  private ResolutionDimension n = null;
  
  private int o = 1;
  
  public ResolutionAnchor(ConstraintAnchor paramConstraintAnchor) {
    this.a = paramConstraintAnchor;
  }
  
  String a(int paramInt) {
    return (paramInt == 1) ? "DIRECT" : ((paramInt == 2) ? "CENTER" : ((paramInt == 3) ? "MATCH" : ((paramInt == 4) ? "CHAIN" : ((paramInt == 5) ? "BARRIER" : "UNCONNECTED"))));
  }
  
  void a(LinearSystem paramLinearSystem) {
    SolverVariable solverVariable = this.a.getSolverVariable();
    ResolutionAnchor resolutionAnchor = this.e;
    if (resolutionAnchor == null) {
      paramLinearSystem.addEquality(solverVariable, (int)(this.f + 0.5F));
      return;
    } 
    paramLinearSystem.addEquality(solverVariable, paramLinearSystem.createObjectVariable(resolutionAnchor.a), (int)(this.f + 0.5F), 6);
  }
  
  public void dependsOn(int paramInt1, ResolutionAnchor paramResolutionAnchor, int paramInt2) {
    this.g = paramInt1;
    this.c = paramResolutionAnchor;
    this.d = paramInt2;
    this.c.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt) {
    this.c = paramResolutionAnchor;
    this.d = paramInt;
    this.c.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension) {
    this.c = paramResolutionAnchor;
    this.c.addDependent(this);
    this.l = paramResolutionDimension;
    this.m = paramInt;
    this.l.addDependent(this);
  }
  
  public float getResolvedValue() {
    return this.f;
  }
  
  public void remove(ResolutionDimension paramResolutionDimension) {
    ResolutionDimension resolutionDimension = this.l;
    if (resolutionDimension == paramResolutionDimension) {
      this.l = null;
      this.d = this.m;
    } else if (resolutionDimension == this.n) {
      this.n = null;
      this.k = this.o;
    } 
    resolve();
  }
  
  public void reset() {
    super.reset();
    this.c = null;
    this.d = 0.0F;
    this.l = null;
    this.m = 1;
    this.n = null;
    this.o = 1;
    this.e = null;
    this.f = 0.0F;
    this.b = 0.0F;
    this.j = null;
    this.k = 0.0F;
    this.g = 0;
  }
  
  public void resolve() {
    int i = this.i;
    int j = 1;
    if (i == 1)
      return; 
    if (this.g == 4)
      return; 
    ResolutionDimension resolutionDimension = this.l;
    if (resolutionDimension != null) {
      if (resolutionDimension.i != 1)
        return; 
      this.d = this.m * this.l.a;
    } 
    resolutionDimension = this.n;
    if (resolutionDimension != null) {
      if (resolutionDimension.i != 1)
        return; 
      this.k = this.o * this.n.a;
    } 
    if (this.g == 1) {
      ResolutionAnchor resolutionAnchor = this.c;
      if (resolutionAnchor == null || resolutionAnchor.i == 1) {
        resolutionAnchor = this.c;
        if (resolutionAnchor == null) {
          this.e = this;
          this.f = this.d;
        } else {
          this.e = resolutionAnchor.e;
          resolutionAnchor.f += this.d;
        } 
        didResolve();
        return;
      } 
    } 
    if (this.g == 2) {
      ResolutionAnchor resolutionAnchor = this.c;
      if (resolutionAnchor != null && resolutionAnchor.i == 1) {
        resolutionAnchor = this.j;
        if (resolutionAnchor != null) {
          resolutionAnchor = resolutionAnchor.c;
          if (resolutionAnchor != null && resolutionAnchor.i == 1) {
            float f1;
            if (LinearSystem.getMetrics() != null) {
              Metrics metrics = LinearSystem.getMetrics();
              metrics.centerConnectionResolved++;
            } 
            this.e = this.c.e;
            resolutionAnchor = this.j;
            resolutionAnchor.e = resolutionAnchor.c.e;
            ConstraintAnchor.Type type1 = this.a.b;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            int k = 0;
            i = j;
            if (type1 != type2)
              if (this.a.b == ConstraintAnchor.Type.BOTTOM) {
                i = j;
              } else {
                i = 0;
              }  
            if (i != 0) {
              f1 = this.c.f;
              f2 = this.j.c.f;
            } else {
              f1 = this.j.c.f;
              f2 = this.c.f;
            } 
            f1 -= f2;
            if (this.a.b == ConstraintAnchor.Type.LEFT || this.a.b == ConstraintAnchor.Type.RIGHT) {
              f2 = f1 - this.a.a.getWidth();
              f1 = this.a.a.P;
            } else {
              f2 = f1 - this.a.a.getHeight();
              f1 = this.a.a.Q;
            } 
            int m = this.a.getMargin();
            j = this.j.a.getMargin();
            if (this.a.getTarget() == this.j.a.getTarget()) {
              f1 = 0.5F;
              j = 0;
            } else {
              k = m;
            } 
            float f3 = k;
            float f4 = j;
            float f2 = f2 - f3 - f4;
            if (i != 0) {
              ResolutionAnchor resolutionAnchor1 = this.j;
              resolutionAnchor1.f = resolutionAnchor1.c.f + f4 + f2 * f1;
              this.f = this.c.f - f3 - f2 * (1.0F - f1);
            } else {
              this.f = this.c.f + f3 + f2 * f1;
              ResolutionAnchor resolutionAnchor1 = this.j;
              resolutionAnchor1.f = resolutionAnchor1.c.f - f4 - f2 * (1.0F - f1);
            } 
            didResolve();
            this.j.didResolve();
            return;
          } 
        } 
      } 
    } 
    if (this.g == 3) {
      ResolutionAnchor resolutionAnchor = this.c;
      if (resolutionAnchor != null && resolutionAnchor.i == 1) {
        resolutionAnchor = this.j;
        if (resolutionAnchor != null) {
          resolutionAnchor = resolutionAnchor.c;
          if (resolutionAnchor != null && resolutionAnchor.i == 1) {
            if (LinearSystem.getMetrics() != null) {
              Metrics metrics = LinearSystem.getMetrics();
              metrics.matchConnectionResolved++;
            } 
            resolutionAnchor = this.c;
            this.e = resolutionAnchor.e;
            ResolutionAnchor resolutionAnchor1 = this.j;
            ResolutionAnchor resolutionAnchor2 = resolutionAnchor1.c;
            resolutionAnchor1.e = resolutionAnchor2.e;
            resolutionAnchor.f += this.d;
            resolutionAnchor2.f += resolutionAnchor1.d;
            didResolve();
            this.j.didResolve();
            return;
          } 
        } 
      } 
    } 
    if (this.g == 5)
      this.a.a.resolve(); 
  }
  
  public void resolve(ResolutionAnchor paramResolutionAnchor, float paramFloat) {
    if (this.i == 0 || (this.e != paramResolutionAnchor && this.f != paramFloat)) {
      this.e = paramResolutionAnchor;
      this.f = paramFloat;
      if (this.i == 1)
        invalidate(); 
      didResolve();
    } 
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, float paramFloat) {
    this.j = paramResolutionAnchor;
    this.k = paramFloat;
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension) {
    this.j = paramResolutionAnchor;
    this.n = paramResolutionDimension;
    this.o = paramInt;
  }
  
  public void setType(int paramInt) {
    this.g = paramInt;
  }
  
  public String toString() {
    if (this.i == 1) {
      if (this.e == this) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", RESOLVED: ");
        stringBuilder2.append(this.f);
        stringBuilder2.append("]  type: ");
        stringBuilder2.append(a(this.g));
        return stringBuilder2.toString();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[");
      stringBuilder1.append(this.a);
      stringBuilder1.append(", RESOLVED: ");
      stringBuilder1.append(this.e);
      stringBuilder1.append(":");
      stringBuilder1.append(this.f);
      stringBuilder1.append("] type: ");
      stringBuilder1.append(a(this.g));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{ ");
    stringBuilder.append(this.a);
    stringBuilder.append(" UNRESOLVED} type: ");
    stringBuilder.append(a(this.g));
    return stringBuilder.toString();
  }
  
  public void update() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   4: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull -> 13
    //   12: return
    //   13: aload_3
    //   14: invokevirtual getTarget : ()Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   17: aload_0
    //   18: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   21: if_acmpne -> 37
    //   24: aload_0
    //   25: iconst_4
    //   26: putfield g : I
    //   29: aload_3
    //   30: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   33: iconst_4
    //   34: putfield g : I
    //   37: aload_0
    //   38: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   41: invokevirtual getMargin : ()I
    //   44: istore_2
    //   45: aload_0
    //   46: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   49: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   52: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.RIGHT : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   55: if_acmpeq -> 73
    //   58: iload_2
    //   59: istore_1
    //   60: aload_0
    //   61: getfield a : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor;
    //   64: getfield b : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   67: getstatic androidx/constraintlayout/solver/widgets/ConstraintAnchor$Type.BOTTOM : Landroidx/constraintlayout/solver/widgets/ConstraintAnchor$Type;
    //   70: if_acmpne -> 76
    //   73: iload_2
    //   74: ineg
    //   75: istore_1
    //   76: aload_0
    //   77: aload_3
    //   78: invokevirtual getResolutionNode : ()Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;
    //   81: iload_1
    //   82: invokevirtual dependsOn : (Landroidx/constraintlayout/solver/widgets/ResolutionAnchor;I)V
    //   85: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ResolutionAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */