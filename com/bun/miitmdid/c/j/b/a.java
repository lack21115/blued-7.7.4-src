package com.bun.miitmdid.c.j.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class a {
  private Context a;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  public String a(int paramInt, String paramString) {
    Uri uri1;
    Uri uri2 = null;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          paramString = null;
        } else {
          uri1 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + paramString);
        } 
      } else {
        uri1 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + uri1);
      } 
    } else {
      uri1 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    } 
    Cursor cursor = this.a.getContentResolver().query(uri1, null, null, null, null);
    if (cursor != null) {
      String str;
      uri1 = uri2;
      if (cursor.moveToNext())
        str = cursor.getString(cursor.getColumnIndex("value")); 
      cursor.close();
      return str;
    } 
    com.bun.lib.a.a("VMS_IDLG_SDK_DB", "return cursor is null,return");
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\j\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */