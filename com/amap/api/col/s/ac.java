package com.amap.api.col.s;

final class ac {
  private static volatile boolean a = false;
  
  public static void a() {
    // Byte code:
    //   0: ldc com/amap/api/col/s/ac
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/ac.a : Z
    //   6: ifne -> 109
    //   9: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   12: ldc 'regeo'
    //   14: new com/amap/api/col/s/af
    //   17: dup
    //   18: iconst_1
    //   19: anewarray java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc '/geocode/regeo'
    //   26: aastore
    //   27: invokespecial <init> : ([Ljava/lang/String;)V
    //   30: invokevirtual a : (Ljava/lang/String;Lcom/amap/api/col/s/ae;)V
    //   33: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   36: ldc 'placeAround'
    //   38: new com/amap/api/col/s/af
    //   41: dup
    //   42: iconst_1
    //   43: anewarray java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc '/place/around'
    //   50: aastore
    //   51: invokespecial <init> : ([Ljava/lang/String;)V
    //   54: invokevirtual a : (Ljava/lang/String;Lcom/amap/api/col/s/ae;)V
    //   57: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   60: ldc 'placeText'
    //   62: new com/amap/api/col/s/ae
    //   65: dup
    //   66: iconst_1
    //   67: anewarray java/lang/String
    //   70: dup
    //   71: iconst_0
    //   72: ldc '/place/text'
    //   74: aastore
    //   75: invokespecial <init> : ([Ljava/lang/String;)V
    //   78: invokevirtual a : (Ljava/lang/String;Lcom/amap/api/col/s/ae;)V
    //   81: invokestatic a : ()Lcom/amap/api/col/s/ad;
    //   84: ldc 'geo'
    //   86: new com/amap/api/col/s/ae
    //   89: dup
    //   90: iconst_1
    //   91: anewarray java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: ldc '/geocode/geo'
    //   98: aastore
    //   99: invokespecial <init> : ([Ljava/lang/String;)V
    //   102: invokevirtual a : (Ljava/lang/String;Lcom/amap/api/col/s/ae;)V
    //   105: iconst_1
    //   106: putstatic com/amap/api/col/s/ac.a : Z
    //   109: ldc com/amap/api/col/s/ac
    //   111: monitorexit
    //   112: return
    //   113: astore_0
    //   114: ldc com/amap/api/col/s/ac
    //   116: monitorexit
    //   117: aload_0
    //   118: athrow
    // Exception table:
    //   from	to	target	type
    //   3	109	113	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */