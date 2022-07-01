package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverList implements Iterable {
  private int mCount;
  
  private int mIterationDepth;
  
  private boolean mNeedsCompact;
  
  private List mObservers = new ArrayList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void compact() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean addObserver(Object paramObject) {
    if (paramObject == null || this.mObservers.contains(paramObject))
      return false; 
    boolean bool = this.mObservers.add(paramObject);
    assert false;
    throw new AssertionError();
  }
  
  public final void clear() {
    boolean bool = false;
    this.mCount = 0;
    if (this.mIterationDepth == 0) {
      this.mObservers.clear();
      return;
    } 
    int i = this.mObservers.size();
    boolean bool2 = this.mNeedsCompact;
    if (i != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.mNeedsCompact = bool2 | bool1;
    boolean bool1 = bool;
    while (bool1 < i) {
      this.mObservers.set(bool1, null);
      int j = bool1 + 1;
    } 
  }
  
  public final boolean hasObserver(Object paramObject) {
    return this.mObservers.contains(paramObject);
  }
  
  public final boolean isEmpty() {
    return (this.mCount == 0);
  }
  
  public Iterator iterator() {
    return new ObserverList$ObserverListIterator(this, (byte)0);
  }
  
  public final boolean removeObserver(Object paramObject) {
    if (paramObject == null)
      return false; 
    int i = this.mObservers.indexOf(paramObject);
    if (i == -1)
      return false; 
    if (this.mIterationDepth == 0) {
      this.mObservers.remove(i);
    } else {
      this.mNeedsCompact = true;
      this.mObservers.set(i, null);
    } 
    this.mCount--;
    assert false;
    return true;
  }
  
  public final ObserverList$RewindableIterator rewindableIterator() {
    return new ObserverList$ObserverListIterator(this, (byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ObserverList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */