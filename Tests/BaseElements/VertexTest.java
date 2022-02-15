package BaseElements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VertexTest {
        Vertex n0;
        Vertex n1;
        Vertex n2;
        Vertex n3;
        Vertex n4;
        Vertex n5;

        @Test
        @BeforeEach
        void setUp(){
            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            n0 = new Vertex(g0,0,0);

            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            n1 = new Vertex(g1,1,0);

            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            n2 = new Vertex(g2,2,0);

            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            n3 = new Vertex(g3,3,0);

            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
            n4 = new Vertex(g4,4,0);

            GeoLocation g5 = new GeoLocation(35.212111165456015,32.106235628571426,0.0);
            n5 = new Vertex(g5,5,0);
        }
        void getKey() {
            assertEquals(n0.getKey(), 0);

            assertEquals(n1.getKey(), 1);

            assertEquals(n2.getKey(), 2);

            assertEquals(n3.getKey(),3);

            assertEquals(n4.getKey(), 4);
        }

        @Test
        void getLocation() {
            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            assertEquals(n0.getLocation(), g0);

            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            assertEquals(n1.getLocation(), g1);

            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            assertEquals(n2.getLocation(), g2);

            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            assertEquals(n3.getLocation(), g3);

            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
            assertEquals(n4.getLocation(), g4);
        }

        @Test
        void setLocation() {
            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,  0.0);

            n0.setLocation(g2);
            assertEquals(n0.getLocation(), g2);

            n1.setLocation(g0);
            assertEquals(n1.getLocation(), g0);

            n2.setLocation(g1);
            assertEquals(n2.getLocation(), g1);

            n3.setLocation(g4);
            assertEquals(n3.getLocation(), g4);

            n4.setLocation(g0);
            assertEquals(n4.getLocation(), g0);
        }

        @Test
        void getTag() {
            assertEquals(n0.getTag(), 0);
        }

        @Test
        void setTag() {
            GeoLocation g0 = new GeoLocation(35.19589389346247,32.10152879327731,0.0);
            n0.setTag(1);
            assertEquals(n0.getTag(), 1);

            GeoLocation g1 = new GeoLocation(35.20319591121872,32.10318254621849,0.0);
            n1.setTag(-1);
            assertEquals(n1.getTag(), -1);

            GeoLocation g2 = new GeoLocation(35.20752617756255,32.1025646605042,0.0);
            n2.setTag(87);
            assertEquals(n2.getTag(), 87);

            GeoLocation g3 = new GeoLocation(35.21007339305892,32.10107446554622,0.0);
            n3.setTag(-344);
            assertEquals(n3.getTag(), -344);

            GeoLocation g4 = new GeoLocation(35.21310882485876,32.104636394957986,0.0);
            n4.setTag(9896);
            assertEquals(n4.getTag(), 9896);
        }
    }