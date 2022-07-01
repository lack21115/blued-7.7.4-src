package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
  private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
  
  private static final String UTC_ID = "UTC";
  
  private static boolean checkOffset(String paramString, int paramInt, char paramChar) {
    return (paramInt < paramString.length() && paramString.charAt(paramInt) == paramChar);
  }
  
  public static String format(Date paramDate) {
    return format(paramDate, false, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean) {
    return format(paramDate, paramBoolean, TIMEZONE_UTC);
  }
  
  public static String format(Date paramDate, boolean paramBoolean, TimeZone paramTimeZone) {
    int j;
    GregorianCalendar gregorianCalendar = new GregorianCalendar(paramTimeZone, Locale.US);
    gregorianCalendar.setTime(paramDate);
    if (paramBoolean) {
      i = 4;
    } else {
      i = 0;
    } 
    if (paramTimeZone.getRawOffset() == 0) {
      j = 1;
    } else {
      j = 6;
    } 
    StringBuilder stringBuilder = new StringBuilder(19 + i + j);
    padInt(stringBuilder, gregorianCalendar.get(1), 4);
    byte b = 45;
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(2) + 1, 2);
    stringBuilder.append('-');
    padInt(stringBuilder, gregorianCalendar.get(5), 2);
    stringBuilder.append('T');
    padInt(stringBuilder, gregorianCalendar.get(11), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(12), 2);
    stringBuilder.append(':');
    padInt(stringBuilder, gregorianCalendar.get(13), 2);
    if (paramBoolean) {
      stringBuilder.append('.');
      padInt(stringBuilder, gregorianCalendar.get(14), 3);
    } 
    int i = paramTimeZone.getOffset(gregorianCalendar.getTimeInMillis());
    if (i != 0) {
      int k = i / 60000;
      j = Math.abs(k / 60);
      k = Math.abs(k % 60);
      if (i >= 0)
        b = 43; 
      stringBuilder.append(b);
      padInt(stringBuilder, j, 2);
      stringBuilder.append(':');
      padInt(stringBuilder, k, 2);
    } else {
      stringBuilder.append('Z');
    } 
    return stringBuilder.toString();
  }
  
  private static int indexOfNonDigit(String paramString, int paramInt) {
    while (paramInt < paramString.length()) {
      char c = paramString.charAt(paramInt);
      if (c >= '0') {
        if (c > '9')
          return paramInt; 
        paramInt++;
        continue;
      } 
      return paramInt;
    } 
    return paramString.length();
  }
  
  private static void padInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    String str = Integer.toString(paramInt1);
    for (paramInt1 = paramInt2 - str.length(); paramInt1 > 0; paramInt1--)
      paramStringBuilder.append('0'); 
    paramStringBuilder.append(str);
  }
  
  public static Date parse(String paramString, ParsePosition paramParsePosition) throws ParseException {
    try {
      int i = paramParsePosition.getIndex();
      int j = i + 4;
      int k = parseInt(paramString, i, j);
      i = j;
      if (checkOffset(paramString, j, '-'))
        i = j + 1; 
      j = i + 2;
      int m = parseInt(paramString, i, j);
      i = j;
      if (checkOffset(paramString, j, '-'))
        i = j + 1; 
      j = i + 2;
      int n = parseInt(paramString, i, j);
      boolean bool = checkOffset(paramString, j, 'T');
      if (!bool && paramString.length() <= j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(k, m - 1, n);
        paramParsePosition.setIndex(j);
        return gregorianCalendar.getTime();
      } 
      if (bool) {
        i = j + 1;
        j = i + 2;
        int i1 = parseInt(paramString, i, j);
        i = j;
        if (checkOffset(paramString, j, ':'))
          i = j + 1; 
        j = i + 2;
        int i2 = parseInt(paramString, i, j);
        int i3 = j;
        if (checkOffset(paramString, j, ':'))
          i3 = j + 1; 
        j = i1;
        bool3 = i2;
        i = i3;
        if (paramString.length() > i3) {
          char c = paramString.charAt(i3);
          j = i1;
          bool3 = i2;
          i = i3;
          if (c != 'Z') {
            j = i1;
            bool3 = i2;
            i = i3;
            if (c != '+') {
              j = i1;
              bool3 = i2;
              i = i3;
              if (c != '-') {
                char c1;
                bool3 = i3 + 2;
                j = parseInt(paramString, i3, bool3);
                i = j;
                if (j > 59) {
                  i = j;
                  if (j < 63)
                    i = 59; 
                } 
                if (checkOffset(paramString, bool3, '.')) {
                  int i4 = indexOfNonDigit(paramString, ++bool3 + 1);
                  i3 = Math.min(i4, bool3 + 3);
                  j = parseInt(paramString, bool3, i3);
                  bool3 = i3 - bool3;
                  if (bool3 != true) {
                    if (bool3 == 2)
                      j *= 10; 
                  } else {
                    j *= 100;
                  } 
                  bool3 = j;
                  i3 = i;
                  i = i4;
                  j = i1;
                  i1 = i3;
                } else {
                  j = i1;
                  i1 = i;
                  i = bool3;
                  bool3 = false;
                } 
                if (paramString.length() > i) {
                  c1 = paramString.charAt(i);
                  if (c1 == 'Z') {
                    TimeZone timeZone = TIMEZONE_UTC;
                    i++;
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, k);
                    gregorianCalendar.set(2, m - 1);
                    gregorianCalendar.set(5, n);
                    gregorianCalendar.set(11, j);
                    gregorianCalendar.set(12, i2);
                    gregorianCalendar.set(13, i1);
                    gregorianCalendar.set(14, bool3);
                    paramParsePosition.setIndex(i);
                    return gregorianCalendar.getTime();
                  } 
                } else {
                  throw new IllegalArgumentException("No time zone indicator");
                } 
                if (c1 == '+' || c1 == '-') {
                  GregorianCalendar gregorianCalendar2;
                  String str1 = paramString.substring(i);
                  if (str1.length() < 5) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str1);
                    stringBuilder2.append("00");
                    str1 = stringBuilder2.toString();
                  } 
                  i += str1.length();
                  if ("+0000".equals(str1) || "+00:00".equals(str1)) {
                    TimeZone timeZone1 = TIMEZONE_UTC;
                    gregorianCalendar2 = new GregorianCalendar(timeZone1);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(1, k);
                    gregorianCalendar2.set(2, m - 1);
                    gregorianCalendar2.set(5, n);
                    gregorianCalendar2.set(11, j);
                    gregorianCalendar2.set(12, i2);
                    gregorianCalendar2.set(13, i1);
                    gregorianCalendar2.set(14, bool3);
                    paramParsePosition.setIndex(i);
                    return gregorianCalendar2.getTime();
                  } 
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("GMT");
                  stringBuilder1.append((String)gregorianCalendar2);
                  String str2 = stringBuilder1.toString();
                  TimeZone timeZone = TimeZone.getTimeZone(str2);
                  String str3 = timeZone.getID();
                  if (!str3.equals(str2) && !str3.replace(":", "").equals(str2)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Mismatching time zone indicator: ");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(" given, resolves to ");
                    stringBuilder2.append(timeZone.getID());
                    throw new IndexOutOfBoundsException(stringBuilder2.toString());
                  } 
                  GregorianCalendar gregorianCalendar1 = new GregorianCalendar(timeZone);
                  gregorianCalendar1.setLenient(false);
                  gregorianCalendar1.set(1, k);
                  gregorianCalendar1.set(2, m - 1);
                  gregorianCalendar1.set(5, n);
                  gregorianCalendar1.set(11, j);
                  gregorianCalendar1.set(12, i2);
                  gregorianCalendar1.set(13, i1);
                  gregorianCalendar1.set(14, bool3);
                  paramParsePosition.setIndex(i);
                  return gregorianCalendar1.getTime();
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid time zone indicator '");
                stringBuilder.append(c1);
                stringBuilder.append("'");
                throw new IndexOutOfBoundsException(stringBuilder.toString());
              } 
            } 
          } 
        } 
      } else {
        i = j;
        j = 0;
        bool3 = false;
      } 
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      if (paramString == null) {
        paramString = null;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('"');
        stringBuilder.append(paramString);
        stringBuilder.append('"');
        paramString = stringBuilder.toString();
      } 
      String str2 = indexOutOfBoundsException.getMessage();
      if (str2 != null) {
        String str = str2;
        if (str2.isEmpty()) {
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append("(");
          stringBuilder3.append(indexOutOfBoundsException.getClass().getName());
          stringBuilder3.append(")");
          str = stringBuilder3.toString();
          StringBuilder stringBuilder4 = new StringBuilder();
          stringBuilder4.append("Failed to parse date [");
          stringBuilder4.append(paramString);
          stringBuilder4.append("]: ");
          stringBuilder4.append(str);
          parseException = new ParseException(stringBuilder4.toString(), paramParsePosition.getIndex());
          parseException.initCause(indexOutOfBoundsException);
          throw parseException;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to parse date [");
        stringBuilder.append((String)parseException);
        stringBuilder.append("]: ");
        stringBuilder.append(str);
        parseException = new ParseException(stringBuilder.toString(), paramParsePosition.getIndex());
        parseException.initCause(indexOutOfBoundsException);
        throw parseException;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("(");
      stringBuilder1.append(indexOutOfBoundsException.getClass().getName());
      stringBuilder1.append(")");
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Failed to parse date [");
      stringBuilder2.append((String)parseException);
      stringBuilder2.append("]: ");
      stringBuilder2.append(str1);
      ParseException parseException = new ParseException(stringBuilder2.toString(), paramParsePosition.getIndex());
      parseException.initCause(indexOutOfBoundsException);
      throw parseException;
    } catch (NumberFormatException numberFormatException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {}
    boolean bool1 = false;
    boolean bool2 = bool3;
    boolean bool3 = false;
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2) throws NumberFormatException {
    if (paramInt1 >= 0 && paramInt2 <= paramString.length() && paramInt1 <= paramInt2) {
      int i;
      int j;
      if (paramInt1 < paramInt2) {
        i = paramInt1 + 1;
        j = Character.digit(paramString.charAt(paramInt1), 10);
        if (j >= 0) {
          j = -j;
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid number: ");
          stringBuilder.append(paramString.substring(paramInt1, paramInt2));
          throw new NumberFormatException(stringBuilder.toString());
        } 
      } else {
        i = paramInt1;
        j = 0;
      } 
      while (i < paramInt2) {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k >= 0) {
          j = j * 10 - k;
          i++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid number: ");
        stringBuilder.append(paramString.substring(paramInt1, paramInt2));
        throw new NumberFormatException(stringBuilder.toString());
      } 
      return -j;
    } 
    throw new NumberFormatException(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\bin\\util\ISO8601Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */