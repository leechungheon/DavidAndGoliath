import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Card_list cardlist=new Card_list();
        My my=new My();
        Enemy enemy=new Enemy();
        Enemy enemy2=new Enemy();
        Enemy enemy3=new Enemy();
        Enemy enemy4=new Enemy();
        Dungeon1 dungeon1=new Dungeon1();
        Reward_1 reward_1=new Reward_1();
        Shop shop=new Shop();
        Story story=new Story();
        Gift gift=new Gift();
        Bgm bgm = new Bgm();

       while(true) {
            System.out.println(
                    "██████╗  █████╗ ██╗   ██╗██╗██████╗      █████╗ ███╗   ██╗██████╗      ██████╗  ██████╗ ██╗     ██╗ █████╗ ████████╗██╗  ██╗\n" +
                    "██╔══██╗██╔══██╗██║   ██║██║██╔══██╗    ██╔══██╗████╗  ██║██╔══██╗    ██╔════╝ ██╔═══██╗██║     ██║██╔══██╗╚══██╔══╝██║  ██║\n" +
                    "██║  ██║███████║██║   ██║██║██║  ██║    ███████║██╔██╗ ██║██║  ██║    ██║  ███╗██║   ██║██║     ██║███████║   ██║   ███████║\n" +
                    "██║  ██║██╔══██║╚██╗ ██╔╝██║██║  ██║    ██╔══██║██║╚██╗██║██║  ██║    ██║   ██║██║   ██║██║     ██║██╔══██║   ██║   ██╔══██║\n" +
                    "██████╔╝██║  ██║ ╚████╔╝ ██║██████╔╝    ██║  ██║██║ ╚████║██████╔╝    ╚██████╔╝╚██████╔╝███████╗██║██║  ██║   ██║   ██║  ██║\n" +
                    "╚═════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝╚═════╝     ╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝      ╚═════╝  ╚═════╝ ╚══════╝╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝\n" +
                    "                                                                                                                            ");
        System.out.println("\n1.게 임 시 작");
        System.out.println("2.카 드 도 감");
        System.out.println("3.선 물 도 감");
        System.out.println("4.종 료");
        int select;
        int story_select;
        Scanner scan= new Scanner(System.in);
        select=scan.nextInt();

            if (select == 1) {
                System.out.println("튜토리얼을 진행하시겠습니까?");
                System.out.println("1.네");
                System.out.println("2.아 니 요");
                select = scan.nextInt();
                if (select == 1) {
                    dungeon1.dunGeon1(0, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//40
                }
                if(select==1||select==2) {
                    story.story();
                    int x = 1;//enemy number

                    dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//40

                    if (my.hp > 0) {
                        x = 2;
                        dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//30,70
                        if (my.hp > 0) {
                            x = 3;
                            dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop,bgm);//40 80
                            if (my.hp > 0) {
                                x = 4;
                                dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//보스전 100(25~35)
                                if(my.hp>0) {
                                    story.story2();
                                    story_select = scan.nextInt();
                                    story.story3(my,story_select);
                                    if(story_select==1){//아드레날린:영구적으로 다윗의 에너지가 4가 됩니다.
                                        gift.gift(my,1);
                                    }else if(story_select==2){
                                        gift.gift(my,2);
                                    }else if(story_select==3){
                                        gift.gift(my,3);
                                    }
                                    x=5;
                                    dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//2-1 3마리 30.30.30.
                                    if(my.hp>0){
                                        x=6;
                                        dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//2-2 3마리 40 40 40
                                        if(my.hp>0){
                                            story.story4(my);
                                            story_select = scan.nextInt();
                                            while(true) {
                                                if (story_select == 1) {//2턴 동안 받는 피해가 0
                                                    gift.gift2(my,1);
                                                    break;
                                                } else if (story_select == 2) {//체력 모두 회복
                                                    gift.gift2(my,2);
                                                    break;
                                                }
                                            }
                                            story.story5(story_select,my);
                                            x=7;
                                            dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, shop, bgm);//골리앗
                                            if(my.hp>0){
                                                story.ending();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } else if (select == 2) {
                int select2;
                for(int i=1; i<=15; i++) {
                    my.card_destription(i);
                }
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 뒤로가기");
                while(true) {
                    select2 = scan.nextInt();
                    if (select2 == 0) {
                        break;
                    }
                }
            } else if (select == 3) {
                while(true) {
                    System.out.println("1.아드레날린 : 영구적으로 다윗의 에너지가 4가 됩니다.");
                    System.out.println("2.청동 갑옷 : 턴이 시작할 때마다 다윗의 방어도가 10 증가합니다.");
                    System.out.println("3.붉은 스카프 : 내 턴이 시작될때 HP를 5씩 회복합니다.");
                    System.out.println("4.황금갑옷 : 2턴 동안 방어도가 999가 됩니다.");
                    System.out.println("5.빨간포션 : 잃은 체력을 모두 회복합니다.");
                    System.out.println();
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 뒤로가기");
                    select = scan.nextInt();
                    if(select==0){
                        break;
                    }
                }


            } else if(select==4) {

                break;
            }else{
                System.out.println("잘못 입력된 값입니다.");
            }
        }
    }
}