package com.soft.blued.utils;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.math.BigInteger;
import java.text.StringCharacterIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class Proto2JsonUtils {
  private static final Pattern a = Pattern.compile("[0-9]", 2);
  
  static String a(char paramChar) {
    if (paramChar < '\020') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\u000");
      stringBuilder1.append(Integer.toHexString(paramChar));
      return stringBuilder1.toString();
    } 
    if (paramChar < 'Ā') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\u00");
      stringBuilder1.append(Integer.toHexString(paramChar));
      return stringBuilder1.toString();
    } 
    if (paramChar < 'က') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\\u0");
      stringBuilder1.append(Integer.toHexString(paramChar));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\\u");
    stringBuilder.append(Integer.toHexString(paramChar));
    return stringBuilder.toString();
  }
  
  private static String a(int paramInt) {
    return (paramInt >= 0) ? Integer.toString(paramInt) : Long.toString(paramInt & 0xFFFFFFFFL);
  }
  
  private static String a(long paramLong) {
    return (paramLong >= 0L) ? Long.toString(paramLong) : BigInteger.valueOf(paramLong & Long.MAX_VALUE).setBit(63).toString();
  }
  
  static String a(ByteString paramByteString) {
    StringBuilder stringBuilder = new StringBuilder(paramByteString.size());
    for (int i = 0; i < paramByteString.size(); i++) {
      byte b = paramByteString.byteAt(i);
      if (b != 34) {
        if (b != 39) {
          if (b != 92) {
            switch (b) {
              default:
                if (b >= 32) {
                  stringBuilder.append((char)b);
                  break;
                } 
                stringBuilder.append(a((char)b));
                break;
              case 13:
                stringBuilder.append("\\r");
                break;
              case 12:
                stringBuilder.append("\\f");
                break;
              case 11:
                stringBuilder.append("\\v");
                break;
              case 10:
                stringBuilder.append("\\n");
                break;
              case 9:
                stringBuilder.append("\\t");
                break;
              case 8:
                stringBuilder.append("\\b");
                break;
              case 7:
                stringBuilder.append("\\a");
                break;
            } 
          } else {
            stringBuilder.append("\\\\");
          } 
        } else {
          stringBuilder.append("\\'");
        } 
      } else {
        stringBuilder.append("\\\"");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String a(Message paramMessage) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      a(paramMessage, stringBuilder);
      return stringBuilder.toString();
    } catch (IOException iOException) {
      throw new RuntimeException("Writing to a StringBuilder threw an IOException (should never happen).", iOException);
    } 
  }
  
  static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length());
    StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(paramString);
    for (char c = stringCharacterIterator.first(); c != Character.MAX_VALUE; c = stringCharacterIterator.next()) {
      if (c != '\f') {
        if (c != '\r') {
          if (c != '"') {
            if (c != '\\') {
              switch (c) {
                default:
                  if (c >= '\000' && c <= '\037') {
                    a(stringBuilder, c);
                    break;
                  } 
                  if (Character.isHighSurrogate(c)) {
                    a(stringBuilder, c);
                    c = stringCharacterIterator.next();
                    if (c != Character.MAX_VALUE) {
                      a(stringBuilder, c);
                      break;
                    } 
                    throw new IllegalArgumentException("invalid unicode string: unexpected high surrogate pair value without corresponding low value.");
                  } 
                  stringBuilder.append(c);
                  break;
                case '\n':
                  stringBuilder.append("\\n");
                  break;
                case '\t':
                  stringBuilder.append("\\t");
                  break;
                case '\b':
                  stringBuilder.append("\\b");
                  break;
              } 
            } else {
              stringBuilder.append("\\\\");
            } 
          } else {
            stringBuilder.append("\\\"");
          } 
        } else {
          stringBuilder.append("\\r");
        } 
      } else {
        stringBuilder.append("\\f");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static void a(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, JsonGenerator paramJsonGenerator) throws IOException {
    b(paramFieldDescriptor, paramObject, paramJsonGenerator);
  }
  
  protected static void a(Message paramMessage, JsonGenerator paramJsonGenerator) throws IOException {
    Iterator<Map.Entry> iterator = paramMessage.getAllFields().entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      a((Descriptors.FieldDescriptor)entry.getKey(), entry.getValue(), paramJsonGenerator);
      if (iterator.hasNext())
        paramJsonGenerator.a(","); 
    } 
    if (paramMessage.getUnknownFields().asMap().size() > 0)
      paramJsonGenerator.a(", "); 
    a(paramMessage.getUnknownFields(), paramJsonGenerator);
  }
  
  public static void a(Message paramMessage, Appendable paramAppendable) throws IOException {
    JsonGenerator jsonGenerator = new JsonGenerator(paramAppendable);
    jsonGenerator.a("{");
    a(paramMessage, jsonGenerator);
    jsonGenerator.a("}");
  }
  
  protected static void a(UnknownFieldSet paramUnknownFieldSet, JsonGenerator paramJsonGenerator) throws IOException {
    Iterator<Map.Entry> iterator = paramUnknownFieldSet.asMap().entrySet().iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      UnknownFieldSet.Field field = (UnknownFieldSet.Field)entry.getValue();
      if (bool) {
        bool = false;
      } else {
        paramJsonGenerator.a(", ");
      } 
      paramJsonGenerator.a("\"");
      paramJsonGenerator.a(((Integer)entry.getKey()).toString());
      paramJsonGenerator.a("\"");
      paramJsonGenerator.a(": [");
      null = field.getVarintList().iterator();
      boolean bool1 = true;
      while (null.hasNext()) {
        long l = ((Long)null.next()).longValue();
        if (bool1) {
          bool1 = false;
        } else {
          paramJsonGenerator.a(", ");
        } 
        paramJsonGenerator.a(a(l));
      } 
      null = field.getFixed32List().iterator();
      while (null.hasNext()) {
        int i = ((Integer)null.next()).intValue();
        if (bool1) {
          bool1 = false;
        } else {
          paramJsonGenerator.a(", ");
        } 
        paramJsonGenerator.a(String.format((Locale)null, "0x%08x", new Object[] { Integer.valueOf(i) }));
      } 
      null = field.getFixed64List().iterator();
      while (null.hasNext()) {
        long l = ((Long)null.next()).longValue();
        if (bool1) {
          bool1 = false;
        } else {
          paramJsonGenerator.a(", ");
        } 
        paramJsonGenerator.a(String.format((Locale)null, "0x%016x", new Object[] { Long.valueOf(l) }));
      } 
      for (ByteString byteString : field.getLengthDelimitedList()) {
        if (bool1) {
          bool1 = false;
        } else {
          paramJsonGenerator.a(", ");
        } 
        paramJsonGenerator.a("\"");
        paramJsonGenerator.a(a(byteString));
        paramJsonGenerator.a("\"");
      } 
      for (UnknownFieldSet unknownFieldSet : field.getGroupList()) {
        if (bool1) {
          bool1 = false;
        } else {
          paramJsonGenerator.a(", ");
        } 
        paramJsonGenerator.a("{");
        a(unknownFieldSet, paramJsonGenerator);
        paramJsonGenerator.a("}");
      } 
      paramJsonGenerator.a("]");
    } 
  }
  
  static void a(StringBuilder paramStringBuilder, char paramChar) {
    String str;
    if (paramChar < '\020') {
      str = "\\u000";
    } else if (paramChar < 'Ā') {
      str = "\\u00";
    } else if (paramChar < 'က') {
      str = "\\u0";
    } else {
      str = "\\u";
    } 
    paramStringBuilder.append(str);
    paramStringBuilder.append(Integer.toHexString(paramChar));
  }
  
  private static CharSequence b(String paramString) {
    return paramString.replace("_", "").toLowerCase();
  }
  
  private static void b(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, JsonGenerator paramJsonGenerator) throws IOException {
    if (paramFieldDescriptor.isExtension()) {
      paramJsonGenerator.a("\"");
      if (paramFieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && paramFieldDescriptor.isOptional() && paramFieldDescriptor.getExtensionScope() == paramFieldDescriptor.getMessageType()) {
        paramJsonGenerator.a(b(paramFieldDescriptor.getMessageType().getFullName()));
      } else {
        paramJsonGenerator.a(b(paramFieldDescriptor.getFullName()));
      } 
      paramJsonGenerator.a("\"");
    } else {
      paramJsonGenerator.a("\"");
      if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
        paramJsonGenerator.a(b(paramFieldDescriptor.getMessageType().getName()));
      } else {
        paramJsonGenerator.a(b(paramFieldDescriptor.getName()));
      } 
      paramJsonGenerator.a("\"");
    } 
    if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      paramJsonGenerator.a(": ");
      paramJsonGenerator.a();
    } else {
      paramJsonGenerator.a(": ");
    } 
    if (paramFieldDescriptor.isRepeated()) {
      paramJsonGenerator.a("[");
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        c(paramFieldDescriptor, paramObject.next(), paramJsonGenerator);
        if (paramObject.hasNext())
          paramJsonGenerator.a(","); 
      } 
      paramJsonGenerator.a("]");
      return;
    } 
    c(paramFieldDescriptor, paramObject, paramJsonGenerator);
    if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
      paramJsonGenerator.b(); 
  }
  
  private static void c(Descriptors.FieldDescriptor paramFieldDescriptor, Object paramObject, JsonGenerator paramJsonGenerator) throws IOException {
    switch (null.a[paramFieldDescriptor.getType().ordinal()]) {
      default:
        return;
      case 17:
      case 18:
        paramJsonGenerator.a("{");
        a((Message)paramObject, paramJsonGenerator);
        paramJsonGenerator.a("}");
        return;
      case 16:
        paramJsonGenerator.a("\"");
        paramJsonGenerator.a(((Descriptors.EnumValueDescriptor)paramObject).getName());
        paramJsonGenerator.a("\"");
        return;
      case 15:
        paramJsonGenerator.a("\"");
        paramJsonGenerator.a(a((ByteString)paramObject));
        paramJsonGenerator.a("\"");
        return;
      case 14:
        paramJsonGenerator.a("\"");
        paramJsonGenerator.a(a((String)paramObject));
        paramJsonGenerator.a("\"");
        return;
      case 12:
      case 13:
        paramJsonGenerator.a(a(((Long)paramObject).longValue()));
        return;
      case 10:
      case 11:
        paramJsonGenerator.a(a(((Integer)paramObject).intValue()));
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        break;
    } 
    paramJsonGenerator.a(paramObject.toString());
  }
  
  static class InvalidEscapeSequence extends IOException {}
  
  public static class JsonGenerator {
    Appendable a;
    
    boolean b = true;
    
    StringBuilder c = new StringBuilder();
    
    public JsonGenerator(Appendable param1Appendable) {
      this.a = param1Appendable;
    }
    
    private void a(CharSequence param1CharSequence, int param1Int) throws IOException {
      if (param1Int == 0)
        return; 
      if (this.b) {
        this.b = false;
        this.a.append(this.c);
      } 
      this.a.append(param1CharSequence);
    }
    
    public void a() {
      this.c.append("  ");
    }
    
    public void a(CharSequence param1CharSequence) throws IOException {
      int k = param1CharSequence.length();
      int i = 0;
      int j;
      for (j = 0; i < k; j = m) {
        int m = j;
        if (param1CharSequence.charAt(i) == '\n') {
          a(param1CharSequence.subSequence(j, k), i - j + 1);
          m = i + 1;
          this.b = true;
        } 
        i++;
      } 
      a(param1CharSequence.subSequence(j, k), k - j);
    }
    
    public void b() {
      int i = this.c.length();
      if (i != 0) {
        this.c.delete(i - 2, i);
        return;
      } 
      throw new IllegalArgumentException(" Outdent() without matching Indent().");
    }
  }
  
  public static class ParseException extends IOException {}
  
  public static class Tokenizer {
    private static final Pattern a = Pattern.compile("(\\s|(#.*$))++", 8);
    
    private static final Pattern b = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
    
    private static final Pattern c = Pattern.compile("-?inf(inity)?", 2);
    
    private static final Pattern d = Pattern.compile("-?inf(inity)?f?", 2);
    
    private static final Pattern e = Pattern.compile("nanf?", 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\Proto2JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */