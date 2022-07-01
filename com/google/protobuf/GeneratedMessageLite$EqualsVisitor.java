package com.google.protobuf;

final class GeneratedMessageLite$EqualsVisitor implements GeneratedMessageLite$Visitor {
  static final GeneratedMessageLite$EqualsVisitor INSTANCE = new GeneratedMessageLite$EqualsVisitor();
  
  private static GeneratedMessageLite$EqualsVisitor$NotEqualsException NOT_EQUALS = new GeneratedMessageLite$EqualsVisitor$NotEqualsException();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean visitBoolean(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    if (paramBoolean1 == paramBoolean3 && paramBoolean2 == paramBoolean4)
      return paramBoolean2; 
    throw NOT_EQUALS;
  }
  
  public final ByteString visitByteString(boolean paramBoolean1, ByteString paramByteString1, boolean paramBoolean2, ByteString paramByteString2) {
    if (paramBoolean1 == paramBoolean2 && paramByteString1.equals(paramByteString2))
      return paramByteString1; 
    throw NOT_EQUALS;
  }
  
  public final String visitString(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2) {
    if (paramBoolean1 == paramBoolean2 && paramString1.equals(paramString2))
      return paramString1; 
    throw NOT_EQUALS;
  }
  
  public final UnknownFieldSetLite visitUnknownFields(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    if (paramUnknownFieldSetLite1.equals(paramUnknownFieldSetLite2))
      return paramUnknownFieldSetLite1; 
    throw NOT_EQUALS;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite$EqualsVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */