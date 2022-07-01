package com.soft.blued.utils.third;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class HuaweiChannelUtils {
  public static String a(Context paramContext) {
    null = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
    ContentResolver contentResolver1 = paramContext.getContentResolver();
    ContentResolver contentResolver2 = null;
    try {
      Cursor cursor1;
      ContentResolver contentResolver;
      Cursor cursor2 = contentResolver1.query(null, null, null, new String[] { "com.soft.blued" }, null);
      contentResolver1 = contentResolver2;
      if (cursor2 != null)
        try {
          cursor2.moveToFirst();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("packageName=");
          stringBuilder.append("com.soft.blued");
          Log.i("HuaweiChannelUtils", stringBuilder.toString());
        } finally {
          contentResolver2 = null;
          cursor1 = cursor2;
        }  
      return (String)cursor1;
    } finally {
      contentResolver1 = null;
      if (contentResolver1 != null)
        contentResolver1.close(); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\HuaweiChannelUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */