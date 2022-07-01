package com.google.protobuf;

final class ExtensionRegistryFactory {
  private static Class EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static ExtensionRegistryLite createEmpty() {
    if (EXTENSION_REGISTRY_CLASS != null)
      try {
        return (ExtensionRegistryLite)EXTENSION_REGISTRY_CLASS.getMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
      } catch (Exception exception) {} 
    return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
  }
  
  private static Class reflectExtensionRegistry() {
    try {
      return Class.forName("com.google.protobuf.ExtensionRegistry");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ExtensionRegistryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */