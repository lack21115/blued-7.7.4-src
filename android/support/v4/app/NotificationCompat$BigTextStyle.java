package android.support.v4.app;

import android.app.Notification;
import android.os.Build;

public final class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
  private CharSequence mBigText;
  
  public final void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {
    if (Build.VERSION.SDK_INT >= 16) {
      Notification.BigTextStyle bigTextStyle = (new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
      if (this.mSummaryTextSet)
        bigTextStyle.setSummaryText(this.mSummaryText); 
    } 
  }
  
  public final NotificationCompat$BigTextStyle bigText(CharSequence paramCharSequence) {
    this.mBigText = NotificationCompat$Builder.limitCharSequenceLength(paramCharSequence);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\NotificationCompat$BigTextStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */