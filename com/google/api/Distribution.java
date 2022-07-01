package com.google.api;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Distribution extends GeneratedMessageV3 implements DistributionOrBuilder {
  public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
  
  public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
  
  public static final int COUNT_FIELD_NUMBER = 1;
  
  private static final Distribution DEFAULT_INSTANCE = new Distribution();
  
  public static final int EXEMPLARS_FIELD_NUMBER = 10;
  
  public static final int MEAN_FIELD_NUMBER = 2;
  
  private static final Parser<Distribution> PARSER = (Parser<Distribution>)new AbstractParser<Distribution>() {
      public Distribution a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Distribution(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int RANGE_FIELD_NUMBER = 4;
  
  public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
  
  private static final long serialVersionUID = 0L;
  
  private int bitField0_;
  
  private int bucketCountsMemoizedSerializedSize = -1;
  
  private Internal.LongList bucketCounts_;
  
  private BucketOptions bucketOptions_;
  
  private long count_;
  
  private List<Exemplar> exemplars_;
  
  private double mean_;
  
  private byte memoizedIsInitialized = -1;
  
  private Range range_;
  
  private double sumOfSquaredDeviation_;
  
  private Distribution() {
    this.bucketCounts_ = emptyLongList();
    this.exemplars_ = Collections.emptyList();
  }
  
  private Distribution(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            if (n != 8) {
              if (n != 17) {
                if (n != 25) {
                  Range.Builder builder1;
                  BucketOptions.Builder builder3 = null;
                  BucketOptions.Builder builder2 = null;
                  if (n != 34) {
                    if (n != 50) {
                      if (n != 56) {
                        if (n != 58) {
                          if (n != 82) {
                            j = i;
                            k = i;
                            m = i;
                            if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, n))
                              continue; 
                            continue;
                          } 
                          n = i;
                          if ((i & 0x40) == 0) {
                            j = i;
                            k = i;
                            m = i;
                            this.exemplars_ = new ArrayList<Exemplar>();
                            n = i | 0x40;
                          } 
                          j = n;
                          k = n;
                          m = n;
                          this.exemplars_.add(paramCodedInputStream.readMessage(Exemplar.parser(), paramExtensionRegistryLite));
                          i = n;
                          continue;
                        } 
                        j = i;
                        k = i;
                        m = i;
                        int i1 = paramCodedInputStream.pushLimit(paramCodedInputStream.readRawVarint32());
                        n = i;
                        if ((i & 0x20) == 0) {
                          n = i;
                          j = i;
                          k = i;
                          m = i;
                          if (paramCodedInputStream.getBytesUntilLimit() > 0) {
                            j = i;
                            k = i;
                            m = i;
                            this.bucketCounts_ = newLongList();
                            n = i | 0x20;
                          } 
                        } 
                        while (true) {
                          j = n;
                          k = n;
                          m = n;
                          if (paramCodedInputStream.getBytesUntilLimit() > 0) {
                            j = n;
                            k = n;
                            m = n;
                            this.bucketCounts_.addLong(paramCodedInputStream.readInt64());
                            continue;
                          } 
                          j = n;
                          k = n;
                          m = n;
                          break;
                        } 
                        paramCodedInputStream.popLimit(i1);
                        i = n;
                        continue;
                      } 
                      n = i;
                      if ((i & 0x20) == 0) {
                        j = i;
                        k = i;
                        m = i;
                        this.bucketCounts_ = newLongList();
                        n = i | 0x20;
                      } 
                      j = n;
                      k = n;
                      m = n;
                      this.bucketCounts_.addLong(paramCodedInputStream.readInt64());
                      i = n;
                      continue;
                    } 
                    j = i;
                    k = i;
                    m = i;
                    if (this.bucketOptions_ != null) {
                      j = i;
                      k = i;
                      m = i;
                      builder2 = this.bucketOptions_.toBuilder();
                    } 
                    j = i;
                    k = i;
                    m = i;
                    this.bucketOptions_ = (BucketOptions)paramCodedInputStream.readMessage(BucketOptions.parser(), paramExtensionRegistryLite);
                    if (builder2 != null) {
                      j = i;
                      k = i;
                      m = i;
                      builder2.mergeFrom(this.bucketOptions_);
                      j = i;
                      k = i;
                      m = i;
                      this.bucketOptions_ = builder2.buildPartial();
                    } 
                    continue;
                  } 
                  builder2 = builder3;
                  j = i;
                  k = i;
                  m = i;
                  if (this.range_ != null) {
                    j = i;
                    k = i;
                    m = i;
                    builder1 = this.range_.toBuilder();
                  } 
                  j = i;
                  k = i;
                  m = i;
                  this.range_ = (Range)paramCodedInputStream.readMessage(Range.parser(), paramExtensionRegistryLite);
                  if (builder1 != null) {
                    j = i;
                    k = i;
                    m = i;
                    builder1.mergeFrom(this.range_);
                    j = i;
                    k = i;
                    m = i;
                    this.range_ = builder1.buildPartial();
                  } 
                  continue;
                } 
                j = i;
                k = i;
                m = i;
                this.sumOfSquaredDeviation_ = paramCodedInputStream.readDouble();
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.mean_ = paramCodedInputStream.readDouble();
              continue;
            } 
            j = i;
            k = i;
            m = i;
            this.count_ = paramCodedInputStream.readInt64();
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
        if ((j & 0x20) != 0)
          this.bucketCounts_.makeImmutable(); 
        if ((j & 0x40) != 0)
          this.exemplars_ = Collections.unmodifiableList(this.exemplars_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        throw paramCodedInputStream;
        bool = true;
      } 
      if ((i & 0x20) != 0)
        this.bucketCounts_.makeImmutable(); 
      if ((i & 0x40) != 0)
        this.exemplars_ = Collections.unmodifiableList(this.exemplars_); 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Distribution(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Distribution getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return DistributionProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Distribution paramDistribution) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDistribution);
  }
  
  public static Distribution parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Distribution)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Distribution parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramByteString);
  }
  
  public static Distribution parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Distribution)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Distribution parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(InputStream paramInputStream) throws IOException {
    return (Distribution)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Distribution parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Distribution)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Distribution parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Distribution parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Distribution parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Distribution)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Distribution> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Distribution))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return (getCount() != paramObject.getCount()) ? false : ((Double.doubleToLongBits(getMean()) != Double.doubleToLongBits(paramObject.getMean())) ? false : ((Double.doubleToLongBits(getSumOfSquaredDeviation()) != Double.doubleToLongBits(paramObject.getSumOfSquaredDeviation())) ? false : ((hasRange() != paramObject.hasRange()) ? false : ((hasRange() && !getRange().equals(paramObject.getRange())) ? false : ((hasBucketOptions() != paramObject.hasBucketOptions()) ? false : ((hasBucketOptions() && !getBucketOptions().equals(paramObject.getBucketOptions())) ? false : (!getBucketCountsList().equals(paramObject.getBucketCountsList()) ? false : (!getExemplarsList().equals(paramObject.getExemplarsList()) ? false : (!!this.unknownFields.equals(((Distribution)paramObject).unknownFields))))))))));
  }
  
  public long getBucketCounts(int paramInt) {
    return this.bucketCounts_.getLong(paramInt);
  }
  
  public int getBucketCountsCount() {
    return this.bucketCounts_.size();
  }
  
  public List<Long> getBucketCountsList() {
    return (List<Long>)this.bucketCounts_;
  }
  
  public BucketOptions getBucketOptions() {
    BucketOptions bucketOptions2 = this.bucketOptions_;
    BucketOptions bucketOptions1 = bucketOptions2;
    if (bucketOptions2 == null)
      bucketOptions1 = BucketOptions.getDefaultInstance(); 
    return bucketOptions1;
  }
  
  public BucketOptionsOrBuilder getBucketOptionsOrBuilder() {
    return getBucketOptions();
  }
  
  public long getCount() {
    return this.count_;
  }
  
  public Distribution getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public Exemplar getExemplars(int paramInt) {
    return this.exemplars_.get(paramInt);
  }
  
  public int getExemplarsCount() {
    return this.exemplars_.size();
  }
  
  public List<Exemplar> getExemplarsList() {
    return this.exemplars_;
  }
  
  public ExemplarOrBuilder getExemplarsOrBuilder(int paramInt) {
    return this.exemplars_.get(paramInt);
  }
  
  public List<? extends ExemplarOrBuilder> getExemplarsOrBuilderList() {
    return (List)this.exemplars_;
  }
  
  public double getMean() {
    return this.mean_;
  }
  
  public Parser<Distribution> getParserForType() {
    return PARSER;
  }
  
  public Range getRange() {
    Range range2 = this.range_;
    Range range1 = range2;
    if (range2 == null)
      range1 = Range.getDefaultInstance(); 
    return range1;
  }
  
  public RangeOrBuilder getRangeOrBuilder() {
    return getRange();
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    long l = this.count_;
    boolean bool = false;
    if (l != 0L) {
      j = CodedOutputStream.computeInt64Size(1, l) + 0;
    } else {
      j = 0;
    } 
    double d = this.mean_;
    i = j;
    if (d != 0.0D)
      i = j + CodedOutputStream.computeDoubleSize(2, d); 
    d = this.sumOfSquaredDeviation_;
    int j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(3, d); 
    i = j;
    if (this.range_ != null)
      i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getRange()); 
    j = i;
    if (this.bucketOptions_ != null)
      j = i + CodedOutputStream.computeMessageSize(6, (MessageLite)getBucketOptions()); 
    i = 0;
    int k = 0;
    while (i < this.bucketCounts_.size()) {
      k += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i));
      i++;
    } 
    j += k;
    i = j;
    if (!getBucketCountsList().isEmpty())
      i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k); 
    this.bucketCountsMemoizedSerializedSize = k;
    for (j = bool; j < this.exemplars_.size(); j++)
      i += CodedOutputStream.computeMessageSize(10, (MessageLite)this.exemplars_.get(j)); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public double getSumOfSquaredDeviation() {
    return this.sumOfSquaredDeviation_;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public boolean hasBucketOptions() {
    return (this.bucketOptions_ != null);
  }
  
  public boolean hasRange() {
    return (this.range_ != null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int j = ((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getCount())) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getMean()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getSumOfSquaredDeviation()));
    int i = j;
    if (hasRange())
      i = (j * 37 + 4) * 53 + getRange().hashCode(); 
    j = i;
    if (hasBucketOptions())
      j = (i * 37 + 6) * 53 + getBucketOptions().hashCode(); 
    i = j;
    if (getBucketCountsCount() > 0)
      i = (j * 37 + 7) * 53 + getBucketCountsList().hashCode(); 
    j = i;
    if (getExemplarsCount() > 0)
      j = (i * 37 + 10) * 53 + getExemplarsList().hashCode(); 
    i = j * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return DistributionProto.b.ensureFieldAccessorsInitialized(Distribution.class, Builder.class);
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
    getSerializedSize();
    long l = this.count_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
    double d = this.mean_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(2, d); 
    d = this.sumOfSquaredDeviation_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(3, d); 
    if (this.range_ != null)
      paramCodedOutputStream.writeMessage(4, (MessageLite)getRange()); 
    if (this.bucketOptions_ != null)
      paramCodedOutputStream.writeMessage(6, (MessageLite)getBucketOptions()); 
    if (getBucketCountsList().size() > 0) {
      paramCodedOutputStream.writeUInt32NoTag(58);
      paramCodedOutputStream.writeUInt32NoTag(this.bucketCountsMemoizedSerializedSize);
    } 
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < this.bucketCounts_.size()) {
        paramCodedOutputStream.writeInt64NoTag(this.bucketCounts_.getLong(i));
        i++;
        continue;
      } 
      break;
    } 
    while (j < this.exemplars_.size()) {
      paramCodedOutputStream.writeMessage(10, (MessageLite)this.exemplars_.get(j));
      j++;
    } 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class BucketOptions extends GeneratedMessageV3 implements BucketOptionsOrBuilder {
    private static final BucketOptions DEFAULT_INSTANCE = new BucketOptions();
    
    public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
    
    public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
    
    public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
    
    private static final Parser<BucketOptions> PARSER = (Parser<BucketOptions>)new AbstractParser<BucketOptions>() {
        public Distribution.BucketOptions a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.BucketOptions(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private int optionsCase_ = 0;
    
    private Object options_;
    
    private BucketOptions() {}
    
    private BucketOptions(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              Linear.Builder builder1;
              Explicit.Builder builder3 = null;
              Explicit.Builder builder4 = null;
              Explicit.Builder builder2 = null;
              if (i != 10) {
                Exponential.Builder builder5;
                if (i != 18) {
                  if (i != 26) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  if (this.optionsCase_ == 3)
                    builder2 = ((Explicit)this.options_).toBuilder(); 
                  this.options_ = param1CodedInputStream.readMessage(Explicit.parser(), param1ExtensionRegistryLite);
                  if (builder2 != null) {
                    builder2.mergeFrom((Explicit)this.options_);
                    this.options_ = builder2.buildPartial();
                  } 
                  this.optionsCase_ = 3;
                  continue;
                } 
                builder2 = builder3;
                if (this.optionsCase_ == 2)
                  builder5 = ((Exponential)this.options_).toBuilder(); 
                this.options_ = param1CodedInputStream.readMessage(Exponential.parser(), param1ExtensionRegistryLite);
                if (builder5 != null) {
                  builder5.mergeFrom((Exponential)this.options_);
                  this.options_ = builder5.buildPartial();
                } 
                this.optionsCase_ = 2;
                continue;
              } 
              builder2 = builder4;
              if (this.optionsCase_ == 1)
                builder1 = ((Linear)this.options_).toBuilder(); 
              this.options_ = param1CodedInputStream.readMessage(Linear.parser(), param1ExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom((Linear)this.options_);
                this.options_ = builder1.buildPartial();
              } 
              this.optionsCase_ = 1;
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private BucketOptions(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static BucketOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.e;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(BucketOptions param1BucketOptions) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1BucketOptions);
    }
    
    public static BucketOptions parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static BucketOptions parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ByteString);
    }
    
    public static BucketOptions parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static BucketOptions parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(InputStream param1InputStream) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static BucketOptions parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (BucketOptions)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static BucketOptions parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static BucketOptions parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static BucketOptions parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (BucketOptions)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<BucketOptions> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof BucketOptions))
        return super.equals(param1Object); 
      param1Object = param1Object;
      if (!getOptionsCase().equals(param1Object.getOptionsCase()))
        return false; 
      int i = this.optionsCase_;
      if (i != 1) {
        if (i != 2) {
          if (i == 3 && !getExplicitBuckets().equals(param1Object.getExplicitBuckets()))
            return false; 
        } else if (!getExponentialBuckets().equals(param1Object.getExponentialBuckets())) {
          return false;
        } 
      } else if (!getLinearBuckets().equals(param1Object.getLinearBuckets())) {
        return false;
      } 
      return !!this.unknownFields.equals(((BucketOptions)param1Object).unknownFields);
    }
    
    public BucketOptions getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Explicit getExplicitBuckets() {
      return (this.optionsCase_ == 3) ? (Explicit)this.options_ : Explicit.getDefaultInstance();
    }
    
    public ExplicitOrBuilder getExplicitBucketsOrBuilder() {
      return (this.optionsCase_ == 3) ? (Explicit)this.options_ : Explicit.getDefaultInstance();
    }
    
    public Exponential getExponentialBuckets() {
      return (this.optionsCase_ == 2) ? (Exponential)this.options_ : Exponential.getDefaultInstance();
    }
    
    public ExponentialOrBuilder getExponentialBucketsOrBuilder() {
      return (this.optionsCase_ == 2) ? (Exponential)this.options_ : Exponential.getDefaultInstance();
    }
    
    public Linear getLinearBuckets() {
      return (this.optionsCase_ == 1) ? (Linear)this.options_ : Linear.getDefaultInstance();
    }
    
    public LinearOrBuilder getLinearBucketsOrBuilder() {
      return (this.optionsCase_ == 1) ? (Linear)this.options_ : Linear.getDefaultInstance();
    }
    
    public OptionsCase getOptionsCase() {
      return OptionsCase.forNumber(this.optionsCase_);
    }
    
    public Parser<BucketOptions> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.optionsCase_ == 1)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)this.options_); 
      i = j;
      if (this.optionsCase_ == 2)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)this.options_); 
      j = i;
      if (this.optionsCase_ == 3)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)this.options_); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasExplicitBuckets() {
      return (this.optionsCase_ == 3);
    }
    
    public boolean hasExponentialBuckets() {
      return (this.optionsCase_ == 2);
    }
    
    public boolean hasLinearBuckets() {
      return (this.optionsCase_ == 1);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = 779 + getDescriptor().hashCode();
      int j = this.optionsCase_;
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            i = i * 29 + this.unknownFields.hashCode();
            this.memoizedHashCode = i;
            return i;
          } 
          i = (i * 37 + 3) * 53;
          j = getExplicitBuckets().hashCode();
        } else {
          i = (i * 37 + 2) * 53;
          j = getExponentialBuckets().hashCode();
        } 
      } else {
        i = (i * 37 + 1) * 53;
        j = getLinearBuckets().hashCode();
      } 
      i += j;
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.f.ensureFieldAccessorsInitialized(BucketOptions.class, Builder.class);
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
      if (this.optionsCase_ == 1)
        param1CodedOutputStream.writeMessage(1, (MessageLite)this.options_); 
      if (this.optionsCase_ == 2)
        param1CodedOutputStream.writeMessage(2, (MessageLite)this.options_); 
      if (this.optionsCase_ == 3)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.options_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptionsOrBuilder {
      private SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> explicitBucketsBuilder_;
      
      private SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> exponentialBucketsBuilder_;
      
      private SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> linearBucketsBuilder_;
      
      private int optionsCase_ = 0;
      
      private Object options_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.e;
      }
      
      private SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> getExplicitBucketsFieldBuilder() {
        if (this.explicitBucketsBuilder_ == null) {
          if (this.optionsCase_ != 3)
            this.options_ = Distribution.BucketOptions.Explicit.getDefaultInstance(); 
          this.explicitBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.options_ = null;
        } 
        this.optionsCase_ = 3;
        onChanged();
        return this.explicitBucketsBuilder_;
      }
      
      private SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> getExponentialBucketsFieldBuilder() {
        if (this.exponentialBucketsBuilder_ == null) {
          if (this.optionsCase_ != 2)
            this.options_ = Distribution.BucketOptions.Exponential.getDefaultInstance(); 
          this.exponentialBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.options_ = null;
        } 
        this.optionsCase_ = 2;
        onChanged();
        return this.exponentialBucketsBuilder_;
      }
      
      private SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> getLinearBucketsFieldBuilder() {
        if (this.linearBucketsBuilder_ == null) {
          if (this.optionsCase_ != 1)
            this.options_ = Distribution.BucketOptions.Linear.getDefaultInstance(); 
          this.linearBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.options_ = null;
        } 
        this.optionsCase_ = 1;
        onChanged();
        return this.linearBucketsBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.BucketOptions build() {
        Distribution.BucketOptions bucketOptions = buildPartial();
        if (bucketOptions.isInitialized())
          return bucketOptions; 
        throw newUninitializedMessageException(bucketOptions);
      }
      
      public Distribution.BucketOptions buildPartial() {
        Distribution.BucketOptions bucketOptions = new Distribution.BucketOptions(this);
        if (this.optionsCase_ == 1) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
          if (singleFieldBuilderV3 == null) {
            Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
          } else {
            Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
          } 
        } 
        if (this.optionsCase_ == 2) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
          if (singleFieldBuilderV3 == null) {
            Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
          } else {
            Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
          } 
        } 
        if (this.optionsCase_ == 3) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
          if (singleFieldBuilderV3 == null) {
            Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
          } else {
            Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
          } 
        } 
        Distribution.BucketOptions.access$4602(bucketOptions, this.optionsCase_);
        onBuilt();
        return bucketOptions;
      }
      
      public Builder clear() {
        super.clear();
        this.optionsCase_ = 0;
        this.options_ = null;
        return this;
      }
      
      public Builder clearExplicitBuckets() {
        if (this.explicitBucketsBuilder_ == null) {
          if (this.optionsCase_ == 3) {
            this.optionsCase_ = 0;
            this.options_ = null;
            onChanged();
            return this;
          } 
        } else {
          if (this.optionsCase_ == 3) {
            this.optionsCase_ = 0;
            this.options_ = null;
          } 
          this.explicitBucketsBuilder_.clear();
        } 
        return this;
      }
      
      public Builder clearExponentialBuckets() {
        if (this.exponentialBucketsBuilder_ == null) {
          if (this.optionsCase_ == 2) {
            this.optionsCase_ = 0;
            this.options_ = null;
            onChanged();
            return this;
          } 
        } else {
          if (this.optionsCase_ == 2) {
            this.optionsCase_ = 0;
            this.options_ = null;
          } 
          this.exponentialBucketsBuilder_.clear();
        } 
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearLinearBuckets() {
        if (this.linearBucketsBuilder_ == null) {
          if (this.optionsCase_ == 1) {
            this.optionsCase_ = 0;
            this.options_ = null;
            onChanged();
            return this;
          } 
        } else {
          if (this.optionsCase_ == 1) {
            this.optionsCase_ = 0;
            this.options_ = null;
          } 
          this.linearBucketsBuilder_.clear();
        } 
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOptions() {
        this.optionsCase_ = 0;
        this.options_ = null;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.BucketOptions getDefaultInstanceForType() {
        return Distribution.BucketOptions.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.e;
      }
      
      public Distribution.BucketOptions.Explicit getExplicitBuckets() {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)this.options_ : Distribution.BucketOptions.Explicit.getDefaultInstance()) : ((this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Explicit.getDefaultInstance());
      }
      
      public Distribution.BucketOptions.Explicit.Builder getExplicitBucketsBuilder() {
        return (Distribution.BucketOptions.Explicit.Builder)getExplicitBucketsFieldBuilder().getBuilder();
      }
      
      public Distribution.BucketOptions.ExplicitOrBuilder getExplicitBucketsOrBuilder() {
        if (this.optionsCase_ == 3) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
          if (singleFieldBuilderV3 != null)
            return (Distribution.BucketOptions.ExplicitOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        } 
        return (this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)this.options_ : Distribution.BucketOptions.Explicit.getDefaultInstance();
      }
      
      public Distribution.BucketOptions.Exponential getExponentialBuckets() {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)this.options_ : Distribution.BucketOptions.Exponential.getDefaultInstance()) : ((this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Exponential.getDefaultInstance());
      }
      
      public Distribution.BucketOptions.Exponential.Builder getExponentialBucketsBuilder() {
        return (Distribution.BucketOptions.Exponential.Builder)getExponentialBucketsFieldBuilder().getBuilder();
      }
      
      public Distribution.BucketOptions.ExponentialOrBuilder getExponentialBucketsOrBuilder() {
        if (this.optionsCase_ == 2) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
          if (singleFieldBuilderV3 != null)
            return (Distribution.BucketOptions.ExponentialOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        } 
        return (this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)this.options_ : Distribution.BucketOptions.Exponential.getDefaultInstance();
      }
      
      public Distribution.BucketOptions.Linear getLinearBuckets() {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)this.options_ : Distribution.BucketOptions.Linear.getDefaultInstance()) : ((this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Linear.getDefaultInstance());
      }
      
      public Distribution.BucketOptions.Linear.Builder getLinearBucketsBuilder() {
        return (Distribution.BucketOptions.Linear.Builder)getLinearBucketsFieldBuilder().getBuilder();
      }
      
      public Distribution.BucketOptions.LinearOrBuilder getLinearBucketsOrBuilder() {
        if (this.optionsCase_ == 1) {
          SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
          if (singleFieldBuilderV3 != null)
            return (Distribution.BucketOptions.LinearOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        } 
        return (this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)this.options_ : Distribution.BucketOptions.Linear.getDefaultInstance();
      }
      
      public Distribution.BucketOptions.OptionsCase getOptionsCase() {
        return Distribution.BucketOptions.OptionsCase.forNumber(this.optionsCase_);
      }
      
      public boolean hasExplicitBuckets() {
        return (this.optionsCase_ == 3);
      }
      
      public boolean hasExponentialBuckets() {
        return (this.optionsCase_ == 2);
      }
      
      public boolean hasLinearBuckets() {
        return (this.optionsCase_ == 1);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.f.ensureFieldAccessorsInitialized(Distribution.BucketOptions.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeExplicitBuckets(Distribution.BucketOptions.Explicit param2Explicit) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (this.optionsCase_ == 3 && this.options_ != Distribution.BucketOptions.Explicit.getDefaultInstance()) {
            this.options_ = Distribution.BucketOptions.Explicit.newBuilder((Distribution.BucketOptions.Explicit)this.options_).mergeFrom(param2Explicit).buildPartial();
          } else {
            this.options_ = param2Explicit;
          } 
          onChanged();
        } else {
          if (this.optionsCase_ == 3)
            singleFieldBuilderV3.mergeFrom((AbstractMessage)param2Explicit); 
          this.explicitBucketsBuilder_.setMessage((AbstractMessage)param2Explicit);
        } 
        this.optionsCase_ = 3;
        return this;
      }
      
      public Builder mergeExponentialBuckets(Distribution.BucketOptions.Exponential param2Exponential) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (this.optionsCase_ == 2 && this.options_ != Distribution.BucketOptions.Exponential.getDefaultInstance()) {
            this.options_ = Distribution.BucketOptions.Exponential.newBuilder((Distribution.BucketOptions.Exponential)this.options_).mergeFrom(param2Exponential).buildPartial();
          } else {
            this.options_ = param2Exponential;
          } 
          onChanged();
        } else {
          if (this.optionsCase_ == 2)
            singleFieldBuilderV3.mergeFrom((AbstractMessage)param2Exponential); 
          this.exponentialBucketsBuilder_.setMessage((AbstractMessage)param2Exponential);
        } 
        this.optionsCase_ = 2;
        return this;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions param2BucketOptions) {
        if (param2BucketOptions == Distribution.BucketOptions.getDefaultInstance())
          return this; 
        int i = Distribution.null.a[param2BucketOptions.getOptionsCase().ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i == 3)
              mergeExplicitBuckets(param2BucketOptions.getExplicitBuckets()); 
          } else {
            mergeExponentialBuckets(param2BucketOptions.getExponentialBuckets());
          } 
        } else {
          mergeLinearBuckets(param2BucketOptions.getLinearBuckets());
        } 
        mergeUnknownFields(param2BucketOptions.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions bucketOptions = (Distribution.BucketOptions)Distribution.BucketOptions.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions bucketOptions = (Distribution.BucketOptions)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.BucketOptions)
          return mergeFrom((Distribution.BucketOptions)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeLinearBuckets(Distribution.BucketOptions.Linear param2Linear) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (this.optionsCase_ == 1 && this.options_ != Distribution.BucketOptions.Linear.getDefaultInstance()) {
            this.options_ = Distribution.BucketOptions.Linear.newBuilder((Distribution.BucketOptions.Linear)this.options_).mergeFrom(param2Linear).buildPartial();
          } else {
            this.options_ = param2Linear;
          } 
          onChanged();
        } else {
          if (this.optionsCase_ == 1)
            singleFieldBuilderV3.mergeFrom((AbstractMessage)param2Linear); 
          this.linearBucketsBuilder_.setMessage((AbstractMessage)param2Linear);
        } 
        this.optionsCase_ = 1;
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit.Builder param2Builder) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.options_ = param2Builder.build();
          onChanged();
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        } 
        this.optionsCase_ = 3;
        return this;
      }
      
      public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit param2Explicit) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Explicit != null) {
            this.options_ = param2Explicit;
            onChanged();
          } else {
            throw new NullPointerException();
          } 
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Explicit);
        } 
        this.optionsCase_ = 3;
        return this;
      }
      
      public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential.Builder param2Builder) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.options_ = param2Builder.build();
          onChanged();
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        } 
        this.optionsCase_ = 2;
        return this;
      }
      
      public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential param2Exponential) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Exponential != null) {
            this.options_ = param2Exponential;
            onChanged();
          } else {
            throw new NullPointerException();
          } 
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Exponential);
        } 
        this.optionsCase_ = 2;
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setLinearBuckets(Distribution.BucketOptions.Linear.Builder param2Builder) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.options_ = param2Builder.build();
          onChanged();
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        } 
        this.optionsCase_ = 1;
        return this;
      }
      
      public Builder setLinearBuckets(Distribution.BucketOptions.Linear param2Linear) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Linear != null) {
            this.options_ = param2Linear;
            onChanged();
          } else {
            throw new NullPointerException();
          } 
        } else {
          singleFieldBuilderV3.setMessage((AbstractMessage)param2Linear);
        } 
        this.optionsCase_ = 1;
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
    
    public static final class Explicit extends GeneratedMessageV3 implements ExplicitOrBuilder {
      public static final int BOUNDS_FIELD_NUMBER = 1;
      
      private static final Explicit DEFAULT_INSTANCE = new Explicit();
      
      private static final Parser<Explicit> PARSER = (Parser<Explicit>)new AbstractParser<Explicit>() {
          public Distribution.BucketOptions.Explicit a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
            return new Distribution.BucketOptions.Explicit(param3CodedInputStream, param3ExtensionRegistryLite);
          }
        };
      
      private static final long serialVersionUID = 0L;
      
      private int boundsMemoizedSerializedSize = -1;
      
      private Internal.DoubleList bounds_;
      
      private byte memoizedIsInitialized = -1;
      
      private Explicit() {
        this.bounds_ = emptyDoubleList();
      }
      
      private Explicit(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (param2ExtensionRegistryLite != null) {
          UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
          boolean bool = false;
          int i = 0;
          while (!bool) {
            int j = i;
            int k = i;
            int m = i;
            try {
              int n = param2CodedInputStream.readTag();
              if (n != 0) {
                if (n != 9) {
                  if (n != 10) {
                    j = i;
                    k = i;
                    m = i;
                    if (!parseUnknownField(param2CodedInputStream, builder, param2ExtensionRegistryLite, n))
                      continue; 
                    continue;
                  } 
                  j = i;
                  k = i;
                  m = i;
                  int i1 = param2CodedInputStream.pushLimit(param2CodedInputStream.readRawVarint32());
                  n = i;
                  if ((i & 0x1) == 0) {
                    n = i;
                    j = i;
                    k = i;
                    m = i;
                    if (param2CodedInputStream.getBytesUntilLimit() > 0) {
                      j = i;
                      k = i;
                      m = i;
                      this.bounds_ = newDoubleList();
                      n = i | 0x1;
                    } 
                  } 
                  while (true) {
                    j = n;
                    k = n;
                    m = n;
                    if (param2CodedInputStream.getBytesUntilLimit() > 0) {
                      j = n;
                      k = n;
                      m = n;
                      this.bounds_.addDouble(param2CodedInputStream.readDouble());
                      continue;
                    } 
                    j = n;
                    k = n;
                    m = n;
                    break;
                  } 
                  param2CodedInputStream.popLimit(i1);
                  i = n;
                  continue;
                } 
                n = i;
                if ((i & 0x1) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.bounds_ = newDoubleList();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.bounds_.addDouble(param2CodedInputStream.readDouble());
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
              this.bounds_.makeImmutable(); 
            this.unknownFields = builder.build();
            makeExtensionsImmutable();
            throw param2CodedInputStream;
            bool = true;
          } 
          if ((i & 0x1) != 0)
            this.bounds_.makeImmutable(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          return;
        } 
        throw new NullPointerException();
      }
      
      private Explicit(GeneratedMessageV3.Builder<?> param2Builder) {
        super(param2Builder);
      }
      
      public static Explicit getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.k;
      }
      
      public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Explicit param2Explicit) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(param2Explicit);
      }
      
      public static Explicit parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Explicit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream);
      }
      
      public static Explicit parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ByteString);
      }
      
      public static Explicit parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream);
      }
      
      public static Explicit parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(InputStream param2InputStream) throws IOException {
        return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream);
      }
      
      public static Explicit parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(ByteBuffer param2ByteBuffer) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ByteBuffer);
      }
      
      public static Explicit parseFrom(ByteBuffer param2ByteBuffer, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ByteBuffer, param2ExtensionRegistryLite);
      }
      
      public static Explicit parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ArrayOfbyte);
      }
      
      public static Explicit parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Explicit)PARSER.parseFrom(param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Explicit> parser() {
        return PARSER;
      }
      
      public boolean equals(Object param2Object) {
        if (param2Object == this)
          return true; 
        if (!(param2Object instanceof Explicit))
          return super.equals(param2Object); 
        param2Object = param2Object;
        return !getBoundsList().equals(param2Object.getBoundsList()) ? false : (!!this.unknownFields.equals(((Explicit)param2Object).unknownFields));
      }
      
      public double getBounds(int param2Int) {
        return this.bounds_.getDouble(param2Int);
      }
      
      public int getBoundsCount() {
        return this.bounds_.size();
      }
      
      public List<Double> getBoundsList() {
        return (List<Double>)this.bounds_;
      }
      
      public Explicit getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
      }
      
      public Parser<Explicit> getParserForType() {
        return PARSER;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1)
          return i; 
        int k = getBoundsList().size() * 8;
        int j = k + 0;
        i = j;
        if (!getBoundsList().isEmpty())
          i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k); 
        this.boundsMemoizedSerializedSize = k;
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
        int j = 779 + getDescriptor().hashCode();
        int i = j;
        if (getBoundsCount() > 0)
          i = (j * 37 + 1) * 53 + getBoundsList().hashCode(); 
        i = i * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.l.ensureFieldAccessorsInitialized(Explicit.class, Builder.class);
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
      
      protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        return new Builder(param2BuilderParent);
      }
      
      public Builder toBuilder() {
        return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        getSerializedSize();
        if (getBoundsList().size() > 0) {
          param2CodedOutputStream.writeUInt32NoTag(10);
          param2CodedOutputStream.writeUInt32NoTag(this.boundsMemoizedSerializedSize);
        } 
        for (int i = 0; i < this.bounds_.size(); i++)
          param2CodedOutputStream.writeDoubleNoTag(this.bounds_.getDouble(i)); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.ExplicitOrBuilder {
        private int bitField0_;
        
        private Internal.DoubleList bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
        
        private Builder() {
          maybeForceBuilderInitialization();
        }
        
        private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
          super(param3BuilderParent);
          maybeForceBuilderInitialization();
        }
        
        private void ensureBoundsIsMutable() {
          if ((this.bitField0_ & 0x1) == 0) {
            this.bounds_ = Distribution.BucketOptions.Explicit.mutableCopy(this.bounds_);
            this.bitField0_ |= 0x1;
          } 
        }
        
        public static final Descriptors.Descriptor getDescriptor() {
          return DistributionProto.k;
        }
        
        private void maybeForceBuilderInitialization() {
          Distribution.BucketOptions.Explicit.alwaysUseFieldBuilders;
        }
        
        public Builder addAllBounds(Iterable<? extends Double> param3Iterable) {
          ensureBoundsIsMutable();
          AbstractMessageLite.Builder.addAll(param3Iterable, (List)this.bounds_);
          onChanged();
          return this;
        }
        
        public Builder addBounds(double param3Double) {
          ensureBoundsIsMutable();
          this.bounds_.addDouble(param3Double);
          onChanged();
          return this;
        }
        
        public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
        }
        
        public Distribution.BucketOptions.Explicit build() {
          Distribution.BucketOptions.Explicit explicit = buildPartial();
          if (explicit.isInitialized())
            return explicit; 
          throw newUninitializedMessageException(explicit);
        }
        
        public Distribution.BucketOptions.Explicit buildPartial() {
          Distribution.BucketOptions.Explicit explicit = new Distribution.BucketOptions.Explicit(this);
          if ((this.bitField0_ & 0x1) != 0) {
            this.bounds_.makeImmutable();
            this.bitField0_ &= 0xFFFFFFFE;
          } 
          Distribution.BucketOptions.Explicit.access$3402(explicit, this.bounds_);
          onBuilt();
          return explicit;
        }
        
        public Builder clear() {
          super.clear();
          this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
          this.bitField0_ &= 0xFFFFFFFE;
          return this;
        }
        
        public Builder clearBounds() {
          this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
          this.bitField0_ &= 0xFFFFFFFE;
          onChanged();
          return this;
        }
        
        public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
          return (Builder)super.clearField(param3FieldDescriptor);
        }
        
        public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
          return (Builder)super.clearOneof(param3OneofDescriptor);
        }
        
        public Builder clone() {
          return (Builder)super.clone();
        }
        
        public double getBounds(int param3Int) {
          return this.bounds_.getDouble(param3Int);
        }
        
        public int getBoundsCount() {
          return this.bounds_.size();
        }
        
        public List<Double> getBoundsList() {
          return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.bounds_) : this.bounds_);
        }
        
        public Distribution.BucketOptions.Explicit getDefaultInstanceForType() {
          return Distribution.BucketOptions.Explicit.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType() {
          return DistributionProto.k;
        }
        
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
          return DistributionProto.l.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Explicit.class, Builder.class);
        }
        
        public final boolean isInitialized() {
          return true;
        }
        
        public Builder mergeFrom(Distribution.BucketOptions.Explicit param3Explicit) {
          if (param3Explicit == Distribution.BucketOptions.Explicit.getDefaultInstance())
            return this; 
          if (!param3Explicit.bounds_.isEmpty()) {
            if (this.bounds_.isEmpty()) {
              this.bounds_ = param3Explicit.bounds_;
              this.bitField0_ &= 0xFFFFFFFE;
            } else {
              ensureBoundsIsMutable();
              this.bounds_.addAll((Collection)param3Explicit.bounds_);
            } 
            onChanged();
          } 
          mergeUnknownFields(param3Explicit.unknownFields);
          onChanged();
          return this;
        }
        
        public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
          CodedInputStream codedInputStream = null;
          try {
            Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)Distribution.BucketOptions.Explicit.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
            return this;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)invalidProtocolBufferException.getUnfinishedMessage();
          } finally {
            param3ExtensionRegistryLite = null;
          } 
          if (param3CodedInputStream != null)
            mergeFrom((Distribution.BucketOptions.Explicit)param3CodedInputStream); 
          throw param3ExtensionRegistryLite;
        }
        
        public Builder mergeFrom(Message param3Message) {
          if (param3Message instanceof Distribution.BucketOptions.Explicit)
            return mergeFrom((Distribution.BucketOptions.Explicit)param3Message); 
          super.mergeFrom(param3Message);
          return this;
        }
        
        public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
        }
        
        public Builder setBounds(int param3Int, double param3Double) {
          ensureBoundsIsMutable();
          this.bounds_.setDouble(param3Int, param3Double);
          onChanged();
          return this;
        }
        
        public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.setField(param3FieldDescriptor, param3Object);
        }
        
        public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
          return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
        }
        
        public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.setUnknownFields(param3UnknownFieldSet);
        }
      }
    }
    
    static final class null extends AbstractParser<Explicit> {
      public Distribution.BucketOptions.Explicit a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Distribution.BucketOptions.Explicit(param2CodedInputStream, param2ExtensionRegistryLite);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Explicit.Builder> implements ExplicitOrBuilder {
      private int bitField0_;
      
      private Internal.DoubleList bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureBoundsIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.bounds_ = Distribution.BucketOptions.Explicit.mutableCopy(this.bounds_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.k;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Explicit.alwaysUseFieldBuilders;
      }
      
      public Builder addAllBounds(Iterable<? extends Double> param2Iterable) {
        ensureBoundsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.bounds_);
        onChanged();
        return this;
      }
      
      public Builder addBounds(double param2Double) {
        ensureBoundsIsMutable();
        this.bounds_.addDouble(param2Double);
        onChanged();
        return this;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.BucketOptions.Explicit build() {
        Distribution.BucketOptions.Explicit explicit = buildPartial();
        if (explicit.isInitialized())
          return explicit; 
        throw newUninitializedMessageException(explicit);
      }
      
      public Distribution.BucketOptions.Explicit buildPartial() {
        Distribution.BucketOptions.Explicit explicit = new Distribution.BucketOptions.Explicit(this);
        if ((this.bitField0_ & 0x1) != 0) {
          this.bounds_.makeImmutable();
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Distribution.BucketOptions.Explicit.access$3402(explicit, this.bounds_);
        onBuilt();
        return explicit;
      }
      
      public Builder clear() {
        super.clear();
        this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      }
      
      public Builder clearBounds() {
        this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public double getBounds(int param2Int) {
        return this.bounds_.getDouble(param2Int);
      }
      
      public int getBoundsCount() {
        return this.bounds_.size();
      }
      
      public List<Double> getBoundsList() {
        return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.bounds_) : this.bounds_);
      }
      
      public Distribution.BucketOptions.Explicit getDefaultInstanceForType() {
        return Distribution.BucketOptions.Explicit.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.k;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.l.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Explicit.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Explicit param2Explicit) {
        if (param2Explicit == Distribution.BucketOptions.Explicit.getDefaultInstance())
          return this; 
        if (!param2Explicit.bounds_.isEmpty()) {
          if (this.bounds_.isEmpty()) {
            this.bounds_ = param2Explicit.bounds_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureBoundsIsMutable();
            this.bounds_.addAll((Collection)param2Explicit.bounds_);
          } 
          onChanged();
        } 
        mergeUnknownFields(param2Explicit.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)Distribution.BucketOptions.Explicit.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Explicit)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.BucketOptions.Explicit)
          return mergeFrom((Distribution.BucketOptions.Explicit)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBounds(int param2Int, double param2Double) {
        ensureBoundsIsMutable();
        this.bounds_.setDouble(param2Int, param2Double);
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
    
    public static interface ExplicitOrBuilder extends MessageOrBuilder {
      double getBounds(int param2Int);
      
      int getBoundsCount();
      
      List<Double> getBoundsList();
    }
    
    public static final class Exponential extends GeneratedMessageV3 implements ExponentialOrBuilder {
      private static final Exponential DEFAULT_INSTANCE = new Exponential();
      
      public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
      
      public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
      
      private static final Parser<Exponential> PARSER = (Parser<Exponential>)new AbstractParser<Exponential>() {
          public Distribution.BucketOptions.Exponential a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
            return new Distribution.BucketOptions.Exponential(param3CodedInputStream, param3ExtensionRegistryLite);
          }
        };
      
      public static final int SCALE_FIELD_NUMBER = 3;
      
      private static final long serialVersionUID = 0L;
      
      private double growthFactor_;
      
      private byte memoizedIsInitialized = -1;
      
      private int numFiniteBuckets_;
      
      private double scale_;
      
      private Exponential() {}
      
      private Exponential(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (param2ExtensionRegistryLite != null) {
          UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
          for (boolean bool = false; !bool; bool = true) {
            try {
              int i = param2CodedInputStream.readTag();
              if (i != 0) {
                if (i != 8) {
                  if (i != 17) {
                    if (i != 25) {
                      if (!parseUnknownField(param2CodedInputStream, builder, param2ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.scale_ = param2CodedInputStream.readDouble();
                    continue;
                  } 
                  this.growthFactor_ = param2CodedInputStream.readDouble();
                  continue;
                } 
                this.numFiniteBuckets_ = param2CodedInputStream.readInt32();
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
            throw param2CodedInputStream;
          } 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          return;
        } 
        throw new NullPointerException();
      }
      
      private Exponential(GeneratedMessageV3.Builder<?> param2Builder) {
        super(param2Builder);
      }
      
      public static Exponential getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.i;
      }
      
      public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Exponential param2Exponential) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(param2Exponential);
      }
      
      public static Exponential parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Exponential)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream);
      }
      
      public static Exponential parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ByteString);
      }
      
      public static Exponential parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream);
      }
      
      public static Exponential parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(InputStream param2InputStream) throws IOException {
        return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream);
      }
      
      public static Exponential parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(ByteBuffer param2ByteBuffer) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ByteBuffer);
      }
      
      public static Exponential parseFrom(ByteBuffer param2ByteBuffer, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ByteBuffer, param2ExtensionRegistryLite);
      }
      
      public static Exponential parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ArrayOfbyte);
      }
      
      public static Exponential parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Exponential)PARSER.parseFrom(param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Exponential> parser() {
        return PARSER;
      }
      
      public boolean equals(Object param2Object) {
        if (param2Object == this)
          return true; 
        if (!(param2Object instanceof Exponential))
          return super.equals(param2Object); 
        param2Object = param2Object;
        return (getNumFiniteBuckets() != param2Object.getNumFiniteBuckets()) ? false : ((Double.doubleToLongBits(getGrowthFactor()) != Double.doubleToLongBits(param2Object.getGrowthFactor())) ? false : ((Double.doubleToLongBits(getScale()) != Double.doubleToLongBits(param2Object.getScale())) ? false : (!!this.unknownFields.equals(((Exponential)param2Object).unknownFields))));
      }
      
      public Exponential getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
      }
      
      public double getGrowthFactor() {
        return this.growthFactor_;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public Parser<Exponential> getParserForType() {
        return PARSER;
      }
      
      public double getScale() {
        return this.scale_;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1)
          return i; 
        i = 0;
        int j = this.numFiniteBuckets_;
        if (j != 0)
          i = 0 + CodedOutputStream.computeInt32Size(1, j); 
        double d = this.growthFactor_;
        j = i;
        if (d != 0.0D)
          j = i + CodedOutputStream.computeDoubleSize(2, d); 
        d = this.scale_;
        i = j;
        if (d != 0.0D)
          i = j + CodedOutputStream.computeDoubleSize(3, d); 
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
        int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getNumFiniteBuckets()) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getGrowthFactor()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getScale()))) * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.j.ensureFieldAccessorsInitialized(Exponential.class, Builder.class);
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
      
      protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        return new Builder(param2BuilderParent);
      }
      
      public Builder toBuilder() {
        return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        int i = this.numFiniteBuckets_;
        if (i != 0)
          param2CodedOutputStream.writeInt32(1, i); 
        double d = this.growthFactor_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(2, d); 
        d = this.scale_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(3, d); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.ExponentialOrBuilder {
        private double growthFactor_;
        
        private int numFiniteBuckets_;
        
        private double scale_;
        
        private Builder() {
          maybeForceBuilderInitialization();
        }
        
        private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
          super(param3BuilderParent);
          maybeForceBuilderInitialization();
        }
        
        public static final Descriptors.Descriptor getDescriptor() {
          return DistributionProto.i;
        }
        
        private void maybeForceBuilderInitialization() {
          Distribution.BucketOptions.Exponential.alwaysUseFieldBuilders;
        }
        
        public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
        }
        
        public Distribution.BucketOptions.Exponential build() {
          Distribution.BucketOptions.Exponential exponential = buildPartial();
          if (exponential.isInitialized())
            return exponential; 
          throw newUninitializedMessageException(exponential);
        }
        
        public Distribution.BucketOptions.Exponential buildPartial() {
          Distribution.BucketOptions.Exponential exponential = new Distribution.BucketOptions.Exponential(this);
          Distribution.BucketOptions.Exponential.access$2302(exponential, this.numFiniteBuckets_);
          Distribution.BucketOptions.Exponential.access$2402(exponential, this.growthFactor_);
          Distribution.BucketOptions.Exponential.access$2502(exponential, this.scale_);
          onBuilt();
          return exponential;
        }
        
        public Builder clear() {
          super.clear();
          this.numFiniteBuckets_ = 0;
          this.growthFactor_ = 0.0D;
          this.scale_ = 0.0D;
          return this;
        }
        
        public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
          return (Builder)super.clearField(param3FieldDescriptor);
        }
        
        public Builder clearGrowthFactor() {
          this.growthFactor_ = 0.0D;
          onChanged();
          return this;
        }
        
        public Builder clearNumFiniteBuckets() {
          this.numFiniteBuckets_ = 0;
          onChanged();
          return this;
        }
        
        public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
          return (Builder)super.clearOneof(param3OneofDescriptor);
        }
        
        public Builder clearScale() {
          this.scale_ = 0.0D;
          onChanged();
          return this;
        }
        
        public Builder clone() {
          return (Builder)super.clone();
        }
        
        public Distribution.BucketOptions.Exponential getDefaultInstanceForType() {
          return Distribution.BucketOptions.Exponential.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType() {
          return DistributionProto.i;
        }
        
        public double getGrowthFactor() {
          return this.growthFactor_;
        }
        
        public int getNumFiniteBuckets() {
          return this.numFiniteBuckets_;
        }
        
        public double getScale() {
          return this.scale_;
        }
        
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
          return DistributionProto.j.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Exponential.class, Builder.class);
        }
        
        public final boolean isInitialized() {
          return true;
        }
        
        public Builder mergeFrom(Distribution.BucketOptions.Exponential param3Exponential) {
          if (param3Exponential == Distribution.BucketOptions.Exponential.getDefaultInstance())
            return this; 
          if (param3Exponential.getNumFiniteBuckets() != 0)
            setNumFiniteBuckets(param3Exponential.getNumFiniteBuckets()); 
          if (param3Exponential.getGrowthFactor() != 0.0D)
            setGrowthFactor(param3Exponential.getGrowthFactor()); 
          if (param3Exponential.getScale() != 0.0D)
            setScale(param3Exponential.getScale()); 
          mergeUnknownFields(param3Exponential.unknownFields);
          onChanged();
          return this;
        }
        
        public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
          CodedInputStream codedInputStream = null;
          try {
            Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)Distribution.BucketOptions.Exponential.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
            return this;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)invalidProtocolBufferException.getUnfinishedMessage();
          } finally {
            param3ExtensionRegistryLite = null;
          } 
          if (param3CodedInputStream != null)
            mergeFrom((Distribution.BucketOptions.Exponential)param3CodedInputStream); 
          throw param3ExtensionRegistryLite;
        }
        
        public Builder mergeFrom(Message param3Message) {
          if (param3Message instanceof Distribution.BucketOptions.Exponential)
            return mergeFrom((Distribution.BucketOptions.Exponential)param3Message); 
          super.mergeFrom(param3Message);
          return this;
        }
        
        public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
        }
        
        public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.setField(param3FieldDescriptor, param3Object);
        }
        
        public Builder setGrowthFactor(double param3Double) {
          this.growthFactor_ = param3Double;
          onChanged();
          return this;
        }
        
        public Builder setNumFiniteBuckets(int param3Int) {
          this.numFiniteBuckets_ = param3Int;
          onChanged();
          return this;
        }
        
        public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
          return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
        }
        
        public Builder setScale(double param3Double) {
          this.scale_ = param3Double;
          onChanged();
          return this;
        }
        
        public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.setUnknownFields(param3UnknownFieldSet);
        }
      }
    }
    
    static final class null extends AbstractParser<Exponential> {
      public Distribution.BucketOptions.Exponential a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Distribution.BucketOptions.Exponential(param2CodedInputStream, param2ExtensionRegistryLite);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Exponential.Builder> implements ExponentialOrBuilder {
      private double growthFactor_;
      
      private int numFiniteBuckets_;
      
      private double scale_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.i;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Exponential.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.BucketOptions.Exponential build() {
        Distribution.BucketOptions.Exponential exponential = buildPartial();
        if (exponential.isInitialized())
          return exponential; 
        throw newUninitializedMessageException(exponential);
      }
      
      public Distribution.BucketOptions.Exponential buildPartial() {
        Distribution.BucketOptions.Exponential exponential = new Distribution.BucketOptions.Exponential(this);
        Distribution.BucketOptions.Exponential.access$2302(exponential, this.numFiniteBuckets_);
        Distribution.BucketOptions.Exponential.access$2402(exponential, this.growthFactor_);
        Distribution.BucketOptions.Exponential.access$2502(exponential, this.scale_);
        onBuilt();
        return exponential;
      }
      
      public Builder clear() {
        super.clear();
        this.numFiniteBuckets_ = 0;
        this.growthFactor_ = 0.0D;
        this.scale_ = 0.0D;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearGrowthFactor() {
        this.growthFactor_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearScale() {
        this.scale_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.BucketOptions.Exponential getDefaultInstanceForType() {
        return Distribution.BucketOptions.Exponential.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.i;
      }
      
      public double getGrowthFactor() {
        return this.growthFactor_;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getScale() {
        return this.scale_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.j.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Exponential.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Exponential param2Exponential) {
        if (param2Exponential == Distribution.BucketOptions.Exponential.getDefaultInstance())
          return this; 
        if (param2Exponential.getNumFiniteBuckets() != 0)
          setNumFiniteBuckets(param2Exponential.getNumFiniteBuckets()); 
        if (param2Exponential.getGrowthFactor() != 0.0D)
          setGrowthFactor(param2Exponential.getGrowthFactor()); 
        if (param2Exponential.getScale() != 0.0D)
          setScale(param2Exponential.getScale()); 
        mergeUnknownFields(param2Exponential.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)Distribution.BucketOptions.Exponential.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Exponential)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.BucketOptions.Exponential)
          return mergeFrom((Distribution.BucketOptions.Exponential)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setGrowthFactor(double param2Double) {
        this.growthFactor_ = param2Double;
        onChanged();
        return this;
      }
      
      public Builder setNumFiniteBuckets(int param2Int) {
        this.numFiniteBuckets_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setScale(double param2Double) {
        this.scale_ = param2Double;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
    
    public static interface ExponentialOrBuilder extends MessageOrBuilder {
      double getGrowthFactor();
      
      int getNumFiniteBuckets();
      
      double getScale();
    }
    
    public static final class Linear extends GeneratedMessageV3 implements LinearOrBuilder {
      private static final Linear DEFAULT_INSTANCE = new Linear();
      
      public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
      
      public static final int OFFSET_FIELD_NUMBER = 3;
      
      private static final Parser<Linear> PARSER = (Parser<Linear>)new AbstractParser<Linear>() {
          public Distribution.BucketOptions.Linear a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
            return new Distribution.BucketOptions.Linear(param3CodedInputStream, param3ExtensionRegistryLite);
          }
        };
      
      public static final int WIDTH_FIELD_NUMBER = 2;
      
      private static final long serialVersionUID = 0L;
      
      private byte memoizedIsInitialized = -1;
      
      private int numFiniteBuckets_;
      
      private double offset_;
      
      private double width_;
      
      private Linear() {}
      
      private Linear(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (param2ExtensionRegistryLite != null) {
          UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
          for (boolean bool = false; !bool; bool = true) {
            try {
              int i = param2CodedInputStream.readTag();
              if (i != 0) {
                if (i != 8) {
                  if (i != 17) {
                    if (i != 25) {
                      if (!parseUnknownField(param2CodedInputStream, builder, param2ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.offset_ = param2CodedInputStream.readDouble();
                    continue;
                  } 
                  this.width_ = param2CodedInputStream.readDouble();
                  continue;
                } 
                this.numFiniteBuckets_ = param2CodedInputStream.readInt32();
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
            throw param2CodedInputStream;
          } 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          return;
        } 
        throw new NullPointerException();
      }
      
      private Linear(GeneratedMessageV3.Builder<?> param2Builder) {
        super(param2Builder);
      }
      
      public static Linear getDefaultInstance() {
        return DEFAULT_INSTANCE;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.g;
      }
      
      public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
      }
      
      public static Builder newBuilder(Linear param2Linear) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(param2Linear);
      }
      
      public static Linear parseDelimitedFrom(InputStream param2InputStream) throws IOException {
        return (Linear)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream);
      }
      
      public static Linear parseDelimitedFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(ByteString param2ByteString) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ByteString);
      }
      
      public static Linear parseFrom(ByteString param2ByteString, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ByteString, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(CodedInputStream param2CodedInputStream) throws IOException {
        return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream);
      }
      
      public static Linear parseFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param2CodedInputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(InputStream param2InputStream) throws IOException {
        return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream);
      }
      
      public static Linear parseFrom(InputStream param2InputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param2InputStream, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(ByteBuffer param2ByteBuffer) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ByteBuffer);
      }
      
      public static Linear parseFrom(ByteBuffer param2ByteBuffer, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ByteBuffer, param2ExtensionRegistryLite);
      }
      
      public static Linear parseFrom(byte[] param2ArrayOfbyte) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ArrayOfbyte);
      }
      
      public static Linear parseFrom(byte[] param2ArrayOfbyte, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return (Linear)PARSER.parseFrom(param2ArrayOfbyte, param2ExtensionRegistryLite);
      }
      
      public static Parser<Linear> parser() {
        return PARSER;
      }
      
      public boolean equals(Object param2Object) {
        if (param2Object == this)
          return true; 
        if (!(param2Object instanceof Linear))
          return super.equals(param2Object); 
        param2Object = param2Object;
        return (getNumFiniteBuckets() != param2Object.getNumFiniteBuckets()) ? false : ((Double.doubleToLongBits(getWidth()) != Double.doubleToLongBits(param2Object.getWidth())) ? false : ((Double.doubleToLongBits(getOffset()) != Double.doubleToLongBits(param2Object.getOffset())) ? false : (!!this.unknownFields.equals(((Linear)param2Object).unknownFields))));
      }
      
      public Linear getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getOffset() {
        return this.offset_;
      }
      
      public Parser<Linear> getParserForType() {
        return PARSER;
      }
      
      public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1)
          return i; 
        i = 0;
        int j = this.numFiniteBuckets_;
        if (j != 0)
          i = 0 + CodedOutputStream.computeInt32Size(1, j); 
        double d = this.width_;
        j = i;
        if (d != 0.0D)
          j = i + CodedOutputStream.computeDoubleSize(2, d); 
        d = this.offset_;
        i = j;
        if (d != 0.0D)
          i = j + CodedOutputStream.computeDoubleSize(3, d); 
        i += this.unknownFields.getSerializedSize();
        this.memoizedSize = i;
        return i;
      }
      
      public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
      }
      
      public double getWidth() {
        return this.width_;
      }
      
      public int hashCode() {
        if (this.memoizedHashCode != 0)
          return this.memoizedHashCode; 
        int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getNumFiniteBuckets()) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getWidth()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getOffset()))) * 29 + this.unknownFields.hashCode();
        this.memoizedHashCode = i;
        return i;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.h.ensureFieldAccessorsInitialized(Linear.class, Builder.class);
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
      
      protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        return new Builder(param2BuilderParent);
      }
      
      public Builder toBuilder() {
        return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
      }
      
      public void writeTo(CodedOutputStream param2CodedOutputStream) throws IOException {
        int i = this.numFiniteBuckets_;
        if (i != 0)
          param2CodedOutputStream.writeInt32(1, i); 
        double d = this.width_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(2, d); 
        d = this.offset_;
        if (d != 0.0D)
          param2CodedOutputStream.writeDouble(3, d); 
        this.unknownFields.writeTo(param2CodedOutputStream);
      }
      
      public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.LinearOrBuilder {
        private int numFiniteBuckets_;
        
        private double offset_;
        
        private double width_;
        
        private Builder() {
          maybeForceBuilderInitialization();
        }
        
        private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
          super(param3BuilderParent);
          maybeForceBuilderInitialization();
        }
        
        public static final Descriptors.Descriptor getDescriptor() {
          return DistributionProto.g;
        }
        
        private void maybeForceBuilderInitialization() {
          Distribution.BucketOptions.Linear.alwaysUseFieldBuilders;
        }
        
        public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
        }
        
        public Distribution.BucketOptions.Linear build() {
          Distribution.BucketOptions.Linear linear = buildPartial();
          if (linear.isInitialized())
            return linear; 
          throw newUninitializedMessageException(linear);
        }
        
        public Distribution.BucketOptions.Linear buildPartial() {
          Distribution.BucketOptions.Linear linear = new Distribution.BucketOptions.Linear(this);
          Distribution.BucketOptions.Linear.access$1302(linear, this.numFiniteBuckets_);
          Distribution.BucketOptions.Linear.access$1402(linear, this.width_);
          Distribution.BucketOptions.Linear.access$1502(linear, this.offset_);
          onBuilt();
          return linear;
        }
        
        public Builder clear() {
          super.clear();
          this.numFiniteBuckets_ = 0;
          this.width_ = 0.0D;
          this.offset_ = 0.0D;
          return this;
        }
        
        public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
          return (Builder)super.clearField(param3FieldDescriptor);
        }
        
        public Builder clearNumFiniteBuckets() {
          this.numFiniteBuckets_ = 0;
          onChanged();
          return this;
        }
        
        public Builder clearOffset() {
          this.offset_ = 0.0D;
          onChanged();
          return this;
        }
        
        public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
          return (Builder)super.clearOneof(param3OneofDescriptor);
        }
        
        public Builder clearWidth() {
          this.width_ = 0.0D;
          onChanged();
          return this;
        }
        
        public Builder clone() {
          return (Builder)super.clone();
        }
        
        public Distribution.BucketOptions.Linear getDefaultInstanceForType() {
          return Distribution.BucketOptions.Linear.getDefaultInstance();
        }
        
        public Descriptors.Descriptor getDescriptorForType() {
          return DistributionProto.g;
        }
        
        public int getNumFiniteBuckets() {
          return this.numFiniteBuckets_;
        }
        
        public double getOffset() {
          return this.offset_;
        }
        
        public double getWidth() {
          return this.width_;
        }
        
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
          return DistributionProto.h.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Linear.class, Builder.class);
        }
        
        public final boolean isInitialized() {
          return true;
        }
        
        public Builder mergeFrom(Distribution.BucketOptions.Linear param3Linear) {
          if (param3Linear == Distribution.BucketOptions.Linear.getDefaultInstance())
            return this; 
          if (param3Linear.getNumFiniteBuckets() != 0)
            setNumFiniteBuckets(param3Linear.getNumFiniteBuckets()); 
          if (param3Linear.getWidth() != 0.0D)
            setWidth(param3Linear.getWidth()); 
          if (param3Linear.getOffset() != 0.0D)
            setOffset(param3Linear.getOffset()); 
          mergeUnknownFields(param3Linear.unknownFields);
          onChanged();
          return this;
        }
        
        public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
          CodedInputStream codedInputStream = null;
          try {
            Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)Distribution.BucketOptions.Linear.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
            return this;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)invalidProtocolBufferException.getUnfinishedMessage();
          } finally {
            param3ExtensionRegistryLite = null;
          } 
          if (param3CodedInputStream != null)
            mergeFrom((Distribution.BucketOptions.Linear)param3CodedInputStream); 
          throw param3ExtensionRegistryLite;
        }
        
        public Builder mergeFrom(Message param3Message) {
          if (param3Message instanceof Distribution.BucketOptions.Linear)
            return mergeFrom((Distribution.BucketOptions.Linear)param3Message); 
          super.mergeFrom(param3Message);
          return this;
        }
        
        public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
        }
        
        public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
          return (Builder)super.setField(param3FieldDescriptor, param3Object);
        }
        
        public Builder setNumFiniteBuckets(int param3Int) {
          this.numFiniteBuckets_ = param3Int;
          onChanged();
          return this;
        }
        
        public Builder setOffset(double param3Double) {
          this.offset_ = param3Double;
          onChanged();
          return this;
        }
        
        public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
          return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
        }
        
        public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
          return (Builder)super.setUnknownFields(param3UnknownFieldSet);
        }
        
        public Builder setWidth(double param3Double) {
          this.width_ = param3Double;
          onChanged();
          return this;
        }
      }
    }
    
    static final class null extends AbstractParser<Linear> {
      public Distribution.BucketOptions.Linear a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Distribution.BucketOptions.Linear(param2CodedInputStream, param2ExtensionRegistryLite);
      }
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Linear.Builder> implements LinearOrBuilder {
      private int numFiniteBuckets_;
      
      private double offset_;
      
      private double width_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.g;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Linear.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.BucketOptions.Linear build() {
        Distribution.BucketOptions.Linear linear = buildPartial();
        if (linear.isInitialized())
          return linear; 
        throw newUninitializedMessageException(linear);
      }
      
      public Distribution.BucketOptions.Linear buildPartial() {
        Distribution.BucketOptions.Linear linear = new Distribution.BucketOptions.Linear(this);
        Distribution.BucketOptions.Linear.access$1302(linear, this.numFiniteBuckets_);
        Distribution.BucketOptions.Linear.access$1402(linear, this.width_);
        Distribution.BucketOptions.Linear.access$1502(linear, this.offset_);
        onBuilt();
        return linear;
      }
      
      public Builder clear() {
        super.clear();
        this.numFiniteBuckets_ = 0;
        this.width_ = 0.0D;
        this.offset_ = 0.0D;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOffset() {
        this.offset_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearWidth() {
        this.width_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.BucketOptions.Linear getDefaultInstanceForType() {
        return Distribution.BucketOptions.Linear.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.g;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getOffset() {
        return this.offset_;
      }
      
      public double getWidth() {
        return this.width_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.h.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Linear.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Linear param2Linear) {
        if (param2Linear == Distribution.BucketOptions.Linear.getDefaultInstance())
          return this; 
        if (param2Linear.getNumFiniteBuckets() != 0)
          setNumFiniteBuckets(param2Linear.getNumFiniteBuckets()); 
        if (param2Linear.getWidth() != 0.0D)
          setWidth(param2Linear.getWidth()); 
        if (param2Linear.getOffset() != 0.0D)
          setOffset(param2Linear.getOffset()); 
        mergeUnknownFields(param2Linear.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)Distribution.BucketOptions.Linear.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Linear)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.BucketOptions.Linear)
          return mergeFrom((Distribution.BucketOptions.Linear)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setNumFiniteBuckets(int param2Int) {
        this.numFiniteBuckets_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOffset(double param2Double) {
        this.offset_ = param2Double;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setWidth(double param2Double) {
        this.width_ = param2Double;
        onChanged();
        return this;
      }
    }
    
    public static interface LinearOrBuilder extends MessageOrBuilder {
      int getNumFiniteBuckets();
      
      double getOffset();
      
      double getWidth();
    }
    
    public enum OptionsCase implements Internal.EnumLite {
      EXPLICIT_BUCKETS,
      EXPONENTIAL_BUCKETS,
      LINEAR_BUCKETS(1),
      OPTIONS_NOT_SET(1);
      
      private final int value;
      
      static {
        $VALUES = new OptionsCase[] { LINEAR_BUCKETS, EXPONENTIAL_BUCKETS, EXPLICIT_BUCKETS, OPTIONS_NOT_SET };
      }
      
      OptionsCase(int param2Int1) {
        this.value = param2Int1;
      }
      
      public static OptionsCase forNumber(int param2Int) {
        return (param2Int != 0) ? ((param2Int != 1) ? ((param2Int != 2) ? ((param2Int != 3) ? null : EXPLICIT_BUCKETS) : EXPONENTIAL_BUCKETS) : LINEAR_BUCKETS) : OPTIONS_NOT_SET;
      }
      
      public int getNumber() {
        return this.value;
      }
    }
  }
  
  static final class null extends AbstractParser<BucketOptions> {
    public Distribution.BucketOptions a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.BucketOptions(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<BucketOptions.Builder> implements BucketOptionsOrBuilder {
    private SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> explicitBucketsBuilder_;
    
    private SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> exponentialBucketsBuilder_;
    
    private SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> linearBucketsBuilder_;
    
    private int optionsCase_ = 0;
    
    private Object options_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.e;
    }
    
    private SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> getExplicitBucketsFieldBuilder() {
      if (this.explicitBucketsBuilder_ == null) {
        if (this.optionsCase_ != 3)
          this.options_ = Distribution.BucketOptions.Explicit.getDefaultInstance(); 
        this.explicitBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.options_ = null;
      } 
      this.optionsCase_ = 3;
      onChanged();
      return this.explicitBucketsBuilder_;
    }
    
    private SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> getExponentialBucketsFieldBuilder() {
      if (this.exponentialBucketsBuilder_ == null) {
        if (this.optionsCase_ != 2)
          this.options_ = Distribution.BucketOptions.Exponential.getDefaultInstance(); 
        this.exponentialBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.options_ = null;
      } 
      this.optionsCase_ = 2;
      onChanged();
      return this.exponentialBucketsBuilder_;
    }
    
    private SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> getLinearBucketsFieldBuilder() {
      if (this.linearBucketsBuilder_ == null) {
        if (this.optionsCase_ != 1)
          this.options_ = Distribution.BucketOptions.Linear.getDefaultInstance(); 
        this.linearBucketsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)this.options_, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.options_ = null;
      } 
      this.optionsCase_ = 1;
      onChanged();
      return this.linearBucketsBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      Distribution.BucketOptions.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.BucketOptions build() {
      Distribution.BucketOptions bucketOptions = buildPartial();
      if (bucketOptions.isInitialized())
        return bucketOptions; 
      throw newUninitializedMessageException(bucketOptions);
    }
    
    public Distribution.BucketOptions buildPartial() {
      Distribution.BucketOptions bucketOptions = new Distribution.BucketOptions(this);
      if (this.optionsCase_ == 1) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
        } else {
          Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
        } 
      } 
      if (this.optionsCase_ == 2) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
        } else {
          Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
        } 
      } 
      if (this.optionsCase_ == 3) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        if (singleFieldBuilderV3 == null) {
          Distribution.BucketOptions.access$4502(bucketOptions, this.options_);
        } else {
          Distribution.BucketOptions.access$4502(bucketOptions, singleFieldBuilderV3.build());
        } 
      } 
      Distribution.BucketOptions.access$4602(bucketOptions, this.optionsCase_);
      onBuilt();
      return bucketOptions;
    }
    
    public Builder clear() {
      super.clear();
      this.optionsCase_ = 0;
      this.options_ = null;
      return this;
    }
    
    public Builder clearExplicitBuckets() {
      if (this.explicitBucketsBuilder_ == null) {
        if (this.optionsCase_ == 3) {
          this.optionsCase_ = 0;
          this.options_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.optionsCase_ == 3) {
          this.optionsCase_ = 0;
          this.options_ = null;
        } 
        this.explicitBucketsBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearExponentialBuckets() {
      if (this.exponentialBucketsBuilder_ == null) {
        if (this.optionsCase_ == 2) {
          this.optionsCase_ = 0;
          this.options_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.optionsCase_ == 2) {
          this.optionsCase_ = 0;
          this.options_ = null;
        } 
        this.exponentialBucketsBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLinearBuckets() {
      if (this.linearBucketsBuilder_ == null) {
        if (this.optionsCase_ == 1) {
          this.optionsCase_ = 0;
          this.options_ = null;
          onChanged();
          return this;
        } 
      } else {
        if (this.optionsCase_ == 1) {
          this.optionsCase_ = 0;
          this.options_ = null;
        } 
        this.linearBucketsBuilder_.clear();
      } 
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOptions() {
      this.optionsCase_ = 0;
      this.options_ = null;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Distribution.BucketOptions getDefaultInstanceForType() {
      return Distribution.BucketOptions.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.e;
    }
    
    public Distribution.BucketOptions.Explicit getExplicitBuckets() {
      SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)this.options_ : Distribution.BucketOptions.Explicit.getDefaultInstance()) : ((this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Explicit.getDefaultInstance());
    }
    
    public Distribution.BucketOptions.Explicit.Builder getExplicitBucketsBuilder() {
      return (Distribution.BucketOptions.Explicit.Builder)getExplicitBucketsFieldBuilder().getBuilder();
    }
    
    public Distribution.BucketOptions.ExplicitOrBuilder getExplicitBucketsOrBuilder() {
      if (this.optionsCase_ == 3) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
        if (singleFieldBuilderV3 != null)
          return (Distribution.BucketOptions.ExplicitOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (this.optionsCase_ == 3) ? (Distribution.BucketOptions.Explicit)this.options_ : Distribution.BucketOptions.Explicit.getDefaultInstance();
    }
    
    public Distribution.BucketOptions.Exponential getExponentialBuckets() {
      SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)this.options_ : Distribution.BucketOptions.Exponential.getDefaultInstance()) : ((this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Exponential.getDefaultInstance());
    }
    
    public Distribution.BucketOptions.Exponential.Builder getExponentialBucketsBuilder() {
      return (Distribution.BucketOptions.Exponential.Builder)getExponentialBucketsFieldBuilder().getBuilder();
    }
    
    public Distribution.BucketOptions.ExponentialOrBuilder getExponentialBucketsOrBuilder() {
      if (this.optionsCase_ == 2) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
        if (singleFieldBuilderV3 != null)
          return (Distribution.BucketOptions.ExponentialOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (this.optionsCase_ == 2) ? (Distribution.BucketOptions.Exponential)this.options_ : Distribution.BucketOptions.Exponential.getDefaultInstance();
    }
    
    public Distribution.BucketOptions.Linear getLinearBuckets() {
      SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
      return (singleFieldBuilderV3 == null) ? ((this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)this.options_ : Distribution.BucketOptions.Linear.getDefaultInstance()) : ((this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)singleFieldBuilderV3.getMessage() : Distribution.BucketOptions.Linear.getDefaultInstance());
    }
    
    public Distribution.BucketOptions.Linear.Builder getLinearBucketsBuilder() {
      return (Distribution.BucketOptions.Linear.Builder)getLinearBucketsFieldBuilder().getBuilder();
    }
    
    public Distribution.BucketOptions.LinearOrBuilder getLinearBucketsOrBuilder() {
      if (this.optionsCase_ == 1) {
        SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
        if (singleFieldBuilderV3 != null)
          return (Distribution.BucketOptions.LinearOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      } 
      return (this.optionsCase_ == 1) ? (Distribution.BucketOptions.Linear)this.options_ : Distribution.BucketOptions.Linear.getDefaultInstance();
    }
    
    public Distribution.BucketOptions.OptionsCase getOptionsCase() {
      return Distribution.BucketOptions.OptionsCase.forNumber(this.optionsCase_);
    }
    
    public boolean hasExplicitBuckets() {
      return (this.optionsCase_ == 3);
    }
    
    public boolean hasExponentialBuckets() {
      return (this.optionsCase_ == 2);
    }
    
    public boolean hasLinearBuckets() {
      return (this.optionsCase_ == 1);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.f.ensureFieldAccessorsInitialized(Distribution.BucketOptions.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeExplicitBuckets(Distribution.BucketOptions.Explicit param1Explicit) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.optionsCase_ == 3 && this.options_ != Distribution.BucketOptions.Explicit.getDefaultInstance()) {
          this.options_ = Distribution.BucketOptions.Explicit.newBuilder((Distribution.BucketOptions.Explicit)this.options_).mergeFrom(param1Explicit).buildPartial();
        } else {
          this.options_ = param1Explicit;
        } 
        onChanged();
      } else {
        if (this.optionsCase_ == 3)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1Explicit); 
        this.explicitBucketsBuilder_.setMessage((AbstractMessage)param1Explicit);
      } 
      this.optionsCase_ = 3;
      return this;
    }
    
    public Builder mergeExponentialBuckets(Distribution.BucketOptions.Exponential param1Exponential) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.optionsCase_ == 2 && this.options_ != Distribution.BucketOptions.Exponential.getDefaultInstance()) {
          this.options_ = Distribution.BucketOptions.Exponential.newBuilder((Distribution.BucketOptions.Exponential)this.options_).mergeFrom(param1Exponential).buildPartial();
        } else {
          this.options_ = param1Exponential;
        } 
        onChanged();
      } else {
        if (this.optionsCase_ == 2)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1Exponential); 
        this.exponentialBucketsBuilder_.setMessage((AbstractMessage)param1Exponential);
      } 
      this.optionsCase_ = 2;
      return this;
    }
    
    public Builder mergeFrom(Distribution.BucketOptions param1BucketOptions) {
      if (param1BucketOptions == Distribution.BucketOptions.getDefaultInstance())
        return this; 
      int i = Distribution.null.a[param1BucketOptions.getOptionsCase().ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            mergeExplicitBuckets(param1BucketOptions.getExplicitBuckets()); 
        } else {
          mergeExponentialBuckets(param1BucketOptions.getExponentialBuckets());
        } 
      } else {
        mergeLinearBuckets(param1BucketOptions.getLinearBuckets());
      } 
      mergeUnknownFields(param1BucketOptions.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.BucketOptions bucketOptions = (Distribution.BucketOptions)Distribution.BucketOptions.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.BucketOptions bucketOptions = (Distribution.BucketOptions)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.BucketOptions)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.BucketOptions)
        return mergeFrom((Distribution.BucketOptions)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeLinearBuckets(Distribution.BucketOptions.Linear param1Linear) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (this.optionsCase_ == 1 && this.options_ != Distribution.BucketOptions.Linear.getDefaultInstance()) {
          this.options_ = Distribution.BucketOptions.Linear.newBuilder((Distribution.BucketOptions.Linear)this.options_).mergeFrom(param1Linear).buildPartial();
        } else {
          this.options_ = param1Linear;
        } 
        onChanged();
      } else {
        if (this.optionsCase_ == 1)
          singleFieldBuilderV3.mergeFrom((AbstractMessage)param1Linear); 
        this.linearBucketsBuilder_.setMessage((AbstractMessage)param1Linear);
      } 
      this.optionsCase_ = 1;
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit.Builder param1Builder) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.options_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.optionsCase_ = 3;
      return this;
    }
    
    public Builder setExplicitBuckets(Distribution.BucketOptions.Explicit param1Explicit) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Explicit, Distribution.BucketOptions.Explicit.Builder, Distribution.BucketOptions.ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Explicit != null) {
          this.options_ = param1Explicit;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Explicit);
      } 
      this.optionsCase_ = 3;
      return this;
    }
    
    public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential.Builder param1Builder) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.options_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.optionsCase_ = 2;
      return this;
    }
    
    public Builder setExponentialBuckets(Distribution.BucketOptions.Exponential param1Exponential) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Exponential, Distribution.BucketOptions.Exponential.Builder, Distribution.BucketOptions.ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Exponential != null) {
          this.options_ = param1Exponential;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Exponential);
      } 
      this.optionsCase_ = 2;
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLinearBuckets(Distribution.BucketOptions.Linear.Builder param1Builder) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.options_ = param1Builder.build();
        onChanged();
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      } 
      this.optionsCase_ = 1;
      return this;
    }
    
    public Builder setLinearBuckets(Distribution.BucketOptions.Linear param1Linear) {
      SingleFieldBuilderV3<Distribution.BucketOptions.Linear, Distribution.BucketOptions.Linear.Builder, Distribution.BucketOptions.LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Linear != null) {
          this.options_ = param1Linear;
          onChanged();
        } else {
          throw new NullPointerException();
        } 
      } else {
        singleFieldBuilderV3.setMessage((AbstractMessage)param1Linear);
      } 
      this.optionsCase_ = 1;
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class Explicit extends GeneratedMessageV3 implements BucketOptions.ExplicitOrBuilder {
    public static final int BOUNDS_FIELD_NUMBER = 1;
    
    private static final Explicit DEFAULT_INSTANCE = new Explicit();
    
    private static final Parser<Explicit> PARSER = (Parser<Explicit>)new AbstractParser<Explicit>() {
        public Distribution.BucketOptions.Explicit a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.BucketOptions.Explicit(param3CodedInputStream, param3ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int boundsMemoizedSerializedSize = -1;
    
    private Internal.DoubleList bounds_;
    
    private byte memoizedIsInitialized = -1;
    
    private Explicit() {
      this.bounds_ = emptyDoubleList();
    }
    
    private Explicit(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 9) {
                if (n != 10) {
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
                int i1 = param1CodedInputStream.pushLimit(param1CodedInputStream.readRawVarint32());
                n = i;
                if ((i & 0x1) == 0) {
                  n = i;
                  j = i;
                  k = i;
                  m = i;
                  if (param1CodedInputStream.getBytesUntilLimit() > 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.bounds_ = newDoubleList();
                    n = i | 0x1;
                  } 
                } 
                while (true) {
                  j = n;
                  k = n;
                  m = n;
                  if (param1CodedInputStream.getBytesUntilLimit() > 0) {
                    j = n;
                    k = n;
                    m = n;
                    this.bounds_.addDouble(param1CodedInputStream.readDouble());
                    continue;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  break;
                } 
                param1CodedInputStream.popLimit(i1);
                i = n;
                continue;
              } 
              n = i;
              if ((i & 0x1) == 0) {
                j = i;
                k = i;
                m = i;
                this.bounds_ = newDoubleList();
                n = i | 0x1;
              } 
              j = n;
              k = n;
              m = n;
              this.bounds_.addDouble(param1CodedInputStream.readDouble());
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
            this.bounds_.makeImmutable(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x1) != 0)
          this.bounds_.makeImmutable(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Explicit(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Explicit getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.k;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Explicit param1Explicit) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Explicit);
    }
    
    public static Explicit parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Explicit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Explicit parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ByteString);
    }
    
    public static Explicit parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Explicit parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(InputStream param1InputStream) throws IOException {
      return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Explicit parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Explicit)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Explicit parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Explicit parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Explicit parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Explicit)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Explicit> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Explicit))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getBoundsList().equals(param1Object.getBoundsList()) ? false : (!!this.unknownFields.equals(((Explicit)param1Object).unknownFields));
    }
    
    public double getBounds(int param1Int) {
      return this.bounds_.getDouble(param1Int);
    }
    
    public int getBoundsCount() {
      return this.bounds_.size();
    }
    
    public List<Double> getBoundsList() {
      return (List<Double>)this.bounds_;
    }
    
    public Explicit getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<Explicit> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int k = getBoundsList().size() * 8;
      int j = k + 0;
      i = j;
      if (!getBoundsList().isEmpty())
        i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k); 
      this.boundsMemoizedSerializedSize = k;
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
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (getBoundsCount() > 0)
        i = (j * 37 + 1) * 53 + getBoundsList().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.l.ensureFieldAccessorsInitialized(Explicit.class, Builder.class);
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
      getSerializedSize();
      if (getBoundsList().size() > 0) {
        param1CodedOutputStream.writeUInt32NoTag(10);
        param1CodedOutputStream.writeUInt32NoTag(this.boundsMemoizedSerializedSize);
      } 
      for (int i = 0; i < this.bounds_.size(); i++)
        param1CodedOutputStream.writeDoubleNoTag(this.bounds_.getDouble(i)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.ExplicitOrBuilder {
      private int bitField0_;
      
      private Internal.DoubleList bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
        super(param3BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureBoundsIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.bounds_ = Distribution.BucketOptions.Explicit.mutableCopy(this.bounds_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.k;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Explicit.alwaysUseFieldBuilders;
      }
      
      public Builder addAllBounds(Iterable<? extends Double> param3Iterable) {
        ensureBoundsIsMutable();
        AbstractMessageLite.Builder.addAll(param3Iterable, (List)this.bounds_);
        onChanged();
        return this;
      }
      
      public Builder addBounds(double param3Double) {
        ensureBoundsIsMutable();
        this.bounds_.addDouble(param3Double);
        onChanged();
        return this;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
      }
      
      public Distribution.BucketOptions.Explicit build() {
        Distribution.BucketOptions.Explicit explicit = buildPartial();
        if (explicit.isInitialized())
          return explicit; 
        throw newUninitializedMessageException(explicit);
      }
      
      public Distribution.BucketOptions.Explicit buildPartial() {
        Distribution.BucketOptions.Explicit explicit = new Distribution.BucketOptions.Explicit(this);
        if ((this.bitField0_ & 0x1) != 0) {
          this.bounds_.makeImmutable();
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        Distribution.BucketOptions.Explicit.access$3402(explicit, this.bounds_);
        onBuilt();
        return explicit;
      }
      
      public Builder clear() {
        super.clear();
        this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        return this;
      }
      
      public Builder clearBounds() {
        this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
        return (Builder)super.clearField(param3FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
        return (Builder)super.clearOneof(param3OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public double getBounds(int param3Int) {
        return this.bounds_.getDouble(param3Int);
      }
      
      public int getBoundsCount() {
        return this.bounds_.size();
      }
      
      public List<Double> getBoundsList() {
        return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.bounds_) : this.bounds_);
      }
      
      public Distribution.BucketOptions.Explicit getDefaultInstanceForType() {
        return Distribution.BucketOptions.Explicit.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.k;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.l.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Explicit.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Explicit param3Explicit) {
        if (param3Explicit == Distribution.BucketOptions.Explicit.getDefaultInstance())
          return this; 
        if (!param3Explicit.bounds_.isEmpty()) {
          if (this.bounds_.isEmpty()) {
            this.bounds_ = param3Explicit.bounds_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureBoundsIsMutable();
            this.bounds_.addAll((Collection)param3Explicit.bounds_);
          } 
          onChanged();
        } 
        mergeUnknownFields(param3Explicit.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)Distribution.BucketOptions.Explicit.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param3ExtensionRegistryLite = null;
        } 
        if (param3CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Explicit)param3CodedInputStream); 
        throw param3ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param3Message) {
        if (param3Message instanceof Distribution.BucketOptions.Explicit)
          return mergeFrom((Distribution.BucketOptions.Explicit)param3Message); 
        super.mergeFrom(param3Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
      }
      
      public Builder setBounds(int param3Int, double param3Double) {
        ensureBoundsIsMutable();
        this.bounds_.setDouble(param3Int, param3Double);
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.setField(param3FieldDescriptor, param3Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
        return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param3UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<BucketOptions.Explicit> {
    public Distribution.BucketOptions.Explicit a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.BucketOptions.Explicit(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<BucketOptions.Explicit.Builder> implements BucketOptions.ExplicitOrBuilder {
    private int bitField0_;
    
    private Internal.DoubleList bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureBoundsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.bounds_ = Distribution.BucketOptions.Explicit.mutableCopy(this.bounds_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.k;
    }
    
    private void maybeForceBuilderInitialization() {
      Distribution.BucketOptions.Explicit.alwaysUseFieldBuilders;
    }
    
    public Builder addAllBounds(Iterable<? extends Double> param1Iterable) {
      ensureBoundsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.bounds_);
      onChanged();
      return this;
    }
    
    public Builder addBounds(double param1Double) {
      ensureBoundsIsMutable();
      this.bounds_.addDouble(param1Double);
      onChanged();
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.BucketOptions.Explicit build() {
      Distribution.BucketOptions.Explicit explicit = buildPartial();
      if (explicit.isInitialized())
        return explicit; 
      throw newUninitializedMessageException(explicit);
    }
    
    public Distribution.BucketOptions.Explicit buildPartial() {
      Distribution.BucketOptions.Explicit explicit = new Distribution.BucketOptions.Explicit(this);
      if ((this.bitField0_ & 0x1) != 0) {
        this.bounds_.makeImmutable();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      Distribution.BucketOptions.Explicit.access$3402(explicit, this.bounds_);
      onBuilt();
      return explicit;
    }
    
    public Builder clear() {
      super.clear();
      this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      return this;
    }
    
    public Builder clearBounds() {
      this.bounds_ = Distribution.BucketOptions.Explicit.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
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
    
    public double getBounds(int param1Int) {
      return this.bounds_.getDouble(param1Int);
    }
    
    public int getBoundsCount() {
      return this.bounds_.size();
    }
    
    public List<Double> getBoundsList() {
      return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.bounds_) : this.bounds_);
    }
    
    public Distribution.BucketOptions.Explicit getDefaultInstanceForType() {
      return Distribution.BucketOptions.Explicit.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.k;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.l.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Explicit.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Distribution.BucketOptions.Explicit param1Explicit) {
      if (param1Explicit == Distribution.BucketOptions.Explicit.getDefaultInstance())
        return this; 
      if (!param1Explicit.bounds_.isEmpty()) {
        if (this.bounds_.isEmpty()) {
          this.bounds_ = param1Explicit.bounds_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureBoundsIsMutable();
          this.bounds_.addAll((Collection)param1Explicit.bounds_);
        } 
        onChanged();
      } 
      mergeUnknownFields(param1Explicit.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)Distribution.BucketOptions.Explicit.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.BucketOptions.Explicit explicit = (Distribution.BucketOptions.Explicit)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.BucketOptions.Explicit)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.BucketOptions.Explicit)
        return mergeFrom((Distribution.BucketOptions.Explicit)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBounds(int param1Int, double param1Double) {
      ensureBoundsIsMutable();
      this.bounds_.setDouble(param1Int, param1Double);
      onChanged();
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
  
  public static interface ExplicitOrBuilder extends MessageOrBuilder {
    double getBounds(int param1Int);
    
    int getBoundsCount();
    
    List<Double> getBoundsList();
  }
  
  public static final class Exponential extends GeneratedMessageV3 implements BucketOptions.ExponentialOrBuilder {
    private static final Exponential DEFAULT_INSTANCE = new Exponential();
    
    public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
    
    public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
    
    private static final Parser<Exponential> PARSER = (Parser<Exponential>)new AbstractParser<Exponential>() {
        public Distribution.BucketOptions.Exponential a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.BucketOptions.Exponential(param3CodedInputStream, param3ExtensionRegistryLite);
        }
      };
    
    public static final int SCALE_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private double growthFactor_;
    
    private byte memoizedIsInitialized = -1;
    
    private int numFiniteBuckets_;
    
    private double scale_;
    
    private Exponential() {}
    
    private Exponential(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 17) {
                  if (i != 25) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.scale_ = param1CodedInputStream.readDouble();
                  continue;
                } 
                this.growthFactor_ = param1CodedInputStream.readDouble();
                continue;
              } 
              this.numFiniteBuckets_ = param1CodedInputStream.readInt32();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Exponential(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Exponential getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.i;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Exponential param1Exponential) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Exponential);
    }
    
    public static Exponential parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Exponential)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Exponential parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ByteString);
    }
    
    public static Exponential parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Exponential parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(InputStream param1InputStream) throws IOException {
      return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Exponential parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exponential)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Exponential parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Exponential parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Exponential parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exponential)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Exponential> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Exponential))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getNumFiniteBuckets() != param1Object.getNumFiniteBuckets()) ? false : ((Double.doubleToLongBits(getGrowthFactor()) != Double.doubleToLongBits(param1Object.getGrowthFactor())) ? false : ((Double.doubleToLongBits(getScale()) != Double.doubleToLongBits(param1Object.getScale())) ? false : (!!this.unknownFields.equals(((Exponential)param1Object).unknownFields))));
    }
    
    public Exponential getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public double getGrowthFactor() {
      return this.growthFactor_;
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public Parser<Exponential> getParserForType() {
      return PARSER;
    }
    
    public double getScale() {
      return this.scale_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.numFiniteBuckets_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
      double d = this.growthFactor_;
      j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(2, d); 
      d = this.scale_;
      i = j;
      if (d != 0.0D)
        i = j + CodedOutputStream.computeDoubleSize(3, d); 
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
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getNumFiniteBuckets()) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getGrowthFactor()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getScale()))) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.j.ensureFieldAccessorsInitialized(Exponential.class, Builder.class);
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
      int i = this.numFiniteBuckets_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      double d = this.growthFactor_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
      d = this.scale_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(3, d); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.ExponentialOrBuilder {
      private double growthFactor_;
      
      private int numFiniteBuckets_;
      
      private double scale_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
        super(param3BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.i;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Exponential.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
      }
      
      public Distribution.BucketOptions.Exponential build() {
        Distribution.BucketOptions.Exponential exponential = buildPartial();
        if (exponential.isInitialized())
          return exponential; 
        throw newUninitializedMessageException(exponential);
      }
      
      public Distribution.BucketOptions.Exponential buildPartial() {
        Distribution.BucketOptions.Exponential exponential = new Distribution.BucketOptions.Exponential(this);
        Distribution.BucketOptions.Exponential.access$2302(exponential, this.numFiniteBuckets_);
        Distribution.BucketOptions.Exponential.access$2402(exponential, this.growthFactor_);
        Distribution.BucketOptions.Exponential.access$2502(exponential, this.scale_);
        onBuilt();
        return exponential;
      }
      
      public Builder clear() {
        super.clear();
        this.numFiniteBuckets_ = 0;
        this.growthFactor_ = 0.0D;
        this.scale_ = 0.0D;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
        return (Builder)super.clearField(param3FieldDescriptor);
      }
      
      public Builder clearGrowthFactor() {
        this.growthFactor_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
        return (Builder)super.clearOneof(param3OneofDescriptor);
      }
      
      public Builder clearScale() {
        this.scale_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.BucketOptions.Exponential getDefaultInstanceForType() {
        return Distribution.BucketOptions.Exponential.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.i;
      }
      
      public double getGrowthFactor() {
        return this.growthFactor_;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getScale() {
        return this.scale_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.j.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Exponential.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Exponential param3Exponential) {
        if (param3Exponential == Distribution.BucketOptions.Exponential.getDefaultInstance())
          return this; 
        if (param3Exponential.getNumFiniteBuckets() != 0)
          setNumFiniteBuckets(param3Exponential.getNumFiniteBuckets()); 
        if (param3Exponential.getGrowthFactor() != 0.0D)
          setGrowthFactor(param3Exponential.getGrowthFactor()); 
        if (param3Exponential.getScale() != 0.0D)
          setScale(param3Exponential.getScale()); 
        mergeUnknownFields(param3Exponential.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)Distribution.BucketOptions.Exponential.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param3ExtensionRegistryLite = null;
        } 
        if (param3CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Exponential)param3CodedInputStream); 
        throw param3ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param3Message) {
        if (param3Message instanceof Distribution.BucketOptions.Exponential)
          return mergeFrom((Distribution.BucketOptions.Exponential)param3Message); 
        super.mergeFrom(param3Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.setField(param3FieldDescriptor, param3Object);
      }
      
      public Builder setGrowthFactor(double param3Double) {
        this.growthFactor_ = param3Double;
        onChanged();
        return this;
      }
      
      public Builder setNumFiniteBuckets(int param3Int) {
        this.numFiniteBuckets_ = param3Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
        return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
      }
      
      public Builder setScale(double param3Double) {
        this.scale_ = param3Double;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param3UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<BucketOptions.Exponential> {
    public Distribution.BucketOptions.Exponential a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.BucketOptions.Exponential(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<BucketOptions.Exponential.Builder> implements BucketOptions.ExponentialOrBuilder {
    private double growthFactor_;
    
    private int numFiniteBuckets_;
    
    private double scale_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.i;
    }
    
    private void maybeForceBuilderInitialization() {
      Distribution.BucketOptions.Exponential.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.BucketOptions.Exponential build() {
      Distribution.BucketOptions.Exponential exponential = buildPartial();
      if (exponential.isInitialized())
        return exponential; 
      throw newUninitializedMessageException(exponential);
    }
    
    public Distribution.BucketOptions.Exponential buildPartial() {
      Distribution.BucketOptions.Exponential exponential = new Distribution.BucketOptions.Exponential(this);
      Distribution.BucketOptions.Exponential.access$2302(exponential, this.numFiniteBuckets_);
      Distribution.BucketOptions.Exponential.access$2402(exponential, this.growthFactor_);
      Distribution.BucketOptions.Exponential.access$2502(exponential, this.scale_);
      onBuilt();
      return exponential;
    }
    
    public Builder clear() {
      super.clear();
      this.numFiniteBuckets_ = 0;
      this.growthFactor_ = 0.0D;
      this.scale_ = 0.0D;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearGrowthFactor() {
      this.growthFactor_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearNumFiniteBuckets() {
      this.numFiniteBuckets_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearScale() {
      this.scale_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Distribution.BucketOptions.Exponential getDefaultInstanceForType() {
      return Distribution.BucketOptions.Exponential.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.i;
    }
    
    public double getGrowthFactor() {
      return this.growthFactor_;
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public double getScale() {
      return this.scale_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.j.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Exponential.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Distribution.BucketOptions.Exponential param1Exponential) {
      if (param1Exponential == Distribution.BucketOptions.Exponential.getDefaultInstance())
        return this; 
      if (param1Exponential.getNumFiniteBuckets() != 0)
        setNumFiniteBuckets(param1Exponential.getNumFiniteBuckets()); 
      if (param1Exponential.getGrowthFactor() != 0.0D)
        setGrowthFactor(param1Exponential.getGrowthFactor()); 
      if (param1Exponential.getScale() != 0.0D)
        setScale(param1Exponential.getScale()); 
      mergeUnknownFields(param1Exponential.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)Distribution.BucketOptions.Exponential.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.BucketOptions.Exponential exponential = (Distribution.BucketOptions.Exponential)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.BucketOptions.Exponential)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.BucketOptions.Exponential)
        return mergeFrom((Distribution.BucketOptions.Exponential)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setGrowthFactor(double param1Double) {
      this.growthFactor_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setNumFiniteBuckets(int param1Int) {
      this.numFiniteBuckets_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setScale(double param1Double) {
      this.scale_ = param1Double;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ExponentialOrBuilder extends MessageOrBuilder {
    double getGrowthFactor();
    
    int getNumFiniteBuckets();
    
    double getScale();
  }
  
  public static final class Linear extends GeneratedMessageV3 implements BucketOptions.LinearOrBuilder {
    private static final Linear DEFAULT_INSTANCE = new Linear();
    
    public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
    
    public static final int OFFSET_FIELD_NUMBER = 3;
    
    private static final Parser<Linear> PARSER = (Parser<Linear>)new AbstractParser<Linear>() {
        public Distribution.BucketOptions.Linear a(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.BucketOptions.Linear(param3CodedInputStream, param3ExtensionRegistryLite);
        }
      };
    
    public static final int WIDTH_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private int numFiniteBuckets_;
    
    private double offset_;
    
    private double width_;
    
    private Linear() {}
    
    private Linear(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 17) {
                  if (i != 25) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.offset_ = param1CodedInputStream.readDouble();
                  continue;
                } 
                this.width_ = param1CodedInputStream.readDouble();
                continue;
              } 
              this.numFiniteBuckets_ = param1CodedInputStream.readInt32();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Linear(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Linear getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.g;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Linear param1Linear) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Linear);
    }
    
    public static Linear parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Linear)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Linear parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ByteString);
    }
    
    public static Linear parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Linear parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(InputStream param1InputStream) throws IOException {
      return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Linear parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Linear)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Linear parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Linear parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Linear parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Linear)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Linear> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Linear))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getNumFiniteBuckets() != param1Object.getNumFiniteBuckets()) ? false : ((Double.doubleToLongBits(getWidth()) != Double.doubleToLongBits(param1Object.getWidth())) ? false : ((Double.doubleToLongBits(getOffset()) != Double.doubleToLongBits(param1Object.getOffset())) ? false : (!!this.unknownFields.equals(((Linear)param1Object).unknownFields))));
    }
    
    public Linear getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public double getOffset() {
      return this.offset_;
    }
    
    public Parser<Linear> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.numFiniteBuckets_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeInt32Size(1, j); 
      double d = this.width_;
      j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(2, d); 
      d = this.offset_;
      i = j;
      if (d != 0.0D)
        i = j + CodedOutputStream.computeDoubleSize(3, d); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public double getWidth() {
      return this.width_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getNumFiniteBuckets()) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getWidth()))) * 37 + 3) * 53 + Internal.hashLong(Double.doubleToLongBits(getOffset()))) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.h.ensureFieldAccessorsInitialized(Linear.class, Builder.class);
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
      int i = this.numFiniteBuckets_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(1, i); 
      double d = this.width_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
      d = this.offset_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(3, d); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.BucketOptions.LinearOrBuilder {
      private int numFiniteBuckets_;
      
      private double offset_;
      
      private double width_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param3BuilderParent) {
        super(param3BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.g;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.BucketOptions.Linear.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.addRepeatedField(param3FieldDescriptor, param3Object);
      }
      
      public Distribution.BucketOptions.Linear build() {
        Distribution.BucketOptions.Linear linear = buildPartial();
        if (linear.isInitialized())
          return linear; 
        throw newUninitializedMessageException(linear);
      }
      
      public Distribution.BucketOptions.Linear buildPartial() {
        Distribution.BucketOptions.Linear linear = new Distribution.BucketOptions.Linear(this);
        Distribution.BucketOptions.Linear.access$1302(linear, this.numFiniteBuckets_);
        Distribution.BucketOptions.Linear.access$1402(linear, this.width_);
        Distribution.BucketOptions.Linear.access$1502(linear, this.offset_);
        onBuilt();
        return linear;
      }
      
      public Builder clear() {
        super.clear();
        this.numFiniteBuckets_ = 0;
        this.width_ = 0.0D;
        this.offset_ = 0.0D;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param3FieldDescriptor) {
        return (Builder)super.clearField(param3FieldDescriptor);
      }
      
      public Builder clearNumFiniteBuckets() {
        this.numFiniteBuckets_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOffset() {
        this.offset_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param3OneofDescriptor) {
        return (Builder)super.clearOneof(param3OneofDescriptor);
      }
      
      public Builder clearWidth() {
        this.width_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.BucketOptions.Linear getDefaultInstanceForType() {
        return Distribution.BucketOptions.Linear.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.g;
      }
      
      public int getNumFiniteBuckets() {
        return this.numFiniteBuckets_;
      }
      
      public double getOffset() {
        return this.offset_;
      }
      
      public double getWidth() {
        return this.width_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.h.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Linear.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.BucketOptions.Linear param3Linear) {
        if (param3Linear == Distribution.BucketOptions.Linear.getDefaultInstance())
          return this; 
        if (param3Linear.getNumFiniteBuckets() != 0)
          setNumFiniteBuckets(param3Linear.getNumFiniteBuckets()); 
        if (param3Linear.getWidth() != 0.0D)
          setWidth(param3Linear.getWidth()); 
        if (param3Linear.getOffset() != 0.0D)
          setOffset(param3Linear.getOffset()); 
        mergeUnknownFields(param3Linear.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param3CodedInputStream, ExtensionRegistryLite param3ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)Distribution.BucketOptions.Linear.PARSER.parsePartialFrom(param3CodedInputStream, param3ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param3ExtensionRegistryLite = null;
        } 
        if (param3CodedInputStream != null)
          mergeFrom((Distribution.BucketOptions.Linear)param3CodedInputStream); 
        throw param3ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param3Message) {
        if (param3Message instanceof Distribution.BucketOptions.Linear)
          return mergeFrom((Distribution.BucketOptions.Linear)param3Message); 
        super.mergeFrom(param3Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param3UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param3FieldDescriptor, Object param3Object) {
        return (Builder)super.setField(param3FieldDescriptor, param3Object);
      }
      
      public Builder setNumFiniteBuckets(int param3Int) {
        this.numFiniteBuckets_ = param3Int;
        onChanged();
        return this;
      }
      
      public Builder setOffset(double param3Double) {
        this.offset_ = param3Double;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param3FieldDescriptor, int param3Int, Object param3Object) {
        return (Builder)super.setRepeatedField(param3FieldDescriptor, param3Int, param3Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param3UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param3UnknownFieldSet);
      }
      
      public Builder setWidth(double param3Double) {
        this.width_ = param3Double;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<BucketOptions.Linear> {
    public Distribution.BucketOptions.Linear a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.BucketOptions.Linear(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<BucketOptions.Linear.Builder> implements BucketOptions.LinearOrBuilder {
    private int numFiniteBuckets_;
    
    private double offset_;
    
    private double width_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.g;
    }
    
    private void maybeForceBuilderInitialization() {
      Distribution.BucketOptions.Linear.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.BucketOptions.Linear build() {
      Distribution.BucketOptions.Linear linear = buildPartial();
      if (linear.isInitialized())
        return linear; 
      throw newUninitializedMessageException(linear);
    }
    
    public Distribution.BucketOptions.Linear buildPartial() {
      Distribution.BucketOptions.Linear linear = new Distribution.BucketOptions.Linear(this);
      Distribution.BucketOptions.Linear.access$1302(linear, this.numFiniteBuckets_);
      Distribution.BucketOptions.Linear.access$1402(linear, this.width_);
      Distribution.BucketOptions.Linear.access$1502(linear, this.offset_);
      onBuilt();
      return linear;
    }
    
    public Builder clear() {
      super.clear();
      this.numFiniteBuckets_ = 0;
      this.width_ = 0.0D;
      this.offset_ = 0.0D;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNumFiniteBuckets() {
      this.numFiniteBuckets_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOffset() {
      this.offset_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearWidth() {
      this.width_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Distribution.BucketOptions.Linear getDefaultInstanceForType() {
      return Distribution.BucketOptions.Linear.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.g;
    }
    
    public int getNumFiniteBuckets() {
      return this.numFiniteBuckets_;
    }
    
    public double getOffset() {
      return this.offset_;
    }
    
    public double getWidth() {
      return this.width_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.h.ensureFieldAccessorsInitialized(Distribution.BucketOptions.Linear.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Distribution.BucketOptions.Linear param1Linear) {
      if (param1Linear == Distribution.BucketOptions.Linear.getDefaultInstance())
        return this; 
      if (param1Linear.getNumFiniteBuckets() != 0)
        setNumFiniteBuckets(param1Linear.getNumFiniteBuckets()); 
      if (param1Linear.getWidth() != 0.0D)
        setWidth(param1Linear.getWidth()); 
      if (param1Linear.getOffset() != 0.0D)
        setOffset(param1Linear.getOffset()); 
      mergeUnknownFields(param1Linear.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)Distribution.BucketOptions.Linear.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.BucketOptions.Linear linear = (Distribution.BucketOptions.Linear)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.BucketOptions.Linear)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.BucketOptions.Linear)
        return mergeFrom((Distribution.BucketOptions.Linear)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNumFiniteBuckets(int param1Int) {
      this.numFiniteBuckets_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOffset(double param1Double) {
      this.offset_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setWidth(double param1Double) {
      this.width_ = param1Double;
      onChanged();
      return this;
    }
  }
  
  public static interface LinearOrBuilder extends MessageOrBuilder {
    int getNumFiniteBuckets();
    
    double getOffset();
    
    double getWidth();
  }
  
  public enum OptionsCase implements Internal.EnumLite {
    EXPLICIT_BUCKETS(1),
    EXPONENTIAL_BUCKETS(1),
    LINEAR_BUCKETS(1),
    OPTIONS_NOT_SET(1);
    
    private final int value;
    
    static {
      EXPLICIT_BUCKETS = new OptionsCase("EXPLICIT_BUCKETS", 2, 3);
      OPTIONS_NOT_SET = new OptionsCase("OPTIONS_NOT_SET", 3, 0);
      $VALUES = new OptionsCase[] { LINEAR_BUCKETS, EXPONENTIAL_BUCKETS, EXPLICIT_BUCKETS, OPTIONS_NOT_SET };
    }
    
    OptionsCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static OptionsCase forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? null : EXPLICIT_BUCKETS) : EXPONENTIAL_BUCKETS) : LINEAR_BUCKETS) : OPTIONS_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
  
  public static interface BucketOptionsOrBuilder extends MessageOrBuilder {
    Distribution.BucketOptions.Explicit getExplicitBuckets();
    
    Distribution.BucketOptions.ExplicitOrBuilder getExplicitBucketsOrBuilder();
    
    Distribution.BucketOptions.Exponential getExponentialBuckets();
    
    Distribution.BucketOptions.ExponentialOrBuilder getExponentialBucketsOrBuilder();
    
    Distribution.BucketOptions.Linear getLinearBuckets();
    
    Distribution.BucketOptions.LinearOrBuilder getLinearBucketsOrBuilder();
    
    Distribution.BucketOptions.OptionsCase getOptionsCase();
    
    boolean hasExplicitBuckets();
    
    boolean hasExponentialBuckets();
    
    boolean hasLinearBuckets();
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DistributionOrBuilder {
    private int bitField0_;
    
    private Internal.LongList bucketCounts_ = Distribution.emptyLongList();
    
    private SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> bucketOptionsBuilder_;
    
    private Distribution.BucketOptions bucketOptions_;
    
    private long count_;
    
    private RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> exemplarsBuilder_;
    
    private List<Distribution.Exemplar> exemplars_ = Collections.emptyList();
    
    private double mean_;
    
    private SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> rangeBuilder_;
    
    private Distribution.Range range_;
    
    private double sumOfSquaredDeviation_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureBucketCountsIsMutable() {
      if ((this.bitField0_ & 0x20) == 0) {
        this.bucketCounts_ = Distribution.mutableCopy(this.bucketCounts_);
        this.bitField0_ |= 0x20;
      } 
    }
    
    private void ensureExemplarsIsMutable() {
      if ((this.bitField0_ & 0x40) == 0) {
        this.exemplars_ = new ArrayList<Distribution.Exemplar>(this.exemplars_);
        this.bitField0_ |= 0x40;
      } 
    }
    
    private SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> getBucketOptionsFieldBuilder() {
      if (this.bucketOptionsBuilder_ == null) {
        this.bucketOptionsBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBucketOptions(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.bucketOptions_ = null;
      } 
      return this.bucketOptionsBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.a;
    }
    
    private RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> getExemplarsFieldBuilder() {
      if (this.exemplarsBuilder_ == null) {
        boolean bool;
        List<Distribution.Exemplar> list = this.exemplars_;
        if ((this.bitField0_ & 0x40) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.exemplarsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.exemplars_ = null;
      } 
      return this.exemplarsBuilder_;
    }
    
    private SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> getRangeFieldBuilder() {
      if (this.rangeBuilder_ == null) {
        this.rangeBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getRange(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.range_ = null;
      } 
      return this.rangeBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Distribution.alwaysUseFieldBuilders)
        getExemplarsFieldBuilder(); 
    }
    
    public Builder addAllBucketCounts(Iterable<? extends Long> param1Iterable) {
      ensureBucketCountsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.bucketCounts_);
      onChanged();
      return this;
    }
    
    public Builder addAllExemplars(Iterable<? extends Distribution.Exemplar> param1Iterable) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExemplarsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.exemplars_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addBucketCounts(long param1Long) {
      ensureBucketCountsIsMutable();
      this.bucketCounts_.addLong(param1Long);
      onChanged();
      return this;
    }
    
    public Builder addExemplars(int param1Int, Distribution.Exemplar.Builder param1Builder) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExemplarsIsMutable();
        this.exemplars_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addExemplars(int param1Int, Distribution.Exemplar param1Exemplar) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Exemplar != null) {
          ensureExemplarsIsMutable();
          this.exemplars_.add(param1Int, param1Exemplar);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Exemplar);
      return this;
    }
    
    public Builder addExemplars(Distribution.Exemplar.Builder param1Builder) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExemplarsIsMutable();
        this.exemplars_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addExemplars(Distribution.Exemplar param1Exemplar) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Exemplar != null) {
          ensureExemplarsIsMutable();
          this.exemplars_.add(param1Exemplar);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Exemplar);
      return this;
    }
    
    public Distribution.Exemplar.Builder addExemplarsBuilder() {
      return (Distribution.Exemplar.Builder)getExemplarsFieldBuilder().addBuilder((AbstractMessage)Distribution.Exemplar.getDefaultInstance());
    }
    
    public Distribution.Exemplar.Builder addExemplarsBuilder(int param1Int) {
      return (Distribution.Exemplar.Builder)getExemplarsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Distribution.Exemplar.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution build() {
      Distribution distribution = buildPartial();
      if (distribution.isInitialized())
        return distribution; 
      throw newUninitializedMessageException(distribution);
    }
    
    public Distribution buildPartial() {
      Distribution distribution = new Distribution(this);
      int i = this.bitField0_;
      Distribution.access$6702(distribution, this.count_);
      Distribution.access$6802(distribution, this.mean_);
      Distribution.access$6902(distribution, this.sumOfSquaredDeviation_);
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV31 = this.rangeBuilder_;
      if (singleFieldBuilderV31 == null) {
        Distribution.access$7002(distribution, this.range_);
      } else {
        Distribution.access$7002(distribution, (Distribution.Range)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 == null) {
        Distribution.access$7102(distribution, this.bucketOptions_);
      } else {
        Distribution.access$7102(distribution, (Distribution.BucketOptions)singleFieldBuilderV3.build());
      } 
      if ((this.bitField0_ & 0x20) != 0) {
        this.bucketCounts_.makeImmutable();
        this.bitField0_ &= 0xFFFFFFDF;
      } 
      Distribution.access$7202(distribution, this.bucketCounts_);
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x40) != 0) {
          this.exemplars_ = Collections.unmodifiableList(this.exemplars_);
          this.bitField0_ &= 0xFFFFFFBF;
        } 
        Distribution.access$7302(distribution, this.exemplars_);
      } else {
        Distribution.access$7302(distribution, repeatedFieldBuilderV3.build());
      } 
      Distribution.access$7402(distribution, 0);
      onBuilt();
      return distribution;
    }
    
    public Builder clear() {
      super.clear();
      this.count_ = 0L;
      this.mean_ = 0.0D;
      this.sumOfSquaredDeviation_ = 0.0D;
      if (this.rangeBuilder_ == null) {
        this.range_ = null;
      } else {
        this.range_ = null;
        this.rangeBuilder_ = null;
      } 
      if (this.bucketOptionsBuilder_ == null) {
        this.bucketOptions_ = null;
      } else {
        this.bucketOptions_ = null;
        this.bucketOptionsBuilder_ = null;
      } 
      this.bucketCounts_ = Distribution.emptyLongList();
      this.bitField0_ &= 0xFFFFFFDF;
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.exemplars_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearBucketCounts() {
      this.bucketCounts_ = Distribution.emptyLongList();
      this.bitField0_ &= 0xFFFFFFDF;
      onChanged();
      return this;
    }
    
    public Builder clearBucketOptions() {
      if (this.bucketOptionsBuilder_ == null) {
        this.bucketOptions_ = null;
        onChanged();
        return this;
      } 
      this.bucketOptions_ = null;
      this.bucketOptionsBuilder_ = null;
      return this;
    }
    
    public Builder clearCount() {
      this.count_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearExemplars() {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.exemplars_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFBF;
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMean() {
      this.mean_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRange() {
      if (this.rangeBuilder_ == null) {
        this.range_ = null;
        onChanged();
        return this;
      } 
      this.range_ = null;
      this.rangeBuilder_ = null;
      return this;
    }
    
    public Builder clearSumOfSquaredDeviation() {
      this.sumOfSquaredDeviation_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public long getBucketCounts(int param1Int) {
      return this.bucketCounts_.getLong(param1Int);
    }
    
    public int getBucketCountsCount() {
      return this.bucketCounts_.size();
    }
    
    public List<Long> getBucketCountsList() {
      return (List<Long>)(((this.bitField0_ & 0x20) != 0) ? Collections.unmodifiableList((List<? extends Long>)this.bucketCounts_) : this.bucketCounts_);
    }
    
    public Distribution.BucketOptions getBucketOptions() {
      Distribution.BucketOptions bucketOptions;
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 == null) {
        Distribution.BucketOptions bucketOptions1 = this.bucketOptions_;
        bucketOptions = bucketOptions1;
        if (bucketOptions1 == null)
          bucketOptions = Distribution.BucketOptions.getDefaultInstance(); 
        return bucketOptions;
      } 
      return (Distribution.BucketOptions)bucketOptions.getMessage();
    }
    
    public Distribution.BucketOptions.Builder getBucketOptionsBuilder() {
      onChanged();
      return (Distribution.BucketOptions.Builder)getBucketOptionsFieldBuilder().getBuilder();
    }
    
    public Distribution.BucketOptionsOrBuilder getBucketOptionsOrBuilder() {
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 != null)
        return (Distribution.BucketOptionsOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Distribution.BucketOptions bucketOptions2 = this.bucketOptions_;
      Distribution.BucketOptions bucketOptions1 = bucketOptions2;
      if (bucketOptions2 == null)
        bucketOptions1 = Distribution.BucketOptions.getDefaultInstance(); 
      return bucketOptions1;
    }
    
    public long getCount() {
      return this.count_;
    }
    
    public Distribution getDefaultInstanceForType() {
      return Distribution.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.a;
    }
    
    public Distribution.Exemplar getExemplars(int param1Int) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.exemplars_.get(param1Int) : (Distribution.Exemplar)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Distribution.Exemplar.Builder getExemplarsBuilder(int param1Int) {
      return (Distribution.Exemplar.Builder)getExemplarsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Distribution.Exemplar.Builder> getExemplarsBuilderList() {
      return getExemplarsFieldBuilder().getBuilderList();
    }
    
    public int getExemplarsCount() {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.exemplars_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Distribution.Exemplar> getExemplarsList() {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.exemplars_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public Distribution.ExemplarOrBuilder getExemplarsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.exemplars_.get(param1Int) : (Distribution.ExemplarOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends Distribution.ExemplarOrBuilder> getExemplarsOrBuilderList() {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList((List)this.exemplars_);
    }
    
    public double getMean() {
      return this.mean_;
    }
    
    public Distribution.Range getRange() {
      Distribution.Range range;
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
      if (singleFieldBuilderV3 == null) {
        Distribution.Range range1 = this.range_;
        range = range1;
        if (range1 == null)
          range = Distribution.Range.getDefaultInstance(); 
        return range;
      } 
      return (Distribution.Range)range.getMessage();
    }
    
    public Distribution.Range.Builder getRangeBuilder() {
      onChanged();
      return (Distribution.Range.Builder)getRangeFieldBuilder().getBuilder();
    }
    
    public Distribution.RangeOrBuilder getRangeOrBuilder() {
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
      if (singleFieldBuilderV3 != null)
        return (Distribution.RangeOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Distribution.Range range2 = this.range_;
      Distribution.Range range1 = range2;
      if (range2 == null)
        range1 = Distribution.Range.getDefaultInstance(); 
      return range1;
    }
    
    public double getSumOfSquaredDeviation() {
      return this.sumOfSquaredDeviation_;
    }
    
    public boolean hasBucketOptions() {
      return (this.bucketOptionsBuilder_ != null || this.bucketOptions_ != null);
    }
    
    public boolean hasRange() {
      return (this.rangeBuilder_ != null || this.range_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.b.ensureFieldAccessorsInitialized(Distribution.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeBucketOptions(Distribution.BucketOptions param1BucketOptions) {
      Distribution.BucketOptions bucketOptions;
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 == null) {
        bucketOptions = this.bucketOptions_;
        if (bucketOptions != null) {
          this.bucketOptions_ = Distribution.BucketOptions.newBuilder(bucketOptions).mergeFrom(param1BucketOptions).buildPartial();
        } else {
          this.bucketOptions_ = param1BucketOptions;
        } 
        onChanged();
        return this;
      } 
      bucketOptions.mergeFrom((AbstractMessage)param1BucketOptions);
      return this;
    }
    
    public Builder mergeFrom(Distribution param1Distribution) {
      if (param1Distribution == Distribution.getDefaultInstance())
        return this; 
      if (param1Distribution.getCount() != 0L)
        setCount(param1Distribution.getCount()); 
      if (param1Distribution.getMean() != 0.0D)
        setMean(param1Distribution.getMean()); 
      if (param1Distribution.getSumOfSquaredDeviation() != 0.0D)
        setSumOfSquaredDeviation(param1Distribution.getSumOfSquaredDeviation()); 
      if (param1Distribution.hasRange())
        mergeRange(param1Distribution.getRange()); 
      if (param1Distribution.hasBucketOptions())
        mergeBucketOptions(param1Distribution.getBucketOptions()); 
      if (!param1Distribution.bucketCounts_.isEmpty()) {
        if (this.bucketCounts_.isEmpty()) {
          this.bucketCounts_ = param1Distribution.bucketCounts_;
          this.bitField0_ &= 0xFFFFFFDF;
        } else {
          ensureBucketCountsIsMutable();
          this.bucketCounts_.addAll((Collection)param1Distribution.bucketCounts_);
        } 
        onChanged();
      } 
      if (this.exemplarsBuilder_ == null) {
        if (!param1Distribution.exemplars_.isEmpty()) {
          if (this.exemplars_.isEmpty()) {
            this.exemplars_ = param1Distribution.exemplars_;
            this.bitField0_ &= 0xFFFFFFBF;
          } else {
            ensureExemplarsIsMutable();
            this.exemplars_.addAll(param1Distribution.exemplars_);
          } 
          onChanged();
        } 
      } else if (!param1Distribution.exemplars_.isEmpty()) {
        if (this.exemplarsBuilder_.isEmpty()) {
          this.exemplarsBuilder_.dispose();
          RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = null;
          this.exemplarsBuilder_ = null;
          this.exemplars_ = param1Distribution.exemplars_;
          this.bitField0_ &= 0xFFFFFFBF;
          if (Distribution.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getExemplarsFieldBuilder(); 
          this.exemplarsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.exemplarsBuilder_.addAllMessages(param1Distribution.exemplars_);
        } 
      } 
      mergeUnknownFields(param1Distribution.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution distribution = (Distribution)Distribution.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution distribution = (Distribution)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution)
        return mergeFrom((Distribution)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeRange(Distribution.Range param1Range) {
      Distribution.Range range;
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
      if (singleFieldBuilderV3 == null) {
        range = this.range_;
        if (range != null) {
          this.range_ = Distribution.Range.newBuilder(range).mergeFrom(param1Range).buildPartial();
        } else {
          this.range_ = param1Range;
        } 
        onChanged();
        return this;
      } 
      range.mergeFrom((AbstractMessage)param1Range);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeExemplars(int param1Int) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExemplarsIsMutable();
        this.exemplars_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setBucketCounts(int param1Int, long param1Long) {
      ensureBucketCountsIsMutable();
      this.bucketCounts_.setLong(param1Int, param1Long);
      onChanged();
      return this;
    }
    
    public Builder setBucketOptions(Distribution.BucketOptions.Builder param1Builder) {
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.bucketOptions_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setBucketOptions(Distribution.BucketOptions param1BucketOptions) {
      SingleFieldBuilderV3<Distribution.BucketOptions, Distribution.BucketOptions.Builder, Distribution.BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1BucketOptions != null) {
          this.bucketOptions_ = param1BucketOptions;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1BucketOptions);
      return this;
    }
    
    public Builder setCount(long param1Long) {
      this.count_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setExemplars(int param1Int, Distribution.Exemplar.Builder param1Builder) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureExemplarsIsMutable();
        this.exemplars_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExemplars(int param1Int, Distribution.Exemplar param1Exemplar) {
      RepeatedFieldBuilderV3<Distribution.Exemplar, Distribution.Exemplar.Builder, Distribution.ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Exemplar != null) {
          ensureExemplarsIsMutable();
          this.exemplars_.set(param1Int, param1Exemplar);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Exemplar);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMean(double param1Double) {
      this.mean_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setRange(Distribution.Range.Builder param1Builder) {
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.range_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setRange(Distribution.Range param1Range) {
      SingleFieldBuilderV3<Distribution.Range, Distribution.Range.Builder, Distribution.RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Range != null) {
          this.range_ = param1Range;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Range);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSumOfSquaredDeviation(double param1Double) {
      this.sumOfSquaredDeviation_ = param1Double;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static final class Exemplar extends GeneratedMessageV3 implements ExemplarOrBuilder {
    public static final int ATTACHMENTS_FIELD_NUMBER = 3;
    
    private static final Exemplar DEFAULT_INSTANCE = new Exemplar();
    
    private static final Parser<Exemplar> PARSER = (Parser<Exemplar>)new AbstractParser<Exemplar>() {
        public Distribution.Exemplar a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.Exemplar(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    
    public static final int VALUE_FIELD_NUMBER = 1;
    
    private static final long serialVersionUID = 0L;
    
    private List<Any> attachments_;
    
    private int bitField0_;
    
    private byte memoizedIsInitialized = -1;
    
    private Timestamp timestamp_;
    
    private double value_;
    
    private Exemplar() {
      this.attachments_ = Collections.emptyList();
    }
    
    private Exemplar(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              if (n != 9) {
                if (n != 18) {
                  if (n != 26) {
                    j = i;
                    k = i;
                    m = i;
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n))
                      continue; 
                    continue;
                  } 
                  n = i;
                  if ((i & 0x4) == 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.attachments_ = new ArrayList<Any>();
                    n = i | 0x4;
                  } 
                  j = n;
                  k = n;
                  m = n;
                  this.attachments_.add(param1CodedInputStream.readMessage(Any.parser(), param1ExtensionRegistryLite));
                  i = n;
                  continue;
                } 
                Timestamp.Builder builder1 = null;
                j = i;
                k = i;
                m = i;
                if (this.timestamp_ != null) {
                  j = i;
                  k = i;
                  m = i;
                  builder1 = this.timestamp_.toBuilder();
                } 
                j = i;
                k = i;
                m = i;
                this.timestamp_ = (Timestamp)param1CodedInputStream.readMessage(Timestamp.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  j = i;
                  k = i;
                  m = i;
                  builder1.mergeFrom(this.timestamp_);
                  j = i;
                  k = i;
                  m = i;
                  this.timestamp_ = builder1.buildPartial();
                } 
                continue;
              } 
              j = i;
              k = i;
              m = i;
              this.value_ = param1CodedInputStream.readDouble();
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
          if ((j & 0x4) != 0)
            this.attachments_ = Collections.unmodifiableList(this.attachments_); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
          bool = true;
        } 
        if ((i & 0x4) != 0)
          this.attachments_ = Collections.unmodifiableList(this.attachments_); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Exemplar(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Exemplar getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.m;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Exemplar param1Exemplar) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Exemplar);
    }
    
    public static Exemplar parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Exemplar parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exemplar parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ByteString);
    }
    
    public static Exemplar parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Exemplar parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Exemplar parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Exemplar parseFrom(InputStream param1InputStream) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Exemplar parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Exemplar)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Exemplar parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Exemplar parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Exemplar parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Exemplar parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Exemplar)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Exemplar> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Exemplar))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (Double.doubleToLongBits(getValue()) != Double.doubleToLongBits(param1Object.getValue())) ? false : ((hasTimestamp() != param1Object.hasTimestamp()) ? false : ((hasTimestamp() && !getTimestamp().equals(param1Object.getTimestamp())) ? false : (!getAttachmentsList().equals(param1Object.getAttachmentsList()) ? false : (!!this.unknownFields.equals(((Exemplar)param1Object).unknownFields)))));
    }
    
    public Any getAttachments(int param1Int) {
      return this.attachments_.get(param1Int);
    }
    
    public int getAttachmentsCount() {
      return this.attachments_.size();
    }
    
    public List<Any> getAttachmentsList() {
      return this.attachments_;
    }
    
    public AnyOrBuilder getAttachmentsOrBuilder(int param1Int) {
      return (AnyOrBuilder)this.attachments_.get(param1Int);
    }
    
    public List<? extends AnyOrBuilder> getAttachmentsOrBuilderList() {
      return (List)this.attachments_;
    }
    
    public Exemplar getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<Exemplar> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      byte b1;
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      double d = this.value_;
      byte b2 = 0;
      if (d != 0.0D) {
        b1 = CodedOutputStream.computeDoubleSize(1, d) + 0;
      } else {
        b1 = 0;
      } 
      i = b1;
      int j = b2;
      if (this.timestamp_ != null) {
        i = b1 + CodedOutputStream.computeMessageSize(2, (MessageLite)getTimestamp());
        j = b2;
      } 
      while (j < this.attachments_.size()) {
        i += CodedOutputStream.computeMessageSize(3, (MessageLite)this.attachments_.get(j));
        j++;
      } 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public Timestamp getTimestamp() {
      Timestamp timestamp2 = this.timestamp_;
      Timestamp timestamp1 = timestamp2;
      if (timestamp2 == null)
        timestamp1 = Timestamp.getDefaultInstance(); 
      return timestamp1;
    }
    
    public TimestampOrBuilder getTimestampOrBuilder() {
      return (TimestampOrBuilder)getTimestamp();
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public double getValue() {
      return this.value_;
    }
    
    public boolean hasTimestamp() {
      return (this.timestamp_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(Double.doubleToLongBits(getValue()));
      int i = j;
      if (hasTimestamp())
        i = (j * 37 + 2) * 53 + getTimestamp().hashCode(); 
      j = i;
      if (getAttachmentsCount() > 0)
        j = (i * 37 + 3) * 53 + getAttachmentsList().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.n.ensureFieldAccessorsInitialized(Exemplar.class, Builder.class);
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
      double d = this.value_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(1, d); 
      if (this.timestamp_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getTimestamp()); 
      int i;
      for (i = 0; i < this.attachments_.size(); i++)
        param1CodedOutputStream.writeMessage(3, (MessageLite)this.attachments_.get(i)); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.ExemplarOrBuilder {
      private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> attachmentsBuilder_;
      
      private List<Any> attachments_ = Collections.emptyList();
      
      private int bitField0_;
      
      private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timestampBuilder_;
      
      private Timestamp timestamp_;
      
      private double value_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureAttachmentsIsMutable() {
        if ((this.bitField0_ & 0x4) == 0) {
          this.attachments_ = new ArrayList<Any>(this.attachments_);
          this.bitField0_ |= 0x4;
        } 
      }
      
      private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getAttachmentsFieldBuilder() {
        if (this.attachmentsBuilder_ == null) {
          boolean bool;
          List<Any> list = this.attachments_;
          if ((this.bitField0_ & 0x4) != 0) {
            bool = true;
          } else {
            bool = false;
          } 
          this.attachmentsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.attachments_ = null;
        } 
        return this.attachmentsBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.m;
      }
      
      private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimestampFieldBuilder() {
        if (this.timestampBuilder_ == null) {
          this.timestampBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTimestamp(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.timestamp_ = null;
        } 
        return this.timestampBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        if (Distribution.Exemplar.alwaysUseFieldBuilders)
          getAttachmentsFieldBuilder(); 
      }
      
      public Builder addAllAttachments(Iterable<? extends Any> param2Iterable) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureAttachmentsIsMutable();
          AbstractMessageLite.Builder.addAll(param2Iterable, this.attachments_);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addAllMessages(param2Iterable);
        return this;
      }
      
      public Builder addAttachments(int param2Int, Any.Builder param2Builder) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureAttachmentsIsMutable();
          this.attachments_.add(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addAttachments(int param2Int, Any param2Any) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Any != null) {
            ensureAttachmentsIsMutable();
            this.attachments_.add(param2Int, param2Any);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage(param2Int, (AbstractMessage)param2Any);
        return this;
      }
      
      public Builder addAttachments(Any.Builder param2Builder) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureAttachmentsIsMutable();
          this.attachments_.add(param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder addAttachments(Any param2Any) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Any != null) {
            ensureAttachmentsIsMutable();
            this.attachments_.add(param2Any);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.addMessage((AbstractMessage)param2Any);
        return this;
      }
      
      public Any.Builder addAttachmentsBuilder() {
        return (Any.Builder)getAttachmentsFieldBuilder().addBuilder((AbstractMessage)Any.getDefaultInstance());
      }
      
      public Any.Builder addAttachmentsBuilder(int param2Int) {
        return (Any.Builder)getAttachmentsFieldBuilder().addBuilder(param2Int, (AbstractMessage)Any.getDefaultInstance());
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.Exemplar build() {
        Distribution.Exemplar exemplar = buildPartial();
        if (exemplar.isInitialized())
          return exemplar; 
        throw newUninitializedMessageException(exemplar);
      }
      
      public Distribution.Exemplar buildPartial() {
        Distribution.Exemplar exemplar = new Distribution.Exemplar(this);
        int i = this.bitField0_;
        Distribution.Exemplar.access$5402(exemplar, this.value_);
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 == null) {
          Distribution.Exemplar.access$5502(exemplar, this.timestamp_);
        } else {
          Distribution.Exemplar.access$5502(exemplar, (Timestamp)singleFieldBuilderV3.build());
        } 
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if ((this.bitField0_ & 0x4) != 0) {
            this.attachments_ = Collections.unmodifiableList(this.attachments_);
            this.bitField0_ &= 0xFFFFFFFB;
          } 
          Distribution.Exemplar.access$5602(exemplar, this.attachments_);
        } else {
          Distribution.Exemplar.access$5602(exemplar, repeatedFieldBuilderV3.build());
        } 
        Distribution.Exemplar.access$5702(exemplar, 0);
        onBuilt();
        return exemplar;
      }
      
      public Builder clear() {
        super.clear();
        this.value_ = 0.0D;
        if (this.timestampBuilder_ == null) {
          this.timestamp_ = null;
        } else {
          this.timestamp_ = null;
          this.timestampBuilder_ = null;
        } 
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.attachments_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clearAttachments() {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          this.attachments_ = Collections.emptyList();
          this.bitField0_ &= 0xFFFFFFFB;
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.clear();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearTimestamp() {
        if (this.timestampBuilder_ == null) {
          this.timestamp_ = null;
          onChanged();
          return this;
        } 
        this.timestamp_ = null;
        this.timestampBuilder_ = null;
        return this;
      }
      
      public Builder clearValue() {
        this.value_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Any getAttachments(int param2Int) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.attachments_.get(param2Int) : (Any)repeatedFieldBuilderV3.getMessage(param2Int);
      }
      
      public Any.Builder getAttachmentsBuilder(int param2Int) {
        return (Any.Builder)getAttachmentsFieldBuilder().getBuilder(param2Int);
      }
      
      public List<Any.Builder> getAttachmentsBuilderList() {
        return getAttachmentsFieldBuilder().getBuilderList();
      }
      
      public int getAttachmentsCount() {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        return (repeatedFieldBuilderV3 == null) ? this.attachments_.size() : repeatedFieldBuilderV3.getCount();
      }
      
      public List<Any> getAttachmentsList() {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.attachments_) : repeatedFieldBuilderV3.getMessageList();
      }
      
      public AnyOrBuilder getAttachmentsOrBuilder(int param2Int) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        return (repeatedFieldBuilderV3 == null) ? (AnyOrBuilder)this.attachments_.get(param2Int) : (AnyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param2Int);
      }
      
      public List<? extends AnyOrBuilder> getAttachmentsOrBuilderList() {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.attachments_);
      }
      
      public Distribution.Exemplar getDefaultInstanceForType() {
        return Distribution.Exemplar.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.m;
      }
      
      public Timestamp getTimestamp() {
        Timestamp timestamp;
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 == null) {
          Timestamp timestamp1 = this.timestamp_;
          timestamp = timestamp1;
          if (timestamp1 == null)
            timestamp = Timestamp.getDefaultInstance(); 
          return timestamp;
        } 
        return (Timestamp)timestamp.getMessage();
      }
      
      public Timestamp.Builder getTimestampBuilder() {
        onChanged();
        return (Timestamp.Builder)getTimestampFieldBuilder().getBuilder();
      }
      
      public TimestampOrBuilder getTimestampOrBuilder() {
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 != null)
          return (TimestampOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Timestamp timestamp2 = this.timestamp_;
        Timestamp timestamp1 = timestamp2;
        if (timestamp2 == null)
          timestamp1 = Timestamp.getDefaultInstance(); 
        return (TimestampOrBuilder)timestamp1;
      }
      
      public double getValue() {
        return this.value_;
      }
      
      public boolean hasTimestamp() {
        return (this.timestampBuilder_ != null || this.timestamp_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.n.ensureFieldAccessorsInitialized(Distribution.Exemplar.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.Exemplar param2Exemplar) {
        if (param2Exemplar == Distribution.Exemplar.getDefaultInstance())
          return this; 
        if (param2Exemplar.getValue() != 0.0D)
          setValue(param2Exemplar.getValue()); 
        if (param2Exemplar.hasTimestamp())
          mergeTimestamp(param2Exemplar.getTimestamp()); 
        if (this.attachmentsBuilder_ == null) {
          if (!param2Exemplar.attachments_.isEmpty()) {
            if (this.attachments_.isEmpty()) {
              this.attachments_ = param2Exemplar.attachments_;
              this.bitField0_ &= 0xFFFFFFFB;
            } else {
              ensureAttachmentsIsMutable();
              this.attachments_.addAll(param2Exemplar.attachments_);
            } 
            onChanged();
          } 
        } else if (!param2Exemplar.attachments_.isEmpty()) {
          if (this.attachmentsBuilder_.isEmpty()) {
            this.attachmentsBuilder_.dispose();
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = null;
            this.attachmentsBuilder_ = null;
            this.attachments_ = param2Exemplar.attachments_;
            this.bitField0_ &= 0xFFFFFFFB;
            if (Distribution.Exemplar.alwaysUseFieldBuilders)
              repeatedFieldBuilderV3 = getAttachmentsFieldBuilder(); 
            this.attachmentsBuilder_ = repeatedFieldBuilderV3;
          } else {
            this.attachmentsBuilder_.addAllMessages(param2Exemplar.attachments_);
          } 
        } 
        mergeUnknownFields(param2Exemplar.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.Exemplar exemplar = (Distribution.Exemplar)Distribution.Exemplar.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.Exemplar exemplar = (Distribution.Exemplar)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.Exemplar)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.Exemplar)
          return mergeFrom((Distribution.Exemplar)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeTimestamp(Timestamp param2Timestamp) {
        Timestamp timestamp;
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 == null) {
          timestamp = this.timestamp_;
          if (timestamp != null) {
            this.timestamp_ = Timestamp.newBuilder(timestamp).mergeFrom(param2Timestamp).buildPartial();
          } else {
            this.timestamp_ = param2Timestamp;
          } 
          onChanged();
          return this;
        } 
        timestamp.mergeFrom((AbstractMessage)param2Timestamp);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder removeAttachments(int param2Int) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureAttachmentsIsMutable();
          this.attachments_.remove(param2Int);
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.remove(param2Int);
        return this;
      }
      
      public Builder setAttachments(int param2Int, Any.Builder param2Builder) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          ensureAttachmentsIsMutable();
          this.attachments_.set(param2Int, param2Builder.build());
          onChanged();
          return this;
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setAttachments(int param2Int, Any param2Any) {
        RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
        if (repeatedFieldBuilderV3 == null) {
          if (param2Any != null) {
            ensureAttachmentsIsMutable();
            this.attachments_.set(param2Int, param2Any);
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        repeatedFieldBuilderV3.setMessage(param2Int, (AbstractMessage)param2Any);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTimestamp(Timestamp.Builder param2Builder) {
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.timestamp_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setTimestamp(Timestamp param2Timestamp) {
        SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Timestamp != null) {
            this.timestamp_ = param2Timestamp;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Timestamp);
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setValue(double param2Double) {
        this.value_ = param2Double;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<Exemplar> {
    public Distribution.Exemplar a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.Exemplar(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Exemplar.Builder> implements ExemplarOrBuilder {
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> attachmentsBuilder_;
    
    private List<Any> attachments_ = Collections.emptyList();
    
    private int bitField0_;
    
    private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timestampBuilder_;
    
    private Timestamp timestamp_;
    
    private double value_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureAttachmentsIsMutable() {
      if ((this.bitField0_ & 0x4) == 0) {
        this.attachments_ = new ArrayList<Any>(this.attachments_);
        this.bitField0_ |= 0x4;
      } 
    }
    
    private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getAttachmentsFieldBuilder() {
      if (this.attachmentsBuilder_ == null) {
        boolean bool;
        List<Any> list = this.attachments_;
        if ((this.bitField0_ & 0x4) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.attachmentsBuilder_ = new RepeatedFieldBuilderV3(list, bool, (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.attachments_ = null;
      } 
      return this.attachmentsBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.m;
    }
    
    private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimestampFieldBuilder() {
      if (this.timestampBuilder_ == null) {
        this.timestampBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTimestamp(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.timestamp_ = null;
      } 
      return this.timestampBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      if (Distribution.Exemplar.alwaysUseFieldBuilders)
        getAttachmentsFieldBuilder(); 
    }
    
    public Builder addAllAttachments(Iterable<? extends Any> param1Iterable) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAttachmentsIsMutable();
        AbstractMessageLite.Builder.addAll(param1Iterable, this.attachments_);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addAllMessages(param1Iterable);
      return this;
    }
    
    public Builder addAttachments(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAttachmentsIsMutable();
        this.attachments_.add(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAttachments(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureAttachmentsIsMutable();
          this.attachments_.add(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder addAttachments(Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAttachmentsIsMutable();
        this.attachments_.add(param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder addAttachments(Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureAttachmentsIsMutable();
          this.attachments_.add(param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.addMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Any.Builder addAttachmentsBuilder() {
      return (Any.Builder)getAttachmentsFieldBuilder().addBuilder((AbstractMessage)Any.getDefaultInstance());
    }
    
    public Any.Builder addAttachmentsBuilder(int param1Int) {
      return (Any.Builder)getAttachmentsFieldBuilder().addBuilder(param1Int, (AbstractMessage)Any.getDefaultInstance());
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.Exemplar build() {
      Distribution.Exemplar exemplar = buildPartial();
      if (exemplar.isInitialized())
        return exemplar; 
      throw newUninitializedMessageException(exemplar);
    }
    
    public Distribution.Exemplar buildPartial() {
      Distribution.Exemplar exemplar = new Distribution.Exemplar(this);
      int i = this.bitField0_;
      Distribution.Exemplar.access$5402(exemplar, this.value_);
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 == null) {
        Distribution.Exemplar.access$5502(exemplar, this.timestamp_);
      } else {
        Distribution.Exemplar.access$5502(exemplar, (Timestamp)singleFieldBuilderV3.build());
      } 
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if ((this.bitField0_ & 0x4) != 0) {
          this.attachments_ = Collections.unmodifiableList(this.attachments_);
          this.bitField0_ &= 0xFFFFFFFB;
        } 
        Distribution.Exemplar.access$5602(exemplar, this.attachments_);
      } else {
        Distribution.Exemplar.access$5602(exemplar, repeatedFieldBuilderV3.build());
      } 
      Distribution.Exemplar.access$5702(exemplar, 0);
      onBuilt();
      return exemplar;
    }
    
    public Builder clear() {
      super.clear();
      this.value_ = 0.0D;
      if (this.timestampBuilder_ == null) {
        this.timestamp_ = null;
      } else {
        this.timestamp_ = null;
        this.timestampBuilder_ = null;
      } 
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.attachments_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
        return this;
      } 
      repeatedFieldBuilderV3.clear();
      return this;
    }
    
    public Builder clearAttachments() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        this.attachments_ = Collections.emptyList();
        this.bitField0_ &= 0xFFFFFFFB;
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
    
    public Builder clearTimestamp() {
      if (this.timestampBuilder_ == null) {
        this.timestamp_ = null;
        onChanged();
        return this;
      } 
      this.timestamp_ = null;
      this.timestampBuilder_ = null;
      return this;
    }
    
    public Builder clearValue() {
      this.value_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Any getAttachments(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.attachments_.get(param1Int) : (Any)repeatedFieldBuilderV3.getMessage(param1Int);
    }
    
    public Any.Builder getAttachmentsBuilder(int param1Int) {
      return (Any.Builder)getAttachmentsFieldBuilder().getBuilder(param1Int);
    }
    
    public List<Any.Builder> getAttachmentsBuilderList() {
      return getAttachmentsFieldBuilder().getBuilderList();
    }
    
    public int getAttachmentsCount() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? this.attachments_.size() : repeatedFieldBuilderV3.getCount();
    }
    
    public List<Any> getAttachmentsList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? Collections.unmodifiableList(this.attachments_) : repeatedFieldBuilderV3.getMessageList();
    }
    
    public AnyOrBuilder getAttachmentsOrBuilder(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      return (repeatedFieldBuilderV3 == null) ? (AnyOrBuilder)this.attachments_.get(param1Int) : (AnyOrBuilder)repeatedFieldBuilderV3.getMessageOrBuilder(param1Int);
    }
    
    public List<? extends AnyOrBuilder> getAttachmentsOrBuilderList() {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      return (repeatedFieldBuilderV3 != null) ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.attachments_);
    }
    
    public Distribution.Exemplar getDefaultInstanceForType() {
      return Distribution.Exemplar.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.m;
    }
    
    public Timestamp getTimestamp() {
      Timestamp timestamp;
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 == null) {
        Timestamp timestamp1 = this.timestamp_;
        timestamp = timestamp1;
        if (timestamp1 == null)
          timestamp = Timestamp.getDefaultInstance(); 
        return timestamp;
      } 
      return (Timestamp)timestamp.getMessage();
    }
    
    public Timestamp.Builder getTimestampBuilder() {
      onChanged();
      return (Timestamp.Builder)getTimestampFieldBuilder().getBuilder();
    }
    
    public TimestampOrBuilder getTimestampOrBuilder() {
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 != null)
        return (TimestampOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Timestamp timestamp2 = this.timestamp_;
      Timestamp timestamp1 = timestamp2;
      if (timestamp2 == null)
        timestamp1 = Timestamp.getDefaultInstance(); 
      return (TimestampOrBuilder)timestamp1;
    }
    
    public double getValue() {
      return this.value_;
    }
    
    public boolean hasTimestamp() {
      return (this.timestampBuilder_ != null || this.timestamp_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.n.ensureFieldAccessorsInitialized(Distribution.Exemplar.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Distribution.Exemplar param1Exemplar) {
      if (param1Exemplar == Distribution.Exemplar.getDefaultInstance())
        return this; 
      if (param1Exemplar.getValue() != 0.0D)
        setValue(param1Exemplar.getValue()); 
      if (param1Exemplar.hasTimestamp())
        mergeTimestamp(param1Exemplar.getTimestamp()); 
      if (this.attachmentsBuilder_ == null) {
        if (!param1Exemplar.attachments_.isEmpty()) {
          if (this.attachments_.isEmpty()) {
            this.attachments_ = param1Exemplar.attachments_;
            this.bitField0_ &= 0xFFFFFFFB;
          } else {
            ensureAttachmentsIsMutable();
            this.attachments_.addAll(param1Exemplar.attachments_);
          } 
          onChanged();
        } 
      } else if (!param1Exemplar.attachments_.isEmpty()) {
        if (this.attachmentsBuilder_.isEmpty()) {
          this.attachmentsBuilder_.dispose();
          RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = null;
          this.attachmentsBuilder_ = null;
          this.attachments_ = param1Exemplar.attachments_;
          this.bitField0_ &= 0xFFFFFFFB;
          if (Distribution.Exemplar.alwaysUseFieldBuilders)
            repeatedFieldBuilderV3 = getAttachmentsFieldBuilder(); 
          this.attachmentsBuilder_ = repeatedFieldBuilderV3;
        } else {
          this.attachmentsBuilder_.addAllMessages(param1Exemplar.attachments_);
        } 
      } 
      mergeUnknownFields(param1Exemplar.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.Exemplar exemplar = (Distribution.Exemplar)Distribution.Exemplar.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.Exemplar exemplar = (Distribution.Exemplar)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.Exemplar)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.Exemplar)
        return mergeFrom((Distribution.Exemplar)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeTimestamp(Timestamp param1Timestamp) {
      Timestamp timestamp;
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 == null) {
        timestamp = this.timestamp_;
        if (timestamp != null) {
          this.timestamp_ = Timestamp.newBuilder(timestamp).mergeFrom(param1Timestamp).buildPartial();
        } else {
          this.timestamp_ = param1Timestamp;
        } 
        onChanged();
        return this;
      } 
      timestamp.mergeFrom((AbstractMessage)param1Timestamp);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder removeAttachments(int param1Int) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAttachmentsIsMutable();
        this.attachments_.remove(param1Int);
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.remove(param1Int);
      return this;
    }
    
    public Builder setAttachments(int param1Int, Any.Builder param1Builder) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        ensureAttachmentsIsMutable();
        this.attachments_.set(param1Int, param1Builder.build());
        onChanged();
        return this;
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setAttachments(int param1Int, Any param1Any) {
      RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
      if (repeatedFieldBuilderV3 == null) {
        if (param1Any != null) {
          ensureAttachmentsIsMutable();
          this.attachments_.set(param1Int, param1Any);
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      repeatedFieldBuilderV3.setMessage(param1Int, (AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTimestamp(Timestamp.Builder param1Builder) {
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.timestamp_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTimestamp(Timestamp param1Timestamp) {
      SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Timestamp != null) {
          this.timestamp_ = param1Timestamp;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Timestamp);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setValue(double param1Double) {
      this.value_ = param1Double;
      onChanged();
      return this;
    }
  }
  
  public static interface ExemplarOrBuilder extends MessageOrBuilder {
    Any getAttachments(int param1Int);
    
    int getAttachmentsCount();
    
    List<Any> getAttachmentsList();
    
    AnyOrBuilder getAttachmentsOrBuilder(int param1Int);
    
    List<? extends AnyOrBuilder> getAttachmentsOrBuilderList();
    
    Timestamp getTimestamp();
    
    TimestampOrBuilder getTimestampOrBuilder();
    
    double getValue();
    
    boolean hasTimestamp();
  }
  
  public static final class Range extends GeneratedMessageV3 implements RangeOrBuilder {
    private static final Range DEFAULT_INSTANCE = new Range();
    
    public static final int MAX_FIELD_NUMBER = 2;
    
    public static final int MIN_FIELD_NUMBER = 1;
    
    private static final Parser<Range> PARSER = (Parser<Range>)new AbstractParser<Range>() {
        public Distribution.Range a(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new Distribution.Range(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private double max_;
    
    private byte memoizedIsInitialized = -1;
    
    private double min_;
    
    private Range() {}
    
    private Range(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 9) {
                if (i != 17) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.max_ = param1CodedInputStream.readDouble();
                continue;
              } 
              this.min_ = param1CodedInputStream.readDouble();
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
          throw param1CodedInputStream;
        } 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Range(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Range getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.c;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Range param1Range) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Range);
    }
    
    public static Range parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Range)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Range parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ByteString);
    }
    
    public static Range parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Range)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Range parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(InputStream param1InputStream) throws IOException {
      return (Range)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Range parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Range)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Range parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Range parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Range parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Range)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Range> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Range))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (Double.doubleToLongBits(getMin()) != Double.doubleToLongBits(param1Object.getMin())) ? false : ((Double.doubleToLongBits(getMax()) != Double.doubleToLongBits(param1Object.getMax())) ? false : (!!this.unknownFields.equals(((Range)param1Object).unknownFields)));
    }
    
    public Range getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public double getMax() {
      return this.max_;
    }
    
    public double getMin() {
      return this.min_;
    }
    
    public Parser<Range> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      double d = this.min_;
      if (d != 0.0D)
        i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
      d = this.max_;
      int j = i;
      if (d != 0.0D)
        j = i + CodedOutputStream.computeDoubleSize(2, d); 
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
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(Double.doubleToLongBits(getMin()))) * 37 + 2) * 53 + Internal.hashLong(Double.doubleToLongBits(getMax()))) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.d.ensureFieldAccessorsInitialized(Range.class, Builder.class);
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
      double d = this.min_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(1, d); 
      d = this.max_;
      if (d != 0.0D)
        param1CodedOutputStream.writeDouble(2, d); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Distribution.RangeOrBuilder {
      private double max_;
      
      private double min_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return DistributionProto.c;
      }
      
      private void maybeForceBuilderInitialization() {
        Distribution.Range.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public Distribution.Range build() {
        Distribution.Range range = buildPartial();
        if (range.isInitialized())
          return range; 
        throw newUninitializedMessageException(range);
      }
      
      public Distribution.Range buildPartial() {
        Distribution.Range range = new Distribution.Range(this);
        Distribution.Range.access$402(range, this.min_);
        Distribution.Range.access$502(range, this.max_);
        onBuilt();
        return range;
      }
      
      public Builder clear() {
        super.clear();
        this.min_ = 0.0D;
        this.max_ = 0.0D;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearMax() {
        this.max_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearMin() {
        this.min_ = 0.0D;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Distribution.Range getDefaultInstanceForType() {
        return Distribution.Range.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return DistributionProto.c;
      }
      
      public double getMax() {
        return this.max_;
      }
      
      public double getMin() {
        return this.min_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return DistributionProto.d.ensureFieldAccessorsInitialized(Distribution.Range.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(Distribution.Range param2Range) {
        if (param2Range == Distribution.Range.getDefaultInstance())
          return this; 
        if (param2Range.getMin() != 0.0D)
          setMin(param2Range.getMin()); 
        if (param2Range.getMax() != 0.0D)
          setMax(param2Range.getMax()); 
        mergeUnknownFields(param2Range.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          Distribution.Range range = (Distribution.Range)Distribution.Range.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          Distribution.Range range = (Distribution.Range)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((Distribution.Range)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof Distribution.Range)
          return mergeFrom((Distribution.Range)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setMax(double param2Double) {
        this.max_ = param2Double;
        onChanged();
        return this;
      }
      
      public Builder setMin(double param2Double) {
        this.min_ = param2Double;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Range> {
    public Distribution.Range a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new Distribution.Range(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Range.Builder> implements RangeOrBuilder {
    private double max_;
    
    private double min_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return DistributionProto.c;
    }
    
    private void maybeForceBuilderInitialization() {
      Distribution.Range.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Distribution.Range build() {
      Distribution.Range range = buildPartial();
      if (range.isInitialized())
        return range; 
      throw newUninitializedMessageException(range);
    }
    
    public Distribution.Range buildPartial() {
      Distribution.Range range = new Distribution.Range(this);
      Distribution.Range.access$402(range, this.min_);
      Distribution.Range.access$502(range, this.max_);
      onBuilt();
      return range;
    }
    
    public Builder clear() {
      super.clear();
      this.min_ = 0.0D;
      this.max_ = 0.0D;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMax() {
      this.max_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearMin() {
      this.min_ = 0.0D;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Distribution.Range getDefaultInstanceForType() {
      return Distribution.Range.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return DistributionProto.c;
    }
    
    public double getMax() {
      return this.max_;
    }
    
    public double getMin() {
      return this.min_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return DistributionProto.d.ensureFieldAccessorsInitialized(Distribution.Range.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(Distribution.Range param1Range) {
      if (param1Range == Distribution.Range.getDefaultInstance())
        return this; 
      if (param1Range.getMin() != 0.0D)
        setMin(param1Range.getMin()); 
      if (param1Range.getMax() != 0.0D)
        setMax(param1Range.getMax()); 
      mergeUnknownFields(param1Range.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Distribution.Range range = (Distribution.Range)Distribution.Range.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Distribution.Range range = (Distribution.Range)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Distribution.Range)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Distribution.Range)
        return mergeFrom((Distribution.Range)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMax(double param1Double) {
      this.max_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setMin(double param1Double) {
      this.min_ = param1Double;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface RangeOrBuilder extends MessageOrBuilder {
    double getMax();
    
    double getMin();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\api\Distribution.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */