import java.io.*;
import java.util.*;

public class HexCC2RGBConverter {
    public static void main(String args[]) throws Exception {
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "  ##  ##   #####   ##  ##           ####     ####    ##        ####    #####            ####     ####    #####     #####   ");
        System.out.println(
                "  ##  ##  ##   ##   ####           ##  ##   ##  ##   ##       ##  ##   ##  ##          ##  ##   ##  ##   ##  ##   ##   ##  ");
        System.out.println(
                "  ######   ###       ##           ##       ##    ##  ##      ##    ##  #####          ##       ##    ##  ##   ##   ###     ");
        System.out.println(
                "  ##  ##  ##   ##   ####           ##  ##   ##  ##   ##       ##  ##   ##  ##          ##  ##   ##  ##   ##  ##   ##   ##  ");
        System.out.println(
                "  ##  ##   #####   ##  ##           ####     ####    ######    ####    ##  ##           ####     ####    #####     #####   ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "                                                          #####                                                            ");
        System.out.println(
                "                                                         ##   ##                                                           ");
        System.out.println(
                "                                                           ####                                                            ");
        System.out.println(
                "                                                          ##                                                               ");
        System.out.println(
                "                                                          ######                                                           ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "                                                 #####     ####   #####                                                    ");
        System.out.println(
                "                                                 ##  ##   ##      ##  ##                                                   ");
        System.out.println(
                "                                                 #####   ##  ###  #####                                                    ");
        System.out.println(
                "                                                 ##  ##   ##  ##  ##  ##                                                   ");
        System.out.println(
                "                                                 ##  ##    ####   #####                                                    ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "                         ####     ####    ##  ##  ##  ##   #####   #####   ######   #####   #####                          ");
        System.out.println(
                "                        ##  ##   ##  ##   ### ##  ##  ##  ##   ##  ##  ##    ##    ##   ##  ##  ##                         ");
        System.out.println(
                "                       ##       ##    ##  ## ###  ##  ##   ###     #####     ##     ###     #####                          ");
        System.out.println(
                "                        ##  ##   ##  ##   ##  ##   ####   ##   ##  ##  ##    ##    ##   ##  ##  ##                         ");
        System.out.println(
                "                         ####     ####    ##  ##    ##     #####   ##  ##    ##     #####   ##  ##                         ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println(
                "                                                                                                                           ");
        System.out.println("\nDescription:\nThis program changes the Hex Color Codes of a JSON file to RGB format.\n");
        Scanner scan = new Scanner(System.in);
        // stores the names of all the themes(55) in the concfg folder
        String presets[] = { "3024", "3024.light", "atelierdune", "atelierdune.light", "atelierforest",
                "atelierforest.light", "atelierheath", "atelierheath.light", "atelierlakeside", "atelierlakeside.light",
                "atelierseaside", "atelierseaside.light", "bespin", "bespin.light", "bluescreen", "bluescreen.light",
                "chalk", "chalk.light", "eighties", "eighties.light", "flat", "grayscale", "grayscale.light",
                "greenscreen", "greenscreen.light", "isotope", "isotope.light", "londontube", "londontube.light",
                "marrakesh", "marrakesh.light", "medium", "mocha", "mocha.light", "monokai", "monokai.light",
                "mountain", "ocean", "ocean.light", "oceanicnext", "paraiso", "paraiso.light", "powershell-defaults",
                "railscasts", "railscasts.light", "redscreen", "redscreen.light", "shapeshifter", "shapeshifter.light",
                "solarized-light", "solarized", "tomorrow", "tomorrow.light", "twilight", "twilight.light" };
        // stores all the required variables for this program
        Scanner read[] = new Scanner[presets.length];
        String data[][] = new String[presets.length][20];// data[file number][line in file]
        File presetFiles[] = new File[presets.length];
        File convertedPresetFiles[] = new File[presets.length];
        // stores the inputted files
        String user = System.getProperty("user.name");// gets the username using System.getProperty in Java
        for (int i = 0; i < presetFiles.length; i++) {
            presetFiles[i] = new File("C:/Users/" + user + "/Google Drive/Program Info/concfg/0.2016.05.08/presets/"
                    + presets[i] + ".json");
        }
        // stores the outputted files
        for (int i = 0; i < presetFiles.length; i++) {
            convertedPresetFiles[i] = new File("C:/Users/" + user
                    + "/Google Drive/Program Info/concfg/0.2016.05.08/presets/Converted/" + presets[i] + ".json");
        }
        // stores the themes in a scanner array to be read and used
        for (int i = 0; i < read.length; i++) {
            read[i] = new Scanner(presetFiles[i]);
        }
        // reads the input files into data
        for (int i = 0; i < data.length; i++) {
            int j = 0;
            while (read[i].hasNextLine()) {
                data[i][j] = read[i].nextLine() + "\n";
                j++;
            }
        }
        // changes the data into the right form
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length(); k++) {
                    // if hex colour code is found
                    if (data[i][j].charAt(k) == '#') {
                        String hexString = data[i][j].substring(k + 1, k + 7);
                        String rgbString = hex2rgb(hexString);
                        // replace the hex color code in the line with the rgb format of it
                        data[i][j] = data[i][j].substring(0, k) + rgbString + data[i][j].substring(k + 7);
                    }
                }
            }
        }
        // the file to be printed out
        FileOutputStream fos[] = new FileOutputStream[convertedPresetFiles.length];
        for (int i = 0; i < fos.length; i++) {
            fos[i] = new FileOutputStream(convertedPresetFiles[i]);
        }
        byte buffer[][][] = new byte[data.length][20][];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = data[i][j].getBytes("utf-8");
            }
        }
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                fos[i].write(buffer[i][j], 0, buffer[i][j].length);
            }
            fos[i].flush();
            fos[i].close();
        }
        System.out.println("Done!");
        scan.close();
    }

    // transforms a hex color code to an rgb format
    public static String hex2rgb(String hexString) {
        String rHex = hexString.substring(0, 2);
        String gHex = hexString.substring(2, 4);
        String bHex = hexString.substring(4, 6);
        int r = Integer.valueOf(rHex, 16);
        int g = Integer.valueOf(gHex, 16);
        int b = Integer.valueOf(bHex, 16);
        String result = "R:" + r + "\t G:" + g + "\t B:" + b;
        return result;
    }
}