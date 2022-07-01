package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public final class ObjectArrays {
  static Object a(Object paramObject, int paramInt) {
    if (paramObject != null)
      return paramObject; 
    paramObject = new StringBuilder();
    paramObject.append("at index ");
    paramObject.append(paramInt);
    throw new NullPointerException(paramObject.toString());
  }
  
  public static <T> T[] a(Class<T> paramClass, int paramInt) {
    return (T[])Array.newInstance(paramClass, paramInt);
  }
  
  private static Object[] a(Iterable<?> paramIterable, Object[] paramArrayOfObject) {
    Iterator<?> iterator = paramIterable.iterator();
    for (int i = 0; iterator.hasNext(); i++)
      paramArrayOfObject[i] = iterator.next(); 
    return paramArrayOfObject;
  }
  
  static Object[] a(Collection<?> paramCollection) {
    return a(paramCollection, new Object[paramCollection.size()]);
  }
  
  static <T> T[] a(Collection<?> paramCollection, T[] paramArrayOfT) {
    int i = paramCollection.size();
    T[] arrayOfT = paramArrayOfT;
    if (paramArrayOfT.length < i)
      arrayOfT = a(paramArrayOfT, i); 
    a(paramCollection, (Object[])arrayOfT);
    if (arrayOfT.length > i)
      arrayOfT[i] = null; 
    return arrayOfT;
  }
  
  static Object[] a(Object... paramVarArgs) {
    return b(paramVarArgs, paramVarArgs.length);
  }
  
  public static <T> T[] a(T[] paramArrayOfT, int paramInt) {
    return Platform.a(paramArrayOfT, paramInt);
  }
  
  static <T> T[] a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT) {
    T[] arrayOfT;
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    if (paramArrayOfT.length < paramInt2) {
      Object[] arrayOfObject = a((Object[])paramArrayOfT, paramInt2);
    } else {
      arrayOfT = paramArrayOfT;
      if (paramArrayOfT.length > paramInt2) {
        paramArrayOfT[paramInt2] = null;
        arrayOfT = paramArrayOfT;
      } 
    } 
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfT, 0, paramInt2);
    return arrayOfT;
  }
  
  public static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass) {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: arraylength
    //   3: aload_1
    //   4: arraylength
    //   5: iadd
    //   6: invokestatic a : (Ljava/lang/Class;I)[Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_0
    //   11: iconst_0
    //   12: aload_2
    //   13: iconst_0
    //   14: aload_0
    //   15: arraylength
    //   16: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   19: aload_1
    //   20: iconst_0
    //   21: aload_2
    //   22: aload_0
    //   23: arraylength
    //   24: aload_1
    //   25: arraylength
    //   26: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   29: aload_2
    //   30: areturn
  }
  
  static Object[] b(Object[] paramArrayOfObject, int paramInt) {
    for (int i = 0; i < paramInt; i++)
      a(paramArrayOfObject[i], i); 
    return paramArrayOfObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ObjectArrays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */