package com.huawei.hms.support.api.push.pushselfshow.prepare;

public enum NotifyStyle {
  STYLE_BIGPICTURE, STYLE_BIGTEXT, STYLE_DEFAULT, STYLE_INBOX;
  
  static {
    STYLE_BIGTEXT = new NotifyStyle("STYLE_BIGTEXT", 1);
    STYLE_BIGPICTURE = new NotifyStyle("STYLE_BIGPICTURE", 2);
    STYLE_INBOX = new NotifyStyle("STYLE_INBOX", 3);
    $VALUES = new NotifyStyle[] { STYLE_DEFAULT, STYLE_BIGTEXT, STYLE_BIGPICTURE, STYLE_INBOX };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfshow\prepare\NotifyStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */