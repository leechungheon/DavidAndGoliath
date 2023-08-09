
public class Enemy {
    int fhp;
    int hp;
    public int enemypower() {
        int atk = (int) (Math.random() * 11) + 15;
        return atk;
    }
    int atk_save = enemypower();
    public void enemyhp(){
        for(int i=0; i<15-15*hp/fhp; i++){
            System.out.print('□');
        }
        for(int i=0; i<15*hp/fhp; i++){
            System.out.print('■');
        }
        System.out.printf("(%d/%d)",hp,fhp);
    }
    public void enemyatk(My my){
        if(atk_save<my.defend){
            System.out.println("『방어성공』");
        }else{
            my.hp-=atk_save-my.defend;
        }
    }


}
