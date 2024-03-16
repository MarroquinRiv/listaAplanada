package edu.ejercicios;

public class Aplanar {
    private static final int MAX_NODES = 1000;
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = (int) 1e5;

    public Node aplanar(Node head) {
        if (head == null) return null;

        int count = contarNodos(head);
        if (count > MAX_NODES) {
            throw new IllegalArgumentException("Número de nodos excede el límite permitido.");
        }

        validarValor(head);

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                Node next = current.next;
                Node childHead = aplanar(current.child);
                current.next = childHead;
                childHead.prev = current;
                current.child = null;
                while (childHead.next != null) {
                    childHead = childHead.next;
                }
                childHead.next = next;
                if (next != null) {
                    next.prev = childHead;
                }
            }
            current = current.next;
        }

        return head;
    }

    private int contarNodos(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void validarValor(Node head) {
        Node current = head;
        while (current != null) {
            if (current.val < MIN_VAL || current.val > MAX_VAL) {
                throw new IllegalArgumentException("Valor de nodo fuera del rango permitido.");
            }
            if (current.child != null) {
                validarValor(current.child);
            }
            current = current.next;
        }
    }
}