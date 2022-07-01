package com.amap.api.mapcore2d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dt {
  private static Map<Class<? extends ds>, ds> d = new HashMap<Class<? extends ds>, ds>();
  
  private dw a;
  
  private SQLiteDatabase b;
  
  private ds c;
  
  public dt(Context paramContext, ds paramds) {
    try {
      this.a = new dw(paramContext.getApplicationContext(), paramds.a(), null, paramds.b(), paramds);
    } finally {
      paramContext = null;
    } 
  }
  
  private ContentValues a(Object paramObject, du paramdu) {
    ContentValues contentValues = new ContentValues();
    for (Field field : a(paramObject.getClass(), paramdu.b())) {
      field.setAccessible(true);
      a(paramObject, field, contentValues);
    } 
    return contentValues;
  }
  
  private SQLiteDatabase a(boolean paramBoolean) {
    try {
      if (this.b == null)
        this.b = this.a.getReadableDatabase(); 
    } finally {
      Exception exception = null;
    } 
  }
  
  public static ds a(Class<? extends ds> paramClass) throws IllegalAccessException, InstantiationException {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/dt
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/dt.d : Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: ifnonnull -> 29
    //   15: getstatic com/amap/api/mapcore2d/dt.d : Ljava/util/Map;
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual newInstance : ()Ljava/lang/Object;
    //   23: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   28: pop
    //   29: getstatic com/amap/api/mapcore2d/dt.d : Ljava/util/Map;
    //   32: aload_0
    //   33: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast com/amap/api/mapcore2d/ds
    //   41: astore_0
    //   42: ldc com/amap/api/mapcore2d/dt
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: ldc com/amap/api/mapcore2d/dt
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   3	29	47	finally
    //   29	42	47	finally
  }
  
  private <T> T a(Cursor paramCursor, Class<T> paramClass, du paramdu) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    Field[] arrayOfField = a(paramClass, paramdu.b());
    int i = 0;
    Constructor<T> constructor = paramClass.getDeclaredConstructor(new Class[0]);
    constructor.setAccessible(true);
    constructor = (Constructor<T>)constructor.newInstance(new Object[0]);
    int j = arrayOfField.length;
    while (i < j) {
      Field field = arrayOfField[i];
      field.setAccessible(true);
      dv dv = (dv)field.getAnnotation((Class)dv.class);
      if (dv != null) {
        dv = dv;
        int k = dv.b();
        int m = paramCursor.getColumnIndex(dv.a());
        switch (k) {
          case 7:
            field.set(constructor, paramCursor.getBlob(m));
            break;
          case 6:
            field.set(constructor, paramCursor.getString(m));
            break;
          case 5:
            field.set(constructor, Long.valueOf(paramCursor.getLong(m)));
            break;
          case 4:
            field.set(constructor, Double.valueOf(paramCursor.getDouble(m)));
            break;
          case 3:
            field.set(constructor, Float.valueOf(paramCursor.getFloat(m)));
            break;
          case 2:
            field.set(constructor, Integer.valueOf(paramCursor.getInt(m)));
            break;
          case 1:
            field.set(constructor, Short.valueOf(paramCursor.getShort(m)));
            break;
        } 
      } 
      i++;
    } 
    return (T)constructor;
  }
  
  private <T> String a(du paramdu) {
    return (paramdu == null) ? null : paramdu.a();
  }
  
  public static String a(Map<String, String> paramMap) {
    if (paramMap == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    boolean bool = true;
    for (String str : paramMap.keySet()) {
      if (bool) {
        stringBuilder.append(str);
        stringBuilder.append(" = '");
        stringBuilder.append(paramMap.get(str));
        stringBuilder.append("'");
        bool = false;
        continue;
      } 
      stringBuilder.append(" and ");
      stringBuilder.append(str);
      stringBuilder.append(" = '");
      stringBuilder.append(paramMap.get(str));
      stringBuilder.append("'");
    } 
    return stringBuilder.toString();
  }
  
  private <T> void a(SQLiteDatabase paramSQLiteDatabase, T paramT) {
    du du = b(paramT.getClass());
    String str = a(du);
    if (TextUtils.isEmpty(str))
      return; 
    if (paramT != null) {
      if (paramSQLiteDatabase == null)
        return; 
      ContentValues contentValues = a(paramT, du);
      if (contentValues == null)
        return; 
      paramSQLiteDatabase.insert(str, null, contentValues);
    } 
  }
  
  private void a(Object paramObject, Field paramField, ContentValues paramContentValues) {
    // Byte code:
    //   0: aload_2
    //   1: ldc com/amap/api/mapcore2d/dv
    //   3: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   6: astore #11
    //   8: aload #11
    //   10: ifnonnull -> 14
    //   13: return
    //   14: aload #11
    //   16: checkcast com/amap/api/mapcore2d/dv
    //   19: astore #11
    //   21: aload #11
    //   23: invokeinterface b : ()I
    //   28: tableswitch default -> 72, 1 -> 216, 2 -> 192, 3 -> 168, 4 -> 144, 5 -> 120, 6 -> 98, 7 -> 73
    //   72: return
    //   73: aload_2
    //   74: aload_1
    //   75: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   78: checkcast [B
    //   81: checkcast [B
    //   84: astore_1
    //   85: aload_3
    //   86: aload #11
    //   88: invokeinterface a : ()Ljava/lang/String;
    //   93: aload_1
    //   94: invokevirtual put : (Ljava/lang/String;[B)V
    //   97: return
    //   98: aload_2
    //   99: aload_1
    //   100: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast java/lang/String
    //   106: astore_1
    //   107: aload_3
    //   108: aload #11
    //   110: invokeinterface a : ()Ljava/lang/String;
    //   115: aload_1
    //   116: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
    //   119: return
    //   120: aload_2
    //   121: aload_1
    //   122: invokevirtual getLong : (Ljava/lang/Object;)J
    //   125: lstore #9
    //   127: aload_3
    //   128: aload #11
    //   130: invokeinterface a : ()Ljava/lang/String;
    //   135: lload #9
    //   137: invokestatic valueOf : (J)Ljava/lang/Long;
    //   140: invokevirtual put : (Ljava/lang/String;Ljava/lang/Long;)V
    //   143: return
    //   144: aload_2
    //   145: aload_1
    //   146: invokevirtual getDouble : (Ljava/lang/Object;)D
    //   149: dstore #5
    //   151: aload_3
    //   152: aload #11
    //   154: invokeinterface a : ()Ljava/lang/String;
    //   159: dload #5
    //   161: invokestatic valueOf : (D)Ljava/lang/Double;
    //   164: invokevirtual put : (Ljava/lang/String;Ljava/lang/Double;)V
    //   167: return
    //   168: aload_2
    //   169: aload_1
    //   170: invokevirtual getFloat : (Ljava/lang/Object;)F
    //   173: fstore #7
    //   175: aload_3
    //   176: aload #11
    //   178: invokeinterface a : ()Ljava/lang/String;
    //   183: fload #7
    //   185: invokestatic valueOf : (F)Ljava/lang/Float;
    //   188: invokevirtual put : (Ljava/lang/String;Ljava/lang/Float;)V
    //   191: return
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual getInt : (Ljava/lang/Object;)I
    //   197: istore #8
    //   199: aload_3
    //   200: aload #11
    //   202: invokeinterface a : ()Ljava/lang/String;
    //   207: iload #8
    //   209: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   212: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   215: return
    //   216: aload_2
    //   217: aload_1
    //   218: invokevirtual getShort : (Ljava/lang/Object;)S
    //   221: istore #4
    //   223: aload_3
    //   224: aload #11
    //   226: invokeinterface a : ()Ljava/lang/String;
    //   231: iload #4
    //   233: invokestatic valueOf : (S)Ljava/lang/Short;
    //   236: invokevirtual put : (Ljava/lang/String;Ljava/lang/Short;)V
    //   239: return
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual printStackTrace : ()V
    //   245: return
    // Exception table:
    //   from	to	target	type
    //   73	97	240	java/lang/IllegalAccessException
    //   98	119	240	java/lang/IllegalAccessException
    //   120	143	240	java/lang/IllegalAccessException
    //   144	167	240	java/lang/IllegalAccessException
    //   168	191	240	java/lang/IllegalAccessException
    //   192	215	240	java/lang/IllegalAccessException
    //   216	239	240	java/lang/IllegalAccessException
  }
  
  private boolean a(Annotation paramAnnotation) {
    return (paramAnnotation != null);
  }
  
  private Field[] a(Class<?> paramClass, boolean paramBoolean) {
    return (paramClass == null) ? null : (paramBoolean ? paramClass.getSuperclass().getDeclaredFields() : paramClass.getDeclaredFields());
  }
  
  private SQLiteDatabase b(boolean paramBoolean) {
    try {
    
    } finally {
      Exception exception = null;
    } 
    return this.b;
  }
  
  private <T> du b(Class<T> paramClass) {
    paramClass = paramClass.getAnnotation(du.class);
    return !a((Annotation)paramClass) ? null : (du)paramClass;
  }
  
  public <T> List<T> a(String paramString, Class<T> paramClass, boolean paramBoolean) {
    synchronized (this.c) {
      ArrayList<T> arrayList = new ArrayList();
      du du = b(paramClass);
      String str = a(du);
      if (this.b == null)
        this.b = a(paramBoolean); 
      if (this.b != null) {
        boolean bool = TextUtils.isEmpty(str);
        if (bool || paramString == null)
          return arrayList; 
        try {
          Cursor cursor = this.b.query(str, null, paramString, null, null, null, null);
        } finally {
          paramClass = null;
        } 
        if (!paramBoolean)
          try {
            dl.a((Throwable)paramClass, "dbs", "sld");
          } finally {
            if (paramString != null);
          }  
        if (paramString != null)
          try {
            paramString.close();
          } finally {
            paramString = null;
          }  
        try {
          if (this.b != null) {
            this.b.close();
            this.b = null;
          } 
        } finally {
          paramString = null;
        } 
      } 
      return arrayList;
    } 
  }
  
  public <T> void a(T paramT) {
    a(paramT, false);
  }
  
  public void a(Object paramObject, String paramString) {
    synchronized (this.c) {
      List<?> list = b(paramString, paramObject.getClass());
      if (list == null || list.size() == 0) {
        a(paramObject);
      } else {
        a(paramString, paramObject);
      } 
      return;
    } 
  }
  
  public <T> void a(T paramT, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/amap/api/mapcore2d/ds;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: iload_2
    //   10: invokespecial b : (Z)Landroid/database/sqlite/SQLiteDatabase;
    //   13: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   16: aload_0
    //   17: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnonnull -> 26
    //   23: aload_3
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: aload_0
    //   28: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   31: aload_1
    //   32: invokespecial a : (Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   39: ifnull -> 84
    //   42: aload_0
    //   43: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   46: invokevirtual close : ()V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   54: goto -> 84
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 'dbs'
    //   61: ldc_w 'itd'
    //   64: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   71: ifnull -> 84
    //   74: aload_0
    //   75: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   78: invokevirtual close : ()V
    //   81: goto -> 49
    //   84: aload_3
    //   85: monitorexit
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   92: ifnull -> 107
    //   95: aload_0
    //   96: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   99: invokevirtual close : ()V
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_3
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    // Exception table:
    //   from	to	target	type
    //   7	25	109	finally
    //   26	35	57	finally
    //   35	49	109	finally
    //   49	54	109	finally
    //   58	67	87	finally
    //   67	81	109	finally
    //   84	86	109	finally
    //   88	107	109	finally
    //   107	109	109	finally
    //   110	112	109	finally
  }
  
  public <T> void a(String paramString, Class<T> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/amap/api/mapcore2d/ds;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: aload_2
    //   10: invokespecial b : (Ljava/lang/Class;)Lcom/amap/api/mapcore2d/du;
    //   13: invokespecial a : (Lcom/amap/api/mapcore2d/du;)Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   21: ifeq -> 27
    //   24: aload_3
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: aload_0
    //   29: iconst_0
    //   30: invokespecial b : (Z)Landroid/database/sqlite/SQLiteDatabase;
    //   33: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   36: aload_0
    //   37: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   40: ifnonnull -> 46
    //   43: aload_3
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_2
    //   51: aload_1
    //   52: aconst_null
    //   53: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   61: ifnull -> 106
    //   64: aload_0
    //   65: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual close : ()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   76: goto -> 106
    //   79: astore_1
    //   80: aload_1
    //   81: ldc 'dbs'
    //   83: ldc_w 'dld'
    //   86: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   93: ifnull -> 106
    //   96: aload_0
    //   97: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   100: invokevirtual close : ()V
    //   103: goto -> 71
    //   106: aload_3
    //   107: monitorexit
    //   108: return
    //   109: astore_1
    //   110: aload_0
    //   111: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   114: ifnull -> 129
    //   117: aload_0
    //   118: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   121: invokevirtual close : ()V
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_3
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   7	26	131	finally
    //   27	45	131	finally
    //   46	57	79	finally
    //   57	71	131	finally
    //   71	76	131	finally
    //   80	89	109	finally
    //   89	103	131	finally
    //   106	108	131	finally
    //   110	129	131	finally
    //   129	131	131	finally
    //   132	134	131	finally
  }
  
  public <T> void a(String paramString, Object paramObject) {
    a(paramString, paramObject, false);
  }
  
  public <T> void a(String paramString, Object paramObject, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Lcom/amap/api/mapcore2d/ds;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: aload_2
    //   10: ifnonnull -> 17
    //   13: aload #4
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual getClass : ()Ljava/lang/Class;
    //   22: invokespecial b : (Ljava/lang/Class;)Lcom/amap/api/mapcore2d/du;
    //   25: astore #6
    //   27: aload_0
    //   28: aload #6
    //   30: invokespecial a : (Lcom/amap/api/mapcore2d/du;)Ljava/lang/String;
    //   33: astore #5
    //   35: aload #5
    //   37: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   40: ifeq -> 47
    //   43: aload #4
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: aload_2
    //   49: aload #6
    //   51: invokespecial a : (Ljava/lang/Object;Lcom/amap/api/mapcore2d/du;)Landroid/content/ContentValues;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnonnull -> 63
    //   59: aload #4
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: iload_3
    //   66: invokespecial b : (Z)Landroid/database/sqlite/SQLiteDatabase;
    //   69: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   72: aload_0
    //   73: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   76: ifnonnull -> 83
    //   79: aload #4
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   87: aload #5
    //   89: aload_2
    //   90: aload_1
    //   91: aconst_null
    //   92: invokevirtual update : (Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   95: pop
    //   96: aload_0
    //   97: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   100: ifnull -> 156
    //   103: aload_0
    //   104: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   107: invokevirtual close : ()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   115: goto -> 156
    //   118: astore_1
    //   119: iload_3
    //   120: ifne -> 135
    //   123: aload_1
    //   124: ldc 'dbs'
    //   126: ldc_w 'udd'
    //   129: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -> 139
    //   135: aload_1
    //   136: invokevirtual printStackTrace : ()V
    //   139: aload_0
    //   140: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   143: ifnull -> 156
    //   146: aload_0
    //   147: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   150: invokevirtual close : ()V
    //   153: goto -> 110
    //   156: aload #4
    //   158: monitorexit
    //   159: return
    //   160: astore_1
    //   161: aload_0
    //   162: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   165: ifnull -> 180
    //   168: aload_0
    //   169: getfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   172: invokevirtual close : ()V
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield b : Landroid/database/sqlite/SQLiteDatabase;
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload #4
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Exception table:
    //   from	to	target	type
    //   13	16	182	finally
    //   17	46	182	finally
    //   47	55	182	finally
    //   59	62	182	finally
    //   63	82	182	finally
    //   83	96	118	finally
    //   96	110	182	finally
    //   110	115	182	finally
    //   123	132	160	finally
    //   135	139	160	finally
    //   139	153	182	finally
    //   156	159	182	finally
    //   161	180	182	finally
    //   180	182	182	finally
    //   183	186	182	finally
  }
  
  public <T> List<T> b(String paramString, Class<T> paramClass) {
    return a(paramString, paramClass, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */