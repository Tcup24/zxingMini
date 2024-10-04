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
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link PlanarYUVLuminanceSource}.
 */
public final class PlanarYUVLuminanceSourceTestCase extends Assert {

  private static final byte[] YUV = {
      0,  1,  1,  2,  3,  5,
      8, 13, 21, 34, 55, 89,
      0,  -1,  -1,  -2,  -3,  -5,
      -8, -13, -21, -34, -55, -89,
      127, 127, 127, 127, 127, 127,
      127, 127, 127, 127, 127, 127,
  };
  private static final int COLS = 6;
  private static final int ROWS = 4;
  private static final byte[] Y = new byte[COLS * ROWS];
  static {
    System.arraycopy(YUV, 0, Y, 0, Y.length);
  }

  @Test
  public void testNoCrop() {
    PlanarYUVLuminanceSource source =
        new PlanarYUVLuminanceSource(YUV, COLS, ROWS, 0, 0, COLS, ROWS, false);
    assertEquals(Y, 0, source.getMatrix(), 0, Y.length);
    for (int r = 0; r < ROWS; r++) {
      assertEquals(Y, r * COLS, source.getRow(r, null), 0, COLS);
    }
  }

  @Test
  public void testCrop() {
    PlanarYUVLuminanceSource source =
        new PlanarYUVLuminanceSource(YUV, COLS, ROWS, 1, 1, COLS - 2, ROWS - 2, false);
    assertTrue(source.isCropSupported());
    byte[] cropMatrix = source.getMatrix();
    for (int r = 0; r < ROWS - 2; r++) {
      assertEquals(Y, (r + 1) * COLS + 1, cropMatrix, r * (COLS - 2), COLS - 2);
    }
    for (int r = 0; r < ROWS - 2; r++) {
      assertEquals(Y, (r + 1) * COLS + 1, source.getRow(r, null), 0, COLS - 2);
    }
  }

  @Test
  public void testThumbnail() {
    PlanarYUVLuminanceSource source =
        new PlanarYUVLuminanceSource(YUV, COLS, ROWS, 0, 0, COLS, ROWS, false);
    assertArrayEquals(
        new int[] { 0xFF000000, 0xFF010101, 0xFF030303, 0xFF000000, 0xFFFFFFFF, 0xFFFDFDFD },
        source.renderThumbnail());
  }

  private static void assertEquals(byte[] expected, int expectedFrom,
                                   byte[] actual, int actualFrom,
                                   int length) {
    for (int i = 0; i < length; i++) {
      assertEquals(expected[expectedFrom + i], actual[actualFrom + i]);
    }
  }

  //KItest Mini:
  @Test
  public void testNoCropTwoMini() {
    byte[] yuvData = {0, 1, 2, 3, 4, 5}; // Beispiel YUV-Daten
    int width = 3;
    int height = 2;
    PlanarYUVLuminanceSource luminanceSource = new PlanarYUVLuminanceSource(yuvData, width, height, 0, 0, width, height, false);

    // Überprüfen der Luminanzmatrix
    byte[] matrix = luminanceSource.getMatrix();
    assertArrayEquals("Die gesamte Bildquelle sollte korrekt zurückgegeben werden.",yuvData, matrix);

    // Luminanzwerte jeder Zeile überprüfen
    for (int y = 0; y < height; y++) {
      byte[] row = luminanceSource.getRow(y, null);
      for (int x = 0; x < width; x++) {
        assertEquals("Die Luminanzwerte jeder Zeile sind nicht korrekt.",yuvData[y * width + x], row[x]);
      }
    }
  }

  @Test
  public void testCropTwoMini() {
    byte[] yuvData = {0, 1, 2, 3, 4, 5}; // Beispiel YUV-Daten
    int width = 5;
    int height = 1;
    PlanarYUVLuminanceSource luminanceSource = new PlanarYUVLuminanceSource(yuvData, width, height, 1, 0, 3, 1, false);

    // Überprüfen der Luminanzmatrix des zugeschnittenen Bildausschnitts
    byte[] matrix = luminanceSource.getMatrix();
    byte[] expected = {1, 2, 3}; // Erwartete Pixelwerte
    assertArrayEquals("Die Luminanzwerte des zugeschnittenen Bereichs sind nicht korrekt.",expected, matrix);

    // Überprüfen der Luminanzwerte jeder Zeile im zugeschnittenen Bildausschnitt
    for (int y = 0; y < 1; y++) {
      byte[] row = luminanceSource.getRow(y, null);
      for (int x = 0; x < expected.length; x++) {
        assertEquals("Die Luminanzwerte jeder Zeile im zugeschnittenen Bereich sind nicht korrekt.",expected[x], row[x]);
      }
    }
  }

//  @Test
//  public void testThumbnailTwo() {
//    byte[] yuvData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // Beispiel YUV-Daten für ein 5x2 Bild
//    int width = 5;
//    int height = 2;
//    PlanarYUVLuminanceSource luminanceSource = new PlanarYUVLuminanceSource(yuvData, width, height, 0, 0, width, height, false);
//
//    // Thumbnail generieren
//    int[] thumbnail = luminanceSource.renderThumbnail();
//    int[] expectedThumbnail = {
//      0xFF000000 | (0 * 0x00010101),  // Pixel 0
//      0xFF000000 | (2 * 0x00010101),  // Pixel 2
//      0xFF000000 | (4 * 0x00010101)   // Pixel 4
//    }; // Erwartete Pixelwerte für ein Thumbnail (Skalierung nach BREITE/2 und HÖHE/2)
//
//    assertArrayEquals("Die generierten Pixelwerte des Vorschaubildes sind nicht korrekt.",expectedThumbnail, thumbnail);
//  }

  @Test
  public void testThumbnailThreeMini() {
    byte[] yuvData = {0, 1, 2, 3, 4, 5}; // Beispiel YUV-Daten für 3x2 Bild
    int width = 3;
    int height = 2;
    PlanarYUVLuminanceSource luminanceSource = new PlanarYUVLuminanceSource(yuvData, width, height, 0, 0, width, height, false);

    // Thumbnail generieren
    int[] thumbnail = luminanceSource.renderThumbnail();

    int thumbnailWidth = width / 2;  // THUMBNAIL_SCALE_FACTOR = 2
    int thumbnailHeight = height / 2; // THUMBNAIL_SCALE_FACTOR = 2

    assertEquals("Die Länge des Thumbnails ist nicht korrekt.",thumbnailWidth * thumbnailHeight, thumbnail.length);

    // Erwartete Pixelwerte berechnen
    int[] expectedThumbnail = new int[thumbnailWidth * thumbnailHeight];
    for (int y = 0; y < thumbnailHeight; y++) {
      for (int x = 0; x < thumbnailWidth; x++) {
        int grey = yuvData[(y * 2) * width + (x * 2)] & 0xff; // Zugriff auf den korrekten Grauwert
        expectedThumbnail[y * thumbnailWidth + x] = 0xFF000000 | (grey * 0x00010101);
      }
    }

    assertArrayEquals("Die generierten Pixelwerte des Vorschaubildes sind nicht korrekt.",expectedThumbnail, thumbnail);
  }

//KItest

  private byte[] yuvData;
  private int dataWidth;
  private int dataHeight;

  @Before
  public void setUp() {
    dataWidth = 6;  // Beispielwerte
    dataHeight = 4;  // Beispielwerte
    yuvData = new byte[]{
      0, 1, 2, 3, 4, 5,
      6, 7, 8, 9, 10, 11,
      12, 13, 14, 15, 16, 17,
      18, 19, 20, 21, 22, 23
    };  // Einfaches YUV-Luminanzdatenarray zum Testen
  }

  @Test
  public void testNoCropTwo() {
    PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
      yuvData, dataWidth, dataHeight, 0, 0, dataWidth, dataHeight, false
    );

    byte[] matrix = source.getMatrix();
    assertArrayEquals("The matrix should be equal to the input yuvData for no cropping.", yuvData, matrix);

    for (int y = 0; y < dataHeight; y++) {
      byte[] row = source.getRow(y, null);
      for (int x = 0; x < dataWidth; x++) {
        assertEquals("Luminance value at row " + y + ", column " + x + " is incorrect.",
          yuvData[y * dataWidth + x], row[x]);
      }
    }
  }

  @Test
  public void testCropTwo() {
    int cropLeft = 1;
    int cropTop = 1;
    int cropWidth = 2;
    int cropHeight = 2;

    PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
      yuvData, dataWidth, dataHeight, cropLeft, cropTop, cropWidth, cropHeight, false
    );

    byte[] matrix = source.getMatrix();
    byte[] expectedCroppedData = new byte[]{7, 8, 13, 14};
    assertArrayEquals("Cropped matrix is not as expected.", expectedCroppedData, matrix);

    for (int y = 0; y < cropHeight; y++) {
      byte[] row = source.getRow(y, null);
      for (int x = 0; x < cropWidth; x++) {
        assertEquals("Luminance value at cropped row " + y + ", column " + x + " is incorrect.",
          expectedCroppedData[y * cropWidth + x], row[x]);
      }
    }
  }

//  @Test
//  public void testThumbnailTwo() {
//    PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
//      yuvData, dataWidth, dataHeight, 0, 0, dataWidth, dataHeight, false
//    );
//
//    int[] thumbnail = source.renderThumbnail();
//    int[] expectedThumbnail = new int[]{
//      0xFF000000 | (0 * 0x00010101),
//      0xFF000000 | (2 * 0x00010101),
//      0xFF000000 | (12 * 0x00010101),
//      0xFF000000 | (14 * 0x00010101)
//    };
//
//    assertArrayEquals("Thumbnail does not match the expected values.", expectedThumbnail, thumbnail);
//  }

  @Test
  public void testThumbnailThree() {
    PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
      yuvData, dataWidth, dataHeight, 0, 0, dataWidth, dataHeight, false
    );

    int[] thumbnail = source.renderThumbnail();

    // Berechnung der erwarteten Thumbnail-Werte
    int expectedWidth = dataWidth / 2;
    int expectedHeight = dataHeight / 2;
    int[] expectedThumbnail = new int[expectedWidth * expectedHeight];

    int idx = 0;
    for (int y = 0; y < expectedHeight; y++) {
      for (int x = 0; x < expectedWidth; x++) {
        int yuvIndex = (y * 2 * dataWidth) + (x * 2);  // Skalierungsfaktor berücksichtigen
        int grey = yuvData[yuvIndex] & 0xff;
        expectedThumbnail[idx] = 0xFF000000 | (grey * 0x00010101);
        idx++;
      }
    }

    assertArrayEquals("Thumbnail does not match the expected values.", expectedThumbnail, thumbnail);
  }


}
