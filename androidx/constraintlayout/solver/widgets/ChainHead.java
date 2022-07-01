package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class ChainHead {
  protected ConstraintWidget a;
  
  protected ConstraintWidget b;
  
  protected ConstraintWidget c;
  
  protected ConstraintWidget d;
  
  protected ConstraintWidget e;
  
  protected ConstraintWidget f;
  
  protected ConstraintWidget g;
  
  protected ArrayList<ConstraintWidget> h;
  
  protected int i;
  
  protected int j;
  
  protected float k = 0.0F;
  
  protected boolean l;
  
  protected boolean m;
  
  protected boolean n;
  
  private int o;
  
  private boolean p = false;
  
  private boolean q;
  
  public ChainHead(ConstraintWidget paramConstraintWidget, int paramInt, boolean paramBoolean) {
    this.a = paramConstraintWidget;
    this.o = paramInt;
    this.p = paramBoolean;
  }
  
  private void a() {
    int i = this.o * 2;
    ConstraintWidget constraintWidget1 = this.a;
    boolean bool3 = false;
    ConstraintWidget constraintWidget2 = constraintWidget1;
    boolean bool1 = false;
    while (!bool1) {
      this.i++;
      ConstraintWidget[] arrayOfConstraintWidget = constraintWidget1.ac;
      int j = this.o;
      ConstraintWidget constraintWidget = null;
      arrayOfConstraintWidget[j] = null;
      constraintWidget1.ab[this.o] = null;
      if (constraintWidget1.getVisibility() != 8) {
        if (this.b == null)
          this.b = constraintWidget1; 
        this.d = constraintWidget1;
        if (constraintWidget1.A[this.o] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget1.e[this.o] == 0 || constraintWidget1.e[this.o] == 3 || constraintWidget1.e[this.o] == 2)) {
          this.j++;
          float f = constraintWidget1.aa[this.o];
          if (f > 0.0F)
            this.k += constraintWidget1.aa[this.o]; 
          if (a(constraintWidget1, this.o)) {
            if (f < 0.0F) {
              this.l = true;
            } else {
              this.m = true;
            } 
            if (this.h == null)
              this.h = new ArrayList<ConstraintWidget>(); 
            this.h.add(constraintWidget1);
          } 
          if (this.f == null)
            this.f = constraintWidget1; 
          ConstraintWidget constraintWidget3 = this.g;
          if (constraintWidget3 != null)
            constraintWidget3.ab[this.o] = constraintWidget1; 
          this.g = constraintWidget1;
        } 
      } 
      if (constraintWidget2 != constraintWidget1)
        constraintWidget2.ac[this.o] = constraintWidget1; 
      ConstraintAnchor constraintAnchor = (constraintWidget1.y[i + 1]).c;
      constraintWidget2 = constraintWidget;
      if (constraintAnchor != null) {
        ConstraintWidget constraintWidget3 = constraintAnchor.a;
        constraintWidget2 = constraintWidget;
        if ((constraintWidget3.y[i]).c != null)
          if ((constraintWidget3.y[i]).c.a != constraintWidget1) {
            constraintWidget2 = constraintWidget;
          } else {
            constraintWidget2 = constraintWidget3;
          }  
      } 
      if (constraintWidget2 == null) {
        constraintWidget2 = constraintWidget1;
        bool1 = true;
      } 
      constraintWidget = constraintWidget1;
      constraintWidget1 = constraintWidget2;
      constraintWidget2 = constraintWidget;
    } 
    this.c = constraintWidget1;
    if (this.o == 0 && this.p) {
      this.e = this.c;
    } else {
      this.e = this.a;
    } 
    boolean bool2 = bool3;
    if (this.m) {
      bool2 = bool3;
      if (this.l)
        bool2 = true; 
    } 
    this.n = bool2;
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget, int paramInt) {
    return (paramConstraintWidget.getVisibility() != 8 && paramConstraintWidget.A[paramInt] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (paramConstraintWidget.e[paramInt] == 0 || paramConstraintWidget.e[paramInt] == 3));
  }
  
  public void define() {
    if (!this.q)
      a(); 
    this.q = true;
  }
  
  public ConstraintWidget getFirst() {
    return this.a;
  }
  
  public ConstraintWidget getFirstMatchConstraintWidget() {
    return this.f;
  }
  
  public ConstraintWidget getFirstVisibleWidget() {
    return this.b;
  }
  
  public ConstraintWidget getHead() {
    return this.e;
  }
  
  public ConstraintWidget getLast() {
    return this.c;
  }
  
  public ConstraintWidget getLastMatchConstraintWidget() {
    return this.g;
  }
  
  public ConstraintWidget getLastVisibleWidget() {
    return this.d;
  }
  
  public float getTotalWeight() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ChainHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */