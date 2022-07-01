package com.loopj.android.http;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity implements HttpEntity {
  private static final byte[] CR_LF = "\r\n".getBytes();
  
  private static final String LOG_TAG = "SimpleMultipartEntity";
  
  private static final char[] MULTIPART_CHARS;
  
  private static final String STR_CR_LF = "\r\n";
  
  private static final byte[] TRANSFER_ENCODING_BINARY = "Content-Transfer-Encoding: binary\r\n".getBytes();
  
  private final String boundary;
  
  private final byte[] boundaryEnd;
  
  private final byte[] boundaryLine;
  
  private int bytesWritten;
  
  private final List<FilePart> fileParts = new ArrayList<FilePart>();
  
  private boolean isRepeatable;
  
  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  
  private final ResponseHandlerInterface progressHandler;
  
  private int totalSize;
  
  static {
    MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  }
  
  public SimpleMultipartEntity(ResponseHandlerInterface paramResponseHandlerInterface) {
    StringBuilder stringBuilder = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 30; i++) {
      char[] arrayOfChar = MULTIPART_CHARS;
      stringBuilder.append(arrayOfChar[random.nextInt(arrayOfChar.length)]);
    } 
    this.boundary = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append("--");
    stringBuilder.append(this.boundary);
    stringBuilder.append("\r\n");
    this.boundaryLine = stringBuilder.toString().getBytes();
    stringBuilder = new StringBuilder();
    stringBuilder.append("--");
    stringBuilder.append(this.boundary);
    stringBuilder.append("--");
    stringBuilder.append("\r\n");
    this.boundaryEnd = stringBuilder.toString().getBytes();
    this.progressHandler = paramResponseHandlerInterface;
  }
  
  private byte[] createContentDisposition(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    return stringBuilder.toString().getBytes();
  }
  
  private byte[] createContentDisposition(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(paramString1);
    stringBuilder.append("\"");
    stringBuilder.append("; filename=\"");
    stringBuilder.append(paramString2);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    return stringBuilder.toString().getBytes();
  }
  
  private byte[] createContentType(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Content-Type: ");
    stringBuilder.append(normalizeContentType(paramString));
    stringBuilder.append("\r\n");
    return stringBuilder.toString().getBytes();
  }
  
  private String normalizeContentType(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = "application/octet-stream"; 
    return str;
  }
  
  private void updateProgress(int paramInt) {
    this.bytesWritten += paramInt;
    this.progressHandler.sendProgressMessage(this.bytesWritten, this.totalSize);
  }
  
  public void addPart(String paramString, File paramFile) {
    addPart(paramString, paramFile, (String)null);
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2) {
    this.fileParts.add(new FilePart(paramString1, paramFile, normalizeContentType(paramString2)));
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2, String paramString3) {
    this.fileParts.add(new FilePart(paramString1, paramFile, normalizeContentType(paramString2), paramString3));
  }
  
  public void addPart(String paramString1, String paramString2) {
    addPartWithCharset(paramString1, paramString2, null);
  }
  
  public void addPart(String paramString1, String paramString2, InputStream paramInputStream, String paramString3) throws IOException {
    this.out.write(this.boundaryLine);
    this.out.write(createContentDisposition(paramString1, paramString2));
    this.out.write(createContentType(paramString3));
    this.out.write(TRANSFER_ENCODING_BINARY);
    this.out.write(CR_LF);
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i != -1) {
        this.out.write(arrayOfByte, 0, i);
        continue;
      } 
      this.out.write(CR_LF);
      this.out.flush();
      AsyncHttpClient.silentCloseOutputStream(this.out);
      return;
    } 
  }
  
  public void addPart(String paramString1, String paramString2, String paramString3) {
    try {
      this.out.write(this.boundaryLine);
      this.out.write(createContentDisposition(paramString1));
      this.out.write(createContentType(paramString3));
      this.out.write(CR_LF);
      this.out.write(paramString2.getBytes());
      this.out.write(CR_LF);
      return;
    } catch (IOException iOException) {
      Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", iOException);
      return;
    } 
  }
  
  public void addPartWithCharset(String paramString1, String paramString2, String paramString3) {
    String str = paramString3;
    if (paramString3 == null)
      str = "UTF-8"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("text/plain; charset=");
    stringBuilder.append(str);
    addPart(paramString1, paramString2, stringBuilder.toString());
  }
  
  public void consumeContent() throws IOException, UnsupportedOperationException {
    if (!isStreaming())
      return; 
    throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
  }
  
  public InputStream getContent() throws IOException, UnsupportedOperationException {
    throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
  }
  
  public Header getContentEncoding() {
    return null;
  }
  
  public long getContentLength() {
    long l = this.out.size();
    Iterator<FilePart> iterator = this.fileParts.iterator();
    while (iterator.hasNext()) {
      long l1 = ((FilePart)iterator.next()).getTotalLength();
      if (l1 < 0L)
        return -1L; 
      l += l1;
    } 
    return l + this.boundaryEnd.length;
  }
  
  public Header getContentType() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("multipart/form-data; boundary=");
    stringBuilder.append(this.boundary);
    return (Header)new BasicHeader("Content-Type", stringBuilder.toString());
  }
  
  public boolean isChunked() {
    return false;
  }
  
  public boolean isRepeatable() {
    return this.isRepeatable;
  }
  
  public boolean isStreaming() {
    return false;
  }
  
  public void setIsRepeatable(boolean paramBoolean) {
    this.isRepeatable = paramBoolean;
  }
  
  public void writeTo(OutputStream paramOutputStream) throws IOException {
    this.bytesWritten = 0;
    this.totalSize = (int)getContentLength();
    this.out.writeTo(paramOutputStream);
    updateProgress(this.out.size());
    Iterator<FilePart> iterator = this.fileParts.iterator();
    while (iterator.hasNext())
      ((FilePart)iterator.next()).writeTo(paramOutputStream); 
    paramOutputStream.write(this.boundaryEnd);
    updateProgress(this.boundaryEnd.length);
  }
  
  class FilePart {
    public File file;
    
    public byte[] header;
    
    public FilePart(String param1String1, File param1File, String param1String2) {
      this.header = createHeader(param1String1, param1File.getName(), param1String2);
      this.file = param1File;
    }
    
    public FilePart(String param1String1, File param1File, String param1String2, String param1String3) {
      String str = param1String3;
      if (TextUtils.isEmpty(param1String3))
        str = param1File.getName(); 
      this.header = createHeader(param1String1, str, param1String2);
      this.file = param1File;
    }
    
    private byte[] createHeader(String param1String1, String param1String2, String param1String3) {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      try {
        byteArrayOutputStream.write(SimpleMultipartEntity.this.boundaryLine);
        byteArrayOutputStream.write(SimpleMultipartEntity.this.createContentDisposition(param1String1, param1String2));
        byteArrayOutputStream.write(SimpleMultipartEntity.this.createContentType(param1String3));
        byteArrayOutputStream.write(SimpleMultipartEntity.TRANSFER_ENCODING_BINARY);
        byteArrayOutputStream.write(SimpleMultipartEntity.CR_LF);
      } catch (IOException iOException) {
        Log.e("SimpleMultipartEntity", "createHeader ByteArrayOutputStream exception", iOException);
      } 
      return byteArrayOutputStream.toByteArray();
    }
    
    public long getTotalLength() {
      long l1 = this.file.length();
      long l2 = SimpleMultipartEntity.CR_LF.length;
      return this.header.length + l1 + l2;
    }
    
    public void writeTo(OutputStream param1OutputStream) throws IOException {
      param1OutputStream.write(this.header);
      SimpleMultipartEntity.this.updateProgress(this.header.length);
      FileInputStream fileInputStream = new FileInputStream(this.file);
      byte[] arrayOfByte = new byte[4096];
      while (true) {
        int i = fileInputStream.read(arrayOfByte);
        if (i != -1) {
          param1OutputStream.write(arrayOfByte, 0, i);
          SimpleMultipartEntity.this.updateProgress(i);
          continue;
        } 
        param1OutputStream.write(SimpleMultipartEntity.CR_LF);
        SimpleMultipartEntity.this.updateProgress(SimpleMultipartEntity.CR_LF.length);
        param1OutputStream.flush();
        AsyncHttpClient.silentCloseInputStream(fileInputStream);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\SimpleMultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */