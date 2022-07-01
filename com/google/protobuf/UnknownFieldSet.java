package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

public final class UnknownFieldSet implements MessageLite {
  private static final Parser PARSER;
  
  private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap(), Collections.emptyMap());
  
  private final Map<Integer, Field> fields = null;
  
  private final Map<Integer, Field> fieldsDescending = null;
  
  static {
    PARSER = new Parser();
  }
  
  private UnknownFieldSet() {}
  
  UnknownFieldSet(Map<Integer, Field> paramMap1, Map<Integer, Field> paramMap2) {}
  
  public static UnknownFieldSet getDefaultInstance() {
    return defaultInstance;
  }
  
  public static Builder newBuilder() {
    return Builder.create();
  }
  
  public static Builder newBuilder(UnknownFieldSet paramUnknownFieldSet) {
    return newBuilder().mergeFrom(paramUnknownFieldSet);
  }
  
  public static UnknownFieldSet parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return newBuilder().mergeFrom(paramByteString).build();
  }
  
  public static UnknownFieldSet parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return newBuilder().mergeFrom(paramCodedInputStream).build();
  }
  
  public static UnknownFieldSet parseFrom(InputStream paramInputStream) throws IOException {
    return newBuilder().mergeFrom(paramInputStream).build();
  }
  
  public static UnknownFieldSet parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return newBuilder().mergeFrom(paramArrayOfbyte).build();
  }
  
  public Map<Integer, Field> asMap() {
    return this.fields;
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject) ? true : ((paramObject instanceof UnknownFieldSet && this.fields.equals(((UnknownFieldSet)paramObject).fields)));
  }
  
  public UnknownFieldSet getDefaultInstanceForType() {
    return defaultInstance;
  }
  
  public Field getField(int paramInt) {
    Field field2 = this.fields.get(Integer.valueOf(paramInt));
    Field field1 = field2;
    if (field2 == null)
      field1 = Field.getDefaultInstance(); 
    return field1;
  }
  
  public final Parser getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    Iterator<Map.Entry> iterator = this.fields.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Field)entry.getValue()).getSerializedSize(((Integer)entry.getKey()).intValue()))
      Map.Entry entry = iterator.next(); 
    return i;
  }
  
  public int getSerializedSizeAsMessageSet() {
    Iterator<Map.Entry> iterator = this.fields.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Field)entry.getValue()).getSerializedSizeAsMessageSetExtension(((Integer)entry.getKey()).intValue()))
      Map.Entry entry = iterator.next(); 
    return i;
  }
  
  public boolean hasField(int paramInt) {
    return this.fields.containsKey(Integer.valueOf(paramInt));
  }
  
  public int hashCode() {
    return this.fields.hashCode();
  }
  
  public boolean isInitialized() {
    return true;
  }
  
  public Builder newBuilderForType() {
    return newBuilder();
  }
  
  public Builder toBuilder() {
    return newBuilder().mergeFrom(this);
  }
  
  public byte[] toByteArray() {
    try {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(arrayOfByte);
      writeTo(codedOutputStream);
      codedOutputStream.checkNoSpaceLeft();
      return arrayOfByte;
    } catch (IOException iOException) {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", iOException);
    } 
  }
  
  public ByteString toByteString() {
    try {
      ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(codedBuilder.getCodedOutput());
      return codedBuilder.build();
    } catch (IOException iOException) {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", iOException);
    } 
  }
  
  public String toString() {
    return TextFormat.printer().printToString(this);
  }
  
  public void writeAsMessageSetTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (Map.Entry<Integer, Field> entry : this.fields.entrySet())
      ((Field)entry.getValue()).writeAsMessageSetExtensionTo(((Integer)entry.getKey()).intValue(), paramCodedOutputStream); 
  }
  
  void writeAsMessageSetTo(Writer paramWriter) throws IOException {
    if (paramWriter.fieldOrder() == Writer.FieldOrder.DESCENDING) {
      for (Map.Entry<Integer, Field> entry : this.fieldsDescending.entrySet())
        ((Field)entry.getValue()).writeAsMessageSetExtensionTo(((Integer)entry.getKey()).intValue(), paramWriter); 
    } else {
      for (Map.Entry<Integer, Field> entry : this.fields.entrySet())
        ((Field)entry.getValue()).writeAsMessageSetExtensionTo(((Integer)entry.getKey()).intValue(), paramWriter); 
    } 
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream) throws IOException {
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream);
    codedOutputStream.writeRawVarint32(getSerializedSize());
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (Map.Entry<Integer, Field> entry : this.fields.entrySet())
      ((Field)entry.getValue()).writeTo(((Integer)entry.getKey()).intValue(), paramCodedOutputStream); 
  }
  
  void writeTo(Writer paramWriter) throws IOException {
    if (paramWriter.fieldOrder() == Writer.FieldOrder.DESCENDING) {
      for (Map.Entry<Integer, Field> entry : this.fieldsDescending.entrySet())
        ((Field)entry.getValue()).writeTo(((Integer)entry.getKey()).intValue(), paramWriter); 
    } else {
      for (Map.Entry<Integer, Field> entry : this.fields.entrySet())
        ((Field)entry.getValue()).writeTo(((Integer)entry.getKey()).intValue(), paramWriter); 
    } 
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream);
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public static final class Builder implements MessageLite.Builder {
    private Map<Integer, UnknownFieldSet.Field> fields;
    
    private UnknownFieldSet.Field.Builder lastField;
    
    private int lastFieldNumber;
    
    private static Builder create() {
      Builder builder = new Builder();
      builder.reinitialize();
      return builder;
    }
    
    private UnknownFieldSet.Field.Builder getFieldBuilder(int param1Int) {
      UnknownFieldSet.Field.Builder builder = this.lastField;
      if (builder != null) {
        int i = this.lastFieldNumber;
        if (param1Int == i)
          return builder; 
        addField(i, builder.build());
      } 
      if (param1Int == 0)
        return null; 
      UnknownFieldSet.Field field = this.fields.get(Integer.valueOf(param1Int));
      this.lastFieldNumber = param1Int;
      this.lastField = UnknownFieldSet.Field.newBuilder();
      if (field != null)
        this.lastField.mergeFrom(field); 
      return this.lastField;
    }
    
    private void reinitialize() {
      this.fields = Collections.emptyMap();
      this.lastFieldNumber = 0;
      this.lastField = null;
    }
    
    public Builder addField(int param1Int, UnknownFieldSet.Field param1Field) {
      if (param1Int != 0) {
        if (this.lastField != null && this.lastFieldNumber == param1Int) {
          this.lastField = null;
          this.lastFieldNumber = 0;
        } 
        if (this.fields.isEmpty())
          this.fields = new TreeMap<Integer, UnknownFieldSet.Field>(); 
        this.fields.put(Integer.valueOf(param1Int), param1Field);
        return this;
      } 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    
    public Map<Integer, UnknownFieldSet.Field> asMap() {
      getFieldBuilder(0);
      return Collections.unmodifiableMap(this.fields);
    }
    
    public UnknownFieldSet build() {
      UnknownFieldSet unknownFieldSet;
      getFieldBuilder(0);
      if (this.fields.isEmpty()) {
        unknownFieldSet = UnknownFieldSet.getDefaultInstance();
      } else {
        Map<?, ?> map = Collections.unmodifiableMap(((TreeMap<?, ?>)this.fields).descendingMap());
        unknownFieldSet = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), (Map)map);
      } 
      this.fields = null;
      return unknownFieldSet;
    }
    
    public UnknownFieldSet buildPartial() {
      return build();
    }
    
    public Builder clear() {
      reinitialize();
      return this;
    }
    
    public Builder clearField(int param1Int) {
      if (param1Int != 0) {
        if (this.lastField != null && this.lastFieldNumber == param1Int) {
          this.lastField = null;
          this.lastFieldNumber = 0;
        } 
        if (this.fields.containsKey(Integer.valueOf(param1Int)))
          this.fields.remove(Integer.valueOf(param1Int)); 
        return this;
      } 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    
    public Builder clone() {
      getFieldBuilder(0);
      Map<?, ?> map = Collections.unmodifiableMap(((TreeMap<?, ?>)this.fields).descendingMap());
      return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, (Map)map));
    }
    
    public UnknownFieldSet getDefaultInstanceForType() {
      return UnknownFieldSet.getDefaultInstance();
    }
    
    public boolean hasField(int param1Int) {
      if (param1Int != 0)
        return (param1Int == this.lastFieldNumber || this.fields.containsKey(Integer.valueOf(param1Int))); 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    
    public boolean isInitialized() {
      return true;
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException {
      int i = param1InputStream.read();
      if (i == -1)
        return false; 
      mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(param1InputStream, CodedInputStream.readRawVarint32(i, param1InputStream)));
      return true;
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return mergeDelimitedFrom(param1InputStream);
    }
    
    public Builder mergeField(int param1Int, UnknownFieldSet.Field param1Field) {
      if (param1Int != 0) {
        if (hasField(param1Int)) {
          getFieldBuilder(param1Int).mergeFrom(param1Field);
          return this;
        } 
        addField(param1Int, param1Field);
        return this;
      } 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    
    public boolean mergeFieldFrom(int param1Int, CodedInputStream param1CodedInputStream) throws IOException {
      int i = WireFormat.getTagFieldNumber(param1Int);
      param1Int = WireFormat.getTagWireType(param1Int);
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int != 3) {
              if (param1Int != 4) {
                if (param1Int == 5) {
                  getFieldBuilder(i).addFixed32(param1CodedInputStream.readFixed32());
                  return true;
                } 
                throw InvalidProtocolBufferException.invalidWireType();
              } 
              return false;
            } 
            Builder builder = UnknownFieldSet.newBuilder();
            param1CodedInputStream.readGroup(i, builder, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(i).addGroup(builder.build());
            return true;
          } 
          getFieldBuilder(i).addLengthDelimited(param1CodedInputStream.readBytes());
          return true;
        } 
        getFieldBuilder(i).addFixed64(param1CodedInputStream.readFixed64());
        return true;
      } 
      getFieldBuilder(i).addVarint(param1CodedInputStream.readInt64());
      return true;
    }
    
    public Builder mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = param1ByteString.newCodedInput();
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", iOException);
      } 
    }
    
    public Builder mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return mergeFrom(param1ByteString);
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream) throws IOException {
      int i;
      do {
        i = param1CodedInputStream.readTag();
      } while (i != 0 && mergeFieldFrom(i, param1CodedInputStream));
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return mergeFrom(param1CodedInputStream);
    }
    
    public Builder mergeFrom(MessageLite param1MessageLite) {
      if (param1MessageLite instanceof UnknownFieldSet)
        return mergeFrom((UnknownFieldSet)param1MessageLite); 
      throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
    
    public Builder mergeFrom(UnknownFieldSet param1UnknownFieldSet) {
      if (param1UnknownFieldSet != UnknownFieldSet.getDefaultInstance())
        for (Map.Entry entry : param1UnknownFieldSet.fields.entrySet())
          mergeField(((Integer)entry.getKey()).intValue(), (UnknownFieldSet.Field)entry.getValue());  
      return this;
    }
    
    public Builder mergeFrom(InputStream param1InputStream) throws IOException {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(param1InputStream);
      mergeFrom(codedInputStream);
      codedInputStream.checkLastTagWas(0);
      return this;
    }
    
    public Builder mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return mergeFrom(param1InputStream);
    }
    
    public Builder mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte);
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
      } 
    }
    
    public Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte, param1Int1, param1Int2);
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", iOException);
      } 
    }
    
    public Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public Builder mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte);
    }
    
    public Builder mergeLengthDelimitedField(int param1Int, ByteString param1ByteString) {
      if (param1Int != 0) {
        getFieldBuilder(param1Int).addLengthDelimited(param1ByteString);
        return this;
      } 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
    
    public Builder mergeVarintField(int param1Int1, int param1Int2) {
      if (param1Int1 != 0) {
        getFieldBuilder(param1Int1).addVarint(param1Int2);
        return this;
      } 
      throw new IllegalArgumentException("Zero is not a valid field number.");
    }
  }
  
  public static final class Field {
    private static final Field fieldDefaultInstance = newBuilder().build();
    
    private List<Integer> fixed32;
    
    private List<Long> fixed64;
    
    private List<UnknownFieldSet> group;
    
    private List<ByteString> lengthDelimited;
    
    private List<Long> varint;
    
    private Field() {}
    
    public static Field getDefaultInstance() {
      return fieldDefaultInstance;
    }
    
    private Object[] getIdentityArray() {
      return new Object[] { this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group };
    }
    
    public static Builder newBuilder() {
      return Builder.create();
    }
    
    public static Builder newBuilder(Field param1Field) {
      return newBuilder().mergeFrom(param1Field);
    }
    
    private void writeAsMessageSetExtensionTo(int param1Int, Writer param1Writer) throws IOException {
      if (param1Writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
        List<ByteString> list = this.lengthDelimited;
        ListIterator<ByteString> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious())
          param1Writer.writeMessageSetItem(param1Int, listIterator.previous()); 
      } else {
        Iterator<ByteString> iterator = this.lengthDelimited.iterator();
        while (iterator.hasNext())
          param1Writer.writeMessageSetItem(param1Int, iterator.next()); 
      } 
    }
    
    public boolean equals(Object param1Object) {
      return (this == param1Object) ? true : (!(param1Object instanceof Field) ? false : Arrays.equals(getIdentityArray(), ((Field)param1Object).getIdentityArray()));
    }
    
    public List<Integer> getFixed32List() {
      return this.fixed32;
    }
    
    public List<Long> getFixed64List() {
      return this.fixed64;
    }
    
    public List<UnknownFieldSet> getGroupList() {
      return this.group;
    }
    
    public List<ByteString> getLengthDelimitedList() {
      return this.lengthDelimited;
    }
    
    public int getSerializedSize(int param1Int) {
      Iterator<Long> iterator = this.varint.iterator();
      int i;
      for (i = 0; iterator.hasNext(); i += CodedOutputStream.computeUInt64Size(param1Int, ((Long)iterator.next()).longValue()));
      iterator = (Iterator)this.fixed32.iterator();
      while (iterator.hasNext())
        i += CodedOutputStream.computeFixed32Size(param1Int, ((Integer)iterator.next()).intValue()); 
      iterator = this.fixed64.iterator();
      while (iterator.hasNext())
        i += CodedOutputStream.computeFixed64Size(param1Int, ((Long)iterator.next()).longValue()); 
      iterator = (Iterator)this.lengthDelimited.iterator();
      while (iterator.hasNext())
        i += CodedOutputStream.computeBytesSize(param1Int, (ByteString)iterator.next()); 
      iterator = (Iterator)this.group.iterator();
      while (iterator.hasNext())
        i += CodedOutputStream.computeGroupSize(param1Int, (UnknownFieldSet)iterator.next()); 
      return i;
    }
    
    public int getSerializedSizeAsMessageSetExtension(int param1Int) {
      Iterator<ByteString> iterator = this.lengthDelimited.iterator();
      int i;
      for (i = 0; iterator.hasNext(); i += CodedOutputStream.computeRawMessageSetExtensionSize(param1Int, iterator.next()));
      return i;
    }
    
    public List<Long> getVarintList() {
      return this.varint;
    }
    
    public int hashCode() {
      return Arrays.hashCode(getIdentityArray());
    }
    
    public ByteString toByteString(int param1Int) {
      try {
        ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(getSerializedSize(param1Int));
        writeTo(param1Int, codedBuilder.getCodedOutput());
        return codedBuilder.build();
      } catch (IOException iOException) {
        throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", iOException);
      } 
    }
    
    public void writeAsMessageSetExtensionTo(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      Iterator<ByteString> iterator = this.lengthDelimited.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeRawMessageSetExtension(param1Int, iterator.next()); 
    }
    
    public void writeTo(int param1Int, CodedOutputStream param1CodedOutputStream) throws IOException {
      Iterator<Long> iterator = this.varint.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeUInt64(param1Int, ((Long)iterator.next()).longValue()); 
      iterator = (Iterator)this.fixed32.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeFixed32(param1Int, ((Integer)iterator.next()).intValue()); 
      iterator = this.fixed64.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeFixed64(param1Int, ((Long)iterator.next()).longValue()); 
      iterator = (Iterator)this.lengthDelimited.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeBytes(param1Int, (ByteString)iterator.next()); 
      iterator = (Iterator)this.group.iterator();
      while (iterator.hasNext())
        param1CodedOutputStream.writeGroup(param1Int, (UnknownFieldSet)iterator.next()); 
    }
    
    void writeTo(int param1Int, Writer param1Writer) throws IOException {
      List<Long> list = this.varint;
      int i = 0;
      param1Writer.writeInt64List(param1Int, list, false);
      param1Writer.writeFixed32List(param1Int, this.fixed32, false);
      param1Writer.writeFixed64List(param1Int, this.fixed64, false);
      param1Writer.writeBytesList(param1Int, this.lengthDelimited);
      if (param1Writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
        while (i < this.group.size()) {
          param1Writer.writeStartGroup(param1Int);
          ((UnknownFieldSet)this.group.get(i)).writeTo(param1Writer);
          param1Writer.writeEndGroup(param1Int);
          i++;
        } 
      } else {
        for (i = this.group.size() - 1; i >= 0; i--) {
          param1Writer.writeEndGroup(param1Int);
          ((UnknownFieldSet)this.group.get(i)).writeTo(param1Writer);
          param1Writer.writeStartGroup(param1Int);
        } 
      } 
    }
    
    public static final class Builder {
      private UnknownFieldSet.Field result;
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new UnknownFieldSet.Field();
        return builder;
      }
      
      public Builder addFixed32(int param2Int) {
        if (this.result.fixed32 == null)
          UnknownFieldSet.Field.access$602(this.result, new ArrayList()); 
        this.result.fixed32.add(Integer.valueOf(param2Int));
        return this;
      }
      
      public Builder addFixed64(long param2Long) {
        if (this.result.fixed64 == null)
          UnknownFieldSet.Field.access$702(this.result, new ArrayList()); 
        this.result.fixed64.add(Long.valueOf(param2Long));
        return this;
      }
      
      public Builder addGroup(UnknownFieldSet param2UnknownFieldSet) {
        if (this.result.group == null)
          UnknownFieldSet.Field.access$902(this.result, new ArrayList()); 
        this.result.group.add(param2UnknownFieldSet);
        return this;
      }
      
      public Builder addLengthDelimited(ByteString param2ByteString) {
        if (this.result.lengthDelimited == null)
          UnknownFieldSet.Field.access$802(this.result, new ArrayList()); 
        this.result.lengthDelimited.add(param2ByteString);
        return this;
      }
      
      public Builder addVarint(long param2Long) {
        if (this.result.varint == null)
          UnknownFieldSet.Field.access$502(this.result, new ArrayList()); 
        this.result.varint.add(Long.valueOf(param2Long));
        return this;
      }
      
      public UnknownFieldSet.Field build() {
        if (this.result.varint == null) {
          UnknownFieldSet.Field.access$502(this.result, Collections.emptyList());
        } else {
          UnknownFieldSet.Field field1 = this.result;
          UnknownFieldSet.Field.access$502(field1, Collections.unmodifiableList(field1.varint));
        } 
        if (this.result.fixed32 == null) {
          UnknownFieldSet.Field.access$602(this.result, Collections.emptyList());
        } else {
          UnknownFieldSet.Field field1 = this.result;
          UnknownFieldSet.Field.access$602(field1, Collections.unmodifiableList(field1.fixed32));
        } 
        if (this.result.fixed64 == null) {
          UnknownFieldSet.Field.access$702(this.result, Collections.emptyList());
        } else {
          UnknownFieldSet.Field field1 = this.result;
          UnknownFieldSet.Field.access$702(field1, Collections.unmodifiableList(field1.fixed64));
        } 
        if (this.result.lengthDelimited == null) {
          UnknownFieldSet.Field.access$802(this.result, Collections.emptyList());
        } else {
          UnknownFieldSet.Field field1 = this.result;
          UnknownFieldSet.Field.access$802(field1, Collections.unmodifiableList(field1.lengthDelimited));
        } 
        if (this.result.group == null) {
          UnknownFieldSet.Field.access$902(this.result, Collections.emptyList());
        } else {
          UnknownFieldSet.Field field1 = this.result;
          UnknownFieldSet.Field.access$902(field1, Collections.unmodifiableList(field1.group));
        } 
        UnknownFieldSet.Field field = this.result;
        this.result = null;
        return field;
      }
      
      public Builder clear() {
        this.result = new UnknownFieldSet.Field();
        return this;
      }
      
      public Builder mergeFrom(UnknownFieldSet.Field param2Field) {
        if (!param2Field.varint.isEmpty()) {
          if (this.result.varint == null)
            UnknownFieldSet.Field.access$502(this.result, new ArrayList()); 
          this.result.varint.addAll(param2Field.varint);
        } 
        if (!param2Field.fixed32.isEmpty()) {
          if (this.result.fixed32 == null)
            UnknownFieldSet.Field.access$602(this.result, new ArrayList()); 
          this.result.fixed32.addAll(param2Field.fixed32);
        } 
        if (!param2Field.fixed64.isEmpty()) {
          if (this.result.fixed64 == null)
            UnknownFieldSet.Field.access$702(this.result, new ArrayList()); 
          this.result.fixed64.addAll(param2Field.fixed64);
        } 
        if (!param2Field.lengthDelimited.isEmpty()) {
          if (this.result.lengthDelimited == null)
            UnknownFieldSet.Field.access$802(this.result, new ArrayList()); 
          this.result.lengthDelimited.addAll(param2Field.lengthDelimited);
        } 
        if (!param2Field.group.isEmpty()) {
          if (this.result.group == null)
            UnknownFieldSet.Field.access$902(this.result, new ArrayList()); 
          this.result.group.addAll(param2Field.group);
        } 
        return this;
      }
    }
  }
  
  public static final class Builder {
    private UnknownFieldSet.Field result;
    
    private static Builder create() {
      Builder builder = new Builder();
      builder.result = new UnknownFieldSet.Field();
      return builder;
    }
    
    public Builder addFixed32(int param1Int) {
      if (this.result.fixed32 == null)
        UnknownFieldSet.Field.access$602(this.result, new ArrayList()); 
      this.result.fixed32.add(Integer.valueOf(param1Int));
      return this;
    }
    
    public Builder addFixed64(long param1Long) {
      if (this.result.fixed64 == null)
        UnknownFieldSet.Field.access$702(this.result, new ArrayList()); 
      this.result.fixed64.add(Long.valueOf(param1Long));
      return this;
    }
    
    public Builder addGroup(UnknownFieldSet param1UnknownFieldSet) {
      if (this.result.group == null)
        UnknownFieldSet.Field.access$902(this.result, new ArrayList()); 
      this.result.group.add(param1UnknownFieldSet);
      return this;
    }
    
    public Builder addLengthDelimited(ByteString param1ByteString) {
      if (this.result.lengthDelimited == null)
        UnknownFieldSet.Field.access$802(this.result, new ArrayList()); 
      this.result.lengthDelimited.add(param1ByteString);
      return this;
    }
    
    public Builder addVarint(long param1Long) {
      if (this.result.varint == null)
        UnknownFieldSet.Field.access$502(this.result, new ArrayList()); 
      this.result.varint.add(Long.valueOf(param1Long));
      return this;
    }
    
    public UnknownFieldSet.Field build() {
      if (this.result.varint == null) {
        UnknownFieldSet.Field.access$502(this.result, Collections.emptyList());
      } else {
        UnknownFieldSet.Field field1 = this.result;
        UnknownFieldSet.Field.access$502(field1, Collections.unmodifiableList(field1.varint));
      } 
      if (this.result.fixed32 == null) {
        UnknownFieldSet.Field.access$602(this.result, Collections.emptyList());
      } else {
        UnknownFieldSet.Field field1 = this.result;
        UnknownFieldSet.Field.access$602(field1, Collections.unmodifiableList(field1.fixed32));
      } 
      if (this.result.fixed64 == null) {
        UnknownFieldSet.Field.access$702(this.result, Collections.emptyList());
      } else {
        UnknownFieldSet.Field field1 = this.result;
        UnknownFieldSet.Field.access$702(field1, Collections.unmodifiableList(field1.fixed64));
      } 
      if (this.result.lengthDelimited == null) {
        UnknownFieldSet.Field.access$802(this.result, Collections.emptyList());
      } else {
        UnknownFieldSet.Field field1 = this.result;
        UnknownFieldSet.Field.access$802(field1, Collections.unmodifiableList(field1.lengthDelimited));
      } 
      if (this.result.group == null) {
        UnknownFieldSet.Field.access$902(this.result, Collections.emptyList());
      } else {
        UnknownFieldSet.Field field1 = this.result;
        UnknownFieldSet.Field.access$902(field1, Collections.unmodifiableList(field1.group));
      } 
      UnknownFieldSet.Field field = this.result;
      this.result = null;
      return field;
    }
    
    public Builder clear() {
      this.result = new UnknownFieldSet.Field();
      return this;
    }
    
    public Builder mergeFrom(UnknownFieldSet.Field param1Field) {
      if (!param1Field.varint.isEmpty()) {
        if (this.result.varint == null)
          UnknownFieldSet.Field.access$502(this.result, new ArrayList()); 
        this.result.varint.addAll(param1Field.varint);
      } 
      if (!param1Field.fixed32.isEmpty()) {
        if (this.result.fixed32 == null)
          UnknownFieldSet.Field.access$602(this.result, new ArrayList()); 
        this.result.fixed32.addAll(param1Field.fixed32);
      } 
      if (!param1Field.fixed64.isEmpty()) {
        if (this.result.fixed64 == null)
          UnknownFieldSet.Field.access$702(this.result, new ArrayList()); 
        this.result.fixed64.addAll(param1Field.fixed64);
      } 
      if (!param1Field.lengthDelimited.isEmpty()) {
        if (this.result.lengthDelimited == null)
          UnknownFieldSet.Field.access$802(this.result, new ArrayList()); 
        this.result.lengthDelimited.addAll(param1Field.lengthDelimited);
      } 
      if (!param1Field.group.isEmpty()) {
        if (this.result.group == null)
          UnknownFieldSet.Field.access$902(this.result, new ArrayList()); 
        this.result.group.addAll(param1Field.group);
      } 
      return this;
    }
  }
  
  public static final class Parser extends AbstractParser<UnknownFieldSet> {
    public UnknownFieldSet parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      try {
        builder.mergeFrom(param1CodedInputStream);
        return builder.buildPartial();
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException.setUnfinishedMessage(builder.buildPartial());
      } catch (IOException iOException) {
        throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(builder.buildPartial());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnknownFieldSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */