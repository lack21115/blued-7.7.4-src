package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.sdk.openadsdk.c.l;
import com.bytedance.sdk.openadsdk.c.n;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.a;
import com.bytedance.sdk.openadsdk.j.g;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;

public class f {
  private static final Object c = new Object();
  
  private c a;
  
  private Context b;
  
  f(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_1
    //   5: ifnonnull -> 15
    //   8: invokestatic a : ()Landroid/content/Context;
    //   11: astore_1
    //   12: goto -> 20
    //   15: aload_1
    //   16: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: putfield b : Landroid/content/Context;
    //   25: aload_0
    //   26: getfield a : Lcom/bytedance/sdk/openadsdk/core/f$c;
    //   29: ifnonnull -> 44
    //   32: aload_0
    //   33: new com/bytedance/sdk/openadsdk/core/f$c
    //   36: dup
    //   37: aload_0
    //   38: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f;)V
    //   41: putfield a : Lcom/bytedance/sdk/openadsdk/core/f$c;
    //   44: return
    //   45: astore_1
    //   46: return
    // Exception table:
    //   from	to	target	type
    //   8	12	45	finally
    //   15	20	45	finally
    //   20	44	45	finally
  }
  
  private Context c() {
    Context context2 = this.b;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  public c a() {
    return this.a;
  }
  
  class a extends SQLiteOpenHelper {
    final Context a;
    
    public a(f this$0, Context param1Context) {
      super(param1Context, "ttopensdk.db", null, 6);
      this.a = param1Context;
    }
    
    private void a(SQLiteDatabase param1SQLiteDatabase) {
      ArrayList<String> arrayList = b(param1SQLiteDatabase);
      if (arrayList != null && arrayList.size() > 0) {
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
          param1SQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", new Object[] { iterator.next() }));
        } 
      } 
    }
    
    private void a(SQLiteDatabase param1SQLiteDatabase, Context param1Context) {
      t.b("DBHelper", "initDB........");
      param1SQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.f.e());
      param1SQLiteDatabase.execSQL(n.g());
      param1SQLiteDatabase.execSQL(l.e());
      param1SQLiteDatabase.execSQL(g.b());
      param1SQLiteDatabase.execSQL(a.d());
    }
    
    private ArrayList<String> b(SQLiteDatabase param1SQLiteDatabase) {
      ArrayList<String> arrayList = new ArrayList();
      try {
        Cursor cursor = param1SQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
        if (cursor != null) {
          while (cursor.moveToNext()) {
            String str = cursor.getString(0);
            if (!str.equals("android_metadata") && !str.equals("sqlite_sequence"))
              arrayList.add(str); 
          } 
          cursor.close();
        } 
        return arrayList;
      } catch (Exception exception) {
        return arrayList;
      } 
    }
    
    public void onCreate(SQLiteDatabase param1SQLiteDatabase) {
      try {
        return;
      } finally {
        param1SQLiteDatabase = null;
      } 
    }
    
    public void onUpgrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onUpgrade....数据库版本升级.....old:");
        stringBuilder.append(param1Int1);
        stringBuilder.append(",new:");
        stringBuilder.append(param1Int2);
        t.b("DBHelper", stringBuilder.toString());
      } finally {
        param1SQLiteDatabase = null;
      } 
      if (param1Int1 != 1) {
        if (param1Int1 != 2) {
          if (param1Int1 != 3) {
            if (param1Int1 != 4) {
              if (param1Int1 != 5)
                return; 
              param1SQLiteDatabase.execSQL(l.e());
              return;
            } 
            param1SQLiteDatabase.execSQL(a.d());
            return;
          } 
          param1SQLiteDatabase.execSQL(n.g());
          return;
        } 
        param1SQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
        return;
      } 
      t.b("DBHelper", "onUpgrade.....执行表创建.....");
    }
  }
  
  class b extends AbstractCursor {
    private b(f this$0) {}
    
    public String[] getColumnNames() {
      return new String[0];
    }
    
    public int getCount() {
      return 0;
    }
    
    public double getDouble(int param1Int) {
      return 0.0D;
    }
    
    public float getFloat(int param1Int) {
      return 0.0F;
    }
    
    public int getInt(int param1Int) {
      return 0;
    }
    
    public long getLong(int param1Int) {
      return 0L;
    }
    
    public short getShort(int param1Int) {
      return 0;
    }
    
    public String getString(int param1Int) {
      return null;
    }
    
    public boolean isNull(int param1Int) {
      return true;
    }
  }
  
  public class c {
    private SQLiteDatabase b = null;
    
    public c(f this$0) {}
    
    private void d() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: invokestatic b : ()Ljava/lang/Object;
      //   5: astore_2
      //   6: aload_2
      //   7: monitorenter
      //   8: aload_0
      //   9: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   12: ifnull -> 25
      //   15: aload_0
      //   16: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   19: invokevirtual isOpen : ()Z
      //   22: ifne -> 58
      //   25: aload_0
      //   26: new com/bytedance/sdk/openadsdk/core/f$a
      //   29: dup
      //   30: aload_0
      //   31: getfield a : Lcom/bytedance/sdk/openadsdk/core/f;
      //   34: aload_0
      //   35: getfield a : Lcom/bytedance/sdk/openadsdk/core/f;
      //   38: invokestatic a : (Lcom/bytedance/sdk/openadsdk/core/f;)Landroid/content/Context;
      //   41: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f;Landroid/content/Context;)V
      //   44: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
      //   47: putfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   50: aload_0
      //   51: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   54: iconst_0
      //   55: invokevirtual setLockingEnabled : (Z)V
      //   58: aload_2
      //   59: monitorexit
      //   60: goto -> 82
      //   63: astore_3
      //   64: aload_2
      //   65: monitorexit
      //   66: aload_3
      //   67: athrow
      //   68: astore_2
      //   69: aload_2
      //   70: invokevirtual printStackTrace : ()V
      //   73: aload_0
      //   74: invokespecial e : ()Z
      //   77: istore_1
      //   78: iload_1
      //   79: ifne -> 85
      //   82: aload_0
      //   83: monitorexit
      //   84: return
      //   85: aload_2
      //   86: athrow
      //   87: astore_2
      //   88: aload_0
      //   89: monitorexit
      //   90: aload_2
      //   91: athrow
      // Exception table:
      //   from	to	target	type
      //   2	8	68	finally
      //   8	25	63	finally
      //   25	58	63	finally
      //   58	60	63	finally
      //   64	66	63	finally
      //   66	68	68	finally
      //   69	78	87	finally
      //   85	87	87	finally
    }
    
    private boolean e() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   6: astore_2
      //   7: aload_2
      //   8: ifnull -> 25
      //   11: aload_2
      //   12: invokevirtual inTransaction : ()Z
      //   15: istore_1
      //   16: iload_1
      //   17: ifeq -> 25
      //   20: iconst_1
      //   21: istore_1
      //   22: goto -> 27
      //   25: iconst_0
      //   26: istore_1
      //   27: aload_0
      //   28: monitorexit
      //   29: iload_1
      //   30: ireturn
      //   31: astore_2
      //   32: aload_0
      //   33: monitorexit
      //   34: aload_2
      //   35: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	31	finally
      //   11	16	31	finally
    }
    
    public int a(String param1String1, ContentValues param1ContentValues, String param1String2, String[] param1ArrayOfString) {
      boolean bool;
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      try {
        d();
        bool = this.b.update(param1String1, param1ContentValues, param1String2, param1ArrayOfString);
      } catch (Exception exception) {
        exception.printStackTrace();
        boolean bool1 = e();
        if (!bool1) {
          bool = false;
          /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
          return bool;
        } 
      } finally {}
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      return bool;
    }
    
    public int a(String param1String1, String param1String2, String[] param1ArrayOfString) {
      boolean bool;
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      try {
        d();
        bool = this.b.delete(param1String1, param1String2, param1ArrayOfString);
      } catch (Exception exception) {
        exception.printStackTrace();
        boolean bool1 = e();
        if (!bool1) {
          bool = false;
          /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
          return bool;
        } 
      } finally {}
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      return bool;
    }
    
    public long a(String param1String1, String param1String2, ContentValues param1ContentValues) {
      long l;
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      try {
        d();
        l = this.b.insert(param1String1, param1String2, param1ContentValues);
      } catch (Exception exception) {
        exception.printStackTrace();
        boolean bool = e();
        if (!bool) {
          l = -1L;
          /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
          return l;
        } 
      } finally {}
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{com/bytedance/sdk/openadsdk/core/f}.Lcom/bytedance/sdk/openadsdk/core/f$c;}} */
      return l;
    }
    
    public Cursor a(String param1String1, String[] param1ArrayOfString1, String param1String2, String[] param1ArrayOfString2, String param1String3, String param1String4, String param1String5) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial d : ()V
      //   6: aload_0
      //   7: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   10: aload_1
      //   11: aload_2
      //   12: aload_3
      //   13: aload #4
      //   15: aload #5
      //   17: aload #6
      //   19: aload #7
      //   21: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   24: astore_1
      //   25: goto -> 57
      //   28: astore_2
      //   29: aload_2
      //   30: invokevirtual printStackTrace : ()V
      //   33: new com/bytedance/sdk/openadsdk/core/f$b
      //   36: dup
      //   37: aload_0
      //   38: getfield a : Lcom/bytedance/sdk/openadsdk/core/f;
      //   41: aconst_null
      //   42: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/core/f;Lcom/bytedance/sdk/openadsdk/core/f$1;)V
      //   45: astore_1
      //   46: aload_0
      //   47: invokespecial e : ()Z
      //   50: istore #8
      //   52: iload #8
      //   54: ifne -> 61
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_1
      //   60: areturn
      //   61: aload_2
      //   62: athrow
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: athrow
      // Exception table:
      //   from	to	target	type
      //   2	25	28	finally
      //   29	52	63	finally
      //   61	63	63	finally
    }
    
    public void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial d : ()V
      //   6: aload_0
      //   7: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   10: astore_1
      //   11: aload_1
      //   12: ifnonnull -> 18
      //   15: aload_0
      //   16: monitorexit
      //   17: return
      //   18: aload_0
      //   19: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   22: invokevirtual beginTransaction : ()V
      //   25: aload_0
      //   26: monitorexit
      //   27: return
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	11	28	finally
      //   18	25	28	finally
    }
    
    public void a(String param1String) throws SQLException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial d : ()V
      //   6: aload_0
      //   7: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   10: aload_1
      //   11: invokevirtual execSQL : (Ljava/lang/String;)V
      //   14: goto -> 27
      //   17: astore_1
      //   18: aload_0
      //   19: invokespecial e : ()Z
      //   22: istore_2
      //   23: iload_2
      //   24: ifne -> 30
      //   27: aload_0
      //   28: monitorexit
      //   29: return
      //   30: aload_1
      //   31: athrow
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	17	finally
      //   18	23	32	finally
      //   30	32	32	finally
    }
    
    public void b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial d : ()V
      //   6: aload_0
      //   7: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   10: astore_1
      //   11: aload_1
      //   12: ifnonnull -> 18
      //   15: aload_0
      //   16: monitorexit
      //   17: return
      //   18: aload_0
      //   19: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   22: invokevirtual setTransactionSuccessful : ()V
      //   25: aload_0
      //   26: monitorexit
      //   27: return
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	11	28	finally
      //   18	25	28	finally
    }
    
    public void c() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial d : ()V
      //   6: aload_0
      //   7: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   10: astore_1
      //   11: aload_1
      //   12: ifnonnull -> 18
      //   15: aload_0
      //   16: monitorexit
      //   17: return
      //   18: aload_0
      //   19: getfield b : Landroid/database/sqlite/SQLiteDatabase;
      //   22: invokevirtual endTransaction : ()V
      //   25: aload_0
      //   26: monitorexit
      //   27: return
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	11	28	finally
      //   18	25	28	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */