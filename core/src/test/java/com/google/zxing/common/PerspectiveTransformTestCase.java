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

package com.google.zxing.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sean Owen
 */
public final class PerspectiveTransformTestCase extends Assert {

  private static final float EPSILON = 1.0E-4f;
//
//  @Test
//  public void testSquareToQuadrilateral() {
//    PerspectiveTransform pt = PerspectiveTransform.squareToQuadrilateral(
//        2.0f, 3.0f, 10.0f, 4.0f, 16.0f, 15.0f, 4.0f, 9.0f);
//    assertPointEquals(2.0f, 3.0f, 0.0f, 0.0f, pt);
//    assertPointEquals(10.0f, 4.0f, 1.0f, 0.0f, pt);
//    assertPointEquals(4.0f, 9.0f, 0.0f, 1.0f, pt);
//    assertPointEquals(16.0f, 15.0f, 1.0f, 1.0f, pt);
//    assertPointEquals(6.535211f, 6.8873234f, 0.5f, 0.5f, pt);
//    assertPointEquals(48.0f, 42.42857f, 1.5f, 1.5f, pt);
//  }
//
//  @Test
//  public void testQuadrilateralToQuadrilateral() {
//    PerspectiveTransform pt = PerspectiveTransform.quadrilateralToQuadrilateral(
//        2.0f, 3.0f, 10.0f, 4.0f, 16.0f, 15.0f, 4.0f, 9.0f,
//        103.0f, 110.0f, 300.0f, 120.0f, 290.0f, 270.0f, 150.0f, 280.0f);
//    assertPointEquals(103.0f, 110.0f, 2.0f, 3.0f, pt);
//    assertPointEquals(300.0f, 120.0f, 10.0f, 4.0f, pt);
//    assertPointEquals(290.0f, 270.0f, 16.0f, 15.0f, pt);
//    assertPointEquals(150.0f, 280.0f, 4.0f, 9.0f, pt);
//    assertPointEquals(7.1516876f, -64.60185f, 0.5f, 0.5f, pt);
//    assertPointEquals(328.09116f, 334.16385f, 50.0f, 50.0f, pt);
//  }

  private static void assertPointEquals(float expectedX,
                                        float expectedY,
                                        float sourceX,
                                        float sourceY,
                                        PerspectiveTransform pt) {
    float[] points = {sourceX, sourceY};
    pt.transformPoints(points);
    assertEquals(expectedX, points[0], EPSILON);
    assertEquals(expectedY, points[1], EPSILON);
  }
//
  //KItest
  @Test
  public void testSquareToQuadrilateralTwo() {
    // Definieren Sie die Ecken des Quadrats (0,0), (1,0), (1,1), (0,1)
    float x0 = 0.0f, y0 = 0.0f, x1 = 1.0f, y1 = 0.0f, x2 = 1.0f, y2 = 1.0f, x3 = 0.0f, y3 = 1.0f;

    // Definieren Sie die Ecken des Zielquadrilaterals (z.B. ein Parallelogramm)
    float x0p = 0.0f, y0p = 0.0f, x1p = 2.0f, y1p = 1.0f, x2p = 2.0f, y2p = 3.0f, x3p = 0.0f, y3p = 2.0f;

    // Erstellen Sie die Transformation
    PerspectiveTransform transform = PerspectiveTransform.squareToQuadrilateral(x0p, y0p, x1p, y1p, x2p, y2p, x3p, y3p);

    // Testpunkte und ihre erwarteten Positionen
    float[] points = { 0.5f, 0.5f, 1.0f, 1.0f };
    float[] expectedPoints = { 1.0f, 1.5f, 2.0f, 3.0f };

    // Transformation anwenden
    transform.transformPoints(points);

    // Überprüfen
    assertArrayEquals(expectedPoints, points, 0.0001f);
  }



//Mini
   //diese Tests sind mit der anderen KI (4o mini) erstellt wworden. Der Witz: es klappt nun ein Test von mini und der andere nur von 4 omni!


//  @Test
//  public void testQuadrilateralToQuadrilateralThreeMini() {
//    // Definiere die Punkte des ursprünglichen Vierecks und das Ziel-Viereck
//    float[] sourceQuadrilateral = {0, 0, 2, 1, 1, 3, -1, 2}; // Ausgangs-Viereck
//    float[] targetQuadrilateral = {0, 0, 1, 0, 1, 1, 0, 1}; // Ziel Quadrat
//
//    // Erzeuge die Transformation
//    PerspectiveTransform transform = PerspectiveTransform.quadrilateralToQuadrilateral(
//      sourceQuadrilateral[0], sourceQuadrilateral[1],
//      sourceQuadrilateral[2], sourceQuadrilateral[3],
//      sourceQuadrilateral[4], sourceQuadrilateral[5],
//      sourceQuadrilateral[6], sourceQuadrilateral[7],
//      targetQuadrilateral[0], targetQuadrilateral[1],
//      targetQuadrilateral[2], targetQuadrilateral[3],
//      targetQuadrilateral[4], targetQuadrilateral[5],
//      targetQuadrilateral[6], targetQuadrilateral[7]
//    );
//
//    // Punkte zum Transformieren
//    float[] pointsToTransform = {0, 0, 2, 1}; // Transformation der Ecken des Ausgangs-Vierecks
//
//    // Transformation durchführen
//    transform.transformPoints(pointsToTransform);
//
//    // Erwartete Ergebnisse (die Positionen nach der Transformation)
//    float[] expectedTransformedPoints = {
//      0f, 0f,  // (0,0) nach (0,0)
//      1f, 0f   // (2,1) nach (1,0)
//    };
//
//    // Vergleiche die erwarteten mit den resultierenden Punkten
//    assertArrayEquals(expectedTransformedPoints, pointsToTransform, 1e-6f); // Toleranz für Gleitkommazahlen
//  }

}
//Mini61; KI72; 63
