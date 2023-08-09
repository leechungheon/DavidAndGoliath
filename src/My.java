public class My {
    int fhp;//풀HP
    int hp;//현재HP
    int gold;
    int defend=0;
    int energy;
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
                System.out.printf("【1.타격⑴: 적에게 데미지 10을 입힌다.】\n");
                break;
            case 2:
                System.out.printf("【2.수비⑴ : 방어도 8을 높인다.】\n");
                break;
            case 3:
                System.out.printf("【3.강타⑴ : 모든 적에게 8의 데미지를 입힌다.】\n");
                break;
            case 4:
                System.out.printf("【4.격돌⒪: 손에 있는 카드가 모두 공격카드 일때 데미지 14를 입힌다.】\n");
                break;
            case 5:
                System.out.printf("【5.혈류⑴: 체력을 2 잃고 데미지를 15 준다.】\n");
                break;
            case 6:
                System.out.printf("【6.몸통박치기⑴: 현재 방어도만큼의 데미지를 준다.】\n");
                break;
            case 7:
                System.out.printf("【7.어퍼컷⑵: 약화를 2 부여하고 데미지를 12 준다.】\n");
                break;
            case 8:
                System.out.printf("【8.위압⒪: 적 전체에게 약화를 1 부여한다.】\n");
                break;
            case 9:
                System.out.printf("【9.격노⒪: 이번 턴에 데미지를 줄 때마다 방어도가 3씩 증가한다.】\n");
                break;
            case 10:
                System.out.printf("【10.진정한 끈기⑴: 방어도를 7얻습니다. 무작위로 패 한장을 버립니다.】\n");
                break;
            case 100://turn over
                System.out.println("Press 0 to turn over...");
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
                card_destription(mydeck[i]);
        }
    }
    public void cardchoice(int x,Enemy enemy){
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
                    //쓴 카드 제거
                    int inithp=enemy.hp;
                    enemy.hp -= 10;
                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t『%d 데미지를 입혔습니다.』\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==1||mydeck[2]==1||mydeck[3]==1||mydeck[4]==1||mydeck[0]==1){//패에 카드를 가지고 있지만, 코스가 부족할 때
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n\n",energy);
                }else{
                    System.out.println("존재하지 않는 카드");
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
                    System.out.printf("\n\t\t\t\t\t\t『+8 방어력을 얻었습니다.』\n\n");
                }else if(mydeck[1]==2||mydeck[2]==2||mydeck[3]==2||mydeck[4]==2||mydeck[0]==2){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n\n",energy);
                }else{
                    System.out.println("존재하지 않는 카드");
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
                    int inithp=enemy.hp;
                    enemy.hp -= 8;
                    //적2에게 8데미지
                    //적3에게 8데미지
                    //적4에게 8데미지
                    energy--;
                    System.out.printf("\n\t\t\t\t\t\t『%d 데미지를 입혔습니다.』\n\n", inithp-enemy.hp);
                }else if(mydeck[1]==3||mydeck[2]==3||mydeck[3]==3||mydeck[4]==3||mydeck[0]==3){
                    System.out.printf("코스트가 부족합니다. 남은 코스트 : %d\n\n",energy);
                }else{
                    System.out.println("존재하지 않는 카드");
                }
                break;
            default:
                System.out.println("존재하지 않는 카드");
                break;
        }
    }


}
