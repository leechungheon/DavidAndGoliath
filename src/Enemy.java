
public class Enemy {
    int hp;
    int fhp;
    int atk;
    int weak;



    public int enemypower() {//적 다음턴 공격력 랜덤 출력
         atk = (int) (Math.random() * 11) + 10;
        return atk;
    }
    public int bosspower() {//적 다음턴 공격력 랜덤 출력
        atk = (int) (Math.random() * 11) + 25;
        return atk;
    }
    int atk_save = enemypower();
    public void enemyhp(){//적 체력바 출력
        for(int i=0; i<15-15*hp/fhp; i++){
            System.out.print('□');
        }
        for(int i=0; i<15*hp/fhp; i++){
            System.out.print('■');
        }
        System.out.printf("(%d/%d)",hp,fhp);
    }
    public void enemyatk(My my){//적 공격 성공실패 출력
        if(weak>0) {
            if (atk_save*0.6 < my.defend) {
                System.out.println("『적의 공격에 방어를 성공했습니다.』");
            } else {
                my.hp -= (int)(atk_save*0.6) - my.defend;
            }
            weak--;
        }else{
            if (atk_save < my.defend) {
                System.out.println("『적의 공격에 방어를 성공했습니다.』");
            } else {
                my.hp -= atk_save - my.defend;
            }
        }
    }


}
