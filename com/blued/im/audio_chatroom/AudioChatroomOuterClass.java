package com.blued.im.audio_chatroom;

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

public final class AudioChatroomOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Request_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_audio_chatroom_Request_descriptor, new String[] { "Common", "To", "MsgType", "Contents", "SourceProfile", "TargetProfile", "Extra", "RoomId", "SendAnyone" });
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_audio_chatroom_Response_descriptor;
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable;
  
  static {
    internal_static_com_blued_im_audio_chatroom_Receive_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_audio_chatroom_Receive_descriptor, new String[] { "From", "MsgType", "Contents", "SourceProfile", "TargetProfile", "Extra", "RoomId", "MsgTime", "Resend" });
    internal_static_com_blued_im_audio_chatroom_Response_descriptor = getDescriptor().getMessageTypes().get(2);
    internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_audio_chatroom_Response_descriptor, new String[] { "Code", "Message", "RequestId", "RequestTime", "ResponseTime" });
    AudioMsgExtra.getDescriptor();
    AudioMsgType.getDescriptor();
    AudioCode.getDescriptor();
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
    Descriptors.FileDescriptor fileDescriptor1 = AudioMsgExtra.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor2 = AudioMsgType.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor3 = AudioCode.getDescriptor();
    Descriptors.FileDescriptor fileDescriptor4 = CommonOuterClass.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\023AudioChatroom.proto\022\033com.blued.im.audio_chatroom\032\023AudioMsgExtra.proto\032\022AudioMsgType.proto\032\017AudioCode.proto\032\fCommon.proto\"Ý\002\n\007Request\022$\n\006common\030\001 \001(\0132\024.com.blued.im.Common\022\n\n\002to\030\002 \001(\r\0226\n\bmsg_type\030\003 \001(\0162$.com.blued.im.audio_chatroom.MsgType\022\020\n\bcontents\030\004 \001(\t\022<\n\016source_profile\030\005 \001(\0132$.com.blued.im.audio_chatroom.Profile\022<\n\016target_profile\030\006 \001(\0132$.com.blued.im.audio_chatroom.Profile\0224\n\005extra\030\007 \001(\0132%.com.blued.im.audio_chatroom.MsgExtra\022\017\n\007room_id\030\b \001(\005\022\023\n\013send_anyone\030\t \001(\005\"Æ\002\n\007Receive\022\f\n\004from\030\001 \001(\r\0226\n\bmsg_type\030\002 \001(\0162$.com.blued.im.audio_chatroom.MsgType\022\020\n\bcontents\030\003 \001(\t\022<\n\016source_profile\030\004 \001(\0132$.com.blued.im.audio_chatroom.Profile\022<\n\016target_profile\030\005 \001(\0132$.com.blued.im.audio_chatroom.Profile\0224\n\005extra\030\006 \001(\0132%.com.blued.im.audio_chatroom.MsgExtra\022\017\n\007room_id\030\007 \001(\005\022\020\n\bmsg_time\030\b \001(\003\022\016\n\006resend\030\t \001(\b\"\001\n\bResponse\022/\n\004code\030\001 \001(\0162!.com.blued.im.audio_chatroom.Code\022\017\n\007message\030\002 \001(\t\022\022\n\nrequest_id\030\003 \001(\t\022\024\n\frequest_time\030\004 \001(\003\022\025\n\rresponse_time\030\005 \001(\0032f\n\rAudioChatroom\022U\n\004Send\022$.com.blued.im.audio_chatroom.Request\032%.com.blued.im.audio_chatroom.Response\"\000B\020¢\002\rAudioChatroomb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor1, fileDescriptor2, fileDescriptor3, fileDescriptor4 });
  }
  
  public static final class Receive extends GeneratedMessageV3 implements ReceiveOrBuilder {
    public static final int CONTENTS_FIELD_NUMBER = 3;
    
    private static final Receive DEFAULT_INSTANCE = new Receive();
    
    public static final int EXTRA_FIELD_NUMBER = 6;
    
    public static final int FROM_FIELD_NUMBER = 1;
    
    public static final int MSG_TIME_FIELD_NUMBER = 8;
    
    public static final int MSG_TYPE_FIELD_NUMBER = 2;
    
    private static final Parser<Receive> PARSER = (Parser<Receive>)new AbstractParser<Receive>() {
        public AudioChatroomOuterClass.Receive parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new AudioChatroomOuterClass.Receive(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int RESEND_FIELD_NUMBER = 9;
    
    public static final int ROOM_ID_FIELD_NUMBER = 7;
    
    public static final int SOURCE_PROFILE_FIELD_NUMBER = 4;
    
    public static final int TARGET_PROFILE_FIELD_NUMBER = 5;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object contents_;
    
    private AudioMsgExtra.MsgExtra extra_;
    
    private int from_;
    
    private byte memoizedIsInitialized = -1;
    
    private long msgTime_;
    
    private int msgType_;
    
    private boolean resend_;
    
    private int roomId_;
    
    private AudioMsgExtra.Profile sourceProfile_;
    
    private AudioMsgExtra.Profile targetProfile_;
    
    private Receive() {
      this.msgType_ = 0;
      this.contents_ = "";
    }
    
    private Receive(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
                    AudioMsgExtra.Profile.Builder builder1;
                    AudioMsgExtra.MsgExtra.Builder builder3 = null;
                    AudioMsgExtra.MsgExtra.Builder builder4 = null;
                    AudioMsgExtra.MsgExtra.Builder builder2 = null;
                    if (i != 34) {
                      if (i != 42) {
                        if (i != 50) {
                          if (i != 56) {
                            if (i != 64) {
                              if (i != 72) {
                                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                                  continue; 
                                continue;
                              } 
                              this.resend_ = param1CodedInputStream.readBool();
                              continue;
                            } 
                            this.msgTime_ = param1CodedInputStream.readInt64();
                            continue;
                          } 
                          this.roomId_ = param1CodedInputStream.readInt32();
                          continue;
                        } 
                        if (this.extra_ != null)
                          builder2 = this.extra_.toBuilder(); 
                        this.extra_ = (AudioMsgExtra.MsgExtra)param1CodedInputStream.readMessage(AudioMsgExtra.MsgExtra.parser(), param1ExtensionRegistryLite);
                        if (builder2 != null) {
                          builder2.mergeFrom(this.extra_);
                          this.extra_ = builder2.buildPartial();
                        } 
                        continue;
                      } 
                      builder2 = builder3;
                      if (this.targetProfile_ != null)
                        builder1 = this.targetProfile_.toBuilder(); 
                      this.targetProfile_ = (AudioMsgExtra.Profile)param1CodedInputStream.readMessage(AudioMsgExtra.Profile.parser(), param1ExtensionRegistryLite);
                      if (builder1 != null) {
                        builder1.mergeFrom(this.targetProfile_);
                        this.targetProfile_ = builder1.buildPartial();
                      } 
                      continue;
                    } 
                    builder2 = builder4;
                    if (this.sourceProfile_ != null)
                      builder1 = this.sourceProfile_.toBuilder(); 
                    this.sourceProfile_ = (AudioMsgExtra.Profile)param1CodedInputStream.readMessage(AudioMsgExtra.Profile.parser(), param1ExtensionRegistryLite);
                    if (builder1 != null) {
                      builder1.mergeFrom(this.sourceProfile_);
                      this.sourceProfile_ = builder1.buildPartial();
                    } 
                    continue;
                  } 
                  this.contents_ = param1CodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.msgType_ = param1CodedInputStream.readEnum();
                continue;
              } 
              this.from_ = param1CodedInputStream.readUInt32();
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
    
    private Receive(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static Receive getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
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
      return (getFrom() != param1Object.getFrom()) ? false : ((this.msgType_ != ((Receive)param1Object).msgType_) ? false : (!getContents().equals(param1Object.getContents()) ? false : ((hasSourceProfile() != param1Object.hasSourceProfile()) ? false : ((hasSourceProfile() && !getSourceProfile().equals(param1Object.getSourceProfile())) ? false : ((hasTargetProfile() != param1Object.hasTargetProfile()) ? false : ((hasTargetProfile() && !getTargetProfile().equals(param1Object.getTargetProfile())) ? false : ((hasExtra() != param1Object.hasExtra()) ? false : ((hasExtra() && !getExtra().equals(param1Object.getExtra())) ? false : ((getRoomId() != param1Object.getRoomId()) ? false : ((getMsgTime() != param1Object.getMsgTime()) ? false : ((getResend() != param1Object.getResend()) ? false : (!!this.unknownFields.equals(((Receive)param1Object).unknownFields)))))))))))));
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
    
    public Receive getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public AudioMsgExtra.MsgExtra getExtra() {
      AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
      AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
      if (msgExtra2 == null)
        msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
      return msgExtra1;
    }
    
    public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
      return getExtra();
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public long getMsgTime() {
      return this.msgTime_;
    }
    
    public AudioMsgType.MsgType getMsgType() {
      AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
      AudioMsgType.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public Parser<Receive> getParserForType() {
      return PARSER;
    }
    
    public boolean getResend() {
      return this.resend_;
    }
    
    public int getRoomId() {
      return this.roomId_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      int j = this.from_;
      if (j != 0)
        i = 0 + CodedOutputStream.computeUInt32Size(1, j); 
      j = i;
      if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(2, this.msgType_); 
      i = j;
      if (!getContentsBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(3, this.contents_); 
      j = i;
      if (this.sourceProfile_ != null)
        j = i + CodedOutputStream.computeMessageSize(4, (MessageLite)getSourceProfile()); 
      int k = j;
      if (this.targetProfile_ != null)
        k = j + CodedOutputStream.computeMessageSize(5, (MessageLite)getTargetProfile()); 
      i = k;
      if (this.extra_ != null)
        i = k + CodedOutputStream.computeMessageSize(6, (MessageLite)getExtra()); 
      k = this.roomId_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(7, k); 
      long l = this.msgTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(8, l); 
      boolean bool = this.resend_;
      j = i;
      if (bool)
        j = i + CodedOutputStream.computeBoolSize(9, bool); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public AudioMsgExtra.Profile getSourceProfile() {
      AudioMsgExtra.Profile profile2 = this.sourceProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
      return getSourceProfile();
    }
    
    public AudioMsgExtra.Profile getTargetProfile() {
      AudioMsgExtra.Profile profile2 = this.targetProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
      return getTargetProfile();
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public boolean hasExtra() {
      return (this.extra_ != null);
    }
    
    public boolean hasSourceProfile() {
      return (this.sourceProfile_ != null);
    }
    
    public boolean hasTargetProfile() {
      return (this.targetProfile_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getFrom()) * 37 + 2) * 53 + this.msgType_) * 37 + 3) * 53 + getContents().hashCode();
      int i = j;
      if (hasSourceProfile())
        i = (j * 37 + 4) * 53 + getSourceProfile().hashCode(); 
      j = i;
      if (hasTargetProfile())
        j = (i * 37 + 5) * 53 + getTargetProfile().hashCode(); 
      i = j;
      if (hasExtra())
        i = (j * 37 + 6) * 53 + getExtra().hashCode(); 
      i = ((((((i * 37 + 7) * 53 + getRoomId()) * 37 + 8) * 53 + Internal.hashLong(getMsgTime())) * 37 + 9) * 53 + Internal.hashBoolean(getResend())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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
      int i = this.from_;
      if (i != 0)
        param1CodedOutputStream.writeUInt32(1, i); 
      if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(2, this.msgType_); 
      if (!getContentsBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.contents_); 
      if (this.sourceProfile_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getSourceProfile()); 
      if (this.targetProfile_ != null)
        param1CodedOutputStream.writeMessage(5, (MessageLite)getTargetProfile()); 
      if (this.extra_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getExtra()); 
      i = this.roomId_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(7, i); 
      long l = this.msgTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(8, l); 
      boolean bool = this.resend_;
      if (bool)
        param1CodedOutputStream.writeBool(9, bool); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AudioChatroomOuterClass.ReceiveOrBuilder {
      private Object contents_ = "";
      
      private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
      
      private AudioMsgExtra.MsgExtra extra_;
      
      private int from_;
      
      private long msgTime_;
      
      private int msgType_ = 0;
      
      private boolean resend_;
      
      private int roomId_;
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
      
      private AudioMsgExtra.Profile sourceProfile_;
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
      
      private AudioMsgExtra.Profile targetProfile_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
        if (this.extraBuilder_ == null) {
          this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.extra_ = null;
        } 
        return this.extraBuilder_;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSourceProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.sourceProfile_ = null;
        } 
        return this.sourceProfileBuilder_;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
        if (this.targetProfileBuilder_ == null) {
          this.targetProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTargetProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.targetProfile_ = null;
        } 
        return this.targetProfileBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        AudioChatroomOuterClass.Receive.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public AudioChatroomOuterClass.Receive build() {
        AudioChatroomOuterClass.Receive receive = buildPartial();
        if (receive.isInitialized())
          return receive; 
        throw newUninitializedMessageException(receive);
      }
      
      public AudioChatroomOuterClass.Receive buildPartial() {
        AudioChatroomOuterClass.Receive receive = new AudioChatroomOuterClass.Receive(this);
        AudioChatroomOuterClass.Receive.access$2502(receive, this.from_);
        AudioChatroomOuterClass.Receive.access$2602(receive, this.msgType_);
        AudioChatroomOuterClass.Receive.access$2702(receive, this.contents_);
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV31 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV31 == null) {
          AudioChatroomOuterClass.Receive.access$2802(receive, this.sourceProfile_);
        } else {
          AudioChatroomOuterClass.Receive.access$2802(receive, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
        } 
        singleFieldBuilderV31 = this.targetProfileBuilder_;
        if (singleFieldBuilderV31 == null) {
          AudioChatroomOuterClass.Receive.access$2902(receive, this.targetProfile_);
        } else {
          AudioChatroomOuterClass.Receive.access$2902(receive, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioChatroomOuterClass.Receive.access$3002(receive, this.extra_);
        } else {
          AudioChatroomOuterClass.Receive.access$3002(receive, (AudioMsgExtra.MsgExtra)singleFieldBuilderV3.build());
        } 
        AudioChatroomOuterClass.Receive.access$3102(receive, this.roomId_);
        AudioChatroomOuterClass.Receive.access$3202(receive, this.msgTime_);
        AudioChatroomOuterClass.Receive.access$3302(receive, this.resend_);
        onBuilt();
        return receive;
      }
      
      public Builder clear() {
        super.clear();
        this.from_ = 0;
        this.msgType_ = 0;
        this.contents_ = "";
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfile_ = null;
        } else {
          this.sourceProfile_ = null;
          this.sourceProfileBuilder_ = null;
        } 
        if (this.targetProfileBuilder_ == null) {
          this.targetProfile_ = null;
        } else {
          this.targetProfile_ = null;
          this.targetProfileBuilder_ = null;
        } 
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
        } else {
          this.extra_ = null;
          this.extraBuilder_ = null;
        } 
        this.roomId_ = 0;
        this.msgTime_ = 0L;
        this.resend_ = false;
        return this;
      }
      
      public Builder clearContents() {
        this.contents_ = AudioChatroomOuterClass.Receive.getDefaultInstance().getContents();
        onChanged();
        return this;
      }
      
      public Builder clearExtra() {
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          onChanged();
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
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
      
      public Builder clearMsgTime() {
        this.msgTime_ = 0L;
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
      
      public Builder clearResend() {
        this.resend_ = false;
        onChanged();
        return this;
      }
      
      public Builder clearRoomId() {
        this.roomId_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSourceProfile() {
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfile_ = null;
          onChanged();
          return this;
        } 
        this.sourceProfile_ = null;
        this.sourceProfileBuilder_ = null;
        return this;
      }
      
      public Builder clearTargetProfile() {
        if (this.targetProfileBuilder_ == null) {
          this.targetProfile_ = null;
          onChanged();
          return this;
        } 
        this.targetProfile_ = null;
        this.targetProfileBuilder_ = null;
        return this;
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
      
      public AudioChatroomOuterClass.Receive getDefaultInstanceForType() {
        return AudioChatroomOuterClass.Receive.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
      }
      
      public AudioMsgExtra.MsgExtra getExtra() {
        AudioMsgExtra.MsgExtra msgExtra;
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.MsgExtra msgExtra1 = this.extra_;
          msgExtra = msgExtra1;
          if (msgExtra1 == null)
            msgExtra = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
          return msgExtra;
        } 
        return (AudioMsgExtra.MsgExtra)msgExtra.getMessage();
      }
      
      public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
        onChanged();
        return (AudioMsgExtra.MsgExtra.Builder)getExtraFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.MsgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
        AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
        if (msgExtra2 == null)
          msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
        return msgExtra1;
      }
      
      public int getFrom() {
        return this.from_;
      }
      
      public long getMsgTime() {
        return this.msgTime_;
      }
      
      public AudioMsgType.MsgType getMsgType() {
        AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
        AudioMsgType.MsgType msgType1 = msgType2;
        if (msgType2 == null)
          msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
        return msgType1;
      }
      
      public int getMsgTypeValue() {
        return this.msgType_;
      }
      
      public boolean getResend() {
        return this.resend_;
      }
      
      public int getRoomId() {
        return this.roomId_;
      }
      
      public AudioMsgExtra.Profile getSourceProfile() {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.Profile profile1 = this.sourceProfile_;
          profile = profile1;
          if (profile1 == null)
            profile = AudioMsgExtra.Profile.getDefaultInstance(); 
          return profile;
        } 
        return (AudioMsgExtra.Profile)profile.getMessage();
      }
      
      public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
        onChanged();
        return (AudioMsgExtra.Profile.Builder)getSourceProfileFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.Profile profile2 = this.sourceProfile_;
        AudioMsgExtra.Profile profile1 = profile2;
        if (profile2 == null)
          profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile1;
      }
      
      public AudioMsgExtra.Profile getTargetProfile() {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.Profile profile1 = this.targetProfile_;
          profile = profile1;
          if (profile1 == null)
            profile = AudioMsgExtra.Profile.getDefaultInstance(); 
          return profile;
        } 
        return (AudioMsgExtra.Profile)profile.getMessage();
      }
      
      public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
        onChanged();
        return (AudioMsgExtra.Profile.Builder)getTargetProfileFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.Profile profile2 = this.targetProfile_;
        AudioMsgExtra.Profile profile1 = profile2;
        if (profile2 == null)
          profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile1;
      }
      
      public boolean hasExtra() {
        return (this.extraBuilder_ != null || this.extra_ != null);
      }
      
      public boolean hasSourceProfile() {
        return (this.sourceProfileBuilder_ != null || this.sourceProfile_ != null);
      }
      
      public boolean hasTargetProfile() {
        return (this.targetProfileBuilder_ != null || this.targetProfile_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Receive.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeExtra(AudioMsgExtra.MsgExtra param2MsgExtra) {
        AudioMsgExtra.MsgExtra msgExtra;
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          msgExtra = this.extra_;
          if (msgExtra != null) {
            this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra).mergeFrom(param2MsgExtra).buildPartial();
          } else {
            this.extra_ = param2MsgExtra;
          } 
          onChanged();
          return this;
        } 
        msgExtra.mergeFrom((AbstractMessage)param2MsgExtra);
        return this;
      }
      
      public Builder mergeFrom(AudioChatroomOuterClass.Receive param2Receive) {
        if (param2Receive == AudioChatroomOuterClass.Receive.getDefaultInstance())
          return this; 
        if (param2Receive.getFrom() != 0)
          setFrom(param2Receive.getFrom()); 
        if (param2Receive.msgType_ != 0)
          setMsgTypeValue(param2Receive.getMsgTypeValue()); 
        if (!param2Receive.getContents().isEmpty()) {
          this.contents_ = param2Receive.contents_;
          onChanged();
        } 
        if (param2Receive.hasSourceProfile())
          mergeSourceProfile(param2Receive.getSourceProfile()); 
        if (param2Receive.hasTargetProfile())
          mergeTargetProfile(param2Receive.getTargetProfile()); 
        if (param2Receive.hasExtra())
          mergeExtra(param2Receive.getExtra()); 
        if (param2Receive.getRoomId() != 0)
          setRoomId(param2Receive.getRoomId()); 
        if (param2Receive.getMsgTime() != 0L)
          setMsgTime(param2Receive.getMsgTime()); 
        if (param2Receive.getResend())
          setResend(param2Receive.getResend()); 
        mergeUnknownFields(param2Receive.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          AudioChatroomOuterClass.Receive receive = (AudioChatroomOuterClass.Receive)AudioChatroomOuterClass.Receive.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          AudioChatroomOuterClass.Receive receive = (AudioChatroomOuterClass.Receive)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((AudioChatroomOuterClass.Receive)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof AudioChatroomOuterClass.Receive)
          return mergeFrom((AudioChatroomOuterClass.Receive)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeSourceProfile(AudioMsgExtra.Profile param2Profile) {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          profile = this.sourceProfile_;
          if (profile != null) {
            this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param2Profile).buildPartial();
          } else {
            this.sourceProfile_ = param2Profile;
          } 
          onChanged();
          return this;
        } 
        profile.mergeFrom((AbstractMessage)param2Profile);
        return this;
      }
      
      public Builder mergeTargetProfile(AudioMsgExtra.Profile param2Profile) {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          profile = this.targetProfile_;
          if (profile != null) {
            this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param2Profile).buildPartial();
          } else {
            this.targetProfile_ = param2Profile;
          } 
          onChanged();
          return this;
        } 
        profile.mergeFrom((AbstractMessage)param2Profile);
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
          AudioChatroomOuterClass.Receive.checkByteStringIsUtf8(param2ByteString);
          this.contents_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setExtra(AudioMsgExtra.MsgExtra.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.extra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setExtra(AudioMsgExtra.MsgExtra param2MsgExtra) {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2MsgExtra != null) {
            this.extra_ = param2MsgExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2MsgExtra);
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
      
      public Builder setMsgTime(long param2Long) {
        this.msgTime_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setMsgType(AudioMsgType.MsgType param2MsgType) {
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
      
      public Builder setResend(boolean param2Boolean) {
        this.resend_ = param2Boolean;
        onChanged();
        return this;
      }
      
      public Builder setRoomId(int param2Int) {
        this.roomId_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSourceProfile(AudioMsgExtra.Profile.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.sourceProfile_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSourceProfile(AudioMsgExtra.Profile param2Profile) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Profile != null) {
            this.sourceProfile_ = param2Profile;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Profile);
        return this;
      }
      
      public Builder setTargetProfile(AudioMsgExtra.Profile.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.targetProfile_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setTargetProfile(AudioMsgExtra.Profile param2Profile) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Profile != null) {
            this.targetProfile_ = param2Profile;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Profile);
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
    }
  }
  
  static final class null extends AbstractParser<Receive> {
    public AudioChatroomOuterClass.Receive parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new AudioChatroomOuterClass.Receive(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Receive.Builder> implements ReceiveOrBuilder {
    private Object contents_ = "";
    
    private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
    
    private AudioMsgExtra.MsgExtra extra_;
    
    private int from_;
    
    private long msgTime_;
    
    private int msgType_ = 0;
    
    private boolean resend_;
    
    private int roomId_;
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
    
    private AudioMsgExtra.Profile sourceProfile_;
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
    
    private AudioMsgExtra.Profile targetProfile_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
      if (this.extraBuilder_ == null) {
        this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extra_ = null;
      } 
      return this.extraBuilder_;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSourceProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sourceProfile_ = null;
      } 
      return this.sourceProfileBuilder_;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
      if (this.targetProfileBuilder_ == null) {
        this.targetProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTargetProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.targetProfile_ = null;
      } 
      return this.targetProfileBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      AudioChatroomOuterClass.Receive.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AudioChatroomOuterClass.Receive build() {
      AudioChatroomOuterClass.Receive receive = buildPartial();
      if (receive.isInitialized())
        return receive; 
      throw newUninitializedMessageException(receive);
    }
    
    public AudioChatroomOuterClass.Receive buildPartial() {
      AudioChatroomOuterClass.Receive receive = new AudioChatroomOuterClass.Receive(this);
      AudioChatroomOuterClass.Receive.access$2502(receive, this.from_);
      AudioChatroomOuterClass.Receive.access$2602(receive, this.msgType_);
      AudioChatroomOuterClass.Receive.access$2702(receive, this.contents_);
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV31 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV31 == null) {
        AudioChatroomOuterClass.Receive.access$2802(receive, this.sourceProfile_);
      } else {
        AudioChatroomOuterClass.Receive.access$2802(receive, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
      } 
      singleFieldBuilderV31 = this.targetProfileBuilder_;
      if (singleFieldBuilderV31 == null) {
        AudioChatroomOuterClass.Receive.access$2902(receive, this.targetProfile_);
      } else {
        AudioChatroomOuterClass.Receive.access$2902(receive, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioChatroomOuterClass.Receive.access$3002(receive, this.extra_);
      } else {
        AudioChatroomOuterClass.Receive.access$3002(receive, (AudioMsgExtra.MsgExtra)singleFieldBuilderV3.build());
      } 
      AudioChatroomOuterClass.Receive.access$3102(receive, this.roomId_);
      AudioChatroomOuterClass.Receive.access$3202(receive, this.msgTime_);
      AudioChatroomOuterClass.Receive.access$3302(receive, this.resend_);
      onBuilt();
      return receive;
    }
    
    public Builder clear() {
      super.clear();
      this.from_ = 0;
      this.msgType_ = 0;
      this.contents_ = "";
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfile_ = null;
      } else {
        this.sourceProfile_ = null;
        this.sourceProfileBuilder_ = null;
      } 
      if (this.targetProfileBuilder_ == null) {
        this.targetProfile_ = null;
      } else {
        this.targetProfile_ = null;
        this.targetProfileBuilder_ = null;
      } 
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
      } else {
        this.extra_ = null;
        this.extraBuilder_ = null;
      } 
      this.roomId_ = 0;
      this.msgTime_ = 0L;
      this.resend_ = false;
      return this;
    }
    
    public Builder clearContents() {
      this.contents_ = AudioChatroomOuterClass.Receive.getDefaultInstance().getContents();
      onChanged();
      return this;
    }
    
    public Builder clearExtra() {
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        onChanged();
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
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
    
    public Builder clearMsgTime() {
      this.msgTime_ = 0L;
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
    
    public Builder clearResend() {
      this.resend_ = false;
      onChanged();
      return this;
    }
    
    public Builder clearRoomId() {
      this.roomId_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSourceProfile() {
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfile_ = null;
        onChanged();
        return this;
      } 
      this.sourceProfile_ = null;
      this.sourceProfileBuilder_ = null;
      return this;
    }
    
    public Builder clearTargetProfile() {
      if (this.targetProfileBuilder_ == null) {
        this.targetProfile_ = null;
        onChanged();
        return this;
      } 
      this.targetProfile_ = null;
      this.targetProfileBuilder_ = null;
      return this;
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
    
    public AudioChatroomOuterClass.Receive getDefaultInstanceForType() {
      return AudioChatroomOuterClass.Receive.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_descriptor;
    }
    
    public AudioMsgExtra.MsgExtra getExtra() {
      AudioMsgExtra.MsgExtra msgExtra;
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.MsgExtra msgExtra1 = this.extra_;
        msgExtra = msgExtra1;
        if (msgExtra1 == null)
          msgExtra = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
        return msgExtra;
      } 
      return (AudioMsgExtra.MsgExtra)msgExtra.getMessage();
    }
    
    public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
      onChanged();
      return (AudioMsgExtra.MsgExtra.Builder)getExtraFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.MsgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
      AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
      if (msgExtra2 == null)
        msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
      return msgExtra1;
    }
    
    public int getFrom() {
      return this.from_;
    }
    
    public long getMsgTime() {
      return this.msgTime_;
    }
    
    public AudioMsgType.MsgType getMsgType() {
      AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
      AudioMsgType.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public boolean getResend() {
      return this.resend_;
    }
    
    public int getRoomId() {
      return this.roomId_;
    }
    
    public AudioMsgExtra.Profile getSourceProfile() {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.Profile profile1 = this.sourceProfile_;
        profile = profile1;
        if (profile1 == null)
          profile = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile;
      } 
      return (AudioMsgExtra.Profile)profile.getMessage();
    }
    
    public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
      onChanged();
      return (AudioMsgExtra.Profile.Builder)getSourceProfileFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.Profile profile2 = this.sourceProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.Profile getTargetProfile() {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.Profile profile1 = this.targetProfile_;
        profile = profile1;
        if (profile1 == null)
          profile = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile;
      } 
      return (AudioMsgExtra.Profile)profile.getMessage();
    }
    
    public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
      onChanged();
      return (AudioMsgExtra.Profile.Builder)getTargetProfileFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.Profile profile2 = this.targetProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public boolean hasExtra() {
      return (this.extraBuilder_ != null || this.extra_ != null);
    }
    
    public boolean hasSourceProfile() {
      return (this.sourceProfileBuilder_ != null || this.sourceProfile_ != null);
    }
    
    public boolean hasTargetProfile() {
      return (this.targetProfileBuilder_ != null || this.targetProfile_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Receive.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeExtra(AudioMsgExtra.MsgExtra param1MsgExtra) {
      AudioMsgExtra.MsgExtra msgExtra;
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        msgExtra = this.extra_;
        if (msgExtra != null) {
          this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra).mergeFrom(param1MsgExtra).buildPartial();
        } else {
          this.extra_ = param1MsgExtra;
        } 
        onChanged();
        return this;
      } 
      msgExtra.mergeFrom((AbstractMessage)param1MsgExtra);
      return this;
    }
    
    public Builder mergeFrom(AudioChatroomOuterClass.Receive param1Receive) {
      if (param1Receive == AudioChatroomOuterClass.Receive.getDefaultInstance())
        return this; 
      if (param1Receive.getFrom() != 0)
        setFrom(param1Receive.getFrom()); 
      if (param1Receive.msgType_ != 0)
        setMsgTypeValue(param1Receive.getMsgTypeValue()); 
      if (!param1Receive.getContents().isEmpty()) {
        this.contents_ = param1Receive.contents_;
        onChanged();
      } 
      if (param1Receive.hasSourceProfile())
        mergeSourceProfile(param1Receive.getSourceProfile()); 
      if (param1Receive.hasTargetProfile())
        mergeTargetProfile(param1Receive.getTargetProfile()); 
      if (param1Receive.hasExtra())
        mergeExtra(param1Receive.getExtra()); 
      if (param1Receive.getRoomId() != 0)
        setRoomId(param1Receive.getRoomId()); 
      if (param1Receive.getMsgTime() != 0L)
        setMsgTime(param1Receive.getMsgTime()); 
      if (param1Receive.getResend())
        setResend(param1Receive.getResend()); 
      mergeUnknownFields(param1Receive.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AudioChatroomOuterClass.Receive receive = (AudioChatroomOuterClass.Receive)AudioChatroomOuterClass.Receive.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AudioChatroomOuterClass.Receive receive = (AudioChatroomOuterClass.Receive)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AudioChatroomOuterClass.Receive)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AudioChatroomOuterClass.Receive)
        return mergeFrom((AudioChatroomOuterClass.Receive)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeSourceProfile(AudioMsgExtra.Profile param1Profile) {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        profile = this.sourceProfile_;
        if (profile != null) {
          this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param1Profile).buildPartial();
        } else {
          this.sourceProfile_ = param1Profile;
        } 
        onChanged();
        return this;
      } 
      profile.mergeFrom((AbstractMessage)param1Profile);
      return this;
    }
    
    public Builder mergeTargetProfile(AudioMsgExtra.Profile param1Profile) {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        profile = this.targetProfile_;
        if (profile != null) {
          this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param1Profile).buildPartial();
        } else {
          this.targetProfile_ = param1Profile;
        } 
        onChanged();
        return this;
      } 
      profile.mergeFrom((AbstractMessage)param1Profile);
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
        AudioChatroomOuterClass.Receive.checkByteStringIsUtf8(param1ByteString);
        this.contents_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExtra(AudioMsgExtra.MsgExtra.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.extra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtra(AudioMsgExtra.MsgExtra param1MsgExtra) {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1MsgExtra != null) {
          this.extra_ = param1MsgExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1MsgExtra);
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
    
    public Builder setMsgTime(long param1Long) {
      this.msgTime_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setMsgType(AudioMsgType.MsgType param1MsgType) {
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
    
    public Builder setResend(boolean param1Boolean) {
      this.resend_ = param1Boolean;
      onChanged();
      return this;
    }
    
    public Builder setRoomId(int param1Int) {
      this.roomId_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSourceProfile(AudioMsgExtra.Profile.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sourceProfile_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSourceProfile(AudioMsgExtra.Profile param1Profile) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Profile != null) {
          this.sourceProfile_ = param1Profile;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Profile);
      return this;
    }
    
    public Builder setTargetProfile(AudioMsgExtra.Profile.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.targetProfile_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTargetProfile(AudioMsgExtra.Profile param1Profile) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Profile != null) {
          this.targetProfile_ = param1Profile;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Profile);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
  
  public static interface ReceiveOrBuilder extends MessageOrBuilder {
    String getContents();
    
    ByteString getContentsBytes();
    
    AudioMsgExtra.MsgExtra getExtra();
    
    AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder();
    
    int getFrom();
    
    long getMsgTime();
    
    AudioMsgType.MsgType getMsgType();
    
    int getMsgTypeValue();
    
    boolean getResend();
    
    int getRoomId();
    
    AudioMsgExtra.Profile getSourceProfile();
    
    AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder();
    
    AudioMsgExtra.Profile getTargetProfile();
    
    AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder();
    
    boolean hasExtra();
    
    boolean hasSourceProfile();
    
    boolean hasTargetProfile();
  }
  
  public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
    public static final int COMMON_FIELD_NUMBER = 1;
    
    public static final int CONTENTS_FIELD_NUMBER = 4;
    
    private static final Request DEFAULT_INSTANCE = new Request();
    
    public static final int EXTRA_FIELD_NUMBER = 7;
    
    public static final int MSG_TYPE_FIELD_NUMBER = 3;
    
    private static final Parser<Request> PARSER = (Parser<Request>)new AbstractParser<Request>() {
        public AudioChatroomOuterClass.Request parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new AudioChatroomOuterClass.Request(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int ROOM_ID_FIELD_NUMBER = 8;
    
    public static final int SEND_ANYONE_FIELD_NUMBER = 9;
    
    public static final int SOURCE_PROFILE_FIELD_NUMBER = 5;
    
    public static final int TARGET_PROFILE_FIELD_NUMBER = 6;
    
    public static final int TO_FIELD_NUMBER = 2;
    
    private static final long serialVersionUID = 0L;
    
    private CommonOuterClass.Common common_;
    
    private volatile Object contents_;
    
    private AudioMsgExtra.MsgExtra extra_;
    
    private byte memoizedIsInitialized = -1;
    
    private int msgType_;
    
    private int roomId_;
    
    private int sendAnyone_;
    
    private AudioMsgExtra.Profile sourceProfile_;
    
    private AudioMsgExtra.Profile targetProfile_;
    
    private int to_;
    
    private Request() {
      this.msgType_ = 0;
      this.contents_ = "";
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
              AudioMsgExtra.MsgExtra.Builder builder3 = null;
              AudioMsgExtra.MsgExtra.Builder builder4 = null;
              AudioMsgExtra.MsgExtra.Builder builder5 = null;
              AudioMsgExtra.MsgExtra.Builder builder2 = null;
              if (i != 10) {
                if (i != 16) {
                  if (i != 24) {
                    if (i != 34) {
                      AudioMsgExtra.Profile.Builder builder6;
                      if (i != 42) {
                        if (i != 50) {
                          if (i != 58) {
                            if (i != 64) {
                              if (i != 72) {
                                if (!parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i))
                                  continue; 
                                continue;
                              } 
                              this.sendAnyone_ = param1CodedInputStream.readInt32();
                              continue;
                            } 
                            this.roomId_ = param1CodedInputStream.readInt32();
                            continue;
                          } 
                          if (this.extra_ != null)
                            builder2 = this.extra_.toBuilder(); 
                          this.extra_ = (AudioMsgExtra.MsgExtra)param1CodedInputStream.readMessage(AudioMsgExtra.MsgExtra.parser(), param1ExtensionRegistryLite);
                          if (builder2 != null) {
                            builder2.mergeFrom(this.extra_);
                            this.extra_ = builder2.buildPartial();
                          } 
                          continue;
                        } 
                        builder2 = builder3;
                        if (this.targetProfile_ != null)
                          builder6 = this.targetProfile_.toBuilder(); 
                        this.targetProfile_ = (AudioMsgExtra.Profile)param1CodedInputStream.readMessage(AudioMsgExtra.Profile.parser(), param1ExtensionRegistryLite);
                        if (builder6 != null) {
                          builder6.mergeFrom(this.targetProfile_);
                          this.targetProfile_ = builder6.buildPartial();
                        } 
                        continue;
                      } 
                      builder2 = builder4;
                      if (this.sourceProfile_ != null)
                        builder6 = this.sourceProfile_.toBuilder(); 
                      this.sourceProfile_ = (AudioMsgExtra.Profile)param1CodedInputStream.readMessage(AudioMsgExtra.Profile.parser(), param1ExtensionRegistryLite);
                      if (builder6 != null) {
                        builder6.mergeFrom(this.sourceProfile_);
                        this.sourceProfile_ = builder6.buildPartial();
                      } 
                      continue;
                    } 
                    this.contents_ = param1CodedInputStream.readStringRequireUtf8();
                    continue;
                  } 
                  this.msgType_ = param1CodedInputStream.readEnum();
                  continue;
                } 
                this.to_ = param1CodedInputStream.readUInt32();
                continue;
              } 
              builder2 = builder5;
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
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
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
      return (hasCommon() != param1Object.hasCommon()) ? false : ((hasCommon() && !getCommon().equals(param1Object.getCommon())) ? false : ((getTo() != param1Object.getTo()) ? false : ((this.msgType_ != ((Request)param1Object).msgType_) ? false : (!getContents().equals(param1Object.getContents()) ? false : ((hasSourceProfile() != param1Object.hasSourceProfile()) ? false : ((hasSourceProfile() && !getSourceProfile().equals(param1Object.getSourceProfile())) ? false : ((hasTargetProfile() != param1Object.hasTargetProfile()) ? false : ((hasTargetProfile() && !getTargetProfile().equals(param1Object.getTargetProfile())) ? false : ((hasExtra() != param1Object.hasExtra()) ? false : ((hasExtra() && !getExtra().equals(param1Object.getExtra())) ? false : ((getRoomId() != param1Object.getRoomId()) ? false : ((getSendAnyone() != param1Object.getSendAnyone()) ? false : (!!this.unknownFields.equals(((Request)param1Object).unknownFields))))))))))))));
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
    
    public Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public AudioMsgExtra.MsgExtra getExtra() {
      AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
      AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
      if (msgExtra2 == null)
        msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
      return msgExtra1;
    }
    
    public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
      return getExtra();
    }
    
    public AudioMsgType.MsgType getMsgType() {
      AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
      AudioMsgType.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public Parser<Request> getParserForType() {
      return PARSER;
    }
    
    public int getRoomId() {
      return this.roomId_;
    }
    
    public int getSendAnyone() {
      return this.sendAnyone_;
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
      if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        j = i + CodedOutputStream.computeEnumSize(3, this.msgType_); 
      i = j;
      if (!getContentsBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(4, this.contents_); 
      j = i;
      if (this.sourceProfile_ != null)
        j = i + CodedOutputStream.computeMessageSize(5, (MessageLite)getSourceProfile()); 
      i = j;
      if (this.targetProfile_ != null)
        i = j + CodedOutputStream.computeMessageSize(6, (MessageLite)getTargetProfile()); 
      j = i;
      if (this.extra_ != null)
        j = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getExtra()); 
      k = this.roomId_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(8, k); 
      k = this.sendAnyone_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(9, k); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public AudioMsgExtra.Profile getSourceProfile() {
      AudioMsgExtra.Profile profile2 = this.sourceProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
      return getSourceProfile();
    }
    
    public AudioMsgExtra.Profile getTargetProfile() {
      AudioMsgExtra.Profile profile2 = this.targetProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
      return getTargetProfile();
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
    
    public boolean hasExtra() {
      return (this.extra_ != null);
    }
    
    public boolean hasSourceProfile() {
      return (this.sourceProfile_ != null);
    }
    
    public boolean hasTargetProfile() {
      return (this.targetProfile_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasCommon())
        i = (j * 37 + 1) * 53 + getCommon().hashCode(); 
      j = (((((i * 37 + 2) * 53 + getTo()) * 37 + 3) * 53 + this.msgType_) * 37 + 4) * 53 + getContents().hashCode();
      i = j;
      if (hasSourceProfile())
        i = (j * 37 + 5) * 53 + getSourceProfile().hashCode(); 
      j = i;
      if (hasTargetProfile())
        j = (i * 37 + 6) * 53 + getTargetProfile().hashCode(); 
      i = j;
      if (hasExtra())
        i = (j * 37 + 7) * 53 + getExtra().hashCode(); 
      i = ((((i * 37 + 8) * 53 + getRoomId()) * 37 + 9) * 53 + getSendAnyone()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
      if (this.msgType_ != AudioMsgType.MsgType.UNKNOWN_MSG_TYPE.getNumber())
        param1CodedOutputStream.writeEnum(3, this.msgType_); 
      if (!getContentsBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 4, this.contents_); 
      if (this.sourceProfile_ != null)
        param1CodedOutputStream.writeMessage(5, (MessageLite)getSourceProfile()); 
      if (this.targetProfile_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getTargetProfile()); 
      if (this.extra_ != null)
        param1CodedOutputStream.writeMessage(7, (MessageLite)getExtra()); 
      i = this.roomId_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(8, i); 
      i = this.sendAnyone_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(9, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AudioChatroomOuterClass.RequestOrBuilder {
      private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
      
      private CommonOuterClass.Common common_;
      
      private Object contents_ = "";
      
      private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
      
      private AudioMsgExtra.MsgExtra extra_;
      
      private int msgType_ = 0;
      
      private int roomId_;
      
      private int sendAnyone_;
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
      
      private AudioMsgExtra.Profile sourceProfile_;
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
      
      private AudioMsgExtra.Profile targetProfile_;
      
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
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
        if (this.extraBuilder_ == null) {
          this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.extra_ = null;
        } 
        return this.extraBuilder_;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSourceProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.sourceProfile_ = null;
        } 
        return this.sourceProfileBuilder_;
      }
      
      private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
        if (this.targetProfileBuilder_ == null) {
          this.targetProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTargetProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.targetProfile_ = null;
        } 
        return this.targetProfileBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        AudioChatroomOuterClass.Request.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public AudioChatroomOuterClass.Request build() {
        AudioChatroomOuterClass.Request request = buildPartial();
        if (request.isInitialized())
          return request; 
        throw newUninitializedMessageException(request);
      }
      
      public AudioChatroomOuterClass.Request buildPartial() {
        AudioChatroomOuterClass.Request request = new AudioChatroomOuterClass.Request(this);
        SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV32 = this.commonBuilder_;
        if (singleFieldBuilderV32 == null) {
          AudioChatroomOuterClass.Request.access$602(request, this.common_);
        } else {
          AudioChatroomOuterClass.Request.access$602(request, (CommonOuterClass.Common)singleFieldBuilderV32.build());
        } 
        AudioChatroomOuterClass.Request.access$702(request, this.to_);
        AudioChatroomOuterClass.Request.access$802(request, this.msgType_);
        AudioChatroomOuterClass.Request.access$902(request, this.contents_);
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV31 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV31 == null) {
          AudioChatroomOuterClass.Request.access$1002(request, this.sourceProfile_);
        } else {
          AudioChatroomOuterClass.Request.access$1002(request, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
        } 
        singleFieldBuilderV31 = this.targetProfileBuilder_;
        if (singleFieldBuilderV31 == null) {
          AudioChatroomOuterClass.Request.access$1102(request, this.targetProfile_);
        } else {
          AudioChatroomOuterClass.Request.access$1102(request, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioChatroomOuterClass.Request.access$1202(request, this.extra_);
        } else {
          AudioChatroomOuterClass.Request.access$1202(request, (AudioMsgExtra.MsgExtra)singleFieldBuilderV3.build());
        } 
        AudioChatroomOuterClass.Request.access$1302(request, this.roomId_);
        AudioChatroomOuterClass.Request.access$1402(request, this.sendAnyone_);
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
        this.contents_ = "";
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfile_ = null;
        } else {
          this.sourceProfile_ = null;
          this.sourceProfileBuilder_ = null;
        } 
        if (this.targetProfileBuilder_ == null) {
          this.targetProfile_ = null;
        } else {
          this.targetProfile_ = null;
          this.targetProfileBuilder_ = null;
        } 
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
        } else {
          this.extra_ = null;
          this.extraBuilder_ = null;
        } 
        this.roomId_ = 0;
        this.sendAnyone_ = 0;
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
      
      public Builder clearContents() {
        this.contents_ = AudioChatroomOuterClass.Request.getDefaultInstance().getContents();
        onChanged();
        return this;
      }
      
      public Builder clearExtra() {
        if (this.extraBuilder_ == null) {
          this.extra_ = null;
          onChanged();
          return this;
        } 
        this.extra_ = null;
        this.extraBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearMsgType() {
        this.msgType_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearRoomId() {
        this.roomId_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSendAnyone() {
        this.sendAnyone_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearSourceProfile() {
        if (this.sourceProfileBuilder_ == null) {
          this.sourceProfile_ = null;
          onChanged();
          return this;
        } 
        this.sourceProfile_ = null;
        this.sourceProfileBuilder_ = null;
        return this;
      }
      
      public Builder clearTargetProfile() {
        if (this.targetProfileBuilder_ == null) {
          this.targetProfile_ = null;
          onChanged();
          return this;
        } 
        this.targetProfile_ = null;
        this.targetProfileBuilder_ = null;
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
      
      public AudioChatroomOuterClass.Request getDefaultInstanceForType() {
        return AudioChatroomOuterClass.Request.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
      }
      
      public AudioMsgExtra.MsgExtra getExtra() {
        AudioMsgExtra.MsgExtra msgExtra;
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.MsgExtra msgExtra1 = this.extra_;
          msgExtra = msgExtra1;
          if (msgExtra1 == null)
            msgExtra = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
          return msgExtra;
        } 
        return (AudioMsgExtra.MsgExtra)msgExtra.getMessage();
      }
      
      public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
        onChanged();
        return (AudioMsgExtra.MsgExtra.Builder)getExtraFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.MsgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
        AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
        if (msgExtra2 == null)
          msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
        return msgExtra1;
      }
      
      public AudioMsgType.MsgType getMsgType() {
        AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
        AudioMsgType.MsgType msgType1 = msgType2;
        if (msgType2 == null)
          msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
        return msgType1;
      }
      
      public int getMsgTypeValue() {
        return this.msgType_;
      }
      
      public int getRoomId() {
        return this.roomId_;
      }
      
      public int getSendAnyone() {
        return this.sendAnyone_;
      }
      
      public AudioMsgExtra.Profile getSourceProfile() {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.Profile profile1 = this.sourceProfile_;
          profile = profile1;
          if (profile1 == null)
            profile = AudioMsgExtra.Profile.getDefaultInstance(); 
          return profile;
        } 
        return (AudioMsgExtra.Profile)profile.getMessage();
      }
      
      public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
        onChanged();
        return (AudioMsgExtra.Profile.Builder)getSourceProfileFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.Profile profile2 = this.sourceProfile_;
        AudioMsgExtra.Profile profile1 = profile2;
        if (profile2 == null)
          profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile1;
      }
      
      public AudioMsgExtra.Profile getTargetProfile() {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          AudioMsgExtra.Profile profile1 = this.targetProfile_;
          profile = profile1;
          if (profile1 == null)
            profile = AudioMsgExtra.Profile.getDefaultInstance(); 
          return profile;
        } 
        return (AudioMsgExtra.Profile)profile.getMessage();
      }
      
      public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
        onChanged();
        return (AudioMsgExtra.Profile.Builder)getTargetProfileFieldBuilder().getBuilder();
      }
      
      public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 != null)
          return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        AudioMsgExtra.Profile profile2 = this.targetProfile_;
        AudioMsgExtra.Profile profile1 = profile2;
        if (profile2 == null)
          profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile1;
      }
      
      public int getTo() {
        return this.to_;
      }
      
      public boolean hasCommon() {
        return (this.commonBuilder_ != null || this.common_ != null);
      }
      
      public boolean hasExtra() {
        return (this.extraBuilder_ != null || this.extra_ != null);
      }
      
      public boolean hasSourceProfile() {
        return (this.sourceProfileBuilder_ != null || this.sourceProfile_ != null);
      }
      
      public boolean hasTargetProfile() {
        return (this.targetProfileBuilder_ != null || this.targetProfile_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Request.class, Builder.class);
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
      
      public Builder mergeExtra(AudioMsgExtra.MsgExtra param2MsgExtra) {
        AudioMsgExtra.MsgExtra msgExtra;
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          msgExtra = this.extra_;
          if (msgExtra != null) {
            this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra).mergeFrom(param2MsgExtra).buildPartial();
          } else {
            this.extra_ = param2MsgExtra;
          } 
          onChanged();
          return this;
        } 
        msgExtra.mergeFrom((AbstractMessage)param2MsgExtra);
        return this;
      }
      
      public Builder mergeFrom(AudioChatroomOuterClass.Request param2Request) {
        if (param2Request == AudioChatroomOuterClass.Request.getDefaultInstance())
          return this; 
        if (param2Request.hasCommon())
          mergeCommon(param2Request.getCommon()); 
        if (param2Request.getTo() != 0)
          setTo(param2Request.getTo()); 
        if (param2Request.msgType_ != 0)
          setMsgTypeValue(param2Request.getMsgTypeValue()); 
        if (!param2Request.getContents().isEmpty()) {
          this.contents_ = param2Request.contents_;
          onChanged();
        } 
        if (param2Request.hasSourceProfile())
          mergeSourceProfile(param2Request.getSourceProfile()); 
        if (param2Request.hasTargetProfile())
          mergeTargetProfile(param2Request.getTargetProfile()); 
        if (param2Request.hasExtra())
          mergeExtra(param2Request.getExtra()); 
        if (param2Request.getRoomId() != 0)
          setRoomId(param2Request.getRoomId()); 
        if (param2Request.getSendAnyone() != 0)
          setSendAnyone(param2Request.getSendAnyone()); 
        mergeUnknownFields(param2Request.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          AudioChatroomOuterClass.Request request = (AudioChatroomOuterClass.Request)AudioChatroomOuterClass.Request.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          AudioChatroomOuterClass.Request request = (AudioChatroomOuterClass.Request)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((AudioChatroomOuterClass.Request)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof AudioChatroomOuterClass.Request)
          return mergeFrom((AudioChatroomOuterClass.Request)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeSourceProfile(AudioMsgExtra.Profile param2Profile) {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          profile = this.sourceProfile_;
          if (profile != null) {
            this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param2Profile).buildPartial();
          } else {
            this.sourceProfile_ = param2Profile;
          } 
          onChanged();
          return this;
        } 
        profile.mergeFrom((AbstractMessage)param2Profile);
        return this;
      }
      
      public Builder mergeTargetProfile(AudioMsgExtra.Profile param2Profile) {
        AudioMsgExtra.Profile profile;
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          profile = this.targetProfile_;
          if (profile != null) {
            this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param2Profile).buildPartial();
          } else {
            this.targetProfile_ = param2Profile;
          } 
          onChanged();
          return this;
        } 
        profile.mergeFrom((AbstractMessage)param2Profile);
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
          AudioChatroomOuterClass.Request.checkByteStringIsUtf8(param2ByteString);
          this.contents_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setExtra(AudioMsgExtra.MsgExtra.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.extra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setExtra(AudioMsgExtra.MsgExtra param2MsgExtra) {
        SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2MsgExtra != null) {
            this.extra_ = param2MsgExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2MsgExtra);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setMsgType(AudioMsgType.MsgType param2MsgType) {
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
      
      public Builder setRoomId(int param2Int) {
        this.roomId_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSendAnyone(int param2Int) {
        this.sendAnyone_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setSourceProfile(AudioMsgExtra.Profile.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.sourceProfile_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSourceProfile(AudioMsgExtra.Profile param2Profile) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Profile != null) {
            this.sourceProfile_ = param2Profile;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Profile);
        return this;
      }
      
      public Builder setTargetProfile(AudioMsgExtra.Profile.Builder param2Builder) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.targetProfile_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setTargetProfile(AudioMsgExtra.Profile param2Profile) {
        SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2Profile != null) {
            this.targetProfile_ = param2Profile;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Profile);
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
    public AudioChatroomOuterClass.Request parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new AudioChatroomOuterClass.Request(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Request.Builder> implements RequestOrBuilder {
    private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
    
    private CommonOuterClass.Common common_;
    
    private Object contents_ = "";
    
    private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> extraBuilder_;
    
    private AudioMsgExtra.MsgExtra extra_;
    
    private int msgType_ = 0;
    
    private int roomId_;
    
    private int sendAnyone_;
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> sourceProfileBuilder_;
    
    private AudioMsgExtra.Profile sourceProfile_;
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> targetProfileBuilder_;
    
    private AudioMsgExtra.Profile targetProfile_;
    
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
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> getExtraFieldBuilder() {
      if (this.extraBuilder_ == null) {
        this.extraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.extra_ = null;
      } 
      return this.extraBuilder_;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getSourceProfileFieldBuilder() {
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSourceProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sourceProfile_ = null;
      } 
      return this.sourceProfileBuilder_;
    }
    
    private SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> getTargetProfileFieldBuilder() {
      if (this.targetProfileBuilder_ == null) {
        this.targetProfileBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTargetProfile(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.targetProfile_ = null;
      } 
      return this.targetProfileBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      AudioChatroomOuterClass.Request.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AudioChatroomOuterClass.Request build() {
      AudioChatroomOuterClass.Request request = buildPartial();
      if (request.isInitialized())
        return request; 
      throw newUninitializedMessageException(request);
    }
    
    public AudioChatroomOuterClass.Request buildPartial() {
      AudioChatroomOuterClass.Request request = new AudioChatroomOuterClass.Request(this);
      SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV32 = this.commonBuilder_;
      if (singleFieldBuilderV32 == null) {
        AudioChatroomOuterClass.Request.access$602(request, this.common_);
      } else {
        AudioChatroomOuterClass.Request.access$602(request, (CommonOuterClass.Common)singleFieldBuilderV32.build());
      } 
      AudioChatroomOuterClass.Request.access$702(request, this.to_);
      AudioChatroomOuterClass.Request.access$802(request, this.msgType_);
      AudioChatroomOuterClass.Request.access$902(request, this.contents_);
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV31 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV31 == null) {
        AudioChatroomOuterClass.Request.access$1002(request, this.sourceProfile_);
      } else {
        AudioChatroomOuterClass.Request.access$1002(request, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
      } 
      singleFieldBuilderV31 = this.targetProfileBuilder_;
      if (singleFieldBuilderV31 == null) {
        AudioChatroomOuterClass.Request.access$1102(request, this.targetProfile_);
      } else {
        AudioChatroomOuterClass.Request.access$1102(request, (AudioMsgExtra.Profile)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioChatroomOuterClass.Request.access$1202(request, this.extra_);
      } else {
        AudioChatroomOuterClass.Request.access$1202(request, (AudioMsgExtra.MsgExtra)singleFieldBuilderV3.build());
      } 
      AudioChatroomOuterClass.Request.access$1302(request, this.roomId_);
      AudioChatroomOuterClass.Request.access$1402(request, this.sendAnyone_);
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
      this.contents_ = "";
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfile_ = null;
      } else {
        this.sourceProfile_ = null;
        this.sourceProfileBuilder_ = null;
      } 
      if (this.targetProfileBuilder_ == null) {
        this.targetProfile_ = null;
      } else {
        this.targetProfile_ = null;
        this.targetProfileBuilder_ = null;
      } 
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
      } else {
        this.extra_ = null;
        this.extraBuilder_ = null;
      } 
      this.roomId_ = 0;
      this.sendAnyone_ = 0;
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
    
    public Builder clearContents() {
      this.contents_ = AudioChatroomOuterClass.Request.getDefaultInstance().getContents();
      onChanged();
      return this;
    }
    
    public Builder clearExtra() {
      if (this.extraBuilder_ == null) {
        this.extra_ = null;
        onChanged();
        return this;
      } 
      this.extra_ = null;
      this.extraBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearMsgType() {
      this.msgType_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRoomId() {
      this.roomId_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSendAnyone() {
      this.sendAnyone_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearSourceProfile() {
      if (this.sourceProfileBuilder_ == null) {
        this.sourceProfile_ = null;
        onChanged();
        return this;
      } 
      this.sourceProfile_ = null;
      this.sourceProfileBuilder_ = null;
      return this;
    }
    
    public Builder clearTargetProfile() {
      if (this.targetProfileBuilder_ == null) {
        this.targetProfile_ = null;
        onChanged();
        return this;
      } 
      this.targetProfile_ = null;
      this.targetProfileBuilder_ = null;
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
    
    public AudioChatroomOuterClass.Request getDefaultInstanceForType() {
      return AudioChatroomOuterClass.Request.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_descriptor;
    }
    
    public AudioMsgExtra.MsgExtra getExtra() {
      AudioMsgExtra.MsgExtra msgExtra;
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.MsgExtra msgExtra1 = this.extra_;
        msgExtra = msgExtra1;
        if (msgExtra1 == null)
          msgExtra = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
        return msgExtra;
      } 
      return (AudioMsgExtra.MsgExtra)msgExtra.getMessage();
    }
    
    public AudioMsgExtra.MsgExtra.Builder getExtraBuilder() {
      onChanged();
      return (AudioMsgExtra.MsgExtra.Builder)getExtraFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.MsgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.MsgExtra msgExtra2 = this.extra_;
      AudioMsgExtra.MsgExtra msgExtra1 = msgExtra2;
      if (msgExtra2 == null)
        msgExtra1 = AudioMsgExtra.MsgExtra.getDefaultInstance(); 
      return msgExtra1;
    }
    
    public AudioMsgType.MsgType getMsgType() {
      AudioMsgType.MsgType msgType2 = AudioMsgType.MsgType.valueOf(this.msgType_);
      AudioMsgType.MsgType msgType1 = msgType2;
      if (msgType2 == null)
        msgType1 = AudioMsgType.MsgType.UNRECOGNIZED; 
      return msgType1;
    }
    
    public int getMsgTypeValue() {
      return this.msgType_;
    }
    
    public int getRoomId() {
      return this.roomId_;
    }
    
    public int getSendAnyone() {
      return this.sendAnyone_;
    }
    
    public AudioMsgExtra.Profile getSourceProfile() {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.Profile profile1 = this.sourceProfile_;
        profile = profile1;
        if (profile1 == null)
          profile = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile;
      } 
      return (AudioMsgExtra.Profile)profile.getMessage();
    }
    
    public AudioMsgExtra.Profile.Builder getSourceProfileBuilder() {
      onChanged();
      return (AudioMsgExtra.Profile.Builder)getSourceProfileFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.Profile profile2 = this.sourceProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public AudioMsgExtra.Profile getTargetProfile() {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        AudioMsgExtra.Profile profile1 = this.targetProfile_;
        profile = profile1;
        if (profile1 == null)
          profile = AudioMsgExtra.Profile.getDefaultInstance(); 
        return profile;
      } 
      return (AudioMsgExtra.Profile)profile.getMessage();
    }
    
    public AudioMsgExtra.Profile.Builder getTargetProfileBuilder() {
      onChanged();
      return (AudioMsgExtra.Profile.Builder)getTargetProfileFieldBuilder().getBuilder();
    }
    
    public AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder() {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 != null)
        return (AudioMsgExtra.ProfileOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      AudioMsgExtra.Profile profile2 = this.targetProfile_;
      AudioMsgExtra.Profile profile1 = profile2;
      if (profile2 == null)
        profile1 = AudioMsgExtra.Profile.getDefaultInstance(); 
      return profile1;
    }
    
    public int getTo() {
      return this.to_;
    }
    
    public boolean hasCommon() {
      return (this.commonBuilder_ != null || this.common_ != null);
    }
    
    public boolean hasExtra() {
      return (this.extraBuilder_ != null || this.extra_ != null);
    }
    
    public boolean hasSourceProfile() {
      return (this.sourceProfileBuilder_ != null || this.sourceProfile_ != null);
    }
    
    public boolean hasTargetProfile() {
      return (this.targetProfileBuilder_ != null || this.targetProfile_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Request.class, Builder.class);
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
    
    public Builder mergeExtra(AudioMsgExtra.MsgExtra param1MsgExtra) {
      AudioMsgExtra.MsgExtra msgExtra;
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        msgExtra = this.extra_;
        if (msgExtra != null) {
          this.extra_ = AudioMsgExtra.MsgExtra.newBuilder(msgExtra).mergeFrom(param1MsgExtra).buildPartial();
        } else {
          this.extra_ = param1MsgExtra;
        } 
        onChanged();
        return this;
      } 
      msgExtra.mergeFrom((AbstractMessage)param1MsgExtra);
      return this;
    }
    
    public Builder mergeFrom(AudioChatroomOuterClass.Request param1Request) {
      if (param1Request == AudioChatroomOuterClass.Request.getDefaultInstance())
        return this; 
      if (param1Request.hasCommon())
        mergeCommon(param1Request.getCommon()); 
      if (param1Request.getTo() != 0)
        setTo(param1Request.getTo()); 
      if (param1Request.msgType_ != 0)
        setMsgTypeValue(param1Request.getMsgTypeValue()); 
      if (!param1Request.getContents().isEmpty()) {
        this.contents_ = param1Request.contents_;
        onChanged();
      } 
      if (param1Request.hasSourceProfile())
        mergeSourceProfile(param1Request.getSourceProfile()); 
      if (param1Request.hasTargetProfile())
        mergeTargetProfile(param1Request.getTargetProfile()); 
      if (param1Request.hasExtra())
        mergeExtra(param1Request.getExtra()); 
      if (param1Request.getRoomId() != 0)
        setRoomId(param1Request.getRoomId()); 
      if (param1Request.getSendAnyone() != 0)
        setSendAnyone(param1Request.getSendAnyone()); 
      mergeUnknownFields(param1Request.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        AudioChatroomOuterClass.Request request = (AudioChatroomOuterClass.Request)AudioChatroomOuterClass.Request.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AudioChatroomOuterClass.Request request = (AudioChatroomOuterClass.Request)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AudioChatroomOuterClass.Request)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AudioChatroomOuterClass.Request)
        return mergeFrom((AudioChatroomOuterClass.Request)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeSourceProfile(AudioMsgExtra.Profile param1Profile) {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        profile = this.sourceProfile_;
        if (profile != null) {
          this.sourceProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param1Profile).buildPartial();
        } else {
          this.sourceProfile_ = param1Profile;
        } 
        onChanged();
        return this;
      } 
      profile.mergeFrom((AbstractMessage)param1Profile);
      return this;
    }
    
    public Builder mergeTargetProfile(AudioMsgExtra.Profile param1Profile) {
      AudioMsgExtra.Profile profile;
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        profile = this.targetProfile_;
        if (profile != null) {
          this.targetProfile_ = AudioMsgExtra.Profile.newBuilder(profile).mergeFrom(param1Profile).buildPartial();
        } else {
          this.targetProfile_ = param1Profile;
        } 
        onChanged();
        return this;
      } 
      profile.mergeFrom((AbstractMessage)param1Profile);
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
        AudioChatroomOuterClass.Request.checkByteStringIsUtf8(param1ByteString);
        this.contents_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExtra(AudioMsgExtra.MsgExtra.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.extra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setExtra(AudioMsgExtra.MsgExtra param1MsgExtra) {
      SingleFieldBuilderV3<AudioMsgExtra.MsgExtra, AudioMsgExtra.MsgExtra.Builder, AudioMsgExtra.MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1MsgExtra != null) {
          this.extra_ = param1MsgExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1MsgExtra);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setMsgType(AudioMsgType.MsgType param1MsgType) {
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
    
    public Builder setRoomId(int param1Int) {
      this.roomId_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSendAnyone(int param1Int) {
      this.sendAnyone_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setSourceProfile(AudioMsgExtra.Profile.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sourceProfile_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSourceProfile(AudioMsgExtra.Profile param1Profile) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.sourceProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Profile != null) {
          this.sourceProfile_ = param1Profile;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Profile);
      return this;
    }
    
    public Builder setTargetProfile(AudioMsgExtra.Profile.Builder param1Builder) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.targetProfile_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTargetProfile(AudioMsgExtra.Profile param1Profile) {
      SingleFieldBuilderV3<AudioMsgExtra.Profile, AudioMsgExtra.Profile.Builder, AudioMsgExtra.ProfileOrBuilder> singleFieldBuilderV3 = this.targetProfileBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1Profile != null) {
          this.targetProfile_ = param1Profile;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Profile);
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
    CommonOuterClass.Common getCommon();
    
    CommonOuterClass.CommonOrBuilder getCommonOrBuilder();
    
    String getContents();
    
    ByteString getContentsBytes();
    
    AudioMsgExtra.MsgExtra getExtra();
    
    AudioMsgExtra.MsgExtraOrBuilder getExtraOrBuilder();
    
    AudioMsgType.MsgType getMsgType();
    
    int getMsgTypeValue();
    
    int getRoomId();
    
    int getSendAnyone();
    
    AudioMsgExtra.Profile getSourceProfile();
    
    AudioMsgExtra.ProfileOrBuilder getSourceProfileOrBuilder();
    
    AudioMsgExtra.Profile getTargetProfile();
    
    AudioMsgExtra.ProfileOrBuilder getTargetProfileOrBuilder();
    
    int getTo();
    
    boolean hasCommon();
    
    boolean hasExtra();
    
    boolean hasSourceProfile();
    
    boolean hasTargetProfile();
  }
  
  public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    
    private static final Response DEFAULT_INSTANCE = new Response();
    
    public static final int MESSAGE_FIELD_NUMBER = 2;
    
    private static final Parser<Response> PARSER = (Parser<Response>)new AbstractParser<Response>() {
        public AudioChatroomOuterClass.Response parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new AudioChatroomOuterClass.Response(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int REQUEST_ID_FIELD_NUMBER = 3;
    
    public static final int REQUEST_TIME_FIELD_NUMBER = 4;
    
    public static final int RESPONSE_TIME_FIELD_NUMBER = 5;
    
    private static final long serialVersionUID = 0L;
    
    private int code_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object message_;
    
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
                  if (i != 26) {
                    if (i != 32) {
                      if (i != 40) {
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
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
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
      return (this.code_ != ((Response)param1Object).code_) ? false : (!getMessage().equals(param1Object.getMessage()) ? false : (!getRequestId().equals(param1Object.getRequestId()) ? false : ((getRequestTime() != param1Object.getRequestTime()) ? false : ((getResponseTime() != param1Object.getResponseTime()) ? false : (!!this.unknownFields.equals(((Response)param1Object).unknownFields))))));
    }
    
    public AudioCode.Code getCode() {
      AudioCode.Code code2 = AudioCode.Code.valueOf(this.code_);
      AudioCode.Code code1 = code2;
      if (code2 == null)
        code1 = AudioCode.Code.UNRECOGNIZED; 
      return code1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public Response getDefaultInstanceForType() {
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
      int j = 0;
      if (this.code_ != AudioCode.Code.AUDIO_SEND_SUCCESS.getNumber())
        j = 0 + CodedOutputStream.computeEnumSize(1, this.code_); 
      i = j;
      if (!getMessageBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(2, this.message_); 
      j = i;
      if (!getRequestIdBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(3, this.requestId_); 
      long l = this.requestTime_;
      i = j;
      if (l != 0L)
        i = j + CodedOutputStream.computeInt64Size(4, l); 
      l = this.responseTime_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
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
      int i = (((((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + this.code_) * 37 + 2) * 53 + getMessage().hashCode()) * 37 + 3) * 53 + getRequestId().hashCode()) * 37 + 4) * 53 + Internal.hashLong(getRequestTime())) * 37 + 5) * 53 + Internal.hashLong(getResponseTime())) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
      if (this.code_ != AudioCode.Code.AUDIO_SEND_SUCCESS.getNumber())
        param1CodedOutputStream.writeEnum(1, this.code_); 
      if (!getMessageBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.message_); 
      if (!getRequestIdBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 3, this.requestId_); 
      long l = this.requestTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(4, l); 
      l = this.responseTime_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AudioChatroomOuterClass.ResponseOrBuilder {
      private int code_ = 0;
      
      private Object message_ = "";
      
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
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        AudioChatroomOuterClass.Response.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public AudioChatroomOuterClass.Response build() {
        AudioChatroomOuterClass.Response response = buildPartial();
        if (response.isInitialized())
          return response; 
        throw newUninitializedMessageException(response);
      }
      
      public AudioChatroomOuterClass.Response buildPartial() {
        AudioChatroomOuterClass.Response response = new AudioChatroomOuterClass.Response(this);
        AudioChatroomOuterClass.Response.access$4402(response, this.code_);
        AudioChatroomOuterClass.Response.access$4502(response, this.message_);
        AudioChatroomOuterClass.Response.access$4602(response, this.requestId_);
        AudioChatroomOuterClass.Response.access$4702(response, this.requestTime_);
        AudioChatroomOuterClass.Response.access$4802(response, this.responseTime_);
        onBuilt();
        return response;
      }
      
      public Builder clear() {
        super.clear();
        this.code_ = 0;
        this.message_ = "";
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
        this.message_ = AudioChatroomOuterClass.Response.getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearRequestId() {
        this.requestId_ = AudioChatroomOuterClass.Response.getDefaultInstance().getRequestId();
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
      
      public AudioCode.Code getCode() {
        AudioCode.Code code2 = AudioCode.Code.valueOf(this.code_);
        AudioCode.Code code1 = code2;
        if (code2 == null)
          code1 = AudioCode.Code.UNRECOGNIZED; 
        return code1;
      }
      
      public int getCodeValue() {
        return this.code_;
      }
      
      public AudioChatroomOuterClass.Response getDefaultInstanceForType() {
        return AudioChatroomOuterClass.Response.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
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
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Response.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(AudioChatroomOuterClass.Response param2Response) {
        if (param2Response == AudioChatroomOuterClass.Response.getDefaultInstance())
          return this; 
        if (param2Response.code_ != 0)
          setCodeValue(param2Response.getCodeValue()); 
        if (!param2Response.getMessage().isEmpty()) {
          this.message_ = param2Response.message_;
          onChanged();
        } 
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
          AudioChatroomOuterClass.Response response = (AudioChatroomOuterClass.Response)AudioChatroomOuterClass.Response.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          AudioChatroomOuterClass.Response response = (AudioChatroomOuterClass.Response)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((AudioChatroomOuterClass.Response)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof AudioChatroomOuterClass.Response)
          return mergeFrom((AudioChatroomOuterClass.Response)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setCode(AudioCode.Code param2Code) {
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
          AudioChatroomOuterClass.Response.checkByteStringIsUtf8(param2ByteString);
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
          AudioChatroomOuterClass.Response.checkByteStringIsUtf8(param2ByteString);
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
    public AudioChatroomOuterClass.Response parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new AudioChatroomOuterClass.Response(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Response.Builder> implements ResponseOrBuilder {
    private int code_ = 0;
    
    private Object message_ = "";
    
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
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      AudioChatroomOuterClass.Response.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public AudioChatroomOuterClass.Response build() {
      AudioChatroomOuterClass.Response response = buildPartial();
      if (response.isInitialized())
        return response; 
      throw newUninitializedMessageException(response);
    }
    
    public AudioChatroomOuterClass.Response buildPartial() {
      AudioChatroomOuterClass.Response response = new AudioChatroomOuterClass.Response(this);
      AudioChatroomOuterClass.Response.access$4402(response, this.code_);
      AudioChatroomOuterClass.Response.access$4502(response, this.message_);
      AudioChatroomOuterClass.Response.access$4602(response, this.requestId_);
      AudioChatroomOuterClass.Response.access$4702(response, this.requestTime_);
      AudioChatroomOuterClass.Response.access$4802(response, this.responseTime_);
      onBuilt();
      return response;
    }
    
    public Builder clear() {
      super.clear();
      this.code_ = 0;
      this.message_ = "";
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
      this.message_ = AudioChatroomOuterClass.Response.getDefaultInstance().getMessage();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearRequestId() {
      this.requestId_ = AudioChatroomOuterClass.Response.getDefaultInstance().getRequestId();
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
    
    public AudioCode.Code getCode() {
      AudioCode.Code code2 = AudioCode.Code.valueOf(this.code_);
      AudioCode.Code code1 = code2;
      if (code2 == null)
        code1 = AudioCode.Code.UNRECOGNIZED; 
      return code1;
    }
    
    public int getCodeValue() {
      return this.code_;
    }
    
    public AudioChatroomOuterClass.Response getDefaultInstanceForType() {
      return AudioChatroomOuterClass.Response.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_descriptor;
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
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return AudioChatroomOuterClass.internal_static_com_blued_im_audio_chatroom_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(AudioChatroomOuterClass.Response.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(AudioChatroomOuterClass.Response param1Response) {
      if (param1Response == AudioChatroomOuterClass.Response.getDefaultInstance())
        return this; 
      if (param1Response.code_ != 0)
        setCodeValue(param1Response.getCodeValue()); 
      if (!param1Response.getMessage().isEmpty()) {
        this.message_ = param1Response.message_;
        onChanged();
      } 
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
        AudioChatroomOuterClass.Response response = (AudioChatroomOuterClass.Response)AudioChatroomOuterClass.Response.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        AudioChatroomOuterClass.Response response = (AudioChatroomOuterClass.Response)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((AudioChatroomOuterClass.Response)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof AudioChatroomOuterClass.Response)
        return mergeFrom((AudioChatroomOuterClass.Response)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setCode(AudioCode.Code param1Code) {
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
        AudioChatroomOuterClass.Response.checkByteStringIsUtf8(param1ByteString);
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
        AudioChatroomOuterClass.Response.checkByteStringIsUtf8(param1ByteString);
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
    AudioCode.Code getCode();
    
    int getCodeValue();
    
    String getMessage();
    
    ByteString getMessageBytes();
    
    String getRequestId();
    
    ByteString getRequestIdBytes();
    
    long getRequestTime();
    
    long getResponseTime();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\audio_chatroom\AudioChatroomOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */