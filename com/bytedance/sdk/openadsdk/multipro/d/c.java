package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a;
import java.util.Map;

public class c implements a {
  private Context a;
  
  private Context c() {
    Context context2 = this.a;
    Context context1 = context2;
    if (context2 == null)
      context1 = o.a(); 
    return context1;
  }
  
  public int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    if (paramContentValues == null)
      return 0; 
    a(paramUri, paramContentValues);
    return 0;
  }
  
  public int a(Uri paramUri, String paramString, String[] paramArrayOfString) {
    String[] arrayOfString = paramUri.getPath().split("/");
    if (arrayOfString[2].equals("clean")) {
      b.a(c(), paramUri.getQueryParameter("sp_file_name"));
      return 0;
    } 
    String str = arrayOfString[3];
    if (b.a(c(), paramUri.getQueryParameter("sp_file_name"), str))
      b.b(c(), paramUri.getQueryParameter("sp_file_name"), str); 
    return 0;
  }
  
  public Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    if (paramUri.getPath().split("/")[2].equals("get_all")) {
      Map<String, ?> map = b.b(c(), paramUri.getQueryParameter("sp_file_name"));
      if (map != null) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[] { "cursor_name", "cursor_type", "cursor_value" });
        for (String str : map.keySet()) {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = str;
          arrayOfObject[2] = map.get(str);
          if (arrayOfObject[2] instanceof Boolean) {
            arrayOfObject[1] = "boolean";
          } else if (arrayOfObject[2] instanceof String) {
            arrayOfObject[1] = "string";
          } else if (arrayOfObject[2] instanceof Integer) {
            arrayOfObject[1] = "int";
          } else if (arrayOfObject[2] instanceof Long) {
            arrayOfObject[1] = "long";
          } else if (arrayOfObject[2] instanceof Float) {
            arrayOfObject[1] = "float";
          } 
          matrixCursor.addRow(arrayOfObject);
        } 
        return (Cursor)matrixCursor;
      } 
    } 
    return null;
  }
  
  public Uri a(Uri paramUri, ContentValues paramContentValues) {
    if (paramContentValues == null)
      return null; 
    String[] arrayOfString = paramUri.getPath().split("/");
    String str2 = arrayOfString[2];
    String str1 = arrayOfString[3];
    Object object = paramContentValues.get("value");
    if (object != null)
      b.a(c(), paramUri.getQueryParameter("sp_file_name"), str1, object); 
    return null;
  }
  
  public String a() {
    return "t_sp";
  }
  
  public String a(Uri paramUri) {
    StringBuilder stringBuilder1;
    String[] arrayOfString = paramUri.getPath().split("/");
    String str1 = arrayOfString[2];
    String str2 = arrayOfString[3];
    if (str1.equals("contain")) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(b.a(o.a(), paramUri.getQueryParameter("sp_file_name"), str2));
      stringBuilder1.append("");
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(b.a(c(), paramUri.getQueryParameter("sp_file_name"), str2, (String)stringBuilder1));
    return stringBuilder2.toString();
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */