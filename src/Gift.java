public class Gift{

    public void gift(My my,int x){
        if(x==1){//아드레날린
            my.gift1=1;
        }else if(x==2){//청동갑옷
            my.gift2=2;
        }else if(x==3){//붉은스카프
            my.gift3=3;
        }
    }
    public void gift2(My my,int x){
        if(x==1){//황금갑옷
            my.gift2_1=1;
        }if(x==2){//최대체력 회복
            my.hp=80;
        }
    }

}
