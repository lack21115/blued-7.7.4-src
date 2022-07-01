package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

public class ObjectArrayCodec implements ObjectDeserializer, ObjectSerializer {
  public static final ObjectArrayCodec instance = new ObjectArrayCodec();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, JSONArray paramJSONArray) {
    // Byte code:
    //   0: aload_3
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_3
    //   7: invokevirtual size : ()I
    //   10: istore #7
    //   12: aload_2
    //   13: iload #7
    //   15: invokestatic newInstance : (Ljava/lang/Class;I)Ljava/lang/Object;
    //   18: astore #12
    //   20: iconst_0
    //   21: istore #4
    //   23: iload #4
    //   25: iload #7
    //   27: if_icmpge -> 229
    //   30: aload_3
    //   31: iload #4
    //   33: invokevirtual get : (I)Ljava/lang/Object;
    //   36: astore #11
    //   38: aload #11
    //   40: aload_3
    //   41: if_acmpne -> 56
    //   44: aload #12
    //   46: iload #4
    //   48: aload #12
    //   50: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   53: goto -> 220
    //   56: aload_2
    //   57: invokevirtual isArray : ()Z
    //   60: ifeq -> 104
    //   63: aload_2
    //   64: aload #11
    //   66: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   69: ifeq -> 79
    //   72: aload #11
    //   74: astore #9
    //   76: goto -> 92
    //   79: aload_0
    //   80: aload_1
    //   81: aload_2
    //   82: aload #11
    //   84: checkcast com/alibaba/fastjson/JSONArray
    //   87: invokespecial toObjectArray : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Class;Lcom/alibaba/fastjson/JSONArray;)Ljava/lang/Object;
    //   90: astore #9
    //   92: aload #12
    //   94: iload #4
    //   96: aload #9
    //   98: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   101: goto -> 220
    //   104: aload #11
    //   106: instanceof com/alibaba/fastjson/JSONArray
    //   109: ifeq -> 187
    //   112: aload #11
    //   114: checkcast com/alibaba/fastjson/JSONArray
    //   117: astore #9
    //   119: aload #9
    //   121: invokevirtual size : ()I
    //   124: istore #8
    //   126: iconst_0
    //   127: istore #5
    //   129: iconst_0
    //   130: istore #6
    //   132: iload #5
    //   134: iload #8
    //   136: if_icmpge -> 172
    //   139: aload #9
    //   141: iload #5
    //   143: invokevirtual get : (I)Ljava/lang/Object;
    //   146: aload_3
    //   147: if_acmpne -> 163
    //   150: aload #9
    //   152: iload #4
    //   154: aload #12
    //   156: invokevirtual set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: iconst_1
    //   161: istore #6
    //   163: iload #5
    //   165: iconst_1
    //   166: iadd
    //   167: istore #5
    //   169: goto -> 132
    //   172: iload #6
    //   174: ifeq -> 187
    //   177: aload #9
    //   179: invokevirtual toArray : ()[Ljava/lang/Object;
    //   182: astore #9
    //   184: goto -> 190
    //   187: aconst_null
    //   188: astore #9
    //   190: aload #9
    //   192: astore #10
    //   194: aload #9
    //   196: ifnonnull -> 211
    //   199: aload #11
    //   201: aload_2
    //   202: aload_1
    //   203: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   206: invokestatic cast : (Ljava/lang/Object;Ljava/lang/Class;Lcom/alibaba/fastjson/parser/ParserConfig;)Ljava/lang/Object;
    //   209: astore #10
    //   211: aload #12
    //   213: iload #4
    //   215: aload #10
    //   217: invokestatic set : (Ljava/lang/Object;ILjava/lang/Object;)V
    //   220: iload #4
    //   222: iconst_1
    //   223: iadd
    //   224: istore #4
    //   226: goto -> 23
    //   229: aload_3
    //   230: aload #12
    //   232: invokevirtual setRelatedArray : (Ljava/lang/Object;)V
    //   235: aload_3
    //   236: aload_2
    //   237: invokevirtual setComponentType : (Ljava/lang/reflect/Type;)V
    //   240: aload #12
    //   242: areturn
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type<Object> paramType, Object paramObject) {
    byte[] arrayOfByte;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int i = jSONLexer.token();
    Type<Object> type1 = null;
    Type<Object> type2 = null;
    if (i == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    if (jSONLexer.token() == 4) {
      arrayOfByte = jSONLexer.bytesValue();
      jSONLexer.nextToken(16);
      return (T)arrayOfByte;
    } 
    if (paramType instanceof GenericArrayType) {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      if (paramType instanceof TypeVariable) {
        TypeVariable typeVariable = (TypeVariable)paramType;
        paramType = (arrayOfByte.getContext()).type;
        boolean bool = paramType instanceof ParameterizedType;
        i = 0;
        if (bool) {
          ParameterizedType parameterizedType = (ParameterizedType)paramType;
          paramType = parameterizedType.getRawType();
          if (paramType instanceof Class) {
            TypeVariable[] arrayOfTypeVariable = ((Class)paramType).getTypeParameters();
            paramType = type2;
            while (true) {
              type1 = paramType;
              if (i < arrayOfTypeVariable.length) {
                if (arrayOfTypeVariable[i].getName().equals(typeVariable.getName()))
                  paramType = parameterizedType.getActualTypeArguments()[i]; 
                i++;
                continue;
              } 
              break;
            } 
          } 
          if (type1 instanceof Class) {
            paramType = type1;
          } else {
            paramType = Object.class;
          } 
        } else {
          paramType = TypeUtils.getClass(typeVariable.getBounds()[0]);
        } 
      } else {
        paramType = TypeUtils.getClass(paramType);
      } 
    } else {
      paramType = ((Class)paramType).getComponentType();
    } 
    JSONArray jSONArray = new JSONArray();
    arrayOfByte.parseArray(paramType, (Collection)jSONArray, paramObject);
    return toObjectArray((DefaultJSONParser)arrayOfByte, (Class<?>)paramType, jSONArray);
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object<?> paramObject1, Object<?> paramObject2, Type<?> paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    Object[] arrayOfObject = (Object[])paramObject1;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        serializeWriter.write("[]");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    int j = arrayOfObject.length;
    int i = j - 1;
    if (i == -1) {
      serializeWriter.append("[]");
      return;
    } 
    SerialContext serialContext = paramJSONSerializer.context;
    paramInt = 0;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
        paramJSONSerializer.incrementIndent();
        paramJSONSerializer.println();
        while (paramInt < j) {
          if (paramInt != 0) {
            serializeWriter.write(44);
            paramJSONSerializer.println();
          } 
          paramJSONSerializer.write(arrayOfObject[paramInt]);
          paramInt++;
        } 
        paramJSONSerializer.decrementIdent();
        paramJSONSerializer.println();
        serializeWriter.write(93);
        return;
      } 
      paramObject2 = null;
      paramObject1 = paramObject2;
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ObjectArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */