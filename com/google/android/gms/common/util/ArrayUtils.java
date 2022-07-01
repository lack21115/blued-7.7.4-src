package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class ArrayUtils {
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT) {
    if (paramArrayOfT != null || paramT != null) {
      if (paramArrayOfT == null) {
        paramArrayOfT = (T[])Array.newInstance(paramT.getClass(), 1);
      } else {
        paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length + 1);
      } 
      paramArrayOfT[paramArrayOfT.length - 1] = paramT;
      return paramArrayOfT;
    } 
    throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
  }
  
  public static <T> T[] concat(T[]... paramVarArgs) {
    if (paramVarArgs.length == 0)
      return (T[])Array.newInstance(paramVarArgs.getClass(), 0); 
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length) {
      j += (paramVarArgs[i]).length;
      i++;
    } 
    Object[] arrayOfObject = Arrays.copyOf((Object[])paramVarArgs[0], j);
    j = (paramVarArgs[0]).length;
    for (i = 1; i < paramVarArgs.length; i++) {
      T[] arrayOfT = paramVarArgs[i];
      System.arraycopy(arrayOfT, 0, arrayOfObject, j, arrayOfT.length);
      j += arrayOfT.length;
    } 
    return (T[])arrayOfObject;
  }
  
  public static byte[] concatByteArrays(byte[]... paramVarArgs) {
    if (paramVarArgs.length == 0)
      return new byte[0]; 
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length) {
      j += (paramVarArgs[i]).length;
      i++;
    } 
    byte[] arrayOfByte = Arrays.copyOf(paramVarArgs[0], j);
    j = (paramVarArgs[0]).length;
    for (i = 1; i < paramVarArgs.length; i++) {
      byte[] arrayOfByte1 = paramVarArgs[i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, arrayOfByte1.length);
      j += arrayOfByte1.length;
    } 
    return arrayOfByte;
  }
  
  public static boolean contains(int[] paramArrayOfint, int paramInt) {
    if (paramArrayOfint == null)
      return false; 
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfint[i] == paramInt)
        return true; 
    } 
    return false;
  }
  
  public static <T> boolean contains(T[] paramArrayOfT, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 10
    //   4: aload_0
    //   5: arraylength
    //   6: istore_3
    //   7: goto -> 12
    //   10: iconst_0
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge -> 39
    //   19: aload_0
    //   20: iload_2
    //   21: aaload
    //   22: aload_1
    //   23: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   26: ifeq -> 32
    //   29: goto -> 41
    //   32: iload_2
    //   33: iconst_1
    //   34: iadd
    //   35: istore_2
    //   36: goto -> 14
    //   39: iconst_m1
    //   40: istore_2
    //   41: iload_2
    //   42: iflt -> 47
    //   45: iconst_1
    //   46: ireturn
    //   47: iconst_0
    //   48: ireturn
  }
  
  public static <T> ArrayList<T> newArrayList() {
    return new ArrayList<T>();
  }
  
  public static <T> T[] removeAll(T[] paramArrayOfT1, T... paramVarArgs1) {
    int j;
    if (paramArrayOfT1 == null)
      return null; 
    if (paramVarArgs1 == null || paramVarArgs1.length == 0)
      return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length); 
    Object[] arrayOfObject = (Object[])Array.newInstance(paramVarArgs1.getClass().getComponentType(), paramArrayOfT1.length);
    int i = paramVarArgs1.length;
    int k = 0;
    if (i == 1) {
      int m = paramArrayOfT1.length;
      k = 0;
      i = 0;
      while (true) {
        j = i;
        if (k < m) {
          T t = paramArrayOfT1[k];
          j = i;
          if (!Objects.equal(paramVarArgs1[0], t)) {
            arrayOfObject[i] = t;
            j = i + 1;
          } 
          k++;
          i = j;
          continue;
        } 
        break;
      } 
    } else {
      int m = paramArrayOfT1.length;
      i = 0;
      while (true) {
        j = i;
        if (k < m) {
          T t = paramArrayOfT1[k];
          j = i;
          if (!contains(paramVarArgs1, t)) {
            arrayOfObject[i] = t;
            j = i + 1;
          } 
          k++;
          i = j;
          continue;
        } 
        break;
      } 
    } 
    if (arrayOfObject == null)
      return null; 
    paramArrayOfT1 = (T[])arrayOfObject;
    if (j != arrayOfObject.length)
      paramArrayOfT1 = Arrays.copyOf((T[])arrayOfObject, j); 
    return paramArrayOfT1;
  }
  
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT) {
    int j = paramArrayOfT.length;
    ArrayList<T> arrayList = new ArrayList(j);
    for (int i = 0; i < j; i++)
      arrayList.add(paramArrayOfT[i]); 
    return arrayList;
  }
  
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection) {
    int i = 0;
    if (paramCollection == null || paramCollection.size() == 0)
      return new int[0]; 
    int[] arrayOfInt = new int[paramCollection.size()];
    Iterator<Integer> iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      arrayOfInt[i] = ((Integer)iterator.next()).intValue();
      i++;
    } 
    return arrayOfInt;
  }
  
  public static Integer[] toWrapperArray(int[] paramArrayOfint) {
    if (paramArrayOfint == null)
      return null; 
    int j = paramArrayOfint.length;
    Integer[] arrayOfInteger = new Integer[j];
    for (int i = 0; i < j; i++)
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfint[i]); 
    return arrayOfInteger;
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfdouble) {
    int j = paramArrayOfdouble.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Double.toString(paramArrayOfdouble[i]));
    } 
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOffloat) {
    int j = paramArrayOffloat.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Float.toString(paramArrayOffloat[i]));
    } 
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Integer.toString(paramArrayOfint[i]));
    } 
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOflong) {
    int j = paramArrayOflong.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Long.toString(paramArrayOflong[i]));
    } 
  }
  
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT) {
    int j = paramArrayOfT.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(paramArrayOfT[i].toString());
    } 
  }
  
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfboolean) {
    int j = paramArrayOfboolean.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append(Boolean.toString(paramArrayOfboolean[i]));
    } 
  }
  
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString) {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (i != 0)
        paramStringBuilder.append(","); 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(paramArrayOfString[i]);
      paramStringBuilder.append("\"");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */