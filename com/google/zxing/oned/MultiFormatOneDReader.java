package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.RSS14Reader;
import com.google.zxing.oned.rss.expanded.RSSExpandedReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatOneDReader extends OneDReader {
  private final OneDReader[] a;
  
  public MultiFormatOneDReader(Map<DecodeHintType, ?> paramMap) {
    boolean bool;
    Collection collection;
    if (paramMap == null) {
      collection = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.c);
    } 
    if (paramMap != null && paramMap.get(DecodeHintType.g) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    ArrayList<MultiFormatUPCEANReader> arrayList = new ArrayList();
    if (collection != null) {
      if (collection.contains(BarcodeFormat.h) || collection.contains(BarcodeFormat.o) || collection.contains(BarcodeFormat.g) || collection.contains(BarcodeFormat.p))
        arrayList.add(new MultiFormatUPCEANReader(paramMap)); 
      if (collection.contains(BarcodeFormat.c))
        arrayList.add(new Code39Reader(bool)); 
      if (collection.contains(BarcodeFormat.d))
        arrayList.add(new Code93Reader()); 
      if (collection.contains(BarcodeFormat.e))
        arrayList.add(new Code128Reader()); 
      if (collection.contains(BarcodeFormat.i))
        arrayList.add(new ITFReader()); 
      if (collection.contains(BarcodeFormat.b))
        arrayList.add(new CodaBarReader()); 
      if (collection.contains(BarcodeFormat.m))
        arrayList.add(new RSS14Reader()); 
      if (collection.contains(BarcodeFormat.n))
        arrayList.add(new RSSExpandedReader()); 
    } 
    if (arrayList.isEmpty()) {
      arrayList.add(new MultiFormatUPCEANReader(paramMap));
      arrayList.add(new Code39Reader());
      arrayList.add(new CodaBarReader());
      arrayList.add(new Code93Reader());
      arrayList.add(new Code128Reader());
      arrayList.add(new ITFReader());
      arrayList.add(new RSS14Reader());
      arrayList.add(new RSSExpandedReader());
    } 
    this.a = arrayList.<OneDReader>toArray(new OneDReader[arrayList.size()]);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    OneDReader[] arrayOfOneDReader = this.a;
    int j = arrayOfOneDReader.length;
    int i = 0;
    while (true) {
      if (i < j) {
        OneDReader oneDReader = arrayOfOneDReader[i];
        try {
          return oneDReader.a(paramInt, paramBitArray, paramMap);
        } catch (ReaderException readerException) {
          i++;
          continue;
        } 
      } 
      throw NotFoundException.a();
    } 
  }
  
  public void a() {
    OneDReader[] arrayOfOneDReader = this.a;
    int j = arrayOfOneDReader.length;
    for (int i = 0; i < j; i++)
      arrayOfOneDReader[i].a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\MultiFormatOneDReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */