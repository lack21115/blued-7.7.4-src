package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class l111l11111Il extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  l111l11111Il(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  public final String l1111l111111Il() {
    String str = "";
    try {
      Uri uri = Uri.parse("content://com.meizu.flyme.openidsdk/");
      Cursor cursor = this.l1111l111111Il.getContentResolver().query(uri, null, null, new String[] { "oaid" }, null);
      return str;
    } finally {
      str = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l11111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */