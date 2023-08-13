import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int select;
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
        System.out.println("3.유 물 도 감");
        System.out.println("4.종 료");
        Scanner scan= new Scanner(System.in);
        select=scan.nextInt();

            if (select == 1) {
                System.out.println("튜토리얼을 진행하시겠습니까?");
                System.out.println("1.네");
                System.out.println("2.아 니 요");
                select = scan.nextInt();
                if (select == 1) {
                    tutorial.tuTorial();
                } else {
                    int x=1;//enemy number
                    dungeon1.dunGeon1(x,my,enemy,enemy2, enemy3,enemy4,reward_1,cardlist,shop);//40 (15~25)
                    if(my.hp>0) {
                        x = 2;
                        dungeon1.dunGeon1(x, my, enemy, enemy2, enemy3, enemy4, reward_1, cardlist, shop);//30,70
                        if(my.hp>0){
                            x=3;
                            dungeon1.dunGeon1(x,my,enemy,enemy2, enemy3,enemy4,reward_1,cardlist,shop);//보스전 100(25~35)
                        }
                    }
                }
            } else if (select == 2) {

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