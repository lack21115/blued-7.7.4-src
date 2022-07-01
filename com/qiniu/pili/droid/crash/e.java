package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.os.DropBoxManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

class e {
  private static final String[] a = new String[] { 
      "system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", 
      "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode" };
  
  private static String b = "N/A";
  
  private SimpleDateFormat c = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
  
  String a(Context paramContext) {
    try {
      DropBoxManager dropBoxManager = (DropBoxManager)paramContext.getSystemService("dropbox");
      Calendar calendar = Calendar.getInstance();
      calendar.roll(12, -1);
      long l = calendar.getTimeInMillis();
      this.c.format(calendar.getTime());
      ArrayList arrayList = new ArrayList(Arrays.asList((Object[])a));
      if (arrayList.isEmpty())
        return "No tag configured for collection."; 
      StringBuilder stringBuilder = new StringBuilder();
      for (String str : arrayList) {
        stringBuilder.append("Tag: ");
        stringBuilder.append(str);
        stringBuilder.append('\n');
        DropBoxManager.Entry entry2 = dropBoxManager.getNextEntry(str, l);
        DropBoxManager.Entry entry1 = entry2;
        if (entry2 == null) {
          stringBuilder.append("Nothing.");
          stringBuilder.append('\n');
          continue;
        } 
        while (entry1 != null) {
          long l1 = entry1.getTimeMillis();
          calendar.setTimeInMillis(l1);
          stringBuilder.append('@');
          stringBuilder.append(this.c.format(calendar.getTime()));
          stringBuilder.append('\n');
          String str1 = entry1.getText(500);
          if (str1 != null) {
            stringBuilder.append("Text: ");
            stringBuilder.append(str1);
            stringBuilder.append('\n');
          } else {
            stringBuilder.append("Not Text!");
            stringBuilder.append('\n');
          } 
          entry1.close();
          entry1 = dropBoxManager.getNextEntry(str, l1);
        } 
      } 
      return stringBuilder.toString();
    } catch (Exception exception) {
      return b;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */