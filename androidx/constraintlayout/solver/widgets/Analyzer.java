package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
  private static int a(ConstraintWidget paramConstraintWidget) {
    if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      float f;
      if (paramConstraintWidget.F == 0) {
        f = paramConstraintWidget.getHeight() * paramConstraintWidget.E;
      } else {
        f = paramConstraintWidget.getHeight() / paramConstraintWidget.E;
      } 
      int i = (int)f;
      paramConstraintWidget.setWidth(i);
      return i;
    } 
    if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      float f;
      if (paramConstraintWidget.F == 1) {
        f = paramConstraintWidget.getWidth() * paramConstraintWidget.E;
      } else {
        f = paramConstraintWidget.getWidth() / paramConstraintWidget.E;
      } 
      int i = (int)f;
      paramConstraintWidget.setHeight(i);
      return i;
    } 
    return -1;
  }
  
  private static int a(ConstraintWidget paramConstraintWidget, int paramInt) {
    int i = paramInt * 2;
    ConstraintAnchor constraintAnchor1 = paramConstraintWidget.y[i];
    ConstraintAnchor constraintAnchor2 = paramConstraintWidget.y[i + 1];
    if (constraintAnchor1.c != null && constraintAnchor1.c.a == paramConstraintWidget.B && constraintAnchor2.c != null && constraintAnchor2.c.a == paramConstraintWidget.B) {
      float f;
      i = paramConstraintWidget.B.getLength(paramInt);
      if (paramInt == 0) {
        f = paramConstraintWidget.P;
      } else {
        f = paramConstraintWidget.Q;
      } 
      paramInt = paramConstraintWidget.getLength(paramInt);
      return (int)((i - constraintAnchor1.getMargin() - constraintAnchor2.getMargin() - paramInt) * f);
    } 
    return 0;
  }
  
  private static int a(ConstraintWidget paramConstraintWidget, int paramInt1, boolean paramBoolean, int paramInt2) {
    int i;
    int j;
    byte b;
    int i3;
    boolean bool = paramConstraintWidget.T;
    int i2 = 0;
    if (!bool)
      return 0; 
    if (paramConstraintWidget.u.c != null && paramInt1 == 1) {
      k = 1;
    } else {
      k = 0;
    } 
    if (paramBoolean) {
      m = paramConstraintWidget.getBaselineDistance();
      n = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      j = paramInt1 * 2;
      i = j + 1;
    } else {
      m = paramConstraintWidget.getHeight() - paramConstraintWidget.getBaselineDistance();
      n = paramConstraintWidget.getBaselineDistance();
      i = paramInt1 * 2;
      j = i + 1;
    } 
    if ((paramConstraintWidget.y[i]).c != null && (paramConstraintWidget.y[j]).c == null) {
      int i6 = j;
      b = -1;
      j = i;
      i = i6;
    } else {
      b = 1;
    } 
    if (k)
      paramInt2 -= m; 
    int i4 = paramConstraintWidget.y[j].getMargin() * b + a(paramConstraintWidget, paramInt1);
    int i1 = paramInt2 + i4;
    if (paramInt1 == 0) {
      paramInt2 = paramConstraintWidget.getWidth();
    } else {
      paramInt2 = paramConstraintWidget.getHeight();
    } 
    int i5 = paramInt2 * b;
    Iterator<ResolutionNode> iterator = (paramConstraintWidget.y[j].getResolutionNode()).h.iterator();
    for (paramInt2 = i2; iterator.hasNext(); paramInt2 = Math.max(paramInt2, a(((ResolutionAnchor)iterator.next()).a.a, paramInt1, paramBoolean, i1)));
    iterator = (paramConstraintWidget.y[i].getResolutionNode()).h.iterator();
    for (i2 = 0; iterator.hasNext(); i2 = Math.max(i2, a(((ResolutionAnchor)iterator.next()).a.a, paramInt1, paramBoolean, i5 + i1)));
    if (k) {
      paramInt2 -= m;
      i3 = i2 + n;
      i2 = paramInt2;
    } else {
      if (paramInt1 == 0) {
        i3 = paramConstraintWidget.getWidth();
      } else {
        i3 = paramConstraintWidget.getHeight();
      } 
      i3 = i2 + i3 * b;
      i2 = paramInt2;
    } 
    if (paramInt1 == 1) {
      iterator = (paramConstraintWidget.u.getResolutionNode()).h.iterator();
      for (paramInt2 = 0; iterator.hasNext(); paramInt2 = Math.max(paramInt2, a(resolutionAnchor.a.a, paramInt1, paramBoolean, n * b + i1))) {
        ResolutionAnchor resolutionAnchor = (ResolutionAnchor)iterator.next();
        if (b == 1) {
          paramInt2 = Math.max(paramInt2, a(resolutionAnchor.a.a, paramInt1, paramBoolean, m + i1));
          continue;
        } 
      } 
      if ((paramConstraintWidget.u.getResolutionNode()).h.size() > 0 && !k)
        if (b == 1) {
          paramInt2 += m;
        } else {
          paramInt2 -= n;
        }  
    } else {
      paramInt2 = 0;
    } 
    int n = Math.max(i2, Math.max(i3, paramInt2));
    int k = i1 + i5;
    int m = k;
    paramInt2 = i1;
    if (b == -1) {
      paramInt2 = k;
      m = i1;
    } 
    if (paramBoolean) {
      Optimizer.a(paramConstraintWidget, paramInt1, paramInt2);
      paramConstraintWidget.setFrame(paramInt2, m, paramInt1);
    } else {
      paramConstraintWidget.p.a(paramConstraintWidget, paramInt1);
      paramConstraintWidget.a(paramInt2, paramInt1);
    } 
    if (paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && paramConstraintWidget.E != 0.0F)
      paramConstraintWidget.p.a(paramConstraintWidget, paramInt1); 
    if ((paramConstraintWidget.y[j]).c != null && (paramConstraintWidget.y[i]).c != null) {
      ConstraintWidget constraintWidget = paramConstraintWidget.getParent();
      if ((paramConstraintWidget.y[j]).c.a == constraintWidget && (paramConstraintWidget.y[i]).c.a == constraintWidget)
        paramConstraintWidget.p.a(paramConstraintWidget, paramInt1); 
    } 
    return i4 + n;
  }
  
  private static int a(ConstraintWidgetGroup paramConstraintWidgetGroup, int paramInt) {
    int k = paramInt * 2;
    List<ConstraintWidget> list = paramConstraintWidgetGroup.getStartWidgets(paramInt);
    int m = list.size();
    int i = 0;
    int j = 0;
    while (i < m) {
      boolean bool;
      ConstraintWidget constraintWidget = list.get(i);
      ConstraintAnchor[] arrayOfConstraintAnchor = constraintWidget.y;
      int n = k + 1;
      if ((arrayOfConstraintAnchor[n]).c == null || ((constraintWidget.y[k]).c != null && (constraintWidget.y[n]).c != null)) {
        bool = true;
      } else {
        bool = false;
      } 
      j = Math.max(j, a(constraintWidget, paramInt, bool, 0));
      i++;
    } 
    paramConstraintWidgetGroup.mGroupDimensions[paramInt] = j;
    return j;
  }
  
  private static void a(ConstraintAnchor paramConstraintAnchor) {
    ResolutionAnchor resolutionAnchor = paramConstraintAnchor.getResolutionNode();
    if (paramConstraintAnchor.c != null && paramConstraintAnchor.c.c != paramConstraintAnchor)
      paramConstraintAnchor.c.getResolutionNode().addDependent(resolutionAnchor); 
  }
  
  private static void a(ConstraintWidget paramConstraintWidget, int paramInt1, int paramInt2) {
    int j = paramInt1 * 2;
    ConstraintAnchor constraintAnchor1 = paramConstraintWidget.y[j];
    ConstraintAnchor constraintAnchor2 = paramConstraintWidget.y[j + 1];
    if (constraintAnchor1.c != null && constraintAnchor2.c != null) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      Optimizer.a(paramConstraintWidget, paramInt1, a(paramConstraintWidget, paramInt1) + constraintAnchor1.getMargin());
      return;
    } 
    if (paramConstraintWidget.E != 0.0F && paramConstraintWidget.getDimensionBehaviour(paramInt1) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      paramInt2 = a(paramConstraintWidget);
      i = (int)(paramConstraintWidget.y[j].getResolutionNode()).f;
      (constraintAnchor2.getResolutionNode()).e = constraintAnchor1.getResolutionNode();
      (constraintAnchor2.getResolutionNode()).f = paramInt2;
      (constraintAnchor2.getResolutionNode()).i = 1;
      paramConstraintWidget.setFrame(i, i + paramInt2, paramInt1);
      return;
    } 
    paramInt2 -= paramConstraintWidget.a(paramInt1);
    int i = paramInt2 - paramConstraintWidget.getLength(paramInt1);
    paramConstraintWidget.setFrame(i, paramInt2, paramInt1);
    Optimizer.a(paramConstraintWidget, paramInt1, i);
  }
  
  private static void a(ConstraintWidgetContainer paramConstraintWidgetContainer) {
    paramConstraintWidgetContainer.mWidgetGroups.clear();
    paramConstraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(paramConstraintWidgetContainer.ap));
  }
  
  private static void a(ConstraintWidgetContainer paramConstraintWidgetContainer, ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup) {
    paramConstraintWidgetGroup.mSkipSolver = false;
    paramConstraintWidgetContainer.mSkipSolver = false;
    paramConstraintWidget.T = false;
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget, ConstraintWidgetGroup paramConstraintWidgetGroup, List<ConstraintWidgetGroup> paramList, boolean paramBoolean) {
    if (paramConstraintWidget == null)
      return true; 
    paramConstraintWidget.U = false;
    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)paramConstraintWidget.getParent();
    if (paramConstraintWidget.p == null) {
      paramConstraintWidget.T = true;
      paramConstraintWidgetGroup.mConstrainedGroup.add(paramConstraintWidget);
      paramConstraintWidget.p = paramConstraintWidgetGroup;
      if (paramConstraintWidget.q.c == null && paramConstraintWidget.s.c == null && paramConstraintWidget.r.c == null && paramConstraintWidget.t.c == null && paramConstraintWidget.u.c == null && paramConstraintWidget.x.c == null) {
        a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean)
          return false; 
      } 
      if (paramConstraintWidget.r.c != null && paramConstraintWidget.t.c != null) {
        constraintWidgetContainer.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean) {
          a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        } 
        if (paramConstraintWidget.r.c.a != paramConstraintWidget.getParent() || paramConstraintWidget.t.c.a != paramConstraintWidget.getParent())
          a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup); 
      } 
      if (paramConstraintWidget.q.c != null && paramConstraintWidget.s.c != null) {
        constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (paramBoolean) {
          a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
          return false;
        } 
        if (paramConstraintWidget.q.c.a != paramConstraintWidget.getParent() || paramConstraintWidget.s.c.a != paramConstraintWidget.getParent())
          a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup); 
      } 
      if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        i = 1;
      } else {
        i = 0;
      } 
      if (paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        j = 1;
      } else {
        j = 0;
      } 
      if ((i ^ j) != 0 && paramConstraintWidget.E != 0.0F) {
        a(paramConstraintWidget);
      } else if (paramConstraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || paramConstraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean)
          return false; 
      } 
      if (((paramConstraintWidget.q.c == null && paramConstraintWidget.s.c == null) || (paramConstraintWidget.q.c != null && paramConstraintWidget.q.c.a == paramConstraintWidget.B && paramConstraintWidget.s.c == null) || (paramConstraintWidget.s.c != null && paramConstraintWidget.s.c.a == paramConstraintWidget.B && paramConstraintWidget.q.c == null) || (paramConstraintWidget.q.c != null && paramConstraintWidget.q.c.a == paramConstraintWidget.B && paramConstraintWidget.s.c != null && paramConstraintWidget.s.c.a == paramConstraintWidget.B)) && paramConstraintWidget.x.c == null && !(paramConstraintWidget instanceof Guideline) && !(paramConstraintWidget instanceof Helper))
        paramConstraintWidgetGroup.c.add(paramConstraintWidget); 
      if (((paramConstraintWidget.r.c == null && paramConstraintWidget.t.c == null) || (paramConstraintWidget.r.c != null && paramConstraintWidget.r.c.a == paramConstraintWidget.B && paramConstraintWidget.t.c == null) || (paramConstraintWidget.t.c != null && paramConstraintWidget.t.c.a == paramConstraintWidget.B && paramConstraintWidget.r.c == null) || (paramConstraintWidget.r.c != null && paramConstraintWidget.r.c.a == paramConstraintWidget.B && paramConstraintWidget.t.c != null && paramConstraintWidget.t.c.a == paramConstraintWidget.B)) && paramConstraintWidget.x.c == null && paramConstraintWidget.u.c == null && !(paramConstraintWidget instanceof Guideline) && !(paramConstraintWidget instanceof Helper))
        paramConstraintWidgetGroup.d.add(paramConstraintWidget); 
      if (paramConstraintWidget instanceof Helper) {
        a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
        if (paramBoolean)
          return false; 
        Helper helper = (Helper)paramConstraintWidget;
        for (i = 0; i < helper.ag; i++) {
          if (!a(helper.af[i], paramConstraintWidgetGroup, paramList, paramBoolean))
            return false; 
        } 
      } 
      int j = paramConstraintWidget.y.length;
      int i;
      for (i = 0; i < j; i++) {
        ConstraintAnchor constraintAnchor = paramConstraintWidget.y[i];
        if (constraintAnchor.c != null && constraintAnchor.c.a != paramConstraintWidget.getParent()) {
          if (constraintAnchor.b == ConstraintAnchor.Type.CENTER) {
            a(constraintWidgetContainer, paramConstraintWidget, paramConstraintWidgetGroup);
            if (paramBoolean)
              return false; 
          } else {
            a(constraintAnchor);
          } 
          if (!a(constraintAnchor.c.a, paramConstraintWidgetGroup, paramList, paramBoolean))
            return false; 
        } 
      } 
      return true;
    } 
    if (paramConstraintWidget.p != paramConstraintWidgetGroup) {
      paramConstraintWidgetGroup.mConstrainedGroup.addAll(paramConstraintWidget.p.mConstrainedGroup);
      paramConstraintWidgetGroup.c.addAll(paramConstraintWidget.p.c);
      paramConstraintWidgetGroup.d.addAll(paramConstraintWidget.p.d);
      if (!paramConstraintWidget.p.mSkipSolver)
        paramConstraintWidgetGroup.mSkipSolver = false; 
      paramList.remove(paramConstraintWidget.p);
      Iterator<ConstraintWidget> iterator = paramConstraintWidget.p.mConstrainedGroup.iterator();
      while (iterator.hasNext())
        ((ConstraintWidget)iterator.next()).p = paramConstraintWidgetGroup; 
    } 
    return true;
  }
  
  private static boolean a(ConstraintWidget paramConstraintWidget, List<ConstraintWidgetGroup> paramList, boolean paramBoolean) {
    ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList<ConstraintWidget>(), true);
    paramList.add(constraintWidgetGroup);
    return a(paramConstraintWidget, constraintWidgetGroup, paramList, paramBoolean);
  }
  
  public static void determineGroups(ConstraintWidgetContainer paramConstraintWidgetContainer) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if ((paramConstraintWidgetContainer.getOptimizationLevel() & 0x20) != 32) {
      a(paramConstraintWidgetContainer);
      return;
    } 
    paramConstraintWidgetContainer.mSkipSolver = true;
    paramConstraintWidgetContainer.mGroupsWrapOptimized = false;
    paramConstraintWidgetContainer.mHorizontalWrapOptimized = false;
    paramConstraintWidgetContainer.mVerticalWrapOptimized = false;
    ArrayList<ConstraintWidget> arrayList = paramConstraintWidgetContainer.ap;
    List<ConstraintWidgetGroup> list = paramConstraintWidgetContainer.mWidgetGroups;
    if (paramConstraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramConstraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 || bool2) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    list.clear();
    for (ConstraintWidget constraintWidget : arrayList) {
      constraintWidget.p = null;
      constraintWidget.V = false;
      constraintWidget.resetResolutionNodes();
    } 
    for (ConstraintWidget constraintWidget : arrayList) {
      if (constraintWidget.p == null && !a(constraintWidget, list, bool3)) {
        a(paramConstraintWidgetContainer);
        paramConstraintWidgetContainer.mSkipSolver = false;
        return;
      } 
    } 
    Iterator<ConstraintWidgetGroup> iterator = list.iterator();
    int j = 0;
    int i;
    for (i = 0; iterator.hasNext(); i = Math.max(i, a(constraintWidgetGroup, 1))) {
      ConstraintWidgetGroup constraintWidgetGroup = iterator.next();
      j = Math.max(j, a(constraintWidgetGroup, 0));
    } 
    if (bool1) {
      paramConstraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setWidth(j);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mHorizontalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedWidth = j;
    } 
    if (bool2) {
      paramConstraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
      paramConstraintWidgetContainer.setHeight(i);
      paramConstraintWidgetContainer.mGroupsWrapOptimized = true;
      paramConstraintWidgetContainer.mVerticalWrapOptimized = true;
      paramConstraintWidgetContainer.mWrapFixedHeight = i;
    } 
    setPosition(list, 0, paramConstraintWidgetContainer.getWidth());
    setPosition(list, 1, paramConstraintWidgetContainer.getHeight());
  }
  
  public static void setPosition(List<ConstraintWidgetGroup> paramList, int paramInt1, int paramInt2) {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      for (ConstraintWidget constraintWidget : ((ConstraintWidgetGroup)paramList.get(i)).a(paramInt1)) {
        if (constraintWidget.T)
          a(constraintWidget, paramInt1, paramInt2); 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Analyzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */