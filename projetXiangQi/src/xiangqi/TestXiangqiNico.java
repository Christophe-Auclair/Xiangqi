package xiangqi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestXiangqiNico {

    Roi	r1, r2;
    Mandarin m1, m2;
    Elephant e1, e2;
    Cavalier c;
    Char t;
    Pion p1, p2;
    Bombarde b;

    @Before
    public void setUp() throws Exception {
        r1 = new Roi("r1", "noir");
        r2 = new Roi("r2", "rouge");

        m1 = new Mandarin("m1", "noir");
        m2 = new Mandarin("m2", "rouge");

        e1 = new Elephant("e1", "noir");
        e2 = new Elephant("e2", "rouge");

        c = new Cavalier("c", "jaune fluo");

        t = new Char("t", "rose bonbon");

        p1 = new Pion ("p1", "noir");
        p2 = new Pion("p2", "rouge");

        b = new Bombarde("b", "vert grenouille");
    }

    @Test
    public void testRoiNoir() {
        Position depart = new Position(1,3);
        Position arrive1 = new Position(1,4);
        Position arrive2 = new Position(1,2);
        Position arrive3 = new Position(2,4);
        assertTrue(r1.estValide(depart, arrive1));
        assertFalse(r1.estValide(depart, arrive2));
        assertFalse(r1.estValide(depart, arrive3));
    }

    @Test
    public void testRoiRouge() {
        Position depart = new Position(7,4);
        Position arrive1 = new Position(7,5);
        Position arrive2 = new Position(6,4);
        Position arrive3 = new Position(8,3);
        assertTrue(r2.estValide(depart, arrive1));
        assertFalse(r2.estValide(depart, arrive2));
        assertFalse(r2.estValide(depart, arrive3));
    }

    @Test
    public void testMandarin(){
        Position depart1 = new Position(0,5);
        Position depart2 = new Position(7,3);
        Position arrive1 = new Position(1,6);
        Position arrive2 = new Position(8,4);
        assertFalse(m1.estValide(depart1, arrive1));
        assertTrue(m2.estValide(depart2, arrive2));
    }

    @Test
    public void testPionNoir() {
        Position depart1 = new Position(4,6);
        Position depart2 = new Position(5,6);
        Position arrive1 = new Position(5,6);
        Position arrive2 = new Position(4,5);
        Position arrive3 = new Position(5,5);
        assertTrue(p1.estValide(depart1, arrive1));
        assertTrue(p1.estValide(depart2, arrive3));
        assertFalse(p1.estValide(depart1, arrive2));
    }

    @Test
    public void testPionRouge() {
        Position depart1 = new Position(5,6);
        Position depart2 = new Position(4,6);
        Position arrive1 = new Position(4,6);
        Position arrive2 = new Position(5,5);
        Position arrive3 = new Position(4,5);
        assertTrue(p2.estValide(depart1, arrive1));
        assertTrue(p2.estValide(depart2, arrive3));
        assertFalse(p2.estValide(depart1, arrive2));
    }

    @Test
    public void testElephant() {
        Position depart1 = new Position(4,2);
        Position depart2 = new Position(5,2);
        Position arrive1 = new Position(6,4);
        Position arrive2 = new Position(2,4);
        Position arrive3 = new Position(3,0);
        Position arrive4 = new Position(7,0);
        assertFalse(e1.estValide(depart1, arrive1));
        assertTrue(e1.estValide(depart1, arrive2));
        assertFalse(e2.estValide(depart2, arrive3));
        assertTrue(e2.estValide(depart2, arrive4));
    }

    @Test
    public void testCharBombarde() {
        Position depart = new Position(2,2);
        Position arrive1 = new Position(5,5);
        Position arrive2 = new Position(2,7);
        Position arrive3 = new Position(9,2);
        assertFalse(b.estValide(depart, arrive1));
        assertFalse(t.estValide(depart, arrive1));
        assertTrue(b.estValide(depart, arrive2));
        assertTrue(b.estValide(depart, arrive3));
        assertTrue(t.estValide(depart, arrive2));
        assertTrue(t.estValide(depart, arrive3));
    }

    @Test
    public void testCavalier() {
        Position depart = new Position(3,4);
        Position arrive1 = new Position(2,2);
        Position arrive2 = new Position(2,1);
        Position arrive3 = new Position(4,5);
        assertTrue(c.estValide(depart, arrive1));
        assertFalse(c.estValide(depart, arrive2));
        assertFalse(c.estValide(depart, arrive3));
    }
}