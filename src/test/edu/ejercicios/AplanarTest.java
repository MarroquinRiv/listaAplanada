package edu.ejercicios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AplanarTest {

    @Test
    public void testEjemplo1() {
        Node head = crearEjemplo1();
        Aplanar aplanador = new Aplanar();
        Node resultado = aplanador.aplanar(head);
        int[] esperado = {1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6};
        validarResultado(esperado, resultado);
    }

    @Test
    public void testEjemplo2() {
        Node head = crearEjemplo2();
        Aplanar aplanador = new Aplanar();
        Node resultado = aplanador.aplanar(head);
        int[] esperado = {1, 3, 2};
        validarResultado(esperado, resultado);
    }

    @Test
    public void testEjemplo3() {
        Node head = crearEjemplo3();
        Aplanar aplanador = new Aplanar();
        Node resultado = aplanador.aplanar(head);
        assertNull(resultado);
    }

    // Ejemplo 1
    private Node crearEjemplo1() {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.prev = head;
        head.next.next = new Node();
        head.next.next.val = 3;
        head.next.next.prev = head.next;
        head.next.next.child = new Node(); // Corregido para reflejar la estructura multinivel
        head.next.next.child.val = 7; // Nodo hijo de 3
        head.next.next.child.prev = head.next.next;
        head.next.next.child.next = new Node(); // Corregido para reflejar la estructura multinivel
        head.next.next.child.next.val = 8; // Nodo hijo de 7
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = new Node(); // Corregido para reflejar la estructura multinivel
        head.next.next.child.next.next.val = 11; // Nodo hijo de 8
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.next = head.next.next.child; // Corregido para reflejar la estructura multinivel

        head.next.next.next.next = new Node();
        head.next.next.next.next.val = 4;
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node();
        head.next.next.next.next.next.val = 5;
        head.next.next.next.next.next.prev = head.next.next.next.next;
        head.next.next.next.next.next.next = new Node();
        head.next.next.next.next.next.next.val = 6;
        head.next.next.next.next.next.next.prev = head.next.next.next.next;

        head.next.next.next.next.child = new Node(); // Corregido para reflejar la estructura multinivel
        head.next.next.next.next.child.val = 9; // Nodo hijo de 6
        head.next.next.next.next.child.prev = head.next.next.next.next;
        head.next.next.next.next.child.next = new Node(); // Corregido para reflejar la estructura multinivel
        head.next.next.next.next.child.next.val = 10; // Nodo hijo de 9
        head.next.next.next.next.child.next.prev = head.next.next.next.next.child;

        return head;
    }


    // Ejemplo 2
    private Node crearEjemplo2() {
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.next.prev = head;
        head.next.child = new Node();
        head.next.child.val = 3;

        return head;
    }

    // Ejemplo 3 (lista vacía)
    private Node crearEjemplo3() {
        return null; // Retorna null para representar una lista vacía
    }

    public static void validarResultado(int[] esperado, Node resultado) {
        assertNotNull(resultado);
        Node current = resultado;
        for (int val : esperado) {
            assertEquals(val, current.val);
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
    }
}