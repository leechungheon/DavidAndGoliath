public class Reward_1 {
    int card1, card2, card3;
    int gold1, gold2, gold3;

    public void reward(int x, My my, Card_list card_list) {//정수 값 1 받으면 리워드//0받으면 상점//0보다 작아지면 고정
        card1 = 0;
        card2 = 0;
        card3 = 0;

        if (x == 1) {
            my.gold += (int) (Math.random() * 41) + 80;//10이상 20이하 골드 획득
            System.out.printf("\t\t\t  ●%d골드 획득●\n\n", my.gold);//40~70골드
            System.out.println("\t\t\t●카드를 선택하세요●\n");
        }
        //카드 1 뽑기

            System.out.print("1.");
            //card1 내 카드에 없다면.
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

        if (x == 0) {//상점 - 카드 1 가격
            gold1 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold1);
        }
        //카드 2 뽑기

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


        if (x == 0) {//상점 - 카드 2 가격
            gold2 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold2);
        }

        //카드 3 뽑기

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
        if (x == 0) {//상점 - 카드 2 가격
            gold3 = (int) (Math.random() * 21) + 50;
            System.out.printf("▶%d 골드\n\n", gold3);
        }

    }
}

