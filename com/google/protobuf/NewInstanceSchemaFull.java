package com.google.protobuf;

final class NewInstanceSchemaFull implements NewInstanceSchema {
  public Object newInstance(Object paramObject) {
    return ((GeneratedMessageV3)paramObject).newInstance(GeneratedMessageV3.UnusedPrivateParameter.INSTANCE);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\NewInstanceSchemaFull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */