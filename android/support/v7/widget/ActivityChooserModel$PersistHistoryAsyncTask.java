package android.support.v7.widget;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

final class ActivityChooserModel$PersistHistoryAsyncTask extends AsyncTask {
  private Void doInBackground(Object... paramVarArgs) {
    List<ActivityChooserModel$HistoricalRecord> list = (List)paramVarArgs[0];
    String str = (String)paramVarArgs[1];
    try {
      FileOutputStream fileOutputStream = ActivityChooserModel.this.mContext.openFileOutput(str, 0);
      XmlSerializer xmlSerializer = Xml.newSerializer();
      try {
        xmlSerializer.setOutput(fileOutputStream, null);
        xmlSerializer.startDocument("UTF-8", Boolean.valueOf(true));
        xmlSerializer.startTag(null, "historical-records");
        int j = list.size();
        for (int i = 0; i < j; i++) {
          ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = list.remove(0);
          xmlSerializer.startTag(null, "historical-record");
          xmlSerializer.attribute(null, "activity", activityChooserModel$HistoricalRecord.activity.flattenToString());
          xmlSerializer.attribute(null, "time", String.valueOf(activityChooserModel$HistoricalRecord.time));
          xmlSerializer.attribute(null, "weight", String.valueOf(activityChooserModel$HistoricalRecord.weight));
          xmlSerializer.endTag(null, "historical-record");
        } 
        xmlSerializer.endTag(null, "historical-records");
        xmlSerializer.endDocument();
        ActivityChooserModel.this.mCanReadHistoricalData = true;
        if (fileOutputStream != null)
          try {
            fileOutputStream.close();
            return null;
          } catch (IOException iOException) {
            return null;
          }  
      } catch (IllegalArgumentException illegalArgumentException) {
        String str1 = ActivityChooserModel.LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder("Error writing historical record file: ");
        stringBuilder.append(ActivityChooserModel.this.mHistoryFileName);
        Log.e(str1, stringBuilder.toString(), illegalArgumentException);
        ActivityChooserModel.this.mCanReadHistoricalData = true;
        if (iOException != null) {
          iOException.close();
          return null;
        } 
      } catch (IllegalStateException illegalStateException) {
        String str1 = ActivityChooserModel.LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder("Error writing historical record file: ");
        stringBuilder.append(ActivityChooserModel.this.mHistoryFileName);
        Log.e(str1, stringBuilder.toString(), illegalStateException);
        ActivityChooserModel.this.mCanReadHistoricalData = true;
        if (iOException != null) {
          iOException.close();
          return null;
        } 
      } catch (IOException iOException1) {
        str = ActivityChooserModel.LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder("Error writing historical record file: ");
        stringBuilder.append(ActivityChooserModel.this.mHistoryFileName);
        Log.e(str, stringBuilder.toString(), iOException1);
        ActivityChooserModel.this.mCanReadHistoricalData = true;
        if (iOException != null) {
          iOException.close();
          return null;
        } 
      } finally {}
      return null;
    } catch (FileNotFoundException fileNotFoundException) {
      String str1 = ActivityChooserModel.LOG_TAG;
      StringBuilder stringBuilder = new StringBuilder("Error writing historical record file: ");
      stringBuilder.append(str);
      Log.e(str1, stringBuilder.toString(), fileNotFoundException);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActivityChooserModel$PersistHistoryAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */