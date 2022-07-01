package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class TypeResolver {
  private final TypeTable a = new TypeTable();
  
  public TypeResolver() {}
  
  private TypeResolver(TypeTable paramTypeTable) {}
  
  static TypeResolver a(Type paramType) {
    return (new TypeResolver()).a((Map<TypeVariableKey, ? extends Type>)TypeMappingIntrospector.a(paramType));
  }
  
  private ParameterizedType a(ParameterizedType paramParameterizedType) {
    Type type1 = paramParameterizedType.getOwnerType();
    if (type1 == null) {
      type1 = null;
    } else {
      type1 = c(type1);
    } 
    Type type2 = c(paramParameterizedType.getRawType());
    Type[] arrayOfType = b(paramParameterizedType.getActualTypeArguments());
    return Types.a(type1, (Class)type2, arrayOfType);
  }
  
  private Type a(GenericArrayType paramGenericArrayType) {
    return Types.a(c(paramGenericArrayType.getGenericComponentType()));
  }
  
  private WildcardType a(WildcardType paramWildcardType) {
    Type[] arrayOfType2 = paramWildcardType.getLowerBounds();
    Type[] arrayOfType1 = paramWildcardType.getUpperBounds();
    return new Types.WildcardTypeImpl(b(arrayOfType2), b(arrayOfType1));
  }
  
  static TypeResolver b(Type paramType) {
    paramType = WildcardCapturer.a.a(paramType);
    return (new TypeResolver()).a((Map<TypeVariableKey, ? extends Type>)TypeMappingIntrospector.a(paramType));
  }
  
  private static <T> T b(Class<T> paramClass, Object paramObject) {
    try {
      return paramClass.cast(paramObject);
    } catch (ClassCastException classCastException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append(" is not a ");
      stringBuilder.append(paramClass.getSimpleName());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  private static void b(Map<TypeVariableKey, Type> paramMap, Type paramType1, Type paramType2) {
    if (paramType1.equals(paramType2))
      return; 
    (new TypeVisitor(paramMap, paramType2) {
        void a(Class<?> param1Class) {
          if (this.b instanceof WildcardType)
            return; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("No type mapping from ");
          stringBuilder.append(param1Class);
          stringBuilder.append(" to ");
          stringBuilder.append(this.b);
          throw new IllegalArgumentException(stringBuilder.toString());
        }
        
        void a(GenericArrayType param1GenericArrayType) {
          boolean bool;
          Type type = this.b;
          if (type instanceof WildcardType)
            return; 
          type = Types.e(type);
          if (type != null) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.a(bool, "%s is not an array type.", this.b);
          TypeResolver.a(this.a, param1GenericArrayType.getGenericComponentType(), type);
        }
        
        void a(ParameterizedType param1ParameterizedType) {
          boolean bool;
          Type type = this.b;
          if (type instanceof WildcardType)
            return; 
          type = (ParameterizedType)TypeResolver.a(ParameterizedType.class, type);
          if (param1ParameterizedType.getOwnerType() != null && type.getOwnerType() != null)
            TypeResolver.a(this.a, param1ParameterizedType.getOwnerType(), type.getOwnerType()); 
          Preconditions.a(param1ParameterizedType.getRawType().equals(type.getRawType()), "Inconsistent raw type: %s vs. %s", param1ParameterizedType, this.b);
          Type[] arrayOfType1 = param1ParameterizedType.getActualTypeArguments();
          Type[] arrayOfType2 = type.getActualTypeArguments();
          int j = arrayOfType1.length;
          int k = arrayOfType2.length;
          int i = 0;
          if (j == k) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.a(bool, "%s not compatible with %s", param1ParameterizedType, type);
          while (i < arrayOfType1.length) {
            TypeResolver.a(this.a, arrayOfType1[i], arrayOfType2[i]);
            i++;
          } 
        }
        
        void a(TypeVariable<?> param1TypeVariable) {
          this.a.put(new TypeResolver.TypeVariableKey(param1TypeVariable), this.b);
        }
        
        void a(WildcardType param1WildcardType) {
          boolean bool2;
          Type type = this.b;
          if (!(type instanceof WildcardType))
            return; 
          WildcardType wildcardType = (WildcardType)type;
          Type[] arrayOfType1 = param1WildcardType.getUpperBounds();
          Type[] arrayOfType2 = wildcardType.getUpperBounds();
          Type[] arrayOfType3 = param1WildcardType.getLowerBounds();
          Type[] arrayOfType4 = wildcardType.getLowerBounds();
          int i = arrayOfType1.length;
          int j = arrayOfType2.length;
          boolean bool1 = false;
          if (i == j && arrayOfType3.length == arrayOfType4.length) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          Preconditions.a(bool2, "Incompatible type: %s vs. %s", param1WildcardType, this.b);
          i = 0;
          while (true) {
            j = bool1;
            if (i < arrayOfType1.length) {
              TypeResolver.a(this.a, arrayOfType1[i], arrayOfType2[i]);
              i++;
              continue;
            } 
            break;
          } 
          while (j < arrayOfType3.length) {
            TypeResolver.a(this.a, arrayOfType3[j], arrayOfType4[j]);
            j++;
          } 
        }
      }).a(new Type[] { paramType1 });
  }
  
  private Type[] b(Type[] paramArrayOfType) {
    Type[] arrayOfType = new Type[paramArrayOfType.length];
    for (int i = 0; i < paramArrayOfType.length; i++)
      arrayOfType[i] = c(paramArrayOfType[i]); 
    return arrayOfType;
  }
  
  TypeResolver a(Map<TypeVariableKey, ? extends Type> paramMap) {
    return new TypeResolver(this.a.a(paramMap));
  }
  
  Type[] a(Type[] paramArrayOfType) {
    for (int i = 0; i < paramArrayOfType.length; i++)
      paramArrayOfType[i] = c(paramArrayOfType[i]); 
    return paramArrayOfType;
  }
  
  public Type c(Type paramType) {
    Preconditions.a(paramType);
    if (paramType instanceof TypeVariable)
      return this.a.a((TypeVariable)paramType); 
    if (paramType instanceof ParameterizedType)
      return a((ParameterizedType)paramType); 
    if (paramType instanceof GenericArrayType)
      return a((GenericArrayType)paramType); 
    Type type = paramType;
    if (paramType instanceof WildcardType)
      type = a((WildcardType)paramType); 
    return type;
  }
  
  static final class TypeMappingIntrospector extends TypeVisitor {
    private final Map<TypeResolver.TypeVariableKey, Type> a = Maps.c();
    
    static ImmutableMap<TypeResolver.TypeVariableKey, Type> a(Type param1Type) {
      Preconditions.a(param1Type);
      TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
      typeMappingIntrospector.a(new Type[] { param1Type });
      return ImmutableMap.a(typeMappingIntrospector.a);
    }
    
    private void a(TypeResolver.TypeVariableKey param1TypeVariableKey, Type param1Type) {
      if (this.a.containsKey(param1TypeVariableKey))
        return; 
      for (Type type = param1Type; type != null; type = this.a.get(TypeResolver.TypeVariableKey.a(type))) {
        if (param1TypeVariableKey.b(type)) {
          while (param1Type != null)
            param1Type = this.a.remove(TypeResolver.TypeVariableKey.a(param1Type)); 
          return;
        } 
      } 
      this.a.put(param1TypeVariableKey, param1Type);
    }
    
    void a(Class<?> param1Class) {
      a(new Type[] { param1Class.getGenericSuperclass() });
      a(param1Class.getGenericInterfaces());
    }
    
    void a(ParameterizedType param1ParameterizedType) {
      boolean bool;
      Class clazz = (Class)param1ParameterizedType.getRawType();
      TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
      Type[] arrayOfType = param1ParameterizedType.getActualTypeArguments();
      if (arrayOfTypeVariable.length == arrayOfType.length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      for (int i = 0; i < arrayOfTypeVariable.length; i++)
        a(new TypeResolver.TypeVariableKey(arrayOfTypeVariable[i]), arrayOfType[i]); 
      a(new Type[] { clazz });
      a(new Type[] { param1ParameterizedType.getOwnerType() });
    }
    
    void a(TypeVariable<?> param1TypeVariable) {
      a(param1TypeVariable.getBounds());
    }
    
    void a(WildcardType param1WildcardType) {
      a(param1WildcardType.getUpperBounds());
    }
  }
  
  static class TypeTable {
    private final ImmutableMap<TypeResolver.TypeVariableKey, Type> a = ImmutableMap.j();
    
    TypeTable() {}
    
    private TypeTable(ImmutableMap<TypeResolver.TypeVariableKey, Type> param1ImmutableMap) {}
    
    final TypeTable a(Map<TypeResolver.TypeVariableKey, ? extends Type> param1Map) {
      ImmutableMap.Builder builder = ImmutableMap.k();
      builder.b((Map)this.a);
      for (Map.Entry<TypeResolver.TypeVariableKey, ? extends Type> entry : param1Map.entrySet()) {
        TypeResolver.TypeVariableKey typeVariableKey = (TypeResolver.TypeVariableKey)entry.getKey();
        Type type = (Type)entry.getValue();
        Preconditions.a(typeVariableKey.b(type) ^ true, "Type variable %s bound to itself", typeVariableKey);
        builder.b(typeVariableKey, type);
      } 
      return new TypeTable(builder.b());
    }
    
    final Type a(TypeVariable<?> param1TypeVariable) {
      return a(param1TypeVariable, new TypeTable(this, param1TypeVariable, this) {
            public Type a(TypeVariable<?> param2TypeVariable, TypeResolver.TypeTable param2TypeTable) {
              return param2TypeVariable.getGenericDeclaration().equals(this.a.getGenericDeclaration()) ? param2TypeVariable : this.b.a(param2TypeVariable, param2TypeTable);
            }
          });
    }
    
    Type a(TypeVariable<?> param1TypeVariable, TypeTable param1TypeTable) {
      Type[] arrayOfType1;
      Type[] arrayOfType2;
      Type type = (Type)this.a.get(new TypeResolver.TypeVariableKey(param1TypeVariable));
      if (type == null) {
        arrayOfType2 = param1TypeVariable.getBounds();
        if (arrayOfType2.length == 0)
          return param1TypeVariable; 
        arrayOfType1 = TypeResolver.a(new TypeResolver(param1TypeTable), arrayOfType2);
        return (Types.NativeTypeVariableEquals.a && Arrays.equals((Object[])arrayOfType2, (Object[])arrayOfType1)) ? param1TypeVariable : Types.a((GenericDeclaration)param1TypeVariable.getGenericDeclaration(), param1TypeVariable.getName(), arrayOfType1);
      } 
      return (new TypeResolver((TypeTable)arrayOfType1)).c((Type)arrayOfType2);
    }
  }
  
  class null extends TypeTable {
    null(TypeResolver this$0, TypeVariable param1TypeVariable, TypeResolver.TypeTable param1TypeTable1) {}
    
    public Type a(TypeVariable<?> param1TypeVariable, TypeResolver.TypeTable param1TypeTable) {
      return param1TypeVariable.getGenericDeclaration().equals(this.a.getGenericDeclaration()) ? param1TypeVariable : this.b.a(param1TypeVariable, param1TypeTable);
    }
  }
  
  static final class TypeVariableKey {
    private final TypeVariable<?> a;
    
    TypeVariableKey(TypeVariable<?> param1TypeVariable) {
      this.a = (TypeVariable)Preconditions.a(param1TypeVariable);
    }
    
    static TypeVariableKey a(Type param1Type) {
      return (param1Type instanceof TypeVariable) ? new TypeVariableKey((TypeVariable)param1Type) : null;
    }
    
    private boolean a(TypeVariable<?> param1TypeVariable) {
      return (this.a.getGenericDeclaration().equals(param1TypeVariable.getGenericDeclaration()) && this.a.getName().equals(param1TypeVariable.getName()));
    }
    
    boolean b(Type param1Type) {
      return (param1Type instanceof TypeVariable) ? a((TypeVariable)param1Type) : false;
    }
    
    public boolean equals(Object param1Object) {
      return (param1Object instanceof TypeVariableKey) ? a(((TypeVariableKey)param1Object).a) : false;
    }
    
    public int hashCode() {
      return Objects.a(new Object[] { this.a.getGenericDeclaration(), this.a.getName() });
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
  
  static class WildcardCapturer {
    static final WildcardCapturer a = new WildcardCapturer();
    
    private final AtomicInteger b;
    
    private WildcardCapturer() {
      this(new AtomicInteger());
    }
    
    private WildcardCapturer(AtomicInteger param1AtomicInteger) {
      this.b = param1AtomicInteger;
    }
    
    private WildcardCapturer a() {
      return new WildcardCapturer(this.b);
    }
    
    private WildcardCapturer a(TypeVariable<?> param1TypeVariable) {
      return new WildcardCapturer(this, this.b, param1TypeVariable) {
          TypeVariable<?> a(Type[] param2ArrayOfType) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])param2ArrayOfType));
            linkedHashSet.addAll(Arrays.asList(this.b.getBounds()));
            if (linkedHashSet.size() > 1)
              linkedHashSet.remove(Object.class); 
            return super.a((Type[])linkedHashSet.toArray((Object[])new Type[0]));
          }
        };
    }
    
    private Type b(@NullableDecl Type param1Type) {
      return (param1Type == null) ? null : a(param1Type);
    }
    
    final Type a(Type<?> param1Type) {
      Preconditions.a(param1Type);
      if (param1Type instanceof Class)
        return param1Type; 
      if (param1Type instanceof TypeVariable)
        return param1Type; 
      if (param1Type instanceof GenericArrayType) {
        param1Type = param1Type;
        return Types.a(a().a(param1Type.getGenericComponentType()));
      } 
      if (param1Type instanceof ParameterizedType) {
        param1Type = param1Type;
        Class<?> clazz = (Class)param1Type.getRawType();
        TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
        Type[] arrayOfType = param1Type.getActualTypeArguments();
        for (int i = 0; i < arrayOfType.length; i++)
          arrayOfType[i] = a(arrayOfTypeVariable[i]).a(arrayOfType[i]); 
        return Types.a(a().b(param1Type.getOwnerType()), clazz, arrayOfType);
      } 
      if (param1Type instanceof WildcardType) {
        WildcardType wildcardType = (WildcardType)param1Type;
        if ((wildcardType.getLowerBounds()).length == 0)
          param1Type = a(wildcardType.getUpperBounds()); 
        return param1Type;
      } 
      throw new AssertionError("must have been one of the known types");
    }
    
    TypeVariable<?> a(Type[] param1ArrayOfType) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("capture#");
      stringBuilder.append(this.b.incrementAndGet());
      stringBuilder.append("-of ? extends ");
      stringBuilder.append(Joiner.a('&').a((Object[])param1ArrayOfType));
      return Types.a(WildcardCapturer.class, stringBuilder.toString(), param1ArrayOfType);
    }
  }
  
  class null extends WildcardCapturer {
    null(TypeResolver this$0, AtomicInteger param1AtomicInteger, TypeVariable param1TypeVariable) {
      super(param1AtomicInteger);
    }
    
    TypeVariable<?> a(Type[] param1ArrayOfType) {
      LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])param1ArrayOfType));
      linkedHashSet.addAll(Arrays.asList(this.b.getBounds()));
      if (linkedHashSet.size() > 1)
        linkedHashSet.remove(Object.class); 
      return super.a((Type[])linkedHashSet.toArray((Object[])new Type[0]));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\TypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */