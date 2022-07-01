package com.blued.im.private_chat;

import com.blued.im.CommonOuterClass;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ReceiptOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor, new String[] { "Common", "SessionType", "From", "To", "Seqnum", "IsDeleteMsg" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor, new String[] { "Code", "Message", "Seqnum", "RequestId", "RequestTime", "ResponseTime" });
  
  static {
    CodeOuterClass.getDescriptor();
    CommonOuterClass.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor1 = CodeOuterClass.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = CommonOuterClass.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\rReceipt.proto\022\031com.blued.im.private_chat\032\nCode.proto\032\fCommon.proto\"\001\n\016ReceiptRequest\022$\n\006common\030\001 \001(\0132\024.com.blued.im.Common\022\024\n\fsession_type\030\003 \001(\r\022\f\n\004from\030\004 \001(\r\022\n\n\002to\030\005 \001(\r\022\016\n\006seqnum\030\006 \001(\003\022\025\n\ris_delete_msg\030\007 \001(\b\"¢\001\n\017ReceiptResponse\022-\n\004code\030\001 \001(\0162\037.com.blued.im.private_chat.Code\022\017\n\007message\030\002 \001(\t\022\016\n\006seqnum\030\003 \001(\003\022\022\n\nrequest_id\030\004 \001(\t\022\024\n\frequest_time\030\005 \001(\003\022\025\n\rresponse_time\030\006 \001(\0032ø\003\n\007Receipt\022^\n\003Got\022).com.blued.im.private_chat.ReceiptRequest\032*.com.blued.im.private_chat.ReceiptResponse\"\000\022_\n\004Read\022).com.blued.im.private_chat.ReceiptRequest\032*.com.blued.im.private_chat.ReceiptResponse\"\000\022b\n\007Retract\022).com.blued.im.private_chat.ReceiptRequest\032*.com.blued.im.private_chat.ReceiptResponse\"\000\022a\n\006DelAll\022).com.blued.im.private_chat.ReceiptRequest\032*.com.blued.im.private_chat.ReceiptResponse\"\000\022e\n\nDelSession\022).com.blued.im.private_chat.ReceiptRequest\032*.com.blued.im.private_chat.ReceiptResponse\"\000B\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2 });
  }
  
  public static final class ReceiptRequest extends GeneratedMessageV3 implements ReceiptRequestOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final ReceiptRequest DEFAULT_INSTANCE = new ReceiptRequest();
    
    public static final int FROM_FIELD_NUMBER = 4;
    
    public static final int IS_DELETE_MSG_FIELD_NUMBER = 7;
    
    private static final Parser<ReceiptRequest> PARSER = (Parser<ReceiptRequest>)new AbstractParser<ReceiptRequest>() {
        public ReceiptOuterClass.ReceiptRequest parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ReceiptOuterClass.ReceiptRequest(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SEQNUM_FIELD_NUMBER = 6;
    
    public static final int SESSION_TYPE_FIELD_NUMBER = 3;
    
    public static final int TO_FIELD_NUMBER = 5;
    
    private static final long serialVersionUID = 0L;
    
    private CommonOuterClass.Common common_;
    
    private int from_;
    
    private boolean isDeleteMsg_;
    
    private byte memoizedIsInitialized = -1;
    
    private long seqnum_;
    
    private int sessionType_;
    
    private int to_;
    
    private ReceiptRequest() {}
    
    private ReceiptRequest(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              if (i != 10) {
                if (i != 24) {
                  if (i != 32) {
                    if (i != 40) {
                      if (i != 48) {
                        if (i != 56) {
                          if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                            continue; 
                          continue;
                        } 
                        this.isDeleteMsg_ = param1CodedInputStream.readBool();
                        continue;
                      } 
                      this.seqnum_ = param1CodedInputStream.readInt64();
                      continue;
                    } 
                    this.to_ = param1CodedInputStream.readUInt32();
                    continue;
                  } 
                  this.from_ = param1CodedInputStream.readUInt32();
                  continue;
                } 
                this.sessionType_ = param1CodedInputStream.readUInt32();
                continue;
              } 
              CommonOuterClass.Common.Builder builder1 = null;
              if (this.common_ != null)
                builder1 = this.common_.toBuilder(); 
              this.common_ = (CommonOuterClass.Common)param1CodedInputStream.readMessage(CommonOuterClass.Common.parser(), param1ExtensionRegistryLite);
              if (builder1 != null) {
                builder1.mergeFrom(this.common_);
                this.common_ = builder1.buildPartial();
              } 
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
    
    private ReceiptRequest(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ReceiptRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ReceiptRequest param1ReceiptRequest) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ReceiptRequest);
    }
    
    public static ReceiptRequest parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ReceiptRequest parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptRequest parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ByteString);
    }
    
    public static ReceiptRequest parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ReceiptRequest parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ReceiptRequest parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptRequest parseFrom(InputStream param1InputStream) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ReceiptRequest parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptRequest)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptRequest parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ReceiptRequest parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ReceiptRequest parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ReceiptRequest parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptRequest)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ReceiptRequest> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ReceiptRequest))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getSessionType() != param1Object.getSessionType()) ? false : ((getFrom() != param1Object.getFrom()) ? false : ((getTo() != param1Object.getTo()) ? false : ((getSeqnum() != param1Object.getSeqnum()) ? false : ((getIsDeleteMsg() != param1Object.getIsDeleteMsg()) ? false : (!!this.unknownFields.equals(((ReceiptRequest)param1Object).unknownFields))))))));
    }
    
    public CommonOuterClass.Common getCommon() {
      CommonOuterClass.Common common2 = this.common_;
      CommonOuterClass.Common common1 = common2;
      if (common2 == null)
        common1 = CommonOuterClass.Common.getDefaultInstance(); 
      return common1;
    }
    
    public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
      return (CommonOuterClass.CommonOrBuilder)getCommon();
    }
    
    public ReceiptRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsDeleteMsg() {
      return this.isDeleteMsg_;
    }
    
    public Parser<ReceiptRequest> getParserForType() {
      return PARSER;
    }
    
    public long getSeqnum() {
      return this.seqnum_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.common_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getCommon()); 
      int k = this.sessionType_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(3, k); 
      k = this.from_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeUInt32Size(4, k); 
      k = this.to_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(5, k); 
      long l = this.seqnum_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(6, l); 
      boolean bool = this.isDeleteMsg_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(7, bool); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public int getSessionType() {
      return this.sessionType_;
    }
    
    public int getTo() {
      return this.to_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasCommon() {
      return (this.common_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasCommon())
        i = (j * 37 + 1) * 53 + getCommon().hashCode(); 
      i = ((((((((((i * 37 + 3) * 53 + getSessionType()) * 37 + 4) * 53 + getFrom()) * 37 + 5) * 53 + getTo()) * 37 + 6) * 53 + Internal.hashLong(getSeqnum())) * 37 + 7) * 53 + Internal.hashBoolean(getIsDeleteMsg())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptRequest.class, Builder.class);
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
      return new ReceiptRequest();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getCommon()); 
      int i = this.sessionType_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(3, i); 
      i = this.from_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(4, i); 
      i = this.to_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(5, i); 
      long l = this.seqnum_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(6, l); 
      boolean bool = this.isDeleteMsg_;
      if (bool)
        param1CodedOutputStream.writeBool(7, bool); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiptOuterClass.ReceiptRequestOrBuilder {
      private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
      
      private CommonOuterClass.Common common_;
      
      private int from_;
      
      private boolean isDeleteMsg_;
      
      private long seqnum_;
      
      private int sessionType_;
      
      private int to_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
        if (this.commonBuilder_ == null) {
          this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.common_ = null;
        } 
        return this.commonBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ReceiptOuterClass.ReceiptRequest.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ReceiptOuterClass.ReceiptRequest build() {
        ReceiptOuterClass.ReceiptRequest receiptRequest = buildPartial();
        if (receiptRequest.isInitialized())
          return receiptRequest; 
        throw newUninitializedMessageException(receiptRequest);
      }
      
      public ReceiptOuterClass.ReceiptRequest buildPartial() {
        ReceiptOuterClass.ReceiptRequest receiptRequest = new ReceiptOuterClass.ReceiptRequest(this);
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          ReceiptOuterClass.ReceiptRequest.access$602(receiptRequest, this.common_);
        } else {
          ReceiptOuterClass.ReceiptRequest.access$602(receiptRequest, (CommonOuterClass.Common)singleFieldBuilderV3.build());
        } 
        ReceiptOuterClass.ReceiptRequest.access$702(receiptRequest, this.sessionType_);
        ReceiptOuterClass.ReceiptRequest.access$802(receiptRequest, this.from_);
        ReceiptOuterClass.ReceiptRequest.access$902(receiptRequest, this.to_);
        ReceiptOuterClass.ReceiptRequest.access$1002(receiptRequest, this.seqnum_);
        ReceiptOuterClass.ReceiptRequest.access$1102(receiptRequest, this.isDeleteMsg_);
        onBuilt();
        return receiptRequest;
      }
      
      public Builder clear() {
        super.clear();
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.sessionType_ = 0;
        this.from_ = 0;
        this.to_ = 0;
        this.seqnum_ = 0L;
        this.isDeleteMsg_ = false;
        return this;
      }
      
      public Builder clearCommon() {
        if (this.commonBuilder_ == null) {
          this.common_ = null;
          onChanged();
          return this;
        } 
        this.common_ = null;
        this.commonBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFrom() {
        this.from_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearIsDeleteMsg() {
        this.isDeleteMsg_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSeqnum() {
        this.seqnum_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearSessionType() {
        this.sessionType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTo() {
        this.to_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public CommonOuterClass.Common getCommon() {
        CommonOuterClass.Common common;
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          CommonOuterClass.Common common1 = this.common_;
          common = common1;
          if (common1 == null)
            common = CommonOuterClass.Common.getDefaultInstance(); 
          return common;
        } 
        return (CommonOuterClass.Common)common.getMessage();
      }
      
      public CommonOuterClass.Common.Builder getCommonBuilder() {
        onChanged();
        return (CommonOuterClass.Common.Builder)getCommonFieldBuilder().getBuilder();
      }
      
      public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 != null)
          return (CommonOuterClass.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        CommonOuterClass.Common common2 = this.common_;
        CommonOuterClass.Common common1 = common2;
        if (common2 == null)
          common1 = CommonOuterClass.Common.getDefaultInstance(); 
        return (CommonOuterClass.CommonOrBuilder)common1;
      }
      
      public ReceiptOuterClass.ReceiptRequest getDefaultInstanceForType() {
        return ReceiptOuterClass.ReceiptRequest.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
      }
      
      public int getFrom() {
        return this.from_;
      }
      
      public boolean getIsDeleteMsg() {
        return this.isDeleteMsg_;
      }
      
      public long getSeqnum() {
        return this.seqnum_;
      }
      
      public int getSessionType() {
        return this.sessionType_;
      }
      
      public int getTo() {
        return this.to_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptOuterClass.ReceiptRequest.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeCommon(CommonOuterClass.Common param2Common) {
        CommonOuterClass.Common common;
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          common = this.common_;
          if (common != null) {
            this.common_ = CommonOuterClass.Common.newBuilder(common).mergeFrom(param2Common).buildPartial();
          } else {
            this.common_ = param2Common;
          } 
          onChanged();
          return this;
        } 
        common.mergeFrom((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder mergeFrom(ReceiptOuterClass.ReceiptRequest param2ReceiptRequest) {
        if (param2ReceiptRequest == ReceiptOuterClass.ReceiptRequest.getDefaultInstance())
          return this; 
        if (param2ReceiptRequest.hasCommon())
          mergeCommon(param2ReceiptRequest.getCommon()); 
        if (param2ReceiptRequest.getSessionType() != 0)
          setSessionType(param2ReceiptRequest.getSessionType()); 
        if (param2ReceiptRequest.getFrom() != 0)
          setFrom(param2ReceiptRequest.getFrom()); 
        if (param2ReceiptRequest.getTo() != 0)
          setTo(param2ReceiptRequest.getTo()); 
        if (param2ReceiptRequest.getSeqnum() != 0L)
          setSeqnum(param2ReceiptRequest.getSeqnum()); 
        if (param2ReceiptRequest.getIsDeleteMsg())
          setIsDeleteMsg(param2ReceiptRequest.getIsDeleteMsg()); 
        mergeUnknownFields(param2ReceiptRequest.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ReceiptOuterClass.ReceiptRequest receiptRequest = (ReceiptOuterClass.ReceiptRequest)ReceiptOuterClass.ReceiptRequest.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ReceiptOuterClass.ReceiptRequest receiptRequest = (ReceiptOuterClass.ReceiptRequest)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ReceiptOuterClass.ReceiptRequest)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ReceiptOuterClass.ReceiptRequest)
          return mergeFrom((ReceiptOuterClass.ReceiptRequest)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCommon(CommonOuterClass.Common.Builder param2Builder) {
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.common_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setCommon(CommonOuterClass.Common param2Common) {
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Common != null) {
            this.common_ = param2Common;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Common);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFrom(int param2Int) {
        this.from_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsDeleteMsg(boolean param2Boolean) {
        this.isDeleteMsg_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSeqnum(long param2Long) {
        this.seqnum_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setSessionType(int param2Int) {
        this.sessionType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setTo(int param2Int) {
        this.to_ = param2Int;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<ReceiptRequest> {
    public ReceiptOuterClass.ReceiptRequest parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ReceiptOuterClass.ReceiptRequest(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ReceiptRequest.Builder> implements ReceiptRequestOrBuilder {
    private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
    
    private CommonOuterClass.Common common_;
    
    private int from_;
    
    private boolean isDeleteMsg_;
    
    private long seqnum_;
    
    private int sessionType_;
    
    private int to_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
      if (this.commonBuilder_ == null) {
        this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.common_ = null;
      } 
      return this.commonBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ReceiptOuterClass.ReceiptRequest.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ReceiptOuterClass.ReceiptRequest build() {
      ReceiptOuterClass.ReceiptRequest receiptRequest = buildPartial();
      if (receiptRequest.isInitialized())
        return receiptRequest; 
      throw newUninitializedMessageException(receiptRequest);
    }
    
    public ReceiptOuterClass.ReceiptRequest buildPartial() {
      ReceiptOuterClass.ReceiptRequest receiptRequest = new ReceiptOuterClass.ReceiptRequest(this);
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        ReceiptOuterClass.ReceiptRequest.access$602(receiptRequest, this.common_);
      } else {
        ReceiptOuterClass.ReceiptRequest.access$602(receiptRequest, (CommonOuterClass.Common)singleFieldBuilderV3.build());
      } 
      ReceiptOuterClass.ReceiptRequest.access$702(receiptRequest, this.sessionType_);
      ReceiptOuterClass.ReceiptRequest.access$802(receiptRequest, this.from_);
      ReceiptOuterClass.ReceiptRequest.access$902(receiptRequest, this.to_);
      ReceiptOuterClass.ReceiptRequest.access$1002(receiptRequest, this.seqnum_);
      ReceiptOuterClass.ReceiptRequest.access$1102(receiptRequest, this.isDeleteMsg_);
      onBuilt();
      return receiptRequest;
    }
    
    public Builder clear() {
      super.clear();
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.sessionType_ = 0;
      this.from_ = 0;
      this.to_ = 0;
      this.seqnum_ = 0L;
      this.isDeleteMsg_ = false;
      return this;
    }
    
    public Builder clearCommon() {
      if (this.commonBuilder_ == null) {
        this.common_ = null;
        onChanged();
        return this;
      } 
      this.common_ = null;
      this.commonBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFrom() {
      this.from_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearIsDeleteMsg() {
      this.isDeleteMsg_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSeqnum() {
      this.seqnum_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearSessionType() {
      this.sessionType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTo() {
      this.to_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public CommonOuterClass.Common getCommon() {
      CommonOuterClass.Common common;
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        CommonOuterClass.Common common1 = this.common_;
        common = common1;
        if (common1 == null)
          common = CommonOuterClass.Common.getDefaultInstance(); 
        return common;
      } 
      return (CommonOuterClass.Common)common.getMessage();
    }
    
    public CommonOuterClass.Common.Builder getCommonBuilder() {
      onChanged();
      return (CommonOuterClass.Common.Builder)getCommonFieldBuilder().getBuilder();
    }
    
    public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 != null)
        return (CommonOuterClass.CommonOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      CommonOuterClass.Common common2 = this.common_;
      CommonOuterClass.Common common1 = common2;
      if (common2 == null)
        common1 = CommonOuterClass.Common.getDefaultInstance(); 
      return (CommonOuterClass.CommonOrBuilder)common1;
    }
    
    public ReceiptOuterClass.ReceiptRequest getDefaultInstanceForType() {
      return ReceiptOuterClass.ReceiptRequest.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsDeleteMsg() {
      return this.isDeleteMsg_;
    }
    
    public long getSeqnum() {
      return this.seqnum_;
    }
    
    public int getSessionType() {
      return this.sessionType_;
    }
    
    public int getTo() {
      return this.to_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptOuterClass.ReceiptRequest.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeCommon(CommonOuterClass.Common param1Common) {
      CommonOuterClass.Common common;
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        common = this.common_;
        if (common != null) {
          this.common_ = CommonOuterClass.Common.newBuilder(common).mergeFrom(param1Common).buildPartial();
        } else {
          this.common_ = param1Common;
        } 
        onChanged();
        return this;
      } 
      common.mergeFrom((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder mergeFrom(ReceiptOuterClass.ReceiptRequest param1ReceiptRequest) {
      if (param1ReceiptRequest == ReceiptOuterClass.ReceiptRequest.getDefaultInstance())
        return this; 
      if (param1ReceiptRequest.hasCommon())
        mergeCommon(param1ReceiptRequest.getCommon()); 
      if (param1ReceiptRequest.getSessionType() != 0)
        setSessionType(param1ReceiptRequest.getSessionType()); 
      if (param1ReceiptRequest.getFrom() != 0)
        setFrom(param1ReceiptRequest.getFrom()); 
      if (param1ReceiptRequest.getTo() != 0)
        setTo(param1ReceiptRequest.getTo()); 
      if (param1ReceiptRequest.getSeqnum() != 0L)
        setSeqnum(param1ReceiptRequest.getSeqnum()); 
      if (param1ReceiptRequest.getIsDeleteMsg())
        setIsDeleteMsg(param1ReceiptRequest.getIsDeleteMsg()); 
      mergeUnknownFields(param1ReceiptRequest.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ReceiptOuterClass.ReceiptRequest receiptRequest = (ReceiptOuterClass.ReceiptRequest)ReceiptOuterClass.ReceiptRequest.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ReceiptOuterClass.ReceiptRequest receiptRequest = (ReceiptOuterClass.ReceiptRequest)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ReceiptOuterClass.ReceiptRequest)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ReceiptOuterClass.ReceiptRequest)
        return mergeFrom((ReceiptOuterClass.ReceiptRequest)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCommon(CommonOuterClass.Common.Builder param1Builder) {
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.common_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setCommon(CommonOuterClass.Common param1Common) {
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Common != null) {
          this.common_ = param1Common;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Common);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFrom(int param1Int) {
      this.from_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsDeleteMsg(boolean param1Boolean) {
      this.isDeleteMsg_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSeqnum(long param1Long) {
      this.seqnum_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setSessionType(int param1Int) {
      this.sessionType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setTo(int param1Int) {
      this.to_ = param1Int;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ReceiptRequestOrBuilder extends MessageOrBuilder {
    CommonOuterClass.Common getCommon();
    
    CommonOuterClass.CommonOrBuilder getCommonOrBuilder();
    
    int getFrom();
    
    boolean getIsDeleteMsg();
    
    long getSeqnum();
    
    int getSessionType();
    
    int getTo();
    
    boolean hasCommon();
  }
  
  public static final class ReceiptResponse extends GeneratedMessageV3 implements ReceiptResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final ReceiptResponse DEFAULT_INSTANCE = new ReceiptResponse();
    
    public static final int MESSAGE_FIELD_NUMBER = 2;
    
    private static final Parser<ReceiptResponse> PARSER = (Parser<ReceiptResponse>)new AbstractParser<ReceiptResponse>() {
        public ReceiptOuterClass.ReceiptResponse parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new ReceiptOuterClass.ReceiptResponse(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_ID_FIELD_NUMBER = 4;
    
    public static final int REQUEST_TIME_FIELD_NUMBER = 5;
    
    public static final int RESPONSE_TIME_FIELD_NUMBER = 6;
    
    public static final int SEQNUM_FIELD_NUMBER = 3;
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object message_;
    
    private volatile Object requestId_;
    
    private long requestTime_;
    
    private long responseTime_;
    
    private long seqnum_;
    
    private ReceiptResponse() {
      this.code_ = 0;
      this.message_ = "";
      this.requestId_ = "";
    }
    
    private ReceiptResponse(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                      if (i != 40) {
                        if (i != 48) {
                          if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                            continue; 
                          continue;
                        } 
                        this.responseTime_ = param1CodedInputStream.readInt64();
                        continue;
                      } 
                      this.requestTime_ = param1CodedInputStream.readInt64();
                      continue;
                    } 
                    this.requestId_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.seqnum_ = param1CodedInputStream.readInt64();
                  continue;
                } 
                this.message_ = param1CodedInputStream.readStringRequireUtf8();
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
    
    private ReceiptResponse(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static ReceiptResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(ReceiptResponse param1ReceiptResponse) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1ReceiptResponse);
    }
    
    public static ReceiptResponse parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static ReceiptResponse parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptResponse parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ByteString);
    }
    
    public static ReceiptResponse parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static ReceiptResponse parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static ReceiptResponse parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptResponse parseFrom(InputStream param1InputStream) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static ReceiptResponse parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (ReceiptResponse)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static ReceiptResponse parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static ReceiptResponse parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static ReceiptResponse parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static ReceiptResponse parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (ReceiptResponse)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<ReceiptResponse> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ReceiptResponse))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.code_ != ((ReceiptResponse)param1Object).code_) ? false : (!getMessage().equals(param1Object.getMessage()) ? false : ((getSeqnum() != param1Object.getSeqnum()) ? false : (!getRequestId().equals(param1Object.getRequestId()) ? false : ((getRequestTime() != param1Object.getRequestTime()) ? false : ((getResponseTime() != param1Object.getResponseTime()) ? false : (!!this.unknownFields.equals(((ReceiptResponse)param1Object).unknownFields)))))));
    }
    
    public CodeOuterClass.Code getCode() {
      CodeOuterClass.Code code2 = CodeOuterClass.Code.valueOf(this.code_);
      CodeOuterClass.Code code1 = code2;
      if (code2 == null)
        code1 = CodeOuterClass.Code.UNRECOGNIZED; 
      return code1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public ReceiptResponse getDefaultInstanceForType() {
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
    
    public Parser<ReceiptResponse> getParserForType() {
      return PARSER;
    }
    
    public String getRequestId() {
      Object object = this.requestId_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.requestId_ = object;
      return (String)object;
    }
    
    public ByteString getRequestIdBytes() {
      Object object = this.requestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getRequestTime() {
      return this.requestTime_;
    }
    
    public long getResponseTime() {
      return this.responseTime_;
    }
    
    public long getSeqnum() {
      return this.seqnum_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.code_); 
      i = j;
      if (!getMessageBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.message_); 
      long l = this.seqnum_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(3, l); 
      i = j;
      if (!getRequestIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.requestId_); 
      l = this.requestTime_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
      l = this.responseTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(6, l); 
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
      int i = (((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.code_) * 37 + 2) * 53 + getMessage().hashCode()) * 37 + 3) * 53 + Internal.hashLong(getSeqnum())) * 37 + 4) * 53 + getRequestId().hashCode()) * 37 + 5) * 53 + Internal.hashLong(getRequestTime())) * 37 + 6) * 53 + Internal.hashLong(getResponseTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptResponse.class, Builder.class);
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
      return new ReceiptResponse();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber())
        param1CodedOutputStream.writeEnum(1, this.code_); 
      if (!getMessageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.message_); 
      long l = this.seqnum_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(3, l); 
      if (!getRequestIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.requestId_); 
      l = this.requestTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      l = this.responseTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(6, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiptOuterClass.ReceiptResponseOrBuilder {
      private int code_ = 0;
      
      private Object message_ = "";
      
      private Object requestId_ = "";
      
      private long requestTime_;
      
      private long responseTime_;
      
      private long seqnum_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        ReceiptOuterClass.ReceiptResponse.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public ReceiptOuterClass.ReceiptResponse build() {
        ReceiptOuterClass.ReceiptResponse receiptResponse = buildPartial();
        if (receiptResponse.isInitialized())
          return receiptResponse; 
        throw newUninitializedMessageException(receiptResponse);
      }
      
      public ReceiptOuterClass.ReceiptResponse buildPartial() {
        ReceiptOuterClass.ReceiptResponse receiptResponse = new ReceiptOuterClass.ReceiptResponse(this);
        ReceiptOuterClass.ReceiptResponse.access$2102(receiptResponse, this.code_);
        ReceiptOuterClass.ReceiptResponse.access$2202(receiptResponse, this.message_);
        ReceiptOuterClass.ReceiptResponse.access$2302(receiptResponse, this.seqnum_);
        ReceiptOuterClass.ReceiptResponse.access$2402(receiptResponse, this.requestId_);
        ReceiptOuterClass.ReceiptResponse.access$2502(receiptResponse, this.requestTime_);
        ReceiptOuterClass.ReceiptResponse.access$2602(receiptResponse, this.responseTime_);
        onBuilt();
        return receiptResponse;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        this.message_ = "";
        this.seqnum_ = 0L;
        this.requestId_ = "";
        this.requestTime_ = 0L;
        this.responseTime_ = 0L;
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
        this.message_ = ReceiptOuterClass.ReceiptResponse.getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearRequestId() {
        this.requestId_ = ReceiptOuterClass.ReceiptResponse.getDefaultInstance().getRequestId();
        onChanged();
        return this;
      }
      
      public Builder clearRequestTime() {
        this.requestTime_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearResponseTime() {
        this.responseTime_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearSeqnum() {
        this.seqnum_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public CodeOuterClass.Code getCode() {
        CodeOuterClass.Code code2 = CodeOuterClass.Code.valueOf(this.code_);
        CodeOuterClass.Code code1 = code2;
        if (code2 == null)
          code1 = CodeOuterClass.Code.UNRECOGNIZED; 
        return code1;
      }
      
      public int getCodeValue() {
        return this.code_;
      }
      
      public ReceiptOuterClass.ReceiptResponse getDefaultInstanceForType() {
        return ReceiptOuterClass.ReceiptResponse.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
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
      
      public String getRequestId() {
        Object object = this.requestId_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.requestId_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getRequestIdBytes() {
        Object object = this.requestId_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.requestId_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public long getRequestTime() {
        return this.requestTime_;
      }
      
      public long getResponseTime() {
        return this.responseTime_;
      }
      
      public long getSeqnum() {
        return this.seqnum_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptOuterClass.ReceiptResponse.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(ReceiptOuterClass.ReceiptResponse param2ReceiptResponse) {
        if (param2ReceiptResponse == ReceiptOuterClass.ReceiptResponse.getDefaultInstance())
          return this; 
        if (param2ReceiptResponse.code_ != 0)
          setCodeValue(param2ReceiptResponse.getCodeValue()); 
        if (!param2ReceiptResponse.getMessage().isEmpty()) {
          this.message_ = param2ReceiptResponse.message_;
          onChanged();
        } 
        if (param2ReceiptResponse.getSeqnum() != 0L)
          setSeqnum(param2ReceiptResponse.getSeqnum()); 
        if (!param2ReceiptResponse.getRequestId().isEmpty()) {
          this.requestId_ = param2ReceiptResponse.requestId_;
          onChanged();
        } 
        if (param2ReceiptResponse.getRequestTime() != 0L)
          setRequestTime(param2ReceiptResponse.getRequestTime()); 
        if (param2ReceiptResponse.getResponseTime() != 0L)
          setResponseTime(param2ReceiptResponse.getResponseTime()); 
        mergeUnknownFields(param2ReceiptResponse.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          ReceiptOuterClass.ReceiptResponse receiptResponse = (ReceiptOuterClass.ReceiptResponse)ReceiptOuterClass.ReceiptResponse.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          ReceiptOuterClass.ReceiptResponse receiptResponse = (ReceiptOuterClass.ReceiptResponse)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((ReceiptOuterClass.ReceiptResponse)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof ReceiptOuterClass.ReceiptResponse)
          return mergeFrom((ReceiptOuterClass.ReceiptResponse)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(CodeOuterClass.Code param2Code) {
        if (param2Code != null) {
          this.code_ = param2Code.getNumber();
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
          ReceiptOuterClass.ReceiptResponse.checkByteStringIsUtf8(param2ByteString);
          this.message_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRequestId(String param2String) {
        if (param2String != null) {
          this.requestId_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRequestIdBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          ReceiptOuterClass.ReceiptResponse.checkByteStringIsUtf8(param2ByteString);
          this.requestId_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setRequestTime(long param2Long) {
        this.requestTime_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setResponseTime(long param2Long) {
        this.responseTime_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setSeqnum(long param2Long) {
        this.seqnum_ = param2Long;
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<ReceiptResponse> {
    public ReceiptOuterClass.ReceiptResponse parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new ReceiptOuterClass.ReceiptResponse(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<ReceiptResponse.Builder> implements ReceiptResponseOrBuilder {
    private int code_ = 0;
    
    private Object message_ = "";
    
    private Object requestId_ = "";
    
    private long requestTime_;
    
    private long responseTime_;
    
    private long seqnum_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      ReceiptOuterClass.ReceiptResponse.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public ReceiptOuterClass.ReceiptResponse build() {
      ReceiptOuterClass.ReceiptResponse receiptResponse = buildPartial();
      if (receiptResponse.isInitialized())
        return receiptResponse; 
      throw newUninitializedMessageException(receiptResponse);
    }
    
    public ReceiptOuterClass.ReceiptResponse buildPartial() {
      ReceiptOuterClass.ReceiptResponse receiptResponse = new ReceiptOuterClass.ReceiptResponse(this);
      ReceiptOuterClass.ReceiptResponse.access$2102(receiptResponse, this.code_);
      ReceiptOuterClass.ReceiptResponse.access$2202(receiptResponse, this.message_);
      ReceiptOuterClass.ReceiptResponse.access$2302(receiptResponse, this.seqnum_);
      ReceiptOuterClass.ReceiptResponse.access$2402(receiptResponse, this.requestId_);
      ReceiptOuterClass.ReceiptResponse.access$2502(receiptResponse, this.requestTime_);
      ReceiptOuterClass.ReceiptResponse.access$2602(receiptResponse, this.responseTime_);
      onBuilt();
      return receiptResponse;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      this.message_ = "";
      this.seqnum_ = 0L;
      this.requestId_ = "";
      this.requestTime_ = 0L;
      this.responseTime_ = 0L;
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
      this.message_ = ReceiptOuterClass.ReceiptResponse.getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequestId() {
      this.requestId_ = ReceiptOuterClass.ReceiptResponse.getDefaultInstance().getRequestId();
      onChanged();
      return this;
    }
    
    public Builder clearRequestTime() {
      this.requestTime_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearResponseTime() {
      this.responseTime_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearSeqnum() {
      this.seqnum_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public CodeOuterClass.Code getCode() {
      CodeOuterClass.Code code2 = CodeOuterClass.Code.valueOf(this.code_);
      CodeOuterClass.Code code1 = code2;
      if (code2 == null)
        code1 = CodeOuterClass.Code.UNRECOGNIZED; 
      return code1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public ReceiptOuterClass.ReceiptResponse getDefaultInstanceForType() {
      return ReceiptOuterClass.ReceiptResponse.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
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
    
    public String getRequestId() {
      Object object = this.requestId_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.requestId_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getRequestIdBytes() {
      Object object = this.requestId_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.requestId_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public long getRequestTime() {
      return this.requestTime_;
    }
    
    public long getResponseTime() {
      return this.responseTime_;
    }
    
    public long getSeqnum() {
      return this.seqnum_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptOuterClass.ReceiptResponse.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(ReceiptOuterClass.ReceiptResponse param1ReceiptResponse) {
      if (param1ReceiptResponse == ReceiptOuterClass.ReceiptResponse.getDefaultInstance())
        return this; 
      if (param1ReceiptResponse.code_ != 0)
        setCodeValue(param1ReceiptResponse.getCodeValue()); 
      if (!param1ReceiptResponse.getMessage().isEmpty()) {
        this.message_ = param1ReceiptResponse.message_;
        onChanged();
      } 
      if (param1ReceiptResponse.getSeqnum() != 0L)
        setSeqnum(param1ReceiptResponse.getSeqnum()); 
      if (!param1ReceiptResponse.getRequestId().isEmpty()) {
        this.requestId_ = param1ReceiptResponse.requestId_;
        onChanged();
      } 
      if (param1ReceiptResponse.getRequestTime() != 0L)
        setRequestTime(param1ReceiptResponse.getRequestTime()); 
      if (param1ReceiptResponse.getResponseTime() != 0L)
        setResponseTime(param1ReceiptResponse.getResponseTime()); 
      mergeUnknownFields(param1ReceiptResponse.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        ReceiptOuterClass.ReceiptResponse receiptResponse = (ReceiptOuterClass.ReceiptResponse)ReceiptOuterClass.ReceiptResponse.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        ReceiptOuterClass.ReceiptResponse receiptResponse = (ReceiptOuterClass.ReceiptResponse)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((ReceiptOuterClass.ReceiptResponse)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof ReceiptOuterClass.ReceiptResponse)
        return mergeFrom((ReceiptOuterClass.ReceiptResponse)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(CodeOuterClass.Code param1Code) {
      if (param1Code != null) {
        this.code_ = param1Code.getNumber();
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
        ReceiptOuterClass.ReceiptResponse.checkByteStringIsUtf8(param1ByteString);
        this.message_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRequestId(String param1String) {
      if (param1String != null) {
        this.requestId_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestIdBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        ReceiptOuterClass.ReceiptResponse.checkByteStringIsUtf8(param1ByteString);
        this.requestId_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRequestTime(long param1Long) {
      this.requestTime_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setResponseTime(long param1Long) {
      this.responseTime_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setSeqnum(long param1Long) {
      this.seqnum_ = param1Long;
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ReceiptResponseOrBuilder extends MessageOrBuilder {
    CodeOuterClass.Code getCode();
    
    int getCodeValue();
    
    String getMessage();
    
    ByteString getMessageBytes();
    
    String getRequestId();
    
    ByteString getRequestIdBytes();
    
    long getRequestTime();
    
    long getResponseTime();
    
    long getSeqnum();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\ReceiptOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */