package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public interface a {
  int a(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString);
  
  int a(Uri paramUri, String paramString, String[] paramArrayOfString);
  
  Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  Uri a(Uri paramUri, ContentValues paramContentValues);
  
  String a();
  
  String a(Uri paramUri);
  
  void a(Context paramContext);
  
  void b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */