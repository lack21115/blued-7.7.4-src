package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class TypeRegistry {
  private static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
  
  private final Map<String, Descriptors.Descriptor> types;
  
  TypeRegistry(Map<String, Descriptors.Descriptor> paramMap) {
    this.types = paramMap;
  }
  
  public static TypeRegistry getEmptyTypeRegistry() {
    return EmptyTypeRegistryHolder.EMPTY;
  }
  
  private static String getTypeName(String paramString) throws InvalidProtocolBufferException {
    String[] arrayOfString = paramString.split("/");
    if (arrayOfString.length != 1)
      return arrayOfString[arrayOfString.length - 1]; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid type url found: ");
    stringBuilder.append(paramString);
    throw new InvalidProtocolBufferException(stringBuilder.toString());
  }
  
  public static Builder newBuilder() {
    return new Builder();
  }
  
  public Descriptors.Descriptor find(String paramString) {
    return this.types.get(paramString);
  }
  
  public final Descriptors.Descriptor getDescriptorForTypeUrl(String paramString) throws InvalidProtocolBufferException {
    return find(getTypeName(paramString));
  }
  
  public static final class Builder {
    private final Set<String> files = new HashSet<String>();
    
    private Map<String, Descriptors.Descriptor> types = new HashMap<String, Descriptors.Descriptor>();
    
    private Builder() {}
    
    private void addFile(Descriptors.FileDescriptor param1FileDescriptor) {
      if (!this.files.add(param1FileDescriptor.getFullName()))
        return; 
      Iterator<Descriptors.FileDescriptor> iterator1 = param1FileDescriptor.getDependencies().iterator();
      while (iterator1.hasNext())
        addFile(iterator1.next()); 
      Iterator<Descriptors.Descriptor> iterator = param1FileDescriptor.getMessageTypes().iterator();
      while (iterator.hasNext())
        addMessage(iterator.next()); 
    }
    
    private void addMessage(Descriptors.Descriptor param1Descriptor) {
      Iterator<Descriptors.Descriptor> iterator = param1Descriptor.getNestedTypes().iterator();
      while (iterator.hasNext())
        addMessage(iterator.next()); 
      if (this.types.containsKey(param1Descriptor.getFullName())) {
        Logger logger = TypeRegistry.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type ");
        stringBuilder.append(param1Descriptor.getFullName());
        stringBuilder.append(" is added multiple times.");
        logger.warning(stringBuilder.toString());
        return;
      } 
      this.types.put(param1Descriptor.getFullName(), param1Descriptor);
    }
    
    public Builder add(Descriptors.Descriptor param1Descriptor) {
      if (this.types != null) {
        addFile(param1Descriptor.getFile());
        return this;
      } 
      throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
    }
    
    public Builder add(Iterable<Descriptors.Descriptor> param1Iterable) {
      if (this.types != null) {
        Iterator<Descriptors.Descriptor> iterator = param1Iterable.iterator();
        while (iterator.hasNext())
          addFile(((Descriptors.Descriptor)iterator.next()).getFile()); 
        return this;
      } 
      throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
    }
    
    public TypeRegistry build() {
      TypeRegistry typeRegistry = new TypeRegistry(this.types);
      this.types = null;
      return typeRegistry;
    }
  }
  
  static class EmptyTypeRegistryHolder {
    private static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\TypeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */