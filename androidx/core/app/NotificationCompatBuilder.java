package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
  private final Notification.Builder a;
  
  private final NotificationCompat.Builder b;
  
  private RemoteViews c;
  
  private RemoteViews d;
  
  private final List<Bundle> e;
  
  private final Bundle f;
  
  private int g;
  
  private RemoteViews h;
  
  NotificationCompatBuilder(NotificationCompat.Builder paramBuilder) {
    boolean bool;
    this.e = new ArrayList<Bundle>();
    this.f = new Bundle();
    this.b = paramBuilder;
    if (Build.VERSION.SDK_INT >= 26) {
      this.a = new Notification.Builder(paramBuilder.mContext, paramBuilder.H);
    } else {
      this.a = new Notification.Builder(paramBuilder.mContext);
    } 
    Notification notification = paramBuilder.O;
    Notification.Builder builder = this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, paramBuilder.f).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
    if ((notification.flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    builder = builder.setOngoing(bool);
    if ((notification.flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    builder = builder.setOnlyAlertOnce(bool);
    if ((notification.flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    builder = builder.setAutoCancel(bool).setDefaults(notification.defaults).setContentTitle(paramBuilder.b).setContentText(paramBuilder.c).setContentInfo(paramBuilder.h).setContentIntent(paramBuilder.d).setDeleteIntent(notification.deleteIntent);
    PendingIntent pendingIntent = paramBuilder.e;
    if ((notification.flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    builder.setFullScreenIntent(pendingIntent, bool).setLargeIcon(paramBuilder.g).setNumber(paramBuilder.i).setProgress(paramBuilder.q, paramBuilder.r, paramBuilder.s);
    if (Build.VERSION.SDK_INT < 21)
      this.a.setSound(notification.sound, notification.audioStreamType); 
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.setSubText(paramBuilder.o).setUsesChronometer(paramBuilder.l).setPriority(paramBuilder.j);
      Iterator<NotificationCompat.Action> iterator = paramBuilder.mActions.iterator();
      while (iterator.hasNext())
        a(iterator.next()); 
      if (paramBuilder.A != null)
        this.f.putAll(paramBuilder.A); 
      if (Build.VERSION.SDK_INT < 20) {
        if (paramBuilder.w)
          this.f.putBoolean("android.support.localOnly", true); 
        if (paramBuilder.t != null) {
          this.f.putString("android.support.groupKey", paramBuilder.t);
          if (paramBuilder.u) {
            this.f.putBoolean("android.support.isGroupSummary", true);
          } else {
            this.f.putBoolean("android.support.useSideChannel", true);
          } 
        } 
        if (paramBuilder.v != null)
          this.f.putString("android.support.sortKey", paramBuilder.v); 
      } 
      this.c = paramBuilder.E;
      this.d = paramBuilder.F;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.setShowWhen(paramBuilder.k);
      if (Build.VERSION.SDK_INT < 21 && paramBuilder.mPeople != null && !paramBuilder.mPeople.isEmpty())
        this.f.putStringArray("android.people", paramBuilder.mPeople.<String>toArray(new String[paramBuilder.mPeople.size()])); 
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      this.a.setLocalOnly(paramBuilder.w).setGroup(paramBuilder.t).setGroupSummary(paramBuilder.u).setSortKey(paramBuilder.v);
      this.g = paramBuilder.L;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setCategory(paramBuilder.z).setColor(paramBuilder.B).setVisibility(paramBuilder.C).setPublicVersion(paramBuilder.D).setSound(notification.sound, notification.audioAttributes);
      for (String str : paramBuilder.mPeople)
        this.a.addPerson(str); 
      this.h = paramBuilder.G;
      if (paramBuilder.a.size() > 0) {
        Bundle bundle2 = paramBuilder.getExtras().getBundle("android.car.EXTENSIONS");
        Bundle bundle1 = bundle2;
        if (bundle2 == null)
          bundle1 = new Bundle(); 
        bundle2 = new Bundle();
        for (int i = 0; i < paramBuilder.a.size(); i++)
          bundle2.putBundle(Integer.toString(i), NotificationCompatJellybean.a(paramBuilder.a.get(i))); 
        bundle1.putBundle("invisible_actions", bundle2);
        paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", bundle1);
        this.f.putBundle("android.car.EXTENSIONS", bundle1);
      } 
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      this.a.setExtras(paramBuilder.A).setRemoteInputHistory(paramBuilder.p);
      if (paramBuilder.E != null)
        this.a.setCustomContentView(paramBuilder.E); 
      if (paramBuilder.F != null)
        this.a.setCustomBigContentView(paramBuilder.F); 
      if (paramBuilder.G != null)
        this.a.setCustomHeadsUpContentView(paramBuilder.G); 
    } 
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setBadgeIconType(paramBuilder.I).setShortcutId(paramBuilder.J).setTimeoutAfter(paramBuilder.K).setGroupAlertBehavior(paramBuilder.L);
      if (paramBuilder.y)
        this.a.setColorized(paramBuilder.x); 
      if (!TextUtils.isEmpty(paramBuilder.H))
        this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null); 
    } 
    if (Build.VERSION.SDK_INT >= 29) {
      this.a.setAllowSystemGeneratedContextualActions(paramBuilder.M);
      this.a.setBubbleMetadata(NotificationCompat.BubbleMetadata.toPlatform(paramBuilder.N));
    } 
  }
  
  private void a(Notification paramNotification) {
    paramNotification.sound = null;
    paramNotification.vibrate = null;
    paramNotification.defaults &= 0xFFFFFFFE;
    paramNotification.defaults &= 0xFFFFFFFD;
  }
  
  private void a(NotificationCompat.Action paramAction) {
    if (Build.VERSION.SDK_INT >= 20) {
      Notification.Action.Builder builder;
      Bundle bundle;
      if (Build.VERSION.SDK_INT >= 23) {
        Icon icon;
        IconCompat iconCompat = paramAction.getIconCompat();
        if (iconCompat == null) {
          iconCompat = null;
        } else {
          icon = iconCompat.toIcon();
        } 
        builder = new Notification.Action.Builder(icon, paramAction.getTitle(), paramAction.getActionIntent());
      } else {
        builder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      } 
      if (paramAction.getRemoteInputs() != null) {
        RemoteInput[] arrayOfRemoteInput = RemoteInput.a(paramAction.getRemoteInputs());
        int j = arrayOfRemoteInput.length;
        for (int i = 0; i < j; i++)
          builder.addRemoteInput(arrayOfRemoteInput[i]); 
      } 
      if (paramAction.getExtras() != null) {
        bundle = new Bundle(paramAction.getExtras());
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24)
        builder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies()); 
      bundle.putInt("android.support.action.semanticAction", paramAction.getSemanticAction());
      if (Build.VERSION.SDK_INT >= 28)
        builder.setSemanticAction(paramAction.getSemanticAction()); 
      if (Build.VERSION.SDK_INT >= 29)
        builder.setContextual(paramAction.isContextual()); 
      bundle.putBoolean("android.support.action.showsUserInterface", paramAction.getShowsUserInterface());
      builder.addExtras(bundle);
      this.a.addAction(builder.build());
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      this.e.add(NotificationCompatJellybean.writeActionAndGetExtras(this.a, paramAction)); 
  }
  
  protected Notification a() {
    if (Build.VERSION.SDK_INT >= 26)
      return this.a.build(); 
    if (Build.VERSION.SDK_INT >= 24) {
      Notification notification = this.a.build();
      if (this.g != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews = this.c;
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      remoteViews = this.d;
      if (remoteViews != null)
        notification.bigContentView = remoteViews; 
      remoteViews = this.h;
      if (remoteViews != null)
        notification.headsUpContentView = remoteViews; 
      if (this.g != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 20) {
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews = this.c;
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      remoteViews = this.d;
      if (remoteViews != null)
        notification.bigContentView = remoteViews; 
      if (this.g != 0) {
        if (notification.getGroup() != null && (notification.flags & 0x200) != 0 && this.g == 2)
          a(notification); 
        if (notification.getGroup() != null && (notification.flags & 0x200) == 0 && this.g == 1)
          a(notification); 
      } 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      SparseArray<Bundle> sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.e);
      if (sparseArray != null)
        this.f.putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      this.a.setExtras(this.f);
      Notification notification = this.a.build();
      RemoteViews remoteViews = this.c;
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      remoteViews = this.d;
      if (remoteViews != null)
        notification.bigContentView = remoteViews; 
      return notification;
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      Notification notification = this.a.build();
      Bundle bundle1 = NotificationCompat.getExtras(notification);
      Bundle bundle2 = new Bundle(this.f);
      for (String str : this.f.keySet()) {
        if (bundle1.containsKey(str))
          bundle2.remove(str); 
      } 
      bundle1.putAll(bundle2);
      SparseArray<Bundle> sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.e);
      if (sparseArray != null)
        NotificationCompat.getExtras(notification).putSparseParcelableArray("android.support.actionExtras", sparseArray); 
      RemoteViews remoteViews = this.c;
      if (remoteViews != null)
        notification.contentView = remoteViews; 
      remoteViews = this.d;
      if (remoteViews != null)
        notification.bigContentView = remoteViews; 
      return notification;
    } 
    return this.a.getNotification();
  }
  
  public Notification build() {
    RemoteViews remoteViews;
    NotificationCompat.Style style = this.b.n;
    if (style != null)
      style.apply(this); 
    if (style != null) {
      remoteViews = style.makeContentView(this);
    } else {
      remoteViews = null;
    } 
    Notification notification = a();
    if (remoteViews != null) {
      notification.contentView = remoteViews;
    } else if (this.b.E != null) {
      notification.contentView = this.b.E;
    } 
    if (Build.VERSION.SDK_INT >= 16 && style != null) {
      remoteViews = style.makeBigContentView(this);
      if (remoteViews != null)
        notification.bigContentView = remoteViews; 
    } 
    if (Build.VERSION.SDK_INT >= 21 && style != null) {
      remoteViews = this.b.n.makeHeadsUpContentView(this);
      if (remoteViews != null)
        notification.headsUpContentView = remoteViews; 
    } 
    if (Build.VERSION.SDK_INT >= 16 && style != null) {
      Bundle bundle = NotificationCompat.getExtras(notification);
      if (bundle != null)
        style.addCompatExtras(bundle); 
    } 
    return notification;
  }
  
  public Notification.Builder getBuilder() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\NotificationCompatBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */