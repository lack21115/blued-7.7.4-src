package com.google.protobuf;

public final class GeneratedMessageLite$MergeFromVisitor implements GeneratedMessageLite$Visitor {
  public static final GeneratedMessageLite$MergeFromVisitor INSTANCE = new GeneratedMessageLite$MergeFromVisitor();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    return paramBoolean3 ? paramBoolean4 : paramBoolean2;
  }
  
  public final ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2) {
    return paramBoolean2 ? paramByteString2 : paramByteString1;
  }
  
  public final String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2) {
    return paramBoolean2 ? paramString2 : paramString1;
  }
  
  public final UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    return (paramUnknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance()) ? paramUnknownFieldSetLite1 : UnknownFieldSetLite.mutableCopyOf(paramUnknownFieldSetLite1, paramUnknownFieldSetLite2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite$MergeFromVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */