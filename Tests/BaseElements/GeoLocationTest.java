package BaseElements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoLocationTest {
    GeoLocation g;
    GeoLocation g1;
    GeoLocation g2;
    GeoLocation g3;
    GeoLocation g4;

    @BeforeEach
    void setUp() {
        g = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
        g1 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
        g2 = new GeoLocation(35.20797194027441,32.104854472268904,0.0);
        g3 = new GeoLocation(35.19805902663438,32.10525428067227,0.0);
        g4 = new GeoLocation(35.20154022114608,32.10594485882353,0.0);
    }

    @Test
    void x() {
        assertEquals(g.x(),35.21310882485876);
        assertEquals(g1.x(),35.21007339305892);
        assertEquals(g2.x(),35.20797194027441);
        assertEquals(g3.x(),35.19805902663438);
        assertEquals(g4.x(),35.20154022114608);
    }

    @Test
    void y() {
        assertEquals(g.y(),32.104636394957986);
        assertEquals(g1.y(),32.10107446554622);
        assertEquals(g2.y(),32.104854472268904);
        assertEquals(g3.y(),32.10525428067227);
        assertEquals(g4.y(),32.10594485882353);
    }

    @Test
    void z() {
        assertEquals(g.z(),0.0);
        assertEquals(g1.z(),0.0);
        assertEquals(g2.z(),0.0);
        assertEquals(g3.z(),0.0);
        assertEquals(g4.z(),0.0);
    }

    @Test
    void setX() {

        g.setX(35.20154022114608);
        assertEquals(g.x(),35.20154022114608);

        g1.setX(35.21310882485876);
        assertEquals(g1.x(),35.21310882485876);

        g2.setX(32.10594485882353);
        assertEquals(g2.x(),32.10594485882353);

        g3.setX(11111222222222.88888888876);
        assertEquals(g3.x(),11111222222222.88888888876);

        g4.setX(0.0);
        assertEquals(g4.x(),0.0);
    }

    @Test
    void setY() {
        g.setY(333322.53527367);
        assertEquals(g.y(),333322.53527367);

        g1.setY(35.21310882485876);
        assertEquals(g1.y(),35.21310882485876);

        g2.setY(32.10594485882353);
        assertEquals(g2.y(),32.10594485882353);

        g3.setY(11111222222222.88888888876);
        assertEquals(g3.y(),11111222222222.88888888876);

        g4.setY(0.0);
        assertEquals(g4.y(),0.0);
    }

    @Test
    void setZ() {
        g.setZ(333322.53527367);
        assertEquals(g.z(),333322.53527367);

        g1.setZ(35.21310882485876);
        assertEquals(g1.z(),35.21310882485876);

        g2.setZ(32.10594485882353);
        assertEquals(g2.z(),32.10594485882353);

        g3.setZ(35.20154022114608);
        assertEquals(g3.z(),35.20154022114608);

        g4.setZ(0.0);
        assertEquals(g4.z(),0.0);
    }

    @Test
    void copy() {
        GeoLocation g5 = g4.copy();

        assertEquals(g5.x(), g4.x());
        assertEquals(g5.y(), g4.y());
        assertEquals(g5.z(), g4.z());
    }

    @Test
    void distance() {
        assertEquals(g.distance(g1), 0.004679870441141678);
        assertEquals(g2.distance(g1), 0.004324876255925059);
        assertEquals(g.distance(g3), 0.015062476866382724);
        assertEquals(g4.distance(g), 0.011642365290109436);
        assertEquals(g2.distance(g4), 0.006523492452990196);
        assertEquals(g4.distance(g2), 0.006523492452990196);
        assertEquals(g1.distance(g3), 0.012720686108501335);
    }

    @Test
    void GeoToString(){
        assertEquals(g.toString(),"35.21310882485876,32.104636394957986,0.0");
        assertEquals(g1.toString(),"35.21007339305892,32.10107446554622,0.0");
        assertEquals(g2.toString(),"35.20797194027441,32.104854472268904,0.0");
    }
}