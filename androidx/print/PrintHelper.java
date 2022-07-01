package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class PrintHelper {
  public static final int COLOR_MODE_COLOR = 2;
  
  public static final int COLOR_MODE_MONOCHROME = 1;
  
  public static final int ORIENTATION_LANDSCAPE = 1;
  
  public static final int ORIENTATION_PORTRAIT = 2;
  
  public static final int SCALE_MODE_FILL = 2;
  
  public static final int SCALE_MODE_FIT = 1;
  
  static final boolean a;
  
  static final boolean b;
  
  final Context c;
  
  BitmapFactory.Options d = null;
  
  final Object e = new Object();
  
  int f = 2;
  
  int g = 2;
  
  int h = 1;
  
  static {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 20 || Build.VERSION.SDK_INT > 23) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    a = bool1;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT != 23)
      bool1 = true; 
    b = bool1;
  }
  
  public PrintHelper(Context paramContext) {
    this.c = paramContext;
  }
  
  static Bitmap a(Bitmap paramBitmap, int paramInt) {
    if (paramInt != 1)
      return paramBitmap; 
    Bitmap bitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint();
    ColorMatrix colorMatrix = new ColorMatrix();
    colorMatrix.setSaturation(0.0F);
    paint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(colorMatrix));
    canvas.drawBitmap(paramBitmap, 0.0F, 0.0F, paint);
    canvas.setBitmap(null);
    return bitmap;
  }
  
  private Bitmap a(Uri paramUri, BitmapFactory.Options paramOptions) throws FileNotFoundException {
    if (paramUri != null) {
      Context context = this.c;
      if (context != null) {
        Exception exception1;
        Exception exception2 = null;
        try {
          InputStream inputStream = context.getContentResolver().openInputStream(paramUri);
        } finally {
          paramUri = null;
        } 
        if (exception1 != null)
          try {
            exception1.close();
          } catch (IOException iOException) {
            Log.w("PrintHelper", "close fail ", iOException);
          }  
        throw paramUri;
      } 
    } 
    throw new IllegalArgumentException("bad argument to loadBitmap");
  }
  
  static Matrix a(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3) {
    Matrix matrix = new Matrix();
    float f1 = paramRectF.width();
    float f2 = paramInt1;
    f1 /= f2;
    if (paramInt3 == 2) {
      f1 = Math.max(f1, paramRectF.height() / paramInt2);
    } else {
      f1 = Math.min(f1, paramRectF.height() / paramInt2);
    } 
    matrix.postScale(f1, f1);
    matrix.postTranslate((paramRectF.width() - f2 * f1) / 2.0F, (paramRectF.height() - paramInt2 * f1) / 2.0F);
    return matrix;
  }
  
  private static PrintAttributes.Builder a(PrintAttributes paramPrintAttributes) {
    PrintAttributes.Builder builder = (new PrintAttributes.Builder()).setMediaSize(paramPrintAttributes.getMediaSize()).setResolution(paramPrintAttributes.getResolution()).setMinMargins(paramPrintAttributes.getMinMargins());
    if (paramPrintAttributes.getColorMode() != 0)
      builder.setColorMode(paramPrintAttributes.getColorMode()); 
    if (Build.VERSION.SDK_INT >= 23 && paramPrintAttributes.getDuplexMode() != 0)
      builder.setDuplexMode(paramPrintAttributes.getDuplexMode()); 
    return builder;
  }
  
  static boolean a(Bitmap paramBitmap) {
    return (paramBitmap.getWidth() <= paramBitmap.getHeight());
  }
  
  public static boolean systemSupportsPrint() {
    return (Build.VERSION.SDK_INT >= 19);
  }
  
  Bitmap a(Uri paramUri) throws FileNotFoundException {
    if (paramUri != null && this.c != null) {
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      a(paramUri, options);
      int i = options.outWidth;
      int j = options.outHeight;
      if (i > 0) {
        if (j <= 0)
          return null; 
        int m = Math.max(i, j);
        int k;
        for (k = 1; m > 3500; k <<= 1)
          m >>>= 1; 
        if (k > 0) {
          if (Math.min(i, j) / k <= 0)
            return null; 
          synchronized (this.e) {
            this.d = new BitmapFactory.Options();
            this.d.inMutable = true;
            this.d.inSampleSize = k;
            BitmapFactory.Options options1 = this.d;
            try {
              null = a(paramUri, options1);
            } finally {
              null = null;
            } 
          } 
        } 
      } 
      return null;
    } 
    throw new IllegalArgumentException("bad argument to getScaledBitmap");
  }
  
  void a(PrintAttributes paramPrintAttributes, int paramInt, Bitmap paramBitmap, ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback) {
    PrintAttributes printAttributes;
    if (b) {
      printAttributes = paramPrintAttributes;
    } else {
      printAttributes = a(paramPrintAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
    } 
    (new AsyncTask<Void, Void, Throwable>(this, paramCancellationSignal, printAttributes, paramBitmap, paramPrintAttributes, paramInt, paramParcelFileDescriptor, paramWriteResultCallback) {
        protected Throwable a(Void... param1VarArgs) {
          try {
            if (this.a.isCanceled())
              return null; 
            PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(this.h.c, this.b);
            Bitmap bitmap = PrintHelper.a(this.c, this.b.getColorMode());
            boolean bool = this.a.isCanceled();
            if (bool)
              return null; 
            try {
              RectF rectF;
              PdfDocument.Page page = printedPdfDocument.startPage(1);
              if (PrintHelper.b) {
                rectF = new RectF(page.getInfo().getContentRect());
              } else {
                PrintedPdfDocument printedPdfDocument1 = new PrintedPdfDocument(this.h.c, this.d);
                PdfDocument.Page page1 = printedPdfDocument1.startPage(1);
                rectF = new RectF(page1.getInfo().getContentRect());
                printedPdfDocument1.finishPage(page1);
                printedPdfDocument1.close();
              } 
              Matrix matrix = PrintHelper.a(bitmap.getWidth(), bitmap.getHeight(), rectF, this.e);
              if (!PrintHelper.b) {
                matrix.postTranslate(rectF.left, rectF.top);
                page.getCanvas().clipRect(rectF);
              } 
              page.getCanvas().drawBitmap(bitmap, matrix, null);
              printedPdfDocument.finishPage(page);
              bool = this.a.isCanceled();
              if (bool)
                return null; 
              printedPdfDocument.writeTo(new FileOutputStream(this.f.getFileDescriptor()));
            } finally {
              printedPdfDocument.close();
              ParcelFileDescriptor parcelFileDescriptor = this.f;
              if (parcelFileDescriptor != null)
                try {
                  this.f.close();
                } catch (IOException iOException) {} 
              if (bitmap != this.c)
                bitmap.recycle(); 
            } 
          } finally {}
        }
        
        protected void a(Throwable param1Throwable) {
          if (this.a.isCanceled()) {
            this.g.onWriteCancelled();
            return;
          } 
          if (param1Throwable == null) {
            this.g.onWriteFinished(new PageRange[] { PageRange.ALL_PAGES });
            return;
          } 
          Log.e("PrintHelper", "Error writing printed content", param1Throwable);
          this.g.onWriteFailed(null);
        }
      }).execute((Object[])new Void[0]);
  }
  
  public int getColorMode() {
    return this.g;
  }
  
  public int getOrientation() {
    return (Build.VERSION.SDK_INT >= 19 && this.h == 0) ? 1 : this.h;
  }
  
  public int getScaleMode() {
    return this.f;
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap) {
    printBitmap(paramString, paramBitmap, (OnPrintFinishCallback)null);
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap, OnPrintFinishCallback paramOnPrintFinishCallback) {
    if (Build.VERSION.SDK_INT >= 19) {
      PrintAttributes.MediaSize mediaSize;
      if (paramBitmap == null)
        return; 
      PrintManager printManager = (PrintManager)this.c.getSystemService("print");
      if (a(paramBitmap)) {
        mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
      } else {
        mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
      } 
      PrintAttributes printAttributes = (new PrintAttributes.Builder()).setMediaSize(mediaSize).setColorMode(this.g).build();
      printManager.print(paramString, new PrintBitmapAdapter(this, paramString, this.f, paramBitmap, paramOnPrintFinishCallback), printAttributes);
    } 
  }
  
  public void printBitmap(String paramString, Uri paramUri) throws FileNotFoundException {
    printBitmap(paramString, paramUri, (OnPrintFinishCallback)null);
  }
  
  public void printBitmap(String paramString, Uri paramUri, OnPrintFinishCallback paramOnPrintFinishCallback) throws FileNotFoundException {
    if (Build.VERSION.SDK_INT < 19)
      return; 
    PrintUriAdapter printUriAdapter = new PrintUriAdapter(this, paramString, paramUri, paramOnPrintFinishCallback, this.f);
    PrintManager printManager = (PrintManager)this.c.getSystemService("print");
    PrintAttributes.Builder builder = new PrintAttributes.Builder();
    builder.setColorMode(this.g);
    int i = this.h;
    if (i == 1 || i == 0) {
      builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    } else if (i == 2) {
      builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
    } 
    printManager.print(paramString, printUriAdapter, builder.build());
  }
  
  public void setColorMode(int paramInt) {
    this.g = paramInt;
  }
  
  public void setOrientation(int paramInt) {
    this.h = paramInt;
  }
  
  public void setScaleMode(int paramInt) {
    this.f = paramInt;
  }
  
  public static interface OnPrintFinishCallback {
    void onFinish();
  }
  
  class PrintBitmapAdapter extends PrintDocumentAdapter {
    private final String b;
    
    private final int c;
    
    private final Bitmap d;
    
    private final PrintHelper.OnPrintFinishCallback e;
    
    private PrintAttributes f;
    
    PrintBitmapAdapter(PrintHelper this$0, String param1String, int param1Int, Bitmap param1Bitmap, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback) {
      this.b = param1String;
      this.c = param1Int;
      this.d = param1Bitmap;
      this.e = param1OnPrintFinishCallback;
    }
    
    public void onFinish() {
      PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.e;
      if (onPrintFinishCallback != null)
        onPrintFinishCallback.onFinish(); 
    }
    
    public void onLayout(PrintAttributes param1PrintAttributes1, PrintAttributes param1PrintAttributes2, CancellationSignal param1CancellationSignal, PrintDocumentAdapter.LayoutResultCallback param1LayoutResultCallback, Bundle param1Bundle) {
      this.f = param1PrintAttributes2;
      param1LayoutResultCallback.onLayoutFinished((new PrintDocumentInfo.Builder(this.b)).setContentType(1).setPageCount(1).build(), param1PrintAttributes2.equals(param1PrintAttributes1) ^ true);
    }
    
    public void onWrite(PageRange[] param1ArrayOfPageRange, ParcelFileDescriptor param1ParcelFileDescriptor, CancellationSignal param1CancellationSignal, PrintDocumentAdapter.WriteResultCallback param1WriteResultCallback) {
      this.a.a(this.f, this.c, this.d, param1ParcelFileDescriptor, param1CancellationSignal, param1WriteResultCallback);
    }
  }
  
  class PrintUriAdapter extends PrintDocumentAdapter {
    final String a;
    
    final Uri b;
    
    final PrintHelper.OnPrintFinishCallback c;
    
    final int d;
    
    PrintAttributes e;
    
    AsyncTask<Uri, Boolean, Bitmap> f;
    
    Bitmap g;
    
    PrintUriAdapter(PrintHelper this$0, String param1String, Uri param1Uri, PrintHelper.OnPrintFinishCallback param1OnPrintFinishCallback, int param1Int) {
      this.a = param1String;
      this.b = param1Uri;
      this.c = param1OnPrintFinishCallback;
      this.d = param1Int;
      this.g = null;
    }
    
    void a() {
      synchronized (this.h.e) {
        if (this.h.d != null) {
          if (Build.VERSION.SDK_INT < 24)
            this.h.d.requestCancelDecode(); 
          this.h.d = null;
        } 
        return;
      } 
    }
    
    public void onFinish() {
      super.onFinish();
      a();
      AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f;
      if (asyncTask != null)
        asyncTask.cancel(true); 
      PrintHelper.OnPrintFinishCallback onPrintFinishCallback = this.c;
      if (onPrintFinishCallback != null)
        onPrintFinishCallback.onFinish(); 
      Bitmap bitmap = this.g;
      if (bitmap != null) {
        bitmap.recycle();
        this.g = null;
      } 
    }
    
    public void onLayout(PrintAttributes param1PrintAttributes1, PrintAttributes param1PrintAttributes2, CancellationSignal param1CancellationSignal, PrintDocumentAdapter.LayoutResultCallback param1LayoutResultCallback, Bundle param1Bundle) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_2
      //   4: putfield e : Landroid/print/PrintAttributes;
      //   7: aload_0
      //   8: monitorexit
      //   9: aload_3
      //   10: invokevirtual isCanceled : ()Z
      //   13: ifeq -> 22
      //   16: aload #4
      //   18: invokevirtual onLayoutCancelled : ()V
      //   21: return
      //   22: aload_0
      //   23: getfield g : Landroid/graphics/Bitmap;
      //   26: ifnull -> 64
      //   29: aload #4
      //   31: new android/print/PrintDocumentInfo$Builder
      //   34: dup
      //   35: aload_0
      //   36: getfield a : Ljava/lang/String;
      //   39: invokespecial <init> : (Ljava/lang/String;)V
      //   42: iconst_1
      //   43: invokevirtual setContentType : (I)Landroid/print/PrintDocumentInfo$Builder;
      //   46: iconst_1
      //   47: invokevirtual setPageCount : (I)Landroid/print/PrintDocumentInfo$Builder;
      //   50: invokevirtual build : ()Landroid/print/PrintDocumentInfo;
      //   53: aload_2
      //   54: aload_1
      //   55: invokevirtual equals : (Ljava/lang/Object;)Z
      //   58: iconst_1
      //   59: ixor
      //   60: invokevirtual onLayoutFinished : (Landroid/print/PrintDocumentInfo;Z)V
      //   63: return
      //   64: aload_0
      //   65: new androidx/print/PrintHelper$PrintUriAdapter$1
      //   68: dup
      //   69: aload_0
      //   70: aload_3
      //   71: aload_2
      //   72: aload_1
      //   73: aload #4
      //   75: invokespecial <init> : (Landroidx/print/PrintHelper$PrintUriAdapter;Landroid/os/CancellationSignal;Landroid/print/PrintAttributes;Landroid/print/PrintAttributes;Landroid/print/PrintDocumentAdapter$LayoutResultCallback;)V
      //   78: iconst_0
      //   79: anewarray android/net/Uri
      //   82: invokevirtual execute : ([Ljava/lang/Object;)Landroid/os/AsyncTask;
      //   85: putfield f : Landroid/os/AsyncTask;
      //   88: return
      //   89: astore_1
      //   90: aload_0
      //   91: monitorexit
      //   92: aload_1
      //   93: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	89	finally
      //   90	92	89	finally
    }
    
    public void onWrite(PageRange[] param1ArrayOfPageRange, ParcelFileDescriptor param1ParcelFileDescriptor, CancellationSignal param1CancellationSignal, PrintDocumentAdapter.WriteResultCallback param1WriteResultCallback) {
      this.h.a(this.e, this.d, this.g, param1ParcelFileDescriptor, param1CancellationSignal, param1WriteResultCallback);
    }
  }
  
  class null extends AsyncTask<Uri, Boolean, Bitmap> {
    null(PrintHelper this$0, CancellationSignal param1CancellationSignal, PrintAttributes param1PrintAttributes1, PrintAttributes param1PrintAttributes2, PrintDocumentAdapter.LayoutResultCallback param1LayoutResultCallback) {}
    
    protected Bitmap a(Uri... param1VarArgs) {
      try {
        return this.e.h.a(this.e.b);
      } catch (FileNotFoundException fileNotFoundException) {
        return null;
      } 
    }
    
    protected void a(Bitmap param1Bitmap) {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial onPostExecute : (Ljava/lang/Object;)V
      //   5: aload_1
      //   6: astore_3
      //   7: aload_1
      //   8: ifnull -> 109
      //   11: getstatic androidx/print/PrintHelper.a : Z
      //   14: ifeq -> 32
      //   17: aload_1
      //   18: astore_3
      //   19: aload_0
      //   20: getfield e : Landroidx/print/PrintHelper$PrintUriAdapter;
      //   23: getfield h : Landroidx/print/PrintHelper;
      //   26: getfield h : I
      //   29: ifne -> 109
      //   32: aload_0
      //   33: monitorenter
      //   34: aload_0
      //   35: getfield e : Landroidx/print/PrintHelper$PrintUriAdapter;
      //   38: getfield e : Landroid/print/PrintAttributes;
      //   41: invokevirtual getMediaSize : ()Landroid/print/PrintAttributes$MediaSize;
      //   44: astore #4
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: astore_3
      //   50: aload #4
      //   52: ifnull -> 109
      //   55: aload_1
      //   56: astore_3
      //   57: aload #4
      //   59: invokevirtual isPortrait : ()Z
      //   62: aload_1
      //   63: invokestatic a : (Landroid/graphics/Bitmap;)Z
      //   66: if_icmpeq -> 109
      //   69: new android/graphics/Matrix
      //   72: dup
      //   73: invokespecial <init> : ()V
      //   76: astore_3
      //   77: aload_3
      //   78: ldc 90.0
      //   80: invokevirtual postRotate : (F)Z
      //   83: pop
      //   84: aload_1
      //   85: iconst_0
      //   86: iconst_0
      //   87: aload_1
      //   88: invokevirtual getWidth : ()I
      //   91: aload_1
      //   92: invokevirtual getHeight : ()I
      //   95: aload_3
      //   96: iconst_1
      //   97: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
      //   100: astore_3
      //   101: goto -> 109
      //   104: astore_1
      //   105: aload_0
      //   106: monitorexit
      //   107: aload_1
      //   108: athrow
      //   109: aload_0
      //   110: getfield e : Landroidx/print/PrintHelper$PrintUriAdapter;
      //   113: astore_1
      //   114: aload_1
      //   115: aload_3
      //   116: putfield g : Landroid/graphics/Bitmap;
      //   119: aload_3
      //   120: ifnull -> 172
      //   123: new android/print/PrintDocumentInfo$Builder
      //   126: dup
      //   127: aload_1
      //   128: getfield a : Ljava/lang/String;
      //   131: invokespecial <init> : (Ljava/lang/String;)V
      //   134: iconst_1
      //   135: invokevirtual setContentType : (I)Landroid/print/PrintDocumentInfo$Builder;
      //   138: iconst_1
      //   139: invokevirtual setPageCount : (I)Landroid/print/PrintDocumentInfo$Builder;
      //   142: invokevirtual build : ()Landroid/print/PrintDocumentInfo;
      //   145: astore_1
      //   146: aload_0
      //   147: getfield b : Landroid/print/PrintAttributes;
      //   150: aload_0
      //   151: getfield c : Landroid/print/PrintAttributes;
      //   154: invokevirtual equals : (Ljava/lang/Object;)Z
      //   157: istore_2
      //   158: aload_0
      //   159: getfield d : Landroid/print/PrintDocumentAdapter$LayoutResultCallback;
      //   162: aload_1
      //   163: iconst_1
      //   164: iload_2
      //   165: ixor
      //   166: invokevirtual onLayoutFinished : (Landroid/print/PrintDocumentInfo;Z)V
      //   169: goto -> 180
      //   172: aload_0
      //   173: getfield d : Landroid/print/PrintDocumentAdapter$LayoutResultCallback;
      //   176: aconst_null
      //   177: invokevirtual onLayoutFailed : (Ljava/lang/CharSequence;)V
      //   180: aload_0
      //   181: getfield e : Landroidx/print/PrintHelper$PrintUriAdapter;
      //   184: aconst_null
      //   185: putfield f : Landroid/os/AsyncTask;
      //   188: return
      // Exception table:
      //   from	to	target	type
      //   34	48	104	finally
      //   105	107	104	finally
    }
    
    protected void b(Bitmap param1Bitmap) {
      this.d.onLayoutCancelled();
      this.e.f = null;
    }
    
    protected void onPreExecute() {
      this.a.setOnCancelListener(new CancellationSignal.OnCancelListener(this) {
            public void onCancel() {
              this.a.e.a();
              this.a.cancel(false);
            }
          });
    }
  }
  
  class null implements CancellationSignal.OnCancelListener {
    public void onCancel() {
      this.a.e.a();
      this.a.cancel(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\print\PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */