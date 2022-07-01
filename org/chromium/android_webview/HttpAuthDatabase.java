package org.chromium.android_webview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public final class HttpAuthDatabase {
  private static final String[] ID_PROJECTION = new String[] { "_id" };
  
  private SQLiteDatabase mDatabase;
  
  private boolean mInitialized;
  
  private final Object mInitializedLock = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static HttpAuthDatabase newInstance(Context paramContext, String paramString) {
    HttpAuthDatabase httpAuthDatabase = new HttpAuthDatabase();
    (new HttpAuthDatabase$1(httpAuthDatabase, paramContext, paramString)).start();
    return httpAuthDatabase;
  }
  
  private boolean waitForInit() {
    synchronized (this.mInitializedLock) {
      while (true) {
        boolean bool = this.mInitialized;
        if (!bool) {
          try {
            this.mInitializedLock.wait();
          } catch (InterruptedException interruptedException) {
            Log.e("HttpAuthDatabase", "Caught exception while checking initialization", interruptedException);
          } 
          continue;
        } 
        return (this.mDatabase != null);
      } 
    } 
  }
  
  public final void clearHttpAuthUsernamePassword() {
    if (!waitForInit())
      return; 
    this.mDatabase.delete("httpauth", null, null);
  }
  
  public final String[] getHttpAuthUsernamePassword(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull -> 204
    //   12: aload_2
    //   13: ifnull -> 204
    //   16: aload_0
    //   17: invokespecial waitForInit : ()Z
    //   20: ifne -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: getfield mDatabase : Landroid/database/sqlite/SQLiteDatabase;
    //   29: ldc 'httpauth'
    //   31: iconst_2
    //   32: anewarray java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 'username'
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc 'password'
    //   44: aastore
    //   45: ldc '(host == ?) AND (realm == ?)'
    //   47: iconst_2
    //   48: anewarray java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_2
    //   58: aastore
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: aload_2
    //   69: astore_3
    //   70: aload_2
    //   71: invokeinterface moveToFirst : ()Z
    //   76: ifeq -> 128
    //   79: aload_2
    //   80: astore_3
    //   81: aload_2
    //   82: aload_2
    //   83: ldc 'username'
    //   85: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   90: invokeinterface getString : (I)Ljava/lang/String;
    //   95: astore_1
    //   96: aload_2
    //   97: astore_3
    //   98: aload_2
    //   99: aload_2
    //   100: ldc 'password'
    //   102: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   107: invokeinterface getString : (I)Ljava/lang/String;
    //   112: astore #6
    //   114: iconst_2
    //   115: anewarray java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload #6
    //   126: aastore
    //   127: astore_1
    //   128: aload_1
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull -> 189
    //   134: aload_2
    //   135: astore_3
    //   136: aload_1
    //   137: astore_2
    //   138: aload_3
    //   139: invokeinterface close : ()V
    //   144: aload_2
    //   145: areturn
    //   146: astore_3
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: astore_2
    //   151: goto -> 163
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_3
    //   157: goto -> 192
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: astore_3
    //   165: ldc 'HttpAuthDatabase'
    //   167: ldc 'getHttpAuthUsernamePassword'
    //   169: aload_2
    //   170: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   173: pop
    //   174: aload #5
    //   176: astore_3
    //   177: aload_1
    //   178: ifnull -> 189
    //   181: aload #4
    //   183: astore_2
    //   184: aload_1
    //   185: astore_3
    //   186: goto -> 138
    //   189: aload_3
    //   190: areturn
    //   191: astore_1
    //   192: aload_3
    //   193: ifnull -> 202
    //   196: aload_3
    //   197: invokeinterface close : ()V
    //   202: aload_1
    //   203: athrow
    //   204: aconst_null
    //   205: areturn
    // Exception table:
    //   from	to	target	type
    //   25	66	160	java/lang/IllegalStateException
    //   25	66	154	finally
    //   70	79	146	java/lang/IllegalStateException
    //   70	79	191	finally
    //   81	96	146	java/lang/IllegalStateException
    //   81	96	191	finally
    //   98	114	146	java/lang/IllegalStateException
    //   98	114	191	finally
    //   165	174	191	finally
  }
  
  public final boolean hasHttpAuthUsernamePassword() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial waitForInit : ()Z
    //   4: ifne -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore #6
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: getfield mDatabase : Landroid/database/sqlite/SQLiteDatabase;
    //   18: ldc 'httpauth'
    //   20: getstatic org/chromium/android_webview/HttpAuthDatabase.ID_PROJECTION : [Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore #4
    //   33: aload #4
    //   35: invokeinterface moveToFirst : ()Z
    //   40: istore_2
    //   41: iload_2
    //   42: istore_1
    //   43: aload #4
    //   45: ifnull -> 112
    //   48: aload #4
    //   50: invokeinterface close : ()V
    //   55: iload_2
    //   56: ireturn
    //   57: astore_3
    //   58: goto -> 114
    //   61: astore_3
    //   62: aload_3
    //   63: astore #5
    //   65: goto -> 85
    //   68: astore #5
    //   70: aload_3
    //   71: astore #4
    //   73: aload #5
    //   75: astore_3
    //   76: goto -> 114
    //   79: astore #5
    //   81: aload #6
    //   83: astore #4
    //   85: aload #4
    //   87: astore_3
    //   88: ldc 'HttpAuthDatabase'
    //   90: ldc 'hasEntries'
    //   92: aload #5
    //   94: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: aload #4
    //   100: ifnull -> 110
    //   103: aload #4
    //   105: invokeinterface close : ()V
    //   110: iconst_0
    //   111: istore_1
    //   112: iload_1
    //   113: ireturn
    //   114: aload #4
    //   116: ifnull -> 126
    //   119: aload #4
    //   121: invokeinterface close : ()V
    //   126: aload_3
    //   127: athrow
    // Exception table:
    //   from	to	target	type
    //   14	33	79	java/lang/IllegalStateException
    //   14	33	68	finally
    //   33	41	61	java/lang/IllegalStateException
    //   33	41	57	finally
    //   88	98	68	finally
  }
  
  public final void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramString1 != null && paramString2 != null) {
      if (!waitForInit())
        return; 
      ContentValues contentValues = new ContentValues();
      contentValues.put("host", paramString1);
      contentValues.put("realm", paramString2);
      contentValues.put("username", paramString3);
      contentValues.put("password", paramString4);
      this.mDatabase.insert("httpauth", "host", contentValues);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\HttpAuthDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */