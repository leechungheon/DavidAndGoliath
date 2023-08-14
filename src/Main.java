import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int select;
        int story_select;
        Tutorial tutorial=new Tutorial();
        Card_list cardlist=new Card_list();
        Artifact_list artifactlist=new Artifact_list();
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
        System.out.println("3.괴 물 도 감");
        System.out.println("4.종 료");
        Scanner scan= new Scanner(System.in);
        select=scan.nextInt();

            if (select == 1) {
                story.story();
                System.out.println("튜토리얼을 진행하시겠습니까?");
                System.out.println("1.네");
                System.out.println("2.아 니 요");
                select = scan.nextInt();
                if (select == 1) {
                    dungeon1.dunGeon1(0, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//40
                }
                if(select==1||select==2) {
                    int x = 1;//enemy number
                    dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//40
                    if (my.hp > 0) {
                        x = 2;
                        dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//30,70
                        if (my.hp > 0) {
                            x = 3;
                            dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//40 80
                            if (my.hp > 0) {
                                x = 4;
                                dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//보스전 100(25~35)
                                if(my.hp>0) {
                                    story.story2();
                                    story_select = scan.nextInt();
                                    story.story3(story_select);
                                    if(story_select==1){//아드레날린:영구적으로 다윗의 에너지가 4가 됩니다.
                                        gift.gift(1);
                                    }else if(story_select==2){
                                        gift.gift(2);
                                    }else if(story_select==3){
                                        gift.gift(3);
                                    }
                                    x=5;
                                    dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//2-1 3마리 30.30.30.
                                    if(my.hp>0){
                                        x=6;
                                        dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//2-2 3마리 40 40 40
                                        if(my.hp>0){
                                            story.story4(my);
                                            story_select = scan.nextInt();
                                            while(true) {
                                                if (story_select == 1) {//잃은 체력의 절반을 회복
                                                    gift.gift2(1);
                                                    break;
                                                } else if (story_select == 2) {
                                                    gift.gift2(2);
                                                    break;
                                                }
                                            }
                                            story.story5(story_select,my);
                                            x=7;
                                            dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//골리앗
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
                for(int i=1; i<=10; i++) {
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
                artifactlist.artifactList();

            } else if(select==4) {

                break;
            }else{
                System.out.println("잘못 입력된 값입니다.");
            }
        }
    }
}