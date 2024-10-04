/*
 * Copyright 2008 ZXing authors
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

package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author satorux@google.com (Satoru Takabayashi) - creator
 * @author mysen@google.com (Chris Mysen) - ported from C++
 */
public final class QRCodeTestCase extends Assert {

  @Test
  public void test() {
    QRCode qrCode = new QRCode();

    // First, test simple setters and getters.
    // We use numbers of version 7-H.
    qrCode.setMode(Mode.BYTE);
    qrCode.setECLevel(ErrorCorrectionLevel.H);
    qrCode.setVersion(Version.getVersionForNumber(7));
    qrCode.setMaskPattern(3);

    assertSame(Mode.BYTE, qrCode.getMode());
    assertSame(ErrorCorrectionLevel.H, qrCode.getECLevel());
    assertEquals(7, qrCode.getVersion().getVersionNumber());
    assertEquals(3, qrCode.getMaskPattern());

    // Prepare the matrix.
    ByteMatrix matrix = new ByteMatrix(45, 45);
    // Just set bogus zero/one values.
    for (int y = 0; y < 45; ++y) {
      for (int x = 0; x < 45; ++x) {
        matrix.set(x, y, (y + x) % 2);
      }
    }

    // Set the matrix.
    qrCode.setMatrix(matrix);
    assertSame(matrix, qrCode.getMatrix());
  }

  @Test
  public void testToString1() {
    QRCode qrCode = new QRCode();
    String expected =
        "<<\n" +
        " mode: null\n" +
        " ecLevel: null\n" +
        " version: null\n" +
        " maskPattern: -1\n" +
        " matrix: null\n" +
        ">>\n";
    assertEquals(expected, qrCode.toString());
  }

  @Test
  public void testToString2() {
    QRCode qrCode = new QRCode();
    qrCode.setMode(Mode.BYTE);
    qrCode.setECLevel(ErrorCorrectionLevel.H);
    qrCode.setVersion(Version.getVersionForNumber(1));
    qrCode.setMaskPattern(3);
    ByteMatrix matrix = new ByteMatrix(21, 21);
    for (int y = 0; y < 21; ++y) {
      for (int x = 0; x < 21; ++x) {
        matrix.set(x, y, (y + x) % 2);
      }
    }
    qrCode.setMatrix(matrix);
    String expected = "<<\n" +
        " mode: BYTE\n" +
        " ecLevel: H\n" +
        " version: 1\n" +
        " maskPattern: 3\n" +
        " matrix:\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        " 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1\n" +
        " 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0\n" +
        ">>\n";
    assertEquals(expected, qrCode.toString());
  }

  @Test
  public void testIsValidMaskPattern() {
    assertFalse(QRCode.isValidMaskPattern(-1));
    assertTrue(QRCode.isValidMaskPattern(0));
    assertTrue(QRCode.isValidMaskPattern(7));
    assertFalse(QRCode.isValidMaskPattern(8));
  }


  //KItest
  private QRCode qrCode;

  @Before
  public void setUp() {
    qrCode = new QRCode();
  }

  @Test
  public void testQRCodeInitializationTwo() {
    // Beispielwerte für die Parametrisierung
    Mode mode = Mode.BYTE;  // Beispielmodus
    ErrorCorrectionLevel ecLevel = ErrorCorrectionLevel.H;  // Beispiel-Fehlerkorrekturstufe
    Version version = Version.getVersionForNumber(5);
    int maskPattern = 3;
    ByteMatrix matrix = new ByteMatrix(21, 21);

    qrCode.setMode(mode);
    qrCode.setECLevel(ecLevel);
    qrCode.setVersion(version);
    qrCode.setMaskPattern(maskPattern);
    qrCode.setMatrix(matrix);

    assertEquals("Mode not setting correctly", mode, qrCode.getMode());
    assertEquals("Error Correction Level not setting correctly", ecLevel, qrCode.getECLevel());
    assertEquals("Version not setting correctly", version, qrCode.getVersion());
    assertEquals("Mask Pattern not setting correctly", maskPattern, qrCode.getMaskPattern());
    assertEquals("Matrix not setting correctly", matrix, qrCode.getMatrix());
  }

  @Test
  public void testToString1Two() {
    String expected = "<<\n"
      + " mode: null\n"
      + " ecLevel: null\n"
      + " version: null\n"
      + " maskPattern: -1\n"
      + " matrix: null\n"
      + ">>\n";
    assertEquals("QR Code toString does not match expected format", expected, qrCode.toString());
  }

  @Test
  public void testToString2Two() {
    // Vorausgesetzte Beispielparameter
    Mode mode = Mode.BYTE;
    ErrorCorrectionLevel ecLevel = ErrorCorrectionLevel.L;
    Version version = Version.getVersionForNumber(2);
    int maskPattern = 2;
    ByteMatrix matrix = new ByteMatrix(21, 21);

    qrCode.setMode(mode);
    qrCode.setECLevel(ecLevel);
    qrCode.setVersion(version);
    qrCode.setMaskPattern(maskPattern);
    qrCode.setMatrix(matrix);

    String expected = "<<\n"
      + " mode: " + mode + "\n"
      + " ecLevel: " + ecLevel + "\n"
      + " version: " + version + "\n"
      + " maskPattern: " + maskPattern + "\n"
      + " matrix:\n" + matrix.toString()
      + ">>\n";

    assertEquals("QR Code toString does not match the expected output", expected, qrCode.toString());
  }

  @Test
  public void testIsValidMaskPatternTwo() {
    // Test für negative Werte und außerhalb der erlaubten Range
    assertFalse("Expected false for invalid mask pattern: -1", QRCode.isValidMaskPattern(-1));
    assertFalse("Expected false for invalid mask pattern: 8", QRCode.isValidMaskPattern(8));

    // Test für gültige Masken
    for (int i = 0; i < QRCode.NUM_MASK_PATTERNS; i++) {
      assertTrue("Mask pattern " + i + " should be valid", QRCode.isValidMaskPattern(i));
    }
  }

  //Mini:

  @Test
  public void testQRCodeInitializationMini() {
    // Teste die Initialisierung von Parametern und die Abrufbarkeit der Werte
    Mode testMode = Mode.BYTE; // Erstellen Sie ein Beispiel für Mode
    ErrorCorrectionLevel testECLevel = ErrorCorrectionLevel.L; // Beispiel für Fehlerkorrekturstufe
    Version testVersion = Version.getVersionForNumber(1); // Angenommen, Version 1 ist gültig
    int testMaskPattern = 3; // Ein Beispiel für ein gültiges Maskenmuster

    qrCode.setMode(testMode);
    qrCode.setECLevel(testECLevel);
    qrCode.setVersion(testVersion);
    qrCode.setMaskPattern(testMaskPattern);

    ByteMatrix matrix = new ByteMatrix(2, 2);
    matrix.set(0, 0, (byte) 1);
    qrCode.setMatrix(matrix);

    // Überprüfe die Rückgabewerte
    assertEquals(testMode, qrCode.getMode());
    assertEquals(testECLevel, qrCode.getECLevel());
    assertEquals(testVersion, qrCode.getVersion());
    assertEquals(testMaskPattern, qrCode.getMaskPattern());
    assertNotNull(qrCode.getMatrix());
    assertEquals(matrix, qrCode.getMatrix());
  }

  @Test
  public void testToString1Mini() {
    // Teste die toString-Ausgabe eines neu erstellten QR-Codes
    String expectedOutput = "<<\n" +
      " mode: null\n" + // Initialwert ist null
      " ecLevel: null\n" + // Initialwert ist null
      " version: null\n" + // Initialwert ist null
      " maskPattern: -1\n" + // Initialwert ist -1
      " matrix: null\n" + // Initialwert ist null
      ">>\n";
    assertEquals(expectedOutput, qrCode.toString());
  }

//  @Test
//  public void testToString2Mini() {
//    // Beispiel für Parameter
//    Mode testMode = Mode.BYTE; // Beispiel für Mode
//    ErrorCorrectionLevel testECLevel = ErrorCorrectionLevel.L;
//    Version testVersion = Version.getVersionForNumber(1);
//    int testMaskPattern = 3;
//
//    qrCode.setMode(testMode);
//    qrCode.setECLevel(testECLevel);
//    qrCode.setVersion(testVersion);
//    qrCode.setMaskPattern(testMaskPattern);
//
//    ByteMatrix matrix = new ByteMatrix(2, 2);
//    matrix.set(0, 0, (byte) 1);
//
//    // Matrix-Format anpassen, um sicherzustellen, dass die Ausgabe der toString-Methode übereinstimmt
//    qrCode.setMatrix(matrix);
//
//    String expectedOutput = "<<\n" +
//      " mode: " + testMode + "\n" +
//      " ecLevel: " + testECLevel + "\n" +
//      " version: " + testVersion + "\n" +
//      " maskPattern: 3\n" +
//      " matrix:\n" +
//      " 1  \n" + // Ersetzen Sie dies ggf. durch die tatsächliche Ausgabe der ByteMatrix
//      "  \n" +
//      ">>\n";
//
//    assertEquals(expectedOutput, qrCode.toString());
//  }

  @Test
  public void testToString2ThreeMini() {
    // Beispiel für Parameter
    Mode testMode = Mode.BYTE; // Beispiel für Mode
    ErrorCorrectionLevel testECLevel = ErrorCorrectionLevel.L;
    Version testVersion = Version.getVersionForNumber(1);
    int testMaskPattern = 3;

    qrCode.setMode(testMode);
    qrCode.setECLevel(testECLevel);
    qrCode.setVersion(testVersion);
    qrCode.setMaskPattern(testMaskPattern);

    ByteMatrix matrix = new ByteMatrix(2, 2);
    matrix.set(0, 0, (byte) 1);
    matrix.set(1, 0, (byte) 0);
    matrix.set(0, 1, (byte) 0);
    matrix.set(1, 1, (byte) 0);
    qrCode.setMatrix(matrix);

    String expectedOutput = "<<\n" +
      " mode: " + testMode + "\n" +
      " ecLevel: " + testECLevel + "\n" +
      " version: " + testVersion + "\n" +
      " maskPattern: 3\n" +
      " matrix:\n" +
      " 1 0\n" + // Ersetzt durch die korrekten Werte, die in der Matrix gesetzt wurden
      " 0 0\n" +
      ">>\n";

    assertEquals(expectedOutput, qrCode.toString());
  }


  @Test
  public void testIsValidMaskPatternMini() {
    // Teste gültige und ungültige Maskenmuster
    assertTrue(QRCode.isValidMaskPattern(0)); // Gültig
    assertTrue(QRCode.isValidMaskPattern(7)); // Gültig
    assertFalse(QRCode.isValidMaskPattern(-1)); // Ungültig
    assertFalse(QRCode.isValidMaskPattern(8)); // Ungültig
  }


}
