package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DynamicMessage extends AbstractMessage {
  private final FieldSet<Descriptors.FieldDescriptor> fields;
  
  private int memoizedSize = -1;
  
  private final Descriptors.FieldDescriptor[] oneofCases;
  
  private final Descriptors.Descriptor type;
  
  private final UnknownFieldSet unknownFields;
  
  DynamicMessage(Descriptors.Descriptor paramDescriptor, FieldSet<Descriptors.FieldDescriptor> paramFieldSet, Descriptors.FieldDescriptor[] paramArrayOfFieldDescriptor, UnknownFieldSet paramUnknownFieldSet) {
    this.type = paramDescriptor;
    this.fields = paramFieldSet;
    this.oneofCases = paramArrayOfFieldDescriptor;
    this.unknownFields = paramUnknownFieldSet;
  }
  
  public static DynamicMessage getDefaultInstance(Descriptors.Descriptor paramDescriptor) {
    Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = new Descriptors.FieldDescriptor[paramDescriptor.toProto().getOneofDeclCount()];
    return new DynamicMessage(paramDescriptor, FieldSet.emptySet(), arrayOfFieldDescriptor, UnknownFieldSet.getDefaultInstance());
  }
  
  static boolean isInitialized(Descriptors.Descriptor paramDescriptor, FieldSet<Descriptors.FieldDescriptor> paramFieldSet) {
    for (Descriptors.FieldDescriptor fieldDescriptor : paramDescriptor.getFields()) {
      if (fieldDescriptor.isRequired() && !paramFieldSet.hasField(fieldDescriptor))
        return false; 
    } 
    return paramFieldSet.isInitialized();
  }
  
  public static Builder newBuilder(Descriptors.Descriptor paramDescriptor) {
    return new Builder(paramDescriptor);
  }
  
  public static Builder newBuilder(Message paramMessage) {
    return (new Builder(paramMessage.getDescriptorForType())).mergeFrom(paramMessage);
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, ByteString paramByteString) throws InvalidProtocolBufferException {
    return newBuilder(paramDescriptor).mergeFrom(paramByteString).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, ByteString paramByteString, ExtensionRegistry paramExtensionRegistry) throws InvalidProtocolBufferException {
    return newBuilder(paramDescriptor).mergeFrom(paramByteString, paramExtensionRegistry).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, CodedInputStream paramCodedInputStream) throws IOException {
    return newBuilder(paramDescriptor).mergeFrom(paramCodedInputStream).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, CodedInputStream paramCodedInputStream, ExtensionRegistry paramExtensionRegistry) throws IOException {
    return newBuilder(paramDescriptor).mergeFrom(paramCodedInputStream, paramExtensionRegistry).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, InputStream paramInputStream) throws IOException {
    return newBuilder(paramDescriptor).mergeFrom(paramInputStream).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, InputStream paramInputStream, ExtensionRegistry paramExtensionRegistry) throws IOException {
    return newBuilder(paramDescriptor).mergeFrom(paramInputStream, paramExtensionRegistry).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return newBuilder(paramDescriptor).mergeFrom(paramArrayOfbyte).buildParsed();
  }
  
  public static DynamicMessage parseFrom(Descriptors.Descriptor paramDescriptor, byte[] paramArrayOfbyte, ExtensionRegistry paramExtensionRegistry) throws InvalidProtocolBufferException {
    return newBuilder(paramDescriptor).mergeFrom(paramArrayOfbyte, paramExtensionRegistry).buildParsed();
  }
  
  private void verifyContainingType(Descriptors.FieldDescriptor paramFieldDescriptor) {
    if (paramFieldDescriptor.getContainingType() == this.type)
      return; 
    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }
  
  private void verifyOneofContainingType(Descriptors.OneofDescriptor paramOneofDescriptor) {
    if (paramOneofDescriptor.getContainingType() == this.type)
      return; 
    throw new IllegalArgumentException("OneofDescriptor does not match message type.");
  }
  
  public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
    return this.fields.getAllFields();
  }
  
  public DynamicMessage getDefaultInstanceForType() {
    return getDefaultInstance(this.type);
  }
  
  public Descriptors.Descriptor getDescriptorForType() {
    return this.type;
  }
  
  public Object getField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    verifyContainingType(paramFieldDescriptor);
    Object object2 = this.fields.getField(paramFieldDescriptor);
    Object object1 = object2;
    if (object2 == null) {
      if (paramFieldDescriptor.isRepeated())
        return Collections.emptyList(); 
      if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        return getDefaultInstance(paramFieldDescriptor.getMessageType()); 
      object1 = paramFieldDescriptor.getDefaultValue();
    } 
    return object1;
  }
  
  public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor paramOneofDescriptor) {
    verifyOneofContainingType(paramOneofDescriptor);
    return this.oneofCases[paramOneofDescriptor.getIndex()];
  }
  
  public Parser<DynamicMessage> getParserForType() {
    return new AbstractParser<DynamicMessage>() {
        public DynamicMessage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
          DynamicMessage.Builder builder = DynamicMessage.newBuilder(DynamicMessage.this.type);
          try {
            builder.mergeFrom(param1CodedInputStream, param1ExtensionRegistryLite);
            return builder.buildPartial();
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            throw invalidProtocolBufferException.setUnfinishedMessage(builder.buildPartial());
          } catch (IOException iOException) {
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(builder.buildPartial());
          } 
        }
      };
  }
  
  public Object getRepeatedField(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    verifyContainingType(paramFieldDescriptor);
    return this.fields.getRepeatedField(paramFieldDescriptor, paramInt);
  }
  
  public int getRepeatedFieldCount(Descriptors.FieldDescriptor paramFieldDescriptor) {
    verifyContainingType(paramFieldDescriptor);
    return this.fields.getRepeatedFieldCount(paramFieldDescriptor);
  }
  
  public int getSerializedSize() {
    int j;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    if (this.type.getOptions().getMessageSetWireFormat()) {
      i = this.fields.getMessageSetSerializedSize();
      j = this.unknownFields.getSerializedSizeAsMessageSet();
    } else {
      i = this.fields.getSerializedSize();
      j = this.unknownFields.getSerializedSize();
    } 
    i += j;
    this.memoizedSize = i;
    return i;
  }
  
  public UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasField(Descriptors.FieldDescriptor paramFieldDescriptor) {
    verifyContainingType(paramFieldDescriptor);
    return this.fields.hasField(paramFieldDescriptor);
  }
  
  public boolean hasOneof(Descriptors.OneofDescriptor paramOneofDescriptor) {
    verifyOneofContainingType(paramOneofDescriptor);
    return !(this.oneofCases[paramOneofDescriptor.getIndex()] == null);
  }
  
  public boolean isInitialized() {
    return isInitialized(this.type, this.fields);
  }
  
  public Builder newBuilderForType() {
    return new Builder(this.type);
  }
  
  public Builder toBuilder() {
    return newBuilderForType().mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.type.getOptions().getMessageSetWireFormat()) {
      this.fields.writeMessageSetTo(paramCodedOutputStream);
      this.unknownFields.writeAsMessageSetTo(paramCodedOutputStream);
      return;
    } 
    this.fields.writeTo(paramCodedOutputStream);
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends AbstractMessage.Builder<Builder> {
    private FieldSet<Descriptors.FieldDescriptor> fields;
    
    private final Descriptors.FieldDescriptor[] oneofCases;
    
    private final Descriptors.Descriptor type;
    
    private UnknownFieldSet unknownFields;
    
    private Builder(Descriptors.Descriptor param1Descriptor) {
      this.type = param1Descriptor;
      this.fields = FieldSet.newFieldSet();
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      this.oneofCases = new Descriptors.FieldDescriptor[param1Descriptor.toProto().getOneofDeclCount()];
      if (param1Descriptor.getOptions().getMapEntry())
        populateMapEntry(); 
    }
    
    private DynamicMessage buildParsed() throws InvalidProtocolBufferException {
      if (isInitialized())
        return buildPartial(); 
      Descriptors.Descriptor descriptor = this.type;
      FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
      throw newUninitializedMessageException(new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[])Arrays.copyOf(arrayOfFieldDescriptor, arrayOfFieldDescriptor.length), this.unknownFields)).asInvalidProtocolBufferException();
    }
    
    private void ensureEnumValueDescriptor(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      if (param1FieldDescriptor.isRepeated()) {
        param1Object = ((List)param1Object).iterator();
        while (param1Object.hasNext())
          ensureSingularEnumValueDescriptor(param1FieldDescriptor, param1Object.next()); 
      } else {
        ensureSingularEnumValueDescriptor(param1FieldDescriptor, param1Object);
      } 
    }
    
    private void ensureIsMutable() {
      if (this.fields.isImmutable())
        this.fields = this.fields.clone(); 
    }
    
    private void ensureSingularEnumValueDescriptor(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      Internal.checkNotNull(param1Object);
      if (param1Object instanceof Descriptors.EnumValueDescriptor)
        return; 
      throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
    }
    
    private void populateMapEntry() {
      for (Descriptors.FieldDescriptor fieldDescriptor : this.type.getFields()) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          this.fields.setField(fieldDescriptor, DynamicMessage.getDefaultInstance(fieldDescriptor.getMessageType()));
          continue;
        } 
        this.fields.setField(fieldDescriptor, fieldDescriptor.getDefaultValue());
      } 
    }
    
    private void verifyContainingType(Descriptors.FieldDescriptor param1FieldDescriptor) {
      if (param1FieldDescriptor.getContainingType() == this.type)
        return; 
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }
    
    private void verifyOneofContainingType(Descriptors.OneofDescriptor param1OneofDescriptor) {
      if (param1OneofDescriptor.getContainingType() == this.type)
        return; 
      throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      verifyContainingType(param1FieldDescriptor);
      ensureIsMutable();
      this.fields.addRepeatedField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public DynamicMessage build() {
      if (isInitialized())
        return buildPartial(); 
      Descriptors.Descriptor descriptor = this.type;
      FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
      throw newUninitializedMessageException(new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[])Arrays.copyOf(arrayOfFieldDescriptor, arrayOfFieldDescriptor.length), this.unknownFields));
    }
    
    public DynamicMessage buildPartial() {
      this.fields.makeImmutable();
      Descriptors.Descriptor descriptor = this.type;
      FieldSet<Descriptors.FieldDescriptor> fieldSet = this.fields;
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
      return new DynamicMessage(descriptor, fieldSet, Arrays.<Descriptors.FieldDescriptor>copyOf(arrayOfFieldDescriptor, arrayOfFieldDescriptor.length), this.unknownFields);
    }
    
    public Builder clear() {
      if (this.fields.isImmutable()) {
        this.fields = FieldSet.newFieldSet();
      } else {
        this.fields.clear();
      } 
      if (this.type.getOptions().getMapEntry())
        populateMapEntry(); 
      this.unknownFields = UnknownFieldSet.getDefaultInstance();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      verifyContainingType(param1FieldDescriptor);
      ensureIsMutable();
      Descriptors.OneofDescriptor oneofDescriptor = param1FieldDescriptor.getContainingOneof();
      if (oneofDescriptor != null) {
        int i = oneofDescriptor.getIndex();
        Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
        if (arrayOfFieldDescriptor[i] == param1FieldDescriptor)
          arrayOfFieldDescriptor[i] = null; 
      } 
      this.fields.clearField(param1FieldDescriptor);
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      verifyOneofContainingType(param1OneofDescriptor);
      Descriptors.FieldDescriptor fieldDescriptor = this.oneofCases[param1OneofDescriptor.getIndex()];
      if (fieldDescriptor != null)
        clearField(fieldDescriptor); 
      return this;
    }
    
    public Builder clone() {
      Builder builder = new Builder(this.type);
      builder.fields.mergeFrom(this.fields);
      builder.mergeUnknownFields(this.unknownFields);
      Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
      System.arraycopy(arrayOfFieldDescriptor, 0, builder.oneofCases, 0, arrayOfFieldDescriptor.length);
      return builder;
    }
    
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
      return this.fields.getAllFields();
    }
    
    public DynamicMessage getDefaultInstanceForType() {
      return DynamicMessage.getDefaultInstance(this.type);
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return this.type;
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      verifyContainingType(param1FieldDescriptor);
      Object object2 = this.fields.getField(param1FieldDescriptor);
      Object object1 = object2;
      if (object2 == null) {
        if (param1FieldDescriptor.isRepeated())
          return Collections.emptyList(); 
        if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
          return DynamicMessage.getDefaultInstance(param1FieldDescriptor.getMessageType()); 
        object1 = param1FieldDescriptor.getDefaultValue();
      } 
      return object1;
    }
    
    public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor) {
      throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }
    
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor) {
      verifyOneofContainingType(param1OneofDescriptor);
      return this.oneofCases[param1OneofDescriptor.getIndex()];
    }
    
    public Object getRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      verifyContainingType(param1FieldDescriptor);
      return this.fields.getRepeatedField(param1FieldDescriptor, param1Int);
    }
    
    public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int) {
      throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a dynamic message type.");
    }
    
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor param1FieldDescriptor) {
      verifyContainingType(param1FieldDescriptor);
      return this.fields.getRepeatedFieldCount(param1FieldDescriptor);
    }
    
    public UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      verifyContainingType(param1FieldDescriptor);
      return this.fields.hasField(param1FieldDescriptor);
    }
    
    public boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      verifyOneofContainingType(param1OneofDescriptor);
      return !(this.oneofCases[param1OneofDescriptor.getIndex()] == null);
    }
    
    public boolean isInitialized() {
      return DynamicMessage.isInitialized(this.type, this.fields);
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof DynamicMessage) {
        param1Message = param1Message;
        if (((DynamicMessage)param1Message).type == this.type) {
          ensureIsMutable();
          this.fields.mergeFrom(((DynamicMessage)param1Message).fields);
          mergeUnknownFields(((DynamicMessage)param1Message).unknownFields);
          int i = 0;
          while (true) {
            Descriptors.FieldDescriptor[] arrayOfFieldDescriptor = this.oneofCases;
            if (i < arrayOfFieldDescriptor.length) {
              if (arrayOfFieldDescriptor[i] == null) {
                arrayOfFieldDescriptor[i] = ((DynamicMessage)param1Message).oneofCases[i];
              } else if (((DynamicMessage)param1Message).oneofCases[i] != null && this.oneofCases[i] != ((DynamicMessage)param1Message).oneofCases[i]) {
                this.fields.clearField(this.oneofCases[i]);
                this.oneofCases[i] = ((DynamicMessage)param1Message).oneofCases[i];
              } 
              i++;
              continue;
            } 
            return this;
          } 
        } 
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      } 
      return super.mergeFrom(param1Message);
    }
    
    public Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(param1UnknownFieldSet).build();
      return this;
    }
    
    public Builder newBuilderForField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      verifyContainingType(param1FieldDescriptor);
      if (param1FieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE)
        return new Builder(param1FieldDescriptor.getMessageType()); 
      throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      verifyContainingType(param1FieldDescriptor);
      ensureIsMutable();
      if (param1FieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.ENUM)
        ensureEnumValueDescriptor(param1FieldDescriptor, param1Object); 
      Descriptors.OneofDescriptor oneofDescriptor = param1FieldDescriptor.getContainingOneof();
      if (oneofDescriptor != null) {
        int i = oneofDescriptor.getIndex();
        Descriptors.FieldDescriptor fieldDescriptor = this.oneofCases[i];
        if (fieldDescriptor != null && fieldDescriptor != param1FieldDescriptor)
          this.fields.clearField(fieldDescriptor); 
        this.oneofCases[i] = param1FieldDescriptor;
      } else if (param1FieldDescriptor.getFile().getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO3 && !param1FieldDescriptor.isRepeated() && param1FieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE && param1Object.equals(param1FieldDescriptor.getDefaultValue())) {
        this.fields.clearField(param1FieldDescriptor);
        return this;
      } 
      this.fields.setField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      verifyContainingType(param1FieldDescriptor);
      ensureIsMutable();
      this.fields.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
      return this;
    }
    
    public Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      this.unknownFields = param1UnknownFieldSet;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\DynamicMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */