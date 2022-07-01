package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends AbstractMessageLite.Builder<MessageType, BuilderType>> implements MessageLite {
  protected int memoizedHashCode = 0;
  
  @Deprecated
  protected static <T> void addAll(Iterable<T> paramIterable, Collection<? super T> paramCollection) {
    Builder.addAll(paramIterable, (List<? super T>)paramCollection);
  }
  
  protected static <T> void addAll(Iterable<T> paramIterable, List<? super T> paramList) {
    Builder.addAll(paramIterable, paramList);
  }
  
  public static void checkByteStringIsUtf8(ByteString paramByteString) throws IllegalArgumentException {
    if (paramByteString.isValidUtf8())
      return; 
    throw new IllegalArgumentException("Byte string is not UTF-8.");
  }
  
  private String getSerializingExceptionMessage(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Serializing ");
    stringBuilder.append(getClass().getName());
    stringBuilder.append(" to a ");
    stringBuilder.append(paramString);
    stringBuilder.append(" threw an IOException (should never happen).");
    return stringBuilder.toString();
  }
  
  int getMemoizedSerializedSize() {
    throw new UnsupportedOperationException();
  }
  
  int getSerializedSize(Schema<AbstractMessageLite> paramSchema) {
    int j = getMemoizedSerializedSize();
    int i = j;
    if (j == -1) {
      i = paramSchema.getSerializedSize(this);
      setMemoizedSerializedSize(i);
    } 
    return i;
  }
  
  UninitializedMessageException newUninitializedMessageException() {
    return new UninitializedMessageException(this);
  }
  
  void setMemoizedSerializedSize(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public byte[] toByteArray() {
    try {
      byte[] arrayOfByte = new byte[getSerializedSize()];
      CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(arrayOfByte);
      writeTo(codedOutputStream);
      codedOutputStream.checkNoSpaceLeft();
      return arrayOfByte;
    } catch (IOException iOException) {
      throw new RuntimeException(getSerializingExceptionMessage("byte array"), iOException);
    } 
  }
  
  public ByteString toByteString() {
    try {
      ByteString.CodedBuilder codedBuilder = ByteString.newCodedBuilder(getSerializedSize());
      writeTo(codedBuilder.getCodedOutput());
      return codedBuilder.build();
    } catch (IOException iOException) {
      throw new RuntimeException(getSerializingExceptionMessage("ByteString"), iOException);
    } 
  }
  
  public void writeDelimitedTo(OutputStream paramOutputStream) throws IOException {
    int i = getSerializedSize();
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(i) + i));
    codedOutputStream.writeRawVarint32(i);
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    CodedOutputStream codedOutputStream = CodedOutputStream.newInstance(paramOutputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
    writeTo(codedOutputStream);
    codedOutputStream.flush();
  }
  
  public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
    @Deprecated
    protected static <T> void addAll(Iterable<T> param1Iterable, Collection<? super T> param1Collection) {
      addAll(param1Iterable, (List<? super T>)param1Collection);
    }
    
    public static <T> void addAll(Iterable<T> param1Iterable, List<? super T> param1List) {
      String str;
      Internal.checkNotNull(param1Iterable);
      if (param1Iterable instanceof LazyStringList) {
        List<?> list = ((LazyStringList)param1Iterable).getUnderlyingElements();
        param1Iterable = (LazyStringList)param1List;
        int i = param1List.size();
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
          list = (List<?>)iterator.next();
          if (list == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Element at index ");
            stringBuilder.append(param1Iterable.size() - i);
            stringBuilder.append(" is null.");
            str = stringBuilder.toString();
            for (int j = param1Iterable.size() - 1; j >= i; j--)
              param1Iterable.remove(j); 
            throw new NullPointerException(str);
          } 
          if (list instanceof ByteString) {
            param1Iterable.add((ByteString)list);
            continue;
          } 
          param1Iterable.add((String)list);
        } 
      } else {
        if (param1Iterable instanceof PrimitiveNonBoxingCollection) {
          str.addAll((Collection)param1Iterable);
          return;
        } 
        addAllCheckingNulls(param1Iterable, (List<? super T>)str);
      } 
    }
    
    private static <T> void addAllCheckingNulls(Iterable<T> param1Iterable, List<? super T> param1List) {
      if (param1List instanceof ArrayList && param1Iterable instanceof Collection)
        ((ArrayList)param1List).ensureCapacity(param1List.size() + ((Collection)param1Iterable).size()); 
      int i = param1List.size();
      Iterator<T> iterator = param1Iterable.iterator();
      while (iterator.hasNext()) {
        T t = iterator.next();
        if (t == null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Element at index ");
          stringBuilder.append(param1List.size() - i);
          stringBuilder.append(" is null.");
          String str = stringBuilder.toString();
          for (int j = param1List.size() - 1; j >= i; j--)
            param1List.remove(j); 
          throw new NullPointerException(str);
        } 
        param1List.add(t);
      } 
    }
    
    private String getReadingExceptionMessage(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Reading ");
      stringBuilder.append(getClass().getName());
      stringBuilder.append(" from a ");
      stringBuilder.append(param1String);
      stringBuilder.append(" threw an IOException (should never happen).");
      return stringBuilder.toString();
    }
    
    protected static UninitializedMessageException newUninitializedMessageException(MessageLite param1MessageLite) {
      return new UninitializedMessageException(param1MessageLite);
    }
    
    public abstract BuilderType clone();
    
    protected abstract BuilderType internalMergeFrom(MessageType param1MessageType);
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException {
      return mergeDelimitedFrom(param1InputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      int i = param1InputStream.read();
      if (i == -1)
        return false; 
      mergeFrom(new LimitedInputStream(param1InputStream, CodedInputStream.readRawVarint32(i, param1InputStream)), param1ExtensionRegistryLite);
      return true;
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = param1ByteString.newCodedInput();
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = param1ByteString.newCodedInput();
        mergeFrom(codedInputStream, param1ExtensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("ByteString"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(CodedInputStream param1CodedInputStream) throws IOException {
      return mergeFrom(param1CodedInputStream, ExtensionRegistryLite.getEmptyRegistry());
    }
    
    public abstract BuilderType mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    public BuilderType mergeFrom(MessageLite param1MessageLite) {
      if (getDefaultInstanceForType().getClass().isInstance(param1MessageLite))
        return internalMergeFrom((MessageType)param1MessageLite); 
      throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream) throws IOException {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(param1InputStream);
      mergeFrom(codedInputStream);
      codedInputStream.checkLastTagWas(0);
      return (BuilderType)this;
    }
    
    public BuilderType mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException {
      CodedInputStream codedInputStream = CodedInputStream.newInstance(param1InputStream);
      mergeFrom(codedInputStream, param1ExtensionRegistryLite);
      codedInputStream.checkLastTagWas(0);
      return (BuilderType)this;
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte, param1Int1, param1Int2);
        mergeFrom(codedInputStream);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      try {
        CodedInputStream codedInputStream = CodedInputStream.newInstance(param1ArrayOfbyte, param1Int1, param1Int2);
        mergeFrom(codedInputStream, param1ExtensionRegistryLite);
        codedInputStream.checkLastTagWas(0);
        return (BuilderType)this;
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        throw invalidProtocolBufferException;
      } catch (IOException iOException) {
        throw new RuntimeException(getReadingExceptionMessage("byte array"), iOException);
      } 
    }
    
    public BuilderType mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException {
      return mergeFrom(param1ArrayOfbyte, 0, param1ArrayOfbyte.length, param1ExtensionRegistryLite);
    }
    
    static final class LimitedInputStream extends FilterInputStream {
      private int limit;
      
      LimitedInputStream(InputStream param2InputStream, int param2Int) {
        super(param2InputStream);
        this.limit = param2Int;
      }
      
      public int available() throws IOException {
        return Math.min(super.available(), this.limit);
      }
      
      public int read() throws IOException {
        if (this.limit <= 0)
          return -1; 
        int i = super.read();
        if (i >= 0)
          this.limit--; 
        return i;
      }
      
      public int read(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) throws IOException {
        int i = this.limit;
        if (i <= 0)
          return -1; 
        param2Int1 = super.read(param2ArrayOfbyte, param2Int1, Math.min(param2Int2, i));
        if (param2Int1 >= 0)
          this.limit -= param2Int1; 
        return param2Int1;
      }
      
      public long skip(long param2Long) throws IOException {
        param2Long = super.skip(Math.min(param2Long, this.limit));
        if (param2Long >= 0L)
          this.limit = (int)(this.limit - param2Long); 
        return param2Long;
      }
    }
  }
  
  static final class LimitedInputStream extends FilterInputStream {
    private int limit;
    
    LimitedInputStream(InputStream param1InputStream, int param1Int) {
      super(param1InputStream);
      this.limit = param1Int;
    }
    
    public int available() throws IOException {
      return Math.min(super.available(), this.limit);
    }
    
    public int read() throws IOException {
      if (this.limit <= 0)
        return -1; 
      int i = super.read();
      if (i >= 0)
        this.limit--; 
      return i;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      int i = this.limit;
      if (i <= 0)
        return -1; 
      param1Int1 = super.read(param1ArrayOfbyte, param1Int1, Math.min(param1Int2, i));
      if (param1Int1 >= 0)
        this.limit -= param1Int1; 
      return param1Int1;
    }
    
    public long skip(long param1Long) throws IOException {
      param1Long = super.skip(Math.min(param1Long, this.limit));
      if (param1Long >= 0L)
        this.limit = (int)(this.limit - param1Long); 
      return param1Long;
    }
  }
  
  public static interface InternalOneOfEnum {
    int getNumber();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\AbstractMessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */