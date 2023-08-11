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
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card1);
        }else if(x==2) {
            mycard[reward1.card2] = reward1.card2;
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card2);
        }else {
            mycard[reward1.card3] = reward1.card3;
            System.out.printf("%d번 카드가 추가 되었습니다.\n", reward1.card3);
        }
        int count=0;
        for(int i=0; i<100; i++){//존재하는 카드들만 추출 사이 버퍼 없애기
            if(mycard[i]!=0){
                mycard_y[count]=mycard[i];
                count++;
            }
        }
    }
    public void mycard_minus(int x,Reward_1 reward1){//손 패
            mycard[x] = 0;
            System.out.printf("%d번 카드가 제거 되었습니다.\n", x);
        int count=0;
        for(int i=0; i<100; i++){//존재하는 카드들만 추출
            if(mycard_y[i]==x){
                mycard_y[i]=0;
            }
        }
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
                System.out.printf("【4번 카드】 격돌⒪: 손에 있는 카드가 모두 공격카드 일때 데미지 14를 입힌다.\n");
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
                System.out.printf("【9번 카드】 격노⒪: 이번 턴에 데미지를 줄 때마다 방어도가 3씩 증가한다.\n");
                break;
            case 10:
                System.out.printf("【10번 카드】 진정한 끈기⑴: 방어도를 7얻습니다. 무작위로 패 한장을 버립니다.\n");
                break;
            case 100://turn over
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0을 눌러 턴을 종료");
                break;
        }
    }
    public void mydeck(int x){//덱 mycard의 카드들을 무작위로 5장 뽑기
        int count=0;
        mydeck[5]=100;
        mycard();//저장된 내 카드 호출
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
    public void cardchoice(int x,Enemy enemy,Enemy enemy2,Enemy enemy3,Enemy enemy4){
        switch(x){
            case 0: //turn over
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
                        atk=13;
                        power--;
                    }else{
                        atk=10;
                    }

                    if(x>2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();



                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
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
                        System.out.println("==============================================================================");
                        System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==1||mydeck[2]==1||mydeck[3]==1||mydeck[4]==1||mydeck[0]==1){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
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
                    System.out.println("==============================================================================");
                    System.out.printf("\n\t\t\t\t\t\t 『+8 방어력을 얻었습니다.』\n\n\n\n");
                }else if(mydeck[1]==2||mydeck[2]==2||mydeck[3]==2||mydeck[4]==2||mydeck[0]==2){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
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
                        atk=11;
                        power--;
                    }else{
                        atk=8;
                    }
                    enemy.hp -= atk;
                    enemy2.hp -= atk;
                    enemy3.hp -= atk;
                    enemy4.hp -= atk;
                    energy--;
                    System.out.println("==============================================================================");
                    System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }
                break;
            case 4://천둥
                if(energy>=1&&mydeck[1]==3||energy>=1&&mydeck[2]==3||energy>=1&&mydeck[3]==3||energy>=1&&mydeck[4]==3||energy>=1&&mydeck[0]==3) {//카드 사용후 제거
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
                    int inithp=enemy.hp;
                    int inithp2=enemy2.hp;
                    int inithp3=enemy3.hp;
                    int inithp4=enemy4.hp;
                    enemy.hp -= 4;
                    enemy2.hp -= 4;
                    enemy3.hp -= 4;
                    enemy4.hp -= 4;
                    power=2;

                    energy--;
                    System.out.println("==============================================================================");
                    System.out.printf("\n\t\t\t\t\t\t 『모든 적에게 %d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }
            case 5://혈류
                if(energy>=1&&mydeck[1]==3||energy>=1&&mydeck[2]==3||energy>=1&&mydeck[3]==3||energy>=1&&mydeck[4]==3||energy>=1&&mydeck[0]==3) {//카드 사용후 제거
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
                    int choice;
                    int inithp;
                    int intimyhp;
                    int atk;
                    if(power>0){
                        atk=20;
                        power--;
                    }else{
                        atk=15;
                    }

                    System.out.println("몇 번 적을 공격하시겠습니까?");
                    if(x>2) {//적이 둘 이상일때
                      while(true) {
                          Scanner scan = new Scanner(System.in);
                          choice = scan.nextInt();
                          if (choice == 1) {
                              inithp = enemy.hp;
                              enemy.hp -= atk;
                              if (defend >= 2) {
                                  defend -= 2;
                              } else {
                                  defend = 0;
                                  hp -= defend - 2;
                              }
                              energy--;
                              System.out.println("==============================================================================");
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy.hp);
                          } else if (choice == 2) {
                              inithp = enemy2.hp;
                              energy--;
                              System.out.println("==============================================================================");
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy2.hp);
                              enemy2.hp -= atk;
                              if (defend >= 2) {
                                  defend -= 2;
                              } else {
                                  defend = 0;
                                  hp -= defend - 2;
                              }
                          } else if (choice == 3&&x>=3) {
                              inithp = enemy3.hp;
                              enemy3.hp -= atk;
                              if (defend >= 2) {
                                  defend -= 2;
                              } else {
                                  defend = 0;
                                  hp -= defend - 2;
                              }
                              energy--;
                              System.out.println("==============================================================================");
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy3.hp);
                          } else if (choice == 4&&x>=4) {
                              inithp = enemy4.hp;
                              enemy4.hp -= atk;
                              if (defend >= 2) {
                                  defend -= 2;
                              } else {
                                  defend = 0;
                                  hp -= defend - 2;
                              }
                              energy--;
                              System.out.println("==============================================================================");
                              System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, choice, inithp - enemy4.hp);
                          } else {
                              System.out.println("존재하지 않는 적입니다.");
                          }
                      }
                    }else{
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        if (defend >= 2) {
                            defend -= 2;
                        } else {
                            defend = 0;
                            hp -= defend - 2;
                        }
                        energy--;
                        System.out.println("==============================================================================");
                        System.out.printf("\n\t\t\t\t\t\t 『피해를 %d입고 적에게 %d 데미지를 입혔습니다.』\n\n\n\n", defend - 2, inithp - enemy.hp);

                    }

                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }
                break;
            case 6://몸통박치기
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
                        atk=(int)(defend*1.3);
                        power--;
                    }else{
                        atk=defend;
                    }

                    if(x>2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();


                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                System.out.println("==============================================================================");
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
                        System.out.println("==============================================================================");
                        System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==1||mydeck[2]==1||mydeck[3]==1||mydeck[4]==1||mydeck[0]==1){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }

                break;
            case 7://어퍼컷
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
                        atk=16;
                        power--;
                    }else{
                        atk=12;
                    }



                    if(x>2) {//적이 둘 이상일때
                        while(true) {
                            System.out.println("몇 번 적을 공격하시겠습니까?");
                            Scanner scan = new Scanner(System.in);
                            choice = scan.nextInt();


                            if (choice == 1) {
                                inithp = enemy.hp;
                                enemy.hp -= atk;
                                energy--;
                                enemy.weak+=2;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy.hp);
                                break;
                            } else if (choice == 2) {
                                inithp = enemy2.hp;
                                enemy2.hp -= atk;
                                energy--;
                                enemy2.weak+=2;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy2.hp);
                                break;
                            } else if (choice == 3 && x >= 3) {
                                inithp = enemy3.hp;
                                enemy3.hp -= atk;
                                energy--;
                                enemy3.weak+=2;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy3.hp);
                                break;
                            } else if (choice == 4 && x >= 4) {
                                inithp = enemy4.hp;
                                enemy4.hp -= atk;
                                energy--;
                                enemy4.weak+=2;
                                System.out.println("==============================================================================");
                                System.out.printf("\n\t\t\t\t\t\t 『적%d에게 취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n", choice, inithp - enemy4.hp);
                                break;
                            } else {
                                System.out.println("존재하지 않는 적입니다.");
                            }
                        }

                    }else{//적이 하나라면
                        inithp = enemy.hp;
                        enemy.hp -= atk;
                        energy--;
                        System.out.println("==============================================================================");
                        System.out.printf("\n\t\t\t\t\t\t 『취약+2와 %d 데미지를 입혔습니다.』\n\n\n\n",inithp - enemy.hp);
                    }
                    /////
                }else if(mydeck[1]==1||mydeck[2]==1||mydeck[3]==1||mydeck[4]==1||mydeck[0]==1){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }

                break;
            case 8://위압
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

                    enemy.weak +=1;
                    enemy2.weak +=1;
                    enemy3.weak +=1;
                    enemy4.weak +=1;
                    energy--;

                    System.out.println("==============================================================================");
                    System.out.printf("\n\t\t\t\t\t\t 『%d 데미지를 입혔습니다.』\n\n\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n",energy);
                    System.out.println("==============================================================================\n\n\n\n");
                }else{
                    System.out.println("존재하지 않는 카드");
                    System.out.println("==============================================================================\n\n\n\n");
                }
                break;
            default:
                System.out.println("존재하지 않는 카드");
                System.out.println("==============================================================================\n\n\n\n");
                break;
        }
    }


}
