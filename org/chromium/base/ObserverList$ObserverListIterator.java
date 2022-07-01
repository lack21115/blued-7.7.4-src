package org.chromium.base;

import java.util.NoSuchElementException;

final class ObserverList$ObserverListIterator implements ObserverList$RewindableIterator {
  private int mIndex;
  
  private boolean mIsExhausted;
  
  private int mListEndMarker;
  
  private ObserverList$ObserverListIterator() {
    ObserverList.access$100(paramObserverList);
    this.mListEndMarker = ObserverList.access$200(paramObserverList);
  }
  
  private void compactListIfNeeded() {
    if (!this.mIsExhausted) {
      this.mIsExhausted = true;
      ObserverList.access$400(ObserverList.this);
    } 
  }
  
  public final boolean hasNext() {
    int i;
    for (i = this.mIndex; i < this.mListEndMarker && ObserverList.access$300(ObserverList.this, i) == null; i++);
    if (i < this.mListEndMarker)
      return true; 
    compactListIfNeeded();
    return false;
  }
  
  public final Object next() {
    while (this.mIndex < this.mListEndMarker && ObserverList.access$300(ObserverList.this, this.mIndex) == null)
      this.mIndex++; 
    if (this.mIndex < this.mListEndMarker) {
      ObserverList observerList = ObserverList.this;
      int i = this.mIndex;
      this.mIndex = i + 1;
      return ObserverList.access$300(observerList, i);
    } 
    compactListIfNeeded();
    throw new NoSuchElementException();
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
  
  public final void rewind() {
    compactListIfNeeded();
    ObserverList.access$100(ObserverList.this);
    this.mListEndMarker = ObserverList.access$200(ObserverList.this);
    this.mIsExhausted = false;
    this.mIndex = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\ObserverList$ObserverListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */