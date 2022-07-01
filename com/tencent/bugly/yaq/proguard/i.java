package com.tencent.bugly.yaq.proguard;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class i {
  private ByteBuffer a;
  
  private String b;
  
  public i() {
    throw new VerifyError("bad dex opcode");
  }
  
  public i(byte[] paramArrayOfbyte) {
    throw new VerifyError("bad dex opcode");
  }
  
  public i(byte[] paramArrayOfbyte, int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  private double a(double paramDouble, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramDouble;
  }
  
  private float a(float paramFloat, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramFloat;
  }
  
  private static int a(a parama, ByteBuffer paramByteBuffer) {
    throw new VerifyError("bad dex opcode");
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean) {
    if (paramMap2 == null || paramMap2.isEmpty())
      return new HashMap<K, V>(); 
    Map.Entry entry = paramMap2.entrySet().iterator().next();
    entry.getKey();
    entry.getValue();
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramMap1;
  }
  
  private void a() {
    new a();
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(byte paramByte) {
    switch (paramByte) {
      default:
        throw new g("invalid type.");
      case 0:
        throw new VerifyError("bad dex opcode");
      case 11:
      case 12:
        throw new VerifyError("bad dex opcode");
      case 1:
        throw new VerifyError("bad dex opcode");
      case 2:
        throw new VerifyError("bad dex opcode");
      case 3:
        throw new VerifyError("bad dex opcode");
      case 4:
        throw new VerifyError("bad dex opcode");
      case 5:
        throw new VerifyError("bad dex opcode");
      case 6:
        throw new VerifyError("bad dex opcode");
      case 7:
        throw new VerifyError("bad dex opcode");
      case 8:
        throw new VerifyError("bad dex opcode");
      case 9:
        throw new VerifyError("bad dex opcode");
      case 13:
        new a();
        throw new VerifyError("bad dex opcode");
      case 10:
        break;
    } 
    a();
  }
  
  private boolean a(int paramInt) {
    try {
      new a();
      throw new VerifyError("bad dex opcode");
    } catch (g g) {
      return false;
    } catch (BufferUnderflowException bufferUnderflowException) {
      return false;
    } 
  }
  
  private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean) {
    if (paramArrayOfT == null || paramArrayOfT.length == 0)
      throw new g("unable to get type of key and value."); 
    return b(paramArrayOfT[0], paramInt, paramBoolean);
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private boolean[] d(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private short[] e(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private int[] f(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private long[] g(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private float[] h(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  private double[] i(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramByte;
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (a(paramInt2)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramInt1;
  }
  
  public final int a(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramLong;
  }
  
  public final k a(k paramk, int paramInt, boolean paramBoolean) {
    if (a(paramInt))
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Exception exception) {
        throw new VerifyError("bad dex opcode");
      }  
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/lang/Byte
    //   4: ifeq -> 17
    //   7: new java/lang/VerifyError
    //   10: dup
    //   11: ldc 'bad dex opcode'
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_1
    //   18: instanceof java/lang/Boolean
    //   21: ifeq -> 34
    //   24: new java/lang/VerifyError
    //   27: dup
    //   28: ldc 'bad dex opcode'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: athrow
    //   34: aload_1
    //   35: instanceof java/lang/Short
    //   38: ifeq -> 51
    //   41: new java/lang/VerifyError
    //   44: dup
    //   45: ldc 'bad dex opcode'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: athrow
    //   51: aload_1
    //   52: instanceof java/lang/Integer
    //   55: ifeq -> 68
    //   58: new java/lang/VerifyError
    //   61: dup
    //   62: ldc 'bad dex opcode'
    //   64: invokespecial <init> : (Ljava/lang/String;)V
    //   67: athrow
    //   68: aload_1
    //   69: instanceof java/lang/Long
    //   72: ifeq -> 85
    //   75: new java/lang/VerifyError
    //   78: dup
    //   79: ldc 'bad dex opcode'
    //   81: invokespecial <init> : (Ljava/lang/String;)V
    //   84: athrow
    //   85: aload_1
    //   86: instanceof java/lang/Float
    //   89: ifeq -> 103
    //   92: aload_0
    //   93: fconst_0
    //   94: iload_2
    //   95: iload_3
    //   96: invokespecial a : (FIZ)F
    //   99: invokestatic valueOf : (F)Ljava/lang/Float;
    //   102: areturn
    //   103: aload_1
    //   104: instanceof java/lang/Double
    //   107: ifeq -> 121
    //   110: aload_0
    //   111: dconst_0
    //   112: iload_2
    //   113: iload_3
    //   114: invokespecial a : (DIZ)D
    //   117: invokestatic valueOf : (D)Ljava/lang/Double;
    //   120: areturn
    //   121: aload_1
    //   122: instanceof java/lang/String
    //   125: ifeq -> 138
    //   128: new java/lang/VerifyError
    //   131: dup
    //   132: ldc 'bad dex opcode'
    //   134: invokespecial <init> : (Ljava/lang/String;)V
    //   137: athrow
    //   138: aload_1
    //   139: instanceof java/util/Map
    //   142: ifeq -> 168
    //   145: aload_1
    //   146: checkcast java/util/Map
    //   149: astore_1
    //   150: aload_0
    //   151: new java/util/HashMap
    //   154: dup
    //   155: invokespecial <init> : ()V
    //   158: aload_1
    //   159: iload_2
    //   160: iload_3
    //   161: invokespecial a : (Ljava/util/Map;Ljava/util/Map;IZ)Ljava/util/Map;
    //   164: checkcast java/util/HashMap
    //   167: areturn
    //   168: aload_1
    //   169: instanceof java/util/List
    //   172: ifeq -> 252
    //   175: aload_1
    //   176: checkcast java/util/List
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull -> 193
    //   184: aload_1
    //   185: invokeinterface isEmpty : ()Z
    //   190: ifeq -> 201
    //   193: new java/util/ArrayList
    //   196: dup
    //   197: invokespecial <init> : ()V
    //   200: areturn
    //   201: aload_0
    //   202: aload_1
    //   203: iconst_0
    //   204: invokeinterface get : (I)Ljava/lang/Object;
    //   209: iload_2
    //   210: iload_3
    //   211: invokespecial b : (Ljava/lang/Object;IZ)[Ljava/lang/Object;
    //   214: astore_1
    //   215: aload_1
    //   216: ifnonnull -> 221
    //   219: aconst_null
    //   220: areturn
    //   221: new java/util/ArrayList
    //   224: dup
    //   225: invokespecial <init> : ()V
    //   228: astore #4
    //   230: aload_1
    //   231: arraylength
    //   232: ifge -> 249
    //   235: aload_1
    //   236: iconst_0
    //   237: aaload
    //   238: astore_1
    //   239: new java/lang/VerifyError
    //   242: dup
    //   243: ldc 'bad dex opcode'
    //   245: invokespecial <init> : (Ljava/lang/String;)V
    //   248: athrow
    //   249: aload #4
    //   251: areturn
    //   252: aload_1
    //   253: instanceof com/tencent/bugly/yaq/proguard/k
    //   256: ifeq -> 269
    //   259: new java/lang/VerifyError
    //   262: dup
    //   263: ldc 'bad dex opcode'
    //   265: invokespecial <init> : (Ljava/lang/String;)V
    //   268: athrow
    //   269: new java/lang/VerifyError
    //   272: dup
    //   273: ldc 'bad dex opcode'
    //   275: invokespecial <init> : (Ljava/lang/String;)V
    //   278: athrow
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean) {
    return (HashMap<K, V>)a(new HashMap<K, V>(), paramMap, paramInt, paramBoolean);
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return paramShort;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean a(int paramInt, boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final String b(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  public final byte[] c(int paramInt, boolean paramBoolean) {
    if (a(paramInt)) {
      new a();
      throw new VerifyError("bad dex opcode");
    } 
    if (paramBoolean)
      throw new g("require field not exist."); 
    return null;
  }
  
  public static final class a {
    public byte a;
    
    public int b;
    
    public a() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */