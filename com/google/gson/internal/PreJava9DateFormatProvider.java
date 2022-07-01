package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class PreJava9DateFormatProvider {
  private static String getDateFormatPattern(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3)
            return "M/d/yy"; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown DateFormat style: ");
          stringBuilder.append(paramInt);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return "MMM d, y";
      } 
      return "MMMM d, y";
    } 
    return "EEEE, MMMM d, y";
  }
  
  private static String getDatePartOfDateTimePattern(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt == 3)
            return "M/d/yy"; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown DateFormat style: ");
          stringBuilder.append(paramInt);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        return "MMM d, yyyy";
      } 
      return "MMMM d, yyyy";
    } 
    return "EEEE, MMMM d, yyyy";
  }
  
  private static String getTimePartOfDateTimePattern(int paramInt) {
    if (paramInt != 0 && paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt == 3)
          return "h:mm a"; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown DateFormat style: ");
        stringBuilder.append(paramInt);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return "h:mm:ss a";
    } 
    return "h:mm:ss a z";
  }
  
  public static DateFormat getUSDateFormat(int paramInt) {
    return new SimpleDateFormat(getDateFormatPattern(paramInt), Locale.US);
  }
  
  public static DateFormat getUSDateTimeFormat(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getDatePartOfDateTimePattern(paramInt1));
    stringBuilder.append(" ");
    stringBuilder.append(getTimePartOfDateTimePattern(paramInt2));
    return new SimpleDateFormat(stringBuilder.toString(), Locale.US);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\PreJava9DateFormatProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */