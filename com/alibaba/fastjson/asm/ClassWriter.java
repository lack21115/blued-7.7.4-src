package com.alibaba.fastjson.asm;

public class ClassWriter {
  private int access;
  
  FieldWriter firstField;
  
  MethodWriter firstMethod;
  
  int index = 1;
  
  private int interfaceCount;
  
  private int[] interfaces;
  
  Item[] items = new Item[256];
  
  final Item key = new Item();
  
  final Item key2 = new Item();
  
  final Item key3 = new Item();
  
  FieldWriter lastField;
  
  MethodWriter lastMethod;
  
  private int name;
  
  final ByteVector pool = new ByteVector();
  
  private int superName;
  
  String thisName;
  
  int threshold = (int)(this.items.length * 0.75D);
  
  Item[] typeTable;
  
  int version;
  
  public ClassWriter() {
    this(0);
  }
  
  private ClassWriter(int paramInt) {}
  
  private Item get(Item paramItem) {
    Item item;
    for (item = this.items[paramItem.hashCode % this.items.length]; item != null && (item.type != paramItem.type || !paramItem.isEqualTo(item)); item = item.next);
    return item;
  }
  
  private Item newString(String paramString) {
    this.key2.set(8, paramString, null, null);
    Item item2 = get(this.key2);
    Item item1 = item2;
    if (item2 == null) {
      this.pool.put12(8, newUTF8(paramString));
      int i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key2);
      put(item1);
    } 
    return item1;
  }
  
  private void put(Item paramItem) {
    if (this.index > this.threshold) {
      int j = this.items.length;
      int k = j * 2 + 1;
      Item[] arrayOfItem1 = new Item[k];
      while (--j >= 0) {
        for (Item item = this.items[j]; item != null; item = item1) {
          int m = item.hashCode % arrayOfItem1.length;
          Item item1 = item.next;
          item.next = arrayOfItem1[m];
          arrayOfItem1[m] = item;
        } 
        j--;
      } 
      this.items = arrayOfItem1;
      this.threshold = (int)(k * 0.75D);
    } 
    int i = paramItem.hashCode;
    Item[] arrayOfItem = this.items;
    i %= arrayOfItem.length;
    paramItem.next = arrayOfItem[i];
    arrayOfItem[i] = paramItem;
  }
  
  public Item newClassItem(String paramString) {
    this.key2.set(7, paramString, null, null);
    Item item2 = get(this.key2);
    Item item1 = item2;
    if (item2 == null) {
      this.pool.put12(7, newUTF8(paramString));
      int i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key2);
      put(item1);
    } 
    return item1;
  }
  
  Item newConstItem(Object paramObject) {
    if (paramObject instanceof Integer) {
      int i = ((Integer)paramObject).intValue();
      this.key.set(i);
      Item item = get(this.key);
      paramObject = item;
      if (item == null) {
        this.pool.putByte(3).putInt(i);
        i = this.index;
        this.index = i + 1;
        paramObject = new Item(i, this.key);
        put((Item)paramObject);
      } 
      return (Item)paramObject;
    } 
    if (paramObject instanceof String)
      return newString((String)paramObject); 
    if (paramObject instanceof Type) {
      paramObject = paramObject;
      if (((Type)paramObject).sort == 10) {
        paramObject = paramObject.getInternalName();
      } else {
        paramObject = paramObject.getDescriptor();
      } 
      return newClassItem((String)paramObject);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("value ");
    stringBuilder.append(paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  Item newFieldItem(String paramString1, String paramString2, String paramString3) {
    this.key3.set(9, paramString1, paramString2, paramString3);
    Item item2 = get(this.key3);
    Item item1 = item2;
    if (item2 == null) {
      int i = (newClassItem(paramString1)).index;
      int j = (newNameTypeItem(paramString2, paramString3)).index;
      this.pool.put12(9, i).putShort(j);
      i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key3);
      put(item1);
    } 
    return item1;
  }
  
  Item newMethodItem(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    int i;
    if (paramBoolean) {
      i = 11;
    } else {
      i = 10;
    } 
    this.key3.set(i, paramString1, paramString2, paramString3);
    Item item2 = get(this.key3);
    Item item1 = item2;
    if (item2 == null) {
      int j = (newClassItem(paramString1)).index;
      int k = (newNameTypeItem(paramString2, paramString3)).index;
      this.pool.put12(i, j).putShort(k);
      i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key3);
      put(item1);
    } 
    return item1;
  }
  
  public Item newNameTypeItem(String paramString1, String paramString2) {
    this.key2.set(12, paramString1, paramString2, null);
    Item item2 = get(this.key2);
    Item item1 = item2;
    if (item2 == null) {
      int i = newUTF8(paramString1);
      int j = newUTF8(paramString2);
      this.pool.put12(12, i).putShort(j);
      i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key2);
      put(item1);
    } 
    return item1;
  }
  
  public int newUTF8(String paramString) {
    this.key.set(1, paramString, null, null);
    Item item2 = get(this.key);
    Item item1 = item2;
    if (item2 == null) {
      this.pool.putByte(1).putUTF8(paramString);
      int i = this.index;
      this.index = i + 1;
      item1 = new Item(i, this.key);
      put(item1);
    } 
    return item1.index;
  }
  
  public byte[] toByteArray() {
    int i = this.interfaceCount;
    FieldWriter fieldWriter2 = this.firstField;
    i = i * 2 + 24;
    int j = 0;
    while (fieldWriter2 != null) {
      j++;
      i += fieldWriter2.getSize();
      fieldWriter2 = fieldWriter2.next;
    } 
    MethodWriter methodWriter2 = this.firstMethod;
    int k = 0;
    while (methodWriter2 != null) {
      k++;
      i += methodWriter2.getSize();
      methodWriter2 = methodWriter2.next;
    } 
    ByteVector byteVector = new ByteVector(i + this.pool.length);
    byteVector.putInt(-889275714).putInt(this.version);
    byteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
    byteVector.putShort(this.access & 0xFFF9FFFF).putShort(this.name).putShort(this.superName);
    byteVector.putShort(this.interfaceCount);
    for (i = 0; i < this.interfaceCount; i++)
      byteVector.putShort(this.interfaces[i]); 
    byteVector.putShort(j);
    for (FieldWriter fieldWriter1 = this.firstField; fieldWriter1 != null; fieldWriter1 = fieldWriter1.next)
      fieldWriter1.put(byteVector); 
    byteVector.putShort(k);
    for (MethodWriter methodWriter1 = this.firstMethod; methodWriter1 != null; methodWriter1 = methodWriter1.next)
      methodWriter1.put(byteVector); 
    byteVector.putShort(0);
    return byteVector.data;
  }
  
  public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString) {
    this.version = paramInt1;
    this.access = paramInt2;
    this.name = (newClassItem(paramString1)).index;
    this.thisName = paramString1;
    paramInt2 = 0;
    if (paramString2 == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = (newClassItem(paramString2)).index;
    } 
    this.superName = paramInt1;
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      this.interfaceCount = paramArrayOfString.length;
      this.interfaces = new int[this.interfaceCount];
      for (paramInt1 = paramInt2; paramInt1 < this.interfaceCount; paramInt1++)
        this.interfaces[paramInt1] = (newClassItem(paramArrayOfString[paramInt1])).index; 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\asm\ClassWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */