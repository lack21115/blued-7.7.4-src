package com.bytedance.embedapplog.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.c.a;
import com.bytedance.embedapplog.util.h;
import org.json.JSONArray;
import org.json.JSONObject;

public class g extends a {
  public byte[] h;
  
  int i;
  
  public int j;
  
  private JSONArray k;
  
  private JSONArray l;
  
  private f m;
  
  private JSONArray n;
  
  private j o;
  
  private JSONObject p;
  
  private JSONArray q;
  
  public a a(Cursor paramCursor) {
    this.a = paramCursor.getLong(0);
    this.h = paramCursor.getBlob(1);
    this.i = paramCursor.getInt(2);
    this.p = null;
    this.m = null;
    this.o = null;
    this.n = null;
    this.k = null;
    this.l = null;
    this.q = null;
    return this;
  }
  
  void a(long paramLong, JSONObject paramJSONObject, f paramf, j paramj, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONArray paramJSONArray3, JSONArray paramJSONArray4) {
    this.a = paramLong;
    this.p = paramJSONObject;
    this.m = paramf;
    this.o = paramj;
    this.n = null;
    this.k = paramJSONArray2;
    this.l = paramJSONArray3;
    this.q = paramJSONArray4;
  }
  
  protected void a(ContentValues paramContentValues) {
    paramContentValues.put("local_time_ms", Long.valueOf(System.currentTimeMillis()));
    paramContentValues.put("_data", AppLog.toEncryptByte(f().toString()));
  }
  
  protected void a(JSONObject paramJSONObject) {
    h.a(null);
  }
  
  protected String[] a() {
    return new String[] { "local_time_ms", "integer", "_data", "blob", "_fail", "integer", "_full", "integer" };
  }
  
  protected a b(JSONObject paramJSONObject) {
    h.a(null);
    return null;
  }
  
  protected JSONObject b() {
    boolean bool1;
    byte b;
    boolean bool2;
    String str2;
    String str1;
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("magic_tag", "ss_app_log");
    jSONObject.put("header", this.p);
    jSONObject.put("time_sync", a.a);
    if (this.m != null) {
      JSONArray jSONArray1 = new JSONArray();
      jSONArray1.put(this.m.f());
      jSONObject.put("launch", jSONArray1);
    } 
    j j2 = this.o;
    int i = 0;
    if (j2 != null) {
      JSONObject jSONObject1 = j2.f();
      JSONArray jSONArray1 = this.n;
      if (jSONArray1 != null) {
        bool1 = jSONArray1.length();
      } else {
        bool1 = false;
      } 
      jSONArray1 = new JSONArray();
      for (b = 0; b < bool1; b++) {
        JSONArray jSONArray2 = new JSONArray();
        JSONObject jSONObject2 = new JSONObject((new JSONObject(this.n.optString(b))).optString("params"));
        jSONArray2.put(0, jSONObject2.optString("page_key", ""));
        jSONArray2.put(1, (jSONObject2.optInt("duration", 0) + 999) / 1000);
        jSONArray1.put(jSONArray2);
      } 
      if (bool1 > 0)
        jSONObject1.put("activites", jSONArray1); 
      jSONArray1 = new JSONArray();
      jSONArray1.put(jSONObject1);
      jSONObject.put("terminate", jSONArray1);
    } 
    JSONArray jSONArray = this.k;
    if (jSONArray != null) {
      bool1 = jSONArray.length();
    } else {
      bool1 = false;
    } 
    if (bool1)
      jSONObject.put("event", this.k); 
    jSONArray = this.n;
    if (jSONArray != null) {
      b = jSONArray.length();
    } else {
      b = 0;
    } 
    if (this.l == null) {
      this.l = this.n;
    } else if (b) {
      for (bool2 = false; bool2 < b; bool2++)
        this.l.put(this.n.get(bool2)); 
    } 
    jSONArray = this.l;
    if (jSONArray != null) {
      bool2 = jSONArray.length();
    } else {
      bool2 = false;
    } 
    if (bool2)
      jSONObject.put("event_v3", this.l); 
    jSONArray = this.q;
    if (jSONArray != null)
      i = jSONArray.length(); 
    if (i > 0)
      jSONObject.put("log_data", this.q); 
    StringBuilder stringBuilder = new StringBuilder("wP {");
    f f1 = this.m;
    if (f1 == null)
      str2 = "la"; 
    stringBuilder.append(str2);
    stringBuilder.append(", ");
    j j1 = this.o;
    if (j1 == null)
      str1 = "te"; 
    stringBuilder.append(str1);
    stringBuilder.append(", p: ");
    stringBuilder.append(b);
    stringBuilder.append(", v1: ");
    stringBuilder.append(bool1);
    stringBuilder.append(", v3: ");
    stringBuilder.append(bool2);
    stringBuilder.append("}");
    stringBuilder.append(", m: ");
    stringBuilder.append(i);
    stringBuilder.append("}");
    h.d(stringBuilder.toString(), null);
    return jSONObject;
  }
  
  String d() {
    return "pack";
  }
  
  public String i() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic getEncryptAndCompress : ()Z
    //   5: ifeq -> 48
    //   8: aload_0
    //   9: aload_0
    //   10: getfield h : [B
    //   13: aload_0
    //   14: getfield h : [B
    //   17: arraylength
    //   18: invokestatic b : ([BI)[B
    //   21: putfield h : [B
    //   24: new java/util/zip/GZIPInputStream
    //   27: dup
    //   28: new java/io/ByteArrayInputStream
    //   31: dup
    //   32: aload_0
    //   33: getfield h : [B
    //   36: invokespecial <init> : ([B)V
    //   39: invokespecial <init> : (Ljava/io/InputStream;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: goto -> 62
    //   48: new java/io/ByteArrayInputStream
    //   51: dup
    //   52: aload_0
    //   53: getfield h : [B
    //   56: invokespecial <init> : ([B)V
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: sipush #8192
    //   65: newarray byte
    //   67: astore_3
    //   68: new java/io/ByteArrayOutputStream
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #5
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual read : ([B)I
    //   82: istore_1
    //   83: iload_1
    //   84: iconst_m1
    //   85: if_icmpeq -> 99
    //   88: aload #5
    //   90: aload_3
    //   91: iconst_0
    //   92: iload_1
    //   93: invokevirtual write : ([BII)V
    //   96: goto -> 77
    //   99: aload #5
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: astore_3
    //   105: aload_2
    //   106: invokevirtual close : ()V
    //   109: aload #5
    //   111: invokevirtual close : ()V
    //   114: aload_3
    //   115: areturn
    //   116: astore_3
    //   117: aload #5
    //   119: astore #4
    //   121: goto -> 193
    //   124: astore #4
    //   126: aload #5
    //   128: astore_3
    //   129: goto -> 143
    //   132: astore_3
    //   133: aconst_null
    //   134: astore #4
    //   136: goto -> 193
    //   139: astore #4
    //   141: aconst_null
    //   142: astore_3
    //   143: goto -> 159
    //   146: astore_3
    //   147: aconst_null
    //   148: astore #4
    //   150: goto -> 193
    //   153: astore #4
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore_3
    //   159: aload #4
    //   161: invokevirtual printStackTrace : ()V
    //   164: aload_2
    //   165: ifnull -> 175
    //   168: aload_2
    //   169: invokevirtual close : ()V
    //   172: goto -> 175
    //   175: aload_3
    //   176: ifnull -> 183
    //   179: aload_3
    //   180: invokevirtual close : ()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore #5
    //   187: aload_3
    //   188: astore #4
    //   190: aload #5
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull -> 204
    //   197: aload_2
    //   198: invokevirtual close : ()V
    //   201: goto -> 204
    //   204: aload #4
    //   206: ifnull -> 214
    //   209: aload #4
    //   211: invokevirtual close : ()V
    //   214: aload_3
    //   215: athrow
    //   216: astore_2
    //   217: goto -> 109
    //   220: astore_2
    //   221: aload_3
    //   222: areturn
    //   223: astore_2
    //   224: goto -> 175
    //   227: astore_2
    //   228: aconst_null
    //   229: areturn
    //   230: astore_2
    //   231: goto -> 204
    //   234: astore_2
    //   235: goto -> 214
    // Exception table:
    //   from	to	target	type
    //   2	43	153	java/io/IOException
    //   2	43	146	finally
    //   48	60	153	java/io/IOException
    //   48	60	146	finally
    //   62	77	139	java/io/IOException
    //   62	77	132	finally
    //   77	83	124	java/io/IOException
    //   77	83	116	finally
    //   88	96	124	java/io/IOException
    //   88	96	116	finally
    //   99	105	124	java/io/IOException
    //   99	105	116	finally
    //   105	109	216	java/lang/Exception
    //   109	114	220	java/lang/Exception
    //   159	164	185	finally
    //   168	172	223	java/lang/Exception
    //   179	183	227	java/lang/Exception
    //   197	201	230	java/lang/Exception
    //   209	214	234	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */