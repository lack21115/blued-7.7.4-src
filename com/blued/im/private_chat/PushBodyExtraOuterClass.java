package com.blued.im.private_chat;

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

public final class PushBodyExtraOuterClass {
  private static Descriptors.FileDescriptor descriptor;
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor, new String[] { 
        "MsgSource", "SecureNotify", "TextExtra", "ImgExtra", "MsgReceiveFrom", "LocationExtra", "VideoExtra", "GroupCardExtra", "LiveShareExtra", "ImagetextExtra", 
        "HidenAlbumExtra", "ShareExtra", "VipExtra", "GiftExtra", "SysNoticeExtra", "VideoCallingExtra", "VideoEndExtra", "FeedShareExtra", "SayHiExtra", "VoiceRoomShareExtra", 
        "LiveShareInternationalExtra", "DoodleShareExtra", "GroupNotice" });
  
  static {
    MsgBodyExtraOuterClass.getDescriptor();
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  static {
    Descriptors.FileDescriptor fileDescriptor = MsgBodyExtraOuterClass.getDescriptor();
    descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\023PushBodyExtra.proto\022\031com.blued.im.private_chat\032\022MsgBodyExtra.proto\"è\013\n\rPushBodyExtra\0227\n\tmsgSource\030\001 \001(\0132$.com.blued.im.private_chat.MsgSource\022=\n\fsecureNotify\030\002 \001(\0132'.com.blued.im.private_chat.SecureNotify\0228\n\ntext_extra\030\003 \001(\0132$.com.blued.im.private_chat.TextExtra\0226\n\timg_extra\030\004 \001(\0132#.com.blued.im.private_chat.ImgExtra\022\030\n\020msg_receive_from\030\005 \001(\003\022@\n\016location_extra\030\006 \001(\0132(.com.blued.im.private_chat.LocationExtra\022:\n\013video_extra\030\007 \001(\0132%.com.blued.im.private_chat.VideoExtra\022C\n\020group_card_extra\030\b \001(\0132).com.blued.im.private_chat.GroupCardExtra\022C\n\020live_share_extra\030\t \001(\0132).com.blued.im.private_chat.LiveShareExtra\022B\n\017imagetext_extra\030\n \001(\0132).com.blued.im.private_chat.ImageTextExtra\022E\n\021hiden_album_extra\030\013 \001(\0132*.com.blued.im.private_chat.HidenAlbumExtra\022:\n\013share_extra\030\f \001(\0132%.com.blued.im.private_chat.ShareExtra\0226\n\tvip_extra\030\r \001(\0132#.com.blued.im.private_chat.VipExtra\0228\n\ngift_extra\030\016 \001(\0132$.com.blued.im.private_chat.GiftExtra\022C\n\020sys_notice_extra\030\017 \001(\0132).com.blued.im.private_chat.SysNoticeExtra\022M\n\023video_calling_extra\030\020 \001(\01320.com.blued.im.private_chat.VideoChatCallingExtra\022E\n\017video_end_extra\030\021 \001(\0132,.com.blued.im.private_chat.VideoChatEndExtra\022C\n\020feed_share_extra\030\022 \001(\0132).com.blued.im.private_chat.FeedShareExtra\022;\n\fsay_hi_extra\030\023 \001(\0132%.com.blued.im.private_chat.SayHiExtra\022N\n\026voice_room_share_extra\030\024 \001(\0132..com.blued.im.private_chat.VoiceRoomShareExtra\022^\n\036live_share_international_extra\030\025 \001(\01326.com.blued.im.private_chat.LiveShareInternationalExtra\022G\n\022doodle_share_extra\030\026 \001(\0132+.com.blued.im.private_chat.DoodleShareExtra\022<\n\fgroup_notice\030\027 \001(\0132&.com.blued.im.private_chat.GroupNoticeB\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[] { fileDescriptor });
  }
  
  public static final class PushBodyExtra extends GeneratedMessageV3 implements PushBodyExtraOrBuilder {
    private static final PushBodyExtra DEFAULT_INSTANCE = new PushBodyExtra();
    
    public static final int DOODLE_SHARE_EXTRA_FIELD_NUMBER = 22;
    
    public static final int FEED_SHARE_EXTRA_FIELD_NUMBER = 18;
    
    public static final int GIFT_EXTRA_FIELD_NUMBER = 14;
    
    public static final int GROUP_CARD_EXTRA_FIELD_NUMBER = 8;
    
    public static final int GROUP_NOTICE_FIELD_NUMBER = 23;
    
    public static final int HIDEN_ALBUM_EXTRA_FIELD_NUMBER = 11;
    
    public static final int IMAGETEXT_EXTRA_FIELD_NUMBER = 10;
    
    public static final int IMG_EXTRA_FIELD_NUMBER = 4;
    
    public static final int LIVE_SHARE_EXTRA_FIELD_NUMBER = 9;
    
    public static final int LIVE_SHARE_INTERNATIONAL_EXTRA_FIELD_NUMBER = 21;
    
    public static final int LOCATION_EXTRA_FIELD_NUMBER = 6;
    
    public static final int MSGSOURCE_FIELD_NUMBER = 1;
    
    public static final int MSG_RECEIVE_FROM_FIELD_NUMBER = 5;
    
    private static final Parser<PushBodyExtra> PARSER = (Parser<PushBodyExtra>)new AbstractParser<PushBodyExtra>() {
        public PushBodyExtraOuterClass.PushBodyExtra parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PushBodyExtraOuterClass.PushBodyExtra(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int SAY_HI_EXTRA_FIELD_NUMBER = 19;
    
    public static final int SECURENOTIFY_FIELD_NUMBER = 2;
    
    public static final int SHARE_EXTRA_FIELD_NUMBER = 12;
    
    public static final int SYS_NOTICE_EXTRA_FIELD_NUMBER = 15;
    
    public static final int TEXT_EXTRA_FIELD_NUMBER = 3;
    
    public static final int VIDEO_CALLING_EXTRA_FIELD_NUMBER = 16;
    
    public static final int VIDEO_END_EXTRA_FIELD_NUMBER = 17;
    
    public static final int VIDEO_EXTRA_FIELD_NUMBER = 7;
    
    public static final int VIP_EXTRA_FIELD_NUMBER = 13;
    
    public static final int VOICE_ROOM_SHARE_EXTRA_FIELD_NUMBER = 20;
    
    private static final long serialVersionUID = 0L;
    
    private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
    
    private MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra_;
    
    private MsgBodyExtraOuterClass.GiftExtra giftExtra_;
    
    private MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra_;
    
    private MsgBodyExtraOuterClass.GroupNotice groupNotice_;
    
    private MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra_;
    
    private MsgBodyExtraOuterClass.ImageTextExtra imagetextExtra_;
    
    private MsgBodyExtraOuterClass.ImgExtra imgExtra_;
    
    private MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra_;
    
    private MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra_;
    
    private MsgBodyExtraOuterClass.LocationExtra locationExtra_;
    
    private byte memoizedIsInitialized = -1;
    
    private long msgReceiveFrom_;
    
    private MsgBodyExtraOuterClass.MsgSource msgSource_;
    
    private MsgBodyExtraOuterClass.SayHiExtra sayHiExtra_;
    
    private MsgBodyExtraOuterClass.SecureNotify secureNotify_;
    
    private MsgBodyExtraOuterClass.ShareExtra shareExtra_;
    
    private MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra_;
    
    private MsgBodyExtraOuterClass.TextExtra textExtra_;
    
    private MsgBodyExtraOuterClass.VideoChatCallingExtra videoCallingExtra_;
    
    private MsgBodyExtraOuterClass.VideoChatEndExtra videoEndExtra_;
    
    private MsgBodyExtraOuterClass.VideoExtra videoExtra_;
    
    private MsgBodyExtraOuterClass.VipExtra vipExtra_;
    
    private MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra_;
    
    private PushBodyExtra() {}
    
    private PushBodyExtra(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      this();
      if (param1ExtensionRegistryLite != null) {
        UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
        boolean bool = false;
        while (!bool) {
          try {
            MsgBodyExtraOuterClass.DoodleShareExtra.Builder builder21;
            MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder builder20;
            MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder builder19;
            MsgBodyExtraOuterClass.SayHiExtra.Builder builder18;
            MsgBodyExtraOuterClass.FeedShareExtra.Builder builder17;
            MsgBodyExtraOuterClass.VideoChatEndExtra.Builder builder16;
            MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder builder15;
            MsgBodyExtraOuterClass.SysNoticeExtra.Builder builder14;
            MsgBodyExtraOuterClass.GiftExtra.Builder builder13;
            MsgBodyExtraOuterClass.VipExtra.Builder builder12;
            MsgBodyExtraOuterClass.ShareExtra.Builder builder11;
            MsgBodyExtraOuterClass.HidenAlbumExtra.Builder builder10;
            MsgBodyExtraOuterClass.ImageTextExtra.Builder builder9;
            MsgBodyExtraOuterClass.LiveShareExtra.Builder builder8;
            MsgBodyExtraOuterClass.GroupCardExtra.Builder builder7;
            MsgBodyExtraOuterClass.VideoExtra.Builder builder6;
            MsgBodyExtraOuterClass.LocationExtra.Builder builder5;
            MsgBodyExtraOuterClass.ImgExtra.Builder builder4;
            MsgBodyExtraOuterClass.TextExtra.Builder builder3;
            MsgBodyExtraOuterClass.SecureNotify.Builder builder2;
            MsgBodyExtraOuterClass.MsgSource.Builder builder1;
            int i = param1CodedInputStream.readTag();
            MsgBodyExtraOuterClass.GroupNotice.Builder builder23 = null;
            MsgBodyExtraOuterClass.DoodleShareExtra.Builder builder24 = null;
            MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder builder25 = null;
            MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder builder26 = null;
            MsgBodyExtraOuterClass.SayHiExtra.Builder builder27 = null;
            MsgBodyExtraOuterClass.FeedShareExtra.Builder builder28 = null;
            MsgBodyExtraOuterClass.VideoChatEndExtra.Builder builder29 = null;
            MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder builder30 = null;
            MsgBodyExtraOuterClass.SysNoticeExtra.Builder builder31 = null;
            MsgBodyExtraOuterClass.GiftExtra.Builder builder32 = null;
            MsgBodyExtraOuterClass.VipExtra.Builder builder33 = null;
            MsgBodyExtraOuterClass.ShareExtra.Builder builder34 = null;
            MsgBodyExtraOuterClass.HidenAlbumExtra.Builder builder35 = null;
            MsgBodyExtraOuterClass.ImageTextExtra.Builder builder36 = null;
            MsgBodyExtraOuterClass.LiveShareExtra.Builder builder37 = null;
            MsgBodyExtraOuterClass.GroupCardExtra.Builder builder38 = null;
            MsgBodyExtraOuterClass.VideoExtra.Builder builder39 = null;
            MsgBodyExtraOuterClass.LocationExtra.Builder builder40 = null;
            MsgBodyExtraOuterClass.ImgExtra.Builder builder41 = null;
            MsgBodyExtraOuterClass.TextExtra.Builder builder42 = null;
            MsgBodyExtraOuterClass.SecureNotify.Builder builder43 = null;
            MsgBodyExtraOuterClass.GroupNotice.Builder builder22 = null;
            switch (i) {
              case 186:
                if (this.groupNotice_ != null)
                  builder22 = this.groupNotice_.toBuilder(); 
                this.groupNotice_ = (MsgBodyExtraOuterClass.GroupNotice)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.GroupNotice.parser(), param1ExtensionRegistryLite);
                if (builder22 != null) {
                  builder22.mergeFrom(this.groupNotice_);
                  this.groupNotice_ = builder22.buildPartial();
                } 
                continue;
              case 178:
                builder22 = builder23;
                if (this.doodleShareExtra_ != null)
                  builder21 = this.doodleShareExtra_.toBuilder(); 
                this.doodleShareExtra_ = (MsgBodyExtraOuterClass.DoodleShareExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.DoodleShareExtra.parser(), param1ExtensionRegistryLite);
                if (builder21 != null) {
                  builder21.mergeFrom(this.doodleShareExtra_);
                  this.doodleShareExtra_ = builder21.buildPartial();
                } 
                continue;
              case 170:
                builder21 = builder24;
                if (this.liveShareInternationalExtra_ != null)
                  builder20 = this.liveShareInternationalExtra_.toBuilder(); 
                this.liveShareInternationalExtra_ = (MsgBodyExtraOuterClass.LiveShareInternationalExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareInternationalExtra.parser(), param1ExtensionRegistryLite);
                if (builder20 != null) {
                  builder20.mergeFrom(this.liveShareInternationalExtra_);
                  this.liveShareInternationalExtra_ = builder20.buildPartial();
                } 
                continue;
              case 162:
                builder20 = builder25;
                if (this.voiceRoomShareExtra_ != null)
                  builder19 = this.voiceRoomShareExtra_.toBuilder(); 
                this.voiceRoomShareExtra_ = (MsgBodyExtraOuterClass.VoiceRoomShareExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.VoiceRoomShareExtra.parser(), param1ExtensionRegistryLite);
                if (builder19 != null) {
                  builder19.mergeFrom(this.voiceRoomShareExtra_);
                  this.voiceRoomShareExtra_ = builder19.buildPartial();
                } 
                continue;
              case 154:
                builder19 = builder26;
                if (this.sayHiExtra_ != null)
                  builder18 = this.sayHiExtra_.toBuilder(); 
                this.sayHiExtra_ = (MsgBodyExtraOuterClass.SayHiExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.SayHiExtra.parser(), param1ExtensionRegistryLite);
                if (builder18 != null) {
                  builder18.mergeFrom(this.sayHiExtra_);
                  this.sayHiExtra_ = builder18.buildPartial();
                } 
                continue;
              case 146:
                builder18 = builder27;
                if (this.feedShareExtra_ != null)
                  builder17 = this.feedShareExtra_.toBuilder(); 
                this.feedShareExtra_ = (MsgBodyExtraOuterClass.FeedShareExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.FeedShareExtra.parser(), param1ExtensionRegistryLite);
                if (builder17 != null) {
                  builder17.mergeFrom(this.feedShareExtra_);
                  this.feedShareExtra_ = builder17.buildPartial();
                } 
                continue;
              case 138:
                builder17 = builder28;
                if (this.videoEndExtra_ != null)
                  builder16 = this.videoEndExtra_.toBuilder(); 
                this.videoEndExtra_ = (MsgBodyExtraOuterClass.VideoChatEndExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatEndExtra.parser(), param1ExtensionRegistryLite);
                if (builder16 != null) {
                  builder16.mergeFrom(this.videoEndExtra_);
                  this.videoEndExtra_ = builder16.buildPartial();
                } 
                continue;
              case 130:
                builder16 = builder29;
                if (this.videoCallingExtra_ != null)
                  builder15 = this.videoCallingExtra_.toBuilder(); 
                this.videoCallingExtra_ = (MsgBodyExtraOuterClass.VideoChatCallingExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatCallingExtra.parser(), param1ExtensionRegistryLite);
                if (builder15 != null) {
                  builder15.mergeFrom(this.videoCallingExtra_);
                  this.videoCallingExtra_ = builder15.buildPartial();
                } 
                continue;
              case 122:
                builder15 = builder30;
                if (this.sysNoticeExtra_ != null)
                  builder14 = this.sysNoticeExtra_.toBuilder(); 
                this.sysNoticeExtra_ = (MsgBodyExtraOuterClass.SysNoticeExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.SysNoticeExtra.parser(), param1ExtensionRegistryLite);
                if (builder14 != null) {
                  builder14.mergeFrom(this.sysNoticeExtra_);
                  this.sysNoticeExtra_ = builder14.buildPartial();
                } 
                continue;
              case 114:
                builder14 = builder31;
                if (this.giftExtra_ != null)
                  builder13 = this.giftExtra_.toBuilder(); 
                this.giftExtra_ = (MsgBodyExtraOuterClass.GiftExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.GiftExtra.parser(), param1ExtensionRegistryLite);
                if (builder13 != null) {
                  builder13.mergeFrom(this.giftExtra_);
                  this.giftExtra_ = builder13.buildPartial();
                } 
                continue;
              case 106:
                builder13 = builder32;
                if (this.vipExtra_ != null)
                  builder12 = this.vipExtra_.toBuilder(); 
                this.vipExtra_ = (MsgBodyExtraOuterClass.VipExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.VipExtra.parser(), param1ExtensionRegistryLite);
                if (builder12 != null) {
                  builder12.mergeFrom(this.vipExtra_);
                  this.vipExtra_ = builder12.buildPartial();
                } 
                continue;
              case 98:
                builder12 = builder33;
                if (this.shareExtra_ != null)
                  builder11 = this.shareExtra_.toBuilder(); 
                this.shareExtra_ = (MsgBodyExtraOuterClass.ShareExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.ShareExtra.parser(), param1ExtensionRegistryLite);
                if (builder11 != null) {
                  builder11.mergeFrom(this.shareExtra_);
                  this.shareExtra_ = builder11.buildPartial();
                } 
                continue;
              case 90:
                builder11 = builder34;
                if (this.hidenAlbumExtra_ != null)
                  builder10 = this.hidenAlbumExtra_.toBuilder(); 
                this.hidenAlbumExtra_ = (MsgBodyExtraOuterClass.HidenAlbumExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.HidenAlbumExtra.parser(), param1ExtensionRegistryLite);
                if (builder10 != null) {
                  builder10.mergeFrom(this.hidenAlbumExtra_);
                  this.hidenAlbumExtra_ = builder10.buildPartial();
                } 
                continue;
              case 82:
                builder10 = builder35;
                if (this.imagetextExtra_ != null)
                  builder9 = this.imagetextExtra_.toBuilder(); 
                this.imagetextExtra_ = (MsgBodyExtraOuterClass.ImageTextExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.ImageTextExtra.parser(), param1ExtensionRegistryLite);
                if (builder9 != null) {
                  builder9.mergeFrom(this.imagetextExtra_);
                  this.imagetextExtra_ = builder9.buildPartial();
                } 
                continue;
              case 74:
                builder9 = builder36;
                if (this.liveShareExtra_ != null)
                  builder8 = this.liveShareExtra_.toBuilder(); 
                this.liveShareExtra_ = (MsgBodyExtraOuterClass.LiveShareExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareExtra.parser(), param1ExtensionRegistryLite);
                if (builder8 != null) {
                  builder8.mergeFrom(this.liveShareExtra_);
                  this.liveShareExtra_ = builder8.buildPartial();
                } 
                continue;
              case 66:
                builder8 = builder37;
                if (this.groupCardExtra_ != null)
                  builder7 = this.groupCardExtra_.toBuilder(); 
                this.groupCardExtra_ = (MsgBodyExtraOuterClass.GroupCardExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.GroupCardExtra.parser(), param1ExtensionRegistryLite);
                if (builder7 != null) {
                  builder7.mergeFrom(this.groupCardExtra_);
                  this.groupCardExtra_ = builder7.buildPartial();
                } 
                continue;
              case 58:
                builder7 = builder38;
                if (this.videoExtra_ != null)
                  builder6 = this.videoExtra_.toBuilder(); 
                this.videoExtra_ = (MsgBodyExtraOuterClass.VideoExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.VideoExtra.parser(), param1ExtensionRegistryLite);
                if (builder6 != null) {
                  builder6.mergeFrom(this.videoExtra_);
                  this.videoExtra_ = builder6.buildPartial();
                } 
                continue;
              case 50:
                builder6 = builder39;
                if (this.locationExtra_ != null)
                  builder5 = this.locationExtra_.toBuilder(); 
                this.locationExtra_ = (MsgBodyExtraOuterClass.LocationExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.LocationExtra.parser(), param1ExtensionRegistryLite);
                if (builder5 != null) {
                  builder5.mergeFrom(this.locationExtra_);
                  this.locationExtra_ = builder5.buildPartial();
                } 
                continue;
              case 40:
                this.msgReceiveFrom_ = param1CodedInputStream.readInt64();
                continue;
              case 34:
                builder5 = builder40;
                if (this.imgExtra_ != null)
                  builder4 = this.imgExtra_.toBuilder(); 
                this.imgExtra_ = (MsgBodyExtraOuterClass.ImgExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.ImgExtra.parser(), param1ExtensionRegistryLite);
                if (builder4 != null) {
                  builder4.mergeFrom(this.imgExtra_);
                  this.imgExtra_ = builder4.buildPartial();
                } 
                continue;
              case 26:
                builder4 = builder41;
                if (this.textExtra_ != null)
                  builder3 = this.textExtra_.toBuilder(); 
                this.textExtra_ = (MsgBodyExtraOuterClass.TextExtra)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.TextExtra.parser(), param1ExtensionRegistryLite);
                if (builder3 != null) {
                  builder3.mergeFrom(this.textExtra_);
                  this.textExtra_ = builder3.buildPartial();
                } 
                continue;
              case 18:
                builder3 = builder42;
                if (this.secureNotify_ != null)
                  builder2 = this.secureNotify_.toBuilder(); 
                this.secureNotify_ = (MsgBodyExtraOuterClass.SecureNotify)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.SecureNotify.parser(), param1ExtensionRegistryLite);
                if (builder2 != null) {
                  builder2.mergeFrom(this.secureNotify_);
                  this.secureNotify_ = builder2.buildPartial();
                } 
                continue;
              case 10:
                builder2 = builder43;
                if (this.msgSource_ != null)
                  builder1 = this.msgSource_.toBuilder(); 
                this.msgSource_ = (MsgBodyExtraOuterClass.MsgSource)param1CodedInputStream.readMessage(MsgBodyExtraOuterClass.MsgSource.parser(), param1ExtensionRegistryLite);
                if (builder1 != null) {
                  builder1.mergeFrom(this.msgSource_);
                  this.msgSource_ = builder1.buildPartial();
                } 
                continue;
              case 0:
                bool = true;
                continue;
            } 
            boolean bool1 = parseUnknownField(param1CodedInputStream, builder, param1ExtensionRegistryLite, i);
            if (!bool1);
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
    
    private PushBodyExtra(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PushBodyExtra getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PushBodyExtra param1PushBodyExtra) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PushBodyExtra);
    }
    
    public static PushBodyExtra parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PushBodyExtra parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBodyExtra parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ByteString);
    }
    
    public static PushBodyExtra parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PushBodyExtra parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PushBodyExtra parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBodyExtra parseFrom(InputStream param1InputStream) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PushBodyExtra parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushBodyExtra)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushBodyExtra parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PushBodyExtra parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PushBodyExtra parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PushBodyExtra parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushBodyExtra)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PushBodyExtra> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PushBodyExtra))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return (hasMsgSource() != param1Object.hasMsgSource()) ? false : ((hasMsgSource() && !getMsgSource().equals(param1Object.getMsgSource())) ? false : ((hasSecureNotify() != param1Object.hasSecureNotify()) ? false : ((hasSecureNotify() && !getSecureNotify().equals(param1Object.getSecureNotify())) ? false : ((hasTextExtra() != param1Object.hasTextExtra()) ? false : ((hasTextExtra() && !getTextExtra().equals(param1Object.getTextExtra())) ? false : ((hasImgExtra() != param1Object.hasImgExtra()) ? false : ((hasImgExtra() && !getImgExtra().equals(param1Object.getImgExtra())) ? false : ((getMsgReceiveFrom() != param1Object.getMsgReceiveFrom()) ? false : ((hasLocationExtra() != param1Object.hasLocationExtra()) ? false : ((hasLocationExtra() && !getLocationExtra().equals(param1Object.getLocationExtra())) ? false : ((hasVideoExtra() != param1Object.hasVideoExtra()) ? false : ((hasVideoExtra() && !getVideoExtra().equals(param1Object.getVideoExtra())) ? false : ((hasGroupCardExtra() != param1Object.hasGroupCardExtra()) ? false : ((hasGroupCardExtra() && !getGroupCardExtra().equals(param1Object.getGroupCardExtra())) ? false : ((hasLiveShareExtra() != param1Object.hasLiveShareExtra()) ? false : ((hasLiveShareExtra() && !getLiveShareExtra().equals(param1Object.getLiveShareExtra())) ? false : ((hasImagetextExtra() != param1Object.hasImagetextExtra()) ? false : ((hasImagetextExtra() && !getImagetextExtra().equals(param1Object.getImagetextExtra())) ? false : ((hasHidenAlbumExtra() != param1Object.hasHidenAlbumExtra()) ? false : ((hasHidenAlbumExtra() && !getHidenAlbumExtra().equals(param1Object.getHidenAlbumExtra())) ? false : ((hasShareExtra() != param1Object.hasShareExtra()) ? false : ((hasShareExtra() && !getShareExtra().equals(param1Object.getShareExtra())) ? false : ((hasVipExtra() != param1Object.hasVipExtra()) ? false : ((hasVipExtra() && !getVipExtra().equals(param1Object.getVipExtra())) ? false : ((hasGiftExtra() != param1Object.hasGiftExtra()) ? false : ((hasGiftExtra() && !getGiftExtra().equals(param1Object.getGiftExtra())) ? false : ((hasSysNoticeExtra() != param1Object.hasSysNoticeExtra()) ? false : ((hasSysNoticeExtra() && !getSysNoticeExtra().equals(param1Object.getSysNoticeExtra())) ? false : ((hasVideoCallingExtra() != param1Object.hasVideoCallingExtra()) ? false : ((hasVideoCallingExtra() && !getVideoCallingExtra().equals(param1Object.getVideoCallingExtra())) ? false : ((hasVideoEndExtra() != param1Object.hasVideoEndExtra()) ? false : ((hasVideoEndExtra() && !getVideoEndExtra().equals(param1Object.getVideoEndExtra())) ? false : ((hasFeedShareExtra() != param1Object.hasFeedShareExtra()) ? false : ((hasFeedShareExtra() && !getFeedShareExtra().equals(param1Object.getFeedShareExtra())) ? false : ((hasSayHiExtra() != param1Object.hasSayHiExtra()) ? false : ((hasSayHiExtra() && !getSayHiExtra().equals(param1Object.getSayHiExtra())) ? false : ((hasVoiceRoomShareExtra() != param1Object.hasVoiceRoomShareExtra()) ? false : ((hasVoiceRoomShareExtra() && !getVoiceRoomShareExtra().equals(param1Object.getVoiceRoomShareExtra())) ? false : ((hasLiveShareInternationalExtra() != param1Object.hasLiveShareInternationalExtra()) ? false : ((hasLiveShareInternationalExtra() && !getLiveShareInternationalExtra().equals(param1Object.getLiveShareInternationalExtra())) ? false : ((hasDoodleShareExtra() != param1Object.hasDoodleShareExtra()) ? false : ((hasDoodleShareExtra() && !getDoodleShareExtra().equals(param1Object.getDoodleShareExtra())) ? false : ((hasGroupNotice() != param1Object.hasGroupNotice()) ? false : ((hasGroupNotice() && !getGroupNotice().equals(param1Object.getGroupNotice())) ? false : (!!this.unknownFields.equals(((PushBodyExtra)param1Object).unknownFields))))))))))))))))))))))))))))))))))))))))))))));
    }
    
    public PushBodyExtra getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = this.doodleShareExtra_;
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra1 = doodleShareExtra2;
      if (doodleShareExtra2 == null)
        doodleShareExtra1 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance(); 
      return doodleShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
      return getDoodleShareExtra();
    }
    
    public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = this.feedShareExtra_;
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra1 = feedShareExtra2;
      if (feedShareExtra2 == null)
        feedShareExtra1 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance(); 
      return feedShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
      return getFeedShareExtra();
    }
    
    public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
      MsgBodyExtraOuterClass.GiftExtra giftExtra2 = this.giftExtra_;
      MsgBodyExtraOuterClass.GiftExtra giftExtra1 = giftExtra2;
      if (giftExtra2 == null)
        giftExtra1 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance(); 
      return giftExtra1;
    }
    
    public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
      return getGiftExtra();
    }
    
    public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = this.groupCardExtra_;
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra1 = groupCardExtra2;
      if (groupCardExtra2 == null)
        groupCardExtra1 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance(); 
      return groupCardExtra1;
    }
    
    public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
      return getGroupCardExtra();
    }
    
    public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
      MsgBodyExtraOuterClass.GroupNotice groupNotice2 = this.groupNotice_;
      MsgBodyExtraOuterClass.GroupNotice groupNotice1 = groupNotice2;
      if (groupNotice2 == null)
        groupNotice1 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance(); 
      return groupNotice1;
    }
    
    public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
      return getGroupNotice();
    }
    
    public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = this.hidenAlbumExtra_;
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra1 = hidenAlbumExtra2;
      if (hidenAlbumExtra2 == null)
        hidenAlbumExtra1 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance(); 
      return hidenAlbumExtra1;
    }
    
    public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
      return getHidenAlbumExtra();
    }
    
    public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = this.imagetextExtra_;
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra1 = imageTextExtra2;
      if (imageTextExtra2 == null)
        imageTextExtra1 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance(); 
      return imageTextExtra1;
    }
    
    public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
      return getImagetextExtra();
    }
    
    public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
      MsgBodyExtraOuterClass.ImgExtra imgExtra2 = this.imgExtra_;
      MsgBodyExtraOuterClass.ImgExtra imgExtra1 = imgExtra2;
      if (imgExtra2 == null)
        imgExtra1 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance(); 
      return imgExtra1;
    }
    
    public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
      return getImgExtra();
    }
    
    public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = this.liveShareExtra_;
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra1 = liveShareExtra2;
      if (liveShareExtra2 == null)
        liveShareExtra1 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance(); 
      return liveShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
      return getLiveShareExtra();
    }
    
    public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = this.liveShareInternationalExtra_;
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra1 = liveShareInternationalExtra2;
      if (liveShareInternationalExtra2 == null)
        liveShareInternationalExtra1 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance(); 
      return liveShareInternationalExtra1;
    }
    
    public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
      return getLiveShareInternationalExtra();
    }
    
    public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
      MsgBodyExtraOuterClass.LocationExtra locationExtra2 = this.locationExtra_;
      MsgBodyExtraOuterClass.LocationExtra locationExtra1 = locationExtra2;
      if (locationExtra2 == null)
        locationExtra1 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance(); 
      return locationExtra1;
    }
    
    public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
      return getLocationExtra();
    }
    
    public long getMsgReceiveFrom() {
      return this.msgReceiveFrom_;
    }
    
    public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
      MsgBodyExtraOuterClass.MsgSource msgSource2 = this.msgSource_;
      MsgBodyExtraOuterClass.MsgSource msgSource1 = msgSource2;
      if (msgSource2 == null)
        msgSource1 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance(); 
      return msgSource1;
    }
    
    public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
      return getMsgSource();
    }
    
    public Parser<PushBodyExtra> getParserForType() {
      return PARSER;
    }
    
    public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = this.sayHiExtra_;
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra1 = sayHiExtra2;
      if (sayHiExtra2 == null)
        sayHiExtra1 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance(); 
      return sayHiExtra1;
    }
    
    public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
      return getSayHiExtra();
    }
    
    public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
      MsgBodyExtraOuterClass.SecureNotify secureNotify2 = this.secureNotify_;
      MsgBodyExtraOuterClass.SecureNotify secureNotify1 = secureNotify2;
      if (secureNotify2 == null)
        secureNotify1 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance(); 
      return secureNotify1;
    }
    
    public MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder() {
      return getSecureNotify();
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      int j = 0;
      if (this.msgSource_ != null)
        j = 0 + CodedOutputStream.computeMessageSize(1, (MessageLite)getMsgSource()); 
      i = j;
      if (this.secureNotify_ != null)
        i = j + CodedOutputStream.computeMessageSize(2, (MessageLite)getSecureNotify()); 
      j = i;
      if (this.textExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(3, (MessageLite)getTextExtra()); 
      i = j;
      if (this.imgExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(4, (MessageLite)getImgExtra()); 
      long l = this.msgReceiveFrom_;
      j = i;
      if (l != 0L)
        j = i + CodedOutputStream.computeInt64Size(5, l); 
      i = j;
      if (this.locationExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(6, (MessageLite)getLocationExtra()); 
      j = i;
      if (this.videoExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(7, (MessageLite)getVideoExtra()); 
      i = j;
      if (this.groupCardExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(8, (MessageLite)getGroupCardExtra()); 
      j = i;
      if (this.liveShareExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(9, (MessageLite)getLiveShareExtra()); 
      i = j;
      if (this.imagetextExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(10, (MessageLite)getImagetextExtra()); 
      j = i;
      if (this.hidenAlbumExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(11, (MessageLite)getHidenAlbumExtra()); 
      i = j;
      if (this.shareExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(12, (MessageLite)getShareExtra()); 
      j = i;
      if (this.vipExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(13, (MessageLite)getVipExtra()); 
      i = j;
      if (this.giftExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(14, (MessageLite)getGiftExtra()); 
      j = i;
      if (this.sysNoticeExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(15, (MessageLite)getSysNoticeExtra()); 
      i = j;
      if (this.videoCallingExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(16, (MessageLite)getVideoCallingExtra()); 
      j = i;
      if (this.videoEndExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(17, (MessageLite)getVideoEndExtra()); 
      i = j;
      if (this.feedShareExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(18, (MessageLite)getFeedShareExtra()); 
      j = i;
      if (this.sayHiExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(19, (MessageLite)getSayHiExtra()); 
      i = j;
      if (this.voiceRoomShareExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(20, (MessageLite)getVoiceRoomShareExtra()); 
      j = i;
      if (this.liveShareInternationalExtra_ != null)
        j = i + CodedOutputStream.computeMessageSize(21, (MessageLite)getLiveShareInternationalExtra()); 
      i = j;
      if (this.doodleShareExtra_ != null)
        i = j + CodedOutputStream.computeMessageSize(22, (MessageLite)getDoodleShareExtra()); 
      j = i;
      if (this.groupNotice_ != null)
        j = i + CodedOutputStream.computeMessageSize(23, (MessageLite)getGroupNotice()); 
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
      MsgBodyExtraOuterClass.ShareExtra shareExtra2 = this.shareExtra_;
      MsgBodyExtraOuterClass.ShareExtra shareExtra1 = shareExtra2;
      if (shareExtra2 == null)
        shareExtra1 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance(); 
      return shareExtra1;
    }
    
    public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
      return getShareExtra();
    }
    
    public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = this.sysNoticeExtra_;
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra1 = sysNoticeExtra2;
      if (sysNoticeExtra2 == null)
        sysNoticeExtra1 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance(); 
      return sysNoticeExtra1;
    }
    
    public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
      return getSysNoticeExtra();
    }
    
    public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
      MsgBodyExtraOuterClass.TextExtra textExtra2 = this.textExtra_;
      MsgBodyExtraOuterClass.TextExtra textExtra1 = textExtra2;
      if (textExtra2 == null)
        textExtra1 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance(); 
      return textExtra1;
    }
    
    public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
      return getTextExtra();
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = this.videoCallingExtra_;
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra1 = videoChatCallingExtra2;
      if (videoChatCallingExtra2 == null)
        videoChatCallingExtra1 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance(); 
      return videoChatCallingExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
      return getVideoCallingExtra();
    }
    
    public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = this.videoEndExtra_;
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra1 = videoChatEndExtra2;
      if (videoChatEndExtra2 == null)
        videoChatEndExtra1 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance(); 
      return videoChatEndExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
      return getVideoEndExtra();
    }
    
    public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
      MsgBodyExtraOuterClass.VideoExtra videoExtra2 = this.videoExtra_;
      MsgBodyExtraOuterClass.VideoExtra videoExtra1 = videoExtra2;
      if (videoExtra2 == null)
        videoExtra1 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance(); 
      return videoExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
      return getVideoExtra();
    }
    
    public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
      MsgBodyExtraOuterClass.VipExtra vipExtra2 = this.vipExtra_;
      MsgBodyExtraOuterClass.VipExtra vipExtra1 = vipExtra2;
      if (vipExtra2 == null)
        vipExtra1 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance(); 
      return vipExtra1;
    }
    
    public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
      return getVipExtra();
    }
    
    public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = this.voiceRoomShareExtra_;
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra1 = voiceRoomShareExtra2;
      if (voiceRoomShareExtra2 == null)
        voiceRoomShareExtra1 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance(); 
      return voiceRoomShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
      return getVoiceRoomShareExtra();
    }
    
    public boolean hasDoodleShareExtra() {
      return (this.doodleShareExtra_ != null);
    }
    
    public boolean hasFeedShareExtra() {
      return (this.feedShareExtra_ != null);
    }
    
    public boolean hasGiftExtra() {
      return (this.giftExtra_ != null);
    }
    
    public boolean hasGroupCardExtra() {
      return (this.groupCardExtra_ != null);
    }
    
    public boolean hasGroupNotice() {
      return (this.groupNotice_ != null);
    }
    
    public boolean hasHidenAlbumExtra() {
      return (this.hidenAlbumExtra_ != null);
    }
    
    public boolean hasImagetextExtra() {
      return (this.imagetextExtra_ != null);
    }
    
    public boolean hasImgExtra() {
      return (this.imgExtra_ != null);
    }
    
    public boolean hasLiveShareExtra() {
      return (this.liveShareExtra_ != null);
    }
    
    public boolean hasLiveShareInternationalExtra() {
      return (this.liveShareInternationalExtra_ != null);
    }
    
    public boolean hasLocationExtra() {
      return (this.locationExtra_ != null);
    }
    
    public boolean hasMsgSource() {
      return (this.msgSource_ != null);
    }
    
    public boolean hasSayHiExtra() {
      return (this.sayHiExtra_ != null);
    }
    
    public boolean hasSecureNotify() {
      return (this.secureNotify_ != null);
    }
    
    public boolean hasShareExtra() {
      return (this.shareExtra_ != null);
    }
    
    public boolean hasSysNoticeExtra() {
      return (this.sysNoticeExtra_ != null);
    }
    
    public boolean hasTextExtra() {
      return (this.textExtra_ != null);
    }
    
    public boolean hasVideoCallingExtra() {
      return (this.videoCallingExtra_ != null);
    }
    
    public boolean hasVideoEndExtra() {
      return (this.videoEndExtra_ != null);
    }
    
    public boolean hasVideoExtra() {
      return (this.videoExtra_ != null);
    }
    
    public boolean hasVipExtra() {
      return (this.vipExtra_ != null);
    }
    
    public boolean hasVoiceRoomShareExtra() {
      return (this.voiceRoomShareExtra_ != null);
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = 779 + getDescriptor().hashCode();
      int i = j;
      if (hasMsgSource())
        i = (j * 37 + 1) * 53 + getMsgSource().hashCode(); 
      j = i;
      if (hasSecureNotify())
        j = (i * 37 + 2) * 53 + getSecureNotify().hashCode(); 
      i = j;
      if (hasTextExtra())
        i = (j * 37 + 3) * 53 + getTextExtra().hashCode(); 
      j = i;
      if (hasImgExtra())
        j = (i * 37 + 4) * 53 + getImgExtra().hashCode(); 
      j = (j * 37 + 5) * 53 + Internal.hashLong(getMsgReceiveFrom());
      i = j;
      if (hasLocationExtra())
        i = (j * 37 + 6) * 53 + getLocationExtra().hashCode(); 
      j = i;
      if (hasVideoExtra())
        j = (i * 37 + 7) * 53 + getVideoExtra().hashCode(); 
      i = j;
      if (hasGroupCardExtra())
        i = (j * 37 + 8) * 53 + getGroupCardExtra().hashCode(); 
      j = i;
      if (hasLiveShareExtra())
        j = (i * 37 + 9) * 53 + getLiveShareExtra().hashCode(); 
      i = j;
      if (hasImagetextExtra())
        i = (j * 37 + 10) * 53 + getImagetextExtra().hashCode(); 
      j = i;
      if (hasHidenAlbumExtra())
        j = (i * 37 + 11) * 53 + getHidenAlbumExtra().hashCode(); 
      i = j;
      if (hasShareExtra())
        i = (j * 37 + 12) * 53 + getShareExtra().hashCode(); 
      j = i;
      if (hasVipExtra())
        j = (i * 37 + 13) * 53 + getVipExtra().hashCode(); 
      i = j;
      if (hasGiftExtra())
        i = (j * 37 + 14) * 53 + getGiftExtra().hashCode(); 
      j = i;
      if (hasSysNoticeExtra())
        j = (i * 37 + 15) * 53 + getSysNoticeExtra().hashCode(); 
      i = j;
      if (hasVideoCallingExtra())
        i = (j * 37 + 16) * 53 + getVideoCallingExtra().hashCode(); 
      j = i;
      if (hasVideoEndExtra())
        j = (i * 37 + 17) * 53 + getVideoEndExtra().hashCode(); 
      i = j;
      if (hasFeedShareExtra())
        i = (j * 37 + 18) * 53 + getFeedShareExtra().hashCode(); 
      j = i;
      if (hasSayHiExtra())
        j = (i * 37 + 19) * 53 + getSayHiExtra().hashCode(); 
      i = j;
      if (hasVoiceRoomShareExtra())
        i = (j * 37 + 20) * 53 + getVoiceRoomShareExtra().hashCode(); 
      j = i;
      if (hasLiveShareInternationalExtra())
        j = (i * 37 + 21) * 53 + getLiveShareInternationalExtra().hashCode(); 
      i = j;
      if (hasDoodleShareExtra())
        i = (j * 37 + 22) * 53 + getDoodleShareExtra().hashCode(); 
      j = i;
      if (hasGroupNotice())
        j = (i * 37 + 23) * 53 + getGroupNotice().hashCode(); 
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyExtra.class, Builder.class);
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
      return new PushBodyExtra();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      if (this.msgSource_ != null)
        param1CodedOutputStream.writeMessage(1, (MessageLite)getMsgSource()); 
      if (this.secureNotify_ != null)
        param1CodedOutputStream.writeMessage(2, (MessageLite)getSecureNotify()); 
      if (this.textExtra_ != null)
        param1CodedOutputStream.writeMessage(3, (MessageLite)getTextExtra()); 
      if (this.imgExtra_ != null)
        param1CodedOutputStream.writeMessage(4, (MessageLite)getImgExtra()); 
      long l = this.msgReceiveFrom_;
      if (l != 0L)
        param1CodedOutputStream.writeInt64(5, l); 
      if (this.locationExtra_ != null)
        param1CodedOutputStream.writeMessage(6, (MessageLite)getLocationExtra()); 
      if (this.videoExtra_ != null)
        param1CodedOutputStream.writeMessage(7, (MessageLite)getVideoExtra()); 
      if (this.groupCardExtra_ != null)
        param1CodedOutputStream.writeMessage(8, (MessageLite)getGroupCardExtra()); 
      if (this.liveShareExtra_ != null)
        param1CodedOutputStream.writeMessage(9, (MessageLite)getLiveShareExtra()); 
      if (this.imagetextExtra_ != null)
        param1CodedOutputStream.writeMessage(10, (MessageLite)getImagetextExtra()); 
      if (this.hidenAlbumExtra_ != null)
        param1CodedOutputStream.writeMessage(11, (MessageLite)getHidenAlbumExtra()); 
      if (this.shareExtra_ != null)
        param1CodedOutputStream.writeMessage(12, (MessageLite)getShareExtra()); 
      if (this.vipExtra_ != null)
        param1CodedOutputStream.writeMessage(13, (MessageLite)getVipExtra()); 
      if (this.giftExtra_ != null)
        param1CodedOutputStream.writeMessage(14, (MessageLite)getGiftExtra()); 
      if (this.sysNoticeExtra_ != null)
        param1CodedOutputStream.writeMessage(15, (MessageLite)getSysNoticeExtra()); 
      if (this.videoCallingExtra_ != null)
        param1CodedOutputStream.writeMessage(16, (MessageLite)getVideoCallingExtra()); 
      if (this.videoEndExtra_ != null)
        param1CodedOutputStream.writeMessage(17, (MessageLite)getVideoEndExtra()); 
      if (this.feedShareExtra_ != null)
        param1CodedOutputStream.writeMessage(18, (MessageLite)getFeedShareExtra()); 
      if (this.sayHiExtra_ != null)
        param1CodedOutputStream.writeMessage(19, (MessageLite)getSayHiExtra()); 
      if (this.voiceRoomShareExtra_ != null)
        param1CodedOutputStream.writeMessage(20, (MessageLite)getVoiceRoomShareExtra()); 
      if (this.liveShareInternationalExtra_ != null)
        param1CodedOutputStream.writeMessage(21, (MessageLite)getLiveShareInternationalExtra()); 
      if (this.doodleShareExtra_ != null)
        param1CodedOutputStream.writeMessage(22, (MessageLite)getDoodleShareExtra()); 
      if (this.groupNotice_ != null)
        param1CodedOutputStream.writeMessage(23, (MessageLite)getGroupNotice()); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushBodyExtraOuterClass.PushBodyExtraOrBuilder {
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> doodleShareExtraBuilder_;
      
      private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> feedShareExtraBuilder_;
      
      private MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> giftExtraBuilder_;
      
      private MsgBodyExtraOuterClass.GiftExtra giftExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> groupCardExtraBuilder_;
      
      private MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> groupNoticeBuilder_;
      
      private MsgBodyExtraOuterClass.GroupNotice groupNotice_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> hidenAlbumExtraBuilder_;
      
      private MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> imagetextExtraBuilder_;
      
      private MsgBodyExtraOuterClass.ImageTextExtra imagetextExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> imgExtraBuilder_;
      
      private MsgBodyExtraOuterClass.ImgExtra imgExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> liveShareExtraBuilder_;
      
      private MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> liveShareInternationalExtraBuilder_;
      
      private MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> locationExtraBuilder_;
      
      private MsgBodyExtraOuterClass.LocationExtra locationExtra_;
      
      private long msgReceiveFrom_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> msgSourceBuilder_;
      
      private MsgBodyExtraOuterClass.MsgSource msgSource_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> sayHiExtraBuilder_;
      
      private MsgBodyExtraOuterClass.SayHiExtra sayHiExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> secureNotifyBuilder_;
      
      private MsgBodyExtraOuterClass.SecureNotify secureNotify_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> shareExtraBuilder_;
      
      private MsgBodyExtraOuterClass.ShareExtra shareExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> sysNoticeExtraBuilder_;
      
      private MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> textExtraBuilder_;
      
      private MsgBodyExtraOuterClass.TextExtra textExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> videoCallingExtraBuilder_;
      
      private MsgBodyExtraOuterClass.VideoChatCallingExtra videoCallingExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> videoEndExtraBuilder_;
      
      private MsgBodyExtraOuterClass.VideoChatEndExtra videoEndExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> videoExtraBuilder_;
      
      private MsgBodyExtraOuterClass.VideoExtra videoExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> vipExtraBuilder_;
      
      private MsgBodyExtraOuterClass.VipExtra vipExtra_;
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> voiceRoomShareExtraBuilder_;
      
      private MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> getDoodleShareExtraFieldBuilder() {
        if (this.doodleShareExtraBuilder_ == null) {
          this.doodleShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getDoodleShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.doodleShareExtra_ = null;
        } 
        return this.doodleShareExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> getFeedShareExtraFieldBuilder() {
        if (this.feedShareExtraBuilder_ == null) {
          this.feedShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getFeedShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.feedShareExtra_ = null;
        } 
        return this.feedShareExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> getGiftExtraFieldBuilder() {
        if (this.giftExtraBuilder_ == null) {
          this.giftExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGiftExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.giftExtra_ = null;
        } 
        return this.giftExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> getGroupCardExtraFieldBuilder() {
        if (this.groupCardExtraBuilder_ == null) {
          this.groupCardExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGroupCardExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.groupCardExtra_ = null;
        } 
        return this.groupCardExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> getGroupNoticeFieldBuilder() {
        if (this.groupNoticeBuilder_ == null) {
          this.groupNoticeBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGroupNotice(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.groupNotice_ = null;
        } 
        return this.groupNoticeBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> getHidenAlbumExtraFieldBuilder() {
        if (this.hidenAlbumExtraBuilder_ == null) {
          this.hidenAlbumExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getHidenAlbumExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.hidenAlbumExtra_ = null;
        } 
        return this.hidenAlbumExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> getImagetextExtraFieldBuilder() {
        if (this.imagetextExtraBuilder_ == null) {
          this.imagetextExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getImagetextExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.imagetextExtra_ = null;
        } 
        return this.imagetextExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> getImgExtraFieldBuilder() {
        if (this.imgExtraBuilder_ == null) {
          this.imgExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getImgExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.imgExtra_ = null;
        } 
        return this.imgExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> getLiveShareExtraFieldBuilder() {
        if (this.liveShareExtraBuilder_ == null) {
          this.liveShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLiveShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.liveShareExtra_ = null;
        } 
        return this.liveShareExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> getLiveShareInternationalExtraFieldBuilder() {
        if (this.liveShareInternationalExtraBuilder_ == null) {
          this.liveShareInternationalExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLiveShareInternationalExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.liveShareInternationalExtra_ = null;
        } 
        return this.liveShareInternationalExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> getLocationExtraFieldBuilder() {
        if (this.locationExtraBuilder_ == null) {
          this.locationExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLocationExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.locationExtra_ = null;
        } 
        return this.locationExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> getMsgSourceFieldBuilder() {
        if (this.msgSourceBuilder_ == null) {
          this.msgSourceBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getMsgSource(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.msgSource_ = null;
        } 
        return this.msgSourceBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> getSayHiExtraFieldBuilder() {
        if (this.sayHiExtraBuilder_ == null) {
          this.sayHiExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSayHiExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.sayHiExtra_ = null;
        } 
        return this.sayHiExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> getSecureNotifyFieldBuilder() {
        if (this.secureNotifyBuilder_ == null) {
          this.secureNotifyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSecureNotify(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.secureNotify_ = null;
        } 
        return this.secureNotifyBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> getShareExtraFieldBuilder() {
        if (this.shareExtraBuilder_ == null) {
          this.shareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.shareExtra_ = null;
        } 
        return this.shareExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> getSysNoticeExtraFieldBuilder() {
        if (this.sysNoticeExtraBuilder_ == null) {
          this.sysNoticeExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSysNoticeExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.sysNoticeExtra_ = null;
        } 
        return this.sysNoticeExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> getTextExtraFieldBuilder() {
        if (this.textExtraBuilder_ == null) {
          this.textExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTextExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.textExtra_ = null;
        } 
        return this.textExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> getVideoCallingExtraFieldBuilder() {
        if (this.videoCallingExtraBuilder_ == null) {
          this.videoCallingExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoCallingExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.videoCallingExtra_ = null;
        } 
        return this.videoCallingExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> getVideoEndExtraFieldBuilder() {
        if (this.videoEndExtraBuilder_ == null) {
          this.videoEndExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoEndExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.videoEndExtra_ = null;
        } 
        return this.videoEndExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> getVideoExtraFieldBuilder() {
        if (this.videoExtraBuilder_ == null) {
          this.videoExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.videoExtra_ = null;
        } 
        return this.videoExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> getVipExtraFieldBuilder() {
        if (this.vipExtraBuilder_ == null) {
          this.vipExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVipExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.vipExtra_ = null;
        } 
        return this.vipExtraBuilder_;
      }
      
      private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> getVoiceRoomShareExtraFieldBuilder() {
        if (this.voiceRoomShareExtraBuilder_ == null) {
          this.voiceRoomShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVoiceRoomShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
          this.voiceRoomShareExtra_ = null;
        } 
        return this.voiceRoomShareExtraBuilder_;
      }
      
      private void maybeForceBuilderInitialization() {
        PushBodyExtraOuterClass.PushBodyExtra.alwaysUseFieldBuilders;
      }
      
      public Builder addRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.addRepeatedField(param2FieldDescriptor, param2Object);
      }
      
      public PushBodyExtraOuterClass.PushBodyExtra build() {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = buildPartial();
        if (pushBodyExtra.isInitialized())
          return pushBodyExtra; 
        throw newUninitializedMessageException(pushBodyExtra);
      }
      
      public PushBodyExtraOuterClass.PushBodyExtra buildPartial() {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = new PushBodyExtraOuterClass.PushBodyExtra(this);
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV321 = this.msgSourceBuilder_;
        if (singleFieldBuilderV321 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$602(pushBodyExtra, this.msgSource_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$602(pushBodyExtra, (MsgBodyExtraOuterClass.MsgSource)singleFieldBuilderV321.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV320 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV320 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$702(pushBodyExtra, this.secureNotify_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$702(pushBodyExtra, (MsgBodyExtraOuterClass.SecureNotify)singleFieldBuilderV320.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV319 = this.textExtraBuilder_;
        if (singleFieldBuilderV319 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$802(pushBodyExtra, this.textExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$802(pushBodyExtra, (MsgBodyExtraOuterClass.TextExtra)singleFieldBuilderV319.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV318 = this.imgExtraBuilder_;
        if (singleFieldBuilderV318 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$902(pushBodyExtra, this.imgExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$902(pushBodyExtra, (MsgBodyExtraOuterClass.ImgExtra)singleFieldBuilderV318.build());
        } 
        PushBodyExtraOuterClass.PushBodyExtra.access$1002(pushBodyExtra, this.msgReceiveFrom_);
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV317 = this.locationExtraBuilder_;
        if (singleFieldBuilderV317 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1102(pushBodyExtra, this.locationExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1102(pushBodyExtra, (MsgBodyExtraOuterClass.LocationExtra)singleFieldBuilderV317.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV316 = this.videoExtraBuilder_;
        if (singleFieldBuilderV316 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1202(pushBodyExtra, this.videoExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1202(pushBodyExtra, (MsgBodyExtraOuterClass.VideoExtra)singleFieldBuilderV316.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV315 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV315 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1302(pushBodyExtra, this.groupCardExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1302(pushBodyExtra, (MsgBodyExtraOuterClass.GroupCardExtra)singleFieldBuilderV315.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV314 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV314 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1402(pushBodyExtra, this.liveShareExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1402(pushBodyExtra, (MsgBodyExtraOuterClass.LiveShareExtra)singleFieldBuilderV314.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV313 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV313 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1502(pushBodyExtra, this.imagetextExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1502(pushBodyExtra, (MsgBodyExtraOuterClass.ImageTextExtra)singleFieldBuilderV313.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV312 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV312 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1602(pushBodyExtra, this.hidenAlbumExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1602(pushBodyExtra, (MsgBodyExtraOuterClass.HidenAlbumExtra)singleFieldBuilderV312.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV311 = this.shareExtraBuilder_;
        if (singleFieldBuilderV311 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1702(pushBodyExtra, this.shareExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1702(pushBodyExtra, (MsgBodyExtraOuterClass.ShareExtra)singleFieldBuilderV311.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV310 = this.vipExtraBuilder_;
        if (singleFieldBuilderV310 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1802(pushBodyExtra, this.vipExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1802(pushBodyExtra, (MsgBodyExtraOuterClass.VipExtra)singleFieldBuilderV310.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV39 = this.giftExtraBuilder_;
        if (singleFieldBuilderV39 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$1902(pushBodyExtra, this.giftExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$1902(pushBodyExtra, (MsgBodyExtraOuterClass.GiftExtra)singleFieldBuilderV39.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV38 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV38 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2002(pushBodyExtra, this.sysNoticeExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2002(pushBodyExtra, (MsgBodyExtraOuterClass.SysNoticeExtra)singleFieldBuilderV38.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV37 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV37 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2102(pushBodyExtra, this.videoCallingExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2102(pushBodyExtra, (MsgBodyExtraOuterClass.VideoChatCallingExtra)singleFieldBuilderV37.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV36 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV36 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2202(pushBodyExtra, this.videoEndExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2202(pushBodyExtra, (MsgBodyExtraOuterClass.VideoChatEndExtra)singleFieldBuilderV36.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV35 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV35 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2302(pushBodyExtra, this.feedShareExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2302(pushBodyExtra, (MsgBodyExtraOuterClass.FeedShareExtra)singleFieldBuilderV35.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV34 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV34 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2402(pushBodyExtra, this.sayHiExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2402(pushBodyExtra, (MsgBodyExtraOuterClass.SayHiExtra)singleFieldBuilderV34.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV33 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV33 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2502(pushBodyExtra, this.voiceRoomShareExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2502(pushBodyExtra, (MsgBodyExtraOuterClass.VoiceRoomShareExtra)singleFieldBuilderV33.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV32 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV32 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2602(pushBodyExtra, this.liveShareInternationalExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2602(pushBodyExtra, (MsgBodyExtraOuterClass.LiveShareInternationalExtra)singleFieldBuilderV32.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV31 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV31 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2702(pushBodyExtra, this.doodleShareExtra_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2702(pushBodyExtra, (MsgBodyExtraOuterClass.DoodleShareExtra)singleFieldBuilderV31.build());
        } 
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 == null) {
          PushBodyExtraOuterClass.PushBodyExtra.access$2802(pushBodyExtra, this.groupNotice_);
        } else {
          PushBodyExtraOuterClass.PushBodyExtra.access$2802(pushBodyExtra, (MsgBodyExtraOuterClass.GroupNotice)singleFieldBuilderV3.build());
        } 
        onBuilt();
        return pushBodyExtra;
      }
      
      public Builder clear() {
        super.clear();
        if (this.msgSourceBuilder_ == null) {
          this.msgSource_ = null;
        } else {
          this.msgSource_ = null;
          this.msgSourceBuilder_ = null;
        } 
        if (this.secureNotifyBuilder_ == null) {
          this.secureNotify_ = null;
        } else {
          this.secureNotify_ = null;
          this.secureNotifyBuilder_ = null;
        } 
        if (this.textExtraBuilder_ == null) {
          this.textExtra_ = null;
        } else {
          this.textExtra_ = null;
          this.textExtraBuilder_ = null;
        } 
        if (this.imgExtraBuilder_ == null) {
          this.imgExtra_ = null;
        } else {
          this.imgExtra_ = null;
          this.imgExtraBuilder_ = null;
        } 
        this.msgReceiveFrom_ = 0L;
        if (this.locationExtraBuilder_ == null) {
          this.locationExtra_ = null;
        } else {
          this.locationExtra_ = null;
          this.locationExtraBuilder_ = null;
        } 
        if (this.videoExtraBuilder_ == null) {
          this.videoExtra_ = null;
        } else {
          this.videoExtra_ = null;
          this.videoExtraBuilder_ = null;
        } 
        if (this.groupCardExtraBuilder_ == null) {
          this.groupCardExtra_ = null;
        } else {
          this.groupCardExtra_ = null;
          this.groupCardExtraBuilder_ = null;
        } 
        if (this.liveShareExtraBuilder_ == null) {
          this.liveShareExtra_ = null;
        } else {
          this.liveShareExtra_ = null;
          this.liveShareExtraBuilder_ = null;
        } 
        if (this.imagetextExtraBuilder_ == null) {
          this.imagetextExtra_ = null;
        } else {
          this.imagetextExtra_ = null;
          this.imagetextExtraBuilder_ = null;
        } 
        if (this.hidenAlbumExtraBuilder_ == null) {
          this.hidenAlbumExtra_ = null;
        } else {
          this.hidenAlbumExtra_ = null;
          this.hidenAlbumExtraBuilder_ = null;
        } 
        if (this.shareExtraBuilder_ == null) {
          this.shareExtra_ = null;
        } else {
          this.shareExtra_ = null;
          this.shareExtraBuilder_ = null;
        } 
        if (this.vipExtraBuilder_ == null) {
          this.vipExtra_ = null;
        } else {
          this.vipExtra_ = null;
          this.vipExtraBuilder_ = null;
        } 
        if (this.giftExtraBuilder_ == null) {
          this.giftExtra_ = null;
        } else {
          this.giftExtra_ = null;
          this.giftExtraBuilder_ = null;
        } 
        if (this.sysNoticeExtraBuilder_ == null) {
          this.sysNoticeExtra_ = null;
        } else {
          this.sysNoticeExtra_ = null;
          this.sysNoticeExtraBuilder_ = null;
        } 
        if (this.videoCallingExtraBuilder_ == null) {
          this.videoCallingExtra_ = null;
        } else {
          this.videoCallingExtra_ = null;
          this.videoCallingExtraBuilder_ = null;
        } 
        if (this.videoEndExtraBuilder_ == null) {
          this.videoEndExtra_ = null;
        } else {
          this.videoEndExtra_ = null;
          this.videoEndExtraBuilder_ = null;
        } 
        if (this.feedShareExtraBuilder_ == null) {
          this.feedShareExtra_ = null;
        } else {
          this.feedShareExtra_ = null;
          this.feedShareExtraBuilder_ = null;
        } 
        if (this.sayHiExtraBuilder_ == null) {
          this.sayHiExtra_ = null;
        } else {
          this.sayHiExtra_ = null;
          this.sayHiExtraBuilder_ = null;
        } 
        if (this.voiceRoomShareExtraBuilder_ == null) {
          this.voiceRoomShareExtra_ = null;
        } else {
          this.voiceRoomShareExtra_ = null;
          this.voiceRoomShareExtraBuilder_ = null;
        } 
        if (this.liveShareInternationalExtraBuilder_ == null) {
          this.liveShareInternationalExtra_ = null;
        } else {
          this.liveShareInternationalExtra_ = null;
          this.liveShareInternationalExtraBuilder_ = null;
        } 
        if (this.doodleShareExtraBuilder_ == null) {
          this.doodleShareExtra_ = null;
        } else {
          this.doodleShareExtra_ = null;
          this.doodleShareExtraBuilder_ = null;
        } 
        if (this.groupNoticeBuilder_ == null) {
          this.groupNotice_ = null;
          return this;
        } 
        this.groupNotice_ = null;
        this.groupNoticeBuilder_ = null;
        return this;
      }
      
      public Builder clearDoodleShareExtra() {
        if (this.doodleShareExtraBuilder_ == null) {
          this.doodleShareExtra_ = null;
          onChanged();
          return this;
        } 
        this.doodleShareExtra_ = null;
        this.doodleShareExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearFeedShareExtra() {
        if (this.feedShareExtraBuilder_ == null) {
          this.feedShareExtra_ = null;
          onChanged();
          return this;
        } 
        this.feedShareExtra_ = null;
        this.feedShareExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearGiftExtra() {
        if (this.giftExtraBuilder_ == null) {
          this.giftExtra_ = null;
          onChanged();
          return this;
        } 
        this.giftExtra_ = null;
        this.giftExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearGroupCardExtra() {
        if (this.groupCardExtraBuilder_ == null) {
          this.groupCardExtra_ = null;
          onChanged();
          return this;
        } 
        this.groupCardExtra_ = null;
        this.groupCardExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearGroupNotice() {
        if (this.groupNoticeBuilder_ == null) {
          this.groupNotice_ = null;
          onChanged();
          return this;
        } 
        this.groupNotice_ = null;
        this.groupNoticeBuilder_ = null;
        return this;
      }
      
      public Builder clearHidenAlbumExtra() {
        if (this.hidenAlbumExtraBuilder_ == null) {
          this.hidenAlbumExtra_ = null;
          onChanged();
          return this;
        } 
        this.hidenAlbumExtra_ = null;
        this.hidenAlbumExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearImagetextExtra() {
        if (this.imagetextExtraBuilder_ == null) {
          this.imagetextExtra_ = null;
          onChanged();
          return this;
        } 
        this.imagetextExtra_ = null;
        this.imagetextExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearImgExtra() {
        if (this.imgExtraBuilder_ == null) {
          this.imgExtra_ = null;
          onChanged();
          return this;
        } 
        this.imgExtra_ = null;
        this.imgExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearLiveShareExtra() {
        if (this.liveShareExtraBuilder_ == null) {
          this.liveShareExtra_ = null;
          onChanged();
          return this;
        } 
        this.liveShareExtra_ = null;
        this.liveShareExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearLiveShareInternationalExtra() {
        if (this.liveShareInternationalExtraBuilder_ == null) {
          this.liveShareInternationalExtra_ = null;
          onChanged();
          return this;
        } 
        this.liveShareInternationalExtra_ = null;
        this.liveShareInternationalExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearLocationExtra() {
        if (this.locationExtraBuilder_ == null) {
          this.locationExtra_ = null;
          onChanged();
          return this;
        } 
        this.locationExtra_ = null;
        this.locationExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearMsgReceiveFrom() {
        this.msgReceiveFrom_ = 0L;
        onChanged();
        return this;
      }
      
      public Builder clearMsgSource() {
        if (this.msgSourceBuilder_ == null) {
          this.msgSource_ = null;
          onChanged();
          return this;
        } 
        this.msgSource_ = null;
        this.msgSourceBuilder_ = null;
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearSayHiExtra() {
        if (this.sayHiExtraBuilder_ == null) {
          this.sayHiExtra_ = null;
          onChanged();
          return this;
        } 
        this.sayHiExtra_ = null;
        this.sayHiExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearSecureNotify() {
        if (this.secureNotifyBuilder_ == null) {
          this.secureNotify_ = null;
          onChanged();
          return this;
        } 
        this.secureNotify_ = null;
        this.secureNotifyBuilder_ = null;
        return this;
      }
      
      public Builder clearShareExtra() {
        if (this.shareExtraBuilder_ == null) {
          this.shareExtra_ = null;
          onChanged();
          return this;
        } 
        this.shareExtra_ = null;
        this.shareExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearSysNoticeExtra() {
        if (this.sysNoticeExtraBuilder_ == null) {
          this.sysNoticeExtra_ = null;
          onChanged();
          return this;
        } 
        this.sysNoticeExtra_ = null;
        this.sysNoticeExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearTextExtra() {
        if (this.textExtraBuilder_ == null) {
          this.textExtra_ = null;
          onChanged();
          return this;
        } 
        this.textExtra_ = null;
        this.textExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearVideoCallingExtra() {
        if (this.videoCallingExtraBuilder_ == null) {
          this.videoCallingExtra_ = null;
          onChanged();
          return this;
        } 
        this.videoCallingExtra_ = null;
        this.videoCallingExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearVideoEndExtra() {
        if (this.videoEndExtraBuilder_ == null) {
          this.videoEndExtra_ = null;
          onChanged();
          return this;
        } 
        this.videoEndExtra_ = null;
        this.videoEndExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearVideoExtra() {
        if (this.videoExtraBuilder_ == null) {
          this.videoExtra_ = null;
          onChanged();
          return this;
        } 
        this.videoExtra_ = null;
        this.videoExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearVipExtra() {
        if (this.vipExtraBuilder_ == null) {
          this.vipExtra_ = null;
          onChanged();
          return this;
        } 
        this.vipExtra_ = null;
        this.vipExtraBuilder_ = null;
        return this;
      }
      
      public Builder clearVoiceRoomShareExtra() {
        if (this.voiceRoomShareExtraBuilder_ == null) {
          this.voiceRoomShareExtra_ = null;
          onChanged();
          return this;
        } 
        this.voiceRoomShareExtra_ = null;
        this.voiceRoomShareExtraBuilder_ = null;
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public PushBodyExtraOuterClass.PushBodyExtra getDefaultInstanceForType() {
        return PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
      }
      
      public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
        MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra1 = this.doodleShareExtra_;
          doodleShareExtra = doodleShareExtra1;
          if (doodleShareExtra1 == null)
            doodleShareExtra = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance(); 
          return doodleShareExtra;
        } 
        return (MsgBodyExtraOuterClass.DoodleShareExtra)doodleShareExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.DoodleShareExtra.Builder getDoodleShareExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.DoodleShareExtra.Builder)getDoodleShareExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = this.doodleShareExtra_;
        MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra1 = doodleShareExtra2;
        if (doodleShareExtra2 == null)
          doodleShareExtra1 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance(); 
        return doodleShareExtra1;
      }
      
      public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
        MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra1 = this.feedShareExtra_;
          feedShareExtra = feedShareExtra1;
          if (feedShareExtra1 == null)
            feedShareExtra = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance(); 
          return feedShareExtra;
        } 
        return (MsgBodyExtraOuterClass.FeedShareExtra)feedShareExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.FeedShareExtra.Builder getFeedShareExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.FeedShareExtra.Builder)getFeedShareExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.FeedShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = this.feedShareExtra_;
        MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra1 = feedShareExtra2;
        if (feedShareExtra2 == null)
          feedShareExtra1 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance(); 
        return feedShareExtra1;
      }
      
      public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
        MsgBodyExtraOuterClass.GiftExtra giftExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.GiftExtra giftExtra1 = this.giftExtra_;
          giftExtra = giftExtra1;
          if (giftExtra1 == null)
            giftExtra = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance(); 
          return giftExtra;
        } 
        return (MsgBodyExtraOuterClass.GiftExtra)giftExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.GiftExtra.Builder getGiftExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.GiftExtra.Builder)getGiftExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.GiftExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.GiftExtra giftExtra2 = this.giftExtra_;
        MsgBodyExtraOuterClass.GiftExtra giftExtra1 = giftExtra2;
        if (giftExtra2 == null)
          giftExtra1 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance(); 
        return giftExtra1;
      }
      
      public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
        MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra1 = this.groupCardExtra_;
          groupCardExtra = groupCardExtra1;
          if (groupCardExtra1 == null)
            groupCardExtra = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance(); 
          return groupCardExtra;
        } 
        return (MsgBodyExtraOuterClass.GroupCardExtra)groupCardExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.GroupCardExtra.Builder getGroupCardExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.GroupCardExtra.Builder)getGroupCardExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.GroupCardExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = this.groupCardExtra_;
        MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra1 = groupCardExtra2;
        if (groupCardExtra2 == null)
          groupCardExtra1 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance(); 
        return groupCardExtra1;
      }
      
      public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
        MsgBodyExtraOuterClass.GroupNotice groupNotice;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.GroupNotice groupNotice1 = this.groupNotice_;
          groupNotice = groupNotice1;
          if (groupNotice1 == null)
            groupNotice = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance(); 
          return groupNotice;
        } 
        return (MsgBodyExtraOuterClass.GroupNotice)groupNotice.getMessage();
      }
      
      public MsgBodyExtraOuterClass.GroupNotice.Builder getGroupNoticeBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.GroupNotice.Builder)getGroupNoticeFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.GroupNoticeOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.GroupNotice groupNotice2 = this.groupNotice_;
        MsgBodyExtraOuterClass.GroupNotice groupNotice1 = groupNotice2;
        if (groupNotice2 == null)
          groupNotice1 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance(); 
        return groupNotice1;
      }
      
      public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
        MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra1 = this.hidenAlbumExtra_;
          hidenAlbumExtra = hidenAlbumExtra1;
          if (hidenAlbumExtra1 == null)
            hidenAlbumExtra = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance(); 
          return hidenAlbumExtra;
        } 
        return (MsgBodyExtraOuterClass.HidenAlbumExtra)hidenAlbumExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.HidenAlbumExtra.Builder getHidenAlbumExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.HidenAlbumExtra.Builder)getHidenAlbumExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = this.hidenAlbumExtra_;
        MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra1 = hidenAlbumExtra2;
        if (hidenAlbumExtra2 == null)
          hidenAlbumExtra1 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance(); 
        return hidenAlbumExtra1;
      }
      
      public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
        MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra1 = this.imagetextExtra_;
          imageTextExtra = imageTextExtra1;
          if (imageTextExtra1 == null)
            imageTextExtra = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance(); 
          return imageTextExtra;
        } 
        return (MsgBodyExtraOuterClass.ImageTextExtra)imageTextExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.ImageTextExtra.Builder getImagetextExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.ImageTextExtra.Builder)getImagetextExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.ImageTextExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = this.imagetextExtra_;
        MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra1 = imageTextExtra2;
        if (imageTextExtra2 == null)
          imageTextExtra1 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance(); 
        return imageTextExtra1;
      }
      
      public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
        MsgBodyExtraOuterClass.ImgExtra imgExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.ImgExtra imgExtra1 = this.imgExtra_;
          imgExtra = imgExtra1;
          if (imgExtra1 == null)
            imgExtra = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance(); 
          return imgExtra;
        } 
        return (MsgBodyExtraOuterClass.ImgExtra)imgExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.ImgExtra.Builder getImgExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.ImgExtra.Builder)getImgExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.ImgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.ImgExtra imgExtra2 = this.imgExtra_;
        MsgBodyExtraOuterClass.ImgExtra imgExtra1 = imgExtra2;
        if (imgExtra2 == null)
          imgExtra1 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance(); 
        return imgExtra1;
      }
      
      public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
        MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra1 = this.liveShareExtra_;
          liveShareExtra = liveShareExtra1;
          if (liveShareExtra1 == null)
            liveShareExtra = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance(); 
          return liveShareExtra;
        } 
        return (MsgBodyExtraOuterClass.LiveShareExtra)liveShareExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.LiveShareExtra.Builder getLiveShareExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.LiveShareExtra.Builder)getLiveShareExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.LiveShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = this.liveShareExtra_;
        MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra1 = liveShareExtra2;
        if (liveShareExtra2 == null)
          liveShareExtra1 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance(); 
        return liveShareExtra1;
      }
      
      public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
        MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra1 = this.liveShareInternationalExtra_;
          liveShareInternationalExtra = liveShareInternationalExtra1;
          if (liveShareInternationalExtra1 == null)
            liveShareInternationalExtra = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance(); 
          return liveShareInternationalExtra;
        } 
        return (MsgBodyExtraOuterClass.LiveShareInternationalExtra)liveShareInternationalExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder getLiveShareInternationalExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder)getLiveShareInternationalExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = this.liveShareInternationalExtra_;
        MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra1 = liveShareInternationalExtra2;
        if (liveShareInternationalExtra2 == null)
          liveShareInternationalExtra1 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance(); 
        return liveShareInternationalExtra1;
      }
      
      public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
        MsgBodyExtraOuterClass.LocationExtra locationExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.LocationExtra locationExtra1 = this.locationExtra_;
          locationExtra = locationExtra1;
          if (locationExtra1 == null)
            locationExtra = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance(); 
          return locationExtra;
        } 
        return (MsgBodyExtraOuterClass.LocationExtra)locationExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.LocationExtra.Builder getLocationExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.LocationExtra.Builder)getLocationExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.LocationExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.LocationExtra locationExtra2 = this.locationExtra_;
        MsgBodyExtraOuterClass.LocationExtra locationExtra1 = locationExtra2;
        if (locationExtra2 == null)
          locationExtra1 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance(); 
        return locationExtra1;
      }
      
      public long getMsgReceiveFrom() {
        return this.msgReceiveFrom_;
      }
      
      public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
        MsgBodyExtraOuterClass.MsgSource msgSource;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.MsgSource msgSource1 = this.msgSource_;
          msgSource = msgSource1;
          if (msgSource1 == null)
            msgSource = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance(); 
          return msgSource;
        } 
        return (MsgBodyExtraOuterClass.MsgSource)msgSource.getMessage();
      }
      
      public MsgBodyExtraOuterClass.MsgSource.Builder getMsgSourceBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.MsgSource.Builder)getMsgSourceFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.MsgSourceOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.MsgSource msgSource2 = this.msgSource_;
        MsgBodyExtraOuterClass.MsgSource msgSource1 = msgSource2;
        if (msgSource2 == null)
          msgSource1 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance(); 
        return msgSource1;
      }
      
      public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
        MsgBodyExtraOuterClass.SayHiExtra sayHiExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.SayHiExtra sayHiExtra1 = this.sayHiExtra_;
          sayHiExtra = sayHiExtra1;
          if (sayHiExtra1 == null)
            sayHiExtra = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance(); 
          return sayHiExtra;
        } 
        return (MsgBodyExtraOuterClass.SayHiExtra)sayHiExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.SayHiExtra.Builder getSayHiExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.SayHiExtra.Builder)getSayHiExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.SayHiExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = this.sayHiExtra_;
        MsgBodyExtraOuterClass.SayHiExtra sayHiExtra1 = sayHiExtra2;
        if (sayHiExtra2 == null)
          sayHiExtra1 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance(); 
        return sayHiExtra1;
      }
      
      public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
        MsgBodyExtraOuterClass.SecureNotify secureNotify;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.SecureNotify secureNotify1 = this.secureNotify_;
          secureNotify = secureNotify1;
          if (secureNotify1 == null)
            secureNotify = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance(); 
          return secureNotify;
        } 
        return (MsgBodyExtraOuterClass.SecureNotify)secureNotify.getMessage();
      }
      
      public MsgBodyExtraOuterClass.SecureNotify.Builder getSecureNotifyBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.SecureNotify.Builder)getSecureNotifyFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.SecureNotifyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.SecureNotify secureNotify2 = this.secureNotify_;
        MsgBodyExtraOuterClass.SecureNotify secureNotify1 = secureNotify2;
        if (secureNotify2 == null)
          secureNotify1 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance(); 
        return secureNotify1;
      }
      
      public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
        MsgBodyExtraOuterClass.ShareExtra shareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.ShareExtra shareExtra1 = this.shareExtra_;
          shareExtra = shareExtra1;
          if (shareExtra1 == null)
            shareExtra = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance(); 
          return shareExtra;
        } 
        return (MsgBodyExtraOuterClass.ShareExtra)shareExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.ShareExtra.Builder getShareExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.ShareExtra.Builder)getShareExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.ShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.ShareExtra shareExtra2 = this.shareExtra_;
        MsgBodyExtraOuterClass.ShareExtra shareExtra1 = shareExtra2;
        if (shareExtra2 == null)
          shareExtra1 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance(); 
        return shareExtra1;
      }
      
      public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
        MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra1 = this.sysNoticeExtra_;
          sysNoticeExtra = sysNoticeExtra1;
          if (sysNoticeExtra1 == null)
            sysNoticeExtra = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance(); 
          return sysNoticeExtra;
        } 
        return (MsgBodyExtraOuterClass.SysNoticeExtra)sysNoticeExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.SysNoticeExtra.Builder getSysNoticeExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.SysNoticeExtra.Builder)getSysNoticeExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = this.sysNoticeExtra_;
        MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra1 = sysNoticeExtra2;
        if (sysNoticeExtra2 == null)
          sysNoticeExtra1 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance(); 
        return sysNoticeExtra1;
      }
      
      public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
        MsgBodyExtraOuterClass.TextExtra textExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.TextExtra textExtra1 = this.textExtra_;
          textExtra = textExtra1;
          if (textExtra1 == null)
            textExtra = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance(); 
          return textExtra;
        } 
        return (MsgBodyExtraOuterClass.TextExtra)textExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.TextExtra.Builder getTextExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.TextExtra.Builder)getTextExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.TextExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.TextExtra textExtra2 = this.textExtra_;
        MsgBodyExtraOuterClass.TextExtra textExtra1 = textExtra2;
        if (textExtra2 == null)
          textExtra1 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance(); 
        return textExtra1;
      }
      
      public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
        MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra1 = this.videoCallingExtra_;
          videoChatCallingExtra = videoChatCallingExtra1;
          if (videoChatCallingExtra1 == null)
            videoChatCallingExtra = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance(); 
          return videoChatCallingExtra;
        } 
        return (MsgBodyExtraOuterClass.VideoChatCallingExtra)videoChatCallingExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder getVideoCallingExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder)getVideoCallingExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = this.videoCallingExtra_;
        MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra1 = videoChatCallingExtra2;
        if (videoChatCallingExtra2 == null)
          videoChatCallingExtra1 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance(); 
        return videoChatCallingExtra1;
      }
      
      public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
        MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra1 = this.videoEndExtra_;
          videoChatEndExtra = videoChatEndExtra1;
          if (videoChatEndExtra1 == null)
            videoChatEndExtra = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance(); 
          return videoChatEndExtra;
        } 
        return (MsgBodyExtraOuterClass.VideoChatEndExtra)videoChatEndExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.VideoChatEndExtra.Builder getVideoEndExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.VideoChatEndExtra.Builder)getVideoEndExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = this.videoEndExtra_;
        MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra1 = videoChatEndExtra2;
        if (videoChatEndExtra2 == null)
          videoChatEndExtra1 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance(); 
        return videoChatEndExtra1;
      }
      
      public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
        MsgBodyExtraOuterClass.VideoExtra videoExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.VideoExtra videoExtra1 = this.videoExtra_;
          videoExtra = videoExtra1;
          if (videoExtra1 == null)
            videoExtra = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance(); 
          return videoExtra;
        } 
        return (MsgBodyExtraOuterClass.VideoExtra)videoExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.VideoExtra.Builder getVideoExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.VideoExtra.Builder)getVideoExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.VideoExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.VideoExtra videoExtra2 = this.videoExtra_;
        MsgBodyExtraOuterClass.VideoExtra videoExtra1 = videoExtra2;
        if (videoExtra2 == null)
          videoExtra1 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance(); 
        return videoExtra1;
      }
      
      public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
        MsgBodyExtraOuterClass.VipExtra vipExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.VipExtra vipExtra1 = this.vipExtra_;
          vipExtra = vipExtra1;
          if (vipExtra1 == null)
            vipExtra = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance(); 
          return vipExtra;
        } 
        return (MsgBodyExtraOuterClass.VipExtra)vipExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.VipExtra.Builder getVipExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.VipExtra.Builder)getVipExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.VipExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.VipExtra vipExtra2 = this.vipExtra_;
        MsgBodyExtraOuterClass.VipExtra vipExtra1 = vipExtra2;
        if (vipExtra2 == null)
          vipExtra1 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance(); 
        return vipExtra1;
      }
      
      public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
        MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra1 = this.voiceRoomShareExtra_;
          voiceRoomShareExtra = voiceRoomShareExtra1;
          if (voiceRoomShareExtra1 == null)
            voiceRoomShareExtra = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance(); 
          return voiceRoomShareExtra;
        } 
        return (MsgBodyExtraOuterClass.VoiceRoomShareExtra)voiceRoomShareExtra.getMessage();
      }
      
      public MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder getVoiceRoomShareExtraBuilder() {
        onChanged();
        return (MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder)getVoiceRoomShareExtraFieldBuilder().getBuilder();
      }
      
      public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV3 != null)
          return (MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
        MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = this.voiceRoomShareExtra_;
        MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra1 = voiceRoomShareExtra2;
        if (voiceRoomShareExtra2 == null)
          voiceRoomShareExtra1 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance(); 
        return voiceRoomShareExtra1;
      }
      
      public boolean hasDoodleShareExtra() {
        return (this.doodleShareExtraBuilder_ != null || this.doodleShareExtra_ != null);
      }
      
      public boolean hasFeedShareExtra() {
        return (this.feedShareExtraBuilder_ != null || this.feedShareExtra_ != null);
      }
      
      public boolean hasGiftExtra() {
        return (this.giftExtraBuilder_ != null || this.giftExtra_ != null);
      }
      
      public boolean hasGroupCardExtra() {
        return (this.groupCardExtraBuilder_ != null || this.groupCardExtra_ != null);
      }
      
      public boolean hasGroupNotice() {
        return (this.groupNoticeBuilder_ != null || this.groupNotice_ != null);
      }
      
      public boolean hasHidenAlbumExtra() {
        return (this.hidenAlbumExtraBuilder_ != null || this.hidenAlbumExtra_ != null);
      }
      
      public boolean hasImagetextExtra() {
        return (this.imagetextExtraBuilder_ != null || this.imagetextExtra_ != null);
      }
      
      public boolean hasImgExtra() {
        return (this.imgExtraBuilder_ != null || this.imgExtra_ != null);
      }
      
      public boolean hasLiveShareExtra() {
        return (this.liveShareExtraBuilder_ != null || this.liveShareExtra_ != null);
      }
      
      public boolean hasLiveShareInternationalExtra() {
        return (this.liveShareInternationalExtraBuilder_ != null || this.liveShareInternationalExtra_ != null);
      }
      
      public boolean hasLocationExtra() {
        return (this.locationExtraBuilder_ != null || this.locationExtra_ != null);
      }
      
      public boolean hasMsgSource() {
        return (this.msgSourceBuilder_ != null || this.msgSource_ != null);
      }
      
      public boolean hasSayHiExtra() {
        return (this.sayHiExtraBuilder_ != null || this.sayHiExtra_ != null);
      }
      
      public boolean hasSecureNotify() {
        return (this.secureNotifyBuilder_ != null || this.secureNotify_ != null);
      }
      
      public boolean hasShareExtra() {
        return (this.shareExtraBuilder_ != null || this.shareExtra_ != null);
      }
      
      public boolean hasSysNoticeExtra() {
        return (this.sysNoticeExtraBuilder_ != null || this.sysNoticeExtra_ != null);
      }
      
      public boolean hasTextExtra() {
        return (this.textExtraBuilder_ != null || this.textExtra_ != null);
      }
      
      public boolean hasVideoCallingExtra() {
        return (this.videoCallingExtraBuilder_ != null || this.videoCallingExtra_ != null);
      }
      
      public boolean hasVideoEndExtra() {
        return (this.videoEndExtraBuilder_ != null || this.videoEndExtra_ != null);
      }
      
      public boolean hasVideoExtra() {
        return (this.videoExtraBuilder_ != null || this.videoExtra_ != null);
      }
      
      public boolean hasVipExtra() {
        return (this.vipExtraBuilder_ != null || this.vipExtra_ != null);
      }
      
      public boolean hasVoiceRoomShareExtra() {
        return (this.voiceRoomShareExtraBuilder_ != null || this.voiceRoomShareExtra_ != null);
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyExtraOuterClass.PushBodyExtra.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra param2DoodleShareExtra) {
        MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          doodleShareExtra = this.doodleShareExtra_;
          if (doodleShareExtra != null) {
            this.doodleShareExtra_ = MsgBodyExtraOuterClass.DoodleShareExtra.newBuilder(doodleShareExtra).mergeFrom(param2DoodleShareExtra).buildPartial();
          } else {
            this.doodleShareExtra_ = param2DoodleShareExtra;
          } 
          onChanged();
          return this;
        } 
        doodleShareExtra.mergeFrom((AbstractMessage)param2DoodleShareExtra);
        return this;
      }
      
      public Builder mergeFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra param2FeedShareExtra) {
        MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          feedShareExtra = this.feedShareExtra_;
          if (feedShareExtra != null) {
            this.feedShareExtra_ = MsgBodyExtraOuterClass.FeedShareExtra.newBuilder(feedShareExtra).mergeFrom(param2FeedShareExtra).buildPartial();
          } else {
            this.feedShareExtra_ = param2FeedShareExtra;
          } 
          onChanged();
          return this;
        } 
        feedShareExtra.mergeFrom((AbstractMessage)param2FeedShareExtra);
        return this;
      }
      
      public Builder mergeFrom(PushBodyExtraOuterClass.PushBodyExtra param2PushBodyExtra) {
        if (param2PushBodyExtra == PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance())
          return this; 
        if (param2PushBodyExtra.hasMsgSource())
          mergeMsgSource(param2PushBodyExtra.getMsgSource()); 
        if (param2PushBodyExtra.hasSecureNotify())
          mergeSecureNotify(param2PushBodyExtra.getSecureNotify()); 
        if (param2PushBodyExtra.hasTextExtra())
          mergeTextExtra(param2PushBodyExtra.getTextExtra()); 
        if (param2PushBodyExtra.hasImgExtra())
          mergeImgExtra(param2PushBodyExtra.getImgExtra()); 
        if (param2PushBodyExtra.getMsgReceiveFrom() != 0L)
          setMsgReceiveFrom(param2PushBodyExtra.getMsgReceiveFrom()); 
        if (param2PushBodyExtra.hasLocationExtra())
          mergeLocationExtra(param2PushBodyExtra.getLocationExtra()); 
        if (param2PushBodyExtra.hasVideoExtra())
          mergeVideoExtra(param2PushBodyExtra.getVideoExtra()); 
        if (param2PushBodyExtra.hasGroupCardExtra())
          mergeGroupCardExtra(param2PushBodyExtra.getGroupCardExtra()); 
        if (param2PushBodyExtra.hasLiveShareExtra())
          mergeLiveShareExtra(param2PushBodyExtra.getLiveShareExtra()); 
        if (param2PushBodyExtra.hasImagetextExtra())
          mergeImagetextExtra(param2PushBodyExtra.getImagetextExtra()); 
        if (param2PushBodyExtra.hasHidenAlbumExtra())
          mergeHidenAlbumExtra(param2PushBodyExtra.getHidenAlbumExtra()); 
        if (param2PushBodyExtra.hasShareExtra())
          mergeShareExtra(param2PushBodyExtra.getShareExtra()); 
        if (param2PushBodyExtra.hasVipExtra())
          mergeVipExtra(param2PushBodyExtra.getVipExtra()); 
        if (param2PushBodyExtra.hasGiftExtra())
          mergeGiftExtra(param2PushBodyExtra.getGiftExtra()); 
        if (param2PushBodyExtra.hasSysNoticeExtra())
          mergeSysNoticeExtra(param2PushBodyExtra.getSysNoticeExtra()); 
        if (param2PushBodyExtra.hasVideoCallingExtra())
          mergeVideoCallingExtra(param2PushBodyExtra.getVideoCallingExtra()); 
        if (param2PushBodyExtra.hasVideoEndExtra())
          mergeVideoEndExtra(param2PushBodyExtra.getVideoEndExtra()); 
        if (param2PushBodyExtra.hasFeedShareExtra())
          mergeFeedShareExtra(param2PushBodyExtra.getFeedShareExtra()); 
        if (param2PushBodyExtra.hasSayHiExtra())
          mergeSayHiExtra(param2PushBodyExtra.getSayHiExtra()); 
        if (param2PushBodyExtra.hasVoiceRoomShareExtra())
          mergeVoiceRoomShareExtra(param2PushBodyExtra.getVoiceRoomShareExtra()); 
        if (param2PushBodyExtra.hasLiveShareInternationalExtra())
          mergeLiveShareInternationalExtra(param2PushBodyExtra.getLiveShareInternationalExtra()); 
        if (param2PushBodyExtra.hasDoodleShareExtra())
          mergeDoodleShareExtra(param2PushBodyExtra.getDoodleShareExtra()); 
        if (param2PushBodyExtra.hasGroupNotice())
          mergeGroupNotice(param2PushBodyExtra.getGroupNotice()); 
        mergeUnknownFields(param2PushBodyExtra.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = (PushBodyExtraOuterClass.PushBodyExtra)PushBodyExtraOuterClass.PushBodyExtra.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = (PushBodyExtraOuterClass.PushBodyExtra)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PushBodyExtraOuterClass.PushBodyExtra)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PushBodyExtraOuterClass.PushBodyExtra)
          return mergeFrom((PushBodyExtraOuterClass.PushBodyExtra)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public Builder mergeGiftExtra(MsgBodyExtraOuterClass.GiftExtra param2GiftExtra) {
        MsgBodyExtraOuterClass.GiftExtra giftExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          giftExtra = this.giftExtra_;
          if (giftExtra != null) {
            this.giftExtra_ = MsgBodyExtraOuterClass.GiftExtra.newBuilder(giftExtra).mergeFrom(param2GiftExtra).buildPartial();
          } else {
            this.giftExtra_ = param2GiftExtra;
          } 
          onChanged();
          return this;
        } 
        giftExtra.mergeFrom((AbstractMessage)param2GiftExtra);
        return this;
      }
      
      public Builder mergeGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra param2GroupCardExtra) {
        MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          groupCardExtra = this.groupCardExtra_;
          if (groupCardExtra != null) {
            this.groupCardExtra_ = MsgBodyExtraOuterClass.GroupCardExtra.newBuilder(groupCardExtra).mergeFrom(param2GroupCardExtra).buildPartial();
          } else {
            this.groupCardExtra_ = param2GroupCardExtra;
          } 
          onChanged();
          return this;
        } 
        groupCardExtra.mergeFrom((AbstractMessage)param2GroupCardExtra);
        return this;
      }
      
      public Builder mergeGroupNotice(MsgBodyExtraOuterClass.GroupNotice param2GroupNotice) {
        MsgBodyExtraOuterClass.GroupNotice groupNotice;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 == null) {
          groupNotice = this.groupNotice_;
          if (groupNotice != null) {
            this.groupNotice_ = MsgBodyExtraOuterClass.GroupNotice.newBuilder(groupNotice).mergeFrom(param2GroupNotice).buildPartial();
          } else {
            this.groupNotice_ = param2GroupNotice;
          } 
          onChanged();
          return this;
        } 
        groupNotice.mergeFrom((AbstractMessage)param2GroupNotice);
        return this;
      }
      
      public Builder mergeHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra param2HidenAlbumExtra) {
        MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          hidenAlbumExtra = this.hidenAlbumExtra_;
          if (hidenAlbumExtra != null) {
            this.hidenAlbumExtra_ = MsgBodyExtraOuterClass.HidenAlbumExtra.newBuilder(hidenAlbumExtra).mergeFrom(param2HidenAlbumExtra).buildPartial();
          } else {
            this.hidenAlbumExtra_ = param2HidenAlbumExtra;
          } 
          onChanged();
          return this;
        } 
        hidenAlbumExtra.mergeFrom((AbstractMessage)param2HidenAlbumExtra);
        return this;
      }
      
      public Builder mergeImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra param2ImageTextExtra) {
        MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          imageTextExtra = this.imagetextExtra_;
          if (imageTextExtra != null) {
            this.imagetextExtra_ = MsgBodyExtraOuterClass.ImageTextExtra.newBuilder(imageTextExtra).mergeFrom(param2ImageTextExtra).buildPartial();
          } else {
            this.imagetextExtra_ = param2ImageTextExtra;
          } 
          onChanged();
          return this;
        } 
        imageTextExtra.mergeFrom((AbstractMessage)param2ImageTextExtra);
        return this;
      }
      
      public Builder mergeImgExtra(MsgBodyExtraOuterClass.ImgExtra param2ImgExtra) {
        MsgBodyExtraOuterClass.ImgExtra imgExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          imgExtra = this.imgExtra_;
          if (imgExtra != null) {
            this.imgExtra_ = MsgBodyExtraOuterClass.ImgExtra.newBuilder(imgExtra).mergeFrom(param2ImgExtra).buildPartial();
          } else {
            this.imgExtra_ = param2ImgExtra;
          } 
          onChanged();
          return this;
        } 
        imgExtra.mergeFrom((AbstractMessage)param2ImgExtra);
        return this;
      }
      
      public Builder mergeLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra param2LiveShareExtra) {
        MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          liveShareExtra = this.liveShareExtra_;
          if (liveShareExtra != null) {
            this.liveShareExtra_ = MsgBodyExtraOuterClass.LiveShareExtra.newBuilder(liveShareExtra).mergeFrom(param2LiveShareExtra).buildPartial();
          } else {
            this.liveShareExtra_ = param2LiveShareExtra;
          } 
          onChanged();
          return this;
        } 
        liveShareExtra.mergeFrom((AbstractMessage)param2LiveShareExtra);
        return this;
      }
      
      public Builder mergeLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra param2LiveShareInternationalExtra) {
        MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          liveShareInternationalExtra = this.liveShareInternationalExtra_;
          if (liveShareInternationalExtra != null) {
            this.liveShareInternationalExtra_ = MsgBodyExtraOuterClass.LiveShareInternationalExtra.newBuilder(liveShareInternationalExtra).mergeFrom(param2LiveShareInternationalExtra).buildPartial();
          } else {
            this.liveShareInternationalExtra_ = param2LiveShareInternationalExtra;
          } 
          onChanged();
          return this;
        } 
        liveShareInternationalExtra.mergeFrom((AbstractMessage)param2LiveShareInternationalExtra);
        return this;
      }
      
      public Builder mergeLocationExtra(MsgBodyExtraOuterClass.LocationExtra param2LocationExtra) {
        MsgBodyExtraOuterClass.LocationExtra locationExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          locationExtra = this.locationExtra_;
          if (locationExtra != null) {
            this.locationExtra_ = MsgBodyExtraOuterClass.LocationExtra.newBuilder(locationExtra).mergeFrom(param2LocationExtra).buildPartial();
          } else {
            this.locationExtra_ = param2LocationExtra;
          } 
          onChanged();
          return this;
        } 
        locationExtra.mergeFrom((AbstractMessage)param2LocationExtra);
        return this;
      }
      
      public Builder mergeMsgSource(MsgBodyExtraOuterClass.MsgSource param2MsgSource) {
        MsgBodyExtraOuterClass.MsgSource msgSource;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
        if (singleFieldBuilderV3 == null) {
          msgSource = this.msgSource_;
          if (msgSource != null) {
            this.msgSource_ = MsgBodyExtraOuterClass.MsgSource.newBuilder(msgSource).mergeFrom(param2MsgSource).buildPartial();
          } else {
            this.msgSource_ = param2MsgSource;
          } 
          onChanged();
          return this;
        } 
        msgSource.mergeFrom((AbstractMessage)param2MsgSource);
        return this;
      }
      
      public Builder mergeSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra param2SayHiExtra) {
        MsgBodyExtraOuterClass.SayHiExtra sayHiExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          sayHiExtra = this.sayHiExtra_;
          if (sayHiExtra != null) {
            this.sayHiExtra_ = MsgBodyExtraOuterClass.SayHiExtra.newBuilder(sayHiExtra).mergeFrom(param2SayHiExtra).buildPartial();
          } else {
            this.sayHiExtra_ = param2SayHiExtra;
          } 
          onChanged();
          return this;
        } 
        sayHiExtra.mergeFrom((AbstractMessage)param2SayHiExtra);
        return this;
      }
      
      public Builder mergeSecureNotify(MsgBodyExtraOuterClass.SecureNotify param2SecureNotify) {
        MsgBodyExtraOuterClass.SecureNotify secureNotify;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV3 == null) {
          secureNotify = this.secureNotify_;
          if (secureNotify != null) {
            this.secureNotify_ = MsgBodyExtraOuterClass.SecureNotify.newBuilder(secureNotify).mergeFrom(param2SecureNotify).buildPartial();
          } else {
            this.secureNotify_ = param2SecureNotify;
          } 
          onChanged();
          return this;
        } 
        secureNotify.mergeFrom((AbstractMessage)param2SecureNotify);
        return this;
      }
      
      public Builder mergeShareExtra(MsgBodyExtraOuterClass.ShareExtra param2ShareExtra) {
        MsgBodyExtraOuterClass.ShareExtra shareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          shareExtra = this.shareExtra_;
          if (shareExtra != null) {
            this.shareExtra_ = MsgBodyExtraOuterClass.ShareExtra.newBuilder(shareExtra).mergeFrom(param2ShareExtra).buildPartial();
          } else {
            this.shareExtra_ = param2ShareExtra;
          } 
          onChanged();
          return this;
        } 
        shareExtra.mergeFrom((AbstractMessage)param2ShareExtra);
        return this;
      }
      
      public Builder mergeSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra param2SysNoticeExtra) {
        MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          sysNoticeExtra = this.sysNoticeExtra_;
          if (sysNoticeExtra != null) {
            this.sysNoticeExtra_ = MsgBodyExtraOuterClass.SysNoticeExtra.newBuilder(sysNoticeExtra).mergeFrom(param2SysNoticeExtra).buildPartial();
          } else {
            this.sysNoticeExtra_ = param2SysNoticeExtra;
          } 
          onChanged();
          return this;
        } 
        sysNoticeExtra.mergeFrom((AbstractMessage)param2SysNoticeExtra);
        return this;
      }
      
      public Builder mergeTextExtra(MsgBodyExtraOuterClass.TextExtra param2TextExtra) {
        MsgBodyExtraOuterClass.TextExtra textExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          textExtra = this.textExtra_;
          if (textExtra != null) {
            this.textExtra_ = MsgBodyExtraOuterClass.TextExtra.newBuilder(textExtra).mergeFrom(param2TextExtra).buildPartial();
          } else {
            this.textExtra_ = param2TextExtra;
          } 
          onChanged();
          return this;
        } 
        textExtra.mergeFrom((AbstractMessage)param2TextExtra);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder mergeVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra param2VideoChatCallingExtra) {
        MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          videoChatCallingExtra = this.videoCallingExtra_;
          if (videoChatCallingExtra != null) {
            this.videoCallingExtra_ = MsgBodyExtraOuterClass.VideoChatCallingExtra.newBuilder(videoChatCallingExtra).mergeFrom(param2VideoChatCallingExtra).buildPartial();
          } else {
            this.videoCallingExtra_ = param2VideoChatCallingExtra;
          } 
          onChanged();
          return this;
        } 
        videoChatCallingExtra.mergeFrom((AbstractMessage)param2VideoChatCallingExtra);
        return this;
      }
      
      public Builder mergeVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra param2VideoChatEndExtra) {
        MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          videoChatEndExtra = this.videoEndExtra_;
          if (videoChatEndExtra != null) {
            this.videoEndExtra_ = MsgBodyExtraOuterClass.VideoChatEndExtra.newBuilder(videoChatEndExtra).mergeFrom(param2VideoChatEndExtra).buildPartial();
          } else {
            this.videoEndExtra_ = param2VideoChatEndExtra;
          } 
          onChanged();
          return this;
        } 
        videoChatEndExtra.mergeFrom((AbstractMessage)param2VideoChatEndExtra);
        return this;
      }
      
      public Builder mergeVideoExtra(MsgBodyExtraOuterClass.VideoExtra param2VideoExtra) {
        MsgBodyExtraOuterClass.VideoExtra videoExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          videoExtra = this.videoExtra_;
          if (videoExtra != null) {
            this.videoExtra_ = MsgBodyExtraOuterClass.VideoExtra.newBuilder(videoExtra).mergeFrom(param2VideoExtra).buildPartial();
          } else {
            this.videoExtra_ = param2VideoExtra;
          } 
          onChanged();
          return this;
        } 
        videoExtra.mergeFrom((AbstractMessage)param2VideoExtra);
        return this;
      }
      
      public Builder mergeVipExtra(MsgBodyExtraOuterClass.VipExtra param2VipExtra) {
        MsgBodyExtraOuterClass.VipExtra vipExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          vipExtra = this.vipExtra_;
          if (vipExtra != null) {
            this.vipExtra_ = MsgBodyExtraOuterClass.VipExtra.newBuilder(vipExtra).mergeFrom(param2VipExtra).buildPartial();
          } else {
            this.vipExtra_ = param2VipExtra;
          } 
          onChanged();
          return this;
        } 
        vipExtra.mergeFrom((AbstractMessage)param2VipExtra);
        return this;
      }
      
      public Builder mergeVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra param2VoiceRoomShareExtra) {
        MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra;
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          voiceRoomShareExtra = this.voiceRoomShareExtra_;
          if (voiceRoomShareExtra != null) {
            this.voiceRoomShareExtra_ = MsgBodyExtraOuterClass.VoiceRoomShareExtra.newBuilder(voiceRoomShareExtra).mergeFrom(param2VoiceRoomShareExtra).buildPartial();
          } else {
            this.voiceRoomShareExtra_ = param2VoiceRoomShareExtra;
          } 
          onChanged();
          return this;
        } 
        voiceRoomShareExtra.mergeFrom((AbstractMessage)param2VoiceRoomShareExtra);
        return this;
      }
      
      public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.doodleShareExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra param2DoodleShareExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2DoodleShareExtra != null) {
            this.doodleShareExtra_ = param2DoodleShareExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2DoodleShareExtra);
        return this;
      }
      
      public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.feedShareExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra param2FeedShareExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2FeedShareExtra != null) {
            this.feedShareExtra_ = param2FeedShareExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2FeedShareExtra);
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.giftExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra param2GiftExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2GiftExtra != null) {
            this.giftExtra_ = param2GiftExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2GiftExtra);
        return this;
      }
      
      public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.groupCardExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra param2GroupCardExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2GroupCardExtra != null) {
            this.groupCardExtra_ = param2GroupCardExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2GroupCardExtra);
        return this;
      }
      
      public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.groupNotice_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice param2GroupNotice) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2GroupNotice != null) {
            this.groupNotice_ = param2GroupNotice;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2GroupNotice);
        return this;
      }
      
      public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.hidenAlbumExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra param2HidenAlbumExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2HidenAlbumExtra != null) {
            this.hidenAlbumExtra_ = param2HidenAlbumExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2HidenAlbumExtra);
        return this;
      }
      
      public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.imagetextExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra param2ImageTextExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2ImageTextExtra != null) {
            this.imagetextExtra_ = param2ImageTextExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2ImageTextExtra);
        return this;
      }
      
      public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.imgExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra param2ImgExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2ImgExtra != null) {
            this.imgExtra_ = param2ImgExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2ImgExtra);
        return this;
      }
      
      public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.liveShareExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra param2LiveShareExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2LiveShareExtra != null) {
            this.liveShareExtra_ = param2LiveShareExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2LiveShareExtra);
        return this;
      }
      
      public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.liveShareInternationalExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra param2LiveShareInternationalExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2LiveShareInternationalExtra != null) {
            this.liveShareInternationalExtra_ = param2LiveShareInternationalExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2LiveShareInternationalExtra);
        return this;
      }
      
      public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.locationExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra param2LocationExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2LocationExtra != null) {
            this.locationExtra_ = param2LocationExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2LocationExtra);
        return this;
      }
      
      public Builder setMsgReceiveFrom(long param2Long) {
        this.msgReceiveFrom_ = param2Long;
        onChanged();
        return this;
      }
      
      public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.msgSource_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource param2MsgSource) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2MsgSource != null) {
            this.msgSource_ = param2MsgSource;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2MsgSource);
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.sayHiExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra param2SayHiExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2SayHiExtra != null) {
            this.sayHiExtra_ = param2SayHiExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2SayHiExtra);
        return this;
      }
      
      public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.secureNotify_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify param2SecureNotify) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2SecureNotify != null) {
            this.secureNotify_ = param2SecureNotify;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2SecureNotify);
        return this;
      }
      
      public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.shareExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra param2ShareExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2ShareExtra != null) {
            this.shareExtra_ = param2ShareExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2ShareExtra);
        return this;
      }
      
      public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.sysNoticeExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra param2SysNoticeExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2SysNoticeExtra != null) {
            this.sysNoticeExtra_ = param2SysNoticeExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2SysNoticeExtra);
        return this;
      }
      
      public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.textExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra param2TextExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2TextExtra != null) {
            this.textExtra_ = param2TextExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2TextExtra);
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.videoCallingExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra param2VideoChatCallingExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2VideoChatCallingExtra != null) {
            this.videoCallingExtra_ = param2VideoChatCallingExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2VideoChatCallingExtra);
        return this;
      }
      
      public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.videoEndExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra param2VideoChatEndExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2VideoChatEndExtra != null) {
            this.videoEndExtra_ = param2VideoChatEndExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2VideoChatEndExtra);
        return this;
      }
      
      public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.videoExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra param2VideoExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2VideoExtra != null) {
            this.videoExtra_ = param2VideoExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2VideoExtra);
        return this;
      }
      
      public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.vipExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra param2VipExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2VipExtra != null) {
            this.vipExtra_ = param2VipExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2VipExtra);
        return this;
      }
      
      public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder param2Builder) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          this.voiceRoomShareExtra_ = param2Builder.build();
          onChanged();
          return this;
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2Builder.build());
        return this;
      }
      
      public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra param2VoiceRoomShareExtra) {
        SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
        if (singleFieldBuilderV3 == null) {
          if (param2VoiceRoomShareExtra != null) {
            this.voiceRoomShareExtra_ = param2VoiceRoomShareExtra;
            onChanged();
            return this;
          } 
          throw new NullPointerException();
        } 
        singleFieldBuilderV3.setMessage((AbstractMessage)param2VoiceRoomShareExtra);
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<PushBodyExtra> {
    public PushBodyExtraOuterClass.PushBodyExtra parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PushBodyExtraOuterClass.PushBodyExtra(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PushBodyExtra.Builder> implements PushBodyExtraOrBuilder {
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> doodleShareExtraBuilder_;
    
    private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> feedShareExtraBuilder_;
    
    private MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> giftExtraBuilder_;
    
    private MsgBodyExtraOuterClass.GiftExtra giftExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> groupCardExtraBuilder_;
    
    private MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> groupNoticeBuilder_;
    
    private MsgBodyExtraOuterClass.GroupNotice groupNotice_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> hidenAlbumExtraBuilder_;
    
    private MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> imagetextExtraBuilder_;
    
    private MsgBodyExtraOuterClass.ImageTextExtra imagetextExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> imgExtraBuilder_;
    
    private MsgBodyExtraOuterClass.ImgExtra imgExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> liveShareExtraBuilder_;
    
    private MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> liveShareInternationalExtraBuilder_;
    
    private MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> locationExtraBuilder_;
    
    private MsgBodyExtraOuterClass.LocationExtra locationExtra_;
    
    private long msgReceiveFrom_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> msgSourceBuilder_;
    
    private MsgBodyExtraOuterClass.MsgSource msgSource_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> sayHiExtraBuilder_;
    
    private MsgBodyExtraOuterClass.SayHiExtra sayHiExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> secureNotifyBuilder_;
    
    private MsgBodyExtraOuterClass.SecureNotify secureNotify_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> shareExtraBuilder_;
    
    private MsgBodyExtraOuterClass.ShareExtra shareExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> sysNoticeExtraBuilder_;
    
    private MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> textExtraBuilder_;
    
    private MsgBodyExtraOuterClass.TextExtra textExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> videoCallingExtraBuilder_;
    
    private MsgBodyExtraOuterClass.VideoChatCallingExtra videoCallingExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> videoEndExtraBuilder_;
    
    private MsgBodyExtraOuterClass.VideoChatEndExtra videoEndExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> videoExtraBuilder_;
    
    private MsgBodyExtraOuterClass.VideoExtra videoExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> vipExtraBuilder_;
    
    private MsgBodyExtraOuterClass.VipExtra vipExtra_;
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> voiceRoomShareExtraBuilder_;
    
    private MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> getDoodleShareExtraFieldBuilder() {
      if (this.doodleShareExtraBuilder_ == null) {
        this.doodleShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getDoodleShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.doodleShareExtra_ = null;
      } 
      return this.doodleShareExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> getFeedShareExtraFieldBuilder() {
      if (this.feedShareExtraBuilder_ == null) {
        this.feedShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getFeedShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.feedShareExtra_ = null;
      } 
      return this.feedShareExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> getGiftExtraFieldBuilder() {
      if (this.giftExtraBuilder_ == null) {
        this.giftExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGiftExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.giftExtra_ = null;
      } 
      return this.giftExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> getGroupCardExtraFieldBuilder() {
      if (this.groupCardExtraBuilder_ == null) {
        this.groupCardExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGroupCardExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.groupCardExtra_ = null;
      } 
      return this.groupCardExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> getGroupNoticeFieldBuilder() {
      if (this.groupNoticeBuilder_ == null) {
        this.groupNoticeBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getGroupNotice(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.groupNotice_ = null;
      } 
      return this.groupNoticeBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> getHidenAlbumExtraFieldBuilder() {
      if (this.hidenAlbumExtraBuilder_ == null) {
        this.hidenAlbumExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getHidenAlbumExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.hidenAlbumExtra_ = null;
      } 
      return this.hidenAlbumExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> getImagetextExtraFieldBuilder() {
      if (this.imagetextExtraBuilder_ == null) {
        this.imagetextExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getImagetextExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.imagetextExtra_ = null;
      } 
      return this.imagetextExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> getImgExtraFieldBuilder() {
      if (this.imgExtraBuilder_ == null) {
        this.imgExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getImgExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.imgExtra_ = null;
      } 
      return this.imgExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> getLiveShareExtraFieldBuilder() {
      if (this.liveShareExtraBuilder_ == null) {
        this.liveShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLiveShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.liveShareExtra_ = null;
      } 
      return this.liveShareExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> getLiveShareInternationalExtraFieldBuilder() {
      if (this.liveShareInternationalExtraBuilder_ == null) {
        this.liveShareInternationalExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLiveShareInternationalExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.liveShareInternationalExtra_ = null;
      } 
      return this.liveShareInternationalExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> getLocationExtraFieldBuilder() {
      if (this.locationExtraBuilder_ == null) {
        this.locationExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getLocationExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.locationExtra_ = null;
      } 
      return this.locationExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> getMsgSourceFieldBuilder() {
      if (this.msgSourceBuilder_ == null) {
        this.msgSourceBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getMsgSource(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.msgSource_ = null;
      } 
      return this.msgSourceBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> getSayHiExtraFieldBuilder() {
      if (this.sayHiExtraBuilder_ == null) {
        this.sayHiExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSayHiExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sayHiExtra_ = null;
      } 
      return this.sayHiExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> getSecureNotifyFieldBuilder() {
      if (this.secureNotifyBuilder_ == null) {
        this.secureNotifyBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSecureNotify(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.secureNotify_ = null;
      } 
      return this.secureNotifyBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> getShareExtraFieldBuilder() {
      if (this.shareExtraBuilder_ == null) {
        this.shareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.shareExtra_ = null;
      } 
      return this.shareExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> getSysNoticeExtraFieldBuilder() {
      if (this.sysNoticeExtraBuilder_ == null) {
        this.sysNoticeExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getSysNoticeExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.sysNoticeExtra_ = null;
      } 
      return this.sysNoticeExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> getTextExtraFieldBuilder() {
      if (this.textExtraBuilder_ == null) {
        this.textExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getTextExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.textExtra_ = null;
      } 
      return this.textExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> getVideoCallingExtraFieldBuilder() {
      if (this.videoCallingExtraBuilder_ == null) {
        this.videoCallingExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoCallingExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.videoCallingExtra_ = null;
      } 
      return this.videoCallingExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> getVideoEndExtraFieldBuilder() {
      if (this.videoEndExtraBuilder_ == null) {
        this.videoEndExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoEndExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.videoEndExtra_ = null;
      } 
      return this.videoEndExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> getVideoExtraFieldBuilder() {
      if (this.videoExtraBuilder_ == null) {
        this.videoExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVideoExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.videoExtra_ = null;
      } 
      return this.videoExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> getVipExtraFieldBuilder() {
      if (this.vipExtraBuilder_ == null) {
        this.vipExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVipExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.vipExtra_ = null;
      } 
      return this.vipExtraBuilder_;
    }
    
    private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> getVoiceRoomShareExtraFieldBuilder() {
      if (this.voiceRoomShareExtraBuilder_ == null) {
        this.voiceRoomShareExtraBuilder_ = new SingleFieldBuilderV3((AbstractMessage)getVoiceRoomShareExtra(), (AbstractMessage.BuilderParent)getParentForChildren(), isClean());
        this.voiceRoomShareExtra_ = null;
      } 
      return this.voiceRoomShareExtraBuilder_;
    }
    
    private void maybeForceBuilderInitialization() {
      PushBodyExtraOuterClass.PushBodyExtra.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra build() {
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = buildPartial();
      if (pushBodyExtra.isInitialized())
        return pushBodyExtra; 
      throw newUninitializedMessageException(pushBodyExtra);
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra buildPartial() {
      PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = new PushBodyExtraOuterClass.PushBodyExtra(this);
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV321 = this.msgSourceBuilder_;
      if (singleFieldBuilderV321 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$602(pushBodyExtra, this.msgSource_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$602(pushBodyExtra, (MsgBodyExtraOuterClass.MsgSource)singleFieldBuilderV321.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV320 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV320 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$702(pushBodyExtra, this.secureNotify_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$702(pushBodyExtra, (MsgBodyExtraOuterClass.SecureNotify)singleFieldBuilderV320.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV319 = this.textExtraBuilder_;
      if (singleFieldBuilderV319 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$802(pushBodyExtra, this.textExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$802(pushBodyExtra, (MsgBodyExtraOuterClass.TextExtra)singleFieldBuilderV319.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV318 = this.imgExtraBuilder_;
      if (singleFieldBuilderV318 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$902(pushBodyExtra, this.imgExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$902(pushBodyExtra, (MsgBodyExtraOuterClass.ImgExtra)singleFieldBuilderV318.build());
      } 
      PushBodyExtraOuterClass.PushBodyExtra.access$1002(pushBodyExtra, this.msgReceiveFrom_);
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV317 = this.locationExtraBuilder_;
      if (singleFieldBuilderV317 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1102(pushBodyExtra, this.locationExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1102(pushBodyExtra, (MsgBodyExtraOuterClass.LocationExtra)singleFieldBuilderV317.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV316 = this.videoExtraBuilder_;
      if (singleFieldBuilderV316 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1202(pushBodyExtra, this.videoExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1202(pushBodyExtra, (MsgBodyExtraOuterClass.VideoExtra)singleFieldBuilderV316.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV315 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV315 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1302(pushBodyExtra, this.groupCardExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1302(pushBodyExtra, (MsgBodyExtraOuterClass.GroupCardExtra)singleFieldBuilderV315.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV314 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV314 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1402(pushBodyExtra, this.liveShareExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1402(pushBodyExtra, (MsgBodyExtraOuterClass.LiveShareExtra)singleFieldBuilderV314.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV313 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV313 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1502(pushBodyExtra, this.imagetextExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1502(pushBodyExtra, (MsgBodyExtraOuterClass.ImageTextExtra)singleFieldBuilderV313.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV312 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV312 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1602(pushBodyExtra, this.hidenAlbumExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1602(pushBodyExtra, (MsgBodyExtraOuterClass.HidenAlbumExtra)singleFieldBuilderV312.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV311 = this.shareExtraBuilder_;
      if (singleFieldBuilderV311 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1702(pushBodyExtra, this.shareExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1702(pushBodyExtra, (MsgBodyExtraOuterClass.ShareExtra)singleFieldBuilderV311.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV310 = this.vipExtraBuilder_;
      if (singleFieldBuilderV310 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1802(pushBodyExtra, this.vipExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1802(pushBodyExtra, (MsgBodyExtraOuterClass.VipExtra)singleFieldBuilderV310.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV39 = this.giftExtraBuilder_;
      if (singleFieldBuilderV39 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$1902(pushBodyExtra, this.giftExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$1902(pushBodyExtra, (MsgBodyExtraOuterClass.GiftExtra)singleFieldBuilderV39.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV38 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV38 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2002(pushBodyExtra, this.sysNoticeExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2002(pushBodyExtra, (MsgBodyExtraOuterClass.SysNoticeExtra)singleFieldBuilderV38.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV37 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV37 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2102(pushBodyExtra, this.videoCallingExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2102(pushBodyExtra, (MsgBodyExtraOuterClass.VideoChatCallingExtra)singleFieldBuilderV37.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV36 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV36 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2202(pushBodyExtra, this.videoEndExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2202(pushBodyExtra, (MsgBodyExtraOuterClass.VideoChatEndExtra)singleFieldBuilderV36.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV35 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV35 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2302(pushBodyExtra, this.feedShareExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2302(pushBodyExtra, (MsgBodyExtraOuterClass.FeedShareExtra)singleFieldBuilderV35.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV34 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV34 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2402(pushBodyExtra, this.sayHiExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2402(pushBodyExtra, (MsgBodyExtraOuterClass.SayHiExtra)singleFieldBuilderV34.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV33 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV33 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2502(pushBodyExtra, this.voiceRoomShareExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2502(pushBodyExtra, (MsgBodyExtraOuterClass.VoiceRoomShareExtra)singleFieldBuilderV33.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV32 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV32 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2602(pushBodyExtra, this.liveShareInternationalExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2602(pushBodyExtra, (MsgBodyExtraOuterClass.LiveShareInternationalExtra)singleFieldBuilderV32.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV31 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV31 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2702(pushBodyExtra, this.doodleShareExtra_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2702(pushBodyExtra, (MsgBodyExtraOuterClass.DoodleShareExtra)singleFieldBuilderV31.build());
      } 
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 == null) {
        PushBodyExtraOuterClass.PushBodyExtra.access$2802(pushBodyExtra, this.groupNotice_);
      } else {
        PushBodyExtraOuterClass.PushBodyExtra.access$2802(pushBodyExtra, (MsgBodyExtraOuterClass.GroupNotice)singleFieldBuilderV3.build());
      } 
      onBuilt();
      return pushBodyExtra;
    }
    
    public Builder clear() {
      super.clear();
      if (this.msgSourceBuilder_ == null) {
        this.msgSource_ = null;
      } else {
        this.msgSource_ = null;
        this.msgSourceBuilder_ = null;
      } 
      if (this.secureNotifyBuilder_ == null) {
        this.secureNotify_ = null;
      } else {
        this.secureNotify_ = null;
        this.secureNotifyBuilder_ = null;
      } 
      if (this.textExtraBuilder_ == null) {
        this.textExtra_ = null;
      } else {
        this.textExtra_ = null;
        this.textExtraBuilder_ = null;
      } 
      if (this.imgExtraBuilder_ == null) {
        this.imgExtra_ = null;
      } else {
        this.imgExtra_ = null;
        this.imgExtraBuilder_ = null;
      } 
      this.msgReceiveFrom_ = 0L;
      if (this.locationExtraBuilder_ == null) {
        this.locationExtra_ = null;
      } else {
        this.locationExtra_ = null;
        this.locationExtraBuilder_ = null;
      } 
      if (this.videoExtraBuilder_ == null) {
        this.videoExtra_ = null;
      } else {
        this.videoExtra_ = null;
        this.videoExtraBuilder_ = null;
      } 
      if (this.groupCardExtraBuilder_ == null) {
        this.groupCardExtra_ = null;
      } else {
        this.groupCardExtra_ = null;
        this.groupCardExtraBuilder_ = null;
      } 
      if (this.liveShareExtraBuilder_ == null) {
        this.liveShareExtra_ = null;
      } else {
        this.liveShareExtra_ = null;
        this.liveShareExtraBuilder_ = null;
      } 
      if (this.imagetextExtraBuilder_ == null) {
        this.imagetextExtra_ = null;
      } else {
        this.imagetextExtra_ = null;
        this.imagetextExtraBuilder_ = null;
      } 
      if (this.hidenAlbumExtraBuilder_ == null) {
        this.hidenAlbumExtra_ = null;
      } else {
        this.hidenAlbumExtra_ = null;
        this.hidenAlbumExtraBuilder_ = null;
      } 
      if (this.shareExtraBuilder_ == null) {
        this.shareExtra_ = null;
      } else {
        this.shareExtra_ = null;
        this.shareExtraBuilder_ = null;
      } 
      if (this.vipExtraBuilder_ == null) {
        this.vipExtra_ = null;
      } else {
        this.vipExtra_ = null;
        this.vipExtraBuilder_ = null;
      } 
      if (this.giftExtraBuilder_ == null) {
        this.giftExtra_ = null;
      } else {
        this.giftExtra_ = null;
        this.giftExtraBuilder_ = null;
      } 
      if (this.sysNoticeExtraBuilder_ == null) {
        this.sysNoticeExtra_ = null;
      } else {
        this.sysNoticeExtra_ = null;
        this.sysNoticeExtraBuilder_ = null;
      } 
      if (this.videoCallingExtraBuilder_ == null) {
        this.videoCallingExtra_ = null;
      } else {
        this.videoCallingExtra_ = null;
        this.videoCallingExtraBuilder_ = null;
      } 
      if (this.videoEndExtraBuilder_ == null) {
        this.videoEndExtra_ = null;
      } else {
        this.videoEndExtra_ = null;
        this.videoEndExtraBuilder_ = null;
      } 
      if (this.feedShareExtraBuilder_ == null) {
        this.feedShareExtra_ = null;
      } else {
        this.feedShareExtra_ = null;
        this.feedShareExtraBuilder_ = null;
      } 
      if (this.sayHiExtraBuilder_ == null) {
        this.sayHiExtra_ = null;
      } else {
        this.sayHiExtra_ = null;
        this.sayHiExtraBuilder_ = null;
      } 
      if (this.voiceRoomShareExtraBuilder_ == null) {
        this.voiceRoomShareExtra_ = null;
      } else {
        this.voiceRoomShareExtra_ = null;
        this.voiceRoomShareExtraBuilder_ = null;
      } 
      if (this.liveShareInternationalExtraBuilder_ == null) {
        this.liveShareInternationalExtra_ = null;
      } else {
        this.liveShareInternationalExtra_ = null;
        this.liveShareInternationalExtraBuilder_ = null;
      } 
      if (this.doodleShareExtraBuilder_ == null) {
        this.doodleShareExtra_ = null;
      } else {
        this.doodleShareExtra_ = null;
        this.doodleShareExtraBuilder_ = null;
      } 
      if (this.groupNoticeBuilder_ == null) {
        this.groupNotice_ = null;
        return this;
      } 
      this.groupNotice_ = null;
      this.groupNoticeBuilder_ = null;
      return this;
    }
    
    public Builder clearDoodleShareExtra() {
      if (this.doodleShareExtraBuilder_ == null) {
        this.doodleShareExtra_ = null;
        onChanged();
        return this;
      } 
      this.doodleShareExtra_ = null;
      this.doodleShareExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearFeedShareExtra() {
      if (this.feedShareExtraBuilder_ == null) {
        this.feedShareExtra_ = null;
        onChanged();
        return this;
      } 
      this.feedShareExtra_ = null;
      this.feedShareExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearGiftExtra() {
      if (this.giftExtraBuilder_ == null) {
        this.giftExtra_ = null;
        onChanged();
        return this;
      } 
      this.giftExtra_ = null;
      this.giftExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearGroupCardExtra() {
      if (this.groupCardExtraBuilder_ == null) {
        this.groupCardExtra_ = null;
        onChanged();
        return this;
      } 
      this.groupCardExtra_ = null;
      this.groupCardExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearGroupNotice() {
      if (this.groupNoticeBuilder_ == null) {
        this.groupNotice_ = null;
        onChanged();
        return this;
      } 
      this.groupNotice_ = null;
      this.groupNoticeBuilder_ = null;
      return this;
    }
    
    public Builder clearHidenAlbumExtra() {
      if (this.hidenAlbumExtraBuilder_ == null) {
        this.hidenAlbumExtra_ = null;
        onChanged();
        return this;
      } 
      this.hidenAlbumExtra_ = null;
      this.hidenAlbumExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearImagetextExtra() {
      if (this.imagetextExtraBuilder_ == null) {
        this.imagetextExtra_ = null;
        onChanged();
        return this;
      } 
      this.imagetextExtra_ = null;
      this.imagetextExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearImgExtra() {
      if (this.imgExtraBuilder_ == null) {
        this.imgExtra_ = null;
        onChanged();
        return this;
      } 
      this.imgExtra_ = null;
      this.imgExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearLiveShareExtra() {
      if (this.liveShareExtraBuilder_ == null) {
        this.liveShareExtra_ = null;
        onChanged();
        return this;
      } 
      this.liveShareExtra_ = null;
      this.liveShareExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearLiveShareInternationalExtra() {
      if (this.liveShareInternationalExtraBuilder_ == null) {
        this.liveShareInternationalExtra_ = null;
        onChanged();
        return this;
      } 
      this.liveShareInternationalExtra_ = null;
      this.liveShareInternationalExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearLocationExtra() {
      if (this.locationExtraBuilder_ == null) {
        this.locationExtra_ = null;
        onChanged();
        return this;
      } 
      this.locationExtra_ = null;
      this.locationExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearMsgReceiveFrom() {
      this.msgReceiveFrom_ = 0L;
      onChanged();
      return this;
    }
    
    public Builder clearMsgSource() {
      if (this.msgSourceBuilder_ == null) {
        this.msgSource_ = null;
        onChanged();
        return this;
      } 
      this.msgSource_ = null;
      this.msgSourceBuilder_ = null;
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearSayHiExtra() {
      if (this.sayHiExtraBuilder_ == null) {
        this.sayHiExtra_ = null;
        onChanged();
        return this;
      } 
      this.sayHiExtra_ = null;
      this.sayHiExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearSecureNotify() {
      if (this.secureNotifyBuilder_ == null) {
        this.secureNotify_ = null;
        onChanged();
        return this;
      } 
      this.secureNotify_ = null;
      this.secureNotifyBuilder_ = null;
      return this;
    }
    
    public Builder clearShareExtra() {
      if (this.shareExtraBuilder_ == null) {
        this.shareExtra_ = null;
        onChanged();
        return this;
      } 
      this.shareExtra_ = null;
      this.shareExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearSysNoticeExtra() {
      if (this.sysNoticeExtraBuilder_ == null) {
        this.sysNoticeExtra_ = null;
        onChanged();
        return this;
      } 
      this.sysNoticeExtra_ = null;
      this.sysNoticeExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearTextExtra() {
      if (this.textExtraBuilder_ == null) {
        this.textExtra_ = null;
        onChanged();
        return this;
      } 
      this.textExtra_ = null;
      this.textExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearVideoCallingExtra() {
      if (this.videoCallingExtraBuilder_ == null) {
        this.videoCallingExtra_ = null;
        onChanged();
        return this;
      } 
      this.videoCallingExtra_ = null;
      this.videoCallingExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearVideoEndExtra() {
      if (this.videoEndExtraBuilder_ == null) {
        this.videoEndExtra_ = null;
        onChanged();
        return this;
      } 
      this.videoEndExtra_ = null;
      this.videoEndExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearVideoExtra() {
      if (this.videoExtraBuilder_ == null) {
        this.videoExtra_ = null;
        onChanged();
        return this;
      } 
      this.videoExtra_ = null;
      this.videoExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearVipExtra() {
      if (this.vipExtraBuilder_ == null) {
        this.vipExtra_ = null;
        onChanged();
        return this;
      } 
      this.vipExtra_ = null;
      this.vipExtraBuilder_ = null;
      return this;
    }
    
    public Builder clearVoiceRoomShareExtra() {
      if (this.voiceRoomShareExtraBuilder_ == null) {
        this.voiceRoomShareExtra_ = null;
        onChanged();
        return this;
      } 
      this.voiceRoomShareExtra_ = null;
      this.voiceRoomShareExtraBuilder_ = null;
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public PushBodyExtraOuterClass.PushBodyExtra getDefaultInstanceForType() {
      return PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
    }
    
    public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra1 = this.doodleShareExtra_;
        doodleShareExtra = doodleShareExtra1;
        if (doodleShareExtra1 == null)
          doodleShareExtra = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance(); 
        return doodleShareExtra;
      } 
      return (MsgBodyExtraOuterClass.DoodleShareExtra)doodleShareExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.DoodleShareExtra.Builder getDoodleShareExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.DoodleShareExtra.Builder)getDoodleShareExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = this.doodleShareExtra_;
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra1 = doodleShareExtra2;
      if (doodleShareExtra2 == null)
        doodleShareExtra1 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance(); 
      return doodleShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra1 = this.feedShareExtra_;
        feedShareExtra = feedShareExtra1;
        if (feedShareExtra1 == null)
          feedShareExtra = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance(); 
        return feedShareExtra;
      } 
      return (MsgBodyExtraOuterClass.FeedShareExtra)feedShareExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.FeedShareExtra.Builder getFeedShareExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.FeedShareExtra.Builder)getFeedShareExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.FeedShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = this.feedShareExtra_;
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra1 = feedShareExtra2;
      if (feedShareExtra2 == null)
        feedShareExtra1 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance(); 
      return feedShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
      MsgBodyExtraOuterClass.GiftExtra giftExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.GiftExtra giftExtra1 = this.giftExtra_;
        giftExtra = giftExtra1;
        if (giftExtra1 == null)
          giftExtra = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance(); 
        return giftExtra;
      } 
      return (MsgBodyExtraOuterClass.GiftExtra)giftExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.GiftExtra.Builder getGiftExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.GiftExtra.Builder)getGiftExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.GiftExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.GiftExtra giftExtra2 = this.giftExtra_;
      MsgBodyExtraOuterClass.GiftExtra giftExtra1 = giftExtra2;
      if (giftExtra2 == null)
        giftExtra1 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance(); 
      return giftExtra1;
    }
    
    public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra1 = this.groupCardExtra_;
        groupCardExtra = groupCardExtra1;
        if (groupCardExtra1 == null)
          groupCardExtra = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance(); 
        return groupCardExtra;
      } 
      return (MsgBodyExtraOuterClass.GroupCardExtra)groupCardExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.GroupCardExtra.Builder getGroupCardExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.GroupCardExtra.Builder)getGroupCardExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.GroupCardExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = this.groupCardExtra_;
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra1 = groupCardExtra2;
      if (groupCardExtra2 == null)
        groupCardExtra1 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance(); 
      return groupCardExtra1;
    }
    
    public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
      MsgBodyExtraOuterClass.GroupNotice groupNotice;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.GroupNotice groupNotice1 = this.groupNotice_;
        groupNotice = groupNotice1;
        if (groupNotice1 == null)
          groupNotice = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance(); 
        return groupNotice;
      } 
      return (MsgBodyExtraOuterClass.GroupNotice)groupNotice.getMessage();
    }
    
    public MsgBodyExtraOuterClass.GroupNotice.Builder getGroupNoticeBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.GroupNotice.Builder)getGroupNoticeFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.GroupNoticeOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.GroupNotice groupNotice2 = this.groupNotice_;
      MsgBodyExtraOuterClass.GroupNotice groupNotice1 = groupNotice2;
      if (groupNotice2 == null)
        groupNotice1 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance(); 
      return groupNotice1;
    }
    
    public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra1 = this.hidenAlbumExtra_;
        hidenAlbumExtra = hidenAlbumExtra1;
        if (hidenAlbumExtra1 == null)
          hidenAlbumExtra = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance(); 
        return hidenAlbumExtra;
      } 
      return (MsgBodyExtraOuterClass.HidenAlbumExtra)hidenAlbumExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.HidenAlbumExtra.Builder getHidenAlbumExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.HidenAlbumExtra.Builder)getHidenAlbumExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = this.hidenAlbumExtra_;
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra1 = hidenAlbumExtra2;
      if (hidenAlbumExtra2 == null)
        hidenAlbumExtra1 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance(); 
      return hidenAlbumExtra1;
    }
    
    public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra1 = this.imagetextExtra_;
        imageTextExtra = imageTextExtra1;
        if (imageTextExtra1 == null)
          imageTextExtra = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance(); 
        return imageTextExtra;
      } 
      return (MsgBodyExtraOuterClass.ImageTextExtra)imageTextExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.ImageTextExtra.Builder getImagetextExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.ImageTextExtra.Builder)getImagetextExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.ImageTextExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = this.imagetextExtra_;
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra1 = imageTextExtra2;
      if (imageTextExtra2 == null)
        imageTextExtra1 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance(); 
      return imageTextExtra1;
    }
    
    public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
      MsgBodyExtraOuterClass.ImgExtra imgExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.ImgExtra imgExtra1 = this.imgExtra_;
        imgExtra = imgExtra1;
        if (imgExtra1 == null)
          imgExtra = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance(); 
        return imgExtra;
      } 
      return (MsgBodyExtraOuterClass.ImgExtra)imgExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.ImgExtra.Builder getImgExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.ImgExtra.Builder)getImgExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.ImgExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.ImgExtra imgExtra2 = this.imgExtra_;
      MsgBodyExtraOuterClass.ImgExtra imgExtra1 = imgExtra2;
      if (imgExtra2 == null)
        imgExtra1 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance(); 
      return imgExtra1;
    }
    
    public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra1 = this.liveShareExtra_;
        liveShareExtra = liveShareExtra1;
        if (liveShareExtra1 == null)
          liveShareExtra = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance(); 
        return liveShareExtra;
      } 
      return (MsgBodyExtraOuterClass.LiveShareExtra)liveShareExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.LiveShareExtra.Builder getLiveShareExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.LiveShareExtra.Builder)getLiveShareExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.LiveShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = this.liveShareExtra_;
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra1 = liveShareExtra2;
      if (liveShareExtra2 == null)
        liveShareExtra1 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance(); 
      return liveShareExtra1;
    }
    
    public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra1 = this.liveShareInternationalExtra_;
        liveShareInternationalExtra = liveShareInternationalExtra1;
        if (liveShareInternationalExtra1 == null)
          liveShareInternationalExtra = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance(); 
        return liveShareInternationalExtra;
      } 
      return (MsgBodyExtraOuterClass.LiveShareInternationalExtra)liveShareInternationalExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder getLiveShareInternationalExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder)getLiveShareInternationalExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = this.liveShareInternationalExtra_;
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra1 = liveShareInternationalExtra2;
      if (liveShareInternationalExtra2 == null)
        liveShareInternationalExtra1 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance(); 
      return liveShareInternationalExtra1;
    }
    
    public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
      MsgBodyExtraOuterClass.LocationExtra locationExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.LocationExtra locationExtra1 = this.locationExtra_;
        locationExtra = locationExtra1;
        if (locationExtra1 == null)
          locationExtra = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance(); 
        return locationExtra;
      } 
      return (MsgBodyExtraOuterClass.LocationExtra)locationExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.LocationExtra.Builder getLocationExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.LocationExtra.Builder)getLocationExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.LocationExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.LocationExtra locationExtra2 = this.locationExtra_;
      MsgBodyExtraOuterClass.LocationExtra locationExtra1 = locationExtra2;
      if (locationExtra2 == null)
        locationExtra1 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance(); 
      return locationExtra1;
    }
    
    public long getMsgReceiveFrom() {
      return this.msgReceiveFrom_;
    }
    
    public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
      MsgBodyExtraOuterClass.MsgSource msgSource;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.MsgSource msgSource1 = this.msgSource_;
        msgSource = msgSource1;
        if (msgSource1 == null)
          msgSource = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance(); 
        return msgSource;
      } 
      return (MsgBodyExtraOuterClass.MsgSource)msgSource.getMessage();
    }
    
    public MsgBodyExtraOuterClass.MsgSource.Builder getMsgSourceBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.MsgSource.Builder)getMsgSourceFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.MsgSourceOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.MsgSource msgSource2 = this.msgSource_;
      MsgBodyExtraOuterClass.MsgSource msgSource1 = msgSource2;
      if (msgSource2 == null)
        msgSource1 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance(); 
      return msgSource1;
    }
    
    public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.SayHiExtra sayHiExtra1 = this.sayHiExtra_;
        sayHiExtra = sayHiExtra1;
        if (sayHiExtra1 == null)
          sayHiExtra = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance(); 
        return sayHiExtra;
      } 
      return (MsgBodyExtraOuterClass.SayHiExtra)sayHiExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.SayHiExtra.Builder getSayHiExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.SayHiExtra.Builder)getSayHiExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.SayHiExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = this.sayHiExtra_;
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra1 = sayHiExtra2;
      if (sayHiExtra2 == null)
        sayHiExtra1 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance(); 
      return sayHiExtra1;
    }
    
    public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
      MsgBodyExtraOuterClass.SecureNotify secureNotify;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.SecureNotify secureNotify1 = this.secureNotify_;
        secureNotify = secureNotify1;
        if (secureNotify1 == null)
          secureNotify = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance(); 
        return secureNotify;
      } 
      return (MsgBodyExtraOuterClass.SecureNotify)secureNotify.getMessage();
    }
    
    public MsgBodyExtraOuterClass.SecureNotify.Builder getSecureNotifyBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.SecureNotify.Builder)getSecureNotifyFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.SecureNotifyOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.SecureNotify secureNotify2 = this.secureNotify_;
      MsgBodyExtraOuterClass.SecureNotify secureNotify1 = secureNotify2;
      if (secureNotify2 == null)
        secureNotify1 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance(); 
      return secureNotify1;
    }
    
    public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
      MsgBodyExtraOuterClass.ShareExtra shareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.ShareExtra shareExtra1 = this.shareExtra_;
        shareExtra = shareExtra1;
        if (shareExtra1 == null)
          shareExtra = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance(); 
        return shareExtra;
      } 
      return (MsgBodyExtraOuterClass.ShareExtra)shareExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.ShareExtra.Builder getShareExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.ShareExtra.Builder)getShareExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.ShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.ShareExtra shareExtra2 = this.shareExtra_;
      MsgBodyExtraOuterClass.ShareExtra shareExtra1 = shareExtra2;
      if (shareExtra2 == null)
        shareExtra1 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance(); 
      return shareExtra1;
    }
    
    public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra1 = this.sysNoticeExtra_;
        sysNoticeExtra = sysNoticeExtra1;
        if (sysNoticeExtra1 == null)
          sysNoticeExtra = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance(); 
        return sysNoticeExtra;
      } 
      return (MsgBodyExtraOuterClass.SysNoticeExtra)sysNoticeExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.SysNoticeExtra.Builder getSysNoticeExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.SysNoticeExtra.Builder)getSysNoticeExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = this.sysNoticeExtra_;
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra1 = sysNoticeExtra2;
      if (sysNoticeExtra2 == null)
        sysNoticeExtra1 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance(); 
      return sysNoticeExtra1;
    }
    
    public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
      MsgBodyExtraOuterClass.TextExtra textExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.TextExtra textExtra1 = this.textExtra_;
        textExtra = textExtra1;
        if (textExtra1 == null)
          textExtra = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance(); 
        return textExtra;
      } 
      return (MsgBodyExtraOuterClass.TextExtra)textExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.TextExtra.Builder getTextExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.TextExtra.Builder)getTextExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.TextExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.TextExtra textExtra2 = this.textExtra_;
      MsgBodyExtraOuterClass.TextExtra textExtra1 = textExtra2;
      if (textExtra2 == null)
        textExtra1 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance(); 
      return textExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra1 = this.videoCallingExtra_;
        videoChatCallingExtra = videoChatCallingExtra1;
        if (videoChatCallingExtra1 == null)
          videoChatCallingExtra = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance(); 
        return videoChatCallingExtra;
      } 
      return (MsgBodyExtraOuterClass.VideoChatCallingExtra)videoChatCallingExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder getVideoCallingExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder)getVideoCallingExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = this.videoCallingExtra_;
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra1 = videoChatCallingExtra2;
      if (videoChatCallingExtra2 == null)
        videoChatCallingExtra1 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance(); 
      return videoChatCallingExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra1 = this.videoEndExtra_;
        videoChatEndExtra = videoChatEndExtra1;
        if (videoChatEndExtra1 == null)
          videoChatEndExtra = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance(); 
        return videoChatEndExtra;
      } 
      return (MsgBodyExtraOuterClass.VideoChatEndExtra)videoChatEndExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.VideoChatEndExtra.Builder getVideoEndExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.VideoChatEndExtra.Builder)getVideoEndExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = this.videoEndExtra_;
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra1 = videoChatEndExtra2;
      if (videoChatEndExtra2 == null)
        videoChatEndExtra1 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance(); 
      return videoChatEndExtra1;
    }
    
    public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
      MsgBodyExtraOuterClass.VideoExtra videoExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.VideoExtra videoExtra1 = this.videoExtra_;
        videoExtra = videoExtra1;
        if (videoExtra1 == null)
          videoExtra = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance(); 
        return videoExtra;
      } 
      return (MsgBodyExtraOuterClass.VideoExtra)videoExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.VideoExtra.Builder getVideoExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.VideoExtra.Builder)getVideoExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.VideoExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.VideoExtra videoExtra2 = this.videoExtra_;
      MsgBodyExtraOuterClass.VideoExtra videoExtra1 = videoExtra2;
      if (videoExtra2 == null)
        videoExtra1 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance(); 
      return videoExtra1;
    }
    
    public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
      MsgBodyExtraOuterClass.VipExtra vipExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.VipExtra vipExtra1 = this.vipExtra_;
        vipExtra = vipExtra1;
        if (vipExtra1 == null)
          vipExtra = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance(); 
        return vipExtra;
      } 
      return (MsgBodyExtraOuterClass.VipExtra)vipExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.VipExtra.Builder getVipExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.VipExtra.Builder)getVipExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.VipExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.VipExtra vipExtra2 = this.vipExtra_;
      MsgBodyExtraOuterClass.VipExtra vipExtra1 = vipExtra2;
      if (vipExtra2 == null)
        vipExtra1 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance(); 
      return vipExtra1;
    }
    
    public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra1 = this.voiceRoomShareExtra_;
        voiceRoomShareExtra = voiceRoomShareExtra1;
        if (voiceRoomShareExtra1 == null)
          voiceRoomShareExtra = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance(); 
        return voiceRoomShareExtra;
      } 
      return (MsgBodyExtraOuterClass.VoiceRoomShareExtra)voiceRoomShareExtra.getMessage();
    }
    
    public MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder getVoiceRoomShareExtraBuilder() {
      onChanged();
      return (MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder)getVoiceRoomShareExtraFieldBuilder().getBuilder();
    }
    
    public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV3 != null)
        return (MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder)singleFieldBuilderV3.getMessageOrBuilder(); 
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = this.voiceRoomShareExtra_;
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra1 = voiceRoomShareExtra2;
      if (voiceRoomShareExtra2 == null)
        voiceRoomShareExtra1 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance(); 
      return voiceRoomShareExtra1;
    }
    
    public boolean hasDoodleShareExtra() {
      return (this.doodleShareExtraBuilder_ != null || this.doodleShareExtra_ != null);
    }
    
    public boolean hasFeedShareExtra() {
      return (this.feedShareExtraBuilder_ != null || this.feedShareExtra_ != null);
    }
    
    public boolean hasGiftExtra() {
      return (this.giftExtraBuilder_ != null || this.giftExtra_ != null);
    }
    
    public boolean hasGroupCardExtra() {
      return (this.groupCardExtraBuilder_ != null || this.groupCardExtra_ != null);
    }
    
    public boolean hasGroupNotice() {
      return (this.groupNoticeBuilder_ != null || this.groupNotice_ != null);
    }
    
    public boolean hasHidenAlbumExtra() {
      return (this.hidenAlbumExtraBuilder_ != null || this.hidenAlbumExtra_ != null);
    }
    
    public boolean hasImagetextExtra() {
      return (this.imagetextExtraBuilder_ != null || this.imagetextExtra_ != null);
    }
    
    public boolean hasImgExtra() {
      return (this.imgExtraBuilder_ != null || this.imgExtra_ != null);
    }
    
    public boolean hasLiveShareExtra() {
      return (this.liveShareExtraBuilder_ != null || this.liveShareExtra_ != null);
    }
    
    public boolean hasLiveShareInternationalExtra() {
      return (this.liveShareInternationalExtraBuilder_ != null || this.liveShareInternationalExtra_ != null);
    }
    
    public boolean hasLocationExtra() {
      return (this.locationExtraBuilder_ != null || this.locationExtra_ != null);
    }
    
    public boolean hasMsgSource() {
      return (this.msgSourceBuilder_ != null || this.msgSource_ != null);
    }
    
    public boolean hasSayHiExtra() {
      return (this.sayHiExtraBuilder_ != null || this.sayHiExtra_ != null);
    }
    
    public boolean hasSecureNotify() {
      return (this.secureNotifyBuilder_ != null || this.secureNotify_ != null);
    }
    
    public boolean hasShareExtra() {
      return (this.shareExtraBuilder_ != null || this.shareExtra_ != null);
    }
    
    public boolean hasSysNoticeExtra() {
      return (this.sysNoticeExtraBuilder_ != null || this.sysNoticeExtra_ != null);
    }
    
    public boolean hasTextExtra() {
      return (this.textExtraBuilder_ != null || this.textExtra_ != null);
    }
    
    public boolean hasVideoCallingExtra() {
      return (this.videoCallingExtraBuilder_ != null || this.videoCallingExtra_ != null);
    }
    
    public boolean hasVideoEndExtra() {
      return (this.videoEndExtraBuilder_ != null || this.videoEndExtra_ != null);
    }
    
    public boolean hasVideoExtra() {
      return (this.videoExtraBuilder_ != null || this.videoExtra_ != null);
    }
    
    public boolean hasVipExtra() {
      return (this.vipExtraBuilder_ != null || this.vipExtra_ != null);
    }
    
    public boolean hasVoiceRoomShareExtra() {
      return (this.voiceRoomShareExtraBuilder_ != null || this.voiceRoomShareExtra_ != null);
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyExtraOuterClass.PushBodyExtra.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra param1DoodleShareExtra) {
      MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        doodleShareExtra = this.doodleShareExtra_;
        if (doodleShareExtra != null) {
          this.doodleShareExtra_ = MsgBodyExtraOuterClass.DoodleShareExtra.newBuilder(doodleShareExtra).mergeFrom(param1DoodleShareExtra).buildPartial();
        } else {
          this.doodleShareExtra_ = param1DoodleShareExtra;
        } 
        onChanged();
        return this;
      } 
      doodleShareExtra.mergeFrom((AbstractMessage)param1DoodleShareExtra);
      return this;
    }
    
    public Builder mergeFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra param1FeedShareExtra) {
      MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        feedShareExtra = this.feedShareExtra_;
        if (feedShareExtra != null) {
          this.feedShareExtra_ = MsgBodyExtraOuterClass.FeedShareExtra.newBuilder(feedShareExtra).mergeFrom(param1FeedShareExtra).buildPartial();
        } else {
          this.feedShareExtra_ = param1FeedShareExtra;
        } 
        onChanged();
        return this;
      } 
      feedShareExtra.mergeFrom((AbstractMessage)param1FeedShareExtra);
      return this;
    }
    
    public Builder mergeFrom(PushBodyExtraOuterClass.PushBodyExtra param1PushBodyExtra) {
      if (param1PushBodyExtra == PushBodyExtraOuterClass.PushBodyExtra.getDefaultInstance())
        return this; 
      if (param1PushBodyExtra.hasMsgSource())
        mergeMsgSource(param1PushBodyExtra.getMsgSource()); 
      if (param1PushBodyExtra.hasSecureNotify())
        mergeSecureNotify(param1PushBodyExtra.getSecureNotify()); 
      if (param1PushBodyExtra.hasTextExtra())
        mergeTextExtra(param1PushBodyExtra.getTextExtra()); 
      if (param1PushBodyExtra.hasImgExtra())
        mergeImgExtra(param1PushBodyExtra.getImgExtra()); 
      if (param1PushBodyExtra.getMsgReceiveFrom() != 0L)
        setMsgReceiveFrom(param1PushBodyExtra.getMsgReceiveFrom()); 
      if (param1PushBodyExtra.hasLocationExtra())
        mergeLocationExtra(param1PushBodyExtra.getLocationExtra()); 
      if (param1PushBodyExtra.hasVideoExtra())
        mergeVideoExtra(param1PushBodyExtra.getVideoExtra()); 
      if (param1PushBodyExtra.hasGroupCardExtra())
        mergeGroupCardExtra(param1PushBodyExtra.getGroupCardExtra()); 
      if (param1PushBodyExtra.hasLiveShareExtra())
        mergeLiveShareExtra(param1PushBodyExtra.getLiveShareExtra()); 
      if (param1PushBodyExtra.hasImagetextExtra())
        mergeImagetextExtra(param1PushBodyExtra.getImagetextExtra()); 
      if (param1PushBodyExtra.hasHidenAlbumExtra())
        mergeHidenAlbumExtra(param1PushBodyExtra.getHidenAlbumExtra()); 
      if (param1PushBodyExtra.hasShareExtra())
        mergeShareExtra(param1PushBodyExtra.getShareExtra()); 
      if (param1PushBodyExtra.hasVipExtra())
        mergeVipExtra(param1PushBodyExtra.getVipExtra()); 
      if (param1PushBodyExtra.hasGiftExtra())
        mergeGiftExtra(param1PushBodyExtra.getGiftExtra()); 
      if (param1PushBodyExtra.hasSysNoticeExtra())
        mergeSysNoticeExtra(param1PushBodyExtra.getSysNoticeExtra()); 
      if (param1PushBodyExtra.hasVideoCallingExtra())
        mergeVideoCallingExtra(param1PushBodyExtra.getVideoCallingExtra()); 
      if (param1PushBodyExtra.hasVideoEndExtra())
        mergeVideoEndExtra(param1PushBodyExtra.getVideoEndExtra()); 
      if (param1PushBodyExtra.hasFeedShareExtra())
        mergeFeedShareExtra(param1PushBodyExtra.getFeedShareExtra()); 
      if (param1PushBodyExtra.hasSayHiExtra())
        mergeSayHiExtra(param1PushBodyExtra.getSayHiExtra()); 
      if (param1PushBodyExtra.hasVoiceRoomShareExtra())
        mergeVoiceRoomShareExtra(param1PushBodyExtra.getVoiceRoomShareExtra()); 
      if (param1PushBodyExtra.hasLiveShareInternationalExtra())
        mergeLiveShareInternationalExtra(param1PushBodyExtra.getLiveShareInternationalExtra()); 
      if (param1PushBodyExtra.hasDoodleShareExtra())
        mergeDoodleShareExtra(param1PushBodyExtra.getDoodleShareExtra()); 
      if (param1PushBodyExtra.hasGroupNotice())
        mergeGroupNotice(param1PushBodyExtra.getGroupNotice()); 
      mergeUnknownFields(param1PushBodyExtra.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = (PushBodyExtraOuterClass.PushBodyExtra)PushBodyExtraOuterClass.PushBodyExtra.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PushBodyExtraOuterClass.PushBodyExtra pushBodyExtra = (PushBodyExtraOuterClass.PushBodyExtra)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PushBodyExtraOuterClass.PushBodyExtra)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PushBodyExtraOuterClass.PushBodyExtra)
        return mergeFrom((PushBodyExtraOuterClass.PushBodyExtra)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeGiftExtra(MsgBodyExtraOuterClass.GiftExtra param1GiftExtra) {
      MsgBodyExtraOuterClass.GiftExtra giftExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        giftExtra = this.giftExtra_;
        if (giftExtra != null) {
          this.giftExtra_ = MsgBodyExtraOuterClass.GiftExtra.newBuilder(giftExtra).mergeFrom(param1GiftExtra).buildPartial();
        } else {
          this.giftExtra_ = param1GiftExtra;
        } 
        onChanged();
        return this;
      } 
      giftExtra.mergeFrom((AbstractMessage)param1GiftExtra);
      return this;
    }
    
    public Builder mergeGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra param1GroupCardExtra) {
      MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        groupCardExtra = this.groupCardExtra_;
        if (groupCardExtra != null) {
          this.groupCardExtra_ = MsgBodyExtraOuterClass.GroupCardExtra.newBuilder(groupCardExtra).mergeFrom(param1GroupCardExtra).buildPartial();
        } else {
          this.groupCardExtra_ = param1GroupCardExtra;
        } 
        onChanged();
        return this;
      } 
      groupCardExtra.mergeFrom((AbstractMessage)param1GroupCardExtra);
      return this;
    }
    
    public Builder mergeGroupNotice(MsgBodyExtraOuterClass.GroupNotice param1GroupNotice) {
      MsgBodyExtraOuterClass.GroupNotice groupNotice;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 == null) {
        groupNotice = this.groupNotice_;
        if (groupNotice != null) {
          this.groupNotice_ = MsgBodyExtraOuterClass.GroupNotice.newBuilder(groupNotice).mergeFrom(param1GroupNotice).buildPartial();
        } else {
          this.groupNotice_ = param1GroupNotice;
        } 
        onChanged();
        return this;
      } 
      groupNotice.mergeFrom((AbstractMessage)param1GroupNotice);
      return this;
    }
    
    public Builder mergeHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra param1HidenAlbumExtra) {
      MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        hidenAlbumExtra = this.hidenAlbumExtra_;
        if (hidenAlbumExtra != null) {
          this.hidenAlbumExtra_ = MsgBodyExtraOuterClass.HidenAlbumExtra.newBuilder(hidenAlbumExtra).mergeFrom(param1HidenAlbumExtra).buildPartial();
        } else {
          this.hidenAlbumExtra_ = param1HidenAlbumExtra;
        } 
        onChanged();
        return this;
      } 
      hidenAlbumExtra.mergeFrom((AbstractMessage)param1HidenAlbumExtra);
      return this;
    }
    
    public Builder mergeImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra param1ImageTextExtra) {
      MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        imageTextExtra = this.imagetextExtra_;
        if (imageTextExtra != null) {
          this.imagetextExtra_ = MsgBodyExtraOuterClass.ImageTextExtra.newBuilder(imageTextExtra).mergeFrom(param1ImageTextExtra).buildPartial();
        } else {
          this.imagetextExtra_ = param1ImageTextExtra;
        } 
        onChanged();
        return this;
      } 
      imageTextExtra.mergeFrom((AbstractMessage)param1ImageTextExtra);
      return this;
    }
    
    public Builder mergeImgExtra(MsgBodyExtraOuterClass.ImgExtra param1ImgExtra) {
      MsgBodyExtraOuterClass.ImgExtra imgExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        imgExtra = this.imgExtra_;
        if (imgExtra != null) {
          this.imgExtra_ = MsgBodyExtraOuterClass.ImgExtra.newBuilder(imgExtra).mergeFrom(param1ImgExtra).buildPartial();
        } else {
          this.imgExtra_ = param1ImgExtra;
        } 
        onChanged();
        return this;
      } 
      imgExtra.mergeFrom((AbstractMessage)param1ImgExtra);
      return this;
    }
    
    public Builder mergeLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra param1LiveShareExtra) {
      MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        liveShareExtra = this.liveShareExtra_;
        if (liveShareExtra != null) {
          this.liveShareExtra_ = MsgBodyExtraOuterClass.LiveShareExtra.newBuilder(liveShareExtra).mergeFrom(param1LiveShareExtra).buildPartial();
        } else {
          this.liveShareExtra_ = param1LiveShareExtra;
        } 
        onChanged();
        return this;
      } 
      liveShareExtra.mergeFrom((AbstractMessage)param1LiveShareExtra);
      return this;
    }
    
    public Builder mergeLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra param1LiveShareInternationalExtra) {
      MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        liveShareInternationalExtra = this.liveShareInternationalExtra_;
        if (liveShareInternationalExtra != null) {
          this.liveShareInternationalExtra_ = MsgBodyExtraOuterClass.LiveShareInternationalExtra.newBuilder(liveShareInternationalExtra).mergeFrom(param1LiveShareInternationalExtra).buildPartial();
        } else {
          this.liveShareInternationalExtra_ = param1LiveShareInternationalExtra;
        } 
        onChanged();
        return this;
      } 
      liveShareInternationalExtra.mergeFrom((AbstractMessage)param1LiveShareInternationalExtra);
      return this;
    }
    
    public Builder mergeLocationExtra(MsgBodyExtraOuterClass.LocationExtra param1LocationExtra) {
      MsgBodyExtraOuterClass.LocationExtra locationExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        locationExtra = this.locationExtra_;
        if (locationExtra != null) {
          this.locationExtra_ = MsgBodyExtraOuterClass.LocationExtra.newBuilder(locationExtra).mergeFrom(param1LocationExtra).buildPartial();
        } else {
          this.locationExtra_ = param1LocationExtra;
        } 
        onChanged();
        return this;
      } 
      locationExtra.mergeFrom((AbstractMessage)param1LocationExtra);
      return this;
    }
    
    public Builder mergeMsgSource(MsgBodyExtraOuterClass.MsgSource param1MsgSource) {
      MsgBodyExtraOuterClass.MsgSource msgSource;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
      if (singleFieldBuilderV3 == null) {
        msgSource = this.msgSource_;
        if (msgSource != null) {
          this.msgSource_ = MsgBodyExtraOuterClass.MsgSource.newBuilder(msgSource).mergeFrom(param1MsgSource).buildPartial();
        } else {
          this.msgSource_ = param1MsgSource;
        } 
        onChanged();
        return this;
      } 
      msgSource.mergeFrom((AbstractMessage)param1MsgSource);
      return this;
    }
    
    public Builder mergeSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra param1SayHiExtra) {
      MsgBodyExtraOuterClass.SayHiExtra sayHiExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        sayHiExtra = this.sayHiExtra_;
        if (sayHiExtra != null) {
          this.sayHiExtra_ = MsgBodyExtraOuterClass.SayHiExtra.newBuilder(sayHiExtra).mergeFrom(param1SayHiExtra).buildPartial();
        } else {
          this.sayHiExtra_ = param1SayHiExtra;
        } 
        onChanged();
        return this;
      } 
      sayHiExtra.mergeFrom((AbstractMessage)param1SayHiExtra);
      return this;
    }
    
    public Builder mergeSecureNotify(MsgBodyExtraOuterClass.SecureNotify param1SecureNotify) {
      MsgBodyExtraOuterClass.SecureNotify secureNotify;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV3 == null) {
        secureNotify = this.secureNotify_;
        if (secureNotify != null) {
          this.secureNotify_ = MsgBodyExtraOuterClass.SecureNotify.newBuilder(secureNotify).mergeFrom(param1SecureNotify).buildPartial();
        } else {
          this.secureNotify_ = param1SecureNotify;
        } 
        onChanged();
        return this;
      } 
      secureNotify.mergeFrom((AbstractMessage)param1SecureNotify);
      return this;
    }
    
    public Builder mergeShareExtra(MsgBodyExtraOuterClass.ShareExtra param1ShareExtra) {
      MsgBodyExtraOuterClass.ShareExtra shareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        shareExtra = this.shareExtra_;
        if (shareExtra != null) {
          this.shareExtra_ = MsgBodyExtraOuterClass.ShareExtra.newBuilder(shareExtra).mergeFrom(param1ShareExtra).buildPartial();
        } else {
          this.shareExtra_ = param1ShareExtra;
        } 
        onChanged();
        return this;
      } 
      shareExtra.mergeFrom((AbstractMessage)param1ShareExtra);
      return this;
    }
    
    public Builder mergeSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra param1SysNoticeExtra) {
      MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        sysNoticeExtra = this.sysNoticeExtra_;
        if (sysNoticeExtra != null) {
          this.sysNoticeExtra_ = MsgBodyExtraOuterClass.SysNoticeExtra.newBuilder(sysNoticeExtra).mergeFrom(param1SysNoticeExtra).buildPartial();
        } else {
          this.sysNoticeExtra_ = param1SysNoticeExtra;
        } 
        onChanged();
        return this;
      } 
      sysNoticeExtra.mergeFrom((AbstractMessage)param1SysNoticeExtra);
      return this;
    }
    
    public Builder mergeTextExtra(MsgBodyExtraOuterClass.TextExtra param1TextExtra) {
      MsgBodyExtraOuterClass.TextExtra textExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        textExtra = this.textExtra_;
        if (textExtra != null) {
          this.textExtra_ = MsgBodyExtraOuterClass.TextExtra.newBuilder(textExtra).mergeFrom(param1TextExtra).buildPartial();
        } else {
          this.textExtra_ = param1TextExtra;
        } 
        onChanged();
        return this;
      } 
      textExtra.mergeFrom((AbstractMessage)param1TextExtra);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder mergeVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra param1VideoChatCallingExtra) {
      MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        videoChatCallingExtra = this.videoCallingExtra_;
        if (videoChatCallingExtra != null) {
          this.videoCallingExtra_ = MsgBodyExtraOuterClass.VideoChatCallingExtra.newBuilder(videoChatCallingExtra).mergeFrom(param1VideoChatCallingExtra).buildPartial();
        } else {
          this.videoCallingExtra_ = param1VideoChatCallingExtra;
        } 
        onChanged();
        return this;
      } 
      videoChatCallingExtra.mergeFrom((AbstractMessage)param1VideoChatCallingExtra);
      return this;
    }
    
    public Builder mergeVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra param1VideoChatEndExtra) {
      MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        videoChatEndExtra = this.videoEndExtra_;
        if (videoChatEndExtra != null) {
          this.videoEndExtra_ = MsgBodyExtraOuterClass.VideoChatEndExtra.newBuilder(videoChatEndExtra).mergeFrom(param1VideoChatEndExtra).buildPartial();
        } else {
          this.videoEndExtra_ = param1VideoChatEndExtra;
        } 
        onChanged();
        return this;
      } 
      videoChatEndExtra.mergeFrom((AbstractMessage)param1VideoChatEndExtra);
      return this;
    }
    
    public Builder mergeVideoExtra(MsgBodyExtraOuterClass.VideoExtra param1VideoExtra) {
      MsgBodyExtraOuterClass.VideoExtra videoExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        videoExtra = this.videoExtra_;
        if (videoExtra != null) {
          this.videoExtra_ = MsgBodyExtraOuterClass.VideoExtra.newBuilder(videoExtra).mergeFrom(param1VideoExtra).buildPartial();
        } else {
          this.videoExtra_ = param1VideoExtra;
        } 
        onChanged();
        return this;
      } 
      videoExtra.mergeFrom((AbstractMessage)param1VideoExtra);
      return this;
    }
    
    public Builder mergeVipExtra(MsgBodyExtraOuterClass.VipExtra param1VipExtra) {
      MsgBodyExtraOuterClass.VipExtra vipExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        vipExtra = this.vipExtra_;
        if (vipExtra != null) {
          this.vipExtra_ = MsgBodyExtraOuterClass.VipExtra.newBuilder(vipExtra).mergeFrom(param1VipExtra).buildPartial();
        } else {
          this.vipExtra_ = param1VipExtra;
        } 
        onChanged();
        return this;
      } 
      vipExtra.mergeFrom((AbstractMessage)param1VipExtra);
      return this;
    }
    
    public Builder mergeVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra param1VoiceRoomShareExtra) {
      MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra;
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        voiceRoomShareExtra = this.voiceRoomShareExtra_;
        if (voiceRoomShareExtra != null) {
          this.voiceRoomShareExtra_ = MsgBodyExtraOuterClass.VoiceRoomShareExtra.newBuilder(voiceRoomShareExtra).mergeFrom(param1VoiceRoomShareExtra).buildPartial();
        } else {
          this.voiceRoomShareExtra_ = param1VoiceRoomShareExtra;
        } 
        onChanged();
        return this;
      } 
      voiceRoomShareExtra.mergeFrom((AbstractMessage)param1VoiceRoomShareExtra);
      return this;
    }
    
    public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.doodleShareExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra param1DoodleShareExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1DoodleShareExtra != null) {
          this.doodleShareExtra_ = param1DoodleShareExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1DoodleShareExtra);
      return this;
    }
    
    public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.feedShareExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra param1FeedShareExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1FeedShareExtra != null) {
          this.feedShareExtra_ = param1FeedShareExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1FeedShareExtra);
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.giftExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra param1GiftExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1GiftExtra != null) {
          this.giftExtra_ = param1GiftExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1GiftExtra);
      return this;
    }
    
    public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.groupCardExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra param1GroupCardExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1GroupCardExtra != null) {
          this.groupCardExtra_ = param1GroupCardExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1GroupCardExtra);
      return this;
    }
    
    public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.groupNotice_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice param1GroupNotice) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1GroupNotice != null) {
          this.groupNotice_ = param1GroupNotice;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1GroupNotice);
      return this;
    }
    
    public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.hidenAlbumExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra param1HidenAlbumExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1HidenAlbumExtra != null) {
          this.hidenAlbumExtra_ = param1HidenAlbumExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1HidenAlbumExtra);
      return this;
    }
    
    public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.imagetextExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra param1ImageTextExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1ImageTextExtra != null) {
          this.imagetextExtra_ = param1ImageTextExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1ImageTextExtra);
      return this;
    }
    
    public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.imgExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra param1ImgExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1ImgExtra != null) {
          this.imgExtra_ = param1ImgExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1ImgExtra);
      return this;
    }
    
    public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.liveShareExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra param1LiveShareExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1LiveShareExtra != null) {
          this.liveShareExtra_ = param1LiveShareExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1LiveShareExtra);
      return this;
    }
    
    public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.liveShareInternationalExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra param1LiveShareInternationalExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1LiveShareInternationalExtra != null) {
          this.liveShareInternationalExtra_ = param1LiveShareInternationalExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1LiveShareInternationalExtra);
      return this;
    }
    
    public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.locationExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra param1LocationExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1LocationExtra != null) {
          this.locationExtra_ = param1LocationExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1LocationExtra);
      return this;
    }
    
    public Builder setMsgReceiveFrom(long param1Long) {
      this.msgReceiveFrom_ = param1Long;
      onChanged();
      return this;
    }
    
    public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.msgSource_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource param1MsgSource) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1MsgSource != null) {
          this.msgSource_ = param1MsgSource;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1MsgSource);
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sayHiExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra param1SayHiExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SayHiExtra != null) {
          this.sayHiExtra_ = param1SayHiExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1SayHiExtra);
      return this;
    }
    
    public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.secureNotify_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify param1SecureNotify) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SecureNotify != null) {
          this.secureNotify_ = param1SecureNotify;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1SecureNotify);
      return this;
    }
    
    public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.shareExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra param1ShareExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1ShareExtra != null) {
          this.shareExtra_ = param1ShareExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1ShareExtra);
      return this;
    }
    
    public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.sysNoticeExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra param1SysNoticeExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1SysNoticeExtra != null) {
          this.sysNoticeExtra_ = param1SysNoticeExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1SysNoticeExtra);
      return this;
    }
    
    public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.textExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra param1TextExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1TextExtra != null) {
          this.textExtra_ = param1TextExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1TextExtra);
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.videoCallingExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra param1VideoChatCallingExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1VideoChatCallingExtra != null) {
          this.videoCallingExtra_ = param1VideoChatCallingExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1VideoChatCallingExtra);
      return this;
    }
    
    public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.videoEndExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra param1VideoChatEndExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1VideoChatEndExtra != null) {
          this.videoEndExtra_ = param1VideoChatEndExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1VideoChatEndExtra);
      return this;
    }
    
    public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.videoExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra param1VideoExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1VideoExtra != null) {
          this.videoExtra_ = param1VideoExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1VideoExtra);
      return this;
    }
    
    public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.vipExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra param1VipExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1VipExtra != null) {
          this.vipExtra_ = param1VipExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1VipExtra);
      return this;
    }
    
    public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder param1Builder) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        this.voiceRoomShareExtra_ = param1Builder.build();
        onChanged();
        return this;
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1Builder.build());
      return this;
    }
    
    public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra param1VoiceRoomShareExtra) {
      SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
      if (singleFieldBuilderV3 == null) {
        if (param1VoiceRoomShareExtra != null) {
          this.voiceRoomShareExtra_ = param1VoiceRoomShareExtra;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      } 
      singleFieldBuilderV3.setMessage((AbstractMessage)param1VoiceRoomShareExtra);
      return this;
    }
  }
  
  public static interface PushBodyExtraOrBuilder extends MessageOrBuilder {
    MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra();
    
    MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder();
    
    MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra();
    
    MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder();
    
    MsgBodyExtraOuterClass.GiftExtra getGiftExtra();
    
    MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder();
    
    MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra();
    
    MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder();
    
    MsgBodyExtraOuterClass.GroupNotice getGroupNotice();
    
    MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder();
    
    MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra();
    
    MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder();
    
    MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra();
    
    MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder();
    
    MsgBodyExtraOuterClass.ImgExtra getImgExtra();
    
    MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder();
    
    MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra();
    
    MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder();
    
    MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra();
    
    MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder();
    
    MsgBodyExtraOuterClass.LocationExtra getLocationExtra();
    
    MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder();
    
    long getMsgReceiveFrom();
    
    MsgBodyExtraOuterClass.MsgSource getMsgSource();
    
    MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder();
    
    MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra();
    
    MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder();
    
    MsgBodyExtraOuterClass.SecureNotify getSecureNotify();
    
    MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder();
    
    MsgBodyExtraOuterClass.ShareExtra getShareExtra();
    
    MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder();
    
    MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra();
    
    MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder();
    
    MsgBodyExtraOuterClass.TextExtra getTextExtra();
    
    MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder();
    
    MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra();
    
    MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder();
    
    MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra();
    
    MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder();
    
    MsgBodyExtraOuterClass.VideoExtra getVideoExtra();
    
    MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder();
    
    MsgBodyExtraOuterClass.VipExtra getVipExtra();
    
    MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder();
    
    MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra();
    
    MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder();
    
    boolean hasDoodleShareExtra();
    
    boolean hasFeedShareExtra();
    
    boolean hasGiftExtra();
    
    boolean hasGroupCardExtra();
    
    boolean hasGroupNotice();
    
    boolean hasHidenAlbumExtra();
    
    boolean hasImagetextExtra();
    
    boolean hasImgExtra();
    
    boolean hasLiveShareExtra();
    
    boolean hasLiveShareInternationalExtra();
    
    boolean hasLocationExtra();
    
    boolean hasMsgSource();
    
    boolean hasSayHiExtra();
    
    boolean hasSecureNotify();
    
    boolean hasShareExtra();
    
    boolean hasSysNoticeExtra();
    
    boolean hasTextExtra();
    
    boolean hasVideoCallingExtra();
    
    boolean hasVideoEndExtra();
    
    boolean hasVideoExtra();
    
    boolean hasVipExtra();
    
    boolean hasVoiceRoomShareExtra();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\PushBodyExtraOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */