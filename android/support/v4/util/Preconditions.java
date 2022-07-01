package android.support.v4.util;

public final class Preconditions {
  public static Object checkNotNull(Object paramObject) {
    if (paramObject != null)
      return paramObject; 
    throw new NullPointerException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */