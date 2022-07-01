package a.a.a.a.a.k.d;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  public long a = 0L;
  
  public long b = 0L;
  
  public long c = 0L;
  
  public long d = 0L;
  
  public Context e;
  
  public boolean f = false;
  
  public String g = null;
  
  public static String a(Context paramContext, String paramString, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual openFileInput : (Ljava/lang/String;)Ljava/io/FileInputStream;
    //   5: astore_0
    //   6: new java/io/BufferedReader
    //   9: dup
    //   10: new java/io/InputStreamReader
    //   13: dup
    //   14: aload_0
    //   15: invokespecial <init> : (Ljava/io/InputStream;)V
    //   18: invokespecial <init> : (Ljava/io/Reader;)V
    //   21: astore #6
    //   23: aload_0
    //   24: astore_1
    //   25: aload #6
    //   27: astore #5
    //   29: aload #6
    //   31: lload_2
    //   32: invokevirtual skip : (J)J
    //   35: pop2
    //   36: aload_0
    //   37: astore_1
    //   38: aload #6
    //   40: astore #5
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore #7
    //   51: aload_0
    //   52: astore_1
    //   53: aload #6
    //   55: astore #5
    //   57: aload #6
    //   59: invokevirtual readLine : ()Ljava/lang/String;
    //   62: astore #8
    //   64: aload #8
    //   66: ifnull -> 100
    //   69: aload_0
    //   70: astore_1
    //   71: aload #6
    //   73: astore #5
    //   75: aload #7
    //   77: aload #8
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: astore_1
    //   85: aload #6
    //   87: astore #5
    //   89: aload #7
    //   91: ldc '\\n'
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: goto -> 51
    //   100: aload_0
    //   101: astore_1
    //   102: aload #6
    //   104: astore #5
    //   106: aload #7
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: astore #7
    //   113: aload_0
    //   114: astore_1
    //   115: aload #6
    //   117: astore #5
    //   119: ldc ''
    //   121: aload #7
    //   123: invokevirtual equals : (Ljava/lang/Object;)Z
    //   126: istore #4
    //   128: iload #4
    //   130: ifeq -> 144
    //   133: aload_0
    //   134: invokestatic a : (Ljava/io/Closeable;)V
    //   137: aload #6
    //   139: invokestatic a : (Ljava/io/Closeable;)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload_0
    //   145: invokestatic a : (Ljava/io/Closeable;)V
    //   148: aload #6
    //   150: invokestatic a : (Ljava/io/Closeable;)V
    //   153: aload #7
    //   155: areturn
    //   156: astore #7
    //   158: goto -> 202
    //   161: astore #7
    //   163: goto -> 216
    //   166: astore #5
    //   168: aload_0
    //   169: astore_1
    //   170: aload #5
    //   172: astore_0
    //   173: goto -> 187
    //   176: astore_1
    //   177: goto -> 196
    //   180: astore_1
    //   181: goto -> 273
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_1
    //   187: aconst_null
    //   188: astore #5
    //   190: goto -> 231
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_0
    //   196: aconst_null
    //   197: astore #6
    //   199: aload_1
    //   200: astore #7
    //   202: aload_0
    //   203: astore_1
    //   204: aload #6
    //   206: astore #5
    //   208: aload #7
    //   210: invokevirtual printStackTrace : ()V
    //   213: goto -> 247
    //   216: aload_0
    //   217: astore_1
    //   218: aload #6
    //   220: astore #5
    //   222: aload #7
    //   224: invokevirtual printStackTrace : ()V
    //   227: goto -> 247
    //   230: astore_0
    //   231: aload_1
    //   232: invokestatic a : (Ljava/io/Closeable;)V
    //   235: aload #5
    //   237: invokestatic a : (Ljava/io/Closeable;)V
    //   240: aload_0
    //   241: athrow
    //   242: aconst_null
    //   243: astore_0
    //   244: aconst_null
    //   245: astore #6
    //   247: aload_0
    //   248: invokestatic a : (Ljava/io/Closeable;)V
    //   251: aload #6
    //   253: invokestatic a : (Ljava/io/Closeable;)V
    //   256: aconst_null
    //   257: areturn
    //   258: astore_0
    //   259: goto -> 242
    //   262: astore_1
    //   263: goto -> 244
    //   266: astore_1
    //   267: goto -> 247
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: aconst_null
    //   274: astore #6
    //   276: aload_1
    //   277: astore #7
    //   279: goto -> 216
    // Exception table:
    //   from	to	target	type
    //   0	6	258	java/io/FileNotFoundException
    //   0	6	270	java/io/IOException
    //   0	6	193	java/lang/OutOfMemoryError
    //   0	6	184	finally
    //   6	23	262	java/io/FileNotFoundException
    //   6	23	180	java/io/IOException
    //   6	23	176	java/lang/OutOfMemoryError
    //   6	23	166	finally
    //   29	36	266	java/io/FileNotFoundException
    //   29	36	161	java/io/IOException
    //   29	36	156	java/lang/OutOfMemoryError
    //   29	36	230	finally
    //   42	51	266	java/io/FileNotFoundException
    //   42	51	161	java/io/IOException
    //   42	51	156	java/lang/OutOfMemoryError
    //   42	51	230	finally
    //   57	64	266	java/io/FileNotFoundException
    //   57	64	161	java/io/IOException
    //   57	64	156	java/lang/OutOfMemoryError
    //   57	64	230	finally
    //   75	83	266	java/io/FileNotFoundException
    //   75	83	161	java/io/IOException
    //   75	83	156	java/lang/OutOfMemoryError
    //   75	83	230	finally
    //   89	97	266	java/io/FileNotFoundException
    //   89	97	161	java/io/IOException
    //   89	97	156	java/lang/OutOfMemoryError
    //   89	97	230	finally
    //   106	113	266	java/io/FileNotFoundException
    //   106	113	161	java/io/IOException
    //   106	113	156	java/lang/OutOfMemoryError
    //   106	113	230	finally
    //   119	128	266	java/io/FileNotFoundException
    //   119	128	161	java/io/IOException
    //   119	128	156	java/lang/OutOfMemoryError
    //   119	128	230	finally
    //   208	213	230	finally
    //   222	227	230	finally
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable == null)
      return; 
    try {
      paramCloseable.close();
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #6
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore #7
    //   9: aconst_null
    //   10: astore #4
    //   12: aload_0
    //   13: aload_1
    //   14: iload_3
    //   15: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   18: astore_0
    //   19: new java/io/BufferedWriter
    //   22: dup
    //   23: new java/io/OutputStreamWriter
    //   26: dup
    //   27: aload_0
    //   28: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   31: invokespecial <init> : (Ljava/io/Writer;)V
    //   34: astore_1
    //   35: aload_1
    //   36: aload_2
    //   37: invokevirtual write : (Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual close : ()V
    //   44: aload_0
    //   45: invokestatic a : (Ljava/io/Closeable;)V
    //   48: aload_1
    //   49: invokestatic a : (Ljava/io/Closeable;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: astore #5
    //   56: aload_1
    //   57: astore_2
    //   58: aload_0
    //   59: astore #4
    //   61: aload #5
    //   63: astore_0
    //   64: goto -> 152
    //   67: astore #5
    //   69: goto -> 125
    //   72: astore #5
    //   74: goto -> 138
    //   77: goto -> 168
    //   80: astore_1
    //   81: aload #5
    //   83: astore_2
    //   84: aload_0
    //   85: astore #4
    //   87: aload_1
    //   88: astore_0
    //   89: goto -> 152
    //   92: astore #5
    //   94: aload #4
    //   96: astore_1
    //   97: goto -> 125
    //   100: astore #5
    //   102: aload #6
    //   104: astore_1
    //   105: goto -> 138
    //   108: astore_0
    //   109: aconst_null
    //   110: astore #4
    //   112: aload #5
    //   114: astore_2
    //   115: goto -> 152
    //   118: astore #5
    //   120: aconst_null
    //   121: astore_0
    //   122: aload #4
    //   124: astore_1
    //   125: aload_1
    //   126: astore_2
    //   127: aload_0
    //   128: astore #4
    //   130: aload #5
    //   132: invokevirtual printStackTrace : ()V
    //   135: goto -> 168
    //   138: aload_1
    //   139: astore_2
    //   140: aload_0
    //   141: astore #4
    //   143: aload #5
    //   145: invokevirtual printStackTrace : ()V
    //   148: goto -> 168
    //   151: astore_0
    //   152: aload #4
    //   154: invokestatic a : (Ljava/io/Closeable;)V
    //   157: aload_2
    //   158: invokestatic a : (Ljava/io/Closeable;)V
    //   161: aload_0
    //   162: athrow
    //   163: aconst_null
    //   164: astore_0
    //   165: aload #7
    //   167: astore_1
    //   168: aload_0
    //   169: invokestatic a : (Ljava/io/Closeable;)V
    //   172: aload_1
    //   173: invokestatic a : (Ljava/io/Closeable;)V
    //   176: iconst_0
    //   177: ireturn
    //   178: astore_0
    //   179: goto -> 163
    //   182: astore_1
    //   183: aload #7
    //   185: astore_1
    //   186: goto -> 168
    //   189: astore_2
    //   190: goto -> 77
    //   193: astore #5
    //   195: aconst_null
    //   196: astore_0
    //   197: aload #6
    //   199: astore_1
    //   200: goto -> 138
    // Exception table:
    //   from	to	target	type
    //   12	19	178	java/io/FileNotFoundException
    //   12	19	193	java/io/IOException
    //   12	19	118	java/lang/OutOfMemoryError
    //   12	19	108	finally
    //   19	35	182	java/io/FileNotFoundException
    //   19	35	100	java/io/IOException
    //   19	35	92	java/lang/OutOfMemoryError
    //   19	35	80	finally
    //   35	44	189	java/io/FileNotFoundException
    //   35	44	72	java/io/IOException
    //   35	44	67	java/lang/OutOfMemoryError
    //   35	44	54	finally
    //   130	135	151	finally
    //   143	148	151	finally
  }
  
  public void a() {
    if (!this.f)
      return; 
    String str = this.g;
    if (str != null) {
      a(this.e, "pili_qos_cache", str, 0);
      this.g = null;
    } 
    this.f = false;
  }
  
  public void a(Context paramContext) {
    if (this.f)
      return; 
    this.e = paramContext.getApplicationContext();
    f();
    if (d())
      this.g = a(paramContext, "pili_qos_cache", 0L); 
    this.f = true;
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Z
    //   4: ifne -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield c : J
    //   13: aload_0
    //   14: getfield a : J
    //   17: lsub
    //   18: ldc2_w 100
    //   21: lcmp
    //   22: ifle -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_0
    //   28: monitorenter
    //   29: new java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore #4
    //   38: aload #4
    //   40: ldc 'pili_qos_log.'
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_0
    //   49: getfield c : J
    //   52: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload #4
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: astore #4
    //   63: aload_0
    //   64: getfield e : Landroid/content/Context;
    //   67: aload #4
    //   69: aload_1
    //   70: ldc 32768
    //   72: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)Z
    //   75: ifne -> 82
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: getfield d : J
    //   86: aload_1
    //   87: invokevirtual length : ()I
    //   90: i2l
    //   91: ladd
    //   92: lstore_2
    //   93: aload_0
    //   94: lload_2
    //   95: putfield d : J
    //   98: lload_2
    //   99: ldc2_w 65536
    //   102: lcmp
    //   103: iflt -> 121
    //   106: aload_0
    //   107: aload_0
    //   108: getfield c : J
    //   111: lconst_1
    //   112: ladd
    //   113: putfield c : J
    //   116: aload_0
    //   117: lconst_0
    //   118: putfield d : J
    //   121: aload_0
    //   122: invokevirtual g : ()Z
    //   125: pop
    //   126: aload_0
    //   127: monitorexit
    //   128: iconst_1
    //   129: ireturn
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Exception table:
    //   from	to	target	type
    //   29	80	130	finally
    //   82	98	130	finally
    //   106	121	130	finally
    //   121	128	130	finally
    //   131	133	130	finally
  }
  
  public void b() {
    this.g = null;
    if (d())
      this.e.deleteFile("pili_qos_cache"); 
  }
  
  public String c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Z
    //   4: ifne -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield g : Ljava/lang/String;
    //   13: astore #4
    //   15: aload #4
    //   17: ifnull -> 23
    //   20: aload #4
    //   22: areturn
    //   23: aload_0
    //   24: getfield a : J
    //   27: aload_0
    //   28: getfield c : J
    //   31: lcmp
    //   32: ifne -> 49
    //   35: aload_0
    //   36: getfield b : J
    //   39: aload_0
    //   40: getfield d : J
    //   43: lcmp
    //   44: ifne -> 49
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield a : J
    //   55: aload_0
    //   56: getfield c : J
    //   59: lcmp
    //   60: ifge -> 245
    //   63: iconst_1
    //   64: istore_1
    //   65: goto -> 68
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #4
    //   77: aload #4
    //   79: ldc 'pili_qos_log.'
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload #4
    //   87: aload_0
    //   88: getfield a : J
    //   91: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #4
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: astore #4
    //   102: aload_0
    //   103: getfield e : Landroid/content/Context;
    //   106: aload #4
    //   108: aload_0
    //   109: getfield b : J
    //   112: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)Ljava/lang/String;
    //   115: astore #4
    //   117: aload_0
    //   118: aload #4
    //   120: putfield g : Ljava/lang/String;
    //   123: aload #4
    //   125: ifnonnull -> 132
    //   128: aload_0
    //   129: monitorexit
    //   130: aconst_null
    //   131: areturn
    //   132: aload_0
    //   133: aload_0
    //   134: getfield b : J
    //   137: aload #4
    //   139: invokevirtual length : ()I
    //   142: i2l
    //   143: ladd
    //   144: putfield b : J
    //   147: aload_0
    //   148: getfield a : J
    //   151: aload_0
    //   152: getfield c : J
    //   155: lcmp
    //   156: ifge -> 174
    //   159: aload_0
    //   160: aload_0
    //   161: getfield a : J
    //   164: lconst_1
    //   165: ladd
    //   166: putfield a : J
    //   169: aload_0
    //   170: lconst_0
    //   171: putfield b : J
    //   174: aload_0
    //   175: invokevirtual g : ()Z
    //   178: pop
    //   179: iload_1
    //   180: ifeq -> 231
    //   183: aload_0
    //   184: getfield a : J
    //   187: lstore_2
    //   188: aload_0
    //   189: getfield e : Landroid/content/Context;
    //   192: astore #4
    //   194: new java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial <init> : ()V
    //   201: astore #5
    //   203: aload #5
    //   205: ldc 'pili_qos_log.'
    //   207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload #5
    //   213: lload_2
    //   214: lconst_1
    //   215: lsub
    //   216: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload #4
    //   222: aload #5
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokevirtual deleteFile : (Ljava/lang/String;)Z
    //   230: pop
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_0
    //   234: getfield g : Ljava/lang/String;
    //   237: areturn
    //   238: astore #4
    //   240: aload_0
    //   241: monitorexit
    //   242: aload #4
    //   244: athrow
    //   245: iconst_0
    //   246: istore_1
    //   247: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   51	63	238	finally
    //   68	123	238	finally
    //   128	130	238	finally
    //   132	174	238	finally
    //   174	179	238	finally
    //   183	231	238	finally
    //   231	233	238	finally
    //   240	242	238	finally
  }
  
  public final boolean d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e.getFilesDir().getAbsolutePath());
    stringBuilder.append("/");
    stringBuilder.append("pili_qos_cache");
    return (new File(stringBuilder.toString())).exists();
  }
  
  public final void e() {
    for (String str : this.e.fileList()) {
      if (str.startsWith("pili_qos_"))
        this.e.deleteFile(str); 
    } 
  }
  
  public final boolean f() {
    try {
      String str = a(this.e, "pili_qos_index.json", 0L);
      if (str == null) {
        e();
        return false;
      } 
      JSONObject jSONObject = new JSONObject(String.valueOf(str));
      this.a = jSONObject.getLong("read_file_index");
      this.b = jSONObject.getLong("read_file_position");
      this.c = jSONObject.getLong("write_file_index");
      this.d = jSONObject.getLong("write_file_position");
      return true;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      e();
      return false;
    } 
  }
  
  public final boolean g() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("read_file_index", this.a);
      jSONObject.put("read_file_position", this.b);
      jSONObject.put("write_file_index", this.c);
      jSONObject.put("write_file_position", this.d);
      Context context = this.e;
      return a(context, "pili_qos_index.json", jSONObject.toString(), 0);
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */