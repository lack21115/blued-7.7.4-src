package com.google.gson;

import com.google.gson.internal.;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
  private boolean complexMapKeySerialization = false;
  
  private String datePattern;
  
  private int dateStyle = 2;
  
  private boolean escapeHtmlChars = true;
  
  private Excluder excluder = Excluder.DEFAULT;
  
  private final List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();
  
  private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
  
  private boolean generateNonExecutableJson = false;
  
  private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList<TypeAdapterFactory>();
  
  private final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap<Type, InstanceCreator<?>>();
  
  private boolean lenient = false;
  
  private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
  
  private boolean prettyPrinting = false;
  
  private boolean serializeNulls = false;
  
  private boolean serializeSpecialFloatingPointValues = false;
  
  private int timeStyle = 2;
  
  public GsonBuilder() {}
  
  GsonBuilder(Gson paramGson) {
    this.excluder = paramGson.excluder;
    this.fieldNamingPolicy = paramGson.fieldNamingStrategy;
    this.instanceCreators.putAll(paramGson.instanceCreators);
    this.serializeNulls = paramGson.serializeNulls;
    this.complexMapKeySerialization = paramGson.complexMapKeySerialization;
    this.generateNonExecutableJson = paramGson.generateNonExecutableJson;
    this.escapeHtmlChars = paramGson.htmlSafe;
    this.prettyPrinting = paramGson.prettyPrinting;
    this.lenient = paramGson.lenient;
    this.serializeSpecialFloatingPointValues = paramGson.serializeSpecialFloatingPointValues;
    this.longSerializationPolicy = paramGson.longSerializationPolicy;
    this.datePattern = paramGson.datePattern;
    this.dateStyle = paramGson.dateStyle;
    this.timeStyle = paramGson.timeStyle;
    this.factories.addAll(paramGson.builderFactories);
    this.hierarchyFactories.addAll(paramGson.builderHierarchyFactories);
  }
  
  private void addTypeAdaptersForDate(String paramString, int paramInt1, int paramInt2, List<TypeAdapterFactory> paramList) {
    DefaultDateTypeAdapter defaultDateTypeAdapter1;
    DefaultDateTypeAdapter defaultDateTypeAdapter2;
    DefaultDateTypeAdapter defaultDateTypeAdapter3;
    if (paramString != null && !"".equals(paramString.trim())) {
      defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Date.class, paramString);
      defaultDateTypeAdapter3 = new DefaultDateTypeAdapter((Class)Timestamp.class, paramString);
      defaultDateTypeAdapter1 = new DefaultDateTypeAdapter((Class)Date.class, paramString);
    } else if (paramInt1 != 2 && paramInt2 != 2) {
      defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Date.class, paramInt1, paramInt2);
      defaultDateTypeAdapter3 = new DefaultDateTypeAdapter((Class)Timestamp.class, paramInt1, paramInt2);
      defaultDateTypeAdapter1 = new DefaultDateTypeAdapter((Class)Date.class, paramInt1, paramInt2);
    } else {
      return;
    } 
    paramList.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter2));
    paramList.add(TypeAdapters.newFactory(Timestamp.class, defaultDateTypeAdapter3));
    paramList.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter1));
  }
  
  public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy) {
    this.excluder = this.excluder.withExclusionStrategy(paramExclusionStrategy, false, true);
    return this;
  }
  
  public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy) {
    this.excluder = this.excluder.withExclusionStrategy(paramExclusionStrategy, true, false);
    return this;
  }
  
  public Gson create() {
    ArrayList<TypeAdapterFactory> arrayList1 = new ArrayList(this.factories.size() + this.hierarchyFactories.size() + 3);
    arrayList1.addAll(this.factories);
    Collections.reverse(arrayList1);
    ArrayList<TypeAdapterFactory> arrayList2 = new ArrayList<TypeAdapterFactory>(this.hierarchyFactories);
    Collections.reverse(arrayList2);
    arrayList1.addAll(arrayList2);
    addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList1);
    return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList1);
  }
  
  public GsonBuilder disableHtmlEscaping() {
    this.escapeHtmlChars = false;
    return this;
  }
  
  public GsonBuilder disableInnerClassSerialization() {
    this.excluder = this.excluder.disableInnerClassSerialization();
    return this;
  }
  
  public GsonBuilder enableComplexMapKeySerialization() {
    this.complexMapKeySerialization = true;
    return this;
  }
  
  public GsonBuilder excludeFieldsWithModifiers(int... paramVarArgs) {
    this.excluder = this.excluder.withModifiers(paramVarArgs);
    return this;
  }
  
  public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
    this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
    return this;
  }
  
  public GsonBuilder generateNonExecutableJson() {
    this.generateNonExecutableJson = true;
    return this;
  }
  
  public GsonBuilder registerTypeAdapter(Type paramType, Object paramObject) {
    boolean bool;
    boolean bool1 = paramObject instanceof JsonSerializer;
    if (bool1 || paramObject instanceof JsonDeserializer || paramObject instanceof InstanceCreator || paramObject instanceof TypeAdapter) {
      bool = true;
    } else {
      bool = false;
    } 
    .Gson.Preconditions.checkArgument(bool);
    if (paramObject instanceof InstanceCreator)
      this.instanceCreators.put(paramType, (InstanceCreator)paramObject); 
    if (bool1 || paramObject instanceof JsonDeserializer) {
      TypeToken typeToken = TypeToken.get(paramType);
      this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(typeToken, paramObject));
    } 
    if (paramObject instanceof TypeAdapter)
      this.factories.add(TypeAdapters.newFactory(TypeToken.get(paramType), (TypeAdapter)paramObject)); 
    return this;
  }
  
  public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory paramTypeAdapterFactory) {
    this.factories.add(paramTypeAdapterFactory);
    return this;
  }
  
  public GsonBuilder registerTypeHierarchyAdapter(Class<?> paramClass, Object paramObject) {
    boolean bool;
    boolean bool1 = paramObject instanceof JsonSerializer;
    if (bool1 || paramObject instanceof JsonDeserializer || paramObject instanceof TypeAdapter) {
      bool = true;
    } else {
      bool = false;
    } 
    .Gson.Preconditions.checkArgument(bool);
    if (paramObject instanceof JsonDeserializer || bool1)
      this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(paramClass, paramObject)); 
    if (paramObject instanceof TypeAdapter)
      this.factories.add(TypeAdapters.newTypeHierarchyFactory(paramClass, (TypeAdapter)paramObject)); 
    return this;
  }
  
  public GsonBuilder serializeNulls() {
    this.serializeNulls = true;
    return this;
  }
  
  public GsonBuilder serializeSpecialFloatingPointValues() {
    this.serializeSpecialFloatingPointValues = true;
    return this;
  }
  
  public GsonBuilder setDateFormat(int paramInt) {
    this.dateStyle = paramInt;
    this.datePattern = null;
    return this;
  }
  
  public GsonBuilder setDateFormat(int paramInt1, int paramInt2) {
    this.dateStyle = paramInt1;
    this.timeStyle = paramInt2;
    this.datePattern = null;
    return this;
  }
  
  public GsonBuilder setDateFormat(String paramString) {
    this.datePattern = paramString;
    return this;
  }
  
  public GsonBuilder setExclusionStrategies(ExclusionStrategy... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      ExclusionStrategy exclusionStrategy = paramVarArgs[i];
      this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
    } 
    return this;
  }
  
  public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy paramFieldNamingPolicy) {
    this.fieldNamingPolicy = paramFieldNamingPolicy;
    return this;
  }
  
  public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy paramFieldNamingStrategy) {
    this.fieldNamingPolicy = paramFieldNamingStrategy;
    return this;
  }
  
  public GsonBuilder setLenient() {
    this.lenient = true;
    return this;
  }
  
  public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy paramLongSerializationPolicy) {
    this.longSerializationPolicy = paramLongSerializationPolicy;
    return this;
  }
  
  public GsonBuilder setPrettyPrinting() {
    this.prettyPrinting = true;
    return this;
  }
  
  public GsonBuilder setVersion(double paramDouble) {
    this.excluder = this.excluder.withVersion(paramDouble);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\gson\GsonBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */