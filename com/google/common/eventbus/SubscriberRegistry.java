package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class SubscriberRegistry {
  private static final LoadingCache<Class<?>, ImmutableList<Method>> c = CacheBuilder.a().h().a(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        public ImmutableList<Method> a(Class<?> param1Class) throws Exception {
          return SubscriberRegistry.a(param1Class);
        }
      });
  
  private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> d = CacheBuilder.a().h().a(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() {
        public ImmutableSet<Class<?>> a(Class<?> param1Class) {
          return ImmutableSet.a(TypeToken.a(param1Class).f().d());
        }
      });
  
  private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> a = Maps.e();
  
  private final EventBus b;
  
  SubscriberRegistry(EventBus paramEventBus) {
    this.b = (EventBus)Preconditions.a(paramEventBus);
  }
  
  private static ImmutableList<Method> b(Class<?> paramClass) {
    Set set = TypeToken.a(paramClass).f().d();
    HashMap<MethodIdentifier, Method> hashMap = Maps.c();
    Iterator<Class<?>> iterator = set.iterator();
    while (iterator.hasNext()) {
      for (Method method : ((Class)iterator.next()).getDeclaredMethods()) {
        if (method.isAnnotationPresent((Class)Subscribe.class) && !method.isSynthetic()) {
          Class[] arrayOfClass = method.getParameterTypes();
          int i = arrayOfClass.length;
          boolean bool = true;
          if (i != 1)
            bool = false; 
          Preconditions.a(bool, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", method, arrayOfClass.length);
          MethodIdentifier methodIdentifier = new MethodIdentifier(method);
          if (!hashMap.containsKey(methodIdentifier))
            hashMap.put(methodIdentifier, method); 
        } 
      } 
    } 
    return ImmutableList.a(hashMap.values());
  }
  
  static final class MethodIdentifier {
    private final String a;
    
    private final List<Class<?>> b;
    
    MethodIdentifier(Method param1Method) {
      this.a = param1Method.getName();
      this.b = Arrays.asList(param1Method.getParameterTypes());
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof MethodIdentifier;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(((MethodIdentifier)param1Object).a)) {
          bool1 = bool2;
          if (this.b.equals(((MethodIdentifier)param1Object).b))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a, this.b });
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\eventbus\SubscriberRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */