package com.company;

public class LinkedIntList {
    Elem head = null;

    public LinkedIntList(Elem head) {
        this.head = head;
    }


    public LinkedIntList(int data) {
        head = new Elem(data,null);
    }

    public LinkedIntList() {
    }

    public LinkedIntList removeAlternating(){
        LinkedIntList answer = new LinkedIntList();
        Elem cur = head;
        Elem answerCur = null;
        Elem previous = null;
        boolean iter = false;
        while(cur != null && cur.next != null){
            if(!iter){
                if(answer.head == null){
                    answer.head = cur;
                    if(previous == null){
                        head = cur.next;
                        cur.next = null;
                    }

                    answerCur = answer.head;
                    cur = head.next;
                    previous = head;
                }
                else {
                    answerCur.next = cur;
                    previous.next = cur.next;
                    answerCur = answerCur.next;
                    previous = cur.next;
                    cur = cur.next.next;
                    answerCur.next = null;
                }
                iter = true;


            }else{
                answerCur.next = cur.next;
                cur.next = cur.next.next;
                iter = false;
                answerCur = answerCur.next;
                previous = cur;
                cur = cur.next;
                answerCur.next = null;

            }

        }
        return answer;
    }

    private void add(int data){
        head = new Elem(data,head);
    }


    public static void main(String[] args) {
        LinkedIntList list1 = new LinkedIntList(10);
        for (int i = 9; i > 0; i--) {
            list1.add(i);
        }
        LinkedIntList list2 = list1.removeAlternating();
    }
}


