package com.google.protobuf.util;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class Timestamps {
  private static final Comparator<Timestamp> COMPARATOR;
  
  public static final Timestamp MAX_VALUE;
  
  static final long MICROS_PER_SECOND = 1000000L;
  
  static final long MILLIS_PER_SECOND = 1000L;
  
  public static final Timestamp MIN_VALUE = Timestamp.newBuilder().setSeconds(-62135596800L).setNanos(0).build();
  
  static final long NANOS_PER_MICROSECOND = 1000L;
  
  static final long NANOS_PER_MILLISECOND = 1000000L;
  
  static final long NANOS_PER_SECOND = 1000000000L;
  
  static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
  
  static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
  
  private static final ThreadLocal<SimpleDateFormat> timestampFormat;
  
  static {
    MAX_VALUE = Timestamp.newBuilder().setSeconds(253402300799L).setNanos(999999999).build();
    timestampFormat = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
          return Timestamps.createTimestampFormat();
        }
      };
    COMPARATOR = new Comparator<Timestamp>() {
        public int compare(Timestamp param1Timestamp1, Timestamp param1Timestamp2) {
          Timestamps.checkValid(param1Timestamp1);
          Timestamps.checkValid(param1Timestamp2);
          int i = Long.compare(param1Timestamp1.getSeconds(), param1Timestamp2.getSeconds());
          return (i != 0) ? i : Integer.compare(param1Timestamp1.getNanos(), param1Timestamp2.getNanos());
        }
      };
  }
  
  public static Timestamp add(Timestamp paramTimestamp, Duration paramDuration) {
    checkValid(paramTimestamp);
    Durations.checkValid(paramDuration);
    return normalizedTimestamp(LongMath.a(paramTimestamp.getSeconds(), paramDuration.getSeconds()), IntMath.b(paramTimestamp.getNanos(), paramDuration.getNanos()));
  }
  
  public static Duration between(Timestamp paramTimestamp1, Timestamp paramTimestamp2) {
    checkValid(paramTimestamp1);
    checkValid(paramTimestamp2);
    return Durations.normalizedDuration(LongMath.b(paramTimestamp2.getSeconds(), paramTimestamp1.getSeconds()), IntMath.c(paramTimestamp2.getNanos(), paramTimestamp1.getNanos()));
  }
  
  public static Timestamp checkValid(Timestamp paramTimestamp) {
    long l = paramTimestamp.getSeconds();
    int i = paramTimestamp.getNanos();
    if (isValid(l, i))
      return paramTimestamp; 
    throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
  }
  
  public static Comparator<Timestamp> comparator() {
    return COMPARATOR;
  }
  
  public static int compare(Timestamp paramTimestamp1, Timestamp paramTimestamp2) {
    return COMPARATOR.compare(paramTimestamp1, paramTimestamp2);
  }
  
  private static SimpleDateFormat createTimestampFormat() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
    simpleDateFormat.setCalendar(gregorianCalendar);
    return simpleDateFormat;
  }
  
  static String formatNanos(int paramInt) {
    long l = paramInt;
    return (l % 1000000L == 0L) ? String.format(Locale.ENGLISH, "%1$03d", new Object[] { Long.valueOf(l / 1000000L) }) : ((l % 1000L == 0L) ? String.format(Locale.ENGLISH, "%1$06d", new Object[] { Long.valueOf(l / 1000L) }) : String.format(Locale.ENGLISH, "%1$09d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static Timestamp fromMicros(long paramLong) {
    return normalizedTimestamp(paramLong / 1000000L, (int)(paramLong % 1000000L * 1000L));
  }
  
  public static Timestamp fromMillis(long paramLong) {
    return normalizedTimestamp(paramLong / 1000L, (int)(paramLong % 1000L * 1000000L));
  }
  
  public static Timestamp fromNanos(long paramLong) {
    return normalizedTimestamp(paramLong / 1000000000L, (int)(paramLong % 1000000000L));
  }
  
  public static Timestamp fromSeconds(long paramLong) {
    return normalizedTimestamp(paramLong, 0);
  }
  
  public static boolean isValid(long paramLong, int paramInt) {
    if (paramLong >= -62135596800L) {
      if (paramLong > 253402300799L)
        return false; 
      if (paramInt >= 0)
        return !(paramInt >= 1000000000L); 
    } 
    return false;
  }
  
  public static boolean isValid(Timestamp paramTimestamp) {
    return isValid(paramTimestamp.getSeconds(), paramTimestamp.getNanos());
  }
  
  static Timestamp normalizedTimestamp(long paramLong, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: i2l
    //   2: lstore #6
    //   4: lload #6
    //   6: ldc2_w -1000000000
    //   9: lcmp
    //   10: ifle -> 25
    //   13: lload_0
    //   14: lstore #4
    //   16: lload #6
    //   18: ldc2_w 1000000000
    //   21: lcmp
    //   22: iflt -> 45
    //   25: lload_0
    //   26: lload #6
    //   28: ldc2_w 1000000000
    //   31: ldiv
    //   32: invokestatic a : (JJ)J
    //   35: lstore #4
    //   37: lload #6
    //   39: ldc2_w 1000000000
    //   42: lrem
    //   43: l2i
    //   44: istore_2
    //   45: lload #4
    //   47: lstore_0
    //   48: iload_2
    //   49: istore_3
    //   50: iload_2
    //   51: ifge -> 69
    //   54: iload_2
    //   55: i2l
    //   56: ldc2_w 1000000000
    //   59: ladd
    //   60: l2i
    //   61: istore_3
    //   62: lload #4
    //   64: lconst_1
    //   65: invokestatic b : (JJ)J
    //   68: lstore_0
    //   69: invokestatic newBuilder : ()Lcom/google/protobuf/Timestamp$Builder;
    //   72: lload_0
    //   73: invokevirtual setSeconds : (J)Lcom/google/protobuf/Timestamp$Builder;
    //   76: iload_3
    //   77: invokevirtual setNanos : (I)Lcom/google/protobuf/Timestamp$Builder;
    //   80: invokevirtual build : ()Lcom/google/protobuf/Timestamp;
    //   83: invokestatic checkValid : (Lcom/google/protobuf/Timestamp;)Lcom/google/protobuf/Timestamp;
    //   86: areturn
  }
  
  public static Timestamp parse(String paramString) throws ParseException {
    int i = paramString.indexOf('T');
    if (i != -1) {
      int k = paramString.indexOf('Z', i);
      int j = k;
      if (k == -1)
        j = paramString.indexOf('+', i); 
      k = j;
      if (j == -1)
        k = paramString.indexOf('-', i); 
      if (k != -1) {
        String str2;
        String str1 = paramString.substring(0, k);
        j = str1.indexOf('.');
        if (j != -1) {
          String str = str1.substring(0, j);
          str2 = str1.substring(j + 1);
          str1 = str;
        } else {
          str2 = "";
        } 
        long l = ((SimpleDateFormat)timestampFormat.get()).parse(str1).getTime() / 1000L;
        if (str2.isEmpty()) {
          j = 0;
        } else {
          j = parseNanos(str2);
        } 
        if (paramString.charAt(k) == 'Z') {
          if (paramString.length() != k + 1) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Failed to parse timestamp: invalid trailing data \"");
            stringBuilder1.append(paramString.substring(k));
            stringBuilder1.append("\"");
            throw new ParseException(stringBuilder1.toString(), 0);
          } 
        } else {
          long l1 = parseTimezoneOffset(paramString.substring(k + 1));
          if (paramString.charAt(k) == '+') {
            l -= l1;
          } else {
            l += l1;
          } 
        } 
        try {
          return normalizedTimestamp(l, j);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new ParseException("Failed to parse timestamp: timestamp is out of range.", 0);
        } 
      } 
      throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to parse timestamp: invalid timestamp \"");
    stringBuilder.append((String)illegalArgumentException);
    stringBuilder.append("\"");
    throw new ParseException(stringBuilder.toString(), 0);
  }
  
  static int parseNanos(String paramString) throws ParseException {
    int j = 0;
    int i = 0;
    while (j < 9) {
      int k = i * 10;
      i = k;
      if (j < paramString.length())
        if (paramString.charAt(j) >= '0' && paramString.charAt(j) <= '9') {
          i = k + paramString.charAt(j) - 48;
        } else {
          throw new ParseException("Invalid nanoseconds.", 0);
        }  
      j++;
    } 
    return i;
  }
  
  private static long parseTimezoneOffset(String paramString) throws ParseException {
    int i = paramString.indexOf(':');
    if (i != -1) {
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      return (Long.parseLong(str) * 60L + Long.parseLong(paramString)) * 60L;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid offset value: ");
    stringBuilder.append(paramString);
    throw new ParseException(stringBuilder.toString(), 0);
  }
  
  public static Timestamp subtract(Timestamp paramTimestamp, Duration paramDuration) {
    checkValid(paramTimestamp);
    Durations.checkValid(paramDuration);
    return normalizedTimestamp(LongMath.b(paramTimestamp.getSeconds(), paramDuration.getSeconds()), IntMath.c(paramTimestamp.getNanos(), paramDuration.getNanos()));
  }
  
  public static long toMicros(Timestamp paramTimestamp) {
    checkValid(paramTimestamp);
    return LongMath.a(LongMath.c(paramTimestamp.getSeconds(), 1000000L), paramTimestamp.getNanos() / 1000L);
  }
  
  public static long toMillis(Timestamp paramTimestamp) {
    checkValid(paramTimestamp);
    return LongMath.a(LongMath.c(paramTimestamp.getSeconds(), 1000L), paramTimestamp.getNanos() / 1000000L);
  }
  
  public static long toNanos(Timestamp paramTimestamp) {
    checkValid(paramTimestamp);
    return LongMath.a(LongMath.c(paramTimestamp.getSeconds(), 1000000000L), paramTimestamp.getNanos());
  }
  
  public static long toSeconds(Timestamp paramTimestamp) {
    return checkValid(paramTimestamp).getSeconds();
  }
  
  public static String toString(Timestamp paramTimestamp) {
    checkValid(paramTimestamp);
    long l = paramTimestamp.getSeconds();
    int i = paramTimestamp.getNanos();
    StringBuilder stringBuilder = new StringBuilder();
    Date date = new Date(l * 1000L);
    stringBuilder.append(((SimpleDateFormat)timestampFormat.get()).format(date));
    if (i != 0) {
      stringBuilder.append(".");
      stringBuilder.append(formatNanos(i));
    } 
    stringBuilder.append("Z");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\Timestamps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */