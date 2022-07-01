package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

class DocumentsContractApi19 {
  private static int a(Context paramContext, Uri paramUri, String paramString, int paramInt) {
    return (int)a(paramContext, paramUri, paramString, paramInt);
  }
  
  private static long a(Context paramContext, Uri paramUri, String paramString, long paramLong) {
    Cursor cursor1;
    ContentResolver contentResolver = paramContext.getContentResolver();
    Cursor cursor2 = null;
    paramContext = null;
    try {
      Cursor cursor = contentResolver.query(paramUri, new String[] { paramString }, null, null, null);
      cursor1 = cursor;
      cursor2 = cursor;
      if (cursor.moveToFirst()) {
        cursor1 = cursor;
        cursor2 = cursor;
        if (!cursor.isNull(0)) {
          cursor1 = cursor;
          cursor2 = cursor;
          long l = cursor.getLong(0);
          a((AutoCloseable)cursor);
          return l;
        } 
      } 
      a((AutoCloseable)cursor);
      return paramLong;
    } catch (Exception exception) {
      cursor1 = cursor2;
      StringBuilder stringBuilder = new StringBuilder();
      cursor1 = cursor2;
      stringBuilder.append("Failed query: ");
      cursor1 = cursor2;
      stringBuilder.append(exception);
      cursor1 = cursor2;
      Log.w("DocumentFile", stringBuilder.toString());
      a((AutoCloseable)cursor2);
      return paramLong;
    } finally {}
    a((AutoCloseable)cursor1);
    throw paramUri;
  }
  
  private static String a(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, "mime_type", (String)null);
  }
  
  private static String a(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    Cursor cursor1;
    ContentResolver contentResolver = paramContext.getContentResolver();
    Cursor cursor2 = null;
    paramContext = null;
    try {
      Cursor cursor = contentResolver.query(paramUri, new String[] { paramString1 }, null, null, null);
      cursor1 = cursor;
      cursor2 = cursor;
      if (cursor.moveToFirst()) {
        cursor1 = cursor;
        cursor2 = cursor;
        if (!cursor.isNull(0)) {
          cursor1 = cursor;
          cursor2 = cursor;
          paramString1 = cursor.getString(0);
          a((AutoCloseable)cursor);
          return paramString1;
        } 
      } 
      a((AutoCloseable)cursor);
      return paramString2;
    } catch (Exception exception) {
      cursor1 = cursor2;
      StringBuilder stringBuilder = new StringBuilder();
      cursor1 = cursor2;
      stringBuilder.append("Failed query: ");
      cursor1 = cursor2;
      stringBuilder.append(exception);
      cursor1 = cursor2;
      Log.w("DocumentFile", stringBuilder.toString());
      a((AutoCloseable)cursor2);
      return paramString2;
    } finally {}
    a((AutoCloseable)cursor1);
    throw paramUri;
  }
  
  private static void a(AutoCloseable paramAutoCloseable) {
    if (paramAutoCloseable != null)
      try {
        paramAutoCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public static boolean canRead(Context paramContext, Uri paramUri) {
    return (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) ? false : (!TextUtils.isEmpty(a(paramContext, paramUri)));
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri) {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0)
      return false; 
    String str = a(paramContext, paramUri);
    int i = a(paramContext, paramUri, "flags", 0);
    return TextUtils.isEmpty(str) ? false : (((i & 0x4) != 0) ? true : (("vnd.android.document/directory".equals(str) && (i & 0x8) != 0) ? true : ((!TextUtils.isEmpty(str) && (i & 0x2) != 0))));
  }
  
  public static boolean exists(Context paramContext, Uri paramUri) {
    Cursor cursor1;
    ContentResolver contentResolver = paramContext.getContentResolver();
    boolean bool = false;
    Cursor cursor2 = null;
    paramContext = null;
    try {
      Cursor cursor = contentResolver.query(paramUri, new String[] { "document_id" }, null, null, null);
      cursor1 = cursor;
      cursor2 = cursor;
      int i = cursor.getCount();
      if (i > 0)
        bool = true; 
      a((AutoCloseable)cursor);
      return bool;
    } catch (Exception exception) {
      cursor1 = cursor2;
      StringBuilder stringBuilder = new StringBuilder();
      cursor1 = cursor2;
      stringBuilder.append("Failed query: ");
      cursor1 = cursor2;
      stringBuilder.append(exception);
      cursor1 = cursor2;
      Log.w("DocumentFile", stringBuilder.toString());
      a((AutoCloseable)cursor2);
      return false;
    } finally {}
    a((AutoCloseable)cursor1);
    throw paramUri;
  }
  
  public static long getFlags(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, "flags", 0L);
  }
  
  public static String getName(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, "_display_name", (String)null);
  }
  
  public static String getType(Context paramContext, Uri paramUri) {
    String str2 = a(paramContext, paramUri);
    String str1 = str2;
    if ("vnd.android.document/directory".equals(str2))
      str1 = null; 
    return str1;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri) {
    return "vnd.android.document/directory".equals(a(paramContext, paramUri));
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri) {
    String str = a(paramContext, paramUri);
    return !("vnd.android.document/directory".equals(str) || TextUtils.isEmpty(str));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri) {
    boolean bool1 = DocumentsContract.isDocumentUri(paramContext, paramUri);
    boolean bool = false;
    if (!bool1)
      return false; 
    if ((getFlags(paramContext, paramUri) & 0x200L) != 0L)
      bool = true; 
    return bool;
  }
  
  public static long lastModified(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri) {
    return a(paramContext, paramUri, "_size", 0L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\documentfile\provider\DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */