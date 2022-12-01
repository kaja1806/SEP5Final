/*
package Classes;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AssetReader {

    public static LinkedList<Assets> readAsset(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    private static List<String> readFile(File file) throws IOException{
        return Files.readAllLines(file.toPath());
    }

    private static LinkedList<Assets> parseContent(List<String> fileContent){
        LinkedList<Assets> assets = new LinkedList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            assets.add(parseBalances(lineComponents));
        }

        private static Assets parseBalances(List<String> components) {
            String name = components.get(0);
            double amount = Double.parseDouble(components.get(1));
            return new Assets (name, amount);
        }
    }
}
*/
