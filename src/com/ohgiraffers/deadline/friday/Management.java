package com.ohgiraffers.deadline.friday;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Management {

    private static List<MemberDTO> memberList = new ArrayList<>();

    public static void addList(MemberDTO member) {
        memberList.add(member);
    }

    public List<MemberDTO> searchMember() {
        return memberList;// add에서 등록한 값을 담은 memberlist를 반환
    }

    public boolean updateMember(MemberDTO updateMember) {
        MemberDTO old = null;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == updateMember.getId()) {
                old = memberList.set(i, updateMember);
            }
        }
        return old != null;
    }

    public boolean deleteMember(int id) {
       MemberDTO old = null;
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId() == id) {
                old = memberList.remove(i);
            }
        }
        return old != null;
    }


}

