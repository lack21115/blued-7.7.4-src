package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.os.CancellationSignal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
  final Loader<Cursor>.ForceLoadContentObserver f = new Loader.ForceLoadContentObserver(this);
  
  Uri g;
  
  String[] h;
  
  String i;
  
  String[] j;
  
  String k;
  
  Cursor l;
  
  CancellationSignal m;
  
  public CursorLoader(Context paramContext) {
    super(paramContext);
  }
  
  public CursorLoader(Context paramContext, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2) {
    super(paramContext);
    this.g = paramUri;
    this.h = paramArrayOfString1;
    this.i = paramString1;
    this.j = paramArrayOfString2;
    this.k = paramString2;
  }
  
  public void cancelLoadInBackground() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial cancelLoadInBackground : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield m : Landroidx/core/os/CancellationSignal;
    //   10: ifnull -> 20
    //   13: aload_0
    //   14: getfield m : Landroidx/core/os/CancellationSignal;
    //   17: invokevirtual cancel : ()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   6	20	23	finally
    //   20	22	23	finally
    //   24	26	23	finally
  }
  
  public void deliverResult(Cursor paramCursor) {
    if (isReset()) {
      if (paramCursor != null)
        paramCursor.close(); 
      return;
    } 
    Cursor cursor = this.l;
    this.l = paramCursor;
    if (isStarted())
      super.deliverResult(paramCursor); 
    if (cursor != null && cursor != paramCursor && !cursor.isClosed())
      cursor.close(); 
  }
  
  @Deprecated
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(this.g);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString((Object[])this.h));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(this.i);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString((Object[])this.j));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(this.k);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(this.l);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(this.u);
  }
  
  protected void e() {
    Cursor cursor = this.l;
    if (cursor != null)
      deliverResult(cursor); 
    if (takeContentChanged() || this.l == null)
      forceLoad(); 
  }
  
  protected void f() {
    cancelLoad();
  }
  
  protected void g() {
    super.g();
    f();
    Cursor cursor = this.l;
    if (cursor != null && !cursor.isClosed())
      this.l.close(); 
    this.l = null;
  }
  
  public String[] getProjection() {
    return this.h;
  }
  
  public String getSelection() {
    return this.i;
  }
  
  public String[] getSelectionArgs() {
    return this.j;
  }
  
  public String getSortOrder() {
    return this.k;
  }
  
  public Uri getUri() {
    return this.g;
  }
  
  public Cursor loadInBackground() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual isLoadInBackgroundCanceled : ()Z
    //   6: ifne -> 123
    //   9: aload_0
    //   10: new androidx/core/os/CancellationSignal
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: putfield m : Landroidx/core/os/CancellationSignal;
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: invokevirtual getContext : ()Landroid/content/Context;
    //   26: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   29: aload_0
    //   30: getfield g : Landroid/net/Uri;
    //   33: aload_0
    //   34: getfield h : [Ljava/lang/String;
    //   37: aload_0
    //   38: getfield i : Ljava/lang/String;
    //   41: aload_0
    //   42: getfield j : [Ljava/lang/String;
    //   45: aload_0
    //   46: getfield k : Ljava/lang/String;
    //   49: aload_0
    //   50: getfield m : Landroidx/core/os/CancellationSignal;
    //   53: invokestatic query : (Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroidx/core/os/CancellationSignal;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull -> 90
    //   61: aload_1
    //   62: invokeinterface getCount : ()I
    //   67: pop
    //   68: aload_1
    //   69: aload_0
    //   70: getfield f : Landroidx/loader/content/Loader$ForceLoadContentObserver;
    //   73: invokeinterface registerContentObserver : (Landroid/database/ContentObserver;)V
    //   78: goto -> 90
    //   81: astore_2
    //   82: aload_1
    //   83: invokeinterface close : ()V
    //   88: aload_2
    //   89: athrow
    //   90: aload_0
    //   91: monitorenter
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield m : Landroidx/core/os/CancellationSignal;
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: monitorenter
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield m : Landroidx/core/os/CancellationSignal;
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: new androidx/core/os/OperationCanceledException
    //   126: dup
    //   127: invokespecial <init> : ()V
    //   130: athrow
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	131	finally
    //   22	57	106	finally
    //   61	78	81	java/lang/RuntimeException
    //   61	78	106	finally
    //   82	90	106	finally
    //   92	99	101	finally
    //   102	104	101	finally
    //   109	116	118	finally
    //   119	121	118	finally
    //   123	131	131	finally
    //   132	134	131	finally
  }
  
  public void onCanceled(Cursor paramCursor) {
    if (paramCursor != null && !paramCursor.isClosed())
      paramCursor.close(); 
  }
  
  public void setProjection(String[] paramArrayOfString) {
    this.h = paramArrayOfString;
  }
  
  public void setSelection(String paramString) {
    this.i = paramString;
  }
  
  public void setSelectionArgs(String[] paramArrayOfString) {
    this.j = paramArrayOfString;
  }
  
  public void setSortOrder(String paramString) {
    this.k = paramString;
  }
  
  public void setUri(Uri paramUri) {
    this.g = paramUri;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\loader\content\CursorLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */