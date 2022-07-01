package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;

public class NotificationCompat {
  public static class DecoratedMediaCustomViewStyle extends MediaStyle {
    private void a(RemoteViews param1RemoteViews) {
      int i;
      if (this.a.getColor() != 0) {
        i = this.a.getColor();
      } else {
        i = this.a.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
      } 
      param1RemoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
    }
    
    int a() {
      return (this.a.getContentView() != null) ? R.layout.notification_template_media_custom : super.a();
    }
    
    int a(int param1Int) {
      return (param1Int <= 3) ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 24) {
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)a((Notification.MediaStyle)new Notification.DecoratedMediaCustomViewStyle()));
        return;
      } 
      super.apply(param1NotificationBuilderWithBuilderAccessor);
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews1;
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      if (this.a.getBigContentView() != null) {
        remoteViews1 = this.a.getBigContentView();
      } else {
        remoteViews1 = this.a.getContentView();
      } 
      if (remoteViews1 == null)
        return null; 
      RemoteViews remoteViews2 = c();
      buildIntoRemoteViews(remoteViews2, remoteViews1);
      if (Build.VERSION.SDK_INT >= 21)
        a(remoteViews2); 
      return remoteViews2;
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      boolean bool1;
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      RemoteViews remoteViews = this.a.getContentView();
      boolean bool2 = true;
      if (remoteViews != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (Build.VERSION.SDK_INT >= 21) {
        boolean bool = bool2;
        if (!bool1)
          if (this.a.getBigContentView() != null) {
            bool = bool2;
          } else {
            bool = false;
          }  
        if (bool) {
          remoteViews = b();
          if (bool1)
            buildIntoRemoteViews(remoteViews, this.a.getContentView()); 
          a(remoteViews);
          return remoteViews;
        } 
      } else {
        remoteViews = b();
        if (bool1) {
          buildIntoRemoteViews(remoteViews, this.a.getContentView());
          return remoteViews;
        } 
      } 
      return null;
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews1;
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      if (this.a.getHeadsUpContentView() != null) {
        remoteViews1 = this.a.getHeadsUpContentView();
      } else {
        remoteViews1 = this.a.getContentView();
      } 
      if (remoteViews1 == null)
        return null; 
      RemoteViews remoteViews2 = c();
      buildIntoRemoteViews(remoteViews2, remoteViews1);
      if (Build.VERSION.SDK_INT >= 21)
        a(remoteViews2); 
      return remoteViews2;
    }
  }
  
  public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
    int[] e = null;
    
    MediaSessionCompat.Token f;
    
    boolean g;
    
    PendingIntent h;
    
    public MediaStyle() {}
    
    public MediaStyle(androidx.core.app.NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    private RemoteViews a(androidx.core.app.NotificationCompat.Action param1Action) {
      boolean bool;
      if (param1Action.getActionIntent() == null) {
        bool = true;
      } else {
        bool = false;
      } 
      RemoteViews remoteViews = new RemoteViews(this.a.mContext.getPackageName(), R.layout.notification_media_action);
      remoteViews.setImageViewResource(R.id.action0, param1Action.getIcon());
      if (!bool)
        remoteViews.setOnClickPendingIntent(R.id.action0, param1Action.getActionIntent()); 
      if (Build.VERSION.SDK_INT >= 15)
        remoteViews.setContentDescription(R.id.action0, param1Action.getTitle()); 
      return remoteViews;
    }
    
    public static MediaSessionCompat.Token getMediaSession(Notification param1Notification) {
      Bundle bundle = androidx.core.app.NotificationCompat.getExtras(param1Notification);
      if (bundle != null) {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 21) {
          parcelable = bundle.getParcelable("android.mediaSession");
          if (parcelable != null)
            return MediaSessionCompat.Token.fromToken(parcelable); 
        } else {
          IBinder iBinder = BundleCompat.getBinder((Bundle)parcelable, "android.mediaSession");
          if (iBinder != null) {
            Parcel parcel = Parcel.obtain();
            parcel.writeStrongBinder(iBinder);
            parcel.setDataPosition(0);
            MediaSessionCompat.Token token = (MediaSessionCompat.Token)MediaSessionCompat.Token.CREATOR.createFromParcel(parcel);
            parcel.recycle();
            return token;
          } 
        } 
      } 
      return null;
    }
    
    int a() {
      return R.layout.notification_template_media;
    }
    
    int a(int param1Int) {
      return (param1Int <= 3) ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
    }
    
    Notification.MediaStyle a(Notification.MediaStyle param1MediaStyle) {
      int[] arrayOfInt = this.e;
      if (arrayOfInt != null)
        param1MediaStyle.setShowActionsInCompactView(arrayOfInt); 
      MediaSessionCompat.Token token = this.f;
      if (token != null)
        param1MediaStyle.setMediaSession((MediaSession.Token)token.getToken()); 
      return param1MediaStyle;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 21) {
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)a(new Notification.MediaStyle()));
        return;
      } 
      if (this.g)
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true); 
    }
    
    RemoteViews b() {
      int i;
      RemoteViews remoteViews = applyStandardTemplate(false, a(), true);
      int j = this.a.mActions.size();
      int[] arrayOfInt = this.e;
      if (arrayOfInt == null) {
        i = 0;
      } else {
        i = Math.min(arrayOfInt.length, 3);
      } 
      remoteViews.removeAllViews(R.id.media_actions);
      if (i > 0) {
        int k = 0;
        while (k < i) {
          if (k < j) {
            RemoteViews remoteViews1 = a(this.a.mActions.get(this.e[k]));
            remoteViews.addView(R.id.media_actions, remoteViews1);
            k++;
            continue;
          } 
          throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[] { Integer.valueOf(k), Integer.valueOf(j - 1) }));
        } 
      } 
      if (this.g) {
        remoteViews.setViewVisibility(R.id.end_padder, 8);
        remoteViews.setViewVisibility(R.id.cancel_action, 0);
        remoteViews.setOnClickPendingIntent(R.id.cancel_action, this.h);
        remoteViews.setInt(R.id.cancel_action, "setAlpha", this.a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        return remoteViews;
      } 
      remoteViews.setViewVisibility(R.id.end_padder, 0);
      remoteViews.setViewVisibility(R.id.cancel_action, 8);
      return remoteViews;
    }
    
    RemoteViews c() {
      int i = Math.min(this.a.mActions.size(), 5);
      RemoteViews remoteViews = applyStandardTemplate(false, a(i), false);
      remoteViews.removeAllViews(R.id.media_actions);
      if (i > 0)
        for (int j = 0; j < i; j++) {
          RemoteViews remoteViews1 = a(this.a.mActions.get(j));
          remoteViews.addView(R.id.media_actions, remoteViews1);
        }  
      if (this.g) {
        remoteViews.setViewVisibility(R.id.cancel_action, 0);
        remoteViews.setInt(R.id.cancel_action, "setAlpha", this.a.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        remoteViews.setOnClickPendingIntent(R.id.cancel_action, this.h);
        return remoteViews;
      } 
      remoteViews.setViewVisibility(R.id.cancel_action, 8);
      return remoteViews;
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return (Build.VERSION.SDK_INT >= 21) ? null : c();
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return (Build.VERSION.SDK_INT >= 21) ? null : b();
    }
    
    public MediaStyle setCancelButtonIntent(PendingIntent param1PendingIntent) {
      this.h = param1PendingIntent;
      return this;
    }
    
    public MediaStyle setMediaSession(MediaSessionCompat.Token param1Token) {
      this.f = param1Token;
      return this;
    }
    
    public MediaStyle setShowActionsInCompactView(int... param1VarArgs) {
      this.e = param1VarArgs;
      return this;
    }
    
    public MediaStyle setShowCancelButton(boolean param1Boolean) {
      if (Build.VERSION.SDK_INT < 21)
        this.g = param1Boolean; 
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */