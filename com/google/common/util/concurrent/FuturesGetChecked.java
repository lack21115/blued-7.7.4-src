package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

final class FuturesGetChecked {
  private static final Ordering<Constructor<?>> a = Ordering.d().a(new Function<Constructor<?>, Boolean>() {
        public Boolean a(Constructor<?> param1Constructor) {
          return Boolean.valueOf(Arrays.<Class<?>>asList(param1Constructor.getParameterTypes()).contains(String.class));
        }
      }).a();
  
  static GetCheckedTypeValidator a() {
    return GetCheckedTypeValidatorHolder.WeakSetValidator.a;
  }
  
  static interface GetCheckedTypeValidator {}
  
  static class GetCheckedTypeValidatorHolder {
    static final String a;
    
    static final FuturesGetChecked.GetCheckedTypeValidator b = a();
    
    static FuturesGetChecked.GetCheckedTypeValidator a() {
      try {
        return (FuturesGetChecked.GetCheckedTypeValidator)Class.forName(a).getEnumConstants()[0];
      } finally {
        Exception exception = null;
      } 
    }
    
    static {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(GetCheckedTypeValidatorHolder.class.getName());
      stringBuilder.append("$ClassValueValidator");
      a = stringBuilder.toString();
    }
    
    enum ClassValueValidator implements FuturesGetChecked.GetCheckedTypeValidator {
      a;
      
      private static final ClassValue<Boolean> b = new ClassValue<Boolean>() {
        
        };
      
      static {
      
      }
    }
    
    static final class null extends ClassValue<Boolean> {}
    
    enum WeakSetValidator implements FuturesGetChecked.GetCheckedTypeValidator {
      a;
      
      private static final Set<WeakReference<Class<? extends Exception>>> b = new CopyOnWriteArraySet<WeakReference<Class<? extends Exception>>>();
      
      static {
      
      }
    }
  }
  
  enum ClassValueValidator implements GetCheckedTypeValidator {
    a;
    
    private static final ClassValue<Boolean> b = new ClassValue<Boolean>() {
      
      };
    
    static {
    
    }
  }
  
  static final class null extends ClassValue<Boolean> {}
  
  enum WeakSetValidator implements GetCheckedTypeValidator {
    a;
    
    private static final Set<WeakReference<Class<? extends Exception>>> b = new CopyOnWriteArraySet<WeakReference<Class<? extends Exception>>>();
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\FuturesGetChecked.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */