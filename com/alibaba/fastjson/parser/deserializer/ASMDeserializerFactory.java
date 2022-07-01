package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldWriter;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory implements Opcodes {
  static final String DefaultJSONParser = ASMUtils.type(DefaultJSONParser.class);
  
  static final String JSONLexerBase = ASMUtils.type(JSONLexerBase.class);
  
  static final String JSONToken = ASMUtils.type(JSONToken.class);
  
  public final ASMClassLoader classLoader;
  
  protected final AtomicLong seed;
  
  public ASMDeserializerFactory(ClassLoader paramClassLoader) {
    ASMClassLoader aSMClassLoader;
    this.seed = new AtomicLong();
    if (paramClassLoader instanceof ASMClassLoader) {
      aSMClassLoader = (ASMClassLoader)paramClassLoader;
    } else {
      aSMClassLoader = new ASMClassLoader((ClassLoader)aSMClassLoader);
    } 
    this.classLoader = aSMClassLoader;
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor) {
    _batchSet(paramContext, paramMethodVisitor, true);
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor, boolean paramBoolean) {
    int j = paramContext.fieldInfoList.length;
    int i;
    for (i = 0; i < j; i++) {
      Label label = new Label();
      if (paramBoolean)
        _isFlag(paramMethodVisitor, paramContext, i, label); 
      _loadAndSet(paramContext, paramMethodVisitor, paramContext.fieldInfoList[i]);
      if (paramBoolean)
        paramMethodVisitor.visitLabel(label); 
    } 
  }
  
  private void _createInstance(ClassWriter paramClassWriter, Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(DefaultJSONParser);
    stringBuilder.append(";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "createInstance", stringBuilder.toString(), null, null);
    methodWriter.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
    methodWriter.visitInsn(89);
    methodWriter.visitMethodInsn(183, ASMUtils.type(paramContext.getInstClass()), "<init>", "()V");
    methodWriter.visitInsn(176);
    methodWriter.visitMaxs(3, 3);
    methodWriter.visitEnd();
  }
  
  private void _createInstance(Context paramContext, MethodVisitor paramMethodVisitor) {
    Constructor constructor = paramContext.beanInfo.defaultConstructor;
    if (Modifier.isPublic(constructor.getModifiers())) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(paramContext.getInstClass()));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(constructor.getDeclaringClass()), "<init>", "()V");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
      return;
    } 
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    String str = ASMUtils.type(ASMJavaBeanDeserializer.class);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(DefaultJSONParser);
    stringBuilder.append(";)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(183, str, "createInstance", stringBuilder.toString());
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramContext.getInstClass()));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
  }
  
  private void _deserObject(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt) {
    _getFieldDeser(paramContext, paramMethodVisitor, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(25, 1);
    if (paramFieldInfo.fieldType instanceof Class) {
      paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
    } 
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str = ASMUtils.type(ObjectDeserializer.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(L");
    stringBuilder2.append(DefaultJSONParser);
    stringBuilder2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(185, str, "deserialze", stringBuilder2.toString());
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
  }
  
  private void _deserialize_endCheck(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel) {
    paramMethodVisitor.visitIntInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitJumpInsn(158, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "RBRACE", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
  }
  
  private void _deserialze_list_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass1, Class<?> paramClass2, int paramInt) {
    Label label1 = new Label();
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(153, label1);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    Label label3 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "NULL", "I");
    paramMethodVisitor.visitJumpInsn(160, label3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label1);
    paramMethodVisitor.visitLabel(label3);
    label3 = new Label();
    Label label5 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "SET", "I");
    paramMethodVisitor.visitJumpInsn(160, label5);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _newCollection(paramMethodVisitor, paramClass1, paramInt, true);
    paramMethodVisitor.visitJumpInsn(167, label3);
    paramMethodVisitor.visitLabel(label5);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _newCollection(paramMethodVisitor, paramClass1, paramInt, false);
    paramMethodVisitor.visitLabel(label3);
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder4.toString()));
    _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
    paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(ObjectDeserializer.class), "getFastMatchToken", "()I");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitVarInsn(25, 1);
    String str4 = DefaultJSONParser;
    StringBuilder stringBuilder5 = new StringBuilder();
    stringBuilder5.append("()");
    stringBuilder5.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str4, "getContext", stringBuilder5.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("listContext"));
    paramMethodVisitor.visitVarInsn(25, 1);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder3.toString()));
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str3 = DefaultJSONParser;
    stringBuilder5 = new StringBuilder();
    stringBuilder5.append("(Ljava/lang/Object;Ljava/lang/Object;)");
    stringBuilder5.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "setContext", stringBuilder5.toString());
    paramMethodVisitor.visitInsn(87);
    Label label2 = new Label();
    Label label4 = new Label();
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
    paramMethodVisitor.visitLabel(label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(159, label4);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str5 = paramContext.className;
    StringBuilder stringBuilder7 = new StringBuilder();
    stringBuilder7.append(paramFieldInfo.name);
    stringBuilder7.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str5, stringBuilder7.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass2)));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    String str2 = ASMUtils.type(ObjectDeserializer.class);
    StringBuilder stringBuilder6 = new StringBuilder();
    stringBuilder6.append("(L");
    stringBuilder6.append(DefaultJSONParser);
    stringBuilder6.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitMethodInsn(185, str2, "deserialze", stringBuilder6.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
    paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder2.toString()));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
    if (paramClass1.isInterface()) {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } else {
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramClass1), "add", "(Ljava/lang/Object;)Z");
    } 
    paramMethodVisitor.visitInsn(87);
    paramMethodVisitor.visitVarInsn(25, 1);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm");
    paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder1.toString()));
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "checkListResolve", "(Ljava/util/Collection;)V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
    paramMethodVisitor.visitJumpInsn(160, label2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitJumpInsn(167, label2);
    paramMethodVisitor.visitLabel(label4);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("listContext"));
    String str1 = DefaultJSONParser;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    stringBuilder1.append(ASMUtils.desc(ParseContext.class));
    stringBuilder1.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str1, "setContext", stringBuilder1.toString());
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, JSONToken, "COMMA", "I");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    paramMethodVisitor.visitLabel(label1);
  }
  
  private void _deserialze_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt) {
    Label label = new Label();
    paramLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(25, 0);
    String str3 = paramContext.className;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(paramFieldInfo.name);
    stringBuilder4.append("_asm_prefix__");
    paramMethodVisitor.visitFieldInsn(180, str3, stringBuilder4.toString(), "[C");
    paramMethodVisitor.visitMethodInsn(182, JSONLexerBase, "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(154, label);
    paramMethodVisitor.visitInsn(1);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm");
    paramMethodVisitor.visitVarInsn(58, paramContext.var(stringBuilder3.toString()));
    paramMethodVisitor.visitJumpInsn(167, paramLabel);
    paramMethodVisitor.visitLabel(label);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitInsn(4);
    paramMethodVisitor.visitInsn(96);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("matchedCount"));
    _deserObject(paramContext, paramMethodVisitor, paramFieldInfo, paramClass, paramInt);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "getResolveStatus", "()I");
    paramMethodVisitor.visitFieldInsn(178, DefaultJSONParser, "NeedToResolve", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    paramMethodVisitor.visitVarInsn(25, 1);
    String str2 = DefaultJSONParser;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(DefaultJSONParser.ResolveTask.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getLastResolveTask", stringBuilder2.toString());
    paramMethodVisitor.visitVarInsn(58, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 1);
    str2 = DefaultJSONParser;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getContext", stringBuilder2.toString());
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "ownerContext", ASMUtils.desc(ParseContext.class));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.name);
    String str1 = ASMUtils.type(ASMJavaBeanDeserializer.class);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(Ljava/lang/String;)");
    stringBuilder1.append(ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str1, "getFieldDeserializer", stringBuilder1.toString());
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(DefaultJSONParser.ResolveTask.class), "fieldDeserializer", ASMUtils.desc(FieldDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitFieldInsn(178, DefaultJSONParser, "NONE", "I");
    paramMethodVisitor.visitMethodInsn(182, DefaultJSONParser, "setResolveStatus", "(I)V");
    paramMethodVisitor.visitLabel(paramLabel);
  }
  
  private void _getCollectionFieldItemDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str3 = paramContext.className;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramFieldInfo.name);
    stringBuilder3.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str3, stringBuilder3.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    str3 = DefaultJSONParser;
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("()");
    stringBuilder3.append(ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitMethodInsn(182, str3, "getConfig", stringBuilder3.toString());
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramClass)));
    String str2 = ASMUtils.type(ParserConfig.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/reflect/Type;)");
    stringBuilder2.append(ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getDeserializer", stringBuilder2.toString());
    str2 = paramContext.className;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(181, str2, stringBuilder2.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_list_item_deser__");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _getFieldDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    String str2 = paramContext.className;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(180, str2, stringBuilder2.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, label);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    str2 = DefaultJSONParser;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(ParserConfig.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getConfig", stringBuilder2.toString());
    paramMethodVisitor.visitLdcInsn(Type.getType(ASMUtils.desc(paramFieldInfo.fieldClass)));
    str2 = ASMUtils.type(ParserConfig.class);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(Ljava/lang/reflect/Type;)");
    stringBuilder2.append(ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, str2, "getDeserializer", stringBuilder2.toString());
    str2 = paramContext.className;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramFieldInfo.name);
    stringBuilder2.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(181, str2, stringBuilder2.toString(), ASMUtils.desc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(label);
    paramMethodVisitor.visitVarInsn(25, 0);
    String str1 = paramContext.className;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramFieldInfo.name);
    stringBuilder1.append("_asm_deser__");
    paramMethodVisitor.visitFieldInsn(180, str1, stringBuilder1.toString(), ASMUtils.desc(ObjectDeserializer.class));
  }
  
  private void _init(ClassWriter paramClassWriter, Context paramContext) {
    int j = paramContext.fieldInfoList.length;
    int i;
    for (i = 0; i < j; i++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[i];
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(fieldInfo.name);
      stringBuilder.append("_asm_prefix__");
      (new FieldWriter(paramClassWriter, 1, stringBuilder.toString(), "[C")).visitEnd();
    } 
    j = paramContext.fieldInfoList.length;
    for (i = 0; i < j; i++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[i];
      Class<?> clazz = fieldInfo.fieldClass;
      if (!clazz.isPrimitive() && !clazz.isEnum())
        if (Collection.class.isAssignableFrom(clazz)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(fieldInfo.name);
          stringBuilder.append("_asm_list_item_deser__");
          (new FieldWriter(paramClassWriter, 1, stringBuilder.toString(), ASMUtils.desc(ObjectDeserializer.class))).visitEnd();
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(fieldInfo.name);
          stringBuilder.append("_asm_deser__");
          (new FieldWriter(paramClassWriter, 1, stringBuilder.toString(), ASMUtils.desc(ObjectDeserializer.class))).visitEnd();
        }  
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(");
    stringBuilder1.append(ASMUtils.desc(ParserConfig.class));
    stringBuilder1.append("Ljava/lang/Class;)V");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "<init>", stringBuilder1.toString(), null, null);
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    String str = ASMUtils.type(ASMJavaBeanDeserializer.class);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(");
    stringBuilder2.append(ASMUtils.desc(ParserConfig.class));
    stringBuilder2.append("Ljava/lang/Class;)V");
    methodWriter.visitMethodInsn(183, str, "<init>", stringBuilder2.toString());
    j = paramContext.fieldInfoList.length;
    for (i = 0; i < j; i++) {
      FieldInfo fieldInfo = paramContext.fieldInfoList[i];
      methodWriter.visitVarInsn(25, 0);
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("\"");
      stringBuilder2.append(fieldInfo.name);
      stringBuilder2.append("\":");
      methodWriter.visitLdcInsn(stringBuilder2.toString());
      methodWriter.visitMethodInsn(182, "java/lang/String", "toCharArray", "()[C");
      String str1 = paramContext.className;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(fieldInfo.name);
      stringBuilder.append("_asm_prefix__");
      methodWriter.visitFieldInsn(181, str1, stringBuilder.toString(), "[C");
    } 
    methodWriter.visitInsn(177);
    methodWriter.visitMaxs(4, 4);
    methodWriter.visitEnd();
  }
  
  private void _isEnable(Context paramContext, MethodVisitor paramMethodVisitor, Feature paramFeature) {
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.type(Feature.class), paramFeature.name(), ASMUtils.desc(Feature.class));
    String str = JSONLexerBase;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(ASMUtils.desc(Feature.class));
    stringBuilder.append(")Z");
    paramMethodVisitor.visitMethodInsn(182, str, "isEnabled", stringBuilder.toString());
  }
  
  private void _loadAndSet(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    StringBuilder stringBuilder;
    Class<boolean> clazz = paramFieldInfo.fieldClass;
    Type type = paramFieldInfo.fieldType;
    if (clazz == boolean.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    } 
    if (stringBuilder == byte.class || stringBuilder == short.class || stringBuilder == int.class || stringBuilder == char.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    } 
    if (stringBuilder == long.class) {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(22, paramContext.var(stringBuilder.toString(), 2));
      if (paramFieldInfo.method != null) {
        paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramContext.getInstClass()), paramFieldInfo.method.getName(), ASMUtils.desc(paramFieldInfo.method));
        if (!paramFieldInfo.method.getReturnType().equals(void.class)) {
          paramMethodVisitor.visitInsn(87);
          return;
        } 
      } else {
        paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
        return;
      } 
    } else {
      if (stringBuilder == float.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(23, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      if (stringBuilder == double.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(24, paramContext.var(stringBuilder.toString(), 2));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      if (stringBuilder == String.class) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      if (stringBuilder.isEnum()) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramFieldInfo.name);
        stringBuilder.append("_asm");
        paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      if (Collection.class.isAssignableFrom((Class<?>)stringBuilder)) {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        if (TypeUtils.getCollectionItemClass(type) == String.class) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramFieldInfo.name);
          stringBuilder1.append("_asm");
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder1.toString()));
          paramMethodVisitor.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder));
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append(paramFieldInfo.name);
          stringBuilder.append("_asm");
          paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
        } 
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
        return;
      } 
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramFieldInfo.name);
      stringBuilder.append("_asm");
      paramMethodVisitor.visitVarInsn(25, paramContext.var(stringBuilder.toString()));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
      return;
    } 
  }
  
  private void _newCollection(MethodVisitor paramMethodVisitor, Class<?> paramClass, int paramInt, boolean paramBoolean) {
    if (paramClass.isAssignableFrom(ArrayList.class) && !paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, "java/util/ArrayList");
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, "java/util/ArrayList", "<init>", "()V");
    } else if (paramClass.isAssignableFrom(LinkedList.class) && !paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedList.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedList.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(HashSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(TreeSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(TreeSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(TreeSet.class), "<init>", "()V");
    } else if (paramClass.isAssignableFrom(LinkedHashSet.class)) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(LinkedHashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(LinkedHashSet.class), "<init>", "()V");
    } else if (paramBoolean) {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.type(HashSet.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.type(HashSet.class), "<init>", "()V");
    } else {
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(Integer.valueOf(paramInt));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
      paramMethodVisitor.visitMethodInsn(184, ASMUtils.type(TypeUtils.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
    } 
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.type(paramClass));
  }
  
  private void _set(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo) {
    if (paramFieldInfo.method != null) {
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.method.getName(), ASMUtils.desc(paramFieldInfo.method));
      if (!paramFieldInfo.method.getReturnType().equals(void.class)) {
        paramMethodVisitor.visitInsn(87);
        return;
      } 
    } else {
      paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(paramFieldInfo.declaringClass), paramFieldInfo.field.getName(), ASMUtils.desc(paramFieldInfo.fieldClass));
    } 
  }
  
  private void _setContext(Context paramContext, MethodVisitor paramMethodVisitor) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("context"));
    String str = DefaultJSONParser;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(");
    stringBuilder.append(ASMUtils.desc(ParseContext.class));
    stringBuilder.append(")V");
    paramMethodVisitor.visitMethodInsn(182, str, "setContext", stringBuilder.toString());
    Label label = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitJumpInsn(198, label);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    paramMethodVisitor.visitFieldInsn(181, ASMUtils.type(ParseContext.class), "object", "Ljava/lang/Object;");
    paramMethodVisitor.visitLabel(label);
  }
  
  private Class<?> defineClassPublic(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return this.classLoader.defineClassPublic(paramString, paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  private void defineVarLexer(Context paramContext, MethodVisitor paramMethodVisitor) {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitFieldInsn(180, DefaultJSONParser, "lexer", ASMUtils.desc(JSONLexer.class));
    paramMethodVisitor.visitTypeInsn(192, JSONLexerBase);
    paramMethodVisitor.visitVarInsn(58, paramContext.var("lexer"));
  }
  
  void _deserialze(ClassWriter paramClassWriter, Context paramContext) {
    ASMDeserializerFactory aSMDeserializerFactory = this;
    if (paramContext.fieldInfoList.length == 0)
      return; 
    FieldInfo[] arrayOfFieldInfo = paramContext.fieldInfoList;
    int j = arrayOfFieldInfo.length;
    int i = 0;
    while (i < j) {
      FieldInfo fieldInfo = arrayOfFieldInfo[i];
      Class<char> clazz = fieldInfo.fieldClass;
      Type type = fieldInfo.fieldType;
      if (clazz == char.class)
        return; 
      if (!Collection.class.isAssignableFrom(clazz) || (type instanceof ParameterizedType && ((ParameterizedType)type).getActualTypeArguments()[0] instanceof Class)) {
        i++;
        continue;
      } 
      return;
    } 
    Context.access$202(paramContext, paramContext.beanInfo.sortedFields);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("(L");
    stringBuilder1.append(DefaultJSONParser);
    stringBuilder1.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "deserialze", stringBuilder1.toString(), null, null);
    Label label5 = new Label();
    Label label3 = new Label();
    Label label4 = new Label();
    Label label1 = new Label();
    aSMDeserializerFactory.defineVarLexer(paramContext, (MethodVisitor)methodWriter);
    aSMDeserializerFactory._isEnable(paramContext, (MethodVisitor)methodWriter, Feature.SortFeidFastMatch);
    methodWriter.visitJumpInsn(153, label3);
    Label label6 = new Label();
    methodWriter.visitVarInsn(25, 0);
    String str1 = "lexer";
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    String str3 = ASMUtils.type(ASMJavaBeanDeserializer.class);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("(");
    stringBuilder3.append(ASMUtils.desc(JSONLexer.class));
    stringBuilder3.append(")Z");
    methodWriter.visitMethodInsn(183, str3, "isSupportArrayToBean", stringBuilder3.toString());
    methodWriter.visitJumpInsn(153, label6);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitMethodInsn(182, JSONLexerBase, "token", "()I");
    String str5 = JSONToken;
    str3 = "I";
    methodWriter.visitFieldInsn(178, str5, "LBRACKET", "I");
    methodWriter.visitJumpInsn(160, label6);
    methodWriter.visitVarInsn(25, 0);
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, 2);
    methodWriter.visitVarInsn(25, 3);
    str5 = paramContext.className;
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("(L");
    stringBuilder4.append(DefaultJSONParser);
    stringBuilder4.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    methodWriter.visitMethodInsn(183, str5, "deserialzeArrayMapping", stringBuilder4.toString());
    methodWriter.visitInsn(176);
    methodWriter.visitLabel(label6);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitLdcInsn(paramContext.clazz.getName());
    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanType", "(Ljava/lang/String;)I");
    methodWriter.visitFieldInsn(178, JSONLexerBase, "NOT_MATCH", "I");
    methodWriter.visitJumpInsn(159, label3);
    methodWriter.visitVarInsn(25, 1);
    String str2 = DefaultJSONParser;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str2, "getContext", stringBuilder2.toString());
    methodWriter.visitVarInsn(58, paramContext.var("mark_context"));
    methodWriter.visitInsn(3);
    methodWriter.visitVarInsn(54, paramContext.var("matchedCount"));
    aSMDeserializerFactory._createInstance(paramContext, (MethodVisitor)methodWriter);
    methodWriter.visitVarInsn(25, 1);
    str2 = DefaultJSONParser;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("()");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str2, "getContext", stringBuilder2.toString());
    methodWriter.visitVarInsn(58, paramContext.var("context"));
    methodWriter.visitVarInsn(25, 1);
    methodWriter.visitVarInsn(25, paramContext.var("context"));
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    methodWriter.visitVarInsn(25, 3);
    str2 = DefaultJSONParser;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("(");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    stringBuilder2.append("Ljava/lang/Object;Ljava/lang/Object;)");
    stringBuilder2.append(ASMUtils.desc(ParseContext.class));
    methodWriter.visitMethodInsn(182, str2, "setContext", stringBuilder2.toString());
    methodWriter.visitVarInsn(58, paramContext.var("childContext"));
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    String str4 = JSONLexerBase;
    str2 = "matchStat";
    methodWriter.visitFieldInsn(180, str4, "matchStat", "I");
    methodWriter.visitFieldInsn(178, JSONLexerBase, "END", "I");
    methodWriter.visitJumpInsn(159, label4);
    methodWriter.visitInsn(3);
    methodWriter.visitIntInsn(54, paramContext.var("matchStat"));
    j = paramContext.fieldInfoList.length;
    for (i = 0; i < j; i += 32) {
      methodWriter.visitInsn(3);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_asm_flag_");
      stringBuilder.append(i / 32);
      methodWriter.visitVarInsn(54, paramContext.var(stringBuilder.toString()));
    } 
    aSMDeserializerFactory._isEnable(paramContext, (MethodVisitor)methodWriter, Feature.InitStringFieldAsEmpty);
    methodWriter.visitIntInsn(54, paramContext.var("initStringFieldAsEmpty"));
    i = 0;
    Label label2 = label5;
    while (true) {
      FieldInfo fieldInfo;
      String str7 = "_asm";
      if (i < j) {
        StringBuilder stringBuilder5;
        fieldInfo = paramContext.fieldInfoList[i];
        Class<boolean> clazz = fieldInfo.fieldClass;
        if (clazz == boolean.class || clazz == byte.class || clazz == short.class || clazz == int.class) {
          methodWriter.visitInsn(3);
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm");
          methodWriter.visitVarInsn(54, paramContext.var(stringBuilder5.toString()));
        } else if (stringBuilder5 == long.class) {
          methodWriter.visitInsn(9);
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm");
          methodWriter.visitVarInsn(55, paramContext.var(stringBuilder5.toString(), 2));
        } else if (stringBuilder5 == float.class) {
          methodWriter.visitInsn(11);
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm");
          methodWriter.visitVarInsn(56, paramContext.var(stringBuilder5.toString()));
        } else if (stringBuilder5 == double.class) {
          methodWriter.visitInsn(14);
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm");
          methodWriter.visitVarInsn(57, paramContext.var(stringBuilder5.toString(), 2));
        } else {
          if (stringBuilder5 == String.class) {
            Label label7 = new Label();
            Label label8 = new Label();
            methodWriter.visitVarInsn(21, paramContext.var("initStringFieldAsEmpty"));
            methodWriter.visitJumpInsn(153, label8);
            _setFlag((MethodVisitor)methodWriter, paramContext, i);
            methodWriter.visitVarInsn(25, paramContext.var("lexer"));
            methodWriter.visitMethodInsn(182, JSONLexerBase, "stringDefaultValue", "()Ljava/lang/String;");
            methodWriter.visitJumpInsn(167, label7);
            methodWriter.visitLabel(label8);
            methodWriter.visitInsn(1);
            methodWriter.visitLabel(label7);
          } else {
            methodWriter.visitInsn(1);
          } 
          methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder5));
          stringBuilder5 = new StringBuilder();
          stringBuilder5.append(fieldInfo.name);
          stringBuilder5.append("_asm");
          methodWriter.visitVarInsn(58, paramContext.var(stringBuilder5.toString()));
        } 
        i++;
        continue;
      } 
      boolean bool = false;
      i = j;
      for (j = bool;; j++) {
        if (j < i) {
          StringBuilder stringBuilder5;
          FieldInfo fieldInfo1 = paramContext.fieldInfoList[j];
          Class<boolean> clazz = fieldInfo1.fieldClass;
          Type type = fieldInfo1.fieldType;
          Label label7 = new Label();
          if (clazz == boolean.class) {
            methodWriter.visitVarInsn(25, paramContext.var(str1));
            methodWriter.visitVarInsn(25, 0);
            String str = paramContext.className;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(fieldInfo1.name);
            stringBuilder6.append("_asm_prefix__");
            methodWriter.visitFieldInsn(180, str, stringBuilder6.toString(), "[C");
            methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldBoolean", "([C)Z");
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append(fieldInfo1.name);
            stringBuilder5.append((String)fieldInfo);
            methodWriter.visitVarInsn(54, paramContext.var(stringBuilder5.toString()));
          } else {
            StringBuilder stringBuilder6;
            if (stringBuilder5 == byte.class) {
              methodWriter.visitVarInsn(25, paramContext.var(str1));
              methodWriter.visitVarInsn(25, 0);
              String str = paramContext.className;
              StringBuilder stringBuilder7 = new StringBuilder();
              stringBuilder7.append(fieldInfo1.name);
              stringBuilder7.append("_asm_prefix__");
              methodWriter.visitFieldInsn(180, str, stringBuilder7.toString(), "[C");
              methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
              stringBuilder6 = new StringBuilder();
              stringBuilder6.append(fieldInfo1.name);
              stringBuilder6.append((String)fieldInfo);
              methodWriter.visitVarInsn(54, paramContext.var(stringBuilder6.toString()));
            } else {
              StringBuilder stringBuilder7;
              if (stringBuilder6 == short.class) {
                methodWriter.visitVarInsn(25, paramContext.var(str1));
                methodWriter.visitVarInsn(25, 0);
                String str = paramContext.className;
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append(fieldInfo1.name);
                stringBuilder8.append("_asm_prefix__");
                methodWriter.visitFieldInsn(180, str, stringBuilder8.toString(), "[C");
                methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(fieldInfo1.name);
                stringBuilder7.append((String)fieldInfo);
                methodWriter.visitVarInsn(54, paramContext.var(stringBuilder7.toString()));
              } else {
                StringBuilder stringBuilder8;
                if (stringBuilder7 == int.class) {
                  methodWriter.visitVarInsn(25, paramContext.var(str1));
                  methodWriter.visitVarInsn(25, 0);
                  String str = paramContext.className;
                  StringBuilder stringBuilder9 = new StringBuilder();
                  stringBuilder9.append(fieldInfo1.name);
                  stringBuilder9.append("_asm_prefix__");
                  methodWriter.visitFieldInsn(180, str, stringBuilder9.toString(), "[C");
                  methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldInt", "([C)I");
                  stringBuilder8 = new StringBuilder();
                  stringBuilder8.append(fieldInfo1.name);
                  stringBuilder8.append((String)fieldInfo);
                  methodWriter.visitVarInsn(54, paramContext.var(stringBuilder8.toString()));
                } else {
                  StringBuilder stringBuilder9;
                  if (stringBuilder8 == long.class) {
                    methodWriter.visitVarInsn(25, paramContext.var(str1));
                    methodWriter.visitVarInsn(25, 0);
                    String str = paramContext.className;
                    StringBuilder stringBuilder10 = new StringBuilder();
                    stringBuilder10.append(fieldInfo1.name);
                    stringBuilder10.append("_asm_prefix__");
                    methodWriter.visitFieldInsn(180, str, stringBuilder10.toString(), "[C");
                    methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldLong", "([C)J");
                    stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(fieldInfo1.name);
                    stringBuilder9.append((String)fieldInfo);
                    methodWriter.visitVarInsn(55, paramContext.var(stringBuilder9.toString(), 2));
                  } else {
                    StringBuilder stringBuilder10;
                    if (stringBuilder9 == float.class) {
                      methodWriter.visitVarInsn(25, paramContext.var(str1));
                      methodWriter.visitVarInsn(25, 0);
                      String str = paramContext.className;
                      StringBuilder stringBuilder11 = new StringBuilder();
                      stringBuilder11.append(fieldInfo1.name);
                      stringBuilder11.append("_asm_prefix__");
                      methodWriter.visitFieldInsn(180, str, stringBuilder11.toString(), "[C");
                      methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldFloat", "([C)F");
                      stringBuilder10 = new StringBuilder();
                      stringBuilder10.append(fieldInfo1.name);
                      stringBuilder10.append((String)fieldInfo);
                      methodWriter.visitVarInsn(56, paramContext.var(stringBuilder10.toString()));
                    } else {
                      StringBuilder stringBuilder11;
                      if (stringBuilder10 == double.class) {
                        methodWriter.visitVarInsn(25, paramContext.var(str1));
                        methodWriter.visitVarInsn(25, 0);
                        String str = paramContext.className;
                        StringBuilder stringBuilder12 = new StringBuilder();
                        stringBuilder12.append(fieldInfo1.name);
                        stringBuilder12.append("_asm_prefix__");
                        methodWriter.visitFieldInsn(180, str, stringBuilder12.toString(), "[C");
                        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldDouble", "([C)D");
                        stringBuilder11 = new StringBuilder();
                        stringBuilder11.append(fieldInfo1.name);
                        stringBuilder11.append((String)fieldInfo);
                        methodWriter.visitVarInsn(57, paramContext.var(stringBuilder11.toString(), 2));
                      } else {
                        StringBuilder stringBuilder12;
                        if (stringBuilder11 == String.class) {
                          methodWriter.visitVarInsn(25, paramContext.var(str1));
                          methodWriter.visitVarInsn(25, 0);
                          String str = paramContext.className;
                          StringBuilder stringBuilder13 = new StringBuilder();
                          stringBuilder13.append(fieldInfo1.name);
                          stringBuilder13.append("_asm_prefix__");
                          methodWriter.visitFieldInsn(180, str, stringBuilder13.toString(), "[C");
                          methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFieldString", "([C)Ljava/lang/String;");
                          stringBuilder12 = new StringBuilder();
                          stringBuilder12.append(fieldInfo1.name);
                          stringBuilder12.append((String)fieldInfo);
                          methodWriter.visitVarInsn(58, paramContext.var(stringBuilder12.toString()));
                        } else {
                          Label label;
                          if (stringBuilder12.isEnum()) {
                            methodWriter.visitVarInsn(25, paramContext.var(str1));
                            methodWriter.visitVarInsn(25, 0);
                            String str8 = paramContext.className;
                            StringBuilder stringBuilder14 = new StringBuilder();
                            stringBuilder14.append(fieldInfo1.name);
                            stringBuilder14.append("_asm_prefix__");
                            methodWriter.visitFieldInsn(180, str8, stringBuilder14.toString(), "[C");
                            label = new Label();
                            methodWriter.visitInsn(1);
                            methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder12));
                            stringBuilder14 = new StringBuilder();
                            stringBuilder14.append(fieldInfo1.name);
                            stringBuilder14.append((String)fieldInfo);
                            methodWriter.visitVarInsn(58, paramContext.var(stringBuilder14.toString()));
                            methodWriter.visitVarInsn(25, 1);
                            String str10 = DefaultJSONParser;
                            StringBuilder stringBuilder15 = new StringBuilder();
                            stringBuilder15.append("()");
                            stringBuilder15.append(ASMUtils.desc(SymbolTable.class));
                            methodWriter.visitMethodInsn(182, str10, "getSymbolTable", stringBuilder15.toString());
                            str10 = JSONLexerBase;
                            stringBuilder15 = new StringBuilder();
                            stringBuilder15.append("([C");
                            stringBuilder15.append(ASMUtils.desc(SymbolTable.class));
                            stringBuilder15.append(")Ljava/lang/String;");
                            methodWriter.visitMethodInsn(182, str10, "scanFieldSymbol", stringBuilder15.toString());
                            methodWriter.visitInsn(89);
                            StringBuilder stringBuilder13 = new StringBuilder();
                            stringBuilder13.append(fieldInfo1.name);
                            stringBuilder13.append("_asm_enumName");
                            methodWriter.visitVarInsn(58, paramContext.var(stringBuilder13.toString()));
                            methodWriter.visitJumpInsn(198, label);
                            stringBuilder13 = new StringBuilder();
                            stringBuilder13.append(fieldInfo1.name);
                            stringBuilder13.append("_asm_enumName");
                            methodWriter.visitVarInsn(25, paramContext.var(stringBuilder13.toString()));
                            String str9 = ASMUtils.type((Class)stringBuilder12);
                            stringBuilder15 = new StringBuilder();
                            stringBuilder15.append("(Ljava/lang/String;)");
                            stringBuilder15.append(ASMUtils.desc((Class)stringBuilder12));
                            methodWriter.visitMethodInsn(184, str9, "valueOf", stringBuilder15.toString());
                            stringBuilder12 = new StringBuilder();
                            stringBuilder12.append(fieldInfo1.name);
                            stringBuilder12.append((String)fieldInfo);
                            methodWriter.visitVarInsn(58, paramContext.var(stringBuilder12.toString()));
                            methodWriter.visitLabel(label);
                          } else {
                            StringBuilder stringBuilder13;
                            if (Collection.class.isAssignableFrom((Class<?>)stringBuilder12)) {
                              StringBuilder stringBuilder14;
                              methodWriter.visitVarInsn(25, paramContext.var(str1));
                              methodWriter.visitVarInsn(25, 0);
                              String str = paramContext.className;
                              StringBuilder stringBuilder15 = new StringBuilder();
                              stringBuilder15.append(fieldInfo1.name);
                              stringBuilder15.append("_asm_prefix__");
                              methodWriter.visitFieldInsn(180, str, stringBuilder15.toString(), "[C");
                              Class<String> clazz1 = TypeUtils.getCollectionItemClass((Type)label);
                              if (clazz1 == String.class) {
                                methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder12)));
                                String str8 = JSONLexerBase;
                                stringBuilder14 = new StringBuilder();
                                stringBuilder14.append("([CLjava/lang/Class;)");
                                stringBuilder14.append(ASMUtils.desc(Collection.class));
                                methodWriter.visitMethodInsn(182, str8, "scanFieldStringArray", stringBuilder14.toString());
                                stringBuilder13 = new StringBuilder();
                                stringBuilder13.append(fieldInfo1.name);
                                stringBuilder13.append((String)fieldInfo);
                                methodWriter.visitVarInsn(58, paramContext.var(stringBuilder13.toString()));
                              } else {
                                _deserialze_list_obj(paramContext, (MethodVisitor)methodWriter, label2, fieldInfo1, (Class<?>)stringBuilder13, (Class<?>)stringBuilder14, j);
                                if (j == i - 1)
                                  _deserialize_endCheck(paramContext, (MethodVisitor)methodWriter, label2); 
                                j++;
                              } 
                            } else {
                              _deserialze_obj(paramContext, (MethodVisitor)methodWriter, label2, fieldInfo1, (Class<?>)stringBuilder13, j);
                              if (j == i - 1)
                                _deserialize_endCheck(paramContext, (MethodVisitor)methodWriter, label2); 
                              j++;
                            } 
                          } 
                        } 
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
          methodWriter.visitVarInsn(25, paramContext.var(str1));
          methodWriter.visitFieldInsn(180, JSONLexerBase, str2, str3);
          Label label8 = new Label();
          methodWriter.visitJumpInsn(158, label8);
          _setFlag((MethodVisitor)methodWriter, paramContext, j);
          methodWriter.visitLabel(label8);
          methodWriter.visitVarInsn(25, paramContext.var(str1));
          methodWriter.visitFieldInsn(180, JSONLexerBase, str2, str3);
          methodWriter.visitInsn(89);
          methodWriter.visitVarInsn(54, paramContext.var(str2));
          methodWriter.visitFieldInsn(178, JSONLexerBase, "NOT_MATCH", str3);
          methodWriter.visitJumpInsn(159, label2);
          methodWriter.visitVarInsn(25, paramContext.var(str1));
          methodWriter.visitFieldInsn(180, JSONLexerBase, str2, str3);
          methodWriter.visitJumpInsn(158, label7);
          methodWriter.visitVarInsn(21, paramContext.var("matchedCount"));
          methodWriter.visitInsn(4);
          methodWriter.visitInsn(96);
          methodWriter.visitVarInsn(54, paramContext.var("matchedCount"));
          methodWriter.visitVarInsn(25, paramContext.var(str1));
          methodWriter.visitFieldInsn(180, JSONLexerBase, str2, str3);
          methodWriter.visitFieldInsn(178, JSONLexerBase, "END", str3);
          methodWriter.visitJumpInsn(159, label1);
          methodWriter.visitLabel(label7);
          if (j == i - 1) {
            methodWriter.visitVarInsn(25, paramContext.var(str1));
            methodWriter.visitFieldInsn(180, JSONLexerBase, str2, str3);
            methodWriter.visitFieldInsn(178, JSONLexerBase, "END", str3);
            methodWriter.visitJumpInsn(160, label2);
          } 
        } else {
          break;
        } 
      } 
      methodWriter.visitLabel(label1);
      if (!paramContext.clazz.isInterface() && !Modifier.isAbstract(paramContext.clazz.getModifiers()))
        _batchSet(paramContext, (MethodVisitor)methodWriter); 
      methodWriter.visitLabel(label4);
      _setContext(paramContext, (MethodVisitor)methodWriter);
      methodWriter.visitVarInsn(25, paramContext.var("instance"));
      Method method = paramContext.beanInfo.buildMethod;
      if (method != null) {
        String str = ASMUtils.type(paramContext.getInstClass());
        str1 = method.getName();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("()");
        stringBuilder5.append(ASMUtils.desc(method.getReturnType()));
        methodWriter.visitMethodInsn(182, str, str1, stringBuilder5.toString());
      } 
      methodWriter.visitInsn(176);
      methodWriter.visitLabel(label2);
      _batchSet(paramContext, (MethodVisitor)methodWriter);
      methodWriter.visitVarInsn(25, 0);
      methodWriter.visitVarInsn(25, 1);
      methodWriter.visitVarInsn(25, 2);
      methodWriter.visitVarInsn(25, 3);
      methodWriter.visitVarInsn(25, paramContext.var("instance"));
      String str6 = ASMUtils.type(ASMJavaBeanDeserializer.class);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(DefaultJSONParser);
      stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
      methodWriter.visitMethodInsn(182, str6, "parseRest", stringBuilder.toString());
      methodWriter.visitTypeInsn(192, ASMUtils.type(paramContext.clazz));
      methodWriter.visitInsn(176);
      methodWriter.visitLabel(label3);
      methodWriter.visitVarInsn(25, 0);
      methodWriter.visitVarInsn(25, 1);
      methodWriter.visitVarInsn(25, 2);
      methodWriter.visitVarInsn(25, 3);
      str6 = ASMUtils.type(ASMJavaBeanDeserializer.class);
      stringBuilder = new StringBuilder();
      stringBuilder.append("(L");
      stringBuilder.append(DefaultJSONParser);
      stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
      methodWriter.visitMethodInsn(183, str6, "deserialze", stringBuilder.toString());
      methodWriter.visitInsn(176);
      methodWriter.visitMaxs(5, paramContext.variantIndex);
      methodWriter.visitEnd();
      return;
    } 
  }
  
  void _deserialzeArrayMapping(ClassWriter paramClassWriter, Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(L");
    stringBuilder.append(DefaultJSONParser);
    stringBuilder.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    MethodWriter methodWriter = new MethodWriter(paramClassWriter, 1, "deserialzeArrayMapping", stringBuilder.toString(), null, null);
    defineVarLexer(paramContext, (MethodVisitor)methodWriter);
    _createInstance(paramContext, (MethodVisitor)methodWriter);
    FieldInfo[] arrayOfFieldInfo = paramContext.beanInfo.sortedFields;
    int i = arrayOfFieldInfo.length;
    int j;
    for (j = 0; j < i; j++) {
      boolean bool;
      byte b;
      StringBuilder stringBuilder1;
      if (j == i - 1) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        b = 93;
      } else {
        b = 44;
      } 
      FieldInfo fieldInfo = arrayOfFieldInfo[j];
      Class<byte> clazz = fieldInfo.fieldClass;
      Type type = fieldInfo.fieldType;
      if (clazz == byte.class || clazz == short.class || clazz == int.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanInt", "(C)I");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == long.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanLong", "(C)J");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(55, paramContext.var(stringBuilder1.toString(), 2));
      } else if (stringBuilder1 == boolean.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanBoolean", "(C)Z");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == float.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanFloat", "(C)F");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(56, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == double.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanDouble", "(C)D");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(57, paramContext.var(stringBuilder1.toString(), 2));
      } else if (stringBuilder1 == char.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
        methodWriter.visitInsn(3);
        methodWriter.visitMethodInsn(182, "java/lang/String", "charAt", "(I)C");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(54, paramContext.var(stringBuilder1.toString()));
      } else if (stringBuilder1 == String.class) {
        methodWriter.visitVarInsn(25, paramContext.var("lexer"));
        methodWriter.visitVarInsn(16, b);
        methodWriter.visitMethodInsn(182, JSONLexerBase, "scanString", "(C)Ljava/lang/String;");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(fieldInfo.name);
        stringBuilder1.append("_asm");
        methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
      } else {
        String str;
        if (stringBuilder1.isEnum()) {
          methodWriter.visitVarInsn(25, paramContext.var("lexer"));
          methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder1)));
          methodWriter.visitVarInsn(25, 1);
          str = DefaultJSONParser;
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("()");
          stringBuilder2.append(ASMUtils.desc(SymbolTable.class));
          methodWriter.visitMethodInsn(182, str, "getSymbolTable", stringBuilder2.toString());
          methodWriter.visitVarInsn(16, b);
          str = JSONLexerBase;
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("(Ljava/lang/Class;");
          stringBuilder2.append(ASMUtils.desc(SymbolTable.class));
          stringBuilder2.append("C)Ljava/lang/Enum;");
          methodWriter.visitMethodInsn(182, str, "scanEnum", stringBuilder2.toString());
          methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder1));
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(fieldInfo.name);
          stringBuilder1.append("_asm");
          methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
        } else {
          String str1;
          if (Collection.class.isAssignableFrom((Class<?>)stringBuilder1)) {
            Class<String> clazz1 = TypeUtils.getCollectionItemClass((Type)str);
            if (clazz1 == String.class) {
              methodWriter.visitVarInsn(25, paramContext.var("lexer"));
              methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc((Class)stringBuilder1)));
              methodWriter.visitVarInsn(16, b);
              methodWriter.visitMethodInsn(182, JSONLexerBase, "scanStringArray", "(Ljava/lang/Class;C)Ljava/util/Collection;");
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(fieldInfo.name);
              stringBuilder1.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
            } else {
              methodWriter.visitVarInsn(25, 1);
              if (j == 0) {
                methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
              } else {
                methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
              } 
              methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
              methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
              _newCollection((MethodVisitor)methodWriter, (Class<?>)stringBuilder1, j, false);
              methodWriter.visitInsn(89);
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append(fieldInfo.name);
              stringBuilder1.append("_asm");
              methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
              _getCollectionFieldItemDeser(paramContext, (MethodVisitor)methodWriter, fieldInfo, clazz1);
              methodWriter.visitVarInsn(25, 1);
              methodWriter.visitLdcInsn(Type.getType(ASMUtils.desc(clazz1)));
              methodWriter.visitVarInsn(25, 3);
              str1 = ASMUtils.type(ASMUtils.class);
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("(Ljava/util/Collection;");
              stringBuilder1.append(ASMUtils.desc(ObjectDeserializer.class));
              stringBuilder1.append("L");
              stringBuilder1.append(DefaultJSONParser);
              stringBuilder1.append(";");
              stringBuilder1.append("Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
              methodWriter.visitMethodInsn(184, str1, "parseArray", stringBuilder1.toString());
            } 
          } else if (stringBuilder1.isArray()) {
            methodWriter.visitVarInsn(25, paramContext.var("lexer"));
            methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
            methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
            methodWriter.visitVarInsn(25, 1);
            methodWriter.visitVarInsn(25, 0);
            methodWriter.visitLdcInsn(Integer.valueOf(j));
            methodWriter.visitMethodInsn(182, ASMUtils.type(ASMJavaBeanDeserializer.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            methodWriter.visitMethodInsn(182, DefaultJSONParser, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            methodWriter.visitTypeInsn(192, ASMUtils.type((Class)stringBuilder1));
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(((FieldInfo)str1).name);
            stringBuilder1.append("_asm");
            methodWriter.visitVarInsn(58, paramContext.var(stringBuilder1.toString()));
          } else {
            methodWriter.visitVarInsn(25, 1);
            if (j == 0) {
              methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
            } else {
              methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
            } 
            methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
            methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
            _deserObject(paramContext, (MethodVisitor)methodWriter, (FieldInfo)str1, (Class<?>)stringBuilder1, j);
            methodWriter.visitVarInsn(25, 1);
            if (!bool) {
              methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
              methodWriter.visitFieldInsn(178, JSONToken, "LBRACKET", "I");
            } else {
              methodWriter.visitFieldInsn(178, JSONToken, "RBRACKET", "I");
              methodWriter.visitFieldInsn(178, JSONToken, "EOF", "I");
            } 
            methodWriter.visitMethodInsn(182, DefaultJSONParser, "accept", "(II)V");
          } 
        } 
      } 
    } 
    _batchSet(paramContext, (MethodVisitor)methodWriter, false);
    methodWriter.visitVarInsn(25, paramContext.var("lexer"));
    methodWriter.visitFieldInsn(178, JSONToken, "COMMA", "I");
    methodWriter.visitMethodInsn(182, JSONLexerBase, "nextToken", "(I)V");
    methodWriter.visitVarInsn(25, paramContext.var("instance"));
    methodWriter.visitInsn(176);
    methodWriter.visitMaxs(5, paramContext.variantIndex);
    methodWriter.visitEnd();
  }
  
  void _isFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, Label paramLabel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_asm_flag_");
    stringBuilder.append(paramInt / 32);
    paramMethodVisitor.visitVarInsn(21, paramContext.var(stringBuilder.toString()));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(126);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  void _setFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_asm_flag_");
    stringBuilder.append(paramInt / 32);
    String str = stringBuilder.toString();
    paramMethodVisitor.visitVarInsn(21, paramContext.var(str));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(128);
    paramMethodVisitor.visitVarInsn(54, paramContext.var(str));
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType) throws Exception {
    if (!paramClass.isPrimitive()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("FastjsonASMDeserializer_");
      stringBuilder1.append(this.seed.incrementAndGet());
      stringBuilder1.append("_");
      stringBuilder1.append(paramClass.getSimpleName());
      String str2 = stringBuilder1.toString();
      String str3 = ASMDeserializerFactory.class.getPackage().getName();
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str3.replace('.', '/'));
      stringBuilder1.append("/");
      stringBuilder1.append(str2);
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str3);
      stringBuilder2.append(".");
      stringBuilder2.append(str2);
      str2 = stringBuilder2.toString();
      ClassWriter classWriter = new ClassWriter();
      classWriter.visit(49, 33, str1, ASMUtils.type(ASMJavaBeanDeserializer.class), null);
      JavaBeanInfo javaBeanInfo = JavaBeanInfo.build(paramClass, paramType);
      _init(classWriter, new Context(str1, paramParserConfig, javaBeanInfo, 3));
      _createInstance(classWriter, new Context(str1, paramParserConfig, javaBeanInfo, 3));
      _deserialze(classWriter, new Context(str1, paramParserConfig, javaBeanInfo, 4));
      _deserialzeArrayMapping(classWriter, new Context(str1, paramParserConfig, javaBeanInfo, 4));
      byte[] arrayOfByte = classWriter.toByteArray();
      return defineClassPublic(str2, arrayOfByte, 0, arrayOfByte.length).getConstructor(new Class[] { ParserConfig.class, Class.class }).newInstance(new Object[] { paramParserConfig, paramClass });
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not support type :");
    stringBuilder.append(paramClass.getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static class Context {
    private final JavaBeanInfo beanInfo;
    
    private final String className;
    
    private final Class<?> clazz;
    
    private FieldInfo[] fieldInfoList;
    
    private int variantIndex = 5;
    
    private final Map<String, Integer> variants = new HashMap<String, Integer>();
    
    public Context(String param1String, ParserConfig param1ParserConfig, JavaBeanInfo param1JavaBeanInfo, int param1Int) {
      this.className = param1String;
      this.clazz = param1JavaBeanInfo.clazz;
      this.variantIndex = param1Int;
      this.beanInfo = param1JavaBeanInfo;
      this.fieldInfoList = param1JavaBeanInfo.fields;
    }
    
    public Class<?> getInstClass() {
      Class<?> clazz2 = this.beanInfo.builderClass;
      Class<?> clazz1 = clazz2;
      if (clazz2 == null)
        clazz1 = this.clazz; 
      return clazz1;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ASMDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */