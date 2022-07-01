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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BackendRule extends GeneratedMessageV3 implements BackendRuleOrBuilder {
  public static final int ADDRESS_FIELD_NUMBER = 2;
  
  public static final int DEADLINE_FIELD_NUMBER = 3;
  
  private static final BackendRule DEFAULT_INSTANCE = new BackendRule();
  
  public static final int JWT_AUDIENCE_FIELD_NUMBER = 7;
  
  public static final int MIN_DEADLINE_FIELD_NUMBER = 4;
  
  public static final int OPERATION_DEADLINE_FIELD_NUMBER = 5;
  
  private static final Parser<BackendRule> PARSER = (Parser<BackendRule>)new AbstractParser<BackendRule>() {
      public BackendRule a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new BackendRule(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PATH_TRANSLATION_FIELD_NUMBER = 6;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object address_;
  
  private int authenticationCase_ = 0;
  
  private Object authentication_;
  
  private double deadline_;
  
  private byte memoizedIsInitialized = -1;
  
  private double minDeadline_;
  
  private double operationDeadline_;
  
  private int pathTranslation_;
  
  private volatile Object selector_;
  
  private BackendRule() {
    this.selector_ = "";
    this.address_ = "";
    this.pathTranslation_ = 0;
  }
  
  private BackendRule(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 25) {
                  if (i != 33) {
                    if (i != 41) {
                      if (i != 48) {
                        if (i != 58) {
                          if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                            continue; 
                          continue;
                        } 
                        String str = paramCodedInputStream.readStringRequireUtf8();
                        this.authenticationCase_ = 7;
                        this.authentication_ = str;
                        continue;
                      } 
                      this.pathTranslation_ = paramCodedInputStream.readEnum();
                      continue;
                    } 
                    this.operationDeadline_ = paramCodedInputStream.readDouble();
                    continue;
                  } 
                  this.minDeadline_ = paramCodedInputStream.readDouble();
                  continue;
                } 
                this.deadline_ = paramCodedInputStream.readDouble();
                continue;
              } 
              this.address_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private BackendRule(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static BackendRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return BackendProto.c;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BackendRule paramBackendRule) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBackendRule);
  }
  
  public static BackendRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static BackendRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramByteString);
  }
  
  public static BackendRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static BackendRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(InputStream paramInputStream) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static BackendRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static BackendRule parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static BackendRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BackendRule)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BackendRule> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof BackendRule))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getSelector().equals(paramObject.getSelector()) ? false : (!getAddress().equals(paramObject.getAddress()) ? false : ((Double.doubleToLongBits(getDeadline()) != Double.doubleToLongBits(paramObject.getDeadline())) ? false : ((Double.doubleToLongBits(getMinDeadline()) != Double.doubleToLongBits(paramObject.getMinDeadline())) ? false : ((Double.doubleToLongBits(getOperationDeadline()) != Double.doubleToLongBits(paramObject.getOperationDeadline())) ? false : ((this.pathTranslation_ != ((BackendRule)paramObject).pathTranslation_) ? false : (!getAuthenticationCase().equals(paramObject.getAuthenticationCase()) ? false : ((this.authenticationCase_ == 7 && !getJwtAudience().equals(paramObject.getJwtAudience())) ? false : (!!this.unknownFields.equals(((BackendRule)paramObject).unknownFields)))))))));
  }
  
  public String getAddress() {
    Object object = this.address_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.address_ = object;
    return (String)object;
  }
  
  public ByteString getAddressBytes() {
    Object object = this.address_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.address_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public AuthenticationCase getAuthenticationCase() {
    return AuthenticationCase.forNumber(this.authenticationCase_);
  }
  
  public double getDeadline() {
    return this.deadline_;
  }
  
  public BackendRule getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getJwtAudience() {
    if (this.authenticationCase_ == 7) {
      object = this.authentication_;
    } else {
      object = "";
    } 
    if (object instanceof String)
      return (String)object; 
    Object object = ((ByteString)object).toStringUtf8();
    if (this.authenticationCase_ == 7)
      this.authentication_ = object; 
    return (String)object;
  }
  
  public ByteString getJwtAudienceBytes() {
    Object object;
    if (this.authenticationCase_ == 7) {
      object = this.authentication_;
    } else {
      object = "";
    } 
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      if (this.authenticationCase_ == 7)
        this.authentication_ = object; 
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public double getMinDeadline() {
    return this.minDeadline_;
  }
  
  public double getOperationDeadline() {
    return this.operationDeadline_;
  }
  
  public Parser<BackendRule> getParserForType() {
    return PARSER;
  }
  
  public PathTranslation getPathTranslation() {
    PathTranslation pathTranslation2 = PathTranslation.valueOf(this.pathTranslation_);
    PathTranslation pathTranslation1 = pathTranslation2;
    if (pathTranslation2 == null)
      pathTranslation1 = PathTranslation.UNRECOGNIZED; 
    return pathTranslation1;
  }
  
  public int getPathTranslationValue() {
    return this.pathTranslation_;
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
    if (!getAddressBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.address_); 
    double d = this.deadline_;
    j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(3, d); 
    d = this.minDeadline_;
    i = j;
    if (d != 0.0D)
      i = j + CodedOutputStream.computeDoubleSize(4, d); 
    d = this.operationDeadline_;
    j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(5, d); 
    i = j;
    if (this.pathTranslation_ != PathTranslation.PATH_TRANSLATION_UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(6, this.pathTranslation_); 
    j = i;
    if (this.authenticationCase_ == 7)
      j = i + GeneratedMessageV3.computeStringSize(7, this.authentication_); 
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
    int i = ((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getSelector().hashCode()) * 37 + 2) * 53 + getAddress().hashCode()) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getDeadline()))) * 37 + 4) * 53 + Internal.hashLong(Double.doubleToLongBits(getMinDeadline()))) * 37 + 5) * 53 + Internal.hashLong(Double.doubleToLongBits(getOperationDeadline()))) * 37 + 6) * 53 + this.pathTranslation_;
    if (this.authenticationCase_ == 7)
      i = (i * 37 + 7) * 53 + getJwtAudience().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return BackendProto.d.ensureFieldAccessorsInitialized(BackendRule.class, Builder.class);
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
    if (!getAddressBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.address_); 
    double d = this.deadline_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(3, d); 
    d = this.minDeadline_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(4, d); 
    d = this.operationDeadline_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(5, d); 
    if (this.pathTranslation_ != PathTranslation.PATH_TRANSLATION_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(6, this.pathTranslation_); 
    if (this.authenticationCase_ == 7)
      GeneratedMessageV3.writeString(paramCodedOutputStream, 7, this.authentication_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public enum AuthenticationCase implements Internal.EnumLite {
    AUTHENTICATION_NOT_SET,
    JWT_AUDIENCE(7);
    
    private final int value;
    
    static {
      $VALUES = new AuthenticationCase[] { JWT_AUDIENCE, AUTHENTICATION_NOT_SET };
    }
    
    AuthenticationCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static AuthenticationCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 7) ? null : JWT_AUDIENCE) : AUTHENTICATION_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BackendRuleOrBuilder {
    private Object address_ = "";
    
    private int authenticationCase_ = 0;
    
    private Object authentication_;
    
    private double deadline_;
    
    private double minDeadline_;
    
    private double operationDeadline_;
    
    private int pathTranslation_ = 0;
    
    private Object selector_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return BackendProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      BackendRule.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public BackendRule build() {
      BackendRule backendRule = buildPartial();
      if (backendRule.isInitialized())
        return backendRule; 
      throw newUninitializedMessageException(backendRule);
    }
    
    public BackendRule buildPartial() {
      BackendRule backendRule = new BackendRule(this);
      BackendRule.access$402(backendRule, this.selector_);
      BackendRule.access$502(backendRule, this.address_);
      BackendRule.access$602(backendRule, this.deadline_);
      BackendRule.access$702(backendRule, this.minDeadline_);
      BackendRule.access$802(backendRule, this.operationDeadline_);
      BackendRule.access$902(backendRule, this.pathTranslation_);
      if (this.authenticationCase_ == 7)
        BackendRule.access$1002(backendRule, this.authentication_); 
      BackendRule.access$1102(backendRule, this.authenticationCase_);
      onBuilt();
      return backendRule;
    }
    
    public Builder clear() {
      super.clear();
      this.selector_ = "";
      this.address_ = "";
      this.deadline_ = 0.0D;
      this.minDeadline_ = 0.0D;
      this.operationDeadline_ = 0.0D;
      this.pathTranslation_ = 0;
      this.authenticationCase_ = 0;
      this.authentication_ = null;
      return this;
    }
    
    public Builder clearAddress() {
      this.address_ = BackendRule.getDefaultInstance().getAddress();
      onChanged();
      return this;
    }
    
    public Builder clearAuthentication() {
      this.authenticationCase_ = 0;
      this.authentication_ = null;
      onChanged();
      return this;
    }
    
    public Builder clearDeadline() {
      this.deadline_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearJwtAudience() {
      if (this.authenticationCase_ == 7) {
        this.authenticationCase_ = 0;
        this.authentication_ = null;
        onChanged();
      } 
      return this;
    }
    
    public Builder clearMinDeadline() {
      this.minDeadline_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOperationDeadline() {
      this.operationDeadline_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearPathTranslation() {
      this.pathTranslation_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSelector() {
      this.selector_ = BackendRule.getDefaultInstance().getSelector();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAddress() {
      Object object = this.address_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.address_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAddressBytes() {
      Object object = this.address_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.address_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public BackendRule.AuthenticationCase getAuthenticationCase() {
      return BackendRule.AuthenticationCase.forNumber(this.authenticationCase_);
    }
    
    public double getDeadline() {
      return this.deadline_;
    }
    
    public BackendRule getDefaultInstanceForType() {
      return BackendRule.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return BackendProto.c;
    }
    
    public String getJwtAudience() {
      Object object;
      if (this.authenticationCase_ == 7) {
        object = this.authentication_;
      } else {
        object = "";
      } 
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        if (this.authenticationCase_ == 7)
          this.authentication_ = object; 
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getJwtAudienceBytes() {
      Object object;
      if (this.authenticationCase_ == 7) {
        object = this.authentication_;
      } else {
        object = "";
      } 
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        if (this.authenticationCase_ == 7)
          this.authentication_ = object; 
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public double getMinDeadline() {
      return this.minDeadline_;
    }
    
    public double getOperationDeadline() {
      return this.operationDeadline_;
    }
    
    public BackendRule.PathTranslation getPathTranslation() {
      BackendRule.PathTranslation pathTranslation2 = BackendRule.PathTranslation.valueOf(this.pathTranslation_);
      BackendRule.PathTranslation pathTranslation1 = pathTranslation2;
      if (pathTranslation2 == null)
        pathTranslation1 = BackendRule.PathTranslation.UNRECOGNIZED; 
      return pathTranslation1;
    }
    
    public int getPathTranslationValue() {
      return this.pathTranslation_;
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
      return BackendProto.d.ensureFieldAccessorsInitialized(BackendRule.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(BackendRule param1BackendRule) {
      if (param1BackendRule == BackendRule.getDefaultInstance())
        return this; 
      if (!param1BackendRule.getSelector().isEmpty()) {
        this.selector_ = param1BackendRule.selector_;
        onChanged();
      } 
      if (!param1BackendRule.getAddress().isEmpty()) {
        this.address_ = param1BackendRule.address_;
        onChanged();
      } 
      if (param1BackendRule.getDeadline() != 0.0D)
        setDeadline(param1BackendRule.getDeadline()); 
      if (param1BackendRule.getMinDeadline() != 0.0D)
        setMinDeadline(param1BackendRule.getMinDeadline()); 
      if (param1BackendRule.getOperationDeadline() != 0.0D)
        setOperationDeadline(param1BackendRule.getOperationDeadline()); 
      if (param1BackendRule.pathTranslation_ != 0)
        setPathTranslationValue(param1BackendRule.getPathTranslationValue()); 
      if (BackendRule.null.a[param1BackendRule.getAuthenticationCase().ordinal()] == 1) {
        this.authenticationCase_ = 7;
        this.authentication_ = param1BackendRule.authentication_;
        onChanged();
      } 
      mergeUnknownFields(param1BackendRule.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        BackendRule backendRule = (BackendRule)BackendRule.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        BackendRule backendRule = (BackendRule)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((BackendRule)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof BackendRule)
        return mergeFrom((BackendRule)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAddress(String param1String) {
      if (param1String != null) {
        this.address_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAddressBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        BackendRule.checkByteStringIsUtf8(param1ByteString);
        this.address_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDeadline(double param1Double) {
      this.deadline_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setJwtAudience(String param1String) {
      if (param1String != null) {
        this.authenticationCase_ = 7;
        this.authentication_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setJwtAudienceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        BackendRule.checkByteStringIsUtf8(param1ByteString);
        this.authenticationCase_ = 7;
        this.authentication_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMinDeadline(double param1Double) {
      this.minDeadline_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setOperationDeadline(double param1Double) {
      this.operationDeadline_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setPathTranslation(BackendRule.PathTranslation param1PathTranslation) {
      if (param1PathTranslation != null) {
        this.pathTranslation_ = param1PathTranslation.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPathTranslationValue(int param1Int) {
      this.pathTranslation_ = param1Int;
      onChanged();
      return this;
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
        BackendRule.checkByteStringIsUtf8(param1ByteString);
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
  
  public enum PathTranslation implements ProtocolMessageEnum {
    APPEND_PATH_TO_ADDRESS(7),
    CONSTANT_ADDRESS(7),
    PATH_TRANSLATION_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int APPEND_PATH_TO_ADDRESS_VALUE = 2;
    
    public static final int CONSTANT_ADDRESS_VALUE = 1;
    
    public static final int PATH_TRANSLATION_UNSPECIFIED_VALUE = 0;
    
    private static final PathTranslation[] VALUES;
    
    private static final Internal.EnumLiteMap<PathTranslation> internalValueMap;
    
    private final int value;
    
    static {
      APPEND_PATH_TO_ADDRESS = new PathTranslation("APPEND_PATH_TO_ADDRESS", 2, 2);
      UNRECOGNIZED = new PathTranslation("UNRECOGNIZED", 3, -1);
      $VALUES = new PathTranslation[] { PATH_TRANSLATION_UNSPECIFIED, CONSTANT_ADDRESS, APPEND_PATH_TO_ADDRESS, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<PathTranslation>() {
          public BackendRule.PathTranslation a(int param2Int) {
            return BackendRule.PathTranslation.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    PathTranslation(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static PathTranslation forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? null : APPEND_PATH_TO_ADDRESS) : CONSTANT_ADDRESS) : PATH_TRANSLATION_UNSPECIFIED;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return BackendRule.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<PathTranslation> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public final int getNumber() {
      if (this != UNRECOGNIZED)
        return this.value; 
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
    
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
  }
  
  static final class null implements Internal.EnumLiteMap<PathTranslation> {
    public BackendRule.PathTranslation a(int param1Int) {
      return BackendRule.PathTranslation.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\BackendRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */