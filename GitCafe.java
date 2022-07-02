package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.IH;
import com.github.catvod.spider.merge.ae;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GitCafe extends Spider {
  private Context AS = null;
  
  private PushAgent Kr;
  
  private JSONObject e;
  
  private List<String> f;
  
  private JSONObject x;
  
  private HashMap<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36");
    return (HashMap)hashMap;
  }
  
  JSONObject AS(String paramString) {
    try {
      File file2 = new File();
      StringBuilder stringBuilder3 = new StringBuilder();
      this();
      stringBuilder3.append(this.AS.getCacheDir());
      stringBuilder3.append("/xzt/");
      this(stringBuilder3.toString());
      if (!file2.exists())
        file2.mkdirs(); 
      File file3 = new File();
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append(this.AS.getCacheDir());
      stringBuilder1.append("/xzt/");
      stringBuilder1.append(paramString);
      stringBuilder1.append(".json.t");
      this(stringBuilder1.toString());
      if (!file3.exists())
        return null; 
      File file1 = new File();
      StringBuilder stringBuilder4 = new StringBuilder();
      this();
      stringBuilder4.append(this.AS.getCacheDir());
      stringBuilder4.append("/xzt/");
      stringBuilder4.append(paramString);
      stringBuilder4.append(".json");
      this(stringBuilder4.toString());
      BufferedReader bufferedReader2 = new BufferedReader();
      InputStreamReader inputStreamReader1 = new InputStreamReader();
      FileInputStream fileInputStream = new FileInputStream();
      this(file3);
      this(fileInputStream, IH.l);
      this(inputStreamReader1);
      if (System.currentTimeMillis() - Long.parseLong(bufferedReader2.readLine().trim()) > 3600000L)
        return null; 
      bufferedReader2.close();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      BufferedReader bufferedReader1 = new BufferedReader();
      InputStreamReader inputStreamReader2 = new InputStreamReader();
      fileInputStream = new FileInputStream();
      this(file1);
      this(fileInputStream, IH.l);
      this(inputStreamReader2);
      while (true) {
        String str = bufferedReader1.readLine();
        if (str != null) {
          stringBuilder2.append(str);
          continue;
        } 
        return new JSONObject(stringBuilder2.toString());
      } 
    } finally {
      paramString = null;
    } 
  }
  
  JSONObject Kr(String paramString) {
    try {
      JSONObject jSONObject = AS(paramString);
      if (jSONObject != null)
        return jSONObject; 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("https://gitcafe.net/alipaper/data/");
      stringBuilder.append(paramString);
      stringBuilder.append(".json?v=");
      stringBuilder.append(System.currentTimeMillis());
      String str = ae.V(stringBuilder.toString(), f());
      e(paramString, str);
      return new JSONObject(str);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public String categoryContent(String paramString1, String paramString2, boolean paramBoolean, HashMap<String, String> paramHashMap) {
    try {
      JSONArray jSONArray2 = Kr(paramString1).getJSONArray("data");
      JSONArray jSONArray1 = new JSONArray();
      this();
      for (byte b = 0; b < jSONArray2.length(); b++) {
        JSONObject jSONObject1 = jSONArray2.getJSONObject(b);
        if (jSONObject1.optString("cat", "").equals(paramString1)) {
          JSONObject jSONObject2 = new JSONObject();
          this();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("https://www.aliyundrive.com/s/");
          stringBuilder.append(jSONObject1.getString("key"));
          jSONObject2.put("vod_id", stringBuilder.toString());
          jSONObject2.put("vod_name", jSONObject1.getString("title"));
          jSONObject2.put("vod_pic", "https://pic.rmb.bdstatic.com/bjh/1d0b02d0f57f0a42201f92caba5107ed.jpeg");
          jSONArray1.put(jSONObject2);
        } 
      } 
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("page", 1);
      jSONObject.put("pagecount", 1);
      jSONObject.put("limit", jSONArray1.length());
      jSONObject.put("total", jSONArray1.length());
      jSONObject.put("list", jSONArray1);
      return jSONObject.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public String detailContent(List<String> paramList) {
    return this.Kr.detailContent(Collections.singletonList(paramList.get(0)));
  }
  
  void e(String paramString1, String paramString2) {
    try {
      File file = new File();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append(this.AS.getCacheDir());
      stringBuilder2.append("/xzt/");
      stringBuilder2.append(paramString1);
      stringBuilder2.append(".json.t");
      this(stringBuilder2.toString());
      FileOutputStream fileOutputStream2 = new FileOutputStream();
      stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append(this.AS.getCacheDir());
      stringBuilder2.append("/xzt/");
      stringBuilder2.append(paramString1);
      stringBuilder2.append(".json");
      this(stringBuilder2.toString());
      fileOutputStream2.write(paramString2.getBytes(IH.l));
      fileOutputStream2.flush();
      fileOutputStream2.close();
      FileOutputStream fileOutputStream1 = new FileOutputStream();
      this(file);
      StringBuilder stringBuilder1 = new StringBuilder();
      this();
      stringBuilder1.append(System.currentTimeMillis());
      stringBuilder1.append("");
      fileOutputStream1.write(stringBuilder1.toString().getBytes(IH.l));
      fileOutputStream1.flush();
      fileOutputStream1.close();
    } finally {}
  }
  
  public JSONObject getAllData() {
    try {
      if (this.e == null) {
        JSONObject jSONObject = new JSONObject();
        this(ae.V("http://81.70.77.5:7800/xztzy/xzt.json", f()));
        this.e = jSONObject;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.e;
  }
  
  public String homeContent(boolean paramBoolean) {
    try {
      JSONArray jSONArray1 = x().getJSONObject("info").getJSONArray("new");
      JSONArray jSONArray2 = new JSONArray();
      this();
      for (String str : this.f) {
        JSONObject jSONObject1 = new JSONObject();
        this();
        jSONObject1.put("type_id", str);
        jSONObject1.put("type_name", this.x.getString(str));
        jSONArray2.put(jSONObject1);
      } 
      JSONArray jSONArray3 = new JSONArray();
      this();
      for (byte b = 0; b < jSONArray1.length(); b++) {
        JSONObject jSONObject1 = jSONArray1.getJSONObject(b);
        if (this.f.contains(jSONObject1.optString("cat", ""))) {
          JSONObject jSONObject2 = new JSONObject();
          this();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("https://www.aliyundrive.com/s/");
          stringBuilder.append(jSONObject1.getString("key"));
          jSONObject2.put("vod_id", stringBuilder.toString());
          jSONObject2.put("vod_name", jSONObject1.getString("title"));
          jSONObject2.put("vod_pic", "https://pic.rmb.bdstatic.com/bjh/1d0b02d0f57f0a42201f92caba5107ed.jpeg");
          jSONObject2.put("vod_remarks", jSONObject1.getString("date"));
          jSONArray3.put(jSONObject2);
        } 
      } 
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("class", jSONArray2);
      jSONObject.put("list", jSONArray3);
      return jSONObject.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  public void init(Context paramContext) {
    super.init(paramContext);
    PushAgent pushAgent = new PushAgent();
    this.Kr = pushAgent;
    pushAgent.init(paramContext);
    try {
      JSONObject jSONObject = new JSONObject();
      this("{\"hyds\":\"华语电视\",\"rhds\":\"日韩电视\",\"omds\":\"欧美电视\",\"qtds\":\"其他电视\",\"hydy\":\"华语电影\",\"rhdy\":\"日韩电影\",\"omdy\":\"欧美电影\",\"qtdy\":\"其他电影\",\"hydm\":\"华语动漫\",\"rhdm\":\"日韩动漫\",\"omdm\":\"欧美动漫\",\"jlp\":\"纪录片\",\"zyp\":\"综艺片\",\"jypx\":\"教育培训\",\"qtsp\":\"其他视频\",\"hyyy\":\"华语音乐\",\"rhyy\":\"日韩音乐\",\"omyy\":\"欧美音乐\",\"qtyy\":\"其他音乐\",\"kfrj\":\"娱乐软件\",\"xtrj\":\"系统软件\",\"wlrj\":\"网络软件\",\"bgrj\":\"办公软件\",\"qtrj\":\"其他软件\",\"mh\":\"漫画\",\"xs\":\"小说\",\"cbs\":\"出版书\",\"zspx\":\"知识培训\",\"qtwd\":\"其他文档\",\"bz\":\"壁纸\",\"rw\":\"人物\",\"fj\":\"风景\",\"qttp\":\"其他图片\",\"qt\":\"其他\"}");
      this.x = jSONObject;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    ArrayList<String> arrayList = new ArrayList();
    this.f = arrayList;
    arrayList.add("hydm");
    this.f.add("hyds");
    this.f.add("hydy");
    this.f.add("omdm");
  }
  
  public String playerContent(String paramString1, String paramString2, List<String> paramList) {
    return this.Kr.playerContent(paramString1, paramString2, paramList);
  }
  
  public String searchContent(String paramString, boolean paramBoolean) {
    try {
      JSONArray jSONArray1 = getAllData().getJSONArray("data");
      JSONArray jSONArray2 = new JSONArray();
      this();
      for (byte b = 0; b < jSONArray1.length(); b++) {
        JSONObject jSONObject1 = jSONArray1.getJSONObject(b);
        if (this.f.contains(jSONObject1.getString("cat"))) {
          String str = jSONObject1.getString("title");
          if (str.contains(paramString)) {
            JSONObject jSONObject2 = new JSONObject();
            this();
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("https://www.aliyundrive.com/s/");
            stringBuilder.append(jSONObject1.getString("key"));
            jSONObject2.put("vod_id", stringBuilder.toString());
            jSONObject2.put("vod_name", str);
            jSONArray2.put(jSONObject2);
          } 
        } 
      } 
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("list", jSONArray2);
      return jSONObject.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
  }
  
  JSONObject x() {
    try {
      JSONObject jSONObject = AS("home");
      if (jSONObject != null)
        return jSONObject; 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("https://gitcafe.net/alipaper/home.json?v=");
      stringBuilder.append(System.currentTimeMillis());
      String str = ae.V(stringBuilder.toString(), f());
      e("home", str);
      return new JSONObject(str);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              C:\Users\Administrator\Desktop\接口\JDGUI\classes.jar!\com\github\catvod\spider\GitCafe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */