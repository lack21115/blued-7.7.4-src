package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class SingleDocumentFile extends DocumentFile {
  private Context a;
  
  private Uri b;
  
  SingleDocumentFile(DocumentFile paramDocumentFile, Context paramContext, Uri paramUri) {
    super(paramDocumentFile);
    this.a = paramContext;
    this.b = paramUri;
  }
  
  public boolean canRead() {
    return DocumentsContractApi19.canRead(this.a, this.b);
  }
  
  public boolean canWrite() {
    return DocumentsContractApi19.canWrite(this.a, this.b);
  }
  
  public DocumentFile createDirectory(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public DocumentFile createFile(String paramString1, String paramString2) {
    throw new UnsupportedOperationException();
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
    throw new UnsupportedOperationException();
  }
  
  public boolean renameTo(String paramString) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\documentfile\provider\SingleDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */