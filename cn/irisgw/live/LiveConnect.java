package cn.irisgw.live;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LiveConnect {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveBasePackage_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveBasePackage_descriptor, new String[] { "PackageId", "NeedAck", "Body" });
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveSetting_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable;
  
  static {
    internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor, new String[] { "PackageId" });
    internal_static_cn_irisgw_live_LiveSetting_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveSetting_descriptor, new String[] { "AppVersion", "Platform", "Language", "OsVersion", "Device", "Channel" });
    AnyProto.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor = AnyProto.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\021liveConnect.proto\022\016cn.irisgw.live\032\031google/protobuf/any.proto\"[\n\017LiveBasePackage\022\022\n\npackage_id\030\001 \001(\004\022\020\n\bneed_ack\030\002 \001(\b\022\"\n\004body\030\003 \001(\0132\024.google.protobuf.Any\"(\n\022LiveBasePackageAck\022\022\n\npackage_id\030\001 \001(\004\"{\n\013LiveSetting\022\023\n\013app_version\030\001 \001(\t\022\020\n\bplatform\030\002 \001(\t\022\020\n\blanguage\030\003 \001(\t\022\022\n\nos_version\030\004 \001(\t\022\016\n\006device\030\005 \001(\t\022\017\n\007channel\030\006 \001(\t2L\n\rLiveConnector\022;\n\007Connect\022\024.google.protobuf.Any\032\024.google.protobuf.Any\"\000(\0010\001b\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class LiveBasePackage extends GeneratedMessageV3 implements LiveBasePackageOrBuilder {
    public static final int BODY_FIELD_NUMBER = 3;
    
    private static final LiveBasePackage DEFAULT_INSTANCE = new LiveBasePackage();
    
    public static final int NEED_ACK_FIELD_NUMBER = 2;
    
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    
    private static final Parser<LiveBasePackage> PARSER = (Parser<LiveBasePackage>)new AbstractParser<LiveBasePackage>() {
        public LiveConnect.LiveBasePackage parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveConnect.LiveBasePackage(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private Any body_;
    
    private byte memoizedIsInitialized = -1;
    
    private boolean needAck_;
    
    private long packageId_;
    
    private LiveBasePackage() {}
    
    private LiveBasePackage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 16) {
                  if (i != 26) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  Any.Builder builder1 = null;
                  if (this.body_ != null)
                    builder1 = this.body_.toBuilder(); 
                  this.body_ = (Any)param1CodedInputStream.readMessage(Any.parser(), param1ExtensionRegistryLite);
                  if (builder1 != null) {
                    builder1.mergeFrom(this.body_);
                    this.body_ = builder1.buildPartial();
                  } 
                  continue;
                } 
                this.needAck_ = param1CodedInputStream.readBool();
                continue;
              } 
              this.packageId_ = param1CodedInputStream.readUInt64();
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
    
    private LiveBasePackage(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveBasePackage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveBasePackage param1LiveBasePackage) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveBasePackage);
    }
    
    public static LiveBasePackage parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveBasePackage parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackage parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveBasePackage parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackage parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveBasePackage parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackage parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveBasePackage parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackage)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackage parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveBasePackage parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackage parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveBasePackage parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackage)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveBasePackage> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveBasePackage))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getPackageId() != param1Object.getPackageId()) ? false : ((getNeedAck() != param1Object.getNeedAck()) ? false : ((hasBody() != param1Object.hasBody()) ? false : ((hasBody() && !getBody().equals(param1Object.getBody())) ? false : (!!this.unknownFields.equals(((LiveBasePackage)param1Object).unknownFields)))));
    }
    
    public Any getBody() {
      Any any2 = this.body_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return any1;
    }
    
    public AnyOrBuilder getBodyOrBuilder() {
      return (AnyOrBuilder)getBody();
    }
    
    public LiveBasePackage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public boolean getNeedAck() {
      return this.needAck_;
    }
    
    public long getPackageId() {
      return this.packageId_;
    }
    
    public Parser<LiveBasePackage> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      long l = this.packageId_;
      if (l != 0L)
        j = 0 + CodedOutputStream.computeUInt64Size(1, l); 
      boolean bool = this.needAck_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(2, bool); 
      j = i;
      if (this.body_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getBody()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasBody() {
      return (this.body_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getPackageId())) * 37 + 2) * 53 + Internal.hashBoolean(getNeedAck());
      int i = j;
      if (hasBody())
        i = (j * 37 + 3) * 53 + getBody().hashCode(); 
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackage.class, Builder.class);
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
      return new LiveBasePackage();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.packageId_;
      if (l != 0L)
        param1CodedOutputStream.writeUInt64(1, l); 
      boolean bool = this.needAck_;
      if (bool)
        param1CodedOutputStream.writeBool(2, bool); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getBody()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveConnect.LiveBasePackageOrBuilder {
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
      
      private Any body_;
      
      private boolean needAck_;
      
      private long packageId_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getBodyFieldBuilder() {
        if (this.bodyBuilder_ == null) {
          this.bodyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBody(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.body_ = null;
        } 
        return this.bodyBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveConnect.LiveBasePackage.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveConnect.LiveBasePackage build() {
        LiveConnect.LiveBasePackage liveBasePackage = buildPartial();
        if (liveBasePackage.isInitialized())
          return liveBasePackage; 
        throw newUninitializedMessageException(liveBasePackage);
      }
      
      public LiveConnect.LiveBasePackage buildPartial() {
        LiveConnect.LiveBasePackage liveBasePackage = new LiveConnect.LiveBasePackage(this);
        LiveConnect.LiveBasePackage.access$602(liveBasePackage, this.packageId_);
        LiveConnect.LiveBasePackage.access$702(liveBasePackage, this.needAck_);
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          LiveConnect.LiveBasePackage.access$802(liveBasePackage, this.body_);
        } else {
          LiveConnect.LiveBasePackage.access$802(liveBasePackage, (Any)singleFieldBuilderV3.build());
        } 
        onBuilt();
        return liveBasePackage;
      }
      
      public Builder clear() {
        super.clear();
        this.packageId_ = 0L;
        this.needAck_ = false;
        if (this.bodyBuilder_ == null) {
          this.body_ = null;
          return this;
        } 
        this.body_ = null;
        this.bodyBuilder_ = null;
        return this;
      }
      
      public Builder clearBody() {
        if (this.bodyBuilder_ == null) {
          this.body_ = null;
          onChanged();
          return this;
        } 
        this.body_ = null;
        this.bodyBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearNeedAck() {
        this.needAck_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPackageId() {
        this.packageId_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public Any getBody() {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          Any any1 = this.body_;
          any = any1;
          if (any1 == null)
            any = Any.getDefaultInstance(); 
          return any;
        } 
        return (Any)any.getMessage();
      }
      
      public Any.Builder getBodyBuilder() {
        onChanged();
        return (Any.Builder)getBodyFieldBuilder().getBuilder();
      }
      
      public AnyOrBuilder getBodyOrBuilder() {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        Any any2 = this.body_;
        Any any1 = any2;
        if (any2 == null)
          any1 = Any.getDefaultInstance(); 
        return (AnyOrBuilder)any1;
      }
      
      public LiveConnect.LiveBasePackage getDefaultInstanceForType() {
        return LiveConnect.LiveBasePackage.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
      }
      
      public boolean getNeedAck() {
        return this.needAck_;
      }
      
      public long getPackageId() {
        return this.packageId_;
      }
      
      public boolean hasBody() {
        return (this.bodyBuilder_ != null || this.body_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveBasePackage.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeBody(Any param2Any) {
        Any any;
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          any = this.body_;
          if (any != null) {
            this.body_ = Any.newBuilder(any).mergeFrom(param2Any).buildPartial();
          } else {
            this.body_ = param2Any;
          } 
          onChanged();
          return this;
        } 
        any.mergeFrom((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder mergeFrom(LiveConnect.LiveBasePackage param2LiveBasePackage) {
        if (param2LiveBasePackage == LiveConnect.LiveBasePackage.getDefaultInstance())
          return this; 
        if (param2LiveBasePackage.getPackageId() != 0L)
          setPackageId(param2LiveBasePackage.getPackageId()); 
        if (param2LiveBasePackage.getNeedAck())
          setNeedAck(param2LiveBasePackage.getNeedAck()); 
        if (param2LiveBasePackage.hasBody())
          mergeBody(param2LiveBasePackage.getBody()); 
        mergeUnknownFields(param2LiveBasePackage.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveConnect.LiveBasePackage liveBasePackage = (LiveConnect.LiveBasePackage)LiveConnect.LiveBasePackage.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveConnect.LiveBasePackage liveBasePackage = (LiveConnect.LiveBasePackage)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveConnect.LiveBasePackage)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveConnect.LiveBasePackage)
          return mergeFrom((LiveConnect.LiveBasePackage)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBody(Any.Builder param2Builder) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.body_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setBody(Any param2Any) {
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Any != null) {
            this.body_ = param2Any;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Any);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setNeedAck(boolean param2Boolean) {
        this.needAck_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setPackageId(long param2Long) {
        this.packageId_ = param2Long;
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
  
  static final class null extends AbstractParser<LiveBasePackage> {
    public LiveConnect.LiveBasePackage parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveConnect.LiveBasePackage(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveBasePackage.Builder> implements LiveBasePackageOrBuilder {
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
    
    private Any body_;
    
    private boolean needAck_;
    
    private long packageId_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getBodyFieldBuilder() {
      if (this.bodyBuilder_ == null) {
        this.bodyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBody(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.body_ = null;
      } 
      return this.bodyBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveConnect.LiveBasePackage.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveConnect.LiveBasePackage build() {
      LiveConnect.LiveBasePackage liveBasePackage = buildPartial();
      if (liveBasePackage.isInitialized())
        return liveBasePackage; 
      throw newUninitializedMessageException(liveBasePackage);
    }
    
    public LiveConnect.LiveBasePackage buildPartial() {
      LiveConnect.LiveBasePackage liveBasePackage = new LiveConnect.LiveBasePackage(this);
      LiveConnect.LiveBasePackage.access$602(liveBasePackage, this.packageId_);
      LiveConnect.LiveBasePackage.access$702(liveBasePackage, this.needAck_);
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        LiveConnect.LiveBasePackage.access$802(liveBasePackage, this.body_);
      } else {
        LiveConnect.LiveBasePackage.access$802(liveBasePackage, (Any)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return liveBasePackage;
    }
    
    public Builder clear() {
      super.clear();
      this.packageId_ = 0L;
      this.needAck_ = false;
      if (this.bodyBuilder_ == null) {
        this.body_ = null;
        return this;
      } 
      this.body_ = null;
      this.bodyBuilder_ = null;
      return this;
    }
    
    public Builder clearBody() {
      if (this.bodyBuilder_ == null) {
        this.body_ = null;
        onChanged();
        return this;
      } 
      this.body_ = null;
      this.bodyBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearNeedAck() {
      this.needAck_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPackageId() {
      this.packageId_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Any getBody() {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        Any any1 = this.body_;
        any = any1;
        if (any1 == null)
          any = Any.getDefaultInstance(); 
        return any;
      } 
      return (Any)any.getMessage();
    }
    
    public Any.Builder getBodyBuilder() {
      onChanged();
      return (Any.Builder)getBodyFieldBuilder().getBuilder();
    }
    
    public AnyOrBuilder getBodyOrBuilder() {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AnyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      Any any2 = this.body_;
      Any any1 = any2;
      if (any2 == null)
        any1 = Any.getDefaultInstance(); 
      return (AnyOrBuilder)any1;
    }
    
    public LiveConnect.LiveBasePackage getDefaultInstanceForType() {
      return LiveConnect.LiveBasePackage.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_descriptor;
    }
    
    public boolean getNeedAck() {
      return this.needAck_;
    }
    
    public long getPackageId() {
      return this.packageId_;
    }
    
    public boolean hasBody() {
      return (this.bodyBuilder_ != null || this.body_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackage_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveBasePackage.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeBody(Any param1Any) {
      Any any;
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        any = this.body_;
        if (any != null) {
          this.body_ = Any.newBuilder(any).mergeFrom(param1Any).buildPartial();
        } else {
          this.body_ = param1Any;
        } 
        onChanged();
        return this;
      } 
      any.mergeFrom((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder mergeFrom(LiveConnect.LiveBasePackage param1LiveBasePackage) {
      if (param1LiveBasePackage == LiveConnect.LiveBasePackage.getDefaultInstance())
        return this; 
      if (param1LiveBasePackage.getPackageId() != 0L)
        setPackageId(param1LiveBasePackage.getPackageId()); 
      if (param1LiveBasePackage.getNeedAck())
        setNeedAck(param1LiveBasePackage.getNeedAck()); 
      if (param1LiveBasePackage.hasBody())
        mergeBody(param1LiveBasePackage.getBody()); 
      mergeUnknownFields(param1LiveBasePackage.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveConnect.LiveBasePackage liveBasePackage = (LiveConnect.LiveBasePackage)LiveConnect.LiveBasePackage.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveConnect.LiveBasePackage liveBasePackage = (LiveConnect.LiveBasePackage)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveConnect.LiveBasePackage)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveConnect.LiveBasePackage)
        return mergeFrom((LiveConnect.LiveBasePackage)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBody(Any.Builder param1Builder) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.body_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setBody(Any param1Any) {
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Any != null) {
          this.body_ = param1Any;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Any);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setNeedAck(boolean param1Boolean) {
      this.needAck_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setPackageId(long param1Long) {
      this.packageId_ = param1Long;
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
  
  public static final class LiveBasePackageAck extends GeneratedMessageV3 implements LiveBasePackageAckOrBuilder {
    private static final LiveBasePackageAck DEFAULT_INSTANCE = new LiveBasePackageAck();
    
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    
    private static final Parser<LiveBasePackageAck> PARSER = (Parser<LiveBasePackageAck>)new AbstractParser<LiveBasePackageAck>() {
        public LiveConnect.LiveBasePackageAck parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveConnect.LiveBasePackageAck(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private byte memoizedIsInitialized = -1;
    
    private long packageId_;
    
    private LiveBasePackageAck() {}
    
    private LiveBasePackageAck(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                  continue; 
                continue;
              } 
              this.packageId_ = param1CodedInputStream.readUInt64();
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
    
    private LiveBasePackageAck(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveBasePackageAck getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveBasePackageAck param1LiveBasePackageAck) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveBasePackageAck);
    }
    
    public static LiveBasePackageAck parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveBasePackageAck parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackageAck parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveBasePackageAck parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackageAck parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveBasePackageAck parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackageAck parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveBasePackageAck parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveBasePackageAck)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackageAck parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveBasePackageAck parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveBasePackageAck parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveBasePackageAck parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveBasePackageAck)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveBasePackageAck> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveBasePackageAck))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getPackageId() != param1Object.getPackageId()) ? false : (!!this.unknownFields.equals(((LiveBasePackageAck)param1Object).unknownFields));
    }
    
    public LiveBasePackageAck getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public long getPackageId() {
      return this.packageId_;
    }
    
    public Parser<LiveBasePackageAck> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      long l = this.packageId_;
      if (l != 0L)
        i = 0 + CodedOutputStream.computeUInt64Size(1, l); 
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
      int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + Internal.hashLong(getPackageId())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveBasePackageAck.class, Builder.class);
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
      return new LiveBasePackageAck();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      long l = this.packageId_;
      if (l != 0L)
        param1CodedOutputStream.writeUInt64(1, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveConnect.LiveBasePackageAckOrBuilder {
      private long packageId_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveConnect.LiveBasePackageAck.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveConnect.LiveBasePackageAck build() {
        LiveConnect.LiveBasePackageAck liveBasePackageAck = buildPartial();
        if (liveBasePackageAck.isInitialized())
          return liveBasePackageAck; 
        throw newUninitializedMessageException(liveBasePackageAck);
      }
      
      public LiveConnect.LiveBasePackageAck buildPartial() {
        LiveConnect.LiveBasePackageAck liveBasePackageAck = new LiveConnect.LiveBasePackageAck(this);
        LiveConnect.LiveBasePackageAck.access$1802(liveBasePackageAck, this.packageId_);
        onBuilt();
        return liveBasePackageAck;
      }
      
      public Builder clear() {
        super.clear();
        this.packageId_ = 0L;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPackageId() {
        this.packageId_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public LiveConnect.LiveBasePackageAck getDefaultInstanceForType() {
        return LiveConnect.LiveBasePackageAck.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
      }
      
      public long getPackageId() {
        return this.packageId_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveBasePackageAck.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveConnect.LiveBasePackageAck param2LiveBasePackageAck) {
        if (param2LiveBasePackageAck == LiveConnect.LiveBasePackageAck.getDefaultInstance())
          return this; 
        if (param2LiveBasePackageAck.getPackageId() != 0L)
          setPackageId(param2LiveBasePackageAck.getPackageId()); 
        mergeUnknownFields(param2LiveBasePackageAck.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveConnect.LiveBasePackageAck liveBasePackageAck = (LiveConnect.LiveBasePackageAck)LiveConnect.LiveBasePackageAck.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveConnect.LiveBasePackageAck liveBasePackageAck = (LiveConnect.LiveBasePackageAck)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveConnect.LiveBasePackageAck)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveConnect.LiveBasePackageAck)
          return mergeFrom((LiveConnect.LiveBasePackageAck)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setPackageId(long param2Long) {
        this.packageId_ = param2Long;
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
  
  static final class null extends AbstractParser<LiveBasePackageAck> {
    public LiveConnect.LiveBasePackageAck parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveConnect.LiveBasePackageAck(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveBasePackageAck.Builder> implements LiveBasePackageAckOrBuilder {
    private long packageId_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveConnect.LiveBasePackageAck.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveConnect.LiveBasePackageAck build() {
      LiveConnect.LiveBasePackageAck liveBasePackageAck = buildPartial();
      if (liveBasePackageAck.isInitialized())
        return liveBasePackageAck; 
      throw newUninitializedMessageException(liveBasePackageAck);
    }
    
    public LiveConnect.LiveBasePackageAck buildPartial() {
      LiveConnect.LiveBasePackageAck liveBasePackageAck = new LiveConnect.LiveBasePackageAck(this);
      LiveConnect.LiveBasePackageAck.access$1802(liveBasePackageAck, this.packageId_);
      onBuilt();
      return liveBasePackageAck;
    }
    
    public Builder clear() {
      super.clear();
      this.packageId_ = 0L;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPackageId() {
      this.packageId_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LiveConnect.LiveBasePackageAck getDefaultInstanceForType() {
      return LiveConnect.LiveBasePackageAck.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_descriptor;
    }
    
    public long getPackageId() {
      return this.packageId_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveBasePackageAck_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveBasePackageAck.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveConnect.LiveBasePackageAck param1LiveBasePackageAck) {
      if (param1LiveBasePackageAck == LiveConnect.LiveBasePackageAck.getDefaultInstance())
        return this; 
      if (param1LiveBasePackageAck.getPackageId() != 0L)
        setPackageId(param1LiveBasePackageAck.getPackageId()); 
      mergeUnknownFields(param1LiveBasePackageAck.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveConnect.LiveBasePackageAck liveBasePackageAck = (LiveConnect.LiveBasePackageAck)LiveConnect.LiveBasePackageAck.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveConnect.LiveBasePackageAck liveBasePackageAck = (LiveConnect.LiveBasePackageAck)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveConnect.LiveBasePackageAck)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveConnect.LiveBasePackageAck)
        return mergeFrom((LiveConnect.LiveBasePackageAck)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setPackageId(long param1Long) {
      this.packageId_ = param1Long;
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
  
  public static interface LiveBasePackageAckOrBuilder extends MessageOrBuilder {
    long getPackageId();
  }
  
  public static interface LiveBasePackageOrBuilder extends MessageOrBuilder {
    Any getBody();
    
    AnyOrBuilder getBodyOrBuilder();
    
    boolean getNeedAck();
    
    long getPackageId();
    
    boolean hasBody();
  }
  
  public static final class LiveSetting extends GeneratedMessageV3 implements LiveSettingOrBuilder {
    public static final int APP_VERSION_FIELD_NUMBER = 1;
    
    public static final int CHANNEL_FIELD_NUMBER = 6;
    
    private static final LiveSetting DEFAULT_INSTANCE = new LiveSetting();
    
    public static final int DEVICE_FIELD_NUMBER = 5;
    
    public static final int LANGUAGE_FIELD_NUMBER = 3;
    
    public static final int OS_VERSION_FIELD_NUMBER = 4;
    
    private static final Parser<LiveSetting> PARSER = (Parser<LiveSetting>)new AbstractParser<LiveSetting>() {
        public LiveConnect.LiveSetting parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveConnect.LiveSetting(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PLATFORM_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object appVersion_;
    
    private volatile Object channel_;
    
    private volatile Object device_;
    
    private volatile Object language_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object osVersion_;
    
    private volatile Object platform_;
    
    private LiveSetting() {
      this.appVersion_ = "";
      this.platform_ = "";
      this.language_ = "";
      this.osVersion_ = "";
      this.device_ = "";
      this.channel_ = "";
    }
    
    private LiveSetting(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (i != 26) {
                    if (i != 34) {
                      if (i != 42) {
                        if (i != 50) {
                          if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                            continue; 
                          continue;
                        } 
                        this.channel_ = param1CodedInputStream.readStringRequireUtf8();
                        continue;
                      } 
                      this.device_ = param1CodedInputStream.readStringRequireUtf8();
                      continue;
                    } 
                    this.osVersion_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.language_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.platform_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.appVersion_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private LiveSetting(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveSetting getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveSetting param1LiveSetting) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveSetting);
    }
    
    public static LiveSetting parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveSetting parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveSetting parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveSetting parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveSetting parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveSetting parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveSetting parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveSetting parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveSetting)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveSetting parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveSetting parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveSetting parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveSetting parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveSetting)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveSetting> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveSetting))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getAppVersion().equals(param1Object.getAppVersion()) ? false : (!getPlatform().equals(param1Object.getPlatform()) ? false : (!getLanguage().equals(param1Object.getLanguage()) ? false : (!getOsVersion().equals(param1Object.getOsVersion()) ? false : (!getDevice().equals(param1Object.getDevice()) ? false : (!getChannel().equals(param1Object.getChannel()) ? false : (!!this.unknownFields.equals(((LiveSetting)param1Object).unknownFields)))))));
    }
    
    public String getAppVersion() {
      Object object = this.appVersion_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.appVersion_ = object;
      return (String)object;
    }
    
    public ByteString getAppVersionBytes() {
      Object object = this.appVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getChannel() {
      Object object = this.channel_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.channel_ = object;
      return (String)object;
    }
    
    public ByteString getChannelBytes() {
      Object object = this.channel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.channel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveSetting getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDevice() {
      Object object = this.device_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.device_ = object;
      return (String)object;
    }
    
    public ByteString getDeviceBytes() {
      Object object = this.device_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.device_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLanguage() {
      Object object = this.language_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.language_ = object;
      return (String)object;
    }
    
    public ByteString getLanguageBytes() {
      Object object = this.language_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.language_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOsVersion() {
      Object object = this.osVersion_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.osVersion_ = object;
      return (String)object;
    }
    
    public ByteString getOsVersionBytes() {
      Object object = this.osVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.osVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<LiveSetting> getParserForType() {
      return PARSER;
    }
    
    public String getPlatform() {
      Object object = this.platform_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.platform_ = object;
      return (String)object;
    }
    
    public ByteString getPlatformBytes() {
      Object object = this.platform_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.platform_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getAppVersionBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.appVersion_); 
      i = j;
      if (!getPlatformBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.platform_); 
      j = i;
      if (!getLanguageBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.language_); 
      i = j;
      if (!getOsVersionBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.osVersion_); 
      j = i;
      if (!getDeviceBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(5, this.device_); 
      i = j;
      if (!getChannelBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(6, this.channel_); 
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
      int i = (((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getAppVersion().hashCode()) * 37 + 2) * 53 + getPlatform().hashCode()) * 37 + 3) * 53 + getLanguage().hashCode()) * 37 + 4) * 53 + getOsVersion().hashCode()) * 37 + 5) * 53 + getDevice().hashCode()) * 37 + 6) * 53 + getChannel().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveSetting.class, Builder.class);
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
      return new LiveSetting();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getAppVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.appVersion_); 
      if (!getPlatformBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.platform_); 
      if (!getLanguageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.language_); 
      if (!getOsVersionBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.osVersion_); 
      if (!getDeviceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.device_); 
      if (!getChannelBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.channel_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveConnect.LiveSettingOrBuilder {
      private Object appVersion_ = "";
      
      private Object channel_ = "";
      
      private Object device_ = "";
      
      private Object language_ = "";
      
      private Object osVersion_ = "";
      
      private Object platform_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveConnect.LiveSetting.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveConnect.LiveSetting build() {
        LiveConnect.LiveSetting liveSetting = buildPartial();
        if (liveSetting.isInitialized())
          return liveSetting; 
        throw newUninitializedMessageException(liveSetting);
      }
      
      public LiveConnect.LiveSetting buildPartial() {
        LiveConnect.LiveSetting liveSetting = new LiveConnect.LiveSetting(this);
        LiveConnect.LiveSetting.access$2802(liveSetting, this.appVersion_);
        LiveConnect.LiveSetting.access$2902(liveSetting, this.platform_);
        LiveConnect.LiveSetting.access$3002(liveSetting, this.language_);
        LiveConnect.LiveSetting.access$3102(liveSetting, this.osVersion_);
        LiveConnect.LiveSetting.access$3202(liveSetting, this.device_);
        LiveConnect.LiveSetting.access$3302(liveSetting, this.channel_);
        onBuilt();
        return liveSetting;
      }
      
      public Builder clear() {
        super.clear();
        this.appVersion_ = "";
        this.platform_ = "";
        this.language_ = "";
        this.osVersion_ = "";
        this.device_ = "";
        this.channel_ = "";
        return this;
      }
      
      public Builder clearAppVersion() {
        this.appVersion_ = LiveConnect.LiveSetting.getDefaultInstance().getAppVersion();
        onChanged();
        return this;
      }
      
      public Builder clearChannel() {
        this.channel_ = LiveConnect.LiveSetting.getDefaultInstance().getChannel();
        onChanged();
        return this;
      }
      
      public Builder clearDevice() {
        this.device_ = LiveConnect.LiveSetting.getDefaultInstance().getDevice();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearLanguage() {
        this.language_ = LiveConnect.LiveSetting.getDefaultInstance().getLanguage();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOsVersion() {
        this.osVersion_ = LiveConnect.LiveSetting.getDefaultInstance().getOsVersion();
        onChanged();
        return this;
      }
      
      public Builder clearPlatform() {
        this.platform_ = LiveConnect.LiveSetting.getDefaultInstance().getPlatform();
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getAppVersion() {
        Object object = this.appVersion_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.appVersion_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAppVersionBytes() {
        Object object = this.appVersion_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.appVersion_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getChannel() {
        Object object = this.channel_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.channel_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getChannelBytes() {
        Object object = this.channel_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.channel_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveConnect.LiveSetting getDefaultInstanceForType() {
        return LiveConnect.LiveSetting.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
      }
      
      public String getDevice() {
        Object object = this.device_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.device_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDeviceBytes() {
        Object object = this.device_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.device_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getLanguage() {
        Object object = this.language_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.language_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLanguageBytes() {
        Object object = this.language_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.language_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getOsVersion() {
        Object object = this.osVersion_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.osVersion_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getOsVersionBytes() {
        Object object = this.osVersion_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.osVersion_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getPlatform() {
        Object object = this.platform_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.platform_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getPlatformBytes() {
        Object object = this.platform_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.platform_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveSetting.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveConnect.LiveSetting param2LiveSetting) {
        if (param2LiveSetting == LiveConnect.LiveSetting.getDefaultInstance())
          return this; 
        if (!param2LiveSetting.getAppVersion().isEmpty()) {
          this.appVersion_ = param2LiveSetting.appVersion_;
          onChanged();
        } 
        if (!param2LiveSetting.getPlatform().isEmpty()) {
          this.platform_ = param2LiveSetting.platform_;
          onChanged();
        } 
        if (!param2LiveSetting.getLanguage().isEmpty()) {
          this.language_ = param2LiveSetting.language_;
          onChanged();
        } 
        if (!param2LiveSetting.getOsVersion().isEmpty()) {
          this.osVersion_ = param2LiveSetting.osVersion_;
          onChanged();
        } 
        if (!param2LiveSetting.getDevice().isEmpty()) {
          this.device_ = param2LiveSetting.device_;
          onChanged();
        } 
        if (!param2LiveSetting.getChannel().isEmpty()) {
          this.channel_ = param2LiveSetting.channel_;
          onChanged();
        } 
        mergeUnknownFields(param2LiveSetting.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveConnect.LiveSetting liveSetting = (LiveConnect.LiveSetting)LiveConnect.LiveSetting.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveConnect.LiveSetting liveSetting = (LiveConnect.LiveSetting)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveConnect.LiveSetting)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveConnect.LiveSetting)
          return mergeFrom((LiveConnect.LiveSetting)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAppVersion(String param2String) {
        if (param2String != null) {
          this.appVersion_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAppVersionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.appVersion_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setChannel(String param2String) {
        if (param2String != null) {
          this.channel_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setChannelBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.channel_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDevice(String param2String) {
        if (param2String != null) {
          this.device_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDeviceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.device_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setLanguage(String param2String) {
        if (param2String != null) {
          this.language_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLanguageBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.language_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOsVersion(String param2String) {
        if (param2String != null) {
          this.osVersion_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOsVersionBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.osVersion_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPlatform(String param2String) {
        if (param2String != null) {
          this.platform_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setPlatformBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveConnect.LiveSetting.checkByteStringIsUtf8(param2ByteString);
          this.platform_ = param2ByteString;
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
  
  static final class null extends AbstractParser<LiveSetting> {
    public LiveConnect.LiveSetting parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveConnect.LiveSetting(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveSetting.Builder> implements LiveSettingOrBuilder {
    private Object appVersion_ = "";
    
    private Object channel_ = "";
    
    private Object device_ = "";
    
    private Object language_ = "";
    
    private Object osVersion_ = "";
    
    private Object platform_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveConnect.LiveSetting.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveConnect.LiveSetting build() {
      LiveConnect.LiveSetting liveSetting = buildPartial();
      if (liveSetting.isInitialized())
        return liveSetting; 
      throw newUninitializedMessageException(liveSetting);
    }
    
    public LiveConnect.LiveSetting buildPartial() {
      LiveConnect.LiveSetting liveSetting = new LiveConnect.LiveSetting(this);
      LiveConnect.LiveSetting.access$2802(liveSetting, this.appVersion_);
      LiveConnect.LiveSetting.access$2902(liveSetting, this.platform_);
      LiveConnect.LiveSetting.access$3002(liveSetting, this.language_);
      LiveConnect.LiveSetting.access$3102(liveSetting, this.osVersion_);
      LiveConnect.LiveSetting.access$3202(liveSetting, this.device_);
      LiveConnect.LiveSetting.access$3302(liveSetting, this.channel_);
      onBuilt();
      return liveSetting;
    }
    
    public Builder clear() {
      super.clear();
      this.appVersion_ = "";
      this.platform_ = "";
      this.language_ = "";
      this.osVersion_ = "";
      this.device_ = "";
      this.channel_ = "";
      return this;
    }
    
    public Builder clearAppVersion() {
      this.appVersion_ = LiveConnect.LiveSetting.getDefaultInstance().getAppVersion();
      onChanged();
      return this;
    }
    
    public Builder clearChannel() {
      this.channel_ = LiveConnect.LiveSetting.getDefaultInstance().getChannel();
      onChanged();
      return this;
    }
    
    public Builder clearDevice() {
      this.device_ = LiveConnect.LiveSetting.getDefaultInstance().getDevice();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLanguage() {
      this.language_ = LiveConnect.LiveSetting.getDefaultInstance().getLanguage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOsVersion() {
      this.osVersion_ = LiveConnect.LiveSetting.getDefaultInstance().getOsVersion();
      onChanged();
      return this;
    }
    
    public Builder clearPlatform() {
      this.platform_ = LiveConnect.LiveSetting.getDefaultInstance().getPlatform();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAppVersion() {
      Object object = this.appVersion_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.appVersion_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAppVersionBytes() {
      Object object = this.appVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.appVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getChannel() {
      Object object = this.channel_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.channel_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getChannelBytes() {
      Object object = this.channel_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.channel_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveConnect.LiveSetting getDefaultInstanceForType() {
      return LiveConnect.LiveSetting.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_descriptor;
    }
    
    public String getDevice() {
      Object object = this.device_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.device_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDeviceBytes() {
      Object object = this.device_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.device_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLanguage() {
      Object object = this.language_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.language_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLanguageBytes() {
      Object object = this.language_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.language_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getOsVersion() {
      Object object = this.osVersion_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.osVersion_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getOsVersionBytes() {
      Object object = this.osVersion_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.osVersion_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getPlatform() {
      Object object = this.platform_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.platform_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getPlatformBytes() {
      Object object = this.platform_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.platform_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveConnect.internal_static_cn_irisgw_live_LiveSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveConnect.LiveSetting.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveConnect.LiveSetting param1LiveSetting) {
      if (param1LiveSetting == LiveConnect.LiveSetting.getDefaultInstance())
        return this; 
      if (!param1LiveSetting.getAppVersion().isEmpty()) {
        this.appVersion_ = param1LiveSetting.appVersion_;
        onChanged();
      } 
      if (!param1LiveSetting.getPlatform().isEmpty()) {
        this.platform_ = param1LiveSetting.platform_;
        onChanged();
      } 
      if (!param1LiveSetting.getLanguage().isEmpty()) {
        this.language_ = param1LiveSetting.language_;
        onChanged();
      } 
      if (!param1LiveSetting.getOsVersion().isEmpty()) {
        this.osVersion_ = param1LiveSetting.osVersion_;
        onChanged();
      } 
      if (!param1LiveSetting.getDevice().isEmpty()) {
        this.device_ = param1LiveSetting.device_;
        onChanged();
      } 
      if (!param1LiveSetting.getChannel().isEmpty()) {
        this.channel_ = param1LiveSetting.channel_;
        onChanged();
      } 
      mergeUnknownFields(param1LiveSetting.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveConnect.LiveSetting liveSetting = (LiveConnect.LiveSetting)LiveConnect.LiveSetting.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveConnect.LiveSetting liveSetting = (LiveConnect.LiveSetting)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveConnect.LiveSetting)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveConnect.LiveSetting)
        return mergeFrom((LiveConnect.LiveSetting)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAppVersion(String param1String) {
      if (param1String != null) {
        this.appVersion_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAppVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.appVersion_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setChannel(String param1String) {
      if (param1String != null) {
        this.channel_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setChannelBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.channel_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDevice(String param1String) {
      if (param1String != null) {
        this.device_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDeviceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.device_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLanguage(String param1String) {
      if (param1String != null) {
        this.language_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLanguageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.language_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOsVersion(String param1String) {
      if (param1String != null) {
        this.osVersion_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOsVersionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.osVersion_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPlatform(String param1String) {
      if (param1String != null) {
        this.platform_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setPlatformBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveConnect.LiveSetting.checkByteStringIsUtf8(param1ByteString);
        this.platform_ = param1ByteString;
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
  
  public static interface LiveSettingOrBuilder extends MessageOrBuilder {
    String getAppVersion();
    
    ByteString getAppVersionBytes();
    
    String getChannel();
    
    ByteString getChannelBytes();
    
    String getDevice();
    
    ByteString getDeviceBytes();
    
    String getLanguage();
    
    ByteString getLanguageBytes();
    
    String getOsVersion();
    
    ByteString getOsVersionBytes();
    
    String getPlatform();
    
    ByteString getPlatformBytes();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\irisgw\live\LiveConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */