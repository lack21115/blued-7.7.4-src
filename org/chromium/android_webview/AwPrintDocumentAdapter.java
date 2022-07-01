package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
public final class AwPrintDocumentAdapter extends PrintDocumentAdapter {
  private PrintAttributes mAttributes;
  
  private String mDocumentName;
  
  private AwPdfExporter mPdfExporter;
  
  public AwPrintDocumentAdapter(AwPdfExporter paramAwPdfExporter, String paramString) {
    this.mPdfExporter = paramAwPdfExporter;
    this.mDocumentName = paramString;
  }
  
  public final void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle) {
    this.mAttributes = paramPrintAttributes2;
    paramLayoutResultCallback.onLayoutFinished((new PrintDocumentInfo.Builder(this.mDocumentName)).build(), true);
  }
  
  public final void onWrite(PageRange[] paramArrayOfPageRange, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {
    int[] arrayOfInt;
    if (paramArrayOfPageRange == null || paramArrayOfPageRange.length == 0) {
      paramWriteResultCallback.onWriteFailed(null);
      return;
    } 
    AwPdfExporter awPdfExporter = this.mPdfExporter;
    PrintAttributes printAttributes = this.mAttributes;
    if (paramArrayOfPageRange.length == 1 && PageRange.ALL_PAGES.equals(paramArrayOfPageRange[0])) {
      arrayOfInt = new int[0];
    } else {
      ArrayList<Integer> arrayList = new ArrayList();
      int j = paramArrayOfPageRange.length;
      int i;
      for (i = 0; i < j; i++) {
        PageRange pageRange = paramArrayOfPageRange[i];
        int k;
        for (k = pageRange.getStart(); k <= pageRange.getEnd(); k++)
          arrayList.add(Integer.valueOf(k)); 
      } 
      arrayOfInt = new int[arrayList.size()];
      for (i = 0; i < arrayList.size(); i++)
        arrayOfInt[i] = ((Integer)arrayList.get(i)).intValue(); 
    } 
    AwPrintDocumentAdapter$$Lambda$0 awPrintDocumentAdapter$$Lambda$0 = new AwPrintDocumentAdapter$$Lambda$0(paramWriteResultCallback, paramArrayOfPageRange);
    if (paramParcelFileDescriptor != null) {
      if (awPdfExporter.mResultCallback == null) {
        if (printAttributes.getMediaSize() != null) {
          if (printAttributes.getResolution() != null) {
            if (printAttributes.getMinMargins() != null) {
              if (awPdfExporter.mNativeAwPdfExporter == 0L) {
                awPrintDocumentAdapter$$Lambda$0.pdfWritingDone(0);
                return;
              } 
              awPdfExporter.mResultCallback = awPrintDocumentAdapter$$Lambda$0;
              awPdfExporter.mAttributes = printAttributes;
              awPdfExporter.mFd = paramParcelFileDescriptor;
              awPdfExporter.nativeExportToPdf(awPdfExporter.mNativeAwPdfExporter, awPdfExporter.mFd.getFd(), arrayOfInt, paramCancellationSignal);
              return;
            } 
            throw new IllegalArgumentException("attributes must specify margins");
          } 
          throw new IllegalArgumentException("attributes must specify print resolution");
        } 
        throw new IllegalArgumentException("attributes must specify a media size");
      } 
      throw new IllegalStateException("printing is already pending");
    } 
    throw new IllegalArgumentException("fd cannot be null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwPrintDocumentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */