package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

public final class NotificationCompat$Builder {
  public ArrayList mActions = new ArrayList();
  
  int mBadgeIcon = 0;
  
  RemoteViews mBigContentView;
  
  String mCategory;
  
  public String mChannelId;
  
  int mColor = 0;
  
  boolean mColorized;
  
  boolean mColorizedSet;
  
  CharSequence mContentInfo;
  
  public PendingIntent mContentIntent;
  
  CharSequence mContentText;
  
  CharSequence mContentTitle;
  
  RemoteViews mContentView;
  
  public Context mContext;
  
  Bundle mExtras;
  
  PendingIntent mFullScreenIntent;
  
  int mGroupAlertBehavior = 0;
  
  String mGroupKey;
  
  boolean mGroupSummary;
  
  RemoteViews mHeadsUpContentView;
  
  Bitmap mLargeIcon;
  
  public boolean mLocalOnly = false;
  
  public Notification mNotification = new Notification();
  
  int mNumber;
  
  @Deprecated
  public ArrayList mPeople;
  
  int mPriority;
  
  int mProgress;
  
  boolean mProgressIndeterminate;
  
  int mProgressMax;
  
  Notification mPublicVersion;
  
  CharSequence[] mRemoteInputHistory;
  
  String mShortcutId;
  
  boolean mShowWhen = true;
  
  String mSortKey;
  
  NotificationCompat$Style mStyle;
  
  CharSequence mSubText;
  
  RemoteViews mTickerView;
  
  long mTimeout;
  
  boolean mUseChronometer;
  
  int mVisibility = 0;
  
  @Deprecated
  public NotificationCompat$Builder(Context paramContext) {
    this(paramContext, null);
  }
  
  private NotificationCompat$Builder(Context paramContext, String paramString) {
    this.mContext = paramContext;
    this.mChannelId = paramString;
    this.mNotification.when = System.currentTimeMillis();
    this.mNotification.audioStreamType = -1;
    this.mPriority = 0;
    this.mPeople = new ArrayList();
  }
  
  protected static CharSequence limitCharSequenceLength(CharSequence paramCharSequence) {
    if (paramCharSequence == null)
      return paramCharSequence; 
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120)
      charSequence = paramCharSequence.subSequence(0, 5120); 
    return charSequence;
  }
  
  public final NotificationCompat$Builder setContentText(CharSequence paramCharSequence) {
    this.mContentText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public final NotificationCompat$Builder setContentTitle(CharSequence paramCharSequence) {
    this.mContentTitle = limitCharSequenceLength(paramCharSequence);
    return this;
  }
  
  public final NotificationCompat$Builder setStyle(NotificationCompat$Style paramNotificationCompat$Style) {
    if (this.mStyle != paramNotificationCompat$Style) {
      this.mStyle = paramNotificationCompat$Style;
      if (this.mStyle != null) {
        paramNotificationCompat$Style = this.mStyle;
        if (paramNotificationCompat$Style.mBuilder != this) {
          paramNotificationCompat$Style.mBuilder = this;
          if (paramNotificationCompat$Style.mBuilder != null)
            paramNotificationCompat$Style.mBuilder.setStyle(paramNotificationCompat$Style); 
        } 
      } 
    } 
    return this;
  }
  
  public final NotificationCompat$Builder setTicker(CharSequence paramCharSequence) {
    this.mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\NotificationCompat$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */