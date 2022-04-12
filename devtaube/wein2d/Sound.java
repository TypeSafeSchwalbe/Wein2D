/*
 * Copyright (c) 2022, DevTaube
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package devtaube.wein2d;

import kuusisto.tinysound.ModdedTinySound;
import kuusisto.tinysound.Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.net.URL;

public final class Sound
{

    static
    {
        ModdedTinySound.init();
    }

    private Music music;
    private boolean loop = false;

    public Sound(String filePath, FileOrigin fileOrigin)
    {
        try
        {
            AudioInputStream audioInputStream = null;
            switch(fileOrigin)
            {
                case WORKING_DIRECTORY:
                    audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
                    break;

                case CLASSPATH:
                    audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath));
                    break;

                case WEB_URL:
                    audioInputStream = AudioSystem.getAudioInputStream(new URL(filePath));
                    break;
            }
            music = ModdedTinySound.loadMusic(audioInputStream);
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    public void setVolume(double volume)
    {
        music.setVolume(volume);
    }

    public void play()
    {
        music.play(loop);
    }

    public void loop(boolean looping)
    {
        loop = looping;
    }

    public void stop()
    {
        music.stop();
    }

    public boolean isPlaying()
    {
        return music.playing();
    }

}
