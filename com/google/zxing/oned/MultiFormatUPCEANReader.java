package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader extends OneDReader {
  private final UPCEANReader[] a;
  
  public MultiFormatUPCEANReader(Map<DecodeHintType, ?> paramMap) {
    Collection collection;
    if (paramMap == null) {
      paramMap = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.c);
    } 
    ArrayList<EAN13Reader> arrayList = new ArrayList();
    if (collection != null) {
      if (collection.contains(BarcodeFormat.h)) {
        arrayList.add(new EAN13Reader());
      } else if (collection.contains(BarcodeFormat.o)) {
        arrayList.add(new UPCAReader());
      } 
      if (collection.contains(BarcodeFormat.g))
        arrayList.add(new EAN8Reader()); 
      if (collection.contains(BarcodeFormat.p))
        arrayList.add(new UPCEReader()); 
    } 
    if (arrayList.isEmpty()) {
      arrayList.add(new EAN13Reader());
      arrayList.add(new EAN8Reader());
      arrayList.add(new UPCEReader());
    } 
    this.a = arrayList.<UPCEANReader>toArray(new UPCEANReader[arrayList.size()]);
  }
  
  public Result a(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    boolean bool1;
    boolean bool2;
    Collection collection;
    Result result;
    int[] arrayOfInt = UPCEANReader.a(paramBitArray);
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int j = arrayOfUPCEANReader.length;
    int i = 0;
    while (true) {
      if (i < j) {
        UPCEANReader uPCEANReader = arrayOfUPCEANReader[i];
        try {
          result = uPCEANReader.a(paramInt, paramBitArray, arrayOfInt, paramMap);
          if (result.d() == BarcodeFormat.h && result.a().charAt(0) == '0') {
            boolean bool = true;
            break;
          } 
        } catch (ReaderException readerException) {
          i++;
          continue;
        } 
      } else {
        throw NotFoundException.a();
      } 
      bool1 = false;
      break;
    } 
    if (paramMap == null) {
      collection = null;
    } else {
      collection = (Collection)paramMap.get(DecodeHintType.c);
    } 
    if (collection == null || collection.contains(BarcodeFormat.o)) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (bool1 && bool2) {
      Result result1 = new Result(result.a().substring(1), result.b(), result.c(), BarcodeFormat.o);
      result1.a(result.e());
      return result1;
    } 
    return result;
  }
  
  public void a() {
    UPCEANReader[] arrayOfUPCEANReader = this.a;
    int j = arrayOfUPCEANReader.length;
    for (int i = 0; i < j; i++)
      arrayOfUPCEANReader[i].a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\MultiFormatUPCEANReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */