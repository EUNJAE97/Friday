package com.ohgiraffers.deadline.friday;

import java.util.*;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Management management = new Management();

    public void mainMenu() {
        label:
        while (true) {
            System.out.println("메뉴를 골라 주세요.");
            System.out.println("1. 회원 정보 입력");
            System.out.println("2. 회원 정보 조회");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 정보 삭제");
            System.out.println("5. 회원 정보 정렬");
            System.out.println("6. 프로그램 종료");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    searchMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    compareMember();
                    break;
                case 6:
                    System.out.println("프로그램이 종료됩니다.");
                    break label;

            }
        }
    }

    public void compareMember() {
        List<MemberDTO> memberList = management.searchMember();
        System.out.println("1. 이름 순서로 정렬 \n 2. 나이 순서로 정렬");
        int pick = sc.nextInt();

        if (memberList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }
        List<MemberDTO> sortList = new ArrayList<>();
        sortList.addAll(memberList);

        if (pick == 1) {
            sortList.sort(new Comparator<MemberDTO>() {
                @Override
                public int compare(MemberDTO o1, MemberDTO o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }else if (pick == 2) {
            sortList.sort(new Comparator<MemberDTO>() {
                @Override
                public int compare(MemberDTO o1, MemberDTO o2) {
                    return Integer.compare(o1.getAge(), o2.getAge());

                }
            });

        } else {
            System.out.println("잘못된 선택입니다.");
            return;
        }
        System.out.println("정렬된 회원 정보 : ");
        for (MemberDTO member : sortList) {
            System.out.println(member);
        }
    }


    public void deleteMember() {
        System.out.println("회원 정보 삭제");
        System.out.println("삭제할 회원의 id를 입력해주세요.");

        if (management.deleteMember(sc.nextInt())) {
            System.out.println("삭제 되었습니다.");
        } else {
            System.out.println("입력하신 회원 정보가 없습니다.");
        }
    }

    public void updateMember() {
        System.out.println("회원 정보 수정");
        System.out.println("수정할 회원의 id : ");
        sc.nextLine();
        int Id = sc.nextInt();
        System.out.println("수정할 회원의 이름 : ");
        sc.nextLine();
        String newName = sc.nextLine();
        System.out.println("수정할 회원의 나이 : ");
        int newAge = sc.nextInt();
        System.out.println("수정할 회원의 성별 : ");
        char newGender = sc.next().charAt(0);
        MemberDTO updateMember = new MemberDTO(Id, newName, newAge, newGender);
        if (management.updateMember(updateMember)) {
            System.out.println("수정이 완료 되었습니다.");
        } else {
            System.out.println("수정할 회원 정보를 찾지 못했습니다.");
        }
    }

    public void addList() {
        System.out.println("회원 정보를 입력해주세요.");
        System.out.println("이름 :");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("나이 :");
        int age = sc.nextInt();
        System.out.println("성별 :");
        char gender = sc.next().charAt(0);

        management.addList(new MemberDTO(name, age, gender));
    }

    public void searchMember() {
        System.out.println("회원 정보를 조회합니다.");
        List<MemberDTO> memberList = management.searchMember(); //리스트 멤버 디티오타입의 멤버리스트 변수에 매니지먼트클래스 서치멤버 메소드로 조회한 값을 넣겠다.
        if (!memberList.isEmpty()) {
            System.out.println("회원 정보를 조회하였습니다.");
            for (MemberDTO member : memberList) {
                System.out.println(member);
            }
        } else {
            System.out.println("회원이 존재하지 않습니다.");
        }

    }
}
