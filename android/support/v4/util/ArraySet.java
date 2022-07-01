package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet implements Collection, Set {
  private static final int[] INT = new int[0];
  
  private static final Object[] OBJECT = new Object[0];
  
  private static Object[] sBaseCache;
  
  private static int sBaseCacheSize;
  
  private static Object[] sTwiceBaseCache;
  
  private static int sTwiceBaseCacheSize;
  
  public Object[] mArray;
  
  private MapCollections mCollections;
  
  private int[] mHashes;
  
  private boolean mIdentityHashCode;
  
  int mSize;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ArraySet() {
    this(0, false);
  }
  
  private ArraySet(int paramInt, boolean paramBoolean) {
    this.mIdentityHashCode = paramBoolean;
    if (paramInt == 0) {
      this.mHashes = INT;
      this.mArray = OBJECT;
    } else {
      allocArrays(paramInt);
    } 
    this.mSize = 0;
  }
  
  private void allocArrays(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: bipush #8
    //   3: if_icmpne -> 75
    //   6: ldc android/support/v4/util/ArraySet
    //   8: monitorenter
    //   9: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   12: ifnull -> 63
    //   15: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_0
    //   20: aload_2
    //   21: putfield mArray : [Ljava/lang/Object;
    //   24: aload_2
    //   25: iconst_0
    //   26: aaload
    //   27: checkcast [Ljava/lang/Object;
    //   30: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   33: aload_0
    //   34: aload_2
    //   35: iconst_1
    //   36: aaload
    //   37: checkcast [I
    //   40: putfield mHashes : [I
    //   43: aload_2
    //   44: iconst_1
    //   45: aconst_null
    //   46: aastore
    //   47: aload_2
    //   48: iconst_0
    //   49: aconst_null
    //   50: aastore
    //   51: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   54: iconst_1
    //   55: isub
    //   56: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   59: ldc android/support/v4/util/ArraySet
    //   61: monitorexit
    //   62: return
    //   63: ldc android/support/v4/util/ArraySet
    //   65: monitorexit
    //   66: goto -> 149
    //   69: astore_2
    //   70: ldc android/support/v4/util/ArraySet
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: iload_1
    //   76: iconst_4
    //   77: if_icmpne -> 149
    //   80: ldc android/support/v4/util/ArraySet
    //   82: monitorenter
    //   83: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   86: ifnull -> 137
    //   89: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   92: astore_2
    //   93: aload_0
    //   94: aload_2
    //   95: putfield mArray : [Ljava/lang/Object;
    //   98: aload_2
    //   99: iconst_0
    //   100: aaload
    //   101: checkcast [Ljava/lang/Object;
    //   104: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   107: aload_0
    //   108: aload_2
    //   109: iconst_1
    //   110: aaload
    //   111: checkcast [I
    //   114: putfield mHashes : [I
    //   117: aload_2
    //   118: iconst_1
    //   119: aconst_null
    //   120: aastore
    //   121: aload_2
    //   122: iconst_0
    //   123: aconst_null
    //   124: aastore
    //   125: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   128: iconst_1
    //   129: isub
    //   130: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   133: ldc android/support/v4/util/ArraySet
    //   135: monitorexit
    //   136: return
    //   137: ldc android/support/v4/util/ArraySet
    //   139: monitorexit
    //   140: goto -> 149
    //   143: astore_2
    //   144: ldc android/support/v4/util/ArraySet
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: aload_0
    //   150: iload_1
    //   151: newarray int
    //   153: putfield mHashes : [I
    //   156: aload_0
    //   157: iload_1
    //   158: anewarray java/lang/Object
    //   161: putfield mArray : [Ljava/lang/Object;
    //   164: return
    // Exception table:
    //   from	to	target	type
    //   9	43	69	finally
    //   51	62	69	finally
    //   63	66	69	finally
    //   70	73	69	finally
    //   83	117	143	finally
    //   125	136	143	finally
    //   137	140	143	finally
    //   144	147	143	finally
  }
  
  private static void freeArrays(int[] paramArrayOfint, Object[] paramArrayOfObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: bipush #8
    //   4: if_icmpne -> 57
    //   7: ldc android/support/v4/util/ArraySet
    //   9: monitorenter
    //   10: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   13: bipush #10
    //   15: if_icmpge -> 47
    //   18: aload_1
    //   19: iconst_0
    //   20: getstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   23: aastore
    //   24: aload_1
    //   25: iconst_1
    //   26: aload_0
    //   27: aastore
    //   28: iload_2
    //   29: iconst_1
    //   30: isub
    //   31: istore_2
    //   32: goto -> 114
    //   35: aload_1
    //   36: putstatic android/support/v4/util/ArraySet.sTwiceBaseCache : [Ljava/lang/Object;
    //   39: getstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   42: iconst_1
    //   43: iadd
    //   44: putstatic android/support/v4/util/ArraySet.sTwiceBaseCacheSize : I
    //   47: ldc android/support/v4/util/ArraySet
    //   49: monitorexit
    //   50: return
    //   51: astore_0
    //   52: ldc android/support/v4/util/ArraySet
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: aload_0
    //   58: arraylength
    //   59: iconst_4
    //   60: if_icmpne -> 113
    //   63: ldc android/support/v4/util/ArraySet
    //   65: monitorenter
    //   66: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   69: bipush #10
    //   71: if_icmpge -> 103
    //   74: aload_1
    //   75: iconst_0
    //   76: getstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   79: aastore
    //   80: aload_1
    //   81: iconst_1
    //   82: aload_0
    //   83: aastore
    //   84: iload_2
    //   85: iconst_1
    //   86: isub
    //   87: istore_2
    //   88: goto -> 130
    //   91: aload_1
    //   92: putstatic android/support/v4/util/ArraySet.sBaseCache : [Ljava/lang/Object;
    //   95: getstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   98: iconst_1
    //   99: iadd
    //   100: putstatic android/support/v4/util/ArraySet.sBaseCacheSize : I
    //   103: ldc android/support/v4/util/ArraySet
    //   105: monitorexit
    //   106: return
    //   107: astore_0
    //   108: ldc android/support/v4/util/ArraySet
    //   110: monitorexit
    //   111: aload_0
    //   112: athrow
    //   113: return
    //   114: iload_2
    //   115: iconst_2
    //   116: if_icmplt -> 35
    //   119: aload_1
    //   120: iload_2
    //   121: aconst_null
    //   122: aastore
    //   123: iload_2
    //   124: iconst_1
    //   125: isub
    //   126: istore_2
    //   127: goto -> 114
    //   130: iload_2
    //   131: iconst_2
    //   132: if_icmplt -> 91
    //   135: aload_1
    //   136: iload_2
    //   137: aconst_null
    //   138: aastore
    //   139: iload_2
    //   140: iconst_1
    //   141: isub
    //   142: istore_2
    //   143: goto -> 130
    // Exception table:
    //   from	to	target	type
    //   10	24	51	finally
    //   35	47	51	finally
    //   47	50	51	finally
    //   52	55	51	finally
    //   66	80	107	finally
    //   91	103	107	finally
    //   103	106	107	finally
    //   108	111	107	finally
  }
  
  private int indexOf(Object paramObject, int paramInt) {
    int j = this.mSize;
    if (j == 0)
      return -1; 
    int k = ContainerHelpers.binarySearch(this.mHashes, j, paramInt);
    if (k < 0)
      return k; 
    if (paramObject.equals(this.mArray[k]))
      return k; 
    int i;
    for (i = k + 1; i < j && this.mHashes[i] == paramInt; i++) {
      if (paramObject.equals(this.mArray[i]))
        return i; 
    } 
    for (j = k - 1; j >= 0 && this.mHashes[j] == paramInt; j--) {
      if (paramObject.equals(this.mArray[j]))
        return j; 
    } 
    return i ^ 0xFFFFFFFF;
  }
  
  private int indexOfNull() {
    int j = this.mSize;
    if (j == 0)
      return -1; 
    int k = ContainerHelpers.binarySearch(this.mHashes, j, 0);
    if (k < 0)
      return k; 
    if (this.mArray[k] == null)
      return k; 
    int i;
    for (i = k + 1; i < j && this.mHashes[i] == 0; i++) {
      if (this.mArray[i] == null)
        return i; 
    } 
    for (j = k - 1; j >= 0 && this.mHashes[j] == 0; j--) {
      if (this.mArray[j] == null)
        return j; 
    } 
    return i ^ 0xFFFFFFFF;
  }
  
  public final boolean add(Object paramObject) {
    int i;
    int j;
    if (paramObject == null) {
      j = indexOfNull();
      i = 0;
    } else {
      int k;
      if (this.mIdentityHashCode) {
        k = System.identityHashCode(paramObject);
      } else {
        k = paramObject.hashCode();
      } 
      j = indexOf(paramObject, k);
      i = k;
    } 
    if (j >= 0)
      return false; 
    j ^= 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length) {
      int m = this.mSize;
      int k = 4;
      if (m >= 8) {
        k = this.mSize;
        k = (this.mSize >> 1) + k;
      } else if (this.mSize >= 4) {
        k = 8;
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(k);
      if (this.mHashes.length > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
    if (j < this.mSize) {
      int[] arrayOfInt1 = this.mHashes;
      int[] arrayOfInt2 = this.mHashes;
      int k = j + 1;
      System.arraycopy(arrayOfInt1, j, arrayOfInt2, k, this.mSize - j);
      System.arraycopy(this.mArray, j, this.mArray, k, this.mSize - j);
    } 
    this.mHashes[j] = i;
    this.mArray[j] = paramObject;
    this.mSize++;
    return true;
  }
  
  public final boolean addAll(Collection paramCollection) {
    int i = this.mSize + paramCollection.size();
    int j = this.mHashes.length;
    boolean bool = false;
    if (j < i) {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mSize > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize);
      } 
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    } 
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      bool |= add(iterator.next()); 
    return bool;
  }
  
  public final void clear() {
    if (this.mSize != 0) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    } 
  }
  
  public final boolean contains(Object paramObject) {
    return (indexOf(paramObject) >= 0);
  }
  
  public final boolean containsAll(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext()) {
      if (!contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      if (size() != paramObject.size())
        return false; 
      int i = 0;
      try {
        while (i < this.mSize) {
          boolean bool = paramObject.contains(this.mArray[i]);
          if (!bool)
            return false; 
          i++;
        } 
        return true;
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    return false;
  }
  
  public final int hashCode() {
    int[] arrayOfInt = this.mHashes;
    int k = this.mSize;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += arrayOfInt[i];
      i++;
    } 
    return j;
  }
  
  public final int indexOf(Object paramObject) {
    int i;
    if (paramObject == null)
      return indexOfNull(); 
    if (this.mIdentityHashCode) {
      i = System.identityHashCode(paramObject);
    } else {
      i = paramObject.hashCode();
    } 
    return indexOf(paramObject, i);
  }
  
  public final boolean isEmpty() {
    return (this.mSize <= 0);
  }
  
  public final Iterator iterator() {
    if (this.mCollections == null)
      this.mCollections = new ArraySet$1(this); 
    return this.mCollections.getKeySet().iterator();
  }
  
  public final boolean remove(Object paramObject) {
    int i = indexOf(paramObject);
    if (i >= 0) {
      removeAt(i);
      return true;
    } 
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection) {
    Iterator iterator = paramCollection.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool |= remove(iterator.next()));
    return bool;
  }
  
  public final Object removeAt(int paramInt) {
    Object object = this.mArray[paramInt];
    if (this.mSize <= 1) {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
      return object;
    } 
    int j = this.mHashes.length;
    int i = 8;
    if (j > 8 && this.mSize < this.mHashes.length / 3) {
      if (this.mSize > 8) {
        i = this.mSize;
        i = (this.mSize >> 1) + i;
      } 
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize--;
      if (paramInt > 0) {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt);
      } 
      if (paramInt < this.mSize) {
        i = paramInt + 1;
        System.arraycopy(arrayOfInt, i, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, i, this.mArray, paramInt, this.mSize - paramInt);
      } 
      return object;
    } 
    this.mSize--;
    if (paramInt < this.mSize) {
      int[] arrayOfInt = this.mHashes;
      i = paramInt + 1;
      System.arraycopy(arrayOfInt, i, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, i, this.mArray, paramInt, this.mSize - paramInt);
    } 
    this.mArray[this.mSize] = null;
    return object;
  }
  
  public final boolean retainAll(Collection paramCollection) {
    int i = this.mSize - 1;
    boolean bool = false;
    while (i >= 0) {
      if (!paramCollection.contains(this.mArray[i])) {
        removeAt(i);
        bool = true;
      } 
      i--;
    } 
    return bool;
  }
  
  public final int size() {
    return this.mSize;
  }
  
  public final Object[] toArray() {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject) {
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject.length < this.mSize)
      arrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), this.mSize); 
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    if (arrayOfObject.length > this.mSize)
      arrayOfObject[this.mSize] = null; 
    return arrayOfObject;
  }
  
  public final String toString() {
    if (isEmpty())
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
    stringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      Object object = this.mArray[i];
      if (object != this) {
        stringBuilder.append(object);
      } else {
        stringBuilder.append("(this Set)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\ArraySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */