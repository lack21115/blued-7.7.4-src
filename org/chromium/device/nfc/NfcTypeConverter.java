package org.chromium.device.nfc;

import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.os.Build;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Log;
import org.chromium.device.mojom.NfcMessage;
import org.chromium.device.mojom.NfcRecord;

public final class NfcTypeConverter {
  static NfcRecord createURLRecord(Uri paramUri) {
    if (paramUri == null)
      return null; 
    NfcRecord nfcRecord = new NfcRecord((byte)0);
    nfcRecord.recordType = 2;
    nfcRecord.mediaType = "text/plain";
    nfcRecord.data = ApiCompatibilityUtils.getBytesUtf8(paramUri.toString());
    return nfcRecord;
  }
  
  private static String getCharset(NfcRecord paramNfcRecord) {
    if (paramNfcRecord.mediaType.endsWith(";charset=UTF-8"))
      return "UTF-8"; 
    if (paramNfcRecord.mediaType.endsWith(";charset=UTF-16"))
      return "UTF-16LE"; 
    Log.w("NfcTypeConverter", "Unknown charset, defaulting to UTF-8.", new Object[0]);
    return "UTF-8";
  }
  
  public static NdefMessage toNdefMessage(NfcMessage paramNfcMessage) {
    try {
      ArrayList<NdefRecord> arrayList = new ArrayList();
      int i = 0;
      while (i < paramNfcMessage.data.length) {
        NdefRecord ndefRecord;
        NfcRecord nfcRecord = paramNfcMessage.data[i];
        switch (nfcRecord.recordType) {
          case 3:
          case 4:
            ndefRecord = NdefRecord.createMime(nfcRecord.mediaType, nfcRecord.data);
            arrayList.add(ndefRecord);
            i++;
            continue;
          case 2:
            ndefRecord = NdefRecord.createUri(new String(((NfcRecord)ndefRecord).data, getCharset((NfcRecord)ndefRecord)));
            arrayList.add(ndefRecord);
            i++;
            continue;
          case 1:
            if (Build.VERSION.SDK_INT >= 21) {
              ndefRecord = NdefRecord.createTextRecord("en-US", new String(((NfcRecord)ndefRecord).data, getCharset((NfcRecord)ndefRecord)));
            } else {
              ndefRecord = NdefRecord.createMime("text/plain", ((NfcRecord)ndefRecord).data);
            } 
            arrayList.add(ndefRecord);
            i++;
            continue;
          case 0:
            ndefRecord = new NdefRecord((short)0, null, null, null);
            arrayList.add(ndefRecord);
            i++;
            continue;
        } 
        throw new InvalidNfcMessageException();
      } 
      arrayList.add(NdefRecord.createExternal("w3.org", "webnfc", ApiCompatibilityUtils.getBytesUtf8(paramNfcMessage.url)));
      NdefRecord[] arrayOfNdefRecord = new NdefRecord[arrayList.size()];
      arrayList.toArray(arrayOfNdefRecord);
      return new NdefMessage(arrayOfNdefRecord);
    } catch (UnsupportedEncodingException|InvalidNfcMessageException|IllegalArgumentException unsupportedEncodingException) {
      throw new InvalidNfcMessageException();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\nfc\NfcTypeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */