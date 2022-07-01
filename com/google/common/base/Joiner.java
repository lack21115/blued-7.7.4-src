package com.google.common.base;

import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class Joiner {
  private final String a;
  
  private Joiner(Joiner paramJoiner) {
    this.a = paramJoiner.a;
  }
  
  private Joiner(String paramString) {
    this.a = Preconditions.<String>a(paramString);
  }
  
  public static Joiner a(char paramChar) {
    return new Joiner(String.valueOf(paramChar));
  }
  
  public static Joiner a(String paramString) {
    return new Joiner(paramString);
  }
  
  public <A extends Appendable> A a(A paramA, Iterator<?> paramIterator) throws IOException {
    Preconditions.a(paramA);
    if (paramIterator.hasNext()) {
      paramA.append(a(paramIterator.next()));
      while (paramIterator.hasNext()) {
        paramA.append(this.a);
        paramA.append(a(paramIterator.next()));
      } 
    } 
    return paramA;
  }
  
  CharSequence a(Object paramObject) {
    Preconditions.a(paramObject);
    return (paramObject instanceof CharSequence) ? (CharSequence)paramObject : paramObject.toString();
  }
  
  public final String a(Iterable<?> paramIterable) {
    return a(paramIterable.iterator());
  }
  
  public final String a(Iterator<?> paramIterator) {
    return a(new StringBuilder(), paramIterator).toString();
  }
  
  public final String a(Object[] paramArrayOfObject) {
    return a(Arrays.asList(paramArrayOfObject));
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterable<?> paramIterable) {
    return a(paramStringBuilder, paramIterable.iterator());
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator) {
    try {
      a(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  public Joiner b(String paramString) {
    Preconditions.a(paramString);
    return new Joiner(this, this, paramString) {
        CharSequence a(@NullableDecl Object param1Object) {
          return (param1Object == null) ? this.a : this.b.a(param1Object);
        }
        
        public Joiner b(String param1String) {
          throw new UnsupportedOperationException("already specified useForNull");
        }
      };
  }
  
  public MapJoiner c(String paramString) {
    return new MapJoiner(this, paramString);
  }
  
  public static final class MapJoiner {
    private final Joiner a;
    
    private final String b;
    
    private MapJoiner(Joiner param1Joiner, String param1String) {
      this.a = param1Joiner;
      this.b = Preconditions.<String>a(param1String);
    }
    
    public <A extends Appendable> A a(A param1A, Iterator<? extends Map.Entry<?, ?>> param1Iterator) throws IOException {
      Preconditions.a(param1A);
      if (param1Iterator.hasNext()) {
        Map.Entry entry = param1Iterator.next();
        param1A.append(this.a.a(entry.getKey()));
        param1A.append(this.b);
        param1A.append(this.a.a(entry.getValue()));
        while (param1Iterator.hasNext()) {
          param1A.append(Joiner.a(this.a));
          entry = param1Iterator.next();
          param1A.append(this.a.a(entry.getKey()));
          param1A.append(this.b);
          param1A.append(this.a.a(entry.getValue()));
        } 
      } 
      return param1A;
    }
    
    public StringBuilder a(StringBuilder param1StringBuilder, Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
      return a(param1StringBuilder, param1Iterable.iterator());
    }
    
    public StringBuilder a(StringBuilder param1StringBuilder, Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
      try {
        a(param1StringBuilder, param1Iterator);
        return param1StringBuilder;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Joiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */