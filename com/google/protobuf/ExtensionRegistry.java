package com.google.protobuf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry extends ExtensionRegistryLite {
  static final ExtensionRegistry EMPTY_REGISTRY = new ExtensionRegistry(true);
  
  private final Map<String, ExtensionInfo> immutableExtensionsByName = new HashMap<String, ExtensionInfo>();
  
  private final Map<DescriptorIntPair, ExtensionInfo> immutableExtensionsByNumber = new HashMap<DescriptorIntPair, ExtensionInfo>();
  
  private final Map<String, ExtensionInfo> mutableExtensionsByName = new HashMap<String, ExtensionInfo>();
  
  private final Map<DescriptorIntPair, ExtensionInfo> mutableExtensionsByNumber = new HashMap<DescriptorIntPair, ExtensionInfo>();
  
  private ExtensionRegistry() {}
  
  private ExtensionRegistry(ExtensionRegistry paramExtensionRegistry) {
    super(paramExtensionRegistry);
  }
  
  ExtensionRegistry(boolean paramBoolean) {
    super(EMPTY_REGISTRY_LITE);
  }
  
  private void add(ExtensionInfo paramExtensionInfo, Extension.ExtensionType paramExtensionType) {
    if (paramExtensionInfo.descriptor.isExtension()) {
      Map<String, ExtensionInfo> map;
      Map<DescriptorIntPair, ExtensionInfo> map1;
      int i = null.$SwitchMap$com$google$protobuf$Extension$ExtensionType[paramExtensionType.ordinal()];
      if (i != 1) {
        if (i != 2)
          return; 
        map = this.mutableExtensionsByName;
        map1 = this.mutableExtensionsByNumber;
      } else {
        map = this.immutableExtensionsByName;
        map1 = this.immutableExtensionsByNumber;
      } 
      map.put(paramExtensionInfo.descriptor.getFullName(), paramExtensionInfo);
      map1.put(new DescriptorIntPair(paramExtensionInfo.descriptor.getContainingType(), paramExtensionInfo.descriptor.getNumber()), paramExtensionInfo);
      Descriptors.FieldDescriptor fieldDescriptor = paramExtensionInfo.descriptor;
      if (fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.isOptional() && fieldDescriptor.getExtensionScope() == fieldDescriptor.getMessageType())
        map.put(fieldDescriptor.getMessageType().getFullName(), paramExtensionInfo); 
      return;
    } 
    throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
  }
  
  public static ExtensionRegistry getEmptyRegistry() {
    return EMPTY_REGISTRY;
  }
  
  static ExtensionInfo newExtensionInfo(Extension<?, ?> paramExtension) {
    if (paramExtension.getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      if (paramExtension.getMessageDefaultInstance() != null)
        return new ExtensionInfo(paramExtension.getDescriptor(), paramExtension.getMessageDefaultInstance()); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Registered message-type extension had null default instance: ");
      stringBuilder.append(paramExtension.getDescriptor().getFullName());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    return new ExtensionInfo(paramExtension.getDescriptor(), null);
  }
  
  public static ExtensionRegistry newInstance() {
    return new ExtensionRegistry();
  }
  
  public void add(Descriptors.FieldDescriptor paramFieldDescriptor) {
    if (paramFieldDescriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      ExtensionInfo extensionInfo = new ExtensionInfo(paramFieldDescriptor, null);
      add(extensionInfo, Extension.ExtensionType.IMMUTABLE);
      add(extensionInfo, Extension.ExtensionType.MUTABLE);
      return;
    } 
    throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
  }
  
  public void add(Descriptors.FieldDescriptor paramFieldDescriptor, Message paramMessage) {
    if (paramFieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
      add(new ExtensionInfo(paramFieldDescriptor, paramMessage), Extension.ExtensionType.IMMUTABLE);
      return;
    } 
    throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
  }
  
  public void add(Extension<?, ?> paramExtension) {
    if (paramExtension.getExtensionType() != Extension.ExtensionType.IMMUTABLE && paramExtension.getExtensionType() != Extension.ExtensionType.MUTABLE)
      return; 
    add(newExtensionInfo(paramExtension), paramExtension.getExtensionType());
  }
  
  public void add(GeneratedMessage.GeneratedExtension<?, ?> paramGeneratedExtension) {
    add(paramGeneratedExtension);
  }
  
  @Deprecated
  public ExtensionInfo findExtensionByName(String paramString) {
    return findImmutableExtensionByName(paramString);
  }
  
  @Deprecated
  public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor paramDescriptor, int paramInt) {
    return findImmutableExtensionByNumber(paramDescriptor, paramInt);
  }
  
  public ExtensionInfo findImmutableExtensionByName(String paramString) {
    return this.immutableExtensionsByName.get(paramString);
  }
  
  public ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor paramDescriptor, int paramInt) {
    return this.immutableExtensionsByNumber.get(new DescriptorIntPair(paramDescriptor, paramInt));
  }
  
  public ExtensionInfo findMutableExtensionByName(String paramString) {
    return this.mutableExtensionsByName.get(paramString);
  }
  
  public ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor paramDescriptor, int paramInt) {
    return this.mutableExtensionsByNumber.get(new DescriptorIntPair(paramDescriptor, paramInt));
  }
  
  public Set<ExtensionInfo> getAllImmutableExtensionsByExtendedType(String paramString) {
    HashSet<ExtensionInfo> hashSet = new HashSet();
    for (DescriptorIntPair descriptorIntPair : this.immutableExtensionsByNumber.keySet()) {
      if (descriptorIntPair.descriptor.getFullName().equals(paramString))
        hashSet.add(this.immutableExtensionsByNumber.get(descriptorIntPair)); 
    } 
    return hashSet;
  }
  
  public Set<ExtensionInfo> getAllMutableExtensionsByExtendedType(String paramString) {
    HashSet<ExtensionInfo> hashSet = new HashSet();
    for (DescriptorIntPair descriptorIntPair : this.mutableExtensionsByNumber.keySet()) {
      if (descriptorIntPair.descriptor.getFullName().equals(paramString))
        hashSet.add(this.mutableExtensionsByNumber.get(descriptorIntPair)); 
    } 
    return hashSet;
  }
  
  public ExtensionRegistry getUnmodifiable() {
    return new ExtensionRegistry(this);
  }
  
  static final class DescriptorIntPair {
    private final Descriptors.Descriptor descriptor;
    
    private final int number;
    
    DescriptorIntPair(Descriptors.Descriptor param1Descriptor, int param1Int) {
      this.descriptor = param1Descriptor;
      this.number = param1Int;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof DescriptorIntPair;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (this.descriptor == ((DescriptorIntPair)param1Object).descriptor) {
        bool = bool1;
        if (this.number == ((DescriptorIntPair)param1Object).number)
          bool = true; 
      } 
      return bool;
    }
    
    public int hashCode() {
      return this.descriptor.hashCode() * 65535 + this.number;
    }
  }
  
  public static final class ExtensionInfo {
    public final Message defaultInstance;
    
    public final Descriptors.FieldDescriptor descriptor;
    
    private ExtensionInfo(Descriptors.FieldDescriptor param1FieldDescriptor) {
      this.descriptor = param1FieldDescriptor;
      this.defaultInstance = null;
    }
    
    private ExtensionInfo(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) {
      this.descriptor = param1FieldDescriptor;
      this.defaultInstance = param1Message;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */