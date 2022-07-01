package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter extends RateLimiter {
  double a;
  
  final double b() {
    return TimeUnit.SECONDS.toMicros(1L) / this.a;
  }
  
  static final class SmoothBursty extends SmoothRateLimiter {}
  
  static final class SmoothWarmingUp extends SmoothRateLimiter {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\SmoothRateLimiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */