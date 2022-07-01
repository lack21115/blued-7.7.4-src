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

public final class Monitoring extends GeneratedMessageV3 implements MonitoringOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
  
  private static final Monitoring DEFAULT_INSTANCE = new Monitoring();
  
  private static final Parser<Monitoring> PARSER = (Parser<Monitoring>)new AbstractParser<Monitoring>() {
      public Monitoring a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Monitoring(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
  
  private static final long serialVersionUID = 0L;
  
  private List<MonitoringDestination> consumerDestinations_;
  
  private byte memoizedIsInitialized = -1;
  
  private List<MonitoringDestination> producerDestinations_;
  
  private Monitoring() {
    this.producerDestinations_ = Collections.emptyList();
    this.consumerDestinations_ = Collections.emptyList();
  }
  
  private Monitoring(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                this.consumerDestinations_ = new ArrayList<MonitoringDestination>();
                n = i | 0x2;
              } 
              j = n;
              k = n;
              m = n;
              this.consumerDestinations_.add(paramCodedInputStream.readMessage(MonitoringDestination.parser(), paramExtensionRegistryLite));
              i = n;
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.producerDestinations_ = new ArrayList<MonitoringDestination>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.producerDestinations_.add(paramCodedInputStream.readMessage(MonitoringDestination.parser(), paramExtensionRegistryLite));
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
  
  private Monitoring(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Monitoring getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return MonitoringProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Monitoring paramMonitoring) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMonitoring);
  }
  
  public static Monitoring parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Monitoring parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramByteString);
  }
  
  public static Monitoring parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Monitoring parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(InputStream paramInputStream) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Monitoring parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Monitoring)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Monitoring parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Monitoring parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Monitoring parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Monitoring)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Monitoring> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Monitoring))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getProducerDestinationsList().equals(paramObject.getProducerDestinationsList()) ? false : (!getConsumerDestinationsList().equals(paramObject.getConsumerDestinationsList()) ? false : (!!this.unknownFields.equals(((Monitoring)paramObject).unknownFields)));
  }
  
  public MonitoringDestination getConsumerDestinations(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<MonitoringDestination> getConsumerDestinationsList() {
    return this.consumerDestinations_;
  }
  
  public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public Monitoring getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Monitoring> getParserForType() {
    return PARSER;
  }
  
  public MonitoringDestination getProducerDestinations(int paramInt) {
    return this.producerDestinations_.get(paramInt);
  }
  
  public int getProducerDestinationsCount() {
    return this.producerDestinations_.size();
  }
  
  public List<MonitoringDestination> getProducerDestinationsList() {
    return this.producerDestinations_;
  }
  
  public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int paramInt) {
    return this.producerDestinations_.get(paramInt);
  }
  
  public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
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
    return MonitoringProto.b.ensureFieldAccessorsInitialized(Monitoring.class, Builder.class);
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
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoringOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> consumerDestinationsBuilder_;
    
    private List<Monitoring.MonitoringDestination> consumerDestinations_ = Collections.emptyList();
    
    private RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> producerDestinationsBuilder_;
    
    private List<Monitoring.MonitoringDestination> producerDestinations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureConsumerDestinationsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.consumerDestinations_ = new ArrayList<Monitoring.MonitoringDestination>(this.consumerDestinations_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    private void ensureProducerDestinationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.producerDestinations_ = new ArrayList<Monitoring.MonitoringDestination>(this.producerDestinations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> getConsumerDestinationsFieldBuilder() {
      if (this.consumerDestinationsBuilder_ == null) {
        boolean bool;
        List<Monitoring.MonitoringDestination> list = this.consumerDestinations_;
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
      return MonitoringProto.a;
    }
    
    private RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> getProducerDestinationsFieldBuilder() {
      if (this.producerDestinationsBuilder_ == null) {
        List<Monitoring.MonitoringDestination> list = this.producerDestinations_;
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
      if (Monitoring.alwaysUseFieldBuilders) {
        getProducerDestinationsFieldBuilder();
        getConsumerDestinationsFieldBuilder();
      } 
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Monitoring.MonitoringDestination> param1Iterable) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.consumerDestinations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAllProducerDestinations(Iterable<? extends Monitoring.MonitoringDestination> param1Iterable) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.producerDestinations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1Int, param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Monitoring.MonitoringDestination.Builder addConsumerDestinationsBuilder() {
      return (Monitoring.MonitoringDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder((AbstractMessage)Monitoring.MonitoringDestination.getDefaultInstance());
    }
    
    public Monitoring.MonitoringDestination.Builder addConsumerDestinationsBuilder(int param1Int) {
      return (Monitoring.MonitoringDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Monitoring.MonitoringDestination.getDefaultInstance());
    }
    
    public Builder addProducerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProducerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.add(param1Int, param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Builder addProducerDestinations(Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addProducerDestinations(Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.add(param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Monitoring.MonitoringDestination.Builder addProducerDestinationsBuilder() {
      return (Monitoring.MonitoringDestination.Builder)getProducerDestinationsFieldBuilder().addBuilder((AbstractMessage)Monitoring.MonitoringDestination.getDefaultInstance());
    }
    
    public Monitoring.MonitoringDestination.Builder addProducerDestinationsBuilder(int param1Int) {
      return (Monitoring.MonitoringDestination.Builder)getProducerDestinationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Monitoring.MonitoringDestination.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Monitoring build() {
      Monitoring monitoring = buildPartial();
      if (monitoring.isInitialized())
        return monitoring; 
      throw newUninitializedMessageException(monitoring);
    }
    
    public Monitoring buildPartial() {
      Monitoring monitoring = new Monitoring(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Monitoring.access$1602(monitoring, this.producerDestinations_);
      } else {
        Monitoring.access$1602(monitoring, repeatedFieldBuilderV3.build());
      } 
      repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x2) != 0) {
          this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_);
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Monitoring.access$1702(monitoring, this.consumerDestinations_);
      } else {
        Monitoring.access$1702(monitoring, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return monitoring;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
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
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
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
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
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
    
    public Monitoring.MonitoringDestination getConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Monitoring.MonitoringDestination)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Monitoring.MonitoringDestination.Builder getConsumerDestinationsBuilder(int param1Int) {
      return (Monitoring.MonitoringDestination.Builder)getConsumerDestinationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Monitoring.MonitoringDestination.Builder> getConsumerDestinationsBuilderList() {
      return getConsumerDestinationsFieldBuilder().getBuilderList();
    }
    
    public int getConsumerDestinationsCount() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Monitoring.MonitoringDestination> getConsumerDestinationsList() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.consumerDestinations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Monitoring.MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Monitoring.MonitoringDestinationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Monitoring.MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.consumerDestinations_);
    }
    
    public Monitoring getDefaultInstanceForType() {
      return Monitoring.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MonitoringProto.a;
    }
    
    public Monitoring.MonitoringDestination getProducerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.get(param1Int) : (Monitoring.MonitoringDestination)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Monitoring.MonitoringDestination.Builder getProducerDestinationsBuilder(int param1Int) {
      return (Monitoring.MonitoringDestination.Builder)getProducerDestinationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Monitoring.MonitoringDestination.Builder> getProducerDestinationsBuilderList() {
      return getProducerDestinationsFieldBuilder().getBuilderList();
    }
    
    public int getProducerDestinationsCount() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Monitoring.MonitoringDestination> getProducerDestinationsList() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.producerDestinations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Monitoring.MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.producerDestinations_.get(param1Int) : (Monitoring.MonitoringDestinationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Monitoring.MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.producerDestinations_);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MonitoringProto.b.ensureFieldAccessorsInitialized(Monitoring.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Monitoring param1Monitoring) {
      if (param1Monitoring == Monitoring.getDefaultInstance())
        return this; 
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      RepeatedFieldBuilderV3 repeatedFieldBuilderV31 = null;
      if (repeatedFieldBuilderV3 == null) {
        if (!param1Monitoring.producerDestinations_.isEmpty()) {
          if (this.producerDestinations_.isEmpty()) {
            this.producerDestinations_ = param1Monitoring.producerDestinations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureProducerDestinationsIsMutable();
            this.producerDestinations_.addAll(param1Monitoring.producerDestinations_);
          } 
          onChanged();
        } 
      } else if (!param1Monitoring.producerDestinations_.isEmpty()) {
        if (this.producerDestinationsBuilder_.isEmpty()) {
          this.producerDestinationsBuilder_.dispose();
          this.producerDestinationsBuilder_ = null;
          this.producerDestinations_ = param1Monitoring.producerDestinations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Monitoring.alwaysUseFieldBuilders) {
            repeatedFieldBuilderV3 = getProducerDestinationsFieldBuilder();
          } else {
            repeatedFieldBuilderV3 = null;
          } 
          this.producerDestinationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.producerDestinationsBuilder_.addAllMessages(param1Monitoring.producerDestinations_);
        } 
      } 
      if (this.consumerDestinationsBuilder_ == null) {
        if (!param1Monitoring.consumerDestinations_.isEmpty()) {
          if (this.consumerDestinations_.isEmpty()) {
            this.consumerDestinations_ = param1Monitoring.consumerDestinations_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.addAll(param1Monitoring.consumerDestinations_);
          } 
          onChanged();
        } 
      } else if (!param1Monitoring.consumerDestinations_.isEmpty()) {
        if (this.consumerDestinationsBuilder_.isEmpty()) {
          this.consumerDestinationsBuilder_.dispose();
          this.consumerDestinationsBuilder_ = null;
          this.consumerDestinations_ = param1Monitoring.consumerDestinations_;
          this.bitField0_ &= 0xFFFFFFFD;
          repeatedFieldBuilderV3 = repeatedFieldBuilderV31;
          if (Monitoring.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getConsumerDestinationsFieldBuilder(); 
          this.consumerDestinationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.consumerDestinationsBuilder_.addAllMessages(param1Monitoring.consumerDestinations_);
        } 
      } 
      mergeUnknownFields(param1Monitoring.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Monitoring monitoring = (Monitoring)Monitoring.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Monitoring monitoring = (Monitoring)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Monitoring)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Monitoring)
        return mergeFrom((Monitoring)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
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
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.set(param1Int, param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setProducerDestinations(int param1Int, Monitoring.MonitoringDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setProducerDestinations(int param1Int, Monitoring.MonitoringDestination param1MonitoringDestination) {
      RepeatedFieldBuilderV3<Monitoring.MonitoringDestination, Monitoring.MonitoringDestination.Builder, Monitoring.MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1MonitoringDestination != null) {
          ensureProducerDestinationsIsMutable();
          this.producerDestinations_.set(param1Int, param1MonitoringDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1MonitoringDestination);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class MonitoringDestination extends GeneratedMessageV3 implements MonitoringDestinationOrBuilder {
    private static final MonitoringDestination DEFAULT_INSTANCE = new MonitoringDestination();
    
    public static final int METRICS_FIELD_NUMBER = 2;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
    
    private static final Parser<MonitoringDestination> PARSER = (Parser<MonitoringDestination>)new AbstractParser<MonitoringDestination>() {
        public Monitoring.MonitoringDestination a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Monitoring.MonitoringDestination(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private byte memoizedIsInitialized = -1;
    
    private LazyStringList metrics_;
    
    private volatile Object monitoredResource_;
    
    private MonitoringDestination() {
      this.monitoredResource_ = "";
      this.metrics_ = LazyStringArrayList.EMPTY;
    }
    
    private MonitoringDestination(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                if (n != 18) {
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
                String str = param1CodedInputStream.readStringRequireUtf8();
                n = i;
                if ((i & 0x2) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.metrics_ = (LazyStringList)new LazyStringArrayList();
                  n = i | 0x2;
                } 
                j = n;
                k = n;
                m = n;
                this.metrics_.add(str);
                i = n;
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.monitoredResource_ = param1CodedInputStream.readStringRequireUtf8();
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
            this.metrics_ = this.metrics_.getUnmodifiableView(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x2) != 0)
          this.metrics_ = this.metrics_.getUnmodifiableView(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private MonitoringDestination(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static MonitoringDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MonitoringProto.c;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(MonitoringDestination param1MonitoringDestination) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1MonitoringDestination);
    }
    
    public static MonitoringDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static MonitoringDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ByteString);
    }
    
    public static MonitoringDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static MonitoringDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static MonitoringDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (MonitoringDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static MonitoringDestination parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static MonitoringDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static MonitoringDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (MonitoringDestination)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<MonitoringDestination> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof MonitoringDestination))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getMonitoredResource().equals(param1Object.getMonitoredResource()) ? false : (!getMetricsList().equals(param1Object.getMetricsList()) ? false : (!!this.unknownFields.equals(((MonitoringDestination)param1Object).unknownFields)));
    }
    
    public MonitoringDestination getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getMetrics(int param1Int) {
      return (String)this.metrics_.get(param1Int);
    }
    
    public ByteString getMetricsBytes(int param1Int) {
      return this.metrics_.getByteString(param1Int);
    }
    
    public int getMetricsCount() {
      return this.metrics_.size();
    }
    
    public ProtocolStringList getMetricsList() {
      return (ProtocolStringList)this.metrics_;
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
    
    public Parser<MonitoringDestination> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      boolean bool = getMonitoredResourceBytes().isEmpty();
      int j = 0;
      if (!bool) {
        i = GeneratedMessageV3.computeStringSize(1, this.monitoredResource_) + 0;
      } else {
        i = 0;
      } 
      int k = 0;
      while (j < this.metrics_.size()) {
        k += computeStringSizeNoTag(this.metrics_.getRaw(j));
        j++;
      } 
      i = i + k + getMetricsList().size() * 1 + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getMonitoredResource().hashCode();
      int i = j;
      if (getMetricsCount() > 0)
        i = (j * 37 + 2) * 53 + getMetricsList().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return MonitoringProto.d.ensureFieldAccessorsInitialized(MonitoringDestination.class, Builder.class);
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
      if (!getMonitoredResourceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.monitoredResource_); 
      for (int i = 0; i < this.metrics_.size(); i++)
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.metrics_.getRaw(i)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Monitoring.MonitoringDestinationOrBuilder {
      private int bitField0_;
      
      private LazyStringList metrics_ = LazyStringArrayList.EMPTY;
      
      private Object monitoredResource_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureMetricsIsMutable() {
        if ((this.bitField0_ & 0x2) == 0) {
          this.metrics_ = (LazyStringList)new LazyStringArrayList(this.metrics_);
          this.bitField0_ |= 0x2;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return MonitoringProto.c;
      }
      
      private void maybeForceBuilderInitialization() {
        Monitoring.MonitoringDestination.alwaysUseFieldBuilders;
      }
      
      public Builder addAllMetrics(Iterable<String> param2Iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.metrics_);
        onChanged();
        return this;
      }
      
      public Builder addMetrics(String param2String) {
        if (param2String != null) {
          ensureMetricsIsMutable();
          this.metrics_.add(param2String);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addMetricsBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          Monitoring.MonitoringDestination.checkByteStringIsUtf8(param2ByteString);
          ensureMetricsIsMutable();
          this.metrics_.add(param2ByteString);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Monitoring.MonitoringDestination build() {
        Monitoring.MonitoringDestination monitoringDestination = buildPartial();
        if (monitoringDestination.isInitialized())
          return monitoringDestination; 
        throw newUninitializedMessageException(monitoringDestination);
      }
      
      public Monitoring.MonitoringDestination buildPartial() {
        Monitoring.MonitoringDestination monitoringDestination = new Monitoring.MonitoringDestination(this);
        int i = this.bitField0_;
        Monitoring.MonitoringDestination.access$402(monitoringDestination, this.monitoredResource_);
        if ((this.bitField0_ & 0x2) != 0) {
          this.metrics_ = this.metrics_.getUnmodifiableView();
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Monitoring.MonitoringDestination.access$502(monitoringDestination, this.metrics_);
        Monitoring.MonitoringDestination.access$602(monitoringDestination, 0);
        onBuilt();
        return monitoringDestination;
      }
      
      public Builder clear() {
        super.clear();
        this.monitoredResource_ = "";
        this.metrics_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFD;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearMetrics() {
        this.metrics_ = LazyStringArrayList.EMPTY;
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      }
      
      public Builder clearMonitoredResource() {
        this.monitoredResource_ = Monitoring.MonitoringDestination.getDefaultInstance().getMonitoredResource();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Monitoring.MonitoringDestination getDefaultInstanceForType() {
        return Monitoring.MonitoringDestination.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return MonitoringProto.c;
      }
      
      public String getMetrics(int param2Int) {
        return (String)this.metrics_.get(param2Int);
      }
      
      public ByteString getMetricsBytes(int param2Int) {
        return this.metrics_.getByteString(param2Int);
      }
      
      public int getMetricsCount() {
        return this.metrics_.size();
      }
      
      public ProtocolStringList getMetricsList() {
        return (ProtocolStringList)this.metrics_.getUnmodifiableView();
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
        return MonitoringProto.d.ensureFieldAccessorsInitialized(Monitoring.MonitoringDestination.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Monitoring.MonitoringDestination param2MonitoringDestination) {
        if (param2MonitoringDestination == Monitoring.MonitoringDestination.getDefaultInstance())
          return this; 
        if (!param2MonitoringDestination.getMonitoredResource().isEmpty()) {
          this.monitoredResource_ = param2MonitoringDestination.monitoredResource_;
          onChanged();
        } 
        if (!param2MonitoringDestination.metrics_.isEmpty()) {
          if (this.metrics_.isEmpty()) {
            this.metrics_ = param2MonitoringDestination.metrics_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureMetricsIsMutable();
            this.metrics_.addAll((Collection)param2MonitoringDestination.metrics_);
          } 
          onChanged();
        } 
        mergeUnknownFields(param2MonitoringDestination.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Monitoring.MonitoringDestination monitoringDestination = (Monitoring.MonitoringDestination)Monitoring.MonitoringDestination.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Monitoring.MonitoringDestination monitoringDestination = (Monitoring.MonitoringDestination)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Monitoring.MonitoringDestination)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Monitoring.MonitoringDestination)
          return mergeFrom((Monitoring.MonitoringDestination)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setMetrics(int param2Int, String param2String) {
        if (param2String != null) {
          ensureMetricsIsMutable();
          this.metrics_.set(param2Int, param2String);
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
          Monitoring.MonitoringDestination.checkByteStringIsUtf8(param2ByteString);
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
  
  static final class null extends AbstractParser<MonitoringDestination> {
    public Monitoring.MonitoringDestination a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Monitoring.MonitoringDestination(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<MonitoringDestination.Builder> implements MonitoringDestinationOrBuilder {
    private int bitField0_;
    
    private LazyStringList metrics_ = LazyStringArrayList.EMPTY;
    
    private Object monitoredResource_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureMetricsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.metrics_ = (LazyStringList)new LazyStringArrayList(this.metrics_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return MonitoringProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      Monitoring.MonitoringDestination.alwaysUseFieldBuilders;
    }
    
    public Builder addAllMetrics(Iterable<String> param1Iterable) {
      ensureMetricsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.metrics_);
      onChanged();
      return this;
    }
    
    public Builder addMetrics(String param1String) {
      if (param1String != null) {
        ensureMetricsIsMutable();
        this.metrics_.add(param1String);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addMetricsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Monitoring.MonitoringDestination.checkByteStringIsUtf8(param1ByteString);
        ensureMetricsIsMutable();
        this.metrics_.add(param1ByteString);
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Monitoring.MonitoringDestination build() {
      Monitoring.MonitoringDestination monitoringDestination = buildPartial();
      if (monitoringDestination.isInitialized())
        return monitoringDestination; 
      throw newUninitializedMessageException(monitoringDestination);
    }
    
    public Monitoring.MonitoringDestination buildPartial() {
      Monitoring.MonitoringDestination monitoringDestination = new Monitoring.MonitoringDestination(this);
      int i = this.bitField0_;
      Monitoring.MonitoringDestination.access$402(monitoringDestination, this.monitoredResource_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.metrics_ = this.metrics_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      Monitoring.MonitoringDestination.access$502(monitoringDestination, this.metrics_);
      Monitoring.MonitoringDestination.access$602(monitoringDestination, 0);
      onBuilt();
      return monitoringDestination;
    }
    
    public Builder clear() {
      super.clear();
      this.monitoredResource_ = "";
      this.metrics_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMetrics() {
      this.metrics_ = LazyStringArrayList.EMPTY;
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearMonitoredResource() {
      this.monitoredResource_ = Monitoring.MonitoringDestination.getDefaultInstance().getMonitoredResource();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Monitoring.MonitoringDestination getDefaultInstanceForType() {
      return Monitoring.MonitoringDestination.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return MonitoringProto.c;
    }
    
    public String getMetrics(int param1Int) {
      return (String)this.metrics_.get(param1Int);
    }
    
    public ByteString getMetricsBytes(int param1Int) {
      return this.metrics_.getByteString(param1Int);
    }
    
    public int getMetricsCount() {
      return this.metrics_.size();
    }
    
    public ProtocolStringList getMetricsList() {
      return (ProtocolStringList)this.metrics_.getUnmodifiableView();
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
      return MonitoringProto.d.ensureFieldAccessorsInitialized(Monitoring.MonitoringDestination.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Monitoring.MonitoringDestination param1MonitoringDestination) {
      if (param1MonitoringDestination == Monitoring.MonitoringDestination.getDefaultInstance())
        return this; 
      if (!param1MonitoringDestination.getMonitoredResource().isEmpty()) {
        this.monitoredResource_ = param1MonitoringDestination.monitoredResource_;
        onChanged();
      } 
      if (!param1MonitoringDestination.metrics_.isEmpty()) {
        if (this.metrics_.isEmpty()) {
          this.metrics_ = param1MonitoringDestination.metrics_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureMetricsIsMutable();
          this.metrics_.addAll((Collection)param1MonitoringDestination.metrics_);
        } 
        onChanged();
      } 
      mergeUnknownFields(param1MonitoringDestination.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Monitoring.MonitoringDestination monitoringDestination = (Monitoring.MonitoringDestination)Monitoring.MonitoringDestination.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Monitoring.MonitoringDestination monitoringDestination = (Monitoring.MonitoringDestination)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Monitoring.MonitoringDestination)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Monitoring.MonitoringDestination)
        return mergeFrom((Monitoring.MonitoringDestination)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMetrics(int param1Int, String param1String) {
      if (param1String != null) {
        ensureMetricsIsMutable();
        this.metrics_.set(param1Int, param1String);
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
        Monitoring.MonitoringDestination.checkByteStringIsUtf8(param1ByteString);
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
  
  public static interface MonitoringDestinationOrBuilder extends MessageOrBuilder {
    String getMetrics(int param1Int);
    
    ByteString getMetricsBytes(int param1Int);
    
    int getMetricsCount();
    
    List<String> getMetricsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Monitoring.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */