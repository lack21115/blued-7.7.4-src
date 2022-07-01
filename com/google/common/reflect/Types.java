package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class Types {
  private static final Function<Type, String> a = new Function<Type, String>() {
      public String a(Type param1Type) {
        return Types.JavaVersion.e.c(param1Type);
      }
    };
  
  private static final Joiner b = Joiner.a(", ").b("null");
  
  static Class<?> a(Class<?> paramClass) {
    return Array.newInstance(paramClass, 0).getClass();
  }
  
  static ParameterizedType a(Class<?> paramClass, Type... paramVarArgs) {
    return new ParameterizedTypeImpl(ClassOwnership.c.a(paramClass), paramClass, paramVarArgs);
  }
  
  static ParameterizedType a(@NullableDecl Type paramType, Class<?> paramClass, Type... paramVarArgs) {
    boolean bool;
    if (paramType == null)
      return a(paramClass, paramVarArgs); 
    Preconditions.a(paramVarArgs);
    if (paramClass.getEnclosingClass() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Owner type for unenclosed %s", paramClass);
    return new ParameterizedTypeImpl(paramType, paramClass, paramVarArgs);
  }
  
  static Type a(Type paramType) {
    Type[] arrayOfType;
    if (paramType instanceof WildcardType) {
      boolean bool1;
      paramType = paramType;
      Type[] arrayOfType1 = paramType.getLowerBounds();
      int i = arrayOfType1.length;
      boolean bool2 = true;
      if (i <= 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      Preconditions.a(bool1, "Wildcard cannot have more than one lower bounds.");
      if (arrayOfType1.length == 1)
        return c(a(arrayOfType1[0])); 
      arrayOfType = paramType.getUpperBounds();
      if (arrayOfType.length == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      Preconditions.a(bool1, "Wildcard should have only one upper bound.");
      return b(a(arrayOfType[0]));
    } 
    return JavaVersion.e.a((Type)arrayOfType);
  }
  
  static <D extends GenericDeclaration> TypeVariable<D> a(D paramD, String paramString, Type... paramVarArgs) {
    Type[] arrayOfType = paramVarArgs;
    if (paramVarArgs.length == 0) {
      arrayOfType = new Type[1];
      arrayOfType[0] = Object.class;
    } 
    return b(paramD, paramString, arrayOfType);
  }
  
  private static Iterable<Type> b(Iterable<Type> paramIterable) {
    return Iterables.c(paramIterable, Predicates.a(Predicates.a(Object.class)));
  }
  
  @NullableDecl
  private static Type b(Type[] paramArrayOfType) {
    int j = paramArrayOfType.length;
    for (int i = 0; i < j; i++) {
      Type type = e(paramArrayOfType[i]);
      if (type != null) {
        if (type instanceof Class) {
          Class clazz = (Class)type;
          if (clazz.isPrimitive())
            return clazz; 
        } 
        return b(type);
      } 
    } 
    return null;
  }
  
  private static <D extends GenericDeclaration> TypeVariable<D> b(D paramD, String paramString, Type[] paramArrayOfType) {
    return Reflection.<TypeVariable<D>>a((Class)TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(paramD, paramString, paramArrayOfType)));
  }
  
  static WildcardType b(Type paramType) {
    return new WildcardTypeImpl(new Type[0], new Type[] { paramType });
  }
  
  private static void b(Type[] paramArrayOfType, String paramString) {
    int j = paramArrayOfType.length;
    for (int i = 0; i < j; i++) {
      Type type = paramArrayOfType[i];
      if (type instanceof Class) {
        type = type;
        Preconditions.a(type.isPrimitive() ^ true, "Primitive type '%s' used as %s", type, paramString);
      } 
    } 
  }
  
  private static Type[] b(Collection<Type> paramCollection) {
    return paramCollection.<Type>toArray(new Type[0]);
  }
  
  static WildcardType c(Type paramType) {
    return new WildcardTypeImpl(new Type[] { paramType }, new Type[] { Object.class });
  }
  
  static String d(Type paramType) {
    return (paramType instanceof Class) ? ((Class)paramType).getName() : paramType.toString();
  }
  
  @NullableDecl
  static Type e(Type paramType) {
    Preconditions.a(paramType);
    AtomicReference<Type> atomicReference = new AtomicReference();
    (new TypeVisitor(atomicReference) {
        void a(Class<?> param1Class) {
          this.a.set(param1Class.getComponentType());
        }
        
        void a(GenericArrayType param1GenericArrayType) {
          this.a.set(param1GenericArrayType.getGenericComponentType());
        }
        
        void a(TypeVariable<?> param1TypeVariable) {
          this.a.set(Types.a(param1TypeVariable.getBounds()));
        }
        
        void a(WildcardType param1WildcardType) {
          this.a.set(Types.a(param1WildcardType.getUpperBounds()));
        }
      }).a(new Type[] { paramType });
    return atomicReference.get();
  }
  
  enum ClassOwnership {
    a {
      @NullableDecl
      Class<?> a(Class<?> param2Class) {
        return param2Class.getEnclosingClass();
      }
    },
    b {
      @NullableDecl
      Class<?> a(Class<?> param2Class) {
        return param2Class.isLocalClass() ? null : param2Class.getEnclosingClass();
      }
    };
    
    static final ClassOwnership c = a();
    
    static {
    
    }
    
    private static ClassOwnership a() {
      ParameterizedType parameterizedType = (ParameterizedType)(new LocalClass<String>() {
        
        }).getClass().getGenericSuperclass();
      for (ClassOwnership classOwnership : values()) {
        if (classOwnership.a(LocalClass.class) == parameterizedType.getOwnerType())
          return classOwnership; 
      } 
      throw new AssertionError();
    }
    
    @NullableDecl
    abstract Class<?> a(Class<?> param1Class);
  }
  
  enum null {
    @NullableDecl
    Class<?> a(Class<?> param1Class) {
      return param1Class.getEnclosingClass();
    }
  }
  
  class LocalClass<T> {}
  
  enum null {
    @NullableDecl
    Class<?> a(Class<?> param1Class) {
      return param1Class.isLocalClass() ? null : param1Class.getEnclosingClass();
    }
  }
  
  static final class null extends ClassOwnership.LocalClass<String> {}
  
  static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
    private final Type a;
    
    GenericArrayTypeImpl(Type param1Type) {
      this.a = Types.JavaVersion.e.b(param1Type);
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof GenericArrayType) {
        param1Object = param1Object;
        return Objects.a(getGenericComponentType(), param1Object.getGenericComponentType());
      } 
      return false;
    }
    
    public Type getGenericComponentType() {
      return this.a;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Types.d(this.a));
      stringBuilder.append("[]");
      return stringBuilder.toString();
    }
  }
  
  enum JavaVersion {
    a {
      Type b(Type param2Type) {
        Preconditions.a(param2Type);
        Type type = param2Type;
        if (param2Type instanceof Class) {
          Class clazz = (Class)param2Type;
          type = param2Type;
          if (clazz.isArray())
            type = new Types.GenericArrayTypeImpl(clazz.getComponentType()); 
        } 
        return type;
      }
      
      GenericArrayType d(Type param2Type) {
        return new Types.GenericArrayTypeImpl(param2Type);
      }
    },
    b {
      Type a(Type param2Type) {
        return (Type)((param2Type instanceof Class) ? Types.a((Class)param2Type) : new Types.GenericArrayTypeImpl(param2Type));
      }
      
      Type b(Type param2Type) {
        return (Type)Preconditions.a(param2Type);
      }
    },
    c {
      Type a(Type param2Type) {
        return b.a(param2Type);
      }
      
      Type b(Type param2Type) {
        return b.b(param2Type);
      }
      
      String c(Type param2Type) {
        try {
          return (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(param2Type, new Object[0]);
        } catch (NoSuchMethodException noSuchMethodException) {
          throw new AssertionError("Type.getTypeName should be available in Java 8");
        } catch (InvocationTargetException invocationTargetException) {
          throw new RuntimeException(invocationTargetException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new RuntimeException(illegalAccessException);
        } 
      }
    },
    d {
      Type a(Type param2Type) {
        return c.a(param2Type);
      }
      
      boolean a() {
        return false;
      }
      
      Type b(Type param2Type) {
        return c.b(param2Type);
      }
      
      String c(Type param2Type) {
        return c.c(param2Type);
      }
    };
    
    static final JavaVersion e = a;
    
    static {
    
    }
    
    final ImmutableList<Type> a(Type[] param1ArrayOfType) {
      ImmutableList.Builder builder = ImmutableList.g();
      int j = param1ArrayOfType.length;
      for (int i = 0; i < j; i++)
        builder.c(b(param1ArrayOfType[i])); 
      return builder.a();
    }
    
    abstract Type a(Type param1Type);
    
    boolean a() {
      return true;
    }
    
    abstract Type b(Type param1Type);
    
    String c(Type param1Type) {
      return Types.d(param1Type);
    }
  }
  
  enum null {
    Type b(Type param1Type) {
      Preconditions.a(param1Type);
      Type type = param1Type;
      if (param1Type instanceof Class) {
        Class clazz = (Class)param1Type;
        type = param1Type;
        if (clazz.isArray())
          type = new Types.GenericArrayTypeImpl(clazz.getComponentType()); 
      } 
      return type;
    }
    
    GenericArrayType d(Type param1Type) {
      return new Types.GenericArrayTypeImpl(param1Type);
    }
  }
  
  enum null {
    Type a(Type param1Type) {
      return (Type)((param1Type instanceof Class) ? Types.a((Class)param1Type) : new Types.GenericArrayTypeImpl(param1Type));
    }
    
    Type b(Type param1Type) {
      return (Type)Preconditions.a(param1Type);
    }
  }
  
  enum null {
    Type a(Type param1Type) {
      return b.a(param1Type);
    }
    
    Type b(Type param1Type) {
      return b.b(param1Type);
    }
    
    String c(Type param1Type) {
      try {
        return (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(param1Type, new Object[0]);
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new AssertionError("Type.getTypeName should be available in Java 8");
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } 
    }
  }
  
  enum null {
    Type a(Type param1Type) {
      return c.a(param1Type);
    }
    
    boolean a() {
      return false;
    }
    
    Type b(Type param1Type) {
      return c.b(param1Type);
    }
    
    String c(Type param1Type) {
      return c.c(param1Type);
    }
  }
  
  static final class null extends TypeCapture<Map.Entry<String, int[][]>> {}
  
  static final class null extends TypeCapture<int[]> {}
  
  static final class NativeTypeVariableEquals<X> {
    static final boolean a = NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.a(NativeTypeVariableEquals.class, "X", new Type[0])) ^ true;
  }
  
  static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
    @NullableDecl
    private final Type a;
    
    private final ImmutableList<Type> b;
    
    private final Class<?> c;
    
    ParameterizedTypeImpl(@NullableDecl Type param1Type, Class<?> param1Class, Type[] param1ArrayOfType) {
      boolean bool;
      Preconditions.a(param1Class);
      if (param1ArrayOfType.length == (param1Class.getTypeParameters()).length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      Types.a(param1ArrayOfType, "type parameter");
      this.a = param1Type;
      this.c = param1Class;
      this.b = Types.JavaVersion.e.a(param1ArrayOfType);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ParameterizedType;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (getRawType().equals(param1Object.getRawType())) {
        bool = bool1;
        if (Objects.a(getOwnerType(), param1Object.getOwnerType())) {
          bool = bool1;
          if (Arrays.equals((Object[])getActualTypeArguments(), (Object[])param1Object.getActualTypeArguments()))
            bool = true; 
        } 
      } 
      return bool;
    }
    
    public Type[] getActualTypeArguments() {
      return Types.a((Collection)this.b);
    }
    
    public Type getOwnerType() {
      return this.a;
    }
    
    public Type getRawType() {
      return this.c;
    }
    
    public int hashCode() {
      int i;
      Type type = this.a;
      if (type == null) {
        i = 0;
      } else {
        i = type.hashCode();
      } 
      return i ^ this.b.hashCode() ^ this.c.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      if (this.a != null && Types.JavaVersion.e.a()) {
        stringBuilder.append(Types.JavaVersion.e.c(this.a));
        stringBuilder.append('.');
      } 
      stringBuilder.append(this.c.getName());
      stringBuilder.append('<');
      stringBuilder.append(Types.b().a(Iterables.a((Iterable)this.b, Types.a())));
      stringBuilder.append('>');
      return stringBuilder.toString();
    }
  }
  
  static final class TypeVariableImpl<D extends GenericDeclaration> {
    private final D a;
    
    private final String b;
    
    private final ImmutableList<Type> c;
    
    TypeVariableImpl(D param1D, String param1String, Type[] param1ArrayOfType) {
      Types.a(param1ArrayOfType, "bound for type variable");
      this.a = (D)Preconditions.a(param1D);
      this.b = (String)Preconditions.a(param1String);
      this.c = ImmutableList.a((Object[])param1ArrayOfType);
    }
    
    public D a() {
      return this.a;
    }
    
    public String b() {
      return this.b;
    }
    
    public boolean equals(Object param1Object) {
      if (Types.NativeTypeVariableEquals.a) {
        if (param1Object != null && Proxy.isProxyClass(param1Object.getClass()) && Proxy.getInvocationHandler(param1Object) instanceof Types.TypeVariableInvocationHandler) {
          param1Object = Types.TypeVariableInvocationHandler.a((Types.TypeVariableInvocationHandler)Proxy.getInvocationHandler(param1Object));
          return (this.b.equals(param1Object.b()) && this.a.equals(param1Object.a()) && this.c.equals(((TypeVariableImpl)param1Object).c));
        } 
        return false;
      } 
      if (param1Object instanceof TypeVariable) {
        param1Object = param1Object;
        return (this.b.equals(param1Object.getName()) && this.a.equals(param1Object.getGenericDeclaration()));
      } 
      return false;
    }
    
    public int hashCode() {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public String toString() {
      return this.b;
    }
  }
  
  static final class TypeVariableInvocationHandler implements InvocationHandler {
    private static final ImmutableMap<String, Method> a;
    
    private final Types.TypeVariableImpl<?> b;
    
    static {
      ImmutableMap.Builder builder = ImmutableMap.k();
      Method[] arrayOfMethod = Types.TypeVariableImpl.class.getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (true) {
        if (i < j) {
          Method method = arrayOfMethod[i];
          if (method.getDeclaringClass().equals(Types.TypeVariableImpl.class)) {
            try {
              method.setAccessible(true);
            } catch (AccessControlException accessControlException) {}
            builder.b(method.getName(), method);
          } 
          i++;
          continue;
        } 
        a = builder.b();
        return;
      } 
    }
    
    TypeVariableInvocationHandler(Types.TypeVariableImpl<?> param1TypeVariableImpl) {
      this.b = param1TypeVariableImpl;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      param1Object = param1Method.getName();
      param1Method = (Method)a.get(param1Object);
      if (param1Method != null)
        try {
          return param1Method.invoke(this.b, param1ArrayOfObject);
        } catch (InvocationTargetException invocationTargetException) {
          throw invocationTargetException.getCause();
        }  
      throw new UnsupportedOperationException(invocationTargetException);
    }
  }
  
  static final class WildcardTypeImpl implements Serializable, WildcardType {
    private final ImmutableList<Type> a;
    
    private final ImmutableList<Type> b;
    
    WildcardTypeImpl(Type[] param1ArrayOfType1, Type[] param1ArrayOfType2) {
      Types.a(param1ArrayOfType1, "lower bound for wildcard");
      Types.a(param1ArrayOfType2, "upper bound for wildcard");
      this.a = Types.JavaVersion.e.a(param1ArrayOfType1);
      this.b = Types.JavaVersion.e.a(param1ArrayOfType2);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof WildcardType;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.a.equals(Arrays.asList(param1Object.getLowerBounds()))) {
          bool1 = bool2;
          if (this.b.equals(Arrays.asList(param1Object.getUpperBounds())))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public Type[] getLowerBounds() {
      return Types.a((Collection)this.a);
    }
    
    public Type[] getUpperBounds() {
      return Types.a((Collection)this.b);
    }
    
    public int hashCode() {
      return this.a.hashCode() ^ this.b.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("?");
      UnmodifiableIterator<Type> unmodifiableIterator = this.a.av_();
      while (unmodifiableIterator.hasNext()) {
        Type type = unmodifiableIterator.next();
        stringBuilder.append(" super ");
        stringBuilder.append(Types.JavaVersion.e.c(type));
      } 
      for (Type type : Types.a((Iterable)this.b)) {
        stringBuilder.append(" extends ");
        stringBuilder.append(Types.JavaVersion.e.c(type));
      } 
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */