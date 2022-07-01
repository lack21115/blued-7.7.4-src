package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
  private final List mActionExtrasList;
  
  private RemoteViews mBigContentView;
  
  private final Notification.Builder mBuilder;
  
  private final NotificationCompat$Builder mBuilderCompat;
  
  private RemoteViews mContentView;
  
  private final Bundle mExtras;
  
  private int mGroupAlertBehavior;
  
  private RemoteViews mHeadsUpContentView;
  
  public NotificationCompatBuilder(NotificationCompat$Builder paramNotificationCompat$Builder) {
    boolean bool1;
    this.mActionExtrasList = new ArrayList();
    this.mExtras = new Bundle();
    this.mBuilderCompat = paramNotificationCompat$Builder;
    if (Build.VERSION.SDK_INT >= 26) {
      this.mBuilder = new Notification.Builder(paramNotificationCompat$Builder.mContext, paramNotificationCompat$Builder.mChannelId);
    } else {
      this.mBuilder = new Notification.Builder(paramNotificationCompat$Builder.mContext);
    } 
    Notification notification = paramNotificationCompat$Builder.mNotification;
    Notification.Builder builder = this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, paramNotificationCompat$Builder.mTickerView).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
    int i = notification.flags;
    boolean bool2 = false;
    if ((i & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    builder = builder.setOngoing(bool1);
    if ((notification.flags & 0x8) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    builder = builder.setOnlyAlertOnce(bool1);
    if ((notification.flags & 0x10) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    builder = builder.setAutoCancel(bool1).setDefaults(notification.defaults).setContentTitle(paramNotificationCompat$Builder.mContentTitle).setContentText(paramNotificationCompat$Builder.mContentText).setContentInfo(paramNotificationCompat$Builder.mContentInfo).setContentIntent(paramNotificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
    PendingIntent pendingIntent = paramNotificationCompat$Builder.mFullScreenIntent;
    if ((notification.flags & 0x80) != 0) {
      bool1 = true;
    } else {
      bool1 = bool2;
    } 
    builder.setFullScreenIntent(pendingIntent, bool1).setLargeIcon(paramNotificationCompat$Builder.mLargeIcon).setNumber(paramNotificationCompat$Builder.mNumber).setProgress(paramNotificationCompat$Builder.mProgressMax, paramNotificationCompat$Builder.mProgress, paramNotificationCompat$Builder.mProgressIndeterminate);
    if (Build.VERSION.SDK_INT >= 16) {
      this.mBuilder.setSubText(paramNotificationCompat$Builder.mSubText).setUsesChronometer(paramNotificationCompat$Builder.mUseChronometer).setPriority(paramNotificationCompat$Builder.mPriority);
      Iterator<NotificationCompat$Action> iterator = paramNotificationCompat$Builder.mActions.iterator();
      while (iterator.hasNext())
        addAction(iterator.next()); 
      if (paramNotificationCompat$Builder.mExtras != null)
        this.mExtras.putAll(paramNotificationCompat$Builder.mExtras); 
      if (Build.VERSION.SDK_INT < 20) {
        if (paramNotificationCompat$Builder.mLocalOnly)
          this.mExtras.putBoolean("android.support.localOnly", true); 
        if (paramNotificationCompat$Builder.mGroupKey != null) {
          this.mExtras.putString("android.support.groupKey", paramNotificationCompat$Builder.mGroupKey);
          if (paramNotificationCompat$Builder.mGroupSummary) {
            this.mExtras.putBoolean("android.support.isGroupSummary", true);
          } else {
            this.mExtras.putBoolean("android.support.useSideChannel", true);
          } 
        } 
        if (paramNotificationCompat$Builder.mSortKey != null)
          this.mExtras.putString("android.support.sortKey", paramNotificationCompat$Builder.mSortKey); 
      } 
      this.mContentView = paramNotificationCompat$Builder.mContentView;
      this.mBigContentView = paramNotificationCompat$Builder.mBigContentView;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      this.mBuilder.setShowWhen(paramNotificationCompat$Builder.mShowWhen);
      if (Build.VERSION.SDK_INT < 21 && paramNotificationCompat$Builder.mPeople != null && !paramNotificationCompat$Builder.mPeople.isEmpty())
        this.mExtras.putStringArray("android.people", (String[])paramNotificationCompat$Builder.mPeople.toArray((Object[])new String[paramNotificationCompat$Builder.mPeople.size()])); 
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      this.mBuilder.setLocalOnly(paramNotificationCompat$Builder.mLocalOnly).setGroup(paramNotificationCompat$Builder.mGroupKey).setGroupSummary(paramNotificationCompat$Builder.mGroupSummary).setSortKey(paramNotificationCompat$Builder.mSortKey);
      this.mGroupAlertBehavior = paramNotificationCompat$Builder.mGroupAlertBehavior;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.mBuilder.setCategory(paramNotificationCompat$Builder.mCategory).setColor(paramNotificationCompat$Builder.mColor).setVisibility(paramNotificationCompat$Builder.mVisibility).setPublicVersion(paramNotificationCompat$Builder.mPublicVersion);
      for (String str : paramNotificationCompat$Builder.mPeople)
        this.mBuilder.addPerson(str); 
      this.mHeadsUpContentView = paramNotificationCompat$Builder.mHeadsUpContentView;
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      this.mBuilder.setExtras(paramNotificationCompat$Builder.mExtras).setRemoteInputHistory(paramNotificationCompat$Builder.mRemoteInputHistory);
      if (paramNotificationCompat$Builder.mContentView != null)
        this.mBuilder.setCustomContentView(paramNotificationCompat$Builder.mContentView); 
      if (paramNotificationCompat$Builder.mBigContentView != null)
        this.mBuilder.setCustomBigContentView(paramNotificationCompat$Builder.mBigContentView); 
      if (paramNotificationCompat$Builder.mHeadsUpContentView != null)
        this.mBuilder.setCustomHeadsUpContentView(paramNotificationCompat$Builder.mHeadsUpContentView); 
    } 
    if (Build.VERSION.SDK_INT >= 26) {
      this.mBuilder.setBadgeIconType(paramNotificationCompat$Builder.mBadgeIcon).setShortcutId(paramNotificationCompat$Builder.mShortcutId).setTimeoutAfter(paramNotificationCompat$Builder.mTimeout).setGroupAlertBehavior(paramNotificationCompat$Builder.mGroupAlertBehavior);
      if (paramNotificationCompat$Builder.mColorizedSet)
        this.mBuilder.setColorized(paramNotificationCompat$Builder.mColorized); 
    } 
  }
  
  private void addAction(NotificationCompat$Action paramNotificationCompat$Action) {
    if (Build.VERSION.SDK_INT >= 20) {
      Bundle bundle;
      Notification.Action.Builder builder = new Notification.Action.Builder(paramNotificationCompat$Action.icon, paramNotificationCompat$Action.title, paramNotificationCompat$Action.actionIntent);
      if (paramNotificationCompat$Action.mRemoteInputs != null) {
        RemoteInput[] arrayOfRemoteInput = RemoteInput.fromCompat(paramNotificationCompat$Action.mRemoteInputs);
        int j = arrayOfRemoteInput.length;
        for (int i = 0; i < j; i++)
          builder.addRemoteInput(arrayOfRemoteInput[i]); 
      } 
      if (paramNotificationCompat$Action.mExtras != null) {
        bundle = new Bundle(paramNotificationCompat$Action.mExtras);
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", paramNotificationCompat$Action.mAllowGeneratedReplies);
      if (Build.VERSION.SDK_INT >= 24)
        builder.setAllowGeneratedReplies(paramNotificationCompat$Action.mAllowGeneratedReplies); 
      builder.addExtras(bundle);
      this.mBuilder.addAction(builder.build());
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.mBuilder, paramNotificationCompat$Action)); 
  }
  
  private static void removeSoundAndVibration(Notification paramNotification) {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  public final Notification build() {
    Notification notification;
    NotificationCompat$Style notificationCompat$Style = this.mBuilderCompat.mStyle;
    if (notificationCompat$Style != null)
      notificationCompat$Style.apply(this); 
    if (Build.VERSION.SDK_INT >= 26) {
      notification = this.mBuilder.build();
    } else if (Build.VERSION.SDK_INT >= 24) {
      notification = this.mBuilder.build();
      if (this.mGroupAlertBehavior != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2)
          removeSoundAndVibration(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1)
          removeSoundAndVibration(notification); 
      } 
    } else if (Build.VERSION.SDK_INT >= 21) {
      this.mBuilder.setExtras(this.mExtras);
      notification = this.mBuilder.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
      if (this.mHeadsUpContentView != null)
        notification.headsUpContentView = this.mHeadsUpContentView; 
      if (this.mGroupAlertBehavior != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2)
          removeSoundAndVibration(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1)
          removeSoundAndVibration(notification); 
      } 
    } else if (Build.VERSION.SDK_INT >= 20) {
      this.mBuilder.setExtras(this.mExtras);
      notification = this.mBuilder.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
      if (this.mGroupAlertBehavior != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.mGroupAlertBehavior == 2)
          removeSoundAndVibration(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.mGroupAlertBehavior == 1)
          removeSoundAndVibration(notification); 
      } 
    } else if (Build.VERSION.SDK_INT >= 19) {
      SparseArray sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (sparseArray != null)
        this.mExtras.putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      this.mBuilder.setExtras(this.mExtras);
      notification = this.mBuilder.build();
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
    } else if (Build.VERSION.SDK_INT >= 16) {
      notification = this.mBuilder.build();
      Bundle bundle1 = NotificationCompat.getExtras(notification);
      Bundle bundle2 = new Bundle(this.mExtras);
      for (String str : this.mExtras.keySet()) {
        if (bundle1.containsKey(str))
          bundle2.remove(str); 
      } 
      bundle1.putAll(bundle2);
      SparseArray sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if (sparseArray != null)
        NotificationCompat.getExtras(notification).putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      if (this.mContentView != null)
        notification.contentView = this.mContentView; 
      if (this.mBigContentView != null)
        notification.bigContentView = this.mBigContentView; 
    } else {
      notification = this.mBuilder.getNotification();
    } 
    if (this.mBuilderCompat.mContentView != null)
      notification.contentView = this.mBuilderCompat.mContentView; 
    int i = Build.VERSION.SDK_INT;
    i = Build.VERSION.SDK_INT;
    if (Build.VERSION.SDK_INT >= 16 && notificationCompat$Style != null)
      NotificationCompat.getExtras(notification); 
    return notification;
  }
  
  public final Notification.Builder getBuilder() {
    return this.mBuilder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\NotificationCompatBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */