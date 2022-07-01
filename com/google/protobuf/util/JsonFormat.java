package com.google.protobuf.util;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt64Value;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

public class JsonFormat {
  private static final Logger logger = Logger.getLogger(JsonFormat.class.getName());
  
  private static String getTypeName(String paramString) throws InvalidProtocolBufferException {
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length != 1)
      return arrayOfString[arrayOfString.length - 1]; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid type url found: ");
    stringBuilder.append(paramString);
    throw new InvalidProtocolBufferException(stringBuilder.toString());
  }
  
  public static Parser parser() {
    return new Parser(TypeRegistry.getEmptyTypeRegistry(), false, 100);
  }
  
  public static Printer printer() {
    return new Printer(TypeRegistry.getEmptyTypeRegistry(), false, Collections.emptySet(), false, false);
  }
  
  private static String unsignedToString(int paramInt) {
    return (paramInt >= 0) ? Integer.toString(paramInt) : Long.toString(paramInt & 0xFFFFFFFFL);
  }
  
  private static String unsignedToString(long paramLong) {
    return (paramLong >= 0L) ? Long.toString(paramLong) : BigInteger.valueOf(paramLong & Long.MAX_VALUE).setBit(63).toString();
  }
  
  static final class CompactTextGenerator implements TextGenerator {
    private final Appendable output;
    
    private CompactTextGenerator(Appendable param1Appendable) {
      this.output = param1Appendable;
    }
    
    public void indent() {}
    
    public void outdent() {}
    
    public void print(CharSequence param1CharSequence) throws IOException {
      this.output.append(param1CharSequence);
    }
  }
  
  public static class Parser {
    private static final int DEFAULT_RECURSION_LIMIT = 100;
    
    private final boolean ignoringUnknownFields;
    
    private final int recursionLimit;
    
    private final JsonFormat.TypeRegistry registry;
    
    private Parser(JsonFormat.TypeRegistry param1TypeRegistry, boolean param1Boolean, int param1Int) {
      this.registry = param1TypeRegistry;
      this.ignoringUnknownFields = param1Boolean;
      this.recursionLimit = param1Int;
    }
    
    public Parser ignoringUnknownFields() {
      return new Parser(this.registry, true, this.recursionLimit);
    }
    
    public void merge(Reader param1Reader, Message.Builder param1Builder) throws IOException {
      (new JsonFormat.ParserImpl(this.registry, this.ignoringUnknownFields, this.recursionLimit)).merge(param1Reader, param1Builder);
    }
    
    public void merge(String param1String, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      (new JsonFormat.ParserImpl(this.registry, this.ignoringUnknownFields, this.recursionLimit)).merge(param1String, param1Builder);
    }
    
    Parser usingRecursionLimit(int param1Int) {
      return new Parser(this.registry, this.ignoringUnknownFields, param1Int);
    }
    
    public Parser usingTypeRegistry(JsonFormat.TypeRegistry param1TypeRegistry) {
      if (this.registry == JsonFormat.TypeRegistry.getEmptyTypeRegistry())
        return new Parser(param1TypeRegistry, this.ignoringUnknownFields, this.recursionLimit); 
      throw new IllegalArgumentException("Only one registry is allowed.");
    }
  }
  
  static class ParserImpl {
    private static final double EPSILON = 1.0E-6D;
    
    private static final BigDecimal MAX_DOUBLE;
    
    private static final BigInteger MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
    
    private static final BigDecimal MIN_DOUBLE;
    
    private static final BigDecimal MORE_THAN_ONE = new BigDecimal(String.valueOf(1.000001D));
    
    private static final Map<String, WellKnownTypeParser> wellKnownTypeParsers = buildWellKnownTypeParsers();
    
    private int currentDepth;
    
    private final Map<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>> fieldNameMaps = new HashMap<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>>();
    
    private final boolean ignoringUnknownFields;
    
    private final JsonParser jsonParser;
    
    private final int recursionLimit;
    
    private final JsonFormat.TypeRegistry registry;
    
    static {
      MAX_DOUBLE = (new BigDecimal(String.valueOf(Double.MAX_VALUE))).multiply(MORE_THAN_ONE);
      MIN_DOUBLE = (new BigDecimal(String.valueOf(-1.7976931348623157E308D))).multiply(MORE_THAN_ONE);
    }
    
    ParserImpl(JsonFormat.TypeRegistry param1TypeRegistry, boolean param1Boolean, int param1Int) {
      this.registry = param1TypeRegistry;
      this.ignoringUnknownFields = param1Boolean;
      this.jsonParser = new JsonParser();
      this.recursionLimit = param1Int;
      this.currentDepth = 0;
    }
    
    private static Map<String, WellKnownTypeParser> buildWellKnownTypeParsers() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put(Any.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeAny(param2JsonElement, param2Builder);
            }
          });
      WellKnownTypeParser wellKnownTypeParser = new WellKnownTypeParser() {
          public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
            param2ParserImpl.mergeWrapper(param2JsonElement, param2Builder);
          }
        };
      hashMap.put(BoolValue.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(Int32Value.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(Int64Value.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(StringValue.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(BytesValue.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(FloatValue.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypeParser);
      hashMap.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeTimestamp(param2JsonElement, param2Builder);
            }
          });
      hashMap.put(Duration.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeDuration(param2JsonElement, param2Builder);
            }
          });
      hashMap.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeFieldMask(param2JsonElement, param2Builder);
            }
          });
      hashMap.put(Struct.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeStruct(param2JsonElement, param2Builder);
            }
          });
      hashMap.put(ListValue.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeListValue(param2JsonElement, param2Builder);
            }
          });
      hashMap.put(Value.getDescriptor().getFullName(), new WellKnownTypeParser() {
            public void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException {
              param2ParserImpl.mergeValue(param2JsonElement, param2Builder);
            }
          });
      return (Map)hashMap;
    }
    
    private Map<String, Descriptors.FieldDescriptor> getFieldNameMap(Descriptors.Descriptor param1Descriptor) {
      if (!this.fieldNameMaps.containsKey(param1Descriptor)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (Descriptors.FieldDescriptor fieldDescriptor : param1Descriptor.getFields()) {
          hashMap.put(fieldDescriptor.getName(), fieldDescriptor);
          hashMap.put(fieldDescriptor.getJsonName(), fieldDescriptor);
        } 
        this.fieldNameMaps.put(param1Descriptor, hashMap);
        return (Map)hashMap;
      } 
      return this.fieldNameMaps.get(param1Descriptor);
    }
    
    private void merge(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      WellKnownTypeParser wellKnownTypeParser = wellKnownTypeParsers.get(param1Builder.getDescriptorForType().getFullName());
      if (wellKnownTypeParser != null) {
        wellKnownTypeParser.merge(this, param1JsonElement, param1Builder);
        return;
      } 
      mergeMessage(param1JsonElement, param1Builder, false);
    }
    
    private void mergeAny(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      Descriptors.Descriptor descriptor = param1Builder.getDescriptorForType();
      Descriptors.FieldDescriptor fieldDescriptor2 = descriptor.findFieldByName("type_url");
      Descriptors.FieldDescriptor fieldDescriptor1 = descriptor.findFieldByName("value");
      if (fieldDescriptor2 != null && fieldDescriptor1 != null && fieldDescriptor2.getType() == Descriptors.FieldDescriptor.Type.STRING && fieldDescriptor1.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
        StringBuilder stringBuilder1;
        if (param1JsonElement instanceof JsonObject) {
          JsonObject jsonObject = (JsonObject)param1JsonElement;
          if (jsonObject.entrySet().isEmpty())
            return; 
          JsonElement jsonElement = jsonObject.get("@type");
          if (jsonElement != null) {
            WellKnownTypeParser wellKnownTypeParser;
            String str = jsonElement.getAsString();
            Descriptors.Descriptor descriptor1 = this.registry.find(JsonFormat.getTypeName(str));
            if (descriptor1 != null) {
              param1Builder.setField(fieldDescriptor2, str);
              DynamicMessage.Builder builder = DynamicMessage.getDefaultInstance(descriptor1).newBuilderForType();
              wellKnownTypeParser = wellKnownTypeParsers.get(descriptor1.getFullName());
              if (wellKnownTypeParser != null) {
                param1JsonElement = jsonObject.get("value");
                if (param1JsonElement != null)
                  wellKnownTypeParser.merge(this, param1JsonElement, (Message.Builder)builder); 
              } else {
                mergeMessage(param1JsonElement, (Message.Builder)builder, true);
              } 
              param1Builder.setField(fieldDescriptor1, builder.build().toByteString());
              return;
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Cannot resolve type: ");
            stringBuilder1.append((String)wellKnownTypeParser);
            throw new InvalidProtocolBufferException(stringBuilder1.toString());
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Missing type url when parsing: ");
          stringBuilder.append(stringBuilder1);
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Expect message object but got: ");
        stringBuilder2.append(stringBuilder1);
        throw new InvalidProtocolBufferException(stringBuilder2.toString());
      } 
      throw new InvalidProtocolBufferException("Invalid Any type.");
    }
    
    private void mergeDuration(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      try {
        param1Builder.mergeFrom(Durations.parse(param1JsonElement.getAsString()).toByteString());
        return;
      } catch (ParseException parseException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to parse duration: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
    }
    
    private void mergeField(Descriptors.FieldDescriptor param1FieldDescriptor, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder2;
      if (param1FieldDescriptor.isRepeated()) {
        if (param1Builder.getRepeatedFieldCount(param1FieldDescriptor) > 0) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Field ");
          stringBuilder1.append(param1FieldDescriptor.getFullName());
          stringBuilder1.append(" has already been set.");
          throw new InvalidProtocolBufferException(stringBuilder1.toString());
        } 
      } else if (!param1Builder.hasField(param1FieldDescriptor)) {
        if (param1FieldDescriptor.getContainingOneof() != null && param1Builder.getOneofFieldDescriptor(param1FieldDescriptor.getContainingOneof()) != null) {
          Descriptors.FieldDescriptor fieldDescriptor = param1Builder.getOneofFieldDescriptor(param1FieldDescriptor.getContainingOneof());
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Cannot set field ");
          stringBuilder2.append(param1FieldDescriptor.getFullName());
          stringBuilder2.append(" because another field ");
          stringBuilder2.append(fieldDescriptor.getFullName());
          stringBuilder2.append(" belonging to the same oneof has already been set ");
          throw new InvalidProtocolBufferException(stringBuilder2.toString());
        } 
      } else {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Field ");
        stringBuilder1.append(param1FieldDescriptor.getFullName());
        stringBuilder1.append(" has already been set.");
        throw new InvalidProtocolBufferException(stringBuilder1.toString());
      } 
      if (param1FieldDescriptor.isRepeated() && stringBuilder1 instanceof com.google.gson.JsonNull)
        return; 
      if (param1FieldDescriptor.isMapField()) {
        mergeMapField(param1FieldDescriptor, (JsonElement)stringBuilder1, (Message.Builder)stringBuilder2);
        return;
      } 
      if (param1FieldDescriptor.isRepeated()) {
        mergeRepeatedField(param1FieldDescriptor, (JsonElement)stringBuilder1, (Message.Builder)stringBuilder2);
        return;
      } 
      Object object = parseFieldValue(param1FieldDescriptor, (JsonElement)stringBuilder1, (Message.Builder)stringBuilder2);
      if (object != null)
        stringBuilder2.setField(param1FieldDescriptor, object); 
    }
    
    private void mergeFieldMask(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1Builder.mergeFrom(FieldMaskUtil.fromJsonString(param1JsonElement.getAsString()).toByteString());
    }
    
    private void mergeListValue(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      Descriptors.FieldDescriptor fieldDescriptor = param1Builder.getDescriptorForType().findFieldByName("values");
      if (fieldDescriptor != null) {
        mergeRepeatedField(fieldDescriptor, param1JsonElement, param1Builder);
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid ListValue type.");
    }
    
    private void mergeMapField(Descriptors.FieldDescriptor param1FieldDescriptor, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      StringBuilder stringBuilder2;
      if (param1JsonElement instanceof JsonObject) {
        Descriptors.Descriptor descriptor = param1FieldDescriptor.getMessageType();
        Descriptors.FieldDescriptor fieldDescriptor1 = descriptor.findFieldByName("key");
        Descriptors.FieldDescriptor fieldDescriptor2 = descriptor.findFieldByName("value");
        if (fieldDescriptor1 != null && fieldDescriptor2 != null) {
          for (Map.Entry entry : ((JsonObject)param1JsonElement).entrySet()) {
            Message.Builder builder = param1Builder.newBuilderForField(param1FieldDescriptor);
            Object object1 = parseFieldValue(fieldDescriptor1, (JsonElement)new JsonPrimitive((String)entry.getKey()), builder);
            Object object2 = parseFieldValue(fieldDescriptor2, (JsonElement)entry.getValue(), builder);
            if (object2 != null) {
              builder.setField(fieldDescriptor1, object1);
              builder.setField(fieldDescriptor2, object2);
              param1Builder.addRepeatedField(param1FieldDescriptor, builder.build());
              continue;
            } 
            throw new InvalidProtocolBufferException("Map value cannot be null.");
          } 
          return;
        } 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Invalid map field: ");
        stringBuilder2.append(param1FieldDescriptor.getFullName());
        throw new InvalidProtocolBufferException(stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expect a map object but found: ");
      stringBuilder1.append(stringBuilder2);
      throw new InvalidProtocolBufferException(stringBuilder1.toString());
    }
    
    private void mergeMessage(JsonElement param1JsonElement, Message.Builder param1Builder, boolean param1Boolean) throws InvalidProtocolBufferException {
      StringBuilder stringBuilder1;
      if (param1JsonElement instanceof JsonObject) {
        JsonObject jsonObject = (JsonObject)param1JsonElement;
        Map<String, Descriptors.FieldDescriptor> map = getFieldNameMap(param1Builder.getDescriptorForType());
        for (Map.Entry entry : jsonObject.entrySet()) {
          if (param1Boolean && ((String)entry.getKey()).equals("@type"))
            continue; 
          Descriptors.FieldDescriptor fieldDescriptor = map.get(entry.getKey());
          if (fieldDescriptor == null) {
            if (this.ignoringUnknownFields)
              continue; 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Cannot find field: ");
            stringBuilder1.append((String)entry.getKey());
            stringBuilder1.append(" in message ");
            stringBuilder1.append(param1Builder.getDescriptorForType().getFullName());
            throw new InvalidProtocolBufferException(stringBuilder1.toString());
          } 
          mergeField(fieldDescriptor, (JsonElement)entry.getValue(), param1Builder);
        } 
        return;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Expect message object but got: ");
      stringBuilder2.append(stringBuilder1);
      throw new InvalidProtocolBufferException(stringBuilder2.toString());
    }
    
    private void mergeRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      JsonArray jsonArray;
      if (param1JsonElement instanceof JsonArray) {
        jsonArray = (JsonArray)param1JsonElement;
        int i = 0;
        while (i < jsonArray.size()) {
          Object object = parseFieldValue(param1FieldDescriptor, jsonArray.get(i), param1Builder);
          if (object != null) {
            param1Builder.addRepeatedField(param1FieldDescriptor, object);
            i++;
            continue;
          } 
          throw new InvalidProtocolBufferException("Repeated field elements cannot be null");
        } 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expect an array but found: ");
      stringBuilder.append(jsonArray);
      throw new InvalidProtocolBufferException(stringBuilder.toString());
    }
    
    private void mergeStruct(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      Descriptors.FieldDescriptor fieldDescriptor = param1Builder.getDescriptorForType().findFieldByName("fields");
      if (fieldDescriptor != null) {
        mergeMapField(fieldDescriptor, param1JsonElement, param1Builder);
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid Struct type.");
    }
    
    private void mergeTimestamp(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      try {
        param1Builder.mergeFrom(Timestamps.parse(param1JsonElement.getAsString()).toByteString());
        return;
      } catch (ParseException parseException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to parse timestamp: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
    }
    
    private void mergeValue(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      JsonPrimitive jsonPrimitive;
      Descriptors.FieldDescriptor fieldDescriptor;
      Descriptors.Descriptor descriptor = param1Builder.getDescriptorForType();
      if (param1JsonElement instanceof JsonPrimitive) {
        jsonPrimitive = (JsonPrimitive)param1JsonElement;
        if (jsonPrimitive.isBoolean()) {
          param1Builder.setField(descriptor.findFieldByName("bool_value"), Boolean.valueOf(jsonPrimitive.getAsBoolean()));
          return;
        } 
        if (jsonPrimitive.isNumber()) {
          param1Builder.setField(descriptor.findFieldByName("number_value"), Double.valueOf(jsonPrimitive.getAsDouble()));
          return;
        } 
        param1Builder.setField(descriptor.findFieldByName("string_value"), jsonPrimitive.getAsString());
        return;
      } 
      if (jsonPrimitive instanceof JsonObject) {
        fieldDescriptor = descriptor.findFieldByName("struct_value");
        Message.Builder builder = param1Builder.newBuilderForField(fieldDescriptor);
        merge((JsonElement)jsonPrimitive, builder);
        param1Builder.setField(fieldDescriptor, builder.build());
        return;
      } 
      if (jsonPrimitive instanceof JsonArray) {
        fieldDescriptor = fieldDescriptor.findFieldByName("list_value");
        Message.Builder builder = param1Builder.newBuilderForField(fieldDescriptor);
        merge((JsonElement)jsonPrimitive, builder);
        param1Builder.setField(fieldDescriptor, builder.build());
        return;
      } 
      if (jsonPrimitive instanceof com.google.gson.JsonNull) {
        param1Builder.setField(fieldDescriptor.findFieldByName("null_value"), NullValue.NULL_VALUE.getValueDescriptor());
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected json data: ");
      stringBuilder.append(jsonPrimitive);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    private void mergeWrapper(JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      Descriptors.Descriptor descriptor = param1Builder.getDescriptorForType();
      Descriptors.FieldDescriptor fieldDescriptor = descriptor.findFieldByName("value");
      if (fieldDescriptor != null) {
        param1Builder.setField(fieldDescriptor, parseFieldValue(fieldDescriptor, param1JsonElement, param1Builder));
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid wrapper type: ");
      stringBuilder.append(descriptor.getFullName());
      throw new InvalidProtocolBufferException(stringBuilder.toString());
    }
    
    private boolean parseBool(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      if (param1JsonElement.getAsString().equals("true"))
        return true; 
      if (param1JsonElement.getAsString().equals("false"))
        return false; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid bool value: ");
      stringBuilder.append(param1JsonElement);
      throw new InvalidProtocolBufferException(stringBuilder.toString());
    }
    
    private ByteString parseBytes(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      try {
        return ByteString.copyFrom(BaseEncoding.b().a(param1JsonElement.getAsString()));
      } catch (IllegalArgumentException illegalArgumentException) {
        return ByteString.copyFrom(BaseEncoding.c().a(param1JsonElement.getAsString()));
      } 
    }
    
    private double parseDouble(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      if (param1JsonElement.getAsString().equals("NaN"))
        return Double.NaN; 
      if (param1JsonElement.getAsString().equals("Infinity"))
        return Double.POSITIVE_INFINITY; 
      if (param1JsonElement.getAsString().equals("-Infinity"))
        return Double.NEGATIVE_INFINITY; 
      try {
        BigDecimal bigDecimal = new BigDecimal(param1JsonElement.getAsString());
        if (bigDecimal.compareTo(MAX_DOUBLE) <= 0 && bigDecimal.compareTo(MIN_DOUBLE) >= 0)
          return bigDecimal.doubleValue(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range double value: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not an double value: ");
        stringBuilder.append(invalidProtocolBufferException);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
    }
    
    private Descriptors.EnumValueDescriptor parseEnum(Descriptors.EnumDescriptor param1EnumDescriptor, JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      String str = param1JsonElement.getAsString();
      Descriptors.EnumValueDescriptor enumValueDescriptor = param1EnumDescriptor.findValueByName(str);
      if (enumValueDescriptor == null) {
        Descriptors.EnumValueDescriptor enumValueDescriptor1;
        try {
          int i = parseInt32(param1JsonElement);
          if (param1EnumDescriptor.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3) {
            enumValueDescriptor1 = param1EnumDescriptor.findValueByNumberCreatingIfUnknown(i);
          } else {
            enumValueDescriptor1 = param1EnumDescriptor.findValueByNumber(i);
          } 
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          enumValueDescriptor1 = enumValueDescriptor;
        } 
        if (enumValueDescriptor1 != null)
          return enumValueDescriptor1; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid enum value: ");
        stringBuilder.append(str);
        stringBuilder.append(" for enum type: ");
        stringBuilder.append(param1EnumDescriptor.getFullName());
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
      return enumValueDescriptor;
    }
    
    private Object parseFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      Message.Builder builder;
      StringBuilder stringBuilder;
      int i;
      if (param1JsonElement instanceof com.google.gson.JsonNull) {
        if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && param1FieldDescriptor.getMessageType().getFullName().equals(Value.getDescriptor().getFullName())) {
          Value value = Value.newBuilder().setNullValueValue(0).build();
          return param1Builder.newBuilderForField(param1FieldDescriptor).mergeFrom(value.toByteString()).build();
        } 
        return (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM && param1FieldDescriptor.getEnumType().getFullName().equals(NullValue.getDescriptor().getFullName())) ? param1FieldDescriptor.getEnumType().findValueByNumber(0) : null;
      } 
      switch (param1FieldDescriptor.getType()) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid field type: ");
          stringBuilder.append(param1FieldDescriptor.getType());
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        case MESSAGE:
        case null:
          i = this.currentDepth;
          if (i < this.recursionLimit) {
            this.currentDepth = i + 1;
            builder = param1Builder.newBuilderForField(param1FieldDescriptor);
            merge((JsonElement)stringBuilder, builder);
            this.currentDepth--;
            return builder.build();
          } 
          throw new InvalidProtocolBufferException("Hit recursion limit.");
        case ENUM:
          return parseEnum(builder.getEnumType(), (JsonElement)stringBuilder);
        case BYTES:
          return parseBytes((JsonElement)stringBuilder);
        case STRING:
          return parseString((JsonElement)stringBuilder);
        case UINT64:
        case FIXED64:
          return Long.valueOf(parseUint64((JsonElement)stringBuilder));
        case UINT32:
        case FIXED32:
          return Integer.valueOf(parseUint32((JsonElement)stringBuilder));
        case DOUBLE:
          return Double.valueOf(parseDouble((JsonElement)stringBuilder));
        case FLOAT:
          return Float.valueOf(parseFloat((JsonElement)stringBuilder));
        case BOOL:
          return Boolean.valueOf(parseBool((JsonElement)stringBuilder));
        case INT64:
        case SINT64:
        case SFIXED64:
          return Long.valueOf(parseInt64((JsonElement)stringBuilder));
        case INT32:
        case SINT32:
        case SFIXED32:
          break;
      } 
      return Integer.valueOf(parseInt32((JsonElement)stringBuilder));
    }
    
    private float parseFloat(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      if (param1JsonElement.getAsString().equals("NaN"))
        return Float.NaN; 
      if (param1JsonElement.getAsString().equals("Infinity"))
        return Float.POSITIVE_INFINITY; 
      if (param1JsonElement.getAsString().equals("-Infinity"))
        return Float.NEGATIVE_INFINITY; 
      try {
        double d = Double.parseDouble(param1JsonElement.getAsString());
        if (d <= 3.402826869208755E38D && d >= -3.402826869208755E38D)
          return (float)d; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range float value: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a float value: ");
        stringBuilder.append(invalidProtocolBufferException);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
    }
    
    private int parseInt32(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      try {
        return Integer.parseInt(param1JsonElement.getAsString());
      } catch (Exception exception) {
        try {
          return (new BigDecimal(param1JsonElement.getAsString())).intValueExact();
        } catch (Exception exception1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Not an int32 value: ");
          stringBuilder.append(param1JsonElement);
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        } 
      } 
    }
    
    private long parseInt64(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      try {
        return Long.parseLong(param1JsonElement.getAsString());
      } catch (Exception exception) {
        try {
          return (new BigDecimal(param1JsonElement.getAsString())).longValueExact();
        } catch (Exception exception1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Not an int64 value: ");
          stringBuilder.append(param1JsonElement);
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        } 
      } 
    }
    
    private String parseString(JsonElement param1JsonElement) {
      return param1JsonElement.getAsString();
    }
    
    private int parseUint32(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      try {
        long l = Long.parseLong(param1JsonElement.getAsString());
        if (l >= 0L && l <= 4294967295L)
          return (int)l; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range uint32 value: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (Exception exception) {
        try {
          BigInteger bigInteger = (new BigDecimal(invalidProtocolBufferException.getAsString())).toBigIntegerExact();
          if (bigInteger.signum() >= 0 && bigInteger.compareTo(new BigInteger("FFFFFFFF", 16)) <= 0)
            return bigInteger.intValue(); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Out of range uint32 value: ");
          stringBuilder.append(invalidProtocolBufferException);
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        } catch (InvalidProtocolBufferException invalidProtocolBufferException1) {
          throw invalidProtocolBufferException1;
        } catch (Exception exception1) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Not an uint32 value: ");
          stringBuilder.append(invalidProtocolBufferException1);
          throw new InvalidProtocolBufferException(stringBuilder.toString());
        } 
      } 
    }
    
    private long parseUint64(JsonElement param1JsonElement) throws InvalidProtocolBufferException {
      try {
        BigInteger bigInteger = (new BigDecimal(param1JsonElement.getAsString())).toBigIntegerExact();
        if (bigInteger.compareTo(BigInteger.ZERO) >= 0 && bigInteger.compareTo(MAX_UINT64) <= 0)
          return bigInteger.longValue(); 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of range uint64 value: ");
        stringBuilder.append(param1JsonElement);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not an uint64 value: ");
        stringBuilder.append(invalidProtocolBufferException);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
    }
    
    void merge(Reader param1Reader, Message.Builder param1Builder) throws IOException {
      try {
        JsonReader jsonReader = new JsonReader(param1Reader);
        jsonReader.setLenient(false);
        merge(this.jsonParser.parse(jsonReader), param1Builder);
        return;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (JsonIOException jsonIOException) {
        if (jsonIOException.getCause() instanceof IOException)
          throw (IOException)jsonIOException.getCause(); 
        throw new InvalidProtocolBufferException(jsonIOException.getMessage());
      } catch (Exception exception) {
        throw new InvalidProtocolBufferException(exception.getMessage());
      } 
    }
    
    void merge(String param1String, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      try {
        JsonReader jsonReader = new JsonReader(new StringReader(param1String));
        jsonReader.setLenient(false);
        merge(this.jsonParser.parse(jsonReader), param1Builder);
        return;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (Exception exception) {
        throw new InvalidProtocolBufferException(exception.getMessage());
      } 
    }
    
    static interface WellKnownTypeParser {
      void merge(JsonFormat.ParserImpl param2ParserImpl, JsonElement param2JsonElement, Message.Builder param2Builder) throws InvalidProtocolBufferException;
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeAny(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeWrapper(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeTimestamp(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeDuration(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeFieldMask(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeStruct(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeListValue(param1JsonElement, param1Builder);
    }
  }
  
  static final class null implements ParserImpl.WellKnownTypeParser {
    public void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException {
      param1ParserImpl.mergeValue(param1JsonElement, param1Builder);
    }
  }
  
  static interface WellKnownTypeParser {
    void merge(JsonFormat.ParserImpl param1ParserImpl, JsonElement param1JsonElement, Message.Builder param1Builder) throws InvalidProtocolBufferException;
  }
  
  static final class PrettyTextGenerator implements TextGenerator {
    private boolean atStartOfLine = true;
    
    private final StringBuilder indent = new StringBuilder();
    
    private final Appendable output;
    
    private PrettyTextGenerator(Appendable param1Appendable) {
      this.output = param1Appendable;
    }
    
    private void write(CharSequence param1CharSequence) throws IOException {
      if (param1CharSequence.length() == 0)
        return; 
      if (this.atStartOfLine) {
        this.atStartOfLine = false;
        this.output.append(this.indent);
      } 
      this.output.append(param1CharSequence);
    }
    
    public void indent() {
      this.indent.append("  ");
    }
    
    public void outdent() {
      int i = this.indent.length();
      if (i >= 2) {
        this.indent.delete(i - 2, i);
        return;
      } 
      throw new IllegalArgumentException(" Outdent() without matching Indent().");
    }
    
    public void print(CharSequence param1CharSequence) throws IOException {
      int k = param1CharSequence.length();
      int i = 0;
      int j;
      for (j = 0; i < k; j = m) {
        int m = j;
        if (param1CharSequence.charAt(i) == '\n') {
          m = i + 1;
          write(param1CharSequence.subSequence(j, m));
          this.atStartOfLine = true;
        } 
        i++;
      } 
      write(param1CharSequence.subSequence(j, k));
    }
  }
  
  public static class Printer {
    private boolean alwaysOutputDefaultValueFields;
    
    private Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
    
    private final boolean omittingInsignificantWhitespace;
    
    private final boolean preservingProtoFieldNames;
    
    private final JsonFormat.TypeRegistry registry;
    
    private Printer(JsonFormat.TypeRegistry param1TypeRegistry, boolean param1Boolean1, Set<Descriptors.FieldDescriptor> param1Set, boolean param1Boolean2, boolean param1Boolean3) {
      this.registry = param1TypeRegistry;
      this.alwaysOutputDefaultValueFields = param1Boolean1;
      this.includingDefaultValueFields = param1Set;
      this.preservingProtoFieldNames = param1Boolean2;
      this.omittingInsignificantWhitespace = param1Boolean3;
    }
    
    private void checkUnsetIncludingDefaultValueFields() {
      if (!this.alwaysOutputDefaultValueFields && this.includingDefaultValueFields.isEmpty())
        return; 
      throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
    }
    
    public void appendTo(MessageOrBuilder param1MessageOrBuilder, Appendable param1Appendable) throws IOException {
      (new JsonFormat.PrinterImpl(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, param1Appendable, this.omittingInsignificantWhitespace)).print(param1MessageOrBuilder);
    }
    
    public Printer includingDefaultValueFields() {
      checkUnsetIncludingDefaultValueFields();
      return new Printer(this.registry, true, Collections.emptySet(), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace);
    }
    
    public Printer includingDefaultValueFields(Set<Descriptors.FieldDescriptor> param1Set) {
      boolean bool;
      if (param1Set != null && !param1Set.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, "Non-empty Set must be supplied for includingDefaultValueFields.");
      checkUnsetIncludingDefaultValueFields();
      return new Printer(this.registry, false, param1Set, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace);
    }
    
    public Printer omittingInsignificantWhitespace() {
      return new Printer(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, true);
    }
    
    public Printer preservingProtoFieldNames() {
      return new Printer(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, true, this.omittingInsignificantWhitespace);
    }
    
    public String print(MessageOrBuilder param1MessageOrBuilder) throws InvalidProtocolBufferException {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        appendTo(param1MessageOrBuilder, stringBuilder);
        return stringBuilder.toString();
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public Printer usingTypeRegistry(JsonFormat.TypeRegistry param1TypeRegistry) {
      if (this.registry == JsonFormat.TypeRegistry.getEmptyTypeRegistry())
        return new Printer(param1TypeRegistry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace); 
      throw new IllegalArgumentException("Only one registry is allowed.");
    }
  }
  
  static final class PrinterImpl {
    private static final Map<String, WellKnownTypePrinter> wellKnownTypePrinters = buildWellKnownTypePrinters();
    
    private final boolean alwaysOutputDefaultValueFields;
    
    private final CharSequence blankOrNewLine;
    
    private final CharSequence blankOrSpace;
    
    private final JsonFormat.TextGenerator generator;
    
    private final Gson gson;
    
    private final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
    
    private final boolean preservingProtoFieldNames;
    
    private final JsonFormat.TypeRegistry registry;
    
    PrinterImpl(JsonFormat.TypeRegistry param1TypeRegistry, boolean param1Boolean1, Set<Descriptors.FieldDescriptor> param1Set, boolean param1Boolean2, Appendable param1Appendable, boolean param1Boolean3) {
      this.registry = param1TypeRegistry;
      this.alwaysOutputDefaultValueFields = param1Boolean1;
      this.includingDefaultValueFields = param1Set;
      this.preservingProtoFieldNames = param1Boolean2;
      this.gson = GsonHolder.DEFAULT_GSON;
      if (param1Boolean3) {
        this.generator = new JsonFormat.CompactTextGenerator(param1Appendable);
        this.blankOrSpace = "";
        this.blankOrNewLine = "";
        return;
      } 
      this.generator = new JsonFormat.PrettyTextGenerator(param1Appendable);
      this.blankOrSpace = " ";
      this.blankOrNewLine = "\n";
    }
    
    private static Map<String, WellKnownTypePrinter> buildWellKnownTypePrinters() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put(Any.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printAny(param2MessageOrBuilder);
            }
          });
      WellKnownTypePrinter wellKnownTypePrinter = new WellKnownTypePrinter() {
          public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
            param2PrinterImpl.printWrapper(param2MessageOrBuilder);
          }
        };
      hashMap.put(BoolValue.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(Int32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(UInt32Value.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(Int64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(UInt64Value.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(StringValue.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(BytesValue.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(FloatValue.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(DoubleValue.getDescriptor().getFullName(), wellKnownTypePrinter);
      hashMap.put(Timestamp.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printTimestamp(param2MessageOrBuilder);
            }
          });
      hashMap.put(Duration.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printDuration(param2MessageOrBuilder);
            }
          });
      hashMap.put(FieldMask.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printFieldMask(param2MessageOrBuilder);
            }
          });
      hashMap.put(Struct.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printStruct(param2MessageOrBuilder);
            }
          });
      hashMap.put(Value.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printValue(param2MessageOrBuilder);
            }
          });
      hashMap.put(ListValue.getDescriptor().getFullName(), new WellKnownTypePrinter() {
            public void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException {
              param2PrinterImpl.printListValue(param2MessageOrBuilder);
            }
          });
      return (Map)hashMap;
    }
    
    private void print(MessageOrBuilder param1MessageOrBuilder, String param1String) throws IOException {
      Map map;
      boolean bool;
      JsonFormat.TextGenerator textGenerator = this.generator;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{");
      stringBuilder.append(this.blankOrNewLine);
      textGenerator.print(stringBuilder.toString());
      this.generator.indent();
      if (param1String != null) {
        textGenerator = this.generator;
        stringBuilder = new StringBuilder();
        stringBuilder.append("\"@type\":");
        stringBuilder.append(this.blankOrSpace);
        stringBuilder.append(this.gson.toJson(param1String));
        textGenerator.print(stringBuilder.toString());
        bool = true;
      } else {
        bool = false;
      } 
      if (this.alwaysOutputDefaultValueFields || !this.includingDefaultValueFields.isEmpty()) {
        TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(param1MessageOrBuilder.getAllFields());
        for (Descriptors.FieldDescriptor fieldDescriptor : param1MessageOrBuilder.getDescriptorForType().getFields()) {
          if ((!fieldDescriptor.isOptional() || ((fieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE || param1MessageOrBuilder.hasField(fieldDescriptor)) && (fieldDescriptor.getContainingOneof() == null || param1MessageOrBuilder.hasField(fieldDescriptor)))) && !treeMap.containsKey(fieldDescriptor) && (this.alwaysOutputDefaultValueFields || this.includingDefaultValueFields.contains(fieldDescriptor)))
            treeMap.put(fieldDescriptor, param1MessageOrBuilder.getField(fieldDescriptor)); 
        } 
        map = treeMap;
      } else {
        map = map.getAllFields();
      } 
      for (Map.Entry entry : map.entrySet()) {
        if (bool) {
          textGenerator = this.generator;
          stringBuilder = new StringBuilder();
          stringBuilder.append(",");
          stringBuilder.append(this.blankOrNewLine);
          textGenerator.print(stringBuilder.toString());
        } else {
          bool = true;
        } 
        printField((Descriptors.FieldDescriptor)entry.getKey(), entry.getValue());
      } 
      if (bool)
        this.generator.print(this.blankOrNewLine); 
      this.generator.outdent();
      this.generator.print("}");
    }
    
    private void printAny(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      if (Any.getDefaultInstance().equals(param1MessageOrBuilder)) {
        this.generator.print("{}");
        return;
      } 
      Descriptors.Descriptor descriptor = param1MessageOrBuilder.getDescriptorForType();
      Descriptors.FieldDescriptor fieldDescriptor1 = descriptor.findFieldByName("type_url");
      Descriptors.FieldDescriptor fieldDescriptor2 = descriptor.findFieldByName("value");
      if (fieldDescriptor1 != null && fieldDescriptor2 != null && fieldDescriptor1.getType() == Descriptors.FieldDescriptor.Type.STRING && fieldDescriptor2.getType() == Descriptors.FieldDescriptor.Type.BYTES) {
        JsonFormat.TextGenerator textGenerator;
        String str1 = (String)param1MessageOrBuilder.getField(fieldDescriptor1);
        String str2 = JsonFormat.getTypeName(str1);
        Descriptors.Descriptor descriptor1 = this.registry.find(str2);
        if (descriptor1 != null) {
          ByteString byteString = (ByteString)param1MessageOrBuilder.getField(fieldDescriptor2);
          Message message = (Message)DynamicMessage.getDefaultInstance(descriptor1).getParserForType().parseFrom(byteString);
          WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(str2);
          if (wellKnownTypePrinter != null) {
            JsonFormat.TextGenerator textGenerator1 = this.generator;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("{");
            stringBuilder2.append(this.blankOrNewLine);
            textGenerator1.print(stringBuilder2.toString());
            this.generator.indent();
            textGenerator1 = this.generator;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\"@type\":");
            stringBuilder2.append(this.blankOrSpace);
            stringBuilder2.append(this.gson.toJson(str1));
            stringBuilder2.append(",");
            stringBuilder2.append(this.blankOrNewLine);
            textGenerator1.print(stringBuilder2.toString());
            textGenerator = this.generator;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("\"value\":");
            stringBuilder1.append(this.blankOrSpace);
            textGenerator.print(stringBuilder1.toString());
            wellKnownTypePrinter.print(this, (MessageOrBuilder)message);
            this.generator.print(this.blankOrNewLine);
            this.generator.outdent();
            this.generator.print("}");
            return;
          } 
          print((MessageOrBuilder)message, (String)textGenerator);
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find type for url: ");
        stringBuilder.append((String)textGenerator);
        throw new InvalidProtocolBufferException(stringBuilder.toString());
      } 
      throw new InvalidProtocolBufferException("Invalid Any type.");
    }
    
    private void printDuration(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Duration duration = Duration.parseFrom(toByteString(param1MessageOrBuilder));
      JsonFormat.TextGenerator textGenerator = this.generator;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\"");
      stringBuilder.append(Durations.toString(duration));
      stringBuilder.append("\"");
      textGenerator.print(stringBuilder.toString());
    }
    
    private void printField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) throws IOException {
      if (this.preservingProtoFieldNames) {
        JsonFormat.TextGenerator textGenerator = this.generator;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(param1FieldDescriptor.getName());
        stringBuilder.append("\":");
        stringBuilder.append(this.blankOrSpace);
        textGenerator.print(stringBuilder.toString());
      } else {
        JsonFormat.TextGenerator textGenerator = this.generator;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(param1FieldDescriptor.getJsonName());
        stringBuilder.append("\":");
        stringBuilder.append(this.blankOrSpace);
        textGenerator.print(stringBuilder.toString());
      } 
      if (param1FieldDescriptor.isMapField()) {
        printMapFieldValue(param1FieldDescriptor, param1Object);
        return;
      } 
      if (param1FieldDescriptor.isRepeated()) {
        printRepeatedFieldValue(param1FieldDescriptor, param1Object);
        return;
      } 
      printSingleFieldValue(param1FieldDescriptor, param1Object);
    }
    
    private void printFieldMask(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      FieldMask fieldMask = FieldMask.parseFrom(toByteString(param1MessageOrBuilder));
      JsonFormat.TextGenerator textGenerator = this.generator;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\"");
      stringBuilder.append(FieldMaskUtil.toJsonString(fieldMask));
      stringBuilder.append("\"");
      textGenerator.print(stringBuilder.toString());
    }
    
    private void printListValue(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Descriptors.FieldDescriptor fieldDescriptor = param1MessageOrBuilder.getDescriptorForType().findFieldByName("values");
      if (fieldDescriptor != null) {
        printRepeatedFieldValue(fieldDescriptor, param1MessageOrBuilder.getField(fieldDescriptor));
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid ListValue type.");
    }
    
    private void printMapFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) throws IOException {
      Descriptors.Descriptor descriptor = param1FieldDescriptor.getMessageType();
      param1FieldDescriptor = descriptor.findFieldByName("key");
      Descriptors.FieldDescriptor fieldDescriptor = descriptor.findFieldByName("value");
      if (param1FieldDescriptor != null && fieldDescriptor != null) {
        JsonFormat.TextGenerator textGenerator = this.generator;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(this.blankOrNewLine);
        textGenerator.print(stringBuilder.toString());
        this.generator.indent();
        boolean bool = false;
        param1Object = ((List)param1Object).iterator();
        while (param1Object.hasNext()) {
          Message message = param1Object.next();
          Object object2 = message.getField(param1FieldDescriptor);
          Object object1 = message.getField(fieldDescriptor);
          if (bool) {
            JsonFormat.TextGenerator textGenerator1 = this.generator;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(",");
            stringBuilder2.append(this.blankOrNewLine);
            textGenerator1.print(stringBuilder2.toString());
          } else {
            bool = true;
          } 
          printSingleFieldValue(param1FieldDescriptor, object2, true);
          object2 = this.generator;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(":");
          stringBuilder1.append(this.blankOrSpace);
          object2.print(stringBuilder1.toString());
          printSingleFieldValue(fieldDescriptor, object1);
        } 
        if (bool)
          this.generator.print(this.blankOrNewLine); 
        this.generator.outdent();
        this.generator.print("}");
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid map field.");
    }
    
    private void printRepeatedFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) throws IOException {
      this.generator.print("[");
      param1Object = ((List)param1Object).iterator();
      boolean bool = false;
      while (param1Object.hasNext()) {
        Object object = param1Object.next();
        if (bool) {
          JsonFormat.TextGenerator textGenerator = this.generator;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(",");
          stringBuilder.append(this.blankOrSpace);
          textGenerator.print(stringBuilder.toString());
        } else {
          bool = true;
        } 
        printSingleFieldValue(param1FieldDescriptor, object);
      } 
      this.generator.print("]");
    }
    
    private void printSingleFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) throws IOException {
      printSingleFieldValue(param1FieldDescriptor, param1Object, false);
    }
    
    private void printSingleFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object, boolean param1Boolean) throws IOException {
      JsonFormat.TextGenerator textGenerator2;
      Double double_;
      Float float_;
      JsonFormat.TextGenerator textGenerator1;
      StringBuilder stringBuilder;
      switch (param1FieldDescriptor.getType()) {
        default:
          return;
        case MESSAGE:
        case null:
          print((MessageOrBuilder)param1Object);
          return;
        case ENUM:
          if (param1FieldDescriptor.getEnumType().getFullName().equals("google.protobuf.NullValue")) {
            if (param1Boolean)
              this.generator.print("\""); 
            this.generator.print("null");
            if (param1Boolean) {
              this.generator.print("\"");
              return;
            } 
          } else {
            Descriptors.EnumValueDescriptor enumValueDescriptor = (Descriptors.EnumValueDescriptor)param1Object;
            if (enumValueDescriptor.getIndex() == -1) {
              this.generator.print(String.valueOf(enumValueDescriptor.getNumber()));
              return;
            } 
            param1Object = this.generator;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("\"");
            stringBuilder1.append(enumValueDescriptor.getName());
            stringBuilder1.append("\"");
            param1Object.print(stringBuilder1.toString());
            return;
          } 
          return;
        case BYTES:
          this.generator.print("\"");
          this.generator.print(BaseEncoding.b().a(((ByteString)param1Object).toByteArray()));
          this.generator.print("\"");
          return;
        case STRING:
          this.generator.print(this.gson.toJson(param1Object));
          return;
        case UINT64:
        case FIXED64:
          textGenerator2 = this.generator;
          stringBuilder = new StringBuilder();
          stringBuilder.append("\"");
          stringBuilder.append(JsonFormat.unsignedToString(((Long)param1Object).longValue()));
          stringBuilder.append("\"");
          textGenerator2.print(stringBuilder.toString());
          return;
        case UINT32:
        case FIXED32:
          if (param1Boolean)
            this.generator.print("\""); 
          this.generator.print(JsonFormat.unsignedToString(((Integer)param1Object).intValue()));
          if (param1Boolean) {
            this.generator.print("\"");
            return;
          } 
          return;
        case DOUBLE:
          double_ = (Double)param1Object;
          if (double_.isNaN()) {
            this.generator.print("\"NaN\"");
            return;
          } 
          if (double_.isInfinite()) {
            if (double_.doubleValue() < 0.0D) {
              this.generator.print("\"-Infinity\"");
              return;
            } 
            this.generator.print("\"Infinity\"");
            return;
          } 
          if (param1Boolean)
            this.generator.print("\""); 
          this.generator.print(double_.toString());
          if (param1Boolean) {
            this.generator.print("\"");
            return;
          } 
          return;
        case FLOAT:
          float_ = (Float)param1Object;
          if (float_.isNaN()) {
            this.generator.print("\"NaN\"");
            return;
          } 
          if (float_.isInfinite()) {
            if (float_.floatValue() < 0.0F) {
              this.generator.print("\"-Infinity\"");
              return;
            } 
            this.generator.print("\"Infinity\"");
            return;
          } 
          if (param1Boolean)
            this.generator.print("\""); 
          this.generator.print(float_.toString());
          if (param1Boolean) {
            this.generator.print("\"");
            return;
          } 
          return;
        case BOOL:
          if (param1Boolean)
            this.generator.print("\""); 
          if (((Boolean)param1Object).booleanValue()) {
            this.generator.print("true");
          } else {
            this.generator.print("false");
          } 
          if (param1Boolean) {
            this.generator.print("\"");
            return;
          } 
          return;
        case INT64:
        case SINT64:
        case SFIXED64:
          textGenerator1 = this.generator;
          stringBuilder = new StringBuilder();
          stringBuilder.append("\"");
          stringBuilder.append(((Long)param1Object).toString());
          stringBuilder.append("\"");
          textGenerator1.print(stringBuilder.toString());
          return;
        case INT32:
        case SINT32:
        case SFIXED32:
          break;
      } 
      if (param1Boolean)
        this.generator.print("\""); 
      this.generator.print(((Integer)param1Object).toString());
      if (param1Boolean)
        this.generator.print("\""); 
    }
    
    private void printStruct(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Descriptors.FieldDescriptor fieldDescriptor = param1MessageOrBuilder.getDescriptorForType().findFieldByName("fields");
      if (fieldDescriptor != null) {
        printMapFieldValue(fieldDescriptor, param1MessageOrBuilder.getField(fieldDescriptor));
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid Struct type.");
    }
    
    private void printTimestamp(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Timestamp timestamp = Timestamp.parseFrom(toByteString(param1MessageOrBuilder));
      JsonFormat.TextGenerator textGenerator = this.generator;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\"");
      stringBuilder.append(Timestamps.toString(timestamp));
      stringBuilder.append("\"");
      textGenerator.print(stringBuilder.toString());
    }
    
    private void printValue(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Map map = param1MessageOrBuilder.getAllFields();
      if (map.isEmpty()) {
        this.generator.print("null");
        return;
      } 
      if (map.size() == 1) {
        for (Map.Entry entry : map.entrySet())
          printSingleFieldValue((Descriptors.FieldDescriptor)entry.getKey(), entry.getValue()); 
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid Value type.");
    }
    
    private void printWrapper(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      Descriptors.FieldDescriptor fieldDescriptor = param1MessageOrBuilder.getDescriptorForType().findFieldByName("value");
      if (fieldDescriptor != null) {
        printSingleFieldValue(fieldDescriptor, param1MessageOrBuilder.getField(fieldDescriptor));
        return;
      } 
      throw new InvalidProtocolBufferException("Invalid Wrapper type.");
    }
    
    private ByteString toByteString(MessageOrBuilder param1MessageOrBuilder) {
      return (param1MessageOrBuilder instanceof Message) ? ((Message)param1MessageOrBuilder).toByteString() : ((Message.Builder)param1MessageOrBuilder).build().toByteString();
    }
    
    void print(MessageOrBuilder param1MessageOrBuilder) throws IOException {
      WellKnownTypePrinter wellKnownTypePrinter = wellKnownTypePrinters.get(param1MessageOrBuilder.getDescriptorForType().getFullName());
      if (wellKnownTypePrinter != null) {
        wellKnownTypePrinter.print(this, param1MessageOrBuilder);
        return;
      } 
      print(param1MessageOrBuilder, null);
    }
    
    static class GsonHolder {
      private static final Gson DEFAULT_GSON = (new GsonBuilder()).disableHtmlEscaping().create();
    }
    
    static interface WellKnownTypePrinter {
      void print(JsonFormat.PrinterImpl param2PrinterImpl, MessageOrBuilder param2MessageOrBuilder) throws IOException;
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printAny(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printWrapper(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printTimestamp(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printDuration(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printFieldMask(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printStruct(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printValue(param1MessageOrBuilder);
    }
  }
  
  static final class null implements PrinterImpl.WellKnownTypePrinter {
    public void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException {
      param1PrinterImpl.printListValue(param1MessageOrBuilder);
    }
  }
  
  static class GsonHolder {
    private static final Gson DEFAULT_GSON = (new GsonBuilder()).disableHtmlEscaping().create();
  }
  
  static interface WellKnownTypePrinter {
    void print(JsonFormat.PrinterImpl param1PrinterImpl, MessageOrBuilder param1MessageOrBuilder) throws IOException;
  }
  
  static interface TextGenerator {
    void indent();
    
    void outdent();
    
    void print(CharSequence param1CharSequence) throws IOException;
  }
  
  public static class TypeRegistry {
    private final Map<String, Descriptors.Descriptor> types;
    
    private TypeRegistry(Map<String, Descriptors.Descriptor> param1Map) {
      this.types = param1Map;
    }
    
    public static TypeRegistry getEmptyTypeRegistry() {
      return EmptyTypeRegistryHolder.EMPTY;
    }
    
    public static Builder newBuilder() {
      return new Builder();
    }
    
    public Descriptors.Descriptor find(String param1String) {
      return this.types.get(param1String);
    }
    
    public static class Builder {
      private final Set<String> files = new HashSet<String>();
      
      private Map<String, Descriptors.Descriptor> types = new HashMap<String, Descriptors.Descriptor>();
      
      private Builder() {}
      
      private void addFile(Descriptors.FileDescriptor param2FileDescriptor) {
        if (!this.files.add(param2FileDescriptor.getFullName()))
          return; 
        Iterator<Descriptors.FileDescriptor> iterator1 = param2FileDescriptor.getDependencies().iterator();
        while (iterator1.hasNext())
          addFile(iterator1.next()); 
        Iterator<Descriptors.Descriptor> iterator = param2FileDescriptor.getMessageTypes().iterator();
        while (iterator.hasNext())
          addMessage(iterator.next()); 
      }
      
      private void addMessage(Descriptors.Descriptor param2Descriptor) {
        Iterator<Descriptors.Descriptor> iterator = param2Descriptor.getNestedTypes().iterator();
        while (iterator.hasNext())
          addMessage(iterator.next()); 
        if (this.types.containsKey(param2Descriptor.getFullName())) {
          Logger logger = JsonFormat.logger;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Type ");
          stringBuilder.append(param2Descriptor.getFullName());
          stringBuilder.append(" is added multiple times.");
          logger.warning(stringBuilder.toString());
          return;
        } 
        this.types.put(param2Descriptor.getFullName(), param2Descriptor);
      }
      
      public Builder add(Descriptors.Descriptor param2Descriptor) {
        if (this.types != null) {
          addFile(param2Descriptor.getFile());
          return this;
        } 
        throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
      }
      
      public Builder add(Iterable<Descriptors.Descriptor> param2Iterable) {
        if (this.types != null) {
          Iterator<Descriptors.Descriptor> iterator = param2Iterable.iterator();
          while (iterator.hasNext())
            addFile(((Descriptors.Descriptor)iterator.next()).getFile()); 
          return this;
        } 
        throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
      }
      
      public JsonFormat.TypeRegistry build() {
        JsonFormat.TypeRegistry typeRegistry = new JsonFormat.TypeRegistry(this.types);
        this.types = null;
        return typeRegistry;
      }
    }
    
    static class EmptyTypeRegistryHolder {
      private static final JsonFormat.TypeRegistry EMPTY = new JsonFormat.TypeRegistry(Collections.emptyMap());
    }
  }
  
  public static class Builder {
    private final Set<String> files = new HashSet<String>();
    
    private Map<String, Descriptors.Descriptor> types = new HashMap<String, Descriptors.Descriptor>();
    
    private Builder() {}
    
    private void addFile(Descriptors.FileDescriptor param1FileDescriptor) {
      if (!this.files.add(param1FileDescriptor.getFullName()))
        return; 
      Iterator<Descriptors.FileDescriptor> iterator1 = param1FileDescriptor.getDependencies().iterator();
      while (iterator1.hasNext())
        addFile(iterator1.next()); 
      Iterator<Descriptors.Descriptor> iterator = param1FileDescriptor.getMessageTypes().iterator();
      while (iterator.hasNext())
        addMessage(iterator.next()); 
    }
    
    private void addMessage(Descriptors.Descriptor param1Descriptor) {
      Iterator<Descriptors.Descriptor> iterator = param1Descriptor.getNestedTypes().iterator();
      while (iterator.hasNext())
        addMessage(iterator.next()); 
      if (this.types.containsKey(param1Descriptor.getFullName())) {
        Logger logger = JsonFormat.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type ");
        stringBuilder.append(param1Descriptor.getFullName());
        stringBuilder.append(" is added multiple times.");
        logger.warning(stringBuilder.toString());
        return;
      } 
      this.types.put(param1Descriptor.getFullName(), param1Descriptor);
    }
    
    public Builder add(Descriptors.Descriptor param1Descriptor) {
      if (this.types != null) {
        addFile(param1Descriptor.getFile());
        return this;
      } 
      throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
    }
    
    public Builder add(Iterable<Descriptors.Descriptor> param1Iterable) {
      if (this.types != null) {
        Iterator<Descriptors.Descriptor> iterator = param1Iterable.iterator();
        while (iterator.hasNext())
          addFile(((Descriptors.Descriptor)iterator.next()).getFile()); 
        return this;
      } 
      throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
    }
    
    public JsonFormat.TypeRegistry build() {
      JsonFormat.TypeRegistry typeRegistry = new JsonFormat.TypeRegistry(this.types);
      this.types = null;
      return typeRegistry;
    }
  }
  
  static class EmptyTypeRegistryHolder {
    private static final JsonFormat.TypeRegistry EMPTY = new JsonFormat.TypeRegistry(Collections.emptyMap());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\JsonFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */