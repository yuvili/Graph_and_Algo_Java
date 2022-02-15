package BaseElements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EdgeTest {

        @Test
        void copy() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            Edge e1 = e0.copy();

            assertEquals(e1.getSrc(), 0);
            assertEquals(e1.getDest(), 16);
            assertEquals(e1.getWeight(),1.3118716362419698);

            Edge e2 = new Edge(1,1.8635670623870366, 0);
            Edge e3 = (Edge) e2.copy();

            assertEquals(e3.getSrc(), 1);
            assertEquals(e3.getDest(), 0);
            assertEquals(e3.getWeight(),1.8635670623870366);

            Edge e4 = new Edge(2,1.5784991011275615, 1);
            Edge e5 = (Edge) e4.copy();

            assertEquals(e5.getSrc(), 2);
            assertEquals(e5.getDest(), 1);
            assertEquals(e5.getWeight(),1.5784991011275615);

            Edge e6 = new Edge(2, 1.7938753352369698,6);
            Edge e7 = (Edge) e6.copy();

            assertEquals(e7.getSrc(), 2);
            assertEquals(e7.getDest(), 6);
            assertEquals(e7.getWeight(),1.7938753352369698);

            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            Edge e9 = (Edge) e8.copy();

            assertEquals(e9.getSrc(), 3);
            assertEquals(e9.getDest(), 4);
            assertEquals(e9.getWeight(),1.2539385028794277);
        }

        @Test
        void getSrc() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            Edge e1 = new Edge(0,1.232037506070033, 1);
            Edge e2 = new Edge(1,1.8635670623870366, 0);
            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            Edge e4 = new Edge(2,1.5784991011275615, 1);
            Edge e5 = new Edge(2,1.0631605142699874, 3 );
            Edge e6 = new Edge(2, 1.7938753352369698,6);
            Edge e7 = new Edge(3, 1.440561778177153,2 );
            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            Edge e9 = new Edge(4,1.8418222744214585, 3);

            assertEquals(e0.getSrc(), 0);
            assertEquals(e1.getSrc(), 0);
            assertEquals(e2.getSrc(), 1);
            assertEquals(e3.getSrc(), 1);
            assertEquals(e4.getSrc(), 2);
            assertEquals(e5.getSrc(), 2);
            assertEquals(e6.getSrc(), 2);
            assertEquals(e7.getSrc(), 3);
            assertEquals(e8.getSrc(), 3);
            assertEquals(e9.getSrc(), 4);
        }

        @Test
        void getDest() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            Edge e1 = new Edge(0,1.232037506070033, 1);
            Edge e2 = new Edge(1,1.8635670623870366, 0);
            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            Edge e4 = new Edge(2,1.5784991011275615, 1);
            Edge e5 = new Edge(2,1.0631605142699874, 3 );
            Edge e6 = new Edge(2, 1.7938753352369698,6);
            Edge e7 = new Edge(3, 1.440561778177153,2 );
            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            Edge e9 = new Edge(4,1.8418222744214585, 3);

            assertEquals(e0.getDest(), 16);
            assertEquals(e1.getDest(), 1);
            assertEquals(e2.getDest(), 0);
            assertEquals(e3.getDest(), 2);
            assertEquals(e4.getDest(), 1);
            assertEquals(e5.getDest(), 3);
            assertEquals(e6.getDest(), 6);
            assertEquals(e7.getDest(), 2);
            assertEquals(e8.getDest(), 4);
            assertEquals(e9.getDest(), 3);
        }

        @Test
        void getWeight() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            Edge e1 = new Edge(0, 1);
            Edge e2 = new Edge(1,1.8635670623870366, 0);
            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            Edge e4 = new Edge(2,1.5784991011275615, 1);
            Edge e5 = new Edge(2,1.0631605142699874, 3 );
            Edge e6 = new Edge(2, 1.7938753352369698,6);
            Edge e7 = new Edge(3, 2);
            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            Edge e9 = new Edge(4,1.8418222744214585, 3);

            assertEquals(e0.getWeight(), 1.3118716362419698);
            assertEquals(e1.getWeight(), 0);
            assertEquals(e2.getWeight(), 1.8635670623870366);
            assertEquals(e3.getWeight(), 1.8015954015822042);
            assertEquals(e4.getWeight(), 1.5784991011275615);
            assertEquals(e5.getWeight(), 1.0631605142699874);
            assertEquals(e6.getWeight(), 1.7938753352369698);
            assertEquals(e7.getWeight(), 0);
            assertEquals(e8.getWeight(), 1.2539385028794277);
            assertEquals(e9.getWeight(), 1.8418222744214585);
        }

        @Test
        void setWeight() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            e0.setWeight(1.232037506070033);
            assertEquals(e0.getWeight(), 1.232037506070033);

            Edge e1 = new Edge(0,1.232037506070033, 1);
            e1.setWeight(1.3118716362419698);
            assertEquals(e1.getWeight(), 1.3118716362419698);

            Edge e2 = new Edge(1, 0);
            e2.setWeight(1.232037506070033);
            assertEquals(e2.getWeight(), 1.232037506070033);

            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            e3.setWeight(1.5784991011275615);
            assertEquals(e3.getWeight(), 1.5784991011275615);

            Edge e4 = new Edge(2, 1);
            e4.setWeight(1.8015954015822042);
            assertEquals(e4.getWeight(), 1.8015954015822042);

            Edge e5 = new Edge(2,1.0631605142699874, 3 );
            e5.setWeight(1.232037506070033);
            assertEquals(e5.getWeight(), 1.232037506070033);

            Edge e6 = new Edge(2, 1.7938753352369698,6);
            e6.setWeight(1.5784991011275615);
            assertEquals(e6.getWeight(), 1.5784991011275615);

            Edge e7 = new Edge(3, 1.440561778177153,2 );
            e7.setWeight(1.7938753352369698);
            assertEquals(e7.getWeight(), 1.7938753352369698);

            Edge e8 = new Edge(3,1.2539385028794277, 4 );
            e8.setWeight(1.8418222744214585);
            assertEquals(e8.getWeight(), 1.8418222744214585);
        }


        @Test
        void getTag() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            assertEquals(e0.getTag(), 0);

            Edge e1 = new Edge(0,1.232037506070033, 1, 2);
            assertEquals(e1.getTag(), 2);

            Edge e2 = new Edge(1, 1.8635670623870366,0, 3);
            assertEquals(e2.getTag(), 3);
        }

        @Test
        void setTag() {
            Edge e0 = new Edge(0,1.3118716362419698, 16);
            e0.setTag(1);
            assertEquals(e0.getTag(), 1);

            Edge e1 = new Edge(0,1.232037506070033, 1);
            e1.setTag(2);
            assertEquals(e1.getTag(), 2);

            Edge e2 = new Edge(1,1.8635670623870366, 0);
            e2.setTag(45);
            assertEquals(e2.getTag(), 45);

            Edge e3 = new Edge(1, 1.8015954015822042,2 );
            e3.setTag(2);
            assertEquals(e3.getTag(), 2);

            Edge e4 = new Edge(2,1.5784991011275615, 1);
            e4.setTag(5);
            assertEquals(e4.getTag(), 5);
        }
    }