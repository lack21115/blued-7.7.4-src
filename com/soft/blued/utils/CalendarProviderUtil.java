package com.soft.blued.utils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarProviderUtil {
  private static String a = "content://com.android.calendar/calendars";
  
  private static String b = "content://com.android.calendar/events";
  
  private static String c = "content://com.android.calendar/reminders";
  
  private static String d = "BluedCalendars";
  
  private static String e = "BluedAccount";
  
  private static String f = "com.soft.blued";
  
  private static String g = "Blued";
  
  private static int a(Context paramContext) {
    int i = b(paramContext);
    return (i >= 0) ? i : ((c(paramContext) >= 0L) ? b(paramContext) : -1);
  }
  
  public static void a(Context paramContext, String paramString) {
    if (paramContext == null)
      return; 
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse(b), null, null, null, null);
    if (cursor == null) {
      if (cursor != null)
        cursor.close(); 
      return;
    } 
    try {
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
          String str = cursor.getString(cursor.getColumnIndex("title"));
          if (!TextUtils.isEmpty(paramString) && paramString.equals(str)) {
            int i = cursor.getInt(cursor.getColumnIndex("_id"));
            Uri uri = ContentUris.withAppendedId(Uri.parse(b), i);
            i = paramContext.getContentResolver().delete(uri, null, null);
            if (i == -1)
              return; 
          } 
          cursor.moveToNext();
        } 
      } 
      return;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          if (paramInt1 == 4)
            stringBuilder.append("FREQ=YEARLY"); 
        } else {
          stringBuilder.append("FREQ=MONTHLY");
        } 
      } else {
        stringBuilder.append("FREQ=WEEKLY");
      } 
    } else {
      stringBuilder.append("FREQ=DAILY");
    } 
    if (stringBuilder.length() > 0) {
      if (paramInt2 > 0) {
        stringBuilder.append(";INTERVAL=");
        stringBuilder.append(paramInt2);
      } 
      if (paramInt3 > 0) {
        stringBuilder.append(";COUNT=");
        stringBuilder.append(paramInt3);
      } 
    } 
    PermissionHelper.a(new PermissionCallbacks(paramContext, paramString1, paramString2, paramLong1, paramLong2, paramLong3, stringBuilder) {
          public void a(String[] param1ArrayOfString) {
            EventTrackGuy.b(GuyProtos.Event.CHECK_IN_REMIND_STATUS, false);
          }
          
          public void aa_() {
            EventTrackGuy.b(GuyProtos.Event.CHECK_IN_REMIND_STATUS, true);
            CalendarProviderUtil.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g.toString());
          }
        });
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, String paramString3) {
    if (paramContext == null) {
      if (AppInfo.m())
        AppMethods.a("Error 1"); 
      return;
    } 
    int i = a(paramContext);
    if (i < 0) {
      if (AppInfo.m())
        AppMethods.a("Error 2"); 
      return;
    } 
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong1);
    long l = calendar.getTime().getTime();
    if (paramLong2 >= paramLong1)
      calendar.setTimeInMillis(paramLong2); 
    paramLong1 = calendar.getTime().getTime();
    ContentValues contentValues2 = new ContentValues();
    contentValues2.put("title", paramString1);
    contentValues2.put("description", paramString2);
    contentValues2.put("calendar_id", Integer.valueOf(i));
    contentValues2.put("dtstart", Long.valueOf(l));
    contentValues2.put("dtend", Long.valueOf(paramLong1));
    contentValues2.put("hasAlarm", Integer.valueOf(1));
    contentValues2.put("rrule", paramString3);
    contentValues2.put("eventTimezone", "Asia/Shanghai");
    Uri uri = paramContext.getContentResolver().insert(Uri.parse(b), contentValues2);
    if (uri == null) {
      if (AppInfo.m())
        AppMethods.a("Error 3"); 
      return;
    } 
    ContentValues contentValues1 = new ContentValues();
    contentValues1.put("event_id", Long.valueOf(ContentUris.parseId(uri)));
    contentValues1.put("minutes", Long.valueOf(paramLong3));
    contentValues1.put("method", Integer.valueOf(1));
    if (paramContext.getContentResolver().insert(Uri.parse(c), contentValues1) == null && AppInfo.m())
      AppMethods.a("Error 4"); 
  }
  
  private static int b(Context paramContext) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse(a), null, null, null, null);
    if (cursor == null) {
      if (cursor != null)
        cursor.close(); 
      return -1;
    } 
    try {
      if (cursor.getCount() > 0) {
        cursor.moveToFirst();
        return cursor.getInt(cursor.getColumnIndex("_id"));
      } 
      return -1;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  private static long c(Context paramContext) {
    TimeZone timeZone = TimeZone.getDefault();
    ContentValues contentValues = new ContentValues();
    contentValues.put("name", d);
    contentValues.put("account_name", e);
    contentValues.put("account_type", f);
    contentValues.put("calendar_displayName", g);
    Integer integer = Integer.valueOf(1);
    contentValues.put("visible", integer);
    contentValues.put("calendar_color", Integer.valueOf(-16776961));
    contentValues.put("calendar_access_level", Integer.valueOf(700));
    contentValues.put("sync_events", integer);
    contentValues.put("calendar_timezone", timeZone.getID());
    contentValues.put("ownerAccount", e);
    contentValues.put("canOrganizerRespond", Integer.valueOf(0));
    Uri uri2 = Uri.parse(a).buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", e).appendQueryParameter("account_type", f).build();
    Uri uri1 = paramContext.getContentResolver().insert(uri2, contentValues);
    return (uri1 == null) ? -1L : ContentUris.parseId(uri1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\CalendarProviderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */