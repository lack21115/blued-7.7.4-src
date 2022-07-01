package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class i {
  private ByteBuffer a;
  
  private String b = "GBK";
  
  public i() {}
  
  public i(byte[] paramArrayOfbyte) {
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
  }
  
  public i(byte[] paramArrayOfbyte, int paramInt) {
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
    this.a.position(4);
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 4) {
        if (paramInt != 5) {
          if (paramInt == 12)
            return 0.0D; 
          throw new g("type mismatch.");
        } 
        return this.a.getDouble();
      } 
      return this.a.getFloat();
    } 
    if (!paramBoolean)
      return paramDouble; 
    throw new g("require field not exist.");
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 4) {
        if (paramInt == 12)
          return 0.0F; 
        throw new g("type mismatch.");
      } 
      return this.a.getFloat();
    } 
    if (!paramBoolean)
      return paramFloat; 
    throw new g("require field not exist.");
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer) {
    byte b = paramByteBuffer.get();
    parama.a = (byte)(b & 0xF);
    parama.b = (b & 0xF0) >> 4;
    if (parama.b == 15) {
      parama.b = paramByteBuffer.get();
      return 2;
    } 
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder;
    if (paramMap2 == null || paramMap2.isEmpty())
      return new HashMap<K, V>(); 
    Map.Entry entry = paramMap2.entrySet().iterator().next();
    paramMap2 = (Map<K, V>)entry.getKey();
    entry = (Map.Entry)entry.getValue();
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 8) {
        int j = a(0, 0, true);
        if (j >= 0) {
          for (paramInt = 0; paramInt < j; paramInt++)
            paramMap1.put((K)a(paramMap2, 0, true), (V)a(entry, 1, true)); 
        } else {
          stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else if (paramBoolean) {
      throw new g("require field not exist.");
    } 
    return (Map<K, V>)stringBuilder;
  }
  
  private void a() {
    a a = new a();
    do {
      a(a, this.a);
      a(a.a);
    } while (a.a != 11);
  }
  
  private void a(byte paramByte) {
    int j;
    a a;
    StringBuilder stringBuilder;
    int m = 0;
    int k = 0;
    switch (paramByte) {
      default:
        throw new g("invalid type.");
      case 13:
        a = new a();
        a(a, this.a);
        if (a.a == 0) {
          j = a(0, 0, true);
          byteBuffer = this.a;
          byteBuffer.position(byteBuffer.position() + j);
          return;
        } 
        stringBuilder = new StringBuilder("skipField with invalid type, type value: ");
        stringBuilder.append(j);
        stringBuilder.append(", ");
        stringBuilder.append(((a)byteBuffer).a);
        throw new g(stringBuilder.toString());
      case 11:
      case 12:
        return;
      case 10:
        a();
        return;
      case 9:
        m = a(0, 0, true);
        for (j = k; j < m; j++) {
          a a1 = new a();
          a(a1, this.a);
          a(a1.a);
        } 
        return;
      case 8:
        k = a(0, 0, true);
        for (j = m; j < k << 1; j++) {
          a a1 = new a();
          a(a1, this.a);
          a(a1.a);
        } 
        return;
      case 7:
        j = this.a.getInt();
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + j);
        return;
      case 6:
        k = this.a.get();
        j = k;
        if (k < 0)
          j = k + 256; 
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + j);
        return;
      case 5:
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + 8);
        return;
      case 4:
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + 4);
        return;
      case 3:
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + 8);
        return;
      case 2:
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + 4);
        return;
      case 1:
        byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + 2);
        return;
      case 0:
        break;
    } 
    ByteBuffer byteBuffer = this.a;
    byteBuffer.position(byteBuffer.position() + 1);
  }
  
  private boolean a(int paramInt) {
    try {
      a a = new a();
      while (true) {
        int k = a(a, this.a.duplicate());
        if (paramInt <= a.b || a.a == 11)
          break; 
        this.a.position(this.a.position() + k);
        a(a.a);
      } 
      int j = a.b;
      return (paramInt == j);
    } catch (g|java.nio.BufferUnderflowException g) {
      return false;
    } 
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean) {
    if (paramArrayOfT != null && paramArrayOfT.length != 0)
      return b(paramArrayOfT[0], paramInt, paramBoolean); 
    throw new g("unable to get type of key and value.");
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), j);
          for (paramInt = 0; paramInt < j; paramInt++)
            arrayOfObject[paramInt] = a(paramT, 0, true); 
          return (T[])arrayOfObject;
        } 
        StringBuilder stringBuilder = new StringBuilder("size invalid: ");
        stringBuilder.append(j);
        throw new g(stringBuilder.toString());
      } 
      throw new g("type mismatch.");
    } 
    if (!paramBoolean)
      return null; 
    throw new g("require field not exist.");
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          boolean[] arrayOfBoolean = new boolean[j];
          paramInt = 0;
          while (true) {
            boolean[] arrayOfBoolean1 = arrayOfBoolean;
            if (paramInt < j) {
              if (a((byte)0, 0, true) != 0) {
                paramBoolean = true;
              } else {
                paramBoolean = false;
              } 
              arrayOfBoolean[paramInt] = paramBoolean;
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (boolean[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private short[] e(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          short[] arrayOfShort = new short[j];
          paramInt = 0;
          while (true) {
            short[] arrayOfShort1 = arrayOfShort;
            if (paramInt < j) {
              arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (short[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private int[] f(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          int[] arrayOfInt = new int[j];
          paramInt = 0;
          while (true) {
            int[] arrayOfInt1 = arrayOfInt;
            if (paramInt < j) {
              arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (int[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private long[] g(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          long[] arrayOfLong = new long[j];
          paramInt = 0;
          while (true) {
            long[] arrayOfLong1 = arrayOfLong;
            if (paramInt < j) {
              arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (long[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private float[] h(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          float[] arrayOfFloat = new float[j];
          paramInt = 0;
          while (true) {
            float[] arrayOfFloat1 = arrayOfFloat;
            if (paramInt < j) {
              arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (float[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  private double[] i(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      if (a.a == 9) {
        int j = a(0, 0, true);
        if (j >= 0) {
          double[] arrayOfDouble = new double[j];
          paramInt = 0;
          while (true) {
            double[] arrayOfDouble1 = arrayOfDouble;
            if (paramInt < j) {
              arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
              paramInt++;
              continue;
            } 
            break;
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder("size invalid: ");
          stringBuilder.append(j);
          throw new g(stringBuilder.toString());
        } 
      } else {
        throw new g("type mismatch.");
      } 
    } else {
      if (!paramBoolean)
        return null; 
      throw new g("require field not exist.");
    } 
    return (double[])SYNTHETIC_LOCAL_VARIABLE_4;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 0) {
        if (paramInt == 12)
          return 0; 
        throw new g("type mismatch.");
      } 
      return this.a.get();
    } 
    if (!paramBoolean)
      return paramByte; 
    throw new g("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (a(paramInt2)) {
      a a = new a();
      a(a, this.a);
      paramInt1 = a.a;
      if (paramInt1 != 0) {
        if (paramInt1 != 1) {
          if (paramInt1 != 2) {
            if (paramInt1 == 12)
              return 0; 
            throw new g("type mismatch.");
          } 
          return this.a.getInt();
        } 
        return this.a.getShort();
      } 
      return this.a.get();
    } 
    if (!paramBoolean)
      return paramInt1; 
    throw new g("require field not exist.");
  }
  
  public final int a(String paramString) {
    this.b = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt != 3) {
              if (paramInt == 12)
                return 0L; 
              throw new g("type mismatch.");
            } 
            return this.a.getLong();
          } 
          paramInt = this.a.getInt();
        } else {
          paramInt = this.a.getShort();
        } 
      } else {
        paramInt = this.a.get();
      } 
      return paramInt;
    } 
    if (!paramBoolean)
      return paramLong; 
    throw new g("require field not exist.");
  }
  
  public final k a(k paramk, int paramInt, boolean paramBoolean) {
    if (a(paramInt))
      try {
        paramk = (k)paramk.getClass().newInstance();
        a a = new a();
        a(a, this.a);
        if (a.a == 10) {
          paramk.a(this);
          a();
          return paramk;
        } 
        throw new g("type mismatch.");
      } catch (Exception exception) {
        throw new g(exception.getMessage());
      }  
    if (!paramBoolean)
      return null; 
    throw new g("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/lang/Byte
    //   4: istore #6
    //   6: iconst_0
    //   7: istore #4
    //   9: iconst_0
    //   10: istore #5
    //   12: iload #6
    //   14: ifeq -> 28
    //   17: aload_0
    //   18: iconst_0
    //   19: iload_2
    //   20: iload_3
    //   21: invokevirtual a : (BIZ)B
    //   24: invokestatic valueOf : (B)Ljava/lang/Byte;
    //   27: areturn
    //   28: aload_1
    //   29: instanceof java/lang/Boolean
    //   32: ifeq -> 54
    //   35: aload_0
    //   36: iconst_0
    //   37: iload_2
    //   38: iload_3
    //   39: invokevirtual a : (BIZ)B
    //   42: ifeq -> 48
    //   45: iconst_1
    //   46: istore #5
    //   48: iload #5
    //   50: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   53: areturn
    //   54: aload_1
    //   55: instanceof java/lang/Short
    //   58: ifeq -> 72
    //   61: aload_0
    //   62: iconst_0
    //   63: iload_2
    //   64: iload_3
    //   65: invokevirtual a : (SIZ)S
    //   68: invokestatic valueOf : (S)Ljava/lang/Short;
    //   71: areturn
    //   72: aload_1
    //   73: instanceof java/lang/Integer
    //   76: ifeq -> 90
    //   79: aload_0
    //   80: iconst_0
    //   81: iload_2
    //   82: iload_3
    //   83: invokevirtual a : (IIZ)I
    //   86: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   89: areturn
    //   90: aload_1
    //   91: instanceof java/lang/Long
    //   94: ifeq -> 108
    //   97: aload_0
    //   98: lconst_0
    //   99: iload_2
    //   100: iload_3
    //   101: invokevirtual a : (JIZ)J
    //   104: invokestatic valueOf : (J)Ljava/lang/Long;
    //   107: areturn
    //   108: aload_1
    //   109: instanceof java/lang/Float
    //   112: ifeq -> 126
    //   115: aload_0
    //   116: fconst_0
    //   117: iload_2
    //   118: iload_3
    //   119: invokespecial a : (FIZ)F
    //   122: invokestatic valueOf : (F)Ljava/lang/Float;
    //   125: areturn
    //   126: aload_1
    //   127: instanceof java/lang/Double
    //   130: ifeq -> 144
    //   133: aload_0
    //   134: dconst_0
    //   135: iload_2
    //   136: iload_3
    //   137: invokespecial a : (DIZ)D
    //   140: invokestatic valueOf : (D)Ljava/lang/Double;
    //   143: areturn
    //   144: aload_1
    //   145: instanceof java/lang/String
    //   148: ifeq -> 161
    //   151: aload_0
    //   152: iload_2
    //   153: iload_3
    //   154: invokevirtual b : (IZ)Ljava/lang/String;
    //   157: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   160: areturn
    //   161: aload_1
    //   162: instanceof java/util/Map
    //   165: ifeq -> 191
    //   168: aload_1
    //   169: checkcast java/util/Map
    //   172: astore_1
    //   173: aload_0
    //   174: new java/util/HashMap
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: aload_1
    //   182: iload_2
    //   183: iload_3
    //   184: invokespecial a : (Ljava/util/Map;Ljava/util/Map;IZ)Ljava/util/Map;
    //   187: checkcast java/util/HashMap
    //   190: areturn
    //   191: aload_1
    //   192: instanceof java/util/List
    //   195: ifeq -> 284
    //   198: aload_1
    //   199: checkcast java/util/List
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull -> 276
    //   207: aload_1
    //   208: invokeinterface isEmpty : ()Z
    //   213: ifeq -> 219
    //   216: goto -> 276
    //   219: aload_0
    //   220: aload_1
    //   221: iconst_0
    //   222: invokeinterface get : (I)Ljava/lang/Object;
    //   227: iload_2
    //   228: iload_3
    //   229: invokespecial b : (Ljava/lang/Object;IZ)[Ljava/lang/Object;
    //   232: astore_1
    //   233: aload_1
    //   234: ifnonnull -> 239
    //   237: aconst_null
    //   238: areturn
    //   239: new java/util/ArrayList
    //   242: dup
    //   243: invokespecial <init> : ()V
    //   246: astore #7
    //   248: iload #4
    //   250: istore_2
    //   251: iload_2
    //   252: aload_1
    //   253: arraylength
    //   254: if_icmpge -> 273
    //   257: aload #7
    //   259: aload_1
    //   260: iload_2
    //   261: aaload
    //   262: invokevirtual add : (Ljava/lang/Object;)Z
    //   265: pop
    //   266: iload_2
    //   267: iconst_1
    //   268: iadd
    //   269: istore_2
    //   270: goto -> 251
    //   273: aload #7
    //   275: areturn
    //   276: new java/util/ArrayList
    //   279: dup
    //   280: invokespecial <init> : ()V
    //   283: areturn
    //   284: aload_1
    //   285: instanceof com/tencent/bugly/proguard/k
    //   288: ifeq -> 302
    //   291: aload_0
    //   292: aload_1
    //   293: checkcast com/tencent/bugly/proguard/k
    //   296: iload_2
    //   297: iload_3
    //   298: invokevirtual a : (Lcom/tencent/bugly/proguard/k;IZ)Lcom/tencent/bugly/proguard/k;
    //   301: areturn
    //   302: aload_1
    //   303: invokevirtual getClass : ()Ljava/lang/Class;
    //   306: invokevirtual isArray : ()Z
    //   309: ifeq -> 431
    //   312: aload_1
    //   313: instanceof [B
    //   316: ifne -> 424
    //   319: aload_1
    //   320: instanceof [Ljava/lang/Byte;
    //   323: ifeq -> 329
    //   326: goto -> 424
    //   329: aload_1
    //   330: instanceof [Z
    //   333: ifeq -> 343
    //   336: aload_0
    //   337: iload_2
    //   338: iload_3
    //   339: invokespecial d : (IZ)[Z
    //   342: areturn
    //   343: aload_1
    //   344: instanceof [S
    //   347: ifeq -> 357
    //   350: aload_0
    //   351: iload_2
    //   352: iload_3
    //   353: invokespecial e : (IZ)[S
    //   356: areturn
    //   357: aload_1
    //   358: instanceof [I
    //   361: ifeq -> 371
    //   364: aload_0
    //   365: iload_2
    //   366: iload_3
    //   367: invokespecial f : (IZ)[I
    //   370: areturn
    //   371: aload_1
    //   372: instanceof [J
    //   375: ifeq -> 385
    //   378: aload_0
    //   379: iload_2
    //   380: iload_3
    //   381: invokespecial g : (IZ)[J
    //   384: areturn
    //   385: aload_1
    //   386: instanceof [F
    //   389: ifeq -> 399
    //   392: aload_0
    //   393: iload_2
    //   394: iload_3
    //   395: invokespecial h : (IZ)[F
    //   398: areturn
    //   399: aload_1
    //   400: instanceof [D
    //   403: ifeq -> 413
    //   406: aload_0
    //   407: iload_2
    //   408: iload_3
    //   409: invokespecial i : (IZ)[D
    //   412: areturn
    //   413: aload_0
    //   414: aload_1
    //   415: checkcast [Ljava/lang/Object;
    //   418: iload_2
    //   419: iload_3
    //   420: invokespecial a : ([Ljava/lang/Object;IZ)[Ljava/lang/Object;
    //   423: areturn
    //   424: aload_0
    //   425: iload_2
    //   426: iload_3
    //   427: invokevirtual c : (IZ)[B
    //   430: areturn
    //   431: new com/tencent/bugly/proguard/g
    //   434: dup
    //   435: ldc_w 'read object error: unsupport type.'
    //   438: invokespecial <init> : (Ljava/lang/String;)V
    //   441: athrow
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean) {
    return (HashMap<K, V>)a(new HashMap<K, V>(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt == 12)
            return 0; 
          throw new g("type mismatch.");
        } 
        return this.a.getShort();
      } 
      return (short)this.a.get();
    } 
    if (!paramBoolean)
      return paramShort; 
    throw new g("require field not exist.");
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = this.a;
    if (byteBuffer != null)
      byteBuffer.clear(); 
    this.a = ByteBuffer.wrap(paramArrayOfbyte);
  }
  
  public final boolean a(int paramInt, boolean paramBoolean) {
    return (a((byte)0, paramInt, paramBoolean) != 0);
  }
  
  public final String b(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      paramInt = a.a;
      if (paramInt != 6) {
        if (paramInt == 7) {
          paramInt = this.a.getInt();
          if (paramInt <= 104857600 && paramInt >= 0) {
            byte[] arrayOfByte1 = new byte[paramInt];
            this.a.get(arrayOfByte1);
            try {
              return new String(arrayOfByte1, this.b);
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
              return new String(arrayOfByte1);
            } 
          } 
          StringBuilder stringBuilder = new StringBuilder("String too long: ");
          stringBuilder.append(paramInt);
          throw new g(stringBuilder.toString());
        } 
        throw new g("type mismatch.");
      } 
      byte b = this.a.get();
      paramInt = b;
      if (b < 0)
        paramInt = b + 256; 
      byte[] arrayOfByte = new byte[paramInt];
      this.a.get(arrayOfByte);
      try {
        return new String(arrayOfByte, this.b);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        return new String(arrayOfByte);
      } 
    } 
    if (!paramBoolean)
      return null; 
    throw new g("require field not exist.");
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      a a = new a();
      a(a, this.a);
      byte b = a.a;
      if (b != 9) {
        if (b == 13) {
          byte[] arrayOfByte;
          a a1 = new a();
          a(a1, this.a);
          if (a1.a == 0) {
            int k = a(0, 0, true);
            if (k >= 0) {
              arrayOfByte = new byte[k];
              this.a.get(arrayOfByte);
              return arrayOfByte;
            } 
            StringBuilder stringBuilder2 = new StringBuilder("invalid size, tag: ");
            stringBuilder2.append(paramInt);
            stringBuilder2.append(", type: ");
            stringBuilder2.append(((a)arrayOfByte).a);
            stringBuilder2.append(", ");
            stringBuilder2.append(a1.a);
            stringBuilder2.append(", size: ");
            stringBuilder2.append(k);
            throw new g(stringBuilder2.toString());
          } 
          StringBuilder stringBuilder1 = new StringBuilder("type mismatch, tag: ");
          stringBuilder1.append(paramInt);
          stringBuilder1.append(", type: ");
          stringBuilder1.append(((a)arrayOfByte).a);
          stringBuilder1.append(", ");
          stringBuilder1.append(a1.a);
          throw new g(stringBuilder1.toString());
        } 
        throw new g("type mismatch.");
      } 
      int j = a(0, 0, true);
      if (j >= 0) {
        byte[] arrayOfByte = new byte[j];
        for (paramInt = 0; paramInt < j; paramInt++)
          arrayOfByte[paramInt] = a(arrayOfByte[0], 0, true); 
        return arrayOfByte;
      } 
      StringBuilder stringBuilder = new StringBuilder("size invalid: ");
      stringBuilder.append(j);
      throw new g(stringBuilder.toString());
    } 
    if (!paramBoolean)
      return null; 
    throw new g("require field not exist.");
  }
  
  public static final class a {
    public byte a;
    
    public int b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */