package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class DocumentationRule extends GeneratedMessageV3 implements DocumentationRuleOrBuilder {
  private static final DocumentationRule DEFAULT_INSTANCE = new DocumentationRule();
  
  public static final int DEPRECATION_DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  
  private static final Parser<DocumentationRule> PARSER = (Parser<DocumentationRule>)new AbstractParser<DocumentationRule>() {
      public DocumentationRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new DocumentationRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object deprecationDescription_;
  
  private volatile Object description_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object selector_;
  
  private DocumentationRule() {
    this.selector_ = "";
    this.description_ = "";
    this.deprecationDescription_ = "";
  }
  
  private DocumentationRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 26) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.deprecationDescription_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.description_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.selector_ = paramCodedInputStream.readStringRequireUtf8();
            continue;
          } 
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private DocumentationRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static DocumentationRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DocumentationProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DocumentationRule paramDocumentationRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDocumentationRule);
  }
  
  public static DocumentationRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static DocumentationRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramByteString);
  }
  
  public static DocumentationRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static DocumentationRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(InputStream paramInputStream) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static DocumentationRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static DocumentationRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static DocumentationRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentationRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DocumentationRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof DocumentationRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!getDeprecationDescription().equals(paramObject.getDeprecationDescription()) ? false : (!!this.unknownFields.equals(((DocumentationRule)paramObject).unknownFields))));
  }
  
  public DocumentationRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDeprecationDescription() {
    Object object = this.deprecationDescription_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.deprecationDescription_ = object;
    return (String)object;
  }
  
  public ByteString getDeprecationDescriptionBytes() {
    Object object = this.deprecationDescription_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.deprecationDescription_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getDescription() {
    Object object = this.description_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.description_ = object;
    return (String)object;
  }
  
  public ByteString getDescriptionBytes() {
    Object object = this.description_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.description_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<DocumentationRule> getParserForType() {
    return PARSER;
  }
  
  public String getSelector() {
    Object object = this.selector_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.selector_ = object;
    return (String)object;
  }
  
  public ByteString getSelectorBytes() {
    Object object = this.selector_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.selector_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getSelectorBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.selector_); 
    i = j;
    if (!getDescriptionBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.description_); 
    j = i;
    if (!getDeprecationDescriptionBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.deprecationDescription_); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode()) * 37 + 2) * 53 + getDescription().hashCode()) * 37 + 3) * 53 + getDeprecationDescription().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DocumentationProto.d.ensureFieldAccessorsInitialized(DocumentationRule.class, Builder.class);
  }
  
  public final boolean isInitialized() {
    byte b = this.memoizedIsInitialized;
    if (b == 1)
      return true; 
    if (b == 0)
      return false; 
    this.memoizedIsInitialized = 1;
    return true;
  }
  
  public Builder newBuilderForType() {
    return newBuilder();
  }
  
  protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent paramBuilderParent) {
    return new Builder(paramBuilderParent);
  }
  
  public Builder toBuilder() {
    return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!getSelectorBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.selector_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.description_); 
    if (!getDeprecationDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.deprecationDescription_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DocumentationRuleOrBuilder {
    private Object deprecationDescription_ = "";
    
    private Object description_ = "";
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DocumentationProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      DocumentationRule.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public DocumentationRule build() {
      DocumentationRule documentationRule = buildPartial();
      if (documentationRule.isInitialized())
        return documentationRule; 
      throw newUninitializedMessageException(documentationRule);
    }
    
    public DocumentationRule buildPartial() {
      DocumentationRule documentationRule = new DocumentationRule(this);
      DocumentationRule.access$402(documentationRule, this.selector_);
      DocumentationRule.access$502(documentationRule, this.description_);
      DocumentationRule.access$602(documentationRule, this.deprecationDescription_);
      onBuilt();
      return documentationRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      this.description_ = "";
      this.deprecationDescription_ = "";
      return this;
    }
    
    public Builder clearDeprecationDescription() {
      this.deprecationDescription_ = DocumentationRule.getDefaultInstance().getDeprecationDescription();
      onChanged();
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = DocumentationRule.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSelector() {
      this.selector_ = DocumentationRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public DocumentationRule getDefaultInstanceForType() {
      return DocumentationRule.getDefaultInstance();
    }
    
    public String getDeprecationDescription() {
      Object object = this.deprecationDescription_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.deprecationDescription_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDeprecationDescriptionBytes() {
      Object object = this.deprecationDescription_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.deprecationDescription_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DocumentationProto.c;
    }
    
    public String getSelector() {
      Object object = this.selector_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.selector_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSelectorBytes() {
      Object object = this.selector_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.selector_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DocumentationProto.d.ensureFieldAccessorsInitialized(DocumentationRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(DocumentationRule param1DocumentationRule) {
      if (param1DocumentationRule == DocumentationRule.getDefaultInstance())
        return this; 
      if (!param1DocumentationRule.getSelector().isEmpty()) {
        this.selector_ = param1DocumentationRule.selector_;
        onChanged();
      } 
      if (!param1DocumentationRule.getDescription().isEmpty()) {
        this.description_ = param1DocumentationRule.description_;
        onChanged();
      } 
      if (!param1DocumentationRule.getDeprecationDescription().isEmpty()) {
        this.deprecationDescription_ = param1DocumentationRule.deprecationDescription_;
        onChanged();
      } 
      mergeUnknownFields(param1DocumentationRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        DocumentationRule documentationRule = (DocumentationRule)DocumentationRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        DocumentationRule documentationRule = (DocumentationRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((DocumentationRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof DocumentationRule)
        return mergeFrom((DocumentationRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDeprecationDescription(String param1String) {
      if (param1String != null) {
        this.deprecationDescription_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDeprecationDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        DocumentationRule.checkByteStringIsUtf8(param1ByteString);
        this.deprecationDescription_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        DocumentationRule.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSelector(String param1String) {
      if (param1String != null) {
        this.selector_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        DocumentationRule.checkByteStringIsUtf8(param1ByteString);
        this.selector_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\DocumentationRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */