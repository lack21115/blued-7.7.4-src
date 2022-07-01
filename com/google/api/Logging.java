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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Logging extends GeneratedMessageV3 implements LoggingOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
  
  private static final Logging DEFAULT_INSTANCE = new Logging();
  
  private static final Parser<Logging> PARSER = (Parser<Logging>)new AbstractParser<Logging>() {
      public Logging a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Logging(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private List<LoggingDestination> consumerDestinations_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<LoggingDestination> producerDestinations_;
  
  private Logging() {
    this.producerDestinations_ = Collections.emptyList();
    this.consumerDestinations_ = Collections.emptyList();
  }
  
  private Logging(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      boolean bool = false;
      int i = 0;
      while (!bool) {
        int j = i;
        int k = i;
        int m = i;
        try {
          int n = paramCodedInputStream.readTag();
          if (n != 0) {
            if (n != 10) {
              if (n != 18) {
                j = i;
                k = i;
                m = i;
                if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                  continue; 
                continue;
              } 
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.consumerDestinations_ = new ArrayList<LoggingDestination>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.consumerDestinations_.add(paramCodedInputStream.readMessage(LoggingDestination.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.producerDestinations_ = new ArrayList<LoggingDestination>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.producerDestinations_.add(paramCodedInputStream.readMessage(LoggingDestination.parser(), paramExtensionRegistryLite));
            i = n;
            continue;
          } 
          continue;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          j = m;
          throw invalidProtocolBufferException.setUnfinishedMessage(this);
        } catch (IOException iOException) {
          j = k;
          throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
        } finally {}
        if ((j & 0x1) != 0)
          this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_); 
        if ((j & 0x2) != 0)
          this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_); 
      if ((i & 0x2) != 0)
        this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Logging(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Logging getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return LoggingProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Logging paramLogging) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramLogging);
  }
  
  public static Logging parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Logging)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Logging parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramByteString);
  }
  
  public static Logging parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Logging)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Logging parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(InputStream paramInputStream) throws IOException {
    return (Logging)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Logging parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Logging)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Logging parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Logging parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Logging parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Logging)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Logging> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Logging))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getProducerDestinationsList().equals(paramObject.getProducerDestinationsList()) ? false : (!getConsumerDestinationsList().equals(paramObject.getConsumerDestinationsList()) ? false : (!!this.unknownFields.equals(((Logging)paramObject).unknownFields)));
  }
  
  public LoggingDestination getConsumerDestinations(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<LoggingDestination> getConsumerDestinationsList() {
    return this.consumerDestinations_;
  }
  
  public LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public Logging getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Logging> getParserForType() {
    return PARSER;
  }
  
  public LoggingDestination getProducerDestinations(int paramInt) {
    return this.producerDestinations_.get(paramInt);
  }
  
  public int getProducerDestinationsCount() {
    return this.producerDestinations_.size();
  }
  
  public List<LoggingDestination> getProducerDestinationsList() {
    return this.producerDestinations_;
  }
  
  public LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt) {
    return this.producerDestinations_.get(paramInt);
  }
  
  public List<? extends LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
    return (List)this.producerDestinations_;
  }
  
  public int getSerializedSize() {
    int k;
    int m;
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    int j = 0;
    i = 0;
    while (true) {
      k = b;
      m = i;
      if (j < this.producerDestinations_.size()) {
        i += CodedOutputStream.computeMessageSize(1, (MessageLite)this.producerDestinations_.get(j));
        j++;
        continue;
      } 
      break;
    } 
    while (k < this.consumerDestinations_.size()) {
      m += CodedOutputStream.computeMessageSize(2, (MessageLite)this.consumerDestinations_.get(k));
      k++;
    } 
    i = m + this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getProducerDestinationsCount() > 0)
      i = (j * 37 + 1) * 53 + getProducerDestinationsList().hashCode(); 
    j = i;
    if (getConsumerDestinationsCount() > 0)
      j = (i * 37 + 2) * 53 + getConsumerDestinationsList().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return LoggingProto.b.ensureFieldAccessorsInitialized(Logging.class, Builder.class);
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
    int j;
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.producerDestinations_.size()) {
        paramCodedOutputStream.writeMessage(1, (MessageLite)this.producerDestinations_.get(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.consumerDestinations_.size()) {
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.consumerDestinations_.get(j));
      j++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoggingOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> consumerDestinationsBuilder_;
    
    private List<Logging.LoggingDestination> consumerDestinations_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> producerDestinationsBuilder_;
    
    private List<Logging.LoggingDestination> producerDestinations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureConsumerDestinationsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.consumerDestinations_ = new ArrayList<Logging.LoggingDestination>(this.consumerDestinations_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureProducerDestinationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.producerDestinations_ = new ArrayList<Logging.LoggingDestination>(this.producerDestinations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> getConsumerDestinationsFieldBuilder() {
      if (this.consumerDestinationsBuilder_ == null) {
        boolean bool;
        List<Logging.LoggingDestination> list = this.consumerDestinations_;
        if ((this.bitField0_ & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.consumerDestinationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.consumerDestinations_ = null;
      } 
      return this.consumerDestinationsBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LoggingProto.a;
    }
    
    private RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> getProducerDestinationsFieldBuilder() {
      if (this.producerDestinationsBuilder_ == null) {
        List<Logging.LoggingDestination> list = this.producerDestinations_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.producerDestinationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.producerDestinations_ = null;
      } 
      return this.producerDestinationsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Logging.alwaysUseFieldBuilders) {
        getProducerDestinationsFieldBuilder();
        getConsumerDestinationsFieldBuilder();
      } 
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Logging.LoggingDestination> param1Iterable) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.consumerDestinations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllProducerDestinations(Iterable<? extends Logging.LoggingDestination> param1Iterable) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.producerDestinations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1Int, param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Logging.LoggingDestination.Builder addConsumerDestinationsBuilder() {
      return (Logging.LoggingDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder((AbstractMessage)Logging.LoggingDestination.getDefaultInstance());
    }
    
    public Logging.LoggingDestination.Builder addConsumerDestinationsBuilder(int param1Int) {
      return (Logging.LoggingDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Logging.LoggingDestination.getDefaultInstance());
    }
    
    public Builder addProducerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.add(param1Int, param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Builder addProducerDestinations(Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProducerDestinations(Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.add(param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Logging.LoggingDestination.Builder addProducerDestinationsBuilder() {
      return (Logging.LoggingDestination.Builder)getProducerDestinationsFieldBuilder().addBuilder((AbstractMessage)Logging.LoggingDestination.getDefaultInstance());
    }
    
    public Logging.LoggingDestination.Builder addProducerDestinationsBuilder(int param1Int) {
      return (Logging.LoggingDestination.Builder)getProducerDestinationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Logging.LoggingDestination.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Logging build() {
      Logging logging = buildPartial();
      if (logging.isInitialized())
        return logging; 
      throw newUninitializedMessageException(logging);
    }
    
    public Logging buildPartial() {
      Logging logging = new Logging(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Logging.access$1602(logging, this.producerDestinations_);
      } else {
        Logging.access$1602(logging, repeatedFieldBuilderV3.build());
      } 
      repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Logging.access$1702(logging, this.consumerDestinations_);
      } else {
        Logging.access$1702(logging, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return logging;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.producerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
      } else {
        repeatedFieldBuilderV3.clear();
      } 
      repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.consumerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearConsumerDestinations() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.consumerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearProducerDestinations() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.producerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Logging.LoggingDestination getConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Logging.LoggingDestination)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Logging.LoggingDestination.Builder getConsumerDestinationsBuilder(int param1Int) {
      return (Logging.LoggingDestination.Builder)getConsumerDestinationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Logging.LoggingDestination.Builder> getConsumerDestinationsBuilderList() {
      return getConsumerDestinationsFieldBuilder().getBuilderList();
    }
    
    public int getConsumerDestinationsCount() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Logging.LoggingDestination> getConsumerDestinationsList() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.consumerDestinations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Logging.LoggingDestinationOrBuilder getConsumerDestinationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Logging.LoggingDestinationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Logging.LoggingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.consumerDestinations_);
    }
    
    public Logging getDefaultInstanceForType() {
      return Logging.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LoggingProto.a;
    }
    
    public Logging.LoggingDestination getProducerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.get(param1Int) : (Logging.LoggingDestination)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Logging.LoggingDestination.Builder getProducerDestinationsBuilder(int param1Int) {
      return (Logging.LoggingDestination.Builder)getProducerDestinationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Logging.LoggingDestination.Builder> getProducerDestinationsBuilderList() {
      return getProducerDestinationsFieldBuilder().getBuilderList();
    }
    
    public int getProducerDestinationsCount() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Logging.LoggingDestination> getProducerDestinationsList() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.producerDestinations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Logging.LoggingDestinationOrBuilder getProducerDestinationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.get(param1Int) : (Logging.LoggingDestinationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Logging.LoggingDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.producerDestinations_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LoggingProto.b.ensureFieldAccessorsInitialized(Logging.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Logging param1Logging) {
      if (param1Logging == Logging.getDefaultInstance())
        return this; 
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Logging.producerDestinations_.isEmpty()) {
          if (this.producerDestinations_.isEmpty()) {
            this.producerDestinations_ = param1Logging.producerDestinations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.addAll(param1Logging.producerDestinations_);
          } 
          onChanged();
        } 
      } else if (!param1Logging.producerDestinations_.isEmpty()) {
        if (this.producerDestinationsBuilder_.isEmpty()) {
          this.producerDestinationsBuilder_.dispose();
          this.producerDestinationsBuilder_ = null;
          this.producerDestinations_ = param1Logging.producerDestinations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Logging.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getProducerDestinationsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.producerDestinationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.producerDestinationsBuilder_.addAllMessages(param1Logging.producerDestinations_);
        } 
      } 
      if (this.consumerDestinationsBuilder_ == null) {
        if (!param1Logging.consumerDestinations_.isEmpty()) {
          if (this.consumerDestinations_.isEmpty()) {
            this.consumerDestinations_ = param1Logging.consumerDestinations_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.addAll(param1Logging.consumerDestinations_);
          } 
          onChanged();
        } 
      } else if (!param1Logging.consumerDestinations_.isEmpty()) {
        if (this.consumerDestinationsBuilder_.isEmpty()) {
          this.consumerDestinationsBuilder_.dispose();
          this.consumerDestinationsBuilder_ = null;
          this.consumerDestinations_ = param1Logging.consumerDestinations_;
          this.bitField0_ &= 0xFFFFFFFD;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Logging.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getConsumerDestinationsFieldBuilder(); 
          this.consumerDestinationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.consumerDestinationsBuilder_.addAllMessages(param1Logging.consumerDestinations_);
        } 
      } 
      mergeUnknownFields(param1Logging.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Logging logging = (Logging)Logging.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Logging logging = (Logging)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Logging)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Logging)
        return mergeFrom((Logging)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder removeProducerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.set(param1Int, param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProducerDestinations(int param1Int, Logging.LoggingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Logging.LoggingDestination param1LoggingDestination) {
      RepeatedFieldBuilderV3<Logging.LoggingDestination, Logging.LoggingDestination.Builder, Logging.LoggingDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1LoggingDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.set(param1Int, param1LoggingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1LoggingDestination);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class LoggingDestination extends GeneratedMessageV3 implements LoggingDestinationOrBuilder {
    private static final LoggingDestination DEFAULT_INSTANCE = new LoggingDestination();
    
    public static final int LOGS_FIELD_NUMBER = 1;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 3;
    
    private static final Parser<LoggingDestination> PARSER = (Parser<LoggingDestination>)new AbstractParser<LoggingDestination>() {
        public Logging.LoggingDestination a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Logging.LoggingDestination(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private LazyStringList logs_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object monitoredResource_;
    
    private LoggingDestination() {
      this.monitoredResource_ = "";
      this.logs_ = LazyStringArrayList.EMPTY;
    }
    
    private LoggingDestination(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        int i = 0;
        while (!bool) {
          int j = i;
          int k = i;
          int m = i;
          try {
            int n = param1CodedInputStream.readTag();
            if (n != 0) {
              if (n != 10) {
                if (n != 26) {
                  j = i;
                  k = i;
                  m = i;
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n))
                    continue; 
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.monitoredResource_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              String str = param1CodedInputStream.readStringRequireUtf8();
              n = i;
              if ((i & 0x2) == 0) {
                j = i;
                k = i;
                m = i;
                this.logs_ = (LazyStringList)new LazyStringArrayList();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.logs_.add(str);
              i = n;
              continue;
            } 
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            j = m;
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            j = k;
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          if ((j & 0x2) != 0)
            this.logs_ = this.logs_.getUnmodifiableView(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x2) != 0)
          this.logs_ = this.logs_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private LoggingDestination(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LoggingDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LoggingProto.c;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LoggingDestination param1LoggingDestination) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LoggingDestination);
    }
    
    public static LoggingDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LoggingDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ByteString);
    }
    
    public static LoggingDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LoggingDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LoggingDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LoggingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LoggingDestination parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LoggingDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LoggingDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LoggingDestination)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LoggingDestination> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LoggingDestination))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getMonitoredResource().equals(param1Object.getMonitoredResource()) ? false : (!getLogsList().equals(param1Object.getLogsList()) ? false : (!!this.unknownFields.equals(((LoggingDestination)param1Object).unknownFields)));
    }
    
    public LoggingDestination getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getLogs(int param1Int) {
      return (String)this.logs_.get(param1Int);
    }
    
    public ByteString getLogsBytes(int param1Int) {
      return this.logs_.getByteString(param1Int);
    }
    
    public int getLogsCount() {
      return this.logs_.size();
    }
    
    public ProtocolStringList getLogsList() {
      return (ProtocolStringList)this.logs_;
    }
    
    public String getMonitoredResource() {
      Object object = this.monitoredResource_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.monitoredResource_ = object;
      return (String)object;
    }
    
    public ByteString getMonitoredResourceBytes() {
      Object object = this.monitoredResource_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.monitoredResource_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<LoggingDestination> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = 0;
      while (i < this.logs_.size()) {
        j += computeStringSizeNoTag(this.logs_.getRaw(i));
        i++;
      } 
      j = 0 + j + getLogsList().size() * 1;
      i = j;
      if (!getMonitoredResourceBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(3, this.monitoredResource_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 3) * 53 + getMonitoredResource().hashCode();
      int i = j;
      if (getLogsCount() > 0)
        i = (j * 37 + 1) * 53 + getLogsList().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LoggingProto.d.ensureFieldAccessorsInitialized(LoggingDestination.class, Builder.class);
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
    
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      return new Builder(param1BuilderParent);
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      for (int i = 0; i < this.logs_.size(); i++)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.logs_.getRaw(i)); 
      if (!getMonitoredResourceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.monitoredResource_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Logging.LoggingDestinationOrBuilder {
      private int bitField0_;
      
      private LazyStringList logs_ = LazyStringArrayList.EMPTY;
      
      private Object monitoredResource_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureLogsIsMutable() {
        if ((this.bitField0_ & 0x2) == 0) {
          this.logs_ = (LazyStringList)new LazyStringArrayList(this.logs_);
          this.bitField0_ |= 0x2;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LoggingProto.c;
      }
      
      private void maybeForceBuilderInitialization() {
        Logging.LoggingDestination.alwaysUseFieldBuilders;
      }
      
      public Builder addAllLogs(Iterable<String> param2Iterable) {
        ensureLogsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.logs_);
        onChanged();
        return this;
      }
      
      public Builder addLogs(String param2String) {
        if (param2String != null) {
          ensureLogsIsMutable();
          this.logs_.add(param2String);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addLogsBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          Logging.LoggingDestination.checkByteStringIsUtf8(param2ByteString);
          ensureLogsIsMutable();
          this.logs_.add(param2ByteString);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Logging.LoggingDestination build() {
        Logging.LoggingDestination loggingDestination = buildPartial();
        if (loggingDestination.isInitialized())
          return loggingDestination; 
        throw newUninitializedMessageException(loggingDestination);
      }
      
      public Logging.LoggingDestination buildPartial() {
        Logging.LoggingDestination loggingDestination = new Logging.LoggingDestination(this);
        int i = this.bitField0_;
        Logging.LoggingDestination.access$402(loggingDestination, this.monitoredResource_);
        if ((this.bitField0_ & 0x2) != 0) {
          this.logs_ = this.logs_.getUnmodifiableView();
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Logging.LoggingDestination.access$502(loggingDestination, this.logs_);
        Logging.LoggingDestination.access$602(loggingDestination, 0);
        onBuilt();
        return loggingDestination;
      }
      
      public Builder clear() {
        super.clear();
        this.monitoredResource_ = "";
        this.logs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearLogs() {
        this.logs_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      }
      
      public Builder clearMonitoredResource() {
        this.monitoredResource_ = Logging.LoggingDestination.getDefaultInstance().getMonitoredResource();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Logging.LoggingDestination getDefaultInstanceForType() {
        return Logging.LoggingDestination.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LoggingProto.c;
      }
      
      public String getLogs(int param2Int) {
        return (String)this.logs_.get(param2Int);
      }
      
      public ByteString getLogsBytes(int param2Int) {
        return this.logs_.getByteString(param2Int);
      }
      
      public int getLogsCount() {
        return this.logs_.size();
      }
      
      public ProtocolStringList getLogsList() {
        return (ProtocolStringList)this.logs_.getUnmodifiableView();
      }
      
      public String getMonitoredResource() {
        Object object = this.monitoredResource_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.monitoredResource_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getMonitoredResourceBytes() {
        Object object = this.monitoredResource_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.monitoredResource_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LoggingProto.d.ensureFieldAccessorsInitialized(Logging.LoggingDestination.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Logging.LoggingDestination param2LoggingDestination) {
        if (param2LoggingDestination == Logging.LoggingDestination.getDefaultInstance())
          return this; 
        if (!param2LoggingDestination.getMonitoredResource().isEmpty()) {
          this.monitoredResource_ = param2LoggingDestination.monitoredResource_;
          onChanged();
        } 
        if (!param2LoggingDestination.logs_.isEmpty()) {
          if (this.logs_.isEmpty()) {
            this.logs_ = param2LoggingDestination.logs_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureLogsIsMutable();
            this.logs_.addAll((Collection)param2LoggingDestination.logs_);
          } 
          onChanged();
        } 
        mergeUnknownFields(param2LoggingDestination.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Logging.LoggingDestination loggingDestination = (Logging.LoggingDestination)Logging.LoggingDestination.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Logging.LoggingDestination loggingDestination = (Logging.LoggingDestination)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Logging.LoggingDestination)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Logging.LoggingDestination)
          return mergeFrom((Logging.LoggingDestination)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setLogs(int param2Int, String param2String) {
        if (param2String != null) {
          ensureLogsIsMutable();
          this.logs_.set(param2Int, param2String);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMonitoredResource(String param2String) {
        if (param2String != null) {
          this.monitoredResource_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMonitoredResourceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          Logging.LoggingDestination.checkByteStringIsUtf8(param2ByteString);
          this.monitoredResource_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<LoggingDestination> {
    public Logging.LoggingDestination a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Logging.LoggingDestination(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LoggingDestination.Builder> implements LoggingDestinationOrBuilder {
    private int bitField0_;
    
    private LazyStringList logs_ = LazyStringArrayList.EMPTY;
    
    private Object monitoredResource_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureLogsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.logs_ = (LazyStringList)new LazyStringArrayList(this.logs_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LoggingProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      Logging.LoggingDestination.alwaysUseFieldBuilders;
    }
    
    public Builder addAllLogs(Iterable<String> param1Iterable) {
      ensureLogsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.logs_);
      onChanged();
      return this;
    }
    
    public Builder addLogs(String param1String) {
      if (param1String != null) {
        ensureLogsIsMutable();
        this.logs_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addLogsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Logging.LoggingDestination.checkByteStringIsUtf8(param1ByteString);
        ensureLogsIsMutable();
        this.logs_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Logging.LoggingDestination build() {
      Logging.LoggingDestination loggingDestination = buildPartial();
      if (loggingDestination.isInitialized())
        return loggingDestination; 
      throw newUninitializedMessageException(loggingDestination);
    }
    
    public Logging.LoggingDestination buildPartial() {
      Logging.LoggingDestination loggingDestination = new Logging.LoggingDestination(this);
      int i = this.bitField0_;
      Logging.LoggingDestination.access$402(loggingDestination, this.monitoredResource_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.logs_ = this.logs_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      Logging.LoggingDestination.access$502(loggingDestination, this.logs_);
      Logging.LoggingDestination.access$602(loggingDestination, 0);
      onBuilt();
      return loggingDestination;
    }
    
    public Builder clear() {
      super.clear();
      this.monitoredResource_ = "";
      this.logs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLogs() {
      this.logs_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearMonitoredResource() {
      this.monitoredResource_ = Logging.LoggingDestination.getDefaultInstance().getMonitoredResource();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Logging.LoggingDestination getDefaultInstanceForType() {
      return Logging.LoggingDestination.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LoggingProto.c;
    }
    
    public String getLogs(int param1Int) {
      return (String)this.logs_.get(param1Int);
    }
    
    public ByteString getLogsBytes(int param1Int) {
      return this.logs_.getByteString(param1Int);
    }
    
    public int getLogsCount() {
      return this.logs_.size();
    }
    
    public ProtocolStringList getLogsList() {
      return (ProtocolStringList)this.logs_.getUnmodifiableView();
    }
    
    public String getMonitoredResource() {
      Object object = this.monitoredResource_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.monitoredResource_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMonitoredResourceBytes() {
      Object object = this.monitoredResource_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.monitoredResource_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LoggingProto.d.ensureFieldAccessorsInitialized(Logging.LoggingDestination.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Logging.LoggingDestination param1LoggingDestination) {
      if (param1LoggingDestination == Logging.LoggingDestination.getDefaultInstance())
        return this; 
      if (!param1LoggingDestination.getMonitoredResource().isEmpty()) {
        this.monitoredResource_ = param1LoggingDestination.monitoredResource_;
        onChanged();
      } 
      if (!param1LoggingDestination.logs_.isEmpty()) {
        if (this.logs_.isEmpty()) {
          this.logs_ = param1LoggingDestination.logs_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureLogsIsMutable();
          this.logs_.addAll((Collection)param1LoggingDestination.logs_);
        } 
        onChanged();
      } 
      mergeUnknownFields(param1LoggingDestination.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Logging.LoggingDestination loggingDestination = (Logging.LoggingDestination)Logging.LoggingDestination.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Logging.LoggingDestination loggingDestination = (Logging.LoggingDestination)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Logging.LoggingDestination)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Logging.LoggingDestination)
        return mergeFrom((Logging.LoggingDestination)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLogs(int param1Int, String param1String) {
      if (param1String != null) {
        ensureLogsIsMutable();
        this.logs_.set(param1Int, param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMonitoredResource(String param1String) {
      if (param1String != null) {
        this.monitoredResource_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMonitoredResourceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Logging.LoggingDestination.checkByteStringIsUtf8(param1ByteString);
        this.monitoredResource_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface LoggingDestinationOrBuilder extends MessageOrBuilder {
    String getLogs(int param1Int);
    
    ByteString getLogsBytes(int param1Int);
    
    int getLogsCount();
    
    List<String> getLogsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */