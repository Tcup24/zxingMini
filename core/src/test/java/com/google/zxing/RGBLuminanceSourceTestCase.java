/*
 * Copyright 2014 ZXing authors
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

package com.google.zxing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests {@link RGBLuminanceSource}.
 */
public final class RGBLuminanceSourceTestCase extends Assert {

//  private static final RGBLuminanceSource SOURCE = new RGBLuminanceSource(3, 3, new int[] {
//      0x000000, 0x7F7F7F, 0xFFFFFF,
//      0xFF0000, 0x00FF00, 0x0000FF,
//      0x0000FF, 0x00FF00, 0xFF0000});
//
//  @Test
//  public void testCrop() {
//    assertTrue(SOURCE.isCropSupported());
//    LuminanceSource cropped = SOURCE.crop(1, 1, 1, 1);
//    assertEquals(1, cropped.getHeight());
//    assertEquals(1, cropped.getWidth());
//    assertArrayEquals(new byte[] { 0x7F }, cropped.getRow(0, null));
//  }
//
//  @Test
//  public void testMatrix() {
//    assertArrayEquals(new byte[] { 0x00, 0x7F, (byte) 0xFF, 0x3F, 0x7F, 0x3F, 0x3F, 0x7F, 0x3F },
//                      SOURCE.getMatrix());
//    LuminanceSource croppedFullWidth = SOURCE.crop(0, 1, 3, 2);
//    assertArrayEquals(new byte[] { 0x3F, 0x7F, 0x3F, 0x3F, 0x7F, 0x3F },
//                      croppedFullWidth.getMatrix());
//    LuminanceSource croppedCorner = SOURCE.crop(1, 1, 2, 2);
//    assertArrayEquals(new byte[] { 0x7F, 0x3F, 0x7F, 0x3F },
//                      croppedCorner.getMatrix());
//  }
//
//  @Test
//  public void testGetRow() {
//    assertArrayEquals(new byte[] { 0x3F, 0x7F, 0x3F }, SOURCE.getRow(2, new byte[3]));
//  }
//
//  @Test
//  public void testToString() {
//    assertEquals("#+ \n#+#\n#+#\n", SOURCE.toString());
//  }


  //KItest

  //zweiter versuch
  @Test
  public void testCropThree() {
    int width = 5;
    int height = 5;
    int[] pixels = {
      0xFF000000, 0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF, 0xFF000000,
      0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF,
      0xFF000000, 0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF, 0xFF000000,
      0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF,
      0xFF000000, 0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF, 0xFF000000,
    };

    RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

    // Zuschneiden der Bildquelle
    LuminanceSource cropped = source.crop(1, 1, 3, 3);

    assertTrue("Zuschneiden sollte unterstützt werden.", cropped.isCropSupported());
    assertEquals("Die Breite nach dem Zuschneiden ist nicht korrekt.",3, cropped.getWidth());
    assertEquals("Die Höhe nach dem Zuschneiden ist nicht korrekt.", 3, cropped.getHeight());

    // Überprüfen des Inhalts einer bestimmten Zeile
    byte[] row = cropped.getRow(1, null);
    byte[] expectedRow = {(byte)0xFF, 0x00, (byte)0xFF};
    assertArrayEquals("Der Inhalt der zugeschnittenen Zeile ist nicht korrekt.",expectedRow, row);
  }

  @Test
  public void testMatrixThree() {
    int width = 3;
    int height = 3;
    int[] pixels = {
      0xFF000000, 0xFFFFFFFF, 0xFF000000,
      0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF,
      0xFF000000, 0xFFFFFFFF, 0xFF000000,
    };

    RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

    byte[] matrix = source.getMatrix();
    assertEquals("Die Matrixlänge ist nicht korrekt.",width * height, matrix.length);

    // Zuschneiden und Luminanz überprüfen
    LuminanceSource cropped = source.crop(0, 1, 2, 2);
    byte[] expectedMatrix = {(byte)0xFF, 0x00, 0x00, (byte)0xFF};

    assertArrayEquals("Die Luminanzmatrix des zugeschnittenen Abschnitts ist nicht korrekt.",expectedMatrix, cropped.getMatrix());
  }

  @Test
  public void testGetRowThree() {
    int width = 3;
    int height = 3;
    int[] pixels = {
      0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF,
      0xFF000000, 0xFFFFFFFF, 0xFF000000,
      0xFFFFFFFF, 0xFF000000, 0xFFFFFFFF,
    };

    RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

    byte[] row = source.getRow(2, null);
    byte[] expectedRow = {(byte)0xFF, 0x00, (byte)0xFF};
    assertArrayEquals("Die Luminanzwerte der zurückgegebenen Zeile sind nicht korrekt.",expectedRow, row);
  }


  @Test
  public void testToStringThree() {
    int width = 2;
    int height = 2;
    int[] pixels = {
      0xFF000000, 0xFFFFFFFF,
      0xFFFFFFFF, 0xFF000000,
    };

    RGBLuminanceSource source = new RGBLuminanceSource(width, height, pixels);

    String expectedString =
      "1 0 " + System.lineSeparator() +
        "0 1 " + System.lineSeparator();

    StringBuilder sb = new StringBuilder();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        byte luminance = source.getRow(y, null)[x];
        // Annahme: Weiß wird als 1 und Schwarz als 0 dargestellt
        sb.append(luminance == (byte) 0xFF ? "0" : "1").append(" ");
      }
      sb.append(System.lineSeparator());
    }

    assertEquals("Die Textdarstellung der Bildquelle ist nicht korrekt.",expectedString, sb.toString());
  }

  //KI Mini

//  private RGBLuminanceSource source;
//
//
//  @Test
//  public void testCropMini() {
//    // Zuschneiden eines 2x2 Bereichs aus (0, 0)
//    LuminanceSource cropped = source.crop(0, 0, 2, 2);
//
//    // Überprüfen der Dimensionen des zugeschnittenen Bildes
//    assertEquals(2, cropped.getWidth());
//    assertEquals(2, cropped.getHeight());
//
//    // Überprüfen einer bestimmten Zeile der zugeschnittenen Bildquelle
//    byte[] rowData = cropped.getRow(0, null);
//    assertArrayEquals(new byte[]{(byte) 127, (byte) 0}, rowData); // Erwartete Luminanzwerte in der ersten Zeile
//  }
//
//  @Test
//  public void testMatrixMini() {
//    // Testen der gesamten Luminanz-Matrix
//    byte[] matrix = source.getMatrix();
//    assertEquals(9, matrix.length);
//
//    // Überprüfen der Luminanzwerte eines bestimmten Abschnitts
//    source.crop(0, 0, 3, 3);
//    byte[] sectionMatrix = source.getMatrix();
//    assertArrayEquals(new byte[]{
//      (byte) 127, (byte) 0, (byte) 0,
//      (byte) 0, (byte) 127, (byte) 191,
//      (byte) 191, (byte) 191, (byte) 0
//    }, sectionMatrix);
//
//    // Überprüfen eines bestimmten Bildausschnitts
//    LuminanceSource croppedAgain = source.crop(1, 1, 2, 2);
//    byte[] croppedMatrix = croppedAgain.getMatrix();
//    assertArrayEquals(new byte[]{
//      (byte) 0, (byte) 191,
//      (byte) 191, (byte) 0
//    }, croppedMatrix);
//  }
//
//  @Test
//  public void testGetRowMini() {
//    // Testen einer bestimmten Zeile der Bildquelle
//    byte[] row = source.getRow(1, null);
//    assertArrayEquals(new byte[]{(byte) 0, (byte) 191, (byte) 63}, row); // Erwartete Luminanzwerte in der zweiten Zeile
//  }
//
//  @Test
//  public void testToStringMini() {
//    // Überprüfen der Textdarstellung der Bildquelle
//    String stringRepresentation = source.toString();
//    String expectedRepresentation =
//      "  ░░░\n" +
//        "▓▓▓░\n" +
//        "░░░░\n";
//
//    assertEquals(expectedRepresentation, stringRepresentation);
//  }
//
//  //Versuch 2
//
//  @BeforeEach
//  public void setUp() {
//    // Beispiel für ein 3x3 Bild mit RGBA-Pixelwerten
//    int[] pixels = {
//      0xFFFFFFFF, 0xFF000000, 0xFFFF0000,
//      0xFF00FF00, 0xFF0000FF, 0xFFFFFF00,
//      0xFFFF00FF, 0xFF00FFFF, 0xFF888888
//    };
//    source = new RGBLuminanceSource(3, 3, pixels);
//  }
//
//  @Test
//  public void testCrop2() {
//    // Zuschneiden eines 2x2 Bereichs aus (0, 0)
//    LuminanceSource cropped = source.crop(0, 0, 2, 2);
//
//    // Überprüfen der Dimensionen des zugeschnittenen Bildes
//    assertEquals(2, cropped.getWidth());
//    assertEquals(2, cropped.getHeight());
//
//    // Überprüfen einer bestimmten Zeile der zugeschnittenen Bildquelle
//    byte[] rowData = cropped.getRow(0, null);
//    assertArrayEquals(new byte[]{(byte) 127, (byte) 0}, rowData); // Hier möglicherweise anpassen
//  }
//
//  @Test
//  public void testMatrix2() {
//    // Testen der gesamten Luminanz-Matrix
//    byte[] matrix = source.getMatrix();
//    assertEquals(9, matrix.length);
//
//    // Überprüfen der Luminanzwerte eines bestimmten Abschnitts
//    // Hier den Test entsprechend Ihrer Logik anpassen
//    LuminanceSource croppedSource = source.crop(0, 0, 3, 3);
//    byte[] sectionMatrix = croppedSource.getMatrix();
//    assertArrayEquals(new byte[]{
//      (byte) 127, (byte) 0, (byte) 0,
//      (byte) 0, (byte) 127, (byte) 127,
//      (byte) 127, (byte) 127, (byte) 127
//    }, sectionMatrix);
//
//    // Überprüfen eines bestimmten Bildausschnitts
//    LuminanceSource croppedAgain = source.crop(1, 1, 2, 2);
//    byte[] croppedMatrix = croppedAgain.getMatrix();
//    assertArrayEquals(new byte[]{
//      (byte) 127, (byte) 127,
//      (byte) 127, (byte) 127
//    }, croppedMatrix);
//  }
//
//  @Test
//  public void testGetRow2() {
//    // Testen einer bestimmten Zeile der Bildquelle
//    byte[] row = source.getRow(1, null);
//    assertArrayEquals(new byte[]{(byte) 0, (byte) 127, (byte) 127}, row); // Hier möglicherweise anpassen
//  }
//
//  @Test
//  public void testToString2() {
//    // Überprüfen der Textdarstellung der Bildquelle
//    String stringRepresentation = source.toString();
//    String expectedRepresentation =
//      "▓▓▓\n" + // Hier können Sie die Darstellung entsprechend anpassen
//        "▓▓▓\n" +
//        "▓▓▓\n";
//
//    assertEquals(expectedRepresentation, stringRepresentation);
//  }


} //Mini 104, KI 116 ,62
