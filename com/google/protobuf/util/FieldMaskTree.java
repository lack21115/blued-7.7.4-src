package com.google.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

final class FieldMaskTree {
  private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
  
  private static final Logger logger = Logger.getLogger(FieldMaskTree.class.getName());
  
  private final Node root = new Node();
  
  FieldMaskTree() {}
  
  FieldMaskTree(FieldMask paramFieldMask) {
    mergeFromFieldMask(paramFieldMask);
  }
  
  private void getFieldPaths(Node paramNode, String paramString, List<String> paramList) {
    if (paramNode.children.isEmpty()) {
      paramList.add(paramString);
      return;
    } 
    for (Map.Entry<String, Node> entry : paramNode.children.entrySet()) {
      String str;
      if (paramString.isEmpty()) {
        str = (String)entry.getKey();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(".");
        stringBuilder.append((String)entry.getKey());
        str = stringBuilder.toString();
      } 
      getFieldPaths((Node)entry.getValue(), str, paramList);
    } 
  }
  
  private void merge(Node paramNode, String paramString, Message paramMessage, Message.Builder paramBuilder, FieldMaskUtil.MergeOptions paramMergeOptions) {
    if (paramMessage.getDescriptorForType() == paramBuilder.getDescriptorForType()) {
      Descriptors.Descriptor descriptor = paramMessage.getDescriptorForType();
      for (Map.Entry<String, Node> entry : paramNode.children.entrySet()) {
        StringBuilder stringBuilder;
        Descriptors.FieldDescriptor fieldDescriptor = descriptor.findFieldByName((String)entry.getKey());
        if (fieldDescriptor == null) {
          Logger logger = logger;
          stringBuilder = new StringBuilder();
          stringBuilder.append("Cannot find field \"");
          stringBuilder.append((String)entry.getKey());
          stringBuilder.append("\" in message type ");
          stringBuilder.append(descriptor.getFullName());
          logger.warning(stringBuilder.toString());
          continue;
        } 
        if (!((Node)entry.getValue()).children.isEmpty()) {
          String str;
          StringBuilder stringBuilder1;
          if (stringBuilder.isRepeated() || stringBuilder.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            Logger logger = logger;
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Field \"");
            stringBuilder1.append(stringBuilder.getFullName());
            stringBuilder1.append("\" is not a singluar message field and cannot have sub-fields.");
            logger.warning(stringBuilder1.toString());
            continue;
          } 
          if (paramString.isEmpty()) {
            str = (String)stringBuilder1.getKey();
          } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(paramString);
            stringBuilder2.append(".");
            stringBuilder2.append((String)stringBuilder1.getKey());
            str = stringBuilder2.toString();
          } 
          merge((Node)stringBuilder1.getValue(), str, (Message)paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder), paramBuilder.getFieldBuilder((Descriptors.FieldDescriptor)stringBuilder), paramMergeOptions);
          continue;
        } 
        if (stringBuilder.isRepeated()) {
          if (paramMergeOptions.replaceRepeatedFields()) {
            paramBuilder.setField((Descriptors.FieldDescriptor)stringBuilder, paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder));
            continue;
          } 
          Iterator iterator = ((List)paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder)).iterator();
          while (iterator.hasNext())
            paramBuilder.addRepeatedField((Descriptors.FieldDescriptor)stringBuilder, iterator.next()); 
          continue;
        } 
        if (stringBuilder.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          if (paramMergeOptions.replaceMessageFields()) {
            if (!paramMessage.hasField((Descriptors.FieldDescriptor)stringBuilder)) {
              paramBuilder.clearField((Descriptors.FieldDescriptor)stringBuilder);
              continue;
            } 
            paramBuilder.setField((Descriptors.FieldDescriptor)stringBuilder, paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder));
            continue;
          } 
          if (paramMessage.hasField((Descriptors.FieldDescriptor)stringBuilder))
            paramBuilder.getFieldBuilder((Descriptors.FieldDescriptor)stringBuilder).mergeFrom((Message)paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder)); 
          continue;
        } 
        if (paramMessage.hasField((Descriptors.FieldDescriptor)stringBuilder) || !paramMergeOptions.replacePrimitiveFields()) {
          paramBuilder.setField((Descriptors.FieldDescriptor)stringBuilder, paramMessage.getField((Descriptors.FieldDescriptor)stringBuilder));
          continue;
        } 
        paramBuilder.clearField((Descriptors.FieldDescriptor)stringBuilder);
      } 
      return;
    } 
    throw new IllegalArgumentException(String.format("source (%s) and destination (%s) descriptor must be equal", new Object[] { paramMessage.getDescriptorForType(), paramBuilder.getDescriptorForType() }));
  }
  
  FieldMaskTree addFieldPath(String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length == 0)
      return this; 
    Node node = this.root;
    int j = arrayOfString.length;
    int i = 0;
    boolean bool = false;
    while (i < j) {
      String str = arrayOfString[i];
      if (!bool && node != this.root && node.children.isEmpty())
        return this; 
      if (node.children.containsKey(str)) {
        node = node.children.get(str);
      } else {
        Node node1 = new Node();
        node.children.put(str, node1);
        node = node1;
        bool = true;
      } 
      i++;
    } 
    node.children.clear();
    return this;
  }
  
  void intersectFieldPath(String paramString, FieldMaskTree paramFieldMaskTree) {
    if (this.root.children.isEmpty())
      return; 
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length == 0)
      return; 
    Node node = this.root;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j) {
      String str = arrayOfString[i];
      if (node != this.root && node.children.isEmpty()) {
        paramFieldMaskTree.addFieldPath(paramString);
        return;
      } 
      if (node.children.containsKey(str)) {
        node = node.children.get(str);
        i++;
        continue;
      } 
      return;
    } 
    ArrayList<String> arrayList = new ArrayList();
    getFieldPaths(node, paramString, arrayList);
    Iterator<String> iterator = arrayList.iterator();
    while (iterator.hasNext())
      paramFieldMaskTree.addFieldPath(iterator.next()); 
  }
  
  void merge(Message paramMessage, Message.Builder paramBuilder, FieldMaskUtil.MergeOptions paramMergeOptions) {
    if (paramMessage.getDescriptorForType() == paramBuilder.getDescriptorForType()) {
      if (this.root.children.isEmpty())
        return; 
      merge(this.root, "", paramMessage, paramBuilder, paramMergeOptions);
      return;
    } 
    throw new IllegalArgumentException("Cannot merge messages of different types.");
  }
  
  FieldMaskTree mergeFromFieldMask(FieldMask paramFieldMask) {
    Iterator<String> iterator = paramFieldMask.getPathsList().iterator();
    while (iterator.hasNext())
      addFieldPath(iterator.next()); 
    return this;
  }
  
  FieldMask toFieldMask() {
    if (this.root.children.isEmpty())
      return FieldMask.getDefaultInstance(); 
    ArrayList<String> arrayList = new ArrayList();
    getFieldPaths(this.root, "", arrayList);
    return FieldMask.newBuilder().addAllPaths(arrayList).build();
  }
  
  public String toString() {
    return FieldMaskUtil.toString(toFieldMask());
  }
  
  static final class Node {
    final SortedMap<String, Node> children = new TreeMap<String, Node>();
    
    private Node() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\FieldMaskTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */