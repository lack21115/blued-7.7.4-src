package com.google.protobuf.util;

import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.protobuf.Duration;
import java.text.ParseException;
import java.util.Comparator;

public final class Durations {
  private static final Comparator<Duration> COMPARATOR;
  
  static final long DURATION_SECONDS_MAX = 315576000000L;
  
  static final long DURATION_SECONDS_MIN = -315576000000L;
  
  public static final Duration MAX_VALUE;
  
  public static final Duration MIN_VALUE = Duration.newBuilder().setSeconds(-315576000000L).setNanos(-999999999).build();
  
  static {
    MAX_VALUE = Duration.newBuilder().setSeconds(315576000000L).setNanos(999999999).build();
    COMPARATOR = new Comparator<Duration>() {
        public int compare(Duration param1Duration1, Duration param1Duration2) {
          Durations.checkValid(param1Duration1);
          Durations.checkValid(param1Duration2);
          int i = Long.compare(param1Duration1.getSeconds(), param1Duration2.getSeconds());
          return (i != 0) ? i : Integer.compare(param1Duration1.getNanos(), param1Duration2.getNanos());
        }
      };
  }
  
  public static Duration add(Duration paramDuration1, Duration paramDuration2) {
    checkValid(paramDuration1);
    checkValid(paramDuration2);
    return normalizedDuration(LongMath.a(paramDuration1.getSeconds(), paramDuration2.getSeconds()), IntMath.b(paramDuration1.getNanos(), paramDuration2.getNanos()));
  }
  
  public static Duration checkValid(Duration paramDuration) {
    long l = paramDuration.getSeconds();
    int i = paramDuration.getNanos();
    if (isValid(l, i))
      return paramDuration; 
    throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[] { Long.valueOf(l), Integer.valueOf(i) }));
  }
  
  public static Comparator<Duration> comparator() {
    return COMPARATOR;
  }
  
  public static int compare(Duration paramDuration1, Duration paramDuration2) {
    return COMPARATOR.compare(paramDuration1, paramDuration2);
  }
  
  public static Duration fromMicros(long paramLong) {
    return normalizedDuration(paramLong / 1000000L, (int)(paramLong % 1000000L * 1000L));
  }
  
  public static Duration fromMillis(long paramLong) {
    return normalizedDuration(paramLong / 1000L, (int)(paramLong % 1000L * 1000000L));
  }
  
  public static Duration fromNanos(long paramLong) {
    return normalizedDuration(paramLong / 1000000000L, (int)(paramLong % 1000000000L));
  }
  
  public static Duration fromSeconds(long paramLong) {
    return normalizedDuration(paramLong, 0);
  }
  
  public static boolean isValid(long paramLong, int paramInt) {
    if (paramLong >= -315576000000L) {
      if (paramLong > 315576000000L)
        return false; 
      long l = paramInt;
      if (l >= -999999999L) {
        if (l >= 1000000000L)
          return false; 
        int i = paramLong cmp 0L;
        if (i < 0 || paramInt < 0) {
          if (i <= 0)
            return !(paramInt > 0); 
        } else {
          return true;
        } 
      } 
    } 
    return false;
  }
  
  public static boolean isValid(Duration paramDuration) {
    return isValid(paramDuration.getSeconds(), paramDuration.getNanos());
  }
  
  static Duration normalizedDuration(long paramLong, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: i2l
    //   2: lstore #6
    //   4: lload #6
    //   6: ldc2_w -1000000000
    //   9: lcmp
    //   10: ifle -> 27
    //   13: lload_0
    //   14: lstore #4
    //   16: iload_2
    //   17: istore_3
    //   18: lload #6
    //   20: ldc2_w 1000000000
    //   23: lcmp
    //   24: iflt -> 47
    //   27: lload_0
    //   28: lload #6
    //   30: ldc2_w 1000000000
    //   33: ldiv
    //   34: invokestatic a : (JJ)J
    //   37: lstore #4
    //   39: lload #6
    //   41: ldc2_w 1000000000
    //   44: lrem
    //   45: l2i
    //   46: istore_3
    //   47: lload #4
    //   49: lstore_0
    //   50: iload_3
    //   51: istore_2
    //   52: lload #4
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle -> 81
    //   59: lload #4
    //   61: lstore_0
    //   62: iload_3
    //   63: istore_2
    //   64: iload_3
    //   65: ifge -> 81
    //   68: iload_3
    //   69: i2l
    //   70: ldc2_w 1000000000
    //   73: ladd
    //   74: l2i
    //   75: istore_2
    //   76: lload #4
    //   78: lconst_1
    //   79: lsub
    //   80: lstore_0
    //   81: lload_0
    //   82: lstore #4
    //   84: iload_2
    //   85: istore_3
    //   86: lload_0
    //   87: lconst_0
    //   88: lcmp
    //   89: ifge -> 114
    //   92: lload_0
    //   93: lstore #4
    //   95: iload_2
    //   96: istore_3
    //   97: iload_2
    //   98: ifle -> 114
    //   101: iload_2
    //   102: i2l
    //   103: ldc2_w 1000000000
    //   106: lsub
    //   107: l2i
    //   108: istore_3
    //   109: lload_0
    //   110: lconst_1
    //   111: ladd
    //   112: lstore #4
    //   114: invokestatic newBuilder : ()Lcom/google/protobuf/Duration$Builder;
    //   117: lload #4
    //   119: invokevirtual setSeconds : (J)Lcom/google/protobuf/Duration$Builder;
    //   122: iload_3
    //   123: invokevirtual setNanos : (I)Lcom/google/protobuf/Duration$Builder;
    //   126: invokevirtual build : ()Lcom/google/protobuf/Duration;
    //   129: invokestatic checkValid : (Lcom/google/protobuf/Duration;)Lcom/google/protobuf/Duration;
    //   132: areturn
  }
  
  public static Duration parse(String paramString) throws ParseException {
    if (!paramString.isEmpty() && paramString.charAt(paramString.length() - 1) == 's') {
      boolean bool;
      String str2;
      if (paramString.charAt(0) == '-') {
        paramString = paramString.substring(1);
        bool = true;
      } else {
        bool = false;
      } 
      String str1 = paramString.substring(0, paramString.length() - 1);
      int i = str1.indexOf('.');
      if (i != -1) {
        str2 = str1.substring(i + 1);
        str1 = str1.substring(0, i);
      } else {
        str2 = "";
      } 
      long l = Long.parseLong(str1);
      if (str2.isEmpty()) {
        i = 0;
      } else {
        i = Timestamps.parseNanos(str2);
      } 
      if (l >= 0L) {
        long l1 = l;
        int j = i;
        if (bool) {
          l1 = -l;
          j = -i;
        } 
        try {
          return normalizedDuration(l1, j);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new ParseException("Duration value is out of range.", 0);
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid duration string: ");
      stringBuilder1.append((String)illegalArgumentException);
      throw new ParseException(stringBuilder1.toString(), 0);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid duration string: ");
    stringBuilder.append((String)illegalArgumentException);
    throw new ParseException(stringBuilder.toString(), 0);
  }
  
  public static Duration subtract(Duration paramDuration1, Duration paramDuration2) {
    checkValid(paramDuration1);
    checkValid(paramDuration2);
    return normalizedDuration(LongMath.b(paramDuration1.getSeconds(), paramDuration2.getSeconds()), IntMath.c(paramDuration1.getNanos(), paramDuration2.getNanos()));
  }
  
  public static long toMicros(Duration paramDuration) {
    checkValid(paramDuration);
    return LongMath.a(LongMath.c(paramDuration.getSeconds(), 1000000L), paramDuration.getNanos() / 1000L);
  }
  
  public static long toMillis(Duration paramDuration) {
    checkValid(paramDuration);
    return LongMath.a(LongMath.c(paramDuration.getSeconds(), 1000L), paramDuration.getNanos() / 1000000L);
  }
  
  public static long toNanos(Duration paramDuration) {
    checkValid(paramDuration);
    return LongMath.a(LongMath.c(paramDuration.getSeconds(), 1000000000L), paramDuration.getNanos());
  }
  
  public static long toSeconds(Duration paramDuration) {
    return checkValid(paramDuration).getSeconds();
  }
  
  public static String toString(Duration paramDuration) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic checkValid : (Lcom/google/protobuf/Duration;)Lcom/google/protobuf/Duration;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual getSeconds : ()J
    //   9: lstore #5
    //   11: aload_0
    //   12: invokevirtual getNanos : ()I
    //   15: istore_2
    //   16: new java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial <init> : ()V
    //   23: astore_0
    //   24: lload #5
    //   26: lconst_0
    //   27: lcmp
    //   28: iflt -> 40
    //   31: lload #5
    //   33: lstore_3
    //   34: iload_2
    //   35: istore_1
    //   36: iload_2
    //   37: ifge -> 54
    //   40: aload_0
    //   41: ldc '-'
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: lload #5
    //   49: lneg
    //   50: lstore_3
    //   51: iload_2
    //   52: ineg
    //   53: istore_1
    //   54: aload_0
    //   55: lload_3
    //   56: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iload_1
    //   61: ifeq -> 80
    //   64: aload_0
    //   65: ldc '.'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_0
    //   72: iload_1
    //   73: invokestatic formatNanos : (I)Ljava/lang/String;
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: ldc 's'
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\Durations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */