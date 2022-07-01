package com.google.protobuf;

final class GeneratedMessageLite$HashCodeVisitor implements GeneratedMessageLite$Visitor {
  int hashCode = 0;
  
  public final boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    this.hashCode = this.hashCode * 53 + Internal.hashBoolean(paramBoolean2);
    return paramBoolean2;
  }
  
  public final ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2) {
    this.hashCode = this.hashCode * 53 + paramByteString1.hashCode();
    return paramByteString1;
  }
  
  public final String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2) {
    this.hashCode = this.hashCode * 53 + paramString1.hashCode();
    return paramString1;
  }
  
  public final UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    this.hashCode = this.hashCode * 53 + paramUnknownFieldSetLite1.hashCode();
    return paramUnknownFieldSetLite1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite$HashCodeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */