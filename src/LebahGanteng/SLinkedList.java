package LebahGanteng;

public class SLinkedList {
    private ListNode head;
    private ListNode tail;
    // private int size;

    public SLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public SLinkedList(int data){
        head = new ListNode(data);
        tail = new ListNode(data);
    }

    public void addFirst(ListNode data){
        if(isEmpty()){
            head = data;
            tail = data;
        }else{
            data.setNext(head);
            head = data;
        }
    }
    
    public void addLast(ListNode data){
        if(isEmpty()){
            head = data;
            tail = data;
        }else{
            tail.setNext(data);
            tail = data;
        }
    }

    public ListNode removeFirst(){
        if(!isEmpty()){
            if(head == tail){
                ListNode perantara = head;
                tail = null;
                head = null;
                return perantara;
            }else{
                ListNode perantara = head;
                head = head.getNext();
                return perantara;
            }
        }else{
            return null;
        }
    }
    
    public ListNode removeLast(){
        if(!isEmpty()){
            if(head == tail){
                ListNode perantara = head;
                tail = null;
                head = null;
                return perantara;
            }else{
                ListNode perantara = head;
                while (perantara.getNext() != tail){
                    perantara = perantara.getNext();
                }
                tail = perantara;
                perantara = perantara.getNext();
                tail.setNext(null);
                return perantara;
            }
        }else{
            return null;
        }
    }

    public boolean isEmpty() {
        if((head == null) && (tail == null)){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString() {
        if (isEmpty()) {
            return "Data kosong";
        } else {
            String cetak = "Data: ";
            ListNode cek = head;
            while (cek != null) {
                cetak += cek.getData();
                if (cek.getNext() != null) {
                    cetak += ", ";
                }
                cek = cek.getNext();
            }
            return cetak;
        }
    }
}
