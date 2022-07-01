package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class CacheBuilder<K, V> {
  static final Supplier<? extends AbstractCache.StatsCounter> a = Suppliers.a(new AbstractCache.StatsCounter() {
        public void a() {}
        
        public void a(int param1Int) {}
        
        public void a(long param1Long) {}
        
        public void b(int param1Int) {}
        
        public void b(long param1Long) {}
      });
  
  static final CacheStats b = new CacheStats(0L, 0L, 0L, 0L, 0L, 0L);
  
  static final Supplier<AbstractCache.StatsCounter> c = new Supplier<AbstractCache.StatsCounter>() {
      public AbstractCache.StatsCounter a() {
        return new AbstractCache.SimpleStatsCounter();
      }
    };
  
  static final Ticker d = new Ticker() {
      public long a() {
        return 0L;
      }
    };
  
  private static final Logger u = Logger.getLogger(CacheBuilder.class.getName());
  
  boolean e = true;
  
  int f = -1;
  
  int g = -1;
  
  long h = -1L;
  
  long i = -1L;
  
  @NullableDecl
  Weigher<? super K, ? super V> j;
  
  @NullableDecl
  LocalCache.Strength k;
  
  @NullableDecl
  LocalCache.Strength l;
  
  long m = -1L;
  
  long n = -1L;
  
  long o = -1L;
  
  @NullableDecl
  Equivalence<Object> p;
  
  @NullableDecl
  Equivalence<Object> q;
  
  @NullableDecl
  RemovalListener<? super K, ? super V> r;
  
  @NullableDecl
  Ticker s;
  
  Supplier<? extends AbstractCache.StatsCounter> t = a;
  
  public static CacheBuilder<Object, Object> a() {
    return new CacheBuilder<Object, Object>();
  }
  
  private void p() {
    Weigher<? super K, ? super V> weigher = this.j;
    boolean bool2 = true;
    boolean bool1 = true;
    if (weigher == null) {
      if (this.i != -1L)
        bool1 = false; 
      Preconditions.b(bool1, "maximumWeight requires weigher");
      return;
    } 
    if (this.e) {
      if (this.i != -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      Preconditions.b(bool1, "weigher requires maximumWeight");
      return;
    } 
    if (this.i == -1L)
      u.log(Level.WARNING, "ignoring weigher specified without maximumWeight"); 
  }
  
  Ticker a(boolean paramBoolean) {
    Ticker ticker = this.s;
    return (ticker != null) ? ticker : (paramBoolean ? Ticker.b() : d);
  }
  
  CacheBuilder<K, V> a(LocalCache.Strength paramStrength) {
    boolean bool;
    if (this.k == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool, "Key strength was already set to %s", this.k);
    this.k = (LocalCache.Strength)Preconditions.a(paramStrength);
    return this;
  }
  
  public <K1 extends K, V1 extends V> LoadingCache<K1, V1> a(CacheLoader<? super K1, V1> paramCacheLoader) {
    p();
    return new LocalCache.LocalLoadingCache<K1, V1>(this, paramCacheLoader);
  }
  
  Equivalence<Object> b() {
    return (Equivalence<Object>)MoreObjects.a(this.p, i().a());
  }
  
  Equivalence<Object> c() {
    return (Equivalence<Object>)MoreObjects.a(this.q, j().a());
  }
  
  int d() {
    int j = this.f;
    int i = j;
    if (j == -1)
      i = 16; 
    return i;
  }
  
  int e() {
    int j = this.g;
    int i = j;
    if (j == -1)
      i = 4; 
    return i;
  }
  
  long f() {
    return (this.m != 0L) ? ((this.n == 0L) ? 0L : ((this.j == null) ? this.h : this.i)) : 0L;
  }
  
  <K1 extends K, V1 extends V> Weigher<K1, V1> g() {
    return (Weigher<K1, V1>)MoreObjects.a(this.j, OneWeigher.a);
  }
  
  public CacheBuilder<K, V> h() {
    return a(LocalCache.Strength.c);
  }
  
  LocalCache.Strength i() {
    return (LocalCache.Strength)MoreObjects.a(this.k, LocalCache.Strength.a);
  }
  
  LocalCache.Strength j() {
    return (LocalCache.Strength)MoreObjects.a(this.l, LocalCache.Strength.a);
  }
  
  long k() {
    long l2 = this.m;
    long l1 = l2;
    if (l2 == -1L)
      l1 = 0L; 
    return l1;
  }
  
  long l() {
    long l2 = this.n;
    long l1 = l2;
    if (l2 == -1L)
      l1 = 0L; 
    return l1;
  }
  
  long m() {
    long l2 = this.o;
    long l1 = l2;
    if (l2 == -1L)
      l1 = 0L; 
    return l1;
  }
  
  <K1 extends K, V1 extends V> RemovalListener<K1, V1> n() {
    return (RemovalListener<K1, V1>)MoreObjects.a(this.r, NullListener.a);
  }
  
  Supplier<? extends AbstractCache.StatsCounter> o() {
    return this.t;
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.a(this);
    int i = this.f;
    if (i != -1)
      toStringHelper.a("initialCapacity", i); 
    i = this.g;
    if (i != -1)
      toStringHelper.a("concurrencyLevel", i); 
    long l = this.h;
    if (l != -1L)
      toStringHelper.a("maximumSize", l); 
    l = this.i;
    if (l != -1L)
      toStringHelper.a("maximumWeight", l); 
    if (this.m != -1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.m);
      stringBuilder.append("ns");
      toStringHelper.a("expireAfterWrite", stringBuilder.toString());
    } 
    if (this.n != -1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.n);
      stringBuilder.append("ns");
      toStringHelper.a("expireAfterAccess", stringBuilder.toString());
    } 
    LocalCache.Strength strength = this.k;
    if (strength != null)
      toStringHelper.a("keyStrength", Ascii.a(strength.toString())); 
    strength = this.l;
    if (strength != null)
      toStringHelper.a("valueStrength", Ascii.a(strength.toString())); 
    if (this.p != null)
      toStringHelper.a("keyEquivalence"); 
    if (this.q != null)
      toStringHelper.a("valueEquivalence"); 
    if (this.r != null)
      toStringHelper.a("removalListener"); 
    return toStringHelper.toString();
  }
  
  enum NullListener implements RemovalListener<Object, Object> {
    a;
    
    public void a(RemovalNotification<Object, Object> param1RemovalNotification) {}
  }
  
  enum OneWeigher implements Weigher<Object, Object> {
    a;
    
    public int a(Object param1Object1, Object param1Object2) {
      return 1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\CacheBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */