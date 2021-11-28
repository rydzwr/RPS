package com.kodilla.rps_game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.rps_game.RpsGameApplication.filePath;

public class HighScoreDatabase
{
    private ArrayList<HighScore> scores;

    public HighScoreDatabase()
    {
        this.scores = new ArrayList<HighScore>();
    }

    public void LoadFromFile(String filePath) throws IOException
    {
        File f = new File(filePath);
        if(!f.exists() || f.isDirectory())
            return;

        List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());

        scores = new ArrayList<HighScore>();

        for (String s : lines)
        {
            if (!s.isEmpty())
            {
                HighScore highScore = new HighScore(s);
                scores.add(highScore);
            }
        }
    }

    public void AddScore(HighScore newScore)
    {
        scores.add( newScore);
    }

    public HighScore[] GetScores(String playerName, int count)
    {
        HighScore[] list = scores.stream()
            .filter(highScore -> highScore.getPlayerName().equals(playerName))
            .sorted((o1, o2) -> HighScore.compareScores(o1, o2))
            .limit(count)
            .toArray(HighScore[]::new);

        return list;
    }

    public HighScore[] GetHighScores(int count)
    {
        HighScore[] bestScores = scores.stream()
                .sorted(((o1, o2) -> HighScore.compareScores(o1, o2)))
                .limit(count)
                .toArray(HighScore[]::new);

        return bestScores;
    }

    public void SaveToFile(String path) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, false));

        for (HighScore score : scores)
        {
            writer.write(score.writeToFile());
            writer.newLine();
        }

        writer.close();
    }
}
