package org.chromium.content.app;

import org.chromium.base.process_launcher.ChildProcessService;

public class ContentChildProcessService extends ChildProcessService {
  public ContentChildProcessService() {
    super(new ContentChildProcessServiceDelegate());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\app\ContentChildProcessService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */