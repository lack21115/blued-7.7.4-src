package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class MotionTiming {
  private long a = 0L;
  
  private long b = 300L;
  
  private TimeInterpolator c = null;
  
  private int d = 0;
  
  private int e = 1;
  
  public MotionTiming(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public MotionTiming(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator) {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramTimeInterpolator;
  }
  
  static MotionTiming a(ValueAnimator paramValueAnimator) {
    MotionTiming motionTiming = new MotionTiming(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    motionTiming.d = paramValueAnimator.getRepeatCount();
    motionTiming.e = paramValueAnimator.getRepeatMode();
    return motionTiming;
  }
  
  private static TimeInterpolator b(ValueAnimator paramValueAnimator) {
    TimeInterpolator timeInterpolator2 = paramValueAnimator.getInterpolator();
    if (timeInterpolator2 instanceof android.view.animation.AccelerateDecelerateInterpolator || timeInterpolator2 == null)
      return AnimationUtils.b; 
    if (timeInterpolator2 instanceof android.view.animation.AccelerateInterpolator)
      return AnimationUtils.c; 
    TimeInterpolator timeInterpolator1 = timeInterpolator2;
    if (timeInterpolator2 instanceof android.view.animation.DecelerateInterpolator)
      timeInterpolator1 = AnimationUtils.d; 
    return timeInterpolator1;
  }
  
  public long a() {
    return this.a;
  }
  
  public void a(Animator paramAnimator) {
    paramAnimator.setStartDelay(a());
    paramAnimator.setDuration(b());
    paramAnimator.setInterpolator(c());
    if (paramAnimator instanceof ValueAnimator) {
      ValueAnimator valueAnimator = (ValueAnimator)paramAnimator;
      valueAnimator.setRepeatCount(d());
      valueAnimator.setRepeatMode(e());
    } 
  }
  
  public long b() {
    return this.b;
  }
  
  public TimeInterpolator c() {
    TimeInterpolator timeInterpolator = this.c;
    return (timeInterpolator != null) ? timeInterpolator : AnimationUtils.b;
  }
  
  public int d() {
    return this.d;
  }
  
  public int e() {
    return this.e;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof MotionTiming))
      return false; 
    paramObject = paramObject;
    return (a() != paramObject.a()) ? false : ((b() != paramObject.b()) ? false : ((d() != paramObject.d()) ? false : ((e() != paramObject.e()) ? false : c().getClass().equals(paramObject.c().getClass()))));
  }
  
  public int hashCode() {
    return ((((int)(a() ^ a() >>> 32L) * 31 + (int)(b() ^ b() >>> 32L)) * 31 + c().getClass().hashCode()) * 31 + d()) * 31 + e();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\n');
    stringBuilder.append(getClass().getName());
    stringBuilder.append('{');
    stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    stringBuilder.append(" delay: ");
    stringBuilder.append(a());
    stringBuilder.append(" duration: ");
    stringBuilder.append(b());
    stringBuilder.append(" interpolator: ");
    stringBuilder.append(c().getClass());
    stringBuilder.append(" repeatCount: ");
    stringBuilder.append(d());
    stringBuilder.append(" repeatMode: ");
    stringBuilder.append(e());
    stringBuilder.append("}\n");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\MotionTiming.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */