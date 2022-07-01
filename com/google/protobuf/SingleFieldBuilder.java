package com.google.protobuf;

public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
  private BType builder;
  
  private boolean isClean;
  
  private MType message;
  
  private GeneratedMessage.BuilderParent parent;
  
  public SingleFieldBuilder(MType paramMType, GeneratedMessage.BuilderParent paramBuilderParent, boolean paramBoolean) {
    this.message = (MType)Internal.<GeneratedMessage>checkNotNull((GeneratedMessage)paramMType);
    this.parent = paramBuilderParent;
    this.isClean = paramBoolean;
  }
  
  private void onChanged() {
    if (this.builder != null)
      this.message = null; 
    if (this.isClean) {
      GeneratedMessage.BuilderParent builderParent = this.parent;
      if (builderParent != null) {
        builderParent.markDirty();
        this.isClean = false;
      } 
    } 
  }
  
  public MType build() {
    this.isClean = true;
    return getMessage();
  }
  
  public SingleFieldBuilder<MType, BType, IType> clear() {
    Message message;
    MType mType = this.message;
    if (mType != null) {
      message = mType.getDefaultInstanceForType();
    } else {
      message = this.builder.getDefaultInstanceForType();
    } 
    this.message = (MType)message;
    BType bType = this.builder;
    if (bType != null) {
      bType.dispose();
      this.builder = null;
    } 
    onChanged();
    return this;
  }
  
  public void dispose() {
    this.parent = null;
  }
  
  public BType getBuilder() {
    if (this.builder == null) {
      this.builder = (BType)this.message.newBuilderForType(this);
      this.builder.mergeFrom((Message)this.message);
      this.builder.markClean();
    } 
    return this.builder;
  }
  
  public MType getMessage() {
    if (this.message == null)
      this.message = (MType)this.builder.buildPartial(); 
    return this.message;
  }
  
  public IType getMessageOrBuilder() {
    BType bType = this.builder;
    return (IType)((bType != null) ? (Object)bType : (Object)this.message);
  }
  
  public void markDirty() {
    onChanged();
  }
  
  public SingleFieldBuilder<MType, BType, IType> mergeFrom(MType paramMType) {
    if (this.builder == null) {
      MType mType = this.message;
      if (mType == mType.getDefaultInstanceForType()) {
        this.message = paramMType;
        onChanged();
        return this;
      } 
    } 
    getBuilder().mergeFrom((Message)paramMType);
    onChanged();
    return this;
  }
  
  public SingleFieldBuilder<MType, BType, IType> setMessage(MType paramMType) {
    this.message = (MType)Internal.<GeneratedMessage>checkNotNull((GeneratedMessage)paramMType);
    BType bType = this.builder;
    if (bType != null) {
      bType.dispose();
      this.builder = null;
    } 
    onChanged();
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\SingleFieldBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */