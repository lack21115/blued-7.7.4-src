package com.mcxiaoke.packer.support.walle;

final class Pair<A, B> {
  private final A a;
  
  private final B b;
  
  private Pair(A paramA, B paramB) {
    this.a = paramA;
    this.b = paramB;
  }
  
  public static <A, B> Pair<A, B> a(A paramA, B paramB) {
    return new Pair<A, B>(paramA, paramB);
  }
  
  public A a() {
    return this.a;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      A a = this.a;
      if (a != null) {
        if (!a.equals(((Pair)paramObject).a))
          return false; 
      } else if (((Pair)paramObject).a != null) {
        return false;
      } 
      B b = this.b;
      paramObject = ((Pair)paramObject).b;
      return (b != null) ? b.equals(paramObject) : ((paramObject == null));
    } 
    return false;
  }
  
  public int hashCode() {
    byte b;
    A a = this.a;
    int i = 0;
    if (a != null) {
      b = a.hashCode();
    } else {
      b = 0;
    } 
    B b1 = this.b;
    if (b1 != null)
      i = b1.hashCode(); 
    return b * 31 + i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\mcxiaoke\packer\support\walle\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */