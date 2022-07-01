package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;

public final class ExtensionRegistryLite {
  static final ExtensionRegistryLite EMPTY_REGISTRY_LITE;
  
  private static volatile boolean eagerlyParseMessageSets = false;
  
  static {
    resolveExtensionClass();
    EMPTY_REGISTRY_LITE = new ExtensionRegistryLite((byte)0);
    throw new VerifyError("bad dex opcode");
  }
  
  ExtensionRegistryLite() {
    new HashMap<Object, Object>();
  }
  
  private ExtensionRegistryLite(byte paramByte) {
    Collections.emptyMap();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry() {
    return ExtensionRegistryFactory.createEmpty();
  }
  
  private static Class resolveExtensionClass() {
    try {
      return Class.forName("com.google.protobuf.Extension");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ExtensionRegistryLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */