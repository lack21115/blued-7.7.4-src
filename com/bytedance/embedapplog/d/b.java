package com.bytedance.embedapplog.d;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.a.e;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.util.g;
import com.bytedance.embedapplog.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  static final HashMap<String, a> a;
  
  private static int b;
  
  private static String c;
  
  private static String d;
  
  private static String e;
  
  private static String f;
  
  private final h g;
  
  private final i h;
  
  private final a i;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(i.h);
    stringBuilder.append(" WHERE ");
    stringBuilder.append("event_name");
    stringBuilder.append(" =?  AND ");
    stringBuilder.append("monitor_status");
    stringBuilder.append("=?");
    c = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE ");
    stringBuilder.append(i.h);
    stringBuilder.append(" SET ");
    stringBuilder.append("monitor_num");
    stringBuilder.append(" =? WHERE ");
    stringBuilder.append("event_name");
    stringBuilder.append(" =? AND ");
    stringBuilder.append("monitor_status");
    stringBuilder.append(" =?");
    d = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(i.h);
    stringBuilder.append(" WHERE ");
    stringBuilder.append("date");
    stringBuilder.append("<? ORDER BY ");
    stringBuilder.append("local_time_ms");
    stringBuilder.append(" LIMIT ?");
    e = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("DELETE FROM ");
    stringBuilder.append(i.h);
    stringBuilder.append(" WHERE ");
    stringBuilder.append("local_time_ms");
    stringBuilder.append(" <= ?");
    f = stringBuilder.toString();
    a = new HashMap<String, a>();
    a(new h());
    a(new c());
    a(new e(null, false, null));
    a(new f());
    a(new j());
    a(new g());
    a(new d("", new JSONObject()));
    a(new i());
  }
  
  public b(Application paramApplication, i parami, h paramh) {
    this.i = new a((Context)paramApplication, "bd_embed_tea_agent.db", null, 29);
    this.h = parami;
    this.g = paramh;
  }
  
  private int a(a[] paramArrayOfa, int paramInt, SQLiteDatabase paramSQLiteDatabase, String paramString, JSONArray[] paramArrayOfJSONArray) {
    int j;
    for (j = 0; j < paramInt; j++)
      paramArrayOfJSONArray[j] = null; 
    paramInt = 200;
    while (paramInt > 0 && j < paramArrayOfa.length) {
      paramArrayOfJSONArray[j] = a(paramSQLiteDatabase, paramArrayOfa[j], paramString, paramInt);
      int k = paramInt - paramArrayOfJSONArray[j].length();
      paramInt = k;
      if (k > 0) {
        j++;
        paramInt = k;
      } 
    } 
    return j;
  }
  
  private long a(JSONObject paramJSONObject, g paramg) {
    long l;
    i i1 = (i)a.get(i.h);
    JSONArray jSONArray = new JSONArray();
    JSONObject jSONObject2 = null;
    Cursor cursor = null;
    e e = new e("bav2b_monitor", true, null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    try {
      SQLiteDatabase sQLiteDatabase2 = this.i.getWritableDatabase();
      try {
        sQLiteDatabase2.beginTransaction();
        l = g.a();
        cursor = sQLiteDatabase2.rawQuery(e, new String[] { String.valueOf(l), String.valueOf(200) });
        long l1 = 0L;
        while (true) {
          l = l1;
          try {
            if (cursor.moveToNext()) {
              l = l1;
              i1.a(cursor);
              l = l1;
              jSONObject2 = i1.f();
              l = l1;
              e.h = jSONObject2.toString();
              l = l1;
              if (e.d() != null) {
                l = l1;
                e.d().b(e);
              } 
              long l2 = l1;
              l = l1;
              if (i1.a > l1) {
                l = l1;
                l2 = i1.a;
              } 
              l = l2;
              stringBuilder.append(jSONObject2.toString());
              l = l2;
              stringBuilder.append(",");
              l = l2;
              jSONArray.put(e.f());
              l1 = l2;
              continue;
            } 
            l = l1;
            stringBuilder.append("]");
            l = l1;
            cursor.close();
            l = l1;
            if (h.b) {
              l = l1;
              StringBuilder stringBuilder1 = new StringBuilder();
              l = l1;
              stringBuilder1.append("p succ:");
              l = l1;
              stringBuilder1.append(stringBuilder.toString());
              l = l1;
              h.a(stringBuilder1.toString(), null);
            } 
            l = l1;
            paramg.a(System.currentTimeMillis(), paramJSONObject, (f)null, (j)null, (JSONArray)null, (JSONArray)null, jSONArray, (JSONArray)null);
            l = l1;
            sQLiteDatabase2.setTransactionSuccessful();
            return l1;
          } catch (Exception exception1) {
            break;
          } 
        } 
      } catch (Exception exception1) {
      
      } finally {
        SQLiteDatabase sQLiteDatabase;
        paramJSONObject = null;
      } 
      JSONObject jSONObject = paramJSONObject;
      SQLiteDatabase sQLiteDatabase1 = sQLiteDatabase2;
    } catch (Exception exception) {
      l = 0L;
      paramJSONObject = jSONObject2;
    } finally {}
    JSONObject jSONObject1 = paramJSONObject;
    h.a(exception);
    if (paramJSONObject != null)
      try {
        paramJSONObject.endTransaction();
        return l;
      } catch (Exception exception1) {
        h.a(exception1);
      }  
    return l;
  }
  
  private String a(long paramLong, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("UPDATE pack SET _fail=");
    stringBuilder.append(paramInt);
    stringBuilder.append(" WHERE ");
    stringBuilder.append("local_time_ms");
    stringBuilder.append("=");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  private String a(a parama, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(parama.d());
    stringBuilder.append(" WHERE ");
    stringBuilder.append("session_id");
    stringBuilder.append("='");
    stringBuilder.append(paramString);
    stringBuilder.append("' ORDER BY ");
    stringBuilder.append("local_time_ms");
    stringBuilder.append(" LIMIT ");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
  
  private String a(a parama, String paramString, long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DELETE FROM ");
    stringBuilder.append(parama.d());
    stringBuilder.append(" WHERE ");
    stringBuilder.append("session_id");
    stringBuilder.append("='");
    stringBuilder.append(paramString);
    stringBuilder.append("' AND ");
    stringBuilder.append("local_time_ms");
    stringBuilder.append("<=");
    stringBuilder.append(paramLong);
    return stringBuilder.toString();
  }
  
  private JSONArray a(SQLiteDatabase paramSQLiteDatabase, a parama, String paramString, int paramInt) {
    // Byte code:
    //   0: new org/json/JSONArray
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #10
    //   9: aload_1
    //   10: aload_0
    //   11: aload_2
    //   12: aload_3
    //   13: iload #4
    //   15: invokespecial a : (Lcom/bytedance/embedapplog/d/a;Ljava/lang/String;I)Ljava/lang/String;
    //   18: aconst_null
    //   19: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore #9
    //   24: lconst_0
    //   25: lstore #7
    //   27: lload #7
    //   29: lstore #5
    //   31: aload #9
    //   33: invokeinterface moveToNext : ()Z
    //   38: ifeq -> 137
    //   41: aload_2
    //   42: aload #9
    //   44: invokevirtual a : (Landroid/database/Cursor;)Lcom/bytedance/embedapplog/d/a;
    //   47: pop
    //   48: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   51: ifeq -> 104
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore #11
    //   63: aload #11
    //   65: ldc_w 'queryEvnetInner, '
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #11
    //   74: aload_3
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload #11
    //   81: ldc_w ', '
    //   84: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload #11
    //   90: aload_2
    //   91: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #11
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: aconst_null
    //   101: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: aload #10
    //   106: aload_2
    //   107: invokevirtual f : ()Lorg/json/JSONObject;
    //   110: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   113: pop
    //   114: lload #5
    //   116: lstore #7
    //   118: aload_2
    //   119: getfield a : J
    //   122: lload #5
    //   124: lcmp
    //   125: ifle -> 27
    //   128: aload_2
    //   129: getfield a : J
    //   132: lstore #7
    //   134: goto -> 27
    //   137: lload #5
    //   139: lconst_0
    //   140: lcmp
    //   141: ifle -> 156
    //   144: aload_1
    //   145: aload_0
    //   146: aload_2
    //   147: aload_3
    //   148: lload #5
    //   150: invokespecial a : (Lcom/bytedance/embedapplog/d/a;Ljava/lang/String;J)Ljava/lang/String;
    //   153: invokevirtual execSQL : (Ljava/lang/String;)V
    //   156: lload #5
    //   158: lstore #7
    //   160: aload #9
    //   162: ifnull -> 209
    //   165: aload #9
    //   167: astore_1
    //   168: aload_1
    //   169: invokeinterface close : ()V
    //   174: lload #5
    //   176: lstore #7
    //   178: goto -> 209
    //   181: astore_3
    //   182: aload #9
    //   184: astore_1
    //   185: goto -> 194
    //   188: astore_3
    //   189: lconst_0
    //   190: lstore #5
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_3
    //   195: invokestatic a : (Ljava/lang/Throwable;)V
    //   198: lload #5
    //   200: lstore #7
    //   202: aload_1
    //   203: ifnull -> 209
    //   206: goto -> 168
    //   209: new java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial <init> : ()V
    //   216: astore_1
    //   217: aload_1
    //   218: ldc_w 'queryEvent, '
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_1
    //   226: aload_2
    //   227: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: ldc_w ', '
    //   235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_1
    //   240: aload #10
    //   242: invokevirtual length : ()I
    //   245: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: ldc_w ', '
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: lload #7
    //   260: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual toString : ()Ljava/lang/String;
    //   268: aconst_null
    //   269: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload #10
    //   274: areturn
    //   275: astore_2
    //   276: aload_1
    //   277: ifnull -> 286
    //   280: aload_1
    //   281: invokeinterface close : ()V
    //   286: aload_2
    //   287: athrow
    // Exception table:
    //   from	to	target	type
    //   9	24	188	finally
    //   31	104	181	finally
    //   104	114	181	finally
    //   118	134	181	finally
    //   144	156	181	finally
    //   194	198	275	finally
  }
  
  private JSONArray a(f paramf, j paramj, h paramh, SQLiteDatabase paramSQLiteDatabase) {
    // Byte code:
    //   0: iconst_1
    //   1: anewarray java/lang/String
    //   4: astore #12
    //   6: aload_1
    //   7: getfield c : Ljava/lang/String;
    //   10: astore #10
    //   12: iconst_0
    //   13: istore #5
    //   15: aload #12
    //   17: iconst_0
    //   18: aload #10
    //   20: aastore
    //   21: new org/json/JSONArray
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #11
    //   30: lconst_0
    //   31: lstore #6
    //   33: aload #4
    //   35: ldc_w 'SELECT * FROM page WHERE session_id=? LIMIT 500'
    //   38: aload #12
    //   40: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore #10
    //   45: aload #10
    //   47: invokeinterface moveToNext : ()Z
    //   52: ifeq -> 155
    //   55: aload_3
    //   56: aload #10
    //   58: invokevirtual a : (Landroid/database/Cursor;)Lcom/bytedance/embedapplog/d/a;
    //   61: pop
    //   62: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   65: ifeq -> 119
    //   68: new java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial <init> : ()V
    //   75: astore #13
    //   77: aload #13
    //   79: ldc_w 'queryPageInner, '
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload #13
    //   88: aload #12
    //   90: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload #13
    //   96: ldc_w ', '
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload #13
    //   105: aload_3
    //   106: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload #13
    //   112: invokevirtual toString : ()Ljava/lang/String;
    //   115: aconst_null
    //   116: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   119: aload_3
    //   120: invokevirtual i : ()Z
    //   123: ifeq -> 139
    //   126: aload #11
    //   128: aload_3
    //   129: invokevirtual f : ()Lorg/json/JSONObject;
    //   132: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   135: pop
    //   136: goto -> 382
    //   139: lload #6
    //   141: aload_3
    //   142: getfield h : J
    //   145: ladd
    //   146: lstore #8
    //   148: lload #8
    //   150: lstore #6
    //   152: goto -> 382
    //   155: iload #5
    //   157: ifeq -> 170
    //   160: aload #4
    //   162: ldc_w 'DELETE FROM page WHERE session_id=?'
    //   165: aload #12
    //   167: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: lload #6
    //   172: lstore #8
    //   174: aload #10
    //   176: ifnull -> 223
    //   179: aload #10
    //   181: astore_3
    //   182: aload_3
    //   183: invokeinterface close : ()V
    //   188: lload #6
    //   190: lstore #8
    //   192: goto -> 223
    //   195: astore #4
    //   197: aload #10
    //   199: astore_3
    //   200: goto -> 207
    //   203: astore #4
    //   205: aconst_null
    //   206: astore_3
    //   207: aload #4
    //   209: invokestatic a : (Ljava/lang/Throwable;)V
    //   212: lload #6
    //   214: lstore #8
    //   216: aload_3
    //   217: ifnull -> 223
    //   220: goto -> 182
    //   223: aload #11
    //   225: invokevirtual length : ()I
    //   228: ifle -> 312
    //   231: lload #8
    //   233: ldc2_w 1000
    //   236: lcmp
    //   237: ifle -> 243
    //   240: goto -> 248
    //   243: ldc2_w 1000
    //   246: lstore #8
    //   248: aload_2
    //   249: lload #8
    //   251: putfield h : J
    //   254: aload_2
    //   255: aload_1
    //   256: getfield c : Ljava/lang/String;
    //   259: putfield c : Ljava/lang/String;
    //   262: aload_2
    //   263: aload_1
    //   264: getfield a : J
    //   267: putfield a : J
    //   270: aload_2
    //   271: aload_1
    //   272: getfield a : J
    //   275: lload #8
    //   277: ladd
    //   278: ldc2_w 1000
    //   281: ldiv
    //   282: putfield i : J
    //   285: aload_2
    //   286: aload_0
    //   287: getfield g : Lcom/bytedance/embedapplog/b/h;
    //   290: invokestatic a : (Lcom/bytedance/embedapplog/b/h;)J
    //   293: putfield b : J
    //   296: aload_2
    //   297: aload_1
    //   298: getfield e : Ljava/lang/String;
    //   301: putfield e : Ljava/lang/String;
    //   304: aload_2
    //   305: aload_1
    //   306: getfield f : Ljava/lang/String;
    //   309: putfield f : Ljava/lang/String;
    //   312: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   315: ifeq -> 366
    //   318: new java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial <init> : ()V
    //   325: astore_1
    //   326: aload_1
    //   327: ldc_w 'queryPage, '
    //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_1
    //   335: aload_2
    //   336: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_1
    //   341: ldc_w ', '
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_1
    //   349: aload #11
    //   351: invokevirtual length : ()I
    //   354: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_1
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: aconst_null
    //   363: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: aload #11
    //   368: areturn
    //   369: astore_1
    //   370: aload_3
    //   371: ifnull -> 380
    //   374: aload_3
    //   375: invokeinterface close : ()V
    //   380: aload_1
    //   381: athrow
    //   382: iconst_1
    //   383: istore #5
    //   385: goto -> 45
    // Exception table:
    //   from	to	target	type
    //   33	45	203	finally
    //   45	119	195	finally
    //   119	136	195	finally
    //   139	148	195	finally
    //   160	170	195	finally
    //   207	212	369	finally
  }
  
  private void a(long paramLong) {
    if (paramLong > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("d succ:maxTs =");
      stringBuilder.append(paramLong);
      h.a(stringBuilder.toString(), null);
      this.i.getWritableDatabase().execSQL(f, (Object[])new String[] { String.valueOf(paramLong) });
    } 
  }
  
  private static void a(a parama) {
    a.put(parama.d(), parama);
  }
  
  private void a(g paramg, HashMap<String, Integer> paramHashMap, boolean paramBoolean) {
    String str = paramg.i();
    try {
      StringBuilder stringBuilder;
      JSONObject jSONObject = new JSONObject(str);
      JSONArray jSONArray2 = jSONObject.optJSONArray("launch");
      JSONArray jSONArray3 = jSONObject.optJSONArray("terminate");
      if (jSONArray2 == null && jSONArray3 == null && paramBoolean) {
        int j = (int)(Math.random() * 100.0D) + 1;
        if (j > AppLog.getSuccRate()) {
          if (h.b) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("drop event,succ rate:");
            stringBuilder.append(AppLog.getSuccRate());
            stringBuilder.append(",random num:");
            stringBuilder.append(j);
            h.a(stringBuilder.toString(), null);
            return;
          } 
          return;
        } 
      } 
      if (jSONArray2 != null && jSONArray2.length() > 0)
        paramHashMap.put("launch", Integer.valueOf(jSONArray2.length())); 
      if (jSONArray3 != null && jSONArray3.length() > 0)
        paramHashMap.put("terminate", Integer.valueOf(jSONArray3.length())); 
      jSONArray2 = stringBuilder.optJSONArray("log_data");
      if (jSONArray2 != null && jSONArray2.length() > 0)
        paramHashMap.put("log_data", Integer.valueOf(jSONArray2.length())); 
      jSONArray2 = stringBuilder.optJSONArray("event");
      byte b1 = 0;
      if (jSONArray2 != null && jSONArray2.length() > 0) {
        int j;
        for (j = 0; j < jSONArray2.length(); j++) {
          int k;
          JSONObject jSONObject1 = jSONArray2.getJSONObject(j);
          String str1 = jSONObject1.optString("tag");
          String str2 = jSONObject1.optString("label");
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("");
          stringBuilder1.append(str1);
          stringBuilder1.append(str2);
          str1 = stringBuilder1.toString();
          Integer integer = paramHashMap.get(str1);
          if (integer == null) {
            k = 1;
          } else {
            k = integer.intValue() + 1;
          } 
          paramHashMap.put(str1, Integer.valueOf(k));
        } 
      } 
      JSONArray jSONArray1 = stringBuilder.optJSONArray("event_v3");
      if (jSONArray1 != null && jSONArray1.length() > 0) {
        int j;
        for (j = b1; j < jSONArray1.length(); j++) {
          int k;
          String str1 = jSONArray1.getJSONObject(j).optString("event");
          Integer integer = paramHashMap.get(str1);
          if (integer == null) {
            k = 1;
          } else {
            k = integer.intValue() + 1;
          } 
          paramHashMap.put(str1, Integer.valueOf(k));
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
  }
  
  private void a(HashMap<String, Integer> paramHashMap, SQLiteDatabase paramSQLiteDatabase, String paramString) {
    if (paramHashMap != null && paramHashMap.size() != 0) {
      if (!g.c())
        return; 
      Iterator<String> iterator = paramHashMap.keySet().iterator();
      ContentValues contentValues = null;
      while (iterator.hasNext()) {
        String str = iterator.next();
        Cursor cursor = paramSQLiteDatabase.rawQuery(c, new String[] { str, paramString });
        Integer integer = paramHashMap.get(str);
        if (h.b) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("i succ:");
          stringBuilder.append(str);
          stringBuilder.append(" r:");
          stringBuilder.append(paramString);
          stringBuilder.append(" count:");
          stringBuilder.append(integer);
          stringBuilder.append(" date:");
          stringBuilder.append(g.a());
          h.a(stringBuilder.toString(), null);
        } 
        if (cursor.moveToNext()) {
          int j = cursor.getInt(8);
          paramSQLiteDatabase.execSQL(d, (Object[])new String[] { String.valueOf(j + integer.intValue()), str, paramString });
        } else {
          i i1 = new i(str, paramString, integer.intValue());
          str = i1.d();
          contentValues = i1.b(contentValues);
          paramSQLiteDatabase.insert(str, null, contentValues);
        } 
        cursor.close();
      } 
    } 
  }
  
  private boolean a(Context paramContext, g paramg) {
    String str = com.bytedance.embedapplog.c.b.b(paramContext, this.h.a());
    byte[] arrayOfByte = AppLog.toEncryptByte(paramg.f().toString());
    h h1 = this.g;
    return (com.bytedance.embedapplog.c.a.a(new String[] { str }, arrayOfByte, h1) == 200);
  }
  
  private boolean a(f paramf, boolean paramBoolean) {
    return (!paramf.k && paramBoolean);
  }
  
  public ArrayList<g> a() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   11: ldc_w 'pack'
    //   14: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast com/bytedance/embedapplog/d/g
    //   20: astore_2
    //   21: aload_0
    //   22: getfield i : Lcom/bytedance/embedapplog/d/b$a;
    //   25: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   28: ldc_w 'SELECT * FROM pack ORDER BY local_time_ms DESC,_full DESC LIMIT 2'
    //   31: aconst_null
    //   32: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_1
    //   36: aload_1
    //   37: invokeinterface moveToNext : ()Z
    //   42: ifeq -> 68
    //   45: aload_2
    //   46: invokevirtual g : ()Lcom/bytedance/embedapplog/d/a;
    //   49: checkcast com/bytedance/embedapplog/d/g
    //   52: astore_2
    //   53: aload_2
    //   54: aload_1
    //   55: invokevirtual a : (Landroid/database/Cursor;)Lcom/bytedance/embedapplog/d/a;
    //   58: pop
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual add : (Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -> 36
    //   68: aload_1
    //   69: ifnull -> 96
    //   72: goto -> 90
    //   75: astore_2
    //   76: goto -> 82
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_2
    //   83: invokestatic a : (Ljava/lang/Throwable;)V
    //   86: aload_1
    //   87: ifnull -> 96
    //   90: aload_1
    //   91: invokeinterface close : ()V
    //   96: new java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial <init> : ()V
    //   103: astore_1
    //   104: aload_1
    //   105: ldc_w 'queryPack, '
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload_3
    //   114: invokevirtual size : ()I
    //   117: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_1
    //   122: ldc_w ', '
    //   125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_1
    //   130: aload_3
    //   131: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_1
    //   136: invokevirtual toString : ()Ljava/lang/String;
    //   139: aconst_null
    //   140: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_3
    //   144: areturn
    //   145: astore_2
    //   146: aload_1
    //   147: ifnull -> 156
    //   150: aload_1
    //   151: invokeinterface close : ()V
    //   156: aload_2
    //   157: athrow
    // Exception table:
    //   from	to	target	type
    //   21	36	79	finally
    //   36	65	75	finally
    //   82	86	145	finally
  }
  
  public void a(Context paramContext) {
    if (b > 0) {
      g g = new g();
      int j = b;
      e e = new e("bav2b_monitor", true, (new i("db_monitor", "db_fail", j)).f().toString());
      if (e.d() != null)
        e.d().b(e); 
      JSONArray jSONArray = new JSONArray();
      jSONArray.put(e.f());
      g.a(System.currentTimeMillis(), this.h.a(), (f)null, (j)null, (JSONArray)null, (JSONArray)null, jSONArray, (JSONArray)null);
      if (a(paramContext, g))
        b -= j; 
    } 
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject) {
    if (g.d()) {
      g g = (g)a.get("pack");
      long l = a(paramJSONObject, g);
      if (l > 0L) {
        if (a(paramContext, g)) {
          a(l);
          return;
        } 
        if (h.b)
          h.a("s succ:fail", null); 
        g.b();
        return;
      } 
      g.e();
    } 
  }
  
  public void a(ArrayList<a> paramArrayList) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 'save, '
    //   12: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual toString : ()Ljava/lang/String;
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: aconst_null
    //   30: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   33: aload_0
    //   34: getfield i : Lcom/bytedance/embedapplog/d/b$a;
    //   37: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual beginTransaction : ()V
    //   45: aload_1
    //   46: invokevirtual iterator : ()Ljava/util/Iterator;
    //   49: astore #4
    //   51: aconst_null
    //   52: astore_2
    //   53: aload #4
    //   55: invokeinterface hasNext : ()Z
    //   60: ifeq -> 101
    //   63: aload #4
    //   65: invokeinterface next : ()Ljava/lang/Object;
    //   70: checkcast com/bytedance/embedapplog/d/a
    //   73: astore #6
    //   75: aload #6
    //   77: invokevirtual d : ()Ljava/lang/String;
    //   80: astore #5
    //   82: aload #6
    //   84: aload_2
    //   85: invokevirtual b : (Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   88: astore_2
    //   89: aload_3
    //   90: aload #5
    //   92: aconst_null
    //   93: aload_2
    //   94: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   97: pop2
    //   98: goto -> 53
    //   101: aload_3
    //   102: invokevirtual setTransactionSuccessful : ()V
    //   105: aload_3
    //   106: ifnull -> 156
    //   109: aload_3
    //   110: invokevirtual endTransaction : ()V
    //   113: return
    //   114: astore #4
    //   116: aload_3
    //   117: astore_2
    //   118: aload #4
    //   120: astore_3
    //   121: goto -> 127
    //   124: astore_3
    //   125: aconst_null
    //   126: astore_2
    //   127: getstatic com/bytedance/embedapplog/d/b.b : I
    //   130: aload_1
    //   131: invokevirtual size : ()I
    //   134: iadd
    //   135: putstatic com/bytedance/embedapplog/d/b.b : I
    //   138: aload_3
    //   139: invokestatic a : (Ljava/lang/Throwable;)V
    //   142: aload_2
    //   143: ifnull -> 156
    //   146: aload_2
    //   147: invokevirtual endTransaction : ()V
    //   150: return
    //   151: astore_1
    //   152: aload_1
    //   153: invokestatic a : (Ljava/lang/Throwable;)V
    //   156: return
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull -> 174
    //   162: aload_2
    //   163: invokevirtual endTransaction : ()V
    //   166: goto -> 174
    //   169: astore_2
    //   170: aload_2
    //   171: invokestatic a : (Ljava/lang/Throwable;)V
    //   174: aload_1
    //   175: athrow
    // Exception table:
    //   from	to	target	type
    //   33	41	124	finally
    //   41	51	114	finally
    //   53	98	114	finally
    //   101	105	114	finally
    //   109	113	151	finally
    //   127	142	157	finally
    //   146	150	151	finally
    //   162	166	169	finally
  }
  
  public void a(ArrayList<g> paramArrayList1, ArrayList<g> paramArrayList2) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload #6
    //   11: ldc_w 'setResult, '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #6
    //   20: aload_1
    //   21: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload #6
    //   27: ldc_w ', '
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload #6
    //   36: aload_2
    //   37: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload #6
    //   43: invokevirtual toString : ()Ljava/lang/String;
    //   46: astore #6
    //   48: aconst_null
    //   49: astore #7
    //   51: aload #6
    //   53: aconst_null
    //   54: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: new java/util/HashMap
    //   60: dup
    //   61: invokespecial <init> : ()V
    //   64: astore #9
    //   66: new java/util/HashMap
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore #10
    //   75: new java/util/HashMap
    //   78: dup
    //   79: invokespecial <init> : ()V
    //   82: astore #11
    //   84: new java/util/HashMap
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: astore #12
    //   93: new java/util/HashMap
    //   96: dup
    //   97: invokespecial <init> : ()V
    //   100: astore #13
    //   102: aload_1
    //   103: ifnull -> 177
    //   106: aload_1
    //   107: invokevirtual size : ()I
    //   110: ifle -> 177
    //   113: iconst_0
    //   114: istore_3
    //   115: iload_3
    //   116: aload_1
    //   117: invokevirtual size : ()I
    //   120: if_icmpge -> 177
    //   123: aload_1
    //   124: iload_3
    //   125: invokevirtual get : (I)Ljava/lang/Object;
    //   128: checkcast com/bytedance/embedapplog/d/g
    //   131: getfield i : I
    //   134: ifne -> 155
    //   137: aload_0
    //   138: aload_1
    //   139: iload_3
    //   140: invokevirtual get : (I)Ljava/lang/Object;
    //   143: checkcast com/bytedance/embedapplog/d/g
    //   146: aload #9
    //   148: iconst_1
    //   149: invokespecial a : (Lcom/bytedance/embedapplog/d/g;Ljava/util/HashMap;Z)V
    //   152: goto -> 170
    //   155: aload_0
    //   156: aload_1
    //   157: iload_3
    //   158: invokevirtual get : (I)Ljava/lang/Object;
    //   161: checkcast com/bytedance/embedapplog/d/g
    //   164: aload #12
    //   166: iconst_0
    //   167: invokespecial a : (Lcom/bytedance/embedapplog/d/g;Ljava/util/HashMap;Z)V
    //   170: iload_3
    //   171: iconst_1
    //   172: iadd
    //   173: istore_3
    //   174: goto -> 115
    //   177: aload_2
    //   178: invokevirtual iterator : ()Ljava/util/Iterator;
    //   181: astore #14
    //   183: aload #14
    //   185: invokeinterface hasNext : ()Z
    //   190: ifeq -> 330
    //   193: aload #14
    //   195: invokeinterface next : ()Ljava/lang/Object;
    //   200: checkcast com/bytedance/embedapplog/d/g
    //   203: astore #15
    //   205: aload #15
    //   207: getfield i : I
    //   210: ifne -> 277
    //   213: aload #10
    //   215: aload #15
    //   217: getfield j : I
    //   220: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   223: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   226: checkcast java/util/HashMap
    //   229: astore #8
    //   231: aload #8
    //   233: astore #6
    //   235: aload #8
    //   237: ifnonnull -> 265
    //   240: new java/util/HashMap
    //   243: dup
    //   244: invokespecial <init> : ()V
    //   247: astore #6
    //   249: aload #10
    //   251: aload #15
    //   253: getfield j : I
    //   256: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   259: aload #6
    //   261: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   264: pop
    //   265: aload_0
    //   266: aload #15
    //   268: aload #6
    //   270: iconst_0
    //   271: invokespecial a : (Lcom/bytedance/embedapplog/d/g;Ljava/util/HashMap;Z)V
    //   274: goto -> 183
    //   277: aload #15
    //   279: getfield i : I
    //   282: iconst_1
    //   283: iadd
    //   284: i2l
    //   285: ldc2_w 5
    //   288: lcmp
    //   289: ifle -> 318
    //   292: aload_0
    //   293: aload #15
    //   295: aload #11
    //   297: iconst_0
    //   298: invokespecial a : (Lcom/bytedance/embedapplog/d/g;Ljava/util/HashMap;Z)V
    //   301: aload_1
    //   302: aload #15
    //   304: invokevirtual add : (Ljava/lang/Object;)Z
    //   307: pop
    //   308: aload #14
    //   310: invokeinterface remove : ()V
    //   315: goto -> 183
    //   318: aload_0
    //   319: aload #15
    //   321: aload #13
    //   323: iconst_0
    //   324: invokespecial a : (Lcom/bytedance/embedapplog/d/g;Ljava/util/HashMap;Z)V
    //   327: goto -> 183
    //   330: aload #7
    //   332: astore #6
    //   334: aload_0
    //   335: getfield i : Lcom/bytedance/embedapplog/d/b$a;
    //   338: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   341: astore #7
    //   343: aload #7
    //   345: astore #6
    //   347: aload #7
    //   349: invokevirtual beginTransaction : ()V
    //   352: aload #7
    //   354: astore #6
    //   356: aload_1
    //   357: invokevirtual iterator : ()Ljava/util/Iterator;
    //   360: astore_1
    //   361: aload #7
    //   363: astore #6
    //   365: aload_1
    //   366: invokeinterface hasNext : ()Z
    //   371: ifeq -> 411
    //   374: aload #7
    //   376: astore #6
    //   378: aload #7
    //   380: ldc_w 'DELETE FROM pack WHERE local_time_ms=?'
    //   383: iconst_1
    //   384: anewarray java/lang/String
    //   387: dup
    //   388: iconst_0
    //   389: aload_1
    //   390: invokeinterface next : ()Ljava/lang/Object;
    //   395: checkcast com/bytedance/embedapplog/d/g
    //   398: getfield a : J
    //   401: invokestatic valueOf : (J)Ljava/lang/String;
    //   404: aastore
    //   405: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: goto -> 361
    //   411: aload #7
    //   413: astore #6
    //   415: aload_2
    //   416: invokevirtual iterator : ()Ljava/util/Iterator;
    //   419: astore_1
    //   420: aload #7
    //   422: astore #6
    //   424: aload_1
    //   425: invokeinterface hasNext : ()Z
    //   430: ifeq -> 496
    //   433: aload #7
    //   435: astore #6
    //   437: aload_1
    //   438: invokeinterface next : ()Ljava/lang/Object;
    //   443: checkcast com/bytedance/embedapplog/d/g
    //   446: astore_2
    //   447: aload #7
    //   449: astore #6
    //   451: aload_2
    //   452: getfield a : J
    //   455: lstore #4
    //   457: aload #7
    //   459: astore #6
    //   461: aload_2
    //   462: getfield i : I
    //   465: iconst_1
    //   466: iadd
    //   467: istore_3
    //   468: aload #7
    //   470: astore #6
    //   472: aload_2
    //   473: iload_3
    //   474: putfield i : I
    //   477: aload #7
    //   479: astore #6
    //   481: aload #7
    //   483: aload_0
    //   484: lload #4
    //   486: iload_3
    //   487: invokespecial a : (JI)Ljava/lang/String;
    //   490: invokevirtual execSQL : (Ljava/lang/String;)V
    //   493: goto -> 420
    //   496: aload #7
    //   498: astore #6
    //   500: aload #10
    //   502: invokevirtual keySet : ()Ljava/util/Set;
    //   505: invokeinterface iterator : ()Ljava/util/Iterator;
    //   510: astore_1
    //   511: aload #7
    //   513: astore #6
    //   515: aload_1
    //   516: invokeinterface hasNext : ()Z
    //   521: ifeq -> 564
    //   524: aload #7
    //   526: astore #6
    //   528: aload_1
    //   529: invokeinterface next : ()Ljava/lang/Object;
    //   534: checkcast java/lang/Integer
    //   537: astore_2
    //   538: aload #7
    //   540: astore #6
    //   542: aload_0
    //   543: aload #10
    //   545: aload_2
    //   546: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   549: checkcast java/util/HashMap
    //   552: aload #7
    //   554: aload_2
    //   555: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   558: invokespecial a : (Ljava/util/HashMap;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   561: goto -> 511
    //   564: aload #7
    //   566: astore #6
    //   568: aload_0
    //   569: aload #9
    //   571: aload #7
    //   573: ldc_w 'success'
    //   576: invokespecial a : (Ljava/util/HashMap;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   579: aload #7
    //   581: astore #6
    //   583: aload_0
    //   584: aload #12
    //   586: aload #7
    //   588: ldc_w 'retry_success'
    //   591: invokespecial a : (Ljava/util/HashMap;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   594: aload #7
    //   596: astore #6
    //   598: aload_0
    //   599: aload #11
    //   601: aload #7
    //   603: ldc_w '13'
    //   606: invokespecial a : (Ljava/util/HashMap;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   609: aload #7
    //   611: astore #6
    //   613: aload_0
    //   614: aload #13
    //   616: aload #7
    //   618: ldc_w '22'
    //   621: invokespecial a : (Ljava/util/HashMap;Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   624: aload #7
    //   626: astore #6
    //   628: aload #7
    //   630: invokevirtual setTransactionSuccessful : ()V
    //   633: aload #7
    //   635: ifnull -> 665
    //   638: aload #7
    //   640: invokevirtual endTransaction : ()V
    //   643: return
    //   644: astore_1
    //   645: aload_1
    //   646: invokestatic a : (Ljava/lang/Throwable;)V
    //   649: aload #6
    //   651: ifnull -> 665
    //   654: aload #6
    //   656: invokevirtual endTransaction : ()V
    //   659: return
    //   660: astore_1
    //   661: aload_1
    //   662: invokestatic a : (Ljava/lang/Throwable;)V
    //   665: return
    //   666: astore_1
    //   667: aload #6
    //   669: ifnull -> 685
    //   672: aload #6
    //   674: invokevirtual endTransaction : ()V
    //   677: goto -> 685
    //   680: astore_2
    //   681: aload_2
    //   682: invokestatic a : (Ljava/lang/Throwable;)V
    //   685: aload_1
    //   686: athrow
    // Exception table:
    //   from	to	target	type
    //   334	343	644	finally
    //   347	352	644	finally
    //   356	361	644	finally
    //   365	374	644	finally
    //   378	408	644	finally
    //   415	420	644	finally
    //   424	433	644	finally
    //   437	447	644	finally
    //   451	457	644	finally
    //   461	468	644	finally
    //   472	477	644	finally
    //   481	493	644	finally
    //   500	511	644	finally
    //   515	524	644	finally
    //   528	538	644	finally
    //   542	561	644	finally
    //   568	579	644	finally
    //   583	594	644	finally
    //   598	609	644	finally
    //   613	624	644	finally
    //   628	633	644	finally
    //   638	643	660	java/lang/Exception
    //   645	649	666	finally
    //   654	659	660	java/lang/Exception
    //   672	677	680	java/lang/Exception
  }
  
  public boolean a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   3: ldc_w 'launch'
    //   6: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   9: checkcast com/bytedance/embedapplog/d/f
    //   12: astore #24
    //   14: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   17: ldc_w 'terminate'
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/bytedance/embedapplog/d/j
    //   26: astore #19
    //   28: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   31: ldc_w 'page'
    //   34: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast com/bytedance/embedapplog/d/h
    //   40: astore #20
    //   42: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   45: ldc_w 'eventv3'
    //   48: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast com/bytedance/embedapplog/d/e
    //   54: astore #25
    //   56: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   59: ldc_w 'event'
    //   62: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast com/bytedance/embedapplog/d/c
    //   68: astore #26
    //   70: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   73: ldc_w 'event_misc'
    //   76: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast com/bytedance/embedapplog/d/d
    //   82: astore #27
    //   84: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   87: astore #13
    //   89: ldc_w 'pack'
    //   92: astore #14
    //   94: aload #13
    //   96: ldc_w 'pack'
    //   99: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   102: checkcast com/bytedance/embedapplog/d/g
    //   105: astore #16
    //   107: new android/content/ContentValues
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: astore #21
    //   116: aconst_null
    //   117: astore #17
    //   119: aload_0
    //   120: getfield i : Lcom/bytedance/embedapplog/d/b$a;
    //   123: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   126: astore #15
    //   128: aload #15
    //   130: invokevirtual beginTransaction : ()V
    //   133: aload #15
    //   135: ldc_w 'SELECT * FROM launch ORDER BY local_time_ms DESC LIMIT 5'
    //   138: aconst_null
    //   139: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   142: astore #13
    //   144: aload_1
    //   145: astore #18
    //   147: aload #21
    //   149: astore #17
    //   151: ldc2_w -9223372036854775808
    //   154: lstore #6
    //   156: ldc2_w 9223372036854775807
    //   159: lstore #8
    //   161: aload #15
    //   163: astore_1
    //   164: aload #18
    //   166: astore #15
    //   168: aload #13
    //   170: invokeinterface moveToNext : ()Z
    //   175: ifeq -> 788
    //   178: aload #24
    //   180: aload #13
    //   182: invokevirtual a : (Landroid/database/Cursor;)Lcom/bytedance/embedapplog/d/a;
    //   185: pop
    //   186: aload #24
    //   188: getfield c : Ljava/lang/String;
    //   191: invokestatic c : ()Ljava/lang/String;
    //   194: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   197: ifeq -> 203
    //   200: goto -> 168
    //   203: aload #24
    //   205: getfield i : Ljava/lang/String;
    //   208: aload_0
    //   209: getfield h : Lcom/bytedance/embedapplog/b/i;
    //   212: invokevirtual d : ()Ljava/lang/String;
    //   215: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   218: istore #12
    //   220: iload #12
    //   222: ifeq -> 268
    //   225: aload #24
    //   227: getfield h : I
    //   230: istore_2
    //   231: aload_0
    //   232: getfield h : Lcom/bytedance/embedapplog/b/i;
    //   235: invokevirtual c : ()I
    //   238: istore_3
    //   239: iload_2
    //   240: iload_3
    //   241: if_icmpeq -> 247
    //   244: goto -> 268
    //   247: goto -> 317
    //   250: astore #15
    //   252: aload #13
    //   254: astore #14
    //   256: aload #15
    //   258: astore #13
    //   260: goto -> 1004
    //   263: astore #14
    //   265: goto -> 960
    //   268: new org/json/JSONObject
    //   271: dup
    //   272: invokespecial <init> : ()V
    //   275: astore #18
    //   277: aload #18
    //   279: aload #15
    //   281: invokestatic b : (Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   284: pop
    //   285: aload #18
    //   287: ldc_w 'app_version'
    //   290: aload #24
    //   292: getfield i : Ljava/lang/String;
    //   295: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   298: pop
    //   299: aload #18
    //   301: ldc_w 'version_code'
    //   304: aload #24
    //   306: getfield h : I
    //   309: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload #18
    //   315: astore #15
    //   317: aload #24
    //   319: getfield a : J
    //   322: lstore #10
    //   324: lload #8
    //   326: lstore #4
    //   328: lload #10
    //   330: lload #8
    //   332: lcmp
    //   333: ifge -> 343
    //   336: aload #24
    //   338: getfield a : J
    //   341: lstore #4
    //   343: aload #24
    //   345: getfield a : J
    //   348: lstore #8
    //   350: lload #8
    //   352: lload #6
    //   354: lcmp
    //   355: ifle -> 368
    //   358: aload #24
    //   360: getfield a : J
    //   363: lstore #6
    //   365: goto -> 368
    //   368: aload_0
    //   369: aload #24
    //   371: aload #19
    //   373: aload #20
    //   375: aload_1
    //   376: invokespecial a : (Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lcom/bytedance/embedapplog/d/h;Landroid/database/sqlite/SQLiteDatabase;)Lorg/json/JSONArray;
    //   379: astore #23
    //   381: iconst_3
    //   382: anewarray com/bytedance/embedapplog/d/a
    //   385: astore #22
    //   387: aload #22
    //   389: iconst_0
    //   390: aload #26
    //   392: aastore
    //   393: aload #22
    //   395: iconst_1
    //   396: aload #25
    //   398: aastore
    //   399: aload #22
    //   401: iconst_2
    //   402: aload #27
    //   404: aastore
    //   405: iconst_3
    //   406: anewarray org/json/JSONArray
    //   409: astore #28
    //   411: aload_0
    //   412: aload #22
    //   414: iconst_0
    //   415: aload_1
    //   416: aload #24
    //   418: getfield c : Ljava/lang/String;
    //   421: aload #28
    //   423: invokespecial a : ([Lcom/bytedance/embedapplog/d/a;ILandroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lorg/json/JSONArray;)I
    //   426: istore_2
    //   427: aload #23
    //   429: invokevirtual length : ()I
    //   432: istore_3
    //   433: iload_3
    //   434: ifle -> 504
    //   437: aload #24
    //   439: getfield a : J
    //   442: lstore #8
    //   444: aload #28
    //   446: iconst_0
    //   447: aaload
    //   448: astore #18
    //   450: aload #28
    //   452: iconst_1
    //   453: aaload
    //   454: astore #21
    //   456: aload #28
    //   458: iconst_2
    //   459: aaload
    //   460: astore #29
    //   462: aload #16
    //   464: lload #8
    //   466: aload #15
    //   468: aconst_null
    //   469: aload #19
    //   471: aload #23
    //   473: aload #18
    //   475: aload #21
    //   477: aload #29
    //   479: invokevirtual a : (JLorg/json/JSONObject;Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   482: goto -> 538
    //   485: aload #13
    //   487: astore #14
    //   489: astore #13
    //   491: goto -> 1004
    //   494: astore #14
    //   496: goto -> 900
    //   499: astore #14
    //   501: goto -> 917
    //   504: aload #24
    //   506: iconst_1
    //   507: putfield j : Z
    //   510: aload #16
    //   512: aload #24
    //   514: getfield a : J
    //   517: aload #15
    //   519: aload #24
    //   521: aconst_null
    //   522: aconst_null
    //   523: aload #28
    //   525: iconst_0
    //   526: aaload
    //   527: aload #28
    //   529: iconst_1
    //   530: aaload
    //   531: aload #28
    //   533: iconst_2
    //   534: aaload
    //   535: invokevirtual a : (JLorg/json/JSONObject;Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   538: aload #16
    //   540: astore #21
    //   542: aload #14
    //   544: astore #18
    //   546: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   549: istore #12
    //   551: iload #12
    //   553: ifeq -> 625
    //   556: new java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial <init> : ()V
    //   563: astore #14
    //   565: aload #14
    //   567: ldc_w 'packer launch, '
    //   570: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload #23
    //   576: invokevirtual length : ()I
    //   579: ifgt -> 1035
    //   582: iconst_1
    //   583: istore #12
    //   585: goto -> 588
    //   588: aload #14
    //   590: iload #12
    //   592: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload #14
    //   598: ldc_w ', sid:'
    //   601: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload #14
    //   607: aload #24
    //   609: getfield c : Ljava/lang/String;
    //   612: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload #14
    //   618: invokevirtual toString : ()Ljava/lang/String;
    //   621: aconst_null
    //   622: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   625: aload #21
    //   627: aload #17
    //   629: invokevirtual b : (Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   632: astore #14
    //   634: aconst_null
    //   635: astore #23
    //   637: aload_1
    //   638: astore #16
    //   640: aload_1
    //   641: astore #17
    //   643: aload_1
    //   644: aload #18
    //   646: aconst_null
    //   647: aload #14
    //   649: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   652: pop2
    //   653: aload_1
    //   654: astore #16
    //   656: aload_1
    //   657: astore #17
    //   659: iload_2
    //   660: aload #22
    //   662: arraylength
    //   663: if_icmpge -> 1048
    //   666: aload_1
    //   667: astore #16
    //   669: aload_1
    //   670: astore #17
    //   672: aload_0
    //   673: aload #22
    //   675: iload_2
    //   676: aload_1
    //   677: aload #24
    //   679: getfield c : Ljava/lang/String;
    //   682: aload #28
    //   684: invokespecial a : ([Lcom/bytedance/embedapplog/d/a;ILandroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lorg/json/JSONArray;)I
    //   687: istore_2
    //   688: aload #28
    //   690: iconst_0
    //   691: aaload
    //   692: ifnonnull -> 716
    //   695: aload #28
    //   697: iconst_1
    //   698: aaload
    //   699: ifnonnull -> 716
    //   702: aload #14
    //   704: astore #16
    //   706: aload #28
    //   708: iconst_2
    //   709: aaload
    //   710: ifnull -> 1041
    //   713: goto -> 716
    //   716: aload_1
    //   717: astore #16
    //   719: aload_1
    //   720: astore #17
    //   722: aload #21
    //   724: aload #24
    //   726: getfield a : J
    //   729: aload #15
    //   731: aconst_null
    //   732: aconst_null
    //   733: aconst_null
    //   734: aload #28
    //   736: iconst_0
    //   737: aaload
    //   738: aload #28
    //   740: iconst_1
    //   741: aaload
    //   742: aload #28
    //   744: iconst_2
    //   745: aaload
    //   746: invokevirtual a : (JLorg/json/JSONObject;Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   749: aload_1
    //   750: astore #16
    //   752: aload_1
    //   753: astore #17
    //   755: aload #21
    //   757: aload #14
    //   759: invokevirtual b : (Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   762: astore #14
    //   764: aload_1
    //   765: astore #16
    //   767: aload_1
    //   768: astore #17
    //   770: aload_1
    //   771: aload #18
    //   773: aload #23
    //   775: aload #14
    //   777: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   780: pop2
    //   781: aload #14
    //   783: astore #16
    //   785: goto -> 1041
    //   788: aload #13
    //   790: astore #14
    //   792: lload #8
    //   794: ldc2_w 9223372036854775807
    //   797: lcmp
    //   798: ifeq -> 843
    //   801: lload #6
    //   803: ldc2_w -9223372036854775808
    //   806: lcmp
    //   807: ifeq -> 843
    //   810: aload_1
    //   811: astore #16
    //   813: aload_1
    //   814: astore #17
    //   816: aload_1
    //   817: ldc_w 'DELETE FROM launch WHERE local_time_ms>=? AND local_time_ms<=?'
    //   820: iconst_2
    //   821: anewarray java/lang/String
    //   824: dup
    //   825: iconst_0
    //   826: lload #8
    //   828: invokestatic valueOf : (J)Ljava/lang/String;
    //   831: aastore
    //   832: dup
    //   833: iconst_1
    //   834: lload #6
    //   836: invokestatic valueOf : (J)Ljava/lang/String;
    //   839: aastore
    //   840: invokevirtual execSQL : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   843: aload_1
    //   844: astore #16
    //   846: aload_1
    //   847: astore #17
    //   849: aload_1
    //   850: invokevirtual setTransactionSuccessful : ()V
    //   853: aload #14
    //   855: ifnull -> 865
    //   858: aload #14
    //   860: invokeinterface close : ()V
    //   865: aload_1
    //   866: ifnull -> 880
    //   869: aload_1
    //   870: invokevirtual endTransaction : ()V
    //   873: iconst_1
    //   874: ireturn
    //   875: astore_1
    //   876: aload_1
    //   877: invokestatic a : (Ljava/lang/Throwable;)V
    //   880: iconst_1
    //   881: ireturn
    //   882: astore #14
    //   884: aload #16
    //   886: astore_1
    //   887: goto -> 900
    //   890: astore #14
    //   892: aload #17
    //   894: astore_1
    //   895: goto -> 917
    //   898: astore #14
    //   900: aload #13
    //   902: astore #15
    //   904: aload #14
    //   906: astore #13
    //   908: aload #15
    //   910: astore #14
    //   912: goto -> 1004
    //   915: astore #14
    //   917: goto -> 960
    //   920: astore #13
    //   922: aconst_null
    //   923: astore #14
    //   925: aload #15
    //   927: astore_1
    //   928: goto -> 1004
    //   931: astore #14
    //   933: aload #15
    //   935: astore_1
    //   936: aload #17
    //   938: astore #13
    //   940: goto -> 960
    //   943: astore #13
    //   945: aconst_null
    //   946: astore_1
    //   947: aload_1
    //   948: astore #14
    //   950: goto -> 1004
    //   953: astore #14
    //   955: aconst_null
    //   956: astore_1
    //   957: aload_1
    //   958: astore #13
    //   960: aload #14
    //   962: invokestatic a : (Ljava/lang/Throwable;)V
    //   965: aload #13
    //   967: ifnull -> 977
    //   970: aload #13
    //   972: invokeinterface close : ()V
    //   977: aload_1
    //   978: ifnull -> 992
    //   981: aload_1
    //   982: invokevirtual endTransaction : ()V
    //   985: iconst_0
    //   986: ireturn
    //   987: astore_1
    //   988: aload_1
    //   989: invokestatic a : (Ljava/lang/Throwable;)V
    //   992: iconst_0
    //   993: ireturn
    //   994: astore #15
    //   996: aload #13
    //   998: astore #14
    //   1000: aload #15
    //   1002: astore #13
    //   1004: aload #14
    //   1006: ifnull -> 1016
    //   1009: aload #14
    //   1011: invokeinterface close : ()V
    //   1016: aload_1
    //   1017: ifnull -> 1032
    //   1020: aload_1
    //   1021: invokevirtual endTransaction : ()V
    //   1024: goto -> 1032
    //   1027: astore_1
    //   1028: aload_1
    //   1029: invokestatic a : (Ljava/lang/Throwable;)V
    //   1032: aload #13
    //   1034: athrow
    //   1035: iconst_0
    //   1036: istore #12
    //   1038: goto -> 588
    //   1041: aload #16
    //   1043: astore #14
    //   1045: goto -> 653
    //   1048: aload #21
    //   1050: astore #16
    //   1052: lload #4
    //   1054: lstore #8
    //   1056: aload #14
    //   1058: astore #17
    //   1060: aload #18
    //   1062: astore #14
    //   1064: goto -> 168
    //   1067: astore #14
    //   1069: goto -> 900
    //   1072: astore #14
    //   1074: goto -> 917
    // Exception table:
    //   from	to	target	type
    //   119	128	953	java/lang/Exception
    //   119	128	943	finally
    //   128	144	931	java/lang/Exception
    //   128	144	920	finally
    //   168	200	915	java/lang/Exception
    //   168	200	898	finally
    //   203	220	915	java/lang/Exception
    //   203	220	898	finally
    //   225	239	263	java/lang/Exception
    //   225	239	250	finally
    //   268	313	915	java/lang/Exception
    //   268	313	898	finally
    //   317	324	915	java/lang/Exception
    //   317	324	898	finally
    //   336	343	263	java/lang/Exception
    //   336	343	250	finally
    //   343	350	915	java/lang/Exception
    //   343	350	898	finally
    //   358	365	263	java/lang/Exception
    //   358	365	250	finally
    //   368	387	915	java/lang/Exception
    //   368	387	898	finally
    //   405	433	915	java/lang/Exception
    //   405	433	898	finally
    //   437	444	499	java/lang/Exception
    //   437	444	494	finally
    //   462	482	1072	java/lang/Exception
    //   462	482	485	finally
    //   504	538	1072	java/lang/Exception
    //   504	538	1067	finally
    //   546	551	1072	java/lang/Exception
    //   546	551	1067	finally
    //   556	582	1072	java/lang/Exception
    //   556	582	485	finally
    //   588	625	1072	java/lang/Exception
    //   588	625	485	finally
    //   625	634	1072	java/lang/Exception
    //   625	634	1067	finally
    //   643	653	890	java/lang/Exception
    //   643	653	882	finally
    //   659	666	890	java/lang/Exception
    //   659	666	882	finally
    //   672	688	890	java/lang/Exception
    //   672	688	882	finally
    //   722	749	890	java/lang/Exception
    //   722	749	882	finally
    //   755	764	890	java/lang/Exception
    //   755	764	882	finally
    //   770	781	890	java/lang/Exception
    //   770	781	882	finally
    //   816	843	890	java/lang/Exception
    //   816	843	882	finally
    //   849	853	890	java/lang/Exception
    //   849	853	882	finally
    //   869	873	875	java/lang/Exception
    //   960	965	994	finally
    //   981	985	987	java/lang/Exception
    //   1020	1024	1027	java/lang/Exception
  }
  
  public boolean a(JSONObject paramJSONObject, f paramf, boolean paramBoolean) {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   3: ldc_w 'eventv3'
    //   6: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   9: checkcast com/bytedance/embedapplog/d/e
    //   12: astore #12
    //   14: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   17: ldc_w 'event'
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/bytedance/embedapplog/d/c
    //   26: astore #13
    //   28: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   31: ldc_w 'event_misc'
    //   34: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast com/bytedance/embedapplog/d/d
    //   40: astore #14
    //   42: getstatic com/bytedance/embedapplog/d/b.a : Ljava/util/HashMap;
    //   45: ldc_w 'pack'
    //   48: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast com/bytedance/embedapplog/d/g
    //   54: astore #11
    //   56: new android/content/ContentValues
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #15
    //   65: aconst_null
    //   66: astore #10
    //   68: aload_0
    //   69: getfield i : Lcom/bytedance/embedapplog/d/b$a;
    //   72: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   75: astore #9
    //   77: aload #9
    //   79: invokevirtual beginTransaction : ()V
    //   82: iconst_3
    //   83: anewarray com/bytedance/embedapplog/d/a
    //   86: astore #10
    //   88: aload #10
    //   90: iconst_0
    //   91: aload #13
    //   93: aastore
    //   94: aload #10
    //   96: iconst_1
    //   97: aload #12
    //   99: aastore
    //   100: aload #10
    //   102: iconst_2
    //   103: aload #14
    //   105: aastore
    //   106: iconst_3
    //   107: anewarray org/json/JSONArray
    //   110: astore #17
    //   112: aload_0
    //   113: aload #10
    //   115: iconst_0
    //   116: aload #9
    //   118: aload_2
    //   119: getfield c : Ljava/lang/String;
    //   122: aload #17
    //   124: invokespecial a : ([Lcom/bytedance/embedapplog/d/a;ILandroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lorg/json/JSONArray;)I
    //   127: istore #4
    //   129: aload #17
    //   131: iconst_0
    //   132: aaload
    //   133: astore #12
    //   135: aload #12
    //   137: ifnull -> 171
    //   140: aload #17
    //   142: iconst_0
    //   143: aaload
    //   144: invokevirtual length : ()I
    //   147: istore #5
    //   149: iload #5
    //   151: ifgt -> 226
    //   154: goto -> 171
    //   157: astore_1
    //   158: aload #9
    //   160: astore_2
    //   161: goto -> 682
    //   164: astore_2
    //   165: aload #9
    //   167: astore_1
    //   168: goto -> 654
    //   171: aload #17
    //   173: iconst_1
    //   174: aaload
    //   175: ifnull -> 192
    //   178: aload #17
    //   180: iconst_1
    //   181: aaload
    //   182: invokevirtual length : ()I
    //   185: istore #5
    //   187: iload #5
    //   189: ifgt -> 226
    //   192: aload #17
    //   194: iconst_2
    //   195: aaload
    //   196: ifnull -> 213
    //   199: aload #17
    //   201: iconst_2
    //   202: aaload
    //   203: invokevirtual length : ()I
    //   206: istore #5
    //   208: iload #5
    //   210: ifgt -> 226
    //   213: aload_0
    //   214: aload_2
    //   215: iload_3
    //   216: invokespecial a : (Lcom/bytedance/embedapplog/d/f;Z)Z
    //   219: istore #6
    //   221: iload #6
    //   223: ifeq -> 434
    //   226: invokestatic currentTimeMillis : ()J
    //   229: lstore #7
    //   231: aload_0
    //   232: aload_2
    //   233: iload_3
    //   234: invokespecial a : (Lcom/bytedance/embedapplog/d/f;Z)Z
    //   237: ifeq -> 700
    //   240: aload_2
    //   241: astore #14
    //   243: goto -> 246
    //   246: aload #17
    //   248: iconst_0
    //   249: aaload
    //   250: astore #18
    //   252: aload #17
    //   254: iconst_1
    //   255: aaload
    //   256: astore #19
    //   258: aload #17
    //   260: iconst_2
    //   261: aaload
    //   262: astore #20
    //   264: aload #9
    //   266: astore #13
    //   268: aconst_null
    //   269: astore #16
    //   271: aload #11
    //   273: astore #12
    //   275: aload #11
    //   277: lload #7
    //   279: aload_1
    //   280: aload #14
    //   282: aconst_null
    //   283: aconst_null
    //   284: aload #18
    //   286: aload #19
    //   288: aload #20
    //   290: invokevirtual a : (JLorg/json/JSONObject;Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   293: aload #12
    //   295: aload #15
    //   297: invokevirtual b : (Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   300: astore #15
    //   302: aload #13
    //   304: ldc_w 'pack'
    //   307: aload #16
    //   309: aload #15
    //   311: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   314: pop2
    //   315: getstatic com/bytedance/embedapplog/util/h.b : Z
    //   318: ifeq -> 384
    //   321: aload_0
    //   322: aload_2
    //   323: iload_3
    //   324: invokespecial a : (Lcom/bytedance/embedapplog/d/f;Z)Z
    //   327: ifeq -> 384
    //   330: new java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial <init> : ()V
    //   337: astore #11
    //   339: aload #11
    //   341: ldc_w 'send launch, '
    //   344: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload #11
    //   350: aload_2
    //   351: getfield c : Ljava/lang/String;
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #11
    //   360: ldc_w ', hadUI:'
    //   363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload #11
    //   369: iload_3
    //   370: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload #11
    //   376: invokevirtual toString : ()Ljava/lang/String;
    //   379: aload #16
    //   381: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload_2
    //   385: iconst_1
    //   386: putfield k : Z
    //   389: aload #10
    //   391: astore #14
    //   393: aload #16
    //   395: astore #11
    //   397: aload #13
    //   399: astore #9
    //   401: aload #15
    //   403: astore #10
    //   405: aload #14
    //   407: astore #13
    //   409: goto -> 453
    //   412: astore_1
    //   413: goto -> 421
    //   416: astore_2
    //   417: goto -> 428
    //   420: astore_1
    //   421: aload #9
    //   423: astore_2
    //   424: goto -> 682
    //   427: astore_2
    //   428: aload #9
    //   430: astore_1
    //   431: goto -> 654
    //   434: aconst_null
    //   435: astore #14
    //   437: aload #10
    //   439: astore #13
    //   441: aload #15
    //   443: astore #10
    //   445: aload #11
    //   447: astore #12
    //   449: aload #14
    //   451: astore #11
    //   453: iload #4
    //   455: aload #13
    //   457: arraylength
    //   458: if_icmpge -> 570
    //   461: aload_2
    //   462: getfield c : Ljava/lang/String;
    //   465: astore #15
    //   467: aload #9
    //   469: astore #14
    //   471: aload_0
    //   472: aload #13
    //   474: iload #4
    //   476: aload #9
    //   478: aload #15
    //   480: aload #17
    //   482: invokespecial a : ([Lcom/bytedance/embedapplog/d/a;ILandroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Lorg/json/JSONArray;)I
    //   485: istore #4
    //   487: aload #17
    //   489: iconst_0
    //   490: aaload
    //   491: ifnull -> 504
    //   494: aload #17
    //   496: iconst_0
    //   497: aaload
    //   498: invokevirtual length : ()I
    //   501: ifgt -> 521
    //   504: aload #17
    //   506: iconst_1
    //   507: aaload
    //   508: ifnull -> 706
    //   511: aload #17
    //   513: iconst_1
    //   514: aaload
    //   515: invokevirtual length : ()I
    //   518: ifle -> 706
    //   521: aload #12
    //   523: invokestatic currentTimeMillis : ()J
    //   526: aload_1
    //   527: aconst_null
    //   528: aconst_null
    //   529: aconst_null
    //   530: aload #17
    //   532: iconst_0
    //   533: aaload
    //   534: aload #17
    //   536: iconst_1
    //   537: aaload
    //   538: aload #17
    //   540: iconst_2
    //   541: aaload
    //   542: invokevirtual a : (JLorg/json/JSONObject;Lcom/bytedance/embedapplog/d/f;Lcom/bytedance/embedapplog/d/j;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;)V
    //   545: aload #12
    //   547: aload #10
    //   549: invokevirtual b : (Landroid/content/ContentValues;)Landroid/content/ContentValues;
    //   552: astore #10
    //   554: aload #14
    //   556: ldc_w 'pack'
    //   559: aload #11
    //   561: aload #10
    //   563: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   566: pop2
    //   567: goto -> 706
    //   570: aload #9
    //   572: astore_1
    //   573: aload_1
    //   574: invokevirtual setTransactionSuccessful : ()V
    //   577: aload_1
    //   578: ifnull -> 592
    //   581: aload_1
    //   582: invokevirtual endTransaction : ()V
    //   585: iconst_1
    //   586: ireturn
    //   587: astore_1
    //   588: aload_1
    //   589: invokestatic a : (Ljava/lang/Throwable;)V
    //   592: iconst_1
    //   593: ireturn
    //   594: aload #9
    //   596: astore_2
    //   597: astore_1
    //   598: goto -> 647
    //   601: aload #9
    //   603: astore_2
    //   604: astore_1
    //   605: goto -> 633
    //   608: astore_1
    //   609: aload #9
    //   611: astore_2
    //   612: goto -> 647
    //   615: astore_1
    //   616: aload #9
    //   618: astore_2
    //   619: goto -> 633
    //   622: astore_1
    //   623: aload #9
    //   625: astore_2
    //   626: goto -> 647
    //   629: astore_1
    //   630: aload #9
    //   632: astore_2
    //   633: aload_2
    //   634: astore #9
    //   636: aload_1
    //   637: astore_2
    //   638: aload #9
    //   640: astore_1
    //   641: goto -> 654
    //   644: astore_1
    //   645: aconst_null
    //   646: astore_2
    //   647: goto -> 682
    //   650: astore_2
    //   651: aload #10
    //   653: astore_1
    //   654: aload_2
    //   655: invokestatic a : (Ljava/lang/Throwable;)V
    //   658: aload_1
    //   659: ifnull -> 673
    //   662: aload_1
    //   663: invokevirtual endTransaction : ()V
    //   666: iconst_0
    //   667: ireturn
    //   668: astore_1
    //   669: aload_1
    //   670: invokestatic a : (Ljava/lang/Throwable;)V
    //   673: iconst_0
    //   674: ireturn
    //   675: astore #9
    //   677: aload_1
    //   678: astore_2
    //   679: aload #9
    //   681: astore_1
    //   682: aload_2
    //   683: ifnull -> 698
    //   686: aload_2
    //   687: invokevirtual endTransaction : ()V
    //   690: goto -> 698
    //   693: astore_2
    //   694: aload_2
    //   695: invokestatic a : (Ljava/lang/Throwable;)V
    //   698: aload_1
    //   699: athrow
    //   700: aconst_null
    //   701: astore #14
    //   703: goto -> 246
    //   706: aload #14
    //   708: astore #9
    //   710: goto -> 453
    // Exception table:
    //   from	to	target	type
    //   68	77	650	java/lang/Exception
    //   68	77	644	finally
    //   77	88	629	java/lang/Exception
    //   77	88	622	finally
    //   106	129	629	java/lang/Exception
    //   106	129	622	finally
    //   140	149	164	java/lang/Exception
    //   140	149	157	finally
    //   178	187	164	java/lang/Exception
    //   178	187	157	finally
    //   199	208	164	java/lang/Exception
    //   199	208	157	finally
    //   213	221	629	java/lang/Exception
    //   213	221	622	finally
    //   226	240	427	java/lang/Exception
    //   226	240	420	finally
    //   275	384	416	java/lang/Exception
    //   275	384	412	finally
    //   384	389	416	java/lang/Exception
    //   384	389	412	finally
    //   453	467	615	java/lang/Exception
    //   453	467	608	finally
    //   471	487	601	java/lang/Exception
    //   471	487	594	finally
    //   494	504	601	java/lang/Exception
    //   494	504	594	finally
    //   511	521	601	java/lang/Exception
    //   511	521	594	finally
    //   521	567	601	java/lang/Exception
    //   521	567	594	finally
    //   573	577	601	java/lang/Exception
    //   573	577	594	finally
    //   581	585	587	java/lang/Exception
    //   654	658	675	finally
    //   662	666	668	java/lang/Exception
    //   686	690	693	java/lang/Exception
  }
  
  static class a extends SQLiteOpenHelper {
    a(Context param1Context, String param1String, SQLiteDatabase.CursorFactory param1CursorFactory, int param1Int) {
      super(param1Context, param1String, param1CursorFactory, param1Int);
    }
    
    public void onCreate(SQLiteDatabase param1SQLiteDatabase) {
      try {
        param1SQLiteDatabase.beginTransaction();
        Iterator<a> iterator = b.a.values().iterator();
        while (iterator.hasNext()) {
          String str = ((a)iterator.next()).c();
          if (str != null)
            param1SQLiteDatabase.execSQL(str); 
        } 
        param1SQLiteDatabase.setTransactionSuccessful();
      } finally {
        null = null;
      } 
    }
    
    public void onDowngrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      onUpgrade(param1SQLiteDatabase, param1Int1, param1Int2);
    }
    
    public void onUpgrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onUpgrade, ");
      stringBuilder.append(param1Int1);
      stringBuilder.append(", ");
      stringBuilder.append(param1Int2);
      h.d(stringBuilder.toString(), null);
      try {
        param1SQLiteDatabase.beginTransaction();
        for (a a1 : b.a.values()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("DROP TABLE IF EXISTS ");
          stringBuilder1.append(a1.d());
          param1SQLiteDatabase.execSQL(stringBuilder1.toString());
        } 
        param1SQLiteDatabase.setTransactionSuccessful();
      } finally {
        stringBuilder = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */