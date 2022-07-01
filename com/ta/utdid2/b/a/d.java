package com.ta.utdid2.b.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class d {
  private static final Object b = new Object();
  
  private File a;
  
  private final Object a;
  
  private HashMap<File, a> a = (HashMap<File, a>)new Object();
  
  public d(String paramString) {
    this.a = new HashMap<File, a>();
    if (paramString != null && paramString.length() > 0) {
      this.a = (HashMap<File, a>)new File(paramString);
      return;
    } 
    throw new RuntimeException("Directory can not be empty");
  }
  
  private File a() {
    synchronized (this.a) {
      return (File)this.a;
    } 
  }
  
  private static File a(File paramFile) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFile.getPath());
    stringBuilder.append(".bak");
    return new File(stringBuilder.toString());
  }
  
  private File a(File paramFile, String paramString) {
    if (paramString.indexOf(File.separatorChar) < 0)
      return new File(paramFile, paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("File ");
    stringBuilder.append(paramString);
    stringBuilder.append(" contains a path separator");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private File b(String paramString) {
    File file = a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(".xml");
    return a(file, stringBuilder.toString());
  }
  
  public b a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial b : (Ljava/lang/String;)Ljava/io/File;
    //   5: astore #11
    //   7: getstatic com/ta/utdid2/b/a/d.b : Ljava/lang/Object;
    //   10: astore_1
    //   11: aload_1
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield a : Ljava/util/HashMap;
    //   17: aload #11
    //   19: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast com/ta/utdid2/b/a/d$a
    //   25: astore #7
    //   27: aload #7
    //   29: ifnull -> 45
    //   32: aload #7
    //   34: invokevirtual d : ()Z
    //   37: ifne -> 45
    //   40: aload_1
    //   41: monitorexit
    //   42: aload #7
    //   44: areturn
    //   45: aload_1
    //   46: monitorexit
    //   47: aload #11
    //   49: invokestatic a : (Ljava/io/File;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual exists : ()Z
    //   57: ifeq -> 73
    //   60: aload #11
    //   62: invokevirtual delete : ()Z
    //   65: pop
    //   66: aload_1
    //   67: aload #11
    //   69: invokevirtual renameTo : (Ljava/io/File;)Z
    //   72: pop
    //   73: aload #11
    //   75: invokevirtual exists : ()Z
    //   78: istore_3
    //   79: aconst_null
    //   80: astore #5
    //   82: aconst_null
    //   83: astore #6
    //   85: aconst_null
    //   86: astore #10
    //   88: aconst_null
    //   89: astore #9
    //   91: aconst_null
    //   92: astore #8
    //   94: aconst_null
    //   95: astore #4
    //   97: aload #10
    //   99: astore_1
    //   100: iload_3
    //   101: ifeq -> 339
    //   104: aload #10
    //   106: astore_1
    //   107: aload #11
    //   109: invokevirtual canRead : ()Z
    //   112: ifeq -> 339
    //   115: new java/io/FileInputStream
    //   118: dup
    //   119: aload #11
    //   121: invokespecial <init> : (Ljava/io/File;)V
    //   124: astore_1
    //   125: aload #9
    //   127: astore #4
    //   129: aload #8
    //   131: astore #5
    //   133: aload_1
    //   134: invokestatic a : (Ljava/io/InputStream;)Ljava/util/HashMap;
    //   137: astore #6
    //   139: aload #6
    //   141: astore #4
    //   143: aload #6
    //   145: astore #5
    //   147: aload_1
    //   148: invokevirtual close : ()V
    //   151: aload #6
    //   153: astore #4
    //   155: aload_1
    //   156: astore #6
    //   158: aload #4
    //   160: astore_1
    //   161: aload #6
    //   163: invokevirtual close : ()V
    //   166: aload #4
    //   168: astore_1
    //   169: goto -> 339
    //   172: astore #5
    //   174: aload_1
    //   175: astore #4
    //   177: aload #5
    //   179: astore_1
    //   180: goto -> 298
    //   183: aload_1
    //   184: astore #6
    //   186: aload #5
    //   188: astore #4
    //   190: goto -> 204
    //   193: astore_1
    //   194: goto -> 298
    //   197: aconst_null
    //   198: astore #6
    //   200: aload #5
    //   202: astore #4
    //   204: aload #4
    //   206: astore_1
    //   207: aload #6
    //   209: ifnull -> 339
    //   212: goto -> 158
    //   215: aconst_null
    //   216: astore_1
    //   217: aload #6
    //   219: astore #4
    //   221: new java/io/FileInputStream
    //   224: dup
    //   225: aload #11
    //   227: invokespecial <init> : (Ljava/io/File;)V
    //   230: astore #5
    //   232: aload #5
    //   234: aload #5
    //   236: invokevirtual available : ()I
    //   239: newarray byte
    //   241: invokevirtual read : ([B)I
    //   244: pop
    //   245: aload #5
    //   247: astore_1
    //   248: aload_1
    //   249: invokevirtual close : ()V
    //   252: aload_1
    //   253: astore #5
    //   255: goto -> 320
    //   258: aload_1
    //   259: astore #5
    //   261: goto -> 320
    //   264: astore_1
    //   265: aload #5
    //   267: astore #4
    //   269: goto -> 286
    //   272: aload #5
    //   274: astore_1
    //   275: goto -> 310
    //   278: astore #5
    //   280: aload_1
    //   281: astore #4
    //   283: aload #5
    //   285: astore_1
    //   286: aload #4
    //   288: ifnull -> 296
    //   291: aload #4
    //   293: invokevirtual close : ()V
    //   296: aload_1
    //   297: athrow
    //   298: aload #4
    //   300: ifnull -> 308
    //   303: aload #4
    //   305: invokevirtual close : ()V
    //   308: aload_1
    //   309: athrow
    //   310: aload_1
    //   311: astore #5
    //   313: aload_1
    //   314: ifnull -> 320
    //   317: goto -> 248
    //   320: aload #4
    //   322: astore_1
    //   323: aload #5
    //   325: ifnull -> 339
    //   328: aload #4
    //   330: astore_1
    //   331: aload #5
    //   333: invokevirtual close : ()V
    //   336: aload #4
    //   338: astore_1
    //   339: getstatic com/ta/utdid2/b/a/d.b : Ljava/lang/Object;
    //   342: astore #6
    //   344: aload #6
    //   346: monitorenter
    //   347: aload #7
    //   349: ifnull -> 365
    //   352: aload #7
    //   354: aload_1
    //   355: invokevirtual a : (Ljava/util/Map;)V
    //   358: aload #7
    //   360: astore #4
    //   362: goto -> 413
    //   365: aload_0
    //   366: getfield a : Ljava/util/HashMap;
    //   369: aload #11
    //   371: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   374: checkcast com/ta/utdid2/b/a/d$a
    //   377: astore #5
    //   379: aload #5
    //   381: astore #4
    //   383: aload #5
    //   385: ifnonnull -> 413
    //   388: new com/ta/utdid2/b/a/d$a
    //   391: dup
    //   392: aload #11
    //   394: iload_2
    //   395: aload_1
    //   396: invokespecial <init> : (Ljava/io/File;ILjava/util/Map;)V
    //   399: astore #4
    //   401: aload_0
    //   402: getfield a : Ljava/util/HashMap;
    //   405: aload #11
    //   407: aload #4
    //   409: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   412: pop
    //   413: aload #6
    //   415: monitorexit
    //   416: aload #4
    //   418: areturn
    //   419: astore_1
    //   420: aload #6
    //   422: monitorexit
    //   423: aload_1
    //   424: athrow
    //   425: astore #4
    //   427: aload_1
    //   428: monitorexit
    //   429: aload #4
    //   431: athrow
    //   432: astore_1
    //   433: goto -> 215
    //   436: astore_1
    //   437: goto -> 197
    //   440: astore #5
    //   442: goto -> 221
    //   445: astore #4
    //   447: goto -> 183
    //   450: astore #4
    //   452: goto -> 339
    //   455: astore #5
    //   457: goto -> 310
    //   460: astore_1
    //   461: goto -> 272
    //   464: astore #5
    //   466: goto -> 258
    //   469: astore #5
    //   471: goto -> 296
    //   474: astore #4
    //   476: goto -> 308
    // Exception table:
    //   from	to	target	type
    //   13	27	425	finally
    //   32	42	425	finally
    //   45	47	425	finally
    //   115	125	432	org/xmlpull/v1/XmlPullParserException
    //   115	125	436	java/lang/Exception
    //   115	125	193	finally
    //   133	139	440	org/xmlpull/v1/XmlPullParserException
    //   133	139	445	java/lang/Exception
    //   133	139	172	finally
    //   147	151	440	org/xmlpull/v1/XmlPullParserException
    //   147	151	445	java/lang/Exception
    //   147	151	172	finally
    //   161	166	450	finally
    //   221	232	455	java/lang/Exception
    //   221	232	278	finally
    //   232	245	460	java/lang/Exception
    //   232	245	264	finally
    //   248	252	464	finally
    //   291	296	469	finally
    //   296	298	193	finally
    //   303	308	474	finally
    //   331	336	450	finally
    //   352	358	419	finally
    //   365	379	419	finally
    //   388	413	419	finally
    //   413	416	419	finally
    //   420	423	419	finally
    //   427	429	425	finally
  }
  
  static final class a implements b {
    private static final Object c = new Object();
    
    private Map a;
    
    private WeakHashMap<b.b, Object> a;
    
    private final File b;
    
    private final int c;
    
    private final File c;
    
    private boolean j = false;
    
    a(File param1File, int param1Int, Map<Object, Object> param1Map) {
      this.b = param1File;
      this.c = d.b(param1File);
      this.c = param1Int;
      if (param1Map == null)
        param1Map = new HashMap<Object, Object>(); 
      this.a = (WeakHashMap)param1Map;
      this.a = new WeakHashMap<b.b, Object>();
    }
    
    private FileOutputStream a(File param1File) {
      try {
        return new FileOutputStream(param1File);
      } catch (FileNotFoundException fileNotFoundException) {
        if (!param1File.getParentFile().mkdir())
          return null; 
        try {
          return new FileOutputStream(param1File);
        } catch (FileNotFoundException fileNotFoundException1) {
          return null;
        } 
      } 
    }
    
    private boolean e() {
      if (this.b.exists())
        if (!this.c.exists()) {
          if (!this.b.renameTo(this.c))
            return false; 
        } else {
          this.b.delete();
        }  
      try {
        FileOutputStream fileOutputStream = a(this.b);
        if (fileOutputStream == null)
          return false; 
        e.a(this.a, fileOutputStream);
        fileOutputStream.close();
        this.c.delete();
        return true;
      } catch (Exception exception) {
        if (this.b.exists())
          this.b.delete(); 
        return false;
      } 
    }
    
    public b.a a() {
      return new a(this);
    }
    
    public void a(Map param1Map) {
      // Byte code:
      //   0: aload_1
      //   1: ifnull -> 19
      //   4: aload_0
      //   5: monitorenter
      //   6: aload_0
      //   7: aload_1
      //   8: putfield a : Ljava/util/Map;
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      //   19: return
      // Exception table:
      //   from	to	target	type
      //   6	13	14	finally
      //   15	17	14	finally
    }
    
    public void a(boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_1
      //   4: putfield j : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_2
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_2
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
    
    public boolean b() {
      File file = this.b;
      return (file != null && (new File(file.getAbsolutePath())).exists());
    }
    
    public boolean d() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield j : Z
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	11	finally
      //   12	14	11	finally
    }
    
    public Map<String, ?> getAll() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/util/HashMap
      //   5: dup
      //   6: aload_0
      //   7: getfield a : Ljava/util/Map;
      //   10: invokespecial <init> : (Ljava/util/Map;)V
      //   13: astore_1
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_1
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public long getLong(String param1String, long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   12: checkcast java/lang/Long
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull -> 25
      //   20: aload_1
      //   21: invokevirtual longValue : ()J
      //   24: lstore_2
      //   25: aload_0
      //   26: monitorexit
      //   27: lload_2
      //   28: lreturn
      //   29: astore_1
      //   30: aload_0
      //   31: monitorexit
      //   32: aload_1
      //   33: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	29	finally
      //   20	25	29	finally
      //   25	27	29	finally
      //   30	32	29	finally
    }
    
    public String getString(String param1String1, String param1String2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   12: checkcast java/lang/String
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull -> 32
      //   20: goto -> 23
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: areturn
      //   27: astore_1
      //   28: aload_0
      //   29: monitorexit
      //   30: aload_1
      //   31: athrow
      //   32: aload_2
      //   33: astore_1
      //   34: goto -> 23
      // Exception table:
      //   from	to	target	type
      //   2	16	27	finally
      //   23	25	27	finally
      //   28	30	27	finally
    }
    
    public final class a implements b.a {
      private final Map<String, Object> b = new HashMap<String, Object>();
      
      private boolean k = false;
      
      public a(d.a this$0) {}
      
      public b.a a(String param2String) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: aload_0
        //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   13: pop
        //   14: aload_0
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: astore_1
        //   19: aload_0
        //   20: monitorexit
        //   21: aload_1
        //   22: athrow
        // Exception table:
        //   from	to	target	type
        //   2	16	18	finally
        //   19	21	18	finally
      }
      
      public b.a a(String param2String, float param2Float) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: fload_2
        //   8: invokestatic valueOf : (F)Ljava/lang/Float;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public b.a a(String param2String, int param2Int) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: iload_2
        //   8: invokestatic valueOf : (I)Ljava/lang/Integer;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public b.a a(String param2String, long param2Long) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: lload_2
        //   8: invokestatic valueOf : (J)Ljava/lang/Long;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public b.a a(String param2String1, String param2String2) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: aload_2
        //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   13: pop
        //   14: aload_0
        //   15: monitorexit
        //   16: aload_0
        //   17: areturn
        //   18: astore_1
        //   19: aload_0
        //   20: monitorexit
        //   21: aload_1
        //   22: athrow
        // Exception table:
        //   from	to	target	type
        //   2	16	18	finally
        //   19	21	18	finally
      }
      
      public b.a a(String param2String, boolean param2Boolean) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield b : Ljava/util/Map;
        //   6: aload_1
        //   7: iload_2
        //   8: invokestatic valueOf : (Z)Ljava/lang/Boolean;
        //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   16: pop
        //   17: aload_0
        //   18: monitorexit
        //   19: aload_0
        //   20: areturn
        //   21: astore_1
        //   22: aload_0
        //   23: monitorexit
        //   24: aload_1
        //   25: athrow
        // Exception table:
        //   from	to	target	type
        //   2	19	21	finally
        //   22	24	21	finally
      }
      
      public b.a b() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: iconst_1
        //   4: putfield k : Z
        //   7: aload_0
        //   8: monitorexit
        //   9: aload_0
        //   10: areturn
        //   11: astore_1
        //   12: aload_0
        //   13: monitorexit
        //   14: aload_1
        //   15: athrow
        // Exception table:
        //   from	to	target	type
        //   2	9	11	finally
        //   12	14	11	finally
      }
      
      public boolean commit() {
        // Byte code:
        //   0: invokestatic a : ()Ljava/lang/Object;
        //   3: astore #5
        //   5: aload #5
        //   7: monitorenter
        //   8: aload_0
        //   9: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   12: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
        //   15: invokevirtual size : ()I
        //   18: ifle -> 339
        //   21: iconst_1
        //   22: istore_1
        //   23: goto -> 26
        //   26: aconst_null
        //   27: astore_3
        //   28: iload_1
        //   29: ifeq -> 344
        //   32: new java/util/ArrayList
        //   35: dup
        //   36: invokespecial <init> : ()V
        //   39: astore_3
        //   40: new java/util/HashSet
        //   43: dup
        //   44: aload_0
        //   45: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   48: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
        //   51: invokevirtual keySet : ()Ljava/util/Set;
        //   54: invokespecial <init> : (Ljava/util/Collection;)V
        //   57: astore #4
        //   59: goto -> 62
        //   62: aload_0
        //   63: monitorenter
        //   64: aload_0
        //   65: getfield k : Z
        //   68: ifeq -> 88
        //   71: aload_0
        //   72: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   75: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   78: invokeinterface clear : ()V
        //   83: aload_0
        //   84: iconst_0
        //   85: putfield k : Z
        //   88: aload_0
        //   89: getfield b : Ljava/util/Map;
        //   92: invokeinterface entrySet : ()Ljava/util/Set;
        //   97: invokeinterface iterator : ()Ljava/util/Iterator;
        //   102: astore #6
        //   104: aload #6
        //   106: invokeinterface hasNext : ()Z
        //   111: ifeq -> 204
        //   114: aload #6
        //   116: invokeinterface next : ()Ljava/lang/Object;
        //   121: checkcast java/util/Map$Entry
        //   124: astore #8
        //   126: aload #8
        //   128: invokeinterface getKey : ()Ljava/lang/Object;
        //   133: checkcast java/lang/String
        //   136: astore #7
        //   138: aload #8
        //   140: invokeinterface getValue : ()Ljava/lang/Object;
        //   145: astore #8
        //   147: aload #8
        //   149: aload_0
        //   150: if_acmpne -> 171
        //   153: aload_0
        //   154: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   157: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   160: aload #7
        //   162: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
        //   167: pop
        //   168: goto -> 188
        //   171: aload_0
        //   172: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   175: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
        //   178: aload #7
        //   180: aload #8
        //   182: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: pop
        //   188: iload_1
        //   189: ifeq -> 104
        //   192: aload_3
        //   193: aload #7
        //   195: invokeinterface add : (Ljava/lang/Object;)Z
        //   200: pop
        //   201: goto -> 104
        //   204: aload_0
        //   205: getfield b : Ljava/util/Map;
        //   208: invokeinterface clear : ()V
        //   213: aload_0
        //   214: monitorexit
        //   215: aload_0
        //   216: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   219: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Z
        //   222: istore_2
        //   223: iload_2
        //   224: ifeq -> 235
        //   227: aload_0
        //   228: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   231: iconst_1
        //   232: invokevirtual a : (Z)V
        //   235: aload #5
        //   237: monitorexit
        //   238: iload_1
        //   239: ifeq -> 326
        //   242: aload_3
        //   243: invokeinterface size : ()I
        //   248: iconst_1
        //   249: isub
        //   250: istore_1
        //   251: iload_1
        //   252: iflt -> 326
        //   255: aload_3
        //   256: iload_1
        //   257: invokeinterface get : (I)Ljava/lang/Object;
        //   262: checkcast java/lang/String
        //   265: astore #5
        //   267: aload #4
        //   269: invokeinterface iterator : ()Ljava/util/Iterator;
        //   274: astore #6
        //   276: aload #6
        //   278: invokeinterface hasNext : ()Z
        //   283: ifeq -> 319
        //   286: aload #6
        //   288: invokeinterface next : ()Ljava/lang/Object;
        //   293: checkcast com/ta/utdid2/b/a/b$b
        //   296: astore #7
        //   298: aload #7
        //   300: ifnull -> 276
        //   303: aload #7
        //   305: aload_0
        //   306: getfield a : Lcom/ta/utdid2/b/a/d$a;
        //   309: aload #5
        //   311: invokeinterface a : (Lcom/ta/utdid2/b/a/b;Ljava/lang/String;)V
        //   316: goto -> 276
        //   319: iload_1
        //   320: iconst_1
        //   321: isub
        //   322: istore_1
        //   323: goto -> 251
        //   326: iload_2
        //   327: ireturn
        //   328: astore_3
        //   329: aload_0
        //   330: monitorexit
        //   331: aload_3
        //   332: athrow
        //   333: astore_3
        //   334: aload #5
        //   336: monitorexit
        //   337: aload_3
        //   338: athrow
        //   339: iconst_0
        //   340: istore_1
        //   341: goto -> 26
        //   344: aconst_null
        //   345: astore #4
        //   347: goto -> 62
        // Exception table:
        //   from	to	target	type
        //   8	21	333	finally
        //   32	59	333	finally
        //   62	64	333	finally
        //   64	88	328	finally
        //   88	104	328	finally
        //   104	147	328	finally
        //   153	168	328	finally
        //   171	188	328	finally
        //   192	201	328	finally
        //   204	215	328	finally
        //   215	223	333	finally
        //   227	235	333	finally
        //   235	238	333	finally
        //   329	331	328	finally
        //   331	333	333	finally
        //   334	337	333	finally
      }
    }
  }
  
  public final class a implements b.a {
    private final Map<String, Object> b = new HashMap<String, Object>();
    
    private boolean k = false;
    
    public a(d this$0) {}
    
    public b.a a(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: aload_0
      //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: pop
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_0
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public b.a a(String param1String, float param1Float) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: fload_2
      //   8: invokestatic valueOf : (F)Ljava/lang/Float;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public b.a a(String param1String, int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: iload_2
      //   8: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public b.a a(String param1String, long param1Long) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: lload_2
      //   8: invokestatic valueOf : (J)Ljava/lang/Long;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public b.a a(String param1String1, String param1String2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: aload_2
      //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: pop
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_0
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	18	finally
      //   19	21	18	finally
    }
    
    public b.a a(String param1String, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Ljava/util/Map;
      //   6: aload_1
      //   7: iload_2
      //   8: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   11: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: aload_0
      //   20: areturn
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	21	finally
      //   22	24	21	finally
    }
    
    public b.a b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield k : Z
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_0
      //   10: areturn
      //   11: astore_1
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_1
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	11	finally
      //   12	14	11	finally
    }
    
    public boolean commit() {
      // Byte code:
      //   0: invokestatic a : ()Ljava/lang/Object;
      //   3: astore #5
      //   5: aload #5
      //   7: monitorenter
      //   8: aload_0
      //   9: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   12: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
      //   15: invokevirtual size : ()I
      //   18: ifle -> 339
      //   21: iconst_1
      //   22: istore_1
      //   23: goto -> 26
      //   26: aconst_null
      //   27: astore_3
      //   28: iload_1
      //   29: ifeq -> 344
      //   32: new java/util/ArrayList
      //   35: dup
      //   36: invokespecial <init> : ()V
      //   39: astore_3
      //   40: new java/util/HashSet
      //   43: dup
      //   44: aload_0
      //   45: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   48: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/WeakHashMap;
      //   51: invokevirtual keySet : ()Ljava/util/Set;
      //   54: invokespecial <init> : (Ljava/util/Collection;)V
      //   57: astore #4
      //   59: goto -> 62
      //   62: aload_0
      //   63: monitorenter
      //   64: aload_0
      //   65: getfield k : Z
      //   68: ifeq -> 88
      //   71: aload_0
      //   72: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   75: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   78: invokeinterface clear : ()V
      //   83: aload_0
      //   84: iconst_0
      //   85: putfield k : Z
      //   88: aload_0
      //   89: getfield b : Ljava/util/Map;
      //   92: invokeinterface entrySet : ()Ljava/util/Set;
      //   97: invokeinterface iterator : ()Ljava/util/Iterator;
      //   102: astore #6
      //   104: aload #6
      //   106: invokeinterface hasNext : ()Z
      //   111: ifeq -> 204
      //   114: aload #6
      //   116: invokeinterface next : ()Ljava/lang/Object;
      //   121: checkcast java/util/Map$Entry
      //   124: astore #8
      //   126: aload #8
      //   128: invokeinterface getKey : ()Ljava/lang/Object;
      //   133: checkcast java/lang/String
      //   136: astore #7
      //   138: aload #8
      //   140: invokeinterface getValue : ()Ljava/lang/Object;
      //   145: astore #8
      //   147: aload #8
      //   149: aload_0
      //   150: if_acmpne -> 171
      //   153: aload_0
      //   154: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   157: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   160: aload #7
      //   162: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   167: pop
      //   168: goto -> 188
      //   171: aload_0
      //   172: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   175: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Ljava/util/Map;
      //   178: aload #7
      //   180: aload #8
      //   182: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   187: pop
      //   188: iload_1
      //   189: ifeq -> 104
      //   192: aload_3
      //   193: aload #7
      //   195: invokeinterface add : (Ljava/lang/Object;)Z
      //   200: pop
      //   201: goto -> 104
      //   204: aload_0
      //   205: getfield b : Ljava/util/Map;
      //   208: invokeinterface clear : ()V
      //   213: aload_0
      //   214: monitorexit
      //   215: aload_0
      //   216: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   219: invokestatic a : (Lcom/ta/utdid2/b/a/d$a;)Z
      //   222: istore_2
      //   223: iload_2
      //   224: ifeq -> 235
      //   227: aload_0
      //   228: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   231: iconst_1
      //   232: invokevirtual a : (Z)V
      //   235: aload #5
      //   237: monitorexit
      //   238: iload_1
      //   239: ifeq -> 326
      //   242: aload_3
      //   243: invokeinterface size : ()I
      //   248: iconst_1
      //   249: isub
      //   250: istore_1
      //   251: iload_1
      //   252: iflt -> 326
      //   255: aload_3
      //   256: iload_1
      //   257: invokeinterface get : (I)Ljava/lang/Object;
      //   262: checkcast java/lang/String
      //   265: astore #5
      //   267: aload #4
      //   269: invokeinterface iterator : ()Ljava/util/Iterator;
      //   274: astore #6
      //   276: aload #6
      //   278: invokeinterface hasNext : ()Z
      //   283: ifeq -> 319
      //   286: aload #6
      //   288: invokeinterface next : ()Ljava/lang/Object;
      //   293: checkcast com/ta/utdid2/b/a/b$b
      //   296: astore #7
      //   298: aload #7
      //   300: ifnull -> 276
      //   303: aload #7
      //   305: aload_0
      //   306: getfield a : Lcom/ta/utdid2/b/a/d$a;
      //   309: aload #5
      //   311: invokeinterface a : (Lcom/ta/utdid2/b/a/b;Ljava/lang/String;)V
      //   316: goto -> 276
      //   319: iload_1
      //   320: iconst_1
      //   321: isub
      //   322: istore_1
      //   323: goto -> 251
      //   326: iload_2
      //   327: ireturn
      //   328: astore_3
      //   329: aload_0
      //   330: monitorexit
      //   331: aload_3
      //   332: athrow
      //   333: astore_3
      //   334: aload #5
      //   336: monitorexit
      //   337: aload_3
      //   338: athrow
      //   339: iconst_0
      //   340: istore_1
      //   341: goto -> 26
      //   344: aconst_null
      //   345: astore #4
      //   347: goto -> 62
      // Exception table:
      //   from	to	target	type
      //   8	21	333	finally
      //   32	59	333	finally
      //   62	64	333	finally
      //   64	88	328	finally
      //   88	104	328	finally
      //   104	147	328	finally
      //   153	168	328	finally
      //   171	188	328	finally
      //   192	201	328	finally
      //   204	215	328	finally
      //   215	223	333	finally
      //   227	235	333	finally
      //   235	238	333	finally
      //   329	331	328	finally
      //   331	333	333	finally
      //   334	337	333	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\b\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */