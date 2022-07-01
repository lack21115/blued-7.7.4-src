package com.google.protobuf;

public abstract class GeneratedMessageLite$Builder extends AbstractMessageLite$Builder {
  private final GeneratedMessageLite defaultInstance;
  
  public GeneratedMessageLite instance;
  
  private boolean isBuilt;
  
  public GeneratedMessageLite$Builder(GeneratedMessageLite paramGeneratedMessageLite) {
    this.defaultInstance = paramGeneratedMessageLite;
    this.instance = (GeneratedMessageLite)paramGeneratedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
    this.isBuilt = false;
  }
  
  private GeneratedMessageLite$Builder clone() {
    GeneratedMessageLite$Builder generatedMessageLite$Builder = (GeneratedMessageLite$Builder)this.defaultInstance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_BUILDER, null, null);
    generatedMessageLite$Builder.mergeFrom(buildPartial());
    return generatedMessageLite$Builder;
  }
  
  public final GeneratedMessageLite buildPartial() {
    if (this.isBuilt)
      return this.instance; 
    this.instance.makeImmutable();
    this.isBuilt = true;
    return this.instance;
  }
  
  public final void copyOnWrite() {
    if (this.isBuilt) {
      GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
      generatedMessageLite.visit(GeneratedMessageLite$MergeFromVisitor.INSTANCE, this.instance);
      this.instance = generatedMessageLite;
      this.isBuilt = false;
    } 
  }
  
  public final boolean isInitialized() {
    return (this.instance.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, Boolean.valueOf(false), null) != null);
  }
  
  public final GeneratedMessageLite$Builder mergeFrom(GeneratedMessageLite paramGeneratedMessageLite) {
    copyOnWrite();
    this.instance.visit(GeneratedMessageLite$MergeFromVisitor.INSTANCE, paramGeneratedMessageLite);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */