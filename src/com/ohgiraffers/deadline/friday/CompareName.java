package com.ohgiraffers.deadline.friday;

import java.util.Comparator;

public class CompareName implements Comparator<MemberDTO> {
     @Override
    public  int compare(MemberDTO o1, MemberDTO o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
