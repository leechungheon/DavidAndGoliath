import java.util.Scanner;

public class Dungeon1 {
    public void dunGeon1(int x, My my, Enemy enemy, Enemy enemy2, Enemy enemy3, Enemy enemy4,Reward_1 reward1, Card_list card_list, Shop shop) {//나중에 int형 반환으로 바꿔서 던전 2입장여부 조사

        int select=0;
        Scanner scan= new Scanner(System.in);

        my.fhp=80;
        my.hp=80;
        if (x == 1) {
            enemy.fhp=40;
            enemy.hp=40;
            my.mycard();//test
        }else if(x==2) {
            enemy.fhp=30;
            enemy.hp=30;
            enemy2.fhp = 70;
            enemy2.hp = 70;
        }

        //출력
        do {
            my.energy=3;
            my.defend=0;
            System.out.println("==============================================================================");
            do {
                System.out.printf("ጿ                                                                       ");
                if(x==1&&enemy.hp>0){
                System.out.printf("▲(atk: %d) ", enemy.atk_save);}
                if(x==2){
                    if(enemy.hp>0){
                        System.out.printf("▲(atk: %d) ", enemy.atk_save);}
                    if(enemy.hp>0){
                    System.out.printf(" \t\t▲(atk: %d)", enemy2.atk_save);}
                }else if(x==3){
                    if(enemy.hp>0){
                        System.out.printf("▲(atk: %d) ", enemy.atk_save);}
                    if(enemy2.hp>0){
                        System.out.printf("▲(atk: %d) ", enemy2.atk_save);}
                    if(enemy3.hp>0){
                        System.out.printf(" \t\t▲(atk: %d)", enemy3.atk_save);}
                }
                else if(x==4){
                    if(enemy.hp>0){
                        System.out.printf("▲(atk: %d) ", enemy.atk_save);}
                    if(enemy2.hp>0){
                        System.out.printf("▲(atk: %d) ", enemy2.atk_save);}
                    if(enemy3.hp>0){
                        System.out.printf(" \t\t▲(atk: %d)", enemy3.atk_save);}
                    if(enemy4.hp>0){
                        System.out.printf(" \t\t▲(atk: %d)", enemy4.atk_save);}
                }
                System.out.println();
                //내 체력바 출력
                my.myhp();
                System.out.print("\t\t\t\t\t\t\t\t\t");
                //적 체력바 출력
                if(enemy.hp>0) {
                    enemy.enemyhp();
                }
                if(x==2){
                    if(enemy2.hp>0) {
                        enemy2.enemyhp();
                    }
                }else if(x==3){
                    if(enemy2.hp>0) {
                        enemy2.enemyhp();
                    }
                    if(enemy3.hp>0) {
                        enemy3.enemyhp();
                    }
                }
                else if(x==4){
                    if(enemy2.hp>0) {
                        enemy2.enemyhp();
                    }
                    if(enemy3.hp>0) {
                        enemy3.enemyhp();
                    }
                    if(enemy4.hp>0) {
                        enemy4.enemyhp();
                    }
                }
                System.out.println("\n==============================================================================");
                System.out.printf("\n\t\t\t\t\t\t\t\t【에너지:%d/3】\n\n", my.energy);
                //내 카드 출력 마이턴.
                my.mydeck(select);
                //test
                for(int i=0; i<100; i++) {
                    System.out.print(my.mycard[i]);
                }
                System.out.println();
                for(int i=0; i<100; i++) {
                    System.out.print(my.mycard_y[i]);
                }
                for(int i=0; i<6; i++){
                    System.out.print(my.mydeck[i]);
                }
                select = scan.nextInt();
                my.cardchoice(select,x, enemy,enemy2,enemy3,enemy4);
            } while (select != 0&&enemy.hp>0||select != 0&&enemy2.hp>0||select != 0&&enemy3.hp>0||select != 0&&enemy4.hp>0);
            //적 공격후 상황 출력
            int savehp=my.hp;
            if(enemy.hp>0||enemy2.hp>0||enemy3.hp>0||enemy4.hp>0) {
                if (enemy.hp > 0) {//적이 살앗으면 나에게 공격
                    enemy.enemyatk(my);
                    enemy.atk_save = enemy.enemypower();
                }
                if (enemy2.hp > 0) {
                    enemy2.enemyatk(my);
                    enemy2.atk_save = enemy2.enemypower();
                }
                if (enemy3.hp > 0) {
                    enemy3.enemyatk(my);
                    enemy3.atk_save = enemy3.enemypower();
                }
                if (enemy4.hp > 0) {
                    enemy4.enemyatk(my);
                    enemy4.atk_save = enemy4.enemypower();
                }
                System.out.printf("\n\t\t\t\t\t\t『적에게 %d 데미지를 받았습니다.』\n\n\n", savehp - my.hp);
            } else{//적이 죽엇으면
                System.out.println("\n\n\n\n\n\n\n\n\n\n" +
                        " ██████╗██╗     ███████╗ █████╗ ██████╗ ██╗██╗\n" +
                        "██╔════╝██║     ██╔════╝██╔══██╗██╔══██╗██║██║\n" +
                        "██║     ██║     █████╗  ███████║██████╔╝██║██║\n" +
                        "██║     ██║     ██╔══╝  ██╔══██║██╔══██╗╚═╝╚═╝\n" +
                        "╚██████╗███████╗███████╗██║  ██║██║  ██║██╗██╗\n" +
                        " ╚═════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝╚═╝\n" +
                        "                                              \n");
                //보상얻기
                reward1.reward(1, my,card_list);//골드받고 카드 3중 1 선택// 정수값 1 받으면 골드 및 선택 문구 출력
                while(true) {
                    select = scan.nextInt();
                    if (select == 1) {
                        my.mycard_plus(1, reward1);
                        break;
                    } else if (select == 2) {
                        my.mycard_plus(2, reward1);
                        break;
                    } else if (select == 3) {
                        my.mycard_plus(3, reward1);
                        break;
                    } else {
                        System.out.println("잘못 입력된 값입니다.");
                    }
                }
                //상점으로 갈래? 싸우러갈래?
                shop.shop_choice(reward1, my, card_list);
                //상점 카드 버리기, 카드 구매, hp회복 기능
                //이벤트 확률적으로 출현
            }
            if(my.hp<0){//내가 죽엇으면
                System.out.println("\n" +
                        " ██████╗  █████╗ ███╗   ███╗███████╗ ██████╗ ██╗   ██╗███████╗██████╗ \n" +
                        "██╔════╝ ██╔══██╗████╗ ████║██╔════╝██╔═══██╗██║   ██║██╔════╝██╔══██╗\n" +
                        "██║  ███╗███████║██╔████╔██║█████╗  ██║   ██║██║   ██║█████╗  ██████╔╝\n" +
                        "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\n" +
                        "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\n" +
                        " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝ ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\n" +
                        "                                                                      \n");
            }
        }while(my.hp>0&&enemy.hp>0||my.hp>0&&enemy2.hp>0||my.hp>0&&enemy3.hp>0||my.hp>0&&enemy4.hp>0);//스테이지 1반복 둘 다 살았다면,


    }
}
