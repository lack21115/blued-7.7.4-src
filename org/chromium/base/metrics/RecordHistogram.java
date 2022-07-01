package org.chromium.base.metrics;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RecordHistogram {
  private static Map sCache;
  
  private static Throwable sDisabledBy;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  static void assertTimesHistogramSupportsUnit(TimeUnit paramTimeUnit) {
    boolean bool;
    if (paramTimeUnit != TimeUnit.NANOSECONDS && paramTimeUnit != TimeUnit.MICROSECONDS) {
      bool = true;
    } else {
      bool = false;
    } 
    assert false;
  }
  
  private static int clampToInt(long paramLong) {
    return (paramLong > 2147483647L) ? Integer.MAX_VALUE : ((paramLong < -2147483648L) ? Integer.MIN_VALUE : (int)paramLong);
  }
  
  private static long getCachedHistogramKey(String paramString) {
    Long long_ = (Long)sCache.get(paramString);
    return (long_ == null) ? 0L : long_.longValue();
  }
  
  private static native int nativeGetHistogramTotalCountForTesting(String paramString);
  
  private static native int nativeGetHistogramValueCountForTesting(String paramString, int paramInt);
  
  private static native long nativeRecordBooleanHistogram(String paramString, long paramLong, boolean paramBoolean);
  
  private static native long nativeRecordCustomCountHistogram(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native long nativeRecordCustomTimesHistogramMilliseconds(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native long nativeRecordEnumeratedHistogram(String paramString, long paramLong, int paramInt1, int paramInt2);
  
  private static native long nativeRecordLinearCountHistogram(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native long nativeRecordSparseHistogram(String paramString, long paramLong, int paramInt);
  
  public static void recordBooleanHistogram(String paramString, boolean paramBoolean) {
    if (sDisabledBy != null)
      return; 
    long l1 = getCachedHistogramKey(paramString);
    long l2 = nativeRecordBooleanHistogram(paramString, l1, paramBoolean);
    if (l2 != l1)
      sCache.put(paramString, Long.valueOf(l2)); 
  }
  
  public static void recordCount100Histogram(String paramString, int paramInt) {
    recordCustomCountHistogram(paramString, paramInt, 1, 100, 50);
  }
  
  public static void recordCustomCountHistogram(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (sDisabledBy != null)
      return; 
    long l1 = getCachedHistogramKey(paramString);
    long l2 = nativeRecordCustomCountHistogram(paramString, l1, paramInt1, paramInt2, paramInt3, paramInt4);
    if (l2 != l1)
      sCache.put(paramString, Long.valueOf(l2)); 
  }
  
  public static void recordCustomTimesHistogram(String paramString, long paramLong1, long paramLong2, long paramLong3, TimeUnit paramTimeUnit, int paramInt) {
    assertTimesHistogramSupportsUnit(paramTimeUnit);
    recordCustomTimesHistogramMilliseconds(paramString, paramTimeUnit.toMillis(paramLong1), paramTimeUnit.toMillis(paramLong2), paramTimeUnit.toMillis(paramLong3), paramInt);
  }
  
  private static void recordCustomTimesHistogramMilliseconds(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt) {
    if (sDisabledBy != null)
      return; 
    long l = getCachedHistogramKey(paramString);
    assert false;
    throw new AssertionError();
  }
  
  public static void recordEnumeratedHistogram(String paramString, int paramInt1, int paramInt2) {
    if (sDisabledBy != null)
      return; 
    long l1 = getCachedHistogramKey(paramString);
    long l2 = nativeRecordEnumeratedHistogram(paramString, l1, paramInt1, paramInt2);
    if (l2 != l1)
      sCache.put(paramString, Long.valueOf(l2)); 
  }
  
  public static void recordSparseSlowlyHistogram(String paramString, int paramInt) {
    if (sDisabledBy != null)
      return; 
    long l1 = getCachedHistogramKey(paramString);
    long l2 = nativeRecordSparseHistogram(paramString, l1, paramInt);
    if (l2 != l1)
      sCache.put(paramString, Long.valueOf(l2)); 
  }
  
  public static void recordTimesHistogram(String paramString, long paramLong, TimeUnit paramTimeUnit) {
    assertTimesHistogramSupportsUnit(paramTimeUnit);
    recordCustomTimesHistogramMilliseconds(paramString, paramTimeUnit.toMillis(paramLong), 1L, TimeUnit.SECONDS.toMillis(10L), 50);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\RecordHistogram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */