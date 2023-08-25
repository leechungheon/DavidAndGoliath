import java.util.Scanner;
import javax.swing.JOptionPane;
public class Story extends Thread{
    int msg_num;
    public static boolean inputCheck = false;
    int gift_choose;
    Scanner scan=new Scanner(System.in);
    public void run() {//run 메소드
        if(msg_num==0) {
            String sentence = "그 신비한 땅 엘라에서 오래된 전투가 곧 펼쳐질 예정입니다. . . . .";
            for (char c : sentence.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(100); // 글자 출력 후 잠시 멈춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(msg_num==1){
            String sentence = "선물을 선택하십시오.\n1.아드레날린 : 영구적으로 다윗의 에너지가 4가 됩니다.\n2.청동 갑옷 : 턴이 시작할 때마다 다윗의 방어도가 10 증가합니다.\n3.붉은 스카프 : 내 턴이 시작될때 HP를 5씩 회복합니다.\n";
            for (char c : sentence.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(100); // 글자 출력 후 잠시 멈춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(msg_num==2){
            String sentence = "1.황금갑옷 : 2턴 동안 방어도가 999가 됩니다.\n2.빨간포션 : 잃은 체력을 모두 회복합니다.\n";
            for (char c : sentence.toCharArray()) {
                System.out.print(c);
                try {
                    Thread.sleep(100); // 글자 출력 후 잠시 멈춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(msg_num==3){
            String[] sentence = new String[7];
            sentence[0] = "마침내 다윗은 골리앗을 쓰러뜨렸습니다.\n\n";
            sentence[1] = "그리고 골리앗은 땅바닥에 얼굴을 박고 쓰러졌습니다.\n\n";
            sentence[2] = "다윗의 승리는 모든 이들에게 큰 용기와 희망을 안겨주었습니다.\n\n";
            sentence[3] = "그의 용기와 믿음은 사람들에게 이기적인 힘만이 아닌 올바른 길을 선택하고 신뢰하는 것의 중요성을 상기시켰습니다.\n\n";
            sentence[4] = "골리앗을 물리침으로써 다윗은 이스라엘 사람들을 지켜내었고, 황폐해진 루엘은 점차 본래 모습을 되찾아갔습니다.\n\n";
            sentence[5] = "이 역사적인 대결의 결말에서, 작은 소년의 역사가 하늘에 새겨졌습니다.\n\n";
            sentence[6] = "이 승리는 용기와 결단력으로 가득찬 미래를 예고하며, 그의 이름은 영원한 영웅으로 기록될 것입니다. \n\n";


            for (int i=0; i<7; i++) {
                System.out.print(sentence[i]);
                try {
                    Thread.sleep(2000); // 글자 출력 후 잠시 멈춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public void story(){
        Story th1 = new Story();
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("엘라라는 신비한 땅에 무서운 거인 \'골리앗\'이 이끄는 \'블레셋족\'들이 있었습니다.");
        System.out.println("\'블레셋족\'은 엘라의 또 다른 백성들인 \'이스라엘 백성\'들이 엘라에 도움이 되지 못한다고 생각했습니다. ");
        System.out.println("그 결과 \'블레셋족\'들과 \'이스라엘 백성\' 사이에 갈등이 빚어졌고 결국 \'블레셋\'쪽에서 전쟁 선포를 하게 되었습니다.");
        System.out.println();
        System.out.println("하지만, 이스라엘 백성은 \'거인 골리앗\'이 이끄는 \'블레셋족\'들의 거대한 몸집과 힘 때문에 곤경에 처해 있습니다.");
        System.out.println("모두가 겁을 먹고 있던 그 때 \'다윗\'이라는 젊고 대담한 양치기 소년이 우똑 솟은 위협에 맞서기로 결심하고 앞으로 나섭니다.");
        System.out.println();
        System.out.println("아침 해가 전장에 금빛 빛을 드리울 때, \'블레셋 대군\'이 건너편 넓은 들판에 모입니다.");
        System.out.println("그리고 당당한 갑옷을 입고 거대한 검을 휘두르는 \'골리앗\'이 블레셋 군대의 후미에 서 있습니다.");
        System.out.println("반대편에는 나무 막대기와 가죽갑옷으로 무장한 \'다윗\'이 \'이스라엘 사람\'의 예상치 못한 챔피언으로 서 있습니다.\n");
        System.out.println();
        msg_num=0;
        th1.start();//System.out.println("그 신비한 땅 엘라에서 오래된 전투가 곧 펼쳐질 예정입니다. . . . .");
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n\n");
    }
    public void story2(){
        String select_string;
        System.out.println("\n\n\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("\'거인 골리앗\'의 애완용인 \'모르고스\'를 물리치고 한 차례 전투가 끝이 났습니다.");
        System.out.println("자신의 애완용을 죽인 다윗에게 분노한 \'골리앗\'은 \'블레셋\'족들과 함께 다윗을 직접 처리하러 나섭니다.");
        System.out.println();
        System.out.println("그 사이 \'다윗\'은 한 차례 전투가 끝난 후 체력을 회복했습니다.");
        System.out.println("그때 다윗의 전투에 감동받은 \'이스라엘 사람들\'이 다윗에게 서둘러 다가옵니다.");
        System.out.println("\'이스라엘 사람들\'은 다윗에게 각자 들고 온 신비로운 선물을 건넸습니다.");
        System.out.println("하지만 다윗은 모두 들고 갈 수 없어 하나의 선물만을 선택해야 합니다. . .");
        System.out.println("[아무 키나 눌러 계속하기]");
        Scanner scan= new Scanner(System.in);
        select_string = scan.next();
        if (select_string != "0") {

        }else{

        }
        System.out.println();
        Story th1 = new Story();
        th1.msg_num=1;
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("(선물의 효과는 영구적이고 버릴 수 없습니다.)");
    /*    Thread th2 = new DataInput();
        Thread th3 = new CountDown();

        th2.start();
        th3.start();
        try {
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        gift_choose=scan.nextInt();
    }
    public void story3(My my){
        Story th1 = new Story();
        String gift=" ";
        if(gift_choose==1){
            gift="아드레날린";//에너지 최대치 4
            my.gift1=1;
            System.out.printf("다윗은 고민끝에 %s을(를) 선택하였습니다. 힘든 고민이었지만 \'골리앗\'을 상대하려면 이 선택이 최선이었습니다.", gift);
        }else if(gift_choose==2){
            gift="청동 갑옷";//시작 방어력 10 받고 시작
            my.gift2=2;
            System.out.printf("다윗은 고민끝에 %s을(를) 선택하였습니다. 힘든 고민이었지만 \'골리앗\'을 상대하려면 이 선택이 최선이었습니다.", gift);
        }else if(gift_choose==3){
            gift="붉은 스카프";//턴 끝날때마다 체력 5회복
            my.gift3=3;
            System.out.printf("다윗은 고민끝에 %s을(를) 선택하였습니다. 힘든 고민이었지만 \'골리앗\'을 상대하려면 이 선택이 최선이었습니다.", gift);
        }else if(gift_choose==0){
            System.out.printf("결국 고민하다가 적들은 바로 앞까지 도달했고 어쩔 수 없이 다윗은 빈 손으로 떠납니다.");
        }
        System.out.println("다윗은 해가 저무는 땅을 향해 다시 한번 발걸음을 옮겨갔습니다.");
        System.out.println();
        msg_num=0;
        th1.start();//System.out.println("그 신비한 땅 엘라에서 오래된 전투가 곧 펼쳐질 예정입니다. . . . .");
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n\n\n\n");

    }
    public void story4(My my){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("다윗은 힘겹게 골리앗의 하수인들을 모두 물리쳤습니다.");
        System.out.println("다시 한번 이스라엘 사람들이 다윗에게 선물을 가지고 왔습니다.");
        System.out.println("다윗은 골리앗이 오기 전에 빨리 선택을 하려고 합니다. 하지만, 저 멀리 있던 \'골리앗\'은 어느 새 코 앞까지 다가오고 말았습니다.");
        System.out.println("다윗은 이제 선택해야 합니다.");
        System.out.println();
        Story th1 = new Story();
        th1.msg_num=2;
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void story5(int x, My my){
        String select="";
        if(x==1)select="황금갑옷을 입기";
        if(x==2)select="빨간포션을 마시기";
        System.out.printf("다윗은 %s로 했습니다. 시간이 없기에 다윗이 할 수 있는 최선의 선택이었습니다.", select);
        System.out.println("이제 싸울 시간입니다.");
        System.out.println();
        Story th1 = new Story();
        msg_num=0;
        th1.start();//System.out.println("그 신비한 땅 엘라에서 오래된 전투가 곧 펼쳐질 예정입니다. . . . .");
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n\n\n\n");
    }

    public void ending(){
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        Story th1 = new Story();
        th1.msg_num=3;
        th1.start();
        try {
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n" +
                "              ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄               \n" +
                "             ▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░▌              \n" +
                "             ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌░▌     ▐░▌▐░█▀▀▀▀▀▀▀█░▌             \n" +
                "             ▐░▌          ▐░▌▐░▌    ▐░▌▐░▌       ▐░▌             \n" +
                " ▄▄▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌ ▐░▌   ▐░▌▐░▌       ▐░▌ ▄▄▄▄▄▄▄▄▄▄▄ \n" +
                "▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌\n" +
                " ▀▀▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░▌   ▐░▌ ▐░▌▐░▌       ▐░▌ ▀▀▀▀▀▀▀▀▀▀▀ \n" +
                "             ▐░▌          ▐░▌    ▐░▌▐░▌▐░▌       ▐░▌             \n" +
                "             ▐░█▄▄▄▄▄▄▄▄▄ ▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌             \n" +
                "             ▐░░░░░░░░░░░▌▐░▌      ▐░░▌▐░░░░░░░░░░▌              \n" +
                "              ▀▀▀▀▀▀▀▀▀▀▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀               \n" +
                "                                                                 \n");
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n\n\n\n\n");
    }
    class DataInput extends Thread{
        @Override
        public void run() {
            Scanner scan = new Scanner(System.in);
            gift_choose=scan.nextInt();
            System.out.println("입력한 값은 " + gift_choose + "입니다.");

            // 입력이 완료되면 inputCheck 변수를 true로 변경한다.
            Story.inputCheck = true;
        }
    }
    class CountDown extends Thread{
        @Override
        public void run() {

            for(int i = 10; i >= 1; i--) {
                // 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run()메서드를 종료시킨다.
                // 즉, 현재 쓰레드를 종료 시킨다.
                if(Story.inputCheck == true) {
                    story3(new My());
                    return ;
                }
                System.out.println(i);

                try {
                    Thread.sleep(1000);	// 1초 동안 잠시 멈춘다
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
            System.out.println("10초가 지났습니다. 고르지 못했습니다.");
            story3(new My());
            System.exit(0);	// 프로그램을 종료시키는 명령
        }
    }







}
