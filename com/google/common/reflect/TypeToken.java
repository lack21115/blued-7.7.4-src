package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
  private final Type a = a();
  
  @NullableDecl
  private transient TypeResolver b;
  
  @NullableDecl
  private transient TypeResolver c;
  
  public TypeToken() {
    Type type = this.a;
    Preconditions.b(type instanceof TypeVariable ^ true, "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", type);
  }
  
  private TypeToken(Type paramType) {}
  
  private ImmutableList<TypeToken<? super T>> a(Type[] paramArrayOfType) {
    ImmutableList.Builder builder = ImmutableList.g();
    int j = paramArrayOfType.length;
    for (int i = 0; i < j; i++) {
      TypeToken<?> typeToken = a(paramArrayOfType[i]);
      if (typeToken.b().isInterface())
        builder.c(typeToken); 
    } 
    return builder.a();
  }
  
  public static <T> TypeToken<T> a(Class<T> paramClass) {
    return new SimpleTypeToken<T>(paramClass);
  }
  
  public static TypeToken<?> a(Type paramType) {
    return new SimpleTypeToken(paramType);
  }
  
  private TypeToken<?> b(Type paramType) {
    TypeToken<?> typeToken = a(h().c(paramType));
    typeToken.c = this.c;
    typeToken.b = this.b;
    return typeToken;
  }
  
  @NullableDecl
  private TypeToken<? super T> c(Type paramType) {
    TypeToken<?> typeToken2 = a(paramType);
    TypeToken<?> typeToken1 = typeToken2;
    if (typeToken2.b().isInterface())
      typeToken1 = null; 
    return (TypeToken)typeToken1;
  }
  
  private ImmutableSet<Class<? super T>> g() {
    ImmutableSet.Builder builder = ImmutableSet.k();
    (new TypeVisitor(this, builder) {
        void a(Class<?> param1Class) {
          this.a.c(param1Class);
        }
        
        void a(GenericArrayType param1GenericArrayType) {
          this.a.c(Types.a(TypeToken.a(param1GenericArrayType.getGenericComponentType()).b()));
        }
        
        void a(ParameterizedType param1ParameterizedType) {
          this.a.c(param1ParameterizedType.getRawType());
        }
        
        void a(TypeVariable<?> param1TypeVariable) {
          a(param1TypeVariable.getBounds());
        }
        
        void a(WildcardType param1WildcardType) {
          a(param1WildcardType.getUpperBounds());
        }
      }).a(new Type[] { this.a });
    return builder.a();
  }
  
  private TypeResolver h() {
    TypeResolver typeResolver2 = this.c;
    TypeResolver typeResolver1 = typeResolver2;
    if (typeResolver2 == null) {
      typeResolver1 = TypeResolver.a(this.a);
      this.c = typeResolver1;
    } 
    return typeResolver1;
  }
  
  private TypeResolver i() {
    TypeResolver typeResolver2 = this.b;
    TypeResolver typeResolver1 = typeResolver2;
    if (typeResolver2 == null) {
      typeResolver1 = TypeResolver.b(this.a);
      this.b = typeResolver1;
    } 
    return typeResolver1;
  }
  
  public final Class<? super T> b() {
    return (Class<? super T>)g().av_().next();
  }
  
  public final Type c() {
    return this.a;
  }
  
  @NullableDecl
  final TypeToken<? super T> d() {
    Type type = this.a;
    if (type instanceof TypeVariable)
      return c(((TypeVariable)type).getBounds()[0]); 
    if (type instanceof WildcardType)
      return c(((WildcardType)type).getUpperBounds()[0]); 
    type = b().getGenericSuperclass();
    return (TypeToken)((type == null) ? null : b(type));
  }
  
  final ImmutableList<TypeToken<? super T>> e() {
    Type type = this.a;
    if (type instanceof TypeVariable)
      return a(((TypeVariable)type).getBounds()); 
    if (type instanceof WildcardType)
      return a(((WildcardType)type).getUpperBounds()); 
    ImmutableList.Builder builder = ImmutableList.g();
    Type[] arrayOfType = b().getGenericInterfaces();
    int j = arrayOfType.length;
    for (int i = 0; i < j; i++)
      builder.c(b(arrayOfType[i])); 
    return builder.a();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof TypeToken) {
      paramObject = paramObject;
      return this.a.equals(((TypeToken)paramObject).a);
    } 
    return false;
  }
  
  public final TypeSet f() {
    return new TypeSet(this);
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public String toString() {
    return Types.d(this.a);
  }
  
  static class Bounds {}
  
  final class ClassSet extends TypeSet {
    @NullableDecl
    private transient ImmutableSet<TypeToken<? super T>> c;
    
    public Set<TypeToken<? super T>> a() {
      ImmutableSet<TypeToken<? super T>> immutableSet2 = this.c;
      ImmutableSet<TypeToken<? super T>> immutableSet1 = immutableSet2;
      if (immutableSet2 == null) {
        immutableSet1 = FluentIterable.a((Iterable)TypeToken.TypeCollector.a.a().a(this.a)).a(TypeToken.TypeFilter.a).b();
        this.c = immutableSet1;
      } 
      return (Set<TypeToken<? super T>>)immutableSet1;
    }
    
    public Set<Class<? super T>> d() {
      return (Set<Class<? super T>>)ImmutableSet.a((Collection)TypeToken.TypeCollector.b.a().a((Iterable)TypeToken.b(this.a)));
    }
  }
  
  final class InterfaceSet extends TypeSet {
    private final transient TypeToken<T>.TypeSet c;
    
    @NullableDecl
    private transient ImmutableSet<TypeToken<? super T>> d;
    
    public Set<TypeToken<? super T>> a() {
      ImmutableSet<TypeToken<? super T>> immutableSet2 = this.d;
      ImmutableSet<TypeToken<? super T>> immutableSet1 = immutableSet2;
      if (immutableSet2 == null) {
        immutableSet1 = FluentIterable.a((Iterable)this.c).a(TypeToken.TypeFilter.b).b();
        this.d = immutableSet1;
      } 
      return (Set<TypeToken<? super T>>)immutableSet1;
    }
    
    public Set<Class<? super T>> d() {
      return (Set<Class<? super T>>)FluentIterable.a((Iterable)TypeToken.TypeCollector.b.a((Iterable<? extends Class<?>>)TypeToken.b(this.a))).a(new Predicate<Class<?>>(this) {
            public boolean a(Class<?> param2Class) {
              return param2Class.isInterface();
            }
          }).b();
    }
  }
  
  class null implements Predicate<Class<?>> {
    null(TypeToken this$0) {}
    
    public boolean a(Class<?> param1Class) {
      return param1Class.isInterface();
    }
  }
  
  static final class SimpleTypeToken<T> extends TypeToken<T> {
    SimpleTypeToken(Type param1Type) {
      super(param1Type);
    }
  }
  
  static abstract class TypeCollector<K> {
    static final TypeCollector<TypeToken<?>> a = new TypeCollector<TypeToken<?>>() {
        Class<?> a(TypeToken<?> param2TypeToken) {
          return param2TypeToken.b();
        }
        
        Iterable<? extends TypeToken<?>> b(TypeToken<?> param2TypeToken) {
          return (Iterable<? extends TypeToken<?>>)param2TypeToken.e();
        }
        
        @NullableDecl
        TypeToken<?> c(TypeToken<?> param2TypeToken) {
          return param2TypeToken.d();
        }
      };
    
    static final TypeCollector<Class<?>> b = new TypeCollector<Class<?>>() {
        Class<?> a(Class<?> param2Class) {
          return param2Class;
        }
        
        Iterable<? extends Class<?>> b(Class<?> param2Class) {
          return Arrays.asList(param2Class.getInterfaces());
        }
        
        @NullableDecl
        Class<?> c(Class<?> param2Class) {
          return param2Class.getSuperclass();
        }
      };
    
    private TypeCollector() {}
    
    private int a(K param1K, Map<? super K, Integer> param1Map) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    private static <K, V> ImmutableList<K> a(Map<K, V> param1Map, Comparator<? super V> param1Comparator) {
      return (new Ordering<K>(param1Comparator, param1Map) {
          public int compare(K param2K1, K param2K2) {
            return this.a.compare(this.b.get(param2K1), this.b.get(param2K2));
          }
        }).a(param1Map.keySet());
    }
    
    ImmutableList<K> a(Iterable<? extends K> param1Iterable) {
      HashMap<? super K, Integer> hashMap = Maps.c();
      Iterator<? extends K> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        a(iterator.next(), hashMap); 
      return a((Map)hashMap, (Comparator<? super Integer>)Ordering.d().a());
    }
    
    final ImmutableList<K> a(K param1K) {
      return a((Iterable<? extends K>)ImmutableList.a(param1K));
    }
    
    final TypeCollector<K> a() {
      return new ForwardingTypeCollector<K>(this, this) {
          ImmutableList<K> a(Iterable<? extends K> param2Iterable) {
            // Byte code:
            //   0: invokestatic g : ()Lcom/google/common/collect/ImmutableList$Builder;
            //   3: astore_2
            //   4: aload_1
            //   5: invokeinterface iterator : ()Ljava/util/Iterator;
            //   10: astore_1
            //   11: aload_1
            //   12: invokeinterface hasNext : ()Z
            //   17: ifeq -> 47
            //   20: aload_1
            //   21: invokeinterface next : ()Ljava/lang/Object;
            //   26: astore_3
            //   27: aload_0
            //   28: aload_3
            //   29: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Class;
            //   32: invokevirtual isInterface : ()Z
            //   35: ifne -> 11
            //   38: aload_2
            //   39: aload_3
            //   40: invokevirtual c : (Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
            //   43: pop
            //   44: goto -> 11
            //   47: aload_0
            //   48: aload_2
            //   49: invokevirtual a : ()Lcom/google/common/collect/ImmutableList;
            //   52: invokespecial a : (Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList;
            //   55: areturn
          }
          
          Iterable<? extends K> c(K param2K) {
            return (Iterable<? extends K>)ImmutableSet.j();
          }
        };
    }
    
    abstract Class<?> b(K param1K);
    
    abstract Iterable<? extends K> c(K param1K);
    
    @NullableDecl
    abstract K d(K param1K);
    
    static class ForwardingTypeCollector<K> extends TypeCollector<K> {
      private final TypeToken.TypeCollector<K> c;
      
      ForwardingTypeCollector(TypeToken.TypeCollector<K> param2TypeCollector) {
        this.c = param2TypeCollector;
      }
      
      Class<?> b(K param2K) {
        return this.c.b(param2K);
      }
      
      Iterable<? extends K> c(K param2K) {
        return this.c.c(param2K);
      }
      
      K d(K param2K) {
        return this.c.d(param2K);
      }
    }
  }
  
  static final class null extends TypeCollector<TypeToken<?>> {
    Class<?> a(TypeToken<?> param1TypeToken) {
      return param1TypeToken.b();
    }
    
    Iterable<? extends TypeToken<?>> b(TypeToken<?> param1TypeToken) {
      return (Iterable<? extends TypeToken<?>>)param1TypeToken.e();
    }
    
    @NullableDecl
    TypeToken<?> c(TypeToken<?> param1TypeToken) {
      return param1TypeToken.d();
    }
  }
  
  static final class null extends TypeCollector<Class<?>> {
    Class<?> a(Class<?> param1Class) {
      return param1Class;
    }
    
    Iterable<? extends Class<?>> b(Class<?> param1Class) {
      return Arrays.asList(param1Class.getInterfaces());
    }
    
    @NullableDecl
    Class<?> c(Class<?> param1Class) {
      return param1Class.getSuperclass();
    }
  }
  
  class null extends TypeCollector.ForwardingTypeCollector<K> {
    null(TypeToken this$0, TypeToken.TypeCollector<K> param1TypeCollector1) {
      super(param1TypeCollector1);
    }
    
    ImmutableList<K> a(Iterable<? extends K> param1Iterable) {
      // Byte code:
      //   0: invokestatic g : ()Lcom/google/common/collect/ImmutableList$Builder;
      //   3: astore_2
      //   4: aload_1
      //   5: invokeinterface iterator : ()Ljava/util/Iterator;
      //   10: astore_1
      //   11: aload_1
      //   12: invokeinterface hasNext : ()Z
      //   17: ifeq -> 47
      //   20: aload_1
      //   21: invokeinterface next : ()Ljava/lang/Object;
      //   26: astore_3
      //   27: aload_0
      //   28: aload_3
      //   29: invokevirtual b : (Ljava/lang/Object;)Ljava/lang/Class;
      //   32: invokevirtual isInterface : ()Z
      //   35: ifne -> 11
      //   38: aload_2
      //   39: aload_3
      //   40: invokevirtual c : (Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
      //   43: pop
      //   44: goto -> 11
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual a : ()Lcom/google/common/collect/ImmutableList;
      //   52: invokespecial a : (Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList;
      //   55: areturn
    }
    
    Iterable<? extends K> c(K param1K) {
      return (Iterable<? extends K>)ImmutableSet.j();
    }
  }
  
  static final class null extends Ordering<K> {
    null(Comparator param1Comparator, Map param1Map) {}
    
    public int compare(K param1K1, K param1K2) {
      return this.a.compare(this.b.get(param1K1), this.b.get(param1K2));
    }
  }
  
  static class ForwardingTypeCollector<K> extends TypeCollector<K> {
    private final TypeToken.TypeCollector<K> c;
    
    ForwardingTypeCollector(TypeToken.TypeCollector<K> param1TypeCollector) {
      this.c = param1TypeCollector;
    }
    
    Class<?> b(K param1K) {
      return this.c.b(param1K);
    }
    
    Iterable<? extends K> c(K param1K) {
      return this.c.c(param1K);
    }
    
    K d(K param1K) {
      return this.c.d(param1K);
    }
  }
  
  enum TypeFilter implements Predicate<TypeToken<?>> {
    a {
      public boolean a(TypeToken<?> param2TypeToken) {
        return (!(TypeToken.c(param2TypeToken) instanceof TypeVariable) && !(TypeToken.c(param2TypeToken) instanceof WildcardType));
      }
    },
    b {
      public boolean a(TypeToken<?> param2TypeToken) {
        return param2TypeToken.b().isInterface();
      }
    };
  }
  
  enum null {
    public boolean a(TypeToken<?> param1TypeToken) {
      return (!(TypeToken.c(param1TypeToken) instanceof TypeVariable) && !(TypeToken.c(param1TypeToken) instanceof WildcardType));
    }
  }
  
  enum null {
    public boolean a(TypeToken<?> param1TypeToken) {
      return param1TypeToken.b().isInterface();
    }
  }
  
  public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
    @NullableDecl
    private transient ImmutableSet<TypeToken<? super T>> a;
    
    TypeSet(TypeToken this$0) {}
    
    public Set<TypeToken<? super T>> a() {
      ImmutableSet<TypeToken<? super T>> immutableSet2 = this.a;
      ImmutableSet<TypeToken<? super T>> immutableSet1 = immutableSet2;
      if (immutableSet2 == null) {
        immutableSet1 = FluentIterable.a((Iterable)TypeToken.TypeCollector.a.a(this.b)).a(TypeToken.TypeFilter.a).b();
        this.a = immutableSet1;
      } 
      return (Set<TypeToken<? super T>>)immutableSet1;
    }
    
    public Set<Class<? super T>> d() {
      return (Set<Class<? super T>>)ImmutableSet.a((Collection)TypeToken.TypeCollector.b.a((Iterable<? extends Class<?>>)TypeToken.b(this.b)));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\TypeToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */