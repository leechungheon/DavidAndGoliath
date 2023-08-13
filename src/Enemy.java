
public class Enemy {
    int hp;
    int fhp;
    int atk;
    int weak;
    String [] enemy_name=new String[4];


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
            } else {
                my.hp -= (int)(atk_save*0.6) - my.defend;
            }
            weak--;
        }else{
            if (atk_save < my.defend) {
            } else {
                my.hp -= atk_save - my.defend;
            }
        }
    }


}
