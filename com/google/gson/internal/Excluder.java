package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
  public static final Excluder DEFAULT = new Excluder();
  
  private static final double IGNORE_VERSIONS = -1.0D;
  
  private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
  
  private int modifiers = 136;
  
  private boolean requireExpose;
  
  private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
  
  private boolean serializeInnerClasses = true;
  
  private double version = -1.0D;
  
  private boolean excludeClassChecks(Class<?> paramClass) {
    return (this.version != -1.0D && !isValidVersion(paramClass.<Since>getAnnotation(Since.class), paramClass.<Until>getAnnotation(Until.class))) ? true : ((!this.serializeInnerClasses && isInnerClass(paramClass)) ? true : (isAnonymousOrLocal(paramClass)));
  }
  
  private boolean excludeClassInStrategy(Class<?> paramClass, boolean paramBoolean) {
    List<ExclusionStrategy> list;
    if (paramBoolean) {
      list = this.serializationStrategies;
    } else {
      list = this.deserializationStrategies;
    } 
    Iterator<ExclusionStrategy> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (((ExclusionStrategy)iterator.next()).shouldSkipClass(paramClass))
        return true; 
    } 
    return false;
  }
  
  private boolean isAnonymousOrLocal(Class<?> paramClass) {
    return (!Enum.class.isAssignableFrom(paramClass) && (paramClass.isAnonymousClass() || paramClass.isLocalClass()));
  }
  
  private boolean isInnerClass(Class<?> paramClass) {
    return (paramClass.isMemberClass() && !isStatic(paramClass));
  }
  
  private boolean isStatic(Class<?> paramClass) {
    return ((paramClass.getModifiers() & 0x8) != 0);
  }
  
  private boolean isValidSince(Since paramSince) {
    return !(paramSince != null && paramSince.value() > this.version);
  }
  
  private boolean isValidUntil(Until paramUntil) {
    return !(paramUntil != null && paramUntil.value() <= this.version);
  }
  
  private boolean isValidVersion(Since paramSince, Until paramUntil) {
    return (isValidSince(paramSince) && isValidUntil(paramUntil));
  }
  
  protected Excluder clone() {
    try {
      return (Excluder)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
    final boolean skipSerialize;
    Class<?> clazz = type.getRawType();
    final boolean skipDeserialize = excludeClassChecks(clazz);
    if (bool1 || excludeClassInStrategy(clazz, true)) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool1 || excludeClassInStrategy(clazz, false)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    return (!bool && !bool1) ? null : new TypeAdapter<T>() {
        private TypeAdapter<T> delegate;
        
        private TypeAdapter<T> delegate() {
          TypeAdapter<T> typeAdapter = this.delegate;
          if (typeAdapter != null)
            return typeAdapter; 
          typeAdapter = gson.getDelegateAdapter(Excluder.this, type);
          this.delegate = typeAdapter;
          return typeAdapter;
        }
        
        public T read(JsonReader param1JsonReader) throws IOException {
          if (skipDeserialize) {
            param1JsonReader.skipValue();
            return null;
          } 
          return (T)delegate().read(param1JsonReader);
        }
        
        public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
          if (skipSerialize) {
            param1JsonWriter.nullValue();
            return;
          } 
          delegate().write(param1JsonWriter, param1T);
        }
      };
  }
  
  public Excluder disableInnerClassSerialization() {
    Excluder excluder = clone();
    excluder.serializeInnerClasses = false;
    return excluder;
  }
  
  public boolean excludeClass(Class<?> paramClass, boolean paramBoolean) {
    return (excludeClassChecks(paramClass) || excludeClassInStrategy(paramClass, paramBoolean));
  }
  
  public boolean excludeField(Field paramField, boolean paramBoolean) {
    List<ExclusionStrategy> list;
    if ((this.modifiers & paramField.getModifiers()) != 0)
      return true; 
    if (this.version != -1.0D && !isValidVersion(paramField.<Since>getAnnotation(Since.class), paramField.<Until>getAnnotation(Until.class)))
      return true; 
    if (paramField.isSynthetic())
      return true; 
    if (this.requireExpose) {
      Expose expose = paramField.<Expose>getAnnotation(Expose.class);
      if (expose != null) {
        if (paramBoolean) {
          if (!expose.serialize())
            return true; 
        } else if (!expose.deserialize()) {
          return true;
        } 
      } else {
        return true;
      } 
    } 
    if (!this.serializeInnerClasses && isInnerClass(paramField.getType()))
      return true; 
    if (isAnonymousOrLocal(paramField.getType()))
      return true; 
    if (paramBoolean) {
      list = this.serializationStrategies;
    } else {
      list = this.deserializationStrategies;
    } 
    if (!list.isEmpty()) {
      FieldAttributes fieldAttributes = new FieldAttributes(paramField);
      Iterator<ExclusionStrategy> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (((ExclusionStrategy)iterator.next()).shouldSkipField(fieldAttributes))
          return true; 
      } 
    } 
    return false;
  }
  
  public Excluder excludeFieldsWithoutExposeAnnotation() {
    Excluder excluder = clone();
    excluder.requireExpose = true;
    return excluder;
  }
  
  public Excluder withExclusionStrategy(ExclusionStrategy paramExclusionStrategy, boolean paramBoolean1, boolean paramBoolean2) {
    Excluder excluder = clone();
    if (paramBoolean1) {
      excluder.serializationStrategies = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
      excluder.serializationStrategies.add(paramExclusionStrategy);
    } 
    if (paramBoolean2) {
      excluder.deserializationStrategies = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
      excluder.deserializationStrategies.add(paramExclusionStrategy);
    } 
    return excluder;
  }
  
  public Excluder withModifiers(int... paramVarArgs) {
    Excluder excluder = clone();
    int i = 0;
    excluder.modifiers = 0;
    int j = paramVarArgs.length;
    while (i < j) {
      excluder.modifiers = paramVarArgs[i] | excluder.modifiers;
      i++;
    } 
    return excluder;
  }
  
  public Excluder withVersion(double paramDouble) {
    Excluder excluder = clone();
    excluder.version = paramDouble;
    return excluder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\internal\Excluder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */