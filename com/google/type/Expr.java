package com.google.type;

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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Expr extends GeneratedMessageV3 implements ExprOrBuilder {
  private static final Expr DEFAULT_INSTANCE = new Expr();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int EXPRESSION_FIELD_NUMBER = 1;
  
  public static final int LOCATION_FIELD_NUMBER = 4;
  
  private static final Parser<Expr> PARSER = (Parser<Expr>)new AbstractParser<Expr>() {
      public Expr a(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
        return new Expr(param1CodedInputStream, param1ExtensionRegistryLite);
      }
    };
  
  public static final int TITLE_FIELD_NUMBER = 2;
  
  private static final long serialVersionUID = 0L;
  
  private volatile Object description_;
  
  private volatile Object expression_;
  
  private volatile Object location_;
  
  private byte memoizedIsInitialized = -1;
  
  private volatile Object title_;
  
  private Expr() {
    this.expression_ = "";
    this.title_ = "";
    this.description_ = "";
    this.location_ = "";
  }
  
  private Expr(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    this();
    if (paramExtensionRegistryLite != null) {
      UnknownFieldSet.Builder builder = UnknownFieldSet.newBuilder();
      for (boolean bool = false; !bool; bool = true) {
        try {
          int i = paramCodedInputStream.readTag();
          if (i != 0) {
            if (i != 10) {
              if (i != 18) {
                if (i != 26) {
                  if (i != 34) {
                    if (!parseUnknownField(paramCodedInputStream, builder, paramExtensionRegistryLite, i))
                      continue; 
                    continue;
                  } 
                  this.location_ = paramCodedInputStream.readStringRequireUtf8();
                  continue;
                } 
                this.description_ = paramCodedInputStream.readStringRequireUtf8();
                continue;
              } 
              this.title_ = paramCodedInputStream.readStringRequireUtf8();
              continue;
            } 
            this.expression_ = paramCodedInputStream.readStringRequireUtf8();
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
        throw paramCodedInputStream;
      } 
      this.unknownFields = builder.build();
      makeExtensionsImmutable();
      return;
    } 
    throw new NullPointerException();
  }
  
  private Expr(GeneratedMessageV3.Builder<?> paramBuilder) {
    super(paramBuilder);
  }
  
  public static Expr getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static final Descriptors.Descriptor getDescriptor() {
    return ExprProto.a;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Expr paramExpr) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramExpr);
  }
  
  public static Expr parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Expr)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream);
  }
  
  public static Expr parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Expr)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Expr parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramByteString);
  }
  
  public static Expr parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramByteString, paramExtensionRegistryLite);
  }
  
  public static Expr parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Expr)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream);
  }
  
  public static Expr parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Expr)GeneratedMessageV3.parseWithIOException(PARSER, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Expr parseFrom(InputStream paramInputStream) throws IOException {
    return (Expr)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream);
  }
  
  public static Expr parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Expr)GeneratedMessageV3.parseWithIOException(PARSER, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Expr parseFrom(ByteBuffer paramByteBuffer) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramByteBuffer);
  }
  
  public static Expr parseFrom(ByteBuffer paramByteBuffer, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramByteBuffer, paramExtensionRegistryLite);
  }
  
  public static Expr parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramArrayOfbyte);
  }
  
  public static Expr parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Expr)PARSER.parseFrom(paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Expr> parser() {
    return PARSER;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Expr))
      return super.equals(paramObject); 
    paramObject = paramObject;
    return !getExpression().equals(paramObject.getExpression()) ? false : (!getTitle().equals(paramObject.getTitle()) ? false : (!getDescription().equals(paramObject.getDescription()) ? false : (!getLocation().equals(paramObject.getLocation()) ? false : (!!this.unknownFields.equals(((Expr)paramObject).unknownFields)))));
  }
  
  public Expr getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
  
  public String getDescription() {
    Object object = this.description_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.description_ = object;
    return (String)object;
  }
  
  public ByteString getDescriptionBytes() {
    Object object = this.description_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.description_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getExpression() {
    Object object = this.expression_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.expression_ = object;
    return (String)object;
  }
  
  public ByteString getExpressionBytes() {
    Object object = this.expression_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.expression_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public String getLocation() {
    Object object = this.location_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.location_ = object;
    return (String)object;
  }
  
  public ByteString getLocationBytes() {
    Object object = this.location_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.location_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public Parser<Expr> getParserForType() {
    return PARSER;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!getExpressionBytes().isEmpty())
      j = 0 + GeneratedMessageV3.computeStringSize(1, this.expression_); 
    i = j;
    if (!getTitleBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(2, this.title_); 
    j = i;
    if (!getDescriptionBytes().isEmpty())
      j = i + GeneratedMessageV3.computeStringSize(3, this.description_); 
    i = j;
    if (!getLocationBytes().isEmpty())
      i = j + GeneratedMessageV3.computeStringSize(4, this.location_); 
    i += this.unknownFields.getSerializedSize();
    this.memoizedSize = i;
    return i;
  }
  
  public String getTitle() {
    Object object = this.title_;
    if (object instanceof String)
      return (String)object; 
    object = ((ByteString)object).toStringUtf8();
    this.title_ = object;
    return (String)object;
  }
  
  public ByteString getTitleBytes() {
    Object object = this.title_;
    if (object instanceof String) {
      object = ByteString.copyFromUtf8((String)object);
      this.title_ = object;
      return (ByteString)object;
    } 
    return (ByteString)object;
  }
  
  public final UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }
  
  public int hashCode() {
    if (this.memoizedHashCode != 0)
      return this.memoizedHashCode; 
    int i = (((((((((779 + getDescriptor().hashCode()) * 37 + 1) * 53 + getExpression().hashCode()) * 37 + 2) * 53 + getTitle().hashCode()) * 37 + 3) * 53 + getDescription().hashCode()) * 37 + 4) * 53 + getLocation().hashCode()) * 29 + this.unknownFields.hashCode();
    this.memoizedHashCode = i;
    return i;
  }
  
  public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return ExprProto.b.ensureFieldAccessorsInitialized(Expr.class, Builder.class);
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
    if (!getExpressionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 1, this.expression_); 
    if (!getTitleBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 2, this.title_); 
    if (!getDescriptionBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 3, this.description_); 
    if (!getLocationBytes().isEmpty())
      GeneratedMessageV3.writeString(paramCodedOutputStream, 4, this.location_); 
    this.unknownFields.writeTo(paramCodedOutputStream);
  }
  
  public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExprOrBuilder {
    private Object description_ = "";
    
    private Object expression_ = "";
    
    private Object location_ = "";
    
    private Object title_ = "";
    
    private Builder() {
      maybeForceBuilderInitialization();
    }
    
    private Builder(GeneratedMessageV3.BuilderParent param1BuilderParent) {
      super(param1BuilderParent);
      maybeForceBuilderInitialization();
    }
    
    public static final Descriptors.Descriptor getDescriptor() {
      return ExprProto.a;
    }
    
    private void maybeForceBuilderInitialization() {
      Expr.alwaysUseFieldBuilders;
    }
    
    public Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.addRepeatedField(param1FieldDescriptor, param1Object);
    }
    
    public Expr build() {
      Expr expr = buildPartial();
      if (expr.isInitialized())
        return expr; 
      throw newUninitializedMessageException(expr);
    }
    
    public Expr buildPartial() {
      Expr expr = new Expr(this);
      Expr.access$402(expr, this.expression_);
      Expr.access$502(expr, this.title_);
      Expr.access$602(expr, this.description_);
      Expr.access$702(expr, this.location_);
      onBuilt();
      return expr;
    }
    
    public Builder clear() {
      super.clear();
      this.expression_ = "";
      this.title_ = "";
      this.description_ = "";
      this.location_ = "";
      return this;
    }
    
    public Builder clearDescription() {
      this.description_ = Expr.getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    
    public Builder clearExpression() {
      this.expression_ = Expr.getDefaultInstance().getExpression();
      onChanged();
      return this;
    }
    
    public Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return (Builder)super.clearField(param1FieldDescriptor);
    }
    
    public Builder clearLocation() {
      this.location_ = Expr.getDefaultInstance().getLocation();
      onChanged();
      return this;
    }
    
    public Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return (Builder)super.clearOneof(param1OneofDescriptor);
    }
    
    public Builder clearTitle() {
      this.title_ = Expr.getDefaultInstance().getTitle();
      onChanged();
      return this;
    }
    
    public Builder clone() {
      return (Builder)super.clone();
    }
    
    public Expr getDefaultInstanceForType() {
      return Expr.getDefaultInstance();
    }
    
    public String getDescription() {
      Object object = this.description_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.description_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getDescriptionBytes() {
      Object object = this.description_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.description_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return ExprProto.a;
    }
    
    public String getExpression() {
      Object object = this.expression_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.expression_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getExpressionBytes() {
      Object object = this.expression_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.expression_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getLocation() {
      Object object = this.location_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.location_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getLocationBytes() {
      Object object = this.location_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.location_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public String getTitle() {
      Object object = this.title_;
      if (!(object instanceof String)) {
        object = ((ByteString)object).toStringUtf8();
        this.title_ = object;
        return (String)object;
      } 
      return (String)object;
    }
    
    public ByteString getTitleBytes() {
      Object object = this.title_;
      if (object instanceof String) {
        object = ByteString.copyFromUtf8((String)object);
        this.title_ = object;
        return (ByteString)object;
      } 
      return (ByteString)object;
    }
    
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return ExprProto.b.ensureFieldAccessorsInitialized(Expr.class, Builder.class);
    }
    
    public final boolean isInitialized() {
      return true;
    }
    
    public Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = null;
      try {
        Expr expr = (Expr)Expr.PARSER.parsePartialFrom(param1CodedInputStream, param1ExtensionRegistryLite);
        return this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        Expr expr = (Expr)invalidProtocolBufferException.getUnfinishedMessage();
      } finally {
        param1ExtensionRegistryLite = null;
      } 
      if (param1CodedInputStream != null)
        mergeFrom((Expr)param1CodedInputStream); 
      throw param1ExtensionRegistryLite;
    }
    
    public Builder mergeFrom(Message param1Message) {
      if (param1Message instanceof Expr)
        return mergeFrom((Expr)param1Message); 
      super.mergeFrom(param1Message);
      return this;
    }
    
    public Builder mergeFrom(Expr param1Expr) {
      if (param1Expr == Expr.getDefaultInstance())
        return this; 
      if (!param1Expr.getExpression().isEmpty()) {
        this.expression_ = param1Expr.expression_;
        onChanged();
      } 
      if (!param1Expr.getTitle().isEmpty()) {
        this.title_ = param1Expr.title_;
        onChanged();
      } 
      if (!param1Expr.getDescription().isEmpty()) {
        this.description_ = param1Expr.description_;
        onChanged();
      } 
      if (!param1Expr.getLocation().isEmpty()) {
        this.location_ = param1Expr.location_;
        onChanged();
      } 
      mergeUnknownFields(param1Expr.unknownFields);
      onChanged();
      return this;
    }
    
    public final Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.mergeUnknownFields(param1UnknownFieldSet);
    }
    
    public Builder setDescription(String param1String) {
      if (param1String != null) {
        this.description_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Expr.checkByteStringIsUtf8(param1ByteString);
        this.description_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExpression(String param1String) {
      if (param1String != null) {
        this.expression_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setExpressionBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Expr.checkByteStringIsUtf8(param1ByteString);
        this.expression_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      return (Builder)super.setField(param1FieldDescriptor, param1Object);
    }
    
    public Builder setLocation(String param1String) {
      if (param1String != null) {
        this.location_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setLocationBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Expr.checkByteStringIsUtf8(param1ByteString);
        this.location_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      return (Builder)super.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
    }
    
    public Builder setTitle(String param1String) {
      if (param1String != null) {
        this.title_ = param1String;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setTitleBytes(ByteString param1ByteString) {
      if (param1ByteString != null) {
        Expr.checkByteStringIsUtf8(param1ByteString);
        this.title_ = param1ByteString;
        onChanged();
        return this;
      } 
      throw new NullPointerException();
    }
    
    public final Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet) {
      return (Builder)super.setUnknownFields(param1UnknownFieldSet);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\Expr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */