package xiangqi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestXiangqi {

    Bombarde b1;
    Bombarde b2;

    Cavalier c1;
    Cavalier c2;

    Char ch1;
    Char ch2;

    Elephant e1;
    Elephant e2;
    Elephant e3;
    Elephant e4;

    Mandarin m1;
    Mandarin m2;

    Pion p1;
    Pion p2;
    Pion p3;
    Pion p4;

    Roi r1;
    Roi r2;

    @org.junit.Before
    public void setUp() throws Exception
    {
        b1 = new Bombarde("b1", "noir");
        b2 = new Bombarde("b2", "rouge");

        c1 = new Cavalier("c1", "noir");
        c2 = new Cavalier("c2", "rouge");

        ch1 = new Char("ch1", "noir");
        ch2 = new Char("ch2", "rouge");

        e1 = new Elephant("e1", "noir");
        e2 = new Elephant("e2", "rouge");
        e3 = new Elephant("e3", "noir");
        e4 = new Elephant("e4", "rouge");

        m1 = new Mandarin("m1", "noir");
        m2 = new Mandarin("m2", "rouge");

        p1 = new Pion("p1", "noir");
        p2 = new Pion("p2", "rouge");
        p3 = new Pion("p3", "noir");
        p4 = new Pion("p4", "rouge");

        r1 = new Roi("r1", "noir");
        r2 = new Roi("r2", "rouge");
    }

    @Test
    public void testBombarde1()
    {
        Position depart = new Position(0, 0);
        Position arrivee = new Position(9, 0);

        assertTrue(b1.estValide(depart, arrivee));
    }

    @Test
    public void testBombarde2()
    {
        Position depart = new Position(9, 8);
        Position arrivee = new Position(8, 7);

        assertFalse(b2.estValide(depart, arrivee));
    }

    @Test
    public void testCavalier1()
    {
        Position depart = new Position(0, 0);
        Position arrivee = new Position(2, 1);

        assertTrue(c1.estValide(depart, arrivee));
    }

    @Test
    public void testCavalier2()
    {
        Position depart = new Position(9, 8);
        Position arrivee = new Position(6, 7);

        assertFalse(c2.estValide(depart, arrivee));
    }


    @Test
    public void testChar1()
    {
        Position depart = new Position(0, 0);
        Position arrivee = new Position(0, 8);

        assertTrue(ch1.estValide(depart, arrivee));
    }


    @Test
    public void testChar2()
    {
        Position depart = new Position(5, 5);
        Position arrivee = new Position(4, 4);

        assertFalse(ch2.estValide(depart, arrivee));
    }


    @Test
    public void testElephant1()
    {
        Position depart = new Position(0, 2);
        Position arrivee = new Position(2, 0);

        assertTrue(e1.estValide(depart, arrivee));
    }


    @Test
    public void testElephant2()
    {
        Position depart = new Position(9, 6);
        Position arrivee = new Position(5, 2);

        assertFalse(e2.estValide(depart, arrivee));
    }

    @Test
    public void testElephant3()
    {
        Position depart = new Position(4, 2);
        Position arrivee = new Position(2, 4);

        assertTrue(e3.estValide(depart, arrivee));
    }

    @Test
    public void testElephant4()
    {
        Position depart = new Position(5, 6);
        Position arrivee = new Position(3, 4);

        assertFalse(e4.estValide(depart, arrivee));
    }


    @Test
    public void testMandarin1()
    {
        Position depart = new Position(1, 4);
        Position arrivee = new Position(0, 5);

        assertTrue(m1.estValide(depart, arrivee));
    }


    @Test
    public void testMandarin2()
    {
        Position depart = new Position(8, 4);
        Position arrivee = new Position(8, 5);

        assertFalse(m2.estValide(depart, arrivee));
    }

    @Test
    public void testPion1()
    {
        Position depart = new Position(4, 3);
        Position arrivee = new Position(5, 3);

        assertTrue(p1.estValide(depart, arrivee));
    }

    @Test
    public void testPion2()
    {
        Position depart = new Position(6, 5);
        Position arrivee = new Position(6, 6);

        assertFalse(p2.estValide(depart, arrivee));
    }

    @Test
    public void testPion3()
    {
        Position depart = new Position(5, 3);
        Position arrivee = new Position(5, 4);

        assertTrue(p3.estValide(depart, arrivee));
    }

    @Test
    public void testPion4()
    {
        Position depart = new Position(6, 6);
        Position arrivee = new Position(5, 7);

        assertFalse(p4.estValide(depart, arrivee));
    }

    @Test
    public void testRoi1()
    {
        Position depart = new Position(0, 3);
        Position arrivee = new Position(0, 4);

        assertTrue(r1.estValide(depart, arrivee));
    }

    @Test
    public void testRoi2()
    {
        Position depart = new Position(8, 4);
        Position arrivee = new Position(7, 3);

        assertFalse(r2.estValide(depart, arrivee));
    }
}