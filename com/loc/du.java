package com.loc;

import java.util.ArrayList;
import java.util.HashMap;

public final class du {
  private HashMap<Long, dv> a = new HashMap<Long, dv>();
  
  private long b = 0L;
  
  private static long a(int paramInt1, int paramInt2) {
    long l = paramInt1;
    return paramInt2 & 0xFFFFL | (l & 0xFFFFL) << 32L;
  }
  
  public final long a(dv paramdv) {
    // Byte code:
    //   0: lconst_0
    //   1: lstore #4
    //   3: aload_1
    //   4: ifnull -> 193
    //   7: aload_1
    //   8: getfield p : Z
    //   11: ifne -> 16
    //   14: lconst_0
    //   15: lreturn
    //   16: aload_0
    //   17: getfield a : Ljava/util/HashMap;
    //   20: astore #6
    //   22: aload_1
    //   23: getfield k : I
    //   26: istore_2
    //   27: iload_2
    //   28: iconst_1
    //   29: if_icmpeq -> 66
    //   32: iload_2
    //   33: iconst_2
    //   34: if_icmpeq -> 53
    //   37: iload_2
    //   38: iconst_3
    //   39: if_icmpeq -> 66
    //   42: iload_2
    //   43: iconst_4
    //   44: if_icmpeq -> 66
    //   47: lconst_0
    //   48: lstore #4
    //   50: goto -> 83
    //   53: aload_1
    //   54: getfield h : I
    //   57: istore_2
    //   58: aload_1
    //   59: getfield i : I
    //   62: istore_3
    //   63: goto -> 76
    //   66: aload_1
    //   67: getfield c : I
    //   70: istore_2
    //   71: aload_1
    //   72: getfield d : I
    //   75: istore_3
    //   76: iload_2
    //   77: iload_3
    //   78: invokestatic a : (II)J
    //   81: lstore #4
    //   83: aload #6
    //   85: lload #4
    //   87: invokestatic valueOf : (J)Ljava/lang/Long;
    //   90: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast com/loc/dv
    //   96: astore #7
    //   98: aload #7
    //   100: ifnonnull -> 124
    //   103: aload_1
    //   104: invokestatic b : ()J
    //   107: putfield m : J
    //   110: aload #6
    //   112: lload #4
    //   114: invokestatic valueOf : (J)Ljava/lang/Long;
    //   117: aload_1
    //   118: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: pop
    //   122: lconst_0
    //   123: lreturn
    //   124: aload #7
    //   126: getfield j : I
    //   129: aload_1
    //   130: getfield j : I
    //   133: if_icmpeq -> 157
    //   136: aload_1
    //   137: invokestatic b : ()J
    //   140: putfield m : J
    //   143: aload #6
    //   145: lload #4
    //   147: invokestatic valueOf : (J)Ljava/lang/Long;
    //   150: aload_1
    //   151: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   154: pop
    //   155: lconst_0
    //   156: lreturn
    //   157: aload_1
    //   158: aload #7
    //   160: getfield m : J
    //   163: putfield m : J
    //   166: aload #6
    //   168: lload #4
    //   170: invokestatic valueOf : (J)Ljava/lang/Long;
    //   173: aload_1
    //   174: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: invokestatic b : ()J
    //   181: aload #7
    //   183: getfield m : J
    //   186: lsub
    //   187: ldc2_w 1000
    //   190: ldiv
    //   191: lstore #4
    //   193: lload #4
    //   195: lreturn
  }
  
  public final void a() {
    this.a.clear();
    this.b = 0L;
  }
  
