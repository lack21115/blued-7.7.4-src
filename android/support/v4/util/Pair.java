package android.support.v4.util;

public final class Pair {
  private Object first;
  
  public final Object second;
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Pair))
      return false; 
    paramObject = paramObject;
    return (objectsEqual(((Pair)paramObject).first, this.first) && objectsEqual(((Pair)paramObject).second, this.second));
  }
  
  public final int hashCode() {
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
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("Pair{");
    stringBuilder.append(String.valueOf(this.first));
    stringBuilder.append(" ");
    stringBuilder.append(String.valueOf(this.second));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */