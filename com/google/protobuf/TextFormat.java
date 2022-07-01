package com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextFormat {
  private static final Parser PARSER;
  
  private static final Logger logger = Logger.getLogger(TextFormat.class.getName());
  
  static {
    PARSER = Parser.newBuilder().build();
  }
  
  private static int digitValue(byte paramByte) {
    int i;
    if (48 <= paramByte && paramByte <= 57)
      return paramByte - 48; 
    if (97 <= paramByte && paramByte <= 122) {
      i = paramByte - 97;
      return i + 10;
    } 
    i -= 65;
    return i + 10;
  }
  
  public static String escapeBytes(ByteString paramByteString) {
    return TextFormatEscaper.escapeBytes(paramByteString);
  }
  
  public static String escapeBytes(byte[] paramArrayOfbyte) {
    return TextFormatEscaper.escapeBytes(paramArrayOfbyte);
  }
  
  public static String escapeDoubleQuotesAndBackslashes(String paramString) {
    return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(paramString);
  }
  
  static String escapeText(String paramString) {
    return escapeBytes(ByteString.copyFromUtf8(paramString));
  }
  
  public static Parser getParser() {
    return PARSER;
  }
  
  private static boolean isHex(byte paramByte) {
    return ((48 <= paramByte && paramByte <= 57) || (97 <= paramByte && paramByte <= 102) || (65 <= paramByte && paramByte <= 70));
  }
  
  private static boolean isOctal(byte paramByte) {
    return (48 <= paramByte && paramByte <= 55);
  }
  
  public static void merge(CharSequence paramCharSequence, ExtensionRegistry paramExtensionRegistry, Message.Builder paramBuilder) throws ParseException {
    PARSER.merge(paramCharSequence, paramExtensionRegistry, paramBuilder);
  }
  
  public static void merge(CharSequence paramCharSequence, Message.Builder paramBuilder) throws ParseException {
    PARSER.merge(paramCharSequence, paramBuilder);
  }
  
  public static void merge(Readable paramReadable, ExtensionRegistry paramExtensionRegistry, Message.Builder paramBuilder) throws IOException {
    PARSER.merge(paramReadable, paramExtensionRegistry, paramBuilder);
  }
  
  public static void merge(Readable paramReadable, Message.Builder paramBuilder) throws IOException {
    PARSER.merge(paramReadable, paramBuilder);
  }
  
  private static TextGenerator multiLineOutput(Appendable paramAppendable) {
    return new TextGenerator(paramAppendable, false);
  }
  
  public static <T extends Message> T parse(CharSequence paramCharSequence, ExtensionRegistry paramExtensionRegistry, Class<T> paramClass) throws ParseException {
    Message.Builder builder = ((Message)Internal.<Message>getDefaultInstance(paramClass)).newBuilderForType();
    merge(paramCharSequence, paramExtensionRegistry, builder);
    return (T)builder.build();
  }
  
  public static <T extends Message> T parse(CharSequence paramCharSequence, Class<T> paramClass) throws ParseException {
    Message.Builder builder = ((Message)Internal.<Message>getDefaultInstance(paramClass)).newBuilderForType();
    merge(paramCharSequence, builder);
    return (T)builder.build();
  }
  
  static int parseInt32(String paramString) throws NumberFormatException {
    return (int)parseInteger(paramString, true, false);
  }
  
  static long parseInt64(String paramString) throws NumberFormatException {
    return parseInteger(paramString, true, true);
  }
  
  private static long parseInteger(String paramString, boolean paramBoolean1, boolean paramBoolean2) throws NumberFormatException {
    byte b3;
    long l;
    StringBuilder stringBuilder;
    byte b1 = 0;
    boolean bool1 = paramString.startsWith("-", 0);
    boolean bool = true;
    if (bool1) {
      if (paramBoolean1) {
        b1 = 1;
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Number must be positive: ");
        stringBuilder.append(paramString);
        throw new NumberFormatException(stringBuilder.toString());
      } 
    } else {
      bool = false;
    } 
    byte b2 = 10;
    if (paramString.startsWith("0x", b1)) {
      b3 = b1 + 2;
      b2 = 16;
    } else {
      b3 = b1;
      if (paramString.startsWith("0", b1)) {
        b2 = 8;
        b3 = b1;
      } 
    } 
    String str = paramString.substring(b3);
    if (str.length() < 16) {
      l = Long.parseLong(str, b2);
      long l1 = l;
      if (bool)
        l1 = -l; 
      l = l1;
      if (!paramBoolean2) {
        if (paramBoolean1) {
          if (l1 <= 2147483647L && l1 >= -2147483648L)
            return l1; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Number out of range for 32-bit signed integer: ");
          stringBuilder1.append(paramString);
          throw new NumberFormatException(stringBuilder1.toString());
        } 
        if (l1 < 4294967296L && l1 >= 0L)
          return l1; 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Number out of range for 32-bit unsigned integer: ");
        stringBuilder.append(paramString);
        throw new NumberFormatException(stringBuilder.toString());
      } 
    } else {
      StringBuilder stringBuilder1;
      BigInteger bigInteger2 = new BigInteger((String)stringBuilder, b2);
      BigInteger bigInteger1 = bigInteger2;
      if (bool)
        bigInteger1 = bigInteger2.negate(); 
      if (!paramBoolean2) {
        if (paramBoolean1) {
          if (bigInteger1.bitLength() > 31) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Number out of range for 32-bit signed integer: ");
            stringBuilder1.append(paramString);
            throw new NumberFormatException(stringBuilder1.toString());
          } 
        } else if (stringBuilder1.bitLength() > 32) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Number out of range for 32-bit unsigned integer: ");
          stringBuilder1.append(paramString);
          throw new NumberFormatException(stringBuilder1.toString());
        } 
      } else if (paramBoolean1) {
        if (stringBuilder1.bitLength() > 63) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Number out of range for 64-bit signed integer: ");
          stringBuilder1.append(paramString);
          throw new NumberFormatException(stringBuilder1.toString());
        } 
      } else if (stringBuilder1.bitLength() > 64) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Number out of range for 64-bit unsigned integer: ");
        stringBuilder1.append(paramString);
        throw new NumberFormatException(stringBuilder1.toString());
      } 
      l = stringBuilder1.longValue();
    } 
    return l;
  }
  
  static int parseUInt32(String paramString) throws NumberFormatException {
    return (int)parseInteger(paramString, false, false);
  }
  
  static long parseUInt64(String paramString) throws NumberFormatException {
    return parseInteger(paramString, false, true);
  }
  
  @Deprecated
  public static void print(MessageOrBuilder paramMessageOrBuilder, Appendable paramAppendable) throws IOException {
    printer().print(paramMessageOrBuilder, paramAppendable);
  }
  
  @Deprecated
  public static void print(UnknownFieldSet paramUnknownFieldSet, Appendable paramAppendable) throws IOException {
    printer().print(paramUnknownFieldSet, paramAppendable);
  }
  
  @Deprecated
  public static void printField(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, Appendable paramAppendable) throws IOException {
    printer().printField(paramFieldDescriptor, paramObject, paramAppendable);
  }
  
  @Deprecated
  public static String printFieldToString(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject) {
    return printer().printFieldToString(paramFieldDescriptor, paramObject);
  }
  
  @Deprecated
  public static void printFieldValue(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, Appendable paramAppendable) throws IOException {
    printer().printFieldValue(paramFieldDescriptor, paramObject, paramAppendable);
  }
  
  @Deprecated
  public static String printToString(MessageOrBuilder paramMessageOrBuilder) {
    return printer().printToString(paramMessageOrBuilder);
  }
  
  @Deprecated
  public static String printToString(UnknownFieldSet paramUnknownFieldSet) {
    return printer().printToString(paramUnknownFieldSet);
  }
  
  @Deprecated
  public static String printToUnicodeString(MessageOrBuilder paramMessageOrBuilder) {
    return printer().escapingNonAscii(false).printToString(paramMessageOrBuilder);
  }
  
  @Deprecated
  public static String printToUnicodeString(UnknownFieldSet paramUnknownFieldSet) {
    return printer().escapingNonAscii(false).printToString(paramUnknownFieldSet);
  }
  
  @Deprecated
  public static void printUnicode(MessageOrBuilder paramMessageOrBuilder, Appendable paramAppendable) throws IOException {
    printer().escapingNonAscii(false).print(paramMessageOrBuilder, paramAppendable);
  }
  
  @Deprecated
  public static void printUnicode(UnknownFieldSet paramUnknownFieldSet, Appendable paramAppendable) throws IOException {
    printer().escapingNonAscii(false).print(paramUnknownFieldSet, paramAppendable);
  }
  
  @Deprecated
  public static void printUnicodeFieldValue(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, Appendable paramAppendable) throws IOException {
    printer().escapingNonAscii(false).printFieldValue(paramFieldDescriptor, paramObject, paramAppendable);
  }
  
  private static void printUnknownFieldValue(int paramInt, Object paramObject, TextGenerator paramTextGenerator) throws IOException {
    int i = WireFormat.getTagWireType(paramInt);
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i == 5) {
              paramTextGenerator.print(String.format((Locale)null, "0x%08x", new Object[] { paramObject }));
              return;
            } 
            paramObject = new StringBuilder();
            paramObject.append("Bad tag: ");
            paramObject.append(paramInt);
            throw new IllegalArgumentException(paramObject.toString());
          } 
          Printer.printUnknownFields((UnknownFieldSet)paramObject, paramTextGenerator);
          return;
        } 
        try {
          UnknownFieldSet unknownFieldSet = UnknownFieldSet.parseFrom((ByteString)paramObject);
          paramTextGenerator.print("{");
          paramTextGenerator.eol();
          paramTextGenerator.indent();
          Printer.printUnknownFields(unknownFieldSet, paramTextGenerator);
          paramTextGenerator.outdent();
          paramTextGenerator.print("}");
          return;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          paramTextGenerator.print("\"");
          paramTextGenerator.print(escapeBytes((ByteString)paramObject));
          paramTextGenerator.print("\"");
          return;
        } 
      } 
      paramTextGenerator.print(String.format((Locale)null, "0x%016x", new Object[] { paramObject }));
      return;
    } 
    paramTextGenerator.print(unsignedToString(((Long)paramObject).longValue()));
  }
  
  public static void printUnknownFieldValue(int paramInt, Object paramObject, Appendable paramAppendable) throws IOException {
    printUnknownFieldValue(paramInt, paramObject, multiLineOutput(paramAppendable));
  }
  
  public static Printer printer() {
    return Printer.DEFAULT;
  }
  
  @Deprecated
  public static String shortDebugString(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject) {
    return printer().shortDebugString(paramFieldDescriptor, paramObject);
  }
  
  public static String shortDebugString(MessageOrBuilder paramMessageOrBuilder) {
    return printer().shortDebugString(paramMessageOrBuilder);
  }
  
  @Deprecated
  public static String shortDebugString(UnknownFieldSet paramUnknownFieldSet) {
    return printer().shortDebugString(paramUnknownFieldSet);
  }
  
  private static TextGenerator singleLineOutput(Appendable paramAppendable) {
    return new TextGenerator(paramAppendable, true);
  }
  
  public static ByteString unescapeBytes(CharSequence paramCharSequence) throws InvalidEscapeSequenceException {
    ByteString byteString = ByteString.copyFromUtf8(paramCharSequence.toString());
    byte[] arrayOfByte = new byte[byteString.size()];
    int i = 0;
    int j = 0;
    while (true) {
      if (i < byteString.size()) {
        byte b = byteString.byteAt(i);
        if (b == 92) {
          int m = i + 1;
          if (m < byteString.size()) {
            b = byteString.byteAt(m);
            if (isOctal(b)) {
              int i2 = digitValue(b);
              int i1 = m + 1;
              int n = m;
              i = i2;
              if (i1 < byteString.size()) {
                n = m;
                i = i2;
                if (isOctal(byteString.byteAt(i1))) {
                  i = i2 * 8 + digitValue(byteString.byteAt(i1));
                  n = i1;
                } 
              } 
              i2 = n + 1;
              m = n;
              i1 = i;
              if (i2 < byteString.size()) {
                m = n;
                i1 = i;
                if (isOctal(byteString.byteAt(i2))) {
                  i1 = i * 8 + digitValue(byteString.byteAt(i2));
                  m = i2;
                } 
              } 
              n = j + 1;
              arrayOfByte[j] = (byte)i1;
              i = m;
            } else {
              if (b != 34) {
                if (b != 39) {
                  if (b != 92) {
                    if (b != 102) {
                      if (b != 110) {
                        if (b != 114) {
                          if (b != 116) {
                            if (b != 118) {
                              StringBuilder stringBuilder;
                              if (b != 120) {
                                if (b != 97) {
                                  if (b == 98) {
                                    i = j + 1;
                                    arrayOfByte[j] = 8;
                                  } else {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Invalid escape sequence: '\\");
                                    stringBuilder.append((char)b);
                                    stringBuilder.append('\'');
                                    throw new InvalidEscapeSequenceException(stringBuilder.toString());
                                  } 
                                } else {
                                  i = j + 1;
                                  arrayOfByte[j] = 7;
                                } 
                              } else {
                                int i1 = m + 1;
                                if (i1 < stringBuilder.size() && isHex(stringBuilder.byteAt(i1))) {
                                  int i3 = digitValue(stringBuilder.byteAt(i1));
                                  m = i1 + 1;
                                  i = i1;
                                  int i2 = i3;
                                  if (m < stringBuilder.size()) {
                                    i = i1;
                                    i2 = i3;
                                    if (isHex(stringBuilder.byteAt(m))) {
                                      i2 = i3 * 16 + digitValue(stringBuilder.byteAt(m));
                                      i = m;
                                    } 
                                  } 
                                  m = j + 1;
                                  arrayOfByte[j] = (byte)i2;
                                  i2 = m;
                                } else {
                                  throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                                } 
                                m = i;
                              } 
                            } else {
                              i = j + 1;
                              arrayOfByte[j] = 11;
                            } 
                          } else {
                            i = j + 1;
                            arrayOfByte[j] = 9;
                          } 
                        } else {
                          i = j + 1;
                          arrayOfByte[j] = 13;
                        } 
                      } else {
                        i = j + 1;
                        arrayOfByte[j] = 10;
                      } 
                    } else {
                      i = j + 1;
                      arrayOfByte[j] = 12;
                    } 
                  } else {
                    i = j + 1;
                    arrayOfByte[j] = 92;
                  } 
                } else {
                  i = j + 1;
                  arrayOfByte[j] = 39;
                } 
              } else {
                i = j + 1;
                arrayOfByte[j] = 34;
              } 
              int n = i;
              i = m + 1;
              j = n;
            } 
          } else {
            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
          } 
        } else {
          int m = j + 1;
          arrayOfByte[j] = b;
        } 
      } else {
        break;
      } 
      int k = i;
    } 
    return (arrayOfByte.length == j) ? ByteString.wrap(arrayOfByte) : ByteString.copyFrom(arrayOfByte, 0, j);
  }
  
  static String unescapeText(String paramString) throws InvalidEscapeSequenceException {
    return unescapeBytes(paramString).toStringUtf8();
  }
  
  public static String unsignedToString(int paramInt) {
    return (paramInt >= 0) ? Integer.toString(paramInt) : Long.toString(paramInt & 0xFFFFFFFFL);
  }
  
  public static String unsignedToString(long paramLong) {
    return (paramLong >= 0L) ? Long.toString(paramLong) : BigInteger.valueOf(paramLong & Long.MAX_VALUE).setBit(63).toString();
  }
  
  public static class InvalidEscapeSequenceException extends IOException {
    private static final long serialVersionUID = -8164033650142593304L;
    
    InvalidEscapeSequenceException(String param1String) {
      super(param1String);
    }
  }
  
  public static class ParseException extends IOException {
    private static final long serialVersionUID = 3196188060225107702L;
    
    private final int column;
    
    private final int line;
    
    public ParseException(int param1Int1, int param1Int2, String param1String) {
      super(stringBuilder.toString());
      this.line = param1Int1;
      this.column = param1Int2;
    }
    
    public ParseException(String param1String) {
      this(-1, -1, param1String);
    }
    
    public int getColumn() {
      return this.column;
    }
    
    public int getLine() {
      return this.line;
    }
  }
  
  public static class Parser {
    private static final int BUFFER_SIZE = 4096;
    
    private final boolean allowUnknownEnumValues;
    
    private final boolean allowUnknownExtensions;
    
    private final boolean allowUnknownFields;
    
    private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
    
    private final SingularOverwritePolicy singularOverwritePolicy;
    
    private final TypeRegistry typeRegistry;
    
    private Parser(TypeRegistry param1TypeRegistry, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, SingularOverwritePolicy param1SingularOverwritePolicy, TextFormatParseInfoTree.Builder param1Builder) {
      this.typeRegistry = param1TypeRegistry;
      this.allowUnknownFields = param1Boolean1;
      this.allowUnknownEnumValues = param1Boolean2;
      this.allowUnknownExtensions = param1Boolean3;
      this.singularOverwritePolicy = param1SingularOverwritePolicy;
      this.parseInfoTreeBuilder = param1Builder;
    }
    
    private void checkUnknownFields(List<UnknownField> param1List) throws TextFormat.ParseException {
      boolean bool;
      if (param1List.isEmpty())
        return; 
      StringBuilder stringBuilder = new StringBuilder("Input contains unknown fields and/or extensions:");
      for (UnknownField unknownField : param1List) {
        stringBuilder.append('\n');
        stringBuilder.append(unknownField.message);
      } 
      if (this.allowUnknownFields) {
        TextFormat.logger.warning(stringBuilder.toString());
        return;
      } 
      if (this.allowUnknownExtensions) {
        boolean bool1;
        Iterator<UnknownField> iterator = param1List.iterator();
        bool = false;
        while (true) {
          if (iterator.hasNext()) {
            if (((UnknownField)iterator.next()).type == UnknownField.Type.FIELD) {
              boolean bool2 = false;
              break;
            } 
            bool++;
            continue;
          } 
          bool1 = true;
          break;
        } 
        if (bool1) {
          TextFormat.logger.warning(stringBuilder.toString());
          return;
        } 
      } else {
        bool = false;
      } 
      String[] arrayOfString = ((UnknownField)param1List.get(bool)).message.split(":");
      throw new TextFormat.ParseException(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), stringBuilder.toString());
    }
    
    private void consumeFieldValue(TextFormat.Tokenizer param1Tokenizer, ExtensionRegistry param1ExtensionRegistry, MessageReflection.MergeTarget param1MergeTarget, Descriptors.FieldDescriptor param1FieldDescriptor, ExtensionRegistry.ExtensionInfo param1ExtensionInfo, TextFormatParseInfoTree.Builder param1Builder, List<UnknownField> param1List) throws TextFormat.ParseException {
      Object object1;
      StringBuilder stringBuilder;
      Object object2;
      if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !param1FieldDescriptor.isRepeated())
        if (!param1MergeTarget.hasField(param1FieldDescriptor)) {
          if (param1FieldDescriptor.getContainingOneof() != null && param1MergeTarget.hasOneof(param1FieldDescriptor.getContainingOneof())) {
            Descriptors.OneofDescriptor oneofDescriptor = param1FieldDescriptor.getContainingOneof();
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Field \"");
            stringBuilder1.append(param1FieldDescriptor.getFullName());
            stringBuilder1.append("\" is specified along with field \"");
            stringBuilder1.append(param1MergeTarget.getOneofFieldDescriptor(oneofDescriptor).getFullName());
            stringBuilder1.append("\", another member of oneof \"");
            stringBuilder1.append(oneofDescriptor.getName());
            stringBuilder1.append("\".");
            throw param1Tokenizer.parseExceptionPreviousToken(stringBuilder1.toString());
          } 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Non-repeated field \"");
          stringBuilder.append(param1FieldDescriptor.getFullName());
          stringBuilder.append("\" cannot be overwritten.");
          throw param1Tokenizer.parseExceptionPreviousToken(stringBuilder.toString());
        }  
      Descriptors.FieldDescriptor.JavaType javaType1 = param1FieldDescriptor.getJavaType();
      Descriptors.FieldDescriptor.JavaType javaType2 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
      String str = null;
      MessageReflection.MergeTarget mergeTarget = null;
      if (javaType1 == javaType2) {
        MessageReflection.MergeTarget mergeTarget1;
        if (param1Tokenizer.tryConsume("<")) {
          str = ">";
        } else {
          param1Tokenizer.consume("{");
          str = "}";
        } 
        if (param1FieldDescriptor.getMessageType().getFullName().equals("google.protobuf.Any") && param1Tokenizer.tryConsume("[")) {
          mergeTarget1 = param1MergeTarget.newMergeTargetForField(param1FieldDescriptor, DynamicMessage.getDefaultInstance(param1FieldDescriptor.getMessageType()));
          mergeAnyFieldValue(param1Tokenizer, (ExtensionRegistry)stringBuilder, mergeTarget1, param1Builder, param1List, param1FieldDescriptor.getMessageType());
          object2 = mergeTarget1.finish();
          param1Tokenizer.consume(str);
          object1 = object2;
        } else {
          Message message;
          if (mergeTarget1 == null) {
            mergeTarget1 = mergeTarget;
          } else {
            message = ((ExtensionRegistry.ExtensionInfo)mergeTarget1).defaultInstance;
          } 
          MessageReflection.MergeTarget mergeTarget2 = param1MergeTarget.newMergeTargetForField(param1FieldDescriptor, message);
          while (!object1.tryConsume(str)) {
            if (!object1.atEnd()) {
              mergeField((TextFormat.Tokenizer)object1, (ExtensionRegistry)object2, mergeTarget2, param1Builder, param1List);
              continue;
            } 
            object2 = new StringBuilder();
            object2.append("Expected \"");
            object2.append(str);
            object2.append("\".");
            throw object1.parseException(object2.toString());
          } 
          object1 = mergeTarget2.finish();
        } 
        object2 = object1;
      } else {
        String str2;
        Descriptors.EnumValueDescriptor enumValueDescriptor1;
        ByteString byteString;
        String str1;
        Long long_2;
        Integer integer;
        Double double_;
        Float float_;
        Boolean bool;
        Long long_1;
        Descriptors.EnumValueDescriptor enumValueDescriptor2;
        Descriptors.EnumDescriptor enumDescriptor;
        String str3;
        switch (param1FieldDescriptor.getType()) {
          default:
            str2 = str;
            break;
          case MESSAGE:
          case GROUP:
            throw new RuntimeException("Can't get here.");
          case ENUM:
            enumDescriptor = param1FieldDescriptor.getEnumType();
            if (object1.lookingAtInteger()) {
              int i = object1.consumeInt32();
              Descriptors.EnumValueDescriptor enumValueDescriptor4 = enumDescriptor.findValueByNumber(i);
              Descriptors.EnumValueDescriptor enumValueDescriptor3 = enumValueDescriptor4;
              if (enumValueDescriptor4 == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Enum type \"");
                stringBuilder2.append(enumDescriptor.getFullName());
                stringBuilder2.append("\" has no value with number ");
                stringBuilder2.append(i);
                stringBuilder2.append('.');
                String str4 = stringBuilder2.toString();
                if (this.allowUnknownEnumValues) {
                  TextFormat.logger.warning(str4);
                  return;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Enum type \"");
                stringBuilder1.append(enumDescriptor.getFullName());
                stringBuilder1.append("\" has no value with number ");
                stringBuilder1.append(i);
                stringBuilder1.append('.');
                throw object1.parseExceptionPreviousToken(stringBuilder1.toString());
              } 
              break;
            } 
            str3 = object1.consumeIdentifier();
            enumValueDescriptor2 = enumDescriptor.findValueByName(str3);
            enumValueDescriptor1 = enumValueDescriptor2;
            if (enumValueDescriptor2 == null) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Enum type \"");
              stringBuilder1.append(enumDescriptor.getFullName());
              stringBuilder1.append("\" has no value named \"");
              stringBuilder1.append(str3);
              stringBuilder1.append("\".");
              String str4 = stringBuilder1.toString();
              if (this.allowUnknownEnumValues) {
                TextFormat.logger.warning(str4);
                return;
              } 
              throw object1.parseExceptionPreviousToken(str4);
            } 
            break;
          case BYTES:
            byteString = object1.consumeByteString();
            break;
          case STRING:
            str1 = object1.consumeString();
            break;
          case UINT64:
          case FIXED64:
            long_2 = Long.valueOf(object1.consumeUInt64());
            break;
          case UINT32:
          case FIXED32:
            integer = Integer.valueOf(object1.consumeUInt32());
            break;
          case DOUBLE:
            double_ = Double.valueOf(object1.consumeDouble());
            break;
          case FLOAT:
            float_ = Float.valueOf(object1.consumeFloat());
            break;
          case BOOL:
            bool = Boolean.valueOf(object1.consumeBoolean());
            break;
          case INT64:
          case SINT64:
          case SFIXED64:
            long_1 = Long.valueOf(object1.consumeInt64());
            break;
          case INT32:
          case SINT32:
          case SFIXED32:
            object2 = Integer.valueOf(object1.consumeInt32());
            break;
        } 
      } 
      if (param1FieldDescriptor.isRepeated()) {
        param1MergeTarget.addRepeatedField(param1FieldDescriptor, object2);
        return;
      } 
      param1MergeTarget.setField(param1FieldDescriptor, object2);
    }
    
    private void consumeFieldValues(TextFormat.Tokenizer param1Tokenizer, ExtensionRegistry param1ExtensionRegistry, MessageReflection.MergeTarget param1MergeTarget, Descriptors.FieldDescriptor param1FieldDescriptor, ExtensionRegistry.ExtensionInfo param1ExtensionInfo, TextFormatParseInfoTree.Builder param1Builder, List<UnknownField> param1List) throws TextFormat.ParseException {
      if (param1FieldDescriptor.isRepeated() && param1Tokenizer.tryConsume("[")) {
        if (!param1Tokenizer.tryConsume("]"))
          while (true) {
            consumeFieldValue(param1Tokenizer, param1ExtensionRegistry, param1MergeTarget, param1FieldDescriptor, param1ExtensionInfo, param1Builder, param1List);
            if (param1Tokenizer.tryConsume("]"))
              return; 
            param1Tokenizer.consume(",");
          }  
      } else {
        consumeFieldValue(param1Tokenizer, param1ExtensionRegistry, param1MergeTarget, param1FieldDescriptor, param1ExtensionInfo, param1Builder, param1List);
      } 
    }
    
    private void mergeAnyFieldValue(TextFormat.Tokenizer param1Tokenizer, ExtensionRegistry param1ExtensionRegistry, MessageReflection.MergeTarget param1MergeTarget, TextFormatParseInfoTree.Builder param1Builder, List<UnknownField> param1List, Descriptors.Descriptor param1Descriptor) throws TextFormat.ParseException {
      StringBuilder stringBuilder = new StringBuilder();
      while (true) {
        stringBuilder.append(param1Tokenizer.consumeIdentifier());
        if (param1Tokenizer.tryConsume("]")) {
          String str1;
          DynamicMessage.Builder builder;
          param1Tokenizer.tryConsume(":");
          if (param1Tokenizer.tryConsume("<")) {
            str1 = ">";
          } else {
            param1Tokenizer.consume("{");
            str1 = "}";
          } 
          String str2 = stringBuilder.toString();
          try {
            Descriptors.Descriptor descriptor = this.typeRegistry.getDescriptorForTypeUrl(str2);
            if (descriptor != null) {
              builder = DynamicMessage.getDefaultInstance(descriptor).newBuilderForType();
              MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(builder);
              while (!param1Tokenizer.tryConsume(str1))
                mergeField(param1Tokenizer, param1ExtensionRegistry, builderAdapter, param1Builder, param1List); 
              param1MergeTarget.setField(param1Descriptor.findFieldByName("type_url"), stringBuilder.toString());
              param1MergeTarget.setField(param1Descriptor.findFieldByName("value"), builder.build().toByteString());
              return;
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Unable to parse Any of type: ");
            stringBuilder1.append((String)builder);
            stringBuilder1.append(". Please make sure that the TypeRegistry contains the descriptors for the given types.");
            throw param1Tokenizer.parseException(stringBuilder1.toString());
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Invalid valid type URL. Found: ");
            stringBuilder1.append((String)builder);
            throw param1Tokenizer.parseException(stringBuilder1.toString());
          } 
        } 
        if (param1Tokenizer.tryConsume("/")) {
          stringBuilder.append("/");
          continue;
        } 
        if (param1Tokenizer.tryConsume(".")) {
          stringBuilder.append(".");
          continue;
        } 
        throw param1Tokenizer.parseExceptionPreviousToken("Expected a valid type URL.");
      } 
    }
    
    private void mergeField(TextFormat.Tokenizer param1Tokenizer, ExtensionRegistry param1ExtensionRegistry, MessageReflection.MergeTarget param1MergeTarget, TextFormatParseInfoTree.Builder param1Builder, List<UnknownField> param1List) throws TextFormat.ParseException {
      StringBuilder stringBuilder;
      Descriptors.Descriptor descriptor1;
      int i = param1Tokenizer.getLine();
      int j = param1Tokenizer.getColumn();
      Descriptors.Descriptor descriptor2 = param1MergeTarget.getDescriptorForType();
      if ("google.protobuf.Any".equals(descriptor2.getFullName()) && param1Tokenizer.tryConsume("[")) {
        mergeAnyFieldValue(param1Tokenizer, param1ExtensionRegistry, param1MergeTarget, param1Builder, param1List, descriptor2);
        return;
      } 
      boolean bool = param1Tokenizer.tryConsume("[");
      Descriptors.FieldDescriptor fieldDescriptor = null;
      if (bool) {
        StringBuilder stringBuilder1 = new StringBuilder(param1Tokenizer.consumeIdentifier());
        while (param1Tokenizer.tryConsume(".")) {
          stringBuilder1.append('.');
          stringBuilder1.append(param1Tokenizer.consumeIdentifier());
        } 
        ExtensionRegistry.ExtensionInfo extensionInfo = param1MergeTarget.findExtensionByName(param1ExtensionRegistry, stringBuilder1.toString());
        if (extensionInfo == null) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(param1Tokenizer.getPreviousLine() + 1);
          stringBuilder2.append(":");
          stringBuilder2.append(param1Tokenizer.getPreviousColumn() + 1);
          stringBuilder2.append(":\t");
          stringBuilder2.append(descriptor2.getFullName());
          stringBuilder2.append(".[");
          stringBuilder2.append(stringBuilder1);
          stringBuilder2.append("]");
          param1List.add(new UnknownField(stringBuilder2.toString(), UnknownField.Type.EXTENSION));
        } else if (extensionInfo.descriptor.getContainingType() == descriptor2) {
          fieldDescriptor = extensionInfo.descriptor;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Extension \"");
          stringBuilder.append(stringBuilder1);
          stringBuilder.append("\" does not extend message type \"");
          stringBuilder.append(descriptor2.getFullName());
          stringBuilder.append("\".");
          throw param1Tokenizer.parseExceptionPreviousToken(stringBuilder.toString());
        } 
        param1Tokenizer.consume("]");
      } else {
        String str = param1Tokenizer.consumeIdentifier();
        Descriptors.FieldDescriptor fieldDescriptor1 = descriptor2.findFieldByName(str);
        fieldDescriptor = fieldDescriptor1;
        if (fieldDescriptor1 == null) {
          fieldDescriptor1 = descriptor2.findFieldByName(str.toLowerCase(Locale.US));
          fieldDescriptor = fieldDescriptor1;
          if (fieldDescriptor1 != null) {
            fieldDescriptor = fieldDescriptor1;
            if (fieldDescriptor1.getType() != Descriptors.FieldDescriptor.Type.GROUP)
              fieldDescriptor = null; 
          } 
        } 
        fieldDescriptor1 = fieldDescriptor;
        if (fieldDescriptor != null) {
          fieldDescriptor1 = fieldDescriptor;
          if (fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
            fieldDescriptor1 = fieldDescriptor;
            if (!fieldDescriptor.getMessageType().getName().equals(str))
              fieldDescriptor1 = null; 
          } 
        } 
        if (fieldDescriptor1 == null) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(param1Tokenizer.getPreviousLine() + 1);
          stringBuilder1.append(":");
          stringBuilder1.append(param1Tokenizer.getPreviousColumn() + 1);
          stringBuilder1.append(":\t");
          stringBuilder1.append(descriptor2.getFullName());
          stringBuilder1.append(".");
          stringBuilder1.append(str);
          param1List.add(new UnknownField(stringBuilder1.toString(), UnknownField.Type.FIELD));
        } 
        descriptor2 = null;
        fieldDescriptor = fieldDescriptor1;
        descriptor1 = descriptor2;
      } 
      if (fieldDescriptor == null) {
        if (param1Tokenizer.tryConsume(":") && !param1Tokenizer.lookingAt("{") && !param1Tokenizer.lookingAt("<")) {
          skipFieldValue(param1Tokenizer);
          return;
        } 
        skipFieldMessage(param1Tokenizer);
        return;
      } 
      if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        param1Tokenizer.tryConsume(":");
        if (param1Builder != null) {
          consumeFieldValues(param1Tokenizer, (ExtensionRegistry)stringBuilder, param1MergeTarget, fieldDescriptor, (ExtensionRegistry.ExtensionInfo)descriptor1, param1Builder.getBuilderForSubMessageField(fieldDescriptor), param1List);
        } else {
          consumeFieldValues(param1Tokenizer, (ExtensionRegistry)stringBuilder, param1MergeTarget, fieldDescriptor, (ExtensionRegistry.ExtensionInfo)descriptor1, param1Builder, param1List);
        } 
      } else {
        param1Tokenizer.consume(":");
        consumeFieldValues(param1Tokenizer, (ExtensionRegistry)stringBuilder, param1MergeTarget, fieldDescriptor, (ExtensionRegistry.ExtensionInfo)descriptor1, param1Builder, param1List);
      } 
      if (param1Builder != null)
        param1Builder.setLocation(fieldDescriptor, TextFormatParseLocation.create(i, j)); 
      if (!param1Tokenizer.tryConsume(";"))
        param1Tokenizer.tryConsume(","); 
    }
    
    private void mergeField(TextFormat.Tokenizer param1Tokenizer, ExtensionRegistry param1ExtensionRegistry, MessageReflection.MergeTarget param1MergeTarget, List<UnknownField> param1List) throws TextFormat.ParseException {
      mergeField(param1Tokenizer, param1ExtensionRegistry, param1MergeTarget, this.parseInfoTreeBuilder, param1List);
    }
    
    public static Builder newBuilder() {
      return new Builder();
    }
    
    private static void skipField(TextFormat.Tokenizer param1Tokenizer) throws TextFormat.ParseException {
      // Byte code:
      //   0: aload_0
      //   1: ldc '['
      //   3: invokevirtual tryConsume : (Ljava/lang/String;)Z
      //   6: ifeq -> 34
      //   9: aload_0
      //   10: invokevirtual consumeIdentifier : ()Ljava/lang/String;
      //   13: pop
      //   14: aload_0
      //   15: ldc_w '.'
      //   18: invokevirtual tryConsume : (Ljava/lang/String;)Z
      //   21: ifne -> 9
      //   24: aload_0
      //   25: ldc_w ']'
      //   28: invokevirtual consume : (Ljava/lang/String;)V
      //   31: goto -> 39
      //   34: aload_0
      //   35: invokevirtual consumeIdentifier : ()Ljava/lang/String;
      //   38: pop
      //   39: aload_0
      //   40: ldc ':'
      //   42: invokevirtual tryConsume : (Ljava/lang/String;)Z
      //   45: ifeq -> 73
      //   48: aload_0
      //   49: ldc '<'
      //   51: invokevirtual lookingAt : (Ljava/lang/String;)Z
      //   54: ifne -> 73
      //   57: aload_0
      //   58: ldc '{'
      //   60: invokevirtual lookingAt : (Ljava/lang/String;)Z
      //   63: ifne -> 73
      //   66: aload_0
      //   67: invokestatic skipFieldValue : (Lcom/google/protobuf/TextFormat$Tokenizer;)V
      //   70: goto -> 77
      //   73: aload_0
      //   74: invokestatic skipFieldMessage : (Lcom/google/protobuf/TextFormat$Tokenizer;)V
      //   77: aload_0
      //   78: ldc_w ';'
      //   81: invokevirtual tryConsume : (Ljava/lang/String;)Z
      //   84: ifne -> 95
      //   87: aload_0
      //   88: ldc_w ','
      //   91: invokevirtual tryConsume : (Ljava/lang/String;)Z
      //   94: pop
      //   95: return
    }
    
    private static void skipFieldMessage(TextFormat.Tokenizer param1Tokenizer) throws TextFormat.ParseException {
      String str;
      if (param1Tokenizer.tryConsume("<")) {
        str = ">";
      } else {
        param1Tokenizer.consume("{");
        str = "}";
      } 
      while (!param1Tokenizer.lookingAt(">") && !param1Tokenizer.lookingAt("}"))
        skipField(param1Tokenizer); 
      param1Tokenizer.consume(str);
    }
    
    private static void skipFieldValue(TextFormat.Tokenizer param1Tokenizer) throws TextFormat.ParseException {
      if (param1Tokenizer.tryConsumeString()) {
        while (param1Tokenizer.tryConsumeString());
        return;
      } 
      if (!param1Tokenizer.tryConsumeIdentifier() && !param1Tokenizer.tryConsumeInt64() && !param1Tokenizer.tryConsumeUInt64() && !param1Tokenizer.tryConsumeDouble()) {
        if (param1Tokenizer.tryConsumeFloat())
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid field value: ");
        stringBuilder.append(param1Tokenizer.currentToken);
        throw param1Tokenizer.parseException(stringBuilder.toString());
      } 
    }
    
    private static StringBuilder toStringBuilder(Readable param1Readable) throws IOException {
      StringBuilder stringBuilder = new StringBuilder();
      CharBuffer charBuffer = CharBuffer.allocate(4096);
      while (true) {
        int i = param1Readable.read(charBuffer);
        if (i == -1)
          return stringBuilder; 
        charBuffer.flip();
        stringBuilder.append(charBuffer, 0, i);
      } 
    }
    
    public void merge(CharSequence param1CharSequence, ExtensionRegistry param1ExtensionRegistry, Message.Builder param1Builder) throws TextFormat.ParseException {
      TextFormat.Tokenizer tokenizer = new TextFormat.Tokenizer(param1CharSequence);
      MessageReflection.BuilderAdapter builderAdapter = new MessageReflection.BuilderAdapter(param1Builder);
      ArrayList<UnknownField> arrayList = new ArrayList();
      while (!tokenizer.atEnd())
        mergeField(tokenizer, param1ExtensionRegistry, builderAdapter, arrayList); 
      checkUnknownFields(arrayList);
    }
    
    public void merge(CharSequence param1CharSequence, Message.Builder param1Builder) throws TextFormat.ParseException {
      merge(param1CharSequence, ExtensionRegistry.getEmptyRegistry(), param1Builder);
    }
    
    public void merge(Readable param1Readable, ExtensionRegistry param1ExtensionRegistry, Message.Builder param1Builder) throws IOException {
      merge(toStringBuilder(param1Readable), param1ExtensionRegistry, param1Builder);
    }
    
    public void merge(Readable param1Readable, Message.Builder param1Builder) throws IOException {
      merge(param1Readable, ExtensionRegistry.getEmptyRegistry(), param1Builder);
    }
    
    public static class Builder {
      private boolean allowUnknownEnumValues = false;
      
      private boolean allowUnknownExtensions = false;
      
      private boolean allowUnknownFields = false;
      
      private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
      
      private TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy = TextFormat.Parser.SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
      
      private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();
      
      public TextFormat.Parser build() {
        return new TextFormat.Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder);
      }
      
      public Builder setAllowUnknownExtensions(boolean param2Boolean) {
        this.allowUnknownExtensions = param2Boolean;
        return this;
      }
      
      public Builder setAllowUnknownFields(boolean param2Boolean) {
        this.allowUnknownFields = param2Boolean;
        return this;
      }
      
      public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder param2Builder) {
        this.parseInfoTreeBuilder = param2Builder;
        return this;
      }
      
      public Builder setSingularOverwritePolicy(TextFormat.Parser.SingularOverwritePolicy param2SingularOverwritePolicy) {
        this.singularOverwritePolicy = param2SingularOverwritePolicy;
        return this;
      }
      
      public Builder setTypeRegistry(TypeRegistry param2TypeRegistry) {
        this.typeRegistry = param2TypeRegistry;
        return this;
      }
    }
    
    public enum SingularOverwritePolicy {
      ALLOW_SINGULAR_OVERWRITES, FORBID_SINGULAR_OVERWRITES;
      
      static {
      
      }
    }
    
    static final class UnknownField {
      final String message;
      
      final Type type;
      
      UnknownField(String param2String, Type param2Type) {
        this.message = param2String;
        this.type = param2Type;
      }
      
      enum Type {
        FIELD, EXTENSION;
        
        static {
        
        }
      }
    }
    
    enum Type {
      EXTENSION, FIELD;
      
      static {
      
      }
    }
  }
  
  public static class Builder {
    private boolean allowUnknownEnumValues = false;
    
    private boolean allowUnknownExtensions = false;
    
    private boolean allowUnknownFields = false;
    
    private TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
    
    private TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy = TextFormat.Parser.SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
    
    private TypeRegistry typeRegistry = TypeRegistry.getEmptyTypeRegistry();
    
    public TextFormat.Parser build() {
      return new TextFormat.Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder);
    }
    
    public Builder setAllowUnknownExtensions(boolean param1Boolean) {
      this.allowUnknownExtensions = param1Boolean;
      return this;
    }
    
    public Builder setAllowUnknownFields(boolean param1Boolean) {
      this.allowUnknownFields = param1Boolean;
      return this;
    }
    
    public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder param1Builder) {
      this.parseInfoTreeBuilder = param1Builder;
      return this;
    }
    
    public Builder setSingularOverwritePolicy(TextFormat.Parser.SingularOverwritePolicy param1SingularOverwritePolicy) {
      this.singularOverwritePolicy = param1SingularOverwritePolicy;
      return this;
    }
    
    public Builder setTypeRegistry(TypeRegistry param1TypeRegistry) {
      this.typeRegistry = param1TypeRegistry;
      return this;
    }
  }
  
  public enum SingularOverwritePolicy {
    ALLOW_SINGULAR_OVERWRITES, FORBID_SINGULAR_OVERWRITES;
    
    static {
    
    }
  }
  
  static final class UnknownField {
    final String message;
    
    final Type type;
    
    UnknownField(String param1String, Type param1Type) {
      this.message = param1String;
      this.type = param1Type;
    }
    
    enum Type {
      FIELD, EXTENSION;
      
      static {
      
      }
    }
  }
  
  enum Type {
    EXTENSION, FIELD;
    
    static {
      $VALUES = new Type[] { FIELD, EXTENSION };
    }
  }
  
  public static final class Printer {
    private static final Printer DEFAULT = new Printer(true, TypeRegistry.getEmptyTypeRegistry());
    
    private final boolean escapeNonAscii;
    
    private final TypeRegistry typeRegistry;
    
    private Printer(boolean param1Boolean, TypeRegistry param1TypeRegistry) {
      this.escapeNonAscii = param1Boolean;
      this.typeRegistry = param1TypeRegistry;
    }
    
    private void print(MessageOrBuilder param1MessageOrBuilder, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      if (param1MessageOrBuilder.getDescriptorForType().getFullName().equals("google.protobuf.Any") && printAny(param1MessageOrBuilder, param1TextGenerator))
        return; 
      printMessage(param1MessageOrBuilder, param1TextGenerator);
    }
    
    private boolean printAny(MessageOrBuilder param1MessageOrBuilder, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      Descriptors.Descriptor descriptor = param1MessageOrBuilder.getDescriptorForType();
      Descriptors.FieldDescriptor fieldDescriptor1 = descriptor.findFieldByNumber(1);
      Descriptors.FieldDescriptor fieldDescriptor2 = descriptor.findFieldByNumber(2);
      if (fieldDescriptor1 != null && fieldDescriptor1.getType() == Descriptors.FieldDescriptor.Type.STRING && fieldDescriptor2 != null) {
        if (fieldDescriptor2.getType() != Descriptors.FieldDescriptor.Type.BYTES)
          return false; 
        String str = (String)param1MessageOrBuilder.getField(fieldDescriptor1);
        if (str.isEmpty())
          return false; 
        Object object = param1MessageOrBuilder.getField(fieldDescriptor2);
        try {
          Descriptors.Descriptor descriptor1 = this.typeRegistry.getDescriptorForTypeUrl(str);
          if (descriptor1 == null)
            return false; 
          DynamicMessage.Builder builder = DynamicMessage.getDefaultInstance(descriptor1).newBuilderForType();
          builder.mergeFrom((ByteString)object);
          param1TextGenerator.print("[");
          param1TextGenerator.print(str);
          param1TextGenerator.print("] {");
          param1TextGenerator.eol();
          param1TextGenerator.indent();
          print(builder, param1TextGenerator);
          param1TextGenerator.outdent();
          param1TextGenerator.print("}");
          param1TextGenerator.eol();
          return true;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          return false;
        } 
      } 
      return false;
    }
    
    private void printField(Descriptors.FieldDescriptor param1FieldDescriptor, Object<MapEntryAdapter> param1Object, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      if (param1FieldDescriptor.isMapField()) {
        ArrayList<MapEntryAdapter> arrayList = new ArrayList();
        param1Object = (Object<MapEntryAdapter>)((List)param1Object).iterator();
        while (param1Object.hasNext())
          arrayList.add(new MapEntryAdapter(param1Object.next(), param1FieldDescriptor)); 
        Collections.sort(arrayList);
        param1Object = (Object<MapEntryAdapter>)arrayList.iterator();
        while (param1Object.hasNext())
          printSingleField(param1FieldDescriptor, ((MapEntryAdapter)param1Object.next()).getEntry(), param1TextGenerator); 
      } else if (param1FieldDescriptor.isRepeated()) {
        param1Object = (Object<MapEntryAdapter>)((List)param1Object).iterator();
        while (param1Object.hasNext())
          printSingleField(param1FieldDescriptor, param1Object.next(), param1TextGenerator); 
      } else {
        printSingleField(param1FieldDescriptor, param1Object, param1TextGenerator);
      } 
    }
    
    private void printFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      String str;
      switch (param1FieldDescriptor.getType()) {
        default:
          return;
        case MESSAGE:
        case GROUP:
          print((Message)param1Object, param1TextGenerator);
          return;
        case ENUM:
          param1TextGenerator.print(((Descriptors.EnumValueDescriptor)param1Object).getName());
          return;
        case BYTES:
          param1TextGenerator.print("\"");
          if (param1Object instanceof ByteString) {
            param1TextGenerator.print(TextFormat.escapeBytes((ByteString)param1Object));
          } else {
            param1TextGenerator.print(TextFormat.escapeBytes((byte[])param1Object));
          } 
          param1TextGenerator.print("\"");
          return;
        case STRING:
          param1TextGenerator.print("\"");
          if (this.escapeNonAscii) {
            str = TextFormatEscaper.escapeText((String)param1Object);
          } else {
            str = TextFormat.escapeDoubleQuotesAndBackslashes((String)param1Object).replace("\n", "\\n");
          } 
          param1TextGenerator.print(str);
          param1TextGenerator.print("\"");
          return;
        case UINT64:
        case FIXED64:
          param1TextGenerator.print(TextFormat.unsignedToString(((Long)param1Object).longValue()));
          return;
        case UINT32:
        case FIXED32:
          param1TextGenerator.print(TextFormat.unsignedToString(((Integer)param1Object).intValue()));
          return;
        case DOUBLE:
          param1TextGenerator.print(((Double)param1Object).toString());
          return;
        case FLOAT:
          param1TextGenerator.print(((Float)param1Object).toString());
          return;
        case BOOL:
          param1TextGenerator.print(((Boolean)param1Object).toString());
          return;
        case INT64:
        case SINT64:
        case SFIXED64:
          param1TextGenerator.print(((Long)param1Object).toString());
          return;
        case INT32:
        case SINT32:
        case SFIXED32:
          break;
      } 
      param1TextGenerator.print(((Integer)param1Object).toString());
    }
    
    private void printMessage(MessageOrBuilder param1MessageOrBuilder, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : param1MessageOrBuilder.getAllFields().entrySet())
        printField((Descriptors.FieldDescriptor)entry.getKey(), entry.getValue(), param1TextGenerator); 
      printUnknownFields(param1MessageOrBuilder.getUnknownFields(), param1TextGenerator);
    }
    
    private void printSingleField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      if (param1FieldDescriptor.isExtension()) {
        param1TextGenerator.print("[");
        if (param1FieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && param1FieldDescriptor.isOptional() && param1FieldDescriptor.getExtensionScope() == param1FieldDescriptor.getMessageType()) {
          param1TextGenerator.print(param1FieldDescriptor.getMessageType().getFullName());
        } else {
          param1TextGenerator.print(param1FieldDescriptor.getFullName());
        } 
        param1TextGenerator.print("]");
      } else if (param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
        param1TextGenerator.print(param1FieldDescriptor.getMessageType().getName());
      } else {
        param1TextGenerator.print(param1FieldDescriptor.getName());
      } 
      if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        param1TextGenerator.print(" {");
        param1TextGenerator.eol();
        param1TextGenerator.indent();
      } else {
        param1TextGenerator.print(": ");
      } 
      printFieldValue(param1FieldDescriptor, param1Object, param1TextGenerator);
      if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        param1TextGenerator.outdent();
        param1TextGenerator.print("}");
      } 
      param1TextGenerator.eol();
    }
    
    private static void printUnknownField(int param1Int1, int param1Int2, List<?> param1List, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      for (Object object : param1List) {
        param1TextGenerator.print(String.valueOf(param1Int1));
        param1TextGenerator.print(": ");
        printUnknownFieldValue(param1Int2, object, param1TextGenerator);
        param1TextGenerator.eol();
      } 
    }
    
    private static void printUnknownFieldValue(int param1Int, Object param1Object, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      int i = WireFormat.getTagWireType(param1Int);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i == 5) {
                param1TextGenerator.print(String.format((Locale)null, "0x%08x", new Object[] { param1Object }));
                return;
              } 
              param1Object = new StringBuilder();
              param1Object.append("Bad tag: ");
              param1Object.append(param1Int);
              throw new IllegalArgumentException(param1Object.toString());
            } 
            printUnknownFields((UnknownFieldSet)param1Object, param1TextGenerator);
            return;
          } 
          try {
            UnknownFieldSet unknownFieldSet = UnknownFieldSet.parseFrom((ByteString)param1Object);
            param1TextGenerator.print("{");
            param1TextGenerator.eol();
            param1TextGenerator.indent();
            printUnknownFields(unknownFieldSet, param1TextGenerator);
            param1TextGenerator.outdent();
            param1TextGenerator.print("}");
            return;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            param1TextGenerator.print("\"");
            param1TextGenerator.print(TextFormat.escapeBytes((ByteString)param1Object));
            param1TextGenerator.print("\"");
            return;
          } 
        } 
        param1TextGenerator.print(String.format((Locale)null, "0x%016x", new Object[] { param1Object }));
        return;
      } 
      param1TextGenerator.print(TextFormat.unsignedToString(((Long)param1Object).longValue()));
    }
    
    private static void printUnknownFields(UnknownFieldSet param1UnknownFieldSet, TextFormat.TextGenerator param1TextGenerator) throws IOException {
      for (Map.Entry<Integer, UnknownFieldSet.Field> entry : param1UnknownFieldSet.asMap().entrySet()) {
        int i = ((Integer)entry.getKey()).intValue();
        UnknownFieldSet.Field field = (UnknownFieldSet.Field)entry.getValue();
        printUnknownField(i, 0, field.getVarintList(), param1TextGenerator);
        printUnknownField(i, 5, field.getFixed32List(), param1TextGenerator);
        printUnknownField(i, 1, field.getFixed64List(), param1TextGenerator);
        printUnknownField(i, 2, field.getLengthDelimitedList(), param1TextGenerator);
        for (UnknownFieldSet unknownFieldSet : field.getGroupList()) {
          param1TextGenerator.print(((Integer)entry.getKey()).toString());
          param1TextGenerator.print(" {");
          param1TextGenerator.eol();
          param1TextGenerator.indent();
          printUnknownFields(unknownFieldSet, param1TextGenerator);
          param1TextGenerator.outdent();
          param1TextGenerator.print("}");
          param1TextGenerator.eol();
        } 
      } 
    }
    
    public Printer escapingNonAscii(boolean param1Boolean) {
      return new Printer(param1Boolean, this.typeRegistry);
    }
    
    public void print(MessageOrBuilder param1MessageOrBuilder, Appendable param1Appendable) throws IOException {
      print(param1MessageOrBuilder, TextFormat.multiLineOutput(param1Appendable));
    }
    
    public void print(UnknownFieldSet param1UnknownFieldSet, Appendable param1Appendable) throws IOException {
      printUnknownFields(param1UnknownFieldSet, TextFormat.multiLineOutput(param1Appendable));
    }
    
    public void printField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object, Appendable param1Appendable) throws IOException {
      printField(param1FieldDescriptor, param1Object, TextFormat.multiLineOutput(param1Appendable));
    }
    
    public String printFieldToString(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        printField(param1FieldDescriptor, param1Object, stringBuilder);
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public void printFieldValue(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object, Appendable param1Appendable) throws IOException {
      printFieldValue(param1FieldDescriptor, param1Object, TextFormat.multiLineOutput(param1Appendable));
    }
    
    public String printToString(MessageOrBuilder param1MessageOrBuilder) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        print(param1MessageOrBuilder, stringBuilder);
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String printToString(UnknownFieldSet param1UnknownFieldSet) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        print(param1UnknownFieldSet, stringBuilder);
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String shortDebugString(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        printField(param1FieldDescriptor, param1Object, TextFormat.singleLineOutput(stringBuilder));
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String shortDebugString(MessageOrBuilder param1MessageOrBuilder) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        print(param1MessageOrBuilder, TextFormat.singleLineOutput(stringBuilder));
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String shortDebugString(UnknownFieldSet param1UnknownFieldSet) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        printUnknownFields(param1UnknownFieldSet, TextFormat.singleLineOutput(stringBuilder));
        return stringBuilder.toString();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public Printer usingTypeRegistry(TypeRegistry param1TypeRegistry) {
      if (this.typeRegistry == TypeRegistry.getEmptyTypeRegistry())
        return new Printer(this.escapeNonAscii, param1TypeRegistry); 
      throw new IllegalArgumentException("Only one typeRegistry is allowed.");
    }
    
    static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
      private Object entry;
      
      private final Descriptors.FieldDescriptor.JavaType fieldType;
      
      private MapEntry mapEntry;
      
      public MapEntryAdapter(Object param2Object, Descriptors.FieldDescriptor param2FieldDescriptor) {
        if (param2Object instanceof MapEntry) {
          this.mapEntry = (MapEntry)param2Object;
        } else {
          this.entry = param2Object;
        } 
        this.fieldType = extractFieldType(param2FieldDescriptor);
      }
      
      private static Descriptors.FieldDescriptor.JavaType extractFieldType(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return ((Descriptors.FieldDescriptor)param2FieldDescriptor.getMessageType().getFields().get(0)).getJavaType();
      }
      
      public int compareTo(MapEntryAdapter param2MapEntryAdapter) {
        String str;
        if (getKey() == null || param2MapEntryAdapter.getKey() == null) {
          TextFormat.logger.info("Invalid key for map field.");
          return -1;
        } 
        int i = TextFormat.null.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.fieldType.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4)
                return 0; 
              String str1 = (String)getKey();
              str = (String)param2MapEntryAdapter.getKey();
              return (str1 == null && str == null) ? 0 : ((str1 == null && str != null) ? -1 : ((str1 != null && str == null) ? 1 : str1.compareTo(str)));
            } 
            return Integer.compare(((Integer)getKey()).intValue(), ((Integer)str.getKey()).intValue());
          } 
          return Long.compare(((Long)getKey()).longValue(), ((Long)str.getKey()).longValue());
        } 
        return Boolean.compare(((Boolean)getKey()).booleanValue(), ((Boolean)str.getKey()).booleanValue());
      }
      
      public Object getEntry() {
        MapEntry mapEntry = this.mapEntry;
        return (mapEntry != null) ? mapEntry : this.entry;
      }
      
      public Object getKey() {
        MapEntry mapEntry = this.mapEntry;
        return (mapEntry != null) ? mapEntry.getKey() : null;
      }
    }
  }
  
  static class MapEntryAdapter implements Comparable<Printer.MapEntryAdapter> {
    private Object entry;
    
    private final Descriptors.FieldDescriptor.JavaType fieldType;
    
    private MapEntry mapEntry;
    
    public MapEntryAdapter(Object param1Object, Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1Object instanceof MapEntry) {
        this.mapEntry = (MapEntry)param1Object;
      } else {
        this.entry = param1Object;
      } 
      this.fieldType = extractFieldType(param1FieldDescriptor);
    }
    
    private static Descriptors.FieldDescriptor.JavaType extractFieldType(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return ((Descriptors.FieldDescriptor)param1FieldDescriptor.getMessageType().getFields().get(0)).getJavaType();
    }
    
    public int compareTo(MapEntryAdapter param1MapEntryAdapter) {
      String str;
      if (getKey() == null || param1MapEntryAdapter.getKey() == null) {
        TextFormat.logger.info("Invalid key for map field.");
        return -1;
      } 
      int i = TextFormat.null.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.fieldType.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4)
              return 0; 
            String str1 = (String)getKey();
            str = (String)param1MapEntryAdapter.getKey();
            return (str1 == null && str == null) ? 0 : ((str1 == null && str != null) ? -1 : ((str1 != null && str == null) ? 1 : str1.compareTo(str)));
          } 
          return Integer.compare(((Integer)getKey()).intValue(), ((Integer)str.getKey()).intValue());
        } 
        return Long.compare(((Long)getKey()).longValue(), ((Long)str.getKey()).longValue());
      } 
      return Boolean.compare(((Boolean)getKey()).booleanValue(), ((Boolean)str.getKey()).booleanValue());
    }
    
    public Object getEntry() {
      MapEntry mapEntry = this.mapEntry;
      return (mapEntry != null) ? mapEntry : this.entry;
    }
    
    public Object getKey() {
      MapEntry mapEntry = this.mapEntry;
      return (mapEntry != null) ? mapEntry.getKey() : null;
    }
  }
  
  static final class TextGenerator {
    private boolean atStartOfLine = false;
    
    private final StringBuilder indent = new StringBuilder();
    
    private final Appendable output;
    
    private final boolean singleLineMode;
    
    private TextGenerator(Appendable param1Appendable, boolean param1Boolean) {
      this.output = param1Appendable;
      this.singleLineMode = param1Boolean;
    }
    
    public void eol() throws IOException {
      if (!this.singleLineMode)
        this.output.append("\n"); 
      this.atStartOfLine = true;
    }
    
    public void indent() {
      this.indent.append("  ");
    }
    
    public void outdent() {
      int i = this.indent.length();
      if (i != 0) {
        this.indent.setLength(i - 2);
        return;
      } 
      throw new IllegalArgumentException(" Outdent() without matching Indent().");
    }
    
    public void print(CharSequence param1CharSequence) throws IOException {
      if (this.atStartOfLine) {
        StringBuilder stringBuilder;
        this.atStartOfLine = false;
        Appendable appendable = this.output;
        if (this.singleLineMode) {
          String str = " ";
        } else {
          stringBuilder = this.indent;
        } 
        appendable.append(stringBuilder);
      } 
      this.output.append(param1CharSequence);
    }
  }
  
  static final class Tokenizer {
    private static final Pattern DOUBLE_INFINITY;
    
    private static final Pattern FLOAT_INFINITY;
    
    private static final Pattern FLOAT_NAN;
    
    private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
    
    private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
    
    private int column = 0;
    
    private String currentToken;
    
    private int line = 0;
    
    private final Matcher matcher;
    
    private int pos = 0;
    
    private int previousColumn = 0;
    
    private int previousLine = 0;
    
    private final CharSequence text;
    
    static {
      DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
      FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
      FLOAT_NAN = Pattern.compile("nanf?", 2);
    }
    
    private Tokenizer(CharSequence param1CharSequence) {
      this.text = param1CharSequence;
      this.matcher = WHITESPACE.matcher(param1CharSequence);
      skipWhitespace();
      nextToken();
    }
    
    private void consumeByteString(List<ByteString> param1List) throws TextFormat.ParseException {
      int i = this.currentToken.length();
      char c = Character.MIN_VALUE;
      if (i > 0)
        c = this.currentToken.charAt(0); 
      if (c == '"' || c == '\'') {
        if (this.currentToken.length() >= 2) {
          String str = this.currentToken;
          if (str.charAt(str.length() - 1) == c)
            try {
              ByteString byteString = TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
              nextToken();
              param1List.add(byteString);
              return;
            } catch (InvalidEscapeSequenceException invalidEscapeSequenceException) {
              throw parseException(invalidEscapeSequenceException.getMessage());
            }  
        } 
        throw parseException("String missing ending quote.");
      } 
      throw parseException("Expected string.");
    }
    
    private TextFormat.ParseException floatParseException(NumberFormatException param1NumberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Couldn't parse number: ");
      stringBuilder.append(param1NumberFormatException.getMessage());
      return parseException(stringBuilder.toString());
    }
    
    private TextFormat.ParseException integerParseException(NumberFormatException param1NumberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Couldn't parse integer: ");
      stringBuilder.append(param1NumberFormatException.getMessage());
      return parseException(stringBuilder.toString());
    }
    
    private void skipWhitespace() {
      this.matcher.usePattern(WHITESPACE);
      if (this.matcher.lookingAt()) {
        Matcher matcher = this.matcher;
        matcher.region(matcher.end(), this.matcher.regionEnd());
      } 
    }
    
    public boolean atEnd() {
      return (this.currentToken.length() == 0);
    }
    
    public void consume(String param1String) throws TextFormat.ParseException {
      if (tryConsume(param1String))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected \"");
      stringBuilder.append(param1String);
      stringBuilder.append("\".");
      throw parseException(stringBuilder.toString());
    }
    
    public boolean consumeBoolean() throws TextFormat.ParseException {
      if (this.currentToken.equals("true") || this.currentToken.equals("True") || this.currentToken.equals("t") || this.currentToken.equals("1")) {
        nextToken();
        return true;
      } 
      if (this.currentToken.equals("false") || this.currentToken.equals("False") || this.currentToken.equals("f") || this.currentToken.equals("0")) {
        nextToken();
        return false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected \"true\" or \"false\". Found \"");
      stringBuilder.append(this.currentToken);
      stringBuilder.append("\".");
      throw parseException(stringBuilder.toString());
    }
    
    public ByteString consumeByteString() throws TextFormat.ParseException {
      ArrayList<ByteString> arrayList = new ArrayList();
      consumeByteString(arrayList);
      while (true) {
        if (this.currentToken.startsWith("'") || this.currentToken.startsWith("\"")) {
          consumeByteString(arrayList);
          continue;
        } 
        return ByteString.copyFrom(arrayList);
      } 
    }
    
    public double consumeDouble() throws TextFormat.ParseException {
      if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
        boolean bool = this.currentToken.startsWith("-");
        nextToken();
        return bool ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
      } 
      if (this.currentToken.equalsIgnoreCase("nan")) {
        nextToken();
        return Double.NaN;
      } 
      try {
        double d = Double.parseDouble(this.currentToken);
        nextToken();
        return d;
      } catch (NumberFormatException numberFormatException) {
        throw floatParseException(numberFormatException);
      } 
    }
    
    public float consumeFloat() throws TextFormat.ParseException {
      if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
        boolean bool = this.currentToken.startsWith("-");
        nextToken();
        return bool ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
      } 
      if (FLOAT_NAN.matcher(this.currentToken).matches()) {
        nextToken();
        return Float.NaN;
      } 
      try {
        float f = Float.parseFloat(this.currentToken);
        nextToken();
        return f;
      } catch (NumberFormatException numberFormatException) {
        throw floatParseException(numberFormatException);
      } 
    }
    
    public String consumeIdentifier() throws TextFormat.ParseException {
      int i = 0;
      while (i < this.currentToken.length()) {
        char c = this.currentToken.charAt(i);
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9') || c == '_' || c == '.') {
          i++;
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected identifier. Found '");
        stringBuilder.append(this.currentToken);
        stringBuilder.append("'");
        throw parseException(stringBuilder.toString());
      } 
      String str = this.currentToken;
      nextToken();
      return str;
    }
    
    public int consumeInt32() throws TextFormat.ParseException {
      try {
        int i = TextFormat.parseInt32(this.currentToken);
        nextToken();
        return i;
      } catch (NumberFormatException numberFormatException) {
        throw integerParseException(numberFormatException);
      } 
    }
    
    public long consumeInt64() throws TextFormat.ParseException {
      try {
        long l = TextFormat.parseInt64(this.currentToken);
        nextToken();
        return l;
      } catch (NumberFormatException numberFormatException) {
        throw integerParseException(numberFormatException);
      } 
    }
    
    public String consumeString() throws TextFormat.ParseException {
      return consumeByteString().toStringUtf8();
    }
    
    public int consumeUInt32() throws TextFormat.ParseException {
      try {
        int i = TextFormat.parseUInt32(this.currentToken);
        nextToken();
        return i;
      } catch (NumberFormatException numberFormatException) {
        throw integerParseException(numberFormatException);
      } 
    }
    
    public long consumeUInt64() throws TextFormat.ParseException {
      try {
        long l = TextFormat.parseUInt64(this.currentToken);
        nextToken();
        return l;
      } catch (NumberFormatException numberFormatException) {
        throw integerParseException(numberFormatException);
      } 
    }
    
    int getColumn() {
      return this.column;
    }
    
    int getLine() {
      return this.line;
    }
    
    int getPreviousColumn() {
      return this.previousColumn;
    }
    
    int getPreviousLine() {
      return this.previousLine;
    }
    
    public boolean lookingAt(String param1String) {
      return this.currentToken.equals(param1String);
    }
    
    public boolean lookingAtInteger() {
      int i = this.currentToken.length();
      boolean bool = false;
      if (i == 0)
        return false; 
      i = this.currentToken.charAt(0);
      if ((48 <= i && i <= 57) || i == 45 || i == 43)
        bool = true; 
      return bool;
    }
    
    public void nextToken() {
      this.previousLine = this.line;
      this.previousColumn = this.column;
      while (this.pos < this.matcher.regionStart()) {
        if (this.text.charAt(this.pos) == '\n') {
          this.line++;
          this.column = 0;
        } else {
          this.column++;
        } 
        this.pos++;
      } 
      if (this.matcher.regionStart() == this.matcher.regionEnd()) {
        this.currentToken = "";
        return;
      } 
      this.matcher.usePattern(TOKEN);
      if (this.matcher.lookingAt()) {
        this.currentToken = this.matcher.group();
        Matcher matcher = this.matcher;
        matcher.region(matcher.end(), this.matcher.regionEnd());
      } else {
        this.currentToken = String.valueOf(this.text.charAt(this.pos));
        Matcher matcher = this.matcher;
        matcher.region(this.pos + 1, matcher.regionEnd());
      } 
      skipWhitespace();
    }
    
    public TextFormat.ParseException parseException(String param1String) {
      return new TextFormat.ParseException(this.line + 1, this.column + 1, param1String);
    }
    
    public TextFormat.ParseException parseExceptionPreviousToken(String param1String) {
      return new TextFormat.ParseException(this.previousLine + 1, this.previousColumn + 1, param1String);
    }
    
    public boolean tryConsume(String param1String) {
      if (this.currentToken.equals(param1String)) {
        nextToken();
        return true;
      } 
      return false;
    }
    
    public boolean tryConsumeDouble() {
      try {
        consumeDouble();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public boolean tryConsumeFloat() {
      try {
        consumeFloat();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public boolean tryConsumeIdentifier() {
      try {
        consumeIdentifier();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public boolean tryConsumeInt64() {
      try {
        consumeInt64();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public boolean tryConsumeString() {
      try {
        consumeString();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public boolean tryConsumeUInt64() {
      try {
        consumeUInt64();
        return true;
      } catch (ParseException parseException) {
        return false;
      } 
    }
    
    public TextFormat.UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String param1String1, String param1String2) {
      return new TextFormat.UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, param1String1, param1String2);
    }
  }
  
  public static class UnknownFieldParseException extends ParseException {
    private final String unknownField;
    
    public UnknownFieldParseException(int param1Int1, int param1Int2, String param1String1, String param1String2) {
      super(param1Int1, param1Int2, param1String2);
      this.unknownField = param1String1;
    }
    
    public UnknownFieldParseException(String param1String) {
      this(-1, -1, "", param1String);
    }
    
    public String getUnknownField() {
      return this.unknownField;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\TextFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */