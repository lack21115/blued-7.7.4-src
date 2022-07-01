package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class FieldSet<T extends FieldSet.FieldDescriptorLite<T>> {
  private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
  
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  
  private final SmallSortedMap<T, Object> fields = SmallSortedMap.newFieldMap(16);
  
  private boolean hasLazyField;
  
  private boolean isImmutable;
  
  private FieldSet() {}
  
  private FieldSet(SmallSortedMap<T, Object> paramSmallSortedMap) {
    makeImmutable();
  }
  
  private FieldSet(boolean paramBoolean) {
    this(SmallSortedMap.newFieldMap(0));
    makeImmutable();
  }
  
  private static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> paramSmallSortedMap, boolean paramBoolean) {
    SmallSortedMap<FieldDescriptorLite, Object> smallSortedMap = SmallSortedMap.newFieldMap(16);
    for (int i = 0; i < paramSmallSortedMap.getNumArrayEntries(); i++)
      cloneFieldEntry(smallSortedMap, paramSmallSortedMap.getArrayEntryAt(i), paramBoolean); 
    Iterator<Map.Entry<FieldDescriptorLite, Object>> iterator = paramSmallSortedMap.getOverflowEntries().iterator();
    while (iterator.hasNext())
      cloneFieldEntry(smallSortedMap, iterator.next(), paramBoolean); 
    return (SmallSortedMap)smallSortedMap;
  }
  
  private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> paramMap, Map.Entry<T, Object> paramEntry, boolean paramBoolean) {
    FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    paramEntry = (Map.Entry<T, Object>)paramEntry.getValue();
    if (paramEntry instanceof LazyField) {
      paramMap.put((T)fieldDescriptorLite, ((LazyField)paramEntry).getValue());
      return;
    } 
    if (paramBoolean && paramEntry instanceof List) {
      paramMap.put((T)fieldDescriptorLite, new ArrayList((List)paramEntry));
      return;
    } 
    paramMap.put((T)fieldDescriptorLite, paramEntry);
  }
  
  private static Object cloneIfMutable(Object paramObject) {
    if (paramObject instanceof byte[]) {
      paramObject = paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    } 
    return paramObject;
  }
  
  static int computeElementSize(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject) {
    int i = CodedOutputStream.computeTagSize(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP)
      paramInt = i * 2; 
    return paramInt + computeElementSizeNoTag(paramFieldType, paramObject);
  }
  
  static int computeElementSizeNoTag(WireFormat.FieldType paramFieldType, Object paramObject) {
    switch (paramFieldType) {
      default:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      case ENUM:
        return (paramObject instanceof Internal.EnumLite) ? CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)paramObject).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer)paramObject).intValue());
      case SINT64:
        return CodedOutputStream.computeSInt64SizeNoTag(((Long)paramObject).longValue());
      case SINT32:
        return CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramObject).intValue());
      case SFIXED64:
        return CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramObject).longValue());
      case SFIXED32:
        return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramObject).intValue());
      case UINT32:
        return CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramObject).intValue());
      case BYTES:
        return (paramObject instanceof ByteString) ? CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject) : CodedOutputStream.computeByteArraySizeNoTag((byte[])paramObject);
      case STRING:
        return (paramObject instanceof ByteString) ? CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject) : CodedOutputStream.computeStringSizeNoTag((String)paramObject);
      case MESSAGE:
        return (paramObject instanceof LazyField) ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)paramObject) : CodedOutputStream.computeMessageSizeNoTag((MessageLite)paramObject);
      case GROUP:
        return CodedOutputStream.computeGroupSizeNoTag((MessageLite)paramObject);
      case BOOL:
        return CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramObject).booleanValue());
      case FIXED32:
        return CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramObject).intValue());
      case FIXED64:
        return CodedOutputStream.computeFixed64SizeNoTag(((Long)paramObject).longValue());
      case INT32:
        return CodedOutputStream.computeInt32SizeNoTag(((Integer)paramObject).intValue());
      case UINT64:
        return CodedOutputStream.computeUInt64SizeNoTag(((Long)paramObject).longValue());
      case INT64:
        return CodedOutputStream.computeInt64SizeNoTag(((Long)paramObject).longValue());
      case FLOAT:
        return CodedOutputStream.computeFloatSizeNoTag(((Float)paramObject).floatValue());
      case DOUBLE:
        break;
    } 
    return CodedOutputStream.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
  }
  
  public static int computeFieldSize(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject) {
    WireFormat.FieldType fieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated()) {
      boolean bool1 = paramFieldDescriptorLite.isPacked();
      boolean bool = false;
      int j = 0;
      if (bool1) {
        Iterator iterator1 = ((List)paramObject).iterator();
        while (iterator1.hasNext())
          j += computeElementSizeNoTag(fieldType, iterator1.next()); 
        return CodedOutputStream.computeTagSize(i) + j + CodedOutputStream.computeRawVarint32Size(j);
      } 
      Iterator iterator = ((List)paramObject).iterator();
      for (j = bool; iterator.hasNext(); j += computeElementSize(fieldType, i, iterator.next()));
      return j;
    } 
    return computeElementSize(fieldType, i, paramObject);
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
    return DEFAULT_INSTANCE;
  }
  
  private int getMessageSetSerializedSize(Map.Entry<T, Object> paramEntry) {
    FieldDescriptorLite<?> fieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object object = paramEntry.getValue();
    return (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptorLite.isRepeated() && !fieldDescriptorLite.isPacked()) ? ((object instanceof LazyField) ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (LazyField)object) : CodedOutputStream.computeMessageSetExtensionSize(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (MessageLite)object)) : computeFieldSize(fieldDescriptorLite, object);
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType paramFieldType, boolean paramBoolean) {
    return paramBoolean ? 2 : paramFieldType.getWireType();
  }
  
  private static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> paramEntry) {
    FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
      Iterator<MessageLite> iterator;
      if (fieldDescriptorLite.isRepeated()) {
        iterator = ((List)paramEntry.getValue()).iterator();
        while (iterator.hasNext()) {
          if (!((MessageLite)iterator.next()).isInitialized())
            return false; 
        } 
      } else {
        iterator = iterator.getValue();
        if (iterator instanceof MessageLite) {
          if (!((MessageLite)iterator).isInitialized())
            return false; 
        } else {
          if (iterator instanceof LazyField)
            return true; 
          throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } 
      } 
    } 
    return true;
  }
  
  private static boolean isValidType(WireFormat.FieldType paramFieldType, Object paramObject) {
    Internal.checkNotNull(paramObject);
    int i = null.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramFieldType.getJavaType().ordinal()];
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    switch (i) {
      default:
        return false;
      case 9:
        if (!(paramObject instanceof MessageLite)) {
          if (paramObject instanceof LazyField)
            return true; 
          bool1 = false;
        } 
        return bool1;
      case 8:
        bool1 = bool2;
        if (!(paramObject instanceof Integer)) {
          if (paramObject instanceof Internal.EnumLite)
            return true; 
          bool1 = false;
        } 
        return bool1;
      case 7:
        bool1 = bool3;
        if (!(paramObject instanceof ByteString)) {
          if (paramObject instanceof byte[])
            return true; 
          bool1 = false;
        } 
        return bool1;
      case 6:
        return paramObject instanceof String;
      case 5:
        return paramObject instanceof Boolean;
      case 4:
        return paramObject instanceof Double;
      case 3:
        return paramObject instanceof Float;
      case 2:
        return paramObject instanceof Long;
      case 1:
        break;
    } 
    return paramObject instanceof Integer;
  }
  
  private void mergeFromField(Map.Entry<T, Object> paramEntry) {
    FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite)paramEntry.getKey();
    Object object2 = paramEntry.getValue();
    Object object1 = object2;
    if (object2 instanceof LazyField)
      object1 = ((LazyField)object2).getValue(); 
    if (fieldDescriptorLite.isRepeated()) {
      object = getField((T)fieldDescriptorLite);
      object2 = object;
      if (object == null)
        object2 = new ArrayList(); 
      for (Object object : object1)
        ((List<Object>)object2).add(cloneIfMutable(object)); 
      this.fields.put((T)fieldDescriptorLite, object2);
      return;
    } 
    if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
      object2 = getField((T)fieldDescriptorLite);
      if (object2 == null) {
        this.fields.put((T)fieldDescriptorLite, cloneIfMutable(object1));
        return;
      } 
      object1 = fieldDescriptorLite.internalMergeFrom(((MessageLite)object2).toBuilder(), (MessageLite)object1).build();
      this.fields.put((T)fieldDescriptorLite, object1);
      return;
    } 
    this.fields.put((T)fieldDescriptorLite, cloneIfMutable(object1));
  }
  
  public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
    return new Builder<T>();
  }
  
  public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
    return new FieldSet<T>();
  }
  
  public static Object readPrimitiveField(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, boolean paramBoolean) throws IOException {
    return paramBoolean ? WireFormat.readPrimitiveField(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.STRICT) : WireFormat.readPrimitiveField(paramCodedInputStream, paramFieldType, WireFormat.Utf8Validation.LOOSE);
  }
  
  private void verifyType(WireFormat.FieldType paramFieldType, Object paramObject) {
    if (isValidType(paramFieldType, paramObject))
      return; 
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  static void writeElement(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject) throws IOException {
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramCodedOutputStream.writeGroup(paramInt, (MessageLite)paramObject);
      return;
    } 
    paramCodedOutputStream.writeTag(paramInt, getWireFormatForFieldType(paramFieldType, false));
    writeElementNoTag(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  static void writeElementNoTag(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject) throws IOException {
    switch (paramFieldType) {
      default:
        return;
      case ENUM:
        if (paramObject instanceof Internal.EnumLite) {
          paramCodedOutputStream.writeEnumNoTag(((Internal.EnumLite)paramObject).getNumber());
          return;
        } 
        paramCodedOutputStream.writeEnumNoTag(((Integer)paramObject).intValue());
        return;
      case SINT64:
        paramCodedOutputStream.writeSInt64NoTag(((Long)paramObject).longValue());
        return;
      case SINT32:
        paramCodedOutputStream.writeSInt32NoTag(((Integer)paramObject).intValue());
        return;
      case SFIXED64:
        paramCodedOutputStream.writeSFixed64NoTag(((Long)paramObject).longValue());
        return;
      case SFIXED32:
        paramCodedOutputStream.writeSFixed32NoTag(((Integer)paramObject).intValue());
        return;
      case UINT32:
        paramCodedOutputStream.writeUInt32NoTag(((Integer)paramObject).intValue());
        return;
      case BYTES:
        if (paramObject instanceof ByteString) {
          paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
          return;
        } 
        paramCodedOutputStream.writeByteArrayNoTag((byte[])paramObject);
        return;
      case STRING:
        if (paramObject instanceof ByteString) {
          paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
          return;
        } 
        paramCodedOutputStream.writeStringNoTag((String)paramObject);
        return;
      case MESSAGE:
        paramCodedOutputStream.writeMessageNoTag((MessageLite)paramObject);
        return;
      case GROUP:
        paramCodedOutputStream.writeGroupNoTag((MessageLite)paramObject);
        return;
      case BOOL:
        paramCodedOutputStream.writeBoolNoTag(((Boolean)paramObject).booleanValue());
        return;
      case FIXED32:
        paramCodedOutputStream.writeFixed32NoTag(((Integer)paramObject).intValue());
        return;
      case FIXED64:
        paramCodedOutputStream.writeFixed64NoTag(((Long)paramObject).longValue());
        return;
      case INT32:
        paramCodedOutputStream.writeInt32NoTag(((Integer)paramObject).intValue());
        return;
      case UINT64:
        paramCodedOutputStream.writeUInt64NoTag(((Long)paramObject).longValue());
        return;
      case INT64:
        paramCodedOutputStream.writeInt64NoTag(((Long)paramObject).longValue());
        return;
      case FLOAT:
        paramCodedOutputStream.writeFloatNoTag(((Float)paramObject).floatValue());
        return;
      case DOUBLE:
        break;
    } 
    paramCodedOutputStream.writeDoubleNoTag(((Double)paramObject).doubleValue());
  }
  
  public static void writeField(FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream) throws IOException {
    WireFormat.FieldType fieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated()) {
      paramObject = paramObject;
      if (paramFieldDescriptorLite.isPacked()) {
        paramCodedOutputStream.writeTag(i, 2);
        i = 0;
        Iterator iterator = paramObject.iterator();
        while (iterator.hasNext())
          i += computeElementSizeNoTag(fieldType, iterator.next()); 
        paramCodedOutputStream.writeRawVarint32(i);
        iterator = paramObject.iterator();
        while (iterator.hasNext())
          writeElementNoTag(paramCodedOutputStream, fieldType, iterator.next()); 
      } else {
        Iterator iterator = paramObject.iterator();
        while (iterator.hasNext())
          writeElement(paramCodedOutputStream, fieldType, i, iterator.next()); 
      } 
    } else {
      if (paramObject instanceof LazyField) {
        writeElement(paramCodedOutputStream, fieldType, i, ((LazyField)paramObject).getValue());
        return;
      } 
      writeElement(paramCodedOutputStream, fieldType, i, paramObject);
    } 
  }
  
  private void writeMessageSetTo(Map.Entry<T, Object> paramEntry, CodedOutputStream paramCodedOutputStream) throws IOException {
    Object object = (FieldDescriptorLite)paramEntry.getKey();
    if (object.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !object.isRepeated() && !object.isPacked()) {
      Object object1 = paramEntry.getValue();
      object = object1;
      if (object1 instanceof LazyField)
        object = ((LazyField)object1).getValue(); 
      paramCodedOutputStream.writeMessageSetExtension(((FieldDescriptorLite)paramEntry.getKey()).getNumber(), (MessageLite)object);
      return;
    } 
    writeField((FieldDescriptorLite<?>)object, paramEntry.getValue(), paramCodedOutputStream);
  }
  
  public void addRepeatedField(T paramT, Object paramObject) {
    if (paramT.isRepeated()) {
      List<Object> list;
      verifyType(paramT.getLiteType(), paramObject);
      Object object = getField(paramT);
      if (object == null) {
        object = new ArrayList();
        this.fields.put(paramT, object);
        paramT = (T)object;
      } else {
        list = (List)object;
      } 
      list.add(paramObject);
      return;
    } 
    throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
  }
  
  public void clear() {
    this.fields.clear();
    this.hasLazyField = false;
  }
  
  public void clearField(T paramT) {
    this.fields.remove(paramT);
    if (this.fields.isEmpty())
      this.hasLazyField = false; 
  }
  
  public FieldSet<T> clone() {
    FieldSet<FieldDescriptorLite> fieldSet = newFieldSet();
    for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
      Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(i);
      fieldSet.setField((FieldDescriptorLite)entry.getKey(), entry.getValue());
    } 
    for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries())
      fieldSet.setField((FieldDescriptorLite)entry.getKey(), entry.getValue()); 
    fieldSet.hasLazyField = this.hasLazyField;
    return (FieldSet)fieldSet;
  }
  
  Iterator<Map.Entry<T, Object>> descendingIterator() {
    return this.hasLazyField ? new LazyField.LazyIterator<T>(this.fields.descendingEntrySet().iterator()) : this.fields.descendingEntrySet().iterator();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof FieldSet))
      return false; 
    paramObject = paramObject;
    return this.fields.equals(((FieldSet)paramObject).fields);
  }
  
  public Map<T, Object> getAllFields() {
    if (this.hasLazyField) {
      SmallSortedMap<T, Object> smallSortedMap = cloneAllFieldsMap(this.fields, false);
      if (this.fields.isImmutable())
        smallSortedMap.makeImmutable(); 
      return smallSortedMap;
    } 
    return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
  }
  
  public Object getField(T paramT) {
    MessageLite messageLite;
    Object object = this.fields.get(paramT);
    paramT = (T)object;
    if (object instanceof LazyField)
      messageLite = ((LazyField)object).getValue(); 
    return messageLite;
  }
  
  public int getMessageSetSerializedSize() {
    int j = 0;
    int i = 0;
    while (j < this.fields.getNumArrayEntries()) {
      i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(j));
      j++;
    } 
    Iterator<Map.Entry<T, Object>> iterator = this.fields.getOverflowEntries().iterator();
    while (iterator.hasNext())
      i += getMessageSetSerializedSize(iterator.next()); 
    return i;
  }
  
  public Object getRepeatedField(T paramT, int paramInt) {
    if (paramT.isRepeated()) {
      paramT = (T)getField(paramT);
      if (paramT != null)
        return ((List)paramT).get(paramInt); 
      throw new IndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getRepeatedFieldCount(T paramT) {
    if (paramT.isRepeated()) {
      paramT = (T)getField(paramT);
      return (paramT == null) ? 0 : ((List)paramT).size();
    } 
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getSerializedSize() {
    int j = 0;
    int i = 0;
    while (j < this.fields.getNumArrayEntries()) {
      Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(j);
      i += computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue());
      j++;
    } 
    for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries())
      i += computeFieldSize((FieldDescriptorLite)entry.getKey(), entry.getValue()); 
    return i;
  }
  
  public boolean hasField(T paramT) {
    if (!paramT.isRepeated())
      return (this.fields.get(paramT) != null); 
    throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
  }
  
  public int hashCode() {
    return this.fields.hashCode();
  }
  
  boolean isEmpty() {
    return this.fields.isEmpty();
  }
  
  public boolean isImmutable() {
    return this.isImmutable;
  }
  
  public boolean isInitialized() {
    for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
      if (!isInitialized(this.fields.getArrayEntryAt(i)))
        return false; 
    } 
    Iterator<Map.Entry<FieldDescriptorLite, Object>> iterator = this.fields.getOverflowEntries().iterator();
    while (iterator.hasNext()) {
      if (!isInitialized(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public Iterator<Map.Entry<T, Object>> iterator() {
    return this.hasLazyField ? new LazyField.LazyIterator<T>(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator();
  }
  
  public void makeImmutable() {
    if (this.isImmutable)
      return; 
    this.fields.makeImmutable();
    this.isImmutable = true;
  }
  
  public void mergeFrom(FieldSet<T> paramFieldSet) {
    for (int i = 0; i < paramFieldSet.fields.getNumArrayEntries(); i++)
      mergeFromField(paramFieldSet.fields.getArrayEntryAt(i)); 
    Iterator<Map.Entry<T, Object>> iterator = paramFieldSet.fields.getOverflowEntries().iterator();
    while (iterator.hasNext())
      mergeFromField(iterator.next()); 
  }
  
  public void setField(T paramT, Object paramObject) {
    if (paramT.isRepeated()) {
      if (paramObject instanceof List) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll((List)paramObject);
        paramObject = arrayList.iterator();
        while (paramObject.hasNext()) {
          Object object = paramObject.next();
          verifyType(paramT.getLiteType(), object);
        } 
        paramObject = arrayList;
      } else {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      } 
    } else {
      verifyType(paramT.getLiteType(), paramObject);
    } 
    if (paramObject instanceof LazyField)
      this.hasLazyField = true; 
    this.fields.put(paramT, paramObject);
  }
  
  public void setRepeatedField(T paramT, int paramInt, Object paramObject) {
    if (paramT.isRepeated()) {
      Object object = getField(paramT);
      if (object != null) {
        verifyType(paramT.getLiteType(), paramObject);
        ((List<Object>)object).set(paramInt, paramObject);
        return;
      } 
      throw new IndexOutOfBoundsException();
    } 
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public void writeMessageSetTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (int i = 0; i < this.fields.getNumArrayEntries(); i++)
      writeMessageSetTo(this.fields.getArrayEntryAt(i), paramCodedOutputStream); 
    Iterator<Map.Entry<T, Object>> iterator = this.fields.getOverflowEntries().iterator();
    while (iterator.hasNext())
      writeMessageSetTo(iterator.next(), paramCodedOutputStream); 
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
      Map.Entry<T, Object> entry = this.fields.getArrayEntryAt(i);
      writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), paramCodedOutputStream);
    } 
    for (Map.Entry<T, Object> entry : this.fields.getOverflowEntries())
      writeField((FieldDescriptorLite)entry.getKey(), entry.getValue(), paramCodedOutputStream); 
  }
  
  static final class Builder<T extends FieldDescriptorLite<T>> {
    private SmallSortedMap<T, Object> fields;
    
    private boolean hasLazyField;
    
    private boolean hasNestedBuilders;
    
    private boolean isMutable;
    
    private Builder() {
      this(SmallSortedMap.newFieldMap(16));
    }
    
    private Builder(SmallSortedMap<T, Object> param1SmallSortedMap) {
      this.fields = param1SmallSortedMap;
      this.isMutable = true;
    }
    
    private void ensureIsMutable() {
      if (!this.isMutable) {
        this.fields = FieldSet.cloneAllFieldsMap(this.fields, true);
        this.isMutable = true;
      } 
    }
    
    public static <T extends FieldSet.FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> param1FieldSet) {
      Builder<FieldSet.FieldDescriptorLite> builder = new Builder<FieldSet.FieldDescriptorLite>(FieldSet.cloneAllFieldsMap(param1FieldSet.fields, true));
      builder.hasLazyField = param1FieldSet.hasLazyField;
      return (Builder)builder;
    }
    
    private void mergeFromField(Map.Entry<T, Object> param1Entry) {
      FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite)param1Entry.getKey();
      Object object2 = param1Entry.getValue();
      Object object1 = object2;
      if (object2 instanceof LazyField)
        object1 = ((LazyField)object2).getValue(); 
      if (fieldDescriptorLite.isRepeated()) {
        object = getField((T)fieldDescriptorLite);
        object2 = object;
        if (object == null)
          object2 = new ArrayList(); 
        for (Object object : object1)
          ((List<Object>)object2).add(FieldSet.cloneIfMutable(object)); 
        this.fields.put((T)fieldDescriptorLite, object2);
        return;
      } 
      if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
        object2 = getField((T)fieldDescriptorLite);
        if (object2 == null) {
          this.fields.put((T)fieldDescriptorLite, FieldSet.cloneIfMutable(object1));
          return;
        } 
        if (object2 instanceof MessageLite.Builder) {
          fieldDescriptorLite.internalMergeFrom((MessageLite.Builder)object2, (MessageLite)object1);
          return;
        } 
        object1 = fieldDescriptorLite.internalMergeFrom(((MessageLite)object2).toBuilder(), (MessageLite)object1).build();
        this.fields.put((T)fieldDescriptorLite, object1);
        return;
      } 
      this.fields.put((T)fieldDescriptorLite, FieldSet.cloneIfMutable(object1));
    }
    
    private static Object replaceBuilder(Object param1Object) {
      Object object = param1Object;
      if (param1Object instanceof MessageLite.Builder)
        object = ((MessageLite.Builder)param1Object).build(); 
      return object;
    }
    
    private static <T extends FieldSet.FieldDescriptorLite<T>> Object replaceBuilders(T param1T, Object param1Object) {
      if (param1Object == null)
        return param1Object; 
      if (param1T.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
        if (param1T.isRepeated()) {
          if (param1Object instanceof List) {
            List<Object> list = (List)param1Object;
            int i = 0;
            while (i < list.size()) {
              Object object1 = list.get(i);
              Object object = replaceBuilder(object1);
              List<Object> list1 = list;
              if (object != object1) {
                list1 = list;
                if (list == param1Object)
                  list1 = (List)new ArrayList<Object>((Collection)list); 
                list1.set(i, object);
              } 
              i++;
              list = list1;
            } 
            return list;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Repeated field should contains a List but actually contains type: ");
          stringBuilder.append(param1Object.getClass());
          throw new IllegalStateException(stringBuilder.toString());
        } 
        return replaceBuilder(param1Object);
      } 
      return param1Object;
    }
    
    private static <T extends FieldSet.FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> param1SmallSortedMap) {
      for (int i = 0; i < param1SmallSortedMap.getNumArrayEntries(); i++)
        replaceBuilders(param1SmallSortedMap.getArrayEntryAt(i)); 
      Iterator<Map.Entry<FieldSet.FieldDescriptorLite, Object>> iterator = param1SmallSortedMap.getOverflowEntries().iterator();
      while (iterator.hasNext())
        replaceBuilders(iterator.next()); 
    }
    
    private static <T extends FieldSet.FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> param1Entry) {
      param1Entry.setValue(replaceBuilders((FieldSet.FieldDescriptorLite)param1Entry.getKey(), param1Entry.getValue()));
    }
    
    private static void verifyType(WireFormat.FieldType param1FieldType, Object param1Object) {
      if (!FieldSet.isValidType(param1FieldType, param1Object)) {
        if (param1FieldType.getJavaType() == WireFormat.JavaType.MESSAGE && param1Object instanceof MessageLite.Builder)
          return; 
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      } 
    }
    
    public void addRepeatedField(T param1T, Object param1Object) {
      ensureIsMutable();
      if (param1T.isRepeated()) {
        List<Object> list;
        boolean bool;
        if (this.hasNestedBuilders || param1Object instanceof MessageLite.Builder) {
          bool = true;
        } else {
          bool = false;
        } 
        this.hasNestedBuilders = bool;
        verifyType(param1T.getLiteType(), param1Object);
        Object object = getField(param1T);
        if (object == null) {
          object = new ArrayList();
          this.fields.put(param1T, object);
          param1T = (T)object;
        } else {
          list = (List)object;
        } 
        list.add(param1Object);
        return;
      } 
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
    
    public FieldSet<T> build() {
      if (this.fields.isEmpty())
        return FieldSet.emptySet(); 
      this.isMutable = false;
      SmallSortedMap<T, Object> smallSortedMap2 = this.fields;
      SmallSortedMap<T, Object> smallSortedMap1 = smallSortedMap2;
      if (this.hasNestedBuilders) {
        smallSortedMap1 = FieldSet.cloneAllFieldsMap(smallSortedMap2, false);
        replaceBuilders(smallSortedMap1);
      } 
      FieldSet<FieldSet.FieldDescriptorLite> fieldSet = new FieldSet<FieldSet.FieldDescriptorLite>(smallSortedMap1);
      FieldSet.access$302(fieldSet, this.hasLazyField);
      return (FieldSet)fieldSet;
    }
    
    public void clearField(T param1T) {
      ensureIsMutable();
      this.fields.remove(param1T);
      if (this.fields.isEmpty())
        this.hasLazyField = false; 
    }
    
    public Map<T, Object> getAllFields() {
      if (this.hasLazyField) {
        SmallSortedMap<T, Object> smallSortedMap = FieldSet.cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable()) {
          smallSortedMap.makeImmutable();
          return smallSortedMap;
        } 
        replaceBuilders(smallSortedMap);
        return smallSortedMap;
      } 
      return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
    }
    
    public Object getField(T param1T) {
      return replaceBuilders(param1T, getFieldAllowBuilders(param1T));
    }
    
    Object getFieldAllowBuilders(T param1T) {
      MessageLite messageLite;
      Object object = this.fields.get(param1T);
      param1T = (T)object;
      if (object instanceof LazyField)
        messageLite = ((LazyField)object).getValue(); 
      return messageLite;
    }
    
    public Object getRepeatedField(T param1T, int param1Int) {
      if (this.hasNestedBuilders)
        ensureIsMutable(); 
      return replaceBuilder(getRepeatedFieldAllowBuilders(param1T, param1Int));
    }
    
    Object getRepeatedFieldAllowBuilders(T param1T, int param1Int) {
      if (param1T.isRepeated()) {
        param1T = (T)getFieldAllowBuilders(param1T);
        if (param1T != null)
          return ((List)param1T).get(param1Int); 
        throw new IndexOutOfBoundsException();
      } 
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    
    public int getRepeatedFieldCount(T param1T) {
      if (param1T.isRepeated()) {
        param1T = (T)getField(param1T);
        return (param1T == null) ? 0 : ((List)param1T).size();
      } 
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
    
    public boolean hasField(T param1T) {
      if (!param1T.isRepeated())
        return (this.fields.get(param1T) != null); 
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }
    
    public boolean isInitialized() {
      for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
        if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(i)))
          return false; 
      } 
      Iterator<Map.Entry> iterator = this.fields.getOverflowEntries().iterator();
      while (iterator.hasNext()) {
        if (!FieldSet.isInitialized(iterator.next()))
          return false; 
      } 
      return true;
    }
    
    public void mergeFrom(FieldSet<T> param1FieldSet) {
      ensureIsMutable();
      for (int i = 0; i < param1FieldSet.fields.getNumArrayEntries(); i++)
        mergeFromField(param1FieldSet.fields.getArrayEntryAt(i)); 
      Iterator<Map.Entry<T, Object>> iterator = param1FieldSet.fields.getOverflowEntries().iterator();
      while (iterator.hasNext())
        mergeFromField(iterator.next()); 
    }
    
    public void setField(T param1T, Object param1Object) {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial ensureIsMutable : ()V
      //   4: aload_1
      //   5: invokeinterface isRepeated : ()Z
      //   10: istore_3
      //   11: iconst_0
      //   12: istore #4
      //   14: iload_3
      //   15: ifeq -> 131
      //   18: aload_2
      //   19: instanceof java/util/List
      //   22: ifeq -> 121
      //   25: new java/util/ArrayList
      //   28: dup
      //   29: invokespecial <init> : ()V
      //   32: astore #5
      //   34: aload #5
      //   36: aload_2
      //   37: checkcast java/util/List
      //   40: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   45: pop
      //   46: aload #5
      //   48: invokeinterface iterator : ()Ljava/util/Iterator;
      //   53: astore_2
      //   54: aload_2
      //   55: invokeinterface hasNext : ()Z
      //   60: ifeq -> 115
      //   63: aload_2
      //   64: invokeinterface next : ()Ljava/lang/Object;
      //   69: astore #6
      //   71: aload_1
      //   72: invokeinterface getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
      //   77: aload #6
      //   79: invokestatic verifyType : (Lcom/google/protobuf/WireFormat$FieldType;Ljava/lang/Object;)V
      //   82: aload_0
      //   83: getfield hasNestedBuilders : Z
      //   86: ifne -> 105
      //   89: aload #6
      //   91: instanceof com/google/protobuf/MessageLite$Builder
      //   94: ifeq -> 100
      //   97: goto -> 105
      //   100: iconst_0
      //   101: istore_3
      //   102: goto -> 107
      //   105: iconst_1
      //   106: istore_3
      //   107: aload_0
      //   108: iload_3
      //   109: putfield hasNestedBuilders : Z
      //   112: goto -> 54
      //   115: aload #5
      //   117: astore_2
      //   118: goto -> 141
      //   121: new java/lang/IllegalArgumentException
      //   124: dup
      //   125: ldc 'Wrong object type used with protocol message reflection.'
      //   127: invokespecial <init> : (Ljava/lang/String;)V
      //   130: athrow
      //   131: aload_1
      //   132: invokeinterface getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
      //   137: aload_2
      //   138: invokestatic verifyType : (Lcom/google/protobuf/WireFormat$FieldType;Ljava/lang/Object;)V
      //   141: aload_2
      //   142: instanceof com/google/protobuf/LazyField
      //   145: ifeq -> 153
      //   148: aload_0
      //   149: iconst_1
      //   150: putfield hasLazyField : Z
      //   153: aload_0
      //   154: getfield hasNestedBuilders : Z
      //   157: ifne -> 170
      //   160: iload #4
      //   162: istore_3
      //   163: aload_2
      //   164: instanceof com/google/protobuf/MessageLite$Builder
      //   167: ifeq -> 172
      //   170: iconst_1
      //   171: istore_3
      //   172: aload_0
      //   173: iload_3
      //   174: putfield hasNestedBuilders : Z
      //   177: aload_0
      //   178: getfield fields : Lcom/google/protobuf/SmallSortedMap;
      //   181: aload_1
      //   182: aload_2
      //   183: invokevirtual put : (Ljava/lang/Comparable;Ljava/lang/Object;)Ljava/lang/Object;
      //   186: pop
      //   187: return
    }
    
    public void setRepeatedField(T param1T, int param1Int, Object param1Object) {
      ensureIsMutable();
      if (param1T.isRepeated()) {
        boolean bool;
        if (this.hasNestedBuilders || param1Object instanceof MessageLite.Builder) {
          bool = true;
        } else {
          bool = false;
        } 
        this.hasNestedBuilders = bool;
        Object object = getField(param1T);
        if (object != null) {
          verifyType(param1T.getLiteType(), param1Object);
          ((List<Object>)object).set(param1Int, param1Object);
          return;
        } 
        throw new IndexOutOfBoundsException();
      } 
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
  }
  
  public static interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
    Internal.EnumLiteMap<?> getEnumType();
    
    WireFormat.JavaType getLiteJavaType();
    
    WireFormat.FieldType getLiteType();
    
    int getNumber();
    
    MessageLite.Builder internalMergeFrom(MessageLite.Builder param1Builder, MessageLite param1MessageLite);
    
    boolean isPacked();
    
    boolean isRepeated();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\FieldSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */