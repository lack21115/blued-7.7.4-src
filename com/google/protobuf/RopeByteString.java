package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class RopeByteString extends ByteString {
  static final int[] minLengthByDepth = new int[] { 
      1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 
      89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 
      10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 
      1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 
      165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE };
  
  private static final long serialVersionUID = 1L;
  
  private final ByteString left;
  
  private final int leftLength;
  
  private final ByteString right;
  
  private final int totalLength;
  
  private final int treeDepth;
  
  private RopeByteString(ByteString paramByteString1, ByteString paramByteString2) {
    this.left = paramByteString1;
    this.right = paramByteString2;
    this.leftLength = paramByteString1.size();
    this.totalLength = this.leftLength + paramByteString2.size();
    this.treeDepth = Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth()) + 1;
  }
  
  static ByteString concatenate(ByteString paramByteString1, ByteString paramByteString2) {
    if (paramByteString2.size() == 0)
      return paramByteString1; 
    if (paramByteString1.size() == 0)
      return paramByteString2; 
    int i = paramByteString1.size() + paramByteString2.size();
    if (i < 128)
      return concatenateBytes(paramByteString1, paramByteString2); 
    if (paramByteString1 instanceof RopeByteString) {
      RopeByteString ropeByteString = (RopeByteString)paramByteString1;
      if (ropeByteString.right.size() + paramByteString2.size() < 128) {
        paramByteString1 = concatenateBytes(ropeByteString.right, paramByteString2);
        return new RopeByteString(ropeByteString.left, paramByteString1);
      } 
      if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > paramByteString2.getTreeDepth()) {
        paramByteString1 = new RopeByteString(ropeByteString.right, paramByteString2);
        return new RopeByteString(ropeByteString.left, paramByteString1);
      } 
    } 
    return (i >= minLength(Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth()) + 1)) ? new RopeByteString(paramByteString1, paramByteString2) : (new Balancer()).balance(paramByteString1, paramByteString2);
  }
  
  private static ByteString concatenateBytes(ByteString paramByteString1, ByteString paramByteString2) {
    int i = paramByteString1.size();
    int j = paramByteString2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramByteString1.copyTo(arrayOfByte, 0, 0, i);
    paramByteString2.copyTo(arrayOfByte, 0, i, j);
    return ByteString.wrap(arrayOfByte);
  }
  
  private boolean equalsFragments(ByteString paramByteString) {
    PieceIterator pieceIterator1 = new PieceIterator(this);
    ByteString.LeafByteString leafByteString = pieceIterator1.next();
    PieceIterator pieceIterator2 = new PieceIterator(paramByteString);
    paramByteString = pieceIterator2.next();
    int j = 0;
    int i = 0;
    int k = 0;
    while (true) {
      boolean bool;
      int i1 = leafByteString.size() - j;
      int m = paramByteString.size() - i;
      int n = Math.min(i1, m);
      if (j == 0) {
        bool = leafByteString.equalsRange(paramByteString, i, n);
      } else {
        bool = paramByteString.equalsRange(leafByteString, j, n);
      } 
      if (!bool)
        return false; 
      k += n;
      int i2 = this.totalLength;
      if (k >= i2) {
        if (k == i2)
          return true; 
        throw new IllegalStateException();
      } 
      if (n == i1) {
        leafByteString = pieceIterator1.next();
        j = 0;
      } else {
        j += n;
      } 
      if (n == m) {
        paramByteString = pieceIterator2.next();
        i = 0;
        continue;
      } 
      i += n;
    } 
  }
  
  static int minLength(int paramInt) {
    int[] arrayOfInt = minLengthByDepth;
    return (paramInt >= arrayOfInt.length) ? Integer.MAX_VALUE : arrayOfInt[paramInt];
  }
  
  static RopeByteString newInstanceForTest(ByteString paramByteString1, ByteString paramByteString2) {
    return new RopeByteString(paramByteString1, paramByteString2);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException {
    throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
  }
  
  public ByteBuffer asReadOnlyByteBuffer() {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList() {
    ArrayList<ByteBuffer> arrayList = new ArrayList();
    PieceIterator pieceIterator = new PieceIterator(this);
    while (pieceIterator.hasNext())
      arrayList.add(pieceIterator.next().asReadOnlyByteBuffer()); 
    return arrayList;
  }
  
  public byte byteAt(int paramInt) {
    checkIndex(paramInt, this.totalLength);
    return internalByteAt(paramInt);
  }
  
  public void copyTo(ByteBuffer paramByteBuffer) {
    this.left.copyTo(paramByteBuffer);
    this.right.copyTo(paramByteBuffer);
  }
  
  protected void copyToInternal(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    int i = this.leftLength;
    if (paramInt1 + paramInt3 <= i) {
      this.left.copyToInternal(paramArrayOfbyte, paramInt1, paramInt2, paramInt3);
      return;
    } 
    if (paramInt1 >= i) {
      this.right.copyToInternal(paramArrayOfbyte, paramInt1 - i, paramInt2, paramInt3);
      return;
    } 
    i -= paramInt1;
    this.left.copyToInternal(paramArrayOfbyte, paramInt1, paramInt2, i);
    this.right.copyToInternal(paramArrayOfbyte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ByteString))
      return false; 
    paramObject = paramObject;
    if (this.totalLength != paramObject.size())
      return false; 
    if (this.totalLength == 0)
      return true; 
    int i = peekCachedHashCode();
    int j = paramObject.peekCachedHashCode();
    return (i != 0 && j != 0 && i != j) ? false : equalsFragments((ByteString)paramObject);
  }
  
  protected int getTreeDepth() {
    return this.treeDepth;
  }
  
  byte internalByteAt(int paramInt) {
    int i = this.leftLength;
    return (paramInt < i) ? this.left.internalByteAt(paramInt) : this.right.internalByteAt(paramInt - i);
  }
  
  protected boolean isBalanced() {
    return (this.totalLength >= minLength(this.treeDepth));
  }
  
  public boolean isValidUtf8() {
    ByteString byteString = this.left;
    int i = this.leftLength;
    boolean bool = false;
    i = byteString.partialIsValidUtf8(0, 0, i);
    byteString = this.right;
    if (byteString.partialIsValidUtf8(i, 0, byteString.size()) == 0)
      bool = true; 
    return bool;
  }
  
  public ByteString.ByteIterator iterator() {
    return new ByteString.AbstractByteIterator() {
        ByteString.ByteIterator current = nextPiece();
        
        final RopeByteString.PieceIterator pieces = new RopeByteString.PieceIterator(RopeByteString.this);
        
        private ByteString.ByteIterator nextPiece() {
          return this.pieces.hasNext() ? this.pieces.next().iterator() : null;
        }
        
        public boolean hasNext() {
          return (this.current != null);
        }
        
        public byte nextByte() {
          ByteString.ByteIterator byteIterator = this.current;
          if (byteIterator != null) {
            byte b = byteIterator.nextByte();
            if (!this.current.hasNext())
              this.current = nextPiece(); 
            return b;
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  public CodedInputStream newCodedInput() {
    return CodedInputStream.newInstance(new RopeInputStream());
  }
  
  public InputStream newInput() {
    return new RopeInputStream();
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3) {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i)
      return this.left.partialHash(paramInt1, paramInt2, paramInt3); 
    if (paramInt2 >= i)
      return this.right.partialHash(paramInt1, paramInt2 - i, paramInt3); 
    i -= paramInt2;
    paramInt1 = this.left.partialHash(paramInt1, paramInt2, i);
    return this.right.partialHash(paramInt1, 0, paramInt3 - i);
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3) {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i)
      return this.left.partialIsValidUtf8(paramInt1, paramInt2, paramInt3); 
    if (paramInt2 >= i)
      return this.right.partialIsValidUtf8(paramInt1, paramInt2 - i, paramInt3); 
    i -= paramInt2;
    paramInt1 = this.left.partialIsValidUtf8(paramInt1, paramInt2, i);
    return this.right.partialIsValidUtf8(paramInt1, 0, paramInt3 - i);
  }
  
  public int size() {
    return this.totalLength;
  }
  
  public ByteString substring(int paramInt1, int paramInt2) {
    int i = checkRange(paramInt1, paramInt2, this.totalLength);
    if (i == 0)
      return ByteString.EMPTY; 
    if (i == this.totalLength)
      return this; 
    i = this.leftLength;
    return (paramInt2 <= i) ? this.left.substring(paramInt1, paramInt2) : ((paramInt1 >= i) ? this.right.substring(paramInt1 - i, paramInt2 - i) : new RopeByteString(this.left.substring(paramInt1), this.right.substring(0, paramInt2 - this.leftLength)));
  }
  
  protected String toStringInternal(Charset paramCharset) {
    return new String(toByteArray(), paramCharset);
  }
  
  Object writeReplace() {
    return ByteString.wrap(toByteArray());
  }
  
  void writeTo(ByteOutput paramByteOutput) throws IOException {
    this.left.writeTo(paramByteOutput);
    this.right.writeTo(paramByteOutput);
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    this.left.writeTo(paramOutputStream);
    this.right.writeTo(paramOutputStream);
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2) throws IOException {
    int i = this.leftLength;
    if (paramInt1 + paramInt2 <= i) {
      this.left.writeToInternal(paramOutputStream, paramInt1, paramInt2);
      return;
    } 
    if (paramInt1 >= i) {
      this.right.writeToInternal(paramOutputStream, paramInt1 - i, paramInt2);
      return;
    } 
    i -= paramInt1;
    this.left.writeToInternal(paramOutputStream, paramInt1, i);
    this.right.writeToInternal(paramOutputStream, 0, paramInt2 - i);
  }
  
  void writeToReverse(ByteOutput paramByteOutput) throws IOException {
    this.right.writeToReverse(paramByteOutput);
    this.left.writeToReverse(paramByteOutput);
  }
  
  static class Balancer {
    private final ArrayDeque<ByteString> prefixesStack = new ArrayDeque<ByteString>();
    
    private Balancer() {}
    
    private ByteString balance(ByteString param1ByteString1, ByteString param1ByteString2) {
      doBalance(param1ByteString1);
      doBalance(param1ByteString2);
      for (param1ByteString1 = this.prefixesStack.pop(); !this.prefixesStack.isEmpty(); param1ByteString1 = new RopeByteString(this.prefixesStack.pop(), param1ByteString1));
      return param1ByteString1;
    }
    
    private void doBalance(ByteString param1ByteString) {
      if (param1ByteString.isBalanced()) {
        insert(param1ByteString);
        return;
      } 
      if (param1ByteString instanceof RopeByteString) {
        param1ByteString = param1ByteString;
        doBalance(((RopeByteString)param1ByteString).left);
        doBalance(((RopeByteString)param1ByteString).right);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Has a new type of ByteString been created? Found ");
      stringBuilder.append(param1ByteString.getClass());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    private int getDepthBinForLength(int param1Int) {
      int i = Arrays.binarySearch(RopeByteString.minLengthByDepth, param1Int);
      param1Int = i;
      if (i < 0)
        param1Int = -(i + 1) - 1; 
      return param1Int;
    }
    
    private void insert(ByteString param1ByteString) {
      int i = getDepthBinForLength(param1ByteString.size());
      int j = RopeByteString.minLength(i + 1);
      if (this.prefixesStack.isEmpty() || ((ByteString)this.prefixesStack.peek()).size() >= j) {
        this.prefixesStack.push(param1ByteString);
        return;
      } 
      i = RopeByteString.minLength(i);
      ByteString byteString;
      for (byteString = this.prefixesStack.pop(); !this.prefixesStack.isEmpty() && ((ByteString)this.prefixesStack.peek()).size() < i; byteString = new RopeByteString(this.prefixesStack.pop(), byteString));
      param1ByteString = new RopeByteString(byteString, param1ByteString);
      while (!this.prefixesStack.isEmpty()) {
        i = RopeByteString.minLength(getDepthBinForLength(param1ByteString.size()) + 1);
        if (((ByteString)this.prefixesStack.peek()).size() < i)
          param1ByteString = new RopeByteString(this.prefixesStack.pop(), param1ByteString); 
      } 
      this.prefixesStack.push(param1ByteString);
    }
  }
  
  static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
    private final ArrayDeque<RopeByteString> breadCrumbs;
    
    private ByteString.LeafByteString next;
    
    private PieceIterator(ByteString param1ByteString) {
      if (param1ByteString instanceof RopeByteString) {
        param1ByteString = param1ByteString;
        this.breadCrumbs = new ArrayDeque<RopeByteString>(param1ByteString.getTreeDepth());
        this.breadCrumbs.push(param1ByteString);
        this.next = getLeafByLeft(((RopeByteString)param1ByteString).left);
        return;
      } 
      this.breadCrumbs = null;
      this.next = (ByteString.LeafByteString)param1ByteString;
    }
    
    private ByteString.LeafByteString getLeafByLeft(ByteString param1ByteString) {
      while (param1ByteString instanceof RopeByteString) {
        param1ByteString = param1ByteString;
        this.breadCrumbs.push(param1ByteString);
        param1ByteString = ((RopeByteString)param1ByteString).left;
      } 
      return (ByteString.LeafByteString)param1ByteString;
    }
    
    private ByteString.LeafByteString getNextNonEmptyLeaf() {
      while (true) {
        ArrayDeque<RopeByteString> arrayDeque = this.breadCrumbs;
        if (arrayDeque == null || arrayDeque.isEmpty())
          break; 
        ByteString.LeafByteString leafByteString = getLeafByLeft((this.breadCrumbs.pop()).right);
        if (!leafByteString.isEmpty())
          return leafByteString; 
      } 
      return null;
    }
    
    public boolean hasNext() {
      return (this.next != null);
    }
    
    public ByteString.LeafByteString next() {
      ByteString.LeafByteString leafByteString = this.next;
      if (leafByteString != null) {
        this.next = getNextNonEmptyLeaf();
        return leafByteString;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  
  class RopeInputStream extends InputStream {
    private ByteString.LeafByteString currentPiece;
    
    private int currentPieceIndex;
    
    private int currentPieceOffsetInRope;
    
    private int currentPieceSize;
    
    private int mark;
    
    private RopeByteString.PieceIterator pieceIterator;
    
    public RopeInputStream() {
      initialize();
    }
    
    private void advanceIfCurrentPieceFullyRead() {
      if (this.currentPiece != null) {
        int i = this.currentPieceIndex;
        int j = this.currentPieceSize;
        if (i == j) {
          this.currentPieceOffsetInRope += j;
          this.currentPieceIndex = 0;
          if (this.pieceIterator.hasNext()) {
            this.currentPiece = this.pieceIterator.next();
            this.currentPieceSize = this.currentPiece.size();
            return;
          } 
          this.currentPiece = null;
          this.currentPieceSize = 0;
        } 
      } 
    }
    
    private void initialize() {
      this.pieceIterator = new RopeByteString.PieceIterator(RopeByteString.this);
      this.currentPiece = this.pieceIterator.next();
      this.currentPieceSize = this.currentPiece.size();
      this.currentPieceIndex = 0;
      this.currentPieceOffsetInRope = 0;
    }
    
    private int readSkipInternal(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int i = param1Int1;
      param1Int1 = param1Int2;
      while (param1Int1 > 0) {
        advanceIfCurrentPieceFullyRead();
        if (this.currentPiece == null)
          break; 
        int k = Math.min(this.currentPieceSize - this.currentPieceIndex, param1Int1);
        int j = i;
        if (param1ArrayOfbyte != null) {
          this.currentPiece.copyTo(param1ArrayOfbyte, this.currentPieceIndex, i, k);
          j = i + k;
        } 
        this.currentPieceIndex += k;
        param1Int1 -= k;
        i = j;
      } 
      return param1Int2 - param1Int1;
    }
    
    public int available() throws IOException {
      int i = this.currentPieceOffsetInRope;
      int j = this.currentPieceIndex;
      return RopeByteString.this.size() - i + j;
    }
    
    public void mark(int param1Int) {
      this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
    }
    
    public boolean markSupported() {
      return true;
    }
    
    public int read() throws IOException {
      advanceIfCurrentPieceFullyRead();
      ByteString.LeafByteString leafByteString = this.currentPiece;
      if (leafByteString == null)
        return -1; 
      int i = this.currentPieceIndex;
      this.currentPieceIndex = i + 1;
      return leafByteString.byteAt(i) & 0xFF;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (param1ArrayOfbyte != null) {
        if (param1Int1 >= 0 && param1Int2 >= 0 && param1Int2 <= param1ArrayOfbyte.length - param1Int1) {
          param1Int2 = readSkipInternal(param1ArrayOfbyte, param1Int1, param1Int2);
          param1Int1 = param1Int2;
          if (param1Int2 == 0)
            param1Int1 = -1; 
          return param1Int1;
        } 
        throw new IndexOutOfBoundsException();
      } 
      throw new NullPointerException();
    }
    
    public void reset() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial initialize : ()V
      //   6: aload_0
      //   7: aconst_null
      //   8: iconst_0
      //   9: aload_0
      //   10: getfield mark : I
      //   13: invokespecial readSkipInternal : ([BII)I
      //   16: pop
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: astore_1
      //   21: aload_0
      //   22: monitorexit
      //   23: aload_1
      //   24: athrow
      // Exception table:
      //   from	to	target	type
      //   2	17	20	finally
    }
    
    public long skip(long param1Long) {
      if (param1Long >= 0L) {
        long l = param1Long;
        if (param1Long > 2147483647L)
          l = 2147483647L; 
        return readSkipInternal(null, 0, (int)l);
      } 
      throw new IndexOutOfBoundsException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RopeByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */