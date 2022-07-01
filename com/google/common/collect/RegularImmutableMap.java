package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
  static final ImmutableMap<Object, Object> a = new RegularImmutableMap(null, new Object[0], 0);
  
  final transient Object[] c;
  
  private final transient Object d;
  
  private final transient int e;
  
  private RegularImmutableMap(Object paramObject, Object[] paramArrayOfObject, int paramInt) {
    this.d = paramObject;
    this.c = paramArrayOfObject;
    this.e = paramInt;
  }
  
  static <K, V> RegularImmutableMap<K, V> a(int paramInt, Object[] paramArrayOfObject) {
    if (paramInt == 0)
      return (RegularImmutableMap)a; 
    if (paramInt == 1) {
      CollectPreconditions.a(paramArrayOfObject[0], paramArrayOfObject[1]);
      return new RegularImmutableMap<K, V>(null, paramArrayOfObject, 1);
    } 
    Preconditions.b(paramInt, paramArrayOfObject.length >> 1);
    return new RegularImmutableMap<K, V>(a(paramArrayOfObject, paramInt, ImmutableSet.c(paramInt), 0), paramArrayOfObject, paramInt);
  }
  
  private static IllegalArgumentException a(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Multiple entries with same key: ");
    stringBuilder.append(paramObject1);
    stringBuilder.append("=");
    stringBuilder.append(paramObject2);
    stringBuilder.append(" and ");
    stringBuilder.append(paramArrayOfObject[paramInt]);
    stringBuilder.append("=");
    stringBuilder.append(paramArrayOfObject[paramInt ^ 0x1]);
    return new IllegalArgumentException(stringBuilder.toString());
  }
  
  static Object a(@NullableDecl Object paramObject1, @NullableDecl Object[] paramArrayOfObject, int paramInt1, int paramInt2, @NullableDecl Object paramObject2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aload #4
    //   5: ifnonnull -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: iload_2
    //   11: iconst_1
    //   12: if_icmpne -> 37
    //   15: aload #6
    //   17: astore_0
    //   18: aload_1
    //   19: iload_3
    //   20: aaload
    //   21: aload #4
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 35
    //   29: aload_1
    //   30: iload_3
    //   31: iconst_1
    //   32: ixor
    //   33: aaload
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: aload_0
    //   38: ifnonnull -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: aload_0
    //   44: instanceof [B
    //   47: ifeq -> 121
    //   50: aload_0
    //   51: checkcast [B
    //   54: checkcast [B
    //   57: astore_0
    //   58: aload_0
    //   59: arraylength
    //   60: istore_3
    //   61: aload #4
    //   63: invokevirtual hashCode : ()I
    //   66: invokestatic a : (I)I
    //   69: istore_2
    //   70: iload_2
    //   71: iload_3
    //   72: iconst_1
    //   73: isub
    //   74: iand
    //   75: istore_2
    //   76: aload_0
    //   77: iload_2
    //   78: baload
    //   79: sipush #255
    //   82: iand
    //   83: istore #5
    //   85: iload #5
    //   87: sipush #255
    //   90: if_icmpne -> 95
    //   93: aconst_null
    //   94: areturn
    //   95: aload_1
    //   96: iload #5
    //   98: aaload
    //   99: aload #4
    //   101: invokevirtual equals : (Ljava/lang/Object;)Z
    //   104: ifeq -> 114
    //   107: aload_1
    //   108: iload #5
    //   110: iconst_1
    //   111: ixor
    //   112: aaload
    //   113: areturn
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_2
    //   118: goto -> 70
    //   121: aload_0
    //   122: instanceof [S
    //   125: ifeq -> 197
    //   128: aload_0
    //   129: checkcast [S
    //   132: checkcast [S
    //   135: astore_0
    //   136: aload_0
    //   137: arraylength
    //   138: istore_3
    //   139: aload #4
    //   141: invokevirtual hashCode : ()I
    //   144: invokestatic a : (I)I
    //   147: istore_2
    //   148: iload_2
    //   149: iload_3
    //   150: iconst_1
    //   151: isub
    //   152: iand
    //   153: istore_2
    //   154: aload_0
    //   155: iload_2
    //   156: saload
    //   157: ldc 65535
    //   159: iand
    //   160: istore #5
    //   162: iload #5
    //   164: ldc 65535
    //   166: if_icmpne -> 171
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: iload #5
    //   174: aaload
    //   175: aload #4
    //   177: invokevirtual equals : (Ljava/lang/Object;)Z
    //   180: ifeq -> 190
    //   183: aload_1
    //   184: iload #5
    //   186: iconst_1
    //   187: ixor
    //   188: aaload
    //   189: areturn
    //   190: iload_2
    //   191: iconst_1
    //   192: iadd
    //   193: istore_2
    //   194: goto -> 148
    //   197: aload_0
    //   198: checkcast [I
    //   201: checkcast [I
    //   204: astore_0
    //   205: aload_0
    //   206: arraylength
    //   207: istore_3
    //   208: aload #4
    //   210: invokevirtual hashCode : ()I
    //   213: invokestatic a : (I)I
    //   216: istore_2
    //   217: iload_2
    //   218: iload_3
    //   219: iconst_1
    //   220: isub
    //   221: iand
    //   222: istore_2
    //   223: aload_0
    //   224: iload_2
    //   225: iaload
    //   226: istore #5
    //   228: iload #5
    //   230: iconst_m1
    //   231: if_icmpne -> 236
    //   234: aconst_null
    //   235: areturn
    //   236: aload_1
    //   237: iload #5
    //   239: aaload
    //   240: aload #4
    //   242: invokevirtual equals : (Ljava/lang/Object;)Z
    //   245: ifeq -> 255
    //   248: aload_1
    //   249: iload #5
    //   251: iconst_1
    //   252: ixor
    //   253: aaload
    //   254: areturn
    //   255: iload_2
    //   256: iconst_1
    //   257: iadd
    //   258: istore_2
    //   259: goto -> 217
  }
  
  static Object a(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 == 1) {
      CollectPreconditions.a(paramArrayOfObject[paramInt3], paramArrayOfObject[paramInt3 ^ 0x1]);
      return null;
    } 
    int m = paramInt2 - 1;
    int j = 0;
    int k = 0;
    int i = 0;
    if (paramInt2 <= 128) {
      byte[] arrayOfByte = new byte[paramInt2];
      Arrays.fill(arrayOfByte, (byte)-1);
      paramInt2 = i;
      label48: while (paramInt2 < paramInt1) {
        j = paramInt2 * 2 + paramInt3;
        Object object1 = paramArrayOfObject[j];
        Object object2 = paramArrayOfObject[j ^ 0x1];
        CollectPreconditions.a(object1, object2);
        i = Hashing.a(object1.hashCode());
        while (true) {
          i &= m;
          k = arrayOfByte[i] & 0xFF;
          if (k == 255) {
            arrayOfByte[i] = (byte)j;
            paramInt2++;
            continue label48;
          } 
          if (!paramArrayOfObject[k].equals(object1)) {
            i++;
            continue;
          } 
          throw a(object1, object2, paramArrayOfObject, k);
        } 
      } 
      return arrayOfByte;
    } 
    if (paramInt2 <= 32768) {
      short[] arrayOfShort = new short[paramInt2];
      Arrays.fill(arrayOfShort, (short)-1);
      paramInt2 = j;
      label49: while (paramInt2 < paramInt1) {
        j = paramInt2 * 2 + paramInt3;
        Object object1 = paramArrayOfObject[j];
        Object object2 = paramArrayOfObject[j ^ 0x1];
        CollectPreconditions.a(object1, object2);
        i = Hashing.a(object1.hashCode());
        while (true) {
          i &= m;
          k = arrayOfShort[i] & 0xFFFF;
          if (k == 65535) {
            arrayOfShort[i] = (short)j;
            paramInt2++;
            continue label49;
          } 
          if (!paramArrayOfObject[k].equals(object1)) {
            i++;
            continue;
          } 
          throw a(object1, object2, paramArrayOfObject, k);
        } 
      } 
      return arrayOfShort;
    } 
    int[] arrayOfInt = new int[paramInt2];
    Arrays.fill(arrayOfInt, -1);
    paramInt2 = k;
    label50: while (paramInt2 < paramInt1) {
      j = paramInt2 * 2 + paramInt3;
      Object object1 = paramArrayOfObject[j];
      Object object2 = paramArrayOfObject[j ^ 0x1];
      CollectPreconditions.a(object1, object2);
      i = Hashing.a(object1.hashCode());
      while (true) {
        i &= m;
        k = arrayOfInt[i];
        if (k == -1) {
          arrayOfInt[i] = j;
          paramInt2++;
          continue label50;
        } 
        if (!paramArrayOfObject[k].equals(object1)) {
          i++;
          continue;
        } 
        throw a(object1, object2, paramArrayOfObject, k);
      } 
    } 
    return arrayOfInt;
  }
  
  boolean b() {
    return false;
  }
  
  ImmutableSet<K> c() {
    return new KeySet<K>(this, new KeysOrValuesAsList(this.c, 0, this.e));
  }
  
  @NullableDecl
  public V get(@NullableDecl Object paramObject) {
    return (V)a(this.d, this.c, this.e, 0, paramObject);
  }
  
  ImmutableCollection<V> h() {
    return new KeysOrValuesAsList(this.c, 1, this.e);
  }
  
  ImmutableSet<Map.Entry<K, V>> m() {
    return new EntrySet<K, V>(this, this.c, 0, this.e);
  }
  
  public int size() {
    return this.e;
  }
  
  static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
    private final transient ImmutableMap<K, V> a;
    
    private final transient Object[] b;
    
    private final transient int c;
    
    private final transient int d;
    
    EntrySet(ImmutableMap<K, V> param1ImmutableMap, Object[] param1ArrayOfObject, int param1Int1, int param1Int2) {
      this.a = param1ImmutableMap;
      this.b = param1ArrayOfObject;
      this.c = param1Int1;
      this.d = param1Int2;
    }
    
    int a(Object[] param1ArrayOfObject, int param1Int) {
      return h().a(param1ArrayOfObject, param1Int);
    }
    
    boolean a() {
      return true;
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> av_() {
      return h().av_();
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        Map.Entry entry = (Map.Entry)param1Object;
        param1Object = entry.getKey();
        entry = (Map.Entry)entry.getValue();
        bool1 = bool2;
        if (entry != null) {
          bool1 = bool2;
          if (entry.equals(this.a.get(param1Object)))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    ImmutableList<Map.Entry<K, V>> d() {
      return new ImmutableList<Map.Entry<K, V>>(this) {
          public boolean a() {
            return true;
          }
          
          public Map.Entry<K, V> b(int param2Int) {
            Preconditions.a(param2Int, RegularImmutableMap.EntrySet.a(this.a));
            Object[] arrayOfObject = RegularImmutableMap.EntrySet.b(this.a);
            param2Int *= 2;
            return new AbstractMap.SimpleImmutableEntry<K, V>((K)arrayOfObject[RegularImmutableMap.EntrySet.c(this.a) + param2Int], (V)RegularImmutableMap.EntrySet.b(this.a)[param2Int + (RegularImmutableMap.EntrySet.c(this.a) ^ 0x1)]);
          }
          
          public int size() {
            return RegularImmutableMap.EntrySet.a(this.a);
          }
        };
    }
    
    public int size() {
      return this.d;
    }
  }
  
  class null extends ImmutableList<Map.Entry<K, V>> {
    null(RegularImmutableMap this$0) {}
    
    public boolean a() {
      return true;
    }
    
    public Map.Entry<K, V> b(int param1Int) {
      Preconditions.a(param1Int, RegularImmutableMap.EntrySet.a(this.a));
      Object[] arrayOfObject = RegularImmutableMap.EntrySet.b(this.a);
      param1Int *= 2;
      return new AbstractMap.SimpleImmutableEntry<K, V>((K)arrayOfObject[RegularImmutableMap.EntrySet.c(this.a) + param1Int], (V)RegularImmutableMap.EntrySet.b(this.a)[param1Int + (RegularImmutableMap.EntrySet.c(this.a) ^ 0x1)]);
    }
    
    public int size() {
      return RegularImmutableMap.EntrySet.a(this.a);
    }
  }
  
  static final class KeySet<K> extends ImmutableSet<K> {
    private final transient ImmutableMap<K, ?> a;
    
    private final transient ImmutableList<K> b;
    
    KeySet(ImmutableMap<K, ?> param1ImmutableMap, ImmutableList<K> param1ImmutableList) {
      this.a = param1ImmutableMap;
      this.b = param1ImmutableList;
    }
    
    int a(Object[] param1ArrayOfObject, int param1Int) {
      return h().a(param1ArrayOfObject, param1Int);
    }
    
    boolean a() {
      return true;
    }
    
    public UnmodifiableIterator<K> av_() {
      return h().av_();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return (this.a.get(param1Object) != null);
    }
    
    public ImmutableList<K> h() {
      return this.b;
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  static final class KeysOrValuesAsList extends ImmutableList<Object> {
    private final transient Object[] a;
    
    private final transient int b;
    
    private final transient int c;
    
    KeysOrValuesAsList(Object[] param1ArrayOfObject, int param1Int1, int param1Int2) {
      this.a = param1ArrayOfObject;
      this.b = param1Int1;
      this.c = param1Int2;
    }
    
    boolean a() {
      return true;
    }
    
    public Object get(int param1Int) {
      Preconditions.a(param1Int, this.c);
      return this.a[param1Int * 2 + this.b];
    }
    
    public int size() {
      return this.c;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */