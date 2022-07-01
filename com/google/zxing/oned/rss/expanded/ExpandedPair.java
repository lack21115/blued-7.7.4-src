package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class ExpandedPair {
  private final boolean a;
  
  private final DataCharacter b;
  
  private final DataCharacter c;
  
  private final FinderPattern d;
  
  ExpandedPair(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean) {
    this.b = paramDataCharacter1;
    this.c = paramDataCharacter2;
    this.d = paramFinderPattern;
    this.a = paramBoolean;
  }
  
  private static int a(Object paramObject) {
    return (paramObject == null) ? 0 : paramObject.hashCode();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  DataCharacter a() {
    return this.b;
  }
  
  DataCharacter b() {
    return this.c;
  }
  
  FinderPattern c() {
    return this.d;
  }
  
  public boolean d() {
    return (this.c == null);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof ExpandedPair))
      return false; 
    paramObject = paramObject;
    return (a(this.b, ((ExpandedPair)paramObject).b) && a(this.c, ((ExpandedPair)paramObject).c) && a(this.d, ((ExpandedPair)paramObject).d));
  }
  
  public int hashCode() {
    return a(this.b) ^ a(this.c) ^ a(this.d);
  }
  
  public String toString() {
    String str;
    Integer integer;
    StringBuilder stringBuilder = new StringBuilder("[ ");
    stringBuilder.append(this.b);
    stringBuilder.append(" , ");
    stringBuilder.append(this.c);
    stringBuilder.append(" : ");
    FinderPattern finderPattern = this.d;
    if (finderPattern == null) {
      str = "null";
    } else {
      integer = Integer.valueOf(str.a());
    } 
    stringBuilder.append(integer);
    stringBuilder.append(" ]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\ExpandedPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */