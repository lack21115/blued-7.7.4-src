package org.chromium.mojo.system;

public class Pair {
  public final Object first;
  
  public final Object second;
  
  public Pair(Object paramObject1, Object paramObject2) {
    this.first = paramObject1;
    this.second = paramObject2;
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  public boolean equals(Object paramObject) {
    if (!(paramObject instanceof Pair))
      return false; 
    paramObject = paramObject;
    return (equals(this.first, ((Pair)paramObject).first) && equals(this.second, ((Pair)paramObject).second));
  }
  
  public int hashCode() {
    int i;
    Object object = this.first;
    int j = 0;
    if (object == null) {
      i = 0;
    } else {
      i = this.first.hashCode();
    } 
    if (this.second != null)
      j = this.second.hashCode(); 
    return i ^ j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */