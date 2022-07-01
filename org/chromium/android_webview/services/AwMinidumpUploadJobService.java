package org.chromium.android_webview.services;

import org.chromium.components.minidump_uploader.MinidumpUploadJobService;
import org.chromium.components.minidump_uploader.MinidumpUploader;
import org.chromium.components.minidump_uploader.MinidumpUploaderImpl;

public class AwMinidumpUploadJobService extends MinidumpUploadJobService {
  protected final MinidumpUploader createMinidumpUploader$78a09a4b() {
    return (MinidumpUploader)new MinidumpUploaderImpl(new AwMinidumpUploaderDelegate());
  }
  
  public void onCreate() {
    super.onCreate();
    ServiceInit.init(getApplicationContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\AwMinidumpUploadJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */