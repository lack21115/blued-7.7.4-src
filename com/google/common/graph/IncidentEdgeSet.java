package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
  protected final N b;
  
  protected final BaseGraph<N> c;
  
  IncidentEdgeSet(BaseGraph<N> paramBaseGraph, N paramN) {
    this.c = paramBaseGraph;
    this.b = paramN;
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    null = paramObject instanceof EndpointPair;
    boolean bool2 = false;
    boolean bool1 = false;
    if (!null)
      return false; 
    paramObject = paramObject;
    if (this.c.d()) {
      if (!paramObject.e())
        return false; 
      Object object = paramObject.a();
      paramObject = paramObject.b();
      if (!this.b.equals(object) || !this.c.g(this.b).contains(paramObject)) {
        null = bool1;
        if (this.b.equals(paramObject)) {
          null = bool1;
          if (this.c.f(this.b).contains(object))
            return true; 
        } 
        return null;
      } 
    } else {
      if (paramObject.e())
        return false; 
      Set<N> set = this.c.e(this.b);
      Object object = paramObject.c();
      paramObject = paramObject.d();
      if (!this.b.equals(paramObject) || !set.contains(object)) {
        null = bool2;
        if (this.b.equals(object)) {
          null = bool2;
          if (set.contains(paramObject))
            null = true; 
        } 
        return null;
      } 
      null = true;
    } 
    return true;
  }
  
  public boolean remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\IncidentEdgeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */