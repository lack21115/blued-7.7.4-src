package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {
  private final LazyStringList list;
  
  public UnmodifiableLazyStringList(LazyStringList paramLazyStringList) {
    this.list = paramLazyStringList;
  }
  
  public void add(ByteString paramByteString) {
    throw new UnsupportedOperationException();
  }
  
  public void add(byte[] paramArrayOfbyte) {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAllByteArray(Collection<byte[]> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAllByteString(Collection<? extends ByteString> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public List<byte[]> asByteArrayList() {
    return (List)Collections.unmodifiableList((List)this.list.asByteArrayList());
  }
  
  public List<ByteString> asByteStringList() {
    return Collections.unmodifiableList(this.list.asByteStringList());
  }
  
  public String get(int paramInt) {
    return this.list.get(paramInt);
  }
  
  public byte[] getByteArray(int paramInt) {
    return this.list.getByteArray(paramInt);
  }
  
  public ByteString getByteString(int paramInt) {
    return this.list.getByteString(paramInt);
  }
  
  public Object getRaw(int paramInt) {
    return this.list.getRaw(paramInt);
  }
  
  public List<?> getUnderlyingElements() {
    return this.list.getUnderlyingElements();
  }
  
  public LazyStringList getUnmodifiableView() {
    return this;
  }
  
  public Iterator<String> iterator() {
    return new Iterator<String>() {
        Iterator<String> iter = UnmodifiableLazyStringList.this.list.iterator();
        
        public boolean hasNext() {
          return this.iter.hasNext();
        }
        
        public String next() {
          return this.iter.next();
        }
        
        public void remove() {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  public ListIterator<String> listIterator(final int index) {
    return new ListIterator<String>() {
        ListIterator<String> iter = UnmodifiableLazyStringList.this.list.listIterator(index);
        
        public void add(String param1String) {
          throw new UnsupportedOperationException();
        }
        
        public boolean hasNext() {
          return this.iter.hasNext();
        }
        
        public boolean hasPrevious() {
          return this.iter.hasPrevious();
        }
        
        public String next() {
          return this.iter.next();
        }
        
        public int nextIndex() {
          return this.iter.nextIndex();
        }
        
        public String previous() {
          return this.iter.previous();
        }
        
        public int previousIndex() {
          return this.iter.previousIndex();
        }
        
        public void remove() {
          throw new UnsupportedOperationException();
        }
        
        public void set(String param1String) {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  public void mergeFrom(LazyStringList paramLazyStringList) {
    throw new UnsupportedOperationException();
  }
  
  public void set(int paramInt, ByteString paramByteString) {
    throw new UnsupportedOperationException();
  }
  
  public void set(int paramInt, byte[] paramArrayOfbyte) {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    return this.list.size();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnmodifiableLazyStringList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */