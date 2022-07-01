package com.blued.im.private_chat;

import com.blued.im.CommonOuterClass;
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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PrivateChatOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Receive_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_Request_descriptor, new String[] { "Common", "To", "MsgType", "LocalId", "Body", "From", "SessionType" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Response_descriptor = getDescriptor().getMessageTypes().get(1);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_Response_descriptor, new String[] { "Code", "Message", "MsgId", "LocalId", "RequestId", "RequestTime", "ResponseTime" });
  
  static {
    internal_static_com_blued_im_private_chat_Receive_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_Receive_descriptor, new String[] { 
          "From", "To", "MsgType", "MsgId", "Timestamp", "Distance", "Coords", "SessionStatus", "IsDeleted", "IsRead", 
          "Body", "SessionType", "PhoneSessionId" });
    AnyProto.getDescriptor();
    MsgTypeOuterClass.getDescriptor();
    CodeOuterClass.getDescriptor();
    CommonOuterClass.getDescriptor();
    PushBodyOuterClass.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor1 = AnyProto.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = MsgTypeOuterClass.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor3 = CodeOuterClass.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor4 = CommonOuterClass.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor5 = PushBodyOuterClass.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\021PrivateChat.proto\022\031com.blued.im.private_chat\032\031google/protobuf/any.proto\032\rMsgType.proto\032\nCode.proto\032\fCommon.proto\032\016PushBody.proto\"Ë\001\n\007Request\022$\n\006common\030\001 \001(\0132\024.com.blued.im.Common\022\n\n\002to\030\002 \001(\r\0224\n\bmsg_type\030\003 \001(\0162\".com.blued.im.private_chat.MsgType\022\020\n\blocal_id\030\004 \001(\005\022\"\n\004body\030\005 \001(\0132\024.google.protobuf.Any\022\f\n\004from\030\006 \001(\r\022\024\n\fsession_type\030\007 \001(\r\"­\001\n\bResponse\022-\n\004code\030\001 \001(\0162\037.com.blued.im.private_chat.Code\022\017\n\007message\030\002 \001(\t\022\016\n\006msg_id\030\003 \001(\003\022\020\n\blocal_id\030\004 \001(\005\022\022\n\nrequest_id\030\005 \001(\t\022\024\n\frequest_time\030\006 \001(\003\022\025\n\rresponse_time\030\007 \001(\003\"¾\002\n\007Receive\022\f\n\004from\030\001 \001(\r\022\n\n\002to\030\002 \001(\r\0224\n\bmsg_type\030\003 \001(\0162\".com.blued.im.private_chat.MsgType\022\016\n\006msg_id\030\004 \001(\003\022\021\n\ttimestamp\030\005 \001(\003\022\020\n\bdistance\030\006 \001(\t\022\016\n\006coords\030\007 \003(\001\022\026\n\016session_status\030\b \001(\005\022\022\n\nis_deleted\030\t \001(\b\022\017\n\007is_read\030\n \001(\b\0221\n\004body\030\013 \001(\0132#.com.blued.im.private_chat.PushBody\022\024\n\fsession_type\030\f \001(\r\022\030\n\020phone_session_id\030\r \001(\r2`\n\013PrivateChat\022Q\n\004Send\022\".com.blued.im.private_chat.Request\032#.com.blued.im.private_chat.Response\"\0002^\n\tGroupChat\022Q\n\004Send\022\".com.blued.im.private_chat.Request\032#.com.blued.im.private_chat.Response\"\000B\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3, fileDescriptor4, fileDescriptor5 });
  }
  
  public static final class Receive extends GeneratedMessageV3 implements ReceiveOrBuilder {
    public static final int BODY_FIELD_NUMBER = 11;
    
    public static final int COORDS_FIELD_NUMBER = 7;
    
    private static final Receive DEFAULT_INSTANCE = new Receive();
    
    public static final int DISTANCE_FIELD_NUMBER = 6;
    
    public static final int FROM_FIELD_NUMBER = 1;
    
    public static final int IS_DELETED_FIELD_NUMBER = 9;
    
    public static final int IS_READ_FIELD_NUMBER = 10;
    
    public static final int MSG_ID_FIELD_NUMBER = 4;
    
    public static final int MSG_TYPE_FIELD_NUMBER = 3;
    
    private static final Parser<Receive> PARSER = (Parser<Receive>)new AbstractParser<Receive>() {
        public PrivateChatOuterClass.Receive parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PrivateChatOuterClass.Receive(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int PHONE_SESSION_ID_FIELD_NUMBER = 13;
    
    public static final int SESSION_STATUS_FIELD_NUMBER = 8;
    
    public static final int SESSION_TYPE_FIELD_NUMBER = 12;
    
    public static final int TIMESTAMP_FIELD_NUMBER = 5;
    
    public static final int TO_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private PushBodyOuterClass.PushBody body_;
    
    private int coordsMemoizedSerializedSize = -1;
    
    private Internal.DoubleList coords_;
    
    private volatile Object distance_;
    
    private int from_;
    
    private boolean isDeleted_;
    
    private boolean isRead_;
    
    private byte memoizedIsInitialized = -1;
    
    private long msgId_;
    
    private int msgType_;
    
    private int phoneSessionId_;
    
    private int sessionStatus_;
    
    private int sessionType_;
    
    private long timestamp_;
    
    private int to_;
    
    private Receive() {
      this.msgType_ = 0;
      this.distance_ = "";
      this.coords_ = emptyDoubleList();
    }
    
    private Receive(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            int i1;
            PushBodyOuterClass.PushBody.Builder builder1;
            int n = param1CodedInputStream.readTag();
            switch (n) {
              case 104:
                j = i;
                k = i;
                m = i;
                this.phoneSessionId_ = param1CodedInputStream.readUInt32();
                continue;
              case 96:
                j = i;
                k = i;
                m = i;
                this.sessionType_ = param1CodedInputStream.readUInt32();
                continue;
              case 90:
                builder1 = null;
                j = i;
                k = i;
                m = i;
                if (this.body_ != null) {
                  j = i;
                  k = i;
                  m = i;
                  builder1 = this.body_.toBuilder();
                } 
                j = i;
                k = i;
                m = i;
                this.body_ = (PushBodyOuterClass.PushBody)param1CodedInputStream.readMessage(PushBodyOuterClass.PushBody.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  j = i;
                  k = i;
                  m = i;
                  builder1.mergeFrom(this.body_);
                  j = i;
                  k = i;
                  m = i;
                  this.body_ = builder1.buildPartial();
                } 
                continue;
              case 80:
                j = i;
                k = i;
                m = i;
                this.isRead_ = param1CodedInputStream.readBool();
                continue;
              case 72:
                j = i;
                k = i;
                m = i;
                this.isDeleted_ = param1CodedInputStream.readBool();
                continue;
              case 64:
                j = i;
                k = i;
                m = i;
                this.sessionStatus_ = param1CodedInputStream.readInt32();
                continue;
              case 58:
                j = i;
                k = i;
                m = i;
                i1 = param1CodedInputStream.pushLimit(param1CodedInputStream.readRawVarint32());
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
                    this.coords_ = newDoubleList();
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
                    this.coords_.addDouble(param1CodedInputStream.readDouble());
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
              case 57:
                n = i;
                if ((i & 0x1) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.coords_ = newDoubleList();
                  n = i | 0x1;
                } 
                j = n;
                k = n;
                m = n;
                this.coords_.addDouble(param1CodedInputStream.readDouble());
                i = n;
                continue;
              case 50:
                j = i;
                k = i;
                m = i;
                this.distance_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 40:
                j = i;
                k = i;
                m = i;
                this.timestamp_ = param1CodedInputStream.readInt64();
                continue;
              case 32:
                j = i;
                k = i;
                m = i;
                this.msgId_ = param1CodedInputStream.readInt64();
                continue;
              case 24:
                j = i;
                k = i;
                m = i;
                this.msgType_ = param1CodedInputStream.readEnum();
                continue;
              case 16:
                j = i;
                k = i;
                m = i;
                this.to_ = param1CodedInputStream.readUInt32();
                continue;
              case 8:
                j = i;
                k = i;
                m = i;
                this.from_ = param1CodedInputStream.readUInt32();
                continue;
              case 0:
                bool = true;
                continue;
            } 
            j = i;
            k = i;
            m = i;
            boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, n);
            if (!bool1);
            continue;
          } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            j = m;
            throw invalidProtocolBufferException.setUnfinishedMessage(this);
          } catch (IOException iOException) {
            j = k;
            throw (new InvalidProtocolBufferException(iOException)).setUnfinishedMessage(this);
          } finally {}
          if ((j & 0x1) != 0)
            this.coords_.makeImmutable(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
        } 
        if ((i & 0x1) != 0)
          this.coords_.makeImmutable(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private Receive(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Receive getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Receive param1Receive) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Receive);
    }
    
    public static Receive parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Receive)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Receive parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Receive)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Receive parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ByteString);
    }
    
    public static Receive parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Receive parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Receive)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Receive parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Receive)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Receive parseFrom(InputStream param1InputStream) throws IOException {
      return (Receive)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Receive parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Receive)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Receive parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Receive parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Receive parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Receive parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Receive)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Receive> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Receive))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (getFrom() != param1Object.getFrom()) ? false : ((getTo() != param1Object.getTo()) ? false : ((this.msgType_ != ((Receive)param1Object).msgType_) ? false : ((getMsgId() != param1Object.getMsgId()) ? false : ((getTimestamp() != param1Object.getTimestamp()) ? false : (!getDistance().equals(param1Object.getDistance()) ? false : (!getCoordsList().equals(param1Object.getCoordsList()) ? false : ((getSessionStatus() != param1Object.getSessionStatus()) ? false : ((getIsDeleted() != param1Object.getIsDeleted()) ? false : ((getIsRead() != param1Object.getIsRead()) ? false : ((hasBody() != param1Object.hasBody()) ? false : ((hasBody() && !getBody().equals(param1Object.getBody())) ? false : ((getSessionType() != param1Object.getSessionType()) ? false : ((getPhoneSessionId() != param1Object.getPhoneSessionId()) ? false : (!!this.unknownFields.equals(((Receive)param1Object).unknownFields)))))))))))))));
    }
    
    public PushBodyOuterClass.PushBody getBody() {
      PushBodyOuterClass.PushBody pushBody2 = this.body_;
      PushBodyOuterClass.PushBody pushBody1 = pushBody2;
      if (pushBody2 == null)
        pushBody1 = PushBodyOuterClass.PushBody.getDefaultInstance(); 
      return pushBody1;
    }
    
    public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
      return getBody();
    }
    
    public double getCoords(int param1Int) {
      return this.coords_.getDouble(param1Int);
    }
    
    public int getCoordsCount() {
      return this.coords_.size();
    }
    
    public List<Double> getCoordsList() {
      return (List<Double>)this.coords_;
    }
    
    public Receive getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public String getDistance() {
      Object object = this.distance_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.distance_ = object;
      return (String)object;
    }
    
    public ByteString getDistanceBytes() {
      Object object = this.distance_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.distance_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsDeleted() {
      return this.isDeleted_;
    }
    
    public boolean getIsRead() {
      return this.isRead_;
    }
    
    public long getMsgId() {
      return this.msgId_;
    }
    
    public MsgTypeOuterClass.MsgType getMsgType() {
      MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
      MsgTypeOuterClass.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public Parser<Receive> getParserForType() {
      return PARSER;
    }
    
    public int getPhoneSessionId() {
      return this.phoneSessionId_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.from_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeUInt32Size(1, j); 
      int k = this.to_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeUInt32Size(2, k); 
      i = j;
      if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        i = j + CodedOutputStream.computeEnumSize(3, this.msgType_); 
      long l = this.msgId_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(4, l); 
      l = this.timestamp_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(5, l); 
      j = i;
      if (!getDistanceBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(6, this.distance_); 
      k = getCoordsList().size() * 8;
      j += k;
      i = j;
      if (!getCoordsList().isEmpty())
        i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k); 
      this.coordsMemoizedSerializedSize = k;
      k = this.sessionStatus_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(8, k); 
      boolean bool = this.isDeleted_;
      i = j;
      if (bool)
        i = j + CodedOutputStream.computeBoolSize(9, bool); 
      bool = this.isRead_;
      k = i;
      if (bool)
        k = i + CodedOutputStream.computeBoolSize(10, bool); 
      j = k;
      if (this.body_ != null)
        j = k + CodedOutputStream.computeMessageSize(11, (MessageLite)getBody()); 
      k = this.sessionType_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(12, k); 
      k = this.phoneSessionId_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeUInt32Size(13, k); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public int getSessionStatus() {
      return this.sessionStatus_;
    }
    
    public int getSessionType() {
      return this.sessionType_;
    }
    
    public long getTimestamp() {
      return this.timestamp_;
    }
    
    public int getTo() {
      return this.to_;
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
      int j = ((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getFrom()) * 37 + 2) * 53 + getTo()) * 37 + 3) * 53 + this.msgType_) * 37 + 4) * 53 + Internal.hashLong(getMsgId())) * 37 + 5) * 53 + Internal.hashLong(getTimestamp())) * 37 + 6) * 53 + getDistance().hashCode();
      int i = j;
      if (getCoordsCount() > 0)
        i = (j * 37 + 7) * 53 + getCoordsList().hashCode(); 
      j = (((((i * 37 + 8) * 53 + getSessionStatus()) * 37 + 9) * 53 + Internal.hashBoolean(getIsDeleted())) * 37 + 10) * 53 + Internal.hashBoolean(getIsRead());
      i = j;
      if (hasBody())
        i = (j * 37 + 11) * 53 + getBody().hashCode(); 
      i = ((((i * 37 + 12) * 53 + getSessionType()) * 37 + 13) * 53 + getPhoneSessionId()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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
      return new Receive();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      getSerializedSize();
      int i = this.from_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(1, i); 
      i = this.to_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(2, i); 
      if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.msgType_); 
      long l = this.msgId_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      l = this.timestamp_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      if (!getDistanceBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 6, this.distance_); 
      if (getCoordsList().size() > 0) {
        param1CodedOutputStream.writeUInt32NoTag(58);
        param1CodedOutputStream.writeUInt32NoTag(this.coordsMemoizedSerializedSize);
      } 
      for (i = 0; i < this.coords_.size(); i++)
        param1CodedOutputStream.writeDoubleNoTag(this.coords_.getDouble(i)); 
      i = this.sessionStatus_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(8, i); 
      boolean bool = this.isDeleted_;
      if (bool)
        param1CodedOutputStream.writeBool(9, bool); 
      bool = this.isRead_;
      if (bool)
        param1CodedOutputStream.writeBool(10, bool); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(11, (MessageLite)getBody()); 
      i = this.sessionType_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(12, i); 
      i = this.phoneSessionId_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(13, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PrivateChatOuterClass.ReceiveOrBuilder {
      private int bitField0_;
      
      private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> bodyBuilder_;
      
      private PushBodyOuterClass.PushBody body_;
      
      private Internal.DoubleList coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
      
      private Object distance_ = "";
      
      private int from_;
      
      private boolean isDeleted_;
      
      private boolean isRead_;
      
      private long msgId_;
      
      private int msgType_ = 0;
      
      private int phoneSessionId_;
      
      private int sessionStatus_;
      
      private int sessionType_;
      
      private long timestamp_;
      
      private int to_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureCoordsIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.coords_ = PrivateChatOuterClass.Receive.mutableCopy(this.coords_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> getBodyFieldBuilder() {
        if (this.bodyBuilder_ == null) {
          this.bodyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBody(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.body_ = null;
        } 
        return this.bodyBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PrivateChatOuterClass.Receive.alwaysUseFieldBuilders;
      }
      
      public Builder addAllCoords(Iterable<? extends Double> param2Iterable) {
        ensureCoordsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.coords_);
        onChanged();
        return this;
      }
      
      public Builder addCoords(double param2Double) {
        ensureCoordsIsMutable();
        this.coords_.addDouble(param2Double);
        onChanged();
        return this;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PrivateChatOuterClass.Receive build() {
        PrivateChatOuterClass.Receive receive = buildPartial();
        if (receive.isInitialized())
          return receive; 
        throw newUninitializedMessageException(receive);
      }
      
      public PrivateChatOuterClass.Receive buildPartial() {
        PrivateChatOuterClass.Receive receive = new PrivateChatOuterClass.Receive(this);
        int i = this.bitField0_;
        PrivateChatOuterClass.Receive.access$4102(receive, this.from_);
        PrivateChatOuterClass.Receive.access$4202(receive, this.to_);
        PrivateChatOuterClass.Receive.access$4302(receive, this.msgType_);
        PrivateChatOuterClass.Receive.access$4402(receive, this.msgId_);
        PrivateChatOuterClass.Receive.access$4502(receive, this.timestamp_);
        PrivateChatOuterClass.Receive.access$4602(receive, this.distance_);
        if ((this.bitField0_ & 0x1) != 0) {
          this.coords_.makeImmutable();
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        PrivateChatOuterClass.Receive.access$4702(receive, this.coords_);
        PrivateChatOuterClass.Receive.access$4802(receive, this.sessionStatus_);
        PrivateChatOuterClass.Receive.access$4902(receive, this.isDeleted_);
        PrivateChatOuterClass.Receive.access$5002(receive, this.isRead_);
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          PrivateChatOuterClass.Receive.access$5102(receive, this.body_);
        } else {
          PrivateChatOuterClass.Receive.access$5102(receive, (PushBodyOuterClass.PushBody)singleFieldBuilderV3.build());
        } 
        PrivateChatOuterClass.Receive.access$5202(receive, this.sessionType_);
        PrivateChatOuterClass.Receive.access$5302(receive, this.phoneSessionId_);
        onBuilt();
        return receive;
      }
      
      public Builder clear() {
        super.clear();
        this.from_ = 0;
        this.to_ = 0;
        this.msgType_ = 0;
        this.msgId_ = 0L;
        this.timestamp_ = 0L;
        this.distance_ = "";
        this.coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        this.sessionStatus_ = 0;
        this.isDeleted_ = false;
        this.isRead_ = false;
        if (this.bodyBuilder_ == null) {
          this.body_ = null;
        } else {
          this.body_ = null;
          this.bodyBuilder_ = null;
        } 
        this.sessionType_ = 0;
        this.phoneSessionId_ = 0;
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
      
      public Builder clearCoords() {
        this.coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      }
      
      public Builder clearDistance() {
        this.distance_ = PrivateChatOuterClass.Receive.getDefaultInstance().getDistance();
        onChanged();
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
      
      public Builder clearIsDeleted() {
        this.isDeleted_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearIsRead() {
        this.isRead_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearMsgId() {
        this.msgId_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearMsgType() {
        this.msgType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearPhoneSessionId() {
        this.phoneSessionId_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSessionStatus() {
        this.sessionStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSessionType() {
        this.sessionType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearTimestamp() {
        this.timestamp_ = 0L;
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
      
      public PushBodyOuterClass.PushBody getBody() {
        PushBodyOuterClass.PushBody pushBody;
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          PushBodyOuterClass.PushBody pushBody1 = this.body_;
          pushBody = pushBody1;
          if (pushBody1 == null)
            pushBody = PushBodyOuterClass.PushBody.getDefaultInstance(); 
          return pushBody;
        } 
        return (PushBodyOuterClass.PushBody)pushBody.getMessage();
      }
      
      public PushBodyOuterClass.PushBody.Builder getBodyBuilder() {
        onChanged();
        return (PushBodyOuterClass.PushBody.Builder)getBodyFieldBuilder().getBuilder();
      }
      
      public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 != null)
          return (PushBodyOuterClass.PushBodyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        PushBodyOuterClass.PushBody pushBody2 = this.body_;
        PushBodyOuterClass.PushBody pushBody1 = pushBody2;
        if (pushBody2 == null)
          pushBody1 = PushBodyOuterClass.PushBody.getDefaultInstance(); 
        return pushBody1;
      }
      
      public double getCoords(int param2Int) {
        return this.coords_.getDouble(param2Int);
      }
      
      public int getCoordsCount() {
        return this.coords_.size();
      }
      
      public List<Double> getCoordsList() {
        return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.coords_) : this.coords_);
      }
      
      public PrivateChatOuterClass.Receive getDefaultInstanceForType() {
        return PrivateChatOuterClass.Receive.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
      }
      
      public String getDistance() {
        Object object = this.distance_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.distance_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getDistanceBytes() {
        Object object = this.distance_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.distance_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getFrom() {
        return this.from_;
      }
      
      public boolean getIsDeleted() {
        return this.isDeleted_;
      }
      
      public boolean getIsRead() {
        return this.isRead_;
      }
      
      public long getMsgId() {
        return this.msgId_;
      }
      
      public MsgTypeOuterClass.MsgType getMsgType() {
        MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
        MsgTypeOuterClass.MsgType msgType1 = msgType2;
        if (msgType2 == null)
          msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
        return msgType1;
      }
      
      public int getMsgTypeValue() {
        return this.msgType_;
      }
      
      public int getPhoneSessionId() {
        return this.phoneSessionId_;
      }
      
      public int getSessionStatus() {
        return this.sessionStatus_;
      }
      
      public int getSessionType() {
        return this.sessionType_;
      }
      
      public long getTimestamp() {
        return this.timestamp_;
      }
      
      public int getTo() {
        return this.to_;
      }
      
      public boolean hasBody() {
        return (this.bodyBuilder_ != null || this.body_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Receive.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeBody(PushBodyOuterClass.PushBody param2PushBody) {
        PushBodyOuterClass.PushBody pushBody;
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          pushBody = this.body_;
          if (pushBody != null) {
            this.body_ = PushBodyOuterClass.PushBody.newBuilder(pushBody).mergeFrom(param2PushBody).buildPartial();
          } else {
            this.body_ = param2PushBody;
          } 
          onChanged();
          return this;
        } 
        pushBody.mergeFrom((AbstractMessage)param2PushBody);
        return this;
      }
      
      public Builder mergeFrom(PrivateChatOuterClass.Receive param2Receive) {
        if (param2Receive == PrivateChatOuterClass.Receive.getDefaultInstance())
          return this; 
        if (param2Receive.getFrom() != 0)
          setFrom(param2Receive.getFrom()); 
        if (param2Receive.getTo() != 0)
          setTo(param2Receive.getTo()); 
        if (param2Receive.msgType_ != 0)
          setMsgTypeValue(param2Receive.getMsgTypeValue()); 
        if (param2Receive.getMsgId() != 0L)
          setMsgId(param2Receive.getMsgId()); 
        if (param2Receive.getTimestamp() != 0L)
          setTimestamp(param2Receive.getTimestamp()); 
        if (!param2Receive.getDistance().isEmpty()) {
          this.distance_ = param2Receive.distance_;
          onChanged();
        } 
        if (!param2Receive.coords_.isEmpty()) {
          if (this.coords_.isEmpty()) {
            this.coords_ = param2Receive.coords_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureCoordsIsMutable();
            this.coords_.addAll((Collection)param2Receive.coords_);
          } 
          onChanged();
        } 
        if (param2Receive.getSessionStatus() != 0)
          setSessionStatus(param2Receive.getSessionStatus()); 
        if (param2Receive.getIsDeleted())
          setIsDeleted(param2Receive.getIsDeleted()); 
        if (param2Receive.getIsRead())
          setIsRead(param2Receive.getIsRead()); 
        if (param2Receive.hasBody())
          mergeBody(param2Receive.getBody()); 
        if (param2Receive.getSessionType() != 0)
          setSessionType(param2Receive.getSessionType()); 
        if (param2Receive.getPhoneSessionId() != 0)
          setPhoneSessionId(param2Receive.getPhoneSessionId()); 
        mergeUnknownFields(param2Receive.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PrivateChatOuterClass.Receive receive = (PrivateChatOuterClass.Receive)PrivateChatOuterClass.Receive.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PrivateChatOuterClass.Receive receive = (PrivateChatOuterClass.Receive)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PrivateChatOuterClass.Receive)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PrivateChatOuterClass.Receive)
          return mergeFrom((PrivateChatOuterClass.Receive)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setBody(PushBodyOuterClass.PushBody.Builder param2Builder) {
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.body_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setBody(PushBodyOuterClass.PushBody param2PushBody) {
        SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2PushBody != null) {
            this.body_ = param2PushBody;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2PushBody);
        return this;
      }
      
      public Builder setCoords(int param2Int, double param2Double) {
        ensureCoordsIsMutable();
        this.coords_.setDouble(param2Int, param2Double);
        onChanged();
        return this;
      }
      
      public Builder setDistance(String param2String) {
        if (param2String != null) {
          this.distance_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setDistanceBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PrivateChatOuterClass.Receive.checkByteStringIsUtf8(param2ByteString);
          this.distance_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFrom(int param2Int) {
        this.from_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsDeleted(boolean param2Boolean) {
        this.isDeleted_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setIsRead(boolean param2Boolean) {
        this.isRead_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setMsgId(long param2Long) {
        this.msgId_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setMsgType(MsgTypeOuterClass.MsgType param2MsgType) {
        if (param2MsgType != null) {
          this.msgType_ = param2MsgType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMsgTypeValue(int param2Int) {
        this.msgType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setPhoneSessionId(int param2Int) {
        this.phoneSessionId_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSessionStatus(int param2Int) {
        this.sessionStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSessionType(int param2Int) {
        this.sessionType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setTimestamp(long param2Long) {
        this.timestamp_ = param2Long;
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
  
  static final class null extends AbstractParser<Receive> {
    public PrivateChatOuterClass.Receive parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PrivateChatOuterClass.Receive(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Receive.Builder> implements ReceiveOrBuilder {
    private int bitField0_;
    
    private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> bodyBuilder_;
    
    private PushBodyOuterClass.PushBody body_;
    
    private Internal.DoubleList coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
    
    private Object distance_ = "";
    
    private int from_;
    
    private boolean isDeleted_;
    
    private boolean isRead_;
    
    private long msgId_;
    
    private int msgType_ = 0;
    
    private int phoneSessionId_;
    
    private int sessionStatus_;
    
    private int sessionType_;
    
    private long timestamp_;
    
    private int to_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureCoordsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.coords_ = PrivateChatOuterClass.Receive.mutableCopy(this.coords_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> getBodyFieldBuilder() {
      if (this.bodyBuilder_ == null) {
        this.bodyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getBody(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.body_ = null;
      } 
      return this.bodyBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PrivateChatOuterClass.Receive.alwaysUseFieldBuilders;
    }
    
    public Builder addAllCoords(Iterable<? extends Double> param1Iterable) {
      ensureCoordsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.coords_);
      onChanged();
      return this;
    }
    
    public Builder addCoords(double param1Double) {
      ensureCoordsIsMutable();
      this.coords_.addDouble(param1Double);
      onChanged();
      return this;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PrivateChatOuterClass.Receive build() {
      PrivateChatOuterClass.Receive receive = buildPartial();
      if (receive.isInitialized())
        return receive; 
      throw newUninitializedMessageException(receive);
    }
    
    public PrivateChatOuterClass.Receive buildPartial() {
      PrivateChatOuterClass.Receive receive = new PrivateChatOuterClass.Receive(this);
      int i = this.bitField0_;
      PrivateChatOuterClass.Receive.access$4102(receive, this.from_);
      PrivateChatOuterClass.Receive.access$4202(receive, this.to_);
      PrivateChatOuterClass.Receive.access$4302(receive, this.msgType_);
      PrivateChatOuterClass.Receive.access$4402(receive, this.msgId_);
      PrivateChatOuterClass.Receive.access$4502(receive, this.timestamp_);
      PrivateChatOuterClass.Receive.access$4602(receive, this.distance_);
      if ((this.bitField0_ & 0x1) != 0) {
        this.coords_.makeImmutable();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      PrivateChatOuterClass.Receive.access$4702(receive, this.coords_);
      PrivateChatOuterClass.Receive.access$4802(receive, this.sessionStatus_);
      PrivateChatOuterClass.Receive.access$4902(receive, this.isDeleted_);
      PrivateChatOuterClass.Receive.access$5002(receive, this.isRead_);
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        PrivateChatOuterClass.Receive.access$5102(receive, this.body_);
      } else {
        PrivateChatOuterClass.Receive.access$5102(receive, (PushBodyOuterClass.PushBody)singleFieldBuilderV3.build());
      } 
      PrivateChatOuterClass.Receive.access$5202(receive, this.sessionType_);
      PrivateChatOuterClass.Receive.access$5302(receive, this.phoneSessionId_);
      onBuilt();
      return receive;
    }
    
    public Builder clear() {
      super.clear();
      this.from_ = 0;
      this.to_ = 0;
      this.msgType_ = 0;
      this.msgId_ = 0L;
      this.timestamp_ = 0L;
      this.distance_ = "";
      this.coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      this.sessionStatus_ = 0;
      this.isDeleted_ = false;
      this.isRead_ = false;
      if (this.bodyBuilder_ == null) {
        this.body_ = null;
      } else {
        this.body_ = null;
        this.bodyBuilder_ = null;
      } 
      this.sessionType_ = 0;
      this.phoneSessionId_ = 0;
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
    
    public Builder clearCoords() {
      this.coords_ = PrivateChatOuterClass.Receive.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    public Builder clearDistance() {
      this.distance_ = PrivateChatOuterClass.Receive.getDefaultInstance().getDistance();
      onChanged();
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
    
    public Builder clearIsDeleted() {
      this.isDeleted_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearIsRead() {
      this.isRead_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearMsgId() {
      this.msgId_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearMsgType() {
      this.msgType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearPhoneSessionId() {
      this.phoneSessionId_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSessionStatus() {
      this.sessionStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSessionType() {
      this.sessionType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearTimestamp() {
      this.timestamp_ = 0L;
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
    
    public PushBodyOuterClass.PushBody getBody() {
      PushBodyOuterClass.PushBody pushBody;
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        PushBodyOuterClass.PushBody pushBody1 = this.body_;
        pushBody = pushBody1;
        if (pushBody1 == null)
          pushBody = PushBodyOuterClass.PushBody.getDefaultInstance(); 
        return pushBody;
      } 
      return (PushBodyOuterClass.PushBody)pushBody.getMessage();
    }
    
    public PushBodyOuterClass.PushBody.Builder getBodyBuilder() {
      onChanged();
      return (PushBodyOuterClass.PushBody.Builder)getBodyFieldBuilder().getBuilder();
    }
    
    public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 != null)
        return (PushBodyOuterClass.PushBodyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      PushBodyOuterClass.PushBody pushBody2 = this.body_;
      PushBodyOuterClass.PushBody pushBody1 = pushBody2;
      if (pushBody2 == null)
        pushBody1 = PushBodyOuterClass.PushBody.getDefaultInstance(); 
      return pushBody1;
    }
    
    public double getCoords(int param1Int) {
      return this.coords_.getDouble(param1Int);
    }
    
    public int getCoordsCount() {
      return this.coords_.size();
    }
    
    public List<Double> getCoordsList() {
      return (List<Double>)(((this.bitField0_ & 0x1) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.coords_) : this.coords_);
    }
    
    public PrivateChatOuterClass.Receive getDefaultInstanceForType() {
      return PrivateChatOuterClass.Receive.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
    }
    
    public String getDistance() {
      Object object = this.distance_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.distance_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDistanceBytes() {
      Object object = this.distance_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.distance_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public boolean getIsDeleted() {
      return this.isDeleted_;
    }
    
    public boolean getIsRead() {
      return this.isRead_;
    }
    
    public long getMsgId() {
      return this.msgId_;
    }
    
    public MsgTypeOuterClass.MsgType getMsgType() {
      MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
      MsgTypeOuterClass.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public int getPhoneSessionId() {
      return this.phoneSessionId_;
    }
    
    public int getSessionStatus() {
      return this.sessionStatus_;
    }
    
    public int getSessionType() {
      return this.sessionType_;
    }
    
    public long getTimestamp() {
      return this.timestamp_;
    }
    
    public int getTo() {
      return this.to_;
    }
    
    public boolean hasBody() {
      return (this.bodyBuilder_ != null || this.body_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Receive.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeBody(PushBodyOuterClass.PushBody param1PushBody) {
      PushBodyOuterClass.PushBody pushBody;
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        pushBody = this.body_;
        if (pushBody != null) {
          this.body_ = PushBodyOuterClass.PushBody.newBuilder(pushBody).mergeFrom(param1PushBody).buildPartial();
        } else {
          this.body_ = param1PushBody;
        } 
        onChanged();
        return this;
      } 
      pushBody.mergeFrom((AbstractMessage)param1PushBody);
      return this;
    }
    
    public Builder mergeFrom(PrivateChatOuterClass.Receive param1Receive) {
      if (param1Receive == PrivateChatOuterClass.Receive.getDefaultInstance())
        return this; 
      if (param1Receive.getFrom() != 0)
        setFrom(param1Receive.getFrom()); 
      if (param1Receive.getTo() != 0)
        setTo(param1Receive.getTo()); 
      if (param1Receive.msgType_ != 0)
        setMsgTypeValue(param1Receive.getMsgTypeValue()); 
      if (param1Receive.getMsgId() != 0L)
        setMsgId(param1Receive.getMsgId()); 
      if (param1Receive.getTimestamp() != 0L)
        setTimestamp(param1Receive.getTimestamp()); 
      if (!param1Receive.getDistance().isEmpty()) {
        this.distance_ = param1Receive.distance_;
        onChanged();
      } 
      if (!param1Receive.coords_.isEmpty()) {
        if (this.coords_.isEmpty()) {
          this.coords_ = param1Receive.coords_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureCoordsIsMutable();
          this.coords_.addAll((Collection)param1Receive.coords_);
        } 
        onChanged();
      } 
      if (param1Receive.getSessionStatus() != 0)
        setSessionStatus(param1Receive.getSessionStatus()); 
      if (param1Receive.getIsDeleted())
        setIsDeleted(param1Receive.getIsDeleted()); 
      if (param1Receive.getIsRead())
        setIsRead(param1Receive.getIsRead()); 
      if (param1Receive.hasBody())
        mergeBody(param1Receive.getBody()); 
      if (param1Receive.getSessionType() != 0)
        setSessionType(param1Receive.getSessionType()); 
      if (param1Receive.getPhoneSessionId() != 0)
        setPhoneSessionId(param1Receive.getPhoneSessionId()); 
      mergeUnknownFields(param1Receive.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PrivateChatOuterClass.Receive receive = (PrivateChatOuterClass.Receive)PrivateChatOuterClass.Receive.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PrivateChatOuterClass.Receive receive = (PrivateChatOuterClass.Receive)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PrivateChatOuterClass.Receive)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PrivateChatOuterClass.Receive)
        return mergeFrom((PrivateChatOuterClass.Receive)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setBody(PushBodyOuterClass.PushBody.Builder param1Builder) {
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.body_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setBody(PushBodyOuterClass.PushBody param1PushBody) {
      SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1PushBody != null) {
          this.body_ = param1PushBody;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1PushBody);
      return this;
    }
    
    public Builder setCoords(int param1Int, double param1Double) {
      ensureCoordsIsMutable();
      this.coords_.setDouble(param1Int, param1Double);
      onChanged();
      return this;
    }
    
    public Builder setDistance(String param1String) {
      if (param1String != null) {
        this.distance_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDistanceBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PrivateChatOuterClass.Receive.checkByteStringIsUtf8(param1ByteString);
        this.distance_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFrom(int param1Int) {
      this.from_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsDeleted(boolean param1Boolean) {
      this.isDeleted_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setIsRead(boolean param1Boolean) {
      this.isRead_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setMsgId(long param1Long) {
      this.msgId_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setMsgType(MsgTypeOuterClass.MsgType param1MsgType) {
      if (param1MsgType != null) {
        this.msgType_ = param1MsgType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMsgTypeValue(int param1Int) {
      this.msgType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setPhoneSessionId(int param1Int) {
      this.phoneSessionId_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSessionStatus(int param1Int) {
      this.sessionStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSessionType(int param1Int) {
      this.sessionType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setTimestamp(long param1Long) {
      this.timestamp_ = param1Long;
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
  
  public static interface ReceiveOrBuilder extends MessageOrBuilder {
    PushBodyOuterClass.PushBody getBody();
    
    PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder();
    
    double getCoords(int param1Int);
    
    int getCoordsCount();
    
    List<Double> getCoordsList();
    
    String getDistance();
    
    ByteString getDistanceBytes();
    
    int getFrom();
    
    boolean getIsDeleted();
    
    boolean getIsRead();
    
    long getMsgId();
    
    MsgTypeOuterClass.MsgType getMsgType();
    
    int getMsgTypeValue();
    
    int getPhoneSessionId();
    
    int getSessionStatus();
    
    int getSessionType();
    
    long getTimestamp();
    
    int getTo();
    
    boolean hasBody();
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int BODY_FIELD_NUMBER = 5;
    
    public static final int COMMON_FIELD_NUMBER = 1;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int FROM_FIELD_NUMBER = 6;
    
    public static final int LOCAL_ID_FIELD_NUMBER = 4;
    
    public static final int MSG_TYPE_FIELD_NUMBER = 3;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public PrivateChatOuterClass.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PrivateChatOuterClass.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SESSION_TYPE_FIELD_NUMBER = 7;
    
    public static final int TO_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private Any body_;
    
    private CommonOuterClass.Common common_;
    
    private int from_;
    
    private int localId_;
    
    private byte memoizedIsInitialized = -1;
    
    private int msgType_;
    
    private int sessionType_;
    
    private int to_;
    
    private Request() {
      this.msgType_ = 0;
    }
    
    private Request(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        for (boolean bool = false; !bool; bool = true) {
          try {
            int i = param1CodedInputStream.readTag();
            if (i != 0) {
              CommonOuterClass.Common.Builder builder1;
              Any.Builder builder3 = null;
              Any.Builder builder2 = null;
              if (i != 10) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 32) {
                      if (i != 42) {
                        if (i != 48) {
                          if (i != 56) {
                            if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                              continue; 
                            continue;
                          } 
                          this.sessionType_ = param1CodedInputStream.readUInt32();
                          continue;
                        } 
                        this.from_ = param1CodedInputStream.readUInt32();
                        continue;
                      } 
                      if (this.body_ != null)
                        builder2 = this.body_.toBuilder(); 
                      this.body_ = (Any)param1CodedInputStream.readMessage(Any.parser(), param1ExtensionRegistryLite);
                      if (builder2 != null) {
                        builder2.mergeFrom(this.body_);
                        this.body_ = builder2.buildPartial();
                      } 
                      continue;
                    } 
                    this.localId_ = param1CodedInputStream.readInt32();
                    continue;
                  } 
                  this.msgType_ = param1CodedInputStream.readEnum();
                  continue;
                } 
                this.to_ = param1CodedInputStream.readUInt32();
                continue;
              } 
              builder2 = builder3;
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
    
    private Request(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Request param1Request) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Request);
    }
    
    public static Request parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Request parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteString);
    }
    
    public static Request parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Request parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(InputStream param1InputStream) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Request parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Request)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Request parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Request parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Request parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Request)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Request> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Request))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getTo() != param1Object.getTo()) ? false : ((this.msgType_ != ((Request)param1Object).msgType_) ? false : ((getLocalId() != param1Object.getLocalId()) ? false : ((hasBody() != param1Object.hasBody()) ? false : ((hasBody() && !getBody().equals(param1Object.getBody())) ? false : ((getFrom() != param1Object.getFrom()) ? false : ((getSessionType() != param1Object.getSessionType()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields))))))))));
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
    
    public Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public int getLocalId() {
      return this.localId_;
    }
    
    public MsgTypeOuterClass.MsgType getMsgType() {
      MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
      MsgTypeOuterClass.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.common_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getCommon()); 
      int k = this.to_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(2, k); 
      j = i;
      if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.msgType_); 
      k = this.localId_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(4, k); 
      j = i;
      if (this.body_ != null)
        j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)getBody()); 
      k = this.from_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeUInt32Size(6, k); 
      k = this.sessionType_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeUInt32Size(7, k); 
      i = j + this.unknownFields.getSerializedSize();
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
    
    public boolean hasBody() {
      return (this.body_ != null);
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
      j = (((((i * 37 + 2) * 53 + getTo()) * 37 + 3) * 53 + this.msgType_) * 37 + 4) * 53 + getLocalId();
      i = j;
      if (hasBody())
        i = (j * 37 + 5) * 53 + getBody().hashCode(); 
      i = ((((i * 37 + 6) * 53 + getFrom()) * 37 + 7) * 53 + getSessionType()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      return new Request();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.common_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getCommon()); 
      int i = this.to_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(2, i); 
      if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.msgType_); 
      i = this.localId_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(4, i); 
      if (this.body_ != null)
        param1CodedOutputStream.writeMessage(5, (MessageLite)getBody()); 
      i = this.from_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(6, i); 
      i = this.sessionType_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(7, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PrivateChatOuterClass.RequestOrBuilder {
      private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
      
      private Any body_;
      
      private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
      
      private CommonOuterClass.Common common_;
      
      private int from_;
      
      private int localId_;
      
      private int msgType_ = 0;
      
      private int sessionType_;
      
      private int to_;
      
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
      
      private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
        if (this.commonBuilder_ == null) {
          this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.common_ = null;
        } 
        return this.commonBuilder_;
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PrivateChatOuterClass.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PrivateChatOuterClass.Request build() {
        PrivateChatOuterClass.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public PrivateChatOuterClass.Request buildPartial() {
        PrivateChatOuterClass.Request request = new PrivateChatOuterClass.Request(this);
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV31 = this.commonBuilder_;
        if (singleFieldBuilderV31 == null) {
          PrivateChatOuterClass.Request.access$602(request, this.common_);
        } else {
          PrivateChatOuterClass.Request.access$602(request, (CommonOuterClass.Common)singleFieldBuilderV31.build());
        } 
        PrivateChatOuterClass.Request.access$702(request, this.to_);
        PrivateChatOuterClass.Request.access$802(request, this.msgType_);
        PrivateChatOuterClass.Request.access$902(request, this.localId_);
        SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
        if (singleFieldBuilderV3 == null) {
          PrivateChatOuterClass.Request.access$1002(request, this.body_);
        } else {
          PrivateChatOuterClass.Request.access$1002(request, (Any)singleFieldBuilderV3.build());
        } 
        PrivateChatOuterClass.Request.access$1102(request, this.from_);
        PrivateChatOuterClass.Request.access$1202(request, this.sessionType_);
        onBuilt();
        return request;
      }
      
      public Builder clear() {
        super.clear();
        if (this.commonBuilder_ == null) {
          this.common_ = null;
        } else {
          this.common_ = null;
          this.commonBuilder_ = null;
        } 
        this.to_ = 0;
        this.msgType_ = 0;
        this.localId_ = 0;
        if (this.bodyBuilder_ == null) {
          this.body_ = null;
        } else {
          this.body_ = null;
          this.bodyBuilder_ = null;
        } 
        this.from_ = 0;
        this.sessionType_ = 0;
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
      
      public Builder clearLocalId() {
        this.localId_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearMsgType() {
        this.msgType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
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
      
      public PrivateChatOuterClass.Request getDefaultInstanceForType() {
        return PrivateChatOuterClass.Request.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
      }
      
      public int getFrom() {
        return this.from_;
      }
      
      public int getLocalId() {
        return this.localId_;
      }
      
      public MsgTypeOuterClass.MsgType getMsgType() {
        MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
        MsgTypeOuterClass.MsgType msgType1 = msgType2;
        if (msgType2 == null)
          msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
        return msgType1;
      }
      
      public int getMsgTypeValue() {
        return this.msgType_;
      }
      
      public int getSessionType() {
        return this.sessionType_;
      }
      
      public int getTo() {
        return this.to_;
      }
      
      public boolean hasBody() {
        return (this.bodyBuilder_ != null || this.body_ != null);
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Request.class, Builder.class);
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
      
      public Builder mergeFrom(PrivateChatOuterClass.Request param2Request) {
        if (param2Request == PrivateChatOuterClass.Request.getDefaultInstance())
          return this; 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (param2Request.getTo() != 0)
          setTo(param2Request.getTo()); 
        if (param2Request.msgType_ != 0)
          setMsgTypeValue(param2Request.getMsgTypeValue()); 
        if (param2Request.getLocalId() != 0)
          setLocalId(param2Request.getLocalId()); 
        if (param2Request.hasBody())
          mergeBody(param2Request.getBody()); 
        if (param2Request.getFrom() != 0)
          setFrom(param2Request.getFrom()); 
        if (param2Request.getSessionType() != 0)
          setSessionType(param2Request.getSessionType()); 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PrivateChatOuterClass.Request request = (PrivateChatOuterClass.Request)PrivateChatOuterClass.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PrivateChatOuterClass.Request request = (PrivateChatOuterClass.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PrivateChatOuterClass.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PrivateChatOuterClass.Request)
          return mergeFrom((PrivateChatOuterClass.Request)param2Message); 
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
      
      public Builder setLocalId(int param2Int) {
        this.localId_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setMsgType(MsgTypeOuterClass.MsgType param2MsgType) {
        if (param2MsgType != null) {
          this.msgType_ = param2MsgType.getNumber();
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setMsgTypeValue(int param2Int) {
        this.msgType_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
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
  
  static final class null extends AbstractParser<Request> {
    public PrivateChatOuterClass.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PrivateChatOuterClass.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
    
    private Any body_;
    
    private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
    
    private CommonOuterClass.Common common_;
    
    private int from_;
    
    private int localId_;
    
    private int msgType_ = 0;
    
    private int sessionType_;
    
    private int to_;
    
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
    
    private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
      if (this.commonBuilder_ == null) {
        this.commonBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getCommon(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.common_ = null;
      } 
      return this.commonBuilder_;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PrivateChatOuterClass.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PrivateChatOuterClass.Request build() {
      PrivateChatOuterClass.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public PrivateChatOuterClass.Request buildPartial() {
      PrivateChatOuterClass.Request request = new PrivateChatOuterClass.Request(this);
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV31 = this.commonBuilder_;
      if (singleFieldBuilderV31 == null) {
        PrivateChatOuterClass.Request.access$602(request, this.common_);
      } else {
        PrivateChatOuterClass.Request.access$602(request, (CommonOuterClass.Common)singleFieldBuilderV31.build());
      } 
      PrivateChatOuterClass.Request.access$702(request, this.to_);
      PrivateChatOuterClass.Request.access$802(request, this.msgType_);
      PrivateChatOuterClass.Request.access$902(request, this.localId_);
      SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
      if (singleFieldBuilderV3 == null) {
        PrivateChatOuterClass.Request.access$1002(request, this.body_);
      } else {
        PrivateChatOuterClass.Request.access$1002(request, (Any)singleFieldBuilderV3.build());
      } 
      PrivateChatOuterClass.Request.access$1102(request, this.from_);
      PrivateChatOuterClass.Request.access$1202(request, this.sessionType_);
      onBuilt();
      return request;
    }
    
    public Builder clear() {
      super.clear();
      if (this.commonBuilder_ == null) {
        this.common_ = null;
      } else {
        this.common_ = null;
        this.commonBuilder_ = null;
      } 
      this.to_ = 0;
      this.msgType_ = 0;
      this.localId_ = 0;
      if (this.bodyBuilder_ == null) {
        this.body_ = null;
      } else {
        this.body_ = null;
        this.bodyBuilder_ = null;
      } 
      this.from_ = 0;
      this.sessionType_ = 0;
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
    
    public Builder clearLocalId() {
      this.localId_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMsgType() {
      this.msgType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
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
    
    public PrivateChatOuterClass.Request getDefaultInstanceForType() {
      return PrivateChatOuterClass.Request.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public int getLocalId() {
      return this.localId_;
    }
    
    public MsgTypeOuterClass.MsgType getMsgType() {
      MsgTypeOuterClass.MsgType msgType2 = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
      MsgTypeOuterClass.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = MsgTypeOuterClass.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public int getSessionType() {
      return this.sessionType_;
    }
    
    public int getTo() {
      return this.to_;
    }
    
    public boolean hasBody() {
      return (this.bodyBuilder_ != null || this.body_ != null);
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Request.class, Builder.class);
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
    
    public Builder mergeFrom(PrivateChatOuterClass.Request param1Request) {
      if (param1Request == PrivateChatOuterClass.Request.getDefaultInstance())
        return this; 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (param1Request.getTo() != 0)
        setTo(param1Request.getTo()); 
      if (param1Request.msgType_ != 0)
        setMsgTypeValue(param1Request.getMsgTypeValue()); 
      if (param1Request.getLocalId() != 0)
        setLocalId(param1Request.getLocalId()); 
      if (param1Request.hasBody())
        mergeBody(param1Request.getBody()); 
      if (param1Request.getFrom() != 0)
        setFrom(param1Request.getFrom()); 
      if (param1Request.getSessionType() != 0)
        setSessionType(param1Request.getSessionType()); 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PrivateChatOuterClass.Request request = (PrivateChatOuterClass.Request)PrivateChatOuterClass.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PrivateChatOuterClass.Request request = (PrivateChatOuterClass.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PrivateChatOuterClass.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PrivateChatOuterClass.Request)
        return mergeFrom((PrivateChatOuterClass.Request)param1Message); 
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
    
    public Builder setLocalId(int param1Int) {
      this.localId_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setMsgType(MsgTypeOuterClass.MsgType param1MsgType) {
      if (param1MsgType != null) {
        this.msgType_ = param1MsgType.getNumber();
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setMsgTypeValue(int param1Int) {
      this.msgType_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
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
  
  public static interface RequestOrBuilder extends MessageOrBuilder {
    Any getBody();
    
    AnyOrBuilder getBodyOrBuilder();
    
    CommonOuterClass.Common getCommon();
    
    CommonOuterClass.CommonOrBuilder getCommonOrBuilder();
    
    int getFrom();
    
    int getLocalId();
    
    MsgTypeOuterClass.MsgType getMsgType();
    
    int getMsgTypeValue();
    
    int getSessionType();
    
    int getTo();
    
    boolean hasBody();
    
    boolean hasCommon();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    public static final int LOCAL_ID_FIELD_NUMBER = 4;
    
    public static final int MESSAGE_FIELD_NUMBER = 2;
    
    public static final int MSG_ID_FIELD_NUMBER = 3;
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public PrivateChatOuterClass.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PrivateChatOuterClass.Response(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_ID_FIELD_NUMBER = 5;
    
    public static final int REQUEST_TIME_FIELD_NUMBER = 6;
    
    public static final int RESPONSE_TIME_FIELD_NUMBER = 7;
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private int localId_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object message_;
    
    private long msgId_;
    
    private volatile Object requestId_;
    
    private long requestTime_;
    
    private long responseTime_;
    
    private Response() {
      this.code_ = 0;
      this.message_ = "";
      this.requestId_ = "";
    }
    
    private Response(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    if (i != 32) {
                      if (i != 42) {
                        if (i != 48) {
                          if (i != 56) {
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
                    this.localId_ = param1CodedInputStream.readInt32();
                    continue;
                  } 
                  this.msgId_ = param1CodedInputStream.readInt64();
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
    
    private Response(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Response getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(Response param1Response) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1Response);
    }
    
    public static Response parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static Response parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteString);
    }
    
    public static Response parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static Response parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(InputStream param1InputStream) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static Response parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (Response)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static Response parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static Response parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static Response parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (Response)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<Response> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof Response))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (this.code_ != ((Response)param1Object).code_) ? false : (!getMessage().equals(param1Object.getMessage()) ? false : ((getMsgId() != param1Object.getMsgId()) ? false : ((getLocalId() != param1Object.getLocalId()) ? false : (!getRequestId().equals(param1Object.getRequestId()) ? false : ((getRequestTime() != param1Object.getRequestTime()) ? false : ((getResponseTime() != param1Object.getResponseTime()) ? false : (!!this.unknownFields.equals(((Response)param1Object).unknownFields))))))));
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
    
    public Response getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getLocalId() {
      return this.localId_;
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
    
    public Parser<Response> getParserForType() {
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
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber())
        i = 0 + CodedOutputStream.computeEnumSize(1, this.code_); 
      int j = i;
      if (!getMessageBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.message_); 
      long l = this.msgId_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(3, l); 
      int k = this.localId_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(4, k); 
      i = j;
      if (!getRequestIdBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(5, this.requestId_); 
      l = this.requestTime_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(6, l); 
      l = this.responseTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(7, l); 
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
      int i = (((((((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.code_) * 37 + 2) * 53 + getMessage().hashCode()) * 37 + 3) * 53 + Internal.hashLong(getMsgId())) * 37 + 4) * 53 + getLocalId()) * 37 + 5) * 53 + getRequestId().hashCode()) * 37 + 6) * 53 + Internal.hashLong(getRequestTime())) * 37 + 7) * 53 + Internal.hashLong(getResponseTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
      return new Response();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber())
        param1CodedOutputStream.writeEnum(1, this.code_); 
      if (!getMessageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.message_); 
      long l = this.msgId_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(3, l); 
      int i = this.localId_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(4, i); 
      if (!getRequestIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 5, this.requestId_); 
      l = this.requestTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(6, l); 
      l = this.responseTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(7, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PrivateChatOuterClass.ResponseOrBuilder {
      private int code_ = 0;
      
      private int localId_;
      
      private Object message_ = "";
      
      private long msgId_;
      
      private Object requestId_ = "";
      
      private long requestTime_;
      
      private long responseTime_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PrivateChatOuterClass.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PrivateChatOuterClass.Response build() {
        PrivateChatOuterClass.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public PrivateChatOuterClass.Response buildPartial() {
        PrivateChatOuterClass.Response response = new PrivateChatOuterClass.Response(this);
        PrivateChatOuterClass.Response.access$2202(response, this.code_);
        PrivateChatOuterClass.Response.access$2302(response, this.message_);
        PrivateChatOuterClass.Response.access$2402(response, this.msgId_);
        PrivateChatOuterClass.Response.access$2502(response, this.localId_);
        PrivateChatOuterClass.Response.access$2602(response, this.requestId_);
        PrivateChatOuterClass.Response.access$2702(response, this.requestTime_);
        PrivateChatOuterClass.Response.access$2802(response, this.responseTime_);
        onBuilt();
        return response;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        this.message_ = "";
        this.msgId_ = 0L;
        this.localId_ = 0;
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
      
      public Builder clearLocalId() {
        this.localId_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearMessage() {
        this.message_ = PrivateChatOuterClass.Response.getDefaultInstance().getMessage();
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
      
      public Builder clearRequestId() {
        this.requestId_ = PrivateChatOuterClass.Response.getDefaultInstance().getRequestId();
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
      
      public PrivateChatOuterClass.Response getDefaultInstanceForType() {
        return PrivateChatOuterClass.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
      }
      
      public int getLocalId() {
        return this.localId_;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(PrivateChatOuterClass.Response param2Response) {
        if (param2Response == PrivateChatOuterClass.Response.getDefaultInstance())
          return this; 
        if (param2Response.code_ != 0)
          setCodeValue(param2Response.getCodeValue()); 
        if (!param2Response.getMessage().isEmpty()) {
          this.message_ = param2Response.message_;
          onChanged();
        } 
        if (param2Response.getMsgId() != 0L)
          setMsgId(param2Response.getMsgId()); 
        if (param2Response.getLocalId() != 0)
          setLocalId(param2Response.getLocalId()); 
        if (!param2Response.getRequestId().isEmpty()) {
          this.requestId_ = param2Response.requestId_;
          onChanged();
        } 
        if (param2Response.getRequestTime() != 0L)
          setRequestTime(param2Response.getRequestTime()); 
        if (param2Response.getResponseTime() != 0L)
          setResponseTime(param2Response.getResponseTime()); 
        mergeUnknownFields(param2Response.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PrivateChatOuterClass.Response response = (PrivateChatOuterClass.Response)PrivateChatOuterClass.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PrivateChatOuterClass.Response response = (PrivateChatOuterClass.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PrivateChatOuterClass.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PrivateChatOuterClass.Response)
          return mergeFrom((PrivateChatOuterClass.Response)param2Message); 
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
      
      public Builder setLocalId(int param2Int) {
        this.localId_ = param2Int;
        onChanged();
        return this;
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
          PrivateChatOuterClass.Response.checkByteStringIsUtf8(param2ByteString);
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
          PrivateChatOuterClass.Response.checkByteStringIsUtf8(param2ByteString);
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
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Response> {
    public PrivateChatOuterClass.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PrivateChatOuterClass.Response(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Response.Builder> implements ResponseOrBuilder {
    private int code_ = 0;
    
    private int localId_;
    
    private Object message_ = "";
    
    private long msgId_;
    
    private Object requestId_ = "";
    
    private long requestTime_;
    
    private long responseTime_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PrivateChatOuterClass.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PrivateChatOuterClass.Response build() {
      PrivateChatOuterClass.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public PrivateChatOuterClass.Response buildPartial() {
      PrivateChatOuterClass.Response response = new PrivateChatOuterClass.Response(this);
      PrivateChatOuterClass.Response.access$2202(response, this.code_);
      PrivateChatOuterClass.Response.access$2302(response, this.message_);
      PrivateChatOuterClass.Response.access$2402(response, this.msgId_);
      PrivateChatOuterClass.Response.access$2502(response, this.localId_);
      PrivateChatOuterClass.Response.access$2602(response, this.requestId_);
      PrivateChatOuterClass.Response.access$2702(response, this.requestTime_);
      PrivateChatOuterClass.Response.access$2802(response, this.responseTime_);
      onBuilt();
      return response;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      this.message_ = "";
      this.msgId_ = 0L;
      this.localId_ = 0;
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
    
    public Builder clearLocalId() {
      this.localId_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearMessage() {
      this.message_ = PrivateChatOuterClass.Response.getDefaultInstance().getMessage();
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
    
    public Builder clearRequestId() {
      this.requestId_ = PrivateChatOuterClass.Response.getDefaultInstance().getRequestId();
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
    
    public PrivateChatOuterClass.Response getDefaultInstanceForType() {
      return PrivateChatOuterClass.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
    }
    
    public int getLocalId() {
      return this.localId_;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(PrivateChatOuterClass.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(PrivateChatOuterClass.Response param1Response) {
      if (param1Response == PrivateChatOuterClass.Response.getDefaultInstance())
        return this; 
      if (param1Response.code_ != 0)
        setCodeValue(param1Response.getCodeValue()); 
      if (!param1Response.getMessage().isEmpty()) {
        this.message_ = param1Response.message_;
        onChanged();
      } 
      if (param1Response.getMsgId() != 0L)
        setMsgId(param1Response.getMsgId()); 
      if (param1Response.getLocalId() != 0)
        setLocalId(param1Response.getLocalId()); 
      if (!param1Response.getRequestId().isEmpty()) {
        this.requestId_ = param1Response.requestId_;
        onChanged();
      } 
      if (param1Response.getRequestTime() != 0L)
        setRequestTime(param1Response.getRequestTime()); 
      if (param1Response.getResponseTime() != 0L)
        setResponseTime(param1Response.getResponseTime()); 
      mergeUnknownFields(param1Response.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PrivateChatOuterClass.Response response = (PrivateChatOuterClass.Response)PrivateChatOuterClass.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PrivateChatOuterClass.Response response = (PrivateChatOuterClass.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PrivateChatOuterClass.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PrivateChatOuterClass.Response)
        return mergeFrom((PrivateChatOuterClass.Response)param1Message); 
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
    
    public Builder setLocalId(int param1Int) {
      this.localId_ = param1Int;
      onChanged();
      return this;
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
        PrivateChatOuterClass.Response.checkByteStringIsUtf8(param1ByteString);
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
        PrivateChatOuterClass.Response.checkByteStringIsUtf8(param1ByteString);
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
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ResponseOrBuilder extends MessageOrBuilder {
    CodeOuterClass.Code getCode();
    
    int getCodeValue();
    
    int getLocalId();
    
    String getMessage();
    
    ByteString getMessageBytes();
    
    long getMsgId();
    
    String getRequestId();
    
    ByteString getRequestIdBytes();
    
    long getRequestTime();
    
    long getResponseTime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\PrivateChatOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */