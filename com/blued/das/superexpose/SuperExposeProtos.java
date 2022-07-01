package com.blued.das.superexpose;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SuperExposeProtos {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\027SuperExposeProtos.proto\022\031com.blued.das.superexpose\"©\001\n\020SuperExposeProto\022/\n\005event\030\001 \001(\0162 .com.blued.das.superexpose.Event\022\n\n\002id\030\002 \001(\t\022\021\n\tbubble_id\030\003 \001(\003\022\016\n\006sku_id\030\004 \001(\t\022\023\n\013discount_id\030\005 \001(\t\022\020\n\bstrategy\030\006 \001(\005\022\016\n\006region\030\007 \001(\005*Í\001\n\005Event\022\021\n\rUNKNOWN_EVENT\020\000\022'\n#AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY\020\001\022%\n!PERSONAL_PAGE_HISTORY_BUBBLE_SHOW\020\002\022\030\n\024EXPOSE_BUY_PAGE_SHOW\020\003\022\035\n\031EXPOSE_BUY_PAGE_PAY_CLICK\020\004\022(\n$AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW\020\005B\017¢\002\fSUPER_EXPOSEb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor, new String[] { "Event", "Id", "BubbleId", "SkuId", "DiscountId", "Strategy", "Region" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public enum Event implements ProtocolMessageEnum {
    AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY,
    AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW,
    EXPOSE_BUY_PAGE_PAY_CLICK,
    EXPOSE_BUY_PAGE_SHOW,
    PERSONAL_PAGE_HISTORY_BUBBLE_SHOW,
    UNKNOWN_EVENT(0),
    UNRECOGNIZED(0);
    
    public static final int AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY_VALUE = 1;
    
    public static final int AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW_VALUE = 5;
    
    public static final int EXPOSE_BUY_PAGE_PAY_CLICK_VALUE = 4;
    
    public static final int EXPOSE_BUY_PAGE_SHOW_VALUE = 3;
    
    public static final int PERSONAL_PAGE_HISTORY_BUBBLE_SHOW_VALUE = 2;
    
    public static final int UNKNOWN_EVENT_VALUE = 0;
    
    private static final Event[] VALUES;
    
    private static final Internal.EnumLiteMap<Event> internalValueMap;
    
    private final int value;
    
    static {
      EXPOSE_BUY_PAGE_SHOW = new Event("EXPOSE_BUY_PAGE_SHOW", 3, 3);
      EXPOSE_BUY_PAGE_PAY_CLICK = new Event("EXPOSE_BUY_PAGE_PAY_CLICK", 4, 4);
      AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW = new Event("AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW", 5, 5);
      UNRECOGNIZED = new Event("UNRECOGNIZED", 6, -1);
      $VALUES = new Event[] { UNKNOWN_EVENT, AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY, PERSONAL_PAGE_HISTORY_BUBBLE_SHOW, EXPOSE_BUY_PAGE_SHOW, EXPOSE_BUY_PAGE_PAY_CLICK, AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Event>() {
          public SuperExposeProtos.Event findValueByNumber(int param2Int) {
            return SuperExposeProtos.Event.forNumber(param2Int);
          }
        };
      VALUES = values();
    }
    
    Event(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Event forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 1) ? ((param1Int != 2) ? ((param1Int != 3) ? ((param1Int != 4) ? ((param1Int != 5) ? null : AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW) : EXPOSE_BUY_PAGE_PAY_CLICK) : EXPOSE_BUY_PAGE_SHOW) : PERSONAL_PAGE_HISTORY_BUBBLE_SHOW) : AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY) : UNKNOWN_EVENT;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return SuperExposeProtos.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<Event> internalGetValueMap() {
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
      if (this != UNRECOGNIZED)
        return getDescriptor().getValues().get(ordinal()); 
      throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
    }
  }
  
  static final class null implements Internal.EnumLiteMap<Event> {
    public SuperExposeProtos.Event findValueByNumber(int param1Int) {
      return SuperExposeProtos.Event.forNumber(param1Int);
    }
  }
  
  public static final class SuperExposeProto extends GeneratedMessageV3 implements SuperExposeProtoOrBuilder {
    public static final int BUBBLE_ID_FIELD_NUMBER = 3;
    
    private static final SuperExposeProto DEFAULT_INSTANCE = new SuperExposeProto();
    
    public static final int DISCOUNT_ID_FIELD_NUMBER = 5;
    
    public static final int EVENT_FIELD_NUMBER = 1;
    
    public static final int ID_FIELD_NUMBER = 2;
    
    private static final Parser<SuperExposeProto> PARSER = (Parser<SuperExposeProto>)new AbstractParser<SuperExposeProto>() {
        public SuperExposeProtos.SuperExposeProto parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new SuperExposeProtos.SuperExposeProto(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REGION_FIELD_NUMBER = 7;
    
    public static final int SKU_ID_FIELD_NUMBER = 4;
    
    public static final int STRATEGY_FIELD_NUMBER = 6;
    
    private static final long serialVersionUID = 0L;
    
    private long bubbleId_;
    
    private volatile Object discountId_;
    
    private int event_;
    
    private volatile Object id_;
    
    private byte memoizedIsInitialized = -1;
    
    private int region_;
    
    private volatile Object skuId_;
    
    private int strategy_;
    
    private SuperExposeProto() {
      this.event_ = 0;
      this.id_ = "";
      this.skuId_ = "";
      this.discountId_ = "";
    }
    
    private SuperExposeProto(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 18) {
                  if (i != 24) {
                    if (i != 34) {
                      if (i != 42) {
                        if (i != 48) {
                          if (i != 56) {
                            if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                              continue; 
                            continue;
                          } 
                          this.region_ = param1CodedInputStream.readInt32();
                          continue;
                        } 
                        this.strategy_ = param1CodedInputStream.readInt32();
                        continue;
                      } 
                      this.discountId_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.skuId_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.bubbleId_ = param1CodedInputStream.readInt64();
                  continue;
                } 
                this.id_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.event_ = param1CodedInputStream.readEnum();
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
    
    private SuperExposeProto(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static SuperExposeProto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(SuperExposeProto param1SuperExposeProto) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1SuperExposeProto);
    }
    
    public static SuperExposeProto parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static SuperExposeProto parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SuperExposeProto parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ByteString);
    }
    
    public static SuperExposeProto parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static SuperExposeProto parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static SuperExposeProto parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static SuperExposeProto parseFrom(InputStream param1InputStream) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static SuperExposeProto parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (SuperExposeProto)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static SuperExposeProto parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static SuperExposeProto parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static SuperExposeProto parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static SuperExposeProto parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (SuperExposeProto)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<SuperExposeProto> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof SuperExposeProto))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.event_ != ((SuperExposeProto)param1Object).event_) ? false : (!getId().equals(param1Object.getId()) ? false : ((getBubbleId() != param1Object.getBubbleId()) ? false : (!getSkuId().equals(param1Object.getSkuId()) ? false : (!getDiscountId().equals(param1Object.getDiscountId()) ? false : ((getStrategy() != param1Object.getStrategy()) ? false : ((getRegion() != param1Object.getRegion()) ? false : (!!this.unknownFields.equals(((SuperExposeProto)param1Object).unknownFields))))))));
    }
    
    public long getBubbleId() {
      return this.bubbleId_;
    }
    
    public SuperExposeProto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDiscountId() {
      Object object = this.discountId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.discountId_ = object;
      return (String)object;
    }
    
    public ByteString getDiscountIdBytes() {
      Object object = this.discountId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.discountId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public SuperExposeProtos.Event getEvent() {
      SuperExposeProtos.Event event2 = SuperExposeProtos.Event.valueOf(this.event_);
      SuperExposeProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SuperExposeProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getId() {
      Object object = this.id_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.id_ = object;
      return (String)object;
    }
    
    public ByteString getIdBytes() {
      Object object = this.id_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.id_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<SuperExposeProto> getParserForType() {
      return PARSER;
    }
    
    public int getRegion() {
      return this.region_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.event_ != SuperExposeProtos.Event.UNKNOWN_EVENT.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.event_); 
      i = j;
      if (!getIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.id_); 
      long l = this.bubbleId_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(3, l); 
      i = j;
      if (!getSkuIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.skuId_); 
      j = i;
      if (!getDiscountIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.discountId_); 
      int k = this.strategy_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(6, k); 
      k = this.region_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(7, k); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public String getSkuId() {
      Object object = this.skuId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.skuId_ = object;
      return (String)object;
    }
    
    public ByteString getSkuIdBytes() {
      Object object = this.skuId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.skuId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getStrategy() {
      return this.strategy_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.event_) * 37 + 2) * 53 + getId().hashCode()) * 37 + 3) * 53 + Internal.hashLong(getBubbleId())) * 37 + 4) * 53 + getSkuId().hashCode()) * 37 + 5) * 53 + getDiscountId().hashCode()) * 37 + 6) * 53 + getStrategy()) * 37 + 7) * 53 + getRegion()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SuperExposeProto.class, Builder.class);
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
    
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter param1UnusedPrivateParameter) {
      return new SuperExposeProto();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.event_ != SuperExposeProtos.Event.UNKNOWN_EVENT.getNumber())
        param1CodedOutputStream.writeEnum(1, this.event_); 
      if (!getIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.id_); 
      long l = this.bubbleId_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(3, l); 
      if (!getSkuIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.skuId_); 
      if (!getDiscountIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.discountId_); 
      int i = this.strategy_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(6, i); 
      i = this.region_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(7, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SuperExposeProtos.SuperExposeProtoOrBuilder {
      private long bubbleId_;
      
      private Object discountId_ = "";
      
      private int event_ = 0;
      
      private Object id_ = "";
      
      private int region_;
      
      private Object skuId_ = "";
      
      private int strategy_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        SuperExposeProtos.SuperExposeProto.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public SuperExposeProtos.SuperExposeProto build() {
        SuperExposeProtos.SuperExposeProto superExposeProto = buildPartial();
        if (superExposeProto.isInitialized())
          return superExposeProto; 
        throw newUninitializedMessageException(superExposeProto);
      }
      
      public SuperExposeProtos.SuperExposeProto buildPartial() {
        SuperExposeProtos.SuperExposeProto superExposeProto = new SuperExposeProtos.SuperExposeProto(this);
        SuperExposeProtos.SuperExposeProto.access$602(superExposeProto, this.event_);
        SuperExposeProtos.SuperExposeProto.access$702(superExposeProto, this.id_);
        SuperExposeProtos.SuperExposeProto.access$802(superExposeProto, this.bubbleId_);
        SuperExposeProtos.SuperExposeProto.access$902(superExposeProto, this.skuId_);
        SuperExposeProtos.SuperExposeProto.access$1002(superExposeProto, this.discountId_);
        SuperExposeProtos.SuperExposeProto.access$1102(superExposeProto, this.strategy_);
        SuperExposeProtos.SuperExposeProto.access$1202(superExposeProto, this.region_);
        onBuilt();
        return superExposeProto;
      }
      
      public Builder clear() {
        super.clear();
        this.event_ = 0;
        this.id_ = "";
        this.bubbleId_ = 0L;
        this.skuId_ = "";
        this.discountId_ = "";
        this.strategy_ = 0;
        this.region_ = 0;
        return this;
      }
      
      public Builder clearBubbleId() {
        this.bubbleId_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearDiscountId() {
        this.discountId_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getDiscountId();
        onChanged();
        return this;
      }
      
      public Builder clearEvent() {
        this.event_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearId() {
        this.id_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getId();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearRegion() {
        this.region_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSkuId() {
        this.skuId_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getSkuId();
        onChanged();
        return this;
      }
      
      public Builder clearStrategy() {
        this.strategy_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public long getBubbleId() {
        return this.bubbleId_;
      }
      
      public SuperExposeProtos.SuperExposeProto getDefaultInstanceForType() {
        return SuperExposeProtos.SuperExposeProto.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
      }
      
      public String getDiscountId() {
        Object object = this.discountId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.discountId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDiscountIdBytes() {
        Object object = this.discountId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.discountId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public SuperExposeProtos.Event getEvent() {
        SuperExposeProtos.Event event2 = SuperExposeProtos.Event.valueOf(this.event_);
        SuperExposeProtos.Event event1 = event2;
        if (event2 == null)
          event1 = SuperExposeProtos.Event.UNRECOGNIZED; 
        return event1;
      }
      
      public int getEventValue() {
        return this.event_;
      }
      
      public String getId() {
        Object object = this.id_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.id_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getIdBytes() {
        Object object = this.id_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.id_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getRegion() {
        return this.region_;
      }
      
      public String getSkuId() {
        Object object = this.skuId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.skuId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getSkuIdBytes() {
        Object object = this.skuId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.skuId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getStrategy() {
        return this.strategy_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SuperExposeProtos.SuperExposeProto.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(SuperExposeProtos.SuperExposeProto param2SuperExposeProto) {
        if (param2SuperExposeProto == SuperExposeProtos.SuperExposeProto.getDefaultInstance())
          return this; 
        if (param2SuperExposeProto.event_ != 0)
          setEventValue(param2SuperExposeProto.getEventValue()); 
        if (!param2SuperExposeProto.getId().isEmpty()) {
          this.id_ = param2SuperExposeProto.id_;
          onChanged();
        } 
        if (param2SuperExposeProto.getBubbleId() != 0L)
          setBubbleId(param2SuperExposeProto.getBubbleId()); 
        if (!param2SuperExposeProto.getSkuId().isEmpty()) {
          this.skuId_ = param2SuperExposeProto.skuId_;
          onChanged();
        } 
        if (!param2SuperExposeProto.getDiscountId().isEmpty()) {
          this.discountId_ = param2SuperExposeProto.discountId_;
          onChanged();
        } 
        if (param2SuperExposeProto.getStrategy() != 0)
          setStrategy(param2SuperExposeProto.getStrategy()); 
        if (param2SuperExposeProto.getRegion() != 0)
          setRegion(param2SuperExposeProto.getRegion()); 
        mergeUnknownFields(param2SuperExposeProto.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          SuperExposeProtos.SuperExposeProto superExposeProto = (SuperExposeProtos.SuperExposeProto)SuperExposeProtos.SuperExposeProto.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          SuperExposeProtos.SuperExposeProto superExposeProto = (SuperExposeProtos.SuperExposeProto)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((SuperExposeProtos.SuperExposeProto)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof SuperExposeProtos.SuperExposeProto)
          return mergeFrom((SuperExposeProtos.SuperExposeProto)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBubbleId(long param2Long) {
        this.bubbleId_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setDiscountId(String param2String) {
        if (param2String != null) {
          this.discountId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDiscountIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param2ByteString);
          this.discountId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEvent(SuperExposeProtos.Event param2Event) {
        if (param2Event != null) {
          this.event_ = param2Event.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setEventValue(int param2Int) {
        this.event_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setId(String param2String) {
        if (param2String != null) {
          this.id_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param2ByteString);
          this.id_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRegion(int param2Int) {
        this.region_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSkuId(String param2String) {
        if (param2String != null) {
          this.skuId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setSkuIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param2ByteString);
          this.skuId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setStrategy(int param2Int) {
        this.strategy_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<SuperExposeProto> {
    public SuperExposeProtos.SuperExposeProto parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new SuperExposeProtos.SuperExposeProto(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<SuperExposeProto.Builder> implements SuperExposeProtoOrBuilder {
    private long bubbleId_;
    
    private Object discountId_ = "";
    
    private int event_ = 0;
    
    private Object id_ = "";
    
    private int region_;
    
    private Object skuId_ = "";
    
    private int strategy_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      SuperExposeProtos.SuperExposeProto.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public SuperExposeProtos.SuperExposeProto build() {
      SuperExposeProtos.SuperExposeProto superExposeProto = buildPartial();
      if (superExposeProto.isInitialized())
        return superExposeProto; 
      throw newUninitializedMessageException(superExposeProto);
    }
    
    public SuperExposeProtos.SuperExposeProto buildPartial() {
      SuperExposeProtos.SuperExposeProto superExposeProto = new SuperExposeProtos.SuperExposeProto(this);
      SuperExposeProtos.SuperExposeProto.access$602(superExposeProto, this.event_);
      SuperExposeProtos.SuperExposeProto.access$702(superExposeProto, this.id_);
      SuperExposeProtos.SuperExposeProto.access$802(superExposeProto, this.bubbleId_);
      SuperExposeProtos.SuperExposeProto.access$902(superExposeProto, this.skuId_);
      SuperExposeProtos.SuperExposeProto.access$1002(superExposeProto, this.discountId_);
      SuperExposeProtos.SuperExposeProto.access$1102(superExposeProto, this.strategy_);
      SuperExposeProtos.SuperExposeProto.access$1202(superExposeProto, this.region_);
      onBuilt();
      return superExposeProto;
    }
    
    public Builder clear() {
      super.clear();
      this.event_ = 0;
      this.id_ = "";
      this.bubbleId_ = 0L;
      this.skuId_ = "";
      this.discountId_ = "";
      this.strategy_ = 0;
      this.region_ = 0;
      return this;
    }
    
    public Builder clearBubbleId() {
      this.bubbleId_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearDiscountId() {
      this.discountId_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getDiscountId();
      onChanged();
      return this;
    }
    
    public Builder clearEvent() {
      this.event_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearId() {
      this.id_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getId();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRegion() {
      this.region_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSkuId() {
      this.skuId_ = SuperExposeProtos.SuperExposeProto.getDefaultInstance().getSkuId();
      onChanged();
      return this;
    }
    
    public Builder clearStrategy() {
      this.strategy_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public long getBubbleId() {
      return this.bubbleId_;
    }
    
    public SuperExposeProtos.SuperExposeProto getDefaultInstanceForType() {
      return SuperExposeProtos.SuperExposeProto.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
    }
    
    public String getDiscountId() {
      Object object = this.discountId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.discountId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDiscountIdBytes() {
      Object object = this.discountId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.discountId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public SuperExposeProtos.Event getEvent() {
      SuperExposeProtos.Event event2 = SuperExposeProtos.Event.valueOf(this.event_);
      SuperExposeProtos.Event event1 = event2;
      if (event2 == null)
        event1 = SuperExposeProtos.Event.UNRECOGNIZED; 
      return event1;
    }
    
    public int getEventValue() {
      return this.event_;
    }
    
    public String getId() {
      Object object = this.id_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.id_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getIdBytes() {
      Object object = this.id_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.id_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getRegion() {
      return this.region_;
    }
    
    public String getSkuId() {
      Object object = this.skuId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.skuId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getSkuIdBytes() {
      Object object = this.skuId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.skuId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getStrategy() {
      return this.strategy_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SuperExposeProtos.SuperExposeProto.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(SuperExposeProtos.SuperExposeProto param1SuperExposeProto) {
      if (param1SuperExposeProto == SuperExposeProtos.SuperExposeProto.getDefaultInstance())
        return this; 
      if (param1SuperExposeProto.event_ != 0)
        setEventValue(param1SuperExposeProto.getEventValue()); 
      if (!param1SuperExposeProto.getId().isEmpty()) {
        this.id_ = param1SuperExposeProto.id_;
        onChanged();
      } 
      if (param1SuperExposeProto.getBubbleId() != 0L)
        setBubbleId(param1SuperExposeProto.getBubbleId()); 
      if (!param1SuperExposeProto.getSkuId().isEmpty()) {
        this.skuId_ = param1SuperExposeProto.skuId_;
        onChanged();
      } 
      if (!param1SuperExposeProto.getDiscountId().isEmpty()) {
        this.discountId_ = param1SuperExposeProto.discountId_;
        onChanged();
      } 
      if (param1SuperExposeProto.getStrategy() != 0)
        setStrategy(param1SuperExposeProto.getStrategy()); 
      if (param1SuperExposeProto.getRegion() != 0)
        setRegion(param1SuperExposeProto.getRegion()); 
      mergeUnknownFields(param1SuperExposeProto.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        SuperExposeProtos.SuperExposeProto superExposeProto = (SuperExposeProtos.SuperExposeProto)SuperExposeProtos.SuperExposeProto.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        SuperExposeProtos.SuperExposeProto superExposeProto = (SuperExposeProtos.SuperExposeProto)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((SuperExposeProtos.SuperExposeProto)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof SuperExposeProtos.SuperExposeProto)
        return mergeFrom((SuperExposeProtos.SuperExposeProto)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBubbleId(long param1Long) {
      this.bubbleId_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setDiscountId(String param1String) {
      if (param1String != null) {
        this.discountId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDiscountIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param1ByteString);
        this.discountId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEvent(SuperExposeProtos.Event param1Event) {
      if (param1Event != null) {
        this.event_ = param1Event.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setEventValue(int param1Int) {
      this.event_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setId(String param1String) {
      if (param1String != null) {
        this.id_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param1ByteString);
        this.id_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRegion(int param1Int) {
      this.region_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSkuId(String param1String) {
      if (param1String != null) {
        this.skuId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setSkuIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        SuperExposeProtos.SuperExposeProto.checkByteStringIsUtf8(param1ByteString);
        this.skuId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setStrategy(int param1Int) {
      this.strategy_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface SuperExposeProtoOrBuilder extends MessageOrBuilder {
    long getBubbleId();
    
    String getDiscountId();
    
    ByteString getDiscountIdBytes();
    
    SuperExposeProtos.Event getEvent();
    
    int getEventValue();
    
    String getId();
    
    ByteString getIdBytes();
    
    int getRegion();
    
    String getSkuId();
    
    ByteString getSkuIdBytes();
    
    int getStrategy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\das\superexpose\SuperExposeProtos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */