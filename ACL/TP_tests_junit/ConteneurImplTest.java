import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ConteneurImplTest {

    Conteneur conteneur;
    Conteneur conteneurCapacite1;
    Conteneur conteneurCapacite2;
    Conteneur getConteneurCapaciteNull;
    Object object1;
    Object object2;
    Object object3;
    Object object4;
    ArrayList arrayList;
    HashSet<Object> hashSet;

    @BeforeEach
    void setUp() {
        conteneur = new ConteneurImpl(10);
        conteneurCapacite1 = new ConteneurImpl(1);
        conteneurCapacite2 = new ConteneurImpl(2);
        getConteneurCapaciteNull = new ConteneurImpl(0);
        object1 = new Object();
        object2 = new Object();
        object3 = new Object();
        object4 = new Object();
        arrayList = new ArrayList();
        hashSet = new HashSet<>();
    }

    // Tests Ajouter

    @Test
    void testAjouterRight1() throws Exception {
        conteneur.ajouter(object1);
        assertEquals(1, conteneur.taille());
    }

    @Test
    void testAjouterRight2() throws Exception {
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        assertEquals(2, conteneur.taille());
    }

    @Test
    void testAjouterBoundary1() {
        assertThrows(ErreurConteneur.class, () -> conteneur.ajouter(null));
    }

    @Test
    void testAjouterBoundary2() throws Exception {
        conteneur.ajouter(object1);
        assertThrows(ErreurConteneur.class, () -> conteneur.ajouter(object1));
    }

    @Test
    void testAjouterBoundary3() throws Exception {
        assertEquals(arrayList, arrayList.clone());
        conteneur.ajouter(arrayList);
        assertThrows(ErreurConteneur.class, () -> conteneur.ajouter(arrayList.clone()));
    }

    @Test
    void testAjouterBoundary4() throws Exception {
        conteneurCapacite2.ajouter(object1);
        conteneurCapacite2.ajouter(object2);
        assertEquals(2, conteneurCapacite2.taille());
    }

    @Test
    void testAjouterBoundary5() throws Exception {
        conteneurCapacite1.ajouter(object1);
        assertThrows(ErreurConteneur.class, () -> conteneurCapacite1.ajouter(object2));
    }

    @Test
    void testAjouterCrosscheck() throws Exception {
        conteneur.ajouter(object1);
        hashSet.add(object1);
        conteneur.ajouter(object2);
        hashSet.add(object2);
        conteneur.ajouter(object3);
        hashSet.add(object3);
        conteneur.ajouter(object4);
        hashSet.add(object4);
        for (Object o : hashSet) {
            assertTrue(conteneur.contient(o));
        }
    }

    // Tests Retirer

    @Test
    void testRetirerRight1() throws Exception {
        conteneur.ajouter(object1);
        conteneur.retirer(object1);
        assertEquals(0, conteneur.taille());
    }

    @Test
    void testRetirerRight2() {
        assertThrows(ErreurConteneur.class, () -> conteneur.retirer(object1));
    }

    @Test
    void testRetirerRight3() throws Exception {
        conteneur.ajouter(object2);
        assertThrows(ErreurConteneur.class, () -> conteneur.retirer(object1));
    }

    @Test
    void testRetirerRight4() throws Exception {
        conteneur.ajouter(object2);
        conteneur.ajouter(object1);
        conteneur.retirer(object1);
        conteneur.retirer(object2);
        assertEquals(0, conteneur.taille());
    }

    @Test
    void testRetirerRight5() throws Exception {
        // ERREUR ici object1 n'est pas retiré
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        conteneur.retirer(object1);
        assertFalse(conteneur.contient(object1));
    }

    @Test
    void testRetirerRight6() throws Exception {
        // ERREUR ici object1 n'est plus dedans, mais aucune erreur n'est throw
        conteneur.ajouter(object1);
        conteneur.retirer(object1);
        assertFalse(conteneur.contient(object1));
        assertThrows(ErreurConteneur.class, () -> conteneur.retirer(object1));
    }

    @Test
    void testRetirerRight7() throws Exception {
        // ERREUR ici il n'arrive pas à retirer le deuxième object
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        conteneur.ajouter(object3);
        conteneur.ajouter(object4);
        assertDoesNotThrow(() -> conteneur.retirer(object1));
        assertDoesNotThrow(() -> conteneur.retirer(object2));
    }

    // Tests Redimensionner

    @Test
    void testRedimensionerRight1() {
        assertThrows(ErreurConteneur.class, () -> conteneur.redimensionner(0));
    }

    @Test
    void testRedimensionerRight2() throws Exception {
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        assertThrows(ErreurConteneur.class, () -> conteneur.redimensionner(1));
    }

    @Test
    void testRedimensionerRight3() throws Exception {
        // ERREUR ici on ne peut pas redimmensionner malgré que la taille soit valide.
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        conteneur.redimensionner(5);
    }

    @Test
    void testRedimensionerRight4() throws Exception {
        getConteneurCapaciteNull.redimensionner(5);
    }

    @Test
    void testRedimensionerRight5() throws Exception {
        // ERREUR ici on ne garde pas les éléments.
        conteneur.ajouter(object1);
        conteneur.ajouter(object2);
        conteneur.redimensionner(50);
        assertTrue(conteneur.contient(object1));
        assertTrue(conteneur.contient(object2));
    }
}