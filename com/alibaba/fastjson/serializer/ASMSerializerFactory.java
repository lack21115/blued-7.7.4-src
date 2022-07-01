package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class ASMSerializerFactory implements Opcodes {
  static final String JSONSerializer = ASMUtils.type(JSONSerializer.class);
  
  static final String JavaBeanSerializer;
  
  static final String JavaBeanSerializer_desc;
  
  static final String SerialContext_desc;
  
  static final String SerializeWriter = ASMUtils.type(SerializeWriter.class);
  
  protected final ASMClassLoader classLoader = new ASMClassLoader();
  
  private final AtomicLong seed = new AtomicLong();
  
  static {
    JavaBeanSerializer = ASMUtils.type(JavaBeanSerializer.class);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(ASMUtils.type(JavaBeanSerializer.class));
    stringBuilder.append(";");
    JavaBeanSerializer_desc = stringBuilder.toString();
    SerialContext_desc = ASMUtils.desc(SerialContext.class);
  }
  
  private void _after(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeAfter", "(Ljava/lang/Object;C)C");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _apply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Class<byte> clazz = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } 
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "apply", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
  }
  
  private void _before(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeBefore", "(Ljava/lang/Object;C)C");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _boolean(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("boolean"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Z)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _byte(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("byte"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;I)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _char(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("char"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;C)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _decimal(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label1 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("decimal"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    Label label2 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitJumpInsn(199, label3);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label4);
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label4);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitLabel(label1);
  }
  
  private void _double(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(57, paramContext.var("double", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _enum(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    JSONField jSONField = paramFieldInfo.getAnnotation();
    boolean bool = false;
    int i = 0;
    if (jSONField != null) {
      SerializerFeature[] arrayOfSerializerFeature = jSONField.serialzeFeatures();
      int j = arrayOfSerializerFeature.length;
      bool = false;
      while (i < j) {
        if (arrayOfSerializerFeature[i] == SerializerFeature.WriteEnumUsingToString)
          bool = true; 
        i++;
      } 
    } 
    Label label1 = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label3);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitTypeInsn(192, "java/lang/Enum");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("enum"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    paramMethodVisitor.visitJumpInsn(199, label1);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label2);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    if (bool) {
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
    } else if (paramContext.writeDirect) {
      paramMethodVisitor.visitMethodInsn(182, "java/lang/Enum", "name", "()Ljava/lang/String;");
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/Enum;)V");
    } 
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitLabel(label3);
  }
  
  private void _filters(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    if (paramFieldInfo.field != null && Modifier.isTransient(paramFieldInfo.field.getModifiers())) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isSkipTransientField", "()Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    } 
    _notWriteDefault(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    if (paramContext.writeDirect)
      return; 
    _apply(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
    _processKey(paramMethodVisitor, paramFieldInfo, paramContext);
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("checkValue"));
    paramMethodVisitor.visitJumpInsn(154, paramLabel);
    _processValue(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitVarInsn(25, Context.original);
    paramMethodVisitor.visitVarInsn(25, Context.processValue);
    paramMethodVisitor.visitJumpInsn(165, label);
    _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _float(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(56, paramContext.var("float"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _get(MethodVisitor paramMethodVisitor, Context paramContext, FieldInfo paramFieldInfo) {
    Method method = paramFieldInfo.method;
    if (method != null) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("entity"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(method.getDeclaringClass()), method.getName(), ASMUtils.desc(method));
      return;
    } 
    paramMethodVisitor.visitVarInsn(25, paramContext.var("entity"));
    paramMethodVisitor.visitFieldInsn(180, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
  }
  
  private void _if_write_null(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    Class<String> clazz = paramFieldInfo.fieldClass;
    Label label4 = new Label();
    Label label1 = new Label();
    Label label2 = new Label();
    Label label3 = new Label();
    paramMethodVisitor.visitLabel(label4);
    JSONField jSONField = paramFieldInfo.getAnnotation();
    boolean bool5 = false;
    int i = 0;
    if (jSONField != null) {
      SerializerFeature[] arrayOfSerializerFeature = jSONField.serialzeFeatures();
      int j = arrayOfSerializerFeature.length;
      bool5 = false;
      bool4 = false;
      bool3 = false;
      bool2 = false;
      bool1 = false;
      while (i < j) {
        boolean bool6;
        boolean bool7;
        boolean bool8;
        boolean bool9;
        SerializerFeature serializerFeature = arrayOfSerializerFeature[i];
        if (serializerFeature == SerializerFeature.WriteMapNullValue) {
          bool6 = true;
          bool7 = bool4;
          bool8 = bool3;
          bool9 = bool2;
        } else if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
          bool8 = true;
          bool6 = bool5;
          bool7 = bool4;
          bool9 = bool2;
        } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
          bool7 = true;
          bool6 = bool5;
          bool8 = bool3;
          bool9 = bool2;
        } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
          bool9 = true;
          bool6 = bool5;
          bool7 = bool4;
          bool8 = bool3;
        } else {
          bool6 = bool5;
          bool7 = bool4;
          bool8 = bool3;
          bool9 = bool2;
          if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
            bool1 = true;
            bool9 = bool2;
            bool8 = bool3;
            bool7 = bool4;
            bool6 = bool5;
          } 
        } 
        i++;
        bool5 = bool6;
        bool4 = bool7;
        bool3 = bool8;
        bool2 = bool9;
      } 
    } else {
      bool4 = false;
      bool3 = false;
      bool2 = false;
      bool1 = false;
    } 
    if (!bool5) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isWriteMapNullValue", "()Z");
      paramMethodVisitor.visitJumpInsn(153, label1);
    } 
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == String.class || clazz == Character.class) {
      if (bool4) {
        paramMethodVisitor.visitLdcInsn("");
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNullString", "(CLjava/lang/String;)V");
      } 
    } else if (Number.class.isAssignableFrom(clazz)) {
      if (bool3) {
        paramMethodVisitor.visitInsn(3);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;I)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNullNumber", "(CLjava/lang/String;)V");
      } 
    } else if (clazz == Boolean.class) {
      if (bool2) {
        paramMethodVisitor.visitInsn(3);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Z)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNullBoolean", "(CLjava/lang/String;)V");
      } 
    } else if (Collection.class.isAssignableFrom(clazz) || clazz.isArray()) {
      if (bool1) {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldEmptyList", "(CLjava/lang/String;)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNullList", "(CLjava/lang/String;)V");
      } 
    } else {
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldNull", "(CLjava/lang/String;)V");
    } 
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label3);
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitLabel(label3);
  }
  
  private void _int(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("int"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;I)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _labelApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.label);
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "applyLabel", "(Ljava/lang/String;)Z");
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  private void _list(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Type<Object> type = paramFieldInfo.fieldType;
    if (type instanceof Class) {
      type = Object.class;
    } else {
      type = ((ParameterizedType)type).getActualTypeArguments()[0];
    } 
    Class clazz = null;
    if (type instanceof Class)
      clazz = (Class)type; 
    Label label1 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    Label label2 = new Label();
    paramMethodVisitor.visitLabel(label3);
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitTypeInsn(192, "java/util/List");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitJumpInsn(199, label4);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label2);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitMethodInsn(185, "java/util/List", "size", "()I");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("int"));
    label4 = new Label();
    Label label5 = new Label();
    label3 = new Label();
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitJumpInsn(160, label5);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitLdcInsn("[]");
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitJumpInsn(167, label3);
    paramMethodVisitor.visitLabel(label5);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 91);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitInsn(1);
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(ObjectSerializer.class));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_ser"));
    label4 = new Label();
    label5 = new Label();
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
    paramMethodVisitor.visitInsn(4);
    paramMethodVisitor.visitInsn(100);
    paramMethodVisitor.visitJumpInsn(162, label5);
    if (type == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
      paramMethodVisitor.visitTypeInsn(192, "java/lang/String");
      paramMethodVisitor.visitVarInsn(16, 44);
      if (paramContext.writeDirect) {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeStringWithDoubleQuoteDirect", "(Ljava/lang/String;C)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      } 
    } else {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      if (clazz != null && Modifier.isPublic(clazz.getModifiers())) {
        paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type)));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      } 
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 44);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    } 
    paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
    paramMethodVisitor.visitJumpInsn(167, label4);
    paramMethodVisitor.visitLabel(label5);
    if (type == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitInsn(4);
      paramMethodVisitor.visitInsn(100);
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
      paramMethodVisitor.visitTypeInsn(192, "java/lang/String");
      paramMethodVisitor.visitVarInsn(16, 93);
      if (paramContext.writeDirect) {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeStringWithDoubleQuoteDirect", "(Ljava/lang/String;C)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      } 
    } else {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
      paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      if (clazz != null && Modifier.isPublic(clazz.getModifiers())) {
        paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc((Class)type)));
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      } else {
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      } 
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 93);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    } 
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "popContext", "()V");
    paramMethodVisitor.visitLabel(label3);
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitLabel(label1);
  }
  
  private void _long(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(55, paramContext.var("long", 2));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _nameApply(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    if (!paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, 2);
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "applyName", "(Ljava/lang/Object;Ljava/lang/String;)Z");
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
      _labelApply(paramMethodVisitor, paramFieldInfo, paramContext, paramLabel);
    } 
    if (paramFieldInfo.field == null) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isIgnoreNonFieldGetter", "()Z");
      paramMethodVisitor.visitJumpInsn(154, paramLabel);
    } 
  }
  
  private void _notWriteDefault(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("notWriteDefaultValue"));
    paramMethodVisitor.visitJumpInsn(153, label);
    Class<boolean> clazz = paramFieldInfo.fieldClass;
    if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long"));
      paramMethodVisitor.visitInsn(9);
      paramMethodVisitor.visitInsn(148);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitInsn(11);
      paramMethodVisitor.visitInsn(149);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double"));
      paramMethodVisitor.visitInsn(14);
      paramMethodVisitor.visitInsn(151);
      paramMethodVisitor.visitJumpInsn(153, paramLabel);
    } 
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _object(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("object"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _writeObject(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _processKey(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("hasNameFilters"));
    paramMethodVisitor.visitJumpInsn(154, label);
    Class<byte> clazz = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } 
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "processKey", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
    paramMethodVisitor.visitVarInsn(58, Context.fieldName);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _processValue(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Class<byte> clazz = paramFieldInfo.fieldClass;
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    if (clazz == byte.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("byte"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == short.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == int.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("int"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == char.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("char"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == long.class) {
      paramMethodVisitor.visitVarInsn(22, paramContext.var("long", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == float.class) {
      paramMethodVisitor.visitVarInsn(23, paramContext.var("float"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == double.class) {
      paramMethodVisitor.visitVarInsn(24, paramContext.var("double", 2));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(21, paramContext.var("boolean"));
      paramMethodVisitor.visitMethodInsn(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitVarInsn(58, Context.original);
    } else if (clazz == BigDecimal.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("decimal"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (clazz == String.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (clazz.isEnum()) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("enum"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else if (List.class.isAssignableFrom(clazz)) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("list"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
      paramMethodVisitor.visitVarInsn(58, Context.original);
      paramMethodVisitor.visitVarInsn(25, Context.original);
    } 
    String str = JSONSerializer;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(JavaBeanSerializer_desc);
    stringBuilder.append("Ljava/lang/Object;Ljava/lang/String;");
    stringBuilder.append("Ljava/lang/Object;");
    stringBuilder.append(")Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(182, str, "processValue", stringBuilder.toString());
    paramMethodVisitor.visitVarInsn(58, Context.processValue);
  }
  
  private void _seperator(MethodVisitor paramMethodVisitor, Context paramContext) {
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
  }
  
  private void _short(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("short"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("short"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;I)V");
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label);
  }
  
  private void _string(Class<?> paramClass, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext) {
    Label label1 = new Label();
    _nameApply(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    _get(paramMethodVisitor, paramContext, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("string"));
    _filters(paramMethodVisitor, paramFieldInfo, paramContext, label1);
    Label label2 = new Label();
    Label label3 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
    paramMethodVisitor.visitJumpInsn(199, label2);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, label3);
    paramMethodVisitor.visitLabel(label2);
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("string"));
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
    } 
    _seperator(paramMethodVisitor, paramContext);
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitLabel(label1);
  }
  
  private void _writeObject(MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Context paramContext, Label paramLabel) {
    String str = paramFieldInfo.getFormat();
    Label label = new Label();
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
    } 
    paramMethodVisitor.visitJumpInsn(199, label);
    _if_write_null(paramMethodVisitor, paramFieldInfo, paramContext);
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(25, Context.fieldName);
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
    paramMethodVisitor.visitVarInsn(25, 1);
    if (paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("object"));
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.processValue);
    } 
    if (str != null) {
      paramMethodVisitor.visitLdcInsn(str);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
    } else {
      paramMethodVisitor.visitVarInsn(25, Context.fieldName);
      if (paramFieldInfo.fieldType instanceof Class && ((Class)paramFieldInfo.fieldType).isPrimitive()) {
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
      } else {
        if (paramFieldInfo.fieldClass == String.class) {
          paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(String.class)));
        } else {
          paramMethodVisitor.visitVarInsn(25, 0);
          String str1 = paramContext.className;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramFieldInfo.name);
          stringBuilder.append("_asm_fieldType");
          paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
        } 
        paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramFieldInfo.serialzeFeatures));
        paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
      } 
    } 
    _seperator(paramMethodVisitor, paramContext);
  }
  
  private void generateWriteAsArray(Class<?> paramClass, MethodVisitor paramMethodVisitor, List<FieldInfo> paramList, Context paramContext) throws Exception {
    int i = paramContext.var("out");
    byte b = 25;
    paramMethodVisitor.visitVarInsn(25, i);
    int j = 16;
    paramMethodVisitor.visitVarInsn(16, 91);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    int k = paramList.size();
    if (k == 0) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
      paramMethodVisitor.visitVarInsn(16, 93);
      paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      return;
    } 
    for (i = 0; i < k; i++) {
      byte b1;
      if (i == k - 1) {
        b1 = 93;
      } else {
        b1 = 44;
      } 
      FieldInfo fieldInfo = paramList.get(i);
      Class<byte> clazz = fieldInfo.fieldClass;
      paramMethodVisitor.visitLdcInsn(fieldInfo.name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if (clazz == byte.class || clazz == short.class || clazz == int.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeIntAndChar", "(IC)V");
      } else if (clazz == long.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeLongAndChar", "(JC)V");
      } else if (clazz == float.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeFloatAndChar", "(FC)V");
      } else if (clazz == double.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeDoubleAndChar", "(DC)V");
      } else if (clazz == boolean.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeBooleanAndChar", "(ZC)V");
      } else if (clazz == char.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeCharacterAndChar", "(CC)V");
      } else if (clazz == String.class) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
      } else if (clazz.isEnum()) {
        paramMethodVisitor.visitVarInsn(b, paramContext.var("out"));
        _get(paramMethodVisitor, paramContext, fieldInfo);
        paramMethodVisitor.visitVarInsn(j, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "writeEnum", "(Ljava/lang/Enum;C)V");
      } else {
        String str = fieldInfo.getFormat();
        paramMethodVisitor.visitVarInsn(b, 1);
        _get(paramMethodVisitor, paramContext, fieldInfo);
        if (str != null) {
          paramMethodVisitor.visitLdcInsn(str);
          paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
          paramMethodVisitor.visitVarInsn(b, Context.fieldName);
          if (fieldInfo.fieldType instanceof Class && ((Class)fieldInfo.fieldType).isPrimitive()) {
            paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
          } else {
            paramMethodVisitor.visitVarInsn(b, 0);
            str = paramContext.className;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(fieldInfo.name);
            stringBuilder.append("_asm_fieldType");
            paramMethodVisitor.visitFieldInsn(180, str, stringBuilder.toString(), "Ljava/lang/reflect/Type;");
            paramMethodVisitor.visitLdcInsn(Integer.valueOf(fieldInfo.serialzeFeatures));
            paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          } 
        } 
        j = paramContext.var("out");
        b = 25;
        paramMethodVisitor.visitVarInsn(25, j);
        j = 16;
        paramMethodVisitor.visitVarInsn(16, b1);
        paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
      } 
    } 
  }
  
  private void generateWriteMethod(Class<?> paramClass, MethodVisitor paramMethodVisitor, List<FieldInfo> paramList, Context paramContext) throws Exception {
    Label label3 = new Label();
    int j = paramList.size();
    Label label5 = new Label();
    Label label8 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isPrettyFormat", "()Z");
    paramMethodVisitor.visitJumpInsn(153, label5);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, label8);
    paramMethodVisitor.visitLabel(label8);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, 3);
    paramMethodVisitor.visitVarInsn(25, 4);
    paramMethodVisitor.visitVarInsn(21, 5);
    String str4 = JavaBeanSerializer;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(JSONSerializer);
    stringBuilder4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
    paramMethodVisitor.visitMethodInsn(182, str4, "write", stringBuilder4.toString());
    paramMethodVisitor.visitInsn(177);
    paramMethodVisitor.visitLabel(label5);
    label5 = new Label();
    Label label7 = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitJumpInsn(199, label7);
    paramMethodVisitor.visitLabel(label7);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(21, 5);
    String str3 = JavaBeanSerializer;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(JSONSerializer);
    stringBuilder4.append(";Ljava/lang/Object;I)Z");
    paramMethodVisitor.visitMethodInsn(182, str3, "writeReference", stringBuilder4.toString());
    paramMethodVisitor.visitJumpInsn(153, label5);
    paramMethodVisitor.visitInsn(177);
    paramMethodVisitor.visitLabel(label5);
    label5 = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.className, "nature", JavaBeanSerializer_desc);
    paramMethodVisitor.visitVarInsn(25, 1);
    str3 = JavaBeanSerializer;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(JSONSerializer);
    stringBuilder4.append(";)Z");
    paramMethodVisitor.visitMethodInsn(182, str3, "isWriteAsArray", stringBuilder4.toString());
    paramMethodVisitor.visitJumpInsn(153, label5);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, 3);
    paramMethodVisitor.visitVarInsn(25, 4);
    str3 = paramContext.className;
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(JSONSerializer);
    stringBuilder4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V");
    paramMethodVisitor.visitMethodInsn(182, str3, "writeAsArray", stringBuilder4.toString());
    paramMethodVisitor.visitInsn(177);
    paramMethodVisitor.visitLabel(label5);
    paramMethodVisitor.visitVarInsn(25, 1);
    String str2 = JSONSerializer;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(SerialContext_desc);
    paramMethodVisitor.visitMethodInsn(182, str2, "getContext", stringBuilder2.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("parent"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitVarInsn(25, 3);
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramContext.beanSerializeFeatures));
    str2 = JSONSerializer;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(");
    stringBuilder2.append(SerialContext_desc);
    stringBuilder2.append("Ljava/lang/Object;Ljava/lang/Object;I)V");
    paramMethodVisitor.visitMethodInsn(182, str2, "setContext", stringBuilder2.toString());
    Label label4 = new Label();
    Label label6 = new Label();
    Label label9 = new Label();
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, 4);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
    paramMethodVisitor.visitJumpInsn(153, label6);
    paramMethodVisitor.visitVarInsn(25, 4);
    paramMethodVisitor.visitVarInsn(25, 2);
    paramMethodVisitor.visitMethodInsn(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
    paramMethodVisitor.visitJumpInsn(165, label6);
    paramMethodVisitor.visitLabel(label9);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("{\"");
    stringBuilder3.append(JSON.DEFAULT_TYPE_KEY);
    stringBuilder3.append("\":\"");
    stringBuilder3.append(paramClass.getName());
    stringBuilder3.append("\"");
    paramMethodVisitor.visitLdcInsn(stringBuilder3.toString());
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(Ljava/lang/String;)V");
    paramMethodVisitor.visitVarInsn(16, 44);
    paramMethodVisitor.visitJumpInsn(167, label4);
    paramMethodVisitor.visitLabel(label6);
    paramMethodVisitor.visitVarInsn(16, 123);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("seperator"));
    if (!paramContext.writeDirect)
      _before(paramMethodVisitor, paramContext); 
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "isNotWriteDefaultValue", "()Z");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("notWriteDefaultValue"));
    if (!paramContext.writeDirect) {
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "checkValue", "()Z");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("checkValue"));
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitMethodInsn(182, JSONSerializer, "hasNameFilters", "()Z");
      paramMethodVisitor.visitVarInsn(54, paramContext.var("hasNameFilters"));
    } 
    int i;
    for (i = 0; i < j; i++) {
      FieldInfo fieldInfo = paramList.get(i);
      Class<byte> clazz = fieldInfo.fieldClass;
      paramMethodVisitor.visitLdcInsn(fieldInfo.name);
      paramMethodVisitor.visitVarInsn(58, Context.fieldName);
      if (clazz == byte.class) {
        _byte(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == short.class) {
        _short(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == int.class) {
        _int(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == long.class) {
        _long(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == float.class) {
        _float(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == double.class) {
        _double(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == boolean.class) {
        _boolean(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == char.class) {
        _char(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == String.class) {
        _string(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz == BigDecimal.class) {
        _decimal(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (List.class.isAssignableFrom(clazz)) {
        _list(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else if (clazz.isEnum()) {
        _enum(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } else {
        _object(paramClass, paramMethodVisitor, fieldInfo, paramContext);
      } 
    } 
    if (!paramContext.writeDirect)
      _after(paramMethodVisitor, paramContext); 
    Label label1 = new Label();
    Label label2 = new Label();
    paramMethodVisitor.visitVarInsn(21, paramContext.var("seperator"));
    paramMethodVisitor.visitIntInsn(16, 123);
    paramMethodVisitor.visitJumpInsn(160, label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 123);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(label1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("out"));
    paramMethodVisitor.visitVarInsn(16, 125);
    paramMethodVisitor.visitMethodInsn(182, SerializeWriter, "write", "(I)V");
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitLabel(label3);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("parent"));
    String str1 = JSONSerializer;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    stringBuilder1.append(SerialContext_desc);
    stringBuilder1.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str1, "setContext", stringBuilder1.toString());
  }
  
  public ObjectSerializer createJavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap) throws Exception {
    byte[] arrayOfByte;
    Class<?> clazz = paramClass;
    if (!paramClass.isPrimitive()) {
      List<FieldInfo> list;
      JSONType jSONType = clazz.<JSONType>getAnnotation(JSONType.class);
      List<?> list1 = TypeUtils.computeGetters(clazz, jSONType, paramMap, false);
      for (FieldInfo fieldInfo : list1) {
        if (fieldInfo.field == null && fieldInfo.method != null && fieldInfo.method.getDeclaringClass().isInterface())
          return new JavaBeanSerializer(clazz); 
      } 
      if (jSONType != null) {
        iterator = (Iterator<FieldInfo>)jSONType.orders();
      } else {
        iterator = null;
      } 
      if (iterator != null && iterator.length != 0) {
        list = TypeUtils.computeGetters(clazz, jSONType, paramMap, true);
      } else {
        list = new ArrayList(list1);
        Collections.sort((List)list);
      } 
      int j = list1.size();
      int i = 0;
      while (true) {
        if (i < j) {
          if (!((FieldInfo)list1.get(i)).equals(list.get(i))) {
            i = 0;
            break;
          } 
          i++;
          continue;
        } 
        i = 1;
        break;
      } 
      if (list.size() > 256)
        return null; 
      Iterator<FieldInfo> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (!ASMUtils.checkName(((FieldInfo)iterator.next()).getMember().getName()))
          return null; 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("ASMSerializer_");
      stringBuilder1.append(this.seed.incrementAndGet());
      stringBuilder1.append("_");
      stringBuilder1.append(paramClass.getSimpleName());
      String str1 = stringBuilder1.toString();
      String str2 = ASMSerializerFactory.class.getPackage().getName();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2.replace('.', '/'));
      stringBuilder2.append("/");
      stringBuilder2.append(str1);
      String str3 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(".");
      stringBuilder2.append(str1);
      str1 = stringBuilder2.toString();
      j = TypeUtils.getSerializeFeatures(paramClass);
      ClassWriter classWriter = new ClassWriter();
      classWriter.visit(49, 33, str3, ASMUtils.type(ASMJavaBeanSerializer.class), new String[] { ASMUtils.type(ObjectSerializer.class) });
      for (FieldInfo fieldInfo : list) {
        if (fieldInfo.fieldClass.isPrimitive() || fieldInfo.fieldClass.isEnum() || fieldInfo.fieldClass == String.class)
          continue; 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm_fieldType");
        (new FieldWriter(classWriter, 1, stringBuilder3.toString(), "Ljava/lang/reflect/Type;")).visitEnd();
      } 
      MethodWriter methodWriter = new MethodWriter(classWriter, 1, "<init>", "()V", null, null);
      methodWriter.visitVarInsn(25, 0);
      methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass)));
      methodWriter.visitMethodInsn(183, ASMUtils.type(ASMJavaBeanSerializer.class), "<init>", "(Ljava/lang/Class;)V");
      for (FieldInfo fieldInfo : list) {
        if (fieldInfo.fieldClass.isPrimitive() || fieldInfo.fieldClass.isEnum() || fieldInfo.fieldClass == String.class)
          continue; 
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(fieldInfo.declaringClass)));
        if (fieldInfo.method != null) {
          methodWriter.visitLdcInsn(fieldInfo.method.getName());
          methodWriter.visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
        } else {
          methodWriter.visitLdcInsn(fieldInfo.field.getName());
          methodWriter.visitMethodInsn(184, ASMUtils.type(ASMUtils.class), "getFieldType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
        } 
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(fieldInfo.name);
        stringBuilder3.append("_asm_fieldType");
        methodWriter.visitFieldInsn(181, str3, stringBuilder3.toString(), "Ljava/lang/reflect/Type;");
      } 
      methodWriter.visitInsn(177);
      methodWriter.visitMaxs(4, 4);
      methodWriter.visitEnd();
      int k = 0;
      while (true) {
        MethodWriter methodWriter1;
        Context context2;
        Class<?> clazz1 = paramClass;
        ASMSerializerFactory aSMSerializerFactory = this;
        if (k < 2) {
          boolean bool;
          String str4;
          if (k == 0) {
            str4 = "write";
            bool = true;
          } else {
            str4 = "write1";
            bool = false;
          } 
          context2 = new Context(str3, j, bool);
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("(L");
          stringBuilder5.append(JSONSerializer);
          stringBuilder5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          methodWriter1 = new MethodWriter(classWriter, 1, str4, stringBuilder5.toString(), null, new String[] { "java/io/IOException" });
          methodWriter1.visitVarInsn(25, 1);
          String str5 = JSONSerializer;
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("()L");
          stringBuilder6.append(SerializeWriter);
          stringBuilder6.append(";");
          methodWriter1.visitMethodInsn(182, str5, "getWriter", stringBuilder6.toString());
          methodWriter1.visitVarInsn(58, context2.var("out"));
          if (i == 0 && (jSONType == null || jSONType.alphabetic())) {
            Label label = new Label();
            methodWriter1.visitVarInsn(25, context2.var("out"));
            methodWriter1.visitMethodInsn(182, SerializeWriter, "isSortField", "()Z");
            methodWriter1.visitJumpInsn(154, label);
            methodWriter1.visitVarInsn(25, 0);
            methodWriter1.visitVarInsn(25, 1);
            methodWriter1.visitVarInsn(25, 2);
            methodWriter1.visitVarInsn(25, 3);
            methodWriter1.visitVarInsn(25, 4);
            methodWriter1.visitVarInsn(21, 5);
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("(L");
            stringBuilder6.append(JSONSerializer);
            stringBuilder6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodWriter1.visitMethodInsn(182, str3, "writeUnsorted", stringBuilder6.toString());
            methodWriter1.visitInsn(177);
            methodWriter1.visitLabel(label);
          } 
          if (context2.writeDirect) {
            Label label = new Label();
            methodWriter1.visitVarInsn(25, 1);
            methodWriter1.visitMethodInsn(182, JSONSerializer, "writeDirect", "()Z");
            methodWriter1.visitJumpInsn(154, label);
            methodWriter1.visitVarInsn(25, 0);
            methodWriter1.visitVarInsn(25, 1);
            methodWriter1.visitVarInsn(25, 2);
            methodWriter1.visitVarInsn(25, 3);
            methodWriter1.visitVarInsn(25, 4);
            methodWriter1.visitVarInsn(21, 5);
            stringBuilder6 = new StringBuilder();
            stringBuilder6.append("(L");
            stringBuilder6.append(JSONSerializer);
            stringBuilder6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodWriter1.visitMethodInsn(182, str3, "write1", stringBuilder6.toString());
            methodWriter1.visitInsn(177);
            methodWriter1.visitLabel(label);
          } 
          methodWriter1.visitVarInsn(25, 2);
          methodWriter1.visitTypeInsn(192, ASMUtils.type(paramClass));
          methodWriter1.visitVarInsn(58, context2.var("entity"));
          generateWriteMethod(paramClass, (MethodVisitor)methodWriter1, list, context2);
          methodWriter1.visitInsn(177);
          methodWriter1.visitMaxs(7, context2.variantIndex + 2);
          methodWriter1.visitEnd();
          k++;
          continue;
        } 
        if (i == 0) {
          Context context = new Context(str3, j, false);
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append("(L");
          stringBuilder5.append(JSONSerializer);
          stringBuilder5.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
          MethodWriter methodWriter3 = new MethodWriter(classWriter, 1, "writeUnsorted", stringBuilder5.toString(), null, new String[] { "java/io/IOException" });
          methodWriter3.visitVarInsn(25, 1);
          String str = JSONSerializer;
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append("()L");
          stringBuilder6.append(SerializeWriter);
          stringBuilder6.append(";");
          methodWriter3.visitMethodInsn(182, str, "getWriter", stringBuilder6.toString());
          methodWriter3.visitVarInsn(58, context.var("out"));
          methodWriter3.visitVarInsn(25, 2);
          methodWriter3.visitTypeInsn(192, ASMUtils.type(paramClass));
          methodWriter3.visitVarInsn(58, context.var("entity"));
          methodWriter1.generateWriteMethod((Class<?>)context2, (MethodVisitor)methodWriter3, (List)list1, context);
          methodWriter3.visitInsn(177);
          methodWriter3.visitMaxs(7, context.variantIndex + 2);
          methodWriter3.visitEnd();
        } 
        Context context1 = new Context(str3, j, false);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("(L");
        stringBuilder3.append(JSONSerializer);
        stringBuilder3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;)V");
        MethodWriter methodWriter2 = new MethodWriter(classWriter, 1, "writeAsArray", stringBuilder3.toString(), null, new String[] { "java/io/IOException" });
        methodWriter2.visitVarInsn(25, 1);
        str3 = JSONSerializer;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("()L");
        stringBuilder4.append(SerializeWriter);
        stringBuilder4.append(";");
        methodWriter2.visitMethodInsn(182, str3, "getWriter", stringBuilder4.toString());
        methodWriter2.visitVarInsn(58, context1.var("out"));
        methodWriter2.visitVarInsn(25, 2);
        methodWriter2.visitTypeInsn(192, ASMUtils.type(paramClass));
        methodWriter2.visitVarInsn(58, context1.var("entity"));
        methodWriter1.generateWriteAsArray((Class<?>)context2, (MethodVisitor)methodWriter2, list, context1);
        methodWriter2.visitInsn(177);
        methodWriter2.visitMaxs(7, context1.variantIndex + 2);
        methodWriter2.visitEnd();
        arrayOfByte = classWriter.toByteArray();
        return ((ASMSerializerFactory)methodWriter1).classLoader.defineClassPublic(str1, arrayOfByte, 0, arrayOfByte.length).newInstance();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupportd class ");
    stringBuilder.append(arrayOfByte.getName());
    throw new JSONException(stringBuilder.toString());
  }
  
  static class Context {
    static final int features = 5;
    
    static int fieldName = 6;
    
    static final int obj = 2;
    
    static int original = 7;
    
    static final int paramFieldName = 3;
    
    static final int paramFieldType = 4;
    
    static int processValue = 8;
    
    static final int serializer = 1;
    
    private final int beanSerializeFeatures;
    
    private final String className;
    
    private int variantIndex = 9;
    
    private Map<String, Integer> variants = new HashMap<String, Integer>();
    
    private final boolean writeDirect;
    
    public Context(String param1String, int param1Int, boolean param1Boolean) {
      this.className = param1String;
      this.beanSerializeFeatures = param1Int;
      this.writeDirect = param1Boolean;
      if (this.writeDirect)
        processValue = 8; 
    }
    
    public int var(String param1String) {
      if ((Integer)this.variants.get(param1String) == null) {
        Map<String, Integer> map = this.variants;
        int i = this.variantIndex;
        this.variantIndex = i + 1;
        map.put(param1String, Integer.valueOf(i));
      } 
      return ((Integer)this.variants.get(param1String)).intValue();
    }
    
    public int var(String param1String, int param1Int) {
      if ((Integer)this.variants.get(param1String) == null) {
        this.variants.put(param1String, Integer.valueOf(this.variantIndex));
        this.variantIndex += param1Int;
      } 
      return ((Integer)this.variants.get(param1String)).intValue();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ASMSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */