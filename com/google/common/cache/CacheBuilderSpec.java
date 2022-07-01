package com.google.common.cache;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class CacheBuilderSpec {
  private static final Splitter n = Splitter.a(',').b();
  
  private static final Splitter o = Splitter.a('=').b();
  
  private static final ImmutableMap<String, ValueParser> p = ImmutableMap.k().b("initialCapacity", new InitialCapacityParser()).b("maximumSize", new MaximumSizeParser()).b("maximumWeight", new MaximumWeightParser()).b("concurrencyLevel", new ConcurrencyLevelParser()).b("weakKeys", new KeyStrengthParser(LocalCache.Strength.c)).b("softValues", new ValueStrengthParser(LocalCache.Strength.b)).b("weakValues", new ValueStrengthParser(LocalCache.Strength.c)).b("recordStats", new RecordStatsParser()).b("expireAfterAccess", new AccessDurationParser()).b("expireAfterWrite", new WriteDurationParser()).b("refreshAfterWrite", new RefreshDurationParser()).b("refreshInterval", new RefreshDurationParser()).b();
  
  @NullableDecl
  Integer a;
  
  @NullableDecl
  Long b;
  
  @NullableDecl
  Long c;
  
  @NullableDecl
  Integer d;
  
  @NullableDecl
  LocalCache.Strength e;
  
  @NullableDecl
  LocalCache.Strength f;
  
  @NullableDecl
  Boolean g;
  
  long h;
  
  @NullableDecl
  TimeUnit i;
  
  long j;
  
  @NullableDecl
  TimeUnit k;
  
  long l;
  
  @NullableDecl
  TimeUnit m;
  
  private final String q;
  
  @NullableDecl
  private static Long a(long paramLong, @NullableDecl TimeUnit paramTimeUnit) {
    return (paramTimeUnit == null) ? null : Long.valueOf(paramTimeUnit.toNanos(paramLong));
  }
  
  public String a() {
    return this.q;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof CacheBuilderSpec))
      return false; 
    paramObject = paramObject;
    return (Objects.a(this.a, ((CacheBuilderSpec)paramObject).a) && Objects.a(this.b, ((CacheBuilderSpec)paramObject).b) && Objects.a(this.c, ((CacheBuilderSpec)paramObject).c) && Objects.a(this.d, ((CacheBuilderSpec)paramObject).d) && Objects.a(this.e, ((CacheBuilderSpec)paramObject).e) && Objects.a(this.f, ((CacheBuilderSpec)paramObject).f) && Objects.a(this.g, ((CacheBuilderSpec)paramObject).g) && Objects.a(a(this.h, this.i), a(((CacheBuilderSpec)paramObject).h, ((CacheBuilderSpec)paramObject).i)) && Objects.a(a(this.j, this.k), a(((CacheBuilderSpec)paramObject).j, ((CacheBuilderSpec)paramObject).k)) && Objects.a(a(this.l, this.m), a(((CacheBuilderSpec)paramObject).l, ((CacheBuilderSpec)paramObject).m)));
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f, this.g, a(this.h, this.i), a(this.j, this.k), a(this.l, this.m) });
  }
  
  public String toString() {
    return MoreObjects.a(this).a(a()).toString();
  }
  
  static class AccessDurationParser extends DurationParser {}
  
  static class ConcurrencyLevelParser extends IntegerParser {}
  
  static abstract class DurationParser implements ValueParser {}
  
  static class InitialCapacityParser extends IntegerParser {}
  
  static abstract class IntegerParser implements ValueParser {}
  
  static class KeyStrengthParser implements ValueParser {
    private final LocalCache.Strength a;
    
    public KeyStrengthParser(LocalCache.Strength param1Strength) {
      this.a = param1Strength;
    }
  }
  
  static abstract class LongParser implements ValueParser {}
  
  static class MaximumSizeParser extends LongParser {}
  
  static class MaximumWeightParser extends LongParser {}
  
  static class RecordStatsParser implements ValueParser {}
  
  static class RefreshDurationParser extends DurationParser {}
  
  static interface ValueParser {}
  
  static class ValueStrengthParser implements ValueParser {
    private final LocalCache.Strength a;
    
    public ValueStrengthParser(LocalCache.Strength param1Strength) {
      this.a = param1Strength;
    }
  }
  
  static class WriteDurationParser extends DurationParser {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\CacheBuilderSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */