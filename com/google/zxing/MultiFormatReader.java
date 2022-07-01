package com.google.zxing;

import com.google.zxing.aztec.AztecReader;
import com.google.zxing.datamatrix.DataMatrixReader;
import com.google.zxing.maxicode.MaxiCodeReader;
import com.google.zxing.oned.MultiFormatOneDReader;
import com.google.zxing.pdf417.PDF417Reader;
import com.google.zxing.qrcode.QRCodeReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatReader implements Reader {
  private Map<DecodeHintType, ?> a;
  
  private Reader[] b;
  
  private Result b(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    Reader[] arrayOfReader = this.b;
    if (arrayOfReader != null) {
      int j = arrayOfReader.length;
      int i = 0;
      while (true) {
        if (i < j) {
          Reader reader = arrayOfReader[i];
          try {
            return reader.a(paramBinaryBitmap, this.a);
          } catch (ReaderException readerException) {
            i++;
            continue;
          } 
        } 
        throw NotFoundException.a();
      } 
    } 
    throw NotFoundException.a();
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap) throws NotFoundException {
    if (this.b == null)
      a((Map<DecodeHintType, ?>)null); 
    return b(paramBinaryBitmap);
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    a(paramMap);
    return b(paramBinaryBitmap);
  }
  
  public void a() {
    Reader[] arrayOfReader = this.b;
    if (arrayOfReader != null) {
      int j = arrayOfReader.length;
      for (int i = 0; i < j; i++)
        arrayOfReader[i].a(); 
    } 
  }
  
  public void a(Map<DecodeHintType, ?> paramMap) {
    boolean bool1;
    Collection collection;
    this.a = paramMap;
    boolean bool2 = true;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.d)) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (paramMap == null) {
      collection = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.c);
    } 
    ArrayList<MultiFormatOneDReader> arrayList = new ArrayList();
    if (collection != null) {
      boolean bool = bool2;
      if (!collection.contains(BarcodeFormat.o)) {
        bool = bool2;
        if (!collection.contains(BarcodeFormat.p)) {
          bool = bool2;
          if (!collection.contains(BarcodeFormat.h)) {
            bool = bool2;
            if (!collection.contains(BarcodeFormat.g)) {
              bool = bool2;
              if (!collection.contains(BarcodeFormat.b)) {
                bool = bool2;
                if (!collection.contains(BarcodeFormat.c)) {
                  bool = bool2;
                  if (!collection.contains(BarcodeFormat.d)) {
                    bool = bool2;
                    if (!collection.contains(BarcodeFormat.e)) {
                      bool = bool2;
                      if (!collection.contains(BarcodeFormat.i)) {
                        bool = bool2;
                        if (!collection.contains(BarcodeFormat.m))
                          if (collection.contains(BarcodeFormat.n)) {
                            bool = bool2;
                          } else {
                            bool = false;
                          }  
                      } 
                    } 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
      if (bool && !bool1)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
      if (collection.contains(BarcodeFormat.l))
        arrayList.add(new QRCodeReader()); 
      if (collection.contains(BarcodeFormat.f))
        arrayList.add(new DataMatrixReader()); 
      if (collection.contains(BarcodeFormat.a))
        arrayList.add(new AztecReader()); 
      if (collection.contains(BarcodeFormat.k))
        arrayList.add(new PDF417Reader()); 
      if (collection.contains(BarcodeFormat.j))
        arrayList.add(new MaxiCodeReader()); 
      if (bool && bool1)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
    } 
    if (arrayList.isEmpty()) {
      if (!bool1)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
      arrayList.add(new QRCodeReader());
      arrayList.add(new DataMatrixReader());
      arrayList.add(new AztecReader());
      arrayList.add(new PDF417Reader());
      arrayList.add(new MaxiCodeReader());
      if (bool1)
        arrayList.add(new MultiFormatOneDReader(paramMap)); 
    } 
    this.b = arrayList.<Reader>toArray(new Reader[arrayList.size()]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\MultiFormatReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */