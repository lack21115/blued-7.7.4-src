package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
  private final RemovalCause a;
  
  private RemovalNotification(@NullableDecl K paramK, @NullableDecl V paramV, RemovalCause paramRemovalCause) {
    super(paramK, paramV);
    this.a = (RemovalCause)Preconditions.a(paramRemovalCause);
  }
  
  public static <K, V> RemovalNotification<K, V> a(@NullableDecl K paramK, @NullableDecl V paramV, RemovalCause paramRemovalCause) {
    return new RemovalNotification<K, V>(paramK, paramV, paramRemovalCause);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\RemovalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */