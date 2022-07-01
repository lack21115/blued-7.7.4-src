package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

public abstract class DiscreteDomain<C extends Comparable> {
  final boolean a;
  
  protected DiscreteDomain() {
    this(false);
  }
  
  private DiscreteDomain(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public abstract long a(C paramC1, C paramC2);
  
  public C a() {
    throw new NoSuchElementException();
  }
  
  public abstract C a(C paramC);
  
  C a(C paramC, long paramLong) {
    CollectPreconditions.a(paramLong, "distance");
    long l;
    for (l = 0L; l < paramLong; l++)
      paramC = a(paramC); 
    return paramC;
  }
  
  public C b() {
    throw new NoSuchElementException();
  }
  
  public abstract C b(C paramC);
  
  static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
    private static final BigIntegerDomain b = new BigIntegerDomain();
    
    private static final BigInteger c = BigInteger.valueOf(Long.MIN_VALUE);
    
    private static final BigInteger d = BigInteger.valueOf(Long.MAX_VALUE);
    
    BigIntegerDomain() {
      super(true);
    }
    
    public long a(BigInteger param1BigInteger1, BigInteger param1BigInteger2) {
      return param1BigInteger2.subtract(param1BigInteger1).max(c).min(d).longValue();
    }
    
    public BigInteger a(BigInteger param1BigInteger) {
      return param1BigInteger.add(BigInteger.ONE);
    }
    
    BigInteger a(BigInteger param1BigInteger, long param1Long) {
      CollectPreconditions.a(param1Long, "distance");
      return param1BigInteger.add(BigInteger.valueOf(param1Long));
    }
    
    public BigInteger b(BigInteger param1BigInteger) {
      return param1BigInteger.subtract(BigInteger.ONE);
    }
    
    public String toString() {
      return "DiscreteDomain.bigIntegers()";
    }
  }
  
  static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
    private static final IntegerDomain b = new IntegerDomain();
    
    IntegerDomain() {
      super(true);
    }
    
    public long a(Integer param1Integer1, Integer param1Integer2) {
      return param1Integer2.intValue() - param1Integer1.intValue();
    }
    
    public Integer a(Integer param1Integer) {
      int i = param1Integer.intValue();
      return (i == Integer.MAX_VALUE) ? null : Integer.valueOf(i + 1);
    }
    
    Integer a(Integer param1Integer, long param1Long) {
      CollectPreconditions.a(param1Long, "distance");
      return Integer.valueOf(Ints.a(param1Integer.longValue() + param1Long));
    }
    
    public Integer b(Integer param1Integer) {
      int i = param1Integer.intValue();
      return (i == Integer.MIN_VALUE) ? null : Integer.valueOf(i - 1);
    }
    
    public Integer c() {
      return Integer.valueOf(-2147483648);
    }
    
    public Integer d() {
      return Integer.valueOf(2147483647);
    }
    
    public String toString() {
      return "DiscreteDomain.integers()";
    }
  }
  
  static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
    private static final LongDomain b = new LongDomain();
    
    LongDomain() {
      super(true);
    }
    
    public long a(Long param1Long1, Long param1Long2) {
      long l = param1Long2.longValue() - param1Long1.longValue();
      return (param1Long2.longValue() > param1Long1.longValue() && l < 0L) ? Long.MAX_VALUE : ((param1Long2.longValue() < param1Long1.longValue() && l > 0L) ? Long.MIN_VALUE : l);
    }
    
    public Long a(Long param1Long) {
      long l = param1Long.longValue();
      return (l == Long.MAX_VALUE) ? null : Long.valueOf(l + 1L);
    }
    
    Long a(Long param1Long, long param1Long1) {
      CollectPreconditions.a(param1Long1, "distance");
      param1Long1 = param1Long.longValue() + param1Long1;
      if (param1Long1 < 0L) {
        boolean bool;
        if (param1Long.longValue() < 0L) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.a(bool, "overflow");
      } 
      return Long.valueOf(param1Long1);
    }
    
    public Long b(Long param1Long) {
      long l = param1Long.longValue();
      return (l == Long.MIN_VALUE) ? null : Long.valueOf(l - 1L);
    }
    
    public Long c() {
      return Long.valueOf(Long.MIN_VALUE);
    }
    
    public Long d() {
      return Long.valueOf(Long.MAX_VALUE);
    }
    
    public String toString() {
      return "DiscreteDomain.longs()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\DiscreteDomain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */