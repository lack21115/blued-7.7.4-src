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

public final class Billing extends GeneratedMessageV3 implements BillingOrBuilder {
  public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 8;
  
  private static final Billing DEFAULT_INSTANCE = new Billing();
  
  private static final Parser<Billing> PARSER = (Parser<Billing>)new AbstractParser<Billing>() {
      public Billing a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Billing(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  private static final long serialVersionUID = 0L;
  
  private List<BillingDestination> consumerDestinations_;
  
  private byte memoizedIsInitialized = -1;
  
  private Billing() {
    this.consumerDestinations_ = Collections.emptyList();
  }
  
  private Billing(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            if (n != 66) {
              j = i;
              k = i;
              m = i;
              if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                continue; 
              continue;
            } 
            n = i;
            if ((i & 0x1) == 0) {
              j = i;
              k = i;
              m = i;
              this.consumerDestinations_ = new ArrayList<BillingDestination>();
              n = i | 0x1;
            } 
            j = n;
            k = n;
            m = n;
            this.consumerDestinations_.add(paramCodedInputStream.readMessage(BillingDestination.parser(), paramExtensionRegistryLite));
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
          this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x1) != 0)
        this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Billing(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Billing getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return BillingProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Billing paramBilling) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBilling);
  }
  
  public static Billing parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Billing)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Billing parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramByteString);
  }
  
  public static Billing parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Billing)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Billing parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(InputStream paramInputStream) throws IOException {
    return (Billing)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Billing parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Billing)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Billing parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Billing parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Billing parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Billing)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Billing> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Billing))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getConsumerDestinationsList().equals(paramObject.getConsumerDestinationsList()) ? false : (!!this.unknownFields.equals(((Billing)paramObject).unknownFields));
  }
  
  public BillingDestination getConsumerDestinations(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public int getConsumerDestinationsCount() {
    return this.consumerDestinations_.size();
  }
  
  public List<BillingDestination> getConsumerDestinationsList() {
    return this.consumerDestinations_;
  }
  
  public BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int paramInt) {
    return this.consumerDestinations_.get(paramInt);
  }
  
  public List<? extends BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
    return (List)this.consumerDestinations_;
  }
  
  public Billing getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Parser<Billing> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    i = 0;
    int j = 0;
    while (i < this.consumerDestinations_.size()) {
      j += CodedOutputStream.computeMessageSize(8, (MessageLite)this.consumerDestinations_.get(i));
      i++;
    } 
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
    int j = 779 + getDescriptor().hashCode();
    int i = j;
    if (getConsumerDestinationsCount() > 0)
      i = (j * 37 + 8) * 53 + getConsumerDestinationsList().hashCode(); 
    i = i * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return BillingProto.b.ensureFieldAccessorsInitialized(Billing.class, Builder.class);
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
    for (int i = 0; i < this.consumerDestinations_.size(); i++)
      paramCodedOutputStream.writeMessage(8, (MessageLite)this.consumerDestinations_.get(i)); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class BillingDestination extends GeneratedMessageV3 implements BillingDestinationOrBuilder {
    private static final BillingDestination DEFAULT_INSTANCE = new BillingDestination();
    
    public static final int METRICS_FIELD_NUMBER = 2;
    
    public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
    
    private static final Parser<BillingDestination> PARSER = (Parser<BillingDestination>)new AbstractParser<BillingDestination>() {
        public Billing.BillingDestination a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Billing.BillingDestination(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int bitField0_;
    
    private byte memoizedIsInitialized = -1;
    
    private LazyStringList metrics_;
    
    private volatile Object monitoredResource_;
    
    private BillingDestination() {
      this.monitoredResource_ = "";
      this.metrics_ = LazyStringArrayList.EMPTY;
    }
    
    private BillingDestination(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
    
    private BillingDestination(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static BillingDestination getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return BillingProto.c;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(BillingDestination param1BillingDestination) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1BillingDestination);
    }
    
    public static BillingDestination parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static BillingDestination parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ByteString);
    }
    
    public static BillingDestination parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static BillingDestination parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(InputStream param1InputStream) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static BillingDestination parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BillingDestination)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static BillingDestination parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static BillingDestination parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static BillingDestination parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BillingDestination)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<BillingDestination> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof BillingDestination))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getMonitoredResource().equals(param1Object.getMonitoredResource()) ? false : (!getMetricsList().equals(param1Object.getMetricsList()) ? false : (!!this.unknownFields.equals(((BillingDestination)param1Object).unknownFields)));
    }
    
    public BillingDestination getDefaultInstanceForType() {
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
    
    public Parser<BillingDestination> getParserForType() {
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
      return BillingProto.d.ensureFieldAccessorsInitialized(BillingDestination.class, Builder.class);
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
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Billing.BillingDestinationOrBuilder {
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
        return BillingProto.c;
      }
      
      private void maybeForceBuilderInitialization() {
        Billing.BillingDestination.alwaysUseFieldBuilders;
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
          Billing.BillingDestination.checkByteStringIsUtf8(param2ByteString);
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
      
      public Billing.BillingDestination build() {
        Billing.BillingDestination billingDestination = buildPartial();
        if (billingDestination.isInitialized())
          return billingDestination; 
        throw newUninitializedMessageException(billingDestination);
      }
      
      public Billing.BillingDestination buildPartial() {
        Billing.BillingDestination billingDestination = new Billing.BillingDestination(this);
        int i = this.bitField0_;
        Billing.BillingDestination.access$402(billingDestination, this.monitoredResource_);
        if ((this.bitField0_ & 0x2) != 0) {
          this.metrics_ = this.metrics_.getUnmodifiableView();
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        Billing.BillingDestination.access$502(billingDestination, this.metrics_);
        Billing.BillingDestination.access$602(billingDestination, 0);
        onBuilt();
        return billingDestination;
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
        this.monitoredResource_ = Billing.BillingDestination.getDefaultInstance().getMonitoredResource();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Billing.BillingDestination getDefaultInstanceForType() {
        return Billing.BillingDestination.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return BillingProto.c;
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
        return BillingProto.d.ensureFieldAccessorsInitialized(Billing.BillingDestination.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Billing.BillingDestination param2BillingDestination) {
        if (param2BillingDestination == Billing.BillingDestination.getDefaultInstance())
          return this; 
        if (!param2BillingDestination.getMonitoredResource().isEmpty()) {
          this.monitoredResource_ = param2BillingDestination.monitoredResource_;
          onChanged();
        } 
        if (!param2BillingDestination.metrics_.isEmpty()) {
          if (this.metrics_.isEmpty()) {
            this.metrics_ = param2BillingDestination.metrics_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureMetricsIsMutable();
            this.metrics_.addAll((Collection)param2BillingDestination.metrics_);
          } 
          onChanged();
        } 
        mergeUnknownFields(param2BillingDestination.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Billing.BillingDestination billingDestination = (Billing.BillingDestination)Billing.BillingDestination.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Billing.BillingDestination billingDestination = (Billing.BillingDestination)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Billing.BillingDestination)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Billing.BillingDestination)
          return mergeFrom((Billing.BillingDestination)param2Message); 
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
          Billing.BillingDestination.checkByteStringIsUtf8(param2ByteString);
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
  
  static final class null extends AbstractParser<BillingDestination> {
    public Billing.BillingDestination a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Billing.BillingDestination(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<BillingDestination.Builder> implements BillingDestinationOrBuilder {
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
      return BillingProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      Billing.BillingDestination.alwaysUseFieldBuilders;
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
        Billing.BillingDestination.checkByteStringIsUtf8(param1ByteString);
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
    
    public Billing.BillingDestination build() {
      Billing.BillingDestination billingDestination = buildPartial();
      if (billingDestination.isInitialized())
        return billingDestination; 
      throw newUninitializedMessageException(billingDestination);
    }
    
    public Billing.BillingDestination buildPartial() {
      Billing.BillingDestination billingDestination = new Billing.BillingDestination(this);
      int i = this.bitField0_;
      Billing.BillingDestination.access$402(billingDestination, this.monitoredResource_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.metrics_ = this.metrics_.getUnmodifiableView();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      Billing.BillingDestination.access$502(billingDestination, this.metrics_);
      Billing.BillingDestination.access$602(billingDestination, 0);
      onBuilt();
      return billingDestination;
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
      this.monitoredResource_ = Billing.BillingDestination.getDefaultInstance().getMonitoredResource();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Billing.BillingDestination getDefaultInstanceForType() {
      return Billing.BillingDestination.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return BillingProto.c;
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
      return BillingProto.d.ensureFieldAccessorsInitialized(Billing.BillingDestination.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Billing.BillingDestination param1BillingDestination) {
      if (param1BillingDestination == Billing.BillingDestination.getDefaultInstance())
        return this; 
      if (!param1BillingDestination.getMonitoredResource().isEmpty()) {
        this.monitoredResource_ = param1BillingDestination.monitoredResource_;
        onChanged();
      } 
      if (!param1BillingDestination.metrics_.isEmpty()) {
        if (this.metrics_.isEmpty()) {
          this.metrics_ = param1BillingDestination.metrics_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureMetricsIsMutable();
          this.metrics_.addAll((Collection)param1BillingDestination.metrics_);
        } 
        onChanged();
      } 
      mergeUnknownFields(param1BillingDestination.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Billing.BillingDestination billingDestination = (Billing.BillingDestination)Billing.BillingDestination.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Billing.BillingDestination billingDestination = (Billing.BillingDestination)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Billing.BillingDestination)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Billing.BillingDestination)
        return mergeFrom((Billing.BillingDestination)param1Message); 
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
        Billing.BillingDestination.checkByteStringIsUtf8(param1ByteString);
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
  
  public static interface BillingDestinationOrBuilder extends MessageOrBuilder {
    String getMetrics(int param1Int);
    
    ByteString getMetricsBytes(int param1Int);
    
    int getMetricsCount();
    
    List<String> getMetricsList();
    
    String getMonitoredResource();
    
    ByteString getMonitoredResourceBytes();
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BillingOrBuilder {
    private int bitField0_;
    
    private RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> consumerDestinationsBuilder_;
    
    private List<Billing.BillingDestination> consumerDestinations_ = Collections.emptyList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureConsumerDestinationsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.consumerDestinations_ = new ArrayList<Billing.BillingDestination>(this.consumerDestinations_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> getConsumerDestinationsFieldBuilder() {
      if (this.consumerDestinationsBuilder_ == null) {
        List<Billing.BillingDestination> list = this.consumerDestinations_;
        int i = this.bitField0_;
        boolean bool = true;
        if ((i & 0x1) == 0)
          bool = false; 
        this.consumerDestinationsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.consumerDestinations_ = null;
      } 
      return this.consumerDestinationsBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return BillingProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Billing.alwaysUseFieldBuilders)
        getConsumerDestinationsFieldBuilder(); 
    }
    
    public Builder addAllConsumerDestinations(Iterable<? extends Billing.BillingDestination> param1Iterable) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.consumerDestinations_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Billing.BillingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(int param1Int, Billing.BillingDestination param1BillingDestination) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BillingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1Int, param1BillingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1BillingDestination);
      return this;
    }
    
    public Builder addConsumerDestinations(Billing.BillingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addConsumerDestinations(Billing.BillingDestination param1BillingDestination) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BillingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.add(param1BillingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1BillingDestination);
      return this;
    }
    
    public Billing.BillingDestination.Builder addConsumerDestinationsBuilder() {
      return (Billing.BillingDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder((AbstractMessage)Billing.BillingDestination.getDefaultInstance());
    }
    
    public Billing.BillingDestination.Builder addConsumerDestinationsBuilder(int param1Int) {
      return (Billing.BillingDestination.Builder)getConsumerDestinationsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Billing.BillingDestination.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Billing build() {
      Billing billing = buildPartial();
      if (billing.isInitialized())
        return billing; 
      throw newUninitializedMessageException(billing);
    }
    
    public Billing buildPartial() {
      Billing billing = new Billing(this);
      int i = this.bitField0_;
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((i & 0x1) != 0) {
          this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_);
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Billing.access$1602(billing, this.consumerDestinations_);
      } else {
        Billing.access$1602(billing, repeatedFieldBuilderV3.build());
      } 
      onBuilt();
      return billing;
    }
    
    public Builder clear() {
      super.clear();
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.consumerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearConsumerDestinations() {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.consumerDestinations_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFE;
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
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Billing.BillingDestination getConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Billing.BillingDestination)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Billing.BillingDestination.Builder getConsumerDestinationsBuilder(int param1Int) {
      return (Billing.BillingDestination.Builder)getConsumerDestinationsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Billing.BillingDestination.Builder> getConsumerDestinationsBuilderList() {
      return getConsumerDestinationsFieldBuilder().getBuilderList();
    }
    
    public int getConsumerDestinationsCount() {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Billing.BillingDestination> getConsumerDestinationsList() {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.consumerDestinations_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Billing.BillingDestinationOrBuilder getConsumerDestinationsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.consumerDestinations_.get(param1Int) : (Billing.BillingDestinationOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Billing.BillingDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.consumerDestinations_);
    }
    
    public Billing getDefaultInstanceForType() {
      return Billing.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return BillingProto.a;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return BillingProto.b.ensureFieldAccessorsInitialized(Billing.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Billing param1Billing) {
      if (param1Billing == Billing.getDefaultInstance())
        return this; 
      if (this.consumerDestinationsBuilder_ == null) {
        if (!param1Billing.consumerDestinations_.isEmpty()) {
          if (this.consumerDestinations_.isEmpty()) {
            this.consumerDestinations_ = param1Billing.consumerDestinations_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureConsumerDestinationsIsMutable();
            this.consumerDestinations_.addAll(param1Billing.consumerDestinations_);
          } 
          onChanged();
        } 
      } else if (!param1Billing.consumerDestinations_.isEmpty()) {
        if (this.consumerDestinationsBuilder_.isEmpty()) {
          this.consumerDestinationsBuilder_.dispose();
          RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = null;
          this.consumerDestinationsBuilder_ = null;
          this.consumerDestinations_ = param1Billing.consumerDestinations_;
          this.bitField0_ &= 0xFFFFFFFE;
          if (Billing.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getConsumerDestinationsFieldBuilder(); 
          this.consumerDestinationsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.consumerDestinationsBuilder_.addAllMessages(param1Billing.consumerDestinations_);
        } 
      } 
      mergeUnknownFields(param1Billing.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Billing billing = (Billing)Billing.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Billing billing = (Billing)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Billing)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Billing)
        return mergeFrom((Billing)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeConsumerDestinations(int param1Int) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Billing.BillingDestination.Builder param1Builder) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setConsumerDestinations(int param1Int, Billing.BillingDestination param1BillingDestination) {
      RepeatedFieldBuilderV3<Billing.BillingDestination, Billing.BillingDestination.Builder, Billing.BillingDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1BillingDestination != null) {
          ensureConsumerDestinationsIsMutable();
          this.consumerDestinations_.set(param1Int, param1BillingDestination);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1BillingDestination);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Billing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */