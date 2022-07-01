package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite {
  static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
  
  static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
  
  private static boolean doFullRuntimeInheritanceCheck = true;
  
  private static volatile boolean eagerlyParseMessageSets = false;
  
  private static volatile ExtensionRegistryLite emptyRegistry;
  
  private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
  
  ExtensionRegistryLite() {
    this.extensionsByNumber = new HashMap<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>>();
  }
  
  ExtensionRegistryLite(ExtensionRegistryLite paramExtensionRegistryLite) {
    if (paramExtensionRegistryLite == EMPTY_REGISTRY_LITE) {
      this.extensionsByNumber = Collections.emptyMap();
      return;
    } 
    this.extensionsByNumber = Collections.unmodifiableMap(paramExtensionRegistryLite.extensionsByNumber);
  }
  
  ExtensionRegistryLite(boolean paramBoolean) {
    this.extensionsByNumber = Collections.emptyMap();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry() {
    // Byte code:
    //   0: getstatic com/google/protobuf/ExtensionRegistryLite.emptyRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull -> 53
    //   8: ldc com/google/protobuf/ExtensionRegistryLite
    //   10: monitorenter
    //   11: getstatic com/google/protobuf/ExtensionRegistryLite.emptyRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   14: astore_1
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: ifnonnull -> 42
    //   21: getstatic com/google/protobuf/ExtensionRegistryLite.doFullRuntimeInheritanceCheck : Z
    //   24: ifeq -> 34
    //   27: invokestatic createEmpty : ()Lcom/google/protobuf/ExtensionRegistryLite;
    //   30: astore_0
    //   31: goto -> 38
    //   34: getstatic com/google/protobuf/ExtensionRegistryLite.EMPTY_REGISTRY_LITE : Lcom/google/protobuf/ExtensionRegistryLite;
    //   37: astore_0
    //   38: aload_0
    //   39: putstatic com/google/protobuf/ExtensionRegistryLite.emptyRegistry : Lcom/google/protobuf/ExtensionRegistryLite;
    //   42: ldc com/google/protobuf/ExtensionRegistryLite
    //   44: monitorexit
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: ldc com/google/protobuf/ExtensionRegistryLite
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: aload_0
    //   54: areturn
    // Exception table:
    //   from	to	target	type
    //   11	15	47	finally
    //   21	31	47	finally
    //   34	38	47	finally
    //   38	42	47	finally
    //   42	45	47	finally
    //   48	51	47	finally
  }
  
  public static boolean isEagerlyParseMessageSets() {
    return eagerlyParseMessageSets;
  }
  
  public static ExtensionRegistryLite newInstance() {
    return doFullRuntimeInheritanceCheck ? ExtensionRegistryFactory.create() : new ExtensionRegistryLite();
  }
  
  public static void setEagerlyParseMessageSets(boolean paramBoolean) {
    eagerlyParseMessageSets = paramBoolean;
  }
  
  public final void add(ExtensionLite<?, ?> paramExtensionLite) {
    if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(paramExtensionLite.getClass()))
      add((GeneratedMessageLite.GeneratedExtension<?, ?>)paramExtensionLite); 
    if (doFullRuntimeInheritanceCheck && ExtensionRegistryFactory.isFullRegistry(this))
      try {
        getClass().getMethod("add", new Class[] { ExtensionClassHolder.INSTANCE }).invoke(this, new Object[] { paramExtensionLite });
        return;
      } catch (Exception exception) {
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[] { paramExtensionLite }), exception);
      }  
  }
  
  public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> paramGeneratedExtension) {
    this.extensionsByNumber.put(new ObjectIntPair(paramGeneratedExtension.getContainingTypeDefaultInstance(), paramGeneratedExtension.getNumber()), paramGeneratedExtension);
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType paramContainingType, int paramInt) {
    return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>)this.extensionsByNumber.get(new ObjectIntPair(paramContainingType, paramInt));
  }
  
  public ExtensionRegistryLite getUnmodifiable() {
    return new ExtensionRegistryLite(this);
  }
  
  static class ExtensionClassHolder {
    static final Class<?> INSTANCE = resolveExtensionClass();
    
    static Class<?> resolveExtensionClass() {
      try {
        return Class.forName("com.google.protobuf.Extension");
      } catch (ClassNotFoundException classNotFoundException) {
        return null;
      } 
    }
  }
  
  static final class ObjectIntPair {
    private final int number;
    
    private final Object object;
    
    ObjectIntPair(Object param1Object, int param1Int) {
      this.object = param1Object;
      this.number = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ObjectIntPair;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (this.object == ((ObjectIntPair)param1Object).object) {
        bool = bool1;
        if (this.number == ((ObjectIntPair)param1Object).number)
          bool = true; 
      } 
      return bool;
    }
    
    public int hashCode() {
      return System.identityHashCode(this.object) * 65535 + this.number;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionRegistryLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */