package cluedo.logic.intrics;

import static cluedo.tools.Tools.LOG;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class IntricsParser {

    public List<Intrics> parseFile(String fileName) {
        List<Intrics> intricCards = new LinkedList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmpList = line.split(";");
                if (correctRow(tmpList)) {
                    int amount = Integer.parseInt(tmpList[2]);
                    for (int i = 0; i < amount; ++i) {
                        intricCards.add(new Intrics(tmpList[0], IntricsType.valueOf(tmpList[1])));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            LOG.warning("File not found");
        } catch (IOException e) {
            LOG.warning("IO Error");
        }
        return intricCards;
    }

    public boolean correctRow(String[] splittedLine) {
        boolean correct = false;
        if (splittedLine.length >= 3) {
            try {
                Integer.parseInt(splittedLine[2]);
                correct = true;
            } catch (NumberFormatException ex) {
                LOG.log(Level.WARNING, "{0} in intrics file cannot be converted to int.", splittedLine[2]);
            }
        }
        return correct;
    }

}
