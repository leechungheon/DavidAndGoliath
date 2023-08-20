import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Bgm {
    private Clip clip;

    public void bgm(int x) {
        // 음악 파일의 경로를 설정합니다.
        String musicFilePath="";
        if(x==1) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\Lux Aeterna.wav";//던전 브금
        }else if(x==2){
            musicFilePath = "C:\\Users\\leech\\Downloads\\마을(Village)｜Original BGM｜일상적인, 판타지, 중세시대 느낌의 브금｜NCS BGM.wav";//상점 브금
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