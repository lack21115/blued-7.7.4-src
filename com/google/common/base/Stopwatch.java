package com.google.common.base;

import java.util.concurrent.TimeUnit;

public final class Stopwatch {
  private final Ticker a = Ticker.b();
  
  private boolean b;
  
  private long c;
  
  private long d;
  
  public static Stopwatch a() {
    return new Stopwatch();
  }
  
  private static TimeUnit a(long paramLong) {
    return (TimeUnit.DAYS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.DAYS : ((TimeUnit.HOURS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.HOURS : ((TimeUnit.MINUTES.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MINUTES : ((TimeUnit.SECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.SECONDS : ((TimeUnit.MILLISECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MILLISECONDS : ((TimeUnit.MICROSECONDS.convert(paramLong, TimeUnit.NANOSECONDS) > 0L) ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS)))));
  }
  
  public static Stopwatch b() {
    return (new Stopwatch()).d();
  }
  
  private static String b(TimeUnit paramTimeUnit) {
    switch (null.a[paramTimeUnit.ordinal()]) {
      default:
        throw new AssertionError();
      case 7:
        return "d";
      case 6:
        return "h";
      case 5:
        return "min";
      case 4:
        return "s";
      case 3:
        return "ms";
      case 2:
        return "μs";
      case 1:
        break;
    } 
    return "ns";
  }
  
  private long g() {
    return this.b ? (this.a.a() - this.d + this.c) : this.c;
  }
  
  public long a(TimeUnit paramTimeUnit) {
    return paramTimeUnit.convert(g(), TimeUnit.NANOSECONDS);
  }
  
  public boolean c() {
    return this.b;
  }
  
  public Stopwatch d() {
    Preconditions.b(this.b ^ true, "This stopwatch is already running.");
    this.b = true;
    this.d = this.a.a();
    return this;
  }
  
  public Stopwatch e() {
    long l = this.a.a();
    Preconditions.b(this.b, "This stopwatch is already stopped.");
    this.b = false;
    this.c += l - this.d;
    return this;
  }
  
  public Stopwatch f() {
    this.c = 0L;
    this.b = false;
    return this;
  }
  
  public String toString() {
    long l = g();
    TimeUnit timeUnit = a(l);
    double d = l / TimeUnit.NANOSECONDS.convert(1L, timeUnit);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Platform.a(d));
    stringBuilder.append(" ");
    stringBuilder.append(b(timeUnit));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Stopwatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */