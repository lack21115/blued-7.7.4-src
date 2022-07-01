package com.google.protobuf;

final class ExtensionRegistryFactory {
  static final Class<?> EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
  
  static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";
  
  public static ExtensionRegistryLite create() {
    ExtensionRegistryLite extensionRegistryLite = invokeSubclassFactory("newInstance");
    return (extensionRegistryLite != null) ? extensionRegistryLite : new ExtensionRegistryLite();
  }
  
  public static ExtensionRegistryLite createEmpty() {
    ExtensionRegistryLite extensionRegistryLite = invokeSubclassFactory("getEmptyRegistry");
    return (extensionRegistryLite != null) ? extensionRegistryLite : ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
  }
  
  private static final ExtensionRegistryLite invokeSubclassFactory(String paramString) {
    Class<?> clazz = EXTENSION_REGISTRY_CLASS;
    if (clazz == null)
      return null; 
    try {
      return (ExtensionRegistryLite)clazz.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  static boolean isFullRegistry(ExtensionRegistryLite paramExtensionRegistryLite) {
    Class<?> clazz = EXTENSION_REGISTRY_CLASS;
    return (clazz != null && clazz.isAssignableFrom(paramExtensionRegistryLite.getClass()));
  }
  
  static Class<?> reflectExtensionRegistry() {
    try {
      return Class.forName("com.google.protobuf.ExtensionRegistry");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionRegistryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */