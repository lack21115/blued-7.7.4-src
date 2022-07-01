package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ActivityChooserModel extends DataSetObservable {
  static final String LOG_TAG;
  
  final List mActivities;
  
  private ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy;
  
  private ActivityChooserModel$ActivitySorter mActivitySorter;
  
  boolean mCanReadHistoricalData;
  
  final Context mContext;
  
  private final List mHistoricalRecords;
  
  private boolean mHistoricalRecordsChanged;
  
  final String mHistoryFileName;
  
  private int mHistoryMaxSize;
  
  final Object mInstanceLock;
  
  private Intent mIntent;
  
  private boolean mReadShareHistoryCalled;
  
  private boolean mReloadActivities;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded() {
    int j = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (j <= 0)
      return; 
    this.mHistoricalRecordsChanged = true;
    for (int i = 0; i < j; i++)
      this.mHistoricalRecords.remove(0); 
  }
  
  private void readHistoricalDataImpl() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mContext : Landroid/content/Context;
    //   4: aload_0
    //   5: getfield mHistoryFileName : Ljava/lang/String;
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
    //   47: ldc 'historical-records'
    //   49: aload_3
    //   50: invokeinterface getName : ()Ljava/lang/String;
    //   55: invokevirtual equals : (Ljava/lang/Object;)Z
    //   58: ifeq -> 182
    //   61: aload_0
    //   62: getfield mHistoricalRecords : Ljava/util/List;
    //   65: astore #4
    //   67: aload #4
    //   69: invokeinterface clear : ()V
    //   74: aload_3
    //   75: invokeinterface next : ()I
    //   80: istore_1
    //   81: iload_1
    //   82: iconst_1
    //   83: if_icmpeq -> 171
    //   86: iload_1
    //   87: iconst_3
    //   88: if_icmpeq -> 74
    //   91: iload_1
    //   92: iconst_4
    //   93: if_icmpeq -> 74
    //   96: ldc 'historical-record'
    //   98: aload_3
    //   99: invokeinterface getName : ()Ljava/lang/String;
    //   104: invokevirtual equals : (Ljava/lang/Object;)Z
    //   107: ifeq -> 161
    //   110: aload #4
    //   112: new android/support/v7/widget/ActivityChooserModel$HistoricalRecord
    //   115: dup
    //   116: aload_3
    //   117: aconst_null
    //   118: ldc 'activity'
    //   120: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   125: aload_3
    //   126: aconst_null
    //   127: ldc 'time'
    //   129: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic parseLong : (Ljava/lang/String;)J
    //   137: aload_3
    //   138: aconst_null
    //   139: ldc 'weight'
    //   141: invokeinterface getAttributeValue : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: invokestatic parseFloat : (Ljava/lang/String;)F
    //   149: invokespecial <init> : (Ljava/lang/String;JF)V
    //   152: invokeinterface add : (Ljava/lang/Object;)Z
    //   157: pop
    //   158: goto -> 74
    //   161: new org/xmlpull/v1/XmlPullParserException
    //   164: dup
    //   165: ldc 'Share records file not well-formed.'
    //   167: invokespecial <init> : (Ljava/lang/String;)V
    //   170: athrow
    //   171: aload_2
    //   172: ifnull -> 292
    //   175: aload_2
    //   176: invokevirtual close : ()V
    //   179: return
    //   180: astore_2
    //   181: return
    //   182: new org/xmlpull/v1/XmlPullParserException
    //   185: dup
    //   186: ldc 'Share records file does not start with historical-records tag.'
    //   188: invokespecial <init> : (Ljava/lang/String;)V
    //   191: athrow
    //   192: astore_3
    //   193: goto -> 293
    //   196: astore_3
    //   197: getstatic android/support/v7/widget/ActivityChooserModel.LOG_TAG : Ljava/lang/String;
    //   200: astore #4
    //   202: new java/lang/StringBuilder
    //   205: dup
    //   206: ldc 'Error reading historical recrod file: '
    //   208: invokespecial <init> : (Ljava/lang/String;)V
    //   211: astore #5
    //   213: aload #5
    //   215: aload_0
    //   216: getfield mHistoryFileName : Ljava/lang/String;
    //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload #4
    //   225: aload #5
    //   227: invokevirtual toString : ()Ljava/lang/String;
    //   230: aload_3
    //   231: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   234: pop
    //   235: aload_2
    //   236: ifnull -> 292
    //   239: aload_2
    //   240: invokevirtual close : ()V
    //   243: return
    //   244: astore_3
    //   245: getstatic android/support/v7/widget/ActivityChooserModel.LOG_TAG : Ljava/lang/String;
    //   248: astore #4
    //   250: new java/lang/StringBuilder
    //   253: dup
    //   254: ldc 'Error reading historical recrod file: '
    //   256: invokespecial <init> : (Ljava/lang/String;)V
    //   259: astore #5
    //   261: aload #5
    //   263: aload_0
    //   264: getfield mHistoryFileName : Ljava/lang/String;
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #4
    //   273: aload #5
    //   275: invokevirtual toString : ()Ljava/lang/String;
    //   278: aload_3
    //   279: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   282: pop
    //   283: aload_2
    //   284: ifnull -> 292
    //   287: aload_2
    //   288: invokevirtual close : ()V
    //   291: return
    //   292: return
    //   293: aload_2
    //   294: ifnull -> 305
    //   297: aload_2
    //   298: invokevirtual close : ()V
    //   301: goto -> 305
    //   304: astore_2
    //   305: aload_3
    //   306: athrow
    //   307: astore_2
    //   308: return
    // Exception table:
    //   from	to	target	type
    //   0	12	307	java/io/FileNotFoundException
    //   12	25	244	org/xmlpull/v1/XmlPullParserException
    //   12	25	196	java/io/IOException
    //   12	25	192	finally
    //   37	44	244	org/xmlpull/v1/XmlPullParserException
    //   37	44	196	java/io/IOException
    //   37	44	192	finally
    //   47	74	244	org/xmlpull/v1/XmlPullParserException
    //   47	74	196	java/io/IOException
    //   47	74	192	finally
    //   74	81	244	org/xmlpull/v1/XmlPullParserException
    //   74	81	196	java/io/IOException
    //   74	81	192	finally
    //   96	158	244	org/xmlpull/v1/XmlPullParserException
    //   96	158	196	java/io/IOException
    //   96	158	192	finally
    //   161	171	244	org/xmlpull/v1/XmlPullParserException
    //   161	171	196	java/io/IOException
    //   161	171	192	finally
    //   175	179	180	java/io/IOException
    //   182	192	244	org/xmlpull/v1/XmlPullParserException
    //   182	192	196	java/io/IOException
    //   182	192	192	finally
    //   197	235	192	finally
    //   239	243	180	java/io/IOException
    //   245	283	192	finally
    //   287	291	180	java/io/IOException
    //   297	301	304	java/io/IOException
  }
  
  private boolean sortActivitiesIfNeeded() {
    if (this.mActivitySorter != null && this.mIntent != null && !this.mActivities.isEmpty() && !this.mHistoricalRecords.isEmpty()) {
      Collections.unmodifiableList(this.mHistoricalRecords);
      return true;
    } 
    return false;
  }
  
  final boolean addHistoricalRecord(ActivityChooserModel$HistoricalRecord paramActivityChooserModel$HistoricalRecord) {
    boolean bool = this.mHistoricalRecords.add(paramActivityChooserModel$HistoricalRecord);
    if (bool) {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (this.mReadShareHistoryCalled) {
        if (this.mHistoricalRecordsChanged) {
          this.mHistoricalRecordsChanged = false;
          if (!TextUtils.isEmpty(this.mHistoryFileName))
            (new ActivityChooserModel$PersistHistoryAsyncTask(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(this.mHistoricalRecords), this.mHistoryFileName }); 
        } 
        sortActivitiesIfNeeded();
        notifyChanged();
        return bool;
      } 
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    } 
    return bool;
  }
  
  public final Intent chooseActivity(int paramInt) {
    synchronized (this.mInstanceLock) {
      if (this.mIntent == null)
        return null; 
      ensureConsistentState();
      ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = this.mActivities.get(paramInt);
      ComponentName componentName = new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name);
      Intent intent = new Intent(this.mIntent);
      intent.setComponent(componentName);
      if (this.mActivityChoserModelPolicy != null) {
        new Intent(intent);
        if (this.mActivityChoserModelPolicy.onChooseActivity$63493815())
          return null; 
      } 
      addHistoricalRecord(new ActivityChooserModel$HistoricalRecord(componentName, System.currentTimeMillis(), 1.0F));
      return intent;
    } 
  }
  
  final void ensureConsistentState() {
    boolean bool1;
    boolean bool = this.mReloadActivities;
    boolean bool2 = true;
    if (bool && this.mIntent != null) {
      this.mReloadActivities = false;
      this.mActivities.clear();
      List<ResolveInfo> list = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int i = list.size();
      for (bool1 = false; bool1 < i; bool1++) {
        ResolveInfo resolveInfo = list.get(bool1);
        this.mActivities.add(new ActivityChooserModel$ActivityResolveInfo(resolveInfo));
      } 
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (this.mCanReadHistoricalData && this.mHistoricalRecordsChanged && !TextUtils.isEmpty(this.mHistoryFileName)) {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
    } else {
      bool2 = false;
    } 
    pruneExcessiveHistoricalRecordsIfNeeded();
    if ((bool1 | bool2) != 0) {
      sortActivitiesIfNeeded();
      notifyChanged();
    } 
  }
  
  public final ResolveInfo getActivity(int paramInt) {
    synchronized (this.mInstanceLock) {
      ensureConsistentState();
      return ((ActivityChooserModel$ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
    } 
  }
  
  public final int getActivityCount() {
    synchronized (this.mInstanceLock) {
      ensureConsistentState();
      return this.mActivities.size();
    } 
  }
  
  public final int getActivityIndex(ResolveInfo paramResolveInfo) {
    synchronized (this.mInstanceLock) {
      ensureConsistentState();
      List list = this.mActivities;
      int j = list.size();
      for (int i = 0;; i++) {
        if (i < j) {
          if (((ActivityChooserModel$ActivityResolveInfo)list.get(i)).resolveInfo == paramResolveInfo)
            return i; 
        } else {
          return -1;
        } 
      } 
    } 
  }
  
  public final ResolveInfo getDefaultActivity() {
    synchronized (this.mInstanceLock) {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
        return ((ActivityChooserModel$ActivityResolveInfo)this.mActivities.get(0)).resolveInfo; 
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */