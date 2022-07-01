package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bx {
  private static final String a = bs.c("SRFZHZUVZT3BOa0ZiemZRQQ");
  
  private static final String b = bs.c("FbGJzX3Nkaw");
  
  private static final String c = bs.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
  
  private static final String d = bs.c("FQU5EU0RLMTA");
  
  private static final String e = bs.c("FMTAw");
  
  private static boolean f = false;
  
  private String g = "";
  
  public static bm.a a() {
    return new bm.a() {
        private bx a = new bx();
        
        public final cy a(byte[] param1ArrayOfbyte, Map<String, String> param1Map) {
          return new cr(param1ArrayOfbyte, param1Map);
        }
        
        public final String a() {
          return bx.c();
        }
        
        public final String a(Context param1Context, String param1String) {
          return bx.a(param1Context, param1String);
        }
        
        public final String a(String param1String1, String param1String2, String param1String3, String param1String4) {
          return this.a.a(param1String1, param1String2, param1String3, param1String4);
        }
        
        public final Map<String, String> b() {
          return this.a.b();
        }
      };
  }
  
  public static String a(Context paramContext, String paramString) {
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      if (jSONObject.optInt(bs.c("UY29kZQ")) == 1) {
        String str = (new JSONObject(jSONObject.optString(bs.c("FZGF0YQ")))).optString(bs.c("FYWRpdQ"));
        if (!TextUtils.isEmpty(str)) {
          by.a(str);
          bt.a(paramContext).a(str);
          return str;
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return "";
  }
  
  public static String c() {
    return by.a();
  }
  
  private String d() {
    if (!TextUtils.isEmpty(this.g))
      return this.g; 
    String str = bn.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
    StringBuffer stringBuffer = new StringBuffer();
    boolean bool = false;
    int i;
    for (i = 0; i < str.length(); i++)
      stringBuffer.append((char)(str.charAt(i) - i % 48)); 
    str = stringBuffer.toString();
    stringBuffer = new StringBuffer();
    for (i = bool; i < str.length() / 2; i++)
      stringBuffer.append((char)((str.charAt(i) + str.charAt(str.length() - 1 - i)) / 2)); 
    this.g = stringBuffer.toString();
    return this.g;
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, String paramString4) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put(bs.c("LdGlk"), paramString1);
      jSONObject.put(bs.c("FZGl1"), paramString2);
      jSONObject.put(bs.c("AZGl1Mg"), paramString3);
      jSONObject.put(bs.c("EZGl1Mw"), paramString4);
    } finally {
      paramString1 = null;
    } 
    if (TextUtils.isEmpty(paramString2))
      return null; 
    paramString1 = ca.a();
    if (!TextUtils.isEmpty(paramString1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("\000");
      paramString2 = bv.a(cb.a(stringBuilder.toString().getBytes(), paramString1.getBytes()));
      if (!TextUtils.isEmpty(paramString2))
        try {
          PublicKey publicKey = bz.a(d());
          paramString1 = bv.a(bz.a(paramString1.getBytes("utf-8"), publicKey));
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(bs.c("Fa2V5PQ"));
          stringBuilder1.append(URLEncoder.encode(paramString1));
          stringBuilder1.append(bs.c("SJmRhdGE9"));
          return stringBuilder1.toString();
        } finally {
          paramString1 = null;
        }  
    } 
    return null;
  }
  
  public final Map<String, String> b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/amap/api/col/s/bx.f : Z
    //   5: istore_1
    //   6: iload_1
    //   7: ifeq -> 14
    //   10: aload_0
    //   11: monitorexit
    //   12: aconst_null
    //   13: areturn
    //   14: iconst_1
    //   15: putstatic com/amap/api/col/s/bx.f : Z
    //   18: new java/util/HashMap
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_2
    //   26: aload_2
    //   27: ldc 'FZW50'
    //   29: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   32: ldc 'FMg'
    //   34: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc 'SY2hhbm5lbD0'
    //   52: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   55: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_3
    //   60: getstatic com/amap/api/col/s/bx.b : Ljava/lang/String;
    //   63: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: ldc 'SJmRpdj0'
    //   70: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_3
    //   78: getstatic com/amap/api/col/s/bx.d : Ljava/lang/String;
    //   81: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: new java/lang/StringBuffer
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #4
    //   94: aload #4
    //   96: getstatic com/amap/api/col/s/bx.b : Ljava/lang/String;
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   102: pop
    //   103: aload #4
    //   105: getstatic com/amap/api/col/s/bx.d : Ljava/lang/String;
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   111: pop
    //   112: aload #4
    //   114: ldc 'FQA'
    //   116: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   122: pop
    //   123: aload #4
    //   125: getstatic com/amap/api/col/s/bx.c : Ljava/lang/String;
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   131: pop
    //   132: aload #4
    //   134: invokevirtual toString : ()Ljava/lang/String;
    //   137: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   140: astore #4
    //   142: aload_3
    //   143: ldc 'FJnNpZ249'
    //   145: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_3
    //   153: aload #4
    //   155: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   158: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: new java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore #4
    //   174: aload #4
    //   176: ldc 'SJm91dHB1dD1qc29u'
    //   178: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload #4
    //   187: ldc ' '
    //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: aload #4
    //   196: invokevirtual toString : ()Ljava/lang/String;
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: invokevirtual toString : ()Ljava/lang/String;
    //   207: invokevirtual getBytes : ()[B
    //   210: getstatic com/amap/api/col/s/bx.a : Ljava/lang/String;
    //   213: invokevirtual getBytes : ()[B
    //   216: invokestatic a : ([B[B)[B
    //   219: astore_3
    //   220: aload_2
    //   221: ldc 'FaW4'
    //   223: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   226: aload_3
    //   227: invokestatic a : ([B)Ljava/lang/String;
    //   230: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload_2
    //   235: ldc 'Sa2V5dA'
    //   237: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   240: getstatic com/amap/api/col/s/bx.e : Ljava/lang/String;
    //   243: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: pop
    //   247: aload_0
    //   248: monitorexit
    //   249: aload_2
    //   250: areturn
    //   251: astore_2
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_2
    //   255: athrow
    // Exception table:
    //   from	to	target	type
    //   2	6	251	finally
    //   14	247	251	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */