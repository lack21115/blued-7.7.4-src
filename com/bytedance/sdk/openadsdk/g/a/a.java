package com.bytedance.sdk.openadsdk.g.a;

import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.o;
import java.io.File;
import java.util.WeakHashMap;

public class a {
  private static String a;
  
  private static volatile a e;
  
  private WeakHashMap<String, String> b = new WeakHashMap<String, String>();
  
  private final com.bytedance.sdk.openadsdk.b.a c = (com.bytedance.sdk.openadsdk.b.a)new d();
  
  private final LruCache<String, a> d = new LruCache<String, a>(this, 5242880) {
      protected int a(String param1String, a.a param1a) {
        byte[] arrayOfByte = param1a.a;
        int i = 0;
        if (arrayOfByte != null)
          i = 0 + param1a.a.length; 
        int j = i;
        if (i == 0)
          j = super.sizeOf(param1String, param1a); 
        return j;
      }
      
      protected void a(boolean param1Boolean, String param1String, a.a param1a1, a.a param1a2) {
        super.entryRemoved(param1Boolean, param1String, param1a1, param1a2);
        if (param1Boolean && param1a1 != null)
          param1a1.a = null; 
      }
    };
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/g/a/a.e : Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/g/a/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/g/a/a.e : Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/g/a/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/g/a/a.e : Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   25: ldc com/bytedance/sdk/openadsdk/g/a/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/g/a/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/g/a/a.e : Lcom/bytedance/sdk/openadsdk/g/a/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private boolean a(byte[] paramArrayOfbyte) {
    return (paramArrayOfbyte != null && paramArrayOfbyte.length >= 3 && paramArrayOfbyte[0] == 71 && paramArrayOfbyte[1] == 73 && paramArrayOfbyte[2] == 70);
  }
  
  private static String b() {
    if (TextUtils.isEmpty(a)) {
      File file = new File(com.bytedance.sdk.adnet.a.b(o.a()), "diskGif");
      file.mkdirs();
      a = file.getAbsolutePath();
    } 
    return a;
  }
  
  public File a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: new java/io/File
    //   18: dup
    //   19: invokestatic b : ()Ljava/lang/String;
    //   22: aload_1
    //   23: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual exists : ()Z
    //   31: ifeq -> 49
    //   34: aload_1
    //   35: invokevirtual length : ()J
    //   38: lstore_3
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle -> 49
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aload_0
    //   50: monitorexit
    //   51: aconst_null
    //   52: areturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	53	finally
    //   15	39	53	finally
  }
  
  public String a(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore #5
    //   8: iload #5
    //   10: ifeq -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: aconst_null
    //   16: areturn
    //   17: aload_1
    //   18: astore #4
    //   20: aload_1
    //   21: ldc 'https'
    //   23: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   26: ifeq -> 39
    //   29: aload_1
    //   30: ldc 'https'
    //   32: ldc 'http'
    //   34: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore #4
    //   39: aload_0
    //   40: getfield b : Ljava/util/WeakHashMap;
    //   43: aload #4
    //   45: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast java/lang/String
    //   51: astore_1
    //   52: aload_1
    //   53: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   56: istore #5
    //   58: iload #5
    //   60: ifne -> 67
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: areturn
    //   67: aload #4
    //   69: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield b : Ljava/util/WeakHashMap;
    //   77: aload #4
    //   79: aload_1
    //   80: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: areturn
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	88	finally
    //   20	39	88	finally
    //   39	58	88	finally
    //   67	84	88	finally
  }
  
  public void a(String paramString, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 262
    //   9: aload_2
    //   10: ifnonnull -> 16
    //   13: goto -> 262
    //   16: aload_0
    //   17: aload_2
    //   18: invokespecial a : ([B)Z
    //   21: istore_3
    //   22: iload_3
    //   23: ifne -> 57
    //   26: aload_0
    //   27: getfield d : Landroid/util/LruCache;
    //   30: aload_1
    //   31: new com/bytedance/sdk/openadsdk/g/a/a$a
    //   34: dup
    //   35: aload_2
    //   36: invokespecial <init> : ([B)V
    //   39: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: goto -> 57
    //   46: astore #6
    //   48: ldc 'GifCache'
    //   50: ldc 'gifCache mLruCache.put error '
    //   52: aload #6
    //   54: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: new java/io/File
    //   60: dup
    //   61: invokestatic b : ()Ljava/lang/String;
    //   64: aload_1
    //   65: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   68: astore #6
    //   70: aload #6
    //   72: invokevirtual exists : ()Z
    //   75: ifeq -> 103
    //   78: aload #6
    //   80: invokevirtual isFile : ()Z
    //   83: ifeq -> 103
    //   86: aload #6
    //   88: invokevirtual length : ()J
    //   91: lstore #4
    //   93: lload #4
    //   95: lconst_0
    //   96: lcmp
    //   97: ifle -> 103
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: new java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore_1
    //   111: aload_1
    //   112: aload #6
    //   114: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: ldc '.tmp'
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: new java/io/File
    //   128: dup
    //   129: aload_1
    //   130: invokevirtual toString : ()Ljava/lang/String;
    //   133: invokespecial <init> : (Ljava/lang/String;)V
    //   136: astore #7
    //   138: aload #7
    //   140: invokevirtual delete : ()Z
    //   143: pop
    //   144: aload #7
    //   146: invokevirtual createNewFile : ()Z
    //   149: pop
    //   150: new java/io/FileOutputStream
    //   153: dup
    //   154: aload #7
    //   156: invokespecial <init> : (Ljava/io/File;)V
    //   159: astore_1
    //   160: aload_1
    //   161: aload_2
    //   162: invokevirtual write : ([B)V
    //   165: aload_1
    //   166: invokevirtual flush : ()V
    //   169: aload #7
    //   171: invokevirtual exists : ()Z
    //   174: ifeq -> 209
    //   177: aload #7
    //   179: invokevirtual length : ()J
    //   182: lconst_0
    //   183: lcmp
    //   184: ifle -> 209
    //   187: aload #6
    //   189: invokevirtual exists : ()Z
    //   192: ifeq -> 201
    //   195: aload #6
    //   197: invokevirtual delete : ()Z
    //   200: pop
    //   201: aload #7
    //   203: aload #6
    //   205: invokevirtual renameTo : (Ljava/io/File;)Z
    //   208: pop
    //   209: aload_0
    //   210: getfield c : Lcom/bytedance/sdk/openadsdk/b/a;
    //   213: aload #6
    //   215: invokeinterface a : (Ljava/io/File;)V
    //   220: aload_1
    //   221: invokevirtual close : ()V
    //   224: goto -> 248
    //   227: aconst_null
    //   228: astore_1
    //   229: aload #7
    //   231: invokevirtual delete : ()Z
    //   234: pop
    //   235: aload #6
    //   237: invokevirtual delete : ()Z
    //   240: pop
    //   241: aload_1
    //   242: ifnull -> 248
    //   245: goto -> 220
    //   248: aload_0
    //   249: monitorexit
    //   250: return
    //   251: astore_2
    //   252: aload_1
    //   253: ifnull -> 260
    //   256: aload_1
    //   257: invokevirtual close : ()V
    //   260: aload_2
    //   261: athrow
    //   262: aload_0
    //   263: monitorexit
    //   264: return
    //   265: astore_1
    //   266: aload_0
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: goto -> 227
    //   274: astore_2
    //   275: goto -> 229
    //   278: astore_1
    //   279: goto -> 248
    //   282: astore_1
    //   283: goto -> 260
    // Exception table:
    //   from	to	target	type
    //   2	9	265	finally
    //   16	22	265	finally
    //   26	43	46	finally
    //   48	57	265	finally
    //   57	93	265	finally
    //   103	144	265	finally
    //   144	160	270	finally
    //   160	201	274	finally
    //   201	209	274	finally
    //   209	220	274	finally
    //   220	224	278	java/io/IOException
    //   220	224	265	finally
    //   229	241	251	finally
    //   256	260	282	java/io/IOException
    //   256	260	265	finally
    //   260	262	265	finally
  }
  
  public a b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: aload_0
    //   16: getfield d : Landroid/util/LruCache;
    //   19: aload_1
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/bytedance/sdk/openadsdk/g/a/a$a
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 35
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: areturn
    //   35: new java/io/File
    //   38: dup
    //   39: invokestatic b : ()Ljava/lang/String;
    //   42: aload_1
    //   43: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: astore #4
    //   48: aload #4
    //   50: invokevirtual exists : ()Z
    //   53: istore_2
    //   54: iload_2
    //   55: ifeq -> 210
    //   58: new java/io/FileInputStream
    //   61: dup
    //   62: aload #4
    //   64: invokespecial <init> : (Ljava/io/File;)V
    //   67: astore_3
    //   68: aload #4
    //   70: invokevirtual length : ()J
    //   73: invokestatic valueOf : (J)Ljava/lang/Long;
    //   76: invokevirtual intValue : ()I
    //   79: invokestatic allocate : (I)Ljava/nio/ByteBuffer;
    //   82: astore #4
    //   84: aload_3
    //   85: invokevirtual getChannel : ()Ljava/nio/channels/FileChannel;
    //   88: aload #4
    //   90: invokevirtual read : (Ljava/nio/ByteBuffer;)I
    //   93: pop
    //   94: aload #4
    //   96: invokevirtual array : ()[B
    //   99: astore #5
    //   101: new com/bytedance/sdk/openadsdk/g/a/a$a
    //   104: dup
    //   105: aload #5
    //   107: invokespecial <init> : ([B)V
    //   110: astore #4
    //   112: aload_3
    //   113: invokevirtual close : ()V
    //   116: aload_0
    //   117: monitorexit
    //   118: aload #4
    //   120: areturn
    //   121: aload_3
    //   122: astore #4
    //   124: aload #5
    //   126: ifnull -> 160
    //   129: new com/bytedance/sdk/openadsdk/g/a/a$a
    //   132: dup
    //   133: aload #5
    //   135: invokespecial <init> : ([B)V
    //   138: astore #4
    //   140: aload_0
    //   141: getfield d : Landroid/util/LruCache;
    //   144: aload_1
    //   145: aload #4
    //   147: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   150: pop
    //   151: aload_3
    //   152: invokevirtual close : ()V
    //   155: aload_0
    //   156: monitorexit
    //   157: aload #4
    //   159: areturn
    //   160: aload #4
    //   162: invokevirtual close : ()V
    //   165: goto -> 210
    //   168: astore #4
    //   170: aload_3
    //   171: astore_1
    //   172: aload #4
    //   174: astore_3
    //   175: goto -> 181
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_1
    //   181: ldc 'GifCache'
    //   183: ldc 'gifCache get error '
    //   185: aload_3
    //   186: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload_1
    //   190: ifnull -> 210
    //   193: aload_1
    //   194: astore #4
    //   196: goto -> 160
    //   199: astore_3
    //   200: aload_1
    //   201: ifnull -> 208
    //   204: aload_1
    //   205: invokevirtual close : ()V
    //   208: aload_3
    //   209: athrow
    //   210: aload_0
    //   211: monitorexit
    //   212: aconst_null
    //   213: areturn
    //   214: astore_1
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: astore #4
    //   221: goto -> 121
    //   224: astore_1
    //   225: goto -> 116
    //   228: astore_1
    //   229: goto -> 155
    //   232: astore_1
    //   233: goto -> 210
    //   236: astore_1
    //   237: goto -> 208
    // Exception table:
    //   from	to	target	type
    //   2	7	214	finally
    //   15	27	214	finally
    //   35	54	214	finally
    //   58	68	178	finally
    //   68	101	168	finally
    //   101	112	219	finally
    //   112	116	224	java/io/IOException
    //   112	116	214	finally
    //   129	151	168	finally
    //   151	155	228	java/io/IOException
    //   151	155	214	finally
    //   160	165	232	java/io/IOException
    //   160	165	214	finally
    //   181	189	199	finally
    //   204	208	236	java/io/IOException
    //   204	208	214	finally
    //   208	210	214	finally
  }
  
  public static class a {
    byte[] a;
    
    public a(byte[] param1ArrayOfbyte) {
      this.a = param1ArrayOfbyte;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\g\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */