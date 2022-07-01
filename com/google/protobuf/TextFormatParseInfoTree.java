package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TextFormatParseInfoTree {
  private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
  
  Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;
  
  private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> paramMap, Map<Descriptors.FieldDescriptor, List<Builder>> paramMap1) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> entry : paramMap.entrySet())
      hashMap.put(entry.getKey(), Collections.unmodifiableList((List)entry.getValue())); 
    this.locationsFromField = Collections.unmodifiableMap(hashMap);
    paramMap = new HashMap<Descriptors.FieldDescriptor, List<TextFormatParseLocation>>();
    for (Map.Entry<Descriptors.FieldDescriptor, List<Builder>> entry : paramMap1.entrySet()) {
      ArrayList<TextFormatParseInfoTree> arrayList = new ArrayList();
      Iterator<Builder> iterator = ((List)entry.getValue()).iterator();
      while (iterator.hasNext())
        arrayList.add(((Builder)iterator.next()).build()); 
      paramMap.put((Descriptors.FieldDescriptor)entry.getKey(), (List)Collections.unmodifiableList(arrayList));
    } 
    this.subtreesFromField = Collections.unmodifiableMap(paramMap);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private static <T> T getFromList(List<T> paramList, int paramInt, Descriptors.FieldDescriptor paramFieldDescriptor) {
    String str;
    if (paramInt >= paramList.size() || paramInt < 0) {
      if (paramFieldDescriptor == null) {
        str = "<null>";
      } else {
        str = paramFieldDescriptor.getName();
      } 
      throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", new Object[] { str, Integer.valueOf(paramInt) }));
    } 
    return str.get(paramInt);
  }
  
  public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    return getFromList(getLocations(paramFieldDescriptor), paramInt, paramFieldDescriptor);
  }
  
  public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor paramFieldDescriptor) {
    List<?> list2 = this.locationsFromField.get(paramFieldDescriptor);
    List<?> list1 = list2;
    if (list2 == null)
      list1 = Collections.emptyList(); 
    return (List)list1;
  }
  
  public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    return getFromList(getNestedTrees(paramFieldDescriptor), paramInt, paramFieldDescriptor);
  }
  
  public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor paramFieldDescriptor) {
    List<?> list2 = this.subtreesFromField.get(paramFieldDescriptor);
    List<?> list1 = list2;
    if (list2 == null)
      list1 = Collections.emptyList(); 
    return (List)list1;
  }
  
  public static class Builder {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField = new HashMap<Descriptors.FieldDescriptor, List<TextFormatParseLocation>>();
    
    private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField = new HashMap<Descriptors.FieldDescriptor, List<Builder>>();
    
    private Builder() {}
    
    public TextFormatParseInfoTree build() {
      return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
    }
    
    public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      List<Builder> list2 = this.subtreeBuildersFromField.get(param1FieldDescriptor);
      List<Builder> list1 = list2;
      if (list2 == null) {
        list1 = new ArrayList();
        this.subtreeBuildersFromField.put(param1FieldDescriptor, list1);
      } 
      Builder builder = new Builder();
      list1.add(builder);
      return builder;
    }
    
    public Builder setLocation(Descriptors.FieldDescriptor param1FieldDescriptor, TextFormatParseLocation param1TextFormatParseLocation) {
      List<TextFormatParseLocation> list2 = this.locationsFromField.get(param1FieldDescriptor);
      List<TextFormatParseLocation> list1 = list2;
      if (list2 == null) {
        list1 = new ArrayList();
        this.locationsFromField.put(param1FieldDescriptor, list1);
      } 
      list1.add(param1TextFormatParseLocation);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\TextFormatParseInfoTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */