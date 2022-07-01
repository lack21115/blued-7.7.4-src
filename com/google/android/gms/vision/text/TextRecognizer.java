package com.google.android.gms.vision.text;

import android.util.SparseArray;
import com.google.android.gms.internal.zzdll;
import com.google.android.gms.internal.zzdlr;
import com.google.android.gms.vision.Detector;

public final class TextRecognizer extends Detector {
  public final zzdlr zzlid;
  
  private TextRecognizer() {
    throw new IllegalStateException("Default constructor called");
  }
  
  private TextRecognizer(zzdlr paramzzdlr) {
    this.zzlid = paramzzdlr;
  }
  
  public static SparseArray zza(zzdll[] paramArrayOfzzdll) {
    SparseArray sparseArray2 = new SparseArray();
    int j = paramArrayOfzzdll.length;
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      zzdll zzdll1 = paramArrayOfzzdll[i];
      SparseArray sparseArray4 = (SparseArray)sparseArray2.get(zzdll1.zzlio);
      SparseArray sparseArray3 = sparseArray4;
      if (sparseArray4 == null) {
        sparseArray3 = new SparseArray();
        sparseArray2.append(zzdll1.zzlio, sparseArray3);
      } 
      sparseArray3.append(zzdll1.zzlip, zzdll1);
    } 
    SparseArray sparseArray1 = new SparseArray(sparseArray2.size());
    for (i = bool; i < sparseArray2.size(); i++)
      sparseArray1.append(sparseArray2.keyAt(i), new TextBlock((SparseArray)sparseArray2.valueAt(i))); 
    return sparseArray1;
  }
  
  public final void release() {
    super.release();
    this.zzlid.zzbln();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\text\TextRecognizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */