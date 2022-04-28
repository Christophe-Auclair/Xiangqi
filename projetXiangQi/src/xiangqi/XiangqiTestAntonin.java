package xiangqi;

import org.junit.Test;

import static org.junit.Assert.*;

public class XiangqiTestAntonin {
    Char c1;
    Roi r1;
    Roi r2;
    Cavalier cav1;
    Elephant eleph1;
    Elephant eleph2;
    Mandarin mand1;
    Bombarde bom1;
    Pion p1;
    Pion p2;
    @org.junit.Before
    public void setUp() throws Exception {

        c1 = new Char("c1","rouge");
        eleph1 = new Elephant("eleph1", "rouge");
        eleph2 = new Elephant("eleph2", "noir");
        r1 = new Roi("r1","rouge");
        r2 = new Roi("r2","noir");
        cav1 = new Cavalier("cav1", "rouge");
        mand1 = new Mandarin("mand1", "noir");
        bom1 = new Bombarde("bom1", "rouge");
        p1 = new Pion("p1","rouge");
        p2 = new Pion("p2","noir");



    }
    @Test
    public void testChar() {
        Position depart = new Position(1,5);
        Position arrivee = new Position(1,8);

        assertTrue(c1.estValide(depart,arrivee));
    }

    @Test

    public void testRoi() { // Test Roi Rouge
        Position depart = new Position(9,3);
        Position arrivee = new Position(9,4);
        assertTrue(r1.estValide(depart,arrivee));
    }
    @Test

    public void testRoi2() { // Test Roi Rouge
        Position depart = new Position(8,3);
        Position arrivee = new Position(8,4);
        assertTrue(r1.estValide(depart,arrivee));
    }


    @Test

    public void testRoi3() { // Test Roi Rouge
        Position depart = new Position(8,4);
        Position arrivee = new Position(7,5);
        assertFalse(r1.estValide(depart,arrivee));
    }

    @Test

    public void testRoi4() { // test Roi Noir
        Position depart = new Position(0,3);
        Position arrivee = new Position(0,4);
        assertTrue(r2.estValide(depart,arrivee));
    }

    @Test

    public void testCavalier() {
        Position depart = new Position(1,2);
        Position arrivee = new Position(3,1);

        assertTrue(cav1.estValide(depart,arrivee));
    }


    @Test

    public void testElephant() {  //  Elephant rouge   ok
        Position depart = new Position(5,2);
        Position arrivee = new Position(7,0);
        assertTrue(eleph1.estValide(depart,arrivee));
    }

    @Test

    public void testElephant2() { // Elephant noir  ok
        Position depart = new Position(4,2);
        Position arrivee = new Position(6,0);
        assertFalse(eleph2.estValide(depart,arrivee));
    }

    @Test

    public void testMandarin() {
        Position depart = new Position(0,3);
        Position arrivee = new Position(1,4);
        assertTrue(mand1.estValide(depart,arrivee));
    }


    @Test

    public void testBombarde() {
        Position depart = new Position(1,1);
        Position arrivee = new Position(1,3);
        assertTrue(bom1.estValide(depart,arrivee));
    }

    @Test

    public void testPion() { // test rouge
        Position depart = new Position(8,1);
        Position arrivee = new Position(9,1);
        assertFalse(p1.estValide(depart,arrivee));
    }

    @Test

    public void testPion2() { // test noir
        Position depart = new Position(1,1);
        Position arrivee = new Position(2,1);
        assertTrue(p2.estValide(depart,arrivee));
    }
}