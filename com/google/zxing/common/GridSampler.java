package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
  private static GridSampler a = new DefaultGridSampler();
  
  public static GridSampler a() {
    return a;
  }
  
  protected static void a(BitMatrix paramBitMatrix, float[] paramArrayOffloat) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual e : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: invokevirtual f : ()I
    //   10: istore #5
    //   12: iconst_0
    //   13: istore_3
    //   14: iconst_1
    //   15: istore_2
    //   16: iload_3
    //   17: aload_1
    //   18: arraylength
    //   19: if_icmpge -> 146
    //   22: iload_2
    //   23: ifeq -> 146
    //   26: aload_1
    //   27: iload_3
    //   28: faload
    //   29: f2i
    //   30: istore_2
    //   31: iload_3
    //   32: iconst_1
    //   33: iadd
    //   34: istore #6
    //   36: aload_1
    //   37: iload #6
    //   39: faload
    //   40: f2i
    //   41: istore #7
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmplt -> 142
    //   48: iload_2
    //   49: iload #4
    //   51: if_icmpgt -> 142
    //   54: iload #7
    //   56: iconst_m1
    //   57: if_icmplt -> 142
    //   60: iload #7
    //   62: iload #5
    //   64: if_icmpgt -> 142
    //   67: iload_2
    //   68: iconst_m1
    //   69: if_icmpne -> 81
    //   72: aload_1
    //   73: iload_3
    //   74: fconst_0
    //   75: fastore
    //   76: iconst_1
    //   77: istore_2
    //   78: goto -> 100
    //   81: iload_2
    //   82: iload #4
    //   84: if_icmpne -> 98
    //   87: aload_1
    //   88: iload_3
    //   89: iload #4
    //   91: iconst_1
    //   92: isub
    //   93: i2f
    //   94: fastore
    //   95: goto -> 76
    //   98: iconst_0
    //   99: istore_2
    //   100: iload #7
    //   102: iconst_m1
    //   103: if_icmpne -> 116
    //   106: aload_1
    //   107: iload #6
    //   109: fconst_0
    //   110: fastore
    //   111: iconst_1
    //   112: istore_2
    //   113: goto -> 135
    //   116: iload #7
    //   118: iload #5
    //   120: if_icmpne -> 135
    //   123: aload_1
    //   124: iload #6
    //   126: iload #5
    //   128: iconst_1
    //   129: isub
    //   130: i2f
    //   131: fastore
    //   132: goto -> 111
    //   135: iload_3
    //   136: iconst_2
    //   137: iadd
    //   138: istore_3
    //   139: goto -> 16
    //   142: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   145: athrow
    //   146: aload_1
    //   147: arraylength
    //   148: iconst_2
    //   149: isub
    //   150: istore_3
    //   151: iconst_1
    //   152: istore_2
    //   153: iload_3
    //   154: iflt -> 281
    //   157: iload_2
    //   158: ifeq -> 281
    //   161: aload_1
    //   162: iload_3
    //   163: faload
    //   164: f2i
    //   165: istore_2
    //   166: iload_3
    //   167: iconst_1
    //   168: iadd
    //   169: istore #6
    //   171: aload_1
    //   172: iload #6
    //   174: faload
    //   175: f2i
    //   176: istore #7
    //   178: iload_2
    //   179: iconst_m1
    //   180: if_icmplt -> 277
    //   183: iload_2
    //   184: iload #4
    //   186: if_icmpgt -> 277
    //   189: iload #7
    //   191: iconst_m1
    //   192: if_icmplt -> 277
    //   195: iload #7
    //   197: iload #5
    //   199: if_icmpgt -> 277
    //   202: iload_2
    //   203: iconst_m1
    //   204: if_icmpne -> 216
    //   207: aload_1
    //   208: iload_3
    //   209: fconst_0
    //   210: fastore
    //   211: iconst_1
    //   212: istore_2
    //   213: goto -> 235
    //   216: iload_2
    //   217: iload #4
    //   219: if_icmpne -> 233
    //   222: aload_1
    //   223: iload_3
    //   224: iload #4
    //   226: iconst_1
    //   227: isub
    //   228: i2f
    //   229: fastore
    //   230: goto -> 211
    //   233: iconst_0
    //   234: istore_2
    //   235: iload #7
    //   237: iconst_m1
    //   238: if_icmpne -> 251
    //   241: aload_1
    //   242: iload #6
    //   244: fconst_0
    //   245: fastore
    //   246: iconst_1
    //   247: istore_2
    //   248: goto -> 270
    //   251: iload #7
    //   253: iload #5
    //   255: if_icmpne -> 270
    //   258: aload_1
    //   259: iload #6
    //   261: iload #5
    //   263: iconst_1
    //   264: isub
    //   265: i2f
    //   266: fastore
    //   267: goto -> 246
    //   270: iload_3
    //   271: iconst_2
    //   272: isub
    //   273: istore_3
    //   274: goto -> 153
    //   277: invokestatic a : ()Lcom/google/zxing/NotFoundException;
    //   280: athrow
    //   281: return
  }
  
  public abstract BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) throws NotFoundException;
  
  public abstract BitMatrix a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform) throws NotFoundException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\GridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */