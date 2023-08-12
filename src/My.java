import java.util.Scanner;
public class My {
    int fhp;//풀HP
    int hp;//현재HP
    int gold;
    int defend=0;
    int energy;
    int power;//취약시 30%데미지 추가

    int[] mycard=new int[101];//내 소유 전체 카드
    int[] mycard_y=new int[101];//빈공간 제외한 내 카드
    int[] mydeck=new int[6];//5장 뽑음

    public void myhp() {
        System.out.printf("(%d+%d/%d)",fhp,defend, hp);
        for(int i=0; i<15*hp/fhp; i++){
            System.out.print('■');
        }
        for(int i=0; i<15-15*hp/fhp; i++){
            System.out.print('□');
        }
    }


    public void mycard(){//초기 카드, 한번만 사용
        mycard[100]=100;
        mycard[0]=0;
        mycard[1]=1;
        mycard[2]=2;
        mycard[3]=3;
        for(int i=0; i<100; i++) {
            mycard_y[i]=0;
        }

    }
    public void mycard_plus(int x,Reward_1 reward1){//손 패
        if(x==1) {
            mycard[reward1.card1] = reward1.card1;
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card1);//ex)mycard[8]=8;
        }else if(x==2) {
            mycard[reward1.card2] = reward1.card2;
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card2);
        }else {
            mycard[reward1.card3] = reward1.card3;
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card3);
        }
        int count=0;
        for(int i=0; i<100; i++){//존재하는 카드들만 추출 &사이 버퍼 없애기
            if(mycard[i]!=0){//마이카드에 카드가 있다면
                mycard_y[count]=mycard[i];
                count++;
            }
        }
    }
    public void mycard_minus(int x,Reward_1 reward1) {//손 패
        mycard[x] = 0;
        System.out.printf("%d번 카드가 제거 되었습니다.\n", x);
        int count = 0;
        for (int i = 0; i < 100; i++) {//존재하는 카드들만 추출
            if (mycard_y[i] == x) {
                mycard_y[i] = 0;
            }
        }
        for (int i = 0; i < 100; i++) {
            mycard_y[i]=0;
        }
        System.out.println();
    }
    public void card_destription(int x){//덱
        switch(x){

            case 1:
                System.out.printf("【1번 카드】 타격⑴: 적에게 데미지 10을 입힌다.\n");
                break;
            case 2:
                System.out.printf("【2번 카드】 수비⑴: 방어도 8을 높인다.\n");
                break;
            case 3:
                System.out.printf("【3번 카드】 강타⑴: 모든 적에게 8의 데미지를 입힌다.\n");
                break;
            case 4:
                System.out.printf("【4번 카드】 천둥⑴: 모든 적에게 데미지 4를 주고 취약 1을 부여한다.\n");
                break;
            case 5:
                System.out.printf("【5번 카드】 혈류⑴: 체력을 2 잃고 데미지를 15 준다.\n");
                break;
            case 6:
                System.out.printf("【6번 카드】 몸통박치기⑴: 현재 방어도만큼의 데미지를 준다.\n");
                break;
            case 7:
                System.out.printf("【7번 카드】 어퍼컷⑵: 약화를 2 부여하고 데미지를 12 준다.\n");
                break;
            case 8:
                System.out.printf("【8번 카드】 위압⒪: 적 전체에게 약화를 1 부여한다.\n");
                break;
            case 9:
                System.out.printf("【9번 카드】 철의파동⑴: 데미지 5를 주고 방어도 5를 얻습니다.\n");
                break;
            case 10:
                System.out.printf("【10번 카드】 소용돌이⑶: 모든 적들에게 피해를 [10,15,20] 중 무작위로 입힙니다.\n");
                break;
            case 100://turn over
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 턴을 종료");
                System.out.println("==============================================================================");
                break;
        }
    }
    public void mydeck(int x){//덱 mycard의 카드들을 무작위로 5장 뽑기
        int count=0;
        mydeck[5]=100;//종료 위함
        //마이카드 메소드삭제함
        for(int i=0; i<100; i++){//존재하는 카드들만 추출
            if(mycard[i]!=0){
                mycard_y[count]=mycard[i];
                count++;
            }
        }
        if(x==0) {//정수형 변수를 받으면 패 다시 뽑음
            for (int i = 0; i < 5; i++) {//존재하는 카드에서 5개 무작위 호출
                mydeck[i] = mycard_y[(int) (Math.random() * count)];
            }
        }
        for(int i=0; i<6; i++){
            if(mydeck[i]!=0) {
                card_destription(mydeck[i]);
            }else{
                System.out.println("【빈 슬롯】");
            }
        }
    }
    public void cardchoice(int select,int x,Enemy enemy,Enemy enemy2,Enemy enemy3,Enemy enemy4){
        switch(select){
            case 0: //turn over
                System.out.println("\t\t\t\t\t\t\t\t\uD83D\uDD14턴 종료\uD83D\uDD14");
                break;
            case 1://타격
                if(energy>=1&&mydeck[1]==1||energy>=1&&mydeck[2]==1||energy>=1&&mydeck[3]==1||energy>=1&&mydeck[4]==1||energy>=1&&mydeck[0]==1) {
                    //에너지가 충분하고, 내가 패에 카드를 가지고 있다면 실행
                    if(mydeck[1]==1){
                        mydeck[1]=0;
                    }else if(mydeck[2]==1){
                        mydeck[2]=0;
                    }else if(mydeck[3]==1){
                        mydeck[3]=0;
                    }else if(mydeck[4]==1){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    ///////반복시작
                    int choice;
                    int inithp;
                    int intimyhp;
                    int atk;
                    if(power>0){
                        atk=(int)(10*1.3);
                        power--;
                    }else{
                        atk=10;
                    }

                    if(x>=2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();



                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy4.hp);
                                break;
                            } else {
                                System.out.println("존재하지 않는 적입니다.");
                            }
                        }

                    }else{//적이 하나라면
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        energy--;
                        System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==1||mydeck[2]==1||mydeck[3]==1||mydeck[4]==1||mydeck[0]==1){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }

                break;
            case 2://수비
                if(energy>=1&&mydeck[1]==2||energy>=1&&mydeck[2]==2||energy>=1&&mydeck[3]==2||energy>=1&&mydeck[4]==2||energy>=1&&mydeck[0]==2) {
                    if(mydeck[1]==2){
                        mydeck[1]=0;
                    }else if(mydeck[2]==2){
                        mydeck[2]=0;
                    }else if(mydeck[3]==2){
                        mydeck[3]=0;
                    }else if(mydeck[4]==2){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    defend+=8;
                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t 『+8 방어력을 얻었습니다.』\n\n\n\n");
                }else if(mydeck[1]==2||mydeck[2]==2||mydeck[3]==2||mydeck[4]==2||mydeck[0]==2){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                break;
            case 3://강타
                if(energy>=1&&mydeck[1]==3||energy>=1&&mydeck[2]==3||energy>=1&&mydeck[3]==3||energy>=1&&mydeck[4]==3||energy>=1&&mydeck[0]==3) {
                    if(mydeck[1]==3){
                        mydeck[1]=0;
                    }else if(mydeck[2]==3){
                        mydeck[2]=0;
                    }else if(mydeck[3]==3){
                        mydeck[3]=0;
                    }else if(mydeck[4]==3){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    int inithp;
                    inithp=enemy.hp;
                    int atk;
                    if(power>0){
                        atk=(int)(8*1.3);
                    }else{
                        atk=8;
                    }
                    enemy.hp -= atk;
                    enemy2.hp -= atk;
                    enemy3.hp -= atk;
                    enemy4.hp -= atk;
                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                break;
            case 4://천둥
                if(energy>=1&&mydeck[1]==4||energy>=1&&mydeck[2]==4||energy>=1&&mydeck[3]==4||energy>=1&&mydeck[4]==4||energy>=1&&mydeck[0]==4) {//카드 사용후 제거
                    if(mydeck[1]==4){
                        mydeck[1]=0;
                    }else if(mydeck[2]==4){
                        mydeck[2]=0;
                    }else if(mydeck[3]==4){
                        mydeck[3]=0;
                    }else if(mydeck[4]==4){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    //
                    int inithp=enemy.hp;
                    int atk;
                    if(power>0){
                        atk=(int)(4*1.3);
                    }else{
                        atk=4;
                    }

                    enemy.hp -= atk;
                    enemy2.hp -= atk;
                    enemy3.hp -= atk;
                    enemy4.hp -= atk;

                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t 『모든 적에게 취약+1 과 %d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==4||mydeck[2]==4||mydeck[3]==4||mydeck[4]==4||mydeck[0]==4){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                power+=1;
                break;
            case 5://혈류
                if(energy>=1&&mydeck[1]==5||energy>=1&&mydeck[2]==5||energy>=1&&mydeck[3]==5||energy>=1&&mydeck[4]==5||energy>=1&&mydeck[0]==5) {//카드 사용후 제거
                    if(mydeck[1]==5){
                        mydeck[1]=0;
                    }else if(mydeck[2]==5){
                        mydeck[2]=0;
                    }else if(mydeck[3]==5){
                        mydeck[3]=0;
                    }else if(mydeck[4]==5){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    int choice;
                    int inithp;
                    int intimyhp;
                    int atk;
                    if(power>0){
                        atk=(int)(15*1.3);
                    }else{
                        atk=15;
                    }

                    System.out.println("몇 번 적을 공격하시겠습니까?");
                    if(x>=2) {//적이 둘 이상일때
                      while(true) {
                          Scanner scan = new Scanner(System.in);
                          choice = scan.nextInt();
                          if (choice == 1) {
                              inithp = enemy.hp;
                              enemy.hp -= atk;
                              hp-=2;
                              energy--;
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy.hp);
                              break;
                          } else if (choice == 2) {
                              inithp = enemy2.hp;
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy2.hp);
                              enemy2.hp -= atk;
                              hp-=2;
                              energy--;
                              break;
                          } else if (choice == 3&&x>=3) {
                              inithp = enemy3.hp;
                              enemy3.hp -= atk;
                              hp-=2;
                              energy--;
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", 2, choice, inithp - enemy3.hp);
                              break;
                          } else if (choice == 4&&x>=4) {
                              inithp = enemy4.hp;
                              enemy4.hp -= atk;
                              hp-=2;
                              energy--;
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", 2, choice, inithp - enemy4.hp);
                              break;
                          } else {
                              System.out.println("존재하지 않는 적입니다.");
                          }
                      }
                    }else{
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        hp-=2;
                        energy--;
                        System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적에게 %d 데미지를 입혔습니다.』\n\n\n\n", 2, inithp - enemy.hp);

                    }

                }else if(mydeck[1]==5||mydeck[2]==5||mydeck[3]==5||mydeck[4]==5||mydeck[0]==5){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                break;
            case 6://몸통박치기
                if(energy>=1&&mydeck[1]==6||energy>=1&&mydeck[2]==6||energy>=1&&mydeck[3]==6||energy>=1&&mydeck[4]==6||energy>=1&&mydeck[0]==6) {
                    //에너지가 충분하고, 내가 패에 카드를 가지고 있다면 실행
                    if(mydeck[1]==6){
                        mydeck[1]=0;
                    }else if(mydeck[2]==6){
                        mydeck[2]=0;
                    }else if(mydeck[3]==6){
                        mydeck[3]=0;
                    }else if(mydeck[4]==6){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    ///////반복시작
                    int choice;
                    int inithp;
                    int atk;
                    if(power>0){
                        atk=(int)(defend*1.3);
                    }else{
                        atk=defend;
                    }

                    if(x>=2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();


                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy4.hp);
                                break;
                            } else {
                                System.out.println("존재하지 않는 적입니다.");
                            }
                        }

                    }else{//적이 하나라면
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        energy--;
                        System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==6||mydeck[2]==6||mydeck[3]==6||mydeck[4]==6||mydeck[0]==6){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }

                break;
            case 7://어퍼컷
                if(energy>=2&&mydeck[1]==7||energy>=2&&mydeck[2]==7||energy>=2&&mydeck[3]==7||energy>=2&&mydeck[4]==7||energy>=2&&mydeck[0]==7) {
                    //에너지가 충분하고, 내가 패에 카드를 가지고 있다면 실행
                    if(mydeck[1]==7){
                        mydeck[1]=0;
                    }else if(mydeck[2]==7){
                        mydeck[2]=0;
                    }else if(mydeck[3]==7){
                        mydeck[3]=0;
                    }else if(mydeck[4]==7){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    ///////반복시작
                    int choice;
                    int inithp;
                    int intimyhp;
                    int atk;
                    if(power>0){
                        atk=(int)(12*1.3);
                        power--;
                    }else{
                        atk=12;
                    }



                    if(x>=2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();


                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy-=2;
                                enemy.weak+=2;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy-=2;
                                enemy2.weak+=2;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy-=2;
                                enemy3.weak+=2;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy-=2;
                                enemy4.weak+=2;
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy4.hp);
                                break;
                            } else {
                                System.out.println("존재하지 않는 적입니다.");
                            }
                        }

                    }else{//적이 하나라면
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        energy-=2;
                        System.out.printf("\n\t\t\t\t\t\t 『취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==7||mydeck[2]==7||mydeck[3]==7||mydeck[4]==7||mydeck[0]==7){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }

                break;
            case 8://위압
                if(energy>=1&&mydeck[1]==8||energy>=1&&mydeck[2]==8||energy>=1&&mydeck[3]==8||energy>=1&&mydeck[4]==8||energy>=1&&mydeck[0]==8) {
                    if(mydeck[1]==8){
                        mydeck[1]=0;
                    }else if(mydeck[2]==8){
                        mydeck[2]=0;
                    }else if(mydeck[3]==8){
                        mydeck[3]=0;
                    }else if(mydeck[4]==8){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }

                    enemy.weak +=1;
                    enemy2.weak +=1;
                    enemy3.weak +=1;
                    enemy4.weak +=1;
                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t 『적에게 약화+1 을 부여했습니다.』\n\n\n\n");
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                break;
            case 9://철의파동
                if(energy>=2&&mydeck[1]==9||energy>=2&&mydeck[2]==9||energy>=2&&mydeck[3]==9||energy>=2&&mydeck[4]==9||energy>=2&&mydeck[0]==9) {
                    //에너지가 충분하고, 내가 패에 카드를 가지고 있다면 실행
                    if(mydeck[1]==9){
                        mydeck[1]=0;
                    }else if(mydeck[2]==9){
                        mydeck[2]=0;
                    }else if(mydeck[3]==9){
                        mydeck[3]=0;
                    }else if(mydeck[4]==9){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    ///////반복시작
                    int choice;
                    int inithp;
                    int atk;
                    if(power>0){
                        atk=(int)(5*1.3);
                        power--;
                    }else{
                        atk=5;
                    }
                    defend+=5;



                    if(x>=2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();


                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『방어도 5를 얻고 적%d 에게 데미지 %d를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『방어도 5를 얻고 적%d 에게 데미지 %d를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『방어도 5를 얻고 적%d 에게 데미지 %d를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                System.out.printf("\n\t\t\t\t\t\t 『방어도 5를 얻고 적%d 에게 데미지 %d를 입혔습니다.』\n\n\n\n", choice, inithp - enemy4.hp);
                                break;
                            } else {
                                System.out.println("존재하지 않는 적입니다.");
                            }
                        }

                    }else{//적이 하나라면
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        energy--;
                        System.out.printf("\n\t\t\t\t\t\t 『취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==7||mydeck[2]==7||mydeck[3]==7||mydeck[4]==7||mydeck[0]==7){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }

                break;
            case 10://소용돌이
                if(energy>=3&&mydeck[1]==10||energy>=3&&mydeck[2]==10||energy>=3&&mydeck[3]==10||energy>=3&&mydeck[4]==10||energy>=3&&mydeck[0]==10) {
                    if(mydeck[1]==10){
                        mydeck[1]=0;
                    }else if(mydeck[2]==10){
                        mydeck[2]=0;
                    }else if(mydeck[3]==10){
                        mydeck[3]=0;
                    }else if(mydeck[4]==10){
                        mydeck[4]=0;
                    }else{
                        mydeck[0]=0;
                    }
                    int inithp;
                    inithp=enemy.hp;

                    int atk=(int)(Math.random()*3)+1;
                    if(power>0){
                        atk*=(int)(atk*1.3);
                    }else{

                    }
                    enemy.hp -= atk;
                    enemy2.hp -= atk;
                    enemy3.hp -= atk;
                    enemy4.hp -= atk;
                    energy-=3;
                    System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("\n\n\n\n");
                }
                if(power>0){
                    power--;
                }
                break;
            default:
                System.out.println("존재하지 않는 카드");
                System.out.println("\n\n\n\n");
                break;
        }
    }


}
