package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class CacheStats {
  private final long a;
  
  private final long b;
  
  private final long c;
  
  private final long d;
  
  private final long e;
  
  private final long f;
  
  public CacheStats(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
    boolean bool1;
    boolean bool2 = true;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    if (paramLong3 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    if (paramLong4 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    if (paramLong5 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    if (paramLong6 >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    Preconditions.a(bool1);
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
    this.f = paramLong6;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof CacheStats;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.a == ((CacheStats)paramObject).a) {
        bool1 = bool2;
        if (this.b == ((CacheStats)paramObject).b) {
          bool1 = bool2;
          if (this.c == ((CacheStats)paramObject).c) {
            bool1 = bool2;
            if (this.d == ((CacheStats)paramObject).d) {
              bool1 = bool2;
              if (this.e == ((CacheStats)paramObject).e) {
                bool1 = bool2;
                if (this.f == ((CacheStats)paramObject).f)
                  bool1 = true; 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f) });
  }
  
  public String toString() {
    return MoreObjects.a(this).a("hitCount", this.a).a("missCount", this.b).a("loadSuccessCount", this.c).a("loadExceptionCount", this.d).a("totalLoadTime", this.e).a("evictionCount", this.f).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\CacheStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */