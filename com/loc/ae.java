package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ae {
  private static Map<Class<? extends ad>, ad> d = new HashMap<Class<? extends ad>, ad>();
  
  private ah a;
  
  private SQLiteDatabase b;
  
  private ad c;
  
  public ae(Context paramContext, ad paramad) {
    try {
      this.a = new ah(paramContext.getApplicationContext(), paramad.a(), paramad);
    } finally {
      paramContext = null;
    } 
  }
  
  private static ContentValues a(Object paramObject, af paramaf) {
    ContentValues contentValues = new ContentValues();
    Field[] arrayOfField = a(paramObject.getClass(), paramaf.b());
    int j = arrayOfField.length;
    int i;
    for (i = 0;; i++) {
      if (i < j) {
        Field field = arrayOfField[i];
        field.setAccessible(true);
        ag ag = (ag)field.getAnnotation((Class)ag.class);
        if (ag != null) {
          short s;
          double d;
          float f;
          int k;
          long l;
          byte[] arrayOfByte;
          String str;
          ag = ag;
          switch (ag.b()) {
            case 7:
              try {
                arrayOfByte = (byte[])field.get(paramObject);
                contentValues.put(ag.a(), arrayOfByte);
                break;
              } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
              } 
              i++;
              continue;
            case 6:
              str = (String)arrayOfByte.get(paramObject);
              contentValues.put(illegalAccessException.a(), str);
              break;
            case 5:
              l = str.getLong(paramObject);
              contentValues.put(illegalAccessException.a(), Long.valueOf(l));
              break;
            case 4:
              d = str.getDouble(paramObject);
              contentValues.put(illegalAccessException.a(), Double.valueOf(d));
              break;
            case 3:
              f = str.getFloat(paramObject);
              contentValues.put(illegalAccessException.a(), Float.valueOf(f));
              break;
            case 2:
              k = str.getInt(paramObject);
              contentValues.put(illegalAccessException.a(), Integer.valueOf(k));
              break;
            case 1:
              s = str.getShort(paramObject);
              contentValues.put(illegalAccessException.a(), Short.valueOf(s));
              break;
          } 
        } 
      } else {
        break;
      } 
    } 
    return contentValues;
  }
  
  private SQLiteDatabase a() {
    try {
      if (this.b == null)
        this.b = this.a.getReadableDatabase(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public static ad a(Class<? extends ad> paramClass) throws IllegalAccessException, InstantiationException {
    // Byte code:
    //   0: ldc com/loc/ae
    //   2: monitorenter
    //   3: getstatic com/loc/ae.d : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: ifnonnull -> 29
    //   15: getstatic com/loc/ae.d : Ljava/util/Map;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual newInstance : ()Ljava/lang/Object;
    //   23: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: getstatic com/loc/ae.d : Ljava/util/Map;
    //   32: aload_0
    //   33: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast com/loc/ad
    //   41: astore_0
    //   42: ldc com/loc/ae
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: ldc com/loc/ae
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	29	47	finally
    //   29	42	47	finally
  }
  
  private static <T> T a(Cursor paramCursor, Class<T> paramClass, af paramaf) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    Field[] arrayOfField = a(paramClass, paramaf.b());
    int i = 0;
    Constructor<T> constructor = paramClass.getDeclaredConstructor(new Class[0]);
    constructor.setAccessible(true);
    T t = constructor.newInstance(new Object[0]);
    int j = arrayOfField.length;
    while (i < j) {
      Field field = arrayOfField[i];
      field.setAccessible(true);
      constructor = field.getAnnotation(ag.class);
      if (constructor != null) {
        String str;
        Long long_;
        Double double_;
        Float float_;
        Integer integer;
        Short short_;
        ag ag = (ag)constructor;
        int k = ag.b();
        int m = paramCursor.getColumnIndex(ag.a());
        switch (k) {
          case 7:
            field.set(t, paramCursor.getBlob(m));
            break;
          case 6:
            str = paramCursor.getString(m);
            field.set(t, str);
            break;
          case 5:
            long_ = Long.valueOf(paramCursor.getLong(m));
            field.set(t, long_);
            break;
          case 4:
            double_ = Double.valueOf(paramCursor.getDouble(m));
            field.set(t, double_);
            break;
          case 3:
            float_ = Float.valueOf(paramCursor.getFloat(m));
            field.set(t, float_);
            break;
          case 2:
            integer = Integer.valueOf(paramCursor.getInt(m));
            field.set(t, integer);
            break;
          case 1:
            short_ = Short.valueOf(paramCursor.getShort(m));
            field.set(t, short_);
            break;
        } 
      } 
      i++;
    } 
    return t;
  }
  
  private static <T> String a(af paramaf) {
    return (paramaf == null) ? null : paramaf.a();
  }
  
  private static Field[] a(Class<?> paramClass, boolean paramBoolean) {
    return (paramClass == null) ? null : (paramBoolean ? paramClass.getSuperclass().getDeclaredFields() : paramClass.getDeclaredFields());
  }
  
  private SQLiteDatabase b() {
    try {
    
    } finally {
      Exception exception = null;
    } 
    return this.b;
  }
  
  private static <T> af b(Class<T> paramClass) {
    boolean bool;
    paramClass = paramClass.getAnnotation(af.class);
    if (paramClass != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return !bool ? null : (af)paramClass;
  }
  
  public final <T> List<T> a(String paramString, Class<T> paramClass) {
    synchronized (this.c) {
      ArrayList<T> arrayList = new ArrayList();
      af af = b(paramClass);
      String str = a(af);
      if (this.b == null)
        this.b = a(); 
      if (this.b != null) {
        boolean bool = TextUtils.isEmpty(str);
        if (!bool && paramString != null) {
          try {
            Cursor cursor = this.b.query(str, null, paramString, null, null, null, null);
          } finally {
            paramClass = null;
          } 
          try {
            y.a((Throwable)paramClass, "dbs", "sld");
            if (paramString != null)
              try {
                paramString.close();
              } finally {
                paramString = null;
              }  
            return arrayList;
          } finally {
            if (paramString != null);
          } 
        } 
      } 
      return arrayList;
    } 
  }
  
  public final void a(Object paramObject, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/loc/ad;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_2
    //   9: aload_1
    //   10: invokevirtual getClass : ()Ljava/lang/Class;
    //   13: invokevirtual a : (Ljava/lang/String;Ljava/lang/Class;)Ljava/util/List;
    //   16: invokeinterface size : ()I
    //   21: ifne -> 177
    //   24: aload_0
    //   25: getfield c : Lcom/loc/ad;
    //   28: astore_2
    //   29: aload_2
    //   30: monitorenter
    //   31: aload_0
    //   32: aload_0
    //   33: invokespecial b : ()Landroid/database/sqlite/SQLiteDatabase;
    //   36: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   39: aload_0
    //   40: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   43: ifnonnull -> 51
    //   46: aload_2
    //   47: monitorexit
    //   48: goto -> 307
    //   51: aload_0
    //   52: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   55: astore #4
    //   57: aload_1
    //   58: invokevirtual getClass : ()Ljava/lang/Class;
    //   61: invokestatic b : (Ljava/lang/Class;)Lcom/loc/af;
    //   64: astore #5
    //   66: aload #5
    //   68: invokestatic a : (Lcom/loc/af;)Ljava/lang/String;
    //   71: astore #6
    //   73: aload #6
    //   75: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   78: ifne -> 101
    //   81: aload #4
    //   83: ifnull -> 101
    //   86: aload #4
    //   88: aload #6
    //   90: aconst_null
    //   91: aload_1
    //   92: aload #5
    //   94: invokestatic a : (Ljava/lang/Object;Lcom/loc/af;)Landroid/content/ContentValues;
    //   97: invokevirtual insert : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   100: pop2
    //   101: aload_0
    //   102: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   105: ifnull -> 46
    //   108: aload_0
    //   109: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   112: invokevirtual close : ()V
    //   115: aload_0
    //   116: aconst_null
    //   117: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   120: goto -> 46
    //   123: astore_1
    //   124: aload_1
    //   125: ldc 'dbs'
    //   127: ldc_w 'itd'
    //   130: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   137: ifnull -> 46
    //   140: aload_0
    //   141: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   144: invokevirtual close : ()V
    //   147: goto -> 115
    //   150: astore_1
    //   151: aload_0
    //   152: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   155: ifnull -> 170
    //   158: aload_0
    //   159: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   162: invokevirtual close : ()V
    //   165: aload_0
    //   166: aconst_null
    //   167: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_2
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    //   177: aload_0
    //   178: getfield c : Lcom/loc/ad;
    //   181: astore #4
    //   183: aload #4
    //   185: monitorenter
    //   186: aload_1
    //   187: invokevirtual getClass : ()Ljava/lang/Class;
    //   190: invokestatic b : (Ljava/lang/Class;)Lcom/loc/af;
    //   193: astore #6
    //   195: aload #6
    //   197: invokestatic a : (Lcom/loc/af;)Ljava/lang/String;
    //   200: astore #5
    //   202: aload #5
    //   204: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   207: ifeq -> 216
    //   210: aload #4
    //   212: monitorexit
    //   213: goto -> 307
    //   216: aload_1
    //   217: aload #6
    //   219: invokestatic a : (Ljava/lang/Object;Lcom/loc/af;)Landroid/content/ContentValues;
    //   222: astore_1
    //   223: aload_0
    //   224: aload_0
    //   225: invokespecial b : ()Landroid/database/sqlite/SQLiteDatabase;
    //   228: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   231: aload_0
    //   232: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   235: astore #6
    //   237: aload #6
    //   239: ifnonnull -> 245
    //   242: goto -> 210
    //   245: aload_0
    //   246: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   249: aload #5
    //   251: aload_1
    //   252: aload_2
    //   253: aconst_null
    //   254: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   257: pop
    //   258: aload_0
    //   259: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   262: ifnull -> 210
    //   265: aload_0
    //   266: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   269: invokevirtual close : ()V
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   277: goto -> 210
    //   280: astore_1
    //   281: aload_1
    //   282: ldc 'dbs'
    //   284: ldc_w 'udd'
    //   287: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_0
    //   291: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   294: ifnull -> 210
    //   297: aload_0
    //   298: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   301: invokevirtual close : ()V
    //   304: goto -> 272
    //   307: aload_3
    //   308: monitorexit
    //   309: return
    //   310: astore_1
    //   311: aload_0
    //   312: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   315: ifnull -> 330
    //   318: aload_0
    //   319: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   322: invokevirtual close : ()V
    //   325: aload_0
    //   326: aconst_null
    //   327: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   330: aload_1
    //   331: athrow
    //   332: astore_1
    //   333: aload #4
    //   335: monitorexit
    //   336: aload_1
    //   337: athrow
    //   338: astore_1
    //   339: aload_3
    //   340: monitorexit
    //   341: aload_1
    //   342: athrow
    // Exception table:
    //   from	to	target	type
    //   7	31	338	finally
    //   31	46	172	finally
    //   46	48	172	finally
    //   51	81	123	finally
    //   86	101	123	finally
    //   101	115	172	finally
    //   115	120	172	finally
    //   124	133	150	finally
    //   133	147	172	finally
    //   151	170	172	finally
    //   170	172	172	finally
    //   173	175	172	finally
    //   175	177	338	finally
    //   177	186	338	finally
    //   186	210	332	finally
    //   210	213	332	finally
    //   216	237	332	finally
    //   245	258	280	finally
    //   258	272	332	finally
    //   272	277	332	finally
    //   281	290	310	finally
    //   290	304	332	finally
    //   307	309	338	finally
    //   311	330	332	finally
    //   330	332	332	finally
    //   333	336	332	finally
    //   336	338	338	finally
    //   339	341	338	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */