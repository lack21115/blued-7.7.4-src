package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.h.j;

public class TTMultiProvider extends ContentProvider {
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString) {
    return !j.a() ? 0 : f.b(getContext()).a(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri) {
    return !j.a() ? null : f.b(getContext()).a(paramUri);
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues) {
    return !j.a() ? null : f.b(getContext()).a(paramUri, paramContentValues);
  }
  
  public boolean onCreate() {
    if (!j.a())
      return false; 
    f.b(getContext()).a(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    return !j.a() ? null : f.b(getContext()).a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString) {
    return !j.a() ? 0 : f.b(getContext()).a(paramUri, paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\TTMultiProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */