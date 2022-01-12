import javax.swing.*;
import javax.sound.midi.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Utility {

    public static boolean answeredYes(String response) {
        response = response.toLowerCase();
        return response.equals("yes") || response.equals("y") || response.equals("yeah");
    }

    public static void sleepIt(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("A runtime error has occurred");
        }
    }

    public static void popup(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg,
                title, JOptionPane.PLAIN_MESSAGE);
    }

    public static ArrayList<Integer> shuffledIntList(int max) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            intList.add(i);
        }

        Collections.shuffle(intList);

        return intList;
    }

    public static ArrayList<Integer> orderedIntList(int max) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            intList.add(i);
        }

        return intList;
    }


    public static boolean arrayListChecker(ArrayList<Integer> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) != i)
                return false;


        }
        return true;

    }

    /**
     * @param instructions The text in the window
     * @param title        The text on top of the window
     * @param choices      An array of choices for user
     * @return The users choice out of the array of choices
     */
    public static String multiStringChoices(String instructions, String title, String[] choices) {
        return (String) JOptionPane.showInputDialog(
                null,
                instructions, //text in window
                title, //titlebar
                JOptionPane.PLAIN_MESSAGE, //the icon type
                null,
                choices, //array of options
                choices[0]); //the default
    }


    public static void playNote(int noteNum, int instrument, int delay) {

        Synthesizer midiSynth = null;
        try {
            midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();


            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[instrument]);


            mChannels[0].noteOn(noteNum, 100);

            mChannels[0].noteOff(noteNum);
            //Utility.sleepIt(250);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

    }

    public static double doubleCuttof(double value){
        double d = value;
        DecimalFormat df = new DecimalFormat("#.#");
        double p = Double.parseDouble(df.format(d));
        System.out.println(p);
        return p;
    }

    public static void main(String[] args) {
        doubleCuttof(123.12312312);
    }
}
