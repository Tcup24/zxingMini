/*
 * Copyright 2007 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link WifiParsedResult}.
 *
 * @author Vikram Aggarwal
 */
public final class WifiParsedResultTestCase extends Assert {

//  @Test
//  public void testNoPassword() {
//    doTest("WIFI:S:NoPassword;P:;T:;;", "NoPassword", null, "nopass");
//    doTest("WIFI:S:No Password;P:;T:;;", "No Password", null, "nopass");
//  }
//
//  @Test
//  public void testWep() {
//    doTest("WIFI:S:TenChars;P:0123456789;T:WEP;;", "TenChars", "0123456789", "WEP");
//    doTest("WIFI:S:TenChars;P:abcde56789;T:WEP;;", "TenChars", "abcde56789", "WEP");
//    // Non hex should not fail at this level
//    doTest("WIFI:S:TenChars;P:hellothere;T:WEP;;", "TenChars", "hellothere", "WEP");
//
//    // Escaped semicolons
//    doTest("WIFI:S:Ten\\;\\;Chars;P:0123456789;T:WEP;;", "Ten;;Chars", "0123456789", "WEP");
//    // Escaped colons
//    doTest("WIFI:S:Ten\\:\\:Chars;P:0123456789;T:WEP;;", "Ten::Chars", "0123456789", "WEP");
//
//    // TODO(vikrama) Need a test for SB as well.
//  }
//
//  /**
//   * Put in checks for the length of the password for wep.
//   */
//  @Test
//  public void testWpa() {
//    doTest("WIFI:S:TenChars;P:wow;T:WPA;;", "TenChars", "wow", "WPA");
//    doTest("WIFI:S:TenChars;P:space is silent;T:WPA;;", "TenChars", "space is silent", "WPA");
//    doTest("WIFI:S:TenChars;P:hellothere;T:WEP;;", "TenChars", "hellothere", "WEP");
//
//    // Escaped semicolons
//    doTest("WIFI:S:TenChars;P:hello\\;there;T:WEP;;", "TenChars", "hello;there", "WEP");
//    // Escaped colons
//    doTest("WIFI:S:TenChars;P:hello\\:there;T:WEP;;", "TenChars", "hello:there", "WEP");
//  }
//
//  @Test
//  public void testEscape() {
//    doTest("WIFI:T:WPA;S:test;P:my_password\\\\;;", "test", "my_password\\", "WPA");
//    doTest("WIFI:T:WPA;S:My_WiFi_SSID;P:abc123/;;", "My_WiFi_SSID", "abc123/", "WPA");
//    doTest("WIFI:T:WPA;S:\"foo\\;bar\\\\baz\";;", "\"foo;bar\\baz\"", null, "WPA");
//    doTest("WIFI:T:WPA;S:test;P:\\\"abcd\\\";;", "test", "\"abcd\"", "WPA");
//  }
//
//  /**
//   * Given the string contents for the barcode, check that it matches our expectations
//   */
  private static void doTest(String contents,
                             String ssid,
                             String password,
                             String type) {
    Result fakeResult = new Result(contents, null, null, BarcodeFormat.QR_CODE);
    ParsedResult result = ResultParser.parseResult(fakeResult);

    // Ensure it is a wifi code
    assertSame(ParsedResultType.WIFI, result.getType());
    WifiParsedResult wifiResult = (WifiParsedResult) result;

    assertEquals(ssid, wifiResult.getSsid());
    assertEquals(password, wifiResult.getPassword());
    assertEquals(type, wifiResult.getNetworkEncryption());
  }

  //KItests
  @Test
  public void testNoPasswordTwo() {
    // Test für eine offene WLAN-Konfiguration (kein Passwort)
    String contents = "WIFI:S:ExampleSSID;T:nopass;;";
    String expectedSsid = "ExampleSSID";
    String expectedPassword = null; // Kein Passwort für offene Netzwerke
    String expectedType = "nopass"; // Typ für offene Netzwerke

    doTest(contents, expectedSsid, expectedPassword, expectedType);
  }

  @Test
  public void testWepTwo() {
    // Test für eine WEP-verschlüsselte WLAN-Konfiguration
    String contents = "WIFI:S:ExampleWEPSSID;T:WEP;P:12345abcde;;";
    String expectedSsid = "ExampleWEPSSID";
    String expectedPassword = "12345abcde"; // Beispiel für ein WEP-Passwort
    String expectedType = "WEP";

    doTest(contents, expectedSsid, expectedPassword, expectedType);
  }

  @Test
  public void testWpaTwo() {
    // Test für eine WPA-verschlüsselte WLAN-Konfiguration
    String contents = "WIFI:S:ExampleWPASSID;T:WPA;P:securepassword;;";
    String expectedSsid = "ExampleWPASSID";
    String expectedPassword = "securepassword"; // Beispiel für ein WPA-Passwort
    String expectedType = "WPA";

    doTest(contents, expectedSsid, expectedPassword, expectedType);
  }

  @Test
  public void testEscapeThree() {
    // Teste alternative Konfigurationen, um das Verhalten zu isolieren
    String contents = "WIFI:S:Special\\;SSID\\;;T:WPA;P:pass\\:with\\;special\\;\\;chars\\;;";
    String expectedSsid = "Special;SSID;";
    String expectedPassword = "pass:with;special;;chars;";
    String expectedType = "WPA";

    doTest(contents, expectedSsid, expectedPassword, expectedType);
  }


//Mini
  //versuch 2:
//  @Test
//  public void testOpenWifiNetworkIdentificationThreeMini() {
//    String contents = "WIFI:S:OpenNetwork;"; // Beispiel für ein offenes Netzwerk
//    String ssid = "OpenNetwork";
//    String password = null; // Offenes Netzwerk hat kein Passwort
//    String type = "nopass"; // Angenommener Typ für offenes WLAN
//
//    doTest(contents, ssid, password, type);
//  }
//
//  @Test
//  public void testWEPWifiNetworkRecognitionWithSpecialPasswordThreeMini() {
//    // Beispiel für ein WEP-Netzwerk
//    // Das Passwort enthält ein Semikolon, das escaped wird
//    String contents = "WIFI:S:WEPNetwork;T:WEP;P:pass\\;123;"; // Die Verschlüsselungsart muss hier explizit angegeben werden
//    String ssid = "WEPNetwork";
//    String password = "pass;123";
//    String type = "WEP";
//
//    doTest(contents, ssid, password, type);
//  }
//
//  @Test
//  public void testWPAWifiNetworkRecognitionWithSpecialCharactersThreeMini() {
//    // Beispiel für ein WPA-Netzwerk, mit korrekter Angabe der Verschlüsselung
//    String contents = "WIFI:S:WPAEncryption;T:WPA;P:pass@word\\;*;"; // Korrekte Angabe der Verschlüsselung
//    String ssid = "WPAEncryption";
//    String password = "pass@word;*"; // Erwartetes Passwort
//    String type = "WPA"; // Erwartete Verschlüsselung
//
//    doTest(contents, ssid, password, type);
//  }
//
//  @Test
//  public void testEscapeCharactersInSSIDAndPasswordThreeMini() {
//    // Beispiel mit korrekter Angabe der Verschlüsselung
//    String contents = "WIFI:S:Test\\\\Network;T:WPA;P:example\\\\password;"; // Doppelte Backslashes
//    String ssid = "Test\\Network"; // Erwartete SSID mit einem Backslash
//    String password = "example\\password"; // Erwartetes Passwort mit einem Backslash
//    String type = "WPA"; // Erwartete Verschlüsselung
//
//    doTest(contents, ssid, password, type);
//  }

}//Mini 72,KI 72, 92
