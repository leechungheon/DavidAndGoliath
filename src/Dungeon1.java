import java.util.Scanner;

public class Dungeon1 {
    public void dunGeon1(int x, My my, Enemy enemy, Enemy enemy2, Enemy enemy3, Enemy enemy4,Reward_1 reward1, Card_list card_list, Shop shop) {//나중에 int형 반환으로 바꿔서 던전 2입장여부 조사

        int select=0;
        Scanner scan= new Scanner(System.in);

        my.fhp=80;
        my.hp=80;
        my.defend=0;
        enemy.fhp=40;
        enemy.hp=40;
        int win=0;
        //반복 시작 구간 내가 죽으면 게임오버, 적이 죽으면 다음으로

        //출력
        do {
            int suffle=0;
            my.energy=3;
            my.defend=0;
            System.out.println("==============================================================================");
            System.out.println("1-1 STAGE\n\n\n\n");
            do {
                System.out.printf("ጿ                                                                       ▲(← %d)\n", enemy.atk_save);
                my.myhp();
                System.out.print("\t\t\t\t\t\t\t\t\t");
                enemy.enemyhp();
                System.out.println("\n==============================================================================");
                System.out.printf("\n\t\t\t\t\t\t\t\t【에너지:%d/3】\n\n", my.energy);
                //내 카드 출력 마이턴.
                my.mydeck(select);
                select = scan.nextInt();
                my.cardchoice(select, enemy,enemy2,enemy3,enemy4);
            } while (select != 0&&enemy.hp>0);
            //적 공격후 상황 출력
            if(enemy.hp>0) {//적이 살앗으면 나에게 공격
                int savehp=my.hp;
                enemy.enemyatk(my);
                System.out.printf("\n\t\t\t\t\t\t『적에게 %d 데미지를 받았습니다.』\n\n\n",savehp-my.hp);
                enemy.atk_save=enemy.enemypower();
                // 반복 종료 구간
            }else{//적이 죽엇으면
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
                select = scan.nextInt();
                if(select==1){
                    my.mycard_plus(1,reward1);

                }else if(select==2){
                    my.mycard_plus(2,reward1);

                }else{
                    my.mycard_plus(3,reward1);
                }
                //상점으로 갈래? 싸우러갈래?
                shop.shop_choice(reward1, my, card_list);
                //상점 카드 버리기, 카드 구매, hp회복 기능
                //이벤트 확률적으로 출현
                win++;//스테이지 1-2 코인
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
        }while(my.hp>0&&enemy.hp>0);//스테이지 1반복 둘 다 살았다면,


        if(win==1){//적 4마리 출현
            //스테이지 1-2
        }else{
            //비워놓기
        }
    }
}
