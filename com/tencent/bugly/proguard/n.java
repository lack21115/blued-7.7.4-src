package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n {
  public static final long a = System.currentTimeMillis();
  
  private static n b;
  
  private Context c;
  
  private String d;
  
  private Map<Integer, Map<String, m>> e;
  
  private SharedPreferences f;
  
  private n(Context paramContext) {
    this.c = paramContext;
    this.e = new HashMap<Integer, Map<String, m>>();
    this.d = (a.b()).d;
    this.f = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static n a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/proguard/n
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/proguard/n
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static n a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/n
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/proguard/n
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   20: getstatic com/tencent/bugly/proguard/n.b : Lcom/tencent/bugly/proguard/n;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/proguard/n
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/proguard/n
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private <T extends List<?>> void a(int paramInt, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield c : Landroid/content/Context;
    //   13: ldc 'crashrecord'
    //   15: iconst_0
    //   16: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   19: astore_3
    //   20: new java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: astore #4
    //   29: aload #4
    //   31: iload_1
    //   32: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new java/io/File
    //   39: dup
    //   40: aload_3
    //   41: aload #4
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   49: astore #4
    //   51: aconst_null
    //   52: astore #5
    //   54: aconst_null
    //   55: astore_3
    //   56: new java/io/ObjectOutputStream
    //   59: dup
    //   60: new java/io/FileOutputStream
    //   63: dup
    //   64: aload #4
    //   66: invokespecial <init> : (Ljava/io/File;)V
    //   69: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   72: astore #4
    //   74: aload #4
    //   76: aload_2
    //   77: invokevirtual writeObject : (Ljava/lang/Object;)V
    //   80: aload #4
    //   82: invokevirtual close : ()V
    //   85: goto -> 171
    //   88: astore_2
    //   89: aload #4
    //   91: astore_3
    //   92: goto -> 147
    //   95: astore_3
    //   96: aload #4
    //   98: astore_2
    //   99: aload_3
    //   100: astore #4
    //   102: goto -> 114
    //   105: astore_2
    //   106: goto -> 147
    //   109: astore #4
    //   111: aload #5
    //   113: astore_2
    //   114: aload_2
    //   115: astore_3
    //   116: aload #4
    //   118: invokevirtual printStackTrace : ()V
    //   121: aload_2
    //   122: astore_3
    //   123: ldc 'open record file error'
    //   125: iconst_0
    //   126: anewarray java/lang/Object
    //   129: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   132: pop
    //   133: aload_2
    //   134: ifnull -> 144
    //   137: aload_2
    //   138: invokevirtual close : ()V
    //   141: goto -> 171
    //   144: aload_0
    //   145: monitorexit
    //   146: return
    //   147: aload_3
    //   148: ifnull -> 155
    //   151: aload_3
    //   152: invokevirtual close : ()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: goto -> 174
    //   161: ldc 'writeCrashRecord error'
    //   163: iconst_0
    //   164: anewarray java/lang/Object
    //   167: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   170: pop
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_2
    //   177: athrow
    //   178: astore_2
    //   179: goto -> 161
    // Exception table:
    //   from	to	target	type
    //   9	51	178	java/lang/Exception
    //   9	51	157	finally
    //   56	74	109	java/io/IOException
    //   56	74	105	finally
    //   74	80	95	java/io/IOException
    //   74	80	88	finally
    //   80	85	178	java/lang/Exception
    //   80	85	157	finally
    //   116	121	105	finally
    //   123	133	105	finally
    //   137	141	178	java/lang/Exception
    //   137	141	157	finally
    //   151	155	178	java/lang/Exception
    //   151	155	157	finally
    //   155	157	178	java/lang/Exception
    //   155	157	157	finally
    //   161	171	157	finally
  }
  
  private boolean b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial c : (I)Ljava/util/List;
    //   7: astore #4
    //   9: aload #4
    //   11: ifnonnull -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic currentTimeMillis : ()J
    //   21: lstore_2
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore #5
    //   31: new java/util/ArrayList
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #6
    //   40: aload #4
    //   42: invokeinterface iterator : ()Ljava/util/Iterator;
    //   47: astore #7
    //   49: aload #7
    //   51: invokeinterface hasNext : ()Z
    //   56: ifeq -> 139
    //   59: aload #7
    //   61: invokeinterface next : ()Ljava/lang/Object;
    //   66: checkcast com/tencent/bugly/proguard/m
    //   69: astore #8
    //   71: aload #8
    //   73: getfield b : Ljava/lang/String;
    //   76: ifnull -> 112
    //   79: aload #8
    //   81: getfield b : Ljava/lang/String;
    //   84: aload_0
    //   85: getfield d : Ljava/lang/String;
    //   88: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   91: ifeq -> 112
    //   94: aload #8
    //   96: getfield d : I
    //   99: ifle -> 112
    //   102: aload #5
    //   104: aload #8
    //   106: invokeinterface add : (Ljava/lang/Object;)Z
    //   111: pop
    //   112: aload #8
    //   114: getfield c : J
    //   117: ldc2_w 86400000
    //   120: ladd
    //   121: lload_2
    //   122: lcmp
    //   123: ifge -> 49
    //   126: aload #6
    //   128: aload #8
    //   130: invokeinterface add : (Ljava/lang/Object;)Z
    //   135: pop
    //   136: goto -> 49
    //   139: aload #5
    //   141: invokestatic sort : (Ljava/util/List;)V
    //   144: aload #5
    //   146: invokeinterface size : ()I
    //   151: iconst_2
    //   152: if_icmplt -> 218
    //   155: aload #5
    //   157: invokeinterface size : ()I
    //   162: ifle -> 214
    //   165: aload #5
    //   167: aload #5
    //   169: invokeinterface size : ()I
    //   174: iconst_1
    //   175: isub
    //   176: invokeinterface get : (I)Ljava/lang/Object;
    //   181: checkcast com/tencent/bugly/proguard/m
    //   184: getfield c : J
    //   187: ldc2_w 86400000
    //   190: ladd
    //   191: lload_2
    //   192: lcmp
    //   193: ifge -> 214
    //   196: aload #4
    //   198: invokeinterface clear : ()V
    //   203: aload_0
    //   204: iload_1
    //   205: aload #4
    //   207: invokespecial a : (ILjava/util/List;)V
    //   210: aload_0
    //   211: monitorexit
    //   212: iconst_0
    //   213: ireturn
    //   214: aload_0
    //   215: monitorexit
    //   216: iconst_1
    //   217: ireturn
    //   218: aload #4
    //   220: aload #6
    //   222: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   227: pop
    //   228: aload_0
    //   229: iload_1
    //   230: aload #4
    //   232: invokespecial a : (ILjava/util/List;)V
    //   235: aload_0
    //   236: monitorexit
    //   237: iconst_0
    //   238: ireturn
    //   239: astore #4
    //   241: goto -> 258
    //   244: ldc 'isFrequentCrash failed'
    //   246: iconst_0
    //   247: anewarray java/lang/Object
    //   250: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   253: pop
    //   254: aload_0
    //   255: monitorexit
    //   256: iconst_0
    //   257: ireturn
    //   258: aload_0
    //   259: monitorexit
    //   260: aload #4
    //   262: athrow
    //   263: astore #4
    //   265: goto -> 244
    // Exception table:
    //   from	to	target	type
    //   2	9	263	java/lang/Exception
    //   2	9	239	finally
    //   18	49	263	java/lang/Exception
    //   18	49	239	finally
    //   49	112	263	java/lang/Exception
    //   49	112	239	finally
    //   112	136	263	java/lang/Exception
    //   112	136	239	finally
    //   139	210	263	java/lang/Exception
    //   139	210	239	finally
    //   218	235	263	java/lang/Exception
    //   218	235	239	finally
    //   244	254	239	finally
  }
  
  private <T extends List<?>> T c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Landroid/content/Context;
    //   6: ldc 'crashrecord'
    //   8: iconst_0
    //   9: invokevirtual getDir : (Ljava/lang/String;I)Ljava/io/File;
    //   12: astore_3
    //   13: new java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aload #4
    //   24: iload_1
    //   25: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new java/io/File
    //   32: dup
    //   33: aload_3
    //   34: aload #4
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual exists : ()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne -> 56
    //   52: aload_0
    //   53: monitorexit
    //   54: aconst_null
    //   55: areturn
    //   56: new java/io/ObjectInputStream
    //   59: dup
    //   60: new java/io/FileInputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial <init> : (Ljava/io/File;)V
    //   68: invokespecial <init> : (Ljava/io/InputStream;)V
    //   71: astore #4
    //   73: aload #4
    //   75: astore_3
    //   76: aload #4
    //   78: invokevirtual readObject : ()Ljava/lang/Object;
    //   81: checkcast java/util/List
    //   84: astore #5
    //   86: aload #4
    //   88: invokevirtual close : ()V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload #5
    //   95: areturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore #4
    //   100: goto -> 164
    //   103: aconst_null
    //   104: astore #4
    //   106: aload #4
    //   108: astore_3
    //   109: ldc 'get object error'
    //   111: iconst_0
    //   112: anewarray java/lang/Object
    //   115: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload #4
    //   121: ifnull -> 190
    //   124: aload #4
    //   126: invokevirtual close : ()V
    //   129: goto -> 190
    //   132: aconst_null
    //   133: astore #4
    //   135: aload #4
    //   137: astore_3
    //   138: ldc 'open record file error'
    //   140: iconst_0
    //   141: anewarray java/lang/Object
    //   144: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload #4
    //   150: ifnull -> 190
    //   153: goto -> 124
    //   156: astore #5
    //   158: aload_3
    //   159: astore #4
    //   161: aload #5
    //   163: astore_3
    //   164: aload #4
    //   166: ifnull -> 174
    //   169: aload #4
    //   171: invokevirtual close : ()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto -> 194
    //   180: ldc 'readCrashRecord error'
    //   182: iconst_0
    //   183: anewarray java/lang/Object
    //   186: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: monitorexit
    //   192: aconst_null
    //   193: areturn
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: goto -> 180
    //   202: astore_3
    //   203: goto -> 132
    //   206: astore_3
    //   207: goto -> 103
    //   210: astore_3
    //   211: goto -> 135
    //   214: astore_3
    //   215: goto -> 106
    // Exception table:
    //   from	to	target	type
    //   2	48	198	java/lang/Exception
    //   2	48	176	finally
    //   56	73	202	java/io/IOException
    //   56	73	206	java/lang/ClassNotFoundException
    //   56	73	96	finally
    //   76	86	210	java/io/IOException
    //   76	86	214	java/lang/ClassNotFoundException
    //   76	86	156	finally
    //   86	91	198	java/lang/Exception
    //   86	91	176	finally
    //   109	119	156	finally
    //   124	129	198	java/lang/Exception
    //   124	129	176	finally
    //   138	148	156	finally
    //   169	174	198	java/lang/Exception
    //   169	174	176	finally
    //   174	176	198	java/lang/Exception
    //   174	176	176	finally
    //   180	190	176	finally
  }
  
  public final void a(int paramInt1, int paramInt2) {
    w.a().a(new Runnable(this, 1004, paramInt2) {
          public final void run() {
            try {
              Object object;
              boolean bool1;
              m m;
              if (TextUtils.isEmpty(n.a(this.c)))
                return; 
              List<m> list2 = n.a(this.c, this.a);
              List<m> list1 = list2;
              if (list2 == null)
                list1 = new ArrayList(); 
              if (n.b(this.c).get(Integer.valueOf(this.a)) == null) {
                HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
                n.b(this.c).put(Integer.valueOf(this.a), hashMap);
              } 
              if (((Map)n.b(this.c).get(Integer.valueOf(this.a))).get(n.a(this.c)) == null) {
                m = new m();
                m.a = this.a;
                m.g = n.a;
                m.b = n.a(this.c);
                m.f = (a.b()).k;
                m.e = (a.b()).f;
                m.c = System.currentTimeMillis();
                m.d = this.b;
                ((Map<String, m>)n.b(this.c).get(Integer.valueOf(this.a))).put(n.a(this.c), m);
              } else {
                m = (m)((Map)n.b(this.c).get(Integer.valueOf(this.a))).get(n.a(this.c));
                m.d = this.b;
              } 
              ArrayList<Object> arrayList = new ArrayList();
              Iterator<m> iterator = list1.iterator();
              boolean bool2 = false;
              while (iterator.hasNext()) {
                boolean bool;
                m m1 = iterator.next();
                Object object1 = object;
                if (m1.g == m.g) {
                  object1 = object;
                  if (m1.b != null) {
                    object1 = object;
                    if (m1.b.equalsIgnoreCase(m.b)) {
                      bool = true;
                      m1.d = m.d;
                    } 
                  } 
                } 
                if ((m1.e == null || m1.e.equalsIgnoreCase(m.e)) && (m1.f == null || m1.f.equalsIgnoreCase(m.f))) {
                  bool1 = bool;
                  if (m1.d <= 0)
                    continue; 
                  continue;
                } 
                continue;
                arrayList.add(SYNTHETIC_LOCAL_VARIABLE_7);
                object = SYNTHETIC_LOCAL_VARIABLE_2;
              } 
              list1.removeAll(arrayList);
              if (!bool1)
                list1.add(m); 
              n.a(this.c, this.a, list1);
              return;
            } catch (Exception exception) {
              x.e("saveCrashRecord failed", new Object[0]);
              return;
            } 
          }
        });
  }
  
  public final boolean a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield f : Landroid/content/SharedPreferences;
    //   10: astore #4
    //   12: iload_3
    //   13: istore_2
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #5
    //   23: iload_3
    //   24: istore_2
    //   25: aload #5
    //   27: iload_1
    //   28: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: iload_3
    //   33: istore_2
    //   34: aload #5
    //   36: ldc '_'
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: iload_3
    //   43: istore_2
    //   44: aload #5
    //   46: aload_0
    //   47: getfield d : Ljava/lang/String;
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: iload_3
    //   55: istore_2
    //   56: aload #4
    //   58: aload #5
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: iconst_1
    //   64: invokeinterface getBoolean : (Ljava/lang/String;Z)Z
    //   69: istore_3
    //   70: iload_3
    //   71: istore_2
    //   72: invokestatic a : ()Lcom/tencent/bugly/proguard/w;
    //   75: new com/tencent/bugly/proguard/n$2
    //   78: dup
    //   79: aload_0
    //   80: iload_1
    //   81: invokespecial <init> : (Lcom/tencent/bugly/proguard/n;I)V
    //   84: invokevirtual a : (Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_3
    //   91: ireturn
    //   92: astore #4
    //   94: goto -> 111
    //   97: ldc 'canInit error'
    //   99: iconst_0
    //   100: anewarray java/lang/Object
    //   103: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_2
    //   110: ireturn
    //   111: aload_0
    //   112: monitorexit
    //   113: aload #4
    //   115: athrow
    //   116: astore #4
    //   118: goto -> 97
    // Exception table:
    //   from	to	target	type
    //   6	12	116	java/lang/Exception
    //   6	12	92	finally
    //   14	23	116	java/lang/Exception
    //   14	23	92	finally
    //   25	32	116	java/lang/Exception
    //   25	32	92	finally
    //   34	42	116	java/lang/Exception
    //   34	42	92	finally
    //   44	54	116	java/lang/Exception
    //   44	54	92	finally
    //   56	70	116	java/lang/Exception
    //   56	70	92	finally
    //   72	88	116	java/lang/Exception
    //   72	88	92	finally
    //   97	107	92	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */