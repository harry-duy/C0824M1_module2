package ss9.s4;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TriangleClassifierTest {
    @Test
    void classify_2_2_2_shouldBeEquilateral() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(2, 2, 2);
        assertEquals("tam giác đều", result);
    }
    @Test
    void classify_2_2_3_shouldBeIsosceles() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(2, 2, 3);
        assertEquals("tam giác cân", result);
    }
    @Test
    void classify_3_4_5_shouldBeScalene() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(3, 4, 5);
        assertEquals("tam giác thường", result);
    }

    @Test
    void classify_8_2_3_shouldNotBeTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(8, 2, 3);
        assertEquals("không phải là tam giác", result);
    }

    @Test
    void classify_negative_1_2_1_shouldNotBeTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(-1, 2, 1);
        assertEquals("không phải là tam giác", result);
    }

    @Test
    void classify_0_1_1_shouldNotBeTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        String result = classifier.classifyTriangle(0, 1, 1);
        assertEquals("không phải là tam giác", result);
    }
}
