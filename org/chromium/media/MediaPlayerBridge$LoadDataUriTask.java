package org.chromium.media;

import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.chromium.base.AsyncTask;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.StreamUtil;

final class MediaPlayerBridge$LoadDataUriTask extends AsyncTask {
  private final String mData;
  
  private File mTempFile;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public MediaPlayerBridge$LoadDataUriTask(String paramString) {
    this.mData = paramString;
  }
  
  private void deleteFile() {
    if (this.mTempFile == null)
      return; 
    if (!this.mTempFile.delete()) {
      StringBuilder stringBuilder = new StringBuilder("Failed to delete temporary file: ");
      stringBuilder.append(this.mTempFile);
      Log.e("cr.media", stringBuilder.toString(), new Object[0]);
      assert false;
      throw new AssertionError();
    } 
  }
  
  private Boolean doInBackground$5f8445a4() {
    byte[] arrayOfByte = null;
    FileOutputStream fileOutputStream1 = null;
    FileOutputStream fileOutputStream2 = fileOutputStream1;
    try {
      this.mTempFile = File.createTempFile("decoded", "mediadata");
      fileOutputStream2 = fileOutputStream1;
    } catch (IOException iOException) {
    
    } finally {
      byte[] arrayOfByte1;
      arrayOfByte = null;
      fileOutputStream1 = fileOutputStream2;
    } 
    StreamUtil.closeQuietly(fileOutputStream1);
    return Boolean.valueOf(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaPlayerBridge$LoadDataUriTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */