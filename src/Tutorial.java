import java.util.Scanner;
public class Tutorial {
    public void tuTorial() {
        //1
        int select, select2, select3;
        Scanner scan = new Scanner(System.in);
        System.out.println("『손에 있는 카드를 사용하여 [적]들을 물리치십시오』");
        System.out.println();
        System.out.println("『카드를 사용하려면 [에너지]가 필요합니다.』");
        System.out.println("『낼 수 있는 카드가 없어지면, 턴을 종료하십시오.』");
        System.out.println();
        System.out.println("『당신의 턴이 시작될 때 새로운 카드들을 뽑고");
        System.out.println("에너지를 다시 채웁니다.』");
        System.out.println();
        System.out.println("『적의 우측에서 다음 턴에 진행될 적의 공격을 확인할 수 있습니다』");
        System.out.println("\n\n\n\n");
        System.out.println("◎                                                                   ▲(← 10)");
        System.out.println("(80/80)■■■■■■■■■■■■■■■" + "                              ■■■■■■■■■■■■■■■(30/30)");
        System.out.println("=========================================================================");
        System.out.println("【에너지:2/2】");
        System.out.println("【1.타격⑴ : 데미지 10을 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【3.수비⑴ : 방어도 8을 높인다.】\n【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
        System.out.println("\n타격과 강타를 쓰십시오.");
        do {
            select = scan.nextInt();
            if (select == 1) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 10)");
                System.out.println("(80/80)■■■■■■■■■■■■■■■" + "                                   ■■■■■■■■■■(20/30)");
                System.out.println("=========================================================================");
                System.out.println("                     [적에게 10 데미지를 입혔습니다!]\n\n");
                System.out.println("【에너지:1/2】");
                System.out.println("【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
                do{
                select = scan.nextInt();
                if (select == 3) {
                    System.out.println("\n\n\n\n");
                    System.out.println("◎                                                                   ▲(← 10)");
                    System.out.println("(80/80)■■■■■■■■■■■■■■■" + "                                   ■■■■■■■(13/30)");
                    System.out.println("=========================================================================");
                    System.out.println("                     [적에게 10 데미지를 입혔습니다!]\n\n");
                    System.out.println("【에너지:0/2】");
                    System.out.println("【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
                }else{
                    System.out.println("강타를 쓰십시오.");
                }
                }while(select!=3);
            } else if (select == 3) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 10)");
                System.out.println("(80/80)■■■■■■■■■■■■■■■" + "                                   ■■■■■■■■■■(22/30)");
                System.out.println("=========================================================================");
                System.out.println("                     [적에게 8 데미지를 입혔습니다!]\n\n");
                System.out.println("【에너지:1/2】");
                System.out.println("【1.타격⑴ : 데미지 10을 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】");

                do{
                    select=scan.nextInt();
                    if(select==1){
                        System.out.println("\n\n\n\n");
                        System.out.println("◎                                                                   ▲(← 10)");
                        System.out.println("(80/80)■■■■■■■■■■■■■■■" + "                                   ■■■■■■■(13/30)");
                        System.out.println("=========================================================================");
                        System.out.println("                     [적에게 10 데미지를 입혔습니다!]\n\n");
                        System.out.println("【에너지:0/2】");
                        System.out.println("【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
                    }else{
                        System.out.println("타격을 쓰십시오.");
                    }
                }while(select!=1);
            } else {
                System.out.println("타격과 강타를 쓰십시오.");
            }
        } while (select != 1 && select != 3);



        System.out.println("\n0을 눌러 턴을 종료하십시오");
        do {
            select = scan.nextInt();
            if (select == 0) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 15)");
                System.out.println("(70/80)■■■■■■■■■■■■■■" + "                                        ■■■■■■■(13/30)");
                System.out.println("=========================================================================");
                System.out.println("                      [적에게 10 데미지를 받았습니다...]\n\n");
                System.out.println("【에너지:2/2】");
                System.out.println("【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n【1.타격⑴ : 데미지 10을 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
                System.out.println();
                System.out.println("『다음 턴이 시작되면 패를 다섯 장 무작위로 다시 뽑습니다.』");
                System.out.println("『적들이 당신을 공격하려 하면, [수비]카드를 사용하여 [방어도]를 얻으십시오』");
                System.out.println("『[방어도]는 받는 공격피해를 줄여주지만, 당신의 다음 턴이 시작될 때 효과가 사라집니다.』");
            } else {
                System.out.println();
                System.out.println("0을 눌러 턴을 종료하십시오");
            }
        } while (select != 0);


        //방어도 튜토
        do {
            select = scan.nextInt();
            if (select == 2) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 15)");
                System.out.println("(70+8/80)■■■■■■■■■■■■■■" + "                                   ■■■■■■■(13/30)");
                System.out.println("=========================================================================");
                System.out.println("                      [방어도가 8 상승했습니다!]\n\n");
                System.out.println("【에너지:1/2】");
                System.out.println("【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n【1.타격⑴ : 데미지 10을 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】\n【2.수비⑴ : 방어도 8을 높인다.】");
            } else {
                System.out.println("『[수비]카드를 사용하여 [방어도]를 얻으십시오』");
            }
        } while (select != 2);
        /////////////
        do {
            select = scan.nextInt();
            if (select == 2) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 15)");
                System.out.println("(70+16/80)■■■■■■■■■■■■■■" + "                                   ■■■■■■■(13/30)");
                System.out.println("=========================================================================");
                System.out.println("                      [방어도가 8 상승했습니다!]\n\n");
                System.out.println("【에너지:0/2】");
                System.out.println("【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n【1.타격⑴ : 데미지 10을 입힌다.】\n【2.수비⑴ : 방어도 8을 높인다.】\nPress 0 to turn over...");
            } else {
                System.out.println("『[수비]카드를 사용하여 [방어도]를 얻으십시오』");
            }
        } while (select != 2);
        //////////////
        do {
            select = scan.nextInt();
            if (select == 0) {
                System.out.println("\n\n\n\n");
                System.out.println("◎                                                                   ▲(← 15)");
                System.out.println("(70/80)■■■■■■■■■■■■■■" + "                                   ■■■■■■■(13/30)");
                System.out.println("=========================================================================");
                System.out.println("                            [방어성공]");
            } else {
                System.out.println("0을 눌러 턴을 종료하십시오");
            }
        } while (select != 0);
        ////////////////

        System.out.println("\n\n\n\n\n");
        System.out.println("『이제 던전으로 나가 적을 끝까지 물리쳐보세요!』");
    }
}





