package com.pgl.sys.ces;

import android.content.Context;
import com.pgl.a.b.a;
import com.pgl.sys.ces.a.a;
import java.security.MessageDigest;
import java.util.Calendar;

public final class c {
  public static String a() {
    try {
      Context context;
      if ((b.a()).b != null) {
        context = (b.a()).b;
      } else {
        context = a.a().getApplicationContext();
      } 
      return a.a(MessageDigest.getInstance("SHA1").digest(arrayOfByte)).toUpperCase();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static String a(String paramString) {
    int i = (int)(Calendar.getInstance().getTimeInMillis() / 1000L);
    b.a();
    String str1 = b.b();
    String str2 = b.c();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("_");
      stringBuilder.append(str1);
      stringBuilder.append("_");
      stringBuilder.append(str2);
      stringBuilder.append("_");
      return a.a((byte[])a.meta(601, null, stringBuilder.toString().getBytes()));
    } finally {
      paramString = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */