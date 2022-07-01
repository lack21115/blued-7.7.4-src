package com.loc;

import java.util.List;

public final class by {
  private static volatile by g;
  
  private static Object h = new Object();
  
  private bx a = new bx();
  
  private bz b = new bz();
  
  private long c;
  
  private dc d;
  
  private bu e = new bu();
  
  private dc f = new dc();
  
  public static by a() {
    if (g == null)
      synchronized (h) {
        if (g == null)
          g = new by(); 
      }  
    return g;
  }
  
  public final ca a(a parama) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #8
    //   3: aconst_null
    //   4: astore #9
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: invokestatic currentTimeMillis : ()J
    //   15: lstore_2
    //   16: invokestatic elapsedRealtime : ()J
    //   19: lstore #4
    //   21: aload_0
    //   22: getfield d : Lcom/loc/dc;
    //   25: ifnull -> 46
    //   28: aload_1
    //   29: getfield a : Lcom/loc/dc;
    //   32: aload_0
    //   33: getfield d : Lcom/loc/dc;
    //   36: invokevirtual a : (Lcom/loc/db;)D
    //   39: ldc2_w 10.0
    //   42: dcmpl
    //   43: iflt -> 256
    //   46: aload_0
    //   47: getfield a : Lcom/loc/bx;
    //   50: aload_1
    //   51: getfield a : Lcom/loc/dc;
    //   54: aload_1
    //   55: getfield j : Z
    //   58: aload_1
    //   59: getfield g : B
    //   62: aload_1
    //   63: getfield h : Ljava/lang/String;
    //   66: aload_1
    //   67: getfield i : Ljava/util/List;
    //   70: invokevirtual a : (Lcom/loc/dc;ZBLjava/lang/String;Ljava/util/List;)Lcom/loc/bx$a;
    //   73: astore #10
    //   75: aload_0
    //   76: getfield b : Lcom/loc/bz;
    //   79: aload_1
    //   80: getfield a : Lcom/loc/dc;
    //   83: aload_1
    //   84: getfield b : Ljava/util/List;
    //   87: aload_1
    //   88: getfield e : Z
    //   91: aload_1
    //   92: getfield d : J
    //   95: lload_2
    //   96: invokevirtual a : (Lcom/loc/dc;Ljava/util/List;ZJJ)Ljava/util/List;
    //   99: astore #11
    //   101: aload #10
    //   103: ifnonnull -> 115
    //   106: aload #9
    //   108: astore #8
    //   110: aload #11
    //   112: ifnull -> 242
    //   115: aload_0
    //   116: getfield f : Lcom/loc/dc;
    //   119: astore #8
    //   121: aload_1
    //   122: getfield a : Lcom/loc/dc;
    //   125: astore #9
    //   127: aload_1
    //   128: getfield f : J
    //   131: lstore #6
    //   133: aload #8
    //   135: lload #6
    //   137: putfield k : J
    //   140: aload #8
    //   142: lload #6
    //   144: putfield b : J
    //   147: aload #8
    //   149: lload_2
    //   150: putfield c : J
    //   153: aload #8
    //   155: aload #9
    //   157: getfield e : D
    //   160: putfield e : D
    //   163: aload #8
    //   165: aload #9
    //   167: getfield d : D
    //   170: putfield d : D
    //   173: aload #8
    //   175: aload #9
    //   177: getfield f : D
    //   180: putfield f : D
    //   183: aload #8
    //   185: aload #9
    //   187: getfield i : F
    //   190: putfield i : F
    //   193: aload #8
    //   195: aload #9
    //   197: getfield g : F
    //   200: putfield g : F
    //   203: aload #8
    //   205: aload #9
    //   207: getfield h : F
    //   210: putfield h : F
    //   213: new com/loc/ca
    //   216: dup
    //   217: iconst_0
    //   218: aload_0
    //   219: getfield e : Lcom/loc/bu;
    //   222: aload_0
    //   223: getfield f : Lcom/loc/dc;
    //   226: aload #10
    //   228: aload_1
    //   229: getfield c : J
    //   232: aload #11
    //   234: invokevirtual a : (Lcom/loc/dc;Lcom/loc/bx$a;JLjava/util/List;)[B
    //   237: invokespecial <init> : (I[B)V
    //   240: astore #8
    //   242: aload_0
    //   243: aload_1
    //   244: getfield a : Lcom/loc/dc;
    //   247: putfield d : Lcom/loc/dc;
    //   250: aload_0
    //   251: lload #4
    //   253: putfield c : J
    //   256: aload #8
    //   258: areturn
  }
  
  public static final class a {
    public dc a;
    
    public List<dd> b;
    
    public long c;
    
    public long d;
    
    public boolean e;
    
    public long f;
    
    public byte g;
    
    public String h;
    
    public List<cw> i;
    
    public boolean j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */