import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Bgm {
     Clip clip;
    String musicFilePath="";
    private Clip effectClip;
    public void bgm(int x) {
        // 음악 파일의 경로를 설정합니다.

        if (x == 1) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\MP_Battle-of-Boss.wav";//던전 브금
            playBgm(musicFilePath);
        } else if (x == 2) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\마을(Village)｜Original BGM｜일상적인, 판타지, 중세시대 느낌의 브금｜NCS BGM.wav";//상점 브금
            playBgm(musicFilePath);
        } else if (x == 3) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\MP_Left-Hook.wav";//공격 효과음
            playEffect(musicFilePath);
        } else if (x == 4) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\MP_롤-소환사-주문-방어막_-배리어.wav";//수비 효과음
            playEffect(musicFilePath);
        } else if (x == 5) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\050_철컥띵-_캐셔_.wav";//상점 구매후
            playEffect(musicFilePath);
        } else if (x == 6) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\MP_실패 임팩트 소리.wav";//game over
            playEffect(musicFilePath);
        } else if (x == 7) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\The Witcher 3： Wild Hunt Quest Complete Sound Effect (HD).wav";
            playEffect(musicFilePath);
        } else if (x == 8) {
            musicFilePath = "C:\\Users\\leech\\Downloads\\Realistic Hit Sound Effect.wav";
            playEffect(musicFilePath);
        } else if (x == 9) {//모르고스 bgm
            musicFilePath = "C:\\Users\\leech\\Downloads\\[MapleStory BGM] Zakum： Welcome to Hell.wav";
            playBgm(musicFilePath);
        }else if (x == 10) {//첫번째 선물 bgm
            musicFilePath = "C:\\Users\\leech\\Downloads\\[MapleStory BGM] Root Abyss： Yggdrasil Prayer (KMST 1.2.465).wav";
            playBgm(musicFilePath);
        }else if (x == 11) {//2던전 브금
            musicFilePath = "C:\\Users\\leech\\Downloads\\StudioEIM - Big Machine Mission [메이플스토리 OST ： Black Heaven].wav";
            playBgm(musicFilePath);
        }else if (x == 12) {//골리앗등장
            musicFilePath = "C:\\Users\\leech\\Downloads\\마비노기 영웅전OST- 죽음의 신 크로우 크루아흐[가사].wav";
            playBgm(musicFilePath);
        }else if (x == 13) {//엔딩
            musicFilePath = "C:\\Users\\leech\\Downloads\\Brave Heart.wav";
            playBgm(musicFilePath);
        }
    }
    public void playBgm(String musicFilePath) {
        try {
            stopBgm(); // 이전 배경음악 중지
            // 지정된 경로의 음악 파일을 File 객체로 생성합니다.
            File audioFile = new File(musicFilePath);

            // AudioSystem.getClip() 메서드로 Clip 객체를 가져옵니다.
            clip = AudioSystem.getClip();

            // Clip 객체를 열어서 음악 파일을 로딩합니다.
            clip.open(AudioSystem.getAudioInputStream(audioFile));
            // 음악을 재생합니다.
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                    clip.close(); // 재생이 끝났으면 클립을 닫아 리소스 해제
                }
            });
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            // 예외가 발생한 경우 예외 정보를 출력합니다.

            e.printStackTrace();
        }
    }
    public void playEffect(String effectFilePath) {
        try {
            File audioFile = new File(effectFilePath);
            effectClip = AudioSystem.getClip();
            effectClip.open(AudioSystem.getAudioInputStream(audioFile));

            effectClip.addLineListener(event -> {
                if (event.getType() == javax.sound.sampled.LineEvent.Type.STOP) {
                    effectClip.close(); // 효과음이 끝났으면 클립을 닫아 리소스 해제
                }
            });

            effectClip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
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