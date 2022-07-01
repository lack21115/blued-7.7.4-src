package com.google.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class GeneratedMessageLite extends AbstractMessageLite {
  public int memoizedSerializedSize = -1;
  
  public UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();
  
  private GeneratedMessageLite getDefaultInstanceForType() {
    return (GeneratedMessageLite)dynamicMethod(GeneratedMessageLite$MethodToInvoke.GET_DEFAULT_INSTANCE, null, null);
  }
  
  static Object invokeOrDie(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      Throwable throwable = invocationTargetException.getCause();
      if (!(throwable instanceof RuntimeException)) {
        if (throwable instanceof Error)
          throw (Error)throwable; 
        throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
      } 
      throw (RuntimeException)throwable;
    } 
  }
  
  public static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite paramGeneratedMessageLite, CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) {
    paramGeneratedMessageLite = (GeneratedMessageLite)paramGeneratedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_MUTABLE_INSTANCE, null, null);
    try {
      paramGeneratedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MERGE_FROM_STREAM, paramCodedInputStream, paramExtensionRegistryLite);
      paramGeneratedMessageLite.makeImmutable();
      return paramGeneratedMessageLite;
    } catch (RuntimeException runtimeException) {
      if (runtimeException.getCause() instanceof InvalidProtocolBufferException)
        throw (InvalidProtocolBufferException)runtimeException.getCause(); 
      throw runtimeException;
    } 
  }
  
  public abstract Object dynamicMethod(GeneratedMessageLite$MethodToInvoke paramGeneratedMessageLite$MethodToInvoke, Object paramObject1, Object paramObject2);
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!getDefaultInstanceForType().getClass().isInstance(paramObject))
      return false; 
    try {
      visit(GeneratedMessageLite$EqualsVisitor.INSTANCE, (GeneratedMessageLite)paramObject);
      return true;
    } catch (GeneratedMessageLite$EqualsVisitor$NotEqualsException generatedMessageLite$EqualsVisitor$NotEqualsException) {
      return false;
    } 
  }
  
  public final Parser getParserForType() {
    return (Parser)dynamicMethod(GeneratedMessageLite$MethodToInvoke.GET_PARSER, null, null);
  }
  
  public int hashCode() {
    if (this.memoizedHashCode == 0) {
      GeneratedMessageLite$HashCodeVisitor generatedMessageLite$HashCodeVisitor = new GeneratedMessageLite$HashCodeVisitor();
      visit(generatedMessageLite$HashCodeVisitor, this);
      this.memoizedHashCode = generatedMessageLite$HashCodeVisitor.hashCode;
    } 
    return this.memoizedHashCode;
  }
  
  public final boolean isInitialized() {
    return (dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, Boolean.TRUE, null) != null);
  }
  
  public final void makeImmutable() {
    dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, null, null);
    this.unknownFields.isMutable = false;
  }
  
  public String toString() {
    String str = super.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("# ");
    stringBuilder.append(str);
    MessageLiteToString.reflectivePrintWithIndent(this, stringBuilder, 0);
    return stringBuilder.toString();
  }
  
  final void visit(GeneratedMessageLite$Visitor paramGeneratedMessageLite$Visitor, GeneratedMessageLite paramGeneratedMessageLite) {
    dynamicMethod(GeneratedMessageLite$MethodToInvoke.VISIT, paramGeneratedMessageLite$Visitor, paramGeneratedMessageLite);
    this.unknownFields = paramGeneratedMessageLite$Visitor.visitUnknownFields(this.unknownFields, paramGeneratedMessageLite.unknownFields);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\GeneratedMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */