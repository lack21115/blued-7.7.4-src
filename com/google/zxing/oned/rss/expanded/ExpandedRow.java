package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

final class ExpandedRow {
  private final List<ExpandedPair> a;
  
  private final int b;
  
  private final boolean c;
  
  ExpandedRow(List<ExpandedPair> paramList, int paramInt, boolean paramBoolean) {
    this.a = new ArrayList<ExpandedPair>(paramList);
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  List<ExpandedPair> a() {
    return this.a;
  }
  
  boolean a(List<ExpandedPair> paramList) {
    return this.a.equals(paramList);
  }
  
  int b() {
    return this.b;
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ExpandedRow))
      return false; 
    paramObject = paramObject;
    return (this.a.equals(paramObject.a()) && this.c == ((ExpandedRow)paramObject).c);
  }
  
  public int hashCode() {
    return this.a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("{ ");
    stringBuilder.append(this.a);
    stringBuilder.append(" }");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\ExpandedRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */