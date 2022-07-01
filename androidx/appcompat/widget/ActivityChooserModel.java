package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ActivityChooserModel extends DataSetObservable {
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  
  static final String a = ActivityChooserModel.class.getSimpleName();
  
  private static final Object e = new Object();
  
  private static final Map<String, ActivityChooserModel> f = new HashMap<String, ActivityChooserModel>();
  
  final Context b;
  
  final String c;
  
  boolean d = true;
  
  private final Object g = new Object();
  
  private final List<ActivityResolveInfo> h = new ArrayList<ActivityResolveInfo>();
  
  private final List<HistoricalRecord> i = new ArrayList<HistoricalRecord>();
  
  private Intent j;
  
  private ActivitySorter k = new DefaultSorter();
  
  private int l = 50;
  
  private boolean m = false;
  
  private boolean n = true;
  
  private boolean o = false;
  
  private OnChooseActivityListener p;
  
  private ActivityChooserModel(Context paramContext, String paramString) {
    this.b = paramContext.getApplicationContext();
    if (!TextUtils.isEmpty(paramString) && !paramString.endsWith(".xml")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(".xml");
      this.c = stringBuilder.toString();
      return;
    } 
    this.c = paramString;
  }
  
  private void a() {
    if (this.m) {
      if (!this.n)
        return; 
      this.n = false;
      if (!TextUtils.isEmpty(this.c))
        (new PersistHistoryAsyncTask(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList<HistoricalRecord>(this.i), this.c }); 
      return;
    } 
    throw new IllegalStateException("No preceding call to #readHistoricalData");
  }
  
  private boolean a(HistoricalRecord paramHistoricalRecord) {
    boolean bool = this.i.add(paramHistoricalRecord);
    if (bool) {
      this.n = true;
      f();
      a();
      c();
      notifyChanged();
    } 
    return bool;
  }
  
  private void b() {
    boolean bool1 = d();
    boolean bool2 = e();
    f();
    if (bool1 | bool2) {
      c();
      notifyChanged();
    } 
  }
  
  private boolean c() {
    if (this.k != null && this.j != null && !this.h.isEmpty() && !this.i.isEmpty()) {
      this.k.sort(this.j, this.h, Collections.unmodifiableList(this.i));
      return true;
    } 
    return false;
  }
  
  private boolean d() {
    boolean bool = this.o;
    int i = 0;
    if (bool && this.j != null) {
      this.o = false;
      this.h.clear();
      List<ResolveInfo> list = this.b.getPackageManager().queryIntentActivities(this.j, 0);
      int j = list.size();
      while (i < j) {
        ResolveInfo resolveInfo = list.get(i);
        this.h.add(new ActivityResolveInfo(resolveInfo));
        i++;
      } 
      return true;
    } 
    return false;
  }
  
  private boolean e() {
    if (this.d && this.n && !TextUtils.isEmpty(this.c)) {
      this.d = false;
      this.m = true;
      g();
      return true;
    } 
    return false;
  }
  
  private void f() {
    int j = this.i.size() - this.l;
    if (j <= 0)
      return; 
    this.n = true;
    for (int i = 0; i < j; i++)
      HistoricalRecord historicalRecord = this.i.remove(0); 
  }
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/content/Context;
    //   4: aload_0
    //   5: getfield c : Ljava/lang/String;
    //   8: invokevirtual openFileInput : (Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic newPullParser : ()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: ldc 'UTF-8'
    //   20: invokeinterface setInput : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_1
    //   29: if_icmpeq -> 47
    //   32: iload_1
    //   33: iconst_2
    //   34: if_icmpeq -> 47
    //   37: aload_3
    //   38: invokeinterface next : ()I
    //   43: istore_1
    //   44: goto -> 27
    //   47: ldc_w 'historical-records'
    //   50: aload_3
    //   51: invokeinterface getName : ()Ljava/lang/String;
    //   56: invokevirtual equals : (Ljava/lang/Object;)Z
    //   59: ifeq -> 189
    //   62: aload_0
    //   63: getfield i : Ljava/util/List;
    //   66: astore #4
    //   68: aload #4
    //   70: invokeinterface clear : ()V
    //   75: aload_3
    //   76: invokeinterface next : ()I
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_1
    //   84: if_icmpne -> 96
    //   87: aload_2
    //   88: ifnull -> 310
    //   91: aload_2
    //   92: invokevirtual close : ()V
    //   95: return
    //   96: iload_1
    //   97: iconst_3
    //   98: if_icmpeq -> 75
    //   101: iload_1
    //   102: iconst_4
    //   103: if_icmpne -> 109
    //   106: goto -> 75
    //   109: ldc_w 'historical-record'
    //   112: aload_3
    //   113: invokeinterface getName : ()Ljava/lang/String;
    //   118: invokevirtual equals : (Ljava/lang/Object;)Z
    //   121: ifeq -> 178
    //   124: aload #4
    //   126: new androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
    //   129: dup
    //   130: aload_3
    //   131: aconst_null
    //   132: ldc_w 'activity'
    //   135: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: aload_3
    //   141: aconst_null
    //   142: ldc_w 'time'
    //   145: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   150: invokestatic parseLong : (Ljava/lang/String;)J
    //   153: aload_3
    //   154: aconst_null
    //   155: ldc_w 'weight'
    //   158: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   163: invokestatic parseFloat : (Ljava/lang/String;)F
    //   166: invokespecial <init> : (Ljava/lang/String;JF)V
    //   169: invokeinterface add : (Ljava/lang/Object;)Z
    //   174: pop
    //   175: goto -> 75
    //   178: new org/xmlpull/v1/XmlPullParserException
    //   181: dup
    //   182: ldc_w 'Share records file not well-formed.'
    //   185: invokespecial <init> : (Ljava/lang/String;)V
    //   188: athrow
    //   189: new org/xmlpull/v1/XmlPullParserException
    //   192: dup
    //   193: ldc_w 'Share records file does not start with historical-records tag.'
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: athrow
    //   200: astore_3
    //   201: goto -> 311
    //   204: astore_3
    //   205: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
    //   208: astore #4
    //   210: new java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore #5
    //   219: aload #5
    //   221: ldc_w 'Error reading historical recrod file: '
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload #5
    //   230: aload_0
    //   231: getfield c : Ljava/lang/String;
    //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload #4
    //   240: aload #5
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: aload_3
    //   246: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   249: pop
    //   250: aload_2
    //   251: ifnull -> 310
    //   254: goto -> 91
    //   257: astore_3
    //   258: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
    //   261: astore #4
    //   263: new java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: astore #5
    //   272: aload #5
    //   274: ldc_w 'Error reading historical recrod file: '
    //   277: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload #5
    //   283: aload_0
    //   284: getfield c : Ljava/lang/String;
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload #4
    //   293: aload #5
    //   295: invokevirtual toString : ()Ljava/lang/String;
    //   298: aload_3
    //   299: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   302: pop
    //   303: aload_2
    //   304: ifnull -> 310
    //   307: goto -> 91
    //   310: return
    //   311: aload_2
    //   312: ifnull -> 319
    //   315: aload_2
    //   316: invokevirtual close : ()V
    //   319: aload_3
    //   320: athrow
    //   321: astore_2
    //   322: return
    //   323: astore_2
    //   324: return
    //   325: astore_2
    //   326: goto -> 319
    // Exception table:
    //   from	to	target	type
    //   0	12	321	java/io/FileNotFoundException
    //   12	25	257	org/xmlpull/v1/XmlPullParserException
    //   12	25	204	java/io/IOException
    //   12	25	200	finally
    //   37	44	257	org/xmlpull/v1/XmlPullParserException
    //   37	44	204	java/io/IOException
    //   37	44	200	finally
    //   47	75	257	org/xmlpull/v1/XmlPullParserException
    //   47	75	204	java/io/IOException
    //   47	75	200	finally
    //   75	82	257	org/xmlpull/v1/XmlPullParserException
    //   75	82	204	java/io/IOException
    //   75	82	200	finally
    //   91	95	323	java/io/IOException
    //   109	175	257	org/xmlpull/v1/XmlPullParserException
    //   109	175	204	java/io/IOException
    //   109	175	200	finally
    //   178	189	257	org/xmlpull/v1/XmlPullParserException
    //   178	189	204	java/io/IOException
    //   178	189	200	finally
    //   189	200	257	org/xmlpull/v1/XmlPullParserException
    //   189	200	204	java/io/IOException
    //   189	200	200	finally
    //   205	250	200	finally
    //   258	303	200	finally
    //   315	319	325	java/io/IOException
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString) {
    synchronized (e) {
      ActivityChooserModel activityChooserModel2 = f.get(paramString);
      ActivityChooserModel activityChooserModel1 = activityChooserModel2;
      if (activityChooserModel2 == null) {
        activityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        f.put(paramString, activityChooserModel1);
      } 
      return activityChooserModel1;
    } 
  }
  
  public Intent chooseActivity(int paramInt) {
    synchronized (this.g) {
      if (this.j == null)
        return null; 
      b();
      ActivityResolveInfo activityResolveInfo = this.h.get(paramInt);
      ComponentName componentName = new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name);
      Intent intent = new Intent(this.j);
      intent.setComponent(componentName);
      if (this.p != null) {
        Intent intent1 = new Intent(intent);
        if (this.p.onChooseActivity(this, intent1))
          return null; 
      } 
      a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0F));
      return intent;
    } 
  }
  
  public ResolveInfo getActivity(int paramInt) {
    synchronized (this.g) {
      b();
      return ((ActivityResolveInfo)this.h.get(paramInt)).resolveInfo;
    } 
  }
  
  public int getActivityCount() {
    synchronized (this.g) {
      b();
      return this.h.size();
    } 
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo) {
    synchronized (this.g) {
      b();
      List<ActivityResolveInfo> list = this.h;
      int j = list.size();
      for (int i = 0;; i++) {
        if (i < j) {
          if (((ActivityResolveInfo)list.get(i)).resolveInfo == paramResolveInfo)
            return i; 
        } else {
          return -1;
        } 
      } 
    } 
  }
  
  public ResolveInfo getDefaultActivity() {
    synchronized (this.g) {
      b();
      if (!this.h.isEmpty())
        return ((ActivityResolveInfo)this.h.get(0)).resolveInfo; 
      return null;
    } 
  }
  
  public int getHistoryMaxSize() {
    synchronized (this.g) {
      return this.l;
    } 
  }
  
  public int getHistorySize() {
    synchronized (this.g) {
      b();
      return this.i.size();
    } 
  }
  
  public Intent getIntent() {
    synchronized (this.g) {
      return this.j;
    } 
  }
  
  public void setActivitySorter(ActivitySorter paramActivitySorter) {
    synchronized (this.g) {
      if (this.k == paramActivitySorter)
        return; 
      this.k = paramActivitySorter;
      if (c())
        notifyChanged(); 
      return;
    } 
  }
  
  public void setDefaultActivity(int paramInt) {
    synchronized (this.g) {
      float f;
      b();
      ActivityResolveInfo activityResolveInfo1 = this.h.get(paramInt);
      ActivityResolveInfo activityResolveInfo2 = this.h.get(0);
      if (activityResolveInfo2 != null) {
        f = activityResolveInfo2.weight - activityResolveInfo1.weight + 5.0F;
      } else {
        f = 1.0F;
      } 
      a(new HistoricalRecord(new ComponentName(activityResolveInfo1.resolveInfo.activityInfo.packageName, activityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
      return;
    } 
  }
  
  public void setHistoryMaxSize(int paramInt) {
    synchronized (this.g) {
      if (this.l == paramInt)
        return; 
      this.l = paramInt;
      f();
      if (c())
        notifyChanged(); 
      return;
    } 
  }
  
  public void setIntent(Intent paramIntent) {
    synchronized (this.g) {
      if (this.j == paramIntent)
        return; 
      this.j = paramIntent;
      this.o = true;
      b();
      return;
    } 
  }
  
  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener) {
    synchronized (this.g) {
      this.p = paramOnChooseActivityListener;
      return;
    } 
  }
  
  public static interface ActivityChooserModelClient {
    void setActivityChooserModel(ActivityChooserModel param1ActivityChooserModel);
  }
  
  public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
    public final ResolveInfo resolveInfo;
    
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo param1ResolveInfo) {
      this.resolveInfo = param1ResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo param1ActivityResolveInfo) {
      return Float.floatToIntBits(param1ActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      return !(Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo)param1Object).weight));
    }
    
    public int hashCode() {
      return Float.floatToIntBits(this.weight) + 31;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append("resolveInfo:");
      stringBuilder.append(this.resolveInfo.toString());
      stringBuilder.append("; weight:");
      stringBuilder.append(new BigDecimal(this.weight));
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public static interface ActivitySorter {
    void sort(Intent param1Intent, List<ActivityChooserModel.ActivityResolveInfo> param1List, List<ActivityChooserModel.HistoricalRecord> param1List1);
  }
  
  static final class DefaultSorter implements ActivitySorter {
    private final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> a = new HashMap<ComponentName, ActivityChooserModel.ActivityResolveInfo>();
    
    public void sort(Intent param1Intent, List<ActivityChooserModel.ActivityResolveInfo> param1List, List<ActivityChooserModel.HistoricalRecord> param1List1) {
      Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> map = this.a;
      map.clear();
      int j = param1List.size();
      int i;
      for (i = 0; i < j; i++) {
        ActivityChooserModel.ActivityResolveInfo activityResolveInfo = param1List.get(i);
        activityResolveInfo.weight = 0.0F;
        map.put(new ComponentName(activityResolveInfo.resolveInfo.activityInfo.packageName, activityResolveInfo.resolveInfo.activityInfo.name), activityResolveInfo);
      } 
      i = param1List1.size() - 1;
      float f;
      for (f = 1.0F; i >= 0; f = f1) {
        ActivityChooserModel.HistoricalRecord historicalRecord = param1List1.get(i);
        ActivityChooserModel.ActivityResolveInfo activityResolveInfo = map.get(historicalRecord.activity);
        float f1 = f;
        if (activityResolveInfo != null) {
          activityResolveInfo.weight += historicalRecord.weight * f;
          f1 = f * 0.95F;
        } 
        i--;
      } 
      Collections.sort(param1List);
    }
  }
  
  public static final class HistoricalRecord {
    public final ComponentName activity;
    
    public final long time;
    
    public final float weight;
    
    public HistoricalRecord(ComponentName param1ComponentName, long param1Long, float param1Float) {
      this.activity = param1ComponentName;
      this.time = param1Long;
      this.weight = param1Float;
    }
    
    public HistoricalRecord(String param1String, long param1Long, float param1Float) {
      this(ComponentName.unflattenFromString(param1String), param1Long, param1Float);
    }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object == null)
        return false; 
      if (getClass() != param1Object.getClass())
        return false; 
      param1Object = param1Object;
      ComponentName componentName = this.activity;
      if (componentName == null) {
        if (((HistoricalRecord)param1Object).activity != null)
          return false; 
      } else if (!componentName.equals(((HistoricalRecord)param1Object).activity)) {
        return false;
      } 
      return (this.time != ((HistoricalRecord)param1Object).time) ? false : (!(Float.floatToIntBits(this.weight) != Float.floatToIntBits(((HistoricalRecord)param1Object).weight)));
    }
    
    public int hashCode() {
      int i;
      ComponentName componentName = this.activity;
      if (componentName == null) {
        i = 0;
      } else {
        i = componentName.hashCode();
      } 
      long l = this.time;
      return ((i + 31) * 31 + (int)(l ^ l >>> 32L)) * 31 + Float.floatToIntBits(this.weight);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append("; activity:");
      stringBuilder.append(this.activity);
      stringBuilder.append("; time:");
      stringBuilder.append(this.time);
      stringBuilder.append("; weight:");
      stringBuilder.append(new BigDecimal(this.weight));
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  public static interface OnChooseActivityListener {
    boolean onChooseActivity(ActivityChooserModel param1ActivityChooserModel, Intent param1Intent);
  }
  
  final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
    PersistHistoryAsyncTask(ActivityChooserModel this$0) {}
    
    public Void doInBackground(Object... param1VarArgs) {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: checkcast java/util/List
      //   6: astore #4
      //   8: aload_1
      //   9: iconst_1
      //   10: aaload
      //   11: checkcast java/lang/String
      //   14: astore #5
      //   16: aload_0
      //   17: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   20: getfield b : Landroid/content/Context;
      //   23: aload #5
      //   25: iconst_0
      //   26: invokevirtual openFileOutput : (Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   29: astore_1
      //   30: invokestatic newSerializer : ()Lorg/xmlpull/v1/XmlSerializer;
      //   33: astore #5
      //   35: aload #5
      //   37: aload_1
      //   38: aconst_null
      //   39: invokeinterface setOutput : (Ljava/io/OutputStream;Ljava/lang/String;)V
      //   44: aload #5
      //   46: ldc 'UTF-8'
      //   48: iconst_1
      //   49: invokestatic valueOf : (Z)Ljava/lang/Boolean;
      //   52: invokeinterface startDocument : (Ljava/lang/String;Ljava/lang/Boolean;)V
      //   57: aload #5
      //   59: aconst_null
      //   60: ldc 'historical-records'
      //   62: invokeinterface startTag : (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   67: pop
      //   68: aload #4
      //   70: invokeinterface size : ()I
      //   75: istore_3
      //   76: iconst_0
      //   77: istore_2
      //   78: iload_2
      //   79: iload_3
      //   80: if_icmpge -> 182
      //   83: aload #4
      //   85: iconst_0
      //   86: invokeinterface remove : (I)Ljava/lang/Object;
      //   91: checkcast androidx/appcompat/widget/ActivityChooserModel$HistoricalRecord
      //   94: astore #6
      //   96: aload #5
      //   98: aconst_null
      //   99: ldc 'historical-record'
      //   101: invokeinterface startTag : (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   106: pop
      //   107: aload #5
      //   109: aconst_null
      //   110: ldc 'activity'
      //   112: aload #6
      //   114: getfield activity : Landroid/content/ComponentName;
      //   117: invokevirtual flattenToString : ()Ljava/lang/String;
      //   120: invokeinterface attribute : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   125: pop
      //   126: aload #5
      //   128: aconst_null
      //   129: ldc 'time'
      //   131: aload #6
      //   133: getfield time : J
      //   136: invokestatic valueOf : (J)Ljava/lang/String;
      //   139: invokeinterface attribute : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   144: pop
      //   145: aload #5
      //   147: aconst_null
      //   148: ldc 'weight'
      //   150: aload #6
      //   152: getfield weight : F
      //   155: invokestatic valueOf : (F)Ljava/lang/String;
      //   158: invokeinterface attribute : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   163: pop
      //   164: aload #5
      //   166: aconst_null
      //   167: ldc 'historical-record'
      //   169: invokeinterface endTag : (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   174: pop
      //   175: iload_2
      //   176: iconst_1
      //   177: iadd
      //   178: istore_2
      //   179: goto -> 78
      //   182: aload #5
      //   184: aconst_null
      //   185: ldc 'historical-records'
      //   187: invokeinterface endTag : (Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
      //   192: pop
      //   193: aload #5
      //   195: invokeinterface endDocument : ()V
      //   200: aload_0
      //   201: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   204: iconst_1
      //   205: putfield d : Z
      //   208: aload_1
      //   209: ifnull -> 418
      //   212: aload_1
      //   213: invokevirtual close : ()V
      //   216: aconst_null
      //   217: areturn
      //   218: astore #4
      //   220: goto -> 420
      //   223: astore #4
      //   225: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
      //   228: astore #5
      //   230: new java/lang/StringBuilder
      //   233: dup
      //   234: invokespecial <init> : ()V
      //   237: astore #6
      //   239: aload #6
      //   241: ldc 'Error writing historical record file: '
      //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   246: pop
      //   247: aload #6
      //   249: aload_0
      //   250: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   253: getfield c : Ljava/lang/String;
      //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: pop
      //   260: aload #5
      //   262: aload #6
      //   264: invokevirtual toString : ()Ljava/lang/String;
      //   267: aload #4
      //   269: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   272: pop
      //   273: aload_0
      //   274: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   277: iconst_1
      //   278: putfield d : Z
      //   281: aload_1
      //   282: ifnull -> 418
      //   285: goto -> 212
      //   288: astore #4
      //   290: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
      //   293: astore #5
      //   295: new java/lang/StringBuilder
      //   298: dup
      //   299: invokespecial <init> : ()V
      //   302: astore #6
      //   304: aload #6
      //   306: ldc 'Error writing historical record file: '
      //   308: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   311: pop
      //   312: aload #6
      //   314: aload_0
      //   315: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   318: getfield c : Ljava/lang/String;
      //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   324: pop
      //   325: aload #5
      //   327: aload #6
      //   329: invokevirtual toString : ()Ljava/lang/String;
      //   332: aload #4
      //   334: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   337: pop
      //   338: aload_0
      //   339: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   342: iconst_1
      //   343: putfield d : Z
      //   346: aload_1
      //   347: ifnull -> 418
      //   350: goto -> 212
      //   353: astore #4
      //   355: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
      //   358: astore #5
      //   360: new java/lang/StringBuilder
      //   363: dup
      //   364: invokespecial <init> : ()V
      //   367: astore #6
      //   369: aload #6
      //   371: ldc 'Error writing historical record file: '
      //   373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   376: pop
      //   377: aload #6
      //   379: aload_0
      //   380: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   383: getfield c : Ljava/lang/String;
      //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   389: pop
      //   390: aload #5
      //   392: aload #6
      //   394: invokevirtual toString : ()Ljava/lang/String;
      //   397: aload #4
      //   399: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   402: pop
      //   403: aload_0
      //   404: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   407: iconst_1
      //   408: putfield d : Z
      //   411: aload_1
      //   412: ifnull -> 418
      //   415: goto -> 212
      //   418: aconst_null
      //   419: areturn
      //   420: aload_0
      //   421: getfield a : Landroidx/appcompat/widget/ActivityChooserModel;
      //   424: iconst_1
      //   425: putfield d : Z
      //   428: aload_1
      //   429: ifnull -> 436
      //   432: aload_1
      //   433: invokevirtual close : ()V
      //   436: aload #4
      //   438: athrow
      //   439: astore_1
      //   440: getstatic androidx/appcompat/widget/ActivityChooserModel.a : Ljava/lang/String;
      //   443: astore #4
      //   445: new java/lang/StringBuilder
      //   448: dup
      //   449: invokespecial <init> : ()V
      //   452: astore #6
      //   454: aload #6
      //   456: ldc 'Error writing historical record file: '
      //   458: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   461: pop
      //   462: aload #6
      //   464: aload #5
      //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   469: pop
      //   470: aload #4
      //   472: aload #6
      //   474: invokevirtual toString : ()Ljava/lang/String;
      //   477: aload_1
      //   478: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   481: pop
      //   482: aconst_null
      //   483: areturn
      //   484: astore_1
      //   485: aconst_null
      //   486: areturn
      //   487: astore_1
      //   488: goto -> 436
      // Exception table:
      //   from	to	target	type
      //   16	30	439	java/io/FileNotFoundException
      //   35	76	353	java/lang/IllegalArgumentException
      //   35	76	288	java/lang/IllegalStateException
      //   35	76	223	java/io/IOException
      //   35	76	218	finally
      //   83	175	353	java/lang/IllegalArgumentException
      //   83	175	288	java/lang/IllegalStateException
      //   83	175	223	java/io/IOException
      //   83	175	218	finally
      //   182	200	353	java/lang/IllegalArgumentException
      //   182	200	288	java/lang/IllegalStateException
      //   182	200	223	java/io/IOException
      //   182	200	218	finally
      //   212	216	484	java/io/IOException
      //   225	273	218	finally
      //   290	338	218	finally
      //   355	403	218	finally
      //   432	436	487	java/io/IOException
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActivityChooserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */