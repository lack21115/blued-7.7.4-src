package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintAttributes;
import android.util.Log;
import android.view.ViewGroup;
import org.chromium.base.annotations.CalledByNative;

@SuppressLint({"NewApi"})
public class AwPdfExporter {
  PrintAttributes mAttributes;
  
  ViewGroup mContainerView;
  
  ParcelFileDescriptor mFd;
  
  long mNativeAwPdfExporter;
  
  AwPdfExporter$AwPdfExporterCallback mResultCallback;
  
  public AwPdfExporter(ViewGroup paramViewGroup) {
    this.mContainerView = paramViewGroup;
  }
  
  @CalledByNative
  private void didExportPdf(int paramInt) {
    this.mResultCallback.pdfWritingDone(paramInt);
    this.mResultCallback = null;
    this.mAttributes = null;
    this.mFd = null;
  }
  
  @CalledByNative
  private int getBottomMargin() {
    return this.mAttributes.getMinMargins().getBottomMils();
  }
  
  @CalledByNative
  private int getDpi() {
    PrintAttributes printAttributes = this.mAttributes;
    int i = printAttributes.getResolution().getHorizontalDpi();
    int j = printAttributes.getResolution().getVerticalDpi();
    if (i != j) {
      StringBuilder stringBuilder = new StringBuilder("Horizontal and vertical DPIs differ. Using horizontal DPI  hDpi=");
      stringBuilder.append(i);
      stringBuilder.append(" vDPI=");
      stringBuilder.append(j);
      Log.w("AwPdfExporter", stringBuilder.toString());
    } 
    return i;
  }
  
  @CalledByNative
  private int getLeftMargin() {
    return this.mAttributes.getMinMargins().getLeftMils();
  }
  
  @CalledByNative
  private int getPageHeight() {
    return this.mAttributes.getMediaSize().getHeightMils();
  }
  
  @CalledByNative
  private int getPageWidth() {
    return this.mAttributes.getMediaSize().getWidthMils();
  }
  
  @CalledByNative
  private int getRightMargin() {
    return this.mAttributes.getMinMargins().getRightMils();
  }
  
  @CalledByNative
  private int getTopMargin() {
    return this.mAttributes.getMinMargins().getTopMils();
  }
  
  @CalledByNative
  private void setNativeAwPdfExporter(long paramLong) {
    this.mNativeAwPdfExporter = paramLong;
    if (paramLong == 0L && this.mResultCallback != null)
      try {
        this.mResultCallback.pdfWritingDone(0);
        this.mResultCallback = null;
        return;
      } catch (IllegalStateException illegalStateException) {} 
  }
  
  native void nativeExportToPdf(long paramLong, int paramInt, int[] paramArrayOfint, CancellationSignal paramCancellationSignal);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwPdfExporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */