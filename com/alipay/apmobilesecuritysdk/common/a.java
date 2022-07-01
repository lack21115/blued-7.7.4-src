package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class a {
  public static boolean a(Context paramContext) {
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(h.e(paramContext));
    return a(arrayList) ? true : (a(new RushTimeUtil$1()));
  }
  
  private static boolean a(List<String> paramList) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    simpleDateFormat.setLenient(false);
    int i = (int)(Math.random() * 24.0D * 60.0D * 60.0D);
    try {
      Iterator<String> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        String[] arrayOfString = ((String)iterator.next()).split("&");
        if (arrayOfString != null && arrayOfString.length == 2) {
          Date date1 = new Date();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(arrayOfString[0]);
          stringBuilder1.append(" 00:00:00");
          Date date2 = simpleDateFormat.parse(stringBuilder1.toString());
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(arrayOfString[1]);
          stringBuilder2.append(" 23:59:59");
          Date date3 = simpleDateFormat.parse(stringBuilder2.toString());
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(date3);
          calendar.add(13, i * 1);
          date3 = calendar.getTime();
          if (date1.after(date2)) {
            boolean bool = date1.before(date3);
            if (bool)
              return true; 
          } 
        } 
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\common\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */