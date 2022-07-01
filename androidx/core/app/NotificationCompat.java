package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
  public static final int BADGE_ICON_LARGE = 2;
  
  public static final int BADGE_ICON_NONE = 0;
  
  public static final int BADGE_ICON_SMALL = 1;
  
  public static final String CATEGORY_ALARM = "alarm";
  
  public static final String CATEGORY_CALL = "call";
  
  public static final String CATEGORY_EMAIL = "email";
  
  public static final String CATEGORY_ERROR = "err";
  
  public static final String CATEGORY_EVENT = "event";
  
  public static final String CATEGORY_MESSAGE = "msg";
  
  public static final String CATEGORY_NAVIGATION = "navigation";
  
  public static final String CATEGORY_PROGRESS = "progress";
  
  public static final String CATEGORY_PROMO = "promo";
  
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  
  public static final String CATEGORY_REMINDER = "reminder";
  
  public static final String CATEGORY_SERVICE = "service";
  
  public static final String CATEGORY_SOCIAL = "social";
  
  public static final String CATEGORY_STATUS = "status";
  
  public static final String CATEGORY_SYSTEM = "sys";
  
  public static final String CATEGORY_TRANSPORT = "transport";
  
  public static final int COLOR_DEFAULT = 0;
  
  public static final int DEFAULT_ALL = -1;
  
  public static final int DEFAULT_LIGHTS = 4;
  
  public static final int DEFAULT_SOUND = 1;
  
  public static final int DEFAULT_VIBRATE = 2;
  
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  
  public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
  
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  
  public static final String EXTRA_MESSAGES = "android.messages";
  
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  
  public static final String EXTRA_PEOPLE = "android.people";
  
  public static final String EXTRA_PICTURE = "android.picture";
  
  public static final String EXTRA_PROGRESS = "android.progress";
  
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  
  public static final String EXTRA_SMALL_ICON = "android.icon";
  
  public static final String EXTRA_SUB_TEXT = "android.subText";
  
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  
  public static final String EXTRA_TEMPLATE = "android.template";
  
  public static final String EXTRA_TEXT = "android.text";
  
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  
  public static final String EXTRA_TITLE = "android.title";
  
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  
  public static final int FLAG_AUTO_CANCEL = 16;
  
  public static final int FLAG_BUBBLE = 4096;
  
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  
  public static final int FLAG_GROUP_SUMMARY = 512;
  
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  
  public static final int FLAG_INSISTENT = 4;
  
  public static final int FLAG_LOCAL_ONLY = 256;
  
  public static final int FLAG_NO_CLEAR = 32;
  
  public static final int FLAG_ONGOING_EVENT = 2;
  
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  
  public static final int FLAG_SHOW_LIGHTS = 1;
  
  public static final int GROUP_ALERT_ALL = 0;
  
  public static final int GROUP_ALERT_CHILDREN = 2;
  
  public static final int GROUP_ALERT_SUMMARY = 1;
  
  public static final int PRIORITY_DEFAULT = 0;
  
  public static final int PRIORITY_HIGH = 1;
  
  public static final int PRIORITY_LOW = -1;
  
  public static final int PRIORITY_MAX = 2;
  
  public static final int PRIORITY_MIN = -2;
  
  public static final int STREAM_DEFAULT = -1;
  
  public static final int VISIBILITY_PRIVATE = 0;
  
  public static final int VISIBILITY_PUBLIC = 1;
  
  public static final int VISIBILITY_SECRET = -1;
  
  static Action a(Notification.Action paramAction) {
    int i;
    boolean bool1;
    boolean bool;
    RemoteInput[] arrayOfRemoteInput;
    RemoteInput[] arrayOfRemoteInput1 = paramAction.getRemoteInputs();
    IconCompat iconCompat = null;
    if (arrayOfRemoteInput1 == null) {
      arrayOfRemoteInput = null;
    } else {
      arrayOfRemoteInput = new RemoteInput[arrayOfRemoteInput1.length];
      for (i = 0; i < arrayOfRemoteInput1.length; i++) {
        boolean bool3;
        RemoteInput remoteInput = arrayOfRemoteInput1[i];
        String str = remoteInput.getResultKey();
        CharSequence charSequence = remoteInput.getLabel();
        CharSequence[] arrayOfCharSequence = remoteInput.getChoices();
        bool1 = remoteInput.getAllowFreeFormInput();
        if (Build.VERSION.SDK_INT >= 29) {
          bool3 = remoteInput.getEditChoicesBeforeSending();
        } else {
          bool3 = false;
        } 
        arrayOfRemoteInput[i] = new RemoteInput(str, charSequence, arrayOfCharSequence, bool1, bool3, remoteInput.getExtras(), null);
      } 
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      if (paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies") || paramAction.getAllowGeneratedReplies()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } else {
      bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
    } 
    boolean bool2 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
    if (Build.VERSION.SDK_INT >= 28) {
      i = paramAction.getSemanticAction();
    } else {
      i = paramAction.getExtras().getInt("android.support.action.semanticAction", 0);
    } 
    if (Build.VERSION.SDK_INT >= 29) {
      bool = paramAction.isContextual();
    } else {
      bool = false;
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramAction.getIcon() == null && paramAction.icon != 0)
        return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool2, bool); 
      if (paramAction.getIcon() != null)
        iconCompat = IconCompat.createFromIconOrNullIfZeroResId(paramAction.getIcon()); 
      return new Action(iconCompat, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool2, bool);
    } 
    return new Action(paramAction.icon, paramAction.title, paramAction.actionIntent, paramAction.getExtras(), arrayOfRemoteInput, null, bool1, i, bool2, bool);
  }
  
  static Notification[] a(Bundle paramBundle, String paramString) {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (arrayOfParcelable instanceof Notification[] || arrayOfParcelable == null)
      return (Notification[])arrayOfParcelable; 
    Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
    for (int i = 0; i < arrayOfParcelable.length; i++)
      arrayOfNotification[i] = (Notification)arrayOfParcelable[i]; 
    paramBundle.putParcelableArray(paramString, (Parcelable[])arrayOfNotification);
    return arrayOfNotification;
  }
  
  public static Action getAction(Notification paramNotification, int paramInt) {
    Bundle bundle;
    if (Build.VERSION.SDK_INT >= 20)
      return a(paramNotification.actions[paramInt]); 
    int i = Build.VERSION.SDK_INT;
    Notification notification = null;
    if (i >= 19) {
      Notification.Action action = paramNotification.actions[paramInt];
      SparseArray sparseArray = paramNotification.extras.getSparseParcelableArray("android.support.actionExtras");
      paramNotification = notification;
      if (sparseArray != null)
        bundle = (Bundle)sparseArray.get(paramInt); 
      return NotificationCompatJellybean.readAction(action.icon, action.title, action.actionIntent, bundle);
    } 
    return (Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getAction((Notification)bundle, paramInt) : null;
  }
  
  public static int getActionCount(Notification paramNotification) {
    int j = Build.VERSION.SDK_INT;
    int i = 0;
    if (j >= 19) {
      if (paramNotification.actions != null)
        i = paramNotification.actions.length; 
      return i;
    } 
    return (Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getActionCount(paramNotification) : 0;
  }
  
  public static boolean getAllowSystemGeneratedContextualActions(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 29) ? paramNotification.getAllowSystemGeneratedContextualActions() : false;
  }
  
  public static int getBadgeIconType(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getBadgeIconType() : 0;
  }
  
  public static BubbleMetadata getBubbleMetadata(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 29) ? BubbleMetadata.fromPlatform(paramNotification.getBubbleMetadata()) : null;
  }
  
  public static String getCategory(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 21) ? paramNotification.category : null;
  }
  
  public static String getChannelId(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getChannelId() : null;
  }
  
  public static CharSequence getContentTitle(Notification paramNotification) {
    return paramNotification.extras.getCharSequence("android.title");
  }
  
  public static Bundle getExtras(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification) : null);
  }
  
  public static String getGroup(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 20) ? paramNotification.getGroup() : ((Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getString("android.support.groupKey") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.groupKey") : null));
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getGroupAlertBehavior() : 0;
  }
  
  public static List<Action> getInvisibleActions(Notification paramNotification) {
    ArrayList<Action> arrayList = new ArrayList();
    Bundle bundle = paramNotification.extras.getBundle("android.car.EXTENSIONS");
    if (bundle == null)
      return arrayList; 
    bundle = bundle.getBundle("invisible_actions");
    if (bundle != null)
      for (int i = 0; i < bundle.size(); i++)
        arrayList.add(NotificationCompatJellybean.a(bundle.getBundle(Integer.toString(i))));  
    return arrayList;
  }
  
  public static boolean getLocalOnly(Notification paramNotification) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20) {
      if ((paramNotification.flags & 0x100) != 0)
        bool = true; 
      return bool;
    } 
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getBoolean("android.support.localOnly") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.localOnly") : false);
  }
  
  public static String getShortcutId(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getShortcutId() : null;
  }
  
  public static String getSortKey(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 20) ? paramNotification.getSortKey() : ((Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getString("android.support.sortKey") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getString("android.support.sortKey") : null));
  }
  
  public static long getTimeoutAfter(Notification paramNotification) {
    return (Build.VERSION.SDK_INT >= 26) ? paramNotification.getTimeoutAfter() : 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 20) {
      if ((paramNotification.flags & 0x200) != 0)
        bool = true; 
      return bool;
    } 
    return (Build.VERSION.SDK_INT >= 19) ? paramNotification.extras.getBoolean("android.support.isGroupSummary") : ((Build.VERSION.SDK_INT >= 16) ? NotificationCompatJellybean.getExtras(paramNotification).getBoolean("android.support.isGroupSummary") : false);
  }
  
  public static class Action {
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    
    public static final int SEMANTIC_ACTION_CALL = 10;
    
    public static final int SEMANTIC_ACTION_DELETE = 4;
    
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    
    public static final int SEMANTIC_ACTION_MUTE = 6;
    
    public static final int SEMANTIC_ACTION_NONE = 0;
    
    public static final int SEMANTIC_ACTION_REPLY = 1;
    
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    
    final Bundle a;
    
    public PendingIntent actionIntent;
    
    boolean b = true;
    
    private IconCompat c;
    
    private final RemoteInput[] d;
    
    private final RemoteInput[] e;
    
    private boolean f;
    
    private final int g;
    
    private final boolean h;
    
    @Deprecated
    public int icon;
    
    public CharSequence title;
    
    public Action(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(iconCompat, param1CharSequence, param1PendingIntent);
    }
    
    Action(int param1Int1, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput1, RemoteInput[] param1ArrayOfRemoteInput2, boolean param1Boolean1, int param1Int2, boolean param1Boolean2, boolean param1Boolean3) {
      this(iconCompat, param1CharSequence, param1PendingIntent, param1Bundle, param1ArrayOfRemoteInput1, param1ArrayOfRemoteInput2, param1Boolean1, param1Int2, param1Boolean2, param1Boolean3);
    }
    
    public Action(IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(param1IconCompat, param1CharSequence, param1PendingIntent, new Bundle(), (RemoteInput[])null, (RemoteInput[])null, true, 0, true, false);
    }
    
    Action(IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput1, RemoteInput[] param1ArrayOfRemoteInput2, boolean param1Boolean1, int param1Int, boolean param1Boolean2, boolean param1Boolean3) {
      this.c = param1IconCompat;
      if (param1IconCompat != null && param1IconCompat.getType() == 2)
        this.icon = param1IconCompat.getResId(); 
      this.title = NotificationCompat.Builder.a(param1CharSequence);
      this.actionIntent = param1PendingIntent;
      if (param1Bundle == null)
        param1Bundle = new Bundle(); 
      this.a = param1Bundle;
      this.d = param1ArrayOfRemoteInput1;
      this.e = param1ArrayOfRemoteInput2;
      this.f = param1Boolean1;
      this.g = param1Int;
      this.b = param1Boolean2;
      this.h = param1Boolean3;
    }
    
    public PendingIntent getActionIntent() {
      return this.actionIntent;
    }
    
    public boolean getAllowGeneratedReplies() {
      return this.f;
    }
    
    public RemoteInput[] getDataOnlyRemoteInputs() {
      return this.e;
    }
    
    public Bundle getExtras() {
      return this.a;
    }
    
    @Deprecated
    public int getIcon() {
      return this.icon;
    }
    
    public IconCompat getIconCompat() {
      if (this.c == null) {
        int i = this.icon;
        if (i != 0)
          this.c = IconCompat.createWithResource(null, "", i); 
      } 
      return this.c;
    }
    
    public RemoteInput[] getRemoteInputs() {
      return this.d;
    }
    
    public int getSemanticAction() {
      return this.g;
    }
    
    public boolean getShowsUserInterface() {
      return this.b;
    }
    
    public CharSequence getTitle() {
      return this.title;
    }
    
    public boolean isContextual() {
      return this.h;
    }
    
    public static final class Builder {
      private final IconCompat a;
      
      private final CharSequence b;
      
      private final PendingIntent c;
      
      private boolean d;
      
      private final Bundle e;
      
      private ArrayList<RemoteInput> f;
      
      private int g;
      
      private boolean h;
      
      private boolean i;
      
      public Builder(int param2Int, CharSequence param2CharSequence, PendingIntent param2PendingIntent) {
        this(iconCompat, param2CharSequence, param2PendingIntent, new Bundle(), null, true, 0, true, false);
      }
      
      public Builder(NotificationCompat.Action param2Action) {
        this(param2Action.getIconCompat(), param2Action.title, param2Action.actionIntent, new Bundle(param2Action.a), param2Action.getRemoteInputs(), param2Action.getAllowGeneratedReplies(), param2Action.getSemanticAction(), param2Action.b, param2Action.isContextual());
      }
      
      public Builder(IconCompat param2IconCompat, CharSequence param2CharSequence, PendingIntent param2PendingIntent) {
        this(param2IconCompat, param2CharSequence, param2PendingIntent, new Bundle(), null, true, 0, true, false);
      }
      
      private Builder(IconCompat param2IconCompat, CharSequence param2CharSequence, PendingIntent param2PendingIntent, Bundle param2Bundle, RemoteInput[] param2ArrayOfRemoteInput, boolean param2Boolean1, int param2Int, boolean param2Boolean2, boolean param2Boolean3) {
        ArrayList<RemoteInput> arrayList;
        this.d = true;
        this.h = true;
        this.a = param2IconCompat;
        this.b = NotificationCompat.Builder.a(param2CharSequence);
        this.c = param2PendingIntent;
        this.e = param2Bundle;
        if (param2ArrayOfRemoteInput == null) {
          param2IconCompat = null;
        } else {
          arrayList = new ArrayList(Arrays.asList((Object[])param2ArrayOfRemoteInput));
        } 
        this.f = arrayList;
        this.d = param2Boolean1;
        this.g = param2Int;
        this.h = param2Boolean2;
        this.i = param2Boolean3;
      }
      
      private void a() {
        if (!this.i)
          return; 
        if (this.c != null)
          return; 
        throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
      }
      
      public Builder addExtras(Bundle param2Bundle) {
        if (param2Bundle != null)
          this.e.putAll(param2Bundle); 
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput param2RemoteInput) {
        if (this.f == null)
          this.f = new ArrayList<RemoteInput>(); 
        this.f.add(param2RemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build() {
        RemoteInput[] arrayOfRemoteInput1;
        RemoteInput[] arrayOfRemoteInput2;
        a();
        ArrayList<RemoteInput> arrayList1 = new ArrayList();
        ArrayList<RemoteInput> arrayList3 = new ArrayList();
        ArrayList<RemoteInput> arrayList2 = this.f;
        if (arrayList2 != null)
          for (RemoteInput remoteInput : arrayList2) {
            if (remoteInput.isDataOnly()) {
              arrayList1.add(remoteInput);
              continue;
            } 
            arrayList3.add(remoteInput);
          }  
        boolean bool = arrayList1.isEmpty();
        arrayList2 = null;
        if (bool) {
          arrayList1 = null;
        } else {
          arrayOfRemoteInput1 = arrayList1.<RemoteInput>toArray(new RemoteInput[arrayList1.size()]);
        } 
        if (!arrayList3.isEmpty())
          arrayOfRemoteInput2 = arrayList3.<RemoteInput>toArray(new RemoteInput[arrayList3.size()]); 
        return new NotificationCompat.Action(this.a, this.b, this.c, this.e, arrayOfRemoteInput2, arrayOfRemoteInput1, this.d, this.g, this.h, this.i);
      }
      
      public Builder extend(NotificationCompat.Action.Extender param2Extender) {
        param2Extender.extend(this);
        return this;
      }
      
      public Bundle getExtras() {
        return this.e;
      }
      
      public Builder setAllowGeneratedReplies(boolean param2Boolean) {
        this.d = param2Boolean;
        return this;
      }
      
      public Builder setContextual(boolean param2Boolean) {
        this.i = param2Boolean;
        return this;
      }
      
      public Builder setSemanticAction(int param2Int) {
        this.g = param2Int;
        return this;
      }
      
      public Builder setShowsUserInterface(boolean param2Boolean) {
        this.h = param2Boolean;
        return this;
      }
    }
    
    public static interface Extender {
      NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface SemanticAction {}
    
    public static final class WearableExtender implements Extender {
      private int a = 1;
      
      private CharSequence b;
      
      private CharSequence c;
      
      private CharSequence d;
      
      public WearableExtender() {}
      
      public WearableExtender(NotificationCompat.Action param2Action) {
        Bundle bundle = param2Action.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (bundle != null) {
          this.a = bundle.getInt("flags", 1);
          this.b = bundle.getCharSequence("inProgressLabel");
          this.c = bundle.getCharSequence("confirmLabel");
          this.d = bundle.getCharSequence("cancelLabel");
        } 
      }
      
      private void a(int param2Int, boolean param2Boolean) {
        if (param2Boolean) {
          this.a = param2Int | this.a;
          return;
        } 
        this.a = param2Int & this.a;
      }
      
      public WearableExtender clone() {
        WearableExtender wearableExtender = new WearableExtender();
        wearableExtender.a = this.a;
        wearableExtender.b = this.b;
        wearableExtender.c = this.c;
        wearableExtender.d = this.d;
        return wearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param2Builder) {
        Bundle bundle = new Bundle();
        int i = this.a;
        if (i != 1)
          bundle.putInt("flags", i); 
        CharSequence charSequence = this.b;
        if (charSequence != null)
          bundle.putCharSequence("inProgressLabel", charSequence); 
        charSequence = this.c;
        if (charSequence != null)
          bundle.putCharSequence("confirmLabel", charSequence); 
        charSequence = this.d;
        if (charSequence != null)
          bundle.putCharSequence("cancelLabel", charSequence); 
        param2Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
        return param2Builder;
      }
      
      @Deprecated
      public CharSequence getCancelLabel() {
        return this.d;
      }
      
      @Deprecated
      public CharSequence getConfirmLabel() {
        return this.c;
      }
      
      public boolean getHintDisplayActionInline() {
        return ((this.a & 0x4) != 0);
      }
      
      public boolean getHintLaunchesActivity() {
        return ((this.a & 0x2) != 0);
      }
      
      @Deprecated
      public CharSequence getInProgressLabel() {
        return this.b;
      }
      
      public boolean isAvailableOffline() {
        return ((this.a & 0x1) != 0);
      }
      
      public WearableExtender setAvailableOffline(boolean param2Boolean) {
        a(1, param2Boolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setCancelLabel(CharSequence param2CharSequence) {
        this.d = param2CharSequence;
        return this;
      }
      
      @Deprecated
      public WearableExtender setConfirmLabel(CharSequence param2CharSequence) {
        this.c = param2CharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean param2Boolean) {
        a(4, param2Boolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean param2Boolean) {
        a(2, param2Boolean);
        return this;
      }
      
      @Deprecated
      public WearableExtender setInProgressLabel(CharSequence param2CharSequence) {
        this.b = param2CharSequence;
        return this;
      }
    }
  }
  
  public static final class Builder {
    private final IconCompat a;
    
    private final CharSequence b;
    
    private final PendingIntent c;
    
    private boolean d;
    
    private final Bundle e;
    
    private ArrayList<RemoteInput> f;
    
    private int g;
    
    private boolean h;
    
    private boolean i;
    
    public Builder(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(iconCompat, param1CharSequence, param1PendingIntent, new Bundle(), null, true, 0, true, false);
    }
    
    public Builder(NotificationCompat.Action param1Action) {
      this(param1Action.getIconCompat(), param1Action.title, param1Action.actionIntent, new Bundle(param1Action.a), param1Action.getRemoteInputs(), param1Action.getAllowGeneratedReplies(), param1Action.getSemanticAction(), param1Action.b, param1Action.isContextual());
    }
    
    public Builder(IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this(param1IconCompat, param1CharSequence, param1PendingIntent, new Bundle(), null, true, 0, true, false);
    }
    
    private Builder(IconCompat param1IconCompat, CharSequence param1CharSequence, PendingIntent param1PendingIntent, Bundle param1Bundle, RemoteInput[] param1ArrayOfRemoteInput, boolean param1Boolean1, int param1Int, boolean param1Boolean2, boolean param1Boolean3) {
      ArrayList<RemoteInput> arrayList;
      this.d = true;
      this.h = true;
      this.a = param1IconCompat;
      this.b = NotificationCompat.Builder.a(param1CharSequence);
      this.c = param1PendingIntent;
      this.e = param1Bundle;
      if (param1ArrayOfRemoteInput == null) {
        param1IconCompat = null;
      } else {
        arrayList = new ArrayList(Arrays.asList((Object[])param1ArrayOfRemoteInput));
      } 
      this.f = arrayList;
      this.d = param1Boolean1;
      this.g = param1Int;
      this.h = param1Boolean2;
      this.i = param1Boolean3;
    }
    
    private void a() {
      if (!this.i)
        return; 
      if (this.c != null)
        return; 
      throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null)
        this.e.putAll(param1Bundle); 
      return this;
    }
    
    public Builder addRemoteInput(RemoteInput param1RemoteInput) {
      if (this.f == null)
        this.f = new ArrayList<RemoteInput>(); 
      this.f.add(param1RemoteInput);
      return this;
    }
    
    public NotificationCompat.Action build() {
      RemoteInput[] arrayOfRemoteInput1;
      RemoteInput[] arrayOfRemoteInput2;
      a();
      ArrayList<RemoteInput> arrayList1 = new ArrayList();
      ArrayList<RemoteInput> arrayList3 = new ArrayList();
      ArrayList<RemoteInput> arrayList2 = this.f;
      if (arrayList2 != null)
        for (RemoteInput remoteInput : arrayList2) {
          if (remoteInput.isDataOnly()) {
            arrayList1.add(remoteInput);
            continue;
          } 
          arrayList3.add(remoteInput);
        }  
      boolean bool = arrayList1.isEmpty();
      arrayList2 = null;
      if (bool) {
        arrayList1 = null;
      } else {
        arrayOfRemoteInput1 = arrayList1.<RemoteInput>toArray(new RemoteInput[arrayList1.size()]);
      } 
      if (!arrayList3.isEmpty())
        arrayOfRemoteInput2 = arrayList3.<RemoteInput>toArray(new RemoteInput[arrayList3.size()]); 
      return new NotificationCompat.Action(this.a, this.b, this.c, this.e, arrayOfRemoteInput2, arrayOfRemoteInput1, this.d, this.g, this.h, this.i);
    }
    
    public Builder extend(NotificationCompat.Action.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    public Bundle getExtras() {
      return this.e;
    }
    
    public Builder setAllowGeneratedReplies(boolean param1Boolean) {
      this.d = param1Boolean;
      return this;
    }
    
    public Builder setContextual(boolean param1Boolean) {
      this.i = param1Boolean;
      return this;
    }
    
    public Builder setSemanticAction(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public Builder setShowsUserInterface(boolean param1Boolean) {
      this.h = param1Boolean;
      return this;
    }
  }
  
  public static interface Extender {
    NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SemanticAction {}
  
  public static final class WearableExtender implements Action.Extender {
    private int a = 1;
    
    private CharSequence b;
    
    private CharSequence c;
    
    private CharSequence d;
    
    public WearableExtender() {}
    
    public WearableExtender(NotificationCompat.Action param1Action) {
      Bundle bundle = param1Action.getExtras().getBundle("android.wearable.EXTENSIONS");
      if (bundle != null) {
        this.a = bundle.getInt("flags", 1);
        this.b = bundle.getCharSequence("inProgressLabel");
        this.c = bundle.getCharSequence("confirmLabel");
        this.d = bundle.getCharSequence("cancelLabel");
      } 
    }
    
    private void a(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.a = param1Int | this.a;
        return;
      } 
      this.a = param1Int & this.a;
    }
    
    public WearableExtender clone() {
      WearableExtender wearableExtender = new WearableExtender();
      wearableExtender.a = this.a;
      wearableExtender.b = this.b;
      wearableExtender.c = this.c;
      wearableExtender.d = this.d;
      return wearableExtender;
    }
    
    public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder param1Builder) {
      Bundle bundle = new Bundle();
      int i = this.a;
      if (i != 1)
        bundle.putInt("flags", i); 
      CharSequence charSequence = this.b;
      if (charSequence != null)
        bundle.putCharSequence("inProgressLabel", charSequence); 
      charSequence = this.c;
      if (charSequence != null)
        bundle.putCharSequence("confirmLabel", charSequence); 
      charSequence = this.d;
      if (charSequence != null)
        bundle.putCharSequence("cancelLabel", charSequence); 
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    @Deprecated
    public CharSequence getCancelLabel() {
      return this.d;
    }
    
    @Deprecated
    public CharSequence getConfirmLabel() {
      return this.c;
    }
    
    public boolean getHintDisplayActionInline() {
      return ((this.a & 0x4) != 0);
    }
    
    public boolean getHintLaunchesActivity() {
      return ((this.a & 0x2) != 0);
    }
    
    @Deprecated
    public CharSequence getInProgressLabel() {
      return this.b;
    }
    
    public boolean isAvailableOffline() {
      return ((this.a & 0x1) != 0);
    }
    
    public WearableExtender setAvailableOffline(boolean param1Boolean) {
      a(1, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setCancelLabel(CharSequence param1CharSequence) {
      this.d = param1CharSequence;
      return this;
    }
    
    @Deprecated
    public WearableExtender setConfirmLabel(CharSequence param1CharSequence) {
      this.c = param1CharSequence;
      return this;
    }
    
    public WearableExtender setHintDisplayActionInline(boolean param1Boolean) {
      a(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintLaunchesActivity(boolean param1Boolean) {
      a(2, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setInProgressLabel(CharSequence param1CharSequence) {
      this.b = param1CharSequence;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface BadgeIconType {}
  
  public static class BigPictureStyle extends Style {
    private Bitmap e;
    
    private Bitmap f;
    
    private boolean g;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.BigPictureStyle bigPictureStyle = (new Notification.BigPictureStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.b).bigPicture(this.e);
        if (this.g)
          bigPictureStyle.bigLargeIcon(this.f); 
        if (this.d)
          bigPictureStyle.setSummaryText(this.c); 
      } 
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap param1Bitmap) {
      this.f = param1Bitmap;
      this.g = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap param1Bitmap) {
      this.e = param1Bitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.b = NotificationCompat.Builder.a(param1CharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence param1CharSequence) {
      this.c = NotificationCompat.Builder.a(param1CharSequence);
      this.d = true;
      return this;
    }
  }
  
  public static class BigTextStyle extends Style {
    private CharSequence e;
    
    public BigTextStyle() {}
    
    public BigTextStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.BigTextStyle bigTextStyle = (new Notification.BigTextStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.b).bigText(this.e);
        if (this.d)
          bigTextStyle.setSummaryText(this.c); 
      } 
    }
    
    public BigTextStyle bigText(CharSequence param1CharSequence) {
      this.e = NotificationCompat.Builder.a(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.b = NotificationCompat.Builder.a(param1CharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence param1CharSequence) {
      this.c = NotificationCompat.Builder.a(param1CharSequence);
      this.d = true;
      return this;
    }
  }
  
  public static final class BubbleMetadata {
    private PendingIntent a;
    
    private PendingIntent b;
    
    private IconCompat c;
    
    private int d;
    
    private int e;
    
    private int f;
    
    private BubbleMetadata(PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, IconCompat param1IconCompat, int param1Int1, int param1Int2, int param1Int3) {
      this.a = param1PendingIntent1;
      this.c = param1IconCompat;
      this.d = param1Int1;
      this.e = param1Int2;
      this.b = param1PendingIntent2;
      this.f = param1Int3;
    }
    
    public static BubbleMetadata fromPlatform(Notification.BubbleMetadata param1BubbleMetadata) {
      if (param1BubbleMetadata == null)
        return null; 
      Builder builder = (new Builder()).setAutoExpandBubble(param1BubbleMetadata.getAutoExpandBubble()).setDeleteIntent(param1BubbleMetadata.getDeleteIntent()).setIcon(IconCompat.createFromIcon(param1BubbleMetadata.getIcon())).setIntent(param1BubbleMetadata.getIntent()).setSuppressNotification(param1BubbleMetadata.isNotificationSuppressed());
      if (param1BubbleMetadata.getDesiredHeight() != 0)
        builder.setDesiredHeight(param1BubbleMetadata.getDesiredHeight()); 
      if (param1BubbleMetadata.getDesiredHeightResId() != 0)
        builder.setDesiredHeightResId(param1BubbleMetadata.getDesiredHeightResId()); 
      return builder.build();
    }
    
    public static Notification.BubbleMetadata toPlatform(BubbleMetadata param1BubbleMetadata) {
      if (param1BubbleMetadata == null)
        return null; 
      Notification.BubbleMetadata.Builder builder = (new Notification.BubbleMetadata.Builder()).setAutoExpandBubble(param1BubbleMetadata.getAutoExpandBubble()).setDeleteIntent(param1BubbleMetadata.getDeleteIntent()).setIcon(param1BubbleMetadata.getIcon().toIcon()).setIntent(param1BubbleMetadata.getIntent()).setSuppressNotification(param1BubbleMetadata.isNotificationSuppressed());
      if (param1BubbleMetadata.getDesiredHeight() != 0)
        builder.setDesiredHeight(param1BubbleMetadata.getDesiredHeight()); 
      if (param1BubbleMetadata.getDesiredHeightResId() != 0)
        builder.setDesiredHeightResId(param1BubbleMetadata.getDesiredHeightResId()); 
      return builder.build();
    }
    
    public boolean getAutoExpandBubble() {
      return ((this.f & 0x1) != 0);
    }
    
    public PendingIntent getDeleteIntent() {
      return this.b;
    }
    
    public int getDesiredHeight() {
      return this.d;
    }
    
    public int getDesiredHeightResId() {
      return this.e;
    }
    
    public IconCompat getIcon() {
      return this.c;
    }
    
    public PendingIntent getIntent() {
      return this.a;
    }
    
    public boolean isNotificationSuppressed() {
      return ((this.f & 0x2) != 0);
    }
    
    public static final class Builder {
      private PendingIntent a;
      
      private IconCompat b;
      
      private int c;
      
      private int d;
      
      private int e;
      
      private PendingIntent f;
      
      private Builder a(int param2Int, boolean param2Boolean) {
        if (param2Boolean) {
          this.e = param2Int | this.e;
          return this;
        } 
        this.e = param2Int & this.e;
        return this;
      }
      
      public NotificationCompat.BubbleMetadata build() {
        PendingIntent pendingIntent = this.a;
        if (pendingIntent != null) {
          IconCompat iconCompat = this.b;
          if (iconCompat != null)
            return new NotificationCompat.BubbleMetadata(pendingIntent, this.f, iconCompat, this.c, this.d, this.e); 
          throw new IllegalStateException("Must supply an icon for the bubble");
        } 
        throw new IllegalStateException("Must supply pending intent to bubble");
      }
      
      public Builder setAutoExpandBubble(boolean param2Boolean) {
        a(1, param2Boolean);
        return this;
      }
      
      public Builder setDeleteIntent(PendingIntent param2PendingIntent) {
        this.f = param2PendingIntent;
        return this;
      }
      
      public Builder setDesiredHeight(int param2Int) {
        this.c = Math.max(param2Int, 0);
        this.d = 0;
        return this;
      }
      
      public Builder setDesiredHeightResId(int param2Int) {
        this.d = param2Int;
        this.c = 0;
        return this;
      }
      
      public Builder setIcon(IconCompat param2IconCompat) {
        if (param2IconCompat != null) {
          if (param2IconCompat.getType() != 1) {
            this.b = param2IconCompat;
            return this;
          } 
          throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
        } 
        throw new IllegalArgumentException("Bubbles require non-null icon");
      }
      
      public Builder setIntent(PendingIntent param2PendingIntent) {
        if (param2PendingIntent != null) {
          this.a = param2PendingIntent;
          return this;
        } 
        throw new IllegalArgumentException("Bubble requires non-null pending intent");
      }
      
      public Builder setSuppressNotification(boolean param2Boolean) {
        a(2, param2Boolean);
        return this;
      }
    }
  }
  
  public static final class Builder {
    private PendingIntent a;
    
    private IconCompat b;
    
    private int c;
    
    private int d;
    
    private int e;
    
    private PendingIntent f;
    
    private Builder a(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.e = param1Int | this.e;
        return this;
      } 
      this.e = param1Int & this.e;
      return this;
    }
    
    public NotificationCompat.BubbleMetadata build() {
      PendingIntent pendingIntent = this.a;
      if (pendingIntent != null) {
        IconCompat iconCompat = this.b;
        if (iconCompat != null)
          return new NotificationCompat.BubbleMetadata(pendingIntent, this.f, iconCompat, this.c, this.d, this.e); 
        throw new IllegalStateException("Must supply an icon for the bubble");
      } 
      throw new IllegalStateException("Must supply pending intent to bubble");
    }
    
    public Builder setAutoExpandBubble(boolean param1Boolean) {
      a(1, param1Boolean);
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent param1PendingIntent) {
      this.f = param1PendingIntent;
      return this;
    }
    
    public Builder setDesiredHeight(int param1Int) {
      this.c = Math.max(param1Int, 0);
      this.d = 0;
      return this;
    }
    
    public Builder setDesiredHeightResId(int param1Int) {
      this.d = param1Int;
      this.c = 0;
      return this;
    }
    
    public Builder setIcon(IconCompat param1IconCompat) {
      if (param1IconCompat != null) {
        if (param1IconCompat.getType() != 1) {
          this.b = param1IconCompat;
          return this;
        } 
        throw new IllegalArgumentException("When using bitmap based icons, Bubbles require TYPE_ADAPTIVE_BITMAP, please use IconCompat#createWithAdaptiveBitmap instead");
      } 
      throw new IllegalArgumentException("Bubbles require non-null icon");
    }
    
    public Builder setIntent(PendingIntent param1PendingIntent) {
      if (param1PendingIntent != null) {
        this.a = param1PendingIntent;
        return this;
      } 
      throw new IllegalArgumentException("Bubble requires non-null pending intent");
    }
    
    public Builder setSuppressNotification(boolean param1Boolean) {
      a(2, param1Boolean);
      return this;
    }
  }
  
  public static class Builder {
    Bundle A;
    
    int B = 0;
    
    int C = 0;
    
    Notification D;
    
    RemoteViews E;
    
    RemoteViews F;
    
    RemoteViews G;
    
    String H;
    
    int I = 0;
    
    String J;
    
    long K;
    
    int L = 0;
    
    boolean M;
    
    NotificationCompat.BubbleMetadata N;
    
    Notification O = new Notification();
    
    ArrayList<NotificationCompat.Action> a = new ArrayList<NotificationCompat.Action>();
    
    CharSequence b;
    
    CharSequence c;
    
    PendingIntent d;
    
    PendingIntent e;
    
    RemoteViews f;
    
    Bitmap g;
    
    CharSequence h;
    
    int i;
    
    int j;
    
    boolean k = true;
    
    boolean l;
    
    boolean m;
    
    public ArrayList<NotificationCompat.Action> mActions = new ArrayList<NotificationCompat.Action>();
    
    public Context mContext;
    
    @Deprecated
    public ArrayList<String> mPeople;
    
    NotificationCompat.Style n;
    
    CharSequence o;
    
    CharSequence[] p;
    
    int q;
    
    int r;
    
    boolean s;
    
    String t;
    
    boolean u;
    
    String v;
    
    boolean w = false;
    
    boolean x;
    
    boolean y;
    
    String z;
    
    @Deprecated
    public Builder(Context param1Context) {
      this(param1Context, null);
    }
    
    public Builder(Context param1Context, String param1String) {
      this.mContext = param1Context;
      this.H = param1String;
      this.O.when = System.currentTimeMillis();
      this.O.audioStreamType = -1;
      this.j = 0;
      this.mPeople = new ArrayList<String>();
      this.M = true;
    }
    
    private Bitmap a(Bitmap param1Bitmap) {
      Bitmap bitmap = param1Bitmap;
      if (param1Bitmap != null) {
        if (Build.VERSION.SDK_INT >= 27)
          return param1Bitmap; 
        Resources resources = this.mContext.getResources();
        int i = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
        int j = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
        if (param1Bitmap.getWidth() <= i && param1Bitmap.getHeight() <= j)
          return param1Bitmap; 
        double d = Math.min(i / Math.max(1, param1Bitmap.getWidth()), j / Math.max(1, param1Bitmap.getHeight()));
        bitmap = Bitmap.createScaledBitmap(param1Bitmap, (int)Math.ceil(param1Bitmap.getWidth() * d), (int)Math.ceil(param1Bitmap.getHeight() * d), true);
      } 
      return bitmap;
    }
    
    protected static CharSequence a(CharSequence param1CharSequence) {
      if (param1CharSequence == null)
        return param1CharSequence; 
      CharSequence charSequence = param1CharSequence;
      if (param1CharSequence.length() > 5120)
        charSequence = param1CharSequence.subSequence(0, 5120); 
      return charSequence;
    }
    
    private void a(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        Notification notification1 = this.O;
        notification1.flags = param1Int | notification1.flags;
        return;
      } 
      Notification notification = this.O;
      notification.flags = param1Int & notification.flags;
    }
    
    public Builder addAction(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      this.mActions.add(new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action param1Action) {
      this.mActions.add(param1Action);
      return this;
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null) {
        Bundle bundle = this.A;
        if (bundle == null) {
          this.A = new Bundle(param1Bundle);
          return this;
        } 
        bundle.putAll(param1Bundle);
      } 
      return this;
    }
    
    public Builder addInvisibleAction(int param1Int, CharSequence param1CharSequence, PendingIntent param1PendingIntent) {
      return addInvisibleAction(new NotificationCompat.Action(param1Int, param1CharSequence, param1PendingIntent));
    }
    
    public Builder addInvisibleAction(NotificationCompat.Action param1Action) {
      this.a.add(param1Action);
      return this;
    }
    
    public Builder addPerson(String param1String) {
      this.mPeople.add(param1String);
      return this;
    }
    
    public Notification build() {
      return (new NotificationCompatBuilder(this)).build();
    }
    
    public Builder extend(NotificationCompat.Extender param1Extender) {
      param1Extender.extend(this);
      return this;
    }
    
    public RemoteViews getBigContentView() {
      return this.F;
    }
    
    public NotificationCompat.BubbleMetadata getBubbleMetadata() {
      return this.N;
    }
    
    public int getColor() {
      return this.B;
    }
    
    public RemoteViews getContentView() {
      return this.E;
    }
    
    public Bundle getExtras() {
      if (this.A == null)
        this.A = new Bundle(); 
      return this.A;
    }
    
    public RemoteViews getHeadsUpContentView() {
      return this.G;
    }
    
    @Deprecated
    public Notification getNotification() {
      return build();
    }
    
    public int getPriority() {
      return this.j;
    }
    
    public long getWhenIfShowing() {
      return this.k ? this.O.when : 0L;
    }
    
    public Builder setAllowSystemGeneratedContextualActions(boolean param1Boolean) {
      this.M = param1Boolean;
      return this;
    }
    
    public Builder setAutoCancel(boolean param1Boolean) {
      a(16, param1Boolean);
      return this;
    }
    
    public Builder setBadgeIconType(int param1Int) {
      this.I = param1Int;
      return this;
    }
    
    public Builder setBubbleMetadata(NotificationCompat.BubbleMetadata param1BubbleMetadata) {
      this.N = param1BubbleMetadata;
      return this;
    }
    
    public Builder setCategory(String param1String) {
      this.z = param1String;
      return this;
    }
    
    public Builder setChannelId(String param1String) {
      this.H = param1String;
      return this;
    }
    
    public Builder setChronometerCountDown(boolean param1Boolean) {
      this.m = param1Boolean;
      this.A.putBoolean("android.chronometerCountDown", param1Boolean);
      return this;
    }
    
    public Builder setColor(int param1Int) {
      this.B = param1Int;
      return this;
    }
    
    public Builder setColorized(boolean param1Boolean) {
      this.x = param1Boolean;
      this.y = true;
      return this;
    }
    
    public Builder setContent(RemoteViews param1RemoteViews) {
      this.O.contentView = param1RemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence param1CharSequence) {
      this.h = a(param1CharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent param1PendingIntent) {
      this.d = param1PendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence param1CharSequence) {
      this.c = a(param1CharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence param1CharSequence) {
      this.b = a(param1CharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews param1RemoteViews) {
      this.F = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews param1RemoteViews) {
      this.E = param1RemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews param1RemoteViews) {
      this.G = param1RemoteViews;
      return this;
    }
    
    public Builder setDefaults(int param1Int) {
      Notification notification = this.O;
      notification.defaults = param1Int;
      if ((param1Int & 0x4) != 0)
        notification.flags |= 0x1; 
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent param1PendingIntent) {
      this.O.deleteIntent = param1PendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle param1Bundle) {
      this.A = param1Bundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent param1PendingIntent, boolean param1Boolean) {
      this.e = param1PendingIntent;
      a(128, param1Boolean);
      return this;
    }
    
    public Builder setGroup(String param1String) {
      this.t = param1String;
      return this;
    }
    
    public Builder setGroupAlertBehavior(int param1Int) {
      this.L = param1Int;
      return this;
    }
    
    public Builder setGroupSummary(boolean param1Boolean) {
      this.u = param1Boolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap param1Bitmap) {
      this.g = a(param1Bitmap);
      return this;
    }
    
    public Builder setLights(int param1Int1, int param1Int2, int param1Int3) {
      Notification notification = this.O;
      notification.ledARGB = param1Int1;
      notification.ledOnMS = param1Int2;
      notification.ledOffMS = param1Int3;
      if (notification.ledOnMS != 0 && this.O.ledOffMS != 0) {
        param1Int1 = 1;
      } else {
        param1Int1 = 0;
      } 
      notification = this.O;
      notification.flags = param1Int1 | notification.flags & 0xFFFFFFFE;
      return this;
    }
    
    public Builder setLocalOnly(boolean param1Boolean) {
      this.w = param1Boolean;
      return this;
    }
    
    public Builder setNumber(int param1Int) {
      this.i = param1Int;
      return this;
    }
    
    public Builder setOngoing(boolean param1Boolean) {
      a(2, param1Boolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean param1Boolean) {
      a(8, param1Boolean);
      return this;
    }
    
    public Builder setPriority(int param1Int) {
      this.j = param1Int;
      return this;
    }
    
    public Builder setProgress(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.q = param1Int1;
      this.r = param1Int2;
      this.s = param1Boolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification param1Notification) {
      this.D = param1Notification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] param1ArrayOfCharSequence) {
      this.p = param1ArrayOfCharSequence;
      return this;
    }
    
    public Builder setShortcutId(String param1String) {
      this.J = param1String;
      return this;
    }
    
    public Builder setShowWhen(boolean param1Boolean) {
      this.k = param1Boolean;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int) {
      this.O.icon = param1Int;
      return this;
    }
    
    public Builder setSmallIcon(int param1Int1, int param1Int2) {
      Notification notification = this.O;
      notification.icon = param1Int1;
      notification.iconLevel = param1Int2;
      return this;
    }
    
    public Builder setSortKey(String param1String) {
      this.v = param1String;
      return this;
    }
    
    public Builder setSound(Uri param1Uri) {
      Notification notification = this.O;
      notification.sound = param1Uri;
      notification.audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21)
        this.O.audioAttributes = (new AudioAttributes.Builder()).setContentType(4).setUsage(5).build(); 
      return this;
    }
    
    public Builder setSound(Uri param1Uri, int param1Int) {
      Notification notification = this.O;
      notification.sound = param1Uri;
      notification.audioStreamType = param1Int;
      if (Build.VERSION.SDK_INT >= 21)
        this.O.audioAttributes = (new AudioAttributes.Builder()).setContentType(4).setLegacyStreamType(param1Int).build(); 
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style param1Style) {
      if (this.n != param1Style) {
        this.n = param1Style;
        param1Style = this.n;
        if (param1Style != null)
          param1Style.setBuilder(this); 
      } 
      return this;
    }
    
    public Builder setSubText(CharSequence param1CharSequence) {
      this.o = a(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence) {
      this.O.tickerText = a(param1CharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence param1CharSequence, RemoteViews param1RemoteViews) {
      this.O.tickerText = a(param1CharSequence);
      this.f = param1RemoteViews;
      return this;
    }
    
    public Builder setTimeoutAfter(long param1Long) {
      this.K = param1Long;
      return this;
    }
    
    public Builder setUsesChronometer(boolean param1Boolean) {
      this.l = param1Boolean;
      return this;
    }
    
    public Builder setVibrate(long[] param1ArrayOflong) {
      this.O.vibrate = param1ArrayOflong;
      return this;
    }
    
    public Builder setVisibility(int param1Int) {
      this.C = param1Int;
      return this;
    }
    
    public Builder setWhen(long param1Long) {
      this.O.when = param1Long;
      return this;
    }
  }
  
  public static final class CarExtender implements Extender {
    private Bitmap a;
    
    private UnreadConversation b;
    
    private int c;
    
    public CarExtender() {
      this.c = 0;
    }
    
    public CarExtender(Notification param1Notification) {
      Bundle bundle;
      this.c = 0;
      if (Build.VERSION.SDK_INT < 21)
        return; 
      if (NotificationCompat.getExtras(param1Notification) == null) {
        param1Notification = null;
      } else {
        bundle = NotificationCompat.getExtras(param1Notification).getBundle("android.car.EXTENSIONS");
      } 
      if (bundle != null) {
        this.a = (Bitmap)bundle.getParcelable("large_icon");
        this.c = bundle.getInt("app_color", 0);
        this.b = a(bundle.getBundle("car_conversation"));
      } 
    }
    
    private static Bundle a(UnreadConversation param1UnreadConversation) {
      Bundle bundle = new Bundle();
      String[] arrayOfString = param1UnreadConversation.getParticipants();
      int i = 0;
      if (arrayOfString != null && (param1UnreadConversation.getParticipants()).length > 1) {
        String str = param1UnreadConversation.getParticipants()[0];
      } else {
        arrayOfString = null;
      } 
      Parcelable[] arrayOfParcelable = new Parcelable[(param1UnreadConversation.getMessages()).length];
      while (i < arrayOfParcelable.length) {
        Bundle bundle1 = new Bundle();
        bundle1.putString("text", param1UnreadConversation.getMessages()[i]);
        bundle1.putString("author", (String)arrayOfString);
        arrayOfParcelable[i] = (Parcelable)bundle1;
        i++;
      } 
      bundle.putParcelableArray("messages", arrayOfParcelable);
      RemoteInput remoteInput = param1UnreadConversation.getRemoteInput();
      if (remoteInput != null)
        bundle.putParcelable("remote_input", (Parcelable)(new RemoteInput.Builder(remoteInput.getResultKey())).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build()); 
      bundle.putParcelable("on_reply", (Parcelable)param1UnreadConversation.getReplyPendingIntent());
      bundle.putParcelable("on_read", (Parcelable)param1UnreadConversation.getReadPendingIntent());
      bundle.putStringArray("participants", param1UnreadConversation.getParticipants());
      bundle.putLong("timestamp", param1UnreadConversation.getLatestTimestamp());
      return bundle;
    }
    
    private static UnreadConversation a(Bundle param1Bundle) {
      String[] arrayOfString1;
      UnreadConversation unreadConversation;
      String str1 = null;
      String str2 = null;
      if (param1Bundle == null)
        return null; 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("messages");
      if (arrayOfParcelable != null) {
        arrayOfString1 = new String[arrayOfParcelable.length];
        int i = 0;
        while (true) {
          if (i < arrayOfString1.length) {
            if (arrayOfParcelable[i] instanceof Bundle) {
              arrayOfString1[i] = ((Bundle)arrayOfParcelable[i]).getString("text");
              if (arrayOfString1[i] != null) {
                i++;
                continue;
              } 
            } 
            i = 0;
            break;
          } 
          i = 1;
          break;
        } 
        if (i == 0)
          return null; 
      } else {
        arrayOfString1 = null;
      } 
      PendingIntent pendingIntent1 = (PendingIntent)param1Bundle.getParcelable("on_read");
      PendingIntent pendingIntent2 = (PendingIntent)param1Bundle.getParcelable("on_reply");
      RemoteInput remoteInput = (RemoteInput)param1Bundle.getParcelable("remote_input");
      String[] arrayOfString2 = param1Bundle.getStringArray("participants");
      if (arrayOfString2 != null) {
        RemoteInput remoteInput1;
        if (arrayOfString2.length != 1)
          return null; 
        str1 = str2;
        if (remoteInput != null) {
          boolean bool;
          str1 = remoteInput.getResultKey();
          CharSequence charSequence = remoteInput.getLabel();
          CharSequence[] arrayOfCharSequence = remoteInput.getChoices();
          boolean bool1 = remoteInput.getAllowFreeFormInput();
          if (Build.VERSION.SDK_INT >= 29) {
            bool = remoteInput.getEditChoicesBeforeSending();
          } else {
            bool = false;
          } 
          remoteInput1 = new RemoteInput(str1, charSequence, arrayOfCharSequence, bool1, bool, remoteInput.getExtras(), null);
        } 
        unreadConversation = new UnreadConversation(arrayOfString1, remoteInput1, pendingIntent2, pendingIntent1, arrayOfString2, param1Bundle.getLong("timestamp"));
      } 
      return unreadConversation;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
      if (Build.VERSION.SDK_INT < 21)
        return param1Builder; 
      Bundle bundle = new Bundle();
      Bitmap bitmap = this.a;
      if (bitmap != null)
        bundle.putParcelable("large_icon", (Parcelable)bitmap); 
      int i = this.c;
      if (i != 0)
        bundle.putInt("app_color", i); 
      UnreadConversation unreadConversation = this.b;
      if (unreadConversation != null)
        bundle.putBundle("car_conversation", a(unreadConversation)); 
      param1Builder.getExtras().putBundle("android.car.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    public int getColor() {
      return this.c;
    }
    
    public Bitmap getLargeIcon() {
      return this.a;
    }
    
    public UnreadConversation getUnreadConversation() {
      return this.b;
    }
    
    public CarExtender setColor(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap param1Bitmap) {
      this.a = param1Bitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation param1UnreadConversation) {
      this.b = param1UnreadConversation;
      return this;
    }
    
    public static class UnreadConversation {
      private final String[] a;
      
      private final RemoteInput b;
      
      private final PendingIntent c;
      
      private final PendingIntent d;
      
      private final String[] e;
      
      private final long f;
      
      UnreadConversation(String[] param2ArrayOfString1, RemoteInput param2RemoteInput, PendingIntent param2PendingIntent1, PendingIntent param2PendingIntent2, String[] param2ArrayOfString2, long param2Long) {
        this.a = param2ArrayOfString1;
        this.b = param2RemoteInput;
        this.d = param2PendingIntent2;
        this.c = param2PendingIntent1;
        this.e = param2ArrayOfString2;
        this.f = param2Long;
      }
      
      public long getLatestTimestamp() {
        return this.f;
      }
      
      public String[] getMessages() {
        return this.a;
      }
      
      public String getParticipant() {
        String[] arrayOfString = this.e;
        return (arrayOfString.length > 0) ? arrayOfString[0] : null;
      }
      
      public String[] getParticipants() {
        return this.e;
      }
      
      public PendingIntent getReadPendingIntent() {
        return this.d;
      }
      
      public RemoteInput getRemoteInput() {
        return this.b;
      }
      
      public PendingIntent getReplyPendingIntent() {
        return this.c;
      }
      
      public static class Builder {
        private final List<String> a = new ArrayList<String>();
        
        private final String b;
        
        private RemoteInput c;
        
        private PendingIntent d;
        
        private PendingIntent e;
        
        private long f;
        
        public Builder(String param3String) {
          this.b = param3String;
        }
        
        public Builder addMessage(String param3String) {
          this.a.add(param3String);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build() {
          List<String> list = this.a;
          String[] arrayOfString = list.<String>toArray(new String[list.size()]);
          String str = this.b;
          RemoteInput remoteInput = this.c;
          PendingIntent pendingIntent1 = this.e;
          PendingIntent pendingIntent2 = this.d;
          long l = this.f;
          return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long param3Long) {
          this.f = param3Long;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
          this.d = param3PendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
          this.c = param3RemoteInput;
          this.e = param3PendingIntent;
          return this;
        }
      }
    }
    
    public static class Builder {
      private final List<String> a = new ArrayList<String>();
      
      private final String b;
      
      private RemoteInput c;
      
      private PendingIntent d;
      
      private PendingIntent e;
      
      private long f;
      
      public Builder(String param2String) {
        this.b = param2String;
      }
      
      public Builder addMessage(String param2String) {
        this.a.add(param2String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        List<String> list = this.a;
        String[] arrayOfString = list.<String>toArray(new String[list.size()]);
        String str = this.b;
        RemoteInput remoteInput = this.c;
        PendingIntent pendingIntent1 = this.e;
        PendingIntent pendingIntent2 = this.d;
        long l = this.f;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param2Long) {
        this.f = param2Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param2PendingIntent) {
        this.d = param2PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param2PendingIntent, RemoteInput param2RemoteInput) {
        this.c = param2RemoteInput;
        this.e = param2PendingIntent;
        return this;
      }
    }
  }
  
  public static class UnreadConversation {
    private final String[] a;
    
    private final RemoteInput b;
    
    private final PendingIntent c;
    
    private final PendingIntent d;
    
    private final String[] e;
    
    private final long f;
    
    UnreadConversation(String[] param1ArrayOfString1, RemoteInput param1RemoteInput, PendingIntent param1PendingIntent1, PendingIntent param1PendingIntent2, String[] param1ArrayOfString2, long param1Long) {
      this.a = param1ArrayOfString1;
      this.b = param1RemoteInput;
      this.d = param1PendingIntent2;
      this.c = param1PendingIntent1;
      this.e = param1ArrayOfString2;
      this.f = param1Long;
    }
    
    public long getLatestTimestamp() {
      return this.f;
    }
    
    public String[] getMessages() {
      return this.a;
    }
    
    public String getParticipant() {
      String[] arrayOfString = this.e;
      return (arrayOfString.length > 0) ? arrayOfString[0] : null;
    }
    
    public String[] getParticipants() {
      return this.e;
    }
    
    public PendingIntent getReadPendingIntent() {
      return this.d;
    }
    
    public RemoteInput getRemoteInput() {
      return this.b;
    }
    
    public PendingIntent getReplyPendingIntent() {
      return this.c;
    }
    
    public static class Builder {
      private final List<String> a = new ArrayList<String>();
      
      private final String b;
      
      private RemoteInput c;
      
      private PendingIntent d;
      
      private PendingIntent e;
      
      private long f;
      
      public Builder(String param3String) {
        this.b = param3String;
      }
      
      public Builder addMessage(String param3String) {
        this.a.add(param3String);
        return this;
      }
      
      public NotificationCompat.CarExtender.UnreadConversation build() {
        List<String> list = this.a;
        String[] arrayOfString = list.<String>toArray(new String[list.size()]);
        String str = this.b;
        RemoteInput remoteInput = this.c;
        PendingIntent pendingIntent1 = this.e;
        PendingIntent pendingIntent2 = this.d;
        long l = this.f;
        return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
      }
      
      public Builder setLatestTimestamp(long param3Long) {
        this.f = param3Long;
        return this;
      }
      
      public Builder setReadPendingIntent(PendingIntent param3PendingIntent) {
        this.d = param3PendingIntent;
        return this;
      }
      
      public Builder setReplyAction(PendingIntent param3PendingIntent, RemoteInput param3RemoteInput) {
        this.c = param3RemoteInput;
        this.e = param3PendingIntent;
        return this;
      }
    }
  }
  
  public static class Builder {
    private final List<String> a = new ArrayList<String>();
    
    private final String b;
    
    private RemoteInput c;
    
    private PendingIntent d;
    
    private PendingIntent e;
    
    private long f;
    
    public Builder(String param1String) {
      this.b = param1String;
    }
    
    public Builder addMessage(String param1String) {
      this.a.add(param1String);
      return this;
    }
    
    public NotificationCompat.CarExtender.UnreadConversation build() {
      List<String> list = this.a;
      String[] arrayOfString = list.<String>toArray(new String[list.size()]);
      String str = this.b;
      RemoteInput remoteInput = this.c;
      PendingIntent pendingIntent1 = this.e;
      PendingIntent pendingIntent2 = this.d;
      long l = this.f;
      return new NotificationCompat.CarExtender.UnreadConversation(arrayOfString, remoteInput, pendingIntent1, pendingIntent2, new String[] { str }, l);
    }
    
    public Builder setLatestTimestamp(long param1Long) {
      this.f = param1Long;
      return this;
    }
    
    public Builder setReadPendingIntent(PendingIntent param1PendingIntent) {
      this.d = param1PendingIntent;
      return this;
    }
    
    public Builder setReplyAction(PendingIntent param1PendingIntent, RemoteInput param1RemoteInput) {
      this.c = param1RemoteInput;
      this.e = param1PendingIntent;
      return this;
    }
  }
  
  public static class DecoratedCustomViewStyle extends Style {
    private RemoteViews a(RemoteViews param1RemoteViews, boolean param1Boolean) {
      // Byte code:
      //   0: getstatic androidx/core/R$layout.notification_template_custom_big : I
      //   3: istore_3
      //   4: iconst_1
      //   5: istore #6
      //   7: iconst_0
      //   8: istore #5
      //   10: aload_0
      //   11: iconst_1
      //   12: iload_3
      //   13: iconst_0
      //   14: invokevirtual applyStandardTemplate : (ZIZ)Landroid/widget/RemoteViews;
      //   17: astore #8
      //   19: aload #8
      //   21: getstatic androidx/core/R$id.actions : I
      //   24: invokevirtual removeAllViews : (I)V
      //   27: aload_0
      //   28: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   31: getfield mActions : Ljava/util/ArrayList;
      //   34: invokestatic a : (Ljava/util/List;)Ljava/util/List;
      //   37: astore #9
      //   39: iload_2
      //   40: ifeq -> 112
      //   43: aload #9
      //   45: ifnull -> 112
      //   48: aload #9
      //   50: invokeinterface size : ()I
      //   55: iconst_3
      //   56: invokestatic min : (II)I
      //   59: istore #7
      //   61: iload #7
      //   63: ifle -> 112
      //   66: iconst_0
      //   67: istore_3
      //   68: iload #6
      //   70: istore #4
      //   72: iload_3
      //   73: iload #7
      //   75: if_icmpge -> 115
      //   78: aload_0
      //   79: aload #9
      //   81: iload_3
      //   82: invokeinterface get : (I)Ljava/lang/Object;
      //   87: checkcast androidx/core/app/NotificationCompat$Action
      //   90: invokespecial a : (Landroidx/core/app/NotificationCompat$Action;)Landroid/widget/RemoteViews;
      //   93: astore #10
      //   95: aload #8
      //   97: getstatic androidx/core/R$id.actions : I
      //   100: aload #10
      //   102: invokevirtual addView : (ILandroid/widget/RemoteViews;)V
      //   105: iload_3
      //   106: iconst_1
      //   107: iadd
      //   108: istore_3
      //   109: goto -> 68
      //   112: iconst_0
      //   113: istore #4
      //   115: iload #4
      //   117: ifeq -> 126
      //   120: iload #5
      //   122: istore_3
      //   123: goto -> 129
      //   126: bipush #8
      //   128: istore_3
      //   129: aload #8
      //   131: getstatic androidx/core/R$id.actions : I
      //   134: iload_3
      //   135: invokevirtual setViewVisibility : (II)V
      //   138: aload #8
      //   140: getstatic androidx/core/R$id.action_divider : I
      //   143: iload_3
      //   144: invokevirtual setViewVisibility : (II)V
      //   147: aload_0
      //   148: aload #8
      //   150: aload_1
      //   151: invokevirtual buildIntoRemoteViews : (Landroid/widget/RemoteViews;Landroid/widget/RemoteViews;)V
      //   154: aload #8
      //   156: areturn
    }
    
    private RemoteViews a(NotificationCompat.Action param1Action) {
      boolean bool;
      int i;
      if (param1Action.actionIntent == null) {
        bool = true;
      } else {
        bool = false;
      } 
      String str = this.a.mContext.getPackageName();
      if (bool) {
        i = R.layout.notification_action_tombstone;
      } else {
        i = R.layout.notification_action;
      } 
      RemoteViews remoteViews = new RemoteViews(str, i);
      remoteViews.setImageViewBitmap(R.id.action_image, a(param1Action.getIconCompat(), this.a.mContext.getResources().getColor(R.color.notification_action_color_filter)));
      remoteViews.setTextViewText(R.id.action_text, param1Action.title);
      if (!bool)
        remoteViews.setOnClickPendingIntent(R.id.action_container, param1Action.actionIntent); 
      if (Build.VERSION.SDK_INT >= 15)
        remoteViews.setContentDescription(R.id.action_container, param1Action.title); 
      return remoteViews;
    }
    
    private static List<NotificationCompat.Action> a(List<NotificationCompat.Action> param1List) {
      if (param1List == null)
        return null; 
      ArrayList<NotificationCompat.Action> arrayList = new ArrayList();
      for (NotificationCompat.Action action : param1List) {
        if (!action.isContextual())
          arrayList.add(action); 
      } 
      return arrayList;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 24)
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle()); 
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      RemoteViews remoteViews = this.a.getBigContentView();
      if (remoteViews == null)
        remoteViews = this.a.getContentView(); 
      return (remoteViews == null) ? null : a(remoteViews, true);
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return (Build.VERSION.SDK_INT >= 24) ? null : ((this.a.getContentView() == null) ? null : a(this.a.getContentView(), false));
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      RemoteViews remoteViews1;
      if (Build.VERSION.SDK_INT >= 24)
        return null; 
      RemoteViews remoteViews2 = this.a.getHeadsUpContentView();
      if (remoteViews2 != null) {
        remoteViews1 = remoteViews2;
      } else {
        remoteViews1 = this.a.getContentView();
      } 
      return (remoteViews2 == null) ? null : a(remoteViews1, true);
    }
  }
  
  public static interface Extender {
    NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GroupAlertBehavior {}
  
  public static class InboxStyle extends Style {
    private ArrayList<CharSequence> e = new ArrayList<CharSequence>();
    
    public InboxStyle() {}
    
    public InboxStyle(NotificationCompat.Builder param1Builder) {
      setBuilder(param1Builder);
    }
    
    public InboxStyle addLine(CharSequence param1CharSequence) {
      this.e.add(NotificationCompat.Builder.a(param1CharSequence));
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      if (Build.VERSION.SDK_INT >= 16) {
        Notification.InboxStyle inboxStyle = (new Notification.InboxStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(this.b);
        if (this.d)
          inboxStyle.setSummaryText(this.c); 
        Iterator<CharSequence> iterator = this.e.iterator();
        while (iterator.hasNext())
          inboxStyle.addLine(iterator.next()); 
      } 
    }
    
    public InboxStyle setBigContentTitle(CharSequence param1CharSequence) {
      this.b = NotificationCompat.Builder.a(param1CharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence param1CharSequence) {
      this.c = NotificationCompat.Builder.a(param1CharSequence);
      this.d = true;
      return this;
    }
  }
  
  public static class MessagingStyle extends Style {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    
    private final List<Message> e = new ArrayList<Message>();
    
    private Person f;
    
    private CharSequence g;
    
    private Boolean h;
    
    private MessagingStyle() {}
    
    public MessagingStyle(Person param1Person) {
      if (!TextUtils.isEmpty(param1Person.getName())) {
        this.f = param1Person;
        return;
      } 
      throw new IllegalArgumentException("User's name must not be empty.");
    }
    
    @Deprecated
    public MessagingStyle(CharSequence param1CharSequence) {
      this.f = (new Person.Builder()).setName(param1CharSequence).build();
    }
    
    private TextAppearanceSpan a(int param1Int) {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(param1Int), null);
    }
    
    private Message a() {
      for (int i = this.e.size() - 1; i >= 0; i--) {
        Message message = this.e.get(i);
        if (message.getPerson() != null && !TextUtils.isEmpty(message.getPerson().getName()))
          return message; 
      } 
      if (!this.e.isEmpty()) {
        List<Message> list = this.e;
        return list.get(list.size() - 1);
      } 
      return null;
    }
    
    private CharSequence a(Message param1Message) {
      CharSequence charSequence1;
      byte b;
      boolean bool;
      BidiFormatter bidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
      if (Build.VERSION.SDK_INT >= 21) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        b = -16777216;
      } else {
        b = -1;
      } 
      Person person = param1Message.getPerson();
      String str = "";
      if (person == null) {
        charSequence2 = "";
      } else {
        charSequence2 = param1Message.getPerson().getName();
      } 
      int i = b;
      CharSequence charSequence3 = charSequence2;
      if (TextUtils.isEmpty(charSequence2)) {
        charSequence2 = this.f.getName();
        i = b;
        charSequence3 = charSequence2;
        if (bool) {
          i = b;
          charSequence3 = charSequence2;
          if (this.a.getColor() != 0) {
            i = this.a.getColor();
            charSequence3 = charSequence2;
          } 
        } 
      } 
      CharSequence charSequence2 = bidiFormatter.unicodeWrap(charSequence3);
      spannableStringBuilder.append(charSequence2);
      spannableStringBuilder.setSpan(a(i), spannableStringBuilder.length() - charSequence2.length(), spannableStringBuilder.length(), 33);
      if (param1Message.getText() == null) {
        charSequence1 = str;
      } else {
        charSequence1 = charSequence1.getText();
      } 
      spannableStringBuilder.append("  ").append(bidiFormatter.unicodeWrap(charSequence1));
      return (CharSequence)spannableStringBuilder;
    }
    
    private boolean b() {
      for (int i = this.e.size() - 1; i >= 0; i--) {
        Message message = this.e.get(i);
        if (message.getPerson() != null && message.getPerson().getName() == null)
          return true; 
      } 
      return false;
    }
    
    public static MessagingStyle extractMessagingStyleFromNotification(Notification param1Notification) {
      Bundle bundle = NotificationCompat.getExtras(param1Notification);
      if (bundle != null && !bundle.containsKey("android.selfDisplayName") && !bundle.containsKey("android.messagingStyleUser"))
        return null; 
      try {
        MessagingStyle messagingStyle = new MessagingStyle();
        messagingStyle.a(bundle);
        return messagingStyle;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    protected void a(Bundle param1Bundle) {
      this.e.clear();
      if (param1Bundle.containsKey("android.messagingStyleUser")) {
        this.f = Person.fromBundle(param1Bundle.getBundle("android.messagingStyleUser"));
      } else {
        this.f = (new Person.Builder()).setName(param1Bundle.getString("android.selfDisplayName")).build();
      } 
      this.g = param1Bundle.getCharSequence("android.conversationTitle");
      if (this.g == null)
        this.g = param1Bundle.getCharSequence("android.hiddenConversationTitle"); 
      Parcelable[] arrayOfParcelable = param1Bundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null)
        this.e.addAll(Message.a(arrayOfParcelable)); 
      if (param1Bundle.containsKey("android.isGroupConversation"))
        this.h = Boolean.valueOf(param1Bundle.getBoolean("android.isGroupConversation")); 
    }
    
    public void addCompatExtras(Bundle param1Bundle) {
      super.addCompatExtras(param1Bundle);
      param1Bundle.putCharSequence("android.selfDisplayName", this.f.getName());
      param1Bundle.putBundle("android.messagingStyleUser", this.f.toBundle());
      param1Bundle.putCharSequence("android.hiddenConversationTitle", this.g);
      if (this.g != null && this.h.booleanValue())
        param1Bundle.putCharSequence("android.conversationTitle", this.g); 
      if (!this.e.isEmpty())
        param1Bundle.putParcelableArray("android.messages", (Parcelable[])Message.a(this.e)); 
      Boolean bool = this.h;
      if (bool != null)
        param1Bundle.putBoolean("android.isGroupConversation", bool.booleanValue()); 
    }
    
    public MessagingStyle addMessage(Message param1Message) {
      this.e.add(param1Message);
      if (this.e.size() > 25)
        this.e.remove(0); 
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence param1CharSequence, long param1Long, Person param1Person) {
      addMessage(new Message(param1CharSequence, param1Long, param1Person));
      return this;
    }
    
    @Deprecated
    public MessagingStyle addMessage(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this.e.add(new Message(param1CharSequence1, param1Long, (new Person.Builder()).setName(param1CharSequence2).build()));
      if (this.e.size() > 25)
        this.e.remove(0); 
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      setGroupConversation(isGroupConversation());
      if (Build.VERSION.SDK_INT >= 24) {
        Notification.MessagingStyle messagingStyle;
        if (Build.VERSION.SDK_INT >= 28) {
          messagingStyle = new Notification.MessagingStyle(this.f.toAndroidPerson());
        } else {
          messagingStyle = new Notification.MessagingStyle(this.f.getName());
        } 
        if (this.h.booleanValue() || Build.VERSION.SDK_INT >= 28)
          messagingStyle.setConversationTitle(this.g); 
        if (Build.VERSION.SDK_INT >= 28)
          messagingStyle.setGroupConversation(this.h.booleanValue()); 
        for (Message message2 : this.e) {
          Notification.MessagingStyle.Message message1;
          if (Build.VERSION.SDK_INT >= 28) {
            Person person;
            Person person1 = message2.getPerson();
            CharSequence charSequence = message2.getText();
            long l = message2.getTimestamp();
            if (person1 == null) {
              person1 = null;
            } else {
              person = person1.toAndroidPerson();
            } 
            message1 = new Notification.MessagingStyle.Message(charSequence, l, person);
          } else {
            if (message2.getPerson() != null) {
              message1 = (Notification.MessagingStyle.Message)message2.getPerson().getName();
            } else {
              message1 = null;
            } 
            message1 = new Notification.MessagingStyle.Message(message2.getText(), message2.getTimestamp(), (CharSequence)message1);
          } 
          if (message2.getDataMimeType() != null)
            message1.setData(message2.getDataMimeType(), message2.getDataUri()); 
          messagingStyle.addMessage(message1);
        } 
        messagingStyle.setBuilder(param1NotificationBuilderWithBuilderAccessor.getBuilder());
        return;
      } 
      Message message = a();
      if (this.g != null && this.h.booleanValue()) {
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(this.g);
      } else if (message != null) {
        param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
        if (message.getPerson() != null)
          param1NotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(message.getPerson().getName()); 
      } 
      if (message != null) {
        CharSequence charSequence;
        Notification.Builder builder = param1NotificationBuilderWithBuilderAccessor.getBuilder();
        if (this.g != null) {
          charSequence = a(message);
        } else {
          charSequence = charSequence.getText();
        } 
        builder.setContentText(charSequence);
      } 
      if (Build.VERSION.SDK_INT >= 16) {
        boolean bool;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.g != null || b()) {
          bool = true;
        } else {
          bool = false;
        } 
        for (int i = this.e.size() - 1; i >= 0; i--) {
          CharSequence charSequence;
          message = this.e.get(i);
          if (bool) {
            charSequence = a(message);
          } else {
            charSequence = charSequence.getText();
          } 
          if (i != this.e.size() - 1)
            spannableStringBuilder.insert(0, "\n"); 
          spannableStringBuilder.insert(0, charSequence);
        } 
        (new Notification.BigTextStyle(param1NotificationBuilderWithBuilderAccessor.getBuilder())).setBigContentTitle(null).bigText((CharSequence)spannableStringBuilder);
      } 
    }
    
    public CharSequence getConversationTitle() {
      return this.g;
    }
    
    public List<Message> getMessages() {
      return this.e;
    }
    
    public Person getUser() {
      return this.f;
    }
    
    @Deprecated
    public CharSequence getUserDisplayName() {
      return this.f.getName();
    }
    
    public boolean isGroupConversation() {
      NotificationCompat.Builder builder = this.a;
      boolean bool2 = false;
      boolean bool1 = false;
      if (builder != null && (this.a.mContext.getApplicationInfo()).targetSdkVersion < 28 && this.h == null) {
        if (this.g != null)
          bool1 = true; 
        return bool1;
      } 
      Boolean bool = this.h;
      bool1 = bool2;
      if (bool != null)
        bool1 = bool.booleanValue(); 
      return bool1;
    }
    
    public MessagingStyle setConversationTitle(CharSequence param1CharSequence) {
      this.g = param1CharSequence;
      return this;
    }
    
    public MessagingStyle setGroupConversation(boolean param1Boolean) {
      this.h = Boolean.valueOf(param1Boolean);
      return this;
    }
    
    public static final class Message {
      private final CharSequence a;
      
      private final long b;
      
      private final Person c;
      
      private Bundle d = new Bundle();
      
      private String e;
      
      private Uri f;
      
      public Message(CharSequence param2CharSequence, long param2Long, Person param2Person) {
        this.a = param2CharSequence;
        this.b = param2Long;
        this.c = param2Person;
      }
      
      @Deprecated
      public Message(CharSequence param2CharSequence1, long param2Long, CharSequence param2CharSequence2) {
        this(param2CharSequence1, param2Long, (new Person.Builder()).setName(param2CharSequence2).build());
      }
      
      private Bundle a() {
        Bundle bundle1 = new Bundle();
        CharSequence charSequence = this.a;
        if (charSequence != null)
          bundle1.putCharSequence("text", charSequence); 
        bundle1.putLong("time", this.b);
        Person person = this.c;
        if (person != null) {
          bundle1.putCharSequence("sender", person.getName());
          if (Build.VERSION.SDK_INT >= 28) {
            bundle1.putParcelable("sender_person", (Parcelable)this.c.toAndroidPerson());
          } else {
            bundle1.putBundle("person", this.c.toBundle());
          } 
        } 
        String str = this.e;
        if (str != null)
          bundle1.putString("type", str); 
        Uri uri = this.f;
        if (uri != null)
          bundle1.putParcelable("uri", (Parcelable)uri); 
        Bundle bundle2 = this.d;
        if (bundle2 != null)
          bundle1.putBundle("extras", bundle2); 
        return bundle1;
      }
      
      static Message a(Bundle param2Bundle) {
        try {
          if (param2Bundle.containsKey("text")) {
            if (!param2Bundle.containsKey("time"))
              return null; 
            if (param2Bundle.containsKey("person")) {
              message = (Message)Person.fromBundle(param2Bundle.getBundle("person"));
            } else if (param2Bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
              message = (Message)Person.fromAndroidPerson((Person)param2Bundle.getParcelable("sender_person"));
            } else if (param2Bundle.containsKey("sender")) {
              message = (Message)(new Person.Builder()).setName(param2Bundle.getCharSequence("sender")).build();
            } else {
              message = null;
            } 
            Message message = new Message(param2Bundle.getCharSequence("text"), param2Bundle.getLong("time"), (Person)message);
            if (param2Bundle.containsKey("type") && param2Bundle.containsKey("uri"))
              message.setData(param2Bundle.getString("type"), (Uri)param2Bundle.getParcelable("uri")); 
            if (param2Bundle.containsKey("extras"))
              message.getExtras().putAll(param2Bundle.getBundle("extras")); 
            return message;
          } 
          return null;
        } catch (ClassCastException classCastException) {
          return null;
        } 
      }
      
      static List<Message> a(Parcelable[] param2ArrayOfParcelable) {
        ArrayList<Message> arrayList = new ArrayList(param2ArrayOfParcelable.length);
        for (int i = 0; i < param2ArrayOfParcelable.length; i++) {
          if (param2ArrayOfParcelable[i] instanceof Bundle) {
            Message message = a((Bundle)param2ArrayOfParcelable[i]);
            if (message != null)
              arrayList.add(message); 
          } 
        } 
        return arrayList;
      }
      
      static Bundle[] a(List<Message> param2List) {
        Bundle[] arrayOfBundle = new Bundle[param2List.size()];
        int j = param2List.size();
        for (int i = 0; i < j; i++)
          arrayOfBundle[i] = ((Message)param2List.get(i)).a(); 
        return arrayOfBundle;
      }
      
      public String getDataMimeType() {
        return this.e;
      }
      
      public Uri getDataUri() {
        return this.f;
      }
      
      public Bundle getExtras() {
        return this.d;
      }
      
      public Person getPerson() {
        return this.c;
      }
      
      @Deprecated
      public CharSequence getSender() {
        Person person = this.c;
        return (person == null) ? null : person.getName();
      }
      
      public CharSequence getText() {
        return this.a;
      }
      
      public long getTimestamp() {
        return this.b;
      }
      
      public Message setData(String param2String, Uri param2Uri) {
        this.e = param2String;
        this.f = param2Uri;
        return this;
      }
    }
  }
  
  public static final class Message {
    private final CharSequence a;
    
    private final long b;
    
    private final Person c;
    
    private Bundle d = new Bundle();
    
    private String e;
    
    private Uri f;
    
    public Message(CharSequence param1CharSequence, long param1Long, Person param1Person) {
      this.a = param1CharSequence;
      this.b = param1Long;
      this.c = param1Person;
    }
    
    @Deprecated
    public Message(CharSequence param1CharSequence1, long param1Long, CharSequence param1CharSequence2) {
      this(param1CharSequence1, param1Long, (new Person.Builder()).setName(param1CharSequence2).build());
    }
    
    private Bundle a() {
      Bundle bundle1 = new Bundle();
      CharSequence charSequence = this.a;
      if (charSequence != null)
        bundle1.putCharSequence("text", charSequence); 
      bundle1.putLong("time", this.b);
      Person person = this.c;
      if (person != null) {
        bundle1.putCharSequence("sender", person.getName());
        if (Build.VERSION.SDK_INT >= 28) {
          bundle1.putParcelable("sender_person", (Parcelable)this.c.toAndroidPerson());
        } else {
          bundle1.putBundle("person", this.c.toBundle());
        } 
      } 
      String str = this.e;
      if (str != null)
        bundle1.putString("type", str); 
      Uri uri = this.f;
      if (uri != null)
        bundle1.putParcelable("uri", (Parcelable)uri); 
      Bundle bundle2 = this.d;
      if (bundle2 != null)
        bundle1.putBundle("extras", bundle2); 
      return bundle1;
    }
    
    static Message a(Bundle param1Bundle) {
      try {
        if (param1Bundle.containsKey("text")) {
          if (!param1Bundle.containsKey("time"))
            return null; 
          if (param1Bundle.containsKey("person")) {
            message = (Message)Person.fromBundle(param1Bundle.getBundle("person"));
          } else if (param1Bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
            message = (Message)Person.fromAndroidPerson((Person)param1Bundle.getParcelable("sender_person"));
          } else if (param1Bundle.containsKey("sender")) {
            message = (Message)(new Person.Builder()).setName(param1Bundle.getCharSequence("sender")).build();
          } else {
            message = null;
          } 
          Message message = new Message(param1Bundle.getCharSequence("text"), param1Bundle.getLong("time"), (Person)message);
          if (param1Bundle.containsKey("type") && param1Bundle.containsKey("uri"))
            message.setData(param1Bundle.getString("type"), (Uri)param1Bundle.getParcelable("uri")); 
          if (param1Bundle.containsKey("extras"))
            message.getExtras().putAll(param1Bundle.getBundle("extras")); 
          return message;
        } 
        return null;
      } catch (ClassCastException classCastException) {
        return null;
      } 
    }
    
    static List<Message> a(Parcelable[] param1ArrayOfParcelable) {
      ArrayList<Message> arrayList = new ArrayList(param1ArrayOfParcelable.length);
      for (int i = 0; i < param1ArrayOfParcelable.length; i++) {
        if (param1ArrayOfParcelable[i] instanceof Bundle) {
          Message message = a((Bundle)param1ArrayOfParcelable[i]);
          if (message != null)
            arrayList.add(message); 
        } 
      } 
      return arrayList;
    }
    
    static Bundle[] a(List<Message> param1List) {
      Bundle[] arrayOfBundle = new Bundle[param1List.size()];
      int j = param1List.size();
      for (int i = 0; i < j; i++)
        arrayOfBundle[i] = ((Message)param1List.get(i)).a(); 
      return arrayOfBundle;
    }
    
    public String getDataMimeType() {
      return this.e;
    }
    
    public Uri getDataUri() {
      return this.f;
    }
    
    public Bundle getExtras() {
      return this.d;
    }
    
    public Person getPerson() {
      return this.c;
    }
    
    @Deprecated
    public CharSequence getSender() {
      Person person = this.c;
      return (person == null) ? null : person.getName();
    }
    
    public CharSequence getText() {
      return this.a;
    }
    
    public long getTimestamp() {
      return this.b;
    }
    
    public Message setData(String param1String, Uri param1Uri) {
      this.e = param1String;
      this.f = param1Uri;
      return this;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface NotificationVisibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface StreamType {}
  
  public static abstract class Style {
    protected NotificationCompat.Builder a;
    
    CharSequence b;
    
    CharSequence c;
    
    boolean d = false;
    
    private static float a(float param1Float1, float param1Float2, float param1Float3) {
      if (param1Float1 < param1Float2)
        return param1Float2; 
      param1Float2 = param1Float1;
      if (param1Float1 > param1Float3)
        param1Float2 = param1Float3; 
      return param1Float2;
    }
    
    private int a() {
      Resources resources = this.a.mContext.getResources();
      int i = resources.getDimensionPixelSize(R.dimen.notification_top_pad);
      int j = resources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
      float f = (a((resources.getConfiguration()).fontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
      return Math.round((1.0F - f) * i + f * j);
    }
    
    private Bitmap a(int param1Int1, int param1Int2, int param1Int3) {
      return a(IconCompat.createWithResource(this.a.mContext, param1Int1), param1Int2, param1Int3);
    }
    
    private Bitmap a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      int j = R.drawable.notification_icon_background;
      int i = param1Int4;
      if (param1Int4 == 0)
        i = 0; 
      Bitmap bitmap = a(j, i, param1Int2);
      Canvas canvas = new Canvas(bitmap);
      Drawable drawable = this.a.mContext.getResources().getDrawable(param1Int1).mutate();
      drawable.setFilterBitmap(true);
      param1Int1 = (param1Int2 - param1Int3) / 2;
      param1Int2 = param1Int3 + param1Int1;
      drawable.setBounds(param1Int1, param1Int1, param1Int2, param1Int2);
      drawable.setColorFilter((ColorFilter)new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      drawable.draw(canvas);
      return bitmap;
    }
    
    private Bitmap a(IconCompat param1IconCompat, int param1Int1, int param1Int2) {
      int i;
      Drawable drawable = param1IconCompat.loadDrawable(this.a.mContext);
      if (param1Int2 == 0) {
        i = drawable.getIntrinsicWidth();
      } else {
        i = param1Int2;
      } 
      int j = param1Int2;
      if (param1Int2 == 0)
        j = drawable.getIntrinsicHeight(); 
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      drawable.setBounds(0, 0, i, j);
      if (param1Int1 != 0)
        drawable.mutate().setColorFilter((ColorFilter)new PorterDuffColorFilter(param1Int1, PorterDuff.Mode.SRC_IN)); 
      drawable.draw(new Canvas(bitmap));
      return bitmap;
    }
    
    private void a(RemoteViews param1RemoteViews) {
      param1RemoteViews.setViewVisibility(R.id.title, 8);
      param1RemoteViews.setViewVisibility(R.id.text2, 8);
      param1RemoteViews.setViewVisibility(R.id.text, 8);
    }
    
    Bitmap a(IconCompat param1IconCompat, int param1Int) {
      return a(param1IconCompat, param1Int, 0);
    }
    
    protected void a(Bundle param1Bundle) {}
    
    public void addCompatExtras(Bundle param1Bundle) {}
    
    public void apply(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {}
    
    public RemoteViews applyStandardTemplate(boolean param1Boolean1, int param1Int, boolean param1Boolean2) {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   4: getfield mContext : Landroid/content/Context;
      //   7: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   10: astore #8
      //   12: new android/widget/RemoteViews
      //   15: dup
      //   16: aload_0
      //   17: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   20: getfield mContext : Landroid/content/Context;
      //   23: invokevirtual getPackageName : ()Ljava/lang/String;
      //   26: iload_2
      //   27: invokespecial <init> : (Ljava/lang/String;I)V
      //   30: astore #9
      //   32: aload_0
      //   33: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   36: invokevirtual getPriority : ()I
      //   39: istore_2
      //   40: iconst_0
      //   41: istore #7
      //   43: iload_2
      //   44: iconst_m1
      //   45: if_icmpge -> 53
      //   48: iconst_1
      //   49: istore_2
      //   50: goto -> 55
      //   53: iconst_0
      //   54: istore_2
      //   55: getstatic android/os/Build$VERSION.SDK_INT : I
      //   58: bipush #16
      //   60: if_icmplt -> 130
      //   63: getstatic android/os/Build$VERSION.SDK_INT : I
      //   66: bipush #21
      //   68: if_icmpge -> 130
      //   71: iload_2
      //   72: ifeq -> 104
      //   75: aload #9
      //   77: getstatic androidx/core/R$id.notification_background : I
      //   80: ldc 'setBackgroundResource'
      //   82: getstatic androidx/core/R$drawable.notification_bg_low : I
      //   85: invokevirtual setInt : (ILjava/lang/String;I)V
      //   88: aload #9
      //   90: getstatic androidx/core/R$id.icon : I
      //   93: ldc 'setBackgroundResource'
      //   95: getstatic androidx/core/R$drawable.notification_template_icon_low_bg : I
      //   98: invokevirtual setInt : (ILjava/lang/String;I)V
      //   101: goto -> 130
      //   104: aload #9
      //   106: getstatic androidx/core/R$id.notification_background : I
      //   109: ldc 'setBackgroundResource'
      //   111: getstatic androidx/core/R$drawable.notification_bg : I
      //   114: invokevirtual setInt : (ILjava/lang/String;I)V
      //   117: aload #9
      //   119: getstatic androidx/core/R$id.icon : I
      //   122: ldc 'setBackgroundResource'
      //   124: getstatic androidx/core/R$drawable.notification_template_icon_bg : I
      //   127: invokevirtual setInt : (ILjava/lang/String;I)V
      //   130: aload_0
      //   131: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   134: getfield g : Landroid/graphics/Bitmap;
      //   137: ifnull -> 307
      //   140: getstatic android/os/Build$VERSION.SDK_INT : I
      //   143: bipush #16
      //   145: if_icmplt -> 175
      //   148: aload #9
      //   150: getstatic androidx/core/R$id.icon : I
      //   153: iconst_0
      //   154: invokevirtual setViewVisibility : (II)V
      //   157: aload #9
      //   159: getstatic androidx/core/R$id.icon : I
      //   162: aload_0
      //   163: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   166: getfield g : Landroid/graphics/Bitmap;
      //   169: invokevirtual setImageViewBitmap : (ILandroid/graphics/Bitmap;)V
      //   172: goto -> 185
      //   175: aload #9
      //   177: getstatic androidx/core/R$id.icon : I
      //   180: bipush #8
      //   182: invokevirtual setViewVisibility : (II)V
      //   185: iload_1
      //   186: ifeq -> 435
      //   189: aload_0
      //   190: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   193: getfield O : Landroid/app/Notification;
      //   196: getfield icon : I
      //   199: ifeq -> 435
      //   202: aload #8
      //   204: getstatic androidx/core/R$dimen.notification_right_icon_size : I
      //   207: invokevirtual getDimensionPixelSize : (I)I
      //   210: istore_2
      //   211: aload #8
      //   213: getstatic androidx/core/R$dimen.notification_small_icon_background_padding : I
      //   216: invokevirtual getDimensionPixelSize : (I)I
      //   219: istore #5
      //   221: getstatic android/os/Build$VERSION.SDK_INT : I
      //   224: bipush #21
      //   226: if_icmplt -> 272
      //   229: aload_0
      //   230: aload_0
      //   231: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   234: getfield O : Landroid/app/Notification;
      //   237: getfield icon : I
      //   240: iload_2
      //   241: iload_2
      //   242: iload #5
      //   244: iconst_2
      //   245: imul
      //   246: isub
      //   247: aload_0
      //   248: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   251: invokevirtual getColor : ()I
      //   254: invokespecial a : (IIII)Landroid/graphics/Bitmap;
      //   257: astore #10
      //   259: aload #9
      //   261: getstatic androidx/core/R$id.right_icon : I
      //   264: aload #10
      //   266: invokevirtual setImageViewBitmap : (ILandroid/graphics/Bitmap;)V
      //   269: goto -> 295
      //   272: aload #9
      //   274: getstatic androidx/core/R$id.right_icon : I
      //   277: aload_0
      //   278: aload_0
      //   279: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   282: getfield O : Landroid/app/Notification;
      //   285: getfield icon : I
      //   288: iconst_m1
      //   289: invokevirtual createColoredBitmap : (II)Landroid/graphics/Bitmap;
      //   292: invokevirtual setImageViewBitmap : (ILandroid/graphics/Bitmap;)V
      //   295: aload #9
      //   297: getstatic androidx/core/R$id.right_icon : I
      //   300: iconst_0
      //   301: invokevirtual setViewVisibility : (II)V
      //   304: goto -> 435
      //   307: iload_1
      //   308: ifeq -> 435
      //   311: aload_0
      //   312: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   315: getfield O : Landroid/app/Notification;
      //   318: getfield icon : I
      //   321: ifeq -> 435
      //   324: aload #9
      //   326: getstatic androidx/core/R$id.icon : I
      //   329: iconst_0
      //   330: invokevirtual setViewVisibility : (II)V
      //   333: getstatic android/os/Build$VERSION.SDK_INT : I
      //   336: bipush #21
      //   338: if_icmplt -> 412
      //   341: aload #8
      //   343: getstatic androidx/core/R$dimen.notification_large_icon_width : I
      //   346: invokevirtual getDimensionPixelSize : (I)I
      //   349: istore_2
      //   350: aload #8
      //   352: getstatic androidx/core/R$dimen.notification_big_circle_margin : I
      //   355: invokevirtual getDimensionPixelSize : (I)I
      //   358: istore #5
      //   360: aload #8
      //   362: getstatic androidx/core/R$dimen.notification_small_icon_size_as_large : I
      //   365: invokevirtual getDimensionPixelSize : (I)I
      //   368: istore #6
      //   370: aload_0
      //   371: aload_0
      //   372: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   375: getfield O : Landroid/app/Notification;
      //   378: getfield icon : I
      //   381: iload_2
      //   382: iload #5
      //   384: isub
      //   385: iload #6
      //   387: aload_0
      //   388: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   391: invokevirtual getColor : ()I
      //   394: invokespecial a : (IIII)Landroid/graphics/Bitmap;
      //   397: astore #10
      //   399: aload #9
      //   401: getstatic androidx/core/R$id.icon : I
      //   404: aload #10
      //   406: invokevirtual setImageViewBitmap : (ILandroid/graphics/Bitmap;)V
      //   409: goto -> 435
      //   412: aload #9
      //   414: getstatic androidx/core/R$id.icon : I
      //   417: aload_0
      //   418: aload_0
      //   419: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   422: getfield O : Landroid/app/Notification;
      //   425: getfield icon : I
      //   428: iconst_m1
      //   429: invokevirtual createColoredBitmap : (II)Landroid/graphics/Bitmap;
      //   432: invokevirtual setImageViewBitmap : (ILandroid/graphics/Bitmap;)V
      //   435: aload_0
      //   436: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   439: getfield b : Ljava/lang/CharSequence;
      //   442: ifnull -> 460
      //   445: aload #9
      //   447: getstatic androidx/core/R$id.title : I
      //   450: aload_0
      //   451: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   454: getfield b : Ljava/lang/CharSequence;
      //   457: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   460: aload_0
      //   461: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   464: getfield c : Ljava/lang/CharSequence;
      //   467: ifnull -> 491
      //   470: aload #9
      //   472: getstatic androidx/core/R$id.text : I
      //   475: aload_0
      //   476: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   479: getfield c : Ljava/lang/CharSequence;
      //   482: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   485: iconst_1
      //   486: istore #5
      //   488: goto -> 494
      //   491: iconst_0
      //   492: istore #5
      //   494: getstatic android/os/Build$VERSION.SDK_INT : I
      //   497: bipush #21
      //   499: if_icmpge -> 517
      //   502: aload_0
      //   503: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   506: getfield g : Landroid/graphics/Bitmap;
      //   509: ifnull -> 517
      //   512: iconst_1
      //   513: istore_2
      //   514: goto -> 519
      //   517: iconst_0
      //   518: istore_2
      //   519: aload_0
      //   520: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   523: getfield h : Ljava/lang/CharSequence;
      //   526: ifnull -> 561
      //   529: aload #9
      //   531: getstatic androidx/core/R$id.info : I
      //   534: aload_0
      //   535: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   538: getfield h : Ljava/lang/CharSequence;
      //   541: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   544: aload #9
      //   546: getstatic androidx/core/R$id.info : I
      //   549: iconst_0
      //   550: invokevirtual setViewVisibility : (II)V
      //   553: iconst_1
      //   554: istore #5
      //   556: iconst_1
      //   557: istore_2
      //   558: goto -> 658
      //   561: aload_0
      //   562: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   565: getfield i : I
      //   568: ifle -> 648
      //   571: aload #8
      //   573: getstatic androidx/core/R$integer.status_bar_notification_info_maxnum : I
      //   576: invokevirtual getInteger : (I)I
      //   579: istore_2
      //   580: aload_0
      //   581: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   584: getfield i : I
      //   587: iload_2
      //   588: if_icmple -> 610
      //   591: aload #9
      //   593: getstatic androidx/core/R$id.info : I
      //   596: aload #8
      //   598: getstatic androidx/core/R$string.status_bar_notification_info_overflow : I
      //   601: invokevirtual getString : (I)Ljava/lang/String;
      //   604: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   607: goto -> 636
      //   610: invokestatic getIntegerInstance : ()Ljava/text/NumberFormat;
      //   613: astore #10
      //   615: aload #9
      //   617: getstatic androidx/core/R$id.info : I
      //   620: aload #10
      //   622: aload_0
      //   623: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   626: getfield i : I
      //   629: i2l
      //   630: invokevirtual format : (J)Ljava/lang/String;
      //   633: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   636: aload #9
      //   638: getstatic androidx/core/R$id.info : I
      //   641: iconst_0
      //   642: invokevirtual setViewVisibility : (II)V
      //   645: goto -> 553
      //   648: aload #9
      //   650: getstatic androidx/core/R$id.info : I
      //   653: bipush #8
      //   655: invokevirtual setViewVisibility : (II)V
      //   658: aload_0
      //   659: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   662: getfield o : Ljava/lang/CharSequence;
      //   665: ifnull -> 741
      //   668: getstatic android/os/Build$VERSION.SDK_INT : I
      //   671: bipush #16
      //   673: if_icmplt -> 741
      //   676: aload #9
      //   678: getstatic androidx/core/R$id.text : I
      //   681: aload_0
      //   682: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   685: getfield o : Ljava/lang/CharSequence;
      //   688: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   691: aload_0
      //   692: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   695: getfield c : Ljava/lang/CharSequence;
      //   698: ifnull -> 731
      //   701: aload #9
      //   703: getstatic androidx/core/R$id.text2 : I
      //   706: aload_0
      //   707: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   710: getfield c : Ljava/lang/CharSequence;
      //   713: invokevirtual setTextViewText : (ILjava/lang/CharSequence;)V
      //   716: aload #9
      //   718: getstatic androidx/core/R$id.text2 : I
      //   721: iconst_0
      //   722: invokevirtual setViewVisibility : (II)V
      //   725: iconst_1
      //   726: istore #6
      //   728: goto -> 744
      //   731: aload #9
      //   733: getstatic androidx/core/R$id.text2 : I
      //   736: bipush #8
      //   738: invokevirtual setViewVisibility : (II)V
      //   741: iconst_0
      //   742: istore #6
      //   744: iload #6
      //   746: ifeq -> 795
      //   749: getstatic android/os/Build$VERSION.SDK_INT : I
      //   752: bipush #16
      //   754: if_icmplt -> 795
      //   757: iload_3
      //   758: ifeq -> 783
      //   761: aload #8
      //   763: getstatic androidx/core/R$dimen.notification_subtext_size : I
      //   766: invokevirtual getDimensionPixelSize : (I)I
      //   769: i2f
      //   770: fstore #4
      //   772: aload #9
      //   774: getstatic androidx/core/R$id.text : I
      //   777: iconst_0
      //   778: fload #4
      //   780: invokevirtual setTextViewTextSize : (IIF)V
      //   783: aload #9
      //   785: getstatic androidx/core/R$id.line1 : I
      //   788: iconst_0
      //   789: iconst_0
      //   790: iconst_0
      //   791: iconst_0
      //   792: invokevirtual setViewPadding : (IIIII)V
      //   795: aload_0
      //   796: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   799: invokevirtual getWhenIfShowing : ()J
      //   802: lconst_0
      //   803: lcmp
      //   804: ifeq -> 937
      //   807: aload_0
      //   808: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   811: getfield l : Z
      //   814: ifeq -> 908
      //   817: getstatic android/os/Build$VERSION.SDK_INT : I
      //   820: bipush #16
      //   822: if_icmplt -> 908
      //   825: aload #9
      //   827: getstatic androidx/core/R$id.chronometer : I
      //   830: iconst_0
      //   831: invokevirtual setViewVisibility : (II)V
      //   834: aload #9
      //   836: getstatic androidx/core/R$id.chronometer : I
      //   839: ldc_w 'setBase'
      //   842: aload_0
      //   843: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   846: invokevirtual getWhenIfShowing : ()J
      //   849: invokestatic elapsedRealtime : ()J
      //   852: invokestatic currentTimeMillis : ()J
      //   855: lsub
      //   856: ladd
      //   857: invokevirtual setLong : (ILjava/lang/String;J)V
      //   860: aload #9
      //   862: getstatic androidx/core/R$id.chronometer : I
      //   865: ldc_w 'setStarted'
      //   868: iconst_1
      //   869: invokevirtual setBoolean : (ILjava/lang/String;Z)V
      //   872: aload_0
      //   873: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   876: getfield m : Z
      //   879: ifeq -> 935
      //   882: getstatic android/os/Build$VERSION.SDK_INT : I
      //   885: bipush #24
      //   887: if_icmplt -> 935
      //   890: aload #9
      //   892: getstatic androidx/core/R$id.chronometer : I
      //   895: aload_0
      //   896: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   899: getfield m : Z
      //   902: invokevirtual setChronometerCountDown : (IZ)V
      //   905: goto -> 935
      //   908: aload #9
      //   910: getstatic androidx/core/R$id.time : I
      //   913: iconst_0
      //   914: invokevirtual setViewVisibility : (II)V
      //   917: aload #9
      //   919: getstatic androidx/core/R$id.time : I
      //   922: ldc_w 'setTime'
      //   925: aload_0
      //   926: getfield a : Landroidx/core/app/NotificationCompat$Builder;
      //   929: invokevirtual getWhenIfShowing : ()J
      //   932: invokevirtual setLong : (ILjava/lang/String;J)V
      //   935: iconst_1
      //   936: istore_2
      //   937: getstatic androidx/core/R$id.right_side : I
      //   940: istore #6
      //   942: iload_2
      //   943: ifeq -> 951
      //   946: iconst_0
      //   947: istore_2
      //   948: goto -> 954
      //   951: bipush #8
      //   953: istore_2
      //   954: aload #9
      //   956: iload #6
      //   958: iload_2
      //   959: invokevirtual setViewVisibility : (II)V
      //   962: getstatic androidx/core/R$id.line3 : I
      //   965: istore #6
      //   967: iload #5
      //   969: ifeq -> 978
      //   972: iload #7
      //   974: istore_2
      //   975: goto -> 981
      //   978: bipush #8
      //   980: istore_2
      //   981: aload #9
      //   983: iload #6
      //   985: iload_2
      //   986: invokevirtual setViewVisibility : (II)V
      //   989: aload #9
      //   991: areturn
    }
    
    public Notification build() {
      NotificationCompat.Builder builder = this.a;
      return (builder != null) ? builder.build() : null;
    }
    
    public void buildIntoRemoteViews(RemoteViews param1RemoteViews1, RemoteViews param1RemoteViews2) {
      a(param1RemoteViews1);
      param1RemoteViews1.removeAllViews(R.id.notification_main_column);
      param1RemoteViews1.addView(R.id.notification_main_column, param1RemoteViews2.clone());
      param1RemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21)
        param1RemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, a(), 0, 0); 
    }
    
    public Bitmap createColoredBitmap(int param1Int1, int param1Int2) {
      return a(param1Int1, param1Int2, 0);
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor param1NotificationBuilderWithBuilderAccessor) {
      return null;
    }
    
    public void setBuilder(NotificationCompat.Builder param1Builder) {
      if (this.a != param1Builder) {
        this.a = param1Builder;
        param1Builder = this.a;
        if (param1Builder != null)
          param1Builder.setStyle(this); 
      } 
    }
  }
  
  public static final class WearableExtender implements Extender {
    @Deprecated
    public static final int SCREEN_TIMEOUT_LONG = -1;
    
    @Deprecated
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    
    @Deprecated
    public static final int SIZE_DEFAULT = 0;
    
    @Deprecated
    public static final int SIZE_FULL_SCREEN = 5;
    
    @Deprecated
    public static final int SIZE_LARGE = 4;
    
    @Deprecated
    public static final int SIZE_MEDIUM = 3;
    
    @Deprecated
    public static final int SIZE_SMALL = 2;
    
    @Deprecated
    public static final int SIZE_XSMALL = 1;
    
    public static final int UNSET_ACTION_INDEX = -1;
    
    private ArrayList<NotificationCompat.Action> a = new ArrayList<NotificationCompat.Action>();
    
    private int b = 1;
    
    private PendingIntent c;
    
    private ArrayList<Notification> d = new ArrayList<Notification>();
    
    private Bitmap e;
    
    private int f;
    
    private int g = 8388613;
    
    private int h = -1;
    
    private int i = 0;
    
    private int j;
    
    private int k = 80;
    
    private int l;
    
    private String m;
    
    private String n;
    
    public WearableExtender() {}
    
    public WearableExtender(Notification param1Notification) {
      Bundle bundle = NotificationCompat.getExtras(param1Notification);
      if (bundle != null) {
        bundle = bundle.getBundle("android.wearable.EXTENSIONS");
      } else {
        bundle = null;
      } 
      if (bundle != null) {
        ArrayList<Notification.Action> arrayList = bundle.getParcelableArrayList("actions");
        if (Build.VERSION.SDK_INT >= 16 && arrayList != null) {
          NotificationCompat.Action[] arrayOfAction = new NotificationCompat.Action[arrayList.size()];
          for (int i = 0; i < arrayOfAction.length; i++) {
            if (Build.VERSION.SDK_INT >= 20) {
              arrayOfAction[i] = NotificationCompat.a(arrayList.get(i));
            } else if (Build.VERSION.SDK_INT >= 16) {
              arrayOfAction[i] = NotificationCompatJellybean.a((Bundle)arrayList.get(i));
            } 
          } 
          Collections.addAll(this.a, arrayOfAction);
        } 
        this.b = bundle.getInt("flags", 1);
        this.c = (PendingIntent)bundle.getParcelable("displayIntent");
        Notification[] arrayOfNotification = NotificationCompat.a(bundle, "pages");
        if (arrayOfNotification != null)
          Collections.addAll(this.d, arrayOfNotification); 
        this.e = (Bitmap)bundle.getParcelable("background");
        this.f = bundle.getInt("contentIcon");
        this.g = bundle.getInt("contentIconGravity", 8388613);
        this.h = bundle.getInt("contentActionIndex", -1);
        this.i = bundle.getInt("customSizePreset", 0);
        this.j = bundle.getInt("customContentHeight");
        this.k = bundle.getInt("gravity", 80);
        this.l = bundle.getInt("hintScreenTimeout");
        this.m = bundle.getString("dismissalId");
        this.n = bundle.getString("bridgeTag");
      } 
    }
    
    private static Notification.Action a(NotificationCompat.Action param1Action) {
      Notification.Action.Builder builder;
      Bundle bundle;
      if (Build.VERSION.SDK_INT >= 23) {
        Icon icon;
        IconCompat iconCompat = param1Action.getIconCompat();
        if (iconCompat == null) {
          iconCompat = null;
        } else {
          icon = iconCompat.toIcon();
        } 
        builder = new Notification.Action.Builder(icon, param1Action.getTitle(), param1Action.getActionIntent());
      } else {
        builder = new Notification.Action.Builder(param1Action.getIcon(), param1Action.getTitle(), param1Action.getActionIntent());
      } 
      if (param1Action.getExtras() != null) {
        bundle = new Bundle(param1Action.getExtras());
      } else {
        bundle = new Bundle();
      } 
      bundle.putBoolean("android.support.allowGeneratedReplies", param1Action.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24)
        builder.setAllowGeneratedReplies(param1Action.getAllowGeneratedReplies()); 
      builder.addExtras(bundle);
      RemoteInput[] arrayOfRemoteInput = param1Action.getRemoteInputs();
      if (arrayOfRemoteInput != null) {
        RemoteInput[] arrayOfRemoteInput1 = RemoteInput.a(arrayOfRemoteInput);
        int j = arrayOfRemoteInput1.length;
        for (int i = 0; i < j; i++)
          builder.addRemoteInput(arrayOfRemoteInput1[i]); 
      } 
      return builder.build();
    }
    
    private void a(int param1Int, boolean param1Boolean) {
      if (param1Boolean) {
        this.b = param1Int | this.b;
        return;
      } 
      this.b = param1Int & this.b;
    }
    
    public WearableExtender addAction(NotificationCompat.Action param1Action) {
      this.a.add(param1Action);
      return this;
    }
    
    public WearableExtender addActions(List<NotificationCompat.Action> param1List) {
      this.a.addAll(param1List);
      return this;
    }
    
    @Deprecated
    public WearableExtender addPage(Notification param1Notification) {
      this.d.add(param1Notification);
      return this;
    }
    
    @Deprecated
    public WearableExtender addPages(List<Notification> param1List) {
      this.d.addAll(param1List);
      return this;
    }
    
    public WearableExtender clearActions() {
      this.a.clear();
      return this;
    }
    
    @Deprecated
    public WearableExtender clearPages() {
      this.d.clear();
      return this;
    }
    
    public WearableExtender clone() {
      WearableExtender wearableExtender = new WearableExtender();
      wearableExtender.a = new ArrayList<NotificationCompat.Action>(this.a);
      wearableExtender.b = this.b;
      wearableExtender.c = this.c;
      wearableExtender.d = new ArrayList<Notification>(this.d);
      wearableExtender.e = this.e;
      wearableExtender.f = this.f;
      wearableExtender.g = this.g;
      wearableExtender.h = this.h;
      wearableExtender.i = this.i;
      wearableExtender.j = this.j;
      wearableExtender.k = this.k;
      wearableExtender.l = this.l;
      wearableExtender.m = this.m;
      wearableExtender.n = this.n;
      return wearableExtender;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder param1Builder) {
      Bundle bundle = new Bundle();
      if (!this.a.isEmpty())
        if (Build.VERSION.SDK_INT >= 16) {
          ArrayList<Notification.Action> arrayList = new ArrayList(this.a.size());
          for (NotificationCompat.Action action : this.a) {
            if (Build.VERSION.SDK_INT >= 20) {
              arrayList.add(a(action));
              continue;
            } 
            if (Build.VERSION.SDK_INT >= 16)
              arrayList.add(NotificationCompatJellybean.a(action)); 
          } 
          bundle.putParcelableArrayList("actions", arrayList);
        } else {
          bundle.putParcelableArrayList("actions", null);
        }  
      int i = this.b;
      if (i != 1)
        bundle.putInt("flags", i); 
      PendingIntent pendingIntent = this.c;
      if (pendingIntent != null)
        bundle.putParcelable("displayIntent", (Parcelable)pendingIntent); 
      if (!this.d.isEmpty()) {
        ArrayList<Notification> arrayList = this.d;
        bundle.putParcelableArray("pages", (Parcelable[])arrayList.toArray((Object[])new Notification[arrayList.size()]));
      } 
      Bitmap bitmap = this.e;
      if (bitmap != null)
        bundle.putParcelable("background", (Parcelable)bitmap); 
      i = this.f;
      if (i != 0)
        bundle.putInt("contentIcon", i); 
      i = this.g;
      if (i != 8388613)
        bundle.putInt("contentIconGravity", i); 
      i = this.h;
      if (i != -1)
        bundle.putInt("contentActionIndex", i); 
      i = this.i;
      if (i != 0)
        bundle.putInt("customSizePreset", i); 
      i = this.j;
      if (i != 0)
        bundle.putInt("customContentHeight", i); 
      i = this.k;
      if (i != 80)
        bundle.putInt("gravity", i); 
      i = this.l;
      if (i != 0)
        bundle.putInt("hintScreenTimeout", i); 
      String str = this.m;
      if (str != null)
        bundle.putString("dismissalId", str); 
      str = this.n;
      if (str != null)
        bundle.putString("bridgeTag", str); 
      param1Builder.getExtras().putBundle("android.wearable.EXTENSIONS", bundle);
      return param1Builder;
    }
    
    public List<NotificationCompat.Action> getActions() {
      return this.a;
    }
    
    @Deprecated
    public Bitmap getBackground() {
      return this.e;
    }
    
    public String getBridgeTag() {
      return this.n;
    }
    
    public int getContentAction() {
      return this.h;
    }
    
    @Deprecated
    public int getContentIcon() {
      return this.f;
    }
    
    @Deprecated
    public int getContentIconGravity() {
      return this.g;
    }
    
    public boolean getContentIntentAvailableOffline() {
      return ((this.b & 0x1) != 0);
    }
    
    @Deprecated
    public int getCustomContentHeight() {
      return this.j;
    }
    
    @Deprecated
    public int getCustomSizePreset() {
      return this.i;
    }
    
    public String getDismissalId() {
      return this.m;
    }
    
    @Deprecated
    public PendingIntent getDisplayIntent() {
      return this.c;
    }
    
    @Deprecated
    public int getGravity() {
      return this.k;
    }
    
    @Deprecated
    public boolean getHintAmbientBigPicture() {
      return ((this.b & 0x20) != 0);
    }
    
    @Deprecated
    public boolean getHintAvoidBackgroundClipping() {
      return ((this.b & 0x10) != 0);
    }
    
    public boolean getHintContentIntentLaunchesActivity() {
      return ((this.b & 0x40) != 0);
    }
    
    @Deprecated
    public boolean getHintHideIcon() {
      return ((this.b & 0x2) != 0);
    }
    
    @Deprecated
    public int getHintScreenTimeout() {
      return this.l;
    }
    
    @Deprecated
    public boolean getHintShowBackgroundOnly() {
      return ((this.b & 0x4) != 0);
    }
    
    @Deprecated
    public List<Notification> getPages() {
      return this.d;
    }
    
    public boolean getStartScrollBottom() {
      return ((this.b & 0x8) != 0);
    }
    
    @Deprecated
    public WearableExtender setBackground(Bitmap param1Bitmap) {
      this.e = param1Bitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String param1String) {
      this.n = param1String;
      return this;
    }
    
    public WearableExtender setContentAction(int param1Int) {
      this.h = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIcon(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setContentIconGravity(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean param1Boolean) {
      a(1, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomContentHeight(int param1Int) {
      this.j = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setCustomSizePreset(int param1Int) {
      this.i = param1Int;
      return this;
    }
    
    public WearableExtender setDismissalId(String param1String) {
      this.m = param1String;
      return this;
    }
    
    @Deprecated
    public WearableExtender setDisplayIntent(PendingIntent param1PendingIntent) {
      this.c = param1PendingIntent;
      return this;
    }
    
    @Deprecated
    public WearableExtender setGravity(int param1Int) {
      this.k = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintAmbientBigPicture(boolean param1Boolean) {
      a(32, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintAvoidBackgroundClipping(boolean param1Boolean) {
      a(16, param1Boolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean param1Boolean) {
      a(64, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintHideIcon(boolean param1Boolean) {
      a(2, param1Boolean);
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintScreenTimeout(int param1Int) {
      this.l = param1Int;
      return this;
    }
    
    @Deprecated
    public WearableExtender setHintShowBackgroundOnly(boolean param1Boolean) {
      a(4, param1Boolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean param1Boolean) {
      a(8, param1Boolean);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\NotificationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */