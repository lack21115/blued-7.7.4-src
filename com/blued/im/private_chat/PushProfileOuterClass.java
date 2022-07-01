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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class PushProfileOuterClass {
  private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\021PushProfile.proto\022\031com.blued.im.private_chat\"\003\n\013PushProfile\022\f\n\004name\030\001 \001(\t\022\016\n\006avatar\030\002 \001(\t\022\016\n\006coords\030\003 \003(\001\022\016\n\006vbadge\030\004 \001(\005\022\016\n\006online\030\005 \001(\005\022\016\n\006friend\030\006 \001(\005\022\022\n\nrich_level\030\007 \001(\005\022\024\n\fo_rich_level\030\b \001(\005\022\022\n\nvip_annual\030\t \001(\005\022\021\n\tvip_grade\030\n \001(\005\022\023\n\013vip_exp_lvl\030\013 \001(\005\022\023\n\013o_vip_grade\030\f \001(\005\022\030\n\020is_hide_vip_look\030\016 \001(\005\022\032\n\022o_is_hide_vip_look\030\017 \001(\005\022\026\n\016avatar_pendant\030\020 \001(\t\022\024\n\fdevice_token\030\021 \001(\005\022\025\n\rshadow_coords\030\022 \003(\001\022\025\n\ro_face_status\030\023 \001(\005\022\022\n\nis_manager\030\024 \001(\005B\016¢\002\013PrivateChatb\006proto3" }, new Descriptors.FileDescriptor[0]);
  
  private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushProfile_descriptor = getDescriptor().getMessageTypes().get(0);
  
  private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_com_blued_im_private_chat_PushProfile_descriptor, new String[] { 
        "Name", "Avatar", "Coords", "Vbadge", "Online", "Friend", "RichLevel", "ORichLevel", "VipAnnual", "VipGrade", 
        "VipExpLvl", "OVipGrade", "IsHideVipLook", "OIsHideVipLook", "AvatarPendant", "DeviceToken", "ShadowCoords", "OFaceStatus", "IsManager" });
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  public static void registerAllExtensions(ExtensionRegistry paramExtensionRegistry) {
    registerAllExtensions((ExtensionRegistryLite)paramExtensionRegistry);
  }
  
  public static void registerAllExtensions(ExtensionRegistryLite paramExtensionRegistryLite) {}
  
  public static final class PushProfile extends GeneratedMessageV3 implements PushProfileOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 2;
    
    public static final int AVATAR_PENDANT_FIELD_NUMBER = 16;
    
    public static final int COORDS_FIELD_NUMBER = 3;
    
    private static final PushProfile DEFAULT_INSTANCE = new PushProfile();
    
    public static final int DEVICE_TOKEN_FIELD_NUMBER = 17;
    
    public static final int FRIEND_FIELD_NUMBER = 6;
    
    public static final int IS_HIDE_VIP_LOOK_FIELD_NUMBER = 14;
    
    public static final int IS_MANAGER_FIELD_NUMBER = 20;
    
    public static final int NAME_FIELD_NUMBER = 1;
    
    public static final int ONLINE_FIELD_NUMBER = 5;
    
    public static final int O_FACE_STATUS_FIELD_NUMBER = 19;
    
    public static final int O_IS_HIDE_VIP_LOOK_FIELD_NUMBER = 15;
    
    public static final int O_RICH_LEVEL_FIELD_NUMBER = 8;
    
    public static final int O_VIP_GRADE_FIELD_NUMBER = 12;
    
    private static final Parser<PushProfile> PARSER = (Parser<PushProfile>)new AbstractParser<PushProfile>() {
        public PushProfileOuterClass.PushProfile parsePartialFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws InvalidProtocolBufferException {
          return new PushProfileOuterClass.PushProfile(param2CodedInputStream, param2ExtensionRegistryLite);
        }
      };
    
    public static final int RICH_LEVEL_FIELD_NUMBER = 7;
    
    public static final int SHADOW_COORDS_FIELD_NUMBER = 18;
    
    public static final int VBADGE_FIELD_NUMBER = 4;
    
    public static final int VIP_ANNUAL_FIELD_NUMBER = 9;
    
    public static final int VIP_EXP_LVL_FIELD_NUMBER = 11;
    
    public static final int VIP_GRADE_FIELD_NUMBER = 10;
    
    private static final long serialVersionUID = 0L;
    
    private volatile Object avatarPendant_;
    
    private volatile Object avatar_;
    
    private int coordsMemoizedSerializedSize = -1;
    
    private Internal.DoubleList coords_;
    
    private int deviceToken_;
    
    private int friend_;
    
    private int isHideVipLook_;
    
    private int isManager_;
    
    private byte memoizedIsInitialized = -1;
    
    private volatile Object name_;
    
    private int oFaceStatus_;
    
    private int oIsHideVipLook_;
    
    private int oRichLevel_;
    
    private int oVipGrade_;
    
    private int online_;
    
    private int richLevel_;
    
    private int shadowCoordsMemoizedSerializedSize = -1;
    
    private Internal.DoubleList shadowCoords_;
    
    private int vbadge_;
    
    private int vipAnnual_;
    
    private int vipExpLvl_;
    
    private int vipGrade_;
    
    private PushProfile() {
      this.name_ = "";
      this.avatar_ = "";
      this.coords_ = emptyDoubleList();
      this.avatarPendant_ = "";
      this.shadowCoords_ = emptyDoubleList();
    }
    
    private PushProfile(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
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
            int n = param1CodedInputStream.readTag();
            switch (n) {
              case 160:
                j = i;
                k = i;
                m = i;
                this.isManager_ = param1CodedInputStream.readInt32();
                continue;
              case 152:
                j = i;
                k = i;
                m = i;
                this.oFaceStatus_ = param1CodedInputStream.readInt32();
                continue;
              case 146:
                j = i;
                k = i;
                m = i;
                i1 = param1CodedInputStream.pushLimit(param1CodedInputStream.readRawVarint32());
                n = i;
                if ((i & 0x2) == 0) {
                  n = i;
                  j = i;
                  k = i;
                  m = i;
                  if (param1CodedInputStream.getBytesUntilLimit() > 0) {
                    j = i;
                    k = i;
                    m = i;
                    this.shadowCoords_ = newDoubleList();
                    n = i | 0x2;
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
                    this.shadowCoords_.addDouble(param1CodedInputStream.readDouble());
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
              case 145:
                n = i;
                if ((i & 0x2) == 0) {
                  j = i;
                  k = i;
                  m = i;
                  this.shadowCoords_ = newDoubleList();
                  n = i | 0x2;
                } 
                j = n;
                k = n;
                m = n;
                this.shadowCoords_.addDouble(param1CodedInputStream.readDouble());
                i = n;
                continue;
              case 136:
                j = i;
                k = i;
                m = i;
                this.deviceToken_ = param1CodedInputStream.readInt32();
                continue;
              case 130:
                j = i;
                k = i;
                m = i;
                this.avatarPendant_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 120:
                j = i;
                k = i;
                m = i;
                this.oIsHideVipLook_ = param1CodedInputStream.readInt32();
                continue;
              case 112:
                j = i;
                k = i;
                m = i;
                this.isHideVipLook_ = param1CodedInputStream.readInt32();
                continue;
              case 96:
                j = i;
                k = i;
                m = i;
                this.oVipGrade_ = param1CodedInputStream.readInt32();
                continue;
              case 88:
                j = i;
                k = i;
                m = i;
                this.vipExpLvl_ = param1CodedInputStream.readInt32();
                continue;
              case 80:
                j = i;
                k = i;
                m = i;
                this.vipGrade_ = param1CodedInputStream.readInt32();
                continue;
              case 72:
                j = i;
                k = i;
                m = i;
                this.vipAnnual_ = param1CodedInputStream.readInt32();
                continue;
              case 64:
                j = i;
                k = i;
                m = i;
                this.oRichLevel_ = param1CodedInputStream.readInt32();
                continue;
              case 56:
                j = i;
                k = i;
                m = i;
                this.richLevel_ = param1CodedInputStream.readInt32();
                continue;
              case 48:
                j = i;
                k = i;
                m = i;
                this.friend_ = param1CodedInputStream.readInt32();
                continue;
              case 40:
                j = i;
                k = i;
                m = i;
                this.online_ = param1CodedInputStream.readInt32();
                continue;
              case 32:
                j = i;
                k = i;
                m = i;
                this.vbadge_ = param1CodedInputStream.readInt32();
                continue;
              case 26:
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
              case 25:
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
              case 18:
                j = i;
                k = i;
                m = i;
                this.avatar_ = param1CodedInputStream.readStringRequireUtf8();
                continue;
              case 10:
                j = i;
                k = i;
                m = i;
                this.name_ = param1CodedInputStream.readStringRequireUtf8();
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
          if ((j & 0x2) != 0)
            this.shadowCoords_.makeImmutable(); 
          this.unknownFields = builder.build();
          makeExtensionsImmutable();
          throw param1CodedInputStream;
        } 
        if ((i & 0x1) != 0)
          this.coords_.makeImmutable(); 
        if ((i & 0x2) != 0)
          this.shadowCoords_.makeImmutable(); 
        this.unknownFields = builder.build();
        makeExtensionsImmutable();
        return;
      } 
      throw new NullPointerException();
    }
    
    private PushProfile(GeneratedMessageV3.Builder<?> param1Builder) {
      super(param1Builder);
    }
    
    public static PushProfile getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
    }
    
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    
    public static Builder newBuilder(PushProfile param1PushProfile) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(param1PushProfile);
    }
    
    public static PushProfile parseDelimitedFrom(InputStream param1InputStream) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream);
    }
    
    public static PushProfile parseDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushProfile parseFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ByteString);
    }
    
    public static PushProfile parseFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ByteString, param1ExtensionRegistryLite);
    }
    
    public static PushProfile parseFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream);
    }
    
    public static PushProfile parseFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseWithIOException(PARSER, param1CodedInputStream, param1ExtensionRegistryLite);
    }
    
    public static PushProfile parseFrom(InputStream param1InputStream) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream);
    }
    
    public static PushProfile parseFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      return (PushProfile)GeneratedMessageV3.parseWithIOException(PARSER, param1InputStream, param1ExtensionRegistryLite);
    }
    
    public static PushProfile parseFrom(ByteBuffer param1ByteBuffer) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ByteBuffer);
    }
    
    public static PushProfile parseFrom(ByteBuffer param1ByteBuffer, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ByteBuffer, param1ExtensionRegistryLite);
    }
    
    public static PushProfile parseFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ArrayOfbyte);
    }
    
    public static PushProfile parseFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return (PushProfile)PARSER.parseFrom(param1ArrayOfbyte, param1ExtensionRegistryLite);
    }
    
    public static Parser<PushProfile> parser() {
      return PARSER;
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof PushProfile))
        return super.equals(param1Object); 
      param1Object = param1Object;
      return !getName().equals(param1Object.getName()) ? false : (!getAvatar().equals(param1Object.getAvatar()) ? false : (!getCoordsList().equals(param1Object.getCoordsList()) ? false : ((getVbadge() != param1Object.getVbadge()) ? false : ((getOnline() != param1Object.getOnline()) ? false : ((getFriend() != param1Object.getFriend()) ? false : ((getRichLevel() != param1Object.getRichLevel()) ? false : ((getORichLevel() != param1Object.getORichLevel()) ? false : ((getVipAnnual() != param1Object.getVipAnnual()) ? false : ((getVipGrade() != param1Object.getVipGrade()) ? false : ((getVipExpLvl() != param1Object.getVipExpLvl()) ? false : ((getOVipGrade() != param1Object.getOVipGrade()) ? false : ((getIsHideVipLook() != param1Object.getIsHideVipLook()) ? false : ((getOIsHideVipLook() != param1Object.getOIsHideVipLook()) ? false : (!getAvatarPendant().equals(param1Object.getAvatarPendant()) ? false : ((getDeviceToken() != param1Object.getDeviceToken()) ? false : (!getShadowCoordsList().equals(param1Object.getShadowCoordsList()) ? false : ((getOFaceStatus() != param1Object.getOFaceStatus()) ? false : ((getIsManager() != param1Object.getIsManager()) ? false : (!!this.unknownFields.equals(((PushProfile)param1Object).unknownFields))))))))))))))))))));
    }
    
    public String getAvatar() {
      Object object = this.avatar_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.avatar_ = object;
      return (String)object;
    }
    
    public ByteString getAvatarBytes() {
      Object object = this.avatar_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.avatar_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getAvatarPendant() {
      Object object = this.avatarPendant_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.avatarPendant_ = object;
      return (String)object;
    }
    
    public ByteString getAvatarPendantBytes() {
      Object object = this.avatarPendant_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.avatarPendant_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public PushProfile getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }
    
    public int getDeviceToken() {
      return this.deviceToken_;
    }
    
    public int getFriend() {
      return this.friend_;
    }
    
    public int getIsHideVipLook() {
      return this.isHideVipLook_;
    }
    
    public int getIsManager() {
      return this.isManager_;
    }
    
    public String getName() {
      Object object = this.name_;
      if (object instanceof String)
        return (String)object; 
      object = ((ByteString)object).toStringUtf8();
      this.name_ = object;
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getOFaceStatus() {
      return this.oFaceStatus_;
    }
    
    public int getOIsHideVipLook() {
      return this.oIsHideVipLook_;
    }
    
    public int getORichLevel() {
      return this.oRichLevel_;
    }
    
    public int getOVipGrade() {
      return this.oVipGrade_;
    }
    
    public int getOnline() {
      return this.online_;
    }
    
    public Parser<PushProfile> getParserForType() {
      return PARSER;
    }
    
    public int getRichLevel() {
      return this.richLevel_;
    }
    
    public int getSerializedSize() {
      int i = this.memoizedSize;
      if (i != -1)
        return i; 
      i = 0;
      if (!getNameBytes().isEmpty())
        i = 0 + GeneratedMessageV3.computeStringSize(1, this.name_); 
      int j = i;
      if (!getAvatarBytes().isEmpty())
        j = i + GeneratedMessageV3.computeStringSize(2, this.avatar_); 
      int k = getCoordsList().size() * 8;
      j += k;
      i = j;
      if (!getCoordsList().isEmpty())
        i = j + 1 + CodedOutputStream.computeInt32SizeNoTag(k); 
      this.coordsMemoizedSerializedSize = k;
      k = this.vbadge_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(4, k); 
      k = this.online_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(5, k); 
      k = this.friend_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(6, k); 
      k = this.richLevel_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(7, k); 
      k = this.oRichLevel_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(8, k); 
      k = this.vipAnnual_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(9, k); 
      k = this.vipGrade_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(10, k); 
      k = this.vipExpLvl_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(11, k); 
      k = this.oVipGrade_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(12, k); 
      k = this.isHideVipLook_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(14, k); 
      k = this.oIsHideVipLook_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(15, k); 
      i = j;
      if (!getAvatarPendantBytes().isEmpty())
        i = j + GeneratedMessageV3.computeStringSize(16, this.avatarPendant_); 
      k = this.deviceToken_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(17, k); 
      k = getShadowCoordsList().size() * 8;
      j += k;
      i = j;
      if (!getShadowCoordsList().isEmpty())
        i = j + 2 + CodedOutputStream.computeInt32SizeNoTag(k); 
      this.shadowCoordsMemoizedSerializedSize = k;
      k = this.oFaceStatus_;
      j = i;
      if (k != 0)
        j = i + CodedOutputStream.computeInt32Size(19, k); 
      k = this.isManager_;
      i = j;
      if (k != 0)
        i = j + CodedOutputStream.computeInt32Size(20, k); 
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      return i;
    }
    
    public double getShadowCoords(int param1Int) {
      return this.shadowCoords_.getDouble(param1Int);
    }
    
    public int getShadowCoordsCount() {
      return this.shadowCoords_.size();
    }
    
    public List<Double> getShadowCoordsList() {
      return (List<Double>)this.shadowCoords_;
    }
    
    public final UnknownFieldSet getUnknownFields() {
      return this.unknownFields;
    }
    
    public int getVbadge() {
      return this.vbadge_;
    }
    
    public int getVipAnnual() {
      return this.vipAnnual_;
    }
    
    public int getVipExpLvl() {
      return this.vipExpLvl_;
    }
    
    public int getVipGrade() {
      return this.vipGrade_;
    }
    
    public int hashCode() {
      if (this.memoizedHashCode != 0)
        return this.memoizedHashCode; 
      int j = ((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getName().hashCode()) * 37 + 2) * 53 + getAvatar().hashCode();
      int i = j;
      if (getCoordsCount() > 0)
        i = (j * 37 + 3) * 53 + getCoordsList().hashCode(); 
      j = (((((((((((((((((((((((((i * 37 + 4) * 53 + getVbadge()) * 37 + 5) * 53 + getOnline()) * 37 + 6) * 53 + getFriend()) * 37 + 7) * 53 + getRichLevel()) * 37 + 8) * 53 + getORichLevel()) * 37 + 9) * 53 + getVipAnnual()) * 37 + 10) * 53 + getVipGrade()) * 37 + 11) * 53 + getVipExpLvl()) * 37 + 12) * 53 + getOVipGrade()) * 37 + 14) * 53 + getIsHideVipLook()) * 37 + 15) * 53 + getOIsHideVipLook()) * 37 + 16) * 53 + getAvatarPendant().hashCode()) * 37 + 17) * 53 + getDeviceToken();
      i = j;
      if (getShadowCoordsCount() > 0)
        i = (j * 37 + 18) * 53 + getShadowCoordsList().hashCode(); 
      i = ((((i * 37 + 19) * 53 + getOFaceStatus()) * 37 + 20) * 53 + getIsManager()) * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      return i;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(PushProfile.class, Builder.class);
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
      return new PushProfile();
    }
    
    public Builder toBuilder() {
      return (this == DEFAULT_INSTANCE) ? new Builder() : (new Builder()).mergeFrom(this);
    }
    
    public void writeTo(CodedOutputStream param1CodedOutputStream) throws IOException {
      getSerializedSize();
      if (!getNameBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 1, this.name_); 
      if (!getAvatarBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 2, this.avatar_); 
      if (getCoordsList().size() > 0) {
        param1CodedOutputStream.writeUInt32NoTag(26);
        param1CodedOutputStream.writeUInt32NoTag(this.coordsMemoizedSerializedSize);
      } 
      boolean bool = false;
      int i;
      for (i = 0; i < this.coords_.size(); i++)
        param1CodedOutputStream.writeDoubleNoTag(this.coords_.getDouble(i)); 
      i = this.vbadge_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(4, i); 
      i = this.online_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(5, i); 
      i = this.friend_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(6, i); 
      i = this.richLevel_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(7, i); 
      i = this.oRichLevel_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(8, i); 
      i = this.vipAnnual_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(9, i); 
      i = this.vipGrade_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(10, i); 
      i = this.vipExpLvl_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(11, i); 
      i = this.oVipGrade_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(12, i); 
      i = this.isHideVipLook_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(14, i); 
      i = this.oIsHideVipLook_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(15, i); 
      if (!getAvatarPendantBytes().isEmpty())
        GeneratedMessageV3.writeString(param1CodedOutputStream, 16, this.avatarPendant_); 
      i = this.deviceToken_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(17, i); 
      i = bool;
      if (getShadowCoordsList().size() > 0) {
        param1CodedOutputStream.writeUInt32NoTag(146);
        param1CodedOutputStream.writeUInt32NoTag(this.shadowCoordsMemoizedSerializedSize);
        i = bool;
      } 
      while (i < this.shadowCoords_.size()) {
        param1CodedOutputStream.writeDoubleNoTag(this.shadowCoords_.getDouble(i));
        i++;
      } 
      i = this.oFaceStatus_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(19, i); 
      i = this.isManager_;
      if (i != 0)
        param1CodedOutputStream.writeInt32(20, i); 
      this.unknownFields.writeTo(param1CodedOutputStream);
    }
    
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushProfileOuterClass.PushProfileOrBuilder {
      private Object avatarPendant_ = "";
      
      private Object avatar_ = "";
      
      private int bitField0_;
      
      private Internal.DoubleList coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      
      private int deviceToken_;
      
      private int friend_;
      
      private int isHideVipLook_;
      
      private int isManager_;
      
      private Object name_ = "";
      
      private int oFaceStatus_;
      
      private int oIsHideVipLook_;
      
      private int oRichLevel_;
      
      private int oVipGrade_;
      
      private int online_;
      
      private int richLevel_;
      
      private Internal.DoubleList shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      
      private int vbadge_;
      
      private int vipAnnual_;
      
      private int vipExpLvl_;
      
      private int vipGrade_;
      
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(GeneratedMessageV3.BuilderParent param2BuilderParent) {
        super(param2BuilderParent);
        maybeForceBuilderInitialization();
      }
      
      private void ensureCoordsIsMutable() {
        if ((this.bitField0_ & 0x1) == 0) {
          this.coords_ = PushProfileOuterClass.PushProfile.mutableCopy(this.coords_);
          this.bitField0_ |= 0x1;
        } 
      }
      
      private void ensureShadowCoordsIsMutable() {
        if ((this.bitField0_ & 0x2) == 0) {
          this.shadowCoords_ = PushProfileOuterClass.PushProfile.mutableCopy(this.shadowCoords_);
          this.bitField0_ |= 0x2;
        } 
      }
      
      public static final Descriptors.Descriptor getDescriptor() {
        return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
      }
      
      private void maybeForceBuilderInitialization() {
        PushProfileOuterClass.PushProfile.alwaysUseFieldBuilders;
      }
      
      public Builder addAllCoords(Iterable<? extends Double> param2Iterable) {
        ensureCoordsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.coords_);
        onChanged();
        return this;
      }
      
      public Builder addAllShadowCoords(Iterable<? extends Double> param2Iterable) {
        ensureShadowCoordsIsMutable();
        AbstractMessageLite.Builder.addAll(param2Iterable, (List)this.shadowCoords_);
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
      
      public Builder addShadowCoords(double param2Double) {
        ensureShadowCoordsIsMutable();
        this.shadowCoords_.addDouble(param2Double);
        onChanged();
        return this;
      }
      
      public PushProfileOuterClass.PushProfile build() {
        PushProfileOuterClass.PushProfile pushProfile = buildPartial();
        if (pushProfile.isInitialized())
          return pushProfile; 
        throw newUninitializedMessageException(pushProfile);
      }
      
      public PushProfileOuterClass.PushProfile buildPartial() {
        PushProfileOuterClass.PushProfile pushProfile = new PushProfileOuterClass.PushProfile(this);
        int i = this.bitField0_;
        PushProfileOuterClass.PushProfile.access$802(pushProfile, this.name_);
        PushProfileOuterClass.PushProfile.access$902(pushProfile, this.avatar_);
        if ((this.bitField0_ & 0x1) != 0) {
          this.coords_.makeImmutable();
          this.bitField0_ &= 0xFFFFFFFE;
        } 
        PushProfileOuterClass.PushProfile.access$1002(pushProfile, this.coords_);
        PushProfileOuterClass.PushProfile.access$1102(pushProfile, this.vbadge_);
        PushProfileOuterClass.PushProfile.access$1202(pushProfile, this.online_);
        PushProfileOuterClass.PushProfile.access$1302(pushProfile, this.friend_);
        PushProfileOuterClass.PushProfile.access$1402(pushProfile, this.richLevel_);
        PushProfileOuterClass.PushProfile.access$1502(pushProfile, this.oRichLevel_);
        PushProfileOuterClass.PushProfile.access$1602(pushProfile, this.vipAnnual_);
        PushProfileOuterClass.PushProfile.access$1702(pushProfile, this.vipGrade_);
        PushProfileOuterClass.PushProfile.access$1802(pushProfile, this.vipExpLvl_);
        PushProfileOuterClass.PushProfile.access$1902(pushProfile, this.oVipGrade_);
        PushProfileOuterClass.PushProfile.access$2002(pushProfile, this.isHideVipLook_);
        PushProfileOuterClass.PushProfile.access$2102(pushProfile, this.oIsHideVipLook_);
        PushProfileOuterClass.PushProfile.access$2202(pushProfile, this.avatarPendant_);
        PushProfileOuterClass.PushProfile.access$2302(pushProfile, this.deviceToken_);
        if ((this.bitField0_ & 0x2) != 0) {
          this.shadowCoords_.makeImmutable();
          this.bitField0_ &= 0xFFFFFFFD;
        } 
        PushProfileOuterClass.PushProfile.access$2402(pushProfile, this.shadowCoords_);
        PushProfileOuterClass.PushProfile.access$2502(pushProfile, this.oFaceStatus_);
        PushProfileOuterClass.PushProfile.access$2602(pushProfile, this.isManager_);
        onBuilt();
        return pushProfile;
      }
      
      public Builder clear() {
        super.clear();
        this.name_ = "";
        this.avatar_ = "";
        this.coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        this.vbadge_ = 0;
        this.online_ = 0;
        this.friend_ = 0;
        this.richLevel_ = 0;
        this.oRichLevel_ = 0;
        this.vipAnnual_ = 0;
        this.vipGrade_ = 0;
        this.vipExpLvl_ = 0;
        this.oVipGrade_ = 0;
        this.isHideVipLook_ = 0;
        this.oIsHideVipLook_ = 0;
        this.avatarPendant_ = "";
        this.deviceToken_ = 0;
        this.shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFD;
        this.oFaceStatus_ = 0;
        this.isManager_ = 0;
        return this;
      }
      
      public Builder clearAvatar() {
        this.avatar_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getAvatar();
        onChanged();
        return this;
      }
      
      public Builder clearAvatarPendant() {
        this.avatarPendant_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getAvatarPendant();
        onChanged();
        return this;
      }
      
      public Builder clearCoords() {
        this.coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFE;
        onChanged();
        return this;
      }
      
      public Builder clearDeviceToken() {
        this.deviceToken_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearField(Descriptors.FieldDescriptor param2FieldDescriptor) {
        return (Builder)super.clearField(param2FieldDescriptor);
      }
      
      public Builder clearFriend() {
        this.friend_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearIsHideVipLook() {
        this.isHideVipLook_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearIsManager() {
        this.isManager_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearName() {
        this.name_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getName();
        onChanged();
        return this;
      }
      
      public Builder clearOFaceStatus() {
        this.oFaceStatus_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOIsHideVipLook() {
        this.oIsHideVipLook_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearORichLevel() {
        this.oRichLevel_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOVipGrade() {
        this.oVipGrade_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearOneof(Descriptors.OneofDescriptor param2OneofDescriptor) {
        return (Builder)super.clearOneof(param2OneofDescriptor);
      }
      
      public Builder clearOnline() {
        this.online_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearRichLevel() {
        this.richLevel_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearShadowCoords() {
        this.shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
        this.bitField0_ &= 0xFFFFFFFD;
        onChanged();
        return this;
      }
      
      public Builder clearVbadge() {
        this.vbadge_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearVipAnnual() {
        this.vipAnnual_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearVipExpLvl() {
        this.vipExpLvl_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clearVipGrade() {
        this.vipGrade_ = 0;
        onChanged();
        return this;
      }
      
      public Builder clone() {
        return (Builder)super.clone();
      }
      
      public String getAvatar() {
        Object object = this.avatar_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.avatar_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAvatarBytes() {
        Object object = this.avatar_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.avatar_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public String getAvatarPendant() {
        Object object = this.avatarPendant_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.avatarPendant_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getAvatarPendantBytes() {
        Object object = this.avatarPendant_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.avatarPendant_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
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
      
      public PushProfileOuterClass.PushProfile getDefaultInstanceForType() {
        return PushProfileOuterClass.PushProfile.getDefaultInstance();
      }
      
      public Descriptors.Descriptor getDescriptorForType() {
        return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
      }
      
      public int getDeviceToken() {
        return this.deviceToken_;
      }
      
      public int getFriend() {
        return this.friend_;
      }
      
      public int getIsHideVipLook() {
        return this.isHideVipLook_;
      }
      
      public int getIsManager() {
        return this.isManager_;
      }
      
      public String getName() {
        Object object = this.name_;
        if (!(object instanceof String)) {
          object = ((ByteString)object).toStringUtf8();
          this.name_ = object;
          return (String)object;
        } 
        return (String)object;
      }
      
      public ByteString getNameBytes() {
        Object object = this.name_;
        if (object instanceof String) {
          object = ByteString.copyFromUtf8((String)object);
          this.name_ = object;
          return (ByteString)object;
        } 
        return (ByteString)object;
      }
      
      public int getOFaceStatus() {
        return this.oFaceStatus_;
      }
      
      public int getOIsHideVipLook() {
        return this.oIsHideVipLook_;
      }
      
      public int getORichLevel() {
        return this.oRichLevel_;
      }
      
      public int getOVipGrade() {
        return this.oVipGrade_;
      }
      
      public int getOnline() {
        return this.online_;
      }
      
      public int getRichLevel() {
        return this.richLevel_;
      }
      
      public double getShadowCoords(int param2Int) {
        return this.shadowCoords_.getDouble(param2Int);
      }
      
      public int getShadowCoordsCount() {
        return this.shadowCoords_.size();
      }
      
      public List<Double> getShadowCoordsList() {
        return (List<Double>)(((this.bitField0_ & 0x2) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.shadowCoords_) : this.shadowCoords_);
      }
      
      public int getVbadge() {
        return this.vbadge_;
      }
      
      public int getVipAnnual() {
        return this.vipAnnual_;
      }
      
      public int getVipExpLvl() {
        return this.vipExpLvl_;
      }
      
      public int getVipGrade() {
        return this.vipGrade_;
      }
      
      public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(PushProfileOuterClass.PushProfile.class, Builder.class);
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(PushProfileOuterClass.PushProfile param2PushProfile) {
        if (param2PushProfile == PushProfileOuterClass.PushProfile.getDefaultInstance())
          return this; 
        if (!param2PushProfile.getName().isEmpty()) {
          this.name_ = param2PushProfile.name_;
          onChanged();
        } 
        if (!param2PushProfile.getAvatar().isEmpty()) {
          this.avatar_ = param2PushProfile.avatar_;
          onChanged();
        } 
        if (!param2PushProfile.coords_.isEmpty()) {
          if (this.coords_.isEmpty()) {
            this.coords_ = param2PushProfile.coords_;
            this.bitField0_ &= 0xFFFFFFFE;
          } else {
            ensureCoordsIsMutable();
            this.coords_.addAll((Collection)param2PushProfile.coords_);
          } 
          onChanged();
        } 
        if (param2PushProfile.getVbadge() != 0)
          setVbadge(param2PushProfile.getVbadge()); 
        if (param2PushProfile.getOnline() != 0)
          setOnline(param2PushProfile.getOnline()); 
        if (param2PushProfile.getFriend() != 0)
          setFriend(param2PushProfile.getFriend()); 
        if (param2PushProfile.getRichLevel() != 0)
          setRichLevel(param2PushProfile.getRichLevel()); 
        if (param2PushProfile.getORichLevel() != 0)
          setORichLevel(param2PushProfile.getORichLevel()); 
        if (param2PushProfile.getVipAnnual() != 0)
          setVipAnnual(param2PushProfile.getVipAnnual()); 
        if (param2PushProfile.getVipGrade() != 0)
          setVipGrade(param2PushProfile.getVipGrade()); 
        if (param2PushProfile.getVipExpLvl() != 0)
          setVipExpLvl(param2PushProfile.getVipExpLvl()); 
        if (param2PushProfile.getOVipGrade() != 0)
          setOVipGrade(param2PushProfile.getOVipGrade()); 
        if (param2PushProfile.getIsHideVipLook() != 0)
          setIsHideVipLook(param2PushProfile.getIsHideVipLook()); 
        if (param2PushProfile.getOIsHideVipLook() != 0)
          setOIsHideVipLook(param2PushProfile.getOIsHideVipLook()); 
        if (!param2PushProfile.getAvatarPendant().isEmpty()) {
          this.avatarPendant_ = param2PushProfile.avatarPendant_;
          onChanged();
        } 
        if (param2PushProfile.getDeviceToken() != 0)
          setDeviceToken(param2PushProfile.getDeviceToken()); 
        if (!param2PushProfile.shadowCoords_.isEmpty()) {
          if (this.shadowCoords_.isEmpty()) {
            this.shadowCoords_ = param2PushProfile.shadowCoords_;
            this.bitField0_ &= 0xFFFFFFFD;
          } else {
            ensureShadowCoordsIsMutable();
            this.shadowCoords_.addAll((Collection)param2PushProfile.shadowCoords_);
          } 
          onChanged();
        } 
        if (param2PushProfile.getOFaceStatus() != 0)
          setOFaceStatus(param2PushProfile.getOFaceStatus()); 
        if (param2PushProfile.getIsManager() != 0)
          setIsManager(param2PushProfile.getIsManager()); 
        mergeUnknownFields(param2PushProfile.unknownFields);
        onChanged();
        return this;
      }
      
      public Builder mergeFrom(CodedInputStream param2CodedInputStream, ExtensionRegistryLite param2ExtensionRegistryLite) throws IOException {
        CodedInputStream codedInputStream = null;
        try {
          PushProfileOuterClass.PushProfile pushProfile = (PushProfileOuterClass.PushProfile)PushProfileOuterClass.PushProfile.PARSER.parsePartialFrom(param2CodedInputStream, param2ExtensionRegistryLite);
          return this;
        } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
          PushProfileOuterClass.PushProfile pushProfile = (PushProfileOuterClass.PushProfile)invalidProtocolBufferException.getUnfinishedMessage();
        } finally {
          param2ExtensionRegistryLite = null;
        } 
        if (param2CodedInputStream != null)
          mergeFrom((PushProfileOuterClass.PushProfile)param2CodedInputStream); 
        throw param2ExtensionRegistryLite;
      }
      
      public Builder mergeFrom(Message param2Message) {
        if (param2Message instanceof PushProfileOuterClass.PushProfile)
          return mergeFrom((PushProfileOuterClass.PushProfile)param2Message); 
        super.mergeFrom(param2Message);
        return this;
      }
      
      public final Builder mergeUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.mergeUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setAvatar(String param2String) {
        if (param2String != null) {
          this.avatar_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAvatarBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param2ByteString);
          this.avatar_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAvatarPendant(String param2String) {
        if (param2String != null) {
          this.avatarPendant_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setAvatarPendantBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param2ByteString);
          this.avatarPendant_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setCoords(int param2Int, double param2Double) {
        ensureCoordsIsMutable();
        this.coords_.setDouble(param2Int, param2Double);
        onChanged();
        return this;
      }
      
      public Builder setDeviceToken(int param2Int) {
        this.deviceToken_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setField(Descriptors.FieldDescriptor param2FieldDescriptor, Object param2Object) {
        return (Builder)super.setField(param2FieldDescriptor, param2Object);
      }
      
      public Builder setFriend(int param2Int) {
        this.friend_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsHideVipLook(int param2Int) {
        this.isHideVipLook_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setIsManager(int param2Int) {
        this.isManager_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setName(String param2String) {
        if (param2String != null) {
          this.name_ = param2String;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setNameBytes(ByteString param2ByteString) {
        if (param2ByteString != null) {
          PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param2ByteString);
          this.name_ = param2ByteString;
          onChanged();
          return this;
        } 
        throw new NullPointerException();
      }
      
      public Builder setOFaceStatus(int param2Int) {
        this.oFaceStatus_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOIsHideVipLook(int param2Int) {
        this.oIsHideVipLook_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setORichLevel(int param2Int) {
        this.oRichLevel_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOVipGrade(int param2Int) {
        this.oVipGrade_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setOnline(int param2Int) {
        this.online_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setRepeatedField(Descriptors.FieldDescriptor param2FieldDescriptor, int param2Int, Object param2Object) {
        return (Builder)super.setRepeatedField(param2FieldDescriptor, param2Int, param2Object);
      }
      
      public Builder setRichLevel(int param2Int) {
        this.richLevel_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setShadowCoords(int param2Int, double param2Double) {
        ensureShadowCoordsIsMutable();
        this.shadowCoords_.setDouble(param2Int, param2Double);
        onChanged();
        return this;
      }
      
      public final Builder setUnknownFields(UnknownFieldSet param2UnknownFieldSet) {
        return (Builder)super.setUnknownFields(param2UnknownFieldSet);
      }
      
      public Builder setVbadge(int param2Int) {
        this.vbadge_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setVipAnnual(int param2Int) {
        this.vipAnnual_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setVipExpLvl(int param2Int) {
        this.vipExpLvl_ = param2Int;
        onChanged();
        return this;
      }
      
      public Builder setVipGrade(int param2Int) {
        this.vipGrade_ = param2Int;
        onChanged();
        return this;
      }
    }
  }
  
  static final class null extends AbstractParser<PushProfile> {
    public PushProfileOuterClass.PushProfile parsePartialFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return new PushProfileOuterClass.PushProfile(param1CodedInputStream, param1ExtensionRegistryLite);
    }
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<PushProfile.Builder> implements PushProfileOrBuilder {
    private Object avatarPendant_ = "";
    
    private Object avatar_ = "";
    
    private int bitField0_;
    
    private Internal.DoubleList coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
    
    private int deviceToken_;
    
    private int friend_;
    
    private int isHideVipLook_;
    
    private int isManager_;
    
    private Object name_ = "";
    
    private int oFaceStatus_;
    
    private int oIsHideVipLook_;
    
    private int oRichLevel_;
    
    private int oVipGrade_;
    
    private int online_;
    
    private int richLevel_;
    
    private Internal.DoubleList shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
    
    private int vbadge_;
    
    private int vipAnnual_;
    
    private int vipExpLvl_;
    
    private int vipGrade_;
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    private void ensureCoordsIsMutable() {
      if ((this.bitField0_ & 0x1) == 0) {
        this.coords_ = PushProfileOuterClass.PushProfile.mutableCopy(this.coords_);
        this.bitField0_ |= 0x1;
      } 
    }
    
    private void ensureShadowCoordsIsMutable() {
      if ((this.bitField0_ & 0x2) == 0) {
        this.shadowCoords_ = PushProfileOuterClass.PushProfile.mutableCopy(this.shadowCoords_);
        this.bitField0_ |= 0x2;
      } 
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
    }
    
    private void maybeForceBuilderInitialization() {
      PushProfileOuterClass.PushProfile.alwaysUseFieldBuilders;
    }
    
    public Builder addAllCoords(Iterable<? extends Double> param1Iterable) {
      ensureCoordsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.coords_);
      onChanged();
      return this;
    }
    
    public Builder addAllShadowCoords(Iterable<? extends Double> param1Iterable) {
      ensureShadowCoordsIsMutable();
      AbstractMessageLite.Builder.addAll(param1Iterable, (List)this.shadowCoords_);
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
    
    public Builder addShadowCoords(double param1Double) {
      ensureShadowCoordsIsMutable();
      this.shadowCoords_.addDouble(param1Double);
      onChanged();
      return this;
    }
    
    public PushProfileOuterClass.PushProfile build() {
      PushProfileOuterClass.PushProfile pushProfile = buildPartial();
      if (pushProfile.isInitialized())
        return pushProfile; 
      throw newUninitializedMessageException(pushProfile);
    }
    
    public PushProfileOuterClass.PushProfile buildPartial() {
      PushProfileOuterClass.PushProfile pushProfile = new PushProfileOuterClass.PushProfile(this);
      int i = this.bitField0_;
      PushProfileOuterClass.PushProfile.access$802(pushProfile, this.name_);
      PushProfileOuterClass.PushProfile.access$902(pushProfile, this.avatar_);
      if ((this.bitField0_ & 0x1) != 0) {
        this.coords_.makeImmutable();
        this.bitField0_ &= 0xFFFFFFFE;
      } 
      PushProfileOuterClass.PushProfile.access$1002(pushProfile, this.coords_);
      PushProfileOuterClass.PushProfile.access$1102(pushProfile, this.vbadge_);
      PushProfileOuterClass.PushProfile.access$1202(pushProfile, this.online_);
      PushProfileOuterClass.PushProfile.access$1302(pushProfile, this.friend_);
      PushProfileOuterClass.PushProfile.access$1402(pushProfile, this.richLevel_);
      PushProfileOuterClass.PushProfile.access$1502(pushProfile, this.oRichLevel_);
      PushProfileOuterClass.PushProfile.access$1602(pushProfile, this.vipAnnual_);
      PushProfileOuterClass.PushProfile.access$1702(pushProfile, this.vipGrade_);
      PushProfileOuterClass.PushProfile.access$1802(pushProfile, this.vipExpLvl_);
      PushProfileOuterClass.PushProfile.access$1902(pushProfile, this.oVipGrade_);
      PushProfileOuterClass.PushProfile.access$2002(pushProfile, this.isHideVipLook_);
      PushProfileOuterClass.PushProfile.access$2102(pushProfile, this.oIsHideVipLook_);
      PushProfileOuterClass.PushProfile.access$2202(pushProfile, this.avatarPendant_);
      PushProfileOuterClass.PushProfile.access$2302(pushProfile, this.deviceToken_);
      if ((this.bitField0_ & 0x2) != 0) {
        this.shadowCoords_.makeImmutable();
        this.bitField0_ &= 0xFFFFFFFD;
      } 
      PushProfileOuterClass.PushProfile.access$2402(pushProfile, this.shadowCoords_);
      PushProfileOuterClass.PushProfile.access$2502(pushProfile, this.oFaceStatus_);
      PushProfileOuterClass.PushProfile.access$2602(pushProfile, this.isManager_);
      onBuilt();
      return pushProfile;
    }
    
    public Builder clear() {
      super.clear();
      this.name_ = "";
      this.avatar_ = "";
      this.coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      this.vbadge_ = 0;
      this.online_ = 0;
      this.friend_ = 0;
      this.richLevel_ = 0;
      this.oRichLevel_ = 0;
      this.vipAnnual_ = 0;
      this.vipGrade_ = 0;
      this.vipExpLvl_ = 0;
      this.oVipGrade_ = 0;
      this.isHideVipLook_ = 0;
      this.oIsHideVipLook_ = 0;
      this.avatarPendant_ = "";
      this.deviceToken_ = 0;
      this.shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFD;
      this.oFaceStatus_ = 0;
      this.isManager_ = 0;
      return this;
    }
    
    public Builder clearAvatar() {
      this.avatar_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getAvatar();
      onChanged();
      return this;
    }
    
    public Builder clearAvatarPendant() {
      this.avatarPendant_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getAvatarPendant();
      onChanged();
      return this;
    }
    
    public Builder clearCoords() {
      this.coords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFE;
      onChanged();
      return this;
    }
    
    public Builder clearDeviceToken() {
      this.deviceToken_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearFriend() {
      this.friend_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearIsHideVipLook() {
      this.isHideVipLook_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearIsManager() {
      this.isManager_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearName() {
      this.name_ = PushProfileOuterClass.PushProfile.getDefaultInstance().getName();
      onChanged();
      return this;
    }
    
    public Builder clearOFaceStatus() {
      this.oFaceStatus_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOIsHideVipLook() {
      this.oIsHideVipLook_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearORichLevel() {
      this.oRichLevel_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOVipGrade() {
      this.oVipGrade_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearOnline() {
      this.online_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearRichLevel() {
      this.richLevel_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearShadowCoords() {
      this.shadowCoords_ = PushProfileOuterClass.PushProfile.emptyDoubleList();
      this.bitField0_ &= 0xFFFFFFFD;
      onChanged();
      return this;
    }
    
    public Builder clearVbadge() {
      this.vbadge_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearVipAnnual() {
      this.vipAnnual_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearVipExpLvl() {
      this.vipExpLvl_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clearVipGrade() {
      this.vipGrade_ = 0;
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public String getAvatar() {
      Object object = this.avatar_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.avatar_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAvatarBytes() {
      Object object = this.avatar_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.avatar_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getAvatarPendant() {
      Object object = this.avatarPendant_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.avatarPendant_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getAvatarPendantBytes() {
      Object object = this.avatarPendant_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.avatarPendant_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
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
    
    public PushProfileOuterClass.PushProfile getDefaultInstanceForType() {
      return PushProfileOuterClass.PushProfile.getDefaultInstance();
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_descriptor;
    }
    
    public int getDeviceToken() {
      return this.deviceToken_;
    }
    
    public int getFriend() {
      return this.friend_;
    }
    
    public int getIsHideVipLook() {
      return this.isHideVipLook_;
    }
    
    public int getIsManager() {
      return this.isManager_;
    }
    
    public String getName() {
      Object object = this.name_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.name_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getNameBytes() {
      Object object = this.name_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.name_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public int getOFaceStatus() {
      return this.oFaceStatus_;
    }
    
    public int getOIsHideVipLook() {
      return this.oIsHideVipLook_;
    }
    
    public int getORichLevel() {
      return this.oRichLevel_;
    }
    
    public int getOVipGrade() {
      return this.oVipGrade_;
    }
    
    public int getOnline() {
      return this.online_;
    }
    
    public int getRichLevel() {
      return this.richLevel_;
    }
    
    public double getShadowCoords(int param1Int) {
      return this.shadowCoords_.getDouble(param1Int);
    }
    
    public int getShadowCoordsCount() {
      return this.shadowCoords_.size();
    }
    
    public List<Double> getShadowCoordsList() {
      return (List<Double>)(((this.bitField0_ & 0x2) != 0) ? Collections.unmodifiableList((List<? extends Double>)this.shadowCoords_) : this.shadowCoords_);
    }
    
    public int getVbadge() {
      return this.vbadge_;
    }
    
    public int getVipAnnual() {
      return this.vipAnnual_;
    }
    
    public int getVipExpLvl() {
      return this.vipExpLvl_;
    }
    
    public int getVipGrade() {
      return this.vipGrade_;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return PushProfileOuterClass.internal_static_com_blued_im_private_chat_PushProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(PushProfileOuterClass.PushProfile.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(PushProfileOuterClass.PushProfile param1PushProfile) {
      if (param1PushProfile == PushProfileOuterClass.PushProfile.getDefaultInstance())
        return this; 
      if (!param1PushProfile.getName().isEmpty()) {
        this.name_ = param1PushProfile.name_;
        onChanged();
      } 
      if (!param1PushProfile.getAvatar().isEmpty()) {
        this.avatar_ = param1PushProfile.avatar_;
        onChanged();
      } 
      if (!param1PushProfile.coords_.isEmpty()) {
        if (this.coords_.isEmpty()) {
          this.coords_ = param1PushProfile.coords_;
          this.bitField0_ &= 0xFFFFFFFE;
        } else {
          ensureCoordsIsMutable();
          this.coords_.addAll((Collection)param1PushProfile.coords_);
        } 
        onChanged();
      } 
      if (param1PushProfile.getVbadge() != 0)
        setVbadge(param1PushProfile.getVbadge()); 
      if (param1PushProfile.getOnline() != 0)
        setOnline(param1PushProfile.getOnline()); 
      if (param1PushProfile.getFriend() != 0)
        setFriend(param1PushProfile.getFriend()); 
      if (param1PushProfile.getRichLevel() != 0)
        setRichLevel(param1PushProfile.getRichLevel()); 
      if (param1PushProfile.getORichLevel() != 0)
        setORichLevel(param1PushProfile.getORichLevel()); 
      if (param1PushProfile.getVipAnnual() != 0)
        setVipAnnual(param1PushProfile.getVipAnnual()); 
      if (param1PushProfile.getVipGrade() != 0)
        setVipGrade(param1PushProfile.getVipGrade()); 
      if (param1PushProfile.getVipExpLvl() != 0)
        setVipExpLvl(param1PushProfile.getVipExpLvl()); 
      if (param1PushProfile.getOVipGrade() != 0)
        setOVipGrade(param1PushProfile.getOVipGrade()); 
      if (param1PushProfile.getIsHideVipLook() != 0)
        setIsHideVipLook(param1PushProfile.getIsHideVipLook()); 
      if (param1PushProfile.getOIsHideVipLook() != 0)
        setOIsHideVipLook(param1PushProfile.getOIsHideVipLook()); 
      if (!param1PushProfile.getAvatarPendant().isEmpty()) {
        this.avatarPendant_ = param1PushProfile.avatarPendant_;
        onChanged();
      } 
      if (param1PushProfile.getDeviceToken() != 0)
        setDeviceToken(param1PushProfile.getDeviceToken()); 
      if (!param1PushProfile.shadowCoords_.isEmpty()) {
        if (this.shadowCoords_.isEmpty()) {
          this.shadowCoords_ = param1PushProfile.shadowCoords_;
          this.bitField0_ &= 0xFFFFFFFD;
        } else {
          ensureShadowCoordsIsMutable();
          this.shadowCoords_.addAll((Collection)param1PushProfile.shadowCoords_);
        } 
        onChanged();
      } 
      if (param1PushProfile.getOFaceStatus() != 0)
        setOFaceStatus(param1PushProfile.getOFaceStatus()); 
      if (param1PushProfile.getIsManager() != 0)
        setIsManager(param1PushProfile.getIsManager()); 
      mergeUnknownFields(param1PushProfile.unknownFields);
      onChanged();
      return this;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        PushProfileOuterClass.PushProfile pushProfile = (PushProfileOuterClass.PushProfile)PushProfileOuterClass.PushProfile.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        PushProfileOuterClass.PushProfile pushProfile = (PushProfileOuterClass.PushProfile)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((PushProfileOuterClass.PushProfile)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof PushProfileOuterClass.PushProfile)
        return mergeFrom((PushProfileOuterClass.PushProfile)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setAvatar(String param1String) {
      if (param1String != null) {
        this.avatar_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAvatarBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param1ByteString);
        this.avatar_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAvatarPendant(String param1String) {
      if (param1String != null) {
        this.avatarPendant_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setAvatarPendantBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param1ByteString);
        this.avatarPendant_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setCoords(int param1Int, double param1Double) {
      ensureCoordsIsMutable();
      this.coords_.setDouble(param1Int, param1Double);
      onChanged();
      return this;
    }
    
    public Builder setDeviceToken(int param1Int) {
      this.deviceToken_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setFriend(int param1Int) {
      this.friend_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsHideVipLook(int param1Int) {
      this.isHideVipLook_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setIsManager(int param1Int) {
      this.isManager_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setName(String param1String) {
      if (param1String != null) {
        this.name_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        PushProfileOuterClass.PushProfile.checkByteStringIsUtf8(param1ByteString);
        this.name_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setOFaceStatus(int param1Int) {
      this.oFaceStatus_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOIsHideVipLook(int param1Int) {
      this.oIsHideVipLook_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setORichLevel(int param1Int) {
      this.oRichLevel_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOVipGrade(int param1Int) {
      this.oVipGrade_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setOnline(int param1Int) {
      this.online_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setRichLevel(int param1Int) {
      this.richLevel_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setShadowCoords(int param1Int, double param1Double) {
      ensureShadowCoordsIsMutable();
      this.shadowCoords_.setDouble(param1Int, param1Double);
      onChanged();
      return this;
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setVbadge(int param1Int) {
      this.vbadge_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setVipAnnual(int param1Int) {
      this.vipAnnual_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setVipExpLvl(int param1Int) {
      this.vipExpLvl_ = param1Int;
      onChanged();
      return this;
    }
    
    public Builder setVipGrade(int param1Int) {
      this.vipGrade_ = param1Int;
      onChanged();
      return this;
    }
  }
  
  public static interface PushProfileOrBuilder extends MessageOrBuilder {
    String getAvatar();
    
    ByteString getAvatarBytes();
    
    String getAvatarPendant();
    
    ByteString getAvatarPendantBytes();
    
    double getCoords(int param1Int);
    
    int getCoordsCount();
    
    List<Double> getCoordsList();
    
    int getDeviceToken();
    
    int getFriend();
    
    int getIsHideVipLook();
    
    int getIsManager();
    
    String getName();
    
    ByteString getNameBytes();
    
    int getOFaceStatus();
    
    int getOIsHideVipLook();
    
    int getORichLevel();
    
    int getOVipGrade();
    
    int getOnline();
    
    int getRichLevel();
    
    double getShadowCoords(int param1Int);
    
    int getShadowCoordsCount();
    
    List<Double> getShadowCoordsList();
    
    int getVbadge();
    
    int getVipAnnual();
    
    int getVipExpLvl();
    
    int getVipGrade();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\im\private_chat\PushProfileOuterClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */