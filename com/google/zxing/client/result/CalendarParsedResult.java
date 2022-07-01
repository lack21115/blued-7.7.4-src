package com.google.zxing.client.result;

import java.text.DateFormat;
import java.util.regex.Pattern;

public final class CalendarParsedResult extends ParsedResult {
  private static final Pattern a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
  
  private static final long[] b = new long[] { 604800000L, 86400000L, 3600000L, 60000L, 1000L };
  
  private static final Pattern c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
  
  private final String d;
  
  private final long e;
  
  private final boolean f;
  
  private final long g;
  
  private final boolean h;
  
  private final String i;
  
  private final String j;
  
  private final String[] k;
  
  private final String l;
  
  private static String a(boolean paramBoolean, long paramLong) {
    DateFormat dateFormat;
    if (paramLong < 0L)
      return null; 
    if (paramBoolean) {
      dateFormat = DateFormat.getDateInstance(2);
    } else {
      dateFormat = DateFormat.getDateTimeInstance(2, 2);
    } 
    return dateFormat.format(Long.valueOf(paramLong));
  }
  
  public String a() {
    StringBuilder stringBuilder = new StringBuilder(100);
    a(this.d, stringBuilder);
    a(a(this.f, this.e), stringBuilder);
    a(a(this.h, this.g), stringBuilder);
    a(this.i, stringBuilder);
    a(this.j, stringBuilder);
    a(this.k, stringBuilder);
    a(this.l, stringBuilder);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\client\result\CalendarParsedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */