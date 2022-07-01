package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
  public static final LazyStringList EMPTY;
  
  private static final LazyStringArrayList EMPTY_LIST = new LazyStringArrayList();
  
  private final List<Object> list;
  
  static {
    EMPTY_LIST.makeImmutable();
    EMPTY = EMPTY_LIST;
  }
  
  public LazyStringArrayList() {
    this(10);
  }
  
  public LazyStringArrayList(int paramInt) {
    this(new ArrayList(paramInt));
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList) {
    this.list = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  private LazyStringArrayList(ArrayList<Object> paramArrayList) {
    this.list = paramArrayList;
  }
  
  public LazyStringArrayList(List<String> paramList) {
    this(new ArrayList(paramList));
  }
  
  private void add(int paramInt, ByteString paramByteString) {
    ensureIsMutable();
    this.list.add(paramInt, paramByteString);
    this.modCount++;
  }
  
  private void add(int paramInt, byte[] paramArrayOfbyte) {
    ensureIsMutable();
    this.list.add(paramInt, paramArrayOfbyte);
    this.modCount++;
  }
  
  private static byte[] asByteArray(Object paramObject) {
    return (paramObject instanceof byte[]) ? (byte[])paramObject : ((paramObject instanceof String) ? Internal.toByteArray((String)paramObject) : ((ByteString)paramObject).toByteArray());
  }
  
  private static ByteString asByteString(Object paramObject) {
    return (paramObject instanceof ByteString) ? (ByteString)paramObject : ((paramObject instanceof String) ? ByteString.copyFromUtf8((String)paramObject) : ByteString.copyFrom((byte[])paramObject));
  }
  
  private static String asString(Object paramObject) {
    return (paramObject instanceof String) ? (String)paramObject : ((paramObject instanceof ByteString) ? ((ByteString)paramObject).toStringUtf8() : Internal.toStringUtf8((byte[])paramObject));
  }
  
  static LazyStringArrayList emptyList() {
    return EMPTY_LIST;
  }
  
  private Object setAndReturn(int paramInt, ByteString paramByteString) {
    ensureIsMutable();
    return this.list.set(paramInt, paramByteString);
  }
  
  private Object setAndReturn(int paramInt, byte[] paramArrayOfbyte) {
    ensureIsMutable();
    return this.list.set(paramInt, paramArrayOfbyte);
  }
  
  public void add(int paramInt, String paramString) {
    ensureIsMutable();
    this.list.add(paramInt, paramString);
    this.modCount++;
  }
  
  public void add(ByteString paramByteString) {
    ensureIsMutable();
    this.list.add(paramByteString);
    this.modCount++;
  }
  
  public void add(byte[] paramArrayOfbyte) {
    ensureIsMutable();
    this.list.add(paramArrayOfbyte);
    this.modCount++;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection) {
    ensureIsMutable();
    Collection<? extends String> collection = paramCollection;
    if (paramCollection instanceof LazyStringList)
      collection = (Collection)((LazyStringList)paramCollection).getUnderlyingElements(); 
    boolean bool = this.list.addAll(paramInt, collection);
    this.modCount++;
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection) {
    return addAll(size(), paramCollection);
  }
  
  public boolean addAllByteArray(Collection<byte[]> paramCollection) {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount++;
    return bool;
  }
  
  public boolean addAllByteString(Collection<? extends ByteString> paramCollection) {
    ensureIsMutable();
    boolean bool = this.list.addAll(paramCollection);
    this.modCount++;
    return bool;
  }
  
  public List<byte[]> asByteArrayList() {
    return new ByteArrayListView(this);
  }
  
  public List<ByteString> asByteStringList() {
    return new ByteStringListView(this);
  }
  
  public void clear() {
    ensureIsMutable();
    this.list.clear();
    this.modCount++;
  }
  
  public String get(int paramInt) {
    Object object = this.list.get(paramInt);
    if (object instanceof String)
      return (String)object; 
    if (object instanceof ByteString) {
      object = object;
      String str1 = object.toStringUtf8();
      if (object.isValidUtf8())
        this.list.set(paramInt, str1); 
      return str1;
    } 
    object = object;
    String str = Internal.toStringUtf8((byte[])object);
    if (Internal.isValidUtf8((byte[])object))
      this.list.set(paramInt, str); 
    return str;
  }
  
  public byte[] getByteArray(int paramInt) {
    Object object = this.list.get(paramInt);
    byte[] arrayOfByte = asByteArray(object);
    if (arrayOfByte != object)
      this.list.set(paramInt, arrayOfByte); 
    return arrayOfByte;
  }
  
  public ByteString getByteString(int paramInt) {
    Object object = this.list.get(paramInt);
    ByteString byteString = asByteString(object);
    if (byteString != object)
      this.list.set(paramInt, byteString); 
    return byteString;
  }
  
  public Object getRaw(int paramInt) {
    return this.list.get(paramInt);
  }
  
  public List<?> getUnderlyingElements() {
    return Collections.unmodifiableList(this.list);
  }
  
  public LazyStringList getUnmodifiableView() {
    return (LazyStringList)(isModifiable() ? new UnmodifiableLazyStringList(this) : this);
  }
  
  public void mergeFrom(LazyStringList paramLazyStringList) {
    ensureIsMutable();
    for (Object object : paramLazyStringList.getUnderlyingElements()) {
      if (object instanceof byte[]) {
        object = object;
        this.list.add(Arrays.copyOf((byte[])object, object.length));
        continue;
      } 
      this.list.add(object);
    } 
  }
  
  public LazyStringArrayList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= size()) {
      ArrayList<Object> arrayList = new ArrayList(paramInt);
      arrayList.addAll(this.list);
      return new LazyStringArrayList(arrayList);
    } 
    throw new IllegalArgumentException();
  }
  
  public String remove(int paramInt) {
    ensureIsMutable();
    Object object = this.list.remove(paramInt);
    this.modCount++;
    return asString(object);
  }
  
  public String set(int paramInt, String paramString) {
    ensureIsMutable();
    return asString(this.list.set(paramInt, paramString));
  }
  
  public void set(int paramInt, ByteString paramByteString) {
    setAndReturn(paramInt, paramByteString);
  }
  
  public void set(int paramInt, byte[] paramArrayOfbyte) {
    setAndReturn(paramInt, paramArrayOfbyte);
  }
  
  public int size() {
    return this.list.size();
  }
  
  static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
    private final LazyStringArrayList list;
    
    ByteArrayListView(LazyStringArrayList param1LazyStringArrayList) {
      this.list = param1LazyStringArrayList;
    }
    
    public void add(int param1Int, byte[] param1ArrayOfbyte) {
      this.list.add(param1Int, param1ArrayOfbyte);
      this.modCount++;
    }
    
    public byte[] get(int param1Int) {
      return this.list.getByteArray(param1Int);
    }
    
    public byte[] remove(int param1Int) {
      String str = this.list.remove(param1Int);
      this.modCount++;
      return LazyStringArrayList.asByteArray(str);
    }
    
    public byte[] set(int param1Int, byte[] param1ArrayOfbyte) {
      Object object = this.list.setAndReturn(param1Int, param1ArrayOfbyte);
      this.modCount++;
      return LazyStringArrayList.asByteArray(object);
    }
    
    public int size() {
      return this.list.size();
    }
  }
  
  static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
    private final LazyStringArrayList list;
    
    ByteStringListView(LazyStringArrayList param1LazyStringArrayList) {
      this.list = param1LazyStringArrayList;
    }
    
    public void add(int param1Int, ByteString param1ByteString) {
      this.list.add(param1Int, param1ByteString);
      this.modCount++;
    }
    
    public ByteString get(int param1Int) {
      return this.list.getByteString(param1Int);
    }
    
    public ByteString remove(int param1Int) {
      String str = this.list.remove(param1Int);
      this.modCount++;
      return LazyStringArrayList.asByteString(str);
    }
    
    public ByteString set(int param1Int, ByteString param1ByteString) {
      Object object = this.list.setAndReturn(param1Int, param1ByteString);
      this.modCount++;
      return LazyStringArrayList.asByteString(object);
    }
    
    public int size() {
      return this.list.size();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\LazyStringArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */