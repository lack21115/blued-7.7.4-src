package com.google.protobuf.util;

import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.math.BigInteger;
import java.text.ParseException;

@Deprecated
public final class TimeUtil {
  public static final long DURATION_SECONDS_MAX = 315576000000L;
  
  public static final long DURATION_SECONDS_MIN = -315576000000L;
  
  private static final long NANOS_PER_SECOND = 1000000000L;
  
  private static final BigInteger NANOS_PER_SECOND_BIG_INTEGER = new BigInteger(String.valueOf(1000000000L));
  
  public static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
  
  public static final long TIMESTAMP_SECONDS_MIN = -62135596800L;
  
  @Deprecated
  public static Duration add(Duration paramDuration1, Duration paramDuration2) {
    return Durations.add(paramDuration1, paramDuration2);
  }
  
  @Deprecated
  public static Timestamp add(Timestamp paramTimestamp, Duration paramDuration) {
    return Timestamps.add(paramTimestamp, paramDuration);
  }
  
  private static Duration createDurationFromBigInteger(BigInteger paramBigInteger) {
    return normalizedDuration(paramBigInteger.divide(new BigInteger(String.valueOf(1000000000L))).longValue(), paramBigInteger.remainder(new BigInteger(String.valueOf(1000000000L))).intValue());
  }
  
  @Deprecated
  public static Duration createDurationFromMicros(long paramLong) {
    return Durations.fromMicros(paramLong);
  }
  
  @Deprecated
  public static Duration createDurationFromMillis(long paramLong) {
    return Durations.fromMillis(paramLong);
  }
  
  @Deprecated
  public static Duration createDurationFromNanos(long paramLong) {
    return Durations.fromNanos(paramLong);
  }
  
  @Deprecated
  public static Timestamp createTimestampFromMicros(long paramLong) {
    return Timestamps.fromMicros(paramLong);
  }
  
  @Deprecated
  public static Timestamp createTimestampFromMillis(long paramLong) {
    return Timestamps.fromMillis(paramLong);
  }
  
  @Deprecated
  public static Timestamp createTimestampFromNanos(long paramLong) {
    return Timestamps.fromNanos(paramLong);
  }
  
  @Deprecated
  public static Duration distance(Timestamp paramTimestamp1, Timestamp paramTimestamp2) {
    return Timestamps.between(paramTimestamp1, paramTimestamp2);
  }
  
  public static long divide(Duration paramDuration1, Duration paramDuration2) {
    return toBigInteger(paramDuration1).divide(toBigInteger(paramDuration2)).longValue();
  }
  
  public static Duration divide(Duration paramDuration, double paramDouble) {
    return multiply(paramDuration, 1.0D / paramDouble);
  }
  
  public static Duration divide(Duration paramDuration, long paramLong) {
    return createDurationFromBigInteger(toBigInteger(paramDuration).divide(toBigInteger(paramLong)));
  }
  
  @Deprecated
  public static Timestamp getCurrentTime() {
    return Timestamps.fromMillis(System.currentTimeMillis());
  }
  
  @Deprecated
  public static Timestamp getEpoch() {
    return Timestamp.getDefaultInstance();
  }
  
  public static Duration multiply(Duration paramDuration, double paramDouble) {
    paramDouble = paramDuration.getSeconds() * paramDouble + paramDuration.getNanos() * paramDouble / 1.0E9D;
    if (paramDouble >= -9.223372036854776E18D && paramDouble <= 9.223372036854776E18D) {
      long l = (long)paramDouble;
      return normalizedDuration(l, (int)((paramDouble - l) * 1.0E9D));
    } 
    throw new IllegalArgumentException("Result is out of valid range.");
  }
  
  public static Duration multiply(Duration paramDuration, long paramLong) {
    return createDurationFromBigInteger(toBigInteger(paramDuration).multiply(toBigInteger(paramLong)));
  }
  
  private static Duration normalizedDuration(long paramLong, int paramInt) {
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
    //   24: iflt -> 45
    //   27: lload_0
    //   28: lload #6
    //   30: ldc2_w 1000000000
    //   33: ldiv
    //   34: ladd
    //   35: lstore #4
    //   37: lload #6
    //   39: ldc2_w 1000000000
    //   42: lrem
    //   43: l2i
    //   44: istore_3
    //   45: lload #4
    //   47: lstore_0
    //   48: iload_3
    //   49: istore_2
    //   50: lload #4
    //   52: lconst_0
    //   53: lcmp
    //   54: ifle -> 79
    //   57: lload #4
    //   59: lstore_0
    //   60: iload_3
    //   61: istore_2
    //   62: iload_3
    //   63: ifge -> 79
    //   66: iload_3
    //   67: i2l
    //   68: ldc2_w 1000000000
    //   71: ladd
    //   72: l2i
    //   73: istore_2
    //   74: lload #4
    //   76: lconst_1
    //   77: lsub
    //   78: lstore_0
    //   79: lload_0
    //   80: lstore #4
    //   82: iload_2
    //   83: istore_3
    //   84: lload_0
    //   85: lconst_0
    //   86: lcmp
    //   87: ifge -> 112
    //   90: lload_0
    //   91: lstore #4
    //   93: iload_2
    //   94: istore_3
    //   95: iload_2
    //   96: ifle -> 112
    //   99: iload_2
    //   100: i2l
    //   101: ldc2_w 1000000000
    //   104: lsub
    //   105: l2i
    //   106: istore_3
    //   107: lload_0
    //   108: lconst_1
    //   109: ladd
    //   110: lstore #4
    //   112: lload #4
    //   114: ldc2_w -315576000000
    //   117: lcmp
    //   118: iflt -> 146
    //   121: lload #4
    //   123: ldc2_w 315576000000
    //   126: lcmp
    //   127: ifgt -> 146
    //   130: invokestatic newBuilder : ()Lcom/google/protobuf/Duration$Builder;
    //   133: lload #4
    //   135: invokevirtual setSeconds : (J)Lcom/google/protobuf/Duration$Builder;
    //   138: iload_3
    //   139: invokevirtual setNanos : (I)Lcom/google/protobuf/Duration$Builder;
    //   142: invokevirtual build : ()Lcom/google/protobuf/Duration;
    //   145: areturn
    //   146: new java/lang/IllegalArgumentException
    //   149: dup
    //   150: ldc 'Duration is out of valid range.'
    //   152: invokespecial <init> : (Ljava/lang/String;)V
    //   155: athrow
  }
  
  @Deprecated
  public static Duration parseDuration(String paramString) throws ParseException {
    return Durations.parse(paramString);
  }
  
  @Deprecated
  public static Timestamp parseTimestamp(String paramString) throws ParseException {
    return Timestamps.parse(paramString);
  }
  
  public static Duration remainder(Duration paramDuration1, Duration paramDuration2) {
    return createDurationFromBigInteger(toBigInteger(paramDuration1).remainder(toBigInteger(paramDuration2)));
  }
  
  @Deprecated
  public static Duration subtract(Duration paramDuration1, Duration paramDuration2) {
    return Durations.subtract(paramDuration1, paramDuration2);
  }
  
  @Deprecated
  public static Timestamp subtract(Timestamp paramTimestamp, Duration paramDuration) {
    return Timestamps.subtract(paramTimestamp, paramDuration);
  }
  
  private static BigInteger toBigInteger(long paramLong) {
    return new BigInteger(String.valueOf(paramLong));
  }
  
  private static BigInteger toBigInteger(Duration paramDuration) {
    return toBigInteger(paramDuration.getSeconds()).multiply(NANOS_PER_SECOND_BIG_INTEGER).add(toBigInteger(paramDuration.getNanos()));
  }
  
  @Deprecated
  public static long toMicros(Duration paramDuration) {
    return Durations.toMicros(paramDuration);
  }
  
  @Deprecated
  public static long toMicros(Timestamp paramTimestamp) {
    return Timestamps.toMicros(paramTimestamp);
  }
  
  @Deprecated
  public static long toMillis(Duration paramDuration) {
    return Durations.toMillis(paramDuration);
  }
  
  @Deprecated
  public static long toMillis(Timestamp paramTimestamp) {
    return Timestamps.toMillis(paramTimestamp);
  }
  
  @Deprecated
  public static long toNanos(Duration paramDuration) {
    return Durations.toNanos(paramDuration);
  }
  
  @Deprecated
  public static long toNanos(Timestamp paramTimestamp) {
    return Timestamps.toNanos(paramTimestamp);
  }
  
  @Deprecated
  public static String toString(Duration paramDuration) {
    return Durations.toString(paramDuration);
  }
  
  @Deprecated
  public static String toString(Timestamp paramTimestamp) {
    return Timestamps.toString(paramTimestamp);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\TimeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */