package com.aoyang.jsontest;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


  private static final String TAG = "ExampleUnitTest";
  String message = "{\"type\": \"candidate\";\"tag\":\"websocket_test_req\"}";

  @Test
  public void addition_isCorrect() {
    Log.d(TAG, message);
  }
}