public class Gift extends My{

    public void gift(int x){
        if(x==1){//아드레날린
            gift1=1;
        }else if(x==2){//청동갑옷
            gift2=2;
        }else if(x==3){//붉은스카프
            gift3=3;
        }
    }
    public void gift2(int x){
        if(x==1){//hp회복
            hp += (int) ((fhp - hp) / 2);
        }else if(x==2){//공격력 상승
            power += 999;
        }
    }

}
