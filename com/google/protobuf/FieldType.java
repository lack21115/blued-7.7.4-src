package com.google.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

public enum FieldType {
  DOUBLE(0, Collection.SCALAR, JavaType.DOUBLE),
  DOUBLE_LIST(0, Collection.SCALAR, JavaType.DOUBLE),
  DOUBLE_LIST_PACKED(0, Collection.SCALAR, JavaType.DOUBLE),
  ENUM(0, Collection.SCALAR, JavaType.DOUBLE),
  ENUM_LIST(0, Collection.SCALAR, JavaType.DOUBLE),
  ENUM_LIST_PACKED(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED32(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED32_LIST(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED32_LIST_PACKED(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED64(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED64_LIST(0, Collection.SCALAR, JavaType.DOUBLE),
  FIXED64_LIST_PACKED(0, Collection.SCALAR, JavaType.DOUBLE),
  BOOL(true),
  BOOL_LIST(true),
  BOOL_LIST_PACKED(true),
  BYTES(true),
  BYTES_LIST(true),
  FLOAT(1, Collection.SCALAR, JavaType.FLOAT),
  FLOAT_LIST(1, Collection.SCALAR, JavaType.FLOAT),
  FLOAT_LIST_PACKED(1, Collection.SCALAR, JavaType.FLOAT),
  GROUP(1, Collection.SCALAR, JavaType.FLOAT),
  GROUP_LIST(1, Collection.SCALAR, JavaType.FLOAT),
  INT32(1, Collection.SCALAR, JavaType.FLOAT),
  INT32_LIST(1, Collection.SCALAR, JavaType.FLOAT),
  INT32_LIST_PACKED(1, Collection.SCALAR, JavaType.FLOAT),
  INT64(2, Collection.SCALAR, JavaType.LONG),
  INT64_LIST(2, Collection.SCALAR, JavaType.LONG),
  INT64_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  MAP(2, Collection.SCALAR, JavaType.LONG),
  MESSAGE(2, Collection.SCALAR, JavaType.LONG),
  MESSAGE_LIST(2, Collection.SCALAR, JavaType.LONG),
  SFIXED32(2, Collection.SCALAR, JavaType.LONG),
  SFIXED32_LIST(2, Collection.SCALAR, JavaType.LONG),
  SFIXED32_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  SFIXED64(2, Collection.SCALAR, JavaType.LONG),
  SFIXED64_LIST(2, Collection.SCALAR, JavaType.LONG),
  SFIXED64_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  SINT32(2, Collection.SCALAR, JavaType.LONG),
  SINT32_LIST(2, Collection.SCALAR, JavaType.LONG),
  SINT32_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  SINT64(2, Collection.SCALAR, JavaType.LONG),
  SINT64_LIST(2, Collection.SCALAR, JavaType.LONG),
  SINT64_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  STRING(2, Collection.SCALAR, JavaType.LONG),
  STRING_LIST(2, Collection.SCALAR, JavaType.LONG),
  UINT32(2, Collection.SCALAR, JavaType.LONG),
  UINT32_LIST(2, Collection.SCALAR, JavaType.LONG),
  UINT32_LIST_PACKED(2, Collection.SCALAR, JavaType.LONG),
  UINT64(3, Collection.SCALAR, JavaType.LONG),
  UINT64_LIST(3, Collection.SCALAR, JavaType.LONG),
  UINT64_LIST_PACKED(3, Collection.SCALAR, JavaType.LONG);
  
  private static final Type[] EMPTY_TYPES;
  
  private static final FieldType[] VALUES;
  
  private final Collection collection;
  
  private final Class<?> elementType;
  
  private final int id;
  
  private final JavaType javaType;
  
  private final boolean primitiveScalar;
  
  static {
    INT32 = new FieldType("INT32", 4, 4, Collection.SCALAR, JavaType.INT);
    FIXED64 = new FieldType("FIXED64", 5, 5, Collection.SCALAR, JavaType.LONG);
    FIXED32 = new FieldType("FIXED32", 6, 6, Collection.SCALAR, JavaType.INT);
    BOOL = new FieldType("BOOL", 7, 7, Collection.SCALAR, JavaType.BOOLEAN);
    STRING = new FieldType("STRING", 8, 8, Collection.SCALAR, JavaType.STRING);
    MESSAGE = new FieldType("MESSAGE", 9, 9, Collection.SCALAR, JavaType.MESSAGE);
    BYTES = new FieldType("BYTES", 10, 10, Collection.SCALAR, JavaType.BYTE_STRING);
    UINT32 = new FieldType("UINT32", 11, 11, Collection.SCALAR, JavaType.INT);
    ENUM = new FieldType("ENUM", 12, 12, Collection.SCALAR, JavaType.ENUM);
    SFIXED32 = new FieldType("SFIXED32", 13, 13, Collection.SCALAR, JavaType.INT);
    SFIXED64 = new FieldType("SFIXED64", 14, 14, Collection.SCALAR, JavaType.LONG);
    SINT32 = new FieldType("SINT32", 15, 15, Collection.SCALAR, JavaType.INT);
    SINT64 = new FieldType("SINT64", 16, 16, Collection.SCALAR, JavaType.LONG);
    GROUP = new FieldType("GROUP", 17, 17, Collection.SCALAR, JavaType.MESSAGE);
    DOUBLE_LIST = new FieldType("DOUBLE_LIST", 18, 18, Collection.VECTOR, JavaType.DOUBLE);
    FLOAT_LIST = new FieldType("FLOAT_LIST", 19, 19, Collection.VECTOR, JavaType.FLOAT);
    INT64_LIST = new FieldType("INT64_LIST", 20, 20, Collection.VECTOR, JavaType.LONG);
    UINT64_LIST = new FieldType("UINT64_LIST", 21, 21, Collection.VECTOR, JavaType.LONG);
    INT32_LIST = new FieldType("INT32_LIST", 22, 22, Collection.VECTOR, JavaType.INT);
    FIXED64_LIST = new FieldType("FIXED64_LIST", 23, 23, Collection.VECTOR, JavaType.LONG);
    FIXED32_LIST = new FieldType("FIXED32_LIST", 24, 24, Collection.VECTOR, JavaType.INT);
    BOOL_LIST = new FieldType("BOOL_LIST", 25, 25, Collection.VECTOR, JavaType.BOOLEAN);
    STRING_LIST = new FieldType("STRING_LIST", 26, 26, Collection.VECTOR, JavaType.STRING);
    MESSAGE_LIST = new FieldType("MESSAGE_LIST", 27, 27, Collection.VECTOR, JavaType.MESSAGE);
    BYTES_LIST = new FieldType("BYTES_LIST", 28, 28, Collection.VECTOR, JavaType.BYTE_STRING);
    UINT32_LIST = new FieldType("UINT32_LIST", 29, 29, Collection.VECTOR, JavaType.INT);
    ENUM_LIST = new FieldType("ENUM_LIST", 30, 30, Collection.VECTOR, JavaType.ENUM);
    SFIXED32_LIST = new FieldType("SFIXED32_LIST", 31, 31, Collection.VECTOR, JavaType.INT);
    SFIXED64_LIST = new FieldType("SFIXED64_LIST", 32, 32, Collection.VECTOR, JavaType.LONG);
    SINT32_LIST = new FieldType("SINT32_LIST", 33, 33, Collection.VECTOR, JavaType.INT);
    SINT64_LIST = new FieldType("SINT64_LIST", 34, 34, Collection.VECTOR, JavaType.LONG);
    DOUBLE_LIST_PACKED = new FieldType("DOUBLE_LIST_PACKED", 35, 35, Collection.PACKED_VECTOR, JavaType.DOUBLE);
    FLOAT_LIST_PACKED = new FieldType("FLOAT_LIST_PACKED", 36, 36, Collection.PACKED_VECTOR, JavaType.FLOAT);
    INT64_LIST_PACKED = new FieldType("INT64_LIST_PACKED", 37, 37, Collection.PACKED_VECTOR, JavaType.LONG);
    UINT64_LIST_PACKED = new FieldType("UINT64_LIST_PACKED", 38, 38, Collection.PACKED_VECTOR, JavaType.LONG);
    INT32_LIST_PACKED = new FieldType("INT32_LIST_PACKED", 39, 39, Collection.PACKED_VECTOR, JavaType.INT);
    FIXED64_LIST_PACKED = new FieldType("FIXED64_LIST_PACKED", 40, 40, Collection.PACKED_VECTOR, JavaType.LONG);
    FIXED32_LIST_PACKED = new FieldType("FIXED32_LIST_PACKED", 41, 41, Collection.PACKED_VECTOR, JavaType.INT);
    BOOL_LIST_PACKED = new FieldType("BOOL_LIST_PACKED", 42, 42, Collection.PACKED_VECTOR, JavaType.BOOLEAN);
    UINT32_LIST_PACKED = new FieldType("UINT32_LIST_PACKED", 43, 43, Collection.PACKED_VECTOR, JavaType.INT);
    ENUM_LIST_PACKED = new FieldType("ENUM_LIST_PACKED", 44, 44, Collection.PACKED_VECTOR, JavaType.ENUM);
    SFIXED32_LIST_PACKED = new FieldType("SFIXED32_LIST_PACKED", 45, 45, Collection.PACKED_VECTOR, JavaType.INT);
    SFIXED64_LIST_PACKED = new FieldType("SFIXED64_LIST_PACKED", 46, 46, Collection.PACKED_VECTOR, JavaType.LONG);
    SINT32_LIST_PACKED = new FieldType("SINT32_LIST_PACKED", 47, 47, Collection.PACKED_VECTOR, JavaType.INT);
    SINT64_LIST_PACKED = new FieldType("SINT64_LIST_PACKED", 48, 48, Collection.PACKED_VECTOR, JavaType.LONG);
    GROUP_LIST = new FieldType("GROUP_LIST", 49, 49, Collection.VECTOR, JavaType.MESSAGE);
    MAP = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
    FieldType fieldType = DOUBLE;
    int i = 0;
    $VALUES = new FieldType[] { 
        fieldType, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, MESSAGE, 
        BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64, GROUP, DOUBLE_LIST, FLOAT_LIST, 
        INT64_LIST, UINT64_LIST, INT32_LIST, FIXED64_LIST, FIXED32_LIST, BOOL_LIST, STRING_LIST, MESSAGE_LIST, BYTES_LIST, UINT32_LIST, 
        ENUM_LIST, SFIXED32_LIST, SFIXED64_LIST, SINT32_LIST, SINT64_LIST, DOUBLE_LIST_PACKED, FLOAT_LIST_PACKED, INT64_LIST_PACKED, UINT64_LIST_PACKED, INT32_LIST_PACKED, 
        FIXED64_LIST_PACKED, FIXED32_LIST_PACKED, BOOL_LIST_PACKED, UINT32_LIST_PACKED, ENUM_LIST_PACKED, SFIXED32_LIST_PACKED, SFIXED64_LIST_PACKED, SINT32_LIST_PACKED, SINT64_LIST_PACKED, GROUP_LIST, 
        MAP };
    EMPTY_TYPES = new Type[0];
    FieldType[] arrayOfFieldType = values();
    VALUES = new FieldType[arrayOfFieldType.length];
    int j = arrayOfFieldType.length;
    while (i < j) {
      FieldType fieldType1 = arrayOfFieldType[i];
      VALUES[fieldType1.id] = fieldType1;
      i++;
    } 
  }
  
  FieldType(int paramInt1, Collection paramCollection, JavaType paramJavaType) {
    this.id = paramInt1;
    this.collection = paramCollection;
    this.javaType = paramJavaType;
    this$enum$index = null.$SwitchMap$com$google$protobuf$FieldType$Collection[paramCollection.ordinal()];
    if (this$enum$index != 1) {
      if (this$enum$index != 2) {
        this.elementType = null;
      } else {
        this.elementType = paramJavaType.getBoxedType();
      } 
    } else {
      this.elementType = paramJavaType.getBoxedType();
    } 
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCollection == Collection.SCALAR) {
      this$enum$index = null.$SwitchMap$com$google$protobuf$JavaType[paramJavaType.ordinal()];
      bool1 = bool2;
      if (this$enum$index != 1) {
        bool1 = bool2;
        if (this$enum$index != 2) {
          bool1 = bool2;
          if (this$enum$index != 3)
            bool1 = true; 
        } 
      } 
    } 
    this.primitiveScalar = bool1;
  }
  
  public static FieldType forId(int paramInt) {
    if (paramInt >= 0) {
      FieldType[] arrayOfFieldType = VALUES;
      if (paramInt < arrayOfFieldType.length)
        return arrayOfFieldType[paramInt]; 
    } 
    return null;
  }
  
  private static Type getGenericSuperList(Class<?> paramClass) {
    for (Type type1 : paramClass.getGenericInterfaces()) {
      if (type1 instanceof ParameterizedType && List.class.isAssignableFrom((Class)((ParameterizedType)type1).getRawType()))
        return type1; 
    } 
    Type type = paramClass.getGenericSuperclass();
    return (type instanceof ParameterizedType && List.class.isAssignableFrom((Class)((ParameterizedType)type).getRawType())) ? type : null;
  }
  
  private static Type getListParameter(Class<?> paramClass, Type[] paramArrayOfType) {
    label44: while (true) {
      int i = 0;
      if (paramClass != List.class) {
        Type type2 = getGenericSuperList(paramClass);
        if (type2 instanceof ParameterizedType) {
          ParameterizedType parameterizedType = (ParameterizedType)type2;
          Type[] arrayOfType = parameterizedType.getActualTypeArguments();
          for (i = 0; i < arrayOfType.length; i++) {
            Type type = arrayOfType[i];
            if (type instanceof TypeVariable) {
              TypeVariable[] arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters();
              if (paramArrayOfType.length == arrayOfTypeVariable.length) {
                int k = 0;
                while (true) {
                  if (k < arrayOfTypeVariable.length) {
                    if (type == arrayOfTypeVariable[k]) {
                      arrayOfType[i] = paramArrayOfType[k];
                      k = 1;
                      break;
                    } 
                    k++;
                    continue;
                  } 
                  k = 0;
                  break;
                } 
                if (k == 0) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("Unable to find replacement for ");
                  stringBuilder.append(type);
                  throw new RuntimeException(stringBuilder.toString());
                } 
              } else {
                throw new RuntimeException("Type array mismatch");
              } 
            } 
          } 
          paramClass = (Class)parameterizedType.getRawType();
          paramArrayOfType = arrayOfType;
          continue;
        } 
        paramArrayOfType = EMPTY_TYPES;
        Class[] arrayOfClass = paramClass.getInterfaces();
        int j = arrayOfClass.length;
        while (i < j) {
          type2 = arrayOfClass[i];
          if (List.class.isAssignableFrom((Class<?>)type2)) {
            type1 = type2;
            continue label44;
          } 
          i++;
        } 
        Type type1 = type1.getSuperclass();
        continue;
      } 
      if (paramArrayOfType.length == 1)
        return paramArrayOfType[0]; 
      throw new RuntimeException("Unable to identify parameter type for List<T>");
    } 
  }
  
  private boolean isValidForList(Field paramField) {
    Class<?> clazz = paramField.getType();
    if (!this.javaType.getType().isAssignableFrom(clazz))
      return false; 
    Type[] arrayOfType = EMPTY_TYPES;
    if (paramField.getGenericType() instanceof ParameterizedType)
      arrayOfType = ((ParameterizedType)paramField.getGenericType()).getActualTypeArguments(); 
    Type type = getListParameter(clazz, arrayOfType);
    return !(type instanceof Class) ? true : this.elementType.isAssignableFrom((Class)type);
  }
  
  public JavaType getJavaType() {
    return this.javaType;
  }
  
  public int id() {
    return this.id;
  }
  
  public boolean isList() {
    return this.collection.isList();
  }
  
  public boolean isMap() {
    return (this.collection == Collection.MAP);
  }
  
  public boolean isPacked() {
    return Collection.PACKED_VECTOR.equals(this.collection);
  }
  
  public boolean isPrimitiveScalar() {
    return this.primitiveScalar;
  }
  
  public boolean isScalar() {
    return (this.collection == Collection.SCALAR);
  }
  
  public boolean isValidForField(Field paramField) {
    return Collection.VECTOR.equals(this.collection) ? isValidForList(paramField) : this.javaType.getType().isAssignableFrom(paramField.getType());
  }
  
  enum Collection {
    MAP,
    PACKED_VECTOR,
    SCALAR(false),
    VECTOR(true);
    
    private final boolean isList;
    
    static {
      MAP = new Collection("MAP", 3, false);
      $VALUES = new Collection[] { SCALAR, VECTOR, PACKED_VECTOR, MAP };
    }
    
    Collection(boolean param1Boolean) {
      this.isList = param1Boolean;
    }
    
    public boolean isList() {
      return this.isList;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */