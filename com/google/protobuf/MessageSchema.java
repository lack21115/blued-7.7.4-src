package com.google.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class MessageSchema<T> implements Schema<T> {
  private static final int[] EMPTY_INT_ARRAY = new int[0];
  
  private static final int ENFORCE_UTF8_MASK = 536870912;
  
  private static final int FIELD_TYPE_MASK = 267386880;
  
  private static final int INTS_PER_FIELD = 3;
  
  private static final int NO_PRESENCE_SENTINEL = 1048575;
  
  private static final int OFFSET_BITS = 20;
  
  private static final int OFFSET_MASK = 1048575;
  
  static final int ONEOF_TYPE_OFFSET = 51;
  
  private static final int REQUIRED_MASK = 268435456;
  
  private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
  
  private final int[] buffer;
  
  private final int checkInitializedCount;
  
  private final MessageLite defaultInstance;
  
  private final ExtensionSchema<?> extensionSchema;
  
  private final boolean hasExtensions;
  
  private final int[] intArray;
  
  private final ListFieldSchema listFieldSchema;
  
  private final boolean lite;
  
  private final MapFieldSchema mapFieldSchema;
  
  private final int maxFieldNumber;
  
  private final int minFieldNumber;
  
  private final NewInstanceSchema newInstanceSchema;
  
  private final Object[] objects;
  
  private final boolean proto3;
  
  private final int repeatedFieldOffsetStart;
  
  private final UnknownFieldSchema<?, ?> unknownFieldSchema;
  
  private final boolean useCachedSizeField;
  
  private MessageSchema(int[] paramArrayOfint1, Object[] paramArrayOfObject, int paramInt1, int paramInt2, MessageLite paramMessageLite, boolean paramBoolean1, boolean paramBoolean2, int[] paramArrayOfint2, int paramInt3, int paramInt4, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema) {
    this.buffer = paramArrayOfint1;
    this.objects = paramArrayOfObject;
    this.minFieldNumber = paramInt1;
    this.maxFieldNumber = paramInt2;
    this.lite = paramMessageLite instanceof GeneratedMessageLite;
    this.proto3 = paramBoolean1;
    if (paramExtensionSchema != null && paramExtensionSchema.hasExtensions(paramMessageLite)) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    } 
    this.hasExtensions = paramBoolean1;
    this.useCachedSizeField = paramBoolean2;
    this.intArray = paramArrayOfint2;
    this.checkInitializedCount = paramInt3;
    this.repeatedFieldOffsetStart = paramInt4;
    this.newInstanceSchema = paramNewInstanceSchema;
    this.listFieldSchema = paramListFieldSchema;
    this.unknownFieldSchema = paramUnknownFieldSchema;
    this.extensionSchema = paramExtensionSchema;
    this.defaultInstance = paramMessageLite;
    this.mapFieldSchema = paramMapFieldSchema;
  }
  
  private boolean arePresentForEquals(T paramT1, T paramT2, int paramInt) {
    return (isFieldPresent(paramT1, paramInt) == isFieldPresent(paramT2, paramInt));
  }
  
  private static <T> boolean booleanAt(T paramT, long paramLong) {
    return UnsafeUtil.getBoolean(paramT, paramLong);
  }
  
  private <K, V> int decodeMapEntry(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap, ArrayDecoders.Registers paramRegisters) throws IOException {
    paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
    int i = paramRegisters.int1;
    if (i >= 0 && i <= paramInt2 - paramInt1) {
      int j = paramInt1 + i;
      K k = paramMetadata.defaultKey;
      V v = paramMetadata.defaultValue;
      while (paramInt1 < j) {
        i = paramInt1 + 1;
        paramInt1 = paramArrayOfbyte[paramInt1];
        if (paramInt1 < 0) {
          i = ArrayDecoders.decodeVarint32(paramInt1, paramArrayOfbyte, i, paramRegisters);
          paramInt1 = paramRegisters.int1;
        } 
        int m = paramInt1 >>> 3;
        int n = paramInt1 & 0x7;
        if (m != 1) {
          if (m == 2 && n == paramMetadata.valueType.getWireType()) {
            paramInt1 = decodeMapEntryValue(paramArrayOfbyte, i, paramInt2, paramMetadata.valueType, paramMetadata.defaultValue.getClass(), paramRegisters);
            v = (V)paramRegisters.object1;
            continue;
          } 
        } else if (n == paramMetadata.keyType.getWireType()) {
          paramInt1 = decodeMapEntryValue(paramArrayOfbyte, i, paramInt2, paramMetadata.keyType, null, paramRegisters);
          k = (K)paramRegisters.object1;
          continue;
        } 
        paramInt1 = ArrayDecoders.skipField(paramInt1, paramArrayOfbyte, i, paramInt2, paramRegisters);
      } 
      if (paramInt1 == j) {
        paramMap.put(k, v);
        return j;
      } 
      throw InvalidProtocolBufferException.parseFailure();
    } 
    throw InvalidProtocolBufferException.truncatedMessage();
  }
  
  private int decodeMapEntryValue(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, WireFormat.FieldType paramFieldType, Class<?> paramClass, ArrayDecoders.Registers paramRegisters) throws IOException {
    boolean bool;
    switch (paramFieldType) {
      default:
        throw new RuntimeException("unsupported field type.");
      case null:
        return ArrayDecoders.decodeStringRequireUtf8(paramArrayOfbyte, paramInt1, paramRegisters);
      case SINT64:
        paramInt1 = ArrayDecoders.decodeVarint64(paramArrayOfbyte, paramInt1, paramRegisters);
        paramRegisters.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(paramRegisters.long1));
        return paramInt1;
      case SINT32:
        paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
        paramRegisters.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(paramRegisters.int1));
        return paramInt1;
      case MESSAGE:
        return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(paramClass), paramArrayOfbyte, paramInt1, paramInt2, paramRegisters);
      case INT64:
      case UINT64:
        paramInt1 = ArrayDecoders.decodeVarint64(paramArrayOfbyte, paramInt1, paramRegisters);
        paramRegisters.object1 = Long.valueOf(paramRegisters.long1);
        return paramInt1;
      case ENUM:
      case INT32:
      case UINT32:
        paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
        paramRegisters.object1 = Integer.valueOf(paramRegisters.int1);
        return paramInt1;
      case FLOAT:
        paramRegisters.object1 = Float.valueOf(ArrayDecoders.decodeFloat(paramArrayOfbyte, paramInt1));
        return paramInt1 + 4;
      case FIXED64:
      case SFIXED64:
        paramRegisters.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(paramArrayOfbyte, paramInt1));
        return paramInt1 + 8;
      case FIXED32:
      case SFIXED32:
        paramRegisters.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(paramArrayOfbyte, paramInt1));
        return paramInt1 + 4;
      case DOUBLE:
        paramRegisters.object1 = Double.valueOf(ArrayDecoders.decodeDouble(paramArrayOfbyte, paramInt1));
        return paramInt1 + 8;
      case BYTES:
        return ArrayDecoders.decodeBytes(paramArrayOfbyte, paramInt1, paramRegisters);
      case BOOL:
        break;
    } 
    paramInt1 = ArrayDecoders.decodeVarint64(paramArrayOfbyte, paramInt1, paramRegisters);
    if (paramRegisters.long1 != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    paramRegisters.object1 = Boolean.valueOf(bool);
    return paramInt1;
  }
  
  private static <T> double doubleAt(T paramT, long paramLong) {
    return UnsafeUtil.getDouble(paramT, paramLong);
  }
  
  private boolean equals(T paramT1, T paramT2, int paramInt) {
    int i = typeAndOffsetAt(paramInt);
    long l = offset(i);
    i = type(i);
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool16 = false;
    boolean bool17 = false;
    boolean bool18 = false;
    boolean bool19 = false;
    boolean bool20 = false;
    boolean bool2 = false;
    switch (i) {
      default:
        return true;
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
      case 68:
        bool1 = bool2;
        if (isOneofCaseEqual(paramT1, paramT2, paramInt)) {
          bool1 = bool2;
          if (SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 50:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l));
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
        return SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l));
      case 17:
        bool1 = bool3;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool3;
          if (SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 16:
        bool1 = bool4;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool4;
          if (UnsafeUtil.getLong(paramT1, l) == UnsafeUtil.getLong(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 15:
        bool1 = bool5;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool5;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 14:
        bool1 = bool6;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool6;
          if (UnsafeUtil.getLong(paramT1, l) == UnsafeUtil.getLong(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 13:
        bool1 = bool7;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool7;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 12:
        bool1 = bool8;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool8;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 11:
        bool1 = bool9;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool9;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 10:
        bool1 = bool10;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool10;
          if (SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 9:
        bool1 = bool11;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool11;
          if (SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 8:
        bool1 = bool12;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool12;
          if (SchemaUtil.safeEquals(UnsafeUtil.getObject(paramT1, l), UnsafeUtil.getObject(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 7:
        bool1 = bool13;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool13;
          if (UnsafeUtil.getBoolean(paramT1, l) == UnsafeUtil.getBoolean(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 6:
        bool1 = bool14;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool14;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 5:
        bool1 = bool15;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool15;
          if (UnsafeUtil.getLong(paramT1, l) == UnsafeUtil.getLong(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 4:
        bool1 = bool16;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool16;
          if (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 3:
        bool1 = bool17;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool17;
          if (UnsafeUtil.getLong(paramT1, l) == UnsafeUtil.getLong(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 2:
        bool1 = bool18;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool18;
          if (UnsafeUtil.getLong(paramT1, l) == UnsafeUtil.getLong(paramT2, l))
            bool1 = true; 
        } 
        return bool1;
      case 1:
        bool1 = bool19;
        if (arePresentForEquals(paramT1, paramT2, paramInt)) {
          bool1 = bool19;
          if (Float.floatToIntBits(UnsafeUtil.getFloat(paramT1, l)) == Float.floatToIntBits(UnsafeUtil.getFloat(paramT2, l)))
            bool1 = true; 
        } 
        return bool1;
      case 0:
        break;
    } 
    boolean bool1 = bool20;
    if (arePresentForEquals(paramT1, paramT2, paramInt)) {
      bool1 = bool20;
      if (Double.doubleToLongBits(UnsafeUtil.getDouble(paramT1, l)) == Double.doubleToLongBits(UnsafeUtil.getDouble(paramT2, l)))
        bool1 = true; 
    } 
    return bool1;
  }
  
  private final <UT, UB> UB filterMapUnknownEnumValues(Object paramObject, int paramInt, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema) {
    int i = numberAt(paramInt);
    paramObject = UnsafeUtil.getObject(paramObject, offset(typeAndOffsetAt(paramInt)));
    if (paramObject == null)
      return paramUB; 
    Internal.EnumVerifier enumVerifier = getEnumFieldVerifier(paramInt);
    return (enumVerifier == null) ? paramUB : filterUnknownEnumMap(paramInt, i, this.mapFieldSchema.forMutableMapData(paramObject), enumVerifier, paramUB, paramUnknownFieldSchema);
  }
  
  private final <K, V, UT, UB> UB filterUnknownEnumMap(int paramInt1, int paramInt2, Map<K, V> paramMap, Internal.EnumVerifier paramEnumVerifier, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema) {
    UB uB;
    MapEntryLite.Metadata<?, ?> metadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(paramInt1));
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (!paramEnumVerifier.isInRange(((Integer)entry.getValue()).intValue())) {
        UB uB1 = paramUB;
        if (paramUB == null)
          uB1 = paramUnknownFieldSchema.newBuilder(); 
        ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
        CodedOutputStream codedOutputStream = codedBuilder.getCodedOutput();
        try {
          MapEntryLite.writeTo(codedOutputStream, metadata, entry.getKey(), entry.getValue());
          paramUnknownFieldSchema.addLengthDelimited(uB1, paramInt2, codedBuilder.build());
          iterator.remove();
          uB = uB1;
        } catch (IOException iOException) {
          throw new RuntimeException(iOException);
        } 
      } 
    } 
    return uB;
  }
  
  private static <T> float floatAt(T paramT, long paramLong) {
    return UnsafeUtil.getFloat(paramT, paramLong);
  }
  
  private Internal.EnumVerifier getEnumFieldVerifier(int paramInt) {
    return (Internal.EnumVerifier)this.objects[paramInt / 3 * 2 + 1];
  }
  
  private Object getMapFieldDefaultEntry(int paramInt) {
    return this.objects[paramInt / 3 * 2];
  }
  
  private Schema getMessageFieldSchema(int paramInt) {
    paramInt = paramInt / 3 * 2;
    Schema<?> schema = (Schema)this.objects[paramInt];
    if (schema != null)
      return schema; 
    schema = Protobuf.getInstance().schemaFor((Class)this.objects[paramInt + 1]);
    this.objects[paramInt] = schema;
    return schema;
  }
  
  static UnknownFieldSetLite getMutableUnknownFields(Object paramObject) {
    GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)paramObject;
    UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
    paramObject = unknownFieldSetLite;
    if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
      paramObject = UnknownFieldSetLite.newInstance();
      generatedMessageLite.unknownFields = (UnknownFieldSetLite)paramObject;
    } 
    return (UnknownFieldSetLite)paramObject;
  }
  
  private int getSerializedSizeProto2(T paramT) {
    // Byte code:
    //   0: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   3: astore #15
    //   5: iconst_0
    //   6: istore #6
    //   8: iconst_0
    //   9: istore #5
    //   11: ldc 1048575
    //   13: istore_3
    //   14: iconst_0
    //   15: istore_2
    //   16: iload #6
    //   18: aload_0
    //   19: getfield buffer : [I
    //   22: arraylength
    //   23: if_icmpge -> 2833
    //   26: aload_0
    //   27: iload #6
    //   29: invokespecial typeAndOffsetAt : (I)I
    //   32: istore #11
    //   34: aload_0
    //   35: iload #6
    //   37: invokespecial numberAt : (I)I
    //   40: istore #10
    //   42: iload #11
    //   44: invokestatic type : (I)I
    //   47: istore #12
    //   49: iload #12
    //   51: bipush #17
    //   53: if_icmpgt -> 114
    //   56: aload_0
    //   57: getfield buffer : [I
    //   60: iload #6
    //   62: iconst_2
    //   63: iadd
    //   64: iaload
    //   65: istore #4
    //   67: iload #4
    //   69: ldc 1048575
    //   71: iand
    //   72: istore #7
    //   74: iconst_1
    //   75: iload #4
    //   77: bipush #20
    //   79: iushr
    //   80: ishl
    //   81: istore #9
    //   83: iload #7
    //   85: iload_3
    //   86: if_icmpeq -> 105
    //   89: aload #15
    //   91: aload_1
    //   92: iload #7
    //   94: i2l
    //   95: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   98: istore_2
    //   99: iload #7
    //   101: istore_3
    //   102: goto -> 105
    //   105: iload_3
    //   106: istore #7
    //   108: iload_2
    //   109: istore #8
    //   111: goto -> 172
    //   114: aload_0
    //   115: getfield useCachedSizeField : Z
    //   118: ifeq -> 160
    //   121: iload #12
    //   123: getstatic com/google/protobuf/FieldType.DOUBLE_LIST_PACKED : Lcom/google/protobuf/FieldType;
    //   126: invokevirtual id : ()I
    //   129: if_icmplt -> 160
    //   132: iload #12
    //   134: getstatic com/google/protobuf/FieldType.SINT64_LIST_PACKED : Lcom/google/protobuf/FieldType;
    //   137: invokevirtual id : ()I
    //   140: if_icmpgt -> 160
    //   143: aload_0
    //   144: getfield buffer : [I
    //   147: iload #6
    //   149: iconst_2
    //   150: iadd
    //   151: iaload
    //   152: ldc 1048575
    //   154: iand
    //   155: istore #4
    //   157: goto -> 163
    //   160: iconst_0
    //   161: istore #4
    //   163: iconst_0
    //   164: istore #9
    //   166: iload_2
    //   167: istore #8
    //   169: iload_3
    //   170: istore #7
    //   172: iload #11
    //   174: invokestatic offset : (I)J
    //   177: lstore #13
    //   179: iload #12
    //   181: tableswitch default -> 472, 0 -> 2792, 1 -> 2771, 2 -> 2743, 3 -> 2715, 4 -> 2687, 5 -> 2666, 6 -> 2645, 7 -> 2624, 8 -> 2567, 9 -> 2533, 10 -> 2502, 11 -> 2474, 12 -> 2446, 13 -> 2420, 14 -> 2399, 15 -> 2371, 16 -> 2343, 17 -> 2306, 18 -> 2280, 19 -> 2259, 20 -> 2238, 21 -> 2217, 22 -> 2196, 23 -> 2175, 24 -> 2154, 25 -> 2133, 26 -> 2113, 27 -> 2087, 28 -> 2067, 29 -> 2046, 30 -> 2025, 31 -> 2004, 32 -> 1983, 33 -> 1962, 34 -> 1941, 35 -> 1873, 36 -> 1813, 37 -> 1753, 38 -> 1693, 39 -> 1633, 40 -> 1573, 41 -> 1513, 42 -> 1453, 43 -> 1393, 44 -> 1333, 45 -> 1273, 46 -> 1213, 47 -> 1153, 48 -> 1093, 49 -> 1067, 50 -> 1038, 51 -> 1013, 52 -> 988, 53 -> 958, 54 -> 928, 55 -> 898, 56 -> 873, 57 -> 848, 58 -> 823, 59 -> 762, 60 -> 724, 61 -> 689, 62 -> 659, 63 -> 629, 64 -> 604, 65 -> 579, 66 -> 549, 67 -> 519, 68 -> 478
    //   472: iload #5
    //   474: istore_2
    //   475: goto -> 2303
    //   478: iload #5
    //   480: istore_2
    //   481: aload_0
    //   482: aload_1
    //   483: iload #10
    //   485: iload #6
    //   487: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   490: ifeq -> 2303
    //   493: iload #10
    //   495: aload #15
    //   497: aload_1
    //   498: lload #13
    //   500: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   503: checkcast com/google/protobuf/MessageLite
    //   506: aload_0
    //   507: iload #6
    //   509: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   512: invokestatic computeGroupSize : (ILcom/google/protobuf/MessageLite;Lcom/google/protobuf/Schema;)I
    //   515: istore_2
    //   516: goto -> 2298
    //   519: iload #5
    //   521: istore_2
    //   522: aload_0
    //   523: aload_1
    //   524: iload #10
    //   526: iload #6
    //   528: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   531: ifeq -> 2303
    //   534: iload #10
    //   536: aload_1
    //   537: lload #13
    //   539: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   542: invokestatic computeSInt64Size : (IJ)I
    //   545: istore_2
    //   546: goto -> 2298
    //   549: iload #5
    //   551: istore_2
    //   552: aload_0
    //   553: aload_1
    //   554: iload #10
    //   556: iload #6
    //   558: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   561: ifeq -> 2303
    //   564: iload #10
    //   566: aload_1
    //   567: lload #13
    //   569: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   572: invokestatic computeSInt32Size : (II)I
    //   575: istore_2
    //   576: goto -> 2298
    //   579: iload #5
    //   581: istore_2
    //   582: aload_0
    //   583: aload_1
    //   584: iload #10
    //   586: iload #6
    //   588: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   591: ifeq -> 2303
    //   594: iload #10
    //   596: lconst_0
    //   597: invokestatic computeSFixed64Size : (IJ)I
    //   600: istore_2
    //   601: goto -> 2298
    //   604: iload #5
    //   606: istore_2
    //   607: aload_0
    //   608: aload_1
    //   609: iload #10
    //   611: iload #6
    //   613: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   616: ifeq -> 2303
    //   619: iload #10
    //   621: iconst_0
    //   622: invokestatic computeSFixed32Size : (II)I
    //   625: istore_2
    //   626: goto -> 2438
    //   629: iload #5
    //   631: istore_2
    //   632: aload_0
    //   633: aload_1
    //   634: iload #10
    //   636: iload #6
    //   638: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   641: ifeq -> 2303
    //   644: iload #10
    //   646: aload_1
    //   647: lload #13
    //   649: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   652: invokestatic computeEnumSize : (II)I
    //   655: istore_2
    //   656: goto -> 2298
    //   659: iload #5
    //   661: istore_2
    //   662: aload_0
    //   663: aload_1
    //   664: iload #10
    //   666: iload #6
    //   668: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   671: ifeq -> 2303
    //   674: iload #10
    //   676: aload_1
    //   677: lload #13
    //   679: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   682: invokestatic computeUInt32Size : (II)I
    //   685: istore_2
    //   686: goto -> 2298
    //   689: iload #5
    //   691: istore_2
    //   692: aload_0
    //   693: aload_1
    //   694: iload #10
    //   696: iload #6
    //   698: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   701: ifeq -> 2303
    //   704: iload #10
    //   706: aload #15
    //   708: aload_1
    //   709: lload #13
    //   711: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   714: checkcast com/google/protobuf/ByteString
    //   717: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   720: istore_2
    //   721: goto -> 2298
    //   724: iload #5
    //   726: istore_2
    //   727: aload_0
    //   728: aload_1
    //   729: iload #10
    //   731: iload #6
    //   733: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   736: ifeq -> 2303
    //   739: iload #10
    //   741: aload #15
    //   743: aload_1
    //   744: lload #13
    //   746: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   749: aload_0
    //   750: iload #6
    //   752: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   755: invokestatic computeSizeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)I
    //   758: istore_2
    //   759: goto -> 2298
    //   762: iload #5
    //   764: istore_2
    //   765: aload_0
    //   766: aload_1
    //   767: iload #10
    //   769: iload #6
    //   771: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   774: ifeq -> 2303
    //   777: aload #15
    //   779: aload_1
    //   780: lload #13
    //   782: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   785: astore #16
    //   787: aload #16
    //   789: instanceof com/google/protobuf/ByteString
    //   792: ifeq -> 809
    //   795: iload #10
    //   797: aload #16
    //   799: checkcast com/google/protobuf/ByteString
    //   802: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   805: istore_2
    //   806: goto -> 2298
    //   809: iload #10
    //   811: aload #16
    //   813: checkcast java/lang/String
    //   816: invokestatic computeStringSize : (ILjava/lang/String;)I
    //   819: istore_2
    //   820: goto -> 2298
    //   823: iload #5
    //   825: istore_2
    //   826: aload_0
    //   827: aload_1
    //   828: iload #10
    //   830: iload #6
    //   832: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   835: ifeq -> 2303
    //   838: iload #10
    //   840: iconst_1
    //   841: invokestatic computeBoolSize : (IZ)I
    //   844: istore_2
    //   845: goto -> 2298
    //   848: iload #5
    //   850: istore_2
    //   851: aload_0
    //   852: aload_1
    //   853: iload #10
    //   855: iload #6
    //   857: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   860: ifeq -> 2303
    //   863: iload #10
    //   865: iconst_0
    //   866: invokestatic computeFixed32Size : (II)I
    //   869: istore_2
    //   870: goto -> 2438
    //   873: iload #5
    //   875: istore_2
    //   876: aload_0
    //   877: aload_1
    //   878: iload #10
    //   880: iload #6
    //   882: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   885: ifeq -> 2303
    //   888: iload #10
    //   890: lconst_0
    //   891: invokestatic computeFixed64Size : (IJ)I
    //   894: istore_2
    //   895: goto -> 2298
    //   898: iload #5
    //   900: istore_2
    //   901: aload_0
    //   902: aload_1
    //   903: iload #10
    //   905: iload #6
    //   907: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   910: ifeq -> 2303
    //   913: iload #10
    //   915: aload_1
    //   916: lload #13
    //   918: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   921: invokestatic computeInt32Size : (II)I
    //   924: istore_2
    //   925: goto -> 2298
    //   928: iload #5
    //   930: istore_2
    //   931: aload_0
    //   932: aload_1
    //   933: iload #10
    //   935: iload #6
    //   937: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   940: ifeq -> 2303
    //   943: iload #10
    //   945: aload_1
    //   946: lload #13
    //   948: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   951: invokestatic computeUInt64Size : (IJ)I
    //   954: istore_2
    //   955: goto -> 2298
    //   958: iload #5
    //   960: istore_2
    //   961: aload_0
    //   962: aload_1
    //   963: iload #10
    //   965: iload #6
    //   967: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   970: ifeq -> 2303
    //   973: iload #10
    //   975: aload_1
    //   976: lload #13
    //   978: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   981: invokestatic computeInt64Size : (IJ)I
    //   984: istore_2
    //   985: goto -> 2298
    //   988: iload #5
    //   990: istore_2
    //   991: aload_0
    //   992: aload_1
    //   993: iload #10
    //   995: iload #6
    //   997: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   1000: ifeq -> 2303
    //   1003: iload #10
    //   1005: fconst_0
    //   1006: invokestatic computeFloatSize : (IF)I
    //   1009: istore_2
    //   1010: goto -> 2298
    //   1013: iload #5
    //   1015: istore_2
    //   1016: aload_0
    //   1017: aload_1
    //   1018: iload #10
    //   1020: iload #6
    //   1022: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   1025: ifeq -> 2303
    //   1028: iload #10
    //   1030: dconst_0
    //   1031: invokestatic computeDoubleSize : (ID)I
    //   1034: istore_2
    //   1035: goto -> 2298
    //   1038: aload_0
    //   1039: getfield mapFieldSchema : Lcom/google/protobuf/MapFieldSchema;
    //   1042: iload #10
    //   1044: aload #15
    //   1046: aload_1
    //   1047: lload #13
    //   1049: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1052: aload_0
    //   1053: iload #6
    //   1055: invokespecial getMapFieldDefaultEntry : (I)Ljava/lang/Object;
    //   1058: invokeinterface getSerializedSize : (ILjava/lang/Object;Ljava/lang/Object;)I
    //   1063: istore_2
    //   1064: goto -> 2298
    //   1067: iload #10
    //   1069: aload #15
    //   1071: aload_1
    //   1072: lload #13
    //   1074: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1077: checkcast java/util/List
    //   1080: aload_0
    //   1081: iload #6
    //   1083: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1086: invokestatic computeSizeGroupList : (ILjava/util/List;Lcom/google/protobuf/Schema;)I
    //   1089: istore_2
    //   1090: goto -> 2298
    //   1093: aload #15
    //   1095: aload_1
    //   1096: lload #13
    //   1098: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1101: checkcast java/util/List
    //   1104: invokestatic computeSizeSInt64ListNoTag : (Ljava/util/List;)I
    //   1107: istore_3
    //   1108: iload #5
    //   1110: istore_2
    //   1111: iload_3
    //   1112: ifle -> 2303
    //   1115: aload_0
    //   1116: getfield useCachedSizeField : Z
    //   1119: ifeq -> 1132
    //   1122: aload #15
    //   1124: aload_1
    //   1125: iload #4
    //   1127: i2l
    //   1128: iload_3
    //   1129: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1132: iload #10
    //   1134: invokestatic computeTagSize : (I)I
    //   1137: istore #9
    //   1139: iload_3
    //   1140: invokestatic computeUInt32SizeNoTag : (I)I
    //   1143: istore #4
    //   1145: iload_3
    //   1146: istore_2
    //   1147: iload #9
    //   1149: istore_3
    //   1150: goto -> 1931
    //   1153: aload #15
    //   1155: aload_1
    //   1156: lload #13
    //   1158: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1161: checkcast java/util/List
    //   1164: invokestatic computeSizeSInt32ListNoTag : (Ljava/util/List;)I
    //   1167: istore_3
    //   1168: iload #5
    //   1170: istore_2
    //   1171: iload_3
    //   1172: ifle -> 2303
    //   1175: aload_0
    //   1176: getfield useCachedSizeField : Z
    //   1179: ifeq -> 1192
    //   1182: aload #15
    //   1184: aload_1
    //   1185: iload #4
    //   1187: i2l
    //   1188: iload_3
    //   1189: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1192: iload #10
    //   1194: invokestatic computeTagSize : (I)I
    //   1197: istore #9
    //   1199: iload_3
    //   1200: invokestatic computeUInt32SizeNoTag : (I)I
    //   1203: istore #4
    //   1205: iload_3
    //   1206: istore_2
    //   1207: iload #9
    //   1209: istore_3
    //   1210: goto -> 1931
    //   1213: aload #15
    //   1215: aload_1
    //   1216: lload #13
    //   1218: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1221: checkcast java/util/List
    //   1224: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1227: istore_3
    //   1228: iload #5
    //   1230: istore_2
    //   1231: iload_3
    //   1232: ifle -> 2303
    //   1235: aload_0
    //   1236: getfield useCachedSizeField : Z
    //   1239: ifeq -> 1252
    //   1242: aload #15
    //   1244: aload_1
    //   1245: iload #4
    //   1247: i2l
    //   1248: iload_3
    //   1249: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1252: iload #10
    //   1254: invokestatic computeTagSize : (I)I
    //   1257: istore #9
    //   1259: iload_3
    //   1260: invokestatic computeUInt32SizeNoTag : (I)I
    //   1263: istore #4
    //   1265: iload_3
    //   1266: istore_2
    //   1267: iload #9
    //   1269: istore_3
    //   1270: goto -> 1931
    //   1273: aload #15
    //   1275: aload_1
    //   1276: lload #13
    //   1278: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1281: checkcast java/util/List
    //   1284: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1287: istore_3
    //   1288: iload #5
    //   1290: istore_2
    //   1291: iload_3
    //   1292: ifle -> 2303
    //   1295: aload_0
    //   1296: getfield useCachedSizeField : Z
    //   1299: ifeq -> 1312
    //   1302: aload #15
    //   1304: aload_1
    //   1305: iload #4
    //   1307: i2l
    //   1308: iload_3
    //   1309: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1312: iload #10
    //   1314: invokestatic computeTagSize : (I)I
    //   1317: istore #9
    //   1319: iload_3
    //   1320: invokestatic computeUInt32SizeNoTag : (I)I
    //   1323: istore #4
    //   1325: iload_3
    //   1326: istore_2
    //   1327: iload #9
    //   1329: istore_3
    //   1330: goto -> 1931
    //   1333: aload #15
    //   1335: aload_1
    //   1336: lload #13
    //   1338: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1341: checkcast java/util/List
    //   1344: invokestatic computeSizeEnumListNoTag : (Ljava/util/List;)I
    //   1347: istore_3
    //   1348: iload #5
    //   1350: istore_2
    //   1351: iload_3
    //   1352: ifle -> 2303
    //   1355: aload_0
    //   1356: getfield useCachedSizeField : Z
    //   1359: ifeq -> 1372
    //   1362: aload #15
    //   1364: aload_1
    //   1365: iload #4
    //   1367: i2l
    //   1368: iload_3
    //   1369: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1372: iload #10
    //   1374: invokestatic computeTagSize : (I)I
    //   1377: istore #9
    //   1379: iload_3
    //   1380: invokestatic computeUInt32SizeNoTag : (I)I
    //   1383: istore #4
    //   1385: iload_3
    //   1386: istore_2
    //   1387: iload #9
    //   1389: istore_3
    //   1390: goto -> 1931
    //   1393: aload #15
    //   1395: aload_1
    //   1396: lload #13
    //   1398: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1401: checkcast java/util/List
    //   1404: invokestatic computeSizeUInt32ListNoTag : (Ljava/util/List;)I
    //   1407: istore_3
    //   1408: iload #5
    //   1410: istore_2
    //   1411: iload_3
    //   1412: ifle -> 2303
    //   1415: aload_0
    //   1416: getfield useCachedSizeField : Z
    //   1419: ifeq -> 1432
    //   1422: aload #15
    //   1424: aload_1
    //   1425: iload #4
    //   1427: i2l
    //   1428: iload_3
    //   1429: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1432: iload #10
    //   1434: invokestatic computeTagSize : (I)I
    //   1437: istore #9
    //   1439: iload_3
    //   1440: invokestatic computeUInt32SizeNoTag : (I)I
    //   1443: istore #4
    //   1445: iload_3
    //   1446: istore_2
    //   1447: iload #9
    //   1449: istore_3
    //   1450: goto -> 1931
    //   1453: aload #15
    //   1455: aload_1
    //   1456: lload #13
    //   1458: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1461: checkcast java/util/List
    //   1464: invokestatic computeSizeBoolListNoTag : (Ljava/util/List;)I
    //   1467: istore_3
    //   1468: iload #5
    //   1470: istore_2
    //   1471: iload_3
    //   1472: ifle -> 2303
    //   1475: aload_0
    //   1476: getfield useCachedSizeField : Z
    //   1479: ifeq -> 1492
    //   1482: aload #15
    //   1484: aload_1
    //   1485: iload #4
    //   1487: i2l
    //   1488: iload_3
    //   1489: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1492: iload #10
    //   1494: invokestatic computeTagSize : (I)I
    //   1497: istore #9
    //   1499: iload_3
    //   1500: invokestatic computeUInt32SizeNoTag : (I)I
    //   1503: istore #4
    //   1505: iload_3
    //   1506: istore_2
    //   1507: iload #9
    //   1509: istore_3
    //   1510: goto -> 1931
    //   1513: aload #15
    //   1515: aload_1
    //   1516: lload #13
    //   1518: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1521: checkcast java/util/List
    //   1524: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1527: istore_3
    //   1528: iload #5
    //   1530: istore_2
    //   1531: iload_3
    //   1532: ifle -> 2303
    //   1535: aload_0
    //   1536: getfield useCachedSizeField : Z
    //   1539: ifeq -> 1552
    //   1542: aload #15
    //   1544: aload_1
    //   1545: iload #4
    //   1547: i2l
    //   1548: iload_3
    //   1549: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1552: iload #10
    //   1554: invokestatic computeTagSize : (I)I
    //   1557: istore #9
    //   1559: iload_3
    //   1560: invokestatic computeUInt32SizeNoTag : (I)I
    //   1563: istore #4
    //   1565: iload_3
    //   1566: istore_2
    //   1567: iload #9
    //   1569: istore_3
    //   1570: goto -> 1931
    //   1573: aload #15
    //   1575: aload_1
    //   1576: lload #13
    //   1578: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1581: checkcast java/util/List
    //   1584: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1587: istore_3
    //   1588: iload #5
    //   1590: istore_2
    //   1591: iload_3
    //   1592: ifle -> 2303
    //   1595: aload_0
    //   1596: getfield useCachedSizeField : Z
    //   1599: ifeq -> 1612
    //   1602: aload #15
    //   1604: aload_1
    //   1605: iload #4
    //   1607: i2l
    //   1608: iload_3
    //   1609: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1612: iload #10
    //   1614: invokestatic computeTagSize : (I)I
    //   1617: istore #9
    //   1619: iload_3
    //   1620: invokestatic computeUInt32SizeNoTag : (I)I
    //   1623: istore #4
    //   1625: iload_3
    //   1626: istore_2
    //   1627: iload #9
    //   1629: istore_3
    //   1630: goto -> 1931
    //   1633: aload #15
    //   1635: aload_1
    //   1636: lload #13
    //   1638: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1641: checkcast java/util/List
    //   1644: invokestatic computeSizeInt32ListNoTag : (Ljava/util/List;)I
    //   1647: istore_3
    //   1648: iload #5
    //   1650: istore_2
    //   1651: iload_3
    //   1652: ifle -> 2303
    //   1655: aload_0
    //   1656: getfield useCachedSizeField : Z
    //   1659: ifeq -> 1672
    //   1662: aload #15
    //   1664: aload_1
    //   1665: iload #4
    //   1667: i2l
    //   1668: iload_3
    //   1669: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1672: iload #10
    //   1674: invokestatic computeTagSize : (I)I
    //   1677: istore #9
    //   1679: iload_3
    //   1680: invokestatic computeUInt32SizeNoTag : (I)I
    //   1683: istore #4
    //   1685: iload_3
    //   1686: istore_2
    //   1687: iload #9
    //   1689: istore_3
    //   1690: goto -> 1931
    //   1693: aload #15
    //   1695: aload_1
    //   1696: lload #13
    //   1698: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1701: checkcast java/util/List
    //   1704: invokestatic computeSizeUInt64ListNoTag : (Ljava/util/List;)I
    //   1707: istore_3
    //   1708: iload #5
    //   1710: istore_2
    //   1711: iload_3
    //   1712: ifle -> 2303
    //   1715: aload_0
    //   1716: getfield useCachedSizeField : Z
    //   1719: ifeq -> 1732
    //   1722: aload #15
    //   1724: aload_1
    //   1725: iload #4
    //   1727: i2l
    //   1728: iload_3
    //   1729: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1732: iload #10
    //   1734: invokestatic computeTagSize : (I)I
    //   1737: istore #9
    //   1739: iload_3
    //   1740: invokestatic computeUInt32SizeNoTag : (I)I
    //   1743: istore #4
    //   1745: iload_3
    //   1746: istore_2
    //   1747: iload #9
    //   1749: istore_3
    //   1750: goto -> 1931
    //   1753: aload #15
    //   1755: aload_1
    //   1756: lload #13
    //   1758: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1761: checkcast java/util/List
    //   1764: invokestatic computeSizeInt64ListNoTag : (Ljava/util/List;)I
    //   1767: istore_3
    //   1768: iload #5
    //   1770: istore_2
    //   1771: iload_3
    //   1772: ifle -> 2303
    //   1775: aload_0
    //   1776: getfield useCachedSizeField : Z
    //   1779: ifeq -> 1792
    //   1782: aload #15
    //   1784: aload_1
    //   1785: iload #4
    //   1787: i2l
    //   1788: iload_3
    //   1789: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1792: iload #10
    //   1794: invokestatic computeTagSize : (I)I
    //   1797: istore #9
    //   1799: iload_3
    //   1800: invokestatic computeUInt32SizeNoTag : (I)I
    //   1803: istore #4
    //   1805: iload_3
    //   1806: istore_2
    //   1807: iload #9
    //   1809: istore_3
    //   1810: goto -> 1931
    //   1813: aload #15
    //   1815: aload_1
    //   1816: lload #13
    //   1818: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1821: checkcast java/util/List
    //   1824: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1827: istore_3
    //   1828: iload #5
    //   1830: istore_2
    //   1831: iload_3
    //   1832: ifle -> 2303
    //   1835: aload_0
    //   1836: getfield useCachedSizeField : Z
    //   1839: ifeq -> 1852
    //   1842: aload #15
    //   1844: aload_1
    //   1845: iload #4
    //   1847: i2l
    //   1848: iload_3
    //   1849: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1852: iload #10
    //   1854: invokestatic computeTagSize : (I)I
    //   1857: istore #9
    //   1859: iload_3
    //   1860: invokestatic computeUInt32SizeNoTag : (I)I
    //   1863: istore #4
    //   1865: iload_3
    //   1866: istore_2
    //   1867: iload #9
    //   1869: istore_3
    //   1870: goto -> 1931
    //   1873: aload #15
    //   1875: aload_1
    //   1876: lload #13
    //   1878: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1881: checkcast java/util/List
    //   1884: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1887: istore #9
    //   1889: iload #5
    //   1891: istore_2
    //   1892: iload #9
    //   1894: ifle -> 2303
    //   1897: aload_0
    //   1898: getfield useCachedSizeField : Z
    //   1901: ifeq -> 1915
    //   1904: aload #15
    //   1906: aload_1
    //   1907: iload #4
    //   1909: i2l
    //   1910: iload #9
    //   1912: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1915: iload #10
    //   1917: invokestatic computeTagSize : (I)I
    //   1920: istore_3
    //   1921: iload #9
    //   1923: invokestatic computeUInt32SizeNoTag : (I)I
    //   1926: istore #4
    //   1928: iload #9
    //   1930: istore_2
    //   1931: iload_3
    //   1932: iload #4
    //   1934: iadd
    //   1935: iload_2
    //   1936: iadd
    //   1937: istore_2
    //   1938: goto -> 2438
    //   1941: iload #10
    //   1943: aload #15
    //   1945: aload_1
    //   1946: lload #13
    //   1948: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1951: checkcast java/util/List
    //   1954: iconst_0
    //   1955: invokestatic computeSizeSInt64List : (ILjava/util/List;Z)I
    //   1958: istore_2
    //   1959: goto -> 2298
    //   1962: iload #10
    //   1964: aload #15
    //   1966: aload_1
    //   1967: lload #13
    //   1969: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1972: checkcast java/util/List
    //   1975: iconst_0
    //   1976: invokestatic computeSizeSInt32List : (ILjava/util/List;Z)I
    //   1979: istore_2
    //   1980: goto -> 2298
    //   1983: iload #10
    //   1985: aload #15
    //   1987: aload_1
    //   1988: lload #13
    //   1990: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1993: checkcast java/util/List
    //   1996: iconst_0
    //   1997: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   2000: istore_2
    //   2001: goto -> 2298
    //   2004: iload #10
    //   2006: aload #15
    //   2008: aload_1
    //   2009: lload #13
    //   2011: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2014: checkcast java/util/List
    //   2017: iconst_0
    //   2018: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   2021: istore_2
    //   2022: goto -> 2298
    //   2025: iload #10
    //   2027: aload #15
    //   2029: aload_1
    //   2030: lload #13
    //   2032: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2035: checkcast java/util/List
    //   2038: iconst_0
    //   2039: invokestatic computeSizeEnumList : (ILjava/util/List;Z)I
    //   2042: istore_2
    //   2043: goto -> 2298
    //   2046: iload #10
    //   2048: aload #15
    //   2050: aload_1
    //   2051: lload #13
    //   2053: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2056: checkcast java/util/List
    //   2059: iconst_0
    //   2060: invokestatic computeSizeUInt32List : (ILjava/util/List;Z)I
    //   2063: istore_2
    //   2064: goto -> 2298
    //   2067: iload #10
    //   2069: aload #15
    //   2071: aload_1
    //   2072: lload #13
    //   2074: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2077: checkcast java/util/List
    //   2080: invokestatic computeSizeByteStringList : (ILjava/util/List;)I
    //   2083: istore_2
    //   2084: goto -> 2298
    //   2087: iload #10
    //   2089: aload #15
    //   2091: aload_1
    //   2092: lload #13
    //   2094: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2097: checkcast java/util/List
    //   2100: aload_0
    //   2101: iload #6
    //   2103: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2106: invokestatic computeSizeMessageList : (ILjava/util/List;Lcom/google/protobuf/Schema;)I
    //   2109: istore_2
    //   2110: goto -> 2298
    //   2113: iload #10
    //   2115: aload #15
    //   2117: aload_1
    //   2118: lload #13
    //   2120: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2123: checkcast java/util/List
    //   2126: invokestatic computeSizeStringList : (ILjava/util/List;)I
    //   2129: istore_2
    //   2130: goto -> 2298
    //   2133: iload #10
    //   2135: aload #15
    //   2137: aload_1
    //   2138: lload #13
    //   2140: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2143: checkcast java/util/List
    //   2146: iconst_0
    //   2147: invokestatic computeSizeBoolList : (ILjava/util/List;Z)I
    //   2150: istore_2
    //   2151: goto -> 2298
    //   2154: iload #10
    //   2156: aload #15
    //   2158: aload_1
    //   2159: lload #13
    //   2161: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2164: checkcast java/util/List
    //   2167: iconst_0
    //   2168: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   2171: istore_2
    //   2172: goto -> 2298
    //   2175: iload #10
    //   2177: aload #15
    //   2179: aload_1
    //   2180: lload #13
    //   2182: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2185: checkcast java/util/List
    //   2188: iconst_0
    //   2189: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   2192: istore_2
    //   2193: goto -> 2298
    //   2196: iload #10
    //   2198: aload #15
    //   2200: aload_1
    //   2201: lload #13
    //   2203: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2206: checkcast java/util/List
    //   2209: iconst_0
    //   2210: invokestatic computeSizeInt32List : (ILjava/util/List;Z)I
    //   2213: istore_2
    //   2214: goto -> 2298
    //   2217: iload #10
    //   2219: aload #15
    //   2221: aload_1
    //   2222: lload #13
    //   2224: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2227: checkcast java/util/List
    //   2230: iconst_0
    //   2231: invokestatic computeSizeUInt64List : (ILjava/util/List;Z)I
    //   2234: istore_2
    //   2235: goto -> 2298
    //   2238: iload #10
    //   2240: aload #15
    //   2242: aload_1
    //   2243: lload #13
    //   2245: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2248: checkcast java/util/List
    //   2251: iconst_0
    //   2252: invokestatic computeSizeInt64List : (ILjava/util/List;Z)I
    //   2255: istore_2
    //   2256: goto -> 2298
    //   2259: iload #10
    //   2261: aload #15
    //   2263: aload_1
    //   2264: lload #13
    //   2266: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2269: checkcast java/util/List
    //   2272: iconst_0
    //   2273: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   2276: istore_2
    //   2277: goto -> 2298
    //   2280: iload #10
    //   2282: aload #15
    //   2284: aload_1
    //   2285: lload #13
    //   2287: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2290: checkcast java/util/List
    //   2293: iconst_0
    //   2294: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   2297: istore_2
    //   2298: iload #5
    //   2300: iload_2
    //   2301: iadd
    //   2302: istore_2
    //   2303: goto -> 2815
    //   2306: iload #5
    //   2308: istore_2
    //   2309: iload #8
    //   2311: iload #9
    //   2313: iand
    //   2314: ifeq -> 2303
    //   2317: iload #10
    //   2319: aload #15
    //   2321: aload_1
    //   2322: lload #13
    //   2324: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2327: checkcast com/google/protobuf/MessageLite
    //   2330: aload_0
    //   2331: iload #6
    //   2333: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2336: invokestatic computeGroupSize : (ILcom/google/protobuf/MessageLite;Lcom/google/protobuf/Schema;)I
    //   2339: istore_2
    //   2340: goto -> 2298
    //   2343: iload #5
    //   2345: istore_2
    //   2346: iload #8
    //   2348: iload #9
    //   2350: iand
    //   2351: ifeq -> 2303
    //   2354: iload #10
    //   2356: aload #15
    //   2358: aload_1
    //   2359: lload #13
    //   2361: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2364: invokestatic computeSInt64Size : (IJ)I
    //   2367: istore_2
    //   2368: goto -> 2298
    //   2371: iload #5
    //   2373: istore_2
    //   2374: iload #8
    //   2376: iload #9
    //   2378: iand
    //   2379: ifeq -> 2303
    //   2382: iload #10
    //   2384: aload #15
    //   2386: aload_1
    //   2387: lload #13
    //   2389: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2392: invokestatic computeSInt32Size : (II)I
    //   2395: istore_2
    //   2396: goto -> 2298
    //   2399: iload #5
    //   2401: istore_2
    //   2402: iload #8
    //   2404: iload #9
    //   2406: iand
    //   2407: ifeq -> 2303
    //   2410: iload #10
    //   2412: lconst_0
    //   2413: invokestatic computeSFixed64Size : (IJ)I
    //   2416: istore_2
    //   2417: goto -> 2298
    //   2420: iload #5
    //   2422: istore_2
    //   2423: iload #8
    //   2425: iload #9
    //   2427: iand
    //   2428: ifeq -> 2303
    //   2431: iload #10
    //   2433: iconst_0
    //   2434: invokestatic computeSFixed32Size : (II)I
    //   2437: istore_2
    //   2438: iload #5
    //   2440: iload_2
    //   2441: iadd
    //   2442: istore_2
    //   2443: goto -> 2303
    //   2446: iload #5
    //   2448: istore_2
    //   2449: iload #8
    //   2451: iload #9
    //   2453: iand
    //   2454: ifeq -> 2303
    //   2457: iload #10
    //   2459: aload #15
    //   2461: aload_1
    //   2462: lload #13
    //   2464: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2467: invokestatic computeEnumSize : (II)I
    //   2470: istore_2
    //   2471: goto -> 2298
    //   2474: iload #5
    //   2476: istore_2
    //   2477: iload #8
    //   2479: iload #9
    //   2481: iand
    //   2482: ifeq -> 2303
    //   2485: iload #10
    //   2487: aload #15
    //   2489: aload_1
    //   2490: lload #13
    //   2492: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2495: invokestatic computeUInt32Size : (II)I
    //   2498: istore_2
    //   2499: goto -> 2298
    //   2502: iload #5
    //   2504: istore_2
    //   2505: iload #8
    //   2507: iload #9
    //   2509: iand
    //   2510: ifeq -> 2303
    //   2513: iload #10
    //   2515: aload #15
    //   2517: aload_1
    //   2518: lload #13
    //   2520: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2523: checkcast com/google/protobuf/ByteString
    //   2526: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   2529: istore_2
    //   2530: goto -> 2298
    //   2533: iload #5
    //   2535: istore_2
    //   2536: iload #8
    //   2538: iload #9
    //   2540: iand
    //   2541: ifeq -> 2303
    //   2544: iload #10
    //   2546: aload #15
    //   2548: aload_1
    //   2549: lload #13
    //   2551: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2554: aload_0
    //   2555: iload #6
    //   2557: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2560: invokestatic computeSizeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)I
    //   2563: istore_2
    //   2564: goto -> 2298
    //   2567: iload #5
    //   2569: istore_2
    //   2570: iload #8
    //   2572: iload #9
    //   2574: iand
    //   2575: ifeq -> 2303
    //   2578: aload #15
    //   2580: aload_1
    //   2581: lload #13
    //   2583: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2586: astore #16
    //   2588: aload #16
    //   2590: instanceof com/google/protobuf/ByteString
    //   2593: ifeq -> 2610
    //   2596: iload #10
    //   2598: aload #16
    //   2600: checkcast com/google/protobuf/ByteString
    //   2603: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   2606: istore_2
    //   2607: goto -> 2298
    //   2610: iload #10
    //   2612: aload #16
    //   2614: checkcast java/lang/String
    //   2617: invokestatic computeStringSize : (ILjava/lang/String;)I
    //   2620: istore_2
    //   2621: goto -> 2298
    //   2624: iload #5
    //   2626: istore_2
    //   2627: iload #8
    //   2629: iload #9
    //   2631: iand
    //   2632: ifeq -> 2303
    //   2635: iload #10
    //   2637: iconst_1
    //   2638: invokestatic computeBoolSize : (IZ)I
    //   2641: istore_2
    //   2642: goto -> 2298
    //   2645: iload #5
    //   2647: istore_2
    //   2648: iload #8
    //   2650: iload #9
    //   2652: iand
    //   2653: ifeq -> 2303
    //   2656: iload #10
    //   2658: iconst_0
    //   2659: invokestatic computeFixed32Size : (II)I
    //   2662: istore_2
    //   2663: goto -> 2810
    //   2666: iload #5
    //   2668: istore_2
    //   2669: iload #8
    //   2671: iload #9
    //   2673: iand
    //   2674: ifeq -> 2815
    //   2677: iload #10
    //   2679: lconst_0
    //   2680: invokestatic computeFixed64Size : (IJ)I
    //   2683: istore_2
    //   2684: goto -> 2810
    //   2687: iload #5
    //   2689: istore_2
    //   2690: iload #8
    //   2692: iload #9
    //   2694: iand
    //   2695: ifeq -> 2815
    //   2698: iload #10
    //   2700: aload #15
    //   2702: aload_1
    //   2703: lload #13
    //   2705: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2708: invokestatic computeInt32Size : (II)I
    //   2711: istore_2
    //   2712: goto -> 2810
    //   2715: iload #5
    //   2717: istore_2
    //   2718: iload #8
    //   2720: iload #9
    //   2722: iand
    //   2723: ifeq -> 2815
    //   2726: iload #10
    //   2728: aload #15
    //   2730: aload_1
    //   2731: lload #13
    //   2733: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2736: invokestatic computeUInt64Size : (IJ)I
    //   2739: istore_2
    //   2740: goto -> 2810
    //   2743: iload #5
    //   2745: istore_2
    //   2746: iload #8
    //   2748: iload #9
    //   2750: iand
    //   2751: ifeq -> 2815
    //   2754: iload #10
    //   2756: aload #15
    //   2758: aload_1
    //   2759: lload #13
    //   2761: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2764: invokestatic computeInt64Size : (IJ)I
    //   2767: istore_2
    //   2768: goto -> 2810
    //   2771: iload #5
    //   2773: istore_2
    //   2774: iload #8
    //   2776: iload #9
    //   2778: iand
    //   2779: ifeq -> 2815
    //   2782: iload #10
    //   2784: fconst_0
    //   2785: invokestatic computeFloatSize : (IF)I
    //   2788: istore_2
    //   2789: goto -> 2810
    //   2792: iload #5
    //   2794: istore_2
    //   2795: iload #8
    //   2797: iload #9
    //   2799: iand
    //   2800: ifeq -> 2815
    //   2803: iload #10
    //   2805: dconst_0
    //   2806: invokestatic computeDoubleSize : (ID)I
    //   2809: istore_2
    //   2810: iload #5
    //   2812: iload_2
    //   2813: iadd
    //   2814: istore_2
    //   2815: iload #6
    //   2817: iconst_3
    //   2818: iadd
    //   2819: istore #6
    //   2821: iload_2
    //   2822: istore #5
    //   2824: iload #7
    //   2826: istore_3
    //   2827: iload #8
    //   2829: istore_2
    //   2830: goto -> 16
    //   2833: iload #5
    //   2835: aload_0
    //   2836: aload_0
    //   2837: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   2840: aload_1
    //   2841: invokespecial getUnknownFieldsSerializedSize : (Lcom/google/protobuf/UnknownFieldSchema;Ljava/lang/Object;)I
    //   2844: iadd
    //   2845: istore_3
    //   2846: iload_3
    //   2847: istore_2
    //   2848: aload_0
    //   2849: getfield hasExtensions : Z
    //   2852: ifeq -> 2869
    //   2855: iload_3
    //   2856: aload_0
    //   2857: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   2860: aload_1
    //   2861: invokevirtual getExtensions : (Ljava/lang/Object;)Lcom/google/protobuf/FieldSet;
    //   2864: invokevirtual getSerializedSize : ()I
    //   2867: iadd
    //   2868: istore_2
    //   2869: iload_2
    //   2870: ireturn
  }
  
  private int getSerializedSizeProto3(T paramT) {
    // Byte code:
    //   0: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   3: astore #11
    //   5: iconst_0
    //   6: istore #5
    //   8: iconst_0
    //   9: istore #6
    //   11: iload #5
    //   13: aload_0
    //   14: getfield buffer : [I
    //   17: arraylength
    //   18: if_icmpge -> 2689
    //   21: aload_0
    //   22: iload #5
    //   24: invokespecial typeAndOffsetAt : (I)I
    //   27: istore_2
    //   28: iload_2
    //   29: invokestatic type : (I)I
    //   32: istore_3
    //   33: aload_0
    //   34: iload #5
    //   36: invokespecial numberAt : (I)I
    //   39: istore #8
    //   41: iload_2
    //   42: invokestatic offset : (I)J
    //   45: lstore #9
    //   47: iload_3
    //   48: getstatic com/google/protobuf/FieldType.DOUBLE_LIST_PACKED : Lcom/google/protobuf/FieldType;
    //   51: invokevirtual id : ()I
    //   54: if_icmplt -> 83
    //   57: iload_3
    //   58: getstatic com/google/protobuf/FieldType.SINT64_LIST_PACKED : Lcom/google/protobuf/FieldType;
    //   61: invokevirtual id : ()I
    //   64: if_icmpgt -> 83
    //   67: aload_0
    //   68: getfield buffer : [I
    //   71: iload #5
    //   73: iconst_2
    //   74: iadd
    //   75: iaload
    //   76: ldc 1048575
    //   78: iand
    //   79: istore_2
    //   80: goto -> 85
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_3
    //   86: tableswitch default -> 376, 0 -> 2654, 1 -> 2631, 2 -> 2603, 3 -> 2575, 4 -> 2547, 5 -> 2524, 6 -> 2501, 7 -> 2478, 8 -> 2421, 9 -> 2387, 10 -> 2356, 11 -> 2328, 12 -> 2300, 13 -> 2277, 14 -> 2254, 15 -> 2226, 16 -> 2198, 17 -> 2161, 18 -> 2140, 19 -> 2124, 20 -> 2108, 21 -> 2092, 22 -> 2076, 23 -> 2060, 24 -> 2044, 25 -> 2028, 26 -> 2013, 27 -> 1992, 28 -> 1977, 29 -> 1961, 30 -> 1945, 31 -> 1929, 32 -> 1913, 33 -> 1897, 34 -> 1881, 35 -> 1814, 36 -> 1750, 37 -> 1686, 38 -> 1622, 39 -> 1558, 40 -> 1494, 41 -> 1430, 42 -> 1366, 43 -> 1302, 44 -> 1238, 45 -> 1174, 46 -> 1110, 47 -> 1046, 48 -> 982, 49 -> 961, 50 -> 934, 51 -> 909, 52 -> 884, 53 -> 854, 54 -> 824, 55 -> 794, 56 -> 769, 57 -> 744, 58 -> 719, 59 -> 660, 60 -> 624, 61 -> 591, 62 -> 561, 63 -> 531, 64 -> 506, 65 -> 481, 66 -> 451, 67 -> 421, 68 -> 382
    //   376: iload #6
    //   378: istore_3
    //   379: goto -> 2677
    //   382: iload #6
    //   384: istore_3
    //   385: aload_0
    //   386: aload_1
    //   387: iload #8
    //   389: iload #5
    //   391: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   394: ifeq -> 2677
    //   397: iload #8
    //   399: aload_1
    //   400: lload #9
    //   402: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   405: checkcast com/google/protobuf/MessageLite
    //   408: aload_0
    //   409: iload #5
    //   411: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   414: invokestatic computeGroupSize : (ILcom/google/protobuf/MessageLite;Lcom/google/protobuf/Schema;)I
    //   417: istore_2
    //   418: goto -> 2153
    //   421: iload #6
    //   423: istore_3
    //   424: aload_0
    //   425: aload_1
    //   426: iload #8
    //   428: iload #5
    //   430: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   433: ifeq -> 2677
    //   436: iload #8
    //   438: aload_1
    //   439: lload #9
    //   441: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   444: invokestatic computeSInt64Size : (IJ)I
    //   447: istore_2
    //   448: goto -> 2153
    //   451: iload #6
    //   453: istore_3
    //   454: aload_0
    //   455: aload_1
    //   456: iload #8
    //   458: iload #5
    //   460: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   463: ifeq -> 2677
    //   466: iload #8
    //   468: aload_1
    //   469: lload #9
    //   471: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   474: invokestatic computeSInt32Size : (II)I
    //   477: istore_2
    //   478: goto -> 2153
    //   481: iload #6
    //   483: istore_3
    //   484: aload_0
    //   485: aload_1
    //   486: iload #8
    //   488: iload #5
    //   490: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   493: ifeq -> 2677
    //   496: iload #8
    //   498: lconst_0
    //   499: invokestatic computeSFixed64Size : (IJ)I
    //   502: istore_2
    //   503: goto -> 2153
    //   506: iload #6
    //   508: istore_3
    //   509: aload_0
    //   510: aload_1
    //   511: iload #8
    //   513: iload #5
    //   515: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   518: ifeq -> 2677
    //   521: iload #8
    //   523: iconst_0
    //   524: invokestatic computeSFixed32Size : (II)I
    //   527: istore_2
    //   528: goto -> 2153
    //   531: iload #6
    //   533: istore_3
    //   534: aload_0
    //   535: aload_1
    //   536: iload #8
    //   538: iload #5
    //   540: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   543: ifeq -> 2677
    //   546: iload #8
    //   548: aload_1
    //   549: lload #9
    //   551: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   554: invokestatic computeEnumSize : (II)I
    //   557: istore_2
    //   558: goto -> 2153
    //   561: iload #6
    //   563: istore_3
    //   564: aload_0
    //   565: aload_1
    //   566: iload #8
    //   568: iload #5
    //   570: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   573: ifeq -> 2677
    //   576: iload #8
    //   578: aload_1
    //   579: lload #9
    //   581: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   584: invokestatic computeUInt32Size : (II)I
    //   587: istore_2
    //   588: goto -> 2153
    //   591: iload #6
    //   593: istore_3
    //   594: aload_0
    //   595: aload_1
    //   596: iload #8
    //   598: iload #5
    //   600: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   603: ifeq -> 2677
    //   606: iload #8
    //   608: aload_1
    //   609: lload #9
    //   611: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   614: checkcast com/google/protobuf/ByteString
    //   617: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   620: istore_2
    //   621: goto -> 2153
    //   624: iload #6
    //   626: istore_3
    //   627: aload_0
    //   628: aload_1
    //   629: iload #8
    //   631: iload #5
    //   633: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   636: ifeq -> 2677
    //   639: iload #8
    //   641: aload_1
    //   642: lload #9
    //   644: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   647: aload_0
    //   648: iload #5
    //   650: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   653: invokestatic computeSizeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)I
    //   656: istore_2
    //   657: goto -> 2153
    //   660: iload #6
    //   662: istore_3
    //   663: aload_0
    //   664: aload_1
    //   665: iload #8
    //   667: iload #5
    //   669: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   672: ifeq -> 2677
    //   675: aload_1
    //   676: lload #9
    //   678: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   681: astore #12
    //   683: aload #12
    //   685: instanceof com/google/protobuf/ByteString
    //   688: ifeq -> 705
    //   691: iload #8
    //   693: aload #12
    //   695: checkcast com/google/protobuf/ByteString
    //   698: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   701: istore_2
    //   702: goto -> 2153
    //   705: iload #8
    //   707: aload #12
    //   709: checkcast java/lang/String
    //   712: invokestatic computeStringSize : (ILjava/lang/String;)I
    //   715: istore_2
    //   716: goto -> 2153
    //   719: iload #6
    //   721: istore_3
    //   722: aload_0
    //   723: aload_1
    //   724: iload #8
    //   726: iload #5
    //   728: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   731: ifeq -> 2677
    //   734: iload #8
    //   736: iconst_1
    //   737: invokestatic computeBoolSize : (IZ)I
    //   740: istore_2
    //   741: goto -> 2153
    //   744: iload #6
    //   746: istore_3
    //   747: aload_0
    //   748: aload_1
    //   749: iload #8
    //   751: iload #5
    //   753: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   756: ifeq -> 2677
    //   759: iload #8
    //   761: iconst_0
    //   762: invokestatic computeFixed32Size : (II)I
    //   765: istore_2
    //   766: goto -> 2153
    //   769: iload #6
    //   771: istore_3
    //   772: aload_0
    //   773: aload_1
    //   774: iload #8
    //   776: iload #5
    //   778: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   781: ifeq -> 2677
    //   784: iload #8
    //   786: lconst_0
    //   787: invokestatic computeFixed64Size : (IJ)I
    //   790: istore_2
    //   791: goto -> 2153
    //   794: iload #6
    //   796: istore_3
    //   797: aload_0
    //   798: aload_1
    //   799: iload #8
    //   801: iload #5
    //   803: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   806: ifeq -> 2677
    //   809: iload #8
    //   811: aload_1
    //   812: lload #9
    //   814: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   817: invokestatic computeInt32Size : (II)I
    //   820: istore_2
    //   821: goto -> 2153
    //   824: iload #6
    //   826: istore_3
    //   827: aload_0
    //   828: aload_1
    //   829: iload #8
    //   831: iload #5
    //   833: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   836: ifeq -> 2677
    //   839: iload #8
    //   841: aload_1
    //   842: lload #9
    //   844: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   847: invokestatic computeUInt64Size : (IJ)I
    //   850: istore_2
    //   851: goto -> 2153
    //   854: iload #6
    //   856: istore_3
    //   857: aload_0
    //   858: aload_1
    //   859: iload #8
    //   861: iload #5
    //   863: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   866: ifeq -> 2677
    //   869: iload #8
    //   871: aload_1
    //   872: lload #9
    //   874: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   877: invokestatic computeInt64Size : (IJ)I
    //   880: istore_2
    //   881: goto -> 2153
    //   884: iload #6
    //   886: istore_3
    //   887: aload_0
    //   888: aload_1
    //   889: iload #8
    //   891: iload #5
    //   893: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   896: ifeq -> 2677
    //   899: iload #8
    //   901: fconst_0
    //   902: invokestatic computeFloatSize : (IF)I
    //   905: istore_2
    //   906: goto -> 2153
    //   909: iload #6
    //   911: istore_3
    //   912: aload_0
    //   913: aload_1
    //   914: iload #8
    //   916: iload #5
    //   918: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   921: ifeq -> 2677
    //   924: iload #8
    //   926: dconst_0
    //   927: invokestatic computeDoubleSize : (ID)I
    //   930: istore_2
    //   931: goto -> 2153
    //   934: aload_0
    //   935: getfield mapFieldSchema : Lcom/google/protobuf/MapFieldSchema;
    //   938: iload #8
    //   940: aload_1
    //   941: lload #9
    //   943: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   946: aload_0
    //   947: iload #5
    //   949: invokespecial getMapFieldDefaultEntry : (I)Ljava/lang/Object;
    //   952: invokeinterface getSerializedSize : (ILjava/lang/Object;Ljava/lang/Object;)I
    //   957: istore_2
    //   958: goto -> 2153
    //   961: iload #8
    //   963: aload_1
    //   964: lload #9
    //   966: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   969: aload_0
    //   970: iload #5
    //   972: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   975: invokestatic computeSizeGroupList : (ILjava/util/List;Lcom/google/protobuf/Schema;)I
    //   978: istore_2
    //   979: goto -> 2153
    //   982: aload #11
    //   984: aload_1
    //   985: lload #9
    //   987: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   990: checkcast java/util/List
    //   993: invokestatic computeSizeSInt64ListNoTag : (Ljava/util/List;)I
    //   996: istore #4
    //   998: iload #6
    //   1000: istore_3
    //   1001: iload #4
    //   1003: ifle -> 2677
    //   1006: aload_0
    //   1007: getfield useCachedSizeField : Z
    //   1010: ifeq -> 1023
    //   1013: aload #11
    //   1015: aload_1
    //   1016: iload_2
    //   1017: i2l
    //   1018: iload #4
    //   1020: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1023: iload #8
    //   1025: invokestatic computeTagSize : (I)I
    //   1028: istore_2
    //   1029: iload #4
    //   1031: invokestatic computeUInt32SizeNoTag : (I)I
    //   1034: istore #7
    //   1036: iload #4
    //   1038: istore_3
    //   1039: iload #7
    //   1041: istore #4
    //   1043: goto -> 1871
    //   1046: aload #11
    //   1048: aload_1
    //   1049: lload #9
    //   1051: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1054: checkcast java/util/List
    //   1057: invokestatic computeSizeSInt32ListNoTag : (Ljava/util/List;)I
    //   1060: istore #4
    //   1062: iload #6
    //   1064: istore_3
    //   1065: iload #4
    //   1067: ifle -> 2677
    //   1070: aload_0
    //   1071: getfield useCachedSizeField : Z
    //   1074: ifeq -> 1087
    //   1077: aload #11
    //   1079: aload_1
    //   1080: iload_2
    //   1081: i2l
    //   1082: iload #4
    //   1084: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1087: iload #8
    //   1089: invokestatic computeTagSize : (I)I
    //   1092: istore_2
    //   1093: iload #4
    //   1095: invokestatic computeUInt32SizeNoTag : (I)I
    //   1098: istore #7
    //   1100: iload #4
    //   1102: istore_3
    //   1103: iload #7
    //   1105: istore #4
    //   1107: goto -> 1871
    //   1110: aload #11
    //   1112: aload_1
    //   1113: lload #9
    //   1115: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1118: checkcast java/util/List
    //   1121: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1124: istore #4
    //   1126: iload #6
    //   1128: istore_3
    //   1129: iload #4
    //   1131: ifle -> 2677
    //   1134: aload_0
    //   1135: getfield useCachedSizeField : Z
    //   1138: ifeq -> 1151
    //   1141: aload #11
    //   1143: aload_1
    //   1144: iload_2
    //   1145: i2l
    //   1146: iload #4
    //   1148: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1151: iload #8
    //   1153: invokestatic computeTagSize : (I)I
    //   1156: istore_2
    //   1157: iload #4
    //   1159: invokestatic computeUInt32SizeNoTag : (I)I
    //   1162: istore #7
    //   1164: iload #4
    //   1166: istore_3
    //   1167: iload #7
    //   1169: istore #4
    //   1171: goto -> 1871
    //   1174: aload #11
    //   1176: aload_1
    //   1177: lload #9
    //   1179: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1182: checkcast java/util/List
    //   1185: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1188: istore #4
    //   1190: iload #6
    //   1192: istore_3
    //   1193: iload #4
    //   1195: ifle -> 2677
    //   1198: aload_0
    //   1199: getfield useCachedSizeField : Z
    //   1202: ifeq -> 1215
    //   1205: aload #11
    //   1207: aload_1
    //   1208: iload_2
    //   1209: i2l
    //   1210: iload #4
    //   1212: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1215: iload #8
    //   1217: invokestatic computeTagSize : (I)I
    //   1220: istore_2
    //   1221: iload #4
    //   1223: invokestatic computeUInt32SizeNoTag : (I)I
    //   1226: istore #7
    //   1228: iload #4
    //   1230: istore_3
    //   1231: iload #7
    //   1233: istore #4
    //   1235: goto -> 1871
    //   1238: aload #11
    //   1240: aload_1
    //   1241: lload #9
    //   1243: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1246: checkcast java/util/List
    //   1249: invokestatic computeSizeEnumListNoTag : (Ljava/util/List;)I
    //   1252: istore #4
    //   1254: iload #6
    //   1256: istore_3
    //   1257: iload #4
    //   1259: ifle -> 2677
    //   1262: aload_0
    //   1263: getfield useCachedSizeField : Z
    //   1266: ifeq -> 1279
    //   1269: aload #11
    //   1271: aload_1
    //   1272: iload_2
    //   1273: i2l
    //   1274: iload #4
    //   1276: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1279: iload #8
    //   1281: invokestatic computeTagSize : (I)I
    //   1284: istore_2
    //   1285: iload #4
    //   1287: invokestatic computeUInt32SizeNoTag : (I)I
    //   1290: istore #7
    //   1292: iload #4
    //   1294: istore_3
    //   1295: iload #7
    //   1297: istore #4
    //   1299: goto -> 1871
    //   1302: aload #11
    //   1304: aload_1
    //   1305: lload #9
    //   1307: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1310: checkcast java/util/List
    //   1313: invokestatic computeSizeUInt32ListNoTag : (Ljava/util/List;)I
    //   1316: istore #4
    //   1318: iload #6
    //   1320: istore_3
    //   1321: iload #4
    //   1323: ifle -> 2677
    //   1326: aload_0
    //   1327: getfield useCachedSizeField : Z
    //   1330: ifeq -> 1343
    //   1333: aload #11
    //   1335: aload_1
    //   1336: iload_2
    //   1337: i2l
    //   1338: iload #4
    //   1340: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1343: iload #8
    //   1345: invokestatic computeTagSize : (I)I
    //   1348: istore_2
    //   1349: iload #4
    //   1351: invokestatic computeUInt32SizeNoTag : (I)I
    //   1354: istore #7
    //   1356: iload #4
    //   1358: istore_3
    //   1359: iload #7
    //   1361: istore #4
    //   1363: goto -> 1871
    //   1366: aload #11
    //   1368: aload_1
    //   1369: lload #9
    //   1371: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1374: checkcast java/util/List
    //   1377: invokestatic computeSizeBoolListNoTag : (Ljava/util/List;)I
    //   1380: istore #4
    //   1382: iload #6
    //   1384: istore_3
    //   1385: iload #4
    //   1387: ifle -> 2677
    //   1390: aload_0
    //   1391: getfield useCachedSizeField : Z
    //   1394: ifeq -> 1407
    //   1397: aload #11
    //   1399: aload_1
    //   1400: iload_2
    //   1401: i2l
    //   1402: iload #4
    //   1404: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1407: iload #8
    //   1409: invokestatic computeTagSize : (I)I
    //   1412: istore_2
    //   1413: iload #4
    //   1415: invokestatic computeUInt32SizeNoTag : (I)I
    //   1418: istore #7
    //   1420: iload #4
    //   1422: istore_3
    //   1423: iload #7
    //   1425: istore #4
    //   1427: goto -> 1871
    //   1430: aload #11
    //   1432: aload_1
    //   1433: lload #9
    //   1435: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1438: checkcast java/util/List
    //   1441: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1444: istore #4
    //   1446: iload #6
    //   1448: istore_3
    //   1449: iload #4
    //   1451: ifle -> 2677
    //   1454: aload_0
    //   1455: getfield useCachedSizeField : Z
    //   1458: ifeq -> 1471
    //   1461: aload #11
    //   1463: aload_1
    //   1464: iload_2
    //   1465: i2l
    //   1466: iload #4
    //   1468: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1471: iload #8
    //   1473: invokestatic computeTagSize : (I)I
    //   1476: istore_2
    //   1477: iload #4
    //   1479: invokestatic computeUInt32SizeNoTag : (I)I
    //   1482: istore #7
    //   1484: iload #4
    //   1486: istore_3
    //   1487: iload #7
    //   1489: istore #4
    //   1491: goto -> 1871
    //   1494: aload #11
    //   1496: aload_1
    //   1497: lload #9
    //   1499: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1502: checkcast java/util/List
    //   1505: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1508: istore #4
    //   1510: iload #6
    //   1512: istore_3
    //   1513: iload #4
    //   1515: ifle -> 2677
    //   1518: aload_0
    //   1519: getfield useCachedSizeField : Z
    //   1522: ifeq -> 1535
    //   1525: aload #11
    //   1527: aload_1
    //   1528: iload_2
    //   1529: i2l
    //   1530: iload #4
    //   1532: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1535: iload #8
    //   1537: invokestatic computeTagSize : (I)I
    //   1540: istore_2
    //   1541: iload #4
    //   1543: invokestatic computeUInt32SizeNoTag : (I)I
    //   1546: istore #7
    //   1548: iload #4
    //   1550: istore_3
    //   1551: iload #7
    //   1553: istore #4
    //   1555: goto -> 1871
    //   1558: aload #11
    //   1560: aload_1
    //   1561: lload #9
    //   1563: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1566: checkcast java/util/List
    //   1569: invokestatic computeSizeInt32ListNoTag : (Ljava/util/List;)I
    //   1572: istore #4
    //   1574: iload #6
    //   1576: istore_3
    //   1577: iload #4
    //   1579: ifle -> 2677
    //   1582: aload_0
    //   1583: getfield useCachedSizeField : Z
    //   1586: ifeq -> 1599
    //   1589: aload #11
    //   1591: aload_1
    //   1592: iload_2
    //   1593: i2l
    //   1594: iload #4
    //   1596: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1599: iload #8
    //   1601: invokestatic computeTagSize : (I)I
    //   1604: istore_2
    //   1605: iload #4
    //   1607: invokestatic computeUInt32SizeNoTag : (I)I
    //   1610: istore #7
    //   1612: iload #4
    //   1614: istore_3
    //   1615: iload #7
    //   1617: istore #4
    //   1619: goto -> 1871
    //   1622: aload #11
    //   1624: aload_1
    //   1625: lload #9
    //   1627: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1630: checkcast java/util/List
    //   1633: invokestatic computeSizeUInt64ListNoTag : (Ljava/util/List;)I
    //   1636: istore #4
    //   1638: iload #6
    //   1640: istore_3
    //   1641: iload #4
    //   1643: ifle -> 2677
    //   1646: aload_0
    //   1647: getfield useCachedSizeField : Z
    //   1650: ifeq -> 1663
    //   1653: aload #11
    //   1655: aload_1
    //   1656: iload_2
    //   1657: i2l
    //   1658: iload #4
    //   1660: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1663: iload #8
    //   1665: invokestatic computeTagSize : (I)I
    //   1668: istore_2
    //   1669: iload #4
    //   1671: invokestatic computeUInt32SizeNoTag : (I)I
    //   1674: istore #7
    //   1676: iload #4
    //   1678: istore_3
    //   1679: iload #7
    //   1681: istore #4
    //   1683: goto -> 1871
    //   1686: aload #11
    //   1688: aload_1
    //   1689: lload #9
    //   1691: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1694: checkcast java/util/List
    //   1697: invokestatic computeSizeInt64ListNoTag : (Ljava/util/List;)I
    //   1700: istore #4
    //   1702: iload #6
    //   1704: istore_3
    //   1705: iload #4
    //   1707: ifle -> 2677
    //   1710: aload_0
    //   1711: getfield useCachedSizeField : Z
    //   1714: ifeq -> 1727
    //   1717: aload #11
    //   1719: aload_1
    //   1720: iload_2
    //   1721: i2l
    //   1722: iload #4
    //   1724: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1727: iload #8
    //   1729: invokestatic computeTagSize : (I)I
    //   1732: istore_2
    //   1733: iload #4
    //   1735: invokestatic computeUInt32SizeNoTag : (I)I
    //   1738: istore #7
    //   1740: iload #4
    //   1742: istore_3
    //   1743: iload #7
    //   1745: istore #4
    //   1747: goto -> 1871
    //   1750: aload #11
    //   1752: aload_1
    //   1753: lload #9
    //   1755: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1758: checkcast java/util/List
    //   1761: invokestatic computeSizeFixed32ListNoTag : (Ljava/util/List;)I
    //   1764: istore #4
    //   1766: iload #6
    //   1768: istore_3
    //   1769: iload #4
    //   1771: ifle -> 2677
    //   1774: aload_0
    //   1775: getfield useCachedSizeField : Z
    //   1778: ifeq -> 1791
    //   1781: aload #11
    //   1783: aload_1
    //   1784: iload_2
    //   1785: i2l
    //   1786: iload #4
    //   1788: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1791: iload #8
    //   1793: invokestatic computeTagSize : (I)I
    //   1796: istore_2
    //   1797: iload #4
    //   1799: invokestatic computeUInt32SizeNoTag : (I)I
    //   1802: istore #7
    //   1804: iload #4
    //   1806: istore_3
    //   1807: iload #7
    //   1809: istore #4
    //   1811: goto -> 1871
    //   1814: aload #11
    //   1816: aload_1
    //   1817: lload #9
    //   1819: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1822: checkcast java/util/List
    //   1825: invokestatic computeSizeFixed64ListNoTag : (Ljava/util/List;)I
    //   1828: istore #7
    //   1830: iload #6
    //   1832: istore_3
    //   1833: iload #7
    //   1835: ifle -> 2677
    //   1838: aload_0
    //   1839: getfield useCachedSizeField : Z
    //   1842: ifeq -> 1855
    //   1845: aload #11
    //   1847: aload_1
    //   1848: iload_2
    //   1849: i2l
    //   1850: iload #7
    //   1852: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1855: iload #8
    //   1857: invokestatic computeTagSize : (I)I
    //   1860: istore_2
    //   1861: iload #7
    //   1863: invokestatic computeUInt32SizeNoTag : (I)I
    //   1866: istore #4
    //   1868: iload #7
    //   1870: istore_3
    //   1871: iload_2
    //   1872: iload #4
    //   1874: iadd
    //   1875: iload_3
    //   1876: iadd
    //   1877: istore_2
    //   1878: goto -> 2153
    //   1881: iload #8
    //   1883: aload_1
    //   1884: lload #9
    //   1886: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1889: iconst_0
    //   1890: invokestatic computeSizeSInt64List : (ILjava/util/List;Z)I
    //   1893: istore_2
    //   1894: goto -> 2153
    //   1897: iload #8
    //   1899: aload_1
    //   1900: lload #9
    //   1902: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1905: iconst_0
    //   1906: invokestatic computeSizeSInt32List : (ILjava/util/List;Z)I
    //   1909: istore_2
    //   1910: goto -> 2153
    //   1913: iload #8
    //   1915: aload_1
    //   1916: lload #9
    //   1918: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1921: iconst_0
    //   1922: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   1925: istore_2
    //   1926: goto -> 2153
    //   1929: iload #8
    //   1931: aload_1
    //   1932: lload #9
    //   1934: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1937: iconst_0
    //   1938: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   1941: istore_2
    //   1942: goto -> 2153
    //   1945: iload #8
    //   1947: aload_1
    //   1948: lload #9
    //   1950: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1953: iconst_0
    //   1954: invokestatic computeSizeEnumList : (ILjava/util/List;Z)I
    //   1957: istore_2
    //   1958: goto -> 2153
    //   1961: iload #8
    //   1963: aload_1
    //   1964: lload #9
    //   1966: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1969: iconst_0
    //   1970: invokestatic computeSizeUInt32List : (ILjava/util/List;Z)I
    //   1973: istore_2
    //   1974: goto -> 2153
    //   1977: iload #8
    //   1979: aload_1
    //   1980: lload #9
    //   1982: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   1985: invokestatic computeSizeByteStringList : (ILjava/util/List;)I
    //   1988: istore_2
    //   1989: goto -> 2153
    //   1992: iload #8
    //   1994: aload_1
    //   1995: lload #9
    //   1997: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2000: aload_0
    //   2001: iload #5
    //   2003: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2006: invokestatic computeSizeMessageList : (ILjava/util/List;Lcom/google/protobuf/Schema;)I
    //   2009: istore_2
    //   2010: goto -> 2153
    //   2013: iload #8
    //   2015: aload_1
    //   2016: lload #9
    //   2018: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2021: invokestatic computeSizeStringList : (ILjava/util/List;)I
    //   2024: istore_2
    //   2025: goto -> 2153
    //   2028: iload #8
    //   2030: aload_1
    //   2031: lload #9
    //   2033: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2036: iconst_0
    //   2037: invokestatic computeSizeBoolList : (ILjava/util/List;Z)I
    //   2040: istore_2
    //   2041: goto -> 2153
    //   2044: iload #8
    //   2046: aload_1
    //   2047: lload #9
    //   2049: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2052: iconst_0
    //   2053: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   2056: istore_2
    //   2057: goto -> 2153
    //   2060: iload #8
    //   2062: aload_1
    //   2063: lload #9
    //   2065: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2068: iconst_0
    //   2069: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   2072: istore_2
    //   2073: goto -> 2153
    //   2076: iload #8
    //   2078: aload_1
    //   2079: lload #9
    //   2081: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2084: iconst_0
    //   2085: invokestatic computeSizeInt32List : (ILjava/util/List;Z)I
    //   2088: istore_2
    //   2089: goto -> 2153
    //   2092: iload #8
    //   2094: aload_1
    //   2095: lload #9
    //   2097: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2100: iconst_0
    //   2101: invokestatic computeSizeUInt64List : (ILjava/util/List;Z)I
    //   2104: istore_2
    //   2105: goto -> 2153
    //   2108: iload #8
    //   2110: aload_1
    //   2111: lload #9
    //   2113: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2116: iconst_0
    //   2117: invokestatic computeSizeInt64List : (ILjava/util/List;Z)I
    //   2120: istore_2
    //   2121: goto -> 2153
    //   2124: iload #8
    //   2126: aload_1
    //   2127: lload #9
    //   2129: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2132: iconst_0
    //   2133: invokestatic computeSizeFixed32List : (ILjava/util/List;Z)I
    //   2136: istore_2
    //   2137: goto -> 2153
    //   2140: iload #8
    //   2142: aload_1
    //   2143: lload #9
    //   2145: invokestatic listAt : (Ljava/lang/Object;J)Ljava/util/List;
    //   2148: iconst_0
    //   2149: invokestatic computeSizeFixed64List : (ILjava/util/List;Z)I
    //   2152: istore_2
    //   2153: iload #6
    //   2155: iload_2
    //   2156: iadd
    //   2157: istore_3
    //   2158: goto -> 2677
    //   2161: iload #6
    //   2163: istore_3
    //   2164: aload_0
    //   2165: aload_1
    //   2166: iload #5
    //   2168: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2171: ifeq -> 2677
    //   2174: iload #8
    //   2176: aload_1
    //   2177: lload #9
    //   2179: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2182: checkcast com/google/protobuf/MessageLite
    //   2185: aload_0
    //   2186: iload #5
    //   2188: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2191: invokestatic computeGroupSize : (ILcom/google/protobuf/MessageLite;Lcom/google/protobuf/Schema;)I
    //   2194: istore_2
    //   2195: goto -> 2153
    //   2198: iload #6
    //   2200: istore_3
    //   2201: aload_0
    //   2202: aload_1
    //   2203: iload #5
    //   2205: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2208: ifeq -> 2677
    //   2211: iload #8
    //   2213: aload_1
    //   2214: lload #9
    //   2216: invokestatic getLong : (Ljava/lang/Object;J)J
    //   2219: invokestatic computeSInt64Size : (IJ)I
    //   2222: istore_2
    //   2223: goto -> 2153
    //   2226: iload #6
    //   2228: istore_3
    //   2229: aload_0
    //   2230: aload_1
    //   2231: iload #5
    //   2233: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2236: ifeq -> 2677
    //   2239: iload #8
    //   2241: aload_1
    //   2242: lload #9
    //   2244: invokestatic getInt : (Ljava/lang/Object;J)I
    //   2247: invokestatic computeSInt32Size : (II)I
    //   2250: istore_2
    //   2251: goto -> 2153
    //   2254: iload #6
    //   2256: istore_3
    //   2257: aload_0
    //   2258: aload_1
    //   2259: iload #5
    //   2261: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2264: ifeq -> 2677
    //   2267: iload #8
    //   2269: lconst_0
    //   2270: invokestatic computeSFixed64Size : (IJ)I
    //   2273: istore_2
    //   2274: goto -> 2153
    //   2277: iload #6
    //   2279: istore_3
    //   2280: aload_0
    //   2281: aload_1
    //   2282: iload #5
    //   2284: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2287: ifeq -> 2677
    //   2290: iload #8
    //   2292: iconst_0
    //   2293: invokestatic computeSFixed32Size : (II)I
    //   2296: istore_2
    //   2297: goto -> 2153
    //   2300: iload #6
    //   2302: istore_3
    //   2303: aload_0
    //   2304: aload_1
    //   2305: iload #5
    //   2307: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2310: ifeq -> 2677
    //   2313: iload #8
    //   2315: aload_1
    //   2316: lload #9
    //   2318: invokestatic getInt : (Ljava/lang/Object;J)I
    //   2321: invokestatic computeEnumSize : (II)I
    //   2324: istore_2
    //   2325: goto -> 2153
    //   2328: iload #6
    //   2330: istore_3
    //   2331: aload_0
    //   2332: aload_1
    //   2333: iload #5
    //   2335: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2338: ifeq -> 2677
    //   2341: iload #8
    //   2343: aload_1
    //   2344: lload #9
    //   2346: invokestatic getInt : (Ljava/lang/Object;J)I
    //   2349: invokestatic computeUInt32Size : (II)I
    //   2352: istore_2
    //   2353: goto -> 2153
    //   2356: iload #6
    //   2358: istore_3
    //   2359: aload_0
    //   2360: aload_1
    //   2361: iload #5
    //   2363: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2366: ifeq -> 2677
    //   2369: iload #8
    //   2371: aload_1
    //   2372: lload #9
    //   2374: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2377: checkcast com/google/protobuf/ByteString
    //   2380: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   2383: istore_2
    //   2384: goto -> 2153
    //   2387: iload #6
    //   2389: istore_3
    //   2390: aload_0
    //   2391: aload_1
    //   2392: iload #5
    //   2394: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2397: ifeq -> 2677
    //   2400: iload #8
    //   2402: aload_1
    //   2403: lload #9
    //   2405: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2408: aload_0
    //   2409: iload #5
    //   2411: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2414: invokestatic computeSizeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)I
    //   2417: istore_2
    //   2418: goto -> 2153
    //   2421: iload #6
    //   2423: istore_3
    //   2424: aload_0
    //   2425: aload_1
    //   2426: iload #5
    //   2428: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2431: ifeq -> 2677
    //   2434: aload_1
    //   2435: lload #9
    //   2437: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2440: astore #12
    //   2442: aload #12
    //   2444: instanceof com/google/protobuf/ByteString
    //   2447: ifeq -> 2464
    //   2450: iload #8
    //   2452: aload #12
    //   2454: checkcast com/google/protobuf/ByteString
    //   2457: invokestatic computeBytesSize : (ILcom/google/protobuf/ByteString;)I
    //   2460: istore_2
    //   2461: goto -> 2153
    //   2464: iload #8
    //   2466: aload #12
    //   2468: checkcast java/lang/String
    //   2471: invokestatic computeStringSize : (ILjava/lang/String;)I
    //   2474: istore_2
    //   2475: goto -> 2153
    //   2478: iload #6
    //   2480: istore_3
    //   2481: aload_0
    //   2482: aload_1
    //   2483: iload #5
    //   2485: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2488: ifeq -> 2677
    //   2491: iload #8
    //   2493: iconst_1
    //   2494: invokestatic computeBoolSize : (IZ)I
    //   2497: istore_2
    //   2498: goto -> 2153
    //   2501: iload #6
    //   2503: istore_3
    //   2504: aload_0
    //   2505: aload_1
    //   2506: iload #5
    //   2508: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2511: ifeq -> 2677
    //   2514: iload #8
    //   2516: iconst_0
    //   2517: invokestatic computeFixed32Size : (II)I
    //   2520: istore_2
    //   2521: goto -> 2153
    //   2524: iload #6
    //   2526: istore_3
    //   2527: aload_0
    //   2528: aload_1
    //   2529: iload #5
    //   2531: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2534: ifeq -> 2677
    //   2537: iload #8
    //   2539: lconst_0
    //   2540: invokestatic computeFixed64Size : (IJ)I
    //   2543: istore_2
    //   2544: goto -> 2153
    //   2547: iload #6
    //   2549: istore_3
    //   2550: aload_0
    //   2551: aload_1
    //   2552: iload #5
    //   2554: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2557: ifeq -> 2677
    //   2560: iload #8
    //   2562: aload_1
    //   2563: lload #9
    //   2565: invokestatic getInt : (Ljava/lang/Object;J)I
    //   2568: invokestatic computeInt32Size : (II)I
    //   2571: istore_2
    //   2572: goto -> 2153
    //   2575: iload #6
    //   2577: istore_3
    //   2578: aload_0
    //   2579: aload_1
    //   2580: iload #5
    //   2582: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2585: ifeq -> 2677
    //   2588: iload #8
    //   2590: aload_1
    //   2591: lload #9
    //   2593: invokestatic getLong : (Ljava/lang/Object;J)J
    //   2596: invokestatic computeUInt64Size : (IJ)I
    //   2599: istore_2
    //   2600: goto -> 2153
    //   2603: iload #6
    //   2605: istore_3
    //   2606: aload_0
    //   2607: aload_1
    //   2608: iload #5
    //   2610: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2613: ifeq -> 2677
    //   2616: iload #8
    //   2618: aload_1
    //   2619: lload #9
    //   2621: invokestatic getLong : (Ljava/lang/Object;J)J
    //   2624: invokestatic computeInt64Size : (IJ)I
    //   2627: istore_2
    //   2628: goto -> 2153
    //   2631: iload #6
    //   2633: istore_3
    //   2634: aload_0
    //   2635: aload_1
    //   2636: iload #5
    //   2638: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2641: ifeq -> 2677
    //   2644: iload #8
    //   2646: fconst_0
    //   2647: invokestatic computeFloatSize : (IF)I
    //   2650: istore_2
    //   2651: goto -> 2153
    //   2654: iload #6
    //   2656: istore_3
    //   2657: aload_0
    //   2658: aload_1
    //   2659: iload #5
    //   2661: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2664: ifeq -> 2677
    //   2667: iload #8
    //   2669: dconst_0
    //   2670: invokestatic computeDoubleSize : (ID)I
    //   2673: istore_2
    //   2674: goto -> 2153
    //   2677: iload #5
    //   2679: iconst_3
    //   2680: iadd
    //   2681: istore #5
    //   2683: iload_3
    //   2684: istore #6
    //   2686: goto -> 11
    //   2689: iload #6
    //   2691: aload_0
    //   2692: aload_0
    //   2693: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   2696: aload_1
    //   2697: invokespecial getUnknownFieldsSerializedSize : (Lcom/google/protobuf/UnknownFieldSchema;Ljava/lang/Object;)I
    //   2700: iadd
    //   2701: ireturn
  }
  
  private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT) {
    return paramUnknownFieldSchema.getSerializedSize(paramUnknownFieldSchema.getFromMessage(paramT));
  }
  
  private static <T> int intAt(T paramT, long paramLong) {
    return UnsafeUtil.getInt(paramT, paramLong);
  }
  
  private static boolean isEnforceUtf8(int paramInt) {
    return ((paramInt & 0x20000000) != 0);
  }
  
  private boolean isFieldPresent(T paramT, int paramInt) {
    int i = presenceMaskAndOffsetAt(paramInt);
    long l = (0xFFFFF & i);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool12 = false;
    boolean bool13 = false;
    boolean bool14 = false;
    boolean bool15 = false;
    boolean bool16 = false;
    boolean bool1 = false;
    if (l == 1048575L) {
      paramInt = typeAndOffsetAt(paramInt);
      l = offset(paramInt);
      switch (type(paramInt)) {
        default:
          throw new IllegalArgumentException();
        case 17:
          if (UnsafeUtil.getObject(paramT, l) != null)
            bool1 = true; 
          return bool1;
        case 16:
          bool1 = bool2;
          if (UnsafeUtil.getLong(paramT, l) != 0L)
            bool1 = true; 
          return bool1;
        case 15:
          bool1 = bool3;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 14:
          bool1 = bool4;
          if (UnsafeUtil.getLong(paramT, l) != 0L)
            bool1 = true; 
          return bool1;
        case 13:
          bool1 = bool5;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 12:
          bool1 = bool6;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 11:
          bool1 = bool7;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 10:
          return ByteString.EMPTY.equals(UnsafeUtil.getObject(paramT, l)) ^ true;
        case 9:
          bool1 = bool8;
          if (UnsafeUtil.getObject(paramT, l) != null)
            bool1 = true; 
          return bool1;
        case 8:
          paramT = (T)UnsafeUtil.getObject(paramT, l);
          if (paramT instanceof String)
            return ((String)paramT).isEmpty() ^ true; 
          if (paramT instanceof ByteString)
            return ByteString.EMPTY.equals(paramT) ^ true; 
          throw new IllegalArgumentException();
        case 7:
          return UnsafeUtil.getBoolean(paramT, l);
        case 6:
          bool1 = bool9;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 5:
          bool1 = bool10;
          if (UnsafeUtil.getLong(paramT, l) != 0L)
            bool1 = true; 
          return bool1;
        case 4:
          bool1 = bool11;
          if (UnsafeUtil.getInt(paramT, l) != 0)
            bool1 = true; 
          return bool1;
        case 3:
          bool1 = bool12;
          if (UnsafeUtil.getLong(paramT, l) != 0L)
            bool1 = true; 
          return bool1;
        case 2:
          bool1 = bool13;
          if (UnsafeUtil.getLong(paramT, l) != 0L)
            bool1 = true; 
          return bool1;
        case 1:
          bool1 = bool14;
          if (UnsafeUtil.getFloat(paramT, l) != 0.0F)
            bool1 = true; 
          return bool1;
        case 0:
          break;
      } 
      bool1 = bool15;
      if (UnsafeUtil.getDouble(paramT, l) != 0.0D)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool16;
    if ((UnsafeUtil.getInt(paramT, l) & 1 << i >>> 20) != 0)
      bool1 = true; 
    return bool1;
  }
  
  private boolean isFieldPresent(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt2 == 1048575) ? isFieldPresent(paramT, paramInt1) : (((paramInt3 & paramInt4) != 0));
  }
  
  private static boolean isInitialized(Object paramObject, int paramInt, Schema<Object> paramSchema) {
    return paramSchema.isInitialized(UnsafeUtil.getObject(paramObject, offset(paramInt)));
  }
  
  private <N> boolean isListInitialized(Object paramObject, int paramInt1, int paramInt2) {
    paramObject = UnsafeUtil.getObject(paramObject, offset(paramInt1));
    if (paramObject.isEmpty())
      return true; 
    Schema schema = getMessageFieldSchema(paramInt2);
    for (paramInt1 = 0; paramInt1 < paramObject.size(); paramInt1++) {
      if (!schema.isInitialized(paramObject.get(paramInt1)))
        return false; 
    } 
    return true;
  }
  
  private boolean isMapInitialized(T paramT, int paramInt1, int paramInt2) {
    Map<?, ?> map = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(paramT, offset(paramInt1)));
    if (map.isEmpty())
      return true; 
    paramT = (T)getMapFieldDefaultEntry(paramInt2);
    if ((this.mapFieldSchema.forMapMetadata(paramT)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE)
      return true; 
    paramT = null;
    for (Object object : map.values()) {
      Schema<?> schema2;
      T t = paramT;
      if (paramT == null)
        schema2 = Protobuf.getInstance().schemaFor(object.getClass()); 
      Schema<?> schema1 = schema2;
      if (!schema2.isInitialized(object))
        return false; 
    } 
    return true;
  }
  
  private boolean isOneofCaseEqual(T paramT1, T paramT2, int paramInt) {
    long l = (presenceMaskAndOffsetAt(paramInt) & 0xFFFFF);
    return (UnsafeUtil.getInt(paramT1, l) == UnsafeUtil.getInt(paramT2, l));
  }
  
  private boolean isOneofPresent(T paramT, int paramInt1, int paramInt2) {
    return (UnsafeUtil.getInt(paramT, (presenceMaskAndOffsetAt(paramInt2) & 0xFFFFF)) == paramInt1);
  }
  
  private static boolean isRequired(int paramInt) {
    return ((paramInt & 0x10000000) != 0);
  }
  
  private static List<?> listAt(Object paramObject, long paramLong) {
    return (List)UnsafeUtil.getObject(paramObject, paramLong);
  }
  
  private static <T> long longAt(T paramT, long paramLong) {
    return UnsafeUtil.getLong(paramT, paramLong);
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, ExtensionSchema<ET> paramExtensionSchema, T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    UB uB1 = null;
    UB uB2 = uB1;
    while (true) {
      UB uB3;
      UB uB4 = uB1;
      try {
        UB uB7;
        int i = paramReader.getFieldNumber();
        uB4 = uB1;
        int j = positionForFieldNumber(i);
        if (j < 0) {
          Object object;
          if (i == Integer.MAX_VALUE)
            return; 
          UB uB10 = uB1;
          if (!this.hasExtensions) {
            uB7 = null;
          } else {
            UB uB = uB1;
            uB7 = (UB)paramExtensionSchema.findExtensionByNumber(paramExtensionRegistryLite, this.defaultInstance, i);
          } 
          if (uB7 != null) {
            UB uB12 = uB2;
            if (uB2 == null) {
              UB uB = uB1;
              object = paramExtensionSchema.getMutableExtensions(paramT);
            } 
            UB uB11 = uB1;
            uB1 = paramExtensionSchema.parseExtension(paramReader, uB7, paramExtensionRegistryLite, (FieldSet<ET>)object, uB1, paramUnknownFieldSchema);
            FieldSet<ET> fieldSet = (FieldSet<ET>)object;
            continue;
          } 
          UB uB9 = uB1;
          if (paramUnknownFieldSchema.shouldDiscardUnknownFields(paramReader)) {
            object = uB1;
            UB uB = uB1;
            if (paramReader.skipField())
              continue; 
          } else {
            uB7 = uB1;
            if (uB1 == null) {
              UB uB = uB1;
              uB7 = paramUnknownFieldSchema.getBuilderFromMessage(paramT);
            } 
            uB9 = uB7;
            boolean bool = paramUnknownFieldSchema.mergeOneFieldFrom(uB7, paramReader);
            object = uB7;
            if (bool) {
              uB1 = uB7;
              continue;
            } 
          } 
          return;
        } 
        UB uB6 = uB1;
        int k = typeAndOffsetAt(j);
        UB uB5 = uB1;
      } finally {
        int i;
        for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++)
          uB3 = filterMapUnknownEnumValues(paramT, this.intArray[i], uB3, paramUnknownFieldSchema); 
        if (uB3 != null)
          paramUnknownFieldSchema.setBuilderToMessage(paramT, uB3); 
      } 
    } 
  }
  
  private final <K, V> void mergeMap(Object paramObject1, int paramInt, Object paramObject2, ExtensionRegistryLite paramExtensionRegistryLite, Reader paramReader) throws IOException {
    Object object1;
    long l = offset(typeAndOffsetAt(paramInt));
    Object object2 = UnsafeUtil.getObject(paramObject1, l);
    if (object2 == null) {
      object1 = this.mapFieldSchema.newMapField(paramObject2);
      UnsafeUtil.putObject(paramObject1, l, object1);
    } else {
      object1 = object2;
      if (this.mapFieldSchema.isImmutable(object2)) {
        object1 = this.mapFieldSchema.newMapField(paramObject2);
        this.mapFieldSchema.mergeFrom(object1, object2);
        UnsafeUtil.putObject(paramObject1, l, object1);
      } 
    } 
    paramReader.readMap(this.mapFieldSchema.forMutableMapData(object1), this.mapFieldSchema.forMapMetadata(paramObject2), paramExtensionRegistryLite);
  }
  
  private void mergeMessage(T paramT1, T paramT2, int paramInt) {
    long l = offset(typeAndOffsetAt(paramInt));
    if (!isFieldPresent(paramT2, paramInt))
      return; 
    Object object = UnsafeUtil.getObject(paramT1, l);
    paramT2 = (T)UnsafeUtil.getObject(paramT2, l);
    if (object != null && paramT2 != null) {
      UnsafeUtil.putObject(paramT1, l, Internal.mergeMessage(object, paramT2));
      setFieldPresent(paramT1, paramInt);
      return;
    } 
    if (paramT2 != null) {
      UnsafeUtil.putObject(paramT1, l, paramT2);
      setFieldPresent(paramT1, paramInt);
    } 
  }
  
  private void mergeOneofMessage(T paramT1, T paramT2, int paramInt) {
    int i = typeAndOffsetAt(paramInt);
    int j = numberAt(paramInt);
    long l = offset(i);
    if (!isOneofPresent(paramT2, j, paramInt))
      return; 
    Object object = UnsafeUtil.getObject(paramT1, l);
    paramT2 = (T)UnsafeUtil.getObject(paramT2, l);
    if (object != null && paramT2 != null) {
      UnsafeUtil.putObject(paramT1, l, Internal.mergeMessage(object, paramT2));
      setOneofPresent(paramT1, j, paramInt);
      return;
    } 
    if (paramT2 != null) {
      UnsafeUtil.putObject(paramT1, l, paramT2);
      setOneofPresent(paramT1, j, paramInt);
    } 
  }
  
  private void mergeSingleField(T paramT1, T paramT2, int paramInt) {
    int i = typeAndOffsetAt(paramInt);
    long l = offset(i);
    int j = numberAt(paramInt);
    switch (type(i)) {
      default:
        return;
      case 68:
        mergeOneofMessage(paramT1, paramT2, paramInt);
        return;
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
        if (isOneofPresent(paramT2, j, paramInt)) {
          UnsafeUtil.putObject(paramT1, l, UnsafeUtil.getObject(paramT2, l));
          setOneofPresent(paramT1, j, paramInt);
          return;
        } 
        return;
      case 60:
        mergeOneofMessage(paramT1, paramT2, paramInt);
        return;
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
        if (isOneofPresent(paramT2, j, paramInt)) {
          UnsafeUtil.putObject(paramT1, l, UnsafeUtil.getObject(paramT2, l));
          setOneofPresent(paramT1, j, paramInt);
          return;
        } 
        return;
      case 50:
        SchemaUtil.mergeMap(this.mapFieldSchema, paramT1, paramT2, l);
        return;
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
        this.listFieldSchema.mergeListsAt(paramT1, paramT2, l);
        return;
      case 17:
        mergeMessage(paramT1, paramT2, paramInt);
        return;
      case 16:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putLong(paramT1, l, UnsafeUtil.getLong(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 15:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 14:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putLong(paramT1, l, UnsafeUtil.getLong(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 13:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 12:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 11:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 10:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putObject(paramT1, l, UnsafeUtil.getObject(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 9:
        mergeMessage(paramT1, paramT2, paramInt);
        return;
      case 8:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putObject(paramT1, l, UnsafeUtil.getObject(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 7:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putBoolean(paramT1, l, UnsafeUtil.getBoolean(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 6:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 5:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putLong(paramT1, l, UnsafeUtil.getLong(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 4:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putInt(paramT1, l, UnsafeUtil.getInt(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 3:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putLong(paramT1, l, UnsafeUtil.getLong(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 2:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putLong(paramT1, l, UnsafeUtil.getLong(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 1:
        if (isFieldPresent(paramT2, paramInt)) {
          UnsafeUtil.putFloat(paramT1, l, UnsafeUtil.getFloat(paramT2, l));
          setFieldPresent(paramT1, paramInt);
          return;
        } 
        return;
      case 0:
        break;
    } 
    if (isFieldPresent(paramT2, paramInt)) {
      UnsafeUtil.putDouble(paramT1, l, UnsafeUtil.getDouble(paramT2, l));
      setFieldPresent(paramT1, paramInt);
    } 
  }
  
  static <T> MessageSchema<T> newSchema(Class<T> paramClass, MessageInfo paramMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema) {
    return (paramMessageInfo instanceof RawMessageInfo) ? newSchemaForRawMessageInfo((RawMessageInfo)paramMessageInfo, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo)paramMessageInfo, paramNewInstanceSchema, paramListFieldSchema, paramUnknownFieldSchema, paramExtensionSchema, paramMapFieldSchema);
  }
  
  static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo paramStructuralMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getSyntax : ()Lcom/google/protobuf/ProtoSyntax;
    //   4: getstatic com/google/protobuf/ProtoSyntax.PROTO3 : Lcom/google/protobuf/ProtoSyntax;
    //   7: if_acmpne -> 16
    //   10: iconst_1
    //   11: istore #15
    //   13: goto -> 19
    //   16: iconst_0
    //   17: istore #15
    //   19: aload_0
    //   20: invokevirtual getFields : ()[Lcom/google/protobuf/FieldInfo;
    //   23: astore #22
    //   25: aload #22
    //   27: arraylength
    //   28: ifne -> 40
    //   31: iconst_0
    //   32: istore #8
    //   34: iconst_0
    //   35: istore #9
    //   37: goto -> 62
    //   40: aload #22
    //   42: iconst_0
    //   43: aaload
    //   44: invokevirtual getFieldNumber : ()I
    //   47: istore #8
    //   49: aload #22
    //   51: aload #22
    //   53: arraylength
    //   54: iconst_1
    //   55: isub
    //   56: aaload
    //   57: invokevirtual getFieldNumber : ()I
    //   60: istore #9
    //   62: aload #22
    //   64: arraylength
    //   65: istore #6
    //   67: iload #6
    //   69: iconst_3
    //   70: imul
    //   71: newarray int
    //   73: astore #20
    //   75: iload #6
    //   77: iconst_2
    //   78: imul
    //   79: anewarray java/lang/Object
    //   82: astore #21
    //   84: aload #22
    //   86: arraylength
    //   87: istore #13
    //   89: iconst_0
    //   90: istore #7
    //   92: iconst_0
    //   93: istore #10
    //   95: iconst_0
    //   96: istore #6
    //   98: iload #7
    //   100: iload #13
    //   102: if_icmpge -> 205
    //   105: aload #22
    //   107: iload #7
    //   109: aaload
    //   110: astore #16
    //   112: aload #16
    //   114: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   117: getstatic com/google/protobuf/FieldType.MAP : Lcom/google/protobuf/FieldType;
    //   120: if_acmpne -> 136
    //   123: iload #10
    //   125: iconst_1
    //   126: iadd
    //   127: istore #11
    //   129: iload #6
    //   131: istore #12
    //   133: goto -> 188
    //   136: iload #10
    //   138: istore #11
    //   140: iload #6
    //   142: istore #12
    //   144: aload #16
    //   146: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   149: invokevirtual id : ()I
    //   152: bipush #18
    //   154: if_icmplt -> 188
    //   157: iload #10
    //   159: istore #11
    //   161: iload #6
    //   163: istore #12
    //   165: aload #16
    //   167: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   170: invokevirtual id : ()I
    //   173: bipush #49
    //   175: if_icmpgt -> 188
    //   178: iload #6
    //   180: iconst_1
    //   181: iadd
    //   182: istore #12
    //   184: iload #10
    //   186: istore #11
    //   188: iload #7
    //   190: iconst_1
    //   191: iadd
    //   192: istore #7
    //   194: iload #11
    //   196: istore #10
    //   198: iload #12
    //   200: istore #6
    //   202: goto -> 98
    //   205: aconst_null
    //   206: astore #17
    //   208: iload #10
    //   210: ifle -> 222
    //   213: iload #10
    //   215: newarray int
    //   217: astore #16
    //   219: goto -> 225
    //   222: aconst_null
    //   223: astore #16
    //   225: iload #6
    //   227: ifle -> 236
    //   230: iload #6
    //   232: newarray int
    //   234: astore #17
    //   236: aload_0
    //   237: invokevirtual getCheckInitialized : ()[I
    //   240: astore #19
    //   242: aload #19
    //   244: astore #18
    //   246: aload #19
    //   248: ifnonnull -> 256
    //   251: getstatic com/google/protobuf/MessageSchema.EMPTY_INT_ARRAY : [I
    //   254: astore #18
    //   256: iconst_0
    //   257: istore #12
    //   259: iconst_0
    //   260: istore #10
    //   262: iconst_0
    //   263: istore #7
    //   265: iconst_0
    //   266: istore #6
    //   268: iconst_0
    //   269: istore #11
    //   271: iload #12
    //   273: aload #22
    //   275: arraylength
    //   276: if_icmpge -> 447
    //   279: aload #22
    //   281: iload #12
    //   283: aaload
    //   284: astore #19
    //   286: aload #19
    //   288: invokevirtual getFieldNumber : ()I
    //   291: istore #14
    //   293: aload #19
    //   295: aload #20
    //   297: iload #10
    //   299: aload #21
    //   301: invokestatic storeFieldData : (Lcom/google/protobuf/FieldInfo;[II[Ljava/lang/Object;)V
    //   304: iload #7
    //   306: istore #13
    //   308: iload #7
    //   310: aload #18
    //   312: arraylength
    //   313: if_icmpge -> 343
    //   316: iload #7
    //   318: istore #13
    //   320: aload #18
    //   322: iload #7
    //   324: iaload
    //   325: iload #14
    //   327: if_icmpne -> 343
    //   330: aload #18
    //   332: iload #7
    //   334: iload #10
    //   336: iastore
    //   337: iload #7
    //   339: iconst_1
    //   340: iadd
    //   341: istore #13
    //   343: aload #19
    //   345: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   348: getstatic com/google/protobuf/FieldType.MAP : Lcom/google/protobuf/FieldType;
    //   351: if_acmpne -> 374
    //   354: aload #16
    //   356: iload #6
    //   358: iload #10
    //   360: iastore
    //   361: iload #6
    //   363: iconst_1
    //   364: iadd
    //   365: istore #7
    //   367: iload #7
    //   369: istore #6
    //   371: goto -> 428
    //   374: iload #6
    //   376: istore #7
    //   378: aload #19
    //   380: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   383: invokevirtual id : ()I
    //   386: bipush #18
    //   388: if_icmplt -> 367
    //   391: iload #6
    //   393: istore #7
    //   395: aload #19
    //   397: invokevirtual getType : ()Lcom/google/protobuf/FieldType;
    //   400: invokevirtual id : ()I
    //   403: bipush #49
    //   405: if_icmpgt -> 367
    //   408: aload #17
    //   410: iload #11
    //   412: aload #19
    //   414: invokevirtual getField : ()Ljava/lang/reflect/Field;
    //   417: invokestatic objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   420: l2i
    //   421: iastore
    //   422: iload #11
    //   424: iconst_1
    //   425: iadd
    //   426: istore #11
    //   428: iload #12
    //   430: iconst_1
    //   431: iadd
    //   432: istore #12
    //   434: iload #10
    //   436: iconst_3
    //   437: iadd
    //   438: istore #10
    //   440: iload #13
    //   442: istore #7
    //   444: goto -> 271
    //   447: aload #16
    //   449: astore #19
    //   451: aload #16
    //   453: ifnonnull -> 461
    //   456: getstatic com/google/protobuf/MessageSchema.EMPTY_INT_ARRAY : [I
    //   459: astore #19
    //   461: aload #17
    //   463: astore #16
    //   465: aload #17
    //   467: ifnonnull -> 475
    //   470: getstatic com/google/protobuf/MessageSchema.EMPTY_INT_ARRAY : [I
    //   473: astore #16
    //   475: aload #18
    //   477: arraylength
    //   478: aload #19
    //   480: arraylength
    //   481: iadd
    //   482: aload #16
    //   484: arraylength
    //   485: iadd
    //   486: newarray int
    //   488: astore #17
    //   490: aload #18
    //   492: iconst_0
    //   493: aload #17
    //   495: iconst_0
    //   496: aload #18
    //   498: arraylength
    //   499: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   502: aload #19
    //   504: iconst_0
    //   505: aload #17
    //   507: aload #18
    //   509: arraylength
    //   510: aload #19
    //   512: arraylength
    //   513: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   516: aload #16
    //   518: iconst_0
    //   519: aload #17
    //   521: aload #18
    //   523: arraylength
    //   524: aload #19
    //   526: arraylength
    //   527: iadd
    //   528: aload #16
    //   530: arraylength
    //   531: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   534: new com/google/protobuf/MessageSchema
    //   537: dup
    //   538: aload #20
    //   540: aload #21
    //   542: iload #8
    //   544: iload #9
    //   546: aload_0
    //   547: invokevirtual getDefaultInstance : ()Lcom/google/protobuf/MessageLite;
    //   550: iload #15
    //   552: iconst_1
    //   553: aload #17
    //   555: aload #18
    //   557: arraylength
    //   558: aload #18
    //   560: arraylength
    //   561: aload #19
    //   563: arraylength
    //   564: iadd
    //   565: aload_1
    //   566: aload_2
    //   567: aload_3
    //   568: aload #4
    //   570: aload #5
    //   572: invokespecial <init> : ([I[Ljava/lang/Object;IILcom/google/protobuf/MessageLite;ZZ[IIILcom/google/protobuf/NewInstanceSchema;Lcom/google/protobuf/ListFieldSchema;Lcom/google/protobuf/UnknownFieldSchema;Lcom/google/protobuf/ExtensionSchema;Lcom/google/protobuf/MapFieldSchema;)V
    //   575: areturn
  }
  
  static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo paramRawMessageInfo, NewInstanceSchema paramNewInstanceSchema, ListFieldSchema paramListFieldSchema, UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MapFieldSchema paramMapFieldSchema) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getSyntax : ()Lcom/google/protobuf/ProtoSyntax;
    //   4: getstatic com/google/protobuf/ProtoSyntax.PROTO3 : Lcom/google/protobuf/ProtoSyntax;
    //   7: if_acmpne -> 16
    //   10: iconst_1
    //   11: istore #31
    //   13: goto -> 19
    //   16: iconst_0
    //   17: istore #31
    //   19: aload_0
    //   20: invokevirtual getStringInfo : ()Ljava/lang/String;
    //   23: astore #36
    //   25: aload #36
    //   27: invokevirtual length : ()I
    //   30: istore #17
    //   32: aload #36
    //   34: iconst_0
    //   35: invokevirtual charAt : (I)C
    //   38: ldc_w 55296
    //   41: if_icmplt -> 77
    //   44: iconst_1
    //   45: istore #7
    //   47: iload #7
    //   49: iconst_1
    //   50: iadd
    //   51: istore #8
    //   53: iload #8
    //   55: istore #6
    //   57: aload #36
    //   59: iload #7
    //   61: invokevirtual charAt : (I)C
    //   64: ldc_w 55296
    //   67: if_icmplt -> 80
    //   70: iload #8
    //   72: istore #7
    //   74: goto -> 47
    //   77: iconst_1
    //   78: istore #6
    //   80: iload #6
    //   82: iconst_1
    //   83: iadd
    //   84: istore #7
    //   86: aload #36
    //   88: iload #6
    //   90: invokevirtual charAt : (I)C
    //   93: istore #9
    //   95: iload #7
    //   97: istore #6
    //   99: iload #9
    //   101: istore #8
    //   103: iload #9
    //   105: ldc_w 55296
    //   108: if_icmplt -> 192
    //   111: iload #9
    //   113: sipush #8191
    //   116: iand
    //   117: istore #8
    //   119: bipush #13
    //   121: istore #6
    //   123: iload #7
    //   125: istore #9
    //   127: iload #9
    //   129: iconst_1
    //   130: iadd
    //   131: istore #7
    //   133: aload #36
    //   135: iload #9
    //   137: invokevirtual charAt : (I)C
    //   140: istore #9
    //   142: iload #9
    //   144: ldc_w 55296
    //   147: if_icmplt -> 178
    //   150: iload #8
    //   152: iload #9
    //   154: sipush #8191
    //   157: iand
    //   158: iload #6
    //   160: ishl
    //   161: ior
    //   162: istore #8
    //   164: iload #6
    //   166: bipush #13
    //   168: iadd
    //   169: istore #6
    //   171: iload #7
    //   173: istore #9
    //   175: goto -> 127
    //   178: iload #8
    //   180: iload #9
    //   182: iload #6
    //   184: ishl
    //   185: ior
    //   186: istore #8
    //   188: iload #7
    //   190: istore #6
    //   192: iload #8
    //   194: ifne -> 230
    //   197: getstatic com/google/protobuf/MessageSchema.EMPTY_INT_ARRAY : [I
    //   200: astore #33
    //   202: iload #6
    //   204: istore #10
    //   206: iconst_0
    //   207: istore #13
    //   209: iconst_0
    //   210: istore #7
    //   212: iconst_0
    //   213: istore #14
    //   215: iconst_0
    //   216: istore #15
    //   218: iconst_0
    //   219: istore #9
    //   221: iconst_0
    //   222: istore #11
    //   224: iconst_0
    //   225: istore #6
    //   227: goto -> 1150
    //   230: iload #6
    //   232: iconst_1
    //   233: iadd
    //   234: istore #7
    //   236: aload #36
    //   238: iload #6
    //   240: invokevirtual charAt : (I)C
    //   243: istore #9
    //   245: iload #9
    //   247: istore #6
    //   249: iload #7
    //   251: istore #8
    //   253: iload #9
    //   255: ldc_w 55296
    //   258: if_icmplt -> 342
    //   261: iload #9
    //   263: sipush #8191
    //   266: iand
    //   267: istore #8
    //   269: bipush #13
    //   271: istore #6
    //   273: iload #7
    //   275: istore #9
    //   277: iload #9
    //   279: iconst_1
    //   280: iadd
    //   281: istore #7
    //   283: aload #36
    //   285: iload #9
    //   287: invokevirtual charAt : (I)C
    //   290: istore #9
    //   292: iload #9
    //   294: ldc_w 55296
    //   297: if_icmplt -> 328
    //   300: iload #8
    //   302: iload #9
    //   304: sipush #8191
    //   307: iand
    //   308: iload #6
    //   310: ishl
    //   311: ior
    //   312: istore #8
    //   314: iload #6
    //   316: bipush #13
    //   318: iadd
    //   319: istore #6
    //   321: iload #7
    //   323: istore #9
    //   325: goto -> 277
    //   328: iload #8
    //   330: iload #9
    //   332: iload #6
    //   334: ishl
    //   335: ior
    //   336: istore #6
    //   338: iload #7
    //   340: istore #8
    //   342: iload #8
    //   344: iconst_1
    //   345: iadd
    //   346: istore #7
    //   348: aload #36
    //   350: iload #8
    //   352: invokevirtual charAt : (I)C
    //   355: istore #13
    //   357: iload #13
    //   359: ldc_w 55296
    //   362: if_icmplt -> 445
    //   365: iload #13
    //   367: sipush #8191
    //   370: iand
    //   371: istore #9
    //   373: bipush #13
    //   375: istore #8
    //   377: iload #7
    //   379: istore #10
    //   381: iload #10
    //   383: iconst_1
    //   384: iadd
    //   385: istore #7
    //   387: aload #36
    //   389: iload #10
    //   391: invokevirtual charAt : (I)C
    //   394: istore #10
    //   396: iload #10
    //   398: ldc_w 55296
    //   401: if_icmplt -> 432
    //   404: iload #9
    //   406: iload #10
    //   408: sipush #8191
    //   411: iand
    //   412: iload #8
    //   414: ishl
    //   415: ior
    //   416: istore #9
    //   418: iload #8
    //   420: bipush #13
    //   422: iadd
    //   423: istore #8
    //   425: iload #7
    //   427: istore #10
    //   429: goto -> 381
    //   432: iload #9
    //   434: iload #10
    //   436: iload #8
    //   438: ishl
    //   439: ior
    //   440: istore #13
    //   442: goto -> 445
    //   445: iload #7
    //   447: iconst_1
    //   448: iadd
    //   449: istore #8
    //   451: aload #36
    //   453: iload #7
    //   455: invokevirtual charAt : (I)C
    //   458: istore #7
    //   460: iload #7
    //   462: ldc_w 55296
    //   465: if_icmplt -> 548
    //   468: iload #7
    //   470: sipush #8191
    //   473: iand
    //   474: istore #9
    //   476: bipush #13
    //   478: istore #7
    //   480: iload #8
    //   482: istore #10
    //   484: iload #10
    //   486: iconst_1
    //   487: iadd
    //   488: istore #8
    //   490: aload #36
    //   492: iload #10
    //   494: invokevirtual charAt : (I)C
    //   497: istore #10
    //   499: iload #10
    //   501: ldc_w 55296
    //   504: if_icmplt -> 535
    //   507: iload #9
    //   509: iload #10
    //   511: sipush #8191
    //   514: iand
    //   515: iload #7
    //   517: ishl
    //   518: ior
    //   519: istore #9
    //   521: iload #7
    //   523: bipush #13
    //   525: iadd
    //   526: istore #7
    //   528: iload #8
    //   530: istore #10
    //   532: goto -> 484
    //   535: iload #10
    //   537: iload #7
    //   539: ishl
    //   540: iload #9
    //   542: ior
    //   543: istore #7
    //   545: goto -> 548
    //   548: iload #8
    //   550: iconst_1
    //   551: iadd
    //   552: istore #9
    //   554: aload #36
    //   556: iload #8
    //   558: invokevirtual charAt : (I)C
    //   561: istore #8
    //   563: iload #8
    //   565: ldc_w 55296
    //   568: if_icmplt -> 651
    //   571: iload #8
    //   573: sipush #8191
    //   576: iand
    //   577: istore #10
    //   579: bipush #13
    //   581: istore #8
    //   583: iload #9
    //   585: istore #11
    //   587: iload #11
    //   589: iconst_1
    //   590: iadd
    //   591: istore #9
    //   593: aload #36
    //   595: iload #11
    //   597: invokevirtual charAt : (I)C
    //   600: istore #11
    //   602: iload #11
    //   604: ldc_w 55296
    //   607: if_icmplt -> 638
    //   610: iload #10
    //   612: iload #11
    //   614: sipush #8191
    //   617: iand
    //   618: iload #8
    //   620: ishl
    //   621: ior
    //   622: istore #10
    //   624: iload #8
    //   626: bipush #13
    //   628: iadd
    //   629: istore #8
    //   631: iload #9
    //   633: istore #11
    //   635: goto -> 587
    //   638: iload #11
    //   640: iload #8
    //   642: ishl
    //   643: iload #10
    //   645: ior
    //   646: istore #8
    //   648: goto -> 651
    //   651: iload #9
    //   653: iconst_1
    //   654: iadd
    //   655: istore #10
    //   657: aload #36
    //   659: iload #9
    //   661: invokevirtual charAt : (I)C
    //   664: istore #9
    //   666: iload #9
    //   668: ldc_w 55296
    //   671: if_icmplt -> 754
    //   674: iload #9
    //   676: sipush #8191
    //   679: iand
    //   680: istore #11
    //   682: bipush #13
    //   684: istore #9
    //   686: iload #10
    //   688: istore #12
    //   690: iload #12
    //   692: iconst_1
    //   693: iadd
    //   694: istore #10
    //   696: aload #36
    //   698: iload #12
    //   700: invokevirtual charAt : (I)C
    //   703: istore #12
    //   705: iload #12
    //   707: ldc_w 55296
    //   710: if_icmplt -> 741
    //   713: iload #11
    //   715: iload #12
    //   717: sipush #8191
    //   720: iand
    //   721: iload #9
    //   723: ishl
    //   724: ior
    //   725: istore #11
    //   727: iload #9
    //   729: bipush #13
    //   731: iadd
    //   732: istore #9
    //   734: iload #10
    //   736: istore #12
    //   738: goto -> 690
    //   741: iload #12
    //   743: iload #9
    //   745: ishl
    //   746: iload #11
    //   748: ior
    //   749: istore #9
    //   751: goto -> 754
    //   754: iload #10
    //   756: iconst_1
    //   757: iadd
    //   758: istore #11
    //   760: aload #36
    //   762: iload #10
    //   764: invokevirtual charAt : (I)C
    //   767: istore #10
    //   769: iload #10
    //   771: ldc_w 55296
    //   774: if_icmplt -> 861
    //   777: iload #10
    //   779: sipush #8191
    //   782: iand
    //   783: istore #12
    //   785: bipush #13
    //   787: istore #10
    //   789: iload #11
    //   791: istore #14
    //   793: iload #14
    //   795: iconst_1
    //   796: iadd
    //   797: istore #11
    //   799: aload #36
    //   801: iload #14
    //   803: invokevirtual charAt : (I)C
    //   806: istore #14
    //   808: iload #14
    //   810: ldc_w 55296
    //   813: if_icmplt -> 844
    //   816: iload #12
    //   818: iload #14
    //   820: sipush #8191
    //   823: iand
    //   824: iload #10
    //   826: ishl
    //   827: ior
    //   828: istore #12
    //   830: iload #10
    //   832: bipush #13
    //   834: iadd
    //   835: istore #10
    //   837: iload #11
    //   839: istore #14
    //   841: goto -> 793
    //   844: iload #14
    //   846: iload #10
    //   848: ishl
    //   849: iload #12
    //   851: ior
    //   852: istore #10
    //   854: iload #11
    //   856: istore #12
    //   858: goto -> 865
    //   861: iload #11
    //   863: istore #12
    //   865: iload #12
    //   867: iconst_1
    //   868: iadd
    //   869: istore #11
    //   871: aload #36
    //   873: iload #12
    //   875: invokevirtual charAt : (I)C
    //   878: istore #15
    //   880: iload #11
    //   882: istore #12
    //   884: iload #15
    //   886: istore #14
    //   888: iload #15
    //   890: ldc_w 55296
    //   893: if_icmplt -> 977
    //   896: iload #15
    //   898: sipush #8191
    //   901: iand
    //   902: istore #14
    //   904: bipush #13
    //   906: istore #12
    //   908: iload #11
    //   910: istore #15
    //   912: iload #15
    //   914: iconst_1
    //   915: iadd
    //   916: istore #11
    //   918: aload #36
    //   920: iload #15
    //   922: invokevirtual charAt : (I)C
    //   925: istore #15
    //   927: iload #15
    //   929: ldc_w 55296
    //   932: if_icmplt -> 963
    //   935: iload #14
    //   937: iload #15
    //   939: sipush #8191
    //   942: iand
    //   943: iload #12
    //   945: ishl
    //   946: ior
    //   947: istore #14
    //   949: iload #12
    //   951: bipush #13
    //   953: iadd
    //   954: istore #12
    //   956: iload #11
    //   958: istore #15
    //   960: goto -> 912
    //   963: iload #14
    //   965: iload #15
    //   967: iload #12
    //   969: ishl
    //   970: ior
    //   971: istore #14
    //   973: iload #11
    //   975: istore #12
    //   977: iload #12
    //   979: iconst_1
    //   980: iadd
    //   981: istore #15
    //   983: aload #36
    //   985: iload #12
    //   987: invokevirtual charAt : (I)C
    //   990: istore #16
    //   992: iload #16
    //   994: istore #12
    //   996: iload #15
    //   998: istore #11
    //   1000: iload #16
    //   1002: ldc_w 55296
    //   1005: if_icmplt -> 1097
    //   1008: iload #16
    //   1010: sipush #8191
    //   1013: iand
    //   1014: istore #12
    //   1016: bipush #13
    //   1018: istore #11
    //   1020: iload #15
    //   1022: istore #16
    //   1024: iload #12
    //   1026: istore #15
    //   1028: iload #16
    //   1030: iconst_1
    //   1031: iadd
    //   1032: istore #12
    //   1034: aload #36
    //   1036: iload #16
    //   1038: invokevirtual charAt : (I)C
    //   1041: istore #16
    //   1043: iload #16
    //   1045: ldc_w 55296
    //   1048: if_icmplt -> 1079
    //   1051: iload #15
    //   1053: iload #16
    //   1055: sipush #8191
    //   1058: iand
    //   1059: iload #11
    //   1061: ishl
    //   1062: ior
    //   1063: istore #15
    //   1065: iload #11
    //   1067: bipush #13
    //   1069: iadd
    //   1070: istore #11
    //   1072: iload #12
    //   1074: istore #16
    //   1076: goto -> 1028
    //   1079: iload #15
    //   1081: iload #16
    //   1083: iload #11
    //   1085: ishl
    //   1086: ior
    //   1087: istore #15
    //   1089: iload #12
    //   1091: istore #11
    //   1093: iload #15
    //   1095: istore #12
    //   1097: iload #12
    //   1099: iload #10
    //   1101: iadd
    //   1102: iload #14
    //   1104: iadd
    //   1105: newarray int
    //   1107: astore #33
    //   1109: iload #6
    //   1111: iconst_2
    //   1112: imul
    //   1113: iload #13
    //   1115: iadd
    //   1116: istore #16
    //   1118: iload #6
    //   1120: istore #14
    //   1122: iload #10
    //   1124: istore #13
    //   1126: iload #12
    //   1128: istore #6
    //   1130: iload #11
    //   1132: istore #10
    //   1134: iload #9
    //   1136: istore #11
    //   1138: iload #8
    //   1140: istore #9
    //   1142: iload #7
    //   1144: istore #15
    //   1146: iload #16
    //   1148: istore #7
    //   1150: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   1153: astore #37
    //   1155: aload_0
    //   1156: invokevirtual getObjects : ()[Ljava/lang/Object;
    //   1159: astore #38
    //   1161: aload_0
    //   1162: invokevirtual getDefaultInstance : ()Lcom/google/protobuf/MessageLite;
    //   1165: invokevirtual getClass : ()Ljava/lang/Class;
    //   1168: astore #34
    //   1170: iload #11
    //   1172: iconst_3
    //   1173: imul
    //   1174: newarray int
    //   1176: astore #32
    //   1178: iload #11
    //   1180: iconst_2
    //   1181: imul
    //   1182: anewarray java/lang/Object
    //   1185: astore #39
    //   1187: iload #6
    //   1189: iload #13
    //   1191: iadd
    //   1192: istore #28
    //   1194: iload #6
    //   1196: istore #8
    //   1198: iload #28
    //   1200: istore #20
    //   1202: iconst_0
    //   1203: istore #11
    //   1205: iconst_0
    //   1206: istore #19
    //   1208: iload #6
    //   1210: istore #18
    //   1212: iload #9
    //   1214: istore #16
    //   1216: iload #7
    //   1218: istore #6
    //   1220: iload #11
    //   1222: istore #9
    //   1224: iload #10
    //   1226: iload #17
    //   1228: if_icmpge -> 2555
    //   1231: iload #10
    //   1233: iconst_1
    //   1234: iadd
    //   1235: istore #7
    //   1237: aload #36
    //   1239: iload #10
    //   1241: invokevirtual charAt : (I)C
    //   1244: istore #21
    //   1246: iload #21
    //   1248: ldc_w 55296
    //   1251: if_icmplt -> 1338
    //   1254: bipush #13
    //   1256: istore #10
    //   1258: iload #21
    //   1260: sipush #8191
    //   1263: iand
    //   1264: istore #11
    //   1266: iload #7
    //   1268: istore #12
    //   1270: iload #10
    //   1272: istore #7
    //   1274: iload #12
    //   1276: iconst_1
    //   1277: iadd
    //   1278: istore #10
    //   1280: aload #36
    //   1282: iload #12
    //   1284: invokevirtual charAt : (I)C
    //   1287: istore #12
    //   1289: iload #12
    //   1291: ldc_w 55296
    //   1294: if_icmplt -> 1325
    //   1297: iload #11
    //   1299: iload #12
    //   1301: sipush #8191
    //   1304: iand
    //   1305: iload #7
    //   1307: ishl
    //   1308: ior
    //   1309: istore #11
    //   1311: iload #7
    //   1313: bipush #13
    //   1315: iadd
    //   1316: istore #7
    //   1318: iload #10
    //   1320: istore #12
    //   1322: goto -> 1274
    //   1325: iload #11
    //   1327: iload #12
    //   1329: iload #7
    //   1331: ishl
    //   1332: ior
    //   1333: istore #21
    //   1335: goto -> 1342
    //   1338: iload #7
    //   1340: istore #10
    //   1342: iload #10
    //   1344: iconst_1
    //   1345: iadd
    //   1346: istore #7
    //   1348: aload #36
    //   1350: iload #10
    //   1352: invokevirtual charAt : (I)C
    //   1355: istore #22
    //   1357: iload #22
    //   1359: ldc_w 55296
    //   1362: if_icmplt -> 1449
    //   1365: bipush #13
    //   1367: istore #10
    //   1369: iload #22
    //   1371: sipush #8191
    //   1374: iand
    //   1375: istore #11
    //   1377: iload #7
    //   1379: istore #12
    //   1381: iload #10
    //   1383: istore #7
    //   1385: iload #12
    //   1387: iconst_1
    //   1388: iadd
    //   1389: istore #10
    //   1391: aload #36
    //   1393: iload #12
    //   1395: invokevirtual charAt : (I)C
    //   1398: istore #12
    //   1400: iload #12
    //   1402: ldc_w 55296
    //   1405: if_icmplt -> 1436
    //   1408: iload #11
    //   1410: iload #12
    //   1412: sipush #8191
    //   1415: iand
    //   1416: iload #7
    //   1418: ishl
    //   1419: ior
    //   1420: istore #11
    //   1422: iload #7
    //   1424: bipush #13
    //   1426: iadd
    //   1427: istore #7
    //   1429: iload #10
    //   1431: istore #12
    //   1433: goto -> 1385
    //   1436: iload #11
    //   1438: iload #12
    //   1440: iload #7
    //   1442: ishl
    //   1443: ior
    //   1444: istore #22
    //   1446: goto -> 1453
    //   1449: iload #7
    //   1451: istore #10
    //   1453: iload #22
    //   1455: sipush #255
    //   1458: iand
    //   1459: istore #30
    //   1461: iload #9
    //   1463: istore #7
    //   1465: iload #22
    //   1467: sipush #1024
    //   1470: iand
    //   1471: ifeq -> 1487
    //   1474: aload #33
    //   1476: iload #9
    //   1478: iload #19
    //   1480: iastore
    //   1481: iload #9
    //   1483: iconst_1
    //   1484: iadd
    //   1485: istore #7
    //   1487: iload #30
    //   1489: bipush #51
    //   1491: if_icmplt -> 1858
    //   1494: iload #10
    //   1496: iconst_1
    //   1497: iadd
    //   1498: istore #11
    //   1500: aload #36
    //   1502: iload #10
    //   1504: invokevirtual charAt : (I)C
    //   1507: istore #12
    //   1509: iload #12
    //   1511: istore #10
    //   1513: iload #11
    //   1515: istore #9
    //   1517: iload #12
    //   1519: ldc_w 55296
    //   1522: if_icmplt -> 1614
    //   1525: iload #12
    //   1527: sipush #8191
    //   1530: iand
    //   1531: istore #10
    //   1533: bipush #13
    //   1535: istore #9
    //   1537: iload #11
    //   1539: istore #12
    //   1541: iload #10
    //   1543: istore #11
    //   1545: iload #12
    //   1547: iconst_1
    //   1548: iadd
    //   1549: istore #10
    //   1551: aload #36
    //   1553: iload #12
    //   1555: invokevirtual charAt : (I)C
    //   1558: istore #12
    //   1560: iload #12
    //   1562: ldc_w 55296
    //   1565: if_icmplt -> 1596
    //   1568: iload #11
    //   1570: iload #12
    //   1572: sipush #8191
    //   1575: iand
    //   1576: iload #9
    //   1578: ishl
    //   1579: ior
    //   1580: istore #11
    //   1582: iload #9
    //   1584: bipush #13
    //   1586: iadd
    //   1587: istore #9
    //   1589: iload #10
    //   1591: istore #12
    //   1593: goto -> 1545
    //   1596: iload #11
    //   1598: iload #12
    //   1600: iload #9
    //   1602: ishl
    //   1603: ior
    //   1604: istore #11
    //   1606: iload #10
    //   1608: istore #9
    //   1610: iload #11
    //   1612: istore #10
    //   1614: iload #30
    //   1616: bipush #51
    //   1618: isub
    //   1619: istore #11
    //   1621: iload #11
    //   1623: bipush #9
    //   1625: if_icmpeq -> 1686
    //   1628: iload #11
    //   1630: bipush #17
    //   1632: if_icmpne -> 1638
    //   1635: goto -> 1686
    //   1638: iload #11
    //   1640: bipush #12
    //   1642: if_icmpne -> 1683
    //   1645: iload #31
    //   1647: ifne -> 1683
    //   1650: iload #19
    //   1652: iconst_3
    //   1653: idiv
    //   1654: istore #12
    //   1656: iload #6
    //   1658: iconst_1
    //   1659: iadd
    //   1660: istore #11
    //   1662: aload #39
    //   1664: iload #12
    //   1666: iconst_2
    //   1667: imul
    //   1668: iconst_1
    //   1669: iadd
    //   1670: aload #38
    //   1672: iload #6
    //   1674: aaload
    //   1675: aastore
    //   1676: iload #11
    //   1678: istore #6
    //   1680: goto -> 1716
    //   1683: goto -> 1716
    //   1686: iload #19
    //   1688: iconst_3
    //   1689: idiv
    //   1690: istore #12
    //   1692: iload #6
    //   1694: iconst_1
    //   1695: iadd
    //   1696: istore #11
    //   1698: aload #39
    //   1700: iload #12
    //   1702: iconst_2
    //   1703: imul
    //   1704: iconst_1
    //   1705: iadd
    //   1706: aload #38
    //   1708: iload #6
    //   1710: aaload
    //   1711: aastore
    //   1712: iload #11
    //   1714: istore #6
    //   1716: iload #10
    //   1718: iconst_2
    //   1719: imul
    //   1720: istore #10
    //   1722: aload #38
    //   1724: iload #10
    //   1726: aaload
    //   1727: astore #35
    //   1729: aload #35
    //   1731: instanceof java/lang/reflect/Field
    //   1734: ifeq -> 1747
    //   1737: aload #35
    //   1739: checkcast java/lang/reflect/Field
    //   1742: astore #35
    //   1744: goto -> 1766
    //   1747: aload #34
    //   1749: aload #35
    //   1751: checkcast java/lang/String
    //   1754: invokestatic reflectField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1757: astore #35
    //   1759: aload #38
    //   1761: iload #10
    //   1763: aload #35
    //   1765: aastore
    //   1766: aload #37
    //   1768: aload #35
    //   1770: invokevirtual objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   1773: l2i
    //   1774: istore #26
    //   1776: iload #10
    //   1778: iconst_1
    //   1779: iadd
    //   1780: istore #10
    //   1782: aload #38
    //   1784: iload #10
    //   1786: aaload
    //   1787: astore #35
    //   1789: aload #35
    //   1791: instanceof java/lang/reflect/Field
    //   1794: ifeq -> 1807
    //   1797: aload #35
    //   1799: checkcast java/lang/reflect/Field
    //   1802: astore #35
    //   1804: goto -> 1826
    //   1807: aload #34
    //   1809: aload #35
    //   1811: checkcast java/lang/String
    //   1814: invokestatic reflectField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1817: astore #35
    //   1819: aload #38
    //   1821: iload #10
    //   1823: aload #35
    //   1825: aastore
    //   1826: aload #37
    //   1828: aload #35
    //   1830: invokevirtual objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   1833: l2i
    //   1834: istore #27
    //   1836: iload #9
    //   1838: istore #10
    //   1840: iconst_0
    //   1841: istore #25
    //   1843: iload #8
    //   1845: istore #24
    //   1847: iload #20
    //   1849: istore #23
    //   1851: iload #6
    //   1853: istore #9
    //   1855: goto -> 2441
    //   1858: iload #6
    //   1860: iconst_1
    //   1861: iadd
    //   1862: istore #9
    //   1864: aload #34
    //   1866: aload #38
    //   1868: iload #6
    //   1870: aaload
    //   1871: checkcast java/lang/String
    //   1874: invokestatic reflectField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1877: astore #35
    //   1879: iload #30
    //   1881: bipush #9
    //   1883: if_icmpeq -> 2081
    //   1886: iload #30
    //   1888: bipush #17
    //   1890: if_icmpne -> 1896
    //   1893: goto -> 2081
    //   1896: iload #30
    //   1898: bipush #27
    //   1900: if_icmpeq -> 2052
    //   1903: iload #30
    //   1905: bipush #49
    //   1907: if_icmpne -> 1913
    //   1910: goto -> 2052
    //   1913: iload #30
    //   1915: bipush #12
    //   1917: if_icmpeq -> 2015
    //   1920: iload #30
    //   1922: bipush #30
    //   1924: if_icmpeq -> 2015
    //   1927: iload #30
    //   1929: bipush #44
    //   1931: if_icmpne -> 1937
    //   1934: goto -> 2015
    //   1937: iload #30
    //   1939: bipush #50
    //   1941: if_icmpne -> 2049
    //   1944: aload #33
    //   1946: iload #8
    //   1948: iload #19
    //   1950: iastore
    //   1951: iload #19
    //   1953: iconst_3
    //   1954: idiv
    //   1955: iconst_2
    //   1956: imul
    //   1957: istore #12
    //   1959: iload #9
    //   1961: iconst_1
    //   1962: iadd
    //   1963: istore #11
    //   1965: aload #39
    //   1967: iload #12
    //   1969: aload #38
    //   1971: iload #9
    //   1973: aaload
    //   1974: aastore
    //   1975: iload #11
    //   1977: istore #6
    //   1979: iload #22
    //   1981: sipush #2048
    //   1984: iand
    //   1985: ifeq -> 2006
    //   1988: aload #39
    //   1990: iload #12
    //   1992: iconst_1
    //   1993: iadd
    //   1994: aload #38
    //   1996: iload #11
    //   1998: aaload
    //   1999: aastore
    //   2000: iload #11
    //   2002: iconst_1
    //   2003: iadd
    //   2004: istore #6
    //   2006: iload #8
    //   2008: iconst_1
    //   2009: iadd
    //   2010: istore #8
    //   2012: goto -> 2101
    //   2015: iload #31
    //   2017: ifne -> 2049
    //   2020: iload #19
    //   2022: iconst_3
    //   2023: idiv
    //   2024: istore #11
    //   2026: iload #9
    //   2028: iconst_1
    //   2029: iadd
    //   2030: istore #6
    //   2032: aload #39
    //   2034: iload #11
    //   2036: iconst_2
    //   2037: imul
    //   2038: iconst_1
    //   2039: iadd
    //   2040: aload #38
    //   2042: iload #9
    //   2044: aaload
    //   2045: aastore
    //   2046: goto -> 2101
    //   2049: goto -> 2097
    //   2052: iload #19
    //   2054: iconst_3
    //   2055: idiv
    //   2056: istore #11
    //   2058: iload #9
    //   2060: iconst_1
    //   2061: iadd
    //   2062: istore #6
    //   2064: aload #39
    //   2066: iload #11
    //   2068: iconst_2
    //   2069: imul
    //   2070: iconst_1
    //   2071: iadd
    //   2072: aload #38
    //   2074: iload #9
    //   2076: aaload
    //   2077: aastore
    //   2078: goto -> 2101
    //   2081: aload #39
    //   2083: iload #19
    //   2085: iconst_3
    //   2086: idiv
    //   2087: iconst_2
    //   2088: imul
    //   2089: iconst_1
    //   2090: iadd
    //   2091: aload #35
    //   2093: invokevirtual getType : ()Ljava/lang/Class;
    //   2096: aastore
    //   2097: iload #9
    //   2099: istore #6
    //   2101: aload #37
    //   2103: aload #35
    //   2105: invokevirtual objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   2108: l2i
    //   2109: istore #29
    //   2111: iload #22
    //   2113: sipush #4096
    //   2116: iand
    //   2117: sipush #4096
    //   2120: if_icmpne -> 2129
    //   2123: iconst_1
    //   2124: istore #9
    //   2126: goto -> 2132
    //   2129: iconst_0
    //   2130: istore #9
    //   2132: iload #9
    //   2134: ifeq -> 2323
    //   2137: iload #30
    //   2139: bipush #17
    //   2141: if_icmpgt -> 2323
    //   2144: iload #10
    //   2146: iconst_1
    //   2147: iadd
    //   2148: istore #11
    //   2150: aload #36
    //   2152: iload #10
    //   2154: invokevirtual charAt : (I)C
    //   2157: istore #9
    //   2159: iload #9
    //   2161: ldc_w 55296
    //   2164: if_icmplt -> 2243
    //   2167: iload #9
    //   2169: sipush #8191
    //   2172: iand
    //   2173: istore #10
    //   2175: bipush #13
    //   2177: istore #9
    //   2179: iload #11
    //   2181: iconst_1
    //   2182: iadd
    //   2183: istore #13
    //   2185: aload #36
    //   2187: iload #11
    //   2189: invokevirtual charAt : (I)C
    //   2192: istore #11
    //   2194: iload #11
    //   2196: ldc_w 55296
    //   2199: if_icmplt -> 2230
    //   2202: iload #10
    //   2204: iload #11
    //   2206: sipush #8191
    //   2209: iand
    //   2210: iload #9
    //   2212: ishl
    //   2213: ior
    //   2214: istore #10
    //   2216: iload #9
    //   2218: bipush #13
    //   2220: iadd
    //   2221: istore #9
    //   2223: iload #13
    //   2225: istore #11
    //   2227: goto -> 2179
    //   2230: iload #10
    //   2232: iload #11
    //   2234: iload #9
    //   2236: ishl
    //   2237: ior
    //   2238: istore #9
    //   2240: goto -> 2247
    //   2243: iload #11
    //   2245: istore #13
    //   2247: iload #14
    //   2249: iconst_2
    //   2250: imul
    //   2251: iload #9
    //   2253: bipush #32
    //   2255: idiv
    //   2256: iadd
    //   2257: istore #10
    //   2259: aload #38
    //   2261: iload #10
    //   2263: aaload
    //   2264: astore #35
    //   2266: aload #35
    //   2268: instanceof java/lang/reflect/Field
    //   2271: ifeq -> 2284
    //   2274: aload #35
    //   2276: checkcast java/lang/reflect/Field
    //   2279: astore #35
    //   2281: goto -> 2303
    //   2284: aload #34
    //   2286: aload #35
    //   2288: checkcast java/lang/String
    //   2291: invokestatic reflectField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   2294: astore #35
    //   2296: aload #38
    //   2298: iload #10
    //   2300: aload #35
    //   2302: aastore
    //   2303: aload #37
    //   2305: aload #35
    //   2307: invokevirtual objectFieldOffset : (Ljava/lang/reflect/Field;)J
    //   2310: l2i
    //   2311: istore #12
    //   2313: iload #9
    //   2315: bipush #32
    //   2317: irem
    //   2318: istore #11
    //   2320: goto -> 2334
    //   2323: ldc 1048575
    //   2325: istore #12
    //   2327: iconst_0
    //   2328: istore #11
    //   2330: iload #10
    //   2332: istore #13
    //   2334: iload #11
    //   2336: istore #25
    //   2338: iload #29
    //   2340: istore #26
    //   2342: iload #12
    //   2344: istore #27
    //   2346: iload #8
    //   2348: istore #24
    //   2350: iload #20
    //   2352: istore #23
    //   2354: iload #6
    //   2356: istore #9
    //   2358: iload #13
    //   2360: istore #10
    //   2362: iload #30
    //   2364: bipush #18
    //   2366: if_icmplt -> 2441
    //   2369: iload #11
    //   2371: istore #25
    //   2373: iload #29
    //   2375: istore #26
    //   2377: iload #12
    //   2379: istore #27
    //   2381: iload #8
    //   2383: istore #24
    //   2385: iload #20
    //   2387: istore #23
    //   2389: iload #6
    //   2391: istore #9
    //   2393: iload #13
    //   2395: istore #10
    //   2397: iload #30
    //   2399: bipush #49
    //   2401: if_icmpgt -> 2441
    //   2404: aload #33
    //   2406: iload #20
    //   2408: iload #29
    //   2410: iastore
    //   2411: iload #20
    //   2413: iconst_1
    //   2414: iadd
    //   2415: istore #23
    //   2417: iload #13
    //   2419: istore #10
    //   2421: iload #6
    //   2423: istore #9
    //   2425: iload #8
    //   2427: istore #24
    //   2429: iload #12
    //   2431: istore #27
    //   2433: iload #29
    //   2435: istore #26
    //   2437: iload #11
    //   2439: istore #25
    //   2441: iload #19
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore #11
    //   2447: aload #32
    //   2449: iload #19
    //   2451: iload #21
    //   2453: iastore
    //   2454: iload #11
    //   2456: iconst_1
    //   2457: iadd
    //   2458: istore #12
    //   2460: iload #22
    //   2462: sipush #512
    //   2465: iand
    //   2466: ifeq -> 2476
    //   2469: ldc 536870912
    //   2471: istore #6
    //   2473: goto -> 2479
    //   2476: iconst_0
    //   2477: istore #6
    //   2479: iload #22
    //   2481: sipush #256
    //   2484: iand
    //   2485: ifeq -> 2495
    //   2488: ldc 268435456
    //   2490: istore #8
    //   2492: goto -> 2498
    //   2495: iconst_0
    //   2496: istore #8
    //   2498: aload #32
    //   2500: iload #11
    //   2502: iload #26
    //   2504: iload #8
    //   2506: iload #6
    //   2508: ior
    //   2509: iload #30
    //   2511: bipush #20
    //   2513: ishl
    //   2514: ior
    //   2515: ior
    //   2516: iastore
    //   2517: iload #12
    //   2519: iconst_1
    //   2520: iadd
    //   2521: istore #19
    //   2523: aload #32
    //   2525: iload #12
    //   2527: iload #25
    //   2529: bipush #20
    //   2531: ishl
    //   2532: iload #27
    //   2534: ior
    //   2535: iastore
    //   2536: iload #9
    //   2538: istore #6
    //   2540: iload #7
    //   2542: istore #9
    //   2544: iload #24
    //   2546: istore #8
    //   2548: iload #23
    //   2550: istore #20
    //   2552: goto -> 1224
    //   2555: new com/google/protobuf/MessageSchema
    //   2558: dup
    //   2559: aload #32
    //   2561: aload #39
    //   2563: iload #15
    //   2565: iload #16
    //   2567: aload_0
    //   2568: invokevirtual getDefaultInstance : ()Lcom/google/protobuf/MessageLite;
    //   2571: iload #31
    //   2573: iconst_0
    //   2574: aload #33
    //   2576: iload #18
    //   2578: iload #28
    //   2580: aload_1
    //   2581: aload_2
    //   2582: aload_3
    //   2583: aload #4
    //   2585: aload #5
    //   2587: invokespecial <init> : ([I[Ljava/lang/Object;IILcom/google/protobuf/MessageLite;ZZ[IIILcom/google/protobuf/NewInstanceSchema;Lcom/google/protobuf/ListFieldSchema;Lcom/google/protobuf/UnknownFieldSchema;Lcom/google/protobuf/ExtensionSchema;Lcom/google/protobuf/MapFieldSchema;)V
    //   2590: areturn
  }
  
  private int numberAt(int paramInt) {
    return this.buffer[paramInt];
  }
  
  private static long offset(int paramInt) {
    return (paramInt & 0xFFFFF);
  }
  
  private static <T> boolean oneofBooleanAt(T paramT, long paramLong) {
    return ((Boolean)UnsafeUtil.getObject(paramT, paramLong)).booleanValue();
  }
  
  private static <T> double oneofDoubleAt(T paramT, long paramLong) {
    return ((Double)UnsafeUtil.getObject(paramT, paramLong)).doubleValue();
  }
  
  private static <T> float oneofFloatAt(T paramT, long paramLong) {
    return ((Float)UnsafeUtil.getObject(paramT, paramLong)).floatValue();
  }
  
  private static <T> int oneofIntAt(T paramT, long paramLong) {
    return ((Integer)UnsafeUtil.getObject(paramT, paramLong)).intValue();
  }
  
  private static <T> long oneofLongAt(T paramT, long paramLong) {
    return ((Long)UnsafeUtil.getObject(paramT, paramLong)).longValue();
  }
  
  private <K, V> int parseMapField(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong, ArrayDecoders.Registers paramRegisters) throws IOException {
    Unsafe unsafe = UNSAFE;
    Object object3 = getMapFieldDefaultEntry(paramInt3);
    Object object2 = unsafe.getObject(paramT, paramLong);
    Object object1 = object2;
    if (this.mapFieldSchema.isImmutable(object2)) {
      object1 = this.mapFieldSchema.newMapField(object3);
      this.mapFieldSchema.mergeFrom(object1, object2);
      unsafe.putObject(paramT, paramLong, object1);
    } 
    return decodeMapEntry(paramArrayOfbyte, paramInt1, paramInt2, this.mapFieldSchema.forMapMetadata(object3), this.mapFieldSchema.forMutableMapData(object1), paramRegisters);
  }
  
  private int parseOneofField(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong, int paramInt8, ArrayDecoders.Registers paramRegisters) throws IOException {
    Object object;
    Unsafe unsafe = UNSAFE;
    long l = (this.buffer[paramInt8 + 2] & 0xFFFFF);
    switch (paramInt7) {
      default:
        return paramInt1;
      case 68:
        if (paramInt5 == 3) {
          paramInt1 = ArrayDecoders.decodeGroupField(getMessageFieldSchema(paramInt8), paramArrayOfbyte, paramInt1, paramInt2, paramInt3 & 0xFFFFFFF8 | 0x4, paramRegisters);
          if (unsafe.getInt(paramT, l) == paramInt4) {
            object = unsafe.getObject(paramT, paramLong);
          } else {
            paramArrayOfbyte = null;
          } 
          if (paramArrayOfbyte == null) {
            unsafe.putObject(paramT, paramLong, paramRegisters.object1);
          } else {
            unsafe.putObject(paramT, paramLong, Internal.mergeMessage(paramArrayOfbyte, paramRegisters.object1));
          } 
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 67:
        if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint64(paramArrayOfbyte, paramInt1, paramRegisters);
          unsafe.putObject(paramT, paramLong, Long.valueOf(CodedInputStream.decodeZigZag64(paramRegisters.long1)));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 66:
        if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
          unsafe.putObject(paramT, paramLong, Integer.valueOf(CodedInputStream.decodeZigZag32(paramRegisters.int1)));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 63:
        if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
          paramInt2 = paramRegisters.int1;
          object = getEnumFieldVerifier(paramInt8);
          if (object == null || object.isInRange(paramInt2)) {
            unsafe.putObject(paramT, paramLong, Integer.valueOf(paramInt2));
            unsafe.putInt(paramT, l, paramInt4);
            return paramInt1;
          } 
          getMutableUnknownFields(paramT).storeField(paramInt3, Long.valueOf(paramInt2));
          return paramInt1;
        } 
      case 61:
        if (paramInt5 == 2) {
          paramInt1 = ArrayDecoders.decodeBytes((byte[])object, paramInt1, paramRegisters);
          unsafe.putObject(paramT, paramLong, paramRegisters.object1);
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 60:
        if (paramInt5 == 2) {
          paramInt1 = ArrayDecoders.decodeMessageField(getMessageFieldSchema(paramInt8), (byte[])object, paramInt1, paramInt2, paramRegisters);
          if (unsafe.getInt(paramT, l) == paramInt4) {
            object = unsafe.getObject(paramT, paramLong);
          } else {
            object = null;
          } 
          if (object == null) {
            unsafe.putObject(paramT, paramLong, paramRegisters.object1);
          } else {
            unsafe.putObject(paramT, paramLong, Internal.mergeMessage(object, paramRegisters.object1));
          } 
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 59:
        if (paramInt5 == 2) {
          paramInt1 = ArrayDecoders.decodeVarint32((byte[])object, paramInt1, paramRegisters);
          paramInt2 = paramRegisters.int1;
          if (paramInt2 == 0) {
            unsafe.putObject(paramT, paramLong, "");
          } else {
            if ((paramInt6 & 0x20000000) == 0 || Utf8.isValidUtf8((byte[])object, paramInt1, paramInt1 + paramInt2)) {
              unsafe.putObject(paramT, paramLong, new String((byte[])object, paramInt1, paramInt2, Internal.UTF_8));
              paramInt1 += paramInt2;
              unsafe.putInt(paramT, l, paramInt4);
              return paramInt1;
            } 
            throw InvalidProtocolBufferException.invalidUtf8();
          } 
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 58:
        if (paramInt5 == 0) {
          boolean bool;
          paramInt1 = ArrayDecoders.decodeVarint64((byte[])object, paramInt1, paramRegisters);
          if (paramRegisters.long1 != 0L) {
            bool = true;
          } else {
            bool = false;
          } 
          unsafe.putObject(paramT, paramLong, Boolean.valueOf(bool));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 57:
      case 64:
        if (paramInt5 == 5) {
          unsafe.putObject(paramT, paramLong, Integer.valueOf(ArrayDecoders.decodeFixed32((byte[])object, paramInt1)));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1 + 4;
        } 
      case 56:
      case 65:
        if (paramInt5 == 1) {
          unsafe.putObject(paramT, paramLong, Long.valueOf(ArrayDecoders.decodeFixed64((byte[])object, paramInt1)));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1 + 8;
        } 
      case 55:
      case 62:
        if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint32((byte[])object, paramInt1, paramRegisters);
          unsafe.putObject(paramT, paramLong, Integer.valueOf(paramRegisters.int1));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 53:
      case 54:
        if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint64((byte[])object, paramInt1, paramRegisters);
          unsafe.putObject(paramT, paramLong, Long.valueOf(paramRegisters.long1));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1;
        } 
      case 52:
        if (paramInt5 == 5) {
          unsafe.putObject(paramT, paramLong, Float.valueOf(ArrayDecoders.decodeFloat((byte[])object, paramInt1)));
          unsafe.putInt(paramT, l, paramInt4);
          return paramInt1 + 4;
        } 
      case 51:
        break;
    } 
    if (paramInt5 == 1) {
      unsafe.putObject(paramT, paramLong, Double.valueOf(ArrayDecoders.decodeDouble((byte[])object, paramInt1)));
      unsafe.putInt(paramT, l, paramInt4);
      return paramInt1 + 8;
    } 
  }
  
  private int parseProto3Message(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters) throws IOException {
    // Byte code:
    //   0: iload #4
    //   2: istore #9
    //   4: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   7: astore #20
    //   9: iload_3
    //   10: istore #8
    //   12: iconst_m1
    //   13: istore #6
    //   15: iconst_0
    //   16: istore #10
    //   18: iconst_0
    //   19: istore_3
    //   20: ldc 1048575
    //   22: istore #7
    //   24: aload_0
    //   25: astore #23
    //   27: aload_1
    //   28: astore #22
    //   30: aload_2
    //   31: astore #24
    //   33: aload #5
    //   35: astore #21
    //   37: iload #8
    //   39: iload #9
    //   41: if_icmpge -> 1264
    //   44: iload #8
    //   46: iconst_1
    //   47: iadd
    //   48: istore #9
    //   50: aload #24
    //   52: iload #8
    //   54: baload
    //   55: istore #11
    //   57: iload #11
    //   59: ifge -> 85
    //   62: iload #11
    //   64: aload #24
    //   66: iload #9
    //   68: aload #21
    //   70: invokestatic decodeVarint32 : (I[BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   73: istore #8
    //   75: aload #21
    //   77: getfield int1 : I
    //   80: istore #11
    //   82: goto -> 89
    //   85: iload #9
    //   87: istore #8
    //   89: iload #11
    //   91: iconst_3
    //   92: iushr
    //   93: istore #9
    //   95: iload #11
    //   97: bipush #7
    //   99: iand
    //   100: istore #14
    //   102: iload #9
    //   104: iload #6
    //   106: if_icmple -> 125
    //   109: aload #23
    //   111: iload #9
    //   113: iload #10
    //   115: iconst_3
    //   116: idiv
    //   117: invokespecial positionForFieldNumber : (II)I
    //   120: istore #6
    //   122: goto -> 134
    //   125: aload #23
    //   127: iload #9
    //   129: invokespecial positionForFieldNumber : (I)I
    //   132: istore #6
    //   134: iload #6
    //   136: iconst_m1
    //   137: if_icmpne -> 146
    //   140: iconst_0
    //   141: istore #6
    //   143: goto -> 1231
    //   146: aload #23
    //   148: getfield buffer : [I
    //   151: iload #6
    //   153: iconst_1
    //   154: iadd
    //   155: iaload
    //   156: istore #15
    //   158: iload #15
    //   160: invokestatic type : (I)I
    //   163: istore #16
    //   165: iload #15
    //   167: invokestatic offset : (I)J
    //   170: lstore #17
    //   172: iload #16
    //   174: bipush #17
    //   176: if_icmpgt -> 921
    //   179: aload #23
    //   181: getfield buffer : [I
    //   184: iload #6
    //   186: iconst_2
    //   187: iadd
    //   188: iaload
    //   189: istore #10
    //   191: iconst_1
    //   192: istore #19
    //   194: iconst_1
    //   195: iload #10
    //   197: bipush #20
    //   199: iushr
    //   200: ishl
    //   201: istore #12
    //   203: iload #10
    //   205: ldc 1048575
    //   207: iand
    //   208: istore #10
    //   210: iload #10
    //   212: iload #7
    //   214: if_icmpeq -> 266
    //   217: iload #7
    //   219: ldc 1048575
    //   221: if_icmpeq -> 238
    //   224: aload #20
    //   226: aload #22
    //   228: iload #7
    //   230: i2l
    //   231: iload_3
    //   232: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   235: goto -> 238
    //   238: iload #10
    //   240: ldc 1048575
    //   242: if_icmpeq -> 256
    //   245: aload #20
    //   247: aload #22
    //   249: iload #10
    //   251: i2l
    //   252: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   255: istore_3
    //   256: iload #10
    //   258: istore #7
    //   260: iload_3
    //   261: istore #10
    //   263: goto -> 269
    //   266: iload_3
    //   267: istore #10
    //   269: iload #16
    //   271: tableswitch default -> 352, 0 -> 873, 1 -> 845, 2 -> 797, 3 -> 797, 4 -> 765, 5 -> 735, 6 -> 672, 7 -> 629, 8 -> 575, 9 -> 492, 10 -> 459, 11 -> 765, 12 -> 427, 13 -> 672, 14 -> 735, 15 -> 392, 16 -> 355
    //   352: goto -> 915
    //   355: iload #14
    //   357: ifne -> 389
    //   360: aload #24
    //   362: iload #8
    //   364: aload #21
    //   366: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   369: istore_3
    //   370: aload #20
    //   372: aload_1
    //   373: lload #17
    //   375: aload #21
    //   377: getfield long1 : J
    //   380: invokestatic decodeZigZag64 : (J)J
    //   383: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   386: goto -> 825
    //   389: goto -> 572
    //   392: iload #14
    //   394: ifne -> 572
    //   397: aload #24
    //   399: iload #8
    //   401: aload #21
    //   403: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   406: istore_3
    //   407: aload #20
    //   409: aload #22
    //   411: lload #17
    //   413: aload #21
    //   415: getfield int1 : I
    //   418: invokestatic decodeZigZag32 : (I)I
    //   421: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   424: goto -> 899
    //   427: iload #14
    //   429: ifne -> 572
    //   432: aload #24
    //   434: iload #8
    //   436: aload #21
    //   438: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   441: istore_3
    //   442: aload #20
    //   444: aload #22
    //   446: lload #17
    //   448: aload #21
    //   450: getfield int1 : I
    //   453: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   456: goto -> 899
    //   459: iload #14
    //   461: iconst_2
    //   462: if_icmpne -> 572
    //   465: aload #24
    //   467: iload #8
    //   469: aload #21
    //   471: invokestatic decodeBytes : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   474: istore_3
    //   475: aload #20
    //   477: aload #22
    //   479: lload #17
    //   481: aload #21
    //   483: getfield object1 : Ljava/lang/Object;
    //   486: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   489: goto -> 899
    //   492: iload #14
    //   494: iconst_2
    //   495: if_icmpne -> 572
    //   498: aload #23
    //   500: iload #6
    //   502: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   505: aload #24
    //   507: iload #8
    //   509: iload #4
    //   511: aload #21
    //   513: invokestatic decodeMessageField : (Lcom/google/protobuf/Schema;[BIILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   516: istore_3
    //   517: aload #20
    //   519: aload #22
    //   521: lload #17
    //   523: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   526: astore #23
    //   528: aload #23
    //   530: ifnonnull -> 550
    //   533: aload #20
    //   535: aload #22
    //   537: lload #17
    //   539: aload #21
    //   541: getfield object1 : Ljava/lang/Object;
    //   544: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   547: goto -> 699
    //   550: aload #20
    //   552: aload #22
    //   554: lload #17
    //   556: aload #23
    //   558: aload #21
    //   560: getfield object1 : Ljava/lang/Object;
    //   563: invokestatic mergeMessage : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   566: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   569: goto -> 699
    //   572: goto -> 915
    //   575: iload #14
    //   577: iconst_2
    //   578: if_icmpne -> 915
    //   581: iload #15
    //   583: ldc 536870912
    //   585: iand
    //   586: ifne -> 602
    //   589: aload #24
    //   591: iload #8
    //   593: aload #21
    //   595: invokestatic decodeString : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   598: istore_3
    //   599: goto -> 612
    //   602: aload #24
    //   604: iload #8
    //   606: aload #21
    //   608: invokestatic decodeStringRequireUtf8 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   611: istore_3
    //   612: aload #20
    //   614: aload #22
    //   616: lload #17
    //   618: aload #21
    //   620: getfield object1 : Ljava/lang/Object;
    //   623: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   626: goto -> 699
    //   629: iload #14
    //   631: ifne -> 915
    //   634: aload #24
    //   636: iload #8
    //   638: aload #21
    //   640: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   643: istore_3
    //   644: aload #21
    //   646: getfield long1 : J
    //   649: lconst_0
    //   650: lcmp
    //   651: ifeq -> 657
    //   654: goto -> 660
    //   657: iconst_0
    //   658: istore #19
    //   660: aload #22
    //   662: lload #17
    //   664: iload #19
    //   666: invokestatic putBoolean : (Ljava/lang/Object;JZ)V
    //   669: goto -> 699
    //   672: iload #14
    //   674: iconst_5
    //   675: if_icmpne -> 915
    //   678: aload #20
    //   680: aload #22
    //   682: lload #17
    //   684: aload #24
    //   686: iload #8
    //   688: invokestatic decodeFixed32 : ([BI)I
    //   691: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   694: iload #8
    //   696: iconst_4
    //   697: iadd
    //   698: istore_3
    //   699: iload #10
    //   701: iload #12
    //   703: ior
    //   704: istore #12
    //   706: iload #9
    //   708: istore #10
    //   710: iload #4
    //   712: istore #9
    //   714: iload #6
    //   716: istore #11
    //   718: iload_3
    //   719: istore #8
    //   721: iload #10
    //   723: istore #6
    //   725: iload #11
    //   727: istore #10
    //   729: iload #12
    //   731: istore_3
    //   732: goto -> 24
    //   735: iload #14
    //   737: iconst_1
    //   738: if_icmpne -> 915
    //   741: aload #20
    //   743: aload_1
    //   744: lload #17
    //   746: aload #24
    //   748: iload #8
    //   750: invokestatic decodeFixed64 : ([BI)J
    //   753: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   756: iload #8
    //   758: bipush #8
    //   760: iadd
    //   761: istore_3
    //   762: goto -> 899
    //   765: iload #14
    //   767: ifne -> 915
    //   770: aload #24
    //   772: iload #8
    //   774: aload #21
    //   776: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   779: istore_3
    //   780: aload #20
    //   782: aload #22
    //   784: lload #17
    //   786: aload #21
    //   788: getfield int1 : I
    //   791: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   794: goto -> 899
    //   797: iload #14
    //   799: ifne -> 915
    //   802: aload #24
    //   804: iload #8
    //   806: aload #21
    //   808: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   811: istore_3
    //   812: aload #20
    //   814: aload_1
    //   815: lload #17
    //   817: aload #21
    //   819: getfield long1 : J
    //   822: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   825: iload #10
    //   827: iload #12
    //   829: ior
    //   830: istore #11
    //   832: iload_3
    //   833: istore #8
    //   835: iload #6
    //   837: istore #10
    //   839: iload #11
    //   841: istore_3
    //   842: goto -> 1054
    //   845: iload #14
    //   847: iconst_5
    //   848: if_icmpne -> 915
    //   851: aload #22
    //   853: lload #17
    //   855: aload #24
    //   857: iload #8
    //   859: invokestatic decodeFloat : ([BI)F
    //   862: invokestatic putFloat : (Ljava/lang/Object;JF)V
    //   865: iload #8
    //   867: iconst_4
    //   868: iadd
    //   869: istore_3
    //   870: goto -> 899
    //   873: iload #14
    //   875: iconst_1
    //   876: if_icmpne -> 915
    //   879: aload #22
    //   881: lload #17
    //   883: aload #24
    //   885: iload #8
    //   887: invokestatic decodeDouble : ([BI)D
    //   890: invokestatic putDouble : (Ljava/lang/Object;JD)V
    //   893: iload #8
    //   895: bipush #8
    //   897: iadd
    //   898: istore_3
    //   899: iload #10
    //   901: iload #12
    //   903: ior
    //   904: istore #10
    //   906: iload_3
    //   907: istore #8
    //   909: iload #10
    //   911: istore_3
    //   912: goto -> 1050
    //   915: iload #10
    //   917: istore_3
    //   918: goto -> 1231
    //   921: iload #9
    //   923: istore #12
    //   925: iload #6
    //   927: istore #10
    //   929: aload #20
    //   931: astore #21
    //   933: iload #16
    //   935: bipush #27
    //   937: if_icmpne -> 1068
    //   940: iload #14
    //   942: iconst_2
    //   943: if_icmpne -> 1065
    //   946: aload #21
    //   948: aload #22
    //   950: lload #17
    //   952: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   955: checkcast com/google/protobuf/Internal$ProtobufList
    //   958: astore #24
    //   960: aload #24
    //   962: astore #20
    //   964: aload #24
    //   966: invokeinterface isModifiable : ()Z
    //   971: ifne -> 1023
    //   974: aload #24
    //   976: invokeinterface size : ()I
    //   981: istore #12
    //   983: iload #12
    //   985: ifne -> 995
    //   988: bipush #10
    //   990: istore #12
    //   992: goto -> 1001
    //   995: iload #12
    //   997: iconst_2
    //   998: imul
    //   999: istore #12
    //   1001: aload #24
    //   1003: iload #12
    //   1005: invokeinterface mutableCopyWithCapacity : (I)Lcom/google/protobuf/Internal$ProtobufList;
    //   1010: astore #20
    //   1012: aload #21
    //   1014: aload #22
    //   1016: lload #17
    //   1018: aload #20
    //   1020: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   1023: aload #23
    //   1025: iload #10
    //   1027: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1030: iload #11
    //   1032: aload_2
    //   1033: iload #8
    //   1035: iload #4
    //   1037: aload #20
    //   1039: aload #5
    //   1041: invokestatic decodeMessageList : (Lcom/google/protobuf/Schema;I[BIILcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1044: istore #8
    //   1046: aload #21
    //   1048: astore #20
    //   1050: iload #6
    //   1052: istore #10
    //   1054: iload #9
    //   1056: istore #6
    //   1058: iload #4
    //   1060: istore #9
    //   1062: goto -> 24
    //   1065: goto -> 1179
    //   1068: iload #16
    //   1070: bipush #49
    //   1072: if_icmpgt -> 1130
    //   1075: aload_0
    //   1076: aload_1
    //   1077: aload_2
    //   1078: iload #8
    //   1080: iload #4
    //   1082: iload #11
    //   1084: iload #12
    //   1086: iload #14
    //   1088: iload #10
    //   1090: iload #15
    //   1092: i2l
    //   1093: iload #16
    //   1095: lload #17
    //   1097: aload #5
    //   1099: invokespecial parseRepeatedField : (Ljava/lang/Object;[BIIIIIIJIJLcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1102: istore #13
    //   1104: iload #13
    //   1106: istore #10
    //   1108: iload #13
    //   1110: iload #8
    //   1112: if_icmpeq -> 1224
    //   1115: iload #13
    //   1117: istore #8
    //   1119: iload #6
    //   1121: istore #10
    //   1123: iload #12
    //   1125: istore #6
    //   1127: goto -> 1257
    //   1130: iload #8
    //   1132: istore #13
    //   1134: iload #16
    //   1136: bipush #50
    //   1138: if_icmpne -> 1182
    //   1141: iload #14
    //   1143: iconst_2
    //   1144: if_icmpne -> 1179
    //   1147: aload_0
    //   1148: aload_1
    //   1149: aload_2
    //   1150: iload #13
    //   1152: iload #4
    //   1154: iload #10
    //   1156: lload #17
    //   1158: aload #5
    //   1160: invokespecial parseMapField : (Ljava/lang/Object;[BIIIJLcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1163: istore #8
    //   1165: iload #8
    //   1167: istore #10
    //   1169: iload #8
    //   1171: iload #13
    //   1173: if_icmpeq -> 1224
    //   1176: goto -> 1119
    //   1179: goto -> 1231
    //   1182: aload_0
    //   1183: aload_1
    //   1184: aload_2
    //   1185: iload #13
    //   1187: iload #4
    //   1189: iload #11
    //   1191: iload #12
    //   1193: iload #14
    //   1195: iload #15
    //   1197: iload #16
    //   1199: lload #17
    //   1201: iload #10
    //   1203: aload #5
    //   1205: invokespecial parseOneofField : (Ljava/lang/Object;[BIIIIIIIJILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1208: istore #8
    //   1210: iload #8
    //   1212: istore #10
    //   1214: iload #8
    //   1216: iload #13
    //   1218: if_icmpeq -> 1224
    //   1221: goto -> 1119
    //   1224: iload #10
    //   1226: istore #8
    //   1228: goto -> 1179
    //   1231: iload #11
    //   1233: aload_2
    //   1234: iload #8
    //   1236: iload #4
    //   1238: aload_1
    //   1239: invokestatic getMutableUnknownFields : (Ljava/lang/Object;)Lcom/google/protobuf/UnknownFieldSetLite;
    //   1242: aload #5
    //   1244: invokestatic decodeUnknownField : (I[BIILcom/google/protobuf/UnknownFieldSetLite;Lcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1247: istore #8
    //   1249: iload #6
    //   1251: istore #10
    //   1253: iload #9
    //   1255: istore #6
    //   1257: iload #4
    //   1259: istore #9
    //   1261: goto -> 24
    //   1264: iload #7
    //   1266: ldc 1048575
    //   1268: if_icmpeq -> 1281
    //   1271: aload #20
    //   1273: aload_1
    //   1274: iload #7
    //   1276: i2l
    //   1277: iload_3
    //   1278: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1281: iload #8
    //   1283: iload #4
    //   1285: if_icmpne -> 1291
    //   1288: iload #8
    //   1290: ireturn
    //   1291: invokestatic parseFailure : ()Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1294: athrow
  }
  
  private int parseRepeatedField(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, int paramInt7, long paramLong2, ArrayDecoders.Registers paramRegisters) throws IOException {
    UnknownFieldSetLite unknownFieldSetLite1;
    UnknownFieldSetLite unknownFieldSetLite2;
    GeneratedMessageLite generatedMessageLite;
    Internal.ProtobufList<?> protobufList2 = (Internal.ProtobufList)UNSAFE.getObject(paramT, paramLong2);
    Internal.ProtobufList<?> protobufList1 = protobufList2;
    if (!protobufList2.isModifiable()) {
      int i = protobufList2.size();
      if (i == 0) {
        i = 10;
      } else {
        i *= 2;
      } 
      protobufList1 = protobufList2.mutableCopyWithCapacity(i);
      UNSAFE.putObject(paramT, paramLong2, protobufList1);
    } 
    switch (paramInt7) {
      default:
        return paramInt1;
      case 49:
        if (paramInt5 == 3)
          return ArrayDecoders.decodeGroupList(getMessageFieldSchema(paramInt6), paramInt3, paramArrayOfbyte, paramInt1, paramInt2, protobufList1, paramRegisters); 
      case 34:
      case 48:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedSInt64List(paramArrayOfbyte, paramInt1, protobufList1, paramRegisters); 
        if (paramInt5 == 0)
          return ArrayDecoders.decodeSInt64List(paramInt3, paramArrayOfbyte, paramInt1, paramInt2, protobufList1, paramRegisters); 
      case 33:
      case 47:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedSInt32List(paramArrayOfbyte, paramInt1, protobufList1, paramRegisters); 
        if (paramInt5 == 0)
          return ArrayDecoders.decodeSInt32List(paramInt3, paramArrayOfbyte, paramInt1, paramInt2, protobufList1, paramRegisters); 
      case 30:
      case 44:
        if (paramInt5 == 2) {
          paramInt1 = ArrayDecoders.decodePackedVarint32List(paramArrayOfbyte, paramInt1, protobufList1, paramRegisters);
        } else if (paramInt5 == 0) {
          paramInt1 = ArrayDecoders.decodeVarint32List(paramInt3, paramArrayOfbyte, paramInt1, paramInt2, protobufList1, paramRegisters);
        } else {
        
        } 
        generatedMessageLite = (GeneratedMessageLite)paramT;
        unknownFieldSetLite2 = generatedMessageLite.unknownFields;
        unknownFieldSetLite1 = unknownFieldSetLite2;
        if (unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance())
          unknownFieldSetLite1 = null; 
        unknownFieldSetLite1 = (UnknownFieldSetLite)SchemaUtil.filterUnknownEnumList(paramInt4, (List)protobufList1, getEnumFieldVerifier(paramInt6), unknownFieldSetLite1, this.unknownFieldSchema);
        if (unknownFieldSetLite1 != null)
          generatedMessageLite.unknownFields = unknownFieldSetLite1; 
        return paramInt1;
      case 28:
        if (paramInt5 == 2)
          return ArrayDecoders.decodeBytesList(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 27:
        if (paramInt5 == 2)
          return ArrayDecoders.decodeMessageList(getMessageFieldSchema(paramInt6), paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 26:
        if (paramInt5 == 2)
          return ((paramLong1 & 0x20000000L) == 0L) ? ArrayDecoders.decodeStringList(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite) : ArrayDecoders.decodeStringListRequireUtf8(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 25:
      case 42:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedBoolList((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 0)
          return ArrayDecoders.decodeBoolList(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 24:
      case 31:
      case 41:
      case 45:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedFixed32List((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 5)
          return ArrayDecoders.decodeFixed32List(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 23:
      case 32:
      case 40:
      case 46:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedFixed64List((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 1)
          return ArrayDecoders.decodeFixed64List(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 22:
      case 29:
      case 39:
      case 43:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedVarint32List((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 0)
          return ArrayDecoders.decodeVarint32List(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 20:
      case 21:
      case 37:
      case 38:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedVarint64List((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 0)
          return ArrayDecoders.decodeVarint64List(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 19:
      case 36:
        if (paramInt5 == 2)
          return ArrayDecoders.decodePackedFloatList((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
        if (paramInt5 == 5)
          return ArrayDecoders.decodeFloatList(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
      case 18:
      case 35:
        break;
    } 
    if (paramInt5 == 2)
      return ArrayDecoders.decodePackedDoubleList((byte[])unknownFieldSetLite2, paramInt1, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
    if (paramInt5 == 1)
      return ArrayDecoders.decodeDoubleList(paramInt3, (byte[])unknownFieldSetLite2, paramInt1, paramInt2, protobufList1, (ArrayDecoders.Registers)generatedMessageLite); 
  }
  
  private int positionForFieldNumber(int paramInt) {
    return (paramInt >= this.minFieldNumber && paramInt <= this.maxFieldNumber) ? slowPositionForFieldNumber(paramInt, 0) : -1;
  }
  
  private int positionForFieldNumber(int paramInt1, int paramInt2) {
    return (paramInt1 >= this.minFieldNumber && paramInt1 <= this.maxFieldNumber) ? slowPositionForFieldNumber(paramInt1, paramInt2) : -1;
  }
  
  private int presenceMaskAndOffsetAt(int paramInt) {
    return this.buffer[paramInt + 2];
  }
  
  private <E> void readGroupList(Object paramObject, long paramLong, Reader paramReader, Schema<E> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    paramReader.readGroupList(this.listFieldSchema.mutableListAt(paramObject, paramLong), paramSchema, paramExtensionRegistryLite);
  }
  
  private <E> void readMessageList(Object paramObject, int paramInt, Reader paramReader, Schema<E> paramSchema, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    long l = offset(paramInt);
    paramReader.readMessageList(this.listFieldSchema.mutableListAt(paramObject, l), paramSchema, paramExtensionRegistryLite);
  }
  
  private void readString(Object paramObject, int paramInt, Reader paramReader) throws IOException {
    if (isEnforceUtf8(paramInt)) {
      UnsafeUtil.putObject(paramObject, offset(paramInt), paramReader.readStringRequireUtf8());
      return;
    } 
    if (this.lite) {
      UnsafeUtil.putObject(paramObject, offset(paramInt), paramReader.readString());
      return;
    } 
    UnsafeUtil.putObject(paramObject, offset(paramInt), paramReader.readBytes());
  }
  
  private void readStringList(Object paramObject, int paramInt, Reader paramReader) throws IOException {
    if (isEnforceUtf8(paramInt)) {
      paramReader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(paramObject, offset(paramInt)));
      return;
    } 
    paramReader.readStringList(this.listFieldSchema.mutableListAt(paramObject, offset(paramInt)));
  }
  
  private static Field reflectField(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getDeclaredField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      for (Field field : paramClass.getDeclaredFields()) {
        if (paramString.equals(field.getName()))
          return field; 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Field ");
      stringBuilder.append(paramString);
      stringBuilder.append(" for ");
      stringBuilder.append(paramClass.getName());
      stringBuilder.append(" not found. Known fields are ");
      stringBuilder.append(Arrays.toString((Object[])noSuchFieldException));
      throw new RuntimeException(stringBuilder.toString());
    } 
  }
  
  private void setFieldPresent(T paramT, int paramInt) {
    paramInt = presenceMaskAndOffsetAt(paramInt);
    long l = (0xFFFFF & paramInt);
    if (l == 1048575L)
      return; 
    UnsafeUtil.putInt(paramT, l, 1 << paramInt >>> 20 | UnsafeUtil.getInt(paramT, l));
  }
  
  private void setOneofPresent(T paramT, int paramInt1, int paramInt2) {
    UnsafeUtil.putInt(paramT, (presenceMaskAndOffsetAt(paramInt2) & 0xFFFFF), paramInt1);
  }
  
  private int slowPositionForFieldNumber(int paramInt1, int paramInt2) {
    int i = this.buffer.length / 3 - 1;
    while (paramInt2 <= i) {
      int j = i + paramInt2 >>> 1;
      int k = j * 3;
      int m = numberAt(k);
      if (paramInt1 == m)
        return k; 
      if (paramInt1 < m) {
        i = j - 1;
        continue;
      } 
      paramInt2 = j + 1;
    } 
    return -1;
  }
  
  private static void storeFieldData(FieldInfo paramFieldInfo, int[] paramArrayOfint, int paramInt, Object[] paramArrayOfObject) {
    long l;
    OneofInfo oneofInfo = paramFieldInfo.getOneof();
    int j = 0;
    if (oneofInfo != null) {
      int m = paramFieldInfo.getType().id() + 51;
      int k = (int)UnsafeUtil.objectFieldOffset(oneofInfo.getValueField());
      l = UnsafeUtil.objectFieldOffset(oneofInfo.getCaseField());
    } else {
      int n;
      byte b1;
      byte b2;
      FieldType fieldType = paramFieldInfo.getType();
      int k = (int)UnsafeUtil.objectFieldOffset(paramFieldInfo.getField());
      int m = fieldType.id();
      if (!fieldType.isList() && !fieldType.isMap()) {
        Field field = paramFieldInfo.getPresenceField();
        if (field == null) {
          n = 1048575;
        } else {
          n = (int)UnsafeUtil.objectFieldOffset(field);
        } 
        b1 = Integer.numberOfTrailingZeros(paramFieldInfo.getPresenceMask());
      } else {
        if (paramFieldInfo.getCachedSizeField() == null) {
          n = 0;
        } else {
          l = UnsafeUtil.objectFieldOffset(paramFieldInfo.getCachedSizeField());
          n = (int)l;
        } 
        b1 = 0;
      } 
      paramArrayOfint[paramInt] = paramFieldInfo.getFieldNumber();
      if (paramFieldInfo.isEnforceUtf8()) {
        b2 = 536870912;
      } else {
        b2 = 0;
      } 
      if (paramFieldInfo.isRequired())
        j = 268435456; 
      paramArrayOfint[paramInt + 1] = j | b2 | m << 20 | k;
      paramArrayOfint[paramInt + 2] = n | b1 << 20;
      Class<?> clazz = paramFieldInfo.getMessageFieldClass();
      if (paramFieldInfo.getMapDefaultEntry() != null) {
        paramInt = paramInt / 3 * 2;
        paramArrayOfObject[paramInt] = paramFieldInfo.getMapDefaultEntry();
        if (clazz != null) {
          paramArrayOfObject[paramInt + 1] = clazz;
          return;
        } 
        if (paramFieldInfo.getEnumVerifier() != null) {
          paramArrayOfObject[paramInt + 1] = paramFieldInfo.getEnumVerifier();
          return;
        } 
      } else {
        if (clazz != null) {
          paramArrayOfObject[paramInt / 3 * 2 + 1] = clazz;
          return;
        } 
        if (paramFieldInfo.getEnumVerifier() != null)
          paramArrayOfObject[paramInt / 3 * 2 + 1] = paramFieldInfo.getEnumVerifier(); 
      } 
      return;
    } 
    int i = (int)l;
  }
  
  private static int type(int paramInt) {
    return (paramInt & 0xFF00000) >>> 20;
  }
  
  private int typeAndOffsetAt(int paramInt) {
    return this.buffer[paramInt + 1];
  }
  
  private void writeFieldsInAscendingOrderProto2(T paramT, Writer paramWriter) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield hasExtensions : Z
    //   4: ifeq -> 47
    //   7: aload_0
    //   8: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   11: aload_1
    //   12: invokevirtual getExtensions : (Ljava/lang/Object;)Lcom/google/protobuf/FieldSet;
    //   15: astore #14
    //   17: aload #14
    //   19: invokevirtual isEmpty : ()Z
    //   22: ifne -> 47
    //   25: aload #14
    //   27: invokevirtual iterator : ()Ljava/util/Iterator;
    //   30: astore #15
    //   32: aload #15
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast java/util/Map$Entry
    //   42: astore #14
    //   44: goto -> 53
    //   47: aconst_null
    //   48: astore #15
    //   50: aconst_null
    //   51: astore #14
    //   53: aload_0
    //   54: getfield buffer : [I
    //   57: arraylength
    //   58: istore #7
    //   60: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   63: astore #16
    //   65: iconst_0
    //   66: istore #5
    //   68: ldc 1048575
    //   70: istore #4
    //   72: iconst_0
    //   73: istore_3
    //   74: iload #5
    //   76: iload #7
    //   78: if_icmpge -> 2393
    //   81: aload_0
    //   82: iload #5
    //   84: invokespecial typeAndOffsetAt : (I)I
    //   87: istore #8
    //   89: aload_0
    //   90: iload #5
    //   92: invokespecial numberAt : (I)I
    //   95: istore #9
    //   97: iload #8
    //   99: invokestatic type : (I)I
    //   102: istore #10
    //   104: aload_0
    //   105: getfield proto3 : Z
    //   108: ifne -> 172
    //   111: iload #10
    //   113: bipush #17
    //   115: if_icmpgt -> 172
    //   118: aload_0
    //   119: getfield buffer : [I
    //   122: iload #5
    //   124: iconst_2
    //   125: iadd
    //   126: iaload
    //   127: istore #11
    //   129: iload #11
    //   131: ldc 1048575
    //   133: iand
    //   134: istore #6
    //   136: iload #6
    //   138: iload #4
    //   140: if_icmpeq -> 160
    //   143: aload #16
    //   145: aload_1
    //   146: iload #6
    //   148: i2l
    //   149: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   152: istore_3
    //   153: iload #6
    //   155: istore #4
    //   157: goto -> 160
    //   160: iconst_1
    //   161: iload #11
    //   163: bipush #20
    //   165: iushr
    //   166: ishl
    //   167: istore #6
    //   169: goto -> 175
    //   172: iconst_0
    //   173: istore #6
    //   175: aload #14
    //   177: ifnull -> 235
    //   180: aload_0
    //   181: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   184: aload #14
    //   186: invokevirtual extensionNumber : (Ljava/util/Map$Entry;)I
    //   189: iload #9
    //   191: if_icmpgt -> 235
    //   194: aload_0
    //   195: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   198: aload_2
    //   199: aload #14
    //   201: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   204: aload #15
    //   206: invokeinterface hasNext : ()Z
    //   211: ifeq -> 229
    //   214: aload #15
    //   216: invokeinterface next : ()Ljava/lang/Object;
    //   221: checkcast java/util/Map$Entry
    //   224: astore #14
    //   226: goto -> 175
    //   229: aconst_null
    //   230: astore #14
    //   232: goto -> 175
    //   235: iload #8
    //   237: invokestatic offset : (I)J
    //   240: lstore #12
    //   242: iload #10
    //   244: tableswitch default -> 536, 0 -> 2363, 1 -> 2339, 2 -> 2313, 3 -> 2287, 4 -> 2261, 5 -> 2235, 6 -> 2209, 7 -> 2185, 8 -> 2160, 9 -> 2128, 10 -> 2099, 11 -> 2073, 12 -> 2047, 13 -> 2021, 14 -> 1995, 15 -> 1969, 16 -> 1943, 17 -> 1911, 18 -> 1886, 19 -> 1861, 20 -> 1836, 21 -> 1811, 22 -> 1786, 23 -> 1761, 24 -> 1736, 25 -> 1711, 26 -> 1687, 27 -> 1657, 28 -> 1633, 29 -> 1608, 30 -> 1583, 31 -> 1558, 32 -> 1533, 33 -> 1508, 34 -> 1483, 35 -> 1458, 36 -> 1433, 37 -> 1408, 38 -> 1383, 39 -> 1358, 40 -> 1333, 41 -> 1308, 42 -> 1283, 43 -> 1258, 44 -> 1233, 45 -> 1208, 46 -> 1183, 47 -> 1158, 48 -> 1133, 49 -> 1103, 50 -> 1083, 51 -> 1054, 52 -> 1025, 53 -> 996, 54 -> 967, 55 -> 938, 56 -> 909, 57 -> 880, 58 -> 851, 59 -> 821, 60 -> 784, 61 -> 750, 62 -> 721, 63 -> 692, 64 -> 663, 65 -> 634, 66 -> 605, 67 -> 576, 68 -> 539
    //   536: goto -> 2384
    //   539: aload_0
    //   540: aload_1
    //   541: iload #9
    //   543: iload #5
    //   545: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   548: ifeq -> 536
    //   551: aload_2
    //   552: iload #9
    //   554: aload #16
    //   556: aload_1
    //   557: lload #12
    //   559: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   562: aload_0
    //   563: iload #5
    //   565: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   568: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   573: goto -> 536
    //   576: aload_0
    //   577: aload_1
    //   578: iload #9
    //   580: iload #5
    //   582: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   585: ifeq -> 536
    //   588: aload_2
    //   589: iload #9
    //   591: aload_1
    //   592: lload #12
    //   594: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   597: invokeinterface writeSInt64 : (IJ)V
    //   602: goto -> 536
    //   605: aload_0
    //   606: aload_1
    //   607: iload #9
    //   609: iload #5
    //   611: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   614: ifeq -> 536
    //   617: aload_2
    //   618: iload #9
    //   620: aload_1
    //   621: lload #12
    //   623: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   626: invokeinterface writeSInt32 : (II)V
    //   631: goto -> 536
    //   634: aload_0
    //   635: aload_1
    //   636: iload #9
    //   638: iload #5
    //   640: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   643: ifeq -> 536
    //   646: aload_2
    //   647: iload #9
    //   649: aload_1
    //   650: lload #12
    //   652: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   655: invokeinterface writeSFixed64 : (IJ)V
    //   660: goto -> 536
    //   663: aload_0
    //   664: aload_1
    //   665: iload #9
    //   667: iload #5
    //   669: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   672: ifeq -> 536
    //   675: aload_2
    //   676: iload #9
    //   678: aload_1
    //   679: lload #12
    //   681: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   684: invokeinterface writeSFixed32 : (II)V
    //   689: goto -> 536
    //   692: aload_0
    //   693: aload_1
    //   694: iload #9
    //   696: iload #5
    //   698: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   701: ifeq -> 536
    //   704: aload_2
    //   705: iload #9
    //   707: aload_1
    //   708: lload #12
    //   710: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   713: invokeinterface writeEnum : (II)V
    //   718: goto -> 536
    //   721: aload_0
    //   722: aload_1
    //   723: iload #9
    //   725: iload #5
    //   727: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   730: ifeq -> 536
    //   733: aload_2
    //   734: iload #9
    //   736: aload_1
    //   737: lload #12
    //   739: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   742: invokeinterface writeUInt32 : (II)V
    //   747: goto -> 536
    //   750: aload_0
    //   751: aload_1
    //   752: iload #9
    //   754: iload #5
    //   756: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   759: ifeq -> 536
    //   762: aload_2
    //   763: iload #9
    //   765: aload #16
    //   767: aload_1
    //   768: lload #12
    //   770: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   773: checkcast com/google/protobuf/ByteString
    //   776: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   781: goto -> 536
    //   784: aload_0
    //   785: aload_1
    //   786: iload #9
    //   788: iload #5
    //   790: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   793: ifeq -> 536
    //   796: aload_2
    //   797: iload #9
    //   799: aload #16
    //   801: aload_1
    //   802: lload #12
    //   804: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   807: aload_0
    //   808: iload #5
    //   810: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   813: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   818: goto -> 536
    //   821: aload_0
    //   822: aload_1
    //   823: iload #9
    //   825: iload #5
    //   827: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   830: ifeq -> 536
    //   833: aload_0
    //   834: iload #9
    //   836: aload #16
    //   838: aload_1
    //   839: lload #12
    //   841: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   844: aload_2
    //   845: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   848: goto -> 536
    //   851: aload_0
    //   852: aload_1
    //   853: iload #9
    //   855: iload #5
    //   857: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   860: ifeq -> 536
    //   863: aload_2
    //   864: iload #9
    //   866: aload_1
    //   867: lload #12
    //   869: invokestatic oneofBooleanAt : (Ljava/lang/Object;J)Z
    //   872: invokeinterface writeBool : (IZ)V
    //   877: goto -> 536
    //   880: aload_0
    //   881: aload_1
    //   882: iload #9
    //   884: iload #5
    //   886: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   889: ifeq -> 536
    //   892: aload_2
    //   893: iload #9
    //   895: aload_1
    //   896: lload #12
    //   898: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   901: invokeinterface writeFixed32 : (II)V
    //   906: goto -> 536
    //   909: aload_0
    //   910: aload_1
    //   911: iload #9
    //   913: iload #5
    //   915: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   918: ifeq -> 536
    //   921: aload_2
    //   922: iload #9
    //   924: aload_1
    //   925: lload #12
    //   927: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   930: invokeinterface writeFixed64 : (IJ)V
    //   935: goto -> 536
    //   938: aload_0
    //   939: aload_1
    //   940: iload #9
    //   942: iload #5
    //   944: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   947: ifeq -> 536
    //   950: aload_2
    //   951: iload #9
    //   953: aload_1
    //   954: lload #12
    //   956: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   959: invokeinterface writeInt32 : (II)V
    //   964: goto -> 536
    //   967: aload_0
    //   968: aload_1
    //   969: iload #9
    //   971: iload #5
    //   973: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   976: ifeq -> 536
    //   979: aload_2
    //   980: iload #9
    //   982: aload_1
    //   983: lload #12
    //   985: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   988: invokeinterface writeUInt64 : (IJ)V
    //   993: goto -> 536
    //   996: aload_0
    //   997: aload_1
    //   998: iload #9
    //   1000: iload #5
    //   1002: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   1005: ifeq -> 536
    //   1008: aload_2
    //   1009: iload #9
    //   1011: aload_1
    //   1012: lload #12
    //   1014: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   1017: invokeinterface writeInt64 : (IJ)V
    //   1022: goto -> 536
    //   1025: aload_0
    //   1026: aload_1
    //   1027: iload #9
    //   1029: iload #5
    //   1031: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   1034: ifeq -> 536
    //   1037: aload_2
    //   1038: iload #9
    //   1040: aload_1
    //   1041: lload #12
    //   1043: invokestatic oneofFloatAt : (Ljava/lang/Object;J)F
    //   1046: invokeinterface writeFloat : (IF)V
    //   1051: goto -> 536
    //   1054: aload_0
    //   1055: aload_1
    //   1056: iload #9
    //   1058: iload #5
    //   1060: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   1063: ifeq -> 536
    //   1066: aload_2
    //   1067: iload #9
    //   1069: aload_1
    //   1070: lload #12
    //   1072: invokestatic oneofDoubleAt : (Ljava/lang/Object;J)D
    //   1075: invokeinterface writeDouble : (ID)V
    //   1080: goto -> 536
    //   1083: aload_0
    //   1084: aload_2
    //   1085: iload #9
    //   1087: aload #16
    //   1089: aload_1
    //   1090: lload #12
    //   1092: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1095: iload #5
    //   1097: invokespecial writeMapHelper : (Lcom/google/protobuf/Writer;ILjava/lang/Object;I)V
    //   1100: goto -> 536
    //   1103: aload_0
    //   1104: iload #5
    //   1106: invokespecial numberAt : (I)I
    //   1109: aload #16
    //   1111: aload_1
    //   1112: lload #12
    //   1114: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1117: checkcast java/util/List
    //   1120: aload_2
    //   1121: aload_0
    //   1122: iload #5
    //   1124: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1127: invokestatic writeGroupList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1130: goto -> 536
    //   1133: aload_0
    //   1134: iload #5
    //   1136: invokespecial numberAt : (I)I
    //   1139: aload #16
    //   1141: aload_1
    //   1142: lload #12
    //   1144: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1147: checkcast java/util/List
    //   1150: aload_2
    //   1151: iconst_1
    //   1152: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1155: goto -> 536
    //   1158: aload_0
    //   1159: iload #5
    //   1161: invokespecial numberAt : (I)I
    //   1164: aload #16
    //   1166: aload_1
    //   1167: lload #12
    //   1169: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1172: checkcast java/util/List
    //   1175: aload_2
    //   1176: iconst_1
    //   1177: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1180: goto -> 536
    //   1183: aload_0
    //   1184: iload #5
    //   1186: invokespecial numberAt : (I)I
    //   1189: aload #16
    //   1191: aload_1
    //   1192: lload #12
    //   1194: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1197: checkcast java/util/List
    //   1200: aload_2
    //   1201: iconst_1
    //   1202: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1205: goto -> 536
    //   1208: aload_0
    //   1209: iload #5
    //   1211: invokespecial numberAt : (I)I
    //   1214: aload #16
    //   1216: aload_1
    //   1217: lload #12
    //   1219: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1222: checkcast java/util/List
    //   1225: aload_2
    //   1226: iconst_1
    //   1227: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1230: goto -> 536
    //   1233: aload_0
    //   1234: iload #5
    //   1236: invokespecial numberAt : (I)I
    //   1239: aload #16
    //   1241: aload_1
    //   1242: lload #12
    //   1244: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1247: checkcast java/util/List
    //   1250: aload_2
    //   1251: iconst_1
    //   1252: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1255: goto -> 536
    //   1258: aload_0
    //   1259: iload #5
    //   1261: invokespecial numberAt : (I)I
    //   1264: aload #16
    //   1266: aload_1
    //   1267: lload #12
    //   1269: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1272: checkcast java/util/List
    //   1275: aload_2
    //   1276: iconst_1
    //   1277: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1280: goto -> 536
    //   1283: aload_0
    //   1284: iload #5
    //   1286: invokespecial numberAt : (I)I
    //   1289: aload #16
    //   1291: aload_1
    //   1292: lload #12
    //   1294: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1297: checkcast java/util/List
    //   1300: aload_2
    //   1301: iconst_1
    //   1302: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1305: goto -> 536
    //   1308: aload_0
    //   1309: iload #5
    //   1311: invokespecial numberAt : (I)I
    //   1314: aload #16
    //   1316: aload_1
    //   1317: lload #12
    //   1319: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1322: checkcast java/util/List
    //   1325: aload_2
    //   1326: iconst_1
    //   1327: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1330: goto -> 536
    //   1333: aload_0
    //   1334: iload #5
    //   1336: invokespecial numberAt : (I)I
    //   1339: aload #16
    //   1341: aload_1
    //   1342: lload #12
    //   1344: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1347: checkcast java/util/List
    //   1350: aload_2
    //   1351: iconst_1
    //   1352: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1355: goto -> 536
    //   1358: aload_0
    //   1359: iload #5
    //   1361: invokespecial numberAt : (I)I
    //   1364: aload #16
    //   1366: aload_1
    //   1367: lload #12
    //   1369: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1372: checkcast java/util/List
    //   1375: aload_2
    //   1376: iconst_1
    //   1377: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1380: goto -> 536
    //   1383: aload_0
    //   1384: iload #5
    //   1386: invokespecial numberAt : (I)I
    //   1389: aload #16
    //   1391: aload_1
    //   1392: lload #12
    //   1394: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1397: checkcast java/util/List
    //   1400: aload_2
    //   1401: iconst_1
    //   1402: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1405: goto -> 536
    //   1408: aload_0
    //   1409: iload #5
    //   1411: invokespecial numberAt : (I)I
    //   1414: aload #16
    //   1416: aload_1
    //   1417: lload #12
    //   1419: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1422: checkcast java/util/List
    //   1425: aload_2
    //   1426: iconst_1
    //   1427: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1430: goto -> 536
    //   1433: aload_0
    //   1434: iload #5
    //   1436: invokespecial numberAt : (I)I
    //   1439: aload #16
    //   1441: aload_1
    //   1442: lload #12
    //   1444: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1447: checkcast java/util/List
    //   1450: aload_2
    //   1451: iconst_1
    //   1452: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1455: goto -> 536
    //   1458: aload_0
    //   1459: iload #5
    //   1461: invokespecial numberAt : (I)I
    //   1464: aload #16
    //   1466: aload_1
    //   1467: lload #12
    //   1469: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1472: checkcast java/util/List
    //   1475: aload_2
    //   1476: iconst_1
    //   1477: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1480: goto -> 536
    //   1483: aload_0
    //   1484: iload #5
    //   1486: invokespecial numberAt : (I)I
    //   1489: aload #16
    //   1491: aload_1
    //   1492: lload #12
    //   1494: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1497: checkcast java/util/List
    //   1500: aload_2
    //   1501: iconst_0
    //   1502: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1505: goto -> 536
    //   1508: aload_0
    //   1509: iload #5
    //   1511: invokespecial numberAt : (I)I
    //   1514: aload #16
    //   1516: aload_1
    //   1517: lload #12
    //   1519: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1522: checkcast java/util/List
    //   1525: aload_2
    //   1526: iconst_0
    //   1527: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1530: goto -> 536
    //   1533: aload_0
    //   1534: iload #5
    //   1536: invokespecial numberAt : (I)I
    //   1539: aload #16
    //   1541: aload_1
    //   1542: lload #12
    //   1544: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1547: checkcast java/util/List
    //   1550: aload_2
    //   1551: iconst_0
    //   1552: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1555: goto -> 536
    //   1558: aload_0
    //   1559: iload #5
    //   1561: invokespecial numberAt : (I)I
    //   1564: aload #16
    //   1566: aload_1
    //   1567: lload #12
    //   1569: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1572: checkcast java/util/List
    //   1575: aload_2
    //   1576: iconst_0
    //   1577: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1580: goto -> 536
    //   1583: aload_0
    //   1584: iload #5
    //   1586: invokespecial numberAt : (I)I
    //   1589: aload #16
    //   1591: aload_1
    //   1592: lload #12
    //   1594: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1597: checkcast java/util/List
    //   1600: aload_2
    //   1601: iconst_0
    //   1602: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1605: goto -> 536
    //   1608: aload_0
    //   1609: iload #5
    //   1611: invokespecial numberAt : (I)I
    //   1614: aload #16
    //   1616: aload_1
    //   1617: lload #12
    //   1619: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1622: checkcast java/util/List
    //   1625: aload_2
    //   1626: iconst_0
    //   1627: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1630: goto -> 536
    //   1633: aload_0
    //   1634: iload #5
    //   1636: invokespecial numberAt : (I)I
    //   1639: aload #16
    //   1641: aload_1
    //   1642: lload #12
    //   1644: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1647: checkcast java/util/List
    //   1650: aload_2
    //   1651: invokestatic writeBytesList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1654: goto -> 536
    //   1657: aload_0
    //   1658: iload #5
    //   1660: invokespecial numberAt : (I)I
    //   1663: aload #16
    //   1665: aload_1
    //   1666: lload #12
    //   1668: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1671: checkcast java/util/List
    //   1674: aload_2
    //   1675: aload_0
    //   1676: iload #5
    //   1678: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1681: invokestatic writeMessageList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1684: goto -> 536
    //   1687: aload_0
    //   1688: iload #5
    //   1690: invokespecial numberAt : (I)I
    //   1693: aload #16
    //   1695: aload_1
    //   1696: lload #12
    //   1698: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1701: checkcast java/util/List
    //   1704: aload_2
    //   1705: invokestatic writeStringList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1708: goto -> 536
    //   1711: aload_0
    //   1712: iload #5
    //   1714: invokespecial numberAt : (I)I
    //   1717: aload #16
    //   1719: aload_1
    //   1720: lload #12
    //   1722: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1725: checkcast java/util/List
    //   1728: aload_2
    //   1729: iconst_0
    //   1730: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1733: goto -> 2384
    //   1736: aload_0
    //   1737: iload #5
    //   1739: invokespecial numberAt : (I)I
    //   1742: aload #16
    //   1744: aload_1
    //   1745: lload #12
    //   1747: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1750: checkcast java/util/List
    //   1753: aload_2
    //   1754: iconst_0
    //   1755: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1758: goto -> 2384
    //   1761: aload_0
    //   1762: iload #5
    //   1764: invokespecial numberAt : (I)I
    //   1767: aload #16
    //   1769: aload_1
    //   1770: lload #12
    //   1772: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1775: checkcast java/util/List
    //   1778: aload_2
    //   1779: iconst_0
    //   1780: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1783: goto -> 2384
    //   1786: aload_0
    //   1787: iload #5
    //   1789: invokespecial numberAt : (I)I
    //   1792: aload #16
    //   1794: aload_1
    //   1795: lload #12
    //   1797: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1800: checkcast java/util/List
    //   1803: aload_2
    //   1804: iconst_0
    //   1805: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1808: goto -> 2384
    //   1811: aload_0
    //   1812: iload #5
    //   1814: invokespecial numberAt : (I)I
    //   1817: aload #16
    //   1819: aload_1
    //   1820: lload #12
    //   1822: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1825: checkcast java/util/List
    //   1828: aload_2
    //   1829: iconst_0
    //   1830: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1833: goto -> 2384
    //   1836: aload_0
    //   1837: iload #5
    //   1839: invokespecial numberAt : (I)I
    //   1842: aload #16
    //   1844: aload_1
    //   1845: lload #12
    //   1847: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1850: checkcast java/util/List
    //   1853: aload_2
    //   1854: iconst_0
    //   1855: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1858: goto -> 2384
    //   1861: aload_0
    //   1862: iload #5
    //   1864: invokespecial numberAt : (I)I
    //   1867: aload #16
    //   1869: aload_1
    //   1870: lload #12
    //   1872: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1875: checkcast java/util/List
    //   1878: aload_2
    //   1879: iconst_0
    //   1880: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1883: goto -> 2384
    //   1886: aload_0
    //   1887: iload #5
    //   1889: invokespecial numberAt : (I)I
    //   1892: aload #16
    //   1894: aload_1
    //   1895: lload #12
    //   1897: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1900: checkcast java/util/List
    //   1903: aload_2
    //   1904: iconst_0
    //   1905: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1908: goto -> 2384
    //   1911: iload_3
    //   1912: iload #6
    //   1914: iand
    //   1915: ifeq -> 2384
    //   1918: aload_2
    //   1919: iload #9
    //   1921: aload #16
    //   1923: aload_1
    //   1924: lload #12
    //   1926: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1929: aload_0
    //   1930: iload #5
    //   1932: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1935: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   1940: goto -> 2384
    //   1943: iload_3
    //   1944: iload #6
    //   1946: iand
    //   1947: ifeq -> 2384
    //   1950: aload_2
    //   1951: iload #9
    //   1953: aload #16
    //   1955: aload_1
    //   1956: lload #12
    //   1958: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   1961: invokeinterface writeSInt64 : (IJ)V
    //   1966: goto -> 2384
    //   1969: iload_3
    //   1970: iload #6
    //   1972: iand
    //   1973: ifeq -> 2384
    //   1976: aload_2
    //   1977: iload #9
    //   1979: aload #16
    //   1981: aload_1
    //   1982: lload #12
    //   1984: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   1987: invokeinterface writeSInt32 : (II)V
    //   1992: goto -> 2384
    //   1995: iload_3
    //   1996: iload #6
    //   1998: iand
    //   1999: ifeq -> 2384
    //   2002: aload_2
    //   2003: iload #9
    //   2005: aload #16
    //   2007: aload_1
    //   2008: lload #12
    //   2010: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2013: invokeinterface writeSFixed64 : (IJ)V
    //   2018: goto -> 2384
    //   2021: iload_3
    //   2022: iload #6
    //   2024: iand
    //   2025: ifeq -> 2384
    //   2028: aload_2
    //   2029: iload #9
    //   2031: aload #16
    //   2033: aload_1
    //   2034: lload #12
    //   2036: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2039: invokeinterface writeSFixed32 : (II)V
    //   2044: goto -> 2384
    //   2047: iload_3
    //   2048: iload #6
    //   2050: iand
    //   2051: ifeq -> 2384
    //   2054: aload_2
    //   2055: iload #9
    //   2057: aload #16
    //   2059: aload_1
    //   2060: lload #12
    //   2062: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2065: invokeinterface writeEnum : (II)V
    //   2070: goto -> 2384
    //   2073: iload_3
    //   2074: iload #6
    //   2076: iand
    //   2077: ifeq -> 2384
    //   2080: aload_2
    //   2081: iload #9
    //   2083: aload #16
    //   2085: aload_1
    //   2086: lload #12
    //   2088: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2091: invokeinterface writeUInt32 : (II)V
    //   2096: goto -> 2384
    //   2099: iload_3
    //   2100: iload #6
    //   2102: iand
    //   2103: ifeq -> 2384
    //   2106: aload_2
    //   2107: iload #9
    //   2109: aload #16
    //   2111: aload_1
    //   2112: lload #12
    //   2114: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2117: checkcast com/google/protobuf/ByteString
    //   2120: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   2125: goto -> 2384
    //   2128: iload_3
    //   2129: iload #6
    //   2131: iand
    //   2132: ifeq -> 2384
    //   2135: aload_2
    //   2136: iload #9
    //   2138: aload #16
    //   2140: aload_1
    //   2141: lload #12
    //   2143: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2146: aload_0
    //   2147: iload #5
    //   2149: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2152: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   2157: goto -> 2384
    //   2160: iload_3
    //   2161: iload #6
    //   2163: iand
    //   2164: ifeq -> 2384
    //   2167: aload_0
    //   2168: iload #9
    //   2170: aload #16
    //   2172: aload_1
    //   2173: lload #12
    //   2175: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2178: aload_2
    //   2179: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   2182: goto -> 2384
    //   2185: iload_3
    //   2186: iload #6
    //   2188: iand
    //   2189: ifeq -> 2384
    //   2192: aload_2
    //   2193: iload #9
    //   2195: aload_1
    //   2196: lload #12
    //   2198: invokestatic booleanAt : (Ljava/lang/Object;J)Z
    //   2201: invokeinterface writeBool : (IZ)V
    //   2206: goto -> 2384
    //   2209: iload_3
    //   2210: iload #6
    //   2212: iand
    //   2213: ifeq -> 2384
    //   2216: aload_2
    //   2217: iload #9
    //   2219: aload #16
    //   2221: aload_1
    //   2222: lload #12
    //   2224: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2227: invokeinterface writeFixed32 : (II)V
    //   2232: goto -> 2384
    //   2235: iload_3
    //   2236: iload #6
    //   2238: iand
    //   2239: ifeq -> 2384
    //   2242: aload_2
    //   2243: iload #9
    //   2245: aload #16
    //   2247: aload_1
    //   2248: lload #12
    //   2250: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2253: invokeinterface writeFixed64 : (IJ)V
    //   2258: goto -> 2384
    //   2261: iload_3
    //   2262: iload #6
    //   2264: iand
    //   2265: ifeq -> 2384
    //   2268: aload_2
    //   2269: iload #9
    //   2271: aload #16
    //   2273: aload_1
    //   2274: lload #12
    //   2276: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   2279: invokeinterface writeInt32 : (II)V
    //   2284: goto -> 2384
    //   2287: iload_3
    //   2288: iload #6
    //   2290: iand
    //   2291: ifeq -> 2384
    //   2294: aload_2
    //   2295: iload #9
    //   2297: aload #16
    //   2299: aload_1
    //   2300: lload #12
    //   2302: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2305: invokeinterface writeUInt64 : (IJ)V
    //   2310: goto -> 2384
    //   2313: iload_3
    //   2314: iload #6
    //   2316: iand
    //   2317: ifeq -> 2384
    //   2320: aload_2
    //   2321: iload #9
    //   2323: aload #16
    //   2325: aload_1
    //   2326: lload #12
    //   2328: invokevirtual getLong : (Ljava/lang/Object;J)J
    //   2331: invokeinterface writeInt64 : (IJ)V
    //   2336: goto -> 2384
    //   2339: iload_3
    //   2340: iload #6
    //   2342: iand
    //   2343: ifeq -> 2384
    //   2346: aload_2
    //   2347: iload #9
    //   2349: aload_1
    //   2350: lload #12
    //   2352: invokestatic floatAt : (Ljava/lang/Object;J)F
    //   2355: invokeinterface writeFloat : (IF)V
    //   2360: goto -> 2384
    //   2363: iload_3
    //   2364: iload #6
    //   2366: iand
    //   2367: ifeq -> 2384
    //   2370: aload_2
    //   2371: iload #9
    //   2373: aload_1
    //   2374: lload #12
    //   2376: invokestatic doubleAt : (Ljava/lang/Object;J)D
    //   2379: invokeinterface writeDouble : (ID)V
    //   2384: iload #5
    //   2386: iconst_3
    //   2387: iadd
    //   2388: istore #5
    //   2390: goto -> 74
    //   2393: aload #14
    //   2395: ifnull -> 2439
    //   2398: aload_0
    //   2399: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   2402: aload_2
    //   2403: aload #14
    //   2405: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   2408: aload #15
    //   2410: invokeinterface hasNext : ()Z
    //   2415: ifeq -> 2433
    //   2418: aload #15
    //   2420: invokeinterface next : ()Ljava/lang/Object;
    //   2425: checkcast java/util/Map$Entry
    //   2428: astore #14
    //   2430: goto -> 2393
    //   2433: aconst_null
    //   2434: astore #14
    //   2436: goto -> 2393
    //   2439: aload_0
    //   2440: aload_0
    //   2441: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   2444: aload_1
    //   2445: aload_2
    //   2446: invokespecial writeUnknownInMessageTo : (Lcom/google/protobuf/UnknownFieldSchema;Ljava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   2449: return
  }
  
  private void writeFieldsInAscendingOrderProto3(T paramT, Writer paramWriter) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield hasExtensions : Z
    //   4: ifeq -> 47
    //   7: aload_0
    //   8: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   11: aload_1
    //   12: invokevirtual getExtensions : (Ljava/lang/Object;)Lcom/google/protobuf/FieldSet;
    //   15: astore #7
    //   17: aload #7
    //   19: invokevirtual isEmpty : ()Z
    //   22: ifne -> 47
    //   25: aload #7
    //   27: invokevirtual iterator : ()Ljava/util/Iterator;
    //   30: astore #9
    //   32: aload #9
    //   34: invokeinterface next : ()Ljava/lang/Object;
    //   39: checkcast java/util/Map$Entry
    //   42: astore #7
    //   44: goto -> 54
    //   47: aconst_null
    //   48: astore #9
    //   50: aload #9
    //   52: astore #7
    //   54: aload_0
    //   55: getfield buffer : [I
    //   58: arraylength
    //   59: istore #4
    //   61: iconst_0
    //   62: istore_3
    //   63: aload #7
    //   65: astore #8
    //   67: iload_3
    //   68: iload #4
    //   70: if_icmpge -> 2381
    //   73: aload_0
    //   74: iload_3
    //   75: invokespecial typeAndOffsetAt : (I)I
    //   78: istore #5
    //   80: aload_0
    //   81: iload_3
    //   82: invokespecial numberAt : (I)I
    //   85: istore #6
    //   87: aload #7
    //   89: ifnull -> 147
    //   92: aload_0
    //   93: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   96: aload #7
    //   98: invokevirtual extensionNumber : (Ljava/util/Map$Entry;)I
    //   101: iload #6
    //   103: if_icmpgt -> 147
    //   106: aload_0
    //   107: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   110: aload_2
    //   111: aload #7
    //   113: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   116: aload #9
    //   118: invokeinterface hasNext : ()Z
    //   123: ifeq -> 141
    //   126: aload #9
    //   128: invokeinterface next : ()Ljava/lang/Object;
    //   133: checkcast java/util/Map$Entry
    //   136: astore #7
    //   138: goto -> 87
    //   141: aconst_null
    //   142: astore #7
    //   144: goto -> 87
    //   147: iload #5
    //   149: invokestatic type : (I)I
    //   152: tableswitch default -> 444, 0 -> 2348, 1 -> 2319, 2 -> 2290, 3 -> 2261, 4 -> 2232, 5 -> 2203, 6 -> 2174, 7 -> 2145, 8 -> 2117, 9 -> 2083, 10 -> 2051, 11 -> 2022, 12 -> 1993, 13 -> 1964, 14 -> 1935, 15 -> 1906, 16 -> 1877, 17 -> 1843, 18 -> 1818, 19 -> 1793, 20 -> 1768, 21 -> 1743, 22 -> 1718, 23 -> 1693, 24 -> 1668, 25 -> 1643, 26 -> 1619, 27 -> 1590, 28 -> 1566, 29 -> 1541, 30 -> 1516, 31 -> 1491, 32 -> 1466, 33 -> 1441, 34 -> 1416, 35 -> 1391, 36 -> 1366, 37 -> 1341, 38 -> 1316, 39 -> 1291, 40 -> 1266, 41 -> 1241, 42 -> 1216, 43 -> 1191, 44 -> 1166, 45 -> 1141, 46 -> 1116, 47 -> 1091, 48 -> 1066, 49 -> 1037, 50 -> 1017, 51 -> 986, 52 -> 955, 53 -> 924, 54 -> 893, 55 -> 862, 56 -> 831, 57 -> 800, 58 -> 769, 59 -> 739, 60 -> 703, 61 -> 669, 62 -> 638, 63 -> 607, 64 -> 576, 65 -> 545, 66 -> 514, 67 -> 483, 68 -> 447
    //   444: goto -> 2374
    //   447: aload_0
    //   448: aload_1
    //   449: iload #6
    //   451: iload_3
    //   452: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   455: ifeq -> 2374
    //   458: aload_2
    //   459: iload #6
    //   461: aload_1
    //   462: iload #5
    //   464: invokestatic offset : (I)J
    //   467: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   470: aload_0
    //   471: iload_3
    //   472: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   475: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   480: goto -> 2374
    //   483: aload_0
    //   484: aload_1
    //   485: iload #6
    //   487: iload_3
    //   488: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   491: ifeq -> 2374
    //   494: aload_2
    //   495: iload #6
    //   497: aload_1
    //   498: iload #5
    //   500: invokestatic offset : (I)J
    //   503: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   506: invokeinterface writeSInt64 : (IJ)V
    //   511: goto -> 2374
    //   514: aload_0
    //   515: aload_1
    //   516: iload #6
    //   518: iload_3
    //   519: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   522: ifeq -> 2374
    //   525: aload_2
    //   526: iload #6
    //   528: aload_1
    //   529: iload #5
    //   531: invokestatic offset : (I)J
    //   534: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   537: invokeinterface writeSInt32 : (II)V
    //   542: goto -> 2374
    //   545: aload_0
    //   546: aload_1
    //   547: iload #6
    //   549: iload_3
    //   550: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   553: ifeq -> 2374
    //   556: aload_2
    //   557: iload #6
    //   559: aload_1
    //   560: iload #5
    //   562: invokestatic offset : (I)J
    //   565: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   568: invokeinterface writeSFixed64 : (IJ)V
    //   573: goto -> 2374
    //   576: aload_0
    //   577: aload_1
    //   578: iload #6
    //   580: iload_3
    //   581: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   584: ifeq -> 2374
    //   587: aload_2
    //   588: iload #6
    //   590: aload_1
    //   591: iload #5
    //   593: invokestatic offset : (I)J
    //   596: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   599: invokeinterface writeSFixed32 : (II)V
    //   604: goto -> 2374
    //   607: aload_0
    //   608: aload_1
    //   609: iload #6
    //   611: iload_3
    //   612: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   615: ifeq -> 2374
    //   618: aload_2
    //   619: iload #6
    //   621: aload_1
    //   622: iload #5
    //   624: invokestatic offset : (I)J
    //   627: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   630: invokeinterface writeEnum : (II)V
    //   635: goto -> 2374
    //   638: aload_0
    //   639: aload_1
    //   640: iload #6
    //   642: iload_3
    //   643: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   646: ifeq -> 2374
    //   649: aload_2
    //   650: iload #6
    //   652: aload_1
    //   653: iload #5
    //   655: invokestatic offset : (I)J
    //   658: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   661: invokeinterface writeUInt32 : (II)V
    //   666: goto -> 2374
    //   669: aload_0
    //   670: aload_1
    //   671: iload #6
    //   673: iload_3
    //   674: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   677: ifeq -> 2374
    //   680: aload_2
    //   681: iload #6
    //   683: aload_1
    //   684: iload #5
    //   686: invokestatic offset : (I)J
    //   689: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   692: checkcast com/google/protobuf/ByteString
    //   695: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   700: goto -> 2374
    //   703: aload_0
    //   704: aload_1
    //   705: iload #6
    //   707: iload_3
    //   708: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   711: ifeq -> 2374
    //   714: aload_2
    //   715: iload #6
    //   717: aload_1
    //   718: iload #5
    //   720: invokestatic offset : (I)J
    //   723: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   726: aload_0
    //   727: iload_3
    //   728: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   731: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   736: goto -> 2374
    //   739: aload_0
    //   740: aload_1
    //   741: iload #6
    //   743: iload_3
    //   744: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   747: ifeq -> 2374
    //   750: aload_0
    //   751: iload #6
    //   753: aload_1
    //   754: iload #5
    //   756: invokestatic offset : (I)J
    //   759: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   762: aload_2
    //   763: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   766: goto -> 2374
    //   769: aload_0
    //   770: aload_1
    //   771: iload #6
    //   773: iload_3
    //   774: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   777: ifeq -> 2374
    //   780: aload_2
    //   781: iload #6
    //   783: aload_1
    //   784: iload #5
    //   786: invokestatic offset : (I)J
    //   789: invokestatic oneofBooleanAt : (Ljava/lang/Object;J)Z
    //   792: invokeinterface writeBool : (IZ)V
    //   797: goto -> 2374
    //   800: aload_0
    //   801: aload_1
    //   802: iload #6
    //   804: iload_3
    //   805: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   808: ifeq -> 2374
    //   811: aload_2
    //   812: iload #6
    //   814: aload_1
    //   815: iload #5
    //   817: invokestatic offset : (I)J
    //   820: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   823: invokeinterface writeFixed32 : (II)V
    //   828: goto -> 2374
    //   831: aload_0
    //   832: aload_1
    //   833: iload #6
    //   835: iload_3
    //   836: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   839: ifeq -> 2374
    //   842: aload_2
    //   843: iload #6
    //   845: aload_1
    //   846: iload #5
    //   848: invokestatic offset : (I)J
    //   851: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   854: invokeinterface writeFixed64 : (IJ)V
    //   859: goto -> 2374
    //   862: aload_0
    //   863: aload_1
    //   864: iload #6
    //   866: iload_3
    //   867: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   870: ifeq -> 2374
    //   873: aload_2
    //   874: iload #6
    //   876: aload_1
    //   877: iload #5
    //   879: invokestatic offset : (I)J
    //   882: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   885: invokeinterface writeInt32 : (II)V
    //   890: goto -> 2374
    //   893: aload_0
    //   894: aload_1
    //   895: iload #6
    //   897: iload_3
    //   898: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   901: ifeq -> 2374
    //   904: aload_2
    //   905: iload #6
    //   907: aload_1
    //   908: iload #5
    //   910: invokestatic offset : (I)J
    //   913: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   916: invokeinterface writeUInt64 : (IJ)V
    //   921: goto -> 2374
    //   924: aload_0
    //   925: aload_1
    //   926: iload #6
    //   928: iload_3
    //   929: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   932: ifeq -> 2374
    //   935: aload_2
    //   936: iload #6
    //   938: aload_1
    //   939: iload #5
    //   941: invokestatic offset : (I)J
    //   944: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   947: invokeinterface writeInt64 : (IJ)V
    //   952: goto -> 2374
    //   955: aload_0
    //   956: aload_1
    //   957: iload #6
    //   959: iload_3
    //   960: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   963: ifeq -> 2374
    //   966: aload_2
    //   967: iload #6
    //   969: aload_1
    //   970: iload #5
    //   972: invokestatic offset : (I)J
    //   975: invokestatic oneofFloatAt : (Ljava/lang/Object;J)F
    //   978: invokeinterface writeFloat : (IF)V
    //   983: goto -> 2374
    //   986: aload_0
    //   987: aload_1
    //   988: iload #6
    //   990: iload_3
    //   991: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   994: ifeq -> 2374
    //   997: aload_2
    //   998: iload #6
    //   1000: aload_1
    //   1001: iload #5
    //   1003: invokestatic offset : (I)J
    //   1006: invokestatic oneofDoubleAt : (Ljava/lang/Object;J)D
    //   1009: invokeinterface writeDouble : (ID)V
    //   1014: goto -> 2374
    //   1017: aload_0
    //   1018: aload_2
    //   1019: iload #6
    //   1021: aload_1
    //   1022: iload #5
    //   1024: invokestatic offset : (I)J
    //   1027: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1030: iload_3
    //   1031: invokespecial writeMapHelper : (Lcom/google/protobuf/Writer;ILjava/lang/Object;I)V
    //   1034: goto -> 2374
    //   1037: aload_0
    //   1038: iload_3
    //   1039: invokespecial numberAt : (I)I
    //   1042: aload_1
    //   1043: iload #5
    //   1045: invokestatic offset : (I)J
    //   1048: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1051: checkcast java/util/List
    //   1054: aload_2
    //   1055: aload_0
    //   1056: iload_3
    //   1057: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1060: invokestatic writeGroupList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1063: goto -> 2374
    //   1066: aload_0
    //   1067: iload_3
    //   1068: invokespecial numberAt : (I)I
    //   1071: aload_1
    //   1072: iload #5
    //   1074: invokestatic offset : (I)J
    //   1077: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1080: checkcast java/util/List
    //   1083: aload_2
    //   1084: iconst_1
    //   1085: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1088: goto -> 2374
    //   1091: aload_0
    //   1092: iload_3
    //   1093: invokespecial numberAt : (I)I
    //   1096: aload_1
    //   1097: iload #5
    //   1099: invokestatic offset : (I)J
    //   1102: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1105: checkcast java/util/List
    //   1108: aload_2
    //   1109: iconst_1
    //   1110: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1113: goto -> 2374
    //   1116: aload_0
    //   1117: iload_3
    //   1118: invokespecial numberAt : (I)I
    //   1121: aload_1
    //   1122: iload #5
    //   1124: invokestatic offset : (I)J
    //   1127: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1130: checkcast java/util/List
    //   1133: aload_2
    //   1134: iconst_1
    //   1135: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1138: goto -> 2374
    //   1141: aload_0
    //   1142: iload_3
    //   1143: invokespecial numberAt : (I)I
    //   1146: aload_1
    //   1147: iload #5
    //   1149: invokestatic offset : (I)J
    //   1152: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1155: checkcast java/util/List
    //   1158: aload_2
    //   1159: iconst_1
    //   1160: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1163: goto -> 2374
    //   1166: aload_0
    //   1167: iload_3
    //   1168: invokespecial numberAt : (I)I
    //   1171: aload_1
    //   1172: iload #5
    //   1174: invokestatic offset : (I)J
    //   1177: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1180: checkcast java/util/List
    //   1183: aload_2
    //   1184: iconst_1
    //   1185: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1188: goto -> 2374
    //   1191: aload_0
    //   1192: iload_3
    //   1193: invokespecial numberAt : (I)I
    //   1196: aload_1
    //   1197: iload #5
    //   1199: invokestatic offset : (I)J
    //   1202: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1205: checkcast java/util/List
    //   1208: aload_2
    //   1209: iconst_1
    //   1210: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1213: goto -> 2374
    //   1216: aload_0
    //   1217: iload_3
    //   1218: invokespecial numberAt : (I)I
    //   1221: aload_1
    //   1222: iload #5
    //   1224: invokestatic offset : (I)J
    //   1227: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1230: checkcast java/util/List
    //   1233: aload_2
    //   1234: iconst_1
    //   1235: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1238: goto -> 2374
    //   1241: aload_0
    //   1242: iload_3
    //   1243: invokespecial numberAt : (I)I
    //   1246: aload_1
    //   1247: iload #5
    //   1249: invokestatic offset : (I)J
    //   1252: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1255: checkcast java/util/List
    //   1258: aload_2
    //   1259: iconst_1
    //   1260: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1263: goto -> 2374
    //   1266: aload_0
    //   1267: iload_3
    //   1268: invokespecial numberAt : (I)I
    //   1271: aload_1
    //   1272: iload #5
    //   1274: invokestatic offset : (I)J
    //   1277: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1280: checkcast java/util/List
    //   1283: aload_2
    //   1284: iconst_1
    //   1285: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1288: goto -> 2374
    //   1291: aload_0
    //   1292: iload_3
    //   1293: invokespecial numberAt : (I)I
    //   1296: aload_1
    //   1297: iload #5
    //   1299: invokestatic offset : (I)J
    //   1302: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1305: checkcast java/util/List
    //   1308: aload_2
    //   1309: iconst_1
    //   1310: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1313: goto -> 2374
    //   1316: aload_0
    //   1317: iload_3
    //   1318: invokespecial numberAt : (I)I
    //   1321: aload_1
    //   1322: iload #5
    //   1324: invokestatic offset : (I)J
    //   1327: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1330: checkcast java/util/List
    //   1333: aload_2
    //   1334: iconst_1
    //   1335: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1338: goto -> 2374
    //   1341: aload_0
    //   1342: iload_3
    //   1343: invokespecial numberAt : (I)I
    //   1346: aload_1
    //   1347: iload #5
    //   1349: invokestatic offset : (I)J
    //   1352: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1355: checkcast java/util/List
    //   1358: aload_2
    //   1359: iconst_1
    //   1360: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1363: goto -> 2374
    //   1366: aload_0
    //   1367: iload_3
    //   1368: invokespecial numberAt : (I)I
    //   1371: aload_1
    //   1372: iload #5
    //   1374: invokestatic offset : (I)J
    //   1377: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1380: checkcast java/util/List
    //   1383: aload_2
    //   1384: iconst_1
    //   1385: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1388: goto -> 2374
    //   1391: aload_0
    //   1392: iload_3
    //   1393: invokespecial numberAt : (I)I
    //   1396: aload_1
    //   1397: iload #5
    //   1399: invokestatic offset : (I)J
    //   1402: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1405: checkcast java/util/List
    //   1408: aload_2
    //   1409: iconst_1
    //   1410: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1413: goto -> 2374
    //   1416: aload_0
    //   1417: iload_3
    //   1418: invokespecial numberAt : (I)I
    //   1421: aload_1
    //   1422: iload #5
    //   1424: invokestatic offset : (I)J
    //   1427: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1430: checkcast java/util/List
    //   1433: aload_2
    //   1434: iconst_0
    //   1435: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1438: goto -> 2374
    //   1441: aload_0
    //   1442: iload_3
    //   1443: invokespecial numberAt : (I)I
    //   1446: aload_1
    //   1447: iload #5
    //   1449: invokestatic offset : (I)J
    //   1452: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1455: checkcast java/util/List
    //   1458: aload_2
    //   1459: iconst_0
    //   1460: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1463: goto -> 2374
    //   1466: aload_0
    //   1467: iload_3
    //   1468: invokespecial numberAt : (I)I
    //   1471: aload_1
    //   1472: iload #5
    //   1474: invokestatic offset : (I)J
    //   1477: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1480: checkcast java/util/List
    //   1483: aload_2
    //   1484: iconst_0
    //   1485: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1488: goto -> 2374
    //   1491: aload_0
    //   1492: iload_3
    //   1493: invokespecial numberAt : (I)I
    //   1496: aload_1
    //   1497: iload #5
    //   1499: invokestatic offset : (I)J
    //   1502: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1505: checkcast java/util/List
    //   1508: aload_2
    //   1509: iconst_0
    //   1510: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1513: goto -> 2374
    //   1516: aload_0
    //   1517: iload_3
    //   1518: invokespecial numberAt : (I)I
    //   1521: aload_1
    //   1522: iload #5
    //   1524: invokestatic offset : (I)J
    //   1527: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1530: checkcast java/util/List
    //   1533: aload_2
    //   1534: iconst_0
    //   1535: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1538: goto -> 2374
    //   1541: aload_0
    //   1542: iload_3
    //   1543: invokespecial numberAt : (I)I
    //   1546: aload_1
    //   1547: iload #5
    //   1549: invokestatic offset : (I)J
    //   1552: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1555: checkcast java/util/List
    //   1558: aload_2
    //   1559: iconst_0
    //   1560: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1563: goto -> 2374
    //   1566: aload_0
    //   1567: iload_3
    //   1568: invokespecial numberAt : (I)I
    //   1571: aload_1
    //   1572: iload #5
    //   1574: invokestatic offset : (I)J
    //   1577: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1580: checkcast java/util/List
    //   1583: aload_2
    //   1584: invokestatic writeBytesList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1587: goto -> 2374
    //   1590: aload_0
    //   1591: iload_3
    //   1592: invokespecial numberAt : (I)I
    //   1595: aload_1
    //   1596: iload #5
    //   1598: invokestatic offset : (I)J
    //   1601: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1604: checkcast java/util/List
    //   1607: aload_2
    //   1608: aload_0
    //   1609: iload_3
    //   1610: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1613: invokestatic writeMessageList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1616: goto -> 2374
    //   1619: aload_0
    //   1620: iload_3
    //   1621: invokespecial numberAt : (I)I
    //   1624: aload_1
    //   1625: iload #5
    //   1627: invokestatic offset : (I)J
    //   1630: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1633: checkcast java/util/List
    //   1636: aload_2
    //   1637: invokestatic writeStringList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1640: goto -> 2374
    //   1643: aload_0
    //   1644: iload_3
    //   1645: invokespecial numberAt : (I)I
    //   1648: aload_1
    //   1649: iload #5
    //   1651: invokestatic offset : (I)J
    //   1654: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1657: checkcast java/util/List
    //   1660: aload_2
    //   1661: iconst_0
    //   1662: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1665: goto -> 2374
    //   1668: aload_0
    //   1669: iload_3
    //   1670: invokespecial numberAt : (I)I
    //   1673: aload_1
    //   1674: iload #5
    //   1676: invokestatic offset : (I)J
    //   1679: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1682: checkcast java/util/List
    //   1685: aload_2
    //   1686: iconst_0
    //   1687: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1690: goto -> 2374
    //   1693: aload_0
    //   1694: iload_3
    //   1695: invokespecial numberAt : (I)I
    //   1698: aload_1
    //   1699: iload #5
    //   1701: invokestatic offset : (I)J
    //   1704: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1707: checkcast java/util/List
    //   1710: aload_2
    //   1711: iconst_0
    //   1712: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1715: goto -> 2374
    //   1718: aload_0
    //   1719: iload_3
    //   1720: invokespecial numberAt : (I)I
    //   1723: aload_1
    //   1724: iload #5
    //   1726: invokestatic offset : (I)J
    //   1729: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1732: checkcast java/util/List
    //   1735: aload_2
    //   1736: iconst_0
    //   1737: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1740: goto -> 2374
    //   1743: aload_0
    //   1744: iload_3
    //   1745: invokespecial numberAt : (I)I
    //   1748: aload_1
    //   1749: iload #5
    //   1751: invokestatic offset : (I)J
    //   1754: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1757: checkcast java/util/List
    //   1760: aload_2
    //   1761: iconst_0
    //   1762: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1765: goto -> 2374
    //   1768: aload_0
    //   1769: iload_3
    //   1770: invokespecial numberAt : (I)I
    //   1773: aload_1
    //   1774: iload #5
    //   1776: invokestatic offset : (I)J
    //   1779: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1782: checkcast java/util/List
    //   1785: aload_2
    //   1786: iconst_0
    //   1787: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1790: goto -> 2374
    //   1793: aload_0
    //   1794: iload_3
    //   1795: invokespecial numberAt : (I)I
    //   1798: aload_1
    //   1799: iload #5
    //   1801: invokestatic offset : (I)J
    //   1804: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1807: checkcast java/util/List
    //   1810: aload_2
    //   1811: iconst_0
    //   1812: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1815: goto -> 2374
    //   1818: aload_0
    //   1819: iload_3
    //   1820: invokespecial numberAt : (I)I
    //   1823: aload_1
    //   1824: iload #5
    //   1826: invokestatic offset : (I)J
    //   1829: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1832: checkcast java/util/List
    //   1835: aload_2
    //   1836: iconst_0
    //   1837: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1840: goto -> 2374
    //   1843: aload_0
    //   1844: aload_1
    //   1845: iload_3
    //   1846: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1849: ifeq -> 2374
    //   1852: aload_2
    //   1853: iload #6
    //   1855: aload_1
    //   1856: iload #5
    //   1858: invokestatic offset : (I)J
    //   1861: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1864: aload_0
    //   1865: iload_3
    //   1866: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1869: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   1874: goto -> 2374
    //   1877: aload_0
    //   1878: aload_1
    //   1879: iload_3
    //   1880: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1883: ifeq -> 2374
    //   1886: aload_2
    //   1887: iload #6
    //   1889: aload_1
    //   1890: iload #5
    //   1892: invokestatic offset : (I)J
    //   1895: invokestatic longAt : (Ljava/lang/Object;J)J
    //   1898: invokeinterface writeSInt64 : (IJ)V
    //   1903: goto -> 2374
    //   1906: aload_0
    //   1907: aload_1
    //   1908: iload_3
    //   1909: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1912: ifeq -> 2374
    //   1915: aload_2
    //   1916: iload #6
    //   1918: aload_1
    //   1919: iload #5
    //   1921: invokestatic offset : (I)J
    //   1924: invokestatic intAt : (Ljava/lang/Object;J)I
    //   1927: invokeinterface writeSInt32 : (II)V
    //   1932: goto -> 2374
    //   1935: aload_0
    //   1936: aload_1
    //   1937: iload_3
    //   1938: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1941: ifeq -> 2374
    //   1944: aload_2
    //   1945: iload #6
    //   1947: aload_1
    //   1948: iload #5
    //   1950: invokestatic offset : (I)J
    //   1953: invokestatic longAt : (Ljava/lang/Object;J)J
    //   1956: invokeinterface writeSFixed64 : (IJ)V
    //   1961: goto -> 2374
    //   1964: aload_0
    //   1965: aload_1
    //   1966: iload_3
    //   1967: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1970: ifeq -> 2374
    //   1973: aload_2
    //   1974: iload #6
    //   1976: aload_1
    //   1977: iload #5
    //   1979: invokestatic offset : (I)J
    //   1982: invokestatic intAt : (Ljava/lang/Object;J)I
    //   1985: invokeinterface writeSFixed32 : (II)V
    //   1990: goto -> 2374
    //   1993: aload_0
    //   1994: aload_1
    //   1995: iload_3
    //   1996: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1999: ifeq -> 2374
    //   2002: aload_2
    //   2003: iload #6
    //   2005: aload_1
    //   2006: iload #5
    //   2008: invokestatic offset : (I)J
    //   2011: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2014: invokeinterface writeEnum : (II)V
    //   2019: goto -> 2374
    //   2022: aload_0
    //   2023: aload_1
    //   2024: iload_3
    //   2025: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2028: ifeq -> 2374
    //   2031: aload_2
    //   2032: iload #6
    //   2034: aload_1
    //   2035: iload #5
    //   2037: invokestatic offset : (I)J
    //   2040: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2043: invokeinterface writeUInt32 : (II)V
    //   2048: goto -> 2374
    //   2051: aload_0
    //   2052: aload_1
    //   2053: iload_3
    //   2054: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2057: ifeq -> 2374
    //   2060: aload_2
    //   2061: iload #6
    //   2063: aload_1
    //   2064: iload #5
    //   2066: invokestatic offset : (I)J
    //   2069: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2072: checkcast com/google/protobuf/ByteString
    //   2075: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   2080: goto -> 2374
    //   2083: aload_0
    //   2084: aload_1
    //   2085: iload_3
    //   2086: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2089: ifeq -> 2374
    //   2092: aload_2
    //   2093: iload #6
    //   2095: aload_1
    //   2096: iload #5
    //   2098: invokestatic offset : (I)J
    //   2101: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2104: aload_0
    //   2105: iload_3
    //   2106: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2109: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   2114: goto -> 2374
    //   2117: aload_0
    //   2118: aload_1
    //   2119: iload_3
    //   2120: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2123: ifeq -> 2374
    //   2126: aload_0
    //   2127: iload #6
    //   2129: aload_1
    //   2130: iload #5
    //   2132: invokestatic offset : (I)J
    //   2135: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2138: aload_2
    //   2139: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   2142: goto -> 2374
    //   2145: aload_0
    //   2146: aload_1
    //   2147: iload_3
    //   2148: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2151: ifeq -> 2374
    //   2154: aload_2
    //   2155: iload #6
    //   2157: aload_1
    //   2158: iload #5
    //   2160: invokestatic offset : (I)J
    //   2163: invokestatic booleanAt : (Ljava/lang/Object;J)Z
    //   2166: invokeinterface writeBool : (IZ)V
    //   2171: goto -> 2374
    //   2174: aload_0
    //   2175: aload_1
    //   2176: iload_3
    //   2177: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2180: ifeq -> 2374
    //   2183: aload_2
    //   2184: iload #6
    //   2186: aload_1
    //   2187: iload #5
    //   2189: invokestatic offset : (I)J
    //   2192: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2195: invokeinterface writeFixed32 : (II)V
    //   2200: goto -> 2374
    //   2203: aload_0
    //   2204: aload_1
    //   2205: iload_3
    //   2206: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2209: ifeq -> 2374
    //   2212: aload_2
    //   2213: iload #6
    //   2215: aload_1
    //   2216: iload #5
    //   2218: invokestatic offset : (I)J
    //   2221: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2224: invokeinterface writeFixed64 : (IJ)V
    //   2229: goto -> 2374
    //   2232: aload_0
    //   2233: aload_1
    //   2234: iload_3
    //   2235: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2238: ifeq -> 2374
    //   2241: aload_2
    //   2242: iload #6
    //   2244: aload_1
    //   2245: iload #5
    //   2247: invokestatic offset : (I)J
    //   2250: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2253: invokeinterface writeInt32 : (II)V
    //   2258: goto -> 2374
    //   2261: aload_0
    //   2262: aload_1
    //   2263: iload_3
    //   2264: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2267: ifeq -> 2374
    //   2270: aload_2
    //   2271: iload #6
    //   2273: aload_1
    //   2274: iload #5
    //   2276: invokestatic offset : (I)J
    //   2279: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2282: invokeinterface writeUInt64 : (IJ)V
    //   2287: goto -> 2374
    //   2290: aload_0
    //   2291: aload_1
    //   2292: iload_3
    //   2293: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2296: ifeq -> 2374
    //   2299: aload_2
    //   2300: iload #6
    //   2302: aload_1
    //   2303: iload #5
    //   2305: invokestatic offset : (I)J
    //   2308: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2311: invokeinterface writeInt64 : (IJ)V
    //   2316: goto -> 2374
    //   2319: aload_0
    //   2320: aload_1
    //   2321: iload_3
    //   2322: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2325: ifeq -> 2374
    //   2328: aload_2
    //   2329: iload #6
    //   2331: aload_1
    //   2332: iload #5
    //   2334: invokestatic offset : (I)J
    //   2337: invokestatic floatAt : (Ljava/lang/Object;J)F
    //   2340: invokeinterface writeFloat : (IF)V
    //   2345: goto -> 2374
    //   2348: aload_0
    //   2349: aload_1
    //   2350: iload_3
    //   2351: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2354: ifeq -> 2374
    //   2357: aload_2
    //   2358: iload #6
    //   2360: aload_1
    //   2361: iload #5
    //   2363: invokestatic offset : (I)J
    //   2366: invokestatic doubleAt : (Ljava/lang/Object;J)D
    //   2369: invokeinterface writeDouble : (ID)V
    //   2374: iload_3
    //   2375: iconst_3
    //   2376: iadd
    //   2377: istore_3
    //   2378: goto -> 63
    //   2381: aload #8
    //   2383: ifnull -> 2427
    //   2386: aload_0
    //   2387: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   2390: aload_2
    //   2391: aload #8
    //   2393: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   2396: aload #9
    //   2398: invokeinterface hasNext : ()Z
    //   2403: ifeq -> 2421
    //   2406: aload #9
    //   2408: invokeinterface next : ()Ljava/lang/Object;
    //   2413: checkcast java/util/Map$Entry
    //   2416: astore #8
    //   2418: goto -> 2381
    //   2421: aconst_null
    //   2422: astore #8
    //   2424: goto -> 2381
    //   2427: aload_0
    //   2428: aload_0
    //   2429: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   2432: aload_1
    //   2433: aload_2
    //   2434: invokespecial writeUnknownInMessageTo : (Lcom/google/protobuf/UnknownFieldSchema;Ljava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   2437: return
  }
  
  private void writeFieldsInDescendingOrder(T paramT, Writer paramWriter) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   5: aload_1
    //   6: aload_2
    //   7: invokespecial writeUnknownInMessageTo : (Lcom/google/protobuf/UnknownFieldSchema;Ljava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   10: aload_0
    //   11: getfield hasExtensions : Z
    //   14: ifeq -> 57
    //   17: aload_0
    //   18: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   21: aload_1
    //   22: invokevirtual getExtensions : (Ljava/lang/Object;)Lcom/google/protobuf/FieldSet;
    //   25: astore #6
    //   27: aload #6
    //   29: invokevirtual isEmpty : ()Z
    //   32: ifne -> 57
    //   35: aload #6
    //   37: invokevirtual descendingIterator : ()Ljava/util/Iterator;
    //   40: astore #8
    //   42: aload #8
    //   44: invokeinterface next : ()Ljava/lang/Object;
    //   49: checkcast java/util/Map$Entry
    //   52: astore #6
    //   54: goto -> 64
    //   57: aconst_null
    //   58: astore #8
    //   60: aload #8
    //   62: astore #6
    //   64: aload_0
    //   65: getfield buffer : [I
    //   68: arraylength
    //   69: iconst_3
    //   70: isub
    //   71: istore_3
    //   72: aload #6
    //   74: astore #7
    //   76: iload_3
    //   77: iflt -> 2385
    //   80: aload_0
    //   81: iload_3
    //   82: invokespecial typeAndOffsetAt : (I)I
    //   85: istore #4
    //   87: aload_0
    //   88: iload_3
    //   89: invokespecial numberAt : (I)I
    //   92: istore #5
    //   94: aload #6
    //   96: ifnull -> 154
    //   99: aload_0
    //   100: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   103: aload #6
    //   105: invokevirtual extensionNumber : (Ljava/util/Map$Entry;)I
    //   108: iload #5
    //   110: if_icmple -> 154
    //   113: aload_0
    //   114: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   117: aload_2
    //   118: aload #6
    //   120: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   123: aload #8
    //   125: invokeinterface hasNext : ()Z
    //   130: ifeq -> 148
    //   133: aload #8
    //   135: invokeinterface next : ()Ljava/lang/Object;
    //   140: checkcast java/util/Map$Entry
    //   143: astore #6
    //   145: goto -> 94
    //   148: aconst_null
    //   149: astore #6
    //   151: goto -> 94
    //   154: iload #4
    //   156: invokestatic type : (I)I
    //   159: tableswitch default -> 448, 0 -> 2352, 1 -> 2323, 2 -> 2294, 3 -> 2265, 4 -> 2236, 5 -> 2207, 6 -> 2178, 7 -> 2149, 8 -> 2121, 9 -> 2087, 10 -> 2055, 11 -> 2026, 12 -> 1997, 13 -> 1968, 14 -> 1939, 15 -> 1910, 16 -> 1881, 17 -> 1847, 18 -> 1822, 19 -> 1797, 20 -> 1772, 21 -> 1747, 22 -> 1722, 23 -> 1697, 24 -> 1672, 25 -> 1647, 26 -> 1623, 27 -> 1594, 28 -> 1570, 29 -> 1545, 30 -> 1520, 31 -> 1495, 32 -> 1470, 33 -> 1445, 34 -> 1420, 35 -> 1395, 36 -> 1370, 37 -> 1345, 38 -> 1320, 39 -> 1295, 40 -> 1270, 41 -> 1245, 42 -> 1220, 43 -> 1195, 44 -> 1170, 45 -> 1145, 46 -> 1120, 47 -> 1095, 48 -> 1070, 49 -> 1041, 50 -> 1021, 51 -> 990, 52 -> 959, 53 -> 928, 54 -> 897, 55 -> 866, 56 -> 835, 57 -> 804, 58 -> 773, 59 -> 743, 60 -> 707, 61 -> 673, 62 -> 642, 63 -> 611, 64 -> 580, 65 -> 549, 66 -> 518, 67 -> 487, 68 -> 451
    //   448: goto -> 2378
    //   451: aload_0
    //   452: aload_1
    //   453: iload #5
    //   455: iload_3
    //   456: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   459: ifeq -> 2378
    //   462: aload_2
    //   463: iload #5
    //   465: aload_1
    //   466: iload #4
    //   468: invokestatic offset : (I)J
    //   471: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   474: aload_0
    //   475: iload_3
    //   476: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   479: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   484: goto -> 2378
    //   487: aload_0
    //   488: aload_1
    //   489: iload #5
    //   491: iload_3
    //   492: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   495: ifeq -> 2378
    //   498: aload_2
    //   499: iload #5
    //   501: aload_1
    //   502: iload #4
    //   504: invokestatic offset : (I)J
    //   507: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   510: invokeinterface writeSInt64 : (IJ)V
    //   515: goto -> 2378
    //   518: aload_0
    //   519: aload_1
    //   520: iload #5
    //   522: iload_3
    //   523: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   526: ifeq -> 2378
    //   529: aload_2
    //   530: iload #5
    //   532: aload_1
    //   533: iload #4
    //   535: invokestatic offset : (I)J
    //   538: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   541: invokeinterface writeSInt32 : (II)V
    //   546: goto -> 2378
    //   549: aload_0
    //   550: aload_1
    //   551: iload #5
    //   553: iload_3
    //   554: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   557: ifeq -> 2378
    //   560: aload_2
    //   561: iload #5
    //   563: aload_1
    //   564: iload #4
    //   566: invokestatic offset : (I)J
    //   569: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   572: invokeinterface writeSFixed64 : (IJ)V
    //   577: goto -> 2378
    //   580: aload_0
    //   581: aload_1
    //   582: iload #5
    //   584: iload_3
    //   585: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   588: ifeq -> 2378
    //   591: aload_2
    //   592: iload #5
    //   594: aload_1
    //   595: iload #4
    //   597: invokestatic offset : (I)J
    //   600: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   603: invokeinterface writeSFixed32 : (II)V
    //   608: goto -> 2378
    //   611: aload_0
    //   612: aload_1
    //   613: iload #5
    //   615: iload_3
    //   616: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   619: ifeq -> 2378
    //   622: aload_2
    //   623: iload #5
    //   625: aload_1
    //   626: iload #4
    //   628: invokestatic offset : (I)J
    //   631: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   634: invokeinterface writeEnum : (II)V
    //   639: goto -> 2378
    //   642: aload_0
    //   643: aload_1
    //   644: iload #5
    //   646: iload_3
    //   647: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   650: ifeq -> 2378
    //   653: aload_2
    //   654: iload #5
    //   656: aload_1
    //   657: iload #4
    //   659: invokestatic offset : (I)J
    //   662: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   665: invokeinterface writeUInt32 : (II)V
    //   670: goto -> 2378
    //   673: aload_0
    //   674: aload_1
    //   675: iload #5
    //   677: iload_3
    //   678: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   681: ifeq -> 2378
    //   684: aload_2
    //   685: iload #5
    //   687: aload_1
    //   688: iload #4
    //   690: invokestatic offset : (I)J
    //   693: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   696: checkcast com/google/protobuf/ByteString
    //   699: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   704: goto -> 2378
    //   707: aload_0
    //   708: aload_1
    //   709: iload #5
    //   711: iload_3
    //   712: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   715: ifeq -> 2378
    //   718: aload_2
    //   719: iload #5
    //   721: aload_1
    //   722: iload #4
    //   724: invokestatic offset : (I)J
    //   727: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   730: aload_0
    //   731: iload_3
    //   732: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   735: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   740: goto -> 2378
    //   743: aload_0
    //   744: aload_1
    //   745: iload #5
    //   747: iload_3
    //   748: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   751: ifeq -> 2378
    //   754: aload_0
    //   755: iload #5
    //   757: aload_1
    //   758: iload #4
    //   760: invokestatic offset : (I)J
    //   763: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   766: aload_2
    //   767: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   770: goto -> 2378
    //   773: aload_0
    //   774: aload_1
    //   775: iload #5
    //   777: iload_3
    //   778: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   781: ifeq -> 2378
    //   784: aload_2
    //   785: iload #5
    //   787: aload_1
    //   788: iload #4
    //   790: invokestatic offset : (I)J
    //   793: invokestatic oneofBooleanAt : (Ljava/lang/Object;J)Z
    //   796: invokeinterface writeBool : (IZ)V
    //   801: goto -> 2378
    //   804: aload_0
    //   805: aload_1
    //   806: iload #5
    //   808: iload_3
    //   809: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   812: ifeq -> 2378
    //   815: aload_2
    //   816: iload #5
    //   818: aload_1
    //   819: iload #4
    //   821: invokestatic offset : (I)J
    //   824: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   827: invokeinterface writeFixed32 : (II)V
    //   832: goto -> 2378
    //   835: aload_0
    //   836: aload_1
    //   837: iload #5
    //   839: iload_3
    //   840: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   843: ifeq -> 2378
    //   846: aload_2
    //   847: iload #5
    //   849: aload_1
    //   850: iload #4
    //   852: invokestatic offset : (I)J
    //   855: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   858: invokeinterface writeFixed64 : (IJ)V
    //   863: goto -> 2378
    //   866: aload_0
    //   867: aload_1
    //   868: iload #5
    //   870: iload_3
    //   871: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   874: ifeq -> 2378
    //   877: aload_2
    //   878: iload #5
    //   880: aload_1
    //   881: iload #4
    //   883: invokestatic offset : (I)J
    //   886: invokestatic oneofIntAt : (Ljava/lang/Object;J)I
    //   889: invokeinterface writeInt32 : (II)V
    //   894: goto -> 2378
    //   897: aload_0
    //   898: aload_1
    //   899: iload #5
    //   901: iload_3
    //   902: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   905: ifeq -> 2378
    //   908: aload_2
    //   909: iload #5
    //   911: aload_1
    //   912: iload #4
    //   914: invokestatic offset : (I)J
    //   917: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   920: invokeinterface writeUInt64 : (IJ)V
    //   925: goto -> 2378
    //   928: aload_0
    //   929: aload_1
    //   930: iload #5
    //   932: iload_3
    //   933: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   936: ifeq -> 2378
    //   939: aload_2
    //   940: iload #5
    //   942: aload_1
    //   943: iload #4
    //   945: invokestatic offset : (I)J
    //   948: invokestatic oneofLongAt : (Ljava/lang/Object;J)J
    //   951: invokeinterface writeInt64 : (IJ)V
    //   956: goto -> 2378
    //   959: aload_0
    //   960: aload_1
    //   961: iload #5
    //   963: iload_3
    //   964: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   967: ifeq -> 2378
    //   970: aload_2
    //   971: iload #5
    //   973: aload_1
    //   974: iload #4
    //   976: invokestatic offset : (I)J
    //   979: invokestatic oneofFloatAt : (Ljava/lang/Object;J)F
    //   982: invokeinterface writeFloat : (IF)V
    //   987: goto -> 2378
    //   990: aload_0
    //   991: aload_1
    //   992: iload #5
    //   994: iload_3
    //   995: invokespecial isOneofPresent : (Ljava/lang/Object;II)Z
    //   998: ifeq -> 2378
    //   1001: aload_2
    //   1002: iload #5
    //   1004: aload_1
    //   1005: iload #4
    //   1007: invokestatic offset : (I)J
    //   1010: invokestatic oneofDoubleAt : (Ljava/lang/Object;J)D
    //   1013: invokeinterface writeDouble : (ID)V
    //   1018: goto -> 2378
    //   1021: aload_0
    //   1022: aload_2
    //   1023: iload #5
    //   1025: aload_1
    //   1026: iload #4
    //   1028: invokestatic offset : (I)J
    //   1031: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1034: iload_3
    //   1035: invokespecial writeMapHelper : (Lcom/google/protobuf/Writer;ILjava/lang/Object;I)V
    //   1038: goto -> 2378
    //   1041: aload_0
    //   1042: iload_3
    //   1043: invokespecial numberAt : (I)I
    //   1046: aload_1
    //   1047: iload #4
    //   1049: invokestatic offset : (I)J
    //   1052: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1055: checkcast java/util/List
    //   1058: aload_2
    //   1059: aload_0
    //   1060: iload_3
    //   1061: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1064: invokestatic writeGroupList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1067: goto -> 2378
    //   1070: aload_0
    //   1071: iload_3
    //   1072: invokespecial numberAt : (I)I
    //   1075: aload_1
    //   1076: iload #4
    //   1078: invokestatic offset : (I)J
    //   1081: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1084: checkcast java/util/List
    //   1087: aload_2
    //   1088: iconst_1
    //   1089: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1092: goto -> 2378
    //   1095: aload_0
    //   1096: iload_3
    //   1097: invokespecial numberAt : (I)I
    //   1100: aload_1
    //   1101: iload #4
    //   1103: invokestatic offset : (I)J
    //   1106: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1109: checkcast java/util/List
    //   1112: aload_2
    //   1113: iconst_1
    //   1114: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1117: goto -> 2378
    //   1120: aload_0
    //   1121: iload_3
    //   1122: invokespecial numberAt : (I)I
    //   1125: aload_1
    //   1126: iload #4
    //   1128: invokestatic offset : (I)J
    //   1131: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1134: checkcast java/util/List
    //   1137: aload_2
    //   1138: iconst_1
    //   1139: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1142: goto -> 2378
    //   1145: aload_0
    //   1146: iload_3
    //   1147: invokespecial numberAt : (I)I
    //   1150: aload_1
    //   1151: iload #4
    //   1153: invokestatic offset : (I)J
    //   1156: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1159: checkcast java/util/List
    //   1162: aload_2
    //   1163: iconst_1
    //   1164: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1167: goto -> 2378
    //   1170: aload_0
    //   1171: iload_3
    //   1172: invokespecial numberAt : (I)I
    //   1175: aload_1
    //   1176: iload #4
    //   1178: invokestatic offset : (I)J
    //   1181: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1184: checkcast java/util/List
    //   1187: aload_2
    //   1188: iconst_1
    //   1189: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1192: goto -> 2378
    //   1195: aload_0
    //   1196: iload_3
    //   1197: invokespecial numberAt : (I)I
    //   1200: aload_1
    //   1201: iload #4
    //   1203: invokestatic offset : (I)J
    //   1206: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1209: checkcast java/util/List
    //   1212: aload_2
    //   1213: iconst_1
    //   1214: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1217: goto -> 2378
    //   1220: aload_0
    //   1221: iload_3
    //   1222: invokespecial numberAt : (I)I
    //   1225: aload_1
    //   1226: iload #4
    //   1228: invokestatic offset : (I)J
    //   1231: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1234: checkcast java/util/List
    //   1237: aload_2
    //   1238: iconst_1
    //   1239: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1242: goto -> 2378
    //   1245: aload_0
    //   1246: iload_3
    //   1247: invokespecial numberAt : (I)I
    //   1250: aload_1
    //   1251: iload #4
    //   1253: invokestatic offset : (I)J
    //   1256: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1259: checkcast java/util/List
    //   1262: aload_2
    //   1263: iconst_1
    //   1264: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1267: goto -> 2378
    //   1270: aload_0
    //   1271: iload_3
    //   1272: invokespecial numberAt : (I)I
    //   1275: aload_1
    //   1276: iload #4
    //   1278: invokestatic offset : (I)J
    //   1281: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1284: checkcast java/util/List
    //   1287: aload_2
    //   1288: iconst_1
    //   1289: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1292: goto -> 2378
    //   1295: aload_0
    //   1296: iload_3
    //   1297: invokespecial numberAt : (I)I
    //   1300: aload_1
    //   1301: iload #4
    //   1303: invokestatic offset : (I)J
    //   1306: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1309: checkcast java/util/List
    //   1312: aload_2
    //   1313: iconst_1
    //   1314: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1317: goto -> 2378
    //   1320: aload_0
    //   1321: iload_3
    //   1322: invokespecial numberAt : (I)I
    //   1325: aload_1
    //   1326: iload #4
    //   1328: invokestatic offset : (I)J
    //   1331: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1334: checkcast java/util/List
    //   1337: aload_2
    //   1338: iconst_1
    //   1339: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1342: goto -> 2378
    //   1345: aload_0
    //   1346: iload_3
    //   1347: invokespecial numberAt : (I)I
    //   1350: aload_1
    //   1351: iload #4
    //   1353: invokestatic offset : (I)J
    //   1356: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1359: checkcast java/util/List
    //   1362: aload_2
    //   1363: iconst_1
    //   1364: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1367: goto -> 2378
    //   1370: aload_0
    //   1371: iload_3
    //   1372: invokespecial numberAt : (I)I
    //   1375: aload_1
    //   1376: iload #4
    //   1378: invokestatic offset : (I)J
    //   1381: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1384: checkcast java/util/List
    //   1387: aload_2
    //   1388: iconst_1
    //   1389: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1392: goto -> 2378
    //   1395: aload_0
    //   1396: iload_3
    //   1397: invokespecial numberAt : (I)I
    //   1400: aload_1
    //   1401: iload #4
    //   1403: invokestatic offset : (I)J
    //   1406: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1409: checkcast java/util/List
    //   1412: aload_2
    //   1413: iconst_1
    //   1414: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1417: goto -> 2378
    //   1420: aload_0
    //   1421: iload_3
    //   1422: invokespecial numberAt : (I)I
    //   1425: aload_1
    //   1426: iload #4
    //   1428: invokestatic offset : (I)J
    //   1431: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1434: checkcast java/util/List
    //   1437: aload_2
    //   1438: iconst_0
    //   1439: invokestatic writeSInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1442: goto -> 2378
    //   1445: aload_0
    //   1446: iload_3
    //   1447: invokespecial numberAt : (I)I
    //   1450: aload_1
    //   1451: iload #4
    //   1453: invokestatic offset : (I)J
    //   1456: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1459: checkcast java/util/List
    //   1462: aload_2
    //   1463: iconst_0
    //   1464: invokestatic writeSInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1467: goto -> 2378
    //   1470: aload_0
    //   1471: iload_3
    //   1472: invokespecial numberAt : (I)I
    //   1475: aload_1
    //   1476: iload #4
    //   1478: invokestatic offset : (I)J
    //   1481: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1484: checkcast java/util/List
    //   1487: aload_2
    //   1488: iconst_0
    //   1489: invokestatic writeSFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1492: goto -> 2378
    //   1495: aload_0
    //   1496: iload_3
    //   1497: invokespecial numberAt : (I)I
    //   1500: aload_1
    //   1501: iload #4
    //   1503: invokestatic offset : (I)J
    //   1506: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1509: checkcast java/util/List
    //   1512: aload_2
    //   1513: iconst_0
    //   1514: invokestatic writeSFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1517: goto -> 2378
    //   1520: aload_0
    //   1521: iload_3
    //   1522: invokespecial numberAt : (I)I
    //   1525: aload_1
    //   1526: iload #4
    //   1528: invokestatic offset : (I)J
    //   1531: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1534: checkcast java/util/List
    //   1537: aload_2
    //   1538: iconst_0
    //   1539: invokestatic writeEnumList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1542: goto -> 2378
    //   1545: aload_0
    //   1546: iload_3
    //   1547: invokespecial numberAt : (I)I
    //   1550: aload_1
    //   1551: iload #4
    //   1553: invokestatic offset : (I)J
    //   1556: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1559: checkcast java/util/List
    //   1562: aload_2
    //   1563: iconst_0
    //   1564: invokestatic writeUInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1567: goto -> 2378
    //   1570: aload_0
    //   1571: iload_3
    //   1572: invokespecial numberAt : (I)I
    //   1575: aload_1
    //   1576: iload #4
    //   1578: invokestatic offset : (I)J
    //   1581: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1584: checkcast java/util/List
    //   1587: aload_2
    //   1588: invokestatic writeBytesList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1591: goto -> 2378
    //   1594: aload_0
    //   1595: iload_3
    //   1596: invokespecial numberAt : (I)I
    //   1599: aload_1
    //   1600: iload #4
    //   1602: invokestatic offset : (I)J
    //   1605: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1608: checkcast java/util/List
    //   1611: aload_2
    //   1612: aload_0
    //   1613: iload_3
    //   1614: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1617: invokestatic writeMessageList : (ILjava/util/List;Lcom/google/protobuf/Writer;Lcom/google/protobuf/Schema;)V
    //   1620: goto -> 2378
    //   1623: aload_0
    //   1624: iload_3
    //   1625: invokespecial numberAt : (I)I
    //   1628: aload_1
    //   1629: iload #4
    //   1631: invokestatic offset : (I)J
    //   1634: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1637: checkcast java/util/List
    //   1640: aload_2
    //   1641: invokestatic writeStringList : (ILjava/util/List;Lcom/google/protobuf/Writer;)V
    //   1644: goto -> 2378
    //   1647: aload_0
    //   1648: iload_3
    //   1649: invokespecial numberAt : (I)I
    //   1652: aload_1
    //   1653: iload #4
    //   1655: invokestatic offset : (I)J
    //   1658: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1661: checkcast java/util/List
    //   1664: aload_2
    //   1665: iconst_0
    //   1666: invokestatic writeBoolList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1669: goto -> 2378
    //   1672: aload_0
    //   1673: iload_3
    //   1674: invokespecial numberAt : (I)I
    //   1677: aload_1
    //   1678: iload #4
    //   1680: invokestatic offset : (I)J
    //   1683: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1686: checkcast java/util/List
    //   1689: aload_2
    //   1690: iconst_0
    //   1691: invokestatic writeFixed32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1694: goto -> 2378
    //   1697: aload_0
    //   1698: iload_3
    //   1699: invokespecial numberAt : (I)I
    //   1702: aload_1
    //   1703: iload #4
    //   1705: invokestatic offset : (I)J
    //   1708: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1711: checkcast java/util/List
    //   1714: aload_2
    //   1715: iconst_0
    //   1716: invokestatic writeFixed64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1719: goto -> 2378
    //   1722: aload_0
    //   1723: iload_3
    //   1724: invokespecial numberAt : (I)I
    //   1727: aload_1
    //   1728: iload #4
    //   1730: invokestatic offset : (I)J
    //   1733: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1736: checkcast java/util/List
    //   1739: aload_2
    //   1740: iconst_0
    //   1741: invokestatic writeInt32List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1744: goto -> 2378
    //   1747: aload_0
    //   1748: iload_3
    //   1749: invokespecial numberAt : (I)I
    //   1752: aload_1
    //   1753: iload #4
    //   1755: invokestatic offset : (I)J
    //   1758: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1761: checkcast java/util/List
    //   1764: aload_2
    //   1765: iconst_0
    //   1766: invokestatic writeUInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1769: goto -> 2378
    //   1772: aload_0
    //   1773: iload_3
    //   1774: invokespecial numberAt : (I)I
    //   1777: aload_1
    //   1778: iload #4
    //   1780: invokestatic offset : (I)J
    //   1783: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1786: checkcast java/util/List
    //   1789: aload_2
    //   1790: iconst_0
    //   1791: invokestatic writeInt64List : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1794: goto -> 2378
    //   1797: aload_0
    //   1798: iload_3
    //   1799: invokespecial numberAt : (I)I
    //   1802: aload_1
    //   1803: iload #4
    //   1805: invokestatic offset : (I)J
    //   1808: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1811: checkcast java/util/List
    //   1814: aload_2
    //   1815: iconst_0
    //   1816: invokestatic writeFloatList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1819: goto -> 2378
    //   1822: aload_0
    //   1823: iload_3
    //   1824: invokespecial numberAt : (I)I
    //   1827: aload_1
    //   1828: iload #4
    //   1830: invokestatic offset : (I)J
    //   1833: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1836: checkcast java/util/List
    //   1839: aload_2
    //   1840: iconst_0
    //   1841: invokestatic writeDoubleList : (ILjava/util/List;Lcom/google/protobuf/Writer;Z)V
    //   1844: goto -> 2378
    //   1847: aload_0
    //   1848: aload_1
    //   1849: iload_3
    //   1850: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1853: ifeq -> 2378
    //   1856: aload_2
    //   1857: iload #5
    //   1859: aload_1
    //   1860: iload #4
    //   1862: invokestatic offset : (I)J
    //   1865: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1868: aload_0
    //   1869: iload_3
    //   1870: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1873: invokeinterface writeGroup : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   1878: goto -> 2378
    //   1881: aload_0
    //   1882: aload_1
    //   1883: iload_3
    //   1884: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1887: ifeq -> 2378
    //   1890: aload_2
    //   1891: iload #5
    //   1893: aload_1
    //   1894: iload #4
    //   1896: invokestatic offset : (I)J
    //   1899: invokestatic longAt : (Ljava/lang/Object;J)J
    //   1902: invokeinterface writeSInt64 : (IJ)V
    //   1907: goto -> 2378
    //   1910: aload_0
    //   1911: aload_1
    //   1912: iload_3
    //   1913: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1916: ifeq -> 2378
    //   1919: aload_2
    //   1920: iload #5
    //   1922: aload_1
    //   1923: iload #4
    //   1925: invokestatic offset : (I)J
    //   1928: invokestatic intAt : (Ljava/lang/Object;J)I
    //   1931: invokeinterface writeSInt32 : (II)V
    //   1936: goto -> 2378
    //   1939: aload_0
    //   1940: aload_1
    //   1941: iload_3
    //   1942: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1945: ifeq -> 2378
    //   1948: aload_2
    //   1949: iload #5
    //   1951: aload_1
    //   1952: iload #4
    //   1954: invokestatic offset : (I)J
    //   1957: invokestatic longAt : (Ljava/lang/Object;J)J
    //   1960: invokeinterface writeSFixed64 : (IJ)V
    //   1965: goto -> 2378
    //   1968: aload_0
    //   1969: aload_1
    //   1970: iload_3
    //   1971: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   1974: ifeq -> 2378
    //   1977: aload_2
    //   1978: iload #5
    //   1980: aload_1
    //   1981: iload #4
    //   1983: invokestatic offset : (I)J
    //   1986: invokestatic intAt : (Ljava/lang/Object;J)I
    //   1989: invokeinterface writeSFixed32 : (II)V
    //   1994: goto -> 2378
    //   1997: aload_0
    //   1998: aload_1
    //   1999: iload_3
    //   2000: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2003: ifeq -> 2378
    //   2006: aload_2
    //   2007: iload #5
    //   2009: aload_1
    //   2010: iload #4
    //   2012: invokestatic offset : (I)J
    //   2015: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2018: invokeinterface writeEnum : (II)V
    //   2023: goto -> 2378
    //   2026: aload_0
    //   2027: aload_1
    //   2028: iload_3
    //   2029: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2032: ifeq -> 2378
    //   2035: aload_2
    //   2036: iload #5
    //   2038: aload_1
    //   2039: iload #4
    //   2041: invokestatic offset : (I)J
    //   2044: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2047: invokeinterface writeUInt32 : (II)V
    //   2052: goto -> 2378
    //   2055: aload_0
    //   2056: aload_1
    //   2057: iload_3
    //   2058: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2061: ifeq -> 2378
    //   2064: aload_2
    //   2065: iload #5
    //   2067: aload_1
    //   2068: iload #4
    //   2070: invokestatic offset : (I)J
    //   2073: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2076: checkcast com/google/protobuf/ByteString
    //   2079: invokeinterface writeBytes : (ILcom/google/protobuf/ByteString;)V
    //   2084: goto -> 2378
    //   2087: aload_0
    //   2088: aload_1
    //   2089: iload_3
    //   2090: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2093: ifeq -> 2378
    //   2096: aload_2
    //   2097: iload #5
    //   2099: aload_1
    //   2100: iload #4
    //   2102: invokestatic offset : (I)J
    //   2105: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2108: aload_0
    //   2109: iload_3
    //   2110: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   2113: invokeinterface writeMessage : (ILjava/lang/Object;Lcom/google/protobuf/Schema;)V
    //   2118: goto -> 2378
    //   2121: aload_0
    //   2122: aload_1
    //   2123: iload_3
    //   2124: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2127: ifeq -> 2378
    //   2130: aload_0
    //   2131: iload #5
    //   2133: aload_1
    //   2134: iload #4
    //   2136: invokestatic offset : (I)J
    //   2139: invokestatic getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   2142: aload_2
    //   2143: invokespecial writeString : (ILjava/lang/Object;Lcom/google/protobuf/Writer;)V
    //   2146: goto -> 2378
    //   2149: aload_0
    //   2150: aload_1
    //   2151: iload_3
    //   2152: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2155: ifeq -> 2378
    //   2158: aload_2
    //   2159: iload #5
    //   2161: aload_1
    //   2162: iload #4
    //   2164: invokestatic offset : (I)J
    //   2167: invokestatic booleanAt : (Ljava/lang/Object;J)Z
    //   2170: invokeinterface writeBool : (IZ)V
    //   2175: goto -> 2378
    //   2178: aload_0
    //   2179: aload_1
    //   2180: iload_3
    //   2181: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2184: ifeq -> 2378
    //   2187: aload_2
    //   2188: iload #5
    //   2190: aload_1
    //   2191: iload #4
    //   2193: invokestatic offset : (I)J
    //   2196: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2199: invokeinterface writeFixed32 : (II)V
    //   2204: goto -> 2378
    //   2207: aload_0
    //   2208: aload_1
    //   2209: iload_3
    //   2210: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2213: ifeq -> 2378
    //   2216: aload_2
    //   2217: iload #5
    //   2219: aload_1
    //   2220: iload #4
    //   2222: invokestatic offset : (I)J
    //   2225: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2228: invokeinterface writeFixed64 : (IJ)V
    //   2233: goto -> 2378
    //   2236: aload_0
    //   2237: aload_1
    //   2238: iload_3
    //   2239: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2242: ifeq -> 2378
    //   2245: aload_2
    //   2246: iload #5
    //   2248: aload_1
    //   2249: iload #4
    //   2251: invokestatic offset : (I)J
    //   2254: invokestatic intAt : (Ljava/lang/Object;J)I
    //   2257: invokeinterface writeInt32 : (II)V
    //   2262: goto -> 2378
    //   2265: aload_0
    //   2266: aload_1
    //   2267: iload_3
    //   2268: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2271: ifeq -> 2378
    //   2274: aload_2
    //   2275: iload #5
    //   2277: aload_1
    //   2278: iload #4
    //   2280: invokestatic offset : (I)J
    //   2283: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2286: invokeinterface writeUInt64 : (IJ)V
    //   2291: goto -> 2378
    //   2294: aload_0
    //   2295: aload_1
    //   2296: iload_3
    //   2297: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2300: ifeq -> 2378
    //   2303: aload_2
    //   2304: iload #5
    //   2306: aload_1
    //   2307: iload #4
    //   2309: invokestatic offset : (I)J
    //   2312: invokestatic longAt : (Ljava/lang/Object;J)J
    //   2315: invokeinterface writeInt64 : (IJ)V
    //   2320: goto -> 2378
    //   2323: aload_0
    //   2324: aload_1
    //   2325: iload_3
    //   2326: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2329: ifeq -> 2378
    //   2332: aload_2
    //   2333: iload #5
    //   2335: aload_1
    //   2336: iload #4
    //   2338: invokestatic offset : (I)J
    //   2341: invokestatic floatAt : (Ljava/lang/Object;J)F
    //   2344: invokeinterface writeFloat : (IF)V
    //   2349: goto -> 2378
    //   2352: aload_0
    //   2353: aload_1
    //   2354: iload_3
    //   2355: invokespecial isFieldPresent : (Ljava/lang/Object;I)Z
    //   2358: ifeq -> 2378
    //   2361: aload_2
    //   2362: iload #5
    //   2364: aload_1
    //   2365: iload #4
    //   2367: invokestatic offset : (I)J
    //   2370: invokestatic doubleAt : (Ljava/lang/Object;J)D
    //   2373: invokeinterface writeDouble : (ID)V
    //   2378: iload_3
    //   2379: iconst_3
    //   2380: isub
    //   2381: istore_3
    //   2382: goto -> 72
    //   2385: aload #7
    //   2387: ifnull -> 2431
    //   2390: aload_0
    //   2391: getfield extensionSchema : Lcom/google/protobuf/ExtensionSchema;
    //   2394: aload_2
    //   2395: aload #7
    //   2397: invokevirtual serializeExtension : (Lcom/google/protobuf/Writer;Ljava/util/Map$Entry;)V
    //   2400: aload #8
    //   2402: invokeinterface hasNext : ()Z
    //   2407: ifeq -> 2425
    //   2410: aload #8
    //   2412: invokeinterface next : ()Ljava/lang/Object;
    //   2417: checkcast java/util/Map$Entry
    //   2420: astore #7
    //   2422: goto -> 2385
    //   2425: aconst_null
    //   2426: astore #7
    //   2428: goto -> 2385
    //   2431: return
  }
  
  private <K, V> void writeMapHelper(Writer paramWriter, int paramInt1, Object paramObject, int paramInt2) throws IOException {
    if (paramObject != null)
      paramWriter.writeMap(paramInt1, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(paramInt2)), this.mapFieldSchema.forMapData(paramObject)); 
  }
  
  private void writeString(int paramInt, Object paramObject, Writer paramWriter) throws IOException {
    if (paramObject instanceof String) {
      paramWriter.writeString(paramInt, (String)paramObject);
      return;
    } 
    paramWriter.writeBytes(paramInt, (ByteString)paramObject);
  }
  
  private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT, Writer paramWriter) throws IOException {
    paramUnknownFieldSchema.writeTo(paramUnknownFieldSchema.getFromMessage(paramT), paramWriter);
  }
  
  public boolean equals(T paramT1, T paramT2) {
    int j = this.buffer.length;
    for (int i = 0; i < j; i += 3) {
      if (!equals(paramT1, paramT2, i))
        return false; 
    } 
    return !this.unknownFieldSchema.getFromMessage(paramT1).equals(this.unknownFieldSchema.getFromMessage(paramT2)) ? false : (this.hasExtensions ? this.extensionSchema.getExtensions(paramT1).equals(this.extensionSchema.getExtensions(paramT2)) : true);
  }
  
  int getSchemaSize() {
    return this.buffer.length * 3;
  }
  
  public int getSerializedSize(T paramT) {
    return this.proto3 ? getSerializedSizeProto3(paramT) : getSerializedSizeProto2(paramT);
  }
  
  public int hashCode(T paramT) {
    int m = this.buffer.length;
    int k = 0;
    int j;
    for (j = 0; k < m; j = n) {
      Object object;
      int n = typeAndOffsetAt(k);
      int i1 = numberAt(k);
      long l = offset(n);
      int i2 = type(n);
      n = 37;
      switch (i2) {
        default:
          n = j;
          break;
        case 68:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            Object object1 = UnsafeUtil.getObject(paramT, l);
            n = j * 53;
            j = object1.hashCode();
          } else {
            break;
          } 
          n += j;
          break;
        case 67:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(oneofLongAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 66:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 65:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(oneofLongAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 64:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 63:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 62:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 61:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = UnsafeUtil.getObject(paramT, l).hashCode();
          } else {
            break;
          } 
          n += j;
          break;
        case 60:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            Object object1 = UnsafeUtil.getObject(paramT, l);
            n = j * 53;
            j = object1.hashCode();
          } else {
            break;
          } 
          n += j;
          break;
        case 59:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = ((String)UnsafeUtil.getObject(paramT, l)).hashCode();
          } else {
            break;
          } 
          n += j;
          break;
        case 58:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashBoolean(oneofBooleanAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 57:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 56:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(oneofLongAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 55:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = oneofIntAt(paramT, l);
          } else {
            break;
          } 
          n += j;
          break;
        case 54:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(oneofLongAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 53:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(oneofLongAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 52:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Float.floatToIntBits(oneofFloatAt(paramT, l));
          } else {
            break;
          } 
          n += j;
          break;
        case 51:
          n = j;
          if (isOneofPresent(paramT, i1, k)) {
            n = j * 53;
            j = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(paramT, l)));
          } else {
            break;
          } 
          n += j;
          break;
        case 50:
          n = j * 53;
          j = UnsafeUtil.getObject(paramT, l).hashCode();
          n += j;
          break;
        case 18:
        case 19:
        case 20:
        case 21:
        case 22:
        case 23:
        case 24:
        case 25:
        case 26:
        case 27:
        case 28:
        case 29:
        case 30:
        case 31:
        case 32:
        case 33:
        case 34:
        case 35:
        case 36:
        case 37:
        case 38:
        case 39:
        case 40:
        case 41:
        case 42:
        case 43:
        case 44:
        case 45:
        case 46:
        case 47:
        case 48:
        case 49:
          n = j * 53;
          j = UnsafeUtil.getObject(paramT, l).hashCode();
          n += j;
          break;
        case 17:
          object = UnsafeUtil.getObject(paramT, l);
          if (object != null)
            n = object.hashCode(); 
          n = j * 53 + n;
          break;
        case 16:
          n = j * 53;
          j = Internal.hashLong(UnsafeUtil.getLong(paramT, l));
          n += j;
          break;
        case 15:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 14:
          n = j * 53;
          j = Internal.hashLong(UnsafeUtil.getLong(paramT, l));
          n += j;
          break;
        case 13:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 12:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 11:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 10:
          n = j * 53;
          j = UnsafeUtil.getObject(paramT, l).hashCode();
          n += j;
          break;
        case 9:
          object = UnsafeUtil.getObject(paramT, l);
          if (object != null)
            n = object.hashCode(); 
          n = j * 53 + n;
          break;
        case 8:
          n = j * 53;
          j = ((String)UnsafeUtil.getObject(paramT, l)).hashCode();
          n += j;
          break;
        case 7:
          n = j * 53;
          j = Internal.hashBoolean(UnsafeUtil.getBoolean(paramT, l));
          n += j;
          break;
        case 6:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 5:
          n = j * 53;
          j = Internal.hashLong(UnsafeUtil.getLong(paramT, l));
          n += j;
          break;
        case 4:
          n = j * 53;
          j = UnsafeUtil.getInt(paramT, l);
          n += j;
          break;
        case 3:
          n = j * 53;
          j = Internal.hashLong(UnsafeUtil.getLong(paramT, l));
          n += j;
          break;
        case 2:
          n = j * 53;
          j = Internal.hashLong(UnsafeUtil.getLong(paramT, l));
          n += j;
          break;
        case 1:
          n = j * 53;
          j = Float.floatToIntBits(UnsafeUtil.getFloat(paramT, l));
          n += j;
          break;
        case 0:
          n = j * 53;
          j = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(paramT, l)));
          n += j;
          break;
      } 
      k += 3;
    } 
    j = j * 53 + this.unknownFieldSchema.getFromMessage(paramT).hashCode();
    int i = j;
    if (this.hasExtensions)
      i = j * 53 + this.extensionSchema.getExtensions(paramT).hashCode(); 
    return i;
  }
  
  public final boolean isInitialized(T paramT) {
    int j = 1048575;
    int i = 0;
    int k;
    for (k = 0; k < this.checkInitializedCount; k++) {
      int n = this.intArray[k];
      int i1 = numberAt(n);
      int i2 = typeAndOffsetAt(n);
      int i3 = this.buffer[n + 2];
      int m = i3 & 0xFFFFF;
      i3 = 1 << i3 >>> 20;
      if (m != j) {
        if (m != 1048575)
          i = UNSAFE.getInt(paramT, m); 
        j = m;
      } 
      if (isRequired(i2) && !isFieldPresent(paramT, n, j, i, i3))
        return false; 
      m = type(i2);
      if (m != 9 && m != 17) {
        if (m != 27)
          if (m != 60 && m != 68) {
            if (m != 49) {
              if (m == 50 && !isMapInitialized(paramT, i2, n))
                return false; 
              continue;
            } 
          } else {
            if (isOneofPresent(paramT, i1, n) && !isInitialized(paramT, i2, getMessageFieldSchema(n)))
              return false; 
            continue;
          }  
        if (!isListInitialized(paramT, i2, n))
          return false; 
        continue;
      } 
      if (isFieldPresent(paramT, n, j, i, i3) && !isInitialized(paramT, i2, getMessageFieldSchema(n)))
        return false; 
      continue;
    } 
    return !(this.hasExtensions && !this.extensionSchema.getExtensions(paramT).isInitialized());
  }
  
  public void makeImmutable(T paramT) {
    int i = this.checkInitializedCount;
    while (true) {
      int j = this.repeatedFieldOffsetStart;
      if (i < j) {
        long l = offset(typeAndOffsetAt(this.intArray[i]));
        Object object = UnsafeUtil.getObject(paramT, l);
        if (object != null)
          UnsafeUtil.putObject(paramT, l, this.mapFieldSchema.toImmutable(object)); 
        i++;
        continue;
      } 
      int k = this.intArray.length;
      for (i = j; i < k; i++)
        this.listFieldSchema.makeImmutableListAt(paramT, this.intArray[i]); 
      this.unknownFieldSchema.makeImmutable(paramT);
      if (this.hasExtensions)
        this.extensionSchema.makeImmutable(paramT); 
      return;
    } 
  }
  
  public void mergeFrom(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    if (paramExtensionRegistryLite != null) {
      mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, paramT, paramReader, paramExtensionRegistryLite);
      return;
    } 
    throw new NullPointerException();
  }
  
  public void mergeFrom(T paramT1, T paramT2) {
    if (paramT2 != null) {
      for (int i = 0; i < this.buffer.length; i += 3)
        mergeSingleField(paramT1, paramT2, i); 
      SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, paramT1, paramT2);
      if (this.hasExtensions)
        SchemaUtil.mergeExtensions(this.extensionSchema, paramT1, paramT2); 
      return;
    } 
    throw new NullPointerException();
  }
  
  public void mergeFrom(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters) throws IOException {
    if (this.proto3) {
      parseProto3Message(paramT, paramArrayOfbyte, paramInt1, paramInt2, paramRegisters);
      return;
    } 
    parseProto2Message(paramT, paramArrayOfbyte, paramInt1, paramInt2, 0, paramRegisters);
  }
  
  public T newInstance() {
    return (T)this.newInstanceSchema.newInstance(this.defaultInstance);
  }
  
  int parseProto2Message(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, ArrayDecoders.Registers paramRegisters) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: astore #22
    //   3: iload #4
    //   5: istore #11
    //   7: iload #5
    //   9: istore #10
    //   11: getstatic com/google/protobuf/MessageSchema.UNSAFE : Lsun/misc/Unsafe;
    //   14: astore #23
    //   16: iconst_m1
    //   17: istore #12
    //   19: iconst_0
    //   20: istore #13
    //   22: iconst_0
    //   23: istore #9
    //   25: iconst_0
    //   26: istore #7
    //   28: ldc 1048575
    //   30: istore #8
    //   32: aload_2
    //   33: astore #26
    //   35: aload_0
    //   36: astore #24
    //   38: aload #6
    //   40: astore #25
    //   42: iload_3
    //   43: iload #11
    //   45: if_icmpge -> 1819
    //   48: iload_3
    //   49: iconst_1
    //   50: iadd
    //   51: istore #14
    //   53: aload #26
    //   55: iload_3
    //   56: baload
    //   57: istore_3
    //   58: iload_3
    //   59: ifge -> 83
    //   62: iload_3
    //   63: aload #26
    //   65: iload #14
    //   67: aload #25
    //   69: invokestatic decodeVarint32 : (I[BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   72: istore #14
    //   74: aload #25
    //   76: getfield int1 : I
    //   79: istore_3
    //   80: goto -> 83
    //   83: iload_3
    //   84: iconst_3
    //   85: iushr
    //   86: istore #11
    //   88: iload_3
    //   89: bipush #7
    //   91: iand
    //   92: istore #16
    //   94: iload #11
    //   96: iload #12
    //   98: if_icmple -> 117
    //   101: aload #24
    //   103: iload #11
    //   105: iload #13
    //   107: iconst_3
    //   108: idiv
    //   109: invokespecial positionForFieldNumber : (II)I
    //   112: istore #9
    //   114: goto -> 126
    //   117: aload #24
    //   119: iload #11
    //   121: invokespecial positionForFieldNumber : (I)I
    //   124: istore #9
    //   126: iload #9
    //   128: iconst_m1
    //   129: if_icmpne -> 164
    //   132: iload_3
    //   133: istore #9
    //   135: iload #8
    //   137: istore #13
    //   139: iload #10
    //   141: istore_3
    //   142: iconst_0
    //   143: istore #12
    //   145: iload #14
    //   147: istore #10
    //   149: iload #9
    //   151: istore #8
    //   153: iload #7
    //   155: istore #9
    //   157: iload #13
    //   159: istore #7
    //   161: goto -> 1670
    //   164: aload #24
    //   166: getfield buffer : [I
    //   169: iload #9
    //   171: iconst_1
    //   172: iadd
    //   173: iaload
    //   174: istore #17
    //   176: iload #17
    //   178: invokestatic type : (I)I
    //   181: istore #18
    //   183: iload #17
    //   185: invokestatic offset : (I)J
    //   188: lstore #19
    //   190: iload #18
    //   192: bipush #17
    //   194: if_icmpgt -> 1257
    //   197: aload #24
    //   199: getfield buffer : [I
    //   202: iload #9
    //   204: iconst_2
    //   205: iadd
    //   206: iaload
    //   207: istore #10
    //   209: iconst_1
    //   210: iload #10
    //   212: bipush #20
    //   214: iushr
    //   215: ishl
    //   216: istore #12
    //   218: iload #10
    //   220: ldc 1048575
    //   222: iand
    //   223: istore #10
    //   225: iload #10
    //   227: iload #8
    //   229: if_icmpeq -> 274
    //   232: iload #8
    //   234: ldc 1048575
    //   236: if_icmpeq -> 251
    //   239: aload #23
    //   241: aload #22
    //   243: iload #8
    //   245: i2l
    //   246: iload #7
    //   248: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   251: aload #23
    //   253: aload #22
    //   255: iload #10
    //   257: i2l
    //   258: invokevirtual getInt : (Ljava/lang/Object;J)I
    //   261: istore #8
    //   263: iload #10
    //   265: istore #7
    //   267: iload #8
    //   269: istore #10
    //   271: goto -> 282
    //   274: iload #7
    //   276: istore #10
    //   278: iload #8
    //   280: istore #7
    //   282: iload #18
    //   284: tableswitch default -> 372, 0 -> 1174, 1 -> 1146, 2 -> 1066, 3 -> 1066, 4 -> 1034, 5 -> 989, 6 -> 910, 7 -> 864, 8 -> 805, 9 -> 719, 10 -> 686, 11 -> 1034, 12 -> 604, 13 -> 910, 14 -> 989, 15 -> 559, 16 -> 512, 17 -> 375
    //   372: goto -> 1232
    //   375: iload #16
    //   377: iconst_3
    //   378: if_icmpne -> 509
    //   381: aload #24
    //   383: iload #9
    //   385: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   388: aload_2
    //   389: iload #14
    //   391: iload #4
    //   393: iload #11
    //   395: iconst_3
    //   396: ishl
    //   397: iconst_4
    //   398: ior
    //   399: aload #6
    //   401: invokestatic decodeGroupField : (Lcom/google/protobuf/Schema;[BIIILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   404: istore #13
    //   406: iload #10
    //   408: iload #12
    //   410: iand
    //   411: ifne -> 431
    //   414: aload #23
    //   416: aload #22
    //   418: lload #19
    //   420: aload #25
    //   422: getfield object1 : Ljava/lang/Object;
    //   425: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   428: goto -> 457
    //   431: aload #23
    //   433: aload #22
    //   435: lload #19
    //   437: aload #23
    //   439: aload #22
    //   441: lload #19
    //   443: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   446: aload #25
    //   448: getfield object1 : Ljava/lang/Object;
    //   451: invokestatic mergeMessage : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   454: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   457: iload #10
    //   459: iload #12
    //   461: ior
    //   462: istore #15
    //   464: iload #4
    //   466: istore #14
    //   468: iload #5
    //   470: istore #10
    //   472: iload_3
    //   473: istore #8
    //   475: iload #11
    //   477: istore #12
    //   479: iload #7
    //   481: istore #11
    //   483: iload #13
    //   485: istore_3
    //   486: iload #9
    //   488: istore #13
    //   490: iload #8
    //   492: istore #9
    //   494: iload #15
    //   496: istore #7
    //   498: iload #11
    //   500: istore #8
    //   502: iload #14
    //   504: istore #11
    //   506: goto -> 32
    //   509: goto -> 802
    //   512: iload #16
    //   514: ifne -> 556
    //   517: aload_2
    //   518: iload #14
    //   520: aload #25
    //   522: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   525: istore #8
    //   527: aload #23
    //   529: aload_1
    //   530: lload #19
    //   532: aload #25
    //   534: getfield long1 : J
    //   537: invokestatic decodeZigZag64 : (J)J
    //   540: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   543: iload #10
    //   545: iload #12
    //   547: ior
    //   548: istore #10
    //   550: aload_1
    //   551: astore #22
    //   553: goto -> 1207
    //   556: goto -> 601
    //   559: iload #16
    //   561: ifne -> 601
    //   564: aload_2
    //   565: iload #14
    //   567: aload #25
    //   569: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   572: istore #8
    //   574: aload #25
    //   576: getfield int1 : I
    //   579: invokestatic decodeZigZag32 : (I)I
    //   582: istore #13
    //   584: aload_1
    //   585: astore #22
    //   587: aload #23
    //   589: aload #22
    //   591: lload #19
    //   593: iload #13
    //   595: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   598: goto -> 1200
    //   601: goto -> 802
    //   604: iload #16
    //   606: ifne -> 802
    //   609: aload_2
    //   610: iload #14
    //   612: aload #25
    //   614: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   617: istore #8
    //   619: aload #25
    //   621: getfield int1 : I
    //   624: istore #13
    //   626: aload #24
    //   628: iload #9
    //   630: invokespecial getEnumFieldVerifier : (I)Lcom/google/protobuf/Internal$EnumVerifier;
    //   633: astore #24
    //   635: aload #24
    //   637: ifnull -> 672
    //   640: aload #24
    //   642: iload #13
    //   644: invokeinterface isInRange : (I)Z
    //   649: ifeq -> 655
    //   652: goto -> 672
    //   655: aload_1
    //   656: invokestatic getMutableUnknownFields : (Ljava/lang/Object;)Lcom/google/protobuf/UnknownFieldSetLite;
    //   659: iload_3
    //   660: iload #13
    //   662: i2l
    //   663: invokestatic valueOf : (J)Ljava/lang/Long;
    //   666: invokevirtual storeField : (ILjava/lang/Object;)V
    //   669: goto -> 1207
    //   672: aload #23
    //   674: aload #22
    //   676: lload #19
    //   678: iload #13
    //   680: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   683: goto -> 1200
    //   686: iload #16
    //   688: iconst_2
    //   689: if_icmpne -> 802
    //   692: aload_2
    //   693: iload #14
    //   695: aload #25
    //   697: invokestatic decodeBytes : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   700: istore #8
    //   702: aload #23
    //   704: aload #22
    //   706: lload #19
    //   708: aload #25
    //   710: getfield object1 : Ljava/lang/Object;
    //   713: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   716: goto -> 1200
    //   719: aload #22
    //   721: astore #26
    //   723: iload #16
    //   725: iconst_2
    //   726: if_icmpne -> 802
    //   729: aload #24
    //   731: iload #9
    //   733: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   736: aload_2
    //   737: iload #14
    //   739: iload #4
    //   741: aload #25
    //   743: invokestatic decodeMessageField : (Lcom/google/protobuf/Schema;[BIILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   746: istore #8
    //   748: iload #10
    //   750: iload #12
    //   752: iand
    //   753: ifne -> 773
    //   756: aload #23
    //   758: aload #26
    //   760: lload #19
    //   762: aload #25
    //   764: getfield object1 : Ljava/lang/Object;
    //   767: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   770: goto -> 937
    //   773: aload #23
    //   775: aload #26
    //   777: lload #19
    //   779: aload #23
    //   781: aload #26
    //   783: lload #19
    //   785: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   788: aload #25
    //   790: getfield object1 : Ljava/lang/Object;
    //   793: invokestatic mergeMessage : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   796: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   799: goto -> 937
    //   802: goto -> 1232
    //   805: aload_2
    //   806: astore #24
    //   808: iload #16
    //   810: iconst_2
    //   811: if_icmpne -> 1232
    //   814: iload #17
    //   816: ldc 536870912
    //   818: iand
    //   819: ifne -> 836
    //   822: aload #24
    //   824: iload #14
    //   826: aload #25
    //   828: invokestatic decodeString : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   831: istore #8
    //   833: goto -> 847
    //   836: aload #24
    //   838: iload #14
    //   840: aload #25
    //   842: invokestatic decodeStringRequireUtf8 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   845: istore #8
    //   847: aload #23
    //   849: aload #22
    //   851: lload #19
    //   853: aload #25
    //   855: getfield object1 : Ljava/lang/Object;
    //   858: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   861: goto -> 937
    //   864: iload #16
    //   866: ifne -> 1232
    //   869: aload_2
    //   870: iload #14
    //   872: aload #25
    //   874: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   877: istore #8
    //   879: aload #25
    //   881: getfield long1 : J
    //   884: lconst_0
    //   885: lcmp
    //   886: ifeq -> 895
    //   889: iconst_1
    //   890: istore #21
    //   892: goto -> 898
    //   895: iconst_0
    //   896: istore #21
    //   898: aload #22
    //   900: lload #19
    //   902: iload #21
    //   904: invokestatic putBoolean : (Ljava/lang/Object;JZ)V
    //   907: goto -> 937
    //   910: iload #16
    //   912: iconst_5
    //   913: if_icmpne -> 1232
    //   916: aload #23
    //   918: aload #22
    //   920: lload #19
    //   922: aload_2
    //   923: iload #14
    //   925: invokestatic decodeFixed32 : ([BI)I
    //   928: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   931: iload #14
    //   933: iconst_4
    //   934: iadd
    //   935: istore #8
    //   937: iload #4
    //   939: istore #14
    //   941: iload_3
    //   942: istore #17
    //   944: iload #7
    //   946: istore #16
    //   948: iload #5
    //   950: istore #15
    //   952: iload #10
    //   954: iload #12
    //   956: ior
    //   957: istore #7
    //   959: iload #8
    //   961: istore_3
    //   962: iload #11
    //   964: istore #12
    //   966: iload #9
    //   968: istore #13
    //   970: iload #17
    //   972: istore #9
    //   974: iload #16
    //   976: istore #8
    //   978: iload #15
    //   980: istore #10
    //   982: iload #14
    //   984: istore #11
    //   986: goto -> 32
    //   989: iload #16
    //   991: iconst_1
    //   992: if_icmpne -> 1232
    //   995: aload #23
    //   997: aload_1
    //   998: lload #19
    //   1000: aload_2
    //   1001: iload #14
    //   1003: invokestatic decodeFixed64 : ([BI)J
    //   1006: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   1009: iload #14
    //   1011: bipush #8
    //   1013: iadd
    //   1014: istore #8
    //   1016: iload #10
    //   1018: iload #12
    //   1020: ior
    //   1021: istore #12
    //   1023: iload #8
    //   1025: istore #10
    //   1027: iload #12
    //   1029: istore #8
    //   1031: goto -> 1109
    //   1034: iload #16
    //   1036: ifne -> 1232
    //   1039: aload_2
    //   1040: iload #14
    //   1042: aload #25
    //   1044: invokestatic decodeVarint32 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1047: istore #8
    //   1049: aload #23
    //   1051: aload #22
    //   1053: lload #19
    //   1055: aload #25
    //   1057: getfield int1 : I
    //   1060: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1063: goto -> 1200
    //   1066: iload #16
    //   1068: ifne -> 1232
    //   1071: aload_2
    //   1072: iload #14
    //   1074: aload #25
    //   1076: invokestatic decodeVarint64 : ([BILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1079: istore #8
    //   1081: aload #23
    //   1083: aload_1
    //   1084: lload #19
    //   1086: aload #25
    //   1088: getfield long1 : J
    //   1091: invokevirtual putLong : (Ljava/lang/Object;JJ)V
    //   1094: iload #10
    //   1096: iload #12
    //   1098: ior
    //   1099: istore #12
    //   1101: iload #8
    //   1103: istore #10
    //   1105: iload #12
    //   1107: istore #8
    //   1109: iload #9
    //   1111: istore #12
    //   1113: iload_3
    //   1114: istore #13
    //   1116: iload #11
    //   1118: istore #9
    //   1120: iload #7
    //   1122: istore #14
    //   1124: iload #10
    //   1126: istore_3
    //   1127: iload #12
    //   1129: istore #11
    //   1131: iload #13
    //   1133: istore #10
    //   1135: iload #8
    //   1137: istore #7
    //   1139: iload #14
    //   1141: istore #8
    //   1143: goto -> 1420
    //   1146: iload #16
    //   1148: iconst_5
    //   1149: if_icmpne -> 1232
    //   1152: aload #22
    //   1154: lload #19
    //   1156: aload_2
    //   1157: iload #14
    //   1159: invokestatic decodeFloat : ([BI)F
    //   1162: invokestatic putFloat : (Ljava/lang/Object;JF)V
    //   1165: iload #14
    //   1167: iconst_4
    //   1168: iadd
    //   1169: istore #8
    //   1171: goto -> 1200
    //   1174: iload #16
    //   1176: iconst_1
    //   1177: if_icmpne -> 1232
    //   1180: aload #22
    //   1182: lload #19
    //   1184: aload_2
    //   1185: iload #14
    //   1187: invokestatic decodeDouble : ([BI)D
    //   1190: invokestatic putDouble : (Ljava/lang/Object;JD)V
    //   1193: iload #14
    //   1195: bipush #8
    //   1197: iadd
    //   1198: istore #8
    //   1200: iload #10
    //   1202: iload #12
    //   1204: ior
    //   1205: istore #10
    //   1207: iload #9
    //   1209: istore #12
    //   1211: iload_3
    //   1212: istore #13
    //   1214: iload #11
    //   1216: istore #9
    //   1218: iload #8
    //   1220: istore_3
    //   1221: iload #12
    //   1223: istore #11
    //   1225: iload #13
    //   1227: istore #12
    //   1229: goto -> 1408
    //   1232: iload #10
    //   1234: istore #13
    //   1236: iload_3
    //   1237: istore #8
    //   1239: iload #5
    //   1241: istore_3
    //   1242: iload #14
    //   1244: istore #10
    //   1246: iload #9
    //   1248: istore #12
    //   1250: iload #13
    //   1252: istore #9
    //   1254: goto -> 1670
    //   1257: iload #11
    //   1259: istore #12
    //   1261: iload #18
    //   1263: bipush #27
    //   1265: if_icmpne -> 1454
    //   1268: iload #16
    //   1270: iconst_2
    //   1271: if_icmpne -> 1451
    //   1274: aload #23
    //   1276: aload #22
    //   1278: lload #19
    //   1280: invokevirtual getObject : (Ljava/lang/Object;J)Ljava/lang/Object;
    //   1283: checkcast com/google/protobuf/Internal$ProtobufList
    //   1286: astore #26
    //   1288: aload #26
    //   1290: astore #25
    //   1292: aload #26
    //   1294: invokeinterface isModifiable : ()Z
    //   1299: ifne -> 1351
    //   1302: aload #26
    //   1304: invokeinterface size : ()I
    //   1309: istore #10
    //   1311: iload #10
    //   1313: ifne -> 1323
    //   1316: bipush #10
    //   1318: istore #10
    //   1320: goto -> 1329
    //   1323: iload #10
    //   1325: iconst_2
    //   1326: imul
    //   1327: istore #10
    //   1329: aload #26
    //   1331: iload #10
    //   1333: invokeinterface mutableCopyWithCapacity : (I)Lcom/google/protobuf/Internal$ProtobufList;
    //   1338: astore #25
    //   1340: aload #23
    //   1342: aload #22
    //   1344: lload #19
    //   1346: aload #25
    //   1348: invokevirtual putObject : (Ljava/lang/Object;JLjava/lang/Object;)V
    //   1351: aload #24
    //   1353: iload #9
    //   1355: invokespecial getMessageFieldSchema : (I)Lcom/google/protobuf/Schema;
    //   1358: astore #22
    //   1360: aload #22
    //   1362: iload_3
    //   1363: aload_2
    //   1364: iload #14
    //   1366: iload #4
    //   1368: aload #25
    //   1370: aload #6
    //   1372: invokestatic decodeMessageList : (Lcom/google/protobuf/Schema;I[BIILcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1375: istore #13
    //   1377: aload_1
    //   1378: astore #22
    //   1380: iload_3
    //   1381: istore #11
    //   1383: iload #12
    //   1385: istore_3
    //   1386: iload #7
    //   1388: istore #10
    //   1390: iload #8
    //   1392: istore #7
    //   1394: iload #11
    //   1396: istore #12
    //   1398: iload #9
    //   1400: istore #11
    //   1402: iload_3
    //   1403: istore #9
    //   1405: iload #13
    //   1407: istore_3
    //   1408: iload #7
    //   1410: istore #8
    //   1412: iload #10
    //   1414: istore #7
    //   1416: iload #12
    //   1418: istore #10
    //   1420: iload #4
    //   1422: istore #14
    //   1424: iload #5
    //   1426: istore #15
    //   1428: iload #9
    //   1430: istore #12
    //   1432: iload #11
    //   1434: istore #13
    //   1436: iload #10
    //   1438: istore #9
    //   1440: iload #15
    //   1442: istore #10
    //   1444: iload #14
    //   1446: istore #11
    //   1448: goto -> 32
    //   1451: goto -> 1585
    //   1454: iload #9
    //   1456: istore #13
    //   1458: iload #18
    //   1460: bipush #49
    //   1462: if_icmpgt -> 1532
    //   1465: aload_0
    //   1466: aload_1
    //   1467: aload_2
    //   1468: iload #14
    //   1470: iload #4
    //   1472: iload_3
    //   1473: iload #12
    //   1475: iload #16
    //   1477: iload #13
    //   1479: iload #17
    //   1481: i2l
    //   1482: iload #18
    //   1484: lload #19
    //   1486: aload #6
    //   1488: invokespecial parseRepeatedField : (Ljava/lang/Object;[BIIIIIIJIJLcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1491: istore #15
    //   1493: iload #15
    //   1495: istore #10
    //   1497: iload #15
    //   1499: iload #14
    //   1501: if_icmpeq -> 1667
    //   1504: iload #15
    //   1506: istore #9
    //   1508: aload_1
    //   1509: astore #22
    //   1511: iload #4
    //   1513: istore #11
    //   1515: iload #5
    //   1517: istore #10
    //   1519: iload_3
    //   1520: istore #14
    //   1522: iload #9
    //   1524: istore_3
    //   1525: iload #14
    //   1527: istore #9
    //   1529: goto -> 32
    //   1532: iload #14
    //   1534: istore #15
    //   1536: iload #18
    //   1538: bipush #50
    //   1540: if_icmpne -> 1622
    //   1543: iload #16
    //   1545: iconst_2
    //   1546: if_icmpne -> 1585
    //   1549: aload_0
    //   1550: aload_1
    //   1551: aload_2
    //   1552: iload #15
    //   1554: iload #4
    //   1556: iload #13
    //   1558: lload #19
    //   1560: aload #6
    //   1562: invokespecial parseMapField : (Ljava/lang/Object;[BIIIJLcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1565: istore #14
    //   1567: iload #14
    //   1569: istore #10
    //   1571: iload #14
    //   1573: iload #15
    //   1575: if_icmpeq -> 1667
    //   1578: iload #14
    //   1580: istore #9
    //   1582: goto -> 1508
    //   1585: iload #14
    //   1587: istore #10
    //   1589: iload #8
    //   1591: istore #13
    //   1593: iload #5
    //   1595: istore #8
    //   1597: iload_3
    //   1598: istore #12
    //   1600: iload #8
    //   1602: istore_3
    //   1603: iload #12
    //   1605: istore #8
    //   1607: iload #9
    //   1609: istore #12
    //   1611: iload #7
    //   1613: istore #9
    //   1615: iload #13
    //   1617: istore #7
    //   1619: goto -> 1670
    //   1622: aload_0
    //   1623: aload_1
    //   1624: aload_2
    //   1625: iload #15
    //   1627: iload #4
    //   1629: iload_3
    //   1630: iload #12
    //   1632: iload #16
    //   1634: iload #17
    //   1636: iload #18
    //   1638: lload #19
    //   1640: iload #13
    //   1642: aload #6
    //   1644: invokespecial parseOneofField : (Ljava/lang/Object;[BIIIIIIIJILcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1647: istore #14
    //   1649: iload #14
    //   1651: istore #10
    //   1653: iload #14
    //   1655: iload #15
    //   1657: if_icmpeq -> 1667
    //   1660: iload #14
    //   1662: istore #9
    //   1664: goto -> 1508
    //   1667: goto -> 1589
    //   1670: iload #8
    //   1672: iload_3
    //   1673: if_icmpne -> 1697
    //   1676: iload_3
    //   1677: ifeq -> 1697
    //   1680: aload_0
    //   1681: astore_2
    //   1682: iload #9
    //   1684: istore #5
    //   1686: iload #7
    //   1688: istore #9
    //   1690: iload #5
    //   1692: istore #7
    //   1694: goto -> 1842
    //   1697: aload_0
    //   1698: getfield hasExtensions : Z
    //   1701: ifeq -> 1741
    //   1704: aload #6
    //   1706: getfield extensionRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   1709: invokestatic getEmptyRegistry : ()Lcom/google/protobuf/ExtensionRegistryLite;
    //   1712: if_acmpeq -> 1741
    //   1715: iload #8
    //   1717: aload_2
    //   1718: iload #10
    //   1720: iload #4
    //   1722: aload_1
    //   1723: aload_0
    //   1724: getfield defaultInstance : Lcom/google/protobuf/MessageLite;
    //   1727: aload_0
    //   1728: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   1731: aload #6
    //   1733: invokestatic decodeExtensionOrUnknownField : (I[BIILjava/lang/Object;Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/UnknownFieldSchema;Lcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1736: istore #10
    //   1738: goto -> 1759
    //   1741: iload #8
    //   1743: aload_2
    //   1744: iload #10
    //   1746: iload #4
    //   1748: aload_1
    //   1749: invokestatic getMutableUnknownFields : (Ljava/lang/Object;)Lcom/google/protobuf/UnknownFieldSetLite;
    //   1752: aload #6
    //   1754: invokestatic decodeUnknownField : (I[BIILcom/google/protobuf/UnknownFieldSetLite;Lcom/google/protobuf/ArrayDecoders$Registers;)I
    //   1757: istore #10
    //   1759: aload_1
    //   1760: astore #22
    //   1762: iload #4
    //   1764: istore #14
    //   1766: iload #11
    //   1768: istore #13
    //   1770: iload #12
    //   1772: istore #17
    //   1774: iload #9
    //   1776: istore #11
    //   1778: iload #7
    //   1780: istore #15
    //   1782: iload_3
    //   1783: istore #16
    //   1785: iload #10
    //   1787: istore_3
    //   1788: iload #13
    //   1790: istore #12
    //   1792: iload #17
    //   1794: istore #13
    //   1796: iload #8
    //   1798: istore #9
    //   1800: iload #11
    //   1802: istore #7
    //   1804: iload #15
    //   1806: istore #8
    //   1808: iload #16
    //   1810: istore #10
    //   1812: iload #14
    //   1814: istore #11
    //   1816: goto -> 32
    //   1819: aload #24
    //   1821: astore_2
    //   1822: iload_3
    //   1823: istore #5
    //   1825: iload #9
    //   1827: istore_3
    //   1828: iload #8
    //   1830: istore #9
    //   1832: iload_3
    //   1833: istore #8
    //   1835: iload #10
    //   1837: istore_3
    //   1838: iload #5
    //   1840: istore #10
    //   1842: iload #9
    //   1844: ldc 1048575
    //   1846: if_icmpeq -> 1863
    //   1849: aload #23
    //   1851: aload_1
    //   1852: iload #9
    //   1854: i2l
    //   1855: iload #7
    //   1857: invokevirtual putInt : (Ljava/lang/Object;JI)V
    //   1860: goto -> 1863
    //   1863: aload_1
    //   1864: astore #6
    //   1866: aconst_null
    //   1867: astore_1
    //   1868: aload_2
    //   1869: getfield checkInitializedCount : I
    //   1872: istore #5
    //   1874: iload #5
    //   1876: aload_2
    //   1877: getfield repeatedFieldOffsetStart : I
    //   1880: if_icmpge -> 1914
    //   1883: aload_2
    //   1884: aload #6
    //   1886: aload_2
    //   1887: getfield intArray : [I
    //   1890: iload #5
    //   1892: iaload
    //   1893: aload_1
    //   1894: aload_2
    //   1895: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   1898: invokespecial filterMapUnknownEnumValues : (Ljava/lang/Object;ILjava/lang/Object;Lcom/google/protobuf/UnknownFieldSchema;)Ljava/lang/Object;
    //   1901: checkcast com/google/protobuf/UnknownFieldSetLite
    //   1904: astore_1
    //   1905: iload #5
    //   1907: iconst_1
    //   1908: iadd
    //   1909: istore #5
    //   1911: goto -> 1874
    //   1914: aload_1
    //   1915: ifnull -> 1928
    //   1918: aload_2
    //   1919: getfield unknownFieldSchema : Lcom/google/protobuf/UnknownFieldSchema;
    //   1922: aload #6
    //   1924: aload_1
    //   1925: invokevirtual setBuilderToMessage : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   1928: iload_3
    //   1929: ifne -> 1946
    //   1932: iload #10
    //   1934: iload #4
    //   1936: if_icmpne -> 1942
    //   1939: iload #10
    //   1941: ireturn
    //   1942: invokestatic parseFailure : ()Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1945: athrow
    //   1946: iload #10
    //   1948: iload #4
    //   1950: if_icmpgt -> 1962
    //   1953: iload #8
    //   1955: iload_3
    //   1956: if_icmpne -> 1962
    //   1959: iload #10
    //   1961: ireturn
    //   1962: invokestatic parseFailure : ()Lcom/google/protobuf/InvalidProtocolBufferException;
    //   1965: athrow
  }
  
  public void writeTo(T paramT, Writer paramWriter) throws IOException {
    if (paramWriter.fieldOrder() == Writer.FieldOrder.DESCENDING) {
      writeFieldsInDescendingOrder(paramT, paramWriter);
      return;
    } 
    if (this.proto3) {
      writeFieldsInAscendingOrderProto3(paramT, paramWriter);
      return;
    } 
    writeFieldsInAscendingOrderProto2(paramT, paramWriter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */