import java.util.Scanner;
public class Shop extends Reward_1{

    int x;
    public void shop_choice(Reward_1 reward1, My my) {

        int select;
        while(true) {
        Scanner scan = new Scanner(System.in);
        System.out.println("▶1. 상점으로 가기");
        System.out.println("▶2. 전투 진행하기");

            select = scan.nextInt();
            if (select == 1) {
                shop(reward1, my);
                x++;//카드 구매후 카드 랜덤 출력되는 문제 수정

            } else if (select == 2) {
                break;

            } else {
                System.out.println("잘못 입력된 값입니다.");
            }
        }//진행시에만 탈출
        x=0;//다음 상점때 다시 출력하기 위함
    }
    public void shop_card(int x, My my){
        if(x>0){
            System.out.print("1.");
            my.card_destription(card1);
            System.out.printf("▶%d 골드\n\n", gold1);
            System.out.print("2.");
            my.card_destription(card2);
            System.out.printf("▶%d 골드\n\n", gold2);
            System.out.print("3.");
            my.card_destription(card3);
            System.out.printf("▶%d 골드\n\n", gold3);
        }else{
            System.out.print("1.");
            while (true) {
                card1 = (int) (Math.random() * 13) + 4;
                int count = 0;
                int i;
                for (i = 0; i < 100; i++) {
                    if (my.mycard[i] != card1) {
                        count++;
                    }
                }
                if (count == 100) {
                    my.card_destription(card1);
                    break;
                }
            }
            gold1 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold1);

            System.out.print("2.");
            while (true) {
                card2 = (int) (Math.random() * 13) + 4;
                if (card2 != card1) {

                    int count = 0;
                    int i;
                    for (i = 0; i < 100; i++) {//중복체크
                        if (my.mycard[i] != card2) {
                            count++;
                        }
                    }
                    if (count == 100) {//중복X
                        my.card_destription(card2);
                        break;
                    }

                } else {//카드1과 같다면

                }
            }
            gold2 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold2);

            System.out.print("3.");
            while (true) {
                card3 = (int) (Math.random() * 13) + 4;
                if (card3 != card1 && card3 != card2) {

                    int count = 0;
                    int i;
                    for (i = 0; i < 100; i++) {//중복체크
                        if (my.mycard[i] != card3) {
                            count++;//무한반복
                        }
                    }
                    if (count == 100) {//중복X
                        my.card_destription(card3);
                        break;
                    }

                } else {//카드1과 같다면

                }

            }
            gold3 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold3);
        }
    }



    public void shop(Reward_1 reward1, My my){
        int select1;
        do {
            System.out.printf("\n" +
                    "\t\t\t\t\t\t╔═╗╦ ╦╔═╗╔═╗\n" +
                    "\t\t\t\t\t\t╚═╗╠═╣║ ║╠═╝\n" +
                    "\t\t\t\t\t\t╚═╝╩ ╩╚═╝╩  \n남은 골드:%d\t\t\t\t\t\t\t\t\t\t\t남은 체력:(%d/%d)\n", my.gold, my.fhp,my.hp);
            System.out.println("*********************************************************************");
            shop_card(x,my);
            x++;
            System.out.println("4.『빵과 치즈』 : HP를 10 회복합니다.\n▶ 30 골드\n");
            System.out.println("5.『카드 삭제 서비스』\n▶ 70 골드\n");
            System.out.println("6.『내 카드 보기』\n");
            System.out.println();
            System.out.println("0을 눌러 뒤로가기");
            System.out.println("*********************************************************************");
            Scanner scan = new Scanner(System.in);
            select1 = scan.nextInt();
            if (select1 == 1) {
                if(my.gold>=gold1&&my.mycard[card1]!=card1) {
                    my.mycard[card1] = card1;
                    int count = 0;
                    my.mydeck[5] = 100;//종료 위함
                    //마이카드 메소드삭제함
                    for (int i = 0; i < 100; i++) {//존재하는 카드들만 추출
                        if (my.mycard[i] != 0) {
                            my.mycard_y[count] = my.mycard[i];
                            count++;
                        }
                    }
                    my.gold-=gold1;
                    System.out.printf("%d번 카드가 내 카드에 추가되었습니다.\n", card1);
                }else if(my.gold>=gold1&&my.mycard[card1]==card1){
                    System.out.println("이미 구매한 카드입니다.\n");
                }
                else{
                    System.out.println("골드가 부족합니다.\n");
                }


            } else if (select1 == 2) {
                if(my.gold>=gold2&&my.mycard[card2]!=card2) {
                    my.mycard[card2] = card2;
                    int count = 0;
                    my.mydeck[5] = 100;//종료 위함
                    //마이카드 메소드삭제함
                    for (int i = 0; i < 100; i++) {//존재하는 카드들만 추출
                        if (my.mycard[i] != 0) {
                            my.mycard_y[count] = my.mycard[i];
                            count++;
                        }
                    }
                    my.gold-=gold2;
                    System.out.printf("%d번 카드가 내 카드에 추가되었습니다.\n", card2);
                }else if(my.gold>=gold2&&my.mycard[card2]==card2) {
                    System.out.println("이미 구매한 카드입니다.\n");
                } else{
                    System.out.println("골드가 부족합니다.\n");
                }

            } else if (select1 == 3) {
                if(my.gold>=gold3&&my.mycard[card3]!=card3) {
                if(my.gold>=gold3) {
                    my.mycard[card3] = card3;
                    int count = 0;
                    my.mydeck[5] = 100;//종료 위함
                    //마이카드 메소드삭제함
                    for (int i = 0; i < 100; i++) {//존재하는 카드들만 추출
                        if (my.mycard[i] != 0) {
                            my.mycard_y[count] = my.mycard[i];
                            count++;
                        }
                    }
                    my.gold-=gold3;
                    System.out.printf("%d번 카드가 내 카드에 추가되었습니다.\n", card3);
                }else if(my.gold>=gold3&&my.mycard[card3]==card3){
                    System.out.println("이미 구매한 카드입니다.\n");
                }
                }else{
                    System.out.println("골드가 부족합니다.\n");
                }

            } else if (select1 == 4) {
                if(my.gold>=30) {
                    System.out.println("체력이 10 회복되었습니다.\n");
                    my.hp += 10;
                    my.gold -= 30;
                    System.out.printf("현재 체력 : %d/%d\n", my.hp, my.fhp);
                }else{
                    System.out.println("골드가 부족합니다.\n");
                }
            } else if (select1 == 5) {
                if(my.gold>=70){
                //조건문 돈이 충분하다면//카드가 5장 이상이라면
                System.out.println("몇 번 카드를 제거하시겠습니까?\n");
                for(int i=0; i<100; i++){
                    my.card_destription(my.mycard_y[i]);
                }
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 뒤로가기");
                int select3;
                select3= scan.nextInt();
                if(select3==0) {
                    //뒤로가기
                }else {
                    my.gold-=70;
                    my.mycard_minus(select3, reward1);
                }}else if(my.gold<70){
                    System.out.println("골드가 부족합니다.\n");
                }
            } else if (select1 == 6) {
                while(true) {
                    int count=0;
                    for(int i=0; i<100; i++){//존재하는 카드들만 추출 &사이 버퍼 없애기
                        if(my.mycard[i]!=0){//마이카드에 카드가 있다면
                            my.mycard_y[count]=my.mycard[i];
                            count++;
                        }
                    }
                    for (int i = 0; i < 100; i++) {
                        my.card_destription(my.mycard_y[i]);
                    }
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 뒤로가기");
                    int select;
                    select = scan.nextInt();
                    if (select == 0) {
                        break;
                    } else {
                        System.out.println("잘못 입력된 값입니다.");
                    }
                }

            } else if (select1 == 0) {
                break;

            } else {
                System.out.println("잘못 입력된 값입니다.");
            }
        }while(select1!=0);

    }

}
