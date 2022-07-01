package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class l11l1111I1l extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  l11l1111I1l(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    Uri uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    ContentResolver contentResolver = this.l1111l111111Il.getContentResolver();
    String str = "";
    if (contentResolver == null)
      return ""; 
    Cursor cursor = contentResolver.query(uri, null, null, null, null);
    if (cursor != null) {
      cursor.moveToNext();
      str = cursor.getString(cursor.getColumnIndex("value"));
      cursor.close();
    } 
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l11l1111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */