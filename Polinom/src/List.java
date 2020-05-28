public class List<E> {
    E data;
    List next;



    public List(E data, List next) {
        this.data = data;
        this.next = next;
    }

    public List(E data) {
        this.data = data;
        this.next = null;
    }


    public List() {
        this(null, null);
    }

    public Object print() {
        return data;
    }
}

class LinkedList<E> {
    private List head;

    public LinkedList() {
        this.head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void add(E e) {
        if (head != null) {
            List cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new List(e, null);
        } else head = new List(e, null);
    }


    public void remove() {
        head = head.next;
    }

    public String toString() {
        List cur = head;
        String str = "[ ";

        while (cur != null) {
            str += cur.data + " ";
            cur = cur.next;
        }
        return str += "]";
    }

    public Object get(int index) {
        List cur = head;
        int k = 0;
        while (cur != null) {
            if (k == index) {
                return cur.print();
            }
            k++;
            cur = cur.next;
        }
        return null;
    }

    public Object remove(int index) {
        List b = null;
        List cur = head;
        int k = 0;
        if (index != 0) {
            while (cur != null) {
                if (k == index) {
                    b.next = cur.next;
                    return cur;
                }
                k++;
                b = cur;
                cur = cur.next;
            }
            return null;
        } else {
            head = head.next;
            return cur;
        }
    }

    public void rearrange() {
        List cur = head;
        int k = 0;
        while (cur != null) {
            if (k % 2 != 0) {

            }
        }
    }

    public int size() {
        int size = 0;
        List c = head;
        if (head != null) {
            while (c != null) {
                size++;
                c = c.next;
            }
        }
        return size;
    }

    public boolean remove(E o) {
        while (head != null && head.data == o) {
            head = head.next;
        }
        if (head.data != null) {
            List c = head;
            List next2;
            while (c != null) {
                if (c.next != null) {
                    next2 = c.next;
                    if (next2.data == o) {
                        c.next = next2.next;
                    }
                }
                c = c.next;
            }
        }
        return true;
    }

    public void add(int index, E element) {
        List b = null;
        List cur = head;
        int k = 0;
        if (index != 0) {
            while (cur != null) {
                if (k == index) {
                    b.next = new List(element, cur);
                }
                k++;
                b = cur;
                cur = cur.next;
            }
        } else {
            head = new List(element, head);
        }
    }

    public int indexOf(E o) {
        List cur = head;
        int k = 0;
        while (cur != null) {
            if (cur.data == o) {
                return k;
            }
            cur = cur.next;
            k++;
        }
        return -1;
    }
}
