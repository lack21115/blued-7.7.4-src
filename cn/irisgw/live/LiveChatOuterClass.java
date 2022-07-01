package cn.irisgw.live;

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

public final class LiveChatOuterClass {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\016liveChat.proto\022\016cn.irisgw.live\"3\n\016LiveMsgRequest\022\017\n\007live_id\030\001 \001(\t\022\020\n\bcontents\030\002 \001(\t\"s\n\017LiveMsgResponse\022,\n\004code\030\001 \001(\0162\036.cn.irisgw.live.SendStatusCode\022\016\n\006msg_id\030\002 \001(\004\022\021\n\ttimestamp\030\003 \001(\004\022\017\n\007message\030\004 \001(\t\"I\n\017LiveLikeRequest\022\017\n\007live_id\030\001 \001(\t\022\r\n\005count\030\002 \001(\r\022\026\n\016has_first_like\030\003 \001(\b\"@\n\020LiveLikeResponse\022,\n\004code\030\001 \001(\0162\036.cn.irisgw.live.SendStatusCode*.\n\016SendStatusCode\022\016\n\nSEND_EMPTY\020\000\022\f\n\007SEND_OK\020È\0012©\001\n\bLiveChat\022L\n\007SendMsg\022\036.cn.irisgw.live.LiveMsgRequest\032\037.cn.irisgw.live.LiveMsgResponse\"\000\022O\n\bSendLike\022\037.cn.irisgw.live.LiveLikeRequest\032 .cn.irisgw.live.LiveLikeResponse\"\000b\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveMsgRequest_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveMsgRequest_descriptor, new String[] { "LiveId", "Contents" });
  
  private static final Descriptors.Descriptor internal_static_cn_irisgw_live_LiveMsgResponse_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveMsgResponse_descriptor, new String[] { "Code", "MsgId", "Timestamp", "Message" });
  
  static {
    internal_static_cn_irisgw_live_LiveLikeRequest_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveLikeRequest_descriptor, new String[] { "LiveId", "Count", "HasFirstLike" });
    internal_static_cn_irisgw_live_LiveLikeResponse_descriptor = getDescriptor().getMessageTypes().get(3);
    internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_cn_irisgw_live_LiveLikeResponse_descriptor, new String[] { "Code" });
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class LiveLikeRequest extends GeneratedMessageV3 implements LiveLikeRequestOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    
    private static final LiveLikeRequest DEFAULT_INSTANCE = new LiveLikeRequest();
    
    public static final int HAS_FIRST_LIKE_FIELD_NUMBER = 3;
    
    public static final int LIVE_ID_FIELD_NUMBER = 1;
    
    private static final Parser<LiveLikeRequest> PARSER = (Parser<LiveLikeRequest>)new AbstractParser<LiveLikeRequest>() {
        public LiveChatOuterClass.LiveLikeRequest parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveChatOuterClass.LiveLikeRequest(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int count_;
    
    private boolean hasFirstLike_;
    
    private volatile Object liveId_;
    
    private byte memoizedIsInitialized = -1;
    
    private LiveLikeRequest() {
      this.liveId_ = "";
    }
    
    private LiveLikeRequest(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 16) {
                  if (i != 24) {
                    if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.hasFirstLike_ = param1CodedInputStream.readBool();
                  continue;
                } 
                this.count_ = param1CodedInputStream.readUInt32();
                continue;
              } 
              this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private LiveLikeRequest(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveLikeRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveLikeRequest param1LiveLikeRequest) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveLikeRequest);
    }
    
    public static LiveLikeRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveLikeRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveLikeRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveLikeRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveLikeRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeRequest parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveLikeRequest parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveLikeRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeRequest)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveLikeRequest> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveLikeRequest))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getLiveId().equals(param1Object.getLiveId()) ? false : ((getCount() != param1Object.getCount()) ? false : ((getHasFirstLike() != param1Object.getHasFirstLike()) ? false : (!!this.unknownFields.equals(((LiveLikeRequest)param1Object).unknownFields))));
    }
    
    public int getCount() {
      return this.count_;
    }
    
    public LiveLikeRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public boolean getHasFirstLike() {
      return this.hasFirstLike_;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveId_ = object;
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<LiveLikeRequest> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (!getLiveIdBytes().isEmpty())
        j = 0 + GeneratedMessageV3.computeStringSize(1, this.liveId_); 
      int k = this.count_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(2, k); 
      boolean bool = this.hasFirstLike_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(3, bool); 
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
      int i = (((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getLiveId().hashCode()) * 37 + 2) * 53 + getCount()) * 37 + 3) * 53 + Internal.hashBoolean(getHasFirstLike())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeRequest.class, Builder.class);
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
      return new LiveLikeRequest();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.liveId_); 
      int i = this.count_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(2, i); 
      boolean bool = this.hasFirstLike_;
      if (bool)
        param1CodedOutputStream.writeBool(3, bool); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveChatOuterClass.LiveLikeRequestOrBuilder {
      private int count_;
      
      private boolean hasFirstLike_;
      
      private Object liveId_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveChatOuterClass.LiveLikeRequest.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveChatOuterClass.LiveLikeRequest build() {
        LiveChatOuterClass.LiveLikeRequest liveLikeRequest = buildPartial();
        if (liveLikeRequest.isInitialized())
          return liveLikeRequest; 
        throw newUninitializedMessageException(liveLikeRequest);
      }
      
      public LiveChatOuterClass.LiveLikeRequest buildPartial() {
        LiveChatOuterClass.LiveLikeRequest liveLikeRequest = new LiveChatOuterClass.LiveLikeRequest(this);
        LiveChatOuterClass.LiveLikeRequest.access$3302(liveLikeRequest, this.liveId_);
        LiveChatOuterClass.LiveLikeRequest.access$3402(liveLikeRequest, this.count_);
        LiveChatOuterClass.LiveLikeRequest.access$3502(liveLikeRequest, this.hasFirstLike_);
        onBuilt();
        return liveLikeRequest;
      }
      
      public Builder clear() {
        super.clear();
        this.liveId_ = "";
        this.count_ = 0;
        this.hasFirstLike_ = false;
        return this;
      }
      
      public Builder clearCount() {
        this.count_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearHasFirstLike() {
        this.hasFirstLike_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearLiveId() {
        this.liveId_ = LiveChatOuterClass.LiveLikeRequest.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public int getCount() {
        return this.count_;
      }
      
      public LiveChatOuterClass.LiveLikeRequest getDefaultInstanceForType() {
        return LiveChatOuterClass.LiveLikeRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
      }
      
      public boolean getHasFirstLike() {
        return this.hasFirstLike_;
      }
      
      public String getLiveId() {
        Object object = this.liveId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveIdBytes() {
        Object object = this.liveId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveLikeRequest.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveChatOuterClass.LiveLikeRequest param2LiveLikeRequest) {
        if (param2LiveLikeRequest == LiveChatOuterClass.LiveLikeRequest.getDefaultInstance())
          return this; 
        if (!param2LiveLikeRequest.getLiveId().isEmpty()) {
          this.liveId_ = param2LiveLikeRequest.liveId_;
          onChanged();
        } 
        if (param2LiveLikeRequest.getCount() != 0)
          setCount(param2LiveLikeRequest.getCount()); 
        if (param2LiveLikeRequest.getHasFirstLike())
          setHasFirstLike(param2LiveLikeRequest.getHasFirstLike()); 
        mergeUnknownFields(param2LiveLikeRequest.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveChatOuterClass.LiveLikeRequest liveLikeRequest = (LiveChatOuterClass.LiveLikeRequest)LiveChatOuterClass.LiveLikeRequest.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveChatOuterClass.LiveLikeRequest liveLikeRequest = (LiveChatOuterClass.LiveLikeRequest)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveChatOuterClass.LiveLikeRequest)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveChatOuterClass.LiveLikeRequest)
          return mergeFrom((LiveChatOuterClass.LiveLikeRequest)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCount(int param2Int) {
        this.count_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setHasFirstLike(boolean param2Boolean) {
        this.hasFirstLike_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setLiveId(String param2String) {
        if (param2String != null) {
          this.liveId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveChatOuterClass.LiveLikeRequest.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
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
  
  static final class null extends AbstractParser<LiveLikeRequest> {
    public LiveChatOuterClass.LiveLikeRequest parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveChatOuterClass.LiveLikeRequest(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveLikeRequest.Builder> implements LiveLikeRequestOrBuilder {
    private int count_;
    
    private boolean hasFirstLike_;
    
    private Object liveId_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveChatOuterClass.LiveLikeRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveChatOuterClass.LiveLikeRequest build() {
      LiveChatOuterClass.LiveLikeRequest liveLikeRequest = buildPartial();
      if (liveLikeRequest.isInitialized())
        return liveLikeRequest; 
      throw newUninitializedMessageException(liveLikeRequest);
    }
    
    public LiveChatOuterClass.LiveLikeRequest buildPartial() {
      LiveChatOuterClass.LiveLikeRequest liveLikeRequest = new LiveChatOuterClass.LiveLikeRequest(this);
      LiveChatOuterClass.LiveLikeRequest.access$3302(liveLikeRequest, this.liveId_);
      LiveChatOuterClass.LiveLikeRequest.access$3402(liveLikeRequest, this.count_);
      LiveChatOuterClass.LiveLikeRequest.access$3502(liveLikeRequest, this.hasFirstLike_);
      onBuilt();
      return liveLikeRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.liveId_ = "";
      this.count_ = 0;
      this.hasFirstLike_ = false;
      return this;
    }
    
    public Builder clearCount() {
      this.count_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearHasFirstLike() {
      this.hasFirstLike_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearLiveId() {
      this.liveId_ = LiveChatOuterClass.LiveLikeRequest.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public int getCount() {
      return this.count_;
    }
    
    public LiveChatOuterClass.LiveLikeRequest getDefaultInstanceForType() {
      return LiveChatOuterClass.LiveLikeRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_descriptor;
    }
    
    public boolean getHasFirstLike() {
      return this.hasFirstLike_;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveLikeRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveChatOuterClass.LiveLikeRequest param1LiveLikeRequest) {
      if (param1LiveLikeRequest == LiveChatOuterClass.LiveLikeRequest.getDefaultInstance())
        return this; 
      if (!param1LiveLikeRequest.getLiveId().isEmpty()) {
        this.liveId_ = param1LiveLikeRequest.liveId_;
        onChanged();
      } 
      if (param1LiveLikeRequest.getCount() != 0)
        setCount(param1LiveLikeRequest.getCount()); 
      if (param1LiveLikeRequest.getHasFirstLike())
        setHasFirstLike(param1LiveLikeRequest.getHasFirstLike()); 
      mergeUnknownFields(param1LiveLikeRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveChatOuterClass.LiveLikeRequest liveLikeRequest = (LiveChatOuterClass.LiveLikeRequest)LiveChatOuterClass.LiveLikeRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveChatOuterClass.LiveLikeRequest liveLikeRequest = (LiveChatOuterClass.LiveLikeRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveChatOuterClass.LiveLikeRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveChatOuterClass.LiveLikeRequest)
        return mergeFrom((LiveChatOuterClass.LiveLikeRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCount(int param1Int) {
      this.count_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setHasFirstLike(boolean param1Boolean) {
      this.hasFirstLike_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setLiveId(String param1String) {
      if (param1String != null) {
        this.liveId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveChatOuterClass.LiveLikeRequest.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
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
  
  public static interface LiveLikeRequestOrBuilder extends MessageOrBuilder {
    int getCount();
    
    boolean getHasFirstLike();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
  }
  
  public static final class LiveLikeResponse extends GeneratedMessageV3 implements LiveLikeResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final LiveLikeResponse DEFAULT_INSTANCE = new LiveLikeResponse();
    
    private static final Parser<LiveLikeResponse> PARSER = (Parser<LiveLikeResponse>)new AbstractParser<LiveLikeResponse>() {
        public LiveChatOuterClass.LiveLikeResponse parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveChatOuterClass.LiveLikeResponse(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private byte memoizedIsInitialized = -1;
    
    private LiveLikeResponse() {
      this.code_ = 0;
    }
    
    private LiveLikeResponse(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
              this.code_ = param1CodedInputStream.readEnum();
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
    
    private LiveLikeResponse(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveLikeResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveLikeResponse param1LiveLikeResponse) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveLikeResponse);
    }
    
    public static LiveLikeResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveLikeResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveLikeResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveLikeResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveLikeResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveLikeResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeResponse parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveLikeResponse parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveLikeResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveLikeResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveLikeResponse)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveLikeResponse> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveLikeResponse))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.code_ != ((LiveLikeResponse)param1Object).code_) ? false : (!!this.unknownFields.equals(((LiveLikeResponse)param1Object).unknownFields));
    }
    
    public LiveChatOuterClass.SendStatusCode getCode() {
      LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
      LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
      if (sendStatusCode2 == null)
        sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
      return sendStatusCode1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public LiveLikeResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public Parser<LiveLikeResponse> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.code_ != LiveChatOuterClass.SendStatusCode.SEND_EMPTY.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.code_); 
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
      int i = (((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.code_) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveLikeResponse.class, Builder.class);
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
      return new LiveLikeResponse();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.code_ != LiveChatOuterClass.SendStatusCode.SEND_EMPTY.getNumber())
        param1CodedOutputStream.writeEnum(1, this.code_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveChatOuterClass.LiveLikeResponseOrBuilder {
      private int code_ = 0;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveChatOuterClass.LiveLikeResponse.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveChatOuterClass.LiveLikeResponse build() {
        LiveChatOuterClass.LiveLikeResponse liveLikeResponse = buildPartial();
        if (liveLikeResponse.isInitialized())
          return liveLikeResponse; 
        throw newUninitializedMessageException(liveLikeResponse);
      }
      
      public LiveChatOuterClass.LiveLikeResponse buildPartial() {
        LiveChatOuterClass.LiveLikeResponse liveLikeResponse = new LiveChatOuterClass.LiveLikeResponse(this);
        LiveChatOuterClass.LiveLikeResponse.access$4602(liveLikeResponse, this.code_);
        onBuilt();
        return liveLikeResponse;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        return this;
      }
      
      public Builder clearCode() {
        this.code_ = 0;
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
      
      public LiveChatOuterClass.SendStatusCode getCode() {
        LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
        LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
        if (sendStatusCode2 == null)
          sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
        return sendStatusCode1;
      }
      
      public int getCodeValue() {
        return this.code_;
      }
      
      public LiveChatOuterClass.LiveLikeResponse getDefaultInstanceForType() {
        return LiveChatOuterClass.LiveLikeResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveLikeResponse.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveChatOuterClass.LiveLikeResponse param2LiveLikeResponse) {
        if (param2LiveLikeResponse == LiveChatOuterClass.LiveLikeResponse.getDefaultInstance())
          return this; 
        if (param2LiveLikeResponse.code_ != 0)
          setCodeValue(param2LiveLikeResponse.getCodeValue()); 
        mergeUnknownFields(param2LiveLikeResponse.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveChatOuterClass.LiveLikeResponse liveLikeResponse = (LiveChatOuterClass.LiveLikeResponse)LiveChatOuterClass.LiveLikeResponse.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveChatOuterClass.LiveLikeResponse liveLikeResponse = (LiveChatOuterClass.LiveLikeResponse)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveChatOuterClass.LiveLikeResponse)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveChatOuterClass.LiveLikeResponse)
          return mergeFrom((LiveChatOuterClass.LiveLikeResponse)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(LiveChatOuterClass.SendStatusCode param2SendStatusCode) {
        if (param2SendStatusCode != null) {
          this.code_ = param2SendStatusCode.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCodeValue(int param2Int) {
        this.code_ = param2Int;
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
  }
  
  static final class null extends AbstractParser<LiveLikeResponse> {
    public LiveChatOuterClass.LiveLikeResponse parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveChatOuterClass.LiveLikeResponse(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveLikeResponse.Builder> implements LiveLikeResponseOrBuilder {
    private int code_ = 0;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveChatOuterClass.LiveLikeResponse.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveChatOuterClass.LiveLikeResponse build() {
      LiveChatOuterClass.LiveLikeResponse liveLikeResponse = buildPartial();
      if (liveLikeResponse.isInitialized())
        return liveLikeResponse; 
      throw newUninitializedMessageException(liveLikeResponse);
    }
    
    public LiveChatOuterClass.LiveLikeResponse buildPartial() {
      LiveChatOuterClass.LiveLikeResponse liveLikeResponse = new LiveChatOuterClass.LiveLikeResponse(this);
      LiveChatOuterClass.LiveLikeResponse.access$4602(liveLikeResponse, this.code_);
      onBuilt();
      return liveLikeResponse;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0;
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
    
    public LiveChatOuterClass.SendStatusCode getCode() {
      LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
      LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
      if (sendStatusCode2 == null)
        sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
      return sendStatusCode1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public LiveChatOuterClass.LiveLikeResponse getDefaultInstanceForType() {
      return LiveChatOuterClass.LiveLikeResponse.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_descriptor;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveLikeResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveLikeResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveChatOuterClass.LiveLikeResponse param1LiveLikeResponse) {
      if (param1LiveLikeResponse == LiveChatOuterClass.LiveLikeResponse.getDefaultInstance())
        return this; 
      if (param1LiveLikeResponse.code_ != 0)
        setCodeValue(param1LiveLikeResponse.getCodeValue()); 
      mergeUnknownFields(param1LiveLikeResponse.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveChatOuterClass.LiveLikeResponse liveLikeResponse = (LiveChatOuterClass.LiveLikeResponse)LiveChatOuterClass.LiveLikeResponse.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveChatOuterClass.LiveLikeResponse liveLikeResponse = (LiveChatOuterClass.LiveLikeResponse)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveChatOuterClass.LiveLikeResponse)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveChatOuterClass.LiveLikeResponse)
        return mergeFrom((LiveChatOuterClass.LiveLikeResponse)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(LiveChatOuterClass.SendStatusCode param1SendStatusCode) {
      if (param1SendStatusCode != null) {
        this.code_ = param1SendStatusCode.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCodeValue(int param1Int) {
      this.code_ = param1Int;
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
  
  public static interface LiveLikeResponseOrBuilder extends MessageOrBuilder {
    LiveChatOuterClass.SendStatusCode getCode();
    
    int getCodeValue();
  }
  
  public static final class LiveMsgRequest extends GeneratedMessageV3 implements LiveMsgRequestOrBuilder {
    public static final int CONTENTS_FIELD_NUMBER = 2;
    
    private static final LiveMsgRequest DEFAULT_INSTANCE = new LiveMsgRequest();
    
    public static final int LIVE_ID_FIELD_NUMBER = 1;
    
    private static final Parser<LiveMsgRequest> PARSER = (Parser<LiveMsgRequest>)new AbstractParser<LiveMsgRequest>() {
        public LiveChatOuterClass.LiveMsgRequest parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveChatOuterClass.LiveMsgRequest(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object contents_;
    
    private volatile Object liveId_;
    
    private byte memoizedIsInitialized = -1;
    
    private LiveMsgRequest() {
      this.liveId_ = "";
      this.contents_ = "";
    }
    
    private LiveMsgRequest(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 18) {
                  if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                    continue; 
                  continue;
                } 
                this.contents_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.liveId_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private LiveMsgRequest(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveMsgRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveMsgRequest param1LiveMsgRequest) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveMsgRequest);
    }
    
    public static LiveMsgRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveMsgRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveMsgRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveMsgRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveMsgRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgRequest parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveMsgRequest parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveMsgRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgRequest)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveMsgRequest> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveMsgRequest))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getLiveId().equals(param1Object.getLiveId()) ? false : (!getContents().equals(param1Object.getContents()) ? false : (!!this.unknownFields.equals(((LiveMsgRequest)param1Object).unknownFields)));
    }
    
    public String getContents() {
      Object object = this.contents_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.contents_ = object;
      return (String)object;
    }
    
    public ByteString getContentsBytes() {
      Object object = this.contents_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.contents_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveMsgRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.liveId_ = object;
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Parser<LiveMsgRequest> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getLiveIdBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.liveId_); 
      int j = i;
      if (!getContentsBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.contents_); 
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
      int i = (((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getLiveId().hashCode()) * 37 + 2) * 53 + getContents().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgRequest.class, Builder.class);
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
      return new LiveMsgRequest();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (!getLiveIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.liveId_); 
      if (!getContentsBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.contents_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveChatOuterClass.LiveMsgRequestOrBuilder {
      private Object contents_ = "";
      
      private Object liveId_ = "";
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveChatOuterClass.LiveMsgRequest.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveChatOuterClass.LiveMsgRequest build() {
        LiveChatOuterClass.LiveMsgRequest liveMsgRequest = buildPartial();
        if (liveMsgRequest.isInitialized())
          return liveMsgRequest; 
        throw newUninitializedMessageException(liveMsgRequest);
      }
      
      public LiveChatOuterClass.LiveMsgRequest buildPartial() {
        LiveChatOuterClass.LiveMsgRequest liveMsgRequest = new LiveChatOuterClass.LiveMsgRequest(this);
        LiveChatOuterClass.LiveMsgRequest.access$602(liveMsgRequest, this.liveId_);
        LiveChatOuterClass.LiveMsgRequest.access$702(liveMsgRequest, this.contents_);
        onBuilt();
        return liveMsgRequest;
      }
      
      public Builder clear() {
        super.clear();
        this.liveId_ = "";
        this.contents_ = "";
        return this;
      }
      
      public Builder clearContents() {
        this.contents_ = LiveChatOuterClass.LiveMsgRequest.getDefaultInstance().getContents();
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearLiveId() {
        this.liveId_ = LiveChatOuterClass.LiveMsgRequest.getDefaultInstance().getLiveId();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getContents() {
        Object object = this.contents_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.contents_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getContentsBytes() {
        Object object = this.contents_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.contents_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public LiveChatOuterClass.LiveMsgRequest getDefaultInstanceForType() {
        return LiveChatOuterClass.LiveMsgRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
      }
      
      public String getLiveId() {
        Object object = this.liveId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.liveId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getLiveIdBytes() {
        Object object = this.liveId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.liveId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveMsgRequest.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveChatOuterClass.LiveMsgRequest param2LiveMsgRequest) {
        if (param2LiveMsgRequest == LiveChatOuterClass.LiveMsgRequest.getDefaultInstance())
          return this; 
        if (!param2LiveMsgRequest.getLiveId().isEmpty()) {
          this.liveId_ = param2LiveMsgRequest.liveId_;
          onChanged();
        } 
        if (!param2LiveMsgRequest.getContents().isEmpty()) {
          this.contents_ = param2LiveMsgRequest.contents_;
          onChanged();
        } 
        mergeUnknownFields(param2LiveMsgRequest.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveChatOuterClass.LiveMsgRequest liveMsgRequest = (LiveChatOuterClass.LiveMsgRequest)LiveChatOuterClass.LiveMsgRequest.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveChatOuterClass.LiveMsgRequest liveMsgRequest = (LiveChatOuterClass.LiveMsgRequest)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveChatOuterClass.LiveMsgRequest)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveChatOuterClass.LiveMsgRequest)
          return mergeFrom((LiveChatOuterClass.LiveMsgRequest)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setContents(String param2String) {
        if (param2String != null) {
          this.contents_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setContentsBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveChatOuterClass.LiveMsgRequest.checkByteStringIsUtf8(param2ByteString);
          this.contents_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setLiveId(String param2String) {
        if (param2String != null) {
          this.liveId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setLiveIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveChatOuterClass.LiveMsgRequest.checkByteStringIsUtf8(param2ByteString);
          this.liveId_ = param2ByteString;
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
  
  static final class null extends AbstractParser<LiveMsgRequest> {
    public LiveChatOuterClass.LiveMsgRequest parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveChatOuterClass.LiveMsgRequest(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveMsgRequest.Builder> implements LiveMsgRequestOrBuilder {
    private Object contents_ = "";
    
    private Object liveId_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveChatOuterClass.LiveMsgRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveChatOuterClass.LiveMsgRequest build() {
      LiveChatOuterClass.LiveMsgRequest liveMsgRequest = buildPartial();
      if (liveMsgRequest.isInitialized())
        return liveMsgRequest; 
      throw newUninitializedMessageException(liveMsgRequest);
    }
    
    public LiveChatOuterClass.LiveMsgRequest buildPartial() {
      LiveChatOuterClass.LiveMsgRequest liveMsgRequest = new LiveChatOuterClass.LiveMsgRequest(this);
      LiveChatOuterClass.LiveMsgRequest.access$602(liveMsgRequest, this.liveId_);
      LiveChatOuterClass.LiveMsgRequest.access$702(liveMsgRequest, this.contents_);
      onBuilt();
      return liveMsgRequest;
    }
    
    public Builder clear() {
      super.clear();
      this.liveId_ = "";
      this.contents_ = "";
      return this;
    }
    
    public Builder clearContents() {
      this.contents_ = LiveChatOuterClass.LiveMsgRequest.getDefaultInstance().getContents();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLiveId() {
      this.liveId_ = LiveChatOuterClass.LiveMsgRequest.getDefaultInstance().getLiveId();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getContents() {
      Object object = this.contents_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.contents_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getContentsBytes() {
      Object object = this.contents_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.contents_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public LiveChatOuterClass.LiveMsgRequest getDefaultInstanceForType() {
      return LiveChatOuterClass.LiveMsgRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_descriptor;
    }
    
    public String getLiveId() {
      Object object = this.liveId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.liveId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLiveIdBytes() {
      Object object = this.liveId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.liveId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveMsgRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveChatOuterClass.LiveMsgRequest param1LiveMsgRequest) {
      if (param1LiveMsgRequest == LiveChatOuterClass.LiveMsgRequest.getDefaultInstance())
        return this; 
      if (!param1LiveMsgRequest.getLiveId().isEmpty()) {
        this.liveId_ = param1LiveMsgRequest.liveId_;
        onChanged();
      } 
      if (!param1LiveMsgRequest.getContents().isEmpty()) {
        this.contents_ = param1LiveMsgRequest.contents_;
        onChanged();
      } 
      mergeUnknownFields(param1LiveMsgRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveChatOuterClass.LiveMsgRequest liveMsgRequest = (LiveChatOuterClass.LiveMsgRequest)LiveChatOuterClass.LiveMsgRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveChatOuterClass.LiveMsgRequest liveMsgRequest = (LiveChatOuterClass.LiveMsgRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveChatOuterClass.LiveMsgRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveChatOuterClass.LiveMsgRequest)
        return mergeFrom((LiveChatOuterClass.LiveMsgRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setContents(String param1String) {
      if (param1String != null) {
        this.contents_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setContentsBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveChatOuterClass.LiveMsgRequest.checkByteStringIsUtf8(param1ByteString);
        this.contents_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLiveId(String param1String) {
      if (param1String != null) {
        this.liveId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLiveIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveChatOuterClass.LiveMsgRequest.checkByteStringIsUtf8(param1ByteString);
        this.liveId_ = param1ByteString;
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
  
  public static interface LiveMsgRequestOrBuilder extends MessageOrBuilder {
    String getContents();
    
    ByteString getContentsBytes();
    
    String getLiveId();
    
    ByteString getLiveIdBytes();
  }
  
  public static final class LiveMsgResponse extends GeneratedMessageV3 implements LiveMsgResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final LiveMsgResponse DEFAULT_INSTANCE = new LiveMsgResponse();
    
    public static final int MESSAGE_FIELD_NUMBER = 4;
    
    public static final int MSG_ID_FIELD_NUMBER = 2;
    
    private static final Parser<LiveMsgResponse> PARSER = (Parser<LiveMsgResponse>)new AbstractParser<LiveMsgResponse>() {
        public LiveChatOuterClass.LiveMsgResponse parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new LiveChatOuterClass.LiveMsgResponse(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object message_;
    
    private long msgId_;
    
    private long timestamp_;
    
    private LiveMsgResponse() {
      this.code_ = 0;
      this.message_ = "";
    }
    
    private LiveMsgResponse(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 8) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 34) {
                      if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                        continue; 
                      continue;
                    } 
                    this.message_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.timestamp_ = param1CodedInputStream.readUInt64();
                  continue;
                } 
                this.msgId_ = param1CodedInputStream.readUInt64();
                continue;
              } 
              this.code_ = param1CodedInputStream.readEnum();
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
    
    private LiveMsgResponse(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static LiveMsgResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(LiveMsgResponse param1LiveMsgResponse) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1LiveMsgResponse);
    }
    
    public static LiveMsgResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveMsgResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ByteString);
    }
    
    public static LiveMsgResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static LiveMsgResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static LiveMsgResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (LiveMsgResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgResponse parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static LiveMsgResponse parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static LiveMsgResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static LiveMsgResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (LiveMsgResponse)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<LiveMsgResponse> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof LiveMsgResponse))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.code_ != ((LiveMsgResponse)param1Object).code_) ? false : ((getMsgId() != param1Object.getMsgId()) ? false : ((getTimestamp() != param1Object.getTimestamp()) ? false : (!getMessage().equals(param1Object.getMessage()) ? false : (!!this.unknownFields.equals(((LiveMsgResponse)param1Object).unknownFields)))));
    }
    
    public LiveChatOuterClass.SendStatusCode getCode() {
      LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
      LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
      if (sendStatusCode2 == null)
        sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
      return sendStatusCode1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public LiveMsgResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getMessage() {
      Object object = this.message_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.message_ = object;
      return (String)object;
    }
    
    public ByteString getMessageBytes() {
      Object object = this.message_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.message_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getMsgId() {
      return this.msgId_;
    }
    
    public Parser<LiveMsgResponse> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.code_ != LiveChatOuterClass.SendStatusCode.SEND_EMPTY.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.code_); 
      long l = this.msgId_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeUInt64Size(2, l); 
      l = this.timestamp_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeUInt64Size(3, l); 
      i = j;
      if (!getMessageBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.message_); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public long getTimestamp() {
      return this.timestamp_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.code_) * 37 + 2) * 53 + Internal.hashLong(getMsgId())) * 37 + 3) * 53 + Internal.hashLong(getTimestamp())) * 37 + 4) * 53 + getMessage().hashCode()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveMsgResponse.class, Builder.class);
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
      return new LiveMsgResponse();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.code_ != LiveChatOuterClass.SendStatusCode.SEND_EMPTY.getNumber())
        param1CodedOutputStream.writeEnum(1, this.code_); 
      long l = this.msgId_;
      if (l != 0L)
        param1CodedOutputStream.writeUInt64(2, l); 
      l = this.timestamp_;
      if (l != 0L)
        param1CodedOutputStream.writeUInt64(3, l); 
      if (!getMessageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.message_); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveChatOuterClass.LiveMsgResponseOrBuilder {
      private int code_ = 0;
      
      private Object message_ = "";
      
      private long msgId_;
      
      private long timestamp_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        LiveChatOuterClass.LiveMsgResponse.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public LiveChatOuterClass.LiveMsgResponse build() {
        LiveChatOuterClass.LiveMsgResponse liveMsgResponse = buildPartial();
        if (liveMsgResponse.isInitialized())
          return liveMsgResponse; 
        throw newUninitializedMessageException(liveMsgResponse);
      }
      
      public LiveChatOuterClass.LiveMsgResponse buildPartial() {
        LiveChatOuterClass.LiveMsgResponse liveMsgResponse = new LiveChatOuterClass.LiveMsgResponse(this);
        LiveChatOuterClass.LiveMsgResponse.access$1902(liveMsgResponse, this.code_);
        LiveChatOuterClass.LiveMsgResponse.access$2002(liveMsgResponse, this.msgId_);
        LiveChatOuterClass.LiveMsgResponse.access$2102(liveMsgResponse, this.timestamp_);
        LiveChatOuterClass.LiveMsgResponse.access$2202(liveMsgResponse, this.message_);
        onBuilt();
        return liveMsgResponse;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        this.msgId_ = 0L;
        this.timestamp_ = 0L;
        this.message_ = "";
        return this;
      }
      
      public Builder clearCode() {
        this.code_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearMessage() {
        this.message_ = LiveChatOuterClass.LiveMsgResponse.getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      
      public Builder clearMsgId() {
        this.msgId_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearTimestamp() {
        this.timestamp_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public LiveChatOuterClass.SendStatusCode getCode() {
        LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
        LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
        if (sendStatusCode2 == null)
          sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
        return sendStatusCode1;
      }
      
      public int getCodeValue() {
        return this.code_;
      }
      
      public LiveChatOuterClass.LiveMsgResponse getDefaultInstanceForType() {
        return LiveChatOuterClass.LiveMsgResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
      }
      
      public String getMessage() {
        Object object = this.message_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.message_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getMessageBytes() {
        Object object = this.message_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.message_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public long getMsgId() {
        return this.msgId_;
      }
      
      public long getTimestamp() {
        return this.timestamp_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveMsgResponse.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(LiveChatOuterClass.LiveMsgResponse param2LiveMsgResponse) {
        if (param2LiveMsgResponse == LiveChatOuterClass.LiveMsgResponse.getDefaultInstance())
          return this; 
        if (param2LiveMsgResponse.code_ != 0)
          setCodeValue(param2LiveMsgResponse.getCodeValue()); 
        if (param2LiveMsgResponse.getMsgId() != 0L)
          setMsgId(param2LiveMsgResponse.getMsgId()); 
        if (param2LiveMsgResponse.getTimestamp() != 0L)
          setTimestamp(param2LiveMsgResponse.getTimestamp()); 
        if (!param2LiveMsgResponse.getMessage().isEmpty()) {
          this.message_ = param2LiveMsgResponse.message_;
          onChanged();
        } 
        mergeUnknownFields(param2LiveMsgResponse.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          LiveChatOuterClass.LiveMsgResponse liveMsgResponse = (LiveChatOuterClass.LiveMsgResponse)LiveChatOuterClass.LiveMsgResponse.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          LiveChatOuterClass.LiveMsgResponse liveMsgResponse = (LiveChatOuterClass.LiveMsgResponse)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((LiveChatOuterClass.LiveMsgResponse)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof LiveChatOuterClass.LiveMsgResponse)
          return mergeFrom((LiveChatOuterClass.LiveMsgResponse)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(LiveChatOuterClass.SendStatusCode param2SendStatusCode) {
        if (param2SendStatusCode != null) {
          this.code_ = param2SendStatusCode.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCodeValue(int param2Int) {
        this.code_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setMessage(String param2String) {
        if (param2String != null) {
          this.message_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMessageBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          LiveChatOuterClass.LiveMsgResponse.checkByteStringIsUtf8(param2ByteString);
          this.message_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMsgId(long param2Long) {
        this.msgId_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setTimestamp(long param2Long) {
        this.timestamp_ = param2Long;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<LiveMsgResponse> {
    public LiveChatOuterClass.LiveMsgResponse parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new LiveChatOuterClass.LiveMsgResponse(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<LiveMsgResponse.Builder> implements LiveMsgResponseOrBuilder {
    private int code_ = 0;
    
    private Object message_ = "";
    
    private long msgId_;
    
    private long timestamp_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      LiveChatOuterClass.LiveMsgResponse.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public LiveChatOuterClass.LiveMsgResponse build() {
      LiveChatOuterClass.LiveMsgResponse liveMsgResponse = buildPartial();
      if (liveMsgResponse.isInitialized())
        return liveMsgResponse; 
      throw newUninitializedMessageException(liveMsgResponse);
    }
    
    public LiveChatOuterClass.LiveMsgResponse buildPartial() {
      LiveChatOuterClass.LiveMsgResponse liveMsgResponse = new LiveChatOuterClass.LiveMsgResponse(this);
      LiveChatOuterClass.LiveMsgResponse.access$1902(liveMsgResponse, this.code_);
      LiveChatOuterClass.LiveMsgResponse.access$2002(liveMsgResponse, this.msgId_);
      LiveChatOuterClass.LiveMsgResponse.access$2102(liveMsgResponse, this.timestamp_);
      LiveChatOuterClass.LiveMsgResponse.access$2202(liveMsgResponse, this.message_);
      onBuilt();
      return liveMsgResponse;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      this.msgId_ = 0L;
      this.timestamp_ = 0L;
      this.message_ = "";
      return this;
    }
    
    public Builder clearCode() {
      this.code_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMessage() {
      this.message_ = LiveChatOuterClass.LiveMsgResponse.getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    
    public Builder clearMsgId() {
      this.msgId_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTimestamp() {
      this.timestamp_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public LiveChatOuterClass.SendStatusCode getCode() {
      LiveChatOuterClass.SendStatusCode sendStatusCode2 = LiveChatOuterClass.SendStatusCode.valueOf(this.code_);
      LiveChatOuterClass.SendStatusCode sendStatusCode1 = sendStatusCode2;
      if (sendStatusCode2 == null)
        sendStatusCode1 = LiveChatOuterClass.SendStatusCode.UNRECOGNIZED; 
      return sendStatusCode1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public LiveChatOuterClass.LiveMsgResponse getDefaultInstanceForType() {
      return LiveChatOuterClass.LiveMsgResponse.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_descriptor;
    }
    
    public String getMessage() {
      Object object = this.message_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.message_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getMessageBytes() {
      Object object = this.message_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.message_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getMsgId() {
      return this.msgId_;
    }
    
    public long getTimestamp() {
      return this.timestamp_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return LiveChatOuterClass.internal_static_cn_irisgw_live_LiveMsgResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveChatOuterClass.LiveMsgResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(LiveChatOuterClass.LiveMsgResponse param1LiveMsgResponse) {
      if (param1LiveMsgResponse == LiveChatOuterClass.LiveMsgResponse.getDefaultInstance())
        return this; 
      if (param1LiveMsgResponse.code_ != 0)
        setCodeValue(param1LiveMsgResponse.getCodeValue()); 
      if (param1LiveMsgResponse.getMsgId() != 0L)
        setMsgId(param1LiveMsgResponse.getMsgId()); 
      if (param1LiveMsgResponse.getTimestamp() != 0L)
        setTimestamp(param1LiveMsgResponse.getTimestamp()); 
      if (!param1LiveMsgResponse.getMessage().isEmpty()) {
        this.message_ = param1LiveMsgResponse.message_;
        onChanged();
      } 
      mergeUnknownFields(param1LiveMsgResponse.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        LiveChatOuterClass.LiveMsgResponse liveMsgResponse = (LiveChatOuterClass.LiveMsgResponse)LiveChatOuterClass.LiveMsgResponse.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        LiveChatOuterClass.LiveMsgResponse liveMsgResponse = (LiveChatOuterClass.LiveMsgResponse)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((LiveChatOuterClass.LiveMsgResponse)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof LiveChatOuterClass.LiveMsgResponse)
        return mergeFrom((LiveChatOuterClass.LiveMsgResponse)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(LiveChatOuterClass.SendStatusCode param1SendStatusCode) {
      if (param1SendStatusCode != null) {
        this.code_ = param1SendStatusCode.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCodeValue(int param1Int) {
      this.code_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMessage(String param1String) {
      if (param1String != null) {
        this.message_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMessageBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        LiveChatOuterClass.LiveMsgResponse.checkByteStringIsUtf8(param1ByteString);
        this.message_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMsgId(long param1Long) {
      this.msgId_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTimestamp(long param1Long) {
      this.timestamp_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface LiveMsgResponseOrBuilder extends MessageOrBuilder {
    LiveChatOuterClass.SendStatusCode getCode();
    
    int getCodeValue();
    
    String getMessage();
    
    ByteString getMessageBytes();
    
    long getMsgId();
    
    long getTimestamp();
  }
  
  public enum SendStatusCode implements ProtocolMessageEnum {
    SEND_EMPTY(0),
    SEND_OK(200),
    UNRECOGNIZED(-1);
    
    public static final int SEND_EMPTY_VALUE = 0;
    
    public static final int SEND_OK_VALUE = 200;
    
    private static final SendStatusCode[] VALUES;
    
    private static final Internal.EnumLiteMap<SendStatusCode> internalValueMap = new Internal.EnumLiteMap<SendStatusCode>() {
        public LiveChatOuterClass.SendStatusCode findValueByNumber(int param2Int) {
          return LiveChatOuterClass.SendStatusCode.forNumber(param2Int);
        }
      };
    
    private final int value;
    
    static {
      VALUES = values();
    }
    
    SendStatusCode(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static SendStatusCode forNumber(int param1Int) {
      return (param1Int != 0) ? ((param1Int != 200) ? null : SEND_OK) : SEND_EMPTY;
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return LiveChatOuterClass.getDescriptor().getEnumTypes().get(0);
    }
    
    public static Internal.EnumLiteMap<SendStatusCode> internalGetValueMap() {
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
  
  static final class null implements Internal.EnumLiteMap<SendStatusCode> {
    public LiveChatOuterClass.SendStatusCode findValueByNumber(int param1Int) {
      return LiveChatOuterClass.SendStatusCode.forNumber(param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\irisgw\live\LiveChatOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */