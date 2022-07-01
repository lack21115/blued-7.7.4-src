package com.google.common.reflect;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.Set;
import java.util.logging.Logger;

public final class ClassPath {
  private static final Logger a = Logger.getLogger(ClassPath.class.getName());
  
  private static final Predicate<ClassInfo> b = new Predicate<ClassInfo>() {
      public boolean a(ClassPath.ClassInfo param1ClassInfo) {
        return (ClassPath.ClassInfo.a(param1ClassInfo).indexOf('$') == -1);
      }
    };
  
  private static final Splitter c = Splitter.a(" ").a();
  
  public static final class ClassInfo extends ResourceInfo {
    private final String b;
    
    public String toString() {
      return this.b;
    }
  }
  
  static final class DefaultScanner extends Scanner {
    private final SetMultimap<ClassLoader, String> a = MultimapBuilder.a().b().b();
  }
  
  public static class ResourceInfo {
    final ClassLoader a;
    
    private final String b;
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ResourceInfo;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.b.equals(((ResourceInfo)param1Object).b)) {
          bool1 = bool2;
          if (this.a == ((ResourceInfo)param1Object).a)
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.b.hashCode();
    }
    
    public String toString() {
      return this.b;
    }
  }
  
  static abstract class Scanner {
    private final Set<File> a = Sets.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\ClassPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */