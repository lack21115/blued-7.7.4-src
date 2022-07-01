package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

class TreeDocumentFile extends DocumentFile {
  private Context a;
  
  private Uri b;
  
  TreeDocumentFile(DocumentFile paramDocumentFile, Context paramContext, Uri paramUri) {
    super(paramDocumentFile);
    this.a = paramContext;
    this.b = paramUri;
  }
  
  private static Uri a(Context paramContext, Uri paramUri, String paramString1, String paramString2) {
    try {
      return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private static void a(AutoCloseable paramAutoCloseable) {
    if (paramAutoCloseable != null)
      try {
        paramAutoCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  public boolean canRead() {
    return DocumentsContractApi19.canRead(this.a, this.b);
  }
  
  public boolean canWrite() {
    return DocumentsContractApi19.canWrite(this.a, this.b);
  }
  
  public DocumentFile createDirectory(String paramString) {
    Uri uri = a(this.a, this.b, "vnd.android.document/directory", paramString);
    return (uri != null) ? new TreeDocumentFile(this, this.a, uri) : null;
  }
  
  public DocumentFile createFile(String paramString1, String paramString2) {
    Uri uri = a(this.a, this.b, paramString1, paramString2);
    return (uri != null) ? new TreeDocumentFile(this, this.a, uri) : null;
  }
  
  public boolean delete() {
    try {
      return DocumentsContract.deleteDocument(this.a.getContentResolver(), this.b);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public boolean exists() {
    return DocumentsContractApi19.exists(this.a, this.b);
  }
  
  public String getName() {
    return DocumentsContractApi19.getName(this.a, this.b);
  }
  
  public String getType() {
    return DocumentsContractApi19.getType(this.a, this.b);
  }
  
  public Uri getUri() {
    return this.b;
  }
  
  public boolean isDirectory() {
    return DocumentsContractApi19.isDirectory(this.a, this.b);
  }
  
  public boolean isFile() {
    return DocumentsContractApi19.isFile(this.a, this.b);
  }
  
  public boolean isVirtual() {
    return DocumentsContractApi19.isVirtual(this.a, this.b);
  }
  
  public long lastModified() {
    return DocumentsContractApi19.lastModified(this.a, this.b);
  }
  
  public long length() {
    return DocumentsContractApi19.length(this.a, this.b);
  }
  
  public DocumentFile[] listFiles() {
    Cursor cursor1;
    ContentResolver contentResolver = this.a.getContentResolver();
    Uri uri1 = this.b;
    Uri uri2 = DocumentsContract.buildChildDocumentsUriUsingTree(uri1, DocumentsContract.getDocumentId(uri1));
    ArrayList<Uri> arrayList = new ArrayList();
    int i = 0;
    uri1 = null;
    Cursor cursor2 = null;
    try {
      String str;
      Cursor cursor = contentResolver.query(uri2, new String[] { "document_id" }, null, null, null);
      while (true) {
        Cursor cursor3 = cursor;
        cursor2 = cursor;
        cursor1 = cursor;
        if (cursor.moveToNext()) {
          cursor2 = cursor;
          cursor1 = cursor;
          str = cursor.getString(0);
          cursor2 = cursor;
          cursor1 = cursor;
          arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.b, str));
          continue;
        } 
        break;
      } 
      a((AutoCloseable)str);
    } catch (Exception exception) {
      cursor2 = cursor1;
      StringBuilder stringBuilder = new StringBuilder();
      cursor2 = cursor1;
      stringBuilder.append("Failed query: ");
      cursor2 = cursor1;
      stringBuilder.append(exception);
      cursor2 = cursor1;
      Log.w("DocumentFile", stringBuilder.toString());
      Cursor cursor = cursor1;
      a((AutoCloseable)cursor);
    } finally {}
    Uri[] arrayOfUri = arrayList.<Uri>toArray(new Uri[arrayList.size()]);
    DocumentFile[] arrayOfDocumentFile = new DocumentFile[arrayOfUri.length];
    while (i < arrayOfUri.length) {
      arrayOfDocumentFile[i] = new TreeDocumentFile(this, this.a, arrayOfUri[i]);
      i++;
    } 
    return arrayOfDocumentFile;
  }
  
  public boolean renameTo(String paramString) {
    try {
      Uri uri = DocumentsContract.renameDocument(this.a.getContentResolver(), this.b, paramString);
      if (uri != null) {
        this.b = uri;
        return true;
      } 
      return false;
    } catch (Exception exception) {
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\documentfile\provider\TreeDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */