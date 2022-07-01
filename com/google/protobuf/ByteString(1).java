package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public abstract class ByteString implements Serializable, Iterable<Byte> {
  static {
    if (Android.isOnAndroidDevice()) {
      SystemByteArrayCopier systemByteArrayCopier = new SystemByteArrayCopier();
    } else {
      arraysByteArrayCopier = new ArraysByteArrayCopier();
    } 
    byteArrayCopier = arraysByteArrayCopier;
    UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() {
        public int compare(ByteString param1ByteString1, ByteString param1ByteString2) {
          ByteString.ByteIterator byteIterator1 = param1ByteString1.iterator();
          ByteString.ByteIterator byteIterator2 = param1ByteString2.iterator();
          while (byteIterator1.hasNext() && byteIterator2.hasNext()) {
            int i = Integer.compare(ByteString.toInt(byteIterator1.nextByte()), ByteString.toInt(byteIterator2.nextByte()));
            if (i != 0)
              return i; 
          } 
          return Integer.compare(param1ByteString1.size(), param1ByteString2.size());
        }
      };
  }
  
  private static ByteString balancedConcat(Iterator<ByteString> paramIterator, int paramInt) {
    if (paramInt >= 1) {
      if (paramInt == 1)
        return paramIterator.next(); 
      int i = paramInt >>> 1;
      return balancedConcat(paramIterator, i).concat(balancedConcat(paramIterator, paramInt - i));
    } 
    throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  static void checkIndex(int paramInt1, int paramInt2) {
    if ((paramInt2 - paramInt1 + 1 | paramInt1) < 0) {
      if (paramInt1 < 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Index < 0: ");
        stringBuilder1.append(paramInt1);
        throw new ArrayIndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Index > length: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", ");
      stringBuilder.append(paramInt2);
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    } 
  }
  
  static int checkRange(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0) {
      if (paramInt1 >= 0) {
        if (paramInt2 < paramInt1) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Beginning index larger than ending index: ");
          stringBuilder2.append(paramInt1);
          stringBuilder2.append(", ");
          stringBuilder2.append(paramInt2);
          throw new IndexOutOfBoundsException(stringBuilder2.toString());
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("End index: ");
        stringBuilder1.append(paramInt2);
        stringBuilder1.append(" >= ");
        stringBuilder1.append(paramInt3);
        throw new IndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Beginning index: ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    } 
    return i;
  }
  
  public static ByteString copyFrom(Iterable<ByteString> paramIterable) {
    int i;
    if (!(paramIterable instanceof Collection)) {
      int j = 0;
      Iterator<ByteString> iterator = paramIterable.iterator();
      while (true) {
        i = j;
        if (iterator.hasNext()) {
          iterator.next();
          j++;
          continue;
        } 
        break;
      } 
    } else {
      i = ((Collection)paramIterable).size();
    } 
    return (i == 0) ? EMPTY : balancedConcat(paramIterable.iterator(), i);
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2) throws UnsupportedEncodingException {
    return new LiteralByteString(paramString1.getBytes(paramString2));
  }
  
  public static ByteString copyFrom(String paramString, Charset paramCharset) {
    return new LiteralByteString(paramString.getBytes(paramCharset));
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer) {
    return copyFrom(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer, int paramInt) {
    checkRange(0, paramInt, paramByteBuffer.remaining());
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new LiteralByteString(arrayOfByte);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfbyte) {
    return copyFrom(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    checkRange(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    return new LiteralByteString(byteArrayCopier.copyFrom(paramArrayOfbyte, paramInt1, paramInt2));
  }
  
  public static ByteString copyFromUtf8(String paramString) {
    return new LiteralByteString(paramString.getBytes(Internal.UTF_8));
  }
  
  static CodedBuilder newCodedBuilder(int paramInt) {
    return new CodedBuilder(paramInt);
  }
  
  public static Output newOutput() {
    return new Output(128);
  }
  
  public static Output newOutput(int paramInt) {
    return new Output(paramInt);
  }
  
  private static ByteString readChunk(InputStream paramInputStream, int paramInt) throws IOException {
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    for (i = 0; i < paramInt; i += j) {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1)
        break; 
    } 
    return (i == 0) ? null : copyFrom(arrayOfByte, 0, i);
  }
  
  public static ByteString readFrom(InputStream paramInputStream) throws IOException {
    return readFrom(paramInputStream, 256, 8192);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt) throws IOException {
    return readFrom(paramInputStream, paramInt, paramInt);
  }
  
  public static ByteString readFrom(InputStream paramInputStream, int paramInt1, int paramInt2) throws IOException {
    ArrayList<ByteString> arrayList = new ArrayList();
    while (true) {
      ByteString byteString = readChunk(paramInputStream, paramInt1);
      if (byteString == null)
        return copyFrom(arrayList); 
      arrayList.add(byteString);
      paramInt1 = Math.min(paramInt1 * 2, paramInt2);
    } 
  }
  
  private static int toInt(byte paramByte) {
    return paramByte & 0xFF;
  }
  
  private String truncateAndEscapeForDisplay() {
    if (size() <= 50)
      return TextFormatEscaper.escapeBytes(this); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TextFormatEscaper.escapeBytes(substring(0, 47)));
    stringBuilder.append("...");
    return stringBuilder.toString();
  }
  
  public static Comparator<ByteString> unsignedLexicographicalComparator() {
    return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
  }
  
  static ByteString wrap(ByteBuffer paramByteBuffer) {
    if (paramByteBuffer.hasArray()) {
      int i = paramByteBuffer.arrayOffset();
      return wrap(paramByteBuffer.array(), i + paramByteBuffer.position(), paramByteBuffer.remaining());
    } 
    return new NioByteString(paramByteBuffer);
  }
  
  static ByteString wrap(byte[] paramArrayOfbyte) {
    return new LiteralByteString(paramArrayOfbyte);
  }
  
  static ByteString wrap(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return new BoundedByteString(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public abstract ByteBuffer asReadOnlyByteBuffer();
  
  public abstract List<ByteBuffer> asReadOnlyByteBufferList();
  
  public abstract byte byteAt(int paramInt);
  
  public final ByteString concat(ByteString paramByteString) {
    if (Integer.MAX_VALUE - size() >= paramByteString.size())
      return RopeByteString.concatenate(this, paramByteString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ByteString would be too long: ");
    stringBuilder.append(size());
    stringBuilder.append("+");
    stringBuilder.append(paramByteString.size());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public abstract void copyTo(ByteBuffer paramByteBuffer);
  
  public void copyTo(byte[] paramArrayOfbyte, int paramInt) {
    copyTo(paramArrayOfbyte, 0, paramInt, size());
  }
  
  @Deprecated
  public final void copyTo(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    checkRange(paramInt1, paramInt1 + paramInt3, size());
    checkRange(paramInt2, paramInt2 + paramInt3, paramArrayOfbyte.length);
    if (paramInt3 > 0)
      copyToInternal(paramArrayOfbyte, paramInt1, paramInt2, paramInt3); 
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3);
  
  public final boolean endsWith(ByteString paramByteString) {
    return (size() >= paramByteString.size() && substring(size() - paramByteString.size()).equals(paramByteString));
  }
  
  public abstract boolean equals(Object paramObject);
  
  protected abstract int getTreeDepth();
  
  public final int hashCode() {
    int j = this.hash;
    int i = j;
    if (j == 0) {
      i = size();
      j = partialHash(i, 0, i);
      i = j;
      if (j == 0)
        i = 1; 
      this.hash = i;
    } 
    return i;
  }
  
  abstract byte internalByteAt(int paramInt);
  
  protected abstract boolean isBalanced();
  
  public final boolean isEmpty() {
    return (size() == 0);
  }
  
  public abstract boolean isValidUtf8();
  
  public ByteIterator iterator() {
    return new AbstractByteIterator() {
        private final int limit = ByteString.this.size();
        
        private int position = 0;
        
        public boolean hasNext() {
          return (this.position < this.limit);
        }
        
        public byte nextByte() {
          int i = this.position;
          if (i < this.limit) {
            this.position = i + 1;
            return ByteString.this.internalByteAt(i);
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  public abstract CodedInputStream newCodedInput();
  
  public abstract InputStream newInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  protected final int peekCachedHashCode() {
    return this.hash;
  }
  
  public abstract int size();
  
  public final boolean startsWith(ByteString paramByteString) {
    int i = size();
    int j = paramByteString.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= j) {
      bool1 = bool2;
      if (substring(0, paramByteString.size()).equals(paramByteString))
        bool1 = true; 
    } 
    return bool1;
  }
  
  public final ByteString substring(int paramInt) {
    return substring(paramInt, size());
  }
  
  public abstract ByteString substring(int paramInt1, int paramInt2);
  
  public final byte[] toByteArray() {
    int i = size();
    if (i == 0)
      return Internal.EMPTY_BYTE_ARRAY; 
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public final String toString() {
    return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay() });
  }
  
  public final String toString(String paramString) throws UnsupportedEncodingException {
    try {
      return toString(Charset.forName(paramString));
    } catch (UnsupportedCharsetException unsupportedCharsetException) {
      UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(paramString);
      unsupportedEncodingException.initCause(unsupportedCharsetException);
      throw unsupportedEncodingException;
    } 
  }
  
  public final String toString(Charset paramCharset) {
    return (size() == 0) ? "" : toStringInternal(paramCharset);
  }
  
  protected abstract String toStringInternal(Charset paramCharset);
  
  public final String toStringUtf8() {
    return toString(Internal.UTF_8);
  }
  
  abstract void writeTo(ByteOutput paramByteOutput) throws IOException;
  
  public abstract void writeTo(OutputStream paramOutputStream) throws IOException;
  
  final void writeTo(OutputStream paramOutputStream, int paramInt1, int paramInt2) throws IOException {
    checkRange(paramInt1, paramInt1 + paramInt2, size());
    if (paramInt2 > 0)
      writeToInternal(paramOutputStream, paramInt1, paramInt2); 
  }
  
  abstract void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2) throws IOException;
  
  abstract void writeToReverse(ByteOutput paramByteOutput) throws IOException;
  
  static {
    ArraysByteArrayCopier arraysByteArrayCopier;
  }
  
  static final int CONCATENATE_BY_COPY_SIZE = 128;
  
  public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
  
  static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
  
  static final int MIN_READ_FROM_CHUNK_SIZE = 256;
  
  private static final int UNSIGNED_BYTE_MASK = 255;
  
  private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
  
  private static final ByteArrayCopier byteArrayCopier;
  
  private int hash = 0;
  
  static abstract class AbstractByteIterator implements ByteIterator {
    public final Byte next() {
      return Byte.valueOf(nextByte());
    }
    
    public final void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class ArraysByteArrayCopier implements ByteArrayCopier {
    private ArraysByteArrayCopier() {}
    
    public byte[] copyFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      return Arrays.copyOfRange(param1ArrayOfbyte, param1Int1, param1Int2 + param1Int1);
    }
  }
  
  static final class BoundedByteString extends LiteralByteString {
    private static final long serialVersionUID = 1L;
    
    private final int bytesLength;
    
    private final int bytesOffset;
    
    BoundedByteString(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      super(param1ArrayOfbyte);
      checkRange(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      this.bytesOffset = param1Int1;
      this.bytesLength = param1Int2;
    }
    
    private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException {
      throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
    }
    
    public byte byteAt(int param1Int) {
      checkIndex(param1Int, size());
      return this.bytes[this.bytesOffset + param1Int];
    }
    
    protected void copyToInternal(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
      System.arraycopy(this.bytes, getOffsetIntoBytes() + param1Int1, param1ArrayOfbyte, param1Int2, param1Int3);
    }
    
    protected int getOffsetIntoBytes() {
      return this.bytesOffset;
    }
    
    byte internalByteAt(int param1Int) {
      return this.bytes[this.bytesOffset + param1Int];
    }
    
    public int size() {
      return this.bytesLength;
    }
    
    Object writeReplace() {
      return ByteString.wrap(toByteArray());
    }
  }
  
  static interface ByteArrayCopier {
    byte[] copyFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2);
  }
  
  public static interface ByteIterator extends Iterator<Byte> {
    byte nextByte();
  }
  
  static final class CodedBuilder {
    private final byte[] buffer;
    
    private final CodedOutputStream output;
    
    private CodedBuilder(int param1Int) {
      this.buffer = new byte[param1Int];
      this.output = CodedOutputStream.newInstance(this.buffer);
    }
    
    public ByteString build() {
      this.output.checkNoSpaceLeft();
      return new ByteString.LiteralByteString(this.buffer);
    }
    
    public CodedOutputStream getCodedOutput() {
      return this.output;
    }
  }
  
  static abstract class LeafByteString extends ByteString {
    abstract boolean equalsRange(ByteString param1ByteString, int param1Int1, int param1Int2);
    
    protected final int getTreeDepth() {
      return 0;
    }
    
    protected final boolean isBalanced() {
      return true;
    }
    
    void writeToReverse(ByteOutput param1ByteOutput) throws IOException {
      writeTo(param1ByteOutput);
    }
  }
  
  static class LiteralByteString extends LeafByteString {
    private static final long serialVersionUID = 1L;
    
    protected final byte[] bytes;
    
    LiteralByteString(byte[] param1ArrayOfbyte) {
      if (param1ArrayOfbyte != null) {
        this.bytes = param1ArrayOfbyte;
        return;
      } 
      throw new NullPointerException();
    }
    
    public final ByteBuffer asReadOnlyByteBuffer() {
      return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }
    
    public final List<ByteBuffer> asReadOnlyByteBufferList() {
      return Collections.singletonList(asReadOnlyByteBuffer());
    }
    
    public byte byteAt(int param1Int) {
      return this.bytes[param1Int];
    }
    
    public final void copyTo(ByteBuffer param1ByteBuffer) {
      param1ByteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected void copyToInternal(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
      System.arraycopy(this.bytes, param1Int1, param1ArrayOfbyte, param1Int2, param1Int3);
    }
    
    public final boolean equals(Object param1Object) {
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof ByteString))
        return false; 
      if (size() != ((ByteString)param1Object).size())
        return false; 
      if (size() == 0)
        return true; 
      if (param1Object instanceof LiteralByteString) {
        param1Object = param1Object;
        int i = peekCachedHashCode();
        int j = param1Object.peekCachedHashCode();
        return (i != 0 && j != 0 && i != j) ? false : equalsRange((ByteString)param1Object, 0, size());
      } 
      return param1Object.equals(this);
    }
    
    final boolean equalsRange(ByteString param1ByteString, int param1Int1, int param1Int2) {
      if (param1Int2 <= param1ByteString.size()) {
        int i = param1Int1 + param1Int2;
        if (i <= param1ByteString.size()) {
          if (param1ByteString instanceof LiteralByteString) {
            param1ByteString = param1ByteString;
            byte[] arrayOfByte1 = this.bytes;
            byte[] arrayOfByte2 = ((LiteralByteString)param1ByteString).bytes;
            int j = getOffsetIntoBytes();
            i = getOffsetIntoBytes();
            for (param1Int1 = param1ByteString.getOffsetIntoBytes() + param1Int1; i < j + param1Int2; param1Int1++) {
              if (arrayOfByte1[i] != arrayOfByte2[param1Int1])
                return false; 
              i++;
            } 
            return true;
          } 
          return param1ByteString.substring(param1Int1, i).equals(substring(0, param1Int2));
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Ran off end of other: ");
        stringBuilder1.append(param1Int1);
        stringBuilder1.append(", ");
        stringBuilder1.append(param1Int2);
        stringBuilder1.append(", ");
        stringBuilder1.append(param1ByteString.size());
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Length too large: ");
      stringBuilder.append(param1Int2);
      stringBuilder.append(size());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    protected int getOffsetIntoBytes() {
      return 0;
    }
    
    byte internalByteAt(int param1Int) {
      return this.bytes[param1Int];
    }
    
    public final boolean isValidUtf8() {
      int i = getOffsetIntoBytes();
      return Utf8.isValidUtf8(this.bytes, i, size() + i);
    }
    
    public final CodedInputStream newCodedInput() {
      return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
    }
    
    public final InputStream newInput() {
      return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }
    
    protected final int partialHash(int param1Int1, int param1Int2, int param1Int3) {
      return Internal.partialHash(param1Int1, this.bytes, getOffsetIntoBytes() + param1Int2, param1Int3);
    }
    
    protected final int partialIsValidUtf8(int param1Int1, int param1Int2, int param1Int3) {
      param1Int2 = getOffsetIntoBytes() + param1Int2;
      return Utf8.partialIsValidUtf8(param1Int1, this.bytes, param1Int2, param1Int3 + param1Int2);
    }
    
    public int size() {
      return this.bytes.length;
    }
    
    public final ByteString substring(int param1Int1, int param1Int2) {
      param1Int2 = checkRange(param1Int1, param1Int2, size());
      return (param1Int2 == 0) ? ByteString.EMPTY : new ByteString.BoundedByteString(this.bytes, getOffsetIntoBytes() + param1Int1, param1Int2);
    }
    
    protected final String toStringInternal(Charset param1Charset) {
      return new String(this.bytes, getOffsetIntoBytes(), size(), param1Charset);
    }
    
    final void writeTo(ByteOutput param1ByteOutput) throws IOException {
      param1ByteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
    }
    
    public final void writeTo(OutputStream param1OutputStream) throws IOException {
      param1OutputStream.write(toByteArray());
    }
    
    final void writeToInternal(OutputStream param1OutputStream, int param1Int1, int param1Int2) throws IOException {
      param1OutputStream.write(this.bytes, getOffsetIntoBytes() + param1Int1, param1Int2);
    }
  }
  
  public static final class Output extends OutputStream {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    
    private byte[] buffer;
    
    private int bufferPos;
    
    private final ArrayList<ByteString> flushedBuffers;
    
    private int flushedBuffersTotalBytes;
    
    private final int initialCapacity;
    
    Output(int param1Int) {
      if (param1Int >= 0) {
        this.initialCapacity = param1Int;
        this.flushedBuffers = new ArrayList<ByteString>();
        this.buffer = new byte[param1Int];
        return;
      } 
      throw new IllegalArgumentException("Buffer size < 0");
    }
    
    private byte[] copyArray(byte[] param1ArrayOfbyte, int param1Int) {
      byte[] arrayOfByte = new byte[param1Int];
      System.arraycopy(param1ArrayOfbyte, 0, arrayOfByte, 0, Math.min(param1ArrayOfbyte.length, param1Int));
      return arrayOfByte;
    }
    
    private void flushFullBuffer(int param1Int) {
      this.flushedBuffers.add(new ByteString.LiteralByteString(this.buffer));
      this.flushedBuffersTotalBytes += this.buffer.length;
      this.buffer = new byte[Math.max(this.initialCapacity, Math.max(param1Int, this.flushedBuffersTotalBytes >>> 1))];
      this.bufferPos = 0;
    }
    
    private void flushLastBuffer() {
      int i = this.bufferPos;
      byte[] arrayOfByte = this.buffer;
      if (i < arrayOfByte.length) {
        if (i > 0) {
          arrayOfByte = copyArray(arrayOfByte, i);
          this.flushedBuffers.add(new ByteString.LiteralByteString(arrayOfByte));
        } 
      } else {
        this.flushedBuffers.add(new ByteString.LiteralByteString(arrayOfByte));
        this.buffer = EMPTY_BYTE_ARRAY;
      } 
      this.flushedBuffersTotalBytes += this.bufferPos;
      this.bufferPos = 0;
    }
    
    public void reset() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield flushedBuffers : Ljava/util/ArrayList;
      //   6: invokevirtual clear : ()V
      //   9: aload_0
      //   10: iconst_0
      //   11: putfield flushedBuffersTotalBytes : I
      //   14: aload_0
      //   15: iconst_0
      //   16: putfield bufferPos : I
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: astore_1
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	22	finally
    }
    
    public int size() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield flushedBuffersTotalBytes : I
      //   6: istore_1
      //   7: aload_0
      //   8: getfield bufferPos : I
      //   11: istore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: iload_1
      //   15: iload_2
      //   16: iadd
      //   17: ireturn
      //   18: astore_3
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_3
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	18	finally
    }
    
    public ByteString toByteString() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial flushLastBuffer : ()V
      //   6: aload_0
      //   7: getfield flushedBuffers : Ljava/util/ArrayList;
      //   10: invokestatic copyFrom : (Ljava/lang/Iterable;)Lcom/google/protobuf/ByteString;
      //   13: astore_1
      //   14: aload_0
      //   15: monitorexit
      //   16: aload_1
      //   17: areturn
      //   18: astore_1
      //   19: aload_0
      //   20: monitorexit
      //   21: aload_1
      //   22: athrow
      // Exception table:
      //   from	to	target	type
      //   2	14	18	finally
    }
    
    public String toString() {
      return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
    }
    
    public void write(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield bufferPos : I
      //   6: aload_0
      //   7: getfield buffer : [B
      //   10: arraylength
      //   11: if_icmpne -> 19
      //   14: aload_0
      //   15: iconst_1
      //   16: invokespecial flushFullBuffer : (I)V
      //   19: aload_0
      //   20: getfield buffer : [B
      //   23: astore_3
      //   24: aload_0
      //   25: getfield bufferPos : I
      //   28: istore_2
      //   29: aload_0
      //   30: iload_2
      //   31: iconst_1
      //   32: iadd
      //   33: putfield bufferPos : I
      //   36: aload_3
      //   37: iload_2
      //   38: iload_1
      //   39: i2b
      //   40: bastore
      //   41: aload_0
      //   42: monitorexit
      //   43: return
      //   44: astore_3
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_3
      //   48: athrow
      // Exception table:
      //   from	to	target	type
      //   2	19	44	finally
      //   19	36	44	finally
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_3
      //   3: aload_0
      //   4: getfield buffer : [B
      //   7: arraylength
      //   8: aload_0
      //   9: getfield bufferPos : I
      //   12: isub
      //   13: if_icmpgt -> 43
      //   16: aload_1
      //   17: iload_2
      //   18: aload_0
      //   19: getfield buffer : [B
      //   22: aload_0
      //   23: getfield bufferPos : I
      //   26: iload_3
      //   27: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield bufferPos : I
      //   35: iload_3
      //   36: iadd
      //   37: putfield bufferPos : I
      //   40: goto -> 99
      //   43: aload_0
      //   44: getfield buffer : [B
      //   47: arraylength
      //   48: aload_0
      //   49: getfield bufferPos : I
      //   52: isub
      //   53: istore #4
      //   55: aload_1
      //   56: iload_2
      //   57: aload_0
      //   58: getfield buffer : [B
      //   61: aload_0
      //   62: getfield bufferPos : I
      //   65: iload #4
      //   67: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
      //   70: iload_3
      //   71: iload #4
      //   73: isub
      //   74: istore_3
      //   75: aload_0
      //   76: iload_3
      //   77: invokespecial flushFullBuffer : (I)V
      //   80: aload_1
      //   81: iload_2
      //   82: iload #4
      //   84: iadd
      //   85: aload_0
      //   86: getfield buffer : [B
      //   89: iconst_0
      //   90: iload_3
      //   91: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
      //   94: aload_0
      //   95: iload_3
      //   96: putfield bufferPos : I
      //   99: aload_0
      //   100: monitorexit
      //   101: return
      //   102: astore_1
      //   103: aload_0
      //   104: monitorexit
      //   105: aload_1
      //   106: athrow
      // Exception table:
      //   from	to	target	type
      //   2	40	102	finally
      //   43	70	102	finally
      //   75	99	102	finally
    }
    
    public void writeTo(OutputStream param1OutputStream) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield flushedBuffers : Ljava/util/ArrayList;
      //   6: aload_0
      //   7: getfield flushedBuffers : Ljava/util/ArrayList;
      //   10: invokevirtual size : ()I
      //   13: anewarray com/google/protobuf/ByteString
      //   16: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
      //   19: checkcast [Lcom/google/protobuf/ByteString;
      //   22: astore #5
      //   24: aload_0
      //   25: getfield buffer : [B
      //   28: astore #6
      //   30: aload_0
      //   31: getfield bufferPos : I
      //   34: istore_3
      //   35: aload_0
      //   36: monitorexit
      //   37: aload #5
      //   39: arraylength
      //   40: istore #4
      //   42: iconst_0
      //   43: istore_2
      //   44: iload_2
      //   45: iload #4
      //   47: if_icmpge -> 65
      //   50: aload #5
      //   52: iload_2
      //   53: aaload
      //   54: aload_1
      //   55: invokevirtual writeTo : (Ljava/io/OutputStream;)V
      //   58: iload_2
      //   59: iconst_1
      //   60: iadd
      //   61: istore_2
      //   62: goto -> 44
      //   65: aload_1
      //   66: aload_0
      //   67: aload #6
      //   69: iload_3
      //   70: invokespecial copyArray : ([BI)[B
      //   73: invokevirtual write : ([B)V
      //   76: return
      //   77: astore_1
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_1
      //   81: athrow
      // Exception table:
      //   from	to	target	type
      //   2	37	77	finally
      //   78	80	77	finally
    }
  }
  
  static final class SystemByteArrayCopier implements ByteArrayCopier {
    private SystemByteArrayCopier() {}
    
    public byte[] copyFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      byte[] arrayOfByte = new byte[param1Int2];
      System.arraycopy(param1ArrayOfbyte, param1Int1, arrayOfByte, 0, param1Int2);
      return arrayOfByte;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */