package com.google.type;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Money extends GeneratedMessageV3 implements MoneyOrBuilder {
  public static final int CURRENCY_CODE_FIELD_NUMBER = 1;
  
  private static final Money DEFAULT_INSTANCE = new Money();
  
  public static final int NANOS_FIELD_NUMBER = 3;
  
  private static final Parser<Money> PARSER = (Parser<Money>)new AbstractParser<Money>() {
      public Money a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Money(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int UNITS_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object currencyCode_;
  
  private byte memoizedIsInitialized = -1;
  
  private int nanos_;
  
  private long units_;
  
  private Money() {
    this.currencyCode_ = "";
  }
  
  private Money(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 16) {
                if (i != 24) {
                  if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.nanos_ = paramCodedInputStream.readInt32();
                continue;
              } 
              this.units_ = paramCodedInputStream.readInt64();
              continue;
            } 
            this.currencyCode_ = paramCodedInputStream.readStringRequireUtf8();
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
  
  private Money(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Money getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MoneyProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Money paramMoney) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMoney);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Money)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Money parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramByteString);
  }
  
  public static Money parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Money)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Money parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(InputStream paramInputStream) throws IOException {
    return (Money)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Money parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Money)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Money parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Money parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Money)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Money> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Money))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getCurrencyCode().equals(paramObject.getCurrencyCode()) ? false : ((getUnits() != paramObject.getUnits()) ? false : ((getNanos() != paramObject.getNanos()) ? false : (!!this.unknownFields.equals(((Money)paramObject).unknownFields))));
  }
  
  public String getCurrencyCode() {
    Object object = this.currencyCode_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.currencyCode_ = object;
    return (String)object;
  }
  
  public ByteString getCurrencyCodeBytes() {
    Object object = this.currencyCode_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.currencyCode_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Money getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public int getNanos() {
    return this.nanos_;
  }
  
  public Parser<Money> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getCurrencyCodeBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.currencyCode_); 
    long l = this.units_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(2, l); 
    int k = this.nanos_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    i = j + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public long getUnits() {
    return this.units_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getCurrencyCode().hashCode()) * 37 + 2) * 53 + Internal.hashLong(getUnits())) * 37 + 3) * 53 + getNanos()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return MoneyProto.b.ensureFieldAccessorsInitialized(Money.class, Builder.class);
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
    if (!getCurrencyCodeBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.currencyCode_); 
    long l = this.units_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(2, l); 
    int i = this.nanos_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MoneyOrBuilder {
    private Object currencyCode_ = "";
    
    private int nanos_;
    
    private long units_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MoneyProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Money.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Money build() {
      Money money = buildPartial();
      if (money.isInitialized())
        return money; 
      throw newUninitializedMessageException(money);
    }
    
    public Money buildPartial() {
      Money money = new Money(this);
      Money.access$402(money, this.currencyCode_);
      Money.access$502(money, this.units_);
      Money.access$602(money, this.nanos_);
      onBuilt();
      return money;
    }
    
    public Builder clear() {
      super.clear();
      this.currencyCode_ = "";
      this.units_ = 0L;
      this.nanos_ = 0;
      return this;
    }
    
    public Builder clearCurrencyCode() {
      this.currencyCode_ = Money.getDefaultInstance().getCurrencyCode();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNanos() {
      this.nanos_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearUnits() {
      this.units_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getCurrencyCode() {
      Object object = this.currencyCode_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.currencyCode_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getCurrencyCodeBytes() {
      Object object = this.currencyCode_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.currencyCode_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Money getDefaultInstanceForType() {
      return Money.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MoneyProto.a;
    }
    
    public int getNanos() {
      return this.nanos_;
    }
    
    public long getUnits() {
      return this.units_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MoneyProto.b.ensureFieldAccessorsInitialized(Money.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Money money = (Money)Money.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Money money = (Money)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Money)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Money)
        return mergeFrom((Money)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Money param1Money) {
      if (param1Money == Money.getDefaultInstance())
        return this; 
      if (!param1Money.getCurrencyCode().isEmpty()) {
        this.currencyCode_ = param1Money.currencyCode_;
        onChanged();
      } 
      if (param1Money.getUnits() != 0L)
        setUnits(param1Money.getUnits()); 
      if (param1Money.getNanos() != 0)
        setNanos(param1Money.getNanos()); 
      mergeUnknownFields(param1Money.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCurrencyCode(String param1String) {
      if (param1String != null) {
        this.currencyCode_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCurrencyCodeBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Money.checkByteStringIsUtf8(param1ByteString);
        this.currencyCode_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNanos(int param1Int) {
      this.nanos_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setUnits(long param1Long) {
      this.units_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Money.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */