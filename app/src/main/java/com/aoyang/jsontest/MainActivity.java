package com.aoyang.jsontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * json特殊字符和转移符的测试
 */
public class MainActivity extends AppCompatActivity {


  private static final String TAG = "MainActivity";
  String message = "{\"msg\":\"{\\\"type\\\":\\\"candidate\\\",\\\"nanotimestamp\\\":258852186888810}\"} ";
//  String message = "{\\\"type\\\": \\\"candidate\\\";\\\"tag\\\":\\\"websocket_test_req\\\"}";
//  String message = "{\"type\": \"candidate\";\"tag\":\"websocket_test_req\"}";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, message);

    //1
    //通过json.put("msg", JsonObject)的方式，不会对特殊字符添加转义字符
    //通过json.put("msg", String)方式，会对特殊字符进行转义

    //示例一
    try {
      JSONObject json = new JSONObject();
      json.put("cmd", "send");
      json.put("msg", message);
      Log.d(TAG, "json:" + json.toString());
    } catch (JSONException e) {
      Log.d(TAG, "json:" + e.toString());
      //do nothing
    }

    //示例二
    try {
      JSONObject json = new JSONObject();
      json.put("cmd", "send");
      JSONObject js = new JSONObject();
      js.put("type", "typevalue");
      json.put("msg", js);//不会有转义符
      json.put("msg2", js.toString());//会有转义符
      Log.d(TAG, "json:" + json.toString());
    } catch (JSONException e) {
      Log.d(TAG, "json:" + e.toString());
      //do nothing
    }

    //2.通过JSONObject json = new JSONObject(message)解析，不会对特殊字符添加转义符。
    //示例三 :
    try {
      JSONObject json = new JSONObject(message);
      json.put("cmd", "send");
      Log.d(TAG, "json:" + json.toString());
    } catch (JSONException e) {
      Log.d(TAG, "json:" + e.toString());
      //do nothing
    }
  }

//  json:{"cmd":"send","msg":"{\"msg\":\"{\\\"type\\\":\\\"candidate\\\",\\\"nanotimestamp\\\":258852186888810}\"} "}
//  json:{"cmd":"send","msg":{"type":"typevalue"},"msg2":"{\"type\":\"typevalue\"}"}
//  json:{"msg":"{\"type\":\"candidate\",\"nanotimestamp\":258852186888810}","cmd":"send"}

}
