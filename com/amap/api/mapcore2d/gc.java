package com.amap.api.mapcore2d;

public final class gc {
  private static gc b;
  
  long a = 0L;
  
  private gg c = null;
  
  private long d = 0L;
  
  private long e = 0L;
  
  public static gc a() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/gc
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/gc.b : Lcom/amap/api/mapcore2d/gc;
    //   6: ifnonnull -> 19
    //   9: new com/amap/api/mapcore2d/gc
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/amap/api/mapcore2d/gc.b : Lcom/amap/api/mapcore2d/gc;
    //   19: getstatic com/amap/api/mapcore2d/gc.b : Lcom/amap/api/mapcore2d/gc;
    //   22: astore_0
    //   23: ldc com/amap/api/mapcore2d/gc
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/amap/api/mapcore2d/gc
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static gg b(gg paramgg) {
    return paramgg;
  }
  
  public final gg a(gg paramgg) {
    // Byte code:
    //   0: invokestatic b : ()J
    //   3: aload_0
    //   4: getfield a : J
    //   7: lsub
    //   8: ldc2_w 30000
    //   11: lcmp
    //   12: ifle -> 32
    //   15: aload_0
    //   16: aload_1
    //   17: putfield c : Lcom/amap/api/mapcore2d/gg;
    //   20: aload_0
    //   21: invokestatic b : ()J
    //   24: putfield a : J
    //   27: aload_0
    //   28: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   31: areturn
    //   32: aload_0
    //   33: invokestatic b : ()J
    //   36: putfield a : J
    //   39: aload_0
    //   40: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   43: invokestatic a : (Lcom/amap/api/mapcore2d/gg;)Z
    //   46: ifeq -> 98
    //   49: aload_1
    //   50: invokestatic a : (Lcom/amap/api/mapcore2d/gg;)Z
    //   53: ifne -> 59
    //   56: goto -> 98
    //   59: aload_1
    //   60: invokevirtual getTime : ()J
    //   63: aload_0
    //   64: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   67: invokevirtual getTime : ()J
    //   70: lcmp
    //   71: ifne -> 86
    //   74: aload_1
    //   75: invokevirtual getAccuracy : ()F
    //   78: ldc 300.0
    //   80: fcmpg
    //   81: ifge -> 86
    //   84: aload_1
    //   85: areturn
    //   86: aload_1
    //   87: invokevirtual getProvider : ()Ljava/lang/String;
    //   90: ldc 'gps'
    //   92: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   95: ifeq -> 113
    //   98: aload_0
    //   99: invokestatic b : ()J
    //   102: putfield d : J
    //   105: aload_0
    //   106: aload_1
    //   107: putfield c : Lcom/amap/api/mapcore2d/gg;
    //   110: goto -> 27
    //   113: aload_1
    //   114: invokevirtual c : ()I
    //   117: aload_0
    //   118: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   121: invokevirtual c : ()I
    //   124: if_icmpeq -> 130
    //   127: goto -> 98
    //   130: aload_1
    //   131: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   134: aload_0
    //   135: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   138: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   141: invokevirtual equals : (Ljava/lang/Object;)Z
    //   144: ifne -> 160
    //   147: aload_1
    //   148: invokevirtual getBuildingId : ()Ljava/lang/String;
    //   151: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   154: ifne -> 160
    //   157: goto -> 98
    //   160: iconst_4
    //   161: newarray double
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: invokevirtual getLatitude : ()D
    //   169: dastore
    //   170: dup
    //   171: iconst_1
    //   172: aload_1
    //   173: invokevirtual getLongitude : ()D
    //   176: dastore
    //   177: dup
    //   178: iconst_2
    //   179: aload_0
    //   180: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   183: invokevirtual getLatitude : ()D
    //   186: dastore
    //   187: dup
    //   188: iconst_3
    //   189: aload_0
    //   190: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   193: invokevirtual getLongitude : ()D
    //   196: dastore
    //   197: invokestatic a : ([D)F
    //   200: fstore_2
    //   201: aload_0
    //   202: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   205: invokevirtual getAccuracy : ()F
    //   208: fstore_3
    //   209: aload_1
    //   210: invokevirtual getAccuracy : ()F
    //   213: fstore #4
    //   215: fload #4
    //   217: fload_3
    //   218: fsub
    //   219: fstore #5
    //   221: invokestatic b : ()J
    //   224: lstore #7
    //   226: aload_0
    //   227: getfield d : J
    //   230: lstore #9
    //   232: fload_3
    //   233: ldc 101.0
    //   235: fcmpg
    //   236: ifge -> 247
    //   239: fload #4
    //   241: ldc 299.0
    //   243: fcmpl
    //   244: ifgt -> 266
    //   247: fload_3
    //   248: ldc 299.0
    //   250: fcmpl
    //   251: istore #6
    //   253: iload #6
    //   255: ifle -> 324
    //   258: fload #4
    //   260: ldc 299.0
    //   262: fcmpl
    //   263: ifle -> 324
    //   266: aload_0
    //   267: getfield e : J
    //   270: lstore #9
    //   272: lload #9
    //   274: lconst_0
    //   275: lcmp
    //   276: ifne -> 288
    //   279: aload_0
    //   280: lload #7
    //   282: putfield e : J
    //   285: goto -> 319
    //   288: lload #7
    //   290: lload #9
    //   292: lsub
    //   293: ldc2_w 30000
    //   296: lcmp
    //   297: ifle -> 319
    //   300: aload_0
    //   301: lload #7
    //   303: putfield d : J
    //   306: aload_0
    //   307: aload_1
    //   308: putfield c : Lcom/amap/api/mapcore2d/gg;
    //   311: aload_0
    //   312: lconst_0
    //   313: putfield e : J
    //   316: goto -> 27
    //   319: aload_0
    //   320: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   323: areturn
    //   324: fload #4
    //   326: ldc 101.0
    //   328: fcmpg
    //   329: ifge -> 340
    //   332: iload #6
    //   334: ifle -> 340
    //   337: goto -> 300
    //   340: fload #4
    //   342: ldc 299.0
    //   344: fcmpg
    //   345: ifgt -> 353
    //   348: aload_0
    //   349: lconst_0
    //   350: putfield e : J
    //   353: fload_2
    //   354: ldc 10.0
    //   356: fcmpg
    //   357: ifge -> 413
    //   360: fload_2
    //   361: f2d
    //   362: ldc2_w 0.1
    //   365: dcmpl
    //   366: ifle -> 413
    //   369: fload #4
    //   371: ldc 5.0
    //   373: fcmpl
    //   374: ifle -> 413
    //   377: fload #5
    //   379: ldc -300.0
    //   381: fcmpl
    //   382: iflt -> 390
    //   385: aload_0
    //   386: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   389: areturn
    //   390: fload_3
    //   391: fload #4
    //   393: fdiv
    //   394: fconst_2
    //   395: fcmpl
    //   396: iflt -> 408
    //   399: aload_0
    //   400: lload #7
    //   402: putfield d : J
    //   405: goto -> 105
    //   408: aload_0
    //   409: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   412: areturn
    //   413: fload #5
    //   415: ldc 300.0
    //   417: fcmpl
    //   418: iflt -> 98
    //   421: lload #7
    //   423: lload #9
    //   425: lsub
    //   426: ldc2_w 30000
    //   429: lcmp
    //   430: iflt -> 436
    //   433: goto -> 98
    //   436: aload_0
    //   437: getfield c : Lcom/amap/api/mapcore2d/gg;
    //   440: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */