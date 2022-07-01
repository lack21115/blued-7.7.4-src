package com.google.protobuf;

final class NewInstanceSchemaLite implements NewInstanceSchema {
  public Object newInstance(Object paramObject) {
    return ((GeneratedMessageLite)paramObject).dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\NewInstanceSchemaLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */