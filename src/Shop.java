import java.util.Scanner;
public class Shop {
    public void shop_choice(Reward_1 reward1, My my, Card_list card_list) {

        int select;
        do {
        Scanner scan = new Scanner(System.in);
        System.out.println("▶1. 상점으로 가기");
        System.out.println("▶2. 전투 진행하기");

            select = scan.nextInt();
            if (select == 1) {
                shop(reward1, my, card_list);

            } else if (select == 2) {
                break;

            } else {
                System.out.println("잘못 입력된 값입니다.");
            }
        } while (select != 2);//진행시에만 탈출
    }


    public void shop(Reward_1 reward1, My my, Card_list card_list){
        int select1;
        do {
            System.out.printf("\n" +
                    "\t\t\t\t\t\t╔═╗╦ ╦╔═╗╔═╗\n" +
                    "\t\t\t\t\t\t╚═╗╠═╣║ ║╠═╝\n" +
                    "\t\t\t\t\t\t╚═╝╩ ╩╚═╝╩  \t\t\t\t남은 골드:%d\n", my.gold);
            System.out.println("*********************************************************************");
            reward1.reward(0, my, card_list);//50~70 원 측정
            System.out.println("4.『HP 10회복』\n▶ 30 골드\n");
            System.out.println("5.『카드 제거 서비스』\n▶ 70 골드");
            System.out.println();
            System.out.println("Press 0 to back...");
            System.out.println("*********************************************************************");
            Scanner scan = new Scanner(System.in);
            select1 = scan.nextInt();
            if (select1 == 1) {

            } else if (select1 == 2) {

            } else if (select1 == 3) {

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
                //조건문 돈이 충분하다면//카드가 5장 이상이라면
                System.out.println("몇 번 카드를 제거하시겠습니까?");
                for(int i=0; i<100; i++){
                    my.card_destription(my.mycard_y[i]);
                }
                int select3;
                select3= scan.nextInt();
                my.mycard_minus(select3,reward1);
                //돈이 충분하지않다면
            } else if (select1 == 0) {
                break;

            } else {
                System.out.println("잘못 입력된 값입니다.");
            }
        }while(select1!=0);

    }

}
