package com.tencent.tbs.patch.applier;

import com.tencent.tbs.patch.common.patch.DeltaFormat;
import com.tencent.tbs.patch.common.patch.FileHolder;
import com.tencent.tbs.patch.common.patch.PatchDelta;
import com.tencent.tbs.patch.common.patch.PatchStatus;
import com.tencent.tbs.patch.json.JSONObject;
import java.util.LinkedHashMap;
import java.util.Map;

final class b {
  private String a;
  
  private String b;
  
  private int c;
  
  private boolean d;
  
  private boolean e;
  
  private final Map<String, FileHolder> f = new LinkedHashMap<String, FileHolder>();
  
  private final Map<String, FileHolder> g = new LinkedHashMap<String, FileHolder>();
  
  private final Map<String, PatchDelta> h = new LinkedHashMap<String, PatchDelta>();
  
  private final Map<String, String> i = new LinkedHashMap<String, String>();
  
  private PatchDelta a(JSONObject paramJSONObject) {
    try {
      PatchDelta patchDelta = new PatchDelta();
      patchDelta.setName(paramJSONObject.optString("name"));
      patchDelta.setStatus(PatchStatus.of(paramJSONObject.optInt("state")));
      patchDelta.setFormat(DeltaFormat.codeOf(paramJSONObject.optInt("format")));
      patchDelta.setDataDigest(paramJSONObject.optString("digest"));
      patchDelta.setDeltaLength(paramJSONObject.optInt("len"));
      patchDelta.setLastModified(paramJSONObject.optInt("time"));
      return patchDelta;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private void a(FileHolder paramFileHolder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/tencent/tbs/patch/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual getPath : ()Ljava/lang/String;
    //   10: invokestatic readStrFromFile : (Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: ldc 'STR'
    //   21: iconst_0
    //   22: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   25: putfield d : Z
    //   28: aload_0
    //   29: aload_1
    //   30: ldc 'RCS'
    //   32: iconst_0
    //   33: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   36: putfield e : Z
    //   39: aload_0
    //   40: aload_1
    //   41: ldc 'CLV'
    //   43: iconst_m1
    //   44: invokevirtual optInt : (Ljava/lang/String;I)I
    //   47: putfield c : I
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	53	finally
  }
  
  private void b(FileHolder paramFileHolder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/tencent/tbs/patch/json/JSONObject
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual getPath : ()Ljava/lang/String;
    //   10: invokestatic readStrFromFile : (Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual keys : ()Ljava/util/Iterator;
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 60
    //   31: aload_2
    //   32: invokeinterface next : ()Ljava/lang/Object;
    //   37: checkcast java/lang/String
    //   40: astore_3
    //   41: aload_0
    //   42: getfield i : Ljava/util/Map;
    //   45: aload_3
    //   46: aload_1
    //   47: aload_3
    //   48: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   51: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: goto -> 22
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	63	finally
    //   22	57	63	finally
  }
  
  private void c(FileHolder paramFileHolder) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/tencent/tbs/patch/json/JSONArray
    //   5: dup
    //   6: aload_1
    //   7: invokevirtual getPath : ()Ljava/lang/String;
    //   10: invokestatic readStrFromFile : (Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial <init> : (Ljava/lang/String;)V
    //   16: astore_1
    //   17: iconst_0
    //   18: istore_2
    //   19: iload_2
    //   20: aload_1
    //   21: invokevirtual length : ()I
    //   24: if_icmpge -> 73
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: invokevirtual getJSONObject : (I)Lcom/tencent/tbs/patch/json/JSONObject;
    //   33: invokespecial a : (Lcom/tencent/tbs/patch/json/JSONObject;)Lcom/tencent/tbs/patch/common/patch/PatchDelta;
    //   36: astore_3
    //   37: aload_3
    //   38: ifnull -> 63
    //   41: aload_0
    //   42: getfield h : Ljava/util/Map;
    //   45: aload_3
    //   46: invokevirtual getName : ()Ljava/lang/String;
    //   49: aload_3
    //   50: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: iload_2
    //   57: iconst_1
    //   58: iadd
    //   59: istore_2
    //   60: goto -> 19
    //   63: new com/tencent/tbs/patch/common/PatchException
    //   66: dup
    //   67: ldc 'Cannot resolve file patch info!'
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: athrow
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	76	finally
    //   19	37	76	finally
    //   41	56	76	finally
    //   63	73	76	finally
  }
  
  public FileHolder a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
  }
  
  public Map<String, FileHolder> a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/LinkedHashMap
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield f : Ljava/util/Map;
    //   14: invokeinterface keySet : ()Ljava/util/Set;
    //   19: invokeinterface iterator : ()Ljava/util/Iterator;
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface hasNext : ()Z
    //   31: ifeq -> 90
    //   34: aload_2
    //   35: invokeinterface next : ()Ljava/lang/Object;
    //   40: checkcast java/lang/String
    //   43: astore_3
    //   44: aload_0
    //   45: getfield f : Ljava/util/Map;
    //   48: aload_3
    //   49: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   57: astore #4
    //   59: aload_0
    //   60: getfield h : Ljava/util/Map;
    //   63: aload_3
    //   64: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   69: ifnonnull -> 25
    //   72: aload #4
    //   74: ifnull -> 25
    //   77: aload_1
    //   78: aload_3
    //   79: aload #4
    //   81: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: goto -> 25
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: areturn
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	94	finally
    //   25	72	94	finally
    //   77	87	94	finally
  }
  
  public void a(ApplierConfig paramApplierConfig) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/tencent/tbs/patch/common/ZipFileDeflater
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual getTempDir : ()Ljava/lang/String;
    //   15: aload_1
    //   16: invokevirtual getPatchInput : ()Ljava/lang/String;
    //   19: invokevirtual parse : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_2
    //   23: invokevirtual getFileEntries : ()Ljava/util/List;
    //   26: invokeinterface iterator : ()Ljava/util/Iterator;
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 69
    //   41: aload_2
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   50: astore_3
    //   51: aload_0
    //   52: getfield g : Ljava/util/Map;
    //   55: aload_3
    //   56: invokevirtual getName : ()Ljava/lang/String;
    //   59: aload_3
    //   60: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: goto -> 32
    //   69: aload_0
    //   70: getfield g : Ljava/util/Map;
    //   73: ldc 'patch.json'
    //   75: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   83: astore_2
    //   84: aload_0
    //   85: getfield g : Ljava/util/Map;
    //   88: ldc 'pkg-restore.json'
    //   90: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   95: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   98: astore_3
    //   99: aload_0
    //   100: getfield g : Ljava/util/Map;
    //   103: ldc 'pkg-data.compat'
    //   105: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   110: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   113: astore #4
    //   115: aload_0
    //   116: getfield g : Ljava/util/Map;
    //   119: ldc 'pkg-desc.json'
    //   121: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   129: astore #5
    //   131: aload_0
    //   132: getfield g : Ljava/util/Map;
    //   135: ldc 'patch-cfg.json'
    //   137: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   145: astore #6
    //   147: aload_2
    //   148: ifnull -> 334
    //   151: aload_3
    //   152: ifnull -> 323
    //   155: aload #4
    //   157: ifnull -> 312
    //   160: aload #5
    //   162: ifnull -> 302
    //   165: aload_0
    //   166: aload #4
    //   168: invokevirtual getPath : ()Ljava/lang/String;
    //   171: putfield a : Ljava/lang/String;
    //   174: aload_0
    //   175: aload #5
    //   177: invokevirtual getPath : ()Ljava/lang/String;
    //   180: putfield b : Ljava/lang/String;
    //   183: aload_0
    //   184: aload_2
    //   185: invokespecial c : (Lcom/tencent/tbs/patch/common/patch/FileHolder;)V
    //   188: aload_0
    //   189: aload_3
    //   190: invokespecial b : (Lcom/tencent/tbs/patch/common/patch/FileHolder;)V
    //   193: aload_0
    //   194: aload #6
    //   196: invokespecial a : (Lcom/tencent/tbs/patch/common/patch/FileHolder;)V
    //   199: aload_1
    //   200: invokevirtual isSourceInputDir : ()Z
    //   203: ifeq -> 217
    //   206: new com/tencent/tbs/patch/common/DirectoryFileDeflater
    //   209: dup
    //   210: invokespecial <init> : ()V
    //   213: astore_2
    //   214: goto -> 225
    //   217: new com/tencent/tbs/patch/common/ZipFileDeflater
    //   220: dup
    //   221: invokespecial <init> : ()V
    //   224: astore_2
    //   225: aload_2
    //   226: aload_1
    //   227: invokevirtual getTempDir : ()Ljava/lang/String;
    //   230: aload_1
    //   231: invokevirtual getSourceInput : ()Ljava/lang/String;
    //   234: invokevirtual parse : (Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_2
    //   238: invokevirtual getFileEntries : ()Ljava/util/List;
    //   241: invokeinterface iterator : ()Ljava/util/Iterator;
    //   246: astore_1
    //   247: aload_1
    //   248: invokeinterface hasNext : ()Z
    //   253: ifeq -> 299
    //   256: aload_1
    //   257: invokeinterface next : ()Ljava/lang/Object;
    //   262: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual getName : ()Ljava/lang/String;
    //   270: astore_3
    //   271: aload_0
    //   272: getfield i : Ljava/util/Map;
    //   275: aload_3
    //   276: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   281: ifeq -> 247
    //   284: aload_0
    //   285: getfield f : Ljava/util/Map;
    //   288: aload_3
    //   289: aload_2
    //   290: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   295: pop
    //   296: goto -> 247
    //   299: aload_0
    //   300: monitorexit
    //   301: return
    //   302: new com/tencent/tbs/patch/common/PatchException
    //   305: dup
    //   306: ldc 'Missing apk signature v2 info!'
    //   308: invokespecial <init> : (Ljava/lang/String;)V
    //   311: athrow
    //   312: new com/tencent/tbs/patch/common/PatchException
    //   315: dup
    //   316: ldc_w 'Missing meta signature v2 info!'
    //   319: invokespecial <init> : (Ljava/lang/String;)V
    //   322: athrow
    //   323: new com/tencent/tbs/patch/common/PatchException
    //   326: dup
    //   327: ldc_w 'Missing restore info!'
    //   330: invokespecial <init> : (Ljava/lang/String;)V
    //   333: athrow
    //   334: new com/tencent/tbs/patch/common/PatchException
    //   337: dup
    //   338: ldc_w 'Missing patch info!'
    //   341: invokespecial <init> : (Ljava/lang/String;)V
    //   344: athrow
    //   345: astore_1
    //   346: aload_0
    //   347: monitorexit
    //   348: aload_1
    //   349: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	345	finally
    //   32	66	345	finally
    //   69	147	345	finally
    //   165	214	345	finally
    //   217	225	345	finally
    //   225	247	345	finally
    //   247	296	345	finally
    //   302	312	345	finally
    //   312	323	345	finally
    //   323	334	345	finally
    //   334	345	345	finally
  }
  
  public FileHolder b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield g : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast com/tencent/tbs/patch/common/patch/FileHolder
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: areturn
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	20	finally
  }
  
  public Map<String, PatchDelta> b() {
    return this.h;
  }
  
  public Map<String, String> c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield i : Ljava/util/Map;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public String d() {
    return this.a;
  }
  
  public String e() {
    return this.b;
  }
  
  public int f() {
    return this.c;
  }
  
  public boolean g() {
    return this.d;
  }
  
  boolean h() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */