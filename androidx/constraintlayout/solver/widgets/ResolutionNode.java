package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode {
  public static final int REMOVED = 2;
  
  public static final int RESOLVED = 1;
  
  public static final int UNRESOLVED = 0;
  
  HashSet<ResolutionNode> h = new HashSet<ResolutionNode>(2);
  
  int i = 0;
  
  public void addDependent(ResolutionNode paramResolutionNode) {
    this.h.add(paramResolutionNode);
  }
  
  public void didResolve() {
    this.i = 1;
    Iterator<ResolutionNode> iterator = this.h.iterator();
    while (iterator.hasNext())
      ((ResolutionNode)iterator.next()).resolve(); 
  }
  
  public void invalidate() {
    this.i = 0;
    Iterator<ResolutionNode> iterator = this.h.iterator();
    while (iterator.hasNext())
      ((ResolutionNode)iterator.next()).invalidate(); 
  }
  
  public void invalidateAnchors() {
    if (this instanceof ResolutionAnchor)
      this.i = 0; 
    Iterator<ResolutionNode> iterator = this.h.iterator();
    while (iterator.hasNext())
      ((ResolutionNode)iterator.next()).invalidateAnchors(); 
  }
  
  public boolean isResolved() {
    return (this.i == 1);
  }
  
  public void remove(ResolutionDimension paramResolutionDimension) {}
  
  public void reset() {
    this.i = 0;
    this.h.clear();
  }
  
  public void resolve() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\ResolutionNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */