package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SafeKeyGenerator {
  private final LruCache<Key, String> a = new LruCache(1000L);
  
  private final Pools.Pool<PoolableDigestContainer> b = FactoryPools.a(10, new FactoryPools.Factory<PoolableDigestContainer>(this) {
        public SafeKeyGenerator.PoolableDigestContainer a() {
          try {
            return new SafeKeyGenerator.PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
          } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
          } 
        }
      });
  
  private String b(Key paramKey) {
    PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer)Preconditions.a(this.b.acquire());
    try {
      paramKey.a(poolableDigestContainer.a);
      return Util.a(poolableDigestContainer.a.digest());
    } finally {
      this.b.release(poolableDigestContainer);
    } 
  }
  
  public String a(Key paramKey) {
    LruCache<Key, String> lruCache;
    String str;
    synchronized (this.a) {
      String str1 = (String)this.a.b(paramKey);
      str = str1;
      if (str1 == null)
        str = b(paramKey); 
      synchronized (this.a) {
        this.a.b(paramKey, str);
        return str;
      } 
    } 
  }
  
  static final class PoolableDigestContainer implements FactoryPools.Poolable {
    final MessageDigest a;
    
    private final StateVerifier b = StateVerifier.a();
    
    PoolableDigestContainer(MessageDigest param1MessageDigest) {
      this.a = param1MessageDigest;
    }
    
    public StateVerifier d() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\SafeKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */