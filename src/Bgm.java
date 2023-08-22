import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Bgm {
     Clip clip;

    public void bgm(int x) {
        // 음악 파일의 경로를 설정합니다.
        String musicFilePath="";
        if(x==1) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\MP_Battle-of-Boss.wav";//던전 브금
        }else if(x==2){
            musicFilePath = "C:\\Users\\leech\\Downloads\\마을(Village)｜Original BGM｜일상적인, 판타지, 중세시대 느낌의 브금｜NCS BGM.wav";//상점 브금
        }else if(x==3){
            musicFilePath ="C:\\Users\\leech\\Downloads\\MP_Left-Hook.wav";//공격 효과음
        }else if(x==4){
            musicFilePath ="C:\\Users\\leech\\Downloads\\MP_롤-소환사-주문-방어막_-배리어.wav";//수비 효과음
        }else if(x==5){
            musicFilePath ="C:\\Users\\leech\\Downloads\\050_철컥띵-_캐셔_.wav";//상점 구매후
        }
        else if(x==6){
            musicFilePath ="C:\\Users\\leech\\Downloads\\MP_실패 임팩트 소리.wav";//game over
        }else if(x==7){
            musicFilePath ="C:\\Users\\leech\\Downloads\\The Witcher 3： Wild Hunt Quest Complete Sound Effect (HD).wav";//game clear
        }else if(x==8){
            musicFilePath ="C:\\Users\\leech\\Downloads\\Realistic Hit Sound Effect.wav";//enemy atk
        }

        try {
            // 지정된 경로의 음악 파일을 File 객체로 생성합니다.
            File audioFile = new File(musicFilePath);

            // AudioSystem.getClip() 메서드로 Clip 객체를 가져옵니다.
            clip = AudioSystem.getClip();

            // Clip 객체를 열어서 음악 파일을 로딩합니다.
            clip.open(AudioSystem.getAudioInputStream(audioFile));
            // 음악을 재생합니다.
            clip.start();

            // 음악 재생이 끝날 때까지 대기
            //Thread.sleep(clip.getMicrosecondLength() / 1000);

            // 음악 재생이 끝나면 Clip 객체를 닫아 메모리를 해제합니다.
           // clip.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            // 예외가 발생한 경우 예외 정보를 출력합니다.

            e.printStackTrace();
        }
    }
    public void stopBgm() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}