  public final void a(ArrayList<? extends dv> paramArrayList) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 367
    //   4: invokestatic b : ()J
    //   7: lstore #11
    //   9: aload_0
    //   10: getfield b : J
    //   13: lstore #7
    //   15: lload #7
    //   17: lconst_0
    //   18: lcmp
    //   19: ifle -> 35
    //   22: lload #11
    //   24: lload #7
    //   26: lsub
    //   27: ldc2_w 60000
    //   30: lcmp
    //   31: ifge -> 35
    //   34: return
    //   35: aload_0
    //   36: getfield a : Ljava/util/HashMap;
    //   39: astore #13
    //   41: aload_1
    //   42: invokevirtual size : ()I
    //   45: istore #6
    //   47: iconst_0
    //   48: istore #5
    //   50: lconst_0
    //   51: lstore #7
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iload #6
    //   58: if_icmpge -> 225
    //   61: aload_1
    //   62: iload_2
    //   63: invokevirtual get : (I)Ljava/lang/Object;
    //   66: checkcast com/loc/dv
    //   69: astore #14
    //   71: lload #7
    //   73: lstore #9
    //   75: aload #14
    //   77: getfield p : Z
    //   80: ifeq -> 214
    //   83: aload #14
    //   85: getfield k : I
    //   88: istore_3
    //   89: iload_3
    //   90: iconst_1
    //   91: if_icmpeq -> 128
    //   94: iload_3
    //   95: iconst_2
    //   96: if_icmpeq -> 112
    //   99: iload_3
    //   100: iconst_3
    //   101: if_icmpeq -> 128
    //   104: iload_3
    //   105: iconst_4
    //   106: if_icmpeq -> 128
    //   109: goto -> 149
    //   112: aload #14
    //   114: getfield h : I
    //   117: istore_3
    //   118: aload #14
    //   120: getfield i : I
    //   123: istore #4
    //   125: goto -> 141
    //   128: aload #14
    //   130: getfield c : I
    //   133: istore_3
    //   134: aload #14
    //   136: getfield d : I
    //   139: istore #4
    //   141: iload_3
    //   142: iload #4
    //   144: invokestatic a : (II)J
    //   147: lstore #7
    //   149: aload #13
    //   151: lload #7
    //   153: invokestatic valueOf : (J)Ljava/lang/Long;
    //   156: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   159: checkcast com/loc/dv
    //   162: astore #15
    //   164: lload #7
    //   166: lstore #9
    //   168: aload #15
    //   170: ifnull -> 214
    //   173: aload #15
    //   175: getfield j : I
    //   178: aload #14
    //   180: getfield j : I
    //   183: if_icmpne -> 203
    //   186: aload #14
    //   188: aload #15
    //   190: getfield m : J
    //   193: putfield m : J
    //   196: lload #7
    //   198: lstore #9
    //   200: goto -> 214
    //   203: aload #14
    //   205: lload #11
    //   207: putfield m : J
    //   210: lload #7
    //   212: lstore #9
    //   214: iload_2
    //   215: iconst_1
    //   216: iadd
    //   217: istore_2
    //   218: lload #9
    //   220: lstore #7
    //   222: goto -> 55
    //   225: aload #13
    //   227: invokevirtual clear : ()V
    //   230: aload_1
    //   231: invokevirtual size : ()I
    //   234: istore #6
    //   236: iload #5
    //   238: istore_2
    //   239: iload_2
    //   240: iload #6
    //   242: if_icmpge -> 361
    //   245: aload_1
    //   246: iload_2
    //   247: invokevirtual get : (I)Ljava/lang/Object;
    //   250: checkcast com/loc/dv
    //   253: astore #14
    //   255: lload #7
    //   257: lstore #9
    //   259: aload #14
    //   261: getfield p : Z
    //   264: ifeq -> 350
    //   267: aload #14
    //   269: getfield k : I
    //   272: istore_3
    //   273: iload_3
    //   274: iconst_1
    //   275: if_icmpeq -> 312
    //   278: iload_3
    //   279: iconst_2
    //   280: if_icmpeq -> 296
    //   283: iload_3
    //   284: iconst_3
    //   285: if_icmpeq -> 312
    //   288: iload_3
    //   289: iconst_4
    //   290: if_icmpeq -> 312
    //   293: goto -> 333
    //   296: aload #14
    //   298: getfield h : I
    //   301: istore_3
    //   302: aload #14
    //   304: getfield i : I
    //   307: istore #4
    //   309: goto -> 325
    //   312: aload #14
    //   314: getfield c : I
    //   317: istore_3
    //   318: aload #14
    //   320: getfield d : I
    //   323: istore #4
    //   325: iload_3
    //   326: iload #4
    //   328: invokestatic a : (II)J
    //   331: lstore #7
    //   333: aload #13
    //   335: lload #7
    //   337: invokestatic valueOf : (J)Ljava/lang/Long;
    //   340: aload #14
    //   342: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   345: pop
    //   346: lload #7
    //   348: lstore #9
    //   350: iload_2
    //   351: iconst_1
    //   352: iadd
    //   353: istore_2
    //   354: lload #9
    //   356: lstore #7
    //   358: goto -> 239
    //   361: aload_0
    //   362: lload #11
    //   364: putfield b : J
    //   367: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */